package org.msf.exterms.yeta2017.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;

public interface Yeta2400ExcelService {
	

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA0400)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
    List  selectYeta2400ToYeta2400List(Ye161010SrhVO ye161010SrhVo) throws Exception;

    
}
