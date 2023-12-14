package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0130VO.java
 * @Description : Psnl0130 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014/07/31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0111BM   extends MSFSimpleBaseModel implements IsSerializable  {
	
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 호주성명 : hfmlyNm */
    public static final String ATTR_HFMLYNM = "hfmlyNm";

    /** set 호주와의관계코드 : hfmlyRelaCd */
    public static final String ATTR_HFMLYRELACD = "hfmlyRelaCd";
    

    /** set 호주와의관계코드 : hfmlyRelaNm */
    public static final String ATTR_HFMLYRELANM = "hfmlyRelaNm";

    /** set 출생지주소 : bthcAddr */
    public static final String ATTR_BTHCADDR = "bthcAddr";

    /** set 집우편번호 : husZpcd */
    public static final String ATTR_HUSZPCD = "husZpcd";

    /** set 집기본주소 : husFndtnAddr */
    public static final String ATTR_HUSFNDTNADDR = "husFndtnAddr";

    /** set 집상세주소 : husDtlPatrAddr */
    public static final String ATTR_HUSDTLPATRADDR = "husDtlPatrAddr";

    /** set 집도로명우편번호 : husRoadNmZpcd */
    public static final String ATTR_HUSROADNMZPCD = "husRoadNmZpcd";

    /** set 집도로명기본주소 : husRoadNmFndtnAddr */
    public static final String ATTR_HUSROADNMFNDTNADDR = "husRoadNmFndtnAddr";

    /** set 집도로명상세주소 : husRoadNmDtlPatrAddr */
    public static final String ATTR_HUSROADNMDTLPATRADDR = "husRoadNmDtlPatrAddr";

    /** set 집전화번호 : husPhnNum */
    public static final String ATTR_HUSPHNNUM = "husPhnNum";

    /** set 집도로명영문주소 : husRoadNmEngAddr */
    public static final String ATTR_HUSROADNMENGADDR = "husRoadNmEngAddr";

    /** set 직장우편번호 : wkOfcZpcd */
    public static final String ATTR_WKOFCZPCD = "wkOfcZpcd";

    /** set 직장기본주소 : wkOfcFndtnAddr */
    public static final String ATTR_WKOFCFNDTNADDR = "wkOfcFndtnAddr";

    /** set 직장상세주소 : wkOfcDtlPatrAddr */
    public static final String ATTR_WKOFCDTLPATRADDR = "wkOfcDtlPatrAddr";

    /** set 회사전화번호 : cmpyPhnNum */
    public static final String ATTR_CMPYPHNNUM = "cmpyPhnNum";

    /** set 회사팩스번호 : cmpyFaxNum */
    public static final String ATTR_CMPYFAXNUM = "cmpyFaxNum";

    /** set 차량번호 : carNum */
    public static final String ATTR_CARNUM = "carNum";

    /** set 차종 : carMdl */
    public static final String ATTR_CARMDL = "carMdl";

    /** set 핸드폰번호 : cellPhneNum */
    public static final String ATTR_CELLPHNENUM = "cellPhneNum";

    /** set 이메일주소 : emailAddr */
    public static final String ATTR_EMAILADDR = "emailAddr";

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
     public Psnl0111BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0111BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  hfmlyNm 
    		, String  hfmlyRelaCd 
    		, String  bthcAddr 
    		, String  husZpcd 
    		, String  husFndtnAddr 
    		, String  husDtlPatrAddr 
    		, String  husRoadNmZpcd 
    		, String  husRoadNmFndtnAddr 
    		, String  husRoadNmDtlPatrAddr 
    		, String  husPhnNum 
    		, String  husRoadNmEngAddr 
    		, String  wkOfcZpcd 
    		, String  wkOfcFndtnAddr 
    		, String  wkOfcDtlPatrAddr 
    		, String  cmpyPhnNum 
    		, String  cmpyFaxNum 
    		, String  carNum 
    		, String  carMdl 
    		, String  cellPhneNum 
    		, String  emailAddr 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_HFMLYNM,hfmlyNm);
     	values.put(ATTR_HFMLYRELACD,hfmlyRelaCd);
     	values.put(ATTR_BTHCADDR,bthcAddr);
     	values.put(ATTR_HUSZPCD,husZpcd);
     	values.put(ATTR_HUSFNDTNADDR,husFndtnAddr);
     	values.put(ATTR_HUSDTLPATRADDR,husDtlPatrAddr);
     	values.put(ATTR_HUSROADNMZPCD,husRoadNmZpcd);
     	values.put(ATTR_HUSROADNMFNDTNADDR,husRoadNmFndtnAddr);
     	values.put(ATTR_HUSROADNMDTLPATRADDR,husRoadNmDtlPatrAddr);
     	values.put(ATTR_HUSPHNNUM,husPhnNum);
     	values.put(ATTR_HUSROADNMENGADDR,husRoadNmEngAddr);
     	values.put(ATTR_WKOFCZPCD,wkOfcZpcd);
     	values.put(ATTR_WKOFCFNDTNADDR,wkOfcFndtnAddr);
     	values.put(ATTR_WKOFCDTLPATRADDR,wkOfcDtlPatrAddr);
     	values.put(ATTR_CMPYPHNNUM,cmpyPhnNum);
     	values.put(ATTR_CMPYFAXNUM,cmpyFaxNum);
     	values.put(ATTR_CARNUM,carNum);
     	values.put(ATTR_CARMDL,carMdl);
     	values.put(ATTR_CELLPHNENUM,cellPhneNum);
     	values.put(ATTR_EMAILADDR,emailAddr);
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

    /** set 호주성명 : hfmlyNm */
    public void setHfmlyNm(String  hfmlyNm) { set( ATTR_HFMLYNM ,hfmlyNm);}
    /** get 호주성명 : hfmlyNm */
    public String  getHfmlyNm() { return (String )get( ATTR_HFMLYNM );}

    /** set 호주와의관계코드 : hfmlyRelaCd */
    public void setHfmlyRelaCd(String  hfmlyRelaCd) { set( ATTR_HFMLYRELACD ,hfmlyRelaCd);}
    /** get 호주와의관계코드 : hfmlyRelaCd */
    public String  getHfmlyRelaCd() { return (String )get( ATTR_HFMLYRELACD );}
    

    /** set 호주와의관계 : hfmlyRelaNm */
    public void setHfmlyRelaNm(String  hfmlyRelaNm) { set( ATTR_HFMLYRELANM ,hfmlyRelaNm);}
    /** get 호주와의관계 : hfmlyRelaNm */
    public String  getHfmlyRelaNm() { return (String )get( ATTR_HFMLYRELANM );}

    /** set 출생지주소 : bthcAddr */
    public void setBthcAddr(String  bthcAddr) { set( ATTR_BTHCADDR ,bthcAddr);}
    /** get 출생지주소 : bthcAddr */
    public String  getBthcAddr() { return (String )get( ATTR_BTHCADDR );}

    /** set 집우편번호 : husZpcd */
    public void setHusZpcd(String  husZpcd) { set( ATTR_HUSZPCD ,husZpcd);}
    /** get 집우편번호 : husZpcd */
    public String  getHusZpcd() { return (String )get( ATTR_HUSZPCD );}

    /** set 집기본주소 : husFndtnAddr */
    public void setHusFndtnAddr(String  husFndtnAddr) { set( ATTR_HUSFNDTNADDR ,husFndtnAddr);}
    /** get 집기본주소 : husFndtnAddr */
    public String  getHusFndtnAddr() { return (String )get( ATTR_HUSFNDTNADDR );}

    /** set 집상세주소 : husDtlPatrAddr */
    public void setHusDtlPatrAddr(String  husDtlPatrAddr) { set( ATTR_HUSDTLPATRADDR ,husDtlPatrAddr);}
    /** get 집상세주소 : husDtlPatrAddr */
    public String  getHusDtlPatrAddr() { return (String )get( ATTR_HUSDTLPATRADDR );}

    /** set 집도로명우편번호 : husRoadNmZpcd */
    public void setHusRoadNmZpcd(String  husRoadNmZpcd) { set( ATTR_HUSROADNMZPCD ,husRoadNmZpcd);}
    /** get 집도로명우편번호 : husRoadNmZpcd */
    public String  getHusRoadNmZpcd() { return (String )get( ATTR_HUSROADNMZPCD );}

    /** set 집도로명기본주소 : husRoadNmFndtnAddr */
    public void setHusRoadNmFndtnAddr(String  husRoadNmFndtnAddr) { set( ATTR_HUSROADNMFNDTNADDR ,husRoadNmFndtnAddr);}
    /** get 집도로명기본주소 : husRoadNmFndtnAddr */
    public String  getHusRoadNmFndtnAddr() { return (String )get( ATTR_HUSROADNMFNDTNADDR );}

    /** set 집도로명상세주소 : husRoadNmDtlPatrAddr */
    public void setHusRoadNmDtlPatrAddr(String  husRoadNmDtlPatrAddr) { set( ATTR_HUSROADNMDTLPATRADDR ,husRoadNmDtlPatrAddr);}
    /** get 집도로명상세주소 : husRoadNmDtlPatrAddr */
    public String  getHusRoadNmDtlPatrAddr() { return (String )get( ATTR_HUSROADNMDTLPATRADDR );}

    /** set 집전화번호 : husPhnNum */
    public void setHusPhnNum(String  husPhnNum) { set( ATTR_HUSPHNNUM ,husPhnNum);}
    /** get 집전화번호 : husPhnNum */
    public String  getHusPhnNum() { return (String )get( ATTR_HUSPHNNUM );}

    /** set 집도로명영문주소 : husRoadNmEngAddr */
    public void setHusRoadNmEngAddr(String  husRoadNmEngAddr) { set( ATTR_HUSROADNMENGADDR ,husRoadNmEngAddr);}
    /** get 집도로명영문주소 : husRoadNmEngAddr */
    public String  getHusRoadNmEngAddr() { return (String )get( ATTR_HUSROADNMENGADDR );}

    /** set 직장우편번호 : wkOfcZpcd */
    public void setWkOfcZpcd(String  wkOfcZpcd) { set( ATTR_WKOFCZPCD ,wkOfcZpcd);}
    /** get 직장우편번호 : wkOfcZpcd */
    public String  getWkOfcZpcd() { return (String )get( ATTR_WKOFCZPCD );}

    /** set 직장기본주소 : wkOfcFndtnAddr */
    public void setWkOfcFndtnAddr(String  wkOfcFndtnAddr) { set( ATTR_WKOFCFNDTNADDR ,wkOfcFndtnAddr);}
    /** get 직장기본주소 : wkOfcFndtnAddr */
    public String  getWkOfcFndtnAddr() { return (String )get( ATTR_WKOFCFNDTNADDR );}

    /** set 직장상세주소 : wkOfcDtlPatrAddr */
    public void setWkOfcDtlPatrAddr(String  wkOfcDtlPatrAddr) { set( ATTR_WKOFCDTLPATRADDR ,wkOfcDtlPatrAddr);}
    /** get 직장상세주소 : wkOfcDtlPatrAddr */
    public String  getWkOfcDtlPatrAddr() { return (String )get( ATTR_WKOFCDTLPATRADDR );}

    /** set 회사전화번호 : cmpyPhnNum */
    public void setCmpyPhnNum(String  cmpyPhnNum) { set( ATTR_CMPYPHNNUM ,cmpyPhnNum);}
    /** get 회사전화번호 : cmpyPhnNum */
    public String  getCmpyPhnNum() { return (String )get( ATTR_CMPYPHNNUM );}

    /** set 회사팩스번호 : cmpyFaxNum */
    public void setCmpyFaxNum(String  cmpyFaxNum) { set( ATTR_CMPYFAXNUM ,cmpyFaxNum);}
    /** get 회사팩스번호 : cmpyFaxNum */
    public String  getCmpyFaxNum() { return (String )get( ATTR_CMPYFAXNUM );}

    /** set 차량번호 : carNum */
    public void setCarNum(String  carNum) { set( ATTR_CARNUM ,carNum);}
    /** get 차량번호 : carNum */
    public String  getCarNum() { return (String )get( ATTR_CARNUM );}

    /** set 차종 : carMdl */
    public void setCarMdl(String  carMdl) { set( ATTR_CARMDL ,carMdl);}
    /** get 차종 : carMdl */
    public String  getCarMdl() { return (String )get( ATTR_CARMDL );}

    /** set 핸드폰번호 : cellPhneNum */
    public void setCellPhneNum(String  cellPhneNum) { set( ATTR_CELLPHNENUM ,cellPhneNum);}
    /** get 핸드폰번호 : cellPhneNum */
    public String  getCellPhneNum() { return (String )get( ATTR_CELLPHNENUM );}

    /** set 이메일주소 : emailAddr */
    public void setEmailAddr(String  emailAddr) { set( ATTR_EMAILADDR ,emailAddr);}
    /** get 이메일주소 : emailAddr */
    public String  getEmailAddr() { return (String )get( ATTR_EMAILADDR );}

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
