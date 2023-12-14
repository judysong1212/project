package com.smrmf.exterms.mypage.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.smrmf.sysm.server.vo.system.LoginVO;
import com.smrmf.exterms.mypage.login.service.PayGenLoginService;

import egovframework.com.cmm.EgovComponentChecker;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.cmm.service.Globals;

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
@SessionAttributes(types=LoginVO.class)
public class PayGenLoginController {


    /** LoginService */
	@Resource(name = "PayGenLoginService")
    private PayGenLoginService myLoginService;
 
    
	/** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
	/** log */
    protected static final Log LOG = LogFactory.getLog(PayGenLoginController.class);
    
	/**
	 * 로그인 화면으로 들어간다
	 * @param vo - 로그인후 이동할 URL이 담긴 LoginVO
	 * @return 로그인 페이지
	 * @exception Exception
	 */
    @IncludedInfo(name="로그인", listUrl="/login/Login.do", order = 10, gid = 10)
    @RequestMapping(value="/login/Login.do")
	public String loginUsrView(@ModelAttribute("loginVO") LoginVO loginVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) 
			throws Exception {
    	if(EgovComponentChecker.hasComponent("mberManageService")){
    		model.addAttribute("useMemberManage", "true");
    	}
    	/*
		GPKIHttpServletResponse gpkiresponse = null;
	    GPKIHttpServletRequest gpkirequest = null;
	    
	    try{
	    
	    	gpkiresponse=new GPKIHttpServletResponse(response); 
		    gpkirequest= new GPKIHttpServletRequest(request);
	        gpkiresponse.setRequest(gpkirequest);
	        model.addAttribute("challenge", gpkiresponse.getChallenge());
	        return "egovframework/com/uat/uia/EgovLoginUsr";
	        
	    }catch(Exception e){
	        return "egovframework/com/cmm/egovError";
	    }
	    */
    	return "/mypage/login/Login";
	}
	
    /**
	 * 일반(세션) 로그인을 처리한다
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
    @RequestMapping(value="/login/actionLogin.do")
    public String actionLogin(@ModelAttribute("loginVO") LoginVO loginVO, 
    		                   HttpServletRequest request,
    		                   ModelMap model)
            throws Exception { 

    	// 1. 일반 로그인 처리
        LoginVO resultVO = myLoginService.actionLogin(loginVO); 
		
        if (resultVO != null && resultVO.getUsrId() != null && !resultVO.getUsrId().equals("")) {
        	
        	// 2-1. 로그인 정보를 세션에 저장
        	request.getSession().setAttribute("loginVO", resultVO);

    		return "redirect:/main/Main.do";
      
        } else {
        	
        	model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
        	return "/mypage/login/Login";
        }
    }   
     
    
    /**
     * sso 처리를 위한  업무시스템 호출을 하는 부분...
     * @param model
     * @return
     * @throws Exception
     */
  @RequestMapping(value="/ExTermsPage.do")  
  public String actionMain(ModelMap model)  throws Exception { 
	  
	// 1. Spring Security 사용자권한 처리
//  	Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
//  	if(!isAuthenticated) {
//  		model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
//      	return "/mypage/login/Login";
//  	}
  	//LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser(); 
  	/*
  	// 2. 메뉴조회
	MenuManageVO menuManageVO = new MenuManageVO();
  	menuManageVO.setTmp_Id(user.getId());
  	menuManageVO.setTmp_UserSe(user.getUserSe());
  	menuManageVO.setTmp_Name(user.getName());
  	menuManageVO.setTmp_Email(user.getEmail());
  	menuManageVO.setTmp_OrgnztId(user.getOrgnztId());
  	menuManageVO.setTmp_UniqId(user.getUniqId());
  	List list_headmenu = menuManageService.selectMainMenuHead(menuManageVO);
	model.addAttribute("list_headmenu", list_headmenu);
  	*/
	   
		// 3. 메인 페이지 이동
		String exterms_page = Globals.EXTERMS_PAGE;
		
		//model.put("curLinkUrl", main_page);  //현재 페이지에 따른 값을 처리하기위해 추가 
		
		if (exterms_page.startsWith("/")) {
		    return "forward:" + exterms_page;
		} else {
		    return exterms_page;
		} 

}
       
//    /**
//	 * 로그인 후 메인화면으로 들어간다
//	 * @param 
//	 * @return 로그인 페이지
//	 * @exception Exception
//	 */
//    @RequestMapping(value="/main/Main.do")
//	public String actionMain(ModelMap model) 
//			throws Exception {
//    	
//    	// 1. Spring Security 사용자권한 처리
//    	Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
//    	if(!isAuthenticated) {
//    		model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
//        	return "/mypage/login/Login";
//    	}
//    	//LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
//    	
//    	/*
//    	// 2. 메뉴조회
//		MenuManageVO menuManageVO = new MenuManageVO();
//    	menuManageVO.setTmp_Id(user.getId());
//    	menuManageVO.setTmp_UserSe(user.getUserSe());
//    	menuManageVO.setTmp_Name(user.getName());
//    	menuManageVO.setTmp_Email(user.getEmail());
//    	menuManageVO.setTmp_OrgnztId(user.getOrgnztId());
//    	menuManageVO.setTmp_UniqId(user.getUniqId());
//    	List list_headmenu = menuManageService.selectMainMenuHead(menuManageVO);
//		model.addAttribute("list_headmenu", list_headmenu);
//    	*/
//    	
//		// 3. 메인 페이지 이동
//		String main_page = Globals.MAIN_PAGE;
//		
//		//model.put("curLinkUrl", main_page);  //현재 페이지에 따른 값을 처리하기위해 추가
//		
//		LOG.debug("Globals.MAIN_PAGE > " +  Globals.MAIN_PAGE);
//		LOG.debug("main_page > " +  main_page);
//		  
//		
//		if (main_page.startsWith("/")) {
//		    return "forward:" + main_page;
//		} else {
//		    return main_page;
//		} 
//	 
//	}
    
    /**
	 * 로그아웃한다.
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping(value="/login/actionLogout.do")
	public String actionLogout(HttpServletRequest request, ModelMap model) 
			throws Exception {
    	
    	/*String userIp = EgovClntInfo.getClntIP(request);
    	
    	// 1. Security 연동
    	return "redirect:/j_spring_security_logout";*/
    	
    	request.getSession().setAttribute("loginVO", null);
    	
    	
    	return "redirect:/main/MainPage.do";
    }
   
    /**
	 * 아이디/비밀번호 찾기 화면으로 들어간다
	 * @param 
	 * @return 아이디/비밀번호 찾기 페이지
	 * @exception Exception
	 */
//	@RequestMapping(value="/uat/uia/egovIdPasswordSearch.do")
//	public String idPasswordSearchView(ModelMap model) 
//			throws Exception {
//		
//		// 1. 비밀번호 힌트 공통코드 조회
//		ComDefaultCodeVO vo = new ComDefaultCodeVO();
//		vo.setCommCd("COM022");
//		List code = cmmUseService.selectCmmCodeDetail(vo);
//		model.addAttribute("pwhtCdList", code);
//		
//		return "/egovframework/com/uat/uia/EgovIdPasswordSearch";
//	}
	 
    /**
	 * 아이디를 찾는다.
	 * @param vo - 이름, 이메일주소, 사용자구분이 담긴 LoginVO
	 * @return result - 아이디
	 * @exception Exception
	 */
    @RequestMapping(value="/uat/uia/searchId.do")
    public String searchId(@ModelAttribute("loginVO") LoginVO loginVO, 
    		ModelMap model)
            throws Exception {
    	
//    	if (loginVO == null || loginVO.getUserNm() == null || loginVO.getUserNm().equals("")
//    		&& loginVO.getUsrEmail() == null || loginVO.getUsrEmail().equals("")
//    		&& loginVO.getOrgYn() == null || loginVO.getOrgYn().equals("")
//    	) {
//    		return "/egovframework/com/cmm/egovError";
//    	}
//    	
//    	// 1. 아이디 찾기
//    	loginVO.setUserNm(loginVO.getUserNm().replaceAll(" ", ""));
//        LoginVO resultVO = loginService.searchId(loginVO);
//        
//        if (resultVO != null && resultVO.getUserId() != null && !resultVO.getUserId().equals("")) {
//        	
//        	model.addAttribute("resultInfo", "아이디는 " + resultVO.getUserId() + " 입니다.");
//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
//        } else {
//        	model.addAttribute("resultInfo", egovMessageSource.getMessage("fail.common.idsearch"));
//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
//        }
    	return "";
    }
    
    /**
	 * 비밀번호를 찾는다.
	 * @param vo - 아이디, 이름, 이메일주소, 비밀번호 힌트, 비밀번호 정답, 사용자구분이 담긴 LoginVO
	 * @return result - 임시비밀번호전송결과
	 * @exception Exception
	 */
    @RequestMapping(value="/uat/uia/searchPassword.do")
    public String searchPassword(@ModelAttribute("loginVO") LoginVO loginVO, 
    		ModelMap model)
            throws Exception {
    	
//    	if (loginVO == null || loginVO.getUserId() == null || loginVO.getUserId().equals("")
//    		&& loginVO.getUserNm() == null || loginVO.getUserNm().equals("")
//    		&& loginVO.getUsrEmail() == null || loginVO.getUsrEmail().equals("")
//    		//&& loginVO.getPasswordHint() == null || loginVO.getPasswordHint().equals("")
//    		//&& loginVO.getPasswordCnsr() == null || loginVO.getPasswordCnsr().equals("")
//    		&& loginVO.getOrgYn() == null || loginVO.getOrgYn().equals("")
//    	) {
//    		return "/egovframework/com/cmm/egovError";
//    	}
//    	
//    	// 1. 비밀번호 찾기
//        boolean result = loginService.searchPassword(loginVO);
//        
//        // 2. 결과 리턴
//        if (result) {
//        	model.addAttribute("resultInfo", "임시 비밀번호를 발송하였습니다.");
//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
//        } else {
//        	model.addAttribute("resultInfo", egovMessageSource.getMessage("fail.common.pwsearch"));
//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
//        }
    	return "";
    }

}
