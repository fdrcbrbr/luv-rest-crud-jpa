package com.fefos.luvrestcrud.rest;

import com.fefos.luvrestcrud.entity.Employee;
import com.fefos.luvrestcrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee theEmployee = employeeService.findById(id);
        if(theEmployee == null){
            throw new RuntimeException("Employee id was not found");
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0L);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee theEmployee = employeeService.findById(id);
        if(theEmployee == null){
            throw new RuntimeException("Employee id was not found");
        }
        employeeService.delete(id);

        return "Deleted employee with ig: "+id;
    }
}
