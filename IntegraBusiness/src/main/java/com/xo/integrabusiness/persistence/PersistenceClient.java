/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xo.integrabusiness.persistence;

import org.hibernate.Session;

/**
 *
 * @author admin
 */
abstract class PersistenceClient {
    protected DatabaseSession databaseSession;
    
    public final DatabaseSession getDatabaseSession(){
        return this.databaseSession;
    }
    
    public abstract void executeProcess();
    
}
