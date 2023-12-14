package com.app.smrmf.pkg.sche.payr.generics;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.pkg.sche.payr.service.PayrScheSvcService;

@Controller  
public class PayrScheSvcContainer {


	private static final Logger logger = LoggerFactory.getLogger(PayrScheSvcContainer.class);
	 
	 //급여관련처리 
    @Autowired
    @Resource(name = "PayrScheSvcService")
    protected PayrScheSvcService payrScheSvcService; 
    
   //스케줄링 
  	public int execPayrScheFamyUnCheck(ApplicationContext ctx)  throws Exception  {
  	    
  	  return  funcPayrScheFamyUnCheck(ctx);
  	}	
  	
	/**
	 *  
	 * <pre>
	 * 1. 개요 : 가족수당 지급관련 스케줄링 
	 * 2. 처리내용 : 가족수당 해당자 중 만 19세초과   만 6세 초과시 비과세처리 루틴 스케줄링 처리 추가 
	 * </pre>
	 * @Method Name : funcPayrScheFamyUnCheck
	 * @date : 2017. 4. 11.
	 * @author : paygen
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 4. 11.		paygen				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ctx
	 * @return
	 * @throws Exception
	 */
  	private int funcPayrScheFamyUnCheck(ApplicationContext ctx) throws Exception  {
  		 
  	    if  (payrScheSvcService == null) { 
  	    	payrScheSvcService = (PayrScheSvcService)ctx.getBean("PayrScheSvcService");
        } 
  	    
  	    
  	   try {
	  		List scheLogSvcYrList = payrScheSvcService.selectFamyTgtUnCheckList(); 
	  		
	  		Iterator<Map<String, Object>> iter = scheLogSvcYrList.iterator(); 
	    
	        while ( iter.hasNext() ) {
	            Map<String, Object> map = (Map<String, Object>) iter.next(); 
	  		 
	            if (MSFSharedUtils.allowNulls(map.get("logSvcYrNumCd01")).equals(MSFSharedUtils.allowNulls(map.get("logSvcYrNumCd02")))
	            		&& MSFSharedUtils.allowNulls(map.get("logSvcMnthIcmCd01")).equals(MSFSharedUtils.allowNulls(map.get("logSvcMnthIcmCd02")))) {
	            	 
	            } else {
	            	
	              //*******************************************************************************************************/
	                //근속년수 업데이트 
	               InfcPkgPsnl0100VO  psnl0100Vo = new InfcPkgPsnl0100VO();
	               
	               psnl0100Vo.setDpobCd(String.valueOf(map.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	               psnl0100Vo.setSystemkey(String.valueOf(map.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	              
	               psnl0100Vo.setLogSvcYrNumCd(String.valueOf(map.get("logSvcYrNumCd01")));    /** column 근속년수코드 : logSvcYrNumCd */
	               psnl0100Vo.setLogSvcMnthIcmCd(String.valueOf(map.get("logSvcMnthIcmCd01")));    /** column 근속월수코드 : logSvcMnthIcmCd */ 
	                 
 
	               //if (!"20155350000001".equals(psnl0100Vo.getDpobCd())) { 
	            	//   if (!"20155370000001".equals(psnl0100Vo.getDpobCd())) {    
	            		   if ("20144050000001".equals(psnl0100Vo.getDpobCd())) {   
	            			   // 용인시청
	            			 //  scheSvcService.updatePsnl0100LogSvcYrNumCd(psnl0100Vo);
	            		   } else if ("20163900000001".equals(psnl0100Vo.getDpobCd())) {  
	            			    //광명시청 
	            			  // scheSvcService.updatePsnl0100LogSvcYrNumCd(psnl0100Vo);
	            		   }
	            	 //  }
	              // }
 
	                
	              //*******************************************************************************************************/
	            	
	           } 
				 
	  		 //System.out.println("Data" + map.get("systemkey") + ":" + map.get("yearDay") + ":" + map.get("monthDay") );
	  		}
	        
  	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
  		return 0;
  	}
 
}
