package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Insr3200ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr4300DAO;
import com.app.exterms.insurance.server.vo.Insr4300SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("insr3200ExcelService")
public class Insr3200ExcelServiceImpl extends AbstractServiceImpl implements Insr3200ExcelService {
    
    @Autowired 
    @Resource(name="Insr4300DAO")
    private Insr4300DAO insr4300DAO;
     
  public List  selectInsr320001ToInsr4300List(Insr4300SrhVO insr4300SrhVo)  throws Exception {
      return insr4300DAO.selectInsr320001ToInsr4300List(insr4300SrhVo);
  } 
  
  public List  selectInsr320002ToInsr4300List(Insr4300SrhVO insr4300SrhVo)  throws Exception {
      return insr4300DAO.selectInsr320002ToInsr4300List(insr4300SrhVo);
  } 

  
}
