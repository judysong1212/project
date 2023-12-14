package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr6500VO.java
 * @Description : Insr6500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr6500BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 납부년월 : pymtYrMnth */
	public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

	/** set 고용구분코드 : emymtDivCd */
	public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

	/** set 산재보험상세일련번호 : idtlAccdtInsurDtlPatrNum */
	public static final String ATTR_IDTLACCDTINSURDTLPATRNUM = "idtlAccdtInsurDtlPatrNum";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";

	/** set 사업코드 : businCd */
	public static final String ATTR_BUSINCD = "businCd";

	/** set 산재보험인원수 : idtlAccdtInsrPeplNum */
	public static final String ATTR_IDTLACCDTINSRPEPLNUM = "idtlAccdtInsrPeplNum";

	/** set 보수총금액 : payTotSum */
	public static final String ATTR_PAYTOTSUM = "payTotSum";

	/** set 산재보험요율 : idtlAccdtInsurApmrt */
	public static final String ATTR_IDTLACCDTINSURAPMRT = "idtlAccdtInsurApmrt";

	/** set 산재보험납부금액 : idtlAccdtInsurPymtSum */
	public static final String ATTR_IDTLACCDTINSURPYMTSUM = "idtlAccdtInsurPymtSum";

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
	 public Insr6500BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr6500BM(
			 String  dpobCd 
			, String  pymtYrMnth 
			, String  emymtDivCd 
			, Long  idtlAccdtInsurDtlPatrNum 
			, String  deptCd 
			, String  businCd 
			, Long  idtlAccdtInsrPeplNum 
			, Long  payTotSum 
			, Long  idtlAccdtInsurApmrt 
			, Long  idtlAccdtInsurPymtSum 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
	 	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
	 	values.put(ATTR_IDTLACCDTINSURDTLPATRNUM,idtlAccdtInsurDtlPatrNum);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_BUSINCD,businCd);
	 	values.put(ATTR_IDTLACCDTINSRPEPLNUM,idtlAccdtInsrPeplNum);
	 	values.put(ATTR_PAYTOTSUM,payTotSum);
	 	values.put(ATTR_IDTLACCDTINSURAPMRT,idtlAccdtInsurApmrt);
	 	values.put(ATTR_IDTLACCDTINSURPYMTSUM,idtlAccdtInsurPymtSum);
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

	/** set 납부년월 : pymtYrMnth */
	public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
	/** get 납부년월 : pymtYrMnth */
	public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}

	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

	/** set 산재보험상세일련번호 : idtlAccdtInsurDtlPatrNum */
	public void setIdtlAccdtInsurDtlPatrNum(Long  idtlAccdtInsurDtlPatrNum) { set( ATTR_IDTLACCDTINSURDTLPATRNUM ,idtlAccdtInsurDtlPatrNum);}
	/** get 산재보험상세일련번호 : idtlAccdtInsurDtlPatrNum */
	public Long  getIdtlAccdtInsurDtlPatrNum() { return (Long )get( ATTR_IDTLACCDTINSURDTLPATRNUM );}

	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

	/** set 사업코드 : businCd */
	public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
	/** get 사업코드 : businCd */
	public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

	/** set 산재보험인원수 : idtlAccdtInsrPeplNum */
	public void setIdtlAccdtInsrPeplNum(Long  idtlAccdtInsrPeplNum) { set( ATTR_IDTLACCDTINSRPEPLNUM ,idtlAccdtInsrPeplNum);}
	/** get 산재보험인원수 : idtlAccdtInsrPeplNum */
	public Long  getIdtlAccdtInsrPeplNum() { return (Long )get( ATTR_IDTLACCDTINSRPEPLNUM );}

	/** set 보수총금액 : payTotSum */
	public void setPayTotSum(Long  payTotSum) { set( ATTR_PAYTOTSUM ,payTotSum);}
	/** get 보수총금액 : payTotSum */
	public Long  getPayTotSum() { return (Long )get( ATTR_PAYTOTSUM );}

	/** set 산재보험요율 : idtlAccdtInsurApmrt */
	public void setIdtlAccdtInsurApmrt(Long  idtlAccdtInsurApmrt) { set( ATTR_IDTLACCDTINSURAPMRT ,idtlAccdtInsurApmrt);}
	/** get 산재보험요율 : idtlAccdtInsurApmrt */
	public Long  getIdtlAccdtInsurApmrt() { return (Long )get( ATTR_IDTLACCDTINSURAPMRT );}

	/** set 산재보험납부금액 : idtlAccdtInsurPymtSum */
	public void setIdtlAccdtInsurPymtSum(Long  idtlAccdtInsurPymtSum) { set( ATTR_IDTLACCDTINSURPYMTSUM ,idtlAccdtInsurPymtSum);}
	/** get 산재보험납부금액 : idtlAccdtInsurPymtSum */
	public Long  getIdtlAccdtInsurPymtSum() { return (Long )get( ATTR_IDTLACCDTINSURPYMTSUM );}

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
