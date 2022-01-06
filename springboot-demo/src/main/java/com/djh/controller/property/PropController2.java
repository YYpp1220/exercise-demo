package com.djh.controller.property;

import com.djh.configuration.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 道具controller2
 *
 * @author MyMrDiao
 * @date 2020/08/09
 */
@RestController
public class PropController2 {
    @Autowired
    private UserProperties userProp;

    @GetMapping("/test3")
    public ResponseEntity<String> test3(){
        System.out.println("======test3======");
        System.out.println(userProp.getHost());
        System.out.println(userProp.getPort());
        System.out.println(userProp.getUser());
        System.out.println(Arrays.toString(userProp.getAddress()));
        System.out.println(userProp.getUsers());
        return ResponseEntity.ok("test3方法，访问成功！");
    }
}
