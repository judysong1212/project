package org.msf.exterms.yeta2018.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2018.xls.service.Yeta3100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye161010_2018_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2018_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta3100ExcelService")
public class Yeta3100ExcelServiceImpl extends AbstractServiceImpl implements Yeta3100ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(Yeta3100ExcelServiceImpl.class);
	private static final String calledClass = Yeta3100ExcelService.class.getName();

	@Autowired
	@Resource(name = "Ye161010_2018_DAO")
	private Ye161010_2018_DAO ye161010DAO;
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	public List selectXlsYeta3100List(Ye161010Srh_2018_VO searchVO)throws Exception {
		
		searchVO.setFirstIndex(1);
        searchVO.setLastIndex(ye161010DAO.selectYe161010ListTotCnt(searchVO));
        
		return ye161010DAO.selectYe161010List(searchVO);
	}

	
	
	

}