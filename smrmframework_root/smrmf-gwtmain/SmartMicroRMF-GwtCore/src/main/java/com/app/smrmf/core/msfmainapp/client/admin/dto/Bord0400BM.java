package com.app.smrmf.core.msfmainapp.client.admin.dto;

import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bord0400VO.java
 * @Description : Bord0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bord0400BM  extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    /** set 시스템구분코드 : sysDivCd */
    public static final String ATTR_SYSDIVCD = "sysDivCd";

    /** set 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
    public static final String ATTR_BULLBORDMSGEATTCFLNUM = "bullBordMsgeAttcFlNum";

    /** set 게시글일련번호 : bullBordMsgeSeilNum */
    public static final String ATTR_BULLBORDMSGESEILNUM = "bullBordMsgeSeilNum";

    /** set 게시판_UID : bullBordUid */
    public static final String ATTR_BULLBORDUID = "bullBordUid";

    /** set 게시판그룹ID : bullBordGrpId */
    public static final String ATTR_BULLBORDGRPID = "bullBordGrpId";

    /** set 파일 이름 : flNm */
    public static final String ATTR_FLNM = "flNm";

    /** set 파일 크기 : flSz */
    public static final String ATTR_FLSZ = "flSz";

    /** set 콘텐트 타입 : ctntTyp */
    public static final String ATTR_CTNTTYP = "ctntTyp";

    /** set 다운로드 수 : dwldNum */
    public static final String ATTR_DWLDNUM = "dwldNum";

    /** set 이미지 크기 넓이 : imgSzEtt */
    public static final String ATTR_IMGSZETT = "imgSzEtt";

    /** set 이미지 크기 높이 : imgSzHeit */
    public static final String ATTR_IMGSZHEIT = "imgSzHeit";

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

    /** set 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** set 게시글파일경로 : flRfta */
    public static final String ATTR_FLRFTA = "flRfta";

    /** 생성자 */
     public Bord0400BM() { super(); } 

    /** 일괄등록 처리   */
     public Bord0400BM(
             String  sysDivCd 
            , BigDecimal  bullBordMsgeAttcFlNum 
            , BigDecimal  bullBordMsgeSeilNum 
            , String  bullBordUid 
            , BigDecimal  bullBordGrpId 
            , String  flNm 
            , String  flSz 
            , String  ctntTyp 
            , BigDecimal  dwldNum 
            , BigDecimal  imgSzEtt 
            , BigDecimal  imgSzHeit 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr 
            , String  flRfta ) { 
        values.put(ATTR_SYSDIVCD,sysDivCd);
        values.put(ATTR_BULLBORDMSGEATTCFLNUM,bullBordMsgeAttcFlNum);
        values.put(ATTR_BULLBORDMSGESEILNUM,bullBordMsgeSeilNum);
        values.put(ATTR_BULLBORDUID,bullBordUid);
        values.put(ATTR_BULLBORDGRPID,bullBordGrpId);
        values.put(ATTR_FLNM,flNm);
        values.put(ATTR_FLSZ,flSz);
        values.put(ATTR_CTNTTYP,ctntTyp);
        values.put(ATTR_DWLDNUM,dwldNum);
        values.put(ATTR_IMGSZETT,imgSzEtt);
        values.put(ATTR_IMGSZHEIT,imgSzHeit);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr);
        values.put(ATTR_FLRFTA,flRfta); } 

    /** set 시스템구분코드 : sysDivCd */
    public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
    /** get 시스템구분코드 : sysDivCd */
    public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

    /** set 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
    public void setBullBordMsgeAttcFlNum(BigDecimal  bullBordMsgeAttcFlNum) { set( ATTR_BULLBORDMSGEATTCFLNUM ,bullBordMsgeAttcFlNum);}
    /** get 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
    public BigDecimal  getBullBordMsgeAttcFlNum() { return (BigDecimal )get( ATTR_BULLBORDMSGEATTCFLNUM );}

    /** set 게시글일련번호 : bullBordMsgeSeilNum */
    public void setBullBordMsgeSeilNum(BigDecimal  bullBordMsgeSeilNum) { set( ATTR_BULLBORDMSGESEILNUM ,bullBordMsgeSeilNum);}
    /** get 게시글일련번호 : bullBordMsgeSeilNum */
    public BigDecimal  getBullBordMsgeSeilNum() { return (BigDecimal )get( ATTR_BULLBORDMSGESEILNUM );}

    /** set 게시판_UID : bullBordUid */
    public void setBullBordUid(String  bullBordUid) { set( ATTR_BULLBORDUID ,bullBordUid);}
    /** get 게시판_UID : bullBordUid */
    public String  getBullBordUid() { return (String )get( ATTR_BULLBORDUID );}

    /** set 게시판그룹ID : bullBordGrpId */
    public void setBullBordGrpId(BigDecimal  bullBordGrpId) { set( ATTR_BULLBORDGRPID ,bullBordGrpId);}
    /** get 게시판그룹ID : bullBordGrpId */
    public BigDecimal  getBullBordGrpId() { return (BigDecimal )get( ATTR_BULLBORDGRPID );}

    /** set 파일 이름 : flNm */
    public void setFlNm(String  flNm) { set( ATTR_FLNM ,flNm);}
    /** get 파일 이름 : flNm */
    public String  getFlNm() { return (String )get( ATTR_FLNM );}

    /** set 파일 크기 : flSz */
    public void setFlSz(String  flSz) { set( ATTR_FLSZ ,flSz);}
    /** get 파일 크기 : flSz */
    public String  getFlSz() { return (String )get( ATTR_FLSZ );}

    /** set 콘텐트 타입 : ctntTyp */
    public void setCtntTyp(String  ctntTyp) { set( ATTR_CTNTTYP ,ctntTyp);}
    /** get 콘텐트 타입 : ctntTyp */
    public String  getCtntTyp() { return (String )get( ATTR_CTNTTYP );}

    /** set 다운로드 수 : dwldNum */
    public void setDwldNum(BigDecimal  dwldNum) { set( ATTR_DWLDNUM ,dwldNum);}
    /** get 다운로드 수 : dwldNum */
    public BigDecimal  getDwldNum() { return (BigDecimal )get( ATTR_DWLDNUM );}

    /** set 이미지 크기 넓이 : imgSzEtt */
    public void setImgSzEtt(BigDecimal  imgSzEtt) { set( ATTR_IMGSZETT ,imgSzEtt);}
    /** get 이미지 크기 넓이 : imgSzEtt */
    public BigDecimal  getImgSzEtt() { return (BigDecimal )get( ATTR_IMGSZETT );}

    /** set 이미지 크기 높이 : imgSzHeit */
    public void setImgSzHeit(BigDecimal  imgSzHeit) { set( ATTR_IMGSZHEIT ,imgSzHeit);}
    /** get 이미지 크기 높이 : imgSzHeit */
    public BigDecimal  getImgSzHeit() { return (BigDecimal )get( ATTR_IMGSZHEIT );}

    /** set 입력자 : kybdr */
    public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String  getKybdr() { return (String )get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String  getInptDt() { return (String )get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String  getIsmt() { return (String )get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String  getRevnDt() { return (String )get( ATTR_REVNDT );}

    /** set 수정주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정주소 : revnAddr */
    public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}

    /** set 게시글파일경로 : flRfta */
    public void setFlRfta(String  flRfta) { set( ATTR_FLRFTA ,flRfta);}
    /** get 게시글파일경로 : flRfta */
    public String  getFlRfta() { return (String )get( ATTR_FLRFTA );}

}
