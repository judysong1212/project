/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto.system; 

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Sysm0100VO.java
 * @Description : Sysm0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MSFAuthCheckBM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
  
 			
    private static final String ATTR_DPOBCD          = "dpobCd";        //사업장코드
    private static final String ATTR_SYS_DIV_CD      = "sysDivCd";      //시스템코드 
    private static final String ATTR_USR_ID     		= "usrId"; 
    private static final String ATTR_USR_DIV_CD      = "usrDivCd";
    
    
    
    private static final String ATTR_AUTHCHECK01    = "authCheck01"; //단위기관 
    private static final String ATTR_AUTHCHECK02    = "authCheck02";  //고용구분
    private static final String ATTR_AUTHCHECK03    = "authCheck03";  //부서
    private static final String ATTR_AUTHCHECK04    = "authCheck04";  //직종
    private static final String ATTR_AUTHCHECK05    = "authCheck05";  //직종세
    private static final String ATTR_AUTHCHECK06    = "authCheck06";   //사업
    private static final String ATTR_AUTHCHECK07    = "authCheck07";  //""
    private static final String ATTR_AUTHCHECK08    = "authCheck08";
    private static final String ATTR_AUTHCHECK09    = "authCheck09";
    private static final String ATTR_AUTHCHECK10    = "authCheck10";
    
    public MSFAuthCheckBM() {
        super();
    }
    
   
//    public MSFAuthCheckBM(
//    		String dpobCd,
//            String sysDivCd,   
//            String usrId, 
//            String usrDivCd,
//            String authCheck01,
//            String authCheck02,
//            String authCheck03,
//            String  authCheck04 ,
//            String  authCheck05 ,
//            String  authCheck06,
//            String  authCheck07 ,
//            String authCheck08,
//            String authCheck09,
//            String authCheck10 ) {
//        this(dpobCd,sysDivCd,  usrId  
//                , usrDivCd 
//                , authCheck01 , authCheck02 , authCheck03 , authCheck04 , authCheck05
//                , authCheck06 , authCheck07 , authCheck08 , authCheck09 , authCheck10);
//    }

    public MSFAuthCheckBM(
    		  String dpobCd,
    		  String sysDivCd,  
              String usrId, 
              String usrDivCd,
              String authCheck01,
              String authCheck02,
              String authCheck03,
              String  authCheck04 ,
              String  authCheck05 ,
              String  authCheck06 ,
              String  authCheck07 ,
              String authCheck08,
              String authCheck09,
              String authCheck10 ) {
    	values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_SYS_DIV_CD,sysDivCd); 
        values.put(ATTR_USR_ID,usrId); 
        values.put(ATTR_USR_DIV_CD,usrDivCd); 
        values.put(ATTR_AUTHCHECK01,authCheck01);
        values.put(ATTR_AUTHCHECK02,authCheck02);
        values.put(ATTR_AUTHCHECK03,authCheck03);
        values.put(ATTR_AUTHCHECK04,authCheck04);
        values.put(ATTR_AUTHCHECK05,authCheck05); 
        values.put(ATTR_AUTHCHECK06,authCheck06); 
        values.put(ATTR_AUTHCHECK07,authCheck07);
        values.put(ATTR_AUTHCHECK08,authCheck08);
        values.put(ATTR_AUTHCHECK09,authCheck09); 
        values.put(ATTR_AUTHCHECK10,authCheck10); 
    } 
       
    public String getDpobCd() {
   	 Object value = values.get(ATTR_DPOBCD);
        return (String)value;
	}

	public void setDpobCd(String dpobCd) {
		 values.put(ATTR_DPOBCD, dpobCd);
	}

	public String getSysDivCd() {
       Object value = values.get(ATTR_SYS_DIV_CD);
       return (String)value;
   }

   public void setSysDivCd(String sysDivCd) {
       values.put(ATTR_SYS_DIV_CD, sysDivCd);
   }
   
   
   public void setUsrId(String usrId) {
       values.put(ATTR_USR_ID, usrId);
   }

   public String getUsrId() {
       Object value = values.get(ATTR_USR_ID);
       return (String)value;
   } 

   public String getUsrDivCd() {
       Object value = values.get(ATTR_USR_DIV_CD);
       return (String)value;
   }
    

 
public void setAuthCheck01(String  authCheck01) {
	values.put(ATTR_AUTHCHECK01 ,authCheck01); 
	}
 
  public String  getAuthCheck01() { 
	 Object value = values.get(ATTR_AUTHCHECK01);
     return (String)value; 
	}
  

public void setAuthCheck02(String  authCheck02) {
	values.put(ATTR_AUTHCHECK02 ,authCheck02); 
	}
 
  public String  getAuthCheck02() { 
	 Object value = values.get(ATTR_AUTHCHECK02);
     return (String)value; 
	}
  

public void setAuthCheck03(String  authCheck03) {
	values.put(ATTR_AUTHCHECK03 ,authCheck03); 
	}
 
  public String  getAuthCheck03() { 
	 Object value = values.get(ATTR_AUTHCHECK03);
     return (String)value; 
	}
  

public void setAuthCheck04(String  authCheck04) {
	values.put(ATTR_AUTHCHECK04 ,authCheck04); 
	}
 
  public String  getAuthCheck04() { 
	 Object value = values.get(ATTR_AUTHCHECK04);
     return (String)value; 
	}
  

public void setAuthCheck05(String  authCheck05) {
	values.put(ATTR_AUTHCHECK05 ,authCheck05); 
	}
 
  public String  getAuthCheck05() { 
	 Object value = values.get(ATTR_AUTHCHECK05);
     return (String)value; 
	}
  

public void setAuthCheck06(String  authCheck06) {
	values.put(ATTR_AUTHCHECK06 ,authCheck06); 
	}
 
  public String  getAuthCheck06() { 
	 Object value = values.get(ATTR_AUTHCHECK06);
     return (String)value; 
	}
  

public void setAuthCheck07(String  authCheck07) {
	values.put(ATTR_AUTHCHECK07 ,authCheck07); 
	}
 
  public String  getAuthCheck07() { 
	 Object value = values.get(ATTR_AUTHCHECK07);
     return (String)value; 
	}
  

public void setAuthCheck08(String  authCheck08) {
	values.put(ATTR_AUTHCHECK08 ,authCheck08); 
	}
 
  public String  getAuthCheck08() { 
	 Object value = values.get(ATTR_AUTHCHECK08);
     return (String)value; 
	}
  

public void setAuthCheck09(String  authCheck09) {
	values.put(ATTR_AUTHCHECK09 ,authCheck09); 
	}
 
  public String  getAuthCheck09() { 
	 Object value = values.get(ATTR_AUTHCHECK09);
     return (String)value; 
	}
  

public void setAuthCheck10(String  authCheck10) {
	values.put(ATTR_AUTHCHECK10 ,authCheck10); 
	}
 
  public String  getAuthCheck10() { 
	 Object value = values.get(ATTR_AUTHCHECK10);
     return (String)value; 
	}
 

    public MSFAuthCheckBM clone(){
        return new MSFAuthCheckBM(
        		this.getDpobCd(),
                this.getSysDivCd(),  
                this.getUsrId(),  
                this.getUsrDivCd(),  
                this.getAuthCheck01(),
                this.getAuthCheck02(),
                this.getAuthCheck03(),
                this.getAuthCheck04(),
                this.getAuthCheck05(),
                this.getAuthCheck06(),
                this.getAuthCheck07(),
                this.getAuthCheck08() ,
                this.getAuthCheck09() ,
                this.getAuthCheck10() );
    } 
   
}
