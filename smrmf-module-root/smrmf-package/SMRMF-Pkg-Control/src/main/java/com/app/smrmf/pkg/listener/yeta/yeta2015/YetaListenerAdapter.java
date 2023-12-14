package com.app.smrmf.pkg.listener.yeta.yeta2015;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2015.YetaYongInProcContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class YetaListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(YetaListenerAdapter.class);
	
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
      
	public YetaListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	 
	 
		public PagingLoadResult<ShowMessageBM> setYetaPayr06420_All_Create( HttpServletRequest request,InfcPkgYeta1000VO yetaPrc1000Vo)  throws Exception  {
			
		   
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null;
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직  
				 
				YetaYongInProcContainer ppc = new YetaYongInProcContainer();
			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
			 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
	 			//YetaGimHaeProcessContainer ppc = new YetaGimHaeProcessContainer();
			 //   retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
			 
	 		} 
//			    else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//거제로직 
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//안양로직 
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//광명로직 
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//삼척로직 
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//수원로직 
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//울주로직 
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
//			 
//	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//	 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
//
//				 
//				YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//			    retval =   ppc.execYetaPayr06420_All_Create(request, yetaPrc1000Vo); 
			 
	 		 else {
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
				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
		 		} 
				    else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//김해로직 
				    	//YetaGimHaeProcessContainer ppc = new YetaGimHaeProcessContainer();
				      // retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//거제로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//안양로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//광명로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//삼척로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//수원로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//울주로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execYetaPayr06420_All_Add_Create(request, yetaPrc1000Vo); 
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		} 
					
					 
				return retval; 
			}
		
		
		
		//추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
//		public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalcSeft(HttpServletRequest request,InfcPayr0250VO dtoPayr0250,SysComPsnl0100DTO dtoPsnl0100)  throws Exception  {
//			//int result = 0;
//			PagingLoadResult<ShowMessageBM> retval = null;
//			PayrProcessContainer ppc = new PayrProcessContainer();
//			if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//				//용인로직 
//				retval = ppc.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, dtoPsnl0100);
//				//System.out.println("End : " + System.currentTimeMillis());
//			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//				//김해로직 
//			} else {
//				bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
//				retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
//			}
//			
//			return retval; 
//		}
		
		public PagingLoadResult<ShowMessageBM> setPayrToYeta_Insert( HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo)  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null;
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	YetaYongInProcContainer ppc = new YetaYongInProcContainer();
				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김해로직 
		 			//YetaGimHaeProcessContainer ppc = new YetaGimHaeProcessContainer();
				   // retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//거제로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//안양로직 
//
//					RemtProcessContainer ppc = new RemtProcessContainer();
//				    //System.out.println("Start : " + System.currentTimeMillis());
//					result =   ppc.execActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo); 
//					//System.out.println("End : " + System.currentTimeMillis());
//					
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//광명로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//삼척로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//수원로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//울주로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayrToYeta_Insert(request, lstInfcPkgYeta2000Vo); 
//			 
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		}  
					
				return retval; 
			}
			
			//추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
//			public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalcSeft(HttpServletRequest request,InfcPayr0250VO dtoPayr0250,SysComPsnl0100DTO dtoPsnl0100)  throws Exception  {
//				//int result = 0;
//				PagingLoadResult<ShowMessageBM> retval = null;
//				PayrProcessContainer ppc = new PayrProcessContainer();
//				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//					//용인로직 
//					retval = ppc.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, dtoPsnl0100);
//					//System.out.println("End : " + System.currentTimeMillis());
//				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//					//김해로직 
//				} else {
//					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
//					retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
//				}
//				
//				return retval; 
//			}
		 
		
		
		public PagingLoadResult<ShowMessageBM> fnYeta0300Payr06430CalcTax( HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo )  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null;
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	YetaYongInProcContainer ppc = new YetaYongInProcContainer();
				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김해로직 
		 			//YetaGimHaeProcessContainer ppc = new YetaGimHaeProcessContainer();
				   // retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//거제로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//안양로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//광명로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//삼척로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//수원로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//울주로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		} 
			   
				
				return retval; 
			}
		
//		public PagingLoadResult<ShowMessageBM> setYetaPayr06420_All_Create( HttpServletRequest request,InfcPayr0250VO dtoPayr0250)  throws Exception  {
//			
//			   
//			   // Long result = new Long(0); 
//				PagingLoadResult<ShowMessageBM> retval = null;
//				
//			    //System.out.println("Start : " + System.currentTimeMillis()); 
//				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//					//용인로직 
//					YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execPayr4100ToPayCalculation(request,dtoPayr0250); 
//					//System.out.println("End : " + System.currentTimeMillis());
//				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//					//김해로직 
//					YetaGimHaeProcessContainer ppcGimHae = new YetaGimHaeProcessContainer();
//					retval =   ppcGimHae.execPayr4100ToPayCalculation(request,dtoPayr0250); 
//					
//				} else {
//					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
//					retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
//				}
//				return retval; 
//			}
//			
//			//추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
//			public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalcSeft(HttpServletRequest request,InfcPayr0250VO dtoPayr0250,SysComPsnl0100DTO dtoPsnl0100)  throws Exception  {
//				//int result = 0;
//				PagingLoadResult<ShowMessageBM> retval = null;
//				PayrProcessContainer ppc = new PayrProcessContainer();
//				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//					//용인로직 
//					retval = ppc.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, dtoPsnl0100);
//					//System.out.println("End : " + System.currentTimeMillis());
//				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//					//김해로직 
//				} else {
//					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
//					retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
//				}
//				
//				return retval; 
//			}
	
	 
}
