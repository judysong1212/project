package org.msf.exterms.yeta2020.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2020_VO;


public interface Yeta5100ExcelService {
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	List selectXlsYeta5100List(Ye161010Srh_2020_VO searchVO) throws Exception;
	
    
}
