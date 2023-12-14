package org.msf.exterms.yeta2017.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2017.xls.service.Yeta2100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161010DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta2100ExcelService")
public class Yeta2100ExcelServiceImpl extends AbstractServiceImpl implements Yeta2100ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(Yeta2100ExcelServiceImpl.class);
	private static final String calledClass = Yeta2100ExcelService.class.getName();

	@Autowired
	@Resource(name = "Ye161010DAO")
	private Ye161010DAO ye161010DAO;
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	public List selectXlsYeta2100List(Ye161010SrhVO searchVO)throws Exception {
		
		searchVO.setFirstIndex(1);
        searchVO.setLastIndex(ye161010DAO.selectYe161010ListTotCnt(searchVO));
        
		return ye161010DAO.selectYe161010List(searchVO);
	}

	
	
	

}