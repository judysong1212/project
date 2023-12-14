package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr1700ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0100DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0130DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130SrhVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr1700ExcelService")
public class Payr1700ExcelServiceImpl extends AbstractServiceImpl implements Payr1700ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Payr1700ExcelServiceImpl.class);
	private static final String calledClass = Payr1700ExcelService.class.getName();
	
	@Autowired
    @Resource(name="PrgmComPsnl0100DAO")
    private PrgmComPsnl0100DAO psnl0100DAO;
	
	@Autowired 
    @Resource(name="InfcPkgPsnl0130DAO")
    private InfcPkgPsnl0130DAO psnl0130DAO;
    
    //엑셀파일 저장_jxls(양식)
	public List  selectXlsFilePayr1700List(InfcPkgPsnl0130SrhVO psnl0130SrhVo) throws Exception {
		return psnl0130DAO.selectXlsPayr1700List(psnl0130SrhVo);
	}
	
    //엑셀파일 저장_jxls(상단)
	public List  selectXlsFilePayr170002List(InfcPkgPsnl0130SrhVO psnl0130SrhVo) throws Exception {
		// TODO 쿼리 수정 후 사용
		return psnl0130DAO.selectXlsPayr1700List(psnl0130SrhVo);
	}
	
	 /**
	  *  엑셀파일을 등록한다._jxls
	  * @param  hMap
	  * @throws Exception
	  */
	
	@Override
	public Long insertXlsPayr1700(List<InfcPkgPsnl0130VO> psnl0130List, HttpServletRequest request)throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
//		System.out.println(" psnl0130List.size : " + psnl0130List.size());
		
//		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		
		
		
		try {
			for(int iPsnlCnt = 0; iPsnlCnt < psnl0130List.size(); iPsnlCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());
				
				InfcPkgPsnl0130VO psnl0130Vo = new InfcPkgPsnl0130VO();
				psnl0130Vo = psnl0130List.get(iPsnlCnt);
				psnl0130Vo.setDpobCd(								sessionUser.getDpobCd());
				psnl0130Vo.setResnRegnGbn( MSFSharedUtils.allowNulls(psnl0130Vo.getResnRegnGbn()));
				
				
				if("Y".equals(psnl0130Vo.getResnRegnGbn()) || "Y"== psnl0130Vo.getResnRegnGbn()) {
					
					// 2. 파라미터 보낼 때(암호화)
					psnl0130Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0130Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

				}else {
					psnl0130Vo.setResnRegnNum( MSFSharedUtils.allowNulls(psnl0130Vo.getResnRegnNum()));
//					psnl0130Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0130Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				}
				
				
				
				psnl0130Vo.setHanNm(	   MSFSharedUtils.allowNulls(psnl0130Vo.getHanNm()).trim());
				psnl0130Vo.setPayCd(	   MSFSharedUtils.allowNulls(psnl0130Vo.getPayCd()));
				psnl0130Vo.setPayNm(	   MSFSharedUtils.allowNulls(psnl0130Vo.getPayNm()));
				psnl0130Vo.setBnkCd(	   MSFSharedUtils.allowNulls(psnl0130Vo.getBnkCd()));
				psnl0130Vo.setBnkNm(	   MSFSharedUtils.allowNulls(psnl0130Vo.getBnkNm()));
				psnl0130Vo.setBnkAccuNum(  MSFSharedUtils.allowNulls(psnl0130Vo.getBnkAccuNum()));
				psnl0130Vo.setAcntHodrNm(  MSFSharedUtils.allowNulls(psnl0130Vo.getAcntHodrNm()));
				psnl0130Vo.setRpsttvAccuYn(MSFSharedUtils.allowNulls(psnl0130Vo.getRpsttvAccuYn()));
				psnl0130Vo.setAccuNoteCtnt(MSFSharedUtils.allowNulls(psnl0130Vo.getAccuNoteCtnt()));
				psnl0130Vo.setKybdr(								sessionUser.getUsrId());
				psnl0130Vo.setInptAddr(									request.getRemoteAddr());
				psnl0130Vo.setIsmt(									sessionUser.getUsrId());
				psnl0130Vo.setRevnAddr(									request.getRemoteAddr());
				
				logger.debug("getDpobCd : " + sessionUser.getDpobCd());
				logger.debug("getResnRegnGbn : " + psnl0130Vo.getResnRegnGbn());
				logger.debug("getResnRegnNum : " + psnl0130Vo.getResnRegnNum());
				logger.debug("getHanNm : " + psnl0130Vo.getHanNm());
				logger.debug("getPayCd : " + psnl0130Vo.getPayCd());
				logger.debug("getPayNm : " + psnl0130Vo.getPayNm());
				logger.debug("getBnkCd : " + psnl0130Vo.getBnkCd());
				logger.debug("getBnkNm : " + psnl0130Vo.getBnkNm());
				logger.debug("getBnkAccuNum : " + psnl0130Vo.getBnkAccuNum());
				logger.debug("getAcntHodrNm : " + psnl0130Vo.getAcntHodrNm());
				logger.debug("getRpsttvAccuYn : " + psnl0130Vo.getRpsttvAccuYn());
				logger.debug("getAccuNoteCtnt : " + psnl0130Vo.getAccuNoteCtnt());
				
				psnl0130DAO.deleteXlsPayr1700(psnl0130Vo);
				psnl0130DAO.insertXlsPayr1700(psnl0130Vo);
				
				iCnt = iCnt + 1;
			}
			result = iCnt;
		} catch (Exception ex) {
			logger.error("EXCEPTION calling insertXlsPayr1700(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("insertXlsPayr1700", ex, logger);
		} finally {
			
		}
		return result;
	}
}