package com.app.smrmf.pkg.listener.yeta.yeta2018;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300AnDongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300AnSeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300AnYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300GMProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300GWGSProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300GeoChangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300GeoJeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300GimCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300GimHaeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300GoeSanProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300HygnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300JeJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300JeonNamProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300JinAnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300MirYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300MuJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300OkCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300SamCheokProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300SuWonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300SunCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300UlJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300UlSanNamGuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300UscProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300YangJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300YangPyeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2018.Yeta3300YongInProcContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class Yeta3300ListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(Yeta3300ListenerAdapter.class);
	
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
      
	public Yeta3300ListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 세액계산 로직 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : fnYeta3300_Ye161010_2017_CalcTax
	 * @date : 2018. 1. 31.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 31.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param request
	 * @param listYe161010VO
	 * @return
	 * @throws Exception
	 */
	public PagingLoadResult<ShowMessageBM> fnYeta3300_Ye161010_2018_CalcTax( HttpServletRequest request,List<InfcPkgYe161010_2018_VO> listYe161010VO )  throws Exception  {
		
		   
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null; 
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 
	        	Yeta3300YongInProcContainer ppc = new Yeta3300YongInProcContainer();
			    retval =   ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 

	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
	 			Yeta3300GimHaeProcContainer ppc = new Yeta3300GimHaeProcContainer();
			    retval =   ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
		 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 
			    Yeta3300GeoJeProcContainer ppc = new Yeta3300GeoJeProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
		 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 
			    Yeta3300AnYangProcContainer ppc = new Yeta3300AnYangProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 
			    Yeta3300GMProcContainer ppc = new Yeta3300GMProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 
			    Yeta3300SamCheokProcContainer ppc = new Yeta3300SamCheokProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
			    Yeta3300SuWonProcContainer ppc = new Yeta3300SuWonProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 
			    Yeta3300UlJuProcContainer ppc = new Yeta3300UlJuProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//의성군청  
			    Yeta3300UscProcContainer ppc = new Yeta3300UscProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울산남구청
			    Yeta3300UlSanNamGuProcContainer ppc = new Yeta3300UlSanNamGuProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김천시청
			    Yeta3300GimCheonProcContainer ppc = new Yeta3300GimCheonProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//강원도고성군청
			    Yeta3300GWGSProcContainer ppc = new Yeta3300GWGSProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//순천시청
			    Yeta3300SunCheonProcContainer ppc = new Yeta3300SunCheonProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//양주시청
			    Yeta3300YangJuProcContainer ppc = new Yeta3300YangJuProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안성시청
			    Yeta3300AnSeongProcContainer ppc = new Yeta3300AnSeongProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//괴산군청
			    Yeta3300GoeSanProcContainer ppc = new Yeta3300GoeSanProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거창군청
			    Yeta3300GeoChangProcContainer ppc = new Yeta3300GeoChangProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//함양군청
			    Yeta3300HygnProcContainer ppc = new Yeta3300HygnProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안동시청
			    Yeta3300AnDongProcContainer ppc = new Yeta3300AnDongProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//진안군청
			    Yeta3300JinAnProcContainer ppc = new Yeta3300JinAnProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//양평군청
			    Yeta3300YangPyeongProcContainer ppc = new Yeta3300YangPyeongProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//제주도청
			    Yeta3300JeJuProcContainer ppc = new Yeta3300JeJuProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//무주군청
			    Yeta3300MuJuProcContainer ppc = new Yeta3300MuJuProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//옥천군청
			    Yeta3300OkCheonProcContainer  ppc = new Yeta3300OkCheonProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//전남도청
			    Yeta3300JeonNamProcContainer ppc = new Yeta3300JeonNamProcContainer();
				retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
	 			  Yeta3300MirYangProcContainer ppc = new Yeta3300MirYangProcContainer();
				  retval =    ppc.execfnYeta3300Payr06430CalcTax(request, listYe161010VO); 
	 			
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
		   
			
			return retval; 
		}
		
		
			public PagingLoadResult<ShowMessageBM> fnYeta3300_Ye161010_2018_CalcUpdate( HttpServletRequest request,InfcPkgYe161010_2018_VO ye161010VO,String serviceDiv )  throws Exception  {
			
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null; 
				  
				  if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//용인로직 
			        	Yeta3300YongInProcContainer ppc = new Yeta3300YongInProcContainer();
					    retval =   ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
		
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//김해로직 
			 			Yeta3300GimHaeProcContainer ppc = new Yeta3300GimHaeProcContainer();
					    retval =   ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
				 
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//거제로직 
					    Yeta3300GeoJeProcContainer ppc = new Yeta3300GeoJeProcContainer();
						retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
				 
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//안양로직 
					    Yeta3300AnYangProcContainer ppc = new Yeta3300AnYangProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//광명로직 
					    Yeta3300GMProcContainer ppc = new Yeta3300GMProcContainer();
						retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//삼척로직 
					    Yeta3300SamCheokProcContainer ppc = new Yeta3300SamCheokProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//수원로직 
					    Yeta3300SuWonProcContainer ppc = new Yeta3300SuWonProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//울주로직 
					    Yeta3300UlJuProcContainer ppc = new Yeta3300UlJuProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//의성군청  
					    Yeta3300UscProcContainer ppc = new Yeta3300UscProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//울산남구청
					    Yeta3300UlSanNamGuProcContainer ppc = new Yeta3300UlSanNamGuProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//김천시청
					    Yeta3300GimCheonProcContainer ppc = new Yeta3300GimCheonProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//강원도고성군청
					    Yeta3300GWGSProcContainer ppc = new Yeta3300GWGSProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//순천시청
					    Yeta3300SunCheonProcContainer ppc = new Yeta3300SunCheonProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//양주시청
					    Yeta3300YangJuProcContainer ppc = new Yeta3300YangJuProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//안성시청
					    Yeta3300AnSeongProcContainer ppc = new Yeta3300AnSeongProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//괴산군청
					    Yeta3300GoeSanProcContainer ppc = new Yeta3300GoeSanProcContainer();
						retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//거창군청
					    Yeta3300GeoChangProcContainer ppc = new Yeta3300GeoChangProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//함양군청
					    Yeta3300HygnProcContainer ppc = new Yeta3300HygnProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//안동시청
					    Yeta3300AnDongProcContainer ppc = new Yeta3300AnDongProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//진안군청
					    Yeta3300JinAnProcContainer ppc = new Yeta3300JinAnProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//양평군청
					    Yeta3300YangPyeongProcContainer ppc = new Yeta3300YangPyeongProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//제주도청
					    Yeta3300JeJuProcContainer ppc = new Yeta3300JeJuProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//무주군청
					    Yeta3300MuJuProcContainer ppc = new Yeta3300MuJuProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//옥천군청
					    Yeta3300OkCheonProcContainer  ppc = new Yeta3300OkCheonProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 			//전남도청
					    Yeta3300JeonNamProcContainer ppc = new Yeta3300JeonNamProcContainer();
					    retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
						
			 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
			 			  Yeta3300MirYangProcContainer ppc = new Yeta3300MirYangProcContainer();
			 			 retval =    ppc.execfnYeta3300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
		 			
			  	       
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		} 
			   
				
				return retval; 
			}
		
 
	
	 
}
