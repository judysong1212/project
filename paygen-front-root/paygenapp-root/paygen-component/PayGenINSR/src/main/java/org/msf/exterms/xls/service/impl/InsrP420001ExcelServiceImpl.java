package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.InsrP420001ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr3200DAO;
import com.app.exterms.insurance.server.vo.Insr3200SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("InsrP420001ExcelService")
public   class InsrP420001ExcelServiceImpl extends AbstractServiceImpl implements InsrP420001ExcelService {
     
	@Autowired
    @Resource(name="Insr3200DAO")
    private Insr3200DAO insr3200DAO;
    
     
  public List selectXlsInsrP420001ToInsr3200List(Insr3200SrhVO insr3200SrhVO) throws Exception {
      return insr3200DAO.selectXlsInsrP420001ToInsr3200List(insr3200SrhVO);
  }
  

  
  
}
