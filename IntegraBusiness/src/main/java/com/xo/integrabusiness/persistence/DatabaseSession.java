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
  
    
    private void establishSession(){
        if(this.session==null){
            this.session = sessionFactory.openSession();
        }
        
    } 
    
    
    public Session getSession(){
        this.establishSession();
        return this.session;
    }
    

    public void closeSession() {
        if(this.session.isOpen())
        {
            this.session.flush();
            this.session.clear();
            this.session.close();
        }
    }
   
    public void closeAllSessionResources(){
        this.closeSession();
        if(!this.sessionFactory.isClosed())
        {
            this.sessionFactory.close();
        }
    }


    
 
}
