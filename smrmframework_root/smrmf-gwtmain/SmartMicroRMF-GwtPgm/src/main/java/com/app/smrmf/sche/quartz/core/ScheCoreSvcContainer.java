package com.app.smrmf.sche.quartz.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.app.smrmf.sche.quartz.service.ScheCoreSvcService;
import com.app.smrmf.sche.quartz.service.impl.SmrmfScheVO;

@Controller  
public class ScheCoreSvcContainer {


	private static final Logger logger = LoggerFactory.getLogger(ScheCoreSvcContainer.class);
	 
	 //헬스체크로직 수행처리를 위한 메서드 
    @Autowired
    @Resource(name = "ScheCoreSvcService")
    protected ScheCoreSvcService coreScheService; 
    
    private String healthTime = null;
   //스케줄링 
  	public void sysScheHealthCheck(ApplicationContext ctx)  {
  	    
  		 if  (coreScheService == null) { 
  	         
  			coreScheService = (ScheCoreSvcService)ctx.getBean("ScheCoreSvcService"); 
          
         } 
   	    
   	    
   	   try {
   		   
 	  		
 	  		SmrmfScheVO smCoVo = coreScheService.sysScheHealthCheck(); 
 	  		 
 	  	    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a"); 
            healthTime = sdf.format(smCoVo.getHealthCheck());
            
 	  		if (healthTime != null) {  
 	  			System.out.println("[PAYGEN] WEB DB HEALTH CHECK TIME : ".concat(healthTime)); 
 	  		} else {
 	  			System.out.println("[PAYGEN] WEB DB HEALTH CHECK TIME : HEALTH DOWN ?"); 
 	  		}
   	    } catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
  	 
  		
  	}	
  	 
	
}
