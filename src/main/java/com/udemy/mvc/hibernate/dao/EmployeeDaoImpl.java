package com.udemy.mvc.hibernate.dao;

import com.udemy.mvc.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class).list();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee findById(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

}
