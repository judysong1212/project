package org.msf.exterms.xls.service;

import java.util.List;

import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;

public interface SysmUsr0100ExcelService {
    /**
     * 사용자정보 조회 리스트
     * @param SysIfSysm0100SrhVO
     * @return
     * @throws Exception
     */
    List  selectXlsFileSysmUsr0100List(SysIfSysm0100SrhVO sysIfSysm0100SrhVo) throws Exception;
  
}
