package com.smrmf.exterms.interceptor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
public class SpringCheckInterceptor extends HandlerInterceptorAdapter   implements ServletContextAware, ServletConfigAware {
	

		private static final Logger logger = LoggerFactory.getLogger(SpringCheckInterceptor.class);
	 
	    private ServletContext sevltContext;
	    
	    private ServletConfig sevltConfig;
	    

		@Override
		public void setServletConfig(ServletConfig servletConfig) {
			 
			   this.sevltConfig = servletConfig;
		}

		@Override
		public void setServletContext(ServletContext servletContext) {
			 
			this.sevltContext = servletContext;

		}

	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		 
		// DispatcherServlet dpServlet = new DispatcherServlet(); 
		//String url = request.getRequestURI().substring(request.getContextPath().length());
		//System.out.println("요청 URL : " +url);
		//if(url.indexOf("/ExTermsPage.do") > -1 
	    //|| url.indexOf("/SSOLogin/SSOLogin.do") > -1
	    //|| url.indexOf("/SSOLogin/ATTRLogin.do") > -1
	    //|| url.indexOf("/login/actionLogout.do") > -1 
	    //|| url.indexOf("/ajax/") > -1){
		//	return true;
		//}else{
		  //  String rootPath   =  request.getContextPath();
		    RemoteServiceUtil.setThreadHandleLocals(request, response, sevltContext,  sevltConfig);
		
			// session검사
			HttpSession session = request.getSession(false);
			if (session != null && null != session.getAttribute("extermuser") ) {
				//ServletContext 객체 가져오기 
			   // ServletContext servletContext = session.getServletContext();
			     
				//RemoteServiceUtil.setThreadHandleLocals(request,
				//		response, dpServlet.getServletContext(), dpServlet.getServletConfig());
				
				return true;
			}else{
				//response.sendRedirect(Globals.EXTERM_SSO_LINK_PAGE.concat("/ExTermsPage.do"));   
				return true;
			}
			/*
			Map<String, String> paramMap = request.getParameterMap();
			
			
			String params = "";
			for ( Map.Entry keyValue : paramMap.entrySet() )
			{
			  String value = request.getParameter(String.valueOf(keyValue.getKey()));
			  System.out.println("파라미터 = "+keyValue.getKey() + ":" +value );
			  
			  //App 쪽의 파라미터 strWebId 가 넘어올경우 
			  if("strWebId".equals(keyValue.getKey())){
				  params += "strWebId="+value;
			  }
			}
			
			if(!"".equals(params) && url.indexOf("/mypage/SSOLogin.do") > -1){
				response.sendRedirect("/mypage/SSOLogin.do?"+params);
				return true;
			}
			
			
			response.sendRedirect("/mypage/Login.do");
			return false;
			*/
	 
		//}
	}

	
	

}
