package com.webb.service;

import com.webb.domain.UserT;

public interface IUserService {

    UserT getUserById(int userId);

    void add(UserT userT);

    void addTest(UserT userT);
}
