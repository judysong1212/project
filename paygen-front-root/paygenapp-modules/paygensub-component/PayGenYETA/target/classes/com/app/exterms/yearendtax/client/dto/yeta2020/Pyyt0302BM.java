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
public class Pyyt0302BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 급여항목코드 : pyytItemCd */
    public static final String ATTR_PYYTITEMCD = "pyytItemCd";
    
    /** set 급여항목코드 : pyytItemNm */
    public static final String ATTR_PYYTITEMNM = "pyytItemNm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 지급년월 : pyytYrMnth */
    public static final String ATTR_PYYTYRMNTH = "pyytYrMnth";

    /** set 지급공제구분코드 : pyytPymtDducCd */
    public static final String ATTR_PYYTPYMTDDUCCD = "pyytPymtDducCd";

    /** set 지급공제금액 : pyytPymtDducSum */
    public static final String ATTR_PYYTPYMTDDUCSUM = "pyytPymtDducSum";

    /** set 지급공제과세금액 : pyytPyddTxtnAmnt */
    public static final String ATTR_PYYTPYDDTXTNAMNT = "pyytPyddTxtnAmnt";

    /** set 지급공제비과세금액 : pyytPyddFreeDtySum */
    public static final String ATTR_PYYTPYDDFREEDTYSUM = "pyytPyddFreeDtySum";

    /** set 연말정산_기부금코드 : pyytYrtxDotnCd */
    public static final String ATTR_PYYTYRTXDOTNCD = "pyytYrtxDotnCd";
    
    /** set 연말정산_기부금코드 : pyytYrtxDotnCd */
    public static final String ATTR_PYYTYRTXDOTNNM = "pyytYrtxDotnNm";

    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
    public static final String ATTR_PYYTYTFEDTYREDUCD = "pyytYtfeDtyReduCd";
    
    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduNm */
    public static final String ATTR_PYYTYTFEDTYREDUNM = "pyytYtfeDtyReduNm";

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
    
    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** 생성자 */
     public Pyyt0302BM() { super(); } 

    /** 일괄등록 처리   */
     public Pyyt0302BM(
    		 String  pyytItemCd 
    		, String  systemkey 
    		, String  dpobCd 
    		, String  pyytYrMnth 
    		, String  pyytPymtDducCd 
    		, Long  pyytPymtDducSum 
    		, Long  pyytPyddTxtnAmnt 
    		, Long  pyytPyddFreeDtySum 
    		, String  pyytYrtxDotnCd 
    		, String  pyytYtfeDtyReduCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_PYYTITEMCD,pyytItemCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PYYTYRMNTH,pyytYrMnth);
     	values.put(ATTR_PYYTPYMTDDUCCD,pyytPymtDducCd);
     	values.put(ATTR_PYYTPYMTDDUCSUM,pyytPymtDducSum);
     	values.put(ATTR_PYYTPYDDTXTNAMNT,pyytPyddTxtnAmnt);
     	values.put(ATTR_PYYTPYDDFREEDTYSUM,pyytPyddFreeDtySum);
     	values.put(ATTR_PYYTYRTXDOTNCD,pyytYrtxDotnCd);
     	values.put(ATTR_PYYTYTFEDTYREDUCD,pyytYtfeDtyReduCd);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 급여항목코드 : pyytItemCd */
    public void setPyytItemCd(String  pyytItemCd) { set( ATTR_PYYTITEMCD ,pyytItemCd);}
    /** get 급여항목코드 : pyytItemCd */
    public String  getPyytItemCd() { return (String )get( ATTR_PYYTITEMCD );}
    /** set 급여항목코드 : pyytItemNm */
    public void setPyytItemNm(String  pyytItemNm) { set( ATTR_PYYTITEMNM ,pyytItemNm);}
    /** get 급여항목코드 : pyytItemNm */
    public String  getPyytItemNm() { return (String )get( ATTR_PYYTITEMNM );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set 지급년월 : pyytYrMnth */
    public void setPyytYrMnth(String  pyytYrMnth) { set( ATTR_PYYTYRMNTH ,pyytYrMnth);}
    /** get 지급년월 : pyytYrMnth */
    public String  getPyytYrMnth() { return (String )get( ATTR_PYYTYRMNTH );}
    /** set 지급공제구분코드 : pyytPymtDducCd */
    public void setPyytPymtDducCd(String  pyytPymtDducCd) { set( ATTR_PYYTPYMTDDUCCD ,pyytPymtDducCd);}
    /** get 지급공제구분코드 : pyytPymtDducCd */
    public String  getPyytPymtDducCd() { return (String )get( ATTR_PYYTPYMTDDUCCD );}
    /** set 지급공제금액 : pyytPymtDducSum */
    public void setPyytPymtDducSum(Long  pyytPymtDducSum) { set( ATTR_PYYTPYMTDDUCSUM ,pyytPymtDducSum);}
    /** get 지급공제금액 : pyytPymtDducSum */
    public Long  getPyytPymtDducSum() { return (Long )get( ATTR_PYYTPYMTDDUCSUM );}
    /** set 지급공제과세금액 : pyytPyddTxtnAmnt */
    public void setPyytPyddTxtnAmnt(Long  pyytPyddTxtnAmnt) { set( ATTR_PYYTPYDDTXTNAMNT ,pyytPyddTxtnAmnt);}
    /** get 지급공제과세금액 : pyytPyddTxtnAmnt */
    public Long  getPyytPyddTxtnAmnt() { return (Long )get( ATTR_PYYTPYDDTXTNAMNT );}
    /** set 지급공제비과세금액 : pyytPyddFreeDtySum */
    public void setPyytPyddFreeDtySum(Long  pyytPyddFreeDtySum) { set( ATTR_PYYTPYDDFREEDTYSUM ,pyytPyddFreeDtySum);}
    /** get 지급공제비과세금액 : pyytPyddFreeDtySum */
    public Long  getPyytPyddFreeDtySum() { return (Long )get( ATTR_PYYTPYDDFREEDTYSUM );}
    /** set 연말정산_기부금코드 : pyytYrtxDotnCd */
    public void setPyytYrtxDotnCd(String  pyytYrtxDotnCd) { set( ATTR_PYYTYRTXDOTNCD ,pyytYrtxDotnCd);}
    /** get 연말정산_기부금코드 : pyytYrtxDotnCd */
    public String  getPyytYrtxDotnCd() { return (String )get( ATTR_PYYTYRTXDOTNCD );}
    /** set 연말정산_기부금코드 : pyytYrtxDotnNm */
    public void setPyytYrtxDotnNm(String  pyytYrtxDotnNm) { set( ATTR_PYYTYRTXDOTNNM ,pyytYrtxDotnNm);}
    /** get 연말정산_기부금코드 : pyytYrtxDotnNm */
    public String  getPyytYrtxDotnNm() { return (String )get( ATTR_PYYTYRTXDOTNNM );}
    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
    public void setPyytYtfeDtyReduCd(String  pyytYtfeDtyReduCd) { set( ATTR_PYYTYTFEDTYREDUCD ,pyytYtfeDtyReduCd);}
    /** get 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
    public String  getPyytYtfeDtyReduCd() { return (String )get( ATTR_PYYTYTFEDTYREDUCD );}
    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduNm */
    public void setPyytYtfeDtyReduNm(String  pyytYtfeDtyReduNm) { set( ATTR_PYYTYTFEDTYREDUNM ,pyytYtfeDtyReduNm);}
    /** get 연말정산_비과세감면코드 : pyytYtfeDtyReduNm */
    public String  getPyytYtfeDtyReduNm() { return (String )get( ATTR_PYYTYTFEDTYREDUNM );}
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
    
    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

}
