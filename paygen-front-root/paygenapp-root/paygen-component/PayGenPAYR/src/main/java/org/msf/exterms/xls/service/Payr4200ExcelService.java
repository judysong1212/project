package org.msf.exterms.xls.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.exterms.payroll.server.vo.Payr0307VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface Payr4200ExcelService {
    
    /**
     *  리스트 
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List<EgovMap> selectXlsPayr4200List2(Payr0304SrhVO   payr0304SrhVO ) throws Exception;
    
    EgovMap selectXlsPayr4200List1(Payr0304SrhVO   payr0304SrhVO ) throws Exception;
    
    List<Payr4200VO> selectXlsPayr4200List(Payr0304SrhVO   payr0304SrhVO ) throws Exception;
    
    
    List<Payr4200TotVO> selectXlsTotPayr4200List(Payr0304SrhVO   payr0304SrhVO ) throws Exception; 
    
    /**
     * 급여대상자정보 리스트(양식)
     * @param psnl0290SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFilePayr304_307ToPayr4200List(Payr0304SrhVO payr0304SrhVO) throws MSFException;
    
    
    /**
     *  엑셀업로드 (JXLS)
     * @TODO DELETE INSERT
     * @param  hashmap
     * @throws Exception
     */

    Long updateXlsPayr0307To4200(List<Payr0307VO> payr0307List, HttpServletRequest request) throws MSFException;
    
    
    
}
