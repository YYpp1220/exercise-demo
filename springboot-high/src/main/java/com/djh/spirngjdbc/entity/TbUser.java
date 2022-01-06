package com.djh.spirngjdbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2020-08-09 10:50:22
 */
@Data
@Table(name = "tb_user")
public class TbUser implements Serializable {
    private static final long serialVersionUID = 714315141149101126L;

    /**
     * 主键
     *  开启主键自增返回
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别，1男性，2女性
     */
    private Object sex;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 备注
     */
    private String note;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;
}