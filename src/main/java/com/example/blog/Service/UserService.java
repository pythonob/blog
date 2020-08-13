package com.example.blog.Service;

import com.example.blog.Common.Result;
import com.example.blog.DTO.UserDetailDTO;
import com.example.blog.DTO.UserRegisterDTO;
import com.example.blog.Model.UserModel;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    UserDetailDTO getUserDetail(Integer id);
    Result register(UserRegisterDTO userModel);
    Result login(UserModel userModel, HttpServletResponse response);
}
