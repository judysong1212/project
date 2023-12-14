package org.msf.exterms.yeta2017.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2017.xls.service.Yeta2400ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161010DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Yeta2400ExcelService")
public class Yeta2400ExcelServiceImpl extends AbstractServiceImpl implements Yeta2400ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta2400ExcelServiceImpl.class.getName();
    
	@Autowired
	@Resource(name = "Ye161010DAO")
	private Ye161010DAO ye161010DAO;
	

    /**
     * 연말정산신고내역 엑셀 저장(YETA0500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta2400ToYeta2400List(Ye161010SrhVO ye161010SrhVo) throws Exception {
		return ye161010DAO.selectYeta2400ToYeta2000XlsList(ye161010SrhVo);
	}
   
	
	    
}