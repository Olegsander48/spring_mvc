package com.udemy.mvc.hibernate.service;

import com.udemy.mvc.hibernate.dao.EmployeeDao;
import com.udemy.mvc.hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
