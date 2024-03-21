package org.example.dao;

import org.example.config.SessionProvider;
import org.example.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void addEmployee(Employee employee) {
        Session session = SessionProvider.getSession();
        Employee employee1;
        try{
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        finally {
            session.close();
        }
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Session session = SessionProvider.getSession();
        Employee employee = null;
        try{
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        finally {
            session.close();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = SessionProvider.getSession();
        List<Employee> employees = null;
        try{
            session.beginTransaction();
            Query<Employee> query = session.createQuery("select e from Employee e", Employee.class);
            employees = query.getResultList();
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        finally {
            session.close();
        }
        return employees;
    }

    @Override
    public Employee updateEmployee(Integer id,Employee employee) {
        Session session = SessionProvider.getSession();
        Employee updatedEmployee = null;
        try{
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, id);
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmail(employee.getEmail());
            session.persist(employee1);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        finally {
            session.close();
        }
        return updatedEmployee;
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        Session session = SessionProvider.getSession();
        try{
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        finally {
            session.close();
        }
        return "Deleted Successfully";
    }
}
