package org.msf.exterms.xls.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.diligence.server.vo.Dlgn0200SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0210ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;

public interface Dlgn0200ExcelService {
	
    /**
     * 근무실적 생성 리스트_JXLS (양식)
     * @param payr0250SrhVo
     * @return
     * @throws Exception
     */
    List<Dlgn0250VO> selectXlsDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception;
    
    /**
     * 근무실적 생성 리스트_JXLS (양식)
     * @param payr0200SrhVo
     * @return
     * @throws Exception
     */
	List<Dlgn0250VO> selectXlsDlgn0200List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception;
    
    /**
     * 근무실적 조회 리스트
     * @param payr0200SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFileDlgn0200List(Dlgn0200SrhVO dlgn0200SrhVo) throws Exception;
    
    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  hashmap
     * @throws Exception
     */
    Long updateXlsDlgn0200(List<Dlgn0210ExlVO> dlgn0210List, HttpServletRequest request) throws Exception;
     
    
    
    
    // 구 업로드
    // ----------------------------------------------------------
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXlsDlgn0200(InputStream file) throws Exception;
    
//    /**
//     *  엑셀파일을 등록한다.
//     * @param  
//     * @throws Exception
//     */
//    void insertXlsDlgn0200(InputStream file) throws Exception;
//    
//    /**
//     *  엑셀파일을 등록한다.
//     * @param  
//     * @throws Exception
//     */
//    void insertXSSFDlgn0200(InputStream file) throws Exception;
//    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXSSFDlgn0200(InputStream file) throws Exception;
    // ----------------------------------------------------------
    
    
    
    /**
     * DLGN0200을 수정한다.
     * @param vo - 수정할 정보가 담긴 Dlgn0200VO
     * @return void형
     * @exception Exception
     */
    void updateXlsDlgn0200(Dlgn0200VO vo) throws Exception;
    
    /**
     * DLGN0200을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Dlgn0200VO
     * @return void형 
     * @exception Exception
     */
    void deleteXlsDlgn0200(Dlgn0200VO vo) throws Exception;
    
    /**
     * DLGN0200을 조회한다.
     * @param vo - 조회할 정보가 담긴 Dlgn0200VO
     * @return 조회한 DLGN0200
     * @exception Exception
     */
    Dlgn0200VO selectXlsDlgn0200(Dlgn0200VO vo) throws Exception;
    
    
    /**
     * DLGN0200을 등록한다.
     * @param vo - 등록할 정보가 담긴 Dlgn0200VO
     * @return 등록 결과
     * @exception Exception
     */
    String insertXlsDlgn0200(Dlgn0200VO vo) throws Exception;
    
}
