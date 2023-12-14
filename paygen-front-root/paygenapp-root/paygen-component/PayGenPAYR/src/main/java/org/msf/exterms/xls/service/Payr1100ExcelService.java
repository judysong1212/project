package org.msf.exterms.xls.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.payroll.client.dto.Payr0100DTO_XLS;
import com.app.exterms.payroll.server.vo.Payr0100SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface Payr1100ExcelService {
	
//    /**
//     * 근무실적 생성 
//     * 리스트 
//     * @param payr0250SrhVo
//     * @return
//     * @throws Exception
//     */
//    List<Psnl0126VO> selectXlsDlgn0250List(Psnl0126SrhVO Psnl0126SrhVo) throws Exception;
//    
    /**
     * 휴가일수 산정 조회 리스트 (양식)
     * @param psnl0290SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFilePayr0100List(Payr0100SrhVO payr0100SrhVo) throws Exception;
    
    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  hashmap
     * @throws Exception
     */

    Long insertXlsPayr0100(List<Payr0100DTO_XLS> payr0100List, HttpServletRequest request, HashMap<String, String> param) throws MSFException;
//    public String insertPayrCertInfo(HashMap<String, String> hMap) throws Exception{
//		return (String)insert("psnlPageDAO.insertPayrCertInfo",hMap);
//	}
//     int updateXlsPsnl0290(HashMap<String, List> hMap) throws Exception;
//     
//    
//    /**
//     *  엑셀파일을 등록한다.
//     * @param  
//     * @throws Exception
//     */
//    void insertXlsDlgn0100(InputStream file) throws Exception;
//    
//    
//    /**
//     *  엑셀파일을 등록한다.
//     * @param  
//     * @throws Exception
//     */
//    void insertXSSFDlgn0100(InputStream file) throws Exception;
//    
//    /**
//     * DLGN0100을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Dlgn0100VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateXlsDlgn0100(Psnl0126VO vo) throws Exception;
//    
//    /**
//     * DLGN0100을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Dlgn0100VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteXlsDlgn0100(Psnl0126VO vo) throws Exception;
//    
//    /**
//     * Psnl0126 조회한다.
//     * @param vo - 조회할 정보가 담긴 Psnl0126
//     * @return 조회한 Psnl0126
//     * @exception Exception
//     */
//    Psnl0126VO selectXlsDlgn0100(Psnl0126VO vo) throws Exception;
//    
//    
//    /**
//     * DLGN0200을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Dlgn0200VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertXlsDlgn0200(Psnl0126VO vo) throws Exception;
//    
//    /**
//     * DLGN0200을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Dlgn0200VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateXlsDlgn0200(Psnl0126VO vo) throws Exception;
//    
//    /**
//     * DLGN0200을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Dlgn0200VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteXlsDlgn0200(Psnl0126VO vo) throws Exception;
//    
//    /**
//     * Psnl0126 조회한다.
//     * @param vo - 조회할 정보가 담긴 Psnl0126
//     * @return 조회한 Psnl0126
//     * @exception Exception
//     */
//    Psnl0126VO selectXlsDlgn0200(Psnl0126VO vo) throws Exception;
//    
//    /**
//     * Psnl0126 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return Psnl0126 목록
//     * @exception Exception
//     */
    
}
