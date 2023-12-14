package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0307SrhVO;

public interface PayrP420001ExcelService {
    
    
    /**
     * 급여조정내역리스트
     * @param psnl0290SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsPayrP420001List(Payr0307SrhVO   payr0307SrhVo) throws Exception;
    
    
    
    
}
