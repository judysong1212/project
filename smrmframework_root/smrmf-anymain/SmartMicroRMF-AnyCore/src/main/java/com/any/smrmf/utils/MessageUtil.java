package com.any.smrmf.utils;


import javax.servlet.http.HttpServletRequest;

import com.any.smrmf.cons.AnyAttrKey;


public class MessageUtil {


   public static void saveMessage(HttpServletRequest request, String code, Object... params){
      request.setAttribute(AnyAttrKey.REQ_MSG_CODE, code);
      request.setAttribute(AnyAttrKey.REQ_MSG_PARAMS, params);
   }
}
