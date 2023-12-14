package org.msf.exterms.yeta2021.xls.service;

import java.util.List;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2021_VO;

public interface Yeta6500ExcelService {
	

    /**
     * 연말정산신고내역 엑셀 저장(YETA0500)
     * @param yeta2000SrhVo
     * @return
     * @throws Exception
     */
    List  selectYeta6500ToYeta3000List(Ye161010Srh_2021_VO ye161010SrhVo) throws Exception;

    
}
