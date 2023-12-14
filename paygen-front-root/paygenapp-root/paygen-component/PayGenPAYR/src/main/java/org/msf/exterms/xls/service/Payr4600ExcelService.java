package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0650SrhVO;

public interface Payr4600ExcelService {
    
    /**
     *  리스트 
     * @param payr0650SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsPayr0650List(Payr0650SrhVO payr0650SrhVO) throws Exception;
    
    
}
