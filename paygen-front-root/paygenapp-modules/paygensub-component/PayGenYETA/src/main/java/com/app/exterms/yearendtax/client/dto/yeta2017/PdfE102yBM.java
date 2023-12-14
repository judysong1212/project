package com.app.exterms.yearendtax.client.dto.yeta2017;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfE102yBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 연금저축계좌번호 : pnsnSvSeilNum */
    public static final String ATTR_PNSNSVSEILNUM = "pnsnSvSeilNum";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 연금저축주민등록번호 : resid */
    public static final String ATTR_RESID = "resid";

    /** set 연금저축성명 : name */
    public static final String ATTR_NAME = "name";

    /** set 자료코드 : datCd */
    public static final String ATTR_DATCD = "datCd";

    /** set 연금저축사업자등록번호 : busnid */
    public static final String ATTR_BUSNID = "busnid";

    /** set 연금저축상호명 : tradeNm */
    public static final String ATTR_TRADENM = "tradeNm";

    /** set 연금저축금융회사등코드 : comCd */
    public static final String ATTR_COMCD = "comCd";

    /** set 연금저축당해연도납입금액 : annTotAmt */
    public static final String ATTR_ANNTOTAMT = "annTotAmt";

    /** set 연금저축당해연도인출금액 : taxYearAmt */
    public static final String ATTR_TAXYEARAMT = "taxYearAmt";

    /** set 연금저축순납입금액 : ddctBsAssAmt */
    public static final String ATTR_DDCTBSASSAMT = "ddctBsAssAmt";

    /** set 연금저축납입금액합계 : pnsnSvSum */
    public static final String ATTR_PNSNSVSUM = "pnsnSvSum";

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    public static final String ATTR_PDFDATAPPYN = "pdfDatAppYn";
    
    /** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public static final String ATTR_PDFDATAPPCMPLDT = "pdfDatAppCmplDt";
    
    /** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
    public static final String ATTR_PDFDATAPPEXCCTNT= "pdfDatAppExcCtnt";

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
     public PdfE102yBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfE102yBM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  pnsnSvSeilNum 
    		, String  formCd 
    		, String  resid 
    		, String  name 
    		, String  datCd 
    		, String  busnid 
    		, String  tradeNm 
    		, String  comCd 
    		, Long  annTotAmt 
    		, Long  taxYearAmt 
    		, Long  ddctBsAssAmt 
    		, Long  pnsnSvSum 
    		, String  pdfDatAppYn 
    		, String  pdfDatAppCmplDt
    		, String  pdfDatAppExcCtnt
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PNSNSVSEILNUM,pnsnSvSeilNum);
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_RESID,resid);
     	values.put(ATTR_NAME,name);
     	values.put(ATTR_DATCD,datCd);
     	values.put(ATTR_BUSNID,busnid);
     	values.put(ATTR_TRADENM,tradeNm);
     	values.put(ATTR_COMCD,comCd);
     	values.put(ATTR_ANNTOTAMT,annTotAmt);
     	values.put(ATTR_TAXYEARAMT,taxYearAmt);
     	values.put(ATTR_DDCTBSASSAMT,ddctBsAssAmt);
     	values.put(ATTR_PNSNSVSUM,pnsnSvSum);
     	values.put(ATTR_PDFDATAPPYN,pdfDatAppYn);
     	values.put(ATTR_PDFDATAPPCMPLDT,pdfDatAppCmplDt);
     	values.put(ATTR_PDFDATAPPEXCCTNT,pdfDatAppExcCtnt);
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

    /** set 귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 연금저축계좌번호 : pnsnSvSeilNum */
    public void setPnsnSvSeilNum(String  pnsnSvSeilNum) { set( ATTR_PNSNSVSEILNUM ,pnsnSvSeilNum);}
    /** get 연금저축계좌번호 : pnsnSvSeilNum */
    public String  getPnsnSvSeilNum() { return (String )get( ATTR_PNSNSVSEILNUM );}

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 연금저축주민등록번호 : resid */
    public void setResid(String  resid) { set( ATTR_RESID ,resid);}
    /** get 연금저축주민등록번호 : resid */
    public String  getResid() { return (String )get( ATTR_RESID );}

    /** set 연금저축성명 : name */
    public void setName(String  name) { set( ATTR_NAME ,name);}
    /** get 연금저축성명 : name */
    public String  getName() { return (String )get( ATTR_NAME );}

    /** set 자료코드 : datCd */
    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
    /** get 자료코드 : datCd */
    public String  getDatCd() { return (String )get( ATTR_DATCD );}

    /** set 연금저축사업자등록번호 : busnid */
    public void setBusnid(String  busnid) { set( ATTR_BUSNID ,busnid);}
    /** get 연금저축사업자등록번호 : busnid */
    public String  getBusnid() { return (String )get( ATTR_BUSNID );}

    /** set 연금저축상호명 : tradeNm */
    public void setTradeNm(String  tradeNm) { set( ATTR_TRADENM ,tradeNm);}
    /** get 연금저축상호명 : tradeNm */
    public String  getTradeNm() { return (String )get( ATTR_TRADENM );}

    /** set 연금저축금융회사등코드 : comCd */
    public void setComCd(String  comCd) { set( ATTR_COMCD ,comCd);}
    /** get 연금저축금융회사등코드 : comCd */
    public String  getComCd() { return (String )get( ATTR_COMCD );}

    /** set 연금저축당해연도납입금액 : annTotAmt */
    public void setAnnTotAmt(Long  annTotAmt) { set( ATTR_ANNTOTAMT ,annTotAmt);}
    /** get 연금저축당해연도납입금액 : annTotAmt */
    public Long  getAnnTotAmt() { return (Long )get( ATTR_ANNTOTAMT );}

    /** set 연금저축당해연도인출금액 : taxYearAmt */
    public void setTaxYearAmt(Long  taxYearAmt) { set( ATTR_TAXYEARAMT ,taxYearAmt);}
    /** get 연금저축당해연도인출금액 : taxYearAmt */
    public Long  getTaxYearAmt() { return (Long )get( ATTR_TAXYEARAMT );}

    /** set 연금저축순납입금액 : ddctBsAssAmt */
    public void setDdctBsAssAmt(Long  ddctBsAssAmt) { set( ATTR_DDCTBSASSAMT ,ddctBsAssAmt);}
    /** get 연금저축순납입금액 : ddctBsAssAmt */
    public Long  getDdctBsAssAmt() { return (Long )get( ATTR_DDCTBSASSAMT );}

    /** set 연금저축납입금액합계 : pnsnSvSum */
    public void setPnsnSvSum(Long  pnsnSvSum) { set( ATTR_PNSNSVSUM ,pnsnSvSum);}
    /** get 연금저축납입금액합계 : pnsnSvSum */
    public Long  getPnsnSvSum() { return (Long )get( ATTR_PNSNSVSUM );}

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    public void setPdfDatAppYn(String  pdfDatAppYn) { set( ATTR_PDFDATAPPYN ,pdfDatAppYn);}
    /** get pdf 소득공제자료적용여부 : pdfDatAppYn */
    public String  getPdfDatAppYn() { return (String )get( ATTR_PDFDATAPPYN );}
    
    /** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public void setPdfDatAppCmplDt(String  pdfDatAppCmplDt) { set( ATTR_PDFDATAPPCMPLDT ,pdfDatAppCmplDt);}
    /** get pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public String  getPdfDatAppCmplDt() { return (String )get( ATTR_PDFDATAPPCMPLDT );}
    
    /** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
    public void setPdfDatAppExcCtnt(String  pdfDatAppExcCtnt) { set( ATTR_PDFDATAPPEXCCTNT ,pdfDatAppExcCtnt);}
    /** get pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
    public String  getPdfDatAppExcCtnt() { return (String )get( ATTR_PDFDATAPPEXCCTNT );}

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
