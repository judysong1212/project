package com.app.smrmf.pkg.proc.remt.retirement.calculation;

import java.util.List;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200VO;

/**
 * 
 * @Class Name : RetirementCalculstionService.java
 * @Description : RetirementCalculstionService Business class
 *                퇴직정산을 계산하여 저장하는 인터페이스 함수 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RetirementCalculstionService {
	
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
    
    InfcPkgRemt3100VO selectRemt3100EepnYrIcm(InfcPkgRemt3100VO vo) throws Exception;
    
    
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
	
    InfcPkgBass0100VO selectBass0100(InfcPkgBass0100VO vo) throws Exception;
    
}
