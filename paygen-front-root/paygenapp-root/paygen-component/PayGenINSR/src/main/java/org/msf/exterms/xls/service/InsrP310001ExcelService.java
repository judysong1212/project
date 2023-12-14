package org.msf.exterms.xls.service;

import java.util.List;

import com.app.exterms.insurance.server.vo.Insr4100SrhVO;

public interface InsrP310001ExcelService {
    
	 /**
     * 국민연금기본리스트 출력  
     * @param  
     * @return
     * @throws Exception
     */
     List selectXlsPInsr4100List(Insr4100SrhVO insr4100SrhVO) throws Exception;
	
 	 
}
