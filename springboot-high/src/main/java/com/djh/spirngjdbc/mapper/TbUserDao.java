package com.djh.spirngjdbc.mapper;

import com.djh.spirngjdbc.entity.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-09 10:50:24
 */
public interface TbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbUser 实例对象
     * @return 对象列表
     */
    List<TbUser> queryAll(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}