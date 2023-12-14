package com.app.exterms.yearendtax.client.dto.yeta2015;



import java.math.BigDecimal;

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
public class Yeta3220BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";
    
    /** set 국세청명 : kuNm */
    public static final String ATTR_KUNM = "kuNm";
    
    /** set 기타명 : kiNm */
    public static final String ATTR_KINM = "kiNm";
    
    /** set 합계  : header */
    public static final String ATTR_HEADER = "header";
    
    /** set 합계명 : sumName */
    public static final String ATTR_SUMNAME = "sumName";
    
    /** set 기타자료 현금영수증  : temp */
    public static final String ATTR_TEMP = "temp";
    

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 주민등록번호 : rsnoNumb */
    public static final String ATTR_RSNONUMB = "rsnoNumb";
    
    /** set 주민등록번호 : rsnoNumb */
    public static final String ATTR_RSNONUMB2 = "rsnoNumb2";

    /** set 관계 : relhCode */
    public static final String ATTR_RELHCODE = "relhCode";

    /** set 성명 : kornName */
    public static final String ATTR_KORNNAME = "kornName";

    /** set 내외국인구분코드 : frnrCode */
    public static final String ATTR_FRNRCODE = "frnrCode";

    /** set 기본공제여부 : baseDdyn */
    public static final String ATTR_BASEDDYN = "baseDdyn";

    /** set 장애인공제여부 : psclDdyn */
    public static final String ATTR_PSCLDDYN = "psclDdyn";

    /** set 자녀양육비공제여부 : brddCtyn */
    public static final String ATTR_BRDDCTYN = "brddCtyn";

    /** set 부녀자공제여부 : faddCtyn */
    public static final String ATTR_FADDCTYN = "faddCtyn";

    /** set 경로우대공제여부 : rpctDdyn */
    public static final String ATTR_RPCTDDYN = "rpctDdyn";

    /** set 출산입양자공제여부 : bithDdyn */
    public static final String ATTR_BITHDDYN = "bithDdyn";

    /** set 한부모공제여부 : pantOnyn */
    public static final String ATTR_PANTONYN = "pantOnyn";

    /** set 보험료_건강고용등국세청 : insuPayr */
    public static final String ATTR_INSUPAYR = "insuPayr";

    /** set 보험료보장성_국세청 : insuRtyr */
    public static final String ATTR_INSURTYR = "insuRtyr";

    /** set 보험료장애인보장성_국세청 : psclIurr */
    public static final String ATTR_PSCLIURR = "psclIurr";

    /** set 의료비_국세청 : mediCost */
    public static final String ATTR_MEDICOST = "mediCost";

    /** set 교육비_국세청 : educCost */
    public static final String ATTR_EDUCCOST = "educCost";

    /** set 신용카드등_국세청 : cdteCard */
    public static final String ATTR_CDTECARD = "cdteCard";

    /** set 현금영수증_국세청 : cashRece */
    public static final String ATTR_CASHRECE = "cashRece";

    /** set 직불카드등_국세청 : jiblCard */
    public static final String ATTR_JIBLCARD = "jiblCard";

    /** set 지로납부액_대중교통_국세청 : grpyAmnt */
    public static final String ATTR_GRPYAMNT = "grpyAmnt";

    /** set 전통시장사용분_국세청 : mgntStvd */
    public static final String ATTR_MGNTSTVD = "mgntStvd";

    /** set 기부금액_국세청 : ctrbAmnt */
    public static final String ATTR_CTRBAMNT = "ctrbAmnt";

    /** set 보험료_건강고용등외 : insuFetc */
    public static final String ATTR_INSUFETC = "insuFetc";

    /** set 보험료보장성외 : insuRtet */
    public static final String ATTR_INSURTET = "insuRtet";

    /** set 보험료장애인보장성외 : psclIurt */
    public static final String ATTR_PSCLIURT = "psclIurt";

    /** set 의료비외 : mediExps */
    public static final String ATTR_MEDIEXPS = "mediExps";

    /** set 교육비외 : educOtec */
    public static final String ATTR_EDUCOTEC = "educOtec";

    /** set 신용카드외 : cdteCdec */
    public static final String ATTR_CDTECDEC = "cdteCdec";

    /** set 직불카드외 : jiblCdec */
    public static final String ATTR_JIBLCDEC = "jiblCdec";

    /** set 지로납부액_대중교통외 : grpyAtec */
    public static final String ATTR_GRPYATEC = "grpyAtec";

    /** set 전통시장사용분외 : mgntSdec */
    public static final String ATTR_MGNTSDEC = "mgntSdec";

    /** set 기부금액외 : ctrbAmec */
    public static final String ATTR_CTRBAMEC = "ctrbAmec";

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
     public Yeta3220BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3220BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  systemkey 
    		, String  rsnoNumb 
    		, String  relhCode 
    		, String  kornName 
    		, String  frnrCode 
    		, String  baseDdyn 
    		, String  psclDdyn 
    		, String  brddCtyn 
    		, String  faddCtyn 
    		, String  rpctDdyn 
    		, String  bithDdyn 
    		, String  pantOnyn 
    		, BigDecimal  insuPayr 
    		, BigDecimal  insuRtyr 
    		, BigDecimal  psclIurr 
    		, BigDecimal  mediCost 
    		, BigDecimal  educCost 
    		, BigDecimal  cdteCard 
    		, BigDecimal  cashRece 
    		, BigDecimal  jiblCard 
    		, BigDecimal  grpyAmnt 
    		, BigDecimal  mgntStvd 
    		, BigDecimal  ctrbAmnt 
    		, BigDecimal  insuFetc 
    		, BigDecimal  insuRtet 
    		, BigDecimal  psclIurt 
    		, BigDecimal  mediExps 
    		, BigDecimal  educOtec 
    		, BigDecimal  cdteCdec 
    		, BigDecimal  jiblCdec 
    		, BigDecimal  grpyAtec 
    		, BigDecimal  mgntSdec 
    		, BigDecimal  ctrbAmec 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_RSNONUMB,rsnoNumb);
     	values.put(ATTR_RELHCODE,relhCode);
     	values.put(ATTR_KORNNAME,kornName);
     	values.put(ATTR_FRNRCODE,frnrCode);
     	values.put(ATTR_BASEDDYN,baseDdyn);
     	values.put(ATTR_PSCLDDYN,psclDdyn);
     	values.put(ATTR_BRDDCTYN,brddCtyn);
     	values.put(ATTR_FADDCTYN,faddCtyn);
     	values.put(ATTR_RPCTDDYN,rpctDdyn);
     	values.put(ATTR_BITHDDYN,bithDdyn);
     	values.put(ATTR_PANTONYN,pantOnyn);
     	values.put(ATTR_INSUPAYR,insuPayr);
     	values.put(ATTR_INSURTYR,insuRtyr);
     	values.put(ATTR_PSCLIURR,psclIurr);
     	values.put(ATTR_MEDICOST,mediCost);
     	values.put(ATTR_EDUCCOST,educCost);
     	values.put(ATTR_CDTECARD,cdteCard);
     	values.put(ATTR_CASHRECE,cashRece);
     	values.put(ATTR_JIBLCARD,jiblCard);
     	values.put(ATTR_GRPYAMNT,grpyAmnt);
     	values.put(ATTR_MGNTSTVD,mgntStvd);
     	values.put(ATTR_CTRBAMNT,ctrbAmnt);
     	values.put(ATTR_INSUFETC,insuFetc);
     	values.put(ATTR_INSURTET,insuRtet);
     	values.put(ATTR_PSCLIURT,psclIurt);
     	values.put(ATTR_MEDIEXPS,mediExps);
     	values.put(ATTR_EDUCOTEC,educOtec);
     	values.put(ATTR_CDTECDEC,cdteCdec);
     	values.put(ATTR_JIBLCDEC,jiblCdec);
     	values.put(ATTR_GRPYATEC,grpyAtec);
     	values.put(ATTR_MGNTSDEC,mgntSdec);
     	values.put(ATTR_CTRBAMEC,ctrbAmec);
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

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 주민등록번호 : rsnoNumb */
    public void setRsnoNumb(String  rsnoNumb) { set( ATTR_RSNONUMB ,rsnoNumb);}
    /** get 주민등록번호 : rsnoNumb */
    public String  getRsnoNumb() { return (String )get( ATTR_RSNONUMB );}

    /** set 관계 : relhCode */
    public void setRelhCode(String  relhCode) { set( ATTR_RELHCODE ,relhCode);}
    /** get 관계 : relhCode */
    public String  getRelhCode() { return (String )get( ATTR_RELHCODE );}

    /** set 성명 : kornName */
    public void setKornName(String  kornName) { set( ATTR_KORNNAME ,kornName);}
    /** get 성명 : kornName */
    public String  getKornName() { return (String )get( ATTR_KORNNAME );}

    /** set 내외국인구분코드 : frnrCode */
    public void setFrnrCode(String  frnrCode) { set( ATTR_FRNRCODE ,frnrCode);}
    /** get 내외국인구분코드 : frnrCode */
    public String  getFrnrCode() { return (String )get( ATTR_FRNRCODE );}

    /** set 기본공제여부 : baseDdyn */
    public void setBaseDdyn(String  baseDdyn) { set( ATTR_BASEDDYN ,baseDdyn);}
    /** get 기본공제여부 : baseDdyn */
    public String  getBaseDdyn() { return (String )get( ATTR_BASEDDYN );}

    /** set 장애인공제여부 : psclDdyn */
    public void setPsclDdyn(String  psclDdyn) { set( ATTR_PSCLDDYN ,psclDdyn);}
    /** get 장애인공제여부 : psclDdyn */
    public String  getPsclDdyn() { return (String )get( ATTR_PSCLDDYN );}

    /** set 자녀양육비공제여부 : brddCtyn */
    public void setBrddCtyn(String  brddCtyn) { set( ATTR_BRDDCTYN ,brddCtyn);}
    /** get 자녀양육비공제여부 : brddCtyn */
    public String  getBrddCtyn() { return (String )get( ATTR_BRDDCTYN );}
    
    /** set 국세청명 : kuNm */
    public void setKuNm(String  kuNm) { set( ATTR_KUNM ,kuNm);}
    /** get 국세청명 : kuNm */
    public String  getKuNm() { return (String )get( ATTR_KUNM );}
    
    /** set 기타명 : kiNm */
    public void setKiNm(String  kiNm) { set( ATTR_KINM ,kiNm);}
    /** get 기타명 : kiNm */
    public String  getKiNm() { return (String )get( ATTR_KINM );}
    
    /** set 합계명 : sumName */
    public void setSumName(String  sumName) { set( ATTR_SUMNAME ,sumName);}
    /** get 합계명 : sumName */
    public String  getSumName() { return (String )get( ATTR_SUMNAME );}
    
    /** set 합계 : header */
    public void setHeader(String  header) { set( ATTR_HEADER ,header);}
    /** get 합계 : header */
    public String  getHeader() { return (String )get( ATTR_HEADER );}
    
    /** set 기타자료 현금영수증 : temp */
    public void setTemp(String  temp) { set( ATTR_TEMP ,temp);}
    /** get 기타자료 현금영수증 : header */
    public String  getTemp() { return (String )get( ATTR_TEMP );}

    /** set 부녀자공제여부 : faddCtyn */
    public void setFaddCtyn(String  faddCtyn) { set( ATTR_FADDCTYN ,faddCtyn);}
    /** get 부녀자공제여부 : faddCtyn */
    public String  getFaddCtyn() { return (String )get( ATTR_FADDCTYN );}

    /** set 경로우대공제여부 : rpctDdyn */
    public void setRpctDdyn(String  rpctDdyn) { set( ATTR_RPCTDDYN ,rpctDdyn);}
    /** get 경로우대공제여부 : rpctDdyn */
    public String  getRpctDdyn() { return (String )get( ATTR_RPCTDDYN );}

    /** set 출산입양자공제여부 : bithDdyn */
    public void setBithDdyn(String  bithDdyn) { set( ATTR_BITHDDYN ,bithDdyn);}
    /** get 출산입양자공제여부 : bithDdyn */
    public String  getBithDdyn() { return (String )get( ATTR_BITHDDYN );}

    /** set 한부모공제여부 : pantOnyn */
    public void setPantOnyn(String  pantOnyn) { set( ATTR_PANTONYN ,pantOnyn);}
    /** get 한부모공제여부 : pantOnyn */
    public String  getPantOnyn() { return (String )get( ATTR_PANTONYN );}

    /** set 보험료_건강고용등국세청 : insuPayr */
    public void setInsuPayr(BigDecimal  insuPayr) { set( ATTR_INSUPAYR ,insuPayr);}
    /** get 보험료_건강고용등국세청 : insuPayr */
    public BigDecimal  getInsuPayr() { return (BigDecimal )get( ATTR_INSUPAYR );}

    /** set 보험료보장성_국세청 : insuRtyr */
    public void setInsuRtyr(BigDecimal  insuRtyr) { set( ATTR_INSURTYR ,insuRtyr);}
    /** get 보험료보장성_국세청 : insuRtyr */
    public BigDecimal  getInsuRtyr() { return (BigDecimal )get( ATTR_INSURTYR );}

    /** set 보험료장애인보장성_국세청 : psclIurr */
    public void setPsclIurr(BigDecimal  psclIurr) { set( ATTR_PSCLIURR ,psclIurr);}
    /** get 보험료장애인보장성_국세청 : psclIurr */
    public BigDecimal  getPsclIurr() { return (BigDecimal )get( ATTR_PSCLIURR );}

    /** set 의료비_국세청 : mediCost */
    public void setMediCost(BigDecimal  mediCost) { set( ATTR_MEDICOST ,mediCost);}
    /** get 의료비_국세청 : mediCost */
    public BigDecimal  getMediCost() { return (BigDecimal )get( ATTR_MEDICOST );}

    /** set 교육비_국세청 : educCost */
    public void setEducCost(BigDecimal  educCost) { set( ATTR_EDUCCOST ,educCost);}
    /** get 교육비_국세청 : educCost */
    public BigDecimal  getEducCost() { return (BigDecimal )get( ATTR_EDUCCOST );}

    /** set 신용카드등_국세청 : cdteCard */
    public void setCdteCard(BigDecimal  cdteCard) { set( ATTR_CDTECARD ,cdteCard);}
    /** get 신용카드등_국세청 : cdteCard */
    public BigDecimal  getCdteCard() { return (BigDecimal )get( ATTR_CDTECARD );}

    /** set 현금영수증_국세청 : cashRece */
    public void setCashRece(BigDecimal  cashRece) { set( ATTR_CASHRECE ,cashRece);}
    /** get 현금영수증_국세청 : cashRece */
    public BigDecimal  getCashRece() { return (BigDecimal )get( ATTR_CASHRECE );}

    /** set 직불카드등_국세청 : jiblCard */
    public void setJiblCard(BigDecimal  jiblCard) { set( ATTR_JIBLCARD ,jiblCard);}
    /** get 직불카드등_국세청 : jiblCard */
    public BigDecimal  getJiblCard() { return (BigDecimal )get( ATTR_JIBLCARD );}

    /** set 지로납부액_대중교통_국세청 : grpyAmnt */
    public void setGrpyAmnt(BigDecimal  grpyAmnt) { set( ATTR_GRPYAMNT ,grpyAmnt);}
    /** get 지로납부액_대중교통_국세청 : grpyAmnt */
    public BigDecimal  getGrpyAmnt() { return (BigDecimal )get( ATTR_GRPYAMNT );}

    /** set 전통시장사용분_국세청 : mgntStvd */
    public void setMgntStvd(BigDecimal  mgntStvd) { set( ATTR_MGNTSTVD ,mgntStvd);}
    /** get 전통시장사용분_국세청 : mgntStvd */
    public BigDecimal  getMgntStvd() { return (BigDecimal )get( ATTR_MGNTSTVD );}

    /** set 기부금액_국세청 : ctrbAmnt */
    public void setCtrbAmnt(BigDecimal  ctrbAmnt) { set( ATTR_CTRBAMNT ,ctrbAmnt);}
    /** get 기부금액_국세청 : ctrbAmnt */
    public BigDecimal  getCtrbAmnt() { return (BigDecimal )get( ATTR_CTRBAMNT );}

    /** set 보험료_건강고용등외 : insuFetc */
    public void setInsuFetc(BigDecimal  insuFetc) { set( ATTR_INSUFETC ,insuFetc);}
    /** get 보험료_건강고용등외 : insuFetc */
    public BigDecimal  getInsuFetc() { return (BigDecimal )get( ATTR_INSUFETC );}

    /** set 보험료보장성외 : insuRtet */
    public void setInsuRtet(BigDecimal  insuRtet) { set( ATTR_INSURTET ,insuRtet);}
    /** get 보험료보장성외 : insuRtet */
    public BigDecimal  getInsuRtet() { return (BigDecimal )get( ATTR_INSURTET );}

    /** set 보험료장애인보장성외 : psclIurt */
    public void setPsclIurt(BigDecimal  psclIurt) { set( ATTR_PSCLIURT ,psclIurt);}
    /** get 보험료장애인보장성외 : psclIurt */
    public BigDecimal  getPsclIurt() { return (BigDecimal )get( ATTR_PSCLIURT );}

    /** set 의료비외 : mediExps */
    public void setMediExps(BigDecimal  mediExps) { set( ATTR_MEDIEXPS ,mediExps);}
    /** get 의료비외 : mediExps */
    public BigDecimal  getMediExps() { return (BigDecimal )get( ATTR_MEDIEXPS );}

    /** set 교육비외 : educOtec */
    public void setEducOtec(BigDecimal  educOtec) { set( ATTR_EDUCOTEC ,educOtec);}
    /** get 교육비외 : educOtec */
    public BigDecimal  getEducOtec() { return (BigDecimal )get( ATTR_EDUCOTEC );}

    /** set 신용카드외 : cdteCdec */
    public void setCdteCdec(BigDecimal  cdteCdec) { set( ATTR_CDTECDEC ,cdteCdec);}
    /** get 신용카드외 : cdteCdec */
    public BigDecimal  getCdteCdec() { return (BigDecimal )get( ATTR_CDTECDEC );}

    /** set 직불카드외 : jiblCdec */
    public void setJiblCdec(BigDecimal  jiblCdec) { set( ATTR_JIBLCDEC ,jiblCdec);}
    /** get 직불카드외 : jiblCdec */
    public BigDecimal  getJiblCdec() { return (BigDecimal )get( ATTR_JIBLCDEC );}

    /** set 지로납부액_대중교통외 : grpyAtec */
    public void setGrpyAtec(BigDecimal  grpyAtec) { set( ATTR_GRPYATEC ,grpyAtec);}
    /** get 지로납부액_대중교통외 : grpyAtec */
    public BigDecimal  getGrpyAtec() { return (BigDecimal )get( ATTR_GRPYATEC );}

    /** set 전통시장사용분외 : mgntSdec */
    public void setMgntSdec(BigDecimal  mgntSdec) { set( ATTR_MGNTSDEC ,mgntSdec);}
    /** get 전통시장사용분외 : mgntSdec */
    public BigDecimal  getMgntSdec() { return (BigDecimal )get( ATTR_MGNTSDEC );}

    /** set 기부금액외 : ctrbAmec */
    public void setCtrbAmec(BigDecimal  ctrbAmec) { set( ATTR_CTRBAMEC ,ctrbAmec);}
    /** get 기부금액외 : ctrbAmec */
    public BigDecimal  getCtrbAmec() { return (BigDecimal )get( ATTR_CTRBAMEC );}

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
