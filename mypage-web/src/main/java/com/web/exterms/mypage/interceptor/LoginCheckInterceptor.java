package com.web.exterms.mypage.interceptor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.web.exterms.mypage.login.service.MyPageSessionVO;

import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
 
public class LoginCheckInterceptor extends HandlerInterceptorAdapter  implements ServletContextAware, ServletConfigAware {
	
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
	 
		//DispatcherServlet dpServlet = new DispatcherServlet(); 
		String url = request.getRequestURI().substring(request.getContextPath().length());
		
		RemoteServiceUtil.setThreadHandleLocals(request, response, sevltContext,  sevltConfig);
		
		//System.out.println("요청 URL : " +url);
		if(url.indexOf("/mypage/LoginProcess.do") > -1 
	    || url.indexOf("/mypage/Login.do") > -1
	    || url.indexOf("/mypage/Logout.do") > -1
	    || url.indexOf("/mypage/signMemberPop.do") > -1
	    || url.indexOf("/mypage/SSOLogin.do") > -1
	    || url.indexOf("/ajax/") > -1){
		//	RemoteServiceUtil.clearThreadLocals();
			return true;
		}else{
			 
			MyPageSessionVO mysession = (MyPageSessionVO)EgovSessionCookieUtil.getSessionAttribute(request, "flagChk");
			// session검사			
			if (mysession != null && null != mysession.getUsrId()) {
			//	RemoteServiceUtil.setThreadHandleLocals(request, response, sevltContext,  sevltConfig);
				return true;
			}else{
				response.sendRedirect("/mypage/Login.do");
			//	RemoteServiceUtil.clearThreadLocals();
				return false;
			}
			
			
			
			//return true;
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
		}
		
		 
	}
  
}
