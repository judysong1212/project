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

import com.app.exterms.personal.client.dto.Psnl0122DTO;
import com.app.exterms.personal.client.service.Psnl0122Service;
import com.app.exterms.personal.server.service.dao.Psnl0122DAO;
import com.app.exterms.personal.server.vo.Psnl0122VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0122ServiceImpl.java
 * @Description : Psnl0122 Business Implement class
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
@Service("psnl0122Service")
public class Psnl0122ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0122Service {

    @Resource(name="psnl0122DAO")
    private Psnl0122DAO psnl0122DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0122ServiceImpl.class);
    private static final String calledClass = Psnl0122ServiceImpl.class.getName();

    
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0122DTO> selectPsnl0122(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0122DTO> returnValue = new ArrayList<Psnl0122DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0122";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			egovResultDataList = psnl0122DAO.selectPsnl0122(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0122DTO dto = new Psnl0122DTO();
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
		
		return new BaseListLoadResult<Psnl0122DTO>(returnValue);
	}

	@Override
	public String savePsnl0122(ArrayList<Psnl0122DTO> changePsnl0122List)throws Exception {
		
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String method = calledClass + ".savePsnl0122";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		try{
			if(changePsnl0122List!=null && changePsnl0122List.size() > 0){
				for ( int i = 0; i < changePsnl0122List.size(); i++){
					
					Psnl0122VO psnl0122Vo = new Psnl0122VO(); 
					
					psnl0122Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getDpobCd()));					/** column 사업장코드 : dpobCd */
					psnl0122Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getSystemkey()));			/** column SYSTEMKEY : systemkey */
					psnl0122Vo.setDsnyActDsplDt(MSFSharedUtils.allowNulls(SmrmfUtils.getStringFromDate(changePsnl0122List.get(i).getDsnyActDsplDt(), "yyyyMMdd")));    	/** column 징계처분일자 : dsnyActDsplDt */
					psnl0122Vo.setDsnyActDivCd(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getDsnyActDivCd()));    	/** column 징계구분코드 : dsnyActDivCd */
					psnl0122Vo.setDsnyActNm(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getDsnyActNm()));    		/** column 징계명 : dsnyActNm */
					psnl0122Vo.setDsnyActReasCtnt(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getDsnyActReasCtnt()));    /** column 징계사유내용 : dsnyActReasCtnt */
					psnl0122Vo.setDsnyActEctgOrgn(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getDsnyActEctgOrgn()));    /** column 징계수행기관 : dsnyActEctgOrgn */
					psnl0122Vo.setDsnyActNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getDsnyActNoteCtnt()));    /** column 징계비고내용 : dsnyActNoteCtnt */
					psnl0122Vo.setDsnyActBgnnDt(MSFSharedUtils.allowNulls(SmrmfUtils.getStringFromDate(changePsnl0122List.get(i).getDsnyActBgnnDt(), "yyyyMMdd")));		/** column 징계시작일자 : dsnyActBgnnDt */
					psnl0122Vo.setDsnyActEndDt(MSFSharedUtils.allowNulls(SmrmfUtils.getStringFromDate(changePsnl0122List.get(i).getDsnyActEndDt(), "yyyyMMdd")));    	/** column 징계종료일자 : dsnyActEndDt */
					psnl0122Vo.setDsnyActCtwpRate(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0122List.get(i).getDsnyActCtwpRate(), "0")));    /** column 징계감봉율 : dsnyActCtwpRate */
					psnl0122Vo.setDsnyActCtwpMnthIcm(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0122List.get(i).getDsnyActCtwpMnthIcm(), "0")));		/** column 징계감봉월수 : dsnyActCtwpMnthIcm */
					psnl0122Vo.setDsnyActAnstyDt(MSFSharedUtils.allowNulls(SmrmfUtils.getStringFromDate(changePsnl0122List.get(i).getDsnyActAnstyDt(), "yyyyMMdd")));    /** column 징계사면일자 : dsnyActAnstyDt */
					psnl0122Vo.setDsnyActAnstyDivCd(MSFSharedUtils.allowNulls(changePsnl0122List.get(i).getDsnyActAnstyDivCd()));    	/** column 징계사면구분코드 : dsnyActAnstyDivCd */
					
					
					if(changePsnl0122List.get(i).getDelChk()){
						psnl0122Vo.setDsnyActSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0122List.get(i).getDsnyActSeilNum(), "0")));	/** column 징계일련번호 : dsnyActSeilNum */
						
//						psnl0122DAO.deletePsnl0122(changePsnl0122List.get(i));
						psnl0122DAO.deletePsnl0122(psnl0122Vo);
						delCnt++;
					}else{
//						MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0122List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0122List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						if(changePsnl0122List.get(i).getDsnyActSeilNum() != null){
							psnl0122Vo.setDsnyActSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0122List.get(i).getDsnyActSeilNum(), "0")));	/** column 징계일련번호 : dsnyActSeilNum */
							
//							psnl0122DAO.updatePsnl0122(changePsnl0122List.get(i));
							psnl0122DAO.updatePsnl0122(psnl0122Vo);
						}else{
							psnl0122Vo.setDsnyActSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0122List.get(i).getDsnyActSeilNum(), "0")));	/** column 징계일련번호 : dsnyActSeilNum */
							
//							psnl0122DAO.insertPsnl0122(changePsnl0122List.get(i));
							psnl0122DAO.insertPsnl0122(psnl0122Vo);
						}
						saveCnt++;
					}
				}
			}
		}catch(Exception e){
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
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
  
	
}
