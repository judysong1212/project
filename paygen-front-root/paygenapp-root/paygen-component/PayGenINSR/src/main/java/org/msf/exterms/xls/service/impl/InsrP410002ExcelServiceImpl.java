package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.InsrP410002ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr3000DAO;
import com.app.exterms.insurance.server.vo.Insr3000SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("InsrP410002ExcelService")
public   class InsrP410002ExcelServiceImpl extends AbstractServiceImpl implements InsrP410002ExcelService {
     
	@Autowired
    @Resource(name="Insr3000DAO")
    private Insr3000DAO insr3000DAO;
    
     
  public List selectXlsInsrP41000202ToInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception {
      return insr3000DAO.selectXlsInsrP41000202ToInsr3000List(insr3000SrhVO);
  }
  
  public List selectXlsInsrP41000201ToInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception {
      return insr3000DAO.selectXlsInsrP41000201ToInsr3000List(insr3000SrhVO);
  }

  
  
}
