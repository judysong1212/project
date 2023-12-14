package com.app.smrmf.core.msfmainapp.client.admin.dto.system;

import java.io.Serializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MSFUserInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

private java.lang.String   dpobCd;   /** column 사업장코드 : dpobCd */

private java.lang.String   dpobNm;   /** column 사업장 : dpobNm */

/** SYS_DIV_CD */
private java.lang.String sysDivCd;

private java.lang.String   accYr;   /** column 회계년도 : accYr */

private java.lang.String   systemkey;   /** column SYSTEMKEY : systemkey */

private java.lang.String   hanNm;   /** column 한글성명 : hanNm */
 
private java.lang.String   resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
 
private java.lang.String   deptCd;   /** column 부서코드 : deptCd */

private java.lang.String   businCd;  /** column 사업코드 : businCd */

private java.lang.String   payrMangDeptCd ;  /** column 단위기관코드 : payrMangDeptCd */

private java.lang.String   deptNm;   /** column 부서 : deptNm */

private java.lang.String   businNm;  /** column 사업 : businNm */

private java.lang.String   payrMangDeptNm ;  /** column 단위기관 : payrMangDeptNm */


/** AUTH_GRP_SEIL_NUM */
private Long authGrpSeilNum;

/** BUSIN_DIV_CD */
private java.lang.String businDivCd;

/** AUTH_GRP_NM */
private java.lang.String authGrpNm;

/** GRDE */
private java.lang.String grde;

 
    
    public java.lang.String getSysDivCd() {
	return sysDivCd;
}

public void setSysDivCd(java.lang.String sysDivCd) {
	this.sysDivCd = sysDivCd;
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
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }
     
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }

	public java.lang.String getDpobNm() {
		return dpobNm;
	}

	public void setDpobNm(java.lang.String dpobNm) {
		this.dpobNm = dpobNm;
	}

	public java.lang.String getAccYr() {
		return accYr;
	}

	public void setAccYr(java.lang.String accYr) {
		this.accYr = accYr;
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
    
   
}
