package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr4200ExcelService;
import org.msf.exterms.xls.service.Payr4200TotVO;
import org.msf.exterms.xls.service.Payr4200VO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0301DAO;
import com.app.exterms.payroll.server.service.dao.Payr0302DAO;
import com.app.exterms.payroll.server.service.dao.Payr0304DAO;
import com.app.exterms.payroll.server.service.dao.Payr0307DAO;
import com.app.exterms.payroll.server.vo.Payr0302VO;
import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.exterms.payroll.server.vo.Payr0307VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.pkg.listener.PayrListenerAdapter;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("payr4200ExcelService")
public class Payr4200ExcelServiceImpl extends AbstractServiceImpl implements Payr4200ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Payr4200ExcelServiceImpl.class);
	private static final String calledClass = Payr4200ExcelService.class.getName();
    
    
	@Autowired
	@Resource(name="Payr0301DAO")
	private Payr0301DAO payr0301DAO;
	
	
	//급여 수당공제이력정보 
	@Autowired
	@Resource(name="Payr0302DAO")
	private Payr0302DAO payr0302DAO;
  
	@Autowired
	@Resource(name="Payr0304DAO")
	private Payr0304DAO payr0304DAO;
	
	@Autowired
	@Resource(name="Payr0307DAO")
	private Payr0307DAO payr0307DAO;
     
	public List<Payr4200VO> selectXlsPayr4200List(Payr0304SrhVO   payr0304SrhVO) throws Exception {
		return payr0301DAO.selectPayr4200XlsList(payr0304SrhVO);
	} 
  
	public List selectXlsPayr4200List2(Payr0304SrhVO   payr0304SrhVO) throws Exception {
		return payr0301DAO.selectPayr4200XlsList2(payr0304SrhVO);
	} 
  
	public EgovMap selectXlsPayr4200List1(Payr0304SrhVO   payr0304SrhVO) throws Exception {
		return (EgovMap) payr0301DAO.selectPayr4200XlsList1(payr0304SrhVO);
	}
  
	public List<Payr4200TotVO> selectXlsTotPayr4200List(Payr0304SrhVO   payr0304SrhVO) throws Exception {
		return payr0301DAO.selectPayr4200XlsTotList(payr0304SrhVO);
	}


	//급여지급대상자 양식저장
	@Override
	public List selectXlsFilePayr304_307ToPayr4200List(Payr0304SrhVO payr0304SrhVO) throws MSFException {
		// TODO Auto-generated method stub
		return payr0304DAO.selectXlsFilePayr0304ToPayr4200LList(payr0304SrhVO);
	}

	
	//급여지급대상자 업로드
	@Override
	public Long updateXlsPayr0307To4200(List<Payr0307VO> payr0307List, HttpServletRequest request)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(1);
		Long iCnt = new Long(0);
		
        BigDecimal tpExtpyTotAmnt = BigDecimal.ZERO;			// 현수당금
        BigDecimal tpTxtnTotAmnt = BigDecimal.ZERO; 			// 과세금액  
        BigDecimal tpFreeDtyTotAmnt = BigDecimal.ZERO; 		// 비과세금액 
        BigDecimal freeDtySum = BigDecimal.ZERO;   			// 비과세 적용금액  
        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
    	
        
		try {  
			
			for(int iPayrCnt=0;iPayrCnt < payr0307List.size();iPayrCnt++) {
				
				// 1. 암호화 객체 생성
		    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

				
				tpExtpyTotAmnt = BigDecimal.ZERO;			// 현수당금
                tpTxtnTotAmnt = BigDecimal.ZERO; 			// 과세금액  
                tpFreeDtyTotAmnt = BigDecimal.ZERO; 		// 비과세금액 
                freeDtySum = BigDecimal.ZERO;   				// 비과세 적용금액  
				
				Payr0307VO payr0307Vo = new Payr0307VO();  
				Payr0307VO  tpPayr0307Vo = new Payr0307VO();
				payr0307Vo = payr0307List.get(iPayrCnt);
				/**========================== 해당하는 조정내역 삭제 후 인서트 처리 : PAYR0307 ========================== */
				payr0307Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));					/** set 사업장코드 : dpobCd */
//				payr0307Vo.setResnRegnNum(MSFSharedUtils.allowNulls(payr0307Vo.getResnRegnNum()));	/** set 주민등록번호 : resnRegnNum */
				// 2. 파라미터 보낼 때(암호화)
				payr0307Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(payr0307Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

				payr0307Vo.setPymtYrMnth(MSFSharedUtils.allowNulls(payr0307Vo.getPymtYrMnth()));											/** set 지급년월 : pymtYrMnth */
			    payr0307Vo.setPayCd(MSFSharedUtils.allowNulls(payr0307Vo.getPayCd()));														/** set 급여구분코드 : payCd */
			    payr0307Vo.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPayrSeilNum(), "0")));					/** set 급여일련번호 : payrSeilNum */
			    payr0307Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0307Vo.getSystemkey()));												/** set SYSTEMKEY : systemkey */
			    payr0307Vo.setMnthPayAdmntSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getMnthPayAdmntSeilNum(), "0")));	/** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
			    payr0307Vo.setPayItemCd(MSFSharedUtils.allowNulls(payr0307Vo.getPayItemCd()));												/** set 급여항목코드 : payItemCd */
			    payr0307Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0307Vo.getPymtDducDivCd())); 										/** set 지급공제구분코드 : pymtDducDivCd */
			    payr0307Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(), "0")));					/** set 지급공제금액 : pymtDducSum */
			    payr0307Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(), "0")));		/** set 지급공제비과세금액 : pymtDducFreeDtySum */
			    payr0307Vo.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(payr0307Vo.getMnthPayAdmntAssoBssCtnt()));					/** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
			    payr0307Vo.setMnthPayAdmntYn(MSFSharedUtils.allowNulls(payr0307Vo.getMnthPayAdmntYn()));									/** set 월급여소급조정여부 : mnthPayAdmntYn */
//			    payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.allowNulls(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(), "0"))));/** set 지급공제과세금액 : pymtDducTxtnAmnt */
			    
			    
                if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {
                    
                    if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
                      
                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
                        
                        } else {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
                             
                        }
                    } else {
                        
                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
                        
                        } else {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
                             
                        }
                    }
                   
                
                } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) {
                
                    if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
                        
                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
                        
                        } else {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
                             
                        }
                    } else {
                        
                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
                        
                        } else {
                            
                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
                             
                        }
                    }
                    
                }  else {
                    
                    payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(),"0")));    /** column null : pymtDducTxtnAmnt */
                } 
			    
			    
                payr0307DAO.deleteXlsPayr0307(payr0307Vo);
                payr0307DAO.insertXlsPayr0307(payr0307Vo); 
			    /**========================== 해당하는 조정내역 삭제 후 인서트 처리 : PAYR0307 ========================== */
			    
			    
                
			    Payr0302VO  payr0302Vo = new Payr0302VO(); 
			    //tpPayr0307Vo = payr0307DAO.selectPayr0307Max(payr0307Vo); 
			    tpPayr0307Vo = payr0307DAO.selectPayr0307Max_2(payr0307Vo);			    
			    /**==========================해당하는 수당공제항목 삭제 후 인서트 처리 : PAYR0302 ==========================*/
                if  (MSFSharedUtils.paramNotNull(tpPayr0307Vo) && MSFSharedUtils.paramNotNull(tpPayr0307Vo.getSystemkey())) {
                    payr0302Vo.setDpobCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getDpobCd()));    											/** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPymtYrMnth()));										/** column 지급년월 : pymtYrMnth */
                    payr0302Vo.setPayCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPayCd()));    											/** column 급여구분코드 : payCd */
                    payr0302Vo.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPayrSeilNum(),"0")));    			/** column 급여일련번호 : payrSeilNum */
                    payr0302Vo.setSystemkey(MSFSharedUtils.allowNulls(tpPayr0307Vo.getSystemkey()));    									/** column SYSTEMKEY : systemkey */
                    payr0302Vo.setPayItemCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPayItemCd()));    									/** column 급여항목코드 : payItemCd */
                    payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));																		/** column 급여항목일련번호 : 	payItemSeilNum */
                    payr0302Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPymtDducDivCd()));    							/** column 지급공제구분코드 : pymtDducDivCd */
                    payr0302Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPymtDducFreeDtySum(),"0")));/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                    payr0302Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPymtDducSum(),"0")));    			/** column 지급공제금액 : pymtDducSum */
                    payr0302Vo.setPayPymtDducPrcsFlag("N");																					/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                    payr0302Vo.setPayReattyAdmntVal(String.valueOf(tpPayr0307Vo.getMnthPayAdmntSeilNum()));    								/** column 급여지급공제소급조정값 : payReattyAdmntVal */
                    payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPymtDducTxtnAmnt(),"0")));    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
                    payr0302Vo.setKybdr(sessionUser.getUsrId());																			/** column 입력자 : kybdr */
                    payr0302Vo.setInptAddr(request.getRemoteHost());																		/** column 입력주소 : inptAddr */
                    payr0302Vo.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
                    payr0302Vo.setRevnAddr(request.getRemoteHost());																		/** column 수정주소 : revnAddr */                
                }
                
                
                Payr0302VO  tpPayr0302Vo = new Payr0302VO();   
                //tpPayr0302Vo = payr0302DAO.selectPayr0302Payr0307_2(payr0302Vo);
                tpPayr0302Vo = payr0302DAO.selectPayr0302Payr0307(payr0302Vo); 
			    
			    //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
                payr0302DAO.deletePayr0302Payr0307(payr0302Vo);
                if  (MSFSharedUtils.paramNotNull(tpPayr0302Vo) && MSFSharedUtils.paramNotNull(tpPayr0302Vo.getSystemkey())) {
                    payr0302DAO.updatePayr0302Payr0307(payr0302Vo);
                } else {
                    payr0302DAO.insertPayr0302(payr0302Vo);
                } 
                /**========================== 해당하는 수당공제항목 삭제 후 인서트 처리 : PAYR0302 ==========================*/ 
                
                
                
                /**========================== 급여 변동사항 반영 ==========================*/ 
                InfcPkgPayr0302VO  calPayr0302Vo = new InfcPkgPayr0302VO(); 
			    
                calPayr0302Vo.setDpobCd(payr0302Vo.getDpobCd());							/** column 사업장코드 : dpobCd */
                calPayr0302Vo.setPymtYrMnth(payr0302Vo.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */
                calPayr0302Vo.setPayCd(payr0302Vo.getPayCd());    							/** column 급여구분코드 : payCd */
                calPayr0302Vo.setPayrSeilNum(payr0302Vo.getPayrSeilNum());					/** column 급여일련번호 : payrSeilNum */
                calPayr0302Vo.setSystemkey(payr0302Vo.getSystemkey());    					/** column SYSTEMKEY : systemkey */
                calPayr0302Vo.setPayItemCd(payr0302Vo.getPayItemCd());    					/** column 급여항목코드 : payItemCd */
                calPayr0302Vo.setPayItemSeilNum(payr0302Vo.getPayItemSeilNum());			/** column 급여항목일련번호 : payItemSeilNum */ 
                calPayr0302Vo.setPymtDducDivCd(payr0302Vo.getPymtDducDivCd());    			/** column 지급공제구분코드 : pymtDducDivCd */
                calPayr0302Vo.setPymtDducFreeDtySum(payr0302Vo.getPymtDducFreeDtySum());	/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                calPayr0302Vo.setPymtDducSum(payr0302Vo.getPymtDducSum());    				/** column 지급공제금액 : pymtDducSum */
                calPayr0302Vo.setPayPymtDducPrcsFlag(payr0302Vo.getPayPymtDducPrcsFlag());	/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                calPayr0302Vo.setPayReattyAdmntVal(payr0302Vo.getPayReattyAdmntVal());		/** column 급여지급공제소급조정값 : payReattyAdmntVal */
                calPayr0302Vo.setKybdr(payr0302Vo.getKybdr());								/** column 입력자 : kybdr */
                calPayr0302Vo.setInptDt(payr0302Vo.getInptDt());    						/** column 입력일자 : inptDt */
                calPayr0302Vo.setInptAddr(payr0302Vo.getInptAddr());						/** column 입력주소 : inptAddr */
                calPayr0302Vo.setIsmt(payr0302Vo.getIsmt());    							/** column 수정자 : ismt */
                calPayr0302Vo.setRevnDt(payr0302Vo.getRevnDt());							/** column 수정일자 : revnDt */
                calPayr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());						/** column 수정주소 : revnAddr */
                calPayr0302Vo.setPymtDducTxtnAmnt(payr0302Vo.getPymtDducTxtnAmnt());    	/** column 지급공제과세금액 : pymtDducTxtnAmnt */
			    
                
			    if (result > 0) {
                    PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
                    
                    //TODO RemoteServiceUtil.getThreadLocalRequest() 오류
                    result = (long) payrAdapter.setPayr4200ToPayCalcSeft(request, calPayr0302Vo);
                }
			    /**========================== 급여 변동사항 반영 ==========================*/ 
			    
//			    result = iCnt;
			    iCnt = iCnt + 1;       
			} 
			
			 result = iCnt;
	          
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsPayr0307To4200(): "+ex); 
	            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsPayr0307To4200", ex, logger);
		} finally {
	          
		}
		return result;
	}
	
}
