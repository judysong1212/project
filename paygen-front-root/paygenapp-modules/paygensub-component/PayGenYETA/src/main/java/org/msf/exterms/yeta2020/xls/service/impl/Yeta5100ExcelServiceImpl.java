package org.msf.exterms.yeta2020.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2020.xls.service.Yeta5100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161010_2020_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2020_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta5100ExcelService")
public class Yeta5100ExcelServiceImpl extends AbstractServiceImpl implements Yeta5100ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(Yeta5100ExcelServiceImpl.class);
	private static final String calledClass = Yeta5100ExcelService.class.getName();

	@Autowired
	@Resource(name = "Ye161010_2020_DAO")
	private Ye161010_2020_DAO ye161010DAO;
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	public List selectXlsYeta5100List(Ye161010Srh_2020_VO searchVO)throws Exception {
		
		searchVO.setFirstIndex(1);
        searchVO.setLastIndex(ye161010DAO.selectYe161010ListTotCnt(searchVO));
        
		return ye161010DAO.selectYe161010List(searchVO);
	}

	
	
	

}