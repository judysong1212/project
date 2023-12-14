package com.app.smrmf.pkg.proc.payr.pay.calculation.service;

import java.util.List;

import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3100VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;

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
public interface PayCalculationService {
	

	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 김해시 모듈 적용  
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : selectJeonNamPayrInfoList
	  * @date : 2016. 5. 12.
	  * @author : Administrator
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 5. 12.		Administrator				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param searchVO
	  * @return
	  * @throws Exception
	  */
	 List<PkgPayrCommCalcVO> selectJeonNamPayrInfoList(InfcPkgPayr0250VO searchVO) throws Exception;
	 

	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : selectPsnlA20PayrInfoList
	  * @date : 2016. 12. 27.
	  * @author : atres-pc
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 12. 27.		atres-pc				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param searchVO
	  * @return
	  * @throws Exception
	  */
	 List<PkgPayrCommCalcVO> selectPsnlA20PayrInfoList(InfcPkgPayr0250VO searchVO) throws Exception;
	 
	  
	  /**
	   * 
	   * <pre>
	   * 1. 개요 : 
	   * 2. 처리내용 : 
	   * </pre>
	   * @Method Name : selectInsr0200Data
	   * @date : 2016. 12. 27.
	   * @author : atres-pc
	   * @history : 
	   *	-----------------------------------------------------------------------
	   *	변경일				작성자						변경내용  
	   *	----------- ------------------- ---------------------------------------
	   *	2016. 12. 27.		atres-pc				최초 작성 
	   *	-----------------------------------------------------------------------
	   * 
	   * @param infcInsr3100SrhVO
	   * @return
	   * @throws Exception
	   */
	 InfcPkgInsr3100VO selectInsr0200Data(InfcPkgInsr3100SrhVO  infcInsr3100SrhVO) throws Exception;
	    
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : seletYeta2000Data
	  * @date : 2016. 12. 27.
	  * @author : atres-pc
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 12. 27.		atres-pc				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param infcYeta2000SrhVO
	  * @return
	  * @throws Exception
	  */
   InfcPkgYeta2000VO seletYeta2000Data(InfcPkgYeta2000SrhVO  infcYeta2000SrhVO) throws Exception;
	 
   /**
    * 
    * <pre>
    * 1. 개요 : 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : updateYeta2000
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
   void updateYeta2000(InfcPkgYeta2000VO vo)  throws Exception;
   
   InfcPkgYe169010VO seletYeta2017ToPayrData(InfcPkgYe161010SrhVO    infcPkgYe161010SrhVo) throws Exception;

   
   void updateYeta2017ToYe161010(InfcPkgYe161010VO    infcPkgYe161010Vo)  throws Exception;
   
    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : selectPayr0300
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
     * @return
     * @throws Exception
     */
	  InfcPkgPayr0300VO selectPayr0300(InfcPkgPayr0300VO vo) throws Exception ;
	 
        
		/**
		 *  
		 * <pre>
		 * 1. 개요 :  김해시청 무기계약직 기말수당 값 가져오는 쿼리  
		 * 2. 처리내용 : 
		 * </pre>
		 * @Method Name : selectPayr0302C9020100
		 * @date : 2016. 6. 15.
		 * @author : Administrator
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	2016. 6. 15.		Administrator				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param vo
		 * @return
		 * @throws Exception
		 */
	  InfcPkgPayr0302VO selectGHPayr0302C9020100(InfcPkgPayr0302VO vo) throws Exception ;

		 List selectPayr0302ToPayr301CalcList(InfcPkgPayr0302VO voPayr0302) throws Exception;
		 /**
		   * 
		   * <pre>
		   * 1. 개요 : 수동작업에 따른데이타 처리  
		   * 2. 처리내용 : 
		   * </pre>
		   * @Method Name : selectPayr0302T0010100
		   * @date : 2017. 7. 20.
		   * @author : atres
		   * @history : 
		   *	-----------------------------------------------------------------------
		   *	변경일				작성자						변경내용  
		   *	----------- ------------------- ---------------------------------------
		   *	2017. 7. 20.		atres				최초 작성 
		   *	-----------------------------------------------------------------------
		   * 
		   * @param payr0305Vo
		   * @return
		   * @throws Exception
		   */
		  InfcPkgPayr0305VO selectPayr0302T0010100(InfcPkgPayr0305VO  payr0305Vo) throws Exception ;  	  
}
