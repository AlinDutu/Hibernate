package com.hibernate.RestController;

import com.hibernate.EmployeeService.EmployeeService;
import com.hibernate.EmployeeEntity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // === Campuri private ===
    private EmployeeService employeeService;

    // === Constructor de initializare ===
    @Autowired
    public StudentRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//-------------------------------------------------------------------------------------------------------------------------

    // === Returneaza o lista cu toti angajatii ===
    // === http://localhost:8080/api/employees/ ===
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }



    // === Returneaza un angajat cautat cu aj unui id ===
    // === http://localhost:8080/api/employees/{employeeId} ===
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }


    // === Primeste datele unui nou angajat sub forma JSON si il creeaza in baza de date ===
    // === http://localhost:8080/api/employees ===
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }


    // === Face un update al unui angajat existent ===
    // === http://localhost:8080/api/employees ===
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeService.save(theEmployee);

        return theEmployee;
    }

    // === Sterge un Angajat cu ajutorul unui Id
    // === http://localhost:8080/api/employees/{employeeId} ===
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
