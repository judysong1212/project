package com.web.exterms.report.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.smrmf.core.msfmainapp.server.utils.AnyLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.ext.constants.PropConfs;
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
public class ComClipServerController {

	private static final String calledClass = ComClipServerController.class.getName();
	private ServletContext svltContext;
	private ServletConfig svltConfig;

	private static final Logger logger = LoggerFactory.getLogger(ComClipServerController.class);  
	//@Resource(name = "egovUserManageService")
	//private EgovUserManageService egovUserManageService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	public final static String REX_DIR_PATH_CHAR = "/";
	private static final  String REX_TOKEN_DELIMITER = "⊥";


	private static   String REXPRINTMODE = "PROD";

	/**
	 * rda 리포트 출력을 위한 설정 및 호출 페이지 
	 */ 
	@RequestMapping(value="/PayGenClipReport.do")
	public String RdServerToPage(HttpServletRequest request , HttpServletResponse response , HttpSession session ,ModelMap model
			,@RequestParam(value="svDirPath", required=true) String svDirPath
			,@RequestParam(value="svRexParam", required=true) String svRexParam
			,@RequestParam(value="rexFile", required=true) String rexFile
			,@RequestParam(value="rexPageCnt", required=true) String rexPageCnt )
					throws Exception { 

		String method = calledClass + ".RdServerToPage";
		String windowNm = "레포트 출력";
		String windowId = "RexReport";

		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);	

		System.out.println("===============================report debug============================");
		System.out.println("svDirPath : " +svDirPath);   
		System.out.println("svRexParam : " +  svRexParam); 
		System.out.println("rexFile : " + rexFile);  
		System.out.println("rexPageCnt : " + rexPageCnt);  
		System.out.println("===============================report debug============================");

		//ModelAndView model = new ModelAndView();
		//세션정보를 체크하여 로그인 페이지로 이동
		String rexServerPath = Globals.REX_SERVER_PATH;   //리포트 출력물 디렉토리 
		String link = "rexserver/ClipReport"; 
		String pageContextPath = "";
		// contextPath() null 인경우 처리 추가  = pageUrl;
		
		try{
			
			pageContextPath = request.getContextPath() == null ? Globals.EXTERM_REPORT_PATH_URL: request.getContextPath();
			if("".equals(pageContextPath)){

				pageContextPath = Globals.EXTERM_REPORT_PATH_URL;  // 경로가  없는경우 설정된 경로 값 
			} 

			if (REXPRINTMODE.equals(Globals.REX_PRINT_MODE)) {
				link = "rexserver/ClipReport4"; 
			} else {
				link = "rexserver/ClipReport";  
			}
			//MyPageSessionVO mysession = (MyPageSessionVO)EgovSessionCookieUtil.getSessionAttribute(request, "mysession");

			if ( (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request)  != null) {


				String rexBaseDb = Globals.REX_SERVER_SID ;  //리포트 디비 접속 sid    

				String rexBaseUrl =  Globals.REX_REPORT_SERVICE;     //리포트 서버 url  

				if (svDirPath==null || svDirPath.equals("")){
					link="egovframework/com/cmm/egovError";
				}   

				//검색조건값 인코딩 변환 
				//   String svConParam = new String(svRexParam.getBytes("iso-8859-1"), "utf-8") ;

				String svRexParamData =  EgovStringUtil.replace(svRexParam,"&apos;","'");  
				List<String> svArrRexParam = new ArrayList<String>();

				Scanner strSvRexParam = new Scanner(svRexParamData).useDelimiter("⊥");
				while(strSvRexParam.hasNext())  {
					//System.out.println(strSvRexParam.next());
					svArrRexParam.add(strSvRexParam.next()) ; 
				}


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



				model.addAttribute("svClipDirPath",  pageContextPath + REX_DIR_PATH_CHAR + rexServerPath + REX_DIR_PATH_CHAR + svDirPath + REX_DIR_PATH_CHAR);  //파일경로  
				//이부분에서 파람값을 변경하여 넘기는 부분을 추가 하여 처리함.
				model.addAttribute("svArrClipParam",svArrRexParam );  //검색조건값
				model.addAttribute("clipFile", rexFile);  //file name 
				model.addAttribute("clipBaseDb", rexBaseDb);  //db conn
				model.addAttribute("clipBaseUrl", rexBaseUrl);  //rex server url  
				model.addAttribute("pageClipConfigUrl", pageContextPath);   //TODO 임시 - 경로를 화면으로 넘김 request 객체에 값이 없음. 확인 수정필요. 
				model.addAttribute("clipPageCnt", rexPageCnt );	


				System.out.println("===============================report debug============================");
				System.out.println("svClipDirPath : " + pageContextPath + REX_DIR_PATH_CHAR + rexServerPath + REX_DIR_PATH_CHAR + svDirPath + REX_DIR_PATH_CHAR);   
				System.out.println("svArrClipParam : " +  svArrRexParam); 
				System.out.println("clipFile : " + rexFile); 
				System.out.println("clipBaseDb : " +  rexBaseDb);  
				System.out.println("clipBaseUrl : " +  rexBaseUrl);  
				System.out.println("pageClipConfigUrl : " + pageContextPath);  
				System.out.println("clipPageCnt : " + rexPageCnt);  
				System.out.println("link : " + link);  
				System.out.println("===============================report debug============================");
			} 
			
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.LIST.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.LIST.toString());

		//model.setViewName(link);

		return link;
	}

}