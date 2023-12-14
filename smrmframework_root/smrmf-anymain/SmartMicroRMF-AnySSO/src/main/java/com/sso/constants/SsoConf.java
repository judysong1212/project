/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.sso.constants;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
 
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ext.constants.PropConfs;
   
public class SsoConf {
 
    private static final Logger logger = LoggerFactory.getLogger(SsoConf.class);
    
    public static final String SYSTEM_SESSION_LOCALE = "locale";
 
    private static String ssoConfigFile = ""; 
    //설정정보를 담은 객체
    private static HashMap<String, HashMap<String, String>> paygenConfigInfo;
 
     
  
   public static String getSsoConfigFile() {
		return  SmrmfUtils.defaultNulls(ssoConfigFile, PropConfs.APP_CONFIG_FILE);
	}

	public static void setSsoConfigFile(String ssoConfigFile) {
		SsoConf.ssoConfigFile = ssoConfigFile;
	}
	
	

public static String getCurrentLocale(HttpServletRequest httpRequest) {
	   
	  if ( httpRequest!=null && httpRequest.getSession()!=null && httpRequest.getSession().getAttribute(SYSTEM_SESSION_LOCALE)!=null ) {
	      return (String)httpRequest.getSession().getAttribute(SYSTEM_SESSION_LOCALE);
	  }
	  return "ko";
	  
	}
    
    public static HashMap<String, String> getPayGenSsoConfigInfo(ServletConfig sc, HttpServletRequest request) {
        String locale = getCurrentLocale(request);
        if ( paygenConfigInfo==null || paygenConfigInfo.get(locale)==null || paygenConfigInfo.get(locale).size()==0 ) {
            readMessagesFile(sc, locale);
        }
        if ( paygenConfigInfo!=null && paygenConfigInfo.get(locale)!=null ) {
            return paygenConfigInfo.get(locale);
        } else {
            return new HashMap<String, String>();
        }
    } 
    //TODO 메시지 파일 처리을 위해 확인 .
    public synchronized static void readMessagesFile(ServletConfig sc, String locale) {
        InputStream is = null;
        String propsFilePath = null;
        HashMap<String, String> messages = new HashMap<String, String>();
        if ( paygenConfigInfo==null ) {
            paygenConfigInfo = new HashMap<String, HashMap<String, String>>();
        }
        if ( paygenConfigInfo!=null ) {
            paygenConfigInfo.put(locale, messages);
        }
       
        //Read no-language-specific file
        try {
            Properties properties = new Properties();
            String rootPath = sc.getServletContext().getRealPath("/");
            propsFilePath = rootPath + "/WEB-INF/classes/egovframework/egovProps/" + getSsoConfigFile();
            logger.debug("Loading application config file '"+propsFilePath+"'");
            is = new FileInputStream(propsFilePath);
            properties.load(is);
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String)keys.nextElement();
                String value = properties.getProperty(key);
                messages.put(key, value);
            }
            logger.debug("Loaded application config file '"+propsFilePath+"'");
        } catch (Throwable t) {
            logger.error("EXCEPTION loading config file '"+propsFilePath+"'", t);
        } finally {
            if ( is!=null ) {
                try {
                    is.close();
                } catch (Throwable t) {
                    logger.error("EXCEPTION closing input stream for file '"+propsFilePath+"'", t);
                }
            }
        }
        //Read language-specific file
        try {
            Properties properties = new Properties();
            String rootPath = sc.getServletContext().getRealPath("/");
          //  String propsFileName = APP_CONFIG_FILE.substring(0, APP_CONFIG_FILE.indexOf(".properties")) + "_" + locale + ".properties";
            String propsFileName = getSsoConfigFile() ;
            propsFilePath = rootPath + "/WEB-INF/classes/egovframework/egovProps/" + propsFileName;
            logger.debug("Loading application config file '"+propsFilePath+"'");
            is = new FileInputStream(propsFilePath);
            properties.load(is);
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String)keys.nextElement();
                String value = properties.getProperty(key);
                messages.put(key, value);
            }
            logger.debug("Loaded application config file '"+propsFilePath+"'");
        } catch (Throwable t) {
            logger.error("EXCEPTION loading config file '"+propsFilePath+"'", t);
        } finally {
            if ( is!=null ) {
                try {
                    is.close();
                } catch (Throwable t) {
                    logger.error("EXCEPTION closing input stream for file '"+propsFilePath+"'", t);
                }
            }
        }
    }
 
     
}
