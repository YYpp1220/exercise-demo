package com.lucenetest.lucene.dao;
import com.lucenetest.lucene.entity.Book;

import java.util.List;

/** 图书数据访问接口
 * @author Lenovo
 */
public interface BookDao {
    /**
     * 查询全部图书
     * @return 返回所有书籍
     */
    List<Book> findAll();
}