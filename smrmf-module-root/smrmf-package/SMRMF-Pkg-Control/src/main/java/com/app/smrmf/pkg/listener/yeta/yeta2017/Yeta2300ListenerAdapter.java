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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300AnDongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300AnSeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300AnYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300GMProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300GWGSProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300GeoChangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300GeoJeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300GimCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300GimHaeProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300GoeSanProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300HygnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300JeJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300JeonNamProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300JinAnProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300MirYangProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300MuJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300OkCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300SamCheokProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300SuWonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300SunCheonProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300UlJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300UlSanNamGuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300UscProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300YangJuProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300YangPyeongProcContainer;
import com.app.smrmf.pkg.proc.yeta.generics.yeta2017.Yeta2300YongInProcContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class Yeta2300ListenerAdapter  implements ServletContextAware, ServletConfigAware  {

	  static final Logger LOGGER = LoggerFactory.getLogger(Yeta2300ListenerAdapter.class);
	
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
      
	public Yeta2300ListenerAdapter() {
		
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 세액계산 로직 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : fnYeta2300_Ye161010_2017_CalcTax
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
	public PagingLoadResult<ShowMessageBM> fnYeta2300_Ye161010_2017_CalcTax( HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO )  throws Exception  {
		
		   
		   // Long result = new Long(0); 
			PagingLoadResult<ShowMessageBM> retval = null; 
			  
	        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//용인로직 
	        	Yeta2300YongInProcContainer ppc = new Yeta2300YongInProcContainer();
			    retval =   ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 

	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김해로직 
	 			Yeta2300GimHaeProcContainer ppc = new Yeta2300GimHaeProcContainer();
			    retval =   ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
		 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거제로직 
			    Yeta2300GeoJeProcContainer ppc = new Yeta2300GeoJeProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
		 
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안양로직 
			    Yeta2300AnYangProcContainer ppc = new Yeta2300AnYangProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//광명로직 
			    Yeta2300GMProcContainer ppc = new Yeta2300GMProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//삼척로직 
			    Yeta2300SamCheokProcContainer ppc = new Yeta2300SamCheokProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//수원로직 
			    Yeta2300SuWonProcContainer ppc = new Yeta2300SuWonProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울주로직 
			    Yeta2300UlJuProcContainer ppc = new Yeta2300UlJuProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//의성군청  
			    Yeta2300UscProcContainer ppc = new Yeta2300UscProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 	
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//울산남구청
			    Yeta2300UlSanNamGuProcContainer ppc = new Yeta2300UlSanNamGuProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//김천시청
			    Yeta2300GimCheonProcContainer ppc = new Yeta2300GimCheonProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//강원도고성군청
			    Yeta2300GWGSProcContainer ppc = new Yeta2300GWGSProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//순천시청
			    Yeta2300SunCheonProcContainer ppc = new Yeta2300SunCheonProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//양주시청
			    Yeta2300YangJuProcContainer ppc = new Yeta2300YangJuProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안성시청
			    Yeta2300AnSeongProcContainer ppc = new Yeta2300AnSeongProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//괴산군청
			    Yeta2300GoeSanProcContainer ppc = new Yeta2300GoeSanProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//거창군청
			    Yeta2300GeoChangProcContainer ppc = new Yeta2300GeoChangProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//함양군청
			    Yeta2300HygnProcContainer ppc = new Yeta2300HygnProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//안동시청
			    Yeta2300AnDongProcContainer ppc = new Yeta2300AnDongProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//진안군청
			    Yeta2300JinAnProcContainer ppc = new Yeta2300JinAnProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//양평군청
			    Yeta2300YangPyeongProcContainer ppc = new Yeta2300YangPyeongProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//제주도청
			    Yeta2300JeJuProcContainer ppc = new Yeta2300JeJuProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//무주군청
			    Yeta2300MuJuProcContainer ppc = new Yeta2300MuJuProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//옥천군청
			    Yeta2300OkCheonProcContainer  ppc = new Yeta2300OkCheonProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 			//전남도청
			    Yeta2300JeonNamProcContainer ppc = new Yeta2300JeonNamProcContainer();
				retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
				
	 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
	 			  Yeta2300MirYangProcContainer ppc = new Yeta2300MirYangProcContainer();
				  retval =    ppc.execfnYeta2300Payr06430CalcTax(request, listYe161010VO); 
	 			
					 
		  	       
	 		}    else {
	 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
	 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
	 		} 
		   
			
			return retval; 
		}
		
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 소득공제관리 화면 변경시 처리를 위한 루틴 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : fnYeta2300_Ye161010_2017_CalcTax
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
		public PagingLoadResult<ShowMessageBM> fnYeta2300_Ye161010_2017_CalcUpdate( HttpServletRequest request,InfcPkgYe161010VO ye161010VO,String serviceDiv )  throws Exception  {
			
			   
			   // Long result = new Long(0); 
				PagingLoadResult<ShowMessageBM> retval = null; 
				  
		        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//용인로직 
		        	Yeta2300YongInProcContainer ppc = new Yeta2300YongInProcContainer();
				    retval =   ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
	
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김해로직 
		 			Yeta2300GimHaeProcContainer ppc = new Yeta2300GimHaeProcContainer();
				    retval =   ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//거제로직 
				    Yeta2300GeoJeProcContainer ppc = new Yeta2300GeoJeProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
			 
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안양로직 
				    Yeta2300AnYangProcContainer ppc = new Yeta2300AnYangProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//광명로직 
				    Yeta2300GMProcContainer ppc = new Yeta2300GMProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//삼척로직 
				    Yeta2300SamCheokProcContainer ppc = new Yeta2300SamCheokProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//수원로직 
				    Yeta2300SuWonProcContainer ppc = new Yeta2300SuWonProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//울주로직 
				    Yeta2300UlJuProcContainer ppc = new Yeta2300UlJuProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//의성군청  
				    Yeta2300UscProcContainer ppc = new Yeta2300UscProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 	
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//울산남구청
				    Yeta2300UlSanNamGuProcContainer ppc = new Yeta2300UlSanNamGuProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//김천시청
				    Yeta2300GimCheonProcContainer ppc = new Yeta2300GimCheonProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//강원도고성군청
				    Yeta2300GWGSProcContainer ppc = new Yeta2300GWGSProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//순천시청
				    Yeta2300SunCheonProcContainer ppc = new Yeta2300SunCheonProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//양주시청
				    Yeta2300YangJuProcContainer ppc = new Yeta2300YangJuProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안성시청
				    Yeta2300AnSeongProcContainer ppc = new Yeta2300AnSeongProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//괴산군청
				    Yeta2300GoeSanProcContainer ppc = new Yeta2300GoeSanProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//거창군청
				    Yeta2300GeoChangProcContainer ppc = new Yeta2300GeoChangProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//함양군청
				    Yeta2300HygnProcContainer ppc = new Yeta2300HygnProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//안동시청
				    Yeta2300AnDongProcContainer ppc = new Yeta2300AnDongProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//진안군청
				    Yeta2300JinAnProcContainer ppc = new Yeta2300JinAnProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//양평군청
				    Yeta2300YangPyeongProcContainer ppc = new Yeta2300YangPyeongProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//제주도청
				    Yeta2300JeJuProcContainer ppc = new Yeta2300JeJuProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//무주군청
				    Yeta2300MuJuProcContainer ppc = new Yeta2300MuJuProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//옥천군청
				    Yeta2300OkCheonProcContainer  ppc = new Yeta2300OkCheonProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//전남도청
				    Yeta2300JeonNamProcContainer ppc = new Yeta2300JeonNamProcContainer();
					retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
					
		 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
		 			  Yeta2300MirYangProcContainer ppc = new Yeta2300MirYangProcContainer();
					  retval =    ppc.execfnYeta2300YetaTableCalcUpdate(request, ye161010VO,serviceDiv); 
		 			
						 
			  	       
		 		}    else {
		 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
		 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		 		} 
			   
				
				return retval; 
			}
		
 
	
	 
}
