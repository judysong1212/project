package com.corp.infc.clipreport.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import com.clipsoft.clipreport.common.data.crypto.DataCrypto;
import com.corp.clipreport.constants.CryptConf;
import com.corp.infc.clipreport.comm.XdspCommConf;
import com.corp.infc.clipreport.xecuredb.xdsp.nativ.XdspInfcFastNative;
import com.corp.infc.clipreport.xecuredb.xdsp.nativ.XdspInfcNative;
import com.softforum.xdbe.XdspException;
import com.softforum.xdbe.XdspIOException;

/**
 * 
 * @author Administrator
 *
 */
public class DataCryptoImpl implements DataCrypto {
	
	/**
	 * 모든 변수들은 DataCrypto.properties에 설정되어 있는 값으로 초기화 됩니다. 
	 */
	
	/**
	 * 복호화할 컬럼정보 
	 */
	private static List<String> cryptoColumnNames;
	
	/**
	 * XecureDB XDSP API 호출하기 위한 정보 
	 */
	private static String rpIp, rpPoolname, rpDatabase, rpOwner, rpTable, rpColumn, rpUserId, rpUserPassword;
	private static String rpPropertiesFile;
	
	private static String rpPort = "";
	private static String rpTimeout = "";
//	private static int handle = 0;

	private static HashMap<String, String> rpSecGlobals;
	
	private static  String xdspRpNativeType ;   //보안모듈적용방법  2가지경우 존재 
		 
	  
	private static XdspInfcNative xInfcNative;   
	private static XdspInfcFastNative xInfcFastNative;    
	   
	 
	private static Boolean rpEncryption; //기본적용안함.
	private static ServletContext rpSevltContext; 
	private static ServletConfig rpSevltConfig;
	   
	/**
	 * 초기화
	 */
	public void init(Properties props) {
		try {	
			 
			/**
			 * 복호화할 컬럼정보 
			 * , 구분자로 여러개의 컬럼들을 리스트에 등록
			 */
			String[] columnNames = props.getProperty("data.crypto.columns").split("\\,");
			this.cryptoColumnNames = new ArrayList<String>();
			for (String columnName : columnNames) {
				cryptoColumnNames.add(columnName);
	    	}
			
			/**
			 * XecureDB XDSP API 호출하기 위한 정보 초기화
			 */			
		    rpSecGlobals = new HashMap<String, String>();
			

			System.out.println("data.crypto.encryptype" + String.valueOf(props.getProperty( "data.crypto.encryptype" )));
			System.out.println("data.crypto.ip" + String.valueOf(props.getProperty( "data.crypto.ip" )));
			System.out.println("data.crypto.poolnme" + String.valueOf(props.getProperty( "data.crypto.poolname" )));
			System.out.println("data.crypto.database" + String.valueOf(props.getProperty( "data.crypto.database" )));
			System.out.println("data.crypto.owner" + String.valueOf(props.getProperty( "data.crypto.owner" )));
			System.out.println("data.crypto.table" + String.valueOf(props.getProperty( "data.crypto.table" )));
			System.out.println("data.crypto.column" + String.valueOf(props.getProperty( "data.crypto.column" )));
			System.out.println("data.crypto.user.id" + String.valueOf(props.getProperty( "data.crypto.user.id" )));
			System.out.println("data.crypto.user.password" + String.valueOf(props.getProperty( "data.crypto.user.password" )));
			System.out.println("data.crypto.port" + String.valueOf(props.getProperty( "data.crypto.port" )));
			System.out.println("data.crypto.timeout" + String.valueOf(props.getProperty( "data.crypto.timeout" )));
			System.out.println("data.crypto.propertiesFile" + String.valueOf(props.getProperty( "data.crypto.propertiesFile" )));
			 
			xdspRpNativeType = props.getProperty( "data.crypto.encryptype" );
			 
			 
			rpIp = String.valueOf(props.getProperty( "data.crypto.ip" ));
			rpPoolname = String.valueOf(props.getProperty( "data.crypto.poolname" ));
			rpDatabase = String.valueOf(props.getProperty( "data.crypto.database" ));
			rpOwner = String.valueOf(props.getProperty( "data.crypto.owner" ));
			rpTable = String.valueOf(props.getProperty( "data.crypto.table" ));
			rpColumn = String.valueOf(props.getProperty( "data.crypto.column" ));
			rpUserId = String.valueOf(props.getProperty( "data.crypto.user.id" ));
			rpUserPassword =  String.valueOf(props.getProperty( "data.crypto.user.password" ));
			rpPort = String.valueOf(props.getProperty( "data.crypto.port" ));
			rpTimeout = String.valueOf(props.getProperty( "data.crypto.timeout" ));
			rpPropertiesFile = String.valueOf(props.getProperty( "data.crypto.propertiesFile" ));
			
			rpSecGlobals.put("ip",rpIp);
			rpSecGlobals.put("poolname",rpPoolname);
			rpSecGlobals.put("database",rpDatabase);
			rpSecGlobals.put("owner",rpOwner);
			rpSecGlobals.put("table",rpTable);
//			rpSecGlobals.put("column",rpColumn);
			rpSecGlobals.put("userId", rpUserId);
			rpSecGlobals.put("userPassword",rpUserPassword);
			rpSecGlobals.put("port", rpPort);
			rpSecGlobals.put("timeout",rpTimeout);
			rpSecGlobals.put("propertiesFile",rpPropertiesFile);
			
 										
            XecureRpInitNative(rpSecGlobals);
	      //  handle = XdspNative.comp_sync_connect(ip, port, timeout, userId,	userPassword, database, owner, table, column);
	
		} catch (XdspException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 해당 컬럼이 복호화할 컬럼인지 여부 
	 */
	public boolean isDataCrypto(String columnName) {
		for (String cryptoColumnName : cryptoColumnNames) {
			if (cryptoColumnName.equalsIgnoreCase(columnName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 복호화 부분
	 */
	public String getValue(String value) {
		String input = null, sOutput = "";
	  
		try {
			
			input = new String(value.getBytes("8859_1"), "KSC5601");
			sOutput = new String(input);
			//byte[] baOutput = null;
			 
			//sOutput = XdspNative.sync_encrypt64(handle, input.getBytes());
			//System.out.println("XdspNative.sync_encrypt64l : " + sOutput);
			//baOutput = XdspNative.sync_decrypt64(handle, sOutput);
			//System.out.println("XdspNative.sync_decrypt64 : " + baOutput);
			//sOutput = new String(baOutput);
			
			sOutput = sync_DecRrnumc(value);
			
		} catch (XdspException e) {
			e.printStackTrace();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return value;
		} 
		
		return sOutput;
	} 
	    
	    public  void  XecureRpInitNative(HashMap<String, String> secGlobals) throws Exception  {      
	 
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
	   
// 		  if (CryptConf.SECURITY_ENCRYPTION.equals(secGlobals.get("Security.Encryption"))) {
			  setEncryption(Boolean.TRUE) ;
//		  } else {
//			  setEncryption(Boolean.FALSE);
//		  } 
		  
		  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
			  
			  xInfcFastNative = XdspInfcFastNative.getInstance();
			  xInfcFastNative.XdspInfcInitFastNative(secGlobals);
			  
		  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
			  
			  xInfcNative = XdspInfcNative.getInstance(); 
			  xInfcNative.XdspInfcInitNative(secGlobals);
		  } else {
			  //에러 
		  } 
		    
		  
	  } 
	  
	  
	   //보안모듈적용여부 
		public   Boolean getEncryption() {
			return  rpEncryption;
	    }

		public void setEncryption(Boolean encBool) {
			rpEncryption = encBool;
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
		public String sync_EncRrnum(String targetEnc) throws  XdspException {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_RRNUM); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_RRNUM); 
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
		public String sync_EncRrnumc(String targetEnc)  throws   XdspException {
			  String strEncrypt64 = null; 
				 
				try {
					  //암호화 설정에 따라 
					  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
						  
						  strEncrypt64 = xInfcFastNative.fast_sync_MSFCompEncrypt64(targetEnc, XdspCommConf.SEC_RRNUMC); 
						  System.out.println (getEncryption() + "<font color='red'>SECURITY_FAST_SYNC_NATIVE : " + strEncrypt64 + "</font>" + CryptConf.SECURITY_FAST_SYNC_NATIVE + " : "+ xdspRpNativeType);
					  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
						  
						  strEncrypt64 = xInfcNative.sync_MSFCompEncrypt64(targetEnc, XdspCommConf.SEC_RRNUMC); 
						  System.out.println (getEncryption() + "<font color='red'>SECURITY_FAST_SYNC_NATIVE : " + strEncrypt64 + "</font>" + CryptConf.SECURITY_SYNC_NATIVE + " : "+ xdspRpNativeType);
					  } else {
						  strEncrypt64 = targetEnc;
						  System.out.println ("sync_EncRrnumc :" + getEncryption() + "<font color='red'> : " + strEncrypt64 + "</font>" +   xdspRpNativeType);
							 
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
		public String sync_DecRrnum(String targetDec)  throws   XdspException {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
		 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcFastNative.fast_sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_RRNUM); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcNative.sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_RRNUM);
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
		public String sync_DecRrnumc(String targetDec)  throws   XdspException {
			String strDecrypt64 = null; 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcFastNative.fast_sync_MSFCompDecrypt64(targetDec, XdspCommConf.SEC_RRNUMC); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcNative.sync_MSFCompDecrypt64(targetDec, XdspCommConf.SEC_RRNUMC);
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
		public String sync_EncBnkAnum(String targetEnc) throws  XdspException {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_BNKANUM); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_BNKANUM); 
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
		public String sync_DecBnkAnum(String targetDec)  throws   XdspException {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
		 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcFastNative.fast_sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_BNKANUM); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcNative.sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_BNKANUM);
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
		public String sync_EncGenCrypt(String targetEnc) throws  XdspException {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_GECRYPT); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_GECRYPT); 
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
		public String sync_DecGenCrypt(String targetDec)  throws   XdspException {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
		 
		     
			try { 
				
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcFastNative.fast_sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_GECRYPT); 
						//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					   
					  strDecrypt64 = xInfcNative.sync_MSFDecrypt64(targetDec, XdspCommConf.SEC_GECRYPT);
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
		public String sync_EnPsswd(String targetEnc) throws  XdspException {
			  
			  String strEncrypt64 = null; 
		 
			try {
				  //암호화 설정에 따라 
				  if (getEncryption() && CryptConf.SECURITY_FAST_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcFastNative.fast_sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_PSSWD); 
					  
				  } else if (getEncryption() && CryptConf.SECURITY_SYNC_NATIVE.equals(xdspRpNativeType)) {
					  
					  strEncrypt64 = xInfcNative.sync_MSFEncrypt64(targetEnc, XdspCommConf.SEC_PSSWD); 
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
	 * 소멸
	 */
	public void destory() {
		//try { 
			//XdspNative.close(handle);
		//} catch (XdspException e) {
		//	e.printStackTrace();
		//} 
	}
}
