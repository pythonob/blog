package com.example.blog.DTO;

import com.example.blog.Model.UserModel;
import lombok.Data;

@Data
public class UserRegisterDTO {
    private String username;
    private String password;
}
