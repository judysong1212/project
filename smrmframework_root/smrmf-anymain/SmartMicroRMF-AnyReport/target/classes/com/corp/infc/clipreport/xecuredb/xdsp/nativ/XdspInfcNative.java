package com.corp.infc.clipreport.xecuredb.xdsp.nativ;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softforum.xdbe.XdspException;
import com.softforum.xdbe.XdspIOException;
import com.softforum.xdbe.XdspNative;
import com.softforum.xdbe.XdspServerNotAvailableException;

/**
 * 
 * <pre>
 * com.link.xecuredb.xdsp.nativ 
 *    |_ XdspLnkNative.java
 *   외부 암호화   처리를 위한 클래스 
 * </pre>
 * @date : Nov 11, 2015 1:13:49 PM
 * @version : 
 * @author : leeheuisung
 */ 
public class XdspInfcNative {
	
	 private static final Logger logger = LoggerFactory.getLogger(XdspInfcFastNative.class);
	 
	  private static XdspInfcNative oneXInfcNative;    
	  
	  private static   String poolname		= "";
	  private static   String databaseName	 = "";
	  private static   String ownerName			= "";
	  private static   String tableName				= "";
	//  private static   String columnName			= "";
	//  private static   String input				= "123456789456";   
	  private static   String serverIp					= "";
	  private static   int serverPort					= 0;
	  private static   int timeout				= 10;
	  private static   String userId				= "";
	  private static   String userPassword	= "";
	  
	  private static   String propertiesFile	= "";
	  
	  private static HashMap<String, String> secGlobals = null;
	  
	  
	  private XdspInfcNative() {   
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		//   xclient  = new XdspClient ( poolname ); 
		  
	  } 
	  
	  public static XdspInfcNative getInstance() {
	        if(oneXInfcNative==null) {
	        	oneXInfcNative = new XdspInfcNative();
	        }
	        return oneXInfcNative;
	  }  
		 
	    
	  public void XdspInfcInitNative(HashMap<String, String> secGlobals)  throws Exception {   
		 
		  try { 
			  // 정책서버 기본 정보 설정  
			  poolname		= secGlobals.get("poolname");
			  databaseName	 =  secGlobals.get("database");
			  ownerName			=  secGlobals.get("owner");
			  tableName				=  secGlobals.get("table");
			  
			  serverIp		= secGlobals.get("ip");
			  serverPort	= Integer.parseInt(secGlobals.get("port"));
			  timeout		= Integer.parseInt(secGlobals.get("timeout"));
			  
			   userId	=    secGlobals.get("userId");
			   userPassword	=  secGlobals.get("userPassword");
			  
			  //” xdsp_pool.properties” xecuredb 환경설정 파일 경로
			 // XdspNative.setPropertiesFile("D:/extrms/xecuredb/conf/xdsp_pool.properties"); 
			  propertiesFile  = secGlobals.get("propertiesFile");
			  
				  
	 	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		  
	  } 

	  /**
	   * 
	   * <pre>
	   * 1. 개요 : 
	   * 2. 처리내용 : 
	   * </pre>
	   * @Method Name : sync_MSFEncrypt64
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
	   * @throws XdspIOException
	   * @throws XdspException
	   */
		public String sync_MSFEncrypt64(String targetEnc, String columnName) throws XdspIOException,XdspException {
			  
			  String strEncrypt64 = null; 
			  int nHandle	= -1;  
			  
			try {
				
				XdspNative.setPropertiesFile(propertiesFile);
				
				nHandle = XdspNative.sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
			  
				strEncrypt64 = XdspNative.sync_encrypt64(nHandle, targetEnc.getBytes());
				//System.out.println ( "<b>encrypt</b> '"+ strEncrypt64 + "'" );
 
	
//				}
//				catch (XdspException xdspe) 
//				{
//					System.out.println ("<font color='red'>" + xdspe + "</font>");
//					//e.printStackTrace();
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'>" + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} finally { 
						XdspNative.sync_close(nHandle);
						//XdspNative.sync_close(database, owner, table, column); 
				} 
			
		   return strEncrypt64;

		} 
 
		/**
		 * <pre>
		 * 1. 개요 : 
		 * 2. 처리내용 : 암호화 디코딩 64 - 복호화 
		 * </pre>
		 * @Method Name : sync_MSFDecrypt64
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
		public String sync_MSFDecrypt64(String targetDec, String columnName)  throws  XdspIOException,XdspException {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
			int		  nHandle	= -1; 
		    
			
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		    // XdspClient  xclient     = new XdspClient ( poolname ); 
		     
			try {
				
				XdspNative.setPropertiesFile(propertiesFile);
				
				nHandle = XdspNative.sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
 
				bytDecrypt64 = XdspNative.sync_decrypt64(nHandle, targetDec );
				strDecrypt64   = new String ( bytDecrypt64 );
				//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					
	
//				}
//				catch (XdspException xdspe) 
//				{
//					System.out.println ("<font color='red'>" + xdspe + "</font>");
//					//e.printStackTrace();
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'>" + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} finally { 
						XdspNative.sync_close(nHandle); 
				} 
            return strDecrypt64;
		}
		
 
		/**
		 * <pre>
		 * 1. 개요 : 
		 * 2. 처리내용 :  64bit 인코딩 암축 암호화 -암호화 
		 * </pre>
		 * @Method Name : sync_MSFCompEncrypt64
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
		 * @throws XdspIOException
		 * @throws XdspException
		 */ 	
		public String sync_MSFCompEncrypt64(String targetEnc, String columnName) throws XdspIOException,XdspException {
			  
			  String strEncrypt64 = null;
			  int		  nHandle	= -1; 
			  
			  
			// 한글일 경우 다음과 같이 변환한다.
			     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
			     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
			//  XdspClient  xclient  = new XdspClient ( poolname ); 
			     
			try {
				 
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+serverIp+"'");
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+serverPort+"'");
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+timeout+"'");
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+userId+"'");
				
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+userPassword+"'");
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+databaseName+"'");
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+ownerName+"'");
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+tableName+"'");
			//	logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+columnName+"'"); 
				 
				XdspNative.setPropertiesFile(propertiesFile);
				
				nHandle = XdspNative.comp_sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
			 

				strEncrypt64 = XdspNative.comp_sync_encrypt64(nHandle, targetEnc.getBytes());
				//System.out.println ( "<b>encrypt</b> '"+ strEncrypt64 + "'" );
 
	
//				}
//				catch (XdspException xdspe) 
//				{
//					System.out.println ("<font color='red'>" + xdspe + "</font>");
//					//e.printStackTrace();
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'>" + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} finally { 
					
					 XdspNative.comp_sync_close(nHandle); 
				} 
			
		   return strEncrypt64;

		} 

 
		/**
		 * <pre>
		 * 1. 개요 : 
		 * 2. 처리내용 : 압축 암호화 디코딩 64 - 복호화 
		 * </pre>
		 * @Method Name : sync_MSFCompDecrypt64
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
		public String sync_MSFCompDecrypt64(String targetDec, String columnName)  throws  XdspIOException,XdspException {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
			int		  nHandle	= -1; 
		 
			
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		   //  XdspClient  xclient     = new XdspClient ( poolname ); 
		     
			try {
				
				XdspNative.setPropertiesFile(propertiesFile);
				
				nHandle = XdspNative.comp_sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
 
				bytDecrypt64 = XdspNative.comp_sync_decrypt64(nHandle, targetDec );
				strDecrypt64   = new String ( bytDecrypt64 );
				//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					
	
//				}
//				catch (XdspException xdspe) 
//				{
//					System.out.println ("<font color='red'>" + xdspe + "</font>");
//					//e.printStackTrace();
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'>" + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} finally {
					 
						XdspNative.comp_sync_close(nHandle); 
				} 
            return strDecrypt64;
		}

}
