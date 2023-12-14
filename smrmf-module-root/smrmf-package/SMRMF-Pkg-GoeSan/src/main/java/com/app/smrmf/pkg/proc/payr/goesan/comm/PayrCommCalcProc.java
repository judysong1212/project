package com.app.smrmf.pkg.proc.payr.goesan.comm;

 
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0309VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;
import com.app.smrmf.pkg.proc.payr.pay.calculation.service.PayCalculationService;
import com.app.smrmf.pkg.proc.payr.pysplogsvcyrnum.PyspLogSvcYrNumService;
import com.ext.constants.PropPayGenConfs;
/**
 * 각 급여 관련 실제 로직을 처리 하는 부분
 */
 
public class PayrCommCalcProc {
	 

	private static final Logger logger = LoggerFactory.getLogger(PayrCommCalcProc.class);
	
 
	//급여계산  
	@Autowired
    @Resource(name = "PayCalculationService")
    protected PayCalculationService payCalculationService;
	

	 //급여관련 공통 패키지 처리 
	@Autowired
   @Resource(name = "PayrCommCalcService")
   protected PayrCommCalcService payrCommCalcService;
	
	 //근속년수 
    @Autowired
    @Resource(name = "PyspLogSvcYrNumService")
    protected PyspLogSvcYrNumService pyspLogSvcYrNumService; 
    
   /*
    * 생성자 
    */
    public PayrCommCalcProc () {
    	
        
    }
    
    /**
	   * 
	   * @param request
	   * @param payr0250Vo
	   * @param payCalculationVo
	   * @param sessionUser
	   */
	   public String call_funcPayr0309(HttpServletRequest request, InfcPkgPayr0250VO payr0250Vo,
				PkgPayrCommCalcVO payCalculationVo, MSFSysm0100BM sessionUser) throws Exception {
			
		   // TODO Auto-generated method stub
		   InfcPkgPayr0309VO payr0309Vo = new InfcPkgPayr0309VO();
         InfcPkgPayr0309VO tpPayr0309Vo = new InfcPkgPayr0309VO();
       
         String rtnPayr = "";  
         
         payrCommCalcService = (PayrCommCalcService)BeanFinder.getBean("PayrCommCalcService");
         payCalculationService = (PayCalculationService)BeanFinder.getBean("PayCalculationService");
        
         
         try {
      	   
			            payr0309Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
			            payr0309Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
			            payr0309Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
			            payr0309Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
			            payr0309Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
			     	    payr0309Vo.setHlthInsurFlucDt(payCalculationVo.getHlthInsurFlucDt());    /** column 건강보험변동일자 : hlthInsurFlucDt */
			     	    payr0309Vo.setHlthInsrPayTotAmnt(payCalculationVo.getHlthInsrPayTotAmnt());    /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
			     	    payr0309Vo.setHlthInsrMnthRuntnAmnt(payCalculationVo.getHlthInsrMnthRuntnAmnt());    /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
			     	    payr0309Vo.setHlthInsrGrde(payCalculationVo.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
			     	    payr0309Vo.setHlthInsrCertNum(payCalculationVo.getHlthInsrCertNum());    /** column 건강보험증번호 : hlthInsrCertNum */
			     	    payr0309Vo.setNatPennInsurFlucDt(payCalculationVo.getNatPennInsurFlucDt());    /** column 국민연금변동일자 : natPennInsurFlucDt */
			     	    payr0309Vo.setNatPennStdIncmMnthAmnt(payCalculationVo.getNatPennStdIncmMnthAmnt());    /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
			     	    payr0309Vo.setNatPennGrde(payCalculationVo.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
			     	    payr0309Vo.setHlthInsrApptnYn(payCalculationVo.getHlthInsrApptnYn());    /** column 건강보험적용여부 : hlthInsrApptnYn */
			     	    payr0309Vo.setNatPennApptnYn(payCalculationVo.getNatPennApptnYn());    /** column 국민연금적용여부 : natPennApptnYn */
			     	    payr0309Vo.setUmytInsrApptnYn(payCalculationVo.getUmytInsrApptnYn());    /** column 고용보험적용여부 : umytInsrApptnYn */
			     	    payr0309Vo.setIdtlAccdtInsurApptnYn(payCalculationVo.getIdtlAccdtInsurApptnYn());    /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
			     	 
			     	    payr0309Vo.setUmytInsrFlucDt(payCalculationVo.getUmytInsrFlucDt());    /** column 고용보험변동일자 : umytInsrFlucDt */
			     	    payr0309Vo.setUmytInsrPayTotAmnt(payCalculationVo.getUmytInsrPayTotAmnt());    /** column 고용보험보수총액 : umytInsrPayTotAmnt */
			     	    payr0309Vo.setUmytInsrPayMnthAmnt(payCalculationVo.getUmytInsrPayMnthAmnt());    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
			     	    payr0309Vo.setIdtlAccdtFlucDt(payCalculationVo.getIdtlAccdtFlucDt());    /** column 산재보험변동일자 : idtlAccdtFlucDt */
			     	    payr0309Vo.setIdtlAccdtPayTotAmnt(payCalculationVo.getIdtlAccdtPayTotAmnt());    /** column 산재보험보수총액 : idtlAccdtPayTotAmnt */
			     	    payr0309Vo.setIdtlAccdtPayMnthAmnt(payCalculationVo.getIdtlAccdtPayMnthAmnt());    /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
			 	    
			     	    payr0309Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
			     	    payr0309Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
			     	    payr0309Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
			     	    payr0309Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
			         	    
			            tpPayr0309Vo = payrCommCalcService.selectPayr0309(payr0309Vo); 
			            
			            if (MSFSharedUtils.paramNull(tpPayr0309Vo)) { 
			               
			             
			            	rtnPayr = payrCommCalcService.insertPayr0309(payr0309Vo);
							
			                
			            } else {
			                
			                payrCommCalcService.updatePayr0309(payr0309Vo);
			                rtnPayr = "1";
			            }
          
          } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
         
         return rtnPayr; 
		}

	   /**
	    *  급여 마스터 테이블에 인서트 한다. Payr0300
	    * @param request
	    * @param payr0250Vo
	    * @param sessionUser
	    * @return
	    */
	   public String  call_funcPayr0300(HttpServletRequest request, InfcPkgPayr0250VO payr0250Vo, MSFSysm0100BM sessionUser) throws Exception {
		 

	        InfcPkgPayr0300VO  payr0300Vo = new InfcPkgPayr0300VO();
			String rtnPayr = "";   
	        
			payrCommCalcService = (PayrCommCalcService)BeanFinder.getBean("PayrCommCalcService");
		    payCalculationService = (PayCalculationService)BeanFinder.getBean("PayCalculationService");
		       
	        
	        try {
		            //직종 // 근속년수 에따른 급여 항목 정보 추출 및 단가표에서 값을 가지고 온다. 
		            //검색조건 - 지급년월, 사용여부 년월에 지급여 
		            //payr0410SrhVo.setDpobCd(payr0250Vo.getDpobCd());  //사업장코드 
		            //payr0410SrhVo.setPayYr(payr0250Vo.getJobYrMnth().substring(0, 4)); //급여항목년도 
		            
		            //payrCommCalcService.selectPayrItemUnitInfoList(searchVO);
		             
		            //무기계약직 
		            payr0300Vo.setDpobCd(payr0250Vo.getDpobCd()); //사업장코드 
		            payr0300Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드 
		            payr0300Vo.setPayrMangDeptCd(payr0250Vo.getPayrMangDeptCd()) ;//단위기관코드 
		            payr0300Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()); 
		            payr0300Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
		            payr0300Vo.setPayPymtDt(payr0250Vo.getPymtDt());   //지급일자 
		            payr0300Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
		            payr0300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
		            payr0300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		            payr0300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		       	    
		            InfcPkgPayr0300VO  tpPayr0300Vo = new InfcPkgPayr0300VO();
		            
		            tpPayr0300Vo = payCalculationService.selectPayr0300(payr0300Vo); 
		             
		            if (MSFSharedUtils.paramNull(tpPayr0300Vo) 
		            		|| MSFSharedUtils.paramNull(tpPayr0300Vo.getPayPymtDt()))  {
		         	   //급여마스터 테이블에 데이터을 인서트한다.  
		            	rtnPayr = payrCommCalcService.insertPayr0300(payr0300Vo); 
		           } 
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
         return rtnPayr; 
		}

	   /**
	    *  급여 대상자 테이블에 인서트 후 InfcPkgPayr0304VO 객체 리턴 
	    * @param request
	    * @param payr0250Vo
	    * @param payCalculationVo
	    * @param sessionUser
	    * @return InfcPkgPayr0304VO
	    */
	public InfcPkgPayr0304VO call_funcPayr0304(HttpServletRequest request, InfcPkgPayr0250VO payr0250Vo,
			PkgPayrCommCalcVO payCalculationVo, MSFSysm0100BM sessionUser) throws Exception {

		InfcPkgPayr0304VO  payr0304Vo = new InfcPkgPayr0304VO();
		String rtnPayr = "";   
         
        payrCommCalcService = (PayrCommCalcService)BeanFinder.getBean("PayrCommCalcService");
        payCalculationService = (PayCalculationService)BeanFinder.getBean("PayCalculationService");
        
        try {  
          
				 payr0304Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
		         payr0304Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
		         payr0304Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
		         payr0304Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
		         payr0304Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
		         payr0304Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
		         payr0304Vo.setMangeDeptCd(payCalculationVo.getMangeDeptCd());    /** column 인사관리부서코드  mangeDeptCd */
		         payr0304Vo.setEmymtDivCd(payCalculationVo.getEmymtDivCd());            /** column 고용구분코드 : emymtDivCd */
		         payr0304Vo.setHanNm(payCalculationVo.getHanNm());                      /** column 한글성명 : hanNm */
		         payr0304Vo.setResnRegnNum(payCalculationVo.getResnRegnNum());          /** column 주민등록번호 : resnRegnNum */
		         payr0304Vo.setDeptCd(payCalculationVo.getCurrAffnDeptCd());                    /** column 부서코드 : deptCd */
		         payr0304Vo.setBusinCd(payCalculationVo.getBusinCd());    /** column 사업코드 : businCd */
		         payr0304Vo.setTypOccuCd(payCalculationVo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
		         payr0304Vo.setDtilOccuInttnCd(payCalculationVo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
		         payr0304Vo.setOdtyCd(payCalculationVo.getOdtyCd());    /** column 직책코드 : odtyCd */
		         payr0304Vo.setPyspCd(payCalculationVo.getPyspCd());    /** column 호봉코드 : pyspCd */
		         payr0304Vo.setPyspGrdeCd(payCalculationVo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
		         payr0304Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
		         payr0304Vo.setLogSvcMnthIcmCd(payCalculationVo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
		         payr0304Vo.setFrstEmymtDt(payCalculationVo.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
		         payr0304Vo.setEmymtBgnnDt(payCalculationVo.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
		         payr0304Vo.setEmymtEndDt(payCalculationVo.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
		         payr0304Vo.setHdofcDivCd(payCalculationVo.getHdofcCodtnCd());    /** column 재직구분코드 : hdofcDivCd */
		         payr0304Vo.setRetryDt(payCalculationVo.getRetryDt());    /** column 퇴직일자 : retryDt */
		         payr0304Vo.setLogSvcStdDt(payCalculationVo.getLogSvcStdDt());    /** column 근속기준일자 : logSvcStdDt */
		         payr0304Vo.setSpueYn(payCalculationVo.getSpueYn());    /** column 배우자유무 : spueYn */
		         payr0304Vo.setSuprtFamyNumTwenChDn(payCalculationVo.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
		         if (("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn())) 
		                  && (payCalculationVo.getSuprtFamyNumTwenChDn().compareTo( new BigDecimal("2")) > 0)) {
		             payr0304Vo.setSuprtFamyNumTreOvrChdn(payCalculationVo.getSuprtFamyNumTwenChDn().subtract( new BigDecimal("2")) );    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
		             payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /**TODO column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
		             
		         } else  {
		             payr0304Vo.setSuprtFamyNumTreOvrChdn(BigDecimal.ZERO);    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */ 
		             payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
		             
		         }
		         payr0304Vo.setSuprtFamyNumEtc(payCalculationVo.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
		         payr0304Vo.setChdnSchlExpnAdmclYn(payCalculationVo.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
		         payr0304Vo.setHlthInsrGrde(payCalculationVo.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
		         payr0304Vo.setNatPennGrde(payCalculationVo.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
		         payr0304Vo.setMnthPayDlywagSum(BigDecimal.ZERO);    /** column 월급여일당금액 : mnthPayDlywagSum */
		         
		         payr0304Vo.setAddIncmTxApptnRtoCd(payCalculationVo.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
		         payr0304Vo.setAddIncmTxApptnYrMnth(payCalculationVo.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
		         
		         payr0304Vo.setRepbtyBusinDivCd(payCalculationVo.getRepbtyBusinDivCd()); /* 호봉제구분코드 */
		         
		         InfcPkgPayr0304VO  tpPayr0304Vo = new InfcPkgPayr0304VO();
		         
		         tpPayr0304Vo = payrCommCalcService.selectPayr0304(payr0304Vo); 
		         
		         if (MSFSharedUtils.paramNull(tpPayr0304Vo)) { 
		            
		             payrCommCalcService.insertPayr0304(payr0304Vo);
		             
		         } else {
		             
		             payrCommCalcService.updatePayr0304(payr0304Vo);
		         }
		         
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
     return payr0304Vo;   
         
		
	}

	/**
	 * 
	 * @param request
	 * @param payCalculationVo
	 * @param payr0304Vo
	 * @param sessionUser
	 */
	public String call_funcPayr0500AddIncmTx(HttpServletRequest request, PkgPayrCommCalcVO payCalculationVo,
			InfcPkgPayr0304VO payr0304Vo, MSFSysm0100BM sessionUser) {
	 
		String rtnPayr = "";   
        
        if  (payrCommCalcService == null) { 
              WebApplicationContext wac = WebApplicationContextUtils.
                      getRequiredWebApplicationContext( request.getSession().getServletContext());
  
              payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
             
         }  
        
        if  (payCalculationService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               payCalculationService = (PayCalculationService) wac.getBean("PayCalculationService" ); 
              
        }
        
        try { 
        	
        	
        	
        	 /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
             * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
             $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
            InfcPkgPayr0304VO tpTxPayr0304Vo = new InfcPkgPayr0304VO();  
            
            tpTxPayr0304Vo = payrCommCalcService.selectPayr0304ToAddIncmTx(payr0304Vo);
          
            if (MSFSharedUtils.paramNotNull(tpTxPayr0304Vo)) {
                if (!(MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnRtoCd()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnRtoCd()))
                		&& MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnYrMnth()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth())) 
                		&& "E".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn()))))  {
                
                	if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
                       
                		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0304Vo.getPymtYrMnth()) <= 0) {
                                	
                    		InfcPkgPayr0500VO TxPayr0500Vo = new InfcPkgPayr0500VO(); 
                            TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
                            TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
                            TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
                            
                            payrCommCalcService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
                            //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
                		}   
                	}
                
                } 
           } else {
        	   
        	   if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
                   
           		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0304Vo.getPymtYrMnth()) <= 0) {
                            	
                		InfcPkgPayr0500VO TxPayr0500Vo = new InfcPkgPayr0500VO(); 
                        TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
                        TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
                        TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
                        
                        payrCommCalcService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
                       //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
           		}   
           	}
           } 
             
            
            /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
             * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
             $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
			 
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
     return rtnPayr;   
         	 
		
	}

	public InfcPkgPayr0250VO call_MappingPayr0250(InfcPkgPayr0250VO dtoPayr0250, InfcPkgPayr0250VO payr0250Vo) {
		// TODO Auto-generated method stub
		 //InfcPkgPayr0250VO payr0250Vo = new InfcPkgPayr0250VO();
		 
		 payr0250Vo.setDpobCd(dtoPayr0250.getDpobCd());    /** column 사업장코드 : dpobCd */
         payr0250Vo.setJobYrMnth(dtoPayr0250.getJobYrMnth());    /** column 작업년월 : jobYrMnth */
         payr0250Vo.setPayCd(dtoPayr0250.getPayCd());    /** column 급여구분코드 : payCd */
         payr0250Vo.setPayScduSeilNum(dtoPayr0250.getPayScduSeilNum());    /** column 급여스케줄일련번호 : payScduSeilNum */
         payr0250Vo.setPayrMangDeptCd(dtoPayr0250.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
         
         payr0250Vo.setMangeDeptCd(dtoPayr0250.getMangeDeptCd());    /** column 관리부서코드  mangeDeptCd */
         
         payr0250Vo.setDeptCd(dtoPayr0250.getDeptCd());    /** column 부서코드 : deptCd */
         payr0250Vo.setBusinCd(dtoPayr0250.getBusinCd());    /** column 사업코드 : businCd */
         payr0250Vo.setEmymtDivCd(dtoPayr0250.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
         payr0250Vo.setPernChrgEmpIdenNum(dtoPayr0250.getPernChrgEmpIdenNum());    /** column 담당직원번호 : pernChrgEmpIdenNum */
         payr0250Vo.setJobNm(dtoPayr0250.getJobNm());    /** column 작업명 : jobNm */
         payr0250Vo.setPymtDt(dtoPayr0250.getPymtDt());    /** column 지급일자 : pymtDt */
         payr0250Vo.setRflctnBgnnDt(dtoPayr0250.getRflctnBgnnDt());    /** column 반영시작일자 : rflctnBgnnDt */
         payr0250Vo.setRflctnEndDt(dtoPayr0250.getRflctnEndDt());    /** column 반영종료일자 : rflctnEndDt */
         payr0250Vo.setPayDdlneDt(dtoPayr0250.getPayDdlneDt());    /** column 급여마감일자 : payDdlneDt */
         payr0250Vo.setGroFlCretnDt(dtoPayr0250.getGroFlCretnDt());    /** column 지로파일생성일자 : groFlCretnDt */
         payr0250Vo.setKybdr(dtoPayr0250.getKybdr());    /** column 입력자 : kybdr */
         payr0250Vo.setInptDt(dtoPayr0250.getInptDt());    /** column 입력일자 : inptDt */
         payr0250Vo.setInptAddr(dtoPayr0250.getInptAddr());    /** column 입력주소 : inptAddr */
         payr0250Vo.setIsmt(dtoPayr0250.getIsmt());    /** column 수정자 : ismt */
         payr0250Vo.setRevnDt(dtoPayr0250.getRevnDt());    /** column 수정일자 : revnDt */
         payr0250Vo.setRevnAddr(dtoPayr0250.getRevnAddr());    /** column 수정주소 : revnAddr */
         payr0250Vo.setTypOccuCd(dtoPayr0250.getTypOccuCd());    /** column 직종코드 : typOccuCd */
         //payr0250Vo.setPyspGrdeCd(dtoPayr0250.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */ 
         payr0250Vo.setDtilOccuInttnCd(dtoPayr0250.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */ 
         //사용자선택에 따른 부분 추가 20170628 atres 
         payr0250Vo.setSystemkey(dtoPayr0250.getSystemkey());    /** column systemkey : systemkey */  
         
		return payr0250Vo;
	}
   
	   
	  	 
}