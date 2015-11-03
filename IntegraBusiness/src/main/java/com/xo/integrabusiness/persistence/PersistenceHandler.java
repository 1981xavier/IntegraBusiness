/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xo.integrabusiness.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
class PersistenceHandler {

    private boolean isSuccessful;
    private PersistenceClient persistenceClient;
    private DatabaseSession databaseSession;
    private String messages;
    
    private PersistenceHandler(PersistenceClient persistenceClient) {
        this.persistenceClient=persistenceClient;
        this.databaseSession= this.persistenceClient.getDatabaseSession();
        this.messages="";
    }   
    
    
    public static PersistenceHandler usePersistenceClient(PersistenceClient persistenceClient){
        return new PersistenceHandler(persistenceClient);
    }
    
    public void executeProcess() {
        this.isSuccessful= false;
        Session session=this.databaseSession.getSession();
        Transaction transaction=session.beginTransaction();        
        try{            
            this.persistenceClient.executeProcess();
            transaction.commit();
            this.isSuccessful=true;
        }
        catch(Exception exception){
            transaction.rollback();
            this.messages = exception.getMessage();
        }
        finally{
            this.databaseSession.closeSession();
        }
    }
    
    public boolean isSuccessful(){
        return this.isSuccessful;
    }
    public String getMessages(){
        return this.messages;
    }    
}
