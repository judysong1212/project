package com.app.exterms.payroll.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0307VO.java
 * @Description : Payr0307 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0307DTO_XLS  extends BaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    
    /** set 순번 : rnum */
    public void setRnum(String  rnum) { set( "rnum" ,rnum);}
    /** get 순번 : rnum */
    public String  getRnum() { return (String )get( "rnum" );}
    
    
    /** set 데이터체크 : dataChk */
    public void setDataChk(String  dataChk) { set( "dataChk" ,dataChk);}
    /** get 데이터체크 : dataChk */
    public String  getDataChk() { return (String )get( "dataChk" );}
    
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( "dpobCd" ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( "dpobCd" );}
    
    /** set 지급년월 : pymtYrMnth */
    public void setPymtYrMnth(String  pymtYrMnth) { set( "pymtYrMnth" ,pymtYrMnth);}
    /** get 지급년월 : pymtYrMnth */
    public String  getPymtYrMnth() { return (String )get( "pymtYrMnth" );}
    
    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( "payCd" ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( "payCd" );}
    
    /** set 급여구분코드 : payCdNm */
    public void setPayCdNm(String  payCdNm) { set( "payCdNm" ,payCdNm);}
    /** get 급여구분코드 : payCdNm */
    public String  getPayCdNm() { return (String )get( "payCdNm" );}
    
    /** set 급여일련번호 : payrSeilNum */
    public void setPayrSeilNum(Long  payrSeilNum) { set( "payrSeilNum" ,payrSeilNum);}
    /** get 급여일련번호 : payrSeilNum */
    public Long  getPayrSeilNum() { return (Long )get( "payrSeilNum" );}
    
    /** set 성명 : hanNm */
    public void setHanNm(String  hanNm) { set( "hanNm" ,hanNm);}
    /** get 성명 : hanNm */
    public String  getHanNm() { return (String )get( "hanNm" );}
    
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String resnRegnNum) { set("resnRegnNum",resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String getResnRegnNum() { return (String)get("resnRegnNum");}
    
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( "systemkey" ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( "systemkey" );}
    
	/** set 부서코드 : deptCd */
	public void setDeptCd(String deptCd) { set("deptCd",deptCd);}
	/** get 부서코드 : deptCd */
	public String getDeptCd() { return (String)get("deptCd");}
	
	/** set 부서코드 : deptCdNm */
	public void setDeptCdNm(String deptCdNm) { set("deptCdNm",deptCdNm);}
	/** get 부서코드 : deptCdNm */
	public String getDeptCdNm() { return (String)get("deptCdNm");}
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String dtilOccuInttnCd) { set("dtilOccuInttnCd",dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String getDtilOccuInttnCd() { return (String)get("dtilOccuInttnCd");}
	
	/** set 직종세통합코드 : dtilOccuInttnCdNm */
	public void setDtilOccuInttnCdNm(String dtilOccuInttnCdNm) { set("dtilOccuInttnCdNm",dtilOccuInttnCdNm);}
	/** get 직종세통합코드 : dtilOccuInttnCdNm */
	public String getDtilOccuInttnCdNm() { return (String)get("dtilOccuInttnCdNm");}
	
	/** set 사업코드 : businCd */
	public void setBusinCd(String businCd) { set("businCd",businCd);}
	/** get 사업코드 : businCd */
	public String getBusinCd() { return (String)get("businCd");}
	
	/** set 사업코드 : businCdNm */
	public void setBusinCdNm(String businCdNm) { set("businCdNm",businCdNm);}
	/** get 사업코드 : businCd */
	public String getBusinCdNm() { return (String)get("businCdNm");}
    
    
    /** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
    public void setMnthPayAdmntSeilNum(Long  mnthPayAdmntSeilNum) { set( "mnthPayAdmntSeilNum" ,mnthPayAdmntSeilNum);}
    /** get 월급여조정일련번호 : mnthPayAdmntSeilNum */
    public Long  getMnthPayAdmntSeilNum() { return (Long )get( "mnthPayAdmntSeilNum" );}
    
    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( "payItemCd" ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( "payItemCd" );}
    
    
    /** set 급여항목코드 : payItemCdNm */
    public void setPayItemCdNm(String  payItemCdNm) { set( "payItemCdNm" ,payItemCdNm);}
    /** get 급여항목코드 : payItemCdNm */
    public String  getPayItemCdNm() { return (String )get( "payItemCdNm" );}
    
    
    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( "pymtDducDivCd" ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( "pymtDducDivCd" );}
    
    /** set 지급공제구분코드 : pymtDducDivCdNm */
    public void setPymtDducDivCdNm(String  pymtDducDivCdNm) { set( "pymtDducDivCdNm" ,pymtDducDivCdNm);}
    /** get 지급공제구분코드 : pymtDducDivCdNm */
    public String  getPymtDducDivCdNm() { return (String )get( "pymtDducDivCdNm" );}
    
    /** set 지급공제금액 : pymtDducSum */
    public void setPymtDducSum(Double  pymtDducSum) { set( "pymtDducSum" ,pymtDducSum);}
    /** get 지급공제금액 : pymtDducSum */
    public Double  getPymtDducSum() { return (Double )get( "pymtDducSum" );}
    
    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    public void setPymtDducFreeDtySum(Double  pymtDducFreeDtySum) { set( "pymtDducFreeDtySum" ,pymtDducFreeDtySum);}
    /** get 지급공제비과세금액 : pymtDducFreeDtySum */
    public Double  getPymtDducFreeDtySum() { return (Double )get( "pymtDducFreeDtySum" );}
    
    /** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
    public void setMnthPayAdmntAssoBssCtnt(String  mnthPayAdmntAssoBssCtnt) { set( "mnthPayAdmntAssoBssCtnt" ,mnthPayAdmntAssoBssCtnt);}
    /** get 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
    public String  getMnthPayAdmntAssoBssCtnt() { return (String )get( "mnthPayAdmntAssoBssCtnt" );}
    
    /** set 월급여소급조정여부 : mnthPayAdmntYn */
    public void setMnthPayAdmntYn(String  mnthPayAdmntYn) { set( "mnthPayAdmntYn" ,mnthPayAdmntYn);}
    /** get 월급여소급조정여부 : mnthPayAdmntYn */
    public String  getMnthPayAdmntYn() { return (String )get( "mnthPayAdmntYn" );}
    
//    /** set 입력자 : kybdr */
//    public void setKybdr(String  kybdr) { set( KYBDR ,kybdr);}
//    /** get 입력자 : kybdr */
//    public String  getKybdr() { return (String )get( KYBDR );}
//    /** set 입력일자 : inptDt */
//    public void setInptDt(String  inptDt) { set( INPTDT ,inptDt);}
//    /** get 입력일자 : inptDt */
//    public String  getInptDt() { return (String )get( INPTDT );}
//    /** set 입력주소 : inptAddr */
//    public void setInptAddr(String  inptAddr) { set( INPTADDR ,inptAddr);}
//    /** get 입력주소 : inptAddr */
//    public String  getInptAddr() { return (String )get( INPTADDR );}
//    /** set 수정자 : ismt */
//    public void setIsmt(String  ismt) { set( ISMT ,ismt);}
//    /** get 수정자 : ismt */
//    public String  getIsmt() { return (String )get( ISMT );}
//    /** set 수정일자 : revnDt */
//    public void setRevnDt(String  revnDt) { set( REVNDT ,revnDt);}
//    /** get 수정일자 : revnDt */
//    public String  getRevnDt() { return (String )get( REVNDT );}
//    /** set 수정주소 : revnAddr */
//    public void setRevnAddr(String  revnAddr) { set( REVNADDR ,revnAddr);}
//    /** get 수정주소 : revnAddr */
//    public String  getRevnAddr() { return (String )get( REVNADDR );}
    
    
    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    public void setPymtDducTxtnAmnt(Double  pymtDducTxtnAmnt) { set( "pymtDducTxtnAmnt" ,pymtDducTxtnAmnt);}
    /** get 지급공제과세금액 : pymtDducTxtnAmnt */
    public Double  getPymtDducTxtnAmnt() { return (Double )get( "pymtDducTxtnAmnt" );}
    
}
