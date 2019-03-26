package com.example.controller;

import com.example.entities.Department;
import com.example.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //返回json数据，不返回页面
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;
    @GetMapping("/dept/{id}") //要处理的映射，以占位符的方式取出id
    public Department getDepartment(@PathVariable("id") int id){
        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
