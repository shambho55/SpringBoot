package com.enjoySpringBoot.crudcrmdemo.dao;

import com.enjoySpringBoot.crudcrmdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define fields for entity manager

    private EntityManager entityManager;

    // set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);


        // execute query and get result list

        List<Employee> employees = theQuery.getResultList();

        // return the results

        return employees;

        //return List.of();
    }

    @Override
    public Employee findById(int theId) {

        // Get Employee
        Employee employee = entityManager.find(Employee.class,theId);

        // return employee
        return  employee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        Employee employee = entityManager.merge(theEmployee);

        // return employee
        return employee;
    }

    @Override
    public void deleteById(int theId) {

        // find employee by id
        Employee employee = entityManager.find(Employee.class,theId);

        // remove employee
        entityManager.remove(employee);
    }

}
