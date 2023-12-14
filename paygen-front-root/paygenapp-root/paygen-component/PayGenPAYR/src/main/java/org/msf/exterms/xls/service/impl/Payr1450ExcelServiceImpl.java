package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr1450ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0485DAO;
import com.app.exterms.payroll.server.vo.Payr0485SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr1450ExcelService")
public class Payr1450ExcelServiceImpl extends AbstractServiceImpl implements Payr1450ExcelService {
    
    
    @Autowired
    @Resource(name="Payr0485DAO")
    private Payr0485DAO payr0485DAO;
     
//  public List selectXlsPayr4400List(Payr0301SrhVO payr0301SrhVO) throws Exception {
//      return payr0301DAO.selectPayr4400XlsList(payr0301SrhVO);
//  } 
//
//  public List selectXlsHoJoPayr4400List(Payr0301SrhVO payr0301SrhVO) throws Exception {
//      return payr0301DAO.selectXlsHoJoPayr4400List(payr0301SrhVO);
//  } 
  
  public List selectXlsPayr1450List(Payr0485SrhVO payr0485SrhVO) throws Exception {
      return payr0485DAO.selectXlsPayr1450List(payr0485SrhVO);
  }
 
}
