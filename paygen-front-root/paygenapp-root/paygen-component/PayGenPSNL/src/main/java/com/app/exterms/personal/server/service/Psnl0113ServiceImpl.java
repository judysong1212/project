package com.app.exterms.personal.server.service;

import java.util.Iterator;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0113DTO;
import com.app.exterms.personal.client.service.Psnl0113Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0113DAO;
import com.app.exterms.personal.server.vo.Psnl0113SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0113ServiceImpl.java
 * @Description : Psnl0113 Business Implement class
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
@Service("psnl0113Service")
public class Psnl0113ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0113Service {
	
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
    
    @Resource(name="psnl0113DAO")
    private Psnl0113DAO psnl0113DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPsnl0113IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;


	@Override
	public String insertPsnl0113(Psnl0113DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return psnl0113DAO.insertPsnl0113(dto);
	}

	@Override
	public int updatePsnl0113(Psnl0113DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return psnl0113DAO.updatePsnl0113(dto);
	}

	@Override
	public int deletePsnl0113(Psnl0113DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return psnl0113DAO.deletePsnl0113(dto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Psnl0113DTO selectPsnl0113(Psnl0113DTO dto) throws Exception {
		
		
		// TODO Auto-generated method stub
		Psnl0113DTO returnVal = new Psnl0113DTO();
		
		EgovMap map = psnl0113DAO.selectPsnl0113(dto); 
		if(map != null && map.size() > 0){
			Iterator<String> keys = map.keySet().iterator();
			while( keys.hasNext() ){
	            String key = keys.next();
	            //형 타입이 숫자형일경우 형변환 해준다.
            	if(map.get(key) instanceof java.math.BigDecimal){
            		returnVal.set(key, String.valueOf(map.get(key)));
            	}else{
            		returnVal.set(key, map.get(key));
            	}
            }
		}
		return returnVal;
	}

	@Override
	public int savePsnl0113(Psnl0113DTO dto) throws Exception {
		int intReturnVal = 0;
		// TODO Auto-generated method stub
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//신상 정보 insert인지 update인지 판별
		int totCnt = 0;
		Psnl0113SrhVO psnl0113SrhVo = new Psnl0113SrhVO();	
		
		psnl0113SrhVo.setDpobCd(dto.getDpobCd());
		psnl0113SrhVo.setSystemkey(dto.getSystemkey());
		
		Psnl0100DTO psnl0100DTO = new Psnl0100DTO();
		
		psnl0100DTO.setDpobCd(dto.getDpobCd());
		psnl0100DTO.setSystemkey(dto.getSystemkey());
		psnl0100DTO.setSxDivCd(dto.getSxDivCd());
		psnl0100DTO.setYoobhMnthDay(dto.getYoobhMnthDay());
		
		totCnt = psnl0113DAO.selectPsnl0113ListTotCnt(psnl0113SrhVo);
		
		//신규일경우 insert
		if(0 >= totCnt) {
			//인사 업데이트 후 신상 insert(성별, 생년월일)
			intReturnVal = psnl0100DAO.updatePsnl0100(psnl0100DTO);
			psnl0113DAO.insertPsnl0113(dto); 
			
		}else if(0 < totCnt) {
			//인사 업데이트 후 신상 update(성별, 생년월일)
			psnl0100DAO.updatePsnl0100(psnl0100DTO);
			
			intReturnVal = psnl0113DAO.updatePsnl0113(dto);
		}
		return intReturnVal;
	}
    
}
