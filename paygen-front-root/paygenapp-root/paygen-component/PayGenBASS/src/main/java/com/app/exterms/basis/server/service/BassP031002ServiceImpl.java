package com.app.exterms.basis.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.basis.client.dto.Psnl2100DTO;
import com.app.exterms.basis.client.service.BassP031002Service;
import com.app.exterms.basis.server.service.dao.Psnl2100DAO;
import com.app.exterms.basis.server.vo.Psnl2100VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Service("BassP031002Service")
public class BassP031002ServiceImpl extends AbstractCustomServiceImpl implements
		BasisDaoConstants, BassP031002Service {

	private static final Logger logger = LoggerFactory.getLogger(BassP031002ServiceImpl.class);
	private static final String calledClass = BassP031002ServiceImpl.class
			.getName();

	@Autowired
	@Resource(name = "Psnl2100DAO")
	private Psnl2100DAO psnl2100DAO;

	@Override
	public int copyPkgHodyNumDysBass031002(List<Psnl2100DTO> listPsnl2100Dto)
			throws MSFException {

		String method = calledClass + ".copyPkgHodyNumDysBass031002";
		String windowNm = "휴가일수 일괄 복사";
		String windowId = "BASSP031001";

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		Psnl2100VO psnl2100Vo = new Psnl2100VO();
		int result = 0;

		try {

			for (int iBassCnt = 0; iBassCnt < listPsnl2100Dto.size(); iBassCnt++) {

				/** 기본 직종의 데이터 가져온다 */
				Psnl2100DTO psnl2100DTO = new Psnl2100DTO();
				psnl2100DTO = listPsnl2100Dto.get(iBassCnt);
				psnl2100Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				/** column 사업장코드 : dpobCd */
				psnl2100Vo.setTypOccuCd(psnl2100DTO.getBasicTypOccuCd());
				psnl2100Vo.setDtilOccuInttnCd(psnl2100DTO.getBasicDtilOccuClsDivCd());
				
				List<Psnl2100VO> psnl2100List;
			 	psnl2100List =  psnl2100DAO.selectCopyPsnl2100_D(psnl2100Vo);
			 	
			 	for(int iPsnlCnt=0;iPsnlCnt < psnl2100List.size();iPsnlCnt++) {
					
					System.out.println("listsize======================"+psnl2100List.size());	
					
					psnl2100Vo = new Psnl2100VO();			
					
					psnl2100Vo = psnl2100List.get(iPsnlCnt);
							
					psnl2100Vo.setTypOccuCd(psnl2100DTO.getTargetTypOccuCd());
					psnl2100Vo.setDtilOccuInttnCd(psnl2100DTO.getTargetDtilOccuClsDivCd());			
					psnl2100Vo.setHodyNumDysBgnnDt(psnl2100DTO.getApplicationDate());
					psnl2100Vo.setHodyNumDysEndDt("99991231");
					psnl2100Vo.setHodyNumDysUseYn("Y");
					psnl2100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
				 	psnl2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				 	psnl2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
				 	psnl2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				 	
				 	
		 			psnl2100DAO.insertCopyPsnl2100(psnl2100Vo);
		 			
		 			                    
				} 
			 	result = result + 1;
				/**
				 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치
				 * L:로그인 O:로그아웃
				 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C");
				

			}

			/**
			 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치
			 * L:로그인 O:로그아웃
			 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C");

		} catch (Exception e) {

			e.printStackTrace();

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,
					calledClass, "S:C", e, windowNm, windowId);

			throw MSFServerUtils.getOperationException(this.getClass()
					.getName() + " " + "오류 발생 <br> 관리자에게 문의해 주세요.", e,
					logger);

		}

		return result;
	}

}
