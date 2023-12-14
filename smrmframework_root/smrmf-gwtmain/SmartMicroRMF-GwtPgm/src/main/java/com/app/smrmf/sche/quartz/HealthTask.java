package com.app.smrmf.sche.quartz;

import org.springframework.context.ApplicationContext;

import com.app.smrmf.sche.quartz.core.ScheCoreSvcContainer;

public class HealthTask {
 
    public void  runSysScheHealthCheck(ApplicationContext ctx) {
    	
    	ScheCoreSvcContainer pssyc = new ScheCoreSvcContainer();
    	 
    	try {
			
    		 pssyc.sysScheHealthCheck(ctx);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    }
 
}
