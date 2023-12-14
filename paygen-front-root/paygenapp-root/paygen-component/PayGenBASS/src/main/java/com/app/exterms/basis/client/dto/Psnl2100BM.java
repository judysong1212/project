package com.app.exterms.basis.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class Psnl2100BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";
	

	/** set 휴가일수일련번호 : hodyNumDysSeilNum */
	public static final String ATTR_HODYNUMDYSSEILNUM = "hodyNumDysSeilNum";

	/** set 직종코드 : typOccuCd */
	public static final String ATTR_TYPOCCUCD = "typOccuCd";

	/** set 호봉등급코드 : pyspGrdeCd */
	public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
	
	 /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
    

	/** set 휴가일수이상 : hodyNumDysOvr */
	public static final String ATTR_HODYNUMDYSOVR = "hodyNumDysOvr";

	/** set 휴가일수미만 : hodyNumDysUdr */
	public static final String ATTR_HODYNUMDYSUDR = "hodyNumDysUdr";

	/** set 휴가일수유형코드 : hodyNumDysFrmCd */
	public static final String ATTR_HODYNUMDYSFRMCD = "hodyNumDysFrmCd";

	/** set 휴가일수 : hodyNumDys */
	public static final String ATTR_HODYNUMDYS = "hodyNumDys";

	/** set 휴가일수율 : hodyNumDysRate */
	public static final String ATTR_HODYNUMDYSRATE = "hodyNumDysRate";

	/** set 휴가일수시작일자 : hodyNumDysBgnnDt */
	public static final String ATTR_HODYNUMDYSBGNNDT = "hodyNumDysBgnnDt";

	/** set 휴가일수종료일자 : hodyNumDysEndDt */
	public static final String ATTR_HODYNUMDYSENDDT = "hodyNumDysEndDt";

	/** set 휴가일수사용여부 : hodyNumDysUseYn */
	public static final String ATTR_HODYNUMDYSUSEYN = "hodyNumDysUseYn";

	/** set 휴가일수비고내용 : hodyNumDysNoteCtnt */
	public static final String ATTR_HODYNUMDYSNOTECTNT = "hodyNumDysNoteCtnt";

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
	 public Psnl2100BM() { super(); } 

	/** 일괄등록 처리   */
	 public Psnl2100BM(
			 String  dpobCd 
			, Long  hodyNumDysSeilNum 
			, String  dtilOccuInttnCd 
			, String  typOccuCd 
			, String  pyspGrdeCd 
			, String  dtilOccuClsDivCd 
			, Long  hodyNumDysOvr 
			, Long  hodyNumDysUdr 
			, String  hodyNumDysFrmCd 
			, Long  hodyNumDys 
			, Double  hodyNumDysRate 
			, String  hodyNumDysBgnnDt 
			, String  hodyNumDysEndDt 
			, String  hodyNumDysUseYn 
			, String  hodyNumDysNoteCtnt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_HODYNUMDYSSEILNUM,hodyNumDysSeilNum);
	 	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
	 	values.put(ATTR_TYPOCCUCD,typOccuCd);
	 	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
	 	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
	 	values.put(ATTR_HODYNUMDYSOVR,hodyNumDysOvr);
	 	values.put(ATTR_HODYNUMDYSUDR,hodyNumDysUdr);
	 	values.put(ATTR_HODYNUMDYSFRMCD,hodyNumDysFrmCd);
	 	values.put(ATTR_HODYNUMDYS,hodyNumDys);
	 	values.put(ATTR_HODYNUMDYSRATE,hodyNumDysRate);
	 	values.put(ATTR_HODYNUMDYSBGNNDT,hodyNumDysBgnnDt);
	 	values.put(ATTR_HODYNUMDYSENDDT,hodyNumDysEndDt);
	 	values.put(ATTR_HODYNUMDYSUSEYN,hodyNumDysUseYn);
	 	values.put(ATTR_HODYNUMDYSNOTECTNT,hodyNumDysNoteCtnt);
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

	/** set 휴가일수일련번호 : hodyNumDysSeilNum */
	public void setHodyNumDysSeilNum(Long  hodyNumDysSeilNum) { set( ATTR_HODYNUMDYSSEILNUM ,hodyNumDysSeilNum);}
	/** get 휴가일수일련번호 : hodyNumDysSeilNum */
	public Long  getHodyNumDysSeilNum() { return (Long )get( ATTR_HODYNUMDYSSEILNUM );}

	/** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    
	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

	/** set 호봉등급코드 : pyspGrdeCd */
	public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
	/** get 호봉등급코드 : pyspGrdeCd */
	public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

	/** set 휴가일수이상 : hodyNumDysOvr */
	public void setHodyNumDysOvr(Long  hodyNumDysOvr) { set( ATTR_HODYNUMDYSOVR ,hodyNumDysOvr);}
	/** get 휴가일수이상 : hodyNumDysOvr */
	public Long  getHodyNumDysOvr() { return (Long )get( ATTR_HODYNUMDYSOVR );}

	/** set 휴가일수미만 : hodyNumDysUdr */
	public void setHodyNumDysUdr(Long  hodyNumDysUdr) { set( ATTR_HODYNUMDYSUDR ,hodyNumDysUdr);}
	/** get 휴가일수미만 : hodyNumDysUdr */
	public Long  getHodyNumDysUdr() { return (Long )get( ATTR_HODYNUMDYSUDR );}

	/** set 휴가일수유형코드 : hodyNumDysFrmCd */
	public void setHodyNumDysFrmCd(String  hodyNumDysFrmCd) { set( ATTR_HODYNUMDYSFRMCD ,hodyNumDysFrmCd);}
	/** get 휴가일수유형코드 : hodyNumDysFrmCd */
	public String  getHodyNumDysFrmCd() { return (String )get( ATTR_HODYNUMDYSFRMCD );}

	/** set 휴가일수 : hodyNumDys */
	public void setHodyNumDys(Long  hodyNumDys) { set( ATTR_HODYNUMDYS ,hodyNumDys);}
	/** get 휴가일수 : hodyNumDys */
	public Long  getHodyNumDys() { return (Long )get( ATTR_HODYNUMDYS );}

	/** set 휴가일수율 : hodyNumDysRate */
	public void setHodyNumDysRate(Double  hodyNumDysRate) { set( ATTR_HODYNUMDYSRATE ,hodyNumDysRate);}
	/** get 휴가일수율 : hodyNumDysRate */
	public Double getHodyNumDysRate() { return (Double)get( ATTR_HODYNUMDYSRATE );}

	/** set 휴가일수시작일자 : hodyNumDysBgnnDt */
	public void setHodyNumDysBgnnDt(String  hodyNumDysBgnnDt) { set( ATTR_HODYNUMDYSBGNNDT ,hodyNumDysBgnnDt);}
	/** get 휴가일수시작일자 : hodyNumDysBgnnDt */
	public String  getHodyNumDysBgnnDt() { return (String )get( ATTR_HODYNUMDYSBGNNDT );}

	/** set 휴가일수종료일자 : hodyNumDysEndDt */
	public void setHodyNumDysEndDt(String  hodyNumDysEndDt) { set( ATTR_HODYNUMDYSENDDT ,hodyNumDysEndDt);}
	/** get 휴가일수종료일자 : hodyNumDysEndDt */
	public String  getHodyNumDysEndDt() { return (String )get( ATTR_HODYNUMDYSENDDT );}

	/** set 휴가일수사용여부 : hodyNumDysUseYn */
	public void setHodyNumDysUseYn(String  hodyNumDysUseYn) { set( ATTR_HODYNUMDYSUSEYN ,hodyNumDysUseYn);}
	/** get 휴가일수사용여부 : hodyNumDysUseYn */
	public String  getHodyNumDysUseYn() { return (String )get( ATTR_HODYNUMDYSUSEYN );}

	/** set 휴가일수비고내용 : hodyNumDysNoteCtnt */
	public void setHodyNumDysNoteCtnt(String  hodyNumDysNoteCtnt) { set( ATTR_HODYNUMDYSNOTECTNT ,hodyNumDysNoteCtnt);}
	/** get 휴가일수비고내용 : hodyNumDysNoteCtnt */
	public String  getHodyNumDysNoteCtnt() { return (String )get( ATTR_HODYNUMDYSNOTECTNT );}

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
