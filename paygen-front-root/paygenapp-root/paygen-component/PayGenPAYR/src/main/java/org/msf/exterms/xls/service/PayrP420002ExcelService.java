package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface PayrP420002ExcelService {
    
    
    /**
     * 급여조정내역리스트(양식)
     * @param payr0307SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFilePayr304_307ToPayr4200List(Payr0304SrhVO   payr0304SrhVo) throws MSFException;
    
    
    
    
}
