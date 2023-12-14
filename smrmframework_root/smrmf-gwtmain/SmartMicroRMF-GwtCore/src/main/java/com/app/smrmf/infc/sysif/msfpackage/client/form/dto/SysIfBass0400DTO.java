package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.io.Serializable;
import java.util.List;

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
public class SysIfBass0400DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

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

    /** set 단위기관코드 : payrMangDeptCd */
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

    /** set 부서생서일자 : deptCreDt */
    private java.lang.String deptCreDt;

    /** set 부서폐지일자 : deptEndDt */
    private java.lang.String deptEndDt; 
     
    /** set 부서코드 : deptCd */
    private java.lang.String deptNm; 
    

    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** 일자 구분  Y : 년도 / YM :년월 / YMD 일자    */
    private String YmdGb;
    
    /** 일자구분에 따른 넘김값   */
    private String strDate; 
    
    /** 부서코드 - DEPT_CD */
    private List<String> rtnDeptCdArr;
    /** TYP_OCCU_CD */
    private List<String> rtnTypOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값 
     
    private List<String> rtnDtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    
    public SysIfBass0400DTO() {
    } 
     
    
    
    /**
	 * Comment : 
	 * @fn List<String> getRtnDeptCdArr()
	 * @brief date:2017 2017. 1. 25. user:atres-pc
	 * @return the rtnDeptCdArr get
	 */
	public List<String> getRtnDeptCdArr() {
		return rtnDeptCdArr;
	}



	/**
	 * Comment : 
	 *@fn void setRtnDeptCdArr(List<String> rtnDeptCdArr)
	 *@brief date:2017 2017. 1. 25. user:atres-pc
	 *@param rtnDeptCdArr the rtnDeptCdArr to set
	 */
	public void setRtnDeptCdArr(List<String> rtnDeptCdArr) {
		this.rtnDeptCdArr = rtnDeptCdArr;
	}



	/**
	 * Comment : 
	 * @fn List<String> getRtnTypOccuCdArr()
	 * @brief date:2017 2017. 1. 25. user:atres-pc
	 * @return the rtnTypOccuCdArr get
	 */
	public List<String> getRtnTypOccuCdArr() {
		return rtnTypOccuCdArr;
	}



	/**
	 * Comment : 
	 *@fn void setRtnTypOccuCdArr(List<String> rtnTypOccuCdArr)
	 *@brief date:2017 2017. 1. 25. user:atres-pc
	 *@param rtnTypOccuCdArr the rtnTypOccuCdArr to set
	 */
	public void setRtnTypOccuCdArr(List<String> rtnTypOccuCdArr) {
		this.rtnTypOccuCdArr = rtnTypOccuCdArr;
	}



	/**
	 * Comment : 
	 * @fn List<String> getRtnDtilOccuInttnCdArr()
	 * @brief date:2017 2017. 1. 25. user:atres-pc
	 * @return the rtnDtilOccuInttnCdArr get
	 */
	public List<String> getRtnDtilOccuInttnCdArr() {
		return rtnDtilOccuInttnCdArr;
	}



	/**
	 * Comment : 
	 *@fn void setRtnDtilOccuInttnCdArr(List<String> rtnDtilOccuInttnCdArr)
	 *@brief date:2017 2017. 1. 25. user:atres-pc
	 *@param rtnDtilOccuInttnCdArr the rtnDtilOccuInttnCdArr to set
	 */
	public void setRtnDtilOccuInttnCdArr(List<String> rtnDtilOccuInttnCdArr) {
		this.rtnDtilOccuInttnCdArr = rtnDtilOccuInttnCdArr;
	}



	/**
	 * Comment :  일자 구분  Y : 년도 / YM :년월 / YMD 일자   
	 * @fn String getYmdGb()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the ymdGb get
	 */
	public String getYmdGb() {
		return YmdGb;
	}



	/**
	 * Comment :  일자 구분  Y : 년도 / YM :년월 / YMD 일자   
	 *@fn void setYmdGb(String YmdGb)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param ymdGb the ymdGb to set
	 */
	public void setYmdGb(String ymdGb) {
		YmdGb = ymdGb;
	}



	/**
	 * Comment : 일자구분에 따른 넘김값
	 * @fn String getStrDate()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the strDate get
	 */
	public String getStrDate() {
		return strDate;
	}



	/**
	 * Comment : 일자구분에 따른 넘김값
	 *@fn void setStrDate(String strDate)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param strDate the strDate to set
	 */
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}



	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCreDt()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the deptCreDt get
	 */
	public java.lang.String getDeptCreDt() {
		return deptCreDt;
	}



	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCreDt(java.lang.String deptCreDt)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param deptCreDt the deptCreDt to set
	 */
	public void setDeptCreDt(java.lang.String deptCreDt) {
		this.deptCreDt = deptCreDt;
	}



	/**
	 * Comment : 
	 * @fn java.lang.String getDeptEndDt()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the deptEndDt get
	 */
	public java.lang.String getDeptEndDt() {
		return deptEndDt;
	}



	/**
	 * Comment : 
	 *@fn void setDeptEndDt(java.lang.String deptEndDt)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param deptEndDt the deptEndDt to set
	 */
	public void setDeptEndDt(java.lang.String deptEndDt) {
		this.deptEndDt = deptEndDt;
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
