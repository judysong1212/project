package org.msf.exterms.remt.xls.service;

import java.util.List;

import com.app.exterms.retirement.server.vo.Remt3100SrhVO;

public interface Remt0300ExcelService {
    
    /**
     *  리스트 
     * @param remt3100SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsRemt0300List(Remt3100SrhVO   remt3100SrhVo) throws Exception;
    
   
}
