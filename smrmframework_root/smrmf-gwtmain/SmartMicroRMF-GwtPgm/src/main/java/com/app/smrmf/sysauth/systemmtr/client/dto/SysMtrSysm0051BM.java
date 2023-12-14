package com.app.smrmf.sysauth.systemmtr.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysMtrSysm0051BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 시스템사업장코드 : sysDpobCd */
	public static final String ATTR_SYSDPOBCD = "sysDpobCd";

	/** set 고용구분코드 : emymtDivCd */
	public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
	
	/** set 고용구분코드 : emymtDivNm */
	public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

	/** set 과세유형구분코드 : txtnFrmDivCd */
	public static final String ATTR_TXTNFRMDIVCD = "txtnFrmDivCd";

	/** set 과세유형시작일자 : txtnFrmBgnnDt */
	public static final String ATTR_TXTNFRMBGNNDT = "txtnFrmBgnnDt";

	/** set 과세유형종료일자 : txtnFrmEndDt */
	public static final String ATTR_TXTNFRMENDDT = "txtnFrmEndDt";

	/** set 과세유형내용 : txtnFrmCtnt */
	public static final String ATTR_TXTNFRMCTNT = "txtnFrmCtnt";

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
	 public SysMtrSysm0051BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysMtrSysm0051BM(
			  String  sysDpobCd 
			, String  emymtDivCd 
			, String  txtnFrmDivCd 
			, String  txtnFrmBgnnDt 
			, String  txtnFrmEndDt 
			, String  txtnFrmCtnt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_SYSDPOBCD,sysDpobCd);
	 	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
	 	values.put(ATTR_TXTNFRMDIVCD,txtnFrmDivCd);
	 	values.put(ATTR_TXTNFRMBGNNDT,txtnFrmBgnnDt);
	 	values.put(ATTR_TXTNFRMENDDT,txtnFrmEndDt);
	 	values.put(ATTR_TXTNFRMCTNT,txtnFrmCtnt);
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

	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
	
	/** set 고용구분코드 : emymtDivNm */
	public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
	/** get 고용구분코드 : emymtDivNm */
	public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}
	

	/** set 과세유형구분코드 : txtnFrmDivCd */
	public void setTxtnFrmDivCd(String  txtnFrmDivCd) { set( ATTR_TXTNFRMDIVCD ,txtnFrmDivCd);}
	/** get 과세유형구분코드 : txtnFrmDivCd */
	public String  getTxtnFrmDivCd() { return (String )get( ATTR_TXTNFRMDIVCD );}

	/** set 과세유형시작일자 : txtnFrmBgnnDt */
	public void setTxtnFrmBgnnDt(String  txtnFrmBgnnDt) { set( ATTR_TXTNFRMBGNNDT ,txtnFrmBgnnDt);}
	/** get 과세유형시작일자 : txtnFrmBgnnDt */
	public String  getTxtnFrmBgnnDt() { return (String )get( ATTR_TXTNFRMBGNNDT );}

	/** set 과세유형종료일자 : txtnFrmEndDt */
	public void setTxtnFrmEndDt(String  txtnFrmEndDt) { set( ATTR_TXTNFRMENDDT ,txtnFrmEndDt);}
	/** get 과세유형종료일자 : txtnFrmEndDt */
	public String  getTxtnFrmEndDt() { return (String )get( ATTR_TXTNFRMENDDT );}

	/** set 과세유형내용 : txtnFrmCtnt */
	public void setTxtnFrmCtnt(String  txtnFrmCtnt) { set( ATTR_TXTNFRMCTNT ,txtnFrmCtnt);}
	/** get 과세유형내용 : txtnFrmCtnt */
	public String  getTxtnFrmCtnt() { return (String )get( ATTR_TXTNFRMCTNT );}

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
