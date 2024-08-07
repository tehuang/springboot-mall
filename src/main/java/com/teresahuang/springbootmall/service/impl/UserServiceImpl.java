package com.teresahuang.springbootmall.service.impl;

import com.teresahuang.springbootmall.dao.UserDao;
import com.teresahuang.springbootmall.dto.UserRegisterRequest;
import com.teresahuang.springbootmall.model.User;
import com.teresahuang.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
