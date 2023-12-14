package org.msf.exterms.yeta2022.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2022_VO;


public interface Yeta7100ExcelService {
	

	/**
	 * 연말정산대상자 및 내역 엑셀 저장
	 */
	List selectXlsYeta7100List(Ye161010Srh_2022_VO searchVO) throws Exception;
	
    
}
