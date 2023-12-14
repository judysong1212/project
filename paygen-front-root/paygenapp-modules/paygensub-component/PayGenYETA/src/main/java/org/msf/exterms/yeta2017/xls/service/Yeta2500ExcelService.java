package org.msf.exterms.yeta2017.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;

public interface Yeta2500ExcelService {
	

    /**
     * 연말정산신고내역 엑셀 저장(YETA0500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
    List  selectYeta2500ToYeta2000List(Ye161010SrhVO ye161010SrhVo) throws Exception;

    
}
