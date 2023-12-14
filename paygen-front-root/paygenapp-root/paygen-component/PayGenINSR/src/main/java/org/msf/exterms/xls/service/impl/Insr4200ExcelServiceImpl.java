package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr4200ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.Insr4200ServiceImpl;
import com.app.exterms.insurance.server.service.dao.Insr3200DAO;
import com.app.exterms.insurance.server.service.dao.Insr3300DAO;
import com.app.exterms.insurance.server.vo.Insr3200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr3200SrhVO;
import com.app.exterms.insurance.server.vo.Insr3200VO;
import com.app.exterms.insurance.server.vo.Insr3300VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Insr4200ExcelService")
public class Insr4200ExcelServiceImpl extends AbstractServiceImpl implements Insr4200ExcelService {
	private static final Logger logger = LoggerFactory.getLogger(Insr4200ServiceImpl.class);
	private static final String calledClass = Insr4200ExcelService.class.getName();
	
	@Autowired
	@Resource(name = "Insr3200DAO")
	private Insr3200DAO insr3200DAO;
	
	@Autowired
	@Resource(name = "Insr3300DAO")
	private Insr3300DAO insr3300DAO;
	
	public List selectXlsInsr4200ToInsr3200List(Insr3200SrhVO insr3200SrhVO) throws Exception {
		return insr3200DAO.selectXlsInsr4200ToInsr3200List(insr3200SrhVO);
	}
	
	/**
	 * 엑셀파일을 등록한다.
	 * @param
	 * @throws Exception
	 */
	
	@Override
	public Long updateXlsInsr4200(List<Insr3200ExcelVO> insr3200List, HttpServletRequest request)throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		int chkRegNum = 0;    // 주민번호로 시스템에 건강보험 가입 직원인지 체크  
//		System.out.println("updateXlsInsr4200 ENter ==============================================okokokokokokokokok");
//		System.out.println(" insr3200List.size : " + insr3200List.size());
		
//		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		try {

			for(int iPsnlCnt = 0; iPsnlCnt < insr3200List.size(); iPsnlCnt++) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				int retVal = 0;
				
				Insr3200VO insr3200Vo = new Insr3200VO();
				Insr3200ExcelVO insr3200ExcelVo = new Insr3200ExcelVO();
				
				Insr3300VO insr3300Vo = new Insr3300VO();
				
				insr3200ExcelVo = insr3200List.get(iPsnlCnt);
				
				insr3200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				retVal=insr3200DAO.selectInsr3000RegChkCnt(insr3200Vo);
				
				System.out.println("retVal=========================="+retVal);
				
				if(retVal > 0){  // 재직중인 인원만 월별 건강대사 테이블 insert
				
					insr3200Vo = new Insr3200VO();
					insr3200ExcelVo = new Insr3200ExcelVO();
					insr3200ExcelVo = insr3200List.get(iPsnlCnt);
					
					insr3200Vo.setSystemkey( insr3200Vo.getSystemkey());
					insr3200Vo.setDpobCd(												   sessionUser.getDpobCd());
					insr3200Vo.setNofctYrMnth(	 MSFSharedUtils.allowNulls(	insr3200ExcelVo.getNofctYrMnth()));
					insr3200Vo.setNofctDspty(												new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getNofctDspty(),			  "0")));
					insr3200Vo.setEmymtSeilNum(		   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getEmymtSeilNum(),		"0")));
					insr3200Vo.setDpobMangeNum(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getDpobMangeNum()));
					insr3200Vo.setUntIstutCd(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getUntIstutCd()));
					insr3200Vo.setAccSgn(						MSFSharedUtils.allowNulls(	insr3200ExcelVo.getAccSgn()));
					insr3200Vo.setHlthInsrCertNum(				MSFSharedUtils.allowNulls(	insr3200ExcelVo.getHlthInsrCertNum()));
					insr3200Vo.setHanNm(						MSFSharedUtils.allowNulls(	insr3200ExcelVo.getHanNm()));
					//insr3200Vo.setResnRegnNum(					MSFSharedUtils.allowNulls(	insr3200Vo.getResnRegnNum()));
					insr3200Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
					
					
					insr3200Vo.setReduReasCd(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getReduReasCd()));
					insr3200Vo.setReduReasNm(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getReduReasNm()));
					insr3200Vo.setHlthInsrTypOccuCd(			MSFSharedUtils.allowNulls(	insr3200ExcelVo.getHlthInsrTypOccuCd()));
					insr3200Vo.setPayMnthAmntGrde(				MSFSharedUtils.allowNulls(	insr3200ExcelVo.getPayMnthAmntGrde()));
					insr3200Vo.setPayMnthAmnt(		   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getPayMnthAmnt(),		  "0")));
					insr3200Vo.setDducYrMnth(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getDducYrMnth()));
					insr3200Vo.setHlthInsrPrcsYn(				MSFSharedUtils.allowNulls(	insr3200ExcelVo.getHlthInsrPrcsYn()));
					insr3200Vo.setCalcPrmm(			   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getCalcPrmm(),			  "0")));
					insr3200Vo.setSanCalcPrmm(		   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getSanCalcPrmm(),		  "0")));
					insr3200Vo.setHlthInsrPrmmSrd(	   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getHlthInsrPrmmSrd(),	  "0")));
					insr3200Vo.setClutReasCd(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getClutReasCd()));
					insr3200Vo.setClutApptnBgnnYrMnth(			MSFSharedUtils.allowNulls(	insr3200ExcelVo.getClutApptnBgnnYrMnth()));
					insr3200Vo.setClutApptnEndYrMnth(			MSFSharedUtils.allowNulls(	insr3200ExcelVo.getClutApptnEndYrMnth()));
					insr3200Vo.setClutPrmm(			   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getClutPrmm(),			  "0")));
					insr3200Vo.setNofctPrmm(		   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getNofctPrmm(),			  "0")));
					insr3200Vo.setYrtxPrmm(			   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getYrtxPrmm(),			  "0")));
					insr3200Vo.setAqtnDt(						MSFSharedUtils.allowNulls(	insr3200ExcelVo.getAqtnDt()));
					insr3200Vo.setLssDt(						MSFSharedUtils.allowNulls(	insr3200ExcelVo.getLssDt()));
					insr3200Vo.setLgtmRcptnCalcPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnCalcPrmm(),	  "0")));
					insr3200Vo.setSanLgtmRcptnCalcPrmm(new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getSanLgtmRcptnCalcPrmm(), "0")));
					insr3200Vo.setLgtmRcptnInsurSrd(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnInsurSrd(),	  "0")));
					insr3200Vo.setLgtmRcptnClutReasCd(			MSFSharedUtils.allowNulls(	insr3200ExcelVo.getLgtmRcptnClutReasCd()));
					insr3200Vo.setLgtmRcptnApptnBgnnYrMnth(		MSFSharedUtils.allowNulls(	insr3200ExcelVo.getLgtmRcptnApptnBgnnYrMnth()));
					insr3200Vo.setLgtmRcptnApptnEndYrMnth(		MSFSharedUtils.allowNulls(	insr3200ExcelVo.getLgtmRcptnApptnEndYrMnth()));
					insr3200Vo.setLgtmRcptnClutPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnClutPrmm(),	  "0")));
					insr3200Vo.setLgtmRcptnNofctPrmm(  new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnNofctPrmm(),   "0")));
					insr3200Vo.setLgtmRcptnYrtxPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnYrtxPrmm(),	  "0")));
					insr3200Vo.setHlthRcptnCalcPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getHlthRcptnCalcPrmm(),	  "0")));
					insr3200Vo.setHlthRcptnClutPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getHlthRcptnClutPrmm(),	  "0")));
					insr3200Vo.setHlthRcptnNofctPrmm(  new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getHlthRcptnNofctPrmm(),   "0")));
					insr3200Vo.setHlthRcptnYrtxPrmm(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getHlthRcptnYrtxPrmm(),	  "0")));
					insr3200Vo.setHlthInsrRefdItrt(	   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getHlthInsrRefdItrt(),	  "0")));
					insr3200Vo.setLgtmRcptnRefdItrt(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnRefdItrt(),	  "0")));
					insr3200Vo.setTotPymtPrmm(		   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getTotPymtPrmm(),		  "0")));
					insr3200Vo.setSrdAggrSum(		   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getSrdAggrSum(),			  "0")));
					insr3200Vo.setKybdr(												   sessionUser.getUsrId());
					insr3200Vo.setInptDt(													insr3200ExcelVo.getInptDt());
	//				insr3200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					insr3200Vo.setIsmt(													   sessionUser.getUsrId());
					insr3200Vo.setRevnDt(													insr3200ExcelVo.getRevnDt());
	//				insr3200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					insr3200DAO.deleteXlsInsr3200(insr3200Vo);
					insr3200DAO.insertXlsInsr3200(insr3200Vo);
					
					
					insr3300Vo.setDpobCd(												   sessionUser.getDpobCd());
					insr3300Vo.setNofctYrMnth(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getNofctYrMnth()));
					insr3300Vo.setNofctDspty(												 new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getNofctDspty(),	  "0")));
					insr3300Vo.setSystemkey(												insr3200ExcelVo.getSystemkey());
					insr3300Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr3200ExcelVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
					insr3300Vo.setDducYrMnth(					MSFSharedUtils.allowNulls(	insr3200ExcelVo.getDducYrMnth()));
					insr3300Vo.setHlthInsrPrcsYn(				MSFSharedUtils.allowNulls(	insr3200ExcelVo.getHlthInsrPrcsYn()));
					insr3300Vo.setYrtxPrmm(			new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getClutPrmm(),	  "0")));   /* 건강보험정산보험료 */
					insr3300Vo.setLgtmRcptnYrtxPrmm(			new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnClutPrmm(),	  "0")));  /* 장기요양정산보험료 */
					insr3300Vo.setHlthInsrRefdItrt(			new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getHlthInsrRefdItrt(),	  "0")));  /* 건강보험환급금이자 */
					insr3300Vo.setLgtmRcptnInsurRefdItrt(   new Long(MSFSharedUtils.defaultNulls(insr3200ExcelVo.getLgtmRcptnRefdItrt(),	  "0")));  /* 장기요양보험환급금이자 */
					insr3300Vo.setKybdr(												   sessionUser.getUsrId());
					insr3300Vo.setInptDt(													insr3200ExcelVo.getInptDt());
					insr3300Vo.setIsmt(													   sessionUser.getUsrId());
					insr3300Vo.setRevnDt(													insr3200ExcelVo.getRevnDt());
					
					insr3300DAO.deleteXlsInsr3300(insr3300Vo);
					insr3300DAO.insertXlsInsr3300(insr3300Vo);
					
					iCnt = iCnt +1L;
				
				} // end if 
				System.out.println("iCnt=========================="+iCnt);
            } // end for
			
			result = iCnt;
			System.out.println("result=========================="+result);
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsInsr4200(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsInsr4200", ex, logger);
		} finally {
			
		}
		return result;
	}
}