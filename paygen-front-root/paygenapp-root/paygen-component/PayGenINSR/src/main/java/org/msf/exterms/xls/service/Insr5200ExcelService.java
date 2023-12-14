package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr5200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr5200SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr5200ExcelService {
    
    /**
     * 국민연금기본리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsr5200List(Insr5200SrhVO insr5100SrhVO) throws Exception;
	

     
    /**
	 *  엑셀파일을 등록한다.
	 * @param  hashmap
	 * @throws Exception
	 */
	Long updateXlsInsr5200(List<Insr5200ExcelVO> insr5200List, HttpServletRequest request) throws MSFException;

     
}
