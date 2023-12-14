package org.msf.exterms.xls.service;

import java.util.List;

import com.app.smrmf.sysm.server.vo.SysIfHist0300SrhVO;

public interface SysmUsr3300ExcelService {
    /**
     * 에러정보 조회 리스트
     * @param hist0300SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFileHist0300List(SysIfHist0300SrhVO hist0300SrhVo) throws Exception;
    
  
}
