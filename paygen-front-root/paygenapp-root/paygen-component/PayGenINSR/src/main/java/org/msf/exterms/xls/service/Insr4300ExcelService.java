package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr3400SrhVO;

public interface Insr4300ExcelService {
	
	/**
	 * 근무실적 리스트
	 * @param Insr3100SrhVO
	 * @return
	 * @throws Exception
	 */
	List selectXlsInsr3400List(Insr3400SrhVO insr3400SrhVO) throws Exception;
}