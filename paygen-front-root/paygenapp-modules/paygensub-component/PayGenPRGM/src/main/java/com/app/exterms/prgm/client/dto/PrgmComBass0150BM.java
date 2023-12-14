package com.app.exterms.prgm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0150VO.java
 * @Description : Bass0150 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PrgmComBass0150BM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 단위기관명 : payMangeDeptNm */
    public static final String ATTR_PAYMANGEDEPTNM = "payMangeDeptNm";

    /** set 대표자주민번호 : degtrResnRegnNum */
    public static final String ATTR_DEGTRRESNREGNNUM = "degtrResnRegnNum";

    /** set 대표자명 : degtrNm */
    public static final String ATTR_DEGTRNM = "degtrNm";

    /** set 사업자등록번호 : busoprRgstnNum */
    public static final String ATTR_BUSOPRRGSTNNUM = "busoprRgstnNum";

    /** set 법인등록번호 : corpRgstnNum */
    public static final String ATTR_CORPRGSTNNUM = "corpRgstnNum";

    /** set 법인구분코드 : corpDivCd */
    public static final String ATTR_CORPDIVCD = "corpDivCd";

    /** set 단위기관우편번호 : payMangeDeptZpcd */
    public static final String ATTR_PAYMANGEDEPTZPCD = "payMangeDeptZpcd";

    /** set 단위기관기본주소 : payMangeDeptFNdtnAddr */
    public static final String ATTR_PAYMANGEDEPTFNDTNADDR = "payMangeDeptFNdtnAddr";

    /** set 단위기관상세주소 : payMangeDeptDtlPatrAddr */
    public static final String ATTR_PAYMANGEDEPTDTLPATRADDR = "payMangeDeptDtlPatrAddr";

    /** set 단위기관전화번호 : payMangeDeptPhnNum */
    public static final String ATTR_PAYMANGEDEPTPHNNUM = "payMangeDeptPhnNum";

    /** set 단위기관팩스번호 : payMangeDeptFaxNum */
    public static final String ATTR_PAYMANGEDEPTFAXNUM = "payMangeDeptFaxNum";

    /** set 단위기관직인문구명 : payMangeDeptSealWrdNm */
    public static final String ATTR_PAYMANGEDEPTSEALWRDNM = "payMangeDeptSealWrdNm";

    /** set 단위기관직인경로 : payMangeDeptSealRftaNm */
    public static final String ATTR_PAYMANGEDEPTSEALRFTANM = "payMangeDeptSealRftaNm";

    /** set 단위기관직인파일명 : payMangeDeptSealFlNm */
    public static final String ATTR_PAYMANGEDEPTSEALFLNM = "payMangeDeptSealFlNm";

    /** set 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
    public static final String ATTR_PAYMANGEDEPTFNDTNUSEYN = "payMangeDeptFNdtnUseYn";

    /** set 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
    public static final String ATTR_PAYMANGEDEPTWHLEPERNCHRG = "payMangeDeptWhlePernChrg";

    /** set 단위기관분임지출관 : payMangeDeptDivTskOffr */
    public static final String ATTR_PAYMANGEDEPTDIVTSKOFFR = "payMangeDeptDivTskOffr";

    /** set 회계코드 : accCd */
    public static final String ATTR_ACCCD = "accCd";

    /** set 건강보험기호 : hlthInsrSym */
    public static final String ATTR_HLTHINSRSYM = "hlthInsrSym";

    /** set 국민연금기호 : natPennSym */
    public static final String ATTR_NATPENNSYM = "natPennSym";

    /** set 고용보험기호 : umytInsrSym */
    public static final String ATTR_UMYTINSRSYM = "umytInsrSym";

    /** set 징수의무자명 : cllnDebrNm */
    public static final String ATTR_CLLNDEBRNM = "cllnDebrNm";

    /** set 홈텍스ID : hmtxId */
    public static final String ATTR_HMTXID = "hmtxId";

    /** set 세무서코드 : txOffcCd */
    public static final String ATTR_TXOFFCCD = "txOffcCd";

    /** set 은행코드 : bnkCd */
    public static final String ATTR_BNKCD = "bnkCd";

    /** set 지로이체코드 : groTnsrCd */
    public static final String ATTR_GROTNSRCD = "groTnsrCd";

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
     public PrgmComBass0150BM() { super(); } 

    /** 일괄등록 처리   */
     public PrgmComBass0150BM(
    		 String  dpobCd 
    		, String  payrMangDeptCd 
    		, String  payMangeDeptNm 
    		, String  degtrResnRegnNum 
    		, String  degtrNm 
    		, String  busoprRgstnNum 
    		, String  corpRgstnNum 
    		, String  corpDivCd 
    		, String  payMangeDeptZpcd 
    		, String  payMangeDeptFNdtnAddr 
    		, String  payMangeDeptDtlPatrAddr 
    		, String  payMangeDeptPhnNum 
    		, String  payMangeDeptFaxNum 
    		, String  payMangeDeptSealWrdNm 
    		, String  payMangeDeptSealRftaNm 
    		, String  payMangeDeptSealFlNm 
    		, String  payMangeDeptFNdtnUseYn 
    		, String  payMangeDeptWhlePernChrg 
    		, String  payMangeDeptDivTskOffr 
    		, String  accCd 
    		, String  hlthInsrSym 
    		, String  natPennSym 
    		, String  umytInsrSym 
    		, String  cllnDebrNm 
    		, String  hmtxId 
    		, String  txOffcCd 
    		, String  bnkCd 
    		, String  groTnsrCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_PAYMANGEDEPTNM,payMangeDeptNm);
     	values.put(ATTR_DEGTRRESNREGNNUM,degtrResnRegnNum);
     	values.put(ATTR_DEGTRNM,degtrNm);
     	values.put(ATTR_BUSOPRRGSTNNUM,busoprRgstnNum);
     	values.put(ATTR_CORPRGSTNNUM,corpRgstnNum);
     	values.put(ATTR_CORPDIVCD,corpDivCd);
     	values.put(ATTR_PAYMANGEDEPTZPCD,payMangeDeptZpcd);
     	values.put(ATTR_PAYMANGEDEPTFNDTNADDR,payMangeDeptFNdtnAddr);
     	values.put(ATTR_PAYMANGEDEPTDTLPATRADDR,payMangeDeptDtlPatrAddr);
     	values.put(ATTR_PAYMANGEDEPTPHNNUM,payMangeDeptPhnNum);
     	values.put(ATTR_PAYMANGEDEPTFAXNUM,payMangeDeptFaxNum);
     	values.put(ATTR_PAYMANGEDEPTSEALWRDNM,payMangeDeptSealWrdNm);
     	values.put(ATTR_PAYMANGEDEPTSEALRFTANM,payMangeDeptSealRftaNm);
     	values.put(ATTR_PAYMANGEDEPTSEALFLNM,payMangeDeptSealFlNm);
     	values.put(ATTR_PAYMANGEDEPTFNDTNUSEYN,payMangeDeptFNdtnUseYn);
     	values.put(ATTR_PAYMANGEDEPTWHLEPERNCHRG,payMangeDeptWhlePernChrg);
     	values.put(ATTR_PAYMANGEDEPTDIVTSKOFFR,payMangeDeptDivTskOffr);
     	values.put(ATTR_ACCCD,accCd);
     	values.put(ATTR_HLTHINSRSYM,hlthInsrSym);
     	values.put(ATTR_NATPENNSYM,natPennSym);
     	values.put(ATTR_UMYTINSRSYM,umytInsrSym);
     	values.put(ATTR_CLLNDEBRNM,cllnDebrNm);
     	values.put(ATTR_HMTXID,hmtxId);
     	values.put(ATTR_TXOFFCCD,txOffcCd);
     	values.put(ATTR_BNKCD,bnkCd);
     	values.put(ATTR_GROTNSRCD,groTnsrCd);
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

    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 단위기관명 : payMangeDeptNm */
    public void setPayMangeDeptNm(String  payMangeDeptNm) { set( ATTR_PAYMANGEDEPTNM ,payMangeDeptNm);}
    /** get 단위기관명 : payMangeDeptNm */
    public String  getPayMangeDeptNm() { return (String )get( ATTR_PAYMANGEDEPTNM );}

    /** set 대표자주민번호 : degtrResnRegnNum */
    public void setDegtrResnRegnNum(String  degtrResnRegnNum) { set( ATTR_DEGTRRESNREGNNUM ,degtrResnRegnNum);}
    /** get 대표자주민번호 : degtrResnRegnNum */
    public String  getDegtrResnRegnNum() { return (String )get( ATTR_DEGTRRESNREGNNUM );}

    /** set 대표자명 : degtrNm */
    public void setDegtrNm(String  degtrNm) { set( ATTR_DEGTRNM ,degtrNm);}
    /** get 대표자명 : degtrNm */
    public String  getDegtrNm() { return (String )get( ATTR_DEGTRNM );}

    /** set 사업자등록번호 : busoprRgstnNum */
    public void setBusoprRgstnNum(String  busoprRgstnNum) { set( ATTR_BUSOPRRGSTNNUM ,busoprRgstnNum);}
    /** get 사업자등록번호 : busoprRgstnNum */
    public String  getBusoprRgstnNum() { return (String )get( ATTR_BUSOPRRGSTNNUM );}

    /** set 법인등록번호 : corpRgstnNum */
    public void setCorpRgstnNum(String  corpRgstnNum) { set( ATTR_CORPRGSTNNUM ,corpRgstnNum);}
    /** get 법인등록번호 : corpRgstnNum */
    public String  getCorpRgstnNum() { return (String )get( ATTR_CORPRGSTNNUM );}

    /** set 법인구분코드 : corpDivCd */
    public void setCorpDivCd(String  corpDivCd) { set( ATTR_CORPDIVCD ,corpDivCd);}
    /** get 법인구분코드 : corpDivCd */
    public String  getCorpDivCd() { return (String )get( ATTR_CORPDIVCD );}

    /** set 단위기관우편번호 : payMangeDeptZpcd */
    public void setPayMangeDeptZpcd(String  payMangeDeptZpcd) { set( ATTR_PAYMANGEDEPTZPCD ,payMangeDeptZpcd);}
    /** get 단위기관우편번호 : payMangeDeptZpcd */
    public String  getPayMangeDeptZpcd() { return (String )get( ATTR_PAYMANGEDEPTZPCD );}

    /** set 단위기관기본주소 : payMangeDeptFNdtnAddr */
    public void setPayMangeDeptFNdtnAddr(String  payMangeDeptFNdtnAddr) { set( ATTR_PAYMANGEDEPTFNDTNADDR ,payMangeDeptFNdtnAddr);}
    /** get 단위기관기본주소 : payMangeDeptFNdtnAddr */
    public String  getPayMangeDeptFNdtnAddr() { return (String )get( ATTR_PAYMANGEDEPTFNDTNADDR );}

    /** set 단위기관상세주소 : payMangeDeptDtlPatrAddr */
    public void setPayMangeDeptDtlPatrAddr(String  payMangeDeptDtlPatrAddr) { set( ATTR_PAYMANGEDEPTDTLPATRADDR ,payMangeDeptDtlPatrAddr);}
    /** get 단위기관상세주소 : payMangeDeptDtlPatrAddr */
    public String  getPayMangeDeptDtlPatrAddr() { return (String )get( ATTR_PAYMANGEDEPTDTLPATRADDR );}

    /** set 단위기관전화번호 : payMangeDeptPhnNum */
    public void setPayMangeDeptPhnNum(String  payMangeDeptPhnNum) { set( ATTR_PAYMANGEDEPTPHNNUM ,payMangeDeptPhnNum);}
    /** get 단위기관전화번호 : payMangeDeptPhnNum */
    public String  getPayMangeDeptPhnNum() { return (String )get( ATTR_PAYMANGEDEPTPHNNUM );}

    /** set 단위기관팩스번호 : payMangeDeptFaxNum */
    public void setPayMangeDeptFaxNum(String  payMangeDeptFaxNum) { set( ATTR_PAYMANGEDEPTFAXNUM ,payMangeDeptFaxNum);}
    /** get 단위기관팩스번호 : payMangeDeptFaxNum */
    public String  getPayMangeDeptFaxNum() { return (String )get( ATTR_PAYMANGEDEPTFAXNUM );}

    /** set 단위기관직인문구명 : payMangeDeptSealWrdNm */
    public void setPayMangeDeptSealWrdNm(String  payMangeDeptSealWrdNm) { set( ATTR_PAYMANGEDEPTSEALWRDNM ,payMangeDeptSealWrdNm);}
    /** get 단위기관직인문구명 : payMangeDeptSealWrdNm */
    public String  getPayMangeDeptSealWrdNm() { return (String )get( ATTR_PAYMANGEDEPTSEALWRDNM );}

    /** set 단위기관직인경로 : payMangeDeptSealRftaNm */
    public void setPayMangeDeptSealRftaNm(String  payMangeDeptSealRftaNm) { set( ATTR_PAYMANGEDEPTSEALRFTANM ,payMangeDeptSealRftaNm);}
    /** get 단위기관직인경로 : payMangeDeptSealRftaNm */
    public String  getPayMangeDeptSealRftaNm() { return (String )get( ATTR_PAYMANGEDEPTSEALRFTANM );}

    /** set 단위기관직인파일명 : payMangeDeptSealFlNm */
    public void setPayMangeDeptSealFlNm(String  payMangeDeptSealFlNm) { set( ATTR_PAYMANGEDEPTSEALFLNM ,payMangeDeptSealFlNm);}
    /** get 단위기관직인파일명 : payMangeDeptSealFlNm */
    public String  getPayMangeDeptSealFlNm() { return (String )get( ATTR_PAYMANGEDEPTSEALFLNM );}

    /** set 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
    public void setPayMangeDeptFNdtnUseYn(String  payMangeDeptFNdtnUseYn) { set( ATTR_PAYMANGEDEPTFNDTNUSEYN ,payMangeDeptFNdtnUseYn);}
    /** get 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
    public String  getPayMangeDeptFNdtnUseYn() { return (String )get( ATTR_PAYMANGEDEPTFNDTNUSEYN );}

    /** set 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
    public void setPayMangeDeptWhlePernChrg(String  payMangeDeptWhlePernChrg) { set( ATTR_PAYMANGEDEPTWHLEPERNCHRG ,payMangeDeptWhlePernChrg);}
    /** get 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
    public String  getPayMangeDeptWhlePernChrg() { return (String )get( ATTR_PAYMANGEDEPTWHLEPERNCHRG );}

    /** set 단위기관분임지출관 : payMangeDeptDivTskOffr */
    public void setPayMangeDeptDivTskOffr(String  payMangeDeptDivTskOffr) { set( ATTR_PAYMANGEDEPTDIVTSKOFFR ,payMangeDeptDivTskOffr);}
    /** get 단위기관분임지출관 : payMangeDeptDivTskOffr */
    public String  getPayMangeDeptDivTskOffr() { return (String )get( ATTR_PAYMANGEDEPTDIVTSKOFFR );}

    /** set 회계코드 : accCd */
    public void setAccCd(String  accCd) { set( ATTR_ACCCD ,accCd);}
    /** get 회계코드 : accCd */
    public String  getAccCd() { return (String )get( ATTR_ACCCD );}

    /** set 건강보험기호 : hlthInsrSym */
    public void setHlthInsrSym(String  hlthInsrSym) { set( ATTR_HLTHINSRSYM ,hlthInsrSym);}
    /** get 건강보험기호 : hlthInsrSym */
    public String  getHlthInsrSym() { return (String )get( ATTR_HLTHINSRSYM );}

    /** set 국민연금기호 : natPennSym */
    public void setNatPennSym(String  natPennSym) { set( ATTR_NATPENNSYM ,natPennSym);}
    /** get 국민연금기호 : natPennSym */
    public String  getNatPennSym() { return (String )get( ATTR_NATPENNSYM );}

    /** set 고용보험기호 : umytInsrSym */
    public void setUmytInsrSym(String  umytInsrSym) { set( ATTR_UMYTINSRSYM ,umytInsrSym);}
    /** get 고용보험기호 : umytInsrSym */
    public String  getUmytInsrSym() { return (String )get( ATTR_UMYTINSRSYM );}

    /** set 징수의무자명 : cllnDebrNm */
    public void setCllnDebrNm(String  cllnDebrNm) { set( ATTR_CLLNDEBRNM ,cllnDebrNm);}
    /** get 징수의무자명 : cllnDebrNm */
    public String  getCllnDebrNm() { return (String )get( ATTR_CLLNDEBRNM );}

    /** set 홈텍스ID : hmtxId */
    public void setHmtxId(String  hmtxId) { set( ATTR_HMTXID ,hmtxId);}
    /** get 홈텍스ID : hmtxId */
    public String  getHmtxId() { return (String )get( ATTR_HMTXID );}

    /** set 세무서코드 : txOffcCd */
    public void setTxOffcCd(String  txOffcCd) { set( ATTR_TXOFFCCD ,txOffcCd);}
    /** get 세무서코드 : txOffcCd */
    public String  getTxOffcCd() { return (String )get( ATTR_TXOFFCCD );}

    /** set 은행코드 : bnkCd */
    public void setBnkCd(String  bnkCd) { set( ATTR_BNKCD ,bnkCd);}
    /** get 은행코드 : bnkCd */
    public String  getBnkCd() { return (String )get( ATTR_BNKCD );}

    /** set 지로이체코드 : groTnsrCd */
    public void setGroTnsrCd(String  groTnsrCd) { set( ATTR_GROTNSRCD ,groTnsrCd);}
    /** get 지로이체코드 : groTnsrCd */
    public String  getGroTnsrCd() { return (String )get( ATTR_GROTNSRCD );}

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
