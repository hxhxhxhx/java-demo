package com.huaxiti.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huaxiti.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserLogin)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-05 10:37:34
 */
@Mapper
public interface UserLoginDao extends BaseMapper<UserLogin> {

}

