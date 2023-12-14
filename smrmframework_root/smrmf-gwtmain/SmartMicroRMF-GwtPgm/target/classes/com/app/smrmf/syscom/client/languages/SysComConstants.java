/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.syscom.client.languages;

import com.google.gwt.core.client.GWT;

public interface SysComConstants extends SysCommConstants {
    
    public static final SysComConstants INSTANCE = (SysComConstants) GWT.create(SysComConstants.class);

    //Window 타이틀 설정
//    String title_TableWithLov(); 
    
//    //Labels
//    String lbl_Id(); 
    
    String title_SysPayr0400TypOccuCd();
    
    String titleSysComPopUpPayr0470();
    
    String titleSysComPopUpPayr0480();
    
    
    
}
