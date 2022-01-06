package com.djh.mongodb.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * 蒙戈dbconfig
 *
 * @author MyMrDiao
 * @date 2021/10/12
 */
@Configuration
public class MongoDBConfig {
    /**
     * 目的，就是为了移除 _class field 。参考博客 https://blog.csdn.net/bigtree_3721/article/details/82787411
     *
     * @param factory     工厂
     * @param context     上下文
     * @param beanFactory bean工厂
     * @return {@link MappingMongoConverter}
     */
    @Bean
    public MappingMongoConverter mappingMongoConverterVice(MongoDatabaseFactory factory,
                                                           MongoMappingContext context,
                                                           BeanFactory beanFactory) {
        // 创建 DbRefResolver 对象
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        // 创建 MappingMongoConverter 对象
        MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, context);
        try {
            // 设置 conversions 属性
            mongoConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        } catch (BeansException e) {
            e.printStackTrace();
        }
        // 设置 typeMapper 属性，从而移除 _class field 。
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mongoConverter;
    }
}
