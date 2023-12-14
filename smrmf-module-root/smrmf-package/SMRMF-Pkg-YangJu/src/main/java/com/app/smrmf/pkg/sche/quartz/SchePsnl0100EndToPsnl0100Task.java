package com.app.smrmf.pkg.sche.quartz;

import org.springframework.context.ApplicationContext;

import com.app.smrmf.pkg.sche.psnl.generics.PsnlScheSvcContainer;

public class SchePsnl0100EndToPsnl0100Task {
 
    public void  schePsnl0100EndToPsnl0100Update(ApplicationContext ctx) {
    	
    	PsnlScheSvcContainer pssyc = new PsnlScheSvcContainer();
    	 
    	try {
			
    		int iPssyc = pssyc.execPsnl0100EndToPanl0100Update(ctx);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    }
 
}
