package com.app.smrmf.pkg.listener;

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
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0360VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.pkg.proc.payr.generics.PayrAnDongProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrAnDongSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrAnSeongProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrAnSeongSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrAnYangProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrAnYangSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGMProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGMSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGWGSProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGWGSSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGeoChangProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGeoChangSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGeoJeProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGeoJeSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGimCheonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGimCheonSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGimHaeProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGimHaeSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGoeSanProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrGoeSanSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrHygnProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrHygnSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrJeJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrJeJuSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrJeonNamProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrJeonNamSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrJinAnProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrJinAnSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrMirYangProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrMirYangSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrMuJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrMuJuSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrOkCheonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrOkCheonSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrSamCheokProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrSamCheokSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrSuWonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrSuWonSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrSunCheonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrSunCheonSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrUlJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrUlJuSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrUlSanNamGuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrUlSanNamGuSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrUscProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrUscSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrYangJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrYangJuSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrYangPyeongProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrYangPyeongSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrYongInProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.PayrYongInSubProcContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoAnDongProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoAnSeongProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoAnYangProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoGMProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoGWGSProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoGeoChangProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoGeoJeProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoGimCheonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoGimHaeProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoGoeSanProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoHygnProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoJeJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoJeonNamProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoJinAnProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoMirYangProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoMuJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoOkCheonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoSamCheokProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoSuWonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoSunCheonProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoUlJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoUlSanNamGuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoUscProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoYangJuProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoYangPyeongProcessContainer;
import com.app.smrmf.pkg.proc.payr.generics.RetoYongInProcessContainer;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


public class PayrListenerAdapter  implements ServletContextAware, ServletConfigAware  {

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
    
	public PayrListenerAdapter() { 
		  extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	} 

	/**
	 * 1. 단가산정호출메서드
	 *    - 생성기준값을 넘김.
	 * 2. 소득세 ,지방소득세 산정 메서드
	 *    급여합계테이블에서 과세 부분에 대한 소득세 처리
	 * 3. 급여계산메서드
	 *    - 급여스케줄에 따른 기간안에 퇴직자,재직자 관련 정보를 가지고 온다. psnl0100 
	 *    - 인사정보
	 *    - 단가표 - 대상자 직종,근속년수에 따른 단가표 처리
	 *    - 추가 수당 존재여부 체크
	 *    - 공제 여부 확인
	 *    - 해당 내역에 대한 맵 값
	 *    - 전체계산 저장
	 *    - 급여 조정시 처리시 
	 *      -  소득세 제계산
	 *    - 마감??  
	 * 
	 */
	//스케줄링에 따른 급여계산 로
	public PagingLoadResult<ShowMessageBM> setPayr4100ToPayCalculation( HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250)  throws Exception  {
		
	   
	   // Long result = new Long(0); 
		PagingLoadResult<ShowMessageBM> retval = null;
		
		  //System.out.println("Start : " + System.currentTimeMillis()); 
				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//용인로직 
					PayrYongInProcessContainer ppc = new PayrYongInProcessContainer();
				    retval =   ppc.execPayr4100ToPayCalculation(request,dtoPayr0250); 
					//System.out.println("End : " + System.currentTimeMillis());
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//김해로직 
					PayrGimHaeProcessContainer ppcGimHae = new PayrGimHaeProcessContainer();
					retval =   ppcGimHae.execPayr4100ToPayCalculation(request,dtoPayr0250); 
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//거제로직 
					PayrGeoJeProcessContainer ppcGeoJe = new PayrGeoJeProcessContainer();
					retval =   ppcGeoJe.execPayr4100ToPayCalculation(request,dtoPayr0250); 
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//안양로직 
					PayrAnYangProcessContainer ppcAnYang = new PayrAnYangProcessContainer();
					retval =   ppcAnYang.execPayr4100ToPayCalculation(request,dtoPayr0250); 
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//광명로직 
					PayrGMProcessContainer ppcGM = new PayrGMProcessContainer();
					retval =   ppcGM.execPayr4100ToPayCalculation(request,dtoPayr0250); 
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//삼척로직 
					PayrSamCheokProcessContainer ppcSamCheok = new PayrSamCheokProcessContainer();
					retval =   ppcSamCheok.execPayr4100ToPayCalculation(request,dtoPayr0250); 
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//수원로직 
					PayrSuWonProcessContainer ppcSuwon = new PayrSuWonProcessContainer();
					retval =   ppcSuwon.execPayr4100ToPayCalculation(request,dtoPayr0250); 
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//울주로직 
					PayrUlJuProcessContainer ppcUlJu = new PayrUlJuProcessContainer();
					retval =   ppcUlJu.execPayr4100ToPayCalculation(request,dtoPayr0250); 
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
					
					PayrUscProcessContainer ppcUsc = new PayrUscProcessContainer();
					retval =   ppcUsc.execPayr4100ToPayCalculation(request,dtoPayr0250); 
					 
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
					
					PayrUlSanNamGuProcessContainer ppcULSANNAMGU = new PayrUlSanNamGuProcessContainer();
					retval =   ppcULSANNAMGU.execPayr4100ToPayCalculation(request,dtoPayr0250); 
					 
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
					
					PayrGimCheonProcessContainer ppcGIMCHEON = new PayrGimCheonProcessContainer();
					retval =   ppcGIMCHEON.execPayr4100ToPayCalculation(request,dtoPayr0250); 
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
					
					PayrGWGSProcessContainer ppcGWGS = new PayrGWGSProcessContainer();
					retval =   ppcGWGS.execPayr4100ToPayCalculation(request,dtoPayr0250); 	
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
					PayrSunCheonProcessContainer ppcSunCheon = new PayrSunCheonProcessContainer(); 
					retval =  ppcSunCheon.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
		  			PayrYangJuProcessContainer ppcYangJu = new PayrYangJuProcessContainer(); 
		  			retval =  ppcYangJu.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  	        
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
		  			PayrAnSeongProcessContainer ppcAnSeong = new PayrAnSeongProcessContainer(); 
		  			retval =  ppcAnSeong.execPayr4100ToPayCalculation(request,dtoPayr0250);
		   		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
		  			PayrGoeSanProcessContainer ppcGoeSan = new PayrGoeSanProcessContainer(); 
		  			retval =  ppcGoeSan.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  	      
		  	      
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
		  			PayrGeoChangProcessContainer ppcGeoChang = new PayrGeoChangProcessContainer(); 
		  			retval =  ppcGeoChang.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
		  			PayrHygnProcessContainer ppcHygn = new PayrHygnProcessContainer(); 
		  			retval =  ppcHygn.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  		
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
		  			PayrAnDongProcessContainer ppcAnDong = new PayrAnDongProcessContainer(); 
		  			retval =  ppcAnDong.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
		  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
		  			PayrJinAnProcessContainer ppcJinAn = new PayrJinAnProcessContainer(); 
		  			retval =  ppcJinAn.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  		
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
			  			PayrYangPyeongProcessContainer ppcYangPyeong = new PayrYangPyeongProcessContainer(); 
			  			retval =  ppcYangPyeong.execPayr4100ToPayCalculation(request,dtoPayr0250);
		  	
		  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
			  			PayrJeJuProcessContainer ppcJeJu = new PayrJeJuProcessContainer(); 
			  			retval = ppcJeJu.execPayr4100ToPayCalculation(request,dtoPayr0250);
			   	    
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
						PayrMuJuProcessContainer ppcMuJu = new PayrMuJuProcessContainer(); 
						retval = ppcMuJu.execPayr4100ToPayCalculation(request,dtoPayr0250);
			  	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
						PayrOkCheonProcessContainer ppcOkCheon = new PayrOkCheonProcessContainer(); 
						retval = ppcOkCheon.execPayr4100ToPayCalculation(request,dtoPayr0250);
			 	      
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
						PayrJeonNamProcessContainer ppcJeonNam = new PayrJeonNamProcessContainer(); 
						retval = ppcJeonNam.execPayr4100ToPayCalculation(request,dtoPayr0250);
					} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 
						PayrMirYangProcessContainer ppcMirYang = new PayrMirYangProcessContainer(); 
						retval = ppcMirYang.execPayr4100ToPayCalculation(request,dtoPayr0250);
			  	              	
						
		  	        
				}  else {
					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
					retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
				}
				
		 
		return retval; 
	}
	
	//추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
	public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250,InfcPkgPsnl0100VO voPsnl0100)  throws Exception  {
		//int result = 0;
		PagingLoadResult<ShowMessageBM> retval = null;
		
		if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//용인로직 
			PayrYongInProcessContainer ppc = new PayrYongInProcessContainer();
			retval = ppc.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
			//System.out.println("End : " + System.currentTimeMillis());
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//김해로직 
			PayrGimHaeProcessContainer ppcGimHae = new PayrGimHaeProcessContainer();
			retval =   ppcGimHae.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//거제로직 
			PayrGeoJeProcessContainer ppcGeoJe = new PayrGeoJeProcessContainer();
			retval =   ppcGeoJe.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//안양로직 
			PayrAnYangProcessContainer ppcAnYang = new PayrAnYangProcessContainer();
			retval =   ppcAnYang.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//광명로직 
			PayrGMProcessContainer ppcGM = new PayrGMProcessContainer();
			retval =   ppcGM.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//삼척로직 
			PayrSamCheokProcessContainer ppcSamCheok = new PayrSamCheokProcessContainer();
			retval =   ppcSamCheok.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//수원로직 
			PayrSuWonProcessContainer ppcSuwon = new PayrSuWonProcessContainer();
			retval =   ppcSuwon.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//울주로직 
			PayrUlJuProcessContainer ppcUlJu = new PayrUlJuProcessContainer();
			retval =   ppcUlJu.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
			
			PayrUscProcessContainer ppcUsc = new PayrUscProcessContainer();
			retval =   ppcUsc.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
			 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
			
			PayrUlSanNamGuProcessContainer ppcULSANNAMGU = new PayrUlSanNamGuProcessContainer();
			retval =   ppcULSANNAMGU.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
			 
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
			
			PayrGimCheonProcessContainer ppcGIMCHEON = new PayrGimCheonProcessContainer();
			retval =   ppcGIMCHEON.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
			
			PayrGWGSProcessContainer ppcGWGS = new PayrGWGSProcessContainer();
			retval =   ppcGWGS.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
			PayrSunCheonProcessContainer ppcSunCheon = new PayrSunCheonProcessContainer(); 
			retval =  ppcSunCheon.execPayr4100ToPayCalcSeft(request, dtoPayr0250, voPsnl0100);
 	        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
 			PayrYangJuProcessContainer ppcYangJu = new PayrYangJuProcessContainer(); 
 			retval =  ppcYangJu.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
 	        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
 			PayrAnSeongProcessContainer ppcAnSeong = new PayrAnSeongProcessContainer(); 
 			retval =  ppcAnSeong.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
  		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
  			PayrGoeSanProcessContainer ppcGoeSan = new PayrGoeSanProcessContainer(); 
  			retval =  ppcGoeSan.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  			PayrGeoChangProcessContainer ppcGeoChang = new PayrGeoChangProcessContainer(); 
  			retval =  ppcGeoChang.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  			PayrHygnProcessContainer ppcHygn = new PayrHygnProcessContainer(); 
  			retval =  ppcHygn.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  			PayrAnDongProcessContainer ppcAnDong = new PayrAnDongProcessContainer(); 
  			retval =  ppcAnDong.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			PayrJinAnProcessContainer ppcJinAn = new PayrJinAnProcessContainer(); 
	  			retval =  ppcJinAn.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
	  			
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
	  			PayrYangPyeongProcessContainer ppcYangPyeong = new PayrYangPyeongProcessContainer(); 
	  			retval =  ppcYangPyeong.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
	  
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
	  			PayrJeJuProcessContainer ppcJeJu = new PayrJeJuProcessContainer(); 
	  			retval = ppcJeJu.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
	   	    
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
				PayrMuJuProcessContainer ppcMuJu = new PayrMuJuProcessContainer(); 
				retval = ppcMuJu.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
	  	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
				PayrOkCheonProcessContainer ppcOkCheon = new PayrOkCheonProcessContainer(); 
				retval = ppcOkCheon.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
	 	      
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
				PayrJeonNamProcessContainer ppcJeonNam = new PayrJeonNamProcessContainer(); 
				retval = ppcJeonNam.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
	 	      	
			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 	
				
				PayrMirYangProcessContainer ppcMirYang = new PayrMirYangProcessContainer(); 
				retval = ppcMirYang.execPayr4100ToPayCalcSeft(request ,dtoPayr0250, voPsnl0100);
				
		}  else {
			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		}
		  
		return retval; 
	}
	
	

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 그리드 멀티건에 대한 처리 로직 선택에 따른  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : setPayr4100ToPayCalcSeft
	 * @date : 2017. 6. 27.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 6. 27.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param request
	 * @param dtoPayr0250
	 * @param voPsnl0100
	 * @return
	 * @throws Exception
	 */
	public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalcMulti(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250,List<InfcPkgPsnl0100VO>  listInfcPkgPsnl0100Vo)  throws Exception  {
		//int result = 0;
		PagingLoadResult<ShowMessageBM> retval = null;
		
		if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//용인로직 
			PayrYongInProcessContainer ppc = new PayrYongInProcessContainer();
			retval = ppc.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
		 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//김해로직 
			PayrGimHaeProcessContainer ppcGimHae = new PayrGimHaeProcessContainer();
			retval =   ppcGimHae.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//거제로직 
			PayrGeoJeProcessContainer ppcGeoJe = new PayrGeoJeProcessContainer();
			retval =   ppcGeoJe.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//안양로직 
			PayrAnYangProcessContainer ppcAnYang = new PayrAnYangProcessContainer();
			retval =   ppcAnYang.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//광명로직 
			PayrGMProcessContainer ppcGM = new PayrGMProcessContainer();
			retval =   ppcGM.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);

		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//삼척로직 
			PayrSamCheokProcessContainer ppcSamCheok = new PayrSamCheokProcessContainer();
			retval =   ppcSamCheok.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//수원로직 
			PayrSuWonProcessContainer ppcSuwon = new PayrSuWonProcessContainer();
			retval =   ppcSuwon.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//울주로직 
			PayrUlJuProcessContainer ppcUlJu = new PayrUlJuProcessContainer();
			retval =   ppcUlJu.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
			
			PayrUscProcessContainer ppcUsc = new PayrUscProcessContainer();
			retval =   ppcUsc.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
			 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
			
			PayrUlSanNamGuProcessContainer ppcULSANNAMGU = new PayrUlSanNamGuProcessContainer();
			retval =   ppcULSANNAMGU.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo); 
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
			
			PayrGimCheonProcessContainer ppcGIMCHEON = new PayrGimCheonProcessContainer();
			retval =   ppcGIMCHEON.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
			PayrGWGSProcessContainer ppcGWGS = new PayrGWGSProcessContainer();
			retval =   ppcGWGS.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
			PayrSunCheonProcessContainer ppcSunCheon = new PayrSunCheonProcessContainer(); 
			retval =  ppcSunCheon.setPayr4100ToPayCalcMulti(request, dtoPayr0250, listInfcPkgPsnl0100Vo);
 	        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
 			PayrYangJuProcessContainer ppcYangJu = new PayrYangJuProcessContainer(); 
 			retval =  ppcYangJu.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
 	        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
 			PayrAnSeongProcessContainer ppcAnSeong = new PayrAnSeongProcessContainer(); 
 			retval =  ppcAnSeong.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
  		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
  			PayrGoeSanProcessContainer ppcGoeSan = new PayrGoeSanProcessContainer(); 
  			retval =  ppcGoeSan.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  			PayrGeoChangProcessContainer ppcGeoChang = new PayrGeoChangProcessContainer(); 
  			retval =  ppcGeoChang.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  			PayrHygnProcessContainer ppcHygn = new PayrHygnProcessContainer(); 
  			retval =  ppcHygn.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  			PayrAnDongProcessContainer ppcAnDong = new PayrAnDongProcessContainer(); 
  			retval =  ppcAnDong.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			PayrJinAnProcessContainer ppcJinAn = new PayrJinAnProcessContainer(); 
	  			retval =  ppcJinAn.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
	  			
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
	  			PayrYangPyeongProcessContainer ppcYangPyeong = new PayrYangPyeongProcessContainer(); 
	  			retval =  ppcYangPyeong.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
	  	
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 	   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
 	  			PayrJeJuProcessContainer ppcJeJu = new PayrJeJuProcessContainer(); 
 	  			retval = ppcJeJu.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
 	   	    
 			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 	  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
 				PayrMuJuProcessContainer ppcMuJu = new PayrMuJuProcessContainer(); 
 				retval = ppcMuJu.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
 	  	      
 			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 	 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
 				PayrOkCheonProcessContainer ppcOkCheon = new PayrOkCheonProcessContainer(); 
 				retval = ppcOkCheon.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
 	 	      
 			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 	 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
 				PayrJeonNamProcessContainer ppcJeonNam = new PayrJeonNamProcessContainer(); 
 				retval = ppcJeonNam.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
 			
 			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 	    		
 				PayrMirYangProcessContainer ppcMirYang = new PayrMirYangProcessContainer(); 
 				retval = ppcMirYang.setPayr4100ToPayCalcMulti(request ,dtoPayr0250, listInfcPkgPsnl0100Vo);
		}  else {
			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
			retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		}
		  
		return retval; 
	}
	
	
	//급여조정로직 
    public int setPayr4200ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0302VO voPayr0302)  throws Exception  {
        int result = 0;
          
        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//용인로직 
        	PayrYongInSubProcContainer ppc = new PayrYongInSubProcContainer();
        	result = ppc.execPayr4200ToPayCalcSeft(request ,voPayr0302);
			//System.out.println("End : " + System.currentTimeMillis());
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//김해로직 
			PayrGimHaeSubProcContainer ppcGimHae = new PayrGimHaeSubProcContainer();
			result =   ppcGimHae.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//거제로직 
			PayrGeoJeSubProcContainer ppcGeoJe = new PayrGeoJeSubProcContainer();
			result =   ppcGeoJe.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//안양로직 
			PayrAnYangSubProcContainer ppcAnYang = new PayrAnYangSubProcContainer();
			result =   ppcAnYang.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//광명로직 
			PayrGMSubProcContainer ppcGM = new PayrGMSubProcContainer();
			result =   ppcGM.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//삼척로직 
			PayrSamCheokSubProcContainer ppcSamCheok = new PayrSamCheokSubProcContainer();
			result =   ppcSamCheok.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//수원로직 
			PayrSuWonSubProcContainer ppcSuwon = new PayrSuWonSubProcContainer();
			result =   ppcSuwon.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//울주로직 
			PayrUlJuSubProcContainer ppcUlJu = new PayrUlJuSubProcContainer();
			result =   ppcUlJu.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
			
			PayrUscSubProcContainer ppcUsc = new PayrUscSubProcContainer();
			result =   ppcUsc.execPayr4200ToPayCalcSeft(request ,voPayr0302);
			 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
			
			PayrUlSanNamGuSubProcContainer ppcULSANNAMGU = new PayrUlSanNamGuSubProcContainer();
			result =   ppcULSANNAMGU.execPayr4200ToPayCalcSeft(request ,voPayr0302);
			 
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
			
			PayrGimCheonSubProcContainer ppcGIMCHEON = new PayrGimCheonSubProcContainer();
			result =   ppcGIMCHEON.execPayr4200ToPayCalcSeft(request ,voPayr0302);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
			
			PayrGWGSSubProcContainer ppcGWGS = new PayrGWGSSubProcContainer();
			result =   ppcGWGS.execPayr4200ToPayCalcSeft(request ,voPayr0302);
	
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
			PayrSunCheonSubProcContainer ppcSunCheon = new PayrSunCheonSubProcContainer(); 
			result =  ppcSunCheon.execPayr4200ToPayCalcSeft(request, voPayr0302);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
			PayrYangJuSubProcContainer ppcYangJu = new PayrYangJuSubProcContainer(); 
			result =  ppcYangJu.execPayr4200ToPayCalcSeft(request ,voPayr0302);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
			PayrAnSeongSubProcContainer ppcAnSeong = new PayrAnSeongSubProcContainer(); 
			result =  ppcAnSeong.execPayr4200ToPayCalcSeft(request ,voPayr0302);
 					
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
			PayrGoeSanSubProcContainer ppcGoeSan = new PayrGoeSanSubProcContainer(); 
  			result =  ppcGoeSan.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  			PayrGeoChangSubProcContainer ppcGeoChang = new PayrGeoChangSubProcContainer(); 
  			result =  ppcGeoChang.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  			PayrHygnSubProcContainer ppcHygn = new PayrHygnSubProcContainer(); 
  			result =  ppcHygn.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  			PayrAnDongSubProcContainer ppcAnDong = new PayrAnDongSubProcContainer(); 
  			result =  ppcAnDong.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
	  			PayrJinAnSubProcContainer ppcJinAn = new PayrJinAnSubProcContainer(); 
	  			result =  ppcJinAn.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
	  			PayrYangPyeongSubProcContainer ppcYangPyeong = new PayrYangPyeongSubProcContainer(); 
	  			result =  ppcYangPyeong.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  	
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  	   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
  	  			PayrJeJuSubProcContainer ppcJeJu = new PayrJeJuSubProcContainer(); 
  	  			result = ppcJeJu.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  	   	    
  			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  	  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
  				PayrMuJuSubProcContainer ppcMuJu = new PayrMuJuSubProcContainer(); 
  				result = ppcMuJu.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  	  	      
  			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  	 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
  				PayrOkCheonSubProcContainer ppcOkCheon = new PayrOkCheonSubProcContainer(); 
  				result = ppcOkCheon.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  	 	      
  			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  	 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
  				PayrJeonNamSubProcContainer ppcJeonNam = new PayrJeonNamSubProcContainer(); 
  				result = ppcJeonNam.execPayr4200ToPayCalcSeft(request ,voPayr0302);
  		
  			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 	 
  				PayrMirYangSubProcContainer ppcMirYang = new PayrMirYangSubProcContainer(); 
  				result = ppcMirYang.execPayr4200ToPayCalcSeft(request ,voPayr0302);
		}    else {
			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		} 
		 
        return result; 
    } 
	
	   //직종세-> 근속년수 생성로직 
    public Long createPyspLogSvcYrNumCd(HttpServletRequest request,InfcPkgPayr0400VO infcPayr0400Vo)  throws Exception  {
        Long result = new Long(0); 
        
        if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//용인로직 
        	PayrYongInSubProcContainer ppc = new PayrYongInSubProcContainer(); 
             result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
			//System.out.println("End : " + System.currentTimeMillis());
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//김해로직 
			PayrGimHaeSubProcContainer ppc = new PayrGimHaeSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//거제로직 
			PayrGeoJeSubProcContainer ppc = new PayrGeoJeSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//안양로직 
			 PayrAnYangSubProcContainer ppc = new PayrAnYangSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//광명로직 
			PayrGMSubProcContainer ppc = new PayrGMSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//삼척로직 
			 PayrSamCheokSubProcContainer ppc = new PayrSamCheokSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//수원로직 
			 PayrSuWonSubProcContainer ppc = new PayrSuWonSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//울주로직 
			PayrUlJuSubProcContainer ppc = new PayrUlJuSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
			
			PayrUscSubProcContainer ppc = new PayrUscSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
			 
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
			
			 PayrUlSanNamGuSubProcContainer ppc = new PayrUlSanNamGuSubProcContainer(); 
		        result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
			 
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
			
			PayrGimCheonSubProcContainer ppc = new PayrGimCheonSubProcContainer(); 
		     result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
		        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청
			 PayrGWGSSubProcContainer ppc = new PayrGWGSSubProcContainer(); 
		     result = (long)ppc.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo); 
	
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
			PayrSunCheonSubProcContainer ppcSunCheon = new PayrSunCheonSubProcContainer(); 
			result =  (long)ppcSunCheon.createPyspLogSvcYrNumCd(request, infcPayr0400Vo);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
			PayrYangJuSubProcContainer ppcYangJu = new PayrYangJuSubProcContainer(); 
			result =  (long)ppcYangJu.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
			PayrAnSeongSubProcContainer ppcAnSeong = new PayrAnSeongSubProcContainer(); 
			result =  (long)ppcAnSeong.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
			
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
			PayrGoeSanSubProcContainer ppcGoeSan = new PayrGoeSanSubProcContainer(); 
  			result =  (long)ppcGoeSan.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  			PayrGeoChangSubProcContainer ppcGeoChang = new PayrGeoChangSubProcContainer(); 
  			result =  (long)ppcGeoChang.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  			PayrHygnSubProcContainer ppcHygn = new PayrHygnSubProcContainer(); 
  			result =  (long)ppcHygn.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  			PayrAnDongSubProcContainer ppcAnDong = new PayrAnDongSubProcContainer(); 
  			result =  (long)ppcAnDong.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
  			PayrJinAnSubProcContainer ppcJinAn = new PayrJinAnSubProcContainer(); 
	  		result =  (long)ppcJinAn.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
  			PayrYangPyeongSubProcContainer ppcYangPyeong = new PayrYangPyeongSubProcContainer(); 
	  			result =   (long)ppcYangPyeong.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
	  											
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
  			PayrJeJuSubProcContainer ppcJeJu = new PayrJeJuSubProcContainer(); 
  			result = (long)ppcJeJu.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
   	    
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
			PayrMuJuSubProcContainer ppcMuJu = new PayrMuJuSubProcContainer(); 
			result = (long)ppcMuJu.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
  	      
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
			PayrOkCheonSubProcContainer ppcOkCheon = new PayrOkCheonSubProcContainer(); 
			result = (long)ppcOkCheon.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
 	      
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
			PayrJeonNamSubProcContainer ppcJeonNam = new PayrJeonNamSubProcContainer(); 
			result = (long)ppcJeonNam.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시 	    	  									
			PayrMirYangSubProcContainer ppcMirYang = new PayrMirYangSubProcContainer(); 
			result = (long)ppcMirYang.createPyspLogSvcYrNumCd(request ,infcPayr0400Vo);		
		}    else {
			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		} 
        
       
        
        return result; 
    }
	  
    
  //소급계산로직 
  	public PagingLoadResult<ShowMessageBM> setPayr4210ToRetoCalculation( HttpServletRequest request,InfcPkgPayr0360VO infcPayr0360Vo)  throws Exception  {
  		
  	   // Long result = new Long(0); 
  		PagingLoadResult<ShowMessageBM> retval = null;
  		
  		 if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//용인로직 

  	  		RetoYongInProcessContainer ppc = new RetoYongInProcessContainer();
  	  	    //System.out.println("Start : " + System.currentTimeMillis());
  	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
  	  		//System.out.println("End : " + System.currentTimeMillis());
 			//System.out.println("End : " + System.currentTimeMillis());
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//김해로직 

 	  		RetoGimHaeProcessContainer ppc = new RetoGimHaeProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//거제로직 

 	  		RetoGeoJeProcessContainer ppc = new RetoGeoJeProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//안양로직 

 	  		RetoAnYangProcessContainer ppc = new RetoAnYangProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//광명로직 

 	  		RetoGMProcessContainer ppc = new RetoGMProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//삼척로직 

 	  		RetoSamCheokProcessContainer ppc = new RetoSamCheokProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//수원로직 

 	  		RetoSuWonProcessContainer ppc = new RetoSuWonProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//울주로직 

 	  		RetoUlJuProcessContainer ppc = new RetoUlJuProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
 			

 	  		RetoUscProcessContainer ppc = new RetoUscProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 			 
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
 			

 	  		RetoUlSanNamGuProcessContainer ppc = new RetoUlSanNamGuProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
 			

 	  		RetoGimCheonProcessContainer ppc = new RetoGimCheonProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

 	  		RetoGWGSProcessContainer ppc = new RetoGWGSProcessContainer();
 	  	    //System.out.println("Start : " + System.currentTimeMillis());
 	  	    retval =   ppc.execPayr4210ToRetoCalculation(request,infcPayr0360Vo); 
 	  		//System.out.println("End : " + System.currentTimeMillis());
 	  	    
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
 			RetoSunCheonProcessContainer ppcSunCheon = new RetoSunCheonProcessContainer(); 
			retval =  ppcSunCheon.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
 	        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
 			RetoYangJuProcessContainer ppcYangJu = new RetoYangJuProcessContainer(); 
 			retval =  ppcYangJu.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
 	        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
 			RetoAnSeongProcessContainer ppcAnSeong = new RetoAnSeongProcessContainer(); 
 			retval =  ppcAnSeong.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
  			RetoGoeSanProcessContainer ppcGoeSan = new RetoGoeSanProcessContainer(); 
  			retval =   ppcGoeSan.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  			RetoGeoChangProcessContainer ppcGeoChang = new RetoGeoChangProcessContainer(); 
  			retval =  ppcGeoChang.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  			RetoHygnProcessContainer ppcHygn = new RetoHygnProcessContainer(); 
  			retval =   ppcHygn.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  			RetoAnDongProcessContainer ppcAnDong = new RetoAnDongProcessContainer(); 
  			retval =   ppcAnDong.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  				
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
  				RetoJinAnProcessContainer ppcJinAn = new RetoJinAnProcessContainer(); 
	  			retval =  ppcJinAn.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  	  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
  	  				RetoYangPyeongProcessContainer ppcYangPyeong = new RetoYangPyeongProcessContainer(); 
  		  			retval =  ppcYangPyeong.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  		  						
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
    		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
  			RetoJeJuProcessContainer ppcJeJu = new RetoJeJuProcessContainer(); 
  			retval = ppcJeJu.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);   
    	    
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
   	   	        RetoMuJuProcessContainer ppcMuJu = new RetoMuJuProcessContainer(); 
   	   	     retval = ppcMuJu.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
   	      
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
  	   	        RetoOkCheonProcessContainer ppcOkCheon = new RetoOkCheonProcessContainer(); 
  	   	  retval = ppcOkCheon.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);
  	      
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
  	   	        RetoJeonNamProcessContainer ppcJeonNam = new RetoJeonNamProcessContainer(); 
  	   	  retval = ppcJeonNam.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);  
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시    	  									
 		   RetoMirYangProcessContainer ppcMirYang = new RetoMirYangProcessContainer(); 
   	   	  retval = ppcMirYang.execPayr4210ToRetoCalculation(request,infcPayr0360Vo);  
   	   	  
 		}    else {
 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
 		} 
  		
  		return retval; 
  	}
  	
  	//소급계산개별로직 
 	public PagingLoadResult<ShowMessageBM> setPayr4210ToPayCalcSeft( HttpServletRequest request,InfcPkgPayr0360VO infcPayr0360Vo,ArrayList<InfcPkgPsnl0100VO> dtoListPsnl0100)  throws Exception  {
  		
 		PagingLoadResult<ShowMessageBM> retval = null;
 		
 		if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//용인로직 

 	   		RetoYongInProcessContainer ppc = new RetoYongInProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//김해로직 

 	   		RetoGimHaeProcessContainer ppc = new RetoGimHaeProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//거제로직 

 	   		RetoGeoJeProcessContainer ppc = new RetoGeoJeProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 	  	    
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//안양로직 

 	   		RetoAnYangProcessContainer ppc = new RetoAnYangProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 	  	    
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//광명로직 

 	   		RetoGMProcessContainer ppc = new RetoGMProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 	  	    
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//삼척로직 

 	   		RetoSamCheokProcessContainer ppc = new RetoSamCheokProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 	  	    
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//수원로직 

 	   		RetoSuWonProcessContainer ppc = new RetoSuWonProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//울주로직 

 	   		RetoUlJuProcessContainer ppc = new RetoUlJuProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 	  	    
 		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  

 	   		RetoUscProcessContainer ppc = new RetoUscProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 	  	    
 			 
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
 			
 	   		RetoUlSanNamGuProcessContainer ppc = new RetoUlSanNamGuProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 			
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
 			
 	   		RetoGimCheonProcessContainer ppc = new RetoGimCheonProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 		        
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_12 = "GOSEONG";    //강원도고성군청

 	   		RetoGWGSProcessContainer ppc = new RetoGWGSProcessContainer();
 	   	    //System.out.println("Start : " + System.currentTimeMillis());
 	   	    retval =   ppc.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100); 
 	   		//System.out.println("End : " + System.currentTimeMillis());
 	   		
 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_13.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			 //public static final String PAYGEN_MUNICIPALITIES_13 = "SUNCHEON";    //순천
			RetoSunCheonProcessContainer ppcSunCheon = new RetoSunCheonProcessContainer(); 
			retval =  ppcSunCheon.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_14.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_14 = "YANGJU";    //양주
			RetoYangJuProcessContainer ppcYangJu = new RetoYangJuProcessContainer(); 
			retval =  ppcYangJu.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
	        
		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
			//public static final String PAYGEN_MUNICIPALITIES_15 = "ANSEONG";    //안성
			RetoAnSeongProcessContainer ppcAnSeong = new RetoAnSeongProcessContainer(); 
			retval =  ppcAnSeong.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
 		

 		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_16.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_16 = "GOESAN";       //괴산
  			RetoGoeSanProcessContainer ppcGoeSan = new RetoGoeSanProcessContainer(); 
  			retval =   ppcGoeSan.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
  	      
  	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_17.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_17 = "GEOCHANG";     //거창
  			RetoGeoChangProcessContainer ppcGeoChang = new RetoGeoChangProcessContainer(); 
  			retval =  ppcGeoChang.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_18.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_18 = "HYGN";         //함양 
  			RetoHygnProcessContainer ppcHygn = new RetoHygnProcessContainer(); 
  			retval =   ppcHygn.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
  		
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_19.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
 			//public static final String PAYGEN_MUNICIPALITIES_19 = "ANDONG";         //안동 
  			RetoAnDongProcessContainer ppcAnDong = new RetoAnDongProcessContainer(); 
  			retval =   ppcAnDong.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
  				
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	  		// public static final String PAYGEN_MUNICIPALITIES_20 = "JINAN";       //진안 
  				RetoJinAnProcessContainer ppcJinAn = new RetoJinAnProcessContainer(); 
	  			retval =  ppcJinAn.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
	  			
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_21.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  		//public static final String PAYGEN_MUNICIPALITIES_21 = "YANGPYEONG";       //YangPyeong 
  				RetoYangPyeongProcessContainer ppcYangPyeong = new RetoYangPyeongProcessContainer(); 
	  			retval =  ppcYangPyeong.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
	  						

   		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_22.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
     		 //public static final String PAYGEN_MUNICIPALITIES_22 = "JEJU";       //제주도청 
   			RetoJeJuProcessContainer ppcJeJu = new RetoJeJuProcessContainer(); 
   			retval = ppcJeJu.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);    
     	    
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_23.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
    		 //public static final String PAYGEN_MUNICIPALITIES_23 = "MUJU";       //무주군청 -2018년도 
    	   	        RetoMuJuProcessContainer ppcMuJu = new RetoMuJuProcessContainer(); 
    	   	     retval = ppcMuJu.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
    	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_24.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_24 = "OKCHEON";       //옥천군청 
   	   	        RetoOkCheonProcessContainer ppcOkCheon = new RetoOkCheonProcessContainer(); 
   	   	  retval = ppcOkCheon.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);
   	      
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_25.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
   		 //public static final String PAYGEN_MUNICIPALITIES_25 = "JEONNAM";       //전남도청 
   	   	        RetoJeonNamProcessContainer ppcJeonNam = new RetoJeonNamProcessContainer(); 
   	   	  retval = ppcJeonNam.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);    
  		
  		} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_26.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
  			//public static final String PAYGEN_MUNICIPALITIES_26 = "MIRYANG";    MirYang   //밀양시    	   		
  	       RetoMirYangProcessContainer ppcMirYang = new RetoMirYangProcessContainer(); 
    	   	  retval = ppcMirYang.execPayr4210ToPayCalcSeft(request,infcPayr0360Vo,dtoListPsnl0100);  
    	   	  
  		}    else {
 			//bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","설정정보","PayGen.MunicipalitiesName" )); 
 			//retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
 		} 
 		
   	  
   		return retval; 
   	}
   	  
}
