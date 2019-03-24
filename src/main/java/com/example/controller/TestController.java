package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 需要注意的是，建表操作是每启动一次项目，就执行一次
 */
@Controller
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody  //用于写数据
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM department");
        System.out.println(list.get(0));
        return list.get(0);
    }
}
