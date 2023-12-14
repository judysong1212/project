package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr1300VO.java
 * @Description : Insr1300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1300BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public static final String ATTR_SOCTYINSURCMPTNDT = "soctyInsurCmptnDt";

	/** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public static final String ATTR_SOCINSRAQTNEMYMTNUM = "socInsrAqtnEmymtNum";

	/** set 국민연금소득월액 : natPennIncmMnthAmnt */
	public static final String ATTR_NATPENNINCMMNTHAMNT = "natPennIncmMnthAmnt";

	/** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	public static final String ATTR_HLTHINSRMNTHRUNTNAMNT = "hlthInsrMnthRuntnAmnt";

	/** set 고용보험보수월액 : umytInsrPayMnthAmnt */
	public static final String ATTR_UMYTINSRPAYMNTHAMNT = "umytInsrPayMnthAmnt";

	/** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
	public static final String ATTR_IDTLACCDTPAYMNTHAMNT = "idtlAccdtPayMnthAmnt";

	/** set 비고 : note */
	public static final String ATTR_NOTE = "note";

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
	 public Insr1300BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr1300BM(
			 String  dpobCd 
			, String  systemkey 
			, String  soctyInsurCmptnDt 
			, Long  socInsrAqtnEmymtNum 
			, Long  natPennIncmMnthAmnt 
			, Long  hlthInsrMnthRuntnAmnt 
			, Long  umytInsrPayMnthAmnt 
			, Long  idtlAccdtPayMnthAmnt 
			, String  note 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_SOCTYINSURCMPTNDT,soctyInsurCmptnDt);
	 	values.put(ATTR_SOCINSRAQTNEMYMTNUM,socInsrAqtnEmymtNum);
	 	values.put(ATTR_NATPENNINCMMNTHAMNT,natPennIncmMnthAmnt);
	 	values.put(ATTR_HLTHINSRMNTHRUNTNAMNT,hlthInsrMnthRuntnAmnt);
	 	values.put(ATTR_UMYTINSRPAYMNTHAMNT,umytInsrPayMnthAmnt);
	 	values.put(ATTR_IDTLACCDTPAYMNTHAMNT,idtlAccdtPayMnthAmnt);
	 	values.put(ATTR_NOTE,note);
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

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public void setSoctyInsurCmptnDt(String  soctyInsurCmptnDt) { set( ATTR_SOCTYINSURCMPTNDT ,soctyInsurCmptnDt);}
	/** get 사회보험작성일자 : soctyInsurCmptnDt */
	public String  getSoctyInsurCmptnDt() { return (String )get( ATTR_SOCTYINSURCMPTNDT );}

	/** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public void setSocInsrAqtnEmymtNum(Long  socInsrAqtnEmymtNum) { set( ATTR_SOCINSRAQTNEMYMTNUM ,socInsrAqtnEmymtNum);}
	/** get 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public Long  getSocInsrAqtnEmymtNum() { return (Long )get( ATTR_SOCINSRAQTNEMYMTNUM );}

	/** set 국민연금소득월액 : natPennIncmMnthAmnt */
	public void setNatPennIncmMnthAmnt(Long  natPennIncmMnthAmnt) { set( ATTR_NATPENNINCMMNTHAMNT ,natPennIncmMnthAmnt);}
	/** get 국민연금소득월액 : natPennIncmMnthAmnt */
	public Long  getNatPennIncmMnthAmnt() { return (Long )get( ATTR_NATPENNINCMMNTHAMNT );}

	/** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	public void setHlthInsrMnthRuntnAmnt(Long  hlthInsrMnthRuntnAmnt) { set( ATTR_HLTHINSRMNTHRUNTNAMNT ,hlthInsrMnthRuntnAmnt);}
	/** get 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	public Long  getHlthInsrMnthRuntnAmnt() { return (Long )get( ATTR_HLTHINSRMNTHRUNTNAMNT );}

	/** set 고용보험보수월액 : umytInsrPayMnthAmnt */
	public void setUmytInsrPayMnthAmnt(Long  umytInsrPayMnthAmnt) { set( ATTR_UMYTINSRPAYMNTHAMNT ,umytInsrPayMnthAmnt);}
	/** get 고용보험보수월액 : umytInsrPayMnthAmnt */
	public Long  getUmytInsrPayMnthAmnt() { return (Long )get( ATTR_UMYTINSRPAYMNTHAMNT );}

	/** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
	public void setIdtlAccdtPayMnthAmnt(Long  idtlAccdtPayMnthAmnt) { set( ATTR_IDTLACCDTPAYMNTHAMNT ,idtlAccdtPayMnthAmnt);}
	/** get 산재보험보수월액 : idtlAccdtPayMnthAmnt */
	public Long  getIdtlAccdtPayMnthAmnt() { return (Long )get( ATTR_IDTLACCDTPAYMNTHAMNT );}

	/** set 비고 : note */
	public void setNote(String  note) { set( ATTR_NOTE ,note);}
	/** get 비고 : note */
	public String  getNote() { return (String )get( ATTR_NOTE );}

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
