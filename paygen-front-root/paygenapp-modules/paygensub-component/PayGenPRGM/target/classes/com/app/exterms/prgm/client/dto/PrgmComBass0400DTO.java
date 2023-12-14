package com.app.exterms.prgm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bass0400VO.java
 * @Description : Bass0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PrgmComBass0400DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
     
    /** set 부서코드 : deptCd */
    private java.lang.String deptNm;

    /** set 부서명_한글 : deptNmHan */
    private java.lang.String deptNmHan;

    /** set 부서명_단축 : deptNmRtchnt */
    private java.lang.String deptNmRtchnt;

    /** set 부서명_영문 : deptNmEng */
    private java.lang.String deptNmEng;

    /** set 최상위부서코드 : tplvlDeptCd */
    private java.lang.String tplvlDeptCd;

    /** set 상위부서코드 : hhrkDeptCd */
    private java.lang.String hhrkDeptCd;

    /** set null : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 부서사용여부 : deptUseYn */
    private java.lang.String deptUseYn;

    /** set 국민연금기호 : natPennSym */
    private java.lang.String natPennSym;

    /** set 건강보험기호 : hlthInsrSym */
    private java.lang.String hlthInsrSym;

    /** set 고용보험기호 : umytInsrSym */
    private java.lang.String umytInsrSym;

    /** set 산재보험기호 : idtlAccdtInsurSym */
    private java.lang.String idtlAccdtInsurSym;

    /** set 부서비고내용 : deptNoteCtnt */
    private java.lang.String deptNoteCtnt;

    /** set 부서출력여부 : deptDspyYn */
    private java.lang.String deptDspyYn;

    /** set 관리부서코드 : mangeDeptCd */
    private java.lang.String mangeDeptCd;
   
    /** set 관리부서 : mangeDeptNm */
    private java.lang.String mangeDeptNm;
    

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

    /** set 수정자주소 : revnAddr */
    private java.lang.String revnAddr;

    /** set 부서순서 : deptRank */
    private java.lang.String deptRank;

    /** 사용여부 표현    */
    private java.lang.String typOccuUseYn;
    
     
    
    public PrgmComBass0400DTO() {
    }
    
    
     
    /**
	 * Comment : 
	 * @fn java.lang.String getMangeDeptNm()
	 * @brief date:2018 2018. 3. 15. user:atres
	 * @return the mangeDeptNm get
	 */
	public java.lang.String getMangeDeptNm() {
		return mangeDeptNm;
	}



	/**
	 * Comment : 
	 *@fn void setMangeDeptNm(java.lang.String mangeDeptNm)
	 *@brief date:2018 2018. 3. 15. user:atres
	 *@param mangeDeptNm the mangeDeptNm to set
	 */
	public void setMangeDeptNm(java.lang.String mangeDeptNm) {
		this.mangeDeptNm = mangeDeptNm;
	}



	/**
	 * Comment : 부서코드 사용여부 표시 
	 * @fn java.lang.String getTypOccuUseYn()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the typOccuUseYn get
	 */
	public java.lang.String getTypOccuUseYn() {
		return typOccuUseYn;
	}



	/**
	 * Comment : 부서코드 사용여부 표시 
	 *@fn void setTypOccuUseYn(java.lang.String typOccuUseYn)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param typOccuUseYn the typOccuUseYn to set
	 */
	public void setTypOccuUseYn(java.lang.String typOccuUseYn) {
		this.typOccuUseYn = typOccuUseYn;
	}



	public java.lang.String getDeptNm() {
        return deptNm;
    }



    public void setDeptNm(java.lang.String deptNm) {
        this.deptNm = deptNm;
    }



    public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public java.lang.String getDeptRank() {
        return deptRank;
    }

    public void setDeptRank(java.lang.String deptRank) {
        this.deptRank = deptRank;
    }

    public java.lang.String getDeptDspyYn() {
		return deptDspyYn;
	}

	public void setDeptDspyYn(java.lang.String deptDspyYn) {
		this.deptDspyYn = deptDspyYn;
	}

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}
	
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getDeptNmHan() {
        return this.deptNmHan;
    }
    
    public void setDeptNmHan(java.lang.String deptNmHan) {
        this.deptNmHan = deptNmHan;
    }
    
    public java.lang.String getDeptNmRtchnt() {
        return this.deptNmRtchnt;
    }
    
    public void setDeptNmRtchnt(java.lang.String deptNmRtchnt) {
        this.deptNmRtchnt = deptNmRtchnt;
    }
    
    public java.lang.String getDeptNmEng() {
        return this.deptNmEng;
    }
    
    public void setDeptNmEng(java.lang.String deptNmEng) {
        this.deptNmEng = deptNmEng;
    }
    
    public java.lang.String getTplvlDeptCd() {
        return this.tplvlDeptCd;
    }
    
    public void setTplvlDeptCd(java.lang.String tplvlDeptCd) {
        this.tplvlDeptCd = tplvlDeptCd;
    }
    
    public java.lang.String getHhrkDeptCd() {
        return this.hhrkDeptCd;
    }
    
    public void setHhrkDeptCd(java.lang.String hhrkDeptCd) {
        this.hhrkDeptCd = hhrkDeptCd;
    }
    
    public java.lang.String getDeptUseYn() {
        return this.deptUseYn;
    }
    
    public void setDeptUseYn(java.lang.String deptUseYn) {
        this.deptUseYn = deptUseYn;
    }
    
    public java.lang.String getNatPennSym() {
        return this.natPennSym;
    }
    
    public void setNatPennSym(java.lang.String natPennSym) {
        this.natPennSym = natPennSym;
    }
    
    public java.lang.String getHlthInsrSym() {
        return this.hlthInsrSym;
    }
    
    public void setHlthInsrSym(java.lang.String hlthInsrSym) {
        this.hlthInsrSym = hlthInsrSym;
    }
    
    public java.lang.String getUmytInsrSym() {
        return this.umytInsrSym;
    }
    
    public void setUmytInsrSym(java.lang.String umytInsrSym) {
        this.umytInsrSym = umytInsrSym;
    }
    
    public java.lang.String getIdtlAccdtInsurSym() {
        return this.idtlAccdtInsurSym;
    }
    
    public void setIdtlAccdtInsurSym(java.lang.String idtlAccdtInsurSym) {
        this.idtlAccdtInsurSym = idtlAccdtInsurSym;
    }
    
    public java.lang.String getDeptNoteCtnt() {
        return this.deptNoteCtnt;
    }
    
    public void setDeptNoteCtnt(java.lang.String deptNoteCtnt) {
        this.deptNoteCtnt = deptNoteCtnt;
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
