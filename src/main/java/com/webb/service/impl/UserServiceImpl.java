package com.webb.service.impl;

import com.webb.dao.UserT;
import com.webb.dao.UserTMapper;
import com.webb.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserTMapper userTMapper;

    public UserT getUserById(int userId) {
        return userTMapper.selectByPrimaryKey(userId);
    }
}
