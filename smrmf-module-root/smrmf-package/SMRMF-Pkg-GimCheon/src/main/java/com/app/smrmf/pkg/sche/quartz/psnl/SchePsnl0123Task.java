package com.app.smrmf.pkg.sche.quartz.psnl;

import org.springframework.context.ApplicationContext;

import com.app.smrmf.pkg.sche.psnl.generics.PsnlScheSvcContainer;

public class SchePsnl0123Task {
 
    public void  schePsnl0123ToPanl0100Update(ApplicationContext ctx) {
    	
    	PsnlScheSvcContainer pssyc = new PsnlScheSvcContainer();
    	 
    	try {
			
    		int iPssyc = pssyc.execPsnl0123ToPanl0100Update(ctx);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    }
 
}
