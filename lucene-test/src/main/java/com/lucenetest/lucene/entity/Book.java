package com.lucenetest.lucene.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2020-07-18 18:03:18
 */
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 926040968495263971L;

    private Integer id;

    private String bookname;

    private Object price;

    private String pic;

    private String bookdesc;
}