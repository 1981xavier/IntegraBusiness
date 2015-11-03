/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xo.integrabusiness.persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class PersistenceHandlerTest {
    
    private DatabaseSession databaseSession ; 
    private PersistenceClient persistenceClient;
    private PersistenceHandler persistenceHandler;
    private boolean fail=false;
    
    public PersistenceHandlerTest() {
        this.databaseSession = DatabaseSession.StartWithDefaultConfiguration(); 
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
   
    
    @Test
    public void executeProcessWithSuccessTransaction(){        
        this.fail=false;
        this.persistenceClient = new SamplePersistenceClient(this.databaseSession,this.fail);                 
        this.persistenceHandler = new PersistenceHandler(this.persistenceClient);
        persistenceHandler.executeProcess();
        assertTrue(this.persistenceHandler.isSuccessful());
    }    
    @Test
    public void executeProcessWithFailedTransaction(){
        this.fail=true;
        this.persistenceClient = new SamplePersistenceClient(this.databaseSession,this.fail);                 
        this.persistenceHandler = new PersistenceHandler(this.persistenceClient);
        persistenceHandler.executeProcess();
        assertFalse(persistenceHandler.isSuccessful());     
    }    
}
