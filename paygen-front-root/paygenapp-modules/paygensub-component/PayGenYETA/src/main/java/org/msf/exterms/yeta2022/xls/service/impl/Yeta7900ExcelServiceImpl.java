package org.msf.exterms.yeta2022.xls.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.yeta2022.xls.service.Yeta7900ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2022.dao.Ye17TaPyyt0302_2022_DAO;
import com.app.exterms.yearendtax.server.service.yeta2022.dao.Ye17TaPyyt0304_2022_DAO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302Exl_2022_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302_2022_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304_2022_VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0485DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0485SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0485VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("yeta7900ExcelService")
public class Yeta7900ExcelServiceImpl extends AbstractServiceImpl implements Yeta7900ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(Yeta7900ExcelServiceImpl.class);
	private static final String calledClass = Yeta7900ExcelService.class.getName();

	
	@Autowired
	@Resource(name = "Ye17TaPyyt0302_2022_DAO")
	private Ye17TaPyyt0302_2022_DAO pyyt0302DAO;
	
	@Autowired
	@Resource(name = "Ye17TaPyyt0304_2022_DAO")
	private Ye17TaPyyt0304_2022_DAO pyyt0304DAO;
	
	
	@Autowired
	@Resource(name = "InfcPkgPayr0485DAO")
	private InfcPkgPayr0485DAO payr0485DAO;

	public List selectXlsPayr0485List(InfcPkgPayr0485SrhVO Payr0485SrhVo)throws Exception {
		return payr0485DAO.selectPayr0485List(Payr0485SrhVo);
	}
	
	
	
	
	 /**
	  *  엑셀파일을 등록한다._jxls
	  * @param  hMap
	  * @throws Exception
	  */

	@Override
	public List<Pyyt0302_2022_VO> updateXlsYeta790001(Collection<Pyyt0302_2022_VO> yeta1900List, HttpServletRequest request)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		Pyyt0302_2022_VO pyyt0302Vo = new Pyyt0302_2022_VO(); 
		Pyyt0304_2022_VO pyyt0304Vo = new Pyyt0304_2022_VO(); 
		Pyyt0304Srh_2022_VO pyyt0304SrhVo = new Pyyt0304Srh_2022_VO(); 
		String rrnDecCrypt = "";	// 2.복호화 리턴받을 값 선언
		String strValue = "";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		List<Pyyt0302_2022_VO> errYeta7900List = new ArrayList<Pyyt0302_2022_VO>();
		 

		
		try {  
			
			errYeta7900List = new ArrayList<Pyyt0302_2022_VO>();	// 데이터 이상으로 저장되지 않는 데이터를 리턴해주기 위한
			
			for(int iPsnlCnt=0;iPsnlCnt < yeta1900List.size();iPsnlCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * PYYT0302 처리 시작
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 **/
				
				pyyt0302Vo = new Pyyt0302_2022_VO();  
				strValue = "";
				Pyyt0302_2022_VO pyyt0302 = new Pyyt0302_2022_VO();  
				pyyt0302 = ((ArrayList<Pyyt0302_2022_VO>) yeta1900List).get(iPsnlCnt);
				
				pyyt0302Vo.setPayCd(MSFSharedUtils.allowNulls(pyyt0302.getPayCd()));
				pyyt0302Vo.setPyytItemCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytItemCd()));   										/** column 급여항목코드 : pyytItemCd */
				pyyt0302Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    												/** column 사업장코드 : dpobCd */
				
				
				pyyt0302Vo.setJuminCk(pyyt0302.getJuminCk());
				// 주민번호 이용 : 0. 생년월일 + 성명 이용 : 1
				if("0".equals(pyyt0302.getJuminCk()) || pyyt0302.getJuminCk() == "0") {
					// 주민번호를 암호화 하여 systemkey를 찾는다.
					pyyt0302Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));			
					
					List psnl0100List = pyyt0302DAO.selectPyyt0302ToPsnl0100List(pyyt0302Vo);
					
					for(int i=0; i<psnl0100List.size(); i++){
						EgovMap eMap  = new EgovMap();
						eMap = (EgovMap) psnl0100List.get(i);
						strValue = MSFSharedUtils.allowNulls(eMap.get("systemkey"));
						pyyt0302Vo.setHanNm(MSFSharedUtils.allowNulls(eMap.get("hanNm")));
						pyyt0302Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(eMap.get("emymtDivCd")));
					}
					pyyt0302Vo.setSystemkey(strValue);    									/** column SYSTEMKEY : systemkey */
					
				}else {
					
					// 성명과 생년월일을 이용하여 systemkey를 찾는다.
					pyyt0302Vo.setHanNm(pyyt0302.getHanNm());
					pyyt0302Vo.setYoobhMnthDay(pyyt0302.getResnRegnNum());
				
					List psnl0100List = pyyt0302DAO.selectPyyt0302ToPsnl0100List(pyyt0302Vo);
					
					for(int i=0; i<psnl0100List.size(); i++){
						EgovMap eMap  = new EgovMap();
						eMap = (EgovMap) psnl0100List.get(i);
						strValue = MSFSharedUtils.allowNulls(eMap.get("systemkey"));
						pyyt0302Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(eMap.get("emymtDivCd")));
					}
					pyyt0302Vo.setSystemkey(strValue);    									/** column SYSTEMKEY : systemkey */
				}
				
				
				
				pyyt0302Vo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0302.getPyytYrMnth()));    										/** column 지급년월 : pyytYrMnth */
//				pyyt0302Vo.setPyytPymtDducCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytPymtDducCd()));    								/** column 지급공제구분코드 : pyytPymtDducCd */
				pyyt0302Vo.setPyytItemCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytItemCd()));  						
				pyyt0302Vo.setPyytPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302.getPyytPymtDducSum(), "0")));    		/** column 지급공제금액 : pyytPymtDducSum */
				
				//TODO 비과세금액 수정 후 과세금액 계산 하는 부분 추가
				pyyt0302Vo.setPyytPyddTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302.getPyytPyddTxtnAmnt(), "0")));   	/** column 지급공제과세금액 : pyytPyddTxtnAmnt */
				//TODO 비과세금액 BASS0300에서 가져옴. 테이블 작업 끝나면 수정필요
				pyyt0302Vo.setPyytPyddFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302.getPyytPyddFreeDtySum(), "0")));	/** column 지급공제비과세금액 : pyytPyddFreeDtySum */
				pyyt0302Vo.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytYrtxDotnCd()));    								/** column 연말정산_기부금코드 : pyytYrtxDotnCd */
				pyyt0302Vo.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytYtfeDtyReduCd()));    						/** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	          	
				pyyt0302Vo.setKybdr(sessionUser.getUsrId());			/** column 입력자 : kybdr */
				pyyt0302Vo.setInptAddr(request.getRemoteHost());		/** column 입력주소 : inptAddr */
				pyyt0302Vo.setIsmt(sessionUser.getUsrId());    			/** column 수정자 : ismt */
				pyyt0302Vo.setRevnAddr(request.getRemoteHost());    	/** column 수정주소 : revnAddr */  
	          	
				
				
				
				// 시스템키 있으면
				if(!"X".equals(MSFSharedUtils.defaultNulls(pyyt0302Vo.getSystemkey(), "X"))) {
					
//					pyyt0304Vo.setStrRtn("O");
					// 해당 코드가 수당공제테에블에 있는지 체크한다.
					InfcPkgPayr0485VO payr0485Vo = new InfcPkgPayr0485VO(); 
					payr0485Vo.setDpobCd(pyyt0302Vo.getDpobCd());
					payr0485Vo.setPayItemCd(pyyt0302Vo.getPyytItemCd());
					
					int returnInt = payr0485DAO.selectPayr0485ListTotCnt(payr0485Vo);
					if(returnInt <= 0) {
						// 이상데이터 리턴
						// 3.복호화
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						pyyt0302Vo.setResnRegnNum(rrnDecCrypt);
//						pyyt0302Vo.setResnRegnNum(MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()));		
//						pyyt0304Vo.setStrRtn("X");
						errYeta7900List.add(pyyt0302Vo);
						
					}else {
						
						pyyt0302DAO.deletePyyt0302(pyyt0302Vo);
			          	pyyt0302DAO.insertPyyt0302(pyyt0302Vo); 
			          	
			          	
						/**
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 * PYYT0304 처리 시작
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 **/
			          	pyyt0304Vo = new Pyyt0304_2022_VO(); 
			          	
						pyyt0304Vo.setSystemkey(MSFSharedUtils.allowNulls(pyyt0302Vo.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
						pyyt0304Vo.setDpobCd(MSFSharedUtils.allowNulls(pyyt0302Vo.getDpobCd()));    			/** column 사업장코드 : dpobCd */
						pyyt0304Vo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0302Vo.getPyytYrMnth()));    	/** column 지급년월 : pyytYrMnth */
						pyyt0304Vo.setHanNm(MSFSharedUtils.allowNulls(pyyt0302Vo.getHanNm()));    				/** column 한글성명 : hanNm */
						pyyt0304Vo.setResnRegnNum(MSFSharedUtils.allowNulls(pyyt0302Vo.getResnRegnNum()));  	/** column 주민등록번호 : resnRegnNum */
						
						// -- PSNL0110 에서 가져옴
//						pyyt0304Vo.setPayrMangDeptCd(pyyt0304Vo.getPayrMangDeptCd());							/** column 급여관리부서코드 : payrMangDeptCd */
//						pyyt0304Vo.setEmymtDivCd(pyyt0304Vo.getEmymtDivCd());    								/** column 고용구분코드 : emymtDivCd */
//						pyyt0304Vo.setDeptCd(pyyt0304Vo.getDeptCd());    										/** column 부서코드 : deptCd */
//						pyyt0304Vo.setBusinCd(pyyt0304Vo.getBusinCd());    										/** column 사업코드 : businCd */
//						pyyt0304Vo.setTypOccuCd(pyyt0304Vo.getTypOccuCd());    									/** column 직종코드 : typOccuCd */
//						pyyt0304Vo.setDtilOccuInttnCd(pyyt0304Vo.getDtilOccuInttnCd());    						/** column 직종세통합코드 : dtilOccuInttnCd */
//						pyyt0304Vo.setOdtyCd(pyyt0304Vo.getOdtyCd());    										/** column 직책코드 : odtyCd */
//						pyyt0304Vo.setPyspCd(pyyt0304Vo.getPyspCd());    										/** column 호봉코드 : pyspCd */
//						pyyt0304Vo.setLogSvcYrNumCd(pyyt0304Vo.getLogSvcYrNumCd());    							/** column 근속년수코드 : logSvcYrNumCd */
//						pyyt0304Vo.setLogSvcMnthIcmCd(pyyt0304Vo.getLogSvcMnthIcmCd());    						/** column 근속월수코드 : logSvcMnthIcmCd */
//						pyyt0304Vo.setFrstEmymtDt(pyyt0304Vo.getFrstEmymtDt());    								/** column 최초고용일자 : frstEmymtDt */
//						pyyt0304Vo.setEmymtBgnnDt(pyyt0304Vo.getEmymtBgnnDt());    								/** column 고용시작일자 : emymtBgnnDt */
//						pyyt0304Vo.setEmymtEndDt(pyyt0304Vo.getEmymtEndDt());    								/** column 고용종료일자 : emymtEndDt */
//						pyyt0304Vo.setHdofcDivCd(pyyt0304Vo.getHdofcDivCd());   								/** column 재직구분코드 : hdofcDivCd */
//						pyyt0304Vo.setRetryDt(pyyt0304Vo.getRetryDt());    										/** column 퇴직일자 : retryDt */
						
						// -- PYYT0302로 계산
//						pyyt0304Vo.setPyytPymtTotAmnt(pyyt0304Vo.getPyytPymtTotAmnt());    						/** column 지급총액 : pyytPymtTotAmnt */
//						pyyt0304Vo.setPyytExtpyTotAmnt(pyyt0304Vo.getPyytExtpyTotAmnt());						/** column 수당총액 : pyytExtpyTotAmnt */
//						pyyt0304Vo.setPyytTxtnTotAmnt(pyyt0304Vo.getPyytTxtnTotAmnt());    						/** column 과세총액 : pyytTxtnTotAmnt */
//						pyyt0304Vo.setPyytFreeDtyTotAmnt(pyyt0304Vo.getPyytFreeDtyTotAmnt());					/** column 비과세총액 : pyytFreeDtyTotAmnt */
//						pyyt0304Vo.setPyytDducTotAmnt(pyyt0304Vo.getPyytDducTotAmnt());    						/** column 공제총액 : pyytDducTotAmnt */
//						pyyt0304Vo.setPyytTxTotAmnt(pyyt0304Vo.getPyytTxTotAmnt());   		 					/** column 세금총액 : pyytTxTotAmnt */
//						pyyt0304Vo.setPyytSevePayPymtYn(pyyt0304Vo.getPyytSevePayPymtYn());    					/** column 퇴직금지급여부 : pyytSevePayPymtYn */
//						pyyt0304Vo.setPyytPernPymtSum(pyyt0304Vo.getPyytPernPymtSum());    						/** column 차인지급액 : pyytPernPymtSum */
						
						
						
						// PYYT304에 데이터가 등록되어 있으면 총액 들만 UPDATE, 없으면 INSERT
						pyyt0304SrhVo = new Pyyt0304Srh_2022_VO();
						pyyt0304SrhVo.setSystemkey(pyyt0304Vo.getSystemkey());
						pyyt0304SrhVo.setDpobCd(pyyt0304Vo.getDpobCd());
						pyyt0304SrhVo.setPyytYrMnth(pyyt0304Vo.getPyytYrMnth());
						
						int iRtn = pyyt0304DAO.selectPyyt0304Check(pyyt0304SrhVo);
						
						if(iRtn > 0 ) {
							
							pyyt0304Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
							pyyt0304Vo.setRevnAddr(request.getRemoteHost());    									/** column 수정주소 : revnAddr */ 
							
							pyyt0304DAO.updatePyyt0304(pyyt0304Vo);
							
							
						}else {
							
							pyyt0304Vo.setKybdr(sessionUser.getUsrId());											/** column 입력자 : kybdr */
							pyyt0304Vo.setInptAddr(request.getRemoteHost());										/** column 입력주소 : inptAddr */
							
							pyyt0304DAO.insertPyyt0304(pyyt0304Vo);
							
						}
					}
		          	
				}else {
					// 이상데이터 리턴
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					pyyt0302Vo.setResnRegnNum(rrnDecCrypt);
//					pyyt0302Vo.setResnRegnNum(MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()));		
//					pyyt0304Vo.setStrRtn("X");
					errYeta7900List.add(pyyt0302Vo);
	
				}
				
			} 
			result = new Long(1);
	          
	        } catch (Exception ex) {
	        	
	            logger.error("EXCEPTION calling updateXlsYeta790002(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("updateXlsYeta790002", ex, logger);
	        }
	        finally {
	          
	        }
		return errYeta7900List;
	}	
	
	
	
	
	
	
	 /**
	  *  엑셀파일을 등록한다._jxls
	  * @param  hMap
	  * @throws Exception
	  */
	@Override
	public List<Pyyt0302_2022_VO> updateXlsYeta790002(List<Pyyt0302Exl_2022_VO> yeta1900List, HttpServletRequest request)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		Pyyt0302_2022_VO pyyt0302Vo = new Pyyt0302_2022_VO(); 
		Pyyt0304_2022_VO pyyt0304Vo = new Pyyt0304_2022_VO(); 
		Pyyt0304Srh_2022_VO pyyt0304SrhVo = new Pyyt0304Srh_2022_VO(); 
		String strValue = "";
		String rrnDecCrypt = "";	// 2.복호화 리턴받을 값 선언
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		List<Pyyt0302_2022_VO> errYeta7900List = new ArrayList<Pyyt0302_2022_VO>();
		 

		
		try {  
			
			errYeta7900List = new ArrayList<Pyyt0302_2022_VO>();	// 데이터 이상으로 저장되지 않는 데이터를 리턴해주기 위한
			
			for(int iPsnlCnt=0;iPsnlCnt < yeta1900List.size();iPsnlCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * PYYT0302 처리 시작
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 **/
				

				
				pyyt0302Vo = new Pyyt0302_2022_VO();  
				strValue = "";
				
				Pyyt0302Exl_2022_VO pyyt0302 = new Pyyt0302Exl_2022_VO();  
				pyyt0302 = yeta1900List.get(iPsnlCnt);
				
				pyyt0302Vo.setPayCd(MSFSharedUtils.allowNulls(pyyt0302.getPayCd()));
				pyyt0302Vo.setPyytItemCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytItemCd()));   										/** column 급여항목코드 : pyytItemCd */
				pyyt0302Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    												/** column 사업장코드 : dpobCd */
				
				
				pyyt0302Vo.setJuminCk(pyyt0302.getJuminCk());
				// 주민번호 이용 : 0. 생년월일 + 성명 이용 : 1
				if("0".equals(pyyt0302.getJuminCk()) || pyyt0302.getJuminCk() == "0") {
					// 주민번호를 암호화 하여 systemkey를 찾는다.
					pyyt0302Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));			
					
					List psnl0100List = pyyt0302DAO.selectPyyt0302ToPsnl0100List(pyyt0302Vo);
					
					for(int i=0; i<psnl0100List.size(); i++){
						EgovMap eMap  = new EgovMap();
						eMap = (EgovMap) psnl0100List.get(i);
						strValue = MSFSharedUtils.allowNulls(eMap.get("systemkey"));
						pyyt0302Vo.setHanNm(MSFSharedUtils.allowNulls(eMap.get("hanNm")));
						pyyt0302Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(eMap.get("emymtDivCd")));
						pyyt0302Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(eMap.get("payrMangDeptCd")));
					}
					pyyt0302Vo.setSystemkey(strValue);    									/** column SYSTEMKEY : systemkey */
					
				}else {
					
					// 성명과 생년월일을 이용하여 systemkey를 찾는다.
					pyyt0302Vo.setHanNm(pyyt0302.getHanNm());
					pyyt0302Vo.setYoobhMnthDay(pyyt0302.getResnRegnNum());
				
					List psnl0100List = pyyt0302DAO.selectPyyt0302ToPsnl0100List(pyyt0302Vo);
					
					for(int i=0; i<psnl0100List.size(); i++){
						EgovMap eMap  = new EgovMap();
						eMap = (EgovMap) psnl0100List.get(i);
						strValue = MSFSharedUtils.allowNulls(eMap.get("systemkey"));
						pyyt0302Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(eMap.get("emymtDivCd")));
						pyyt0302Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(eMap.get("payrMangDeptCd")));
					}
					pyyt0302Vo.setSystemkey(strValue);    									/** column SYSTEMKEY : systemkey */
				}
				
				
				
				pyyt0302Vo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0302.getPyytYrMnth()));    										/** column 지급년월 : pyytYrMnth */
//				pyyt0302Vo.setPyytPymtDducCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytPymtDducCd()));    								/** column 지급공제구분코드 : pyytPymtDducCd */
				pyyt0302Vo.setPyytItemCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytItemCd()));    	
				pyyt0302Vo.setPyytPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302.getPyytPymtDducSum(), "0")));    		/** column 지급공제금액 : pyytPymtDducSum */
				pyyt0302Vo.setPyytPyddTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302.getPyytPyddTxtnAmnt(), "0")));   	/** column 지급공제과세금액 : pyytPyddTxtnAmnt */
//				pyyt0302Vo.setPyytPyddFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302.getPyytPyddFreeDtySum(), "0")));	/** column 지급공제비과세금액 : pyytPyddFreeDtySum */
				pyyt0302Vo.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytYrtxDotnCd()));    								/** column 연말정산_기부금코드 : pyytYrtxDotnCd */
				pyyt0302Vo.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(pyyt0302.getPyytYtfeDtyReduCd()));    						/** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
	          	
				pyyt0302Vo.setKybdr(sessionUser.getUsrId());			/** column 입력자 : kybdr */
				pyyt0302Vo.setInptAddr(request.getRemoteHost());		/** column 입력주소 : inptAddr */
				pyyt0302Vo.setIsmt(sessionUser.getUsrId());    			/** column 수정자 : ismt */
				pyyt0302Vo.setRevnAddr(request.getRemoteHost());    	/** column 수정주소 : revnAddr */  
	          	
				
				
				
				// 시스템키 있으면
				if(!"X".equals(MSFSharedUtils.defaultNulls(pyyt0302Vo.getSystemkey(), "X"))) {
					
//					pyyt0304Vo.setStrRtn("O");
					// 해당 코드가 수당공제테에블에 있는지 체크한다.
					InfcPkgPayr0485VO payr0485Vo = new InfcPkgPayr0485VO(); 
					payr0485Vo.setDpobCd(pyyt0302Vo.getDpobCd());
					payr0485Vo.setPayItemCd(pyyt0302Vo.getPyytItemCd());
					
					int returnInt = payr0485DAO.selectPayr0485ListTotCnt(payr0485Vo);
					if(returnInt <= 0) {
						// 이상데이터 리턴
						// 3.복호화
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						pyyt0302Vo.setResnRegnNum(rrnDecCrypt);
//						pyyt0302Vo.setResnRegnNum(MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()));		
//						pyyt0304Vo.setStrRtn("X");
						errYeta7900List.add(pyyt0302Vo);
//						System.out.println("1111111111111111111");
						
					}else {
						
						pyyt0302DAO.deletePyyt0302(pyyt0302Vo);
			          	pyyt0302DAO.insertPyyt0302(pyyt0302Vo); 
			          	
			          	
						/**
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 * PYYT0304 처리 시작
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 **/
			          	pyyt0304Vo = new Pyyt0304_2022_VO(); 
			          	
						pyyt0304Vo.setSystemkey(MSFSharedUtils.allowNulls(pyyt0302Vo.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
						pyyt0304Vo.setDpobCd(MSFSharedUtils.allowNulls(pyyt0302Vo.getDpobCd()));    			/** column 사업장코드 : dpobCd */
						pyyt0304Vo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0302Vo.getPyytYrMnth()));    	/** column 지급년월 : pyytYrMnth */
						pyyt0304Vo.setHanNm(MSFSharedUtils.allowNulls(pyyt0302Vo.getHanNm()));    				/** column 한글성명 : hanNm */
						pyyt0304Vo.setResnRegnNum(MSFSharedUtils.allowNulls(pyyt0302Vo.getResnRegnNum()));  	/** column 주민등록번호 : resnRegnNum */
						pyyt0304Vo.setPayCd(MSFSharedUtils.allowNulls(pyyt0302Vo.getPayCd()));					/** column 급여구분코드 : payCd */
						pyyt0304Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(pyyt0302Vo.getPayrMangDeptCd()));/** column 급여관리부서코드 : payrMangDeptCd */
						
						// -- PSNL0110 에서 가져옴
//						pyyt0304Vo.setPayrMangDeptCd(pyyt0304Vo.getPayrMangDeptCd());							/** column 급여관리부서코드 : payrMangDeptCd */
//						pyyt0304Vo.setEmymtDivCd(pyyt0304Vo.getEmymtDivCd());    								/** column 고용구분코드 : emymtDivCd */
//						pyyt0304Vo.setDeptCd(pyyt0304Vo.getDeptCd());    										/** column 부서코드 : deptCd */
//						pyyt0304Vo.setBusinCd(pyyt0304Vo.getBusinCd());    										/** column 사업코드 : businCd */
//						pyyt0304Vo.setTypOccuCd(pyyt0304Vo.getTypOccuCd());    									/** column 직종코드 : typOccuCd */
//						pyyt0304Vo.setDtilOccuInttnCd(pyyt0304Vo.getDtilOccuInttnCd());    						/** column 직종세통합코드 : dtilOccuInttnCd */
//						pyyt0304Vo.setOdtyCd(pyyt0304Vo.getOdtyCd());    										/** column 직책코드 : odtyCd */
//						pyyt0304Vo.setPyspCd(pyyt0304Vo.getPyspCd());    										/** column 호봉코드 : pyspCd */
//						pyyt0304Vo.setLogSvcYrNumCd(pyyt0304Vo.getLogSvcYrNumCd());    							/** column 근속년수코드 : logSvcYrNumCd */
//						pyyt0304Vo.setLogSvcMnthIcmCd(pyyt0304Vo.getLogSvcMnthIcmCd());    						/** column 근속월수코드 : logSvcMnthIcmCd */
//						pyyt0304Vo.setFrstEmymtDt(pyyt0304Vo.getFrstEmymtDt());    								/** column 최초고용일자 : frstEmymtDt */
//						pyyt0304Vo.setEmymtBgnnDt(pyyt0304Vo.getEmymtBgnnDt());    								/** column 고용시작일자 : emymtBgnnDt */
//						pyyt0304Vo.setEmymtEndDt(pyyt0304Vo.getEmymtEndDt());    								/** column 고용종료일자 : emymtEndDt */
//						pyyt0304Vo.setHdofcDivCd(pyyt0304Vo.getHdofcDivCd());   								/** column 재직구분코드 : hdofcDivCd */
//						pyyt0304Vo.setRetryDt(pyyt0304Vo.getRetryDt());    										/** column 퇴직일자 : retryDt */
						
						// -- PYYT0302로 계산
//						pyyt0304Vo.setPyytPymtTotAmnt(pyyt0304Vo.getPyytPymtTotAmnt());    						/** column 지급총액 : pyytPymtTotAmnt */
//						pyyt0304Vo.setPyytExtpyTotAmnt(pyyt0304Vo.getPyytExtpyTotAmnt());						/** column 수당총액 : pyytExtpyTotAmnt */
//						pyyt0304Vo.setPyytTxtnTotAmnt(pyyt0304Vo.getPyytTxtnTotAmnt());    						/** column 과세총액 : pyytTxtnTotAmnt */
//						pyyt0304Vo.setPyytFreeDtyTotAmnt(pyyt0304Vo.getPyytFreeDtyTotAmnt());					/** column 비과세총액 : pyytFreeDtyTotAmnt */
//						pyyt0304Vo.setPyytDducTotAmnt(pyyt0304Vo.getPyytDducTotAmnt());    						/** column 공제총액 : pyytDducTotAmnt */
//						pyyt0304Vo.setPyytTxTotAmnt(pyyt0304Vo.getPyytTxTotAmnt());   		 					/** column 세금총액 : pyytTxTotAmnt */
//						pyyt0304Vo.setPyytSevePayPymtYn(pyyt0304Vo.getPyytSevePayPymtYn());    					/** column 퇴직금지급여부 : pyytSevePayPymtYn */
//						pyyt0304Vo.setPyytPernPymtSum(pyyt0304Vo.getPyytPernPymtSum());    						/** column 차인지급액 : pyytPernPymtSum */
						
						
						
						// PYYT304에 데이터가 등록되어 있으면 총액 들만 UPDATE, 없으면 INSERT
						pyyt0304SrhVo = new Pyyt0304Srh_2022_VO();
						pyyt0304SrhVo.setSystemkey(pyyt0304Vo.getSystemkey());
						pyyt0304SrhVo.setDpobCd(pyyt0304Vo.getDpobCd());
						pyyt0304SrhVo.setPyytYrMnth(pyyt0304Vo.getPyytYrMnth());
						pyyt0304SrhVo.setPayCd(pyyt0304Vo.getPayCd());
						
						int iRtn = pyyt0304DAO.selectPyyt0304Check(pyyt0304SrhVo);
						
						if(iRtn > 0 ) {
							
							pyyt0304Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
							pyyt0304Vo.setRevnAddr(request.getRemoteHost());    									/** column 수정주소 : revnAddr */ 
							
							pyyt0304DAO.updatePyyt0304(pyyt0304Vo);
							
							
						}else {
							
							pyyt0304Vo.setKybdr(sessionUser.getUsrId());											/** column 입력자 : kybdr */
							pyyt0304Vo.setInptAddr(request.getRemoteHost());										/** column 입력주소 : inptAddr */
							
							pyyt0304DAO.insertPyyt0304(pyyt0304Vo);
							
						}
					}
		          	
				}else {
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					pyyt0302Vo.setResnRegnNum(rrnDecCrypt);
					// 이상데이터 리턴
//					pyyt0302Vo.setResnRegnNum(MSFSharedUtils.allowNulls(pyyt0302.getResnRegnNum()));		
//					pyyt0304Vo.setStrRtn("X");
					errYeta7900List.add(pyyt0302Vo);
	
				}
				
			} 
			result = new Long(1);
	          
	        } catch (Exception ex) {
	        	
	            logger.error("EXCEPTION calling updateXlsYeta790002(): "+ex); 
	            
	            result = new Long(0);
	            
	            MSFErrorMessage errMsg = new MSFErrorMessage("", "", 0, "업로드 데이터에 문제가 있습니다.</br> 관리자에게 문의해주세요."); 
  				throw MSFServerUtils.getValidationException("updateXlsYeta790002", errMsg, logger) ; 
//	            throw MSFServerUtils.getOperationException("updateXlsYeta190002", ex, logger);
	        }
	        finally {
	          
	        }
		return errYeta7900List;
	}
	
	
	
	
	
//	public EgovMap selectXlsPyyt0304List1(Pyyt0304SrhVO pyyt0304SrhVo)throws Exception {
//		return (EgovMap) pyyt0304DAO.selectPyyt0302XlsList1(pyyt0304SrhVo);
//	}
	
	
	
	// 급여대장(공무직)
	@Override
	public List<Pyyt0304_2022_VO> selectXlsPyyt0304List01(Pyyt0304Srh_2022_VO   pyyt0304SrhVo) throws Exception {
		return pyyt0304DAO.selectXlsYeta1900ToPyyt0304List01(pyyt0304SrhVo);
	} 
	
	// 급여대장(기간제근로자)
	public List selectXlsPyyt0304List2(Pyyt0304Srh_2022_VO pyyt0304SrhVo)throws Exception {
		return pyyt0304DAO.selectXlsYeta1900ToPyyt0304List02(pyyt0304SrhVo);
	}




	/*@Override
	public List selectXlsPayr0485List(InfcPkgPayr0485VO Payr0485SrhVo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	
	

}