package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr1100VO;
import com.app.exterms.insurance.server.vo.Insr1200SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550VO;
import com.app.exterms.insurance.server.vo.Insr1600VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr2100ExcelService {
    
    List selectXlsInsr1200List(Insr1200SrhVO insr1200SrhVo) throws Exception;
    
    List selectXlsInsr1550List(Insr1550SrhVO insr1550SrhVo) throws Exception;
    
    List selectXlsInsr1600List(Insr1550SrhVO insr1550SrhVo) throws Exception;
    
    int selectInsr1550Check(Insr1550VO vo) throws MSFException ;
    
    void updateXlsInsr1550(Insr1550VO vo) throws MSFException ;
    
    Long updateXlsInsr1100(Insr1100VO insr1100Vo) throws MSFException ;
    
    Long updateXlsInsr1100Each(Insr1100VO insr1100Vo) throws MSFException ;
    
    
    void updateXlsInsr2150ToInsr1550(Insr1550VO vo) throws MSFException ;
    void updateXlsInsr2150ToInsr1600(Insr1600VO vo) throws MSFException ;
}
