package com.app.smrmf.core.msfmainapp.client.admin.dto;

import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bord0300VO.java
 * @Description : Bord0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bord0300BM  extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    /** set 시스템구분코드 : sysDivCd */
    public static final String ATTR_SYSDIVCD = "sysDivCd";

    /** set 게시글일련번호 : bullBordMsgeSeilNum */
    public static final String ATTR_BULLBORDMSGESEILNUM = "bullBordMsgeSeilNum";

    /** set 게시판_UID : bullBordUid */
    public static final String ATTR_BULLBORDUID = "bullBordUid";

    /** set 게시판그룹ID : bullBordGrpId */
    public static final String ATTR_BULLBORDGRPID = "bullBordGrpId";

    /** set 최상위 글 정보 : tplvlWrtnInfo */
    public static final String ATTR_TPLVLWRTNINFO = "tplvlWrtnInfo";

    /** set 글의 답변단계 : wrtnAswrStge */
    public static final String ATTR_WRTNASWRSTGE = "wrtnAswrStge";

    /** set 글의 등록된 순서 : wrtnRgstnOrd */
    public static final String ATTR_WRTNRGSTNORD = "wrtnRgstnOrd";

    /** set 답변하는 글의 번호 : aswrWrtnNum */
    public static final String ATTR_ASWRWRTNNUM = "aswrWrtnNum";

    /** set 작성자 이름 : ppgPernNm */
    public static final String ATTR_PPGPERNNM = "ppgPernNm";

    /** set 사용자 아이디 : usrId */
    public static final String ATTR_USRID = "usrId";

    /** set 제목 : bullBordMsgeTtl */
    public static final String ATTR_BULLBORDMSGETTL = "bullBordMsgeTtl";

    /** set 내용 : bullBordMsgeCtnt */
    public static final String ATTR_BULLBORDMSGECTNT = "bullBordMsgeCtnt";

    /** set 글 비밀번호 : wrtnSecrNum */
    public static final String ATTR_WRTNSECRNUM = "wrtnSecrNum";

    /** set 작성자 메일 : ppgPernEmail */
    public static final String ATTR_PPGPERNEMAIL = "ppgPernEmail";

    /** set 조회수 : inqyNum */
    public static final String ATTR_INQYNUM = "inqyNum";

    /** set HTML 사용여부 : htmlUseYn */
    public static final String ATTR_HTMLUSEYN = "htmlUseYn";

    /** set 삭제 여부 : bullBordMsgeDelYn */
    public static final String ATTR_BULLBORDMSGEDELYN = "bullBordMsgeDelYn";

    /** set 공지 시작일 : notiBgnnDt */
    public static final String ATTR_NOTIBGNNDT = "notiBgnnDt";

    /** set 공지 종료일 : notiEndDt */
    public static final String ATTR_NOTIENDDT = "notiEndDt";

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

    /** 생성자 */
     public Bord0300BM() { super(); } 

    /** 일괄등록 처리   */
     public Bord0300BM(
    		 String  sysDivCd 
    		, BigDecimal  bullBordMsgeSeilNum 
    		, String  bullBordUid 
    		, BigDecimal  bullBordGrpId 
    		, BigDecimal  tplvlWrtnInfo 
    		, BigDecimal  wrtnAswrStge 
    		, BigDecimal  wrtnRgstnOrd 
    		, BigDecimal  aswrWrtnNum 
    		, String  ppgPernNm 
    		, String  usrId 
    		, String  bullBordMsgeTtl 
    		, String  bullBordMsgeCtnt 
    		, String  wrtnSecrNum 
    		, String  ppgPernEmail 
    		, BigDecimal  inqyNum 
    		, String  htmlUseYn 
    		, String  bullBordMsgeDelYn 
    		, String  notiBgnnDt 
    		, String  notiEndDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_SYSDIVCD,sysDivCd);
     	values.put(ATTR_BULLBORDMSGESEILNUM,bullBordMsgeSeilNum);
     	values.put(ATTR_BULLBORDUID,bullBordUid);
     	values.put(ATTR_BULLBORDGRPID,bullBordGrpId);
     	values.put(ATTR_TPLVLWRTNINFO,tplvlWrtnInfo);
     	values.put(ATTR_WRTNASWRSTGE,wrtnAswrStge);
     	values.put(ATTR_WRTNRGSTNORD,wrtnRgstnOrd);
     	values.put(ATTR_ASWRWRTNNUM,aswrWrtnNum);
     	values.put(ATTR_PPGPERNNM,ppgPernNm);
     	values.put(ATTR_USRID,usrId);
     	values.put(ATTR_BULLBORDMSGETTL,bullBordMsgeTtl);
     	values.put(ATTR_BULLBORDMSGECTNT,bullBordMsgeCtnt);
     	values.put(ATTR_WRTNSECRNUM,wrtnSecrNum);
     	values.put(ATTR_PPGPERNEMAIL,ppgPernEmail);
     	values.put(ATTR_INQYNUM,inqyNum);
     	values.put(ATTR_HTMLUSEYN,htmlUseYn);
     	values.put(ATTR_BULLBORDMSGEDELYN,bullBordMsgeDelYn);
     	values.put(ATTR_NOTIBGNNDT,notiBgnnDt);
     	values.put(ATTR_NOTIENDDT,notiEndDt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 시스템구분코드 : sysDivCd */
    public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
    /** get 시스템구분코드 : sysDivCd */
    public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

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

    /** set 최상위 글 정보 : tplvlWrtnInfo */
    public void setTplvlWrtnInfo(BigDecimal  tplvlWrtnInfo) { set( ATTR_TPLVLWRTNINFO ,tplvlWrtnInfo);}
    /** get 최상위 글 정보 : tplvlWrtnInfo */
    public BigDecimal  getTplvlWrtnInfo() { return (BigDecimal )get( ATTR_TPLVLWRTNINFO );}

    /** set 글의 답변단계 : wrtnAswrStge */
    public void setWrtnAswrStge(BigDecimal  wrtnAswrStge) { set( ATTR_WRTNASWRSTGE ,wrtnAswrStge);}
    /** get 글의 답변단계 : wrtnAswrStge */
    public BigDecimal  getWrtnAswrStge() { return (BigDecimal )get( ATTR_WRTNASWRSTGE );}

    /** set 글의 등록된 순서 : wrtnRgstnOrd */
    public void setWrtnRgstnOrd(BigDecimal  wrtnRgstnOrd) { set( ATTR_WRTNRGSTNORD ,wrtnRgstnOrd);}
    /** get 글의 등록된 순서 : wrtnRgstnOrd */
    public BigDecimal  getWrtnRgstnOrd() { return (BigDecimal )get( ATTR_WRTNRGSTNORD );}

    /** set 답변하는 글의 번호 : aswrWrtnNum */
    public void setAswrWrtnNum(BigDecimal  aswrWrtnNum) { set( ATTR_ASWRWRTNNUM ,aswrWrtnNum);}
    /** get 답변하는 글의 번호 : aswrWrtnNum */
    public BigDecimal  getAswrWrtnNum() { return (BigDecimal )get( ATTR_ASWRWRTNNUM );}

    /** set 작성자 이름 : ppgPernNm */
    public void setPpgPernNm(String  ppgPernNm) { set( ATTR_PPGPERNNM ,ppgPernNm);}
    /** get 작성자 이름 : ppgPernNm */
    public String  getPpgPernNm() { return (String )get( ATTR_PPGPERNNM );}

    /** set 사용자 아이디 : usrId */
    public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
    /** get 사용자 아이디 : usrId */
    public String  getUsrId() { return (String )get( ATTR_USRID );}

    /** set 제목 : bullBordMsgeTtl */
    public void setBullBordMsgeTtl(String  bullBordMsgeTtl) { set( ATTR_BULLBORDMSGETTL ,bullBordMsgeTtl);}
    /** get 제목 : bullBordMsgeTtl */
    public String  getBullBordMsgeTtl() { return (String )get( ATTR_BULLBORDMSGETTL );}

    /** set 내용 : bullBordMsgeCtnt */
    public void setBullBordMsgeCtnt(String  bullBordMsgeCtnt) { set( ATTR_BULLBORDMSGECTNT ,bullBordMsgeCtnt);}
    /** get 내용 : bullBordMsgeCtnt */
    public String  getBullBordMsgeCtnt() { return (String )get( ATTR_BULLBORDMSGECTNT );}

    /** set 글 비밀번호 : wrtnSecrNum */
    public void setWrtnSecrNum(String  wrtnSecrNum) { set( ATTR_WRTNSECRNUM ,wrtnSecrNum);}
    /** get 글 비밀번호 : wrtnSecrNum */
    public String  getWrtnSecrNum() { return (String )get( ATTR_WRTNSECRNUM );}

    /** set 작성자 메일 : ppgPernEmail */
    public void setPpgPernEmail(String  ppgPernEmail) { set( ATTR_PPGPERNEMAIL ,ppgPernEmail);}
    /** get 작성자 메일 : ppgPernEmail */
    public String  getPpgPernEmail() { return (String )get( ATTR_PPGPERNEMAIL );}

    /** set 조회수 : inqyNum */
    public void setInqyNum(BigDecimal  inqyNum) { set( ATTR_INQYNUM ,inqyNum);}
    /** get 조회수 : inqyNum */
    public BigDecimal  getInqyNum() { return (BigDecimal )get( ATTR_INQYNUM );}

    /** set HTML 사용여부 : htmlUseYn */
    public void setHtmlUseYn(String  htmlUseYn) { set( ATTR_HTMLUSEYN ,htmlUseYn);}
    /** get HTML 사용여부 : htmlUseYn */
    public String  getHtmlUseYn() { return (String )get( ATTR_HTMLUSEYN );}

    /** set 삭제 여부 : bullBordMsgeDelYn */
    public void setBullBordMsgeDelYn(String  bullBordMsgeDelYn) { set( ATTR_BULLBORDMSGEDELYN ,bullBordMsgeDelYn);}
    /** get 삭제 여부 : bullBordMsgeDelYn */
    public String  getBullBordMsgeDelYn() { return (String )get( ATTR_BULLBORDMSGEDELYN );}

    /** set 공지 시작일 : notiBgnnDt */
    public void setNotiBgnnDt(String  notiBgnnDt) { set( ATTR_NOTIBGNNDT ,notiBgnnDt);}
    /** get 공지 시작일 : notiBgnnDt */
    public String  getNotiBgnnDt() { return (String )get( ATTR_NOTIBGNNDT );}

    /** set 공지 종료일 : notiEndDt */
    public void setNotiEndDt(String  notiEndDt) { set( ATTR_NOTIENDDT ,notiEndDt);}
    /** get 공지 종료일 : notiEndDt */
    public String  getNotiEndDt() { return (String )get( ATTR_NOTIENDDT );}

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

   
}
