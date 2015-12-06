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
        this.databaseSession = DatabaseSession.startWithDefaultConfiguration(); 
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
    
    private void commonPersistenceHandlerExecution(){
        this.persistenceClient = new SamplePersistenceClient(this.databaseSession,this.fail);                 
        this.persistenceHandler = PersistenceHandler.usePersistenceClient(this.persistenceClient);
        persistenceHandler.executeProcess();
    }
    
    @Test
    public void executeProcessWithSuccessTransaction(){        
        this.fail=false;
        this.commonPersistenceHandlerExecution();
        assertTrue(this.persistenceHandler.isSuccessful());
    }    
    @Test
    public void executeProcessWithFailedTransaction(){
        this.fail=true;
        this.commonPersistenceHandlerExecution();
        assertFalse(persistenceHandler.isSuccessful());     
    }   
    
    @Test
    public void executeClient(){
        this.persistenceClient = new SamplePersistenceClient(this.databaseSession,false);    
        this.persistenceHandler=PersistenceHandler.executeClient(this.persistenceClient);
        assertTrue(this.persistenceHandler.isSuccessful());    
    }
}
