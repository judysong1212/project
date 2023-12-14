package com.app.exterms.personal.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0114VO.java
 * @Description : Psnl0114 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0114BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 단체일련번호 : opztnSeilNum */
    public static final String ATTR_OPZTNSEILNUM = "opztnSeilNum";

    /** set 가입일자 : jnDt */
    public static final String ATTR_JNDT = "jnDt";

    /** set 가입단체명 : jnOpztnNm */
    public static final String ATTR_JNOPZTNNM = "jnOpztnNm";

    /** set 직책코드 : odtyCd */
    public static final String ATTR_ODTYCD = "odtyCd";
    
    /** set 직책코드 : odtyNm */
    public static final String ATTR_ODTYNM = "odtyNm";

    /** set 탈퇴일자 : wirlDt */
    public static final String ATTR_WIRLDT = "wirlDt";

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
    

	/** set 급여공제구분코드 : jnPayrDducDivCd */
	public static final String ATTR_JNPAYRDDUCDIVCD = "jnPayrDducDivCd";
	
	/** set 단체급여공제여부 : jnPayrDducYn */
	public static final String ATTR_JNPAYRDDUCYN = "jnPayrDducYn";
	
	/** set 기부금공제구분코드 : jnCntbDducDivCd */
	public static final String ATTR_JNCNTBDDUCDIVCD = "jnCntbDducDivCd";
	
	/** set 기부금표기명 : jnCntbMknm */
	public static final String ATTR_JNCNTBMKNM = "jnCntbMknm";
	
	/** set 비과세감면구분코드 : txemRducDivCd */
	public static final String ATTR_TXEMRDUCDIVCD = "txemRducDivCd";
	
	/** set 단체비고내용 : jnCtnt */
	public static final String ATTR_JNCTNT = "jnCtnt";


    /** 생성자 */
     public Psnl0114BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0114BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  opztnSeilNum 
    		, String  jnDt 
    		, String  jnOpztnNm 
    		, String  odtyCd 
    		, String  wirlDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_OPZTNSEILNUM,opztnSeilNum);
     	values.put(ATTR_JNDT,jnDt);
     	values.put(ATTR_JNOPZTNNM,jnOpztnNm);
     	values.put(ATTR_ODTYCD,odtyCd);
     	values.put(ATTR_WIRLDT,wirlDt);
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
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 단체일련번호 : opztnSeilNum */
    public void setOpztnSeilNum(BigDecimal  opztnSeilNum) { set( ATTR_OPZTNSEILNUM ,opztnSeilNum);}
    /** get 단체일련번호 : opztnSeilNum */
    public BigDecimal  getOpztnSeilNum() { return (BigDecimal )get( ATTR_OPZTNSEILNUM );}
    /** set 가입일자 : jnDt */
    public void setJnDt(String  jnDt) { set( ATTR_JNDT ,jnDt);}
    /** get 가입일자 : jnDt */
    public String  getJnDt() { return (String )get( ATTR_JNDT );}
    /** set 가입단체명 : jnOpztnNm */
    public void setJnOpztnNm(String  jnOpztnNm) { set( ATTR_JNOPZTNNM ,jnOpztnNm);}
    /** get 가입단체명 : jnOpztnNm */
    public String  getJnOpztnNm() { return (String )get( ATTR_JNOPZTNNM );}
    /** set 직책코드 : odtyCd */
    public void setOdtyCd(String  odtyCd) { set( ATTR_ODTYCD ,odtyCd);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyCd() { return (String )get( ATTR_ODTYCD );}
    /** set 직책코드 : odtyNm */
    public void setOdtyNm(String  odtyNm) { set( ATTR_ODTYNM ,odtyNm);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyNm() { return (String )get( ATTR_ODTYNM );}
    /** set 탈퇴일자 : wirlDt */
    public void setWirlDt(String  wirlDt) { set( ATTR_WIRLDT ,wirlDt);}
    /** get 탈퇴일자 : wirlDt */
    public String  getWirlDt() { return (String )get( ATTR_WIRLDT );}
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
    /** set 급여공제구분코드 : jnPayrDducDivCd */
    public void setJnPayrDducDivCd(String  jnPayrDducDivCd) { set( ATTR_JNPAYRDDUCDIVCD ,jnPayrDducDivCd);}
    /** get 급여공제구분코드 : jnPayrDducDivCd */
    public String  getJnPayrDducDivCd() { return (String )get( ATTR_JNPAYRDDUCDIVCD );}
    /** set 단체급여공제여부 : jnPayrDducYn */
    public void setJnPayrDducYn(String  jnPayrDducYn) { set( ATTR_JNPAYRDDUCYN ,jnPayrDducYn);}
    /** get 단체급여공제여부 : jnPayrDducYn */
    public String  getJnPayrDducYn() { return (String )get( ATTR_JNPAYRDDUCYN );}
    /** set 기부금공제구분코드 : jnCntbDducDivCd */
    public void setJnCntbDducDivCd(String  jnCntbDducDivCd) { set( ATTR_JNCNTBDDUCDIVCD ,jnCntbDducDivCd);}
    /** get 기부금공제구분코드 : jnCntbDducDivCd */
    public String  getJnCntbDducDivCd() { return (String )get( ATTR_JNCNTBDDUCDIVCD );}
    /** set 기부금표기명 : jnCntbMknm */
    public void setJnCntbMknm(String  jnCntbMknm) { set( ATTR_JNCNTBMKNM ,jnCntbMknm);}
    /** get 기부금표기명 : jnCntbMknm */
    public String  getJnCntbMknm() { return (String )get( ATTR_JNCNTBMKNM );}
    /** set 비과세감면구분코드 : txemRducDivCd */
    public void setTxemRducDivCd(String  txemRducDivCd) { set( ATTR_TXEMRDUCDIVCD ,txemRducDivCd);}
    /** get 비과세감면구분코드 : txemRducDivCd */
    public String  getTxemRducDivCd() { return (String )get( ATTR_TXEMRDUCDIVCD );}
    /** set 단체비고내용 : jnCtnt */
    public void setJnCtnt(String  jnCtnt) { set( ATTR_JNCTNT ,jnCtnt);}
    /** get 단체비고내용 : jnCtnt */
    public String  getJnCtnt() { return (String )get( ATTR_JNCTNT );}
     
}
