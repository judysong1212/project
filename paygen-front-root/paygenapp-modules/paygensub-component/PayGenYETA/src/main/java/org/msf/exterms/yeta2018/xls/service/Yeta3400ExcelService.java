package org.msf.exterms.yeta2018.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2018_VO;

public interface Yeta3400ExcelService {
	

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA0400)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
    List  selectYeta3400ToYeta3400List(Ye161010Srh_2018_VO ye161010SrhVo) throws Exception;

    
}
