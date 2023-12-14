package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Stts0100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.statistics.server.service.dao.Stts0100DAO;
import com.app.exterms.statistics.server.vo.Stts0100SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("stts0100ExcelService")
public class Stts0100ExcelServiceImpl extends AbstractServiceImpl implements Stts0100ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Stts0100ExcelServiceImpl.class);
	private static final String calledClass = Stts0100ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="stts0100DAO")
    private Stts0100DAO stts0100DAO;
    

    /**
     * 기간제근로자운영현황
     * @param InfcPkgPayr0304SrhVo	
     * @return
     * @throws Exception
     */
	public List  selectStts0100List(Stts0100SrhVO stts0100SrhVo) throws Exception {
		return stts0100DAO.selectStts0100XlsList(stts0100SrhVo);
	}


  
}
