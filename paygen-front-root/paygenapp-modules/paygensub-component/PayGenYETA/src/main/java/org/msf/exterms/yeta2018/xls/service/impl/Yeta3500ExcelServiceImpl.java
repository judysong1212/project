package org.msf.exterms.yeta2018.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2018.xls.service.Yeta3500ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye161010_2018_DAO;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye17Ta2000_2018_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000Srh_2018_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta3500ExcelService")
public class Yeta3500ExcelServiceImpl extends AbstractServiceImpl implements Yeta3500ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta3500ExcelService.class.getName();
    
	@Autowired
	@Resource(name = "Ye161010_2018_DAO")
	private Ye161010_2018_DAO ye161010DAO;

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA2500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta3500ToYeta3000List(Ye161010Srh_2018_VO ye161010SrhVo) throws Exception {
		return ye161010DAO.selectYeta3500ToYeta3000XlsList(ye161010SrhVo);
	}
   
}