package org.msf.exterms.yeta2016.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2016.xls.service.Yeta1400ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta2000DAO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta1400ExcelService")
public class Yeta1400ExcelServiceImpl extends AbstractServiceImpl implements Yeta1400ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta1400ExcelServiceImpl.class.getName();
    
    @Autowired 
    @Resource(name="Yeta2000DAO")
    private Yeta2000DAO yeta2000DAO;

    /**
     * 연말정산신고내역 엑셀 저장(YETA0500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta1400ToYeta2000List(Yeta2000SrhVO yeta2000SrhVo) throws Exception {
		return yeta2000DAO.selectYeta1400ToYeta2000XlsList(yeta2000SrhVo);
	}
   
}