package com.app.smrmf.pkg.sche.quartz;

import org.springframework.context.ApplicationContext;

import com.app.smrmf.pkg.sche.psnl.generics.PsnlScheSvcContainer;

public class DummyTask {
 
    public void  scheLogSvcYrNumCd(ApplicationContext ctx) {
    	
    	PsnlScheSvcContainer pssyc = new PsnlScheSvcContainer();
    	 
    	try {
			
    		int iPssyc = pssyc.execPsnlScheLogSvcYr(ctx);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    }
 
}
