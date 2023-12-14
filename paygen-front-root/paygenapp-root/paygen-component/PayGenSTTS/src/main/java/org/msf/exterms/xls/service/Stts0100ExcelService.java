package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.statistics.server.vo.Stts0100SrhVO;


public interface Stts0100ExcelService {
	
    /**
     * 기간제근로자운영현황
     * @param InfcPkgPayr0304SrhVo	
     * @return
     * @throws Exception
     */
    List  selectStts0100List(Stts0100SrhVO stts0100SrhVo) throws Exception;
    
}
