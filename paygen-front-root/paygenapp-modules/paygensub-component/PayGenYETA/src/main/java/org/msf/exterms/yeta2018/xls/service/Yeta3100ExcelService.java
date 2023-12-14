package org.msf.exterms.yeta2018.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2018_VO;


public interface Yeta3100ExcelService {
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	List selectXlsYeta3100List(Ye161010Srh_2018_VO searchVO) throws Exception;
	
    
}
