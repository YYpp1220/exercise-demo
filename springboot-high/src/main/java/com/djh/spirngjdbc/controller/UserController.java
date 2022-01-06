package com.djh.spirngjdbc.controller;

import com.djh.spirngjdbc.entity.TbUser;
import com.djh.spirngjdbc.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MyMrDiao
 * @date 2020/08/10
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 找到所有
     * @return {@link ResponseEntity<List<TbUser>>}
     */
    @GetMapping("findAll")
    public ResponseEntity<List<TbUser>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    /**
     * 保存
     * @param user 用户
     * @return {@link ResponseEntity<Boolean>}
     */
    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody TbUser user){
        try {
            userService.save(user);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(false);
    }
}
