package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr4200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr4200SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr3150ExcelService {
    
    /**
     * 기본리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsInsr4200List(Insr4200SrhVO insr4200SrhVO) throws Exception;
	
    /**
	 *  엑셀파일을 등록한다.
	 * @param  hashmap
	 * @throws Exception
	 */
	Long updateXlsInsr3150(List<Insr4200ExcelVO> insr4200List, HttpServletRequest request) throws MSFException;
}
