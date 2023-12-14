package com.app.smrmf.pkg.proc.payr.ulsannamgu.a0020010;

 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.constc.ulsannamgu.ConstUlSanNamGu;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0307VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0450VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0530VO;
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
 *  공무직 -> 월급여 처리 루틴 
 * @author atres
 *
 */
public class PayrA0020010_B0150000CalcProc  extends AbstractCustomServiceImpl {
	 

	private static final Logger logger = LoggerFactory.getLogger(PayrA0020010_B0150000CalcProc.class);
	
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
     public PayrA0020010_B0150000CalcProc () {
     	
         
     }

    /**
     * 
     * <pre>
     * 1. 개요 : 공무직 관련 월급여 내역을 처리한다.  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : 
     * @date : 2017. 10. 11.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 10. 11.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param payr0250Vo
     * @param payCalculationVo
     * @param sessionUser
     */ 

	public void callProcMethedPayrA0020010_B0150000(HttpServletRequest request, InfcPkgPayr0250VO payr0250Vo,
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
	  	   ArrayList strDducPayr0520= new ArrayList();  
          
          
          /*********************************************************************************
           * VO 객체 선언부 
           *********************************************************************************/ 
          InfcPkgPayr0301VO  payr0301Vo = new InfcPkgPayr0301VO();
          InfcPkgPayr0306VO  payr0306Vo = new InfcPkgPayr0306VO(); 
          InfcPkgPayr0520SrhVO payr0520SrhVo = new InfcPkgPayr0520SrhVO();
          InfcPkgPayr0520VO  payr0520Vo = null;
          InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
          
          //직책별 수당 
          //   InfcPkgPayr0460SrhVO payr0460SrhVo = new InfcPkgPayr0460SrhVO();
          InfcPkgPayr0460VO  payr0460Vo = null;
          
          //항목별수당
          //  InfcPkgPayr0450SrhVO payr0450SrhVo = new InfcPkgPayr0450SrhVO();
            InfcPkgPayr0450VO  payr0450Vo = null;
            
          /*********************************************************************************
           * 프로그램 구현 부 
           *********************************************************************************/   
          
   		  try {
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
			         
			        /*########################################################################################*/
			        /**  가족수당/학비보조수당    시작                                                                                                                                                               **/
			        /*########################################################################################*/  
			        Set<InfcPkgPayr0530VO> payr0530Set = payCalculationVo.getExPayr0530();
			        
			        Iterator<InfcPkgPayr0530VO> iterpayr0530Set = payr0530Set!=null ? payr0530Set.iterator()  : null;
			        
			        while (iterpayr0530Set.hasNext() ) {
			            
			            InfcPkgPayr0530VO payr0530 = iterpayr0530Set.next(); 
			
			            payr0306Vo.setDpobCd(payr0530.getDpobCd());    /** column 사업장코드 : dpobCd */
			            payr0306Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());     /** column 지급년월 : pymtYrMnth */          
			            payr0306Vo.setSystemkey(payCalculationVo.getSystemkey());            /** column SYSTEMKEY : systemkey */  
			            payr0306Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드  
			            payr0306Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
			            payr0306Vo.setPayFamyRsptSeilNum(payr0530.getPayFamyRsptSeilNum());    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
			            payr0306Vo.setPayFamyResnRegnNum(payr0530.getPayFamyResnRegnNum());   /** column 급여가족주민번호 : payFamyResnRegnNum */ 
			            payr0306Vo.setHanNm(payr0530.getHanNm());                 /** column 한글성명 : hanNm */  
			            payr0306Vo.setFamyRelaDivCd(payr0530.getFamyExtpyDivCd());       /** column 가족관계구분코드 : famyRelaDivCd */    
			            payr0306Vo.setFamyAllwPymtYn(payr0530.getFamyAllwPymtYn());     /** column 가족수당지급여부 : famyAllwPymtYn */    
			            payr0306Vo.setChdnChdRrgEpnsPymtYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
			            payr0306Vo.setFndtnDducYn(payr0530.getFndtnDducYn());        /** column 기본공제여부 : fndtnDducYn */     
			            payr0306Vo.setSpueDducYn(payr0530.getSpueDducYn());          /** column 배우자공제여부 : spueDducYn */    
			            payr0306Vo.setWmnDducYn(payr0530.getWmnDducYn());              /** column 부녀자공제여부 : wmnDducYn */
			            payr0306Vo.setRftaGvstDducYn(payr0530.getRftaGvstDducYn());         /** column 경로우대공제여부 : rftaGvstDducYn */
			            payr0306Vo.setDabpnDducYn(payr0530.getDabpnDducYn());            /** column 장애자공제여부 : dabpnDducYn */ 
			            payr0306Vo.setSgpnFmlyDducYn(payr0530.getSgpnFmlyDducYn());           /** column 한가족공제여부 : sgpnFmlyDducYn */
			            payr0306Vo.setChdnChdRrgEpnsDducYn(payr0530.getChdnChdRrgEpnsDducYn());     /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
			            payr0306Vo.setFamyExtpyDivCd(payr0530.getFamyExtpyDivCd());         /** column 가족수당구분코드 : famyExtpyDivCd */
			            payr0306Vo.setSchlExpnAdmclExtpyDivCd(payr0530.getSchlExpnAdmclExtpyDivCd());   /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
			            
			            if ("Y".equals(payr0530.getFamyAllwPymtYn())) {
			                payr0306Vo.setFamyExtpySum(payr0530.getFamyExtpySum());     /** column 가족수당금액 : famyExtpySum */
			            } else {
			                payr0306Vo.setFamyExtpySum(BigDecimal.ZERO);                  /** column 가족수당금액 : famyExtpySum */
			            }
			            
			            if ((payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
			                    && (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
			                    && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) ) {
			          
			            	payr0306Vo.setSchlExpnAdmclExtpySum(payr0530.getSchlExpnAdmclExtpySum());     /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
			         
			            } else {
			            
			                payr0306Vo.setSchlExpnAdmclExtpySum(BigDecimal.ZERO);
			                
			            }
			            
			            payr0306Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
			            payr0306Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
			            payr0306Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
			            payr0306Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    				/** column 수정주소 : revnAddr */
				        
			            
			            if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
			                    (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
			                    && (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
			                    && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
			             
			                   if (MSFSharedUtils.paramNull(payr0306Vo.getFamyExtpySum())) {
			                       payr0306Vo.setFamyExtpySum(new BigDecimal("0"));
			                   }
			                   
			                   if (MSFSharedUtils.paramNull(payr0306Vo.getSchlExpnAdmclExtpySum())) {
			                       payr0306Vo.setSchlExpnAdmclExtpySum(new BigDecimal("0"));
			                   }
			                   
			                   // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
			                  if ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
			                	 
			                	  pkgPayrAmntVo.setTpFamyFreeExtpySum(pkgPayrAmntVo.getTpFamyFreeExtpySum().add(payr0306Vo.getFamyExtpySum()));
                           	  
			                	  if (pkgPayrAmntVo.getTpFamyFreeExtpySum().compareTo(new BigDecimal("100000")) > 0) {
			                		  pkgPayrAmntVo.setTpFamyFreeExtpySum(new BigDecimal("100000")); 
                           	   	  }
                           	   
			                	 
			                   }
			                  
			                  	//가족수당 합
                              	pkgPayrAmntVo.setTpFamyExtpySum(pkgPayrAmntVo.getTpFamyExtpySum().add(payr0306Vo.getFamyExtpySum()));
                              	//학비보조금함계
                              	pkgPayrAmntVo.setTpSchlExpnAdmclExtpySum(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum().add(payr0306Vo.getSchlExpnAdmclExtpySum()));
                             
                              
			                    
			                    InfcPkgPayr0306VO tpPayr0306Vo = new InfcPkgPayr0306VO();
			                    tpPayr0306Vo = payrCommCalcService.selectPayr0306(payr0306Vo);  
			                    
			                    if (MSFSharedUtils.paramNull(tpPayr0306Vo)) { 
			                        
			                        payrCommCalcService.insertPayr0306(payr0306Vo); 
			                        
			                    } else {
			                        
			                        payrCommCalcService.updatePayr0306(payr0306Vo); 
			                    }
			                    
			                  
			            }  
			            
			        }
			        
			         if ("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn()) ) {
			            //TODO 추가시 지급여부 3명이상인경우인경우 처리 
			            //  tpFamyExtpySum = tpFamyExtpySum.add(payCalculationVo.getSuprtFamy3ChdnExtpySum());
			            
			         }  
			       /*########################################################################################*/
			       /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
			       /*########################################################################################*/  
			 
			     
			     /*########################################################################################*/
			     /**  공제관련 항목  시작                                                                                                                                                                         **/
			     /*########################################################################################*/    
			     payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
			     payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
			     payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 
			     payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
			     //공제테이블 
			     List listDducPayr0520 = payrCommCalcService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
			  
			     /*########################################################################################*/
			     /**  공제관련 항목  가져오기                                                                                                                                                                       **/
			     /*########################################################################################*/     
			     
			       
			       /*########################################################################################*/
			       /**  수당관련 항목  시작                                                                                                                                                                         **/
			       /*########################################################################################*/    
			       payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
			       payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
			       payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 
			       payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_02"));
			       //수당테이블 
			       List listPymtPayr0520 = payrCommCalcService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
			         
			       /*########################################################################################*/
			       /**  공제관련 항목  가져오기                                                                                                                                                                       **/
			       /*########################################################################################*/  
			       
			       /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			        *  급여 항목에 따른 인서트 및 계산 처리 시작 
			          @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			     
			       //기본급가져오기위해 추가된 부분 처리 해야함. 
			       Set<InfcPkgPayr0410VO> payr0410Base = payCalculationVo.getExPayr0410();
			       Iterator<InfcPkgPayr0410VO> iterpayr0410Base = payr0410Base!=null ? payr0410Base.iterator()  : null;
			       
			       while ( iterpayr0410Base.hasNext() ) { 
			           
			    	     InfcPkgPayr0410VO payr0410Be = new InfcPkgPayr0410VO();
			    	     payr0410Be = iterpayr0410Base.next(); 
			             
			             if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0410Be.getPayrImcd())) {
			            	 
			            	// logger.debug("값이 넘어오는가 :" + payCalculationVo.getHanNm() + ":" +payr0410Be.getUcstSum() );
			            	
			            	 pkgPayrAmntVo.setBasePymtAmnt(payr0410Be.getUcstSum());
			             } 
			       }
			       
			       Set<InfcPkgPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
			    
			       Iterator<InfcPkgPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
			       
			       while ( iterpayr0410Set.hasNext() ) { 
			    	   InfcPkgPayr0410VO payr0410 = new InfcPkgPayr0410VO();
			    	   payr0410 = iterpayr0410Set.next();
			        
			    	if (PayrPkgUtil.funcMonthCheck(payr0250Vo, payr0410,null)) {
			            	// logger.debug("값이 넘어오는가3 :" + payCalculationVo.getHanNm() + ":" +payr0410.getPayrImcd() );
			               //공제 처리 루틴  (tpPymtTotAmnt.compareTo(BigDecimal.ZERO) > 0)  && 
			               if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0410.getPymtDducDivCd())) {
			            	  // logger.debug("값이 넘어오는가4 :" + payCalculationVo.getHanNm() + ":" +payr0410.getPayrImcd() );
			            	   //수당공제 항목에 드록된 공제 인경우 payr0520 공제 
			            	   pkgPayrAmntVo.setiDducCnt(0);
			//                   for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
			//                       
			//                        payr0520Vo  = new InfcPkgPayr0520VO();
			//                            
			//                        BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt)); 
			//                      
			//                        
			//                        if (payr0520Vo.getPayItemCd().equals(payr0410.getPayrImcd())) {
			//                         
			//                                if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) != 0) { 
			//                                     
			//                                    payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			//                                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			//                                    payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			//                                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			//                                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//                                    payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			//                                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			//                                    payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			//                                    payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//                                    payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			//                                    payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			//                                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			//                                    payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
			//                                                                   .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			////                                                            payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
			////                                                            payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
			////                                                            payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
			////                                                            payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
			////                                                            payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
			////                                                            payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
			//                                    
			//                                   if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) != 0) {
			//                                	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
			//                                          payrCommCalcService.insertPayr0302(payr0302Vo);  
			//                                	   }   
			//                                    } 
			//                                 
			//                                    tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
			//                                   
			//                                } else {
			//                                	//금액이 아닌 비율로 처리 되는 경우 
			//                                	 if ((payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate()).compareTo(BigDecimal.ZERO) > 0) { 
			//                                         
			//                                         payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			//                                         payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			//                                         payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			//                                         payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			//                                         payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//                                         payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			//                                         payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			//                                         payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			//                                         payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//                                          
			//                                         payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
			//                                          
			//                                         payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			//                                         payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			//                                         payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
			//                                         //payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
			//                                           //                             .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			////                                                            payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
			////                                                            payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
			////                                                            payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
			////                                                            payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
			////                                                            payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
			////                                                            payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
			//                                         
			//                                         BigDecimal dducSumRate = (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate());
			//                                         BigDecimal dducSum = BigDecimal.ZERO;
			//                                         
			//                                         dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
			//                                          
			//                                         payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
			//                                         
			//                                        if ((payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate()).compareTo(BigDecimal.ZERO) > 0) {
			//                                     	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  { 
			//                                     		   
			//                                               payrCommCalcService.insertPayr0302(payr0302Vo);  
			//                                     	   }   
			//                                         } 
			//                                      
			//                                         tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
			//                                        
			//                                     }
			//                                	
			//                                }
			//                                strDducPayr0520.add(payr0410.getPayrImcd());  
			//                               
			//                            }   
			//                       }
			                 //  logger.debug("여기서 시작인데 :" + payCalculationVo.getHanNm() + ":" +payr0410.getPayrImcd() );
			                   /**
			                    * Payr0410에 등록된 공제 인경우 
			                    */
			                   if (ExtermsProps.getProps("PAY_DDUC_CD_92001").equals(payr0410.getPayrImcd())) {
			                	 //상조회인경우 처리   
			                	  // logger.debug("값이 넘어오는가5 :" + payCalculationVo.getHanNm() + ":" +payr0410.getPayrImcd() );
			//                	      payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			//                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			//                       payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			//                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			//                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//                       payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			//                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			//                       payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			//                       payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//                       payr0302Vo.setPymtDducSum(payr0410.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
			//                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			//                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			//                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			////                                               payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
			////                                               payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
			////                                               payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
			////                                               payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
			////                                               payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
			////                                               payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
			//                     
			//                       
			//                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn()))  {  
			//                    	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			//                    	   tpDducTotAmnt = tpDducTotAmnt.add(payr0410.getPymtDducSum());
			//                       }   
			//                	   
			//                      strDducPayr0520.add(payr0410.getPayrImcd());  
			                	   
			                   } else if (ExtermsProps.getProps("PAY_DDUC_CD_95004").equals(payr0410.getPayrImcd())) {
			                	 //노조회비 인경우 처리 
			                  
			//                	  // logger.debug("값이 넘어오는가2 :" + payCalculationVo.getHanNm() + ":" +basePymtAmnt );
			//                	      payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			//                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			//                       payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			//                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			//                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//                       payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			//                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			//                       payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			//                       payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//                       payr0302Vo.setPymtDducSum(payr0410.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
			//                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			//                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			//                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			////                                               payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
			////                                               payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
			////                                               payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
			////                                               payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
			////                                               payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
			////                                               payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
			//                       
			//                       
			//                       BigDecimal dducSumRate = (payr0410.getPymtDducRate());
			//                       BigDecimal dducSum = BigDecimal.ZERO;
			//                       
			//                       
			//                       dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
			//                        
			//                       payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
			//                       
			//                     // if ( payr0410.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn())) {
			//                   	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn()))  { 
			//                   		   
			//                             payrCommCalcService.insertPayr0302(payr0302Vo);  
			//                             tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
			//                   	   }   
			//                     //  }  
			//                	   strDducPayr0520.add(payr0410.getPayrImcd());  
			                   }
			                   
			               } else {
			                   //공제를 제외한 수당 인서트  
			                   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0410.getPayrImcd())) {
			                    //기본급처리 루틴 근무일수 /실근무일수가 다른경우처리 루틴 추가    
			                	   //기본급  - 병가관련데이터 처리 하는 부분 추가 
			                       BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급
			                       BigDecimal dayPayAmt = BigDecimal.ZERO; //기본급일액
			                       
			                       BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
			                       
			                       BigDecimal abnceNumDysAmt  = BigDecimal.ZERO; //결근금액 
			                      
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
			                       payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    
			                         
			                    
			                        if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
			                        	
			                        	 if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
			                                 
			                                 mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                
			                                // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
			                                // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
			                              
			                                 dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			                                		 .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
			                                				 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
			                                 
			                             }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
			                               
			                                 dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                 
			                             } else {
			                                 
			                                 dayPaySum = BigDecimal.ZERO;
			                             }
			                            //결근이 존재하는 경우 결근 빼기 - 시급통상임금 구해서 처리 해야 함. 그러기 위해서 다시 정의 해야 함. 
			                           //  payCalculationVo.getDilnlazAbnceNumDys()   /** column 근태_결근일수 : dilnlazAbnceNumDys */
			                            abnceNumDysAmt = (new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))
			                                            .multiply(payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal(ConstUlSanNamGu.PAYR_BASS_WKTM_YG_01)));  // USALY_AMNT_HRWG_QNTY 시급통상임금 
			                            
			                        } else {
			                        	
			                        	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
			                                  
			                                  mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                 
			                                 // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
			                                 // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
			                               
			                                  dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			                                		  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
			                                  
			                              }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
			                                
			                                  dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                  
			                              } else {
			                                  
			                                  dayPaySum = BigDecimal.ZERO;
			                              }
			                        }
			                        
			                        payr0302Vo.setPymtDducSum(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));   /** column 지급공제금액 : pymtDducSum */
			                        payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                       
			                        pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1)));
                                    // tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
                                    pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                    pkgPayrAmntVo.setTpStdPymtTotAmnt(pkgPayrAmntVo.getTpStdPymtTotAmnt().add(payr0302Vo.getPymtDducSum()));   //기본급
                                     
			                      
			                        
			                        if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
			                        	payrCommCalcService.insertPayr0302(payr0302Vo);
			                        }	
			                       
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0410.getPayrImcd()) && (pkgPayrAmntVo.getTpFamyExtpySum().compareTo(BigDecimal.ZERO) > 0)) {
			                        //가족수당 
			                	   
			                        BigDecimal dayFmyPayAmt = BigDecimal.ZERO; //일급계산 
			                        BigDecimal dayFreeFmyPayAmt = BigDecimal.ZERO; //일급프리금액 
			                         
			                        
			                        if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
			                        //결근은 가족수당을 제외하지 않음.
			                        	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
			                               		if (pkgPayrAmntVo.getTpFamyExtpySum().compareTo(BigDecimal.ZERO) > 0) { 
			                               			
			                               		dayFmyPayAmt = (pkgPayrAmntVo.getTpFamyExtpySum().divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP)) 
			                               				.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
			                               				.add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
			                               	
			                               		} else {
			                               		  dayFmyPayAmt = BigDecimal.ZERO;
			                               	  
			                               		}
			                               		if (pkgPayrAmntVo.getTpFamyExtpySum().compareTo(BigDecimal.ZERO) > 0) { 
			                                    
			                               			dayFreeFmyPayAmt = (pkgPayrAmntVo.getTpFamyExtpySum().divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			                               					            .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
			                               					            .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
			                               		
			                               		} else {
			                               			dayFreeFmyPayAmt =  BigDecimal.ZERO;
			                               		} 
			                               }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
			                                 
			                            	   dayFmyPayAmt = pkgPayrAmntVo.getTpFamyExtpySum();
                                        	   dayFreeFmyPayAmt = pkgPayrAmntVo.getTpFamyFreeExtpySum();
                                        	    
			                               } else {
			                                   
			                            	   dayFmyPayAmt = BigDecimal.ZERO;
			                            	   dayFreeFmyPayAmt =  BigDecimal.ZERO;
			                               }
			                        } else {
			                        
			                              if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
			                               		if (pkgPayrAmntVo.getTpFamyExtpySum().compareTo(BigDecimal.ZERO) > 0) { 
			                               		
			                               			dayFmyPayAmt = (pkgPayrAmntVo.getTpFamyExtpySum().divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			                               					         .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
			                               					         .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
			                               			
			                               		} else {
			                               		  dayFmyPayAmt = BigDecimal.ZERO;
			                               	  
			                               		}
			                               		if (pkgPayrAmntVo.getTpFamyFreeExtpySum().compareTo(BigDecimal.ZERO) > 0) { 
			                               			
			                                       		dayFreeFmyPayAmt = (pkgPayrAmntVo.getTpFamyFreeExtpySum().divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			                                       				    .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
			                                       				    .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
			                               		
			                               		} else {
			                               			dayFreeFmyPayAmt =  BigDecimal.ZERO;
			                               		} 
			                               }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
			                                 
			                            	   dayFmyPayAmt = pkgPayrAmntVo.getTpFamyExtpySum();
                                        	   dayFreeFmyPayAmt = pkgPayrAmntVo.getTpFamyFreeExtpySum();
                                        	   
			                            	  
			                               } else {
			                                   
			                            	   dayFmyPayAmt = BigDecimal.ZERO;
			                            	   dayFreeFmyPayAmt =  BigDecimal.ZERO;
			                               }
			                        }
			                       //가족수당  C9050100  
			                       payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                       payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                       payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                       payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                       payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                       payr0302Vo.setPymtDducSum(dayFmyPayAmt);   /** column 지급공제금액 : pymtDducSum */
			                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                       payr0302Vo.setPymtDducTxtnAmnt(dayFmyPayAmt.subtract(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt)));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                       payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
			                       payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
			                       payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
			                       payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    
			                           
			                       pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(dayFmyPayAmt));
                                   pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(dayFmyPayAmt));
                                   pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt)));
                                    
			                          if (pkgPayrAmntVo.getTpFamyExtpySum().compareTo(BigDecimal.ZERO) > 0) {
			                        	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
			                        		  payrCommCalcService.insertPayr0302(payr0302Vo);  
			                        	  }
			                           } 
			                          
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0410.getPayrImcd()) && (pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum().compareTo(BigDecimal.ZERO) > 0)) {
			                       //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
			                       payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                       payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                       payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                       payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */  
			                       payr0302Vo.setPymtDducSum(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum());   /** column 지급공제금액 : pymtDducSum */
			                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                       payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
			                       payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
			                       payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
			                       payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    
			                      
			                       // B0050001    B005    0001    과세
			                       // B0050002    B005    0002    비과세
			                       // B0050003    B005    0003    부분과세
			                        
			                       if (ExtermsProps.getProps("PAY_CALC_TX_B005_02").equals(payr0410.getTxtnDivCd())) {
			                           payr0302Vo.setPymtDducFreeDtySum(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                        
			                           pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum()));
			                       } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_01").equals(payr0410.getTxtnDivCd())) {
			                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                           payr0302Vo.setPymtDducTxtnAmnt(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                           pkgPayrAmntVo.setTpFreeDtyTotAmnt(BigDecimal.ZERO);
			                           
			                       } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_03").equals(payr0410.getTxtnDivCd())) {
			                           payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                           payr0302Vo.setPymtDducTxtnAmnt(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum().subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                          
			                           pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
			                           
			                       } else {
			                    	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                           payr0302Vo.setPymtDducTxtnAmnt(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                           pkgPayrAmntVo.setTpFreeDtyTotAmnt(BigDecimal.ZERO);
			                       }
			                  
			                       pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum()));
                                   pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum())); 
			                      
			                         
			                        
			                          if (pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum().compareTo(BigDecimal.ZERO) > 0) {
			                        	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
			                        		  payrCommCalcService.insertPayr0302(payr0302Vo);  
			                        	  }	  
			                           } 
			                   
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_04").equals(payr0410.getPayrImcd())) {
			                     //선임인력수당 -직채수당인경우 처리 루틴          
			                     //직책별 수당  
			                        payr0460Vo = new InfcPkgPayr0460VO();
			                        BigDecimal edPymtAmnt = BigDecimal.ZERO;
			                        
			                        payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
			                        payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			                        payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
			                        payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
			                        payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
			                     
			                        payr0460Vo = payrCommCalcService.selectPayr0460(payr0460Vo);
			                       
			                        if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
			                        
			                        	edPymtAmnt = payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN);
			                        	
			                        } else {
			                        	
			                        	edPymtAmnt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN);
			                        }	
			                           payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                           payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                           payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                           payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                           payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                           payr0302Vo.setPymtDducSum(edPymtAmnt);   /** column 지급공제금액 : pymtDducSum */
			                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                           payr0302Vo.setPymtDducTxtnAmnt(edPymtAmnt.subtract(payr0410.getFreeDtySum()));                     /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                           payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                       payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                       payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                       payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));      
			                           
			                           
				                       pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN)));
                                       pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN)));
                                       pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)));  
			                           
			                           if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {     
			                        	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			                           }
			                      
			                       
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_09").equals(payr0410.getPayrImcd())) {
			                       //임금보전수당 입사일자 기준으로 2015 이전 이후 로 구분하여 정리 한다. 
			                         	  payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */  
			                               
			                               if (payCalculationVo.getFrstEmymtDt().compareTo("20150101") >= 0) {
			                             	  //2015년이후 
			                             	  payr0302Vo.setPymtDducSum(payr0410.getUcstSum02().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                                   payr0302Vo.setPymtDducTxtnAmnt(payr0410.getUcstSum02().subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			//                                              
			                                    
			                                   pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add((payr0410.getUcstSum02().setScale(-1,BigDecimal.ROUND_DOWN))));
                                               pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add((payr0410.getUcstSum02().setScale(-1,BigDecimal.ROUND_DOWN))));
                                             
			                                   
			                               } else {
			                             	  //2015년이전  
			                             	  payr0302Vo.setPymtDducSum(payr0410.getUcstSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                                   payr0302Vo.setPymtDducTxtnAmnt(payr0410.getUcstSum().subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			//                                  

			                                   pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add((payr0410.getUcstSum().setScale(-1,BigDecimal.ROUND_DOWN))));
                                               pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add((payr0410.getUcstSum().setScale(-1,BigDecimal.ROUND_DOWN))));
                                                
			                                   
			                               } 
			                               
			                                // payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                               // payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                               payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
					                       payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
					                       payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
					                       payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));      
			                               
			                               
			                               pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN))); 
			                               
			                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {    
			                            	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			                               }  
			                                
			                              
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_50").equals(payr0410.getPayrImcd())) {
			                     // 근속가산금     
			
			                          payr0450Vo = new InfcPkgPayr0450VO();
										                    
								  	  payr0450Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
									  payr0450Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
									  payr0450Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());   /** set 근속년수코드 : logSvcYrNumCd */
									  payr0450Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_50"));    /** column 급여항목코드 : payItemCd */ 
									  payr0450Vo.setItemListExtpyDelYn("N");    /** column 직책_직종세수당삭제여부 : itemListExtpyDelYn */
										                                                               
			                          payr0450Vo = payrCommCalcService.selectPayr0450(payr0450Vo);
			                    
			                      if (MSFSharedUtils.paramNotNull(payr0450Vo) ) {
			                          
			                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                          payr0302Vo.setPymtDducSum((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                          payr0302Vo.setPymtDducTxtnAmnt((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)).subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                          payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                      payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                      payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                      payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
			                          
			                          
				                      pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN)));
                                      pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN)));
                                      pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN))); 
                                       
			                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {     
			                       	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			                          }
			                      }   
			
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_53").equals(payr0410.getPayrImcd())) {
			                	   // C9030150	B0080020	B0250030	정근수당가산금
			                	  //  public static final String  PYMT_ITEM_53 = "C9030150";    // 정근수당가산금
				
				                          payr0450Vo = new InfcPkgPayr0450VO();
											                    
									  	  payr0450Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
										  payr0450Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
										  payr0450Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());   /** set 근속년수코드 : logSvcYrNumCd */
										  payr0450Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_53"));    /** column 급여항목코드 : payItemCd */ 
										  payr0450Vo.setItemListExtpyDelYn("N");    /** column 직책_직종세수당삭제여부 : itemListExtpyDelYn */
											                                                               
				                          payr0450Vo = payrCommCalcService.selectPayr0450(payr0450Vo);
				                    
				                      if (MSFSharedUtils.paramNotNull(payr0450Vo) ) {
				                          
				                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
				                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
				                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
				                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
				                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
				                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
				                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
				                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
				                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
				                          payr0302Vo.setPymtDducSum((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
				                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
				                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
				                          payr0302Vo.setPymtDducTxtnAmnt((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)).subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
				                          payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
					                      payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
					                      payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
					                      payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
				                          
				                          
					                      pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN)));
	                                      pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN)));
	                                      pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN))); 
	                                       
				                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {     
				                       	   payrCommCalcService.insertPayr0302(payr0302Vo); 
				                          }
				                      }   
				
				                      
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_51").equals(payr0410.getPayrImcd())) {
			                     //정근수당    
			                	   /*****************************************************************
                                    *  정근수당 C9030100
                                    *****************************************************************/ 
                            	       BigDecimal baseBnusAmnt = BigDecimal.ZERO; 
                            		   BigDecimal totTmSum = BigDecimal.ZERO;
                            		   
			                 	      payr0450Vo = new InfcPkgPayr0450VO();
					                    
								  	  payr0450Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
									  payr0450Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
									  payr0450Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());   /** set 근속년수코드 : logSvcYrNumCd */
									  payr0450Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_51"));    /** column 급여항목코드 : payItemCd */ 
									  payr0450Vo.setItemListExtpyDelYn("N");    /** column 직책_직종세수당삭제여부 : itemListExtpyDelYn */
										                                                               
			                         payr0450Vo = payrCommCalcService.selectPayr0450(payr0450Vo);
			                    
			                        if (MSFSharedUtils.paramNotNull(payr0450Vo) ) {
			                          
	                        	     baseBnusAmnt = pkgPayrAmntVo.getBasePymtAmnt();
                          		     //비율 
                          		     BigDecimal ucstSumRto = payr0410.getPymtDducRate();  
                          		   
                          		     totTmSum = baseBnusAmnt.multiply((ucstSumRto.divide(new BigDecimal("100")))).setScale(-1,BigDecimal.ROUND_DOWN);   
                          		     
			                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                          payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                          payr0302Vo.setPymtDducTxtnAmnt((payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum())).subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                          payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                      payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                      payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                      payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
			                          
				                      pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum));
                                      pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
                                      pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN))); 
                                      
			                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {     
			                       	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			                          }
			                      }  
			                       
			                       
			                   } else if (ExtermsProps.getProps("PYMT_ITEM_52").equals(payr0410.getPayrImcd())) {
			                     //장기근속수당 - 비호봉제 
			                       payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                       payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                       payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                       payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                       payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                       payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                       payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                       payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                       payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                       payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                       payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                       payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                       payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                       payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                      payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                      payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                      payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
			                       
				                      pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)));
                                      pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)));
                                      pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum())); 
                                    
                                      
			                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
			                    	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			                       }  
			                       
			                   } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_12").equals(payr0410.getPayrImcd())) {
			                       //"C9020100"  --  기말수당
			                	     
			                	     BigDecimal edPymtAmnt = BigDecimal.ZERO;
			                	     
			                         payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                         payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                         payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                         payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                         payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                         payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                         payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                         payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                         payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                         payr0302Vo.setPymtDducSum(pkgPayrAmntVo.getBasePymtAmnt().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                         payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                         payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                         payr0302Vo.setPymtDducTxtnAmnt(pkgPayrAmntVo.getBasePymtAmnt().subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                         payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                      payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                      payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                      payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
			                       
			                          //정확한 기말 수당을 구하기 위한 로직 구현부 여기에 추가한다.  
			                          //매분기 직전 3개월간의 지급한 기본급의 합계 /3 을 한값   
			                         InfcPkgPayr0302VO tpPayr0302vo = new InfcPkgPayr0302VO();
			                         
			                         //TODO 확인후 다시 확인 
			                         tpPayr0302vo = payCalculationService.selectGHPayr0302C9020100(payr0302Vo);
			                          
			                         edPymtAmnt = (pkgPayrAmntVo.getBasePymtAmnt().add((tpPayr0302vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? tpPayr0302vo.getPymtDducSum() 
			                        		                    : payr0410.getPymtDducSum()))).divide(new BigDecimal("3"), -1, BigDecimal.ROUND_DOWN)  ;
			                         
			                         payr0302Vo.setPymtDducSum(edPymtAmnt);   /** column 지급공제금액 : pymtDducSum */
			                         payr0302Vo.setPymtDducTxtnAmnt(edPymtAmnt.subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			
			                         pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN)));
                                     pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN)));
                                     pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum())); 
                                     
			                         
			                         if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
			                      	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			                         }     
			                       
			                   } else {
			                        
			                	 // if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() 
			                		//	  : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { //
			                           /** 각수당별로 처리하는 로직을구현한다. */
			                           payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                           payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                           payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                           payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                           payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                           payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                           payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                           payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
					                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
					                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
					                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
				                       
			                            
			                             // if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
			                                  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
			                                    // 시간외근무관리   
			                                      if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
			                                    	  
			                                    	BigDecimal ucstSum =  BigDecimal.ZERO;
			                                            //시간외근무  -USALY_AMNT_HRWG_QNTY 계산된 시급으로 정리한다. 통상시급 
			                                    	  ucstSum = (payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN);  //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                     
			                                         if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                    	     ucstSum =  (payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN);   //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
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
			                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
			                                            	  payrCommCalcService.insertPayr0302(payr0302Vo);   
			                                              }	  
			                                        }
			                                        
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
			                                    // 토요근무수당   --일수산정C9410700 USALY_AMNT_PDY_QNTY
			                                	  
			                                     if (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0) {
			                                    	 
			                                    	 BigDecimal ucstSum =  BigDecimal.ZERO;
			                                    	 
			                                    	 ucstSum = (payr0410.getUsalyAmntPdyQnty().multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN); //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                         if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                    	   ucstSum = (payr0410.getUsalyAmntPdyQnty().multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN);  //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
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
			                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
			                                        	  payrCommCalcService.insertPayr0302(payr0302Vo);    
			                                          }
			                                      }
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
			                                	   
			                                   // 야간수당       -- 시간산정C9410300 MNTH_USALY_AMNT_WAG
			                                      if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
			                                    	  
			                                    	 BigDecimal ucstSum =  BigDecimal.ZERO;
			                                    	  
			                                    	 // BigDecimal ucstSum =  (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5))).multiply(new BigDecimal("2"))).setScale(0,BigDecimal.ROUND_DOWN);
			                                          ucstSum = ((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("226"), 5)).multiply(new BigDecimal("0.5"))).setScale(0,BigDecimal.ROUND_DOWN);
			                                          //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                          if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                        	 // ucstSum = (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5)).multiply(new BigDecimal("2")))).setScale(0,BigDecimal.ROUND_DOWN);
			                                        	  ucstSum = ((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("226"), 5)).multiply(new BigDecimal("0.5"))).setScale(0,BigDecimal.ROUND_DOWN);
			                                        	  //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                                          } 
			                                          BigDecimal totTmSum = BigDecimal.ZERO;
			                                          
			                                          totTmSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotNtotTm(),"0"))).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
			                                           
			                                          payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                                          payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                                           
			                                          pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                                      pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
			                                          
			                                          if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                                        	  pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                                          }
			                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
			                                        	  payrCommCalcService.insertPayr0302(payr0302Vo); 
			                                          }	  
			                                      }
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
			                                    // 휴일수당        -- 일수 C9410200
			                                      if (MSFSharedUtils.paramNotNull(payCalculationVo.getDilnlazPubcHodyDutyNumDys())) {
			                                    	  
			                                          if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0) {
			                                        	  
			                                        	 BigDecimal ucstSum =  BigDecimal.ZERO;
			                                        	 
			                                        	  ucstSum = (payr0410.getUsalyAmntPdyQnty().multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN); //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                               if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                             	  ucstSum = (payr0410.getUsalyAmntPdyQnty().multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN);  //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                                               } 
			                                               
			                                              BigDecimal totTmSum = BigDecimal.ZERO;
			                                              
			                                              totTmSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0"))).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
			                                              
			                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                                              
			                                              pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                                          pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
			                                              
			                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                                            	  pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                                              }
			                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
			                                            	  payrCommCalcService.insertPayr0302(payr0302Vo); 
			                                              }	  
			                                          }
			                                      }   
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
			                                      // 유급휴일수당  -- 일수 산정 C9415000
			                                      if (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0) {
			                                 	  
			                                    	  BigDecimal ucstSum =  BigDecimal.ZERO;
			                                          
			                                    	  ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                          if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                        	  ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
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
			                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
			                                        	  payrCommCalcService.insertPayr0302(payr0302Vo);    
			                                          }	  
			                                      }
			                                  } else   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0410.getPayrImcd())) {
			                                        //PAY_EMYMT_PYMT_18 = "C9080100";    // 정액급식비
			                                	      BigDecimal dayPaySum = BigDecimal.ZERO; 
			                                          BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                                      
			                                          if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
			                                              //결근은 정액급식비 을 제외 급여모자랄시  
			                                        	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
			                                                   
			                                            	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			                                            			     .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
			                                            			    		 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
			                                                  
			                                              }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
			                                                
			                                                  dayPaySum = ucstSum.setScale(-1,BigDecimal.ROUND_DOWN);
			                                                  
			                                              } else {
			                                                  
			                                                  dayPaySum = BigDecimal.ZERO;
			                                              } 
			                                          } else { 
			                                              if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
			                                                   
			                                            	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP)).multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
			                                            	   .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
			                                                  
			                                              }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
			                                                
			                                                  dayPaySum = ucstSum.setScale(-1,BigDecimal.ROUND_DOWN);
			                                                  
			                                              } else {
			                                                  
			                                                  dayPaySum = BigDecimal.ZERO;
			                                              } 
			                                          }
			                                          payr0302Vo.setPymtDducSum(dayPaySum);   /** column 지급공제금액 : pymtDducSum */
			                                          
			                                          if (dayPaySum.compareTo(payr0410.getFreeDtySum()) >= 0) {
			                                              payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                                              payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                                          
			                                              pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(dayPaySum)); 
                                                          pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                                           
			                                          } else {
			                                        	  
			                                        	  payr0302Vo.setPymtDducFreeDtySum(dayPaySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                                              payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                                          
			                                              pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(dayPaySum)); 
                                                          pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(dayPaySum)); 
                                                           
			                                          }
			                                          if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                                        	  pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(dayPaySum));
			                                          }
			                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
			                                        	  payrCommCalcService.insertPayr0302(payr0302Vo);    
			                                          }
			                                 
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0410.getPayrImcd())) {
			                                      // PAY_EMYMT_PYMT_24 = "C9410600";    // 연가보상비
			                                      if (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0) {
			                                         
			                                          BigDecimal ucstSum =   payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                                         
			                                          BigDecimal totTmSum = BigDecimal.ZERO;
			                                          
			                                          totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys())).multiply(ucstSum)).setScale(-1, BigDecimal.ROUND_DOWN);  //토요근무수당 
			                                          
			                                          payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
			                                          payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                                          
			                                          pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                                      pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                                       
			                                          
			                                          if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                                        	  pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
			                                          }
			                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
			                                        	  payrCommCalcService.insertPayr0302(payr0302Vo);    
			                                          }	  
			                                      }
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_17").equals(payr0410.getPayrImcd())) {
                                                  // PAY_EMYMT_PYMT_17 = "C9110100";    // 명절휴가비  
                                         	     BigDecimal ucstSum =  BigDecimal.ZERO;
                                         	     BigDecimal totTmSum = BigDecimal.ZERO; 
                                         	   
                                                 ucstSum =  pkgPayrAmntVo.getBasePymtAmnt();
                                                
                                                  BigDecimal dducSumRate =  payr0410.getPymtDducRate() ; 
                                                
                                                  totTmSum = ucstSum.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
                                                            
                                                    
                                                   
                                                   payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                   payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                   
                                                   pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                                   pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                                   
                                                
                                                   
                                                   if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                	   pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum)); 
                                                   }
                                                   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                 	  payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                   }	  
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_31").equals(payr0410.getPayrImcd())) {
                                                  //public static final String PAY_EMYMT_PYMT_31 = "C9310200";    //		대민활동비
                                         	  
                                                   BigDecimal ucstSum =   payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                   BigDecimal totTmSum = BigDecimal.ZERO;
                                               
                                                   totTmSum = ucstSum.setScale(-1, BigDecimal.ROUND_DOWN);  //대민활동비 
                                                   
                                                   payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                   payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                   
                                                   pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                                   pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                                   
                                                   if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                 	  pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
                                                   }
                                                   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                 	  payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                   }
                                                   
			                                  } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_09").equals(payr0410.getPayrImcd())) {
                                                  // PAY_EMYMT_PYMT_09 = "C9130100";    // 위험수당
                                         	      // 지급대상자가 국한 되어 있음 
                                                   BigDecimal ucstSum =   payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                   BigDecimal totTmSum = BigDecimal.ZERO;
                                               
                                                   totTmSum = ucstSum.setScale(-1, BigDecimal.ROUND_DOWN);  
                                                   
                                                   payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                   payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                   
                                                   pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(totTmSum)); 
                                                   pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum()));
                                                    
                                                    if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                    	 pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(totTmSum));
                                                    }
                                                   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                 	  payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                   }	              
			                                  } else {
			                                	  if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() 
			                              			  : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { //
			                                		  
			                                		  pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN))); 
                                               		  pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)));
                                                           
                                               		   
			                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                                            	  pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)));
			                                              }
			                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
			                                            	  payrCommCalcService.insertPayr0302(payr0302Vo);   
			                                              }	
			                                	  }       
			                                  }
			                                    
			                              // }  
			                             
			                //       } 
			                   }   
			               }  
			               
			            } 
			             
			       }  //
			    
			       /**
			        * 지급 금액이 없는 경우 보험등을 계산하지 않음.
			        */
			  if(pkgPayrAmntVo.getTpPymtTotAmnt().compareTo(BigDecimal.ZERO) > 0) { 
				  
				  for (int iCnt = 0; iCnt < listPymtPayr0520.size();iCnt++) {
			  	    	
			       	   
			          payr0520Vo  = new InfcPkgPayr0520VO(); 
			          BeanUtils.copyProperties(payr0520Vo, listPymtPayr0520.get(iCnt)); 
			
			          if (MSFSharedUtils.paramNotNull(payr0520Vo) && MSFSharedUtils.paramNotNull(payr0520Vo.getPayItemCd())) { 
			          	
			          payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			          payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			          payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
			          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			          payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_02"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
			          payr0302Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Vo.getPymtDducFreeDtySum(),"0")));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			          payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
			          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			          payr0302Vo.setPymtDducTxtnAmnt(payr0520Vo.getPymtDducSum().subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Vo.getPymtDducFreeDtySum(),"0"))));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			          payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
	                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
	                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
	                   
			          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
			          	payrCommCalcService.insertPayr0302(payr0302Vo);  
			          	   
			          	 //과세금액 및 공제등 금액 처리 
                     	pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(payr0302Vo.getPymtDducSum())); // 급여합계
                     	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(payr0302Vo.getPymtDducSum())); // 수당합계  
                     	pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0302Vo.getPymtDducFreeDtySum()));//비과세금액 
                     	
			              
			          }
			        
			   } 
			}
			           //항목에 없는 데이터 인서트 (공제)
			           for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
			               
			                boolean payr0520chk = true; 
			                payr0520Vo  = new InfcPkgPayr0520VO();
			               // payr0200Vo = (Payr0200VO) listPayr0200.get(iCnt);
			                BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt)); 
			                
			                for (int iduCnt = 0; iduCnt < strDducPayr0520.size(); iduCnt++) {
			                    
			                    if (strDducPayr0520.get(iduCnt).equals(payr0520Vo.getPayItemCd())) {
			                        payr0520chk = false ;
			                    } 
			                } 
			               
			                if (payr0520chk) {
			                    
			                	 if (payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0) {	
			                        payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                        payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
			                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                        payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
			                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                        payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
					                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
					                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
					                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
					                   
					                   
			                        if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
			                        	payrCommCalcService.insertPayr0302(payr0302Vo);  
			                        
			                        	pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(payr0520Vo.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN)));  
			                        	 
			                        }
			                	 } else {
			                		//금액이 아닌 비율로 처리 되는 경우 
			                    	 if (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0  ) { 
			                             
			                             payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                             payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
			                             payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                              
			                             payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
			                              
			                             payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
			                             //payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
			                               //                             .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                             payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
						                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
						                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
						                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
						                   
						                   
			                             
			                             BigDecimal dducSumRate =  payr0520Vo.getPymtDducRate() ;
			                             BigDecimal dducSum = BigDecimal.ZERO;
			                             
			                             dducSum = pkgPayrAmntVo.getBasePymtAmnt().multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
			                              
			                             payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
			                             
			                            if (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ) {
			                         	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  { 
			                         		   
			                                   payrCommCalcService.insertPayr0302(payr0302Vo);  
			                                   
			                                   pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(dducSum)); 
			                                 
			                         	   }   
			                             }  
			                         }
			                	 }   
			             }  
			           }
			    
			        /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			        *  급여 항목에 따른 인서트 및 계산 처리 종료 
			          @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			      
			       /**===============================================================================================
			        * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
			        * 과세대상금액, 비과세금액 처리 함. 
			        ================================================================================================*/ 
			        InfcPkgPayr0307VO  payr0307SrhVo = new InfcPkgPayr0307VO();
			        
			        payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			        payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			        payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			        payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			        payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			        
			        List<InfcPkgPayr0307VO> listPayr0307Vo = payrCommCalcService.selectPayr0307All(payr0307SrhVo); 
			        
			        for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
			        
			                InfcPkgPayr0307VO  payr0307Vo = new InfcPkgPayr0307VO();  //PAYR0307-조정내역처리를 위해 추가됨  
			                payr0307Vo = listPayr0307Vo.get(i307Cnt);
			                
			                //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
			                if  (MSFSharedUtils.paramNotNull(payr0307Vo) && MSFSharedUtils.paramNotNull(payr0307Vo.getSystemkey())) {
			                    
			                    payr0302Vo.setDpobCd(payr0307Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			                    payr0302Vo.setPymtYrMnth(payr0307Vo.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
			                    payr0302Vo.setPayCd(payr0307Vo.getPayCd());    /** column 급여구분코드 : payCd */
			                    payr0302Vo.setPayrSeilNum(payr0307Vo.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                    payr0302Vo.setSystemkey(payr0307Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                    payr0302Vo.setPayItemCd(payr0307Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
			                    payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			                    payr0302Vo.setPymtDducDivCd(payr0307Vo.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
			                    payr0302Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                    payr0302Vo.setPymtDducSum(payr0307Vo.getPymtDducSum());    /** column 지급공제금액 : pymtDducSum */
			                    payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                    payr0302Vo.setPayReattyAdmntVal(String.valueOf(payr0307Vo.getMnthPayAdmntSeilNum()));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                    payr0302Vo.setPymtDducTxtnAmnt(payr0307Vo.getPymtDducTxtnAmnt());    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			                    payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
				                   
			                    payrCommCalcService.insertPayr0302(payr0302Vo);
			                    
			                    if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
			                        //과세금액 및 공제등 금액 처리 
			                    	pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(payr0307Vo.getPymtDducSum())); // 급여합계
                                   	pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0307Vo.getPymtDducFreeDtySum()));//비과세금액 
                                   	 
			                        
			                    } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
			                        //과세금액 및 공제등 금액 처리 
			                        
			                    	pkgPayrAmntVo.setTpPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().add(payr0307Vo.getPymtDducSum())); // 급여합계
                                   	pkgPayrAmntVo.setTpExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt().add(payr0307Vo.getPymtDducSum())); // 수당합계  
                                   	pkgPayrAmntVo.setTpFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt().add(payr0307Vo.getPymtDducFreeDtySum()));//비과세금액 
                                   	
			                        
			                    } else {
			                    	
			                    	pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(payr0307Vo.getPymtDducSum())); //공제합계  
			                    	
			                    } 
			                    
			                }
			        }
			        /**===============================================================================================
			         * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
			         * 과세대상금액, 비과세금액 처리 종료 
			         ================================================================================================*/
			    
			}      
			  
			  /*########################################################################################*/
			    /**  4대보험 처리 로직  추가                                                                                                                                                                                              **/
			    /*########################################################################################*/   
			     
			  //과세대상금액  
	            pkgInsrWorkVo.setTpTxtnTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().subtract(pkgPayrAmntVo.getTpFreeDtyTotAmnt()));
	            //공제금액합계
	            pkgInsrWorkVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt());
	            //기본금액 
	            pkgInsrWorkVo.setTpStdPymtTotAmnt(pkgPayrAmntVo.getTpStdPymtTotAmnt());
	            
			     
			      payr0250Vo.setSystemkey(payCalculationVo.getSystemkey());
			        pkgInsrWorkVo = pkgInsrCtl.func4InsureService(request,payCalculationVo
			        		       ,payr0250Vo,pkgInsrWorkVo); 
			
			    	//공제금액 - 4대보험 합계포함 
              	    pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpDducTotAmnt()));
              	   
			
			   /*########################################################################################*/
			   /**  4대보험 처리 로직  종료                                                                            	  **/
			   /*########################################################################################*/  
			
			  
			     /**===============================================================================================
			      *  전체 금액 가지고 처리 하는 부분처리를 위해 추가 
			      *   
			      ================================================================================================*/
			     
			     
			        Set<InfcPkgPayr0410VO> payr0410SetDDuc = payCalculationVo.getExPayr0410();
			     
			        Iterator<InfcPkgPayr0410VO> iterpayr0410SetDDuc = payr0410SetDDuc!=null ? payr0410SetDDuc.iterator()  : null;
			        
			        while ( iterpayr0410SetDDuc.hasNext() ) { 
			            
			              InfcPkgPayr0410VO payr0410 = iterpayr0410SetDDuc.next();
			         
			              if (PayrPkgUtil.funcMonthCheck(payr0250Vo, payr0410,null)) {
			                
			                //공제 처리 루틴  (tpPymtTotAmnt.compareTo(BigDecimal.ZERO) > 0)  && 
			                if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0410.getPymtDducDivCd())) {
			                      
			                    /**
			                     * Payr0410에 등록된 공제 인경우 
			                     */
			                    if (ExtermsProps.getProps("PAY_DDUC_CD_92001").equals(payr0410.getPayrImcd())) {
			                 	 //상조회인경우 처리   
			                 	   
			                 	   payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                        payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                        payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                        payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                        payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                        payr0302Vo.setPymtDducSum(payr0410.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
			                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                        payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
					                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
					                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
					                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
			                      
			                        
			                        if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn()))  {  
			                     	   payrCommCalcService.insertPayr0302(payr0302Vo); 
			                     	  
			                     	   pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(payr0410.getPymtDducSum()));
			                     	   
			                        }   
			                 	    
			                 	   
			                    } else if (ExtermsProps.getProps("PAY_DDUC_CD_95004").equals(payr0410.getPayrImcd())) {
			                 	 //노조회비 인경우 처리 
			                 	   BigDecimal dducSum = BigDecimal.ZERO;
			                 	   
			                 	   payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			                        payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                        payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			                        payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
			                        payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                        payr0302Vo.setPymtDducSum(payr0410.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
			                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			                        payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
					                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
					                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
					                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    
			                       
			                         
			                    	
			                       if ("B0170010".equals(payr0410.getPymtDducFrmCd())) {
			                     	  //금액
			                     	    dducSum = payr0410.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN); 
			                            payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
			                            
			                            if ( payr0410.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn())) {
			                            	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
			                            		   
			                                      payrCommCalcService.insertPayr0302(payr0302Vo);  
			                                      pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(dducSum)); 
			                            	   }  
			                            	   
			                                }  
			                            
			                       } else   if ("B0170020".equals(payr0410.getPymtDducFrmCd())) {
			//                     		B017	0020	비율
			                     	   BigDecimal dducSumRate = (payr0410.getPymtDducRate());
			                           
			                     	   BigDecimal basePymtAmnt = BigDecimal.ZERO;
                                       basePymtAmnt = pkgPayrAmntVo.getTpPymtTotAmnt();  //과세금액  
                                       
			                            dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
			                             
			                            payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
			                            if ( payr0410.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn())) {
			                            	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
			                            		   
			                                      payrCommCalcService.insertPayr0302(payr0302Vo);  
			                                      
			                                      pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(dducSum));
			                            	   }  
			                            	   
			                                }  
			                            
			                       } 
			                        
			                      
			                    }
			                    
			                }
			              }
			           }
			        
			        /**===============================================================================================
			          *  전체 금액 가지고 처리 하는 부분처리를 위해 추가 
			          *   
			          ================================================================================================*/
			        
			        
			        /**===============================================================================================
			         * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
			         * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
			         ================================================================================================*/
			        
			      //  if ("201504".equals(payr0250Vo.getJobYrMnth()))
			      
			        InfcPkgInsr3100SrhVO  infcInsr3100SrhVO = new InfcPkgInsr3100SrhVO(); 
			        
			        infcInsr3100SrhVO.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			        infcInsr3100SrhVO.setNofctYrMnthNum(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : nfctYrMnthNum */ 
			        infcInsr3100SrhVO.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			        
			        InfcPkgInsr3100VO  infcInsr3100VO = new InfcPkgInsr3100VO();
			        
			        infcInsr3100VO = payCalculationService.selectInsr0200Data(infcInsr3100SrhVO); 
			        
			     //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
			        
			        	    
			        //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
			                
			//    	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
			//    	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
			//    	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
			//    	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
			        
			        
			            if  (MSFSharedUtils.paramNotNull(infcInsr3100VO) && MSFSharedUtils.paramNotNull(infcInsr3100VO.getSystemkey())) { 
							
							 //공제금액처리 건강보험관련  
							if (infcInsr3100VO.getMbrAlttHlth().compareTo(BigDecimal.ZERO) != 0) {
								
			//                	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
							    /** column 연말정산보험료 : yrtxPrmm */ 
			                        
								payr0302Vo.setDpobCd(infcInsr3100VO.getDpobCd());    /** column 사업장코드 : dpobCd */
			                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			                    payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                    payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_0102"));    /** column 급여항목코드 : payItemCd */
			                    payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                    payr0302Vo.setPymtDducSum(infcInsr3100VO.getMbrAlttHlth());    /** column 지급공제금액 : pymtDducSum */
			                    payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			                    payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
				                   
			                    payrCommCalcService.insertPayr0302(payr0302Vo); 
			                        
			                    pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(infcInsr3100VO.getMbrAlttHlth())); //공제합계 
			                    
			                    
							}  
							
							if (infcInsr3100VO.getMbrAlttLgtmRcptn().compareTo(BigDecimal.ZERO) != 0) {
			//                	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
								 /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */ 
								
								payr0302Vo.setDpobCd(infcInsr3100VO.getDpobCd());    /** column 사업장코드 : dpobCd */
			                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			                    payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                    payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_CD_1102"));    /** column 급여항목코드 : payItemCd */
			                    payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                    payr0302Vo.setPymtDducSum(infcInsr3100VO.getMbrAlttLgtmRcptn());    /** column 지급공제금액 : pymtDducSum */
			                    payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			                    payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
				                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
				                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
				                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
				                   
				                   
			                    payrCommCalcService.insertPayr0302(payr0302Vo); 
			                        
			                    pkgPayrAmntVo.setTpDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt().add(infcInsr3100VO.getMbrAlttLgtmRcptn())); //공제합계 
			                     
							}
			                
			//                if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
			//					//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
			////                	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
			//					  /** column 건강환급금이자 : hlthInsrRefdItrt */
			//				
			//					payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			//                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			//                    payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			//                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			//                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//                    payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
			//                    payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			//                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			//                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//                    payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
			//                    payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			//                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			//                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			////                                            payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
			////                                            payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
			////                                            payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
			////                                            payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
			////                                            payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
			////                                            payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			//                    payrCommCalcService.insertPayr0302(payr0302Vo);  
			//                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
			//                }    
			//                if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
			////                	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
			//					  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
			//					 
			//					payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			//                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			//                    payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			//                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			//                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//                    payr0302Vo.setPayItemCd(ExtermsProps.PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
			//                    payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			//                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			//                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//                    payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
			//                    payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			//                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			//                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			////                                            payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
			////                                            payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
			////                                            payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
			////                                            payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
			////                                            payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
			////                                            payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			//                    payrCommCalcService.insertPayr0302(payr0302Vo); 
			//                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
			//                }
			            }
			      //  } 
			    	
			    	 /**===============================================================================================
			         * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
			         * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
			         ================================================================================================*/
				
			  //월급여내역 합계를 구한다. 
			    // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
			      
			         pkgInsrWorkVo.setTpTxtnTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt().subtract(pkgPayrAmntVo.getTpFreeDtyTotAmnt()));  
			      //과세대상금액 
			     pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO); //과세대상금액  
			     pkgPayrAmntVo.setTxTotAmnt(BigDecimal.ZERO);    //과세합계
			      
			     pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgInsrWorkVo.getTpTxtnTotAmnt());      //tpTxtnTotAmnt.subtract(pkgPayrAmntVo.getTpSchlExpnAdmclExtpySum()); //비과세,학자금을 제외한 금액 
			   
			     /****************************************************************************************
                  * 일용직처리로직 추가 
                  ****************************************************************************************/
               if ("Y".equals(payCalculationVo.getPayrIncmExceYn())) {
            	   
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
                     payr0302Vo.setPymtDducSum(pkgPayrAmntVo.getTxTotAmnt());
                     payr0302Vo.setPayPymtDducPrcsFlag("N");
                     payr0302Vo.setPayReattyAdmntVal("0");
                     payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
                     payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
	                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
	                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
	                   
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
                     payr0302Vo.setPymtDducSum(pkgPayrAmntVo.getTxTotAmnt());
                     payr0302Vo.setPayPymtDducPrcsFlag("N");
                     payr0302Vo.setPayReattyAdmntVal("0");
                     payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
                     payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
	                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
	                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
	                   
                     payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                     
                     payrCommCalcService.insertPayr0302(payr0302Vo);  
                     
                     
              	     payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                     payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
                     payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
                     payr0301Vo.setPayCd(payCalculationVo.getPayCd());          
                     payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
                     payr0301Vo.setPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt());   
                     payr0301Vo.setExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt() );  
                     payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
                     payr0301Vo.setFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt());
                     payr0301Vo.setDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt());   
                     payr0301Vo.setTxTotAmnt(pkgPayrAmntVo.getTxTotAmnt());     
                     payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
                     payr0301Vo.setPernPymtSum((pkgPayrAmntVo.getTpPymtTotAmnt().subtract((pkgPayrAmntVo.getTpDducTotAmnt().add(pkgPayrAmntVo.getTxTotAmnt())))));   
                     payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
                     payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
                     payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
                     payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
                     payr0301Vo.setPayDdlneDt("");    
                     payr0301Vo.setPayDdlneYn("N");   
                     payr0302Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
	                   payr0302Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
	                   payr0302Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
	                   
                     
                     payrCommCalcService.updatePayr0301(payr0301Vo); //월급여내역  
                     
                 } else {
               	 
                	 //소득세 주민세처리 루틴 변경 적용 2017.08.21
               	       pkgPayrAmntVo.setTxTotAmnt(payrTaxCtl.getWorkIncmTxtn( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt()));
               	      
               	     payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */  
                     payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
                     payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
                     payr0301Vo.setPayCd(payCalculationVo.getPayCd());         
                     payr0301Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());
                     payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
                     payr0301Vo.setPymtTotAmnt(pkgPayrAmntVo.getTpPymtTotAmnt());   
                     payr0301Vo.setExtpyTotAmnt(pkgPayrAmntVo.getTpExtpyTotAmnt() );  
                     payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
                     payr0301Vo.setFreeDtyTotAmnt(pkgPayrAmntVo.getTpFreeDtyTotAmnt());
                     payr0301Vo.setDducTotAmnt(pkgPayrAmntVo.getTpDducTotAmnt());   
                     payr0301Vo.setTxTotAmnt(pkgPayrAmntVo.getTxTotAmnt());     
                     payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
                     payr0301Vo.setPernPymtSum((pkgPayrAmntVo.getTpPymtTotAmnt().subtract((pkgPayrAmntVo.getTpDducTotAmnt().add(pkgPayrAmntVo.getTxTotAmnt())))));   
                     payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));  
                     payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
                     payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
                     payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
                     payr0301Vo.setPayDdlneDt("");    
                     payr0301Vo.setPayDdlneYn("N");    
					 payr0301Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
					 payr0301Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost())); 
					   
			
						payrCommCalcService.updatePayr0301(payr0301Vo);
             	}
               
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //월급여내역   
     
	}
	  	 
}