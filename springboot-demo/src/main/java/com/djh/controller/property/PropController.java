package com.djh.controller.property;

import com.djh.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 支持控制器
 * @author MyMrDiao
 * @date 2020/08/08
 */
@RestController
@ConfigurationProperties(prefix = "my1")
public class PropController {
    private String host;
    private int port;
    private User user;
    private String[] address;
    private List<User> users;

    @GetMapping("/test1")
    public String test1(){
        System.out.println("======test1=======");
        System.out.println("host = " + host);
        System.out.println("port = " + port);
        System.out.println("user = " + user);
        System.out.println("address = " + Arrays.toString(address));
        System.out.println("users = " + users);
        return "test1方法，访问成功！";
    }

    /** 注入的属性必须提供setter方法 */
    public void setHost(String host) {
        this.host = host;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setAddress(String[] address) {
        this.address = address;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
