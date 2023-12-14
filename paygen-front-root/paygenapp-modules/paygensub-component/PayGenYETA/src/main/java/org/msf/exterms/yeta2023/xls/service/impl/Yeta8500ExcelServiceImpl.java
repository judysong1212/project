package org.msf.exterms.yeta2023.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2023.xls.service.Yeta8500ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye161010_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye17Ta2000_2023_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000Srh_2023_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta8500ExcelService")
public class Yeta8500ExcelServiceImpl extends AbstractServiceImpl implements Yeta8500ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta8500ExcelService.class.getName();
    
	@Autowired
	@Resource(name = "Ye161010_2023_DAO")
	private Ye161010_2023_DAO ye161010DAO;

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA2500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta8500ToYeta3000List(Ye161010Srh_2023_VO ye161010SrhVo) throws Exception {
		return ye161010DAO.selectYeta8500ToYeta3000XlsList(ye161010SrhVo);
	}
   
}