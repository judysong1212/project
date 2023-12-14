package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr4300SrhVO;

public interface Insr3200ExcelService {
    
    /**
     * 근무실적 리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectInsr320001ToInsr4300List(Insr4300SrhVO insr4300SrhVo) throws Exception;
    
    List selectInsr320002ToInsr4300List(Insr4300SrhVO insr4300SrhVo) throws Exception;
     
}
