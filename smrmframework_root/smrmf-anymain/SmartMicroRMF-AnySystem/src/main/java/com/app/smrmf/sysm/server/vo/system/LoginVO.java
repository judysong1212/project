package com.app.smrmf.sysm.server.vo.system;

import java.io.Serializable;

/**
 * @Class Name : LoginVO.java
 * @Description : Login VO class
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.03.03    박지욱          최초 생성
 *
 *  @author 공통서비스 개발팀 박지욱
 *  @since 2009.03.03
 *  @version 1.0
 *  @see
 *  
 *  
 */
public class LoginVO implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;


	/** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** USR_NM */
    private java.lang.String usrNm;
    
    /** USR_DIV_CD */
    private java.lang.String usrDivCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** EMAIL */
    private java.lang.String email;
    
    /** PWD */
    private java.lang.String pwd;
    
    /** SSO_USR_ID */
    private java.lang.String ssoUsrId; 
    
    /** USE_YN */
    private java.lang.String useYn;
    
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
 


private java.lang.String   dpobCd;   /** column 사업장코드 : dpobCd */

private java.lang.String   dpobNm;   /** column 사업장 : dpobNm */
 
/** SYS_DIV_NM */
private java.lang.String sysDivNm;
private java.lang.String   accYr;   /** column 회계년도 : accYr */
 

private java.lang.String   hanNm;   /** column 한글성명 : hanNm */
 
private java.lang.String   resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
  

private java.lang.String   businCd;  /** column 사업코드 : businCd */

private java.lang.String   payrMangDeptCd ;  /** column 단위기관코드 : payrMangDeptCd */

private java.lang.String   deptNm;   /** column 부서 : deptNm */

private java.lang.String   businNm;  /** column 사업 : businNm */

private java.lang.String   payrMangDeptNm ;  /** column 단위기관 : payrMangDeptNm */


/** AUTH_GRP_SEIL_NUM */
private Long authGrpSeilNum;

/** BUSIN_DIV_CD */
private java.lang.String businDivCd;
/** BUSIN_DIV_NM */
private java.lang.String businDivNm;
/** AUTH_GRP_NM */
private java.lang.String authGrpNm;

/** GRDE */
private java.lang.String grde;
 
private java.lang.String usrDivNm; 
    
private java.lang.String usrTel;

private java.lang.String ssoUseType; 

private java.lang.String mangeDeptCd;

private java.lang.String mangeDeptNm;

private java.lang.String payrMangDeptYn;

private java.lang.String tplvlDeptCd;

private java.lang.String tplvlDeptNm;
 
  
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

	public java.lang.String getSsoUsrId() {
		return ssoUsrId;
	}
	
	public void setSsoUsrId(java.lang.String ssoUsrId) {
		this.ssoUsrId = ssoUsrId;
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

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getDpobNm() {
		return dpobNm;
	}

	public void setDpobNm(java.lang.String dpobNm) {
		this.dpobNm = dpobNm;
	}

	public java.lang.String getSysDivNm() {
		return sysDivNm;
	}

	public void setSysDivNm(java.lang.String sysDivNm) {
		this.sysDivNm = sysDivNm;
	}

	public java.lang.String getAccYr() {
		return accYr;
	}

	public void setAccYr(java.lang.String accYr) {
		this.accYr = accYr;
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

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	public java.lang.String getPayrMangDeptNm() {
		return payrMangDeptNm;
	}

	public void setPayrMangDeptNm(java.lang.String payrMangDeptNm) {
		this.payrMangDeptNm = payrMangDeptNm;
	}

	public Long getAuthGrpSeilNum() {
		return authGrpSeilNum;
	}

	public void setAuthGrpSeilNum(Long authGrpSeilNum) {
		this.authGrpSeilNum = authGrpSeilNum;
	}

	public java.lang.String getBusinDivCd() {
		return businDivCd;
	}

	public void setBusinDivCd(java.lang.String businDivCd) {
		this.businDivCd = businDivCd;
	}

	public java.lang.String getBusinDivNm() {
		return businDivNm;
	}

	public void setBusinDivNm(java.lang.String businDivNm) {
		this.businDivNm = businDivNm;
	}

	public java.lang.String getAuthGrpNm() {
		return authGrpNm;
	}

	public void setAuthGrpNm(java.lang.String authGrpNm) {
		this.authGrpNm = authGrpNm;
	}

	public java.lang.String getGrde() {
		return grde;
	}

	public void setGrde(java.lang.String grde) {
		this.grde = grde;
	}

	public java.lang.String getUsrDivNm() {
		return usrDivNm;
	}

	public void setUsrDivNm(java.lang.String usrDivNm) {
		this.usrDivNm = usrDivNm;
	}

	public java.lang.String getUsrTel() {
		return usrTel;
	}

	public void setUsrTel(java.lang.String usrTel) {
		this.usrTel = usrTel;
	}

	public java.lang.String getSsoUseType() {
		return ssoUseType;
	}

	public void setSsoUseType(java.lang.String ssoUseType) {
		this.ssoUseType = ssoUseType;
	}

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	public java.lang.String getMangeDeptNm() {
		return mangeDeptNm;
	}

	public void setMangeDeptNm(java.lang.String mangeDeptNm) {
		this.mangeDeptNm = mangeDeptNm;
	}

	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	public java.lang.String getTplvlDeptCd() {
		return tplvlDeptCd;
	}

	public void setTplvlDeptCd(java.lang.String tplvlDeptCd) {
		this.tplvlDeptCd = tplvlDeptCd;
	}

	public java.lang.String getTplvlDeptNm() {
		return tplvlDeptNm;
	}

	public void setTplvlDeptNm(java.lang.String tplvlDeptNm) {
		this.tplvlDeptNm = tplvlDeptNm;
	}
    
	
}
