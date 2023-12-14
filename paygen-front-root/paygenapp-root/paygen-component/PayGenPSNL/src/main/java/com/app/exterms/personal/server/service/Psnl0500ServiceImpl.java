package com.app.exterms.personal.server.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0500DTO;
import com.app.exterms.personal.client.service.Psnl0500Service;
import com.app.exterms.personal.server.service.dao.Psnl0500DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;


@SuppressWarnings("serial")
@Service("psnl0500Service")
public class Psnl0500ServiceImpl extends AbstractCustomServiceImpl implements Psnl0500Service {
	
	 private static final Logger logger = LoggerFactory.getLogger(Psnl0500ServiceImpl.class);
	 private static final String calledClass = Psnl0500ServiceImpl.class.getName();
	  
	@Autowired
    @Resource(name="psnl0500DAO")
    private Psnl0500DAO psnl0500DAO;

	

	@SuppressWarnings("rawtypes")
	@Override
	public BaseListLoadResult<Psnl0500DTO> selectPsnl0500(
			BaseListLoadConfig config, Psnl0500DTO psnl0500dto)
			throws Exception {
		
		String windowNm = "신분증발급";
		String windowId = "PSNL0500";
		
		
		List<Psnl0500DTO> returnValue = new ArrayList<Psnl0500DTO>();
		List egovResultDataList = new ArrayList();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		// 파라미터 보낼 때(암호화)
		psnl0500dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0500dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

		String method = calledClass + ".selectPsnl0500";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			egovResultDataList = psnl0500DAO.selectPsnl0500(psnl0500dto);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0500DTO dto = new Psnl0500DTO();
					
					Map tempMap = (Map)egovResultDataList.get(i);
					
					@SuppressWarnings("unchecked")
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
					
					// 복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);

					
					returnValue.add(dto);
				}
			}
			
		}catch(Exception e){
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
		
		return new BaseListLoadResult<Psnl0500DTO>(returnValue);	
	}



	@Override
	public List<String> insertPsnl0560(List<Psnl0500DTO> dtosList) throws Exception {
		List<String> returnVal =  new ArrayList<String>(); 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		for(Psnl0500DTO dto : dtosList){
			dto.setPsptIssEmpNum(sessionUser.getUsrId());
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			String pkNum = psnl0500DAO.getPsptIssNum();
			dto.setPsptIssNum(pkNum);
			psnl0500DAO.insertPsnl0560(dto);
			returnVal.add(pkNum);
		}
		return returnVal;
	}

	
}
