/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.diligence.shared;

public interface DiligenceDaoConstants extends DiligenceDaoConstantsGenerated {

    //public static final String CUSTOM_METHOD_EmployeesWithSize_List = "com.app.exterms.basis.server.services.EmployeesCustomService.getList";

    //public static final String CUSTOM_METHOD_JobHistory_List = "com.app.exterms.basis.server.services.JobHistoryCustomService.getList";
    //public static final String CUSTOM_METHOD_JobHistory_Save = "com.app.exterms.basis.server.services.JobHistoryCustomService.save";
	
	/* 근태월별집계 인쇄 */
	public static final String CLASS_DLGNP030001TODLGN0300_DAO_LIST	= "com.app.exterms.diligence.server.service.DlgnP030001ServiceImpl.getDlgnP030001ToDlgn0300DataList";
	
	
    /** 복무통합관리 근로자정보 조회 **/
    public static final String CLASS_DLGN0230_MEMBER_LIST =  "com.app.exterms.diligence.server.service.Dlgn0230ServiceImpl.getDlgn0100MemberList";
    
    
    /** 복무통합관리 기본근무 조회 **/
    public static final String CLASS_DLGN0230_TO_DLGN0100_LIST =  "com.app.exterms.diligence.server.service.Dlgn0230ServiceImpl.getDlgn0230ToDlgn0100List";
    
    /** 복무통합관리 초과근무 조회 **/
    public static final String CLASS_DLGN0230_TO_DLGN0200_LIST =  "com.app.exterms.diligence.server.service.Dlgn0230ServiceImpl.getDlgn0230ToDlgn0200List";
    
	
}