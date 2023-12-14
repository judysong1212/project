package com.app.smrmf.pkg.listener.yeta.yeta2016;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2016.Yeta1300AnYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2016.Yeta1300YongInProcContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class Yeta1300ListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(Yeta1300ListenerAdapter.class);
	
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
      
	public Yeta1300ListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	   
		
		public PagingLoadResult<ShowMessageBM> fnYeta0300Payr06430CalcTax( HttpServletRequest request,List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo )  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null; 
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	Yeta1300YongInProcContainer ppc = new Yeta1300YongInProcContainer();
				    retval =   ppc.execfnYeta1300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//김해로직 
//		 			YetaGimHaeProcessContainer ppc = new YetaGimHaeProcessContainer();
//				    //retval =   ppc.execfnYeta1300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
//		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//		 			//거제로직 
//		 			YetaYonginProcessContainer ppc = new YetaYonginProcessContainer();
//				    retval =   ppc.execfnYeta0300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
//				 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안양로직 
		 			Yeta1300AnYangProcContainer ppc = new Yeta1300AnYangProcContainer();
				    retval =   ppc.execfnYeta1300Payr06430CalcTax(request, lstInfcPkgYeta2000Vo); 
				 
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
		
 
	
	 
}
