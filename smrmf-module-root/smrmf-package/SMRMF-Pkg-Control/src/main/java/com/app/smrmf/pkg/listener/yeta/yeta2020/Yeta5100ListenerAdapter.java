package com.app.smrmf.pkg.listener.yeta.yeta2020;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta5100YongInProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta5100SuWonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta5100AnSeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta5100AnYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta5100GMProcContainer;

/*import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100AnDongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100GWGSProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100GeoChangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100GeoJeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100GimCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100GimHaeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100GoeSanProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100HygnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100JeJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100JeonNamProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100JinAnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100MirYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100MuJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100OkCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100SamCheokProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100SunCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100UlJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100UlSanNamGuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100UscProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100YangJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2020.Yeta3100YangPyeongProcContainer;
*/
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class Yeta5100ListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(Yeta5100ListenerAdapter.class);
	
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
      
	public Yeta5100ListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	 
	
	 
	
	
	 public PagingLoadResult<ShowMessageBM> setUpDpopYeta_2020_Insert( HttpServletRequest request,List<InfcPkgYe161010_2020_VO> listYe161010VO)  throws Exception  {
			
			
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직  
	        	Yeta5100YongInProcContainer ppc = new Yeta5100YongInProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 																			
	 			Yeta5100AnYangProcContainer ppc = new Yeta5100AnYangProcContainer();
	 		    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 
	 			Yeta5100GMProcContainer ppc = new Yeta5100GMProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	 		
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
	  			Yeta5100AnSeongProcContainer ppc = new Yeta5100AnSeongProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	 		
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
	 			Yeta5100SuWonProcContainer ppc = new Yeta5100SuWonProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
			
			 
	 		} /*else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
	 			Yeta3100GimHaeProcContainer ppc = new Yeta3100GimHaeProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 
	 			Yeta3100GeoJeProcContainer ppc = new Yeta3100GeoJeProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
			
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 
	 			Yeta3100SamCheokProcContainer ppc = new Yeta3100SamCheokProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
				  
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 
	 			Yeta3100UlJuProcContainer ppc = new Yeta3100UlJuProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 	 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

	 			Yeta3100UscProcContainer ppc = new Yeta3100UscProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
	 			Yeta3100UlSanNamGuProcContainer ppc = new Yeta3100UlSanNamGuProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
				   
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
	 			Yeta3100GimCheonProcContainer ppc = new Yeta3100GimCheonProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
				  
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG"  GWGS;    //강원도고성군청
	 			Yeta3100GWGSProcContainer ppc = new Yeta3100GWGSProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	 			
	        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
	        	Yeta3100SunCheonProcContainer ppc = new Yeta3100SunCheonProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
	  			Yeta3100YangJuProcContainer ppc = new Yeta3100YangJuProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  	        
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
	  			Yeta3100GoeSanProcContainer ppc = new Yeta3100GoeSanProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  	      
	  	      
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
	  			 
	  			Yeta3100GeoChangProcContainer ppc = new Yeta3100GeoChangProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
	  			Yeta3100HygnProcContainer ppc = new Yeta3100HygnProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
	  			Yeta3100AnDongProcContainer ppc = new Yeta3100AnDongProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  			 
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			Yeta3100JinAnProcContainer ppc = new Yeta3100JinAnProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
	  			Yeta3100YangPyeongProcContainer ppc = new Yeta3100YangPyeongProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
	  	
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
	  			Yeta3100JeJuProcContainer ppc = new Yeta3100JeJuProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
		   	    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2020년도 
				Yeta3100MuJuProcContainer ppc = new Yeta3100MuJuProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO);  
		  	      
		    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
		    	Yeta3100OkCheonProcContainer ppc = new Yeta3100OkCheonProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO);  
		 	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
				Yeta3100JeonNamProcContainer ppc = new Yeta3100JeonNamProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 
			    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
				Yeta3100MirYangProcContainer ppc = new Yeta3100MirYangProcContainer();
			    retval =   ppc.execUpDpopYeta_2020_Insert(request, listYe161010VO); 	 
		  	     
	 		}*/    else {
	 			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[연말정산]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	         
			return retval; 
		}
		
	 
	 public PagingLoadResult<ShowMessageBM> setYetaP510001ToAll_2020_Create( HttpServletRequest request,List<InfcPkgYe161010_2020_VO> listYe161010VO)  throws Exception  {
			
			
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
						  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직  
				 
	        	Yeta5100YongInProcContainer ppc = new Yeta5100YongInProcContainer();
			    retval =   ppc.execYeta5100_All_2020_Create(request, listYe161010VO); 
			 
	        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 
	 			Yeta5100AnYangProcContainer ppc = new Yeta5100AnYangProcContainer();
	 		    retval =   ppc.execYeta5100_All_Create(request, listYe161010VO); 
				  
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 
	 			Yeta5100GMProcContainer ppc = new Yeta5100GMProcContainer();
			    retval =   ppc.execYeta5100_All_2020_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
	  			Yeta5100AnSeongProcContainer ppc = new Yeta5100AnSeongProcContainer();
			    retval =   ppc.execYeta5100_All_Create(request, listYe161010VO); 
	   		
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
	 			Yeta5100SuWonProcContainer ppc = new Yeta5100SuWonProcContainer();
			    retval =   ppc.execYeta5100_All_Create(request, listYe161010VO); 
			
	 		} /*else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
	 			Yeta3100GimHaeProcContainer ppc = new Yeta3100GimHaeProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 
	 			Yeta3100GeoJeProcContainer ppc = new Yeta3100GeoJeProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
				  
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 
	 			Yeta3100SamCheokProcContainer ppc = new Yeta3100SamCheokProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 
	 			Yeta3100UlJuProcContainer ppc = new Yeta3100UlJuProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
			
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

	 			Yeta3100UscProcContainer ppc = new Yeta3100UscProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
	 			Yeta3100UlSanNamGuProcContainer ppc = new Yeta3100UlSanNamGuProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
	 			Yeta3100GimCheonProcContainer ppc = new Yeta3100GimCheonProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG"  GWGS;    //강원도고성군청
	 			Yeta3100GWGSProcContainer ppc = new Yeta3100GWGSProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	 			
	        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
	        	Yeta3100SunCheonProcContainer ppc = new Yeta3100SunCheonProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
	  			Yeta3100YangJuProcContainer ppc = new Yeta3100YangJuProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
	  			Yeta3100GoeSanProcContainer ppc = new Yeta3100GoeSanProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	  	      
	  	      
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
	  			 
	  			Yeta3100GeoChangProcContainer ppc = new Yeta3100GeoChangProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
	  			Yeta3100HygnProcContainer ppc = new Yeta3100HygnProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	  		
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
	  			Yeta3100AnDongProcContainer ppc = new Yeta3100AnDongProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	  			 
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			Yeta3100JinAnProcContainer ppc = new Yeta3100JinAnProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
	  			Yeta3100YangPyeongProcContainer ppc = new Yeta3100YangPyeongProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
	  	
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
	  			Yeta3100JeJuProcContainer ppc = new Yeta3100JeJuProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
		   	    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2020년도 
				Yeta3100MuJuProcContainer ppc = new Yeta3100MuJuProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO);  
		  	      
		    } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
		    	Yeta3100OkCheonProcContainer ppc = new Yeta3100OkCheonProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO);  
		 	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
				Yeta3100JeonNamProcContainer ppc = new Yeta3100JeonNamProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 
			    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
				Yeta3100MirYangProcContainer ppc = new Yeta3100MirYangProcContainer();
			    retval =   ppc.execYeta3100_All_Create(request, listYe161010VO); 	 
 	     
	 		}*/    else {
	 			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[연말정산]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	         
			return retval; 
		}
		
		// 급여대상자이관 
		public PagingLoadResult<ShowMessageBM> setPayrToYeta_2020_Insert( HttpServletRequest request,List<InfcPkgYe161010_2020_VO> listYe161010VO)  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null;
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	Yeta5100YongInProcContainer ppc = new Yeta5100YongInProcContainer();
				    retval =   ppc.execPayrToYeta_2020_Insert(request, listYe161010VO); 
			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안양로직 
				    Yeta5100AnYangProcContainer ppc = new Yeta5100AnYangProcContainer();
					retval =   ppc.execPayrToYeta_2020_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//광명로직 
				    Yeta5100GMProcContainer ppc = new Yeta5100GMProcContainer();
					retval =   ppc.execPayrToYeta_2020_Insert(request, listYe161010VO); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//수원로직 
				    Yeta5100SuWonProcContainer ppc = new Yeta5100SuWonProcContainer();
					retval =   ppc.execPayrToYeta_2020_Insert(request, listYe161010VO); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안성시청
				    Yeta5100AnSeongProcContainer ppc = new Yeta5100AnSeongProcContainer();
					retval =   ppc.execPayrToYeta_2020_Insert(request, listYe161010VO); 
					
		 		}   else {
		 			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		}  
					
				return retval; 
			}
	 
}
