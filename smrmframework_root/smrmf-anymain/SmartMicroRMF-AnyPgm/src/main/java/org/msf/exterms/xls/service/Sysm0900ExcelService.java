package org.msf.exterms.xls.service;

import java.util.List;

import com.app.smrmf.sysm.server.vo.SysIfSysm0900SrhVO;

public interface Sysm0900ExcelService {
    /**
     * 사용자정보 조회 리스트
     * @param SysIfSysm0100SrhVO
     * @return
     * @throws Exception
     */
    List  selectXlsSysm0900List(SysIfSysm0900SrhVO sysm0900SrhVo) throws Exception;
  
}
