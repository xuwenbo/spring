package com.webb.service.impl;

import com.webb.domain.UserT;
import com.webb.dao.UserTMapper;
import com.webb.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
//@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

    @Resource
    private UserTMapper userTMapper;

    public UserT getUserById(int userId) {
        return userTMapper.selectByPrimaryKey(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void add(UserT userT) {
        userTMapper.insert(userT);
        String str = null;
        if (str.equals("")) {
            int i = 0;
        }
    }

    public void addTest(UserT userT) {
        this.add(userT);
    }
}
