package org.msf.exterms.yeta2022.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2022.xls.service.Yeta7400ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2022.dao.Ye161010_2022_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000Srh_2022_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Yeta7400ExcelService")
public class Yeta7400ExcelServiceImpl extends AbstractServiceImpl implements Yeta7400ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta7400ExcelServiceImpl.class.getName();
    
	@Autowired
	@Resource(name = "Ye161010_2022_DAO")
	private Ye161010_2022_DAO ye161010DAO;
	

    /**
     * 연말정산신고내역 엑셀 저장(YETA0500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta7400ToYeta7400List(Ye161010Srh_2022_VO ye161010SrhVo) throws Exception {
		return ye161010DAO.selectYeta7400ToYeta3000XlsList(ye161010SrhVo);
	}
   
	
	    
}