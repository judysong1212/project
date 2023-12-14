/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.prgm.client.languages;

import com.google.gwt.core.client.GWT;

public interface PrgmConstants extends PrgmComConstants {
    
    public static final PrgmConstants INSTANCE = (PrgmConstants) GWT.create(PrgmConstants.class);

    //Window 타이틀 설정
//    String title_TableWithLov(); 
    
//    //Labels
//    String lbl_Id(); 
    
    String title_SysPayr0400TypOccuCd();
    
    String titleSysComPopUpPayr0470();
    
    String titleSysComPopUpPayr0480();
    
    
    
}
