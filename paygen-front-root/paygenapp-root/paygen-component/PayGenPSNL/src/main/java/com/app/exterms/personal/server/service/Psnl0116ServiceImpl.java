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

import com.app.exterms.personal.client.dto.Psnl0116DTO;
import com.app.exterms.personal.client.service.Psnl0116Service;
import com.app.exterms.personal.server.service.dao.Psnl0116DAO;
import com.app.exterms.personal.server.vo.Psnl0116VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0116ServiceImpl.java
 * @Description : Psnl0116 Business Implement class
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
@Service("psnl0116Service")
public class Psnl0116ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0116Service {

    @Resource(name="psnl0116DAO")
    private Psnl0116DAO psnl0116DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0116ServiceImpl.class);
    private static final String calledClass = Psnl0116ServiceImpl.class.getName();
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0116DTO> selectPsnl0116(BaseListLoadConfig config, HashMap<String, String> params)throws Exception {
    	
    	String method = calledClass + ".selectPsnl0116";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    	
		// TODO Auto-generated method stub
    	List<Psnl0116DTO> returnValue = new ArrayList<Psnl0116DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			
			egovResultDataList = psnl0116DAO.selectPsnl0116(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0116DTO dto = new Psnl0116DTO();
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
		
		return new BaseListLoadResult<Psnl0116DTO>(returnValue);
	}

	@Override
	public String savePsnl0116(ArrayList<Psnl0116DTO> changePsnl0116List)throws Exception {
		
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".changePsnl0116List";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			if(changePsnl0116List!=null && changePsnl0116List.size() > 0){
				for ( int i = 0; i < changePsnl0116List.size(); i++){
					
					Psnl0116VO psnl0116Vo = new Psnl0116VO();
					
					psnl0116Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getDpobCd()));    /** column 사업장코드 : dpobCd */
					psnl0116Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getSystemkey()));    /** column SYSTEMKEY : systemkey */
					
					psnl0116Vo.setEtncItshlDt(SmrmfUtils.getStringFromDate(changePsnl0116List.get(i).getEtncItshlDt(), "yyyyMMdd"));    		/** column 입학일자 : etncItshlDt */
					psnl0116Vo.setGrdtnDt(SmrmfUtils.getStringFromDate(changePsnl0116List.get(i).getGrdtnDt(), "yyyyMMdd"));	/** column 졸업일자 : grdtnDt */
					psnl0116Vo.setAcadAbtyDivCd(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getAcadAbtyDivCd()));    		/** column 학력구분코드 : acadAbtyDivCd */
					psnl0116Vo.setSchlCd(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getSchlCd()));    			/** column 학교코드 : schlCd */
					psnl0116Vo.setDeprMajrCd(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getDeprMajrCd()));    	/** column 학과코드 : deprMajrCd */
					psnl0116Vo.setMjrSpctyNm(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getMjrSpctyNm()));    	/** column 전공명 : mjrSpctyNm */
					psnl0116Vo.setMnrNm(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getMnrNm()));    			/** column 부전공명 : mnrNm */
					psnl0116Vo.setNatnCd(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getNatnCd()));    			/** column 국가코드 : natnCd */
					psnl0116Vo.setDegrNm(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getDegrNm()));    			/** column 학위명 : degrNm */
					psnl0116Vo.setDegrDivCd(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getDegrDivCd()));    	/** column 학위구분코드 : degrDivCd */
//					psnl0116Vo.setDegrAqtnDt(MSFServerUtils.getStringFromDate(changePsnl0116List.get(i).getDegrAqtnDt(), "yyyyMMdd"));    /** column 학위취득일자 : degrAqtnDt */
					psnl0116Vo.setLesnYrNumCd(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getLesnYrNumCd()));	/** column 수업년수코드 : lesnYrNumCd */
					psnl0116Vo.setAcadAbtyNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0116List.get(i).getAcadAbtyNoteCtnt()));    /** column 학력비고내용 : acadAbtyNoteCtnt */
					
					if(changePsnl0116List.get(i).getDelChk()){
						psnl0116Vo.setAcadAbtySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0116List.get(i).getAcadAbtySeilNum(), "0")));/** column 학력사항일련번호 : acadAbtySeilNum */
//						psnl0116DAO.deletePsnl0116(changePsnl0116List.get(i));
						psnl0116DAO.deletePsnl0116(psnl0116Vo);
						delCnt++;
						
					}else{
//						MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0116List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0116List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						psnl0116Vo.setIsmt(sessionUser.getUsrId());
						psnl0116Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						if(changePsnl0116List.get(i).getAcadAbtySeilNum() != null){
							psnl0116Vo.setAcadAbtySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0116List.get(i).getAcadAbtySeilNum(), "0")));/** column 학력사항일련번호 : acadAbtySeilNum */
							
//							psnl0116DAO.updatePsnl0116(changePsnl0116List.get(i));
							psnl0116DAO.updatePsnl0116(psnl0116Vo);
							
						}else{
							psnl0116Vo.setAcadAbtySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0116List.get(i).getAcadAbtySeilNum(), "0")));/** column 학력사항일련번호 : acadAbtySeilNum */
							
//							psnl0116DAO.insertPsnl0116(changePsnl0116List.get(i));
							psnl0116DAO.insertPsnl0116(psnl0116Vo);
							
						}
						saveCnt++;
						
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U:D:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U:D:C");
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
    
}
