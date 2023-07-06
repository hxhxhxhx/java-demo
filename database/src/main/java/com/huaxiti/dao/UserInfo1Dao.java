package com.huaxiti.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huaxiti.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-03 23:03:33
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {

}

