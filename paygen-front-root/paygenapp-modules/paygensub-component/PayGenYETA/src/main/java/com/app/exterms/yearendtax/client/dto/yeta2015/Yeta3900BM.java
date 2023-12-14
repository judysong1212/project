package com.app.exterms.yearendtax.client.dto.yeta2015;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Yeta3900BM extends MSFSimpleBaseModel implements IsSerializable{
	private static final long serialVersionUID = 1L;

	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 지급년월 : pymtYrMnth */
	public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

	/** set 급여구분코드 : payCd */
	public static final String ATTR_PAYCD = "payCd";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";


	/** set 급여항목코드 : payItemCd */
	public static final String ATTR_PAYITEMCD = "payItemCd";

	/** set 급여항목일련번호 : payItemSeilNum */
	public static final String ATTR_PAYITEMSEILNUM = "payItemSeilNum";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 지급공제구분코드 : pymtDducDivCd */
	public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";

	/** set 지급공제금액 : pymtDducSum */
	public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

	/** set 지급공제과세금액 : pymtDducTxtnAmnt */
	public static final String ATTR_PYMTDDUCTXTNAMNT = "pymtDducTxtnAmnt";

	/** set 지급공제비과세금액 : pymtDducFreeDtySum */
	public static final String ATTR_PYMTDDUCFREEDTYSUM = "pymtDducFreeDtySum";

	/** set 급여지급일자 : payPymtDt */
	public static final String ATTR_PAYPYMTDT = "payPymtDt";

	/** set 급여항목명 : payItemNm */
	public static final String ATTR_PAYITEMNM = "payItemNm";

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
	 public Yeta3900BM() { super(); } 

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

	/** set 지급년월 : pymtYrMnth */
	public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
	/** get 지급년월 : pymtYrMnth */
	public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}

	/** set 급여구분코드 : payCd */
	public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
	/** get 급여구분코드 : payCd */
	public String  getPayCd() { return (String )get( ATTR_PAYCD );}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

	/** set 급여항목코드 : payItemCd */
	public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
	/** get 급여항목코드 : payItemCd */
	public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

	/** set 급여항목일련번호 : payItemSeilNum */
	public void setPayItemSeilNum(BigDecimal  payItemSeilNum) { set( ATTR_PAYITEMSEILNUM ,payItemSeilNum);}
	/** get 급여항목일련번호 : payItemSeilNum */
	public BigDecimal  getPayItemSeilNum() { return (BigDecimal )get( ATTR_PAYITEMSEILNUM );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 지급공제구분코드 : pymtDducDivCd */
	public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
	/** get 지급공제구분코드 : pymtDducDivCd */
	public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}

	/** set 지급공제금액 : pymtDducSum */
	public void setPymtDducSum(BigDecimal  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
	/** get 지급공제금액 : pymtDducSum */
	public BigDecimal  getPymtDducSum() { return (BigDecimal )get( ATTR_PYMTDDUCSUM );}

	/** set 지급공제과세금액 : pymtDducTxtnAmnt */
	public void setPymtDducTxtnAmnt(BigDecimal  pymtDducTxtnAmnt) { set( ATTR_PYMTDDUCTXTNAMNT ,pymtDducTxtnAmnt);}
	/** get 지급공제과세금액 : pymtDducTxtnAmnt */
	public BigDecimal  getPymtDducTxtnAmnt() { return (BigDecimal )get( ATTR_PYMTDDUCTXTNAMNT );}

	/** set 지급공제비과세금액 : pymtDducFreeDtySum */
	public void setPymtDducFreeDtySum(BigDecimal  pymtDducFreeDtySum) { set( ATTR_PYMTDDUCFREEDTYSUM ,pymtDducFreeDtySum);}
	/** get 지급공제비과세금액 : pymtDducFreeDtySum */
	public BigDecimal  getPymtDducFreeDtySum() { return (BigDecimal )get( ATTR_PYMTDDUCFREEDTYSUM );}

	/** set 급여지급일자 : payPymtDt */
	public void setPayPymtDt(String  payPymtDt) { set( ATTR_PAYPYMTDT ,payPymtDt);}
	/** get 급여지급일자 : payPymtDt */
	public String  getPayPymtDt() { return (String )get( ATTR_PAYPYMTDT );}

	/** set 급여항목명 : payItemNm */
	public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
	/** get 급여항목명 : payItemNm */
	public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}

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

    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
}