package com.udemy.mvc.hibernate.dao;

import com.udemy.mvc.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    void saveEmployee(Employee employee);

    Employee findById(int id);
}
