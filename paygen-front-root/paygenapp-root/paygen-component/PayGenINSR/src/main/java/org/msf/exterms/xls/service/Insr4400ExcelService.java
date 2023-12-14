package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.insurance.server.vo.Insr3150SrhVO;
import com.app.exterms.insurance.server.vo.Insr3150VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Insr4400ExcelService {
    
    /**
     * 근무실적 리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List selectXlsInsr4400List(Insr3150SrhVO insr3150SrhVo) throws Exception;
    
    List selectTxtInsr4400ToInsr3150List(Insr3150SrhVO insr3150SrhVo) throws Exception;
    
    /**
     *  엑셀파일을 등록한다. 
     * @param  hashmap
     * @throws Exception
     */

    Long updateXlsInsr4400(List<Insr3150VO> insr3150List, HttpServletRequest request) throws MSFException;
    
    void updateTxtFileInsr3150(Insr3150VO insr3150Vo) throws MSFException;
}
