package org.msf.exterms.remt.xls.service;

import java.util.List;

import com.app.exterms.retirement.server.vo.Remt2000SrhVO;

public interface Remt0150ExcelService {
    
    /**
     *  리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsRemt0150List(Remt2000SrhVO   remt2000SrhVo) throws Exception;
    
   
}
