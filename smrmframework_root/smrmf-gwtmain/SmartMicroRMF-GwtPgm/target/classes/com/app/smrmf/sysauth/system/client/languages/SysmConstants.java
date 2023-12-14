/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.sysauth.system.client.languages;

import com.google.gwt.core.client.GWT;

public interface SysmConstants extends SysmComConstants {
    
    public static  SysmConstants INSTANCE = (SysmConstants) GWT.create(SysmConstants.class);

    //Window titles
    String title_Sysm0100();
    String title_Sysm0200();
    String title_Sysm0300(); 
   
    
    String title_Sysm0400();
    String title_Sysm0500(); 
    
    String title_Cmmn0310();
    String title_Cmmn0320();
    
    /*
     * 팝업리스트 타이틀명칭 설정 
     */ 
    @DefaultStringValue("인사검색")
    String titleSysComPopUpPsnl0100(); 
    
    @DefaultStringValue("직종검색")
    String titleSysComComboBass0320(); 
     
    //Labels
   // String lbl_Id();
   
}
