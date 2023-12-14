package com.web.exterms.report.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.web.exterms.mypage.login.service.MyPageSessionVO;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : EgovComUtlController.java
 * @Description : 공통유틸리티성 작업을 위한 Controller
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.03.02    조재영          최초 생성
 * @ 2011.10.07    이기하          .action -> .do로 변경하면서 동일 매핑이 되어 삭제처리
 *
 *  @author 공통서비스 개발팀 조재영
 *  @since 2009.03.02
 *  @version 1.0
 *  @see
 *
 */
@Controller
public class ComRexServerController {

	private static final Logger logger = LoggerFactory.getLogger(ComRexServerController.class);  
    //@Resource(name = "egovUserManageService")
    //private EgovUserManageService egovUserManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    public final static String REX_DIR_PATH_CHAR = "/";
    private static final  String REX_TOKEN_DELIMITER = "⊥";

    /**
	 * rda 리포트 출력을 위한 설정 및 호출 페이지 
	 */ 
	@RequestMapping(value="/PayGenRexReport.do")
	public String RdServerToPage(HttpServletRequest request ,ModelMap model
			,@RequestParam(value="svDirPath", required=true) String svDirPath
			,@RequestParam(value="svRexParam", required=true) String svRexParam
			,@RequestParam(value="rexFile", required=true) String rexFile
			,@RequestParam(value="rexPageCnt", required=true) String rexPageCnt )
		            throws Exception { 
		
		
	  
		 
		//ModelAndView model = new ModelAndView();
		//세션정보를 체크하여 로그인 페이지로 이동
		String rexServerPath = Globals.REX_SERVER_PATH;   //리포트 출력물 디렉토리 
		String link = "rexserver/RexReport"; 
		String pageContextPath = "";
//		pageContextPath = Globals.EXTERM_REPORT_PATH_URL;
		// contextPath() null 인경우 처리 추가  = pageUrl;
		pageContextPath = request.getContextPath() == null ? Globals.EXTERM_REPORT_PATH_URL: request.getContextPath();
	    if("".equals(pageContextPath)){
	    	pageContextPath = Globals.EXTERM_REPORT_PATH_URL; // 경로가  없는경우 설정된 경로 값 
	    }
		 
	    MSFUserInfoVO mysession = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);
	    
		if ( EgovSessionCookieUtil.getSessionAttribute(request, mysession.getUsrId())   != null) {
 
			 
			String rexBaseDb = Globals.REX_SERVER_SID ;  //리포트 디비 접속 sid    
			
			String rexBaseUrl =  Globals.REX_REPORT_SERVICE;     //리포트 서버 url  
       
       	    if (svDirPath==null || svDirPath.equals("")){
				link="egovframework/com/cmm/egovError";
			}   
			
       	    //검색조건값 인코딩 변환 
            String svConParam = new String(svRexParam.getBytes("iso-8859-1"), "utf-8") ;
       	 
       	    //넘어온 검색조건 값을 배열에 넣어 넘김
       	    String svRexParamData =  EgovStringUtil.replace(svConParam,"&apos;","'"); 
            List<String> svArrRexParam = new ArrayList<String>();
       	    
            Scanner strSvRexParam = new Scanner(svRexParamData).useDelimiter("⊥");
            while(strSvRexParam.hasNext())  {
            	//System.out.println(strSvRexParam.next());
            	svArrRexParam.add(strSvRexParam.next()) ; 
            }
            
            
//    		System.out.println("===============================report debug============================");
//			System.out.println("svDirPath : " + pageContextPath.concat(svDirPath));   
//			System.out.println("svRdaParam : " +  svRexParamData); 
//			System.out.println("svArrRexParam : " + svArrRexParam); 
//			System.out.println("rexBaseDb : " +  rexBaseDb);  
//			System.out.println("rexBaseUrl : " +  rexBaseUrl);  
//			System.out.println("pageConfigUrl : " + pageContextPath);  
//			System.out.println("rexPageCnt : " + rexPageCnt);  
//			System.out.println("===============================report debug============================");
            
//         String[] strSvRexParam = svRexParamData.split("|]");
//    		int tokenCount = strSvRexParam.length;
//    		for (int iCnt = 0; iCnt < tokenCount; iCnt++) {
//    			svArrRexParam.add(strSvRexParam[iCnt]) ; 
//    			System.out.println("Split Output: "+ strSvRexParam[iCnt]);
//    		}
    		
//    		StringTokenizer strSvRexParam = new StringTokenizer(svRexParamData,"|]");
//       	   
//            while(strSvRexParam.hasMoreTokens()) {
//                System.out.println(strSvRexParam.nextToken());
//            	
//            } 
           
            
       	    
			model.addAttribute("svDirPath",  pageContextPath + REX_DIR_PATH_CHAR + rexServerPath + REX_DIR_PATH_CHAR + svDirPath + REX_DIR_PATH_CHAR);  //파일경로  
			//이부분에서 파람값을 변경하여 넘기는 부분을 추가 하여 처리함.
			model.addAttribute("svArrRexParam",svArrRexParam );  //검색조건값
			model.addAttribute("rexFile", rexFile);  //file name 
			model.addAttribute("rexBaseDb", rexBaseDb);  //db conn
			model.addAttribute("rexBaseUrl", rexBaseUrl);  //rex server url  
			model.addAttribute("pageConfigUrl", pageContextPath);   //TODO 임시 - 경로를 화면으로 넘김 request 객체에 값이 없음. 확인 수정필요. 
			model.addAttribute("rexPageCnt", rexPageCnt );	
		
			
			System.out.println("===============================report debug============================");
			System.out.println("svDirPath : " + pageContextPath + REX_DIR_PATH_CHAR + rexServerPath + REX_DIR_PATH_CHAR + svDirPath + REX_DIR_PATH_CHAR);   
			System.out.println("svRdaParam : " +  svRexParamData); 
			System.out.println("svArrRexParam : " + svArrRexParam); 
			System.out.println("rexBaseDb : " +  rexBaseDb);  
			System.out.println("rexBaseUrl : " +  rexBaseUrl);  
			System.out.println("pageConfigUrl : " + pageContextPath);  
			System.out.println("rexPageCnt : " + rexPageCnt);  
			System.out.println("===============================report debug============================");
		} 
		 
		//model.setViewName(link);
		
		return link;
	}
	 
}