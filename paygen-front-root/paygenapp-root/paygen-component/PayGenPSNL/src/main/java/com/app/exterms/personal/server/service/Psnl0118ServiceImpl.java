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

import com.app.exterms.personal.client.dto.Psnl0118DTO;
import com.app.exterms.personal.client.service.Psnl0118Service;
import com.app.exterms.personal.server.service.dao.Psnl0118DAO;
import com.app.exterms.personal.server.vo.Psnl0118VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0118ServiceImpl.java
 * @Description : Psnl0118 Business Implement class
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
@Service("psnl0118Service")
public class Psnl0118ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0118Service {

    @Resource(name="psnl0118DAO")
    private Psnl0118DAO psnl0118DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0118ServiceImpl.class);
    private static final String calledClass = Psnl0118ServiceImpl.class.getName();
    

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Psnl0118DTO> selectPsnl0118(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0118DTO> returnValue = new ArrayList<Psnl0118DTO>();
		List egovResultDataList = new ArrayList();
		

		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".selectPsnl0118";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		try {
			egovResultDataList = psnl0118DAO.selectPsnl0118(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0118DTO dto = new Psnl0118DTO();
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
		
		return new BaseListLoadResult<Psnl0118DTO>(returnValue);
	}

	@Override
	public String savePsnl0118(ArrayList<Psnl0118DTO> changePsnl0118List)
			throws Exception {
		
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";

		String method = calledClass + ".savePsnl0118";
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		String strJobSeptDivCd = "";
		
		try{
			if(changePsnl0118List!=null && changePsnl0118List.size() > 0){
				for ( int i = 0; i < changePsnl0118List.size(); i++){
					
					Psnl0118VO psnl0118Vo = new Psnl0118VO();
					
					psnl0118Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0118List.get(i).getDpobCd()));								/** column 사업장코드 : dpobCd */
					psnl0118Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0118List.get(i).getSystemkey()));							/** column SYSTEMKEY : systemkey */
					
					psnl0118Vo.setAqtnDt(SmrmfUtils.getStringFromDate(changePsnl0118List.get(i).getAqtnDt(), "yyyyMMdd"));		/** column 취득일자 : aqtnDt */
					psnl0118Vo.setQftntLicnsCd(MSFSharedUtils.allowNulls(changePsnl0118List.get(i).getQftntLicnsCd()));    					/** column 자격면허코드 : qftntLicnsCd */
					psnl0118Vo.setQftntLicnsPovncCtnt(MSFSharedUtils.allowNulls(changePsnl0118List.get(i).getQftntLicnsPovncCtnt()));	/** column 자격면허분야내용 : qftntLicnsPovncCtnt */
					psnl0118Vo.setEfmnIstutNm(MSFSharedUtils.allowNulls(changePsnl0118List.get(i).getEfmnIstutNm()));    					/** column 시행기관명 : efmnIstutNm */
					psnl0118Vo.setQftntLicnsNum(MSFSharedUtils.allowNulls(changePsnl0118List.get(i).getQftntLicnsNum()));    			/** column 자격면허번호 : qftntLicnsNum */
					
					if(changePsnl0118List.get(i).getDelChk()){
						psnl0118Vo.setQftntLicnsSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0118List.get(i).getQftntLicnsSeilNum(), "0")));	/** column 자격면허일련번호 : qftntLicnsSeilNum */
						
//						psnl0118DAO.deletePsnl0118(changePsnl0118List.get(i));
						psnl0118DAO.deletePsnl0118(psnl0118Vo);
						delCnt++;
						
					}else{
						
						changePsnl0118List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0118List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						psnl0118Vo.setIsmt(sessionUser.getUsrId());
						psnl0118Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						if(changePsnl0118List.get(i).getQftntLicnsSeilNum() != null){
							psnl0118Vo.setQftntLicnsSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0118List.get(i).getQftntLicnsSeilNum(), "0")));	/** column 자격면허일련번호 : qftntLicnsSeilNum */
							
//							psnl0118DAO.updatePsnl0118(changePsnl0118List.get(i));
							psnl0118DAO.updatePsnl0118(psnl0118Vo);
							
						}else{
							psnl0118Vo.setQftntLicnsSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0118List.get(i).getQftntLicnsSeilNum(), "0")));	/** column 자격면허일련번호 : qftntLicnsSeilNum */
							
//							psnl0118DAO.insertPsnl0118(changePsnl0118List.get(i));
							psnl0118DAO.insertPsnl0118(psnl0118Vo);
							
						}
						saveCnt++;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D:U:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,  "D:U:C");
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
    
}
