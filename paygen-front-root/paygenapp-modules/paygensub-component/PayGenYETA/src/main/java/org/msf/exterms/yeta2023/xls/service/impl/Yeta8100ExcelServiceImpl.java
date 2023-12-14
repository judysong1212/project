package org.msf.exterms.yeta2023.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2023.xls.service.Yeta8100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye161010_2023_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2023_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta8100ExcelService")
public class Yeta8100ExcelServiceImpl extends AbstractServiceImpl implements Yeta8100ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(Yeta8100ExcelServiceImpl.class);
	private static final String calledClass = Yeta8100ExcelService.class.getName();

	@Autowired
	@Resource(name = "Ye161010_2023_DAO")
	private Ye161010_2023_DAO ye161010DAO;
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	public List selectXlsYeta8100List(Ye161010Srh_2023_VO searchVO)throws Exception {
		
		searchVO.setFirstIndex(1);
        searchVO.setLastIndex(ye161010DAO.selectYe161010ListTotCnt(searchVO));
        
		return ye161010DAO.selectYe161010List(searchVO);
	}

	
	
	

}