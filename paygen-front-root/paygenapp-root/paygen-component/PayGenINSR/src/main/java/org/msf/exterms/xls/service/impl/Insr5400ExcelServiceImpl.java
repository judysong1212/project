package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Insr5400ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr5400DAO;
import com.app.exterms.insurance.server.vo.Insr5400SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Insr5400ExcelService")
public class Insr5400ExcelServiceImpl extends AbstractServiceImpl implements Insr5400ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(Insr5400ExcelServiceImpl.class);
     
    @Autowired
    @Resource(name="Insr5400DAO")
    private Insr5400DAO insr5400DAO;
    
    
     
//  public List selectXlsInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception {
//      return insr3000DAO.selectXlsInsr3000List(insr3000SrhVO);
//  } 
	public List selectXlsInsr5400List(Insr5400SrhVO insr5400SrhVO) throws Exception {
		// TODO Auto-generated method stub
		
logger.debug("0000001");

		return insr5400DAO.selectInsr5300ToInsr5400ListXls(insr5400SrhVO);
	}
}