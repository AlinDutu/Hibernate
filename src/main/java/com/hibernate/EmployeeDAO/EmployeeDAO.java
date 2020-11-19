package com.hibernate.EmployeeDAO;



import com.hibernate.EmployeeEntity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

    public void add(Employee theEmployee);



}
