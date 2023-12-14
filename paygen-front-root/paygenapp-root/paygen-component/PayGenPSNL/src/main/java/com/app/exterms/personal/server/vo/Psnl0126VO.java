package com.app.exterms.personal.server.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
public class Psnl0126VO implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YOOBH_MNTH_DAY */
    private java.lang.String yoobhMnthDay;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** HODY_APPTN_YR */
    private java.lang.String hodyApptnYr;
    
    /** HODY_NUM_DYS_SYS_CALC */
    private java.lang.String hodyNumDysSysCalc;
    
    /** HODY_APPTN_NUM_DYS */
    private java.lang.String hodyApptnNumDys;
    
    /** HODY_USE_NUM_DYS */
    private java.lang.String hodyUseNumDys;
    
    /** HODY_RST_NUM_DYS */
    private java.lang.String hodyRstNumDys;
    
    /** HODY_BGNN_DT */
    private java.lang.String hodyBgnnDt;
    
    /** HODY_END_DT */
    private java.lang.String hodyEndDt;
    
    /** HODY_NOTE_CTNT */
    private java.lang.String hodyNoteCtnt;
    
    /** HODY_FIX_YN */
    private java.lang.String hodyFixYn;
    
    /** HODY_FIX_DT */
    private java.lang.String hodyFixDt;
    
    /** LVSG_COPTN_CST_APPTN_YN */
    private java.lang.String lvsgCoptnCstApptnYn;
    
    /** LVSG_COPTN_CST_APPTN_DT */
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
    
    /** set 특별휴가일수 : spclHodyNumDys */
    private java.lang.String spclHodyNumDys;
    
    /** set 특별휴가사용일수 : spclHodyUseDys */
    private java.lang.String spclHodyUseDys;
    
    private java.lang.String resnRegnGbn;
    
    
    public java.lang.String getSpclHodyNumDys() {
		return spclHodyNumDys;
	}

	public void setSpclHodyNumDys(java.lang.String spclHodyNumDys) {
		this.spclHodyNumDys = spclHodyNumDys;
	}

	public java.lang.String getHodyApptnYr() {
        return this.hodyApptnYr;
    }
    
    public void setHodyApptnYr(java.lang.String hodyApptnYr) {
        this.hodyApptnYr = hodyApptnYr;
    }
    
    public java.lang.String getHodyNumDysSysCalc() {
        return this.hodyNumDysSysCalc;
    }
    
    public void setHodyNumDysSysCalc(java.lang.String hodyNumDysSysCalc) {
        this.hodyNumDysSysCalc = hodyNumDysSysCalc;
    }
    
    public java.lang.String getHodyApptnNumDys() {
        return this.hodyApptnNumDys;
    }
    
    public void setHodyApptnNumDys(java.lang.String hodyApptnNumDys) {
        this.hodyApptnNumDys = hodyApptnNumDys;
    }
    
    public java.lang.String getHodyUseNumDys() {
        return this.hodyUseNumDys;
    }
    
    public void setHodyUseNumDys(java.lang.String hodyUseNumDys) {
        this.hodyUseNumDys = hodyUseNumDys;
    }
    
    public java.lang.String getHodyRstNumDys() {
        return this.hodyRstNumDys;
    }
    
    public void setHodyRstNumDys(java.lang.String hodyRstNumDys) {
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
    
    public java.lang.String getHodyFixYn() {
        return this.hodyFixYn;
    }
    
    public void setHodyFixYn(java.lang.String hodyFixYn) {
        this.hodyFixYn = hodyFixYn;
    }
    
    public java.lang.String getLvsgCoptnCstApptnYn() {
        return this.lvsgCoptnCstApptnYn;
    }
    
    public void setLvsgCoptnCstApptnYn(java.lang.String lvsgCoptnCstApptnYn) {
        this.lvsgCoptnCstApptnYn = lvsgCoptnCstApptnYn;
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
    
    public java.lang.String getHodyFixDt() {
        return this.hodyFixDt;
    }
    
    public void setHodyFixDt(java.lang.String hodyFixDt) {
        this.hodyFixDt = hodyFixDt;
    }
    
    
    //----PSNL2100
    /** set 휴가일수 : hodyNumDys */
	private java.math.BigDecimal hodyNumDys;
	
	public java.math.BigDecimal getHodyNumDys() {
		return hodyNumDys;
	}

	public void setHodyNumDys(java.math.BigDecimal hodyNumDys) {
		this.hodyNumDys = hodyNumDys;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

    
    //---- 리스트..?
//    public List<Psnl0126VO> psnl0126List = new ArrayList<Psnl0126VO>();
//
//	public List<Psnl0126VO> getPsnl0126List() {
//		return psnl0126List;
//	}
//
//	public void setPsnl0126List(List<Psnl0126VO> psnl0126List) {
//		this.psnl0126List = psnl0126List;
//	}
	
	public java.lang.String getSpclHodyUseDys() {
		return spclHodyUseDys;
	}

	public void setSpclHodyUseDys(java.lang.String spclHodyUseDys) {
		this.spclHodyUseDys = spclHodyUseDys;
	}

	public MultipartFile file;
	
	public MultipartFile getFile() {
        return file;
    }
 
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    //---- PSNL0100
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    /** set 부서코드 : deptNm */
    private java.lang.String deptNm;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    
    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;
    

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

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getLogSvcYrNumCd() {
		return logSvcYrNumCd;
	}

	public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
		this.logSvcYrNumCd = logSvcYrNumCd;
	}
	
    private List<Psnl0126VO> psnl0126List = new ArrayList<Psnl0126VO>();

	public List<Psnl0126VO> getPsnl0126List() {
		return psnl0126List;
	}

	public void setPsnl0126List(List<Psnl0126VO> psnl0126List) {
		this.psnl0126List = psnl0126List;
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

	public java.lang.String getResnRegnGbn() {
		return resnRegnGbn;
	}

	public void setResnRegnGbn(java.lang.String resnRegnGbn) {
		this.resnRegnGbn = resnRegnGbn;
	}
    
    
    
}
