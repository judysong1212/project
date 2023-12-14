package com.app.smrmf.core.msfmainapp.client.exceptions;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bord0400VO.java
 * @Description : Bord0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ShowMessageBM  extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
   
    /** set 구분 : division */
    public static final String ATTR_DIVISION = "division";

    /** set 메뉴  : menu */
    public static final String ATTR_MENU = "menu";

    /** set 단계  : phase */
    public static final String ATTR_PHASE = "phase";

    /** set 메시지 : message */
    public static final String ATTR_MESSAGE = "message";

    /** set 발생일시  : messageDttm */
    public static final String ATTR_MESSAGEDTTM = "messageDttm";
    
    /** set 설명  : content */
    public static final String ATTR_CONTENT = "content";
 
    /** set 화면명  : windowNm */
    public static final String ATTR_WINDOWNM = "windowNm";
    
    /** set 화면아이디  : windowId */
    public static final String ATTR_WINDOWID = "windowId";
      
    /** set 화면아이디  : stackTraceContent */
    public static final String ATTR_STACKTRACECONTENT = "stackTraceContent";
      
    
    /** 생성자 */
     public ShowMessageBM() { super(); } 

    /** 일괄등록 처리   */
     public ShowMessageBM(
              String  division  
            , String  menu  
            , String  phase 
            , String  message 
            , String  content ) { 
        values.put(ATTR_DIVISION,division);
        values.put(ATTR_MENU,menu); 
        values.put(ATTR_PHASE,phase);
        values.put(ATTR_MESSAGE,message);
        values.put(ATTR_CONTENT,content);
       } 
 
     
	/** set 구분 : division */
    public void setDivision(String  division) { set( ATTR_DIVISION ,division);}
    /** get 구분 : division */
    public String  getDivision() { return (String )get( ATTR_DIVISION );}
 
    /** set 메뉴_UID : menu */
    public void setMenu(String  menu) { set( ATTR_MENU ,menu);}
    /** get 메뉴_UID : menu */
    public String  getMenu() { return (String )get( ATTR_MENU );}

    /** set 단계ID : phase */
    public void setPhase(String  phase) { set( ATTR_PHASE ,phase);}
    /** get 단계ID : phase */
    public String  getPhase() { return (String )get( ATTR_PHASE );}

    /** set 파일 이름 : message */
    public void setMessage(String  message) { set( ATTR_MESSAGE ,message);}
    /** get 파일 이름 : message */
    public String  getMessage() { return (String )get( ATTR_MESSAGE );}

    /** set 파일 크기 : content */
    public void setContent(String  content) { set( ATTR_CONTENT ,content);}
    /** get 파일 크기 : content */
    public String  getContent() { return (String )get( ATTR_CONTENT );}
    
    
    /** set 파일 크기 : stackTraceContent */
    public void setStackTraceContent(String  stackTraceContent) { set( ATTR_STACKTRACECONTENT ,stackTraceContent);}
    /** get 파일 크기 : stackTraceContent */
    public String  getStackTraceContent() { return (String)get( ATTR_STACKTRACECONTENT );}
    
    /** set  발생일시  : messageDttm */
    public void setMessageDttm(String  messageDttm) { set( ATTR_MESSAGEDTTM ,messageDttm);}
    /** get  발생일시  : messageDttm */
    public String  getMessageDttm() { return (String )get( ATTR_MESSAGEDTTM );} 
    
    /** set 화면명  : windowNm  */
    public void setWindowNm(String  windowNm) { set( ATTR_WINDOWNM ,windowNm);}
    /** get 화면명  : windowNm  */
    public String  getWindowNm() { return (String )get( ATTR_WINDOWNM );} 
      
    /** set 화면아이디  : windowId */
    public void setWindowId(String  windowId) { set( ATTR_WINDOWID ,windowId);}
    /** get 화면아이디  : windowId */
    public String  getWindowId() { return (String )get( ATTR_WINDOWID );}
      
}
