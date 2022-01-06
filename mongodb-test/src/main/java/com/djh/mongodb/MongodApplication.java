package com.djh.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;

/**
 * mongod应用程序
 *
 * @author MyMrDiao
 * @date 2021/10/12
 */
@SpringBootApplication(exclude = {ElasticsearchDataAutoConfiguration.class})
public class MongodApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodApplication.class, args);
    }
}
