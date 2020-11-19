package com.hibernate.EmployeeService;

import com.hibernate.EmployeeEntity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee theEmployee);

    public void deleteById(int theId);


}
