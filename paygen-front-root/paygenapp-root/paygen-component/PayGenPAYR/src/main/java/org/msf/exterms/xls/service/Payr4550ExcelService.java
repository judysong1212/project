package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0301SrhVO;

public interface Payr4550ExcelService {
    
    /**
     *  리스트 
     * @param payr0301srhVo
     * @return
     * @throws Exception
     */
    List selectXlsPayr4550List(Payr0301SrhVO payr0301srhVo) throws Exception;
    
    
}
