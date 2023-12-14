package org.msf.exterms.remt.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.retirement.server.vo.Remt9000SrhVO;
import com.app.exterms.retirement.server.vo.Remt9000VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Remt0400ExcelService {
		
	/**
     * 퇴직정산 산정 조회 리스트 (양식)
     * @param remt9000SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsFileRemt0400List(Remt9000SrhVO remt9000SrhVo) throws Exception;
    
    
        
    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  hashmap
     * @throws Exception
     */
    List<Remt9000VO> updateXlsRemt0400(List<Remt9000VO> remt9000List, HttpServletRequest request) throws MSFException;

}
