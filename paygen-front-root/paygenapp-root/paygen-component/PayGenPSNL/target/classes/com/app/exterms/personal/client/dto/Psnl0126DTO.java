package com.app.exterms.personal.client.dto;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Psnl0126VO.java
 * @Description : Psnl0126 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0126DTO extends BaseModel {
    private static final long serialVersionUID = 1L;
    
    /** 사업장 코드 DPOB_CD */
    private java.lang.String dpobCd;
    
    /** 시스템키 SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** 휴가적용년도 HODY_APPTN_YR */
    private java.lang.String hodyApptnYr;
    
    /** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
    private java.lang.String hodyNumDysSysCalc;
    
    /** 휴가적용일수 HODY_APPTN_NUM_DYS */
    private java.lang.Double hodyApptnNumDys;
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;
    
    /** 휴가사용일수 HODY_USE_NUM_DYS */
    private java.lang.Double hodyUseNumDys;
    
    /** 휴가잔여일수 HODY_RST_NUM_DYS */
    private java.lang.Double hodyRstNumDys;
    
    /** 휴가시작일자 HODY_BGNN_DT */
    private java.lang.String hodyBgnnDt;
    
    /** 휴가종료일자 HODY_END_DT */
    private java.lang.String hodyEndDt;
    
    /** 휴가비고내용 HODY_NOTE_CTNT */
    private java.lang.String hodyNoteCtnt;
    
    /** 휴가확정여부 HODY_FIX_YN */
    private Boolean hodyFixYn;
    
    private java.lang.String resnRegnGbn;
    
    /** 휴가확정여부 HODY_FIX_DT */
    private java.lang.String hodyFixDt;
    
    /** set 특별휴가일수 : spclHodyNumDys */
    private java.lang.Double spclHodyNumDys;
    
    /** set 특별휴가사용일수 : spclHodyUseDys */
    private java.lang.Double spclHodyUseDys;
        
    

	public java.lang.Double getSpclHodyUseDys() {
		return spclHodyUseDys;
	}

	public void setSpclHodyUseDys(java.lang.Double spclHodyUseDys) {
		this.spclHodyUseDys = spclHodyUseDys;
	}

	public java.lang.Double getSpclHodyNumDys() {
		return spclHodyNumDys;
	}

	public void setSpclHodyNumDys(java.lang.Double spclHodyNumDys) {
		this.spclHodyNumDys = spclHodyNumDys;
	}

	public java.lang.String getHodyFixDt() {
		return hodyFixDt;
	}

	public void setHodyFixDt(java.lang.String hodyFixDt) {
		this.hodyFixDt = hodyFixDt;
	}

	/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
    private Boolean lvsgCoptnCstApptnYn;
    
    public Boolean getHodyFixYn() {
		return hodyFixYn;
	}

	public void setHodyFixYn(Boolean hodyFixYn) {
		this.hodyFixYn = hodyFixYn;
	}

	public Boolean getLvsgCoptnCstApptnYn() {
		return lvsgCoptnCstApptnYn;
	}

	public void setLvsgCoptnCstApptnYn(Boolean lvsgCoptnCstApptnYn) {
		this.lvsgCoptnCstApptnYn = lvsgCoptnCstApptnYn;
	}

	/** 연가보상비적용일자 LVSG_COPTN_CST_APPTN_DT */
    private java.lang.String lvsgCoptnCstApptnDt;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCd;
    
    /** 부서이름 - DEPT_NM */
    private java.lang.String deptNm;
    
    private java.lang.String hodyNumDysUseYn;
    
    public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
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
    
    public java.lang.String getHodyApptnYr() {
        return this.hodyApptnYr;
    }
    
    public void setHodyApptnYr(java.lang.String hodyApptnYr) {
        this.hodyApptnYr = hodyApptnYr;
    }
    
    public String getHodyNumDysSysCalc() {
        return this.hodyNumDysSysCalc;
    }
    
    public void setHodyNumDysSysCalc(String hodyNumDysSysCalc) {
        this.hodyNumDysSysCalc = hodyNumDysSysCalc;
    }
    
    public Double getHodyApptnNumDys() {
        return this.hodyApptnNumDys;
    }
    
    public void setHodyApptnNumDys(Double hodyApptnNumDys) {
        this.hodyApptnNumDys = hodyApptnNumDys;
    }
    
    public Double getHodyUseNumDys() {
        return this.hodyUseNumDys;
    }
    
    public void setHodyUseNumDys(Double hodyUseNumDys) {
        this.hodyUseNumDys = hodyUseNumDys;
    }
    
    public Double getHodyRstNumDys() {
        return this.hodyRstNumDys;
    }
    
    public void setHodyRstNumDys(Double hodyRstNumDys) {
        this.hodyRstNumDys = hodyRstNumDys;
    }
    
    public java.lang.String getHodyBgnnDt() {
        return this.hodyBgnnDt;
    }
    
    public void setHodyBgnnDt(java.lang.String hodyBgnnDt) {
        this.hodyBgnnDt = hodyBgnnDt;
    }
    
    public java.lang.String getHodyEndDt() {
        return this.hodyEndDt;
    }
    
    public void setHodyEndDt(java.lang.String hodyEndDt) {
        this.hodyEndDt = hodyEndDt;
    }
    
    public java.lang.String getHodyNoteCtnt() {
        return this.hodyNoteCtnt;
    }
    
    public void setHodyNoteCtnt(java.lang.String hodyNoteCtnt) {
        this.hodyNoteCtnt = hodyNoteCtnt;
    }
    
    
    public java.lang.String getLvsgCoptnCstApptnDt() {
        return this.lvsgCoptnCstApptnDt;
    }
    
    public void setLvsgCoptnCstApptnDt(java.lang.String lvsgCoptnCstApptnDt) {
        this.lvsgCoptnCstApptnDt = lvsgCoptnCstApptnDt;
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
    
    
    //PSNL0100
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** YOOBH_MNTH_DAY */
    private java.lang.String yoobhMnthDay;

    
    public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}
    
    
    // PSNL2100
    /** 근속년수에 따른 휴가일수 HODY_NUM_DYS */
    private java.lang.String  hodyNumDys;

	public java.lang.String getHodyNumDys() {
		return hodyNumDys;
	}

	public void setHodyNumDys(java.lang.String hodyNumDys) {
		this.hodyNumDys = hodyNumDys;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	public java.lang.String getYoobhMnthDay() {
		return yoobhMnthDay;
	}

	public void setYoobhMnthDay(java.lang.String yoobhMnthDay) {
		this.yoobhMnthDay = yoobhMnthDay;
	}

	public String getResnRegnGbn() {
		return resnRegnGbn;
	}

	public void setResnRegnGbn(String resnRegnGbn) {
		this.resnRegnGbn = resnRegnGbn;
	}

	public java.lang.String getHodyNumDysUseYn() {
		return hodyNumDysUseYn;
	}

	public void setHodyNumDysUseYn(java.lang.String hodyNumDysUseYn) {
		this.hodyNumDysUseYn = hodyNumDysUseYn;
	}
    
}
