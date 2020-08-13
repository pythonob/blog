package com.example.blog.Model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserModel {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String email;
    private String avatar;
    private String dateJoined;

}
