package org.msf.exterms.yeta2015.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;

public interface Yeta0400ExcelService {
	

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA0400)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
    List  selectYeta0400ToYeta2000List(Yeta2000SrhVO yeta2000SrhVo) throws Exception;

    
}
