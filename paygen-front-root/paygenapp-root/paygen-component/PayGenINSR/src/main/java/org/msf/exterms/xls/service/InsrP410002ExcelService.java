package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr3000SrhVO;

public interface InsrP410002ExcelService {

	 /**
    * 개인별 건강보험 월별납부내역리스트 출력  
    * @param  
    * @return
    * @throws Exception
    */
    List selectXlsInsrP41000202ToInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception;
	
    /**
     * 부서별 건강보험 월별납부내역리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsrP41000201ToInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception;
 	
	  
}
