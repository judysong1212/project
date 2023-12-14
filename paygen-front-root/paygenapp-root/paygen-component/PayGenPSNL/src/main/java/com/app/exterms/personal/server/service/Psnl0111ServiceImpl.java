package com.app.exterms.personal.server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0111DTO;
import com.app.exterms.personal.client.service.Psnl0111Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0111DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

/**
 * @Class Name : Psnl0111ServiceImpl.java
 * @Description : Psnl0111 Business Implement class
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
@Service("psnl0111Service")
public class Psnl0111ServiceImpl extends AbstractCustomServiceImpl  implements Psnl0111Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Psnl0111ServiceImpl.class);
	
    @Resource(name="psnl0111DAO")
    private Psnl0111DAO psnl0111DAO;
    
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
    

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> selectPsnl0111(
			HashMap<String, String> param) throws MSFException {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> resultData = new ArrayList<HashMap<String, String>>();
		try {
			resultData = psnl0111DAO.selectPsnl0111(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger); 
		}
		
		return resultData;
	}


	@Override
	public int savePsnl0111(Psnl0111DTO psnl0111Dto) throws Exception {
		// TODO Auto-generated method stub
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		//인적정보 업데이트
		psnl0111Dto.setIsmt(sessionUser.getUsrId());
		psnl0111Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		psnl0111DAO.savePsnl0111(psnl0111Dto);
		//Psnl0100정보 업데이트
		Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
		psnl0100Dto.setIsmt(sessionUser.getUsrId());
		psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		psnl0100Dto.setDpobCd(psnl0111Dto.getDpobCd());
		psnl0100Dto.setSystemkey(psnl0111Dto.getSystemkey());
		psnl0100Dto.setPernNoteCtnt(psnl0111Dto.getPernNoteCtnt());			//비고
		psnl0100Dto.setStyBgnnDt(psnl0111Dto.getStyBgnnDt());				//체류시작일자
		psnl0100Dto.setStyEndDt(psnl0111Dto.getStyEndDt());					//체류종료일자
		psnl0100Dto.setFrstEmymtDt(psnl0111Dto.getFrgnrDivCd());			//외국인구분코드
		psnl0100Dto.setPsptNum(psnl0111Dto.getPsptNum());					//여권번호
		psnl0100Dto.setRepbtyBusinDivCd(psnl0111Dto.getRepbtyBusinDivCd());	//호봉
		psnl0100DAO.updatePsnl0100(psnl0100Dto);
		
		return 0;
	}
    
    
    
}
