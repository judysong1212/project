package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.exterms.basis.server.vo.Bass0350SrhVO;
import com.app.exterms.basis.server.vo.Bass0350VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Bass0350ExcelService {
	
	/**
     * 퇴직정산 산정 조회 리스트 (양식)
     * @param remt9000SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsFileBass0350List(Bass0350SrhVO bass0350SrhVo) throws Exception;
    
    
        
    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  hashmap
     * @throws Exception
     */
    Long updateXlsBass0350(List<Bass0350VO> Bass0350List, HttpServletRequest request, HttpServletResponse response) throws MSFException;

}
