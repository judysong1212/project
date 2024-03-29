package com.app.smrmf.pkg.sche.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DummyJobBean extends QuartzJobBean {
 
	 
    private DummyTask dummyTask;
   
    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException { 
        
    	//안타깝게도 QuartzJobBean을 상속시 스프링의 어노테이션을 통해 빈을 취할수 없다.
    	//향수를 불러 일으키는 코드다. 
		try {
			
			SchedulerContext schedulerContext;
			schedulerContext = context.getScheduler().getContext();
		
			ApplicationContext applicationContext = (ApplicationContext) schedulerContext.get("applicationContext"); 
        
			dummyTask.scheLogSvcYrNumCd(applicationContext);
    	
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
 
    public void setDummyTask(DummyTask dummyTask) {
        this.dummyTask = dummyTask;
    }
     
    
}
