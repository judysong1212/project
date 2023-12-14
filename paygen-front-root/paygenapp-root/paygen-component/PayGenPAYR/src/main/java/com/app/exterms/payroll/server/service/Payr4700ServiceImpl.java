package com.app.exterms.payroll.server.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceDispatcher;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.client.dto.Payr4700DTO;
import com.app.exterms.payroll.client.service.Payr4700Service;
import com.app.exterms.payroll.server.service.dao.Payr4700DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;


@SuppressWarnings("serial")
@Service("payr4700Service")
public class Payr4700ServiceImpl extends RemoteServiceDispatcher implements Payr4700Service {
	
	 private static final Logger logger = LoggerFactory.getLogger(Payr4700ServiceImpl.class);
	 private static final String calledClass = Payr4700ServiceImpl.class.getName();
	  
	@Autowired
    @Resource(name="payr4700DAO")
    private Payr4700DAO payr4700DAO;

	

	@SuppressWarnings("rawtypes")
	@Override
	public BaseListLoadResult<Payr4700DTO> selectPayr4700(BaseListLoadConfig config, Payr4700DTO payr4700dto)throws Exception {
		
		List<Payr4700DTO> returnValue = new ArrayList<Payr4700DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "원천징수영수증발급승인";
		String windowId = "PAYR4700";
		
		String method = calledClass + ".selectPayr4700";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		// 2. 파라미터 보낼 때(암호화)
		payr4700dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(payr4700dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

		
		
		try{
			egovResultDataList = payr4700DAO.selectPayr4700(payr4700dto);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Payr4700DTO dto = new Payr4700DTO();
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
		            	
		        		// 3.복호화
		        		rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		        		dto.setResnRegnNum(rrnDecCrypt);
		            }
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
		
		return new BaseListLoadResult<Payr4700DTO>(returnValue);	
		
	}



	@Override
	public int updateIssueOk(List<Payr4700DTO> list) throws Exception {
		int returnVal = 0;
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if(list != null && list.size() > 0){
			for(Payr4700DTO dto : list){
				dto.setIsmt(sessionUser.getUsrId());
				dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				returnVal += payr4700DAO.updateIssueOk(dto);
			}
		}
		return returnVal;
	}
	
}
