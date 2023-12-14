package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr4400ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0301DAO;
import com.app.exterms.payroll.server.vo.Payr0301SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr4400ExcelService")
public class Payr4400ExcelServiceImpl extends AbstractServiceImpl implements Payr4400ExcelService {
    
    
    @Autowired
    @Resource(name="Payr0301DAO")
    private Payr0301DAO payr0301DAO;
     
  public List selectXlsPayr4400List(Payr0301SrhVO payr0301SrhVO) throws Exception {
      return payr0301DAO.selectPayr4400XlsList(payr0301SrhVO);
  } 

  public List selectXlsHoJoPayr4400List(Payr0301SrhVO payr0301SrhVO) throws Exception {
      return payr0301DAO.selectXlsHoJoPayr4400List(payr0301SrhVO);
  } 

   
 
}
