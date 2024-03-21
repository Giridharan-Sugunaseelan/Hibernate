package org.example.config;

import org.example.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/ems");
            properties.put(Environment.USER,"root");
            properties.put(Environment.PASS, "Giridharan@31");
            properties.put(Environment.HBM2DDL_AUTO,"update");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
            properties.put(Environment.SHOW_SQL,"true");
            properties.put(Environment.FORMAT_SQL,"true");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Employee.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
