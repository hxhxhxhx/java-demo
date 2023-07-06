package com.huaxiti.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaxiti.dao.UserLoginDao;
import com.huaxiti.entity.UserLogin;
import com.huaxiti.service.UserLoginService;
import org.springframework.stereotype.Service;

/**
 * (UserLogin)表服务实现类
 *
 * @author makejava
 * @since 2023-07-05 10:37:35
 */
@Service("userLoginService")
public class UserLoginServiceImpl extends ServiceImpl<UserLoginDao, UserLogin> implements UserLoginService {

}

