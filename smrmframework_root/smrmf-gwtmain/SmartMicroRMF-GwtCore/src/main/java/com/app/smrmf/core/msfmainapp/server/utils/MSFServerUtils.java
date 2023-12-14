/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ListColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFOperationException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFSimpleMessageException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFUserExpiredException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFValidationException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.ext.constants.PropConfs;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
   
public class MSFServerUtils {
 
	private static Logger logger = LoggerFactory.getLogger(MSFServerUtils.class);
 
 //   private static HashSet<String> historizableDaosFull;
 //   private static HashSet<String> historizableDaosLite;
    private static HashMap<String, HashMap<String, String>> languageMessages;

    public static MSFSysm0100BM getLoggedUser(HttpServletRequest request) throws MSFUserExpiredException {
        MSFSysm0100BM user = null;
        try {
            HttpSession session = request.getSession();
            user = (MSFSysm0100BM) session.getAttribute(MSFConfiguration.PAYGEN_SESSION_USER);
            if ( user != null ) {
                return user;
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION reading user from session.", ex);
        }
        throw new MSFUserExpiredException();
    }

    public static String getCurrentLocale(HttpServletRequest httpRequest) {
        if ( httpRequest!=null && httpRequest.getSession()!=null && httpRequest.getSession().getAttribute(MSFConfiguration.PAYGEN_SESSION_LOCALE)!=null ) {
            return (String)httpRequest.getSession().getAttribute(MSFConfiguration.PAYGEN_SESSION_LOCALE);
        }
        return "ko";
    }

    public static void setCurrentLocale(HttpServletRequest httpRequest, String locale) {
        if ( httpRequest!=null && MSFSharedUtils.paramNotNull(locale) ) {
            HttpSession httpSession = httpRequest.getSession(); 
            httpSession.setAttribute(MSFConfiguration.PAYGEN_SESSION_LOCALE, locale);
        }
    }

    public static void setCurrentLocaleFromRequest(HttpServletRequest httpRequest) {
        if ( httpRequest!=null ) {
            String reqLocale  = httpRequest.getParameter(MSFConfiguration.REQ_ATTR_LOCALE)!=null ? httpRequest.getParameter(MSFConfiguration.REQ_ATTR_LOCALE).trim().toLowerCase() : "ko";
            String sessLocale = httpRequest.getSession()!=null ? MSFSharedUtils.allowNulls(httpRequest.getSession().getAttribute(MSFConfiguration.PAYGEN_SESSION_LOCALE)).trim().toLowerCase() : "ko";
            String locale = MSFSharedUtils.paramNotNull(sessLocale) ? sessLocale : reqLocale;
            setCurrentLocale(httpRequest, locale);
        }
    }

    public static void updateCurrentLocaleFromRequest(HttpServletRequest httpRequest) {
        if ( httpRequest!=null ) {
            String locale = httpRequest.getParameter(MSFConfiguration.REQ_ATTR_LOCALE)!=null ? httpRequest.getParameter(MSFConfiguration.REQ_ATTR_LOCALE).trim().toLowerCase() : "ko";
            setCurrentLocale(httpRequest, locale);
        }
    }
    
  
    public static HashMap<String, String> getLocalidedMessages(ServletConfig sc, HttpServletRequest request) {
        String locale = getCurrentLocale(request);
        if ( languageMessages==null || languageMessages.get(locale)==null || languageMessages.get(locale).size()==0 ) {
            readMessagesFile(sc, locale);
        }
        if ( languageMessages!=null && languageMessages.get(locale)!=null ) {
            return languageMessages.get(locale);
        } else {
            return new HashMap<String, String>();
        }
    }
    
//TODO  로케일 메시지처리를 위해 수정 할것.
    public static String getLocalizedMessage(ServletConfig sc, HttpServletRequest request, String key, String defaultValue) {
        try {
            String locale = getCurrentLocale(request);
           // GwtLocaleFactory gwtLocaleFactory = new GwtLocaleFactoryImpl();
           // GwtLocale gwtLocale = gwtLocaleFactory.fromString(locale);
           // Class constantsClass = Class.forName("com.app.smrmf.core.msfmainapp.client.languages.MSFConstants", false, MSFServerUtils.class.getClassLoader());
           // Localizable constants = I18nFactory.create(constantsClass, gwtLocale);
           // String methodName = "get" + MSFSharedUtils.checkCase(key);
           // Object value = ReflectionUtils.invokeMethod(constants, methodName, ReflectionUtils.EMPTY_TYPES, ReflectionUtils.EMPTY_VALUES);
           // String locale = getCurrentLocale(request);
            if ( languageMessages==null || languageMessages.get(locale)==null || languageMessages.get(locale).size()==0 ) {
                readMessagesFile(sc, locale);
            }
            if ( languageMessages!=null && languageMessages.get(locale)!=null ) {
                String value = languageMessages.get(locale).get(key);
                String retval = value!=null ? value.toString() : defaultValue;
                return retval;
            }
        } catch (Throwable t) {
            logger.debug("EXCEPTION in getLocalizedMessage()", t);
        }
        return defaultValue;
    }

    public static String getLocalizedMessage(String key, String defaultValue) {
        try {
            MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
            String locale = getCurrentLocale(userInfo.getHttpServletRequest());
            if ( languageMessages==null || languageMessages.get(locale)==null || languageMessages.get(locale).size()==0 ) {
                readMessagesFile(userInfo.getServletConfig(), locale);
            }
            if ( languageMessages!=null && languageMessages.get(locale)!=null ) {
                String value = languageMessages.get(locale).get(key);
                String retval = value!=null ? value.toString() : defaultValue;
                return retval;
            }
        } catch (Throwable t) {
            logger.debug("EXCEPTION in getLocalizedMessage()", t);
        }
        return defaultValue;
    }

    //TODO 메시지 파일 처리을 위해 확인 .
    public synchronized static void readMessagesFile(ServletConfig sc, String locale) {
        InputStream is = null;
        String propsFilePath = null;
        HashMap<String, String> messages = new HashMap<String, String>();
        if ( languageMessages==null ) {
            languageMessages = new HashMap<String, HashMap<String, String>>();
        }
        if ( languageMessages!=null ) {
            languageMessages.put(locale, messages);
        }
       
        //Read no-language-specific file
        try {
            Properties properties = new Properties();
            String rootPath = sc.getServletContext().getRealPath("/");
            propsFilePath = rootPath + "/WEB-INF/classes/egovframework/egovProps/" + PropConfs.APP_CONFIG_FILE;
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
            String propsFileName = PropConfs.APP_CONFIG_FILE ;
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

    /**
     * 
     * <pre>
     * 1. 개요 : 오퍼페이션 에러처리 메시지 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getOperationException
     * @date : 2016. 8. 9.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 9.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param method
     * @param t
     * @param log
     * @return
     */
    public static MSFException getOperationException(String method, Throwable t, Logger log) {
        log.error("OPERATION EXCEPTION calling '"+method+"': "+t);
        if ( log.isDebugEnabled() ) {
            log.debug("StackTrace:", t);
        }
        if ( t instanceof MSFException ) {
            return (MSFException)t;
        } else if ( t.getCause()!=null && t.getCause() instanceof MSFException ) {
            return (MSFException)t.getCause();
        }  
    
        MSFErrorMessage err = new MSFErrorMessage(null, null, MSFErrorMessage.ERRCODE_EXCEPTION, ""+t);
        MSFException retval = new MSFOperationException();
        retval.initCause(t);
        retval.addMessage(err);
        return retval;
    }

    /**
     * 
     * <pre>
     * 1. 개요 : UserExpiredException
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getUserExpiredException
     * @date : 2016. 8. 9.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 9.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param method
     * @param log
     * @return
     */
    public static MSFException getUserExpiredException(String method, Logger log) {
        log.debug("CALLING method "+method+" USER in session is null.");
        MSFException retval = new MSFUserExpiredException();
        return retval;
    }

    /**
     * 
     * <pre>
     * 1. 개요 : ValidationException 여러건 처리 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getValidationException
     * @date : 2016. 8. 9.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 9.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param method
     * @param errlist
     * @param log
     * @return
     */
    public static MSFException getValidationException(String method, List<MSFErrorMessage> errlist, Logger log) {
        log.debug("CALLING method "+method+" VALIDATION phase failed.");
        MSFException retval = new MSFValidationException();
        retval.addMessages(errlist);
        return retval;
    }
 
    
    /**
     * 
     * <pre>
     * 1. 개요 :  ValidationException 단건  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getValidationException
     * @date : 2016. 8. 9.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 9.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param method
     * @param err
     * @param log
     * @return
     */
    public static MSFException getValidationException(String method, MSFErrorMessage err, Logger log) {
        log.debug("CALLING method "+method+" VALIDATION phase failed.");
        MSFException retval = new MSFValidationException();
        retval.addMessage(err);
        return retval;
    }

    /**
     *  
     * <pre>
     * 1. 개요 : 기본 에러 처리 루틴  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getSimpleMessageException
     * @date : 2016. 8. 9.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 9.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param method
     * @param msg
     * @param log
     * @return
     */
    public static MSFException getSimpleMessageException(String method, String msg, Logger log) {
        log.debug("CALLING method "+method+" GENERIC exception.");
        String decodedMessage = MSFServerContext.getLocalizedMessage(msg, msg);
        MSFException retval = new MSFSimpleMessageException();
        MSFErrorMessage err = new MSFErrorMessage(null, null, MSFErrorMessage.ERRCODE_GENERIC_MSG, decodedMessage);
        retval.addMessage(err);
        return retval;
    }


    @SuppressWarnings("unchecked")
    public static PagingLoadResult<BaseModel> invokeCustomListMethod(
            ServiceParameters serviceParameters, MSFSysm0100BM user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            ServletContext servletContext, ServletConfig servletConfig) throws MSFException {
        PagingLoadResult<BaseModel> retval = null;
        try {
        	 
            Object result = invokeCustomMethod(serviceParameters, user, httpServletRequest, httpServletResponse, servletContext, servletConfig);
            
            retval = (PagingLoadResult<BaseModel>) result;
             
        } catch (Exception ex) {
            throw MSFServerUtils.getOperationException("invokeCustomListMethod()", ex, logger);
        }
        return retval;
    }

    public static BaseModel invokeCustomSaveMethod(
            ServiceParameters serviceParameters, MSFSysm0100BM user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            ServletContext servletContext, ServletConfig servletConfig) throws MSFException {
        BaseModel retval = null;
        try {
            Object result = invokeCustomMethod(serviceParameters, user, httpServletRequest, httpServletResponse, servletContext, servletConfig);
            retval = (BaseModel) result;
        } catch (Exception ex) {
            throw MSFServerUtils.getOperationException("invokeCustomSaveMethod()", ex, logger);
        }
        return retval;
    }

    public static BaseModel invokeCustomReadMethod(
            ServiceParameters serviceParameters, MSFSysm0100BM user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            ServletContext servletContext, ServletConfig servletConfig) throws MSFException {
        BaseModel retval = null;
        try {
            Object result = invokeCustomMethod(serviceParameters, user, httpServletRequest, httpServletResponse, servletContext, servletConfig);
            retval = (BaseModel) result;
        } catch (Exception ex) {
            throw MSFServerUtils.getOperationException("invokeCustomReadMethod()", ex, logger);
        }
        return retval;
    }

    public static Object invokeCustomMethod(
            ServiceParameters serviceParameters, MSFSysm0100BM user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            ServletContext servletContext, ServletConfig servletConfig) throws Exception  {
        Object retval = null; 
    
        try { 
		       // if ( MSFSharedUtils.paramNull( serviceParameters.getCustomMethodName()) ) {
		        //	serviceParameters.setCustomMethodName(serviceParameters.getClsName());
		        //} 
		        String customMethod = serviceParameters.getCustomMethodName();
		        int lastDotIdx = customMethod.lastIndexOf(".");
		        String className  = customMethod.substring(0, lastDotIdx);
		        String methodName = customMethod.substring(lastDotIdx+1);
		         
					Object	handler = Class.forName(className).newInstance();
				 
				
		        //호출할 빈명을 찾아서 가져온다.
		//        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(httpServletRequest.getSession().getServletContext());
		//     
		//       if (context.containsBean(className + ".class")) {
		//    	   Object handler   = context.getBean("Sysm0300Service"); //호출할 빈명  
		//        }  
		
		        if ( handler instanceof AbstractCustomServiceImpl ) {
		            AbstractCustomServiceImpl customHandler = (AbstractCustomServiceImpl)handler;
		            customHandler.setUser(user);
		            customHandler.setHttpServletRequest(httpServletRequest);
		            customHandler.setHttpServletResponse(httpServletResponse);
		            customHandler.setServletContext(servletContext);
		            customHandler.setServletConfig(servletConfig);
		        }
		       
		        Method method = ReflectionUtils.findMethod(handler, methodName, new Class[]{ServiceParameters.class});
		       
		        retval = method.invoke(handler, new Object[]{serviceParameters});
		      
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
		    // Answer:
		    e.getCause().printStackTrace();
		} catch (Exception e) {

		    // generic exception handling
		    e.printStackTrace();
		}
        
        return retval;
    }

    /**
     * Given a generic IColumnFilter (simple or list) and a particular attributeName, the method returns the
     * value present in the SimpleFilter associated to the given attributeName.
     * If more than one SimpleFilter for the given attributeName is present, the first is returned.
     * Null if no SimpleFilter exists for the given attributeName. 
     * @param filter
     * @param attributeName
     * @return
     */
    public static Object getFilterValue(IColumnFilter filter, String attributeName) {
        Object retval = null;
        SimpleColumnFilter scf = getFilter(filter, attributeName);
        if ( scf!=null ) {
            retval = scf.getValue();
        }
        return retval;
    }

    /**
     * Given a generic IColumnFilter (simple or list) and a particular attributeName, the method returns the
     * SimpleFilter associated to the given attributeName.
     * If more than one SimpleFilter for the given attributeName is present, the first is returned.
     * Null if no SimpleFilter exists for the given attributeName. 
     * @param filter
     * @param attributeName
     * @return
     */
    public static SimpleColumnFilter getFilter(IColumnFilter filter, String attributeName) {
        String attrName = adjustsColumnDefName(attributeName);
        if ( filter==null || MSFSharedUtils.paramNull(attrName) ) {
            return null;
        }

        SimpleColumnFilter retval = null;

        if (       filter instanceof SimpleColumnFilter && MSFSharedUtils.paramNotNull(((SimpleColumnFilter)filter).getAttribute()) ) {

            SimpleColumnFilter scf = (SimpleColumnFilter) filter;
            if ( attrName.equals(scf.getAttribute()) ) {
                retval = scf;
            }

        //Filter is a ListFilter, add Conjunction or Disjunction and add to them a list of Criterion
        } else if (filter instanceof ListColumnFilter && ((ListColumnFilter)filter).getFilterList()!=null) {

            ListColumnFilter lcf = (ListColumnFilter) filter;
            List<IColumnFilter> filterList = lcf.getFilterList();
            for ( int i=0 ; retval==null && filterList!=null && i<filterList.size() ; i++ ) {
                IColumnFilter childFilter = filterList.get(i);
                retval = getFilter(childFilter, attrName);
            }

        }

        return retval;
    }

    public static PagingValues getPagingValues(PagingLoadConfig pagingLoadConfig, List<ColumnOrder> columnOrders) {
        //Initialize default values
        PagingValues retval = new PagingValues(-1, -1, 0, true,true, columnOrders);
        //Get pagination info from pagingLoadConfig
        if (pagingLoadConfig != null) {
//            System.out.println("수정이후 데이터  들어온데이터 확인  (LoadConfig:" +
//                        "  offset=" + pagingLoadConfig.getOffset() + 
//                        "  limit=" + pagingLoadConfig.getLimit() +
//                        "  sortField=" + pagingLoadConfig.getSortField() +
//                        "  sortDir=" + pagingLoadConfig.getSortDir());
            //Log info regarding pagingLoadConfig
            if ( logger.isDebugEnabled() ) {
                logger.debug(
                        "LoadConfig:" +
                        "  offset=" + pagingLoadConfig.getOffset() + 
                        "  limit=" + pagingLoadConfig.getLimit() +
                        "  sortField=" + pagingLoadConfig.getSortField() +
                        "  sortDir=" + pagingLoadConfig.getSortDir() );
            }

            //Check if recordCount is already present
            if (pagingLoadConfig.get("recordCount") != null) {
                retval.totalRecordCount = ((Integer)pagingLoadConfig.get("recordCount")).intValue();
                retval.executeRecordCount = false;
            }

            //Be sure start and offsetLimit are positive numbers
            retval.start       = Math.max(pagingLoadConfig.getOffset(), 0);
            retval.offsetLimit = Math.max(pagingLoadConfig.getLimit(),  0);
            logger.debug("Start : " + retval.start + " offsetLimit : " + retval.offsetLimit);
        
            if ( MSFSharedUtils.paramNotNull(pagingLoadConfig.getSortField()) ) {
                if ( retval.columnOrders==null ) {
                    retval.columnOrders = new ArrayList<ColumnOrder>();
                }
                ColumnOrder columnOrder = 
                    new ColumnOrder(pagingLoadConfig.getSortField(), 
                                    MSFSharedUtils.allowNulls(pagingLoadConfig.getSortDir().name()), 0);
                retval.columnOrders.add(0, columnOrder);
            }
           
            logger.debug("orderBy : " + retval.columnOrders);
        } else {
            retval.start = 0;
            retval.offsetLimit = 0;
            retval.pageExecute = false;
        }
        return retval;
    }

    public static String adjustsColumnDefName(String columnDefName) {
        if (MSFSharedUtils.paramNotNull(columnDefName)) {
            columnDefName = columnDefName.replace(".", TableDef.SEPARATOR_CLIENT);
        }
        return columnDefName;
    }

    public static byte[] zipObject(Object obj) {

        if ( obj == null ) {
            return null;
        }

        byte[] zippedContent = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gz = new GZIPOutputStream(bos);
            ObjectOutputStream oos = new ObjectOutputStream(gz);
            oos.writeObject(obj);
            oos.flush();
            bos.flush();
            oos.close();
            bos.close();
            zippedContent = bos.toByteArray();
        } catch(Exception ex) {
            logger.error("EXCEPTION zipping object: "+ex);
        }
        return zippedContent;
    }

    public static Object unzipObject(byte[] zippedContent) {

        if ( zippedContent == null ) {
            return null;
        }

        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(zippedContent);
            GZIPInputStream gs = new GZIPInputStream(bis);
            ObjectInputStream ois = new ObjectInputStream(gs);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch(Exception ex) {
            logger.error("EXCEPTION unzipping object: "+ex);
        }
        return obj;
    }

    public static Object unzipObject(InputStream zippedStream) {

        if ( zippedStream == null ) {
            return null;
        }

        Object obj = null;
        try {
            GZIPInputStream gs = new GZIPInputStream(zippedStream);
            ObjectInputStream ois = new ObjectInputStream(gs);
            obj = ois.readObject();
            ois.close();
        } catch(Exception ex) {
            logger.error("EXCEPTION unzipping object: "+ex);
        }
        return obj;
    }

    public static byte[] getObjectAsBytes(Object obj) {

        if ( obj == null ) {
            return null;
        }

        byte[] content = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bos.flush();
            oos.close();
            bos.close();
            content = bos.toByteArray();
        } catch(Exception ex) {
            logger.error("EXCEPTION getObjectAsBytes: "+ex);
        }
        return content;
    }

    public static Object getObjectFromBytes(byte[] content) {

        if ( content == null ) {
            return null;
        }

        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(content);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch(Exception ex) {
            logger.error("EXCEPTION getObjectFromBytes: "+ex);
        }
        return obj;
    }

    /**
     * Return the approximate size in bytes.
     *
     * @param obj  the object to be checked
     */
    public static long getObjectSize(Object obj){
        long result = 0;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bos.flush();
            oos.close();
            bos.close();
            byte[] bytes = bos.toByteArray();
            result = bytes.length;
        } catch(Exception ex) {
        }

        return result;
    }

    public static String getObjectAsString(String name, Object value) {
        String retval = null;
        try {
            retval = name + ":";
            if ( value!=null ) {
                if ( value instanceof Date ) {
                    retval += SmrmfUtils.convertDateToString((Date)value);
                } else {
                    retval += value.toString();
                }
            } else {
                retval += value;
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return retval;
    }
//TODO DELETE
//    public synchronized static int isDaoHistorizable(String className) {
//        int retval = MSFConfiguration.HISTORIZABLE_DAO_NONE;
//        boolean reloadList = "true".equals(ConfigurationServlet.getProperty("history-dao-reload-list"));
//        if ( reloadList || historizableDaosFull==null  || historizableDaosLite==null ) {
//            historizableDaosFull = new HashSet<String>();
//            historizableDaosLite = new HashSet<String>();
//            ConfigurationServlet.getInstance().readConfigFile();
//            Long maxIndex =MSFSharedUtils.convertStringToLong(ConfigurationServlet.getProperty("history-dao-list-maxIndex"));
//            int size = maxIndex!=null ? maxIndex.intValue() : 0;
//            for ( int i=0 ; i<size ; i++ ) {
//                String keyFull   = "history-dao."+i;
//                String keyLite   = "history-dao."+i+".lite";
//                String daoNameFull = ConfigurationServlet.getProperty(keyFull);
//                String daoNameLite = ConfigurationServlet.getProperty(keyLite);
//                if ( MSFSharedUtils.paramNotNull(daoNameFull) ) {
//                    historizableDaosFull.add(daoNameFull);
//                } else if ( MSFSharedUtils.paramNotNull(daoNameLite) ) {
//                    historizableDaosLite.add(daoNameLite);
//                }
//            }
//        }
//        retval = 
//            historizableDaosFull!=null && historizableDaosFull.contains(className) ? MSFConfiguration.HISTORIZABLE_DAO_FULL :
//            historizableDaosLite!=null && historizableDaosLite.contains(className) ? MSFConfiguration.HISTORIZABLE_DAO_LITE :
//            MSFConfiguration.HISTORIZABLE_DAO_NONE;
//        return retval;
//    }
    
    public static StringBuffer xmlToStringBuffer(Document doc) {
        try {
            Source source = new DOMSource(doc);
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult(stringWriter);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.transform(source, result);
            return stringWriter.getBuffer();
        } catch (Exception ex) {
            logger.error("EXCEPTION in xmlToString: "+ex, ex);
            return null;
        }
    }
    public static String xmlToString(Document doc) {
        return xmlToStringBuffer(doc).toString();
    }
    public static Document stringToXml(String xmlString) {
        try {
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            dbfactory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder domparser = dbfactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlString));
            Document xmlDoc = domparser.parse(is);
            return xmlDoc;
        } catch (Exception ex) {
            logger.error("EXCEPTION in stringToXml: "+ex, ex);
            return null;
        }
    }

 
}
