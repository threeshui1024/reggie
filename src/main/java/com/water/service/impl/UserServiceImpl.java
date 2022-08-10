package com.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.water.entity.User;
import com.water.mapper.UserMapper;
import com.water.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
