package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.InsrP510001ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr5100DAO;
import com.app.exterms.insurance.server.vo.Insr5100SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("InsrP510001ExcelService")
public   class InsrP510001ExcelServiceImpl extends AbstractServiceImpl implements InsrP510001ExcelService {
     
	@Autowired
    @Resource(name="Insr5100DAO")
    private Insr5100DAO insr5100DAO;
    
     
  public List selectXlsInsrP51000102ToInsr5100List(Insr5100SrhVO insr5100SrhVO) throws Exception {
      return insr5100DAO.selectXlsInsrP51000102ToInsr5100List(insr5100SrhVO);
  }
  
  public List selectXlsInsrP51000101ToInsr5100List(Insr5100SrhVO insr5100SrhVO) throws Exception {
      return insr5100DAO.selectXlsInsrP51000101ToInsr5100List(insr5100SrhVO);
  }

  
  
}
