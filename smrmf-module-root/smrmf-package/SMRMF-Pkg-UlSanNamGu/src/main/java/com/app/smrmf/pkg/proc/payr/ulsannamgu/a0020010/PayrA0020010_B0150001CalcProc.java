package com.app.smrmf.pkg.proc.payr.ulsannamgu.a0020010;

 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.pkg.insr.insurance.PkgInsrController;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrWorkVO;
import com.app.smrmf.pkg.payr.income.tax.PayrTaxController;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;
import com.app.smrmf.pkg.payr.service.vo.PkgPayrAmntVO;
import com.app.smrmf.pkg.proc.payr.pay.calculation.service.PayCalculationService;
import com.app.smrmf.pkg.proc.payr.pysplogsvcyrnum.PyspLogSvcYrNumService;
import com.app.smrmf.props.ExtermsProps;
import com.app.smrmf.utils.PayrPkgUtil;
/**
 * 각 급여 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class PayrA0020010_B0150001CalcProc  extends AbstractCustomServiceImpl {
	 

	private static final Logger logger = LoggerFactory.getLogger(PayrA0020010_B0150001CalcProc.class);
	
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
    
    /*
     * 생성자 
     */
     public PayrA0020010_B0150001CalcProc () {
     	
         
     }

     /**
      * 
      * <pre>
      * 1. 개요 : 복리후생비
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : callProcMethedPayrA0020010_B0150001
      * @date : 2017. 10. 12.
      * @author : atres
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2017. 10. 12.		atres				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param request
      * @param payr0250Vo
      * @param payCalculationVo
      * @param pkgPayrAmntVo
      * @param pkgInsrWorkVo
      */
	public void callProcMethedPayrA0020010_B0150001(HttpServletRequest request, InfcPkgPayr0250VO payr0250Vo,
			PkgPayrCommCalcVO payCalculationVo, PkgPayrAmntVO pkgPayrAmntVo, PkgInsrWorkVO pkgInsrWorkVo)  throws Exception {
		
		 // PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	   
	  	   
        /*********************************************************************************
         * 호출 메서드 선언부 
         *********************************************************************************/
         
	  	  payrCommCalcService = (PayrCommCalcService)BeanFinder.getBean("PayrCommCalcService");
	  	  payCalculationService = (PayCalculationService)BeanFinder.getBean("PayCalculationService");
	  	//소득세계산을 위한 메서드 
          payrTaxCtl = PayrTaxController.getInstance();
          // 4대 보험 메소드  
          pkgInsrCtl = PkgInsrController.getInstance(); 
      
        /*********************************************************************************
         * 변수 선언부 
         *********************************************************************************/
	  	//  ArrayList strDducPayr0520= new ArrayList();  
        
        
        /*********************************************************************************
         * VO 객체 선언부 
         *********************************************************************************/ 
        InfcPkgPayr0301VO  payr0301Vo = new InfcPkgPayr0301VO();
      //  InfcPkgPayr0306VO  payr0306Vo = new InfcPkgPayr0306VO(); 
      //  InfcPkgPayr0520SrhVO payr0520SrhVo = new InfcPkgPayr0520SrhVO();
      //  InfcPkgPayr0520VO  payr0520Vo = null;
        InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
        
        //직책별 수당 
        //   InfcPkgPayr0460SrhVO payr0460SrhVo = new InfcPkgPayr0460SrhVO();
      //  InfcPkgPayr0460VO  payr0460Vo = null;
        
        //항목별수당
        //  InfcPkgPayr0450SrhVO payr0450SrhVo = new InfcPkgPayr0450SrhVO();
        //  InfcPkgPayr0450VO  payr0450Vo = null;
          
        /*********************************************************************************
         * 프로그램 구현 부 
         *********************************************************************************/   
          
	        try { 
					// TODO Auto-generated method stub
					  // 월급여내역 인서트 - 이후 급여합계은 업데이트 한다.  
			        payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			        payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
			        payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
			        payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			        payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
			        payr0301Vo.setPymtTotAmnt(BigDecimal.ZERO);    /** column 지급총액 : pymtTotAmnt */
			        payr0301Vo.setExtpyTotAmnt(BigDecimal.ZERO);    /** column 수당총액 : extpyTotAmnt */
			        payr0301Vo.setTxtnTotAmnt(BigDecimal.ZERO);    /** column 과세총액 : txtnTotAmnt */
			        payr0301Vo.setFreeDtyTotAmnt(BigDecimal.ZERO);    /** column 비과세총액 : freeDtyTotAmnt */
			        payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
			        payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
			        payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
			        payr0301Vo.setPernPymtSum(BigDecimal.ZERO);    /** column 차인지급액 : pernPymtSum */
			        payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
			        payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
			        payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
			        payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
			        payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
			        payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
			        payr0301Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
			        payr0301Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
			        payr0301Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
			        payr0301Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    				/** column 수정주소 : revnAddr */
			        
			        
			        payrCommCalcService.insertPayr0301(payr0301Vo); //월급여내역  
			        
			        /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			         *  급여 항목에 따른 인서트 및 계산 처리 시작 
			           @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			        Set<InfcPkgPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
			     
			        Iterator<InfcPkgPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
			        
			        while ( iterpayr0410Set.hasNext() ) { 
			            
			              InfcPkgPayr0410VO payr0410 = iterpayr0410Set.next();
			         
			              if (PayrPkgUtil.funcMonthCheck(payr0250Vo, payr0410,null)) {
			                 
			                /**
			                 *     //C9410100 시간외수당
			                 *     //C9410200 휴일수당  
			                 */ 
			                 /** 각수당별로 처리하는 로직을구현한다. */
			                 payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                 payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                 payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                 payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                 payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                 payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                 payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                 payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                 payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                 payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                 payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                 payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                 payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                 payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
			                 payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
			                 payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
			                 payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    				/** column 수정주소 : revnAddr */
			                  
			                    if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
			                        if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
			                             
			                    
			                            if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
			                                  //시간외근무 
			                                
			                                    BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                    if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                  	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                                    } 
			                                    BigDecimal totTmSum = BigDecimal.ZERO;
			                                    
			                                    totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
			                                    
			                                    
			                                    payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                                    payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                                    
			                                    pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                                pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                                 
			                                    
			                                    if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                                    	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                                    }
			                                    
			                                    payrCommCalcService.insertPayr0302(payr0302Vo);    
			                              }
			                              
			                        } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
			                          // 토요근무수당  --일수산정C9410700
			                            
			                            BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                            if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                          	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                            } 
			                            BigDecimal totTmSum = BigDecimal.ZERO;
			                            
			                            totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
			                            
			                            payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                            payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                            
			                            pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                        pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
			                            
			                            if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                            	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                            }
			                            
			                            payrCommCalcService.insertPayr0302(payr0302Vo);    
			                            
			                            
			                        } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
			                         // 야간수당       -- 시간산정C9410300
			                            
			                            BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                            if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                          	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                            } 
			                            BigDecimal totTmSum = BigDecimal.ZERO;
			                            
			                            totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotNtotTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
			                             
			                            payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                            payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                             
			                            pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                        pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                        
			                            
			                            if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                            	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                            }
			                            
			                            payrCommCalcService.insertPayr0302(payr0302Vo);    
			                            
			                        } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
			                          // 휴일수당        -- 일수 C9410200
			                            
			                            BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                            if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                          	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                            } 
			                            BigDecimal totTmSum = BigDecimal.ZERO;
			                            
			                            totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
			                            
			                            payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                            payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                            
			                            pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                        pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
			                            
			                            if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                            	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                            }
			                            
			                            payrCommCalcService.insertPayr0302(payr0302Vo);    
			                            
			                        } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
			                            // 유급휴일수당  -- 일수 산정 C9415000
			                                
			                            BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                            if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                          	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                            } 
			                            BigDecimal totTmSum = BigDecimal.ZERO;
			                            
			                            
			                            totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
			                            
			                            payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                            payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                            
			                            pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                        pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
			                            
			                            if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                            	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                            }
			                            
			                            payrCommCalcService.insertPayr0302(payr0302Vo);    
			                            
			                        } else {
			                            
			                        	pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN))); 
                                       	pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)));
                                           
			                            if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                            	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)));
                                        }
			                            
			                            payrCommCalcService.insertPayr0302(payr0302Vo);    
			                        }
			                          
			                     }   
			                         
			           }  
			        }
			         
			        payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
                    payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                    payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                    payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                    payr0301Vo.setPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt());    /** column 지급총액 : pymtTotAmnt */
                    payr0301Vo.setExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt());    /** column 수당총액 : extpyTotAmnt */
                    payr0301Vo.setTxtnTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt());    /** column 과세총액 : txtnTotAmnt */
                    payr0301Vo.setFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt());    /** column 비과세총액 : freeDtyTotAmnt */
                    payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
                    payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
                    payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
                    payr0301Vo.setPernPymtSum(pkgPayrAmntVo.getTpPymtTotAmnt());    /** column 차인지급액 : pernPymtSum */
                    payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
                    payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
                    payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
                    payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
                    payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
                    payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
                    
                    payr0301Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
                    payr0301Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
                    payr0301Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
                    payr0301Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    
                 
						payrCommCalcService.updatePayr0301(payr0301Vo);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        
			        /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			         *  급여 항목에 따른 인서트 및 계산 처리 종료 
			           @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
	}
     
     
	  	 
}