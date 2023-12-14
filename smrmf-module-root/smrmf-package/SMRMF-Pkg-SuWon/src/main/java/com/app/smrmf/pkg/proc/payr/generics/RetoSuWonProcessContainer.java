package com.app.smrmf.pkg.proc.payr.generics;

 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0360VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.pkg.proc.payr.retroactivity.calculation.RetroactivityCalculationService;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


/**
 *  소급적용
* <pre>
* 1. 패키지명 : com.app.smrmf.payr.generics
* 2. 타입명 : RetoProcessContainer.java
* 3. 작성일 : Jan 4, 2016 10:30:01 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Controller 
public class RetoSuWonProcessContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(RetoSuWonProcessContainer.class);
	  
	//소급계산로직 
	@Autowired
    @Resource(name = "RetroactivityCalculationService")
    protected RetroactivityCalculationService RetoCalcService;
	 
    
	  //스케줄링에 따른 급여계산 로직
	  	public PagingLoadResult<ShowMessageBM> execPayr4210ToRetoCalculation(HttpServletRequest request,InfcPkgPayr0360VO infcPayr0360Vo)  throws Exception  {
	  	    
	  	  return  funcPayr4210ToRetoCalc(request,infcPayr0360Vo,null );
	  	}
	  	
	  	
		public PagingLoadResult<ShowMessageBM> execPayr4210ToPayCalcSeft( HttpServletRequest request,InfcPkgPayr0360VO infcPayr0360Vo,ArrayList<InfcPkgPsnl0100VO> dtoListPsnl0100)  throws Exception  {
	  		
		   	   // Long result = new Long(0); 
		   		PagingLoadResult<ShowMessageBM> retval = null;
		   		List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		   		try {
		   		
		   			
			   		RetoSuWonProcessContainer ppc = new RetoSuWonProcessContainer();
			   	    //System.out.println("Start : " + System.currentTimeMillis());
			   	    for(int iPayrCnt=0;iPayrCnt < dtoListPsnl0100.size();iPayrCnt++) {  
					    
			   	    	InfcPkgPsnl0100VO  infcPkgPsnl0100VO = new InfcPkgPsnl0100VO();
			   	    	infcPkgPsnl0100VO = dtoListPsnl0100.get(iPayrCnt);  
					     
						retval =   ppc.execPayr4210ToRetoCalcSeft(request,infcPayr0360Vo,infcPkgPsnl0100VO); 
						  
		            }  
			   	   
			   		//System.out.println("End : " + System.currentTimeMillis());
				 } catch (Exception ex) {
		             ex.printStackTrace();   
		     	   ShowMessageBM smBm = new ShowMessageBM();
		     	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
		     	   smBm.setMenu("Payr");
		     	   smBm.setPhase("[소급]에러");
		     	   smBm.setMessage(ex.getLocalizedMessage());
		     	   smBm.setContent(ex.getMessage());
		     	   bmResult.add(smBm);  
		     	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
		     	 
		        }  		
			   	  return retval; 
		   	}
	  	
	  	//추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
	  	public PagingLoadResult<ShowMessageBM>  execPayr4210ToRetoCalcSeft(HttpServletRequest request,InfcPkgPayr0360VO infcPayr0360Vo,InfcPkgPsnl0100VO infcPsnl0100Vo)  throws Exception  {
	  	     return  funcPayr4210ToRetoCalc(request,infcPayr0360Vo,infcPsnl0100Vo );
	  	}
	  	
	  
	  	
	  	private PagingLoadResult<ShowMessageBM> funcPayr4210ToRetoCalc(HttpServletRequest request,InfcPkgPayr0360VO infcPayr0360Vo,InfcPkgPsnl0100VO voPsnl0100)  throws Exception {
	  	    
	  	  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
	      InfcPkgPayr0304SrhVO  payr0304SrhVo = new InfcPkgPayr0304SrhVO();
          InfcPkgPayr0304VO  payr0304Vo = new InfcPkgPayr0304VO();
	  	  
	  	   if  (RetoCalcService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               RetoCalcService = (RetroactivityCalculationService) wac.getBean("RetroactivityCalculationService" ); 
              
          }
	    
           
         try { 
        	  
        	 
        	 /** @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 월별 따른 처리  시작 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
        	  /**
              * 지급월여부 판단. 플래그  시작 
              */
         
        	 payr0304SrhVo.setDpobCd(infcPayr0360Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
        	 payr0304SrhVo.setPymtYrMnth("000000");    /** column 지급년월 : pymtYrMnth */
        	// payr0304SrhVo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */
        	// payr0304SrhVo.setPayrSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
        	 payr0304SrhVo.setSystemkey(voPsnl0100.getSystemkey());    /** column SYSTEMKEY : systemkey */
              
        	 
        	 
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp01())) {
        		 
        		 payr0304SrhVo.setPymtYrMnth("000000");    /** column 지급년월 : pymtYrMnth */
        		 
        	 };    /** column 지급월설정_01 : pymtMnthStp01 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp02())) {
        		 
        	 };       /** column 지급월설정_02 : pymtMnthStp02 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp03())) {
        		 
        	 };       /** column 지급월설정_03 : pymtMnthStp03 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp04())) {
        		 
        	 };       /** column 지급월설정_04 : pymtMnthStp04 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp05())) {
        		 
        	 };       /** column 지급월설정_05 : pymtMnthStp05 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp06())) {
        		 
        	 };       /** column 지급월설정_06 : pymtMnthStp06 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp07())) {
        		 
        	 };       /** column 지급월설정_07 : pymtMnthStp07 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp08())) {
        		 
        	 };       /** column 지급월설정_08 : pymtMnthStp08 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp09())) {
        		 
        	 };       /** column 지급월설정_09 : pymtMnthStp09 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp10())) {
        		 
        	 };       /** column 지급월설정_10 : pymtMnthStp10 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp11())) {
        		 
        	 };       /** column 지급월설정_11 : pymtMnthStp11 */
        	 if (("Y").equals(infcPayr0360Vo.getPymtMnthStp12())) {
        		 
        	 };       /** column 지급월설정_12 : pymtMnthStp12 */
             
        	 /** @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 월별 따른 처리  종료 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */ 
        	 
        	 
         } catch (Exception ex) {
                ex.printStackTrace();   
        	   ShowMessageBM smBm = new ShowMessageBM();
        	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
        	   smBm.setMenu("Payr");
        	   smBm.setPhase("[소급]에러");
        	   smBm.setMessage(ex.getLocalizedMessage());
        	   smBm.setContent(ex.getMessage());
        	   bmResult.add(smBm);  
        	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
        	 
           } 
           
           return retval; 
	  	} 

}