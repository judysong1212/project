package com.app.smrmf.pkg.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnAnDongProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnAnSeongProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnAnYangProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnGMProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnGWGSProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnGeoChangProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnGeoJeProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnGimCheonProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnGimHaeProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnGoeSanProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnHygnProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnJeJuProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnJeonNamProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnJinAnProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnMirYangProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnMuJuProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnOkCheonProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnSamCheokProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnSuWonProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnSunCheonProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnUlJuProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnUlSanNamGuProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnUscProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnYangJuProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnYangPyeongProcessContainer;
import com.app.smrmf.pkg.proc.dlgn.generics.DlgnYongInProcessContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DlgnListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	private static HashMap<String, String> extGlobals = null;
    private List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	
    private ServletContext sevltContext;
    
    private ServletConfig sevltConfig;
    
    private static final Logger logger = LoggerFactory.getLogger(DlgnListenerAdapter.class);
    
    @Override
    public void setServletConfig(final ServletConfig servletConfig) {
        this.sevltConfig = servletConfig;

    }

    @Override
    public void setServletContext(final ServletContext servletContext) {
        this.sevltContext = servletContext;

    }
    
	public DlgnListenerAdapter() { 
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	} 

  
	//서블릿형태의 값을 넘겨 받을경우 객체가 널인경우 처리 하는 루틴추가 
	public int getDlgnListenerCheck(ServletConfig sevltConfig,HttpServletRequest request) throws Exception{
		   
		  if (extGlobals.get("PayGen.MunicipalitiesName") == null) {  
		       extGlobals = SysmConf.getPayGenConfigInfo(sevltConfig , request);
		  } 
		  
		 return 0; 
	}  
	 
    
    //근태업데이트 -시간단위  메서드 
    public Long setUpdateManageDlgn0100CommuteService(HttpServletRequest request,InfcPkgDlgn0100VO infcDlgn0100Vo) throws Exception{
        Long result = new Long(0); 
       
        
        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//용인로직  YongIn

            DlgnYongInProcessContainer dpc = new DlgnYongInProcessContainer(); 
            result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
             
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//김해로직 

 	        DlgnGimHaeProcessContainer dpc = new DlgnGimHaeProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//거제로직 

 	        DlgnGeoJeProcessContainer dpc = new DlgnGeoJeProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//안양로직 

 	        DlgnAnYangProcessContainer dpc = new DlgnAnYangProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//광명로직 

 	        DlgnGMProcessContainer dpc = new DlgnGMProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//삼척로직 

 	        DlgnSamCheokProcessContainer dpc = new DlgnSamCheokProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//수원로직 

 	        DlgnSuWonProcessContainer dpc = new DlgnSuWonProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//울주로직 

 	        DlgnUlJuProcessContainer dpc = new DlgnUlJuProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

 	        DlgnUscProcessContainer dpc = new DlgnUscProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

 	        DlgnUlSanNamGuProcessContainer dpc = new DlgnUlSanNamGuProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	         
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

 	        DlgnGimCheonProcessContainer dpc = new DlgnGimCheonProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
 	            
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

 	        DlgnGWGSProcessContainer dpc = new DlgnGWGSProcessContainer(); 
 	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo); 	   
 	       
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
  	        DlgnSunCheonProcessContainer dpc = new DlgnSunCheonProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  	        
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
  	        DlgnYangJuProcessContainer dpc = new DlgnYangJuProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  	        
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
  	        DlgnAnSeongProcessContainer dpc = new DlgnAnSeongProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  	        
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
  	        DlgnGoeSanProcessContainer dpc = new DlgnGoeSanProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);     
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  	        DlgnGeoChangProcessContainer dpc = new DlgnGeoChangProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  	        DlgnHygnProcessContainer dpc = new DlgnHygnProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  	        DlgnAnDongProcessContainer dpc = new DlgnAnDongProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안    
  	        DlgnJinAnProcessContainer dpc = new DlgnJinAnProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  		     
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			 //public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
  	  	        DlgnYangPyeongProcessContainer dpc = new DlgnYangPyeongProcessContainer(); 
  	  	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
     		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
     	   	        DlgnJeJuProcessContainer dpc = new DlgnJeJuProcessContainer(); 
     	   	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);    
     	    
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
    		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
    	   	        DlgnMuJuProcessContainer dpc = new DlgnMuJuProcessContainer(); 
    	   	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);    
    	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
   	   	        DlgnOkCheonProcessContainer dpc = new DlgnOkCheonProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);    
   	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
   	   	        DlgnJeonNamProcessContainer dpc = new DlgnJeonNamProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);    
   	      	   	
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";       //밀양시 
  	   	   	        DlgnMirYangProcessContainer dpc = new DlgnMirYangProcessContainer(); 
  	   	   	        result = (long)dpc.setUpdateManageInfcDlgn0100CommuteService(request,infcDlgn0100Vo);    
  	   	      	   		        
 		}    else {
 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
 		} 
        
        return result; 
         
    }
    

    //근태업데이트  - 시간단위 메서드  
     public Long setUpdateManageDlgn0200CommuteService(HttpServletRequest request,InfcPkgDlgn0200VO infcDlgn0200Vo) throws Exception{
         Long result = new Long(0); 
       
         if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//용인로직  YongIn

             DlgnYongInProcessContainer dpc = new DlgnYongInProcessContainer(); 
             result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
              
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//김해로직 

  	        DlgnGimHaeProcessContainer dpc = new DlgnGimHaeProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//거제로직 

  	        DlgnGeoJeProcessContainer dpc = new DlgnGeoJeProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//안양로직 

  	        DlgnAnYangProcessContainer dpc = new DlgnAnYangProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//광명로직 

  	        DlgnGMProcessContainer dpc = new DlgnGMProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//삼척로직 

  	        DlgnSamCheokProcessContainer dpc = new DlgnSamCheokProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//수원로직 

  	        DlgnSuWonProcessContainer dpc = new DlgnSuWonProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//울주로직 

  	        DlgnUlJuProcessContainer dpc = new DlgnUlJuProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

  	        DlgnUscProcessContainer dpc = new DlgnUscProcessContainer(); 
  	      result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

  	        DlgnUlSanNamGuProcessContainer dpc = new DlgnUlSanNamGuProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
  	        DlgnGimCheonProcessContainer dpc = new DlgnGimCheonProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	            
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
  	        DlgnGWGSProcessContainer dpc = new DlgnGWGSProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	        
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
  	        DlgnSunCheonProcessContainer dpc = new DlgnSunCheonProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	        
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
  	        DlgnYangJuProcessContainer dpc = new DlgnYangJuProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	        
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
  	        DlgnAnSeongProcessContainer dpc = new DlgnAnSeongProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
  	        DlgnGoeSanProcessContainer dpc = new DlgnGoeSanProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);   
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  	        DlgnGeoChangProcessContainer dpc = new DlgnGeoChangProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  	        DlgnHygnProcessContainer dpc = new DlgnHygnProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  	        DlgnAnDongProcessContainer dpc = new DlgnAnDongProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안    
  	        DlgnJinAnProcessContainer dpc = new DlgnJinAnProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  	        
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong    
  	  	        DlgnYangPyeongProcessContainer dpc = new DlgnYangPyeongProcessContainer(); 
  	  	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
     	 	 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
     	   	        DlgnJeJuProcessContainer dpc = new DlgnJeJuProcessContainer(); 
     	   	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);    
     	    
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
    		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
    	   	        DlgnMuJuProcessContainer dpc = new DlgnMuJuProcessContainer(); 
    	   	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);    
    	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
   	   	        DlgnOkCheonProcessContainer dpc = new DlgnOkCheonProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);    
   	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
   	   	        DlgnJeonNamProcessContainer dpc = new DlgnJeonNamProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);    
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
  			 DlgnMirYangProcessContainer dpc = new DlgnMirYangProcessContainer(); 
	   	        result = (long)dpc.setUpdateManageInfcDlgn0200CommuteService(request,infcDlgn0200Vo);  
  	   	      	   	     	   	
  	    
  		}    else {
  			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
  			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
  		} 
          
          
         return result; 
          
     }
       

     
    /**
     * 
     * <pre>
     * 1. 개요 : 분단위 메서드  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : setUpdateManageDlgn0100CommuteService
     * @date : 2017. 4. 11.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 4. 11.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param infcDlgn0100Vo
     * @return
     * @throws Exception
     */
     public Long setUpdateManageDlgn0100HHMiCommuteService(HttpServletRequest request,InfcPkgDlgn0100VO infcDlgn0100Vo) throws Exception{
         Long result = new Long(0); 
        
        logger.debug("각 지자체로이동 = " + extGlobals.get("PayGen.MunicipalitiesName"));
         if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//용인로직  YongIn

             DlgnYongInProcessContainer dpc = new DlgnYongInProcessContainer(); 
             result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
              
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//김해로직 

  	        DlgnGimHaeProcessContainer dpc = new DlgnGimHaeProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//거제로직 

  	        DlgnGeoJeProcessContainer dpc = new DlgnGeoJeProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//안양로직 

  	        DlgnAnYangProcessContainer dpc = new DlgnAnYangProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//광명로직 

  	        DlgnGMProcessContainer dpc = new DlgnGMProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//삼척로직 

  	        DlgnSamCheokProcessContainer dpc = new DlgnSamCheokProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//수원로직 

  	        DlgnSuWonProcessContainer dpc = new DlgnSuWonProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//울주로직 

  	        DlgnUlJuProcessContainer dpc = new DlgnUlJuProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

  	        DlgnUscProcessContainer dpc = new DlgnUscProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

  	        DlgnUlSanNamGuProcessContainer dpc = new DlgnUlSanNamGuProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	         
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

  	        DlgnGimCheonProcessContainer dpc = new DlgnGimCheonProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
  	            
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

  	        DlgnGWGSProcessContainer dpc = new DlgnGWGSProcessContainer(); 
  	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo); 	   
  	       
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
   	        DlgnSunCheonProcessContainer dpc = new DlgnSunCheonProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   	        
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
   	        DlgnYangJuProcessContainer dpc = new DlgnYangJuProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   	        
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
   	        DlgnAnSeongProcessContainer dpc = new DlgnAnSeongProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   	        
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
   	        DlgnGoeSanProcessContainer dpc = new DlgnGoeSanProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);     
   	      
   	      
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
   	        DlgnGeoChangProcessContainer dpc = new DlgnGeoChangProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   		
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
   	        DlgnHygnProcessContainer dpc = new DlgnHygnProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   		
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
   	        DlgnAnDongProcessContainer dpc = new DlgnAnDongProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안  
   	        DlgnJinAnProcessContainer dpc = new DlgnJinAnProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong   
   	   	        DlgnYangPyeongProcessContainer dpc = new DlgnYangPyeongProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);
   	  
   	    
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
     		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
     	   	        DlgnJeJuProcessContainer dpc = new DlgnJeJuProcessContainer(); 
     	   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);    
     	    
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
    		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
    	   	        DlgnMuJuProcessContainer dpc = new DlgnMuJuProcessContainer(); 
    	   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);    
    	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
   	   	        DlgnOkCheonProcessContainer dpc = new DlgnOkCheonProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);    
   	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
   	   	        DlgnJeonNamProcessContainer dpc = new DlgnJeonNamProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);    
   	      	   	
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
  		  DlgnMirYangProcessContainer dpc = new DlgnMirYangProcessContainer(); 
	   	        result = (long)dpc.setUpdateManageInfcDlgn0100HHMiCommuteService(request,infcDlgn0100Vo);    
  	   	      	   	     	   	
  	            
  		}    else {
  			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
  			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
  		} 
         
         return result; 
          
     }
     

     /**
      * 
      * <pre>
      * 1. 개요 : 분단위 메서드  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : setUpdateManageDlgn0200HHMiCommuteService
      * @date : 2017. 4. 11.
      * @author : paygen
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 4. 11.		paygen				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param request
      * @param infcDlgn0200Vo
      * @return
      * @throws Exception
      */ 
      public Long setUpdateManageDlgn0200HHMiCommuteService(HttpServletRequest request,InfcPkgDlgn0200VO infcDlgn0200Vo) throws Exception{
          Long result = new Long(0); 
        
          if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//용인로직  YongIn

              DlgnYongInProcessContainer dpc = new DlgnYongInProcessContainer(); 
              result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
               
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//김해로직 

   	        DlgnGimHaeProcessContainer dpc = new DlgnGimHaeProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//거제로직 

   	        DlgnGeoJeProcessContainer dpc = new DlgnGeoJeProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//안양로직 

   	        DlgnAnYangProcessContainer dpc = new DlgnAnYangProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//광명로직 

   	        DlgnGMProcessContainer dpc = new DlgnGMProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//삼척로직 

   	        DlgnSamCheokProcessContainer dpc = new DlgnSamCheokProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//수원로직 

   	        DlgnSuWonProcessContainer dpc = new DlgnSuWonProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//울주로직 

   	        DlgnUlJuProcessContainer dpc = new DlgnUlJuProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

   	        DlgnUscProcessContainer dpc = new DlgnUscProcessContainer(); 
   	      result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

   	        DlgnUlSanNamGuProcessContainer dpc = new DlgnUlSanNamGuProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	         
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
   	        DlgnGimCheonProcessContainer dpc = new DlgnGimCheonProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	            
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
   	        DlgnGWGSProcessContainer dpc = new DlgnGWGSProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	        
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
   	        DlgnSunCheonProcessContainer dpc = new DlgnSunCheonProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	        
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
   	        DlgnYangJuProcessContainer dpc = new DlgnYangJuProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   	        
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
   	        DlgnAnSeongProcessContainer dpc = new DlgnAnSeongProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
   	        DlgnGoeSanProcessContainer dpc = new DlgnGoeSanProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);   
   	      
   	      
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
   	        DlgnGeoChangProcessContainer dpc = new DlgnGeoChangProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   		
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
   	        DlgnHygnProcessContainer dpc = new DlgnHygnProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   		
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
   	        DlgnAnDongProcessContainer dpc = new DlgnAnDongProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안    
   	        DlgnJinAnProcessContainer dpc = new DlgnJinAnProcessContainer(); 
   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);
   		
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
   	   	        DlgnYangPyeongProcessContainer dpc = new DlgnYangPyeongProcessContainer(); 
   	   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);    
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
      		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
      	   	        DlgnJeJuProcessContainer dpc = new DlgnJeJuProcessContainer(); 
      	   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);    
      	    
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
     		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
     	   	        DlgnMuJuProcessContainer dpc = new DlgnMuJuProcessContainer(); 
     	   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);    
     	      
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
    		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
    	   	        DlgnOkCheonProcessContainer dpc = new DlgnOkCheonProcessContainer(); 
    	   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);    
    	      
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
    		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
    	   	        DlgnJeonNamProcessContainer dpc = new DlgnJeonNamProcessContainer(); 
    	   	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);    
   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
   		 DlgnMirYangProcessContainer dpc = new DlgnMirYangProcessContainer(); 
	        result = (long)dpc.setUpdateManageInfcDlgn0200HHMiCommuteService(request,infcDlgn0200Vo);    
  	                	   	        
   		}    else {
   			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
   			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
   		} 
           
           
          return result; 
           
      }
       
      
}
