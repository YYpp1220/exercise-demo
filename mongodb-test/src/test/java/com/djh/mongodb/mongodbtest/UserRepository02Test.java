package com.djh.mongodb.mongodbtest;

import com.djh.mongodb.entity.UserDO;
import com.djh.mongodb.repository.UserRepository02;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户repository02测试
 *
 * @author MyMrDiao
 * @date 2021/10/24
 */
@SpringBootTest
class UserRepository02Test {
    @Autowired
    private UserRepository02 userRepository02;

    /**
     * 根据名字获得一条记录
     */
    @Test
    void findByUsername() {
        UserDO user = userRepository02.findByUsername("liMiss");
        System.out.println(user);
    }
}
