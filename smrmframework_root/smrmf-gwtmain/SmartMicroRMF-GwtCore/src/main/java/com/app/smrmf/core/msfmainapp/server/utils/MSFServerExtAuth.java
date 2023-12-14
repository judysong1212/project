/**
* <pre>
* 1. 프로젝트명 : SmartMicroRMF-Core-1.0.0
* 2. 패키지명(또는 디렉토리 경로) : com.app.smrmf.core.msfmainapp.server.utils
* 3. 파일명 : MSFServerAuth.java
* 4. 작성일 : Nov 13, 2015 4:05:03 PM
* 5. 작성자 : leeheuisung
* 6. 설명 :
* </pre>
*/
/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.app.smrmf.core.msfmainapp.server.utils; 

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.crypto.service.AbstCryptCutmServiceImpl;

/**
 * <pre>
 * com.app.smrmf.core.msfmainapp.server.utils 
 *    |_ MSFServerAuth.java
 * 
 * </pre>
 * @date : Nov 13, 2015 4:05:03 PM
 * @version : 
 * @author : leeheuisung
 */
/**
 * <pre>
 * 1. 패키지명 : com.app.smrmf.core.msfmainapp.server.utils
 * 2. 타입명 : MSFServerAuth.java
 * 3. 작성일 : Nov 13, 2015 4:05:03 PM
 * 4. 작성자 : leeheuisung
 * 5. 설명 :  서버 권한 처리가 필요한 경우 여기에 선언하여 사용한다. 콤보 박스등 권한이 필요한 경우 
 * </pre>
 */
public class MSFServerExtAuth extends AbstCryptCutmServiceImpl   implements ServletContextAware, ServletConfigAware {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    
   private static MSFServerExtAuth oneServerAuth;   
  
	  
   private  MSFServerExtAuth () {  
	   
   }
   
   public static MSFServerExtAuth getInstance() {
       if(oneServerAuth==null) {
    	   oneServerAuth = new MSFServerExtAuth();
       }
       return oneServerAuth;
   }
   

   @Override
   public void setServletConfig(final ServletConfig servletConfig) {
       this.servletConfig = servletConfig;

   }

   @Override
   public void setServletContext(final ServletContext servletContext) {
       this.servletContext = servletContext;

   }
	 
    /**
     * <pre>
     * 1. 개요 : 권한에 따른 고용구분의 값을 처리 할때 사
     * 2. 처리내용 :  권한에 따른 고용구분의 값을 셋팅하여 가져온다.
     * </pre>
     * @Method Name : getAuthEmymtDivCd
     * @date : Nov 13, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 13, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @return String
     */ 	
    public String getAuthEmymtDivCd(MSFSysm0100BM authUser) {
    	  
    	// MSFSysm0100BM  authUser = MSFServerUtils.getLoggedUser(MSFSharedUtils.paramNull(getHttpServletRequest()) ? 
    			    //                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest() : getHttpServletRequest());
    	 String strEmymtDivCd =  "";
         
        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(authUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(authUser.getUsrDivCd()))) {
            //기간제업무담당자- 기간제업무담당자
        	strEmymtDivCd =  MSFConfiguration.EMYMT_DIVCD02;
           } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(authUser.getUsrDivCd())) {
            //무기계약직업무담당자- 무기계약직업무담당자
        	   strEmymtDivCd =  MSFConfiguration.EMYMT_DIVCD01; 
           } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(authUser.getUsrDivCd())) {
               //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
        	   strEmymtDivCd =  "";
           } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(authUser.getUsrDivCd())) {
             //무기계약직업무담당자- 무기계약직업무담당자
        	   strEmymtDivCd = MSFConfiguration.EMYMT_DIVCD01; 
           } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(authUser.getUsrDivCd())) {  
        	   strEmymtDivCd =  ""; 
           } else {
        	   strEmymtDivCd =  MSFConfiguration.EMYMT_DIVCD01;   
           }
         return strEmymtDivCd ;
    }
    
    
//    /**
//     * <pre>
//     * 1. 개요 : 권한에 따른 부서코드를 셋팅할 경우 사용한다. 
//     * 2. 처리내용 : 권한에서 부서코드가 변경되지 않아야 할경우 사용함.
//     * </pre>
//     * @Method Name : getAuthDeptCd
//     * @date : Nov 13, 2015
//     * @author : leeheuisung
//     * @history : 
//     *	-----------------------------------------------------------------------
//     *	변경일				작성자						변경내용  
//     *	----------- ------------------- ---------------------------------------
//     *	Nov 13, 2015		leeheuisung				최초 작성 
//     *	-----------------------------------------------------------------------
//     * 
//     * @return
//     */ 	
//    public String getAuthDeptCd() {
//  	  
//    	String strDeptCd =  "";
//         
//        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(authUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(authUser.getUsrDivCd()))) {
//            //기간제업무담당자- 기간제업무담당자
//        	
//        	strDeptCd =  MSFConfiguration.EMYMT_DIVCD02;
//           } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(authUser.getUsrDivCd())) {
//            //무기계약직업무담당자- 무기계약직업무담당자
//        	   strDeptCd =  MSFConfiguration.EMYMT_DIVCD01; 
//           } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(authUser.getUsrDivCd())) {
//               //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
//        	   strDeptCd =  "";
//           } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(authUser.getUsrDivCd())) {
//             //무기계약직업무담당자- 무기계약직업무담당자
//        	   strDeptCd = MSFConfiguration.EMYMT_DIVCD01; 
//           } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(authUser.getUsrDivCd())) {  
//        	   strDeptCd =  ""; 
//           } else {
//        	   strDeptCd =  MSFConfiguration.EMYMT_DIVCD01;   
//           }
//         return strDeptCd ;
//    }
    
    
  	
//  /**
//	 * <pre>
//	 * 1. 개요 : 권한의 조건이 전체 권한 
//	 * 2. 처리내용 : 
//	 * </pre>
//	 * @Method Name : getAuthPayrMangDeptCd
//	 * @date : Nov 13, 2015
//	 * @author : leeheuisung
//	 * @history : 
//	 *	-----------------------------------------------------------------------
//	 *	변경일				작성자						변경내용  
//	 *	----------- ------------------- ---------------------------------------
//	 *	Nov 13, 2015		leeheuisung				최초 작성 
//	 *	-----------------------------------------------------------------------
//	 * 
//	 * @return
//	 */ 	
//	public String getAuthPayrMangDeptCd() {
//		  
//	  	String strPayrMangDeptCd =  "";
//	       
//	  	    if ("A".equals(authUser.getPayrMangDeptYn())) {
//	  	    	strPayrMangDeptCd = "";
//	  	    } else {
//	  	    	strPayrMangDeptCd = authUser.getPayrMangDeptCd();
//	  	    }
//	         
//	       return strPayrMangDeptCd ;
//	  }
    
     
      
}
