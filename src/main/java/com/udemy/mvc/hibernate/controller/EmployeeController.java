package com.udemy.mvc.hibernate.controller;

import com.udemy.mvc.hibernate.entity.Employee;
import com.udemy.mvc.hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "list";
    }
}
