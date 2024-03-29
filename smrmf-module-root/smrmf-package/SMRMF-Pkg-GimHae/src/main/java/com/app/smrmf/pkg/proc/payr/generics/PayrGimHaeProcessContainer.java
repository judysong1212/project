package com.app.smrmf.pkg.proc.payr.generics;

 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.constc.gimhae.ConstGimHae;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0307VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0309VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0450SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0490VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0530VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.pkg.insr.insurance.PkgInsrController;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrWorkVO;
import com.app.smrmf.pkg.insr.insurance.service.PkgPayrInsrStdSrhVO;
import com.app.smrmf.pkg.insr.insurance.service.PkgPayrInsrStdVO;
import com.app.smrmf.pkg.payr.income.tax.PayrTaxController;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;
import com.app.smrmf.pkg.proc.payr.pay.calculation.service.PayCalculationService;
import com.app.smrmf.props.ExtermsProps;
import com.app.smrmf.utils.PayrPkgUtil;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 각 급여 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class PayrGimHaeProcessContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(PayrGimHaeProcessContainer.class);
	
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
	 

	  /**
		     * 
		     * <pre>
		     * 1. 개요 :스케줄링에 따른 급여계산 로직 
		     * 2. 처리내용 : 
		     * </pre>
		     * @Method Name : execPayr4100ToPayCalculation
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
		     * @param voPayr0250
		     * @return
		     * @throws Exception
		     */
		  	public PagingLoadResult<ShowMessageBM> execPayr4100ToPayCalculation(HttpServletRequest request,InfcPkgPayr0250VO voPayr0250)  throws Exception  {
		  	    
		  	  return  funcPayr4100ToPayrCalc(request,voPayr0250,null,null );
		  	}
		  	
		  	/**
		  	 *  
		  	 * <pre>
		  	 * 1. 개요 : 추가선택된 인원에 따른 급여계산로직 - 단건개별로직. 
		  	 * 2. 처리내용 : 
		  	 * </pre>
		  	 * @Method Name : execPayr4100ToPayCalcSeft
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
		  	 * @param voPayr0250
		  	 * @param voPsnl0100
		  	 * @return
		  	 * @throws Exception
		  	 */
		  	public PagingLoadResult<ShowMessageBM>  execPayr4100ToPayCalcSeft(HttpServletRequest request,InfcPkgPayr0250VO voPayr0250,InfcPkgPsnl0100VO voPsnl0100)  throws Exception  {
		  	     return  funcPayr4100ToPayrCalc(request,voPayr0250,voPsnl0100,null );
		  	} 
		     
		  	/**
		  	 * 
		  	 * <pre>
		  	 * 1. 개요 : 여러건에 대한 로직 처리  
		  	 * 2. 처리내용 : 
		  	 * </pre>
		  	 * @Method Name : setPayr4100ToPayCalcMulti
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
		  	 * @param voPayr0250
		  	 * @param voPsnl0100
		  	 * @return
		  	 * @throws Exception
		  	 */
		 	public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalcMulti(HttpServletRequest request,InfcPkgPayr0250VO voPayr0250,List<InfcPkgPsnl0100VO> listPsnl0100)  throws Exception  {
		  	     return  funcPayr4100ToPayrCalc(request,voPayr0250,null,listPsnl0100);
		  	}
		  	
		  	
		  	/**
		  	 * 급여처리로직 
		  	 * @param request
		  	 * @param voPayr0250
		  	 * @param voPsnl0100
		  	 * @return
		  	 */
		  	private PagingLoadResult<ShowMessageBM> funcPayr4100ToPayrCalc(HttpServletRequest request,InfcPkgPayr0250VO voPayr0250,InfcPkgPsnl0100VO voPsnl0100,List<InfcPkgPsnl0100VO> listPsnl0100)  throws Exception {
		  	    
		  	 
		  	  PagingLoadResult<ShowMessageBM> retval = null; 
		  	  List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		  	  boolean boolInsert = false;
		  	 
		  	
		      if (ExtermsProps.getProps("EMYMT_DIVCD_01").equals(voPayr0250.getEmymtDivCd())) {
		   	   /*****************************************************************************************************************
		   	    * 공무직 정액제 및 일당제적용 호봉
		   	    *****************************************************************************************************************/
		   	    
			  	  /**
		           * 개별 근로자 처리를 위한 vo객체에 값 넣기 
		           */
		          if (voPsnl0100 != null) {
		        	  
		        	   voPayr0250.setSystemkey(voPsnl0100.getSystemkey());  
		        	  
		        	 
		              if (MSFSharedUtils.paramNull(voPsnl0100.getSystemkey())) {
		           	   boolInsert = true;  //payr0300 급여마스터 인서트 여부 
		              }
		              bmResult =  procEmymtDivCd01(request,voPayr0250,voPsnl0100,  boolInsert);
		              
		          } else {
		        	 
		        	  if ((listPsnl0100 != null) && (listPsnl0100.size() > 0)) {
		        		//멀티건 처리를 위한 로직 추가 
		        		   for(int iPayrCnt=0;iPayrCnt < listPsnl0100.size();iPayrCnt++) { 
		        			    
		        			   List<ShowMessageBM>  vBmResult = new ArrayList<ShowMessageBM>();
		                      InfcPkgPsnl0100VO   infcPkgPsnl0100Vo = new  InfcPkgPsnl0100VO(); 
		                      boolInsert = false; 
		                      infcPkgPsnl0100Vo = (InfcPkgPsnl0100VO)listPsnl0100.get(iPayrCnt); 
		                       voPayr0250.setSystemkey(infcPkgPsnl0100Vo.getSystemkey());  
		                   	
		                      
		                       if (MSFSharedUtils.paramNull(infcPkgPsnl0100Vo.getSystemkey())) {
		     	           	       boolInsert = true;  //payr0300 급여마스터 인서트 여부 
		     	               }  
		                   
		     	              vBmResult =  procEmymtDivCd01(request,voPayr0250,infcPkgPsnl0100Vo,  boolInsert);  
		     	              bmResult.addAll(iPayrCnt,vBmResult);
		        		   }
		        	 
		        	  } else {
		        		
		        		  voPayr0250.setSystemkey(""); 
		        		  boolInsert = true;  //payr0300 급여마스터 인서트 여부 
		        		  bmResult =  procEmymtDivCd01(request,voPayr0250,voPsnl0100,  boolInsert);
		        	  
		        	  }
		          } 
		           
		   	   
		   	   /*****************************************************************************************************************
		   	    * 공무직 정액제 및 일당제적용 호봉
		   	    *****************************************************************************************************************/
		   	   
		      } else {
		   	   /*****************************************************************************************************************
		   	    * 기간제 정액제 및 일당제적용 호봉
		   	    *****************************************************************************************************************/ 
		             
		    	  /**
		           * 개별 근로자 처리를 위한 vo객체에 값 넣기 
		           */
		          if (voPsnl0100 != null) {
		        	  
		        	  voPayr0250.setSystemkey(voPsnl0100.getSystemkey());  
		              if (MSFSharedUtils.paramNull(voPsnl0100.getSystemkey())) {
		           	   boolInsert = true;  //payr0300 급여마스터 인서트 여부 
		              }
		              bmResult =  procEmymtDivCd02(request,voPayr0250,voPsnl0100,  boolInsert);
		              
		          } else {
		        	 
		        	  if ((listPsnl0100 != null) && (listPsnl0100.size() > 0)) {
		        			//멀티건 처리를 위한 로직 추가 
		        		   for(int iPayrCnt=0;iPayrCnt < listPsnl0100.size();iPayrCnt++) { 
		        			   List<ShowMessageBM>  vBmResult = new ArrayList<ShowMessageBM>();
		                      InfcPkgPsnl0100VO   infcPkgPsnl0100Vo = new  InfcPkgPsnl0100VO(); 
		                      boolInsert = false; 
		                      infcPkgPsnl0100Vo =  (InfcPkgPsnl0100VO)listPsnl0100.get(iPayrCnt); 
		                       voPayr0250.setSystemkey(infcPkgPsnl0100Vo.getSystemkey());  
		     	               if (MSFSharedUtils.paramNull(infcPkgPsnl0100Vo.getSystemkey())) {
		     	           	       boolInsert = true;  //payr0300 급여마스터 인서트 여부 
		     	               }  
		                   
		     	              vBmResult =  procEmymtDivCd02(request,voPayr0250,infcPkgPsnl0100Vo,  boolInsert);  
		     	              bmResult.addAll(iPayrCnt,vBmResult);
		        		   }
		        		  
		        		  
		        	 
		        	  } else {
		        		
		        		  voPayr0250.setSystemkey(""); 
		        		  boolInsert = true;  //payr0300 급여마스터 인서트 여부 
		        		  bmResult =  procEmymtDivCd02(request,voPayr0250,voPsnl0100,  boolInsert);
		        	  
		        	  }
		          } 
		           
		   	   /*****************************************************************************************************************
		   	    * 기간제 정액제 및 일당제적용 호봉
		   	    *****************************************************************************************************************/
		   	   
		      }
		    
		      retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
		       
		 	  return retval;
		 	 
		  		
		  	}
		  	

	  	
	   
    	 
	  	/**
	  	 * 급여처리로직 
	  	 * @param request
	  	 * @param dtoPayr0250
	  	 * @param voPsnl0100
	  	 * @return
	  	 */
	 private List<ShowMessageBM>  procEmymtDivCd01(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250,InfcPkgPsnl0100VO voPsnl0100,boolean boolInsert)  throws Exception {
	    
	  	//  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
	  	//소득세계산을 위한 메서드 
          payrTaxCtl = PayrTaxController.getInstance();
          
         // 4대 보험 메소드  
          pkgInsrCtl = PkgInsrController.getInstance(); 
          
          payrCommCalcService = (PayrCommCalcService)BeanFinder.getBean("PayrCommCalcService");
	  	  payCalculationService = (PayCalculationService)BeanFinder.getBean("PayCalculationService");

           int iDducCnt = 0;
           
           InfcPkgPayr0520SrhVO payr0520SrhVo = new InfcPkgPayr0520SrhVO();
          
           InfcPkgPayr0520VO  payr0520Vo = null;
           InfcPkgPayr0250VO  payr0250Vo = new InfcPkgPayr0250VO();
           InfcPkgPayr0300VO  payr0300Vo = new InfcPkgPayr0300VO();
           InfcPkgPayr0301VO  payr0301Vo = new InfcPkgPayr0301VO();
           InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
           InfcPkgPayr0304VO  payr0304Vo = new InfcPkgPayr0304VO();
           InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
           InfcPkgPayr0306VO  payr0306Vo = new InfcPkgPayr0306VO(); 
           InfcPkgPayr0410VO  payr0410Vo = new InfcPkgPayr0410VO();
           InfcPkgPayr0530VO  payr0530Vo = new InfcPkgPayr0530VO();
          
           //4대보험처리 TempVO 객체 
           PkgInsrWorkVO   pkgInsrWorkVo = new PkgInsrWorkVO();
           
           //항목별수당
           InfcPkgPayr0450SrhVO payr0450SrhVo = new InfcPkgPayr0450SrhVO();
           InfcPkgPayr0520VO  payr0450Vo = null;
           
           //직책별 수당 
           InfcPkgPayr0460SrhVO payr0460SrhVo = new InfcPkgPayr0460SrhVO();
           InfcPkgPayr0460VO  payr0460Vo = null;
           
           
           InfcPkgPayr0410SrhVO payr0410SrhVo = new InfcPkgPayr0410SrhVO();
           PkgPayrInsrStdSrhVO payrInsrStdSrhVo = new PkgPayrInsrStdSrhVO();
           PkgPayrInsrStdVO payrInsrStdVo = null;
           
           //시간외 근무 및 기본근무집계내역을 가지는 객체
           //Dlgn0100VO dlgn0100Vo = new Dlgn0100VO();   //기본근무
           //Dlgn0200VO dlgn0200Vo = new Dlgn0200VO();   //시간외근무(휴일근무포함)
            
           
           PkgPayrCommCalcVO payCalculationVo = null;
           
           //가족수당 합
           BigDecimal tpFamyExtpySum = BigDecimal.ZERO;
           
           BigDecimal tpFamyFreeExtpySum = BigDecimal.ZERO;
           
           //학비보조금함계
           BigDecimal  tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;
           BigDecimal  tpStdPymtTotAmnt = BigDecimal.ZERO;   //기본
           //pymtTotAmnt 지급총액
           BigDecimal  tpPymtTotAmnt = BigDecimal.ZERO;
           //extpyTotAmnt 수당총액
           BigDecimal  tpExtpyTotAmnt = BigDecimal.ZERO;
           //txtnTotAmnt 과세총액 
         //  BigDecimal  tpTxtnTotAmnt = BigDecimal.ZERO;
           //freeDtyTotAmnt 비과세총액 
           BigDecimal  tpFreeDtyTotAmnt = BigDecimal.ZERO;
           //dducTotAmnt  공제총액 
           BigDecimal  tpDducTotAmnt = BigDecimal.ZERO;
           
           BigDecimal abnceNumDysCnt  = BigDecimal.ZERO; //실결근일수  
           
           //기본급정보 
            BigDecimal basePymtAmnt =  BigDecimal.ZERO;
        
            pkgInsrWorkVo.setTpTxtnTotAmnt(BigDecimal.ZERO); //txtnTotAmnt 과세총액 
            pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);          //건강보험
            pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);     //요양 
            pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);              //국민연금
            pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);        //고용
            pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);               //보수금액
            pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO);        //과세대상금액
                                               
            //과세합계
            BigDecimal txTotAmnt =  BigDecimal.ZERO;
            
           //월 출력체크 
           String chkMonth = "N";
           boolInsert = true;  //payr0300 급여마스터 인서트 여부 
           
       //    DlgnProcessContainer dlgnProcessContainer = new DlgnProcessContainer();
           Map<String, Object> mapPayr = new HashMap<String, Object>();
              
            if (MSFSharedUtils.paramNull(dtoPayr0250.getJobYrMnth()) 
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getPayrMangDeptCd()) 
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getPymtDt()) 
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getRflctnBgnnDt())
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getRflctnEndDt())) {
            	
            	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","스케줄정보","급여스케줄정보 이상!!! 확인요망." )); 
                 
            }
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
     
         try {
             
                   // 근태관리정리작업 진행 인터페이스 호출 
                   // 근태관리테이블에 데이터 존재여부 확인 없으면 메시지출력 함. 
                   // 근무시간 가져오기 - 시간외 근무인경우는 두가지 경우로 처리함.
                   // dlgnProcessContainer.setSelectManageDlgn0100CommuteService(payr0250Vo);
                   // dlgnProcessContainer.setSelectManageDlgn0200CommuteService(payr0250Vo);
              
                   //사회보험요율가져오기 
//                 //  List insureList =   pkgInsrCtl.getSelect4InsureDataList(payr0250Vo);  
//                   
//                   if (insureList.size() > 0) {
//                	 //  BaseModel bm = new BaseModel();
//                	   ShowMessageBM smBm = new ShowMessageBM();
//                	   smBm.setDivision(PropPayGenConfs.PAYGEN_INFO);
//                	   smBm.setMenu("Payr");
//                	   smBm.setPhase("[급여]4대보험요율");
//                	   smBm.setMessage("불러오기성공");
//                	   smBm.setContent("");
//                	   bmResult.add(smBm); 
//                   }  
                   
                   
               //    if (ExtermsProps.getProps("EMYMT_DIVCD_02")EMYMT_DIVCD_01.equals(payr0250Vo.getEmymtDivCd())) {
                	  
                	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여]처리시작","무기계약직",""));  
                  /**
                   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   * 무기계약직 
                   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
                   */ 
                    	//List<String> listDeptCd = new ArrayList<String>();
                       ArrayList strDducPayr0520= new ArrayList();  
                       payr0250Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부  
                       payr0250Vo.setUsrId(sessionUser.getUsrId());  
                       /******************************** 권한 ************************************************************************/
                       payr0250Vo.setDeptCdAuth(payr0250Vo.getDeptCd());  //권한처리를위해 추가  
                       payr0250Vo.setDtilOccuInttnCdAuth(payr0250Vo.getDtilOccuInttnCd());   
              
                       String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
                       if ("FALSE".equals(chkDeptCd)) {
                    	   payr0250Vo.setDeptCd(sessionUser.getDeptCd());  
                    	   //listDeptCd.add(sessionUser.getDeptCd());
                    	  // payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드    
                    	   payr0250Vo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
                       } else {
                       	    
                    	     
                                if (payr0250Vo.getPayrMangDeptCd().equals(payr0250Vo.getDeptCd())) {  
                                	//listDeptCd = null; 
                                	//payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드 
                                	payr0250Vo.setDeptCd("");  //부서코드
                               
                                } else {  
                                	
                                	payr0250Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0250Vo.getPayrMangDeptCd())) ;   //단위기관코드
	                                if (payr0250Vo.getDeptCd().equals("ALL")) {
	                                	//listDeptCd = null; 
	                                	//payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드 
	                                	payr0250Vo.setDeptCd("");  //부서코드
	                                } else {  
	                                	payr0250Vo.setDeptCd(MSFSharedUtils.allowNulls(payr0250Vo.getDeptCd()));
	                                    // listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0250Vo.getDeptCd()));  
	                                    // payr0250Vo.setDeptCdArr(listDeptCd);     //부서코드   
	                                } 
                                }    
                             
                       }
                       /******************************** 권한 ************************************************************************/
                       //무기계약직인경우 처리를 위한 부분  
                        //TODO 확인 필요 
//                          if ( (ExtermsProps.getProps("EMYMT_DIVCD_02")AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (ExtermsProps.getProps("EMYMT_DIVCD_02")AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
//                           //기간제업무담당자- 기간제업무담당자
//                             
//                          } else  if (ExtermsProps.getProps("EMYMT_DIVCD_02")AUTH_USR_DIV_10.equals(sessionUser.getUsrDivCd())) {
//                           //무기계약직업무담당자- 무기계약직업무담당자
//                              //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                              if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                                      && (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//                                 
//                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
//                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
//                                  payr0250Vo.setPayrMangDeptYn("");
//                                  
//                              } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                                      && (!ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//                                  
//                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
//                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
//                                  payr0250Vo.setPayrMangDeptYn("");
//                                  
//                              } else { 
//                                  //TODO 전체관리자나 총괄관리자일경우 선택된 항목을 가지고 처리하는 루틴 추가 
//                                  payr0250Vo.setTypOccuCd(""); 
//                                  payr0250Vo.setPyspGrdeCd("");
//                                  payr0250Vo.setPayrMangDeptYn("");
//                              }
//                                
//                          } else  if (ExtermsProps.getProps("EMYMT_DIVCD_02")AUTH_USR_DIV_25.equals(sessionUser.getUsrDivCd())) {
//                              //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
//                                 //   GWT.log("Field count: " + ((FormPanel) cmp).getFields().size());
//                              if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                                      && (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//                                 
//                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
//                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
//                                  payr0250Vo.setPayrMangDeptYn("");
//                                  
//                              } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                                      && (!ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//                                 
//                                  payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())); 
//                                  payr0250Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()));
//                                  payr0250Vo.setPayrMangDeptYn("");
//                                  
//                              } else { 
//                                  //TODO 전체관리자나 총괄관리자일경우 선택된 항목을 가지고 처리하는 루틴 추가
//                                  payr0250Vo.setTypOccuCd(""); 
//                                  payr0250Vo.setPyspGrdeCd("");
//                                  payr0250Vo.setPayrMangDeptYn("");
//                              }
//                                   
//                                
//                          } else  if (ExtermsProps.getProps("EMYMT_DIVCD_02")AUTH_USR_DIV_30.equals(sessionUser.getUsrDivCd())) {
//                            //무기계약직업무담당자- 무기계약직업무담당자
//                              if ("Y".equals(sessionUser.getPayrMangDeptYn())) {
//                                  
//                                  payr0250Vo.setPayrMangDeptYn("Y"); 
//                              
//                              } else {
//                                  payr0250Vo.setPayrMangDeptYn("");  
//                              }
//                            
//                          } else  if (ExtermsProps.getProps("EMYMT_DIVCD_02")AUTH_USR_DIV_60.equals(sessionUser.getUsrDivCd())) {  
//                              
//                                 
//                          }
                       
                       
                      
                       //인사정보 추출 //근태기록도 같이 가져옴.
                       //검색조건 지급년월 기준으로 정보를 가져온다. 
                       //근태관리의 근무일수 산정등...데이타 가져오기 결과값.
                       //시스템키. 및 무기계약직에서 환경미화원 담당자 인경우 처리를 위한 변수 값을 가져오기 위한 처리 추가 . 
                     
                       //--
                       List<PkgPayrCommCalcVO>  psnlList = payCalculationService.selectGimHaePayrInfoList(payr0250Vo);  
                       
                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여]" + String.valueOf(psnlList.size()) + "명처리중","무기계약직",""));  
                       for (int icnt = 0; icnt < psnlList.size();icnt++) { 
                          //사람데이타 처리  
                           payCalculationVo = new PkgPayrCommCalcVO();
                           payCalculationVo = (PkgPayrCommCalcVO)psnlList.get(icnt);
                          
                           if ("Y".equals(payCalculationVo.getPayRcptYn())) {
                               
                                   if (boolInsert) {
                                       //직종 // 근속년수 에따른 급여 항목 정보 추출 및 단가표에서 값을 가지고 온다. 
                                       //검색조건 - 지급년월, 사용여부 년월에 지급여 
                                       payr0410SrhVo.setDpobCd(payr0250Vo.getDpobCd());  //사업장코드 
                                       payr0410SrhVo.setPayYr(payr0250Vo.getJobYrMnth().substring(0, 4)); //급여항목년도 
                                       
                                       //payCalculationService.selectPayrItemUnitInfoList(searchVO);
                                        
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
                                    	   payrCommCalcService.insertPayr0300(payr0300Vo); 
                                      }
                                       boolInsert = false;
                                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]급여마스터저장" ,"급여마스터저장완료","")); 
                                   }
                                   

                                   /*************************************************************** 
                                    4대보험 이력 테이블 추가 
                                   ****************************************************************/
                                    InfcPkgPayr0309VO payr0309Vo = new InfcPkgPayr0309VO();
                                    InfcPkgPayr0309VO tpPayr0309Vo = new InfcPkgPayr0309VO();
                                   
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
                                     
                                      payrCommCalcService.insertPayr0309(payr0309Vo);
                                      
                                  } else {
                                      
                                      payrCommCalcService.updatePayr0309(payr0309Vo);
                                  }
                                  
                           	     
                                   /*************************************************************** 
                                                                                  급여 계산을 위한 초기화 
                                   ****************************************************************/
                                 
                                   tpFamyExtpySum = BigDecimal.ZERO;            //가족수당 합 
                                   tpFamyFreeExtpySum =  BigDecimal.ZERO;            //가족수당 비과세합계  
                                   tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;   //학비보조금함계
                                   tpStdPymtTotAmnt= BigDecimal.ZERO;   //기본
                                   tpPymtTotAmnt = BigDecimal.ZERO;             //pymtTotAmnt 지급총액
                                   tpExtpyTotAmnt = BigDecimal.ZERO;            //extpyTotAmnt 수당총액
                                   //tpTxtnTotAmnt = BigDecimal.ZERO;             //txtnTotAmnt 과세총액 
                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;          //freeDtyTotAmnt 비과세총액
                                   tpDducTotAmnt = BigDecimal.ZERO;             //dducTotAmnt  공제총액 
                                     abnceNumDysCnt  = BigDecimal.ZERO; //실결근일수 
                                     
                                   pkgInsrWorkVo.setTpTxtnTotAmnt(BigDecimal.ZERO); //txtnTotAmnt 과세총액 
                                   pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);          //건강보험
                                   pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);     //요양 
                                   pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);              //국민연금
                                   pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);        //고용
                                   pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);               //보수금액
                                   pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO);        //과세대상금액
                                   
                                   chkMonth = "N";                               //월 출력체크
                             
                                  if ((payCalculationVo.getExPayr0410() != null)  && (!payCalculationVo.getExPayr0410().isEmpty())) { 
                                    
                                      /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                       *  월급여내역개인 인서트  시작
                                       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                      
                                      //1. 이미등록된 정보인지 확인 하고 정보가 존재하면 스킾  
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
                                      /************************************************************************************
                                       * 전역에서 사용되는 값처리를 위한 선언부  
                                       ************************************************************************************/
                                      abnceNumDysCnt = (new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).subtract((new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())));
                                       
                                      /************************************************************************************
                                       * 전역에서 사용되는 값처리를 위한 선언부  
                                       ************************************************************************************/  
                                      
                                      bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]월급여내역인서" ,"월급여내역저장완료","대상자 : " + payCalculationVo.getHanNm())); 
                                      /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                       *  월급여내역개인 인서트  종료
                                       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                      
                              
                                        if (ExtermsProps.getProps("PAY_CD_01").equals(payr0250Vo.getPayCd())) { 
                                                /**@@@@@@@@@
                                                 * @@@@@@@@@@@@@@@@@@@@@@ 월급여 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                 @@@@@@@@@@@ */ 
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
            //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
            //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                
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
                                                        	 
                                                        	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
                                                        	   
                                                        	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
                                                        		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
                                                        	   }
                                                           }
                                                            //가족수당 합
                                                            tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
                                                            //학비보조금함계
                                                            tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum()); 
                                                            
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
                                                    	 basePymtAmnt = payr0410Be.getUcstSum();
                                                    	 
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
                                                           iDducCnt = 0;
//                                                           for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//                                                               
//                                                                payr0520Vo  = new InfcPkgPayr0520VO();
//                                                                    
//                                                                BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt)); 
//                                                              
//                                                                
//                                                                if (payr0520Vo.getPayItemCd().equals(payr0410.getPayrImcd())) {
//                                                                 
//                                                                        if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) != 0) { 
//                                                                             
//                                                                            payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//                                                                            payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                            payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//                                                                            payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//                                                                            payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//                                                                            payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                            payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//                                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                            payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
//                                                                                                           .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//            //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//            //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//            //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//            //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//            //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//            //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//                                                                            
//                                                                           if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) != 0) {
//                                                                        	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
//                                                                                  payrCommCalcService.insertPayr0302(payr0302Vo);  
//                                                                        	   }   
//                                                                            } 
//                                                                         
//                                                                            tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//                                                                           
//                                                                        } else {
//                                                                        	//금액이 아닌 비율로 처리 되는 경우 
//                                                                        	 if ((payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate()).compareTo(BigDecimal.ZERO) > 0) { 
//                                                                                 
//                                                                                 payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                                 payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//                                                                                 payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                                 payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                                 payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                                 payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//                                                                                 payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//                                                                                 payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//                                                                                 payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                                  
//                                                                                 payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
//                                                                                  
//                                                                                 payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                                 payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                                 payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                                                                                 //payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
//                                                                                   //                             .subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//                 //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                 //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                 //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                 //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                 //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                 //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//                                                                                 
//                                                                                 BigDecimal dducSumRate = (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate());
//                                                                                 BigDecimal dducSum = BigDecimal.ZERO;
//                                                                                 
//                                                                                 dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
//                                                                                  
//                                                                                 payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
//                                                                                 
//                                                                                if ((payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducRate() : payr0410.getPymtDducRate()).compareTo(BigDecimal.ZERO) > 0) {
//                                                                             	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  { 
//                                                                             		   
//                                                                                       payrCommCalcService.insertPayr0302(payr0302Vo);  
//                                                                             	   }   
//                                                                                 } 
//                                                                              
//                                                                                 tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
//                                                                                
//                                                                             }
//                                                                        	
//                                                                        }
//                                                                        strDducPayr0520.add(payr0410.getPayrImcd());  
//                                                                       
//                                                                    }   
//                                                               }
                                                         //  logger.debug("여기서 시작인데 :" + payCalculationVo.getHanNm() + ":" +payr0410.getPayrImcd() );
                                                           /**
                                                            * Payr0410에 등록된 공제 인경우 
                                                            */
                                                           if (ExtermsProps.getProps("PAY_DDUC_CD_92001").equals(payr0410.getPayrImcd())) {
                                                        	 //상조회인경우 처리   
                                                        	  // logger.debug("값이 넘어오는가5 :" + payCalculationVo.getHanNm() + ":" +payr0410.getPayrImcd() );
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
            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                             
                                                               
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn()))  {  
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                            	   tpDducTotAmnt = tpDducTotAmnt.add(payr0410.getPymtDducSum());
                                                               }   
                                                        	   
                                                               strDducPayr0520.add(payr0410.getPayrImcd());  
                                                        	   
                                                           } else if (ExtermsProps.getProps("PAY_DDUC_CD_95004").equals(payr0410.getPayrImcd())) {
                                                        	 //노조회비 인경우 처리 
                                                        	  // logger.debug("값이 넘어오는가2 :" + payCalculationVo.getHanNm() + ":" +basePymtAmnt );
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
            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                               
                                                               
                                                               BigDecimal dducSumRate = (payr0410.getPymtDducRate());
                                                               BigDecimal dducSum = BigDecimal.ZERO;
                                                               
                                                               dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
                                                                
                                                               payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
                                                               
                                                             // if ( payr0410.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn())) {
                                                           	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0 && "Y".equals(payCalculationVo.getUnnMbspSttYn()))  { 
                                                           		   
                                                                     payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                     tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
                                                           	   }   
                                                             //  }  
                                                        	   strDducPayr0520.add(payr0410.getPayrImcd());  
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
            //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                 
                                                            
                                                               // if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
                                                               if (abnceNumDysCnt.compareTo(BigDecimal.ZERO) > 0) {
                                                            	   
                                                                	// if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
                                                            	   if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))) > 0)) {
                                                                           
                                                                         mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                        
                                                                        // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
                                                                        // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
                                                                      
                                                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                        		 .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())
                                                                        		 .add(abnceNumDysCnt))).setScale(-1, 1);
                                                                        		    //  .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                        				// .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
                                                                         
                                                                     }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
                                                                       
                                                                         dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                         
                                                                     } else {
                                                                         
                                                                         dayPaySum = BigDecimal.ZERO;
                                                                     }
	                                                                //결근이 존재하는 경우 결근 빼기 - 시급통상임금 구해서 처리 해야 함. 그러기 위해서 다시 정의 해야 함. 
	                                                               //  payCalculationVo.getDilnlazAbnceNumDys()   /** column 근태_결근일수 : dilnlazAbnceNumDys */
                                                            	 //(new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))
	                                                                abnceNumDysAmt =  abnceNumDysCnt.multiply(payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal(ConstGimHae.PAYR_BASS_WKTM_GH_01)));  // USALY_AMNT_HRWG_QNTY 시급통상임금 
	                                                                
                                                                } else {
                                                                	
                                                                	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
                                                                          
                                                                          mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                         
                                                                         // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
                                                                         // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
                                                                       
                                                                          dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                        		  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
                                                                        		//  .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                          
                                                                      }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
                                                                        
                                                                          dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                          
                                                                      } else {
                                                                          
                                                                          dayPaySum = BigDecimal.ZERO;
                                                                      }
                                                                }
                                                                
                                                                payr0302Vo.setPymtDducSum(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));   /** column 지급공제금액 : pymtDducSum */
                                                                payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                               
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));
                                                               // tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                tpStdPymtTotAmnt= tpStdPymtTotAmnt.add(payr0302Vo.getPymtDducSum());   //기본급
                                                                
                                                                if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                	payrCommCalcService.insertPayr0302(payr0302Vo);
                                                                }	
                                                               
                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0410.getPayrImcd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                                
                                                                BigDecimal dayFmyPayAmt = BigDecimal.ZERO; //일급계산 
                                                                BigDecimal dayFreeFmyPayAmt = BigDecimal.ZERO; //일급프리금액 
                                                                 
                                                                
                                                               // if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
                                                                if (abnceNumDysCnt.compareTo(BigDecimal.ZERO) > 0) {
                                                                //결근은 가족수당을 제외하지 않음.
                                                                	  //if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
                                                                	 if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))) > 0)) {
                                                                         
                                                                		  if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
		                                                               			
		                                                               		dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP)) 
		                                                               				.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
		                                                               				//.add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
		                                                               				//.add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))
		                                                               	
		                                                               		} else {
		                                                               		  dayFmyPayAmt = BigDecimal.ZERO;
		                                                               	  
		                                                               		}
		                                                               		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
				                                                            
		                                                               			dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
		                                                               					            .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
		                                                               					          //  .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
		                                                               					          //  .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))
		                                                               		
		                                                               		} else {
		                                                               			dayFreeFmyPayAmt =  BigDecimal.ZERO;
		                                                               		} 
		                                                               }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
		                                                                 
		                                                            	   dayFmyPayAmt = tpFamyExtpySum;
		                                                            	   dayFreeFmyPayAmt = tpFamyFreeExtpySum;
		                                                               } else {
		                                                                   
		                                                            	   dayFmyPayAmt = BigDecimal.ZERO;
		                                                            	   dayFreeFmyPayAmt =  BigDecimal.ZERO;
		                                                               }
                                                                } else {
                                                                
		                                                              if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
		                                                               		if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
		                                                               		
		                                                               			dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
		                                                               					         .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
		                                                               					        // .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
		                                                               			
		                                                               		} else {
		                                                               		  dayFmyPayAmt = BigDecimal.ZERO;
		                                                               	  
		                                                               		}
		                                                               		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
		                                                               			
				                                                               		dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
				                                                               				    .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
				    		                                                               		
				                                                               				   // .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
		                                                               		} else {
		                                                               			dayFreeFmyPayAmt =  BigDecimal.ZERO;
		                                                               		} 
		                                                               }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
		                                                                 
		                                                            	   dayFmyPayAmt = tpFamyExtpySum;
		                                                            	   dayFreeFmyPayAmt = tpFamyFreeExtpySum;
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
            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
                                                                   
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(dayFmyPayAmt);
                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayFmyPayAmt);
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt));
                                                               
                                                                  if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
                                                                		  payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                	  }
                                                                   } 
                                                                  
                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0410.getPayrImcd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                               //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */  
                                                               payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                              
            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                              
                                                               // B0050001    B005    0001    과세
                                                               // B0050002    B005    0002    비과세
                                                               // B0050003    B005    0003    부분과세
                                                                
                                                               if (ExtermsProps.getProps("PAY_CALC_TX_B005_02").equals(payr0410.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_01").equals(payr0410.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_03").equals(payr0410.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               } else {
                                                            	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                               }
                                                          
                                                               
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
                                                                 
                                                                
                                                                  if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                		  payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                	  }	  
                                                                   } 
                                                           
                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_04").equals(payr0410.getPayrImcd())) {
                                                             //선임인력수당 -직채수당인경우 처리 루틴          
                                                             //직책별 수당  
                                                                payr0460Vo = new InfcPkgPayr0460VO();
                  
                                                                payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
                                                                payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                                payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
                                                                payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
                                                                payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
                                                             
                                                                payr0460Vo = payrCommCalcService.selectPayr0460(payr0460Vo);
                                                               
                                                               if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
                                                                   
                                                                   payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                                   payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
                                                                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                                   payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
                                                                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                                   payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducSum(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                                                                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(payr0460Vo.getOdtyDtilOccuClsSum().subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
            //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                   
                                                                   
                                                                   tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {     
                                                                	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                   }
                                                               } 
                                                                      
                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_50").equals(payr0410.getPayrImcd())) {
                                                             // 근속가산금 - 비호봉제   
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
            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {    
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                               }  
                     
                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_51").equals(payr0410.getPayrImcd())) {
                                                             //정근수당 -비호봉제 
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
            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {    
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                 
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
            //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
            //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
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
                                                                 payr0302Vo.setPymtDducSum(basePymtAmnt);   /** column 지급공제금액 : pymtDducSum */
                                                                 payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                                 payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                                 payr0302Vo.setPymtDducTxtnAmnt(basePymtAmnt.subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
              //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
              //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
              //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
              //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
              //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
              //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                  //정확한 기말 수당을 구하기 위한 로직 구현부 여기에 추가한다.  
                                                                  //매분기 직전 3개월간의 지급한 기본급의 합계 /3 을 한값   
                                                                 InfcPkgPayr0302VO tpPayr0302vo = new InfcPkgPayr0302VO();
                                                                 
                                                                 //TODO 확인후 다시 확인 
                                                                 tpPayr0302vo = payCalculationService.selectGHPayr0302C9020100(payr0302Vo);
                                                                  
                                                                 edPymtAmnt = (basePymtAmnt.add((tpPayr0302vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? tpPayr0302vo.getPymtDducSum() 
                                                                		                    : payr0410.getPymtDducSum()))).divide(new BigDecimal("3"), -1, BigDecimal.ROUND_DOWN)  ;
                                                                 
                                                                 payr0302Vo.setPymtDducSum(edPymtAmnt);   /** column 지급공제금액 : pymtDducSum */
                                                                 payr0302Vo.setPymtDducTxtnAmnt(edPymtAmnt.subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
             
                                                                 
                                                                 tpPymtTotAmnt = tpPymtTotAmnt.add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                                                                 tpExtpyTotAmnt = tpExtpyTotAmnt.add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
                                                                 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
                                                              	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                 }     
                                                               
                                                           } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_33").equals(payr0410.getPayrImcd())) {
                                                               //public static final String PAY_EMYMT_PYMT_33 = "C9440100";    //		월정수당
                                                        	     
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
                                                                 payr0302Vo.setPymtDducSum(basePymtAmnt);   /** column 지급공제금액 : pymtDducSum */
                                                                 payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                                 payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                                 payr0302Vo.setPymtDducTxtnAmnt(basePymtAmnt.subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
              //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
              //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
              //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
              //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
              //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
              //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                  //정확한 기말 수당을 구하기 위한 로직 구현부 여기에 추가한다.  
                                                                   
                                                                 edPymtAmnt = basePymtAmnt.divide(new BigDecimal("3"), -1, BigDecimal.ROUND_DOWN)  ;
                                                                 
                                                                 payr0302Vo.setPymtDducSum(edPymtAmnt);   /** column 지급공제금액 : pymtDducSum */
                                                                 payr0302Vo.setPymtDducTxtnAmnt(edPymtAmnt.subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
             
                                                                 
                                                                 tpPymtTotAmnt = tpPymtTotAmnt.add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                                                                 tpExtpyTotAmnt = tpExtpyTotAmnt.add(edPymtAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
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
	            //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
	            //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
	            //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
	            //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
	            //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
	            //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
	                                                                
	                                                                 // if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
	                                                                      if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
	                                                                            
	                                                                          if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
	                                                                                //시간외근무  -USALY_AMNT_HRWG_QNTY 계산된 시급으로 정리한다. 통상시급 
	                                                                                  BigDecimal ucstSum = payr0410.getUsalyAmntHrwgQnty(); //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
	                                                                                
	                                                                                  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
	                                                                                	  ucstSum =  payr0410.getUsalyAmntHrwgQnty();  //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
	                                                                                  } 
	                                                                                  
	                                                                                  BigDecimal totTmSum = BigDecimal.ZERO;
	                                                                                  
	                                                                                  totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
	                                                                                  
	                                                                                  
	                                                                                  payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
	                                                                                  payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                                                                                  
	                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
	                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
	                                                                                  
	                                                                                  if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
	                                                                                      tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
	                                                                                  }
	                                                                                  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
	                                                                                	  payrCommCalcService.insertPayr0302(payr0302Vo);   
	                                                                                  }	  
	                                                                            }
	                                                                            
	                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
	                                                                        // 토요근무수당   --일수산정C9410700 USALY_AMNT_PDY_QNTY
	                                                                    	  
	                                                                         if (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0) {
	                                                                        	 
	                                                                              BigDecimal ucstSum = payr0410.getUsalyAmntPdyQnty(); //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
	                                                                              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
                                                                                	  ucstSum = payr0410.getUsalyAmntPdyQnty(); //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                  } 
	                                                                              BigDecimal totTmSum = BigDecimal.ZERO;
	                                                                              
	                                                                              totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
	                                                                              
	                                                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
	                                                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                                                                              
	                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
	                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
	                                                                              
	                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
	                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
	                                                                              }
	                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
	                                                                            	  payrCommCalcService.insertPayr0302(payr0302Vo);    
	                                                                              }
	                                                                          }
	                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
	                                                                       // 야간수당       -- 시간산정C9410300 MNTH_USALY_AMNT_WAG
	                                                                          if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
	                                                                        	  //BigDecimal ucstSum =  (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5))).multiply(new BigDecimal("2"))).setScale(0,BigDecimal.ROUND_DOWN);
	                                                                              BigDecimal ucstSum = ((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5)).multiply(new BigDecimal("2"))).setScale(0,BigDecimal.ROUND_DOWN);
	                                                                              //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
	                                                                              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
	                                                                            	  //ucstSum = (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5)).multiply(new BigDecimal("2")))).setScale(0,BigDecimal.ROUND_DOWN);
	                                                                            	  ucstSum = ((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5)).multiply(new BigDecimal("2"))).setScale(0,BigDecimal.ROUND_DOWN);
                                                                                	  //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                  } 
	                                                                              BigDecimal totTmSum = BigDecimal.ZERO;
	                                                                              
	                                                                              totTmSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotNtotTm(),"0"))).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
	                                                                               
	                                                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
	                                                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                                                                               
	                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
	                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
	                                                                              
	                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
	                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
	                                                                              }
	                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
	                                                                            	  payrCommCalcService.insertPayr0302(payr0302Vo); 
	                                                                              }	  
	                                                                          }
	                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
	                                                                    	  /****************************************************************************************/
		                                                                    	// 휴일수당        -- 일수 C9410200
		                                                                    	/****************************************************************************************/  
		                                                                          if (MSFSharedUtils.paramNotNull(payCalculationVo.getDilnlazPubcHodyDutyNumDys())) {
		                                                                        	  
		                                                                              if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0) {
		                                                                            	  
		                                                                            	  /**********************************************************/
		                                                                            	  // 연장근무가 포함되어 있는경우 처리를 위한 루틴 추가 
		                                                                            	  // 연장근무은 시간으로 처리함.
		                                                                            	  /**********************************************************/
		                                                                            	  BigDecimal ucstSum = (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5)).multiply(new BigDecimal("8"))).multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN);
			                                                                              //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                                                              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                                                            	  //ucstSum = (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5)).multiply(new BigDecimal("2")))).setScale(0,BigDecimal.ROUND_DOWN);
			                                                                            	  ucstSum = (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5)).multiply(new BigDecimal("8"))).multiply(new BigDecimal("1.5"))).setScale(5,BigDecimal.ROUND_DOWN);
		                                                                                	  //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
		                                                                                  } 
			                                                                               
		                                                                                   
		                                                                                  BigDecimal totTmSum = BigDecimal.ZERO;    //휴일근무처리를 위한 부분  
		                                                                                  BigDecimal totTmlnSum = BigDecimal.ZERO;  //연장근무처리를 위한 추가 부분 
		                                                                            	  
		                                                                            	   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0410.getDayMnthAmntDivCd())) 
		                                                                                           && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) { 

				                                                                               totTmSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0"))).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
				                                                                                  
		                                                                            		   
		                                                                            		   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
		                                                                            			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
			                                                                                       // dilnlazHodyTotNtotTm  //연장근무시간 
		                                                                            			   BigDecimal tmUcstSum = BigDecimal.ZERO;
		                                                                            			   // 시간근무환산 
		                                                                            			   tmUcstSum = (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5))).multiply(new BigDecimal("2"))).setScale(5,BigDecimal.ROUND_DOWN);
			                                                                            		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
		                                                                            		 
		                                                                            		   } else {
		                                                                            			
		                                                                            			   totTmlnSum = BigDecimal.ZERO;
		                                                                            			   
		                                                                            		   } 
		                                                                            		   
		                                                                                   } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && ((
		                                                                                           ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0410.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0410.getDayMnthAmntDivCd()))
		                                                                                           )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
		                                                                                       //월정액,월액인경우  
		                                                                                	   totTmSum = ucstSum;
		                                                                                	   
		                                                                                   } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0410.getDayMnthAmntDivCd())) 
		                                                                                           && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
		                                                                                	   
		                                                                                	   BigDecimal tmUcstSum = BigDecimal.ZERO;  //시간값처리 
		                                                                                	   
		                                                                                	   tmUcstSum = (((payr0410.getMnthUsalyAmntWag().divide(new BigDecimal("209"), 5))).multiply(new BigDecimal("2"))).setScale(5,BigDecimal.ROUND_DOWN);
		                                                                                	   
		                                                                                	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
		                                                                            			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
			                                                                                       // dilnlazHodyTotNtotTm  //연장근무시간 
		                                                                            			  
		                                                                            			   // 시간근무환산 
		                                                                                		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0"))).multiply(tmUcstSum);  //휴일근무 
			                                                                            		    
		                                                                            		   } else {
		                                                                            			
		                                                                            			   totTmSum = BigDecimal.ZERO;
		                                                                            			   
		                                                                            		   } 
		                                                                                	   
		                                                                                	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
		                                                                            			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
			                                                                                       // dilnlazHodyTotNtotTm  //연장근무시간  
			                                                                            		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
		                                                                            		 
		                                                                            		   } else {
		                                                                            			
		                                                                            			   totTmlnSum = BigDecimal.ZERO;
		                                                                            			   
		                                                                            		   } 
		                                                                                 
		                                                                                   } 
		                                                                            	   
		                                                                            	  totTmSum = totTmSum.add(totTmlnSum);
		                                                                                  
		                                                                                  payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
		                                                                                  payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
		                                                                                  
		                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
		                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
		                                                                                  
		                                                                                  if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
		                                                                                      tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
		                                                                                  }
		                                                                                  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
		                                                                                	  payrCommCalcService.insertPayr0302(payr0302Vo); 
		                                                                                  }	  
		                                                                              }
		                                                                          }
	                                                                    	     
	                                                                      } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
	                                                                          // 유급휴일수당  -- 일수 산정 C9415000
	                                                                          if (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0) {
	                                                                             
	                                                                              BigDecimal ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
	                                                                              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
                                                                                	  ucstSum = payr0410.getUsalyAmntPdyQnty();//payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                  } 
	                                                                              BigDecimal totTmSum = BigDecimal.ZERO;
	                                                                              
	                                                                              totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
	                                                                              
	                                                                              payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
	                                                                              payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                                                                              
	                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
	                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
	                                                                              
	                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
	                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
	                                                                              }
	                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
	                                                                            	  payrCommCalcService.insertPayr0302(payr0302Vo);    
	                                                                              }	  
	                                                                          }
	                                                                      } else   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0410.getPayrImcd())) {
	                                                                            //PAY_EMYMT_PYMT_18 = "C9080100";    // 정액급식비
	                                                                    	      BigDecimal dayPaySum = BigDecimal.ZERO; 
                                                                                  BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                              
                                                                                 // if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
                                                                                  if (abnceNumDysCnt.compareTo(BigDecimal.ZERO) > 0) { 
                                                                                  //결근은 정액급식비 을 제외 급여모자랄시  
                                                                                //	  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
                                                                                	  if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))) > 0)) {
                                                                                                   
	                                                                                	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
	                                                                                			     .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
	                                                                                			        //  .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
	                                                                                			    	//	 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))
	                                                                                      
	                                                                                  }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
	                                                                                    
	                                                                                      dayPaySum = ucstSum.setScale(-1,BigDecimal.ROUND_DOWN);
	                                                                                      
	                                                                                  } else {
	                                                                                      
	                                                                                      dayPaySum = BigDecimal.ZERO;
	                                                                                  } 
                                                                                  } else { 
	                                                                                  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
	                                                                                       
	                                                                                	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
	                                                                                			   .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
	                                                                                	//   .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
	                                                                                      
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
                                                                                  
	                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
	                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                                  } else {
                                                                                	  
                                                                                	  payr0302Vo.setPymtDducFreeDtySum(dayPaySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                                                                                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                  
	                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
	                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(dayPaySum); 
                                                                                  }
                                                                                  if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                      tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayPaySum);
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
	                                                                              
	                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
	                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
	                                                                              
	                                                                              if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
	                                                                                  tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
	                                                                              }
	                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
	                                                                            	  payrCommCalcService.insertPayr0302(payr0302Vo);    
	                                                                              }	  
	                                                                          }
	                                                                      } else {
	                                                                    	  if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() 
	                                                                  			  : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { //
			                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
			                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
			                                                                          
			                                                                          if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
			                                                                              tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
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
                                          if(tpPymtTotAmnt.compareTo(BigDecimal.ZERO) > 0) { 
                                        	  
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
      //                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
      //                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
      //                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
      //                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
      //                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
      //                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
                                                  	payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                  	   
                                                        //과세금액 및 공제등 금액 처리 
                                                        tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0302Vo.getPymtDducSum()); // 급여합계
                                                        tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0302Vo.getPymtDducSum()); // 수당합계  
                                                        tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0302Vo.getPymtDducFreeDtySum());//비과세금액 
                                                             
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
		            //                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
		            //                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
		            //                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
		            //                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
		            //                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
		            //                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
		                                                        if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
		                                                        	payrCommCalcService.insertPayr0302(payr0302Vo);  
		                                                        
		                                                        	tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));  
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
     //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
     //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
     //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
     //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
     //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
     //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
                                                                     
                                                                     BigDecimal dducSumRate =  payr0520Vo.getPymtDducRate() ;
                                                                     BigDecimal dducSum = BigDecimal.ZERO;
                                                                     
                                                                     dducSum = basePymtAmnt.multiply((dducSumRate.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN);
                                                                      
                                                                     payr0302Vo.setPymtDducSum(dducSum);   /** column 지급공제금액 : pymtDducSum */
                                                                     
                                                                    if (payr0520Vo.getPymtDducRate().compareTo(BigDecimal.ZERO) > 0 ) {
                                                                 	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  { 
                                                                 		   
                                                                           payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                           
                                                                           tpDducTotAmnt = tpDducTotAmnt.add(dducSum);
                                                                 	   }   
                                                                     }  
                                                                 }
	                                                    	 }   
	                                                 }  
	                                               }
	                                        
	                                            /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
	                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
	                                               
	                                           
                                          }      
                                         
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
	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	                                                        payrCommCalcService.insertPayr0302(payr0302Vo);
	                                                        
	                                                        if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
	                                                            //과세금액 및 공제등 금액 처리 
	                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
	                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
	                                                            
	                                                        } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
	                                                            //과세금액 및 공제등 금액 처리 
	                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
	                                                            tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
	                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
	                                                            
	                                                        } else {
	                                                            tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
	                                                        } 
	                                                        
	                                                    }
	                                            }
	                                            /**===============================================================================================
	                                             * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
	                                             * 과세대상금액, 비과세금액 처리 종료 
	                                             ================================================================================================*/
                                           
	                                            /*########################################################################################*/
		                                           /**  4대보험 처리 로직  추가                                                                                                                                                                                              **/
		                                           /*########################################################################################*/   
		                                            
			                                         //과세대상금액  
				                          	        pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt));
				                          	        //공제금액합계
				                          	        pkgInsrWorkVo.setTpDducTotAmnt(tpDducTotAmnt);
				                          	        //기본금액 
				                          	        pkgInsrWorkVo.setTpStdPymtTotAmnt(tpStdPymtTotAmnt);
				                          	      payr0250Vo.setSystemkey(payCalculationVo.getSystemkey());
				                          	        pkgInsrWorkVo = pkgInsrCtl.func4InsureService(request,payCalculationVo
				                          	        		       ,payr0250Vo,pkgInsrWorkVo); 

				                          	        //공제금액 - 4대보험 합계포함 
					                          	    tpDducTotAmnt = tpDducTotAmnt.add(pkgInsrWorkVo.getTpDducTotAmnt());
			                                   
		                                          /*########################################################################################*/
		                                          /**  4대보험 처리 로직  종료                                                                            	  **/
		                                          /*########################################################################################*/  
					                          	        
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
	                                                    
//	                                        	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
//	                                        	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
//	                                        	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
//	                                        	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
	                                            
	                                            
	                                                if  (MSFSharedUtils.paramNotNull(infcInsr3100VO) && MSFSharedUtils.paramNotNull(infcInsr3100VO.getSystemkey())) { 
														
														 //공제금액처리 건강보험관련  
														if (infcInsr3100VO.getMbrAlttHlth().compareTo(BigDecimal.ZERO) != 0) {
															
//				                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
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
	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	                                                        payrCommCalcService.insertPayr0302(payr0302Vo); 
		                                                        
		                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttHlth()); //공제합계 
		                                                    
														}  
														
														if (infcInsr3100VO.getMbrAlttLgtmRcptn().compareTo(BigDecimal.ZERO) != 0) {
//				                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
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
		        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
		        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
		        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
		        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
		        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
		        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
		                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
		                                                        
		                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttLgtmRcptn()); //공제합계 
														}
	                                                    
//	                                                    if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//															//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
////				                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
//															  /** column 건강환급금이자 : hlthInsrRefdItrt */
//														
//															payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
//	                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//	                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//	                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//	                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//		        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//		        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//		        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//		        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//	                                                        payrCommCalcService.insertPayr0302(payr0302Vo);  
//	                                                        tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
//	                                                    }    
//	                                                    if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////				                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
//															  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
//															 
//															payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//	                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//	                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//	                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//	                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//	                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
//	                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//	                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//	                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//	                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//	                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//	                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//	                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//		        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//		        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//		        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//		        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//		                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
//		                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
//	                                                    }
	                                                }
	                                          //  } 
	                                        	
	                                        	 /**===============================================================================================
	                                             * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
	                                             * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
	                                             ================================================================================================*/
                                        	
                                          //월급여내역 합계를 구한다. 
                                            // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
                                            
	                                                pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt)); 
                                                    //과세대상금액 
                                                   pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO); //과세대상금액  
                                                   txTotAmnt =  BigDecimal.ZERO;    //과세합계
                                                    
                                                   pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgInsrWorkVo.getTpTxtnTotAmnt());  
                                           
                                                   //소득세 주민세처리 루틴 변경 적용 2017.08.21
                                                   txTotAmnt = payrTaxCtl.getWorkIncmTxtn( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());
                                                   
                                         
		                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */  
		                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
		                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
		                                           payr0301Vo.setPayCd(payCalculationVo.getPayCd());         
		                                           payr0301Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());
		                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
		                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
		                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
		                                           payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
		                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
		                                           payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
		                                           payr0301Vo.setTxTotAmnt(txTotAmnt);     
		                                           payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
		                                           payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
		                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
		                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
		                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
		                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
		                                           payr0301Vo.setPayDdlneDt("");    
		                                           payr0301Vo.setPayDdlneYn("N");   
		                                           
		                                           payrCommCalcService.updatePayr0301(payr0301Vo); //월급여내역  
                                            
                                        } else if (ExtermsProps.getProps("PAY_CD_02").equals(payr0250Vo.getPayCd())) {
                                            /**
                                             *   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                               * @@@@@@@@@@@@@@@@@@@@@@ 복리후생비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                               *  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                               */ 
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
        //                                   payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                   payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                   payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                   payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                   payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                   payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                            
                                            
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
        //                                                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                      
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
                                                                        
                                                                        tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                        tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                        
                                                                        if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                            tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
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
                                                                
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                
                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
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
                                                                 
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                
                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                }
                                                                
                                                                payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                                
                                                            } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
                                                              // 휴일수당        -- 일수 C9410200
                                                            	 /**********************************************************/
                                                          	  // 연장근무가 포함되어 있는경우 처리를 위한 루틴 추가 
                                                          	  // 연장근무은 시간으로 처리함.
                                                          	  /**********************************************************/
                                                            	 BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                 if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
                                                               	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                 } 
                                                                 
                                                                BigDecimal totTmSum = BigDecimal.ZERO;    //휴일근무처리를 위한 부분  
                                                                BigDecimal totTmlnSum = BigDecimal.ZERO;  //연장근무처리를 위한 추가 부분 
                                                          	  
                                                          	   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0410.getDayMnthAmntDivCd())) 
                                                                         && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                      
                                                          		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0"))).multiply(ucstSum);  //휴일근무
                                                          		   
                                                          		   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                          			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                         // dilnlazHodyTotNtotTm  //연장근무시간 
                                                          			   BigDecimal tmUcstSum = BigDecimal.ZERO;
                                                          			   // 시간근무환산 
                                                          			   tmUcstSum = ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).add(
                                                          					              ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
                                                              		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                          		 
                                                          		   } else {
                                                          			
                                                          			   totTmlnSum = BigDecimal.ZERO;
                                                          			   
                                                          		   } 
                                                          		   
                                                                 } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && ((
                                                                         ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0410.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0410.getDayMnthAmntDivCd()))
                                                                         )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                     //월정액,월액인경우  
                                                              	   totTmSum = ucstSum;
                                                              	   
                                                                 } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0410.getDayMnthAmntDivCd())) 
                                                                         && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                     
                                                              	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                          			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                         // dilnlazHodyTotNtotTm  //연장근무시간 
                                                          			  
                                                          			   // 시간근무환산 
                                                              		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0"))).multiply(ucstSum);  //휴일근무 
                                                              		    
                                                          		   } else {
                                                          			
                                                          			   totTmSum = BigDecimal.ZERO;
                                                          			   
                                                          		   } 
                                                              	   
                                                              	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                          			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                         // dilnlazHodyTotNtotTm  //연장근무시간 
                                                          			   BigDecimal tmUcstSum = BigDecimal.ZERO;
                                                          			   // 시간근무환산 
                                                          			   tmUcstSum = (ucstSum.add((ucstSum.multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
                                                              		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                          		 
                                                          		   } else {
                                                          			
                                                          			   totTmlnSum = BigDecimal.ZERO;
                                                          			   
                                                          		   } 
                                                               
                                                                 } 
                                                          	   
                                                          	  totTmSum = totTmSum.add(totTmlnSum); 
                                                               
                                                                
                                                                payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                
                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
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
                                                                
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                
                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                }
                                                                
                                                                payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                                
                                                            } else {
                                                                
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                
                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
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
                                            payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
                                            payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
                                            payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
                                            payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
                                            payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
                                            payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
                                            payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
                                            payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
                                            payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
                                            payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
                                            payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
                                            payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
                                            payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
                                            payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
        //                                   payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                   payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                   payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                   payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                   payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                   payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                            
                                            payrCommCalcService.updatePayr0301(payr0301Vo); 
                                            
                                            /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                             *  급여 항목에 따른 인서트 및 계산 처리 종료 
                                               @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
                                               
                                       } else if (ExtermsProps.getProps("PAY_CD_03").equals(payr0250Vo.getPayCd())) {
                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           * @@@@@@@@@@@@@@@@@@@@@@ 월급여 2회차 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           */ 
                                             
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
                        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                           
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
                                                               
                                                               if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
                                                                       (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
                                                                       && (payr0250Vo.getPymtDt().compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
                                                                       && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
                                                            	 
	                                                            	   
	                                                                   // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
	                                                                   if  ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
	                                                                	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
	                                                                	  
	                                                                	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
	                                                                		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
	                                                                	   }
	                                                                   }
                                                                       //가족수당 합
                                                                       tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
                                                                       //학비보조금함계
                                                                       tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum());
        
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
                                                                 //tpFamyExtpySum = tpFamyExtpySum.ad());
                                                               
                                                            }  
                                                          /*########################################################################################*/
                                                          /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
                                                          /*########################################################################################*/  
                                                    
                                                        
                                                        /*########################################################################################*/
                                                        /**  공제관련 항목  시작                                                                                                                                                                         **/
                                                        /*########################################################################################*/    
                        //                                payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
                        //                                payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
                        //                                payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 
                        //                                payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);
                        //                                //공제테이블 
                        //                                List listDducPayr0520 = payrCommCalcService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
                                                          
                                                        /*########################################################################################*/
                                                        /**  공제관련 항목  가져오기                                                                                                                                                                    **/
                                                        /*########################################################################################*/     
                                                        
                                                          
                                                          /*########################################################################################*/
                                                          /**  수당관련 항목  시작                                                                                                                                                                         **/
                                                          /*########################################################################################*/    
                                                          payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
                                                          payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
                                                          payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 
                                                          payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_02"));
                                                          //공제테이블 
                                                          List listPymtPayr0520 = payrCommCalcService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
                                                            
                                                          /*########################################################################################*/
                                                          /**  공제관련 항목  가져오기                                                                                                                                                                       **/
                                                          /*########################################################################################*/  
                                                          
                                                          /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                                           *  급여 항목에 따른 인서트 및 계산 처리 시작 
                                                             @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                                          Set<InfcPkgPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
                                                       
                                                          Iterator<InfcPkgPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
                                                          
                                                          while ( iterpayr0410Set.hasNext() ) { 
                                                              
                                                                InfcPkgPayr0410VO payr0410 = iterpayr0410Set.next();
                                                           
                                                                if (PayrPkgUtil.funcMonthCheck(payr0250Vo, payr0410,null)) {
                                                                  
                                                                  //공제 처리 루틴  
                                                                  if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0410.getPymtDducDivCd())) {
                                                                      
                        //                                              iDducCnt = 0;
                        //                                              for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
                        //                                                  
                        //                                                   payr0520Vo  = new Payr0520VO();
                        //                                                       
                        //                                                   BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
                        //                                                   
                        //                                                 
                        //                                                   
                        //                                                   if (payr0520Vo.getPayItemCd().equals(payr0410.getPayrImcd())) {
                        //                                                    
                        //                                                           if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { 
                        //                                                                
                        //                                                               payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
                        //                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                        //                                                               payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
                        //                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                        //                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                        //                                                               payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
                        //                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                        //                                                               payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                        //                                                               payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                        //                                                               payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()));   /** column 지급공제금액 : pymtDducSum */
                        //                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                        //                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                        //                                                               payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum())
                        //                                                                                              .subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                        ////                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        ////                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        ////                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        ////                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        ////                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        ////                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
                        //                                                               
                        //                                                              if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
                        //                                                                     payrCommCalcService.insertPayr0302(payr0302Vo);  
                        //                                                               } 
                        //                                                            
                        //                                                               tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0410.getPymtDducSum()));
                        //                                                              
                        //                                                           }  
                        //                                                           strDducPayr0520.add(payr0410.getPayrImcd());  
                        //                                                          
                        //                                                       }   
                        //                                                  }
                                                                       
                                                                      
                                                                  } else {
                                                                      //공제를 제외한 수당 인서트  
                                                                      if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0410.getPayrImcd())) {
                                                                       //기본급처리 루틴 근무일수 /실근무일수가 다른경우처리 루틴 추가    
                                                                          
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
                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                          payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                                          payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                            
                                                                       //    if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
                                                                             if (abnceNumDysCnt.compareTo(BigDecimal.ZERO) > 0) {
             	                                                                //결근이 존재하는 경우 결근 빼기 
                                                                            	 mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                                 //dayPayAmt =  mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()))).setScale(-1, 1);
                                                                                 //dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())));
                                                                                 dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                                		 .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
                                                                               // .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                			   // .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))
             	                                                               //  payCalculationVo.getDilnlazAbnceNumDys()   /** column 근태_결근일수 : dilnlazAbnceNumDys */
             	                                                                abnceNumDysAmt =  abnceNumDysCnt.multiply(payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal(ConstGimHae.PAYR_BASS_WKTM_GH_01)));  // USALY_AMNT_HRWG_QNTY 시급통상임금 
             	                                                               //(new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))
                                                                             } else {    
                                                                            	 
                                                                               mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                               //dayPayAmt =  mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()))).setScale(-1, 1);
                                                                               //dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())));
                                                                               dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                            		   .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);

                                                                             }
                                                                               
                                                                               payr0302Vo.setPymtDducSum(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));   /** column 지급공제금액 : pymtDducSum */
                                                                               payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                             
                                                                         
                                                                        //   }  else {
                                                                               
                                                                        //       dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                        //   }
                                                                          
                                                                               
                                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));
                                                                              // tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
                                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                               tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(payr0302Vo.getPymtDducSum()) ;
                                                                               
                                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                               }   
                                                                          
                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0410.getPayrImcd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                    	  //가족수당  C9050100  
                                                                    	  BigDecimal dayFmyPayAmt = BigDecimal.ZERO; //일급계산 
                                                                          BigDecimal dayFreeFmyPayAmt = BigDecimal.ZERO; //일급프리금액 
                                                                    
                                                                      // if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
                                                                          if (abnceNumDysCnt.compareTo(BigDecimal.ZERO) > 0) { 
                                                                              //결근은 가족수당을 제외하지 않음.
                                                                    		if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
                                                                         		  dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                         				            .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
                                                                         				           // .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                         				           // .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))
                                                                         		} else {
                                                                         		  dayFmyPayAmt = BigDecimal.ZERO;
                                                                         	  
                                                                         		}
                                                                         		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
                                                                         			
          		                                                               		dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
          		                                                               				.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
          		                                                               				//.add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
          		                                                               				//		.add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))
          		                                                               		
                                                                         		} else {
                                                                         			dayFreeFmyPayAmt =  BigDecimal.ZERO;
                                                                         		}
                                                                    	   
                                                                        } else {
                                                                     // if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
                                                                       		if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
                                                                       		  dayFmyPayAmt = (tpFamyExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                       				  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
                                                                       				  //.add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                       		} else {
                                                                       		  dayFmyPayAmt = BigDecimal.ZERO;
                                                                       	  
                                                                       		}
                                                                       		if (tpFamyFreeExtpySum.compareTo(BigDecimal.ZERO) > 0) { 
        		                                                               		dayFreeFmyPayAmt = (tpFamyFreeExtpySum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP)) 
        		                                                               				.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1);
        		                                                               				//.add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                       		} else {
                                                                       			dayFreeFmyPayAmt =  BigDecimal.ZERO;
                                                                       		}
                                                                        }
                                                                      // }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
                                                                         
                                                                    	//   dayFmyPayAmt = tpFamyExtpySum;
                                                                    	//   dayFreeFmyPayAmt = tpFamyFreeExtpySum;
                                                                      // } else {
                                                                           
                                                                    	//   dayFmyPayAmt = BigDecimal.ZERO;
                                                                    	//   dayFreeFmyPayAmt =  BigDecimal.ZERO;
                                                                      // } 
                                                                      
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
                    //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                    //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                    //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                    //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                    //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                    //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
                                                                           
                                                                        tpPymtTotAmnt = tpPymtTotAmnt.add(dayFmyPayAmt);
                                                                        tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayFmyPayAmt);
                                                                        tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().add(dayFreeFmyPayAmt));
                                                                       
                                                                          if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                        	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                        		  payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                        	  }	  
                                                                           }  
                                                                             
                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0410.getPayrImcd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                                          //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
                                                                          payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                                          payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                                          payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
                                                                          payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                                          payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                                          payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
                                                                          payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                                          payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                                          payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                          payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
                                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                                          payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                                          payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                         
                                                                          
                                                                          if ("B0050002".equals(payr0410.getTxtnDivCd())) {
                                                                              payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                              payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                                          } else  if ("B0050001".equals(payr0410.getTxtnDivCd())) {
                                                                              payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                              payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                              tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                                          } else  if ("B0050003".equals(payr0410.getTxtnDivCd())) {
                                                                              payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                              payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                          } else {
                                                                       	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                              payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                              tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                                          }
                                                                     
                                                                          
                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
                                                                            
                                                                           
//                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//                                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                           
                                                                             if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                            	 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                            		 payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                            	 }	 
                                                                              } 
                                                                      
                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_04").equals(payr0410.getPayrImcd())) {
                                                                        //선임인력수당 -직채수당인경우 처리 루틴          
                                                                        //직책별 수당  
                                                                           payr0460Vo = new InfcPkgPayr0460VO();
                             
                                                                           payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
                                                                           payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                                           payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
                                                                           payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
                                                                           payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
                                                                        
                                                                           payr0460Vo = payrCommCalcService.selectPayr0460(payr0460Vo);
                                                                          
                                                                          if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
                                                                              
                                                                              payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                                              payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
                                                                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                                              payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
                                                                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                                              payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                                              payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                              payr0302Vo.setPymtDducSum(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                                                                              payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                                              payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                                              payr0302Vo.setPymtDducTxtnAmnt(payr0460Vo.getOdtyDtilOccuClsSum().subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                              
                                                                              
                                                                              tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                              tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                              tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                              if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
                                                                            	  payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                              } 
                                                                          } 
                                                                                 
                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_50").equals(payr0410.getPayrImcd())) {
                                                                        // 근속가산금   
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
                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                          
                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                        	  payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                          } 
                                
                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_51").equals(payr0410.getPayrImcd())) {
                                                                        //정근수당
                                                                          
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
                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                          
                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
                                                                        	  payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                          } 
                                                                          
                                                                          
                                                                      } else if (ExtermsProps.getProps("PYMT_ITEM_52").equals(payr0410.getPayrImcd())) {
                                                                        //장기근속수당 
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
                        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                          
                                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                          if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
                                                                        	  payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                            
                                                                          }
                                                                      } else {
                                                                           
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
                        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                           
                                                                             if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
                                                                                 if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
                                                                                      
                                                                             
                                                                                     if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
                                                                                           //시간외근무 
                                                                                         
                                                                                             BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                            		 //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                                             BigDecimal totTmSum = BigDecimal.ZERO;
                                                                                             
                                                                                             totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
                                                                                             
                                                                                             
                                                                                             payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                                             payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                             
                                                                                             tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                                             tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                                             
                                                                                             if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                                 tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                                             }
                                                                                             if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {  
                                                                                            	 payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                                                             }	 
                                                                                       }
                                                                                       
                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
                                                                                   // 토요근무수당   --일수산정C9410700
                                                                                     
                                                                                     BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                     BigDecimal totTmSum = BigDecimal.ZERO;
                                                                                     
                                                                                     totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
                                                                                     
                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                     
                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                                     
                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                                     }
                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                                    	 payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                                                     }
                                                                                     
                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
                                                                                  // 야간수당       -- 시간산정C9410300
                                                                                     
                                                                                     BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                     BigDecimal totTmSum = BigDecimal.ZERO;
                                                                                     
                                                                                     totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotNtotTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
                                                                                      
                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                      
                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                                     
                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                                     }
                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
                                                                                    	 payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                                                     }
                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
                                                                                   // 휴일수당        -- 일수 C9410200
                                                                                	 /**********************************************************/
	                                                                            	  // 연장근무가 포함되어 있는경우 처리를 위한 루틴 추가 
	                                                                            	  // 연장근무은 시간으로 처리함.
	                                                                            	  /**********************************************************/
                                                                                	 BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                    
	                                                                                   
	                                                                                  BigDecimal totTmSum = BigDecimal.ZERO;    //휴일근무처리를 위한 부분  
	                                                                                  BigDecimal totTmlnSum = BigDecimal.ZERO;  //연장근무처리를 위한 추가 부분 
	                                                                            	  
	                                                                            	   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0410.getDayMnthAmntDivCd())) 
	                                                                                           && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
	                                                                                        
	                                                                            		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0"))).multiply(ucstSum);  //휴일근무
	                                                                            		   
	                                                                            		   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
	                                                                            			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
		                                                                                       // dilnlazHodyTotNtotTm  //연장근무시간 
	                                                                            			   BigDecimal tmUcstSum = BigDecimal.ZERO;
	                                                                            			   // 시간근무환산 
	                                                                            			   tmUcstSum = ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).add(
	                                                                            					              ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
		                                                                            		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
	                                                                            		 
	                                                                            		   } else {
	                                                                            			
	                                                                            			   totTmlnSum = BigDecimal.ZERO;
	                                                                            			   
	                                                                            		   } 
	                                                                            		   
	                                                                                   } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && ((
	                                                                                           ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0410.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0410.getDayMnthAmntDivCd()))
	                                                                                           )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
	                                                                                       //월정액,월액인경우  
	                                                                                	   totTmSum = ucstSum;
	                                                                                	   
	                                                                                   } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0410.getDayMnthAmntDivCd())) 
	                                                                                           && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
	                                                                                       
	                                                                                	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
	                                                                            			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
		                                                                                       // dilnlazHodyTotNtotTm  //연장근무시간 
	                                                                            			  
	                                                                            			   // 시간근무환산 
	                                                                                		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0"))).multiply(ucstSum);  //휴일근무 
		                                                                            		    
	                                                                            		   } else {
	                                                                            			
	                                                                            			   totTmSum = BigDecimal.ZERO;
	                                                                            			   
	                                                                            		   } 
	                                                                                	   
	                                                                                	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
	                                                                            			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
		                                                                                       // dilnlazHodyTotNtotTm  //연장근무시간 
	                                                                            			   BigDecimal tmUcstSum = BigDecimal.ZERO;
	                                                                            			   // 시간근무환산 
	                                                                            			   tmUcstSum = (ucstSum.add((ucstSum.multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
		                                                                            		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
	                                                                            		 
	                                                                            		   } else {
	                                                                            			
	                                                                            			   totTmlnSum = BigDecimal.ZERO;
	                                                                            			   
	                                                                            		   } 
	                                                                                 
	                                                                                   } 
	                                                                            	   
	                                                                            	  totTmSum = totTmSum.add(totTmlnSum);
                                                                                     
                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                     
                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                                     
                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                                     }
                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                                    	 payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                                                     }
                                                                                 } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
                                                                                     // 유급휴일수당  -- 일수 산정 C9415000
                                                                                         
                                                                                     BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                     BigDecimal totTmSum = BigDecimal.ZERO;
                                                                                     
                                                                                     totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
                                                                                     
                                                                                     payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                                     payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                     
                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                                     
                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                                     }
                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                                    	 payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                                     }
                                                                                 } else   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0410.getPayrImcd())) {
     	                                                                            //PAY_EMYMT_PYMT_18 = "C9080100";    // 정액급식비
     	                                                                    	      BigDecimal dayPaySum = BigDecimal.ZERO; 
                                                                                       BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                                      
                                                                                      // if ((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
                                                                                       if (abnceNumDysCnt.compareTo(BigDecimal.ZERO) > 0) { 
                                                                                       //결근은 정액급식비 을 제외 급여모자랄시  
                                                                                    	   dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                                    			   .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
                                                                                    			          //  .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                                    					  // .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))
                                                                                       } else { 
                                                                                      // if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) > 0)) {
                                                                                           dayPaySum = ((ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),5, BigDecimal.ROUND_UP))
                                                                                        		   .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, 1)).setScale(-1,BigDecimal.ROUND_DOWN);
                                                                                        		 //  .add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
                                                                                           
                                                                                      // }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))) == 0)) {
                                                                                         
                                                                                       //    dayPaySum = ucstSum;
                                                                                           
                                                                                       //} else {
                                                                                           
                                                                                       //    dayPaySum = BigDecimal.ZERO;
                                                                                       //} 
                                                                                       } 
                                                                                       
                                                                                       if (dayPaySum.compareTo(payr0410.getFreeDtySum()) >= 0) {
     	                                                                                  payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
     	                                                                                  payr0302Vo.setPymtDducTxtnAmnt(dayPaySum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                       
     	                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
     	                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                                       } else {
                                                                                     	  
                                                                                     	  payr0302Vo.setPymtDducFreeDtySum(dayPaySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
     	                                                                                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                                       
     	                                                                                  tpPymtTotAmnt = tpPymtTotAmnt.add(dayPaySum); 
     	                                                                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(dayPaySum); 
                                                                                       }
                                                                                       
                                                                                       if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(dayPaySum);
                                                                                       }
                                                                                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                                    	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                                                       }
                                                                                 } else {
                                                                                     
                                                                                     tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                                     tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                                     
                                                                                     if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                                         tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                                                     }
                                                                                     if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                                    	 	payrCommCalcService.insertPayr0302(payr0302Vo);   
                                                                                     }	 	
                                                                                 }
                                                                                   
                                                                              }  
                                                                            
                                                                      } 
                                                                       
                                                                  }  
                                                                  
                                                               } 
                                                                
                                                          }  //
                                                          
                                                          //항목에 없는 데이터 인서트 (공제)
                        //                                  for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
                        //                                      
                        //                                       boolean payr0520chk = true; 
                        //                                       payr0520Vo  = new Payr0520VO();
                        //                                      // payr0200Vo = (Payr0200VO) listPayr0200.get(iCnt);
                        //                                       BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
                        //                                       
                        //                                       
                        //                                       for (int iduCnt = 0; iduCnt < strDducPayr0520.size(); iduCnt++) {
                        //                                           
                        //                                           if (strDducPayr0520.get(iduCnt).equals(payr0520Vo.getPayItemCd())) {
                        //                                               payr0520chk = false ;
                        //                                           } 
                        //                                       }
                        //                                       
                        //                                      
                        //                                       if (payr0520chk) {
                        //                                           
                        //                                           payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                        //                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                        //                                           payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
                        //                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                        //                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                        //                                           payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                        //                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                        //                                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */ 
                        //                                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                        //                                           payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
                        //                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                        //                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                        //                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                        ////                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
                        ////                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
                        ////                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                        ////                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
                        ////                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
                        ////                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                        //                                            
                        //                                       payrCommCalcService.insertPayr0302(payr0302Vo);  
                        //
                        //                                       tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum());  
                        //                                       
                        //                                    }  
                        //                                  }
                                                   
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
                        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
                        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
                        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
                        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
                        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
                        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                                        payrCommCalcService.insertPayr0302(payr0302Vo);
                                                                        
                                                                        if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
                                                                            //과세금액 및 공제등 금액 처리 
                                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
                                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
                                                                            
                                                                        } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
                                                                            //과세금액 및 공제등 금액 처리 
                                                                            tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
                                                                            tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
                                                                            tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
                                                                            
                                                                        } else {
                                                                            tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
                                                                        } 
                                                                        
                                                                    }
                                                            }
                                                            /**===============================================================================================
                                                             * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                             * 과세대상금액, 비과세금액 처리 종료 
                                                             ================================================================================================*/      
                                                          
                                                    	    /*########################################################################################*/
             	                                           /**  4대보험 처리 로직  추가                                                                                                                                                                                              **/
             	                                           /*########################################################################################*/   
             	                                            
             		                                         //과세대상금액  
             			                          	        pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt));
             			                          	        //공제금액합계
             			                          	        pkgInsrWorkVo.setTpDducTotAmnt(tpDducTotAmnt);
             			                          	        //기본금액 
             			                          	        pkgInsrWorkVo.setTpStdPymtTotAmnt(tpStdPymtTotAmnt);
             			                          	     payr0250Vo.setSystemkey(payCalculationVo.getSystemkey());
             			                          	        pkgInsrWorkVo = pkgInsrCtl.func4InsureService(request,payCalculationVo
             			                          	        		       ,payr0250Vo,pkgInsrWorkVo); 

             			                          	        //공제금액 - 4대보험 합계포함 
             				                          	     tpDducTotAmnt = tpDducTotAmnt.add(pkgInsrWorkVo.getTpDducTotAmnt());
             		                                   
             	                                          /*########################################################################################*/
             	                                          /**  4대보험 처리 로직  종료                                                                            	  **/
             	                                          /*########################################################################################*/  
                                                            
                                                            /**===============================================================================================
                                                             * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                             * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
                                                             ================================================================================================*/
                                                            
                                                          //  if ("201504".equals(payr0250Vo.getJobYrMnth()))
                                                          
//                                                            Insr0200VO  insr0200SrhVo = new Insr0200VO();
//                                                           
//                                                            
//                                                            insr0200SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                            insr0200SrhVo.setDducYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */ 
//                                                            insr0200SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                            
//                                                            Insr0200VO  insr0200Vo = new Insr0200VO();
//                                                            
//                                                            insr0200Vo = payrCommCalcService.selectInsr0200Data(insr0200SrhVo); 
//                                                            
//                                                         //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//                                                            
//                                                            	    
//                                                            //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
//                                                                    
////                                                        	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
////                                                        	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
////                                                        	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
////                                                        	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
//                                                            
//                                                            
//                                                                if  (MSFSharedUtils.paramNotNull(insr0200Vo) && MSFSharedUtils.paramNotNull(insr0200Vo.getSystemkey())) {
//                                                                      
//                													
//                													 //공제금액처리 건강보험관련  
//                													if (insr0200Vo.getYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
//                														
////                			                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
//                													    /** column 연말정산보험료 : yrtxPrmm */
//                														 
//                				                                            
//                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_0102);    /** column 급여항목코드 : payItemCd */
//                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
//                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//                        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//                        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//                        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//                        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//                        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//                        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//                                                                        payrCommCalcService.insertPayr0302(payr0302Vo); 
//                	                                                        
//                	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getYrtxPrmm()); //공제합계 
//                	                                                    
//                													}  
//                													
//                													if (insr0200Vo.getLgtmRcptnYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
////                			                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
//                														 /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */ 
//                														
//                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_1102);    /** column 급여항목코드 : payItemCd */
//                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
//                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//                	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//                	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//                	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//                	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//                	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//                	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//                	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
//                	                                                        
//                	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnYrtxPrmm()); //공제합계 
//                													}
//                                                                    
//                                                                    if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//                														//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
////                			                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
//                														  /** column 건강환급금이자 : hlthInsrRefdItrt */
//                													
//                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
//                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//                	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//                	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//                	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//                	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//                	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//                	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//                                                                        payrCommCalcService.insertPayr0302(payr0302Vo);
//                                                                        
//                                                                        
//                                                                        tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
//                                                                    }    
//                                                                    if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////                			                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
//                														  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
//                														 
//                														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                                        payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                        payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
//                                                                        payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                                        payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                                        payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                        payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                        payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//                	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//                	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//                	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//                	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//                	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//                	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//                	                                                    payrCommCalcService.insertPayr0302(payr0302Vo);
//                	                                                        
//                	                                                        
//                	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
//                                                                    }
//                                                                }
//                                                          //  } 
                                                        	
                                                        	 /**===============================================================================================
                                                             * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                             * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
                                                             ================================================================================================*/
                                                        	
                                                     //월급여내역 합계를 구한다. 
                                                       // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
                                                       
             				                          	     pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt)); 
                                                             //과세대상금액 
                                                            pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO); //과세대상금액  
                                                            txTotAmnt =  BigDecimal.ZERO;    //과세합계
                                                             
                                                            pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgInsrWorkVo.getTpTxtnTotAmnt());  
                                                            //소득세 주민세처리 루틴 변경 적용 2017.08.21
                                                            txTotAmnt = payrTaxCtl.getWorkIncmTxtn( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());
                                                            
                                                       
		                                                      payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */  
		                                                      payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
		                                                      payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
		                                                      payr0301Vo.setPayCd(payCalculationVo.getPayCd());         
		                                                      payr0301Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());
		                                                      payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
		                                                      payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
		                                                      payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
		                                                      payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
		                                                      payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
		                                                      payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
		                                                      payr0301Vo.setTxTotAmnt(txTotAmnt);     
		                                                      payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
		                                                      payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
		                                                      payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
		                                                      payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
		                                                      payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
		                                                      payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
		                                                      payr0301Vo.setPayDdlneDt("");    
		                                                      payr0301Vo.setPayDdlneYn("N");   
		                                                      
		                                                      payrCommCalcService.updatePayr0301(payr0301Vo); //월급여내역   
                                      
                                       } else if (ExtermsProps.getProps("PAY_CD_04").equals(payr0250Vo.getPayCd())) {
                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           * @@@@@@@@@@@@@@@@@@@@@@  명절휴가비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           */  
                                           //C9110100  명절휴가비
                                           
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
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           
                                           payrCommCalcService.insertPayr0301(payr0301Vo); //월급여내역  
                                           
                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                            *  급여 항목에 따른 인서트 및 계산 처리 시작 
                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                           Set<InfcPkgPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
                                        
                                           Iterator<InfcPkgPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
                                           
                                           while ( iterpayr0410Set.hasNext() ) { 
                                               
                                                 InfcPkgPayr0410VO payr0410 = iterpayr0410Set.next();
                                            
                                                 if (PayrPkgUtil.funcMonthCheck(payr0250Vo, payr0410,null)) {
                                                     
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
        //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                            
                                                           tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                           if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                        	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                           }  
                                              }  
                                           }
                                            
                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           payrCommCalcService.updatePayr0301(payr0301Vo); //명정휴가비 
                                           
                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
                                           
                                       } else if (ExtermsProps.getProps("PAY_CD_05").equals(payr0250Vo.getPayCd())) {
                                         /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           * @@@@@@@@@@@@@@@@@@@@@@  초과근무수당 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           */  
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
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           
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
                                                    payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                    payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                                                    payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                    payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                     
                                                       if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
                                                           if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
                                                                
                                                       
                                                               if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
                                                                     //시간외근무 
                                                                   
                                                                       BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                                       if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
                                                                     	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                       } 
                                                                       //payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                       BigDecimal totTmSum = BigDecimal.ZERO;
                                                                       
                                                                       totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
                                                                       
                                                                       
                                                                       payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                       payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                       
                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                       
                                                                       if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                       }
                                                                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
                                                                    	   payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                       }
                                                                 }
                                                                 
                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
                                                             // 토요근무수당   --일수산정C9410700
                                                               
                                                               BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                               if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
                                                             	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                               } 
                                                               BigDecimal totTmSum = BigDecimal.ZERO;
                                                               
                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
                                                               
                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
                                                               
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
                                                                
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
                                                             // 휴일수당        -- 일수 C9410200
                                                        	   /**********************************************************/
                                                         	  // 연장근무가 포함되어 있는경우 처리를 위한 루틴 추가 
                                                         	  // 연장근무은 시간으로 처리함.
                                                         	  /**********************************************************/
                                                        	   BigDecimal ucstSum = payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
                                                               if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
                                                             	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                               } 
                                                                
                                                               BigDecimal totTmSum = BigDecimal.ZERO;    //휴일근무처리를 위한 부분  
                                                               BigDecimal totTmlnSum = BigDecimal.ZERO;  //연장근무처리를 위한 추가 부분 
                                                         	  
                                                         	   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0410.getDayMnthAmntDivCd())) 
                                                                        && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                     
                                                         		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0"))).multiply(ucstSum);  //휴일근무
                                                         		   
                                                         		   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                         			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                        // dilnlazHodyTotNtotTm  //연장근무시간 
                                                         			   BigDecimal tmUcstSum = BigDecimal.ZERO;
                                                         			   // 시간근무환산 
                                                         			   tmUcstSum = ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).add(
                                                         					              ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
                                                             		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                         		 
                                                         		   } else {
                                                         			
                                                         			   totTmlnSum = BigDecimal.ZERO;
                                                         			   
                                                         		   } 
                                                         		   
                                                                } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && ((
                                                                        ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0410.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0410.getDayMnthAmntDivCd()))
                                                                        )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    //월정액,월액인경우  
                                                             	   totTmSum = ucstSum;
                                                             	   
                                                                } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0410.getDayMnthAmntDivCd())) 
                                                                        && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                             	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                         			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                        // dilnlazHodyTotNtotTm  //연장근무시간 
                                                         			  
                                                         			   // 시간근무환산 
                                                             		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0"))).multiply(ucstSum);  //휴일근무 
                                                             		    
                                                         		   } else {
                                                         			
                                                         			   totTmSum = BigDecimal.ZERO;
                                                         			   
                                                         		   } 
                                                             	   
                                                             	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                         			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                        // dilnlazHodyTotNtotTm  //연장근무시간 
                                                         			   BigDecimal tmUcstSum = BigDecimal.ZERO;
                                                         			   // 시간근무환산 
                                                         			   tmUcstSum = (ucstSum.add((ucstSum.multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
                                                             		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                         		 
                                                         		   } else {
                                                         			
                                                         			   totTmlnSum = BigDecimal.ZERO;
                                                         			   
                                                         		   } 
                                                              
                                                                } 
                                                         	   
                                                         	  totTmSum = totTmSum.add(totTmlnSum);
                                                              
                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
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
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
                                                           } else {
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }	   
                                                           }
                                                             
                                                        }   
                                                            
                                              }  
                                           }
                                            
                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           payrCommCalcService.updatePayr0301(payr0301Vo);  
                                           
                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/   
                                           
                                           
                                       } else if (ExtermsProps.getProps("PAY_CD_06").equals(payr0250Vo.getPayCd())) {
                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           * @@@@@@@@@@@@@@@@@@@@@@ 연가보상비 C9410600 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           */
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
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           
                                           payrCommCalcService.insertPayr0301(payr0301Vo); //월급여내역  
                                           
                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                            *  급여 항목에 따른 인서트 및 계산 처리 시작 
                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                           Set<InfcPkgPayr0410VO> payr0410Set = payCalculationVo.getExPayr0410();
                                        
                                           Iterator<InfcPkgPayr0410VO> iterpayr0410Set = payr0410Set!=null ? payr0410Set.iterator()  : null;
                                           
                                           while ( iterpayr0410Set.hasNext() ) { 
                                               
                                                 InfcPkgPayr0410VO payr0410 = iterpayr0410Set.next();
                                            
                                                 if (PayrPkgUtil.funcMonthCheck(payr0250Vo, payr0410,null)) {
                                                     
                                                	  payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                      payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                      payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
                                                      payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                      payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                      payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
                                                      payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                      payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */  
                                                      payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                      payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
                                                      payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                      payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                      payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
   //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
   //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
   //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
   //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
   //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
   //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                      
                                                      
                                                      if (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0) {
                                                          
                                                          BigDecimal ucstSum =   payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                           
                                                          BigDecimal totTmSum = BigDecimal.ZERO;
                                                          
                                                          totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys())).multiply(ucstSum)).setScale(-1, BigDecimal.ROUND_DOWN);  //연가보상비 
                                                          
                                                          payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                          payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                          
                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                          
                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                        
                                                        
                                                      } else {
                                                   	   
                                                   	   payr0302Vo.setPymtDducSum(BigDecimal.ZERO);   /** column 지급공제금액 : pymtDducSum */
                                                          payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                          
                                                          tpPymtTotAmnt = tpPymtTotAmnt.add(BigDecimal.ZERO); 
                                                          tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(BigDecimal.ZERO); 
                                                          
                                                          tpExtpyTotAmnt = tpExtpyTotAmnt.add(BigDecimal.ZERO);
                                                   	   
                                                      } 
                                                       
                                                     // tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()));
                                                     // tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()));
                                                    //  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
                                                      if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                   	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                      }	   	   
                                                            
                                              }  
                                           }
                                            
                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           payrCommCalcService.updatePayr0301(payr0301Vo);  
                                           
                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
                                           
                                           
                                       } else if (ExtermsProps.getProps("PAY_CD_07").equals(payr0250Vo.getPayCd())) {
                                        /**  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           * @@@@@@@@@@@@@@@@@@@@@@ 초과근무수당(12월)   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                           * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                           */
                                          
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
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           
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
                                                    payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                    payr0302Vo.setPymtDducSum((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                                                    payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                    payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                    payr0302Vo.setPymtDducTxtnAmnt((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).subtract(payr0410.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                     
                                                       if ((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) {
                                                           if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0410.getPayrImcd())) {
                                                                
                                                       
                                                               if (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
                                                                     //시간외근무 
                                                                   
                                                                       BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                                       BigDecimal totTmSum = BigDecimal.ZERO;
                                                                       
                                                                       totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
                                                                       
                                                                       
                                                                       payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                                       payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                       
                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                                       
                                                                       if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                           tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                                       }
                                                                       if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                    	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                       }
                                                                 }
                                                                 
                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0410.getPayrImcd())) {
                                                             // 토요근무수당   --일수산정C9410700
                                                               
                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                               BigDecimal totTmSum = BigDecimal.ZERO;
                                                               
                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
                                                               
                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
                                                               
                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0410.getPayrImcd())) {
                                                            // 야간수당       -- 시간산정C9410300
                                                               
                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                               BigDecimal totTmSum = BigDecimal.ZERO;
                                                               
                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazTotNtotTm())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //시간외근무
                                                                
                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd())) {
                                                             // 휴일수당        -- 일수 C9410200
                                                        	   /**********************************************************/
                                                         	  // 연장근무가 포함되어 있는경우 처리를 위한 루틴 추가 
                                                         	  // 연장근무은 시간으로 처리함.
                                                         	  /**********************************************************/

                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                               
                                                               BigDecimal totTmSum = BigDecimal.ZERO;    //휴일근무처리를 위한 부분  
                                                               BigDecimal totTmlnSum = BigDecimal.ZERO;  //연장근무처리를 위한 추가 부분 
                                                         	  
                                                         	   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0410.getDayMnthAmntDivCd())) 
                                                                        && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                     
                                                         		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0"))).multiply(ucstSum);  //휴일근무
                                                         		   
                                                         		   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                         			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                        // dilnlazHodyTotNtotTm  //연장근무시간 
                                                         			   BigDecimal tmUcstSum = BigDecimal.ZERO;
                                                         			   // 시간근무환산 
                                                         			   tmUcstSum = ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).add(
                                                         					              ((ucstSum.divide(new BigDecimal("8"), 5, BigDecimal.ROUND_UP)).multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
                                                             		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                         		 
                                                         		   } else {
                                                         			
                                                         			   totTmlnSum = BigDecimal.ZERO;
                                                         			   
                                                         		   } 
                                                         		   
                                                                } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && ((
                                                                        ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0410.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0410.getDayMnthAmntDivCd()))
                                                                        )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    //월정액,월액인경우  
                                                             	   totTmSum = ucstSum;
                                                             	   
                                                                } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0410.getPayrImcd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0410.getDayMnthAmntDivCd())) 
                                                                        && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                             	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                         			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                        // dilnlazHodyTotNtotTm  //연장근무시간 
                                                         			  
                                                         			   // 시간근무환산 
                                                             		   totTmSum = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyTm(),"0"))).multiply(ucstSum);  //휴일근무 
                                                             		    
                                                         		   } else {
                                                         			
                                                         			   totTmSum = BigDecimal.ZERO;
                                                         			   
                                                         		   } 
                                                             	   
                                                             	   if (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0")).compareTo(BigDecimal.ZERO) > 0) {
                                                         			   //dilnlazPubcHodyDutyTm  //휴일근무시간 
                                                                        // dilnlazHodyTotNtotTm  //연장근무시간 
                                                         			   BigDecimal tmUcstSum = BigDecimal.ZERO;
                                                         			   // 시간근무환산 
                                                         			   tmUcstSum = (ucstSum.add((ucstSum.multiply(new BigDecimal("0.5"))))).setScale(0,BigDecimal.ROUND_DOWN);
                                                             		   totTmlnSum = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyTotNtotTm(),"0"))).multiply(tmUcstSum)).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                         		 
                                                         		   } else {
                                                         			
                                                         			   totTmlnSum = BigDecimal.ZERO;
                                                         			   
                                                         		   } 
                                                              
                                                                } 
                                                         	   
                                                         	  totTmSum = totTmSum.add(totTmlnSum);
                                                         	  
                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  { 
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
                                                           } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(payr0410.getPayrImcd())) {
                                                               // 유급휴일수당  -- 일수 산정 C9415000
                                                                   
                                                               BigDecimal ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
                                                               BigDecimal totTmSum = BigDecimal.ZERO;
                                                               
                                                               totTmSum = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum)).setScale(-1,BigDecimal.ROUND_DOWN);  //토요근무수당 
                                                               
                                                               payr0302Vo.setPymtDducSum(totTmSum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPymtDducTxtnAmnt(totTmSum.subtract(payr0410.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add(totTmSum); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add(totTmSum);
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);    
                                                               }
                                                           } else {
                                                               
                                                               tpPymtTotAmnt = tpPymtTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                               tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                               
                                                               if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0410.getPymtDducDivCd())) {
                                                                   tpExtpyTotAmnt = tpExtpyTotAmnt.add((payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
                                                               }
                                                               if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            	   payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                               }	   
                                                           }
                                                             
                                                        }   
                                                            
                                              }  
                                           }
                                            
                                           payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                           payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
                                           payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                                           payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                           payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                                           payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
                                           payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
                                           payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
                                           payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
                                           payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
                                           payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
                                           payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
                                           payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
                                           payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
                                           payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
                                           payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
                                           payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
                                           payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
                                           payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
        //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                           
                                           payrCommCalcService.updatePayr0301(payr0301Vo); //명정휴가비 
                                           
                                           /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                            *  급여 항목에 따른 인서트 및 계산 처리 종료 
                                              @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
                                           
                                           
                                       }   
                                        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]월급여" ,"처리완료","대상자 : " + payCalculationVo.getHanNm() + "명처리완료 "));
                                  } else {//if ((payCalculationVo.getExPayr0410() != null)  && (!payCalculationVo.getExPayr0410().isEmpty()))
                                	  bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","무기계약직","급여항목데이터 존재하지 않음.")); 
                                  }
                            } else {
                                //급여대상여부가 불러왔는데 대상자가 아닌경우 처리  조정데이타가 존재하면 삭제 
                                InfcPkgPayr0307VO  payr0307SrhVo = new InfcPkgPayr0307VO();
                                
                                payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
                                payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                
                                payrCommCalcService.deletePayCalculationPayr0307(payr0307SrhVo); 
                            }
                          } 
                       
                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[무기계약직]월급여" ,"처리완료","대상자 : " + String.valueOf(psnlList.size()) + "명처리완료 "));
                     
                //   } else { }
                  
           //   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
           } catch (Exception ex) {
                ex.printStackTrace();   
        	   ShowMessageBM smBm = new ShowMessageBM();
        	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
        	   smBm.setMenu("Payr");
        	   smBm.setPhase("[급여]에러");
        	   smBm.setMessage(ex.getLocalizedMessage());
        	   smBm.setContent(ex.getMessage());
        	   bmResult.add(smBm);  
        	//   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
        	 
           } 
           
           return bmResult; 
	  	}
	  	
	  
		 
	  	/**
	  	 * 급여처리로직 
	  	 * @param request
	  	 * @param dtoPayr0250
	  	 * @param voPsnl0100
	  	 * @return
	  	 */

	 private List<ShowMessageBM> procEmymtDivCd02(HttpServletRequest request,InfcPkgPayr0250VO dtoPayr0250,InfcPkgPsnl0100VO voPsnl0100,boolean boolInsert)  throws Exception {
	    
	  	//  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
	  	//소득세계산을 위한 메서드 
          payrTaxCtl = PayrTaxController.getInstance();
          
         // 4대 보험 메소드  
          pkgInsrCtl = PkgInsrController.getInstance(); 
          
          payrCommCalcService = (PayrCommCalcService)BeanFinder.getBean("PayrCommCalcService");
	  	  payCalculationService = (PayCalculationService)BeanFinder.getBean("PayCalculationService");

          // int result = 0;
           int iDducCnt = 0;
           
           InfcPkgPayr0520SrhVO payr0520SrhVo = new InfcPkgPayr0520SrhVO();
          
           InfcPkgPayr0520VO  payr0520Vo = null;
           InfcPkgPayr0250VO  payr0250Vo = new InfcPkgPayr0250VO();
           InfcPkgPayr0300VO  payr0300Vo = new InfcPkgPayr0300VO();
           InfcPkgPayr0301VO  payr0301Vo = new InfcPkgPayr0301VO();
           InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
           InfcPkgPayr0304VO  payr0304Vo = new InfcPkgPayr0304VO();
           InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
           InfcPkgPayr0306VO  payr0306Vo = new InfcPkgPayr0306VO(); 
           InfcPkgPayr0410VO  payr0410Vo = new InfcPkgPayr0410VO();
           InfcPkgPayr0530VO  payr0530Vo = new InfcPkgPayr0530VO();
          
           //4대보험처리 TempVO 객체 
           PkgInsrWorkVO   pkgInsrWorkVo = new PkgInsrWorkVO();
           
           //항목별수당
           InfcPkgPayr0450SrhVO payr0450SrhVo = new InfcPkgPayr0450SrhVO();
           InfcPkgPayr0520VO  payr0450Vo = null;
           
           //직책별 수당 
           InfcPkgPayr0460SrhVO payr0460SrhVo = new InfcPkgPayr0460SrhVO();
           InfcPkgPayr0460VO  payr0460Vo = null;
           
           
           InfcPkgPayr0410SrhVO payr0410SrhVo = new InfcPkgPayr0410SrhVO();
           PkgPayrInsrStdSrhVO payrInsrStdSrhVo = new PkgPayrInsrStdSrhVO();
           PkgPayrInsrStdVO payrInsrStdVo = null;
           
           //시간외 근무 및 기본근무집계내역을 가지는 객체
           //Dlgn0100VO dlgn0100Vo = new Dlgn0100VO();   //기본근무
           //Dlgn0200VO dlgn0200Vo = new Dlgn0200VO();   //시간외근무(휴일근무포함)
            
           
           PkgPayrCommCalcVO payCalculationVo = null;
           
           //가족수당 합
           BigDecimal tpFamyExtpySum = BigDecimal.ZERO;
           
           BigDecimal tpFamyFreeExtpySum = BigDecimal.ZERO;
           
           //학비보조금함계
           BigDecimal  tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;
           BigDecimal  tpStdPymtTotAmnt = BigDecimal.ZERO;   //기본
           //pymtTotAmnt 지급총액
           BigDecimal  tpPymtTotAmnt = BigDecimal.ZERO;
           //extpyTotAmnt 수당총액
           BigDecimal  tpExtpyTotAmnt = BigDecimal.ZERO;
           //txtnTotAmnt 과세총액 
         //  BigDecimal  tpTxtnTotAmnt = BigDecimal.ZERO;
           //freeDtyTotAmnt 비과세총액 
           BigDecimal  tpFreeDtyTotAmnt = BigDecimal.ZERO;
           //dducTotAmnt  공제총액 
           BigDecimal  tpDducTotAmnt = BigDecimal.ZERO;
           
            //기본급정보 
            BigDecimal basePymtAmnt =  BigDecimal.ZERO;
        
            pkgInsrWorkVo.setTpTxtnTotAmnt(BigDecimal.ZERO); //txtnTotAmnt 과세총액 
            pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);          //건강보험
            pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);     //요양 
            pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);              //국민연금
            pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);        //고용
            pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);               //보수금액
            pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO);        //과세대상금액
                                               
            //과세합계
            BigDecimal txTotAmnt =  BigDecimal.ZERO;
            
           //월 출력체크 
           String chkMonth = "N";
           boolInsert = true;  //payr0300 급여마스터 인서트 여부 
           
       //    DlgnProcessContainer dlgnProcessContainer = new DlgnProcessContainer();
           Map<String, Object> mapPayr = new HashMap<String, Object>();
              
            if (MSFSharedUtils.paramNull(dtoPayr0250.getJobYrMnth()) 
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getPayrMangDeptCd()) 
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getPymtDt()) 
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getRflctnBgnnDt())
            		|| MSFSharedUtils.paramNull(dtoPayr0250.getRflctnEndDt())) {
            	
            	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","스케줄정보","급여스케줄정보 이상!!! 확인요망." )); 
                 
            }
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
     
            
         try {
             
                   // 근태관리정리작업 진행 인터페이스 호출 
                   // 근태관리테이블에 데이터 존재여부 확인 없으면 메시지출력 함. 
                   // 근무시간 가져오기 - 시간외 근무인경우는 두가지 경우로 처리함.
                   // dlgnProcessContainer.setSelectManageDlgn0100CommuteService(payr0250Vo);
                   // dlgnProcessContainer.setSelectManageDlgn0200CommuteService(payr0250Vo);
              
                   //사회보험요율가져오기 
//                 //  List insureList =   pkgInsrCtl.getSelect4InsureDataList(payr0250Vo);  
//                   
//                   if (insureList.size() > 0) {
//                	 //  BaseModel bm = new BaseModel();
//                	   ShowMessageBM smBm = new ShowMessageBM();
//                	   smBm.setDivision(PropPayGenConfs.PAYGEN_INFO);
//                	   smBm.setMenu("Payr");
//                	   smBm.setPhase("[급여]4대보험요율");
//                	   smBm.setMessage("불러오기성공");
//                	   smBm.setContent("");
//                	   bmResult.add(smBm); 
//                   }  
                   
                   
              //     if (ExtermsProps.getProps("EMYMT_DIVCD_02")EMYMT_DIVCD_01.equals(payr0250Vo.getEmymtDivCd())) { } else {
                     
                  /*****************************************************************************************************
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    * 기간제근로자 급여 계산 처리 
                    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~      
                    ****************************************************************************************************/ 
                       ArrayList strDducPayr0520= new ArrayList();
                       //기간제인경우 무기계약직 해당 없음. 
                       payr0250Vo.setTypOccuCd(""); 
                       payr0250Vo.setPyspGrdeCd("");
                       payr0250Vo.setPayrMangDeptYn("");
                       
                       if  (MSFSharedUtils.paramNull(payr0250Vo.getBusinCd()) ) {
                    	   bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]기간제근로자스케줄확인" ,"기간제근로자 사업명 선택에러","기간제근로자의경우 받드시 사업명을 선택하셔야합니다. <br> "
                    	   		+ "급여스케줄관리에서 사업명을 선택하신후 급여계산을 다시 하십시요.")); 
                    	   throw new Exception();  
                       } 
                               //인사정보 추출 //근태기록도 같이 가져옴.
                               //검색조건 지급년월 기준으로 정보를 가져온다. 
                               //근태관리의 근무일수 산정등...데이타 가져오기 결과값.
                       
                     //권한적용 루틴 추가 
                       /** 조건절 */
                      // payr0250Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
                       payr0250Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
                       payr0250Vo.setUsrId(sessionUser.getUsrId());  
                        
                        
                       /******************************** 권한 ************************************************************************/
                        
                       payr0250Vo.setDeptCdAuth(payr0250Vo.getDeptCd());  //권한처리를위해 추가  
                       payr0250Vo.setDtilOccuInttnCdAuth(payr0250Vo.getDtilOccuInttnCd());   
              
                       //String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
                                if (payr0250Vo.getPayrMangDeptCd().equals(payr0250Vo.getDeptCd())) {  
                                	payr0250Vo.setDeptCd("");  //부서코드
                                } else {
                                	payr0250Vo.setDeptCd(payr0250Vo.getDeptCd());
                                    
                                } 
                        
                       /******************************** 권한 ************************************************************************/
                       
                                
                       List<PkgPayrCommCalcVO>  psnlList = payCalculationService.selectPsnlA20PayrInfoList(payr0250Vo); 
                               
                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[급여]" + String.valueOf(psnlList.size()) + "명처리중","기간제근로자",""));  
                       if (psnlList.size() > 0) { 
                                   //직종 // 근속년수 에따른 급여 항목 정보 추출 및 단가표에서 값을 가지고 온다. 
                                   //검색조건 - 지급년월, 사용여부 년월에 지급여 
                                   payr0410SrhVo.setDpobCd(payr0250Vo.getDpobCd());  //사업장코드 
                                   payr0410SrhVo.setPayYr(payr0250Vo.getJobYrMnth().substring(0, 4)); //급여항목년도 
                                   
                                   //payCalculationService.selectPayrItemUnitInfoList(searchVO);
                                    
                                   //기간제근로자 
                                   payr0300Vo.setDpobCd(payr0250Vo.getDpobCd()); //사업장코드 
                                   payr0300Vo.setPayCd(payr0250Vo.getPayCd());  //급여구분코드 
                                   payr0300Vo.setPayrMangDeptCd(payr0250Vo.getPayrMangDeptCd()) ;//단위기관코드 
                                   payr0300Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()); 
                                   payr0300Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum()); //일련번호 
                                   payr0300Vo.setPayPymtDt(payr0250Vo.getPymtDt());   //지급일자
                                      
                                   
                                   InfcPkgPayr0300VO  tpPayr0300Vo = new InfcPkgPayr0300VO();
                                   
                                   tpPayr0300Vo = payCalculationService.selectPayr0300(payr0300Vo); 
                                    
                                   if (MSFSharedUtils.paramNull(tpPayr0300Vo) 
                                   		|| MSFSharedUtils.paramNull(tpPayr0300Vo.getPayPymtDt()))  {
                                	   //급여마스터 테이블에 데이터을 인서트한다.  
                                       payrCommCalcService.insertPayr0300(payr0300Vo);
                                  }
                                  
                               
                      
                               for (int icnt = 0; icnt < psnlList.size();icnt++) { 
                            
                                   payCalculationVo = new PkgPayrCommCalcVO();
                                   payCalculationVo = (PkgPayrCommCalcVO)psnlList.get(icnt);
                                   
                                   if ("Y".equals(payCalculationVo.getPayRcptYn())) {     
                                         
                                        /*************************************************************** 
                                                                                                급여 계산을 위한 초기화 
                                        ****************************************************************/
        
                                                
                                            tpFamyExtpySum = BigDecimal.ZERO;  //가족수당 합 
                                            tpFamyFreeExtpySum =  BigDecimal.ZERO;            //가족수당 비과세합계  
                                            tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;//학비보조금함계 
                                            tpStdPymtTotAmnt= BigDecimal.ZERO;   //기본
                                            tpPymtTotAmnt = BigDecimal.ZERO; //pymtTotAmnt 지급총액 
                                            tpExtpyTotAmnt = BigDecimal.ZERO;  //extpyTotAmnt 수당총액 
                                          //  tpTxtnTotAmnt = BigDecimal.ZERO;//txtnTotAmnt 과세총액  
                                            tpFreeDtyTotAmnt = BigDecimal.ZERO; //freeDtyTotAmnt 비과세총액  
                                            tpDducTotAmnt = BigDecimal.ZERO; //dducTotAmnt  공제총액 
                                            
                                            pkgInsrWorkVo.setTpTxtnTotAmnt(BigDecimal.ZERO); //txtnTotAmnt 과세총액 
                                            pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);          //건강보험
                                           pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);     //요양 
                                           pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);              //국민연금
                                           pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);        //고용
                                           pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);               //보수금액
                                           pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO);        //과세대상금액 
                                             
                                             chkMonth = "N";//월 출력체크 
                                         
                                          
                                          
                                        if ((payCalculationVo.getExPayr0490() != null)  && (!payCalculationVo.getExPayr0490().isEmpty())) { 
                                             
                                               /**
                                                * @@@@@@@@@@@@@@@@@@@@@@ 월급여 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                */
                                               // 월급여내역개인 인서트  
                                            	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]" + payCalculationVo.getHanNm() + " 처리중","기간제근로자",""));  
                                                payr0304Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
                                                payr0304Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
                                                payr0304Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
                                                payr0304Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                                                payr0304Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
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
                                                    payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /**TODO  column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySumpayCalculationVo.getSuprtFamy3ChdnExtpySum() */
                                                    
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
                                                
                                                InfcPkgPayr0304VO tpPayr0304Vo = new InfcPkgPayr0304VO();
                                                tpPayr0304Vo = payrCommCalcService.selectPayr0304(payr0304Vo); 
                                                
                                                if (MSFSharedUtils.paramNull(tpPayr0304Vo)) { 
                                                   
                                                    payrCommCalcService.insertPayr0304(payr0304Vo);
                                                    
                                                } else {
                                                    
                                                    payrCommCalcService.updatePayr0304(payr0304Vo);
                                                }
                                                 
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
                                                
                                            if (ExtermsProps.getProps("PAY_CD_01").equals(payr0250Vo.getPayCd())) {         
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
        //                                      payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                      payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                      payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                      payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                      payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                      payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                
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
                                                           
                                                           if ((MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) ) {
                                                               payr0306Vo.setSchlExpnAdmclExtpySum(payr0530.getSchlExpnAdmclExtpySum());     /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
                                                        
                                                           } else {
                                                           
                                                               payr0306Vo.setSchlExpnAdmclExtpySum(BigDecimal.ZERO);
                                                               
                                                           }
                                                           
                                                           if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
                                                                   (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
                                                            
	                                                        	  
	                                                               // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
	                                                               if  ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
	                                                            	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
	                                                            	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
	                                                            		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
	                                                            	   }
	                                                               }
                                                                   //가족수당 합
                                                                   tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
                                                                   //학비보조금함계
                                                                   tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum());
                                                                  
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
                                                      // tpFamyExtpySum = tpFamyExtpySum.add(payCalculationVo.getSuprtFamy3ChdnExtpySum());
                                                     
                                                  }  
                                                /*########################################################################################*/
                                                /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
                                                /*########################################################################################*/  
                                          
                                              
                                              /*########################################################################################*/
                                              /**  공제관련 항목  시작                                                                                                                                                                         **/
                                              /*########################################################################################*/    
                                              payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
                                              payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
                                              payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 .getPymtDt()
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
                                                //공제테이블 
                                                List listPymtPayr0520 = payrCommCalcService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
                                                  
                                                /*########################################################################################*/
                                                /**  공제관련 항목  가져오기                                                                                                                                                                       **/
                                                /*########################################################################################*/  
                                                
                                               /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                                *  급여 항목에 따른 인서트 및 계산 처리 시작 
                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                                 
                                               //지급공제항목에 따른 급여항목에 따른 인서트 처리 
                                               Set<InfcPkgPayr0490VO> payr0490Set = payCalculationVo.getExPayr0490();
                                            
                                               Iterator<InfcPkgPayr0490VO> iterpayr0490Set = payr0490Set!=null ? payr0490Set.iterator()  : null;
                                               
                                               while ( iterpayr0490Set!=null && iterpayr0490Set.hasNext() ) {
                                                   
                                                     InfcPkgPayr0490VO payr0490 = iterpayr0490Set.next();
                                                
                                                     if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
                                                        
                                                    	//공제 
                                                       if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0490.getPymtDducDivCd())) {
                                                           
                                                           iDducCnt = 0;
//                                                           for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//                                                               
//                                                                payr0520Vo  = new InfcPkgPayr0520VO();
//                                                                    
//                                                                BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
//                                                                
//                                                     
//                                                            if (payr0520Vo.getPayItemCd().equals(payr0490.getPayItemCd())) {
//                                                              
//                                                                    if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).compareTo(BigDecimal.ZERO) != 0) { 
//                                                                     
//                                                                        payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//                                                                        payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                        payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//                                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//                                                                        payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//                                                                        payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                        payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                        payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum())
//                                                                                                       .subtract(payr0490.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//        //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//        //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//        //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//        //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//        //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//        //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//                                                                        if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  { 
//                                                                        	payrCommCalcService.insertPayr0302(payr0302Vo);  
//                                                                        	
//                                                                        	tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).setScale(-1,BigDecimal.ROUND_DOWN));
//                                                                              
//                                                                        }
//                                                                       
//                                                                    } 
//                                                                    strDducPayr0520.add(payr0490.getPayItemCd());  
//                                                                }   
//                                                           }
                                                            
                                                           
                                                       } else {
                                                          
                                                           //가족수당
                                                           if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0490.getPayItemCd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                            
                                                               //가족수당  C9050100    
                                                        	   payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                               payr0302Vo.setPymtDducSum(tpFamyExtpySum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                               payr0302Vo.setPymtDducTxtnAmnt(tpFamyExtpySum.subtract(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum)));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
                                                                   
                                                                
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpFamyExtpySum);
                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));
                                                                
                                                                if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                		  payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                	  } 	  
                                                                 } 
                                                               
                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0490.getPayItemCd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                               //학비보조수당 C9060100
                                                               
                                                               //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                               payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                               payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                             
                                                               if (ExtermsProps.getProps("PAY_CALC_TX_B005_02").equals(payr0490.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_01").equals(payr0490.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                               } else  if (ExtermsProps.getProps("PAY_CALC_TX_B005_03").equals(payr0490.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                               } else {
                                                            	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                               }
                                                          
                                                               
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
                                                                 
//                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                                
                                                                if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                	  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                		  payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                	  }	  
                                                                 }
                                                                
                                                           } else {
                                                               /** 각수당별로 처리하는 로직을구현한다. */ 
                                                                
                                                               BigDecimal tpEmymtAmnt = BigDecimal.ZERO;  //기간제 본봉 /수당 임시변수 
                                                                
                                                               // 본봉   --시간.일할정액이냐에 따라 다름
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //총 근무일수  * 본봉
                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum()))).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                                   
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd())
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                            	   
                                                            	   //기본급  - 병가관련데이터 처리 하는 부분 추가 
                                                                   BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급 
                                                                   
                                                                   BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
                                                                   
                                                                   
                                                                   if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))) > 0)) {
                                                                       
                                                                       mothPayAmt = payr0490.getPymtDducSum(); 
                                                                    
                                                                       dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
                                                                     		  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
                                                                       
                                                                   }  else  if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))) == 0)) {
                                                                     
                                                                       dayPaySum = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                       
                                                                   } else {
                                                                 	   bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","근무일수보다 근무총일수가 클수 없습니다.")); 
                                                                       dayPaySum = BigDecimal.ZERO;
                                                                   }  
                                                                   
                                                            	   //월정액,월액인경우  
                                                                   tpEmymtAmnt = dayPaySum;
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                            	   
                                                            	   //월정액,월액인경우  
                                                                   //tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                   //tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd())
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                            	   
                                                            	   //기본급  - 병가관련데이터 처리 하는 부분 추가 
                                                                   BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급 
                                                                   
                                                                   BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
                                                                   
                                                                   BigDecimal dilnlazTotDutyDys = BigDecimal.ZERO;  //휴일포함일수 계산 
                                                                   
                                                                   dilnlazTotDutyDys = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))
                                                      		              .add((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyDutyNumDys(),"0"))))
                                                      		               .add((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazAbnceDutyRcgtnDys(),"0"))));
                                                                   
                                                                   if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo(dilnlazTotDutyDys) > 0)) {
                                                                       
                                                                       mothPayAmt = payr0490.getPymtDducSum(); 
                                                                    
                                                                       dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
                                                                     		  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
                                                                       
                                                                   }  else  if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo(dilnlazTotDutyDys) == 0)) {
                                                                     
                                                                       dayPaySum = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                       
                                                                   } else {
                                                                 	   bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","근무일수보다 근무총일수가 클수 없습니다.")); 
                                                                       dayPaySum = BigDecimal.ZERO;
                                                                   }  
                                                                   
                                                            	   //월정액,월액인경우  
                                                                   tpEmymtAmnt = dayPaySum;
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                            	   
                                                            	   //월정액,월액인경우  
                                                                   //tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                   //tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //총 근무일수  * 본봉 -시급처리 추가 
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               }  
                                                             //  BigDecimal tpEmymtC9410700Amnt = BigDecimal.ZERO;
                                                               // 토요근무수당   --일수산정
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else    if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                           && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                        
                                                                       tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                 
                                                               }  
                                                               
                                                              // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
                                                               // 주휴수당       --일수산정
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazWklyHldyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazWklyHldyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazWklyHldyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               }   
                                                               
                                                               
                                                               // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
                                                               // 교통보조비        --일수산정 
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_06").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //교통보조비  * 금액
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_06").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_06").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //교통보조비  * 본봉 -시급처리 추가 
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } 
                                                               
                                                               // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
                                                               // 교통비 신설      --일수산정 
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_45").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //교통보조비  * 금액
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_45").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_45").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //교통보조비  * 본봉 -시급처리 추가 
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTfcAssCstNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } 
                                                               //급식비 추가 
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //총 근무일수  * 본봉
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //총 근무일수  * 본봉 -시급처리 추가 
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLnchDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } 
                                                              
	                                                               // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
	                                                               // 정액급식비        --일수산정 
	                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
	                                                                   //총 근무일수  * 정액급식비 
	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd()) && ((
	                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
	                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
	                                                                   //월정액,월액인경우  
	                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
	                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
	                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
	                                                                   //총 근무일수   정액급식비  -시급처리 추가 
	                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
	                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
	                                                               } 
                                                               
                                                               //BigDecimal tpEmymtC9410400Amnt = BigDecimal.ZERO;
                                                               // 월차수당        -- 일수 (퇴직시) TODO 수정 
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (BigDecimal.ONE.multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               }
        
                                                               // BigDecimal tpEmymtC9410200Amnt = BigDecimal.ZERO;
	                                                            // 휴일수당        -- 일수  ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_21 = "C9410200";  
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                               
                                                            	   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPubcHodyDutyNumDys(),"0")).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //TODO  휴일수당 시간으로 계산 하는 부분 하고 휴일연장시장 추가 로직 구성  
                                                                  // tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN);
                                                            	   
                                                            	   tpEmymtAmnt =  ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyTm())).add((new BigDecimal(payCalculationVo.getDilnlazHodyTotNtotTm())))
                                                  	                        .multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN);
                                                            	   
                                                              }
	                                         
                                                               //BigDecimal tpEmymtC9415000Amnt = BigDecimal.ZERO;
                                                               // 유급휴일수당  -- 일수 산정 ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23 = "C9415000";  
//                                                               if (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23.equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_01.equals(payr0490.getDayMnthAmntDivCd())) 
//                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//                                                                      //일당 
//                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//                                                                
//                                                                  } else if (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23.equals(payr0490.getPayItemCd()) && ((
//                                                                          ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_02.equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_03.equals(payr0490.getDayMnthAmntDivCd()))
//                                                                          )  && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//                                                                      //월정액,월액인경우  
//                                                                      tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//                                                                  } else  if (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23.equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_04.equals(payr0490.getDayMnthAmntDivCd())) 
//                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//                                                                      //시급 
//                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//                                                                
//                                                                  } 
                                                                 
                                                              // BigDecimal tpEmymtC9410100Amnt = BigDecimal.ZERO; 
                                                               // 시간외수당     --시간으로산정
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } 
                                                               
                                                              // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
                                                               // 야간수당       -- 시간산정ExtermsProps.getProps("EMYMT_DIVCD_02") = "C9410300";
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } 
                                                               
                                                            // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
                                                               // 연가일수       -- 시간산정PAY_EMYMT_PYMT_24 = "C9410600";    // 연가보상비
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1, BigDecimal.ROUND_DOWN);
                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                             
                                                               }  
                                                               //명절휴가비 추가 
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_17").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd()))) {
                                                                    
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_17").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_17").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd()))) {
                                                                    
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } 
                                                               
                                                                 
                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                              
                                                               payr0302Vo.setPymtDducSum(tpEmymtAmnt);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                               
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(payr0490.getPayItemCd())) {
                                                            	   //정액급식비 
                                                            	   if (tpEmymtAmnt.compareTo(payr0490.getFreeDtySum()) >= 0) {  
                                                            		   
                                                                       payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                       payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                    
                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                                       
                                                                   } else {
                                                                 	  
                                                                 	   payr0302Vo.setPymtDducFreeDtySum(tpEmymtAmnt);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                       payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                    
                                                                       tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
                                                                       tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpEmymtAmnt);
                                                                   }
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_38").equals(payr0490.getPayItemCd())) {
                                                            	   //급식비 
                                                                	   if (tpEmymtAmnt.compareTo(payr0490.getFreeDtySum()) >= 0) {  
                                                                		   
                                                                           payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()) );    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                           payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                        
                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
                                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                                           
                                                                       } else {
                                                                     	  
                                                                     	   payr0302Vo.setPymtDducFreeDtySum(tpEmymtAmnt);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                        
                                                                           tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
                                                                           tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpEmymtAmnt);
                                                                       }
                                                               } else {
                                                            	   
                                                            	   payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                            	   payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                              
                                                            	   tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                               
                                                               } 
                                                               
                                                               
                                                               
        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                 
                                                                
                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0490.getPymtDducDivCd())) {
                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpEmymtAmnt);
                                                                }
                                                                 if (tpEmymtAmnt.compareTo(BigDecimal.ZERO) > 0) {
                                                            	 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            		 payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                            	 }	 
                                                                }
                                                           }
                                                            
                                                       }  //----------------------
                                                       
                                                    }  
                                                     
                                               }  
                                               
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
	      //                                          payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
	      //                                          payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
	      //                                          payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
	      //                                          payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
	      //                                          payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
	      //                                          payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
	                                                  if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
	                                                  	payrCommCalcService.insertPayr0302(payr0302Vo);  
	                                                  	   
	                                                        //과세금액 및 공제등 금액 처리 
	                                                        tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0302Vo.getPymtDducSum()); // 급여합계
	                                                        tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0302Vo.getPymtDducSum()); // 수당합계  
	                                                        tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0302Vo.getPymtDducFreeDtySum());//비과세금액 
	                                                             
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
                                                           
                                                           payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                           payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
                                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                           payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                           payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
                                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                           
                                                      
                                                           if (payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) != 0 ) {
                                                        	   
                                                        	   if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) != 0)  {
                                                        		   payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                        	   }
                                                               tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum());
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
             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                             payrCommCalcService.insertPayr0302(payr0302Vo);
                                                             
                                                             if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
                                                                 //과세금액 및 공제등 금액 처리 
                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
                                                                 
                                                             } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
                                                                 //과세금액 및 공제등 금액 처리 
                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
                                                                 tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
                                                                 
                                                             } else {
                                                                 tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
                                                             } 
                                                             
                                                         }
                                                 }
                                                 /**===============================================================================================
                                                  * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                  * 과세대상금액, 비과세금액 처리 종료 
                                                  ================================================================================================*/
                                                 /*########################################################################################*/
  	                                           /**  4대보험 처리 로직  추가                                                                                                                                                                                              **/
  	                                           /*########################################################################################*/   
  	                                            
  		                                         //과세대상금액  
  			                          	        pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt));
  			                          	        //공제금액합계
  			                          	        pkgInsrWorkVo.setTpDducTotAmnt(tpDducTotAmnt);
  			                          	        //기본금액 
  			                          	        pkgInsrWorkVo.setTpStdPymtTotAmnt(tpStdPymtTotAmnt);
  			                          	    payr0250Vo.setSystemkey(payCalculationVo.getSystemkey());
  			                          	        pkgInsrWorkVo = pkgInsrCtl.func4InsureService(request,payCalculationVo
  			                          	        		       ,payr0250Vo,pkgInsrWorkVo); 

  			                          	        //공제금액 - 4대보험 합계포함 
  				                          	    tpDducTotAmnt = tpDducTotAmnt.add(pkgInsrWorkVo.getTpDducTotAmnt());
  		                                   
  	                                          /*########################################################################################*/
  	                                          /**  4대보험 처리 로직  종료                                                                            	  **/
  	                                          /*########################################################################################*/  
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
                                                         
//                                             	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
//                                             	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
//                                             	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
//                                             	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
                                                 
                                                 
                                                     if  (MSFSharedUtils.paramNotNull(infcInsr3100VO) && MSFSharedUtils.paramNotNull(infcInsr3100VO.getSystemkey())) { 
     													
     													 //공제금액처리 건강보험관련  
     													if (infcInsr3100VO.getMbrAlttHlth().compareTo(BigDecimal.ZERO) != 0) {
     														
//     			                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
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
             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                             payrCommCalcService.insertPayr0302(payr0302Vo); 
     	                                                        
     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttHlth()); //공제합계 
     	                                                    
     													}  
     													
     													if (infcInsr3100VO.getMbrAlttLgtmRcptn().compareTo(BigDecimal.ZERO) != 0) {
//     			                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
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
     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
     	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
     	                                                        
     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(infcInsr3100VO.getMbrAlttLgtmRcptn()); //공제합계 
     													}
                                                         
//                                                         if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//     														//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
////     			                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
//     														  /** column 건강환급금이자 : hlthInsrRefdItrt */
//     													
//     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
//                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//                                                             payrCommCalcService.insertPayr0302(payr0302Vo);  
//                                                             tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
//                                                         }    
//                                                         if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////     			                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
//     														  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
//     														 
//     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
//                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//     	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
//     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
//                                                         }
                                                     }
                                               //  } 
                                             	
                                             	 /**===============================================================================================
                                                  * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                  * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
                                                  ================================================================================================*/
                                             	
                                                 // 급여내역 합계를 구한다. 
                                              // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
                                               
                                                     pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt)); 
                                                     //과세대상금액 
                                                    pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO); //과세대상금액  
                                                    txTotAmnt =  BigDecimal.ZERO;    //과세합계
                                                     
                                                    pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgInsrWorkVo.getTpTxtnTotAmnt());  
                                                
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
                                                          payr0302Vo.setPymtDducSum(txTotAmnt);
                                                          payr0302Vo.setPayPymtDducPrcsFlag("N");
                                                          payr0302Vo.setPayReattyAdmntVal("0");
                                                          payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                                                        payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                                                        payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                                                        payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                                                        payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                                                        payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                                                        payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
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
//                                                        payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                                                        payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                                                        payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                                                        payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                                                        payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                                                        payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                          payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                                                          
                                                          payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                          
                                                          
                                                   	   payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                          payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
                                                          payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
                                                          payr0301Vo.setPayCd(payCalculationVo.getPayCd());          
                                                          payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
                                                          payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
                                                          payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
                                                          payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
                                                          payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
                                                          payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
                                                          payr0301Vo.setTxTotAmnt(txTotAmnt);     
                                                          payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
                                                          payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
                                                          payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
                                                          payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
                                                          payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
                                                          payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
                                                          payr0301Vo.setPayDdlneDt("");    
                                                          payr0301Vo.setPayDdlneYn("N");   
                   //                                     payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
                   //                                     payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
                   //                                     payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
                   //                                     payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
                   //                                     payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
                   //                                     payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                          
                                                          payrCommCalcService.updatePayr0301(payr0301Vo); //월급여내역  
                                                      } else {
                                                    	  //소득세 주민세처리 루틴 변경 적용 2017.08.21
                                                          txTotAmnt = payrTaxCtl.getWorkIncmTxtn( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());
                                                          
                                               
			                                               payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			                                               payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
			                                               payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
			                                               payr0301Vo.setPayCd(payCalculationVo.getPayCd());          
			                                               payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
			                                               payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
			                                               payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
			                                               payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
			                                               payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
			                                               payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
			                                               payr0301Vo.setTxTotAmnt(txTotAmnt);     
			                                               payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
			                                               payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
			                                               payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
			                                               payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
			                                               payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
			                                               payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
			                                               payr0301Vo.setPayDdlneDt("");    
			                                               payr0301Vo.setPayDdlneYn("N");   
			        //                                     payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
			        //                                     payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
			        //                                     payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
			        //                                     payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
			        //                                     payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
			        //                                     payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
			                                               
			                                               payrCommCalcService.updatePayr0301(payr0301Vo); //월급여내역  
                                               
                                                      } 
                                            } else if (ExtermsProps.getProps("PAY_CD_02").equals(payr0250Vo.getPayCd())) {
                                              /**
                                                * @@@@@@@@@@@@@@@@@@@@@@ 복리후생비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                */  
                                                
                                            } else if (ExtermsProps.getProps("PAY_CD_03").equals(payr0250Vo.getPayCd())) {
                                             /**
                                                * @@@@@@@@@@@@@@@@@@@@@@ 월급여 2회차 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                */ 
                                                
                                                // 월급여내역개인 인서트  
                                                
//                                                payr0304Vo.setDpobCd(payr0250Vo.getDpobCd());                          /** column 사업장코드 : dpobCd */
//                                                payr0304Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                   /** column 지급년월 : pymtYrMnth */
//                                                payr0304Vo.setSystemkey(payCalculationVo.getSystemkey());              /** column SYSTEMKEY : systemkey */
//                                                payr0304Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                payr0304Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                payr0304Vo.setPayrMangDeptCd(payCalculationVo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
                                            	
//                                            	 payr0304Vo.setMangeDeptCd(payCalculationVo.getMangeDeptCd());    /** column 인사관리부서코드  mangeDeptCd */
                                            	 
//                                                payr0304Vo.setEmymtDivCd(payCalculationVo.getEmymtDivCd());            /** column 고용구분코드 : emymtDivCd */
//                                                payr0304Vo.setHanNm(payCalculationVo.getHanNm());                      /** column 한글성명 : hanNm */
//                                                payr0304Vo.setResnRegnNum(payCalculationVo.getResnRegnNum());          /** column 주민등록번호 : resnRegnNum */
//                                                payr0304Vo.setDeptCd(payCalculationVo.getCurrAffnDeptCd());                    /** column 부서코드 : deptCd */
//                                                payr0304Vo.setBusinCd(payCalculationVo.getBusinCd());    /** column 사업코드 : businCd */
//                                                payr0304Vo.setTypOccuCd(payCalculationVo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//                                                payr0304Vo.setDtilOccuInttnCd(payCalculationVo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//                                                payr0304Vo.setOdtyCd(payCalculationVo.getOdtyCd());    /** column 직책코드 : odtyCd */
//                                                payr0304Vo.setPyspCd(payCalculationVo.getPyspCd());    /** column 호봉코드 : pyspCd */
//                                                payr0304Vo.setPyspGrdeCd(payCalculationVo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//                                                payr0304Vo.setLogSvcYrNumCd(payCalculationVo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//                                                payr0304Vo.setLogSvcMnthIcmCd(payCalculationVo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//                                                payr0304Vo.setFrstEmymtDt(payCalculationVo.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
//                                                payr0304Vo.setEmymtBgnnDt(payCalculationVo.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
//                                                payr0304Vo.setEmymtEndDt(payCalculationVo.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
//                                                payr0304Vo.setHdofcDivCd(payCalculationVo.getHdofcCodtnCd());    /** column 재직구분코드 : hdofcDivCd */
//                                                payr0304Vo.setRetryDt(payCalculationVo.getRetryDt());    /** column 퇴직일자 : retryDt */
//                                                payr0304Vo.setLogSvcStdDt(payCalculationVo.getLogSvcStdDt());    /** column 근속기준일자 : logSvcStdDt */
//                                                payr0304Vo.setSpueYn(payCalculationVo.getSpueYn());    /** column 배우자유무 : spueYn */
//                                                payr0304Vo.setSuprtFamyNumTwenChDn(payCalculationVo.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
//                                                if (("Y".equals(payCalculationVo.getSuprtFamyNumTreOvrChdnYn())) 
//                                                         && (payCalculationVo.getSuprtFamyNumTwenChDn().compareTo( new BigDecimal("2")) > 0)) {
//                                                    payr0304Vo.setSuprtFamyNumTreOvrChdn(payCalculationVo.getSuprtFamyNumTwenChDn().subtract( new BigDecimal("2")) );    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
//                                                    payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /**TODO  column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySumpayCalculationVo.getSuprtFamy3ChdnExtpySum() */
//                                                    
//                                                } else  {
//                                                    payr0304Vo.setSuprtFamyNumTreOvrChdn(BigDecimal.ZERO);    /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */ 
//                                                    payr0304Vo.setSuprtFamy3ChdnExtpySum(BigDecimal.ZERO);    /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//                                                    
//                                                }
//                                                payr0304Vo.setSuprtFamyNumEtc(payCalculationVo.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
//                                                payr0304Vo.setChdnSchlExpnAdmclYn(payCalculationVo.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
//                                                payr0304Vo.setHlthInsrGrde(payCalculationVo.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
//                                                payr0304Vo.setNatPennGrde(payCalculationVo.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
//                                                payr0304Vo.setMnthPayDlywagSum(BigDecimal.ZERO);    /** column 월급여일당금액 : mnthPayDlywagSum */
//                                                
//                                                
//                                                payr0304Vo.setAddIncmTxApptnRtoCd(payCalculationVo.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
//                                                payr0304Vo.setAddIncmTxApptnYrMnth(payCalculationVo.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
//                                              
                                            	// payr0304Vo.setRepbtyBusinDivCd(payCalculationVo.getRepbtyBusinDivCd()); /* 호봉제구분코드 */
//                                                
//                                                Payr0304VO tpPayr0304Vo = new Payr0304VO();
//                                                tpPayr0304Vo = payrCommCalcService.selectPayr0304(payr0304Vo); 
//                                                
//                                                if (MSFSharedUtils.paramNull(tpPayr0304Vo)) { 
//                                                   
//                                                    payrCommCalcService.insertPayr0304(payr0304Vo);
//                                                    
//                                                } else {
//                                                    
//                                                    payrCommCalcService.updatePayr0304(payr0304Vo);
//                                                } 
                                                
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
        //                                      payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                      payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                      payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                      payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
        //                                      payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                      payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                
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
                                                           
                                                           if ((MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) ) {
                                                               payr0306Vo.setSchlExpnAdmclExtpySum(payr0530.getSchlExpnAdmclExtpySum());     /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
                                                        
                                                           } else {
                                                           
                                                               payr0306Vo.setSchlExpnAdmclExtpySum(BigDecimal.ZERO);
                                                               
                                                           }
                                                           
                                                           if (("Y".equals(payr0530.getFamyAllwPymtYn())) || (
                                                                   (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtBgnnDt())) >= 0)
                                                                   && (MSFSharedUtils.allowNulls(payr0250Vo.getRflctnEndDt()).compareTo(MSFSharedUtils.allowNulls(payr0530.getSchlExpnExtpyPymtEndDt())) <= 0)
                                                                   && (BigDecimal.ZERO.compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530.getSchlExpnAdmclExtpySum(),"0"))) < 0) )) {
                                                              
	                                                               // 자녀보육공제가 있는 경우 비과세 처리 루틴 추가 
	                                                               if  ("Y".equals(payr0530.getChdnChdRrgEpnsDducYn())) {
	                                                            	   tpFamyFreeExtpySum = tpFamyFreeExtpySum.add(payr0306Vo.getFamyExtpySum());
	                                                            	   if (tpFamyFreeExtpySum.compareTo(new BigDecimal("100000")) > 0) {
	                                                            		   tpFamyFreeExtpySum = new BigDecimal("100000"); 
	                                                            	   }
	                                                               }
                                                                   //가족수당 합
                                                                   tpFamyExtpySum =  tpFamyExtpySum.add(payr0306Vo.getFamyExtpySum());
                                                                   //학비보조금함계
                                                                   tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum.add(payr0306Vo.getSchlExpnAdmclExtpySum());
                                                                  
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
                                                      // tpFamyExtpySum = tpFamyExtpySum.add(payCalculationVo.getSuprtFamy3ChdnExtpySum());
                                                     
                                                  }  
                                                /*########################################################################################*/
                                                /**  가족수당/학비보조수당 종료                                                                                                                                                             **/
                                                /*########################################################################################*/  
                                          
                                              
                                              /*########################################################################################*/
                                              /**  공제관련 항목  시작                                                                                                                                                                         **/
                                              /*########################################################################################*/    
//                                              payr0520SrhVo.setDpobCd(payr0250Vo.getDpobCd());
//                                              payr0520SrhVo.setSystemkey(payCalculationVo.getSystemkey());
//                                              payr0520SrhVo.setPymtDt(payr0250Vo.getJobYrMnth());  //지급구간 .getPymtDt()
//                                              payr0520SrhVo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);
//                                              //공제테이블 
//                                              List listDducPayr0520 = payrCommCalcService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
                                                
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
                                                //공제테이블 
                                                List listPymtPayr0520 = payrCommCalcService.selectPayr0520ToPayrCalcList(payr0520SrhVo);
                                                  
                                                /*########################################################################################*/
                                                /**  공제관련 항목  가져오기                                                                                                                                                                       **/
                                                /*########################################################################################*/  
                                                
                                               /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                                *  급여 항목에 따른 인서트 및 계산 처리 시작 
                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                                 
                                               //지급공제항목에 따른 급여항목에 따른 인서트 처리 
                                               Set<InfcPkgPayr0490VO> payr0490Set = payCalculationVo.getExPayr0490();
                                            
                                               Iterator<InfcPkgPayr0490VO> iterpayr0490Set = payr0490Set!=null ? payr0490Set.iterator()  : null;
                                               
                                               while ( iterpayr0490Set!=null && iterpayr0490Set.hasNext() ) {
                                                   
                                                     InfcPkgPayr0490VO payr0490 = iterpayr0490Set.next();
                                                
                                                     if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
                                                        
                                                       if(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03").equals(payr0490.getPymtDducDivCd())) {
                                                           
//                                                           iDducCnt = 0;
//                                                           for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//                                                               
//                                                                payr0520Vo  = new Payr0520VO();
//                                                                    
//                                                                BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
//                                                                
//                                                     
//                                                            if (payr0520Vo.getPayItemCd().equals(payr0490.getPayItemCd())) {
//                                                              
//                                                                    if ((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()).compareTo(BigDecimal.ZERO) > 0) { 
//                                                                     
//                                                                        payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                                        payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//                                                                        payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
//                                                                        payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                                        payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                                        payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//                                                                        payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//                                                                        payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
//                                                                        payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                                        payr0302Vo.setPymtDducSum((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()));   /** column 지급공제금액 : pymtDducSum */
//                                                                        payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                                        payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                                        payr0302Vo.setPymtDducTxtnAmnt((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum())
//                                                                                                       .subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//        //                                                                payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//        //                                                                payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//        //                                                                payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//        //                                                                payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//        //                                                                payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//        //                                                                payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
//                                                                         
//                                                                        payrCommCalcService.insertPayr0302(payr0302Vo);  
//                                                                        
//                                                                        tpDducTotAmnt = tpDducTotAmnt.add((payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ? payr0520Vo.getPymtDducSum() : payr0490.getPymtDducSum()));
//                                                                       
//                                                                    } 
//                                                                    strDducPayr0520.add(payr0490.getPayItemCd());  
//                                                                }   
//                                                           }
                                                            
                                                           
                                                       } else {
                                                          
                                                           
                                                           if (ExtermsProps.getProps("PYMT_ITEM_01").equals(payr0490.getPayItemCd()) && (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                             
                                                               //가족수당  C9050100 TODO 비과세처리 
                                                        	   payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                               payr0302Vo.setPymtDducSum(tpFamyExtpySum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                               payr0302Vo.setPymtDducTxtnAmnt(tpFamyExtpySum.subtract(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum)));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */  
                                                                   
                                                                
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpFamyExtpySum);
                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpFamyExtpySum);
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum().add(tpFamyFreeExtpySum));
                                                                
                                                                if (tpFamyExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                	if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                		payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                	}	
                                                                 } 
                                                               
                                                           } else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0490.getPayItemCd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
                                                               //학비보조수당 C9060100
                                                               
                                                               //학비보조수당 C9060100  재학생인경우 2월 학생신입인경우은 3월에 지급함...예외사항임. 
                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                               payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                               payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                               
                                                               if ("B0050002".equals(payr0490.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                               } else  if ("B0050001".equals(payr0490.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                               } else  if ("B0050003".equals(payr0490.getTxtnDivCd())) {
                                                                   payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                               } else {
                                                            	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                   payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                                                                   tpFreeDtyTotAmnt = BigDecimal.ZERO;
                                                               }
                                                          
                                                               
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
                                                                 
//                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//                                                                tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                                
                                                                if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
                                                                	if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                                		payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                                	}	
                                                                 }
                                                                
                                                           } else {
                                                               /** 각수당별로 처리하는 로직을구현한다. */ 
                                                                
                                                               BigDecimal tpEmymtAmnt = BigDecimal.ZERO;  //기간제 본봉 /수당 임시변수 
                                                                
                                                               // 본봉   --시간.일할정액이냐에 따라 다름
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //총 근무일수  * 본봉
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd())
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                            	 //기본급  - 병가관련데이터 처리 하는 부분 추가 
                                                                   BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급 
                                                                   
                                                                   BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
                                                                   
                                                                   
                                                                   if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))) > 0)) {
                                                                       
                                                                       mothPayAmt = payr0490.getPymtDducSum(); 
                                                                    
                                                                       dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
                                                                     		  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
                                                                       
                                                                   }  else  if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))) == 0)) {
                                                                     
                                                                       dayPaySum = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                       
                                                                   } else {
                                                                 	   bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","근무일수보다 근무총일수가 클수 없습니다.")); 
                                                                       dayPaySum = BigDecimal.ZERO;
                                                                   }  
                                                                   
                                                            	   //월정액,월액인경우  
                                                                   tpEmymtAmnt = dayPaySum;
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                            	   //월정액,월액인경우  
                                                                   //tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                   //tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                          
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd())
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                            	   
                                                            	 //기본급  - 병가관련데이터 처리 하는 부분 추가 
                                                                   BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급 
                                                                   
                                                                   BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
                                                                   
                                                                   BigDecimal dilnlazTotDutyDys = BigDecimal.ZERO;  //휴일포함일수 계산 
                                                                   
                                                                   dilnlazTotDutyDys = (new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazTotDutyNumDys(),"0")))
                                                     		              .add((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazHodyDutyNumDys(),"0"))))
                                                     		              .add((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazAbnceDutyRcgtnDys(),"0"))));
                                                                   
                                                                   if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo(dilnlazTotDutyDys) > 0)) {
                                                                       
                                                                       mothPayAmt = payr0490.getPymtDducSum(); 
                                                                    
                                                                       dayPaySum = (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
                                                                     		  .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys())))).setScale(-1, 1);
                                                                       
                                                                   }  else  if ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazDutyNumDys(),"0")).compareTo(dilnlazTotDutyDys) == 0)) {
                                                                     
                                                                       dayPaySum = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                       
                                                                   } else {
                                                                 	   bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","근무일수보다 근무총일수가 클수 없습니다.")); 
                                                                       dayPaySum = BigDecimal.ZERO;
                                                                   }  
                                                                   
                                                            	   //월정액,월액인경우  
                                                                   tpEmymtAmnt = dayPaySum;
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                            	   //월정액,월액인경우  
                                                                   //tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                                   //tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                          
                                                                   
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //총 근무일수  * 본봉 -시급처리 추가 
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                   tpStdPymtTotAmnt = tpStdPymtTotAmnt.add(tpEmymtAmnt);
                                                               }  
                                                             //  BigDecimal tpEmymtC9410700Amnt = BigDecimal.ZERO;
                                                               // 토요근무수당   --일수산정
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else    if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                           && (new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                        
                                                                       tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazSatDutyNumDys()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                                 
                                                               }  
                                                               
                                                              // BigDecimal tpEmymtC9410500Amnt = BigDecimal.ZERO;
                                                               // 주휴수당       --일수산정
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_08").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazWklyHldyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               }                     
                                                               
                                                               //BigDecimal tpEmymtC9410400Amnt = BigDecimal.ZERO;
                                                               // 월차수당        -- 일수 (퇴직시) TODO 수정 
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = ((new BigDecimal(MSFSharedUtils.defaultNulls(payCalculationVo.getDilnlazPaidPubcHodyNum(),"0"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_20").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (BigDecimal.ONE.multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               }
        
        
                                                              // BigDecimal tpEmymtC9410200Amnt = BigDecimal.ZERO;
                                                            // 휴일수당        -- 일수  ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_21 = "C9410200";  
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   
                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazPubcHodyDutyNumDys()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               }
        //                                                     
                                                               
                                                               //BigDecimal tpEmymtC9415000Amnt = BigDecimal.ZERO;
                                                               // 유급휴일수당  -- 일수 산정 ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23 = "C9415000";  
//                                                               if (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23.equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_01.equals(payr0490.getDayMnthAmntDivCd())) 
//                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//                                                                      
//                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//                                                                
//                                                                  } else if (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23.equals(payr0490.getPayItemCd()) && ((
//                                                                          ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_02.equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_03.equals(payr0490.getDayMnthAmntDivCd()))
//                                                                          )  && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//                                                                      //월정액,월액인경우  
//                                                                      tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
//                                                                  } else  if (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_PYMT_23.equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_EMYMT_DYMNTH_04.equals(payr0490.getDayMnthAmntDivCd())) 
//                                                                          && (new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0)) {
//                                                                      
//                                                                   tpEmymtAmnt = ((new BigDecimal(payCalculationVo.getDilnlazPaidPubcHodyNum()).multiply(new BigDecimal("8"))).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
//                                                                
//                                                                  } 
                                                                 
                                                              // BigDecimal tpEmymtC9410100Amnt = BigDecimal.ZERO; 
                                                               // 시간외수당     --시간으로산정
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotTmRstDutyTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } 
                                                               
                                                              // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
                                                               // 야간수당       -- 시간산정ExtermsProps.getProps("EMYMT_DIVCD_02") = "C9410300";
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN);
                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazTotNtotTm()).multiply(payr0490.getPymtDducSum())).setScale(-1,BigDecimal.ROUND_DOWN); 
                                                             
                                                               } 
                                                               
                                                            // BigDecimal tpEmymtC9410300Amnt = BigDecimal.ZERO; 
                                                               // 연가일수       -- 시간산정PAY_EMYMT_PYMT_24 = "C9410600";    // 연가보상비
                                                               if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_04").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                             
                                                               } else if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && ((
                                                                       ExtermsProps.getProps("PAY_EMYMT_DYMNTH_02").equals(payr0490.getDayMnthAmntDivCd()) ||  ExtermsProps.getProps("PAY_EMYMT_DYMNTH_03").equals(payr0490.getDayMnthAmntDivCd()))
                                                                       )  && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                   //월정액,월액인경우  
                                                                   tpEmymtAmnt = payr0490.getPymtDducSum().setScale(-1, BigDecimal.ROUND_DOWN);
                                                               } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_24").equals(payr0490.getPayItemCd()) && (ExtermsProps.getProps("PAY_EMYMT_DYMNTH_01").equals(payr0490.getDayMnthAmntDivCd())) 
                                                                       && (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).compareTo(BigDecimal.ZERO) > 0)) {
                                                                    
                                                                   tpEmymtAmnt = (new BigDecimal(payCalculationVo.getDilnlazLvsgNumDys()).multiply(payr0490.getPymtDducSum())).setScale(-1, BigDecimal.ROUND_DOWN); 
                                                             
                                                               } 
                                                                 
                                                               payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                               payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                               payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
                                                               payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                               payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                               payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                               payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                               payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                               payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                               payr0302Vo.setPymtDducSum(tpEmymtAmnt);   /** column 지급공제금액 : pymtDducSum */
                                                               payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                               payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                               payr0302Vo.setPymtDducTxtnAmnt(tpEmymtAmnt.subtract(payr0490.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
        //                                                       payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
        //                                                       payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
        //                                                       payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
        //                                                       payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
        //                                                       payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
        //                                                       payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                
                                                                
                                                                tpPymtTotAmnt = tpPymtTotAmnt.add(tpEmymtAmnt); 
                                                                tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum());
                                                                
                                                                if (!ExtermsProps.getProps("PYMT_DDUC_DIV_CD_01").equals(payr0490.getPymtDducDivCd())) {
                                                                    tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpEmymtAmnt);
                                                                }
                                                             if (tpEmymtAmnt.compareTo(BigDecimal.ZERO) > 0) {
                                                            	 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                            		 payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                            	 }	 
                                                             }
                                                           }
                                                            
                                                       }  
                                                       
                                                    }  
                                                     
                                               }   
                                               
                                                 //항목에 없는 데이터 인서트 (공제)
//                                                   for (int iCnt = 0; iCnt < listDducPayr0520.size();iCnt++) {
//                                                       
//                                                       boolean payr0520chk = true; 
//                                                       payr0520Vo  = new Payr0520VO();
//                                                      // payr0200Vo = (Payr0200VO) listPayr0200.get(iCnt);
//                                                       BeanUtils.copyProperties(payr0520Vo, listDducPayr0520.get(iCnt));
//                                                       
//                                                       
//                                                       for (int iduCnt = 0; iduCnt < strDducPayr0520.size(); iduCnt++) {
//                                                           
//                                                           if (strDducPayr0520.get(iduCnt).equals(payr0520Vo.getPayItemCd())) {
//                                                               payr0520chk = false ;
//                                                           } 
//                                                       }
//                                                       
//                                                      
//                                                       if (payr0520chk) {
//                                                           
//                                                           payr0302Vo.setDpobCd(payr0520Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//                                                           payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                           payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                           payr0302Vo.setPayItemCd(payr0520Vo.getPayItemCd());   /** column 급여항목코드 : payItemCd */
//                                                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//                                                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */ 
//                                                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                           payr0302Vo.setPymtDducSum(payr0520Vo.getPymtDducSum());   /** column 지급공제금액 : pymtDducSum */
//                                                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//        //                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//        //                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//        //                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//        //                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//        //                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//        //                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//                                                           
//                                                      
//                                                           if (payr0520Vo.getPymtDducSum().compareTo(BigDecimal.ZERO) > 0 ) {
//                                                               payrCommCalcService.insertPayr0302(payr0302Vo);  
//                                                             
//                                                               tpDducTotAmnt = tpDducTotAmnt.add(payr0520Vo.getPymtDducSum());
//                                                           }
//                                                        
//                                                     }  
//                                                   } 
        
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
             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                                                             payrCommCalcService.insertPayr0302(payr0302Vo);
                                                             
                                                             if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {  
                                                                 //과세금액 및 공제등 금액 처리 
                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
                                                                 
                                                             } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) { 
                                                                 //과세금액 및 공제등 금액 처리 
                                                                 tpPymtTotAmnt   =  tpPymtTotAmnt.add(payr0307Vo.getPymtDducSum()); // 급여합계
                                                                 tpExtpyTotAmnt  =  tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum()); // 수당합계  
                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducFreeDtySum());//비과세금액 
                                                                 
                                                             } else {
                                                                 tpDducTotAmnt   =  tpDducTotAmnt.add(payr0307Vo.getPymtDducSum()); //공제합계 
                                                             } 
                                                             
                                                         }
                                                 }
                                                 /**===============================================================================================
                                                  * payr0307에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                  * 과세대상금액, 비과세금액 처리 종료 
                                                  ================================================================================================*/
                                                
                                                 /*########################################################################################*/
  	                                             /**  4대보험 처리 로직  추가                                                                                                                                                                                              **/
  	                                             /*########################################################################################*/   
  	                                            
  		                                         //과세대상금액  
  			                          	        pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt));
  			                          	        //공제금액합계
  			                          	        pkgInsrWorkVo.setTpDducTotAmnt(tpDducTotAmnt);
  			                          	        //기본금액 
  			                          	        pkgInsrWorkVo.setTpStdPymtTotAmnt(tpStdPymtTotAmnt);
  			                          	    payr0250Vo.setSystemkey(payCalculationVo.getSystemkey());
  			                          	        pkgInsrWorkVo = pkgInsrCtl.func4InsureService(request,payCalculationVo
  			                          	        		       ,payr0250Vo,pkgInsrWorkVo); 

  			                          	       	//공제금액 - 4대보험 합계포함 
  				                          	    tpDducTotAmnt = tpDducTotAmnt.add(pkgInsrWorkVo.getTpDducTotAmnt());
  		                                   
  	                                          /*########################################################################################*/
  	                                          /**  4대보험 처리 로직  종료                                                                            	  **/
  	                                          /*########################################################################################*/  
                                                 
                                                 /**===============================================================================================
                                                  * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                  * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
                                                  ================================================================================================*/
                                                 
                                               //  if ("201504".equals(payr0250Vo.getJobYrMnth()))
                                               
//                                                 Insr0200VO  insr0200SrhVo = new Insr0200VO();
//                                                
//                                                 
//                                                 insr0200SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                 insr0200SrhVo.setDducYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */ 
//                                                 insr0200SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                 
//                                                 Insr0200VO  insr0200Vo = new Insr0200VO();
//                                                 
//                                                 insr0200Vo = payrCommCalcService.selectInsr0200Data(insr0200SrhVo); 
//                                                 
//                                              //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
//                                                 
//                                                 	    
//                                                 //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
//                                                         
////                                             	public static final String PAY_DDUC_CD_0104 = "D0010400"; //공제 건강보험휴직자분할보험
////                                             	public static final String PAY_DDUC_CD_0103 = "D0010300"; //공제 건강보험과미납 
////                                             	public static final String PAY_DDUC_CD_1104 = "D0110400"; //공제 휴직자분할장기요양보험
////                                             	public static final String PAY_DDUC_CD_1103 = "D0110300"; //공제 노인장기요양보험과미납 
//                                                 
//                                                 
//                                                     if  (MSFSharedUtils.paramNotNull(insr0200Vo) && MSFSharedUtils.paramNotNull(insr0200Vo.getSystemkey())) {
//                                                           
//     													
//     													 //공제금액처리 건강보험관련  
//     													if (insr0200Vo.getYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
//     														
////     			                                        	public static final String PAY_DDUC_CD_0102 = "D0010200"; //공제 건강보험연말정산 
//     													    /** column 연말정산보험료 : yrtxPrmm */
//     														 
//     				                                            
//     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_0102);    /** column 급여항목코드 : payItemCd */
//                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
//                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//             //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//             //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//             //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//             //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//             //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//             //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//                                                             payrCommCalcService.insertPayr0302(payr0302Vo); 
//     	                                                        
//     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getYrtxPrmm()); //공제합계 
//     	                                                    
//     													}  
//     													
//     													if (insr0200Vo.getLgtmRcptnYrtxPrmm().compareTo(BigDecimal.ZERO) != 0) {
////     			                                        	public static final String PAY_DDUC_CD_1102 = "D0110200"; //공제 노인장기요양보험연말정산 
//     														 /** column 요양연말정산보험료 : lgtmRcptnYrtxPrmm */ 
//     														
//     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_1102);    /** column 급여항목코드 : payItemCd */
//                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnYrtxPrmm());    /** column 지급공제금액 : pymtDducSum */
//                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//     	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
//     	                                                        
//     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnYrtxPrmm()); //공제합계 
//     													}
//                                                         
//                                                         if (insr0200Vo.getHlthInsrRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
//     														//payr0302Vo.setHlthRcptnYrtxPrmm(insr0200Vo.getHlthRcptnYrtxPrmm());    /** column 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
////     			                                        	public static final String PAY_DDUC_CD_0105 = "D0010500"; //공제 건강보험환급금이자 														
//     														  /** column 건강환급금이자 : hlthInsrRefdItrt */
//     													
//     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_0105);    /** column 급여항목코드 : payItemCd */
//                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getHlthInsrRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//                                                             payrCommCalcService.insertPayr0302(payr0302Vo);
//                                                             
//                                                             
//                                                             tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getHlthInsrRefdItrt()); //공제합계 
//                                                         }    
//                                                         if (insr0200Vo.getLgtmRcptnRefdItrt().compareTo(BigDecimal.ZERO) != 0) {
////     			                                        	public static final String PAY_DDUC_CD_1105 = "D0110500"; //공제 노인장기요양보험환급금이자 
//     														  /** column 요양환급금이자 : lgtmRcptnRefdItrt */
//     														 
//     														payr0302Vo.setDpobCd(insr0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                                                             payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
//                                                             payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//                                                             payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//                                                             payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                                             payr0302Vo.setPayItemCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PAY_DDUC_CD_1105);    /** column 급여항목코드 : payItemCd */
//                                                             payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
//                                                             payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("EMYMT_DIVCD_02")PYMT_DDUC_DIV_CD_03);    /** column 지급공제구분코드 : pymtDducDivCd */
//                                                             payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                                             payr0302Vo.setPymtDducSum(insr0200Vo.getLgtmRcptnRefdItrt());    /** column 지급공제금액 : pymtDducSum */
//                                                             payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//                                                             payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//                                                             payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//     	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//     	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//     	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//     	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//     	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//     	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
//     	                                                    payrCommCalcService.insertPayr0302(payr0302Vo);
//     	                                                        
//     	                                                        
//     	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(insr0200Vo.getLgtmRcptnRefdItrt()); //공제합계 
//                                                         }
//                                                     }
//                                               //  } 
                                             	
                                             	 /**===============================================================================================
                                                  * INSR0200에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                  * 건강보험 연말정산에 따른 처리 루틴으로 4월에만 처리하는 부분임.  
                                                  ================================================================================================*/
                                             	
  				                              /**===============================================================================================
                                                 * YETA2000/YETA3000에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                 *  연말정산에 따른 처리 루틴으로 3월 및 분납자 대상자 환수금/환급급 처리를 한다.
                                                 *  환급금의 경우 3월에 지급대상으로 선택이 되어 있는경우 공제에 인서트 
                                                 *  환수금정보도 동일하게 구성된다   
                                                 *  2017년귀속분에 대해 위치 변경됨  ye169010/ye169010a ye161020 구분자에 따라 불러오는 값 틀림 
                                                 ================================================================================================*/
                                                 //분할여부 체크 및 나누기해서 잔액정함.....
                                                  //D0220100 - 환급소득세
                                                  //D0230100 - 환급주민세
                                                  //D0240100 - 농특세
                                                
                                             if ("201801".compareTo(payr0250Vo.getJobYrMnth()) > 0 ) {
                                              
                                                InfcPkgYeta2000SrhVO  infcYeta2000SrhVO = new InfcPkgYeta2000SrhVO(); 
                                                
                                                infcYeta2000SrhVO.setDpobCd(payr0250Vo.getDpobCd());                /** column 사업장코드 : dpobCd */
                                                infcYeta2000SrhVO.setEdacRvyy(payr0250Vo.getJobYrMnth().substring(0, 4)) ;          /** column 지급년월 : pymtYrMnth */ 
                                                infcYeta2000SrhVO.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                infcYeta2000SrhVO.setSettGbcd("Y0020010");   //정산구분코드 
                                                
                                                
                                                InfcPkgYeta2000VO  infcYeta2000VO = new InfcPkgYeta2000VO();
                                                InfcPkgYeta2000VO  updateYeta2000VO = new InfcPkgYeta2000VO();
                                                
                                                infcYeta2000VO = payCalculationService.seletYeta2000Data(infcYeta2000SrhVO); 
                                                
                                             //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
                                                
                                                	    
                                              //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
                                                         
//                                            //	public static final String PAY_DDUC_D02201 = "D0220100";   // 	D0220100	B0080030	B0250260	환급소득세
                                              //	public static final String PAY_DDUC_D02301 = "D0230100";   // 	D0230100	B0080030	B0250270	환급주민세
                                              //	public static final String PAY_DDUC_D08701 = "D0870100";   // 	D0870100	B0080030	B0250310	연말정산원천징수
                                              //	public static final String PAY_DDUC_D08702 = "D0870200";   // 	D0870200	B0080030	B0250310	연말정산재정산
                                                
                                                
                                                    if  (MSFSharedUtils.paramNotNull(infcYeta2000VO) && MSFSharedUtils.paramNotNull(infcYeta2000VO.getSystemkey())) { 
                                                    	
                                                    	if(!MSFSharedUtils.allowNulls(infcYeta2000VO.getYrtxPrcsDt()).equals(payr0250Vo.getPymtDt())) {     /** column 연말정산처리일자 : yrtxPrcsDt */
                                                    	
	    													if (!("Y".equals(infcYeta2000VO.getYrtxPrcsYn()))) {
	    														 
		                                                    	if (infcYeta2000VO.getDivdPymtDivSu().compareTo(infcYeta2000VO.getDivdPymt()) > 0) {
		                                                    		
		                                                    		BigDecimal subtEtax = BigDecimal.ZERO;   //소득세 
		                                                    		BigDecimal subtInhb = BigDecimal.ZERO;   //주민세 
		                                                    		BigDecimal divdPymtAmnt = BigDecimal.ZERO;   //합계  
		                                                    		
		                                                    		updateYeta2000VO.setDivdPymt(String.valueOf(new BigDecimal(infcYeta2000VO.getDivdPymt()).add(BigDecimal.ONE)));    /** column 분할납부횟수 : divdPymt */
																	 
		                                                    		if (updateYeta2000VO.getDivdPymt().compareTo(infcYeta2000VO.getDivdPymtDivSu()) == 0) {
		                                                    			// 같으면 잔액으로 처리 할
		                                                    			subtEtax = infcYeta2000VO.getSubtEtax().subtract(infcYeta2000VO.getSubtEtax01().multiply(new BigDecimal(infcYeta2000VO.getDivdPymt())));
		                                                    			subtInhb = infcYeta2000VO.getSubtInhb().subtract(infcYeta2000VO.getSubtInhb01().multiply(new BigDecimal(infcYeta2000VO.getDivdPymt())));
		                                                    			  
		    															updateYeta2000VO.setYrtxPrcsYn("Y");    /** column 연말정산처리여부 : yrtxPrcsYn */ 
		    															
		                                                    		} else {
		                                                    			//다르면 값을 다르게 처리 할것. 
		                                                    			subtEtax =  infcYeta2000VO.getSubtEtax01();
		                                                    			subtInhb =  infcYeta2000VO.getSubtInhb01(); 
		                                                    			 
		    															updateYeta2000VO.setYrtxPrcsYn(infcYeta2000VO.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
		                                                    		}
		                                                    		
		                                                    		divdPymtAmnt = infcYeta2000VO.getDivdPymtAmnt();
		                                                    		divdPymtAmnt = divdPymtAmnt.add(subtEtax.add(subtInhb));
		                                                    		
			    													 //연말정산 환급금처리 
			    													if (subtEtax.compareTo(BigDecimal.ZERO) != 0) {
			    														
			//    			                                        	 //	public static final String PAY_DDUC_D02201 = "D0220100";   // 	D0220100	B0080030	B0250260	환급소득세
			    				                                            
			    														payr0302Vo.setDpobCd(infcYeta2000VO.getDpobCd());    /** column 사업장코드 : dpobCd */
			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02201"));    /** column 급여항목코드 : payItemCd */
			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                                                            payr0302Vo.setPymtDducSum(subtEtax);    /** column 지급공제금액 : pymtDducSum */
			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			            //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
			            //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
			            //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
			            //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
			            //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
			            //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			                                                            payrCommCalcService.insertPayr0302(payr0302Vo); 
			    	                                                        
			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtEtax); //공제합계 
			    	                                                    
			    													}  
			    													
			    													if (subtInhb.compareTo(BigDecimal.ZERO) != 0) {
			    														
			//    			                                        	//	public static final String PAY_DDUC_D02301 = "D0230100";   // 	D0230100	B0080030	B0250270	환급주민세
			    														
			    														payr0302Vo.setDpobCd(infcYeta2000VO.getDpobCd());    /** column 사업장코드 : dpobCd */
			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02301"));    /** column 급여항목코드 : payItemCd */
			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                                                            payr0302Vo.setPymtDducSum(subtInhb);    /** column 지급공제금액 : pymtDducSum */
			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			    	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
			    	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
			    	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
			    	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
			    	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
			    	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			    	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
			    	                                                        
			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtInhb); //공제합계 
			    													}
			                                                        
			                                                        /*************************************************/
			    													//연말정산 처리 업데이트 부분 
			    													/*************************************************/ 
			
																	updateYeta2000VO.setDpobCd(infcYeta2000VO.getDpobCd());    /** column 사업장코드 : dpobCd */
																	updateYeta2000VO.setEdacRvyy(infcYeta2000VO.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
																	updateYeta2000VO.setSettGbcd(infcYeta2000VO.getSettGbcd());    /** column 정산구분코드 : settGbcd */
																	updateYeta2000VO.setSystemkey(infcYeta2000VO.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
																//	updateYeta2000VO.setYrtxApptnYrMnth(infcYeta2000VO.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */ 
																//	updateYeta2000VO.setDivdPymtDivCd(infcYeta2000VO.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
																	
																	//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
	    															//updateYeta2000VO.setYrtxPrcsDt(sdf.format(new Date()));    /** column 연말정산처리일자 : yrtxPrcsDt */
																	updateYeta2000VO.setYrtxPrcsDt(payr0250Vo.getPymtDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
	    															
																	updateYeta2000VO.setDivdPymtAmnt(divdPymtAmnt);    /** column 분납납부금액 : divdPymtAmnt */
																	
																	updateYeta2000VO.setKybdr(infcYeta2000VO.getKybdr());    /** column 입력자 : kybdr */
																	updateYeta2000VO.setInptDt(infcYeta2000VO.getInptDt());    /** column 입력일자 : inptDt */
																	updateYeta2000VO.setInptAddr(infcYeta2000VO.getInptAddr());    /** column 입력주소 : inptAddr */
																	updateYeta2000VO.setIsmt(infcYeta2000VO.getIsmt());    /** column 수정자 : ismt */ 
			
			    													payCalculationService.updateYeta2000(updateYeta2000VO);
			    													
		                                                    	}
	    													} else {
	    														// 아직 완료 되지 않은 경우 
	    													}	
                                                    	} else {
                                                    		//급여 반영이 된경우 처리 
                                                    		//if (!("Y".equals(infcYeta2000VO.getYrtxPrcsYn()))) {
	    														 
		                                                    //	if (infcYeta2000VO.getDivdPymtDivSu().compareTo(infcYeta2000VO.getDivdPymt()) > 0) {
		                                                    		
		                                                    		BigDecimal subtEtax = BigDecimal.ZERO;   //소득세 
		                                                    		BigDecimal subtInhb = BigDecimal.ZERO;   //주민세 
		                                                    		BigDecimal divdPymtAmnt = BigDecimal.ZERO;   //합계  
		                                                    		
		                                                    		updateYeta2000VO.setDivdPymt(infcYeta2000VO.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
																	 
		                                                    		if (updateYeta2000VO.getDivdPymt().compareTo(infcYeta2000VO.getDivdPymtDivSu()) == 0) {
		                                                    			// 같으면 잔액으로 처리 할
		                                                    			subtEtax = infcYeta2000VO.getSubtEtax().subtract(infcYeta2000VO.getSubtEtax01().multiply((new BigDecimal(infcYeta2000VO.getDivdPymt())).subtract(BigDecimal.ONE)));
		                                                    			subtInhb = infcYeta2000VO.getSubtInhb().subtract(infcYeta2000VO.getSubtInhb01().multiply((new BigDecimal(infcYeta2000VO.getDivdPymt())).subtract(BigDecimal.ONE)));
		                                                    			  
		    															updateYeta2000VO.setYrtxPrcsYn("Y");    /** column 연말정산처리여부 : yrtxPrcsYn */ 
		    															
		                                                    		} else {
		                                                    			//다르면 값을 다르게 처리 할것. 
		                                                    			subtEtax =  infcYeta2000VO.getSubtEtax01();
		                                                    			subtInhb =  infcYeta2000VO.getSubtInhb01(); 
		                                                    			 
		    															updateYeta2000VO.setYrtxPrcsYn(infcYeta2000VO.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
		                                                    		}
		                                                    		
		                                                    		divdPymtAmnt = infcYeta2000VO.getDivdPymtAmnt(); 
		                                                    		//divdPymtAmnt = subtEtax.add(subtInhb);
		                                                    		
			    													 //연말정산 환급금처리 
			    													if (subtEtax.compareTo(BigDecimal.ZERO) != 0) {
			    														
			//    			                                        	 //	public static final String PAY_DDUC_D02201 = "D0220100";   // 	D0220100	B0080030	B0250260	환급소득세
			    				                                            
			    														payr0302Vo.setDpobCd(infcYeta2000VO.getDpobCd());    /** column 사업장코드 : dpobCd */
			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02201"));    /** column 급여항목코드 : payItemCd */
			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                                                            payr0302Vo.setPymtDducSum(subtEtax);    /** column 지급공제금액 : pymtDducSum */
			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			            //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
			            //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
			            //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
			            //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
			            //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
			            //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			                                                            payrCommCalcService.insertPayr0302(payr0302Vo); 
			    	                                                        
			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtEtax); //공제합계 
			    	                                                    
			    													}  
			    													
			    													if (subtInhb.compareTo(BigDecimal.ZERO) != 0) {
			    														
			//    			                                        	//	 public static final String PAY_DDUC_D02301 = "D0230100";   // 	D0230100	B0080030	B0250270	환급주민세
			    														
			    														payr0302Vo.setDpobCd(infcYeta2000VO.getDpobCd());    /** column 사업장코드 : dpobCd */
			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02301"));    /** column 급여항목코드 : payItemCd */
			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                                                            payr0302Vo.setPymtDducSum(subtInhb);    /** column 지급공제금액 : pymtDducSum */
			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
			    	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
			    	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
			    	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
			    	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
			    	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
			    	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			    	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
			    	                                                        
			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtInhb); //공제합계 
			    													}
			                                                        
			                                                        /*************************************************/
			    													//연말정산 처리 업데이트 부분 
			    													/*************************************************/ 
			
																	updateYeta2000VO.setDpobCd(infcYeta2000VO.getDpobCd());    /** column 사업장코드 : dpobCd */
																	updateYeta2000VO.setEdacRvyy(infcYeta2000VO.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
																	updateYeta2000VO.setSettGbcd(infcYeta2000VO.getSettGbcd());    /** column 정산구분코드 : settGbcd */
																	updateYeta2000VO.setSystemkey(infcYeta2000VO.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
																//	updateYeta2000VO.setYrtxApptnYrMnth(infcYeta2000VO.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */ 
																//	updateYeta2000VO.setDivdPymtDivCd(infcYeta2000VO.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
																	
																	//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
	    															//updateYeta2000VO.setYrtxPrcsDt(sdf.format(new Date()));    /** column 연말정산처리일자 : yrtxPrcsDt */
																	updateYeta2000VO.setYrtxPrcsDt(payr0250Vo.getPymtDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
	    															
																	updateYeta2000VO.setDivdPymtAmnt(divdPymtAmnt);    /** column 분납납부금액 : divdPymtAmnt */
																	
																	updateYeta2000VO.setKybdr(infcYeta2000VO.getKybdr());    /** column 입력자 : kybdr */
																	updateYeta2000VO.setInptDt(infcYeta2000VO.getInptDt());    /** column 입력일자 : inptDt */
																	updateYeta2000VO.setInptAddr(infcYeta2000VO.getInptAddr());    /** column 입력주소 : inptAddr */
																	updateYeta2000VO.setIsmt(infcYeta2000VO.getIsmt());    /** column 수정자 : ismt */ 
			
			    													payCalculationService.updateYeta2000(updateYeta2000VO);
			    													
		                                                   // 	}
	    												//	} else {
	    														// 아직 완료 되지 않은 경우 
	    													//}	
                                                    	}	
                                                    }
                                                }  else {
                                                
                                                	/***************************************************************************************************************
                                                	 * 2017년도 귀속연말정산은 여기를 태움 
                                                	 ***************************************************************************************************************/

                                                	InfcPkgYe161010SrhVO    infcPkgYe161010SrhVo	 = new InfcPkgYe161010SrhVO();	// 연말정산대상자기본 
                                                    
                                                    infcPkgYe161010SrhVo.setDpobCd(payr0250Vo.getDpobCd());                /** column 사업장코드 : dpobCd */
                                                    infcPkgYe161010SrhVo.setYrtxBlggYr(payr0250Vo.getJobYrMnth().substring(0, 4)) ;          /** column 지급년월 : pymtYrMnth */ 
                                                    infcPkgYe161010SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                    infcPkgYe161010SrhVo.setClutSeptCd("Y0020010");   //정산구분코드 
                                                    
                                                    InfcPkgYe169010VO    infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
                                                    InfcPkgYe161010VO  updateYe161010Vo = new InfcPkgYe161010VO();
                                                   // InfcPkgYeta2000VO  infcYeta2000VO = new InfcPkgYeta2000VO();
                                                   // InfcPkgYeta2000VO  updateYeta2000VO = new InfcPkgYeta2000VO();
                                                    
                                                    infcPkgYe169010Vo = payCalculationService.seletYeta2017ToPayrData(infcPkgYe161010SrhVo); 
                                                    
                                                 //   for(int i307Cnt = 0;i307Cnt < listPayr0307Vo.size();i307Cnt++) {
                                                    
                                                    	    
                                                  //  payr0307Vo = listPayr0307Vo.get(i307Cnt);
                                                             
//                                                //	public static final String PAY_DDUC_D02201 = "D0220100";   // 	D0220100	B0080030	B0250260	환급소득세
                                                  //	public static final String PAY_DDUC_D02301 = "D0230100";   // 	D0230100	B0080030	B0250270	환급주민세
                                                  //	public static final String PAY_DDUC_D08701 = "D0870100";   // 	D0870100	B0080030	B0250310	연말정산원천징수
                                                  //	public static final String PAY_DDUC_D08702 = "D0870200";   // 	D0870200	B0080030	B0250310	연말정산재정산
                                                    
                                                    
                                                        if  (MSFSharedUtils.paramNotNull(infcPkgYe169010Vo) && MSFSharedUtils.paramNotNull(infcPkgYe169010Vo.getSystemkey())) { 
                                                        	
                                                        	if(!MSFSharedUtils.allowNulls(infcPkgYe169010Vo.getYrtxPrcsDt()).equals(payr0250Vo.getPymtDt())) {     /** column 연말정산처리일자 : yrtxPrcsDt */
                                                        	
    	    													if (!("Y".equals(infcPkgYe169010Vo.getYrtxPrcsYn()))) {
    	    														 
    		                                                    	if (infcPkgYe169010Vo.getDivdPymtDivSu().compareTo(infcPkgYe169010Vo.getDivdPymt()) > 0) {
    		                                                    		
    		                                                    		BigDecimal subtEtax = BigDecimal.ZERO;   //소득세 
    		                                                    		BigDecimal subtInhb = BigDecimal.ZERO;   //주민세 
    		                                                    		BigDecimal divdPymtAmnt = BigDecimal.ZERO;   //합계  
    		                                                    		
    		                                                    		updateYe161010Vo.setDivdPymt(String.valueOf(new BigDecimal(infcPkgYe169010Vo.getDivdPymt()).add(BigDecimal.ONE)));    /** column 분할납부횟수 : divdPymt */
    																	 
    		                                                    		if (updateYe161010Vo.getDivdPymt().compareTo(infcPkgYe169010Vo.getDivdPymtDivSu()) == 0) {
    		                                                    			// 같으면 잔액으로 처리 할
    		                                                    			subtEtax = infcPkgYe169010Vo.getSubtEtax().subtract(infcPkgYe169010Vo.getSubtEtax01().multiply(new BigDecimal(infcPkgYe169010Vo.getDivdPymt())));
    		                                                    			subtInhb = infcPkgYe169010Vo.getSubtInhb().subtract(infcPkgYe169010Vo.getSubtInhb01().multiply(new BigDecimal(infcPkgYe169010Vo.getDivdPymt())));
    		                                                    			  
    		    															updateYe161010Vo.setYrtxPrcsYn("Y");    /** column 연말정산처리여부 : yrtxPrcsYn */ 
    		    															
    		                                                    		} else {
    		                                                    			//다르면 값을 다르게 처리 할것. 
    		                                                    			subtEtax =  infcPkgYe169010Vo.getSubtEtax01();
    		                                                    			subtInhb =  infcPkgYe169010Vo.getSubtInhb01(); 
    		                                                    			 
    		    															updateYe161010Vo.setYrtxPrcsYn(infcPkgYe169010Vo.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
    		                                                    		}
    		                                                    		
    		                                                    		divdPymtAmnt = infcPkgYe169010Vo.getDivdPymtAmnt();
    		                                                    		divdPymtAmnt = divdPymtAmnt.add(subtEtax.add(subtInhb));
    		                                                    		
    			    													 //연말정산 환급금처리 
    			    													if (subtEtax.compareTo(BigDecimal.ZERO) != 0) {
    			    														
    			//    			                                        	 //	public static final String PAY_DDUC_D02201 = "D0220100";   // 	D0220100	B0080030	B0250260	환급소득세
    			    				                                            
    			    														payr0302Vo.setDpobCd(infcPkgYe169010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
    			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
    			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
    			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
    			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
    			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02201"));    /** column 급여항목코드 : payItemCd */
    			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
    			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
    			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
    			                                                            payr0302Vo.setPymtDducSum(subtEtax);    /** column 지급공제금액 : pymtDducSum */
    			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
    			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
    			            //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
    			            //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
    			            //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
    			            //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
    			            //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
    			            //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
    			                                                            payrCommCalcService.insertPayr0302(payr0302Vo); 
    			    	                                                        
    			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtEtax); //공제합계 
    			    	                                                    
    			    													}  
    			    													
    			    													if (subtInhb.compareTo(BigDecimal.ZERO) != 0) {
    			    														
    			//    			                                        	//	public static final String PAY_DDUC_D02301 = "D0230100";   // 	D0230100	B0080030	B0250270	환급주민세
    			    														
    			    														payr0302Vo.setDpobCd(infcPkgYe169010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
    			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
    			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
    			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
    			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
    			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02301"));    /** column 급여항목코드 : payItemCd */
    			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
    			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
    			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
    			                                                            payr0302Vo.setPymtDducSum(subtInhb);    /** column 지급공제금액 : pymtDducSum */
    			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
    			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
    			    	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
    			    	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
    			    	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
    			    	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
    			    	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
    			    	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
    			    	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
    			    	                                                        
    			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtInhb); //공제합계 
    			    													}
    			                                                        
    			                                                        /*************************************************/
    			    													//연말정산 처리 업데이트 부분 
    			    													/*************************************************/ 
    			
    																	updateYe161010Vo.setDpobCd(infcPkgYe169010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
    																	updateYe161010Vo.setYrtxBlggYr(infcPkgYe169010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
    																	updateYe161010Vo.setClutSeptCd(infcPkgYe169010Vo.getClutSeptCd());    /** column 정산구분코드 : settGbcd */
    																	updateYe161010Vo.setSystemkey(infcPkgYe169010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
    																//	updateYe161010Vo.setYrtxApptnYrMnth(infcPkgYe169010Vo.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */ 
    																//	updateYe161010Vo.setDivdPymtDivCd(infcPkgYe169010Vo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
    																	
    																	//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
    	    															//updateYe161010Vo.setYrtxPrcsDt(sdf.format(new Date()));    /** column 연말정산처리일자 : yrtxPrcsDt */
    																	updateYe161010Vo.setYrtxPrcsDt(payr0250Vo.getPymtDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
    	    															
    																	updateYe161010Vo.setDivdPymtAmnt(divdPymtAmnt);    /** column 분납납부금액 : divdPymtAmnt */
    																	
    																	updateYe161010Vo.setKybdr(infcPkgYe169010Vo.getKybdr());    /** column 입력자 : kybdr */
    																	updateYe161010Vo.setInptDt(infcPkgYe169010Vo.getInptDt());    /** column 입력일자 : inptDt */
    																	updateYe161010Vo.setInptAddr(infcPkgYe169010Vo.getInptAddr());    /** column 입력주소 : inptAddr */
    																	updateYe161010Vo.setIsmt(infcPkgYe169010Vo.getIsmt());    /** column 수정자 : ismt */ 
    			
    			    													payCalculationService.updateYeta2017ToYe161010(updateYe161010Vo);
    			    													
    		                                                    	}
    	    													} else {
    	    														// 아직 완료 되지 않은 경우 
    	    													}	
                                                        	} else {
                                                        		//급여 반영이 된경우 처리 
                                                        		//if (!("Y".equals(infcPkgYe169010Vo.getYrtxPrcsYn()))) {
    	    														 
    		                                                    //	if (infcPkgYe169010Vo.getDivdPymtDivSu().compareTo(infcPkgYe169010Vo.getDivdPymt()) > 0) {
    		                                                    		
    		                                                    		BigDecimal subtEtax = BigDecimal.ZERO;   //소득세 
    		                                                    		BigDecimal subtInhb = BigDecimal.ZERO;   //주민세 
    		                                                    		BigDecimal divdPymtAmnt = BigDecimal.ZERO;   //합계  
    		                                                    		
    		                                                    		updateYe161010Vo.setDivdPymt(infcPkgYe169010Vo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
    																	 
    		                                                    		if (updateYe161010Vo.getDivdPymt().compareTo(infcPkgYe169010Vo.getDivdPymtDivSu()) == 0) {
    		                                                    			// 같으면 잔액으로 처리 할
    		                                                    			subtEtax = infcPkgYe169010Vo.getSubtEtax().subtract(infcPkgYe169010Vo.getSubtEtax01().multiply((new BigDecimal(infcPkgYe169010Vo.getDivdPymt())).subtract(BigDecimal.ONE)));
    		                                                    			subtInhb = infcPkgYe169010Vo.getSubtInhb().subtract(infcPkgYe169010Vo.getSubtInhb01().multiply((new BigDecimal(infcPkgYe169010Vo.getDivdPymt())).subtract(BigDecimal.ONE)));
    		                                                    			  
    		    															updateYe161010Vo.setYrtxPrcsYn("Y");    /** column 연말정산처리여부 : yrtxPrcsYn */ 
    		    															
    		                                                    		} else {
    		                                                    			//다르면 값을 다르게 처리 할것. 
    		                                                    			subtEtax =  infcPkgYe169010Vo.getSubtEtax01();
    		                                                    			subtInhb =  infcPkgYe169010Vo.getSubtInhb01(); 
    		                                                    			 
    		    															updateYe161010Vo.setYrtxPrcsYn(infcPkgYe169010Vo.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
    		                                                    		}
    		                                                    		
    		                                                    		divdPymtAmnt = infcPkgYe169010Vo.getDivdPymtAmnt(); 
    		                                                    		//divdPymtAmnt = subtEtax.add(subtInhb);
    		                                                    		
    			    													 //연말정산 환급금처리 
    			    													if (subtEtax.compareTo(BigDecimal.ZERO) != 0) {
    			    														
    			//    			                                        	 //	public static final String PAY_DDUC_D02201 = "D0220100";   // 	D0220100	B0080030	B0250260	환급소득세
    			    				                                            
    			    														payr0302Vo.setDpobCd(infcPkgYe169010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
    			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
    			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
    			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
    			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
    			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02201"));    /** column 급여항목코드 : payItemCd */
    			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
    			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
    			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
    			                                                            payr0302Vo.setPymtDducSum(subtEtax);    /** column 지급공제금액 : pymtDducSum */
    			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
    			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
    			            //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
    			            //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
    			            //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
    			            //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
    			            //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
    			            //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
    			                                                            payrCommCalcService.insertPayr0302(payr0302Vo); 
    			    	                                                        
    			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtEtax); //공제합계 
    			    	                                                    
    			    													}  
    			    													
    			    													if (subtInhb.compareTo(BigDecimal.ZERO) != 0) {
    			    														
    			//    			                                        	//	 public static final String PAY_DDUC_D02301 = "D0230100";   // 	D0230100	B0080030	B0250270	환급주민세
    			    														
    			    														payr0302Vo.setDpobCd(infcPkgYe169010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
    			                                                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : pymtYrMnth */
    			                                                            payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
    			                                                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
    			                                                            payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
    			                                                            payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_D02301"));    /** column 급여항목코드 : payItemCd */
    			                                                            payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    /** column 급여항목일련번호 : payItemSeilNum */
    			                                                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
    			                                                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
    			                                                            payr0302Vo.setPymtDducSum(subtInhb);    /** column 지급공제금액 : pymtDducSum */
    			                                                            payr0302Vo.setPayPymtDducPrcsFlag("N");    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    			                                                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
    			                                                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
    			    	        //                                                payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
    			    	        //                                                payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
    			    	        //                                                payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
    			    	        //                                                payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
    			    	        //                                                payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
    			    	        //                                                payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
    			    	                                                    payrCommCalcService.insertPayr0302(payr0302Vo); 
    			    	                                                        
    			    	                                                    tpDducTotAmnt   =  tpDducTotAmnt.add(subtInhb); //공제합계 
    			    													}
    			                                                        
    			                                                        /*************************************************/
    			    													//연말정산 처리 업데이트 부분 
    			    													/*************************************************/ 
    			
    																	updateYe161010Vo.setDpobCd(infcPkgYe169010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
    																	updateYe161010Vo.setYrtxBlggYr(infcPkgYe169010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
    																	updateYe161010Vo.setClutSeptCd(infcPkgYe169010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
    																	updateYe161010Vo.setSystemkey(infcPkgYe169010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
    																//	updateYe161010Vo.setYrtxApptnYrMnth(infcPkgYe169010Vo.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */ 
    																//	updateYe161010Vo.setDivdPymtDivCd(infcPkgYe169010Vo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
    																	
    																	//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
    	    															//updateYe161010Vo.setYrtxPrcsDt(sdf.format(new Date()));    /** column 연말정산처리일자 : yrtxPrcsDt */
    																	updateYe161010Vo.setYrtxPrcsDt(payr0250Vo.getPymtDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
    	    															
    																	updateYe161010Vo.setDivdPymtAmnt(divdPymtAmnt);    /** column 분납납부금액 : divdPymtAmnt */
    																	
    																	updateYe161010Vo.setKybdr(infcPkgYe169010Vo.getKybdr());    /** column 입력자 : kybdr */
    																	updateYe161010Vo.setInptDt(infcPkgYe169010Vo.getInptDt());    /** column 입력일자 : inptDt */
    																	updateYe161010Vo.setInptAddr(infcPkgYe169010Vo.getInptAddr());    /** column 입력주소 : inptAddr */
    																	updateYe161010Vo.setIsmt(infcPkgYe169010Vo.getIsmt());    /** column 수정자 : ismt */ 
    			
    			    													payCalculationService.updateYeta2017ToYe161010(updateYe161010Vo);
    			    													
    		                                                   // 	}
    	    												//	} else {
    	    														// 아직 완료 되지 않은 경우 
    	    													//}	
                                                        	}	
                                                        }
                                                    
                                                        /***************************************************************************************************************
                                                    	 * 2017년도 귀속연말정산은 여기를 태움 
                                                    	 ***************************************************************************************************************/
                                                }
                                            	
                                                    /**===============================================================================================
                                                     * YETA2000/YETA3000에 데이터 존재여부 확인하여 payr0302에 인서트 작업진행을 한다. 
                                                     *  연말정산에 따른 처리 루틴으로 3월 및 분납자 대상자 환수금/환급급 처리를 한다.
                                                     *  환급금의 경우 3월에 지급대상으로 선택이 되어 있는경우 공제에 인서트 
                                                     *  환수금정보도 동일하게 구성된다   
                                                     *  2017년귀속분 부터 변경됨 처리를 위해 따로 설계됨 
                                                     ================================================================================================*/
                                        	      
                                                 // 급여내역 합계를 구한다. 
                                              // 월급여내역  업데이트한다. - 이후 급여합계은 업데이트 한다.   
                                               
  				                          	  pkgInsrWorkVo.setTpTxtnTotAmnt(tpPymtTotAmnt.subtract(tpFreeDtyTotAmnt)); 
                                              //과세대상금액 
                                             pkgInsrWorkVo.setTpWorkIncmTxtnSum(BigDecimal.ZERO); //과세대상금액  
                                             txTotAmnt =  BigDecimal.ZERO;    //과세합계
                                              
                                             pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgInsrWorkVo.getTpTxtnTotAmnt());   //비과세,학자금을 제외한 금액 
                                                
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
                                                   payr0302Vo.setPymtDducSum(txTotAmnt);
                                                   payr0302Vo.setPayPymtDducPrcsFlag("N");
                                                   payr0302Vo.setPayReattyAdmntVal("0");
                                                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
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
//                                                 payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                                                 payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                                                 payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                                                 payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                                                 payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                                                 payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                   payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                                                   
                                                   payrCommCalcService.insertPayr0302(payr0302Vo);  
                                                   
                                                   
                                            	   payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                   payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
                                                   payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
                                                   payr0301Vo.setPayCd(payCalculationVo.getPayCd());          
                                                   payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
                                                   payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
                                                   payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
                                                   payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
                                                   payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
                                                   payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
                                                   payr0301Vo.setTxTotAmnt(txTotAmnt);     
                                                   payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
                                                   payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
                                                   payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
                                                   payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
                                                   payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
                                                   payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
                                                   payr0301Vo.setPayDdlneDt("");    
                                                   payr0301Vo.setPayDdlneYn("N");   
            //                                     payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
            //                                     payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
            //                                     payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
            //                                     payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
            //                                     payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
            //                                     payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                   
                                                   payrCommCalcService.updatePayr0301(payr0301Vo); //월급여내역  
                                               } else {
                                            	   //소득세 주민세처리 루틴 변경 적용 2017.08.21
                                                   txTotAmnt = payrTaxCtl.getWorkIncmTxtn( request,payr0250Vo,payCalculationVo,pkgInsrWorkVo.getTpWorkIncmTxtnSum() ,pkgInsrWorkVo.getTpNatPennAmt());
                                                   
                                               
	                                               payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                                               payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());   
	                                               payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    
	                                               payr0301Vo.setPayCd(payCalculationVo.getPayCd());          
	                                               payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());   
	                                               payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);   
	                                               payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt );  
	                                               payr0301Vo.setTxtnTotAmnt(pkgInsrWorkVo.getTpTxtnTotAmnt());   
	                                               payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);
	                                               payr0301Vo.setDducTotAmnt(tpDducTotAmnt);   
	                                               payr0301Vo.setTxTotAmnt(txTotAmnt);     
	                                               payr0301Vo.setSevePayPymtYn("N"); //퇴직정산지급여부 업데이트   
	                                               payr0301Vo.setPernPymtSum((tpPymtTotAmnt.subtract((tpDducTotAmnt.add(txTotAmnt)))));   
	                                               payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0")); 
	                                               payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());         
	                                               payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    
	                                               payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    
	                                               payr0301Vo.setPayDdlneDt("");    
	                                               payr0301Vo.setPayDdlneYn("N");   
	        //                                     payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
	        //                                     payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
	        //                                     payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
	        //                                     payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
	        //                                     payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
	        //                                     payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
	                                               
	                                               payrCommCalcService.updatePayr0301(payr0301Vo); //월급여내역  
                                               
                                               }  
                                            } else if (ExtermsProps.getProps("PAY_CD_04").equals(payr0250Vo.getPayCd())) {
                                             /**
                                                * @@@@@@@@@@@@@@@@@@@@@@  명절휴가비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                */  
                                             
                                                 //C9110100  명절휴가비
                                                 
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
              //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
              //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
              //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
              //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
              //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
              //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                 
                                               
                                                 payrCommCalcService.insertPayr0301(payr0301Vo); //월급여내역  
                                                 
                                                 /**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                                  *  급여 항목에 따른 인서트 및 계산 처리 시작 
                                                    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
                                                 
                                                 //지급공제항목에 따른 급여항목에 따른 인서트 처리 
                                                 Set<InfcPkgPayr0490VO> payr0490Set = payCalculationVo.getExPayr0490();
                                              
                                                 Iterator<InfcPkgPayr0490VO> iterpayr0490Set = payr0490Set!=null ? payr0490Set.iterator()  : null;
                                                 
                                                 while ( iterpayr0490Set!=null && iterpayr0490Set.hasNext() ) {
                                                     
                                                       InfcPkgPayr0490VO payr0490 = iterpayr0490Set.next();
                                                  
                                                       if (PayrPkgUtil.funcMonthCheck(payr0250Vo, null, payr0490)) {
                                                          
                                                           
                                                                 payr0302Vo.setDpobCd(payr0490.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                                 payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                                                 payr0302Vo.setPayCd(payr0490.getPayCd());    /** column 급여구분코드 : payCd */
                                                                 payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                                 payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                                                 payr0302Vo.setPayItemCd(payr0490.getPayItemCd());   /** column 급여항목코드 : payItemCd */
                                                                 payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                                                                 payr0302Vo.setPymtDducDivCd(payr0490.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */ 
                                                                 payr0302Vo.setPymtDducFreeDtySum(payr0490.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                                                                 payr0302Vo.setPymtDducSum(payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                                                                 payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                                                                 payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                                                                 payr0302Vo.setPymtDducTxtnAmnt(payr0490.getPymtDducSum().subtract(payr0490.getFreeDtySum()).setScale(-1,BigDecimal.ROUND_DOWN));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
              //                                                   payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
              //                                                   payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
              //                                                   payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
              //                                                   payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
              //                                                   payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
              //                                                   payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                                                                  
                                                                 tpPymtTotAmnt = tpPymtTotAmnt.add(payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                 tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0490.getPymtDducSum().setScale(-1,BigDecimal.ROUND_DOWN));
                                                                 tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0490.getFreeDtySum().setScale(-1,BigDecimal.ROUND_DOWN)); 
                                                                 if (BigDecimal.ZERO.compareTo(payr0302Vo.getPymtDducSum()) < 0)  {
                                                              	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                                                                 }  
                                                    }  
                                                 }
                                                  
                                                 payr0301Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                                 payr0301Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());    /** column 지급년월 : JobYrMnth */
                                                 payr0301Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                                                 payr0301Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                                 payr0301Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                                                 payr0301Vo.setPymtTotAmnt(tpPymtTotAmnt);    /** column 지급총액 : pymtTotAmnt */
                                                 payr0301Vo.setExtpyTotAmnt(tpExtpyTotAmnt);    /** column 수당총액 : extpyTotAmnt */
                                                 payr0301Vo.setTxtnTotAmnt(tpExtpyTotAmnt);    /** column 과세총액 : txtnTotAmnt */
                                                 payr0301Vo.setFreeDtyTotAmnt(tpFreeDtyTotAmnt);    /** column 비과세총액 : freeDtyTotAmnt */
                                                 payr0301Vo.setDducTotAmnt(BigDecimal.ZERO);    /** column 공제총액 : dducTotAmnt */
                                                 payr0301Vo.setTxTotAmnt(BigDecimal.ZERO);    /** column 세금총액 : txTotAmnt */
                                                 payr0301Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
                                                 payr0301Vo.setPernPymtSum(tpPymtTotAmnt);    /** column 차인지급액 : pernPymtSum */
                                                 payr0301Vo.setIncmTxCllnRto(new BigDecimal("0.0"));    /** column 소득세징수비율 : incmTxCllnRto */
                                                 payr0301Vo.setBnkCd(payCalculationVo.getBnkCd());    /** column 은행코드 : bnkCd */
                                                 payr0301Vo.setBnkAccuNum(payCalculationVo.getBnkAccuNum());    /** column 은행계좌번호 : bnkAccuNum */
                                                 payr0301Vo.setAcntHodrNm(payCalculationVo.getAcntHodrNm());    /** column 예금주명 : acntHodrNm */
                                                 payr0301Vo.setPayDdlneDt("");    /** column 급여마감일자 : payDdlneDt */
                                                 payr0301Vo.setPayDdlneYn("N");    /** column 급여마감여부 : payDdlneYn */
              //                                  payr0301Vo.setKybdr(payr0250Vo.getKybdr());    /** column 입력자 : kybdr */
              //                                  payr0301Vo.setInptDt(payr0250Vo.getInptDt());    /** column 입력일자 : inptDt */
              //                                  payr0301Vo.setInptAddr(payr0250Vo.getInptAddr());    /** column 입력주소 : inptAddr */
              //                                  payr0301Vo.setIsmt(payr0250Vo.getIsmt());    /** column 수정자 : ismt */
              //                                  payr0301Vo.setRevnDt(payr0250Vo.getRevnDt());    /** column 수정일자 : revnDt */
              //                                  payr0301Vo.setRevnAddr(payr0250Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                                                 
                                                 payrCommCalcService.updatePayr0301(payr0301Vo); //명휴가비 
                                                
                                            } else if (ExtermsProps.getProps("PAY_CD_05").equals(payr0250Vo.getPayCd())) {
                                             /**
                                                * @@@@@@@@@@@@@@@@@@@@@@  초과근무수당 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                */  
                                                
                                            } else if (ExtermsProps.getProps("PAY_CD_06").equals(payr0250Vo.getPayCd())) {
                                             /**
                                                * @@@@@@@@@@@@@@@@@@@@@@ 연가보상비 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                */
                                                
                                            } else if (ExtermsProps.getProps("PAY_CD_07").equals(payr0250Vo.getPayCd())) {
                                             /**
                                                * @@@@@@@@@@@@@@@@@@@@@@ 초과근무수당(12월) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
                                                */
                                                
                                            }  
                                            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[기간제근로자]월급여" ,"처리완료","대상자 : " + payCalculationVo.getHanNm() + "명처리완료 "));
                                        } else {
                                        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]항목에러" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","급여항목데이터 존재하지 않음.")); 
                                        }//while ( iter.hasNext() )  
                                 } else {
                                	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[월급여]급여대상아님" + payCalculationVo.getHanNm() + " 처리중","기간제근로자","급여대상자관리에서 급여대상 급여대상여부체크 확인 ")); 
                                    //급여대상여부가 불러왔는데 대상자가 아닌경우 처리  조정데이타가 존재하면 삭제 
                                    InfcPkgPayr0307VO  payr0307SrhVo = new InfcPkgPayr0307VO();
                                    
                                    payr0307SrhVo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                    payr0307SrhVo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                                    payr0307SrhVo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
                                    payr0307SrhVo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                                    payr0307SrhVo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                    
                                    payrCommCalcService.deletePayCalculationPayr0307(payr0307SrhVo); 
                                }           
                           }
                                  
                       }   
                       
                       bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[기간제근로자]월급여" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(psnlList.size()) + "명처리완료 "));
	        //	}
                  
             // retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
           } catch (Exception ex) {
                ex.printStackTrace();   
        	   ShowMessageBM smBm = new ShowMessageBM();
        	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
        	   smBm.setMenu("Payr");
        	   smBm.setPhase("[급여]에러");
        	   smBm.setMessage(ex.getLocalizedMessage());
        	   smBm.setContent(ex.getMessage());
        	   bmResult.add(smBm);  
        	 //  retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
        	 
           } 
           
           return bmResult; 
	  	}
	  	
	  
	    

}