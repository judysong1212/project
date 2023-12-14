/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.languages;
 

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public interface MSFConstants extends Constants {	
    
    public static final MSFConstants INSTANCE = (MSFConstants) GWT.create(MSFConstants.class);
    
    String titlePopUpPsnl0100();
    
    //  Campi Comuni	
    String Separatore();	
    String CampoObbligatorio();
    String RegExMessage();

    // Button
    String BtConferma();
    String BtSave();
    String BtDelete();
    String BtRefresh();
    String BtOrdinamento();
    String BtNuovo();
    String BtNew();
    String BtModification();
    String BtCancel();
    String BtStampa();     
    String BtLogIn();
    String BtLogOut();
    String BtnSearch();
    String MenuReload();
    String ShowHistoryLite();

    // Intestazione finestra
    String ExceptionTitleService();
    String msgErrorServiceInvocationTitoloService();
    String Alert();
    String Errore();
    String Messaggio();    
    String Uscita();
    String TitleDataHistory();

    // Description messaggio
    
    String VecchiaPwdUgualeNuova();
    String NuovaPwdConferma(); 
    String OldPwdNotCorrect();
    String MessaggioUscita();
    String PasswordAggiornata();
    String SessioneNonValida();
    String NoSavePwd();
    String PwddateChange(); // 추가 hieju_06.15
    String NotUser(); 
    String LockId(); // 추가 hieju_06.26
    String PwdnewChange();

    //  Label 
    String CambiaPwd();
    String UserId(); // id추가
    String OldPwd();
    String NewPwd();
    String ConPwd();
    String Filtro();
    String LblHistoryUser();
    String LblHistoryDate();
    String LblHistoryOperation();
    String LblTrue();
    String LblFalse();
    String LblAll();

    // Hibernate
    
    String ConcurrentLoginBlocked();
    String CurrentPasswordMismatch();// 비밀번호가 일치하지 않음
    String PasswordChanged(); // 비밀번호 변경 성공
    String PassWordPatternErrata(); // 비밀번호는 한글, 영문, 특수문자로 구성되어야하며 9자 이상 
    String LoginCanceled(); // 로그인 취소
    String PassWordErrata();
    String ErroreGenerico();	
    String UserNonEsiste();

    // Formatter
    String DateFormat();
    String DateTimeFormat();
    
    
    /*
     * 팝업리스트 타이틀명칭 설정 
     */ 
    @DefaultStringValue("인사검색")
    String titleSysComPopUpPsnl0100(); 
    
    @DefaultStringValue("직종검색")
    String titleSysComComboBass0320();

	

}
