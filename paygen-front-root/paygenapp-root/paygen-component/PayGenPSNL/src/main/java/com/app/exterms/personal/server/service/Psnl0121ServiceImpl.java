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

import com.app.exterms.personal.client.dto.Psnl0121DTO;
import com.app.exterms.personal.client.service.Psnl0121Service;
import com.app.exterms.personal.server.service.dao.Psnl0121DAO;
import com.app.exterms.personal.server.vo.Psnl0121VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0121ServiceImpl.java
 * @Description : Psnl0121 Business Implement class
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
@Service("psnl0121Service")
public class Psnl0121ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0121Service {

    @Resource(name="psnl0121DAO")
    private Psnl0121DAO psnl0121DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0121ServiceImpl.class);
    private static final String calledClass = Psnl0121ServiceImpl.class.getName();
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0121DTO> selectPsnl0121(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0121DTO> returnValue = new ArrayList<Psnl0121DTO>();
		List egovResultDataList = new ArrayList();
		

		String method = calledClass + ".selectPsnl0121";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			
			egovResultDataList = psnl0121DAO.selectPsnl0121(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0121DTO dto = new Psnl0121DTO();
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
		
		return new BaseListLoadResult<Psnl0121DTO>(returnValue);
	}

	@Override
	public String savePsnl0121(ArrayList<Psnl0121DTO> changePsnl0121List)
			throws Exception {
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String method = calledClass + ".changePsnl0121List";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		try{
			if(changePsnl0121List!=null && changePsnl0121List.size() > 0){
				for ( int i = 0; i < changePsnl0121List.size(); i++){
					
					Psnl0121VO psnl0121Vo = new Psnl0121VO();
					
					psnl0121Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getDpobCd()));			/** column 사업장코드 : dpobCd */
					psnl0121Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getSystemkey()));    	/** column SYSTEMKEY : systemkey */
					
					psnl0121Vo.setAccldYr(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getAccldYr()));    	/** column 포상년도 : accldYr */
					psnl0121Vo.setAccldPrttDt(SmrmfUtils.getStringFromDate(changePsnl0121List.get(i).getAccldPrttDt(), "yyyyMMdd"));    	/** column 포상수여일자 : accldPrttDt */
					psnl0121Vo.setAccldKndCd(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getAccldKndCd())); /** column 포상종류코드 : accldKndCd */
					psnl0121Vo.setAccldDivCd(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getAccldDivCd()));	/** column 포상구분코드 : accldDivCd */
					psnl0121Vo.setAccldNm(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getAccldNm()));    	/** column 포상명 : accldNm */
					psnl0121Vo.setAccldCfmntNum(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getAccldCfmntNum()));	/** column 포상서훈번호 : accldCfmntNum */
					psnl0121Vo.setEfmnIstutNm(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getEfmnIstutNm()));    	/** column 시행기관명 : efmnIstutNm */
					psnl0121Vo.setAccldMnantCtnt(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getAccldMnantCtnt())); /** column 포상주체내용 : accldMnantCtnt */
					psnl0121Vo.setAccldNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0121List.get(i).getAccldNoteCtnt()));	/** column 포상비고내용 : accldNoteCtnt */
					
					if(changePsnl0121List.get(i).getDelChk()){
						psnl0121Vo.setAccldSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0121List.get(i).getAccldSeilNum(), "0")));	/** column 포상일련번호 : accldSeilNum */
						
//						psnl0121DAO.deletePsnl0121(changePsnl0121List.get(i));
						psnl0121DAO.deletePsnl0121(psnl0121Vo);
						delCnt++;
					}else{
//						MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0121List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0121List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						psnl0121Vo.setIsmt(sessionUser.getUsrId());
						psnl0121Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						
						if(changePsnl0121List.get(i).getAccldSeilNum() != null){
							psnl0121Vo.setAccldSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0121List.get(i).getAccldSeilNum(), "0")));	/** column 포상일련번호 : accldSeilNum */
							
//							psnl0121DAO.updatePsnl0121(changePsnl0121List.get(i));
							psnl0121DAO.updatePsnl0121(psnl0121Vo);
						}else{
							psnl0121Vo.setAccldSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0121List.get(i).getAccldSeilNum(), "0")));	/** column 포상일련번호 : accldSeilNum */
							
//							psnl0121DAO.insertPsnl0121(changePsnl0121List.get(i));
							psnl0121DAO.insertPsnl0121(psnl0121Vo);
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
