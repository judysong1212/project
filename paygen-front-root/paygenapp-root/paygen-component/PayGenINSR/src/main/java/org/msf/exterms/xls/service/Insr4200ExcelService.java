package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr3200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr3200SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr4200ExcelService {
	/**
	 * 국민연금기본리스트 출력
	 * @param
	 * @return
	 * @throws Exception
	 */
	List selectXlsInsr4200ToInsr3200List(Insr3200SrhVO insr3200SrhVO) throws Exception;
	
	/**
	 *  엑셀파일을 등록한다.
	 * @param  hashmap
	 * @throws Exception
	 */
	Long updateXlsInsr4200(List<Insr3200ExcelVO> insr3200List, HttpServletRequest request) throws MSFException;
}