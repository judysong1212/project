package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr2200SrhVO;


public interface Insr2400ExcelService {
    
    /**
     * 이직관련 리스트
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsInsr2400List(Insr2200SrhVO insr2200SrhVo) throws Exception;
    
    List selectXlsInsrP230006(Insr2200SrhVO insr2200SrhVo) throws Exception;
    
}
