package org.msf.exterms.yeta2019.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2019.xls.service.Yeta4400ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161010_2019_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000Srh_2019_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Yeta4400ExcelService")
public class Yeta4400ExcelServiceImpl extends AbstractServiceImpl implements Yeta4400ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta4400ExcelServiceImpl.class.getName();
    
	@Autowired
	@Resource(name = "Ye161010_2019_DAO")
	private Ye161010_2019_DAO ye161010DAO;
	

    /**
     * 연말정산신고내역 엑셀 저장(YETA0500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta4400ToYeta4400List(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception {
		return ye161010DAO.selectYeta4400ToYeta3000XlsList(ye161010SrhVo);
	}
   
	
	    
}