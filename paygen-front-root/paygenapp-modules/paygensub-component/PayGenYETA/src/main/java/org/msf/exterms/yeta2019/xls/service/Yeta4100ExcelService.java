package org.msf.exterms.yeta2019.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2019_VO;


public interface Yeta4100ExcelService {
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	List selectXlsYeta4100List(Ye161010Srh_2019_VO searchVO) throws Exception;
	
    
}
