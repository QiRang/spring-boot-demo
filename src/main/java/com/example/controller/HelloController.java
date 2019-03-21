package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> showHelloWorld(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "HelloWorld!");
        return map;
    }
    //classpath:/templates/success.html
    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("Hello","你好！");
        return "success";
    }
    /**
     * 这个函数会从templates里面找相关的页面
     * 这样给每个controller加方法，太麻烦，可以直接自己配置一下
     */
//    @RequestMapping({"/","/index.html"})
//    public String Index(){
//        return "index";
//    }
}
