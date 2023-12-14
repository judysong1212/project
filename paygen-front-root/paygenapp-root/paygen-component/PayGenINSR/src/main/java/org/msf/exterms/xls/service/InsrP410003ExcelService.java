package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr3000SrhVO;

public interface InsrP410003ExcelService {

	 /**
    *  건강보험 개별납부내역리스트 출력  
    * @param  
    * @return
    * @throws Exception
    */
    List selectXlsInsrP410003ToInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception;
	
    
}
