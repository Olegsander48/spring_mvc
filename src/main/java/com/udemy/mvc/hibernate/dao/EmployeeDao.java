package com.udemy.mvc.hibernate.dao;

import com.udemy.mvc.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
}
