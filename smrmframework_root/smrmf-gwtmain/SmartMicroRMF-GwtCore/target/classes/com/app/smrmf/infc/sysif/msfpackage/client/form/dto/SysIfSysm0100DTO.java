package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.io.Serializable;

/**
 * @Class Name : Sysm0100VO.java
 * @Description : Sysm0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0100DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    

	/** set 시스템구분코드 : sysDivCd */
	private java.lang.String sysDivCd;

	/** set 사용자아이디 : usrId */
	private java.lang.String usrId;

	/** set 사용자성명 : usrNm */
	private java.lang.String usrNm;

	/** set 사용자구분코드 : usrDivCd */
	private java.lang.String usrDivCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 부서코드 : deptCd */
	private java.lang.String deptCd;

	/** set null : usrTel */
	private java.lang.String usrTel;

	/** set 이메일 : email */
	private java.lang.String email;

	/** set 패스워드 : pwd */
	private java.lang.String pwd;

	/** set 사용자사용여부 : useYn */
	private java.lang.String useYn;

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

	/** set 직종코드 : typOccuCd */
	private java.lang.String typOccuCd;

	/** set 호봉등급코드 : pyspGrdeCd */
	private java.lang.String pyspGrdeCd;

	/** set 사용자권한제외여부 : usrAuthEepnYn */
	private java.lang.String usrAuthEepnYn;

	/** set 호봉제포함여부 : pyspInsnYn */
	private java.lang.String pyspInsnYn;

	/** set 비호봉제포함여부 : notPyspInsnYn */
	private java.lang.String notPyspInsnYn;

	/** set 복무입력처리여부 : servcInptPrcsYn */
	private java.lang.String servcInptPrcsYn;

	/** set 연말정산입력처리여부 : yrtxInptPrcsYn */
	private java.lang.String yrtxInptPrcsYn;

	/** set 기간제포함여부 : shttmInsnYn */
	private java.lang.String shttmInsnYn;

	/** set 사용자권한구분코드 : usrAuthDivCd */
	private java.lang.String usrAuthDivCd;

 
	
	/** set 패스워드 : tmpPwd */
	private java.lang.String tmpPwd;

  
    
	 /** set 사업장코드 - DPOB_CD */
    private java.lang.String dpobCd;
 
    /** set 시스템구분코드 : sysDivNm */
    private java.lang.String sysDivNm;

   
    /** set 사용자구분 : usrDivNm*/
    private java.lang.String usrDivNm;

    

    /** set 부서코드 : deptNm */
    private java.lang.String deptNm;
    
    
    
    /** set 단위기관코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;
    
    /** set 단위기관코드 : payrMangDeptNm */
    private java.lang.String payrMangDeptNm;
    
    /** set 관리부서코드 : mangeDeptCd */
    private java.lang.String mangeDeptCd; 

    /** set 관리부서 : mangeDeptNm */
    private java.lang.String mangeDeptNm;
      
    /** set 최상위부서코드 : tplvlDeptCd */
    private java.lang.String tplvlDeptCd;
    
    /** set 최상위부서코드 : tplvlDeptNm */
    private java.lang.String tplvlDeptNm;
     
    /** set 직종 : typOccuNm TODO 삭제 */
    private java.lang.String typOccuNm;
     
    /** set 등급 : pyspGrdeNm TODO 삭제 */
    private java.lang.String pyspGrdeNm;

    /** set 단위기관담당자여부 : payrMangDeptYn   */
    private java.lang.String payrMangDeptYn;
 
    
    
    /**
	 * Comment : 
	 * @fn java.lang.String getUsrAuthEepnYn()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the usrAuthEepnYn get
	 */
	public java.lang.String getUsrAuthEepnYn() {
		return usrAuthEepnYn;
	}

	/**
	 * Comment : 
	 *@fn void setUsrAuthEepnYn(java.lang.String usrAuthEepnYn)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param usrAuthEepnYn the usrAuthEepnYn to set
	 */
	public void setUsrAuthEepnYn(java.lang.String usrAuthEepnYn) {
		this.usrAuthEepnYn = usrAuthEepnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspInsnYn()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the pyspInsnYn get
	 */
	public java.lang.String getPyspInsnYn() {
		return pyspInsnYn;
	}

	/**
	 * Comment : 
	 *@fn void setPyspInsnYn(java.lang.String pyspInsnYn)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param pyspInsnYn the pyspInsnYn to set
	 */
	public void setPyspInsnYn(java.lang.String pyspInsnYn) {
		this.pyspInsnYn = pyspInsnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNotPyspInsnYn()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the notPyspInsnYn get
	 */
	public java.lang.String getNotPyspInsnYn() {
		return notPyspInsnYn;
	}

	/**
	 * Comment : 
	 *@fn void setNotPyspInsnYn(java.lang.String notPyspInsnYn)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param notPyspInsnYn the notPyspInsnYn to set
	 */
	public void setNotPyspInsnYn(java.lang.String notPyspInsnYn) {
		this.notPyspInsnYn = notPyspInsnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getServcInptPrcsYn()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the servcInptPrcsYn get
	 */
	public java.lang.String getServcInptPrcsYn() {
		return servcInptPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setServcInptPrcsYn(java.lang.String servcInptPrcsYn)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param servcInptPrcsYn the servcInptPrcsYn to set
	 */
	public void setServcInptPrcsYn(java.lang.String servcInptPrcsYn) {
		this.servcInptPrcsYn = servcInptPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxInptPrcsYn()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the yrtxInptPrcsYn get
	 */
	public java.lang.String getYrtxInptPrcsYn() {
		return yrtxInptPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxInptPrcsYn(java.lang.String yrtxInptPrcsYn)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param yrtxInptPrcsYn the yrtxInptPrcsYn to set
	 */
	public void setYrtxInptPrcsYn(java.lang.String yrtxInptPrcsYn) {
		this.yrtxInptPrcsYn = yrtxInptPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getShttmInsnYn()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the shttmInsnYn get
	 */
	public java.lang.String getShttmInsnYn() {
		return shttmInsnYn;
	}

	/**
	 * Comment : 
	 *@fn void setShttmInsnYn(java.lang.String shttmInsnYn)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param shttmInsnYn the shttmInsnYn to set
	 */
	public void setShttmInsnYn(java.lang.String shttmInsnYn) {
		this.shttmInsnYn = shttmInsnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrAuthDivCd()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the usrAuthDivCd get
	 */
	public java.lang.String getUsrAuthDivCd() {
		return usrAuthDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setUsrAuthDivCd(java.lang.String usrAuthDivCd)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param usrAuthDivCd the usrAuthDivCd to set
	 */
	public void setUsrAuthDivCd(java.lang.String usrAuthDivCd) {
		this.usrAuthDivCd = usrAuthDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSysDivNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the sysDivNm get
	 */
	public java.lang.String getSysDivNm() {
		return sysDivNm;
	}

	/**
	 * Comment : 
	 *@fn void setSysDivNm(java.lang.String sysDivNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param sysDivNm the sysDivNm to set
	 */
	public void setSysDivNm(java.lang.String sysDivNm) {
		this.sysDivNm = sysDivNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrDivNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the usrDivNm get
	 */
	public java.lang.String getUsrDivNm() {
		return usrDivNm;
	}

	/**
	 * Comment : 
	 *@fn void setUsrDivNm(java.lang.String usrDivNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param usrDivNm the usrDivNm to set
	 */
	public void setUsrDivNm(java.lang.String usrDivNm) {
		this.usrDivNm = usrDivNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the deptNm get
	 */
	public java.lang.String getDeptNm() {
		return deptNm;
	}

	/**
	 * Comment : 
	 *@fn void setDeptNm(java.lang.String deptNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param deptNm the deptNm to set
	 */
	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the payrMangDeptNm get
	 */
	public java.lang.String getPayrMangDeptNm() {
		return payrMangDeptNm;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptNm(java.lang.String payrMangDeptNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param payrMangDeptNm the payrMangDeptNm to set
	 */
	public void setPayrMangDeptNm(java.lang.String payrMangDeptNm) {
		this.payrMangDeptNm = payrMangDeptNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getMangeDeptNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the mangeDeptNm get
	 */
	public java.lang.String getMangeDeptNm() {
		return mangeDeptNm;
	}

	/**
	 * Comment : 
	 *@fn void setMangeDeptNm(java.lang.String mangeDeptNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param mangeDeptNm the mangeDeptNm to set
	 */
	public void setMangeDeptNm(java.lang.String mangeDeptNm) {
		this.mangeDeptNm = mangeDeptNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTplvlDeptCd()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the tplvlDeptCd get
	 */
	public java.lang.String getTplvlDeptCd() {
		return tplvlDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setTplvlDeptCd(java.lang.String tplvlDeptCd)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param tplvlDeptCd the tplvlDeptCd to set
	 */
	public void setTplvlDeptCd(java.lang.String tplvlDeptCd) {
		this.tplvlDeptCd = tplvlDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTplvlDeptNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the tplvlDeptNm get
	 */
	public java.lang.String getTplvlDeptNm() {
		return tplvlDeptNm;
	}

	/**
	 * Comment : 
	 *@fn void setTplvlDeptNm(java.lang.String tplvlDeptNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param tplvlDeptNm the tplvlDeptNm to set
	 */
	public void setTplvlDeptNm(java.lang.String tplvlDeptNm) {
		this.tplvlDeptNm = tplvlDeptNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the typOccuNm get
	 */
	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuNm(java.lang.String typOccuNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param typOccuNm the typOccuNm to set
	 */
	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeNm()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the pyspGrdeNm get
	 */
	public java.lang.String getPyspGrdeNm() {
		return pyspGrdeNm;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeNm(java.lang.String pyspGrdeNm)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param pyspGrdeNm the pyspGrdeNm to set
	 */
	public void setPyspGrdeNm(java.lang.String pyspGrdeNm) {
		this.pyspGrdeNm = pyspGrdeNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptYn()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the payrMangDeptYn get
	 */
	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptYn(java.lang.String payrMangDeptYn)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param payrMangDeptYn the payrMangDeptYn to set
	 */
	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrTel()
	 * @brief date:2015 Dec 25, 2015 user:leeheuisung
	 * @return the usrTel get
	 */
	public java.lang.String getUsrTel() {
		return usrTel;
	}

	/**
	 * Comment : 
	 *@fn void setUsrTel(java.lang.String usrTel)
	 *@brief date:2015 Dec 25, 2015 user:leeheuisung
	 *@param usrTel the usrTel to set
	 */
	public void setUsrTel(java.lang.String usrTel) {
		this.usrTel = usrTel;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2015 Dec 25, 2015 user:leeheuisung
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2015 Dec 25, 2015 user:leeheuisung
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2015 Dec 25, 2015 user:leeheuisung
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2015 Dec 25, 2015 user:leeheuisung
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getTmpPwd() {
		return tmpPwd;
	}

	public void setTmpPwd(java.lang.String tmpPwd) {
		this.tmpPwd = tmpPwd;
	}

	public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public java.lang.String getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(java.lang.String usrId) {
        this.usrId = usrId;
    }
    
    public java.lang.String getUsrNm() {
        return this.usrNm;
    }
    
    public void setUsrNm(java.lang.String usrNm) {
        this.usrNm = usrNm;
    }
    
    public java.lang.String getUsrDivCd() {
        return this.usrDivCd;
    }
    
    public void setUsrDivCd(java.lang.String usrDivCd) {
        this.usrDivCd = usrDivCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getEmail() {
        return this.email;
    }
    
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    public java.lang.String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(java.lang.String pwd) {
        this.pwd = pwd;
    }
    
    public java.lang.String getUseYn() {
        return this.useYn;
    }
    
    public void setUseYn(java.lang.String useYn) {
        this.useYn = useYn;
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
