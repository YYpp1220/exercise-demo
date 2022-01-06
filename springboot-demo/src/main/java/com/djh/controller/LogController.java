package com.djh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志控制器
 *
 * @author MyMrDiao
 * @date 2020/08/09
 */
@RestController
@Slf4j
public class LogController {

    @GetMapping("/log")
    public ResponseEntity<String> log(){
        log.debug("====debug====");
        log.info("====info====");
        log.warn("====warn====");
        log.error("====error====");
        return ResponseEntity.ok("log......");
    }
}
