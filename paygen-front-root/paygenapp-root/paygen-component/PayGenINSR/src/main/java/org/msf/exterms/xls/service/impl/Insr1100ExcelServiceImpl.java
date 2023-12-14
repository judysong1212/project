package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Insr1100ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.diligence.server.service.dao.InfcPkgDlgn0100DAO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("insr1100ExcelService")
public class Insr1100ExcelServiceImpl extends AbstractServiceImpl implements Insr1100ExcelService {
    
    @Autowired 
    @Resource(name="InfcPkgDlgn0100DAO")
    private InfcPkgDlgn0100DAO infcDlgn0100DAO;
     
  public List<InfcPkgDlgn0250VO> selectXlsDlgn0250List(InfcPkgDlgn0250SrhVO infcDlgn0250SrhVo) throws Exception {
      return infcDlgn0100DAO.selectXlsDlgn0250List(infcDlgn0250SrhVo);
  } 

  
}
