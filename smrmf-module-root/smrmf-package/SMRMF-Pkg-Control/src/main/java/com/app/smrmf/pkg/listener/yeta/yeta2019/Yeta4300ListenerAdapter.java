package com.app.smrmf.pkg.listener.yeta.yeta2019;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta4300YongInProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta4300AnSeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta4300AnYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta4300GMProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta4300SuWonProcContainer;

/*import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300AnDongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300GWGSProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300GeoChangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300GeoJeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300GimCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300GimHaeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300GoeSanProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300HygnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300JeJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300JeonNamProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300JinAnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300MirYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300MuJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300OkCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300SamCheokProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300SunCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300UlJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300UlSanNamGuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300UscProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300YangJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2019.Yeta3300YangPyeongProcContainer;
*/
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class Yeta4300ListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(Yeta4300ListenerAdapter.class);
	
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
      
	public Yeta4300ListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 세액계산 로직 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : fnYeta3300_Ye161010_2017_CalcTax
	 * @date : 2019. 1. 31.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 1. 31.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param request
	 * @param listYe161010VO
	 * @return
	 * @throws Exception
	 */
	public PagingLoadResult<ShowMessageBM> fnYeta4300_Ye161010_2019_CalcTax( HttpServletRequest request,List<InfcPkgYe161010_2019_VO> listYe161010VO )  throws Exception  {
		
		   
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null; 
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 
	        	Yeta4300YongInProcContainer ppc = new Yeta4300YongInProcContainer();
			    retval =   ppc.execfnYeta4300Payr06430CalcTax(request, listYe161010VO); 

	 		}else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 
			    Yeta4300AnYangProcContainer ppc = new Yeta4300AnYangProcContainer();
				retval =    ppc.execfnYeta4300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 
			    Yeta4300GMProcContainer ppc = new Yeta4300GMProcContainer();
				retval =    ppc.execfnYeta4300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
			    Yeta4300SuWonProcContainer ppc = new Yeta4300SuWonProcContainer();
				retval =    ppc.execfnYeta4300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안성시청
			    Yeta4300AnSeongProcContainer ppc = new Yeta4300AnSeongProcContainer();
				retval =    ppc.execfnYeta4300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
		   
			
			return retval; 
		}
		
		
			public PagingLoadResult<ShowMessageBM> fnYeta4300_Ye161010_2019_CalcUpdate( HttpServletRequest request,InfcPkgYe161010_2019_VO ye161010VO,String serviceDiv )  throws Exception  {
			
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null; 
				  
				  if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//용인로직 
			        	Yeta4300YongInProcContainer ppc = new Yeta4300YongInProcContainer();
					    retval =   ppc.execfnYeta4300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
		
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//안양로직 
					    Yeta4300AnYangProcContainer ppc = new Yeta4300AnYangProcContainer();
					    retval =    ppc.execfnYeta4300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//광명로직 
					    Yeta4300GMProcContainer ppc = new Yeta4300GMProcContainer();
						retval =    ppc.execfnYeta4300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//수원로직 
					    Yeta4300SuWonProcContainer ppc = new Yeta4300SuWonProcContainer();
					    retval =    ppc.execfnYeta4300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//안성시청
					    Yeta4300AnSeongProcContainer ppc = new Yeta4300AnSeongProcContainer();
					    retval =    ppc.execfnYeta4300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		}  else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		} 
			   
				
				return retval; 
			}
		
 
	
	 
}