package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0416SrhVO;

public interface Payr5250ExcelService {
    
    /**
     * 근무실적 리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List<?> selectXlsPayr0416List(Payr0416SrhVO payr0416SrhVo) throws Exception;

}
