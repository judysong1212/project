package org.msf.utils;

public class StringAnyUtil {

   
   public static boolean isEmpty(String str){
      return ((str == null)||(str.isEmpty()));
   }
   
   public static boolean isEmptyOrWhitespace(String str){
      return (isEmpty(str) || (str.trim()).isEmpty());
   }
   
}
