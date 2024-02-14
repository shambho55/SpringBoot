package com.enjoySpringBoot.crudcrmdemo.dao;

import com.enjoySpringBoot.crudcrmdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
