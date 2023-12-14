package com.app.exterms.prgm.server.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;



public class PrgmComUtils {
	
	private static PrintWriter out ;
	
 
	public static final void responseAlert(final HttpServletResponse response, String msg){
      try{
		response.setContentType("text/html; charset=UTF-8");

        out = response.getWriter();
        out.println("<script>alert('"+msg+"'); </script>"); 
        out.flush(); 
      }catch(Exception ex){
    	  ex.printStackTrace();
      } 
	}
 
	
}
