package org.msf.exterms.yeta2022.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.yeta2022.xls.service.Yeta7100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.yearendtax.server.service.yeta2022.dao.Ye161010_2022_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2022_VO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("yeta7100ExcelService")
public class Yeta7100ExcelServiceImpl extends AbstractServiceImpl implements Yeta7100ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(Yeta7100ExcelServiceImpl.class);
	private static final String calledClass = Yeta7100ExcelService.class.getName();

	@Autowired
	@Resource(name = "Ye161010_2022_DAO")
	private Ye161010_2022_DAO ye161010DAO;
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	public List selectXlsYeta7100List(Ye161010Srh_2022_VO searchVO)throws Exception {
		
		searchVO.setFirstIndex(1);
        searchVO.setLastIndex(ye161010DAO.selectYe161010ListTotCnt(searchVO));
        
		return ye161010DAO.selectYe161010List(searchVO);
	}

	
	
	

}