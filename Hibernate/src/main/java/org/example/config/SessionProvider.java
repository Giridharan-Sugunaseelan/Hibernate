package org.example.config;

import org.hibernate.Session;

public class SessionProvider {
    public static Session getSession(){
        return HibernateConfiguration.getSessionFactory().openSession();
    }
}
