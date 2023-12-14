package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0530SrhVO;

public interface PayrP410005ExcelService {
    
    
    /**
     * 가족수당대상자 리스트
     * @param payr0530SrhVO
     * @return
     * @throws Exception
     */
    List  selectXlsPayrP410005List(Payr0530SrhVO payr0530SrhVO) throws Exception;
   
    
    
    
}
