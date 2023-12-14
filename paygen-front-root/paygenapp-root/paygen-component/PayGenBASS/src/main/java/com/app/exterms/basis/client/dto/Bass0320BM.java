package com.app.exterms.basis.client.dto;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0350VO.java
 * @Description : Bass0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0320BM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 직종사용여부 : typOccuUseYn */
    public static final String ATTR_TYPOCCUUSEYN = "typOccuUseYn";

    /** set 직종내용 : typOccuCtnt */
    public static final String ATTR_TYPOCCUCTNT = "typOccuCtnt";

    /** set 정렬순서 : typOccuOrd */
    public static final String ATTR_TYPOCCUORD = "typOccuOrd";

    /** set 직종직군구분코드 : typOccuJbfmlDivCd */
    public static final String ATTR_TYPOCCUJBFMLDIVCD = "typOccuJbfmlDivCd";

    /** set null : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

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


/** set 이전직종코드 : chngTypOccuCd */
public static final String ATTR_CHNGTYPOCCUCD = "chngTypOccuCd";

/** set 직종시작일자 : typOccuStdt */
public static final String ATTR_TYPOCCUSTDT = "typOccuStdt";

/** set 직종종료일자 : typOccuEddt */
public static final String ATTR_TYPOCCUEDDT = "typOccuEddt";


    /** 생성자 */
     public Bass0320BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass0320BM(
    		 String  dpobCd 
    		, String  typOccuCd 
    		, String  typOccuNm 
    		, String  typOccuUseYn 
    		, String  typOccuCtnt 
    		, BigDecimal  typOccuOrd 
    		, String  typOccuJbfmlDivCd 
    		, String  pyspGrdeCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr
    		, String  chngTypOccuCd
    		, String  typOccuStdt
    		, String  typOccuEddt) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_TYPOCCUNM,typOccuNm);
     	values.put(ATTR_TYPOCCUUSEYN,typOccuUseYn);
     	values.put(ATTR_TYPOCCUCTNT,typOccuCtnt);
     	values.put(ATTR_TYPOCCUORD,typOccuOrd);
     	values.put(ATTR_TYPOCCUJBFMLDIVCD,typOccuJbfmlDivCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_CHNGTYPOCCUCD,chngTypOccuCd);
     	values.put(ATTR_TYPOCCUSTDT,typOccuStdt);
     	values.put(ATTR_TYPOCCUEDDT,typOccuEddt);} 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종명 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종명 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    /** set 직종사용여부 : typOccuUseYn */
    public void setTypOccuUseYn(Boolean  typOccuUseYn) { set( ATTR_TYPOCCUUSEYN ,typOccuUseYn);}
    /** get 직종사용여부 : typOccuUseYn */
    public Boolean  getTypOccuUseYn() { return (Boolean )get( ATTR_TYPOCCUUSEYN );}

    /** set 직종내용 : typOccuCtnt */
    public void setTypOccuCtnt(String  typOccuCtnt) { set( ATTR_TYPOCCUCTNT ,typOccuCtnt);}
    /** get 직종내용 : typOccuCtnt */
    public String  getTypOccuCtnt() { return (String )get( ATTR_TYPOCCUCTNT );}

    /** set 정렬순서 : typOccuOrd */
    public void setTypOccuOrd(Long  typOccuOrd) { set( ATTR_TYPOCCUORD ,typOccuOrd);}
    /** get 정렬순서 : typOccuOrd */
    public Long  getTypOccuOrd() { return (Long )get( ATTR_TYPOCCUORD );}

    /** set 직종직군구분코드 : typOccuJbfmlDivCd */
    public void setTypOccuJbfmlDivCd(String  typOccuJbfmlDivCd) { set( ATTR_TYPOCCUJBFMLDIVCD ,typOccuJbfmlDivCd);}
    /** get 직종직군구분코드 : typOccuJbfmlDivCd */
    public String  getTypOccuJbfmlDivCd() { return (String )get( ATTR_TYPOCCUJBFMLDIVCD );}

    /** set null : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get null : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

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

/** set 이전직종코드 : chngTypOccuCd */
public void setChngTypOccuCd(String  chngTypOccuCd) { set( ATTR_CHNGTYPOCCUCD ,chngTypOccuCd);}
/** get 이전직종코드 : chngTypOccuCd */
public String  getChngTypOccuCd() { return (String )get( ATTR_CHNGTYPOCCUCD );}

/** set 직종시작일자 : typOccuStdt */
public void setTypOccuStdt(String  typOccuStdt) { set( ATTR_TYPOCCUSTDT ,typOccuStdt);}
/** get 직종시작일자 : typOccuStdt */
public String  getTypOccuStdt() { return (String )get( ATTR_TYPOCCUSTDT );}

/** set 직종종료일자 : typOccuEddt */
public void setTypOccuEddt(String  typOccuEddt) { set( ATTR_TYPOCCUEDDT ,typOccuEddt);}
/** get 직종종료일자 : typOccuEddt */
public String  getTypOccuEddt() { return (String )get( ATTR_TYPOCCUEDDT );}

}
