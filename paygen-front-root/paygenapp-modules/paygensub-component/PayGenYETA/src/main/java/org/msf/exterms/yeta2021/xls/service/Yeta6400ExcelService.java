package org.msf.exterms.yeta2021.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2021_VO;

public interface Yeta6400ExcelService {
	

    /**
     * 연말정산대상자 및 내역 엑셀 저장(YETA0400)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
    List  selectYeta6400ToYeta6400List(Ye161010Srh_2021_VO ye161010SrhVo) throws Exception;

    
}
