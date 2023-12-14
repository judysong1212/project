package com.app.exterms.personal.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0112BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 입대일자 : enrlntDt */
    public static final String ATTR_ENRLNTDT = "enrlntDt";

    /** set 제대일자 : dsageDt */
    public static final String ATTR_DSAGEDT = "dsageDt";

    /** set 복무인정기간코드 : servcRcgtnPridCd */
    public static final String ATTR_SERVCRCGTNPRIDCD = "servcRcgtnPridCd";
    
    /** set 복무인정기간코드 : servcRcgtnPridNm */
    public static final String ATTR_SERVCRCGTNPRIDNM = "servcRcgtnPridNm";

    /** set 역종코드 : srvssCd */
    public static final String ATTR_SRVSSCD = "srvssCd";
    /** set 역종코드 : srvssNm */
    public static final String ATTR_SRVSSNM = "srvssNm";

    /** set 군별코드 : baggrpCd */
    public static final String ATTR_BAGGRPCD = "baggrpCd";
    /** set 군별코드 : baggrpNm */
    public static final String ATTR_BAGGRPNM = "baggrpNm";

    /** set 병과코드 : abotsCd */
    public static final String ATTR_ABOTSCD = "abotsCd";
    /** set 병과코드 : abotsNm */
    public static final String ATTR_ABOTSNM = "abotsNm";

    /** set 계급코드 : clsCd */
    public static final String ATTR_CLSCD = "clsCd";
    /** set 계급코드 : clsNm */
    public static final String ATTR_CLSNM = "clsNm";

    /** set 군번 : mitySilnum */
    public static final String ATTR_MITYSILNUM = "mitySilnum";

    /** set MOS : mos */
    public static final String ATTR_MOS = "mos";

    /** set 제대구분코드 : dsageDivCd */
    public static final String ATTR_DSAGEDIVCD = "dsageDivCd";
    
    /** set 제대구분코드 : dsageDivNm */
    public static final String ATTR_DSAGEDIVNM = "dsageDivNm";

    /** set 면제사유코드 : exmtnReasCd */
    public static final String ATTR_EXMTNREASCD = "exmtnReasCd";

    /** set 면제사유내용 : exmtnReasCtnt */
    public static final String ATTR_EXMTNREASCTNT = "exmtnReasCtnt";

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
     public Psnl0112BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0112BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  enrlntDt 
    		, String  dsageDt 
    		, String  servcRcgtnPridCd 
    		, String  srvssCd 
    		, String  baggrpCd 
    		, String  abotsCd 
    		, String  clsCd 
    		, String  mitySilnum 
    		, String  mos 
    		, String  dsageDivCd 
    		, String  exmtnReasCd 
    		, String  exmtnReasCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_ENRLNTDT,enrlntDt);
     	values.put(ATTR_DSAGEDT,dsageDt);
     	values.put(ATTR_SERVCRCGTNPRIDCD,servcRcgtnPridCd);
     	values.put(ATTR_SRVSSCD,srvssCd);
     	values.put(ATTR_BAGGRPCD,baggrpCd);
     	values.put(ATTR_ABOTSCD,abotsCd);
     	values.put(ATTR_CLSCD,clsCd);
     	values.put(ATTR_MITYSILNUM,mitySilnum);
     	values.put(ATTR_MOS,mos);
     	values.put(ATTR_DSAGEDIVCD,dsageDivCd);
     	values.put(ATTR_EXMTNREASCD,exmtnReasCd);
     	values.put(ATTR_EXMTNREASCTNT,exmtnReasCtnt);
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
    /** set 입대일자 : enrlntDt */
    public void setEnrlntDt(String  enrlntDt) { set( ATTR_ENRLNTDT ,enrlntDt);}
    /** get 입대일자 : enrlntDt */
    public String  getEnrlntDt() { return (String )get( ATTR_ENRLNTDT );}
    /** set 제대일자 : dsageDt */
    public void setDsageDt(String  dsageDt) { set( ATTR_DSAGEDT ,dsageDt);}
    /** get 제대일자 : dsageDt */
    public String  getDsageDt() { return (String )get( ATTR_DSAGEDT );}
    /** set 복무인정기간코드 : servcRcgtnPridCd */
    public void setServcRcgtnPridCd(String  servcRcgtnPridCd) { set( ATTR_SERVCRCGTNPRIDCD ,servcRcgtnPridCd);}
    /** get 복무인정기간코드 : servcRcgtnPridCd */
    public String  getServcRcgtnPridCd() { return (String )get( ATTR_SERVCRCGTNPRIDCD );}
    
    /** set 복무인정기간코드 : servcRcgtnPridNm */
    public void setServcRcgtnPridNm(String  servcRcgtnPridNm) { set( ATTR_SERVCRCGTNPRIDNM ,servcRcgtnPridNm);}
    /** get 복무인정기간코드 : servcRcgtnPridNm */
    public String  getServcRcgtnPridNm() { return (String )get( ATTR_SERVCRCGTNPRIDNM );}
    
    /** set 역종코드 : srvssCd */
    public void setSrvssCd(String  srvssCd) { set( ATTR_SRVSSCD ,srvssCd);}
    /** get 역종코드 : srvssCd */
    public String  getSrvssCd() { return (String )get( ATTR_SRVSSCD );}
    /** set 역종코드 : srvssNm */
    public void setSrvssNm(String  srvssNm) { set( ATTR_SRVSSNM ,srvssNm);}
    /** get 역종코드 : srvssNm */
    public String  getSrvssNm() { return (String )get( ATTR_SRVSSNM );}
    
    
    /** set 군별코드 : baggrpCd */
    public void setBaggrpCd(String  baggrpCd) { set( ATTR_BAGGRPCD ,baggrpCd);}
    /** get 군별코드 : baggrpCd */
    public String  getBaggrpCd() { return (String )get( ATTR_BAGGRPCD );}
    /** set 군별코드 : baggrpNm */
    public void setBaggrpNm(String  baggrpNm) { set( ATTR_BAGGRPNM ,baggrpNm);}
    /** get 군별코드 : baggrpNm */
    public String  getBaggrpNm() { return (String )get( ATTR_BAGGRPNM );}
    
    
    /** set 병과코드 : abotsCd */
    public void setAbotsCd(String  abotsCd) { set( ATTR_ABOTSCD ,abotsCd);}
    /** get 병과코드 : abotsCd */
    public String  getAbotsCd() { return (String )get( ATTR_ABOTSCD );}
    /** set 병과코드 : abotsNm */
    public void setAbotsNm(String  abotsNm) { set( ATTR_ABOTSNM ,abotsNm);}
    /** get 병과코드 : abotsNm */
    public String  getAbotsNm() { return (String )get( ATTR_ABOTSNM );}
    
    
    /** set 계급코드 : clsCd */
    public void setClsCd(String  clsCd) { set( ATTR_CLSCD ,clsCd);}
    /** get 계급코드 : clsCd */
    public String  getClsCd() { return (String )get( ATTR_CLSCD );}
    /** set 계급코드 : clsNm */
    public void setClsNm(String  clsNm) { set( ATTR_CLSNM ,clsNm);}
    /** get 계급코드 : clsNm */
    public String  getClsNm() { return (String )get( ATTR_CLSNM );}
    
    
    /** set 군번 : mitySilnum */
    public void setMitySilnum(String  mitySilnum) { set( ATTR_MITYSILNUM ,mitySilnum);}
    /** get 군번 : mitySilnum */
    public String  getMitySilnum() { return (String )get( ATTR_MITYSILNUM );}
    /** set MOS : mos */
    public void setMos(String  mos) { set( ATTR_MOS ,mos);}
    /** get MOS : mos */
    public String  getMos() { return (String )get( ATTR_MOS );}
    /** set 제대구분코드 : dsageDivCd */
    public void setDsageDivCd(String  dsageDivCd) { set( ATTR_DSAGEDIVCD ,dsageDivCd);}
    /** get 제대구분코드 : dsageDivCd */
    public String  getDsageDivCd() { return (String )get( ATTR_DSAGEDIVCD );}
    
    /** set 제대구분코드 : dsageDivNm */
    public void setDsageDivNm(String  dsageDivNm) { set( ATTR_DSAGEDIVNM ,dsageDivNm);}
    /** get 제대구분코드 : dsageDivCd */
    public String  dsageDivNm() { return (String )get( ATTR_DSAGEDIVNM );}
    
    /** set 면제사유코드 : exmtnReasCd */
    public void setExmtnReasCd(String  exmtnReasCd) { set( ATTR_EXMTNREASCD ,exmtnReasCd);}
    /** get 면제사유코드 : exmtnReasCd */
    public String  getExmtnReasCd() { return (String )get( ATTR_EXMTNREASCD );}
    /** set 면제사유내용 : exmtnReasCtnt */
    public void setExmtnReasCtnt(String  exmtnReasCtnt) { set( ATTR_EXMTNREASCTNT ,exmtnReasCtnt);}
    /** get 면제사유내용 : exmtnReasCtnt */
    public String  getExmtnReasCtnt() { return (String )get( ATTR_EXMTNREASCTNT );}
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
