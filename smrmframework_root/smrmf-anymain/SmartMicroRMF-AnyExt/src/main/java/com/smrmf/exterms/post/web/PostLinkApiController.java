package com.smrmf.exterms.post.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.ext.constants.SysmConf;

import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
  * 
 * <pre>
 * 1. 패키지명 : com.smrmf.exterms.post.web
 * 2. 타입명 : PostLinkApiController.java
 * 3. 작성일 : Jun 12, 2016 2:16:17 PM
 * 4. 작성자 : leeheuisung
 * 5. 설명 :
 * </pre>
  */
@Controller
public class PostLinkApiController implements ServletContextAware, ServletConfigAware {

	private static final Logger logger = LoggerFactory.getLogger(PostLinkApiController.class);  
    //@Resource(name = "egovUserManageService")
    //private EgovUserManageService egovUserManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
     
  
    private String strPostConnUrl = "http://www.juso.go.kr"; //운영 인터넷망
    private String strPostConnIp = "http://10.182.60.20";  //운영 내부망
    
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
	@RequestMapping(value="/postAddr/addrDoroApi.do")
	public String RdServerToPage(HttpServletRequest request ,ModelMap model )
		            throws Exception { 
	 
		 final HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , request);  
		//ModelAndView model = new ModelAndView();
		//세션정보를 체크하여 로그인 페이지로 이동
	//	MSFSysm0100BM user = MSFServerUtils.getLoggedUser(request);
		String link = "post/addrDoroApi";  
		String strConfKey =  "";
		
		//if (user != null) { 
			
			if ("NONE".equals(extGlobals.get("PayGen.PostSystemkey"))) {
				strConfKey = "TESTJUSOGOKR";
			} else {
				strConfKey = extGlobals.get("PayGen.PostSystemkey");
			} 
       	    
			model.addAttribute("confmKey", strConfKey );  //승인키   
			  
		//} else {
			//접근권한 오류 에러 처리 할것. 
	//	}
		  
		return link;
	} 
	
	
/*
   도로명주소 검색기능은 회원가입등의 보안이 필요한 환경에서 이용할 수 있습니다. 

보안을 위해 https프로토콜을 이용하기 때문에 주소정보 검색를 위해서는 https로 호출하여 주소검색을 해야 합니다.

 

PC에서는 정상적으로 조회가 되나, 모바일에서 정상적으로 검색이 되지 않을 수 있습니다.  

이는 SSL 인증서 문제입니다.

모바일에서 SSL인증서의 웹 트러스트(web trust)인증이 아직 이뤄지지 않아 '신뢰할 수 없음'으로 표시가 됩니다.

 

▶ 검색API를 이용하여 기능 구현시 controller를 이용하여 구현 가능 합니다. 

검색API는 웹에서 Ajax를 이용하여 구현하는 방법과 어플리케이션으로 구현하는 방식이 있는데 

어플리케이션(http..)에서 구현하시면 됩니다.

 

   https 환경에서도 어플리케이션에서 http 호출하면 됨/

   String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey;  

 

* 검색API 구현 시 추가 고려사항

▶ 어플리케이션에서 연계가 정상적으로 되나 검색건수가 0일 경우에는 한글 인코딩 문제입니다.

   keyword를 URLEncoder.encode(keyword,"UTF-8") 해주시길 바랍니다.
 */
	 @RequestMapping(value="/postAddr/getAddrApi.do")
	 public void getAddrApi( HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
		    final HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , req);  
		  //  MSFSysm0100BM user = MSFServerUtils.getLoggedUser(req);
			String  strPostConnType =  "";
			//if (user != null) { 
				
				if ("".equals(EgovStringUtil.nullConvert(extGlobals.get("PayGen.PostConnType")))) {
					
					strPostConnType  = strPostConnUrl;
					
				} else {
					
					strPostConnType = extGlobals.get("PayGen.PostConnType");
					
				}  
			//} else {
				//접근권한 오류 에러 처리 할것. 
			//}
	    	String currentPage = req.getParameter("currentPage");
			String countPerPage = req.getParameter("countPerPage");
			String confmKey = req.getParameter("confmKey");
			String keyword = req.getParameter("keyword");
			String apiUrl = strPostConnType + "/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey;
			URL url = new URL(apiUrl);
	    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
	    	StringBuffer sb = new StringBuffer();
	    	String tempStr = null;
	    	while(true){
	    		tempStr = br.readLine();
	    		if(tempStr == null) break;
	    		sb.append(tempStr);	
	    	}
	    	br.close();
	    	
	    	//System.out.println("응답 : -------------------------------------------------" );
	    	//System.out.println("응답 : " + sb.toString());
	    	//System.out.println("응답 : -------------------------------------------------" );
	    	response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml");
			response.getWriter().write(sb.toString());
	    }
	  
		
	  
//	    /**
//		 * 글 목록을 조회한다. (pageing)
//		 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
//		 * @param model
//		 * @return "/sample/egovSampleList"
//		 * @exception Exception
//		 */
//	    @RequestMapping(value="/sample/egovSampleList.do")
//	    public String selectSampleList(@ModelAttribute("searchVO") SampleDefaultVO searchVO, HttpServletRequest req,
//	    		ModelMap model)
//	            throws Exception {
//	    	
//	    	return "/sample/egovSampleList";
//	    } 
//	    @RequestMapping(value="/sample/jusoPopup.do")
//	    public String jusoPopup(@ModelAttribute("searchVO") SampleDefaultVO searchVO, HttpServletRequest req,
//	    		ModelMap model)
//	            throws Exception {
//	    	return "/sample/jusoPopup";
//	    }     
//	    
//	    @RequestMapping(value="/sample/getAddrApi.do")
//	    public void getAddrApi(@ModelAttribute("searchVO") SampleDefaultVO searchVO, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
//
//	    	String host = "http://www.juso.go.kr"; //운영 인터넷망
//	    	String currentPage = req.getParameter("currentPage");
//			String countPerPage = req.getParameter("countPerPage");
//			String confmKey = req.getParameter("confmKey");
//			String keyword = req.getParameter("keyword");
//			String apiUrl = host + "/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey;
//			URL url = new URL(apiUrl);
//	    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
//	    	StringBuffer sb = new StringBuffer();
//	    	String tempStr = null;
//	    	while(true){
//	    		tempStr = br.readLine();
//	    		if(tempStr == null) break;
//	    		sb.append(tempStr);	
//	    	}
//	    	br.close();
//	    	
//	    	System.out.println("응답 : " + sb.toString());
//	    	
//	    	response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/xml");
//			response.getWriter().write(sb.toString());
//	    }
//	    
//	    @RequestMapping(value="/sample/getAddrApiTest.do")
//	    public void getAddrApiTest(@ModelAttribute("searchVO") SampleDefaultVO searchVO, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
//
//	    	String host = "http://10.60.182.139:8080";
//	    	String currentPage = req.getParameter("currentPage");
//			String countPerPage = req.getParameter("countPerPage");
//			String confmKey = req.getParameter("confmKey");
//			String keyword = req.getParameter("keyword");
//			String apiUrl = host + "/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey;
//			URL url = new URL(apiUrl);
//	    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
//	    	StringBuffer sb = new StringBuffer();
//	    	String tempStr = null;
//	    	while(true){
//	    		tempStr = br.readLine();
//	    		if(tempStr == null) break;
//	    		sb.append(tempStr);	
//	    	}
//	    	br.close();
//	    	
//	    	System.out.println("응답 : " + sb.toString());
//	    	
//	    	response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/xml");
//			response.getWriter().write(sb.toString());
//	    }
//	    
//	    @RequestMapping(value="/sample/getAddrApiJson.do")
//	    public void getAddrApiJson(@ModelAttribute("searchVO") SampleDefaultVO searchVO, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
//	    	
//	    	String host = "http://www.juso.go.kr"; //운영 인터넷망
//	    	String currentPage = req.getParameter("currentPage");
//	    	String countPerPage = req.getParameter("countPerPage");
//	    	String resultType = req.getParameter("resultType");
//	    	String confmKey = req.getParameter("confmKey");
//	    	String keyword = req.getParameter("keyword");
//	    	String apiUrl = host + "/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey+"&resultType="+resultType;
//	    	URL url = new URL(apiUrl);
//	    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
//	    	StringBuffer sb = new StringBuffer();
//	    	String tempStr = null;
//	    	while(true){
//	    		tempStr = br.readLine();
//	    		if(tempStr == null) break;
//	    		sb.append(tempStr);	
//	    	}
//	    	br.close();
//	    	
//	    	System.out.println("응답 : " + sb.toString());
//	    	
//	    	response.setCharacterEncoding("UTF-8");
//	    	response.setContentType("text/xml");
//	    	response.getWriter().write(sb.toString());
//	    }
//	    
//	    @RequestMapping(value="/sample/getAddrApiJsonTest.do")
//	    public void getAddrApiJsonTest(@ModelAttribute("searchVO") SampleDefaultVO searchVO, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
//	    	
//	    	String host = "http://10.60.182.139:8080";
//	    	String currentPage = req.getParameter("currentPage");
//	    	String countPerPage = req.getParameter("countPerPage");
//	    	String resultType = req.getParameter("resultType");
//	    	String confmKey = req.getParameter("confmKey");
//	    	String keyword = req.getParameter("keyword");
//	    	String apiUrl = host + "/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey+"&resultType="+resultType;
//	    	URL url = new URL(apiUrl);
//	    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
//	    	StringBuffer sb = new StringBuffer();
//	    	String tempStr = null;
//	    	while(true){
//	    		tempStr = br.readLine();
//	    		if(tempStr == null) break;
//	    		sb.append(tempStr);	
//	    	}
//	    	br.close();
//	    	
//	    	System.out.println("응답 : " + sb.toString());
//	    	
//	    	response.setCharacterEncoding("UTF-8");
//	    	response.setContentType("text/xml");
//	    	response.getWriter().write(sb.toString());
//	    }
 
	 
}