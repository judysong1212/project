package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0130VO.java
 * @Description : Psnl0130 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014/07/31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0130BM   extends MSFSimpleBaseModel implements IsSerializable  {
	
    private static final long serialVersionUID = 1L;
    
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";
    
    /** set 급여구분코드 : payNm */
    public static final String ATTR_PAYNM = "payNm";

    /** set 은행코드 : bnkCd */
    public static final String ATTR_BNKCD = "bnkCd";
    

    /** set 은행명 : bnkNm */
    public static final String ATTR_BNKNM = "bnkNm";

    /** set 은행계좌번호 : bnkAccuNum */
    public static final String ATTR_BNKACCUNUM = "bnkAccuNum";

    /** set 예금주명 : acntHodrNm */
    public static final String ATTR_ACNTHODRNM = "acntHodrNm";

    /** set 대표계좌여부 : rpsttvAccuYn */
    public static final String ATTR_RPSTTVACCUYN = "rpsttvAccuYn";

    /** set 계좌비고내용 : accuNoteCtnt */
    public static final String ATTR_ACCUNOTECTNT = "accuNoteCtnt";
 

    /** 생성자 */
     public Psnl0130BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0130BM(
    		 String  systemkey 
    		, String  dpobCd 
    		, String  payCd 
    		, String  payNm
    		, String  bnkCd 
    		, String  bnkNm
    		, String  bnkAccuNum 
    		, String  acntHodrNm 
    		, String  rpsttvAccuYn 
    		, String  accuNoteCtnt  ) { 
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_PAYNM,payNm);
     	values.put(ATTR_BNKCD,bnkCd);
     	values.put(ATTR_BNKNM,bnkNm);
     	values.put(ATTR_BNKACCUNUM,bnkAccuNum);
     	values.put(ATTR_ACNTHODRNM,acntHodrNm);
     	values.put(ATTR_RPSTTVACCUYN,rpsttvAccuYn);
     	values.put(ATTR_ACCUNOTECTNT,accuNoteCtnt); } 

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 은행코드 : bnkCd */
    public void setBnkCd(String  bnkCd) { set( ATTR_BNKCD ,bnkCd);}
    /** get 은행코드 : bnkCd */
    public String  getBnkCd() { return (String )get( ATTR_BNKCD );}

    /** set 은행계좌번호 : bnkAccuNum */
    public void setBnkAccuNum(String  bnkAccuNum) { set( ATTR_BNKACCUNUM ,bnkAccuNum);}
    /** get 은행계좌번호 : bnkAccuNum */
    public String  getBnkAccuNum() { return (String )get( ATTR_BNKACCUNUM );}

    /** set 예금주명 : acntHodrNm */
    public void setAcntHodrNm(String  acntHodrNm) { set( ATTR_ACNTHODRNM ,acntHodrNm);}
    /** get 예금주명 : acntHodrNm */
    public String  getAcntHodrNm() { return (String )get( ATTR_ACNTHODRNM );}

    /** set 대표계좌여부 : rpsttvAccuYn */
    public void setRpsttvAccuYn(String  rpsttvAccuYn) { set( ATTR_RPSTTVACCUYN ,rpsttvAccuYn);}
    /** get 대표계좌여부 : rpsttvAccuYn */
    public String  getRpsttvAccuYn() { return (String )get( ATTR_RPSTTVACCUYN );}

    /** set 계좌비고내용 : accuNoteCtnt */
    public void setAccuNoteCtnt(String  accuNoteCtnt) { set( ATTR_ACCUNOTECTNT ,accuNoteCtnt);}
    /** get 계좌비고내용 : accuNoteCtnt */
    public String  getAccuNoteCtnt() { return (String )get( ATTR_ACCUNOTECTNT );}
 
}
