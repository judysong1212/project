package com.app.exterms.insurance.server.vo;

import java.math.BigDecimal;

/**
 * @Class Name : Insr4300VO.java
 * @Description : Insr4300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4300VO extends Insr4300SrhVO{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 국민연금일련번호 : natPennSeilNum */
  //  private java.math.BigDecimal natPennSeilNum;

    /** set 고용일련번호 : emymtSeilNum */
  	private Long  emymtSeilNum;

  	
    /** set 연금결정년도 : antyDeinYr */
    private java.lang.String antyDeinYr;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set 연금총근무일수 : antyTotDutyNumDys */
    private java.math.BigDecimal antyTotDutyNumDys;

    /** set 연금소득총액 : antyIncmTotAmnt */
    private java.math.BigDecimal antyIncmTotAmnt;

    /** set 연금기준소득월액 : antyStdIncmMnthAmnt */
    private java.math.BigDecimal antyStdIncmMnthAmnt;

    /** set 연금월보험료 : antyMnthPrmm */
    private java.math.BigDecimal antyMnthPrmm;

    /** set 종전기준소득월액 : bfrStdIncmMnthAmnt */
    private java.math.BigDecimal bfrStdIncmMnthAmnt;

    /** set 과세자료결정여부 : txtnDataDeinYn */
    private java.lang.String txtnDataDeinYn;

    /** set 공단직권결정여부 : pbcorpOautyDeinYn */
    private java.lang.String pbcorpOautyDeinYn;

    /** set 연금급여반영여부 : antyPayRflctnYn */
    private java.lang.String antyPayRflctnYn;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

   
	/** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;


    /** 연금취득일자 NAT_PENN_AQTN_DT */
    private java.lang.String natPennAqtnDt;
     

    /** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
    private BigDecimal  natPennStdIncmMnthAmnt;

    /** set 국민연금등급 : natPennGrde */
    private String  natPennGrde;

    /** 국민연금급여적용년월 NAT_APPTN_YR_MNTH */
    private java.lang.String natApptnYrMnth;
    
    /** 국민연금급여적용일자 NAT_PRCS_DT */
    private java.lang.String natPrcsDt;
    
    /** 국민연금급여처리여부 NAT_PRCS_YN */
    private java.lang.String natPrcsYn;
    
    
    public BigDecimal getNatPennStdIncmMnthAmnt() {
		return natPennStdIncmMnthAmnt;
	}

	public void setNatPennStdIncmMnthAmnt(BigDecimal natPennStdIncmMnthAmnt) {
		this.natPennStdIncmMnthAmnt = natPennStdIncmMnthAmnt;
	}

	public String getNatPennGrde() {
		return natPennGrde;
	}

	public void setNatPennGrde(String natPennGrde) {
		this.natPennGrde = natPennGrde;
	}

	public java.lang.String getNatApptnYrMnth() {
		return natApptnYrMnth;
	}

	public void setNatApptnYrMnth(java.lang.String natApptnYrMnth) {
		this.natApptnYrMnth = natApptnYrMnth;
	}

	public java.lang.String getNatPrcsDt() {
		return natPrcsDt;
	}

	public void setNatPrcsDt(java.lang.String natPrcsDt) {
		this.natPrcsDt = natPrcsDt;
	}

	public java.lang.String getNatPrcsYn() {
		return natPrcsYn;
	}

	public void setNatPrcsYn(java.lang.String natPrcsYn) {
		this.natPrcsYn = natPrcsYn;
	}

	public java.lang.String getNatPennAqtnDt() {
		return natPennAqtnDt;
	}

	public void setNatPennAqtnDt(java.lang.String natPennAqtnDt) {
		this.natPennAqtnDt = natPennAqtnDt;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
//    public java.math.BigDecimal getNatPennSeilNum() {
//        return this.natPennSeilNum;
//    }
//    
//    public void setNatPennSeilNum(java.math.BigDecimal natPennSeilNum) {
//        this.natPennSeilNum = natPennSeilNum;
//    }
    
//    
    public java.lang.String getAntyDeinYr() {
        return this.antyDeinYr;
    }
    
    /**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public Long getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(Long emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public void setAntyDeinYr(java.lang.String antyDeinYr) {
        this.antyDeinYr = antyDeinYr;
    }
    
    public java.math.BigDecimal getAntyTotDutyNumDys() {
        return this.antyTotDutyNumDys;
    }
    
    public void setAntyTotDutyNumDys(java.math.BigDecimal antyTotDutyNumDys) {
        this.antyTotDutyNumDys = antyTotDutyNumDys;
    }
    
    public java.math.BigDecimal getAntyIncmTotAmnt() {
        return this.antyIncmTotAmnt;
    }
    
    public void setAntyIncmTotAmnt(java.math.BigDecimal antyIncmTotAmnt) {
        this.antyIncmTotAmnt = antyIncmTotAmnt;
    }
    
    public java.math.BigDecimal getAntyStdIncmMnthAmnt() {
        return this.antyStdIncmMnthAmnt;
    }
    
    public void setAntyStdIncmMnthAmnt(java.math.BigDecimal antyStdIncmMnthAmnt) {
        this.antyStdIncmMnthAmnt = antyStdIncmMnthAmnt;
    }
    
    public java.math.BigDecimal getAntyMnthPrmm() {
        return this.antyMnthPrmm;
    }
    
    public void setAntyMnthPrmm(java.math.BigDecimal antyMnthPrmm) {
        this.antyMnthPrmm = antyMnthPrmm;
    }
    
    public java.math.BigDecimal getBfrStdIncmMnthAmnt() {
        return this.bfrStdIncmMnthAmnt;
    }
    
    public void setBfrStdIncmMnthAmnt(java.math.BigDecimal bfrStdIncmMnthAmnt) {
        this.bfrStdIncmMnthAmnt = bfrStdIncmMnthAmnt;
    }
    
    public java.lang.String getTxtnDataDeinYn() {
        return this.txtnDataDeinYn;
    }
    
    public void setTxtnDataDeinYn(java.lang.String txtnDataDeinYn) {
        this.txtnDataDeinYn = txtnDataDeinYn;
    }
    
    public java.lang.String getPbcorpOautyDeinYn() {
        return this.pbcorpOautyDeinYn;
    }
    
    public void setPbcorpOautyDeinYn(java.lang.String pbcorpOautyDeinYn) {
        this.pbcorpOautyDeinYn = pbcorpOautyDeinYn;
    }
    
    public java.lang.String getAntyPayRflctnYn() {
        return this.antyPayRflctnYn;
    }
    
    public void setAntyPayRflctnYn(java.lang.String antyPayRflctnYn) {
        this.antyPayRflctnYn = antyPayRflctnYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
}
