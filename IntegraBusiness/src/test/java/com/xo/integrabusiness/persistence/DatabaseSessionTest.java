/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xo.integrabusiness.persistence;

import org.hibernate.Session;
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
public class DatabaseSessionTest {
    
    public DatabaseSessionTest() {
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
    public void createSessionWithDefaultParameters(){
        DatabaseSession databaseSession = new DatabaseSession();
        Session session = databaseSession.establishSession();
        assertTrue(session.isConnected());
        session.close();
    }
    
    @Test
    public void createSessionWithNonDefaultParameters(){
        String resourceURL="extraConfig.cfg.xml";
        DatabaseSession databaseSession = new DatabaseSession(resourceURL);
        Session session = databaseSession.establishSession();        
        
        assertTrue(session.isOpen());
    
        session.close();
        
    }
    
}
