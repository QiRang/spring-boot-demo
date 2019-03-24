package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.entities.Department;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 *
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired//这个一定要加，没加的时候，departments为null，加了才能执行方法
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){ //查询员工列表
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);//将employees放在请求域中共享
        return "list";//Thymeleaf会自动拼串   classpath:/template/XXX.html
    }
    @GetMapping("/emp")//映射客户端发起的请求
    public String toAddPage(Model model){//去添加员工页面
        //先查出所有的部门，显示出来供员工选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }
    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        //SpringMVC自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名字与JavaBean入参的对象里面的属性名是一样的
        //员工添加功能
        System.out.println("保存的员工信息：" + employee);
        employeeDao.save(employee);
        //forward:转发到一个地址
        //redirect:重定向到一个地址  /代表当前项目路径
        //为了防止去到模板引擎的页面
        return "redirect:/emps";
    }
}
