package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.PayrP420001ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0307DAO;
import com.app.exterms.payroll.server.vo.Payr0307SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payrP420001ExcelService")
public class PayrP420001ExcelServiceImpl extends AbstractServiceImpl implements PayrP420001ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(PayrP420001ExcelServiceImpl.class);
	private static final String calledClass = PayrP420001ExcelService.class.getName();
    
	
	@Autowired
	@Resource(name="Payr0307DAO")
	private Payr0307DAO payr0307DAO;
     

	//급여지급대상자 양식저장
	@Override
	public List selectXlsPayrP420001List(Payr0307SrhVO payr0307SrhVo) throws Exception {
		// TODO Auto-generated method stub
		return payr0307DAO.selectPayr0307ToPayr420001List(payr0307SrhVo);
	}

	
}
