package com.app.smrmf.exterms.sso.login.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.app.smrmf.exterms.sso.login.service.SSOLoginService;
import com.app.smrmf.magicsso.service.SsomUserService;
import com.app.smrmf.ssocom.service.SsoxSmrmfService;
import com.app.smrmf.sysm.server.vo.system.LoginVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;
import com.ext.constants.PropConfs;
import com.sso.constants.SsoConf;

/**
 * @Class Name : Sysm0100Controller.java
 * @Description : Sysm0100 Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller 
public class SSOLoginController implements ServletContextAware, ServletConfigAware {

    /** log */
    
    private static Logger logger = LoggerFactory.getLogger(SSOLoginController.class);
   
	
	public static final String SYSTEM_SESSION_SSO   = "ssoxuser";

    /** LoginService */
	@Resource(name = "SSOLoginService")
    private SSOLoginService ssoLoginService;
	
	
	  /** 세올서비스 호출부  */
		@Resource(name = "SsoxSmrmfService")
	    private SsoxSmrmfService ssoxUserService;
	   
		 /** 올레서비스 호출부 */
		@Resource(name = "SsomUserService")
	    private SsomUserService ssomUserService;
	/** EgovMessageSource */
    
//	@Resource(name="egovMessageSource")
//    EgovMessageSource egovMessageSource;
    
	
    private ServletContext sevltContext;
    
    private ServletConfig sevltConfig;
    
    @Override
    public void setServletConfig(final ServletConfig servletConfig) {
        this.sevltConfig = servletConfig;

    }

    @Override
    public void setServletContext(final ServletContext servletContext) {
        this.sevltContext = servletContext;

    }
     
    /**
	 * 일반(세션) 로그인을 처리한다
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
    @RequestMapping(value="/SSOLogin/SSOLogin.do")
    public ModelAndView actionLogin(@RequestParam(value="ssoUsrId", required=false) String ssoUsrId, 
    		                   HttpServletRequest request,
    		                   ModelMap model)
            throws Exception {  
    	 
//    	   ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//    	   HttpSession httpSession = attr.getRequest().getSession();
    	 
        	SsoConf.setSsoConfigFile(PropConfs.APP_CONFIG_FILE);
    	   final HashMap<String, String> ssoGlobals = SsoConf.getPayGenSsoConfigInfo(sevltConfig , request);   
    	
//			System.out.println("===============================sso 받은값 debug============================");
//			System.out.println("svDirPath : " + ssoGlobals.get("PayGen.SSOLinkPage"));   
//			System.out.println("ssoUsrId : " +  ssoUsrId);  
//			System.out.println("===============================sso 받은값 debug============================");
			
             ///SSOLogin/SSOLogin.do?ssoUsrId=portal01
    	    LoginVO loginVo = new LoginVO();
    	   // String strRtn = "redirect:/ExTermsPage.do";
    	    String encrypted = "";
    	    String origin_data = ""; //복호화된 값을 저장할 별수
        	try {   
        	   if (ssoUsrId != null &&  !ssoUsrId.equals("")) {
    	    	  
        		    encrypted = ssoUsrId;
        		 //   LOG.debug("data-sso : " + ssoUsrId);
        		    origin_data = encrypted;
        		    
        		   if (ssoUsrId.equals("02esj")) {
        			   
    //    	    	 try {
    //       			
    //   	    	    origin_data = crypt.dec(encrypted);
    //   	    	    
    //       		 } catch (Exception ex) {
    //       			
    //       			return "redirect:/ExTermsPage.do"; 
    //       		 }
        			   
        			 //  SsoxUserVO resultVO = new SsoxUserVO();
        			  
        			  //resultVO.setUserId("admin");
        			  //resultVO.setDpobCd("20144050000001");
        			 // resultVO.setSysDivCd("EXTERM00");
        			   
        					   
        			 // request.getSession().setAttribute(MSFConfiguration.PAYGEN_SESSION_SSO, resultVO);
        			 // request.setAttribute("strWebId","kmo0823");
        			 //  SsoxUserVO resultVO1 =  (SsoxUserVO)request.getSession().getAttribute(MSFConfiguration.PAYGEN_SESSION_SSO);
        			 // strRtn =  "redirect:" + PayGen.MY_URL_PAGE  + "?strWebId=kmo0823"; 
//        				System.out.println("===============================report 받은값 debug============================");
//        				System.out.println("svDirPath : " + ssoGlobals.get("PayGen.SSOLinkPage"));   
//        				System.out.println("svRexParam : " +  resultVO.getSysDivCd());  
//        				System.out.println("===============================report debug============================");
        			   SsoxUserVO resultVO = new SsoxUserVO(); 
    	    		   loginVo.setSsoUsrId(origin_data);   
    		    	  // 1. 일반 로그인 처리 - 무기계약직 호출 
    	    		   SsoxUserVO sysmVO = ssoLoginService.actionSSOLogin(loginVo); 
    	    		   
    	    		   if (sysmVO != null && sysmVO.getUserId()  != null && !sysmVO.getUserId().equals("")) { 
    	    		  
    	    			    resultVO.setUserId(sysmVO.getUserId());
    	        			resultVO.setDpobCd(sysmVO.getDpobCd());
    	        			resultVO.setSysDivCd(sysmVO.getSysDivCd());
    	    			   
    	    		   } else {   
    	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
    	    		   }
    	    		   TimingInfo millisBeginSelectSsoxUser = SmrmfUtils.startTiming(logger); 
    	    		   SsoxUserVO rtnSsoUsrVO  = ssoxUserService.selectSsoxUser(sysmVO); 
    	    		   SmrmfUtils.endTiming(logger, millisBeginSelectSsoxUser, "selectSsoxUser");
    	    		   
    	    		   
//    	    		   System.out.println("=============================== debug 01============================");
//   		   			   System.out.println("getUserId : " + rtnSsoUsrVO.getUserId());    /** column null : userId */
//					   System.out.println("getUserName : " +  rtnSsoUsrVO.getUserName());    /** column null : userName */    
//   		   			   System.out.println("=============================== debug 01============================");
   		   			
   		   			   
    	    		   if (rtnSsoUsrVO != null && rtnSsoUsrVO.getUserId()  != null && !rtnSsoUsrVO.getUserId().equals("")) {  

								resultVO.setUserId(rtnSsoUsrVO.getUserId());    /** column null : userId */
								resultVO.setUserName(rtnSsoUsrVO.getUserName());    /** column null : userName */
								resultVO.setUserSn(rtnSsoUsrVO.getUserSn());    /** column null : userSn */
								resultVO.setUserStat(rtnSsoUsrVO.getUserStat());    /** column null : userStat */
								resultVO.setUserStatName(rtnSsoUsrVO.getUserStatName());    /** column null : userStatName */
								resultVO.setRegularity(rtnSsoUsrVO.getRegularity());    /** column null : regularity */
								resultVO.setOrgId(rtnSsoUsrVO.getOrgId());    /** column null : orgId */
								resultVO.setOrgName(rtnSsoUsrVO.getOrgName());    /** column null : orgName */
								resultVO.setDeptId(rtnSsoUsrVO.getDeptId());    /** column null : deptId */
								resultVO.setDeptName(rtnSsoUsrVO.getDeptName());    /** column null : deptName */
								resultVO.setDeptFullname(rtnSsoUsrVO.getDeptFullname());    /** column null : deptFullname */
								resultVO.setClassId(rtnSsoUsrVO.getClassId());    /** column null : classId */
								resultVO.setClassName(rtnSsoUsrVO.getClassName());    /** column null : className */
								resultVO.setPositionId(rtnSsoUsrVO.getPositionId());    /** column null : positionId */
								resultVO.setPositionName(rtnSsoUsrVO.getPositionName());    /** column null : positionName */
								resultVO.setGradeId(rtnSsoUsrVO.getGradeId());    /** column null : gradeId */
								resultVO.setGradeName(rtnSsoUsrVO.getGradeName());    /** column null : gradeName */
								resultVO.setEmail(rtnSsoUsrVO.getEmail());    /** column null : email */
								resultVO.setTel(rtnSsoUsrVO.getTel());    /** column null : tel */
								resultVO.setMobile(rtnSsoUsrVO.getMobile());    /** column null : mobile */
								resultVO.setJoinDay(rtnSsoUsrVO.getJoinDay());    /** column null : joinDay */
								resultVO.setRetireDay(rtnSsoUsrVO.getRetireDay());    /** column null : retireDay */
								resultVO.setAddInfo1(rtnSsoUsrVO.getAddInfo1());    /** column null : addInfo1 */
								resultVO.setAddInfo2(rtnSsoUsrVO.getAddInfo2());    /** column null : addInfo2 */
								resultVO.setAddInfo3(rtnSsoUsrVO.getAddInfo3());    /** column null : addInfo3 */
								resultVO.setAddInfo4(rtnSsoUsrVO.getAddInfo4());    /** column null : addInfo4 */
								resultVO.setAddInfo5(rtnSsoUsrVO.getAddInfo5());    /** column null : addInfo5 */
								resultVO.setAddInfo6(rtnSsoUsrVO.getAddInfo6());    /** column null : addInfo6 */
								resultVO.setAddInfo7(rtnSsoUsrVO.getAddInfo7());    /** column null : addInfo7 */
								resultVO.setBaseSys(rtnSsoUsrVO.getBaseSys());    /** column null : baseSys */
								resultVO.setRegDay(rtnSsoUsrVO.getRegDay());    /** column null : regDay */
								resultVO.setUpdateDay(rtnSsoUsrVO.getUpdateDay());    /** column null : updateDay */
								resultVO.setUseYn(rtnSsoUsrVO.getUseYn());    /** column null : useYn */
								resultVO.setRdutyName(rtnSsoUsrVO.getRdutyName());    /** column null : rdutyName */
								resultVO.setSsoUseType("SSOX");  //SSOX 적용 
    	    			   
    	    		   } else {   
    	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
    	    		   }
    	    		   
    	    		
   		   			
    		           if (resultVO != null && resultVO.getUserId()  != null && !resultVO.getUserId().equals("")) {
    		        	   
//    		        	System.out.println("===============================aaaareport 처리 결과 debug============================");
//    		   			System.out.println("getUserId : " + resultVO.getUserId());    /** column null : userId */
//					 	System.out.println("getUserName : " +  resultVO.getUserName());    /** column null : userName */    
//    		   			System.out.println("===============================aaareport debug============================");
    		   			
    		        	   request.getSession().setAttribute(SYSTEM_SESSION_SSO, resultVO);  
    		               return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
    		           } else {
    		        	   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
    		           }
        		   }  else {    
        			   
        			   SsoxUserVO resultVO = new SsoxUserVO(); 
    	    		   loginVo.setSsoUsrId(origin_data);   
    		    	  //1. 일반 로그인 처리 - 무기계약직 호출 
    	    		   SsoxUserVO sysmVO = ssoLoginService.actionSSOLogin(loginVo); 
    	    		   
    	    		   if (sysmVO != null && sysmVO.getUserId()  != null && !sysmVO.getUserId().equals("")) { 
    	    		  
    	    			    resultVO.setUserId(sysmVO.getUserId());
   	        				resultVO.setDpobCd(sysmVO.getDpobCd());
   	        			    resultVO.setSysDivCd(sysmVO.getSysDivCd());
   	        			
    	    		   } else {   
    	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
    	    		   }
    	    		   TimingInfo millisBeginRtnSsoUsrVO = SmrmfUtils.startTiming(logger);
    	    		   SsoxUserVO rtnSsoUsrVO  = ssoxUserService.selectSsoxUser(sysmVO);
    	    		   SmrmfUtils.endTiming(logger, millisBeginRtnSsoUsrVO, "selectSsoxUser");
    	    		   if (rtnSsoUsrVO != null && rtnSsoUsrVO.getUserId()  != null && !rtnSsoUsrVO.getUserId().equals("")) {  

								resultVO.setUserId(rtnSsoUsrVO.getUserId());    /** column null : userId */
								resultVO.setUserName(rtnSsoUsrVO.getUserName());    /** column null : userName */
								resultVO.setUserSn(rtnSsoUsrVO.getUserSn());    /** column null : userSn */
								resultVO.setUserStat(rtnSsoUsrVO.getUserStat());    /** column null : userStat */
								resultVO.setUserStatName(rtnSsoUsrVO.getUserStatName());    /** column null : userStatName */
								resultVO.setRegularity(rtnSsoUsrVO.getRegularity());    /** column null : regularity */
								resultVO.setOrgId(rtnSsoUsrVO.getOrgId());    /** column null : orgId */
								resultVO.setOrgName(rtnSsoUsrVO.getOrgName());    /** column null : orgName */
								resultVO.setDeptId(rtnSsoUsrVO.getDeptId());    /** column null : deptId */
								resultVO.setDeptName(rtnSsoUsrVO.getDeptName());    /** column null : deptName */
								resultVO.setDeptFullname(rtnSsoUsrVO.getDeptFullname());    /** column null : deptFullname */
								resultVO.setClassId(rtnSsoUsrVO.getClassId());    /** column null : classId */
								resultVO.setClassName(rtnSsoUsrVO.getClassName());    /** column null : className */
								resultVO.setPositionId(rtnSsoUsrVO.getPositionId());    /** column null : positionId */
								resultVO.setPositionName(rtnSsoUsrVO.getPositionName());    /** column null : positionName */
								resultVO.setGradeId(rtnSsoUsrVO.getGradeId());    /** column null : gradeId */
								resultVO.setGradeName(rtnSsoUsrVO.getGradeName());    /** column null : gradeName */
								resultVO.setEmail(rtnSsoUsrVO.getEmail());    /** column null : email */
								resultVO.setTel(rtnSsoUsrVO.getTel());    /** column null : tel */
								resultVO.setMobile(rtnSsoUsrVO.getMobile());    /** column null : mobile */
								resultVO.setJoinDay(rtnSsoUsrVO.getJoinDay());    /** column null : joinDay */
								resultVO.setRetireDay(rtnSsoUsrVO.getRetireDay());    /** column null : retireDay */
								resultVO.setAddInfo1(rtnSsoUsrVO.getAddInfo1());    /** column null : addInfo1 */
								resultVO.setAddInfo2(rtnSsoUsrVO.getAddInfo2());    /** column null : addInfo2 */
								resultVO.setAddInfo3(rtnSsoUsrVO.getAddInfo3());    /** column null : addInfo3 */
								resultVO.setAddInfo4(rtnSsoUsrVO.getAddInfo4());    /** column null : addInfo4 */
								resultVO.setAddInfo5(rtnSsoUsrVO.getAddInfo5());    /** column null : addInfo5 */
								resultVO.setAddInfo6(rtnSsoUsrVO.getAddInfo6());    /** column null : addInfo6 */
								resultVO.setAddInfo7(rtnSsoUsrVO.getAddInfo7());    /** column null : addInfo7 */
								resultVO.setBaseSys(rtnSsoUsrVO.getBaseSys());    /** column null : baseSys */
								resultVO.setRegDay(rtnSsoUsrVO.getRegDay());    /** column null : regDay */
								resultVO.setUpdateDay(rtnSsoUsrVO.getUpdateDay());    /** column null : updateDay */
								resultVO.setUseYn(rtnSsoUsrVO.getUseYn());    /** column null : useYn */
								resultVO.setRdutyName(rtnSsoUsrVO.getRdutyName());    /** column null : rdutyName */
								resultVO.setSsoUseType("SSOX");  //SSOX 적용 
    	    			   
    	    		   } else {   
    	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
    	    		   }
    	    		   
    		           if (resultVO != null && resultVO.getUserId()  != null && !resultVO.getUserId().equals("")) { 
    		        	   
    		        	   //무기계약직/기간제근로자인경우은 웹페이지로 이동한다.
    		    		   if ("99901".equals(resultVO.getClassId()) || "99902".equals(resultVO.getClassId())) {
    		    			   
    		    			    if ("YONGIN".equals(ssoGlobals.get("PayGen.MunicipalitiesName"))) {  
    	    		    		      // return "redirect:" + Globals.MY_URL_PAGE + "?strWebId=" + resultVO.getUserId(); Globals.MY_URL_PAGE
    	    		    		       return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.MyUrlPage")  + "?strWebId=" + resultVO.getUserId()); 
           		    			 } else {
           		    				 // TODO 임시처리 
           		    			   // 2-1. 로그인 정보를 세션에 저장
           		    				 request.getSession().setAttribute(SYSTEM_SESSION_SSO, resultVO); 
            			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
               			          	
           		    			 }
    		    			  
    		    		   } else { 
    		    		  
    			        	// 2-1. 로그인 정보를 세션에 저장
    			          	 request.getSession().setAttribute(SYSTEM_SESSION_SSO, resultVO); 
    			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
    			          	
    		    		   }
    		    	 	
    		           } else {
    		    	 		 
    		    	 		// model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
    		               return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
    		    	   }
        		   }
    	      
    	       } else { 
    	           return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
    	       }
        	 } catch (Exception ex) {
        	     ex.printStackTrace();
        	     logger.error("EXCEPTION calling actionLogin(): "+ex);
        	     return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));  // + "/ExTermsPage.do"
             }
        	  
        	//return strRtn;
        	  
            
    }   
    
    
    /**
   	 * 일반(세션) 로그인을 처리한다
   	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
   	 * @param request - 세션처리를 위한 HttpServletRequest
   	 * @return result - 로그인결과(세션정보)
   	 * @exception Exception
   	 */
       @RequestMapping(value="/SSOLogin/ATTRLogin.do")
       public ModelAndView actionLogin(HttpServletRequest request,
       		                   ModelMap model,HttpSession httpSession)
               throws Exception {  
       	 
    	   String attrSsoUsrId = "";
    	   String ssoUsrId = "";
      	  //  ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
      	 
       	    HttpSession session = request.getSession();
       	    
//   		int i=0;
//          
//	        Enumeration e1 = session.getAttributeNames();
//	         
//	       	while(e1.hasMoreElements()){
//	
//	       		String sname = (String) e1.nextElement();
//	       		String svalue = session.getAttribute(sname).toString();
//	       	    logger.debug("ssolog sesion : " + "["+ i +"]"+sname+"=["+ i +"]"+svalue+"<br>");
//	       		i++;
//	
//	       	}
//	       	
//	        Enumeration e = httpSession.getAttributeNames();
//	        
//           i=0;
// 
//	       	while(e.hasMoreElements()){
//	
//	       		String sname = (String) e.nextElement();
//	       		String svalue = httpSession.getAttribute(sname).toString();
//	       	    logger.debug("ssolog sesion2 : " + "["+ i +"]"+sname+"=["+ i +"]"+svalue+"<br>");
//	       		i++;
//	
//	       	} 
       	           	
       	    attrSsoUsrId = String.valueOf(session.getAttribute("ssoUsrId")); 
     	    
     	    logger.debug("ssolog : " + attrSsoUsrId);
			 
     	    if (attrSsoUsrId != null &&  !attrSsoUsrId.equals("")) { 
     	    	
     	    	ssoUsrId = attrSsoUsrId;
     	    	
     	    } else {	
     	    	 
     	         ssoUsrId = String.valueOf(httpSession.getAttribute("ssoUsrId"));
     	    }
     	     
       	    if (ssoUsrId != null &&  !ssoUsrId.equals("")) { 
       	    	 
       	    } else {	
       	    	ssoUsrId = String.valueOf(request.getAttribute("ssoUsrId"));
       	    }
       	
       	    SsoConf.setSsoConfigFile(PropConfs.APP_CONFIG_FILE);  
       	    final HashMap<String, String> ssoGlobals = SsoConf.getPayGenSsoConfigInfo(sevltConfig , request);   
        
              ///SSOLogin/SSOLogin.do?ssoUsrId=portal01
       	    LoginVO loginVo = new LoginVO();
       	   // String strRtn = "redirect:/ExTermsPage.do";
       	    String encrypted = "";
       	    String origin_data = ""; //복호화된 값을 저장할 별수
           	try {   
           	   if (ssoUsrId != null &&  !ssoUsrId.equals("")) {
       	    	  
           		    encrypted = ssoUsrId;
           		 //   LOG.debug("data-sso : " + ssoUsrId);
           		    origin_data = encrypted;
           		    
           		               			   
           			   SsoxUserVO resultVO = new SsoxUserVO(); 
       	    		   loginVo.setSsoUsrId(origin_data);   
       		    	  // 1. 일반 로그인 처리 - 무기계약직 호출 
       	    		   SsoxUserVO sysmVO = ssoLoginService.actionSSOLogin(loginVo); 
       	    		   
//       	    		System.out.println("===============================aaaarepoㅁㅁㅁㅁrt 처리 결과 debug============================");
//       	   			System.out.println("getUserId : " + sysmVO.getUserId());    /** column null : userId */
//       			 	System.out.println("getUserName : " +  sysmVO.getUserName());    /** column null : userName */    
//       	   			System.out.println("===============================aaareport debug============================");
       	   			
       	    		   if (sysmVO != null && sysmVO.getUserId()  != null && !sysmVO.getUserId().equals("")) { 
       	    		  
       	    			    resultVO.setUserId(sysmVO.getUserId());
      	        			resultVO.setDpobCd(sysmVO.getDpobCd());
      	        			resultVO.setSysDivCd(sysmVO.getSysDivCd());
      	       	   			
       	    		   } else {   
       	    			   
       	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));  
               	   			
       	    		   }
       	    		   TimingInfo millisBeginSelectSsoxUser = SmrmfUtils.startTiming(logger);
           	   			
       	    		   SsoxUserVO rtnSsoUsrVO  = ssoxUserService.selectSsoxUser(sysmVO);
       	    		   
       	   			
       	    		   SmrmfUtils.endTiming(logger, millisBeginSelectSsoxUser, "selectSsoxUser");
       	    		   if (rtnSsoUsrVO != null && rtnSsoUsrVO.getUserId()  != null && !rtnSsoUsrVO.getUserId().equals("")) {  
 
   								resultVO.setUserId(rtnSsoUsrVO.getUserId());    /** column null : userId */
   								resultVO.setUserName(rtnSsoUsrVO.getUserName());    /** column null : userName */
   								resultVO.setUserSn(rtnSsoUsrVO.getUserSn());    /** column null : userSn */
   								resultVO.setUserStat(rtnSsoUsrVO.getUserStat());    /** column null : userStat */
   								resultVO.setUserStatName(rtnSsoUsrVO.getUserStatName());    /** column null : userStatName */
   								resultVO.setRegularity(rtnSsoUsrVO.getRegularity());    /** column null : regularity */
   								resultVO.setOrgId(rtnSsoUsrVO.getOrgId());    /** column null : orgId */
   								resultVO.setOrgName(rtnSsoUsrVO.getOrgName());    /** column null : orgName */
   								resultVO.setDeptId(rtnSsoUsrVO.getDeptId());    /** column null : deptId */
   								resultVO.setDeptName(rtnSsoUsrVO.getDeptName());    /** column null : deptName */
   								resultVO.setDeptFullname(rtnSsoUsrVO.getDeptFullname());    /** column null : deptFullname */
   								resultVO.setClassId(rtnSsoUsrVO.getClassId());    /** column null : classId */
   								resultVO.setClassName(rtnSsoUsrVO.getClassName());    /** column null : className */
   								resultVO.setPositionId(rtnSsoUsrVO.getPositionId());    /** column null : positionId */
   								resultVO.setPositionName(rtnSsoUsrVO.getPositionName());    /** column null : positionName */
   								resultVO.setGradeId(rtnSsoUsrVO.getGradeId());    /** column null : gradeId */
   								resultVO.setGradeName(rtnSsoUsrVO.getGradeName());    /** column null : gradeName */
   								resultVO.setEmail(rtnSsoUsrVO.getEmail());    /** column null : email */
   								resultVO.setTel(rtnSsoUsrVO.getTel());    /** column null : tel */
   								resultVO.setMobile(rtnSsoUsrVO.getMobile());    /** column null : mobile */
   								resultVO.setJoinDay(rtnSsoUsrVO.getJoinDay());    /** column null : joinDay */
   								resultVO.setRetireDay(rtnSsoUsrVO.getRetireDay());    /** column null : retireDay */
   								resultVO.setAddInfo1(rtnSsoUsrVO.getAddInfo1());    /** column null : addInfo1 */
   								resultVO.setAddInfo2(rtnSsoUsrVO.getAddInfo2());    /** column null : addInfo2 */
   								resultVO.setAddInfo3(rtnSsoUsrVO.getAddInfo3());    /** column null : addInfo3 */
   								resultVO.setAddInfo4(rtnSsoUsrVO.getAddInfo4());    /** column null : addInfo4 */
   								resultVO.setAddInfo5(rtnSsoUsrVO.getAddInfo5());    /** column null : addInfo5 */
   								resultVO.setAddInfo6(rtnSsoUsrVO.getAddInfo6());    /** column null : addInfo6 */
   								resultVO.setAddInfo7(rtnSsoUsrVO.getAddInfo7());    /** column null : addInfo7 */
   								resultVO.setBaseSys(rtnSsoUsrVO.getBaseSys());    /** column null : baseSys */
   								resultVO.setRegDay(rtnSsoUsrVO.getRegDay());    /** column null : regDay */
   								resultVO.setUpdateDay(rtnSsoUsrVO.getUpdateDay());    /** column null : updateDay */
   								resultVO.setUseYn(rtnSsoUsrVO.getUseYn());    /** column null : useYn */
   								resultVO.setRdutyName(rtnSsoUsrVO.getRdutyName());    /** column null : rdutyName */
   								resultVO.setSsoUseType("SSOX");  //SSOX 적용 
       	    			   
       	    		   } else {    
       				 
       	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
       	    		   }
       	    		   
       		           if (resultVO != null && resultVO.getUserId()  != null && !resultVO.getUserId().equals("")) { 
       		        	 
       		        	   //무기계약직/기간제근로자인경우은 웹페이지로 이동한다.
       		    		   if ("99901".equals(resultVO.getClassId()) || "99902".equals(resultVO.getClassId())) {
       		    			 
       		    			 if ("YONGIN".equals(ssoGlobals.get("PayGen.MunicipalitiesName"))) { 
       		    		       // return "redirect:" + Globals.MY_URL_PAGE + "?strWebId=" + resultVO.getUserId(); Globals.MY_URL_PAGE
       		    		        return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.MyUrlPage")  + "?strWebId=" + resultVO.getUserId()); 
       		    			 } else {
       		    				 // TODO 임시처리 
       		    			   // 2-1. 로그인 정보를 세션에 저장
       		    			 
           			          	 request.getSession().setAttribute(SYSTEM_SESSION_SSO, resultVO); 
           			            
           			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
           			          	
       		    			 }
       		    		   } else { 
       			        	// 2-1. 로그인 정보를 세션에 저장
       			          	 request.getSession().setAttribute(SYSTEM_SESSION_SSO, resultVO);
       			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
       			            
       		    		   }
       		    	 	
       		           } else {
       		         
       		    	 		// model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
       		               return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
       		    	   }
           		   
       	      
       	       } else { 
       	    	 
       	           return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
       	       }
           	 } catch (Exception ex) {
           	     ex.printStackTrace();
           	     logger.error("EXCEPTION calling actionLogin(): "+ex);
           	     return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));  // + "/ExTermsPage.do"
                }
           	  
           	//return strRtn;
           	  
               
       }   
       
       /**
      	 * 올레 세션일반(세션) 로그인을 처리한다
      	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
      	 * @param request - 세션처리를 위한 HttpServletRequest
      	 * @return result - 로그인결과(세션정보)
      	 * @exception Exception
      	 */
          @RequestMapping(value="/SSOLogin/MAGICLogin.do")
          public ModelAndView actionMagicLogin(HttpServletRequest request,
          		                   ModelMap model,HttpSession httpSession)
                  throws Exception {  
          	 
       	   String attrSsoUsrId = "";
       	   String ssoUsrId = "";
         	  //  ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
         	 
          	    HttpSession session = request.getSession();
          	    
//      		int i=0;
//             
//   	        Enumeration e1 = session.getAttributeNames();
//   	         
//   	       	while(e1.hasMoreElements()){
   //	
//   	       		String sname = (String) e1.nextElement();
//   	       		String svalue = session.getAttribute(sname).toString();
//   	       	    logger.debug("ssolog sesion : " + "["+ i +"]"+sname+"=["+ i +"]"+svalue+"<br>");
//   	       		i++;
   //	
//   	       	}
//   	       	
//   	        Enumeration e = httpSession.getAttributeNames();
//   	        
//              i=0;
   // 
//   	       	while(e.hasMoreElements()){
   //	
//   	       		String sname = (String) e.nextElement();
//   	       		String svalue = httpSession.getAttribute(sname).toString();
//   	       	    logger.debug("ssolog sesion2 : " + "["+ i +"]"+sname+"=["+ i +"]"+svalue+"<br>");
//   	       		i++;
   //	
//   	       	} 
          	           	
          	    attrSsoUsrId = String.valueOf(session.getAttribute("SSO_IDS")); 
        	    
        	    logger.debug("ssolog : " + attrSsoUsrId);
   			 
        	    if (attrSsoUsrId != null &&  !attrSsoUsrId.equals("")) { 
        	    	
        	    	ssoUsrId = attrSsoUsrId;
        	    	
        	    } else {	
        	    	 
        	         ssoUsrId = String.valueOf(httpSession.getAttribute("SSO_IDS"));
        	    }
        	     
          	    if (ssoUsrId != null &&  !ssoUsrId.equals("")) { 
          	    	 
          	    } else {	
          	    	ssoUsrId = String.valueOf(request.getAttribute("SSO_IDS"));
          	    }
          	
          	    SsoConf.setSsoConfigFile(PropConfs.APP_CONFIG_FILE);  
          	    final HashMap<String, String> ssoGlobals = SsoConf.getPayGenSsoConfigInfo(sevltConfig , request);   
           
                 ///SSOLogin/SSOLogin.do?ssoUsrId=portal01
          	    LoginVO loginVo = new LoginVO();
          	   // String strRtn = "redirect:/ExTermsPage.do";
          	    String encrypted = "";
          	    String origin_data = ""; //복호화된 값을 저장할 별수
              	try {   
              	   if (ssoUsrId != null &&  !ssoUsrId.equals("")) {
          	    	  
              		    encrypted = ssoUsrId;
              		 //   LOG.debug("data-sso : " + ssoUsrId);
              		    origin_data = encrypted;
              		  
              		          	   
              		       SsoxUserVO resultVO = new SsoxUserVO(); 
          	    		   loginVo.setSsoUsrId(origin_data);   
          		    	  // 1. 일반 로그인 처리 - 무기계약직 호출
          	    		   SsomUserVO sysmVO = ssoLoginService.actionOLSSOLogin(loginVo); 
          	    		   
//          	    		System.out.println("=============================== 처리 결과 debug============================");
//          	   			System.out.println("getUserId : " + sysmVO.getUserId());    /** column null : userId */
//          			 	System.out.println("getUserName : " +  sysmVO.getUserName());    /** column null : userName */    
//          	   			System.out.println("===============================aaareport debug============================");
          	   			
          	    		   if (sysmVO != null && sysmVO.getUserId()  != null && !sysmVO.getUserId().equals("")) { 
          	    		  
          	    			    resultVO.setUserId(sysmVO.getUserId());
         	        			resultVO.setDpobCd(sysmVO.getDpobCd());
         	        			resultVO.setSysDivCd(sysmVO.getSysDivCd());
         	       	   			
          	    		   } else {   
          	    			   
          	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));  
                  	   			
          	    		   }
          	    		   TimingInfo millisBeginSelectSsoxUser = SmrmfUtils.startTiming(logger);
              	   			
          	    		   SsomUserVO rtnSsoUsrVO  = ssomUserService.selectSsomUser(sysmVO); 
          	   			
          	    		   SmrmfUtils.endTiming(logger, millisBeginSelectSsoxUser, "selectSsomUser");
          	    		   if (rtnSsoUsrVO != null && rtnSsoUsrVO.getSidM()  != null && !rtnSsoUsrVO.getSidM().equals("")) {  
    
      								resultVO.setUserId(rtnSsoUsrVO.getSidM());    /** column null : userId */
      								resultVO.setUserName(rtnSsoUsrVO.getDisplayname());    /** column null : userName */
      								resultVO.setUserSn("");    /** column null : userSn */
      								resultVO.setUserStat(rtnSsoUsrVO.getStatus());    /** column null : userStat */
      								resultVO.setUserStatName("");    /** column null : userStatName */
      								resultVO.setRegularity("");    /** column null : regularity */
      								resultVO.setOrgId(rtnSsoUsrVO.getTopoucode());    /** column null : orgId */
      								resultVO.setOrgName("");    /** column null : orgName */
      								resultVO.setDeptId(rtnSsoUsrVO.getOucode());    /** column null : deptId */
      								resultVO.setDeptName(rtnSsoUsrVO.getOu());    /** column null : deptName */
      								resultVO.setDeptFullname(rtnSsoUsrVO.getOrgfullname());    /** column null : deptFullname */
      								resultVO.setClassId(rtnSsoUsrVO.getPositioncode());    /** column null : classId */
      								resultVO.setClassName(rtnSsoUsrVO.getPosition());    /** column null : className */
      								resultVO.setPositionId(rtnSsoUsrVO.getTitlecode());    /** column null : positionId */
      								resultVO.setPositionName(rtnSsoUsrVO.getTitle());    /** column null : positionName */
      								resultVO.setGradeId("");    /** column null : gradeId */
      								resultVO.setGradeName("");    /** column null : gradeName */
      								resultVO.setEmail(rtnSsoUsrVO.getMail());    /** column null : email */
      								resultVO.setTel(rtnSsoUsrVO.getTelephonenumber());    /** column null : tel */
      								resultVO.setMobile(rtnSsoUsrVO.getMobile());    /** column null : mobile */
      								resultVO.setJoinDay("");    /** column null : joinDay */
      								resultVO.setRetireDay("");    /** column null : retireDay */
      								resultVO.setAddInfo1("");    /** column null : addInfo1 */
      								resultVO.setAddInfo2("");    /** column null : addInfo2 */
      								resultVO.setAddInfo3("");    /** column null : addInfo3 */
      								resultVO.setAddInfo4("");    /** column null : addInfo4 */
      								resultVO.setAddInfo5("");    /** column null : addInfo5 */
      								resultVO.setAddInfo6("");    /** column null : addInfo6 */
      								resultVO.setAddInfo7("");    /** column null : addInfo7 */
      								resultVO.setBaseSys("");    /** column null : baseSys */
      								resultVO.setRegDay("");    /** column null : regDay */
      								resultVO.setUpdateDay("");    /** column null : updateDay */
      								resultVO.setUseYn(rtnSsoUsrVO.getStatus());    /** column null : useYn */
      								resultVO.setRdutyName("");    /** column null : rdutyName */
      								resultVO.setSsoUseType("SSOX");  //SSOX 적용 
          	    			   
          	    		   } else {    
          				 
          	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
          	    		   }
          	    		   
          		           if (resultVO != null && resultVO.getUserId()  != null && !resultVO.getUserId().equals("")) { 
          		        	 
          		        	   //무기계약직/기간제근로자인경우은 웹페이지로 이동한다.
//          		    		   if ("99901".equals(resultVO.getClassId()) || "99902".equals(resultVO.getClassId())) {
//          		    			 
//          		    			 if ("YONGIN".equals(ssoGlobals.get("PayGen.MunicipalitiesName"))) { 
//          		    		       // return "redirect:" + Globals.MY_URL_PAGE + "?strWebId=" + resultVO.getUserId(); Globals.MY_URL_PAGE
//          		    		        return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.MyUrlPage")  + "?strWebId=" + resultVO.getUserId()); 
//          		    			 } else {
//          		    				 // TODO 임시처리 
//          		    			   // 2-1. 로그인 정보를 세션에 저장
//          		    			 
//              			          	 request.getSession().setAttribute(SYSTEM_SESSION_SSO, resultVO); 
//              			            
//              			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
//              			          	
//          		    			 }
//          		    		   } else { 
          			        	// 2-1. 로그인 정보를 세션에 저장
          			          	 request.getSession().setAttribute(SYSTEM_SESSION_SSO, resultVO);
          			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
          			            
          		    		//   }
          		    	 	
          		           } else {
          		         
          		    	 		// model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
          		               return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));   
          		    	   }
              		   
          	      
          	       } else { 
          	    	 
          	           return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage")); 
          	       }
              	 } catch (Exception ex) {
              	     ex.printStackTrace();
              	     logger.error("EXCEPTION calling actionLogin(): "+ex);
              	     return  new ModelAndView("redirect:" + ssoGlobals.get("PayGen.SSOLinkPage"));  // + "/ExTermsPage.do"
                   }
              	  
              	//return strRtn; 
          }   
          
          
       /***********************************************************************************************************************
        * 희망정보시스템 세올인사랑 설정 정보 처리 수정 반영을 위한 로직 추가 
        ************************************************************************************************************************/
        
       
       /**
   	 * 희망정보시스템 로그인 처리 param 값을 통해처리 
   	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
   	 * @param request - 세션처리를 위한 HttpServletRequest
   	 * @return result - 로그인결과(세션정보)
   	 * @exception Exception
   	 */
       @RequestMapping(value="/SSOLogin/SSOHmrLogin.do")
       public ModelAndView actionSeolParamLogin(@RequestParam(value="ssoUsrId", required=false) String ssoUsrId, 
       		                   HttpServletRequest request,
       		                   ModelMap model)
               throws Exception {   
       	 
    	   SsoConf.setSsoConfigFile(PropConfs.SSO_HMR_CONFIG_FILE);
       	   final HashMap<String, String> ssoGlobals = SsoConf.getPayGenSsoConfigInfo(sevltConfig , request);   
       	    
       	    LoginVO loginVo = new LoginVO();
       	   // String strRtn = "redirect:/ExTermsPage.do";
       	    String encrypted = "";
       	    String origin_data = ""; //복호화된 값을 저장할 별수
           	try {   
           	   if (ssoUsrId != null &&  !ssoUsrId.equals("")) {
       	    	  
           		    encrypted = ssoUsrId;
           		 //   LOG.debug("data-sso : " + ssoUsrId);
           		    origin_data = encrypted;
           		    
           		   if (ssoUsrId.equals("vision")) {
           			   
//           	     try {
//              			
//          	    	    origin_data = crypt.dec(encrypted);
//          	    	    
//              		 } catch (Exception ex) {
//              			
//              			return "redirect:/cmm/main/mainPage.do"; 
//              		 }
           			   
       
           			   SsoxUserVO resultVO = new SsoxUserVO(); 
       	    		   loginVo.setSsoUsrId(origin_data);   
       		    	  // 1. 일반 로그인 처리 - 
//       	    		   SsoxUserVO sysmVO = ssoLoginService.actionSSOLogin(loginVo); 
//       	    		   
//       	    		   if (sysmVO != null && sysmVO.getUserId()  != null && !sysmVO.getUserId().equals("")) { 
//       	    		  
//       	    			    resultVO.setUserId(sysmVO.getUserId());
//       	        			resultVO.setSsoUseType(ssoGlobals.get("Globals.SsoUseType"));
//       	        			resultVO.setSsoLinkType(ssoGlobals.get("Globals.SsoLinkType"));
//       	    			   
//       	    		   } else {   
//       	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
//       	    		   }
       	    		   resultVO.setUserId(loginVo.getSsoUsrId());
       	    		   resultVO.setSsoUseType(ssoGlobals.get("Globals.SsoUseType"));
   	        		   resultVO.setSsoLinkType(ssoGlobals.get("Globals.SsoLinkType"));
       	    		   SsoxUserVO rtnSsoUsrVO  = ssoxUserService.selectSsoxUser(resultVO); 
       	    		  
       	    		   
       	    		   if (rtnSsoUsrVO != null && rtnSsoUsrVO.getUserId()  != null && !rtnSsoUsrVO.getUserId().equals("")) {  

   								resultVO.setUserId(rtnSsoUsrVO.getUserId());    /** column null : userId */
   								resultVO.setUserName(rtnSsoUsrVO.getUserName());    /** column null : userName */
   								resultVO.setUserSn(rtnSsoUsrVO.getUserSn());    /** column null : userSn */
   								resultVO.setUserStat(rtnSsoUsrVO.getUserStat());    /** column null : userStat */
   								resultVO.setUserStatName(rtnSsoUsrVO.getUserStatName());    /** column null : userStatName */
   								resultVO.setRegularity(rtnSsoUsrVO.getRegularity());    /** column null : regularity */
   								resultVO.setOrgId(rtnSsoUsrVO.getOrgId());    /** column null : orgId */
   								resultVO.setOrgName(rtnSsoUsrVO.getOrgName());    /** column null : orgName */
   								resultVO.setDeptId(rtnSsoUsrVO.getDeptId());    /** column null : deptId */
   								resultVO.setDeptName(rtnSsoUsrVO.getDeptName());    /** column null : deptName */
   								resultVO.setDeptFullname(rtnSsoUsrVO.getDeptFullname());    /** column null : deptFullname */
   								resultVO.setClassId(rtnSsoUsrVO.getClassId());    /** column null : classId */
   								resultVO.setClassName(rtnSsoUsrVO.getClassName());    /** column null : className */
   								resultVO.setPositionId(rtnSsoUsrVO.getPositionId());    /** column null : positionId */
   								resultVO.setPositionName(rtnSsoUsrVO.getPositionName());    /** column null : positionName */
   								resultVO.setGradeId(rtnSsoUsrVO.getGradeId());    /** column null : gradeId */
   								resultVO.setGradeName(rtnSsoUsrVO.getGradeName());    /** column null : gradeName */
   								resultVO.setEmail(rtnSsoUsrVO.getEmail());    /** column null : email */
   								resultVO.setTel(rtnSsoUsrVO.getTel());    /** column null : tel */
   								resultVO.setMobile(rtnSsoUsrVO.getMobile());    /** column null : mobile */
   								resultVO.setJoinDay(rtnSsoUsrVO.getJoinDay());    /** column null : joinDay */
   								resultVO.setRetireDay(rtnSsoUsrVO.getRetireDay());    /** column null : retireDay */
   								resultVO.setAddInfo1(rtnSsoUsrVO.getAddInfo1());    /** column null : addInfo1 */
   								resultVO.setAddInfo2(rtnSsoUsrVO.getAddInfo2());    /** column null : addInfo2 */
   								resultVO.setAddInfo3(rtnSsoUsrVO.getAddInfo3());    /** column null : addInfo3 */
   								resultVO.setAddInfo4(rtnSsoUsrVO.getAddInfo4());    /** column null : addInfo4 */
   								resultVO.setAddInfo5(rtnSsoUsrVO.getAddInfo5());    /** column null : addInfo5 */
   								resultVO.setAddInfo6(rtnSsoUsrVO.getAddInfo6());    /** column null : addInfo6 */
   								resultVO.setAddInfo7(rtnSsoUsrVO.getAddInfo7());    /** column null : addInfo7 */
   								resultVO.setBaseSys(rtnSsoUsrVO.getBaseSys());    /** column null : baseSys */
   								resultVO.setRegDay(rtnSsoUsrVO.getRegDay());    /** column null : regDay */
   								resultVO.setUpdateDay(rtnSsoUsrVO.getUpdateDay());    /** column null : updateDay */
   								resultVO.setUseYn(rtnSsoUsrVO.getUseYn());    /** column null : useYn */
   								resultVO.setRdutyName(rtnSsoUsrVO.getRdutyName());    /** column null : rdutyName */
   								 
       	    			   
       	    		   } else {   
       	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
       	    		   }
       	    		   
       		           if (resultVO != null && resultVO.getUserId()  != null && !resultVO.getUserId().equals("")) { 	
       		        	   request.getSession().setAttribute("ssoxUserVO", resultVO);  
       		               return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage")); 
       		           } else {
       		        	   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
       		           }
           		   }  else {    
           			   
           			   SsoxUserVO resultVO = new SsoxUserVO(); 
       	    		   loginVo.setSsoUsrId(origin_data);   
       		    	  // 1. 일반 로그인 처리 - 
//       	    		   SsoxUserVO sysmVO = ssoLoginService.actionSSOLogin(loginVo); 
//       	    		   
//       	    		   if (sysmVO != null && sysmVO.getUserId()  != null && !sysmVO.getUserId().equals("")) { 
//       	    		  
//       	    			    resultVO.setUserId(sysmVO.getUserId());
//       	    				resultVO.setSsoUseType(ssoGlobals.get("Globals.SsoUseType"));
//       	        			resultVO.setSsoLinkType(ssoGlobals.get("Globals.SsoLinkType"));
//      	        			
//       	    		   } else {   
//       	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
//       	    		   }
       	    		   resultVO.setUserId(loginVo.getSsoUsrId());
       	    		   resultVO.setSsoUseType(ssoGlobals.get("Globals.SsoUseType"));
   	        			resultVO.setSsoLinkType(ssoGlobals.get("Globals.SsoLinkType"));
       	    		   SsoxUserVO rtnSsoUsrVO  = ssoxUserService.selectSsoxUser(resultVO);
       	    		 
       	    		   if (rtnSsoUsrVO != null && rtnSsoUsrVO.getUserId()  != null && !rtnSsoUsrVO.getUserId().equals("")) {  

   								resultVO.setUserId(rtnSsoUsrVO.getUserId());    /** column null : userId */
   								resultVO.setUserName(rtnSsoUsrVO.getUserName());    /** column null : userName */
   								resultVO.setUserSn(rtnSsoUsrVO.getUserSn());    /** column null : userSn */
   								resultVO.setUserStat(rtnSsoUsrVO.getUserStat());    /** column null : userStat */
   								resultVO.setUserStatName(rtnSsoUsrVO.getUserStatName());    /** column null : userStatName */
   								resultVO.setRegularity(rtnSsoUsrVO.getRegularity());    /** column null : regularity */
   								resultVO.setOrgId(rtnSsoUsrVO.getOrgId());    /** column null : orgId */
   								resultVO.setOrgName(rtnSsoUsrVO.getOrgName());    /** column null : orgName */
   								resultVO.setDeptId(rtnSsoUsrVO.getDeptId());    /** column null : deptId */
   								resultVO.setDeptName(rtnSsoUsrVO.getDeptName());    /** column null : deptName */
   								resultVO.setDeptFullname(rtnSsoUsrVO.getDeptFullname());    /** column null : deptFullname */
   								resultVO.setClassId(rtnSsoUsrVO.getClassId());    /** column null : classId */
   								resultVO.setClassName(rtnSsoUsrVO.getClassName());    /** column null : className */
   								resultVO.setPositionId(rtnSsoUsrVO.getPositionId());    /** column null : positionId */
   								resultVO.setPositionName(rtnSsoUsrVO.getPositionName());    /** column null : positionName */
   								resultVO.setGradeId(rtnSsoUsrVO.getGradeId());    /** column null : gradeId */
   								resultVO.setGradeName(rtnSsoUsrVO.getGradeName());    /** column null : gradeName */
   								resultVO.setEmail(rtnSsoUsrVO.getEmail());    /** column null : email */
   								resultVO.setTel(rtnSsoUsrVO.getTel());    /** column null : tel */
   								resultVO.setMobile(rtnSsoUsrVO.getMobile());    /** column null : mobile */
   								resultVO.setJoinDay(rtnSsoUsrVO.getJoinDay());    /** column null : joinDay */
   								resultVO.setRetireDay(rtnSsoUsrVO.getRetireDay());    /** column null : retireDay */
   								resultVO.setAddInfo1(rtnSsoUsrVO.getAddInfo1());    /** column null : addInfo1 */
   								resultVO.setAddInfo2(rtnSsoUsrVO.getAddInfo2());    /** column null : addInfo2 */
   								resultVO.setAddInfo3(rtnSsoUsrVO.getAddInfo3());    /** column null : addInfo3 */
   								resultVO.setAddInfo4(rtnSsoUsrVO.getAddInfo4());    /** column null : addInfo4 */
   								resultVO.setAddInfo5(rtnSsoUsrVO.getAddInfo5());    /** column null : addInfo5 */
   								resultVO.setAddInfo6(rtnSsoUsrVO.getAddInfo6());    /** column null : addInfo6 */
   								resultVO.setAddInfo7(rtnSsoUsrVO.getAddInfo7());    /** column null : addInfo7 */
   								resultVO.setBaseSys(rtnSsoUsrVO.getBaseSys());    /** column null : baseSys */
   								resultVO.setRegDay(rtnSsoUsrVO.getRegDay());    /** column null : regDay */
   								resultVO.setUpdateDay(rtnSsoUsrVO.getUpdateDay());    /** column null : updateDay */
   								resultVO.setUseYn(rtnSsoUsrVO.getUseYn());    /** column null : useYn */
   								resultVO.setRdutyName(rtnSsoUsrVO.getRdutyName());    /** column null : rdutyName */
   								 
       	    		   } else {   
       	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
       	    		   }
       	    		   
       		           if (resultVO != null && resultVO.getUserId()  != null && !resultVO.getUserId().equals("")) { 
       		        	   
       		        	   //특성사용자 구분시 특정페이지호출시 사용 
       		    		   //if ("99901".equals(resultVO.getClassId()) || "99902".equals(resultVO.getClassId())) {
       		    			   
       		    		      // return "redirect:" + Globals.MY_URL_PAGE + "?strWebId=" + resultVO.getUserId(); Globals.MY_URL_PAGE
       		    		    //   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.MyUrlPage")  + "?strWebId=" + resultVO.getUserId()); 
       		    		  // } else { 
       		    		  
       			        	// 2-1. 로그인 정보를 세션에 저장
       			          	 request.getSession().setAttribute("ssoxUserVO", resultVO); 
       			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage")); 
       			          	
       		    		   //}
       		    	 	
       		           } else {
       		    	 		 
       		    	 		// model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
       		               return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
       		    	   }
           		   }
       	      
       	       } else { 
       	           return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage")); 
       	       }
           	 } catch (Exception ex) {
           	     ex.printStackTrace();
           	     logger.error("EXCEPTION calling actionLogin(): "+ex);
           	     return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));  // + "/ExTermsPage.do"
                }
           	  
           	//return strRtn;
           	  
               
       }   
       
       
         /**
          *  세션값을 통해처리 되는 값  
          * @param request
          * @param model
          * @param httpSession
          * @return
          * @throws Exception
          */
          @RequestMapping(value="/SSOLogin/ATTRHmrLogin.do")
          public ModelAndView actionSeolSessionLogin(HttpServletRequest request,
          		                   ModelMap model,HttpSession httpSession )
                  throws Exception {  
          	 
       	    String attrSsoUsrId = "";
       	    String ssoUsrId = "";
       	    
       	    request.getSession().setAttribute("ssoxUserVO", null);  
       	    
          	    HttpSession session = request.getSession();
          	
//          		int i=0;
//             
//   	        Enumeration e1 = session.getAttributeNames();
//   	         
//   	       	while(e1.hasMoreElements()){
   //	
//   	       		String sname = (String) e1.nextElement();
//   	       		String svalue = session.getAttribute(sname).toString();
//   	       	    logger.debug("ssolog sesion : " + "["+ i +"]"+sname+"=["+ i +"]"+svalue+"<br>");
//   	       		i++;
   //	
//   	       	}
//   	       	
//   	        Enumeration e = httpSession.getAttributeNames();
//   	        
//              i=0;
   // 
//   	       	while(e.hasMoreElements()){
   //	
//   	       		String sname = (String) e.nextElement();
//   	       		String svalue = httpSession.getAttribute(sname).toString();
//   	       	    logger.debug("ssolog sesion2 : " + "["+ i +"]"+sname+"=["+ i +"]"+svalue+"<br>");
//   	       		i++;
   //	
//   	       	} 
          	
          	    attrSsoUsrId = String.valueOf(session.getAttribute("ssoUsrId")); 
          	    
          	    logger.debug("ssolog : " + attrSsoUsrId);
          	    System.out.println("chk_sso_data1" + attrSsoUsrId);  
          	    
          	    if (attrSsoUsrId != null &&  !attrSsoUsrId.equals("")) { 
          	    	
          	    	ssoUsrId = attrSsoUsrId;
          	    	
          	    } else {	
          	    	 
          	         ssoUsrId = String.valueOf(httpSession.getAttribute("ssoUsrId"));
          	    }
          	   
          	    logger.debug("ssolog2 : " + ssoUsrId);
             
          	    SsoConf.setSsoConfigFile(PropConfs.SSO_HMR_CONFIG_FILE);
          	   final HashMap<String, String> ssoGlobals = SsoConf.getPayGenSsoConfigInfo(sevltConfig , request);   
          	
                   ///SSOLogin/SSOLogin.do?ssoUsrId=portal01
          	    LoginVO loginVo = new LoginVO();
          	   // String strRtn = "redirect:/ExTermsPage.do";
          	    String encrypted = "";
          	    String origin_data = ""; //복호화된 값을 저장할 별수
              	try {   
              		
              	   if (ssoUsrId != null &&  !ssoUsrId.equals("")) {
              		   
              		
              		 logger.debug("ssolog7 : " + ssoUsrId);
              		    encrypted = ssoUsrId;
              		 //   LOG.debug("data-sso : " + ssoUsrId);
              		    origin_data = encrypted;
              		    
              		               			   
              			   SsoxUserVO resultVO = new SsoxUserVO(); 
          	    		   loginVo.setSsoUsrId(origin_data);   
          		    	  // 1. 일반 로그인 처리 - 무기계약직 호출 
//          	    		   SsoxUserVO sysmVO = ssoLoginService.actionSSOLogin(loginVo); 
//          	    		   
//          	    		   if (sysmVO != null && sysmVO.getUserId()  != null && !sysmVO.getUserId().equals("")) { 
//          	    		  
//          	    			    resultVO.setUserId(sysmVO.getUserId());
//          	    				resultVO.setSsoUseType(ssoGlobals.get("Globals.SsoUseType"));
//       	        			resultVO.setSsoLinkType(ssoGlobals.get("Globals.SsoLinkType"));
//         	        			
//          	    		   } else {   
//          	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
//          	    		   }
          	    		   resultVO.setUserId(loginVo.getSsoUsrId());
          	    		   resultVO.setSsoUseType(ssoGlobals.get("Globals.SsoUseType"));
   	        		   resultVO.setSsoLinkType(ssoGlobals.get("Globals.SsoLinkType"));
          	    		   SsoxUserVO rtnSsoUsrVO  = ssoxUserService.selectSsoxUser(resultVO);
          	    		  
          	    		   if (rtnSsoUsrVO != null && rtnSsoUsrVO.getUserId()  != null && !rtnSsoUsrVO.getUserId().equals("")) {  

      								resultVO.setUserId(rtnSsoUsrVO.getUserId());    /** column null : userId */
      								resultVO.setUserName(rtnSsoUsrVO.getUserName());    /** column null : userName */
      								resultVO.setUserSn(rtnSsoUsrVO.getUserSn());    /** column null : userSn */
      								resultVO.setUserStat(rtnSsoUsrVO.getUserStat());    /** column null : userStat */
      								resultVO.setUserStatName(rtnSsoUsrVO.getUserStatName());    /** column null : userStatName */
      								resultVO.setRegularity(rtnSsoUsrVO.getRegularity());    /** column null : regularity */
      								resultVO.setOrgId(rtnSsoUsrVO.getOrgId());    /** column null : orgId */
      								resultVO.setOrgName(rtnSsoUsrVO.getOrgName());    /** column null : orgName */
      								resultVO.setDeptId(rtnSsoUsrVO.getDeptId());    /** column null : deptId */
      								resultVO.setDeptName(rtnSsoUsrVO.getDeptName());    /** column null : deptName */
      								resultVO.setDeptFullname(rtnSsoUsrVO.getDeptFullname());    /** column null : deptFullname */
      								resultVO.setClassId(rtnSsoUsrVO.getClassId());    /** column null : classId */
      								resultVO.setClassName(rtnSsoUsrVO.getClassName());    /** column null : className */
      								resultVO.setPositionId(rtnSsoUsrVO.getPositionId());    /** column null : positionId */
      								resultVO.setPositionName(rtnSsoUsrVO.getPositionName());    /** column null : positionName */
      								resultVO.setGradeId(rtnSsoUsrVO.getGradeId());    /** column null : gradeId */
      								resultVO.setGradeName(rtnSsoUsrVO.getGradeName());    /** column null : gradeName */
      								resultVO.setEmail(rtnSsoUsrVO.getEmail());    /** column null : email */
      								resultVO.setTel(rtnSsoUsrVO.getTel());    /** column null : tel */
      								resultVO.setMobile(rtnSsoUsrVO.getMobile());    /** column null : mobile */
      								resultVO.setJoinDay(rtnSsoUsrVO.getJoinDay());    /** column null : joinDay */
      								resultVO.setRetireDay(rtnSsoUsrVO.getRetireDay());    /** column null : retireDay */
      								resultVO.setAddInfo1(rtnSsoUsrVO.getAddInfo1());    /** column null : addInfo1 */
      								resultVO.setAddInfo2(rtnSsoUsrVO.getAddInfo2());    /** column null : addInfo2 */
      								resultVO.setAddInfo3(rtnSsoUsrVO.getAddInfo3());    /** column null : addInfo3 */
      								resultVO.setAddInfo4(rtnSsoUsrVO.getAddInfo4());    /** column null : addInfo4 */
      								resultVO.setAddInfo5(rtnSsoUsrVO.getAddInfo5());    /** column null : addInfo5 */
      								resultVO.setAddInfo6(rtnSsoUsrVO.getAddInfo6());    /** column null : addInfo6 */
      								resultVO.setAddInfo7(rtnSsoUsrVO.getAddInfo7());    /** column null : addInfo7 */
      								resultVO.setBaseSys(rtnSsoUsrVO.getBaseSys());    /** column null : baseSys */
      								resultVO.setRegDay(rtnSsoUsrVO.getRegDay());    /** column null : regDay */
      								resultVO.setUpdateDay(rtnSsoUsrVO.getUpdateDay());    /** column null : updateDay */
      								resultVO.setUseYn(rtnSsoUsrVO.getUseYn());    /** column null : useYn */
      								resultVO.setRdutyName(rtnSsoUsrVO.getRdutyName());    /** column null : rdutyName */
      								 
          	    		   } else {   
          	    			 logger.debug("ssolog6 : " + ssoUsrId); 
          	    			   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
          	    		   }
          	    		   
          		           if (resultVO != null && resultVO.getUserId()  != null && !resultVO.getUserId().equals("")) { 
          		        	   
          		        	   
          		    		  // if ("99901".equals(resultVO.getClassId()) || "99902".equals(resultVO.getClassId())) {
          		    			   
          		    		      // return "redirect:" + Globals.MY_URL_PAGE + "?strWebId=" + resultVO.getUserId(); Globals.MY_URL_PAGE
          		    		   //    return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.MyUrlPage")  + "?strWebId=" + resultVO.getUserId()); 
          		    		  // } else { 
          		        	 logger.debug("ssolog5 : " + ssoUsrId);
          			        	// 2-1. 로그인 정보를 세션에 저장
          		        	      
          			          	 request.getSession().setAttribute("ssoxUserVO", resultVO); 
          			          	 return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage")); 
          			          	
          		    		  // }
          		    	 	
          		           } else {
          		        	 logger.debug("ssolog4 : " + ssoUsrId);
          		            	 
          		    	 		// model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
          		               return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));   
          		    	   }
              		   
          	      
          	       } else { 
          	    	   logger.debug("ssolog3 : " + ssoUsrId);
          	    	  
          	    	   return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage")); 
          	       }
              	   
              	 } catch (Exception ex) {
              	     ex.printStackTrace();
              	     logger.error("EXCEPTION calling actionLogin(): "+ex);
                    
              	     return  new ModelAndView("redirect:" + ssoGlobals.get("Globals.SSOLinkPage"));  // + "/ExTermsPage.do"
                   }
              	  
              	//return strRtn;
              	  
                  
          }   
      
    
}
