package com.app.exterms.budget.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bugt0010VO.java
 * @Description : Bugt0010 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bugt0010BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 회계단위코드 : accUntCd */
    public static final String ATTR_ACCUNTCD = "accUntCd";

    /** set 회계년도 : accYr */
    public static final String ATTR_ACCYR = "accYr";

    /** set 회계단위명 : accUntNm */
    public static final String ATTR_ACCUNTNM = "accUntNm";

    /** set 회계단위상위코드 : accUntHhrkCd */
    public static final String ATTR_ACCUNTHHRKCD = "accUntHhrkCd";

    /** set 회계단위시작일자 : accUntBgnnDt */
    public static final String ATTR_ACCUNTBGNNDT = "accUntBgnnDt";

    /** set 회계단위종료일자 : accUntEndDt */
    public static final String ATTR_ACCUNTENDDT = "accUntEndDt";

    /** set 회계단위비고내용 : accUntNoteCtnt */
    public static final String ATTR_ACCUNTNOTECTNT = "accUntNoteCtnt";

    /** set 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** set 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** set 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** set 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** set 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** set IP주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** 생성자 */
     public Bugt0010BM() { super(); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get( ATTR_DPOBCD );}

    /** set 회계단위코드 : accUntCd */
    public void setAccUntCd(String accUntCd) { set( ATTR_ACCUNTCD ,accUntCd);}
    /** get 회계단위코드 : accUntCd */
    public String getAccUntCd() { return (String)get( ATTR_ACCUNTCD );}

    /** set 회계년도 : accYr */
    public void setAccYr(String accYr) { set( ATTR_ACCYR ,accYr);}
    /** get 회계년도 : accYr */
    public String getAccYr() { return (String)get( ATTR_ACCYR );}

    /** set 회계단위명 : accUntNm */
    public void setAccUntNm(String accUntNm) { set( ATTR_ACCUNTNM ,accUntNm);}
    /** get 회계단위명 : accUntNm */
    public String getAccUntNm() { return (String)get( ATTR_ACCUNTNM );}

    /** set 회계단위상위코드 : accUntHhrkCd */
    public void setAccUntHhrkCd(String accUntHhrkCd) { set( ATTR_ACCUNTHHRKCD ,accUntHhrkCd);}
    /** get 회계단위상위코드 : accUntHhrkCd */
    public String getAccUntHhrkCd() { return (String)get( ATTR_ACCUNTHHRKCD );}

    /** set 회계단위시작일자 : accUntBgnnDt */
    public void setAccUntBgnnDt(String accUntBgnnDt) { set( ATTR_ACCUNTBGNNDT ,accUntBgnnDt);}
    /** get 회계단위시작일자 : accUntBgnnDt */
    public String getAccUntBgnnDt() { return (String)get( ATTR_ACCUNTBGNNDT );}

    /** set 회계단위종료일자 : accUntEndDt */
    public void setAccUntEndDt(String accUntEndDt) { set( ATTR_ACCUNTENDDT ,accUntEndDt);}
    /** get 회계단위종료일자 : accUntEndDt */
    public String getAccUntEndDt() { return (String)get( ATTR_ACCUNTENDDT );}

    /** set 회계단위비고내용 : accUntNoteCtnt */
    public void setAccUntNoteCtnt(String accUntNoteCtnt) { set( ATTR_ACCUNTNOTECTNT ,accUntNoteCtnt);}
    /** get 회계단위비고내용 : accUntNoteCtnt */
    public String getAccUntNoteCtnt() { return (String)get( ATTR_ACCUNTNOTECTNT );}

    /** set 입력자 : kybdr */
    public void setKybdr(String kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String getKybdr() { return (String)get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String getInptDt() { return (String)get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String getInptAddr() { return (String)get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String getIsmt() { return (String)get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String getRevnDt() { return (String)get( ATTR_REVNDT );}

    /** set IP주소 : revnAddr */
    public void setRevnAddr(String revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get IP주소 : revnAddr */
    public String getRevnAddr() { return (String)get( ATTR_REVNADDR );}


}
