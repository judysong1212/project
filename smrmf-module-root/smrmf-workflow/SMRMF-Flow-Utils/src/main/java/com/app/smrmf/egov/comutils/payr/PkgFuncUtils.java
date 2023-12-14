/**
* <pre>
* 1. 프로젝트명 : SMRMF-Pkg-Package-2.2.0
* 2. 패키지명(또는 디렉토리 경로) : com.app.smrmf.utils
* 3. 파일명 : PkgFuncUtils.java
* 4. 작성일 : 2017. 1. 15. 오전 2:45:24
* 5. 작성자 : atres-pc
* 6. 설명 :  패키지 jar나 기타 패키지를 호출한 메서드 등에서 사용되는 공통 유틸리티 모음. 
* </pre>
*/
package com.app.smrmf.egov.comutils.payr;

import java.io.UnsupportedEncodingException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <pre>
 * 1. 패키지명 : com.app.smrmf.utils
 * 2. 타입명 : PkgFuncUtils.java
 * 3. 작성일 : 2017. 1. 15. 오전 2:45:24
 * 4. 작성자 : atres-pc
 * 5. 설명 :
 * </pre>
 */
public class PkgFuncUtils { 
	
  /**
   * 	
   * <pre>
   * 1. 개요 : xml 파일의 태크 엘림먼트의 노드 값을 반환 
   * 2. 처리내용 : 
   * </pre>
   * @Method Name : getTagValue
   * @date : 2017. 1. 15.
   * @author : atres-pc
   * @history : 
   *	-----------------------------------------------------------------------
   *	변경일				작성자						변경내용  
   *	----------- ------------------- ---------------------------------------
   *	2017. 1. 15.		atres-pc				최초 작성 
   *	-----------------------------------------------------------------------
   * 
   * @param sTag
   * @param eElement
   * @return
   */
  public static String getXmlTagValue(String sTag, Element eElement) {
		
   	 NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
   	Node nValue  = null;
   	
   	 if (nlList.item(0) != null) {
   		nValue = (Node) nlList.item(0);
   	 }
   	 
   	 if (nValue == null) {
   		 return "";
   	 }
   	 
   	 return nValue.getNodeValue();
  }
  
  

	 /**
	 * 양쪽으로 자리수만큼 문자 채우기
	 *
	 * @param   str         원본 문자열
	 * @param   size        총 문자열 사이즈(리턴받을 결과의 문자열 크기)
	 * @param   strFillText 원본 문자열 외에 남는 사이즈만큼을 채울 문자
	 * @return  
	 * @throws UnsupportedEncodingException 
	 */
  public static String getCPad(String str, int size, String strFillText)  {
	    int intPadPos = 0;
	    for(int i = (str.getBytes()).length; i < size; i++) {
	        if(intPadPos == 0) {
	            str += strFillText;
	            intPadPos = 1;
	        } else {
	            str = strFillText + str;
	            intPadPos = 0;
	        }
	    }
	    return str;
	}
	
	
	/**
	 * 왼쪽으로 자리수만큼 문자 채우기
	 *
	 * @param   str         원본 문자열
	 * @param   size        총 문자열 사이즈(리턴받을 결과의 문자열 크기)
	 * @param   strFillText 원본 문자열 외에 남는 사이즈만큼을 채울 문자
	 * @return  
	 * @throws UnsupportedEncodingException 
	 */
  public static String getLPad(String str, int size, String strFillText) {
	    for(int i = (str.getBytes()).length; i < size; i++) {
	        str = strFillText + str;
	    }
	    return str;
	}
	
	
	/**
	 * 오른쪽으로 자리수만큼 문자 채우기
	 *
	 * @param   str         원본 문자열
	 * @param   size        총 문자열 사이즈(리턴받을 결과의 문자열 크기)
	 * @param   strFillText 원본 문자열 외에 남는 사이즈만큼을 채울 문자
	 * @return  
	 * @throws UnsupportedEncodingException 
	 */
  public static String getRPad(String str, int size, String strFillText)   {
	    for(int i = (str.getBytes()).length; i < size; i++) {
	        str += strFillText;
	    }
	    return str;
	}
	
  public static  String subStringBytes(String str, int byteLength) {   
		 // String 을 byte 길이 만큼 자르기.    
			 return lengthLimit(str, byteLength, ' ');   
		
	}
  
  public static  String subStringUtfBytes(String str, int byteLength,char byteType) {   
		 // String 을 byte 길이 만큼 자르기.    
			 return lengthLimit(str, byteLength, byteType);   
		
	}
  /**
 	 * 한글 가변길이 처리 2byte, 3byte 기타 양쪽으로 자리수만큼 문자 채우기
 	 *
 	 * @param   str         원본 문자열
 	 * @param   size        총 문자열 사이즈(리턴받을 결과의 문자열 크기)
 	 * @param   strFillText 원본 문자열 외에 남는 사이즈만큼을 채울 문자
 	 * @return  
 * @throws UnsupportedEncodingException 
 	 */
   public static String getCHanPad(String str, int size, String strFillText)  {
	   
	   int f_len = bytesLenHan(str);
 	    int intPadPos = 0;
 	    for(int i = (str.getBytes()).length; i < (size + f_len); i++) {
 	        if(intPadPos == 0) {
 	            str += strFillText;
 	            intPadPos = 1;
 	        } else {
 	            str = strFillText + str;
 	            intPadPos = 0;
 	        }
 	    }
 	    return str;
 	}
 	
  /**
	 * 한글 가변길이 처리 2byte, 3byte 기타왼쪽으로 자리수만큼 문자 채우기 한글처리시 사용되는것.
	 *
	 * @param   str         원본 문자열
	 * @param   size        총 문자열 사이즈(리턴받을 결과의 문자열 크기)
	 * @param   strFillText 원본 문자열 외에 남는 사이즈만큼을 채울 문자
	 * @return  
 * @throws UnsupportedEncodingException 
	 */
public static String getLHanPad(String str, int size, String strFillText) {
	   
	    int f_len = bytesLenHan(str);
	    for(int i = (str.getBytes()).length; i < (size + f_len); i++) {
	        str = strFillText + str;
	    }
	    return str;
	}
	
	
	/**
	 * 한글 가변길이 처리 2byte, 3byte 기타오른쪽으로 자리수만큼 문자 채우기
	 *
	 * @param   str         원본 문자열
	 * @param   size        총 문자열 사이즈(리턴받을 결과의 문자열 크기)
	 * @param   strFillText 원본 문자열 외에 남는 사이즈만큼을 채울 문자
	 * @return  
	 * @throws UnsupportedEncodingException 
	 */
public static String getRHanPad(String str, int size, String strFillText) {
	
	    int f_len = bytesLenHan(str);
	    
	    for(int i = (str.getBytes()).length; i < (size + f_len); i++) {
	        str += strFillText;
	        
	    }
	    return str;
	}

  public static int bytesLenHan(String str) { 
	    
	    int f_str_len = 0;
	    String hanByte = "한"; //글자길이 체크를 위해 추가 
	  
	   
			    int hanNum = hanByte.getBytes().length == 3 ? 3 : 2;
	 	   		byte[] bytes = str.getBytes(); 
		 
				int len = bytes.length; 
				 
				int counter = 0; 
			//	if (length >= len) { 
			//		StringBuffer sb = new StringBuffer();
			//		sb.append(str);
			//		for(int i=0;i<length-len;i++){
			//		sb.append(' ');
			//		}
			//		return sb.toString(); 
			//	} 
				for (int i = len - 1; i >= 0; i--) { 
					if (((int)bytes[i] & 0x80) != 0) 
					counter++; 
					 
				}
				
			
				if(hanNum == 3){
					f_str_len = counter / hanNum;
					 
				}else if(hanNum == 2){
					f_str_len = 0;
					 
				}else{
					f_str_len = 0;
					 
				}
	 
		return f_str_len; 
	}
	
	
	/** 
	* 스트링 자르기
	* 지정한 정수의 개수 만큼 빈칸(" ")을 스트링을 구한다. 
	* 절단된 String의 바이트 수가 자를 바이트 개수를 넘지 않도록 한다. 
	* 
	* @param str 원본 String 
	* @param int 자를 바이트 개수 
	* @param char +1 or -1 
	* @return String 절단된 String 
	*/ 
  public static String lengthLimit(String str, int length ,char type) { 
		
	    String hanByte = "한"; //글자길이 체크를 위해 추가  
	    String f_str = null;
	    
	 
			    int  hanNum = hanByte.getBytes().length == 3 ? 3 : 2;
				byte[] bytes = str.getBytes(); 
				int len = bytes.length; 
				int counter = 0; 
				if (length >= len) { 
				StringBuffer sb = new StringBuffer();
				sb.append(str);
				for(int i=0;i<length-len;i++){
				sb.append(' ');
				}
				return sb.toString(); 
				} 
				for (int i = length - 1; i >= 0; i--) { 
				if (((int)bytes[i] & 0x80) != 0) 
				counter++; 
				}
				
				if(type == '+'){
				f_str = new String(bytes, 0, length + (counter % hanNum));
				}else if(type == '-'){
				f_str = new String(bytes, 0, length - (counter % hanNum));
				}else{
				f_str = new String(bytes, 0, length - (counter % hanNum));
				}
				
	 
		return f_str; 
	}
	
//	public static String lengthLimit(String inputStr, int limit, String fixStr) {
//     if (inputStr == null)
//         return "";
//     if (limit <= 0)
//         return inputStr;
//     byte[] strbyte = null;
//     strbyte = inputStr.getBytes();
//
//     if (strbyte.length <= limit) {
//         return inputStr;
//     }
//     char[] charArray = inputStr.toCharArray();
//     int checkLimit = limit;
//     for ( int i = 0 ; i < charArray.length ; i++ ) {
//         if (charArray[i] < 256) {
//             checkLimit -= 1;
//         }
//         else {
//             checkLimit -= 2;
//         }
//         if (checkLimit <= 0) {
//             break;
//         }
//     }
//     //대상 문자열 마지막 자리가 2바이트의 중간일 경우 제거함
//     byte[] newByte = new byte[limit + checkLimit];
//     for ( int i = 0 ; i < newByte.length ; i++ ) {
//         newByte[i] = strbyte[i];
//     }
//     if (fixStr == null) {
//         return new String(newByte);
//     }
//     else {
//         return new String(newByte) + fixStr;
//     }
//		}
	
  
  public static String encode(String str, String charset) {
      StringBuilder sb = new StringBuilder();
      try {
          byte[] key_source = str.getBytes(charset);
          for(byte b : key_source) {
              String hex = String.format("%02x", b).toUpperCase();
              sb.append("%");
              sb.append(hex);
          }
      } catch(UnsupportedEncodingException e) { }//Exception
      return sb.toString();
  }
   
  public static String decode(String hex, String charset) {
      byte[] bytes = new byte[hex.length()/3];
      int len = hex.length();
      for(int i = 0 ; i < len ;) {
          int pos = hex.substring(i).indexOf("%");
          if(pos == 0) {
              String hex_code = hex.substring(i+1, i+3);
              bytes[i/3] = (byte)Integer.parseInt(hex_code, 16);
              i += 3;
          } else {
              i += pos;
          }
      }
      try {
          return new String(bytes, charset);
      } catch(UnsupportedEncodingException e) { }//Exception
      return "";
  }
   
  public static String changeCharset(String str, String charset) {
      try {
          byte[] bytes = str.getBytes(charset);
          return new String(bytes, charset);
      } catch(UnsupportedEncodingException e) { }//Exception
      return "";
  }
  	
}
