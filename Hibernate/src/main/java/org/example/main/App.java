package org.example.main;

import org.example.config.HibernateConfiguration;
import org.example.config.SessionProvider;
import org.example.entities.Employee;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private EmployeeService employeeService;

    {
        this.employeeService = new EmployeeServiceImpl();
    }


    public static void main( String[] args ) {
        App app = new App();
//        Employee employee = new Employee("Kumar", "Manglam", "kumarManglam@gmail.com");
//        app.employeeService.addEmployee(employee);
//        Employee employee1 = new Employee("Gayathri", "Kotla", "kotla.gayathri@gmail.com");
//        app.employeeService.updateEmployee(2,employee1);
        System.out.println(app.employeeService.deleteEmployeeById(3));

    }
}
