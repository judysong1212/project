package com.app.smrmf.sysauth.systemmtr.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysMtrSysm0050BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 시스템사업장코드 : sysDpobCd */
	public static final String ATTR_SYSDPOBCD = "sysDpobCd";

	/** set 시스템사업장명 : sysDpobNm */
	public static final String ATTR_SYSDPOBNM = "sysDpobNm";

	/** set 시스템사업장KEY : sysDpobKey */
	public static final String ATTR_SYSDPOBKEY = "sysDpobKey";

	/** set 사용시스템구분코드 : useSysDivCd */
	public static final String ATTR_USESYSDIVCD = "useSysDivCd";

	/** set 시스템사업장사용여부 : sysDpobUseYn */
	public static final String ATTR_SYSDPOBUSEYN = "sysDpobUseYn";

	/** set 시스템사업장개시일자 : sysDpobBgnDt */
	public static final String ATTR_SYSDPOBBGNDT = "sysDpobBgnDt";

	/** set 시스템사업장종료일자 : sysDpobEdDt */
	public static final String ATTR_SYSDPOBEDDT = "sysDpobEdDt";

	/** set 시스템사업장내용 : sysDpobCtnt */
	public static final String ATTR_SYSDPOBCTNT = "sysDpobCtnt";

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
	 public SysMtrSysm0050BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysMtrSysm0050BM(
			 String  sysDpobCd 
			, String  sysDpobNm 
			, String  sysDpobKey 
			, String  useSysDivCd 
			, String  sysDpobUseYn 
			, String  sysDpobBgnDt 
			, String  sysDpobEdDt 
			, String  sysDpobCtnt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_SYSDPOBCD,sysDpobCd);
	 	values.put(ATTR_SYSDPOBNM,sysDpobNm);
	 	values.put(ATTR_SYSDPOBKEY,sysDpobKey);
	 	values.put(ATTR_USESYSDIVCD,useSysDivCd);
	 	values.put(ATTR_SYSDPOBUSEYN,sysDpobUseYn);
	 	values.put(ATTR_SYSDPOBBGNDT,sysDpobBgnDt);
	 	values.put(ATTR_SYSDPOBEDDT,sysDpobEdDt);
	 	values.put(ATTR_SYSDPOBCTNT,sysDpobCtnt);
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr); } 

	/** set 시스템사업장코드 : sysDpobCd */
	public void setSysDpobCd(String  sysDpobCd) { set( ATTR_SYSDPOBCD ,sysDpobCd);}
	/** get 시스템사업장코드 : sysDpobCd */
	public String  getSysDpobCd() { return (String )get( ATTR_SYSDPOBCD );}

	/** set 시스템사업장명 : sysDpobNm */
	public void setSysDpobNm(String  sysDpobNm) { set( ATTR_SYSDPOBNM ,sysDpobNm);}
	/** get 시스템사업장명 : sysDpobNm */
	public String  getSysDpobNm() { return (String )get( ATTR_SYSDPOBNM );}

	/** set 시스템사업장KEY : sysDpobKey */
	public void setSysDpobKey(String  sysDpobKey) { set( ATTR_SYSDPOBKEY ,sysDpobKey);}
	/** get 시스템사업장KEY : sysDpobKey */
	public String  getSysDpobKey() { return (String )get( ATTR_SYSDPOBKEY );}

	/** set 사용시스템구분코드 : useSysDivCd */
	public void setUseSysDivCd(String  useSysDivCd) { set( ATTR_USESYSDIVCD ,useSysDivCd);}
	/** get 사용시스템구분코드 : useSysDivCd */
	public String  getUseSysDivCd() { return (String )get( ATTR_USESYSDIVCD );}

	/** set 시스템사업장사용여부 : sysDpobUseYn */
	public void setSysDpobUseYn(String  sysDpobUseYn) { set( ATTR_SYSDPOBUSEYN ,sysDpobUseYn);}
	/** get 시스템사업장사용여부 : sysDpobUseYn */
	public String  getSysDpobUseYn() { return (String )get( ATTR_SYSDPOBUSEYN );}

	/** set 시스템사업장개시일자 : sysDpobBgnDt */
	public void setSysDpobBgnDt(String  sysDpobBgnDt) { set( ATTR_SYSDPOBBGNDT ,sysDpobBgnDt);}
	/** get 시스템사업장개시일자 : sysDpobBgnDt */
	public String  getSysDpobBgnDt() { return (String )get( ATTR_SYSDPOBBGNDT );}

	/** set 시스템사업장종료일자 : sysDpobEdDt */
	public void setSysDpobEdDt(String  sysDpobEdDt) { set( ATTR_SYSDPOBEDDT ,sysDpobEdDt);}
	/** get 시스템사업장종료일자 : sysDpobEdDt */
	public String  getSysDpobEdDt() { return (String )get( ATTR_SYSDPOBEDDT );}

	/** set 시스템사업장내용 : sysDpobCtnt */
	public void setSysDpobCtnt(String  sysDpobCtnt) { set( ATTR_SYSDPOBCTNT ,sysDpobCtnt);}
	/** get 시스템사업장내용 : sysDpobCtnt */
	public String  getSysDpobCtnt() { return (String )get( ATTR_SYSDPOBCTNT );}

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
