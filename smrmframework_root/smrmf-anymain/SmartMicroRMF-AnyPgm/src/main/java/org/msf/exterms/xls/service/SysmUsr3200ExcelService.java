package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import com.app.smrmf.sysm.server.vo.SysIfHist0200SrhVO;

public interface SysmUsr3200ExcelService {
    /**
     * 사용자작업정보 조회 리스트
     * @param hist0200SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFileHist0200List(SysIfHist0200SrhVO hist0200SrhVo) throws Exception;
    

    // 점검내역 엑셀 추가_hieju 07.31
	List<SysIfHist0200SrhVO> selectXlsSysm3200List(SysIfHist0200SrhVO oracleDb0100) throws Exception;
	
    List  selectXlsFileSysm3200List(SysIfHist0200SrhVO oracleDb0100) throws Exception;

	List<SysIfHist0200SrhVO> selectXlsSysm3200List1(
			SysIfHist0200SrhVO oracleDb0100) throws Exception;

	List selectXlsFileSysm3200List1(SysIfHist0200SrhVO oracleDb0100)
			throws Exception;

	void setServletConfig(ServletConfig servletConfig);

	void setServletContext(ServletContext servletContext);

	// ************끝
}
