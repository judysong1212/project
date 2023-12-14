package com.app.smrmf.sysm.server.service.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Bass0150VO.java
 * @Description : Bass0150 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfBass0400VO implements Serializable {
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
      
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
     
    /** 일자 구분  Y : 년도 / YM :년월 / YMD 일자    */
    private String YmdGb;
    
    /** 일자구분에 따른 넘김값   */
    private String strDate;  
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    /** pyspGrdeCd */
    private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
       
    
   private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
        

/** set 부서생서일자 : deptCreDt */
private java.lang.String deptCreDt;

/** set 부서폐지일자 : deptEndDt */
private java.lang.String deptEndDt;

 
/** 부서코드 - DEPT_CD */
private List<String> rtnDeptCdArr;
/** TYP_OCCU_CD */
private List<String> rtnTypOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값 
 
private List<String> rtnDtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값

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
 * Comment : 
 * @fn List<String> getDeptCdArr()
 * @brief date:2017 2017. 1. 24. user:atres-pc
 * @return the deptCdArr get
 */
public List<String> getDeptCdArr() {
	return deptCdArr;
}

/**
 * Comment : 
 *@fn void setDeptCdArr(List<String> deptCdArr)
 *@brief date:2017 2017. 1. 24. user:atres-pc
 *@param deptCdArr the deptCdArr to set
 */
public void setDeptCdArr(List<String> deptCdArr) {
	this.deptCdArr = deptCdArr;
}

/**
 * Comment : 
 * @fn String getYmdGb()
 * @brief date:2017 2017. 1. 24. user:atres-pc
 * @return the ymdGb get
 */
public String getYmdGb() {
	return YmdGb;
}

/**
 * Comment : 
 *@fn void setYmdGb(String YmdGb)
 *@brief date:2017 2017. 1. 24. user:atres-pc
 *@param ymdGb the ymdGb to set
 */
public void setYmdGb(String ymdGb) {
	YmdGb = ymdGb;
}

/**
 * Comment : 
 * @fn String getStrDate()
 * @brief date:2017 2017. 1. 24. user:atres-pc
 * @return the strDate get
 */
public String getStrDate() {
	return strDate;
}

/**
 * Comment : 
 *@fn void setStrDate(String strDate)
 *@brief date:2017 2017. 1. 24. user:atres-pc
 *@param strDate the strDate to set
 */
public void setStrDate(String strDate) {
	this.strDate = strDate;
}

/**
 * Comment : 
 * @fn List<String> getTypOccuCdArr()
 * @brief date:2017 2017. 1. 24. user:atres-pc
 * @return the typOccuCdArr get
 */
public List<String> getTypOccuCdArr() {
	return typOccuCdArr;
}

/**
 * Comment : 
 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
 *@brief date:2017 2017. 1. 24. user:atres-pc
 *@param typOccuCdArr the typOccuCdArr to set
 */
public void setTypOccuCdArr(List<String> typOccuCdArr) {
	this.typOccuCdArr = typOccuCdArr;
}

/**
 * Comment : 
 * @fn List<String> getPyspGrdeCdArr()
 * @brief date:2017 2017. 1. 24. user:atres-pc
 * @return the pyspGrdeCdArr get
 */
public List<String> getPyspGrdeCdArr() {
	return pyspGrdeCdArr;
}

/**
 * Comment : 
 *@fn void setPyspGrdeCdArr(List<String> pyspGrdeCdArr)
 *@brief date:2017 2017. 1. 24. user:atres-pc
 *@param pyspGrdeCdArr the pyspGrdeCdArr to set
 */
public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
	this.pyspGrdeCdArr = pyspGrdeCdArr;
}

/**
 * Comment : 
 * @fn List<String> getDtilOccuClsDivCdArr()
 * @brief date:2017 2017. 1. 24. user:atres-pc
 * @return the dtilOccuClsDivCdArr get
 */
public List<String> getDtilOccuClsDivCdArr() {
	return dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 *@fn void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr)
 *@brief date:2017 2017. 1. 24. user:atres-pc
 *@param dtilOccuClsDivCdArr the dtilOccuClsDivCdArr to set
 */
public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
	this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 * @fn List<String> getDtilOccuInttnCdArr()
 * @brief date:2017 2017. 1. 24. user:atres-pc
 * @return the dtilOccuInttnCdArr get
 */
public List<String> getDtilOccuInttnCdArr() {
	return dtilOccuInttnCdArr;
}

/**
 * Comment : 
 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
 *@brief date:2017 2017. 1. 24. user:atres-pc
 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
 */
public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
	this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
}

	/**
 * Comment : 
 * @fn java.lang.String getDeptCreDt()
 * @brief date:2017 2017. 1. 22. user:atres-pc
 * @return the deptCreDt get
 */
public java.lang.String getDeptCreDt() {
	return deptCreDt;
}

/**
 * Comment : 
 *@fn void setDeptCreDt(java.lang.String deptCreDt)
 *@brief date:2017 2017. 1. 22. user:atres-pc
 *@param deptCreDt the deptCreDt to set
 */
public void setDeptCreDt(java.lang.String deptCreDt) {
	this.deptCreDt = deptCreDt;
}

/**
 * Comment : 
 * @fn java.lang.String getDeptEndDt()
 * @brief date:2017 2017. 1. 22. user:atres-pc
 * @return the deptEndDt get
 */
public java.lang.String getDeptEndDt() {
	return deptEndDt;
}

/**
 * Comment : 
 *@fn void setDeptEndDt(java.lang.String deptEndDt)
 *@brief date:2017 2017. 1. 22. user:atres-pc
 *@param deptEndDt the deptEndDt to set
 */
public void setDeptEndDt(java.lang.String deptEndDt) {
	this.deptEndDt = deptEndDt;
}

	/** PAY_MANGE_DEPT_NM */
    private java.lang.String payMangeDeptNm;
    
    /** DEGTR_RESN_REGN_NUM */
    private java.lang.String degtrResnRegnNum;
    
    /** DEGTR_NM */
    private java.lang.String degtrNm;
    
    /** BUSOPR_RGSTN_NUM */
    private java.lang.String busoprRgstnNum;
    
    /** CORP_RGSTN_NUM */
    private java.lang.String corpRgstnNum;
    
    /** CORP_DIV_CD */
    private java.lang.String corpDivCd;
    
    /** PAY_MANGE_DEPT_ZPCD */
    private java.lang.String payMangeDeptZpcd;
    
    /** PAY_MANGE_DEPT_F_NDTN_ADDR */
    private java.lang.String payMangeDeptFNdtnAddr;
    
    /** PAY_MANGE_DEPT_DTL_PATR_ADDR */
    private java.lang.String payMangeDeptDtlPatrAddr;
    
    /** PAY_MANGE_DEPT_PHN_NUM */
    private java.lang.String payMangeDeptPhnNum;
    
    /** PAY_MANGE_DEPT_FAX_NUM */
    private java.lang.String payMangeDeptFaxNum;
    
    /** PAY_MANGE_DEPT_SEAL_WRD_NM */
    private java.lang.String payMangeDeptSealWrdNm;
    
    /** PAY_MANGE_DEPT_SEAL_RFTA_NM */
    private java.lang.String payMangeDeptSealRftaNm;
    
    /** PAY_MANGE_DEPT_SEAL_FL_NM */
    private java.lang.String payMangeDeptSealFlNm;
    
    /** PAY_MANGE_DEPT_F_NDTN_USE_YN */
    private java.lang.String payMangeDeptFNdtnUseYn;
    
    /** PAY_MANGE_DEPT_WHLE_PERN_CHRG */
    private java.lang.String payMangeDeptWhlePernChrg;
    
    /** PAY_MANGE_DEPT_DIV_TSK_OFFR */
    private java.lang.String payMangeDeptDivTskOffr;
    
    /** ACC_CD */
    private java.lang.String accCd;
    
     
    
    /** CLLN_DEBR_NM */
    private java.lang.String cllnDebrNm;
    
    /** HMTX_ID */
    private java.lang.String hmtxId;
    
    /** TX_OFFC_CD */
    private java.lang.String txOffcCd;
    
    /** BNK_CD */
    private java.lang.String bnkCd;
    
    /** GRO_TNSR_CD */
    private java.lang.String groTnsrCd;
    
   
    /** HLTH_INSR_OFCE_SYM */
    private java.lang.String hlthInsrOfceSym;
   
    
    
    public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getDeptNmHan() {
		return deptNmHan;
	}

	public void setDeptNmHan(java.lang.String deptNmHan) {
		this.deptNmHan = deptNmHan;
	}

	public java.lang.String getDeptNmRtchnt() {
		return deptNmRtchnt;
	}

	public void setDeptNmRtchnt(java.lang.String deptNmRtchnt) {
		this.deptNmRtchnt = deptNmRtchnt;
	}

	public java.lang.String getDeptNmEng() {
		return deptNmEng;
	}

	public void setDeptNmEng(java.lang.String deptNmEng) {
		this.deptNmEng = deptNmEng;
	}

	public java.lang.String getTplvlDeptCd() {
		return tplvlDeptCd;
	}

	public void setTplvlDeptCd(java.lang.String tplvlDeptCd) {
		this.tplvlDeptCd = tplvlDeptCd;
	}

	public java.lang.String getHhrkDeptCd() {
		return hhrkDeptCd;
	}

	public void setHhrkDeptCd(java.lang.String hhrkDeptCd) {
		this.hhrkDeptCd = hhrkDeptCd;
	}

	public java.lang.String getDeptUseYn() {
		return deptUseYn;
	}

	public void setDeptUseYn(java.lang.String deptUseYn) {
		this.deptUseYn = deptUseYn;
	}

	public java.lang.String getDeptNoteCtnt() {
		return deptNoteCtnt;
	}

	public void setDeptNoteCtnt(java.lang.String deptNoteCtnt) {
		this.deptNoteCtnt = deptNoteCtnt;
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

	public java.lang.String getDeptRank() {
		return deptRank;
	}

	public void setDeptRank(java.lang.String deptRank) {
		this.deptRank = deptRank;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public java.lang.String getPayMangeDeptNm() {
        return this.payMangeDeptNm;
    }
    
    public void setPayMangeDeptNm(java.lang.String payMangeDeptNm) {
        this.payMangeDeptNm = payMangeDeptNm;
    }
    
    public java.lang.String getDegtrResnRegnNum() {
        return this.degtrResnRegnNum;
    }
    
    public void setDegtrResnRegnNum(java.lang.String degtrResnRegnNum) {
        this.degtrResnRegnNum = degtrResnRegnNum;
    }
    
    public java.lang.String getDegtrNm() {
        return this.degtrNm;
    }
    
    public void setDegtrNm(java.lang.String degtrNm) {
        this.degtrNm = degtrNm;
    }
    
    public java.lang.String getBusoprRgstnNum() {
        return this.busoprRgstnNum;
    }
    
    public void setBusoprRgstnNum(java.lang.String busoprRgstnNum) {
        this.busoprRgstnNum = busoprRgstnNum;
    }
    
    public java.lang.String getCorpRgstnNum() {
        return this.corpRgstnNum;
    }
    
    public void setCorpRgstnNum(java.lang.String corpRgstnNum) {
        this.corpRgstnNum = corpRgstnNum;
    }
    
    public java.lang.String getCorpDivCd() {
        return this.corpDivCd;
    }
    
    public void setCorpDivCd(java.lang.String corpDivCd) {
        this.corpDivCd = corpDivCd;
    }
    
    public java.lang.String getPayMangeDeptZpcd() {
        return this.payMangeDeptZpcd;
    }
    
    public void setPayMangeDeptZpcd(java.lang.String payMangeDeptZpcd) {
        this.payMangeDeptZpcd = payMangeDeptZpcd;
    }
    
    public java.lang.String getPayMangeDeptFNdtnAddr() {
        return this.payMangeDeptFNdtnAddr;
    }
    
    public void setPayMangeDeptFNdtnAddr(java.lang.String payMangeDeptFNdtnAddr) {
        this.payMangeDeptFNdtnAddr = payMangeDeptFNdtnAddr;
    }
    
    public java.lang.String getPayMangeDeptDtlPatrAddr() {
        return this.payMangeDeptDtlPatrAddr;
    }
    
    public void setPayMangeDeptDtlPatrAddr(java.lang.String payMangeDeptDtlPatrAddr) {
        this.payMangeDeptDtlPatrAddr = payMangeDeptDtlPatrAddr;
    }
    
    public java.lang.String getPayMangeDeptPhnNum() {
        return this.payMangeDeptPhnNum;
    }
    
    public void setPayMangeDeptPhnNum(java.lang.String payMangeDeptPhnNum) {
        this.payMangeDeptPhnNum = payMangeDeptPhnNum;
    }
    
    public java.lang.String getPayMangeDeptFaxNum() {
        return this.payMangeDeptFaxNum;
    }
    
    public void setPayMangeDeptFaxNum(java.lang.String payMangeDeptFaxNum) {
        this.payMangeDeptFaxNum = payMangeDeptFaxNum;
    }
    
    public java.lang.String getPayMangeDeptSealWrdNm() {
        return this.payMangeDeptSealWrdNm;
    }
    
    public void setPayMangeDeptSealWrdNm(java.lang.String payMangeDeptSealWrdNm) {
        this.payMangeDeptSealWrdNm = payMangeDeptSealWrdNm;
    }
    
    public java.lang.String getPayMangeDeptSealRftaNm() {
        return this.payMangeDeptSealRftaNm;
    }
    
    public void setPayMangeDeptSealRftaNm(java.lang.String payMangeDeptSealRftaNm) {
        this.payMangeDeptSealRftaNm = payMangeDeptSealRftaNm;
    }
    
    public java.lang.String getPayMangeDeptSealFlNm() {
        return this.payMangeDeptSealFlNm;
    }
    
    public void setPayMangeDeptSealFlNm(java.lang.String payMangeDeptSealFlNm) {
        this.payMangeDeptSealFlNm = payMangeDeptSealFlNm;
    }
    
    public java.lang.String getPayMangeDeptFNdtnUseYn() {
        return this.payMangeDeptFNdtnUseYn;
    }
    
    public void setPayMangeDeptFNdtnUseYn(java.lang.String payMangeDeptFNdtnUseYn) {
        this.payMangeDeptFNdtnUseYn = payMangeDeptFNdtnUseYn;
    }
    
    public java.lang.String getPayMangeDeptWhlePernChrg() {
        return this.payMangeDeptWhlePernChrg;
    }
    
    public void setPayMangeDeptWhlePernChrg(java.lang.String payMangeDeptWhlePernChrg) {
        this.payMangeDeptWhlePernChrg = payMangeDeptWhlePernChrg;
    }
    
    public java.lang.String getPayMangeDeptDivTskOffr() {
        return this.payMangeDeptDivTskOffr;
    }
    
    public void setPayMangeDeptDivTskOffr(java.lang.String payMangeDeptDivTskOffr) {
        this.payMangeDeptDivTskOffr = payMangeDeptDivTskOffr;
    }
    
    public java.lang.String getAccCd() {
        return this.accCd;
    }
    
    public void setAccCd(java.lang.String accCd) {
        this.accCd = accCd;
    }
    
    public java.lang.String getHlthInsrSym() {
        return this.hlthInsrSym;
    }
    
    public void setHlthInsrSym(java.lang.String hlthInsrSym) {
        this.hlthInsrSym = hlthInsrSym;
    }
    
    public java.lang.String getNatPennSym() {
        return this.natPennSym;
    }
    
    public void setNatPennSym(java.lang.String natPennSym) {
        this.natPennSym = natPennSym;
    }
    
    public java.lang.String getUmytInsrSym() {
        return this.umytInsrSym;
    }
    
    public void setUmytInsrSym(java.lang.String umytInsrSym) {
        this.umytInsrSym = umytInsrSym;
    }
    
    public java.lang.String getCllnDebrNm() {
        return this.cllnDebrNm;
    }
    
    public void setCllnDebrNm(java.lang.String cllnDebrNm) {
        this.cllnDebrNm = cllnDebrNm;
    }
    
    public java.lang.String getHmtxId() {
        return this.hmtxId;
    }
    
    public void setHmtxId(java.lang.String hmtxId) {
        this.hmtxId = hmtxId;
    }
    
    public java.lang.String getTxOffcCd() {
        return this.txOffcCd;
    }
    
    public void setTxOffcCd(java.lang.String txOffcCd) {
        this.txOffcCd = txOffcCd;
    }
    
    public java.lang.String getBnkCd() {
        return this.bnkCd;
    }
    
    public void setBnkCd(java.lang.String bnkCd) {
        this.bnkCd = bnkCd;
    }
    
    public java.lang.String getGroTnsrCd() {
        return this.groTnsrCd;
    }
    
    public void setGroTnsrCd(java.lang.String groTnsrCd) {
        this.groTnsrCd = groTnsrCd;
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
    
    public java.lang.String getHlthInsrOfceSym() {
        return this.hlthInsrOfceSym;
    }
    
    public void setHlthInsrOfceSym(java.lang.String hlthInsrOfceSym) {
        this.hlthInsrOfceSym = hlthInsrOfceSym;
    }
    
    public java.lang.String getIdtlAccdtInsurSym() {
        return this.idtlAccdtInsurSym;
    }
    
    public void setIdtlAccdtInsurSym(java.lang.String idtlAccdtInsurSym) {
        this.idtlAccdtInsurSym = idtlAccdtInsurSym;
    }
    
}
