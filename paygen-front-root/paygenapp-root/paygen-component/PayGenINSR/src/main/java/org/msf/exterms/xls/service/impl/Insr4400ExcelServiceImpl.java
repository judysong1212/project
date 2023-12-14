package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr4400ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr3150DAO;
import com.app.exterms.insurance.server.vo.Insr3150SrhVO;
import com.app.exterms.insurance.server.vo.Insr3150VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Insr4400ExcelService")
public class Insr4400ExcelServiceImpl extends AbstractServiceImpl implements Insr4400ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Insr4400ExcelServiceImpl.class);
	private static final String calledClass = Insr4400ExcelServiceImpl.class.getName();
    
    @Autowired 
    @Resource(name="Insr3150DAO")
    private Insr3150DAO insr3150DAO;
 

  
	public List selectXlsInsr4400List(Insr3150SrhVO insr3150SrhVo) throws Exception {
		// TODO Auto-generated method stub
		 return insr3150DAO.selectXlsInsr4400ToInsr3150List(insr3150SrhVo);
	} 
	
	public List selectTxtInsr4400ToInsr3150List(Insr3150SrhVO insr3150SrhVo) throws Exception {
		// TODO Auto-generated method stub
		 return insr3150DAO.selectTxtInsr4400ToInsr3150List(insr3150SrhVo);
	} 
	
	@Override
	public Long updateXlsInsr4400(List<Insr3150VO> insr3150List, HttpServletRequest request)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
//		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {  

			
			for(int iInsrCnt=0;iInsrCnt < insr3150List.size();iInsrCnt++) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());				
				
				Insr3150VO insr3150Vo = new Insr3150VO();  
				Insr3150VO tpInsr3150Vo = new Insr3150VO();  
				insr3150Vo = insr3150List.get(iInsrCnt);
				
				//TODO 주민등록번호로 체크한 후에 넣기. 
				
 				insr3150Vo.setDpobCd(sessionUser.getDpobCd());			/** column 사업장코드 : dpobCd */
				insr3150Vo.setHlthInsrYr(MSFSharedUtils.allowNulls(insr3150Vo.getHlthInsrYr()));   /** column 건간보험정산귀속년도 : hlthInsrYr */
//				insr3150Vo.setSystemkey(insr3150Vo.getSystemkey());    	/** column SYSTEMKEY : systemkey */
			//	insr3150Vo.setHlthInsrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getHlthInsrSeilNum(), "0")));		/** column 건강보험일련번호 : hlthInsrSeilNum */
				insr3150Vo.setDspty(MSFSharedUtils.allowNulls(insr3150Vo.getDspty()));	/** column 차수 : dspty */
				insr3150Vo.setDpobMangeNum(MSFSharedUtils.allowNulls(insr3150Vo.getDpobMangeNum()));    /** column 사업장관리번호 : dpobMangeNum */
				insr3150Vo.setAcc(MSFSharedUtils.allowNulls(insr3150Vo.getAcc()));    	/** column 회계 : acc */
				insr3150Vo.setUntDpobCd(MSFSharedUtils.allowNulls(insr3150Vo.getUntDpobCd()));		/** column 단위사업장코드 : untDpobCd */
				insr3150Vo.setCertNumHuhd(MSFSharedUtils.allowNulls(insr3150Vo.getCertNumHuhd()));	/** column 증번호 : certNumHuhd */
				insr3150Vo.setHlthNm(MSFSharedUtils.allowNulls(insr3150Vo.getHlthNm()));			/** column 성명 : hlthNm */
				insr3150Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr3150Vo.getResnRegnNum()));			/** column 주민등록번호 : resnRegnNum */
				
				insr3150Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3150Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				insr3150Vo.setHlthInsrAqtnDt(MSFSharedUtils.allowNulls(insr3150Vo.getHlthInsrAqtnDt()));   	/** column 건강보험취득일자 : hlthInsrAqtnDt */
				insr3150Vo.setIposPrmmMnthHlth(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getIposPrmmMnthHlth(), "0")));	/** column 보험료부과월수_건강 : iposPrmmMnthHlth */
				insr3150Vo.setIposPrmmMnthRcptn(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getIposPrmmMnthRcptn(), "0"))); /** column 보험료부과월수_장기 : iposPrmmMnthRcptn */
				insr3150Vo.setIposTotPrmmAggr(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getIposTotPrmmAggr(), "0")));    	/** column 부과한총보험료_계 : iposTotPrmmAggr */
				insr3150Vo.setIposTotPrmmHlth(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getIposTotPrmmHlth(), "0")));    	/** column 부과한총보험료_건강 : iposTotPrmmHlth */
				insr3150Vo.setIposTotPrmmLgtmRcptn(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getIposTotPrmmLgtmRcptn(), "0")));	/** column 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
				insr3150Vo.setYrlyPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getYrlyPayTotAmnt(), "0")));		/** column 연간보수총액 : yrlyPayTotAmnt */
				insr3150Vo.setDutyMnthIcm(new BigDecimal(MSFSharedUtils.defaultNulls(insr3150Vo.getDutyMnthIcm(), "0")));				/** column 근무월수 : dutyMnthIcm */
				insr3150Vo.setNofctSspn(MSFSharedUtils.allowNulls(insr3150Vo.getNofctSspn()));	/** column 고지유예 : nofctSspn */
				insr3150Vo.setKybdr(sessionUser.getUsrId());			/** column 입력자 : kybdr */
//				insr3150Vo.setInptDt(insr3150Vo.getInptDt());		/** column 입력일자 : inptDt */
//				insr3150Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
				insr3150Vo.setIsmt(sessionUser.getUsrId());			/** column 수정자 : ismt */
//				insr3150Vo.setRevnDt(insr3150Vo.getRevnDt());		/** column 수정일자 : revnDt */
//				insr3150Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
	          	
				tpInsr3150Vo = insr3150DAO.selectInsr4400ToInsr3150(insr3150Vo);  
				
				if(MSFSharedUtils.paramNotNull(tpInsr3150Vo) && MSFSharedUtils.paramNotNull(tpInsr3150Vo.getSystemkey()) ) { 
					
					insr3150Vo.setSystemkey(tpInsr3150Vo.getSystemkey());
					 
					insr3150DAO.deleteXlsInsr3150(insr3150Vo);
					insr3150DAO.insertXlsInsr3150(insr3150Vo); 
				}         
			} 
			result = iCnt;
	          
	        } catch (Exception ex) {
	            logger.error("EXCEPTION calling updateXlsInsr4400(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("updateXlsInsr4400", ex, logger);
	        }
	        finally {
	          
	        }
		return result;
	}
	
	public void updateTxtFileInsr3150(Insr3150VO vo) throws MSFException {
		try {
			insr3150DAO.updateTxtFileInsr3150(vo);
		} catch(Exception e) {
			logger.error("EXCEPTION calling updateTxtFileInsr3150(): " + e);
			throw MSFServerUtils.getOperationException("updateTxtFileInsr3150", e, logger);
		}
	}
}