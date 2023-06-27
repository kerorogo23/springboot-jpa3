package com.example.demo.controller;

import com.example.demo.dto.UserLoginRequest;
import com.example.demo.entity.User;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users/register")
    public ResponseEntity<Void> userRegister(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {

        userService.register(userRegisterRequest);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/users/login")
    public  ResponseEntity<User> userLogin(@RequestBody @Valid UserLoginRequest userLoginRequest) {

        User user = userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
