/**
 *암호화 처리 공통 모듈 
 */
package com.app.smrmf.core.msfmainapp.server.utils;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.link.xecuredb.service.XecureNative;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.smrmf.core.msfmainapp.server.utils
* 2. 타입명 : MSFCryptUtils.java
* 3. 작성일 : 2016. 8. 8. 오후 5:16:01
* 4. 작성자 : Administrator
* 5. 설명 :
* </pre>
 */
public class AnyCryptUtils {
 	
	 private static final Logger logger = LoggerFactory.getLogger(AnyCryptUtils.class);
	 
	 
	 public static String SEC_RRNUMC	= "SEC_RRNUMC";   // 주민번호 7자리 이후 자릿수에 맞추어 암호화 /복호화 
	 public static String SEC_RRNUM  	= "SEC_RRNUM";                //주민번호 7자리 이후 암호화 / 복호화 
	 public static String SEC_BNKANUM   = "SEC_BNKANUM";       //계좌번호 
	    
	 public static String SEC_GECRYPT   = "SEC_GECRYPT";       // 통합기본암호화 
	 public static String SEC_PSSWD     = "SEC_PSSWD";        //패스워드 암호화 
	 
	 // 암복호화 구분 
	 public static String SEC_CRYPT_ENC_TYPE	= "ENC";   // 암호화  
	 public static String SEC_CRYPT_DEC_TYPE	= "DEC";   // 복호화  
	 
	 //출력형태구분
	 public static String SEC_DEC_FULL	= "SECDECFULL";   // 전체 복호화 보여주기 
	 public static String SEC_ENC_D07	= "SECENCD07";   // 암호화 특정자리수 이후 부터 별표나 0으로 표시 
	 public static String SEC_ENC_FULL	= "SECENCFULL";   // 전체암호화해서보여주기 (암호화표시)
	    
	    
	 private static XecureNative xnCrypt ;
	   
	    
     /**
      * 
      * <pre>
      * 1. 개요 :  암호화 객체 생성 및 초기화 처리를 위한 루틴 생성  
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : XecureCryptInitialize
      * @date : 2016. 8. 8.
      * @author : Administrator
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2016. 8. 8.		Administrator				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param servletCfg
      * @param request
      * @throws Exception
      */
	 public static String XecureCryptInitialize(ServletConfig servletCfg,HttpServletRequest request)   {      
	 
		   String rtnResult = "-1";
		  try {
				//사용시 반드시 초기화 선언 추가 
			    xnCrypt = XecureNative.getInstance();    
			    xnCrypt.XecureInitNative(servletCfg,request); 
			    
			    if (SmrmfUtils.paramNotNull(xnCrypt)) {
			    	rtnResult = "200";	
			    }
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}	  
		   
		  return rtnResult;
	} 
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 암호화 처리 
	  * 2. 처리내용 : 
	  * SEC_RRNUMC :  주민번호 7자리 이후 자릿수에 맞추어 암호화 /복호화 
	  * SEC_RRNUM  : 주민번호 7자리 이후 암호화 / 복호화 
	  * SEC_BNKANUM: 계좌번호 암호화 /복호화  
	  * SEC_GECRYPT:통합기본암호화/복호화  
	  * SEC_PSSWD  : 패스워드 암호화  단방향 (사용안함.주의)
	  * 
	  * 
	  * </pre>
	  * @Method Name : getEncSyncCrypt
	  * @date : 2016. 8. 9.
	  * @author : Administrator
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 8. 9.		Administrator				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param secSource 암호화 할 대상 
	  * @param secColumn 암호화 방법 타입
	  * @return
	  * @throws Exception
	  */
	 public static  String getEncSyncCrypt(String nResult,String secSource,String secColumn)   {      
		   
		   String rtnNoHoldSyncCrypt = "";
		  try {
			 
			  rtnNoHoldSyncCrypt = getALLSyncCrypt(secSource,secColumn,SEC_CRYPT_ENC_TYPE,"", "") ;
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return rtnNoHoldSyncCrypt = secSource;
			}	
		  
		   return rtnNoHoldSyncCrypt;
		   
		  
	}
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 복호화   
	  * 2. 처리내용 : 
	  * SEC_RRNUMC :  주민번호 7자리 이후 자릿수에 맞추어 암호화 /복호화 
	  * SEC_RRNUM  : 주민번호 7자리 이후 암호화 / 복호화 
	  * SEC_BNKANUM: 계좌번호 암호화 /복호화  
	  * SEC_GECRYPT:통합기본암호화/복호화  
	  * SEC_PSSWD  : 패스워드 암호화  단방향 (사용안함.주의)
	  * </pre>  
	  * @Method Name : getDecSyncCrypt
	  * @date : 2016. 8. 9.
	  * @author : Administrator
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 8. 9.		Administrator				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param secSource 암호화 할 대상 
	  * @param secColumn 암호화 방법 타입
	  * @return
	  * @throws Exception
	  */
	 public static  String getDecSyncCrypt(String nResult,String secSource,String secColumn)   {      
		   
		   String rtnNoHoldSyncCrypt = "";
		  try {
			 
			  rtnNoHoldSyncCrypt = getALLSyncCrypt(secSource,secColumn,SEC_CRYPT_DEC_TYPE,"", "") ;
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return rtnNoHoldSyncCrypt = secSource;
			}	
		  
		   return rtnNoHoldSyncCrypt;
		   
		  
	}

	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 암호화/복호화 전체를 처리하는 메서드 
	  * 2. 처리내용 : 
	  * SEC_RRNUMC :  주민번호 7자리 이후 자릿수에 맞추어 암호화 /복호화 
	  * SEC_RRNUM  : 주민번호 7자리 이후 암호화 / 복호화 
	  * SEC_BNKANUM: 계좌번호 암호화 /복호화  
	  * SEC_GECRYPT:통합기본암호화/복호화  
	  * SEC_PSSWD  : 패스워드 암호화  단방향 (사용안함.주의)
	  * 
	  * 화면 출력 타입 
	  *  SEC_DEC_FULL : 전체 복호화 보여주기 
	  *  SEC_ENC_D07  : 암호화 특정자리수 이후 부터 별표나 0으로 표시 
	  *  SEC_ENC_FULL : 전체암호화해서보여주기 (암호화표시)
	  * </pre>
	  * @Method Name : getALLSyncCrypt
	  * @date : 2016. 8. 9.
	  * @author : Administrator
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 8. 9.		Administrator				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param secSource 암호화 할 대상 
	  * @param secColumn 암호화 방법 타입
	  * @param secSyncType 암/복호화 타입
	  * @param secPrintType 화면 출력 타입
	  * @param placeHolder  암호화 부분 출력 옵션    "*"/"0" 두가지경우 존재  
	  * @return
	  * @throws Exception
	  */
	 private static  String getALLSyncCrypt(String secSource,String secColumn,String secSyncType,String secPrintType, String placeHolder) throws Exception  {      
		    
		  String rtnSyncCrypt = "";
		  try {
			 
			  if (secSyncType.equals(SEC_CRYPT_ENC_TYPE)) {
				  //암호화 
				  rtnSyncCrypt = getSyncEncCrypt(secSource,secColumn); 
				  
			  } else if (secSyncType.equals(SEC_CRYPT_DEC_TYPE)) {
				  //복호화 
				  rtnSyncCrypt = getSyncDecCrypt(secSource,secColumn,secPrintType,placeHolder);
			  } else {
				  rtnSyncCrypt = secSource;
				 // throw new MSFOperationException();  
				  
			  } 
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return   rtnSyncCrypt = secSource;
			}	
		  
		   return rtnSyncCrypt;
		   
		  
	}
	 
	 
    /**
     * 
     * <pre>
     * 1. 개요 : 암/복호화 타입을 기준으로 암복호화 함. 출력화면 마스킹 기능 제외 
     * 2. 처리내용 : 
     * SEC_RRNUMC :  주민번호 7자리 이후 자릿수에 맞추어 암호화 /복호화 
	  * SEC_RRNUM  : 주민번호 7자리 이후 암호화 / 복호화 
	  * SEC_BNKANUM: 계좌번호 암호화 /복호화  
	  * SEC_GECRYPT:통합기본암호화/복호화  
	  * SEC_PSSWD  : 패스워드 암호화  단방향 (사용안함.주의)
     * </pre>
     * @Method Name : getNoHoldSyncCrypt
     * @date : 2016. 8. 9.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 9.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param secSource 암호화 할 대상 
	 * @param secColumn 암호화 방법 타입
	 * @param secSyncType 암/복호화 타입
     * @return
     * @throws Exception
     */
	 public static  String getNoHoldSyncCrypt(String nResult,String secSource,String secColumn,String secSyncType)    {      
		   
		   String rtnNoHoldSyncCrypt = "";
		  try {
			 
			  rtnNoHoldSyncCrypt = getALLSyncCrypt(secSource,secColumn,secSyncType,"", "") ;
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return rtnNoHoldSyncCrypt = secSource;
			}	
		  
		   return rtnNoHoldSyncCrypt;
		   
		  
	}
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 구분자에 따른 암복호화 처리 및 마스킹기능
	  * 2. 처리내용 : 
	  * SEC_RRNUMC :  주민번호 7자리 이후 자릿수에 맞추어 암호화 /복호화 
	  * SEC_RRNUM  : 주민번호 7자리 이후 암호화 / 복호화 
	  * SEC_BNKANUM: 계좌번호 암호화 /복호화  
	  * SEC_GECRYPT:통합기본암호화/복호화  
	  * SEC_PSSWD  : 패스워드 암호화  단방향 (사용안함.주의)
	  * 
	  * 화면 출력 타입 
	  *  SEC_DEC_FULL : 전체 복호화 보여주기 
	  *  SEC_ENC_D07  : 암호화 특정자리수 이후 부터 별표나 0으로 표시 
	  *  SEC_ENC_FULL : 전체암호화해서보여주기 (암호화표시)
	  * </pre>
	  * @Method Name : getHoldSyncCrypt
	  * @date : 2016. 8. 9.
	  * @author : Administrator
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 8. 9.		Administrator				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	 * @param secSource 암호화 할 대상 
	  * @param secColumn 암호화 방법 타입
	  * @param secSyncType 암/복호화 타입
	  * @param secPrintType 화면 출력 타입
	  * @param placeHolder  암호화 부분 출력 옵션    "*"/"0" 두가지경우 존재  
	  * @return
	  * @throws Exception
	  */
	 public static  String getHoldSyncCrypt(String nResult,String secSource,String secColumn,String secSyncType,String secPrintType, String placeHolder)    {      
		   
		   String rtnHoldSyncCrypt = "";
		  try {
			 
			  rtnHoldSyncCrypt = getALLSyncCrypt(secSource,secColumn,secSyncType,secPrintType, placeHolder) ;
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return rtnHoldSyncCrypt = secSource;
			}	
		  
		   return rtnHoldSyncCrypt;
		   
		  
	}
	 
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 암호화 메서드 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : getSyncEncCrypt
	  * @date : 2016. 8. 9.
	  * @author : Administrator
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 8. 9.		Administrator				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param secSource
	  * @param secColumn
	  * @return
	  * @throws Exception
	  */
	 private static   String getSyncEncCrypt(String secSource,String secColumn) throws Exception  {      
		 
		 String rtnSyncEncCrypt = "";
		 
		  try {
			  
			   if (secColumn.equals(SEC_RRNUM)) { 
				   
				   /**
				    * 암복호화를 위해 넘어온 값 확인..
				    */
				if (secSource.matches("^\\d{6}[1-6]\\d{6}")) {
					
					if (SmrmfUtils.isNumeric(secSource)) { 
						//주민번호 암호화 메서드  
					    rtnSyncEncCrypt = xnCrypt.sync_EncRrnum(secSource);  
					    
			    	} else {

			    		  //주민번호 암호화 메서드  
						 rtnSyncEncCrypt = secSource;
			    	} 
					
				} else {
					//주민번호 암호화 메서드  
				    rtnSyncEncCrypt = secSource;  
				} 
                
			   } else if (secColumn.equals(SEC_RRNUMC)) {  
				   /**
				    * 암복호화를 위해 넘어온 값 확인..
				    */
				   if (secSource.matches("^\\d{6}[1-6]\\d{6}")) {
					   
						if (SmrmfUtils.isNumeric(secSource)) { 

							 //주민번호 암호화 메서드  13자리에 맞추어 암호화 
							   rtnSyncEncCrypt =  xnCrypt.sync_EncRrnumc(secSource); 
						    
				    	} else {

				    		  //주민번호 암호화 메서드  
							 rtnSyncEncCrypt = secSource;
				    	} 
						
					} else {
						//주민번호 암호화 메서드  13자리에 맞추어 암호화 
						   rtnSyncEncCrypt = secSource; 
					}  
					 
			   } else if (secColumn.equals(SEC_BNKANUM)) {   
				 
				// 계좌번호 암호화 
				   rtnSyncEncCrypt =  xnCrypt.sync_EncBnkAnum(secSource);
					 
			   } else if (secColumn.equals(SEC_GECRYPT)) { 
				 
				// 통합 일반암호화 메서드 
				   rtnSyncEncCrypt =  xnCrypt.sync_EncGenCrypt(secSource);
				 
			   } else  {
				   
				   rtnSyncEncCrypt = secSource;
				 // throw new MSFOperationException();   
			   } 
			    
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				//throw new MSFOperationException();   
				return rtnSyncEncCrypt = secSource;
			}	  
		   
		  return rtnSyncEncCrypt;
	}  
	
	 /**
	  * 
	  * <pre>
	  * 1. 개요 :  복호화 메서드 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : getSyncDecCrypt
	  * @date : 2016. 8. 9.
	  * @author : Administrator
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2016. 8. 9.		Administrator				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param secSource
	  * @param secColumn
	  * @param secPrintType
	  * @param placeHolder
	  * @return
	  * @throws Exception
	  */
	 private static   String getSyncDecCrypt(String secSource,String secColumn,String secPrintType, String placeHolder) throws Exception  {      
		  String rtnSyncEncCrypt = "";
		 
		  try {
			  if (secColumn.equals(SEC_RRNUM)) { 
				    
					    if (secSource.length() > 7) { 
					    	// 암호화 되어 있는지 여부 판단 
					    	if (SmrmfUtils.isNumeric(secSource)) {
					    		  //주민번호 암호화 메서드  
								 rtnSyncEncCrypt = secSource;
					    	} else {
					    		//주민번호 암호화 메서드  
							    rtnSyncEncCrypt = xnCrypt.sync_DecRrnum(secSource); 
					    	}
						} else {
							  //주민번호 암호화 메서드  
							 rtnSyncEncCrypt = secSource;
						}	 
				    
				   } else if (secColumn.equals(SEC_RRNUMC)) { 
				  
					//길이 체크 
					  if (secSource.length() == 13) {
						  
						  if (SmrmfUtils.isNumeric(secSource)) {
				    		  //주민번호 암호화 메서드  
							 rtnSyncEncCrypt = secSource;
				    	} else {
				    		//주민번호 암호화 메서드  13자리에 맞추어 암호화 
						     rtnSyncEncCrypt =  xnCrypt.sync_DecRrnumc(secSource);
				    	} 
					
					  } else {
						  rtnSyncEncCrypt =  secSource;
					  }	 
				   } else if (secColumn.equals(SEC_BNKANUM)) {  
					 
					// 계좌번호 암호화 
					   rtnSyncEncCrypt =  xnCrypt.sync_DecBnkAnum(secSource);
						 
				   } else if (secColumn.equals(SEC_GECRYPT)) { 
					 
					// 통합 일반암호화 메서드 
					   rtnSyncEncCrypt =  xnCrypt.sync_DecGenCrypt(secSource);
					 
				   } else  {
					   
					  return rtnSyncEncCrypt =  secSource;
					  //throw new MSFOperationException();   
				   } 
				    
			     //placeHolder 홀더처리를 위한 루틴 .......
			  
			  
			  
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return rtnSyncEncCrypt =  secSource;
			}	  
		  
		  return rtnSyncEncCrypt;
		  
	}   
	 
	   //보안모듈적용여부 
//		public   Boolean getEncryption() {
//		 
//	    }
//
//		public void setEncryption(Boolean encBool) {
//			  
//	    }
	    
		  

}
