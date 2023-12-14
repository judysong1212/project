package com.app.exterms.payroll.client.dto;

 
import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0220BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 가압류일련번호 : provAthmSeilNum */
    public static final String ATTR_PROVATHMSEILNUM = "provAthmSeilNum";

    /** set 사건번호 : icntNum */
    public static final String ATTR_ICNTNUM = "icntNum";

    /** set 사건명 : icntNm */
    public static final String ATTR_ICNTNM = "icntNm";

    /** set 채권자명 : cdtrNm */
    public static final String ATTR_CDTRNM = "cdtrNm";

    /** set 채권기관 : bondIstut */
    public static final String ATTR_BONDISTUT = "bondIstut";

    /** set 은행코드 : bnkCd */
    public static final String ATTR_BNKCD = "bnkCd";
    

    /** set 은행 : bnkNm */
    public static final String ATTR_BNKNM = "bnkNm";

    /** set 은행계좌번호 : bnkAccuNum */
    public static final String ATTR_BNKACCUNUM = "bnkAccuNum";

    /** set 예금주명 : acntHodrNm */
    public static final String ATTR_ACNTHODRNM = "acntHodrNm";

    /** set 접수일자 : rcptDt */
    public static final String ATTR_RCPTDT = "rcptDt";

    /** set 송달일자 : dlvyDt */
    public static final String ATTR_DLVYDT = "dlvyDt";

    /** set 공제기간시작일자 : dducPridBgnnDt */
    public static final String ATTR_DDUCPRIDBGNNDT = "dducPridBgnnDt";

    /** set 공제기간종료일자 : dducPridEndDt */
    public static final String ATTR_DDUCPRIDENDDT = "dducPridEndDt";

    /** set 채권압류종료여부 : bondFrclrEndYn */
    public static final String ATTR_BONDFRCLRENDYN = "bondFrclrEndYn";

    /** set 급여공제여부 : payDducYn */
    public static final String ATTR_PAYDDUCYN = "payDducYn";

    /** set 청구금액 : clmSum */
    public static final String ATTR_CLMSUM = "clmSum";

    /** set 청구잔액 : clmBaln */
    public static final String ATTR_CLMBALN = "clmBaln";

    /** set 채권압류제한금액 : bondFrclrLmtSum */
    public static final String ATTR_BONDFRCLRLMTSUM = "bondFrclrLmtSum";

    /** set 누적공제금액 : acmlteDducSum */
    public static final String ATTR_ACMLTEDDUCSUM = "acmlteDducSum";

    /** set 공제금액 : dducSum */
    public static final String ATTR_DDUCSUM = "dducSum";

    /** set 공제비율 : dducRto */
    public static final String ATTR_DDUCRTO = "dducRto";

    /** set 가압류비고내용 : provAthmNoteCtnt */
    public static final String ATTR_PROVATHMNOTECTNT = "provAthmNoteCtnt";

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
     public Payr0220BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0220BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, Long  provAthmSeilNum 
    		, String  icntNum 
    		, String  icntNm 
    		, String  cdtrNm 
    		, String  bondIstut 
    		, String  bnkCd 
    		, String  bnkAccuNum 
    		, String  acntHodrNm 
    		, String  rcptDt 
    		, String  dlvyDt 
    		, String  dducPridBgnnDt 
    		, String  dducPridEndDt 
    		, Boolean  bondFrclrEndYn 
    		, Boolean  payDducYn 
    		, Long  clmSum 
    		, Long  clmBaln 
    		, Long  bondFrclrLmtSum 
    		, Long  acmlteDducSum 
    		, Long  dducSum 
    		, Double  dducRto 
    		, String  provAthmNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PROVATHMSEILNUM,provAthmSeilNum);
     	values.put(ATTR_ICNTNUM,icntNum);
     	values.put(ATTR_ICNTNM,icntNm);
     	values.put(ATTR_CDTRNM,cdtrNm);
     	values.put(ATTR_BONDISTUT,bondIstut);
     	values.put(ATTR_BNKCD,bnkCd);
     	values.put(ATTR_BNKACCUNUM,bnkAccuNum);
     	values.put(ATTR_ACNTHODRNM,acntHodrNm);
     	values.put(ATTR_RCPTDT,rcptDt);
     	values.put(ATTR_DLVYDT,dlvyDt);
     	values.put(ATTR_DDUCPRIDBGNNDT,dducPridBgnnDt);
     	values.put(ATTR_DDUCPRIDENDDT,dducPridEndDt);
     	values.put(ATTR_BONDFRCLRENDYN,bondFrclrEndYn);
     	values.put(ATTR_PAYDDUCYN,payDducYn);
     	values.put(ATTR_CLMSUM,clmSum);
     	values.put(ATTR_CLMBALN,clmBaln);
     	values.put(ATTR_BONDFRCLRLMTSUM,bondFrclrLmtSum);
     	values.put(ATTR_ACMLTEDDUCSUM,acmlteDducSum);
     	values.put(ATTR_DDUCSUM,dducSum);
     	values.put(ATTR_DDUCRTO,dducRto);
     	values.put(ATTR_PROVATHMNOTECTNT,provAthmNoteCtnt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 가압류일련번호 : provAthmSeilNum */
    public void setProvAthmSeilNum(Long  provAthmSeilNum) { set( ATTR_PROVATHMSEILNUM ,provAthmSeilNum);}
    /** get 가압류일련번호 : provAthmSeilNum */
    public Long  getProvAthmSeilNum() { return (Long )get( ATTR_PROVATHMSEILNUM );}

    /** set 사건번호 : icntNum */
    public void setIcntNum(String  icntNum) { set( ATTR_ICNTNUM ,icntNum);}
    /** get 사건번호 : icntNum */
    public String  getIcntNum() { return (String )get( ATTR_ICNTNUM );}

    /** set 사건명 : icntNm */
    public void setIcntNm(String  icntNm) { set( ATTR_ICNTNM ,icntNm);}
    /** get 사건명 : icntNm */
    public String  getIcntNm() { return (String )get( ATTR_ICNTNM );}

    /** set 채권자명 : cdtrNm */
    public void setCdtrNm(String  cdtrNm) { set( ATTR_CDTRNM ,cdtrNm);}
    /** get 채권자명 : cdtrNm */
    public String  getCdtrNm() { return (String )get( ATTR_CDTRNM );}

    /** set 채권기관 : bondIstut */
    public void setBondIstut(String  bondIstut) { set( ATTR_BONDISTUT ,bondIstut);}
    /** get 채권기관 : bondIstut */
    public String  getBondIstut() { return (String )get( ATTR_BONDISTUT );}

    /** set 은행코드 : bnkCd */
    public void setBnkCd(String  bnkCd) { set( ATTR_BNKCD ,bnkCd);}
    /** get 은행코드 : bnkCd */
    public String  getBnkCd() { return (String )get( ATTR_BNKCD );}
    

    /** set 은행 : bnkNm */
    public void setBnkNm(String  bnkNm) { set( ATTR_BNKNM ,bnkNm);}
    /** get 은행 : bnkNm */
    public String  getBnkNm() { return (String )get( ATTR_BNKNM );}


    /** set 은행계좌번호 : bnkAccuNum */
    public void setBnkAccuNum(String  bnkAccuNum) { set( ATTR_BNKACCUNUM ,bnkAccuNum);}
    /** get 은행계좌번호 : bnkAccuNum */
    public String  getBnkAccuNum() { return (String )get( ATTR_BNKACCUNUM );}

    /** set 예금주명 : acntHodrNm */
    public void setAcntHodrNm(String  acntHodrNm) { set( ATTR_ACNTHODRNM ,acntHodrNm);}
    /** get 예금주명 : acntHodrNm */
    public String  getAcntHodrNm() { return (String )get( ATTR_ACNTHODRNM );}

    /** set 접수일자 : rcptDt */
    public void setRcptDt(String  rcptDt) { set( ATTR_RCPTDT ,rcptDt);}
    /** get 접수일자 : rcptDt */
    public String  getRcptDt() { return (String )get( ATTR_RCPTDT );}

    /** set 송달일자 : dlvyDt */
    public void setDlvyDt(String  dlvyDt) { set( ATTR_DLVYDT ,dlvyDt);}
    /** get 송달일자 : dlvyDt */
    public String  getDlvyDt() { return (String )get( ATTR_DLVYDT );}

    /** set 공제기간시작일자 : dducPridBgnnDt */
    public void setDducPridBgnnDt(String  dducPridBgnnDt) { set( ATTR_DDUCPRIDBGNNDT ,dducPridBgnnDt);}
    /** get 공제기간시작일자 : dducPridBgnnDt */
    public String  getDducPridBgnnDt() { return (String )get( ATTR_DDUCPRIDBGNNDT );}

    /** set 공제기간종료일자 : dducPridEndDt */
    public void setDducPridEndDt(String  dducPridEndDt) { set( ATTR_DDUCPRIDENDDT ,dducPridEndDt);}
    /** get 공제기간종료일자 : dducPridEndDt */
    public String  getDducPridEndDt() { return (String )get( ATTR_DDUCPRIDENDDT );}

    /** set 채권압류종료여부 : bondFrclrEndYn */
    public void setBondFrclrEndYn(Boolean  bondFrclrEndYn) { set( ATTR_BONDFRCLRENDYN ,bondFrclrEndYn);}
    /** get 채권압류종료여부 : bondFrclrEndYn */
    public Boolean  getBondFrclrEndYn() { return (Boolean )get( ATTR_BONDFRCLRENDYN );}

    /** set 급여공제여부 : payDducYn */
    public void setPayDducYn(Boolean  payDducYn) { set( ATTR_PAYDDUCYN ,payDducYn);}
    /** get 급여공제여부 : payDducYn */
    public Boolean  getPayDducYn() { return (Boolean )get( ATTR_PAYDDUCYN );}

    /** set 청구금액 : clmSum */
    public void setClmSum(Long  clmSum) { set( ATTR_CLMSUM ,clmSum);}
    /** get 청구금액 : clmSum */
    public Long  getClmSum() { return (Long )get( ATTR_CLMSUM );}

    /** set 청구잔액 : clmBaln */
    public void setClmBaln(Long  clmBaln) { set( ATTR_CLMBALN ,clmBaln);}
    /** get 청구잔액 : clmBaln */
    public Long  getClmBaln() { return (Long )get( ATTR_CLMBALN );}

    /** set 채권압류제한금액 : bondFrclrLmtSum */
    public void setBondFrclrLmtSum(Long  bondFrclrLmtSum) { set( ATTR_BONDFRCLRLMTSUM ,bondFrclrLmtSum);}
    /** get 채권압류제한금액 : bondFrclrLmtSum */
    public Long  getBondFrclrLmtSum() { return (Long )get( ATTR_BONDFRCLRLMTSUM );}

    /** set 누적공제금액 : acmlteDducSum */
    public void setAcmlteDducSum(Long  acmlteDducSum) { set( ATTR_ACMLTEDDUCSUM ,acmlteDducSum);}
    /** get 누적공제금액 : acmlteDducSum */
    public Long  getAcmlteDducSum() { return (Long )get( ATTR_ACMLTEDDUCSUM );}

    /** set 공제금액 : dducSum */
    public void setDducSum(Long  dducSum) { set( ATTR_DDUCSUM ,dducSum);}
    /** get 공제금액 : dducSum */
    public Long  getDducSum() { return (Long )get( ATTR_DDUCSUM );}

    /** set 공제비율 : dducRto */
    public void setDducRto(Double  dducRto) { set( ATTR_DDUCRTO ,dducRto);}
    /** get 공제비율 : dducRto */
    public Double  getDducRto() { return (Double)get( ATTR_DDUCRTO );}

    /** set 가압류비고내용 : provAthmNoteCtnt */
    public void setProvAthmNoteCtnt(String  provAthmNoteCtnt) { set( ATTR_PROVATHMNOTECTNT ,provAthmNoteCtnt);}
    /** get 가압류비고내용 : provAthmNoteCtnt */
    public String  getProvAthmNoteCtnt() { return (String )get( ATTR_PROVATHMNOTECTNT );}

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
