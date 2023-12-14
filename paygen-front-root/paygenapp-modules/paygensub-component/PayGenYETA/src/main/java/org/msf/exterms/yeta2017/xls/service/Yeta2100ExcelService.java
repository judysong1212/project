package org.msf.exterms.yeta2017.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;


public interface Yeta2100ExcelService {
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	List selectXlsYeta2100List(Ye161010SrhVO searchVO) throws Exception;
	
    
}
