package com.test.jiao.controller;


import com.test.jiao.bean.User;
import com.test.jiao.service.UserService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@EnableAutoConfiguration 注解作用：根据应用所声明的依赖来对 spring 框架进行自动配置；
@Controller//表示该类中的所有方法返回json模式  = @Controller+@ResponseBody；
public class LoginController<userLogin> {
    @Autowired
    private UserService userService;


//    @ApiOperation(value = "注册", notes = "填写用户名及密码注册账号")
//    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
//    public String registerUser(User user, Model model) {
//        return userService.registerUser(user);
//    }


    ///实现用户注册功能!
    @GetMapping(value = "/register")
    public String registerUser(){
        return "register";
    }
    @ApiOperation(value = "注册", notes = "填写用户名及密码注册账号")
    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    @ResponseBody
    public String registerUser(User user, Model model) {
        boolean check = userService.check(user);
        if (check) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("password", user.getPassword());
            return "用户名" + user.getUsername() + "注册成功!";
        } else {
            return "该用户名已被占用!";
        }
    }

    ///实现用户登录功能!
    @GetMapping(value = "/login")
    public String userLogin(){
        return "login";
    }

    @ApiOperation(value = "登录", notes = "根据用户名、密码登录")
    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    @ResponseBody
    public String userLogin(User user, Model model) {
        boolean verify = userService.verify(user);
        if (verify) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("password", user.getPassword());
            return "登录成功!";
        } else {
            return "用户名或密码不正确!";
        }
    }

    ///实现根据Id删除用户功能!
    @ApiOperation(value = "删除", notes = "根据Id删除用户")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(User user, Model model) {
        return userService.deleteUser(user);
    }


//    @ApiOperation(value = "查询", notes = "输入用户名查询用户信息")
//    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
//    public String selectUser(User user, Model model) {
//        return userService.selectUser(user);
//    }


}



