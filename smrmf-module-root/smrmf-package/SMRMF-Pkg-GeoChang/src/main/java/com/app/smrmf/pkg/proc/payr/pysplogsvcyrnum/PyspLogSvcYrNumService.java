package com.app.smrmf.pkg.proc.payr.pysplogsvcyrnum;

import java.util.List;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0300SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0430SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0430VO;

/**
 * @Class Name : Payr0305Service.java
 * @Description : Payr0305 Business class
 *               단가표 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PyspLogSvcYrNumService {
	
    
  /**
   * PAYR0430을 등록한다.
   * @param vo - 등록할 정보가 담긴 Payr0430VO
   * @return 등록 결과
   * @exception Exception
   */
   String insertPayr0430(InfcPkgPayr0430VO vo)  throws Exception ;
    
    /**
   * PAYR0430을 수정한다.
   * @param vo - 수정할 정보가 담긴 Payr0430VO
   * @return void형
   * @exception Exception
   */
   void updatePayr0430(InfcPkgPayr0430VO vo) throws Exception ;
    
    /**
   * PAYR0430을 삭제한다.
   * @param vo - 삭제할 정보가 담긴 Payr0430VO
   * @return void형 
   * @exception Exception
   */
   void deletePayr0430(InfcPkgPayr0430VO vo) throws Exception ;
    
    /**
   * PAYR0430을 조회한다.
   * @param vo - 조회할 정보가 담긴 Payr0430VO
   * @return 조회한 PAYR0430
   * @exception Exception
   */
   InfcPkgPayr0430VO selectPayr0430(InfcPkgPayr0430VO vo) throws Exception ;
    
    /**
   * PAYR0430 목록을 조회한다.
   * @param searchVO - 조회할 정보가 담긴 VO
   * @return PAYR0430 목록
   * @exception Exception
   */
   List selectPayr0430List(InfcPkgPayr0430SrhVO searchVO) throws Exception ;
    
   
   
   /**
  * 근속년수 코드 정보리스트를 가지고 온다. 
  * @param searchVO - 조회할 정보가 담긴 VO
  * @return Bass0300 목록
  * @exception Exception
  */
  List selectBass0300List(InfcPkgBass0300SrhVO searchVO) throws Exception ;
   
  
    /**
   * PAYR0430 총 갯수를 조회한다.
   * @param searchVO - 조회할 정보가 담긴 VO
   * @return PAYR0430 총 갯수
   * @exception
   */
   int selectPayr0430ListTotCnt(InfcPkgPayr0430SrhVO searchVO);
    
    
    
}
