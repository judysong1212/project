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

import com.app.exterms.personal.client.dto.Psnl0410DTO;
import com.app.exterms.personal.client.service.Psnl0410Service;
import com.app.exterms.personal.server.service.dao.Psnl0410DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;


@SuppressWarnings("serial")
@Service("psnl0410Service")
public class Psnl0410ServiceImpl extends AbstractCustomServiceImpl implements Psnl0410Service {
	
	 private static final Logger logger = LoggerFactory.getLogger(Psnl0410ServiceImpl.class);
	 private static final String calledClass = Psnl0410ServiceImpl.class.getName();
	  
	@Autowired
    @Resource(name="psnl0410DAO")
    private Psnl0410DAO psnl0410DAO;

		

	@SuppressWarnings("rawtypes")
	@Override
	public BaseListLoadResult<Psnl0410DTO> selectPsnl0410(
			BaseListLoadConfig config, Psnl0410DTO psnl0410dto)
			throws Exception {
		List<Psnl0410DTO> returnValue = new ArrayList<Psnl0410DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "증명서발급대장";
		String windowId = "PSNL0410";
		

		String method = calledClass + ".selectPsnl0410";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		// 파라미터 보낼 때(암호화)
		psnl0410dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0410dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호		
		
		
		try{
			egovResultDataList = psnl0410DAO.selectPsnl0410(psnl0410dto);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0410DTO dto = new Psnl0410DTO();
					
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
		
		return new BaseListLoadResult<Psnl0410DTO>(returnValue);	
	}
	
}
