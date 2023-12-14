package com.app.exterms.personal.server.service;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.basis.client.dto.InfcPkgBass0360DTO;
import com.app.exterms.personal.client.service.ComP010001Service;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0360DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360VO;

/**
 * @Class Name : Psnl0114ServiceImpl.java
 * @Description : Psnl0114 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@SuppressWarnings("serial")
@Service("ComPsnlP010001Service")
public class ComP010001ServiceImpl extends AbstractCustomServiceImpl implements ComP010001Service {

    @Resource(name="InfcPkgBass0360DAO")
    private InfcPkgBass0360DAO infcBass0360DAO;
    
	private static final Logger logger = LoggerFactory.getLogger(ComP010001ServiceImpl.class);
	private static final String calledClass = ComP010001ServiceImpl.class.getName();
    
	/** 단위기관 권한 조회 **/
	@Override
	public int selectBass0360List(InfcPkgBass0360DTO infcBass0360Dto)throws MSFException {
		
		String method = calledClass + ".selectBass0360List";
		
		String windowNm = "인사(공무직)";
		String windowId = "PSNL0100";
		
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		int result = 0;
		
		
		try{
			
			InfcPkgBass0360SrhVO infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
			
			infcBass0360SrhVo.setDpobCd(infcBass0360Dto.getDpobCd());
			infcBass0360SrhVo.setDeptCd(infcBass0360Dto.getDeptCd());
			infcBass0360SrhVo.setTypOccuCd(infcBass0360Dto.getTypOccuCd());
			infcBass0360SrhVo.setDtilOccuInttnCd(infcBass0360Dto.getDtilOccuInttnCd());
			infcBass0360SrhVo.setPayrMangDeptCd(infcBass0360Dto.getPayrMangDeptCd());
			
			result = infcBass0360DAO.selectBass0360ListTotCnt(infcBass0360SrhVo);
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "단위기관 조회 오류", e, logger);
			
		}		
		
		return result;
	}
	
	
	/** 단위기관 권한 조회 **/
	@Override
	public String insertBass0360List(InfcPkgBass0360DTO infcBass0360Dto)throws MSFException {
		
		String method = calledClass + ".selectBass0360List";
		
		String windowNm = "인사(공무직)";
		String windowId = "PSNL0100";
		
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String returnStr = "";
		
		
		try{
			
			InfcPkgBass0360SrhVO infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
			
			infcBass0360SrhVo.setDpobCd(sessionUser.getDpobCd());
			infcBass0360SrhVo.setDeptCd(infcBass0360Dto.getDeptCd());
			infcBass0360SrhVo.setTypOccuCd(infcBass0360Dto.getTypOccuCd());
			infcBass0360SrhVo.setDtilOccuInttnCd(infcBass0360Dto.getDtilOccuInttnCd());
			infcBass0360SrhVo.setPayrMangDeptCd(infcBass0360Dto.getPayrMangDeptCd());
			
			
			// 사업장, 부서, 직종, 직종세, 단위기관 체크
			int result = infcBass0360DAO.selectBass0360ListTotCnt(infcBass0360SrhVo);
			
			
			InfcPkgBass0360VO infcBass0360SVo = new InfcPkgBass0360VO();
			
			infcBass0360SVo.setDpobCd(sessionUser.getDpobCd());
			infcBass0360SVo.setDeptCd(infcBass0360Dto.getDeptCd());
			infcBass0360SVo.setTypOccuCd(infcBass0360Dto.getTypOccuCd());
			infcBass0360SVo.setDtilOccuInttnCd(infcBass0360Dto.getDtilOccuInttnCd());
			infcBass0360SVo.setPayrMangDeptCd(infcBass0360Dto.getPayrMangDeptCd());
			
    		if(result > 0) {
    			
    			// 기존에 맵핑되어있지 않은 자료가 있는지 체크
    			// 단위기관 부서, 직종, 직종세 비교
    			infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
    			
    			infcBass0360SrhVo.setDpobCd(sessionUser.getDpobCd());
    			infcBass0360SrhVo.setDeptCd(infcBass0360Dto.getDeptCd());
    			infcBass0360SrhVo.setTypOccuCd(infcBass0360Dto.getTypOccuCd());
    			infcBass0360SrhVo.setDtilOccuInttnCd(infcBass0360Dto.getDtilOccuInttnCd());
    			infcBass0360SrhVo.setPayrMangDeptCd(infcBass0360Dto.getPayrMangDeptCd());
    			infcBass0360SrhVo.setPayrMangDeptCdCk("chk");
    			
    			result = infcBass0360DAO.selectBass0360ListTotCnt(infcBass0360SrhVo);
    			
    			// 단위기관코드가 맵핑되어 있지 않은 자료가 존재할 경우 맵핑
    			if(result > 0) {
    				infcBass0360DAO.updateBass0360PayrMangDeptCd(infcBass0360SVo);
    				
    				returnStr = "Y";
    				
    			}else {
    				returnStr = "N";
//        			MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, "해당 부서의 직종, 직종세는 이미 단위기관이 등록되어 있습니다."); 
//        			throw MSFServerUtils.getValidationException("insertBass0360List", errMsg1, logger) ; 
    			}
    			
    		}else {
    			infcBass0360DAO.insertBass0360(infcBass0360SVo);
    			returnStr = "Y";
    		}
    		
    		
			
			
		}catch(Exception e){
			
			returnStr = "X";
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "단위기관 조회 오류", e, logger);
			
		}		
		
		return returnStr;
	}
	
    

}
