package com.corp.infc.clipreport.xecuredb.xdsp.nativ;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softforum.xdbe.XdspException;
import com.softforum.xdbe.XdspIOException;
import com.softforum.xdbe.XdspNative;
import com.softforum.xdbe.XdspServerNotAvailableException;

 
/**
 * <pre>
 * com.link.xecuredb.xdsp.nativ 
 *    |_ XdspLnkFastNative.java
 * 
 * </pre>
 * @date : Nov 11, 2015 1:44:42 PM
 * @version : 
 * @author : leeheuisung
 */
public class XdspInfcFastNative  {
	
	 private static final Logger logger = LoggerFactory.getLogger(XdspInfcFastNative.class);
	 
	  private static XdspInfcFastNative oneXInfcFastNative;    
	  
	  private static   String poolname		= "";
	  private static   String databaseName	 = "";
	  private static   String ownerName			= "";
	  private static   String tableName				= "";
//      private static   String columnName			= "";
//    private static   String input				= "123456789456"; 
	  private static   String serverIp					= "";
	  private static   int serverPort					= 0;
	  private static   int timeout				= 10;
	  private static   String userId				= "";
	  private static   String userPassword	= "";
	  private static   String propertiesFile	= "";
	   
	  private static HashMap<String, String> secGlobals = null;
		  
	  private XdspInfcFastNative() {   
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		//   xclient  = new XdspClient ( poolname ); 
	  
	  } 
	   
	  public static XdspInfcFastNative getInstance() {
	        if(oneXInfcFastNative==null) {
	        	oneXInfcFastNative = new XdspInfcFastNative();
	        }
	        return oneXInfcFastNative;
	  }  
		
	  public void XdspInfcInitFastNative(HashMap<String, String> secGlobals) throws Exception {   
		  try {
			  // 한글일 경우 다음과 같이 변환한다.
			     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
			     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
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
		 * <pre>
		 * 1. 개요 : 
		 * 2. 처리내용 : 
		 * </pre>
		 * @Method Name : fast_sync_MSFEncrypt64
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
		 * @param columnName
		 * @return
		 * @throws XdspIOException
		 * @throws XdspException
		 */ 	
		public String fast_sync_MSFEncrypt64(String targetEnc, String columnName) throws XdspIOException,XdspException {
			  
			  String strEncrypt64 = null; 
		 
			try { 
				 
				XdspNative.setPropertiesFile(propertiesFile);

				strEncrypt64 = XdspNative.fast_sync_encrypt64(poolname, databaseName, ownerName, tableName, columnName , targetEnc.getBytes());;
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
						 
						 XdspNative.fast_close(databaseName, ownerName, tableName, columnName); 
				} 
			
		   return strEncrypt64;

		} 
 
	 
		/**
		 * <pre>
		 * 1. 개요 : 
		 * 2. 처리내용 : 
		 * </pre>
		 * @Method Name : fast_sync_MSFDecrypt64
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
		 * @param columnName
		 * @return
		 * @throws XdspIOException
		 * @throws XdspException
		 */ 	
		public String fast_sync_MSFDecrypt64(String targetDec, String columnName)  throws  XdspIOException,XdspException {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
			  
			try {
				
			    logger.debug("Loaded application propertiesFile file '"+propertiesFile+"'");
				
			    XdspNative.setPropertiesFile(propertiesFile);
 
				bytDecrypt64 = XdspNative.fast_sync_decrypt64( poolname, databaseName, ownerName, tableName, columnName , targetDec );
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
					XdspNative.fast_close(databaseName, ownerName, tableName, columnName); 
				} 
            return strDecrypt64;
		}
		
 
		
 	
		/**
		 * <pre>
		 * 1. 개요 : 
		 * 2. 처리내용 : 
		 * </pre>
		 * @Method Name : fast_sync_MSFCompEncrypt64
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
		 * @param columnName
		 * @return
		 * @throws XdspIOException
		 * @throws XdspException
		 */ 	
		public String fast_sync_MSFCompEncrypt64(String targetEnc, String columnName) throws XdspIOException,XdspException {
			  
			  String strEncrypt64 = null;
			  
			     
			try {
			//	XdspNative.propertyInitialize();
				//logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+propertiesFile+"'");
				
				
				//logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+poolname+"'");
				//logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+databaseName+"'");
				//logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+ownerName+"'");
				//logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+tableName+"'");
				//logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+columnName+"'");
				//logger.debug("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+targetEnc.getBytes().toString()+"'"); 
				 
				
				XdspNative.setPropertiesFile(propertiesFile);
				
				strEncrypt64 = XdspNative.fast_comp_sync_encrypt64(poolname, databaseName, ownerName, tableName, columnName, targetEnc.getBytes());
				//System.out.println ( "<b>encrypt</b> '"+ strEncrypt64 + "'" );
 
	
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'>" + xdspe + "</font>");
					xdspe.printStackTrace();
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'>" + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} finally { 
					
					XdspNative.fast_comp_sync_close(databaseName, ownerName, tableName, columnName); 
				} 
			
		   return strEncrypt64;

		} 

 
		 	
		/**
		 * <pre>
		 * 1. 개요 : 
		 * 2. 처리내용 : 
		 * </pre>
		 * @Method Name : fast_sync_MSFCompDecrypt64
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
		 * @param columnName
		 * @return
		 * @throws XdspIOException
		 * @throws XdspException
		 */ 	
		public String fast_sync_MSFCompDecrypt64(String targetDec, String columnName)  throws  XdspIOException,XdspException {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
			 
		     
			try {
				 
				XdspNative.setPropertiesFile(propertiesFile);
				
				bytDecrypt64 = XdspNative.fast_comp_sync_decrypt64(poolname, databaseName, ownerName, tableName, columnName, targetDec );
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
					 
					XdspNative.fast_comp_sync_close(databaseName, ownerName, tableName, columnName); 
				} 
            return strDecrypt64;
		}

}
