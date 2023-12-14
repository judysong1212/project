package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr3000VO.java
 * @Description : Insr3000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3000VO implements Serializable {
    private static final long serialVersionUID = 1L;
     

    /** set 사업장코드 : dpobCd */
	private String  dpobCd;

	/** set SYSTEMKEY : systemkey */
	private String  systemkey;

 
	/** set 고용일련번호 : emymtSeilNum */
	private BigDecimal  emymtSeilNum;

	/** set 사대보험공제방식코드 : socInsrDducEthdCd */
	private String  socInsrDducEthdCd; 

	/** set 사대보험공제방식 : socInsrDducEthdNm */
	private String  socInsrDducEthdNm;

	/** set 건강보험취득일자 : hlthInsrAqtnDt */
	private String  hlthInsrAqtnDt;

	/** set 건강보험상실일자 : hlthInsrLssDt */
	private String  hlthInsrLssDt;

	/** set 입력자 : kybdr */
	private String  kybdr;

	/** set 입력일자 : inptDt */
	private String  inptDt;

	/** set 입력주소 : inptAddr */
	private String  inptAddr;

	/** set 수정자 : ismt */
	private String  ismt;

	/** set 수정일자 : revnDt */
	private String  revnDt;

	/** set 수정주소 : revnAddr */
	private String  revnAddr;
	

    /** set 고용구분코드 : emymtDivCd */
    private String  emymtDivCd;

    /** set 부서코드 : deptCd */
    private String  deptCd;

    /** set 사업코드 : businCd */
    private String  businCd;

    /** set 직종코드 : typOccuCd */
    private String  typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private String  dtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private String  pyspGrdeCd;
 

    /** set 단위기관코드 : payrMangDeptCd */
    private String  payrMangDeptCd;
    

    /** set 단위기관 : payrMangDeptNm */
    private String  payrMangDeptNm;
    
    /** set 고용구분 : emymtDivNm */
    private String  emymtDivNm;

    /** set 부서 : deptNm */
    private String  deptNm;

    /** set 사업명 : businNm */
    private String  businNm;
    
    /** set 직종명 : typOccuNm */
    private String  typOccuNm;
    
    /** set 직종세 : dtilOccuClsDivNm */
    private String  dtilOccuClsDivNm;
    
    /** set 직책코드 : odtyNm */
    private String  odtyNm;

 
    /** set 호봉등급코드 : pyspGrdeNm */
    private String  pyspGrdeNm;
    

    /** set 한글성명 : hanNm */
    private String  hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private String  resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** set 예외처리지급금액 -건강보험 : exptnPrcsPymtSum01 */
    private BigDecimal  exptnPrcsPymtSum01;

    /** set 예외처리지급비율 -건강보험 : exptnPrcsPymtRto01 */
    private BigDecimal  exptnPrcsPymtRto01;
    
    
    /** set 예외처리지급금액 -장기요양보험 : exptnPrcsPymtSum02 */
    private BigDecimal  exptnPrcsPymtSum02;

    /** set 예외처리지급비율 -장기요양보험 : exptnPrcsPymtRto02 */
    private BigDecimal  exptnPrcsPymtRto02;
    
 
    /** set 연금보험료 : pymtDducD0010100 */
    private BigDecimal  pymtDducD0010100;

    /** set 정산보험료 : pymtDducD0010200 */
    private BigDecimal  pymtDducD0010200;

    /** set 소급보험료 : pymtDducD0010300 */
    private BigDecimal  pymtDducD0010300;
        
    /** set 휴직자분할보험료 : pymtDducD0010400 */
    private BigDecimal  pymtDducD0010400;

    /** set 건강보험환급금이자 : pymtDducD0010500 */
    private BigDecimal  pymtDducD0010500;  
    

 
/** set 노인장기요양보험 : pymtDducD0110100 */
private BigDecimal  pymtDducD0110100;

/** set 장기요양보험연말정산 : pymtDducD0110200 */
private BigDecimal  pymtDducD0110200;

/** set 노인장기요양보험과미납 : pymtDducD0110300 */
private BigDecimal  pymtDducD0110300;
    
/** set 휴직자분할장기요양보험료 : pymtDducD0110400 */
private BigDecimal  pymtDducD0110400;

/** set 노인장기요양보험환급금이자 : pymtDducD0110500 */
private BigDecimal  pymtDducD0110500; 
    


/** set 합계 : PYMT_DDUC_SUM */
private BigDecimal  pymtSducSum;
    
    

/** set 건강보험변동일자 : hlthInsurFlucDt */
private String  hlthInsurFlucDt;

/** set 건강보험보수총액 : hlthInsrPayTotAmnt */
private BigDecimal  hlthInsrPayTotAmnt;

/** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
private BigDecimal  hlthInsrMnthRuntnAmnt;

/** set 건강보험 : hlthInsrMnthAmnt */
private BigDecimal  hlthInsrMnthAmnt;


/** set 장기요양보험료 : HLTH_RCPTN_MNTH_AMNT */
private BigDecimal  hlthRcptnMnthAmnt;



/** set 건강보험등급 : hlthInsrGrde */
private String  hlthInsrGrde;

/** set 건강보험증번호 : hlthInsrCertNum */
private String  hlthInsrCertNum;
 
/** set 건강보험적용여부 : hlthInsrApptnYn */
private String  hlthInsrApptnYn;

 
	/** set 예외구분코드 : exptnDivCd */
	private String  exptnDivCd;
	
	/** set 예외구분코드 : exptnDivCd01 */
	private String  exptnDivCd01;
	

	/** set 예외구분코드 : exptnDivCd02 */
	private String  exptnDivCd02;
	
	/** set 예외구분코드 : exptnDivNm01 */
	private String  exptnDivNm01;
	

	/** set 예외구분코드 : exptnDivNm02 */
	private String  exptnDivNm02;
	
	/** set 예외구분 : exptnDivNm */
	private String  exptnDivNm;
	
	/** set 지급공제구분코드 : pymtDducDivCd */
	private String  pymtDducDivCd;
	
	
	/** set 지급공제구분 : pymtDducDivNm */
	private String  pymtDducDivNm;
	
	/** set 면제여부 : exmtnYn */
	private String  exmtnYn;
	 
	/** set 급여항목코드 : payItemCd */
	private String  payItemCd;
	
	/** set 예외처리내용 : exptnPrcsNoteCtnt */
	private String  exptnPrcsNoteCtnt; 
	
	   /** set 지급년월 : pymtYrMnth */
    private String  pymtYrMnth;

	public String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(String systemkey) {
		this.systemkey = systemkey;
	}

	 

	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public String getSocInsrDducEthdCd() {
		return socInsrDducEthdCd;
	}

	public void setSocInsrDducEthdCd(String socInsrDducEthdCd) {
		this.socInsrDducEthdCd = socInsrDducEthdCd;
	}

	public String getSocInsrDducEthdNm() {
		return socInsrDducEthdNm;
	}

	public void setSocInsrDducEthdNm(String socInsrDducEthdNm) {
		this.socInsrDducEthdNm = socInsrDducEthdNm;
	}

	public String getHlthInsrAqtnDt() {
		return hlthInsrAqtnDt;
	}

	public void setHlthInsrAqtnDt(String hlthInsrAqtnDt) {
		this.hlthInsrAqtnDt = hlthInsrAqtnDt;
	}

	public String getHlthInsrLssDt() {
		return hlthInsrLssDt;
	}

	public void setHlthInsrLssDt(String hlthInsrLssDt) {
		this.hlthInsrLssDt = hlthInsrLssDt;
	}

	public String getKybdr() {
		return kybdr;
	}

	public void setKybdr(String kybdr) {
		this.kybdr = kybdr;
	}

	public String getInptDt() {
		return inptDt;
	}

	public void setInptDt(String inptDt) {
		this.inptDt = inptDt;
	}

	public String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public String getIsmt() {
		return ismt;
	}

	public void setIsmt(String ismt) {
		this.ismt = ismt;
	}

	public String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(String revnDt) {
		this.revnDt = revnDt;
	}

	public String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(String revnAddr) {
		this.revnAddr = revnAddr;
	}

	public String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(String businCd) {
		this.businCd = businCd;
	}

	public String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public String getPayrMangDeptNm() {
		return payrMangDeptNm;
	}

	public void setPayrMangDeptNm(String payrMangDeptNm) {
		this.payrMangDeptNm = payrMangDeptNm;
	}

	public String getEmymtDivNm() {
		return emymtDivNm;
	}

	public void setEmymtDivNm(String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(String businNm) {
		this.businNm = businNm;
	}

	public String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public String getDtilOccuClsDivNm() {
		return dtilOccuClsDivNm;
	}

	public void setDtilOccuClsDivNm(String dtilOccuClsDivNm) {
		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
	}

	public String getOdtyNm() {
		return odtyNm;
	}

	public void setOdtyNm(String odtyNm) {
		this.odtyNm = odtyNm;
	}

	public String getPyspGrdeNm() {
		return pyspGrdeNm;
	}

	public void setPyspGrdeNm(String pyspGrdeNm) {
		this.pyspGrdeNm = pyspGrdeNm;
	}

	public String getHanNm() {
		return hanNm;
	}

	public void setHanNm(String hanNm) {
		this.hanNm = hanNm;
	}

	public String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public BigDecimal getExptnPrcsPymtSum01() {
		return exptnPrcsPymtSum01;
	}

	public void setExptnPrcsPymtSum01(BigDecimal exptnPrcsPymtSum01) {
		this.exptnPrcsPymtSum01 = exptnPrcsPymtSum01;
	}

	public BigDecimal getExptnPrcsPymtRto01() {
		return exptnPrcsPymtRto01;
	}

	public void setExptnPrcsPymtRto01(BigDecimal exptnPrcsPymtRto01) {
		this.exptnPrcsPymtRto01 = exptnPrcsPymtRto01;
	}

	public BigDecimal getExptnPrcsPymtSum02() {
		return exptnPrcsPymtSum02;
	}

	public void setExptnPrcsPymtSum02(BigDecimal exptnPrcsPymtSum02) {
		this.exptnPrcsPymtSum02 = exptnPrcsPymtSum02;
	}

	public BigDecimal getExptnPrcsPymtRto02() {
		return exptnPrcsPymtRto02;
	}

	public void setExptnPrcsPymtRto02(BigDecimal exptnPrcsPymtRto02) {
		this.exptnPrcsPymtRto02 = exptnPrcsPymtRto02;
	}

	public BigDecimal getPymtDducD0010100() {
		return pymtDducD0010100;
	}

	public void setPymtDducD0010100(BigDecimal pymtDducD0010100) {
		this.pymtDducD0010100 = pymtDducD0010100;
	}

	public BigDecimal getPymtDducD0010200() {
		return pymtDducD0010200;
	}

	public void setPymtDducD0010200(BigDecimal pymtDducD0010200) {
		this.pymtDducD0010200 = pymtDducD0010200;
	}

	public BigDecimal getPymtDducD0010300() {
		return pymtDducD0010300;
	}

	public void setPymtDducD0010300(BigDecimal pymtDducD0010300) {
		this.pymtDducD0010300 = pymtDducD0010300;
	}

	public BigDecimal getPymtDducD0010400() {
		return pymtDducD0010400;
	}

	public void setPymtDducD0010400(BigDecimal pymtDducD0010400) {
		this.pymtDducD0010400 = pymtDducD0010400;
	}

	public BigDecimal getPymtDducD0010500() {
		return pymtDducD0010500;
	}

	public void setPymtDducD0010500(BigDecimal pymtDducD0010500) {
		this.pymtDducD0010500 = pymtDducD0010500;
	}

	public BigDecimal getPymtDducD0110100() {
		return pymtDducD0110100;
	}

	public void setPymtDducD0110100(BigDecimal pymtDducD0110100) {
		this.pymtDducD0110100 = pymtDducD0110100;
	}

	public BigDecimal getPymtDducD0110200() {
		return pymtDducD0110200;
	}

	public void setPymtDducD0110200(BigDecimal pymtDducD0110200) {
		this.pymtDducD0110200 = pymtDducD0110200;
	}

	public BigDecimal getPymtDducD0110300() {
		return pymtDducD0110300;
	}

	public void setPymtDducD0110300(BigDecimal pymtDducD0110300) {
		this.pymtDducD0110300 = pymtDducD0110300;
	}

	public BigDecimal getPymtDducD0110400() {
		return pymtDducD0110400;
	}

	public void setPymtDducD0110400(BigDecimal pymtDducD0110400) {
		this.pymtDducD0110400 = pymtDducD0110400;
	}

	public BigDecimal getPymtDducD0110500() {
		return pymtDducD0110500;
	}

	public void setPymtDducD0110500(BigDecimal pymtDducD0110500) {
		this.pymtDducD0110500 = pymtDducD0110500;
	}

	public BigDecimal getPymtSducSum() {
		return pymtSducSum;
	}

	public void setPymtSducSum(BigDecimal pymtSducSum) {
		this.pymtSducSum = pymtSducSum;
	}

	public String getHlthInsurFlucDt() {
		return hlthInsurFlucDt;
	}

	public void setHlthInsurFlucDt(String hlthInsurFlucDt) {
		this.hlthInsurFlucDt = hlthInsurFlucDt;
	}

	public BigDecimal getHlthInsrPayTotAmnt() {
		return hlthInsrPayTotAmnt;
	}

	public void setHlthInsrPayTotAmnt(BigDecimal hlthInsrPayTotAmnt) {
		this.hlthInsrPayTotAmnt = hlthInsrPayTotAmnt;
	}

	public BigDecimal getHlthInsrMnthRuntnAmnt() {
		return hlthInsrMnthRuntnAmnt;
	}

	public void setHlthInsrMnthRuntnAmnt(BigDecimal hlthInsrMnthRuntnAmnt) {
		this.hlthInsrMnthRuntnAmnt = hlthInsrMnthRuntnAmnt;
	}

	public BigDecimal getHlthInsrMnthAmnt() {
		return hlthInsrMnthAmnt;
	}

	public void setHlthInsrMnthAmnt(BigDecimal hlthInsrMnthAmnt) {
		this.hlthInsrMnthAmnt = hlthInsrMnthAmnt;
	}

	public BigDecimal getHlthRcptnMnthAmnt() {
		return hlthRcptnMnthAmnt;
	}

	public void setHlthRcptnMnthAmnt(BigDecimal hlthRcptnMnthAmnt) {
		this.hlthRcptnMnthAmnt = hlthRcptnMnthAmnt;
	}

	public String getHlthInsrGrde() {
		return hlthInsrGrde;
	}

	public void setHlthInsrGrde(String hlthInsrGrde) {
		this.hlthInsrGrde = hlthInsrGrde;
	}

	public String getHlthInsrCertNum() {
		return hlthInsrCertNum;
	}

	public void setHlthInsrCertNum(String hlthInsrCertNum) {
		this.hlthInsrCertNum = hlthInsrCertNum;
	}

	public String getHlthInsrApptnYn() {
		return hlthInsrApptnYn;
	}

	public void setHlthInsrApptnYn(String hlthInsrApptnYn) {
		this.hlthInsrApptnYn = hlthInsrApptnYn;
	}

	public String getExptnDivCd() {
		return exptnDivCd;
	}

	public void setExptnDivCd(String exptnDivCd) {
		this.exptnDivCd = exptnDivCd;
	}

	public String getExptnDivCd01() {
		return exptnDivCd01;
	}

	public void setExptnDivCd01(String exptnDivCd01) {
		this.exptnDivCd01 = exptnDivCd01;
	}

	public String getExptnDivCd02() {
		return exptnDivCd02;
	}

	public void setExptnDivCd02(String exptnDivCd02) {
		this.exptnDivCd02 = exptnDivCd02;
	}

	public String getExptnDivNm01() {
		return exptnDivNm01;
	}

	public void setExptnDivNm01(String exptnDivNm01) {
		this.exptnDivNm01 = exptnDivNm01;
	}

	public String getExptnDivNm02() {
		return exptnDivNm02;
	}

	public void setExptnDivNm02(String exptnDivNm02) {
		this.exptnDivNm02 = exptnDivNm02;
	}

	public String getExptnDivNm() {
		return exptnDivNm;
	}

	public void setExptnDivNm(String exptnDivNm) {
		this.exptnDivNm = exptnDivNm;
	}

	public String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	public String getPymtDducDivNm() {
		return pymtDducDivNm;
	}

	public void setPymtDducDivNm(String pymtDducDivNm) {
		this.pymtDducDivNm = pymtDducDivNm;
	}

	public String getExmtnYn() {
		return exmtnYn;
	}

	public void setExmtnYn(String exmtnYn) {
		this.exmtnYn = exmtnYn;
	}

	public String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(String payItemCd) {
		this.payItemCd = payItemCd;
	}

	public String getExptnPrcsNoteCtnt() {
		return exptnPrcsNoteCtnt;
	}

	public void setExptnPrcsNoteCtnt(String exptnPrcsNoteCtnt) {
		this.exptnPrcsNoteCtnt = exptnPrcsNoteCtnt;
	}

	public String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}
    
    
    
}
