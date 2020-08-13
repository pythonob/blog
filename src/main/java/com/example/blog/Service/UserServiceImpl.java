package com.example.blog.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blog.Common.Result;
import com.example.blog.Common.ResultUtils;
import com.example.blog.DTO.UserDetailDTO;
import com.example.blog.DTO.UserRegisterDTO;
import com.example.blog.mapper.UserMapper;
import com.example.blog.Model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserDetailDTO getUserDetail(Integer id) {

        UserModel userModel = userMapper.selectById(id);
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        BeanUtils.copyProperties(userModel, userDetailDTO);
        return userDetailDTO;

    }

    @Override
    public Result register(UserRegisterDTO userRegisterDTO) {
        String password = userRegisterDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            log.info("111");
            return ResultUtils.fail();
        }
        String hashed_password = DigestUtils.md5DigestAsHex(password.getBytes());
        userRegisterDTO.setPassword(hashed_password);

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRegisterDTO, userModel);
        int result = userMapper.insert(userModel);
        return result > 0 ? ResultUtils.success() : ResultUtils.fail();
    }

    public Result login(UserModel userModel, HttpServletResponse response) {

        String username = userModel.getUsername();
        String password = userModel.getPassword();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResultUtils.fail();
        }

        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<UserModel>();
        queryWrapper.eq("username", username);
        UserModel userModel1 = userMapper.selectOne(queryWrapper);
        if (userModel1.getPassword() == DigestUtils.md5DigestAsHex(password.getBytes())) {
            return ResultUtils.success();
        } else {
            return ResultUtils.fail();
        }

    }
}
