package com.teresahuang.springbootmall.service;

import com.teresahuang.springbootmall.dto.UserLoginRequest;
import com.teresahuang.springbootmall.dto.UserRegisterRequest;
import com.teresahuang.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
    User login(UserLoginRequest userLoginRequest);
}
