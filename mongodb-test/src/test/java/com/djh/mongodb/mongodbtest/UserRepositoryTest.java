package com.djh.mongodb.mongodbtest;

import com.djh.mongodb.MongodApplication;
import com.djh.mongodb.entity.UserDO;
import com.djh.mongodb.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@SpringBootTest(classes = MongodApplication.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    /**
     * 测试插入一条记录
     */
    @Test
    void testInsert() {
        // 创建 UserDO 对象
        UserDO user = new UserDO();
        // 这里先临时写死一个 ID 编号，后面演示自增 ID 的时候，在修改这块
        for (int i = 4; i < 20; i++) {
            user.setId(i);
            user.setUsername("diaojiahui" + i);
            user.setPassword("buzhidao" + i);
            user.setCreateTime(new Date());
            // 创建 Profile 对象
            UserDO.Profile profile = new UserDO.Profile();
            profile.setNickname("刁嘉辉" + i);
            profile.setGender(i);
            user.setProfile(profile);
            // 存储到 DB
            userRepository.insert(user);
        }
    }

    /**
     * 这里要注意，如果使用save方法来更新的话，必须是全量字段，否则其他字段会被覆盖掉
     */
    @Test
    void testUpdate() {
        // 查询用户
        Optional<UserDO> userResult = userRepository.findById(1);
        Assert.isTrue(userResult.isPresent(), "用户必须存在");
        // 更新
        UserDO userDO = userResult.get();
        userDO.setUsername("liMiss");
        userRepository.save(userDO);
    }

    /**
     * 根据id删除记录
     */
    @Test
    void testDelete() {
        userRepository.deleteById(4);
    }

    /**
     * 根据id查询用户
     */
    @Test
    void testSelectById() {
        Optional<UserDO> userResult = userRepository.findById(1);
        Assert.isTrue(userResult.isPresent(), "当前用户不存在");
        System.out.println(userResult.get());
    }

    /**
     * 根据 ID 编号数组，查询多条记录
     */
    @Test
    void testSelectByIds() {
        Iterable<UserDO> users = userRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }
}
