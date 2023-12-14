package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0134DTO;
import com.app.exterms.personal.client.service.Psnl0134Service;
import com.app.exterms.personal.server.service.dao.Psnl0134DAO;
import com.app.exterms.personal.server.vo.Psnl0134SrhVO;
import com.app.exterms.personal.server.vo.Psnl0134VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0134ServiceImpl.java
 * @Description : Psnl0134 Business Implement class
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
@Service("psnl0134Service")
public class Psnl0134ServiceImpl extends AbstractCustomServiceImpl implements Psnl0134Service {

    @Resource(name="psnl0134DAO")
    private Psnl0134DAO psnl0134DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0134ServiceImpl.class);
    private static final String calledClass = Psnl0134ServiceImpl.class.getName();

    
    /** 시찰(수행) 조회 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0134DTO> selectPsnl0134(BaseListLoadConfig config, HashMap<String, String> params)throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0134DTO> returnValue = new ArrayList<Psnl0134DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0134";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		Psnl0134SrhVO psnl0134SrhVo = new Psnl0134SrhVO();
		
		
		try {
			
			
			psnl0134SrhVo = new Psnl0134SrhVO();
			psnl0134SrhVo.setDpobCd(params.get("dpobCd"));
			psnl0134SrhVo.setSystemkey(params.get("systemkey"));
			psnl0134SrhVo.setAcmpInspnDivCd(params.get("acmpInspnDivCd"));
			
			egovResultDataList = psnl0134DAO.selectPsnl0134(psnl0134SrhVo);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0134DTO dto = new Psnl0134DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					//삭제 여부가 필요한 그리드 데이터일 경우 delChk를 false값을 필수로 넘겨준다.
					dto.setDelChk(false);
					returnValue.add(dto);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Psnl0134DTO>(returnValue);
	}

	
	/** 시찰(수행) 저장 **/
	@Override
	public Long savePsnl0134(Psnl0134DTO psnl0134Dto, ActionDatabase actionDatabase)throws Exception {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		
		String method = calledClass + ".savePsnl0134";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		Psnl0134VO psnl0134Vo = new Psnl0134VO(); 
		
		try{
			
			
			
			psnl0134Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    											/** column 사업장코드 : dpobCd */
			psnl0134Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0134Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
			psnl0134Vo.setAcmpInspnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0134Dto.getAcmpInspnSeilNum(), "0")));    /** column 수행시찰일련번호 : acmpInspnSeilNum */
			psnl0134Vo.setAcmpInspnDivCd(MSFSharedUtils.allowNulls(psnl0134Dto.getAcmpInspnDivCd()));    							/** column 수행시찰구분코드 : acmpInspnDivCd */
			psnl0134Vo.setAcmpInspnTtl(MSFSharedUtils.allowNulls(psnl0134Dto.getAcmpInspnTtl()));    								/** column 수행시찰제목 : acmpInspnTtl */
			psnl0134Vo.setAcmpInspnBgnnDt(SmrmfUtils.getStringFromDate(psnl0134Dto.getAcmpInspnBgnnDt(), "yyyyMMdd"));				/** column 수행시찰시작일자 : acmpInspnBgnnDt */
			psnl0134Vo.setAcmpInspnEndDt(SmrmfUtils.getStringFromDate(psnl0134Dto.getAcmpInspnEndDt(), "yyyyMMdd"));    			/** column 수행시찰종료일자 : acmpInspnEndDt */
			psnl0134Vo.setAcmpInspnDys(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0134Dto.getAcmpInspnDys(), "0")));   			/** column 수행시찰기간수 : acmpInspnDys */
			psnl0134Vo.setAcmpInspnNmCty(MSFSharedUtils.allowNulls(psnl0134Dto.getAcmpInspnNmCty()));    							/** column 수행시찰국명 : acmpInspnNmCty */
			psnl0134Vo.setAcmpInspnPurCtnt(MSFSharedUtils.allowNulls(psnl0134Dto.getAcmpInspnPurCtnt()));    						/** column 수행시찰목적내용 : acmpInspnPurCtnt */
			psnl0134Vo.setAcmpInspnRstCtnt(MSFSharedUtils.allowNulls(psnl0134Dto.getAcmpInspnRstCtnt()));    						/** column 수행시찰성과내용 : acmpInspnRstCtnt */
			psnl0134Vo.setAcmpInspnEtcCtnt(MSFSharedUtils.allowNulls(psnl0134Dto.getAcmpInspnEtcCtnt()));    						/** column 수행시찰기타내용 : acmpInspnEtcCtnt */
			psnl0134Vo.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
			psnl0134Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 수정주소 : revnAddr */
			
			
			
        	switch (actionDatabase) {
	    		case INSERT:
	    			
	    			psnl0134Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
	    			psnl0134Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
		          	
	    			psnl0134DAO.insertPsnl0134(psnl0134Vo); 
	    			result = new Long(1);
	    			break;
	        	case UPDATE: 
	        		psnl0134DAO.updatePsnl0134(psnl0134Vo); 
	        		result = new Long(1);
	        		break;
	        	case DELETE: 
	        		psnl0134DAO.deletePsnl0134(psnl0134Vo); 
	        		result = new Long(1);
	        		break;
        	} 
			
			
		}catch(Exception e){
			
			result = new Long(0); 
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");
		
		return result;
	}
	
	
	
	
	
	
 	/** 선택한 데이터를 가져옴 **/
 	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Psnl0134DTO selectPsnl0134Data(Psnl0134DTO psnl0134Dto)throws MSFException {
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		// TODO Auto-generated method stub
		Psnl0134DTO returnValue = new Psnl0134DTO();
		List egovResultDataList = new ArrayList();
		Psnl0134SrhVO psnl0134SrhVo = new Psnl0134SrhVO();
		
		
		String method = calledClass + ".selectPsnl0131";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		try {
			
			psnl0134SrhVo = new Psnl0134SrhVO();
			psnl0134SrhVo.setDpobCd(sessionUser.getDpobCd());
			psnl0134SrhVo.setSystemkey(psnl0134Dto.getSystemkey());
			psnl0134SrhVo.setAcmpInspnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0134Dto.getAcmpInspnSeilNum(), "0")));
			psnl0134SrhVo.setAcmpInspnDivCd(psnl0134Dto.getAcmpInspnDivCd());
			
			// 삭제처리 되지 않은 데이터만 가져옹.
			egovResultDataList = psnl0134DAO.selectPsnl0134(psnl0134SrhVo);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					returnValue = new Psnl0134DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		returnValue.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		returnValue.set(key, tempMap.get(key));
		            	}
			        }
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return returnValue;
	}

  
	
}
