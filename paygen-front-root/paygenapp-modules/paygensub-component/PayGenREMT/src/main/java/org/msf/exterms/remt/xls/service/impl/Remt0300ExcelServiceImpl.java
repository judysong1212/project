package org.msf.exterms.remt.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.remt.xls.service.Remt0300ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.retirement.server.service.dao.Remt3100DAO;
import com.app.exterms.retirement.server.vo.Remt3100SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("remt0300ExcelService")
public class Remt0300ExcelServiceImpl extends AbstractServiceImpl implements Remt0300ExcelService {
    
    
    @Autowired
    @Resource(name="Remt3100DAO")
    private Remt3100DAO remt3100DAO;
     
  public List selectXlsRemt0300List(Remt3100SrhVO   remt3100SrhVo) throws Exception {
      return remt3100DAO.selectXlsRemt0300List(remt3100SrhVo);
  } 

 
}
