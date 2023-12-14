package com.app.exterms.yearendtax.client.dto.yeta2020;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye160406BM.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye160406BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public static final String ATTR_WHDGDEBRBUSOPRRGSTNUM = "whdgDebrBusoprRgstnum";

    /** set 국민연금보험료금액 : natPennPrmmSum */
    public static final String ATTR_NATPENNPRMMSUM = "natPennPrmmSum";

    /** set 국민연금지역보험료금액 : natPennAraPrmmSum */
    public static final String ATTR_NATPENNARAPRMMSUM = "natPennAraPrmmSum";

    /** set 국민연금공제금액 : natPennDducSum */
    public static final String ATTR_NATPENNDDUCSUM = "natPennDducSum";

    /** set 공적연금_공무원연금금액 : puoferAnty */
    public static final String ATTR_PUOFERANTY = "puoferAnty";

    /** set 공적연금_공무원연금공제금액 : puoferAntyDducSum */
    public static final String ATTR_PUOFERANTYDDUCSUM = "puoferAntyDducSum";

    /** set 공적연금_군인연금금액 : mltymAnty */
    public static final String ATTR_MLTYMANTY = "mltymAnty";

    /** set 공적연금_군인연금공제금액 : mltymAntyDducSum */
    public static final String ATTR_MLTYMANTYDDUCSUM = "mltymAntyDducSum";

    /** set 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
    public static final String ATTR_PRTAFIRSCHLFALYMMANTY = "prtafirSchlFalymmAnty";

    /** set 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
    public static final String ATTR_PRTAFIRSCHLDDUCSUM = "prtafirSchlDducSum";

    /** set 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
    public static final String ATTR_SPILDTNPSTOFICANTY = "spildtnPstoficAnty";

    /** set 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
    public static final String ATTR_SPILDTNPSTOFICDDUCSUM = "spildtnPstoficDducSum";

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
     public Ye160406BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye160406BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  whdgDebrBusoprRgstnum 
    		, Long  natPennPrmmSum 
    		, Long  natPennAraPrmmSum 
    		, Long  natPennDducSum 
    		, Long  puoferAnty 
    		, Long  puoferAntyDducSum 
    		, Long  mltymAnty 
    		, Long  mltymAntyDducSum 
    		, Long  prtafirSchlFalymmAnty 
    		, Long  prtafirSchlDducSum 
    		, Long  spildtnPstoficAnty 
    		, Long  spildtnPstoficDducSum 
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
     	values.put(ATTR_NATPENNPRMMSUM,natPennPrmmSum);
     	values.put(ATTR_NATPENNARAPRMMSUM,natPennAraPrmmSum);
     	values.put(ATTR_NATPENNDDUCSUM,natPennDducSum);
     	values.put(ATTR_PUOFERANTY,puoferAnty);
     	values.put(ATTR_PUOFERANTYDDUCSUM,puoferAntyDducSum);
     	values.put(ATTR_MLTYMANTY,mltymAnty);
     	values.put(ATTR_MLTYMANTYDDUCSUM,mltymAntyDducSum);
     	values.put(ATTR_PRTAFIRSCHLFALYMMANTY,prtafirSchlFalymmAnty);
     	values.put(ATTR_PRTAFIRSCHLDDUCSUM,prtafirSchlDducSum);
     	values.put(ATTR_SPILDTNPSTOFICANTY,spildtnPstoficAnty);
     	values.put(ATTR_SPILDTNPSTOFICDDUCSUM,spildtnPstoficDducSum);
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
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public void setWhdgDebrBusoprRgstnum(String  whdgDebrBusoprRgstnum) { set( ATTR_WHDGDEBRBUSOPRRGSTNUM ,whdgDebrBusoprRgstnum);}
    /** get 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public String  getWhdgDebrBusoprRgstnum() { return (String )get( ATTR_WHDGDEBRBUSOPRRGSTNUM );}
    /** set 국민연금보험료금액 : natPennPrmmSum */
    public void setNatPennPrmmSum(Long  natPennPrmmSum) { set( ATTR_NATPENNPRMMSUM ,natPennPrmmSum);}
    /** get 국민연금보험료금액 : natPennPrmmSum */
    public Long  getNatPennPrmmSum() { return (Long )get( ATTR_NATPENNPRMMSUM );}
    /** set 국민연금지역보험료금액 : natPennAraPrmmSum */
    public void setNatPennAraPrmmSum(Long  natPennAraPrmmSum) { set( ATTR_NATPENNARAPRMMSUM ,natPennAraPrmmSum);}
    /** get 국민연금지역보험료금액 : natPennAraPrmmSum */
    public Long  getNatPennAraPrmmSum() { return (Long )get( ATTR_NATPENNARAPRMMSUM );}
    /** set 국민연금공제금액 : natPennDducSum */
    public void setNatPennDducSum(Long  natPennDducSum) { set( ATTR_NATPENNDDUCSUM ,natPennDducSum);}
    /** get 국민연금공제금액 : natPennDducSum */
    public Long  getNatPennDducSum() { return (Long )get( ATTR_NATPENNDDUCSUM );}
    /** set 공적연금_공무원연금금액 : puoferAnty */
    public void setPuoferAnty(Long  puoferAnty) { set( ATTR_PUOFERANTY ,puoferAnty);}
    /** get 공적연금_공무원연금금액 : puoferAnty */
    public Long  getPuoferAnty() { return (Long )get( ATTR_PUOFERANTY );}
    /** set 공적연금_공무원연금공제금액 : puoferAntyDducSum */
    public void setPuoferAntyDducSum(Long  puoferAntyDducSum) { set( ATTR_PUOFERANTYDDUCSUM ,puoferAntyDducSum);}
    /** get 공적연금_공무원연금공제금액 : puoferAntyDducSum */
    public Long  getPuoferAntyDducSum() { return (Long )get( ATTR_PUOFERANTYDDUCSUM );}
    /** set 공적연금_군인연금금액 : mltymAnty */
    public void setMltymAnty(Long  mltymAnty) { set( ATTR_MLTYMANTY ,mltymAnty);}
    /** get 공적연금_군인연금금액 : mltymAnty */
    public Long  getMltymAnty() { return (Long )get( ATTR_MLTYMANTY );}
    /** set 공적연금_군인연금공제금액 : mltymAntyDducSum */
    public void setMltymAntyDducSum(Long  mltymAntyDducSum) { set( ATTR_MLTYMANTYDDUCSUM ,mltymAntyDducSum);}
    /** get 공적연금_군인연금공제금액 : mltymAntyDducSum */
    public Long  getMltymAntyDducSum() { return (Long )get( ATTR_MLTYMANTYDDUCSUM );}
    /** set 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
    public void setPrtafirSchlFalymmAnty(Long  prtafirSchlFalymmAnty) { set( ATTR_PRTAFIRSCHLFALYMMANTY ,prtafirSchlFalymmAnty);}
    /** get 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
    public Long  getPrtafirSchlFalymmAnty() { return (Long )get( ATTR_PRTAFIRSCHLFALYMMANTY );}
    /** set 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
    public void setPrtafirSchlDducSum(Long  prtafirSchlDducSum) { set( ATTR_PRTAFIRSCHLDDUCSUM ,prtafirSchlDducSum);}
    /** get 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
    public Long  getPrtafirSchlDducSum() { return (Long )get( ATTR_PRTAFIRSCHLDDUCSUM );}
    /** set 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
    public void setSpildtnPstoficAnty(Long  spildtnPstoficAnty) { set( ATTR_SPILDTNPSTOFICANTY ,spildtnPstoficAnty);}
    /** get 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
    public Long  getSpildtnPstoficAnty() { return (Long )get( ATTR_SPILDTNPSTOFICANTY );}
    /** set 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
    public void setSpildtnPstoficDducSum(Long  spildtnPstoficDducSum) { set( ATTR_SPILDTNPSTOFICDDUCSUM ,spildtnPstoficDducSum);}
    /** get 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
    public Long  getSpildtnPstoficDducSum() { return (Long )get( ATTR_SPILDTNPSTOFICDDUCSUM );}
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
