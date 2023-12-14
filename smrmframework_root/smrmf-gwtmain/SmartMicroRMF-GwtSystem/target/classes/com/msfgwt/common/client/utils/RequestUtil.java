package com.msfgwt.common.client.utils;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	
	private static ThreadLocal<HttpServletRequest> currentRequest = new ThreadLocal<HttpServletRequest>();

    public static void setCurrentRequest(HttpServletRequest request) {
        currentRequest.set(request);
    }
    
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        currentRequest.set(httpRequest);
        try {
            // 필터 체인 계속 진행
            try {
				chain.doFilter(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } finally {
            // 필터 처리 완료 후 ThreadLocal 값 제거
            currentRequest.remove();
        }
    }
   
    public static HttpServletRequest getCurrentRequest() {
        return currentRequest.get();
    }

    public static void clearCurrentRequest() {
        currentRequest.remove();
    }

}
