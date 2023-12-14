package com.app.smrmf.pkg.proc.payr.generics;

 
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0300SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0430VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540SrhVO;
import com.app.smrmf.pkg.insr.insurance.PkgInsrController;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrWorkVO;
import com.app.smrmf.pkg.payr.income.tax.PayrTaxController;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;
import com.app.smrmf.pkg.proc.payr.pay.calculation.service.PayCalculationService;
import com.app.smrmf.pkg.proc.payr.pysplogsvcyrnum.PyspLogSvcYrNumService;
import com.app.smrmf.props.ExtermsProps;
/**
 * 각 급여 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class PayrYongInSubProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(PayrYongInSubProcContainer.class);
	  
	private PayrTaxController payrTaxCtl; 
	
	private PkgInsrController pkgInsrCtl; 

	//소득세계 
//	@Autowired
//    @Resource(name = "InComeTaxService")
//    protected InComeTaxService inComeTaxService;
	
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
    
	      
	    
	  	/**
	  	 * 
	  	 * <pre>
	  	 * 1. 개요 : 추가선택된 인원에 따른 급여계산로직 - 급여조정에 따른 수정  
	  	 * 2. 처리내용 : 
	  	 * </pre>
	  	 * @Method Name : execPayr4200ToPayCalcSeft
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
	  	 * @param voPayr0302
	  	 * @return
	  	 * @throws Exception
	  	 */
        public int execPayr4200ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0302VO voPayr0302)  throws Exception  {
             return  funcPayr4200ToPayrCalc(request,voPayr0302  );
        }
        
        /**
         * 
         * <pre>
         * 1. 개요 : 
         * 2. 처리내용 : 
         * </pre>
         * @Method Name : funcPayr4200ToPayrCalc
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
         * @param voPayr0302
         * @return
         * @throws Exception
         */
        private int funcPayr4200ToPayrCalc(HttpServletRequest request,InfcPkgPayr0302VO voPayr0302)  throws Exception  {
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
            
          //소득세계산을 위한 메서드 
            payrTaxCtl = PayrTaxController.getInstance();
            
       	 // 4대 보험 메소드  
            pkgInsrCtl = PkgInsrController.getInstance(); 
                  	    
 
            if  (payCalculationService == null) { 
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( request.getSession().getServletContext());
    
                payCalculationService = (PayCalculationService) wac.getBean("PayCalculationService" ); 
               
           }  
            if  (payrCommCalcService == null) { 
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( request.getSession().getServletContext());
    
                payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
               
           }  
  
            int result = 1;
            InfcPkgPayr0301VO  payr0301Vo = new InfcPkgPayr0301VO();
            InfcPkgPayr0302SrhVO  payr0302SrhVo = new InfcPkgPayr0302SrhVO();
            InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
            InfcPkgPayr0250VO  payr0250Vo = new InfcPkgPayr0250VO();
            PkgPayrCommCalcVO payCalculationVo = new PkgPayrCommCalcVO();
            InfcPkgPayr0540SrhVO payr0540SrhVo = new InfcPkgPayr0540SrhVO();
            
            BigDecimal sumReattyD0150100 = BigDecimal.ZERO; //2016.10.04
            BigDecimal tpStdPymtTotAmnt= BigDecimal.ZERO;   //기본
            //pymtTotAmnt 지급총액
            BigDecimal  tpPymtTotAmnt = BigDecimal.ZERO;
            //extpyTotAmnt 수당총액
            BigDecimal  tpExtpyTotAmnt = BigDecimal.ZERO;
            //txtnTotAmnt 과세총액 
           // BigDecimal  tpTxtnTotAmnt = BigDecimal.ZERO;
            //freeDtyTotAmnt 비과세총액 
            BigDecimal  tpFreeDtyTotAmnt = BigDecimal.ZERO;
            //dducTotAmnt  공제총액 
            BigDecimal  tpDducTotAmnt = BigDecimal.ZERO;
            // 
            
            //4대보험처리 TempVO 객체 
            PkgInsrWorkVO   pkgInsrWorkVo = new PkgInsrWorkVO();
                       

           pkgInsrWorkVo.setTpTxtnTotAmnt(BigDecimal.ZERO); //txtnTotAmnt 과세총액 
           pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);          //건강보험
           pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);     //요양 
           pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);              //국민연금
           pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);        //고용
           pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);               //보수금액
           pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO);        //과세대상금액

             
          //소득세/지방소득세 합계 
            BigDecimal txTotAmnt = BigDecimal.ZERO; 
           
            try {
                
               // if (ExtermsProps.getProps("PAY_CD_01").equals(voPayr0302.getPayCd()) || ExtermsProps.getProps("PAY_CD_03").equals(voPayr0302.getPayCd()) ) { 
                
                        //1. 대상자의 급여 항목 합계 payr0301 업데이트 을 위한 값 가져오기
                         List  listPayr0302ToPayr301 = payCalculationService.selectPayr0302ToPayr301CalcList(voPayr0302);
                        //2. payr301 데이터를 불러와 변경된 사항만 처리  payr0301에 업데이트 하기 
                        for (int iCnt01 = 0;iCnt01 < listPayr0302ToPayr301.size();iCnt01++) {
                            Map tempMap = (Map)listPayr0302ToPayr301.get(iCnt01); 
                          
                            //3. 소득세 주민세 다시 계산 하기...  
                
                            //   payr0250Vo.setPayItemCd(voPayr0302.getPayItemCd());    /** column 급여항목코드 : payItemCd */
                          //  payr0250Vo.setPayItemSeilNum(voPayr0302.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
                          //  payr0250Vo.setPymtDducDivCd(voPayr0302.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
                          //  payr0250Vo.setPymtDducFreeDtySum(voPayr0302.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                           //   payr0250Vo.setPymtDducSum(voPayr0302.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
                            //  payr0250Vo.setPayPymtDducPrcsFlag(voPayr0302.getPayPymtDducPrcsFlag());    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                            // payr0250Vo.setPayReattyAdmntVal(voPayr0302.getPayReattyAdmntVal());    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                            //payr0250Vo.setPymtDducTxtnAmnt(voPayr0302.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
                 
                            payCalculationVo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
                            //payCalculationVo.setPymtYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
                            payCalculationVo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */
                           // payCalculationVo.setPayrSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
                            payCalculationVo.setSystemkey(voPayr0302.getSystemkey());    /** column SYSTEMKEY : systemkey */
                           // payCalculationVo.setPayItemCd(voPayr0302.getPayItemCd());    /** column 급여항목코드 : payItemCd */
                            //payCalculationVo.setPayItemSeilNum(voPayr0302.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
                           // payCalculationVo.setPymtDducDivCd(voPayr0302.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
                           // payCalculationVo.setPymtDducFreeDtySum(voPayr0302.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                           // payCalculationVo.setPymtDducSum(voPayr0302.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
                          //  payCalculationVo.setPayPymtDducPrcsFlag(voPayr0302.getPayPymtDducPrcsFlag());    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                           // payCalculationVo.setPayReattyAdmntVal(voPayr0302.getPayReattyAdmntVal());    /** column 급여지급공제소급조정값 : payReattyAdmntVal */ 
                            //payCalculationVo.setPymtDducTxtnAmnt(voPayr0302.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
                    
                          //소득세주민세 계산을위해 중요    
                            payCalculationVo.setSpueYn(String.valueOf(tempMap.get("spueYn")));    /** column 배우자유무 : spueYn */
                            payCalculationVo.setSuprtFamyNumTwenChDn(new BigDecimal(String.valueOf(tempMap.get("suprtFamyNumTwenChDn"))));    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */ 
                            payCalculationVo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
        //                    if (("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn())) 
        //                             && (payCalculationVo.getSuprtFamyNumTwenChDn().compareTo( new BigDecimal("2")) > 0)) {
        //                        payr0304Vo.setSuprtFamyNumTreOvrChdn(payCalculationVo.getSuprtFamyNumTwenChDn().subtract( new BigDecimal("2")) );    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
        //                        payr0304Vo.setSuprtFamy3ChdnExtpySum(payCalculationVo.getSuprtFamy3ChdnExtpySum());    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
        //                        
        //                    } else  {
        //                        payr0304Vo.setSuprtFamyNumTreOvrChdn(BigDecimal.ZERO);    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */ 
        //                        payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
        //                        
        //                    }
                            payCalculationVo.setSuprtFamyNumEtc(new BigDecimal(String.valueOf(tempMap.get("suprtFamyNumEtc"))));    /** column 부양가족수_기타 : suprtFamyNumEtc */
                           
                            //실근무일수 DILNLAZ_TOT_DUTY_NUM_DYS
                            payCalculationVo.setDilnlazTotDutyNumDys(String.valueOf(tempMap.get("dilnlazTotDutyNumDys")));
                          
                            payCalculationVo.setAddIncmTxApptnRtoCd(String.valueOf(tempMap.get("addIncmTxApptnRtoCd"))); /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
                            payCalculationVo.setAddIncmTxApptnRto(new BigDecimal(String.valueOf(MSFSharedUtils.defaultNulls(tempMap.get("addIncmTxApptnRto"),"0")))); /** set 추가소득세적용비율 : addIncmTxApptnRto */ 
                            payCalculationVo.setAddIncmTxApptnYrMnth(String.valueOf(tempMap.get("addIncmTxApptnYrMnth"))); /** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
                            payCalculationVo.setBusinCd(MSFSharedUtils.allowNulls(tempMap.get("businCd"))); 

                                              
                            payCalculationVo.setHlthInsrApptnYn(MSFSharedUtils.allowNulls(tempMap.get("hlthInsrApptnYn")));
                            payCalculationVo.setNatPennApptnYn(MSFSharedUtils.allowNulls(tempMap.get("natPennApptnYn")));
                            payCalculationVo.setUmytInsrApptnYn(MSFSharedUtils.allowNulls(tempMap.get("umytInsrApptnYn")));
                            payCalculationVo.setIdtlAccdtInsurApptnYn(MSFSharedUtils.allowNulls(tempMap.get("idtlAccdtInsurApptnYn")));
                            payCalculationVo.setHlthInsrMnthRuntnAmnt(new BigDecimal(String.valueOf(MSFSharedUtils.defaultNulls(tempMap.get("hlthInsrMnthRuntnAmnt"),"0"))));
                            payCalculationVo.setNatPennStdIncmMnthAmnt(new BigDecimal(String.valueOf(MSFSharedUtils.defaultNulls(tempMap.get("natPennStdIncmMnthAmnt"),"0"))));
                            payCalculationVo.setUmytInsrPayMnthAmnt(new BigDecimal(String.valueOf(MSFSharedUtils.defaultNulls(tempMap.get("umytInsrPayMnthAmnt"),"0")))); 
                            
                            
                            /************************************************** 급여구분이외의 자료 처리시 임시 적용 ***************************************/
                            // .4대보험처리를 위한 루틴 포함   20171129_공통적용

                            // .4대보험처리를 위한 루틴 포함   
                               payr0250Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
                               payr0250Vo.setJobYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
                               payr0250Vo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */
                               payr0250Vo.setPayScduSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
                               payr0250Vo.setSystemkey(voPayr0302.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                               payr0250Vo.setPymtDt(MSFSharedUtils.allowNulls(tempMap.get("payPymtDt"))); 
                            /************************************************** 급여구분이외의 자료 처리시 임시 적용 ***************************************/
                              
                            
                            
                            /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                             * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
                             $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
                            InfcPkgPayr0304VO payr0304Vo = new InfcPkgPayr0304VO();  
                            InfcPkgPayr0304VO tpTxPayr0304Vo = new InfcPkgPayr0304VO();  
                            
                            payr0304Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
                            payr0304Vo.setPymtYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
                            payr0304Vo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */
                            payr0304Vo.setPayrSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
                            payr0304Vo.setSystemkey(voPayr0302.getSystemkey());    /** column SYSTEMKEY : systemkey */
                            payr0304Vo.setBusinCd(payCalculationVo.getBusinCd());    /** column buninCd */
                            
                            tpTxPayr0304Vo = payrCommCalcService.selectPayr0304ToAddIncmTx(payr0304Vo);
                            
                           if (MSFSharedUtils.paramNotNull(tpTxPayr0304Vo)) {
	                            if (!(MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnRtoCd()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnRtoCd()))
	                            		&& MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnYrMnth()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth())) 
	                            		&& "E".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn()))))  {
	                            
	                            	if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
	                                   
	                            		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(voPayr0302.getPymtYrMnth()) <= 0) {
		                                        	
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
                                   
                           		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(voPayr0302.getPymtYrMnth()) <= 0) {
	                                        	
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
                            
                           pkgInsrWorkVo.setTpWorkIncmTxtnSum( new BigDecimal(String.valueOf(tempMap.get("tpTxtnTotAmnt"))));//과세대상금액
                            //국민연금  
                           // tpNatPennAmt = new BigDecimal(String.valueOf(tempMap.get("sumB002")));
                            
                              
                           // if (tpNatPennAmt.compareTo(BigDecimal.ZERO) <= 0) {
                           //       payCalculationVo.setNatPennApptnYn("N");
                           // } else {
                           //       payCalculationVo.setNatPennApptnYn("Y");
                           // } 
                               
                            //pymtTotAmnt 지급총액
                              tpPymtTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpPymtTotAmnt")));
                            //extpyTotAmnt 수당총액
                              tpExtpyTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpExtpyTotAmnt")));
                            //txtnTotAmnt 과세총액 
                              pkgInsrWorkVo.setTpTxtnTotAmnt(new BigDecimal(String.valueOf(tempMap.get("tpTxtnTotAmnt"))));
                            //freeDtyTotAmnt 비과세총액 
                              tpFreeDtyTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpFreeDtyTotAmnt")));
                            //dducTotAmnt  공제총액 
                              tpDducTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpDducTotAmnt")));
                            //과세대상금액  
                  	        pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt));
                              /** 월급여일경우 처리 및 아닌경우처리를 위한 루틴   */
              				if(ExtermsProps.getProps("PAY_CD_01").equals(payCalculationVo.getPayCd())) {
                              /******************************************************************************************
                               * 4대보험 처리 
                               * AA.SUM_D0010100,    //건강보험
 				                 AA.SUM_D0110100,    //장기요양
 				                 AA.SUM_D0150100,    //국민연금
 				                 AA.SUM_D0160100,    //고용보험 
 				                //2016.10.04 sumReattyD0150100   //국민연금 조정값....
                               *****************************************************************************************/
                              /******************************************************************************************
                               * 4대보험 관련 공제 금액에서 빼기 다시 계산 후 저장 처리 한다. 
                               *****************************************************************************************/
                              BigDecimal sumD0010100 = new BigDecimal(String.valueOf(tempMap.get("sumD0010100")));
                              BigDecimal sumD0110100 = new BigDecimal(String.valueOf(tempMap.get("sumD0110100")));
                              BigDecimal sumD0150100 = new BigDecimal(String.valueOf(tempMap.get("sumD0150100")));
                              sumReattyD0150100 = new BigDecimal(String.valueOf(tempMap.get("sumReattyD0150100"))); //2016.10.04
                              BigDecimal sumD0160100 = new BigDecimal(String.valueOf(tempMap.get("sumD0160100")));
                              
                              //국민연금 소득세 처리 조정으로 들어온 데이터 값가지고 오기
                             
                              tpDducTotAmnt =  tpDducTotAmnt.subtract((sumD0010100.add(sumD0110100.add(sumD0150100.add(sumD0160100))))); 
                              
                              /*########################################################################################*/
                              /**  4대보험 처리 로직  추가  - 현재 값을 넘기는 부분 추가함. 값을 처리 할지 여부 판단                                                                                                                                                                                              **/
                              /*########################################################################################*/ 
                             
                              /************************************20170725  4대보험정리작업전 모듈추가  ******************************/
                              
                               pkgInsrWorkVo.setSumChkD0010100(String.valueOf(tempMap.get("sumChkD0010100")));   //건강보험
                               pkgInsrWorkVo.setSumChkD0110100(String.valueOf(tempMap.get("sumChkD0110100")));   //건강요양보험
                               
                               pkgInsrWorkVo.setSumChkD0150100(String.valueOf(tempMap.get("sumChkD0150100")));   //국민연금  
                               pkgInsrWorkVo.setSumChkD0160100(String.valueOf(tempMap.get("sumChkD0160100")));   //고용보험  
                               //건강보험 
	           		           pkgInsrWorkVo.setTpHlthInsrPayAmt(sumD0010100);
	           		           //요양 
	           		           pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(sumD0110100);
	           		           //국민연금  
	           		           pkgInsrWorkVo.setTpNatPennAmt(sumD0150100);
	           		           //고용 
	           		           pkgInsrWorkVo.setTpUmytInsrApptnAmt(sumD0160100);
	           		         /************************************20170725  4대보험정리작업전 모듈추가  ******************************/   
                              
                              
                                
              		        //과세대상금액  
                    	        pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt));
                    	        //공제금액합계
                    	      //  pkgInsrWorkVo.setTpDducTotAmnt(tpDducTotAmnt);
                    	        //기본금액 
                    	      // pkgInsrWorkVo.setTpStdPymtTotAmnt(tpStdPymtTotAmnt);
                    	       pkgInsrWorkVo.setTpStdPymtTotAmnt(new BigDecimal(String.valueOf(tempMap.get("sumB001"))));
             		           pkgInsrWorkVo.setTpPymtAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt));  //보수금액 
             		            
                    	        
                    	        pkgInsrWorkVo = pkgInsrCtl.func4InsureModService(request , payCalculationVo ,  payr0250Vo  , pkgInsrWorkVo,sumReattyD0150100);
                    	         
                    	        //공제금액 - 4대보험 합계포함 
                    	         tpDducTotAmnt = tpDducTotAmnt.add(pkgInsrWorkVo.getTpDducTotAmnt());
                    	                                                             	        
                    	        /*########################################################################################*/
                                /**  4대보험 처리 로직  종료                                                                            	  **/
                                /*########################################################################################*/  
                               
                    	         pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgInsrWorkVo.getTpTxtnTotAmnt());                                  
                                 pkgInsrWorkVo.setTpWorkIncmTxtnSum(new BigDecimal(String.valueOf(tempMap.get("tpTxtnTotAmnt"))));//과세대상금액
                                 
                                 
                           if ("Y".equals(String.valueOf(tempMap.get("payrIncmExceYn")))) {
                           	 //소득세 제외
                          	  txTotAmnt = BigDecimal.ZERO;
                          	  
                          	  //소득세   
                              payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                              payr0302Vo.setPayItemCd("T0010100");
                              payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                              payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                              payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                              payr0302Vo.setPymtDducSum(txTotAmnt);
                              payr0302Vo.setPayPymtDducPrcsFlag("N");
                              payr0302Vo.setPayReattyAdmntVal("0");
                              payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                            payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                            payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                            payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                            payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                            payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                            payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                              payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                              
                              payrCommCalcService.insertPayr0302(payr0302Vo);
                              
                              
                              //지방소득세   
                              payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                              payr0302Vo.setPayItemCd("T0020100");
                              payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                              payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                              payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                              payr0302Vo.setPymtDducSum(txTotAmnt);
                              payr0302Vo.setPayPymtDducPrcsFlag("N");
                              payr0302Vo.setPayReattyAdmntVal("0");
                              payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                            payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                            payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                            payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                            payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                            payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                            payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                              payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                              
                              payrCommCalcService.insertPayr0302(payr0302Vo);  
                              
                           } else if ( ExtermsProps.getProps("PAY_DDUC_T00101").equals(voPayr0302.getPayr4200DducCheck())) {
                           	/**************************************************************************
                           	 * 소득세 수동입력시 처리 해야 하는 부분 추가 20170720  
                           	 **************************************************************************/
                           	 txTotAmnt = BigDecimal.ZERO;
                           	 InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
                           	  // 등록된 소득세 주민세를 가지고 와서 payr0305에저장하는 루틴    
                           	 payr0305Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
                           	 payr0305Vo.setPymtYrMnth(voPayr0302.getPymtYrMnth());     /** column 지급년월 : pymtYrMnth */             
                           	 payr0305Vo.setPayCd(voPayr0302.getPayCd());       /** column 급여구분코드 : payCd */               
                           	 payr0305Vo.setSystemkey(voPayr0302.getSystemkey());     /** column 급여일련번호 : payrSeilNum */            
                           	 payr0305Vo.setPayrSeilNum(voPayr0302.getPayrSeilNum());   /** column SYSTEMKEY : systemkey */   
	                              
	                               payr0305Vo = payCalculationService.selectPayr0302T0010100(payr0305Vo);
	                              
	                              if (MSFSharedUtils.paramNotNull(payr0305Vo) && MSFSharedUtils.paramNotNull(payr0305Vo.getSystemkey())
	                            		  && (payr0305Vo.getMnlTxtbSimfTxs().compareTo(BigDecimal.ZERO) != 0)) {
	                            	  
		                              InfcPkgPayr0305VO  inPayr0305Vo = new InfcPkgPayr0305VO();
		                            //근로소득간이세액표산출값 
		                              inPayr0305Vo.setDpobCd(payr0305Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
		                              inPayr0305Vo.setPymtYrMnth(payr0305Vo.getPymtYrMnth());                 
		                              inPayr0305Vo.setPayCd(payr0305Vo.getPayCd());                      
		                              inPayr0305Vo.setSystemkey(payr0305Vo.getSystemkey());               
		                              inPayr0305Vo.setPayrSeilNum(payr0305Vo.getPayrSeilNum());                
		                              inPayr0305Vo.setMnlTxtbSimfTxs(payr0305Vo.getMnlTxtbSimfTxs());    /** column 수동소득세 : mnlTxtbSimfTxs */
		                              inPayr0305Vo.setMnlLocTxAmt(payr0305Vo.getMnlLocTxAmt());    /** column 수동지방소득세 : mnlLocTxAmt */
		                              inPayr0305Vo.setMnlTxtbSimfYn("Y");    /** column 수동소득세여부 : mnlTxtbSimfYn */
		                              inPayr0305Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//		      	                  inPayr0305Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
		                              inPayr0305Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
		                              inPayr0305Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//		      	                  inPayr0305Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
		                              inPayr0305Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
		                          
		                              payrCommCalcService.updatePayr0302ToPayr0305(inPayr0305Vo);   
		                              
		                              txTotAmnt = payr0305Vo.getMnlTxtbSimfTxs().add(payr0305Vo.getMnlLocTxAmt());
		                              
	                               } else {
	                            	   //소득세   
	 	                              payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	 	                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
	 	                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
	 	                              payr0302Vo.setPayItemCd("T0010100");
	 	                              payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
	 	                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
	 	                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
	 	                              payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
	 	                              payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
	 	                              payr0302Vo.setPymtDducSum(txTotAmnt);
	 	                              payr0302Vo.setPayPymtDducPrcsFlag("N");
	 	                              payr0302Vo.setPayReattyAdmntVal("0");
	 	                              payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
	 	                              payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//	 	        	                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
	 	        	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	 	        	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//	 	        	                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
	 	        	                  payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */  
	 	                              payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
	 	                              
	 	                              payrCommCalcService.insertPayr0302(payr0302Vo); 
	 	                              
	 	                              //지방소득세   
	 	                              payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	 	                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
	 	                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
	 	                              payr0302Vo.setPayItemCd("T0020100");
	 	                              payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
	 	                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
	 	                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
	 	                              payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
	 	                              payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
	 	                              payr0302Vo.setPymtDducSum(txTotAmnt);
	 	                              payr0302Vo.setPayPymtDducPrcsFlag("N");
	 	                              payr0302Vo.setPayReattyAdmntVal("0");
	 	                              payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
	 	                              payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//	 	        	                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
	 	        	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	 	        	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//	 	        	                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
	 	        	                  payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
	 	                              payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
	 	                              
	 	                              payrCommCalcService.insertPayr0302(payr0302Vo);  
	                            	   
	                               }   
	                             } else {    
	                            	 InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
                                	  // 등록된 소득세 주민세를 가지고 와서 payr0305에저장하는 루틴    
                                	 payr0305Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
                                	 payr0305Vo.setPymtYrMnth(voPayr0302.getPymtYrMnth());     /** column 지급년월 : pymtYrMnth */             
                                	 payr0305Vo.setPayCd(voPayr0302.getPayCd());       /** column 급여구분코드 : payCd */               
                                	 payr0305Vo.setSystemkey(voPayr0302.getSystemkey());     /** column 급여일련번호 : payrSeilNum */            
                                	 payr0305Vo.setPayrSeilNum(voPayr0302.getPayrSeilNum());   /** column SYSTEMKEY : systemkey */   
     	                              
     	                               payr0305Vo = payCalculationService.selectPayr0302T0010100(payr0305Vo);
     	                              
     	                                 if (MSFSharedUtils.paramNotNull(payr0305Vo) && MSFSharedUtils.paramNotNull(payr0305Vo.getSystemkey())
     	                            		  && ("Y".equals(payr0305Vo.getMnlTxtbSimfYn()))) { 
     	                                	 //소득세   
	      	                            	  txTotAmnt = payr0305Vo.getMnlTxtbSimfTxs().add(payr0305Vo.getMnlLocTxAmt()); 
     	                               
     	                                } else {

				                              //일용직인경우 소득세 주민세 계산 루틴을 다르게 적용해야 함.......
				                              if ("Y".equals(String.valueOf(tempMap.get("dayWorkYn")))) {
				                                  /***********************************************************************************/
				                                  //일용직로직 추가 부분 ......
				                                  /***********************************************************************************/
				                                  //소득세/지방소득세  
				                                  txTotAmnt = payrTaxCtl.getFuncWorkDayIncmTxtn(request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());  
				                                  
				                              } else {
				                            	  
				                            	  if ("201506".compareTo(payr0250Vo.getJobYrMnth()) >= 0) {
				                            		  //소득세/지방소득세  
				                                       txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());
				                            	    
                                          	      } else if ("201701".compareTo(payr0250Vo.getJobYrMnth()) >= 0) {
                                          	    	 //소득세/지방소득세  
				                                       txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn2015( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());
				                            	   
                                               	   } else {
	                                               		//20170203일자 소득세법 계정으로 변경된 계산 법 적용    
	                                               		//소득세/지방소득세   
                                  						txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn2017( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());
                                         		   	//	 pkgPayrAmntVo.setTxTotAmnt(payrTaxCtl.getFuncWorkIncmTxtn2017( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt()));
	                                               	   
	                                              } 
				                            	     
				                              }
	      	                            	
	      	                            	   
	      	                               }              
	                             }

                           // 급여구분의 월급여가 아닐 때	
            				}else { 
            				 
            				    txTotAmnt = BigDecimal.ZERO; 
            					
            				} 
                            payr0301Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */  
                            payr0301Vo.setPymtYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
                            payr0301Vo.setSystemkey(voPayr0302.getSystemkey());    
                            payr0301Vo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */        
                            payr0301Vo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
                            payr0301Vo.setPayrSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
                            payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
                            payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
                            payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
                            payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
                            payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
                            payr0301Vo.setTxTotAmnt(txTotAmnt);      
                            payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
                           // payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
                           // payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
                           // payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
                           // payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
                           // payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
                           // payr0301Vo.setPayDdlneDt("");    
                           // payr0301Vo.setPayDdlneYn("N");   
                            
                            payrCommCalcService.updatePayr0301ToPayr0307(payr0301Vo); //월급여내역   
                            
                           
                        } 
              //  }
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                result = 0;
            }       
            
            return result;
        }
	  	  
      
	   /**
	    * 
	    * <pre>
	    * 1. 개요 :  직종세 근속년수 맵핑.
	    * 2. 처리내용 : 
	    * </pre>
	    * @Method Name : createPyspLogSvcYrNumCd
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
	    * @param payr0400Vo
	    * @return
	    * @throws Exception
	    */
        public int createPyspLogSvcYrNumCd(HttpServletRequest request,InfcPkgPayr0400VO payr0400Vo)  throws Exception  {
            int result = 1;
             
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
            
         if  (pyspLogSvcYrNumService == null) { 
             WebApplicationContext wac = WebApplicationContextUtils.
                     getRequiredWebApplicationContext( request.getSession().getServletContext()); 
            
             pyspLogSvcYrNumService = (PyspLogSvcYrNumService) wac.getBean("PyspLogSvcYrNumService"); 
         }
            
         //근속년수 맵핑 로직 구현 하기 
         /*
          * 1. 근속녀수 코드 리스트를 가지고 와서 구간 별로 직종세와 맵핑을 한다.
          * 2. 맵핑된 데이터를 인서트 한다.
          */
         
         InfcPkgPayr0430VO  payr0430Vo = new InfcPkgPayr0430VO();
         InfcPkgBass0300SrhVO searchVO  = new InfcPkgBass0300SrhVO(); 
       
         try {
         
         searchVO.setDpobCd(payr0400Vo.getDpobCd());  
         searchVO.setRpsttvCd("A007"); 
         searchVO.setCommCd(payr0400Vo.getCommCd());
         
         List list = pyspLogSvcYrNumService.selectBass0300List(searchVO);
         
         Iterator<Map<String, Object>> iter = list.iterator();
          
         while ( iter.hasNext() ) {
             
             Map<String, Object> map = (Map<String, Object>) iter.next();
              
             /** DPOB_CD */
             payr0430Vo.setDpobCd(payr0400Vo.getDpobCd());
             
             payr0430Vo.setTypOccuGrdeMppgSeilNum(payr0400Vo.getTypOccuGrdeMppgSeilNum());
             /** TYP_OCCU_CD */
             payr0430Vo.setTypOccuCd(payr0400Vo.getTypOccuCd());
             
             /** PYSP_GRDE_CD */
             payr0430Vo.setPyspGrdeCd(payr0400Vo.getPyspGrdeCd());
             
             /** DTIL_OCCU_CLS_DIV_CD */
             payr0430Vo.setDtilOccuInttnCd(payr0400Vo.getDtilOccuInttnCd()); 
               
             /** PYSP_LOG_SVC_YR_NUM_CD */
             payr0430Vo.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(map.get("commCd"))); 
          
             /** LOG_SVC_YR_NUM_OVR */
             payr0430Vo.setLogSvcYrNumOvr(new BigDecimal(MSFSharedUtils.defaultNulls(map.get("mangeItem11"),"0"))); 
             /** LOG_SVC_YR_NUM_UDR */
             payr0430Vo.setLogSvcYrNumUdr(new BigDecimal(MSFSharedUtils.defaultNulls(map.get("mangeItem12"),"0"))); 
             payr0430Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
             payr0430Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
             payr0430Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
             payr0430Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
              
             
             pyspLogSvcYrNumService.insertPayr0430(payr0430Vo);
            
             
         }
            
          } catch (Exception ex) {
             
             result = 0;
             
           }
         
            return result; 
        }
	 

}