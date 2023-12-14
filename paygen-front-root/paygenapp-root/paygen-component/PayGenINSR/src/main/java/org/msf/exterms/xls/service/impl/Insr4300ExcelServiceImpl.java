package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Insr4300ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.Insr4300ServiceImpl;
import com.app.exterms.insurance.server.service.dao.Insr3400DAO;
import com.app.exterms.insurance.server.vo.Insr3400SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("insr4300ExcelService")
public class Insr4300ExcelServiceImpl extends AbstractServiceImpl implements Insr4300ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Insr4300ServiceImpl.class);
	private static final String calledClass = Insr4300ExcelService.class.getName();
	
	@Autowired
	@Resource(name = "Insr3400DAO")
	private Insr3400DAO insr3400DAO;
	
//	@Autowired
//	@Resource(name = "insr4300ExcelUploadService")
//	private MsfExcelService insr4300ExcelUploadService;
	
	public List selectXlsInsr3400List(Insr3400SrhVO insr3400SrhVO) throws Exception {
		return insr3400DAO.selectXlsInsr3400List(insr3400SrhVO);
	}
}