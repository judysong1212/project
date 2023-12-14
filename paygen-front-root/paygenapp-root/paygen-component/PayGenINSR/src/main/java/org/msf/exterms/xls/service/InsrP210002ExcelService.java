package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr1100SrhVO;

public interface InsrP210002ExcelService {
    
    /**
     * 근무실적 리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsInsrP210002ToInsr12000240List(Insr1100SrhVO insr1100SrhVO) throws Exception;
    
}
