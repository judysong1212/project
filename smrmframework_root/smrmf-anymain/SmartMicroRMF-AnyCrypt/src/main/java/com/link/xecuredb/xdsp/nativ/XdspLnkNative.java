package com.link.xecuredb.xdsp.nativ;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.crypto.constants.CryptConf;
import com.crypto.service.AbstCryptCutmServiceImpl;
import com.crypto.service.AnyCryptService;
import com.softforum.xdbe.XdspClient;
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
public class XdspLnkNative extends AbstCryptCutmServiceImpl implements ServletContextAware, ServletConfigAware {
	
	 private static final Logger logger = LoggerFactory.getLogger(XdspLnkFastNative.class);
	 
	  private static XdspLnkNative oneXLnkNative;    
	  
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
	  private static ServletContext sevltContext; 
	   private static ServletConfig sevltConfig;
	   /** 암호화 모듈 호출  */
	   @Autowired 
       @Resource(name = "AnyCryptService")
       protected AnyCryptService payGenCryptService;
		  
	  private XdspLnkNative() {   
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		//   xclient  = new XdspClient ( poolname ); 
		  
	  } 
	  
	  public static XdspLnkNative getInstance() {
	        if(oneXLnkNative==null) {
	        	oneXLnkNative = new XdspLnkNative();
	        }
	        return oneXLnkNative;
	  }  
		
	  
	    
	    @Override
	    public void setServletConfig(final ServletConfig servletConfig) {
	        this.sevltConfig = servletConfig;

	    }

	    @Override
	    public void setServletContext(final ServletContext servletContext) {
	        this.sevltContext = servletContext;

	    }
	    
	  public void XdspLnkInitNative(ServletConfig servletCfg,HttpServletRequest request)  throws Exception {   
			 
		  secGlobals = CryptConf.getPayGenSecConfigInfo(servletCfg , request);   
		  try {
			  
//			  if  (payGenCryptService == null) {
//			        
//		        	WebApplicationContext wac = WebApplicationContextUtils.
//		                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//		        	payGenCryptService = (AnyCryptService) wac.getBean("AnyCryptService" ); 
//		        	 
//		      } 
			  // 정책서버 기본 정보 설정  
			  poolname		= secGlobals.get("Security.OsType");
			  databaseName	=  secGlobals.get("Security.DbType");
			  ownerName		=  secGlobals.get("Security.Owner");
			  tableName		=  secGlobals.get("Security.TableName");
			
			  serverIp		= secGlobals.get("Security.ServerHostName");
			  serverPort	= Integer.parseInt(secGlobals.get("Security.ServerPort"));
			  timeout		= Integer.parseInt(secGlobals.get("Security.ConTimeOut"));
			 
			 // "xdb"; //"78()uiOP" ;
			  userId	=  secGlobals.get("Security.UserName"); //DCrypto.decrypt(secGlobals.get("Security.UserName"));    ///
			  userPassword	=  secGlobals.get("Security.Password"); //DCrypto.decrypt(secGlobals.get("Security.Password")); //
			
			 //  String aaa = payGenCryptService.payGenDecrypt(secGlobals.get("Security.UserName"));
			 //  String bbb =  payGenCryptService.payGenDecrypt(secGlobals.get("Security.Password"));
			  //  System.out.println("data.crypto.encryptype" + String.valueOf(props.getProperty( "data.crypto.encryptype" )));
				System.out.println("data.crypto.ip" + serverIp);
				System.out.println("data.crypto.poolnme" + poolname);
				System.out.println("data.crypto.database" + databaseName);
				System.out.println("data.crypto.owner" + ownerName);
				System.out.println("data.crypto.table" + tableName);
				//System.out.println("data.crypto.column" + String.valueOf(props.getProperty( "data.crypto.column" )));
				System.out.println("data.crypto.user.id :" + userId);
				System.out.println("data.crypto.user.password :" + userPassword);
				System.out.println("data.crypto.port" + serverPort);
				System.out.println("data.crypto.timeout" + timeout);
				System.out.println("data.crypto.propertiesFile" + secGlobals.get("Security.PropertiesFile"));
				 
				
			  //” xdsp_pool.properties” xecuredb 환경설정 파일 경로
			  // XdspNative.setPropertiesFile("D:/extrms/xecuredb/conf/xdsp_pool.properties"); 
			  propertiesFile  = secGlobals.get("Security.PropertiesFile");
				  
		  } catch (Exception e) {
				e.printStackTrace();
				throw new Exception();  
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
		public String sync_MSFEncrypt64(String targetEnc, String columnName) throws XdspIOException,XdspException ,Exception{
			  
			  String strEncrypt64 = null; 
			  int nHandle	= -1;  
			  XdspClient  xclient     = new XdspClient ( poolname ); 
			try {
				 
				//XdspNative.setPropertiesFile(propertiesFile);
				//nHandle = XdspNative.sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
			  
				//strEncrypt64 = XdspNative.sync_encrypt64(nHandle, targetEnc.getBytes());
				strEncrypt64 = XdspNative.fast_comp_sync_encrypt64(poolname,databaseName, ownerName, tableName, columnName , targetEnc.getBytes());
				
				//System.out.println ( "<b>encrypt</b> '"+ strEncrypt64 + "'" );
 
	
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'> sync_MSFEncrypt64 : " + xdspe + "</font>");
					xdspe.printStackTrace();
					throw new Exception(xdspe);  
					
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'> sync_MSFEncrypt64 : " + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new Exception(ex);  
				} finally {
					//XdspNative.fast_close(databaseName, ownerName, tableName, columnName );
					//	XdspNative.sync_close(nHandle);
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
		public String sync_MSFDecrypt64(String targetDec, String columnName)  throws  XdspIOException,XdspException,Exception {
			String strDecrypt64 = null;
			byte[]      bytDecrypt64    = null;
			int		  nHandle	= -1; 
		    
			
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		    XdspClient  xclient     = new XdspClient ( poolname ); 
		     
			try {
				
				//XdspNative.setPropertiesFile(propertiesFile);
				
				//nHandle = XdspNative.sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
 
				//bytDecrypt64 = XdspNative.sync_decrypt64(nHandle, targetDec );
				bytDecrypt64 = XdspNative.fast_sync_decrypt64(poolname, databaseName, ownerName, tableName, columnName, targetDec );
				strDecrypt64   = new String ( bytDecrypt64 );
				//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					
	
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'> sync_MSFDecrypt64 : " + xdspe + "</font>");
					xdspe.printStackTrace();
					throw new Exception(xdspe);  
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'> sync_MSFDecrypt64 : " + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace(); 
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception();  	
				} finally { 
					//XdspNative.fast_close(databaseName, ownerName, tableName, columnName );
					//	XdspNative.sync_close(nHandle); 
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
		public String sync_MSFCompEncrypt64(String targetEnc, String columnName) throws XdspIOException,XdspException,Exception {
			  
			  String strEncrypt64 = null;
			  int		  nHandle	= -1; 
			  
			  
			// 한글일 경우 다음과 같이 변환한다.
			     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
			     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		     XdspClient  xclient  = new XdspClient ( poolname ); 
			     
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
				 
			//	XdspNative.setPropertiesFile(propertiesFile);
				
			//	nHandle = XdspNative.comp_sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
			 

			//	strEncrypt64 = XdspNative.comp_sync_encrypt64(nHandle, targetEnc.getBytes());
				strEncrypt64 = XdspNative.fast_comp_sync_encrypt64( poolname,databaseName, ownerName, tableName, columnName, targetEnc.getBytes());
				//System.out.println ( "<b>encrypt</b> '"+ strEncrypt64 + "'" );
 
	
 				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'> sync_MSFCompEncrypt64 : " + xdspe + "</font>");
					xdspe.printStackTrace();
					throw new Exception(xdspe);  		
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'> sync_MSFCompEncrypt64 : " + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
					
				} finally { 
				//	 XdspNative.fast_close(databaseName, ownerName, tableName, columnName );
				//	 XdspNative.comp_sync_close(nHandle); 
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
		public String sync_MSFCompDecrypt64(String targetDec, String columnName)  throws  XdspIOException,XdspException,Exception {
			String strDecrypt64 = null;
			byte[]    bytDecrypt64    = null;
			int		  nHandle	= -1;  
			
			// 한글일 경우 다음과 같이 변환한다.
		     // WAS에 한글 패치가 적용된 것은 다음 과정이 필요없다.
		     //input = new String ( input.getBytes("8859_1"), "KSC5601" );
		    XdspClient  xclient     = new XdspClient ( poolname ); 
		     
			try {
				
			//	XdspNative.setPropertiesFile(propertiesFile);
				
				//nHandle = XdspNative.comp_sync_connect( serverIp, serverPort, timeout,userId, userPassword, databaseName, ownerName, tableName, columnName );
 
				//bytDecrypt64 = XdspNative.comp_sync_decrypt64(nHandle, targetDec );
				 bytDecrypt64 = XdspNative.fast_comp_sync_decrypt64(poolname,databaseName, ownerName, tableName, columnName ,targetDec );
				strDecrypt64   = new String ( bytDecrypt64 );
				//System.out.println ( "<br><b>decrypt</b> '" + strDecrypt64 + "'" );
					
	
				}
				catch (XdspException xdspe) 
				{
					System.out.println ("<font color='red'> sync_MSFCompDecrypt64 : " + xdspe + "</font>");
					xdspe.printStackTrace();
					throw new Exception(xdspe);  
				} catch (XdspServerNotAvailableException sdxpsnae) {
					
					System.out.println ("<font color='red'> sync_MSFCompDecrypt64 : " + sdxpsnae + "</font>");
					sdxpsnae.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception();  		
				} finally {
					//XdspNative.fast_close(databaseName, ownerName, tableName, columnName );
					//	XdspNative.comp_sync_close(nHandle); 
				} 
            return strDecrypt64;
		}

}
