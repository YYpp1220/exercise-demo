package com.djh.mongodb.repository;

import com.djh.mongodb.entity.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户repository02
 *
 * @author MyMrDiao
 * @date 2021/10/24
 */
public interface UserRepository02 extends MongoRepository<UserDO, Integer> {

    /**
     * 找到的用户名
     *
     * @param username 用户名
     * @return {@link UserDO}
     */
    UserDO findByUsername(String username);

    /**
     * 找到的用户名一样
     *
     * @param username 用户名
     * @param pageable 可分页
     * @return {@link Page<UserDO>}
     */
    Page<UserDO> findByUsernameLike(String username, Pageable pageable);
}
