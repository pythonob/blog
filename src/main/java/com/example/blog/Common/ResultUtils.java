package com.example.blog.Common;

public class ResultUtils {

    public Result success(Object object) {
        Result result = new Result();
        result.setCode("0");
        result.setMessage("ok");
        result.setData(object);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode("0");
        result.setMessage("ok");
        result.setData(null);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setCode("1001");
        result.setMessage("登陆失败!");
        result.setData(null);
        return result;
    }

}
