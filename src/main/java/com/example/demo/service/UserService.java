package com.example.demo.service;

import com.example.demo.dto.UserLoginRequest;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.entity.User;

public interface UserService {

    void register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);

}
