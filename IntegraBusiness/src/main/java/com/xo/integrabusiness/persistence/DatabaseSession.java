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

    private Configuration configuration;
    private SessionFactory sessionFactory;
    private Session session;
    
    public DatabaseSession(){
        this.configuration = new Configuration();
        this.configuration.configure();
        this.buildSessionFactory();
    }
    
    public DatabaseSession(String resourceURL){
        this.configuration = new Configuration();
        this.configuration.configure(resourceURL);        
        this.buildSessionFactory();
    }
    
    private void buildSessionFactory(){
        if(this.sessionFactory==null){
             this.sessionFactory = this.configuration.buildSessionFactory();
        }
    }
  
    
    public Session establishSession(){
        if(this.session==null){
            this.session = sessionFactory.openSession();
        }
        return this.session;
    } 

    public void close() {
        this.session.flush();
        this.session.clear();
        this.session.close();
    }
   
    public void closeAll(){
        this.close();
        this.sessionFactory.close();
    }


    
 
}
