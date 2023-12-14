package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.payroll.server.vo.Payr0520VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Payr5400ExcelService {
    
    /**
     *  개별수당리스트 엑셀 양식
     * @param 
     * @return
     * @throws Exception
     */
    List selectXlsPayr0520List(Payr0520VO payr0520Vo) throws Exception;
    
    
	/**
	 *  엑셀파일을 등록한다.(JXLS)
	 * @param  hashmap
	 * @throws Exception
	 */
	Long insertXlsPayr5400ToPayr0520(List<Payr0520VO> payr0520List, HttpServletRequest request) throws MSFException;
    
    
}
