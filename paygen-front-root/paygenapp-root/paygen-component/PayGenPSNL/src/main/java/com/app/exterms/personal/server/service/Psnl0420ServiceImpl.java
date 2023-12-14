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

import com.app.exterms.personal.client.dto.Psnl0420DTO;
import com.app.exterms.personal.client.service.Psnl0420Service;
import com.app.exterms.personal.server.service.dao.Psnl0420DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;


@SuppressWarnings("serial")
@Service("psnl0420Service")
public class Psnl0420ServiceImpl extends AbstractCustomServiceImpl implements Psnl0420Service {
	
	 private static final Logger logger = LoggerFactory.getLogger(Psnl0420ServiceImpl.class);
	 private static final String calledClass = Psnl0420ServiceImpl.class.getName();

	  
	@Autowired
    @Resource(name="psnl0420DAO")
    private Psnl0420DAO psnl0420DAO;

	

	@SuppressWarnings("rawtypes")
	@Override
	public BaseListLoadResult<Psnl0420DTO> selectPsnl0420(
			BaseListLoadConfig config, Psnl0420DTO psnl0420dto)
			throws Exception {
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		// 파라미터 보낼 때(암호화)
		psnl0420dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0420dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		List<Psnl0420DTO> returnValue = new ArrayList<Psnl0420DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "증명서발급승인";
		String windowId = "PSNL0420";
		
		String method = calledClass + ".selectPsnl0420";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			egovResultDataList = psnl0420DAO.selectPsnl0420(psnl0420dto);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0420DTO dto = new Psnl0420DTO();
					
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
		
		return new BaseListLoadResult<Psnl0420DTO>(returnValue);	
	}



	@Override
	public int updateIssueOk(List<Psnl0420DTO> list) throws Exception {
		int returnVal = 0;
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if(list != null && list.size() > 0){
			for(Psnl0420DTO dto : list){
				dto.setIsmt(sessionUser.getUsrId());
				dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				dto.setIssCodtnEmpNum(sessionUser.getUsrId()); //발급승인 담당자 번호
				returnVal += psnl0420DAO.updateIssueOk(dto);
			}
		}
		return returnVal;
	}
	
}
