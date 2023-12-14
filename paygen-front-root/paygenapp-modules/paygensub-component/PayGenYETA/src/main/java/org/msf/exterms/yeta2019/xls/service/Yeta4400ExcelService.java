package org.msf.exterms.yeta2019.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2019_VO;

public interface Yeta4400ExcelService {
	

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA0400)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
    List  selectYeta4400ToYeta4400List(Ye161010Srh_2019_VO ye161010SrhVo) throws Exception;

    
}
