package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.SysmUsr0100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.sysm.server.service.dao.Sysm0100DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("sysmUsr0100ExcelService")
public class SysmUsr0100ExcelServiceImpl extends AbstractServiceImpl implements SysmUsr0100ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(SysmUsr0100ExcelServiceImpl.class);
	private static final String calledClass =  SysmUsr0100ExcelServiceImpl.class.getName();
    
	@Autowired 
	@Resource(name="Sysm0100DAO")
	private Sysm0100DAO sysm0100DAO;
    
    
	/** 사용자정보 엑셀 저장 **/
	public List  selectXlsFileSysmUsr0100List(SysIfSysm0100SrhVO sysIfSysm0100SrhVo) throws Exception {
		return sysm0100DAO.selectSysm0100ExlList(sysIfSysm0100SrhVo);
	}
  
}
