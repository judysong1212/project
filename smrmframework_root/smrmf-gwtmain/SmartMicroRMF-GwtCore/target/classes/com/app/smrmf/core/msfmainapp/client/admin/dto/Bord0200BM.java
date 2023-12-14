package com.app.smrmf.core.msfmainapp.client.admin.dto;

import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bord0200VO.java
 * @Description : Bord0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bord0200BM  extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    /** set 시스템구분코드 : sysDivCd */
    public static final String ATTR_SYSDIVCD = "sysDivCd";

    /** set 게시판_UID : bullBordUid */
    public static final String ATTR_BULLBORDUID = "bullBordUid";

    /** set 게시판그룹ID : bullBordGrpId */
    public static final String ATTR_BULLBORDGRPID = "bullBordGrpId";

    /** set 제목 : ttl */
    public static final String ATTR_TTL = "ttl";

    /** set 게시판_제목_텍스트 : bullBordTtlTxt */
    public static final String ATTR_BULLBORDTTLTXT = "bullBordTtlTxt";

    /** set 게시판 설명 : bullBordEpln */
    public static final String ATTR_BULLBORDEPLN = "bullBordEpln";

    /** set 게시물 수 : notMateNum */
    public static final String ATTR_NOTMATENUM = "notMateNum";

    /** set 페이지 테그 크기 : pageTagSz */
    public static final String ATTR_PAGETAGSZ = "pageTagSz";

    /** set 스킨 타입 : sknTyp */
    public static final String ATTR_SKNTYP = "sknTyp";

    /** set 최근 글 설정 : nlsncWrtnStp */
    public static final String ATTR_NLSNCWRTNSTP = "nlsncWrtnStp";

    /** set 게시판 정렬 : bullBordRnge */
    public static final String ATTR_BULLBORDRNGE = "bullBordRnge";

    /** set 게시판 크기 : bullBordSz */
    public static final String ATTR_BULLBORDSZ = "bullBordSz";

    /** set 게시물의 제목 표현방법 : notMateTtlEpsnMensCd */
    public static final String ATTR_NOTMATETTLEPSNMENSCD = "notMateTtlEpsnMensCd";

    /** set 답변글 사용 : aswrWrtnUseYn */
    public static final String ATTR_ASWRWRTNUSEYN = "aswrWrtnUseYn";

    /** set 댓글 사용 : comtUseYn */
    public static final String ATTR_COMTUSEYN = "comtUseYn";

    /** set 파일 첨부 사용 : flAttcUseYn */
    public static final String ATTR_FLATTCUSEYN = "flAttcUseYn";

    /** set 게시판 알림 기능 사용 : bullBordNtfnFuncUseYn */
    public static final String ATTR_BULLBORDNTFNFUNCUSEYN = "bullBordNtfnFuncUseYn";

    /** set 관리자에게 메일 발송 사용 : adminEmailSndUseYn */
    public static final String ATTR_ADMINEMAILSNDUSEYN = "adminEmailSndUseYn";

    /** set 삭제구분플래그 : delDivFlag */
    public static final String ATTR_DELDIVFLAG = "delDivFlag";

    /** set 리스트 형태 : lstShape */
    public static final String ATTR_LSTSHAPE = "lstShape";

    /** set 링크 URI : lnkUrl */
    public static final String ATTR_LNKURL = "lnkUrl";

    /** set 첨부파일 크기 : attcFlSz */
    public static final String ATTR_ATTCFLSZ = "attcFlSz";

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
     public Bord0200BM() { super(); } 

    /** 일괄등록 처리   */
     public Bord0200BM(
    		 String  sysDivCd 
    		, String  bullBordUid 
    		, BigDecimal  bullBordGrpId 
    		, String  ttl 
    		, String  bullBordTtlTxt 
    		, String  bullBordEpln 
    		, BigDecimal  notMateNum 
    		, BigDecimal  pageTagSz 
    		, String  sknTyp 
    		, BigDecimal  nlsncWrtnStp 
    		, String  bullBordRnge 
    		, BigDecimal  bullBordSz 
    		, String  notMateTtlEpsnMensCd 
    		, String  aswrWrtnUseYn 
    		, String  comtUseYn 
    		, String  flAttcUseYn 
    		, String  bullBordNtfnFuncUseYn 
    		, String  adminEmailSndUseYn 
    		, String  delDivFlag 
    		, String  lstShape 
    		, String  lnkUrl 
    		, String  attcFlSz 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_SYSDIVCD,sysDivCd);
     	values.put(ATTR_BULLBORDUID,bullBordUid);
     	values.put(ATTR_BULLBORDGRPID,bullBordGrpId);
     	values.put(ATTR_TTL,ttl);
     	values.put(ATTR_BULLBORDTTLTXT,bullBordTtlTxt);
     	values.put(ATTR_BULLBORDEPLN,bullBordEpln);
     	values.put(ATTR_NOTMATENUM,notMateNum);
     	values.put(ATTR_PAGETAGSZ,pageTagSz);
     	values.put(ATTR_SKNTYP,sknTyp);
     	values.put(ATTR_NLSNCWRTNSTP,nlsncWrtnStp);
     	values.put(ATTR_BULLBORDRNGE,bullBordRnge);
     	values.put(ATTR_BULLBORDSZ,bullBordSz);
     	values.put(ATTR_NOTMATETTLEPSNMENSCD,notMateTtlEpsnMensCd);
     	values.put(ATTR_ASWRWRTNUSEYN,aswrWrtnUseYn);
     	values.put(ATTR_COMTUSEYN,comtUseYn);
     	values.put(ATTR_FLATTCUSEYN,flAttcUseYn);
     	values.put(ATTR_BULLBORDNTFNFUNCUSEYN,bullBordNtfnFuncUseYn);
     	values.put(ATTR_ADMINEMAILSNDUSEYN,adminEmailSndUseYn);
     	values.put(ATTR_DELDIVFLAG,delDivFlag);
     	values.put(ATTR_LSTSHAPE,lstShape);
     	values.put(ATTR_LNKURL,lnkUrl);
     	values.put(ATTR_ATTCFLSZ,attcFlSz);
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

    /** set 게시판_UID : bullBordUid */
    public void setBullBordUid(String  bullBordUid) { set( ATTR_BULLBORDUID ,bullBordUid);}
    /** get 게시판_UID : bullBordUid */
    public String  getBullBordUid() { return (String )get( ATTR_BULLBORDUID );}

    /** set 게시판그룹ID : bullBordGrpId */
    public void setBullBordGrpId(BigDecimal  bullBordGrpId) { set( ATTR_BULLBORDGRPID ,bullBordGrpId);}
    /** get 게시판그룹ID : bullBordGrpId */
    public BigDecimal  getBullBordGrpId() { return (BigDecimal )get( ATTR_BULLBORDGRPID );}

    /** set 제목 : ttl */
    public void setTtl(String  ttl) { set( ATTR_TTL ,ttl);}
    /** get 제목 : ttl */
    public String  getTtl() { return (String )get( ATTR_TTL );}

    /** set 게시판_제목_텍스트 : bullBordTtlTxt */
    public void setBullBordTtlTxt(String  bullBordTtlTxt) { set( ATTR_BULLBORDTTLTXT ,bullBordTtlTxt);}
    /** get 게시판_제목_텍스트 : bullBordTtlTxt */
    public String  getBullBordTtlTxt() { return (String )get( ATTR_BULLBORDTTLTXT );}

    /** set 게시판 설명 : bullBordEpln */
    public void setBullBordEpln(String  bullBordEpln) { set( ATTR_BULLBORDEPLN ,bullBordEpln);}
    /** get 게시판 설명 : bullBordEpln */
    public String  getBullBordEpln() { return (String )get( ATTR_BULLBORDEPLN );}

    /** set 게시물 수 : notMateNum */
    public void setNotMateNum(BigDecimal  notMateNum) { set( ATTR_NOTMATENUM ,notMateNum);}
    /** get 게시물 수 : notMateNum */
    public BigDecimal  getNotMateNum() { return (BigDecimal )get( ATTR_NOTMATENUM );}

    /** set 페이지 테그 크기 : pageTagSz */
    public void setPageTagSz(BigDecimal  pageTagSz) { set( ATTR_PAGETAGSZ ,pageTagSz);}
    /** get 페이지 테그 크기 : pageTagSz */
    public BigDecimal  getPageTagSz() { return (BigDecimal )get( ATTR_PAGETAGSZ );}

    /** set 스킨 타입 : sknTyp */
    public void setSknTyp(String  sknTyp) { set( ATTR_SKNTYP ,sknTyp);}
    /** get 스킨 타입 : sknTyp */
    public String  getSknTyp() { return (String )get( ATTR_SKNTYP );}

    /** set 최근 글 설정 : nlsncWrtnStp */
    public void setNlsncWrtnStp(BigDecimal  nlsncWrtnStp) { set( ATTR_NLSNCWRTNSTP ,nlsncWrtnStp);}
    /** get 최근 글 설정 : nlsncWrtnStp */
    public BigDecimal  getNlsncWrtnStp() { return (BigDecimal )get( ATTR_NLSNCWRTNSTP );}

    /** set 게시판 정렬 : bullBordRnge */
    public void setBullBordRnge(String  bullBordRnge) { set( ATTR_BULLBORDRNGE ,bullBordRnge);}
    /** get 게시판 정렬 : bullBordRnge */
    public String  getBullBordRnge() { return (String )get( ATTR_BULLBORDRNGE );}

    /** set 게시판 크기 : bullBordSz */
    public void setBullBordSz(BigDecimal  bullBordSz) { set( ATTR_BULLBORDSZ ,bullBordSz);}
    /** get 게시판 크기 : bullBordSz */
    public BigDecimal  getBullBordSz() { return (BigDecimal )get( ATTR_BULLBORDSZ );}

    /** set 게시물의 제목 표현방법 : notMateTtlEpsnMensCd */
    public void setNotMateTtlEpsnMensCd(String  notMateTtlEpsnMensCd) { set( ATTR_NOTMATETTLEPSNMENSCD ,notMateTtlEpsnMensCd);}
    /** get 게시물의 제목 표현방법 : notMateTtlEpsnMensCd */
    public String  getNotMateTtlEpsnMensCd() { return (String )get( ATTR_NOTMATETTLEPSNMENSCD );}

    /** set 답변글 사용 : aswrWrtnUseYn */
    public void setAswrWrtnUseYn(String  aswrWrtnUseYn) { set( ATTR_ASWRWRTNUSEYN ,aswrWrtnUseYn);}
    /** get 답변글 사용 : aswrWrtnUseYn */
    public String  getAswrWrtnUseYn() { return (String )get( ATTR_ASWRWRTNUSEYN );}

    /** set 댓글 사용 : comtUseYn */
    public void setComtUseYn(String  comtUseYn) { set( ATTR_COMTUSEYN ,comtUseYn);}
    /** get 댓글 사용 : comtUseYn */
    public String  getComtUseYn() { return (String )get( ATTR_COMTUSEYN );}

    /** set 파일 첨부 사용 : flAttcUseYn */
    public void setFlAttcUseYn(String  flAttcUseYn) { set( ATTR_FLATTCUSEYN ,flAttcUseYn);}
    /** get 파일 첨부 사용 : flAttcUseYn */
    public String  getFlAttcUseYn() { return (String )get( ATTR_FLATTCUSEYN );}

    /** set 게시판 알림 기능 사용 : bullBordNtfnFuncUseYn */
    public void setBullBordNtfnFuncUseYn(String  bullBordNtfnFuncUseYn) { set( ATTR_BULLBORDNTFNFUNCUSEYN ,bullBordNtfnFuncUseYn);}
    /** get 게시판 알림 기능 사용 : bullBordNtfnFuncUseYn */
    public String  getBullBordNtfnFuncUseYn() { return (String )get( ATTR_BULLBORDNTFNFUNCUSEYN );}

    /** set 관리자에게 메일 발송 사용 : adminEmailSndUseYn */
    public void setAdminEmailSndUseYn(String  adminEmailSndUseYn) { set( ATTR_ADMINEMAILSNDUSEYN ,adminEmailSndUseYn);}
    /** get 관리자에게 메일 발송 사용 : adminEmailSndUseYn */
    public String  getAdminEmailSndUseYn() { return (String )get( ATTR_ADMINEMAILSNDUSEYN );}

    /** set 삭제구분플래그 : delDivFlag */
    public void setDelDivFlag(String  delDivFlag) { set( ATTR_DELDIVFLAG ,delDivFlag);}
    /** get 삭제구분플래그 : delDivFlag */
    public String  getDelDivFlag() { return (String )get( ATTR_DELDIVFLAG );}

    /** set 리스트 형태 : lstShape */
    public void setLstShape(String  lstShape) { set( ATTR_LSTSHAPE ,lstShape);}
    /** get 리스트 형태 : lstShape */
    public String  getLstShape() { return (String )get( ATTR_LSTSHAPE );}

    /** set 링크 URI : lnkUrl */
    public void setLnkUrl(String  lnkUrl) { set( ATTR_LNKURL ,lnkUrl);}
    /** get 링크 URI : lnkUrl */
    public String  getLnkUrl() { return (String )get( ATTR_LNKURL );}

    /** set 첨부파일 크기 : attcFlSz */
    public void setAttcFlSz(String  attcFlSz) { set( ATTR_ATTCFLSZ ,attcFlSz);}
    /** get 첨부파일 크기 : attcFlSz */
    public String  getAttcFlSz() { return (String )get( ATTR_ATTCFLSZ );}

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
