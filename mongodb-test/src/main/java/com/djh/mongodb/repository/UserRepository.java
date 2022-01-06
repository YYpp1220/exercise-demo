package com.djh.mongodb.repository;

import com.djh.mongodb.entity.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户存储库
 *
 * @author MyMrDiao
 * @date 2021/10/16
 */
public interface UserRepository extends MongoRepository<UserDO, Integer> {
}
