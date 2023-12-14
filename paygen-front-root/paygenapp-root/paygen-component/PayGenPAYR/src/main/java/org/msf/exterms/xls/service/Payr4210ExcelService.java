package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0350SrhVO;

public interface Payr4210ExcelService {
    
    /**
     *  리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsPayr4210List(Payr0350SrhVO   payr0350SrhVO ) throws Exception;
  
   
}
