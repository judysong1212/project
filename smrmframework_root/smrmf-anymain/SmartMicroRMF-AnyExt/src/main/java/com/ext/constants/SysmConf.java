/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.ext.constants;

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
 
public class SysmConf {
 
    private static final Logger logger = LoggerFactory.getLogger(SysmConf.class); 

    private static String sysmConfigFile = ""; 
    //설정정보를 담은 객체
    private static HashMap<String, HashMap<String, String>> paygenConfigInfo; 
  
     

/**
	 * @return the sysmConfigFile
	 */
	public static String getSysmConfigFile() {
		return SmrmfUtils.defaultNulls(sysmConfigFile, PropConfs.APP_CONFIG_FILE);
	}

	/**
	 * @param sysmConfigFile the sysmConfigFile to set
	 */
	public static void setSysmConfigFile(String sysmConfigFile) {
		 SysmConf.sysmConfigFile = sysmConfigFile;
	}
	
	

public static String getCurrentLocale(HttpServletRequest httpRequest) {
	  if ( httpRequest!=null && httpRequest.getSession()!=null && httpRequest.getSession().getAttribute(PropConfs.SYSTEM_SESSION_LOCALE)!=null ) {
	      return (String)httpRequest.getSession().getAttribute(PropConfs.SYSTEM_SESSION_LOCALE);
	  }
	  return "ko";
	}
    
    public static HashMap<String, String> getPayGenConfigInfo(ServletConfig sc, HttpServletRequest request) {
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
            propsFilePath = rootPath + "/WEB-INF/classes/egovframework/egovProps/" + getSysmConfigFile();
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
            String propsFileName = getSysmConfigFile();
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
