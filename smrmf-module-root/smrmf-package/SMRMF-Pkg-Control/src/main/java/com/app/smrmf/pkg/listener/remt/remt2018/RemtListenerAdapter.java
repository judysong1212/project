package com.app.smrmf.pkg.listener.remt.remt2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;
import com.app.smrmf.pkg.proc.remt.generics.RemtGimCheonProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtAnDongProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtAnSeongProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtAnYangProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtGMProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtGWGSProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtGeoChangProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtGeoJeProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtGimHaeProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtGoeSanProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtHygnProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtJeJuProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtJeonNamProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtJinAnProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtMirYangProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtMuJuProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtOkCheonProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtSamCheokProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtSuWonProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtSunCheonProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtUlJuProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtUlSanNamGuProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtUscProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtYangJuProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtYangPyeongProcessContainer;
import com.app.smrmf.pkg.proc.remt.generics.remt2018.RemtYongInProcessContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class RemtListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  private static HashMap<String, String> extGlobals = null;
	  private List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
   
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
      
	public RemtListenerAdapter() {
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
				
	}
	
	//퇴직정산대상자선택을 하였을경우 퇴직금산정 루틴을 태워 기본적인 데이터를 가지고 오는 메서드 
	public PagingLoadResult<ShowMessageBM> setRemt0100ToRetirementCalc( HttpServletRequest request,ArrayList<InfcPkgRemt2000VO> liseRemt2000)  throws Exception  {
		
	   // Long result = new Long(0); 
		PagingLoadResult<ShowMessageBM> retval = null;
		
		   
        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//용인로직 
        	 
    		RemtYongInProcessContainer ppc = new RemtYongInProcessContainer();
    	    //System.out.println("Start : " + System.currentTimeMillis());
    	    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
    		//System.out.println("End : " + System.currentTimeMillis());
    		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//김해로직 
 			 
 			RemtGimHaeProcessContainer ppc = new RemtGimHaeProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//거제로직 
 			 
 			RemtGeoJeProcessContainer ppc = new RemtGeoJeProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//안양로직 
 			 
 			RemtAnYangProcessContainer ppc = new RemtAnYangProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//광명로직 
 			 
 			RemtGMProcessContainer ppc = new RemtGMProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//삼척로직 
 			 
 			RemtSamCheokProcessContainer ppc = new RemtSamCheokProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//수원로직 
 			 
 			RemtSuWonProcessContainer ppc = new RemtSuWonProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//울주로직 
 			 
 			RemtUlJuProcessContainer ppc = new RemtUlJuProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
 			 
 			RemtUscProcessContainer ppc = new RemtUscProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
 			 
 			RemtUlSanNamGuProcessContainer ppc = new RemtUlSanNamGuProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
 			 
 			RemtGimCheonProcessContainer ppc = new RemtGimCheonProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 			 
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
 			 
 			RemtGWGSProcessContainer ppc = new RemtGWGSProcessContainer();
 		    //System.out.println("Start : " + System.currentTimeMillis());
 		    retval =   ppc.execRemt0100ToRetirementCalc(request,liseRemt2000); 
 			//System.out.println("End : " + System.currentTimeMillis());
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
			RemtSunCheonProcessContainer ppcSunCheon = new RemtSunCheonProcessContainer(); 
			retval =  ppcSunCheon.execRemt0100ToRetirementCalc(request,liseRemt2000);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
			RemtYangJuProcessContainer ppcYangJu = new RemtYangJuProcessContainer(); 
			retval =  ppcYangJu.execRemt0100ToRetirementCalc(request,liseRemt2000);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
			RemtAnSeongProcessContainer ppcAnSeong = new RemtAnSeongProcessContainer(); 
			retval =  ppcAnSeong.execRemt0100ToRetirementCalc(request,liseRemt2000);
							
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
  			RemtGoeSanProcessContainer ppcGoeSan = new RemtGoeSanProcessContainer(); 
  			retval =   ppcGoeSan.execRemt0100ToRetirementCalc(request,liseRemt2000);
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  			RemtGeoChangProcessContainer ppcGeoChang = new RemtGeoChangProcessContainer(); 
  			retval =  ppcGeoChang.execRemt0100ToRetirementCalc(request,liseRemt2000);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  			RemtHygnProcessContainer ppcHygn = new RemtHygnProcessContainer(); 
  			retval =   ppcHygn.execRemt0100ToRetirementCalc(request,liseRemt2000);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  			RemtAnDongProcessContainer ppcAnDong = new RemtAnDongProcessContainer(); 
  			retval =   ppcAnDong.execRemt0100ToRetirementCalc(request,liseRemt2000);
  				
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
  			RemtJinAnProcessContainer ppcJinAn = new RemtJinAnProcessContainer(); 
  			retval =   ppcJinAn.execRemt0100ToRetirementCalc(request,liseRemt2000);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
  	  			RemtYangPyeongProcessContainer ppcYangPyeong = new RemtYangPyeongProcessContainer(); 
  	  			retval =   ppcYangPyeong.execRemt0100ToRetirementCalc(request,liseRemt2000);
  	
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
	  			RemtJeJuProcessContainer ppcJeJu = new RemtJeJuProcessContainer(); 
	  			retval = ppcJeJu.execRemt0100ToRetirementCalc(request,liseRemt2000);
	   	    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
				RemtMuJuProcessContainer ppcMuJu = new RemtMuJuProcessContainer(); 
				retval = ppcMuJu.execRemt0100ToRetirementCalc(request,liseRemt2000);		
	  	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
				RemtOkCheonProcessContainer ppcOkCheon = new RemtOkCheonProcessContainer(); 
				retval = ppcOkCheon.execRemt0100ToRetirementCalc(request,liseRemt2000);	
	 	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
				RemtJeonNamProcessContainer ppcJeonNam = new RemtJeonNamProcessContainer(); 
				retval = ppcJeonNam.execRemt0100ToRetirementCalc(request,liseRemt2000);		
	    
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시   	 
			
			RemtMirYangProcessContainer ppcMirYang = new RemtMirYangProcessContainer(); 
			retval = ppcMirYang.execRemt0100ToRetirementCalc(request,liseRemt2000);		
			
 		}    else {
 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
 		} 
       
		return retval; 
	}
	
	public PagingLoadResult<ShowMessageBM> setRemt0100ToRemtCalc2000( HttpServletRequest request, InfcPkgRemt2000VO  remt2000)  throws Exception  {
		
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
			
			   
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 

				RemtYongInProcessContainer ppc = new RemtYongInProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 

				RemtGimHaeProcessContainer ppc = new RemtGimHaeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 

				RemtGeoJeProcessContainer ppc = new RemtGeoJeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 

				RemtAnYangProcessContainer ppc = new RemtAnYangProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 

				RemtGMProcessContainer ppc = new RemtGMProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 

				RemtSamCheokProcessContainer ppc = new RemtSamCheokProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 

				RemtSuWonProcessContainer ppc = new RemtSuWonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 

				RemtUlJuProcessContainer ppc = new RemtUlJuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

				RemtUscProcessContainer ppc = new RemtUscProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

				RemtUlSanNamGuProcessContainer ppc = new RemtUlSanNamGuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

				RemtGimCheonProcessContainer ppc = new RemtGimCheonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

				RemtGWGSProcessContainer ppc = new RemtGWGSProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execRemt0100ToRemtCalc2000(request,remt2000); 
				//System.out.println("End : " + System.currentTimeMillis());
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
				RemtSunCheonProcessContainer ppcSunCheon = new RemtSunCheonProcessContainer(); 
				retval =  ppcSunCheon.execRemt0100ToRemtCalc2000(request,remt2000);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
				RemtYangJuProcessContainer ppcYangJu = new RemtYangJuProcessContainer(); 
				retval =  ppcYangJu.execRemt0100ToRemtCalc2000(request,remt2000);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
				RemtAnSeongProcessContainer ppcAnSeong = new RemtAnSeongProcessContainer(); 
				retval =  ppcAnSeong.execRemt0100ToRemtCalc2000(request,remt2000);
	 		
				
			    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
					RemtGoeSanProcessContainer ppcGoeSan = new RemtGoeSanProcessContainer(); 
					retval =   ppcGoeSan.execRemt0100ToRemtCalc2000(request,remt2000);
			      
			      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
					RemtGeoChangProcessContainer ppcGeoChang = new RemtGeoChangProcessContainer(); 
					retval =  ppcGeoChang.execRemt0100ToRemtCalc2000(request,remt2000);
				
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
					RemtHygnProcessContainer ppcHygn = new RemtHygnProcessContainer(); 
					retval =   ppcHygn.execRemt0100ToRemtCalc2000(request,remt2000);
				
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
					RemtAnDongProcessContainer ppcAnDong = new RemtAnDongProcessContainer(); 
					retval =   ppcAnDong.execRemt0100ToRemtCalc2000(request,remt2000);
			
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
			  			RemtJinAnProcessContainer ppcJinAn = new RemtJinAnProcessContainer(); 
			  			retval =   ppcJinAn.execRemt0100ToRemtCalc2000(request,remt2000);
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
			  			RemtYangPyeongProcessContainer ppcYangPyeong = new RemtYangPyeongProcessContainer(); 
			  			retval =   ppcYangPyeong.execRemt0100ToRemtCalc2000(request,remt2000);				 			
			  		
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
			  			RemtJeJuProcessContainer ppcJeJu = new RemtJeJuProcessContainer(); 
			  			retval = ppcJeJu.execRemt0100ToRemtCalc2000(request,remt2000);			
			   	    
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
						RemtMuJuProcessContainer ppcMuJu = new RemtMuJuProcessContainer(); 
						retval = ppcMuJu.execRemt0100ToRemtCalc2000(request,remt2000);			
			  	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
						RemtOkCheonProcessContainer ppcOkCheon = new RemtOkCheonProcessContainer(); 
						retval = ppcOkCheon.execRemt0100ToRemtCalc2000(request,remt2000);		
			 	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
						RemtJeonNamProcessContainer ppcJeonNam = new RemtJeonNamProcessContainer(); 
						retval = ppcJeonNam.execRemt0100ToRemtCalc2000(request,remt2000);			
			
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시   
						
						RemtMirYangProcessContainer ppcMirYang = new RemtMirYangProcessContainer(); 
						retval = ppcMirYang.execRemt0100ToRemtCalc2000(request,remt2000);	
						
						
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	        
			return retval; 
		}
	
	public PagingLoadResult<ShowMessageBM> setActivityOnPayrCalc( HttpServletRequest request, List<InfcPkgRemt2000VO> listRemt2000Vo)  throws Exception  {
		
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
			
			   
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 

				RemtYongInProcessContainer ppc = new RemtYongInProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 

				RemtGimHaeProcessContainer ppc = new RemtGimHaeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 

				RemtGeoJeProcessContainer ppc = new RemtGeoJeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 

				RemtAnYangProcessContainer ppc = new RemtAnYangProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 

				RemtGMProcessContainer ppc = new RemtGMProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 

				RemtSamCheokProcessContainer ppc = new RemtSamCheokProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 

				RemtSuWonProcessContainer ppc = new RemtSuWonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 

				RemtUlJuProcessContainer ppc = new RemtUlJuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

				RemtUscProcessContainer ppc = new RemtUscProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

				RemtUlSanNamGuProcessContainer ppc = new RemtUlSanNamGuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

				RemtGimCheonProcessContainer ppc = new RemtGimCheonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				   
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

				RemtGWGSProcessContainer ppc = new RemtGWGSProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
			    retval =   ppc.execActivityOnPayrCalc(request,listRemt2000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
				RemtSunCheonProcessContainer ppcSunCheon = new RemtSunCheonProcessContainer(); 
				retval =  ppcSunCheon.execActivityOnPayrCalc(request,listRemt2000Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
				RemtYangJuProcessContainer ppcYangJu = new RemtYangJuProcessContainer(); 
				retval =  ppcYangJu.execActivityOnPayrCalc(request,listRemt2000Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
				RemtAnSeongProcessContainer ppcAnSeong = new RemtAnSeongProcessContainer(); 
				retval =  ppcAnSeong.execActivityOnPayrCalc(request,listRemt2000Vo);
	 		
				
		    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
				RemtGoeSanProcessContainer ppcGoeSan = new RemtGoeSanProcessContainer(); 
				retval =   ppcGoeSan.execActivityOnPayrCalc(request,listRemt2000Vo);
		      
		      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
				RemtGeoChangProcessContainer ppcGeoChang = new RemtGeoChangProcessContainer(); 
				retval =  ppcGeoChang.execActivityOnPayrCalc(request,listRemt2000Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
				RemtHygnProcessContainer ppcHygn = new RemtHygnProcessContainer(); 
				retval =   ppcHygn.execActivityOnPayrCalc(request,listRemt2000Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
				RemtAnDongProcessContainer ppcAnDong = new RemtAnDongProcessContainer(); 
				retval =   ppcAnDong.execActivityOnPayrCalc(request,listRemt2000Vo);
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			RemtJinAnProcessContainer ppcJinAn = new RemtJinAnProcessContainer(); 
		  			retval =   ppcJinAn.execActivityOnPayrCalc(request,listRemt2000Vo); 
		  		 
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong
		  			RemtYangPyeongProcessContainer ppcYangPyeong = new RemtYangPyeongProcessContainer(); 
		  			retval =   ppcYangPyeong.execActivityOnPayrCalc(request,listRemt2000Vo);		
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
		  			RemtJeJuProcessContainer ppcJeJu = new RemtJeJuProcessContainer(); 
		  			retval = ppcJeJu.execActivityOnPayrCalc(request,listRemt2000Vo);		
		   	    
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
					RemtMuJuProcessContainer ppcMuJu = new RemtMuJuProcessContainer(); 
					retval = ppcMuJu.execActivityOnPayrCalc(request,listRemt2000Vo);		
		  	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
					RemtOkCheonProcessContainer ppcOkCheon = new RemtOkCheonProcessContainer(); 
					retval = ppcOkCheon.execActivityOnPayrCalc(request,listRemt2000Vo);		
		 	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
					RemtJeonNamProcessContainer ppcJeonNam = new RemtJeonNamProcessContainer(); 
					retval = ppcJeonNam.execActivityOnPayrCalc(request,listRemt2000Vo);		
			
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시       		
					RemtMirYangProcessContainer ppcMirYang = new RemtMirYangProcessContainer(); 
					retval = ppcMirYang.execActivityOnPayrCalc(request,listRemt2000Vo);	
					
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	        
			return retval; 
		}
	
	public Long setActivityOnUpdateRemt0100ToPayrCalc( HttpServletRequest request, List<InfcPkgRemt2200VO> lstInfcRemt2200Vo)  throws Exception  {
		
		   Long result = new Long(0);  
		   
		   
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 

				RemtYongInProcessContainer ppc = new RemtYongInProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 

				RemtGimHaeProcessContainer ppc = new RemtGimHaeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 

				RemtGeoJeProcessContainer ppc = new RemtGeoJeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 

				RemtAnYangProcessContainer ppc = new RemtAnYangProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 

				RemtGMProcessContainer ppc = new RemtGMProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 

				RemtSamCheokProcessContainer ppc = new RemtSamCheokProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 

				RemtSuWonProcessContainer ppc = new RemtSuWonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 

				RemtUlJuProcessContainer ppc = new RemtUlJuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

				RemtUscProcessContainer ppc = new RemtUscProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

				RemtUlSanNamGuProcessContainer ppc = new RemtUlSanNamGuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

				RemtGimCheonProcessContainer ppc = new RemtGimCheonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

				RemtGWGSProcessContainer ppc = new RemtGWGSProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
				RemtSunCheonProcessContainer ppcSunCheon = new RemtSunCheonProcessContainer(); 
				result =  ppcSunCheon.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
				RemtYangJuProcessContainer ppcYangJu = new RemtYangJuProcessContainer(); 
				result =  ppcYangJu.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
				RemtAnSeongProcessContainer ppcAnSeong = new RemtAnSeongProcessContainer(); 
				result =  ppcAnSeong.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
	 		
				
		    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
				RemtGoeSanProcessContainer ppcGoeSan = new RemtGoeSanProcessContainer(); 
				result =   ppcGoeSan.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
		      
		      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
				RemtGeoChangProcessContainer ppcGeoChang = new RemtGeoChangProcessContainer(); 
				result =  ppcGeoChang.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
				RemtHygnProcessContainer ppcHygn = new RemtHygnProcessContainer(); 
				result =   ppcHygn.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
				RemtAnDongProcessContainer ppcAnDong = new RemtAnDongProcessContainer(); 
				result =   ppcAnDong.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			RemtJinAnProcessContainer ppcJinAn = new RemtJinAnProcessContainer(); 
		  			result =   ppcJinAn.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
		  				 
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong
		  			RemtYangPyeongProcessContainer ppcYangPyeong = new RemtYangPyeongProcessContainer(); 
		  			result =   ppcYangPyeong.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);	
		  	
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
		  			RemtJeJuProcessContainer ppcJeJu = new RemtJeJuProcessContainer(); 
		  			result = ppcJeJu.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);	
		   	    
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
					RemtMuJuProcessContainer ppcMuJu = new RemtMuJuProcessContainer(); 
					result = ppcMuJu.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);	
		  	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
					RemtOkCheonProcessContainer ppcOkCheon = new RemtOkCheonProcessContainer(); 
					result = ppcOkCheon.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);	
		 	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
					RemtJeonNamProcessContainer ppcJeonNam = new RemtJeonNamProcessContainer(); 
					result = ppcJeonNam.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);	
			
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시  
					RemtMirYangProcessContainer ppcMirYang = new RemtMirYangProcessContainer(); 
					result = ppcMirYang.execActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);	
					
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	        
			return result; 
		}
	
	public Long setActivityOnUpdateRemt0100ToPayrWfepCalc( HttpServletRequest request, List<InfcPkgRemt2200VO> lstInfcRemt2200Vo)  throws Exception  {
		
		   Long result = new Long(0);  
		   
		   
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 

				RemtYongInProcessContainer ppc = new RemtYongInProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 

				RemtGimHaeProcessContainer ppc = new RemtGimHaeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 

				RemtGeoJeProcessContainer ppc = new RemtGeoJeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 

				RemtAnYangProcessContainer ppc = new RemtAnYangProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 

				RemtGMProcessContainer ppc = new RemtGMProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 

				RemtSamCheokProcessContainer ppc = new RemtSamCheokProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 

				RemtSuWonProcessContainer ppc = new RemtSuWonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 

				RemtUlJuProcessContainer ppc = new RemtUlJuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

				RemtUscProcessContainer ppc = new RemtUscProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

				RemtUlSanNamGuProcessContainer ppc = new RemtUlSanNamGuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

				RemtGimCheonProcessContainer ppc = new RemtGimCheonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				   
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

				RemtGWGSProcessContainer ppc = new RemtGWGSProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
				RemtSunCheonProcessContainer ppcSunCheon = new RemtSunCheonProcessContainer(); 
				result =  ppcSunCheon.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
				RemtYangJuProcessContainer ppcYangJu = new RemtYangJuProcessContainer(); 
				result =  ppcYangJu.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
				RemtAnSeongProcessContainer ppcAnSeong = new RemtAnSeongProcessContainer(); 
				result =  ppcAnSeong.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
	 		
				
		    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
				RemtGoeSanProcessContainer ppcGoeSan = new RemtGoeSanProcessContainer(); 
				result =   ppcGoeSan.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
		      
		      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
				RemtGeoChangProcessContainer ppcGeoChang = new RemtGeoChangProcessContainer(); 
				result =  ppcGeoChang.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
				RemtHygnProcessContainer ppcHygn = new RemtHygnProcessContainer(); 
				result =   ppcHygn.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
				RemtAnDongProcessContainer ppcAnDong = new RemtAnDongProcessContainer(); 
				result =   ppcAnDong.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			RemtJinAnProcessContainer ppcJinAn = new RemtJinAnProcessContainer(); 
		  			result =   ppcJinAn.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
		  				 
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong
		  			RemtYangPyeongProcessContainer ppcYangPyeong = new RemtYangPyeongProcessContainer(); 
		  			result =   ppcYangPyeong.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
		  			RemtJeJuProcessContainer ppcJeJu = new RemtJeJuProcessContainer(); 
		  			result = ppcJeJu.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
		   	    
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
					RemtMuJuProcessContainer ppcMuJu = new RemtMuJuProcessContainer(); 
					result = ppcMuJu.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
		  	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
					RemtOkCheonProcessContainer ppcOkCheon = new RemtOkCheonProcessContainer(); 
					result = ppcOkCheon.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
		 	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
					RemtJeonNamProcessContainer ppcJeonNam = new RemtJeonNamProcessContainer(); 
					result = ppcJeonNam.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시      		
					RemtMirYangProcessContainer ppcMirYang = new RemtMirYangProcessContainer(); 
					result = ppcMirYang.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
					
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 			
				
	 		} 
	         
			return result; 
		}
	
	public PagingLoadResult<ShowMessageBM>  setActivityOnPayrRemtCalc( HttpServletRequest request, List<InfcPkgRemt3000VO> lstInfcRemt3000Vo)  throws Exception  {
		
		    PagingLoadResult<ShowMessageBM> retval = null;
		    
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 

				RemtYongInProcessContainer ppc = new RemtYongInProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 

				RemtGimHaeProcessContainer ppc = new RemtGimHaeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 

				RemtGeoJeProcessContainer ppc = new RemtGeoJeProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 

				RemtAnYangProcessContainer ppc = new RemtAnYangProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 

				RemtGMProcessContainer ppc = new RemtGMProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 

				RemtSamCheokProcessContainer ppc = new RemtSamCheokProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 

				RemtSuWonProcessContainer ppc = new RemtSuWonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 

				RemtUlJuProcessContainer ppc = new RemtUlJuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

				RemtUscProcessContainer ppc = new RemtUscProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

				RemtUlSanNamGuProcessContainer ppc = new RemtUlSanNamGuProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

				RemtGimCheonProcessContainer ppc = new RemtGimCheonProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
				 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

				RemtGWGSProcessContainer ppc = new RemtGWGSProcessContainer();
			    //System.out.println("Start : " + System.currentTimeMillis());
				retval =   ppc.execRemtTxCalculation(request,lstInfcRemt3000Vo); 
				//System.out.println("End : " + System.currentTimeMillis());
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
	 			RemtSunCheonProcessContainer ppcSunCheon = new RemtSunCheonProcessContainer(); 
				retval =  ppcSunCheon.execRemtTxCalculation(request,lstInfcRemt3000Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
				RemtYangJuProcessContainer ppcYangJu = new RemtYangJuProcessContainer(); 
				retval =  ppcYangJu.execRemtTxCalculation(request,lstInfcRemt3000Vo);
		        
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
				RemtAnSeongProcessContainer ppcAnSeong = new RemtAnSeongProcessContainer(); 
				retval =  ppcAnSeong.execRemtTxCalculation(request,lstInfcRemt3000Vo);
	 		
			 } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
				RemtGoeSanProcessContainer ppcGoeSan = new RemtGoeSanProcessContainer(); 
				retval =   ppcGoeSan.execRemtTxCalculation(request,lstInfcRemt3000Vo);
		      
		      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
				RemtGeoChangProcessContainer ppcGeoChang = new RemtGeoChangProcessContainer(); 
				retval =  ppcGeoChang.execRemtTxCalculation(request,lstInfcRemt3000Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
				RemtHygnProcessContainer ppcHygn = new RemtHygnProcessContainer(); 
				retval =   ppcHygn.execRemtTxCalculation(request,lstInfcRemt3000Vo);
			
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
				RemtAnDongProcessContainer ppcAnDong = new RemtAnDongProcessContainer(); 
				retval =   ppcAnDong.execRemtTxCalculation(request,lstInfcRemt3000Vo);
			
			
			 } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			RemtJinAnProcessContainer ppcJinAn = new RemtJinAnProcessContainer(); 
		  			retval =   ppcJinAn.execRemtTxCalculation(request,lstInfcRemt3000Vo);
		  	
			 } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong	
			  			RemtYangPyeongProcessContainer ppcYangPyeong = new RemtYangPyeongProcessContainer(); 
			  			retval =   ppcYangPyeong.execRemtTxCalculation(request,lstInfcRemt3000Vo);
			  			
			 } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
		  			RemtJeJuProcessContainer ppcJeJu = new RemtJeJuProcessContainer(); 
		  			retval = ppcJeJu.execRemtTxCalculation(request,lstInfcRemt3000Vo);
		   	    
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
					RemtMuJuProcessContainer ppcMuJu = new RemtMuJuProcessContainer(); 
					retval = ppcMuJu.execRemtTxCalculation(request,lstInfcRemt3000Vo);
		  	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
					RemtOkCheonProcessContainer ppcOkCheon = new RemtOkCheonProcessContainer(); 
					retval = ppcOkCheon.execRemtTxCalculation(request,lstInfcRemt3000Vo);
		 	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
					RemtJeonNamProcessContainer ppcJeonNam = new RemtJeonNamProcessContainer(); 
					retval = ppcJeonNam.execRemtTxCalculation(request,lstInfcRemt3000Vo);
			
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시      	  
					RemtMirYangProcessContainer ppcMirYang = new RemtMirYangProcessContainer(); 
					retval = ppcMirYang.execRemtTxCalculation(request,lstInfcRemt3000Vo);
					
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	        
			return retval; 
		}
	
	
	
	
//	//추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
//	public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250,SysComPsnl0100DTO dtoPsnl0100)  throws Exception  {
//		//int result = 0;
//		PagingLoadResult<ShowMessageBM> retval = null;
//		PayrProcessContainer ppc = new PayrProcessContainer();
//		
//		retval = ppc.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, dtoPsnl0100);
//		
//		
//		return retval; 
//	}
//	
//    public int setPayr4200ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0302VO voPayr0302)  throws Exception  {
//        int result = 0;
//        PayrProcessContainer ppc = new PayrProcessContainer();
//        
//        result = ppc.execPayr4200ToPayCalcSeft(request ,voPayr0302);
//        
//        
//        return result; 
//    }
	
	 
}
