package com.example.bookmyshowapplication.controller;

import com.example.bookmyshowapplication.dtos.*;
import com.example.bookmyshowapplication.models.User;
import com.example.bookmyshowapplication.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        return userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
    }

    @PostMapping("/signin")
    public boolean signIn(@RequestBody SignUpRequestDto signUpRequestDto) {
        return userService.signIn(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
    }

}
