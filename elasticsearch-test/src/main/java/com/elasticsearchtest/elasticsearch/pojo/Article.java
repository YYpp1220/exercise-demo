package com.elasticsearchtest.elasticsearch.pojo;

import lombok.Data;

/**
 * @author Lenovo
 */
@Data
public class Article {
    private long id;
    private String title;
    private String content;
}
