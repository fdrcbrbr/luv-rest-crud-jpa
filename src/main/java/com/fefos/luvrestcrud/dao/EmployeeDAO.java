package com.fefos.luvrestcrud.dao;

import com.fefos.luvrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);
}

