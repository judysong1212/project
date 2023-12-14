/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.shared.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.constants.Constants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;


public class MSFSharedUtils {

    public static Timestamp convertDateToTimestamp(Date inval) {
        Timestamp retval = null;
        try {
            if ( inval!=null ) {
                retval = new Timestamp(inval.getTime());
            }
        } catch (Exception ex) {
        }
        return retval;
    }

    public static Date convertTimestampToDate(Date inval) {
        Date retval = null;
        try {
            if ( inval!=null ) {
                retval = new Date(inval.getTime());
            }
        } catch (Exception ex) {
        }
        return retval;
    }
   
    public static Double convertLongToDouble(Long inval) {
        Double retval = null;
        try {
            if ( inval!=null ) {
                retval = Double.valueOf(inval.doubleValue());
            }
        } catch (Exception ex) {
        }
        return retval;
    }

    public static Long convertDoubleToLong(Double inval) {
        Long retval = null;
        try {
            if ( inval!=null ) {
                retval = Long.valueOf(inval.longValue());
            }
        } catch (Exception ex) {
        }
        return retval;
    }

    public static Long convertStringToLong(String inval) {
        Long retval = null;
        try {
            if ( inval!=null ) {
                retval = Long.valueOf(inval);
            }
        } catch (Exception ex) {
        }
        return retval;
    }

    public static Double convertStringToDouble(String inval) {
        Double retval = null;
        try {
            if ( inval!=null ) {
                retval = Double.valueOf(inval);
            }
        } catch (Exception ex) {
        }
        return retval;
    }
 
    public static BigDecimal convertStringToBigDecimal(String inval) {
    	BigDecimal retval = null;
        try {
            if ( inval!=null ) {
                retval = new BigDecimal(inval);
            }
        } catch (Exception ex) {
        }
        return retval;
    }

    public static Boolean convertStringToBoolean(String inval) {
        Boolean retval = null;
        try {
            retval = 
                Constants.TRUE_VALUE.equals(inval)  ? Boolean.TRUE :
                Constants.FALSE_VALUE.equals(inval) ? Boolean.FALSE :
                null;
            if (retval == null) {
	            retval = 
	                    Constants.TRUE_EVALUE.equals(inval)  ? Boolean.TRUE :  Boolean.FALSE  ;
            }
        } catch (Exception ex) {
        }
        return retval;
    }
    
    /**
     * 1,2로 예아니오 일경우 처리하는 로직 
     * @param inval
     * @return
     */
    public static Boolean convertValToBoolean(String inval) {
        Boolean retval = null;
        try {
            retval = 
                "1".equals(inval)  ? Boolean.TRUE :
                "2".equals(inval) ? Boolean.FALSE :
                null;
            if (retval == null) {
	            retval = 
	                    Constants.TRUE_EVALUE.equals(inval)  ? Boolean.TRUE :  Boolean.FALSE  ;
            }
        } catch (Exception ex) {
        }
        return retval;
    }
    
    /**
     * 1,2로 예아니오 일경우 처리하는 로직 
     * @param inval
     * @return
     */
    public static String convertBooleanToVal(Boolean inval) {
        String retval = null;
        try {
        	  retval = Boolean.TRUE.equals(inval) ? "1" : "2" ; 
        } catch (Exception ex) {
        }
        return retval;
    }
    

    public static Boolean convertLongToBoolean(Long inval) {
        String strRetval = convertObjectToString(inval);
        Boolean retval = convertStringToBoolean(strRetval);
        return retval;
    }

    public static String convertBooleanToString(Boolean inval) {
        String retval = null;
        try {
              retval = Boolean.TRUE.equals(inval) ? Constants.TRUE_VALUE : Constants.FALSE_VALUE ; 
        } catch (Exception ex) {
        }
        return retval;
    }

    public static Long convertBooleanToLong(Boolean inval) {
        String strRetval = convertBooleanToString(inval);
        Long retval = convertStringToLong(strRetval);
        return retval;
    }

    public static String convertObjectToString(Object inval) {
        String retval = null;
        try {
            if ( inval!=null ) {
                retval = String.valueOf(inval);
            }
        } catch (Exception ex) {
        }
        return retval;
    }
    
  

    public static Object convertObjectValueToBaseModelValue(Object value, int type) {
        if ( value==null ) { 
            return null;
        }
        //In some conditions we must convert Object value to corresponding BaseModel value
        Object retval = value;
        switch ( type ) {
        case ColumnDef.TYPE_STRING:
//            retval = value;
//            break;
        case ColumnDef.TYPE_DOUBLE: 
//        	if ( value instanceof Double ) {
//       		 retval = value;
//       	} else   {
//       		retval = MSFSharedUtils.convertStringToDouble((String)value);
//              
//           }
//            break;
        case ColumnDef.TYPE_LONG:
//        	if ( value instanceof Long ) {
//       		 retval = value;
//       	} else   {
//       		retval = MSFSharedUtils.convertStringToLong((String)value); 
//           }
//            break;
        case ColumnDef.TYPE_DATE:
        case ColumnDef.TYPE_DATETIME: 
	        		 retval = value;  
        	break;
        case ColumnDef.TYPE_BIGDECIMAL:  //TODO - 추후적용할것.
        	if ( value instanceof java.math.BigDecimal ) {
                retval = String.valueOf(value) ;
            } else   {
                retval = MSFSharedUtils.convertStringToBigDecimal((String)value);
            }
            break;
        case ColumnDef.TYPE_BOOLEAN:
            if (        value instanceof String ) {
                retval = MSFSharedUtils.convertStringToBoolean((String)value);
            } else if ( value instanceof Long ) {
                retval = MSFSharedUtils.convertLongToBoolean((Long)value);
            }
            break;
        }
        return retval;
    } 
   
    
    /**
     * Check the type of the value and return corresponding ColumnDef TYPE. Returns 0 in zase of null.
     * @param value
     * @return
     */
    public static int getValueType(Object value) {
        if ( value==null ) {
            return 0;
        }
        int retval = 0;
        if (        value instanceof String ) {
            retval = ColumnDef.TYPE_STRING;
        } else if ( value instanceof Date ) {
            retval = ColumnDef.TYPE_DATE;
        } else if ( value instanceof Double ) {
            retval = ColumnDef.TYPE_DOUBLE;
        } else if ( value instanceof BigDecimal ) {
            retval = ColumnDef.TYPE_BIGDECIMAL;
        } else if ( value instanceof Long ) {
            retval = ColumnDef.TYPE_LONG;
        } else if ( value instanceof Boolean ) {
            retval = ColumnDef.TYPE_BOOLEAN;
        }
        return retval;
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
    
	/**
	 * 콤보박스의 선택된 Value 값을 리턴한다.
	 * @param comboBoxObj
	 * @param getSelectedText
	 * @return
	 */
	public static String getSelectedComboValue(ComboBox<BaseModel> comboBoxObj){
		String v = "";
		
		if(comboBoxObj != null && comboBoxObj.getValue() != null){
			v = comboBoxObj.getValue().get("commCd") == null ? "" : String.valueOf(comboBoxObj.getValue().get("commCd"));
		}
		
		return v;
	}
    
    //콤보박스 값 null 체크및 값가져오기 
    public static String getSelectedComboValue(ComboBox<BaseModel> objCombo, String getX){
		String value = "";
		if(objCombo != null && objCombo.getValue() != null){
			value = isNullAsString(objCombo.getValue().get(getX)) ? "" : objCombo.getValue().get(getX).toString();
		}
		return value;
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

    public static int occorrenze(String s, String c) {
        if (s.length()==0) return 0;
        else if (s.charAt(0)==c.charAt(0)) return 1 + occorrenze(s.substring(1),c);
        else return occorrenze(s.substring(1),c);
    }

    public static String getToken(String s, int token){
        int p;
        int q;
        String ss = vv (s);
        p = instr (ss, TableDef.SEPARATOR_CLIENT, 0, token) + 1;
        q = instr (ss, TableDef.SEPARATOR_CLIENT, p, 1) - p;
        return ss.substring(p, p+q);
    }

    public static String vv(String s) {
        String r = MSFSharedUtils.allowNulls(s);
        if ("".equals(r)) {
            return r;
        } else {
            r = adjustsColumnDefName(r);
            if (!r.substring(r.length()-1).equals(TableDef.SEPARATOR_CLIENT)){
                r = r+TableDef.SEPARATOR_CLIENT;
            }
            if (!r.substring(0,1).equals(TableDef.SEPARATOR_CLIENT)){
                r = TableDef.SEPARATOR_CLIENT+r;
            }
        }
        return r;
    }

    /**
     * Given a string containing package + className + methodName, returns the final token, i.e. the method name. 
     * @param methodName
     * @return
     */
    public static String getSimpleMethodName(String methodName) {
        if ( methodName!=null && methodName.indexOf(".")>0 ) {
            String simpleName = methodName.substring(methodName.lastIndexOf(".")+1);
            return simpleName;
        }
        return null;
    }

    public static String adjustsColumnDefName(String columnDefName) {
        if (MSFSharedUtils.paramNotNull(columnDefName)) {
            columnDefName = columnDefName.replace(".", TableDef.SEPARATOR_CLIENT);
        }
        return columnDefName;
    }

    public static int instr(String s, String v, int d, int p) {
        int e = d;
        for (int i=0;i<p;i++){
            d = s.indexOf(v, e);
            e = d+1;
        }
        return d;
    }

    /**
     * Gets an object and returns a toString(), trimmed from leading spaces, to uppercase. 
     * If a null is passed, null is returned.
     * @param o
     * @return
     */
    public static String toUpperCase(Object o) {
        return o==null ? null : o.toString().trim().toUpperCase();
    }

    /**
     * Gets an object and returns a toString(), trimmed from leading spaces, to lowercase. 
     * If a null is passed, null is returned.
     * @param o
     * @return
     */
    public static String toLowerCase(Object o) {
        return o==null ? null : o.toString().trim().toLowerCase();
    }

    public static String toInitCaps(String inputString, String delimiter) {
        StringBuffer result = new StringBuffer();
        if (inputString != null && inputString.length() > 0) {
            String[] strings = inputString.split(delimiter);
            for (String str : strings) {
                String f = str.trim();
                result.append(f.substring(0, 1).toUpperCase()).append(f.substring(1, f.length()).toLowerCase());
            }
        }
        return result.toString();
    }

    public static boolean objectEquals(Object o1, Object o2) {
        if ( o1 == o2 ) {
            return true;
        }
        if ( o1==null && o2==null ) {
            return true;
        }
        if ( o1!=null && o1.equals(o2) ) {
            return true;
        }
        if ( o2!=null && o2.equals(o1) ) {
            return true;
        }
        return false;
    }

    /**
     * Makes a round half up with precision 2 of the input parameter. Useful for EURO calculations.
     * Example usage:
     * 
     *   double v0 = 123.2254d;
     *   double v1 = 0.02233d;
     *   double v2 = 10.22d;
     *   double v3 = 123.0d;
     *   double v4 = 11.115011d;
     *   double v5;
     *
     *   round(d0)=123.23
     *   round(d1)=0.02
     *   round(d2)=10.22
     *   round(d3)=123.0
     *   round(d4)=11.12
     *
     *   v5 = (v0+v1-v2) / v1;
     *      = 5061.6986117;
     *   
     *   v5 = round((round(v0)+round(v1)-round(v2)) / v1);
     *      = 5061.80;
     * 
     * @param input
     * @return
     */
    public static double round(double input) {
        return round(input, 2);
    }

    /**
     * Makes a round half up with given precision of the input parameter.
     * @param input
     * @param precision
     * @return
     */
    public static double round(double input, int precision) {
        double factor = (double)Math.pow(10, precision);
        double dtmp = input * factor;
        long ltmp = Math.round(dtmp);
        double retval = (double) ltmp/factor;
        return retval;
    }

    public static String extractStackTrace(Exception e) {
        if (e==null) {
              return "";
        }
        try {
            StringBuffer sb = new StringBuffer();
            Object[] st = e.getStackTrace();
            for ( int i=0 ; i<st.length ; i++ ) {
                sb.append(st[i]+"\n");
            }
            return sb.toString();
        } catch (Exception ex) {
            return "" + e + " EXCEPTION EXTRACTING STACK-TRACE: " + ex;
        }
    }
    
    
    /**
 	 * DATE 날짜를 String 형으로 변경
 	 * @param date
 	 * @param patten
 	 * @return
 	 */
 	public static String getConvertDateToString(DateField date, String patten){
 		if(date.getValue() != null){
 			DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(patten);
 			return dateTimeFormat.format(date.getValue());
 		}else{
 			return "";
 		}
 	}
 	
 	 /**
 	  * 멀티 콤보로 선택된 값의 키를 스트링에 값을 대입
 	  * @param lsBmData 값을 구하고자 하는 listStore 
 	  * @param strValueData //멀티콤보의 디스플레이 값 
 	  * @param findNmKey //선택된  디스틀레이 값의 키 
 	  * @param findKey //BaseModel 가지고 오고자 하는 값의 키
 	  * @return
 	  */
 	 public static String getStrValToBMMultiCombo(ListStore<BaseModel> lsBmData, String strValueData, String findNmKey, String findKey) {
 	    
 	     String strReData = ""; 
 	     if (MSFSharedUtils.paramNotNull(strValueData)) {
 	         String[] ray = strValueData.substring(0, strValueData.length()).split(",");
 	         String chkkey = "";
 	         for (int i=0; i<ray.length; i++){ 
 	             BaseModel bmData = lsBmData.findModel(findNmKey, ray[i]);
 	             chkkey += bmData.get(findKey)+","; 
 	         }
 	         strReData = chkkey.substring(0,chkkey.length()-1);
 	     }  
 	    
 	     return strReData;
 	 } 
 	 
     /**
      * in조건 쿼리 를 위한 스트링으로 넘어온 데이터 를 list로 변환 하여 검색조건으로 넘기기 위한 처리 
      * @param strValue
      * @return
      */
     public static List<String> getStrToArrayList(String strValue) {
          
         List<String> listValue = new ArrayList<String>(); 
        
         String[] rayDeptCd = strValue.substring(0, strValue.length()).split(",");
         
         for (int i=0; i<rayDeptCd.length; i++){ 
             listValue.add(rayDeptCd[i]);
         }  
         
         return listValue;
         
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

//         Throwable[] suppressedExceptions = e.getSuppressed();
//         // Print suppressed exceptions indented one level deeper.
//         if (suppressedExceptions != null) {
//             for (Throwable throwable : suppressedExceptions) {
//                 sb.append(indent);
//                 sb.append("\tSuppressed: ");
//                 sb.append(getStackTraceString(throwable, indent + "\t"));
//             }
//         }

         Throwable cause = ex.getCause();
         if (cause != null) {
             sb.append(indent);
             sb.append("Caused by: ");
             sb.append(getStackTraceString(cause, indent));
         }

         return sb.toString();
     }

}
