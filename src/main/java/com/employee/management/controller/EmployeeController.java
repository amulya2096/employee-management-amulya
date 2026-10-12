package com.employee.management.controller;

import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    // 1. GET ALL -> http://localhost:8080/employees returns []
    @GetMapping("/employees")
    public List<Employee> getAll() {
        return repo.findAll();
    }

    // 2. GET BY ID -> http://localhost:8080/employees/1
    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // 3. CREATE -> POST http://localhost:8080/employees
    @PostMapping("/employees")
    public Employee create(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    // 4. UPDATE -> PUT http://localhost:8080/employees/1
    @PutMapping("/employees/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        emp.setId(id);
        return repo.save(emp);
    }

    // 5. DELETE -> DELETE http://localhost:8080/employees/1
    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted employee " + id;
    }
}