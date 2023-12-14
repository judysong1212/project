package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.personal.server.vo.Psnl0320SrhVO;

public interface Psnl0320ExcelService {
    
    /**
     *  인사통합출력 엑셀저장(기본)
     * @param Psnl0600SrhVO
     * @return
     * @throws Exception
     */
    //List selectXlsPsnl0600List(Psnl0100SrhVO psnl0100SrhVo) throws Exception;
    
    List selectXlsPsnl0320List(Psnl0320SrhVO psnl0320SrhVo) throws Exception;
    
   
    
   
}
