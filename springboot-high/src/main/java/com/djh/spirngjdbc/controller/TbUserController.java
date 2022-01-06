package com.djh.spirngjdbc.controller;

import com.djh.spirngjdbc.entity.TbUser;
import com.djh.spirngjdbc.service.impl.TbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbUser)表控制层
 *
 * @author makejava
 * @since 2020-08-09 10:50:27
 */
@RestController
@RequestMapping("tbUser")
public class TbUserController {
    /**
     * 服务对象
     */
    @Autowired
    private TbUserServiceImpl tbUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbUser selectOne(Long id) {
        return this.tbUserService.queryById(id);
    }

    /**
     * 查询页面
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link ResponseEntity<List<TbUser>>}
     */
    @GetMapping("queryPage")
    public ResponseEntity<List<TbUser>> queryPage(@RequestParam(name = "pageNum", defaultValue = "0") Long pageNum,
                                                  @RequestParam(name = "pageSize", defaultValue = "10") Long pageSize){
        return ResponseEntity.ok(tbUserService.queryAllByLimit(pageNum, pageSize));
    }
}