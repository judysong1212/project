package com.app.smrmf.pkg.proc.payr.retroactivity.calculation;

import java.util.List;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;

/**
 * @Class Name : Payr0305Service.java
 * @Description : Payr0305 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RetroactivityCalculationService {
	
	/**
	 * PAYR0305을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0305VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPayr0305(InfcPkgPayr0305VO vo) throws Exception;
    
    /**
	 * PAYR0305을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0305VO
	 * @return void형
	 * @exception Exception
	 */
    void updatePayr0305(InfcPkgPayr0305VO vo) throws Exception;
    
    /**
	 * PAYR0305을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0305VO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePayr0305(InfcPkgPayr0305VO vo) throws Exception;
    
    /**
	 * PAYR0305을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0305VO
	 * @return 조회한 PAYR0305
	 * @exception Exception
	 */
    InfcPkgPayr0305VO selectPayr0305(InfcPkgPayr0305VO vo) throws Exception;
    
    /**
	 * PAYR0305 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0305 목록
	 * @exception Exception
	 */
    List selectPayr0305List(InfcPkgPayr0305SrhVO searchVO) throws Exception;
    
    /**
	 * PAYR0305 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0305 총 갯수
	 * @exception
	 */
    int selectPayr0305ListTotCnt(InfcPkgPayr0305SrhVO searchVO);
    
}
