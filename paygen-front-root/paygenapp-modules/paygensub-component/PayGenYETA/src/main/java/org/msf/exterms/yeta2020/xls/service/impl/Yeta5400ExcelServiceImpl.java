package org.msf.exterms.yeta2020.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2020.xls.service.Yeta5400ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161010_2020_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000Srh_2020_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Yeta5400ExcelService")
public class Yeta5400ExcelServiceImpl extends AbstractServiceImpl implements Yeta5400ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta5400ExcelServiceImpl.class.getName();
    
	@Autowired
	@Resource(name = "Ye161010_2020_DAO")
	private Ye161010_2020_DAO ye161010DAO;
	

    /**
     * 연말정산신고내역 엑셀 저장(YETA0500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta5400ToYeta5400List(Ye161010Srh_2020_VO ye161010SrhVo) throws Exception {
		return ye161010DAO.selectYeta5400ToYeta3000XlsList(ye161010SrhVo);
	}
   
	
	    
}