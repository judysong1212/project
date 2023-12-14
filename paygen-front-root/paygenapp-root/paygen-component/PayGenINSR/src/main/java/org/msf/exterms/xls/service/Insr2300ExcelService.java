package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr1600VO;
import com.app.exterms.insurance.server.vo.Insr2100VO;
import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr2300ExcelService {
    
    /**
     * 근무실적 리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsInsr2200List(Insr2200SrhVO insr2200SrhVo) throws Exception;
    Long updateXlsInsr2100(Insr2100VO insr2100Vo) throws MSFException ;
    Long updateXlsInsr2100Each(Insr2100VO insr2100Vo) throws MSFException ;
    int selectInsr1600Check(Insr1600VO vo) throws MSFException ;
    void updateInsr1600(Insr1600VO vo) throws MSFException ;
}
