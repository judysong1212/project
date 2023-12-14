package com.app.smrmf.pkg.listener.yeta.yeta2021;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2015.YetaYongInProcContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class Yeta6200ListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(Yeta6200ListenerAdapter.class);
	
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
      
	public Yeta6200ListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	 
	 
		public PagingLoadResult<ShowMessageBM> setYetaPayr06420_All_Create( HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
			
		   
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직  
				 
				YetaYongInProcContainer ppc = new YetaYongInProcContainer();
			   // retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 

				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 

				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 

				 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 
 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 

				 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

				  
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
 
	        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
			 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
	  		 
	  	        
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
	  			 
	   		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
	  			 
	  	      
	  	      
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
	  			 
	  		
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
	  		 
	  		
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
	  			 
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			 
	  		
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
		  		 
	  	
	  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
		  		 
		   	    
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
					 
		  	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
					 
		 	      
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
					 
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
					 
		  	     
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
	         
			return retval; 
		}
		
		public PagingLoadResult<ShowMessageBM> setYetaPayr06420_All_Add_Create( HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null;
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	YetaYongInProcContainer ppc = new YetaYongInProcContainer();
				   // retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김해로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//거제로직 

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안양로직 

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//광명로직 

					 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//삼척로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//수원로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//울주로직 

					 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
	 
		        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
				 
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
		  		 
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
		  			 
		   		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
		  			 
		  	      
		  	      
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
		  			 
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
		  		 
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
		  			 
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			 
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
			  		 
		  	
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
			  		 
			   	    
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
						 
			  	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
						 
			 	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
						 
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
						 
			  	     
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		} 
					
					 
				return retval; 
			}
		
		
		
 
		
		// 급여대상자이관 
		public PagingLoadResult<ShowMessageBM> setPayrToYeta_Insert( HttpServletRequest request,List<InfcPkgYe160401VO>  lstInfcPkgYe160401Vo)  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null;
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//용인로직 
//		        	YetaYongInProcessContainer ppc = new YetaYongInProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYe160401Vo); 
//			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김해로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//거제로직 

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안양로직 

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//광명로직 

					 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//삼척로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//수원로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//울주로직 

					 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
	 
		        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
				 
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
		  		 
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
		  			 
		   		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
		  			 
		  	      
		  	      
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
		  			 
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
		  		 
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
		  			 
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			 
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
			  		 
		  	
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
			  		 
			   	    
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
						 
			  	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
						 
			 	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
						 
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
						 
			  	     
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		}  
					
				return retval; 
			}
			
 
		
		
		public PagingLoadResult<ShowMessageBM> fnYeta0300Payr06430CalcTax( HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo )  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null;
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	YetaYongInProcContainer ppc = new YetaYongInProcContainer();
				  //  retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김해로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//거제로직 

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안양로직 

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//광명로직 

					 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//삼척로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//수원로직 
	 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//울주로직 

					 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청

					  
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
	 
		        } else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
				 
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
		  		 
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
		  			 
		   		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
		  			 
		  	      
		  	      
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
		  			 
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
		  		 
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
		  			 
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			 
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
			  		 
		  	
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
			  		 
			   	    
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
						 
			  	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
						 
			 	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
						 
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
						 
			  	     
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		} 
			   
				
				return retval; 
			}
		
 
	
	 
}
