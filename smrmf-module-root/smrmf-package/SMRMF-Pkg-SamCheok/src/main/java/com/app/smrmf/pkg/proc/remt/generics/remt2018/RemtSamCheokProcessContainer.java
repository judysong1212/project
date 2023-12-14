package com.app.smrmf.pkg.proc.remt.generics.remt2018;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0100VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200VO;
import com.app.smrmf.pkg.proc.remt.retirement.calculation.RetirementCalculstionService;
import com.app.smrmf.pkg.proc.remt.retirement.payr.Remt0100DlgnVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtLogSvcDysVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPayr0302SrhVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPsnl0100SrhVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPsnl0100VO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtWfep0100VO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RetirementPayrService;
import com.app.smrmf.props.ExtermsProps;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.fdl.string.EgovDateUtil;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class RemtSamCheokProcessContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(RemtSamCheokProcessContainer.class);
    private static final String calledClass = RemtSamCheokProcessContainer.class.getName();
	  
	 
	//퇴직금계산인터페이스 
    @Resource(name = "RetirementPayrService")
    protected RetirementPayrService remtPayrService;
    
    @Resource(name = "RetirementCalculstionService")
    protected RetirementCalculstionService remtCalcService;

  

//    public RemtProcessContainer() {
//    	
//    }
    
    //기본 퇴직금산정 루틴  
    public PagingLoadResult<ShowMessageBM> execRemt0100ToRetirementCalc(HttpServletRequest request,ArrayList<InfcPkgRemt2000VO> liseRemt2000)  throws Exception  {
  	    
	  	  return  funcRetirementPayrCalc(request,liseRemt2000);
	}
    
    //저장루틴에 따른 변동사항 재저장 처리를 위한 처리부 
    public PagingLoadResult<ShowMessageBM> execRemt0100ToRemtCalc2000(HttpServletRequest request, InfcPkgRemt2000VO  remt2000)  throws Exception  {
  	    
	  	  return  funcRemt0100ToRemtCalc2000(request,remt2000);
	} 
     
  
    //저장루틴에 따른 변동사항 재저장 처리를 위한 처리부 
    public PagingLoadResult<ShowMessageBM> execActivityOnPayrCalc(HttpServletRequest request, List<InfcPkgRemt2000VO> listRemt2000Vo)  throws Exception  {
  	    
	  	  return  funcActivityOnPayrCalc(request,listRemt2000Vo);
	} 
    
    //급여내역 시간 변경에 따른 데이타 재계산 처리를 위한 루틴 추가 
    public Long execActivityOnUpdateRemt0100ToPayrCalc(HttpServletRequest request, List<InfcPkgRemt2200VO> lstInfcRemt2200Vo)  throws Exception  {
  	    
	  	  return  funcActivityOnUpdateRemt0100ToPayrCalc(request,lstInfcRemt2200Vo);
	} 
    
    /**
     * 후생복지비에 따른 계산 처리 
     * @param request
     * @param lstInfcRemt2200Vo
     * @return
     * @throws Exception
     */
    public Long execActivityOnUpdateRemt0100ToPayrWfepCalc(HttpServletRequest request, List<InfcPkgRemt2200VO> lstInfcRemt2200Vo)  throws Exception  {
  	    
	  	  return  funcActivityOnUpdateRemt0100ToPayrWfepCalc(request,lstInfcRemt2200Vo);
	} 
     
      
    //퇴직정산 
    public PagingLoadResult<ShowMessageBM> execRemtTxCalculation(HttpServletRequest request,List<InfcPkgRemt3000VO> lstInfcRemt3000TgtVo)  throws Exception  {
  	    
	  	  return  funcRemtTxCalculation(request,lstInfcRemt3000TgtVo);
	}
   
    
    /**
     * 퇴직금산정 - 급여를  계산하여 퇴직금을 산정하는 메서드 
     * @param request
     * @param remt3000TgtVo
     * @param listVoPsnl0100
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcRetirementPayrCalc(HttpServletRequest request,ArrayList<InfcPkgRemt2000VO> liseRemt2000)  throws Exception  {
    	
    		String method = calledClass + ".funcRetirementPayrCalc";
    	
    	  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
	  	  
	  	  try {
	  		  
	  		   
		  	   if  (remtPayrService == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               remtPayrService = (RetirementPayrService) wac.getBean("RetirementPayrService" ); 
	              
	          }
		  	   
		  	   if  (remtCalcService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               remtCalcService = (RetirementCalculstionService) wac.getBean("RetirementCalculstionService" ); 
              
          }
		  	   
		  	   /*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		  	    * 대상자로 선택된 근로자에 대해 돌면서 퇴직금을 기본적으로 돌린다. 
		  	    * *******군경력을 기본적으로 포함하는지 이미 포함하여 중간 정산을 했는지 여부판단하여 처리 ***********
		  	    **********************************************************************************/
		  	   
		  	 for (int iCnt01 = 0;iCnt01 < liseRemt2000.size();iCnt01++) {
		  	
		  		 InfcPkgRemt2000VO infcRemt2000Vo = new InfcPkgRemt2000VO(); 
		  		 InfcPkgRemt2000VO tpInfcRemt2000Vo = new InfcPkgRemt2000VO(); 
		  		 
		  		 infcRemt2000Vo =  liseRemt2000.get(iCnt01);
		  		 
		  		RemtPsnl0100SrhVO remtPsnl0100SrhVo = new RemtPsnl0100SrhVO(); 
				RemtPsnl0100VO remtPsnl0100Vo = new RemtPsnl0100VO();
				
				remtPsnl0100SrhVo.setDpobCd(infcRemt2000Vo.getDpobCd());
		  		remtPsnl0100SrhVo.setSystemkey(infcRemt2000Vo.getSystemkey());
		  		
		  		/**@@@@@@@@@@@@@@@@@@@@@@@퇴직 대상자 정보 조회  @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		  		 // 인사의 개인 기본정보를 가지고 온다. 
		  		 // 중간정산여부 확인 및 군경력지급여부 확인 //가산율해당여부 확인.가산율가져오기  
		  		remtPsnl0100Vo = remtPayrService.selectRemt0100ToPsnl0100(remtPsnl0100SrhVo);
		  		 
		  	  if (MSFSharedUtils.paramNull(remtPsnl0100Vo)) {
             	 //  BaseModel bm = new BaseModel();
             	   ShowMessageBM smBm = new ShowMessageBM();
             	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR); 
             	   smBm.setMenu("Remt");
             	   smBm.setPhase("[퇴직정산]대상자조회오류");
             	   smBm.setMessage("데이터가존재하지않습니다.");
             	   smBm.setContent("SystemKey" + remtPsnl0100SrhVo.getSystemkey());
             	   bmResult.add(smBm); 
                }  
		  		  

				infcRemt2000Vo.setDpobCd(remtPsnl0100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
				infcRemt2000Vo.setSystemkey(remtPsnl0100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			 	infcRemt2000Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			 	infcRemt2000Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				infcRemt2000Vo.setEmymtDivCd(remtPsnl0100Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
				infcRemt2000Vo.setDeptCd(remtPsnl0100Vo.getCurrAffnDeptCd());    /** column 부서코드 : deptCd */
			//	infcRemt2000Vo.setTypOccuCd(remtPsnl0100Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
				infcRemt2000Vo.setPyspGrdeCd(remtPsnl0100Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
				infcRemt2000Vo.setDtilOccuInttnCd(remtPsnl0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
				infcRemt2000Vo.setBusinCd(remtPsnl0100Vo.getBusinCd());    /** column 사업코드 : businCd */
				//infcRemt2000Vo.setInbyCd(remtPsnl0100Vo.getInbyCd());    /** column 직위코드 : inbyCd */
				infcRemt2000Vo.setPyspCd(remtPsnl0100Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
				infcRemt2000Vo.setLogSvcYrNumCd(remtPsnl0100Vo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
				infcRemt2000Vo.setLogSvcMnthIcmCd(remtPsnl0100Vo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
				 
				infcRemt2000Vo.setNm(remtPsnl0100Vo.getHanNm());    /** column 성명 : nm */
				infcRemt2000Vo.setIcncDt(remtPsnl0100Vo.getFrstEmymtDt());    /** column 입사일자 : icncDt */
				if (MSFSharedUtils.paramNull(remtPsnl0100Vo.getRkfcdDt())) { 
					infcRemt2000Vo.setRkfcdDt(remtPsnl0100Vo.getFrstEmymtDt());    /** column 기산일자 : rkfcdDt */
				} else {
					infcRemt2000Vo.setRkfcdDt(remtPsnl0100Vo.getRkfcdDt());    /** column 기산일자 : rkfcdDt */
				}
				 
				infcRemt2000Vo.setRetryDt(remtPsnl0100Vo.getRetryDt());    /** column 퇴직일자 : retryDt */ 
				
				
				 
				infcRemt2000Vo.setEepnMnthIcm2012Bfr(BigDecimal.ZERO);    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
				infcRemt2000Vo.setEepnMnthIcm2013Aft(BigDecimal.ZERO);    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
				infcRemt2000Vo.setAddMnthIcm2012Bfr(BigDecimal.ZERO);    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
				infcRemt2000Vo.setAddMnthIcm2013Aft(BigDecimal.ZERO);    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
				infcRemt2000Vo.setEepnDayIcmDys(BigDecimal.ZERO);    /** column 제외일수 : eepnDayIcmDys */
			
				infcRemt2000Vo.setPayCmpttnBgnnDt("");    /** column 급여산정시작일자 : payCmpttnBgnnDt */
				infcRemt2000Vo.setPayCmpttnEndDt("");     /** column 급여산정종료일자 : payCmpttnEndDt */
				
				infcRemt2000Vo.setFndtnPayAggrSumSum(BigDecimal.ZERO);    /** column 기본급여합계금액 : fndtnPayAggrSumSum */
				infcRemt2000Vo.setSnryAllwAggrSum(BigDecimal.ZERO);    /** column 제수당합계금액 : snryAllwAggrSum */
				infcRemt2000Vo.setWelfWelfSpdgAggrSum(BigDecimal.ZERO);    /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
				infcRemt2000Vo.setMarPubcWelfAmnt(BigDecimal.ZERO);    /** column 3월간후생복지비 : marPubcWelfAmnt */
				infcRemt2000Vo.setMarTotAmntWag(BigDecimal.ZERO);    /** column 3월간총임금액 : marTotAmntWag */
				infcRemt2000Vo.setDayAvgAmntWag(BigDecimal.ZERO);    /** column 1일평균임금액 : dayAvgAmntWag */
				infcRemt2000Vo.setSevePayCmpttnSum(BigDecimal.ZERO);    /** column 퇴직금산정금액 : sevePayCmpttnSum */
				
				infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
				infcRemt2000Vo.setSevePayAddRate(remtPsnl0100Vo.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
				
				infcRemt2000Vo.setSevePayAddApptnSum(BigDecimal.ZERO);    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
				
				if ("Y".equals(remtPsnl0100Vo.getChkAmcrrClutInsnYn())) {
				    infcRemt2000Vo.setAmcrrClutInsnYn("N");    /** column 군경력정산포함여부 : amcrrClutInsnYn */
				} else {
					infcRemt2000Vo.setAmcrrClutInsnYn(remtPsnl0100Vo.getAmcrrClutInsnYn());    /** column 군경력정산포함여부 : amcrrClutInsnYn */
				}
				infcRemt2000Vo.setAmcrrAddApptnSum(BigDecimal.ZERO);    /** column 군경력가산적용금액 : amcrrAddApptnSum */
				
				infcRemt2000Vo.setSevePayPymtSum(BigDecimal.ZERO);    /** column 퇴직금지급액 : sevePayPymtSum */
				infcRemt2000Vo.setSevePayCmpttnFreeDtySum(BigDecimal.ZERO);    /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
				infcRemt2000Vo.setSevePayCmpttnTxtnSum(BigDecimal.ZERO);    /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
				infcRemt2000Vo.setSevePayPymtDducSum(BigDecimal.ZERO);    /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
				infcRemt2000Vo.setSevePayTurtyPymtSum(BigDecimal.ZERO);    /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
				infcRemt2000Vo.setSevePayNoteCtnt("");    /** column 퇴직금비고내용 : sevePayNoteCtnt */
				infcRemt2000Vo.setSevePayPymtDt("");    /** column 퇴직금지급일자 : sevePayPymtDt */
				infcRemt2000Vo.setSevePayPymtYn("N");    /** column 퇴직금지급여부 : sevePayPymtYn */
				infcRemt2000Vo.setDdlneYn("N");    /** column 마감여부 : ddlneYn */
				infcRemt2000Vo.setDdlneDt("");    /** column 마감일시 : ddlneDt */
				 
				/** ------------- 퇴직인경우 처리를 위해 함수 호출 -------------- */
				if (ExtermsProps.getProps("HDOFC_CODTN_CD_20").equals(remtPsnl0100Vo.getHdofcCodtnCd())) {
					RemtLogSvcDysVO  remtLogSvcDysVo= new RemtLogSvcDysVO(); 
					//근속년수 계산로직 호출 기산일자,퇴직일자,군경력포함여부  
					remtLogSvcDysVo = fnc_LogSvcDys(request,infcRemt2000Vo );
					
					infcRemt2000Vo.setLogSvcYrNum(remtLogSvcDysVo.getLogSvcYrNum());    /** column 근속년수 : logSvcYrNum */
					infcRemt2000Vo.setLogSvcMnthIcm(remtLogSvcDysVo.getLogSvcMnthIcm());    /** column 근속월수 : logSvcMnthIcm */
					infcRemt2000Vo.setLogSvcNumDys(remtLogSvcDysVo.getLogSvcNumDys());    /** column 근속일수 : logSvcNumDys */
					
					infcRemt2000Vo.setTurtyDutyYrNum(remtLogSvcDysVo.getTurtyDutyYrNum());    /** column 실근무년수 : turtyDutyYrNum */
					infcRemt2000Vo.setTurtyDutyMnthNum(remtLogSvcDysVo.getTurtyDutyMnthNum());    /** column 실근무개월수 : turtyDutyMnthNum */
					infcRemt2000Vo.setTurtyDutyNumDys(remtLogSvcDysVo.getTurtyDutyNumDys());    /** column 실근무일수 : turtyDutyNumDys */
					 
					infcRemt2000Vo.setTotLogSvcNumDys(remtLogSvcDysVo.getTotLogSvcNumDys());    /** column 총근무일수 : totLogSvcNumDys */
					
					if ("N".equals(remtPsnl0100Vo.getChkAmcrrClutInsnYn())) {
						infcRemt2000Vo.setAmcrrClutInsnYn(remtPsnl0100Vo.getAmcrrClutInsnYn());    /** column 군경력정산포함여부 : amcrrClutInsnYn */
						infcRemt2000Vo.setAmcrrLogSvcYrNum(remtLogSvcDysVo.getAmcrrLogSvcYrNum());    /** column 군경력근속년수 : amcrrLogSvcYrNum */
						infcRemt2000Vo.setAmcrrLogSvcMnthIcm(remtLogSvcDysVo.getAmcrrLogSvcMnthIcm());    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */ 
						infcRemt2000Vo.setAmcrrLogSvcNumDys(remtLogSvcDysVo.getAmcrrLogSvcNumDys());    /** column 군경력근무일수 : amcrrLogSvcNumDys */ 
					} else {
						infcRemt2000Vo.setAmcrrClutInsnYn("N");    /** column 군경력정산포함여부 : amcrrClutInsnYn */
					    infcRemt2000Vo.setAmcrrLogSvcYrNum(BigDecimal.ZERO);    /** column 군경력근속년수 : amcrrLogSvcYrNum */
						infcRemt2000Vo.setAmcrrLogSvcMnthIcm(BigDecimal.ZERO);    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */ 
						infcRemt2000Vo.setAmcrrLogSvcNumDys(BigDecimal.ZERO);    /** column 군경력근무일수 : amcrrLogSvcNumDys */ 
						
					} 
					
				} else { 
					infcRemt2000Vo.setLogSvcYrNum(BigDecimal.ZERO);    /** column 근속년수 : logSvcYrNum */
					infcRemt2000Vo.setLogSvcMnthIcm(BigDecimal.ZERO);    /** column 근속월수 : logSvcMnthIcm */
					infcRemt2000Vo.setLogSvcNumDys(BigDecimal.ZERO);    /** column 근속일수 : logSvcNumDys */
					
					
					infcRemt2000Vo.setTurtyDutyYrNum(BigDecimal.ZERO);    /** column 실근무년수 : turtyDutyYrNum */
					infcRemt2000Vo.setTurtyDutyMnthNum(BigDecimal.ZERO);    /** column 실근무개월수 : turtyDutyMnthNum */
					infcRemt2000Vo.setTurtyDutyNumDys(BigDecimal.ZERO);    /** column 실근무일수 : turtyDutyNumDys */
					
					infcRemt2000Vo.setTotLogSvcNumDys(BigDecimal.ZERO);    /** column 총근무일수 : totLogSvcNumDys */
					
					infcRemt2000Vo.setAmcrrLogSvcYrNum(BigDecimal.ZERO);    /** column 군경력근속년수 : amcrrLogSvcYrNum */
					infcRemt2000Vo.setAmcrrLogSvcMnthIcm(BigDecimal.ZERO);    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */ 
					infcRemt2000Vo.setAmcrrLogSvcNumDys(BigDecimal.ZERO);    /** column 군경력근무일수 : amcrrLogSvcNumDys */ 
					
				}
				/** ------------- 퇴직인경우 처리를 위해 함수 호출 -------------- */
				
				infcRemt2000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
				infcRemt2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				infcRemt2000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
				infcRemt2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				

//				infcRemt2000Vo.setDpobCd(remtPsnl0100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//				infcRemt2000Vo.setSystemkey(remtPsnl0100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//			//	infcRemt2000Vo.setCalcSevePayPsnDivCd(remtPsnl0100Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//			//	infcRemt2000Vo.setClutYrMnth(remtPsnl0100Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
//				infcRemt2000Vo.setEmymtDivCd(remtPsnl0100Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//				infcRemt2000Vo.setDeptCd(remtPsnl0100Vo.getDeptCd());    /** column 부서코드 : deptCd */
//				infcRemt2000Vo.setTypOccuCd(remtPsnl0100Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//				infcRemt2000Vo.setPyspGrdeCd(remtPsnl0100Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//				infcRemt2000Vo.setDtilOccuInttnCd(remtPsnl0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//				infcRemt2000Vo.setBusinCd(remtPsnl0100Vo.getBusinCd());    /** column 사업코드 : businCd */
//			//	infcRemt2000Vo.setInbyCd(remtPsnl0100Vo.getInbyCd());    /** column 직위코드 : inbyCd */
//				infcRemt2000Vo.setPyspCd(remtPsnl0100Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
//				infcRemt2000Vo.setLogSvcYrNumCd(remtPsnl0100Vo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//				infcRemt2000Vo.setLogSvcMnthIcmCd(remtPsnl0100Vo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//				infcRemt2000Vo.setNm(remtPsnl0100Vo.getHanNm());    /** column 성명 : nm */
//				infcRemt2000Vo.setIcncDt(remtPsnl0100Vo.getFrstEmymtDt());    /** column 입사일자 : icncDt */
//				infcRemt2000Vo.setRetryDt(remtPsnl0100Vo.getRetryDt());    /** column 퇴직일자 : retryDt */
//				infcRemt2000Vo.setLogSvcYrNum(remtPsnl0100Vo.getLogSvcYrNum());    /** column 근속년수 : logSvcYrNum */
//				infcRemt2000Vo.setLogSvcMnthIcm(remtPsnl0100Vo.getLogSvcMnthIcm());    /** column 근속월수 : logSvcMnthIcm */
//				infcRemt2000Vo.setAmcrrLogSvcYrNum(remtPsnl0100Vo.getAmcrrLogSvcYrNum());    /** column 군경력근속년수 : amcrrLogSvcYrNum */
//				infcRemt2000Vo.setAmcrrLogSvcMnthIcm(remtPsnl0100Vo.getAmcrrLogSvcMnthIcm());    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
//				infcRemt2000Vo.setEepnMnthIcm2012Bfr(remtPsnl0100Vo.getEepnMnthIcm2012Bfr());    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//				infcRemt2000Vo.setEepnMnthIcm2013Aft(remtPsnl0100Vo.getEepnMnthIcm2013Aft());    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//				infcRemt2000Vo.setAddMnthIcm2012Bfr(remtPsnl0100Vo.getAddMnthIcm2012Bfr());    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//				infcRemt2000Vo.setAddMnthIcm2013Aft(remtPsnl0100Vo.getAddMnthIcm2013Aft());    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//				infcRemt2000Vo.setLogSvcNumDys(remtPsnl0100Vo.getLogSvcNumDys());    /** column 근속일수 : logSvcNumDys */
//				infcRemt2000Vo.setAmcrrLogSvcNumDys(remtPsnl0100Vo.getAmcrrLogSvcNumDys());    /** column 군경력근무일수 : amcrrLogSvcNumDys */
//				infcRemt2000Vo.setPayCmpttnBgnnDt(remtPsnl0100Vo.getPayCmpttnBgnnDt());    /** column 급여산정시작일자 : payCmpttnBgnnDt */
//				infcRemt2000Vo.setPayCmpttnEndDt(remtPsnl0100Vo.getPayCmpttnEndDt());    /** column 급여산정종료일자 : payCmpttnEndDt */
//				infcRemt2000Vo.setFndtnPayAggrSumSum(remtPsnl0100Vo.getFndtnPayAggrSumSum());    /** column 기본급여합계금액 : fndtnPayAggrSumSum */
//				infcRemt2000Vo.setSnryAllwAggrSum(remtPsnl0100Vo.getSnryAllwAggrSum());    /** column 제수당합계금액 : snryAllwAggrSum */
//				infcRemt2000Vo.setWelfWelfSpdgAggrSum(remtPsnl0100Vo.getWelfWelfSpdgAggrSum());    /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
//				infcRemt2000Vo.setMarPubcWelfAmnt(remtPsnl0100Vo.getMarPubcWelfAmnt());    /** column 3월간후생복지비 : marPubcWelfAmnt */
//				infcRemt2000Vo.setMarTotAmntWag(remtPsnl0100Vo.getMarTotAmntWag());    /** column 3월간총임금액 : marTotAmntWag */
//				infcRemt2000Vo.setDayAvgAmntWag(remtPsnl0100Vo.getDayAvgAmntWag());    /** column 1일평균임금액 : dayAvgAmntWag */
//				infcRemt2000Vo.setSevePayCmpttnSum(remtPsnl0100Vo.getSevePayCmpttnSum());    /** column 퇴직금산정금액 : sevePayCmpttnSum */
//				infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
//				infcRemt2000Vo.setSevePayAddRate(remtPsnl0100Vo.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
//				infcRemt2000Vo.setSevePayAddApptnSum(remtPsnl0100Vo.getSevePayAddApptnSum());    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
//				infcRemt2000Vo.setAmcrrClutInsnYn(remtPsnl0100Vo.getAmcrrClutInsnYn());    /** column 군경력정산포함여부 : amcrrClutInsnYn */
//				infcRemt2000Vo.setAmcrrAddApptnSum(remtPsnl0100Vo.getAmcrrAddApptnSum());    /** column 군경력가산적용금액 : amcrrAddApptnSum */
//				infcRemt2000Vo.setTotLogSvcNumDys(remtPsnl0100Vo.getTotLogSvcNumDys());    /** column 총근무일수 : totLogSvcNumDys */
//				infcRemt2000Vo.setSevePayPymtSum(remtPsnl0100Vo.getSevePayPymtSum());    /** column 퇴직금지급액 전체합산금액 : sevePayPymtSum */
//				infcRemt2000Vo.setSevePayCmpttnFreeDtySum(remtPsnl0100Vo.getSevePayCmpttnFreeDtySum());    /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
//				infcRemt2000Vo.setSevePayCmpttnTxtnSum(remtPsnl0100Vo.getSevePayCmpttnTxtnSum());    /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
//				infcRemt2000Vo.setSevePayPymtDducSum(remtPsnl0100Vo.getSevePayPymtDducSum());    /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
//				infcRemt2000Vo.setSevePayTurtyPymtSum(remtPsnl0100Vo.getSevePayTurtyPymtSum());    /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
//				infcRemt2000Vo.setSevePayNoteCtnt(remtPsnl0100Vo.getSevePayNoteCtnt());    /** column 퇴직금비고내용 : sevePayNoteCtnt */
//				infcRemt2000Vo.setSevePayPymtDt(remtPsnl0100Vo.getSevePayPymtDt());    /** column 퇴직금지급일자 : sevePayPymtDt */
//				infcRemt2000Vo.setSevePayPymtYn(remtPsnl0100Vo.getSevePayPymtYn());    /** column 퇴직금지급여부 : sevePayPymtYn */
//				infcRemt2000Vo.setDdlneYn(remtPsnl0100Vo.getDdlneYn());    /** column 마감여부 : ddlneYn */
//				infcRemt2000Vo.setDdlneDt(remtPsnl0100Vo.getDdlneDt());    /** column 마감일시 : ddlneDt */
 
					

		  	      tpInfcRemt2000Vo = remtPayrService.selectRemt2000(infcRemt2000Vo);
		  	      /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		  	      
		  		  if (MSFSharedUtils.paramNull(tpInfcRemt2000Vo)) { 
                      
		  			remtPayrService.insertRemt2000(infcRemt2000Vo);
		  			
		  			 /**@=====================퇴직금정산 기본/정산 인서트 업데이트 시작 =====================@*/   


			  		InfcPkgRemt3000VO infcRemt3000Vo = new InfcPkgRemt3000VO();
			  		InfcPkgRemt3100VO infcRemt3100Vo = new InfcPkgRemt3100VO();
			  		InfcPkgBass0100VO infcBass0100Vo = new InfcPkgBass0100VO();
			  		
			  		infcRemt3000Vo.setDpobCd(remtPsnl0100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
					infcRemt3000Vo.setSystemkey(remtPsnl0100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
				 	infcRemt3000Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				 	infcRemt3000Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				 	 
				 	
 
					//infcRemt3000Vo.setSevePayClutMangeNum("");    /** column 퇴직정산관리번호 : sevePayClutMangeNum */
					infcRemt3000Vo.setReipDt("");    /** column 영수일자 : reipDt */
					infcRemt3000Vo.setDdlneYn("N");    /** column 마감여부 : ddlneYn */
					infcRemt3000Vo.setDdlneDt("");    /** column 마감일자 : ddlneDt */
					infcRemt3000Vo.setCalcSevePayPsnSumtDt("");    /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
			       
					infcBass0100Vo.setDpobCd(remtPsnl0100Vo.getDpobCd());
					
					infcBass0100Vo = remtCalcService.selectBass0100(infcBass0100Vo);
					
				 
					//사업장정보에서 데이타 가져오기 담당자는 수기입력 화면에서 기본담당자 로그인해서 처리하는 사람을 기준으로 기본적으로 작업진행.
 
					infcRemt3000Vo.setCorpNmFmnm(infcBass0100Vo.getDpobNm());    /** column 사업장명 : dpobNm */
					infcRemt3000Vo.setResnRegnNum(infcBass0100Vo.getDegtrResnRegnNum());    /** column 대표자주민번호 : degtrResnRegnNum */ 
					infcRemt3000Vo.setDegtrNm(infcBass0100Vo.getDegtrNm());    /** column 대표자명 : degtrNm */
					infcRemt3000Vo.setBusoprRgstnNum(infcBass0100Vo.getBusoprRgstnNum());    /** column 사업자등록번호 : busoprRgstnNum */
					infcRemt3000Vo.setCorpNum(infcBass0100Vo.getCorpRgstnNum());    /** column 법인등록번호 : corpRgstnNum */ 
					infcRemt3000Vo.setIncmRegrstDebrZpcd(infcBass0100Vo.getDpobZpcd());    /** column 사업장우편번호 : dpobZpcd */
					infcRemt3000Vo.setIncmRegrstDebrFndtnAddr(infcBass0100Vo.getDpobFndtnAddr());    /** column 사업장기본주소 : dpobFndtnAddr */
					infcRemt3000Vo.setIncmRegrstDebrDtlPatrAddr(infcBass0100Vo.getDpobDtlPatrAddr());    /** column 사업장상세주소 : dpobDtlPatrAddr */
					 
					infcRemt3000Vo.setCllnDebrDivCd(infcBass0100Vo.getRetryCllnDebrDivCd());    /** column 퇴직징수의무자구분코드 : retryCllnDebrDivCd */
					  
 
//					infcRemt3000Vo.setJuriTxOffcCd(infcRemt2000Vo.getJuriTxOffcCd());    /** column 관할세무서코드 : juriTxOffcCd */
//					infcRemt3000Vo.setPentrCd(infcRemt2000Vo.getPentrCd());    /** column 제출자구분코드 : pentrCd */
//					infcRemt3000Vo.setTxDeptyNum(infcRemt2000Vo.getTxDeptyNum());    /** column 세무대리인번호 : txDeptyNum */
//					infcRemt3000Vo.setHmtxId(infcRemt2000Vo.getHmtxId());    /** column 홈텍스ID : hmtxId */
//					infcRemt3000Vo.setTxPgmCd(infcRemt2000Vo.getTxPgmCd());    /** column 세무프로그램코드 : txPgmCd */
//					infcRemt3000Vo.setPernChrgDeptNm(infcRemt2000Vo.getPernChrgDeptNm());    /** column 담당자부서명 : pernChrgDeptNm */
//					infcRemt3000Vo.setPernChrgNm(infcRemt2000Vo.getPernChrgNm());    /** column 담당자성명 : pernChrgNm */
//					infcRemt3000Vo.setPernChrgPhnNum(infcRemt2000Vo.getPernChrgPhnNum());    /** column 담당자전화번호 : pernChrgPhnNum */ 
					
					infcRemt3000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
					infcRemt3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					infcRemt3000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
					infcRemt3000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				 	
				 	
					infcRemt3100Vo.setDpobCd(remtPsnl0100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
					infcRemt3100Vo.setSystemkey(remtPsnl0100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
				 	infcRemt3100Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				 	infcRemt3100Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				 	
					infcRemt3100Vo.setDeptCd(infcRemt2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
					infcRemt3100Vo.setHanNm(infcRemt2000Vo.getNm());    /** column 한글성명 : hanNm */
					infcRemt3100Vo.setResnRegnNum(remtPsnl0100Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
					infcRemt3100Vo.setAimenrEcteYn("N");    /** column 소득자임원여부 : aimenrEcteYn */
					infcRemt3100Vo.setFixPayJnDt("");    /** column 확정급여형가입일자 : fixPayJnDt */
					infcRemt3100Vo.setSevePay20111231Sum(BigDecimal.ZERO);    /** column 퇴직금_20111231금액 : sevePay20111231Sum */
					infcRemt3100Vo.setFrgnrDivCd(remtPsnl0100Vo.getFrgnrDivCd());    /** column 외국인구분코드 : frgnrDivCd */
					infcRemt3100Vo.setRidnSeptYn("Y");    /** column 거주구분여부 : ridnSeptYn */
					infcRemt3100Vo.setRidnCd("");    /** column 거주지국코드 : ridnCd */
					infcRemt3100Vo.setRidnNm("");    /** column 거주지국명 : ridnNm */
					
					infcRemt3100Vo.setCalcSevePsnBlggYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
					//TODO 해당 회계 원천으로 설정값을 가져온다. 
					//SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy"); 
		           // String strCalcSevePsnBlggYr = dateFormatGmt.format(EgovDateUtil.getCurrentDateAsString());
					 String strCalcSevePsnBlggYr =  EgovDateUtil.getCurrentYearAsString() ;
		            String strCalcSevePsnDt = strCalcSevePsnBlggYr.concat("0101");
		            
                    if (strCalcSevePsnDt.compareTo(infcRemt2000Vo.getRkfcdDt()) > 0) {
                    	infcRemt3100Vo.setBlggYrBgnnDt(strCalcSevePsnDt);    /** column 귀속년도시작일자 : blggYrBgnnDt */
                    } else {
                    	infcRemt3100Vo.setBlggYrBgnnDt(infcRemt2000Vo.getRkfcdDt());    /** column 귀속년도시작일자 : blggYrBgnnDt */
                    }
                    
                    if (strCalcSevePsnDt.compareTo(infcRemt2000Vo.getRetryDt()) > 0) {
                    	
                    	infcRemt3100Vo.setBlggYrEndDt(infcRemt2000Vo.getSevePayPymtDt());    /** column 귀속년도종료일자 : blggYrEndDt */
                    	infcRemt3100Vo.setCalcSevePsnBlggYrMnth(infcRemt2000Vo.getSevePayPymtDt().substring(0, 6));    /** column 귀속년월 : CalcSevePsnBlggYrMnth */
                    } else {
                    	infcRemt3100Vo.setBlggYrEndDt(infcRemt2000Vo.getRetryDt());    /** column 귀속년도종료일자 : blggYrEndDt */
                    	infcRemt3100Vo.setCalcSevePsnBlggYrMnth(infcRemt2000Vo.getRetryDt().substring(0, 6));    /** column 귀속년월 : CalcSevePsnBlggYrMnth */
                    } 
				  	 
				    
				    //infcRemt3100Vo.setRetryReasCd(infcRemt2000Vo.getRetryReasCd());    /** column 퇴직사유코드 : retryReasCd */
					
					
					infcRemt3100Vo.setCtrBusoprRgstnNum("");    /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
					infcRemt3100Vo.setCtrPaeWorkNm("");    /** column 중_근무처명 : ctrPaeWorkNm */
					
					infcRemt3100Vo.setCtrRetryPayQnty(BigDecimal.ZERO);    /** column 중_퇴직급여액 : ctrRetryPayQnty */
					infcRemt3100Vo.setCtrFreeDtyRetryPayQnty(BigDecimal.ZERO);    /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
					infcRemt3100Vo.setCtrTxtnTgtRetryPayQnty(BigDecimal.ZERO);    /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
					
					//TODO 사업장정보에서 가져옴.
					infcRemt3100Vo.setEndBusoprRgstnNum(infcBass0100Vo.getBusoprRgstnNum());    /** column 종_사업자등록번호 : endBusoprRgstnNum */
					infcRemt3100Vo.setEndPaeWorkNm(infcBass0100Vo.getDpobNm());    /** column 종_근무처명 : endPaeWorkNm */
					
					infcRemt3100Vo.setEndRetryPayQnty(BigDecimal.ZERO);    /** column 종_퇴직급여액 : endRetryPayQnty */
					infcRemt3100Vo.setEndFreeDtyRetryPayQnty(BigDecimal.ZERO);    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
					infcRemt3100Vo.setEndTxtnTgtRetryPayQnty(BigDecimal.ZERO);    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
					infcRemt3100Vo.setClutRetryPayQnty(BigDecimal.ZERO);    /** column 정산_퇴직급여액 : clutRetryPayQnty */
					infcRemt3100Vo.setClutFreeDtyRetryPayQnty(BigDecimal.ZERO);    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
					infcRemt3100Vo.setClutTxtnTgtRetryPayQnty(BigDecimal.ZERO);    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
				
					infcRemt3100Vo.setCtrIcncDt("");    /** column 중_입사일자 : ctrIcncDt */
					infcRemt3100Vo.setCtrRkfcdDt("");    /** column 중_기산일자 : ctrRkfcdDt */
					infcRemt3100Vo.setCtrRsgtnDt("");    /** column 중_퇴사일자 : ctrRsgtnDt */
					infcRemt3100Vo.setCtrPymtDt("");    /** column 중_지급일자 : ctrPymtDt */
					infcRemt3100Vo.setCtrLogSvcMnthIcm(BigDecimal.ZERO);    /** column 중_근속월수 : ctrLogSvcMnthIcm */
					infcRemt3100Vo.setCtrEepnMnth12Bfr(BigDecimal.ZERO);    /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
					infcRemt3100Vo.setCtrEepnMnth13Aft(BigDecimal.ZERO);    /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
					infcRemt3100Vo.setCtrAddMnth12Bfr(BigDecimal.ZERO);    /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
					infcRemt3100Vo.setCtrAddMnth13Aft(BigDecimal.ZERO);    /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
					infcRemt3100Vo.setCtrEepnMnthIcm(BigDecimal.ZERO);    /** column 중_제외월수 : ctrEepnMnthIcm */
					infcRemt3100Vo.setCtrAddMnthIcm(BigDecimal.ZERO);    /** column 중_가산월수 : ctrAddMnthIcm */
					infcRemt3100Vo.setCtrDupMnthIcm(BigDecimal.ZERO);    /** column 중_중복월수 : ctrDupMnthIcm */
					infcRemt3100Vo.setCtrLogSvc(BigDecimal.ZERO);    /** column 중_근속연수 : ctrLogSvc */
					infcRemt3100Vo.setEndIcncDt(infcRemt2000Vo.getIcncDt());    /** column 종_입사일자 : endIcncDt */
					infcRemt3100Vo.setEndRkfcdDt(infcRemt2000Vo.getRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
					infcRemt3100Vo.setEndRsgtnDt(infcRemt2000Vo.getRetryDt());    /** column 종_퇴사일자 : endRsgtnDt */
					infcRemt3100Vo.setEndPymtDt(infcRemt2000Vo.getSevePayPymtDt());    /** column 종_지급일자 : endPymtDt */
					infcRemt3100Vo.setEndLogSvcMnthIcm(infcRemt2000Vo.getTurtyDutyMnthNum());    /** column 종_근속월수 : endLogSvcMnthIcm */
					infcRemt3100Vo.setEndEepnMnth12Bfr(infcRemt2000Vo.getEepnMnthIcm2012Bfr());    /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
					infcRemt3100Vo.setEndEepnMnth13Aft(infcRemt2000Vo.getEepnMnthIcm2013Aft());    /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
					infcRemt3100Vo.setEndAddMnth12Bfr(infcRemt2000Vo.getAddMnthIcm2012Bfr());    /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
					infcRemt3100Vo.setEndAddMnth13Aft(infcRemt2000Vo.getAddMnthIcm2013Aft());    /** column 종_가산월수_2013이후 : endAddMnth13Aft */
					
					infcRemt3100Vo.setEndEepnMnthIcm(BigDecimal.ZERO);    /** column 종_제외월수 : endEepnMnthIcm */
					infcRemt3100Vo.setEndAddMnthIcm(BigDecimal.ZERO);    /** column 종_가산월수 : endAddMnthIcm */
					infcRemt3100Vo.setEndDupMnthIcm(BigDecimal.ZERO);    /** column 종_중복월수 : endDupMnthIcm */
					infcRemt3100Vo.setEndLogSvcYrNum(infcRemt2000Vo.getTurtyDutyYrNum());    /** column 종_근속연수 : endLogSvcYrNum */
					
					infcRemt3100Vo.setClutIcncDt("");    /** column 정산_입사일자 : clutIcncDt */
					infcRemt3100Vo.setClutRkfcdDt("");    /** column 정산-기산일자 : clutRkfcdDt */
					infcRemt3100Vo.setClutRsgtnDt("");    /** column 정산_퇴사일자 : clutRsgtnDt */
					infcRemt3100Vo.setClutPymtDt("");    /** column 정산_지급일자 : clutPymtDt */
					infcRemt3100Vo.setClutLogSvcMnthIcm(infcRemt2000Vo.getTurtyDutyMnthNum());    /** column 정산_근속월수 : clutLogSvcMnthIcm */
					infcRemt3100Vo.setClutEepnMnthIcm(BigDecimal.ZERO);    /** column 정산_제외월수 : clutEepnMnthIcm */
					infcRemt3100Vo.setClutAddMnthIcm(BigDecimal.ZERO);    /** column 정산_가산월수 : clutAddMnthIcm */
					infcRemt3100Vo.setClutDupMnthIcm(BigDecimal.ZERO);    /** column 정산_중복월수 : clutDupMnthIcm */
					infcRemt3100Vo.setClutLogSvcYrNum(infcRemt2000Vo.getTurtyDutyYrNum());    /** column 정산_근속연수 : clutLogSvcYrNum */
					
					infcRemt3100Vo.setLogPpnl12befIcncDt("");    /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
					infcRemt3100Vo.setLogPpnl12befRkfcdDt("");    /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
					infcRemt3100Vo.setLogPpnl12befRsgtnDt("");    /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
					infcRemt3100Vo.setLogPpnl12befPymtDt("");    /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
					
					infcRemt3100Vo.setLogPpnl12befLogMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
					infcRemt3100Vo.setLogPpnl12befEepnMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
					infcRemt3100Vo.setLogPpnl12befAddMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
					infcRemt3100Vo.setLogPpnl12befDupMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
					infcRemt3100Vo.setLogPpnl12befLogYrNum(BigDecimal.ZERO);    /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
					
					infcRemt3100Vo.setLogPpnl13afrIcncDt("");    /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
					infcRemt3100Vo.setLogPpnl13afrRkfcdDt("");    /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
					infcRemt3100Vo.setLogPpnl13afrRsgtnDt("");    /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
					infcRemt3100Vo.setLogPpnl13afrPymtDt("");    /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
					
					
					infcRemt3100Vo.setLogPpnl13afrLogMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
					infcRemt3100Vo.setLogPpnl13afrEepnMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
					infcRemt3100Vo.setLogPpnl13afrAddMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
					infcRemt3100Vo.setLogPpnl13afrDupMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
					infcRemt3100Vo.setLogPpnl13afrLogSvc(BigDecimal.ZERO);    /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
					
					infcRemt3100Vo.setRetryIncmCtrPymtSum(BigDecimal.ZERO);    /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
					infcRemt3100Vo.setRetryIncmEndPymtSum(BigDecimal.ZERO);    /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
					infcRemt3100Vo.setRetryIncmClutSum(BigDecimal.ZERO);    /** column 퇴직소득_정산금액 : retryIncmClutSum */
					infcRemt3100Vo.setRetryFxrtDducClutSum(BigDecimal.ZERO);    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
					infcRemt3100Vo.setLogYrDducSum(BigDecimal.ZERO);    /** column 근속년수공제_정산금액 : logYrDducSum */
					infcRemt3100Vo.setRetryTxtnStdClutSum(BigDecimal.ZERO);    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
					infcRemt3100Vo.setTat12befTxtnStdPpnlSum(BigDecimal.ZERO);    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
					infcRemt3100Vo.setTat12befYravgTxstdSum(BigDecimal.ZERO);    /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
					infcRemt3100Vo.setTat12befCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
					infcRemt3100Vo.setTat12befCvsnCalcAmnt(BigDecimal.ZERO);    /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
					infcRemt3100Vo.setTat12befYrAvgCalcAmnt(BigDecimal.ZERO);    /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
					infcRemt3100Vo.setTat12befCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
					infcRemt3100Vo.setTat12befAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
					infcRemt3100Vo.setTat12befRegTgtTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
					infcRemt3100Vo.setTat13afrTxstdPpnlSum(BigDecimal.ZERO);    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
					infcRemt3100Vo.setTat13afrYrAvgStdSum(BigDecimal.ZERO);    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
					infcRemt3100Vo.setTat13afrCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
					infcRemt3100Vo.setTat13afrCvsnCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
					infcRemt3100Vo.setTat13afrYrAvgCalcAmnt(BigDecimal.ZERO);    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
					infcRemt3100Vo.setTat13afrCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
					infcRemt3100Vo.setTat13afrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
					infcRemt3100Vo.setTat13afrRegrstTgtSum(BigDecimal.ZERO);    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
					infcRemt3100Vo.setTatAggrTxtnStdPpnlSum(BigDecimal.ZERO);    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
					infcRemt3100Vo.setTatAggrYrAvgTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
					infcRemt3100Vo.setTatAggrCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
					infcRemt3100Vo.setTatAggrCvsnCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
					infcRemt3100Vo.setTatAggrYrAvgCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
					infcRemt3100Vo.setTatAggrCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
					infcRemt3100Vo.setTatAggrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
					infcRemt3100Vo.setTatAggrRegrstTgtTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
					infcRemt3100Vo.setTalRegrstTgtTxAmnt(BigDecimal.ZERO);    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
					infcRemt3100Vo.setTalAccuDepitAggrSum(BigDecimal.ZERO);    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
					infcRemt3100Vo.setTalRetryPayQnty(BigDecimal.ZERO);    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
					infcRemt3100Vo.setTalRetryIncmTxAmnt(BigDecimal.ZERO);    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
					infcRemt3100Vo.setPymtRegTgtIncmTxQnty(BigDecimal.ZERO);    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
					infcRemt3100Vo.setPymtRegTgtRgonIncmQnty(BigDecimal.ZERO);    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
					infcRemt3100Vo.setPymtRegTgtFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
					infcRemt3100Vo.setPymtRegrstTgtAggrSum(BigDecimal.ZERO);    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
					infcRemt3100Vo.setPymtTalcIncmTxQnty(BigDecimal.ZERO);    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
					infcRemt3100Vo.setPymtTalcRgonIncmTxQnty(BigDecimal.ZERO);    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
					infcRemt3100Vo.setPymtTalcFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
					infcRemt3100Vo.setPymtTxAllcAggrSum(BigDecimal.ZERO);    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
					infcRemt3100Vo.setPymtSubtnIncmTxQnty(BigDecimal.ZERO);    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
					infcRemt3100Vo.setPymtSubtnRgonIncmTxQnty(BigDecimal.ZERO);    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
					infcRemt3100Vo.setPymtSubtnFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
					infcRemt3100Vo.setPymtSubtnAggrSum(BigDecimal.ZERO);    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
					infcRemt3100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
					infcRemt3100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					infcRemt3100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
					infcRemt3100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
  
			  		  
				 	remtPayrService.insertRemt3000(infcRemt3000Vo);
				 	remtPayrService.insertRemt3100(infcRemt3100Vo);
				 	 /**@=====================퇴직금정산 기본/정산 인서트 업데이트 종료 =====================@*/    
                  } else {
                      
                	remtPayrService.updateRemt2000(infcRemt2000Vo);
                  } 
		  		  
		  		  
		  		
		  	 } 
		  	   
		        /**********************************************************************************
		  	    * 대상자로 선택된 근로자에 대해 돌면서 1차작업 종료
		  	    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/
		  	 
		  	   
	  	  
	  	} catch (Exception ex) {
           ex.printStackTrace();   
   	   ShowMessageBM smBm = new ShowMessageBM();
   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
   	   smBm.setMenu("Remt");
   	   smBm.setPhase("[퇴직금산정]대상자선택등록에러");
   	   smBm.setMessage(ex.getLocalizedMessage());
   	   smBm.setContent(ex.getMessage());
   	   bmResult.add(smBm);  
   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
   	 
      } 
	  	  
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U"); 
	  	  
	  	   
	  	  return  retval;
    }
    
    
    /**
     * 퇴직금 저장 (수정) 에따른 관련사항 재산정 및 저장 
     * @param request
     * @param remt2000
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcRemt0100ToRemtCalc2000(HttpServletRequest request, InfcPkgRemt2000VO  remt2000)  throws Exception  {
    	
    		String method = calledClass + ".funcRemt0100ToRemtCalc2000";
    	
    	  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	   
	  	  try {
	  		  
	  		   
		  	   if  (remtPayrService == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               remtPayrService = (RetirementPayrService) wac.getBean("RetirementPayrService" ); 
	              
	            }
	  	   
		  	   
		  	
		  		InfcPkgRemt2000VO infcRemt2000Vo = new InfcPkgRemt2000VO(); 
		  		InfcPkgRemt3100VO infcRemt3100Vo = new InfcPkgRemt3100VO();     
		  		
		  		 
		  		infcRemt2000Vo.setDpobCd(remt2000.getDpobCd());    /** column 사업장코드 : dpobCd */
		  		infcRemt2000Vo.setSystemkey(remt2000.getSystemkey());    /** column SYSTEMKEY : systemkey */
		  		infcRemt2000Vo.setCalcSevePayPsnDivCd(remt2000.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  		infcRemt2000Vo.setClutYrMnth(remt2000.getClutYrMnth());    /** column 정산년월 : clutYrMnth */

		  		infcRemt3100Vo.setDpobCd(remt2000.getDpobCd());    /** column 사업장코드 : dpobCd */
		  		infcRemt3100Vo.setSystemkey(remt2000.getSystemkey());    /** column SYSTEMKEY : systemkey */
		  		infcRemt3100Vo.setCalcSevePayPsnDivCd(remt2000.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  		infcRemt3100Vo.setClutYrMnth(remt2000.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				 
		  		/**@@@@@@@@@@@@@@@@@@@@@@@퇴직 대상자 등록정보 조회  @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		  	 
		  		infcRemt2000Vo = remtPayrService.selectRemt2000(infcRemt2000Vo);
		  		infcRemt3100Vo = remtPayrService.selectRemt3100(infcRemt3100Vo);
		  		 
		  	   if (MSFSharedUtils.paramNull(infcRemt2000Vo) ||  MSFSharedUtils.paramNull(infcRemt3100Vo)) {
             	 //  BaseModel bm = new BaseModel();
             	   ShowMessageBM smBm = new ShowMessageBM();
             	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR); 
             	   smBm.setMenu("Remt");
             	   smBm.setPhase("[퇴직정산저장]대상자조회오류");
             	   smBm.setMessage("데이터가존재하지않습니다.");
             	   smBm.setContent("SystemKey" + remt2000.getSystemkey());
             	   bmResult.add(smBm); 
                }  
		  		   
			  
			  infcRemt2000Vo.setDpobCd(remt2000.getDpobCd());    /** column 사업장코드 : dpobCd */
			  infcRemt2000Vo.setSystemkey(remt2000.getSystemkey());    /** column SYSTEMKEY : systemkey */
			  infcRemt2000Vo.setCalcSevePayPsnDivCd(remt2000.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			  infcRemt2000Vo.setClutYrMnth(remt2000.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
//				infcRemt2000Vo.setEmymtDivCd(remt2000Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//				infcRemt2000Vo.setDeptCd(remt2000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//				infcRemt2000Vo.setTypOccuCd(remt2000Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//				infcRemt2000Vo.setPyspGrdeCd(remt2000Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//				infcRemt2000Vo.setDtilOccuInttnCd(remt2000Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//				infcRemt2000Vo.setBusinCd(remt2000Dto.getBusinCd());    /** column 사업코드 : businCd */
//				infcRemt2000Vo.setInbyCd(remt2000Dto.getInbyCd());    /** column 직위코드 : inbyCd */
//				infcRemt2000Vo.setPyspCd(remt2000Dto.getPyspCd());    /** column 호봉코드 : pyspCd */
//				infcRemt2000Vo.setLogSvcYrNumCd(remt2000Dto.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//				infcRemt2000Vo.setLogSvcMnthIcmCd(remt2000Dto.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//				infcRemt2000Vo.setNm(remt2000Dto.getNm());    /** column 성명 : nm */
//				infcRemt2000Vo.setIcncDt(remt2000Dto.getIcncDt());    /** column 입사일자 : icncDt */
			  infcRemt2000Vo.setRkfcdDt(remt2000.getRkfcdDt());    /** column 기산일자 : rkfcdDt */
			  infcRemt2000Vo.setRetryDt(remt2000.getRetryDt());    /** column 퇴직일자 : retryDt */
				//infcRemt2000Vo.setLogSvcYrNum(remt2000Dto.getLogSvcYrNum());    /** column 근속년수 : logSvcYrNum */
				//infcRemt2000Vo.setLogSvcMnthIcm(remt2000Dto.getLogSvcMnthIcm());    /** column 근속월수 : logSvcMnthIcm */
				//infcRemt2000Vo.setAmcrrLogSvcYrNum(remt2000Dto.getAmcrrLogSvcYrNum());    /** column 군경력근속년수 : amcrrLogSvcYrNum */
				//infcRemt2000Vo.setAmcrrLogSvcMnthIcm(remt2000Dto.getAmcrrLogSvcMnthIcm());    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
			  infcRemt2000Vo.setEepnMnthIcm2012Bfr( remt2000.getEepnMnthIcm2012Bfr());    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
			  infcRemt2000Vo.setEepnMnthIcm2013Aft( remt2000.getEepnMnthIcm2013Aft());    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
			  infcRemt2000Vo.setAddMnthIcm2012Bfr( remt2000.getAddMnthIcm2012Bfr());    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
			  infcRemt2000Vo.setAddMnthIcm2013Aft( remt2000.getAddMnthIcm2013Aft());    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
			  infcRemt2000Vo.setEepnDayIcmDys( remt2000.getEepnDayIcmDys());    /** column 제외일수 : eepnDayIcmDys */
				
			  infcRemt2000Vo.setSevePayAddRate( remt2000.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
			  infcRemt2000Vo.setAmcrrClutInsnYn( remt2000.getAmcrrClutInsnYn() );    /** column 군경력정산포함여부 : amcrrClutInsnYn */
				 
			  infcRemt2000Vo.setSevePayNoteCtnt(remt2000.getSevePayNoteCtnt());    /** column 퇴직금비고내용 : sevePayNoteCtnt */
			  infcRemt2000Vo.setSevePayPymtDt(remt2000.getSevePayPymtDt());    /** column 퇴직금지급일자 : sevePayPymtDt */
			 
			   
				/** ------------- 퇴직인경우 처리를 위해 함수 호출 -------------- */
				if (!"".equals(remt2000.getRetryDt())) {
					RemtLogSvcDysVO  remtLogSvcDysVo= new RemtLogSvcDysVO(); 
					//근속년수 계산로직 호출 기산일자,퇴직일자,군경력포함여부  
					remtLogSvcDysVo = fnc_LogSvcDys(request,infcRemt2000Vo );
					
					infcRemt2000Vo.setLogSvcYrNum(remtLogSvcDysVo.getLogSvcYrNum());    /** column 근속년수 : logSvcYrNum */
					infcRemt2000Vo.setLogSvcMnthIcm(remtLogSvcDysVo.getLogSvcMnthIcm());    /** column 근속월수 : logSvcMnthIcm */
					infcRemt2000Vo.setLogSvcNumDys(remtLogSvcDysVo.getLogSvcNumDys());    /** column 근속일수 : logSvcNumDys */
					
					infcRemt2000Vo.setTurtyDutyYrNum(remtLogSvcDysVo.getTurtyDutyYrNum());    /** column 실근무년수 : turtyDutyYrNum */
					infcRemt2000Vo.setTurtyDutyMnthNum(remtLogSvcDysVo.getTurtyDutyMnthNum());    /** column 실근무개월수 : turtyDutyMnthNum */
					infcRemt2000Vo.setTurtyDutyNumDys(remtLogSvcDysVo.getTurtyDutyNumDys());    /** column 실근무일수 : turtyDutyNumDys */
					 
					infcRemt2000Vo.setTotLogSvcNumDys(remtLogSvcDysVo.getTotLogSvcNumDys().subtract(remt2000.getEepnDayIcmDys()) );    /** column 총근무일수 : totLogSvcNumDys */
					
				 
					infcRemt2000Vo.setAmcrrLogSvcYrNum(remtLogSvcDysVo.getAmcrrLogSvcYrNum());    /** column 군경력근속년수 : amcrrLogSvcYrNum */
					infcRemt2000Vo.setAmcrrLogSvcMnthIcm(remtLogSvcDysVo.getAmcrrLogSvcMnthIcm());    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */ 
					infcRemt2000Vo.setAmcrrLogSvcNumDys(remtLogSvcDysVo.getAmcrrLogSvcNumDys());    /** column 군경력근무일수 : amcrrLogSvcNumDys */ 
					 
					
					infcRemt2000Vo.setPayCmpttnBgnnDt(remtLogSvcDysVo.getPayCmpttnBgnnDt());    /** column 급여산정시작일자 : payCmpttnBgnnDt */
					infcRemt2000Vo.setPayCmpttnEndDt(remtLogSvcDysVo.getPayCmpttnEndDt());    /** column 급여산정종료일자 : payCmpttnEndDt */
					
				} else { 
					infcRemt2000Vo.setLogSvcYrNum(BigDecimal.ZERO);    /** column 근속년수 : logSvcYrNum */
					infcRemt2000Vo.setLogSvcMnthIcm(BigDecimal.ZERO);    /** column 근속월수 : logSvcMnthIcm */
					infcRemt2000Vo.setLogSvcNumDys(BigDecimal.ZERO);    /** column 근속일수 : logSvcNumDys */
					
					infcRemt2000Vo.setTurtyDutyYrNum(BigDecimal.ZERO);    /** column 실근무년수 : turtyDutyYrNum */
					infcRemt2000Vo.setTurtyDutyMnthNum(BigDecimal.ZERO);    /** column 실근무개월수 : turtyDutyMnthNum */
					infcRemt2000Vo.setTurtyDutyNumDys(BigDecimal.ZERO);    /** column 실근무일수 : turtyDutyNumDys */
					
					infcRemt2000Vo.setTotLogSvcNumDys(BigDecimal.ZERO);    /** column 총근무일수 : totLogSvcNumDys */
					
					infcRemt2000Vo.setAmcrrLogSvcYrNum(BigDecimal.ZERO);    /** column 군경력근속년수 : amcrrLogSvcYrNum */
					infcRemt2000Vo.setAmcrrLogSvcMnthIcm(BigDecimal.ZERO);    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */ 
					infcRemt2000Vo.setAmcrrLogSvcNumDys(BigDecimal.ZERO);    /** column 군경력근무일수 : amcrrLogSvcNumDys */ 
					
					infcRemt2000Vo.setPayCmpttnBgnnDt("");    /** column 급여산정시작일자 : payCmpttnBgnnDt */
					infcRemt2000Vo.setPayCmpttnEndDt("");    /** column 급여산정종료일자 : payCmpttnEndDt */
				}
				  
				infcRemt2000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
				infcRemt2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				infcRemt2000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
				infcRemt2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				
				remtPayrService.updateRemt2000(infcRemt2000Vo);  
				
		  	    
		  	        /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		  	        
					infcRemt3100Vo.setDpobCd(remt2000.getDpobCd());    /** column 사업장코드 : dpobCd */
					infcRemt3100Vo.setSystemkey(remt2000.getSystemkey());    /** column SYSTEMKEY : systemkey */
				 	infcRemt3100Vo.setCalcSevePayPsnDivCd(remt2000.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				 	infcRemt3100Vo.setClutYrMnth(remt2000.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
 	
				 	
//					infcRemt3100Vo.setDeptCd(infcRemt2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
//					infcRemt3100Vo.setHanNm(infcRemt2000Vo.getNm());    /** column 한글성명 : hanNm */
//					infcRemt3100Vo.setResnRegnNum(remtPsnl0100Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//					infcRemt3100Vo.setAimenrEcteYn("N");    /** column 소득자임원여부 : aimenrEcteYn */
//					infcRemt3100Vo.setFixPayJnDt("");    /** column 확정급여형가입일자 : fixPayJnDt */
//					infcRemt3100Vo.setSevePay20111231Sum(BigDecimal.ZERO);    /** column 퇴직금_20111231금액 : sevePay20111231Sum */
//					infcRemt3100Vo.setFrgnrDivCd(remtPsnl0100Vo.getFrgnrDivCd());    /** column 외국인구분코드 : frgnrDivCd */
//					infcRemt3100Vo.setRidnSeptYn("Y");    /** column 거주구분여부 : ridnSeptYn */
//					infcRemt3100Vo.setRidnCd("");    /** column 거주지국코드 : ridnCd */
//					infcRemt3100Vo.setRidnNm("");    /** column 거주지국명 : ridnNm */
				   //infcRemt3100Vo.setRetryReasCd(infcRemt2000Vo.getRetryReasCd());    /** column 퇴직사유코드 : retryReasCd */
					
					
//					infcRemt3100Vo.setCtrBusoprRgstnNum("");    /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
//					infcRemt3100Vo.setCtrPaeWorkNm("");    /** column 중_근무처명 : ctrPaeWorkNm */
					
//					infcRemt3100Vo.setCtrRetryPayQnty(BigDecimal.ZERO);    /** column 중_퇴직급여액 : ctrRetryPayQnty */
//					infcRemt3100Vo.setCtrFreeDtyRetryPayQnty(BigDecimal.ZERO);    /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
//					infcRemt3100Vo.setCtrTxtnTgtRetryPayQnty(BigDecimal.ZERO);    /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
					
					//TODO 사업장정보에서 가져옴.
					//infcRemt3100Vo.setEndBusoprRgstnNum(infcRemt2000Vo.getEndBusoprRgstnNum());    /** column 종_사업자등록번호 : endBusoprRgstnNum */
					//infcRemt3100Vo.setEndPaeWorkNm(infcRemt2000Vo.getEndPaeWorkNm());    /** column 종_근무처명 : endPaeWorkNm */
					
//					infcRemt3100Vo.setEndRetryPayQnty(BigDecimal.ZERO);    /** column 종_퇴직급여액 : endRetryPayQnty */
//					infcRemt3100Vo.setEndFreeDtyRetryPayQnty(BigDecimal.ZERO);    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
//					infcRemt3100Vo.setEndTxtnTgtRetryPayQnty(BigDecimal.ZERO);    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
//					infcRemt3100Vo.setClutRetryPayQnty(BigDecimal.ZERO);    /** column 정산_퇴직급여액 : clutRetryPayQnty */
//					infcRemt3100Vo.setClutFreeDtyRetryPayQnty(BigDecimal.ZERO);    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
//					infcRemt3100Vo.setClutTxtnTgtRetryPayQnty(BigDecimal.ZERO);    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
				
//					infcRemt3100Vo.setCtrIcncDt("");    /** column 중_입사일자 : ctrIcncDt */
//					infcRemt3100Vo.setCtrRkfcdDt("");    /** column 중_기산일자 : ctrRkfcdDt */
//					infcRemt3100Vo.setCtrRsgtnDt("");    /** column 중_퇴사일자 : ctrRsgtnDt */
//					infcRemt3100Vo.setCtrPymtDt("");    /** column 중_지급일자 : ctrPymtDt */
//					infcRemt3100Vo.setCtrLogSvcMnthIcm(BigDecimal.ZERO);    /** column 중_근속월수 : ctrLogSvcMnthIcm */
//					infcRemt3100Vo.setCtrEepnMnth12Bfr(BigDecimal.ZERO);    /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
//					infcRemt3100Vo.setCtrEepnMnth13Aft(BigDecimal.ZERO);    /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
//					infcRemt3100Vo.setCtrAddMnth12Bfr(BigDecimal.ZERO);    /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
//					infcRemt3100Vo.setCtrAddMnth13Aft(BigDecimal.ZERO);    /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
//					infcRemt3100Vo.setCtrEepnMnthIcm(BigDecimal.ZERO);    /** column 중_제외월수 : ctrEepnMnthIcm */
//					infcRemt3100Vo.setCtrAddMnthIcm(BigDecimal.ZERO);    /** column 중_가산월수 : ctrAddMnthIcm */
//					infcRemt3100Vo.setCtrDupMnthIcm(BigDecimal.ZERO);    /** column 중_중복월수 : ctrDupMnthIcm */
//					infcRemt3100Vo.setCtrLogSvc(BigDecimal.ZERO);    /** column 중_근속연수 : ctrLogSvc */
				 	
				//	infcRemt3100Vo.setEndIcncDt(infcRemt2000Vo.getIcncDt());    /** column 종_입사일자 : endIcncDt */
					infcRemt3100Vo.setEndRkfcdDt(infcRemt2000Vo.getRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
					infcRemt3100Vo.setEndRsgtnDt(infcRemt2000Vo.getRetryDt());    /** column 종_퇴사일자 : endRsgtnDt */
					
                    //TODO 지급일자변경에 따른 원천년도 비교하여 처리하는 부분 추가 
					if (!infcRemt3100Vo.getBlggYrEndDt().equals(infcRemt3100Vo.getEndRsgtnDt())) {
						//SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy"); 
			            String strCalcSevePsnBlggYr = EgovDateUtil.getCurrentYearAsString(); //dateFormatGmt.format(DATE.getCurrentDate());
			            String strCalcSevePsnDt = strCalcSevePsnBlggYr.concat("0101");
			            
	                    if (strCalcSevePsnDt.compareTo(infcRemt2000Vo.getRkfcdDt()) > 0) {
	                    	infcRemt3100Vo.setBlggYrBgnnDt(strCalcSevePsnDt);    /** column 귀속년도시작일자 : blggYrBgnnDt */
	                    } else {
	                    	infcRemt3100Vo.setBlggYrBgnnDt(infcRemt2000Vo.getRkfcdDt());    /** column 귀속년도시작일자 : blggYrBgnnDt */
	                    }
	                    
	                    if (strCalcSevePsnDt.compareTo(infcRemt2000Vo.getRetryDt()) > 0) {
	                    	
	                    	infcRemt3100Vo.setBlggYrEndDt(infcRemt2000Vo.getSevePayPymtDt());    /** column 귀속년도종료일자 : blggYrEndDt */
	                    	infcRemt3100Vo.setCalcSevePsnBlggYrMnth(infcRemt2000Vo.getSevePayPymtDt().substring(0, 6));    /** column 귀속년월 : CalcSevePsnBlggYrMnth */
	                    } else {
	                    	infcRemt3100Vo.setBlggYrEndDt(infcRemt2000Vo.getRetryDt());    /** column 귀속년도종료일자 : blggYrEndDt */
	                    	infcRemt3100Vo.setCalcSevePsnBlggYrMnth(infcRemt2000Vo.getRetryDt().substring(0, 6));    /** column 귀속년월 : CalcSevePsnBlggYrMnth */
	                    } 
				  	 
					} 
					//infcRemt3100Vo.setBlggYrBgnnDt(infcRemt2000Vo.getBlggYrBgnnDt());    /** column 귀속년도시작일자 : blggYrBgnnDt */
					//infcRemt3100Vo.setBlggYrEndDt(infcRemt2000Vo.getBlggYrEndDt());    /** column 귀속년도종료일자 : blggYrEndDt */
					
					 //	infcRemt3100Vo.setCalcSevePsnBlggYrMnth(remt2000.getCalcSevePsnBlggYrMnth());    /** column 정산년월 : clutYrMnth */
					 infcRemt3100Vo.setEndPymtDt(infcRemt2000Vo.getSevePayPymtDt());    /** column 종_지급일자 : endPymtDt */
					
					infcRemt3100Vo.setEndLogSvcMnthIcm( infcRemt2000Vo.getTurtyDutyMnthNum());    /** column 종_근속월수 : endLogSvcMnthIcm */
					infcRemt3100Vo.setEndEepnMnth12Bfr(infcRemt2000Vo.getEepnMnthIcm2012Bfr());    /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
					infcRemt3100Vo.setEndEepnMnth13Aft(infcRemt2000Vo.getEepnMnthIcm2013Aft());    /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
					infcRemt3100Vo.setEndAddMnth12Bfr(infcRemt2000Vo.getAddMnthIcm2012Bfr());    /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
					infcRemt3100Vo.setEndAddMnth13Aft(infcRemt2000Vo.getAddMnthIcm2013Aft());    /** column 종_가산월수_2013이후 : endAddMnth13Aft */
					
//					infcRemt3100Vo.setEndEepnMnthIcm(BigDecimal.ZERO);    /** column 종_제외월수 : endEepnMnthIcm */
//					infcRemt3100Vo.setEndAddMnthIcm(BigDecimal.ZERO);    /** column 종_가산월수 : endAddMnthIcm */
//					infcRemt3100Vo.setEndDupMnthIcm(BigDecimal.ZERO);    /** column 종_중복월수 : endDupMnthIcm */
					infcRemt3100Vo.setEndLogSvcYrNum(infcRemt2000Vo.getTurtyDutyYrNum());    /** column 종_근속연수 : endLogSvcYrNum */
					
//					infcRemt3100Vo.setClutIcncDt("");    /** column 정산_입사일자 : clutIcncDt */
//					infcRemt3100Vo.setClutRkfcdDt("");    /** column 정산-기산일자 : clutRkfcdDt */
//					infcRemt3100Vo.setClutRsgtnDt("");    /** column 정산_퇴사일자 : clutRsgtnDt */
//					infcRemt3100Vo.setClutPymtDt("");    /** column 정산_지급일자 : clutPymtDt */
					infcRemt3100Vo.setClutLogSvcMnthIcm(infcRemt2000Vo.getTurtyDutyMnthNum());    /** column 정산_근속월수 : clutLogSvcMnthIcm */
//					infcRemt3100Vo.setClutEepnMnthIcm(BigDecimal.ZERO);    /** column 정산_제외월수 : clutEepnMnthIcm */
//					infcRemt3100Vo.setClutAddMnthIcm(BigDecimal.ZERO);    /** column 정산_가산월수 : clutAddMnthIcm */
//					infcRemt3100Vo.setClutDupMnthIcm(BigDecimal.ZERO);    /** column 정산_중복월수 : clutDupMnthIcm */
					infcRemt3100Vo.setClutLogSvcYrNum(infcRemt2000Vo.getTurtyDutyYrNum());    /** column 정산_근속연수 : clutLogSvcYrNum */
					
//					infcRemt3100Vo.setLogPpnl12befIcncDt("");    /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
//					infcRemt3100Vo.setLogPpnl12befRkfcdDt("");    /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
//					infcRemt3100Vo.setLogPpnl12befRsgtnDt("");    /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
//					infcRemt3100Vo.setLogPpnl12befPymtDt("");    /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
//					
//					infcRemt3100Vo.setLogPpnl12befLogMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
//					infcRemt3100Vo.setLogPpnl12befEepnMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
//					infcRemt3100Vo.setLogPpnl12befAddMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
//					infcRemt3100Vo.setLogPpnl12befDupMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
//					infcRemt3100Vo.setLogPpnl12befLogYrNum(BigDecimal.ZERO);    /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
//					
//					infcRemt3100Vo.setLogPpnl13afrIcncDt("");    /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
//					infcRemt3100Vo.setLogPpnl13afrRkfcdDt("");    /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
//					infcRemt3100Vo.setLogPpnl13afrRsgtnDt("");    /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
//					infcRemt3100Vo.setLogPpnl13afrPymtDt("");    /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
//					
//					
//					infcRemt3100Vo.setLogPpnl13afrLogMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
//					infcRemt3100Vo.setLogPpnl13afrEepnMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
//					infcRemt3100Vo.setLogPpnl13afrAddMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
//					infcRemt3100Vo.setLogPpnl13afrDupMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
//					infcRemt3100Vo.setLogPpnl13afrLogSvc(BigDecimal.ZERO);    /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
//					
//					infcRemt3100Vo.setRetryIncmCtrPymtSum(BigDecimal.ZERO);    /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
//					infcRemt3100Vo.setRetryIncmEndPymtSum(BigDecimal.ZERO);    /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
//					infcRemt3100Vo.setRetryIncmClutSum(BigDecimal.ZERO);    /** column 퇴직소득_정산금액 : retryIncmClutSum */
//					infcRemt3100Vo.setRetryFxrtDducClutSum(BigDecimal.ZERO);    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//					infcRemt3100Vo.setLogYrDducSum(BigDecimal.ZERO);    /** column 근속년수공제_정산금액 : logYrDducSum */
//					infcRemt3100Vo.setRetryTxtnStdClutSum(BigDecimal.ZERO);    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//					infcRemt3100Vo.setTat12befTxtnStdPpnlSum(BigDecimal.ZERO);    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//					infcRemt3100Vo.setTat12befYravgTxstdSum(BigDecimal.ZERO);    /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
//					infcRemt3100Vo.setTat12befCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
//					infcRemt3100Vo.setTat12befCvsnCalcAmnt(BigDecimal.ZERO);    /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
//					infcRemt3100Vo.setTat12befYrAvgCalcAmnt(BigDecimal.ZERO);    /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//					infcRemt3100Vo.setTat12befCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
//					infcRemt3100Vo.setTat12befAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
//					infcRemt3100Vo.setTat12befRegTgtTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
//					infcRemt3100Vo.setTat13afrTxstdPpnlSum(BigDecimal.ZERO);    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//					infcRemt3100Vo.setTat13afrYrAvgStdSum(BigDecimal.ZERO);    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
//					infcRemt3100Vo.setTat13afrCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//					infcRemt3100Vo.setTat13afrCvsnCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//					infcRemt3100Vo.setTat13afrYrAvgCalcAmnt(BigDecimal.ZERO);    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//					infcRemt3100Vo.setTat13afrCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
//					infcRemt3100Vo.setTat13afrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
//					infcRemt3100Vo.setTat13afrRegrstTgtSum(BigDecimal.ZERO);    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
//					infcRemt3100Vo.setTatAggrTxtnStdPpnlSum(BigDecimal.ZERO);    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//					infcRemt3100Vo.setTatAggrYrAvgTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
//					infcRemt3100Vo.setTatAggrCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//					infcRemt3100Vo.setTatAggrCvsnCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//					infcRemt3100Vo.setTatAggrYrAvgCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//					infcRemt3100Vo.setTatAggrCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
//					infcRemt3100Vo.setTatAggrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
//					infcRemt3100Vo.setTatAggrRegrstTgtTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
//					infcRemt3100Vo.setTalRegrstTgtTxAmnt(BigDecimal.ZERO);    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
//					infcRemt3100Vo.setTalAccuDepitAggrSum(BigDecimal.ZERO);    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
//					infcRemt3100Vo.setTalRetryPayQnty(BigDecimal.ZERO);    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
//					infcRemt3100Vo.setTalRetryIncmTxAmnt(BigDecimal.ZERO);    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
//					infcRemt3100Vo.setPymtRegTgtIncmTxQnty(BigDecimal.ZERO);    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//					infcRemt3100Vo.setPymtRegTgtRgonIncmQnty(BigDecimal.ZERO);    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//					infcRemt3100Vo.setPymtRegTgtFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//					infcRemt3100Vo.setPymtRegrstTgtAggrSum(BigDecimal.ZERO);    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//					infcRemt3100Vo.setPymtTalcIncmTxQnty(BigDecimal.ZERO);    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
//					infcRemt3100Vo.setPymtTalcRgonIncmTxQnty(BigDecimal.ZERO);    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
//					infcRemt3100Vo.setPymtTalcFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
//					infcRemt3100Vo.setPymtTxAllcAggrSum(BigDecimal.ZERO);    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
//					infcRemt3100Vo.setPymtSubtnIncmTxQnty(BigDecimal.ZERO);    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
//					infcRemt3100Vo.setPymtSubtnRgonIncmTxQnty(BigDecimal.ZERO);    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
//					infcRemt3100Vo.setPymtSubtnFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
//					infcRemt3100Vo.setPymtSubtnAggrSum(BigDecimal.ZERO);    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
					infcRemt3100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
					infcRemt3100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					infcRemt3100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
					infcRemt3100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
    
				 	remtPayrService.updateRemt3100(infcRemt3100Vo);
				 	 /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 종료 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
               
	  	  
	  	} catch (Exception ex) {
        ex.printStackTrace();   
   	   ShowMessageBM smBm = new ShowMessageBM();
   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
   	   smBm.setMenu("Remt");
   	   smBm.setPhase("[퇴직금수정]저장에러");
   	   smBm.setMessage(ex.getLocalizedMessage());
   	   smBm.setContent(ex.getMessage());
   	   bmResult.add(smBm);  
   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
   	 
      } 
	  	  
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");

	  	   
	  	  return  retval;
    }
  	    
    /**
     * 퇴직금 산정 버튼을 클릭하여 이에 따른 프로세서 처리 위한 구현부 
     * @param request
     * @param listRemt2000Vo
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcActivityOnPayrCalc(HttpServletRequest request, List<InfcPkgRemt2000VO> listRemt2000Vo)  throws Exception  {
    	
    	String method = calledClass + ".funcActivityOnPayrCalc";
    	  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	   
	  	 InfcPkgPayr0410VO  payr0410Vo = new InfcPkgPayr0410VO(); 
	  	 
	  	BigDecimal fndtnPayAggrSum = BigDecimal.ZERO;  //기본급여합계
	  	BigDecimal snryAllwAggrSum  = BigDecimal.ZERO;      //제수당합 
	  	BigDecimal aggrTotSum  = BigDecimal.ZERO;      //기본급 + 제수당 합계금액  
	  	BigDecimal welfSpdgAggrSum  = BigDecimal.ZERO;   //후생복지비 합계금액  
	  	BigDecimal marPubcWelfAmnt  = BigDecimal.ZERO;    //3개월간 후생복지비  
	  	BigDecimal marTotAmntWag = BigDecimal.ZERO;    //3개월간 총임금액 
	  	BigDecimal marTotAmntDays = BigDecimal.ZERO;    //3개월간 총일수 
	  	
	  	  try {
	  		  
	  		   
		  	   if  (remtPayrService == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               remtPayrService = (RetirementPayrService) wac.getBean("RetirementPayrService" ); 
	              
	            }
		  	   
		  	   
	  	     /*************************************급여산정시작*********************************************/
		  	  for (int iCnt01 = 0;iCnt01 < listRemt2000Vo.size();iCnt01++) {
		  		  
		  		  fndtnPayAggrSum = BigDecimal.ZERO;  //기본급여합계
			  	  snryAllwAggrSum  = BigDecimal.ZERO;      //제수당합 
			  	  aggrTotSum  = BigDecimal.ZERO;      //기본급 + 제수당 합계금액  
			  	  welfSpdgAggrSum  = BigDecimal.ZERO;   //후생복지비 합계금액  
			  	  marPubcWelfAmnt  = BigDecimal.ZERO;    //3개월간 후생복지비  
			  	  marTotAmntWag = BigDecimal.ZERO;    //3개월간 총임금액 
			  	  marTotAmntDays = BigDecimal.ZERO;    //3개월간 총일수   
				  	 
		  		InfcPkgRemt2000VO infcRemt2000Vo = new InfcPkgRemt2000VO(); 
		  		 
		  		infcRemt2000Vo = listRemt2000Vo.get(iCnt01);
		  		 
//		  		infcRemt2000Vo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		  		infcRemt2000Vo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		  		infcRemt2000Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//		  		infcRemt2000Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
 
		  		/**@@@@@@@@@@@@@@@@@@@@@@@대상자 등록정보 조회 급여산정  @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		  	 
		  		infcRemt2000Vo = remtPayrService.selectRemt2000(infcRemt2000Vo);
		  	 
		  	   if (MSFSharedUtils.paramNull(infcRemt2000Vo) ) {
             	 // BaseModel bm = new BaseModel();
             	   ShowMessageBM smBm = new ShowMessageBM();
             	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR); 
             	   smBm.setMenu("Remt");
             	   smBm.setPhase("[급여산정]급여산정오류");
             	   smBm.setMessage("데이터가존재하지않습니다.");
             	   smBm.setContent("SystemKey" + infcRemt2000Vo.getSystemkey());
             	   bmResult.add(smBm); 
                }    
		  		  
		  	   //무기계약직근로자 인경우 
	           if (ExtermsProps.getProps("EMYMT_DIVCD_01").equals(infcRemt2000Vo.getEmymtDivCd())) {
	        	   /**=========================무기계약직======================================*/
	        	   /**
	        	    * 1. 급여구간을 구해온다 값을 데이타 베이스에 저장한다.
	        	    * 2. 급여 구간의 근무실적값을 가져와 값을 적재한다.
	        	    * 3. 근속년수에 따른 payr0410 에서 해당하는 사용자의 단가표 값을 가져온다.
	        	    
	        	    * 4. 해당하는 기간의 월에 지급된 항목을 리스트로 가져와 각각 값을 구하여
	        	    *    remt2200 테이블에 인서트 한다.  
	        	    * 
	        	    *    구간을 구해온다
						2. 구간에 처음에서 월별 근태 정보를을 
						구해온다.
						3. 각 달에 지급된 항목을 가져온다 위와 합해하나의 쿼리로
						5. 각달에 근속년수를 . 이전달 근속년수를 구한다 그에따른 값을넘어온 근속년수까지 보내서 단가를 가져온다 가져온다. 
						함수를 호출하여 조건에 따른 값을 계산한다.
						각 개별로. 저장한다.
						
						단가표 구할때 근속년수에따른 값을 전부 구해온다.
						
						복지는 개월수 선언 하고 개월수에 해당하는 기간의 월을 가져와 구간을 생성하고 구간 카군트를 하고 값을 구해온다. 지급카운트를 개월수로
						
						마감처리 구분자로ㅠ검색기능  추가 

	        	    *    ^^^3개월간의 근속년수에 따른 호봉등급은 이전달의 근속년수 데이터를 가지고 와야함 이부분을 구하는 함수가 하나 있어서 그에 따른 
	        	    *    비교 루틴을 통해서 다른 경우 호출하여 사용함. ^^^  
	        	    */
	        	   //1.구간의 값을 가지고 온다.   /이전달.현달의 근속년수 값가져오기 
	        	   List lstDateTerm = remtPayrService.selectDateTermList(infcRemt2000Vo);
	        	   Iterator<Map<String, Object>> iter = lstDateTerm.iterator(); 
	        	   Boolean chkRemt2100 = true; 
		           ArrayList<String>  logSvcYrNumCdArr = new ArrayList<String>();
	        	   
		            while ( iter.hasNext() ) {
		            	 
		            	InfcPkgRemt2100VO infcRemt2100Vo = new InfcPkgRemt2100VO(); 
		                Map<String, Object> map = (Map<String, Object>) iter.next();
	        	  //for (int iCnt02 = 0; iCnt02 < lstDateTerm.size();iCnt02++) { 
	        		   
			        	 infcRemt2100Vo.setDpobCd(MSFSharedUtils.allowNulls(map.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			        	 infcRemt2100Vo.setSystemkey(MSFSharedUtils.allowNulls(map.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			        	 infcRemt2100Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			        	 infcRemt2100Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			        	 infcRemt2100Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(map.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			        	 infcRemt2100Vo.setPayPymtBgnnDt(MSFSharedUtils.allowNulls(map.get("payPymtBgnnDt")));    /** column 급여지급시작일자 : payPymtBgnnDt */
			        	 infcRemt2100Vo.setPayPymtEndDt(MSFSharedUtils.allowNulls(map.get("payPymtEndDt")));    /** column 급여지급종료일자 : payPymtEndDt */
			        	 infcRemt2100Vo.setPymtNumDys(new BigDecimal(MSFSharedUtils.allowNulls(map.get("pymtNumDys"))));    /** column 지급일수 : pymtNumDys */
			        	 infcRemt2100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
			        	 infcRemt2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
			        	 infcRemt2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
			        	 infcRemt2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
			        	 
			        	 
			        	 if (chkRemt2100) {
			        		 remtPayrService.deleteRemt0100CalcRemt2100(infcRemt2100Vo);
			        		 chkRemt2100 = false; 
			        	 } 
			        	 
			        	 remtPayrService.insertRemt2100(infcRemt2100Vo);
			        	 
			        	 logSvcYrNumCdArr.add(MSFSharedUtils.allowNulls(map.get("logSvcYrNumCd")));
			        	 logSvcYrNumCdArr.add(MSFSharedUtils.allowNulls(map.get("beLogSvcYrNumCd")));
			        	 
			        	 marTotAmntDays = marTotAmntDays.add(new BigDecimal(MSFSharedUtils.allowNulls(map.get("pymtNumDys")))); //3개월간 총 일수 
	        	   } 
		            
		            List<InfcPkgPayr0410VO> lstInfcPayr0410Vo =  new ArrayList<InfcPkgPayr0410VO>();
		            
		            InfcPkgRemt2000SrhVO infcRemt2000SrhVo = new InfcPkgRemt2000SrhVO(); 
		            
		            infcRemt2000SrhVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
		            infcRemt2000SrhVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		            infcRemt2000SrhVo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		            infcRemt2000SrhVo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
		            infcRemt2000SrhVo.setEmymtDivCd(infcRemt2000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
		            infcRemt2000SrhVo.setDeptCd(infcRemt2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
		            infcRemt2000SrhVo.setTypOccuCd(infcRemt2000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
		            infcRemt2000SrhVo.setPyspGrdeCd(infcRemt2000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
		            infcRemt2000SrhVo.setDtilOccuInttnCd(infcRemt2000Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
		            infcRemt2000SrhVo.setBusinCd(infcRemt2000Vo.getBusinCd());    /** column 사업코드 : businCd */
				   
		            infcRemt2000SrhVo.setLogSvcYrNumCd(infcRemt2000Vo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
		            infcRemt2000SrhVo.setLogSvcYrNumCdArr(logSvcYrNumCdArr);    /** column 근속년수코드 : logSvcYrNumCdArr */
				   
		            infcRemt2000SrhVo.setIcncDt(infcRemt2000Vo.getIcncDt());    /** column 입사일자 : icncDt */
		            infcRemt2000SrhVo.setRkfcdDt(infcRemt2000Vo.getRkfcdDt());    /** column 기산일자 : rkfcdDt */
		            infcRemt2000SrhVo.setRetryDt(infcRemt2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */
		            infcRemt2000SrhVo.setSevePayPymtDt(infcRemt2000Vo.getSevePayPymtDt());    /** column 퇴직금지급일자 : sevePayPymtDt */
		            
	        	   //2. 단가표에 따른 이전달, 현달 구해온 단가표 전체 가져오기 로직 추가 
		            lstInfcPayr0410Vo  =  remtPayrService.selectRemt0100ToPayr4100List(infcRemt2000SrhVo) ;
	        	   
		            if (lstInfcPayr0410Vo.size() <= 0) {
		             	 // BaseModel bm = new BaseModel();
		             	   ShowMessageBM smBm = new ShowMessageBM();
		             	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR); 
		             	   smBm.setMenu("Remt");
		             	   smBm.setPhase("[급여산정]단가표오류");
		             	   smBm.setMessage("데이터가존재하지않습니다.");
		             	   smBm.setContent("SystemKey" + infcRemt2000Vo.getSystemkey());
		             	   bmResult.add(smBm); 
		            }    
	        	     
	        	   //3.구간루프돌면서 해당기간의 지급된 급여항목등을 구해서 가져온다. 
	        	   //3.1 해당구간의 사용자 급여지급항목에 따른 근무실적 및 급여항목정보 가져오기
		           

                    InfcPkgRemt2200VO infcRemt2200Del = new InfcPkgRemt2200VO();
                    infcRemt2200Del.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    infcRemt2200Del.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                    infcRemt2200Del.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
                    infcRemt2200Del.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
          		
                    remtPayrService.deleteRemt0100CalcRemt2200(infcRemt2200Del); 
                    
		            Iterator<Map<String, Object>> iter01 = lstDateTerm.iterator(); 
		            //구간의 값  
			         while ( iter01.hasNext() ) {
			            	
	              	  
	                  Map<String, Object> mapDateTerm = (Map<String, Object>) iter01.next();
	                  
                      /**-------------------------------------근무실적 시작--------------------------------------------------*/
	                  //근무실적데이타 
	                  Remt0100DlgnVO remt0100DlgnVo = new Remt0100DlgnVO();
	                  
	                  remt0100DlgnVo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                  remt0100DlgnVo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */ 
	                  remt0100DlgnVo.setPayPymtBgnnDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtBgnnDt")));    /** column 급여지급시작일자 : payPymtBgnnDt */
	                  remt0100DlgnVo.setPayPymtEndDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtEndDt")));    /** column 급여지급종료일자 : payPymtEndDt */
			        	 
	                  
	                  remt0100DlgnVo  = remtPayrService.selectRemt0100Dlgn(remt0100DlgnVo);
	                  
	                  /**-------------------------------------근무실적 종료--------------------------------------------------*/
	                
	                  
	                  /**-------------------------------------급여항목 시작--------------------------------------------------*/
	                  //여러건
                      RemtPayr0302SrhVO  remtPayr0302SrhVo = new RemtPayr0302SrhVO();
	                  
	                  remtPayr0302SrhVo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                  remtPayr0302SrhVo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */ 
	                  remtPayr0302SrhVo.setPayPymtBgnnDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtBgnnDt")));    /** column 급여지급시작일자 : payPymtBgnnDt */
	                  remtPayr0302SrhVo.setPayPymtEndDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtEndDt")));    /** column 급여지급종료일자 : payPymtEndDt */
	                  
	               
	                  List lstRemtPayr0302 = remtPayrService.selectRemt0100ToPayr0302List(remtPayr0302SrhVo);
	                   
		                  
	                  /**-------------------------------------급여항목 종료--------------------------------------------------*/
	                   boolean chkItemCd = false;
	                  
	                   //3.1.1 각항목에 대해 단가표 루트 돌면서 찾아 해당하는 값을 넣음
	                  //월지급급여항목
	                    Iterator<Map<String, Object>> iter02 = lstRemtPayr0302.iterator(); 
			            //구간의 값  
				         while ( iter02.hasNext() ) { 
				        	      chkItemCd = true;
				        	      InfcPkgRemt2200VO infcRemt2200Vo = new InfcPkgRemt2200VO();
				                  
				                  Map<String, Object> mapRemtPayr0302 = (Map<String, Object>) iter02.next(); 
				                  
				                  
			                	  //단가표항목
			                	  for (int iCnt03 = 0;iCnt03 <lstInfcPayr0410Vo.size();iCnt03++) {
			                	  //TODO 연간후생복지비항목만 나중에 쿼리로 따로 분리해서 가져오는 구 
			                		  InfcPkgPayr0410VO infcPayr0410Vo =  new  InfcPkgPayr0410VO();
			                		  infcPayr0410Vo = lstInfcPayr0410Vo.get(iCnt03);
			                		
					                	  if (mapRemtPayr0302.get("payItemCd").equals(infcPayr0410Vo.getPayrImcd())) {
				                             //단가표 와 지급공제항목이 같으면 처리 하고 
					                		  
					                		  // 수당 인서트  
					                          if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(infcPayr0410Vo.getPayrImcd()) 
					                        		  && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
					                           //기본급처리 루틴 근무일수 /실근무일수가 다른경우처리 루틴 추가    
					                       	   //기본급  
					                            BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급
					                            BigDecimal dayPayAmt = BigDecimal.ZERO; //기본급일액
					                             
					                            BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
					                             
					                            BigDecimal abnceNumDysAmt  = BigDecimal.ZERO; //결근금액 
					                           
					                      	  	infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
					                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
					                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
					                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
					                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
					                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
					                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
					                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
					                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
					                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
						                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
						                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */		 
					                               
//					                               if ((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {//결근일수 
//					                               	
//					                               	 if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(remt0100DlgnVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())))) > 0)) {
//					                                        
//					                                        mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//					                                       
//					                                       // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
//					                                       // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
//					                                     
//					                                        dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//					                                       		 .multiply((new BigDecimal(remt0100DlgnVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(remt0100DlgnVo.getDilnlazAbnceDutyRcgtnDys()))
//					                                       				 .add((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//					                                        
//					                                    }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(remt0100DlgnVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())))) == 0)) {
//					                                      
//					                                        dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//					                                        
//					                                    } else {
//					                                        
//					                                        dayPaySum = BigDecimal.ZERO;
//					                                    }
//					                                   //결근이 존재하는 경우 결근 빼기 
//					                                  //  payCalculationVo.getDilnlazAbnceNumDys()   /** column 근태_결근일수 : dilnlazAbnceNumDys */
//					                                   abnceNumDysAmt = (new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys()))
//					                                                   .multiply(payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal(ExtermsProps.PAYR_BASS_WKTM_201401_01)));  // USALY_AMNT_HRWG_QNTY 시급통상임금 
//					                                   
//					                               } else {
					                               	
					                               	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))) > 0)) {
					                                         
					                                         mothPayAmt = (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
					                                        
					                                        // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
					                                        // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
					                                      
					                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
					                                       		  .multiply((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))).setScale(-1, 1);
					                                         
					                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))) == 0)) {
					                                       
					                                         dayPaySum = (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
					                                         
					                                     } else { 
					                                         
					                                         dayPaySum = BigDecimal.ZERO;
					                                     }
					                              // }
					                               
					                               fndtnPayAggrSum = fndtnPayAggrSum.add(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));  //기본급여합
					                               
					                               infcRemt2200Vo.setPymtSum(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));    /** column 지급금액 : pymtSum */ 
							                  	 
					                               remtPayrService.insertRemt2200(infcRemt2200Vo);  
					                              
//					                          }  else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0410.getPayrImcd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
//					                              //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
//					                              payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
//					                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//					                              payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
//					                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//					                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//					                              payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
//					                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//					                              payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */  
//					                              payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
//					                              payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//					                              payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//					                             
//				//	                                                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//				//	                                                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//				//	                                                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//				//	                                                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//				//	                                                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//				//	                                                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
//					                             
//					                              // B0050001    B005    0001    과세
//					                              // B0050002    B005    0002    비과세
//					                              // B0050003    B005    0003    부분과세
//					                               
//					                              if ("B0050002".equals(payr0410.getTxtnDivCd())) {
//					                                  payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//					                                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//					                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
//					                              } else  if ("B0050001".equals(payr0410.getTxtnDivCd())) {
//					                                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//					                                  payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//					                                  tpFreeDtyTotAmnt = BigDecimal.ZERO;
//					                              } else  if ("B0050003".equals(payr0410.getTxtnDivCd())) {
//					                                  payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//					                                  payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//					                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
//					                              } else {
//					                           	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//					                                  payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//					                                  tpFreeDtyTotAmnt = BigDecimal.ZERO;
//					                              }
//					                         
//					                              
//					                               tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
//					                               tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
//					                                
//					                               
//					                                 if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
//					                                     payCalculationService.insertPayr0302(payr0302Vo);  
//					                                  } 
//					                          
					                          } else if ((ExtermsProps.getProps("PYMT_ITEM_04").equals(infcPayr0410Vo.getPayrImcd()) || ExtermsProps.getProps("PYMT_ITEM_25").equals(infcPayr0410Vo.getPayrImcd()))
					                        		  && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
					                            //선임인력수당 -직채수당인경우 처리 루틴  PYMT_ITEM_25        
					                            //직책별 수당  //기타수당을 반장수당으로 대체 해서 처리 할것. 반장등수당처리부분 
//					                               payr0460Vo = new InfcPkgPayr0460VO();
//				
//					                               payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
//					                               payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//					                               payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
//					                               payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
//					                               payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
//					                            
//					                               payr0460Vo = payCalculationService.selectPayr0460(payr0460Vo);
//					                              
//					                              if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
					                                  
					                        	    BigDecimal mothPayAmt = BigDecimal.ZERO; //정상금액 
						                            BigDecimal dayPaySum = BigDecimal.ZERO;  // 일액계산 
						                              
					                        		infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
						                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
						                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
						                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
						                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
						                  		  	infcRemt2200Vo.setPymtSum(new BigDecimal("50000"));    /** TODO 수정 column 지급금액 : pymtSum */ 
						                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
							                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
							                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
							                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							                  		
							                  		
							                  	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))) > 0)) {
				                                         
				                                         mothPayAmt =  infcRemt2200Vo.getPymtSum();//(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
				                                        
				                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
				                                       		  .multiply((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))).setScale(-1, 1);
				                                         
				                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))) == 0)) {
				                                       
				                                         dayPaySum = infcRemt2200Vo.getPymtSum(); // (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
				                                         
				                                     } else { 
				                                         
				                                         dayPaySum = BigDecimal.ZERO;
				                                     }
							                  		
							                    	infcRemt2200Vo.setPymtSum(dayPaySum);
							                    	
							                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
					                               
							                  		remtPayrService.insertRemt2200(infcRemt2200Vo);  
					                                  
					                            //  } 
					                                     
					                          } else if (ExtermsProps.getProps("PYMT_ITEM_50").equals(infcPayr0410Vo.getPayrImcd()) && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
					                            // 근속가산금   
					                        	  infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
						                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
						                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
						                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
						                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
						                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
						                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
							                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
							                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
							                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
					                              
					                             // tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
					                             // tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
					                             // tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
					                               
							                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
							                  		
							                  		remtPayrService.insertRemt2200(infcRemt2200Vo);  
					                                
				
					                          } else if (ExtermsProps.getProps("PYMT_ITEM_51").equals(infcPayr0410Vo.getPayrImcd()) && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
					                            //정근수당
					                              
					                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
						                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
						                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
						                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
						                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
						                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
						                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
							                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
							                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
							                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
					                              
					                             // tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
					                             // tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
					                             // tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
					                               
							                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
							                  		
							                  		remtPayrService.insertRemt2200(infcRemt2200Vo);  
					                                
					                              
					                              
					                          } else if (ExtermsProps.getProps("PYMT_ITEM_52").equals(infcPayr0410Vo.getPayrImcd()) && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
					                            //장기근속수당 
					                        	  infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
						                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
						                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
						                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
						                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
						                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
						                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
							                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
							                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
							                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
					                              
					                             // tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
					                             // tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
					                             // tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
					                               
							                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
							                  		
							                  		remtPayrService.insertRemt2200(infcRemt2200Vo);  
					                                
					                              
					                          } else { 
							                  		  //TODO 12월인경우 처리를 위한 루틴 으로 수정필요 
			                                          if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(infcPayr0410Vo.getPayrImcd())
			                                        		  && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
			                                               
			                                        	  infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
								                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
								                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
								                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
									                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
									                  		
			                                             if (new BigDecimal(remt0100DlgnVo.getDilnlazTotTmRstDutyTm()).compareTo(BigDecimal.ZERO) > 0) {
			                                                   //시간외근무  
										                  		
			                                                     BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
			                                                    		 //infcPayr0410Vo.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getBefUcstSum() : (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                                   
//			                                                     if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//			                                                   	  ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
//			                                                     } 
			                                                     
			                                                     BigDecimal totTmSum = BigDecimal.ZERO;
			                                                     
			                                                     totTmSum = (new BigDecimal(remt0100DlgnVo.getDilnlazTotTmRstDutyTm())).multiply(ucstSum);  //시간외근무
			                                                     
			                                                 	 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazTotTmRstDutyTm());
			                                                     infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtSum */ 
			                                                     
			                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
			 							                  		
			 							                  		 remtPayrService.insertRemt2200(infcRemt2200Vo);  
			                                                      
			                                               } else {
			                                            	   infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazTotTmRstDutyTm());
			                                                     infcRemt2200Vo.setPymtSum(BigDecimal.ZERO);   /** column 지급금액 : pymtSum */ 
			                                            	     remtPayrService.insertRemt2200(infcRemt2200Vo);
			                                               }
			                                               
			                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(infcPayr0410Vo.getPayrImcd())
			                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
			                                           // 토요근무수당   --일수산정C9410700
			                                        	 
			                                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
								                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
								                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
								                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
									                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
									                  		
			                                           
			                                            if (new BigDecimal(remt0100DlgnVo.getDilnlazSatDutyNumDys()).compareTo(BigDecimal.ZERO) > 0) {
			                                           	 
			                                                 BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
			                                                		  //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//			                                                 if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//			                                               	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//			                                                 } 
			                                                 BigDecimal totTmSum = BigDecimal.ZERO;
			                                                 
			                                                 totTmSum = (new BigDecimal(remt0100DlgnVo.getDilnlazSatDutyNumDys())).multiply(ucstSum);  //토요근무수당 
			                                                 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazSatDutyNumDys());  
			                                                 infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtSum */ 
		                                                     
		                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
		 							                  		
		 							                  		 remtPayrService.insertRemt2200(infcRemt2200Vo);   
			                                             
			                                             } else {
			                                            	 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazSatDutyNumDys());  
			                                                 infcRemt2200Vo.setPymtSum(BigDecimal.ZERO);   /** column 지급금액 : pymtSum */ 
		                                            	     remtPayrService.insertRemt2200(infcRemt2200Vo);
		                                                 }
			                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(infcPayr0410Vo.getPayrImcd())
			                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
			                                              // 야간수당       -- 시간산정C9410300
			                                        	 
			                                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
								                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
								                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
								                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
									                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
									                  		
			                                             if (new BigDecimal(remt0100DlgnVo.getDilnlazTotNtotTm()).compareTo(BigDecimal.ZERO) > 0) {
			                                           	  
			                                                 BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
//			                                                		 payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//			                                                 if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//			                                               	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//			                                                 } 
			                                                 BigDecimal totTmSum = BigDecimal.ZERO;
			                                                 
			                                                 totTmSum = (new BigDecimal(remt0100DlgnVo.getDilnlazTotNtotTm())).multiply(ucstSum);  //시간외근무
			                                                  
			                                             	 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazTotNtotTm()); 
			                                                 infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtDducSum */
			                                                
			                                                 snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
			 							                  		
		 							                  		 remtPayrService.insertRemt2200(infcRemt2200Vo);     
			                                             } else {
			                                            	 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazTotNtotTm()); 
			                                                 infcRemt2200Vo.setPymtSum(BigDecimal.ZERO);   /** column 지급금액 : pymtDducSum */
		                                            	     remtPayrService.insertRemt2200(infcRemt2200Vo);
		                                                 }
			                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(infcPayr0410Vo.getPayrImcd())
			                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
			                                           // 휴일수당        -- 일수 C9410200
			                                        	 
			                                        	 infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
								                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
								                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
								                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
									                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
									                  		
			                                             if (MSFSharedUtils.paramNotNull(remt0100DlgnVo.getDilnlazPubcHodyDutyNumDys())) {
			                                           	  
			                                                 if (new BigDecimal(remt0100DlgnVo.getDilnlazPubcHodyDutyNumDys()).compareTo(BigDecimal.ZERO) > 0) {
			                                               	  
			                                                     BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum(); 
			                                                 
			                                                    //     payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			                                                    // if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			                                                   	//  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			                                                    // }
			                                                     
			                                                     BigDecimal totTmSum = BigDecimal.ZERO;
			                                                     
			                                                     totTmSum = (new BigDecimal(remt0100DlgnVo.getDilnlazPubcHodyDutyNumDys())).multiply(ucstSum);  //토요근무수당 
			                                                     
			                                                     infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazPubcHodyDutyNumDys()); 
			                                                     infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtDducSum */
			                                                     
			                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
				 							                  		
			 							                  		 remtPayrService.insertRemt2200(infcRemt2200Vo);      
			                                                 } else {
			                                                	 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazPubcHodyDutyNumDys());  
				                                                 infcRemt2200Vo.setPymtSum(new BigDecimal(MSFSharedUtils.defaultNulls(mapRemtPayr0302.get("pymtDducSum"),"0")));   /** column 지급금액 : pymtDducSum */
			                                            	     remtPayrService.insertRemt2200(infcRemt2200Vo);
			                                                 }
			                                             }   
			                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(infcPayr0410Vo.getPayrImcd())
			                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
			                                             // 유급휴일수당  -- 일수 산정 C9415000
			                                        	 infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
								                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
								                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
								                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
									                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
									                  		
			                                             if (new BigDecimal(remt0100DlgnVo.getDilnlazPaidPubcHodyNum()).compareTo(BigDecimal.ZERO) > 0) {
			                                                
			                                                 BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
//			                                                		 payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
//			                                                 if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
//			                                               	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
//			                                                 } 
			                                                 BigDecimal totTmSum = BigDecimal.ZERO;
			                                                 
			                                                 totTmSum = (new BigDecimal(remt0100DlgnVo.getDilnlazPaidPubcHodyNum())).multiply(ucstSum);  //토요근무수당 
			                                                 
			                                                 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazPaidPubcHodyNum()); 
			                                                 infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtDducSum */
			                                                 
			                                                 snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
			 							                  		
		 							                  		 remtPayrService.insertRemt2200(infcRemt2200Vo);       
			                                             } else {
			                                            	 infcRemt2200Vo.setSevePayCmpttnTm(remt0100DlgnVo.getDilnlazPaidPubcHodyNum()); 
			                                                 infcRemt2200Vo.setPymtSum(BigDecimal.ZERO);   /** column 지급금액 : pymtDducSum */
		                                            	     remtPayrService.insertRemt2200(infcRemt2200Vo);
		                                                 }
			                                         } else   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(infcPayr0410Vo.getPayrImcd())
			                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
			                                               //PAY_EMYMT_PYMT_18 = "C9080100";    // 정액급식비
			                                        	 
			                                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
								                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
								                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
								                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
									                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
									                  		
			                                       	         BigDecimal dayPaySum = BigDecimal.ZERO; 
			                                                 BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
			                                             
//			                                                 if ((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
//			                                                     //결근은 정액급식비 을 제외 급여모자랄시  
//			                                               	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
//			                                                          
//			                                                   	   dayPaySum = (ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
//			                                                   			     .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
//			                                                   			    		 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
//			                                                         
//			                                                     }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
//			                                                       
//			                                                         dayPaySum = ucstSum;
//			                                                         
//			                                                     } else {
//			                                                         
//			                                                         dayPaySum = BigDecimal.ZERO;
//			                                                     } 
//			                                                 } else { 
			                                                     if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))) > 0)) {
			                                                          
			                                                   	   dayPaySum = (ucstSum.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP)).multiply((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))
			                                                   	   ).setScale(-1, 1);
			                                                         
			                                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"))) == 0)) {
			                                                       
			                                                         dayPaySum = ucstSum;
			                                                         
			                                                     } else {
			                                                         
			                                                         dayPaySum = BigDecimal.ZERO;
			                                                     } 
			                                                // }
			                                                     infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));   
			                                                     infcRemt2200Vo.setPymtSum(dayPaySum);   /** column 지급공제금액 : pymtDducSum */
			                                                 
			                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
				 							                  		
			 							                  		 remtPayrService.insertRemt2200(infcRemt2200Vo);       
			                                                
			                                         } else {
			                                        	 // TODO 전부 속해 있지 않은 경우 처리 로직 
			                                        	 
			                                         } 
					                                    
					                          }    
				                             break;
					                	  }  else {
					                		   
					                		  if (ExtermsProps.getProps("PYMT_ITEM_25").equals(mapRemtPayr0302.get("payItemCd")) 
					                				  && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd()) && chkItemCd) {
					                			    //반장수당인경우 처리 로직 수정 차후 
					                			    //선임인력수당 -직채수당인경우 처리 루틴  PYMT_ITEM_25        
						                            //직책별 수당  //기타수당을 반장수당으로 대체 해서 처리 할것. 반장등수당처리부분 
//						                               payr0460Vo = new InfcPkgPayr0460VO();
//					
//						                               payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
//						                               payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//						                               payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
//						                               payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
//						                               payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
//						                            
//						                               payr0460Vo = payCalculationService.selectPayr0460(payr0460Vo);
//						                              
//						                              if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
						                                  
						                        	    BigDecimal mothPayAmt = BigDecimal.ZERO; //정상금액 
							                            BigDecimal dayPaySum = BigDecimal.ZERO;  // 일액계산 
							                              
						                        		infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
							                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
							                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
							                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
							                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
							                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
							                  		  	infcRemt2200Vo.setPymtSum(new BigDecimal("50000"));    /** TODO 수정 column 지급금액 : pymtSum */ 
							                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
								                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
								                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
								                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
								                  		
								                  		
								                  	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))) > 0)) {
					                                         
					                                         mothPayAmt =  infcRemt2200Vo.getPymtSum();//(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
					                                        
					                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
					                                       		  .multiply((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))).setScale(-1, 1);
					                                         
					                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0")))) == 0)) {
					                                       
					                                         dayPaySum = infcRemt2200Vo.getPymtSum(); // (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
					                                         
					                                     } else { 
					                                         
					                                         dayPaySum = BigDecimal.ZERO;
					                                     }
								                  		
								                    	infcRemt2200Vo.setPymtSum(dayPaySum);
								                    	
								                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
						                               
								                  		remtPayrService.insertRemt2200(infcRemt2200Vo);  
								                  		chkItemCd = false; 
					                		  }
					                		   
					                	  }
	                	     }  
	                    }
				         
	                  
			         }
			         /**-----------------------후생복지비 시작 ----------------------------------------------------------*/ 
				       //3.1.3 후생복지비로 등록된 항목에 대해서는 실제지급한 항목으로 구해야 하므로 해당하는 db로 관리해야함 일단은 박음.
				         
				         // TODO 3.1.2 함수호출해서 동일한 값을 처리하도록 하는 루틴 하여 계산후 저장
				           //명절휴가비 - 소급적용시 때문에 1년안에 금액을 단가표에서 계산 함. 
				          //TODO 호봉승급이 중간에 들어간 경우 계산처리 ---소급계산에서 처리한 상세 내역을 가지고 와야함.
				                	 
				                	  
				                	  List<RemtWfep0100VO> lstRemtWfep0100Vo = new ArrayList<RemtWfep0100VO>();
				                	  RemtPayr0302SrhVO  remtPayr0302SrhVo = new RemtPayr0302SrhVO();
					                  
					                  remtPayr0302SrhVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
					                  remtPayr0302SrhVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
					                  remtPayr0302SrhVo.setRetryDt(infcRemt2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */ 
					                  
					                  lstRemtWfep0100Vo = remtPayrService.selectRemtWfep0100List(remtPayr0302SrhVo);     
				                	  
					                  for (int iCnt04 = 0; iCnt04 < lstRemtWfep0100Vo.size();iCnt04++) { 
					        		   
					                	  RemtWfep0100VO remtWfep0100Vo = new RemtWfep0100VO();
					                	   InfcPkgRemt2200VO infcRemt2200Vo = new InfcPkgRemt2200VO();
					                	  
					                	  remtWfep0100Vo = lstRemtWfep0100Vo.get(iCnt04);
					                	  
					                	  infcRemt2200Vo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			                  		  	  infcRemt2200Vo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                  		  	  infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			                  		  	  infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			                  		      infcRemt2200Vo.setSevePayDtlPatrNum(BigDecimal.ZERO);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			                  		  	  infcRemt2200Vo.setPayItemCd(remtWfep0100Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
			                  		  	  infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020020);    /** column 수당그룹코드 : extpyGrpCd */
			                  		  	  infcRemt2200Vo.setSevePayCmpttnTm(remtWfep0100Vo.getItemMonths());    /** column 퇴직금산정시간 : sevePayCmpttnTm */
			                  		  	  infcRemt2200Vo.setPymtSum(remtWfep0100Vo.getPymtSum());    /** column 지급금액 : pymtSum */ 
			                  		      infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
				                  		  infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				                  		  infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
				                  		  infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
					                  		
				                  		  welfSpdgAggrSum  = welfSpdgAggrSum.add(infcRemt2200Vo.getPymtSum());   //후생복지비 합계금액  
				                  		  
				                  		  remtPayrService.insertRemt2200(infcRemt2200Vo);  
					        	      } 
				         
				       /**-----------------------후생복지비 종료 ----------------------------------------------------------*/ 
		        	   
					   /**+++++++++++++++++++++++++++++++++++++퇴직금산정 기본 업데이트 시작 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
					                //1일평균 임금  

						        	aggrTotSum = fndtnPayAggrSum.add(snryAllwAggrSum) ;      //기본급 + 제수당 합계금액  
					                marPubcWelfAmnt = welfSpdgAggrSum.divide(new BigDecimal("12"),3, RoundingMode.DOWN).multiply(new BigDecimal("3")).setScale(-1, RoundingMode.DOWN);//3개월간 후생복지비  
					          	  	 
					                
					                marTotAmntWag =  aggrTotSum.add(marPubcWelfAmnt); //3개월간 총임금액 
					                        
					                  
					             	infcRemt2000Vo.setFndtnPayAggrSumSum(fndtnPayAggrSum);    /** column 기본급여합계금액 : fndtnPayAggrSumSum */
					    		  	infcRemt2000Vo.setSnryAllwAggrSum(snryAllwAggrSum);    /** column 제수당합계금액 : snryAllwAggrSum */
					    		  	infcRemt2000Vo.setWelfWelfSpdgAggrSum(welfSpdgAggrSum);    /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
					    		  	infcRemt2000Vo.setMarPubcWelfAmnt(marPubcWelfAmnt);    /** column 3월간후생복지비 : marPubcWelfAmnt */
					    		  	infcRemt2000Vo.setMarTotAmntWag(marTotAmntWag);    /** column 3월간총임금액 : marTotAmntWag */
					    		  	infcRemt2000Vo.setDayAvgAmntWag(marTotAmntWag.divide(marTotAmntDays, 10, RoundingMode.DOWN));    /** column 1일평균임금액 : dayAvgAmntWag */
					                  
					    		  	
					    		    infcRemt2000Vo.setSevePayCmpttnSum(((infcRemt2000Vo.getDayAvgAmntWag().multiply(new BigDecimal("30")))
					    		    		                   .multiply((infcRemt2000Vo.getTotLogSvcNumDys().divide(new BigDecimal("365"), 10, RoundingMode.DOWN))))
					    		    		                   .setScale(-1, RoundingMode.DOWN));    /** column 퇴직금산정금액 : sevePayCmpttnSum */
					                   
					    			if (infcRemt2000Vo.getSevePayAddRate().compareTo(BigDecimal.ZERO) > 0) {
					    				
					    				BigDecimal sevepayAddRate = BigDecimal.ZERO;
					    				
					    				sevepayAddRate = infcRemt2000Vo.getSevePayAddRate().divide(new BigDecimal("100"));
					    				infcRemt2000Vo.setSevePayAddApptnSum(infcRemt2000Vo.getSevePayCmpttnSum().multiply(sevepayAddRate).setScale(-1, RoundingMode.UP));    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
					    				
					    				//infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
						    		  	//infcRemt2000Vo.setSevePayAddRate(remtPsnl0100Vo.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
						    		  	 
					    				
					    			} else {
					    				if (infcRemt2000Vo.getSevePayAddSum().compareTo(BigDecimal.ZERO) > 0) {
					    					
					    					//infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
					    					infcRemt2000Vo.setSevePayAddApptnSum(infcRemt2000Vo.getSevePayCmpttnSum().add(infcRemt2000Vo.getSevePayAddSum()));    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
						    				
					    				}
					    			}
					    		  
					    		    if ("Y".equals(infcRemt2000Vo.getAmcrrClutInsnYn())) {
					    		    	//TODO 군경력은 금액의 1.5를 곱해서 지급 확인 할것 설정정보...
					    		      //infcRemt2000Vo.setAmcrrLogSvcNumDys(remtPsnl0100Vo.getAmcrrLogSvcNumDys());    /** column 군경력근무일수 : amcrrLogSvcNumDys */
                                        BigDecimal sevePayAddApptnSum = BigDecimal.ZERO;
                                        sevePayAddApptnSum = (infcRemt2000Vo.getDayAvgAmntWag().multiply(new BigDecimal("30")))
		    		    		                             .multiply((infcRemt2000Vo.getAmcrrLogSvcNumDys().divide(new BigDecimal("365"), 10, RoundingMode.DOWN))) ;
					    			 
					    				infcRemt2000Vo.setAmcrrAddApptnSum(sevePayAddApptnSum.multiply(new BigDecimal("1.5")).setScale(-1, RoundingMode.DOWN));    /** column 군경력가산적용금액 : amcrrAddApptnSum */
					    				  
					    		    } 
					    		    
					    		    
					    		    
					    			infcRemt2000Vo.setSevePayPymtSum(infcRemt2000Vo.getSevePayCmpttnSum().add(infcRemt2000Vo.getSevePayAddApptnSum())
					    					                       .add(infcRemt2000Vo.getAmcrrAddApptnSum()));    /** column 퇴직금지급액 : sevePayPymtSum */
					    			
					    		  	infcRemt2000Vo.setSevePayCmpttnFreeDtySum(BigDecimal.ZERO);    /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
					    		  	
					    		  	infcRemt2000Vo.setSevePayCmpttnTxtnSum(infcRemt2000Vo.getSevePayPymtSum());    /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
					    		  	
					    		  	
					    		  	//infcRemt2000Vo.setSevePayPymtDducSum(dducSum);    /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
					    		  	
					    		  	//infcRemt2000Vo.setSevePayTurtyPymtSum(infcRemt2000Vo.getSevePayPymtSum().subtract(dducSum));    /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */	    
					    		     
					    		  	remtPayrService.updateRemt2000(infcRemt2000Vo);
					    		  	
					    		  	/**+++++++++++++++++++++++++++++++++++++퇴직정산 메서드 호출부 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/        
					    		  	
					    		  	BigDecimal dducSum = BigDecimal.ZERO;
					    		  	
					    		  	InfcPkgRemt3100VO remt3100TgtVo = new InfcPkgRemt3100VO();
					    		  	
					    		    /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
						  	        
					    		  	remt3100TgtVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
					    		  	remt3100TgtVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
					    		  	remt3100TgtVo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
					    		  	remt3100TgtVo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								 	
//									infcRemt3100Vo.setDeptCd(infcRemt2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
//									infcRemt3100Vo.setHanNm(infcRemt2000Vo.getNm());    /** column 한글성명 : hanNm */
//									infcRemt3100Vo.setResnRegnNum(remtPsnl0100Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//									infcRemt3100Vo.setAimenrEcteYn("N");    /** column 소득자임원여부 : aimenrEcteYn */
//									infcRemt3100Vo.setFixPayJnDt("");    /** column 확정급여형가입일자 : fixPayJnDt */
//									infcRemt3100Vo.setSevePay20111231Sum(BigDecimal.ZERO);    /** column 퇴직금_20111231금액 : sevePay20111231Sum */
//									infcRemt3100Vo.setFrgnrDivCd(remtPsnl0100Vo.getFrgnrDivCd());    /** column 외국인구분코드 : frgnrDivCd */
//									infcRemt3100Vo.setRidnSeptYn("Y");    /** column 거주구분여부 : ridnSeptYn */
//									infcRemt3100Vo.setRidnCd("");    /** column 거주지국코드 : ridnCd */
//									infcRemt3100Vo.setRidnNm("");    /** column 거주지국명 : ridnNm */
									//infcRemt3100Vo.setRetryReasCd(infcRemt2000Vo.getRetryReasCd());    /** column 퇴직사유코드 : retryReasCd */
 
									
//									infcRemt3100Vo.setCtrBusoprRgstnNum("");    /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
//									infcRemt3100Vo.setCtrPaeWorkNm("");    /** column 중_근무처명 : ctrPaeWorkNm */
									
//									infcRemt3100Vo.setCtrRetryPayQnty(BigDecimal.ZERO);    /** column 중_퇴직급여액 : ctrRetryPayQnty */
//									infcRemt3100Vo.setCtrFreeDtyRetryPayQnty(BigDecimal.ZERO);    /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
//									infcRemt3100Vo.setCtrTxtnTgtRetryPayQnty(BigDecimal.ZERO);    /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
									
					    		  	//TODO 귀속년월관련 처리 여부 확인후 처리 
					    		  //infcRemt3100Vo.setBlggYrBgnnDt(infcRemt2000Vo.getBlggYrBgnnDt());    /** column 귀속년도시작일자 : blggYrBgnnDt */
									//infcRemt3100Vo.setBlggYrEndDt(infcRemt2000Vo.getBlggYrEndDt());    /** column 귀속년도종료일자 : blggYrEndDt */
									// remt3100TgtVo.setCalcSevePsnBlggYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
								 
					    		  	
									//TODO 사업장정보에서 가져옴.
									//infcRemt3100Vo.setEndBusoprRgstnNum(infcRemt2000Vo.getEndBusoprRgstnNum());    /** column 종_사업자등록번호 : endBusoprRgstnNum */
									//infcRemt3100Vo.setEndPaeWorkNm(infcRemt2000Vo.getEndPaeWorkNm());    /** column 종_근무처명 : endPaeWorkNm */
									
					    		  	remt3100TgtVo.setEndRetryPayQnty(infcRemt2000Vo.getSevePayPymtSum());    /** column 종_퇴직급여액 : endRetryPayQnty */
					    		  	remt3100TgtVo.setEndFreeDtyRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnFreeDtySum());    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
					    		  	remt3100TgtVo.setEndTxtnTgtRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnTxtnSum());    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
					    		  	  
					    		  	 
					    		  	remt3100TgtVo.setClutRetryPayQnty(infcRemt2000Vo.getSevePayPymtSum());    /** column 정산_퇴직급여액 : clutRetryPayQnty */
					    		  	remt3100TgtVo.setClutFreeDtyRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnFreeDtySum());    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
					    		  	remt3100TgtVo.setClutTxtnTgtRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnTxtnSum());    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
								
//									infcRemt3100Vo.setCtrIcncDt("");    /** column 중_입사일자 : ctrIcncDt */
//									infcRemt3100Vo.setCtrRkfcdDt("");    /** column 중_기산일자 : ctrRkfcdDt */
//									infcRemt3100Vo.setCtrRsgtnDt("");    /** column 중_퇴사일자 : ctrRsgtnDt */
//									infcRemt3100Vo.setCtrPymtDt("");    /** column 중_지급일자 : ctrPymtDt */
//									infcRemt3100Vo.setCtrLogSvcMnthIcm(BigDecimal.ZERO);    /** column 중_근속월수 : ctrLogSvcMnthIcm */
//									infcRemt3100Vo.setCtrEepnMnth12Bfr(BigDecimal.ZERO);    /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
//									infcRemt3100Vo.setCtrEepnMnth13Aft(BigDecimal.ZERO);    /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
//									infcRemt3100Vo.setCtrAddMnth12Bfr(BigDecimal.ZERO);    /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
//									infcRemt3100Vo.setCtrAddMnth13Aft(BigDecimal.ZERO);    /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
//									infcRemt3100Vo.setCtrEepnMnthIcm(BigDecimal.ZERO);    /** column 중_제외월수 : ctrEepnMnthIcm */
//									infcRemt3100Vo.setCtrAddMnthIcm(BigDecimal.ZERO);    /** column 중_가산월수 : ctrAddMnthIcm */
//									infcRemt3100Vo.setCtrDupMnthIcm(BigDecimal.ZERO);    /** column 중_중복월수 : ctrDupMnthIcm */
//									infcRemt3100Vo.setCtrLogSvc(BigDecimal.ZERO);    /** column 중_근속연수 : ctrLogSvc */
								 	
								//	infcRemt3100Vo.setEndIcncDt(infcRemt2000Vo.getIcncDt());    /** column 종_입사일자 : endIcncDt */
//									infcRemt3100Vo.setEndRkfcdDt(infcRemt2000Vo.getRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
//									infcRemt3100Vo.setEndRsgtnDt(infcRemt2000Vo.getRetryDt());    /** column 종_퇴사일자 : endRsgtnDt */
//									infcRemt3100Vo.setEndPymtDt(infcRemt2000Vo.getSevePayPymtDt());    /** column 종_지급일자 : endPymtDt */
//									infcRemt3100Vo.setEndLogSvcMnthIcm( infcRemt2000Vo.getLogSvcMnthIcm());    /** column 종_근속월수 : endLogSvcMnthIcm */
//									infcRemt3100Vo.setEndEepnMnth12Bfr(infcRemt2000Vo.getEepnMnthIcm2012Bfr());    /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
//									infcRemt3100Vo.setEndEepnMnth13Aft(infcRemt2000Vo.getEepnMnthIcm2013Aft());    /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
//									infcRemt3100Vo.setEndAddMnth12Bfr(infcRemt2000Vo.getAddMnthIcm2012Bfr());    /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
//									infcRemt3100Vo.setEndAddMnth13Aft(infcRemt2000Vo.getAddMnthIcm2013Aft());    /** column 종_가산월수_2013이후 : endAddMnth13Aft */
									
//									infcRemt3100Vo.setEndEepnMnthIcm(BigDecimal.ZERO);    /** column 종_제외월수 : endEepnMnthIcm */
//									infcRemt3100Vo.setEndAddMnthIcm(BigDecimal.ZERO);    /** column 종_가산월수 : endAddMnthIcm */
//									infcRemt3100Vo.setEndDupMnthIcm(BigDecimal.ZERO);    /** column 종_중복월수 : endDupMnthIcm */
//									infcRemt3100Vo.setEndLogSvcYrNum(infcRemt2000Vo.getTurtyDutyYrNum());    /** column 종_근속연수 : endLogSvcYrNum */
									
//									infcRemt3100Vo.setClutIcncDt("");    /** column 정산_입사일자 : clutIcncDt */
//									infcRemt3100Vo.setClutRkfcdDt("");    /** column 정산-기산일자 : clutRkfcdDt */
//									infcRemt3100Vo.setClutRsgtnDt("");    /** column 정산_퇴사일자 : clutRsgtnDt */
//									infcRemt3100Vo.setClutPymtDt("");    /** column 정산_지급일자 : clutPymtDt */
//									infcRemt3100Vo.setClutLogSvcMnthIcm(infcRemt2000Vo.getLogSvcMnthIcm());    /** column 정산_근속월수 : clutLogSvcMnthIcm */
//									infcRemt3100Vo.setClutEepnMnthIcm(BigDecimal.ZERO);    /** column 정산_제외월수 : clutEepnMnthIcm */
//									infcRemt3100Vo.setClutAddMnthIcm(BigDecimal.ZERO);    /** column 정산_가산월수 : clutAddMnthIcm */
//									infcRemt3100Vo.setClutDupMnthIcm(BigDecimal.ZERO);    /** column 정산_중복월수 : clutDupMnthIcm */
//									infcRemt3100Vo.setClutLogSvcYrNum(infcRemt2000Vo.getTurtyDutyYrNum());    /** column 정산_근속연수 : clutLogSvcYrNum */
									
//									infcRemt3100Vo.setLogPpnl12befIcncDt("");    /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
//									infcRemt3100Vo.setLogPpnl12befRkfcdDt("");    /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
//									infcRemt3100Vo.setLogPpnl12befRsgtnDt("");    /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
//									infcRemt3100Vo.setLogPpnl12befPymtDt("");    /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
//									
//									infcRemt3100Vo.setLogPpnl12befLogMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
//									infcRemt3100Vo.setLogPpnl12befEepnMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
//									infcRemt3100Vo.setLogPpnl12befAddMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
//									infcRemt3100Vo.setLogPpnl12befDupMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
//									infcRemt3100Vo.setLogPpnl12befLogYrNum(BigDecimal.ZERO);    /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
//									
//									infcRemt3100Vo.setLogPpnl13afrIcncDt("");    /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
//									infcRemt3100Vo.setLogPpnl13afrRkfcdDt("");    /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
//									infcRemt3100Vo.setLogPpnl13afrRsgtnDt("");    /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
//									infcRemt3100Vo.setLogPpnl13afrPymtDt("");    /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
//									
//									
//									infcRemt3100Vo.setLogPpnl13afrLogMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
//									infcRemt3100Vo.setLogPpnl13afrEepnMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
//									infcRemt3100Vo.setLogPpnl13afrAddMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
//									infcRemt3100Vo.setLogPpnl13afrDupMnthIcm(BigDecimal.ZERO);    /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
//									infcRemt3100Vo.setLogPpnl13afrLogSvc(BigDecimal.ZERO);    /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
//									
//									infcRemt3100Vo.setRetryIncmCtrPymtSum(BigDecimal.ZERO);    /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
//									infcRemt3100Vo.setRetryIncmEndPymtSum(BigDecimal.ZERO);    /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
//									infcRemt3100Vo.setRetryIncmClutSum(BigDecimal.ZERO);    /** column 퇴직소득_정산금액 : retryIncmClutSum */
//									infcRemt3100Vo.setRetryFxrtDducClutSum(BigDecimal.ZERO);    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//									infcRemt3100Vo.setLogYrDducSum(BigDecimal.ZERO);    /** column 근속년수공제_정산금액 : logYrDducSum */
//									infcRemt3100Vo.setRetryTxtnStdClutSum(BigDecimal.ZERO);    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//									infcRemt3100Vo.setTat12befTxtnStdPpnlSum(BigDecimal.ZERO);    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//									infcRemt3100Vo.setTat12befYravgTxstdSum(BigDecimal.ZERO);    /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
//									infcRemt3100Vo.setTat12befCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
//									infcRemt3100Vo.setTat12befCvsnCalcAmnt(BigDecimal.ZERO);    /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
//									infcRemt3100Vo.setTat12befYrAvgCalcAmnt(BigDecimal.ZERO);    /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//									infcRemt3100Vo.setTat12befCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
//									infcRemt3100Vo.setTat12befAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
//									infcRemt3100Vo.setTat12befRegTgtTxAmnt(BigDecimal.ZERO);    /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
//									infcRemt3100Vo.setTat13afrTxstdPpnlSum(BigDecimal.ZERO);    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//									infcRemt3100Vo.setTat13afrYrAvgStdSum(BigDecimal.ZERO);    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
//									infcRemt3100Vo.setTat13afrCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//									infcRemt3100Vo.setTat13afrCvsnCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//									infcRemt3100Vo.setTat13afrYrAvgCalcAmnt(BigDecimal.ZERO);    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//									infcRemt3100Vo.setTat13afrCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
//									infcRemt3100Vo.setTat13afrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
//									infcRemt3100Vo.setTat13afrRegrstTgtSum(BigDecimal.ZERO);    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
//									infcRemt3100Vo.setTatAggrTxtnStdPpnlSum(BigDecimal.ZERO);    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//									infcRemt3100Vo.setTatAggrYrAvgTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
//									infcRemt3100Vo.setTatAggrCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//									infcRemt3100Vo.setTatAggrCvsnCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//									infcRemt3100Vo.setTatAggrYrAvgCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//									infcRemt3100Vo.setTatAggrCalcTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
//									infcRemt3100Vo.setTatAggrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
//									infcRemt3100Vo.setTatAggrRegrstTgtTxAmnt(BigDecimal.ZERO);    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
//									infcRemt3100Vo.setTalRegrstTgtTxAmnt(BigDecimal.ZERO);    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
//									infcRemt3100Vo.setTalAccuDepitAggrSum(BigDecimal.ZERO);    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
//									infcRemt3100Vo.setTalRetryPayQnty(BigDecimal.ZERO);    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
//									infcRemt3100Vo.setTalRetryIncmTxAmnt(BigDecimal.ZERO);    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
//									infcRemt3100Vo.setPymtRegTgtIncmTxQnty(BigDecimal.ZERO);    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//									infcRemt3100Vo.setPymtRegTgtRgonIncmQnty(BigDecimal.ZERO);    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//									infcRemt3100Vo.setPymtRegTgtFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//									infcRemt3100Vo.setPymtRegrstTgtAggrSum(BigDecimal.ZERO);    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//									infcRemt3100Vo.setPymtTalcIncmTxQnty(BigDecimal.ZERO);    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
//									infcRemt3100Vo.setPymtTalcRgonIncmTxQnty(BigDecimal.ZERO);    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
//									infcRemt3100Vo.setPymtTalcFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
//									infcRemt3100Vo.setPymtTxAllcAggrSum(BigDecimal.ZERO);    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
//									infcRemt3100Vo.setPymtSubtnIncmTxQnty(BigDecimal.ZERO);    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
//									infcRemt3100Vo.setPymtSubtnRgonIncmTxQnty(BigDecimal.ZERO);    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
//									infcRemt3100Vo.setPymtSubtnFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
//									infcRemt3100Vo.setPymtSubtnAggrSum(BigDecimal.ZERO);    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
					    		  	remt3100TgtVo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
					    		  	remt3100TgtVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					    		  	remt3100TgtVo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
					    		  	remt3100TgtVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				    
								 	remtPayrService.updateRemt3100Remt2000Data(remt3100TgtVo);
								 	 /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 종료 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
					    		  	 
					    		  	dducSum = funcRemtTxCalc(request,  remt3100TgtVo); 
					    		  	
					    		  	/**+++++++++++++++++++++++++++++++++++++퇴직정산 메서드 호출부 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/         
					    		  	 
					   /**+++++++++++++++++++++++++++++++++++++퇴직금산정 기본 업데이트 종료 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/                  
					                  
			       
	           } else {
	        	   //TODO 무기계약직 마무리 후 적용 할것 9월말까지 
	        	   /**=========================기간제근로자=====================================*/ 
	        	   
	           } 
		  		  
		   }
		  	/*************************************급여산정종료*********************************************/ 
	  	  
	  	} catch (Exception ex) {
        ex.printStackTrace();   
   	   ShowMessageBM smBm = new ShowMessageBM();
   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
   	   smBm.setMenu("Remt");
   	   smBm.setPhase("[퇴직금수정]저장에러");
   	   smBm.setMessage(ex.getLocalizedMessage());
   	   smBm.setContent(ex.getMessage());
   	   bmResult.add(smBm);  
   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
   	 
      } 
	  	  
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D");
	  	   
	  	  return  retval;
    }
  	    
    
    /**
     * 급여내역에 따른 퇴직금재정산 처리부 
     * @param request
     * @param listRemt2000Vo
     * @return
     * @throws Exception
     */
    private Long funcActivityOnUpdateRemt0100ToPayrCalc(HttpServletRequest request, List<InfcPkgRemt2200VO> listRemt2200Vo)  throws Exception  {
    	
    	Long retval = 0L; 
    	String method = calledClass + ".funcActivityOnUpdateRemt0100ToPayrCalc";
	      
	  	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	   
	  	InfcPkgPayr0410VO  payr0410Vo = new InfcPkgPayr0410VO(); 
	  	InfcPkgRemt2000VO infcRemt2000Vo = new InfcPkgRemt2000VO(); 
	  	
	  	BigDecimal fndtnPayAggrSum = BigDecimal.ZERO;  //기본급여합계
	  	BigDecimal snryAllwAggrSum  = BigDecimal.ZERO;      //제수당합 
	  	BigDecimal aggrTotSum  = BigDecimal.ZERO;      //기본급 + 제수당 합계금액  
	  	BigDecimal welfSpdgAggrSum  = BigDecimal.ZERO;   //후생복지비 합계금액  
	  	BigDecimal marPubcWelfAmnt  = BigDecimal.ZERO;    //3개월간 후생복지비  
	  	BigDecimal marTotAmntWag = BigDecimal.ZERO;    //3개월간 총임금액 
	  	BigDecimal marTotAmntDays = BigDecimal.ZERO;    //3개월간 총일수 
	  	
	  	  try {
	  		  
	  		   
		  	   if  (remtPayrService == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               remtPayrService = (RetirementPayrService) wac.getBean("RetirementPayrService" ); 
	              
	            } 
		  	   
	  	     /*************************************급여산정시작*********************************************/
		  	  
		  		  infcRemt2000Vo.setDpobCd( listRemt2200Vo.get(0).getDpobCd());    /** column 사업장코드 : dpobCd */
		  		  infcRemt2000Vo.setSystemkey(listRemt2200Vo.get(0).getSystemkey());    /** column SYSTEMKEY : systemkey */
		  		  infcRemt2000Vo.setCalcSevePayPsnDivCd(listRemt2200Vo.get(0).getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  		  infcRemt2000Vo.setClutYrMnth(listRemt2200Vo.get(0).getClutYrMnth());    /** column 정산년월 : clutYrMnth */
	 
			  	  /**@@@@@@@@@@@@@@@@@@@@@@@대상자 등록정보 조회 급여산정  @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			  	 
			  		infcRemt2000Vo = remtPayrService.selectRemt2000(infcRemt2000Vo);
			  	 
//			  	   if (MSFSharedUtils.paramNull(infcRemt2000Vo) ) {
//	             	 // BaseModel bm = new BaseModel();
//	             	   ShowMessageBM smBm = new ShowMessageBM();
//	             	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR); 
//	             	   smBm.setMenu("Remt");
//	             	   smBm.setPhase("[급여산정]급여산정오류");
//	             	   smBm.setMessage("데이터가존재하지않습니다.");
//	             	   smBm.setContent("SystemKey" + infcRemt2000Vo.getSystemkey());
//	             	   bmResult.add(smBm); 
//	                } 
			  	   
			  	      fndtnPayAggrSum = BigDecimal.ZERO;  //기본급여합계
				  	  snryAllwAggrSum  = BigDecimal.ZERO;      //제수당합 
				  	  aggrTotSum  = BigDecimal.ZERO;      //기본급 + 제수당 합계금액  
				  	  welfSpdgAggrSum  = BigDecimal.ZERO;   //후생복지비 합계금액  
				  	  marPubcWelfAmnt  = BigDecimal.ZERO;    //3개월간 후생복지비  
				  	  marTotAmntWag = BigDecimal.ZERO;    //3개월간 총임금액 
				  	  marTotAmntDays = BigDecimal.ZERO;    //3개월간 총일수   
				  	  
			  		 //무기계약직근로자 인경우 
			      if (ExtermsProps.getProps("EMYMT_DIVCD_01").equals(infcRemt2000Vo.getEmymtDivCd())) {
			    	  

				        /**=========================무기계약직======================================*/
				    	   //1.구간의 값을 가지고 온다.   /이전달.현달의 근속년수 값가져오기 
			        	   List lstDateTerm = remtPayrService.selectDateTermList(infcRemt2000Vo);
			        	   Iterator<Map<String, Object>> iter = lstDateTerm.iterator(); 
			        	   Boolean chkRemt2100 = true; 
				        	 
				           ArrayList<String>  logSvcYrNumCdArr = new ArrayList<String>();
			        	   
				            while ( iter.hasNext() ) {
				            	
				            	InfcPkgRemt2100VO infcRemt2100Vo = new InfcPkgRemt2100VO(); 
				                Map<String, Object> map = (Map<String, Object>) iter.next();
			        	  //for (int iCnt02 = 0; iCnt02 < lstDateTerm.size();iCnt02++) { 
			        		     
					        	 infcRemt2100Vo.setDpobCd(MSFSharedUtils.allowNulls(map.get("dpobCd")));    /** column 사업장코드 : dpobCd */
					        	 infcRemt2100Vo.setSystemkey(MSFSharedUtils.allowNulls(map.get("systemkey")));    /** column SYSTEMKEY : systemkey */
					        	 infcRemt2100Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
					        	 infcRemt2100Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
					        	 infcRemt2100Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(map.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
					        	 infcRemt2100Vo.setPayPymtBgnnDt(MSFSharedUtils.allowNulls(map.get("payPymtBgnnDt")));    /** column 급여지급시작일자 : payPymtBgnnDt */
					        	 infcRemt2100Vo.setPayPymtEndDt(MSFSharedUtils.allowNulls(map.get("payPymtEndDt")));    /** column 급여지급종료일자 : payPymtEndDt */
					        	 infcRemt2100Vo.setPymtNumDys(new BigDecimal(MSFSharedUtils.allowNulls(map.get("pymtNumDys"))));    /** column 지급일수 : pymtNumDys */
					        	 infcRemt2100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
					        	 infcRemt2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					        	 infcRemt2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
					        	 infcRemt2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					        	 
					        	 if (chkRemt2100) {
					        		 remtPayrService.deleteRemt0100CalcRemt2100(infcRemt2100Vo);
					        		 chkRemt2100 = false; 
					        	 }
					        	 
					        	 remtPayrService.insertRemt2100(infcRemt2100Vo);
					        	 
					        	 logSvcYrNumCdArr.add(MSFSharedUtils.allowNulls(map.get("logSvcYrNumCd")));
					        	 logSvcYrNumCdArr.add(MSFSharedUtils.allowNulls(map.get("beLogSvcYrNumCd")));
					        	 
					        	 marTotAmntDays = marTotAmntDays.add(new BigDecimal(MSFSharedUtils.allowNulls(map.get("pymtNumDys")))); //3개월간 총 일수 
			        	   } 
				            
				            List<InfcPkgPayr0410VO> lstInfcPayr0410Vo =  new ArrayList<InfcPkgPayr0410VO>();
				            
				            InfcPkgRemt2000SrhVO infcRemt2000SrhVo = new InfcPkgRemt2000SrhVO(); 
				            
				            infcRemt2000SrhVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
				            infcRemt2000SrhVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
				            infcRemt2000SrhVo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				            infcRemt2000SrhVo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				            infcRemt2000SrhVo.setEmymtDivCd(infcRemt2000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
				            infcRemt2000SrhVo.setDeptCd(infcRemt2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
				            infcRemt2000SrhVo.setTypOccuCd(infcRemt2000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
				            infcRemt2000SrhVo.setPyspGrdeCd(infcRemt2000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
				            infcRemt2000SrhVo.setDtilOccuInttnCd(infcRemt2000Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
				            infcRemt2000SrhVo.setBusinCd(infcRemt2000Vo.getBusinCd());    /** column 사업코드 : businCd */
						   
				            infcRemt2000SrhVo.setLogSvcYrNumCd(infcRemt2000Vo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
				            infcRemt2000SrhVo.setLogSvcYrNumCdArr(logSvcYrNumCdArr);    /** column 근속년수코드 : logSvcYrNumCdArr */
						   
				            infcRemt2000SrhVo.setIcncDt(infcRemt2000Vo.getIcncDt());    /** column 입사일자 : icncDt */
				            infcRemt2000SrhVo.setRkfcdDt(infcRemt2000Vo.getRkfcdDt());    /** column 기산일자 : rkfcdDt */
				            infcRemt2000SrhVo.setRetryDt(infcRemt2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */
				            infcRemt2000SrhVo.setSevePayPymtDt(infcRemt2000Vo.getSevePayPymtDt());    /** column 퇴직금지급일자 : sevePayPymtDt */
				            
			        	    //2. 단가표에 따른  현달 구해온 단가표 전체 가져오기 로직 추가 
				            lstInfcPayr0410Vo  =  remtPayrService.selectRemt0100ToPayr4100List(infcRemt2000SrhVo) ;
			        	    
	//			            if (lstInfcPayr0410Vo.size() <= 0) {
	//			             	 // BaseModel bm = new BaseModel();
	//			             	   ShowMessageBM smBm = new ShowMessageBM();
	//			             	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR); 
	//			             	   smBm.setMenu("Remt");
	//			             	   smBm.setPhase("[급여산정]단가표오류");
	//			             	   smBm.setMessage("데이터가존재하지않습니다.");
	//			             	   smBm.setContent("SystemKey" + infcRemt2000Vo.getSystemkey());
	//			             	   bmResult.add(smBm); 
	//			            }    
				            
				           boolean chkItemCd = false; 
			    	  //시간/일수 수정에 따른 재계산 
				  	    for (int iCnt01 = 0;iCnt01 < listRemt2200Vo.size();iCnt01++) {
				  		   
						  	  //퇴직금산정 - 지급항목 업데이트 및 각 단계별 처리 
				  	    	  InfcPkgRemt2200VO infcRemt2200Vo = new InfcPkgRemt2200VO(); 
					  		  InfcPkgRemt2200VO infcRemt2200InVo = new InfcPkgRemt2200VO(); 
					  		  infcRemt2200InVo = listRemt2200Vo.get(iCnt01);  
					  		  
					  		  BeanUtils.copyProperties(infcRemt2200Vo, infcRemt2200InVo);
					  		  chkItemCd = true;
					  		
					  		  //4번째 데이타가 없는 경우 스킾하기 위해 추가 
					  		  if (new BigDecimal("4").equals(infcRemt2200InVo.getSevePayDtlPatrNum())) {
					  			 if (infcRemt2200InVo.getPymtSum().compareTo(BigDecimal.ZERO) <= 0) {
					  				 continue;
					  			 }
					  		  } 
				  		  
						       
						            Iterator<Map<String, Object>> iter01 = lstDateTerm.iterator(); 
						            //구간의 값  
							         while ( iter01.hasNext() ) {
							        	  
							        	 Map<String, Object> mapDateTerm = (Map<String, Object>) iter01.next();
							        	 
							        	 if (new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))).compareTo(infcRemt2200InVo.getSevePayDtlPatrNum()) == 0) {
						                   
					                      /**--TODO 수정 -----------------------------------근무실적 시작--------------------------------------------------*/
						                  //근무실적데이타 
						                  Remt0100DlgnVO remt0100DlgnVo = new Remt0100DlgnVO();
						                  
						                  remt0100DlgnVo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						                  remt0100DlgnVo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */ 
						                  remt0100DlgnVo.setPayPymtBgnnDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtBgnnDt")));    /** column 급여지급시작일자 : payPymtBgnnDt */
						                  remt0100DlgnVo.setPayPymtEndDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtEndDt")));    /** column 급여지급종료일자 : payPymtEndDt */
								        	 
						                  
						                  remt0100DlgnVo  = remtPayrService.selectRemt0100Dlgn(remt0100DlgnVo);
						                  
						                  /**----------------------------------------------근무실적 종료--------------------------------------------------*/
						                
						                  
						                  /**-------------------------------------급여항목 시작--------------------------------------------------*/
						                  //여러건
			//		                      RemtPayr0302SrhVO  remtPayr0302SrhVo = new RemtPayr0302SrhVO();
			//			                  
			//			                  remtPayr0302SrhVo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//			                  remtPayr0302SrhVo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */ 
			//			                  remtPayr0302SrhVo.setPayPymtBgnnDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtBgnnDt")));    /** column 급여지급시작일자 : payPymtBgnnDt */
			//			                  remtPayr0302SrhVo.setPayPymtEndDt(MSFSharedUtils.allowNulls(mapDateTerm.get("payPymtEndDt")));    /** column 급여지급종료일자 : payPymtEndDt */
			//			                  
			//			                  List lstRemtPayr0302 = remtPayrService.selectRemt0100ToPayr0302List(remtPayr0302SrhVo); 
							                  
						                  /**-------------------------------------급여항목 종료--------------------------------------------------*/
						                  
						                  
						                   //3.1.1 각항목에 대해 단가표 루트 돌면서 찾아 해당하는 값을 넣음
						                  //월지급급여항목
						               //     Iterator<Map<String, Object>> iter02 = lstRemtPayr0302.iterator(); 
								            //구간의 값  
									    //     while ( iter01.hasNext() ) { 
									                  
									      //  	      InfcRemt2200VO infcRemt2200Vo = new InfcRemt2200VO();
									                  
									        //          Map<String, Object> mapRemtPayr0302 = (Map<String, Object>) iter02.next();
									                  
								           //단가표항목
								            for (int iCnt03 = 0;iCnt03 <lstInfcPayr0410Vo.size();iCnt03++) {
								                	  //TODO 연간후생복지비항목만 나중에 쿼리로 따로 분리해서 가져오는 구 
								                		  InfcPkgPayr0410VO infcPayr0410Vo =  new  InfcPkgPayr0410VO();
								                		  infcPayr0410Vo = lstInfcPayr0410Vo.get(iCnt03);
								                		
										               	  if (infcRemt2200InVo.getPayItemCd().equals(infcPayr0410Vo.getPayrImcd())) {
									                             //단가표 와 지급공제항목이 같으면 처리 하고 
										                		  
										               		     if (BigDecimal.ZERO.equals(infcRemt2200InVo.getSevePayDtlPatrNum())) {
										               		    	 
										               		     } else
										                		  // 수당 인서트  
										                          if (ExtermsProps.getProps("PAY_EMYMT_PYMT_19").equals(infcPayr0410Vo.getPayrImcd())
										                        		  && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
										                           //기본급처리 루틴 근무일수 /실근무일수가 다른경우처리 루틴 추가    
										                       	   //기본급  
										                            BigDecimal mothPayAmt = BigDecimal.ZERO; //기본급
										                            BigDecimal dayPayAmt = BigDecimal.ZERO; //기본급일액
										                             
										                            BigDecimal dayPaySum = BigDecimal.ZERO; //기본급일액계산 
										                             
										                            BigDecimal abnceNumDysAmt  = BigDecimal.ZERO; //결근금액 
										                           
			//							                      	  	infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//							                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//							                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//							                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//							                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//							                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//							                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//							                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
										                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
										                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
											                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
											                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
											                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */		 
										                               
			//							                               if ((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {//결근일수 
			//							                               	
			//							                               	 if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(remt0100DlgnVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())))) > 0)) {
			//							                                        
			//							                                        mothPayAmt = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			//							                                       
			//							                                       // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
			//							                                       // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
			//							                                     
			//							                                        dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			//							                                       		 .multiply((new BigDecimal(remt0100DlgnVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(remt0100DlgnVo.getDilnlazAbnceDutyRcgtnDys()))
			//							                                       				 .add((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
			//							                                        
			//							                                    }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(remt0100DlgnVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())))) == 0)) {
			//							                                      
			//							                                        dayPaySum = (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			//							                                        
			//							                                    } else {
			//							                                        
			//							                                        dayPaySum = BigDecimal.ZERO;
			//							                                    }
			//							                                   //결근이 존재하는 경우 결근 빼기 
			//							                                  //  payCalculationVo.getDilnlazAbnceNumDys()   /** column 근태_결근일수 : dilnlazAbnceNumDys */
			//							                                   abnceNumDysAmt = (new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys()))
			//							                                                   .multiply(payr0410.getUsalyAmntHrwgQnty().multiply(new BigDecimal(ExtermsProps.PAYR_BASS_WKTM_201401_01)));  // USALY_AMNT_HRWG_QNTY 시급통상임금 
			//							                                   
			//							                               } else {
										                               	
										                               	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))) > 0)) {
										                                         
										                                         mothPayAmt = (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
										                                        
										                                        // dayPayAmt =  (mothPayAmt.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3)).setScale(-1, 1);
										                                        // dayPaySum = dayPayAmt.multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))));
										                                      
										                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
										                                       		  .multiply((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))).setScale(-1, 1);
										                                         
										                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))) == 0)) {
										                                       
										                                         dayPaySum = (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
										                                         
										                                     } else { 
										                                         
										                                         dayPaySum = BigDecimal.ZERO;
										                                     }
										                              // }
										                               
										                               fndtnPayAggrSum = fndtnPayAggrSum.add(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));  //기본급여합
										                               if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
										                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
										                               } else {
										                            	   infcRemt2200Vo.setPymtSum(dayPaySum.subtract(abnceNumDysAmt).setScale(-1, 1));    /** column 지급금액 : pymtSum */ 
										                               } 
												                  	 
										                               remtPayrService.updateRemt2200(infcRemt2200Vo);  
										                              
			//							                          }  else if (ExtermsProps.getProps("PYMT_ITEM_02").equals(payr0410.getPayrImcd()) && (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0)) {
			//							                              //학비보조수당 C9060100 TODO : 신입인경우은 3월에 지급함...예외사항임. 
			//							                              payr0302Vo.setDpobCd(payr0410.getDpobCd());    /** column 사업장코드 : dpobCd */
			//							                              payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
			//							                              payr0302Vo.setPayCd(payr0410.getPayCd());    /** column 급여구분코드 : payCd */
			//							                              payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
			//							                              payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//							                              payr0302Vo.setPayItemCd(payr0410.getPayrImcd());   /** column 급여항목코드 : payItemCd */
			//							                              payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
			//							                              payr0302Vo.setPymtDducDivCd(payr0410.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */  
			//							                              payr0302Vo.setPymtDducSum(tpSchlExpnAdmclExtpySum);   /** column 지급공제금액 : pymtDducSum */
			//							                              payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
			//							                              payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
			//							                             
			//						//	                                                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
			//						//	                                                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
			//						//	                                                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
			//						//	                                                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
			//						//	                                                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
			//						//	                                                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
			//							                             
			//							                              // B0050001    B005    0001    과세
			//							                              // B0050002    B005    0002    비과세
			//							                              // B0050003    B005    0003    부분과세
			//							                               
			//							                              if ("B0050002".equals(payr0410.getTxtnDivCd())) {
			//							                                  payr0302Vo.setPymtDducFreeDtySum(tpSchlExpnAdmclExtpySum);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//							                                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			//							                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(tpSchlExpnAdmclExtpySum);
			//							                              } else  if ("B0050001".equals(payr0410.getTxtnDivCd())) {
			//							                                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//							                                  payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			//							                                  tpFreeDtyTotAmnt = BigDecimal.ZERO;
			//							                              } else  if ("B0050003".equals(payr0410.getTxtnDivCd())) {
			//							                                  payr0302Vo.setPymtDducFreeDtySum(payr0410.getFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//							                                  payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum.subtract(payr0410.getFreeDtySum()));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			//							                                  tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum());
			//							                              } else {
			//							                           	   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//							                                  payr0302Vo.setPymtDducTxtnAmnt(tpSchlExpnAdmclExtpySum);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
			//							                                  tpFreeDtyTotAmnt = BigDecimal.ZERO;
			//							                              }
			//							                         
			//							                              
			//							                               tpPymtTotAmnt = tpPymtTotAmnt.add(tpSchlExpnAdmclExtpySum);
			//							                               tpExtpyTotAmnt = tpExtpyTotAmnt.add(tpSchlExpnAdmclExtpySum); 
			//							                                
			//							                               
			//							                                 if (tpSchlExpnAdmclExtpySum.compareTo(BigDecimal.ZERO) > 0) {
			//							                                     payCalculationService.insertPayr0302(payr0302Vo);  
			//							                                  } 
			//							                          
										                          } else if ((ExtermsProps.getProps("PYMT_ITEM_04").equals(infcPayr0410Vo.getPayrImcd()) || ExtermsProps.getProps("PYMT_ITEM_25").equals(infcPayr0410Vo.getPayrImcd()))
										                        		  && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
										                            //선임인력수당 -직채수당인경우 처리 루틴  PYMT_ITEM_25        
										                            //직책별 수당  //기타수당을 반장수당으로 대체 해서 처리 할것. 반장등수당처리부분 
			//							                               payr0460Vo = new InfcPkgPayr0460VO();
			//						
			//							                               payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
			//							                               payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			//							                               payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
			//							                               payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
			//							                               payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
			//							                            
			//							                               payr0460Vo = payCalculationService.selectPayr0460(payr0460Vo);
			//							                              
			//							                              if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
										                                  
										                        	    BigDecimal mothPayAmt = BigDecimal.ZERO; //정상금액 
											                            BigDecimal dayPaySum = BigDecimal.ZERO;  // 일액계산 
											                              
			//							                        		infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//								                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
											                  		  	infcRemt2200Vo.setPymtSum(new BigDecimal("50000"));    /** TODO 수정 column 지급금액 : pymtSum */ 
											                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
												                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
												                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
												                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
												                  		
												                  		
												                  	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))) > 0)) {
									                                         
									                                         mothPayAmt =  infcRemt2200Vo.getPymtSum();//(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
									                                        
									                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
									                                       		  .multiply((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))).setScale(-1, 1);
									                                         
									                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200Vo.getSevePayCmpttnTm(),"0")))) == 0)) {
									                                       
									                                         dayPaySum = infcRemt2200Vo.getPymtSum(); // (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
									                                         
									                                     } else { 
									                                         
									                                         dayPaySum = BigDecimal.ZERO;
									                                     }
												                  		
												                  	if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
										                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
										                               } else {
										                            	   infcRemt2200Vo.setPymtSum(dayPaySum);
										                               }
												                  	  
												                    	
												                    	
												                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
										                               
												                  		remtPayrService.updateRemt2200(infcRemt2200Vo);  
										                                  
										                            //  } 
										                                     
										                          } else if (ExtermsProps.getProps("PYMT_ITEM_50").equals(infcPayr0410Vo.getPayrImcd()) && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
										                            // 근속가산금   
			//							                        	  infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//								                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
											                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
											                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
												                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
												                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
												                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
										                              
										                             // tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
										                             // tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
										                             // tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
										                               
												                  		if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
										                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
										                               } else {
										                            	  // infcRemt2200Vo.setPymtSum(dayPaySum);
										                               }
												                  	  
												                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
												                  		
												                  		remtPayrService.updateRemt2200(infcRemt2200Vo);  
										                                
									
										                          } else if (ExtermsProps.getProps("PYMT_ITEM_51").equals(infcPayr0410Vo.getPayrImcd()) && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
										                            //정근수당
										                              
			//							                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//								                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
											                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
											                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
												                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
												                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
												                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
										                              
										                             // tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
										                             // tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
										                             // tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
										                               
												                  		if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
										                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
										                               } else {
										                            	  // infcRemt2200Vo.setPymtSum(dayPaySum);
										                               }
												                  	  
												                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
												                  		
												                  		remtPayrService.updateRemt2200(infcRemt2200Vo);  
										                                
										                              
										                              
										                          } else if (ExtermsProps.getProps("PYMT_ITEM_52").equals(infcPayr0410Vo.getPayrImcd()) && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
										                            //장기근속수당 
			//							                        	  infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//								                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
											                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
											                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
												                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
												                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
												                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
										                              
										                             // tpPymtTotAmnt = tpPymtTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
										                             // tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0460Vo.getOdtyDtilOccuClsSum());
										                             // tpFreeDtyTotAmnt = tpFreeDtyTotAmnt.add(payr0410.getFreeDtySum()); 
										                               
												                  		if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
										                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
										                               } else {
										                            	  // infcRemt2200Vo.setPymtSum(dayPaySum);
										                               }
												                  	  
												                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
												                  		
												                  		remtPayrService.updateRemt2200(infcRemt2200Vo);  
										                                
										                              
										                          } else { 
												                  		  //TODO 12월인경우 처리를 위한 루틴 으로 수정필요 
								                                          if (ExtermsProps.getProps("PAY_EMYMT_PYMT_07").equals(infcPayr0410Vo.getPayrImcd())
								                                        		  && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
								                                               
								                                             if (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm()).compareTo(BigDecimal.ZERO) > 0) {
								                                                   //시간외근무 
								                                                    
			//					                                            	 infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//											                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//											                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//											                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//											                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//											                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//											                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//											                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
														                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
														                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
															                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
															                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
															                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
															                  		
								                                                     BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
								                                                    		 //infcPayr0410Vo.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getBefUcstSum() : (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
								                                                   
			//					                                                     if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			//					                                                   	  ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
			//					                                                     } 
								                                                     
								                                                     BigDecimal totTmSum = BigDecimal.ZERO;
								                                                     
								                                                     totTmSum = (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm())).multiply(ucstSum);  //시간외근무
								                                                     
								                                                     if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
														                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
														                               } else {
														                            	   infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtSum */ 
														                               } 
								                                                     
								                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
								 							                  		
								 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);  
								                                                      
								                                               } else {
								                                                	  
														                             infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */  
								                                                     
								                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
									 							                  		
								 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);  
								                                                 }
								                                               
								                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_04").equals(infcPayr0410Vo.getPayrImcd())
								                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
								                                           // 토요근무수당   --일수산정C9410700
								                                        	 
			//					                                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//										                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//										                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//										                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//										                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//										                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//										                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//										                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
													                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
													                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
														                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
														                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
														                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
														                  		
								                                           
								                                            if (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm()).compareTo(BigDecimal.ZERO) > 0) {
								                                           	 
								                                                 BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
								                                                		  //payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			//					                                                 if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			//					                                               	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			//					                                                 } 
								                                                 BigDecimal totTmSum = BigDecimal.ZERO;
								                                                 
								                                                 totTmSum = (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm())).multiply(ucstSum);  //토요근무수당 
								                                                 
								                                                 
								                                                 if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
													                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
													                               } else {
													                            	   infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtSum */ 
													                               }
								                                                 
								                                                 
							                                                     
							                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
							 							                  		
							 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);   
								                                             
								                                             } else {
							                                                	  
													                             infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */  
							                                                     
							                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
								 							                  		
							 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);  
							                                                 }
								                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_10").equals(infcPayr0410Vo.getPayrImcd())
								                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
								                                          // 야간수당       -- 시간산정C9410300
								                                        	 
			//					                                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//										                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//										                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//										                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//										                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//										                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//										                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//										                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
													                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
													                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
														                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
														                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
														                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
														                  		
								                                             if (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm()).compareTo(BigDecimal.ZERO) > 0) {
								                                           	  
								                                                 BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
			//					                                                		 payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			//					                                                 if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			//					                                               	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			//					                                                 } 
								                                                 BigDecimal totTmSum = BigDecimal.ZERO;
								                                                 
								                                                 totTmSum = (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm())).multiply(ucstSum);  //시간외근무
								                                                  
								                                                 if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
													                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
													                               } else {
													                            	   infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtDducSum */
													                               }
								                                                 
								                                                 
								                                                
								                                                
								                                                 snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
								 							                  		
							 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);     
								                                             }else {
							                                                	  
													                             infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */  
							                                                     
							                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
								 							                  		
							 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);  
							                                                 }
								                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_21").equals(infcPayr0410Vo.getPayrImcd())
								                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
								                                           // 휴일수당        -- 일수 C9410200
								                                        	 
			//					                                        	 infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//										                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//										                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//										                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//										                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//										                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//										                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//										                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
													                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
													                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
														                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
														                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
														                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
														                  		
								                                             if (MSFSharedUtils.paramNotNull(infcRemt2200InVo.getSevePayCmpttnTm())) {
								                                           	  
								                                                 if (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm()).compareTo(BigDecimal.ZERO) > 0) {
								                                               	  
								                                                     BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum(); 
								                                                 
								                                                    //     payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
								                                                    // if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
								                                                   	//  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
								                                                    // }
								                                                     
								                                                     BigDecimal totTmSum = BigDecimal.ZERO;
								                                                     
								                                                     totTmSum = (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm())).multiply(ucstSum);  //토요근무수당 
								                                                     
								                                                     if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
														                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
														                               } else {
														                            	   infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtDducSum */
														                               }
								                                                     
								                                                    
								                                                     
								                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
									 							                  		
								 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);      
								                                                 } else {
								                                                	  
														                             infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */  
								                                                     
								                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
									 							                  		
								 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);  
								                                                 }
								                                             }    
								                                         } else  if (ExtermsProps.getProps("PAY_EMYMT_PYMT_23").equals(infcPayr0410Vo.getPayrImcd())
								                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("beLogSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
								                                             // 유급휴일수당  -- 일수 산정 C9415000
			//					                                        	 infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//										                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//										                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//										                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//										                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//										                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//										                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//										                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
													                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
													                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
														                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
														                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
														                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
														                  		
								                                             if (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm()).compareTo(BigDecimal.ZERO) > 0) {
								                                                
								                                                 BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
			//					                                                		 payr0410.getBefUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getBefUcstSum() : (payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum());
			//					                                                 if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
			//					                                               	  ucstSum = payr0410.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? payr0410.getUcstSum() : payr0410.getPymtDducSum();
			//					                                                 } 
								                                                 BigDecimal totTmSum = BigDecimal.ZERO;
								                                                 
								                                                 totTmSum = (new BigDecimal(infcRemt2200InVo.getSevePayCmpttnTm())).multiply(ucstSum);  //토요근무수당 
								                                                 
								                                                 if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
													                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
													                               } else {
													                            	   infcRemt2200Vo.setPymtSum(totTmSum);   /** column 지급금액 : pymtDducSum */
													                               } 
								                                                 
								                                                 snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
								 							                  		
							 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);       
								                                             }else {
							                                                	  
													                             infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */  
							                                                     
							                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
								 							                  		
							 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);  
							                                                 }
								                                         } else   if (ExtermsProps.getProps("PAY_EMYMT_PYMT_18").equals(infcPayr0410Vo.getPayrImcd())
								                                        		 && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd())) {
								                                               //PAY_EMYMT_PYMT_18 = "C9080100";    // 정액급식비
								                                        	 
			//					                                        	    infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
			//										                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			//										                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
			//										                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			//										                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
			//										                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
			//										                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
			//										                  		  	infcRemt2200Vo.setSevePayCmpttnTm("0");    /** column 퇴직금산정시간 : sevePayCmpttnTm */
													                  		  	infcRemt2200Vo.setPymtSum(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());    /** column 지급금액 : pymtSum */ 
													                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
														                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
														                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
														                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
														                  		
								                                       	        BigDecimal dayPaySum = BigDecimal.ZERO; 
								                                                BigDecimal ucstSum = infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum();
								                                             
			//					                                                 if ((new BigDecimal(remt0100DlgnVo.getDilnlazAbnceNumDys())).compareTo(BigDecimal.ZERO) > 0) {
			//					                                                     //결근은 정액급식비 을 제외 급여모자랄시  
			//					                                               	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) > 0)) {
			//					                                                          
			//					                                                   	   dayPaySum = (ucstSum.divide((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
			//					                                                   			     .multiply((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()).add(new BigDecimal(payCalculationVo.getDilnlazAbnceDutyRcgtnDys()))
			//					                                                   			    		 .add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys()))))).setScale(-1, 1);
			//					                                                         
			//					                                                     }  else  if ((new BigDecimal(payCalculationVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())).add((new BigDecimal(payCalculationVo.getDilnlazAbnceNumDys())))) == 0)) {
			//					                                                       
			//					                                                         dayPaySum = ucstSum;
			//					                                                         
			//					                                                     } else {
			//					                                                         
			//					                                                         dayPaySum = BigDecimal.ZERO;
			//					                                                     } 
			//					                                                 } else { 
								                                                     if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))) > 0)) {
								                                                          
								                                                   	   dayPaySum = (ucstSum.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP)).multiply((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))
								                                                   	   ).setScale(-1, 1);
								                                                         
								                                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo(new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0"))) == 0)) {
								                                                       
								                                                         dayPaySum = ucstSum;
								                                                         
								                                                     } else {
								                                                         
								                                                         dayPaySum = BigDecimal.ZERO;
								                                                     } 
								                                                // }
								                                                     
								                                                     if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
														                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
														                               } else {
														                            	   infcRemt2200Vo.setPymtSum(dayPaySum);   /** column 지급공제금액 : pymtDducSum */
														                               } 
								                                                     
								                                                 
								                                                     snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
									 							                  		
								 							                  		 remtPayrService.updateRemt2200(infcRemt2200Vo);       
								                                                
								                                         } else {
								                                        	 // TODO 전부 속해 있지 않은 경우 처리 로직 
								                                        	 
								                                         } 
										                                    
										                          }    
									                             break;
										                	  }  else {
										                		   
										                		    if (  ExtermsProps.getProps("PYMT_ITEM_25").equals(infcRemt2200InVo.getPayItemCd()) 
									                        		  && MSFSharedUtils.allowNulls(mapDateTerm.get("logSvcYrNumCd")).equals(infcPayr0410Vo.getPyspLogSvcYrNumCd()) && chkItemCd) {
													                            //선임인력수당 -직채수당인경우 처리 루틴  PYMT_ITEM_25        
													                            //직책별 수당  //기타수당을 반장수당으로 대체 해서 처리 할것. 반장등수당처리부분 
						//							                               payr0460Vo = new InfcPkgPayr0460VO();
						//						
						//							                               payr0460Vo.setPayYr(payr0250Vo.getJobYrMnth().substring(0,4));    /** column 급여년도 : payYr */
						//							                               payr0460Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
						//							                               payr0460Vo.setOdtyDtilOccuClsCd(payCalculationVo.getOdtyCd());    /** column 직책_직종세코드 : odtyDtilOccuClsCd */
						//							                               payr0460Vo.setPayItemCd(ExtermsProps.getProps("PYMT_ITEM_04"));    /** column 급여항목코드 : payItemCd */ 
						//							                               payr0460Vo.setOdtyDtilOccuClsDelYn("N");    /** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
						//							                            
						//							                               payr0460Vo = payCalculationService.selectPayr0460(payr0460Vo);
						//							                              
						//							                              if (MSFSharedUtils.paramNotNull(payr0460Vo)) {
													                                  
													                        	    BigDecimal mothPayAmt = BigDecimal.ZERO; //정상금액 
														                            BigDecimal dayPaySum = BigDecimal.ZERO;  // 일액계산 
														                              
						//							                        		infcRemt2200Vo.setDpobCd(MSFSharedUtils.allowNulls(mapDateTerm.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						//								                  		  	infcRemt2200Vo.setSystemkey(MSFSharedUtils.allowNulls(mapDateTerm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						//								                  		  	infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
						//								                  		  	infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						//								                  		  	infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(MSFSharedUtils.allowNulls(mapDateTerm.get("sevePayDtlPatrNum"))));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
						//								                  		  	infcRemt2200Vo.setPayItemCd(MSFSharedUtils.allowNulls(mapRemtPayr0302.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
						//								                  		  	infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020010);    /** column 수당그룹코드 : extpyGrpCd */
						//								                  		  	infcRemt2200Vo.setSevePayCmpttnTm(MSFSharedUtils.defaultNulls(mapDateTerm.get("pymtNumDys"),"0"));    /** column 퇴직금산정시간 : sevePayCmpttnTm */
														                  		  	infcRemt2200Vo.setPymtSum(new BigDecimal("50000"));    /** TODO 수정 column 지급금액 : pymtSum */ 
														                  		    infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
															                  		infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
															                  		infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
															                  		infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
															                  		
															                  		
															                  	  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))) > 0)) {
												                                         
												                                         mothPayAmt =  infcRemt2200Vo.getPymtSum();//(infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
												                                        
												                                         dayPaySum = (mothPayAmt.divide((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys())),3, BigDecimal.ROUND_UP))
												                                       		  .multiply((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200InVo.getSevePayCmpttnTm(),"0")))).setScale(-1, 1);
												                                         
												                                     }  else  if ((new BigDecimal(remt0100DlgnVo.getDilnlazDutyNumDys()).compareTo((new BigDecimal(MSFSharedUtils.defaultNulls(infcRemt2200Vo.getSevePayCmpttnTm(),"0")))) == 0)) {
												                                       
												                                         dayPaySum = infcRemt2200Vo.getPymtSum(); // (infcPayr0410Vo.getUcstSum().compareTo(BigDecimal.ZERO) > 0 ? infcPayr0410Vo.getUcstSum() : infcPayr0410Vo.getPymtDducSum());
												                                         
												                                     } else { 
												                                         
												                                         dayPaySum = BigDecimal.ZERO;
												                                     }
															                  		
															                  	if ("0".equals(infcRemt2200InVo.getSevePayCmpttnTm())) {
													                            	   infcRemt2200Vo.setPymtSum(infcRemt2200InVo.getPymtSum());    /** column 지급금액 : pymtSum */ 
													                               } else {
													                            	   infcRemt2200Vo.setPymtSum(dayPaySum);
													                               }
															                  	  
															                    	
															                    	
															                  		snryAllwAggrSum = snryAllwAggrSum.add(infcRemt2200Vo.getPymtSum()); //수당합계
													                               
															                  		remtPayrService.updateRemt2200(infcRemt2200Vo);  
															                  		 chkItemCd = false ;
													                            //  } 
										                		    }
										                		    
										                	  }
						                	     }  
						                    }
							         }                   
				              	  } 	 
				  	  
				  	  
				         /**-----------------------후생복지비 시작 ----------------------------------------------------------*/ 
					       //3.1.3 후생복지비로 등록된 항목에 대해서는 실제지급한 항목으로 구해야 하므로 해당하는 db로 관리해야함 일단은 박음.
					         
					         // TODO 3.1.2 함수호출해서 동일한 값을 처리하도록 하는 루틴 하여 계산후 저장
					           //명절휴가비 - 소급적용시 때문에 1년안에 금액을 단가표에서 계산 함. 
					          //TODO 호봉승급이 중간에 들어간 경우 계산처리 ---소급계산에서 처리한 상세 내역을 가지고 와야함.
					                	 
					                	  
//						                	  List<RemtWfep0100VO> lstRemtWfep0100Vo = new ArrayList<RemtWfep0100VO>();
//						                	  RemtPayr0302SrhVO  remtPayr0302SrhVo = new RemtPayr0302SrhVO();
//							                  
//							                  remtPayr0302SrhVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//							                  remtPayr0302SrhVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//							                  remtPayr0302SrhVo.setRetryDt(infcRemt2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */ 
//							                  
//							                  lstRemtWfep0100Vo = remtPayrService.selectRemtWfep0100List(remtPayr0302SrhVo);     
//						                	  
//							                  for (int iCnt04 = 0; iCnt04 < lstRemtWfep0100Vo.size();iCnt04++) { 
//							        		   
//							                	  RemtWfep0100VO remtWfep0100Vo = new RemtWfep0100VO();
//							                	 // InfcRemt2200VO infcRemt2200Vo = new InfcRemt2200VO();
//							                	  
//							                	  remtWfep0100Vo = lstRemtWfep0100Vo.get(iCnt04);
//							                	  
//							                	  infcRemt2200Vo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//					                  		  	  infcRemt2200Vo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//					                  		  	  infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
//					                  		  	  infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//					                  		      infcRemt2200Vo.setSevePayDtlPatrNum(BigDecimal.ZERO);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
//					                  		  	  infcRemt2200Vo.setPayItemCd(remtWfep0100Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//					                  		  	  infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020020);    /** column 수당그룹코드 : extpyGrpCd */
//					                  		  	  infcRemt2200Vo.setSevePayCmpttnTm(remtWfep0100Vo.getItemMonths());    /** column 퇴직금산정시간 : sevePayCmpttnTm */
//					                  		  	  infcRemt2200Vo.setPymtSum(remtWfep0100Vo.getPymtSum());    /** column 지급금액 : pymtSum */ 
//					                  		      infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//						                  		  infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//						                  		  infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//						                  		  infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
//							                  		
//						                  		  welfSpdgAggrSum  = welfSpdgAggrSum.add(infcRemt2200Vo.getPymtSum());   //후생복지비 합계금액  
//						                  		  
//						                  		  remtPayrService.insertRemt2200(infcRemt2200Vo);  
//							        	      } 
					         
					       /**-----------------------후생복지비 종료 ----------------------------------------------------------*/ 
			        	   
						   /**+++++++++++++++++++++++++++++++++++++퇴직금산정 기본 업데이트 시작 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
						                //1일평균 임금  

							        	aggrTotSum = fndtnPayAggrSum.add(snryAllwAggrSum) ;      //기본급 + 제수당 합계금액  
						               // marPubcWelfAmnt = welfSpdgAggrSum.divide(new BigDecimal("12"),3, RoundingMode.DOWN).multiply(new BigDecimal("3")).setScale(-1, RoundingMode.DOWN);//3개월간 후생복지비  
							        	 
						                
						                marTotAmntWag =  aggrTotSum.add(infcRemt2000Vo.getMarPubcWelfAmnt()); //3개월간 총임금액 
						                        
						                  
						             	infcRemt2000Vo.setFndtnPayAggrSumSum(fndtnPayAggrSum);    /** column 기본급여합계금액 : fndtnPayAggrSumSum */
						    		  	infcRemt2000Vo.setSnryAllwAggrSum(snryAllwAggrSum);    /** column 제수당합계금액 : snryAllwAggrSum */
						    		  //	infcRemt2000Vo.setWelfWelfSpdgAggrSum(welfSpdgAggrSum);    /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
						    		  	
						    		  	infcRemt2000Vo.setMarTotAmntWag(marTotAmntWag);    /** column 3월간총임금액 : marTotAmntWag */
						    		  	infcRemt2000Vo.setDayAvgAmntWag(marTotAmntWag.divide(marTotAmntDays, 10, RoundingMode.DOWN));    /** column 1일평균임금액 : dayAvgAmntWag */
						                  
						    		  	
						    		    infcRemt2000Vo.setSevePayCmpttnSum(((infcRemt2000Vo.getDayAvgAmntWag().multiply(new BigDecimal("30")))
						    		    		                   .multiply((infcRemt2000Vo.getTotLogSvcNumDys().divide(new BigDecimal("365"), 10, RoundingMode.DOWN))))
						    		    		                   .setScale(-1, RoundingMode.DOWN));    /** column 퇴직금산정금액 : sevePayCmpttnSum */
						                   
						    			if (infcRemt2000Vo.getSevePayAddRate().compareTo(BigDecimal.ZERO) > 0) {
						    				
						    				BigDecimal sevepayAddRate = BigDecimal.ZERO;
						    				
						    				sevepayAddRate = infcRemt2000Vo.getSevePayAddRate().divide(new BigDecimal("100"));
						    				infcRemt2000Vo.setSevePayAddApptnSum(infcRemt2000Vo.getSevePayCmpttnSum().multiply(sevepayAddRate).setScale(-1, RoundingMode.UP));    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
						    				
						    				//infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
							    		  	//infcRemt2000Vo.setSevePayAddRate(remtPsnl0100Vo.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
							    		  	  
						    			} else {
						    				if (infcRemt2000Vo.getSevePayAddSum().compareTo(BigDecimal.ZERO) > 0) {
						    					
						    					//infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
						    					infcRemt2000Vo.setSevePayAddApptnSum(infcRemt2000Vo.getSevePayCmpttnSum().add(infcRemt2000Vo.getSevePayAddSum()));    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
							    				
						    				}
						    			}
						    		  
						    		    if ("Y".equals(infcRemt2000Vo.getAmcrrClutInsnYn())) {
						    		    	//TODO 군경력은 금액의 1.5를 곱해서 지급 확인 할것 설정정보...
						    		      //infcRemt2000Vo.setAmcrrLogSvcNumDys(remtPsnl0100Vo.getAmcrrLogSvcNumDys());    /** column 군경력근무일수 : amcrrLogSvcNumDys */
	                                        BigDecimal sevePayAddApptnSum = BigDecimal.ZERO;
	                                        sevePayAddApptnSum = (infcRemt2000Vo.getDayAvgAmntWag().multiply(new BigDecimal("30")))
			    		    		                             .multiply((infcRemt2000Vo.getAmcrrLogSvcNumDys().divide(new BigDecimal("365"),10,RoundingMode.DOWN))) ;
						    			 
						    				infcRemt2000Vo.setAmcrrAddApptnSum(sevePayAddApptnSum.multiply(new BigDecimal("1.5")).setScale(-1, RoundingMode.DOWN));    /** column 군경력가산적용금액 : amcrrAddApptnSum */
						    				  
						    		    }  
						    		    
						    			infcRemt2000Vo.setSevePayPymtSum(infcRemt2000Vo.getSevePayCmpttnSum().add(infcRemt2000Vo.getSevePayAddApptnSum())
						    					                       .add(infcRemt2000Vo.getAmcrrAddApptnSum()));    /** column 퇴직금지급액 : sevePayPymtSum */
						    			
						    		  	infcRemt2000Vo.setSevePayCmpttnFreeDtySum(BigDecimal.ZERO);    /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
						    		  	
						    		  	infcRemt2000Vo.setSevePayCmpttnTxtnSum(infcRemt2000Vo.getSevePayPymtSum());    /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
						    		  	
						    		  	
						    		  	//infcRemt2000Vo.setSevePayPymtDducSum(dducSum);    /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
						    		  	
						    		  	//infcRemt2000Vo.setSevePayTurtyPymtSum(infcRemt2000Vo.getSevePayPymtSum().subtract(dducSum));    /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */	    
						    		     
						    		  	remtPayrService.updateRemt2000(infcRemt2000Vo);
						    		  	
						    		  	/**+++++++++++++++++++++++++++++++++++++퇴직정산 메서드 호출부 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/        
						    		  	
						    		  	BigDecimal dducSum = BigDecimal.ZERO;
						    		  	
						    		  	InfcPkgRemt3100VO remt3100TgtVo = new InfcPkgRemt3100VO();
						    		  	
						    		    /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
							  	        
						    		  	remt3100TgtVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
						    		  	remt3100TgtVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
						    		  	remt3100TgtVo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						    		  	remt3100TgtVo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
									 	 
						    		  	remt3100TgtVo.setEndRetryPayQnty(infcRemt2000Vo.getSevePayPymtSum());    /** column 종_퇴직급여액 : endRetryPayQnty */
						    		  	remt3100TgtVo.setEndFreeDtyRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnFreeDtySum());    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
						    		  	remt3100TgtVo.setEndTxtnTgtRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnTxtnSum());    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
						    		  	  
						    			 
						    		  	remt3100TgtVo.setClutRetryPayQnty(infcRemt2000Vo.getSevePayPymtSum());    /** column 정산_퇴직급여액 : clutRetryPayQnty */
						    		  	remt3100TgtVo.setClutFreeDtyRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnFreeDtySum());    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
						    		  	remt3100TgtVo.setClutTxtnTgtRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnTxtnSum());    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
									
						    		  	 
						    		  	remt3100TgtVo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
						    		  	remt3100TgtVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						    		  	remt3100TgtVo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
						    		  	remt3100TgtVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					    
									 	remtPayrService.updateRemt3100Remt2000Data(remt3100TgtVo);
									 	 /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 종료 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
						    		  	 
						    		  	dducSum = funcRemtTxCalc(request,  remt3100TgtVo); 
						    		  	
						    		  	/**+++++++++++++++++++++++++++++++++++++퇴직정산 메서드 호출부 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/         
						    		  	 
						          /**+++++++++++++++++++++++++++++++++++++퇴직금산정 기본 업데이트 종료 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
						     } else {
					        	   //TODO 무기계약직 마무리 후 적용 할것 9월말까지 
					        	   /**=========================기간제근로자=====================================*/ 
					        	   
					        } 
		  		  
		  		  
		  	
		  	/*************************************급여산정종료*********************************************/ 
	  	  
	  	} catch (Exception ex) {
           ex.printStackTrace();   
   	  
   	     retval =  0L;   
   	 
         } 
	  	  
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D");
	  	   
	   return  retval;
	}
  	    
    
    /**
     * 후생복지비에 따른 퇴직금재정산 처리부 
     * @param request
     * @param listRemt2000Vo
     * @return
     * @throws Exception
     */
    private Long funcActivityOnUpdateRemt0100ToPayrWfepCalc(HttpServletRequest request, List<InfcPkgRemt2200VO> listRemt2200Vo)  throws Exception  {
    	
    	Long retval = 0L; 
    	

    	String method = calledClass + ".funcActivityOnUpdateRemt0100ToPayrWfepCalc";
	  	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	    
	  	InfcPkgRemt2000VO infcRemt2000Vo = new InfcPkgRemt2000VO(); 
	  	
	  
	  	BigDecimal welfSpdgAggrSum  = BigDecimal.ZERO;   //후생복지비 합계금액  
	  	BigDecimal marPubcWelfAmnt  = BigDecimal.ZERO;    //3개월간 후생복지비  
	  	BigDecimal marTotAmntWag = BigDecimal.ZERO;    //3개월간 총임금액  
		BigDecimal marTotAmntDays = BigDecimal.ZERO;    //3개월간 총일수 
		
	  	  try {
	  		  
	  		   
		  	   if  (remtPayrService == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               remtPayrService = (RetirementPayrService) wac.getBean("RetirementPayrService" ); 
	              
	            } 
		  	   
	  	     /*************************************급여산정시작*********************************************/
		  	 
		  	      InfcPkgRemt2200VO infcRemt2200SrhVo = new InfcPkgRemt2200VO();  
		  	      infcRemt2200SrhVo  = listRemt2200Vo.get(0);  
		  	  
		  		  infcRemt2000Vo.setDpobCd(infcRemt2200SrhVo.getDpobCd());    /** column 사업장코드 : dpobCd */
		  		  infcRemt2000Vo.setSystemkey(infcRemt2200SrhVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		  		  infcRemt2000Vo.setCalcSevePayPsnDivCd(infcRemt2200SrhVo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  		  infcRemt2000Vo.setClutYrMnth(infcRemt2200SrhVo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
	 
			  	  /**@@@@@@@@@@@@@@@@@@@@@@@대상자 등록정보 조회 급여산정  @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			  	 
			  		infcRemt2000Vo = remtPayrService.selectRemt2000(infcRemt2000Vo);
			  	 
//			  	   if (MSFSharedUtils.paramNull(infcRemt2000Vo) ) {
//	             	 // BaseModel bm = new BaseModel();
//	             	   ShowMessageBM smBm = new ShowMessageBM();
//	             	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR); 
//	             	   smBm.setMenu("Remt");
//	             	   smBm.setPhase("[급여산정]급여산정오류");
//	             	   smBm.setMessage("데이터가존재하지않습니다.");
//	             	   smBm.setContent("SystemKey" + infcRemt2000Vo.getSystemkey());
//	             	   bmResult.add(smBm); 
//	                } 
			  	   
			  		 //무기계약직근로자 인경우 
			      if (ExtermsProps.getProps("EMYMT_DIVCD_01").equals(infcRemt2000Vo.getEmymtDivCd())) {
			        /**=========================무기계약직======================================*/
			     
//	                	  List<RemtWfep0100VO> lstRemtWfep0100Vo = new ArrayList<RemtWfep0100VO>();
//	                	  RemtPayr0302SrhVO  remtPayr0302SrhVo = new RemtPayr0302SrhVO();
//		                  
//		                  remtPayr0302SrhVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                  remtPayr0302SrhVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
//		                  remtPayr0302SrhVo.setRetryDt(infcRemt2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */ 
//		                  
//		                  lstRemtWfep0100Vo = remtPayrService.selectRemtWfep0100List(remtPayr0302SrhVo);     
//	                	  
//		                  for (int iCnt04 = 0; iCnt04 < lstRemtWfep0100Vo.size();iCnt04++) { 
//		        		   
//		                	  RemtWfep0100VO remtWfep0100Vo = new RemtWfep0100VO();
//		                	 // InfcRemt2200VO infcRemt2200Vo = new InfcRemt2200VO();
//		                	  
//		                	  remtWfep0100Vo = lstRemtWfep0100Vo.get(iCnt04);
//		                	  
//		                	  infcRemt2200Vo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//                  		  	  infcRemt2200Vo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//                  		  	  infcRemt2200Vo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
//                  		  	  infcRemt2200Vo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//                  		      infcRemt2200Vo.setSevePayDtlPatrNum(BigDecimal.ZERO);    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
//                  		  	  infcRemt2200Vo.setPayItemCd(remtWfep0100Vo.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//                  		  	  infcRemt2200Vo.setExtpyGrpCd(ExtermsProps.REMT_R0020020);    /** column 수당그룹코드 : extpyGrpCd */
//                  		  	  infcRemt2200Vo.setSevePayCmpttnTm(remtWfep0100Vo.getItemMonths());    /** column 퇴직금산정시간 : sevePayCmpttnTm */
//                  		  	  infcRemt2200Vo.setPymtSum(remtWfep0100Vo.getPymtSum());    /** column 지급금액 : pymtSum */ 
//                  		      infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//	                  		  infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//	                  		  infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//	                  		  infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
//		                  		
//	                  		  welfSpdgAggrSum  = welfSpdgAggrSum.add(infcRemt2200Vo.getPymtSum());   //후생복지비 합계금액  
//	                  		  
//	                  		  remtPayrService.insertRemt2200(infcRemt2200Vo);  
//		        	      } 
			    	  
			    	    //후생복지비 합계  
				  	   for (int iCnt01 = 0;iCnt01 < listRemt2200Vo.size();iCnt01++) {
				  		    
				  		  InfcPkgRemt2200VO infcRemt2200Vo = new InfcPkgRemt2200VO(); 
				  		  infcRemt2200Vo = listRemt2200Vo.get(iCnt01);  
				  		   
//						infcRemt2200Vo.setDpobCd(remt2200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
//						infcRemt2200Vo.setSystemkey(remt2200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//						infcRemt2200Vo.setClutYrMnth(remt2200Dto.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
//						infcRemt2200Vo.setCalcSevePayPsnDivCd(remt2200Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//						infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(remt2200Dto.getSevePayDtlPatrNum()));    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
//						infcRemt2200Vo.setPayItemCd(remt2200Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//						infcRemt2200Vo.setExtpyGrpCd(remt2200Dto.getExtpyGrpCd());    /** column 수당그룹코드 : extpyGrpCd */
//						infcRemt2200Vo.setSevePayCmpttnTm(remt2200Dto.getSevePayCmpttnTm());    /** column 퇴직금산정시간 : sevePayCmpttnTm */
//						infcRemt2200Vo.setPymtSum(new BigDecimal(remt2200Dto.getPymtSum()));    /** column 지급금액 : pymtSum */
						  infcRemt2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
		          		  infcRemt2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
		          		  infcRemt2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		          		  infcRemt2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	 
							 
		              		
		          		  welfSpdgAggrSum  = welfSpdgAggrSum.add(infcRemt2200Vo.getPymtSum());   //후생복지비 합계금액  
		          		  
		          		  remtPayrService.updateRemt2200(infcRemt2200Vo);  
				  		   
				  	  }
				  	  
				  	  //3개월간 총일수 가져오는 쿼리 
				  	   
				  	    InfcPkgRemt2100SrhVO infcRemt2100SrhVo = new InfcPkgRemt2100SrhVO(); 
						
				  	    infcRemt2100SrhVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
					  	infcRemt2100SrhVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
					  	infcRemt2100SrhVo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
					  	infcRemt2100SrhVo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				  	   
						marTotAmntDays = new BigDecimal(remtPayrService.selectMarTotAmntDays(infcRemt2100SrhVo));
		   /**+++++++++++++++++++++++++++++++++++++퇴직금산정 기본 업데이트 시작 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
		                //1일평균 임금  

			        	//aggrTotSum = fndtnPayAggrSum.add(snryAllwAggrSum) ;      //기본급 + 제수당 합계금액  
		                marPubcWelfAmnt = welfSpdgAggrSum.divide(new BigDecimal("12"),10, RoundingMode.DOWN).multiply(new BigDecimal("3")).setScale(-1, RoundingMode.DOWN);//3개월간 후생복지비  
		                infcRemt2000Vo.setMarPubcWelfAmnt(marPubcWelfAmnt);  
		                
		                marTotAmntWag =  infcRemt2000Vo.getFndtnPayAggrSumSum().add(infcRemt2000Vo.getSnryAllwAggrSum()).add(marPubcWelfAmnt); //3개월간 총임금액 
		                        
		                  
		             //	infcRemt2000Vo.setFndtnPayAggrSumSum(fndtnPayAggrSum);    /** column 기본급여합계금액 : fndtnPayAggrSumSum */
		    		 // infcRemt2000Vo.setSnryAllwAggrSum(snryAllwAggrSum);    /** column 제수당합계금액 : snryAllwAggrSum */
		    		 	infcRemt2000Vo.setWelfWelfSpdgAggrSum(welfSpdgAggrSum);    /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
		    		  	
		    		  	infcRemt2000Vo.setMarTotAmntWag(marTotAmntWag);    /** column 3월간총임금액 : marTotAmntWag */
		    		  	infcRemt2000Vo.setDayAvgAmntWag(marTotAmntWag.divide(marTotAmntDays, 10, RoundingMode.DOWN));    /** column 1일평균임금액 : dayAvgAmntWag */
		                  
		    		  	
		    		    infcRemt2000Vo.setSevePayCmpttnSum(((infcRemt2000Vo.getDayAvgAmntWag().multiply(new BigDecimal("30")))
		    		    		                   .multiply((infcRemt2000Vo.getTotLogSvcNumDys().divide(new BigDecimal("365"), 10, RoundingMode.DOWN))))
		    		    		                   .setScale(-1, RoundingMode.DOWN));    /** column 퇴직금산정금액 : sevePayCmpttnSum */
		                   
		    			if (infcRemt2000Vo.getSevePayAddRate().compareTo(BigDecimal.ZERO) > 0) {
		    				
		    				BigDecimal sevepayAddRate = BigDecimal.ZERO;
		    				
		    				sevepayAddRate = infcRemt2000Vo.getSevePayAddRate().divide(new BigDecimal("100"));
		    				infcRemt2000Vo.setSevePayAddApptnSum(infcRemt2000Vo.getSevePayCmpttnSum().multiply(sevepayAddRate).setScale(-1, RoundingMode.UP));    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
		    				
		    				//infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
			    		  	//infcRemt2000Vo.setSevePayAddRate(remtPsnl0100Vo.getSevePayAddRate());    /** column 퇴직금가산율 : sevePayAddRate */
			    		  	 
		    				
		    			} else {
		    				if (infcRemt2000Vo.getSevePayAddSum().compareTo(BigDecimal.ZERO) > 0) {
		    					
		    					//infcRemt2000Vo.setSevePayAddSum(remtPsnl0100Vo.getSevePayAddSum());    /** column 퇴직금가산금액 : sevePayAddSum */
		    					infcRemt2000Vo.setSevePayAddApptnSum(infcRemt2000Vo.getSevePayCmpttnSum().add(infcRemt2000Vo.getSevePayAddSum()));    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
			    				
		    				}
		    			}
		    		  
		    		    if ("Y".equals(infcRemt2000Vo.getAmcrrClutInsnYn())) {
		    		    	//TODO 군경력은 금액의 1.5를 곱해서 지급 확인 할것 설정정보...
		    		      //infcRemt2000Vo.setAmcrrLogSvcNumDys(remtPsnl0100Vo.getAmcrrLogSvcNumDys());    /** column 군경력근무일수 : amcrrLogSvcNumDys */
                            BigDecimal sevePayAddApptnSum = BigDecimal.ZERO;
                            sevePayAddApptnSum = (infcRemt2000Vo.getDayAvgAmntWag().multiply(new BigDecimal("30")))
		    		                             .multiply((infcRemt2000Vo.getAmcrrLogSvcNumDys().divide(new BigDecimal("365"), 10, RoundingMode.DOWN))) ;
		    			 
		    				infcRemt2000Vo.setAmcrrAddApptnSum(sevePayAddApptnSum.multiply(new BigDecimal("1.5")).setScale(-1, RoundingMode.DOWN));    /** column 군경력가산적용금액 : amcrrAddApptnSum */
		    				  
		    		    } 
		    		     
		    			infcRemt2000Vo.setSevePayPymtSum(infcRemt2000Vo.getSevePayCmpttnSum().add(infcRemt2000Vo.getSevePayAddApptnSum())
		    					                       .add(infcRemt2000Vo.getAmcrrAddApptnSum()));    /** column 퇴직금지급액 : sevePayPymtSum */
		    			
		    		  	infcRemt2000Vo.setSevePayCmpttnFreeDtySum(BigDecimal.ZERO);    /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
		    		  	
		    		  	infcRemt2000Vo.setSevePayCmpttnTxtnSum(infcRemt2000Vo.getSevePayPymtSum());    /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
		    		  	
		    		  	
		    		  	//infcRemt2000Vo.setSevePayPymtDducSum(dducSum);    /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
		    		  	
		    		  	//infcRemt2000Vo.setSevePayTurtyPymtSum(infcRemt2000Vo.getSevePayPymtSum().subtract(dducSum));    /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */	    
		    		     
		    		  	remtPayrService.updateRemt2000(infcRemt2000Vo);
		    		  	
		    		  	/**+++++++++++++++++++++++++++++++++++++퇴직정산 메서드 호출부 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/        
		    		  	
		    		  	BigDecimal dducSum = BigDecimal.ZERO;
		    		  	
		    		  	InfcPkgRemt3100VO remt3100TgtVo = new InfcPkgRemt3100VO();
		    		  	
		    		    /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			  	        
		    		  	remt3100TgtVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
		    		  	remt3100TgtVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		    		  	remt3100TgtVo.setCalcSevePayPsnDivCd(infcRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		    		  	remt3100TgtVo.setClutYrMnth(infcRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
					 	 
		    		  	remt3100TgtVo.setEndRetryPayQnty(infcRemt2000Vo.getSevePayPymtSum());    /** column 종_퇴직급여액 : endRetryPayQnty */
		    		  	remt3100TgtVo.setEndFreeDtyRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnFreeDtySum());    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
		    		  	remt3100TgtVo.setEndTxtnTgtRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnTxtnSum());    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
		    		  	  
		    			 
		    		  	remt3100TgtVo.setClutRetryPayQnty(infcRemt2000Vo.getSevePayPymtSum());    /** column 정산_퇴직급여액 : clutRetryPayQnty */
		    		  	remt3100TgtVo.setClutFreeDtyRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnFreeDtySum());    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
		    		  	remt3100TgtVo.setClutTxtnTgtRetryPayQnty(infcRemt2000Vo.getSevePayCmpttnTxtnSum());    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
					
		    		  	 
		    		  	remt3100TgtVo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
		    		  	remt3100TgtVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
		    		  	remt3100TgtVo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		    		  	remt3100TgtVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	    
					 	remtPayrService.updateRemt3100Remt2000Data(remt3100TgtVo);
					 	 /**@@@@@@@@@@@@@@@@@@@@@@@퇴직금정산 인서트 업데이트 종료 @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		    		  	 
		    		  	dducSum = funcRemtTxCalc(request,  remt3100TgtVo); 
		    		  	
		    		  	/**+++++++++++++++++++++++++++++++++++++퇴직정산 메서드 호출부 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/         
	    		  	 
		          /**+++++++++++++++++++++++++++++++++++++퇴직금산정 기본 업데이트 종료 +++++++++++++++++++++++++++++++++++++++++++++++++++++++*/                  
						  
			     } else {
		        	   //TODO 무기계약직 마무리 후 적용 할것 9월말까지 
		        	   /**=========================기간제근로자=====================================*/ 
		        	   
		        } 
		  		 
		  	/*************************************급여산정종료*********************************************/ 
	  	  
	  	} catch (Exception ex) {
           ex.printStackTrace();   
   	  
   	     retval =  0L;   
   	 
      } 
	  	  
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
	  	   
	   return  retval;
    }
  	    
    
   /**
    * 근속예다른 년수,월수,일수 구하는 함수 
    * @param frstEmymtDt
    * @param retryDt
    * @param chkAmcrrClutInsnYn
    * @return
    */
    private RemtLogSvcDysVO fnc_LogSvcDys(HttpServletRequest request,InfcPkgRemt2000VO infcRemt2000Vo)  throws Exception{
		
    	RemtLogSvcDysVO rtnRemtLogSvcDysVo = new RemtLogSvcDysVO();
    	RemtLogSvcDysVO remtLogSvcDysVo = new RemtLogSvcDysVO();
    	 
    	if  (remtPayrService == null) { 
              WebApplicationContext wac = WebApplicationContextUtils.
                      getRequiredWebApplicationContext( request.getSession().getServletContext());
  
              remtPayrService = (RetirementPayrService) wac.getBean("RetirementPayrService" ); 
             
         }
     
    	
    	remtLogSvcDysVo.setDpobCd(infcRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
    	remtLogSvcDysVo.setSystemkey(infcRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
    	remtLogSvcDysVo.setIcncDt(infcRemt2000Vo.getIcncDt());    /** column 입사일자 : icncDt */
    	remtLogSvcDysVo.setRkfcdDt(infcRemt2000Vo.getRkfcdDt());    /** column 기산일자 : rkfcdDt */
    	remtLogSvcDysVo.setRetryDt(infcRemt2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */
 
    	//remtPsnl0100Vo.getChkAmcrrClutInsnYn();    /** column 군경력정산포함여부 : amcrrClutInsnYn */
    	  
    	
    	try {
    		
			rtnRemtLogSvcDysVo = remtPayrService.selectLogSvcDys(remtLogSvcDysVo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 
		}
    	 
    	
    	return rtnRemtLogSvcDysVo; 
    }  	
    	
    
    /**
     * 퇴직정산 - 중간정산과퇴직정산처리를 하는 함수.
     * @param request
     * @param remt3000TgtVo
     * @param listVoPsnl0100
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcRemtTxCalculation(HttpServletRequest request,List<InfcPkgRemt3000VO> lstInfcRemt3000TgtVo)  throws Exception  {
  	     
    	  PagingLoadResult<ShowMessageBM> retval = null; 
	      List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	      
	      BigDecimal dducSum = BigDecimal.ZERO;
//	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//	  	  
//	  	  //퇴직금산정테이블
//	  	  InfcRemt2000SrhVO remt2000SrhVo = new InfcRemt2000SrhVO(); 
//	  	  InfcRemt2000VO remt2000Vo = new InfcRemt2000VO(); 
//	  	  //퇴직정산마감등정보
//	  	  InfcRemt3000SrhVO remt3000SrhVo = new InfcRemt3000SrhVO();
//	  	  InfcRemt3000VO remt3000Vo = new InfcRemt3000VO();
//	  	  //퇴직금정산테이블
//	  	  InfcRemt3100SrhVO remt3100SrhVo = new InfcRemt3100SrhVO();
//	  	  InfcRemt3100VO remtSelect3100Vo = new InfcRemt3100VO();
//	  	  //퇴직금연금계좌명세 
//	  	  InfcRemt3200SrhVO remt3200SrhVo = new InfcRemt3200SrhVO();
//	  	  InfcRemt3200VO remt3200Vo = new InfcRemt3200VO();
//	  	  
//	  	  //퇴직금계산정보 
//	  	  InfcRemt3100VO remtInpt3100Vo = new InfcRemt3100VO();
	  	  
	  	  try {
	  		  
	   
//		  	   if  (remtCalcService == null) { 
//	               WebApplicationContext wac = WebApplicationContextUtils.
//	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
//	   
//	               remtCalcService = (RetirementCalculstionService) wac.getBean("RetirementCalculstionService" ); 
//	              
//	          }
//	  	   
	  	   
	  	  //1. 퇴직금산정금액테이블의 값을 가져옴 REMT2000
	  	   
	  	  //2. 퇴직정산 테이블 데이터를 가져옴.  REMT3100
	  	   
		  	  /**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		  	   *  퇴직정산대상자 for문시작 
		  	   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		  	  for (int icnt = 0; icnt < lstInfcRemt3000TgtVo.size();icnt++) { 
		  		  
		  		InfcPkgRemt3000VO infcRemt3000Vo = new InfcPkgRemt3000VO();
		  		infcRemt3000Vo = (InfcPkgRemt3000VO)lstInfcRemt3000TgtVo.get(icnt);
		  		
		  		//퇴직정산 검색조건에 따른 값가져오기 
		  		InfcPkgRemt3100VO tpRemt3100Vo = new InfcPkgRemt3100VO();
		  		 
		  		tpRemt3100Vo.setDpobCd(infcRemt3000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
		  		tpRemt3100Vo.setClutYrMnth(infcRemt3000Vo.getClutYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
		  		tpRemt3100Vo.setCalcSevePayPsnDivCd(infcRemt3000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  		tpRemt3100Vo.setSystemkey(infcRemt3000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		  		
		  		dducSum = funcRemtTxCalc( request,tpRemt3100Vo);  
//		  		remtSelect3100Vo = remtCalcService.selectRemt3100(tpRemt3100Vo); 
//		  		 
//		  		
//		  		if (MSFSharedUtils.paramNull(remtSelect3100Vo) ) {
//		  			 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"remt","[퇴직정산]" + String.valueOf(lstInfcRemt3000TgtVo.size()) + "명처리중","퇴직정산내역이존재하지않음","퇴직금계산처리후실행하십시요."));  
//		  		}
//		  		
//		  		BeanUtils.copyProperties(remtInpt3100Vo, remtSelect3100Vo);   //입력을위해 조회값을 입력값에 대입
//		  		
//		  		/**
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 * 퇴직소득과세표준계산 - 퇴직소득에 따른 퇴직소득정률공제 계산 현재 40% - 2016년도 차등적용으로 변환  round 처리 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */
//		  	 
//				remtInpt3100Vo.setRetryFxrtDducClutSum(((remtInpt3100Vo.getRetryIncmClutSum().multiply(new BigDecimal("0.40"))).setScale(0, 0)));    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//		  		 
//				/**
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 * 퇴직소득과세표준계산  - 근속년수공제
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */
//				 BigDecimal dcLogYrDducSum = BigDecimal.ZERO; //근속년수공제_정산금액 
//				 BigDecimal dcTpLogYrDducSum = BigDecimal.ZERO; //근속년수공제_정산금액 
//				 BigDecimal dcLogYrDducLimit = BigDecimal.ZERO; //근속년수공제_한도금액 
//				 
//				 
//				 dcLogYrDducLimit = remtInpt3100Vo.getRetryIncmClutSum().subtract(remtInpt3100Vo.getRetryFxrtDducClutSum());   //한도액 
//				 
//				 
//				 /** column 정산_근속연수 : clutLogSvcYrNum 에따른 범위 공제금액 구하기 */
//				 if ((new BigDecimal("5")).compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) <= 0) {
//					 
//					 dcTpLogYrDducSum = remtInpt3100Vo.getClutLogSvcYrNum().multiply(new BigDecimal("300000"));
//					 
//				 } else if ((new BigDecimal("10")).compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) <= 0) {
//					 
//					 dcTpLogYrDducSum = (new BigDecimal("1500000")).add( 
//							 (new BigDecimal("500000").multiply(remtInpt3100Vo.getClutLogSvcYrNum().subtract(new BigDecimal("5")))));
//					 
//				 } else if ((new BigDecimal("20")).compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) <= 0) {
//					 
//					 dcTpLogYrDducSum = (new BigDecimal("4000000")).add( 
//							 (new BigDecimal("800000").multiply(remtInpt3100Vo.getClutLogSvcYrNum().subtract(new BigDecimal("10")))));
//					 
//				 } else {
//					 
//					 dcTpLogYrDducSum = (new BigDecimal("12000000")).add( 
//							 (new BigDecimal("1200000").multiply(remtInpt3100Vo.getClutLogSvcYrNum().subtract(new BigDecimal("20")))));
//				 }
//				   
//				 //한도액과 비교하여 금액적용
//				 if (dcTpLogYrDducSum.compareTo(dcLogYrDducLimit) > 0) {
//					 remtInpt3100Vo.setLogYrDducSum(dcLogYrDducLimit);    /** column 근속년수공제_정산금액 : logYrDducSum */ 
//				 } else {
//					 remtInpt3100Vo.setLogYrDducSum(dcTpLogYrDducSum);    /** column 근속년수공제_정산금액 : logYrDducSum */
//				 }
//				 
//				 
//				 /**
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 * 퇴직소득과세표준계산  - 퇴직소득과세표준 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */
//				 BigDecimal dcRetryTxtnStdClutSum = BigDecimal.ZERO; //퇴직소득과세표준_정산금액 
//				 
//				
//				 dcRetryTxtnStdClutSum = (remtInpt3100Vo.getRetryIncmClutSum().subtract(remtInpt3100Vo.getRetryFxrtDducClutSum())).subtract(remtInpt3100Vo.getLogYrDducSum());
//				 //-인경우 처리 
//				 if (dcRetryTxtnStdClutSum.compareTo(BigDecimal.ZERO) > 0) {
//					 remtInpt3100Vo.setRetryTxtnStdClutSum(dcRetryTxtnStdClutSum.setScale(0,1));    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//				 } else {
//					 remtInpt3100Vo.setRetryTxtnStdClutSum(BigDecimal.ZERO);    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//				 }
//				 
//				 /**
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 * 퇴직소득세액계산 - 과세표준안분(30 * 각근속연수 / 정산근속년수) 2012전 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */ 
//				 
//				 BigDecimal dcTat12befTxtnStdPpnlSum = BigDecimal.ZERO; //세액_2012전_과세표준안분금액
//				 BigDecimal dcTat12befYravgTxstdSum = BigDecimal.ZERO; //세액_2012전_연평균과세표준금액
//				 
//				 BigDecimal dcTat12befYrAvgCalcAmnt = BigDecimal.ZERO; //세액_2012전_연평균산출세액
//				 BigDecimal dcTat12befCalcTxAmnt = BigDecimal.ZERO; //세액_2012전_산출세액
//				 
//				 //세액_2012전_과세표준안분금액  - round 처리 
//				
//				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) <= 0) {
//					 
//					 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl12befLogYrNum()) <= 0) {
//						
//						 dcTat12befTxtnStdPpnlSum = (remtInpt3100Vo.getRetryTxtnStdClutSum().multiply((remtInpt3100Vo.getLogPpnl12befLogYrNum().divide(remtInpt3100Vo.getClutLogSvcYrNum())))).setScale(0,0);
//					 
//					 } else {
//						 dcTat12befTxtnStdPpnlSum =  BigDecimal.ZERO;
//					 }
//					 
//				 } else {
//					 dcTat12befTxtnStdPpnlSum = BigDecimal.ZERO;
//				 }
//				  
//				 remtInpt3100Vo.setTat12befTxtnStdPpnlSum(dcTat12befTxtnStdPpnlSum);    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//				 
//				//세액_2012전_연평균과세표준금액
//				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl12befLogYrNum()) <= 0) {
//						
//					 dcTat12befYravgTxstdSum = remtInpt3100Vo.getTat12befTxtnStdPpnlSum().divide(remtInpt3100Vo.getLogPpnl12befLogYrNum(),0,1);
//				 
//				 } else {
//					 dcTat12befYravgTxstdSum =  BigDecimal.ZERO;
//				 } 
//				 remtInpt3100Vo.setTat12befYravgTxstdSum(dcTat12befYravgTxstdSum);      /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
//				  
//				//세액_2012전_연평균산출세액 round down 
//				 
//				 //기본세율적용 
//				 
//				 if ((new BigDecimal("12000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) <= 0) {
//					 //6%
//					 dcTat12befYrAvgCalcAmnt = remtInpt3100Vo.getTat12befYravgTxstdSum().multiply(new BigDecimal("0.06"));
//							 
//				 } else if ((new BigDecimal("46000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) <= 0) {
//					 
//					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("720000")).add(
//							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("12000000"))).multiply(new BigDecimal("0.15")));
//					 
//				 } else if ((new BigDecimal("88000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) <= 0) {
//					 
//					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("5820000")).add(
//							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("46000000"))).multiply(new BigDecimal("0.24")));
//					 
//				 } else if ((new BigDecimal("150000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) <= 0) {
//					 
//					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("15900000")).add(
//							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("88000000"))).multiply(new BigDecimal("0.35")));
//					 
//				 } else  {
//					//1억 5천만원 초과 금액 
//					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("37600000")).add(
//							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("150000000"))).multiply(new BigDecimal("0.38")));
//				 } 
//				 
//				 remtInpt3100Vo.setTat12befYrAvgCalcAmnt(dcTat12befYrAvgCalcAmnt.setScale(0, 1));      /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//				 
//				//세액_2012전_산출세액 
//				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl12befLogYrNum()) <= 0) {
//						
//					 dcTat12befCalcTxAmnt = remtInpt3100Vo.getTat12befYrAvgCalcAmnt().multiply(remtInpt3100Vo.getLogPpnl12befLogYrNum());
//				 
//				 } else {
//					 dcTat12befCalcTxAmnt =  BigDecimal.ZERO;
//				 } 
//				 
//				 
//				 remtInpt3100Vo.setTat12befCalcTxAmnt(dcTat12befCalcTxAmnt);            /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
//				 
//				//나머지처리  
//				 remtInpt3100Vo.setTat12befCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
//				 remtInpt3100Vo.setTat12befCvsnCalcAmnt(BigDecimal.ZERO);        /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */ 
//				// remtInpt3100Vo.setTat12befAlpayTxAmnt(BigDecimal.ZERO);          /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
//				 remtInpt3100Vo.setTat12befRegTgtTxAmnt(BigDecimal.ZERO);        /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
//				 
//				 
//				 /**
//			  		 * -------------------------------------------------------------------------------------------------
//			  		 * 퇴직소득세액계산 - 과세표준안분(30 * 각근속연수 / 정산근속년수) 2013이후 
//			  		 * -------------------------------------------------------------------------------------------------
//			  		 */  
//				 
//				 
//				   // 세액_2013후_과세표준안분금액
//				    BigDecimal dcTat13afrTxstdPpnlSum = BigDecimal.ZERO; //세액_2013후_과세표준안분금액
//				 
//				    
//				    if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) <= 0) {
//						 
//				    	 dcTat13afrTxstdPpnlSum = remtInpt3100Vo.getRetryTxtnStdClutSum().subtract(remtInpt3100Vo.getTat12befTxtnStdPpnlSum());
//						 
//					 } else {
//						 dcTat13afrTxstdPpnlSum = BigDecimal.ZERO;
//					 }
//				     
//				    
//				    remtInpt3100Vo.setTat13afrTxstdPpnlSum(dcTat13afrTxstdPpnlSum);    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//				     
//				    
//				    //세액_2013후_연평균과세표준금액
//				    BigDecimal dcTat13afrYrAvgStdSum = BigDecimal.ZERO; //세액_2013후_연평균과세표준금액
//				    
//				    
//				    if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getTat13afrTxstdPpnlSum()) <= 0) {
//						
//						 dcTat12befYravgTxstdSum = remtInpt3100Vo.getTat13afrTxstdPpnlSum().divide(remtInpt3100Vo.getLogPpnl13afrLogSvc(),0,1);
//					 
//					 } else {
//						 dcTat12befYravgTxstdSum =  BigDecimal.ZERO;
//					 } 
//				     
//					remtInpt3100Vo.setTat13afrYrAvgStdSum(dcTat13afrYrAvgStdSum);    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
//					
//					
//					//세액_2013후_환산과세표준금액
//				    BigDecimal dcTat13afrCvsnTxtnStdSum = BigDecimal.ZERO; //세액_2013후_환산과세표준금액
//				    
//				    dcTat13afrCvsnTxtnStdSum = remtInpt3100Vo.getTat13afrYrAvgStdSum().multiply(new BigDecimal("5"));
//				    
//					remtInpt3100Vo.setTat13afrCvsnTxtnStdSum(dcTat13afrCvsnTxtnStdSum);    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//					
//	
//					//세액_2013후_환산산출세액
//				    BigDecimal dcTat13afrCvsnCalcTxAmnt = BigDecimal.ZERO; //세액_2013후_환산산출세액
//				    
//				    
//				    if ((new BigDecimal("12000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) <= 0) {
//						 //6%
//				    	dcTat13afrCvsnCalcTxAmnt = remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().multiply(new BigDecimal("0.06"));
//								 
//					 } else if ((new BigDecimal("46000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) <= 0) {
//						 
//						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("720000")).add(
//								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("12000000"))).multiply(new BigDecimal("0.15")));
//						 
//					 } else if ((new BigDecimal("88000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) <= 0) {
//						 
//						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("5820000")).add(
//								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("46000000"))).multiply(new BigDecimal("0.24")));
//						 
//					 } else if ((new BigDecimal("150000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) <= 0) {
//						 
//						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("15900000")).add(
//								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("88000000"))).multiply(new BigDecimal("0.35")));
//						 
//					 } else  {
//						//1억 5천만원 초과 금액 
//						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("37600000")).add(
//								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("150000000"))).multiply(new BigDecimal("0.38")));
//					 } 
//					  
//					remtInpt3100Vo.setTat13afrCvsnCalcTxAmnt(dcTat13afrCvsnCalcTxAmnt.setScale(0,1));    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//					
//					
//					
//	
//					//세액_2013후_연평균산출세액
//				    BigDecimal dcTat13afrYrAvgCalcAmnt = BigDecimal.ZERO; //세액_2013후_연평균산출세액
//				    
//				    dcTat13afrYrAvgCalcAmnt = remtInpt3100Vo.getTat13afrCvsnCalcTxAmnt().divide(new BigDecimal("5"), 0, 1);
//				   
//					remtInpt3100Vo.setTat13afrYrAvgCalcAmnt(dcTat13afrYrAvgCalcAmnt);    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//					 
//					
//					//세액_2013후_산출세액
//				    BigDecimal dcTat13afrCalcTxAmnt = BigDecimal.ZERO; //세액_2013후_산출세액
//				    
//				    if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl13afrLogSvc()) <= 0) {
//						 
//				    	dcTat13afrCalcTxAmnt = remtInpt3100Vo.getTat13afrYrAvgCalcAmnt().multiply(remtInpt3100Vo.getLogPpnl13afrLogSvc());
//						 
//					 } else {
//						 dcTat13afrCalcTxAmnt = BigDecimal.ZERO;
//					 } 
//				    
//					remtInpt3100Vo.setTat13afrCalcTxAmnt(dcTat13afrCalcTxAmnt);    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
//					
//					
//					//기타 나머지 부분 처리 
//					//remtInpt3100Vo.setTat13afrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
//					remtInpt3100Vo.setTat13afrRegrstTgtSum(BigDecimal.ZERO);    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
//				 
//				 
//	
//			    /**
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 * 퇴직소득세액계산 - 과세표준안분(30 * 각근속연수 / 정산근속년수)  세액합계 계산....
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */  
//				  
//					
//				remtInpt3100Vo.setTatAggrTxtnStdPpnlSum(remtInpt3100Vo.getTat12befTxtnStdPpnlSum().add(remtInpt3100Vo.getTat13afrTxstdPpnlSum()));    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//				remtInpt3100Vo.setTatAggrYrAvgTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
//				remtInpt3100Vo.setTatAggrCvsnTxtnStdSum(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum());    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//				remtInpt3100Vo.setTatAggrCvsnCalcTxAmnt(remtInpt3100Vo.getTat13afrCvsnCalcTxAmnt());    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//				remtInpt3100Vo.setTatAggrYrAvgCalcTxAmnt(remtInpt3100Vo.getTat12befYrAvgCalcAmnt().add(remtInpt3100Vo.getTat13afrYrAvgCalcAmnt()));    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//				remtInpt3100Vo.setTatAggrCalcTxAmnt(remtInpt3100Vo.getTat12befCalcTxAmnt().add(remtInpt3100Vo.getTat13afrCalcTxAmnt()));    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
//				
//				//TODO - 기납부세액은 등록된 데이터을 통해서 처리 하려 했으나 문제있음.기납부세액적용 출력시에는 안보이게 내부적사용 
//				remtInpt3100Vo.setTatAggrAlpayTxAmnt(remtInpt3100Vo.getTat12befAlpayTxAmnt().add(remtInpt3100Vo.getTat13afrAlpayTxAmnt()));    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
//				remtInpt3100Vo.setTatAggrRegrstTgtTxAmnt(remtInpt3100Vo.getTatAggrCalcTxAmnt().subtract(remtInpt3100Vo.getTatAggrAlpayTxAmnt()));    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
//				
//				
//				/**
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 * 이연퇴직소득세액계산  -  신고대상세액 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */   
//			 
//				remtInpt3100Vo.setTalRegrstTgtTxAmnt(remtInpt3100Vo.getTatAggrRegrstTgtTxAmnt());    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
//				
//				//remtInpt3100Vo.setTalAccuDepitAggrSum(remtInpt3100Vo.getTalAccuDepitAggrSum());    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
//				remtInpt3100Vo.setTalRetryPayQnty(remtInpt3100Vo.getEndTxtnTgtRetryPayQnty());    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
//			
//				
//				/** -------------------------------------------------------------------------------------------------
//		  		 * 이연퇴직소득세액계산  -  이연퇴직소득세 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */ 
//				 BigDecimal dcTalRetryIncmTxAmnt = BigDecimal.ZERO; //세액_2013후_산출세액
//				 
//				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getTalRegrstTgtTxAmnt()) >= 0 ) {
//					 dcTalRetryIncmTxAmnt = BigDecimal.ZERO;
//				 } else {
//					 dcTalRetryIncmTxAmnt = remtInpt3100Vo.getTalRegrstTgtTxAmnt().multiply((remtInpt3100Vo.getTalAccuDepitAggrSum().divide(remtInpt3100Vo.getTalRetryPayQnty()))).setScale(0,0);
//				 }
//				
//				 if (BigDecimal.ZERO.compareTo(dcTalRetryIncmTxAmnt) >= 0 ) {
//					 dcTalRetryIncmTxAmnt = BigDecimal.ZERO;
//				 }  
//				 
//				
//				 remtInpt3100Vo.setTalRetryIncmTxAmnt(dcTalRetryIncmTxAmnt);    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
//				
//				 
//				/** -------------------------------------------------------------------------------------------------
//		  		 * 납부명세 신고대상세액 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */ 
//				//소득세  
//				remtInpt3100Vo.setPymtRegTgtIncmTxQnty(remtInpt3100Vo.getTatAggrRegrstTgtTxAmnt());    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//				//지방소득세 
//				remtInpt3100Vo.setPymtRegTgtRgonIncmQnty(remtInpt3100Vo.getPymtRegTgtIncmTxQnty().multiply(new BigDecimal("0.1")).setScale(0, 0));    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//				//농어촌특별세
//				remtInpt3100Vo.setPymtRegTgtFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//				//합계
//				remtInpt3100Vo.setPymtRegrstTgtAggrSum(remtInpt3100Vo.getPymtRegTgtIncmTxQnty().add(remtInpt3100Vo.getPymtRegTgtRgonIncmQnty()).add(remtInpt3100Vo.getPymtRegTgtFarvilSpclQnty()));    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//				
//				/** -------------------------------------------------------------------------------------------------
//		  		 * 납부명세 이연퇴직소득세 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */ 
//				//소득세
//				remtInpt3100Vo.setPymtTalcIncmTxQnty(remtInpt3100Vo.getTalRetryIncmTxAmnt());    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
//				//지방소득세
//				remtInpt3100Vo.setPymtTalcRgonIncmTxQnty(remtInpt3100Vo.getPymtTalcIncmTxQnty().multiply(new BigDecimal("0.1")).setScale(0, 0));    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
//				//농어촌특별세
//				remtInpt3100Vo.setPymtTalcFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
//				//합계
//				remtInpt3100Vo.setPymtTxAllcAggrSum(remtInpt3100Vo.getPymtTalcIncmTxQnty().add(remtInpt3100Vo.getPymtTalcRgonIncmTxQnty()).add(remtInpt3100Vo.getPymtTalcFarvilSpclQnty()));    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
//				
//				
//				/** -------------------------------------------------------------------------------------------------
//		  		 * 납부명세 이연퇴직소득세 
//		  		 * -------------------------------------------------------------------------------------------------
//		  		 */ 
//				//소득세
//				remtInpt3100Vo.setPymtSubtnIncmTxQnty((remtInpt3100Vo.getPymtRegTgtIncmTxQnty().subtract(remtInpt3100Vo.getPymtTalcIncmTxQnty())).setScale(-1,1));    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
//				//지방소득세
//				remtInpt3100Vo.setPymtSubtnRgonIncmTxQnty((remtInpt3100Vo.getPymtRegTgtRgonIncmQnty().subtract(remtInpt3100Vo.getPymtTalcRgonIncmTxQnty())).setScale(-1,1));    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
//				
//				//농어촌특별세
//				remtInpt3100Vo.setPymtSubtnFarvilSpclQnty((remtInpt3100Vo.getPymtRegTgtFarvilSpclQnty().subtract(remtInpt3100Vo.getPymtTalcFarvilSpclQnty())).setScale(-1,1));    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
//				//합계
//				remtInpt3100Vo.setPymtSubtnAggrSum(remtInpt3100Vo.getPymtSubtnIncmTxQnty().add(remtInpt3100Vo.getPymtSubtnRgonIncmTxQnty()).add(remtInpt3100Vo.getPymtSubtnFarvilSpclQnty()));    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
//				
//				 
//				/**=================================================================================================
//		  		 * 퇴직정산 저장
//		  		 * =================================================================================================
//		  		 */ 
//				
//				remtCalcService.updateRemt3100(remtInpt3100Vo);
//		  		 
		  	  }
		   	/**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		  	   *  퇴직정산대상자 for문종료 
		  	   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	  	
	  	} catch (Exception ex) {
            ex.printStackTrace();   
    	   ShowMessageBM smBm = new ShowMessageBM();
    	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
    	   smBm.setMenu("Remt");
    	   smBm.setPhase("[퇴직정산]에러");
    	   smBm.setMessage(ex.getLocalizedMessage());
    	   smBm.setContent(ex.getMessage());
    	   bmResult.add(smBm);  
    	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
    	 
       } 
	  	  
//			/** 로그반영
//			 * CRUDSBLO
//			 * C:create		R:read		U:update
//	    	 * D:delete		S:select	B:배치 
//	    	 * L:로그인		O:로그아웃
//	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "R");  
	  	   
	  	  return  retval;
	}
    
    /**
     * 퇴직정산 공통 처리 구현 부 
     * @param request
     * @param remt3100TgtVo
     * @return
     * @throws Exception
     */
    private BigDecimal funcRemtTxCalc(HttpServletRequest request,InfcPkgRemt3100VO remt3100TgtVo)  throws Exception  {
    	
    	
    	String method = calledClass + ".funcRemtTxCalc";
  	      BigDecimal rtnDDucSum = BigDecimal.ZERO;
  	      
	  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	  
	  	  //퇴직금산정테이블
	  	  InfcPkgRemt2000SrhVO remt2000SrhVo = new InfcPkgRemt2000SrhVO(); 
	  	  InfcPkgRemt2000VO remt2000Vo = new InfcPkgRemt2000VO(); 
	  	  //퇴직정산마감등정보
	  	  InfcPkgRemt3000SrhVO remt3000SrhVo = new InfcPkgRemt3000SrhVO();
	  	  InfcPkgRemt3000VO remt3000Vo = new InfcPkgRemt3000VO();
	  	  //퇴직금정산테이블
	  	  InfcPkgRemt3100SrhVO remt3100SrhVo = new InfcPkgRemt3100SrhVO();
	  	  InfcPkgRemt3100VO remtSelect3100Vo = new InfcPkgRemt3100VO();
	  	  //퇴직금연금계좌명세 
	  	  InfcPkgRemt3200SrhVO remt3200SrhVo = new InfcPkgRemt3200SrhVO();
	  	  InfcPkgRemt3200VO remt3200Vo = new InfcPkgRemt3200VO();
	  	  
	  	  //퇴직금계산정보 
	  	  InfcPkgRemt3100VO remtInpt3100Vo = new InfcPkgRemt3100VO();
	  	  
	  	  try { 
	   
		  	   if  (remtCalcService == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               remtCalcService = (RetirementCalculstionService) wac.getBean("RetirementCalculstionService" ); 
	              
	          }
	  	   
			   if  (remtPayrService == null) { 
	               WebApplicationContext wac = WebApplicationContextUtils.
	                       getRequiredWebApplicationContext( request.getSession().getServletContext());
	   
	               remtPayrService = (RetirementPayrService) wac.getBean("RetirementPayrService" ); 
	              
	          }
	  	  //1. 퇴직금산정금액테이블의 값을 가져옴 REMT2000
	  	   
	  	  //2. 퇴직정산 테이블 데이터를 가져옴.  REMT3100
	  	   
		  	  /**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		  	   *  퇴직정산대상자 for문시작 
		  	   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		  	 
		  		
		  		//퇴직정산 검색조건에 따른 값가져오기 
		  		InfcPkgRemt3100VO tpRemt3100Vo = new InfcPkgRemt3100VO();
		  		 
		  		tpRemt3100Vo.setDpobCd(remt3100TgtVo.getDpobCd());    /** column 사업장코드 : dpobCd */
		  		tpRemt3100Vo.setClutYrMnth(remt3100TgtVo.getClutYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
		  		tpRemt3100Vo.setCalcSevePayPsnDivCd(remt3100TgtVo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  		tpRemt3100Vo.setSystemkey(remt3100TgtVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		  		
		  		remtSelect3100Vo = remtCalcService.selectRemt3100(tpRemt3100Vo); 
		  		 
		  		
//		  		if (MSFSharedUtils.paramNull(remtSelect3100Vo) ) {
//		  			 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"remt","[퇴직정산]" + String.valueOf(listVoPsnl0100.size()) + "명처리중","퇴직정산내역이존재하지않음","퇴직금계산처리후실행하십시요."));  
//		  		}
		  		
		  		BeanUtils.copyProperties(remtInpt3100Vo, remtSelect3100Vo);   //입력을위해 조회값을 입력값에 대입
		  		
		  		/**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 근속년수 구하기 시작 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */
		  		 InfcPkgRemt3100VO eepnRemt3100Vo = new InfcPkgRemt3100VO();
		  		 
		  		eepnRemt3100Vo.setDpobCd(remt3100TgtVo.getDpobCd());    /** column 사업장코드 : dpobCd */
		  		eepnRemt3100Vo.setCalcSevePsnBlggYrMnth(remt3100TgtVo.getCalcSevePsnBlggYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
		  		eepnRemt3100Vo.setCalcSevePayPsnDivCd(remt3100TgtVo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
		  		eepnRemt3100Vo.setSystemkey(remt3100TgtVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		  		 
		  		 
		  		 eepnRemt3100Vo = remtCalcService.selectRemt3100EepnYrIcm(eepnRemt3100Vo); 
		  		  
//					remtInpt3100Vo.setDpobCd(eepnRemt3100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//					remtInpt3100Vo.setCalcSevePsnBlggYrMnth(eepnRemt3100Vo.getCalcSevePsnBlggYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//					remtInpt3100Vo.setCalcSevePsnBlggYrMnth(eepnRemt3100Vo.getCalcSevePsnBlggYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//					remtInpt3100Vo.setCalcSevePayPsnDivCd(eepnRemt3100Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//					remtInpt3100Vo.setSystemkey(eepnRemt3100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//					remtInpt3100Vo.setDeptCd(eepnRemt3100Vo.getDeptCd());    /** column 부서코드 : deptCd */
//					remtInpt3100Vo.setHanNm(eepnRemt3100Vo.getHanNm());    /** column 한글성명 : hanNm */
//					remtInpt3100Vo.setResnRegnNum(eepnRemt3100Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//					remtInpt3100Vo.setAimenrEcteYn(eepnRemt3100Vo.getAimenrEcteYn());    /** column 소득자임원여부 : aimenrEcteYn */
//					remtInpt3100Vo.setFixPayJnDt(eepnRemt3100Vo.getFixPayJnDt());    /** column 확정급여형가입일자 : fixPayJnDt */
//					remtInpt3100Vo.setSevePay20111231Sum(eepnRemt3100Vo.getSevePay20111231Sum());    /** column 퇴직금_20111231금액 : sevePay20111231Sum */
//					remtInpt3100Vo.setFrgnrDivCd(eepnRemt3100Vo.getFrgnrDivCd());    /** column 외국인구분코드 : frgnrDivCd */
//					remtInpt3100Vo.setRidnSeptYn(eepnRemt3100Vo.getRidnSeptYn());    /** column 거주구분여부 : ridnSeptYn */
//					remtInpt3100Vo.setRidnCd(eepnRemt3100Vo.getRidnCd());    /** column 거주지국코드 : ridnCd */
//					remtInpt3100Vo.setRidnNm(eepnRemt3100Vo.getRidnNm());    /** column 거주지국명 : ridnNm */
//					remtInpt3100Vo.setBlggYrBgnnDt(eepnRemt3100Vo.getBlggYrBgnnDt());    /** column 귀속년도시작일자 : blggYrBgnnDt */
//					remtInpt3100Vo.setBlggYrEndDt(eepnRemt3100Vo.getBlggYrEndDt());    /** column 귀속년도종료일자 : blggYrEndDt */
//					remtInpt3100Vo.setRetryReasCd(eepnRemt3100Vo.getRetryReasCd());    /** column 퇴직사유코드 : retryReasCd */
//					remtInpt3100Vo.setCtrBusoprRgstnNum(eepnRemt3100Vo.getCtrBusoprRgstnNum());    /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
//					remtInpt3100Vo.setCtrPaeWorkNm(eepnRemt3100Vo.getCtrPaeWorkNm());    /** column 중_근무처명 : ctrPaeWorkNm */
//					remtInpt3100Vo.setCtrRetryPayQnty(eepnRemt3100Vo.getCtrRetryPayQnty());    /** column 중_퇴직급여액 : ctrRetryPayQnty */
//					remtInpt3100Vo.setCtrFreeDtyRetryPayQnty(eepnRemt3100Vo.getCtrFreeDtyRetryPayQnty());    /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
//					remtInpt3100Vo.setCtrTxtnTgtRetryPayQnty(eepnRemt3100Vo.getCtrTxtnTgtRetryPayQnty());    /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
//					remtInpt3100Vo.setEndBusoprRgstnNum(eepnRemt3100Vo.getEndBusoprRgstnNum());    /** column 종_사업자등록번호 : endBusoprRgstnNum */
//					remtInpt3100Vo.setEndPaeWorkNm(eepnRemt3100Vo.getEndPaeWorkNm());    /** column 종_근무처명 : endPaeWorkNm */
//					remtInpt3100Vo.setEndRetryPayQnty(eepnRemt3100Vo.getEndRetryPayQnty());    /** column 종_퇴직급여액 : endRetryPayQnty */
//					remtInpt3100Vo.setEndFreeDtyRetryPayQnty(eepnRemt3100Vo.getEndFreeDtyRetryPayQnty());    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
//					remtInpt3100Vo.setEndTxtnTgtRetryPayQnty(eepnRemt3100Vo.getEndTxtnTgtRetryPayQnty());    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
//					remtInpt3100Vo.setClutRetryPayQnty(eepnRemt3100Vo.getClutRetryPayQnty());    /** column 정산_퇴직급여액 : clutRetryPayQnty */
//					remtInpt3100Vo.setClutFreeDtyRetryPayQnty(eepnRemt3100Vo.getClutFreeDtyRetryPayQnty());    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
//					remtInpt3100Vo.setClutTxtnTgtRetryPayQnty(eepnRemt3100Vo.getClutTxtnTgtRetryPayQnty());    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
//					remtInpt3100Vo.setCtrIcncDt(eepnRemt3100Vo.getCtrIcncDt());    /** column 중_입사일자 : ctrIcncDt */
//					remtInpt3100Vo.setCtrRkfcdDt(eepnRemt3100Vo.getCtrRkfcdDt());    /** column 중_기산일자 : ctrRkfcdDt */
//					remtInpt3100Vo.setCtrRsgtnDt(eepnRemt3100Vo.getCtrRsgtnDt());    /** column 중_퇴사일자 : ctrRsgtnDt */
//					remtInpt3100Vo.setCtrPymtDt(eepnRemt3100Vo.getCtrPymtDt());    /** column 중_지급일자 : ctrPymtDt */
//					remtInpt3100Vo.setCtrLogSvcMnthIcm(eepnRemt3100Vo.getCtrLogSvcMnthIcm());    /** column 중_근속월수 : ctrLogSvcMnthIcm */
//					remtInpt3100Vo.setCtrEepnMnth12Bfr(eepnRemt3100Vo.getCtrEepnMnth12Bfr());    /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
//					remtInpt3100Vo.setCtrEepnMnth13Aft(eepnRemt3100Vo.getCtrEepnMnth13Aft());    /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
//					remtInpt3100Vo.setCtrAddMnth12Bfr(eepnRemt3100Vo.getCtrAddMnth12Bfr());    /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
//					remtInpt3100Vo.setCtrAddMnth13Aft(eepnRemt3100Vo.getCtrAddMnth13Aft());    /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
//					remtInpt3100Vo.setCtrEepnMnthIcm(eepnRemt3100Vo.getCtrEepnMnthIcm());    /** column 중_제외월수 : ctrEepnMnthIcm */
//					remtInpt3100Vo.setCtrAddMnthIcm(eepnRemt3100Vo.getCtrAddMnthIcm());    /** column 중_가산월수 : ctrAddMnthIcm */
//					remtInpt3100Vo.setCtrDupMnthIcm(eepnRemt3100Vo.getCtrDupMnthIcm());    /** column 중_중복월수 : ctrDupMnthIcm */
//					remtInpt3100Vo.setCtrLogSvc(eepnRemt3100Vo.getCtrLogSvc());    /** column 중_근속연수 : ctrLogSvc */
//					remtInpt3100Vo.setEndIcncDt(eepnRemt3100Vo.getEndIcncDt());    /** column 종_입사일자 : endIcncDt */
//					remtInpt3100Vo.setEndRkfcdDt(eepnRemt3100Vo.getEndRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
//					remtInpt3100Vo.setEndRsgtnDt(eepnRemt3100Vo.getEndRsgtnDt());    /** column 종_퇴사일자 : endRsgtnDt */
//					remtInpt3100Vo.setEndPymtDt(eepnRemt3100Vo.getEndPymtDt());    /** column 종_지급일자 : endPymtDt */
//					remtInpt3100Vo.setEndLogSvcMnthIcm(eepnRemt3100Vo.getEndLogSvcMnthIcm());    /** column 종_근속월수 : endLogSvcMnthIcm */
//					remtInpt3100Vo.setEndEepnMnth12Bfr(eepnRemt3100Vo.getEndEepnMnth12Bfr());    /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
//					remtInpt3100Vo.setEndEepnMnth13Aft(eepnRemt3100Vo.getEndEepnMnth13Aft());    /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
//					remtInpt3100Vo.setEndAddMnth12Bfr(eepnRemt3100Vo.getEndAddMnth12Bfr());    /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
//					remtInpt3100Vo.setEndAddMnth13Aft(eepnRemt3100Vo.getEndAddMnth13Aft());    /** column 종_가산월수_2013이후 : endAddMnth13Aft */
					remtInpt3100Vo.setEndEepnMnthIcm(eepnRemt3100Vo.getEndEepnMnthIcm());    /** column 종_제외월수 : endEepnMnthIcm */
					remtInpt3100Vo.setEndAddMnthIcm(eepnRemt3100Vo.getEndAddMnthIcm());    /** column 종_가산월수 : endAddMnthIcm */
					remtInpt3100Vo.setEndDupMnthIcm(eepnRemt3100Vo.getEndDupMnthIcm());    /** column 종_중복월수 : endDupMnthIcm */
					remtInpt3100Vo.setEndLogSvcYrNum(eepnRemt3100Vo.getEndLogSvcYrNum());    /** column 종_근속연수 : endLogSvcYrNum */
					//remtInpt3100Vo.setClutIcncDt(eepnRemt3100Vo.getClutIcncDt());    /** column 정산_입사일자 : clutIcncDt */
					remtInpt3100Vo.setClutRkfcdDt(eepnRemt3100Vo.getClutRkfcdDt());    /** column 정산-기산일자 : clutRkfcdDt */
					remtInpt3100Vo.setClutRsgtnDt(eepnRemt3100Vo.getClutRsgtnDt());    /** column 정산_퇴사일자 : clutRsgtnDt */
					//remtInpt3100Vo.setClutPymtDt(eepnRemt3100Vo.getClutPymtDt());    /** column 정산_지급일자 : clutPymtDt */
					remtInpt3100Vo.setClutLogSvcMnthIcm(eepnRemt3100Vo.getClutLogSvcMnthIcm());    /** column 정산_근속월수 : clutLogSvcMnthIcm */
					remtInpt3100Vo.setClutEepnMnthIcm(eepnRemt3100Vo.getClutEepnMnthIcm());    /** column 정산_제외월수 : clutEepnMnthIcm */
					remtInpt3100Vo.setClutAddMnthIcm(eepnRemt3100Vo.getClutAddMnthIcm());    /** column 정산_가산월수 : clutAddMnthIcm */
					remtInpt3100Vo.setClutDupMnthIcm(eepnRemt3100Vo.getClutDupMnthIcm());    /** column 정산_중복월수 : clutDupMnthIcm */
					remtInpt3100Vo.setClutLogSvcYrNum(eepnRemt3100Vo.getClutLogSvcYrNum());    /** column 정산_근속연수 : clutLogSvcYrNum */
					remtInpt3100Vo.setLogPpnl12befIcncDt(eepnRemt3100Vo.getLogPpnl12befIcncDt());    /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
					remtInpt3100Vo.setLogPpnl12befRkfcdDt(eepnRemt3100Vo.getLogPpnl12befRkfcdDt());    /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
					remtInpt3100Vo.setLogPpnl12befRsgtnDt(eepnRemt3100Vo.getLogPpnl12befRsgtnDt());    /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
					//remtInpt3100Vo.setLogPpnl12befPymtDt(eepnRemt3100Vo.getLogPpnl12befPymtDt());    /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
					remtInpt3100Vo.setLogPpnl12befLogMnthIcm(eepnRemt3100Vo.getLogPpnl12befLogMnthIcm());    /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
					remtInpt3100Vo.setLogPpnl12befEepnMnthIcm(eepnRemt3100Vo.getLogPpnl12befEepnMnthIcm());    /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
					remtInpt3100Vo.setLogPpnl12befAddMnthIcm(eepnRemt3100Vo.getLogPpnl12befAddMnthIcm());    /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
				//	remtInpt3100Vo.setLogPpnl12befDupMnthIcm(eepnRemt3100Vo.getLogPpnl12befDupMnthIcm());    /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
					remtInpt3100Vo.setLogPpnl12befLogYrNum(eepnRemt3100Vo.getLogPpnl12befLogYrNum());    /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
					remtInpt3100Vo.setLogPpnl13afrIcncDt(eepnRemt3100Vo.getLogPpnl13afrIcncDt());    /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
					remtInpt3100Vo.setLogPpnl13afrRkfcdDt(eepnRemt3100Vo.getLogPpnl13afrRkfcdDt());    /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
					remtInpt3100Vo.setLogPpnl13afrRsgtnDt(eepnRemt3100Vo.getLogPpnl13afrRsgtnDt());    /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
					//remtInpt3100Vo.setLogPpnl13afrPymtDt(eepnRemt3100Vo.getLogPpnl13afrPymtDt());    /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
					remtInpt3100Vo.setLogPpnl13afrLogMnthIcm(eepnRemt3100Vo.getLogPpnl13afrLogMnthIcm());    /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
					remtInpt3100Vo.setLogPpnl13afrEepnMnthIcm(eepnRemt3100Vo.getLogPpnl13afrEepnMnthIcm());    /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
					remtInpt3100Vo.setLogPpnl13afrAddMnthIcm(eepnRemt3100Vo.getLogPpnl13afrAddMnthIcm());    /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
					//remtInpt3100Vo.setLogPpnl13afrDupMnthIcm(eepnRemt3100Vo.getLogPpnl13afrDupMnthIcm());    /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
					remtInpt3100Vo.setLogPpnl13afrLogSvc(eepnRemt3100Vo.getLogPpnl13afrLogSvc());    /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
//					remtInpt3100Vo.setRetryIncmCtrPymtSum(eepnRemt3100Vo.getRetryIncmCtrPymtSum());    /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
//					remtInpt3100Vo.setRetryIncmEndPymtSum(eepnRemt3100Vo.getRetryIncmEndPymtSum());    /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
//					remtInpt3100Vo.setRetryIncmClutSum(eepnRemt3100Vo.getRetryIncmClutSum());    /** column 퇴직소득_정산금액 : retryIncmClutSum */
//					remtInpt3100Vo.setRetryFxrtDducClutSum(eepnRemt3100Vo.getRetryFxrtDducClutSum());    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
//					remtInpt3100Vo.setLogYrDducSum(eepnRemt3100Vo.getLogYrDducSum());    /** column 근속년수공제_정산금액 : logYrDducSum */
//					remtInpt3100Vo.setRetryTxtnStdClutSum(eepnRemt3100Vo.getRetryTxtnStdClutSum());    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//					remtInpt3100Vo.setTat12befTxtnStdPpnlSum(eepnRemt3100Vo.getTat12befTxtnStdPpnlSum());    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//					remtInpt3100Vo.setTat12befYravgTxstdSum(eepnRemt3100Vo.getTat12befYravgTxstdSum());    /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
//					remtInpt3100Vo.setTat12befCvsnTxtnStdSum(eepnRemt3100Vo.getTat12befCvsnTxtnStdSum());    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
//					remtInpt3100Vo.setTat12befCvsnCalcAmnt(eepnRemt3100Vo.getTat12befCvsnCalcAmnt());    /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
//					remtInpt3100Vo.setTat12befYrAvgCalcAmnt(eepnRemt3100Vo.getTat12befYrAvgCalcAmnt());    /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//					remtInpt3100Vo.setTat12befCalcTxAmnt(eepnRemt3100Vo.getTat12befCalcTxAmnt());    /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
//					remtInpt3100Vo.setTat12befAlpayTxAmnt(eepnRemt3100Vo.getTat12befAlpayTxAmnt());    /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
//					remtInpt3100Vo.setTat12befRegTgtTxAmnt(eepnRemt3100Vo.getTat12befRegTgtTxAmnt());    /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
//					remtInpt3100Vo.setTat13afrTxstdPpnlSum(eepnRemt3100Vo.getTat13afrTxstdPpnlSum());    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//					remtInpt3100Vo.setTat13afrYrAvgStdSum(eepnRemt3100Vo.getTat13afrYrAvgStdSum());    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
//					remtInpt3100Vo.setTat13afrCvsnTxtnStdSum(eepnRemt3100Vo.getTat13afrCvsnTxtnStdSum());    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//					remtInpt3100Vo.setTat13afrCvsnCalcTxAmnt(eepnRemt3100Vo.getTat13afrCvsnCalcTxAmnt());    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//					remtInpt3100Vo.setTat13afrYrAvgCalcAmnt(eepnRemt3100Vo.getTat13afrYrAvgCalcAmnt());    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//					remtInpt3100Vo.setTat13afrCalcTxAmnt(eepnRemt3100Vo.getTat13afrCalcTxAmnt());    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
//					remtInpt3100Vo.setTat13afrAlpayTxAmnt(eepnRemt3100Vo.getTat13afrAlpayTxAmnt());    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
//					remtInpt3100Vo.setTat13afrRegrstTgtSum(eepnRemt3100Vo.getTat13afrRegrstTgtSum());    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
//					remtInpt3100Vo.setTatAggrTxtnStdPpnlSum(eepnRemt3100Vo.getTatAggrTxtnStdPpnlSum());    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//					remtInpt3100Vo.setTatAggrYrAvgTxtnStdSum(eepnRemt3100Vo.getTatAggrYrAvgTxtnStdSum());    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
//					remtInpt3100Vo.setTatAggrCvsnTxtnStdSum(eepnRemt3100Vo.getTatAggrCvsnTxtnStdSum());    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//					remtInpt3100Vo.setTatAggrCvsnCalcTxAmnt(eepnRemt3100Vo.getTatAggrCvsnCalcTxAmnt());    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//					remtInpt3100Vo.setTatAggrYrAvgCalcTxAmnt(eepnRemt3100Vo.getTatAggrYrAvgCalcTxAmnt());    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//					remtInpt3100Vo.setTatAggrCalcTxAmnt(eepnRemt3100Vo.getTatAggrCalcTxAmnt());    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
//					remtInpt3100Vo.setTatAggrAlpayTxAmnt(eepnRemt3100Vo.getTatAggrAlpayTxAmnt());    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
//					remtInpt3100Vo.setTatAggrRegrstTgtTxAmnt(eepnRemt3100Vo.getTatAggrRegrstTgtTxAmnt());    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
//					remtInpt3100Vo.setTalRegrstTgtTxAmnt(eepnRemt3100Vo.getTalRegrstTgtTxAmnt());    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
//					remtInpt3100Vo.setTalAccuDepitAggrSum(eepnRemt3100Vo.getTalAccuDepitAggrSum());    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
//					remtInpt3100Vo.setTalRetryPayQnty(eepnRemt3100Vo.getTalRetryPayQnty());    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
//					remtInpt3100Vo.setTalRetryIncmTxAmnt(eepnRemt3100Vo.getTalRetryIncmTxAmnt());    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
//					remtInpt3100Vo.setPymtRegTgtIncmTxQnty(eepnRemt3100Vo.getPymtRegTgtIncmTxQnty());    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//					remtInpt3100Vo.setPymtRegTgtRgonIncmQnty(eepnRemt3100Vo.getPymtRegTgtRgonIncmQnty());    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//					remtInpt3100Vo.setPymtRegTgtFarvilSpclQnty(eepnRemt3100Vo.getPymtRegTgtFarvilSpclQnty());    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//					remtInpt3100Vo.setPymtRegrstTgtAggrSum(eepnRemt3100Vo.getPymtRegrstTgtAggrSum());    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//					remtInpt3100Vo.setPymtTalcIncmTxQnty(eepnRemt3100Vo.getPymtTalcIncmTxQnty());    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
//					remtInpt3100Vo.setPymtTalcRgonIncmTxQnty(eepnRemt3100Vo.getPymtTalcRgonIncmTxQnty());    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
//					remtInpt3100Vo.setPymtTalcFarvilSpclQnty(eepnRemt3100Vo.getPymtTalcFarvilSpclQnty());    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
//					remtInpt3100Vo.setPymtTxAllcAggrSum(eepnRemt3100Vo.getPymtTxAllcAggrSum());    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
//					remtInpt3100Vo.setPymtSubtnIncmTxQnty(eepnRemt3100Vo.getPymtSubtnIncmTxQnty());    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
//					remtInpt3100Vo.setPymtSubtnRgonIncmTxQnty(eepnRemt3100Vo.getPymtSubtnRgonIncmTxQnty());    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
//					remtInpt3100Vo.setPymtSubtnFarvilSpclQnty(eepnRemt3100Vo.getPymtSubtnFarvilSpclQnty());    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
//					remtInpt3100Vo.setPymtSubtnAggrSum(eepnRemt3100Vo.getPymtSubtnAggrSum());    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
//					remtInpt3100Vo.setKybdr(eepnRemt3100Vo.getKybdr());    /** column 입력자 : kybdr */
//					remtInpt3100Vo.setInptDt(eepnRemt3100Vo.getInptDt());    /** column 입력일자 : inptDt */
//					remtInpt3100Vo.setInptAddr(eepnRemt3100Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//					remtInpt3100Vo.setIsmt(eepnRemt3100Vo.getIsmt());    /** column 수정자 : ismt */
//					remtInpt3100Vo.setRevnDt(eepnRemt3100Vo.getRevnDt());    /** column 수정일자 : revnDt */
//					remtInpt3100Vo.setRevnAddr(eepnRemt3100Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
					

		  		/**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 근속년수 구하기 종료 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */
		  		
		  		/**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 퇴직소득과세표준계산 - 퇴직소득에 따른 퇴직소득정률공제 계산 현재 40% - 2016년도 차등적용으로 변환  round 처리 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */
		  		//정산 합산 -----
		  		remtInpt3100Vo.setRetryIncmClutSum(remtInpt3100Vo.getCtrTxtnTgtRetryPayQnty().add(remtInpt3100Vo.getEndTxtnTgtRetryPayQnty()));
				
		  		remtInpt3100Vo.setRetryFxrtDducClutSum(((remtInpt3100Vo.getRetryIncmClutSum().multiply(new BigDecimal("0.40"))).setScale(0, 0)));    /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
		  		 
				/**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 퇴직소득과세표준계산  - 근속년수공제
		  		 * -------------------------------------------------------------------------------------------------
		  		 */
				 BigDecimal dcLogYrDducSum = BigDecimal.ZERO; //근속년수공제_정산금액 
				 BigDecimal dcTpLogYrDducSum = BigDecimal.ZERO; //근속년수공제_정산금액 
				 BigDecimal dcLogYrDducLimit = BigDecimal.ZERO; //근속년수공제_한도금액 
				 
				 
				 dcLogYrDducLimit = remtInpt3100Vo.getRetryIncmClutSum().subtract(remtInpt3100Vo.getRetryFxrtDducClutSum());   //한도액 
				 
				 
				 /** column 정산_근속연수 : clutLogSvcYrNum 에따른 범위 공제금액 구하기 */
				 if ((new BigDecimal("5")).compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) >= 0) {
					 
					 dcTpLogYrDducSum = remtInpt3100Vo.getClutLogSvcYrNum().multiply(new BigDecimal("300000"));
					 
				 } else if ((new BigDecimal("10")).compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) >= 0) {
					 
					 dcTpLogYrDducSum = (new BigDecimal("1500000")).add( 
							 (new BigDecimal("500000").multiply(remtInpt3100Vo.getClutLogSvcYrNum().subtract(new BigDecimal("5")))));
					 
				 } else if ((new BigDecimal("20")).compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) >= 0) {
					 
					 dcTpLogYrDducSum = (new BigDecimal("4000000")).add( 
							 (new BigDecimal("800000").multiply(remtInpt3100Vo.getClutLogSvcYrNum().subtract(new BigDecimal("10")))));
					 
				 } else {
					 
					 dcTpLogYrDducSum = (new BigDecimal("12000000")).add( 
							 (new BigDecimal("1200000").multiply(remtInpt3100Vo.getClutLogSvcYrNum().subtract(new BigDecimal("20")))));
				 }
				   
				 //한도액과 비교하여 금액적용
				 if (dcTpLogYrDducSum.compareTo(dcLogYrDducLimit) > 0) {
					 remtInpt3100Vo.setLogYrDducSum(dcLogYrDducLimit);    /** column 근속년수공제_정산금액 : logYrDducSum */ 
				 } else {
					 remtInpt3100Vo.setLogYrDducSum(dcTpLogYrDducSum);    /** column 근속년수공제_정산금액 : logYrDducSum */
				 }
				 
				 
				 /**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 퇴직소득과세표준계산  - 퇴직소득과세표준 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */
				 BigDecimal dcRetryTxtnStdClutSum = BigDecimal.ZERO; //퇴직소득과세표준_정산금액 
				 
				
				 dcRetryTxtnStdClutSum = (remtInpt3100Vo.getRetryIncmClutSum().subtract(remtInpt3100Vo.getRetryFxrtDducClutSum())).subtract(remtInpt3100Vo.getLogYrDducSum());
				 //-인경우 처리 
				 if (dcRetryTxtnStdClutSum.compareTo(BigDecimal.ZERO) > 0) {
					 remtInpt3100Vo.setRetryTxtnStdClutSum(dcRetryTxtnStdClutSum.setScale(0,1));    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
				 } else {
					 remtInpt3100Vo.setRetryTxtnStdClutSum(BigDecimal.ZERO);    /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
				 }
				 
				 /**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 퇴직소득세액계산 - 과세표준안분(30 * 각근속연수 / 정산근속년수) 2012전 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */ 
				 
				 BigDecimal dcTat12befTxtnStdPpnlSum = BigDecimal.ZERO; //세액_2012전_과세표준안분금액
				 BigDecimal dcTat12befYravgTxstdSum = BigDecimal.ZERO; //세액_2012전_연평균과세표준금액
				 
				 BigDecimal dcTat12befYrAvgCalcAmnt = BigDecimal.ZERO; //세액_2012전_연평균산출세액
				 BigDecimal dcTat12befCalcTxAmnt = BigDecimal.ZERO; //세액_2012전_산출세액
				 
				 //세액_2012전_과세표준안분금액  - round 처리 
				
				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) < 0) {
					 
					 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl12befLogYrNum()) < 0) {
						 
						 dcTat12befTxtnStdPpnlSum = (remtInpt3100Vo.getRetryTxtnStdClutSum().multiply((remtInpt3100Vo.getLogPpnl12befLogYrNum().divide(remtInpt3100Vo.getClutLogSvcYrNum(), 10, RoundingMode.DOWN)))).setScale(0,0);
					 
					 } else {
						 dcTat12befTxtnStdPpnlSum =  BigDecimal.ZERO;
					 }
					 
				 } else {
					 dcTat12befTxtnStdPpnlSum = BigDecimal.ZERO;
				 }
				  
				 remtInpt3100Vo.setTat12befTxtnStdPpnlSum(dcTat12befTxtnStdPpnlSum);    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
				 
				//세액_2012전_연평균과세표준금액
				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl12befLogYrNum()) < 0) {
						
					 dcTat12befYravgTxstdSum = remtInpt3100Vo.getTat12befTxtnStdPpnlSum().divide(remtInpt3100Vo.getLogPpnl12befLogYrNum(),0,1);
				 
				 } else {
					 dcTat12befYravgTxstdSum =  BigDecimal.ZERO;
				 } 
				 remtInpt3100Vo.setTat12befYravgTxstdSum(dcTat12befYravgTxstdSum);      /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
				  
				//세액_2012전_연평균산출세액 round down 
				 
				 //기본세율적용 
				 
				 if ((new BigDecimal("12000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) >= 0) {
					 //6%
					 dcTat12befYrAvgCalcAmnt = remtInpt3100Vo.getTat12befYravgTxstdSum().multiply(new BigDecimal("0.06"));
							 
				 } else if ((new BigDecimal("46000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) >= 0) {
					 
					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("720000")).add(
							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("12000000"))).multiply(new BigDecimal("0.15")));
					 
				 } else if ((new BigDecimal("88000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) >= 0) {
					 
					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("5820000")).add(
							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("46000000"))).multiply(new BigDecimal("0.24")));
					 
				 } else if ((new BigDecimal("150000000")).compareTo(remtInpt3100Vo.getTat12befYravgTxstdSum()) >= 0) {
					 
					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("15900000")).add(
							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("88000000"))).multiply(new BigDecimal("0.35")));
					 
				 } else  {
					//1억 5천만원 초과 금액 
					 dcTat12befYrAvgCalcAmnt = (new BigDecimal("37600000")).add(
							 (remtInpt3100Vo.getTat12befYravgTxstdSum().subtract(new BigDecimal("150000000"))).multiply(new BigDecimal("0.38")));
				 } 
				 
				 remtInpt3100Vo.setTat12befYrAvgCalcAmnt(dcTat12befYrAvgCalcAmnt.setScale(0, 1));      /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
				 
				//세액_2012전_산출세액 
				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl12befLogYrNum()) < 0) {
						
					 dcTat12befCalcTxAmnt = remtInpt3100Vo.getTat12befYrAvgCalcAmnt().multiply(remtInpt3100Vo.getLogPpnl12befLogYrNum());
				 
				 } else {
					 dcTat12befCalcTxAmnt =  BigDecimal.ZERO;
				 } 
				 
				 
				 remtInpt3100Vo.setTat12befCalcTxAmnt(dcTat12befCalcTxAmnt);            /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
				 
				//나머지처리  
				 remtInpt3100Vo.setTat12befCvsnTxtnStdSum(BigDecimal.ZERO);    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
				 remtInpt3100Vo.setTat12befCvsnCalcAmnt(BigDecimal.ZERO);        /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */ 
				// remtInpt3100Vo.setTat12befAlpayTxAmnt(BigDecimal.ZERO);          /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
				 remtInpt3100Vo.setTat12befRegTgtTxAmnt(BigDecimal.ZERO);        /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
				 
				 
				 /**
			  		 * -------------------------------------------------------------------------------------------------
			  		 * 퇴직소득세액계산 - 과세표준안분(30 * 각근속연수 / 정산근속년수) 2013이후 
			  		 * -------------------------------------------------------------------------------------------------
			  		 */  
				 
				 
				   // 세액_2013후_과세표준안분금액
				    BigDecimal dcTat13afrTxstdPpnlSum = BigDecimal.ZERO; //세액_2013후_과세표준안분금액
				 
				    
				    if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getClutLogSvcYrNum()) < 0) {
						 
				    	 dcTat13afrTxstdPpnlSum = remtInpt3100Vo.getRetryTxtnStdClutSum().subtract(remtInpt3100Vo.getTat12befTxtnStdPpnlSum());
						 
					 } else {
						 dcTat13afrTxstdPpnlSum = BigDecimal.ZERO;
					 }
				     
				    
				    remtInpt3100Vo.setTat13afrTxstdPpnlSum(dcTat13afrTxstdPpnlSum);    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
				     
				    
				    //세액_2013후_연평균과세표준금액
				    BigDecimal dcTat13afrYrAvgStdSum = BigDecimal.ZERO; //세액_2013후_연평균과세표준금액
				    
				    
				    if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getTat13afrTxstdPpnlSum()) < 0 && BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl13afrLogSvc()) < 0) {
						
				    	dcTat13afrYrAvgStdSum = remtInpt3100Vo.getTat13afrTxstdPpnlSum().divide(remtInpt3100Vo.getLogPpnl13afrLogSvc(),0,1);
					 
					 } else {
						 dcTat13afrYrAvgStdSum =  BigDecimal.ZERO;
					 } 
				     
					remtInpt3100Vo.setTat13afrYrAvgStdSum(dcTat13afrYrAvgStdSum);    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
					
					
					//세액_2013후_환산과세표준금액
				    BigDecimal dcTat13afrCvsnTxtnStdSum = BigDecimal.ZERO; //세액_2013후_환산과세표준금액
				    
				    dcTat13afrCvsnTxtnStdSum = remtInpt3100Vo.getTat13afrYrAvgStdSum().multiply(new BigDecimal("5"));
				    
					remtInpt3100Vo.setTat13afrCvsnTxtnStdSum(dcTat13afrCvsnTxtnStdSum);    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
					
	
					//세액_2013후_환산산출세액
				    BigDecimal dcTat13afrCvsnCalcTxAmnt = BigDecimal.ZERO; //세액_2013후_환산산출세액
				    
				    
				    if ((new BigDecimal("12000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) >= 0) {
						 //6%
				    	dcTat13afrCvsnCalcTxAmnt = remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().multiply(new BigDecimal("0.06"));
								 
					 } else if ((new BigDecimal("46000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) >= 0) {
						 
						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("720000")).add(
								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("12000000"))).multiply(new BigDecimal("0.15")));
						 
					 } else if ((new BigDecimal("88000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) >= 0) {
						 
						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("5820000")).add(
								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("46000000"))).multiply(new BigDecimal("0.24")));
						 
					 } else if ((new BigDecimal("150000000")).compareTo(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum()) >= 0) {
						 
						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("15900000")).add(
								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("88000000"))).multiply(new BigDecimal("0.35")));
						 
					 } else  {
						//1억 5천만원 초과 금액 
						 dcTat13afrCvsnCalcTxAmnt = (new BigDecimal("37600000")).add(
								 (remtInpt3100Vo.getTat13afrCvsnTxtnStdSum().subtract(new BigDecimal("150000000"))).multiply(new BigDecimal("0.38")));
					 } 
					  
					remtInpt3100Vo.setTat13afrCvsnCalcTxAmnt(dcTat13afrCvsnCalcTxAmnt.setScale(0,1));    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
					
					
					
	
					//세액_2013후_연평균산출세액
				    BigDecimal dcTat13afrYrAvgCalcAmnt = BigDecimal.ZERO; //세액_2013후_연평균산출세액
				    
				    dcTat13afrYrAvgCalcAmnt = remtInpt3100Vo.getTat13afrCvsnCalcTxAmnt().divide(new BigDecimal("5"), 0, 1);
				   
					remtInpt3100Vo.setTat13afrYrAvgCalcAmnt(dcTat13afrYrAvgCalcAmnt);    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
					 
					
					//세액_2013후_산출세액
				    BigDecimal dcTat13afrCalcTxAmnt = BigDecimal.ZERO; //세액_2013후_산출세액
				    
				    if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getLogPpnl13afrLogSvc()) < 0) {
						 
				    	dcTat13afrCalcTxAmnt = remtInpt3100Vo.getTat13afrYrAvgCalcAmnt().multiply(remtInpt3100Vo.getLogPpnl13afrLogSvc());
						 
					 } else {
						 dcTat13afrCalcTxAmnt = BigDecimal.ZERO;
					 } 
				    
					remtInpt3100Vo.setTat13afrCalcTxAmnt(dcTat13afrCalcTxAmnt);    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
					
					
					//기타 나머지 부분 처리 
					//remtInpt3100Vo.setTat13afrAlpayTxAmnt(BigDecimal.ZERO);    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
					remtInpt3100Vo.setTat13afrRegrstTgtSum(BigDecimal.ZERO);    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
				 
				 
	
			    /**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 퇴직소득세액계산 - 과세표준안분(30 * 각근속연수 / 정산근속년수)  세액합계 계산....
		  		 * -------------------------------------------------------------------------------------------------
		  		 */  
				  
					
				remtInpt3100Vo.setTatAggrTxtnStdPpnlSum(remtInpt3100Vo.getTat12befTxtnStdPpnlSum().add(remtInpt3100Vo.getTat13afrTxstdPpnlSum()));    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
				remtInpt3100Vo.setTatAggrYrAvgTxtnStdSum(BigDecimal.ZERO);    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
				remtInpt3100Vo.setTatAggrCvsnTxtnStdSum(remtInpt3100Vo.getTat13afrCvsnTxtnStdSum());    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
				remtInpt3100Vo.setTatAggrCvsnCalcTxAmnt(remtInpt3100Vo.getTat13afrCvsnCalcTxAmnt());    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
				remtInpt3100Vo.setTatAggrYrAvgCalcTxAmnt(remtInpt3100Vo.getTat12befYrAvgCalcAmnt().add(remtInpt3100Vo.getTat13afrYrAvgCalcAmnt()));    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
				remtInpt3100Vo.setTatAggrCalcTxAmnt(remtInpt3100Vo.getTat12befCalcTxAmnt().add(remtInpt3100Vo.getTat13afrCalcTxAmnt()));    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
				
				//TODO - 기납부세액은 등록된 데이터을 통해서 처리 하려 했으나 문제있음.기납부세액적용 출력시에는 안보이게 내부적사용 
				remtInpt3100Vo.setTatAggrAlpayTxAmnt(remtInpt3100Vo.getTat12befAlpayTxAmnt().add(remtInpt3100Vo.getTat13afrAlpayTxAmnt()));    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
				remtInpt3100Vo.setTatAggrRegrstTgtTxAmnt(remtInpt3100Vo.getTatAggrCalcTxAmnt().subtract(remtInpt3100Vo.getTatAggrAlpayTxAmnt()));    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
				
				
				/**
		  		 * -------------------------------------------------------------------------------------------------
		  		 * 이연퇴직소득세액계산  -  신고대상세액 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */   
			 
				remtInpt3100Vo.setTalRegrstTgtTxAmnt(remtInpt3100Vo.getTatAggrRegrstTgtTxAmnt());    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
				
				//remtInpt3100Vo.setTalAccuDepitAggrSum(remtInpt3100Vo.getTalAccuDepitAggrSum());    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
				remtInpt3100Vo.setTalRetryPayQnty(remtInpt3100Vo.getEndTxtnTgtRetryPayQnty());    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
			
				
				/** -------------------------------------------------------------------------------------------------
		  		 * 이연퇴직소득세액계산  -  이연퇴직소득세 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */ 
				 BigDecimal dcTalRetryIncmTxAmnt = BigDecimal.ZERO; //세액_2013후_산출세액
				 
				 if (BigDecimal.ZERO.compareTo(remtInpt3100Vo.getTalRegrstTgtTxAmnt()) >= 0 ) {
					 dcTalRetryIncmTxAmnt = BigDecimal.ZERO;
				 } else {
					 dcTalRetryIncmTxAmnt = remtInpt3100Vo.getTalRegrstTgtTxAmnt().multiply((remtInpt3100Vo.getTalAccuDepitAggrSum().divide(remtInpt3100Vo.getTalRetryPayQnty()))).setScale(0,0);
				 }
				
				 if (BigDecimal.ZERO.compareTo(dcTalRetryIncmTxAmnt) >= 0 ) {
					 dcTalRetryIncmTxAmnt = BigDecimal.ZERO;
				 }  
				 
				
				 remtInpt3100Vo.setTalRetryIncmTxAmnt(dcTalRetryIncmTxAmnt);    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
				
				 
				/** -------------------------------------------------------------------------------------------------
		  		 * 납부명세 신고대상세액 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */ 
				//소득세  
				remtInpt3100Vo.setPymtRegTgtIncmTxQnty(remtInpt3100Vo.getTatAggrRegrstTgtTxAmnt());    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
				//지방소득세 
				remtInpt3100Vo.setPymtRegTgtRgonIncmQnty(remtInpt3100Vo.getPymtRegTgtIncmTxQnty().multiply(new BigDecimal("0.1")).setScale(0, 0));    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
				//농어촌특별세
				remtInpt3100Vo.setPymtRegTgtFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
				//합계
				remtInpt3100Vo.setPymtRegrstTgtAggrSum(remtInpt3100Vo.getPymtRegTgtIncmTxQnty().add(remtInpt3100Vo.getPymtRegTgtRgonIncmQnty()).add(remtInpt3100Vo.getPymtRegTgtFarvilSpclQnty()));    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
				
				/** -------------------------------------------------------------------------------------------------
		  		 * 납부명세 이연퇴직소득세 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */ 
				//소득세
				remtInpt3100Vo.setPymtTalcIncmTxQnty(remtInpt3100Vo.getTalRetryIncmTxAmnt());    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
				//지방소득세
				remtInpt3100Vo.setPymtTalcRgonIncmTxQnty(remtInpt3100Vo.getPymtTalcIncmTxQnty().multiply(new BigDecimal("0.1")).setScale(0, 0));    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
				//농어촌특별세
				remtInpt3100Vo.setPymtTalcFarvilSpclQnty(BigDecimal.ZERO);    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
				//합계
				remtInpt3100Vo.setPymtTxAllcAggrSum(remtInpt3100Vo.getPymtTalcIncmTxQnty().add(remtInpt3100Vo.getPymtTalcRgonIncmTxQnty()).add(remtInpt3100Vo.getPymtTalcFarvilSpclQnty()));    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
				
				
				/** -------------------------------------------------------------------------------------------------
		  		 * 납부명세 이연퇴직소득세 
		  		 * -------------------------------------------------------------------------------------------------
		  		 */ 
				//소득세
				remtInpt3100Vo.setPymtSubtnIncmTxQnty((remtInpt3100Vo.getPymtRegTgtIncmTxQnty().subtract(remtInpt3100Vo.getPymtTalcIncmTxQnty())).setScale(-1,1));    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
				//지방소득세
				remtInpt3100Vo.setPymtSubtnRgonIncmTxQnty((remtInpt3100Vo.getPymtRegTgtRgonIncmQnty().subtract(remtInpt3100Vo.getPymtTalcRgonIncmTxQnty())).setScale(-1,1));    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
				
				//농어촌특별세
				remtInpt3100Vo.setPymtSubtnFarvilSpclQnty((remtInpt3100Vo.getPymtRegTgtFarvilSpclQnty().subtract(remtInpt3100Vo.getPymtTalcFarvilSpclQnty())).setScale(-1,1));    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
				//합계
				remtInpt3100Vo.setPymtSubtnAggrSum(remtInpt3100Vo.getPymtSubtnIncmTxQnty().add(remtInpt3100Vo.getPymtSubtnRgonIncmTxQnty()).add(remtInpt3100Vo.getPymtSubtnFarvilSpclQnty()));    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
				
				 
				/**=================================================================================================
		  		 * 퇴직정산 저장
		  		 * =================================================================================================
		  		 */ 
				
				remtCalcService.updateRemt3100(remtInpt3100Vo);
		  		  
				
				/**=================================================================================================
		  		 * 퇴직금 공제 테이블 삭제/인서트 및 퇴직금 산정 테이블 업데이트를 위한 함수 호출 시작 
		  		 * =================================================================================================
		  		 */ 
				InfcPkgRemt2300VO infcRemt2300Vo = new InfcPkgRemt2300VO(); 
				 
				 //소득세  
				infcRemt2300Vo.setDpobCd(remtInpt3100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
				infcRemt2300Vo.setCalcSevePayPsnDivCd(remtInpt3100Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				infcRemt2300Vo.setClutYrMnth(remtInpt3100Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				infcRemt2300Vo.setSystemkey(remtInpt3100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
				infcRemt2300Vo.setPayItemCd("T0010100");    /** column 급여항목코드 : payItemCd */
				infcRemt2300Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
				infcRemt2300Vo.setPymtSum(remtInpt3100Vo.getPymtSubtnIncmTxQnty());    /** column 지급금액 : pymtSum */
				infcRemt2300Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
				infcRemt2300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				infcRemt2300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
				infcRemt2300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				
				remtPayrService.deleteRemt2300(infcRemt2300Vo);  //퇴직금지급공제내역 삭제 
				remtPayrService.insertRemt2300(infcRemt2300Vo);  //퇴직금지급공제내역 저장 
				
                //지방소득세  
				infcRemt2300Vo.setDpobCd(remtInpt3100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
				infcRemt2300Vo.setCalcSevePayPsnDivCd(remtInpt3100Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				infcRemt2300Vo.setClutYrMnth(remtInpt3100Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
				infcRemt2300Vo.setSystemkey(remtInpt3100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
				infcRemt2300Vo.setPayItemCd("T0020100");    /** column 급여항목코드 : payItemCd */
				infcRemt2300Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */
				infcRemt2300Vo.setPymtSum(remtInpt3100Vo.getPymtSubtnRgonIncmTxQnty());    /** column 지급금액 : pymtSum */
				infcRemt2300Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
				infcRemt2300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				infcRemt2300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
				infcRemt2300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				remtPayrService.deleteRemt2300(infcRemt2300Vo);  //퇴직금지급공제내역 삭제 
				remtPayrService.insertRemt2300(infcRemt2300Vo);  //퇴직금지급공제내역 저장  
				
				//퇴직금 산정 테이블 업데이트를 위한 함수 호출 시작  소득세 및 주민세 업데이트 기존 공제가 있으면 같이 업데이트 
				remtPayrService.updateRemt3100ToRemt2300Data(infcRemt2300Vo);
				
				
				/**=================================================================================================
		  		 * 퇴직금 공제 테이블 삭제/인서트 및 퇴직금 산정 테이블 업데이트를 위한 함수 호출 종료
		  		 * =================================================================================================
		  		 */ 
				
				
		   	/**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		  	   *  퇴직정산대상자 for문종료 
		  	   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	  	
	  	} catch (Exception ex) {
          ex.printStackTrace();   
       } 
	  	  
	  	  
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D:B");  
	  	  
	  	return rtnDDucSum;  
	  	 
	}
}