package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class UserController {
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功，去dashboard.html
            //防止表单重复提交，可以重定向到首页
            //return "dashboard";
            session.setAttribute("LoginUser",username);//设置一个user，用于检测用户是否登陆
            return "redirect:/main.html";
        } else {
            //登陆失败，留在此页
            map.put("msg", "用户名或者密码错误");
            return "login";
        }

    }
}
