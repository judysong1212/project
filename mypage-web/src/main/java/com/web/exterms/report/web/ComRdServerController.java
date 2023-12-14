package com.web.exterms.report.web;

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
import egovframework.com.utl.fcc.service.EgovStringUtil;
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
public class ComRdServerController {

	private static final String calledClass = ComRdServerController.class.getName();
	private ServletContext svltContext;
	private ServletConfig svltConfig;

	private static final Logger logger = LoggerFactory.getLogger(ComRdServerController.class);  
	//@Resource(name = "egovUserManageService")
	//private EgovUserManageService egovUserManageService;

	public final static String RDA_DIR_PATH_CHAR = "/";                   

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/**
	 * rda 리포트 출력을 위한 설정 및 호출 페이지 
	 * RequestParam : value=파라미터이름(String), required=해당 파라미터가 반드시 필수 인지 여부, 기본값 true(boolean)
	 * ProofAccept.jsp에서
	 */ 
	@RequestMapping(value="/ExTermsReport.do")
	public String RdServerToPage(HttpServletRequest request , HttpSession session
			,HttpServletResponse response 
			,ModelMap model
			,@RequestParam(value="svDirPath", required=true) String svDirPath	 	
			,@RequestParam(value="svRdaParam", required=true) String svRdaParam  
			,@RequestParam(value="rdaFile", required=true) String rdaFile		
			,@RequestParam(value="rdaPageCnt", required=true) String rdaPageCnt  
			)  throws Exception { 
		// 출력물 디렉토리 패스경로 인사 : strDirPath
		// 파라미터 : svRdaParam
		// mrd 출력물 : rdaFileName 	
		// 페이지수 : rdaPageCnt
		String method = calledClass + ".RdServerToPage";
		String windowNm = "레포트 출력";
		String windowId = "RdaReport";

		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);	

		//rda 파일경로  : RDA_SERVER_PATH
		String rdaServerPath = Globals.RDA_SERVER_PATH;  
		String link = "rdaserver/RdaReport"; 

		try{
			if ( EgovSessionCookieUtil.getSessionAttribute(request, sessionUser.getUsrId())   != null) {

				// RDA_SERVER_SID : exterms, RDA_REPORT_SERVICE : http://121.170.65.28:8088/RDServer/rdagent.jsp
				String rdaConfigUrl = "/rsn [" + Globals.RDA_SERVER_SID + "] /rf [" + Globals.RDA_REPORT_SERVICE  + "] /rprnn [" + rdaPageCnt + "] ";  
				//String rdaConfigUrl = "/rsn [exterms] /rf [" + rdaUrl + "] "; 

				if (svDirPath ==null || svDirPath.equals("")){
					link="egovframework/com/cmm/egovError";
				}   

				//report 경로 : EXTERM_REPORT_PATH_URL
				// String path = "http://192.168.0.4:8088";
				String path = request.getContextPath() == null ? Globals.EXTERM_REPORT_PATH_URL: request.getContextPath();
				if("".equals(path)){
					path = Globals.EXTERM_REPORT_PATH_URL;
				}

				model.addAttribute("svDirPath",  path + RDA_DIR_PATH_CHAR + rdaServerPath + RDA_DIR_PATH_CHAR + svDirPath + RDA_DIR_PATH_CHAR); 				//출력물 디렉토리 패스경로 인사
				model.addAttribute("svRdaParam", EgovStringUtil.replace(svRdaParam ,"&apos;","'"));		//파라미터 : [DPOB_CD], [SYSTEMKEY], [PRF_ISS_NUM] 
				model.addAttribute("rdaFile", rdaFile );			//파일이름 
				model.addAttribute("rdaConfigUrl", rdaConfigUrl );	 
				model.addAttribute("rdaPageCnt", rdaPageCnt );		//페이지수 
				model.addAttribute("pageConfigUrl", path);

				System.out.println("===============================report debug============================");
				System.out.println("svDirPath : " + path + RDA_DIR_PATH_CHAR + rdaServerPath + RDA_DIR_PATH_CHAR + svDirPath + RDA_DIR_PATH_CHAR);   
				System.out.println("svRdaParam : " +  EgovStringUtil.replace(svRdaParam ,"&apos;","'")); 
				System.out.println("rdaFile : " + rdaFile); 
				System.out.println("rdaConfigUrl : " +  rdaConfigUrl);  
				System.out.println("rdaPageCnt : " +  rdaPageCnt);  
				System.out.println("pageConfigUrl : " + path);  
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
		
		return link;
	}

}