package com.store.web.front.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.msf.utils.StringAnyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.any.smrmf.utils.MessageUtil;
import com.any.smrmf.utils.SessionUtil;
import com.web.smrmf.core.service.SchedulerService;
import com.web.smrmf.core.vo.SysmScheduleVO;
import com.web.smrmf.sysm.exception.NotFoundException;


@Controller
public class ScheduleController{


   @Autowired
   protected SchedulerService schedulerService; 

   @Autowired
   protected Validator validator;
   
   Logger logger = Logger.getLogger(ScheduleController.class);
   

   @RequestMapping(value="/scheduler/list.html")
   public ModelAndView listSchedule(HttpServletRequest request) {
      List<SysmScheduleVO> scheduleList = schedulerService.getEntireSchedules();
      return new ModelAndView("schedule.list", "scheduleList", scheduleList);
   }

   @SuppressWarnings("unchecked")
   @RequestMapping(value="/scheduler/new.html", method=RequestMethod.GET)
   public ModelAndView registerSchedule(HttpServletRequest request, ModelMap modelMap) {
      modelMap.put("schedule", new SysmScheduleVO());
      modelMap.put("scheduleJobs", schedulerService.getSchedulerJobMap());
      return new ModelAndView("schedule.new", modelMap);
   }
   
   @RequestMapping(value="/scheduler/new.html", method=RequestMethod.POST)
   public ModelAndView registerScheduleSubmit(SysmScheduleVO schedule, BindingResult result, HttpServletRequest request, ModelMap modelMap) {

      validator.validate(schedule, result);
      if (result.hasErrors()){
         ModelAndView mav = new ModelAndView("schedule.new");
         return mav;
      }

      try{
         UserDetails userDetail = SessionUtil.getUserDetails(request);
         schedule.setCreator(userDetail.getUsername());
         schedulerService.addSchedule(schedule);
         List<SysmScheduleVO> scheduleList = schedulerService.getEntireSchedules();
         return new ModelAndView("schedule.list", "scheduleList", scheduleList);
      }catch(Exception e){
         logger.error("Register new schedule is failed", e);
         MessageUtil.saveMessage(request, "failedNewSchedule");
         return registerSchedule(request, modelMap);
      }
   }

   @SuppressWarnings("unchecked")
   @RequestMapping(value="/scheduler/edit.html", method=RequestMethod.GET)
   public ModelAndView edit(HttpServletRequest request, ModelMap modelMap) {
      
      String schId = request.getParameter("schId");
      if(StringAnyUtil.isEmptyOrWhitespace(schId))
         return listSchedule(request);
      
      SysmScheduleVO schedule = null;
      try{
         schedule = schedulerService.getScheduleById(schId);
      }catch(NotFoundException nfe){
         MessageUtil.saveMessage(request, "notFoundSchedule", schId);
         return listSchedule(request);
      }
   
      modelMap.put("schedule", schedule);
      modelMap.put("scheduleJobs", schedulerService.getSchedulerJobMap());
      return new ModelAndView("schedule.edit", modelMap);
   } 

   @SuppressWarnings("unchecked")
   @RequestMapping(value="/scheduler/edit.html", method=RequestMethod.POST)
   public ModelAndView editSubmit(SysmScheduleVO schedule, BindingResult result, HttpServletRequest request, ModelMap modelMap) {
      
      validator.validate(schedule, result);
      if (result.hasErrors()){
         modelMap.put("scheduleJobs", schedulerService.getSchedulerJobMap());
         ModelAndView mav = new ModelAndView("schedule.edit", modelMap);
         return mav;
      }

      try{
         UserDetails userDetail = SessionUtil.getUserDetails(request);
         schedule.setEditor(userDetail.getUsername());         
         schedulerService.changeSchedule(schedule);         
         List<SysmScheduleVO> scheduleList = schedulerService.getEntireSchedules();
         modelMap.put("scheduleList", scheduleList);
         return new ModelAndView("schedule.list", modelMap);         
      }catch(Exception e){
         logger.error("Editing schedule is failed", e);
         MessageUtil.saveMessage(request, "failedEditSchedule");
         return edit(request, modelMap);
      }
   }    
   
   @RequestMapping(value="/scheduler/cancel.html")
   public ModelAndView cancel(HttpServletRequest request, ModelMap modelMap) {
      
      String schId = request.getParameter("schId");
      if(StringAnyUtil.isEmptyOrWhitespace(schId))
         return listSchedule(request);
      
      try{
         schedulerService.cancelSchedule(schId);
         List<SysmScheduleVO> scheduleList = schedulerService.getEntireSchedules();
         return new ModelAndView("schedule.list", "scheduleList", scheduleList);
      }catch(Exception e){
         logger.error("Schedule cancel is failed", e);
         return listSchedule(request);
      }
   } 
}
