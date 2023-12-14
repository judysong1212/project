package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.dlgn.server.vo.Dlgn0300SrhVO;

public interface Dlgn0300ExcelService {
    
  
    /**
     * 근무실적 조회 리스트 
     * @param payr0300SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFileDlgn0300List(Dlgn0300SrhVO dlgn0300SrhVo) throws Exception;
     
    
    
}
