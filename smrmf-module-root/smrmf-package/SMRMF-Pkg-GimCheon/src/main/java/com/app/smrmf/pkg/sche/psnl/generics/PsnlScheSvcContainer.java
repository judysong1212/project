package com.app.smrmf.pkg.sche.psnl.generics;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.app.exterms.personal.client.dto.InfcPkgPsnl0100DTO;
import com.app.exterms.personal.client.dto.InfcPkgPsnl0123DTO;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.pkg.sche.psnl.service.ScheSvcService;
import com.app.smrmf.props.ExtermsProps;

import egovframework.let.utl.fcc.service.EgovDateUtil;

@Controller  
public class PsnlScheSvcContainer {


	private static final Logger logger = LoggerFactory.getLogger(PsnlScheSvcContainer.class);
	 
	 //근속년수 
    @Autowired
    @Resource(name = "ScheSvcService")
    protected ScheSvcService scheSvcService; 
    
   //스케줄링 
  	public int execPsnlScheLogSvcYr(ApplicationContext ctx)  throws Exception  {
  	    
  	  return  funcPsnlScheLogSvcYr(ctx);
  	}	
  	
	//근속년수 스케줄처리 
  	private int funcPsnlScheLogSvcYr(ApplicationContext ctx) throws Exception  {
  		 
  	    if  (scheSvcService == null) { 
         
  	    	scheSvcService = (ScheSvcService)ctx.getBean("ScheSvcService"); 
         
        } 
  	    
  	    
  	   try {
	  		List scheLogSvcYrList = scheSvcService.selectScheLogSvcYrList(); 
	  		
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
	            			   scheSvcService.updatePsnl0100LogSvcYrNumCd(psnl0100Vo);
	            		   } else if ("20163900000001".equals(psnl0100Vo.getDpobCd())) {  
	            			    //광명시청 
	            			   scheSvcService.updatePsnl0100LogSvcYrNumCd(psnl0100Vo);
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

	public int execPsnl0123ToPanl0100Update(ApplicationContext ctx) {
		 if  (scheSvcService == null) { 
	         
	  	    	scheSvcService = (ScheSvcService)ctx.getBean("ScheSvcService"); 
	         
	        } 
	  	    
	  	    
	  	   try {
		  		List schePsnl0123ToPanl0100List = scheSvcService.selectPsnl0123ToPanl0100List(); 
		  		
		  		Iterator<Map<String, Object>> iter = schePsnl0123ToPanl0100List.iterator(); 
		    
		        while ( iter.hasNext() ) {
		            Map<String, Object> map = (Map<String, Object>) iter.next(); 
		  		 
		          //  if (map.get("logSvcYrNumCd01").equals(map.get("logSvcYrNumCd02"))) {
		             
		              //*******************************************************************************************************/
		            	InfcPkgPsnl0100DTO infcPsnl0100Dto = new InfcPkgPsnl0100DTO();
					  
		            	infcPsnl0100Dto.setDpobCd(map.get("dpobCd").toString());
		            	infcPsnl0100Dto.setSystemkey(map.get("systemkey").toString());    /** column SYSTEMKEY : systemkey */
		            	infcPsnl0100Dto.setHdofcCodtnCd(ExtermsProps.getProps("HDOFC_CODTN_CD_10"));   //마스터 재직변경 
		            	infcPsnl0100Dto.setRetryDt(null);
		            	infcPsnl0100Dto.setRetryReasCtnt("");  
						 
							//재직처리 루틴 호출 
							scheSvcService.updatePsnl0100ToPsnlStat(infcPsnl0100Dto);
		                
		              //*******************************************************************************************************/
					 if (MSFSharedUtils.paramNull(map.get("turtyRntmntDt"))) {
						  //*******************************************************************************************************/
			            	InfcPkgPsnl0123DTO infcPsnl0123Dto = new InfcPkgPsnl0123DTO();
						  
			            	infcPsnl0123Dto.setDpobCd(String.valueOf(map.get("dpobCd")));
			            	infcPsnl0123Dto.setSystemkey(String.valueOf(map.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			            	infcPsnl0123Dto.setTurtyRntmntDt( SmrmfUtils.getDateFromString(EgovDateUtil.addDay(String.valueOf(map.get("levfAbncEndDt")),1),"yyyyMMdd") );   //마스터 재직변경 
			            	
							//재직처리 루틴 호출 
							scheSvcService.updateSchePsnl0123(infcPsnl0123Dto);
			                
			              //*******************************************************************************************************/
					 } else {
						  //*******************************************************************************************************/
			            	InfcPkgPsnl0123DTO infcPsnl0123Dto = new InfcPkgPsnl0123DTO();
						  
			            	infcPsnl0123Dto.setDpobCd(String.valueOf(map.get("dpobCd")));
			            	infcPsnl0123Dto.setSystemkey(String.valueOf(map.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			            	infcPsnl0123Dto.setTurtyRntmntDt( SmrmfUtils.getDateFromString(String.valueOf(map.get("turtyRntmntDt")),"yyyyMMdd") );   //마스터 재직변경 
			            	
							//재직처리 루틴 호출 
							scheSvcService.updateSchePsnl0123(infcPsnl0123Dto);
			                
			              //*******************************************************************************************************/ 
						 
					 }		
							
		            	
		        //   } 
					 
		  		}
		        
	  	    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	   
		return 0;
	} 
	
	
	public int execPsnl0100EndToPanl0100Update(ApplicationContext ctx) {
		 if  (scheSvcService == null) { 
	         
	  	    	scheSvcService = (ScheSvcService)ctx.getBean("ScheSvcService"); 
	         
	        } 
	  	    
	  	    
	  	   try {
	  		   //기간제 오류 수정 배치 
	  		     List schePsnl0100EndToRePanl0100List = scheSvcService.selectPsnl0100EndToRePanl0100List(); 
		  		
		  		Iterator<Map<String, Object>> iterRe = schePsnl0100EndToRePanl0100List.iterator(); 
		    
		        while ( iterRe.hasNext() ) {
		            Map<String, Object> mapRe = (Map<String, Object>) iterRe.next(); 
		  		 
		          //  if (map.get("logSvcYrNumCd01").equals(map.get("logSvcYrNumCd02"))) {
		             
		              //*******************************************************************************************************/
		            	InfcPkgPsnl0100DTO infcPsnl0100Dto = new InfcPkgPsnl0100DTO();
					  
		            	infcPsnl0100Dto.setDpobCd(String.valueOf(mapRe.get("dpobCd")));
		            	infcPsnl0100Dto.setSystemkey(String.valueOf(mapRe.get("systemkey")));    /** column SYSTEMKEY : systemkey */
		            	infcPsnl0100Dto.setHdofcCodtnCd(ExtermsProps.getProps("HDOFC_CODTN_CD_10"));   //마스터 재직변경 
		            	infcPsnl0100Dto.setRetryDt("");
		            	infcPsnl0100Dto.setRetryReasCtnt("");  
						 
							//재직처리 루틴 호출 
							scheSvcService.updatePsnl0100ToPsnlStat(infcPsnl0100Dto);
		                
		              //*******************************************************************************************************/
		            	
		        //   } 
					 
		  		}
	  		   
	  		   
		  		List schePsnl0100EndToPanl0100List = scheSvcService.selectPsnl0100EndToPanl0100List(); 
		  		
		  		Iterator<Map<String, Object>> iter = schePsnl0100EndToPanl0100List.iterator(); 
		    
		        while ( iter.hasNext() ) {
		            Map<String, Object> map = (Map<String, Object>) iter.next(); 
		  		 
		          //  if (map.get("logSvcYrNumCd01").equals(map.get("logSvcYrNumCd02"))) {
		             
		              //*******************************************************************************************************/
		            	InfcPkgPsnl0100DTO infcPsnl0100Dto = new InfcPkgPsnl0100DTO();
					  
		            	infcPsnl0100Dto.setDpobCd(String.valueOf(map.get("dpobCd")));
		            	infcPsnl0100Dto.setSystemkey(String.valueOf(map.get("systemkey")));    /** column SYSTEMKEY : systemkey */
		            	infcPsnl0100Dto.setHdofcCodtnCd(ExtermsProps.getProps("HDOFC_CODTN_CD_20"));   //마스터 재직변경 
		            	infcPsnl0100Dto.setRetryDt(String.valueOf(map.get("emymtEndDt")) );
		            	infcPsnl0100Dto.setRetryReasCtnt(String.valueOf(map.get("emymtReasCtnt")));  
						 
							//재직처리 루틴 호출 
							scheSvcService.updatePsnl0100ToPsnlStat(infcPsnl0100Dto);
		                
		              //*******************************************************************************************************/
		            	
		        //   } 
					 
		  		}
		        
	  	    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	   
		return 0;
	} 
	
	
}
