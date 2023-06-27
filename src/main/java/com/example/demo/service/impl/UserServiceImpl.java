package com.example.demo.service.impl;

import com.example.demo.dto.UserLoginRequest;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(UserRegisterRequest userRegisterRequest) {

        User userCheck = userRepository.findByEmail(
                userRegisterRequest.getEmail()
        ).orElse(null);

        if (userCheck != null) { //檢查是否 eamil 已被註冊。
            log.warn("該 email：{} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 使用 MD5 Hash 生成密碼的雜湊值、設定密碼。
        String hashedPassWord = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassWord);

        User user = new User(); // 初始化。
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());

        userRepository.save(user); // Repository層 傳回來是 null 的話 →創建帳號。
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {

        User userCheck = userRepository.findByEmail(userLoginRequest.getEmail()).orElse(null);

        if (userCheck == null) { //檢查 eamil 是否已經存在。
            log.warn("該 email：{} 尚未註冊。", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 使用 MD5 生成密碼的雜湊值。
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        // 比較密碼。
        if (userCheck.getPassword().equals(hashedPassword)) {

            return userCheck;

        } else {
            log.warn("該 email：{} 的密碼不正確。", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
