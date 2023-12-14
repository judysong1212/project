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

import com.app.exterms.personal.client.dto.Psnl0119DTO;
import com.app.exterms.personal.client.service.Psnl0119Service;
import com.app.exterms.personal.server.service.dao.Psnl0119DAO;
import com.app.exterms.personal.server.vo.Psnl0119VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0119ServiceImpl.java
 * @Description : Psnl0119 Business Implement class
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
@Service("psnl0119Service")
public class Psnl0119ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0119Service {

    @Resource(name="psnl0119DAO")
    private Psnl0119DAO psnl0119DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0119ServiceImpl.class);
    private static final String calledClass = Psnl0119ServiceImpl.class.getName();
    

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0119DTO> selectPsnl0119(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		
		String method = calledClass + ".selectPsnl0119";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		List<Psnl0119DTO> returnValue = new ArrayList<Psnl0119DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			
			egovResultDataList = psnl0119DAO.selectPsnl0119(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0119DTO dto = new Psnl0119DTO();
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
		
		return new BaseListLoadResult<Psnl0119DTO>(returnValue);
	}

	@Override
	public String savePsnl0119(ArrayList<Psnl0119DTO> changePsnl0119List)throws Exception {
		
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
//		String strJobSeptDivCd = "";

		String method = calledClass + ".savePsnl0119";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";

		
		try{
			if(changePsnl0119List!=null && changePsnl0119List.size() > 0){
				for ( int i = 0; i < changePsnl0119List.size(); i++){
					
					Psnl0119VO psnl0119Vo = new Psnl0119VO();
					
					psnl0119Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getDpobCd()));    		/** column 사업장코드 : dpobCd */
					psnl0119Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getSystemkey()));	/** column SYSTEMKEY : systemkey */
					
					psnl0119Vo.setCarrBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0119List.get(i).getCarrBgnnDt(), "yyyyMMdd"));	/** column 경력시작일자 : carrBgnnDt */
					psnl0119Vo.setCarrEndDt(SmrmfUtils.getStringFromDate(changePsnl0119List.get(i).getCarrEndDt(), "yyyyMMdd"));    /** column 경력종료일자 : carrEndDt */
					psnl0119Vo.setPaeWorkNm(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getPaeWorkNm()));	/** column 근무처명 : paeWorkNm */
					psnl0119Vo.setCarrDivCd(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getCarrDivCd()));	/** column 경력구분코드 : carrDivCd */
					psnl0119Vo.setDutyDeptNm(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getDutyDeptNm()));	/** column 근무부서명 : dutyDeptNm */
					psnl0119Vo.setRepbtyBusinNm(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getRepbtyBusinNm()));	/** column 담당업무명 : repbtyBusinNm */
					psnl0119Vo.setOdtyNm(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getOdtyNm()));    		/** column 직책명 : odtyNm */
					psnl0119Vo.setAmntDlywagSum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getAmntDlywagSum(), "0")));/** column 임금일당금액 : amntDlywagSum */
					psnl0119Vo.setCarrNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getCarrNoteCtnt()));    	/** column 경력비고내용 : carrNoteCtnt */
					psnl0119Vo.setDutyYrNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getDutyYrNum(), "0")));    	/** column 근무년수 : dutyYrNum */
					psnl0119Vo.setDutyMnthIcm(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getDutyMnthIcm(), "0")));    /** column 근무월수 : dutyMnthIcm */
//					psnl0119Vo.setCvsnRto(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getCvsnRto()));    	/** column 환산비율 : cvsnRto */
					psnl0119Vo.setCvsnRtoDivCd(MSFSharedUtils.allowNulls(changePsnl0119List.get(i).getCvsnRtoDivCd()));    	/** column 환산비율구분코드 : cvsnRtoDivCd */
					psnl0119Vo.setAjmtMnthNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getAjmtMnthNum(), "0")));    /** column 가감월수 : ajmtMnthNum */
					psnl0119Vo.setRcgtnMnthNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getRcgtnMnthNum(), "0")));  /** column 인정월수 : rcgtnMnthNum */
					
					
					if(changePsnl0119List.get(i).getDelChk()){
						psnl0119Vo.setCarrRsptSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getCarrRsptSeilNum(), "0")));	/** column 경력사항일련번호 : carrRsptSeilNum */
						
//						psnl0119DAO.deletePsnl0119(changePsnl0119List.get(i));
						psnl0119DAO.deletePsnl0119(psnl0119Vo);
						delCnt++;
						
					}else{
//						MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0119List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0119List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						psnl0119Vo.setIsmt(sessionUser.getUsrId());
						psnl0119Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						if(changePsnl0119List.get(i).getCarrRsptSeilNum() != null){
							psnl0119Vo.setCarrRsptSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getCarrRsptSeilNum(), "0")));	/** column 경력사항일련번호 : carrRsptSeilNum */
							
//							psnl0119DAO.updatePsnl0119(changePsnl0119List.get(i));
							psnl0119DAO.updatePsnl0119(psnl0119Vo);
							
							
						}else{
							psnl0119Vo.setCarrRsptSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0119List.get(i).getCarrRsptSeilNum(), "0")));	/** column 경력사항일련번호 : carrRsptSeilNum */
							
//							psnl0119DAO.insertPsnl0119(changePsnl0119List.get(i));
							psnl0119DAO.insertPsnl0119(psnl0119Vo);
							
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
