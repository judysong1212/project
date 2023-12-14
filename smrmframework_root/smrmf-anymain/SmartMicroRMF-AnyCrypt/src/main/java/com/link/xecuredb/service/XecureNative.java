package com.link.xecuredb.service;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.crypto.constants.CryptConf;
import com.crypto.service.AbstCryptCutmServiceImpl;
import com.link.xecuredb.xdsp.XdspCommConf;
import com.link.xecuredb.xdsp.nativ.XdspLnkFastNative;
import com.link.xecuredb.xdsp.nativ.XdspLnkNative;
import com.softforum.xdbe.XdspException;
import com.softforum.xdbe.XdspIOException;
 
/**
 * <pre>
 * 
 *  XecureDb 연동에 따른 서비스 
 *  
 * com.link.xecuredb.service 
 *    |_ XecureNative.java
 * 
 * </pre>
 * @date : Nov 11, 2015 2:53:56 PM
 * @version : 
 * @author : leeheuisung
 */
 
public class XecureNative extends AbstCryptCutmServiceImpl implements ServletContextAware, ServletConfigAware {
	 
	  private static  String xdspNativeType ;   //보안모듈적용방법  2가지경우 존재 
	
	  private static XecureNative oneXNative;   
	  
	  private static XdspLnkNative xLnkNative;   
	  private static XdspLnkFastNative xLnkFastNative;    
	  
	  private static HashMap<String, String> secGlobals;
	  
	  private static Boolean encryption; //기본적용안함.
	  
			 
	  private static ServletContext sevltContext; 
	  private static ServletConfig sevltConfig;
	   
	  private XecureNative() {   
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		//   xclient  = new XdspClient ( poolname ); 
		 
		  
	  } 
	  
	  public static XecureNative getInstance() {
	        if(oneXNative==null) {
	        	oneXNative = new XecureNative();
	        }
	        return oneXNative;
	    } 
	
	  @Override
	    public void setServletConfig(ServletConfig servletConfig) {
	        this.sevltConfig = servletConfig;

	    }

	    @Override
	    public void setServletContext(ServletContext servletContext) {
	        this.sevltContext = servletContext;

	    }
	    
	    public  void XecureInitNative(ServletConfig servletCfg,HttpServletRequest request) throws Exception  {      
	 
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		//   xclient  = new XdspClient ( poolname ); 
	    //  ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();  
         // MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
        	 
		  secGlobals = CryptConf.getPayGenSecConfigInfo(servletCfg , request);   
		  
		  if (CryptConf.SECURITY_ENCRYPTION.equals(secGlobals.get("Security.Encryption"))) {
			  setEncryption(Boolean.TRUE) ;
		  } else {
			  setEncryption(Boolean.FALSE);
		  } 
		  
		  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
			  
			  xLnkFastNative = XdspLnkFastNative.getInstance();
			  xLnkFastNative.XdspLnkInitFastNative(servletCfg,request);
			  
		  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
			  
			  xLnkNative = XdspLnkNative.getInstance(); 
			  xLnkNative.XdspLnkInitNative(servletCfg,request);
		  } else {
			  //에러 
		  } 
		   
		  
	  } 
	  
	  
	   //보안모듈적용여부 
		public   Boolean getEncryption() {
			return  encryption;
	    }
 
		public void setEncryption(Boolean encBool) {
			 encryption = encBool;
	    }
	    
		/**
		 * <pre>
		 * 1. 개요 : 주민번호 암호화 메서드  
		 * 2. 처리내용 : 주민번호를 입력 받아 패턴에 따른 암호화를 한다.
		 *             7자리 이후 부터 암호화
		 * </pre>
		 * @Method Name : sync_Rrnum
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetEnc
		 * @return
		 * @throws XdspException
		 */ 	
		public String sync_EncRrnum(String targetEnc) throws  XdspException,Exception {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_RRNUM); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_RRNUM); 
				  } else {
					  //값 그대로 리턴 
					  strEncrypt64 = targetEnc;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
		   return strEncrypt64;

		} 

	 
		/**
		 * <pre>
		 * 1. 개요 : 주민번호 암호화 메서드  13자리에 맞추어 암호화 
		 * 2. 처리내용 : 주민번호를 입력 받아 패턴에 따른 암호화를 한다.
		 *             7자리 이후 부터 암호화 13자리 압축 맞춤  
		 * </pre>
		 * @Method Name : sync_Rrnumc
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetDec
		 * @return
		 * @throws XdspIOException
		 * @throws XdspException
		 */ 	
		public String sync_EncRrnumc(String targetEnc)  throws   XdspException ,Exception {
			  String strEncrypt64 = null; 
				 
				try {
					  //암호화 설정에 따라 
					  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
						  
						  strEncrypt64 = xLnkFastNative.fast_sync_MSFCompEncrypt64(targetEnc, XdspCommConf.SEC_RRNUMC); 
						  System.out.println (getEncryption() + "<font color='red'>SECURITY_FAST_SYNC_NATIVE : " + strEncrypt64 + "</font>" + CryptConf.SECURITY_FAST_SYNC_NATIVE + " : "+ secGlobals.get("Security.XdspNativeType"));
					  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
						  
						  strEncrypt64 = xLnkNative.sync_MSFCompEncrypt64(targetEnc, XdspCommConf.SEC_RRNUMC); 
						  System.out.println (getEncryption() + "<font color='red'>SECURITY_FAST_SYNC_NATIVE : " + strEncrypt64 + "</font>" + CryptConf.SECURITY_SYNC_NATIVE + " : "+ secGlobals.get("Security.XdspNativeType"));
					  } else {
						  strEncrypt64 = targetEnc;
						  System.out.println (getEncryption() + "<font color='red'> : " + strEncrypt64 + "</font>" +   secGlobals.get("Security.XdspNativeType"));
							 
					  } 
				  
					}
					catch (XdspException xdspe) 
					{
						System.out.println ("<font color='red'>" + xdspe + "</font>");
						xdspe.printStackTrace();
					}  
				
			   return strEncrypt64;
		}
		
		
		/**
		 * <pre>
		 * 1. 개요 : 주민번호 복호화 처리 메서드 
		 * 2. 처리내용 : 주민번호 암호화 -> 복호화 처리 
		 * </pre>
		 * @Method Name : sync_DecRrnum
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetDec
		 * @return
		 * @throws XdspIOException
		 * @throws XdspException
		 */ 	
		public String sync_DecRrnum(String targetDec)  throws   XdspException ,Exception {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
		 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkFastNative.fast_sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_RRNUM); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkNative.sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_RRNUM);
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else {
					  strDecrypt64 = targetDec;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
            return strDecrypt64;
		}
		
		/**
		 * <pre>
		 * 1. 개요 :  주민번호 자릿수 13자리 압축 암호화 복호화
		 * 2. 처리내용 :   주민번호 13자리로 암호화 한 값을 복호화 한다.
		 * </pre>
		 * @Method Name : sync_DecRrnumc
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetDec
		 * @return
		 * @throws XdspException
		 */ 	
		public String sync_DecRrnumc(String targetDec)  throws   XdspException  ,Exception {
			String strDecrypt64 = null;
			 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkFastNative.fast_sync_MSFCompDecrypt64(targetDec, XdspCommConf.SEC_RRNUMC); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkNative.sync_MSFCompDecrypt64(targetDec, XdspCommConf.SEC_RRNUMC);
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else {
					  strDecrypt64 = targetDec;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
            return strDecrypt64;
		}
		
		
		
		/**
		 * <pre>
		 * 1. 개요 : 계좌번호 암호화 
		 * 2. 처리내용 : 계좌번호를 암호화 한다.
		 * </pre>
		 * @Method Name : sync_EncBnkAnum
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetEnc
		 * @return
		 * @throws XdspException
		 */ 	
		public String sync_EncBnkAnum(String targetEnc) throws  XdspException  ,Exception {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_BNKANUM); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_BNKANUM); 
				  } else {
					  strEncrypt64 = targetEnc;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
		   return strEncrypt64;

		} 
		
		
		/**
		 * <pre>
		 * 1. 개요 : 암호화된 계좌번호를 복호화 하는 메서드 
		 * 2. 처리내용 : 암호화 -> 복호화 
		 * </pre>
		 * @Method Name : sync_DecBnkAnum
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetDec
		 * @return
		 * @throws XdspException
		 */ 	
		public String sync_DecBnkAnum(String targetDec)  throws   XdspException  ,Exception {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
		 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkFastNative.fast_sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_BNKANUM); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkNative.sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_BNKANUM);
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else {
					  strDecrypt64 = targetDec;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
            return strDecrypt64;
		}

		
 
		/**
		 * <pre>
		 * 1. 개요 : 통합 일반암호화 메서드 
		 * 2. 처리내용 : 일반적인 암호화시 사용 
		 * </pre>
		 * @Method Name : sync_EncGenCrypt
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetEnc
		 * @return
		 * @throws XdspException
		 */ 	
		public String sync_EncGenCrypt(String targetEnc) throws  XdspException  ,Exception {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_GECRYPT); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_GECRYPT); 
				  } else {
					  strEncrypt64 = targetEnc;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
		   return strEncrypt64;

		} 
		
		
		 
		/**
		 * <pre>
		 * 1. 개요 : 일반 /통합 암호화 복호화 메서드 
		 * 2. 처리내용 : 일반/통합 암호화에 따른 복호화 처리를 한다. 
		 * </pre>
		 * @Method Name : sync_DecGenCrypt
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetDec
		 * @return
		 * @throws XdspException
		 */ 	
		public String sync_DecGenCrypt(String targetDec)  throws   XdspException  ,Exception {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
		 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkFastNative.fast_sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_GECRYPT); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					   
					  strDecrypt64 = xLnkNative.sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_GECRYPT);
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else {
					  strDecrypt64 = targetDec;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
            return strDecrypt64;
		}
		
		
		/**
		 * <pre>
		 * 1. 개요 : 패스워드 암호화 
		 * 2. 처리내용 : 패스워드 암호화는 단방향으로 암호화 하므로 
		 *             분실시 초기화 후 변경하여야한다.
		 * </pre>
		 * @Method Name : sync_EnPsswd
		 * @date : Nov 11, 2015
		 * @author : leeheuisung
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	Nov 11, 2015		leeheuisung				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param targetEnc
		 * @return
		 * @throws XdspException
		 */ 	
		public String sync_EnPsswd(String targetEnc) throws  XdspException  ,Exception {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_PSSWD); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(secGlobals.get("Security.XdspNativeType"))) {
					  
					  strEncrypt64 = xLnkNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_PSSWD); 
				  } else {
					  strEncrypt64 = targetEnc;
				  } 
			  
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				}  
			
		   return strEncrypt64;

		}  
		 

}
