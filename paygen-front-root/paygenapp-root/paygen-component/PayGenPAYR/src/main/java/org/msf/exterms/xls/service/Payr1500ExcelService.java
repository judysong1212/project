package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.payroll.server.vo.Payr0410SrhVO;

public interface Payr1500ExcelService {
    
    /**
     * 근무실적 리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List<?> selectXlsInsr1500List(Payr0410SrhVO payr0410SrhVo) throws Exception;

}
