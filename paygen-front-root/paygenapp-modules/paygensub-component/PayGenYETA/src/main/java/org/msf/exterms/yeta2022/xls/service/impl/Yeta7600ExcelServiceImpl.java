package org.msf.exterms.yeta2022.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2022.xls.service.Yeta7600ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2022.dao.Ye161010_2022_DAO;
import com.app.exterms.yearendtax.server.service.yeta2022.dao.Ye17Ta2000_2022_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000Srh_2022_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta7600ExcelService")
public class Yeta7600ExcelServiceImpl extends AbstractServiceImpl implements Yeta7600ExcelService {
	
//	private static final Logger logger = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	private static final String calledClass = Yeta7600ExcelService.class.getName();
    
	@Autowired
	@Resource(name = "Ye161010_2022_DAO")
	private Ye161010_2022_DAO ye161010DAO;

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA2500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
	public List  selectYeta7600ToYeta3000List(Ye161010Srh_2022_VO ye161010SrhVo) throws Exception {
		return ye161010DAO.selectYeta7600ToYeta3000XlsList(ye161010SrhVo);
	}
   
}