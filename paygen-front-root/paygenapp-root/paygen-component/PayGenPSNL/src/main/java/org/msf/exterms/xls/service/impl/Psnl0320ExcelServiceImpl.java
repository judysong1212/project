package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Psnl0320ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.server.service.dao.Psnl0320DAO;
import com.app.exterms.personal.server.vo.Psnl0320SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("psnl0320ExcelService")
public class Psnl0320ExcelServiceImpl extends AbstractServiceImpl implements Psnl0320ExcelService {
    
    
    @Autowired
    @Resource(name="psnl0320DAO")
    private Psnl0320DAO psnl0320DAO;
     
  public List selectXlsPsnl0320List(Psnl0320SrhVO vo) throws Exception {
      return psnl0320DAO.selectXlsPsnl0320List(vo);
  } 
 
}
