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

import com.app.exterms.personal.client.dto.Psnl0120DTO;
import com.app.exterms.personal.client.service.Psnl0120Service;
import com.app.exterms.personal.server.service.dao.Psnl0120DAO;
import com.app.exterms.personal.server.vo.Psnl0120VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0120ServiceImpl.java
 * @Description : Psnl0120 Business Implement class
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
@Service("psnl0120Service")
public class Psnl0120ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0120Service {

    @Resource(name="psnl0120DAO")
    private Psnl0120DAO psnl0120DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0120ServiceImpl.class);
    private static final String calledClass = Psnl0120ServiceImpl.class.getName();
    

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0120DTO> selectPsnl0120(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		

		// TODO Auto-generated method stub
		List<Psnl0120DTO> returnValue = new ArrayList<Psnl0120DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0120";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			
			egovResultDataList = psnl0120DAO.selectPsnl0120(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0120DTO dto = new Psnl0120DTO();
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
		
		return new BaseListLoadResult<Psnl0120DTO>(returnValue);
	}

	@Override
	public String savePsnl0120(ArrayList<Psnl0120DTO> changePsnl0120List)
			throws Exception {

		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		

//		String strJobSeptDivCd = "";
		String method = calledClass + ".savePsnl0120";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			if(changePsnl0120List!=null && changePsnl0120List.size() > 0){
				for ( int i = 0; i < changePsnl0120List.size(); i++){
					
					Psnl0120VO psnl0120Vo = new Psnl0120VO();
					
					psnl0120Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getDpobCd()));								/** column 사업장코드 : dpobCd */
					psnl0120Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getSystemkey()));						/** column SYSTEMKEY : systemkey */
					psnl0120Vo.setEduBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0120List.get(i).getEduBgnnDt(), "yyyyMMdd"));   		/** column 교육시작일자 : eduBgnnDt */
					psnl0120Vo.setEduEndDt(SmrmfUtils.getStringFromDate(changePsnl0120List.get(i).getEduEndDt(), "yyyyMMdd"));    		/** column 교육종료일자 : eduEndDt */
					psnl0120Vo.setEduCmpteTm(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getEduCmpteTm()));    					/** column 교육이수시간 : eduCmpteTm */
					psnl0120Vo.setEduKndNm(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getEduKndNm()));    						/** column 교육종류명 : eduKndNm */
					psnl0120Vo.setEduIstutNm(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getEduIstutNm()));    					/** column 교육기관명 : eduIstutNm */
					psnl0120Vo.setEduNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getEduNoteCtnt()));   				/** column 교육비고내용 : eduNoteCtnt */
					psnl0120Vo.setEduBgnnTm(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getEduBgnnTm()).replaceAll(":", ""));	/** column 교육시작시간 : eduBgnnTm */
					psnl0120Vo.setEduEndTm(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getEduEndTm()).replaceAll(":", ""));    	/** column 교육종료시간 : eduEndTm */
//					psnl0120Vo.setResnRegnNum(MSFSharedUtils.allowNulls(changePsnl0120List.get(i).getResnRegnNum()));	/** column 주민등록번호 : resnRegnNum */
					
					if(changePsnl0120List.get(i).getDelChk()){
						psnl0120Vo.setEduSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0120List.get(i).getEduSeilNum(), "0")));  /** column 교육일련번호 : eduSeilNum */
						
//						psnl0120DAO.deletePsnl0120(changePsnl0120List.get(i));
						psnl0120DAO.deletePsnl0120(psnl0120Vo);
						delCnt++;
						
					}else{
//						MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0120List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0120List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						psnl0120Vo.setIsmt(sessionUser.getUsrId());
						psnl0120Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						if(changePsnl0120List.get(i).getEduSeilNum() != null){
							psnl0120Vo.setEduSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0120List.get(i).getEduSeilNum(), "0")));  /** column 교육일련번호 : eduSeilNum */
							
//							psnl0120DAO.updatePsnl0120(changePsnl0120List.get(i));
							psnl0120DAO.updatePsnl0120(psnl0120Vo);
							
						}else{
							psnl0120Vo.setEduSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0120List.get(i).getEduSeilNum(), "0")));  /** column 교육일련번호 : eduSeilNum */
							
//							psnl0120DAO.insertPsnl0120(changePsnl0120List.get(i));
							psnl0120DAO.insertPsnl0120(psnl0120Vo);
							
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
	@Override
	public String insert0120List(ArrayList<Psnl0120DTO> insertPsnl0120List)
			throws Exception {
		// TODO Auto-generated method stub
		int saveCnt = 0;
		if(insertPsnl0120List!=null && insertPsnl0120List.size() > 0){
			for ( int i = 0; i < insertPsnl0120List.size(); i++){
				MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				insertPsnl0120List.get(i).setIsmt(sessionUser.getUsrId());
				insertPsnl0120List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				try{
					psnl0120DAO.insertPsnl0120Excel(insertPsnl0120List.get(i));
					saveCnt++;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return ""+saveCnt;
	}
}
