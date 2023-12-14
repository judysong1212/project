package org.msf.exterms.yeta2021.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2021_VO;


public interface Yeta6100ExcelService {
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	List selectXlsYeta6100List(Ye161010Srh_2021_VO searchVO) throws Exception;
	
    
}
