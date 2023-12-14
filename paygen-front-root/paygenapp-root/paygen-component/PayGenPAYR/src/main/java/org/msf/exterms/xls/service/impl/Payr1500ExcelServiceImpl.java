package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr1500ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0410DAO;
import com.app.exterms.payroll.server.vo.Payr0410SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr1500ExcelService")
public class Payr1500ExcelServiceImpl extends AbstractServiceImpl implements Payr1500ExcelService {

	@Autowired 
	@Resource(name="Payr0410DAO")
	private Payr0410DAO payr0410DAO;

	public  List selectXlsInsr1500List(Payr0410SrhVO searchVO) throws Exception {
		return payr0410DAO.selectXlsPayr1500List(searchVO);
	}
}
