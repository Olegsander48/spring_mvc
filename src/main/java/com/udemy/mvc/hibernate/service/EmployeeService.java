package com.udemy.mvc.hibernate.service;

import com.udemy.mvc.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void saveEmployee(Employee employee);
}
