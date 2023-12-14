package org.msf.exterms.yeta2015.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.yearendtax.server.vo.Yeta3900SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3900VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Yeta0900ExcelService {
	

    /**
     * 급여 다운로드 (양식)
     */
    List  selectXlsFileYeta3900List(Yeta3900SrhVO Yeta3900SrhVo) throws Exception;

    /**
     *  급여업로드_엑셀파일을 등록한다. (JXLS)
     */

    Long updateXlsYeta3900(List<Yeta3900VO> yeta3900List, HttpServletRequest request) throws MSFException;


    
}
