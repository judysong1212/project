package org.msf.exterms.xls.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;

public interface Dlgn0100ExcelService {
    
    /**
     * 근무실적 생성 리스트_JXLS (양식)
     * @param payr0100SrhVo
     * @return
     * @throws Exception
     */
	List<Dlgn0250VO> selectXlsDlgn0100List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception;
	
	
	
    /**
     * 엑셀생성시 근태테이블 체크 
     * @param dlgn0250SrhVo
     * @return
     * @throws Exception
     */
	Integer selectDlgn0100Cnt(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception;
    

	
	/**
     * 양식다운로드 리스트
     * @param payr0100SrhVo
     * @return
     * @throws Exception
     */
	List<Dlgn0250VO> selectXlsDlgn0100ListD(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception;
    
    /**
     * 근무실적 조회 리스트
     * @param payr0100SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsFileDlgn0100List(Dlgn0100SrhVO dlgn0100SrhVo) throws Exception;
    
    /**
     *  엑셀파일을 등록한다. (JXLS)
     * @param  hashmap
     * @throws Exception
     */
    Long updateXlsDlgn0100(List<Dlgn0110ExlVO> dlgn0110List, HttpServletRequest request) throws Exception;
    
    
    /**
     * 기본근무관리 양식 다운 시 근태 생성 리스트 조회
     * @param payr0100SrhVo
     * @return
     * @throws Exception
     */
    List  selectXlsUseDlgn0100List(Dlgn0100SrhVO dlgn0100SrhVo) throws Exception;
    
    
    
    
     
    
    
    
    // 구 업로드
    // ----------------------------------------------------------
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXlsDlgn0100(InputStream file) throws Exception;
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXlsDlgn0200(InputStream file) throws Exception;
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXSSFDlgn0100(InputStream file) throws Exception;
    
    /**
     *  엑셀파일을 등록한다.
     * @param  
     * @throws Exception
     */
    void insertXSSFDlgn0200(InputStream file) throws Exception;
    // ----------------------------------------------------------
    
    
    
    /**
     * DLGN0100을 수정한다.
     * @param vo - 수정할 정보가 담긴 Dlgn0100VO
     * @return void형
     * @exception Exception
     */
    void updateXlsDlgn0100(Dlgn0100VO vo) throws Exception;
    
    /**
     * DLGN0100을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Dlgn0100VO
     * @return void형 
     * @exception Exception
     */
    void deleteXlsDlgn0100(Dlgn0100VO vo) throws Exception;
    
    /**
     * DLGN0100을 조회한다.
     * @param vo - 조회할 정보가 담긴 Dlgn0100VO
     * @return 조회한 DLGN0100
     * @exception Exception
     */
    Dlgn0100VO selectXlsDlgn0100(Dlgn0100VO vo) throws Exception;
    
    
    /**
     * DLGN0200을 등록한다.
     * @param vo - 등록할 정보가 담긴 Dlgn0200VO
     * @return 등록 결과
     * @exception Exception
     */
    String insertXlsDlgn0200(Dlgn0200VO vo) throws Exception;
    
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
     * DLGN0200 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return DLGN0200 목록
     * @exception Exception
     */
    
}
