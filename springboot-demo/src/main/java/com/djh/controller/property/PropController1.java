package com.djh.controller.property;

import com.djh.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 支持管理员一
 * @author MyMrDiao
 * @date 2020/08/09
 */
@RestController
@ConfigurationProperties(prefix = "my2")
public class PropController1 {
    /**
     * 宿主
     */
    @Value("${my.host}")
    private String host;

    /**
     * 港口
     */
    @Value("${my.port}")
    private Integer port;

    /**
     * 用户
     */
    private User user;

    /**
     * 地址
     */
    private String[] address;

    /**
     * 用户集合
     */
    private List<User> users;

    /**
     * test2
     * @return {@link String}
     */
    @GetMapping("/test2")
    public String test2(){
        System.out.println("======test2=======");
        System.out.println("host = " + host);
        System.out.println("port = " + port);
        System.out.println("user = " + user);
        System.out.println("address = " + Arrays.toString(address));
        System.out.println("users = " + users);
        return "test2方法，访问成功！";
    }

    /**
     * 获取用户
     * @return {@link User}
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}