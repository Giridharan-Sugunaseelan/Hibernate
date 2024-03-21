package org.example.service;
import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.entities.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void addEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeDao.getAllEmployees();
    }

    @Override
    public Employee updateEmployee(Integer id ,Employee employee) {
        return this.employeeDao.updateEmployee(id, employee);
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        return this.employeeDao.deleteEmployeeById(id);
    }
}
