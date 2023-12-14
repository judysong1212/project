package org.msf.exterms.remt.xls.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.remt.xls.service.Remt0400ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.retirement.server.service.Remt0400ServiceImpl;
import com.app.exterms.retirement.server.service.dao.Remt9000DAO;
import com.app.exterms.retirement.server.vo.Remt9000SrhVO;
import com.app.exterms.retirement.server.vo.Remt9000VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("remt0400ExcelService")
public class Remt0400ExcelServiceImpl extends AbstractServiceImpl implements Remt0400ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Remt0400ServiceImpl.class);
	private static final String calledClass = Remt0400ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="Remt9000DAO")
    private Remt9000DAO remt9000DAO;
    
//    @Autowired
//	@Resource(name = "InfcPkgRemt9000DAO")
//	private InfcPkgRemt9000DAO pkremt9000DAO;

//	public List selectXlsRemt9000List(InfcPkgRemt9000SrhVO searchVO)throws Exception {
//		return pkremt9000DAO.selectRemt9000List(searchVO);
//	}
	

	@Override
	public List selectXlsFileRemt0400List(Remt9000SrhVO remt9000SrhVo)
			throws Exception {
		
		return remt9000DAO.selectXlsRemt0400List(remt9000SrhVo);
	}

	@Override
	public List<Remt9000VO> updateXlsRemt0400(List<Remt9000VO> remt9000List,
			HttpServletRequest request) throws MSFException {
		// TODO Auto-generated method stub
				Long result = new Long(0);
				Long iCnt = new Long(0);
				String strValue = "";				
				String rrnDecCrypt = "";	// 2.복호화 리턴받을 값 선언
				Remt9000VO remt9000vo = new Remt9000VO();  
				
				int monthS = 1;
				int monthE = 12;
				int maxDays = 0;
				
				List<Remt9000VO> errRemt0400List = new ArrayList<Remt9000VO>();
				MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
				 				
				
				try {  
					errRemt0400List = new ArrayList<Remt9000VO>();
					
					List psnl0100List = null;
					
					for(int iPsnlCnt=0;iPsnlCnt < remt9000List.size();iPsnlCnt++) {
						
						System.out.println("listsize======================"+remt9000List.size());
						
						psnl0100List = null;
						
						// 1. 암호화 객체 생성
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
						
						remt9000vo = new Remt9000VO();  
						remt9000vo = remt9000List.get(iPsnlCnt);
												
						remt9000vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd())); /** set 사업장코드 : dpobCd */
//						remt9000vo.setSystemkey(MSFSharedUtils.allowNulls(remt9000vo.getSystemkey()));/** set SYSTEMKEY : systemkey */
							
						
						// 주민번호를 암호화 하여 systemkey를 찾는다.
						remt9000vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(remt9000vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));			
							
						psnl0100List = remt9000DAO.selectRemt0400ToPsnl0100List(remt9000vo);
						
						remt9000vo = new Remt9000VO(); 
						
						remt9000vo = remt9000List.get(iPsnlCnt);
						
						for(int i=0; i<psnl0100List.size(); i++){
							
							System.out.println("listsize22222======================"+psnl0100List.size());
							EgovMap eMap  = new EgovMap();
							eMap = (EgovMap) psnl0100List.get(i);
							System.out.println("eMap======================"+eMap.toString());
							strValue = MSFSharedUtils.allowNulls(eMap.get("systemkey"));
							remt9000vo.setHanNm(MSFSharedUtils.allowNulls(eMap.get("hanNm")));
							remt9000vo.setSystemkey(strValue);   	/** column SYSTEMKEY : systemkey */
						}
								
						remt9000vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(remt9000vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
						remt9000vo.setSevePayClutMangeNum(MSFSharedUtils.allowNulls(remt9000vo.getSevePayClutMangeNum()));/** set 퇴직금정산관리번호 : sevePayClutMangeNum */
						remt9000vo.setCalcSevePayPsnBlggYr(remt9000vo.getCalcSevePayPsnBlggYr());/** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
						remt9000vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt9000vo.getCalcSevePayPsnDivCd()));/** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
						remt9000vo.setIcncDt(remt9000vo.getIcncDt());/** set 입사일자 : icncDt */
					    remt9000vo.setRkfcdDt(remt9000vo.getRkfcdDt());/** set 기산일자 : rkfcdDt */
					    remt9000vo.setRsgtnDt(remt9000vo.getRsgtnDt());/** set 퇴사일자 : rsgtnDt */
					    remt9000vo.setPymtDt(remt9000vo.getPymtDt());/** set 지급일자 : pymtDt */
					    remt9000vo.setEepnMnthIcm2012Bfr(remt9000vo.getEepnMnthIcm2012Bfr());/** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
					    remt9000vo.setEepnMnthIcm2013Aft(remt9000vo.getEepnMnthIcm2013Aft());/** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
					    remt9000vo.setAddMnthIcm2012Bfr(remt9000vo.getAddMnthIcm2013Aft());/** set 가산월수_2012이전 : addMnthIcm2012Bfr */
					    remt9000vo.setAddMnthIcm2013Aft(remt9000vo.getAddMnthIcm2013Aft());/** set 가산월수_2013이후 : addMnthIcm2013Aft */
					    remt9000vo.setRetryPayQnty(remt9000vo.getRetryPayQnty());/** set 퇴직급여액 : retryPayQnty */
					    remt9000vo.setFreeDtyRetryPayQnty(remt9000vo.getFreeDtyRetryPayQnty());/** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
					    remt9000vo.setAlpayTxAmnt(remt9000vo.getAlpayTxAmnt());/** set 기납부소득세 : alpayTxAmnt */
					    remt9000vo.setLocIncmTxAmt(remt9000vo.getLocIncmTxAmt());/** set 지방소득세 : locIncmTxAmt */
					    remt9000vo.setPernPymtSum(remt9000vo.getPernPymtSum());/** set 차인지급액 : pernPymtSum */
					    remt9000vo.setSevePayCtrClutNoteCtnt(MSFSharedUtils.allowNulls(remt9000vo.getSevePayCtrClutNoteCtnt()));/** set 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
					    remt9000vo.setAmcrrClutInsnYn(remt9000vo.getAmcrrClutInsnYn());/** set 군경력정산포함여부 : amcrrClutInsnYn */
					    
					    remt9000vo.setKybdr(sessionUser.getUsrId());/** set 입력자 : kybdr */
					    remt9000vo.setInptAddr(request.getRemoteHost());/** set 입력주소 : inptAddr */
					    remt9000vo.setIsmt(sessionUser.getUsrId()); /** set 수정자 : ismt */
					    remt9000vo.setRevnAddr(request.getRemoteHost());/** set 수정주소 : revnAddr */
					  					    
					    // 시스템키 있으면
						if(!"X".equals(MSFSharedUtils.defaultNulls(remt9000vo.getSystemkey(), "X"))) {
//							
//							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(remt9000vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//							remt9000vo.setResnRegnNum(rrnDecCrypt);
//							errRemt0400List.add(remt9000vo);
							
							if(remt9000vo.getRkfcdDt()!= remt9000vo.getRsgtnDt()){
//								remt9000DAO.deleteXlsRemt0400(remt9000vo); 
						    	remt9000DAO.insertXlsRemt0400(remt9000vo); 
						    }
							
						}else{
						// 3.복호화
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(remt9000vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						remt9000vo.setResnRegnNum(rrnDecCrypt);
						errRemt0400List.add(remt9000vo);
						}			                    
					} 
					result = new Long(1);
			          
			        } catch (Exception ex) {
			        	
			            logger.error("EXCEPTION calling updateXlsRemt0400(): "+ex); 
			            
			            result = new Long(0);
			            throw MSFServerUtils.getOperationException("updateXlsRemt0400", ex, logger);
			        }
			        finally {
			          
			        }
				return errRemt0400List;
	}
	
	

}
