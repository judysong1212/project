package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130SrhVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130VO;

public interface Payr1700ExcelService {
	/**
	 * 휴가일수 산정 조회 리스트 (양식)
	 * @param psnl0290SrhVo
	 * @return
	 * @throws Exception
	 */
	List selectXlsFilePayr1700List(InfcPkgPsnl0130SrhVO psnl0130SrhVo) throws Exception;
	
	List selectXlsFilePayr170002List(InfcPkgPsnl0130SrhVO psnl0130SrhVo) throws Exception;
	
	/**
	 *  엑셀파일을 등록한다.(JXLS)
	 * @param  hashmap
	 * @throws Exception
	 */
	Long insertXlsPayr1700(List<InfcPkgPsnl0130VO> psnl0130List, HttpServletRequest request) throws MSFException;
}