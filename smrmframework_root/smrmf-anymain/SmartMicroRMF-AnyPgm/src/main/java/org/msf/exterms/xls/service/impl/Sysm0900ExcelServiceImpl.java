package org.msf.exterms.xls.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Sysm0900ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.sysm.server.service.dao.Sysm0900DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0900SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("sysm0900ExcelService")
public class Sysm0900ExcelServiceImpl extends AbstractServiceImpl implements Sysm0900ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Sysm0900ExcelServiceImpl.class);
	private static final String calledClass =  Sysm0900ExcelServiceImpl.class.getName();
    
	@Autowired 
	@Resource(name="Sysm0900DAO")
	private Sysm0900DAO sysm0900DAO;
    
    
	/** 사용자정보 엑셀 저장 **/
	public List  selectXlsSysm0900List(SysIfSysm0900SrhVO sysm0900SrhVo) throws Exception {
		
		List returnList = new ArrayList();
		
		if("PSNL0100".equals(sysm0900SrhVo.getDataType())) {
			returnList = sysm0900DAO.selectXlsSysm0900ToPsnl0100List(sysm0900SrhVo);
		}else {
			returnList = sysm0900DAO.selectXlsSysm0900ToPsnl0115List(sysm0900SrhVo);
		}
		
		return returnList; 
	}
  
}
