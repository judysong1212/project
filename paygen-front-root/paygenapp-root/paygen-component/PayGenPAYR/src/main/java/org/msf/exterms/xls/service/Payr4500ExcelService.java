package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0305SrhVO;

public interface Payr4500ExcelService {
    
    /**
     *  리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsPayr4400List(Payr0305SrhVO payr0305SrhVO) throws Exception;
    
    
}
