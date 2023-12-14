package com.app.exterms.yearendtax.client.dto.yeta2021;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye160404BM.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye160404BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final Long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";
    
    /** set 연말정산구분코드 : clutSeptNm */
    public static final String ATTR_CLUTSEPTNM = "clutSeptNm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public static final String ATTR_WHDGDEBRBUSOPRRGSTNUM = "whdgDebrBusoprRgstnum";

    /** set D4_종전근무처일련번호 : prcspSeilNum */
    public static final String ATTR_PRCSPSEILNUM = "prcspSeilNum";

    /** set D7_소득자주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";

    /** set D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
    public static final String ATTR_PRCSPTXPYRASOCYN = "prcspTxpyrAsocYn";

    /** set D9_종전근무처법인_상호명 : prcspFmnmNm */
    public static final String ATTR_PRCSPFMNMNM = "prcspFmnmNm";

    /** set D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
    public static final String ATTR_PRCSPBUSOPRRGSTNUM = "prcspBusoprRgstnum";

    /** set D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
    public static final String ATTR_PRCSPDUTYBGNNDT = "prcspDutyBgnnDt";

    /** set D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
    public static final String ATTR_PRCSPDUTYENDDT = "prcspDutyEndDt";

    /** set D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
    public static final String ATTR_PRCSPREDUBGNNDT = "prcspReduBgnnDt";

    /** set D14_종전근무처감면기간종료일자 : prcspReduEndDt */
    public static final String ATTR_PRCSPREDUENDDT = "prcspReduEndDt";

    /** set D15_종전근무처급여금액 : prcspPaySum */
    public static final String ATTR_PRCSPPAYSUM = "prcspPaySum";

    /** set D16_종전근무처상여금액 : prcspAllwBnusSum */
    public static final String ATTR_PRCSPALLWBNUSSUM = "prcspAllwBnusSum";

    /** set D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
    public static final String ATTR_PRCSPRCGTNBNUSSUM = "prcspRcgtnBnusSum";

    /** set D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
    public static final String ATTR_PRCSPSTCKEVNTPRFTSUM = "prcspStckEvntPrftSum";

    /** set D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
    public static final String ATTR_PRCSPEMPSTKSCWDRWSUM = "prcspEmpStkscWdrwSum";

    /** set D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
    public static final String ATTR_PRCSPECTERSGTNEXCESUM = "prcspEcteRsgtnExceSum";

    /** set D22_종전근무처합계금액 : prcspAggrSum */
    public static final String ATTR_PRCSPAGGRSUM = "prcspAggrSum";

    /** set D53_비과세합계금액 : freeDtyAggrSum */
    public static final String ATTR_FREEDTYAGGRSUM = "freeDtyAggrSum";

    /** set D54_감면소득합계금액 : reduIncmAggrSum */
    public static final String ATTR_REDUINCMAGGRSUM = "reduIncmAggrSum";

    /** set D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
    public static final String ATTR_PRCSPINCMTXSUM = "prcspIncmTxSum";

    /** set D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
    public static final String ATTR_PRCSPRGONINCMTXSUM = "prcspRgonIncmTxSum";

    /** set D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
    public static final String ATTR_PRCSPNNKSSUM = "prcspNnksSum";

    /** set 종전근무지건강보험료금액 : prcspHlthPrmmSum */
    public static final String ATTR_PRCSPHLTHPRMMSUM = "prcspHlthPrmmSum";

    /** set 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
    public static final String ATTR_PRCSPLGTMRCPTNSUM = "prcspLgtmRcptnSum";

    /** set 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
    public static final String ATTR_PRCSPHLTHLGCPTNAGGR = "prcspHlthLgcptnAggr";

    /** set 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
    public static final String ATTR_PRCSPHLTHPRMMDDUCSUM = "prcspHlthPrmmDducSum";

    /** set 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
    public static final String ATTR_PRCSPEMYMTPRMMSUM = "prcspEmymtPrmmSum";

    /** set 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
    public static final String ATTR_PRCSPEMYTPRMMDDUCSUM = "prcspEmytPrmmDducSum";

    /** set 종전근무지처리여부 : prcspPrcsYn */
    public static final String ATTR_PRCSPPRCSYN = "prcspPrcsYn";

    /** set 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */
    public static final String ATTR_PRCSPWHDGREIPSUMTYN = "prcspWhdgReipSumtYn";

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
    
    /** set C165_납부특례세액_소득세금액 : prcspYetaC165 */
    public static final String ATTR_PRCSPYETAC165 = "prcspYetaC165";

    /** set C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
    public static final String ATTR_PRCSPYETAC166 = "prcspYetaC166";

    /** set C167_납부특례세액_농특세금액 : prcspYetaC167 */
    public static final String ATTR_PRCSPYETAC167 = "prcspYetaC167";

    /** 생성자 */
     public Ye160404BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye160404BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  whdgDebrBusoprRgstnum 
    		, BigDecimal  prcspSeilNum 
    		, String  resnRegnNum 
    		, String  prcspTxpyrAsocYn 
    		, String  prcspFmnmNm 
    		, String  prcspBusoprRgstnum 
    		, String  prcspDutyBgnnDt 
    		, String  prcspDutyEndDt 
    		, String  prcspReduBgnnDt 
    		, String  prcspReduEndDt 
    		, BigDecimal  prcspPaySum 
    		, BigDecimal  prcspAllwBnusSum 
    		, BigDecimal  prcspRcgtnBnusSum 
    		, BigDecimal  prcspStckEvntPrftSum 
    		, BigDecimal  prcspEmpStkscWdrwSum 
    		, BigDecimal  prcspEcteRsgtnExceSum 
    		, BigDecimal  prcspAggrSum 
    		, BigDecimal  freeDtyAggrSum 
    		, BigDecimal  reduIncmAggrSum 
    		, BigDecimal  prcspIncmTxSum 
    		, BigDecimal  prcspRgonIncmTxSum 
    		, BigDecimal  prcspNnksSum 
    		, BigDecimal  prcspHlthPrmmSum 
    		, BigDecimal  prcspLgtmRcptnSum 
    		, BigDecimal  prcspHlthLgcptnAggr 
    		, BigDecimal  prcspHlthPrmmDducSum 
    		, BigDecimal  prcspEmymtPrmmSum 
    		, BigDecimal  prcspEmytPrmmDducSum 
    		, String  prcspPrcsYn 
    		, String  prcspWhdgReipSumtYn 
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
     	values.put(ATTR_WHDGDEBRBUSOPRRGSTNUM,whdgDebrBusoprRgstnum);
     	values.put(ATTR_PRCSPSEILNUM,prcspSeilNum);
     	values.put(ATTR_RESNREGNNUM,resnRegnNum);
     	values.put(ATTR_PRCSPTXPYRASOCYN,prcspTxpyrAsocYn);
     	values.put(ATTR_PRCSPFMNMNM,prcspFmnmNm);
     	values.put(ATTR_PRCSPBUSOPRRGSTNUM,prcspBusoprRgstnum);
     	values.put(ATTR_PRCSPDUTYBGNNDT,prcspDutyBgnnDt);
     	values.put(ATTR_PRCSPDUTYENDDT,prcspDutyEndDt);
     	values.put(ATTR_PRCSPREDUBGNNDT,prcspReduBgnnDt);
     	values.put(ATTR_PRCSPREDUENDDT,prcspReduEndDt);
     	values.put(ATTR_PRCSPPAYSUM,prcspPaySum);
     	values.put(ATTR_PRCSPALLWBNUSSUM,prcspAllwBnusSum);
     	values.put(ATTR_PRCSPRCGTNBNUSSUM,prcspRcgtnBnusSum);
     	values.put(ATTR_PRCSPSTCKEVNTPRFTSUM,prcspStckEvntPrftSum);
     	values.put(ATTR_PRCSPEMPSTKSCWDRWSUM,prcspEmpStkscWdrwSum);
     	values.put(ATTR_PRCSPECTERSGTNEXCESUM,prcspEcteRsgtnExceSum);
     	values.put(ATTR_PRCSPAGGRSUM,prcspAggrSum);
     	values.put(ATTR_FREEDTYAGGRSUM,freeDtyAggrSum);
     	values.put(ATTR_REDUINCMAGGRSUM,reduIncmAggrSum);
     	values.put(ATTR_PRCSPINCMTXSUM,prcspIncmTxSum);
     	values.put(ATTR_PRCSPRGONINCMTXSUM,prcspRgonIncmTxSum);
     	values.put(ATTR_PRCSPNNKSSUM,prcspNnksSum);
     	values.put(ATTR_PRCSPHLTHPRMMSUM,prcspHlthPrmmSum);
     	values.put(ATTR_PRCSPLGTMRCPTNSUM,prcspLgtmRcptnSum);
     	values.put(ATTR_PRCSPHLTHLGCPTNAGGR,prcspHlthLgcptnAggr);
     	values.put(ATTR_PRCSPHLTHPRMMDDUCSUM,prcspHlthPrmmDducSum);
     	values.put(ATTR_PRCSPEMYMTPRMMSUM,prcspEmymtPrmmSum);
     	values.put(ATTR_PRCSPEMYTPRMMDDUCSUM,prcspEmytPrmmDducSum);
     	values.put(ATTR_PRCSPPRCSYN,prcspPrcsYn);
     	values.put(ATTR_PRCSPWHDGREIPSUMTYN,prcspWhdgReipSumtYn);
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
    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}
    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}
    /** set 연말정산구분코드 : clutSeptNm */
    public void setClutSeptNm(String  clutSeptNm) { set( ATTR_CLUTSEPTNM ,clutSeptNm);}
    /** get 연말정산구분코드 : clutSeptNm */
    public String  getClutSeptNm() { return (String )get( ATTR_CLUTSEPTNM );}    
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public void setWhdgDebrBusoprRgstnum(String  whdgDebrBusoprRgstnum) { set( ATTR_WHDGDEBRBUSOPRRGSTNUM ,whdgDebrBusoprRgstnum);}
    /** get D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public String  getWhdgDebrBusoprRgstnum() { return (String )get( ATTR_WHDGDEBRBUSOPRRGSTNUM );}
    /** set D4_종전근무처일련번호 : prcspSeilNum */
    public void setPrcspSeilNum(BigDecimal  prcspSeilNum) { set( ATTR_PRCSPSEILNUM ,prcspSeilNum);}
    /** get D4_종전근무처일련번호 : prcspSeilNum */
    public BigDecimal  getPrcspSeilNum() { return (BigDecimal )get( ATTR_PRCSPSEILNUM );}
    /** set D7_소득자주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
    /** get D7_소득자주민등록번호 : resnRegnNum */
    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
    /** set D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
    public void setPrcspTxpyrAsocYn(String  prcspTxpyrAsocYn) { set( ATTR_PRCSPTXPYRASOCYN ,prcspTxpyrAsocYn);}
    /** get D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
    public String  getPrcspTxpyrAsocYn() { return (String )get( ATTR_PRCSPTXPYRASOCYN );}
    /** set D9_종전근무처법인_상호명 : prcspFmnmNm */
    public void setPrcspFmnmNm(String  prcspFmnmNm) { set( ATTR_PRCSPFMNMNM ,prcspFmnmNm);}
    /** get D9_종전근무처법인_상호명 : prcspFmnmNm */
    public String  getPrcspFmnmNm() { return (String )get( ATTR_PRCSPFMNMNM );}
    /** set D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
    public void setPrcspBusoprRgstnum(String  prcspBusoprRgstnum) { set( ATTR_PRCSPBUSOPRRGSTNUM ,prcspBusoprRgstnum);}
    /** get D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
    public String  getPrcspBusoprRgstnum() { return (String )get( ATTR_PRCSPBUSOPRRGSTNUM );}
    /** set D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
    public void setPrcspDutyBgnnDt(String  prcspDutyBgnnDt) { set( ATTR_PRCSPDUTYBGNNDT ,prcspDutyBgnnDt);}
    /** get D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
    public String  getPrcspDutyBgnnDt() { return (String )get( ATTR_PRCSPDUTYBGNNDT );}
    /** set D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
    public void setPrcspDutyEndDt(String  prcspDutyEndDt) { set( ATTR_PRCSPDUTYENDDT ,prcspDutyEndDt);}
    /** get D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
    public String  getPrcspDutyEndDt() { return (String )get( ATTR_PRCSPDUTYENDDT );}
    /** set D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
    public void setPrcspReduBgnnDt(String  prcspReduBgnnDt) { set( ATTR_PRCSPREDUBGNNDT ,prcspReduBgnnDt);}
    /** get D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
    public String  getPrcspReduBgnnDt() { return (String )get( ATTR_PRCSPREDUBGNNDT );}
    /** set D14_종전근무처감면기간종료일자 : prcspReduEndDt */
    public void setPrcspReduEndDt(String  prcspReduEndDt) { set( ATTR_PRCSPREDUENDDT ,prcspReduEndDt);}
    /** get D14_종전근무처감면기간종료일자 : prcspReduEndDt */
    public String  getPrcspReduEndDt() { return (String )get( ATTR_PRCSPREDUENDDT );}
    /** set D15_종전근무처급여금액 : prcspPaySum */
    public void setPrcspPaySum(Long  prcspPaySum) { set( ATTR_PRCSPPAYSUM ,prcspPaySum);}
    /** get D15_종전근무처급여금액 : prcspPaySum */
    public Long  getPrcspPaySum() { return (Long )get( ATTR_PRCSPPAYSUM );}
    /** set D16_종전근무처상여금액 : prcspAllwBnusSum */
    public void setPrcspAllwBnusSum(BigDecimal  prcspAllwBnusSum) { set( ATTR_PRCSPALLWBNUSSUM ,prcspAllwBnusSum);}
    /** get D16_종전근무처상여금액 : prcspAllwBnusSum */
    public BigDecimal  getPrcspAllwBnusSum() { return (BigDecimal )get( ATTR_PRCSPALLWBNUSSUM );}
    /** set D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
    public void setPrcspRcgtnBnusSum(BigDecimal  prcspRcgtnBnusSum) { set( ATTR_PRCSPRCGTNBNUSSUM ,prcspRcgtnBnusSum);}
    /** get D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
    public BigDecimal  getPrcspRcgtnBnusSum() { return (BigDecimal )get( ATTR_PRCSPRCGTNBNUSSUM );}
    /** set D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
    public void setPrcspStckEvntPrftSum(BigDecimal  prcspStckEvntPrftSum) { set( ATTR_PRCSPSTCKEVNTPRFTSUM ,prcspStckEvntPrftSum);}
    /** get D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
    public BigDecimal  getPrcspStckEvntPrftSum() { return (BigDecimal )get( ATTR_PRCSPSTCKEVNTPRFTSUM );}
    /** set D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
    public void setPrcspEmpStkscWdrwSum(BigDecimal  prcspEmpStkscWdrwSum) { set( ATTR_PRCSPEMPSTKSCWDRWSUM ,prcspEmpStkscWdrwSum);}
    /** get D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
    public BigDecimal  getPrcspEmpStkscWdrwSum() { return (BigDecimal )get( ATTR_PRCSPEMPSTKSCWDRWSUM );}
    /** set D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
    public void setPrcspEcteRsgtnExceSum(BigDecimal  prcspEcteRsgtnExceSum) { set( ATTR_PRCSPECTERSGTNEXCESUM ,prcspEcteRsgtnExceSum);}
    /** get D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
    public BigDecimal  getPrcspEcteRsgtnExceSum() { return (BigDecimal )get( ATTR_PRCSPECTERSGTNEXCESUM );}
    /** set D22_종전근무처합계금액 : prcspAggrSum */
    public void setPrcspAggrSum(BigDecimal  prcspAggrSum) { set( ATTR_PRCSPAGGRSUM ,prcspAggrSum);}
    /** get D22_종전근무처합계금액 : prcspAggrSum */
    public BigDecimal  getPrcspAggrSum() { return (BigDecimal )get( ATTR_PRCSPAGGRSUM );}
    /** set D53_비과세합계금액 : freeDtyAggrSum */
    public void setFreeDtyAggrSum(BigDecimal  freeDtyAggrSum) { set( ATTR_FREEDTYAGGRSUM ,freeDtyAggrSum);}
    /** get D53_비과세합계금액 : freeDtyAggrSum */
    public BigDecimal  getFreeDtyAggrSum() { return (BigDecimal )get( ATTR_FREEDTYAGGRSUM );}
    /** set D54_감면소득합계금액 : reduIncmAggrSum */
    public void setReduIncmAggrSum(BigDecimal  reduIncmAggrSum) { set( ATTR_REDUINCMAGGRSUM ,reduIncmAggrSum);}
    /** get D54_감면소득합계금액 : reduIncmAggrSum */
    public BigDecimal  getReduIncmAggrSum() { return (BigDecimal )get( ATTR_REDUINCMAGGRSUM );}
    /** set D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
    public void setPrcspIncmTxSum(BigDecimal  prcspIncmTxSum) { set( ATTR_PRCSPINCMTXSUM ,prcspIncmTxSum);}
    /** get D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
    public BigDecimal  getPrcspIncmTxSum() { return (BigDecimal )get( ATTR_PRCSPINCMTXSUM );}
    /** set D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
    public void setPrcspRgonIncmTxSum(BigDecimal  prcspRgonIncmTxSum) { set( ATTR_PRCSPRGONINCMTXSUM ,prcspRgonIncmTxSum);}
    /** get D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
    public BigDecimal  getPrcspRgonIncmTxSum() { return (BigDecimal )get( ATTR_PRCSPRGONINCMTXSUM );}
    /** set D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
    public void setPrcspNnksSum(BigDecimal  prcspNnksSum) { set( ATTR_PRCSPNNKSSUM ,prcspNnksSum);}
    /** get D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
    public BigDecimal  getPrcspNnksSum() { return (BigDecimal )get( ATTR_PRCSPNNKSSUM );}
    /** set 종전근무지건강보험료금액 : prcspHlthPrmmSum */
    public void setPrcspHlthPrmmSum(BigDecimal  prcspHlthPrmmSum) { set( ATTR_PRCSPHLTHPRMMSUM ,prcspHlthPrmmSum);}
    /** get 종전근무지건강보험료금액 : prcspHlthPrmmSum */
    public BigDecimal  getPrcspHlthPrmmSum() { return (BigDecimal )get( ATTR_PRCSPHLTHPRMMSUM );}
    /** set 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
    public void setPrcspLgtmRcptnSum(BigDecimal  prcspLgtmRcptnSum) { set( ATTR_PRCSPLGTMRCPTNSUM ,prcspLgtmRcptnSum);}
    /** get 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
    public BigDecimal  getPrcspLgtmRcptnSum() { return (BigDecimal )get( ATTR_PRCSPLGTMRCPTNSUM );}
    /** set 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
    public void setPrcspHlthLgcptnAggr(BigDecimal  prcspHlthLgcptnAggr) { set( ATTR_PRCSPHLTHLGCPTNAGGR ,prcspHlthLgcptnAggr);}
    /** get 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
    public BigDecimal  getPrcspHlthLgcptnAggr() { return (BigDecimal )get( ATTR_PRCSPHLTHLGCPTNAGGR );}
    /** set 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
    public void setPrcspHlthPrmmDducSum(BigDecimal  prcspHlthPrmmDducSum) { set( ATTR_PRCSPHLTHPRMMDDUCSUM ,prcspHlthPrmmDducSum);}
    /** get 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
    public BigDecimal  getPrcspHlthPrmmDducSum() { return (BigDecimal )get( ATTR_PRCSPHLTHPRMMDDUCSUM );}
    /** set 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
    public void setPrcspEmymtPrmmSum(BigDecimal  prcspEmymtPrmmSum) { set( ATTR_PRCSPEMYMTPRMMSUM ,prcspEmymtPrmmSum);}
    /** get 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
    public BigDecimal  getPrcspEmymtPrmmSum() { return (BigDecimal )get( ATTR_PRCSPEMYMTPRMMSUM );}
    /** set 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
    public void setPrcspEmytPrmmDducSum(BigDecimal  prcspEmytPrmmDducSum) { set( ATTR_PRCSPEMYTPRMMDDUCSUM ,prcspEmytPrmmDducSum);}
    /** get 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
    public BigDecimal  getPrcspEmytPrmmDducSum() { return (BigDecimal )get( ATTR_PRCSPEMYTPRMMDDUCSUM );}
    /** set 종전근무지처리여부 : prcspPrcsYn */
    public void setPrcspPrcsYn(String  prcspPrcsYn) { set( ATTR_PRCSPPRCSYN ,prcspPrcsYn);}
    /** get 종전근무지처리여부 : prcspPrcsYn */
    public String  getPrcspPrcsYn() { return (String )get( ATTR_PRCSPPRCSYN );}
    /** set 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */
    public void setPrcspWhdgReipSumtYn(String  prcspWhdgReipSumtYn) { set( ATTR_PRCSPWHDGREIPSUMTYN ,prcspWhdgReipSumtYn);}
    /** get 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */
    public String  getPrcspWhdgReipSumtYn() { return (String )get( ATTR_PRCSPWHDGREIPSUMTYN );}
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
    
    /** set C165_납부특례세액_소득세금액 : prcspYetaC165 */
    public void setPrcspYetaC165(Long  prcspYetaC165) { set( ATTR_PRCSPYETAC165 ,prcspYetaC165);}
    /** get C165_납부특례세액_소득세금액 : prcspYetaC165 */
    public Long  getPrcspYetaC165() { return (Long )get( ATTR_PRCSPYETAC165 );}
    /** set C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
    public void setPrcspYetaC166(Long  prcspYetaC166) { set( ATTR_PRCSPYETAC166 ,prcspYetaC166);}
    /** get C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
    public Long  getPrcspYetaC166() { return (Long )get( ATTR_PRCSPYETAC166 );}
    /** set C167_납부특례세액_농특세금액 : prcspYetaC167 */
    public void setPrcspYetaC167(Long  prcspYetaC167) { set( ATTR_PRCSPYETAC167 ,prcspYetaC167);}
    /** get C167_납부특례세액_농특세금액 : prcspYetaC167 */
    public Long  getPrcspYetaC167() { return (Long )get( ATTR_PRCSPYETAC167 );}

}
