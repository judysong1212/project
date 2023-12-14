package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.SysmUsr3300ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.sysm.server.service.dao.SysmHist0300DAO;
import com.app.smrmf.sysm.server.vo.SysIfHist0300SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("SysmUsr3300ExcelService")
public class SysmUsr3300ExcelServiceImpl extends AbstractServiceImpl implements SysmUsr3300ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(SysmUsr3300ExcelServiceImpl.class);
	private static final String calledClass = SysmUsr3300ExcelServiceImpl.class.getName();
    
    @Autowired 
    @Resource(name="SysmHist0300DAO")
    private SysmHist0300DAO hist0300DAO;
    
    
    //엑셀파일 저장_jxls_export 
	public List  selectXlsFileHist0300List(SysIfHist0300SrhVO hist0300SrhVo) throws Exception {
		return hist0300DAO.selectHist0300ExlList(hist0300SrhVo);
	}

  
}
