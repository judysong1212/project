package com.app.smrmf.pkg.proc.remt.retirement.payr;

import java.util.List;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200VO;

/**
 * 
 * @Class Name : RetirementPayrService.java
 * @Description : RetirementPayrService Business class
 *                퇴직금계산을 위한 인터페이스 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RetirementPayrService {
	
	 /**
		 * 퇴직금산정 테이블에 값을 넣기위해 데이터를 조회한다.
		 * @param vo - 조회할 정보가 담긴 Remt2000VO
		 * @return 조회한 REMT2000
		 * @exception Exception
		 */
	RemtPsnl0100VO selectRemt0100ToPsnl0100(RemtPsnl0100SrhVO vo) throws Exception;
	    
	RemtLogSvcDysVO selectLogSvcDys(RemtLogSvcDysVO vo) throws Exception;
	
	Remt0100DlgnVO selectRemt0100Dlgn(Remt0100DlgnVO remt0100DlgnVo) throws Exception;
	  
	
	List selectDateTermList(InfcPkgRemt2000VO infcRemt2000Vo) throws Exception;
	
	List selectRemt0100ToPayr0302List(RemtPayr0302SrhVO  remtPayr0302SrhVo) throws Exception;
	
	 
	List<InfcPkgPayr0410VO> selectRemt0100ToPayr4100List(  InfcPkgRemt2000SrhVO infcRemt2000SrhVo) throws Exception;
	
	List<RemtWfep0100VO> selectRemtWfep0100List(  RemtPayr0302SrhVO  remtPayr0302SrhVo) throws Exception;
	
	 
	 
	/**
	 * REMT2000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRemt2000(InfcPkgRemt2000VO vo) throws Exception;
    
    /**
	 * REMT2000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2000VO
	 * @return void형
	 * @exception Exception
	 */
    void updateRemt2000(InfcPkgRemt2000VO vo) throws Exception;
    
    /**
	 * REMT2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2000VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRemt2000(InfcPkgRemt2000VO vo) throws Exception;
    
    /**
	 * REMT2000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2000VO
	 * @return 조회한 REMT2000
	 * @exception Exception
	 */
    InfcPkgRemt2000VO selectRemt2000(InfcPkgRemt2000VO vo) throws Exception;
    
    /**
	 * REMT2000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2000 목록
	 * @exception Exception
	 */
    List selectRemt2000List(InfcPkgRemt2000SrhVO searchVO) throws Exception;
    
    /**
	 * REMT2000 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2000 총 갯수
	 * @exception
	 */
    int selectRemt2000ListTotCnt(InfcPkgRemt2000SrhVO searchVO);
    
    
    /**
	 * REMT2100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRemt2100(InfcPkgRemt2100VO vo) throws Exception;
    
    /**
	 * REMT2100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2100VO
	 * @return void형
	 * @exception Exception
	 */
    void updateRemt2100(InfcPkgRemt2100VO vo) throws Exception;
    
    /**
	 * REMT2100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2100VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRemt2100(InfcPkgRemt2100VO vo) throws Exception;
    
    void deleteRemt0100CalcRemt2100(InfcPkgRemt2100VO vo) throws Exception;
    
    /**
	 * REMT2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2100VO
	 * @return 조회한 REMT2100
	 * @exception Exception
	 */
    InfcPkgRemt2100VO selectRemt2100(InfcPkgRemt2100VO vo) throws Exception;
    
    /**
	 * REMT2100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2100 목록
	 * @exception Exception
	 */
    List selectRemt2100List(InfcPkgRemt2100SrhVO searchVO) throws Exception;
    
    /**
	 * REMT2100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2100 총 갯수
	 * @exception
	 */
    int selectRemt2100ListTotCnt(InfcPkgRemt2100SrhVO searchVO);
    

	/**
	 * REMT2200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRemt2200(InfcPkgRemt2200VO vo) throws Exception;
    
    /**
	 * REMT2200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2200VO
	 * @return void형
	 * @exception Exception
	 */
    void updateRemt2200(InfcPkgRemt2200VO vo) throws Exception;
    
    /**
	 * REMT2200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2200VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRemt2200(InfcPkgRemt2200VO vo) throws Exception;
    
    void deleteRemt0100CalcRemt2200(InfcPkgRemt2200VO vo) throws Exception;
    
    
    /**
	 * REMT2200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2200VO
	 * @return 조회한 REMT2200
	 * @exception Exception
	 */
    InfcPkgRemt2200VO selectRemt2200(InfcPkgRemt2200VO vo) throws Exception;
    
    /**
	 * REMT2200 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2200 목록
	 * @exception Exception
	 */
    List selectRemt2200List(InfcPkgRemt2200SrhVO searchVO) throws Exception;
    
    /**
	 * REMT2200 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2200 총 갯수
	 * @exception
	 */
    int selectRemt2200ListTotCnt(InfcPkgRemt2200SrhVO searchVO);
    
    /**
	 * REMT2300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRemt2300(InfcPkgRemt2300VO vo) throws Exception;
    
    
    
    
    /**
	 * REMT2300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2300VO
	 * @return void형
	 * @exception Exception
	 */
    void updateRemt2300(InfcPkgRemt2300VO vo) throws Exception;
    
    void updateRemt3100ToRemt2300Data(InfcPkgRemt2300VO vo) throws Exception;
     
    
    /**
	 * REMT2300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2300VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRemt2300(InfcPkgRemt2300VO vo) throws Exception;
    
    /**
	 * REMT2300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2300VO
	 * @return 조회한 REMT2300
	 * @exception Exception
	 */
    InfcPkgRemt2300VO selectRemt2300(InfcPkgRemt2300VO vo) throws Exception;
    
    /**
	 * REMT2300 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2300 목록
	 * @exception Exception
	 */
    List selectRemt2300List(InfcPkgRemt2300SrhVO searchVO) throws Exception;
    
    /**
	 * REMT2300 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2300 총 갯수
	 * @exception
	 */
    int selectRemt2300ListTotCnt(InfcPkgRemt2300SrhVO searchVO);
    
    /**
	 * REMT3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRemt3000(InfcPkgRemt3000VO vo) throws Exception;
    
    /**
	 * REMT3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3000VO
	 * @return void형
	 * @exception Exception
	 */
    void updateRemt3000(InfcPkgRemt3000VO vo) throws Exception;
    
    /**
	 * REMT3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3000VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRemt3000(InfcPkgRemt3000VO vo) throws Exception;
    
    /**
	 * REMT3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3000VO
	 * @return 조회한 REMT3000
	 * @exception Exception
	 */
    InfcPkgRemt3000VO selectRemt3000(InfcPkgRemt3000VO vo) throws Exception;
    
    /**
	 * REMT3000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3000 목록
	 * @exception Exception
	 */
    List selectRemt3000List(InfcPkgRemt3000SrhVO searchVO) throws Exception;
    
    /**
	 * REMT3000 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3000 총 갯수
	 * @exception
	 */
    int selectRemt3000ListTotCnt(InfcPkgRemt3000SrhVO searchVO);
    
    /**
	 * REMT3100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRemt3100(InfcPkgRemt3100VO vo) throws Exception;
    
    
    
    /**
	 * REMT3100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3100VO
	 * @return void형
	 * @exception Exception
	 */
    void updateRemt3100(InfcPkgRemt3100VO vo) throws Exception;

    void updateRemt3100Remt2000Data(InfcPkgRemt3100VO vo) throws Exception;
    
    /**
	 * REMT3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3100VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRemt3100(InfcPkgRemt3100VO vo) throws Exception;
    
    /**
	 * REMT3100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3100VO
	 * @return 조회한 REMT3100
	 * @exception Exception
	 */
    InfcPkgRemt3100VO selectRemt3100(InfcPkgRemt3100VO vo) throws Exception;
    
    /**
	 * REMT3100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3100 목록
	 * @exception Exception
	 */
    List selectRemt3100List(InfcPkgRemt3100SrhVO searchVO) throws Exception;
    
    /**
	 * REMT3100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3100 총 갯수
	 * @exception
	 */
    int selectRemt3100ListTotCnt(InfcPkgRemt3100SrhVO searchVO);
    
    /**
	 * REMT3200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRemt3200(InfcPkgRemt3200VO vo) throws Exception;
    
    /**
	 * REMT3200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3200VO
	 * @return void형
	 * @exception Exception
	 */
    void updateRemt3200(InfcPkgRemt3200VO vo) throws Exception;
    
    /**
	 * REMT3200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3200VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRemt3200(InfcPkgRemt3200VO vo) throws Exception;
    
    /**
	 * REMT3200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3200VO
	 * @return 조회한 REMT3200
	 * @exception Exception
	 */
    InfcPkgRemt3200VO selectRemt3200(InfcPkgRemt3200VO vo) throws Exception;
    
    /**
	 * REMT3200 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3200 목록
	 * @exception Exception
	 */
    List selectRemt3200List(InfcPkgRemt3200SrhVO searchVO) throws Exception;
    
    /**
	 * REMT3200 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3200 총 갯수
	 * @exception
	 */
    int selectRemt3200ListTotCnt(InfcPkgRemt3200SrhVO searchVO);
    
    int selectMarTotAmntDays(InfcPkgRemt2100SrhVO infcRemt2100SrhVo);
     
    
    
    
}
