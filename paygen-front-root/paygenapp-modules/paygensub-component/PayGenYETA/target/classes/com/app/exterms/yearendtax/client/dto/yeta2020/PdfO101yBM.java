package com.app.exterms.yearendtax.client.dto.yeta2020;



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
public class PdfO101yBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 자료코드 : datCd */
    public static final String ATTR_DATCD = "datCd";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 건강보험료_주민등록번호 : resid */
    public static final String ATTR_RESID = "resid";

    /** set 건강보험료_성명 : name */
    public static final String ATTR_NAME = "name";

    /** set 건강보험료총합계금액 : hlthAmtSum */
    public static final String ATTR_HLTHAMTSUM = "hlthAmtSum";

    /** set 건강보험연말정산금액 : hiYrs */
    public static final String ATTR_HIYRS = "hiYrs";

    /** set 장기요양연말정산금액 : ltrmYrs */
    public static final String ATTR_LTRMYRS = "ltrmYrs";

    /** set 건강보험_보수월액_고지금액합계 : hiNtf */
    public static final String ATTR_HINTF = "hiNtf";

    /** set 장기요양_보수월액_고지금액합계 : ltrmNtf */
    public static final String ATTR_LTRMNTF = "ltrmNtf";

    /** set 건강보험_소득월액_납부금액합계 : hiPmt */
    public static final String ATTR_HIPMT = "hiPmt";

    /** set 장기요양_소득월액_납부금액합계 : ltrmPmt */
    public static final String ATTR_LTRMPMT = "ltrmPmt";

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
     public PdfO101yBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfO101yBM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  datCd 
    		, String  formCd 
    		, String  resid 
    		, String  name 
    		, Long  hlthAmtSum 
    		, Long  hiYrs 
    		, Long  ltrmYrs 
    		, Long  hiNtf 
    		, Long  ltrmNtf 
    		, Long  hiPmt 
    		, Long  ltrmPmt 
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
     	values.put(ATTR_DATCD,datCd);
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_RESID,resid);
     	values.put(ATTR_NAME,name);
     	values.put(ATTR_HLTHAMTSUM,hlthAmtSum);
     	values.put(ATTR_HIYRS,hiYrs);
     	values.put(ATTR_LTRMYRS,ltrmYrs);
     	values.put(ATTR_HINTF,hiNtf);
     	values.put(ATTR_LTRMNTF,ltrmNtf);
     	values.put(ATTR_HIPMT,hiPmt);
     	values.put(ATTR_LTRMPMT,ltrmPmt);
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

    /** set 자료코드 : datCd */
    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
    /** get 자료코드 : datCd */
    public String  getDatCd() { return (String )get( ATTR_DATCD );}

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 건강보험료_주민등록번호 : resid */
    public void setResid(String  resid) { set( ATTR_RESID ,resid);}
    /** get 건강보험료_주민등록번호 : resid */
    public String  getResid() { return (String )get( ATTR_RESID );}

    /** set 건강보험료_성명 : name */
    public void setName(String  name) { set( ATTR_NAME ,name);}
    /** get 건강보험료_성명 : name */
    public String  getName() { return (String )get( ATTR_NAME );}

    /** set 건강보험료총합계금액 : hlthAmtSum */
    public void setHlthAmtSum(Long  hlthAmtSum) { set( ATTR_HLTHAMTSUM ,hlthAmtSum);}
    /** get 건강보험료총합계금액 : hlthAmtSum */
    public Long  getHlthAmtSum() { return (Long )get( ATTR_HLTHAMTSUM );}

    /** set 건강보험연말정산금액 : hiYrs */
    public void setHiYrs(Long  hiYrs) { set( ATTR_HIYRS ,hiYrs);}
    /** get 건강보험연말정산금액 : hiYrs */
    public Long  getHiYrs() { return (Long )get( ATTR_HIYRS );}

    /** set 장기요양연말정산금액 : ltrmYrs */
    public void setLtrmYrs(Long  ltrmYrs) { set( ATTR_LTRMYRS ,ltrmYrs);}
    /** get 장기요양연말정산금액 : ltrmYrs */
    public Long  getLtrmYrs() { return (Long )get( ATTR_LTRMYRS );}

    /** set 건강보험_보수월액_고지금액합계 : hiNtf */
    public void setHiNtf(Long  hiNtf) { set( ATTR_HINTF ,hiNtf);}
    /** get 건강보험_보수월액_고지금액합계 : hiNtf */
    public Long  getHiNtf() { return (Long )get( ATTR_HINTF );}

    /** set 장기요양_보수월액_고지금액합계 : ltrmNtf */
    public void setLtrmNtf(Long  ltrmNtf) { set( ATTR_LTRMNTF ,ltrmNtf);}
    /** get 장기요양_보수월액_고지금액합계 : ltrmNtf */
    public Long  getLtrmNtf() { return (Long )get( ATTR_LTRMNTF );}

    /** set 건강보험_소득월액_납부금액합계 : hiPmt */
    public void setHiPmt(Long  hiPmt) { set( ATTR_HIPMT ,hiPmt);}
    /** get 건강보험_소득월액_납부금액합계 : hiPmt */
    public Long  getHiPmt() { return (Long )get( ATTR_HIPMT );}

    /** set 장기요양_소득월액_납부금액합계 : ltrmPmt */
    public void setLtrmPmt(Long  ltrmPmt) { set( ATTR_LTRMPMT ,ltrmPmt);}
    /** get 장기요양_소득월액_납부금액합계 : ltrmPmt */
    public Long  getLtrmPmt() { return (Long )get( ATTR_LTRMPMT );}

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
