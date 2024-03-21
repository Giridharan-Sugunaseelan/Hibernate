package org.example.dao;

import org.example.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Integer id, Employee employee);
    String deleteEmployeeById(Integer id);

}
