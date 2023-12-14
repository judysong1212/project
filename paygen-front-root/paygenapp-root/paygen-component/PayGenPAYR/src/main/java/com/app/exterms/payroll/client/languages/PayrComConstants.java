/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.payroll.client.languages;

import com.google.gwt.i18n.client.Constants;

public interface PayrComConstants extends Constants {

   // public static final PayrComConstants INSTANCE = (PayrComConstants) GWT.create(PayrComConstants.class);

    /*
     * List of all titles
     */

	@DefaultStringValue("근로소득간이세액표")   
	String titlePayr0100();
	
	@DefaultStringValue("개별공제")
	String titlePayr0200();	
	
	@DefaultStringValue("채권압류")  
	String titlePayr0220();	
	
	@DefaultStringValue("급여스케줄") 
	String titlePayr0250();	
	
	@DefaultStringValue("급여마스터") 
	String titlePayr0300();	
	
	@DefaultStringValue("월급여내역")  
	String titlePayr0301();	
	
	@DefaultStringValue("월급여_항목") 
	String titlePayr0302();
	
	@DefaultStringValue("월소급_항목")  
	String titlePayr0303();	
	
	@DefaultStringValue("월급여내역_개인")  
	String titlePayr0304();	
	
	@DefaultStringValue("근로소득간이세액표산출값") 
	String titlePayr0305();	
	
	@DefaultStringValue("월급여_가족사항") 
	String titlePayr0306();	
	
	@DefaultStringValue("월급여조정이력") 
	String titlePayr0307();	
	
	@DefaultStringValue("월소급설정")     
	String titlePayr0350();	
	
	@DefaultStringValue("직종_등급맵핑_공무직")  
	String titlePayr0400();	
	
	@DefaultStringValue("급여항목_공무직")  
	String titlePayr0410();	
	
	@DefaultStringValue("급여항목마스터_공무직")  
	String titlePayr0415();	
	
	@DefaultStringValue("직종별급여산정기준_공무직") 
	String titlePayr0420();	
	
	@DefaultStringValue("직종_등급맵핑상세_공무직") 
	String titlePayr0430();	
	
	@DefaultStringValue("급여단가표_공무직") 
	String titlePayr0440();	
	
	@DefaultStringValue("급여항목별수당")  
	String titlePayr0450();	
    
	@DefaultStringValue("급여항목별직책_직종세수당")
	String titlePayr0460();	
    
	@DefaultStringValue("급여공제")    
	String titlePayr0470();	
    
	@DefaultStringValue("급여수당")     
	String titlePayr0480();	
    
	@DefaultStringValue("급여단가표_기간제") 
	String titlePayr0490();	
    
	@DefaultStringValue("급여인사마스터") 
	String titlePayr0500();	
    
	@DefaultStringValue("개별지급공제항목")
	String titlePayr0520();	
    
	@DefaultStringValue("급여가족사항_학비보조") 
	String titlePayr0530();	
    
	@DefaultStringValue("급여예외처리")   
	String titlePayr0540();	
    
	@DefaultStringValue("일용근로소득지급기본명세")   
	String titlePayr0600();	
    
	@DefaultStringValue("일용근로소득지급상세명세")  
	String titlePayr0650();	
    
	@DefaultStringValue("원천징수영수증발급")  
	String titlePayr0900();
    
	

	
	
    /*
     * List of all labels
     */
//    @DefaultStringValue("Employee Id")
//    String employeeId();
     
}
