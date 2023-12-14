package org.msf.exterms.yeta2023.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2023_VO;


public interface Yeta8100ExcelService {
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	List selectXlsYeta8100List(Ye161010Srh_2023_VO searchVO) throws Exception;
	
    
}
