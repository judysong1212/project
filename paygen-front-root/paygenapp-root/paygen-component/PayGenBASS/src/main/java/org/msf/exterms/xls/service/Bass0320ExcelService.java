package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.basis.server.vo.Bass0320SrhVO;
import com.app.exterms.basis.server.vo.Bass0320VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Bass0320ExcelService {
	
	/**
     * 퇴직정산 산정 조회 리스트 (양식)
     * @param remt9000SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsFileBass0320List(Bass0320SrhVO bass0320SrhVo) throws Exception;
    
    
        
    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  hashmap
     * @throws Exception
     */
    Long updateXlsBass0320(List<Bass0320VO> Bass0320List, HttpServletRequest request) throws MSFException;

}
