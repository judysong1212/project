package org.msf.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmrmfUtils {
	
	 private static Logger logger = LoggerFactory.getLogger(SmrmfUtils.class);
	 
	/**
	 * 데이타의 널 여부를 판단함.
	 * @param value
	 * @return
	 */
    public static boolean dataNotNull(Object value) {
        boolean ok = true;
        if ( value == null ) {
            ok = false;
        } else if (value instanceof String) {
            ok = !value.toString().trim().equals("");
        } else if (value instanceof StringBuffer) {
            ok = !value.toString().trim().equals("");
        }
        return ok;
    }

    /**
     * 데이타의 널여부를 판단 
     * @param value
     * @return
     */
    public static boolean dataNull(Object value) {
        boolean notNull = dataNotNull(value);
        return !notNull;
    }	
    
    
    /**
     * 파일저장시 웹의 파일이름 인코딩
     * @param filename
     * @return
     */
    public static  String encodeFileName(String filename) {
        try {
            return URLEncoder.encode(filename, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    
    /**
     * 
     * @param e
     * @return
     */
    public String getStackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
  

    /**
     * 
     * @param e
     * @return
     */
    public static String getStackTraceString(Throwable ex) {
        return getStackTraceString(ex, "");
    }

    /**
     * 
     * @param e
     * @param indent
     * @return
     */
    private static String getStackTraceString(Throwable ex, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(ex.toString());
        sb.append("\n");

        StackTraceElement[] stack = ex.getStackTrace();
        if (stack != null) {
            for (StackTraceElement stackTraceElement : stack) {
                sb.append(indent);
                sb.append("\tat ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
        }

//        Throwable[] suppressedExceptions = e.getSuppressed();
//        // Print suppressed exceptions indented one level deeper.
//        if (suppressedExceptions != null) {
//            for (Throwable throwable : suppressedExceptions) {
//                sb.append(indent);
//                sb.append("\tSuppressed: ");
//                sb.append(getStackTraceString(throwable, indent + "\t"));
//            }
//        }

        Throwable cause = ex.getCause();
        if (cause != null) {
            sb.append(indent);
            sb.append("Caused by: ");
            sb.append(getStackTraceString(cause, indent));
        }

        return sb.toString();
    }
    
    public static String getCallingMethod(int level) {
        String method = "";
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[level];
            //method = stackTraceElement.getClassName()+"."+stackTraceElement.getMethodName();
            method = stackTraceElement.toString();
        } catch (Exception ex) {
            logger.error("EXCEPTION getting method name: "+ex);
        }
        return method;
    }
    /**
     * 
     * @param stackTrace
     * @return
     */
    public static String stackTraceToString(StackTraceElement[] stackTrace) {
        StringWriter sw = new StringWriter();
        printStackTrace(stackTrace, new PrintWriter(sw));
        return null; //sw.toString();
    }
    /**
     * 
     * @param stackTrace
     * @param pw
     */
    public static void printStackTrace(StackTraceElement[] stackTrace, PrintWriter pw) {
        for(StackTraceElement stackTraceEl : stackTrace) {
            pw.println(stackTraceEl);
        }
    }
    public static TimingInfo startTiming(Logger logger) {
        if ( logger.isDebugEnabled() ) {
            long start = System.currentTimeMillis();
            String id = start+"-"+Math.random();
            id = id.substring(0, Math.min(id.length(), 30));
            logger.debug("TIMING.INI["+id+"]: ["+getCallingMethod(3)+"]");
            return new TimingInfo(start, id);
        }
        return null;
    }
    public static long endTiming(Logger logger, TimingInfo t, String msg) {
        if ( logger.isDebugEnabled() ) {
            long duration = System.currentTimeMillis()-t.millis;
            logger.debug("TIMING.END["+t.id+"]: "+duration+" ["+msg+" - "+getCallingMethod(3)+"]");
            return duration;
        }
        return 0;
    }
    /**
     * 
     * <pre>
     * 1. 개요  : 숫자만 존재하는지 여부 판단  
     * 2. 처리내용 : 숫자이면 true   이외 false 
     * </pre>
     * @Method Name : isNumeric
     * @date : 2016. 12. 15.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 12. 15.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param s
     * @return
     */
    public static boolean isNumeric(String s) {  

        return s.matches("[-+]?\\d*\\.?\\d+");  

    }   
    

    public static boolean isEmpty(String s) {
        return (s == null || s.trim().length() == 0);
    }

    public static boolean isNullAsString(Object o) {
        return (o == null || o.toString().trim().length() == 0 || o.toString().trim().equalsIgnoreCase("null"));
    }

    public static String allowNulls(Object o) {
    	 
       // return o != null ? o.toString() : "";
       return !isNullAsString(o) ? o.toString() : "";
    }

    public static String defaultNulls(Object o, String s) {
        // return (o == null ? s : o.toString());
    	return (!isNullAsString(o) ? o.toString():s);
    }
    
    public static boolean paramNotNull(Object param) {
        boolean ok = true;
        if ( param == null ) {
            ok = false;
        } else if (param instanceof String) {
            ok = !param.toString().trim().equals("");
        } else if (param instanceof StringBuffer) {
            ok = !param.toString().trim().equals("");
        }
        return ok;
    }

    public static boolean paramNull(Object param) {
        boolean notNull = paramNotNull(param);
        return !notNull;
    }

    public static Object checkEmpty(Object obj, Object defaultValue) {
        return paramNotNull(obj) ? obj : defaultValue;
    }
    
    public static String rpad(Object o, int maxChars, char c) {
        StringBuffer sb = new StringBuffer(allowNulls(o).trim());
        int len = sb.length();
        int max = Math.max(0, maxChars);
        for(int i = len; i < max; i++) {
            sb.append(c);
        }
        return sb.substring(0, max).toString();
    }

    public static String lpad(Object o, int maxChars, char c) {
        StringBuffer sb = new StringBuffer();
        String from = allowNulls(o).trim();
        int len = from.length();
        String fromOk = from.substring(Math.max(0, len - maxChars));
        int lenOk = fromOk.length();
        for(int i = 0; i < maxChars - lenOk; i++) {
            sb.append(c);
        }
        sb.append(fromOk);
        return sb.toString();
    }

    public static void replace(StringBuffer sb, String oldsub, String newsub) {
        if (sb==null) {
            return;
        }

        int i=0;
        int oldlen=oldsub.length();
        int newlen=newsub.length();
        while ( i < sb.length() ) {
            if ( i+oldlen <= sb.length() ) {
                if ( sb.substring(i,i+oldlen).equals(oldsub) ) {
                    sb.replace(i, i+oldlen, newsub);
                    i=i+newlen-1;
                }
                i++;
            }
        }
        return;
    }

    public static String replace(String s, String oldsub, String newsub) {
        StringBuffer sb = new StringBuffer();

        if (s==null) {
            return "";
        }

        int i=0;
        int oldlen=oldsub.length();
        while ( i < s.length() ) {
            if ( i+oldlen <= s.length() ) {
                if ( s.substring(i,i+oldlen).equals(oldsub) ) {
                    sb.append(newsub);
                    i=i+oldlen-1;
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public static String replace(String s, char c, String newsub) {
        StringBuffer sb = new StringBuffer(s);

        if (s==null) {
            return "";
        }

        int i=0;
        int oldlen=1;
        int newlen=newsub.length();
        while ( i < sb.length() ) {
            if ( i+oldlen <= sb.length() ) {
                if ( sb.charAt(i) == c ) {
                    sb.replace(i, i+oldlen, newsub);
                    i=i+newlen-1;
                }
                i++;
            }
        }
        return sb.toString();
    }

    public static String checkCase(String name) {
        char firstLetter = name.charAt(0);
        if(Character.isLowerCase(firstLetter)) {
            name = name.substring(1,name.length());
            name = Character.toString(firstLetter).toUpperCase() + name;
        }
        return name;
    }

    
    /**
     * 
     * <pre>
     * 1. 개요 :  Date 을 String 형으로 반환 
     * 2. 처리내용 : 형식  yyyy-MM-dd_HH-mm-ss
     *            TODO TimeZone 변경 차후 
     * </pre>
     * @Method Name : convertDateToString
     * @date : Apr 3, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Apr 3, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param inval
     * @return
     */
     public static String convertDateToString(Date inval) {
         String retval = null;
         try {
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
             formatter.setTimeZone ( TimeZone.getTimeZone ( "Asia/Seoul" ) );
             retval = formatter.format(inval);
         } catch (Exception ex) {
         }
         return retval;
     }
   
     /**
      * 
      * <pre>
      * 1. 개요 : 
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : convertStringToDate
      * @date : Apr 3, 2016
      * @author : leeheuisung
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	Apr 3, 2016		leeheuisung				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param inval
      * @return
      */
     public static Date convertStringToDate(String inval) {
         Date retval = null;
         try {
             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
             formatter.setTimeZone ( TimeZone.getTimeZone ( "Asia/Seoul" ) );
             retval = formatter.parse(inval);
         } catch (Exception ex) {
         }
         return retval;
     }
     /**
      * 
      * <pre>
      * 1. 개요 : 
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : getStringFromDate
      * @date : Apr 3, 2016
      * @author : leeheuisung
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	Apr 3, 2016		leeheuisung				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param dtValue
      * @param pattern
      * @return
      */
     public static String getStringFromDate(Date dtValue, String pattern) {
         try {
             SimpleDateFormat format = new SimpleDateFormat(pattern);
             format.setTimeZone ( TimeZone.getTimeZone ( "Asia/Seoul" ) );
             String value = format.format(dtValue);
             return  value;
         } catch (Exception ex) {
             return null;
         }
     }

      /**
       * 
       * <pre>
       * 1. 개요 : 
       * 2. 처리내용 : 
       * </pre>
       * @Method Name : getDateFromString
       * @date : Apr 3, 2016
       * @author : leeheuisung
       * @history : 
       *	-----------------------------------------------------------------------
       *	변경일				작성자						변경내용  
       *	----------- ------------------- ---------------------------------------
       *	Apr 3, 2016		leeheuisung				최초 작성 
       *	-----------------------------------------------------------------------
       * 
       * @param strValue
       * @param pattern
       * @return
       */
     public static Date getDateFromString(String strValue, String pattern) {
         try { 
         	SimpleDateFormat format = new SimpleDateFormat(pattern); 
             format.setTimeZone ( TimeZone.getTimeZone ( "Asia/Seoul" ) );
             Date value = format.parse(strValue);
             return value;
         } catch (Exception ex) {
             return null;
         }
     }
     
     /**
      * in조건 쿼리 를 위한 스트링으로 넘어온 데이터 를 list로 변환 하여 검색조건으로 넘기기 위한 처리 
      * @param strValue
      * @return
      */
     public static List<String> getStrToArrayList(String strValue) {
          
         List<String> listValue = new ArrayList<String>(); 
         if (SmrmfUtils.dataNotNull(strValue)) {
 	        String[] rayDeptCd = strValue.substring(0, strValue.length()).split(",");
 	        
 	        for (int i=0; i<rayDeptCd.length; i++){ 
 	            listValue.add(rayDeptCd[i]);
 	        }  
         } else {
         	listValue.add("");
         }
         return listValue;
         
     } 
}
