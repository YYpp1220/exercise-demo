package com.djh.spirngjdbc.service.impl;

import com.djh.spirngjdbc.entity.TbUser;
import com.djh.spirngjdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author MyMrDiao
 * @date 2020/08/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * @return {@link List<TbUser>}
     */
    public List<TbUser> findAll(){
        return userMapper.selectAll();
    }

    /**
     * 保存
     * @param user 用户
     */
    public void save(TbUser user) {
        try {
            user.setUpdated(new Date());
            user.setCreated(new Date());
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
