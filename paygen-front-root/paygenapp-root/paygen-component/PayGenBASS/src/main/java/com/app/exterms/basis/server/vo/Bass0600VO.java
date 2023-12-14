package com.app.exterms.basis.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0600VO.java
 * @Description : Bass0600 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0600VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
  
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;
 

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String orgResnNum;
    
    
    /** TRNR_CTL_JOB_DIV_CD */
    private java.lang.String trnrCtlJobDivCd;
    
    /** TRNR_CTL_JOB_SEIL_NUM */
    private java.math.BigDecimal trnrCtlJobSeilNum;
    
    /** TRNR_CTL_JOB_DT */
    private java.lang.String trnrCtlJobDt;
    
    /** TRNR_CTL_JOB_BGNN_DTNTM */
    private java.lang.String trnrCtlJobBgnnDtntm;
    
    /** TRNR_CTL_JOB_END_DTNTM */
    private java.lang.String trnrCtlJobEndDtntm;
    
    /** TRNR_CTL_JOB_CTNT */
    private java.lang.String trnrCtlJobCtnt;
    
    /** TRNR_CTL_JOB_CMPLTN_YN */
    private java.lang.String trnrCtlJobCmpltnYn;
    
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
    

/** set 급여가족사항일련번호 : payFamyRsptSeilNum */
private java.math.BigDecimal payFamyRsptSeilNum;

/** set 급여가족주민번호 : payFamyResnRegnNum */
private java.lang.String payFamyResnRegnNum;


/** set 가족주민등록번호 : famyResnRegnNum */
private java.lang.String famyResnRegnNum;

/** set null : famySecRegnNum */
private java.lang.String famySecRegnNum;

/** set null : famyOrgRegnNum */
private java.lang.String famyOrgRegnNum;


/** FAMY_SEIL_NUM */
private java.math.BigDecimal famySeilNum;
 

private java.lang.String resid;

private java.lang.String oldresid;
 

    /**
 * Comment : 
 * @fn java.lang.String getResid()
 * @brief date:2018 2018. 3. 23. user:atres
 * @return the resid get
 */
public java.lang.String getResid() {
	return resid;
}

/**
 * Comment : 
 *@fn void setResid(java.lang.String resid)
 *@brief date:2018 2018. 3. 23. user:atres
 *@param resid the resid to set
 */
public void setResid(java.lang.String resid) {
	this.resid = resid;
}

/**
 * Comment : 
 * @fn java.lang.String getOldresid()
 * @brief date:2018 2018. 3. 23. user:atres
 * @return the oldresid get
 */
public java.lang.String getOldresid() {
	return oldresid;
}

/**
 * Comment : 
 *@fn void setOldresid(java.lang.String oldresid)
 *@brief date:2018 2018. 3. 23. user:atres
 *@param oldresid the oldresid to set
 */
public void setOldresid(java.lang.String oldresid) {
	this.oldresid = oldresid;
}

	/**
 * Comment : 
 * @fn java.math.BigDecimal getFamySeilNum()
 * @brief date:2016 2016. 9. 26. user:Administrator
 * @return the famySeilNum get
 */
public java.math.BigDecimal getFamySeilNum() {
	return famySeilNum;
}

/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPayFamyRsptSeilNum()
	 * @brief date:2017 2017. 3. 28. user:paygen
	 * @return the payFamyRsptSeilNum get
	 */
	public java.math.BigDecimal getPayFamyRsptSeilNum() {
		return payFamyRsptSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setPayFamyRsptSeilNum(java.math.BigDecimal payFamyRsptSeilNum)
	 *@brief date:2017 2017. 3. 28. user:paygen
	 *@param payFamyRsptSeilNum the payFamyRsptSeilNum to set
	 */
	public void setPayFamyRsptSeilNum(java.math.BigDecimal payFamyRsptSeilNum) {
		this.payFamyRsptSeilNum = payFamyRsptSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayFamyResnRegnNum()
	 * @brief date:2017 2017. 3. 28. user:paygen
	 * @return the payFamyResnRegnNum get
	 */
	public java.lang.String getPayFamyResnRegnNum() {
		return payFamyResnRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setPayFamyResnRegnNum(java.lang.String payFamyResnRegnNum)
	 *@brief date:2017 2017. 3. 28. user:paygen
	 *@param payFamyResnRegnNum the payFamyResnRegnNum to set
	 */
	public void setPayFamyResnRegnNum(java.lang.String payFamyResnRegnNum) {
		this.payFamyResnRegnNum = payFamyResnRegnNum;
	}

/**
 * Comment : 
 *@fn void setFamySeilNum(java.math.BigDecimal famySeilNum)
 *@brief date:2016 2016. 9. 26. user:Administrator
 *@param famySeilNum the famySeilNum to set
 */
public void setFamySeilNum(java.math.BigDecimal famySeilNum) {
	this.famySeilNum = famySeilNum;
}

	/**
 * Comment : 
 * @fn java.lang.String getFamyResnRegnNum()
 * @brief date:2016 2016. 9. 26. user:Administrator
 * @return the famyResnRegnNum get
 */
public java.lang.String getFamyResnRegnNum() {
	return famyResnRegnNum;
}

/**
 * Comment : 
 *@fn void setFamyResnRegnNum(java.lang.String famyResnRegnNum)
 *@brief date:2016 2016. 9. 26. user:Administrator
 *@param famyResnRegnNum the famyResnRegnNum to set
 */
public void setFamyResnRegnNum(java.lang.String famyResnRegnNum) {
	this.famyResnRegnNum = famyResnRegnNum;
}

/**
 * Comment : 
 * @fn java.lang.String getFamySecRegnNum()
 * @brief date:2016 2016. 9. 26. user:Administrator
 * @return the famySecRegnNum get
 */
public java.lang.String getFamySecRegnNum() {
	return famySecRegnNum;
}

/**
 * Comment : 
 *@fn void setFamySecRegnNum(java.lang.String famySecRegnNum)
 *@brief date:2016 2016. 9. 26. user:Administrator
 *@param famySecRegnNum the famySecRegnNum to set
 */
public void setFamySecRegnNum(java.lang.String famySecRegnNum) {
	this.famySecRegnNum = famySecRegnNum;
}

/**
 * Comment : 
 * @fn java.lang.String getFamyOrgRegnNum()
 * @brief date:2016 2016. 9. 26. user:Administrator
 * @return the famyOrgRegnNum get
 */
public java.lang.String getFamyOrgRegnNum() {
	return famyOrgRegnNum;
}

/**
 * Comment : 
 *@fn void setFamyOrgRegnNum(java.lang.String famyOrgRegnNum)
 *@brief date:2016 2016. 9. 26. user:Administrator
 *@param famyOrgRegnNum the famyOrgRegnNum to set
 */
public void setFamyOrgRegnNum(java.lang.String famyOrgRegnNum) {
	this.famyOrgRegnNum = famyOrgRegnNum;
}

	/**
	 * Comment : 
	 * @fn java.lang.String getOrgResnNum()
	 * @brief date:2016 2016. 8. 10. user:Administrator
	 * @return the orgResnNum get
	 */
	public java.lang.String getOrgResnNum() {
		return orgResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setOrgResnNum(java.lang.String orgResnNum)
	 *@brief date:2016 2016. 8. 10. user:Administrator
	 *@param orgResnNum the orgResnNum to set
	 */
	public void setOrgResnNum(java.lang.String orgResnNum) {
		this.orgResnNum = orgResnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2015 Nov 26, 2015 user:leeheuisung
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2015 Nov 26, 2015 user:leeheuisung
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getResnRegnNum()
	 * @brief date:2015 Nov 26, 2015 user:leeheuisung
	 * @return the resnRegnNum get
	 */
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setResnRegnNum(java.lang.String resnRegnNum)
	 *@brief date:2015 Nov 26, 2015 user:leeheuisung
	 *@param resnRegnNum the resnRegnNum to set
	 */
	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2015 Nov 26, 2015 user:leeheuisung
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2015 Nov 26, 2015 user:leeheuisung
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getTrnrCtlJobDivCd() {
        return this.trnrCtlJobDivCd;
    }
    
    public void setTrnrCtlJobDivCd(java.lang.String trnrCtlJobDivCd) {
        this.trnrCtlJobDivCd = trnrCtlJobDivCd;
    }
    
    public java.math.BigDecimal getTrnrCtlJobSeilNum() {
        return this.trnrCtlJobSeilNum;
    }
    
    public void setTrnrCtlJobSeilNum(java.math.BigDecimal trnrCtlJobSeilNum) {
        this.trnrCtlJobSeilNum = trnrCtlJobSeilNum;
    }
    
    public java.lang.String getTrnrCtlJobDt() {
        return this.trnrCtlJobDt;
    }
    
    public void setTrnrCtlJobDt(java.lang.String trnrCtlJobDt) {
        this.trnrCtlJobDt = trnrCtlJobDt;
    }
    
    public java.lang.String getTrnrCtlJobBgnnDtntm() {
        return this.trnrCtlJobBgnnDtntm;
    }
    
    public void setTrnrCtlJobBgnnDtntm(java.lang.String trnrCtlJobBgnnDtntm) {
        this.trnrCtlJobBgnnDtntm = trnrCtlJobBgnnDtntm;
    }
    
    public java.lang.String getTrnrCtlJobEndDtntm() {
        return this.trnrCtlJobEndDtntm;
    }
    
    public void setTrnrCtlJobEndDtntm(java.lang.String trnrCtlJobEndDtntm) {
        this.trnrCtlJobEndDtntm = trnrCtlJobEndDtntm;
    }
    
    public java.lang.String getTrnrCtlJobCtnt() {
        return this.trnrCtlJobCtnt;
    }
    
    public void setTrnrCtlJobCtnt(java.lang.String trnrCtlJobCtnt) {
        this.trnrCtlJobCtnt = trnrCtlJobCtnt;
    }
    
    public java.lang.String getTrnrCtlJobCmpltnYn() {
        return this.trnrCtlJobCmpltnYn;
    }
    
    public void setTrnrCtlJobCmpltnYn(java.lang.String trnrCtlJobCmpltnYn) {
        this.trnrCtlJobCmpltnYn = trnrCtlJobCmpltnYn;
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
