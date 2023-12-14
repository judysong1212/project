package com.app.smrmf.pkg.yeta.yeta2021.tax.service;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3210VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3900SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3900VO;

/**
 * @Class Name : Yeta3900Service.java
 * @Description : Yeta3900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta21Payr7440Service {
	
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 연말정산 마감테이블 신규생성 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : fnPayr06420_PAYR420_2014_CREATE_Insert
	  * @date : Jan 19, 2016
	  * @author : leeheuisung
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	Jan 19, 2016		leeheuisung				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param vo
	  * @return
	  * @throws Exception
	  */
    String fnPayr06420_PAYR420_2014_CREATE_Insert(InfcPkgYeta1000VO  vo) throws Exception;
     
    
    /**
	  * 
	  * <pre>
	  * 1. 개요 : 연말정산 급여내역생성 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : fnPayr06420_PAYR417_2014_CREATE_Insert
	  * @date : Jan 19, 2016
	  * @author : leeheuisung
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	Jan 19, 2016		leeheuisung				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param vo
	  * @return
	  * @throws Exception
	  */
   String fnPayr06420_PAYR417_2014_CREATE_Insert(InfcPkgYeta3210VO infcPkgYeta3210Vo) throws Exception;
    
   
   /**
    * 
    * <pre>
    * 1. 개요 : 연말정산 기본 정보 생성  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06420_PAYR415_2014_CREATE_Insert
    * @date : Jan 21, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 21, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   String fnPayr06420_PAYR415_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception;
   
   /**
    * 
    * <pre>
    * 1. 개요 : 연말정산 기본 비과세 감면 생성  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06420_PAYR415_2014_CREATE_Insert
    * @date : Jan 21, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 21, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   String fnPayr06420_YETA3200_2015_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception;
   
   /**
    * 
    * <pre>
    * 1. 개요 : 연말정산 대상자 생성 가족사항 추가 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06430_PAYR410_2014_CREATE_Insert
    * @date : Jan 21, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 21, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   String fnPayr06430_PAYR410_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception;  
   
   
   /**
    * 
    * <pre>
    * 1. 개요 : 가족사항 업데이트 410 고용/건강보험료외 업데이트
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06430_PAYR410_2014_INSU_FETC_Update
    * @date : Jan 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   void fnPayr06430_PAYR410_2014_INSU_FETC_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception;  
   
   
   /**
    * 
    * <pre>
    * 1. 개요 : 부녀자공제란 여성근로소득자 본인인경우 업데이트 처리
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06430_PAYR410_2014_CREATE_Update
    * @date : Jan 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   void fnPayr06430_PAYR410_2014_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception; 
   
   /**
    * 
    * <pre>
    * 1. 개요 : 이월기부금  443 인서트
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06430_PAYR443_2014_CREATE_Insert
    * @date : Jan 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   String fnPayr06430_PAYR443_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception; 
    
   /**
    * 
    * <pre>
    * 1. 개요 : 연말정산상세  [7]
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06430_PAYR425_2014_CREATE_Insert
    * @date : Jan 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   String fnPayr06430_PAYR425_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception; 
   
   
   
   /**
  	 * YETA3900을 조회한다.
  	 * @param vo - 조회할 정보가 담긴 Yeta3900VO
  	 * @return 조회한 YETA3900
  	 * @exception Exception
  	 */
   InfcPkgYeta1000VO selectYeta0100ToCreateYetaPrc1000(InfcPkgYeta1000VO  vo) throws Exception;
      
    
   
    
    /**
	 * YETA3900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertYeta3900(InfcPkgYeta3900VO vo) throws Exception;
     
    
    /**
	 * YETA3900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
	 * @return void형
	 * @exception Exception
	 */
    void updateYeta3900(InfcPkgYeta3900VO vo) throws Exception;
    
    /**
	 * YETA3900을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3900VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteYeta3900(InfcPkgYeta3900VO vo) throws Exception;
    
    /**
	 * YETA3900을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3900VO
	 * @return 조회한 YETA3900
	 * @exception Exception
	 */
    InfcPkgYeta3900VO selectYeta3900(InfcPkgYeta3900VO vo) throws Exception;
    
    /**
	 * YETA3900 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return YETA3900 목록
	 * @exception Exception
	 */
    List selectYeta3900List(InfcPkgYeta3900SrhVO searchVO) throws Exception;
    
    /**
	 * YETA3900 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return YETA3900 총 갯수
	 * @exception
	 */
    int selectYeta3900ListTotCnt(InfcPkgYeta3900SrhVO searchVO);
    
}
