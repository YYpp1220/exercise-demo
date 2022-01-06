package com.djh.configuration;

import com.djh.entity.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户属性
 * @author MyMrDiao
 * @date 2020/08/09
 */
@ConfigurationProperties(prefix = "my")
@Component
@Data
public class UserProperties {
    private String host;
    private Integer port;
    private User user;
    private String[] address;
    private List<User> users = new ArrayList<>();
}
