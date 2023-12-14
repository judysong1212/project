package org.msf.exterms.xls.service;

import java.util.List;

import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250SrhVO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250VO;

public interface Insr1100ExcelService {
    
    /**
     * 근무실적 리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List<InfcPkgDlgn0250VO> selectXlsDlgn0250List(InfcPkgDlgn0250SrhVO infcDlgn0250SrhVo) throws Exception;
    
    
}
