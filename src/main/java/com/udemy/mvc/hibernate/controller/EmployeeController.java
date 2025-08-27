package com.udemy.mvc.hibernate.controller;

import com.udemy.mvc.hibernate.dao.EmployeeDao;
import com.udemy.mvc.hibernate.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employeeList = employeeDao.findAll();
        model.addAttribute("employees", employeeList);
        return "list";
    }
}
