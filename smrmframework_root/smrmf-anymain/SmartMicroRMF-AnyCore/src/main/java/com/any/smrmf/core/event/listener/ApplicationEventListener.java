package com.any.smrmf.core.event.listener;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import com.any.smrmf.core.event.handler.ApplicationEventHandler;


public class ApplicationEventListener implements ApplicationListener {


   protected Map<String, ApplicationEventHandler> eventMappings;

   private static Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);


   public Map<String, ApplicationEventHandler> getEventMappings() {
      return eventMappings;
   }

   public void setEventMappings(Map<String, ApplicationEventHandler> eventMappings) {
      this.eventMappings = eventMappings;
   }

   @Override
   public void onApplicationEvent(ApplicationEvent event) { 

	  if(event instanceof ServletRequestHandledEvent)
		  return;

      logger.debug("Event - "+event.getClass().getSimpleName());

      ApplicationEventHandler eventHandler = eventMappings.get(event.getClass().getName());
      if(eventHandler != null){
         try{
            eventHandler.handle(event);
         }catch(Exception e){
            logger.error("EventHander execution is failed", e);
         }
      }else{
         logger.warn("EventHander is not found - " + event.getClass().getName());
      }
   }
}