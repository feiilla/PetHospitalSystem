package com.example.pethospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pethospital.pojo.User;
import com.example.pethospital.service.UserService;
import com.example.pethospital.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getAll")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/getByPage")
    public List<User> getUserByPage(int page, int size){
        return userService.getUserByPage(page, size);
    }

    @RequestMapping("/me")
    public Object getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        JSONObject json = new JSONObject();
        User user = userService.login(userName, password);
        if(user != null){
            String token = JWTUtil.generateToken(user);
            json.put("code", 1);
            json.put("msg", "success");
            json.put("Authorization", token);
        }
        else{
            json.put("code", -1);
            json.put("msg", "fail");
        }
        return JSON.toJSONString(json);
    }

    @PostMapping("/register")
    public String register(@RequestParam String userName, @RequestParam String password, @RequestParam String gender, @RequestParam int age){
        JSONObject json = new JSONObject();
        int ok = userService.register(userName, password, gender, age);
        if(ok == 0) {
            json.put("code", -1);
            json.put("msg", "username exists");
        }
        else{
            json.put("code", 1);
            json.put("msg", "注册成功");
        }
        return JSON.toJSONString(json);
    }

    @PostMapping("/changePassword")
    public String modifyPassword(@RequestParam String originPassword, @RequestParam String newPassword){
        JSONObject json = new JSONObject();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.login(userName, originPassword);
        if(user != null){
            userService.updatePassword(userName, newPassword);
            json.put("code", 1);
            json.put("msg", "修改成功");
        }
        else{
            json.put("code", -1);
            json.put("msg", "wrong password!");
        }
        return JSON.toJSONString(json);
    }
}
