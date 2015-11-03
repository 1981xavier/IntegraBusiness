/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xo.integrabusiness.persistence;

/**
 *
 * @author admin
 */
class SamplePersistenceClient extends PersistenceClient {

    private boolean causeFail;
    
    public SamplePersistenceClient(DatabaseSession databaseSession,boolean fail){
        this.databaseSession=databaseSession;
        this.causeFail=fail;
    }

    @Override
    public void executeProcess() {        
        int divisor=1;
        int dividend=1;
        int result=0;
        if(this.causeFail)
        {
            divisor=0;
            result=dividend/divisor;
        }
        
    }
    
}
