package org.msf.exterms.xls.service;

import java.util.List;

import com.app.smrmf.sysm.server.vo.SysIfHist0100SrhVO;

public interface SysmUsr3100ExcelService {
    /**
     * 사용자접속정보 조회 리스트
     * @param hist0100SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFileHist0100List(SysIfHist0100SrhVO hist0100SrhVo) throws Exception;
    
  
}
