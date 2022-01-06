package com.elasticsearchtest.elasticsearch;

import com.elasticsearchtest.elasticsearch.pojo.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lenovo
 */
public class Demo1 {
    /** 创建索引库 */
    @Test
    public void test1() throws Exception{
        // 1. 创建Settings配置信息对象(主要配置集群名称)
        // 参数一: 集群key (固定不变)
        // 参数二：集群环境名称,默认的ES的环境集群名称为 "elasticsearch"
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();

        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        // 参数一：主机
        // 参数二：端口
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"), 9300));


        // 3. 创建索引库(index)
        // 获取索引库管理客户端执行创建索引库，并执行请求
        transportClient.admin().indices().prepareCreate("blog1").get();
        // 4. 释放资源
        transportClient.close();
    }

    /** 添加文档: 第一种方式(XContentBuilder) */
    @Test
    public void test2() throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new
                TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        // 3. 创建内容构建对象
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("id", 1)
                .field("title", "elasticsearch搜索服务")
                .field("content","ElasticSearch是一个基于Lucene的搜索服务器。它提供了一个分布式多用户能力的全文搜索引擎。")
                .endObject();

        // 4. 执行索引库、类型、文档
        transportClient.prepareIndex("blog2","article", "1")
                .setSource(builder).get(); // 执行请求
        // 5. 释放资源
        transportClient.close();
    }

    /** 创建文档: 第二种方式(使用Map集合) */
    @Test
    public void test3() throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"), 9300));

        // 3. 定义Map集合封装文档
        Map<String, Object> map = new HashMap();
        map.put("id", 2);
        map.put("title", "dubbo分布式服务框架");
        map.put("content", "dubbo阿里巴巴开源的高性能的RPC框架。");

        // 4. 添加文档
        transportClient.prepareIndex("blog2","article", "2")
                .setSource(map).get();
        // 5. 释放资源
        transportClient.close();
    }

    /** 创建文档: 第三种方式(使用POJO) */
    @Test
    public void test4() throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"), 9300));

        // 3. 创建实体对象
        Article article = new Article();
        article.setId(3);
        article.setTitle("lucene全文检索框架");
        article.setContent("lucene是apache组织开源的全文检索框架。");

        // 4. 把article转化成json字符串
        String jsonStr = new ObjectMapper().writeValueAsString(article);

        // 5. 添加文档
        transportClient.prepareIndex("blog2","article", "3")
                .setSource(jsonStr, XContentType.JSON).get();
        // 6. 释放资源
        transportClient.close();
    }

    /** 批量添加文档 */
    @Test
    public void test5()throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"), 9300));
        // 3. 创建批量请求构建对象
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        long begin = System.currentTimeMillis();
        // 4. 循环创建文档，添加索引请求对象
        for (long i = 1; i <= 1000; i++){
            Article article = new Article();
            article.setId(i);
            article.setTitle("dubbo分布式服务框架" + i);
            article.setContent("dubbo阿里巴巴开源的高性能的RPC框架" + i);
            // 4.1 创建索引请求对象
            IndexRequest indexRequest = new IndexRequest("blog1","article", i + "")
                    .source(new ObjectMapper().writeValueAsString(article),
                            XContentType.JSON);
            // 4.2 添加索引请求对象
            bulkRequestBuilder.add(indexRequest);
        }
        // 5. 提交请求
        bulkRequestBuilder.get();
        long end = System.currentTimeMillis();
        System.out.println("毫秒数：" + (end - begin));
        // 6. 释放资源
        transportClient.close();
    }

    /** 修改文档 */
    @Test
    public void test6() throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"), 9300));

        // 3. 创建实体对象
        Article article = new Article();
        article.setId(1);
        article.setTitle("lucene全文检索框架");
        article.setContent("lucene是apache组织开源的全文检索框架。");
        // 4. 把article转化成json字符串
        String jsonStr = new ObjectMapper().writeValueAsString(article);

        // 5. 修改文档
        transportClient.prepareUpdate("blog1","article", "1")
                .setDoc(jsonStr, XContentType.JSON).get();
        // 6. 释放资源
        transportClient.close();
    }

    /** 删除文档 */
    @Test
    public void test7() throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"), 9300));

        // 3. 删除文档
        transportClient.prepareDelete("blog1", "article", "1").get();
        // 4. 释放资源
        transportClient.close();
    }

    /** 删除索引库 */
    @Test
    public void test8() throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"), 9300));

        // 3. 删除索引库
        transportClient.admin().indices().prepareDelete("blog1").get();
        // 4. 释放资源
        transportClient.close();
    }

    /** 创建索引库映射 */
    @Test
    public void test9()throws Exception{
        // 1. 创建Settings配置信息对象
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        // 2. 创建ES传输客户端
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        // 2.1 添加传输地址对象
        transportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("127.0.0.1"),9300));

        // 3. 创建索引库管理客户端
        IndicesAdminClient indices = transportClient.admin().indices();
        // 3.1 创建空的索引库
        indices.prepareCreate("blog2").get();

        // 4. 创建映射信息json格式字符串，使用XContentBuilder
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject()
                .startObject("article")
                .startObject("properties");

        builder.startObject("id")
                .field("type", "long")
                .field("store", true)
                .endObject();

        builder.startObject("title")
                .field("type", "text")
                .field("store", true)
                .field("analyzer", "ik_smart")
                .endObject();

        builder.startObject("content")
                .field("type", "text")
                .field("store", true)
                .field("analyzer","ik_smart")
                .endObject();

        builder.endObject();
        builder.endObject();
        builder.endObject();

        // 5. 创建映射请求对象，封装请求信息
        PutMappingRequest mappingRequest = new PutMappingRequest("blog2")
                .type("article").source(builder);
        // 6. 索引库管理客户端，为索引库添加映射
        indices.putMapping(mappingRequest).get();
        // 7. 释放资源
        transportClient.close();
    }


}
