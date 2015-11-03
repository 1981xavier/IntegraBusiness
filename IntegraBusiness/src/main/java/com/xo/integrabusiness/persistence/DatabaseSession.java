package com.xo.integrabusiness.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author admin
 */
class DatabaseSession {

    
    public DatabaseSession(){
    
    }
    
  
    
    public Session establishSession() {
        Configuration configuration= new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    public Session establishSession(String resourceURL) {
        Configuration configuration= new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
    
 
}
