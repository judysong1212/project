package com.app.smrmf.infc.sysif.msfpackage.server.utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysm.server.service.SysIfPkgSmrmfService;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0320VO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0400VO;

public class SysifPkgServiceUtils {
   
	 
	
	@Autowired 
	@Resource(name="SysIfPkgSmrmfService")
	private static SysIfPkgSmrmfService sysIfPkgSmrmfService;
		
		
/************************************* 시점에 따른 사용 부서, 직종, 직종세 데이타를 가져와 넘기는 부분으로 이 부분은 차후 추가 하여 처리할 부분 존재 ******************************/
		
/**
 * 		
 * <pre>
 * 1. 개요 :   기간에 따른 부서 리스트를 리스트 형태로 리턴 한다.  
 * 2. 처리내용 : 
 * </pre>
 * @Method Name : funcArrBeforDeptCd
 * @date : 2017. 1. 21.
 * @author : atres-pc
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2017. 1. 21.		atres-pc				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @param sysIfBass0400Vo
 * @return
 * @throws Exception 
 */
public static final SysIfBass0400VO funcArrBeforDeptCd(HttpServletRequest request,SysIfBass0400VO sysIfBass0400Vo ) throws Exception {
	
	  SysIfBass0400VO listResult = new SysIfBass0400VO();  
  
	 if  (MSFSharedUtils.paramNull(sysIfPkgSmrmfService)) {
         
         WebApplicationContext wac = WebApplicationContextUtils.
                 getRequiredWebApplicationContext( request.getSession().getServletContext());

         sysIfPkgSmrmfService = (SysIfPkgSmrmfService) wac.getBean("SysIfPkgSmrmfService" ); 
     }
     
	listResult = sysIfPkgSmrmfService.getFuncBeforComboBass0400List(sysIfBass0400Vo );  
	
	return listResult;
}	

/**
 * 
 * <pre>
 * 1. 개요 : 기간에 포함 되어 있는 리스트를 직종에 대해 출력한다.  
 * 2. 처리내용 : 
 * </pre>
 * @Method Name : funcArrBeforTypOccuCd
 * @date : 2017. 1. 21.
 * @author : atres-pc
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2017. 1. 21.		atres-pc				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @param sysComBass0320Vo
 * @return
 * @throws Exception 
 */
public static final SysIfBass0320VO funcArrBeforTypOccuCd(HttpServletRequest request,SysIfBass0320VO sysComBass0320Vo) throws Exception{
	
	SysIfBass0320VO listResult = new SysIfBass0320VO(); 

	 if  (MSFSharedUtils.paramNull(sysIfPkgSmrmfService)) {
        
        WebApplicationContext wac = WebApplicationContextUtils.
                getRequiredWebApplicationContext( request.getSession().getServletContext());

        sysIfPkgSmrmfService = (SysIfPkgSmrmfService) wac.getBean("SysIfPkgSmrmfService" ); 
    }
    
	listResult = sysIfPkgSmrmfService.getFuncBeforComboBass0320List(sysComBass0320Vo) ;
	return listResult;
}	

public static final SysIfBass0350VO getFuncBeforDtilOccuInttnCd(HttpServletRequest request,SysIfBass0350VO sysIfBass0350Vo) throws Exception{
	
	     SysIfBass0350VO listResult = new SysIfBass0350VO(); 

		 if  (MSFSharedUtils.paramNull(sysIfPkgSmrmfService)) {
	         
	         WebApplicationContext wac = WebApplicationContextUtils.
	                 getRequiredWebApplicationContext( request.getSession().getServletContext());

	         sysIfPkgSmrmfService = (SysIfPkgSmrmfService) wac.getBean("SysIfPkgSmrmfService" ); 
	     }
	     
		 
	   listResult = sysIfPkgSmrmfService.getFuncBeforComboBass0350List(sysIfBass0350Vo ) ; 
	 
	return listResult;
}	
		
/************************************* 시점에 따른 사용 부서, 직종, 직종세 데이타를 가져와 넘기는 부분으로 이 부분은 차후 추가 하여 처리할 부분 존재 ******************************/		
	
	
}
 