package com.huaxiti.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaxiti.dao.UserInfoDao;
import com.huaxiti.entity.UserInfo;
import com.huaxiti.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * (UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-07-03 23:03:39
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

}

