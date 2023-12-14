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
public class PdfJ203yBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 장기주택저당차입금일련번호 : loanSeilNum */
    public static final String ATTR_LOANSEILNUM = "loanSeilNum";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 장기주택저당차입금주민등록번호 : resid */
    public static final String ATTR_RESID = "resid";

    /** set 장기주택저당차입금성명 : name */
    public static final String ATTR_NAME = "name";

    /** set 자료코드 : datCd */
    public static final String ATTR_DATCD = "datCd";

    /** set 장기주택저당차입금사업자등록번호 : busnid */
    public static final String ATTR_BUSNID = "busnid";

    /** set 장기주택저당차입금취급기관명 : tradeNm */
    public static final String ATTR_TRADENM = "tradeNm";

    /** set 장기주택저당차입금계좌번호 : accNo */
    public static final String ATTR_ACCNO = "accNo";

    /** set 장기주택저당차입금대출종류 : lendKd */
    public static final String ATTR_LENDKD = "lendKd";

    /** set 장기주택저당차입금주택취득일자 : houseTakeDt */
    public static final String ATTR_HOUSETAKEDT = "houseTakeDt";

    /** set 장기주택저당차입금저당권설정일자 : mortSetupDt */
    public static final String ATTR_MORTSETUPDT = "mortSetupDt";

    /** set 장기주택저당차입금최초차입일자 : startDt */
    public static final String ATTR_STARTDT = "startDt";

    /** set 장기주택저당차입금최종상환예정일자 : endDt */
    public static final String ATTR_ENDDT = "endDt";

    /** set 장기주택저당차입금상환기간연수 : repayYears */
    public static final String ATTR_REPAYYEARS = "repayYears";

    /** set 장기주택저당차입금상품명 : lendGoodsNm */
    public static final String ATTR_LENDGOODSNM = "lendGoodsNm";

    /** set 장기주택저당차입금금액 : debt */
    public static final String ATTR_DEBT = "debt";

    /** set 장기주택저당차입금고정금리차입금 : fixedRateDebt */
    public static final String ATTR_FIXEDRATEDEBT = "fixedRateDebt";

    /** set 장기주택저당차입금비거치식상환차입금액 : notDeferDebt */
    public static final String ATTR_NOTDEFERDEBT = "notDeferDebt";

    /** set 장기주택저당차입금당해년원금상환액 : thisYearRedeAmt */
    public static final String ATTR_THISYEARREDEAMT = "thisYearRedeAmt";

    /** set 장기주택저당차입금소득공제대상금액 : sumDdct */
    public static final String ATTR_SUMDDCT = "sumDdct";

    /** set 장기주택저당차입금연간합계금액 : yearSumDdct */
    public static final String ATTR_YEARSUMDDCT = "yearSumDdct";

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
     public PdfJ203yBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfJ203yBM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, Long  loanSeilNum 
    		, String  formCd 
    		, String  resid 
    		, String  name 
    		, String  datCd 
    		, String  busnid 
    		, String  tradeNm 
    		, String  accNo 
    		, String  lendKd 
    		, String  houseTakeDt 
    		, String  mortSetupDt 
    		, String  startDt 
    		, String  endDt 
    		, Long  repayYears 
    		, String  lendGoodsNm 
    		, Long  debt 
    		, Long  fixedRateDebt 
    		, Long  notDeferDebt 
    		, Long  thisYearRedeAmt 
    		, Long  sumDdct 
    		, Long  yearSumDdct 
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
     	values.put(ATTR_LOANSEILNUM,loanSeilNum);
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_RESID,resid);
     	values.put(ATTR_NAME,name);
     	values.put(ATTR_DATCD,datCd);
     	values.put(ATTR_BUSNID,busnid);
     	values.put(ATTR_TRADENM,tradeNm);
     	values.put(ATTR_ACCNO,accNo);
     	values.put(ATTR_LENDKD,lendKd);
     	values.put(ATTR_HOUSETAKEDT,houseTakeDt);
     	values.put(ATTR_MORTSETUPDT,mortSetupDt);
     	values.put(ATTR_STARTDT,startDt);
     	values.put(ATTR_ENDDT,endDt);
     	values.put(ATTR_REPAYYEARS,repayYears);
     	values.put(ATTR_LENDGOODSNM,lendGoodsNm);
     	values.put(ATTR_DEBT,debt);
     	values.put(ATTR_FIXEDRATEDEBT,fixedRateDebt);
     	values.put(ATTR_NOTDEFERDEBT,notDeferDebt);
     	values.put(ATTR_THISYEARREDEAMT,thisYearRedeAmt);
     	values.put(ATTR_SUMDDCT,sumDdct);
     	values.put(ATTR_YEARSUMDDCT,yearSumDdct);
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

    /** set 장기주택저당차입금일련번호 : loanSeilNum */
    public void setLoanSeilNum(Long  loanSeilNum) { set( ATTR_LOANSEILNUM ,loanSeilNum);}
    /** get 장기주택저당차입금일련번호 : loanSeilNum */
    public Long  getLoanSeilNum() { return (Long )get( ATTR_LOANSEILNUM );}

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 장기주택저당차입금주민등록번호 : resid */
    public void setResid(String  resid) { set( ATTR_RESID ,resid);}
    /** get 장기주택저당차입금주민등록번호 : resid */
    public String  getResid() { return (String )get( ATTR_RESID );}

    /** set 장기주택저당차입금성명 : name */
    public void setName(String  name) { set( ATTR_NAME ,name);}
    /** get 장기주택저당차입금성명 : name */
    public String  getName() { return (String )get( ATTR_NAME );}

    /** set 자료코드 : datCd */
    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
    /** get 자료코드 : datCd */
    public String  getDatCd() { return (String )get( ATTR_DATCD );}

    /** set 장기주택저당차입금사업자등록번호 : busnid */
    public void setBusnid(String  busnid) { set( ATTR_BUSNID ,busnid);}
    /** get 장기주택저당차입금사업자등록번호 : busnid */
    public String  getBusnid() { return (String )get( ATTR_BUSNID );}

    /** set 장기주택저당차입금취급기관명 : tradeNm */
    public void setTradeNm(String  tradeNm) { set( ATTR_TRADENM ,tradeNm);}
    /** get 장기주택저당차입금취급기관명 : tradeNm */
    public String  getTradeNm() { return (String )get( ATTR_TRADENM );}

    /** set 장기주택저당차입금계좌번호 : accNo */
    public void setAccNo(String  accNo) { set( ATTR_ACCNO ,accNo);}
    /** get 장기주택저당차입금계좌번호 : accNo */
    public String  getAccNo() { return (String )get( ATTR_ACCNO );}

    /** set 장기주택저당차입금대출종류 : lendKd */
    public void setLendKd(String  lendKd) { set( ATTR_LENDKD ,lendKd);}
    /** get 장기주택저당차입금대출종류 : lendKd */
    public String  getLendKd() { return (String )get( ATTR_LENDKD );}

    /** set 장기주택저당차입금주택취득일자 : houseTakeDt */
    public void setHouseTakeDt(String  houseTakeDt) { set( ATTR_HOUSETAKEDT ,houseTakeDt);}
    /** get 장기주택저당차입금주택취득일자 : houseTakeDt */
    public String  getHouseTakeDt() { return (String )get( ATTR_HOUSETAKEDT );}

    /** set 장기주택저당차입금저당권설정일자 : mortSetupDt */
    public void setMortSetupDt(String  mortSetupDt) { set( ATTR_MORTSETUPDT ,mortSetupDt);}
    /** get 장기주택저당차입금저당권설정일자 : mortSetupDt */
    public String  getMortSetupDt() { return (String )get( ATTR_MORTSETUPDT );}

    /** set 장기주택저당차입금최초차입일자 : startDt */
    public void setStartDt(String  startDt) { set( ATTR_STARTDT ,startDt);}
    /** get 장기주택저당차입금최초차입일자 : startDt */
    public String  getStartDt() { return (String )get( ATTR_STARTDT );}

    /** set 장기주택저당차입금최종상환예정일자 : endDt */
    public void setEndDt(String  endDt) { set( ATTR_ENDDT ,endDt);}
    /** get 장기주택저당차입금최종상환예정일자 : endDt */
    public String  getEndDt() { return (String )get( ATTR_ENDDT );}

    /** set 장기주택저당차입금상환기간연수 : repayYears */
    public void setRepayYears(Long  repayYears) { set( ATTR_REPAYYEARS ,repayYears);}
    /** get 장기주택저당차입금상환기간연수 : repayYears */
    public Long  getRepayYears() { return (Long )get( ATTR_REPAYYEARS );}

    /** set 장기주택저당차입금상품명 : lendGoodsNm */
    public void setLendGoodsNm(String  lendGoodsNm) { set( ATTR_LENDGOODSNM ,lendGoodsNm);}
    /** get 장기주택저당차입금상품명 : lendGoodsNm */
    public String  getLendGoodsNm() { return (String )get( ATTR_LENDGOODSNM );}

    /** set 장기주택저당차입금금액 : debt */
    public void setDebt(Long  debt) { set( ATTR_DEBT ,debt);}
    /** get 장기주택저당차입금금액 : debt */
    public Long  getDebt() { return (Long )get( ATTR_DEBT );}

    /** set 장기주택저당차입금고정금리차입금 : fixedRateDebt */
    public void setFixedRateDebt(Long  fixedRateDebt) { set( ATTR_FIXEDRATEDEBT ,fixedRateDebt);}
    /** get 장기주택저당차입금고정금리차입금 : fixedRateDebt */
    public Long  getFixedRateDebt() { return (Long )get( ATTR_FIXEDRATEDEBT );}

    /** set 장기주택저당차입금비거치식상환차입금액 : notDeferDebt */
    public void setNotDeferDebt(Long  notDeferDebt) { set( ATTR_NOTDEFERDEBT ,notDeferDebt);}
    /** get 장기주택저당차입금비거치식상환차입금액 : notDeferDebt */
    public Long  getNotDeferDebt() { return (Long )get( ATTR_NOTDEFERDEBT );}

    /** set 장기주택저당차입금당해년원금상환액 : thisYearRedeAmt */
    public void setThisYearRedeAmt(Long  thisYearRedeAmt) { set( ATTR_THISYEARREDEAMT ,thisYearRedeAmt);}
    /** get 장기주택저당차입금당해년원금상환액 : thisYearRedeAmt */
    public Long  getThisYearRedeAmt() { return (Long )get( ATTR_THISYEARREDEAMT );}

    /** set 장기주택저당차입금소득공제대상금액 : sumDdct */
    public void setSumDdct(Long  sumDdct) { set( ATTR_SUMDDCT ,sumDdct);}
    /** get 장기주택저당차입금소득공제대상금액 : sumDdct */
    public Long  getSumDdct() { return (Long )get( ATTR_SUMDDCT );}

    /** set 장기주택저당차입금연간합계금액 : yearSumDdct */
    public void setYearSumDdct(Long  yearSumDdct) { set( ATTR_YEARSUMDDCT ,yearSumDdct);}
    /** get 장기주택저당차입금연간합계금액 : yearSumDdct */
    public Long  getYearSumDdct() { return (Long )get( ATTR_YEARSUMDDCT );}

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
