package org.msf.exterms.xls.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.basis.server.vo.Bass0350SrhVO;
import com.app.exterms.basis.server.vo.Psnl2100VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface BassP031001ExcelService {
	
	/**
     * 퇴직정산 산정 조회 리스트 (양식)
     * @param remt9000SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsFileBassP031001List(Bass0350SrhVO bass0350SrhVo) throws Exception;
    
    
        
    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  hashmap
     * @throws Exception
     */
    Long updateXlsBassP031001(List<Psnl2100VO> psnl2100List, HttpServletRequest request, Map<String,Object> objectrMap) throws MSFException;

}
