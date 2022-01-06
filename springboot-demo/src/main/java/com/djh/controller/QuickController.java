package com.djh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 快速控制器
 * @author MyMrDiao
 * @date 2020/08/08
 */
@RestController
public class QuickController {
    @GetMapping("/quick")
    public String quick(){
        return "SpringBoot 从入门到精通！！";
    }
}
