package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr5100SrhVO;

public interface InsrP510001ExcelService {

	 /**
    * 개인별 건강보험 월별납부내역리스트 출력  
    * @param  
    * @return
    * @throws Exception
    */
    List selectXlsInsrP51000102ToInsr5100List(Insr5100SrhVO insr5100SrhVO) throws Exception;
	
    /**
     * 부서별 건강보험 월별납부내역리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsrP51000101ToInsr5100List(Insr5100SrhVO insr5100SrhVO) throws Exception;
 	
	  
}
