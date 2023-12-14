package com.app.exterms.yearendtax.client.dto.yeta2018;



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
public class PdfA102yBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 증권번호 : accNo */
    public static final String ATTR_ACCNO = "accNo";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 주민등록번호 : resid */
    public static final String ATTR_RESID = "resid";

    /** set 성명 : name */
    public static final String ATTR_NAME = "name";

    /** set 자료코드 : datCd */
    public static final String ATTR_DATCD = "datCd";

    /** set 사업자번호 : busnid */
    public static final String ATTR_BUSNID = "busnid";

    /** set 상호명 : tradeNm */
    public static final String ATTR_TRADENM = "tradeNm";

    /** set 보험종류 : goodsNm */
    public static final String ATTR_GOODSNM = "goodsNm";

    /** set 주민등록번호_주피보험자 : insu1Resid */
    public static final String ATTR_INSU1RESID = "insu1Resid";

    /** set 성명_주피보험자 : insu1Nm */
    public static final String ATTR_INSU1NM = "insu1Nm";

    /** set 주민등록번호_종피보험자1 : insu2Resid1 */
    public static final String ATTR_INSU2RESID1 = "insu2Resid1";

    /** set 성명_종피보험자1 : insu2Nm1 */
    public static final String ATTR_INSU2NM1 = "insu2Nm1";

    /** set 주민등록번호_종피보험자2 : insu2Resid2 */
    public static final String ATTR_INSU2RESID2 = "insu2Resid2";

    /** set 성명_종피보험자2 : insu2Nm2 */
    public static final String ATTR_INSU2NM2 = "insu2Nm2";

    /** set 주민등록번호_종피보험자3 : insu2Resid3 */
    public static final String ATTR_INSU2RESID3 = "insu2Resid3";

    /** set 성명_종피보험자3 : insu2Nm3 */
    public static final String ATTR_INSU2NM3 = "insu2Nm3";

    /** set 보험료납입금액계 : insuPaySum */
    public static final String ATTR_INSUPAYSUM = "insuPaySum";

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
     public PdfA102yBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfA102yBM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  accNo 
    		, String  formCd 
    		, String  resid 
    		, String  name 
    		, String  datCd 
    		, String  busnid 
    		, String  tradeNm 
    		, String  goodsNm 
    		, String  insu1Resid 
    		, String  insu1Nm 
    		, String  insu2Resid1 
    		, String  insu2Nm1 
    		, String  insu2Resid2 
    		, String  insu2Nm2 
    		, String  insu2Resid3 
    		, String  insu2Nm3 
    		, Long  insuPaySum 
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
     	values.put(ATTR_ACCNO,accNo);
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_RESID,resid);
     	values.put(ATTR_NAME,name);
     	values.put(ATTR_DATCD,datCd);
     	values.put(ATTR_BUSNID,busnid);
     	values.put(ATTR_TRADENM,tradeNm);
     	values.put(ATTR_GOODSNM,goodsNm);
     	values.put(ATTR_INSU1RESID,insu1Resid);
     	values.put(ATTR_INSU1NM,insu1Nm);
     	values.put(ATTR_INSU2RESID1,insu2Resid1);
     	values.put(ATTR_INSU2NM1,insu2Nm1);
     	values.put(ATTR_INSU2RESID2,insu2Resid2);
     	values.put(ATTR_INSU2NM2,insu2Nm2);
     	values.put(ATTR_INSU2RESID3,insu2Resid3);
     	values.put(ATTR_INSU2NM3,insu2Nm3);
     	values.put(ATTR_INSUPAYSUM,insuPaySum);
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

    /** set 증권번호 : accNo */
    public void setAccNo(String  accNo) { set( ATTR_ACCNO ,accNo);}
    /** get 증권번호 : accNo */
    public String  getAccNo() { return (String )get( ATTR_ACCNO );}

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 주민등록번호 : resid */
    public void setResid(String  resid) { set( ATTR_RESID ,resid);}
    /** get 주민등록번호 : resid */
    public String  getResid() { return (String )get( ATTR_RESID );}

    /** set 성명 : name */
    public void setName(String  name) { set( ATTR_NAME ,name);}
    /** get 성명 : name */
    public String  getName() { return (String )get( ATTR_NAME );}

    /** set 자료코드 : datCd */
    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
    /** get 자료코드 : datCd */
    public String  getDatCd() { return (String )get( ATTR_DATCD );}

    /** set 사업자번호 : busnid */
    public void setBusnid(String  busnid) { set( ATTR_BUSNID ,busnid);}
    /** get 사업자번호 : busnid */
    public String  getBusnid() { return (String )get( ATTR_BUSNID );}

    /** set 상호명 : tradeNm */
    public void setTradeNm(String  tradeNm) { set( ATTR_TRADENM ,tradeNm);}
    /** get 상호명 : tradeNm */
    public String  getTradeNm() { return (String )get( ATTR_TRADENM );}

    /** set 보험종류 : goodsNm */
    public void setGoodsNm(String  goodsNm) { set( ATTR_GOODSNM ,goodsNm);}
    /** get 보험종류 : goodsNm */
    public String  getGoodsNm() { return (String )get( ATTR_GOODSNM );}

    /** set 주민등록번호_주피보험자 : insu1Resid */
    public void setInsu1Resid(String  insu1Resid) { set( ATTR_INSU1RESID ,insu1Resid);}
    /** get 주민등록번호_주피보험자 : insu1Resid */
    public String  getInsu1Resid() { return (String )get( ATTR_INSU1RESID );}

    /** set 성명_주피보험자 : insu1Nm */
    public void setInsu1Nm(String  insu1Nm) { set( ATTR_INSU1NM ,insu1Nm);}
    /** get 성명_주피보험자 : insu1Nm */
    public String  getInsu1Nm() { return (String )get( ATTR_INSU1NM );}

    /** set 주민등록번호_종피보험자1 : insu2Resid1 */
    public void setInsu2Resid1(String  insu2Resid1) { set( ATTR_INSU2RESID1 ,insu2Resid1);}
    /** get 주민등록번호_종피보험자1 : insu2Resid1 */
    public String  getInsu2Resid1() { return (String )get( ATTR_INSU2RESID1 );}

    /** set 성명_종피보험자1 : insu2Nm1 */
    public void setInsu2Nm1(String  insu2Nm1) { set( ATTR_INSU2NM1 ,insu2Nm1);}
    /** get 성명_종피보험자1 : insu2Nm1 */
    public String  getInsu2Nm1() { return (String )get( ATTR_INSU2NM1 );}

    /** set 주민등록번호_종피보험자2 : insu2Resid2 */
    public void setInsu2Resid2(String  insu2Resid2) { set( ATTR_INSU2RESID2 ,insu2Resid2);}
    /** get 주민등록번호_종피보험자2 : insu2Resid2 */
    public String  getInsu2Resid2() { return (String )get( ATTR_INSU2RESID2 );}

    /** set 성명_종피보험자2 : insu2Nm2 */
    public void setInsu2Nm2(String  insu2Nm2) { set( ATTR_INSU2NM2 ,insu2Nm2);}
    /** get 성명_종피보험자2 : insu2Nm2 */
    public String  getInsu2Nm2() { return (String )get( ATTR_INSU2NM2 );}

    /** set 주민등록번호_종피보험자3 : insu2Resid3 */
    public void setInsu2Resid3(String  insu2Resid3) { set( ATTR_INSU2RESID3 ,insu2Resid3);}
    /** get 주민등록번호_종피보험자3 : insu2Resid3 */
    public String  getInsu2Resid3() { return (String )get( ATTR_INSU2RESID3 );}

    /** set 성명_종피보험자3 : insu2Nm3 */
    public void setInsu2Nm3(String  insu2Nm3) { set( ATTR_INSU2NM3 ,insu2Nm3);}
    /** get 성명_종피보험자3 : insu2Nm3 */
    public String  getInsu2Nm3() { return (String )get( ATTR_INSU2NM3 );}

    /** set 보험료납입금액계 : insuPaySum */
    public void setInsuPaySum(Long  insuPaySum) { set( ATTR_INSUPAYSUM ,insuPaySum);}
    /** get 보험료납입금액계 : insuPaySum */
    public Long  getInsuPaySum() { return (Long )get( ATTR_INSUPAYSUM );}

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    public void setPdfDatAppYn(String  pdfDatAppYn) { set( ATTR_PDFDATAPPYN ,pdfDatAppYn);}
    /** get pdf 소득공제자료적용여부 : pdfDatAppYn */
    public String  getPdfDatAppYn() { return (String )get( ATTR_PDFDATAPPYN );}
    
    /** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public void setPdfDatAppCmplDt(String  pdfDatAppCmplDt) { set( ATTR_PDFDATAPPCMPLDT ,pdfDatAppCmplDt);}
    /** get pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public String  getPdfDatAppCmplDt() { return (String )get( ATTR_PDFDATAPPCMPLDT );}
    
    /** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
    public void setPdfDatAppExcCtnt(String  pdfDatAppExcCtnt) {	set( ATTR_PDFDATAPPEXCCTNT ,pdfDatAppExcCtnt);}
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
