package com.link.xecuredb.xdsp.nativ;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.crypto.constants.CryptConf;
import com.crypto.service.AbstCryptCutmServiceImpl;
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
public class XdspLnkFastNative extends AbstCryptCutmServiceImpl implements ServletContextAware, ServletConfigAware {
	
	 private static final Logger logger = LoggerFactory.getLogger(XdspLnkFastNative.class);
	 
	  private static XdspLnkFastNative oneXLnkFastNative;    
	  
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
		
	  private static ServletContext sevltContext; 
	   private static ServletConfig sevltConfig;
	  
	  private XdspLnkFastNative() {   
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		//   xclient  = new XdspClient ( poolname ); 
	  
	  } 
	  
	  
	   
	    @Override
	    public void setServletConfig(final ServletConfig servletConfig) {
	        this.sevltConfig = servletConfig;

	    }

	    @Override
	    public void setServletContext(final ServletContext servletContext) {
	        this.sevltContext = servletContext;

	    }
	  
	  public static XdspLnkFastNative getInstance() {
	        if(oneXLnkFastNative==null) {
	        	oneXLnkFastNative = new XdspLnkFastNative();
	        }
	        return oneXLnkFastNative;
	  }  
		
	  public    void XdspLnkInitFastNative(ServletConfig servletCfg,HttpServletRequest request) throws Exception {   
		  try {
			  // 한글일 경우 다음과 같이 변환한다.
			     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
			     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
			//   xclient  = new XdspClient ( poolname ); 
			  secGlobals = CryptConf.getPayGenSecConfigInfo(servletCfg , request);   
			  
			  // 정책서버 기본 정보 설정  
			  poolname		= secGlobals.get("Security.OsType");
			  databaseName	 =  secGlobals.get("Security.DbType");
			  ownerName			=  secGlobals.get("Security.Owner");
			  tableName				=  secGlobals.get("Security.TableName");
			  
			  serverIp		= secGlobals.get("Security.ServerHostName");
			  serverPort	= Integer.parseInt(secGlobals.get("Security.ServerPort"));
			  timeout		= Integer.parseInt(secGlobals.get("Security.ConTimeOut"));
			  
			  // userId	=    DCrypto.decrypt(secGlobals.get("Security.UserName"));
			  // userPassword	=  DCrypto.decrypt(secGlobals.get("Security.Password"));
				 // "xdb"; //"78()uiOP" ;
			     userId	=  secGlobals.get("Security.UserName");  
				 userPassword	=  secGlobals.get("Security.Password");   
				
			  //” xdsp_pool.properties” xecuredb 환경설정 파일 경로
			 // XdspNative.setPropertiesFile("D:/extrms/xecuredb/conf/xdsp_pool.properties"); 
			  propertiesFile  = secGlobals.get("Security.PropertiesFile");
			  
		  } catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
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
					
					System.out.println ("<font color='red'> fast_sync_MSFEncrypt64 :" + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
					
				} finally { 
						 
						// XdspNative.fast_close(databaseName, ownerName, tableName, columnName); 
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
					
					System.out.println ("<font color='red'> fast_sync_MSFDecrypt64 : " + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} finally { 
					//XdspNative.fast_close(databaseName, ownerName, tableName, columnName); 
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
				System.out.println("Loaded fast_sync_MSFCompEncrypt64 propertiesFile file '"+propertiesFile+"'");
				
				
				System.out.println("Loaded fast_sync_MSFCompEncrypt64 poolname file '"+poolname+"'");
				System.out.println("Loaded fast_sync_MSFCompEncrypt64 databaseName file '"+databaseName+"'");
				System.out.println("Loaded fast_sync_MSFCompEncrypt64 ownerName file '"+ownerName+"'");
				System.out.println("Loaded fast_sync_MSFCompEncrypt64 tableName file '"+tableName+"'");
				System.out.println("Loaded fast_sync_MSFCompEncrypt64 columnName file '"+columnName+"'");
				System.out.println("Loaded fast_sync_MSFCompEncrypt64 targetEnc.getBytes().toString file '"+targetEnc.getBytes().toString()+"'"); 
				 
				
				XdspNative.setPropertiesFile(propertiesFile);  
				strEncrypt64 = XdspNative.fast_comp_sync_encrypt64(poolname, databaseName, ownerName, tableName, columnName, targetEnc.getBytes());
				
 
	
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'> fast_sync_MSFCompEncrypt64 : " + xdspe + "</font>");
					System.out.println ( "<b>encrypt</b> '"+ strEncrypt64 + "'" );
					xdspe.printStackTrace();
					return strEncrypt64 = targetEnc;
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'>  fast_sync_MSFCompEncrypt64 : " + sdxpsnae + "</font>");
					System.out.println ( "<b>encrypt</b> '"+ strEncrypt64 + "'" );
					sdxpsnae.printStackTrace();
					
					return strEncrypt64 = targetEnc;
				} finally { 
					
					//XdspNative.fast_comp_sync_close(databaseName, ownerName, tableName, columnName); 
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
					
					System.out.println ("<font color='red'> fast_sync_MSFCompDecrypt64 : " + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} finally {
					 
					//XdspNative.fast_comp_sync_close(databaseName, ownerName, tableName, columnName); 
				} 
            return strDecrypt64;
		}

}
