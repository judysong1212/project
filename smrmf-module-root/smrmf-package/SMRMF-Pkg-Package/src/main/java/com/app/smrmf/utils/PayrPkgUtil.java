/**
* <pre>
* 1. 프로젝트명 : SMRMF-Pkg-Utils-2.2.0
* 2. 패키지명(또는 디렉토리 경로) : com.app.smrmf.egov.comutils.payr
* 3. 파일명 : PayrPkgUtil.java
* 4. 작성일 : 2016. 12. 23. 오후 8:01:58
* 5. 작성자 : atres-pc
* 6. 설명 :
* </pre>
*/
package com.app.smrmf.utils;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0417VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0490VO;


/**
 * <pre>
 * 1. 패키지명 : com.app.smrmf.egov.comutils.payr
 * 2. 타입명 : PayrPkgUtil.java
 * 3. 작성일 : 2016. 12. 23. 오후 8:01:58
 * 4. 작성자 : atres-pc
 * 5. 설명 :
 * </pre>
 */
public class PayrPkgUtil {

	   /**
	    * 
	    * <pre>
	    * 1. 개요 : 급여 해당달에 계산 여부 체크  
	    * 2. 처리내용 : 스케줄관리의 작업년월과 지급공제항목에 월정보에 대해 체크가 되어 있는지 여부 판단 하여 결과값을 리턴 
	    * </pre>
	    * @Method Name : funcMonthCheck
	    * @date : 2016. 12. 23.
	    * @author : atres-pc
	    * @history : 
	    *	-----------------------------------------------------------------------
	    *	변경일				작성자						변경내용  
	    *	----------- ------------------- ---------------------------------------
	    *	2016. 12. 23.		atres-pc				최초 작성 
	    *	-----------------------------------------------------------------------
	    * 
	    * @return mnthChk 
	    */
	   public static boolean funcMonthCheck(InfcPkgPayr0250VO  payr0250Vo,InfcPkgPayr0410VO payr0410 ,InfcPkgPayr0490VO payr0490) {
		    
		      boolean mnthChk = false ;
		   
		      /**
               * 지급월여부 판단. 플래그  시작 
               */
              if (payr0250Vo.getJobYrMnth().substring(4,6).equals("01")) {
            	  
            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getJan()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getJan()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  }
              
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("02")) {
                  
            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getFeb()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getFeb()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  }
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("03")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getMar()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getMar()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  }
            	  
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("04")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getApr()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getApr()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  }
             
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("05")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getMay()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getMay()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  }
                 
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("06")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getJun()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getJun()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  }
                 
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("07")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getJul()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getJul()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  }
                 
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("08")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getAug()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getAug()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } 
                 
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("09")) {
 
            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getSep()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getSep()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } 
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("10")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getOct()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getOct()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } 
                 
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("11")) {

            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getNov()) ?  Boolean.TRUE: Boolean.FALSE) ; 
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getNov()) ?  Boolean.TRUE: Boolean.FALSE) ; 
            	  } 
            	  
              } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
            	  
            	  if (MSFSharedUtils.paramNotNull(payr0410)) {
            		  mnthChk  = ("Y".equals(payr0410.getDec()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } else {
            		  mnthChk  = ("Y".equals(payr0490.getDec()) ?  Boolean.TRUE: Boolean.FALSE) ;
            	  } 
            	  
              } else {
            	  
            	  mnthChk = false; 
              }
              
		      return mnthChk;
		   
	   }
	   
	   /**
	    * 
	    * <pre>
	    * 1. 개요 : 
	    * 2. 처리내용 : 
	    * </pre>
	    * @Method Name : funcMonth417Check
	    * @date : 2017. 5. 11.
	    * @author : paygen
	    * @history : 
	    *	-----------------------------------------------------------------------
	    *	변경일				작성자						변경내용  
	    *	----------- ------------------- ---------------------------------------
	    *	2017. 5. 11.		paygen				최초 작성 
	    *	-----------------------------------------------------------------------
	    * 
	    * @param payr0250Vo
	    * @param payr0410
	    * @param payr0490
	    * @return
	    */
	   public static boolean funcMonth417Check(InfcPkgPayr0250VO  payr0250Vo,InfcPkgPayr0417VO payr0417) {
		    
		      boolean mnthChk = false ;
		   
		      /**
            * 지급월여부 판단. 플래그  시작 
            */
           if (payr0250Vo.getJobYrMnth().substring(4,6).equals("01")) {
         	  
         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getJan()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  } 
           
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("02")) {
               
         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getFeb()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("03")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getMar()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
         	  
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("04")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getApr()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  } 
          
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("05")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getMay()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
              
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("06")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getJun()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  } 
              
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("07")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getJul()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
              
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("08")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getAug()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
              
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("09")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getSep()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("10")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getOct()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
              
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("11")) {

         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getNov()) ?  Boolean.TRUE: Boolean.FALSE) ; 
         	  }  
         	  
           } else  if (payr0250Vo.getJobYrMnth().substring(4,6).equals("12")) { 
         	  
         	  if (MSFSharedUtils.paramNotNull(payr0417)) {
         		  mnthChk  = ("Y".equals(payr0417.getDec()) ?  Boolean.TRUE: Boolean.FALSE) ;
         	  }  
         	  
           } else {
         	  
         	  mnthChk = false; 
           }
           
		      return mnthChk;
		   
	   }
	    
}
