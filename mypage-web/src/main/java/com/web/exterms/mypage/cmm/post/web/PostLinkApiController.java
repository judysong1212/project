package com.web.exterms.mypage.cmm.post.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.web.exterms.mypage.login.service.MyPageSessionVO;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
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
      *  
      * <pre>
      * 1. 개요 : 우편번호 처리를 위한 루틴  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : RdServerToPage
      * @date : 2016. 6. 23.
      * @author : Administrator
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2016. 6. 23.		Administrator				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param request
      * @param model
      * @return
      * @throws Exception
      */
	@RequestMapping(value="/postAddr/addrDoroApi.do")
	public String RdServerToPage(HttpSession session,HttpServletRequest request ,ModelMap model )
		            throws Exception { 
	  
		//ModelAndView model = new ModelAndView();
		//세션정보를 체크하여 로그인 페이지로 이동
		 
		String link = "/mypage/common/addrDoroApi";  
		String strConfKey =  "";
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		
		if (sessionUser.getSystemkey() == null) {
			throw new Exception("세션정보 에러 프로그램오류"); 
		} else {  
			
			if ("NONE".equals(Globals.POSTSYSTEMKEY)) {
				strConfKey = "TESTJUSOGOKR";
			} else {
				strConfKey = Globals.POSTSYSTEMKEY;
			} 
       	    
			model.addAttribute("confmKey", strConfKey );  //승인키   
		 
		}
		  
		return link;
	} 
	
	 @RequestMapping(value="/postAddr/getAddrApi.do")
	 public void getAddrApi(HttpSession session, HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {

	    	String currentPage = req.getParameter("currentPage");
			String countPerPage = req.getParameter("countPerPage");
			String confmKey = req.getParameter("confmKey");
			String keyword = req.getParameter("keyword");
			String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey;
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
	    	response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml");
			response.getWriter().write(sb.toString());
	    }
	 
}