package com.app.exterms.retirement.client.dto;



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
public class Remt3200BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

//    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    public static final String ATTR_CALCSEVEPSNBLGGYRMNTH = "calcSevePsnBlggYrMnth";
    
    /** set 정산년월 : clutYrMnth */
    public static final String ATTR_CLUTYRMNTH = "clutYrMnth";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 연금계좌일련번호 : antyAccuSeilNum */
    public static final String ATTR_ANTYACCUSEILNUM = "antyAccuSeilNum";

    /** set 연금계좌_사업자등록번호 : antyAccuBusoprNum */
    public static final String ATTR_ANTYACCUBUSOPRNUM = "antyAccuBusoprNum";

    /** set 연금계좌_사업자명 : antyAccuBusoprNm */
    public static final String ATTR_ANTYACCUBUSOPRNM = "antyAccuBusoprNm";

    /** set 연금계좌_계좌번호 : antyAccuAccuNum */
    public static final String ATTR_ANTYACCUACCUNUM = "antyAccuAccuNum";

    /** set 연금계좌_입금금액 : antyAccuDepitSum */
    public static final String ATTR_ANTYACCUDEPITSUM = "antyAccuDepitSum";

    /** set 연금계좌_입금일자 : antyAccuDepitDt */
    public static final String ATTR_ANTYACCUDEPITDT = "antyAccuDepitDt";

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
     public Remt3200BM() { super(); } 

    /** 일괄등록 처리   */
     public Remt3200BM(
    		 String  dpobCd 
    		, String  clutYrMnth 
    		, String  calcSevePayPsnDivCd 
    		, String  systemkey 
    		, Long  antyAccuSeilNum 
    		, String  antyAccuBusoprNum 
    		, String  antyAccuBusoprNm 
    		, String  antyAccuAccuNum 
    		, Long  antyAccuDepitSum 
    		, String  antyAccuDepitDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     //	values.put(ATTR_CALCSEVEPSNBLGGYRMNTH,calcSevePsnBlggYrMnth);
     	values.put(ATTR_CLUTYRMNTH,clutYrMnth);
     	values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_ANTYACCUSEILNUM,antyAccuSeilNum);
     	values.put(ATTR_ANTYACCUBUSOPRNUM,antyAccuBusoprNum);
     	values.put(ATTR_ANTYACCUBUSOPRNM,antyAccuBusoprNm);
     	values.put(ATTR_ANTYACCUACCUNUM,antyAccuAccuNum);
     	values.put(ATTR_ANTYACCUDEPITSUM,antyAccuDepitSum);
     	values.put(ATTR_ANTYACCUDEPITDT,antyAccuDepitDt);
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

//    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    public void setCalcSevePsnBlggYrMnth(String  calcSevePsnBlggYrMnth) { set( ATTR_CALCSEVEPSNBLGGYRMNTH ,calcSevePsnBlggYrMnth);}
//    /** get 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    public String  getCalcSevePsnBlggYrMnth() { return (String )get( ATTR_CALCSEVEPSNBLGGYRMNTH );}

    /** set 정산년월 : clutYrMnth */
	public void setClutYrMnth(String  clutYrMnth) { set( ATTR_CLUTYRMNTH ,clutYrMnth);}
	/** get 정산년월 : clutYrMnth */
	public String  getClutYrMnth() { return (String )get( ATTR_CLUTYRMNTH );}
	
    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public void setCalcSevePayPsnDivCd(String  calcSevePayPsnDivCd) { set( ATTR_CALCSEVEPAYPSNDIVCD ,calcSevePayPsnDivCd);}
    /** get 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public String  getCalcSevePayPsnDivCd() { return (String )get( ATTR_CALCSEVEPAYPSNDIVCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 연금계좌일련번호 : antyAccuSeilNum */
    public void setAntyAccuSeilNum(Long  antyAccuSeilNum) { set( ATTR_ANTYACCUSEILNUM ,antyAccuSeilNum);}
    /** get 연금계좌일련번호 : antyAccuSeilNum */
    public Long  getAntyAccuSeilNum() { return (Long )get( ATTR_ANTYACCUSEILNUM );}

    /** set 연금계좌_사업자등록번호 : antyAccuBusoprNum */
    public void setAntyAccuBusoprNum(String  antyAccuBusoprNum) { set( ATTR_ANTYACCUBUSOPRNUM ,antyAccuBusoprNum);}
    /** get 연금계좌_사업자등록번호 : antyAccuBusoprNum */
    public String  getAntyAccuBusoprNum() { return (String )get( ATTR_ANTYACCUBUSOPRNUM );}

    /** set 연금계좌_사업자명 : antyAccuBusoprNm */
    public void setAntyAccuBusoprNm(String  antyAccuBusoprNm) { set( ATTR_ANTYACCUBUSOPRNM ,antyAccuBusoprNm);}
    /** get 연금계좌_사업자명 : antyAccuBusoprNm */
    public String  getAntyAccuBusoprNm() { return (String )get( ATTR_ANTYACCUBUSOPRNM );}

    /** set 연금계좌_계좌번호 : antyAccuAccuNum */
    public void setAntyAccuAccuNum(String  antyAccuAccuNum) { set( ATTR_ANTYACCUACCUNUM ,antyAccuAccuNum);}
    /** get 연금계좌_계좌번호 : antyAccuAccuNum */
    public String  getAntyAccuAccuNum() { return (String )get( ATTR_ANTYACCUACCUNUM );}

    /** set 연금계좌_입금금액 : antyAccuDepitSum */
    public void setAntyAccuDepitSum(Long  antyAccuDepitSum) { set( ATTR_ANTYACCUDEPITSUM ,antyAccuDepitSum);}
    /** get 연금계좌_입금금액 : antyAccuDepitSum */
    public Long  getAntyAccuDepitSum() { return (Long )get( ATTR_ANTYACCUDEPITSUM );}

    /** set 연금계좌_입금일자 : antyAccuDepitDt */
    public void setAntyAccuDepitDt(String  antyAccuDepitDt) { set( ATTR_ANTYACCUDEPITDT ,antyAccuDepitDt);}
    /** get 연금계좌_입금일자 : antyAccuDepitDt */
    public String  getAntyAccuDepitDt() { return (String )get( ATTR_ANTYACCUDEPITDT );}

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
