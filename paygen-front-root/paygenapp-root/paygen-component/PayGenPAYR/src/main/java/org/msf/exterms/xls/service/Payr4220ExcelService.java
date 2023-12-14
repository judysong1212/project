package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0303SrhVO;

public interface Payr4220ExcelService {
    
    /**
     *  리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsPayr4220List(Payr0303SrhVO   payr0303SrhVO ) throws Exception;
     
   
}
