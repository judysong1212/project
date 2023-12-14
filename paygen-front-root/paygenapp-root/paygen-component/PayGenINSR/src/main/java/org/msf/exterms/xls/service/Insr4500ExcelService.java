package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr3100SrhVO;
import com.app.exterms.insurance.server.vo.Insr3100VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr4500ExcelService {
	
	/**
	 * 근무실적 리스트
	 * @param Insr3100SrhVO
	 * @return
	 * @throws Exception
	 */
	List selectXlsInsr3100List(Insr3100SrhVO insr3100SrhVO) throws Exception;
	
	/**
	 *  엑셀파일을 등록한다.
	 * @param  hashmap
	 * @throws Exception
	 */
	Long updateXlsInsr4500(List<Insr3100VO> insr3100List, HttpServletRequest request) throws MSFException;
}