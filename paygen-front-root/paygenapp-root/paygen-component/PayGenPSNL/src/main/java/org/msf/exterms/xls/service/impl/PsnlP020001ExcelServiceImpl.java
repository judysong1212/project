package org.msf.exterms.xls.service.impl;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.PsnlP020001ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0110DAO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("psnlP020002ExcelService")
public class PsnlP020001ExcelServiceImpl extends AbstractServiceImpl implements PsnlP020001ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(PsnlP020001ExcelServiceImpl.class);
	private static final String calledClass = PsnlP020001ExcelService.class.getName();
    
	// 인사 마스터
	@Autowired
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
	
	// 인사 고용
	@Autowired
    @Resource(name="psnl0110DAO")
	private Psnl0110DAO psnl0110DAO;

//	@Override
//	public List selectXlsFilePsnl0200ToPsnl0110List(Psnl0110SrhVO  psnl0110SrhVo) throws MSFException {
//		// TODO Auto-generated method stub
//		return payr0304DAO.selectXlsFilePayr0304ToPayr4200LList(payr0304SrhVO);
//	}

	
}
