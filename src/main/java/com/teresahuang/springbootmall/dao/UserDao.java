package com.teresahuang.springbootmall.dao;

import com.teresahuang.springbootmall.dto.UserRegisterRequest;
import com.teresahuang.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
}
