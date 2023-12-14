package com.smrmf.exterms.report.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.ext.constants.SysmConf;

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
public class ComRdServerController implements ServletContextAware, ServletConfigAware {

	private static final Logger logger = LoggerFactory.getLogger(ComRdServerController.class);  
    //@Resource(name = "egovUserManageService")
    //private EgovUserManageService egovUserManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

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
	 * rda 리포트 출력을 위한 설정 및 호출 페이지 
	 */ 
	@RequestMapping(value="/ExTermsReport.do")
	public String RdServerToPage(HttpServletRequest request ,ModelMap model
			,@RequestParam(value="svDirPath", required=true) String svDirPath
			,@RequestParam(value="svRdaParam", required=true) String svRdaParam
			,@RequestParam(value="rdaFile", required=true) String rdaFile
			,@RequestParam(value="rdaUrl", required=true) String rdaUrl
			,@RequestParam(value="pageUrl", required=true) String pageUrl)
		            throws Exception { 
	 
		 final HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , request); 
		 
		//ModelAndView model = new ModelAndView();
		//세션정보를 체크하여 로그인 페이지로 이동
	//	MSFSysm0100BM user = MSFServerUtils.getLoggedUser(request);
		String link = "rdaserver/RdaReport"; 
		String pageContextPath = "";
		// contextPath() null 인경우 처리 추가 
		//if (request.getContextPath() == null || request.getContextPath() == "") {
		pageContextPath = pageUrl;
		//}  
		
	//	if (user != null) {

			
	//		String svDirPath = request.getContextPath() + String.valueOf(model.get("svDirPath"));
	//		String svRdaParam = String.valueOf(model.get("svRdaParam"));
	//		String rdaFile = String.valueOf(model.get("rdaFile"));
	//		String rdaUrl = String.valueOf(model.get("rdaUrl"));
			 
			//Globals.RDA_SERVER_SID 
			String rdaConfigUrl = "/rsn [" + extGlobals.get("PayGen.RdaServerSID")  + "] /rf [" + rdaUrl + "] "; 
			
			//String rdaConfigUrl = "/rsn [exterms] /rf [" + rdaUrl + "] "; 
			     
			//데이터를 리포트 처리 do로 넘김 
//	    	model.getModelMap().addAttribute("svDirPath",   svDirPath);   
//			model.getModelMap().addAttribute("svRdaParam", svRdaParam); 
//			model.getModelMap().addAttribute("rdaFile", rdaFile); 
//			model.getModelMap().addAttribute("rdaConfigUrl", rdaConfigUrl); 
       
       	    if (svDirPath==null || svDirPath.equals("")){
				link="egovframework/com/cmm/egovError";
			}   
			
			model.addAttribute("svDirPath",  pageUrl.concat(svDirPath));    //pageContextPath.concat(svDirPath)  
			model.addAttribute("svRdaParam", EgovStringUtil.replace(svRdaParam,"&apos;","'"));   //EgovStringUtil.replace(svRdaParam,"&apos;","'")  //svRdaParam.replace("&apos;","'")
			model.addAttribute("rdaFile", rdaFile); 
			model.addAttribute("rdaConfigUrl", rdaConfigUrl);  
			model.addAttribute("pageConfigUrl", pageUrl);   //TODO 임시 - 경로를 화면으로 넘김 request 객체에 값이 없음. 확인 수정필요. 
				
		
			
//			System.out.println("===============================report debug============================");
//			System.out.println("svDirPath : " + pageContextPath.concat(svDirPath));   
//			System.out.println("svRdaParam : " +  svRdaParam); 
//			System.out.println("rdaFile : " + rdaFile); 
//			System.out.println("rdaConfigUrl : " +  rdaConfigUrl);  
//			System.out.println("pageConfigUrl : " + pageUrl);  
//			System.out.println("===============================report debug============================");
	//	} 
		 
		//model.setViewName(link);
		
		return link;
	}
	 
}