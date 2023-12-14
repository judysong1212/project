/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.shared;


public interface MSFConfiguration {

    public static final String PROP_FORM_BINDING  = "formBinding";
    public static final String PROP_FORM_PARENT   = "formParent";

    public static final String REQ_ATTR_LOCALE  = "locale";

    public static final String PAYGEN_SESSION_LOCALE = "locale";
    public static final String PAYGEN_SESSION_USER   = "extermuser";
    public static final String PAYGEN_SESSION_AUTH   = "extermAuth";  //TODO 차후에 분리 현재 그냥 넘김.
    public static final String PAYGEN_SESSION_SSO   = "ssoxuser"; 
     

    /**
     * This is used to stop the call to the server
     */
    public static final String CUSTOM_SERVICE_SKIP_CALL                 = "SKIP_CALL";
    public static final String CUSTOM_SERVICE_DATA_HISTORY_LIST         = "com.app.smrmf.core.msfmainapp.server.service.impl.DataHistoryCustomServiceImpl.getList";
    public static final String CUSTOM_SERVICE_DATA_HISTORY_SUMMARY_INFO = "com.app.smrmf.core.msfmainapp.server.service.impl.DataHistoryCustomServiceImpl.getSummaryInfo";

    public static final int HISTORIZABLE_DAO_NONE = 0;
    public static final int HISTORIZABLE_DAO_FULL = 1;
    public static final int HISTORIZABLE_DAO_LITE = 2;
    
    public static final String DATA_HISTORY_USER_INSERT          = "dataHistoryUserInsert";
    public static final String DATA_HISTORY_USER_UPDATE          = "dataHistoryUserUpdate";
    public static final String DATA_HISTORY_DATE_INSERT          = "dataHistoryDateInsert";
    public static final String DATA_HISTORY_DATE_UPDATE          = "dataHistoryDateUpdate";
     
    
    public final static String RDA_DIR_PATH_CHAR = "/";                                                        //파일경로 구분자    
    
    
    /***************************************************************/
    //CLIENT/ SERVER 동시사용하는 업무 코드 선언변수
    /***************************************************************/ 
    //TODO 권한 설정에 따른 정보 추후 수정
    public static final String AUTH_USR_DIV_10 = "D0010010";   // D001    0010    무기계약직업무담당자
    public static final String AUTH_USR_DIV_20 = "D0010020";   // D001    0020    기간제업무담당자
    public static final String AUTH_USR_DIV_25 = "D0010025";  //  D001    0025    [겸직]무기계약직기간제담당자
    public static final String AUTH_USR_DIV_30 = "D0010030";   // D001    0030    무기계약직총괄업무담당자
    public static final String AUTH_USR_DIV_40 = "D0010040";   // D001    0040    기간제총괄업무담당자
    public static final String AUTH_USR_DIV_60 = "D0010060";   // D001    0060    총괄업무담당자
    public static final String AUTH_USR_DIV_70 = "D0010070";   // D001    0070    무기계약직근로자
    public static final String AUTH_USR_DIV_80 = "D0010080";   // D001    0080    기간제근로자
    public static final String AUTH_USR_DIV_90 = "D0010090";   // D001    0090    마스터관리자
    
    
    public static final String PAYGEN_INFO      = "정보";
    public static final String PAYGEN_WORN      = "경고";
    public static final String PAYGEN_CONFIRM   = "확인";
    public static final String PAYGEN_ERROR     = "에러"; 
     
    
    /*************************공통코드 고용구분 권한설정처리를 위한 선언 ***************************/
    public static final String EMYMT_DA002 = "A002"; //권한설정처리를 위한 선언
    //고용구분 
    public static final String EMYMT_DIVCD01 = "A0020010";  //무기계약직
    public static final String EMYMT_DIVCD02 = "A0020020";  //기간제  
    
    //권한설정 부분 직종에 따른 권한 추가 
   // public static final String AUTH_TYPOCCUCD_10 = "A0410117A0060000";   // 환경미화원
    
   //sso 사용여부 확인을 위한 설정값  SSOX, NONE 설정 
    public static final String AUTH_SSOX_USE_TYPE = "SSOX";  
     
}
