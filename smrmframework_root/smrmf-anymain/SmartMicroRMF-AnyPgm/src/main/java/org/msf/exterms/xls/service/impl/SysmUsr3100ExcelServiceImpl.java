package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.SysmUsr3100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.sysm.server.service.dao.SysmHist0100DAO;
import com.app.smrmf.sysm.server.vo.SysIfHist0100SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("SysmUsr3100ExcelService")
public class SysmUsr3100ExcelServiceImpl extends AbstractServiceImpl implements SysmUsr3100ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(SysmUsr3100ExcelServiceImpl.class);
	private static final String calledClass =  SysmUsr3100ExcelServiceImpl.class.getName();
    
    @Autowired 
    @Resource(name="SysmHist0100DAO")
    private SysmHist0100DAO hist0100DAO;
    
//    @Autowired 
//    @Resource(name="stts0100DAO")
//    private Stts0100DAO stts0100DAO;
	
    
    //엑셀파일 저장_jxls_export 
	public List  selectXlsFileHist0100List(SysIfHist0100SrhVO hist0100SrhVo) throws Exception {
		return hist0100DAO.selectHist0100ExlList(hist0100SrhVo);
	}

  
}
