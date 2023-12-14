package com.app.exterms.payroll.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0305VO.java
 * @Description : Payr0305 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0305BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

   
/** set 사업장코드 : dpobCd */
public static final String ATTR_DPOBCD = "dpobCd";

/** set 지급년월 : pymtYrMnth */
public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

/** set 급여구분코드 : payCd */
public static final String ATTR_PAYCD = "payCd";

/** set 급여일련번호 : payrSeilNum */
public static final String ATTR_PAYRSEILNUM = "payrSeilNum";

/** set SYSTEMKEY : systemkey */
public static final String ATTR_SYSTEMKEY = "systemkey";

/** set 근로소득과세금액 : workIncmTxtnSum */
public static final String ATTR_WORKINCMTXTNSUM = "workIncmTxtnSum";

/** set 급여구간중간금액 : paySectiCtrSum */
public static final String ATTR_PAYSECTICTRSUM = "paySectiCtrSum";

/** set 연간총급여액 : yrlyTotPayQNty */
public static final String ATTR_YRLYTOTPAYQNTY = "yrlyTotPayQNty";

/** set 근로소득공제금액 : eandIncmDducSum */
public static final String ATTR_EANDINCMDDUCSUM = "eandIncmDducSum";

/** set 근로소득금액 : eandIncmSum */
public static final String ATTR_EANDINCMSUM = "eandIncmSum";

/** set 인적공제인원수 : hmnDducNumPeplNum */
public static final String ATTR_HMNDDUCNUMPEPLNUM = "hmnDducNumPeplNum";

/** set 인적공제20세이하자녀수 : hmnDducTwenSqntsChdnNum */
public static final String ATTR_HMNDDUCTWENSQNTSCHDNNUM = "hmnDducTwenSqntsChdnNum";

/** set 인적공제금액 : hmnDducSum */
public static final String ATTR_HMNDDUCSUM = "hmnDducSum";

/** set 연금보험료공제금액 : antyPrmmDducSum */
public static final String ATTR_ANTYPRMMDDUCSUM = "antyPrmmDducSum";

/** set 특별소득공제등금액 : spclIncmDducEtcSum */
public static final String ATTR_SPCLINCMDDUCETCSUM = "spclIncmDducEtcSum";

/** set 과세표준금액 : txtnStdSum */
public static final String ATTR_TXTNSTDSUM = "txtnStdSum";

/** set 과세표준적용세율 : txtnStdApptnTxrt */
public static final String ATTR_TXTNSTDAPPTNTXRT = "txtnStdApptnTxrt";

/** set 과세표준누진공제금액 : txtnStdPgivDducSum */
public static final String ATTR_TXTNSTDPGIVDDUCSUM = "txtnStdPgivDducSum";

/** set 산출세액 : calcTxAmnt */
public static final String ATTR_CALCTXAMNT = "calcTxAmnt";

/** set 근로소득세액공제액 : eandIncmTxAmnt */
public static final String ATTR_EANDINCMTXAMNT = "eandIncmTxAmnt";

/** set 결정세액 : deinTxAmnt */
public static final String ATTR_DEINTXAMNT = "deinTxAmnt";

/** set 간이세액 : txtbSimfTxs */
public static final String ATTR_TXTBSIMFTXS = "txtbSimfTxs";

/** set 지방소득세 : locIncmTxAmt */
public static final String ATTR_LOCINCMTXAMT = "locIncmTxAmt";

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


/** set 추가소득세율 : addIncmTxRate */
public static final String ATTR_ADDINCMTXRATE = "addIncmTxRate";

/** set 실소득세액 : turtyIncmTxQnty */
public static final String ATTR_TURTYINCMTXQNTY = "turtyIncmTxQnty";


/** 생성자 */
 public Payr0305BM() { super(); } 

/** 일괄등록 처리   */
 public Payr0305BM(
         String  dpobCd 
        , String  pymtYrMnth 
        , String  payCd 
        , Long  payrSeilNum 
        , String  systemkey 
        , Long  workIncmTxtnSum 
        , Long  paySectiCtrSum 
        , Long  yrlyTotPayQNty 
        , Long  eandIncmDducSum 
        , Long  eandIncmSum 
        , Long  hmnDducNumPeplNum 
        , Long  hmnDducTwenSqntsChdnNum 
        , Long  hmnDducSum 
        , Long  antyPrmmDducSum 
        , Long  spclIncmDducEtcSum 
        , Long  txtnStdSum 
        , Double  txtnStdApptnTxrt 
        , Long  txtnStdPgivDducSum 
        , Long  calcTxAmnt 
        , Long  eandIncmTxAmnt 
        , Long  deinTxAmnt 
        , Long  txtbSimfTxs 
        , Long  locIncmTxAmt 
        , String  kybdr 
        , String  inptDt 
        , String  inptAddr 
        , String  ismt 
        , String  revnDt 
        , String  revnAddr ) { 
    values.put(ATTR_DPOBCD,dpobCd);
    values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
    values.put(ATTR_PAYCD,payCd);
    values.put(ATTR_PAYRSEILNUM,payrSeilNum);
    values.put(ATTR_SYSTEMKEY,systemkey);
    values.put(ATTR_WORKINCMTXTNSUM,workIncmTxtnSum);
    values.put(ATTR_PAYSECTICTRSUM,paySectiCtrSum);
    values.put(ATTR_YRLYTOTPAYQNTY,yrlyTotPayQNty);
    values.put(ATTR_EANDINCMDDUCSUM,eandIncmDducSum);
    values.put(ATTR_EANDINCMSUM,eandIncmSum);
    values.put(ATTR_HMNDDUCNUMPEPLNUM,hmnDducNumPeplNum);
    values.put(ATTR_HMNDDUCTWENSQNTSCHDNNUM,hmnDducTwenSqntsChdnNum);
    values.put(ATTR_HMNDDUCSUM,hmnDducSum);
    values.put(ATTR_ANTYPRMMDDUCSUM,antyPrmmDducSum);
    values.put(ATTR_SPCLINCMDDUCETCSUM,spclIncmDducEtcSum);
    values.put(ATTR_TXTNSTDSUM,txtnStdSum);
    values.put(ATTR_TXTNSTDAPPTNTXRT,txtnStdApptnTxrt);
    values.put(ATTR_TXTNSTDPGIVDDUCSUM,txtnStdPgivDducSum);
    values.put(ATTR_CALCTXAMNT,calcTxAmnt);
    values.put(ATTR_EANDINCMTXAMNT,eandIncmTxAmnt);
    values.put(ATTR_DEINTXAMNT,deinTxAmnt);
    values.put(ATTR_TXTBSIMFTXS,txtbSimfTxs);
    values.put(ATTR_LOCINCMTXAMT,locIncmTxAmt);
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

  
    /** set 지급년월 : pymtYrMnth */
    public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
    /** get 지급년월 : pymtYrMnth */
    public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 급여일련번호 : payrSeilNum */
    public void setPayrSeilNum(Long  payrSeilNum) { set( ATTR_PAYRSEILNUM ,payrSeilNum);}
    /** get 급여일련번호 : payrSeilNum */
    public Long  getPayrSeilNum() { return (Long )get( ATTR_PAYRSEILNUM );}

    /** set 근로소득과세금액 : workIncmTxtnSum */
    public void setWorkIncmTxtnSum(Long  workIncmTxtnSum) { set( ATTR_WORKINCMTXTNSUM ,workIncmTxtnSum);}
    /** get 근로소득과세금액 : workIncmTxtnSum */
    public Long  getWorkIncmTxtnSum() { return (Long )get( ATTR_WORKINCMTXTNSUM );}

    /** set 급여구간중간금액 : paySectiCtrSum */
    public void setPaySectiCtrSum(Long  paySectiCtrSum) { set( ATTR_PAYSECTICTRSUM ,paySectiCtrSum);}
    /** get 급여구간중간금액 : paySectiCtrSum */
    public Long  getPaySectiCtrSum() { return (Long )get( ATTR_PAYSECTICTRSUM );}

    /** set 연간총급여액 : yrlyTotPayQNty */
    public void setYrlyTotPayQNty(Long  yrlyTotPayQNty) { set( ATTR_YRLYTOTPAYQNTY ,yrlyTotPayQNty);}
    /** get 연간총급여액 : yrlyTotPayQNty */
    public Long  getYrlyTotPayQNty() { return (Long )get( ATTR_YRLYTOTPAYQNTY );}

    /** set 근로소득공제금액 : eandIncmDducSum */
    public void setEandIncmDducSum(Long  eandIncmDducSum) { set( ATTR_EANDINCMDDUCSUM ,eandIncmDducSum);}
    /** get 근로소득공제금액 : eandIncmDducSum */
    public Long  getEandIncmDducSum() { return (Long )get( ATTR_EANDINCMDDUCSUM );}

    /** set 인적공제인원수 : hmnDducNumPeplNum */
    public void setHmnDducNumPeplNum(Long  hmnDducNumPeplNum) { set( ATTR_HMNDDUCNUMPEPLNUM ,hmnDducNumPeplNum);}
    /** get 인적공제인원수 : hmnDducNumPeplNum */
    public Long  getHmnDducNumPeplNum() { return (Long )get( ATTR_HMNDDUCNUMPEPLNUM );}

    /** set 인적공제20세이하자녀수 : hmnDducTwenSqntsChdnNum */
    public void setHmnDducTwenSqntsChdnNum(Long  hmnDducTwenSqntsChdnNum) { set( ATTR_HMNDDUCTWENSQNTSCHDNNUM ,hmnDducTwenSqntsChdnNum);}
    /** get 인적공제20세이하자녀수 : hmnDducTwenSqntsChdnNum */
    public Long  getHmnDducTwenSqntsChdnNum() { return (Long )get( ATTR_HMNDDUCTWENSQNTSCHDNNUM );}

    /** set 인적공제금액 : hmnDducSum */
    public void setHmnDducSum(Long  hmnDducSum) { set( ATTR_HMNDDUCSUM ,hmnDducSum);}
    /** get 인적공제금액 : hmnDducSum */
    public Long  getHmnDducSum() { return (Long )get( ATTR_HMNDDUCSUM );}

    /** set 연금보험료공제금액 : antyPrmmDducSum */
    public void setAntyPrmmDducSum(Long  antyPrmmDducSum) { set( ATTR_ANTYPRMMDDUCSUM ,antyPrmmDducSum);}
    /** get 연금보험료공제금액 : antyPrmmDducSum */
    public Long  getAntyPrmmDducSum() { return (Long )get( ATTR_ANTYPRMMDDUCSUM );}

    /** set 특별소득공제등금액 : spclIncmDducEtcSum */
    public void setSpclIncmDducEtcSum(Long  spclIncmDducEtcSum) { set( ATTR_SPCLINCMDDUCETCSUM ,spclIncmDducEtcSum);}
    /** get 특별소득공제등금액 : spclIncmDducEtcSum */
    public Long  getSpclIncmDducEtcSum() { return (Long )get( ATTR_SPCLINCMDDUCETCSUM );}

    /** set 과세표준금액 : txtnStdSum */
    public void setTxtnStdSum(Long  txtnStdSum) { set( ATTR_TXTNSTDSUM ,txtnStdSum);}
    /** get 과세표준금액 : txtnStdSum */
    public Long  getTxtnStdSum() { return (Long )get( ATTR_TXTNSTDSUM );}

    /** set 과세표준적용세율 : txtnStdApptnTxrt */
    public void setTxtnStdApptnTxrt(Double  txtnStdApptnTxrt) { set( ATTR_TXTNSTDAPPTNTXRT ,txtnStdApptnTxrt);}
    /** get 과세표준적용세율 : txtnStdApptnTxrt */
    public Double  getTxtnStdApptnTxrt() { return (Double )get( ATTR_TXTNSTDAPPTNTXRT );}

    /** set 과세표준누진공제금액 : txtnStdPgivDducSum */
    public void setTxtnStdPgivDducSum(Long  txtnStdPgivDducSum) { set( ATTR_TXTNSTDPGIVDDUCSUM ,txtnStdPgivDducSum);}
    /** get 과세표준누진공제금액 : txtnStdPgivDducSum */
    public Long  getTxtnStdPgivDducSum() { return (Long )get( ATTR_TXTNSTDPGIVDDUCSUM );}

    /** set 산출세액 : calcTxAmnt */
    public void setCalcTxAmnt(Long  calcTxAmnt) { set( ATTR_CALCTXAMNT ,calcTxAmnt);}
    /** get 산출세액 : calcTxAmnt */
    public Long  getCalcTxAmnt() { return (Long )get( ATTR_CALCTXAMNT );}

    /** set 근로소득세액공제액 : eandIncmTxAmnt */
    public void setEandIncmTxAmnt(Long  eandIncmTxAmnt) { set( ATTR_EANDINCMTXAMNT ,eandIncmTxAmnt);}
    /** get 근로소득세액공제액 : eandIncmTxAmnt */
    public Long  getEandIncmTxAmnt() { return (Long )get( ATTR_EANDINCMTXAMNT );}

    /** set 결정세액 : deinTxAmnt */
    public void setDeinTxAmnt(Long  deinTxAmnt) { set( ATTR_DEINTXAMNT ,deinTxAmnt);}
    /** get 결정세액 : deinTxAmnt */
    public Long  getDeinTxAmnt() { return (Long )get( ATTR_DEINTXAMNT );}

    /** set 간이세액 : txtbSimfTxs */
    public void setTxtbSimfTxs(Long  txtbSimfTxs) { set( ATTR_TXTBSIMFTXS ,txtbSimfTxs);}
    /** get 간이세액 : txtbSimfTxs */
    public Long  getTxtbSimfTxs() { return (Long )get( ATTR_TXTBSIMFTXS );}

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

	
	/** set 추가소득세율 : addIncmTxRate */
	public void setAddIncmTxRate(Double  addIncmTxRate) { set( ATTR_ADDINCMTXRATE ,addIncmTxRate);}
	/** get 추가소득세율 : addIncmTxRate */
	public Double  getAddIncmTxRate() { return (Double )get( ATTR_ADDINCMTXRATE );}
	
	/** set 실소득세액 : turtyIncmTxQnty */
	public void setTurtyIncmTxQnty(Long  turtyIncmTxQnty) { set( ATTR_TURTYINCMTXQNTY ,turtyIncmTxQnty);}
	/** get 실소득세액 : turtyIncmTxQnty */
	public Long  getTurtyIncmTxQnty() { return (Long )get( ATTR_TURTYINCMTXQNTY );}

    
}
