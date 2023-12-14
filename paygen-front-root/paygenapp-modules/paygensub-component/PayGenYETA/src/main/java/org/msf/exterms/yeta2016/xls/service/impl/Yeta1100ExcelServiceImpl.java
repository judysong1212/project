package org.msf.exterms.yeta2016.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2016.xls.service.Yeta1100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta2000DAO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta1100ExcelService")
public class Yeta1100ExcelServiceImpl extends AbstractServiceImpl implements Yeta1100ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Yeta1100ExcelServiceImpl.class);
	private static final String calledClass = Yeta1100ExcelServiceImpl.class.getName();
    
    @Autowired 
    @Resource(name="Yeta2000DAO")
    private Yeta2000DAO yeta2000DAO;

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA0100)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta1100ToYeta2000List(Yeta2000SrhVO yeta2000SrhVo) throws Exception {
		return yeta2000DAO.selectYeta0100ToYeta2000XlsList(yeta2000SrhVo);
	}
   
}