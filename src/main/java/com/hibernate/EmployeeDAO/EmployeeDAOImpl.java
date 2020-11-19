package com.hibernate.EmployeeDAO;

import com.hibernate.EmployeeEntity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session curentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = curentSession.get(Employee.class, id);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery(
                "delete from Employee where id=:employeeId");
              theQuery.setParameter("employeeId", theId);
              theQuery.executeUpdate();
    }

    @Override
    public void add(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(theEmployee);
    }

}
