package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr4300SrhVO;
import com.app.exterms.insurance.server.vo.Insr4300VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr3300ExcelService {
    
    /**
     * 국민연금기본리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsr4100List(Insr4300SrhVO insr4300SrhVO) throws Exception;
	
    /**
	 *  엑셀파일을 등록한다.
	 * @param  hashmap
	 * @throws Exception
	 */
	Long updateXlsInsr3300(List<Insr4300VO> insr4300List, HttpServletRequest request) throws MSFException;
}
