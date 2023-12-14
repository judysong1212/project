/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.retirement.shared;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface InfcPkgRemtDaoConstants extends InfcPkgRemtDaoConstantsGenerated {

	 
	
	public static final String CLASS_REMT3500_PAYR4100_DATA_LIST  = "com.app.exterms.payroll.server.service.Payr4100ServiceImpl.getSelectPayr4100ToRemt3500List"; //퇴직정산항목 
	
	
	
	 /** 
     * 퇴직금계산 대상자 조회
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
	public static final String CLASS_SYSCOM_PSNL0100_REMT0100_DATALIST  = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getPayr8500ToPsnl0100ToRemt0100DataList"; //퇴직정산항목
	
	
	/**
	  * 최근 3개월간 기본급여 및 제수당 
	  * @param serviceParameters
	  * @return
	  * @throws MSFException
	  */
	public static final String CLASS_REMT0100_REMT2200_DATALIST  = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getSelectPayrToRemtRemt2200List"; 
	
	 /**
	  * 최근 3개월간 기본급여 및 제수당 
	  * @param serviceParameters
	  * @return
	  * @throws MSFException
	  */
	public static final String CLASS_REMTWFEP0100_REMT2200_DATALIST  = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getSelectRemtWfep0100ToRemtRemt2200List"; 
}
