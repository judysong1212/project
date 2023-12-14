package com.app.smrmf.pkg.payr.payrcalc.service;

import java.util.List;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0200SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0307VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0309VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0450VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540VO;

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
public interface PayrCommCalcService {
	
	 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : deletePayr0302ToPayr0307T
	 * @date : 2016. 12. 13.
	 * @author : atres-pc
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 12. 13.		atres-pc				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param vo
	 * @throws Exception
	 */
	 void deletePayr0302ToPayr0307T(InfcPkgPayr0302VO vo) throws Exception;
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : insertPayr0302
	  * @date : 2016. 12. 13.
	  * @author : atres-pc
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 12. 13.		atres-pc				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param vo
	  * @return
	  * @throws Exception
	  */
	 String insertPayr0302(InfcPkgPayr0302VO vo) throws Exception;
	    
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 4대보험 예외처리 데이타 가져오기 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : getSelectPkgPayr0540List
	  * @date : 2016. 12. 24.
	  * @author : atres-pc
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 12. 24.		atres-pc				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param payr0540SrhVo
	  * @return
	  * @throws Exception
	  */
	 List selectPkgPayr0540List(InfcPkgPayr0540SrhVO payr0540SrhVo ) throws Exception;   
		   
	  /**
	 * PAYR0540을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0540VO
	 * @return 조회한 PAYR0540
	 * @exception Exception
	 */
	 InfcPkgPayr0540VO selectPayr0540(InfcPkgPayr0540VO vo) throws Exception;
	  
	  
	  
	  /**
	 * PAYR0540 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0540 총 갯수
	 * @exception
	 */
	 int selectPayr0540ListTotCnt(InfcPkgPayr0540SrhVO searchVO);
	 
	 
     /***
      * 
      * <pre>
      * 1. 개요 : 
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : deletePayr0302Payr0307
      * @date : 2016. 12. 27.
      * @author : atres-pc
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2016. 12. 27.		atres-pc				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param vo
      * @throws Exception
      */
	 void deletePayr0302Payr0307(InfcPkgPayr0302VO vo) throws Exception;
	 
	 
	 
	  /**
		 * PAYR0300을 등록한다.
		 * @param vo - 등록할 정보가 담긴 Payr0300VO
		 * @return 등록 결과
		 * @exception Exception
		 */
		 String insertPayr0300(InfcPkgPayr0300VO vo) throws Exception;
	    
	    /**
		 * PAYR0300을 수정한다.
		 * @param vo - 수정할 정보가 담긴 Payr0300VO
		 * @return void형
		 * @exception Exception
		 */
		 void updatePayr0300(InfcPkgPayr0300VO vo) throws Exception;
		 
 
	    /**
		 * PAYR0300을 삭제한다.
		 * @param vo - 삭제할 정보가 담긴 Payr0300VO
		 * @return void형 
		 * @exception Exception
		 */
		 void deletePayr0300(InfcPkgPayr0300VO vo) throws Exception;
		  
		  
	 
		/**
	 * PAYR0301을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0301VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	 String insertPayr0301(InfcPkgPayr0301VO vo)  throws Exception;
   
   /**
	 * PAYR0301을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0301VO
	 * @return void형
	 * @exception Exception
	 */
	 void updatePayr0301(InfcPkgPayr0301VO vo)  throws Exception;
   
	 void updatePayr0301ToPayr0307(InfcPkgPayr0301VO vo)  throws Exception; 
	 
   /**
	 * PAYR0301을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0301VO
	 * @return void형 
	 * @exception Exception
	 */
	 void deletePayr0301(InfcPkgPayr0301VO vo)  throws Exception; 
	 
 
	    /**
		 * PAYR0302을 수정한다.
		 * @param vo - 수정할 정보가 담긴 Payr0302VO
		 * @return void형
		 * @exception Exception
		 */
		  void updatePayr0302(InfcPkgPayr0302VO vo) throws Exception;
	    
	    /**
		 * PAYR0302을 삭제한다.
		 * @param vo - 삭제할 정보가 담긴 Payr0302VO
		 * @return void형 
		 * @exception Exception
		 */
		  void deletePayr0302(InfcPkgPayr0302VO vo) throws Exception;
		/**
		 * PAYR0304을 등록한다.
		 * @param vo - 등록할 정보가 담긴 Payr0304VO
		 * @return 등록 결과
		 * @exception Exception
		 */
		  String insertPayr0304(InfcPkgPayr0304VO vo) throws Exception;
	    
	    /**
		 * PAYR0304을 수정한다.
		 * @param vo - 수정할 정보가 담긴 Payr0304VO
		 * @return void형
		 * @exception Exception
		 */
		 void updatePayr0304(InfcPkgPayr0304VO vo) throws Exception;
	    
	    /**
		 * PAYR0304을 삭제한다.
		 * @param vo - 삭제할 정보가 담긴 Payr0304VO
		 * @return void형 
		 * @exception Exception
		 */
		 void deletePayr0304(InfcPkgPayr0304VO vo) throws Exception;
	    	  
		 
		/**
		 * PAYR0306을 등록한다.
		 * @param vo - 등록할 정보가 담긴 Payr0306VO
		 * @return 등록 결과
		 * @exception Exception
		 */
		 String insertPayr0306(InfcPkgPayr0306VO vo) throws Exception;
	    
	    /**
		 * PAYR0306을 수정한다.
		 * @param vo - 수정할 정보가 담긴 Payr0306VO
		 * @return void형
		 * @exception Exception
		 */
		  void updatePayr0306(InfcPkgPayr0306VO vo) throws Exception;
	    
	    /**
		 * PAYR0306을 삭제한다.
		 * @param vo - 삭제할 정보가 담긴 Payr0306VO
		 * @return void형 
		 * @exception Exception
		 */
		 void deletePayr0306(InfcPkgPayr0306VO vo) throws Exception;
		 
	   /**
	   * PAYR0460을 등록한다.
	   * @param vo - 등록할 정보가 담긴 Payr0460VO
	   * @return 등록 결과
	   * @exception Exception
	   */
	    String insertPayr0460(InfcPkgPayr0460VO vo) throws Exception;
	    
	    /**
	   * PAYR0460을 수정한다.
	   * @param vo - 수정할 정보가 담긴 Payr0460VO
	   * @return void형
	   * @exception Exception
	   */
	    void updatePayr0460(InfcPkgPayr0460VO vo) throws Exception;
	    
	    /**
	   * PAYR0460을 삭제한다.
	   * @param vo - 삭제할 정보가 담긴 Payr0460VO
	   * @return void형 
	   * @exception Exception
	   */
	    void deletePayr0460(InfcPkgPayr0460VO vo) throws Exception;
	    
	    /**
	   * PAYR0460을 조회한다.
	   * @param vo - 조회할 정보가 담긴 Payr0460VO
	   * @return 조회한 PAYR0460
	   * @exception Exception
	   */
	    InfcPkgPayr0460VO selectPayr0460(InfcPkgPayr0460VO vo) throws Exception;
	    
	    /**
	   * PAYR0460 목록을 조회한다.
	   * @param searchVO - 조회할 정보가 담긴 VO
	   * @return PAYR0460 목록
	   * @exception Exception
	   */
	    List selectPayr0460List(InfcPkgPayr0460SrhVO searchVO) throws Exception;
	    
	    /**
	   * PAYR0460 총 갯수를 조회한다.
	   * @param searchVO - 조회할 정보가 담긴 VO
	   * @return PAYR0460 총 갯수
	   * @exception
	   */
	  public int selectPayr0460ListTotCnt(InfcPkgPayr0460SrhVO searchVO) ;
		     
   /**
  * PAYR0304을 조회한다.
  * @param vo - 조회할 정보가 담긴 Payr0304VO
  * @return 조회한 PAYR0304
  * @exception Exception
  */
   InfcPkgPayr0304VO selectPayr0304(InfcPkgPayr0304VO vo)  throws Exception;
   
   /**
  * PAYR0304 목록을 조회한다.
  * @param searchVO - 조회할 정보가 담긴 VO
  * @return PAYR0304 목록
  * @exception Exception
  */
   List selectPayr0304List(InfcPkgPayr0304SrhVO searchVO) throws Exception;
   
   /**
  * PAYR0304 총 갯수를 조회한다.
  * @param searchVO - 조회할 정보가 담긴 VO
  * @return PAYR0304 총 갯수
  * @exception
  */
   int selectPayr0304ListTotCnt(InfcPkgPayr0304SrhVO searchVO);
   
  

/**
* PAYR0306을 조회한다.
* @param vo - 조회할 정보가 담긴 Payr0306VO
* @return 조회한 PAYR0306
* @exception Exception
*/
InfcPkgPayr0306VO selectPayr0306(InfcPkgPayr0306VO vo) throws Exception;

/**
* PAYR0306 목록을 조회한다.
* @param searchVO - 조회할 정보가 담긴 VO
* @return PAYR0306 목록
* @exception Exception
*/
List selectPayr0306List(InfcPkgPayr0306SrhVO searchVO)throws Exception;

/**
* PAYR0306 총 갯수를 조회한다.
* @param searchVO - 조회할 정보가 담긴 VO
* @return PAYR0306 총 갯수
* @exception
*/
int selectPayr0306ListTotCnt(InfcPkgPayr0306SrhVO searchVO);
 

InfcPkgPayr0309VO selectPayr0309(InfcPkgPayr0309VO vo) throws Exception;

/**
* Payr0309VO을 등록한다.
* @param vo - 등록할 정보가 담긴 Payr0309VO
* @return 등록 결과
* @exception Exception
*/
String insertPayr0309(InfcPkgPayr0309VO vo) throws Exception;

/**
* Payr0309VO을 수정한다.
* @param vo - 수정할 정보가 담긴 Payr0309VO
* @return void형
* @exception Exception
*/
void updatePayr0309(InfcPkgPayr0309VO vo) throws Exception;
 

	/**
	* 이전달 추가 소득세 세율코드 데이터를 조회한다. PAYR0304을 조회한다.
	* @param vo - 조회할 정보가 담긴 Payr0304VO
	* @return 조회한 PAYR0304
	* @exception Exception
	*/
	InfcPkgPayr0304VO selectPayr0304ToAddIncmTx(InfcPkgPayr0304VO vo)  throws Exception;
	

	 /**
	  * Payr0500VO을 수정한다.
	  * @param vo - 수정할 정보가 담긴 Payr0500VO
	  * @return void형
	  * @exception Exception
	  */
	  void updatePayr0500TotAddIncmTx(InfcPkgPayr0500VO vo) throws Exception;
	  
	  /**
		 * PAYR0200 목록을 조회한다.
		 * @param searchVO - 조회할 정보가 담긴 VO
		 * @return PAYR0200 목록
		 * @exception Exception
		 */
		 List selectPayr0200ToPayrCalcList(InfcPkgPayr0200SrhVO searchVO) throws Exception;
	 
		 List selectPayr0520ToPayrCalcList(InfcPkgPayr0520SrhVO searchVO) throws Exception;
		  
		 
		 
		 List<InfcPkgPayr0307VO> selectPayr0307All(InfcPkgPayr0307VO vo) throws Exception;
		 
		 void deletePayCalculationPayr0307(InfcPkgPayr0307VO vo) throws Exception;	    
	     
		 /**
		   * 
		   * <pre>
		   * 1. 개요 : 근속가산금, 정근수당처리 
		   * 2. 처리내용 : 
		   * </pre>
		   * @Method Name : selectPayr0450
		   * @date : 2016. 12. 2.
		   * @author : cyberlhs
		   * @history : 
		   *	-----------------------------------------------------------------------
		   *	변경일				작성자						변경내용  
		   *	----------- ------------------- ---------------------------------------
		   *	2016. 12. 2.		cyberlhs				최초 작성 
		   *	-----------------------------------------------------------------------
		   * 
		   * @param vo
		   * @return
		   * @throws Exception
		   */
	 	  InfcPkgPayr0450VO selectPayr0450(InfcPkgPayr0450VO vo) throws Exception;
	 	  
	 	 /**
		   * 
		   * <pre>
		   * 1. 개요 : 정근수당 
		   * 2. 처리내용 : 
		   * </pre>
		   * @Method Name : selectPayr0450ToC9030100
		   * @date : 2016. 12. 2.
		   * @author : cyberlhs
		   * @history : 
		   *	-----------------------------------------------------------------------
		   *	변경일				작성자						변경내용  
		   *	----------- ------------------- ---------------------------------------
		   *	2016. 12. 2.		cyberlhs				최초 작성 
		   *	-----------------------------------------------------------------------
		   * 
		   * @param vo
		   * @return
		   * @throws Exception
		   */
	 	  InfcPkgPayr0450VO selectPayr0450ToC9030100(InfcPkgPayr0450VO vo) throws Exception;
	 	  
	 	  /**
	 	   * 
	 	   * <pre>
	 	   * 1. 개요 : 근속가산금 
	 	   * 2. 처리내용 : 
	 	   * </pre>
	 	   * @Method Name : selectPayr0450ToC9010100
	 	   * @date : 2017. 5. 19.
	 	   * @author : atres
	 	   * @history : 
	 	   *	-----------------------------------------------------------------------
	 	   *	변경일				작성자						변경내용  
	 	   *	----------- ------------------- ---------------------------------------
	 	   *	2017. 5. 19.		atres				최초 작성 
	 	   *	-----------------------------------------------------------------------
	 	   * 
	 	   * @param vo
	 	   * @return
	 	   * @throws Exception
	 	   */
	 	 InfcPkgPayr0450VO selectPayr0450ToC9010100(InfcPkgPayr0450VO vo) throws Exception;
	 	 
	 	InfcPkgPayr0450VO selectPayr0450ToC9010400(InfcPkgPayr0450VO vo) throws Exception; 
	 	

		 InfcPkgPayr0410VO selectPayr0410ToPayrCalcList(InfcPkgPayr0410VO searchVO) throws Exception;
		 
		 void updatePayr0302ToPayr0305(InfcPkgPayr0305VO  inPayr0305Vo) throws Exception;
		 
		 
}
