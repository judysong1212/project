/**
 * 거제 급여로직 구현부 
 */
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
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
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
import com.app.smrmf.utils.PayrPkgUtil;
/**
 * 각 급여 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class PayrGeoJeSubProcContainer  extends AbstractCustomServiceImpl {
		 

	private static final Logger logger = LoggerFactory.getLogger(PayrGeoJeSubProcContainer.class);
	
	private PayrTaxController payrTaxCtl; 
	private PkgInsrController pkgInsrCtl; 
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
      
	  	
	    //추가선택된 인원에 따른 급여계산로직 - 급여조정에 따른 수정 
        public int execPayr4200ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0302VO voPayr0302)  throws Exception  {
             return  funcPayr4200ToPayrCalc(request,voPayr0302  );
        }
        
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
            
            //4대보험처리 TempVO 객체 
            PkgInsrWorkVO   pkgInsrWorkVo = new PkgInsrWorkVO();
            
           // BigDecimal tpWorkIncmTxtnSum =  BigDecimal.ZERO;//과세대상금액
            //국민연금  
            //BigDecimal tpNatPennAmt = BigDecimal.ZERO;
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
            BigDecimal  ucstSumD9500400 = BigDecimal.ZERO;  //노조회비 공제 대상 수당 합계
            //건강보험 
          //  BigDecimal tpHlthInsrPayAmt = BigDecimal.ZERO;
            //요양 
           // BigDecimal tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;
             //국민연금  
          //  BigDecimal tpNatPennAmt = BigDecimal.ZERO;
            //고용 
          //  BigDecimal tpUmytInsrApptnAmt = BigDecimal.ZERO;
            
            //보수금액 
           // BigDecimal tpPymtAmnt =  BigDecimal.ZERO;
            pkgInsrWorkVo.setTpTxtnTotAmnt(BigDecimal.ZERO); //txtnTotAmnt 과세총액  
            pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);          //건강보험
            pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);     //요양 
            pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);              //국민연금
            pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);        //고용
            pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);               //보수금액
            pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO);        //과세대상금액
                                               
            /**
             * WHERE DPOB_CD = ' '
            AND   PYMT_YR_MNTH = '201501'
            AND   PAY_CD = 'B0150000' 
            AND   PAYR_SEIL_NUM = 6
            AND SYSTEMKEY = '19910001'
             */
          //소득세/지방소득세 합계 
            BigDecimal txTotAmnt = BigDecimal.ZERO; 
           
            try {
                
             //   if (ExtermsProps.getProps("PAY_CD_01").equals(voPayr0302.getPayCd()) || ExtermsProps.getProps("PAY_CD_03").equals(voPayr0302.getPayCd()) ) { 
                
                        //1. 대상자의 급여 항목 합계 payr0301 업데이트 을 위한 값 가져오기
                         List  listPayr0302ToPayr301 = payCalculationService.selectPayr0302ToPayr301CalcList(voPayr0302);
                        //2. payr301 데이터를 불러와 변경된 사항만 처리  payr0301에 업데이트 하기 
                        for (int iCnt01 = 0;iCnt01 < listPayr0302ToPayr301.size();iCnt01++) {
                            Map tempMap = (Map)listPayr0302ToPayr301.get(iCnt01); 
                          
                        
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
                             payCalculationVo.setTypOccuCd(MSFSharedUtils.allowNulls(tempMap.get("typOccuCd")));    /** column 직종 : typOccuCd */
                            payCalculationVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(tempMap.get("dtilOccuInttnCd")));     /** column 직종세통합코드 : dtilOccuInttnCd */
                            payCalculationVo.setEmymtDivCd(MSFSharedUtils.allowNulls(tempMap.get("emymtDivCd")));     /** column 고용구분  : EMYMT_DIV_CD */
                            payCalculationVo.setUnnMbspSttYn(MSFSharedUtils.defaultNulls(tempMap.get("unnMbspSttYn"),"N"));
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
                            
                           pkgInsrWorkVo.setTpWorkIncmTxtnSum(new BigDecimal(String.valueOf(tempMap.get("tpTxtnTotAmnt"))));//과세대상금액
                            //국민연금  
                           // tpNatPennAmt = new BigDecimal(String.valueOf(tempMap.get("sumB002")));
                            
                              
                           // if (tpNatPennAmt.compareTo(BigDecimal.ZERO) <= 0) {
                            //      payCalculationVo.setNatPennApptnYn("N");
                            //} else {
                            //      payCalculationVo.setNatPennApptnYn("Y");
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
                               *****************************************************************************************/
                              /******************************************************************************************
                               * 4대보험 관련 공제 금액에서 빼기 다시 계산 후 저장 처리 한다. 
                               *****************************************************************************************/
                              BigDecimal sumD0010100 = new BigDecimal(String.valueOf(tempMap.get("sumD0010100")));
                              BigDecimal sumD0110100 = new BigDecimal(String.valueOf(tempMap.get("sumD0110100")));
                              BigDecimal sumD0150100 = new BigDecimal(String.valueOf(tempMap.get("sumD0150100")));
                              sumReattyD0150100 = new BigDecimal(String.valueOf(tempMap.get("sumReattyD0150100"))); //2016.10.04
                              BigDecimal sumD0160100 = new BigDecimal(String.valueOf(tempMap.get("sumD0160100")));
                             
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
                    	       // pkgInsrWorkVo.setTpDducTotAmnt(tpDducTotAmnt);
                    	        //기본금액 
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
//      		      	                  inPayr0305Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
      		                              inPayr0305Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
      		                              inPayr0305Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//      		      	                  inPayr0305Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
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
//      	 	        	                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
      	 	        	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
      	 	        	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//      	 	        	                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
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
//      	 	        	                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
      	 	        	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
      	 	        	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//      	 	        	                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
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
	                                               	   
	                                              }  
				                            	  
				                              }
     	                            	 
     	                            	   
     	                               }        
		                            }
                                 
                                 // 급여구분의 월급여가 아닐 때	
                  				}else { 
                  				 
                  				    txTotAmnt = BigDecimal.ZERO; 
                  					
                  				}          
                           /**===============================================================================================
                            *  지급 금액 가지고 처리 하는 부분처리를 위해 추가 
                            *  노조회비 재계산 처리를 위한 루틴 추가 20170530 
                            ================================================================================================*/
                           BigDecimal tpPernPymtSum = BigDecimal.ZERO;   //지급금액 
                           BigDecimal tpPernSubPymtSum = BigDecimal.ZERO; //차인지급금액 
                           BigDecimal tpDducAmntsumB001 = BigDecimal.ZERO;  //기본금액
                           /**\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*/
                           //노조회비 처리를위한 대상금액만 가져오기
                           /**\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*/
                          //ucstSumD9500400 노조회비 공제 대상금액UCST_SUM_D9500400
                           ucstSumD9500400 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ucstSumD9500400"),"0"));
                           tpDducAmntsumB001 = new BigDecimal(String.valueOf(tempMap.get("sumB001")));
  
                           /***********************************************************************************/
                           //이전자료 값 삭제 하기 노조회비 
                           /***********************************************************************************/
                           BigDecimal sumD9500400  = new BigDecimal(String.valueOf(tempMap.get("sumD9500400")));
                           tpDducTotAmnt =  tpDducTotAmnt.subtract(sumD9500400); 
                           /***********************************************************************************/
                           //이전자료 값 삭제 하기 노조회비 
                           /***********************************************************************************/
                           //지급공제항목에서 데이타 가져오기 
                           InfcPkgPayr0410VO payr0410 = new InfcPkgPayr0410VO();
                           
                           payr0410.setDpobCd(payCalculationVo.getDpobCd());    /** column 사업장코드 : dpobCd */
                           payr0410.setPymtYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
                           payr0410.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */ 
                           payr0410.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                           payr0410.setTypOccuCd(payCalculationVo.getTypOccuCd());    /** column 직종 : typOccuCd */
                           payr0410.setDtilOccuInttnCd(payCalculationVo.getDtilOccuInttnCd());     /** column 직종세통합코드 : dtilOccuInttnCd */ 
                           payr0410.setPayrImcd("D9500400"); //급여항목코드  //노조회비 데이타 가져오기 
                           
                           payr0410 = payrCommCalcService.selectPayr0410ToPayrCalcList(payr0410);  

                           tpPernPymtSum = (tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt))));
                           
                           /*
                           WHERE DPOB_CD=#dpobCd#
   								AND PAY_YR=#payYr#
   								AND TYP_OCCU_GRDE_MPPG_SEIL_NUM=#typOccuGrdeMppgSeilNum#
   								AND PAYR_IMCD = #payrImcd#
                            */
                           if (MSFSharedUtils.paramNotNull(payr0410)) {
	                           if (PayrPkgUtil.funcMonthCheck(payr0250Vo, payr0410, null)) {  
	                        	   
	                        	   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                               payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
	                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                               payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                               payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                               payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
	                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                               payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                               payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	        	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	        	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	        	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
	        	                     

                                   BigDecimal dducSumRate = (payr0410.getPymtDducRate());
                                   BigDecimal dducSum = BigDecimal.ZERO;
                                   
                                   dducSum = (tpDducAmntsumB001.add(ucstSumD9500400)).multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
                                   payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */ 
                                   
                                  if ( payr0410.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn())) {
	                               	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
	
	                               		   	 payrCommCalcService.deletePayr0302Payr0307(payr0302Vo); 
	                               		     payrCommCalcService.insertPayr0302(payr0302Vo);  
	                               		     tpPernSubPymtSum = tpPernPymtSum.subtract(dducSum);  
	                                         tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
	                               	   }  
	                               	   
                                  }   
	                        	   
	                           } else {
	                        	   
	                        	   tpPernSubPymtSum = tpPernPymtSum;
	                           }
                           } else {
                        	   tpPernSubPymtSum = tpPernPymtSum; 
                           } 
                            
                           /**===============================================================================================
                             *  지급 금액 가지고 처리 하는 부분처리를 위해 추가 
                             *   
                             ================================================================================================*/                                 
 

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
                           payr0301Vo.setPernPymtSum(tpPernSubPymtSum);   
                          // payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
                          // payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
                          // payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
                          // payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
                          // payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
                          // payr0301Vo.setPayDdlneDt("");    
                          // payr0301Vo.setPayDdlneYn("N");   
                           payr0301Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
                           payr0301Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                         
                            
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
	  	 * 직종세 근속년수 맵핑.
	  	 * @param request
	  	 * @param payr0400Vo
	  	 * @return
	  	 * @throws Exception
	  	 */
        public int createPyspLogSvcYrNumCd(HttpServletRequest request,InfcPkgPayr0400VO payr0400Vo)  throws Exception  {
            int result = 1;
             
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
             
             pyspLogSvcYrNumService.insertPayr0430(payr0430Vo);
            
             
         }
            
          } catch (Exception ex) {
             
             result = 0;
             
           }
         
            return result; 
        }
	  	
 
//
//		private static final Logger logger = LoggerFactory.getLogger(PayrGeoJeProcContainer.class);
//		
//
//		private PayrTaxController payrTaxCtl; 
//		private PkgInsrController pkgInsrCtl; 
//		//급여계산  
//		@Autowired
//	    @Resource(name = "PayCalculationService")
//	    protected PayCalculationService payrCommCalcService;
//		
//		
//		 //근속년수 
//	    @Autowired
//	    @Resource(name = "PyspLogSvcYrNumService")
//	    protected PyspLogSvcYrNumService pyspLogSvcYrNumService; 
//	    
//		  //스케줄링에 따른 급여계산 로직
//		  	public PagingLoadResult<ShowMessageBM> execPayr4100ToPayCalculation(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250)  throws Exception  {
//		  	    
//		  	  return  funcPayr4100ToPayrCalc(request,dtoPayr0250,null );
//		  	}
//		  	
//		  	//추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
//		  	public PagingLoadResult<ShowMessageBM>  execPayr4100ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250,InfcPkgPsnl0100VO voPsnl0100)  throws Exception  {
//		  	     return  funcPayr4100ToPayrCalc(request,dtoPayr0250,voPsnl0100 );
//		  	}
//		  	
//		    //추가선택된 인원에 따른 급여계산로직 - 급여조정에 따른 수정 
//	        public int execPayr4200ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0302VO voPayr0302)  throws Exception  {
//	             return  funcPayr4200ToPayrCalc(request,voPayr0302  );
//	        }
//	        
//	        private int funcPayr4200ToPayrCalc(HttpServletRequest request,InfcPkgPayr0302VO voPayr0302)  throws Exception  {
//	            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//	            
//				//소득세계산을 위한 메서드 
//	            payrTaxCtl = PayrTaxController.getInstance();
//				    
//	             // 4대 보험 메소드  
//    pkgInsrCtl = PkgInsrController.getInstance(); 
//	            if  (payCalculationService == null) { 
//	                WebApplicationContext wac = WebApplicationContextUtils.
//	                        getRequiredWebApplicationContext( request.getSession().getServletContext());
//	    
//	                payCalculationService = (PayCalculationService) wac.getBean("PayCalculationService" ); 
//	               
//	           }  
//	            
//	            int result = 1;
//	            InfcPkgPayr0301VO  payr0301Vo = new InfcPkgPayr0301VO();
//	            InfcPkgPayr0302SrhVO  payr0302SrhVo = new InfcPkgPayr0302SrhVO();
//	            InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
//	            InfcPkgPayr0250VO  payr0250Vo = new InfcPkgPayr0250VO();
//	            PkgPayrCommCalcVO payCalculationVo = new PkgPayrCommCalcVO();
//	            
//	            BigDecimal tpWorkIncmTxtnSum =  BigDecimal.ZERO;//과세대상금액
//	            //국민연금  
//	            BigDecimal tpNatPennAmt = BigDecimal.ZERO;
//	            BigDecimal tpStdPymtTotAmnt= BigDecimal.ZERO;   //기본
//	            //pymtTotAmnt 지급총액
//	            BigDecimal  tpPymtTotAmnt = BigDecimal.ZERO;
//	            //extpyTotAmnt 수당총액
//	            BigDecimal  tpExtpyTotAmnt = BigDecimal.ZERO;
//	            //txtnTotAmnt 과세총액 
//	            BigDecimal  tpTxtnTotAmnt = BigDecimal.ZERO;
//	            //freeDtyTotAmnt 비과세총액 
//	            BigDecimal  tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	            //dducTotAmnt  공제총액 
//	            BigDecimal  tpDducTotAmnt = BigDecimal.ZERO;
//	            // 
//	            /**
//	             * WHERE DPOB_CD = ' '
//	            AND   PYMT_YR_MNTH = '201501'
//	            AND   PAY_CD = 'B0150000' 
//	            AND   PAYR_SEIL_NUM = 6
//	            AND SYSTEMKEY = '19910001'
//	             */
//	          //소득세/지방소득세 합계 
//	            BigDecimal txTotAmnt = BigDecimal.ZERO; 
//	           
//	            try {
//	                
//	                if (ExtermsProps.getProps("PAY_CD_01").equals(voPayr0302.getPayCd()) || ExtermsProps.getProps("PAY_CD_03").equals(voPayr0302.getPayCd()) ) { 
//	                
//	                        //1. 대상자의 급여 항목 합계 payr0301 업데이트 을 위한 값 가져오기
//	                         List  listPayr0302ToPayr301 = payCalculationService.selectPayr0302ToPayr301CalcList(voPayr0302);
//	                        //2. payr301 데이터를 불러와 변경된 사항만 처리  payr0301에 업데이트 하기 
//	                        for (int iCnt01 = 0;iCnt01 < listPayr0302ToPayr301.size();iCnt01++) {
//	                            Map tempMap = (Map)listPayr0302ToPayr301.get(iCnt01); 
//	                          
//	                            //3. 소득세 주민세 다시 계산 하기...  
//	                            payr0250Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                            payr0250Vo.setJobYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                            payr0250Vo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */
//	                            payr0250Vo.setPayScduSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                            payr0250Vo.setSystemkey(voPayr0302.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                         //   payr0250Vo.setPayItemCd(voPayr0302.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//	                          //  payr0250Vo.setPayItemSeilNum(voPayr0302.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
//	                          //  payr0250Vo.setPymtDducDivCd(voPayr0302.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//	                          //  payr0250Vo.setPymtDducFreeDtySum(voPayr0302.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                           //   payr0250Vo.setPymtDducSum(voPayr0302.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
//	                            //  payr0250Vo.setPayPymtDducPrcsFlag(voPayr0302.getPayPymtDducPrcsFlag());    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                            // payr0250Vo.setPayReattyAdmntVal(voPayr0302.getPayReattyAdmntVal());    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                            //payr0250Vo.setPymtDducTxtnAmnt(voPayr0302.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//	                 
//	                            payCalculationVo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                            //payCalculationVo.setPymtYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                            payCalculationVo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */
//	                           // payCalculationVo.setPayrSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                            payCalculationVo.setSystemkey(voPayr0302.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                           // payCalculationVo.setPayItemCd(voPayr0302.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//	                            //payCalculationVo.setPayItemSeilNum(voPayr0302.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
//	                           // payCalculationVo.setPymtDducDivCd(voPayr0302.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//	                           // payCalculationVo.setPymtDducFreeDtySum(voPayr0302.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                           // payCalculationVo.setPymtDducSum(voPayr0302.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
//	                          //  payCalculationVo.setPayPymtDducPrcsFlag(voPayr0302.getPayPymtDducPrcsFlag());    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                           // payCalculationVo.setPayReattyAdmntVal(voPayr0302.getPayReattyAdmntVal());    /** column 급여지급공제소급조정값 : payReattyAdmntVal */ 
//	                            //payCalculationVo.setPymtDducTxtnAmnt(voPayr0302.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//	                    
//	                           //소득세주민세 계산을위해 중요    
//	                            payCalculationVo.setSpueYn(String.valueOf(tempMap.get("spueYn")));    /** column 배우자유무 : spueYn */
//	                            payCalculationVo.setSuprtFamyNumTwenChDn(new BigDecimal(String.valueOf(tempMap.get("suprtFamyNumTwenChDn"))));    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */ 
//	                            payCalculationVo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//	        //                    if (("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn())) 
//	        //                             && (payCalculationVo.getSuprtFamyNumTwenChDn().compareTo( new BigDecimal("2")) > 0)) {
//	        //                        payr0304Vo.setSuprtFamyNumTreOvrChdn(payCalculationVo.getSuprtFamyNumTwenChDn().subtract( new BigDecimal("2")) );    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
//	        //                        payr0304Vo.setSuprtFamy3ChdnExtpySum(payCalculationVo.getSuprtFamy3ChdnExtpySum());    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//	        //                        
//	        //                    } else  {
//	        //                        payr0304Vo.setSuprtFamyNumTreOvrChdn(BigDecimal.ZERO);    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */ 
//	        //                        payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//	        //                        
//	        //                    }
//	                            payCalculationVo.setSuprtFamyNumEtc(new BigDecimal(String.valueOf(tempMap.get("suprtFamyNumEtc"))));    /** column 부양가족수_기타 : suprtFamyNumEtc */
//	                           
//	                            //실근무일수 DILNLAZ_TOT_DUTY_NUM_DYS
//	                            payCalculationVo.setDilnlazTotDutyNumDys(String.valueOf(tempMap.get("dilnlazTotDutyNumDys")));
//	                          
//	                            payCalculationVo.setAddIncmTxApptnRtoCd(String.valueOf(tempMap.get("addIncmTxApptnRtoCd"))); /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
//	                            payCalculationVo.setAddIncmTxApptnRto(new BigDecimal(String.valueOf(MSFSharedUtils.defaultNulls(tempMap.get("addIncmTxApptnRto"),"0")))); /** set 추가소득세적용비율 : addIncmTxApptnRto */ 
//	                            payCalculationVo.setAddIncmTxApptnYrMnth(String.valueOf(tempMap.get("addIncmTxApptnYrMnth"))); /** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
//	                            payCalculationVo.setBusinCd(MSFSharedUtils.allowNulls(tempMap.get("businCd"))); 
//	                            
//	                            /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	                             * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
//	                             $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
//	                            InfcPkgPayr0304VO payr0304Vo = new InfcPkgPayr0304VO();  
//	                            InfcPkgPayr0304VO tpTxPayr0304Vo = new InfcPkgPayr0304VO();  
//	                            
//	                            payr0304Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                            payr0304Vo.setPymtYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                            payr0304Vo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */
//	                            payr0304Vo.setPayrSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                            payr0304Vo.setSystemkey(voPayr0302.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                            payr0304Vo.setBusinCd(payCalculationVo.getBusinCd());    /** column buninCd */
//	                            
//	                            tpTxPayr0304Vo = payCalculationService.selectPayr0304ToAddIncmTx(payr0304Vo);
//	                           if (MSFSharedUtils.paramNotNull(tpTxPayr0304Vo)) {
//		                            if (!(MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnRtoCd()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnRtoCd()))
//		                            		&& MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnYrMnth()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth())) 
//		                            		&& "E".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn()))))  {
//		                            
//		                            	if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
//		                                   
//		                            		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(voPayr0302.getPymtYrMnth()) <= 0) {
//			                                        	
//			                            		InfcPkgPayr0500VO TxPayr0500Vo = new InfcPkgPayr0500VO(); 
//			                                    TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
//			                                    TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
//			                                    TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
//			                                    
//			                                    payCalculationService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
//			                                   //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
//		                            		}   
//		                            	}
//		                            
//		                            } 
//	                           } else {
//	                        	   
//	                        	   if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
//	                                   
//	                           		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(voPayr0302.getPymtYrMnth()) <= 0) {
//		                                        	
//		                            		InfcPkgPayr0500VO TxPayr0500Vo = new InfcPkgPayr0500VO(); 
//		                                    TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
//		                                    TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
//		                                    TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
//		                                    
//		                                    payCalculationService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
//		                                   //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
//	                           		}   
//	                           	}
//	                           } 
//	                            /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	                             * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
//	                             $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
//	                            
//	                            tpWorkIncmTxtnSum =  new BigDecimal(String.valueOf(tempMap.get("tpTxtnTotAmnt")));//과세대상금액
//	                            //국민연금  
//	                            tpNatPennAmt = new BigDecimal(String.valueOf(tempMap.get("sumB002")));
//	                            
//	                              
//	                            if (tpNatPennAmt.compareTo(BigDecimal.ZERO) <= 0) {
//	                                  payCalculationVo.setNatPennApptnYn("N");
//	                            } else {
//	                                  payCalculationVo.setNatPennApptnYn("Y");
//	                            } 
//	                               
//	                            //pymtTotAmnt 지급총액
//	                              tpPymtTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpPymtTotAmnt")));
//	                            //extpyTotAmnt 수당총액
//	                              tpExtpyTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpExtpyTotAmnt")));
//	                            //txtnTotAmnt 과세총액 
//	                              tpTxtnTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpTxtnTotAmnt")));
//	                            //freeDtyTotAmnt 비과세총액 
//	                              tpFreeDtyTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpFreeDtyTotAmnt")));
//	                            //dducTotAmnt  공제총액 
//	                              tpDducTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpDducTotAmnt")));
//	                          
//	                              //일용직인경우 소득세 주민세 계산 루틴을 다르게 적용해야 함.......
//	                              if ("Y".equals(String.valueOf(tempMap.get("dayWorkYn")))) {
//	                                  /***********************************************************************************/
//	                                  //일용직로직 추가 부분 ......
//	                                  /***********************************************************************************/
//	                                  //소득세/지방소득세  
//	                                  txTotAmnt = payrTaxCtl.getFuncWorkDayIncmTxtn(request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);  
//	                                  
//	                              } else {
//	                            	  
//	                            	   if ("201506".compareTo(payr0250Vo.getJobYrMnth()) < 0) {
//	                            		   //소득세/지방소득세  
//	                                       txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn2015( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
//	                            	   } else {
//	                            		   //소득세/지방소득세  
//	                                       txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
//	                            	   }
//	                                  
//	                              }
//	                           
//	                            payr0301Vo.setDpobCd(voPayr0302.getDpobCd());    /** column 사업장코드 : dpobCd */  
//	                            payr0301Vo.setPymtYrMnth(voPayr0302.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                            payr0301Vo.setSystemkey(voPayr0302.getSystemkey());    
//	                            payr0301Vo.setPayCd(voPayr0302.getPayCd());    /** column 급여구분코드 : payCd */        
//	                            payr0301Vo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//	                            payr0301Vo.setPayrSeilNum(voPayr0302.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                            payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
//	                            payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
//	                            payr0301Vo.setTxtnTotAmnt(tpTxtnTotAmnt);   
//	                            payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
//	                            payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
//	                            payr0301Vo.setTxTotAmnt(txTotAmnt);      
//	                            payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
//	                           // payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
//	                           // payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
//	                           // payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
//	                           // payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
//	                           // payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
//	                           // payr0301Vo.setPayDdlneDt("");    
//	                           // payr0301Vo.setPayDdlneYn("N");   
//	                            
//	                            payCalculationService.updatePayr0301ToPayr0307(payr0301Vo); //월급여내역   
//	                            
//	                           
//	                        } 
//	                }
//	                
//	            } catch (Exception e) {
//	                // TODO Auto-generated catch block
//	                e.printStackTrace();
//	                result = 0;
//	            }       
//	            
//	            return result;
//	        }
//		  	 
//		  	/**
//		  	 * 급여처리로직 
//		  	 * @param request
//		  	 * @param dtoPayr0250
//		  	 * @param voPsnl0100
//		  	 * @return
//		  	 */
//		  	private PagingLoadResult<ShowMessageBM> funcPayr4100ToPayrCalc(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250,InfcPkgPsnl0100VO voPsnl0100)  throws Exception {
//		  	    
//		  	  PagingLoadResult<ShowMessageBM> retval = null; 
//		      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
//		  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//		  	  
//		  	//소득세계산을 위한 메서드 
//	          payrTaxCtl = PayrTaxController.getInstance();
//		  	   // 4대 보험 메소드  
//    pkgInsrCtl = PkgInsrController.getInstance(); 
//		  	   if  (payCalculationService == null) { 
//	               WebApplicationContext wac = WebApplicationContextUtils.
//	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
//	   
//	               payCalculationService = (PayCalculationService) wac.getBean("PayCalculationService" ); 
//	              
//	          }
//		  	 // System.out.println("Start dept: " + sessionUser.getDeptCd() + ":" + sessionUser.getDeptNm());
//	          
//	          // int result = 0;
//	           int iDducCnt = 0;
//	           boolean boolInsert = false;
//	           
//	           InfcPkgPayr0520SrhVO payr0520SrhVo = new InfcPkgPayr0520SrhVO();
//	           InfcPkgPayr0540SrhVO payr0540SrhVo = new InfcPkgPayr0540SrhVO();
//	           InfcPkgPayr0520VO  payr0520Vo = null;
//	           InfcPkgPayr0250VO  payr0250Vo = new InfcPkgPayr0250VO();
//	           InfcPkgPayr0300VO  payr0300Vo = new InfcPkgPayr0300VO();
//	           InfcPkgPayr0301VO  payr0301Vo = new InfcPkgPayr0301VO();
//	           InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
//	           InfcPkgPayr0304VO  payr0304Vo = new InfcPkgPayr0304VO();
//	           InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
//	           InfcPkgPayr0306VO  payr0306Vo = new InfcPkgPayr0306VO(); 
//	           InfcPkgPayr0410VO  payr0410Vo = new InfcPkgPayr0410VO();
//	           InfcPkgPayr0530VO  payr0530Vo = new InfcPkgPayr0530VO();
//	           InfcPkgPayr0540VO  payr0540Vo = null;
//	           
//	           //항목별수당
//	           InfcPkgPayr0450SrhVO payr0450SrhVo = new InfcPkgPayr0450SrhVO();
//	           InfcPkgPayr0520VO  payr0450Vo = null;
//	           
//	           //직책별 수당 
//	           InfcPkgPayr0460SrhVO payr0460SrhVo = new InfcPkgPayr0460SrhVO();
//	           InfcPkgPayr0460VO  payr0460Vo = null;
//	           
//	           
//	           InfcPkgPayr0410SrhVO payr0410SrhVo = new InfcPkgPayr0410SrhVO();
//	           PayrInsrStdSrhVO payrInsrStdSrhVo = new PayrInsrStdSrhVO();
//	           PayrInsrStdVO payrInsrStdVo = null;
//	           
//	           //시간외 근무 및 기본근무집계내역을 가지는 객체
//	           //Dlgn0100VO dlgn0100Vo = new Dlgn0100VO();   //기본근무
//	           //Dlgn0200VO dlgn0200Vo = new Dlgn0200VO();   //시간외근무(휴일근무포함)
//	            
//	           
//	           PkgPayrCommCalcVO payCalculationVo = null;
//	           
//	           //가족수당 합
//	           BigDecimal tpFamyExtpySum = BigDecimal.ZERO;
//	           
//	           BigDecimal tpFamyFreeExtpySum = BigDecimal.ZERO;
//	           
//	           //학비보조금함계
//	           BigDecimal  tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;
//	           BigDecimal  tpStdPymtTotAmnt = BigDecimal.ZERO;   //기본
//	           //pymtTotAmnt 지급총액
//	           BigDecimal  tpPymtTotAmnt = BigDecimal.ZERO;
//	           //extpyTotAmnt 수당총액
//	           BigDecimal  tpExtpyTotAmnt = BigDecimal.ZERO;
//	           //txtnTotAmnt 과세총액 
//	           BigDecimal  tpTxtnTotAmnt = BigDecimal.ZERO;
//	           //freeDtyTotAmnt 비과세총액 
//	           BigDecimal  tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	           //dducTotAmnt  공제총액 
//	           BigDecimal  tpDducTotAmnt = BigDecimal.ZERO;
//	           // 
//	            //건강보험 
//	            BigDecimal tpHlthInsrPayAmt = BigDecimal.ZERO;
//	            //요양 
//	            BigDecimal tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;
//	             //국민연금  
//	            BigDecimal tpNatPennAmt = BigDecimal.ZERO;
//	            //고용 
//	            BigDecimal tpUmytInsrApptnAmt = BigDecimal.ZERO;
//	            //기본급정보 
//	            BigDecimal basePymtAmnt =  BigDecimal.ZERO;
//	            //보수금액 
//	            BigDecimal tpPymtAmnt =  BigDecimal.ZERO;
//	            //과세대상금액 
//	            BigDecimal tpWorkIncmTxtnSum =  BigDecimal.ZERO;
//	            
//	            //과세합계
//	            BigDecimal txTotAmnt =  BigDecimal.ZERO;
//	            
//	           //월 출력체크 
//	           String chkMonth = "N";
//	           boolInsert = true;  //payr0300 급여마스터 인서트 여부 
//	           
//	           DlgnProcessContainer dlgnProcessContainer = new DlgnProcessContainer();
//	           Map<String, Object> mapPayr = new HashMap<String, Object>();
//	              
//	            if (MSFSharedUtils.paramNull(dtoPayr0250.getJobYrMnth()) 
//	            		|| MSFSharedUtils.paramNull(dtoPayr0250.getPayrMangDeptCd()) 
//	            		|| MSFSharedUtils.paramNull(dtoPayr0250.getPymtDt()) 
//	            		|| MSFSharedUtils.paramNull(dtoPayr0250.getRflctnBgnnDt())
//	            		|| MSFSharedUtils.paramNull(dtoPayr0250.getRflctnEndDt())) {
//	            	
//	            	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","스케줄정보","급여스케줄정보 이상!!! 확인요망." )); 
//	                 
//	            }
//	            payr0250Vo.setDpobCd(dtoPayr0250.getDpobCd());    /** column 사업장코드 : dpobCd */
//	            payr0250Vo.setJobYrMnth(dtoPayr0250.getJobYrMnth());    /** column 작업년월 : jobYrMnth */
//	            payr0250Vo.setPayCd(dtoPayr0250.getPayCd());    /** column 급여구분코드 : payCd */
//	            payr0250Vo.setPayScduSeilNum(dtoPayr0250.getPayScduSeilNum());    /** column 급여스케줄일련번호 : payScduSeilNum */
//	            payr0250Vo.setPayrMangDeptCd(dtoPayr0250.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//	            payr0250Vo.setDeptCd(dtoPayr0250.getDeptCd());    /** column 부서코드 : deptCd */
//	            payr0250Vo.setBusinCd(dtoPayr0250.getBusinCd());    /** column 사업코드 : businCd */
//	            payr0250Vo.setEmymtDivCd(dtoPayr0250.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//	            payr0250Vo.setPernChrgEmpIdenNum(dtoPayr0250.getPernChrgEmpIdenNum());    /** column 담당직원번호 : pernChrgEmpIdenNum */
//	            payr0250Vo.setJobNm(dtoPayr0250.getJobNm());    /** column 작업명 : jobNm */
//	            payr0250Vo.setPymtDt(dtoPayr0250.getPymtDt());    /** column 지급일자 : pymtDt */
//	            payr0250Vo.setRflctnBgnnDt(dtoPayr0250.getRflctnBgnnDt());    /** column 반영시작일자 : rflctnBgnnDt */
//	            payr0250Vo.setRflctnEndDt(dtoPayr0250.getRflctnEndDt());    /** column 반영종료일자 : rflctnEndDt */
//	            payr0250Vo.setPayDdlneDt(dtoPayr0250.getPayDdlneDt());    /** column 급여마감일자 : payDdlneDt */
//	            payr0250Vo.setGroFlCretnDt(dtoPayr0250.getGroFlCretnDt());    /** column 지로파일생성일자 : groFlCretnDt */
//	            payr0250Vo.setKybdr(dtoPayr0250.getKybdr());    /** column 입력자 : kybdr */
//	            payr0250Vo.setInptDt(dtoPayr0250.getInptDt());    /** column 입력일자 : inptDt */
//	            payr0250Vo.setInptAddr(dtoPayr0250.getInptAddr());    /** column 입력주소 : inptAddr */
//	            payr0250Vo.setIsmt(dtoPayr0250.getIsmt());    /** column 수정자 : ismt */
//	            payr0250Vo.setRevnDt(dtoPayr0250.getRevnDt());    /** column 수정일자 : revnDt */
//	            payr0250Vo.setRevnAddr(dtoPayr0250.getRevnAddr());    /** column 수정주소 : revnAddr */
//	            payr0250Vo.setTypOccuCd(dtoPayr0250.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//	            //payr0250Vo.setPyspGrdeCd(dtoPayr0250.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */ 
//	            payr0250Vo.setDtilOccuInttnCd(dtoPayr0250.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */ 
//	           /**
//	            * 개별 근로자 처리를 위한 vo객체에 값 넣기 
//	            */
//	          
//	           if (voPsnl0100 != null) {
//	               payr0250Vo.setSystemkey(voPsnl0100.getSystemkey());  
//	               if (MSFSharedUtils.paramNull(voPsnl0100.getSystemkey())) {
//	            	   boolInsert = true;  //payr0300 급여마스터 인서트 여부 
//	               }
//	           } else {
//	               payr0250Vo.setSystemkey(""); 
//	               boolInsert = true;  //payr0300 급여마스터 인서트 여부 
//	           } 
//	         try {
//	             
//	                   // 근태관리정리작업 진행 인터페이스 호출 
//	                   // 근태관리테이블에 데이터 존재여부 확인 없으면 메시지출력 함. 
//	                   // 근무시간 가져오기 - 시간외 근무인경우는 두가지 경우로 처리함.
//	                   // dlgnProcessContainer.setSelectManageDlgn0100CommuteService(payr0250Vo);
//	                   // dlgnProcessContainer.setSelectManageDlgn0200CommuteService(payr0250Vo);
//	              
//	                   //사회보험요율가져오기 
//	                   List insureList = pkgInsrCtl.getSelect4InsureDataList(payr0250Vo);  
//	                   
//	                   if (insureList.size() > 0) {
//	                	 //  BaseModel bm = new BaseModel();
//	                	   ShowMessageBM smBm = new ShowMessageBM();
//	                	   smBm.setDivision(PropPayGenConfs.PAYGEN_INFO);
//	                	   smBm.setMenu("Payr");
//	                	   smBm.setPhase("[급여]4대보험요율");
//	                	   smBm.setMessage("불러오기성공");
//	                	   smBm.setContent("");
//	                	   bmResult.add(smBm); 
//	                   }  
//	                   
//	                   
//	                   if (ExtermsProps.getProps("EMYMT_DIVCD_01").equals(payr0250Vo.getEmymtDivCd())) {
//	                	  
//	                	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여]처리시작","무기계약직",""));  
//	                  /**
//	                   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	                   * 무기계약직 
//	                   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
//	                   */ 
//	                    	//List<String> listDeptCd = new ArrayList<String>();
//	                       ArrayList strDducPayr0520= new ArrayList();  
//	                       payr0250Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부  
//	                       payr0250Vo.setUsrId(sessionUser.getUsrId());  
//	                       /******************************** 권한 ************************************************************************/
//	                       payr0250Vo.setDeptCdAuth(payr0250Vo.getDeptCd());  //권한처리를위해 추가  
//	                       payr0250Vo.setDtilOccuInttnCdAuth(payr0250Vo.getDtilOccuInttnCd());   
//	              
//	                       String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	                       if ("FALSE".equals(chkDeptCd)) {
//	                    	   payr0250Vo.setDeptCd(sessionUser.getDeptCd());  
//	                    	   //listDeptCd.add(sessionUser.getDeptCd());
//	                    	  // payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드    
//	                    	   payr0250Vo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	                       } else {
//	                       	    
//	                    	     
//	                                if (payr0250Vo.getPayrMangDeptCd().equals(payr0250Vo.getDeptCd())) {  
//	                                	//listDeptCd = null; 
//	                                	//payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드 
//	                                	payr0250Vo.setDeptCd("");  //부서코드
//	                               
//	                                } else {  
//	                                	
//	                                	payr0250Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0250Vo.getPayrMangDeptCd())) ;   //단위기관코드
//		                                if (payr0250Vo.getDeptCd().equals("ALL")) {
//		                                	//listDeptCd = null; 
//		                                	//payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드 
//		                                	payr0250Vo.setDeptCd("");  //부서코드
//		                                } else {  
//		                                	payr0250Vo.setDeptCd(MSFSharedUtils.allowNulls(payr0250Vo.getDeptCd()));
//		                                    // listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0250Vo.getDeptCd()));  
//		                                    // payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드   
//		                                } 
//	                                }    
//	                             
//	                       }
//	                       /******************************** 권한 ************************************************************************/
//	                       //무기계약직인경우 처리를 위한 부분  
//	                        //TODO 확인 필요 
////	                          if ( (ExtermsProps.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (ExtermsProps.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
////	                           //기간제업무담당자- 기간제업무담당자
////	                             
////	                          } else  if (ExtermsProps.AUTH_USR_DIV_10.equals(sessionUser.getUsrDivCd())) {
////	                           //무기계약직업무담당자- 무기계약직업무담당자
////	                              //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
////	                              if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////	                                      && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////	                                 
////	                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
////	                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
////	                                  payr0250Vo.setPayrMangDeptYn("");
////	                                  
////	                              } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////	                                      && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////	                                  
////	                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
////	                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
////	                                  payr0250Vo.setPayrMangDeptYn("");
////	                                  
////	                              } else { 
////	                                  //TODO 전체관리자나 총괄관리자일경우 선택된 항목을 가지고 처리하는 루틴 추가 
////	                                  payr0250Vo.setTypOccuCd(""); 
////	                                  payr0250Vo.setPyspGrdeCd("");
////	                                  payr0250Vo.setPayrMangDeptYn("");
////	                              }
////	                                
////	                          } else  if (ExtermsProps.AUTH_USR_DIV_25.equals(sessionUser.getUsrDivCd())) {
////	                              //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
////	                                 //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
////	                              if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////	                                      && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////	                                 
////	                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
////	                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
////	                                  payr0250Vo.setPayrMangDeptYn("");
////	                                  
////	                              } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////	                                      && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////	                                 
////	                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
////	                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
////	                                  payr0250Vo.setPayrMangDeptYn("");
////	                                  
////	                              } else { 
////	                                  //TODO 전체관리자나 총괄관리자일경우 선택된 항목을 가지고 처리하는 루틴 추가
////	                                  payr0250Vo.setTypOccuCd(""); 
////	                                  payr0250Vo.setPyspGrdeCd("");
////	                                  payr0250Vo.setPayrMangDeptYn("");
////	                              }
////	                                   
////	                                
////	                          } else  if (ExtermsProps.AUTH_USR_DIV_30.equals(sessionUser.getUsrDivCd())) {
////	                            //무기계약직업무담당자- 무기계약직업무담당자
////	                              if ("Y".equals(sessionUser.getPayrMangDeptYn())) {
////	                                  
////	                                  payr0250Vo.setPayrMangDeptYn("Y"); 
////	                              
////	                              } else {
////	                                  payr0250Vo.setPayrMangDeptYn("");  
////	                              }
////	                            
////	                          } else  if (ExtermsProps.AUTH_USR_DIV_60.equals(sessionUser.getUsrDivCd())) {  
////	                              
////	                                 
////	                          }
//	                       
//	                       
//	                      
//	                       //인사정보 추출 //근태기록도 같이 가져옴.
//	                       //검색조건 지급년월 기준으로 정보를 가져온다. 
//	                       //근태관리의 근무일수 산정등...데이타 가져오기 결과값.
//	                       //시스템키. 및 무기계약직에서 환경미화원 담당자 인경우 처리를 위한 변수 값을 가져오기 위한 처리 추가 . 
//	                     
//	                       //--
//	                       List<PkgPayrCommCalcVO>  psnlList = payCalculationService.selectGeoJePayrInfoList(payr0250Vo);  
//	                       
//	                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여]" + String.valueOf(psnlList.size()) + "명처리중","무기계약직",""));  
//	                       for (int icnt = 0; icnt < psnlList.size();icnt++) { 
//	                          //사람데이타 처리  
//	                           payCalculationVo = new PkgPayrCommCalcVO();
//	                           payCalculationVo = (PkgPayrCommCalcVO)psnlList.get(icnt);
//	                          
//	                           if ("Y".equals(payCalculationVo.getPayRcptYn())) {
//	                               
//	                                   if (boolInsert) {
//	                                       //직종 // 근속년수 에따른 급여 항목 정보 추출 및 단가표에서 값을 가지고 온다. 
//	                                       //검색조건 - 지급년월, 사용여부 년월에 지급여 
//	                                       payr0410SrhVo.setDpobCd(payr0250Vo.getDpobCd());  //사업장코드 
//	                                       payr0410SrhVo.setPayYr(payr0250Vo.getJobYrMnth().substring(0, 4)); //급여항목년도 
//	                                       
//	                                       //payCalculationService.selectPayrItemUnitInfoList(searchVO);
//	                                        
//	                                       //무기계약직 
//	                                       payr0300Vo.setDpobCd(payr0250Vo.getDpobCd()); //사업장코드 
//	                                       payr0300Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드 
//	                                       payr0300Vo.setPayrMangDeptCd(payr0250Vo.getPayrMangDeptCd()) ;//단위기관코드 
//	                                       payr0300Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()); 
//	                                       payr0300Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//	                                       payr0300Vo.setPayPymtDt(payr0250Vo.getPymtDt());   //지급일자 
//	                                       payr0300Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//	                                       payr0300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//	                                       payr0300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//	                                       payr0300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//	   	                           	    
//	                                       InfcPkgPayr0300VO  tpPayr0300Vo = new InfcPkgPayr0300VO();
//	                                       
//	                                       tpPayr0300Vo = payCalculationService.selectPayr0300(payr0300Vo); 
//	                                        
//	                                       if (MSFSharedUtils.paramNull(tpPayr0300Vo) 
//	                                       		|| MSFSharedUtils.paramNull(tpPayr0300Vo.getPayPymtDt()))  {
//	                                    	   //급여마스터 테이블에 데이터을 인서트한다.  
//	                                           payCalculationService.insertPayr0300(payr0300Vo);
//	                                      }
//	                                       boolInsert = false;
//	                                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]급여마스터저장" ,"급여마스터저장완료","")); 
//	                                   }
//	                                   
//
//	                                   /*************************************************************** 
//	                                    4대보험 이력 테이블 추가 
//	                                   ****************************************************************/
//	                                    InfcPkgPayr0309VO payr0309Vo = new InfcPkgPayr0309VO();
//	                                    InfcPkgPayr0309VO tpPayr0309Vo = new InfcPkgPayr0309VO();
//	                                   
//	                                    payr0309Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
//	                                    payr0309Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
//	                                    payr0309Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
//	                                    payr0309Vo.setPoayCd(payr0250Vo.getPayCd());  //급여구분코드  
//	                                    payr0309Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//		                           	    payr0309Vo.setHlthInsurFlucDt(payCalculationVo.getHlthInsurFlucDt());    /** column 건강보험변동일자 : hlthInsurFlucDt */
//		                           	    payr0309Vo.setHlthInsrPayTotAmnt(payCalculationVo.getHlthInsrPayTotAmnt());    /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
//		                           	    payr0309Vo.setHlthInsrMnthRuntnAmnt(payCalculationVo.getHlthInsrMnthRuntnAmnt());    /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
//		                           	    payr0309Vo.setHlthInsrGrde(payCalculationVo.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
//		                           	    payr0309Vo.setHlthInsrCertNum(payCalculationVo.getHlthInsrCertNum());    /** column 건강보험증번호 : hlthInsrCertNum */
//		                           	    payr0309Vo.setNatPennInsurFlucDt(payCalculationVo.getNatPennInsurFlucDt());    /** column 국민연금변동일자 : natPennInsurFlucDt */
//		                           	    payr0309Vo.setNatPennStdIncmMnthAmnt(payCalculationVo.getNatPennStdIncmMnthAmnt());    /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
//		                           	    payr0309Vo.setNatPennGrde(payCalculationVo.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
//		                           	    payr0309Vo.setHlthInsrApptnYn(payCalculationVo.getHlthInsrApptnYn());    /** column 건강보험적용여부 : hlthInsrApptnYn */
//		                           	    payr0309Vo.setNatPennApptnYn(payCalculationVo.getNatPennApptnYn());    /** column 국민연금적용여부 : natPennApptnYn */
//		                           	    payr0309Vo.setUmytInsrApptnYn(payCalculationVo.getUmytInsrApptnYn());    /** column 고용보험적용여부 : umytInsrApptnYn */
//		                           	    payr0309Vo.setIdtlAccdtInsurApptnYn(payCalculationVo.getIdtlAccdtInsurApptnYn());    /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
//		                           	 
//		                           	    payr0309Vo.setUmytInsrFlucDt(payCalculationVo.getUmytInsrFlucDt());    /** column 고용보험변동일자 : umytInsrFlucDt */
//		                           	    payr0309Vo.setUmytInsrPayTotAmnt(payCalculationVo.getUmytInsrPayTotAmnt());    /** column 고용보험보수총액 : umytInsrPayTotAmnt */
//		                           	    payr0309Vo.setUmytInsrPayMnthAmnt(payCalculationVo.getUmytInsrPayMnthAmnt());    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
//		                           	    payr0309Vo.setIdtlAccdtFlucDt(payCalculationVo.getIdtlAccdtFlucDt());    /** column 산재보험변동일자 : idtlAccdtFlucDt */
//		                           	    payr0309Vo.setIdtlAccdtPayTotAmnt(payCalculationVo.getIdtlAccdtPayTotAmnt());    /** column 산재보험보수총액 : idtlAccdtPayTotAmnt */
//		                           	    payr0309Vo.setIdtlAccdtPayMnthAmnt(payCalculationVo.getIdtlAccdtPayMnthAmnt());    /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
//	                           	    
//		                           	    payr0309Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//		                           	    payr0309Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//		                           	    payr0309Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//		                           	    payr0309Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//		                           	    
//		                             	 tpPayr0309Vo = payCalculationService.selectPayr0309(payr0309Vo); 
//	                                  
//	                                  if (MSFSharedUtils.paramNull(tpPayr0309Vo)) { 
//	                                     
//	                                      payCalculationService.insertPayr0309(payr0309Vo);
//	                                      
//	                                  } else {
//	                                      
//	                                      payCalculationService.updatePayr0309(payr0309Vo);
//	                                  }
//	                                  
//	                           	     
//	                                   /*************************************************************** 
//	                                                                                  급여 계산을 위한 초기화 
//	                                   ****************************************************************/
//	                                 
//	                                   tpFamyExtpySum = BigDecimal.ZERO;            //가족수당 합 
//	                                   tpFamyFreeExtpySum =  BigDecimal.ZERO;            //가족수당 비과세합계  
//	                                   tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;   //학비보조금함계
//	                                   tpStdPymtTotAmnt= BigDecimal.ZERO;   //기본
//	                                   tpPymtTotAmnt = BigDecimal.ZERO;             //pymtTotAmnt 지급총액
//	                                   tpExtpyTotAmnt = BigDecimal.ZERO;            //extpyTotAmnt 수당총액
//	                                   tpTxtnTotAmnt = BigDecimal.ZERO;             //txtnTotAmnt 과세총액 
//	                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;          //freeDtyTotAmnt 비과세총액
//	                                   tpDducTotAmnt = BigDecimal.ZERO;             //dducTotAmnt  공제총액 
//	                                   tpHlthInsrPayAmt = BigDecimal.ZERO;          //건강보험
//	                                   tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;     //요양 
//	                                   tpNatPennAmt = BigDecimal.ZERO;              //국민연금
//	                                   tpUmytInsrApptnAmt = BigDecimal.ZERO;        //고용
//	                                   tpPymtAmnt =  BigDecimal.ZERO;               //보수금액
//	                                   tpWorkIncmTxtnSum =  BigDecimal.ZERO;        //과세대상금액
//	                                   chkMonth = "N";                               //월 출력체크
//	                             
//	                                  if ((payCalculationVo.getExPayr0410() != null)  && (!payCalculationVo.getExPayr0410().isEmpty())) { 
//	                                    
//	                                      /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                       *  월급여내역개인 인서트  시작
//	                                       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                      
//	                                      //1. 이미등록된 정보인지 확인 하고 정보가 존재하면 스킾  
//	                                      payr0304Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
//	                                      payr0304Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
//	                                      payr0304Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
//	                                      payr0304Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
//	                                      payr0304Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//	                                      payr0304Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//	                                      payr0304Vo.setEmymtDivCd(payCalculationVo.getEmymtDivCd());            /** column 고용구분코드 : emymtDivCd */
//	                                      payr0304Vo.setHanNm(payCalculationVo.getHanNm());                      /** column 한글성명 : hanNm */
//	                                      payr0304Vo.setResnRegnNum(payCalculationVo.getResnRegnNum());          /** column 주민등록번호 : resnRegnNum */
//	                                      payr0304Vo.setDeptCd(payCalculationVo.getCurrAffnDeptCd());                    /** column 부서코드 : deptCd */
//	                                      payr0304Vo.setBusinCd(payCalculationVo.getBusinCd());    /** column 사업코드 : businCd */
//	                                      payr0304Vo.setTypOccuCd(payCalculationVo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//	                                      payr0304Vo.setDtilOccuInttnCd(payCalculationVo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//	                                      payr0304Vo.setOdtyCd(payCalculationVo.getOdtyCd());    /** column 직책코드 : odtyCd */
//	                                      payr0304Vo.setPyspCd(payCalculationVo.getPyspCd());    /** column 호봉코드 : pyspCd */
//	                                      payr0304Vo.setPyspGrdeCd(payCalculationVo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//	                                      payr0304Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//	                                      payr0304Vo.setLogSvcMnthIcmCd(payCalculationVo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//	                                      payr0304Vo.setFrstEmymtDt(payCalculationVo.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
//	                                      payr0304Vo.setEmymtBgnnDt(payCalculationVo.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
//	                                      payr0304Vo.setEmymtEndDt(payCalculationVo.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
//	                                      payr0304Vo.setHdofcDivCd(payCalculationVo.getHdofcCodtnCd());    /** column 재직구분코드 : hdofcDivCd */
//	                                      payr0304Vo.setRetryDt(payCalculationVo.getRetryDt());    /** column 퇴직일자 : retryDt */
//	                                      payr0304Vo.setLogSvcStdDt(payCalculationVo.getLogSvcStdDt());    /** column 근속기준일자 : logSvcStdDt */
//	                                      payr0304Vo.setSpueYn(payCalculationVo.getSpueYn());    /** column 배우자유무 : spueYn */
//	                                      payr0304Vo.setSuprtFamyNumTwenChDn(payCalculationVo.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
//	                                      if (("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn())) 
//	                                               && (payCalculationVo.getSuprtFamyNumTwenChDn().compareTo( new BigDecimal("2")) > 0)) {
//	                                          payr0304Vo.setSuprtFamyNumTreOvrChdn(payCalculationVo.getSuprtFamyNumTwenChDn().subtract( new BigDecimal("2")) );    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
//	                                          payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /**TODO column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//	                                          
//	                                      } else  {
//	                                          payr0304Vo.setSuprtFamyNumTreOvrChdn(BigDecimal.ZERO);    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */ 
//	                                          payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//	                                          
//	                                      }
//	                                      payr0304Vo.setSuprtFamyNumEtc(payCalculationVo.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
//	                                      payr0304Vo.setChdnSchlExpnAdmclYn(payCalculationVo.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
//	                                      payr0304Vo.setHlthInsrGrde(payCalculationVo.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
//	                                      payr0304Vo.setNatPennGrde(payCalculationVo.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
//	                                      payr0304Vo.setMnthPayDlywagSum(BigDecimal.ZERO);    /** column 월급여일당금액 : mnthPayDlywagSum */
//	                                      
//	                                      payr0304Vo.setAddIncmTxApptnRtoCd(payCalculationVo.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
//	                                      payr0304Vo.setAddIncmTxApptnYrMnth(payCalculationVo.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
//	                                      
//	                                      InfcPayr0304VO  tpPayr0304Vo = new InfcPayr0304VO();
//	                                      
//	                                      tpPayr0304Vo = payCalculationService.selectPayr0304(payr0304Vo); 
//	                                      
//	                                      if (MSFSharedUtils.paramNull(tpPayr0304Vo)) { 
//	                                         
//	                                          payCalculationService.insertPayr0304(payr0304Vo);
//	                                          
//	                                      } else {
//	                                          
//	                                          payCalculationService.updatePayr0304(payr0304Vo);
//	                                      }
//	                                   
//	                                      /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	                                       * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
//	                                       $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
//	                                      InfcPayr0304VO tpTxPayr0304Vo = new InfcPayr0304VO();  
//	                                      tpTxPayr0304Vo = payCalculationService.selectPayr0304ToAddIncmTx(payr0304Vo);
//	                                    
//	                                      if (MSFSharedUtils.paramNotNull(tpTxPayr0304Vo)) {
//	          	                            if (!(MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnRtoCd()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnRtoCd()))
//	          	                            		&& MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnYrMnth()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth())) 
//	          	                            		&& "E".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn()))))  {
//	          	                            
//	          	                            	if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
//	          	                                   
//	          	                            		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0304Vo.getPymtYrMnth()) <= 0) {
//	          		                                        	
//	          		                            		InfcPayr0500VO TxPayr0500Vo = new InfcPayr0500VO(); 
//	          		                                    TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
//	          		                                    TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
//	          		                                    TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
//	          		                                    
//	          		                                    payCalculationService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
//	          		                                   //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
//	          	                            		}   
//	          	                            	}
//	          	                            
//	          	                            } 
//	                                     } else {
//	                                  	   
//	                                  	   if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
//	                                             
//	                                     		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0304Vo.getPymtYrMnth()) <= 0) {
//	          	                                        	
//	          	                            		InfcPayr0500VO TxPayr0500Vo = new InfcPayr0500VO(); 
//	          	                                    TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
//	          	                                    TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
//	          	                                    TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
//	          	                                    
//	          	                                    payCalculationService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
//	          	                                   //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
//	                                     		}   
//	                                     	}
//	                                     } 
//	                                      
//	                                     
//	                                      
//	                                      /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	                                       * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
//	                                       $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
//	                                       
//	                                      
//	                                      bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]월급여내역인서" ,"월급여내역저장완료","대상자 : " + payCalculationVo.getHanNm())); 
//	                                      /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                       *  월급여내역개인 인서트  종료
//	                                       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                      
//	                              
//	                                        if (ExtermsProps.getProps("PAY_CD_01").equals(payr0250Vo.getPayCd())) { 
//	                                                /**
//	                                                 * @@@@@@@@@@@@@@@@@@@@@@ 월급여 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                 */ 
//	                                                // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다. 
//	            
//	                                                payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                                payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                                payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                                payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                                payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                                payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                                payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                                payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                                payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                                payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                                payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                                payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                                payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                                payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                                payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                                payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	            //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                                
//	                                                payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                                 
//	                                                /*########################################################################################*/
//	                                                /**  가족수당/학비보조수당    시작                                                                                                                                                               **/
//	                                                /*########################################################################################*/  
//	                                                Set<InfcPayr0530VO> payr0530Set = payCalculationVo.getExPayr0530();
//	                                                
//	                                                Iterator<InfcPayr0530VO> iterpayr0530Set = payr0530Set!=null ? payr0530Set.iterator()  : null;
//	                                                
//	                                                while (iterpayr0530Set.hasNext() ) {
//	                                                    
//	                                                    InfcPayr0530VO payr0530 = iterpayr0530Set.next(); 
//	            
//	                                                    payr0306Vo.setDpobCd(payr0530.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                    payr0306Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());     /** column 지급년월 : pymtYrMnth */          
//	                                                    payr0306Vo.setSystemkey(payCalculationVo.getSystemkey());            /** column SYSTEMKEY : systemkey */  
//	                                                    payr0306Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
//	                                                    payr0306Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//	                                                    payr0306Vo.setPayFamyRsptSeilNum(payr0530.getPayFamyRsptSeilNum());    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
//	                                                    payr0306Vo.setPayFamyResnRegnNum(payr0530.getPayFamyResnRegnNum());   /** column 급여가족주민번호 : payFamyResnRegnNum */ 
//	                                                    payr0306Vo.setHanNm(payr0530.getHanNm());                 /** column 한글성명 : hanNm */  
//	                                                    payr0306Vo.setFamyRelaDivCd(payr0530.getFamyExtpyDivCd());       /** column 가족관계구분코드 : famyRelaDivCd */    
//	                                                    payr0306Vo.setFamyAllwPymtYn(payr0530.getFamyAllwPymtYn());     /** column 가족수당지급여부 : famyAllwPymtYn */    
//	                                                    payr0306Vo.setChdnChdRrgEpnsPymtYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
//	                                                    payr0306Vo.setFndtnDducYn(payr0530.getFndtnDducYn());        /** column 기본공제여부 : fndtnDducYn */     
//	                                                    payr0306Vo.setSpueDducYn(payr0530.getSpueDducYn());          /** column 배우자공제여부 : spueDducYn */    
//	                                                    payr0306Vo.setWmnDducYn(payr0530.getWmnDducYn());              /** column 부녀자공제여부 : wmnDducYn */
//	                                                    payr0306Vo.setRftaGvstDducYn(payr0530.getRftaGvstDducYn());         /** column 경로우대공제여부 : rftaGvstDducYn */
//	                                                    payr0306Vo.setDabpnDducYn(payr0530.getDabpnDducYn());            /** column 장애자공제여부 : dabpnDducYn */ 
//	                                                    payr0306Vo.setSgpnFmlyDducYn(payr0530.getSgpnFmlyDducYn());           /** column 한가족공제여부 : sgpnFmlyDducYn */
//	                                                    payr0306Vo.setChdnChdRrgEpnsDducYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
//	                                                    payr0306Vo.setFamyExtpyDivCd(payr0530.getFamyExtpyDivCd());         /** column 가족수당구분코드 : famyExtpyDivCd */
//	                                                    payr0306Vo.setSchlExpnAdmclExtpyDivCd(payr0530.getSchlExpnAdmclExtpyDivCd());   /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
//	                                                    
//	                                                    if ("Y".equals(payr0530.getFamyAllwPymtYn())) {
//	                                                        payr0306Vo.setFamyExtpySum(payr0530.getFamyExtpySum());     /** column 가족수당금액 : famyExtpySum */
//	                                                    } else {
//	                                                        payr0306Vo.setFamyExtpySum(BigDecimal.ZERO);                  /** column 가족수당금액 : famyExtpySum */
//	                                                    }
//	                                                    
//	                                                    if ((payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                            && (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                            && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) ) {
//	                                                  
//	                                                    	payr0306Vo.setSchlExpnAdmclExtpySum(payr0530.getSchlExpnAdmclExtpySum());     /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
//	                                                 
//	                                                    } else {
//	                                                    
//	                                                        payr0306Vo.setSchlExpnAdmclExtpySum(BigDecimal.ZERO);
//	                                                        
//	                                                    }
//	                                                    
//	                                                    if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
//	                                                            (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                            && (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                            && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
//	                                                     
//	                                                           if (MSFSharedUtils.paramNull(payr0306Vo.getFamyExtpySum())) {
//	                                                               payr0306Vo.setFamyExtpySum(new BigDecimal("0"));
//	                                                           }
//	                                                           
//	                                                           if (MSFSharedUtils.paramNull(payr0306Vo.getSchlExpnAdmclExtpySum())) {
//	                                                               payr0306Vo.setSchlExpnAdmclExtpySum(new BigDecimal("0"));
//	                                                           }
//	                                                           
//	                                                           // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
//	                                                          if ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
//	                                                        	 
//	                                                        	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
//	                                                        	   
//	                                                        	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
//	                                                        		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
//	                                                        	   }
//	                                                           }
//	                                                            //가족수당 합
//	                                                            tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
//	                                                            //학비보조금함계
//	                                                            tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum()); 
//	                                                            
//	                                                            InfcPayr0306VO tpPayr0306Vo = new InfcPayr0306VO();
//	                                                            tpPayr0306Vo = payCalculationService.selectPayr0306(payr0306Vo);  
//	                                                            
//	                                                            if (MSFSharedUtils.paramNull(tpPayr0306Vo)) { 
//	                                                                
//	                                                                payCalculationService.insertPayr0306(payr0306Vo); 
//	                                                                
//	                                                            } else {
//	                                                                
//	                                                                payCalculationService.updatePayr0306(payr0306Vo); 
//	                                                            }
//	                                                            
//	                                                          
//	                                                    }  
//	                                                    
//	                                                }
//	                                                
//	                                                 if ("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn()) ) {
//	                                                    //TODO 추가시 지급여부 3명이상인경우인경우 처리 
//	                                                    //  tpFamyExtpySum = tpFamyExtpySum.add(payCalculationVo.getSuprtFamy3ChdnExtpySum());
//	                                                    
//	                                                 }  
//	                                               /*########################################################################################*/
//	                                               /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
//	                                               /*########################################################################################*/  
//	                                         
//	                                             
//	                                             /*########################################################################################*/
//	                                             /**  공제관련 항목  시작                                                                                                                                                                         **/
//	                                             /*########################################################################################*/    
//	                                             payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                                             payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                                             payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 
//	                                             payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
//	                                             //공제테이블 
//	                                             List listDducPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                          
//	                                             /*########################################################################################*/
//	                                             /**  공제관련 항목  가져오기                                                                                                                                                                       **/
//	                                             /*########################################################################################*/     
//	                                             
//	                                               
//	                                               /*########################################################################################*/
//	                                               /**  수당관련 항목  시작                                                                                                                                                                         **/
//	                                               /*########################################################################################*/    
//	                                               payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                                               payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                                               payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 
//	                                               payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_02"));
//	                                               //수당테이블 
//	                                               List listPymtPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                                 
//	                                               /*########################################################################################*/
//	                                               /**  공제관련 항목  가져오기                                                                                                                                                                       **/
//	                                               /*########################################################################################*/  
//	                                               
//	                                               /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                                  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                             
//	                                               //기본급가져오기위해 추가된 부분 처리 해야함. 
//	                                               Set<InfcPayr0410VO> payr0410Base = payCalculationVo.getExPayr0410();
//	                                               Iterator<InfcPayr0410VO> iterpayr0410Base = payr0410Base!=null ? payr0410Base.iterator()  : null;
//	                                               
//	                                               while ( iterpayr0410Base.hasNext() ) { 
//	                                                   
//	                                            	     InfcPayr0410VO payr0410Be = new InfcPayr0410VO();
//	                                            	     payr0410Be = iterpayr0410Base.next(); 
//	                                                     
//	                                                     if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0410Be.getPayrImcd())) {
//	                                                    	 basePymtAmnt = payr0410Be.getUcstSum();
//	                                                     } 
//	                                               }
//	                                               
//	                                               Set<InfcPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
//	                                            
//	                                               Iterator<InfcPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
//	                                               
//	                                               while ( iterpayr0410Set.hasNext() ) { 
//	                                                   
//	                                                     InfcPayr0410VO payr0410 = iterpayr0410Set.next();
//	                                                
//	                                                    if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                       
//	                                                       //공제 처리 루틴  (tpPymtTotAmnt.compareTo(BigDecimal.ZERO) > 0)  && 
//	                                                       if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0410.getPymtDducDivCd())) {
//	                                                           
//	                                                           iDducCnt = 0;
//	                                                           for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//	                                                               
//	                                                                payr0520Vo  = new InfcPayr0520VO();
//	                                                                    
//	                                                                BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt)); 
//	                                                              
//	                                                                
//	                                                                if (payr0520Vo.getPayItemCd().equals(payr0410.getPayrImcd())) {
//	                                                                 
//	                                                                        if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { 
//	                                                                             
//	                                                                            payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                            payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                            payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                            payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                            payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                            payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                            payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                            payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
//	                                                                                                           .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                            
//	                                                                           if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                        	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                                  payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                        	   }   
//	                                                                            } 
//	                                                                         
//	                                                                            tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                           
//	                                                                        } else {
//	                                                                        	//금액이 아닌 비율로 처리 되는 경우 
//	                                                                        	 if ((payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate()).compareTo(BigDecimal.ZERO) > 0) { 
//	                                                                                 
//	                                                                                 payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                                 payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                                 payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                                 payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                                 payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                                 payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                                 payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                                 payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                                 payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                                  
//	                                                                                 payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                  
//	                                                                                 payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                                 payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                                 payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//	                                                                                 //payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
//	                                                                                   //                             .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                 //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                 //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                 //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                 //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                 //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                 //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                                 
//	                                                                                 BigDecimal dducSumRate = (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate());
//	                                                                                 BigDecimal dducSum = BigDecimal.ZERO;
//	                                                                                 
//	                                                                                 dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                                  
//	                                                                                 payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                 
//	                                                                                if ((payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                             	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                             		   
//	                                                                                       payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                             	   }   
//	                                                                                 } 
//	                                                                              
//	                                                                                 tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
//	                                                                                
//	                                                                             }
//	                                                                        	
//	                                                                        }
//	                                                                        strDducPayr0520.add(payr0410.getPayrImcd());  
//	                                                                       
//	                                                                    }   
//	                                                               }
//	                                                           
//	                                                           
//	                                                           /**
//	                                                            * Payr0410에 등록된 공제 인경우 
//	                                                            */
//	                                                           if (ExtermsProps.getProps("PAY_DDUC_CD_92001").equals(payr0410.getPayrImcd())) {
//	                                                        	 //상조회인경우 처리   
//	                                                        	   
//	                                                        	   payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(payr0410.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                             
//	                                                               
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn()))  {  
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                            	   tpDducTotAmnt = tpDducTotAmnt.add(payr0410.getPymtDducSum());
//	                                                               }   
//	                                                        	   
//	                                                               strDducPayr0520.add(payr0410.getPayrImcd());  
//	                                                        	   
//	                                                           } else if (ExtermsProps.getProps("PAY_DDUC_CD_95004").equals(payr0410.getPayrImcd())) {
//	                                                        	 //노조회비 인경우 처리 
//	                                                        	   
//	                                                        	   payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(payr0410.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                               
//	                                                               
//	                                                               BigDecimal dducSumRate = (payr0410.getPymtDducRate());
//	                                                               BigDecimal dducSum = BigDecimal.ZERO;
//	                                                               
//	                                                               dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                
//	                                                               payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               
//	                                                              if ( payr0410.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn())) {
//	                                                           	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                           		   
//	                                                                     payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                     tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
//	                                                           	   }   
//	                                                               }  
//	                                                        	   strDducPayr0520.add(payr0410.getPayrImcd());  
//	                                                           }
//	                                                            
//	                                                           
//	                                                       } else {
//	                                                           //공제를 제외한 수당 인서트  
//	                                                           if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0410.getPayrImcd())) {
//	                                                            //기본급처리 루틴 근무일수 /실근무일수가 다른경우처리 루틴 추가    
//	                                                        	   //기본급  - 병가관련데이터 처리 하는 부분 추가 
//	                                                               BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급
//	                                                               BigDecimal dayPayAmt = BigDecimal.ZERO; //기본급일액
//	                                                               
//	                                                               BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
//	                                                               
//	                                                               BigDecimal abnceNumDysAmt  = BigDecimal.ZERO; //결근금액 
//	                                                              
//	                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                 
//	                                                            
//	                                                                if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                	
//	                                                                	 if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
//	                                                                         
//	                                                                         mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                        
//	                                                                        // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
//	                                                                        // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
//	                                                                      
//	                                                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                        		 .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
//	                                                                        				 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//	                                                                         
//	                                                                     }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
//	                                                                       
//	                                                                         dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                         
//	                                                                     } else {
//	                                                                         
//	                                                                         dayPaySum = BigDecimal.ZERO;
//	                                                                     }
//		                                                                //결근이 존재하는 경우 결근 빼기 - 시급통상임금 구해서 처리 해야 함. 그러기 위해서 다시 정의 해야 함. 
//		                                                               //  payCalculationVo.getDilnlazAbnceNumDys()   /** column 근태_결근일수 : dilnlazAbnceNumDys */
//		                                                                abnceNumDysAmt = (new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))
//		                                                                                .multiply(payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal(ConstGeoJe.PAYR_BASS_WKTM_GJ_01)));  // USALY_AMNT_HRWG_QNTY 시급통상임금 
//		                                                                
//	                                                                } else {
//	                                                                	
//	                                                                	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
//	                                                                          
//	                                                                          mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                         
//	                                                                         // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
//	                                                                         // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
//	                                                                       
//	                                                                          dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                        		  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
//	                                                                          
//	                                                                      }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
//	                                                                        
//	                                                                          dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                          
//	                                                                      } else {
//	                                                                          
//	                                                                          dayPaySum = BigDecimal.ZERO;
//	                                                                      }
//	                                                                }
//	                                                                
//	                                                                payr0302Vo.setPymtDducSum(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));   /** column 지급공제금액 : pymtDducSum */
//	                                                                payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                               
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));
//	                                                               // tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                tpStdPymtTotAmnt= tpStdPymtTotAmnt.add(payr0302Vo.getPymtDducSum());   //기본급
//	                                                                
//	                                                                if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                	payCalculationService.insertPayr0302(payr0302Vo);
//	                                                                }	
//	                                                               
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0410.getPayrImcd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                
//	                                                                BigDecimal dayFmyPayAmt = BigDecimal.ZERO; //일급계산 
//	                                                                BigDecimal dayFreeFmyPayAmt = BigDecimal.ZERO; //일급프리금액 
//	                                                                 
//	                                                                
//	                                                                if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                //결근은 가족수당을 제외하지 않음.
//	                                                                	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
//			                                                               		if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//			                                                               			
//			                                                               		dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP)) 
//			                                                               				.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
//			                                                               				.add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//			                                                               	
//			                                                               		} else {
//			                                                               		  dayFmyPayAmt = BigDecimal.ZERO;
//			                                                               	  
//			                                                               		}
//			                                                               		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//					                                                            
//			                                                               			dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//			                                                               					            .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
//			                                                               					            .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//			                                                               		
//			                                                               		} else {
//			                                                               			dayFreeFmyPayAmt =  BigDecimal.ZERO;
//			                                                               		} 
//			                                                               }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
//			                                                                 
//			                                                            	   dayFmyPayAmt = tpFamyExtpySum;
//			                                                            	   dayFreeFmyPayAmt = tpFamyFreeExtpySum;
//			                                                               } else {
//			                                                                   
//			                                                            	   dayFmyPayAmt = BigDecimal.ZERO;
//			                                                            	   dayFreeFmyPayAmt =  BigDecimal.ZERO;
//			                                                               }
//	                                                                } else {
//	                                                                
//			                                                              if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
//			                                                               		if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//			                                                               		
//			                                                               			dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//			                                                               					         .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
//			                                                               					         .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
//			                                                               			
//			                                                               		} else {
//			                                                               		  dayFmyPayAmt = BigDecimal.ZERO;
//			                                                               	  
//			                                                               		}
//			                                                               		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//			                                                               			
//					                                                               		dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//					                                                               				    .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
//					                                                               				    .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
//			                                                               		
//			                                                               		} else {
//			                                                               			dayFreeFmyPayAmt =  BigDecimal.ZERO;
//			                                                               		} 
//			                                                               }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
//			                                                                 
//			                                                            	   dayFmyPayAmt = tpFamyExtpySum;
//			                                                            	   dayFreeFmyPayAmt = tpFamyFreeExtpySum;
//			                                                               } else {
//			                                                                   
//			                                                            	   dayFmyPayAmt = BigDecimal.ZERO;
//			                                                            	   dayFreeFmyPayAmt =  BigDecimal.ZERO;
//			                                                               }
//	                                                                }
//	                                                               //가족수당  C9050100  
//	                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(dayFmyPayAmt);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(dayFmyPayAmt.subtract(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt)));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                   
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(dayFmyPayAmt);
//	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayFmyPayAmt);
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt));
//	                                                               
//	                                                                  if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                		  payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                	  }
//	                                                                   } 
//	                                                                  
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0410.getPayrImcd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                               //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
//	                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */  
//	                                                               payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                              
//	            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                              
//	                                                               // B0050001    B005    0001    과세
//	                                                               // B0050002    B005    0002    비과세
//	                                                               // B0050003    B005    0003    부분과세
//	                                                                
//	                                                               if (ExtermsProps.getProps("PAY_CALC_TX_B005_02").equals(payr0410.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_01").equals(payr0410.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_03").equals(payr0410.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               } else {
//	                                                            	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                               }
//	                                                          
//	                                                               
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
//	                                                                 
//	                                                                
//	                                                                  if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                		  payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                	  }	  
//	                                                                   } 
//	                                                           
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_04").equals(payr0410.getPayrImcd())) {
//	                                                             //선임인력수당 -직채수당인경우 처리 루틴          
//	                                                             //직책별 수당  
//	                                                                payr0460Vo = new InfcPayr0460VO();
//	                  
//	                                                                payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
//	                                                                payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
//	                                                                payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
//	                                                                payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
//	                                                             
//	                                                                payr0460Vo = payCalculationService.selectPayr0460(payr0460Vo);
//	                                                               
//	                                                               if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
//	                                                                   
//	                                                                   payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                   payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                   payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                   payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducSum(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(payr0460Vo.getOdtyDtilOccuClsSum().subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                   
//	                                                                   
//	                                                                   tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {     
//	                                                                	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                   }
//	                                                               } 
//	                                                                      
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_50").equals(payr0410.getPayrImcd())) {
//	                                                             // 근속가산금 - 비호봉제   
//	                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {    
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                               }  
//	                     
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_51").equals(payr0410.getPayrImcd())) {
//	                                                             //정근수당 -비호봉제 
//	                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {    
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                 
//	                                                               } 
//	                                                               
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_52").equals(payr0410.getPayrImcd())) {
//	                                                             //장기근속수당 - 비호봉제 
//	                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                               }  
//	                                                               
//	                                                           } else {
//	                                                                
//	                                                        	 // if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() 
//	                                                        		//	  : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { //
//		                                                               /** 각수당별로 처리하는 로직을구현한다. */
//		                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//		                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//		                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//		                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//		                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                               payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//		                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                               payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		            //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//		            //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//		            //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//		            //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//		            //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//		            //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//		                                                                
//		                                                                 // if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
//		                                                                      if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
//		                                                                            
//		                                                                          if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
//		                                                                                //시간외근무  -USALY_AMNT_HRWG_QNTY 계산된 시급으로 정리한다. 통상시급 
//		                                                                                  BigDecimal ucstSum = payr0410.getUsalyAmntHrwgQnty(); //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//		                                                                                
//		                                                                                  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//		                                                                                	  ucstSum =  payr0410.getUsalyAmntHrwgQnty();  //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//		                                                                                  } 
//		                                                                                  
//		                                                                                  BigDecimal totTmSum = BigDecimal.ZERO;
//		                                                                                  
//		                                                                                  totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//		                                                                                  
//		                                                                                  
//		                                                                                  payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//		                                                                                  payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                                                                                  
//		                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//		                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//		                                                                                  
//		                                                                                  if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//		                                                                                      tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//		                                                                                  }
//		                                                                                  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
//		                                                                                	  payCalculationService.insertPayr0302(payr0302Vo);   
//		                                                                                  }	  
//		                                                                            }
//		                                                                            
//		                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
//		                                                                        // 토요근무수당   --일수산정C9410700 USALY_AMNT_PDY_QNTY
//		                                                                    	  
//		                                                                         if (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0) {
//		                                                                        	 
//		                                                                              BigDecimal ucstSum = payr0410.getUsalyAmntPdyQnty(); //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//		                                                                              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                                                	  ucstSum = payr0410.getUsalyAmntPdyQnty(); //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                  } 
//		                                                                              BigDecimal totTmSum = BigDecimal.ZERO;
//		                                                                              
//		                                                                              totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//		                                                                              
//		                                                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//		                                                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                                                                              
//		                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//		                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//		                                                                              
//		                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//		                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//		                                                                              }
//		                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
//		                                                                            	  payCalculationService.insertPayr0302(payr0302Vo);    
//		                                                                              }
//		                                                                          }
//		                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
//		                                                                       // 야간수당       -- 시간산정C9410300 MNTH_USALY_AMNT_WAG
//		                                                                          if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
//		                                                                        	  
//		                                                                              BigDecimal ucstSum = ((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 3)).multiply(new BigDecimal("0.5"))).setScale(0,BigDecimal.ROUND_DOWN);//payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//		                                                                              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                                                	  ucstSum = ((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 3)).multiply(new BigDecimal("0.5"))).setScale(0,BigDecimal.ROUND_DOWN);//payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                  } 
//		                                                                              BigDecimal totTmSum = BigDecimal.ZERO;
//		                                                                              
//		                                                                              totTmSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotNtotTm(),"0"))).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//		                                                                               
//		                                                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//		                                                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                                                                               
//		                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//		                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//		                                                                              
//		                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//		                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//		                                                                              }
//		                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//		                                                                            	  payCalculationService.insertPayr0302(payr0302Vo); 
//		                                                                              }	  
//		                                                                          }
//		                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
//		                                                                        // 휴일수당        -- 일수 C9410200
//		                                                                          if (MSFSharedUtils.paramNotNull(payCalculationVo.getDilnlazPubcHodyDutyNumDys())) {
//		                                                                        	  
//		                                                                              if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0) {
//		                                                                            	  
//		                                                                                  BigDecimal ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//		                                                                                  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//		                                                                                	  ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//		                                                                                  } 
//		                                                                                  BigDecimal totTmSum = BigDecimal.ZERO;
//		                                                                                  
//		                                                                                  totTmSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0"))).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//		                                                                                  
//		                                                                                  payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//		                                                                                  payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                                                                                  
//		                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//		                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//		                                                                                  
//		                                                                                  if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//		                                                                                      tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//		                                                                                  }
//		                                                                                  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//		                                                                                	  payCalculationService.insertPayr0302(payr0302Vo); 
//		                                                                                  }	  
//		                                                                              }
//		                                                                          }   
//		                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
//		                                                                          // 유급휴일수당  -- 일수 산정 C9415000
//		                                                                          if (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0) {
//		                                                                             
//		                                                                              BigDecimal ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//		                                                                              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                                                	  ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                  } 
//		                                                                              BigDecimal totTmSum = BigDecimal.ZERO;
//		                                                                              
//		                                                                              totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//		                                                                              
//		                                                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//		                                                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                                                                              
//		                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//		                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//		                                                                              
//		                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//		                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//		                                                                              }
//		                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//		                                                                            	  payCalculationService.insertPayr0302(payr0302Vo);    
//		                                                                              }	  
//		                                                                          }
//		                                                                      } else   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0410.getPayrImcd())) {
//		                                                                            //PAY_EMYMT_PYMT_18 = "C9080100";    // 정액급식비
//		                                                                    	      BigDecimal dayPaySum = BigDecimal.ZERO; 
//	                                                                                  BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                              
//	                                                                                  if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                                      //결근은 정액급식비 을 제외 급여모자랄시  
//	                                                                                	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
//		                                                                                       
//		                                                                                	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//		                                                                                			     .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
//		                                                                                			    		 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                                                      
//		                                                                                  }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
//		                                                                                    
//		                                                                                      dayPaySum = ucstSum.setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                                                      
//		                                                                                  } else {
//		                                                                                      
//		                                                                                      dayPaySum = BigDecimal.ZERO;
//		                                                                                  } 
//	                                                                                  } else { 
//		                                                                                  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
//		                                                                                       
//		                                                                                	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP)).multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
//		                                                                                	   .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                                                      
//		                                                                                  }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
//		                                                                                    
//		                                                                                      dayPaySum = ucstSum.setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                                                      
//		                                                                                  } else {
//		                                                                                      
//		                                                                                      dayPaySum = BigDecimal.ZERO;
//		                                                                                  } 
//	                                                                                  }
//	                                                                                  payr0302Vo.setPymtDducSum(dayPaySum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                  
//	                                                                                  if (dayPaySum.compareTo(payr0410.getFreeDtySum()) >= 0) {
//		                                                                                  payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                                                  payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                  
//		                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
//		                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                                  } else {
//	                                                                                	  
//	                                                                                	  payr0302Vo.setPymtDducFreeDtySum(dayPaySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                                                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                  
//		                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
//		                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(dayPaySum); 
//	                                                                                  }
//	                                                                                  if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                      tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayPaySum);
//	                                                                                  }
//	                                                                                  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                                	  payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                                  }
//		                                                                     
//		                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0410.getPayrImcd())) {
//		                                                                          // PAY_EMYMT_PYMT_24 = "C9410600";    // 연가보상비
//		                                                                          if (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0) {
//		                                                                             
//		                                                                              BigDecimal ucstSum =   payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                 
//		                                                                              BigDecimal totTmSum = BigDecimal.ZERO;
//		                                                                              
//		                                                                              totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys())).multiply(ucstSum)).setScale(-1, BigDecimal.ROUND_DOWN);  //토요근무수당 
//		                                                                              
//		                                                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//		                                                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                                                                              
//		                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//		                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//		                                                                              
//		                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//		                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//		                                                                              }
//		                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//		                                                                            	  payCalculationService.insertPayr0302(payr0302Vo);    
//		                                                                              }	  
//		                                                                          }
//		                                                                      } else {
//		                                                                    	  if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() 
//		                                                                  			  : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { //
//				                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
//				                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
//				                                                                          
//				                                                                          if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//				                                                                              tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//				                                                                          }
//				                                                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//				                                                                        	  payCalculationService.insertPayr0302(payr0302Vo);   
//				                                                                          }	
//		                                                                    	  }       
//		                                                                      }
//		                                                                        
//		                                                                  // }  
//		                                                                 
//		                                                    //       } 
//	                                                           }   
//	                                                       }  
//	                                                       
//	                                                    } 
//	                                                     
//	                                               }  //
//	                                            
//	                                               /**
//	                                                * 지급 금액이 없는 경우 보험등을 계산하지 않음.
//	                                                */
//	                                          if(tpPymtTotAmnt.compareTo(BigDecimal.ZERO) > 0) { 
//		                                               //항목에 없는 데이터 인서트 (공제)
//		                                               for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//		                                                   
//		                                                    boolean payr0520chk = true; 
//		                                                    payr0520Vo  = new InfcPayr0520VO();
//		                                                   // payr0200Vo = (Payr0200VO) listPayr0200.get(iCnt);
//		                                                    BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt)); 
//		                                                    
//		                                                    for (int iduCnt = 0; iduCnt < strDducPayr0520.size(); iduCnt++) {
//		                                                        
//		                                                        if (strDducPayr0520.get(iduCnt).equals(payr0520Vo.getPayItemCd())) {
//		                                                            payr0520chk = false ;
//		                                                        } 
//		                                                    } 
//		                                                   
//		                                                    if (payr0520chk) {
//		                                                        
//		                                                    	 if (payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0) {	
//			                                                        payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//			                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//			                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//			                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//			                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//			                                                        payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//			                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//			                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//			                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//			                                                        payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//			                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//			                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//			                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//			            //                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//			            //                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//			            //                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//			            //                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//			            //                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//			            //                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//			                                                        if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//			                                                        	payCalculationService.insertPayr0302(payr0302Vo);  
//			                                                        
//			                                                        	tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));  
//			                                                        }
//		                                                    	 } else {
//		                                                    		//금액이 아닌 비율로 처리 되는 경우 
//	                                                            	 if (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0  ) { 
//	                                                                     
//	                                                                     payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                     payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                     payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                     payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                     payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                     payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                                     payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                     payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                     payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                      
//	                                                                     payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
//	                                                                      
//	                                                                     payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                     payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                     payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//	                                                                     //payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
//	                                                                       //                             .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	     //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	     //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	     //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	     //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	     //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	     //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                     
//	                                                                     BigDecimal dducSumRate =  payr0520Vo.getPymtDducRate() ;
//	                                                                     BigDecimal dducSum = BigDecimal.ZERO;
//	                                                                     
//	                                                                     dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                      
//	                                                                     payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                     
//	                                                                    if (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ) {
//	                                                                 	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                 		   
//	                                                                           payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                 	   }   
//	                                                                     } 
//	                                                                  
//	                                                                     tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
//	                                                                    
//	                                                                 }
//		                                                    	 }   
//		                                                 }  
//		                                               }
//		                                        
//		                                            /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//		                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
//		                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//		                                               
//		                                           //사대보험계산로직추가 에외처리로직 추가 
//		                                               /*########################################################################################*/
//		                                               /**   에외처리로직 추가                                                                                                                                                                      **/
//		                                               /*########################################################################################*/    
//		                                               payr0540SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//		                                               payr0540SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//		                                               payr0540SrhVo.setPymtDt(payr0250Vo.getPymtDt());  //지급구간 
//		                                               payr0540SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
//		                                               //공제테이블 
//		                                               List lisPayr0540 = payCalculationService.selectPayr0540List(payr0540SrhVo);
//		                                               
//		                                               /*########################################################################################*/
//		                                               /**   에외처리로직 추가                                                                                                                                                                      **/
//		                                               /*########################################################################################*/   
//		                                              
//		                                           //기본적으로 계산되어 나오나 값이 없는 경우에는 값을 가지고와서 처리함. 과세대상금액으로 처리 
//		                                            for(int iCnt01 = 0;iCnt01 < insureList.size();iCnt01++) {
//		                                                
//		                                                payrInsrStdVo  = new PayrInsrStdVO();
//		                                               // payrInsrStdVo = (PayrInsrStdVO)insureList.get(iCnt01);
//		                                                BeanUtils.copyProperties(payrInsrStdVo,insureList.get(iCnt01));
//		                                                //건강보험 
//		                                                tpHlthInsrPayAmt = BigDecimal.ZERO;
//		                                                //요양 
//		                                                tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;
//		                                                 //국민연금  
//		                                                tpNatPennAmt = BigDecimal.ZERO;
//		                                                //고용 
//		                                                tpUmytInsrApptnAmt = BigDecimal.ZERO;
//		                                                
//		                                                //보수금액 
//		                                                tpPymtAmnt =  BigDecimal.ZERO;
//		            
//		                                                tpPymtAmnt = tpPymtTotAmnt;  //.subtract(tpDducTotAmnt); //TODO  확인 
//		                                                 tpWorkIncmTxtnSum = tpPymtAmnt;
//		                                                //B013 
//		                                                //건강보험
//		                                                if (payCalculationVo.getHlthInsrApptnYn().equals("Y")) {
//		                                                    
//		                                                        if (payCalculationVo.getHlthInsrApptnYn().equals("Y") &&  payCalculationVo.getHlthInsrMnthRuntnAmnt().compareTo(BigDecimal.ZERO) > 0) {
//		                                                            tpHlthInsrPayAmt = payCalculationVo.getHlthInsrPayAmt();
//		                                                        } else {
//		                                                            //현재금액에서 값을 구한다. 
//		                                                            if (payrInsrStdVo.getHlthInsrBstMnthRuntnAmnt().compareTo(tpPymtAmnt) >= 0) {
//		                                                                tpHlthInsrPayAmt  =  BigDecimal.ZERO;
//		                                                            } else {
//		                                                                tpHlthInsrPayAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getHlthInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//		                                                            }
//		                                                            
//		                                                        } 
//		        
//		                                                        //장기요양 
//		                                                        tpHlthInsrRcptnPayAmt = tpHlthInsrPayAmt.multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//		                                                         
//		                                                        
//		                                                        for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
//		                                                          
//		                                                           // public static final String PAY_DDUC_CD_2 = "D0010100"; //공제 건강보험
//		                                                           // public static final String PAY_DDUC_CD_3 = "D0150100"; //공제 국민보험
//		                                                           // public static final String PAY_DDUC_CD_4 = "D0160100"; //공제 고용보험 
//		                                                           // public static final String PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
//		                                                              
//		                                                            payr0540Vo = new InfcPayr0540VO();
//		                                                            BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
//		                                                            
//		                                                          //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
//		                                                                
//		                                                          //  }
//		                                                          
//		                                                            if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
//		                                                                // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)  
//		                                                                tpHlthInsrPayAmt = BigDecimal.ZERO; //건강 
//		                                                                tpHlthInsrRcptnPayAmt = BigDecimal.ZERO; //장기
//		                                                                
//		                                                            } else if (ExtermsProps.getProps("PAY_INSR_ETC_CD_03").equals(payr0540Vo.getExptnDivCd())) {
//		                                                                // public static final String PAY_INSR_ETC_CD_03 = "B0130005";  // 건강보험면제(50%) 
//		                                                                BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
//		                                                                
//		                                                                if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
//		                                                                    tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
//		                                                                    tpHlthInsrPayAmt = tpHlthInsrPayAmt.multiply(tpPayPerAmt).setScale(-1, 2);
//		                                                                } else {
//		                                                                    tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
//		                                                                    tpHlthInsrPayAmt = tpHlthInsrPayAmt.add(tpPayPerAmt).setScale(-1, 2) ;
//		                                                                }  
//		                                                                
//		                                                            } 
//		                                                             
//		                                                           
//		                                                        }
//		                                                        
//		                                                        
//		                                                        for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
//		                                                             
//		                                                             payr0540Vo = new InfcPayr0540VO();
//		                                                             BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
//		                                                             
//		                                                             if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
//		                                                                 // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)   
//		                                                                 tpHlthInsrRcptnPayAmt = BigDecimal.ZERO; //장기
//		                                                                 
//		                                                             } else {
//		                                                               
//		                                                                 if (ExtermsProps.getProps("PAY_INSR_ETC_CD_04").equals(payr0540Vo.getExptnDivCd())) {
//		                                                                     //  public static final String PAY_INSR_ETC_CD_04 = "B0130007";  // 노인장기요양보험면제(30%)   
//		                                                                     //장기요양 
//		                                                                     tpHlthInsrRcptnPayAmt = tpHlthInsrPayAmt.multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//		                                                                     
//		                                                                     BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
//		                                                                     
//		                                                                     if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
//		                                                                         
//		                                                                         tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
//		                                                                         tpHlthInsrRcptnPayAmt = tpHlthInsrRcptnPayAmt.multiply(tpPayPerAmt).setScale(-1, 2);
//		                                                                     } else {
//		                                                                         tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
//		                                                                         tpHlthInsrRcptnPayAmt = tpHlthInsrRcptnPayAmt.add(tpPayPerAmt).setScale(-1, 2) ;
//		                                                                     }   
//		                                                                     
//		                                                                 }
//		                                                             }    
//		                                                          
//		                                                            
//		                                                         }
//		                                                         //건강보험 
//		                                                        payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//		                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                        payr0302Vo.setPayItemCd("D0010100");   /** column 급여항목코드 : payItemCd */
//		                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//		                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//		                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                        payr0302Vo.setPymtDducSum(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//		                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//		                //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//		                //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//		                //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//		                //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//		                //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//		                                                        
//		                                                        if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  { 
//		                                                        	payCalculationService.insertPayr0302(payr0302Vo);  
//		                                                        
//		                                                           tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN)); 
//		                                                        }
//		                                                       //건강보험 -요양 
//		                                                       payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//		                                                       payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                       payr0302Vo.setPayItemCd("D0110100");   /** column 급여항목코드 : payItemCd */
//		                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//		                                                       payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//		                                                       payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                       payr0302Vo.setPymtDducSum(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//		                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                //                                                      payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//		                //                                                      payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//		                //                                                      payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//		                //                                                      payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//		                //                                                      payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//		                //                                                      payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//		                                                         
//		                                                       if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {    
//		                                                    	   payCalculationService.insertPayr0302(payr0302Vo); 
//		                                                      
//		                                                           tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));
//		                                                       }    
//		                                                } 
//		                                                
//		                                                //국민연금  
//		                                                if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
//		                                                        if (payCalculationVo.getNatPennApptnYn().equals("Y") &&  payCalculationVo.getNatPennAmt().compareTo(BigDecimal.ZERO) > 0) {
//		                                                            
//		                                                              tpNatPennAmt = payCalculationVo.getNatPennAmt().setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                        } else {
//		                                                            //현재금액에서 값을 구한다. 
//		                                                            if (payrInsrStdVo.getNatPennMinmIncmMnthAmnt().compareTo(tpPymtAmnt) >= 0) {
//		                                                                tpNatPennAmt  =  BigDecimal.ZERO;
//		                                                            } else {
//		                                                                //국민연금 기준소득월액 상하향 조정 2015 270000 - 4210000    
//		                                                            	//                  2016 280000  - 4340000 
//		                                                            	
////		                                                                if (tpPymtAmnt.compareTo(new BigDecimal("250000")) <= 0) {
////		                                                                    
////		                                                                    tpNatPennAmt = (new BigDecimal("250000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
////		                                                                    
////		                                                               } else  if (tpPymtAmnt.compareTo(new BigDecimal("3980000")) >= 0) {
////		                                                                   
////		                                                                   tpNatPennAmt = (new BigDecimal("3980000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
////		                                                                   
////		                                                               } else {
////		                                                                   tpNatPennAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
////		                                                               }
//		                                                                
//	                                                                   if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("280000")) <= 0) {
//		                                                                    
//		                                                                    tpNatPennAmt = (new BigDecimal("280000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                                    
//		                                                               } else  if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("4340000")) >= 0) {
//		                                                                   
//		                                                                   tpNatPennAmt = (new BigDecimal("4340000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                                   
//		                                                               } else {
//		                                                                   tpNatPennAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//		                                                               }
//		                                                            }
//		                                                            
//		                                                        }
//		                                                        
//		                                                        for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
//		                                                             
//		                                                           
//		                                                               
//		                                                             payr0540Vo = new InfcPayr0540VO();
//		                                                             BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
//		                                                             
//		                                                           //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
//		                                                                 
//		                                                           //  }
//		                                                           
//		                                                             if (ExtermsProps.getProps("PAY_INSR_ETC_CD_01").equals(payr0540Vo.getExptnDivCd())) {
//		                                                                 // public static final String  PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
//		                                                                 tpNatPennAmt = BigDecimal.ZERO;
//		                                                             }  
//		                                                              
//		                                                            
//		                                                         }
//		                                                        
//		                                                        //국민연금 
//		                                                        payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//		                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                        payr0302Vo.setPayItemCd("D0150100");   /** column 급여항목코드 : payItemCd */
//		                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//		                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//		                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                        payr0302Vo.setPymtDducSum(tpNatPennAmt);   /** column 지급공제금액 : pymtDducSum */
//		                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//		                //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//		                //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//		                //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//		                //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//		                //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//		                                                          
//		                                                        if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  { 
//		                                                        	payCalculationService.insertPayr0302(payr0302Vo);  
//		                                                        	tpDducTotAmnt = tpDducTotAmnt.add(tpNatPennAmt);
//		                                                        }
//		                                                }
//		                                                
//		                                                if (payCalculationVo.getUmytInsrApptnYn().equals("Y")) {
//		                                                    
//		                                                    //고용보험  
//		                                                    if (payCalculationVo.getUmytInsrApptnYn().equals("Y") &&  payCalculationVo.getUmytInsrPayMnthAmnt().compareTo(BigDecimal.ZERO) > 0) {
//		                                                        tpUmytInsrApptnAmt = payCalculationVo.getUmytInsrPayMnthAmnt().setScale(-1, BigDecimal.ROUND_DOWN);
//		                                                      } else {
//		                                                          //현재금액에서 값을 구한다. 
//		                                                        if (payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().compareTo(tpPymtAmnt) >= 0) {
//		                                                            tpUmytInsrApptnAmt  =  BigDecimal.ZERO;
//		                                                        } else {
//		                                                            tpUmytInsrApptnAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//		                                                      }
//		                                                          
//		                                                      } 
//		                                                       
//		                                                        //고용보험  
//		                                                       payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//		                                                       payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                       payr0302Vo.setPayItemCd("D0160100");   /** column 급여항목코드 : payItemCd */
//		                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//		                                                       payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//		                                                       payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                       payr0302Vo.setPymtDducSum(tpUmytInsrApptnAmt);   /** column 지급공제금액 : pymtDducSum */
//		                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//		                //                                                      payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//		                //                                                      payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//		                //                                                      payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//		                //                                                      payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//		                //                                                      payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//		                //                                                      payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//		                                                          
//		                                                       if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {   
//		                                                    	   payCalculationService.insertPayr0302(payr0302Vo);   
//		                                                    	   tpDducTotAmnt = tpDducTotAmnt.add(tpUmytInsrApptnAmt);
//		                                                       }
//		                                                 }
//		                                            }  
//	                                          }      
//	                                         
//		                                           /**===============================================================================================
//		                                            * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//		                                            * 과세대상금액, 비과세금액 처리 함. 
//		                                            ================================================================================================*/ 
//		                                            InfcPayr0307VO  payr0307SrhVo = new InfcPayr0307VO();
//		                                            
//		                                            payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                            payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//		                                            payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                            payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                            payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                            
//		                                            List<InfcPayr0307VO> listPayr0307Vo = payCalculationService.selectPayr0307All(payr0307SrhVo); 
//		                                            
//		                                            for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//		                                            
//		                                                    InfcPayr0307VO  payr0307Vo = new InfcPayr0307VO();  //PAYR0307-조정내역처리를 위해 추가됨  
//		                                                    payr0307Vo = listPayr0307Vo.get(i307Cnt);
//		                                                    
//		                                                    //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
//		                                                    if  (MSFSharedUtils.paramNotNull(payr0307Vo) && MSFSharedUtils.paramNotNull(payr0307Vo.getSystemkey())) {
//		                                                        
//		                                                        payr0302Vo.setDpobCd(payr0307Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                        payr0302Vo.setPymtYrMnth(payr0307Vo.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//		                                                        payr0302Vo.setPayCd(payr0307Vo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                        payr0302Vo.setPayrSeilNum(payr0307Vo.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                        payr0302Vo.setSystemkey(payr0307Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                        payr0302Vo.setPayItemCd(payr0307Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//		                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//		                                                        payr0302Vo.setPymtDducDivCd(payr0307Vo.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//		                                                        payr0302Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                        payr0302Vo.setPymtDducSum(payr0307Vo.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
//		                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                        payr0302Vo.setPayReattyAdmntVal(String.valueOf(payr0307Vo.getMnthPayAdmntSeilNum()));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                        payr0302Vo.setPymtDducTxtnAmnt(payr0307Vo.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//		        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//		        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//		        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//		        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//		                                                        payCalculationService.insertPayr0302(payr0302Vo);
//		                                                        
//		                                                        if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
//		                                                            //과세금액 및 공제등 금액 처리 
//		                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//		                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//		                                                            
//		                                                        } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
//		                                                            //과세금액 및 공제등 금액 처리 
//		                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//		                                                            tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
//		                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//		                                                            
//		                                                        } else {
//		                                                            tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
//		                                                        } 
//		                                                        
//		                                                    }
//		                                            }
//		                                            /**===============================================================================================
//		                                             * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//		                                             * 과세대상금액, 비과세금액 처리 종료 
//		                                             ================================================================================================*/
//	                                           
//		                                            /**===============================================================================================
//		                                             * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//		                                             * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//		                                             ================================================================================================*/
//		                                            
//		                                          //  if ("201504".equals(payr0250Vo.getJobYrMnth()))
//		                                          
//			                                        InfcInsr3100SrhVO  infcInsr3100SrhVO = new InfcInsr3100SrhVO(); 
//		                                            
//			                                        infcInsr3100SrhVO.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//			                                        infcInsr3100SrhVO.setNofctYrMnthNum(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : nfctYrMnthNum */ 
//			                                        infcInsr3100SrhVO.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                            
//		                                            InfcInsr3100VO  infcInsr3100VO = new InfcInsr3100VO();
//		                                            
//		                                            infcInsr3100VO = payCalculationService.selectInsr0200Data(infcInsr3100SrhVO); 
//		                                            
//		                                         //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//		                                            
//		                                            	    
//		                                            //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
//		                                                    
////		                                        	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
////		                                        	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
////		                                        	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
////		                                        	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
//		                                            
//		                                            
//		                                                if  (MSFSharedUtils.paramNotNull(infcInsr3100VO) && MSFSharedUtils.paramNotNull(infcInsr3100VO.getSystemkey())) { 
//															
//															 //공제금액처리 건강보험관련  
//															if (infcInsr3100VO.getMbrAlttHlth().compareTo(BigDecimal.ZERO) != 0) {
//																
////					                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
//															    /** column 연말정산보험료 : yrtxPrmm */ 
//						                                            
//																payr0302Vo.setDpobCd(infcInsr3100VO.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//		                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_0102"));    /** column 급여항목코드 : payItemCd */
//		                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//		                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
//		                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                        payr0302Vo.setPymtDducSum(infcInsr3100VO.getMbrAlttHlth());    /** column 지급공제금액 : pymtDducSum */
//		                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//		        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//		        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//		        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//		        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//		                                                        payCalculationService.insertPayr0302(payr0302Vo); 
//			                                                        
//			                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttHlth()); //공제합계 
//			                                                    
//															}  
//															
//															if (infcInsr3100VO.getMbrAlttLgtmRcptn().compareTo(BigDecimal.ZERO) != 0) {
////					                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
//																 /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */ 
//																
//																payr0302Vo.setDpobCd(infcInsr3100VO.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//		                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//		                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//		                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_1102"));    /** column 급여항목코드 : payItemCd */
//		                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//		                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
//		                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//		                                                        payr0302Vo.setPymtDducSum(infcInsr3100VO.getMbrAlttLgtmRcptn());    /** column 지급공제금액 : pymtDducSum */
//		                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//		                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//		                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//			        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//			        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//			        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//			        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//			        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//			        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//			                                                    payCalculationService.insertPayr0302(payr0302Vo); 
//			                                                        
//			                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttLgtmRcptn()); //공제합계 
//															}
//		                                                    
////		                                                    if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////																//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
//////					                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
////																  /** column 건강환급금이자 : hlthInsrRefdItrt */
////															
////																payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////		                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////		                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////		                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////		                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////		                                                        payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
////		                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////		                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////		                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////		                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////		                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////		                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////		                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////			        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////			        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////			        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////			        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////			        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////			        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////		                                                        payCalculationService.insertPayr0302(payr0302Vo);  
////		                                                        tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
////		                                                    }    
////		                                                    if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//////					                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
////																  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
////																 
////																payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////		                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////		                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////		                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////		                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////		                                                        payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
////		                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////		                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////		                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////		                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////		                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////		                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////		                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////			        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////			        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////			        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////			        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////			        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////			        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////			                                                    payCalculationService.insertPayr0302(payr0302Vo); 
////			                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
////		                                                    }
//		                                                }
//		                                          //  } 
//		                                        	
//		                                        	 /**===============================================================================================
//		                                             * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//		                                             * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//		                                             ================================================================================================*/
//	                                        	
//	                                          //월급여내역 합계를 구한다. 
//	                                            // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
//	                                            
//	                                           tpTxtnTotAmnt =  tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt); 
//	                                           //과세대상금액 
//	                                           tpWorkIncmTxtnSum = BigDecimal.ZERO; //과세대상금액  
//	                                           txTotAmnt =  BigDecimal.ZERO;    //과세합계
//	                                           
//	                                           tpWorkIncmTxtnSum = tpTxtnTotAmnt;    //tpTxtnTotAmnt.subtract(tpSchlExpnAdmclExtpySum); //비과세,학자금을 제외한 금액 
//	                                           
//	                                           if ("201506".compareTo(payr0250Vo.getJobYrMnth()) < 0) {
//	                                    		   //소득세/지방소득세  
//	                                               txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn2015( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
//	                                    	   } else {
//	                                    		   //무기계약직 소득세/지방소득세 
//	                                               txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt); 
//	                                    	   }  
//	                                         
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */  
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
//	                                           payr0301Vo.setPayCd(payCalculationVo.getPayCd());         
//	                                           payr0301Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
//	                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
//	                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
//	                                           payr0301Vo.setTxtnTotAmnt(tpTxtnTotAmnt);   
//	                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
//	                                           payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
//	                                           payr0301Vo.setTxTotAmnt(txTotAmnt);     
//	                                           payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
//	                                           payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
//	                                           payr0301Vo.setPayDdlneDt("");    
//	                                           payr0301Vo.setPayDdlneYn("N");   
//	                                           
//	                                           payCalculationService.updatePayr0301(payr0301Vo); //월급여내역  
//	                                            
//	                                        } else if (ExtermsProps.getProps("PAY_CD_02").equals(payr0250Vo.getPayCd())) {
//	                                            /**
//	                                             *   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                               * @@@@@@@@@@@@@@@@@@@@@@ 복리후생비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                               *  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                               */ 
//	                                            // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다.  
//	                                            payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                            payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                            payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                            payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                            payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                            payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                            payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                            payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                            payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                            payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                            payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                            payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                            payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                            payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                            payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                            payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                            payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                            payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                            payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                   payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                   payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                   payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                   payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                   payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                   payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                            
//	                                            
//	                                            payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                            
//	                                            /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                             *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                               @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                            Set<InfcPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
//	                                         
//	                                            Iterator<InfcPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
//	                                            
//	                                            while ( iterpayr0410Set.hasNext() ) { 
//	                                                
//	                                                  InfcPayr0410VO payr0410 = iterpayr0410Set.next();
//	                                             
//	                                                 if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                     
//	                                                    /**
//	                                                     *     //C9410100 시간외수당
//	                                                     *     //C9410200 휴일수당  
//	                                                     */ 
//	                                                     /** 각수당별로 처리하는 로직을구현한다. */
//	                                                     payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                     payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                     payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                     payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                     payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                     payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                     payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                     payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                     payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                     payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                     payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                     payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                     payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                      
//	                                                        if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                            if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
//	                                                                 
//	                                                        
//	                                                                if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                      //시간외근무 
//	                                                                    
//	                                                                        BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                        if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                                      	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                        } 
//	                                                                        BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                        
//	                                                                        totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                        
//	                                                                        
//	                                                                        payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                        payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                        
//	                                                                        tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                        tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                        
//	                                                                        if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                            tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                        }
//	                                                                        
//	                                                                        payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                  }
//	                                                                  
//	                                                            } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
//	                                                              // 토요근무수당  --일수산정C9410700
//	                                                                
//	                                                                BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                              	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                } 
//	                                                                BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                
//	                                                                totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                                
//	                                                                payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                
//	                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                }
//	                                                                
//	                                                                payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                
//	                                                                
//	                                                            } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
//	                                                             // 야간수당       -- 시간산정C9410300
//	                                                                
//	                                                                BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                              	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                } 
//	                                                                BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                
//	                                                                totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotNtotTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                 
//	                                                                payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                 
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                
//	                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                }
//	                                                                
//	                                                                payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                
//	                                                            } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
//	                                                              // 휴일수당        -- 일수 C9410200
//	                                                                
//	                                                                BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                              	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                } 
//	                                                                BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                
//	                                                                totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                                
//	                                                                payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                
//	                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                }
//	                                                                
//	                                                                payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                
//	                                                            } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
//	                                                                // 유급휴일수당  -- 일수 산정 C9415000
//	                                                                    
//	                                                                BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                              	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                } 
//	                                                                BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                
//	                                                                
//	                                                                totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                                
//	                                                                payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                
//	                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                }
//	                                                                
//	                                                                payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                
//	                                                            } else {
//	                                                                
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                
//	                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                }
//	                                                                
//	                                                                payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                            }
//	                                                              
//	                                                         }   
//	                                                             
//	                                               }  
//	                                            }
//	                                             
//	                                            payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                            payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                            payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                            payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                            payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                            payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
//	                                            payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
//	                                            payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
//	                                            payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                            payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                            payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                            payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                            payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
//	                                            payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                            payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                            payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                            payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                            payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                            payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                   payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                   payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                   payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                   payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                   payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                   payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                            
//	                                            payCalculationService.updatePayr0301(payr0301Vo); 
//	                                            
//	                                            /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                             *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                               @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
//	                                               
//	                                       } else if (ExtermsProps.getProps("PAY_CD_03").equals(payr0250Vo.getPayCd())) {
//	                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           * @@@@@@@@@@@@@@@@@@@@@@ 월급여 2회차 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           */ 
//	                                             
//	                                                           // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다. 
//	                        
//	                                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                                           payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                                           payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                                           payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                                           payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                                           payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	                        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                                           
//	                                                           payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                                            
//	                                                           /*########################################################################################*/
//	                                                           /**  가족수당/학비보조수당    시작                                                                                                                                                               **/
//	                                                           /*########################################################################################*/  
//	                                                           Set<InfcPayr0530VO> payr0530Set = payCalculationVo.getExPayr0530();
//	                                                           
//	                                                           Iterator<InfcPayr0530VO> iterpayr0530Set = payr0530Set!=null ? payr0530Set.iterator()  : null;
//	                                                           
//	                                                           while (iterpayr0530Set.hasNext() ) {
//	                                                               
//	                                                               InfcPayr0530VO payr0530 = iterpayr0530Set.next(); 
//	                        
//	                                                               payr0306Vo.setDpobCd(payr0530.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0306Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());     /** column 지급년월 : pymtYrMnth */          
//	                                                               payr0306Vo.setSystemkey(payCalculationVo.getSystemkey());            /** column SYSTEMKEY : systemkey */   
//	                                                               payr0306Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
//	                                                               payr0306Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//	                                                               payr0306Vo.setPayFamyRsptSeilNum(payr0530.getPayFamyRsptSeilNum());    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
//	                                                               payr0306Vo.setPayFamyResnRegnNum(payr0530.getPayFamyResnRegnNum());   /** column 급여가족주민번호 : payFamyResnRegnNum */ 
//	                                                               payr0306Vo.setHanNm(payr0530.getHanNm());                 /** column 한글성명 : hanNm */  
//	                                                               payr0306Vo.setFamyRelaDivCd(payr0530.getFamyExtpyDivCd());       /** column 가족관계구분코드 : famyRelaDivCd */    
//	                                                               payr0306Vo.setFamyAllwPymtYn(payr0530.getFamyAllwPymtYn());     /** column 가족수당지급여부 : famyAllwPymtYn */    
//	                                                               payr0306Vo.setChdnChdRrgEpnsPymtYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
//	                                                               payr0306Vo.setFndtnDducYn(payr0530.getFndtnDducYn());        /** column 기본공제여부 : fndtnDducYn */     
//	                                                               payr0306Vo.setSpueDducYn(payr0530.getSpueDducYn());          /** column 배우자공제여부 : spueDducYn */    
//	                                                               payr0306Vo.setWmnDducYn(payr0530.getWmnDducYn());              /** column 부녀자공제여부 : wmnDducYn */
//	                                                               payr0306Vo.setRftaGvstDducYn(payr0530.getRftaGvstDducYn());         /** column 경로우대공제여부 : rftaGvstDducYn */
//	                                                               payr0306Vo.setDabpnDducYn(payr0530.getDabpnDducYn());            /** column 장애자공제여부 : dabpnDducYn */ 
//	                                                               payr0306Vo.setSgpnFmlyDducYn(payr0530.getSgpnFmlyDducYn());           /** column 한가족공제여부 : sgpnFmlyDducYn */
//	                                                               payr0306Vo.setChdnChdRrgEpnsDducYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
//	                                                               payr0306Vo.setFamyExtpyDivCd(payr0530.getFamyExtpyDivCd());         /** column 가족수당구분코드 : famyExtpyDivCd */
//	                                                               payr0306Vo.setSchlExpnAdmclExtpyDivCd(payr0530.getSchlExpnAdmclExtpyDivCd());   /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
//	                                                               
//	                                                               if ("Y".equals(payr0530.getFamyAllwPymtYn())) {
//	                                                                   payr0306Vo.setFamyExtpySum(payr0530.getFamyExtpySum());     /** column 가족수당금액 : famyExtpySum */
//	                                                               } else {
//	                                                                   payr0306Vo.setFamyExtpySum(BigDecimal.ZERO);                  /** column 가족수당금액 : famyExtpySum */
//	                                                               }
//	                                                               
//	                                                               if ((payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                                       && (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                                       && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) ) {
//	                                                                   payr0306Vo.setSchlExpnAdmclExtpySum(payr0530.getSchlExpnAdmclExtpySum());     /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
//	                                                            
//	                                                               } else {
//	                                                               
//	                                                                   payr0306Vo.setSchlExpnAdmclExtpySum(BigDecimal.ZERO);
//	                                                                   
//	                                                               }
//	                                                               
//	                                                               if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
//	                                                                       (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                                       && (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                                       && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
//	                                                            	 
//		                                                            	   
//		                                                                   // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
//		                                                                   if  ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
//		                                                                	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
//		                                                                	  
//		                                                                	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
//		                                                                		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
//		                                                                	   }
//		                                                                   }
//	                                                                       //가족수당 합
//	                                                                       tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
//	                                                                       //학비보조금함계
//	                                                                       tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum());
//	        
//	                                                                       InfcPayr0306VO tpPayr0306Vo = new InfcPayr0306VO();
//	                                                                       tpPayr0306Vo = payCalculationService.selectPayr0306(payr0306Vo);  
//	                                                                       
//	                                                                       if (MSFSharedUtils.paramNull(tpPayr0306Vo)) { 
//	                                                                           
//	                                                                           payCalculationService.insertPayr0306(payr0306Vo); 
//	                                                                           
//	                                                                       } else {
//	                                                                           
//	                                                                           payCalculationService.updatePayr0306(payr0306Vo); 
//	                                                                       }
//	                                                               }  
//	                                                               
//	                                                           }
//	                                                           
//	                                                           if ("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn()) ) {
//	                                                               //TODO 추가시 지급여부 3명이상인경우인경우 처리 
//	                                                                 //tpFamyExtpySum = tpFamyExtpySum.ad());
//	                                                               
//	                                                            }  
//	                                                          /*########################################################################################*/
//	                                                          /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
//	                                                          /*########################################################################################*/  
//	                                                    
//	                                                        
//	                                                        /*########################################################################################*/
//	                                                        /**  공제관련 항목  시작                                                                                                                                                                         **/
//	                                                        /*########################################################################################*/    
//	                        //                                payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                        //                                payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                        //                                payr0520SrhVo.setPymtDt(payr0250Vo.getPymtDt());  //지급구간 
//	                        //                                payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
//	                        //                                //공제테이블 
//	                        //                                List listDducPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                                          
//	                                                        /*########################################################################################*/
//	                                                        /**  공제관련 항목  가져오기                                                                                                                                                                    **/
//	                                                        /*########################################################################################*/     
//	                                                        
//	                                                          
//	                                                          /*########################################################################################*/
//	                                                          /**  수당관련 항목  시작                                                                                                                                                                         **/
//	                                                          /*########################################################################################*/    
//	                                                          payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                                                          payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                                                          payr0520SrhVo.setPymtDt(payr0250Vo.getPymtDt());  //지급구간 
//	                                                          payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_02"));
//	                                                          //공제테이블 
//	                                                          List listPymtPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                                            
//	                                                          /*########################################################################################*/
//	                                                          /**  공제관련 항목  가져오기                                                                                                                                                                       **/
//	                                                          /*########################################################################################*/  
//	                                                          
//	                                                          /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                           *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                                             @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                                          Set<InfcPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
//	                                                       
//	                                                          Iterator<InfcPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
//	                                                          
//	                                                          while ( iterpayr0410Set.hasNext() ) { 
//	                                                              
//	                                                                InfcPayr0410VO payr0410 = iterpayr0410Set.next();
//	                                                           
//	                                                                if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                                  
//	                                                                  //공제 처리 루틴  
//	                                                                  if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0410.getPymtDducDivCd())) {
//	                                                                      
//	                        //                                              iDducCnt = 0;
//	                        //                                              for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//	                        //                                                  
//	                        //                                                   payr0520Vo  = new Payr0520VO();
//	                        //                                                       
//	                        //                                                   BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
//	                        //                                                   
//	                        //                                                 
//	                        //                                                   
//	                        //                                                   if (payr0520Vo.getPayItemCd().equals(payr0410.getPayrImcd())) {
//	                        //                                                    
//	                        //                                                           if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { 
//	                        //                                                                
//	                        //                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                        //                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                        //                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                        //                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                        //                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                        //                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                        //                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                        //                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                        //                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                        //                                                               payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()));   /** column 지급공제금액 : pymtDducSum */
//	                        //                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                        //                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                        //                                                               payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
//	                        //                                                                                              .subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        ////                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        ////                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        ////                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        ////                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        ////                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        ////                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                        //                                                               
//	                        //                                                              if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
//	                        //                                                                     payCalculationService.insertPayr0302(payr0302Vo);  
//	                        //                                                               } 
//	                        //                                                            
//	                        //                                                               tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()));
//	                        //                                                              
//	                        //                                                           }  
//	                        //                                                           strDducPayr0520.add(payr0410.getPayrImcd());  
//	                        //                                                          
//	                        //                                                       }   
//	                        //                                                  }
//	                                                                       
//	                                                                      
//	                                                                  } else {
//	                                                                      //공제를 제외한 수당 인서트  
//	                                                                      if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0410.getPayrImcd())) {
//	                                                                       //기본급처리 루틴 근무일수 /실근무일수가 다른경우처리 루틴 추가    
//	                                                                          
//	                                                                          BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급
//	                                                                          BigDecimal dayPayAmt = BigDecimal.ZERO; //기본급일액
//	                                                                          
//	                                                                          BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
//	                                                                          
//	                                                                          BigDecimal abnceNumDysAmt  = BigDecimal.ZERO; //결근금액 
//
//	                                                                         
//	                                                                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                          payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                          payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                           
//	                                                                          
//	                                                                       //    if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
//	                                                                             if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
//	             	                                                                //결근이 존재하는 경우 결근 빼기 
//	                                                                            	 mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                                 //dayPayAmt =  mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()))).setScale(-1, 1);
//	                                                                                 //dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())));
//	                                                                                 dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                                		 .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
//	                                                                                				 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//	             	                                                               //  payCalculationVo.getDilnlazAbnceNumDys()   /** column 근태_결근일수 : dilnlazAbnceNumDys */
//	             	                                                                abnceNumDysAmt = (new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))
//	             	                                                                                .multiply(payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal(ConstGeoJe.PAYR_BASS_WKTM_GJ_01)));  // USALY_AMNT_HRWG_QNTY 시급통상임금 
//	             	                                                                
//	                                                                             } else {    
//	                                                                            	 
//	                                                                               mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                               //dayPayAmt =  mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()))).setScale(-1, 1);
//	                                                                               //dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())));
//	                                                                               dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                            		   .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
//
//	                                                                             }
//	                                                                               
//	                                                                               payr0302Vo.setPymtDducSum(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));   /** column 지급공제금액 : pymtDducSum */
//	                                                                               payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                             
//	                                                                         
//	                                                                        //   }  else {
//	                                                                               
//	                                                                        //       dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                        //   }
//	                                                                          
//	                                                                               
//	                                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));
//	                                                                              // tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
//	                                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                               tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(payr0302Vo.getPymtDducSum()) ;
//	                                                                               
//	                                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                            	   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                               }   
//	                                                                          
//	                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0410.getPayrImcd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                    	  //가족수당  C9050100  
//	                                                                    	  BigDecimal dayFmyPayAmt = BigDecimal.ZERO; //일급계산 
//	                                                                          BigDecimal dayFreeFmyPayAmt = BigDecimal.ZERO; //일급프리금액 
//	                                                                    
//	                                                                       if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                              //결근은 가족수당을 제외하지 않음.
//	                                                                    		if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//	                                                                         		  dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                         				            .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
//	                                                                         				            .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//	                                                                         		} else {
//	                                                                         		  dayFmyPayAmt = BigDecimal.ZERO;
//	                                                                         	  
//	                                                                         		}
//	                                                                         		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//	          		                                                               		dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	          		                                                               				.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
//	          		                                                               						.add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//	                                                                         		} else {
//	                                                                         			dayFreeFmyPayAmt =  BigDecimal.ZERO;
//	                                                                         		}
//	                                                                    	   
//	                                                                        } else {
//	                                                                     // if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
//	                                                                       		if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//	                                                                       		  dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                       				  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
//	                                                                       		} else {
//	                                                                       		  dayFmyPayAmt = BigDecimal.ZERO;
//	                                                                       	  
//	                                                                       		}
//	                                                                       		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
//	        		                                                               		dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP)) 
//	        		                                                               				.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
//	                                                                       		} else {
//	                                                                       			dayFreeFmyPayAmt =  BigDecimal.ZERO;
//	                                                                       		}
//	                                                                        }
//	                                                                      // }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
//	                                                                         
//	                                                                    	//   dayFmyPayAmt = tpFamyExtpySum;
//	                                                                    	//   dayFreeFmyPayAmt = tpFamyFreeExtpySum;
//	                                                                      // } else {
//	                                                                           
//	                                                                    	//   dayFmyPayAmt = BigDecimal.ZERO;
//	                                                                    	//   dayFreeFmyPayAmt =  BigDecimal.ZERO;
//	                                                                      // } 
//	                                                                      
//	                                                                       payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                       payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                       payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                       payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                       payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                       payr0302Vo.setPymtDducSum(dayFmyPayAmt);   /** column 지급공제금액 : pymtDducSum */
//	                                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                       payr0302Vo.setPymtDducTxtnAmnt(dayFmyPayAmt.subtract(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt)));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                    //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                    //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                    //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                    //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                    //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                    //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                           
//	                                                                        tpPymtTotAmnt = tpPymtTotAmnt.add(dayFmyPayAmt);
//	                                                                        tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayFmyPayAmt);
//	                                                                        tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt));
//	                                                                       
//	                                                                          if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                        	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                        		  payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                        	  }	  
//	                                                                           }  
//	                                                                             
//	                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0410.getPayrImcd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                          //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
//	                                                                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                          payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                          payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                         
//	                                                                          
//	                                                                          if ("B0050002".equals(payr0410.getTxtnDivCd())) {
//	                                                                              payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                              payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                                          } else  if ("B0050001".equals(payr0410.getTxtnDivCd())) {
//	                                                                              payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                              payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                              tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                                          } else  if ("B0050003".equals(payr0410.getTxtnDivCd())) {
//	                                                                              payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                              payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                          } else {
//	                                                                       	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                              payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                              tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                                          }
//	                                                                     
//	                                                                          
//	                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
//	                                                                            
//	                                                                           
////	                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
////	                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum);
////	                                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                           
//	                                                                             if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                            	 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                            		 payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                            	 }	 
//	                                                                              } 
//	                                                                      
//	                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_04").equals(payr0410.getPayrImcd())) {
//	                                                                        //선임인력수당 -직채수당인경우 처리 루틴          
//	                                                                        //직책별 수당  
//	                                                                           payr0460Vo = new InfcPayr0460VO();
//	                             
//	                                                                           payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
//	                                                                           payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                           payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
//	                                                                           payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
//	                                                                           payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
//	                                                                        
//	                                                                           payr0460Vo = payCalculationService.selectPayr0460(payr0460Vo);
//	                                                                          
//	                                                                          if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
//	                                                                              
//	                                                                              payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                              payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                              payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                              payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                              payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                              payr0302Vo.setPymtDducSum(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                              payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                              payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                              payr0302Vo.setPymtDducTxtnAmnt(payr0460Vo.getOdtyDtilOccuClsSum().subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                              
//	                                                                              
//	                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                              tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
//	                                                                            	  payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                              } 
//	                                                                          } 
//	                                                                                 
//	                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_50").equals(payr0410.getPayrImcd())) {
//	                                                                        // 근속가산금   
//	                                                                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                          payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                          payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                          
//	                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                        	  payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                          } 
//	                                
//	                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_51").equals(payr0410.getPayrImcd())) {
//	                                                                        //정근수당
//	                                                                          
//	                                                                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                          payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                          payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                          
//	                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                        	  payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                          } 
//	                                                                          
//	                                                                          
//	                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_52").equals(payr0410.getPayrImcd())) {
//	                                                                        //장기근속수당 
//	                                                                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                          payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                          payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                          
//	                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
//	                                                                        	  payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                            
//	                                                                          }
//	                                                                      } else {
//	                                                                           
//	                                                                          /** 각수당별로 처리하는 로직을구현한다. */
//	                                                                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                          payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                          payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                           
//	                                                                             if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                                 if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
//	                                                                                      
//	                                                                             
//	                                                                                     if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                                           //시간외근무 
//	                                                                                         
//	                                                                                             BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                            		 //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                                             BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                                             
//	                                                                                             totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                                             
//	                                                                                             
//	                                                                                             payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                             payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                             
//	                                                                                             tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                                             tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                                             
//	                                                                                             if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                                 tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                                             }
//	                                                                                             if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
//	                                                                                            	 payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                                             }	 
//	                                                                                       }
//	                                                                                       
//	                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
//	                                                                                   // 토요근무수당   --일수산정C9410700
//	                                                                                     
//	                                                                                     BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                     BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                                     
//	                                                                                     totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                                                     
//	                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                     
//	                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                                     
//	                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                                     }
//	                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                                    	 payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                                     }
//	                                                                                     
//	                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
//	                                                                                  // 야간수당       -- 시간산정C9410300
//	                                                                                     
//	                                                                                     BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                     BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                                     
//	                                                                                     totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotNtotTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                                      
//	                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                      
//	                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                                     
//	                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                                     }
//	                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                                    	 payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                                     }
//	                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
//	                                                                                   // 휴일수당        -- 일수 C9410200
//	                                                                                     
//	                                                                                     BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                     BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                                     
//	                                                                                     totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                                                     
//	                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                     
//	                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                                     
//	                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                                     }
//	                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                                    	 payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                                     }
//	                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
//	                                                                                     // 유급휴일수당  -- 일수 산정 C9415000
//	                                                                                         
//	                                                                                     BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                     BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                                     
//	                                                                                     totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                                                     
//	                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                     
//	                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                                     
//	                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                                     }
//	                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                                    	 payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                                     }
//	                                                                                 } else   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0410.getPayrImcd())) {
//	     	                                                                            //PAY_EMYMT_PYMT_18 = "C9080100";    // 정액급식비
//	     	                                                                    	      BigDecimal dayPaySum = BigDecimal.ZERO; 
//	                                                                                       BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                                      
//	                                                                                       if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                                           //결근은 정액급식비 을 제외 급여모자랄시  
//	                                                                                    	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                                    			   .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
//	                                                                                    					   .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                                       } else { 
//	                                                                                      // if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
//	                                                                                           dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//	                                                                                        		   .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
//	                                                                                        		   .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                                           
//	                                                                                      // }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
//	                                                                                         
//	                                                                                       //    dayPaySum = ucstSum;
//	                                                                                           
//	                                                                                       //} else {
//	                                                                                           
//	                                                                                       //    dayPaySum = BigDecimal.ZERO;
//	                                                                                       //} 
//	                                                                                       } 
//	                                                                                       
//	                                                                                       if (dayPaySum.compareTo(payr0410.getFreeDtySum()) >= 0) {
//	     	                                                                                  payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	     	                                                                                  payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                       
//	     	                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
//	     	                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                                       } else {
//	                                                                                     	  
//	                                                                                     	  payr0302Vo.setPymtDducFreeDtySum(dayPaySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	     	                                                                                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                                       
//	     	                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
//	     	                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(dayPaySum); 
//	                                                                                       }
//	                                                                                       
//	                                                                                       if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayPaySum);
//	                                                                                       }
//	                                                                                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                                    	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                                                       }
//	                                                                                 } else {
//	                                                                                     
//	                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                                     
//	                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                                     }
//	                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                                    	 	payCalculationService.insertPayr0302(payr0302Vo);   
//	                                                                                     }	 	
//	                                                                                 }
//	                                                                                   
//	                                                                              }  
//	                                                                            
//	                                                                      } 
//	                                                                       
//	                                                                  }  
//	                                                                  
//	                                                               } 
//	                                                                
//	                                                          }  //
//	                                                          
//	                                                          //항목에 없는 데이터 인서트 (공제)
//	                        //                                  for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//	                        //                                      
//	                        //                                       boolean payr0520chk = true; 
//	                        //                                       payr0520Vo  = new Payr0520VO();
//	                        //                                      // payr0200Vo = (Payr0200VO) listPayr0200.get(iCnt);
//	                        //                                       BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
//	                        //                                       
//	                        //                                       
//	                        //                                       for (int iduCnt = 0; iduCnt < strDducPayr0520.size(); iduCnt++) {
//	                        //                                           
//	                        //                                           if (strDducPayr0520.get(iduCnt).equals(payr0520Vo.getPayItemCd())) {
//	                        //                                               payr0520chk = false ;
//	                        //                                           } 
//	                        //                                       }
//	                        //                                       
//	                        //                                      
//	                        //                                       if (payr0520chk) {
//	                        //                                           
//	                        //                                           payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                        //                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                        //                                           payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                        //                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                        //                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                        //                                           payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                        //                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                        //                                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                        //                                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                        //                                           payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
//	                        //                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                        //                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                        //                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                        ////                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                        ////                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                        ////                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        ////                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                        ////                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                        ////                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                        //                                            
//	                        //                                       payCalculationService.insertPayr0302(payr0302Vo);  
//	                        //
//	                        //                                       tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum());  
//	                        //                                       
//	                        //                                    }  
//	                        //                                  }
//	                                                   
//	                                                       /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                       *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                                         @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                                          
//	                                                          
//	                                                          //사대보험계산로직추가 에외처리로직 추가 
//	                                                              /*########################################################################################*/
//	                                                              /**   에외처리로직 추가                                                                                                                                                                      **/
//	                                                              /*########################################################################################*/    
//	                                                              payr0540SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                                                              payr0540SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                                                              payr0540SrhVo.setPymtDt(payr0250Vo.getPymtDt());  //지급구간 
//	                                                              payr0540SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
//	                                                              //공제테이블 
//	                                                              List lisPayr0540 = payCalculationService.selectPayr0540List(payr0540SrhVo);
//	                                                              
//	                                                              /*########################################################################################*/
//	                                                              /**   에외처리로직 추가                                                                                                                                                                      **/
//	                                                              /*########################################################################################*/   
//	                                                          //기본적으로 계산되어 나오나 값이 없는 경우에는 값을 가지고와서 처리함. 과세대상금액으로 처리 
//	             	                                            for(int iCnt01 = 0;iCnt01 < insureList.size();iCnt01++) {
//	             	                                                
//	             	                                                payrInsrStdVo  = new PayrInsrStdVO();
//	             	                                               // payrInsrStdVo = (PayrInsrStdVO)insureList.get(iCnt01);
//	             	                                                BeanUtils.copyProperties(payrInsrStdVo,insureList.get(iCnt01));
//	             	                                                //건강보험 
//	             	                                                tpHlthInsrPayAmt = BigDecimal.ZERO;
//	             	                                                //요양 
//	             	                                                tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;
//	             	                                                 //국민연금  
//	             	                                                tpNatPennAmt = BigDecimal.ZERO;
//	             	                                                //고용 
//	             	                                                tpUmytInsrApptnAmt = BigDecimal.ZERO;
//	             	                                                
//	             	                                                //보수금액 
//	             	                                                tpPymtAmnt =  BigDecimal.ZERO;
//	             	            
//	             	                                                tpPymtAmnt = tpPymtTotAmnt;  //.subtract(tpDducTotAmnt); //TODO  확인 
//	             	                                                 tpWorkIncmTxtnSum = tpPymtAmnt;
//	             	                                                //B013 
//	             	                                                //건강보험
//	             	                                                if (payCalculationVo.getHlthInsrApptnYn().equals("Y")) {
//	             	                                                    
//	             	                                                        if (payCalculationVo.getHlthInsrApptnYn().equals("Y") &&  payCalculationVo.getHlthInsrMnthRuntnAmnt().compareTo(BigDecimal.ZERO) > 0) {
//	             	                                                            tpHlthInsrPayAmt = payCalculationVo.getHlthInsrPayAmt();
//	             	                                                        } else {
//	             	                                                            //현재금액에서 값을 구한다. 
//	             	                                                            if (payrInsrStdVo.getHlthInsrBstMnthRuntnAmnt().compareTo(tpPymtAmnt) >= 0) {
//	             	                                                                tpHlthInsrPayAmt  =  BigDecimal.ZERO;
//	             	                                                            } else {
//	             	                                                                tpHlthInsrPayAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getHlthInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	             	                                                            }
//	             	                                                            
//	             	                                                        } 
//	             	        
//	             	                                                        //장기요양 
//	             	                                                        tpHlthInsrRcptnPayAmt = tpHlthInsrPayAmt.multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	             	                                                         
//	             	                                                        
//	             	                                                        for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
//	             	                                                          
//	             	                                                           // public static final String PAY_DDUC_CD_2 = "D0010100"; //공제 건강보험
//	             	                                                           // public static final String PAY_DDUC_CD_3 = "D0150100"; //공제 국민보험
//	             	                                                           // public static final String PAY_DDUC_CD_4 = "D0160100"; //공제 고용보험 
//	             	                                                           // public static final String PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
//	             	                                                              
//	             	                                                            payr0540Vo = new InfcPayr0540VO();
//	             	                                                            BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
//	             	                                                            
//	             	                                                          //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
//	             	                                                                
//	             	                                                          //  }
//	             	                                                          
//	             	                                                            if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
//	             	                                                                // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)  
//	             	                                                                tpHlthInsrPayAmt = BigDecimal.ZERO; //건강 
//	             	                                                                tpHlthInsrRcptnPayAmt = BigDecimal.ZERO; //장기
//	             	                                                                
//	             	                                                            } else if (ExtermsProps.getProps("PAY_INSR_ETC_CD_03").equals(payr0540Vo.getExptnDivCd())) {
//	             	                                                                // public static final String PAY_INSR_ETC_CD_03 = "B0130005";  // 건강보험면제(50%) 
//	             	                                                                BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
//	             	                                                                
//	             	                                                                if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
//	             	                                                                    tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
//	             	                                                                    tpHlthInsrPayAmt = tpHlthInsrPayAmt.multiply(tpPayPerAmt).setScale(-1, 2);
//	             	                                                                } else {
//	             	                                                                    tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
//	             	                                                                    tpHlthInsrPayAmt = tpHlthInsrPayAmt.add(tpPayPerAmt).setScale(-1, 2) ;
//	             	                                                                }  
//	             	                                                                
//	             	                                                            } 
//	             	                                                             
//	             	                                                           
//	             	                                                        }
//	             	                                                        
//	             	                                                        
//	             	                                                        for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
//	             	                                                             
//	             	                                                             payr0540Vo = new InfcPayr0540VO();
//	             	                                                             BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
//	             	                                                             
//	             	                                                             if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
//	             	                                                                 // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)   
//	             	                                                                 tpHlthInsrRcptnPayAmt = BigDecimal.ZERO; //장기
//	             	                                                                 
//	             	                                                             } else {
//	             	                                                               
//	             	                                                                 if (ExtermsProps.getProps("PAY_INSR_ETC_CD_04").equals(payr0540Vo.getExptnDivCd())) {
//	             	                                                                     //  public static final String PAY_INSR_ETC_CD_04 = "B0130007";  // 노인장기요양보험면제(30%)   
//	             	                                                                     //장기요양 
//	             	                                                                     tpHlthInsrRcptnPayAmt = tpHlthInsrPayAmt.multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	             	                                                                     
//	             	                                                                     BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
//	             	                                                                     
//	             	                                                                     if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
//	             	                                                                         
//	             	                                                                         tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
//	             	                                                                         tpHlthInsrRcptnPayAmt = tpHlthInsrRcptnPayAmt.multiply(tpPayPerAmt).setScale(-1, 2);
//	             	                                                                     } else {
//	             	                                                                         tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
//	             	                                                                         tpHlthInsrRcptnPayAmt = tpHlthInsrRcptnPayAmt.add(tpPayPerAmt).setScale(-1, 2) ;
//	             	                                                                     }   
//	             	                                                                     
//	             	                                                                 }
//	             	                                                             }    
//	             	                                                          
//	             	                                                            
//	             	                                                         }
//	             	                                                         //건강보험 
//	             	                                                        payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	             	                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	             	                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	             	                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	             	                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	             	                                                        payr0302Vo.setPayItemCd("D0010100");   /** column 급여항목코드 : payItemCd */
//	             	                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	             	                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	             	                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	             	                                                        payr0302Vo.setPymtDducSum(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	             	                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	             	                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	             	                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	             	                //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	             	                //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	             	                //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	             	                //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	             	                //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	             	                //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	             	                                                        
//	             	                                                        if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  { 
//	             	                                                        	payCalculationService.insertPayr0302(payr0302Vo);  
//	             	                                                        
//	             	                                                           tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN)); 
//	             	                                                        }
//	             	                                                       //건강보험 -요양 
//	             	                                                       payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	             	                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	             	                                                       payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	             	                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	             	                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	             	                                                       payr0302Vo.setPayItemCd("D0110100");   /** column 급여항목코드 : payItemCd */
//	             	                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	             	                                                       payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	             	                                                       payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	             	                                                       payr0302Vo.setPymtDducSum(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	             	                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	             	                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	             	                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	             	                //                                                      payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	             	                //                                                      payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	             	                //                                                      payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	             	                //                                                      payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	             	                //                                                      payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	             	                //                                                      payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	             	                                                         
//	             	                                                       if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {    
//	             	                                                    	   payCalculationService.insertPayr0302(payr0302Vo); 
//	             	                                                      
//	             	                                                           tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));
//	             	                                                       }    
//	             	                                                } 
//	             	                                                
//	             	                                                //국민연금  
//	             	                                                if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
//	             	                                                        if (payCalculationVo.getNatPennApptnYn().equals("Y") &&  payCalculationVo.getNatPennAmt().compareTo(BigDecimal.ZERO) > 0) {
//	             	                                                            
//	             	                                                              tpNatPennAmt = payCalculationVo.getNatPennAmt().setScale(-1,BigDecimal.ROUND_DOWN);
//	             	                                                        } else {
//	             	                                                            //현재금액에서 값을 구한다. 
//	             	                                                            if (payrInsrStdVo.getNatPennMinmIncmMnthAmnt().compareTo(tpPymtAmnt) >= 0) {
//	             	                                                                tpNatPennAmt  =  BigDecimal.ZERO;
//	             	                                                            } else {
//	             	                                                                
//	             	                                                                if (tpPymtAmnt.compareTo(new BigDecimal("250000")) <= 0) {
//	             	                                                                    
//	             	                                                                    tpNatPennAmt = (new BigDecimal("250000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	             	                                                                    
//	             	                                                               } else  if (tpPymtAmnt.compareTo(new BigDecimal("3980000")) >= 0) {
//	             	                                                                   
//	             	                                                                   tpNatPennAmt = (new BigDecimal("3980000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	             	                                                                   
//	             	                                                               } else {
//	             	                                                                   tpNatPennAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	             	                                                               }
//	             	                                                                
//	             	                                                            }
//	             	                                                            
//	             	                                                        }
//	             	                                                        
//	             	                                                        for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
//	             	                                                             
//	             	                                                           
//	             	                                                               
//	             	                                                             payr0540Vo = new InfcPayr0540VO();
//	             	                                                             BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
//	             	                                                             
//	             	                                                           //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
//	             	                                                                 
//	             	                                                           //  }
//	             	                                                           
//	             	                                                             if (ExtermsProps.getProps("PAY_INSR_ETC_CD_01").equals(payr0540Vo.getExptnDivCd())) {
//	             	                                                                 // public static final String  PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
//	             	                                                                 tpNatPennAmt = BigDecimal.ZERO;
//	             	                                                             }  
//	             	                                                              
//	             	                                                            
//	             	                                                         }
//	             	                                                        
//	             	                                                        //국민연금 
//	             	                                                        payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	             	                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	             	                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	             	                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	             	                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	             	                                                        payr0302Vo.setPayItemCd("D0150100");   /** column 급여항목코드 : payItemCd */
//	             	                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	             	                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	             	                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	             	                                                        payr0302Vo.setPymtDducSum(tpNatPennAmt);   /** column 지급공제금액 : pymtDducSum */
//	             	                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	             	                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	             	                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	             	                //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	             	                //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	             	                //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	             	                //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	             	                //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	             	                //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	             	                                                          
//	             	                                                        if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  { 
//	             	                                                        	payCalculationService.insertPayr0302(payr0302Vo);  
//	             	                                                        	tpDducTotAmnt = tpDducTotAmnt.add(tpNatPennAmt);
//	             	                                                        }
//	             	                                                }
//	             	                                                
//	             	                                                if (payCalculationVo.getUmytInsrApptnYn().equals("Y")) {
//	             	                                                    
//	             	                                                    //고용보험  
//	             	                                                    if (payCalculationVo.getUmytInsrApptnYn().equals("Y") &&  payCalculationVo.getUmytInsrPayMnthAmnt().compareTo(BigDecimal.ZERO) > 0) {
//	             	                                                        tpUmytInsrApptnAmt = payCalculationVo.getUmytInsrPayMnthAmnt().setScale(-1, BigDecimal.ROUND_DOWN);
//	             	                                                      } else {
//	             	                                                          //현재금액에서 값을 구한다. 
//	             	                                                        if (payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().compareTo(tpPymtAmnt) >= 0) {
//	             	                                                            tpUmytInsrApptnAmt  =  BigDecimal.ZERO;
//	             	                                                        } else {
//	             	                                                            tpUmytInsrApptnAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	             	                                                      }
//	             	                                                          
//	             	                                                      } 
//	             	                                                       
//	             	                                                        //고용보험  
//	             	                                                       payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	             	                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	             	                                                       payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	             	                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	             	                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	             	                                                       payr0302Vo.setPayItemCd("D0160100");   /** column 급여항목코드 : payItemCd */
//	             	                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	             	                                                       payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	             	                                                       payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	             	                                                       payr0302Vo.setPymtDducSum(tpUmytInsrApptnAmt);   /** column 지급공제금액 : pymtDducSum */
//	             	                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	             	                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	             	                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	             	                //                                                      payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	             	                //                                                      payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	             	                //                                                      payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	             	                //                                                      payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	             	                //                                                      payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	             	                //                                                      payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	             	                                                          
//	             	                                                       if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {   
//	             	                                                    	   payCalculationService.insertPayr0302(payr0302Vo);   
//	             	                                                    	   tpDducTotAmnt = tpDducTotAmnt.add(tpUmytInsrApptnAmt);
//	             	                                                       }
//	             	                                                 }
//	             	                                            }  
//	                                                           
//	                                                           /**===============================================================================================
//	                                                            * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                            * 과세대상금액, 비과세금액 처리 함. 
//	                                                            ================================================================================================*/ 
//	                                                           InfcPayr0307VO  payr0307SrhVo = new InfcPayr0307VO();
//	                                                           
//	                                                           payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                           payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                           payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                           payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                           payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                            
//	                                                            List<InfcPayr0307VO> listPayr0307Vo = payCalculationService.selectPayr0307All(payr0307SrhVo); 
//	                                                            
//	                                                            for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//	                                                            
//	                                                                    InfcPayr0307VO  payr0307Vo = new InfcPayr0307VO();  //PAYR0307-조정내역처리를 위해 추가됨  
//	                                                                    payr0307Vo = listPayr0307Vo.get(i307Cnt);
//	                                                                    
//	                                                                    //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
//	                                                                    if  (MSFSharedUtils.paramNotNull(payr0307Vo) && MSFSharedUtils.paramNotNull(payr0307Vo.getSystemkey())) {
//	                                                                        
//	                                                                        payr0302Vo.setDpobCd(payr0307Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                        payr0302Vo.setPymtYrMnth(payr0307Vo.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                                                                        payr0302Vo.setPayCd(payr0307Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                        payr0302Vo.setPayrSeilNum(payr0307Vo.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                        payr0302Vo.setSystemkey(payr0307Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                        payr0302Vo.setPayItemCd(payr0307Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//	                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//	                                                                        payr0302Vo.setPymtDducDivCd(payr0307Vo.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//	                                                                        payr0302Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                        payr0302Vo.setPymtDducSum(payr0307Vo.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
//	                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                        payr0302Vo.setPayReattyAdmntVal(String.valueOf(payr0307Vo.getMnthPayAdmntSeilNum()));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                        payr0302Vo.setPymtDducTxtnAmnt(payr0307Vo.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//	                        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//	                        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//	                        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//	                        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//	                        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//	                        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//	                                                                        payCalculationService.insertPayr0302(payr0302Vo);
//	                                                                        
//	                                                                        if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
//	                                                                            //과세금액 및 공제등 금액 처리 
//	                                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//	                                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//	                                                                            
//	                                                                        } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
//	                                                                            //과세금액 및 공제등 금액 처리 
//	                                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//	                                                                            tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
//	                                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//	                                                                            
//	                                                                        } else {
//	                                                                            tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
//	                                                                        } 
//	                                                                        
//	                                                                    }
//	                                                            }
//	                                                            /**===============================================================================================
//	                                                             * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                             * 과세대상금액, 비과세금액 처리 종료 
//	                                                             ================================================================================================*/      
//	                                                            /**===============================================================================================
//	                                                             * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                             * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//	                                                             ================================================================================================*/
//	                                                            
//	                                                          //  if ("201504".equals(payr0250Vo.getJobYrMnth()))
//	                                                          
////	                                                            Insr0200VO  insr0200SrhVo = new Insr0200VO();
////	                                                           
////	                                                            
////	                                                            insr0200SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                            insr0200SrhVo.setDducYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */ 
////	                                                            insr0200SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                            
////	                                                            Insr0200VO  insr0200Vo = new Insr0200VO();
////	                                                            
////	                                                            insr0200Vo = payCalculationService.selectInsr0200Data(insr0200SrhVo); 
////	                                                            
////	                                                         //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
////	                                                            
////	                                                            	    
////	                                                            //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
////	                                                                    
//////	                                                        	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
//////	                                                        	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
//////	                                                        	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
//////	                                                        	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
////	                                                            
////	                                                            
////	                                                                if  (MSFSharedUtils.paramNotNull(insr0200Vo) && MSFSharedUtils.paramNotNull(insr0200Vo.getSystemkey())) {
////	                                                                      
////	                													
////	                													 //공제금액처리 건강보험관련  
////	                													if (insr0200Vo.getYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
////	                														
//////	                			                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
////	                													    /** column 연말정산보험료 : yrtxPrmm */
////	                														 
////	                				                                            
////	                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_0102"));    /** column 급여항목코드 : payItemCd */
////	                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
////	                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	                        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	                        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	                        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	                        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	                        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	                        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	                                                                        payCalculationService.insertPayr0302(payr0302Vo); 
////	                	                                                        
////	                	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getYrtxPrmm()); //공제합계 
////	                	                                                    
////	                													}  
////	                													
////	                													if (insr0200Vo.getLgtmRcptnYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
//////	                			                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
////	                														 /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */ 
////	                														
////	                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_1102"));    /** column 급여항목코드 : payItemCd */
////	                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
////	                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	                	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	                	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	                	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	                	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	                	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	                	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	                	                                                    payCalculationService.insertPayr0302(payr0302Vo); 
////	                	                                                        
////	                	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnYrtxPrmm()); //공제합계 
////	                													}
////	                                                                    
////	                                                                    if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////	                														//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
//////	                			                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
////	                														  /** column 건강환급금이자 : hlthInsrRefdItrt */
////	                													
////	                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                                        payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
////	                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////	                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	                	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	                	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	                	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	                	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	                	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	                	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	                                                                        payCalculationService.insertPayr0302(payr0302Vo);
////	                                                                        
////	                                                                        
////	                                                                        tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
////	                                                                    }    
////	                                                                    if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//////	                			                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
////	                														  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
////	                														 
////	                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                                        payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
////	                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////	                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	                	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	                	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	                	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	                	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	                	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	                	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	                	                                                    payCalculationService.insertPayr0302(payr0302Vo);
////	                	                                                        
////	                	                                                        
////	                	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
////	                                                                    }
////	                                                                }
////	                                                          //  } 
//	                                                        	
//	                                                        	 /**===============================================================================================
//	                                                             * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                             * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//	                                                             ================================================================================================*/
//	                                                        	
//	                                                     //월급여내역 합계를 구한다. 
//	                                                       // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
//	                                                       
//	                                                      tpTxtnTotAmnt =  tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt); 
//	                                                      //과세대상금액 
//	                                                      tpWorkIncmTxtnSum = BigDecimal.ZERO; //과세대상금액  
//	                                                      txTotAmnt =  BigDecimal.ZERO;    //과세합계
//	                                                      
//	                                                      tpWorkIncmTxtnSum = tpTxtnTotAmnt;  //tpTxtnTotAmnt.subtract(tpSchlExpnAdmclExtpySum); //비과세,학자금을 제외한 금액 
//	                                                      //무기계약직 
//	                                                      if ("201506".compareTo(payr0250Vo.getJobYrMnth()) < 0) {
//	                                               		   //소득세/지방소득세  
//	                                                          txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn2015( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
//		                                               	   } else {
//		                                               		 //소득세/지방소득세 
//		                                                       txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
//		                                               	   }  
//	                                                       
//	                                                      payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */  
//	                                                      payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
//	                                                      payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
//	                                                      payr0301Vo.setPayCd(payCalculationVo.getPayCd());         
//	                                                      payr0301Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());
//	                                                      payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
//	                                                      payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
//	                                                      payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
//	                                                      payr0301Vo.setTxtnTotAmnt(tpTxtnTotAmnt);   
//	                                                      payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
//	                                                      payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
//	                                                      payr0301Vo.setTxTotAmnt(txTotAmnt);     
//	                                                      payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
//	                                                      payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
//	                                                      payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
//	                                                      payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
//	                                                      payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
//	                                                      payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
//	                                                      payr0301Vo.setPayDdlneDt("");    
//	                                                      payr0301Vo.setPayDdlneYn("N");   
//	                                                      
//	                                                      payCalculationService.updatePayr0301(payr0301Vo); //월급여내역   
//	                                      
//	                                       } else if (ExtermsProps.getProps("PAY_CD_04").equals(payr0250Vo.getPayCd())) {
//	                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           * @@@@@@@@@@@@@@@@@@@@@@  명절휴가비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           */  
//	                                           //C9110100  명절휴가비
//	                                           
//	                                           // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다.  
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           
//	                                           payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                           Set<InfcPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
//	                                        
//	                                           Iterator<InfcPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
//	                                           
//	                                           while ( iterpayr0410Set.hasNext() ) { 
//	                                               
//	                                                 InfcPayr0410VO payr0410 = iterpayr0410Set.next();
//	                                            
//	                                                 if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                     
//	                                                           payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                           payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                           payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                           payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                           payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                           payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                           payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                            
//	                                                           tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                           if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                        	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                           }  
//	                                              }  
//	                                           }
//	                                            
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           payCalculationService.updatePayr0301(payr0301Vo); //명정휴가비 
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
//	                                           
//	                                       } else if (ExtermsProps.getProps("PAY_CD_05").equals(payr0250Vo.getPayCd())) {
//	                                         /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           * @@@@@@@@@@@@@@@@@@@@@@  초과근무수당 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           */  
//	                                           // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다.  
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           
//	                                           payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                           Set<InfcPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
//	                                        
//	                                           Iterator<InfcPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
//	                                           
//	                                           while ( iterpayr0410Set.hasNext() ) { 
//	                                               
//	                                                 InfcPayr0410VO payr0410 = iterpayr0410Set.next();
//	                                            
//	                                                 if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                    
//	                                                   /**
//	                                                    *     //C9410100 시간외수당
//	                                                    *     //C9410200 휴일수당  
//	                                                    */ 
//	                                                    /** 각수당별로 처리하는 로직을구현한다. */
//	                                                    payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                    payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                    payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                    payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                    payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                    payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                    payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                    payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                     
//	                                                       if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                           if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
//	                                                                
//	                                                       
//	                                                               if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                     //시간외근무 
//	                                                                   
//	                                                                       BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                                       if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                                     	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                       } 
//	                                                                       //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                       BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                       
//	                                                                       totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                       
//	                                                                       
//	                                                                       payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                       payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                       
//	                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                       
//	                                                                       if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                       }
//	                                                                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                    	   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                       }
//	                                                                 }
//	                                                                 
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
//	                                                             // 토요근무수당   --일수산정C9410700
//	                                                               
//	                                                               BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                               if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                             	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               } 
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                               
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                               
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
//	                                                            // 야간수당       -- 시간산정C9410300
//	                                                               
//	                                                               BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                               if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                             	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               } 
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotNtotTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
//	                                                             // 휴일수당        -- 일수 C9410200
//	                                                               
//	                                                               BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                               if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                             	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               } 
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                               
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
//	                                                               // 유급휴일수당  -- 일수 산정 C9415000
//	                                                                   
//	                                                               BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//	                                                               if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//	                                                             	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               } 
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                               
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                           } else {
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }	   
//	                                                           }
//	                                                             
//	                                                        }   
//	                                                            
//	                                              }  
//	                                           }
//	                                            
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           payCalculationService.updatePayr0301(payr0301Vo);  
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/   
//	                                           
//	                                           
//	                                       } else if (ExtermsProps.getProps("PAY_CD_06").equals(payr0250Vo.getPayCd())) {
//	                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           * @@@@@@@@@@@@@@@@@@@@@@ 연가보상비 C9410600 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           */
//	                                           // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다.  
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           
//	                                           payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                           Set<InfcPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
//	                                        
//	                                           Iterator<InfcPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
//	                                           
//	                                           while ( iterpayr0410Set.hasNext() ) { 
//	                                               
//	                                                 InfcPayr0410VO payr0410 = iterpayr0410Set.next();
//	                                            
//	                                               if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                     
//	                                                	  payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                      payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                      payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                      payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                      payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                      payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                      payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                      payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */  
//	                                                      payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                      payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
//	                                                      payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                      payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                      payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	   //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	   //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	   //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	   //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	   //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	   //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                      
//	                                                      
//	                                                      if (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                          
//	                                                          BigDecimal ucstSum =   payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                           
//	                                                          BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                          
//	                                                          totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys())).multiply(ucstSum)).setScale(-1, BigDecimal.ROUND_DOWN);  //연가보상비 
//	                                                          
//	                                                          payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                          payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                          
//	                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                          
//	                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                        
//	                                                        
//	                                                      } else {
//	                                                   	   
//	                                                   	   payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
//	                                                          payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                          
//	                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(BigDecimal.ZERO); 
//	                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(BigDecimal.ZERO); 
//	                                                          
//	                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(BigDecimal.ZERO);
//	                                                   	   
//	                                                      } 
//	                                                       
//	                                                     // tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()));
//	                                                     // tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()));
//	                                                    //  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
//	                                                      if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                   	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                      }	   	   
//	                                                            
//	                                              }  
//	                                           }
//	                                            
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           payCalculationService.updatePayr0301(payr0301Vo);  
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
//	                                           
//	                                           
//	                                       } else if (ExtermsProps.getProps("PAY_CD_07").equals(payr0250Vo.getPayCd())) {
//	                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           * @@@@@@@@@@@@@@@@@@@@@@ 초과근무수당(12월)   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                           */
//	                                          
//	                                           // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다.  
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           
//	                                           payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                           Set<InfcPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
//	                                        
//	                                           Iterator<InfcPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
//	                                           
//	                                           while ( iterpayr0410Set.hasNext() ) { 
//	                                               
//	                                                 InfcPayr0410VO payr0410 = iterpayr0410Set.next();
//	                                            
//	                                               if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                    
//	                                                   /**
//	                                                    *     //C9410100 시간외수당
//	                                                    *     //C9410200 휴일수당  
//	                                                    */ 
//	                                                    /** 각수당별로 처리하는 로직을구현한다. */
//	                                                    payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                    payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                    payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//	                                                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                    payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                    payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                    payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                    payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                    payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                     
//	                                                       if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                           if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
//	                                                                
//	                                                       
//	                                                               if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
//	                                                                     //시간외근무 
//	                                                                   
//	                                                                       BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                                       BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                                       
//	                                                                       totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                       
//	                                                                       
//	                                                                       payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                                       payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                       
//	                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                                       
//	                                                                       if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                                       }
//	                                                                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                    	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                       }
//	                                                                 }
//	                                                                 
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
//	                                                             // 토요근무수당   --일수산정C9410700
//	                                                               
//	                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                               
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                               
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
//	                                                            // 야간수당       -- 시간산정C9410300
//	                                                               
//	                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotNtotTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
//	                                                                
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
//	                                                             // 휴일수당        -- 일수 C9410200
//	                                                               
//	                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                               
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
//	                                                               // 유급휴일수당  -- 일수 산정 C9415000
//	                                                                   
//	                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//	                                                               BigDecimal totTmSum = BigDecimal.ZERO;
//	                                                               
//	                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
//	                                                               
//	                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);    
//	                                                               }
//	                                                           } else {
//	                                                               
//	                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               
//	                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
//	                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                               }
//	                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            	   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                               }	   
//	                                                           }
//	                                                             
//	                                                        }   
//	                                                            
//	                                              }  
//	                                           }
//	                                            
//	                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
//	                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
//	                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
//	                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
//	                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                           
//	                                           payCalculationService.updatePayr0301(payr0301Vo); //명정휴가비 
//	                                           
//	                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
//	                                           
//	                                           
//	                                       }   
//	                                        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]월급여" ,"처리완료","대상자 : " + payCalculationVo.getHanNm() + "명처리완료 "));
//	                                  } else {//if ((payCalculationVo.getExPayr0410() != null)  && (!payCalculationVo.getExPayr0410().isEmpty()))
//	                                	  bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","무기계약직","급여항목데이터 존재하지 않음.")); 
//	                                  }
//	                            } else {
//	                                //급여대상여부가 불러왔는데 대상자가 아닌경우 처리  조정데이타가 존재하면 삭제 
//	                                InfcPayr0307VO  payr0307SrhVo = new InfcPayr0307VO();
//	                                
//	                                payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                
//	                                payCalculationService.deletePayCalculationPayr0307(payr0307SrhVo); 
//	                            }
//	                          } 
//	                       
//	                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]월급여" ,"처리완료","대상자 : " + String.valueOf(psnlList.size()) + "명처리완료 "));
//	                     
//	                   } else {
//	                     
//	                  /*****************************************************************************************************
//	                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	                    * 기간제근로자 급여 계산 처리 
//	                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~      
//	                    ****************************************************************************************************/ 
//	                       ArrayList strDducPayr0520= new ArrayList();
//	                       //기간제인경우 무기계약직 해당 없음. 
//	                       payr0250Vo.setTypOccuCd(""); 
//	                       payr0250Vo.setPyspGrdeCd("");
//	                       payr0250Vo.setPayrMangDeptYn("");
//	                       
//	                       if  (MSFSharedUtils.paramNull(payr0250Vo.getBusinCd()) ) {
//	                    	   bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]기간제근로자스케줄확인" ,"기간제근로자 사업명 선택에러","기간제근로자의경우 받드시 사업명을 선택하셔야합니다. <br> "
//	                    	   		+ "급여스케줄관리에서 사업명을 선택하신후 급여계산을 다시 하십시요.")); 
//	                    	   throw new Exception();  
//	                       } 
//	                               //인사정보 추출 //근태기록도 같이 가져옴.
//	                               //검색조건 지급년월 기준으로 정보를 가져온다. 
//	                               //근태관리의 근무일수 산정등...데이타 가져오기 결과값.
//	                       
//	                     //권한적용 루틴 추가 
//	                       /** 조건절 */
//	                      // payr0250Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//	                       payr0250Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	                       payr0250Vo.setUsrId(sessionUser.getUsrId());  
//	                        
//	                        
//	                       /******************************** 권한 ************************************************************************/
//	                        
//	                       payr0250Vo.setDeptCdAuth(payr0250Vo.getDeptCd());  //권한처리를위해 추가  
//	                       payr0250Vo.setDtilOccuInttnCdAuth(payr0250Vo.getDtilOccuInttnCd());   
//	              
//	                       //String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	                                if (payr0250Vo.getPayrMangDeptCd().equals(payr0250Vo.getDeptCd())) {  
//	                                	payr0250Vo.setDeptCd("");  //부서코드
//	                                } else {
//	                                	payr0250Vo.setDeptCd(payr0250Vo.getDeptCd());
//	                                    
//	                                } 
//	                        
//	                       /******************************** 권한 ************************************************************************/
//	                       
//	                                
//	                       List<PkgPayrCommCalcVO>  psnlList = payCalculationService.selectPsnlA20PayrInfoList(payr0250Vo); 
//	                               
//	                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여]" + String.valueOf(psnlList.size()) + "명처리중","기간제근로자",""));  
//	                       if (psnlList.size() > 0) { 
//	                                   //직종 // 근속년수 에따른 급여 항목 정보 추출 및 단가표에서 값을 가지고 온다. 
//	                                   //검색조건 - 지급년월, 사용여부 년월에 지급여 
//	                                   payr0410SrhVo.setDpobCd(payr0250Vo.getDpobCd());  //사업장코드 
//	                                   payr0410SrhVo.setPayYr(payr0250Vo.getJobYrMnth().substring(0, 4)); //급여항목년도 
//	                                   
//	                                   //payCalculationService.selectPayrItemUnitInfoList(searchVO);
//	                                    
//	                                   //기간제근로자 
//	                                   payr0300Vo.setDpobCd(payr0250Vo.getDpobCd()); //사업장코드 
//	                                   payr0300Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드 
//	                                   payr0300Vo.setPayrMangDeptCd(payr0250Vo.getPayrMangDeptCd()) ;//단위기관코드 
//	                                   payr0300Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()); 
//	                                   payr0300Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//	                                   payr0300Vo.setPayPymtDt(payr0250Vo.getPymtDt());   //지급일자
//	                                      
//	                                   InfcPayr0300VO  tpPayr0300Vo = new InfcPayr0300VO();
//	                                   
//	                                   tpPayr0300Vo = payCalculationService.selectPayr0300(payr0300Vo); 
//	                                    
//	                                   if (MSFSharedUtils.paramNull(tpPayr0300Vo) 
//	                                   		|| MSFSharedUtils.paramNull(tpPayr0300Vo.getPayPymtDt()))  {
//	                                	   //급여마스터 테이블에 데이터을 인서트한다.  
//	                                       payCalculationService.insertPayr0300(payr0300Vo);
//	                                  }
//	                               
//	                      
//	                               for (int icnt = 0; icnt < psnlList.size();icnt++) { 
//	                            
//	                                   payCalculationVo = new PkgPayrCommCalcVO();
//	                                   payCalculationVo = (PkgPayrCommCalcVO)psnlList.get(icnt);
//	                                   
//	                                   if ("Y".equals(payCalculationVo.getPayRcptYn())) {     
//	                                         
//	                                        /*************************************************************** 
//	                                                                                                급여 계산을 위한 초기화 
//	                                        ****************************************************************/
//	        
//	                                                
//	                                            tpFamyExtpySum = BigDecimal.ZERO;  //가족수당 합 
//	                                            tpFamyFreeExtpySum =  BigDecimal.ZERO;            //가족수당 비과세합계  
//	                                            tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;//학비보조금함계 
//	                                            tpStdPymtTotAmnt= BigDecimal.ZERO;   //기본
//	                                            tpPymtTotAmnt = BigDecimal.ZERO; //pymtTotAmnt 지급총액 
//	                                            tpExtpyTotAmnt = BigDecimal.ZERO;  //extpyTotAmnt 수당총액 
//	                                            tpTxtnTotAmnt = BigDecimal.ZERO;//txtnTotAmnt 과세총액  
//	                                            tpFreeDtyTotAmnt = BigDecimal.ZERO; //freeDtyTotAmnt 비과세총액  
//	                                            tpDducTotAmnt = BigDecimal.ZERO; //dducTotAmnt  공제총액 
//	                                            
//	                                            tpHlthInsrPayAmt = BigDecimal.ZERO;//건강보험  
//	                                            tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;//요양  
//	                                            tpNatPennAmt = BigDecimal.ZERO; //국민연금   
//	                                            tpUmytInsrApptnAmt = BigDecimal.ZERO;  //고용  
//	                                            
//	                                            tpPymtAmnt =  BigDecimal.ZERO;//보수금액  
//	                                            tpWorkIncmTxtnSum =  BigDecimal.ZERO;//과세대상금액 
//	                                             
//	                                             chkMonth = "N";//월 출력체크 
//	                                         
//	                                          
//	                                          
//	                                        if ((payCalculationVo.getExPayr0490() != null)  && (!payCalculationVo.getExPayr0490().isEmpty())) { 
//	                                             
//	                                               /**
//	                                                * @@@@@@@@@@@@@@@@@@@@@@ 월급여 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                */
//	                                               // 월급여내역개인 인서트  
//	                                            	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]" + payCalculationVo.getHanNm() + " 처리중","기간제근로자",""));  
//	                                                payr0304Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
//	                                                payr0304Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
//	                                                payr0304Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
//	                                                payr0304Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                payr0304Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                payr0304Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//	                                                payr0304Vo.setEmymtDivCd(payCalculationVo.getEmymtDivCd());            /** column 고용구분코드 : emymtDivCd */
//	                                                payr0304Vo.setHanNm(payCalculationVo.getHanNm());                      /** column 한글성명 : hanNm */
//	                                                payr0304Vo.setResnRegnNum(payCalculationVo.getResnRegnNum());          /** column 주민등록번호 : resnRegnNum */
//	                                                payr0304Vo.setDeptCd(payCalculationVo.getCurrAffnDeptCd());                    /** column 부서코드 : deptCd */
//	                                                payr0304Vo.setBusinCd(payCalculationVo.getBusinCd());    /** column 사업코드 : businCd */
//	                                                payr0304Vo.setTypOccuCd(payCalculationVo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//	                                                payr0304Vo.setDtilOccuInttnCd(payCalculationVo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//	                                                payr0304Vo.setOdtyCd(payCalculationVo.getOdtyCd());    /** column 직책코드 : odtyCd */
//	                                                payr0304Vo.setPyspCd(payCalculationVo.getPyspCd());    /** column 호봉코드 : pyspCd */
//	                                                payr0304Vo.setPyspGrdeCd(payCalculationVo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//	                                                payr0304Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//	                                                payr0304Vo.setLogSvcMnthIcmCd(payCalculationVo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//	                                                payr0304Vo.setFrstEmymtDt(payCalculationVo.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
//	                                                payr0304Vo.setEmymtBgnnDt(payCalculationVo.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
//	                                                payr0304Vo.setEmymtEndDt(payCalculationVo.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
//	                                                payr0304Vo.setHdofcDivCd(payCalculationVo.getHdofcCodtnCd());    /** column 재직구분코드 : hdofcDivCd */
//	                                                payr0304Vo.setRetryDt(payCalculationVo.getRetryDt());    /** column 퇴직일자 : retryDt */
//	                                                payr0304Vo.setLogSvcStdDt(payCalculationVo.getLogSvcStdDt());    /** column 근속기준일자 : logSvcStdDt */
//	                                                payr0304Vo.setSpueYn(payCalculationVo.getSpueYn());    /** column 배우자유무 : spueYn */
//	                                                payr0304Vo.setSuprtFamyNumTwenChDn(payCalculationVo.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
//	                                                if (("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn())) 
//	                                                         && (payCalculationVo.getSuprtFamyNumTwenChDn().compareTo( new BigDecimal("2")) > 0)) {
//	                                                    payr0304Vo.setSuprtFamyNumTreOvrChdn(payCalculationVo.getSuprtFamyNumTwenChDn().subtract( new BigDecimal("2")) );    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
//	                                                    payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /**TODO  column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySumpayCalculationVo.getSuprtFamy3ChdnExtpySum() */
//	                                                    
//	                                                } else  {
//	                                                    payr0304Vo.setSuprtFamyNumTreOvrChdn(BigDecimal.ZERO);    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */ 
//	                                                    payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//	                                                    
//	                                                }
//	                                                payr0304Vo.setSuprtFamyNumEtc(payCalculationVo.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
//	                                                payr0304Vo.setChdnSchlExpnAdmclYn(payCalculationVo.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
//	                                                payr0304Vo.setHlthInsrGrde(payCalculationVo.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
//	                                                payr0304Vo.setNatPennGrde(payCalculationVo.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
//	                                                payr0304Vo.setMnthPayDlywagSum(BigDecimal.ZERO);    /** column 월급여일당금액 : mnthPayDlywagSum */
//	                                                
//	                                                payr0304Vo.setAddIncmTxApptnRtoCd(payCalculationVo.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
//	                                                payr0304Vo.setAddIncmTxApptnYrMnth(payCalculationVo.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
//	                                              
//	                                                
//	                                                InfcPayr0304VO tpPayr0304Vo = new InfcPayr0304VO();
//	                                                tpPayr0304Vo = payCalculationService.selectPayr0304(payr0304Vo); 
//	                                                
//	                                                if (MSFSharedUtils.paramNull(tpPayr0304Vo)) { 
//	                                                   
//	                                                    payCalculationService.insertPayr0304(payr0304Vo);
//	                                                    
//	                                                } else {
//	                                                    
//	                                                    payCalculationService.updatePayr0304(payr0304Vo);
//	                                                }
//	                                                 
//	                                                /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	                                                 * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
//	                                                 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
//	                                                InfcPayr0304VO tpTxPayr0304Vo = new InfcPayr0304VO();  
//	                                                tpTxPayr0304Vo = payCalculationService.selectPayr0304ToAddIncmTx(payr0304Vo);
//	                                              
//	                                                
//	                                                if (MSFSharedUtils.paramNotNull(tpTxPayr0304Vo)) {
//	                      	                            if (!(MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnRtoCd()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnRtoCd()))
//	                      	                            		&& MSFSharedUtils.allowNulls(tpTxPayr0304Vo.getAddIncmTxApptnYrMnth()).equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth())) 
//	                      	                            		&& "E".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn()))))  {
//	                      	                            
//	                      	                            	if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
//	                      	                                   
//	                      	                            		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0304Vo.getPymtYrMnth()) <= 0) {
//	                      		                                        	
//	                      		                            		InfcPayr0500VO TxPayr0500Vo = new InfcPayr0500VO(); 
//	                      		                                    TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
//	                      		                                    TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
//	                      		                                    TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
//	                      		                                    
//	                      		                                    payCalculationService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
//	                      		                                   //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
//	                      	                            		}   
//	                      	                            	}
//	                      	                            
//	                      	                            } 
//	                                                 } else {
//	                                              	   
//	                                              	   if ("Y".equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYn())) && MSFSharedUtils.paramNotNull(payCalculationVo.getAddIncmTxApptnRtoCd())) {
//	                                                         
//	                                                 		if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0304Vo.getPymtYrMnth()) <= 0) {
//	                      	                                        	
//	                      	                            		InfcPayr0500VO TxPayr0500Vo = new InfcPayr0500VO(); 
//	                      	                                    TxPayr0500Vo.setDpobCd(payCalculationVo.getDpobCd());                          /** column 사업장코드 : dpobCd */ 
//	                      	                                    TxPayr0500Vo.setSystemkey(payCalculationVo.getSystemkey());                    /** column SYSTEMKEY : systemkey */  
//	                      	                                    TxPayr0500Vo.setAddIncmTxApptnYn("E");   //적용여부 
//	                      	                                    
//	                      	                                    payCalculationService.updatePayr0500TotAddIncmTx(TxPayr0500Vo);
//	                      	                                   //TODO 년도 가 지나는경우 수정가능하도록 스케줄처리.....
//	                                                 		}   
//	                                                 	}
//	                                                 } 
//	                                                  
//	                                                  
//	                                                /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	                                                 * 2015.07.13 추가 소득세 추가로 인한 수정작업진행.........
//	                                                 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
//	                                                
//	                                            if (ExtermsProps.getProps("PAY_CD_01").equals(payr0250Vo.getPayCd())) {         
//	                                                // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다. 
//	        
//	                                                payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                                payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                                payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                                payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                                payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                                payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                                payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                                payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                                payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                                payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                                payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                                payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                                payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                                payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                                payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                                payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                      payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                      payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                      payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                      payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                      payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                      payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                                
//	                                                payCalculationService.insertPayr0301(payr0301Vo); //월급여내역   
//	                                                  
//	                                                
//	                                                /*########################################################################################*/
//	                                                /**  가족수당/학비보조수당    시작                                                                                                                                                               **/
//	                                                /*########################################################################################*/  
//	                                                Set<InfcPayr0530VO> payr0530Set = payCalculationVo.getExPayr0530();
//	                                                
//	                                                Iterator<InfcPayr0530VO> iterpayr0530Set = payr0530Set!=null ? payr0530Set.iterator()  : null;
//	                                                   
//	                                                while (iterpayr0530Set.hasNext() ) {
//	                                                       
//	                                                           InfcPayr0530VO payr0530 = iterpayr0530Set.next(); 
//	        
//	                                                           payr0306Vo.setDpobCd(payr0530.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                           payr0306Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());     /** column 지급년월 : pymtYrMnth */          
//	                                                           payr0306Vo.setSystemkey(payCalculationVo.getSystemkey());            /** column SYSTEMKEY : systemkey */   
//	                                                           payr0306Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
//	                                                           payr0306Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//	                                                           payr0306Vo.setPayFamyRsptSeilNum(payr0530.getPayFamyRsptSeilNum());    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
//	                                                           payr0306Vo.setPayFamyResnRegnNum(payr0530.getPayFamyResnRegnNum());   /** column 급여가족주민번호 : payFamyResnRegnNum */ 
//	                                                           payr0306Vo.setHanNm(payr0530.getHanNm());                 /** column 한글성명 : hanNm */  
//	                                                           payr0306Vo.setFamyRelaDivCd(payr0530.getFamyExtpyDivCd());       /** column 가족관계구분코드 : famyRelaDivCd */    
//	                                                           payr0306Vo.setFamyAllwPymtYn(payr0530.getFamyAllwPymtYn());     /** column 가족수당지급여부 : famyAllwPymtYn */    
//	                                                           payr0306Vo.setChdnChdRrgEpnsPymtYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
//	                                                           payr0306Vo.setFndtnDducYn(payr0530.getFndtnDducYn());        /** column 기본공제여부 : fndtnDducYn */     
//	                                                           payr0306Vo.setSpueDducYn(payr0530.getSpueDducYn());          /** column 배우자공제여부 : spueDducYn */    
//	                                                           payr0306Vo.setWmnDducYn(payr0530.getWmnDducYn());              /** column 부녀자공제여부 : wmnDducYn */
//	                                                           payr0306Vo.setRftaGvstDducYn(payr0530.getRftaGvstDducYn());         /** column 경로우대공제여부 : rftaGvstDducYn */
//	                                                           payr0306Vo.setDabpnDducYn(payr0530.getDabpnDducYn());            /** column 장애자공제여부 : dabpnDducYn */ 
//	                                                           payr0306Vo.setSgpnFmlyDducYn(payr0530.getSgpnFmlyDducYn());           /** column 한가족공제여부 : sgpnFmlyDducYn */
//	                                                           payr0306Vo.setChdnChdRrgEpnsDducYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
//	                                                           payr0306Vo.setFamyExtpyDivCd(payr0530.getFamyExtpyDivCd());         /** column 가족수당구분코드 : famyExtpyDivCd */
//	                                                           payr0306Vo.setSchlExpnAdmclExtpyDivCd(payr0530.getSchlExpnAdmclExtpyDivCd());   /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
//	                                                           
//	                                                           if ("Y".equals(payr0530.getFamyAllwPymtYn())) {
//	                                                               payr0306Vo.setFamyExtpySum(payr0530.getFamyExtpySum());     /** column 가족수당금액 : famyExtpySum */
//	                                                           } else {
//	                                                               payr0306Vo.setFamyExtpySum(BigDecimal.ZERO);                  /** column 가족수당금액 : famyExtpySum */
//	                                                           }
//	                                                           
//	                                                           if ((MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) ) {
//	                                                               payr0306Vo.setSchlExpnAdmclExtpySum(payr0530.getSchlExpnAdmclExtpySum());     /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
//	                                                        
//	                                                           } else {
//	                                                           
//	                                                               payr0306Vo.setSchlExpnAdmclExtpySum(BigDecimal.ZERO);
//	                                                               
//	                                                           }
//	                                                           
//	                                                           if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
//	                                                                   (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
//	                                                            
//		                                                        	  
//		                                                               // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
//		                                                               if  ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
//		                                                            	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
//		                                                            	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
//		                                                            		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
//		                                                            	   }
//		                                                               }
//	                                                                   //가족수당 합
//	                                                                   tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
//	                                                                   //학비보조금함계
//	                                                                   tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum());
//	                                                                  
//	                                                                   InfcPayr0306VO tpPayr0306Vo = new InfcPayr0306VO();
//	                                                                   tpPayr0306Vo = payCalculationService.selectPayr0306(payr0306Vo);  
//	                                                                   
//	                                                                   if (MSFSharedUtils.paramNull(tpPayr0306Vo)) { 
//	                                                                       
//	                                                                       payCalculationService.insertPayr0306(payr0306Vo); 
//	                                                                       
//	                                                                   } else {
//	                                                                       
//	                                                                       payCalculationService.updatePayr0306(payr0306Vo); 
//	                                                                   }
//	                                                          } 
//	                                                       
//	                                                   }  
//	                                            
//	                                                  if ("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn()) ) {
//	                                                     //TODO 추가시 지급여부 3명이상인경우인경우 처리 
//	                                                      // tpFamyExtpySum = tpFamyExtpySum.add(payCalculationVo.getSuprtFamy3ChdnExtpySum());
//	                                                     
//	                                                  }  
//	                                                /*########################################################################################*/
//	                                                /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
//	                                                /*########################################################################################*/  
//	                                          
//	                                              
//	                                              /*########################################################################################*/
//	                                              /**  공제관련 항목  시작                                                                                                                                                                         **/
//	                                              /*########################################################################################*/    
//	                                              payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                                              payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                                              payr0520SrhVo.setPymtDt(payr0250Vo.getRflctnBgnnDt());  //지급구간 .getPymtDt()
//	                                              payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
//	                                              //공제테이블 
//	                                              List listDducPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                                
//	                                              /*########################################################################################*/
//	                                              /**  공제관련 항목  가져오기                                                                                                                                                                       **/
//	                                              /*########################################################################################*/     
//	                                              
//	                                                
//	                                                /*########################################################################################*/
//	                                                /**  수당관련 항목  시작                                                                                                                                                                         **/
//	                                                /*########################################################################################*/    
//	                                                payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                                                payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                                                payr0520SrhVo.setPymtDt(payr0250Vo.getRflctnBgnnDt());  //지급구간 
//	                                                payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_02"));
//	                                                //공제테이블 
//	                                                List listPymtPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                                  
//	                                                /*########################################################################################*/
//	                                                /**  공제관련 항목  가져오기                                                                                                                                                                       **/
//	                                                /*########################################################################################*/  
//	                                                
//	                                               /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                                 
//	                                               //지급공제항목에 따른 급여항목에 따른 인서트 처리 
//	                                               Set<InfcPayr0490VO> payr0490Set = payCalculationVo.getExPayr0490();
//	                                            
//	                                               Iterator<InfcPayr0490VO> iterpayr0490Set = payr0490Set!=null ? payr0490Set.iterator()  : null;
//	                                               
//	                                               while ( iterpayr0490Set!=null && iterpayr0490Set.hasNext() ) {
//	                                                   
//	                                                     InfcPayr0490VO payr0490 = iterpayr0490Set.next();
//	                                                
//	                                                   if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                        
//	                                                    	//공제 
//	                                                       if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0490.getPymtDducDivCd())) {
//	                                                           
//	                                                           iDducCnt = 0;
//	                                                           for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//	                                                               
//	                                                                payr0520Vo  = new InfcPayr0520VO();
//	                                                                    
//	                                                                BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
//	                                                                
//	                                                     
//	                                                            if (payr0520Vo.getPayItemCd().equals(payr0490.getPayItemCd())) {
//	                                                              
//	                                                                    if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { 
//	                                                                     
//	                                                                        payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                        payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                        payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                        payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                        payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                        payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                        payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum())
//	                                                                                                       .subtract(payr0490.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                        if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
//	                                                                        	payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                        }
//	                                                                         tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                       
//	                                                                    } 
//	                                                                    strDducPayr0520.add(payr0490.getPayItemCd());  
//	                                                                }   
//	                                                           }
//	                                                            
//	                                                           
//	                                                       } else {
//	                                                          
//	                                                           //가족수당
//	                                                           if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0490.getPayItemCd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                            
//	                                                               //가족수당  C9050100    
//	                                                        	   payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(tpFamyExtpySum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(tpFamyExtpySum.subtract(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum)));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                   
//	                                                                
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpFamyExtpySum);
//	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));
//	                                                                
//	                                                                if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                		  payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                	  } 	  
//	                                                                 } 
//	                                                               
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0490.getPayItemCd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                               //학비보조수당 C9060100
//	                                                               
//	                                                               //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
//	                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                             
//	                                                               if (ExtermsProps.getProps("PAY_CALC_TX_B005_02").equals(payr0490.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_01").equals(payr0490.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_03").equals(payr0490.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                               } else {
//	                                                            	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                               }
//	                                                          
//	                                                               
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
//	                                                                 
////	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
////	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum);
////	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                                
//	                                                                if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                		  payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                	  }	  
//	                                                                 }
//	                                                                
//	                                                           } else {
//	                                                               /** 각수당별로 처리하는 로직을구현한다. */ 
//	                                                                
//	                                                               BigDecimal tpEmymtAmnt = BigDecimal.ZERO;  //기간제 본봉 /수당 임시변수 
//	                                                                
//	                                                               // 본봉   --시간.일할정액이냐에 따라 다름
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //총 근무일수  * 본봉
//	                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum()))).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //총 근무일수  * 본봉 -시급처리 추가 
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               }  
//	                                                             //  BigDecimal tpEmymtC9410700Amnt = BigDecimal.ZERO;
//	                                                               // 토요근무수당   --일수산정
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else    if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                           && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                        
//	                                                                       tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                 
//	                                                               }  
//	                                                               
//	                                                              // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
//	                                                               // 주휴수당       --일수산정
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazWklyHldyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazWklyHldyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazWklyHldyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               }   
//	                                                               
//	                                                               
//	                                                               // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
//	                                                               // 교통보조비        --일수산정 
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_06").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //교통보조비  * 금액
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_06").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_06").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //교통보조비  * 본봉 -시급처리 추가 
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } 
//	                                                               //급식비 추가 
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //총 근무일수  * 본봉
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //총 근무일수  * 본봉 -시급처리 추가 
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } 
//	                                                              
//		                                                               // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
//		                                                               // 정액급식비        --일수산정 
//		                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//		                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//		                                                                   //총 근무일수  * 정액급식비 
//		                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//		                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//		                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd()) && ((
//		                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//		                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//		                                                                   //월정액,월액인경우  
//		                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//		                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//		                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//		                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//		                                                                   //총 근무일수   정액급식비  -시급처리 추가 
//		                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//		                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//		                                                               } 
//	                                                               
//	                                                               //BigDecimal tpEmymtC9410400Amnt = BigDecimal.ZERO;
//	                                                               // 월차수당        -- 일수 (퇴직시) TODO 수정 
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = (BigDecimal.ONE.multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               }
//	        
//	        
//	                                                              // BigDecimal tpEmymtC9410200Amnt = BigDecimal.ZERO;
//	                                                            // 휴일수당        -- 일수  ExtermsProps.getProps("PAY_EMYMT_PYMT_21") = "C9410200";  
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //일액 
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //시급인경우 
//	                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               }
//	        //                                                     
//	                                                               
//	                                                               //BigDecimal tpEmymtC9415000Amnt = BigDecimal.ZERO;
//	                                                               // 유급휴일수당  -- 일수 산정 ExtermsProps.getProps("PAY_EMYMT_PYMT_23") = "C9415000";  
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                      //일당 
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                
//	                                                                  } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0490.getPayItemCd()) && ((
//	                                                                          ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                          )  && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                      //월정액,월액인경우  
//	                                                                      tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                      //시급 
//	                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                
//	                                                                  } 
//	                                                                 
//	                                                              // BigDecimal tpEmymtC9410100Amnt = BigDecimal.ZERO; 
//	                                                               // 시간외수당     --시간으로산정
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } 
//	                                                               
//	                                                              // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
//	                                                               // 야간수당       -- 시간산정ExtermsProps. = "C9410300";
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } 
//	                                                               
//	                                                            // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
//	                                                               // 연가일수       -- 시간산정PAY_EMYMT_PYMT_24 = "C9410600";    // 연가보상비
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               }  
//	                                                               //명절휴가비 추가 
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_17").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd()))) {
//	                                                                    
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_17").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_17").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd()))) {
//	                                                                    
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } 
//	                                                               
//	                                                                 
//	                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                              
//	                                                               payr0302Vo.setPymtDducSum(tpEmymtAmnt);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd())) {
//	                                                            	   //정액급식비 
//	                                                            	   if (tpEmymtAmnt.compareTo(payr0490.getFreeDtySum()) >= 0) {  
//	                                                            		   
//	                                                                       payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                       payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                    
//	                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
//	                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                                       
//	                                                                   } else {
//	                                                                 	  
//	                                                                 	   payr0302Vo.setPymtDducFreeDtySum(tpEmymtAmnt);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                    
//	                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
//	                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpEmymtAmnt);
//	                                                                   }
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd())) {
//	                                                            	   //급식비 
//	                                                                	   if (tpEmymtAmnt.compareTo(payr0490.getFreeDtySum()) >= 0) {  
//	                                                                		   
//	                                                                           payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                           payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                        
//	                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
//	                                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                                           
//	                                                                       } else {
//	                                                                     	  
//	                                                                     	   payr0302Vo.setPymtDducFreeDtySum(tpEmymtAmnt);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                        
//	                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
//	                                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpEmymtAmnt);
//	                                                                       }
//	                                                               } else {
//	                                                            	   
//	                                                            	   payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                            	   payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                              
//	                                                            	   tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                               
//	                                                               } 
//	                                                               
//	                                                               
//	                                                               
//	        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                 
//	                                                                
//	                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0490.getPymtDducDivCd())) {
//	                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpEmymtAmnt);
//	                                                                }
//	                                                                 if (tpEmymtAmnt.compareTo(BigDecimal.ZERO) > 0) {
//	                                                            	 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            		 payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                            	 }	 
//	                                                                }
//	                                                           }
//	                                                            
//	                                                       }  //----------------------
//	                                                       
//	                                                    }  
//	                                                     
//	                                               }   
//	                                               
//	                                                 //항목에 없는 데이터 인서트 (공제)
//	                                                   for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//	                                                       
//	                                                       boolean payr0520chk = true; 
//	                                                       payr0520Vo  = new InfcPayr0520VO();
//	                                                      // payr0200Vo = (Payr0200VO) listPayr0200.get(iCnt);
//	                                                       BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
//	                                                       
//	                                                       
//	                                                       for (int iduCnt = 0; iduCnt < strDducPayr0520.size(); iduCnt++) {
//	                                                           
//	                                                           if (strDducPayr0520.get(iduCnt).equals(payr0520Vo.getPayItemCd())) {
//	                                                               payr0520chk = false ;
//	                                                           } 
//	                                                       }
//	                                                       
//	                                                      
//	                                                       if (payr0520chk) {
//	                                                           
//	                                                           payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                           payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                           payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                           payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
//	                                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                           
//	                                                      
//	                                                           if (payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ) {
//	                                                        	   
//	                                                        	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                        		   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                        	   }
//	                                                               tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum());
//	                                                           }
//	                                                        
//	                                                     }  
//	                                                   } 
//	        
//	                                                   /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                   *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                                     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                                      
//	                                               
//	                                                   /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                    *   4대보험 로직 시작
//	                                                      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/   
//	                                               //기본적으로 계산되어 나오나 값이 없는 경우에는 값을 가지고와서 처리함. 과세대상금액으로 처리 
//	                                                for(int iCnt01 = 0;iCnt01 < insureList.size();iCnt01++) {
//	                                                    
//	                                                    payrInsrStdVo  = new PayrInsrStdVO();
//	                                                   // payrInsrStdVo = (PayrInsrStdVO)insureList.get(iCnt01);
//	                                                    BeanUtils.copyProperties(payrInsrStdVo,insureList.get(iCnt01));
//	                                                    //건강보험 
//	                                                    tpHlthInsrPayAmt = BigDecimal.ZERO;
//	                                                    //요양 
//	                                                    tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;
//	                                                     //국민연금  
//	                                                    tpNatPennAmt = BigDecimal.ZERO;
//	                                                    //고용 
//	                                                    tpUmytInsrApptnAmt = BigDecimal.ZERO;
//	                                                    
//	                                                    //보수금액 
//	                                                    tpPymtAmnt =  BigDecimal.ZERO;
//	        
//	                                                    tpPymtAmnt = tpPymtTotAmnt;  //.subtract(tpDducTotAmnt); //TODO  확인 
//	 tpWorkIncmTxtnSum = tpPymtAmnt;                                                   
//	if (payCalculationVo.getHlthInsrApptnYn().equals("Y")) {   
//	                                                    	    //건강보험
//	                                                            if (payCalculationVo.getHlthInsrApptnYn().equals("Y") &&  payCalculationVo.getHlthInsrMnthRuntnAmnt().compareTo(BigDecimal.ZERO) > 0) {
//	                                                                tpHlthInsrPayAmt = payCalculationVo.getHlthInsrPayAmt().setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                            } else {
//	                                                                //현재금액에서 값을 구한다. 
//	                                                                if (payrInsrStdVo.getHlthInsrBstMnthRuntnAmnt().compareTo(tpPymtAmnt) >= 0) {
//	                                                                    tpHlthInsrPayAmt  =  BigDecimal.ZERO;
//	                                                                } else {
//	                                                                    tpHlthInsrPayAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getHlthInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                                }
//	                                                                
//	                                                            }
//	                                                            
//	                                                            //건강보험 
//	                                                            payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                            payr0302Vo.setPayItemCd("D0010100");   /** column 급여항목코드 : payItemCd */
//	                                                            payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                            payr0302Vo.setPymtDducSum(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                //                                                           payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                //                                                           payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                //                                                           payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                //                                                           payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                //                                                           payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                //                                                           payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                            if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {   
//	                                                            	payCalculationService.insertPayr0302(payr0302Vo);   
//	                                                                tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));
//	                                                            }
//	                                                            tpHlthInsrRcptnPayAmt = tpHlthInsrPayAmt.multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                            
//	                                                           //건강보험 -요양 
//	                                                           payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                           payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                           payr0302Vo.setPayItemCd("D0110100");   /** column 급여항목코드 : payItemCd */
//	                                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                           payr0302Vo.setPymtDducSum(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                //                                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                //                                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                //                                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                //                                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                //                                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                //                                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                           if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {      
//	                                                             payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                       
//	                                                             tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));
//	                                                           }  
//	                                                    }
//	                                                      //국민연금  
//	                                                    if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
//	                                                            if (payCalculationVo.getNatPennApptnYn().equals("Y") &&  payCalculationVo.getNatPennAmt().compareTo(BigDecimal.ZERO) > 0) {
//	                                                                
//	                                                                  tpNatPennAmt = payCalculationVo.getNatPennAmt().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                  
//	                                                            } else {
//	                                                                //현재금액에서 값을 구한다. 
//	                                                                if (payrInsrStdVo.getNatPennMinmIncmMnthAmnt().compareTo(tpPymtAmnt) >= 0) {
//	                                                                    tpNatPennAmt  =  BigDecimal.ZERO;
//	                                                                } else {
//	                                                                    
//	                                                                    if (tpPymtAmnt.compareTo(new BigDecimal("250000")) <= 0) {
//	                                                                        
//	                                                                        tpNatPennAmt = (new BigDecimal("250000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                        
//	                                                                   } else  if (tpPymtAmnt.compareTo(new BigDecimal("3980000")) >= 0) {
//	                                                                       
//	                                                                       tpNatPennAmt = (new BigDecimal("3980000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                       
//	                                                                   } else {
//	                                                                       tpNatPennAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal("100"))).setScale(-1, BigDecimal.ROUND_DOWN);;
//	                                                                   }
//	                                                                    
//	                                                                   
//	                                                                }
//	                                                                
//	                                                            }
//	                                                            //국민연금 
//	                                                            payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                            payr0302Vo.setPayItemCd("D0150100");   /** column 급여항목코드 : payItemCd */
//	                                                            payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                            payr0302Vo.setPymtDducSum(tpNatPennAmt);   /** column 지급공제금액 : pymtDducSum */
//	                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                //                                                           payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	                //                                                           payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                //                                                           payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                //                                                           payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	                //                                                           payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                //                                                           payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                            if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {  
//	                                                            	payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                            	tpDducTotAmnt = tpDducTotAmnt.add(tpNatPennAmt);
//	                                                            }	
//	                                                    } 
//	                                                    
//	                                                    if (payCalculationVo.getUmytInsrApptnYn().equals("Y")) {     
//	                                                            //고용보험 
//	                                                          if (payCalculationVo.getUmytInsrApptnYn().equals("Y") &&  payCalculationVo.getUmytInsrPayMnthAmnt().compareTo(BigDecimal.ZERO) > 0) {
//	                                                              tpUmytInsrApptnAmt = payCalculationVo.getUmytInsrPayMnthAmnt().setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                            } else {
//	                                                                //현재금액에서 값을 구한다. 
//	                                                              if (payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().compareTo(tpPymtAmnt) >= 0) {
//	                                                                  tpUmytInsrApptnAmt  =  BigDecimal.ZERO;
//	                                                              } else {
//	                                                                tpUmytInsrApptnAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);;
//	                                                            }
//	                                                                
//	                                                            }
//	                                                       
//	                                                        //고용보험  
//	                                                       payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                       payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                       payr0302Vo.setPayItemCd("D0160100");   /** column 급여항목코드 : payItemCd */
//	                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                       payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                       payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                       payr0302Vo.setPymtDducSum(tpUmytInsrApptnAmt);   /** column 지급공제금액 : pymtDducSum */
//	                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	            //                                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	            //                                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	            //                                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	            //                                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	            //                                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	            //                                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                       if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {    
//	                                                    	   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                        
//	                                                    	   tpDducTotAmnt = tpDducTotAmnt.add(tpUmytInsrApptnAmt);
//	                                                       }   
//	                                                    }
//	                                                }  
//	                                               
//	        
//	                                                /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                 *   4대보험 로직 종료 
//	                                                   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/   
//	                                              
//	                                                
//	                                                /**===============================================================================================
//	                                                 * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                 * 과세대상금액, 비과세금액 처리 함. 
//	                                                 ================================================================================================*/ 
//	                                                InfcPayr0307VO  payr0307SrhVo = new InfcPayr0307VO();
//	                                                
//	                                                payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                 
//	                                                 List<InfcPayr0307VO> listPayr0307Vo = payCalculationService.selectPayr0307All(payr0307SrhVo); 
//	                                                 
//	                                                 for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//	                                                 
//	                                                         InfcPayr0307VO  payr0307Vo = new InfcPayr0307VO();  //PAYR0307-조정내역처리를 위해 추가됨  
//	                                                         payr0307Vo = listPayr0307Vo.get(i307Cnt);
//	                                                         
//	                                                         //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
//	                                                         if  (MSFSharedUtils.paramNotNull(payr0307Vo) && MSFSharedUtils.paramNotNull(payr0307Vo.getSystemkey())) {
//	                                                             
//	                                                             payr0302Vo.setDpobCd(payr0307Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                             payr0302Vo.setPymtYrMnth(payr0307Vo.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                                                             payr0302Vo.setPayCd(payr0307Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                             payr0302Vo.setPayrSeilNum(payr0307Vo.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                             payr0302Vo.setSystemkey(payr0307Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                             payr0302Vo.setPayItemCd(payr0307Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//	                                                             payr0302Vo.setPymtDducDivCd(payr0307Vo.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//	                                                             payr0302Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                             payr0302Vo.setPymtDducSum(payr0307Vo.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
//	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                             payr0302Vo.setPayReattyAdmntVal(String.valueOf(payr0307Vo.getMnthPayAdmntSeilNum()));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                             payr0302Vo.setPymtDducTxtnAmnt(payr0307Vo.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//	             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//	             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//	             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//	             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//	             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//	             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//	                                                             payCalculationService.insertPayr0302(payr0302Vo);
//	                                                             
//	                                                             if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
//	                                                                 //과세금액 및 공제등 금액 처리 
//	                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//	                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//	                                                                 
//	                                                             } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
//	                                                                 //과세금액 및 공제등 금액 처리 
//	                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//	                                                                 tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
//	                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//	                                                                 
//	                                                             } else {
//	                                                                 tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
//	                                                             } 
//	                                                             
//	                                                         }
//	                                                 }
//	                                                 /**===============================================================================================
//	                                                  * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                  * 과세대상금액, 비과세금액 처리 종료 
//	                                                  ================================================================================================*/
//	                                              
//	                                                 /**===============================================================================================
//	                                                  * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                  * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//	                                                  ================================================================================================*/
//	                                                 
//	                                               //  if ("201504".equals(payr0250Vo.getJobYrMnth()))
//	                                               
//	     	                                        InfcInsr3100SrhVO  infcInsr3100SrhVO = new InfcInsr3100SrhVO(); 
//	                                                 
//	     	                                        infcInsr3100SrhVO.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	     	                                        infcInsr3100SrhVO.setNofctYrMnthNum(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : nfctYrMnthNum */ 
//	     	                                        infcInsr3100SrhVO.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                 
//	                                                 InfcInsr3100VO  infcInsr3100VO = new InfcInsr3100VO();
//	                                                 
//	                                                 infcInsr3100VO = payCalculationService.selectInsr0200Data(infcInsr3100SrhVO); 
//	                                                 
//	                                              //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//	                                                 
//	                                                 	    
//	                                                 //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
//	                                                         
////	                                             	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
////	                                             	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
////	                                             	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
////	                                             	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
//	                                                 
//	                                                 
//	                                                     if  (MSFSharedUtils.paramNotNull(infcInsr3100VO) && MSFSharedUtils.paramNotNull(infcInsr3100VO.getSystemkey())) { 
//	     													
//	     													 //공제금액처리 건강보험관련  
//	     													if (infcInsr3100VO.getMbrAlttHlth().compareTo(BigDecimal.ZERO) != 0) {
//	     														
////	     			                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
//	     													    /** column 연말정산보험료 : yrtxPrmm */ 
//	     				                                            
//	     														payr0302Vo.setDpobCd(infcInsr3100VO.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_0102"));    /** column 급여항목코드 : payItemCd */
//	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
//	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                             payr0302Vo.setPymtDducSum(infcInsr3100VO.getMbrAlttHlth());    /** column 지급공제금액 : pymtDducSum */
//	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//	             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//	             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//	             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//	             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//	             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//	             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//	                                                             payCalculationService.insertPayr0302(payr0302Vo); 
//	     	                                                        
//	     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttHlth()); //공제합계 
//	     	                                                    
//	     													}  
//	     													
//	     													if (infcInsr3100VO.getMbrAlttLgtmRcptn().compareTo(BigDecimal.ZERO) != 0) {
////	     			                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
//	     														 /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */ 
//	     														
//	     														payr0302Vo.setDpobCd(infcInsr3100VO.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_1102"));    /** column 급여항목코드 : payItemCd */
//	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
//	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                             payr0302Vo.setPymtDducSum(infcInsr3100VO.getMbrAlttLgtmRcptn());    /** column 지급공제금액 : pymtDducSum */
//	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//	     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//	     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//	     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//	     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//	     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//	     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//	     	                                                    payCalculationService.insertPayr0302(payr0302Vo); 
//	     	                                                        
//	     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttLgtmRcptn()); //공제합계 
//	     													}
//	                                                         
////	                                                         if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////	     														//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
//////	     			                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
////	     														  /** column 건강환급금이자 : hlthInsrRefdItrt */
////	     													
////	     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                             payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
////	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	                                                             payCalculationService.insertPayr0302(payr0302Vo);  
////	                                                             tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
////	                                                         }    
////	                                                         if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//////	     			                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
////	     														  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
////	     														 
////	     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                             payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
////	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	     	                                                    payCalculationService.insertPayr0302(payr0302Vo); 
////	     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
////	                                                         }
//	                                                     }
//	                                               //  } 
//	                                             	
//	                                             	 /**===============================================================================================
//	                                                  * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                  * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//	                                                  ================================================================================================*/
//	                                             	
//	                                                 // 급여내역 합계를 구한다. 
//	                                              // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
//	                                               
//	                                               tpTxtnTotAmnt =  tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt); 
//	                                                //과세대상금액 
//	                                               tpWorkIncmTxtnSum = BigDecimal.ZERO; //과세대상금액  
//	                                               txTotAmnt =  BigDecimal.ZERO;    //과세합계
//	                                                
//	                                               tpWorkIncmTxtnSum = tpTxtnTotAmnt;  //tpTxtnTotAmnt.subtract(tpSchlExpnAdmclExtpySum); //비과세,학자금을 제외한 금액 
//	                                                
//	                                               /****************************************************************************************
//	                                                * 일용직처리로직 추가 
//	                                                ****************************************************************************************/
//	                                               if (payCalculationVo.getDayWorkYn().equals("Y")) {
//	                                                  
////	                                                   //소득세   
////	                                                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
////	                                                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
////	                                                   payr0302Vo.setPayItemCd("T0010100");
////	                                                   payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
////	                                                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
////	                                                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
////	                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducSum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPayPymtDducPrcsFlag("N");
////	                                                   payr0302Vo.setPayReattyAdmntVal("0");
////	                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
////	        //                                         payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
////	        //                                         payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
////	        //                                         payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
////	        //                                         payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
////	        //                                         payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
////	        //                                         payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
////	                                                  // payCalculationService.deletePayr0302ToPayr0307T(payr0302Vo);  
////	                                                   
////	                                                   payCalculationService.insertPayr0302(payr0302Vo);
////	                                                   
////	                                                   
////	                                                   //지방소득세   
////	                                                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
////	                                                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
////	                                                   payr0302Vo.setPayItemCd("T0020100");
////	                                                   payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
////	                                                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
////	                                                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
////	                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducSum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPayPymtDducPrcsFlag("N");
////	                                                   payr0302Vo.setPayReattyAdmntVal("0");
////	                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
////	        //                                         payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
////	        //                                         payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
////	        //                                         payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
////	        //                                         payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
////	        //                                         payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
////	        //                                         payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
////	                                                   //payCalculationService.deletePayr0302ToPayr0307T(payr0302Vo);  
////	                                                   
////	                                                   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                   //기간제 소득세/지방소득세 
//	                                                   txTotAmnt = payrTaxCtl.getFuncWorkDayIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);      
//	                                                  
//	                                               } else {
//	                                            	   
//	                                            	   if ("201506".compareTo(payr0250Vo.getJobYrMnth()) < 0) {
//	                                               		   //소득세/지방소득세  
//	                                                          txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn2015( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
//		                                               	   } else {
//		                                               	 	//기간제 소득세/지방소득세 
//		                                                       txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);    
//		                                               	   }  
//	                                                   
//	                                                      
//	                                               }
//	                                               
//	                                               payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                               payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
//	                                               payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
//	                                               payr0301Vo.setPayCd(payCalculationVo.getPayCd());          
//	                                               payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
//	                                               payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
//	                                               payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
//	                                               payr0301Vo.setTxtnTotAmnt(tpTxtnTotAmnt);   
//	                                               payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
//	                                               payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
//	                                               payr0301Vo.setTxTotAmnt(txTotAmnt);     
//	                                               payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
//	                                               payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
//	                                               payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
//	                                               payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
//	                                               payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
//	                                               payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
//	                                               payr0301Vo.setPayDdlneDt("");    
//	                                               payr0301Vo.setPayDdlneYn("N");   
//	        //                                     payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                     payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                     payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                     payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                     payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                     payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                               
//	                                               payCalculationService.updatePayr0301(payr0301Vo); //월급여내역  
//	                                               
//	                                               
//	                                            } else if (ExtermsProps.getProps("PAY_CD_02").equals(payr0250Vo.getPayCd())) {
//	                                              /**
//	                                                * @@@@@@@@@@@@@@@@@@@@@@ 복리후생비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                */  
//	                                                
//	                                            } else if (ExtermsProps.getProps("PAY_CD_03").equals(payr0250Vo.getPayCd())) {
//	                                             /**
//	                                                * @@@@@@@@@@@@@@@@@@@@@@ 월급여 2회차 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                */ 
//	                                                
//	                                                // 월급여내역개인 인서트  
//	                                                
////	                                                payr0304Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
////	                                                payr0304Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
////	                                                payr0304Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
////	                                                payr0304Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                payr0304Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                payr0304Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
////	                                                payr0304Vo.setEmymtDivCd(payCalculationVo.getEmymtDivCd());            /** column 고용구분코드 : emymtDivCd */
////	                                                payr0304Vo.setHanNm(payCalculationVo.getHanNm());                      /** column 한글성명 : hanNm */
////	                                                payr0304Vo.setResnRegnNum(payCalculationVo.getResnRegnNum());          /** column 주민등록번호 : resnRegnNum */
////	                                                payr0304Vo.setDeptCd(payCalculationVo.getCurrAffnDeptCd());                    /** column 부서코드 : deptCd */
////	                                                payr0304Vo.setBusinCd(payCalculationVo.getBusinCd());    /** column 사업코드 : businCd */
////	                                                payr0304Vo.setTypOccuCd(payCalculationVo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
////	                                                payr0304Vo.setDtilOccuInttnCd(payCalculationVo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
////	                                                payr0304Vo.setOdtyCd(payCalculationVo.getOdtyCd());    /** column 직책코드 : odtyCd */
////	                                                payr0304Vo.setPyspCd(payCalculationVo.getPyspCd());    /** column 호봉코드 : pyspCd */
////	                                                payr0304Vo.setPyspGrdeCd(payCalculationVo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
////	                                                payr0304Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
////	                                                payr0304Vo.setLogSvcMnthIcmCd(payCalculationVo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
////	                                                payr0304Vo.setFrstEmymtDt(payCalculationVo.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
////	                                                payr0304Vo.setEmymtBgnnDt(payCalculationVo.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
////	                                                payr0304Vo.setEmymtEndDt(payCalculationVo.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
////	                                                payr0304Vo.setHdofcDivCd(payCalculationVo.getHdofcCodtnCd());    /** column 재직구분코드 : hdofcDivCd */
////	                                                payr0304Vo.setRetryDt(payCalculationVo.getRetryDt());    /** column 퇴직일자 : retryDt */
////	                                                payr0304Vo.setLogSvcStdDt(payCalculationVo.getLogSvcStdDt());    /** column 근속기준일자 : logSvcStdDt */
////	                                                payr0304Vo.setSpueYn(payCalculationVo.getSpueYn());    /** column 배우자유무 : spueYn */
////	                                                payr0304Vo.setSuprtFamyNumTwenChDn(payCalculationVo.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
////	                                                if (("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn())) 
////	                                                         && (payCalculationVo.getSuprtFamyNumTwenChDn().compareTo( new BigDecimal("2")) > 0)) {
////	                                                    payr0304Vo.setSuprtFamyNumTreOvrChdn(payCalculationVo.getSuprtFamyNumTwenChDn().subtract( new BigDecimal("2")) );    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
////	                                                    payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /**TODO  column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySumpayCalculationVo.getSuprtFamy3ChdnExtpySum() */
////	                                                    
////	                                                } else  {
////	                                                    payr0304Vo.setSuprtFamyNumTreOvrChdn(BigDecimal.ZERO);    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */ 
////	                                                    payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
////	                                                    
////	                                                }
////	                                                payr0304Vo.setSuprtFamyNumEtc(payCalculationVo.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
////	                                                payr0304Vo.setChdnSchlExpnAdmclYn(payCalculationVo.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
////	                                                payr0304Vo.setHlthInsrGrde(payCalculationVo.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
////	                                                payr0304Vo.setNatPennGrde(payCalculationVo.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
////	                                                payr0304Vo.setMnthPayDlywagSum(BigDecimal.ZERO);    /** column 월급여일당금액 : mnthPayDlywagSum */
////	                                                
////	                                                
////	                                                payr0304Vo.setAddIncmTxApptnRtoCd(payCalculationVo.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
////	                                                payr0304Vo.setAddIncmTxApptnYrMnth(payCalculationVo.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
////	                                              
////	                                                
////	                                                Payr0304VO tpPayr0304Vo = new Payr0304VO();
////	                                                tpPayr0304Vo = payCalculationService.selectPayr0304(payr0304Vo); 
////	                                                
////	                                                if (MSFSharedUtils.paramNull(tpPayr0304Vo)) { 
////	                                                   
////	                                                    payCalculationService.insertPayr0304(payr0304Vo);
////	                                                    
////	                                                } else {
////	                                                    
////	                                                    payCalculationService.updatePayr0304(payr0304Vo);
////	                                                } 
//	                                                
//	                                                // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다. 
//	        
//	                                                payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                                payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                                payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                                payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                                payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                                payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                                payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                                payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                                payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                                payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                                payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                                payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                                payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                                payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                                payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                                payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	        //                                      payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                      payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                      payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                      payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                      payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                      payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                                
//	                                                payCalculationService.insertPayr0301(payr0301Vo); //월급여내역   
//	                                                  
//	                                                
//	                                                /*########################################################################################*/
//	                                                /**  가족수당/학비보조수당    시작                                                                                                                                                               **/
//	                                                /*########################################################################################*/  
//	                                                Set<InfcPayr0530VO> payr0530Set = payCalculationVo.getExPayr0530();
//	                                                
//	                                                Iterator<InfcPayr0530VO> iterpayr0530Set = payr0530Set!=null ? payr0530Set.iterator()  : null;
//	                                                   
//	                                                while (iterpayr0530Set.hasNext() ) {
//	                                                       
//	                                                           InfcPayr0530VO payr0530 = iterpayr0530Set.next(); 
//	        
//	                                                           payr0306Vo.setDpobCd(payr0530.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                           payr0306Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());     /** column 지급년월 : pymtYrMnth */          
//	                                                           payr0306Vo.setSystemkey(payCalculationVo.getSystemkey());            /** column SYSTEMKEY : systemkey */   
//	                                                           payr0306Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
//	                                                           payr0306Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
//	                                                           payr0306Vo.setPayFamyRsptSeilNum(payr0530.getPayFamyRsptSeilNum());    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
//	                                                           payr0306Vo.setPayFamyResnRegnNum(payr0530.getPayFamyResnRegnNum());   /** column 급여가족주민번호 : payFamyResnRegnNum */ 
//	                                                           payr0306Vo.setHanNm(payr0530.getHanNm());                 /** column 한글성명 : hanNm */  
//	                                                           payr0306Vo.setFamyRelaDivCd(payr0530.getFamyExtpyDivCd());       /** column 가족관계구분코드 : famyRelaDivCd */    
//	                                                           payr0306Vo.setFamyAllwPymtYn(payr0530.getFamyAllwPymtYn());     /** column 가족수당지급여부 : famyAllwPymtYn */    
//	                                                           payr0306Vo.setChdnChdRrgEpnsPymtYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
//	                                                           payr0306Vo.setFndtnDducYn(payr0530.getFndtnDducYn());        /** column 기본공제여부 : fndtnDducYn */     
//	                                                           payr0306Vo.setSpueDducYn(payr0530.getSpueDducYn());          /** column 배우자공제여부 : spueDducYn */    
//	                                                           payr0306Vo.setWmnDducYn(payr0530.getWmnDducYn());              /** column 부녀자공제여부 : wmnDducYn */
//	                                                           payr0306Vo.setRftaGvstDducYn(payr0530.getRftaGvstDducYn());         /** column 경로우대공제여부 : rftaGvstDducYn */
//	                                                           payr0306Vo.setDabpnDducYn(payr0530.getDabpnDducYn());            /** column 장애자공제여부 : dabpnDducYn */ 
//	                                                           payr0306Vo.setSgpnFmlyDducYn(payr0530.getSgpnFmlyDducYn());           /** column 한가족공제여부 : sgpnFmlyDducYn */
//	                                                           payr0306Vo.setChdnChdRrgEpnsDducYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
//	                                                           payr0306Vo.setFamyExtpyDivCd(payr0530.getFamyExtpyDivCd());         /** column 가족수당구분코드 : famyExtpyDivCd */
//	                                                           payr0306Vo.setSchlExpnAdmclExtpyDivCd(payr0530.getSchlExpnAdmclExtpyDivCd());   /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
//	                                                           
//	                                                           if ("Y".equals(payr0530.getFamyAllwPymtYn())) {
//	                                                               payr0306Vo.setFamyExtpySum(payr0530.getFamyExtpySum());     /** column 가족수당금액 : famyExtpySum */
//	                                                           } else {
//	                                                               payr0306Vo.setFamyExtpySum(BigDecimal.ZERO);                  /** column 가족수당금액 : famyExtpySum */
//	                                                           }
//	                                                           
//	                                                           if ((MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) ) {
//	                                                               payr0306Vo.setSchlExpnAdmclExtpySum(payr0530.getSchlExpnAdmclExtpySum());     /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
//	                                                        
//	                                                           } else {
//	                                                           
//	                                                               payr0306Vo.setSchlExpnAdmclExtpySum(BigDecimal.ZERO);
//	                                                               
//	                                                           }
//	                                                           
//	                                                           if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
//	                                                                   (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
//	                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
//	                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
//	                                                              
//		                                                               // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
//		                                                               if  ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
//		                                                            	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
//		                                                            	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
//		                                                            		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
//		                                                            	   }
//		                                                               }
//	                                                                   //가족수당 합
//	                                                                   tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
//	                                                                   //학비보조금함계
//	                                                                   tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum());
//	                                                                  
//	                                                                   InfcPayr0306VO tpPayr0306Vo = new InfcPayr0306VO();
//	                                                                   tpPayr0306Vo = payCalculationService.selectPayr0306(payr0306Vo);  
//	                                                                   
//	                                                                   if (MSFSharedUtils.paramNull(tpPayr0306Vo)) { 
//	                                                                       
//	                                                                       payCalculationService.insertPayr0306(payr0306Vo); 
//	                                                                       
//	                                                                   } else {
//	                                                                       
//	                                                                       payCalculationService.updatePayr0306(payr0306Vo); 
//	                                                                   }
//	                                                          } 
//	                                                       
//	                                                   }  
//	                                            
//	                                                  if ("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn()) ) {
//	                                                     //TODO 추가시 지급여부 3명이상인경우인경우 처리 
//	                                                      // tpFamyExtpySum = tpFamyExtpySum.add(payCalculationVo.getSuprtFamy3ChdnExtpySum());
//	                                                     
//	                                                  }  
//	                                                /*########################################################################################*/
//	                                                /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
//	                                                /*########################################################################################*/  
//	                                          
//	                                              
//	                                              /*########################################################################################*/
//	                                              /**  공제관련 항목  시작                                                                                                                                                                         **/
//	                                              /*########################################################################################*/    
////	                                              payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
////	                                              payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
////	                                              payr0520SrhVo.setPymtDt(payr0250Vo.getRflctnBgnnDt());  //지급구간 .getPymtDt()
////	                                              payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
////	                                              //공제테이블 
////	                                              List listDducPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                                
//	                                              /*########################################################################################*/
//	                                              /**  공제관련 항목  가져오기                                                                                                                                                                       **/
//	                                              /*########################################################################################*/     
//	                                              
//	                                                
//	                                                /*########################################################################################*/
//	                                                /**  수당관련 항목  시작                                                                                                                                                                         **/
//	                                                /*########################################################################################*/    
//	                                                payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//	                                                payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//	                                                payr0520SrhVo.setPymtDt(payr0250Vo.getRflctnBgnnDt());  //지급구간 
//	                                                payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_02"));
//	                                                //공제테이블 
//	                                                List listPymtPayr0520 = payCalculationService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
//	                                                  
//	                                                /*########################################################################################*/
//	                                                /**  공제관련 항목  가져오기                                                                                                                                                                       **/
//	                                                /*########################################################################################*/  
//	                                                
//	                                               /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                                 
//	                                               //지급공제항목에 따른 급여항목에 따른 인서트 처리 
//	                                               Set<InfcPayr0490VO> payr0490Set = payCalculationVo.getExPayr0490();
//	                                            
//	                                               Iterator<InfcPayr0490VO> iterpayr0490Set = payr0490Set!=null ? payr0490Set.iterator()  : null;
//	                                               
//	                                               while ( iterpayr0490Set!=null && iterpayr0490Set.hasNext() ) {
//	                                                   
//	                                                     InfcPayr0490VO payr0490 = iterpayr0490Set.next();
//	                                                
//	                                                  if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                        
//	                                                       if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0490.getPymtDducDivCd())) {
//	                                                           
////	                                                           iDducCnt = 0;
////	                                                           for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
////	                                                               
////	                                                                payr0520Vo  = new Payr0520VO();
////	                                                                    
////	                                                                BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
////	                                                                
////	                                                     
////	                                                            if (payr0520Vo.getPayItemCd().equals(payr0490.getPayItemCd())) {
////	                                                              
////	                                                                    if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { 
////	                                                                     
////	                                                                        payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
////	                                                                        payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                                        payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
////	                                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
////	                                                                        payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
////	                                                                        payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                                        payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()));   /** column 지급공제금액 : pymtDducSum */
////	                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                                        payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum())
////	                                                                                                       .subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
////	        //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
////	        //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
////	        //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
////	        //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
////	        //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
////	        //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
////	                                                                         
////	                                                                        payCalculationService.insertPayr0302(payr0302Vo);  
////	                                                                        
////	                                                                        tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()));
////	                                                                       
////	                                                                    } 
////	                                                                    strDducPayr0520.add(payr0490.getPayItemCd());  
////	                                                                }   
////	                                                           }
//	                                                            
//	                                                           
//	                                                       } else {
//	                                                          
//	                                                           
//	                                                           if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0490.getPayItemCd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                             
//	                                                               //가족수당  C9050100 TODO 비과세처리 
//	                                                        	   payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(tpFamyExtpySum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(tpFamyExtpySum.subtract(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum)));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                                   
//	                                                                
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpFamyExtpySum);
//	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));
//	                                                                
//	                                                                if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                	if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                		payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                	}	
//	                                                                 } 
//	                                                               
//	                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0490.getPayItemCd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//	                                                               //학비보조수당 C9060100
//	                                                               
//	                                                               //학비보조수당 C9060100  재학생인경우 2월 학생신입인경우은 3월에 지급함...예외사항임. 
//	                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                               
//	                                                               if ("B0050002".equals(payr0490.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                               } else  if ("B0050001".equals(payr0490.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                               } else  if ("B0050003".equals(payr0490.getTxtnDivCd())) {
//	                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                               } else {
//	                                                            	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
//	                                                               }
//	                                                          
//	                                                               
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
//	                                                                 
////	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
////	                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum);
////	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                                
//	                                                                if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//	                                                                	if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                                		payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                                	}	
//	                                                                 }
//	                                                                
//	                                                           } else {
//	                                                               /** 각수당별로 처리하는 로직을구현한다. */ 
//	                                                                
//	                                                               BigDecimal tpEmymtAmnt = BigDecimal.ZERO;  //기간제 본봉 /수당 임시변수 
//	                                                                
//	                                                               // 본봉   --시간.일할정액이냐에 따라 다름
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //총 근무일수  * 본봉
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //총 근무일수  * 본봉 -시급처리 추가 
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
//	                                                               }  
//	                                                             //  BigDecimal tpEmymtC9410700Amnt = BigDecimal.ZERO;
//	                                                               // 토요근무수당   --일수산정
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else    if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                           && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                        
//	                                                                       tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                 
//	                                                               }  
//	                                                               
//	                                                              // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
//	                                                               // 주휴수당       --일수산정
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               }                     
//	                                                               
//	                                                               //BigDecimal tpEmymtC9410400Amnt = BigDecimal.ZERO;
//	                                                               // 월차수당        -- 일수 (퇴직시) TODO 수정 
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = (BigDecimal.ONE.multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               }
//	        
//	        
//	                                                              // BigDecimal tpEmymtC9410200Amnt = BigDecimal.ZERO;
//	                                                            // 휴일수당        -- 일수  ExtermsProps.getProps("PAY_EMYMT_PYMT_21") = "C9410200";  
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   
//	                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               }
//	        //                                                     
//	                                                               
//	                                                               //BigDecimal tpEmymtC9415000Amnt = BigDecimal.ZERO;
//	                                                               // 유급휴일수당  -- 일수 산정 ExtermsProps.getProps("PAY_EMYMT_PYMT_23") = "C9415000";  
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                      
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                
//	                                                                  } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0490.getPayItemCd()) && ((
//	                                                                          ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                          )  && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                      //월정액,월액인경우  
//	                                                                      tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                      
//	                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                                
//	                                                                  } 
//	                                                                 
//	                                                              // BigDecimal tpEmymtC9410100Amnt = BigDecimal.ZERO; 
//	                                                               // 시간외수당     --시간으로산정
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } 
//	                                                               
//	                                                              // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
//	                                                               // 야간수당       -- 시간산정ExtermsProps. = "C9410300";
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } 
//	                                                               
//	                                                            // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
//	                                                               // 연가일수       -- 시간산정PAY_EMYMT_PYMT_24 = "C9410600";    // 연가보상비
//	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && ((
//	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
//	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                   //월정액,월액인경우  
//	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
//	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
//	                                                                    
//	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
//	                                                             
//	                                                               } 
//	                                                                 
//	                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                               payr0302Vo.setPymtDducSum(tpEmymtAmnt);   /** column 지급공제금액 : pymtDducSum */
//	                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                               payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                
//	                                                                
//	                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
//	                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
//	                                                                
//	                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0490.getPymtDducDivCd())) {
//	                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpEmymtAmnt);
//	                                                                }
//	                                                             if (tpEmymtAmnt.compareTo(BigDecimal.ZERO) > 0) {
//	                                                            	 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                            		 payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                            	 }	 
//	                                                             }
//	                                                           }
//	                                                            
//	                                                       }  
//	                                                       
//	                                                    }  
//	                                                     
//	                                               }   
//	                                               
//	                                                 //항목에 없는 데이터 인서트 (공제)
////	                                                   for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
////	                                                       
////	                                                       boolean payr0520chk = true; 
////	                                                       payr0520Vo  = new Payr0520VO();
////	                                                      // payr0200Vo = (Payr0200VO) listPayr0200.get(iCnt);
////	                                                       BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
////	                                                       
////	                                                       
////	                                                       for (int iduCnt = 0; iduCnt < strDducPayr0520.size(); iduCnt++) {
////	                                                           
////	                                                           if (strDducPayr0520.get(iduCnt).equals(payr0520Vo.getPayItemCd())) {
////	                                                               payr0520chk = false ;
////	                                                           } 
////	                                                       }
////	                                                       
////	                                                      
////	                                                       if (payr0520chk) {
////	                                                           
////	                                                           payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
////	                                                           payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                           payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
////	                                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
////	                                                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
////	                                                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                           payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
////	                                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
////	        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
////	        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
////	        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
////	        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
////	        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
////	        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
////	                                                           
////	                                                      
////	                                                           if (payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ) {
////	                                                               payCalculationService.insertPayr0302(payr0302Vo);  
////	                                                             
////	                                                               tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum());
////	                                                           }
////	                                                        
////	                                                     }  
////	                                                   } 
//	        
//	                                                   /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                   *  급여 항목에 따른 인서트 및 계산 처리 종료 
//	                                                     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                                      
//	                                               
//	                                               /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                *   4대보험 로직 시작
//	                                                  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/   
//	                                           //기본적으로 계산되어 나오나 값이 없는 경우에는 값을 가지고와서 처리함. 과세대상금액으로 처리 
//	                                           for(int iCnt01 = 0;iCnt01 < insureList.size();iCnt01++) {
//	                                               
//	                                               payrInsrStdVo  = new PayrInsrStdVO();
//	                                              // payrInsrStdVo = (PayrInsrStdVO)insureList.get(iCnt01);
//	                                               BeanUtils.copyProperties(payrInsrStdVo,insureList.get(iCnt01));
//	                                               //건강보험 
//	                                               tpHlthInsrPayAmt = BigDecimal.ZERO;
//	                                               //요양 
//	                                               tpHlthInsrRcptnPayAmt = BigDecimal.ZERO;
//	                                                //국민연금  
//	                                               tpNatPennAmt = BigDecimal.ZERO;
//	                                               //고용 
//	                                               tpUmytInsrApptnAmt = BigDecimal.ZERO;
//	                                               
//	                                               //보수금액 
//	                                               tpPymtAmnt =  BigDecimal.ZERO;
//	   
//	                                               tpPymtAmnt = tpPymtTotAmnt;  //.subtract(tpDducTotAmnt); //TODO  확인 
// tpWorkIncmTxtnSum = tpPymtAmnt;
	//	                                               if (payCalculationVo.getHlthInsrApptnYn().equals("Y")) {   
//	                                               	    //건강보험
//	                                                       if (payCalculationVo.getHlthInsrApptnYn().equals("Y") &&  payCalculationVo.getHlthInsrMnthRuntnAmnt().compareTo(BigDecimal.ZERO) > 0) {
//	                                                           tpHlthInsrPayAmt = payCalculationVo.getHlthInsrPayAmt().setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                       } else {
//	                                                           //현재금액에서 값을 구한다. 
//	                                                           if (payrInsrStdVo.getHlthInsrBstMnthRuntnAmnt().compareTo(tpPymtAmnt) >= 0) {
//	                                                               tpHlthInsrPayAmt  =  BigDecimal.ZERO;
//	                                                           } else {
//	                                                               tpHlthInsrPayAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getHlthInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                           }
//	                                                           
//	                                                       }
//	                                                       
//	                                                       //건강보험 
//	                                                       payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                       payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                       payr0302Vo.setPayItemCd("D0010100");   /** column 급여항목코드 : payItemCd */
//	                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                       payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                       payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                       payr0302Vo.setPymtDducSum(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	           //                                                           payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	           //                                                           payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	           //                                                           payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	           //                                                           payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	           //                                                           payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	           //                                                           payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                       if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {   
//	                                                       	payCalculationService.insertPayr0302(payr0302Vo);   
//	                                                           tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));
//	                                                       }
//	                                                       tpHlthInsrRcptnPayAmt = tpHlthInsrPayAmt.multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                       
//	                                                      //건강보험 -요양 
//	                                                      payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                      payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                      payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                      payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                      payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                      payr0302Vo.setPayItemCd("D0110100");   /** column 급여항목코드 : payItemCd */
//	                                                      payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                      payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                      payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                      payr0302Vo.setPymtDducSum(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                      payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                      payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                      payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	           //                                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	           //                                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	           //                                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	           //                                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	           //                                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	           //                                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                      if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {      
//	                                                        payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                  
//	                                                        tpDducTotAmnt = tpDducTotAmnt.add(tpHlthInsrRcptnPayAmt.setScale(-1, BigDecimal.ROUND_DOWN));
//	                                                      }  
//	                                               }
//	                                                 //국민연금  
//	                                               if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
//	                                                       if (payCalculationVo.getNatPennApptnYn().equals("Y") &&  payCalculationVo.getNatPennAmt().compareTo(BigDecimal.ZERO) > 0) {
//	                                                           
//	                                                             tpNatPennAmt = payCalculationVo.getNatPennAmt().setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                             
//	                                                       } else {
//	                                                           //현재금액에서 값을 구한다. 
//	                                                           if (payrInsrStdVo.getNatPennMinmIncmMnthAmnt().compareTo(tpPymtAmnt) >= 0) {
//	                                                               tpNatPennAmt  =  BigDecimal.ZERO;
//	                                                           } else {
//	                                                               
//	                                                               if (tpPymtAmnt.compareTo(new BigDecimal("250000")) <= 0) {
//	                                                                   
//	                                                                   tpNatPennAmt = (new BigDecimal("250000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                   
//	                                                              } else  if (tpPymtAmnt.compareTo(new BigDecimal("3980000")) >= 0) {
//	                                                                  
//	                                                                  tpNatPennAmt = (new BigDecimal("3980000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	                                                                  
//	                                                              } else {
//	                                                                  tpNatPennAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal("100"))).setScale(-1, BigDecimal.ROUND_DOWN);;
//	                                                              }
//	                                                               
//	                                                              
//	                                                           }
//	                                                           
//	                                                       }
//	                                                       //국민연금 
//	                                                       payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                       payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                       payr0302Vo.setPayItemCd("D0150100");   /** column 급여항목코드 : payItemCd */
//	                                                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                       payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                       payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                       payr0302Vo.setPymtDducSum(tpNatPennAmt);   /** column 지급공제금액 : pymtDducSum */
//	                                                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	           //                                                           payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	           //                                                           payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	           //                                                           payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	           //                                                           payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	           //                                                           payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	           //                                                           payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                       if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {  
//	                                                       	payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                       	tpDducTotAmnt = tpDducTotAmnt.add(tpNatPennAmt);
//	                                                       }	
//	                                               } 
//	                                               
//	                                               if (payCalculationVo.getUmytInsrApptnYn().equals("Y")) {     
//	                                                       //고용보험 
//	                                                     if (payCalculationVo.getUmytInsrApptnYn().equals("Y") &&  payCalculationVo.getUmytInsrPayMnthAmnt().compareTo(BigDecimal.ZERO) > 0) {
//	                                                         tpUmytInsrApptnAmt = payCalculationVo.getUmytInsrPayMnthAmnt().setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                       } else {
//	                                                           //현재금액에서 값을 구한다. 
//	                                                         if (payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().compareTo(tpPymtAmnt) >= 0) {
//	                                                             tpUmytInsrApptnAmt  =  BigDecimal.ZERO;
//	                                                         } else {
//	                                                           tpUmytInsrApptnAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	                                                       }
//	                                                           
//	                                                       }
//	                                                  
//	                                                   //고용보험  
//	                                                  payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                  payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                  payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                  payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                  payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                  payr0302Vo.setPayItemCd("D0160100");   /** column 급여항목코드 : payItemCd */
//	                                                  payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                  payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                  payr0302Vo.setPymtDducSum(tpUmytInsrApptnAmt);   /** column 지급공제금액 : pymtDducSum */
//	                                                  payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                  payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	       //                                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	       //                                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	       //                                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	       //                                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	       //                                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	       //                                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//	                                                  if (BigDecimal.ZERO.compareTo(tpStdPymtTotAmnt) < 0)  {    
//	                                               	   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                   
//	                                               	   tpDducTotAmnt = tpDducTotAmnt.add(tpUmytInsrApptnAmt);
//	                                                  }   
//	                                               }
//	                                           }  
//	    
//	                                            /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                             *   4대보험 로직 종료 
//	                                               @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/   
//	                                                
//	                                                /**===============================================================================================
//	                                                 * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                 * 과세대상금액, 비과세금액 처리 함. 
//	                                                 ================================================================================================*/ 
//	                                                 InfcPayr0307VO  payr0307SrhVo = new InfcPayr0307VO();
//	                                                 
//	                                                 payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                 payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                 payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                 payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                 payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                
//	                                                 List<InfcPayr0307VO> listPayr0307Vo = payCalculationService.selectPayr0307All(payr0307SrhVo); 
//	                                                 
//	                                                 for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//	                                                 
//	                                                         InfcPayr0307VO  payr0307Vo = new InfcPayr0307VO();  //PAYR0307-조정내역처리를 위해 추가됨  
//	                                                         payr0307Vo = listPayr0307Vo.get(i307Cnt);
//	                                                         
//	                                                         //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
//	                                                         if  (MSFSharedUtils.paramNotNull(payr0307Vo) && MSFSharedUtils.paramNotNull(payr0307Vo.getSystemkey())) {
//	                                                             
//	                                                             payr0302Vo.setDpobCd(payr0307Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                             payr0302Vo.setPymtYrMnth(payr0307Vo.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                                                             payr0302Vo.setPayCd(payr0307Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                             payr0302Vo.setPayrSeilNum(payr0307Vo.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                             payr0302Vo.setSystemkey(payr0307Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                             payr0302Vo.setPayItemCd(payr0307Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//	                                                             payr0302Vo.setPymtDducDivCd(payr0307Vo.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//	                                                             payr0302Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                             payr0302Vo.setPymtDducSum(payr0307Vo.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
//	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                             payr0302Vo.setPayReattyAdmntVal(String.valueOf(payr0307Vo.getMnthPayAdmntSeilNum()));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                             payr0302Vo.setPymtDducTxtnAmnt(payr0307Vo.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//	             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//	             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//	             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//	             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//	             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//	             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//	                                                             payCalculationService.insertPayr0302(payr0302Vo);
//	                                                             
//	                                                             if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
//	                                                                 //과세금액 및 공제등 금액 처리 
//	                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//	                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//	                                                                 
//	                                                             } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
//	                                                                 //과세금액 및 공제등 금액 처리 
//	                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
//	                                                                 tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
//	                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
//	                                                                 
//	                                                             } else {
//	                                                                 tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
//	                                                             } 
//	                                                             
//	                                                         }
//	                                                 }
//	                                                 /**===============================================================================================
//	                                                  * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                  * 과세대상금액, 비과세금액 처리 종료 
//	                                                  ================================================================================================*/
//	                                                 /**===============================================================================================
//	                                                  * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                  * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//	                                                  ================================================================================================*/
//	                                                 
//	                                               //  if ("201504".equals(payr0250Vo.getJobYrMnth()))
//	                                               
////	                                                 Insr0200VO  insr0200SrhVo = new Insr0200VO();
////	                                                
////	                                                 
////	                                                 insr0200SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                 insr0200SrhVo.setDducYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */ 
////	                                                 insr0200SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                 
////	                                                 Insr0200VO  insr0200Vo = new Insr0200VO();
////	                                                 
////	                                                 insr0200Vo = payCalculationService.selectInsr0200Data(insr0200SrhVo); 
////	                                                 
////	                                              //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
////	                                                 
////	                                                 	    
////	                                                 //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
////	                                                         
//////	                                             	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
//////	                                             	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
//////	                                             	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
//////	                                             	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
////	                                                 
////	                                                 
////	                                                     if  (MSFSharedUtils.paramNotNull(insr0200Vo) && MSFSharedUtils.paramNotNull(insr0200Vo.getSystemkey())) {
////	                                                           
////	     													
////	     													 //공제금액처리 건강보험관련  
////	     													if (insr0200Vo.getYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
////	     														
//////	     			                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
////	     													    /** column 연말정산보험료 : yrtxPrmm */
////	     														 
////	     				                                            
////	     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_0102"));    /** column 급여항목코드 : payItemCd */
////	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
////	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	                                                             payCalculationService.insertPayr0302(payr0302Vo); 
////	     	                                                        
////	     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getYrtxPrmm()); //공제합계 
////	     	                                                    
////	     													}  
////	     													
////	     													if (insr0200Vo.getLgtmRcptnYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
//////	     			                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
////	     														 /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */ 
////	     														
////	     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_1102"));    /** column 급여항목코드 : payItemCd */
////	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
////	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	     	                                                    payCalculationService.insertPayr0302(payr0302Vo); 
////	     	                                                        
////	     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnYrtxPrmm()); //공제합계 
////	     													}
////	                                                         
////	                                                         if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////	     														//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
//////	     			                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
////	     														  /** column 건강환급금이자 : hlthInsrRefdItrt */
////	     													
////	     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                             payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
////	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	                                                             payCalculationService.insertPayr0302(payr0302Vo);
////	                                                             
////	                                                             
////	                                                             tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
////	                                                         }    
////	                                                         if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//////	     			                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
////	     														  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
////	     														 
////	     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
////	                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
////	                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
////	                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
////	                                                             payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
////	                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
////	                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
////	                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
////	                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
////	                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
////	                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
////	                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
////	     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
////	     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
////	     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
////	     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
////	     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
////	     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////	     	                                                    payCalculationService.insertPayr0302(payr0302Vo);
////	     	                                                        
////	     	                                                        
////	     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
////	                                                         }
////	                                                     }
////	                                               //  } 
//	                                             	
//	                                             	 /**===============================================================================================
//	                                                  * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
//	                                                  * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
//	                                                  ================================================================================================*/
//	                                             	
//	                                                 
//	                                                 // 급여내역 합계를 구한다. 
//	                                              // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
//	                                               
//	                                               tpTxtnTotAmnt =  tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt); 
//	                                                //과세대상금액 
//	                                               tpWorkIncmTxtnSum = BigDecimal.ZERO; //과세대상금액  
//	                                               txTotAmnt =  BigDecimal.ZERO;    //과세합계
//	                                                
//	                                               tpWorkIncmTxtnSum = tpTxtnTotAmnt;  //tpTxtnTotAmnt.subtract(tpSchlExpnAdmclExtpySum); //비과세,학자금을 제외한 금액 
//	                                                
//	                                               /****************************************************************************************
//	                                                * 일용직처리로직 추가 
//	                                                ****************************************************************************************/
//	                                               if (payCalculationVo.getDayWorkYn().equals("Y")) {
//	                                                  
////	                                                   //소득세   
////	                                                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
////	                                                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
////	                                                   payr0302Vo.setPayItemCd("T0010100");
////	                                                   payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
////	                                                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
////	                                                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
////	                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducSum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPayPymtDducPrcsFlag("N");
////	                                                   payr0302Vo.setPayReattyAdmntVal("0");
////	                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
////	        //                                         payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
////	        //                                         payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
////	        //                                         payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
////	        //                                         payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
////	        //                                         payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
////	        //                                         payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
////	                                                  // payCalculationService.deletePayr0302ToPayr0307T(payr0302Vo);  
////	                                                   
////	                                                   payCalculationService.insertPayr0302(payr0302Vo);
////	                                                   
////	                                                   
////	                                                   //지방소득세   
////	                                                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
////	                                                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
////	                                                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
////	                                                   payr0302Vo.setPayItemCd("T0020100");
////	                                                   payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
////	                                                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
////	                                                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
////	                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPymtDducSum(BigDecimal.ZERO);
////	                                                   payr0302Vo.setPayPymtDducPrcsFlag("N");
////	                                                   payr0302Vo.setPayReattyAdmntVal("0");
////	                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
////	        //                                         payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
////	        //                                         payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
////	        //                                         payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
////	        //                                         payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
////	        //                                         payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
////	        //                                         payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
////	                                                   //payCalculationService.deletePayr0302ToPayr0307T(payr0302Vo);  
////	                                                   
////	                                                   payCalculationService.insertPayr0302(payr0302Vo);  
//	                                                   txTotAmnt = payrTaxCtl.getFuncWorkDayIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt); 
//	                                                  
//	                                               } else {
//	                                            	   
//	                                            	       if ("201506".compareTo(payr0250Vo.getJobYrMnth()) < 0) {
//	                                               		       //소득세/지방소득세  
//	                                                           txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn2015( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
//		                                               	   } else {
//		                                               		   //기간제 소득세/지방소득세 
//		                                                       txTotAmnt = payrTaxCtl.getFuncWorkIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);    
//		                                               	   }  
//	                                                      
//	                                               }
//	                                               
//	                                               payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                               payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
//	                                               payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
//	                                               payr0301Vo.setPayCd(payCalculationVo.getPayCd());          
//	                                               payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
//	                                               payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
//	                                               payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
//	                                               payr0301Vo.setTxtnTotAmnt(tpTxtnTotAmnt);   
//	                                               payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
//	                                               payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
//	                                               payr0301Vo.setTxTotAmnt(txTotAmnt);     
//	                                               payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
//	                                               payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
//	                                               payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
//	                                               payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
//	                                               payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
//	                                               payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
//	                                               payr0301Vo.setPayDdlneDt("");    
//	                                               payr0301Vo.setPayDdlneYn("N");   
//	        //                                     payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	        //                                     payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	        //                                     payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	        //                                     payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	        //                                     payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	        //                                     payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                               
//	                                               payCalculationService.updatePayr0301(payr0301Vo); //월급여내역  
//	                                               
//	                                                
//	                                            } else if (ExtermsProps.getProps("PAY_CD_04").equals(payr0250Vo.getPayCd())) {
//	                                             /**
//	                                                * @@@@@@@@@@@@@@@@@@@@@@  명절휴가비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                */  
//	                                             
//	                                                 //C9110100  명절휴가비
//	                                                 
//	                                                 // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다.  
//	                                                 payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                 payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                                 payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                 payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                 payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                                 payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
//	                                                 payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
//	                                                 payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
//	                                                 payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                                 payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                                 payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                                 payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                                 payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
//	                                                 payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                                 payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                                 payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                                 payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                                 payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                                 payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	              //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	              //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	              //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	              //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	              //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	              //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                                 
//	                                               
//	                                                 payCalculationService.insertPayr0301(payr0301Vo); //월급여내역  
//	                                                 
//	                                                 /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	                                                  *  급여 항목에 따른 인서트 및 계산 처리 시작 
//	                                                    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
//	                                                 
//	                                                 //지급공제항목에 따른 급여항목에 따른 인서트 처리 
//	                                                 Set<InfcPayr0490VO> payr0490Set = payCalculationVo.getExPayr0490();
//	                                              
//	                                                 Iterator<InfcPayr0490VO> iterpayr0490Set = payr0490Set!=null ? payr0490Set.iterator()  : null;
//	                                                 
//	                                                 while ( iterpayr0490Set!=null && iterpayr0490Set.hasNext() ) {
//	                                                     
//	                                                       InfcPayr0490VO payr0490 = iterpayr0490Set.next();
//	                                                  
//	                                                     if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
//	                                                          
//	                                                           
//	                                                                 payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                                 payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                                                 payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                                 payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                                 payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                                 payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//	                                                                 payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//	                                                                 payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//	                                                                 payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                                 payr0302Vo.setPymtDducSum(payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//	                                                                 payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                                 payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                                 payr0302Vo.setPymtDducTxtnAmnt(payr0490.getPymtDducSum().subtract(payr0490.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//	              //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//	              //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//	              //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	              //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//	              //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	              //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//	                                                                  
//	                                                                 tpPymtTotAmnt = tpPymtTotAmnt.add(payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                 tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));
//	                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
//	                                                                 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
//	                                                              	   payCalculationService.insertPayr0302(payr0302Vo); 
//	                                                                 }  
//	                                                    }  
//	                                                 }
//	                                                  
//	                                                 payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                 payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
//	                                                 payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                 payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                 payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//	                                                 payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
//	                                                 payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
//	                                                 payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
//	                                                 payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
//	                                                 payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
//	                                                 payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
//	                                                 payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
//	                                                 payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
//	                                                 payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
//	                                                 payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
//	                                                 payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
//	                                                 payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
//	                                                 payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
//	                                                 payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
//	              //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
//	              //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
//	              //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	              //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
//	              //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	              //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
//	                                                 
//	                                                 payCalculationService.updatePayr0301(payr0301Vo); //명휴가비 
//	                                                
//	                                            } else if (ExtermsProps.getProps("PAY_CD_05").equals(payr0250Vo.getPayCd())) {
//	                                             /**
//	                                                * @@@@@@@@@@@@@@@@@@@@@@  초과근무수당 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                */  
//	                                                
//	                                            } else if (ExtermsProps.getProps("PAY_CD_06").equals(payr0250Vo.getPayCd())) {
//	                                             /**
//	                                                * @@@@@@@@@@@@@@@@@@@@@@ 연가보상비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                */
//	                                                
//	                                            } else if (ExtermsProps.getProps("PAY_CD_07").equals(payr0250Vo.getPayCd())) {
//	                                             /**
//	                                                * @@@@@@@@@@@@@@@@@@@@@@ 초과근무수당(12월) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
//	                                                */
//	                                                
//	                                            }  
//	                                            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[기간제근로자]월급여" ,"처리완료","대상자 : " + payCalculationVo.getHanNm() + "명처리완료 "));
//	                                        } else {
//	                                        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","급여항목데이터 존재하지 않음.")); 
//	                                        }//while ( iter.hasNext() )  
//	                                 } else {
//	                                	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]급여대상아님" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","급여대상자관리에서 급여대상 급여대상여부체크 확인 ")); 
//	                                    //급여대상여부가 불러왔는데 대상자가 아닌경우 처리  조정데이타가 존재하면 삭제 
//	                                    InfcPayr0307VO  payr0307SrhVo = new InfcPayr0307VO();
//	                                    
//	                                    payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                    payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//	                                    payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                    payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                    payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                    
//	                                    payCalculationService.deletePayCalculationPayr0307(payr0307SrhVo); 
//	                                }           
//	                           }
//	                                  
//	                       }   
//	                       
//	                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[기간제근로자]월급여" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(psnlList.size()) + "명처리완료 "));
//		        	}
//	                  
//	              retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
//	           } catch (Exception ex) {
//	                ex.printStackTrace();   
//	        	   ShowMessageBM smBm = new ShowMessageBM();
//	        	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
//	        	   smBm.setMenu("Payr");
//	        	   smBm.setPhase("[급여]에러");
//	        	   smBm.setMessage(ex.getLocalizedMessage());
//	        	   smBm.setContent(ex.getMessage());
//	        	   bmResult.add(smBm);  
//	        	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
//	        	 
//	           } 
//	           
//	           return retval; 
//		  	}
//		  	
//		  
//		   
//		  	/**
//		  	 * 직종세 근속년수 맵핑.
//		  	 * @param request
//		  	 * @param payr0400Vo
//		  	 * @return
//		  	 * @throws Exception
//		  	 */
//	        public int createPyspLogSvcYrNumCd(HttpServletRequest request,InfcPayr0400VO payr0400Vo)  throws Exception  {
//	            int result = 1;
//	             
//	         if  (pyspLogSvcYrNumService == null) { 
//	             WebApplicationContext wac = WebApplicationContextUtils.
//	                     getRequiredWebApplicationContext( request.getSession().getServletContext()); 
//	            
//	             pyspLogSvcYrNumService = (PyspLogSvcYrNumService) wac.getBean("PyspLogSvcYrNumService"); 
//	         }
//	            
//	         //근속년수 맵핑 로직 구현 하기 
//	         /*
//	          * 1. 근속녀수 코드 리스트를 가지고 와서 구간 별로 직종세와 맵핑을 한다.
//	          * 2. 맵핑된 데이터를 인서트 한다.
//	          */
//	         
//	         InfcPayr0430VO  payr0430Vo = new InfcPayr0430VO();
//	         InfcBass0300SrhVO searchVO  = new InfcBass0300SrhVO(); 
//	       
//	         try {
//	         
//	         searchVO.setDpobCd(payr0400Vo.getDpobCd());  
//	         searchVO.setRpsttvCd("A007");  
//	         
//	         List list = pyspLogSvcYrNumService.selectBass0300List(searchVO);
//	         
//	         Iterator<Map<String, Object>> iter = list.iterator();
//	          
//	         while ( iter.hasNext() ) {
//	             
//	             Map<String, Object> map = (Map<String, Object>) iter.next();
//	              
//	             /** DPOB_CD */
//	             payr0430Vo.setDpobCd(payr0400Vo.getDpobCd());
//	             
//	             payr0430Vo.setTypOccuGrdeMppgSeilNum(payr0400Vo.getTypOccuGrdeMppgSeilNum());
//	             /** TYP_OCCU_CD */
//	             payr0430Vo.setTypOccuCd(payr0400Vo.getTypOccuCd());
//	             
//	             /** PYSP_GRDE_CD */
//	             payr0430Vo.setPyspGrdeCd(payr0400Vo.getPyspGrdeCd());
//	             
//	             /** DTIL_OCCU_CLS_DIV_CD */
//	             payr0430Vo.setDtilOccuInttnCd(payr0400Vo.getDtilOccuInttnCd()); 
//	               
//	             /** PYSP_LOG_SVC_YR_NUM_CD */
//	             payr0430Vo.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(map.get("commCd"))); 
//	          
//	             /** LOG_SVC_YR_NUM_OVR */
//	             payr0430Vo.setLogSvcYrNumOvr(new BigDecimal(MSFSharedUtils.defaultNulls(map.get("mangeItem11"),"0"))); 
//	             /** LOG_SVC_YR_NUM_UDR */
//	             payr0430Vo.setLogSvcYrNumUdr(new BigDecimal(MSFSharedUtils.defaultNulls(map.get("mangeItem12"),"0")));
//	             
//	             pyspLogSvcYrNumService.insertPayr0430(payr0430Vo);
//	            
//	             
//	         }
//	            
//	          } catch (Exception ex) {
//	             
//	             result = 0;
//	             
//	           }
//	         
//	            return result; 
//	        }
//		  	
//		public String getTest01() throws Exception{
//			 
////			InfcPayr0305SrhVO searchVO = new InfcPayr0305SrhVO();
////			searchVO.setDpobCd("");
////			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
////			int a = inComeTaxService.selectPayr0305ListTotCnt(searchVO);
////			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
////			 
////			return String.valueOf(a);
//		   return null;
//		}
	 
	  
	}
  
