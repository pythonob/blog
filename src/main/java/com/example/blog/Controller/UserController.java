package com.example.blog.Controller;

import com.example.blog.Common.Result;
import com.example.blog.DTO.UserRegisterDTO;
import com.example.blog.Model.UserModel;
import com.example.blog.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(UserModel userModel, HttpServletResponse response) {
        return userService.login(userModel, response);
    }

    @PostMapping("/register")
    public Result register(UserRegisterDTO userRegisterDTO) {
        return userService.register(userRegisterDTO);
    }
}
