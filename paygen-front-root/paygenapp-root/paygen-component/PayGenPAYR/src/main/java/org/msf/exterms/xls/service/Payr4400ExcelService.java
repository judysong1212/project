package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0301SrhVO;

public interface Payr4400ExcelService {
    
    /**
     *  리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsPayr4400List(Payr0301SrhVO payr0301SrhVO) throws Exception;
    
    /**
     * 이호조 연계파일 생성  
     * @param payr0301SrhVO
     * @return
     * @throws Exception
     */
    List selectXlsHoJoPayr4400List(Payr0301SrhVO payr0301SrhVO) throws Exception;
    
    
}
