/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.User;
import org.springframework.stereotype.Service;
//import com.app.smrmf.core.msfmainapp.server.hibernate.SessionManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.any.smrmf.utils.SessionUtil;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFAuthCheckBM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0300BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.SysIfSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginService;
import com.app.smrmf.core.msfmainapp.server.service.dao.LogHistoryServiceDAO;
import com.app.smrmf.core.msfmainapp.server.service.dao.LoginServiceDAO;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysm.server.service.dao.Sysm0100DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0500VO;
import com.app.smrmf.sysm.server.vo.system.MSFAuthCheckVO;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;
import com.crypto.service.AnyCryptService;
import com.ext.constants.PropConfs;
import com.extjs.gxt.ui.client.widget.MessageBox;

@Service("LoginService")
public class LoginServiceImpl extends AbstractCustomServiceImpl implements LoginService {
    	
	// 중복로그인추가
	private static final Map<String, HttpSession> activeSessions = new ConcurrentHashMap<String, HttpSession>();
	// 끝
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(LoginServiceImpl.class);
	private static final String calledClass = LoginServiceImpl.class.getName();

	@Autowired
	@Resource(name = "LoginServiceDAO")
	private LoginServiceDAO loginServiceDAO;
	
	@Autowired
	@Resource(name = "Sysm0100DAO")
	private Sysm0100DAO sysm0100DAO;
	
	/** 암호화 모듈 호출 */
	@Autowired
	@Resource(name = "AnyCryptService")
	protected AnyCryptService payGenCryptService;

	// 비밀번호 변경하는 코드(로그인했을 때) *****************************************************기능 수정_hieju/06.13
    
	@SuppressWarnings("unused")
	public Long changePassword(String userId, String oldPwd, String newPwd) {
		String pwChkCryptSHA512 = "";
		String calledMethod = calledClass + "changePassword";
		String calledMethod2 = calledClass + "checkUsr";
		Long result = new Long(1);
		 MSFSysm0100BM user = new MSFSysm0100BM();
        SysIfSysm0100VO srhUser = new SysIfSysm0100VO();
        ShowMessageBM bm = new ShowMessageBM();
        MSFSysm0100DTO sysm0100Login = new MSFSysm0100DTO();
        MSFUserInfoVO webUserInfo = new MSFUserInfoVO();  
        
        
        try {

        		if  (MSFSharedUtils.paramNull(loginServiceDAO)) {
    	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	        			 getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalSession().getServletContext()); 

	        	loginServiceDAO = (LoginServiceDAO) wac.getBean("LoginServiceDAO"); 
	        }

           srhUser.setSysDivCd(""); // 데이터베이스에서 사용자 조회
           srhUser.setUsrId(userId);
           srhUser.setPwd(oldPwd); // newPwd
           
        SysIfSysm0100VO admUser = loginServiceDAO.selectSysm0100(srhUser);
       
        if (admUser == null) { // 사용자가 다를 경우 로그인을 막음
        	sysm0100Login = new MSFSysm0100DTO(
                    user, 
                    "-2", 
                    "UserNonEsiste",
                    new Date(),
                    bm);
        	
        // 계정이 잠겨있는 경우, 로그인을 막음._hieju/05.30
        } else if ("Y".equals(admUser.getLockat())) {
		sysm0100Login = new MSFSysm0100DTO(user, "-2", "UserNonEsiste",
				new Date(), bm); 
					
		}else{
					
		}
        	 
        	
    	if (MSFSharedUtils.allowNulls(oldPwd).equals(admUser.getPwd())) { // 비밀번호 유효성 검사(비밀번호가 서로 일치하면)
    		pwChkCryptSHA512 = MSFSharedUtils.allowNulls(oldPwd);
    		
   		 
    	}else{ // 비밀번호가 일치하지 않으면 
    		pwChkCryptSHA512 = payGenCryptService.payGenEncryptSHA256(MSFSharedUtils.allowNulls(oldPwd));
    		
    	}
    	
        if ( pwChkCryptSHA512.equals(admUser.getPwd())){//valid ) { // 암호화된 비밀번호랑 사용자의 비밀번호가 일치하는 경우, 
        	
        	//암호화 모듈적용으로 추가 
        	admUser.setPwd(newPwd); // 새로운 비밀번호
        	pwChkCryptSHA512 = payGenCryptService.payGenEncryptSHA256(MSFSharedUtils.allowNulls(newPwd)); // 비밀번호 암호화
        	
        	
        	BeanUtils.copyProperties(admUser, webUserInfo);
        	}else{ // 이전 비밀번호가 일치하지 않을 경우,
        		return new Long(-1);
        	}
     
        try{ 
        
    	user = new MSFSysm0100BM(
        		admUser.getDpobCd(),
        		admUser.getSysDivCd(), 
        		admUser.getSysDivNm(), 
        		admUser.getUsrId(), 
        		admUser.getUsrNm(),
        		admUser.getUsrDivCd(), 
        		admUser.getUsrDivNm(), 
        		admUser.getDeptCd(),
        		admUser.getDeptNm(),
        		//admUser.getTypOccuCd(),
        		//admUser.getTypOccuNm(),
        	    //admUser.getPyspGrdeCd(),
        	    //admUser.getPyspGrdeNm(),
        		admUser.getUsrTel(), 
        		admUser.getTplvlDeptCd() ,
        		admUser.getTplvlDeptNm() ,
        		admUser.getPayrMangDeptCd(),
        		admUser.getPayrMangDeptNm(),
        		admUser.getMangeDeptCd(),
        		admUser.getMangeDeptNm(),
        		admUser.getPayrMangDeptYn(),
        		admUser.getYrtxInptPrcsYn(),
        		admUser.getEmail(), 
        		admUser.getPwd(), 
        		admUser.getUseYn(),
        		admUser.getLockat(), // 추가 hieju_05.31
        		admUser.getLogincnt(),
        		admUser.getPwddate(),
        		admUser.getInptDt()
        		);
    	
    	admUser.setPwd(newPwd); // 새 비밀번호로 변경
    	admUser.setPwd(pwChkCryptSHA512); // 비밀번호 암호화
    	
    	// 비밀번호 변경 후 90일 지났는지 확인하는 로직_hieju/05.30
        String lastPasswordChangeDateString = admUser.getPwddate(); // 사용자의 마지막 비밀번호 변경 일자 
       
        // 비밀번호 변경일자(pwd_date가 null이 아니라면)
        if (lastPasswordChangeDateString != null && !lastPasswordChangeDateString.isEmpty()) {
        	
        	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date lastPasswordChangeDate = null;
			try {
				lastPasswordChangeDate = format.parse(lastPasswordChangeDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            Date currentDate = new Date(); // 현재 날짜
            long millisecondsPerDay = 24 * 60 * 60 * 1000; // 하루의 밀리초 수
            int maxPasswordAgeInDays = 90; // 비밀번호 변경 주기 (90일)

            long passwordAgeInDays = (currentDate.getTime() - lastPasswordChangeDate.getTime()) / millisecondsPerDay;
			//암호초기화 수정 시 안타서 주석처리추가수정_sys_23.09.10
           // if (passwordAgeInDays > maxPasswordAgeInDays) {
            	
            	admUser.setPwddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
            	user.setPwddate(admUser.getPwddate());
            	user.setPwddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
            
            // 사용자 정보 업데이트
            loginServiceDAO.updatePwdSysm0100(admUser); // 비밀번호 및 비밀번호 변경일자 업데이트

           // }
            logger.debug(" update 끝 11" + admUser.getPwd());
            // 로그적용을 위해 풀것.
             MSFLogHistoryUtils.tracerUserActivity(
            		user, 
            		calledMethod,
            		calledClass,
            		"CHANGE PASSWORD"
            		);
         // 비밀번호 변경일자(pwd_date가 null일 경우)_hieju/05.30
        } else if(lastPasswordChangeDateString == null)  {
        	
        	String accountCreationDateString = user.getInptDt(); // 사용자의 계정 생성 일자를 가져옴
        	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        	Date accountCreationDate = null;
			try {
				accountCreationDate = format.parse(accountCreationDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			} // 문자열을 Date 객체로 변환

            Date currentDate = new Date(); // 현재 날짜
            long millisecondsPerDay = 24 * 60 * 60 * 1000; // 하루의 밀리초 수
            long accountAgeInDays = (currentDate.getTime() - accountCreationDate.getTime()) / millisecondsPerDay;
            // 사용자의 계정생성 후 90일이 지났는지 안지났는지 비교
            
            int maxPasswordAgeInDays = 90; // 90일 설정
		 if (accountAgeInDays >= maxPasswordAgeInDays) {
             // 비밀번호 변경일자 업데이트
            	admUser.setPwddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
            	
            	user.setPwddate(admUser.getPwddate());
            	user.setPwddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
              
                
		    	} else {
		    	    // 비밀번호 변경일자가 현재 일자로부터 90일이 지나지 않았을 경우
		    	    logger.debug("비밀번호 변경일자가 현재 일자로부터 90일이 지나지 않았습니다.");
		    	}
            	
            	// 사용자 정보 업데이트
	            loginServiceDAO.updatePwdSysm0100(admUser); // 비밀번호 및 비밀번호 변경일자 업데이트
	            
	            logger.debug(" update 끝22 " + admUser.getPwd());
	            // 로그적용을 위해 풀것.
	             MSFLogHistoryUtils.tracerUserActivity(
	            		user, 
	            		calledMethod,
	            		calledClass,
	            		"CHANGE PASSWORD"
	            		);
		}else{
				result = new Long(-1);
		}
        
        } catch (Exception ex) {
        	MSFLogHistoryUtils.tracerUserExceptionActivity( user, 
        			calledMethod,
        			calledClass,
        			"CHANGE PASSWORD",
        			ex,
        			"비밀번호 변경",
        			"CHANGE PASSWORD");
        	logger.error("EXCEPTION calling changePassword(): "+ex); 
        	result = new Long(0);
					
        } finally {
           
        	}
        	
        }catch (Exception e) { 
        	MSFLogHistoryUtils.tracerUserExceptionActivity( user, 
                    calledMethod2,
                    calledClass,
                    "SSO LOGIN",e, "로그인 체크", "SSO LOGIN");
            e.printStackTrace(); 
            bm.setMessage(e.getMessage());
            bm.setStackTraceContent(MSFSharedUtils.getStackTraceString(e));
            bm.setMessageDttm((new Date()).toString());
            
            sysm0100Login = new MSFSysm0100DTO(
                    user, 
                    "-3", 
                    "ErroreGenerico",
                    new Date(),
                    bm );
        	
                			
	       } finally {
	    	  
		 }

	    return result;
	    
	}

	//************************************************************************************************* 비밀번호 변경일자 감지 기능 추가_hieju/06.07
	@SuppressWarnings("unused")
	@Override
	public Long isPasswordChangeRequired(String useid, String userPwd) {
		
		String pwChkCryptSHA512 = "";
		String calledMethod = calledClass + "checkUsr";
        MSFSysm0100BM user = new MSFSysm0100BM();
        SysIfSysm0100VO srhUser = new SysIfSysm0100VO();
        ShowMessageBM bm = new ShowMessageBM();
		MSFSysm0100DTO sysm0100Login = null;
        MSFUserInfoVO webUserInfo = new MSFUserInfoVO(); 
        Long result = new Long(0);
        String pwdNewCryptSHA512 = "";

        try {
        	if  (MSFSharedUtils.paramNull(loginServiceDAO)) {
	        	WebApplicationContext wac = WebApplicationContextUtils.
	        			 getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalSession().getServletContext()); 
	      
	        	loginServiceDAO = (LoginServiceDAO) wac.getBean("LoginServiceDAO"); 
	        }
        	
           srhUser.setSysDivCd(""); // 데이터베이스에서 사용자 조회
           srhUser.setUsrId(useid);
           srhUser.setPwd(userPwd);
           
        SysIfSysm0100VO admUser = loginServiceDAO.selectSysm0100(srhUser);
        
        

        if (admUser == null) { // 사용자가 다를 경우 로그인을 막음
        	 result = new Long(-1);
        	 
        } else if ("Y".equals(admUser.getLockat())) {
    		sysm0100Login = new MSFSysm0100DTO(user, "-2", "UserNonEsiste",
    				new Date(), bm); 
    		
    		return result = new Long(-2);
        	
        } else  { 
        	pwChkCryptSHA512 = MSFSharedUtils.allowNulls(userPwd);
    		pwChkCryptSHA512 = payGenCryptService.payGenEncryptSHA256(MSFSharedUtils.allowNulls(userPwd));
        		
        	}  if( pwChkCryptSHA512.equals(admUser.getPwd())){//valid ) { // 비밀번호가 일치하는 경우, 
        		logger.debug(" 비밀번호가 잘 일치합니다." + admUser.getPwd());
        		
        
    			 admUser.setLogincnt("0");
     			loginServiceDAO.updateLoginCount(admUser);
         		BeanUtils.copyProperties(admUser, webUserInfo);
        
        		         
        		
        		
        	}else{
        		logger.debug(" 비밀번호가 일치하지않아 로그인을 막습니다." + admUser.getPwd());
        		
        		// ***** 로그인 실패 횟수 증가 및 차단 여부 확인_hieju_06.15__시작
            	int loginCount;
            	String loginCountStr = admUser.getLogincnt();
            	if (loginCountStr != null) { // 값이 있다면
            	    loginCount = Integer.parseInt(loginCountStr);
            	} else { // 값이 없다면
            	    loginCount = 0;
            	}
                int maxLoginAttempts = 5; // 로그인 실패 허용 횟수 설정 /2
                if (loginCount < maxLoginAttempts) { // 로그인 실패 시 횟수 증가
                    
                	// 로그인 실패 횟수 증가
                    loginCount++;
                    admUser.setLogincnt(String.valueOf(loginCount));
                    
                    // 로그인 실패 횟수 업데이트
                    loginServiceDAO.updateLoginCount(admUser);
                    
                    return new Long(-1);
            	} else if(loginCount == maxLoginAttempts) { // 로그인 실패횟수가 5회 이상이면
                    
                	// 로그인 차단 처리
                    admUser.setLockat("Y");
                   //비밀번호초기화_sys_23.09.10
                    pwdNewCryptSHA512 = payGenCryptService
        					.payGenEncryptSHA256("new1234!");
                 
                    admUser.setPwd(pwdNewCryptSHA512);

                    
                    // 로그인 차단 상태 업데이트
                    loginServiceDAO.updateLoginLock(admUser);
                    return new Long(-2);
            	}else{
            		
                }
                if ("Y".equals(admUser.getLockat())) { // 로그인 차단되면
        			logger.debug(" 로그인 차단 o" + admUser.getLockat());
        			
        			return new Long(-2);
        			// 로그인 차단되지 않고 비밀번호가 서로 일치하면
        		} else if("N".equals(admUser.getLockat()) &&  pwChkCryptSHA512.equals(admUser.getPwd())) { 
        			logger.debug(" 로그인 차단 X" + admUser.getLockat());
        			admUser.setLogincnt("0");
        			loginServiceDAO.updateLoginCount(admUser); // 로그인횟수 초기화 _hieju_06.15
        			
        			admUser.setLockat("N");
        			loginServiceDAO.updateLoginLock(admUser);
        			
        		}else{
        		}
        	}
                logger.debug("비밀번호 변경일자 확인222" + admUser.getPwddate());
    	user = new MSFSysm0100BM(
        		admUser.getDpobCd(),
        		admUser.getSysDivCd(), 
        		admUser.getSysDivNm(), 
        		admUser.getUsrId(), 
        		admUser.getUsrNm(),
        		admUser.getUsrDivCd(), 
        		admUser.getUsrDivNm(), 
        		admUser.getDeptCd(),
        		admUser.getDeptNm(),
        		//admUser.getTypOccuCd(),
        		//admUser.getTypOccuNm(),
        	    //admUser.getPyspGrdeCd(),
        	    //admUser.getPyspGrdeNm(),
        		admUser.getUsrTel(), 
        		admUser.getTplvlDeptCd() ,
        		admUser.getTplvlDeptNm() ,
        		admUser.getPayrMangDeptCd(),
        		admUser.getPayrMangDeptNm(),
        		admUser.getMangeDeptCd(),
        		admUser.getMangeDeptNm(),
        		admUser.getPayrMangDeptYn(),
        		admUser.getYrtxInptPrcsYn(),
        		admUser.getEmail(), 
        		admUser.getPwd(), 
        		admUser.getUseYn(),
        		admUser.getLockat(), // 추가 hieju_05.31
        		admUser.getLogincnt(),
        		admUser.getPwddate(),
        		admUser.getInptDt()
        		);
    	
    	 // 비밀번호 변경 후 90일 지났는지 확인하는 로직_hieju/05.30
        String lastPasswordChangeDateString = admUser.getPwddate(); // 사용자의 마지막 비밀번호 변경 일자 

        
        // 비밀번호 변경일자(pwd_date가 null이 아니라면)
        if (lastPasswordChangeDateString != null && !lastPasswordChangeDateString.isEmpty()) {
            
            Date lastPasswordChangeDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 형식 변경
            
            try {
                lastPasswordChangeDate = format.parse(lastPasswordChangeDateString);
               
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            Date currentDate = new Date(); // 현재 날짜
            long millisecondsPerDay = 24 * 60 * 60 * 1000; // 하루의 밀리초 수
            int maxPasswordAgeInDays = 90; // 비밀번호 변경 주기 (90일)

            long passwordAgeInDays = (currentDate.getTime() - lastPasswordChangeDate.getTime()) / millisecondsPerDay;
            
            if (passwordAgeInDays > maxPasswordAgeInDays) { // 비밀번호 변경일이 현재일자보다 90일이 지나있으면
                admUser.setPwddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                 result = new Long(1);
            } else if(passwordAgeInDays < maxPasswordAgeInDays){// 비밀번호 변경일이 현재일자보다 90일이 안지났으면
            	
            } else{
            	
            }
         // 비밀번호 변경일자(pwd_date가 null일 경우)_hieju/05.30
        }
        if(lastPasswordChangeDateString == null)  {
        	String accountCreationDateString = admUser.getInptDt(); // 사용자의 계정 생성 일자를 가져옴
        	logger.debug("계정생성일자 잘 가져왔는지 확인 "+admUser.getInptDt());
        	
        	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	Date accountCreationDate = null;
			try {
				 accountCreationDate = inputFormat.parse(accountCreationDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			} // 문자열을 Date 객체로 변환
			
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");
			String accountCreationDateFormatted = outputFormat.format(accountCreationDate);
			
            Date currentDate = new Date(); // 현재 날짜
            long millisecondsPerDay = 24 * 60 * 60 * 1000; // 하루의 밀리초 수
            long accountAgeInDays = (currentDate.getTime() - accountCreationDate.getTime()) / millisecondsPerDay; // null 오류
            // 사용자의 계정생성 후 90일이 지났는지 안지났는지 비교
            
            int maxPasswordAgeInDays = 90; // 90일 설정
            if (accountAgeInDays > maxPasswordAgeInDays) { // 계정생성일이 현재일자보다 90일이 지나있으면
                // 비밀번호 변경일자 업데이트
                admUser.setPwddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                result = new Long(1);
                }              
        }else{	
        	// result = new Long(-1);
        }
        //초기화 비밀번호일 경우 비밀번호변경 팝업 탈수있게 수정_sys_23.09.10	
        if ("new1234!".equals(userPwd)) {

        	 result = new Long(2);
        }
        }catch (Exception ex) { 
        	MSFLogHistoryUtils.tracerUserExceptionActivity( user, 
                    calledMethod,
                    calledClass,
                    "SSO LOGIN",ex, "로그인 체크", "SSO LOGIN");
            ex.printStackTrace(); 
            bm.setMessage(ex.getMessage());
            bm.setStackTraceContent(MSFSharedUtils.getStackTraceString(ex));
            bm.setMessageDttm((new Date()).toString());
            sysm0100Login = new MSFSysm0100DTO(
                    user, 
                    "-3", 
                    "ErroreGenerico",
                    new Date(),
                    bm );
           
        	
    } finally {
        // 필요한 경우 정리 작업 수행
    
    }
    
        return result;
	}
	// ********************************************************************************************* 기능수정 끝


	// TODO 로그인
	public MSFSysm0100DTO checkUsr(String userid, String userPwd, String language) {
			
	        //  Session session = null;
	        //String msg = "";
	        String pwChkCryptSHA512 = "";
	        MSFSysm0100BM user = null;
	        MSFSysm0100DTO sysm0100Login = new MSFSysm0100DTO();
	        SysIfSysm0100VO srhUser = new SysIfSysm0100VO();
	        ShowMessageBM bm = new ShowMessageBM();
	        //web 화면 처리를 위한 세션 정보를 가지고 처리 하기위한 작업
	        MSFUserInfoVO webUserInfo = new MSFUserInfoVO();
	        MSFSysm0100BM sessionUserYn = new MSFSysm0100BM();
	        
	        String calledMethod = calledClass + "checkUsr";
	        try {
	             //Update user selected language
	            // MSFServerUtils.setCurrentLocaleFromRequest(RemoteServiceUtil.getThreadLocalRequest());

	            if  (MSFSharedUtils.paramNull(loginServiceDAO)) {
	    	        
		        	WebApplicationContext wac = WebApplicationContextUtils.
		        			 getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalSession().getServletContext()); 

		        	loginServiceDAO = (LoginServiceDAO) wac.getBean("LoginServiceDAO"); 
		        }
	            
	             srhUser.setSysDivCd(""); // 데이터베이스에서 사용자 조회
	             srhUser.setUsrId(userid);
	             SysIfSysm0100VO admUser = loginServiceDAO.selectSysm0100(srhUser);
	             
	            if (admUser==null) { // 사용자가 다를 경우 로그인을 막음
	            	sysm0100Login = new MSFSysm0100DTO(
	                        user, 
	                        "-2", 
	                        "UserNonEsiste",
	                        new Date(),
	                        bm);
	            // 계정이 잠겨있는 경우, 로그인을 막음._hieju/05.30
	            } else if ("Y".equals(admUser.getLockat())) {
	            	
	            	sysm0100Login = new MSFSysm0100DTO(user, "-2", "UserNonEsiste",
						new Date(), bm); 
							
				}else{
					
				}
        		 
	            	
    		 	if (MSFSharedUtils.allowNulls(userPwd).equals(admUser.getPwd())) { // 비밀번호 유효성 검사
                	 		pwChkCryptSHA512 = MSFSharedUtils.allowNulls(userPwd);
            		 	
            		
            	}else {
	            		
	            	//암호화 모듈적용으로 추가 
	            	pwChkCryptSHA512 = payGenCryptService.payGenEncryptSHA256(MSFSharedUtils.allowNulls(userPwd));
	            	
	            	
            
                    
                    //Se ho trovato uno User creo il corrispondente Sysm0100VO di ritorno
                    user = new MSFSysm0100BM(
                    		admUser.getDpobCd(),
                    		admUser.getSysDivCd(), 
                    		admUser.getSysDivNm(), 
                    		admUser.getUsrId(), 
                    		admUser.getUsrNm(),
                    		admUser.getUsrDivCd(), 
                    		admUser.getUsrDivNm(), 
                    		admUser.getDeptCd(),
                    		admUser.getDeptNm(),
                    		//admUser.getTypOccuCd(),
                    		//admUser.getTypOccuNm(),
                    	    //admUser.getPyspGrdeCd(),
                    	    //admUser.getPyspGrdeNm(),
                    		admUser.getUsrTel(), 
                    		admUser.getTplvlDeptCd() ,
                    		admUser.getTplvlDeptNm() ,
                    		admUser.getPayrMangDeptCd(),
                    		admUser.getPayrMangDeptNm(),
                    		admUser.getMangeDeptCd(),
                    		admUser.getMangeDeptNm(),
                    		admUser.getPayrMangDeptYn(),
                    		admUser.getYrtxInptPrcsYn(),
                    		admUser.getEmail(), 
                    		admUser.getPwd(), 
                    		admUser.getUseYn(), 
                    		null, null, null, null, 
                    		admUser.getLockat(), // 추가 hieju_05.31
                    		admUser.getLogincnt(),  // 추가 hieju_05.31
                    		admUser.getPwddate(),  // 추가 hieju_05.31
                    		admUser.getInptDt()  // 추가 hieju_05.31
                    		);
                    
                 
                    //Setto sull'utenteBM i profiles associati
                    @SuppressWarnings("unchecked")
                    Set<SysIfSysm0500VO> admSysm0500 = admUser.getAdmSysm0500();
                    Iterator<SysIfSysm0500VO> iterSysm0500 = admSysm0500!=null ? admSysm0500.iterator() : null;
                    while ( iterSysm0500!=null && iterSysm0500.hasNext() ) {
                        SysIfSysm0500VO sysm0500 = iterSysm0500.next();
                        if ( sysm0500.getAdmSysm0300()!=null ) {
                            SysIfSysm0300VO sysm0300 = sysm0500.getAdmSysm0300();
                            MSFSysm0300BM sysm0300Bm = new MSFSysm0300BM(
                            		sysm0300.getSysDivCd(),
                            		sysm0300.getAuthGrpSeilNum(),
                            		sysm0300.getBusinDivCd(),
                            		sysm0300.getAuthGrpNm(),
                            		sysm0300.getGrde(),
                            		sysm0300.getAuthGrpUseYn(),
                            		sysm0300.getGrpEpln());
                           
                            user.addSysm0300(sysm0300Bm);
                        }
                    } 
                    
                    //사용자데이터 권한 처리 루틴 추가 2015.11.12
                    @SuppressWarnings("unchecked")
                    Set<MSFAuthCheckVO> admAuthCheckInfo= admUser.getAdmAuthCheckInfo();
                    Iterator<MSFAuthCheckVO> iterAuthCheck = admAuthCheckInfo!=null ? admAuthCheckInfo.iterator() : null;
                    while ( iterAuthCheck!=null && iterAuthCheck.hasNext() ) {
                    	MSFAuthCheckVO authCheck = iterAuthCheck.next();
                    	
                        if ( authCheck.getUsrId()!=null ) {
                       	 
                        	 MSFAuthCheckBM authCheckBm  = new MSFAuthCheckBM(
                       			 authCheck.getDpobCd(),
                       			 authCheck.getSysDivCd(),
                       			 authCheck.getUsrId(),
                       			 authCheck.getUsrDivCd(),
                       			 authCheck.getAuthCheck01(),
                       			 authCheck.getAuthCheck02(),
                       			 authCheck.getAuthCheck03(),
                       			 authCheck.getAuthCheck04(),
                       			 authCheck.getAuthCheck05(),
                       			 authCheck.getAuthCheck06(),
                       			 authCheck.getAuthCheck07(),
                       			 authCheck.getAuthCheck08(),
                       			 authCheck.getAuthCheck09(),
                       			 authCheck.getAuthCheck10()
                       			 );
                        	 
                             user.setAuthCheck(authCheckBm); 
                         }  
                    } 
                    user.setUserInfo(null);
                    user.setSsoxUser(null); //TODO 세션이 아닌경우처리
                    

                     ////////////////////////////////////////////////////////////////////////////
                    //중복로그인 안되게 수정_23.08.23
                    //세션을 생성(2가지 버전으로 생성)
                    HttpSession httpSession = RemoteServiceUtil.getThreadLocalSession(); //기존에 쓰는 세션
                    HttpSession existingSession = activeSessions.get(userid);
                   
                    sessionUserYn = (MSFSysm0100BM) httpSession.getAttribute(MSFConfiguration.PAYGEN_SESSION_USER);
                    httpSession.setAttribute(MSFConfiguration.PAYGEN_SESSION_USER, user);
                    //Web Session 추가 
                    httpSession.setAttribute(PropConfs.WEB_SESSION_USER, webUserInfo);
                  
                     
                    if (sessionUserYn == null) {
                    	if (existingSession != null) {
                    	
                    		// Invalidate the existing session
                    		existingSession.invalidate();
                    		activeSessions.remove(userid);
                    	}
 	
                    }
                    activeSessions.put(userid, httpSession);
                    
                    sysm0100Login = new MSFSysm0100DTO(user 
							                            , httpSession.getId() 
							                            , ""
							                            , new Date()
							                            , bm); // 로그인 사용자 활동 로그 기록

                    MSFLogHistoryUtils.tracerLoginUserActivity(user
									                            , calledMethod
									                            , ""
									                            , "LOGIN");
            	
                
            
                      }
            	
		                
	        }
	        catch (Exception ex) { 
	        	
	        	MSFLogHistoryUtils.tracerUserExceptionActivity( user, 
	                    calledMethod,
	                    calledClass,
	                    "SSO LOGIN",ex, "로그인 체크", "SSO LOGIN");
	            ex.printStackTrace(); 
	            bm.setMessage(ex.getMessage());
	            bm.setStackTraceContent(MSFSharedUtils.getStackTraceString(ex));
	            bm.setMessageDttm((new Date()).toString());
	            
	        	sysm0100Login = new MSFSysm0100DTO(
	                    user, 
	                    "-3", 
	                    "ErroreGenerico",
	                    new Date(),
	                    bm );
	        
	        }
	        finally { 
	        }
	
	        
	        return sysm0100Login;
	 }
	

	public MSFSysm0100DTO checkSSOUsr(String dpobCd, String sysDivCd,
			String userId, String language) {

		String calledMethod = calledClass + "checkSSOUsr";

		MSFSysm0100BM user = null;
		MSFSysm0100DTO sysm0100Login = new MSFSysm0100DTO();
		SysIfSysm0100VO srhUser = new SysIfSysm0100VO();
		SsoxUserVO ssoxUserVo = new SsoxUserVO();
		ShowMessageBM bm = new ShowMessageBM();
		// web 화면 처리를 위한 세션 정보를 가지고 처리 하기위한 작업
		MSFUserInfoVO webUserInfo = new MSFUserInfoVO();

		try {

			// MSFServerUtils.setCurrentLocaleFromRequest(RemoteServiceUtil.getThreadLocalRequest());
			if (MSFSharedUtils.paramNull(loginServiceDAO)) {

				WebApplicationContext wac = WebApplicationContextUtils
						.getRequiredWebApplicationContext(RemoteServiceUtil
								.getThreadLocalRequest().getSession()
								.getServletContext());

				loginServiceDAO = (LoginServiceDAO) wac
						.getBean("LoginServiceDAO");
			}

			srhUser.setDpobCd(dpobCd);
			srhUser.setSysDivCd(sysDivCd);
			srhUser.setUsrId(userId);
			SysIfSysm0100VO admUser = loginServiceDAO.selectSysm0100(srhUser);

			if (admUser == null) {
				sysm0100Login = new MSFSysm0100DTO(user, "-2", "UserNonEsiste",
						new Date(), bm);
				// 계정이 잠겨있는 경우, 로그인을 막음._hieju/05.30
			} else if ("Y".equals(admUser.getLockat())) {
				sysm0100Login = new MSFSysm0100DTO(user, "-2", "UserNonEsiste",
						new Date(), bm);
			} else {

				BeanUtils.copyProperties(admUser, webUserInfo);

				// Se ho trovato uno User creo il corrispondente Sysm0100VO di
				// ritorno
				logger.debug("로그인 정보 이전 "+admUser.getDpobCd());
				user = new MSFSysm0100BM(
						admUser.getDpobCd(),
						admUser.getSysDivCd(),
						admUser.getSysDivNm(),
						admUser.getUsrId(),
						admUser.getUsrNm(),
						admUser.getUsrDivCd(),
						admUser.getUsrDivNm(),
						admUser.getDeptCd(),
						admUser.getDeptNm(),
						// admUser.getTypOccuCd(),
						// admUser.getTypOccuNm(),
						// admUser.getPyspGrdeCd(),
						// admUser.getPyspGrdeNm(),
						admUser.getUsrTel(), admUser.getTplvlDeptCd(),
						admUser.getTplvlDeptNm(), admUser.getPayrMangDeptCd(),
						admUser.getPayrMangDeptNm(), admUser.getMangeDeptCd(),
						admUser.getMangeDeptNm(), admUser.getPayrMangDeptYn(),
						admUser.getYrtxInptPrcsYn(), admUser.getEmail(),
						admUser.getPwd(), admUser.getUseYn(),
						admUser.getLogincnt(),admUser.getPwddate(),
						admUser.getInptDt(), admUser.getLockat());
				logger.debug("로그인 정보 이후"+admUser.getDpobCd());
				/**
				 * 추가내용
				 * 
				 */
				// Setto sull'utenteBM i profiles associati
				Set<SysIfSysm0500VO> admSysm0500 = admUser.getAdmSysm0500();
				Iterator<SysIfSysm0500VO> iterSysm0500 = admSysm0500 != null ? admSysm0500
						.iterator() : null;
				while (iterSysm0500 != null && iterSysm0500.hasNext()) {
					SysIfSysm0500VO sysm0500 = iterSysm0500.next();
					if (sysm0500.getAdmSysm0300() != null) {
						SysIfSysm0300VO sysm0300 = sysm0500.getAdmSysm0300();
						MSFSysm0300BM sysm0300Bm = new MSFSysm0300BM(
								sysm0300.getSysDivCd(),
								sysm0300.getAuthGrpSeilNum(),
								sysm0300.getBusinDivCd(),
								sysm0300.getAuthGrpNm(), sysm0300.getGrde(),
								sysm0300.getAuthGrpUseYn(),
								sysm0300.getGrpEpln());
						user.addSysm0300(sysm0300Bm);
					}
				}

				// 사용자데이터 권한 처리 루틴 추가 2015.11.12
				@SuppressWarnings("unchecked")
				Set<MSFAuthCheckVO> admAuthCheckInfo = admUser
						.getAdmAuthCheckInfo();
				Iterator<MSFAuthCheckVO> iterAuthCheck = admAuthCheckInfo != null ? admAuthCheckInfo
						.iterator() : null;
				while (iterAuthCheck != null && iterAuthCheck.hasNext()) {
					MSFAuthCheckVO authCheck = iterAuthCheck.next();

					if (authCheck.getUsrId() != null) {

						MSFAuthCheckBM authCheckBm = new MSFAuthCheckBM(
								authCheck.getDpobCd(), authCheck.getSysDivCd(),
								authCheck.getUsrId(), authCheck.getUsrDivCd(),
								authCheck.getAuthCheck01(),
								authCheck.getAuthCheck02(),
								authCheck.getAuthCheck03(),
								authCheck.getAuthCheck04(),
								authCheck.getAuthCheck05(),
								authCheck.getAuthCheck06(),
								authCheck.getAuthCheck07(),
								authCheck.getAuthCheck08(),
								authCheck.getAuthCheck09(),
								authCheck.getAuthCheck10());

						user.setAuthCheck(authCheckBm);

					}
				}

				HttpSession httpSession = RemoteServiceUtil
						.getThreadLocalSession();

				// 사용자 세션 정보를 셋팅한다.
				httpSession.setAttribute(MSFConfiguration.PAYGEN_SESSION_USER,
						user);
				// Web Session 추가
				httpSession.setAttribute(PropConfs.WEB_SESSION_USER,
						webUserInfo);
				sysm0100Login = new MSFSysm0100DTO(user, httpSession.getId(),
						"", new Date(), bm);

				MSFLogHistoryUtils.tracerLoginUserActivity(user, calledMethod,
						"", "SSOLOGIN");
			}

		} catch (Exception ex) {
			MSFLogHistoryUtils.tracerUserExceptionActivity(user, calledMethod,
					calledClass, "CHANGE PASSWORD", ex, "비밀번호 변경",
					"CHANGE PASSWORD");
			ex.printStackTrace();
			bm.setMessage(ex.getMessage());
			bm.setStackTraceContent(MSFSharedUtils.getStackTraceString(ex));
			bm.setMessageDttm((new Date()).toString());
			sysm0100Login = new MSFSysm0100DTO(user, "-3", "ErroreGenerico",
					new Date(), bm);
		}

		return sysm0100Login;
	}

	@SuppressWarnings("null")
	public MSFSysm0100DTO checkSSOSession() {

		String calledMethod = calledClass + "checkSSOSession";
		MSFSysm0100BM extermuser = new MSFSysm0100BM();
		SsoxUserVO ssoxUserVo = new SsoxUserVO();
		// ShowMessageBM bm = new ShowMessageBM();
		try {

			HttpSession httpSession = RemoteServiceUtil.getThreadLocalSession();
			// extermuser = (MSFSysm0100BM)
			// httpSession.getAttribute(MSFConfiguration.PAYGEN_SESSION_USER);
			// if (MSFSharedUtils.paramNull(extermuser)) {
			// httpSession.setAttribute(MSFConfiguration.PAYGEN_SESSION_SSO,
			// null);
			// }
			ssoxUserVo = (SsoxUserVO) httpSession
					.getAttribute(MSFConfiguration.PAYGEN_SESSION_SSO);

			if (MSFSharedUtils.paramNull(ssoxUserVo)) {
				extermuser.setSsoUseType("NONE");

			}

			if (ssoxUserVo != null && ssoxUserVo.getUserId() != null
					&& !ssoxUserVo.getUserId().equals("")) {
				extermuser.setUsrId(ssoxUserVo.getUserId());
				extermuser.setSysDivCd(ssoxUserVo.getSysDivCd());
				extermuser.setDpobCd(ssoxUserVo.getDpobCd());
				extermuser.setSsoUseType(MSFSharedUtils.defaultNulls(
						ssoxUserVo.getSsoUseType(), "NONE"));
			}
			// else {
			// extermuser.setUsrId("");
			// extermuser.setSysDivCd("");
			// extermuser.setDpobCd("");
			// }

		} catch (Exception ex) {
			MSFLogHistoryUtils.tracerUserExceptionActivity(getUser(),
					calledMethod, calledClass, "checkSSOSession", ex, "로그인",
					"LOGIN");
			ex.printStackTrace();
			logger.error("EXCEPTION calling checkUsr(): " + ex);
		}

		return new MSFSysm0100DTO(extermuser, null, "", new Date(), null);
	}

	public MSFSysm0100DTO checkSession() {
		String calledMethod = calledClass + "checkSession";
		MSFSysm0100BM extermuser = null;
		MSFSysm0100BM ssoExUser = null;
		MSFSysm0100DTO msfSysm0100Dto = new MSFSysm0100DTO();
		// ShowMessageBM bm = new ShowMessageBM();
		try {
			// RpcConfigServiceServlet();

			if (MSFSharedUtils.paramNull(loginServiceDAO)) {

				WebApplicationContext wac = WebApplicationContextUtils
						.getRequiredWebApplicationContext(RemoteServiceUtil
								.getThreadLocalSession().getServletContext());

				loginServiceDAO = (LoginServiceDAO) wac
						.getBean("LoginServiceDAO");
			}

			/**************************************** 당분간처리를 위해 추가됨 *******************************************/
			loginServiceDAO.updateSysm040001();
			loginServiceDAO.updateSysm040002();
			/**************************************** 당분간처리를 위해 추가됨 *******************************************/

			// sso 에서 넘어온 값인지 아닌지 여부 판단을 하여데이타를 넘김
			msfSysm0100Dto = checkSSOSession();
			ssoExUser = msfSysm0100Dto.getMsfSysm0100();
			if (MSFSharedUtils.paramNotNull(ssoExUser)) {

				if ("SSOX".equals(MSFSharedUtils.allowNulls(ssoExUser
						.getSsoUseType()))) {

					extermuser = ssoExUser;

				} else {

					HttpSession httpSession = RemoteServiceUtil
							.getThreadLocalSession(); // getThreadLocalRequest().getSession();
					extermuser = (MSFSysm0100BM) httpSession
							.getAttribute(MSFConfiguration.PAYGEN_SESSION_USER);
				}

			} else {

				HttpSession httpSession = RemoteServiceUtil
						.getThreadLocalSession(); // getThreadLocalRequest().getSession();
				extermuser = (MSFSysm0100BM) httpSession
						.getAttribute(MSFConfiguration.PAYGEN_SESSION_USER);
			}

		} catch (Exception ex) {
			MSFLogHistoryUtils.tracerUserExceptionActivity(getUser(),
					calledMethod, calledClass, "checkSession", ex, "로그인",
					"LOGIN");
			ex.printStackTrace();
			logger.error("EXCEPTION calling checkUsr(): " + ex);
		}

		return new MSFSysm0100DTO(extermuser, null, "", new Date(), null);
	}

	// TODO 로그아웃
	public void clearSession() {
		String calledMethod = calledClass + "clearSession";
		try {
			HttpSession httpSession = RemoteServiceUtil.getThreadLocalSession();
			MSFSysm0100BM user = (MSFSysm0100BM) httpSession
					.getAttribute(MSFConfiguration.PAYGEN_SESSION_USER);

			MSFLogHistoryUtils.tracerLoginUserActivity(user, calledMethod, "",
					"LOGOUT");

			httpSession.removeAttribute(MSFConfiguration.PAYGEN_SESSION_USER);
			httpSession.removeAttribute(MSFConfiguration.PAYGEN_SESSION_AUTH);
			httpSession.removeAttribute(MSFConfiguration.PAYGEN_SESSION_SSO);
			httpSession.removeAttribute("loginVO");

			if (user != null){
				HttpSession existingSession = activeSessions.get(user.getUsrId());
				existingSession.invalidate();
        		activeSessions.remove(user.getUsrId());
 
			}
			
		} catch (Exception ex) {
			MSFLogHistoryUtils.tracerUserExceptionActivity(getUser(),
					calledMethod, calledClass, "LOGOUT", ex, "로그아웃", "LOGOUT");
			ex.printStackTrace();
			logger.error("EXCEPTION calling clearSession(): " + ex);
		}
	}
	public Long saveUser(SysIfSysm0100DTO sysm0100BM) {

		String calledMethod = calledClass + "saveUser";
		String pwdCryptSHA512 = "";
		Long result = new Long(0);
		
		try {
			HttpSession httpSession = RemoteServiceUtil.getThreadLocalSession(); // getThreadLocalRequest().getSession();
			MSFSysm0100BM user = (MSFSysm0100BM) httpSession
					.getAttribute(MSFConfiguration.PAYGEN_SESSION_USER);
			
			if (MSFSharedUtils.paramNull(loginServiceDAO)) {

				WebApplicationContext wac = WebApplicationContextUtils
						.getRequiredWebApplicationContext(RemoteServiceUtil
								.getThreadLocalSession().getServletContext());

				loginServiceDAO = (LoginServiceDAO) wac
						.getBean("LoginServiceDAO");
			}

			SysIfSysm0100VO instAdmUser = new SysIfSysm0100VO();
			instAdmUser.setUsrId(sysm0100BM.getUsrId());
			instAdmUser.setUsrNm(sysm0100BM.getUsrNm());
			instAdmUser.setSysDivCd("EXTERM00");
			instAdmUser.setDeptCd(sysm0100BM.getDeptCd());
			instAdmUser.setUsrTel(sysm0100BM.getUsrTel());

			instAdmUser.setEmail(sysm0100BM.getEmail());
			pwdCryptSHA512 = payGenCryptService
					.payGenEncryptSHA256(MSFSharedUtils.allowNulls(sysm0100BM
							.getPwd()));
			instAdmUser.setPwd(pwdCryptSHA512);
			instAdmUser.setUseYn("N");
			
			// pwddate 추가
			String lastPasswordChangeDateString = sysm0100BM.getPwddate();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			 logger.debug("pwddate 확인 " + sysm0100BM.getPwddate());
			try {
			    // pwddate가 null인 경우 현재일자로 설정
			    if (lastPasswordChangeDateString == null) {
			        // pwddate가 null이면 현재일자를 "yyyyMMdd" 형식으로 설정합니다.
			        lastPasswordChangeDateString = format.format(new Date());
			    } else {
			        // 문자열을 Date 객체로 변환하여 currentDate에 저장합니다.
			       format.parse(lastPasswordChangeDateString);
			       logger.debug("pwddate 확인 1 " + sysm0100BM.getPwddate());
			    }
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			 logger.debug("pwddate 확인 2 " + sysm0100BM.getPwddate());
			instAdmUser.setPwddate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
			// 끝_hieju_07.20
		

			// System.out.println("===============================report 처리 결과 debug============================");
			// System.out.println("데이타 없음. : " + instAdmUser.toString());
			// System.out.println("===============================report 처리 결과 debug============================");

			loginServiceDAO.insertConfSysm0100(instAdmUser);

			result = new Long(1);

			// TODO 차후 로그 구현을 위해 풀것.
			// MSFLogHistoryUtils.tracerUserActivity(
			// user,
			// calledMethod,
			// SysIfSysm0100VO.class.getName(),
			// "UPDATE"
			// );

		} catch (Exception ex) {
			result = new Long(0);
			logger.error("EXCEPTION calling saveUser(): " + ex);
		} finally {
		}
		return result;
	}

	public List<MSFSysm0300BM> readProfilesByUser(MSFSysm0100BM user) {
		return null;
	}

	public MSFAuthCheckBM readAuthByUser(MSFSysm0100BM user) {
		return null;
	}

	public HashMap<String, String> getServerMessages() {
		HashMap<String, String> messages = MSFServerUtils.getLocalidedMessages(
				RemoteServiceUtil.getThreadLocalConfig(),
				RemoteServiceUtil.getThreadLocalRequest());
		return messages;
	}





	
}
