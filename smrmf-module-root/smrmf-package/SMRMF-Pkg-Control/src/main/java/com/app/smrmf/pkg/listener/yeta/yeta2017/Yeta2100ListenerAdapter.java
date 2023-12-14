package com.app.smrmf.pkg.listener.yeta.yeta2017;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100AnDongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100AnSeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100AnYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100GMProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100GWGSProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100GeoChangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100GeoJeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100GimCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100GimHaeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100GoeSanProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100HygnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100JeJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100JeonNamProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100JinAnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100MirYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100MuJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100OkCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100SamCheokProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100SuWonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100SunCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100UlJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100UlSanNamGuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100UscProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100YangJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100YangPyeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2100YongInProcContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class Yeta2100ListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(Yeta2100ListenerAdapter.class);
	
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
      
	public Yeta2100ListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	 
	
	 
	
	
	 public PagingLoadResult<ShowMessageBM> setUpDpopYeta_Insert( HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
			
			
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직  
				 
	        	Yeta2100YongInProcContainer ppc = new Yeta2100YongInProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
	 			Yeta2100GimHaeProcContainer ppc = new Yeta2100GimHaeProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 
	 			Yeta2100GeoJeProcContainer ppc = new Yeta2100GeoJeProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 
	 			Yeta2100AnYangProcContainer ppc = new Yeta2100AnYangProcContainer();
	 		    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 
	 			Yeta2100GMProcContainer ppc = new Yeta2100GMProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
				  
				 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 
	 			Yeta2100SamCheokProcContainer ppc = new Yeta2100SamCheokProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
	 			Yeta2100SuWonProcContainer ppc = new Yeta2100SuWonProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 
	 			Yeta2100UlJuProcContainer ppc = new Yeta2100UlJuProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
				 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

	 			Yeta2100UscProcContainer ppc = new Yeta2100UscProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
	 			Yeta2100UlSanNamGuProcContainer ppc = new Yeta2100UlSanNamGuProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
	 			Yeta2100GimCheonProcContainer ppc = new Yeta2100GimCheonProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG"  GWGS;    //강원도고성군청
	 			Yeta2100GWGSProcContainer ppc = new Yeta2100GWGSProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	 			
	        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
	        	Yeta2100SunCheonProcContainer ppc = new Yeta2100SunCheonProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
	  			Yeta2100YangJuProcContainer ppc = new Yeta2100YangJuProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
	  			Yeta2100AnSeongProcContainer ppc = new Yeta2100AnSeongProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	   		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
	  			Yeta2100GoeSanProcContainer ppc = new Yeta2100GoeSanProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  	      
	  	      
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
	  			 
	  			Yeta2100GeoChangProcContainer ppc = new Yeta2100GeoChangProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
	  			Yeta2100HygnProcContainer ppc = new Yeta2100HygnProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  		
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
	  			Yeta2100AnDongProcContainer ppc = new Yeta2100AnDongProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  			 
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			Yeta2100JinAnProcContainer ppc = new Yeta2100JinAnProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
	  			Yeta2100YangPyeongProcContainer ppc = new Yeta2100YangPyeongProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
	  	
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
	  			Yeta2100JeJuProcContainer ppc = new Yeta2100JeJuProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
		   	    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
				Yeta2100MuJuProcContainer ppc = new Yeta2100MuJuProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO);  
		  	      
		    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
		    	Yeta2100OkCheonProcContainer ppc = new Yeta2100OkCheonProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO);  
		 	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
				Yeta2100JeonNamProcContainer ppc = new Yeta2100JeonNamProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 
			    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
				Yeta2100MirYangProcContainer ppc = new Yeta2100MirYangProcContainer();
			    retval =   ppc.execUpDpopYeta_Insert(request, listYe161010VO); 	 
		  	     
	 		}    else {
	 			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[연말정산]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	         
			return retval; 
		}
		
	 
	 public PagingLoadResult<ShowMessageBM> setYetaP210001ToAll_Create( HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
			
			
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직  
				 
	        	Yeta2100YongInProcContainer ppc = new Yeta2100YongInProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
	 			Yeta2100GimHaeProcContainer ppc = new Yeta2100GimHaeProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 
	 			Yeta2100GeoJeProcContainer ppc = new Yeta2100GeoJeProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 
	 			Yeta2100AnYangProcContainer ppc = new Yeta2100AnYangProcContainer();
	 		    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 
	 			Yeta2100GMProcContainer ppc = new Yeta2100GMProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
				  
				 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 
	 			Yeta2100SamCheokProcContainer ppc = new Yeta2100SamCheokProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
	 			Yeta2100SuWonProcContainer ppc = new Yeta2100SuWonProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 
	 			Yeta2100UlJuProcContainer ppc = new Yeta2100UlJuProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
				 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

	 			Yeta2100UscProcContainer ppc = new Yeta2100UscProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
	 			Yeta2100UlSanNamGuProcContainer ppc = new Yeta2100UlSanNamGuProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
	 			Yeta2100GimCheonProcContainer ppc = new Yeta2100GimCheonProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG"  GWGS;    //강원도고성군청
	 			Yeta2100GWGSProcContainer ppc = new Yeta2100GWGSProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	 			
	        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
	        	Yeta2100SunCheonProcContainer ppc = new Yeta2100SunCheonProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
	  			Yeta2100YangJuProcContainer ppc = new Yeta2100YangJuProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
	  			Yeta2100AnSeongProcContainer ppc = new Yeta2100AnSeongProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	   		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
	  			Yeta2100GoeSanProcContainer ppc = new Yeta2100GoeSanProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  	      
	  	      
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
	  			 
	  			Yeta2100GeoChangProcContainer ppc = new Yeta2100GeoChangProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
	  			Yeta2100HygnProcContainer ppc = new Yeta2100HygnProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  		
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
	  			Yeta2100AnDongProcContainer ppc = new Yeta2100AnDongProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  			 
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			Yeta2100JinAnProcContainer ppc = new Yeta2100JinAnProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
	  			Yeta2100YangPyeongProcContainer ppc = new Yeta2100YangPyeongProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
	  	
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
	  			Yeta2100JeJuProcContainer ppc = new Yeta2100JeJuProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
		   	    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
				Yeta2100MuJuProcContainer ppc = new Yeta2100MuJuProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO);  
		  	      
		    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
		    	Yeta2100OkCheonProcContainer ppc = new Yeta2100OkCheonProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO);  
		 	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
				Yeta2100JeonNamProcContainer ppc = new Yeta2100JeonNamProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 
			    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
				Yeta2100MirYangProcContainer ppc = new Yeta2100MirYangProcContainer();
			    retval =   ppc.execYeta2100_All_Create(request, listYe161010VO); 	 
		  	     
	 		}    else {
	 			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[연말정산]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	         
			return retval; 
		}
		
//		public PagingLoadResult<ShowMessageBM> setYetaPayr06420_All_Add_Create( HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
//			
//			   
//			   // Long result = new Long(0); 
//				PagingLoadResult<ShowMessageBM> retval = null;
//				  
//		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//용인로직 
//		        	 Yeta1100YongInProcContainer ppc = new Yeta1100YongInProcContainer();
//				     retval =   ppc.execPayrToYeta_2016_Insert(request, lstYeta2000Vo); 
//		    	} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//김해로직 
//	 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//거제로직 
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//안양로직 
//		 			Yeta1100AnYangProcContainer ppc = new Yeta1100AnYangProcContainer();
//				     retval =   ppc.execPayrToYeta_2017_Insert(request, lstYeta2000Vo); 
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//광명로직 
//
//					 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//삼척로직 
//	 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//수원로직 
//	 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//울주로직 
//
//					 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
//	 
//		        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
//				 
//		  	        
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
//		  		 
//		  	        
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
//		  			 
//		   		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
//		  			 
//		  	      
//		  	      
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
//		  			 
//		  		
//		  		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
//		  		 
//		  		
//		  		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
//		  			 
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
//		  			 
//		  		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
//			  		 
//		  	
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
//			  		 
//			   	    
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
//						 
//			  	      
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
//						 
//			 	      
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
//						 
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
//						 
//		 		}    else {
//		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
//		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
//		 		} 
//					
//					 
//				return retval; 
//			}
		
		
		 
		
		// 급여대상자이관 
		public PagingLoadResult<ShowMessageBM> setPayrToYeta_Insert( HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null;
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	Yeta2100YongInProcContainer ppc = new Yeta2100YongInProcContainer();
				    retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김해로직 
		 			Yeta2100GimHaeProcContainer ppc = new Yeta2100GimHaeProcContainer();
				    retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//거제로직 
				    Yeta2100GeoJeProcContainer ppc = new Yeta2100GeoJeProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안양로직 
				    Yeta2100AnYangProcContainer ppc = new Yeta2100AnYangProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//광명로직 
				    Yeta2100GMProcContainer ppc = new Yeta2100GMProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//삼척로직 
				    Yeta2100SamCheokProcContainer ppc = new Yeta2100SamCheokProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//수원로직 
				    Yeta2100SuWonProcContainer ppc = new Yeta2100SuWonProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//울주로직 
				    Yeta2100UlJuProcContainer ppc = new Yeta2100UlJuProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//의성군청  
				    Yeta2100UscProcContainer ppc = new Yeta2100UscProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//울산남구청
				    Yeta2100UlSanNamGuProcContainer ppc = new Yeta2100UlSanNamGuProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김천시청
				    Yeta2100GimCheonProcContainer ppc = new Yeta2100GimCheonProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//강원도고성군청
				    Yeta2100GWGSProcContainer ppc = new Yeta2100GWGSProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//순천시청
				    Yeta2100SunCheonProcContainer ppc = new Yeta2100SunCheonProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//양주시청
				    Yeta2100YangJuProcContainer ppc = new Yeta2100YangJuProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안성시청
				    Yeta2100AnSeongProcContainer ppc = new Yeta2100AnSeongProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//괴산군청
				    Yeta2100GoeSanProcContainer ppc = new Yeta2100GoeSanProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//거창군청
				    Yeta2100GeoChangProcContainer ppc = new Yeta2100GeoChangProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//함양군청
				    Yeta2100HygnProcContainer ppc = new Yeta2100HygnProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안동시청
				    Yeta2100AnDongProcContainer ppc = new Yeta2100AnDongProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//진안군청
				    Yeta2100JinAnProcContainer ppc = new Yeta2100JinAnProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//양평군청
				    Yeta2100YangPyeongProcContainer ppc = new Yeta2100YangPyeongProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//제주도청
				    Yeta2100JeJuProcContainer ppc = new Yeta2100JeJuProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//무주군청
				    Yeta2100MuJuProcContainer ppc = new Yeta2100MuJuProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//옥천군청
				    Yeta2100OkCheonProcContainer  ppc = new Yeta2100OkCheonProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//전남도청
				    Yeta2100JeonNamProcContainer ppc = new Yeta2100JeonNamProcContainer();
					retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
		 			  Yeta2100MirYangProcContainer ppc = new Yeta2100MirYangProcContainer();
					  retval =   ppc.execPayrToYeta_2017_Insert(request, listYe161010VO); 
		 			
		 		}   else {
		 			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		}  
					
				return retval; 
			}
			 
		
//		public PagingLoadResult<ShowMessageBM> fnYeta0300Payr06430CalcTax( HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo )  throws Exception  {
//			
//			   
//			   // Long result = new Long(0); 
//				PagingLoadResult<ShowMessageBM> retval = null;
//				  
//		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//용인로직 
//		        	YetaYongInProcContainer ppc = new YetaYongInProcContainer();
//				   // retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//김해로직 
//	 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//거제로직 
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//안양로직 
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//광명로직 
//
//					 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//삼척로직 
//	 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//수원로직 
//	 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//울주로직 
//
//					 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
//
//					  
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
//	 
//		        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
//				 
//		  	        
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
//		  		 
//		  	        
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
//		  			 
//		   		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
//		  			 
//		  	      
//		  	      
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
//		  			 
//		  		
//		  		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
//		  		 
//		  		
//		  		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
//		  			 
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
//		  			 
//		  		
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
//			  		 
//		  	
//		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
//			  		 
//			   	    
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
//						 
//			  	      
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
//						 
//			 	      
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
//						 
//					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
//						 
//			  	     
//		 		}    else {
//		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
//		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
//		 		} 
//			   
//				
//				return retval; 
//			} 
		
	 
}
