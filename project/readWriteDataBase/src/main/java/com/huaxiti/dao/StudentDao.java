package com.huaxiti.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huaxiti.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-26 15:29:50
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

}

