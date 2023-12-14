package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr5400SrhVO;

public interface Insr5400ExcelService {

    /**
     * 고용보험보수총액신고  
     * @param  
     * @return
     * @throws Exception
     */
     //List selectXlsInsr3000List(Insr3000SrhVO insr3000SrhVO) throws Exception;
	List selectXlsInsr5400List(Insr5400SrhVO insr5400SrhVO) throws Exception;
}
