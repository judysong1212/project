package com.app.smrmf.sysm.server.vo.system;

import java.io.Serializable;
import java.util.List;

import com.app.smrmf.sysm.server.vo.SysIfSysm0300VO;

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
public class MSFUserInfoVO implements Serializable {

	
private static final long serialVersionUID = 1L;
    
private java.lang.String   dpobCd;   /** column 사업장코드 : dpobCd */

private java.lang.String   dpobNm;   /** column 사업장 : dpobNm */

/** SYS_DIV_CD */
private java.lang.String sysDivCd;


/** CONFIG 파일 접근 및 사용자 접근구분자  */
private java.lang.String appWebConn;


/** SYS_DIV_NM */
private java.lang.String sysDivNm;
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
/** BUSIN_DIV_NM */
private java.lang.String businDivNm;
/** AUTH_GRP_NM */
private java.lang.String authGrpNm;

/** GRDE */
private java.lang.String grde;

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
  
/***  고용구분코드   ******************/
private java.lang.String emymtDivCd; 
 
/***  고용구분명   ******************/
private java.lang.String emymtDivNm;

/** USR_ID */
private java.lang.String usrId;

/** USR_NM */
private java.lang.String usrNm;

/** USR_DIV_CD */
private java.lang.String usrDivCd;
 
/** EMAIL */
private java.lang.String email;

/** PWD */
private java.lang.String pwd;

/** SSO_USR_ID */
private java.lang.String ssoUsrId; 

/** USE_YN */
private java.lang.String useYn;
 
private java.lang.String usrDivNm; 

private java.lang.String usrTel;

private java.lang.String ssoUseType; 

private java.lang.String mangeDeptCd;

private java.lang.String mangeDeptNm;

private java.lang.String payrMangDeptYn;

private java.lang.String tplvlDeptCd;

private java.lang.String tplvlDeptNm;

private List<SysIfSysm0300VO> msfSysm0300List;   //TODO 권한정보 처리 
private LoginVO userInfo;       //TODO 로그인사용자 설정정보 
private MSFSsoxUserVO ssoxUser;        //TODO sso user info
private MSFAuthCheckVO  userAuth;        //TODO sso user info



    /**
 * @return the usrId
 */
public java.lang.String getUsrId() {
	return usrId;
}

/**
 * @param usrId the usrId to set
 */
public void setUsrId(java.lang.String usrId) {
	this.usrId = usrId;
}

/**
 * @return the usrNm
 */
public java.lang.String getUsrNm() {
	return usrNm;
}

/**
 * @param usrNm the usrNm to set
 */
public void setUsrNm(java.lang.String usrNm) {
	this.usrNm = usrNm;
}

/**
 * @return the usrDivCd
 */
public java.lang.String getUsrDivCd() {
	return usrDivCd;
}

/**
 * @param usrDivCd the usrDivCd to set
 */
public void setUsrDivCd(java.lang.String usrDivCd) {
	this.usrDivCd = usrDivCd;
}

/**
 * @return the email
 */
public java.lang.String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(java.lang.String email) {
	this.email = email;
}

/**
 * @return the pwd
 */
public java.lang.String getPwd() {
	return pwd;
}

/**
 * @param pwd the pwd to set
 */
public void setPwd(java.lang.String pwd) {
	this.pwd = pwd;
}

/**
 * @return the ssoUsrId
 */
public java.lang.String getSsoUsrId() {
	return ssoUsrId;
}

/**
 * @param ssoUsrId the ssoUsrId to set
 */
public void setSsoUsrId(java.lang.String ssoUsrId) {
	this.ssoUsrId = ssoUsrId;
}

/**
 * @return the useYn
 */
public java.lang.String getUseYn() {
	return useYn;
}

/**
 * @param useYn the useYn to set
 */
public void setUseYn(java.lang.String useYn) {
	this.useYn = useYn;
}

/**
 * @return the usrDivNm
 */
public java.lang.String getUsrDivNm() {
	return usrDivNm;
}

/**
 * @param usrDivNm the usrDivNm to set
 */
public void setUsrDivNm(java.lang.String usrDivNm) {
	this.usrDivNm = usrDivNm;
}

/**
 * @return the usrTel
 */
public java.lang.String getUsrTel() {
	return usrTel;
}

/**
 * @param usrTel the usrTel to set
 */
public void setUsrTel(java.lang.String usrTel) {
	this.usrTel = usrTel;
}

/**
 * @return the ssoUseType
 */
public java.lang.String getSsoUseType() {
	return ssoUseType;
}

/**
 * @param ssoUseType the ssoUseType to set
 */
public void setSsoUseType(java.lang.String ssoUseType) {
	this.ssoUseType = ssoUseType;
}

/**
 * @return the mangeDeptCd
 */
public java.lang.String getMangeDeptCd() {
	return mangeDeptCd;
}

/**
 * @param mangeDeptCd the mangeDeptCd to set
 */
public void setMangeDeptCd(java.lang.String mangeDeptCd) {
	this.mangeDeptCd = mangeDeptCd;
}

/**
 * @return the mangeDeptNm
 */
public java.lang.String getMangeDeptNm() {
	return mangeDeptNm;
}

/**
 * @param mangeDeptNm the mangeDeptNm to set
 */
public void setMangeDeptNm(java.lang.String mangeDeptNm) {
	this.mangeDeptNm = mangeDeptNm;
}

/**
 * @return the payrMangDeptYn
 */
public java.lang.String getPayrMangDeptYn() {
	return payrMangDeptYn;
}

/**
 * @param payrMangDeptYn the payrMangDeptYn to set
 */
public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
	this.payrMangDeptYn = payrMangDeptYn;
}

/**
 * @return the tplvlDeptCd
 */
public java.lang.String getTplvlDeptCd() {
	return tplvlDeptCd;
}

/**
 * @param tplvlDeptCd the tplvlDeptCd to set
 */
public void setTplvlDeptCd(java.lang.String tplvlDeptCd) {
	this.tplvlDeptCd = tplvlDeptCd;
}

/**
 * @return the tplvlDeptNm
 */
public java.lang.String getTplvlDeptNm() {
	return tplvlDeptNm;
}

/**
 * @param tplvlDeptNm the tplvlDeptNm to set
 */
public void setTplvlDeptNm(java.lang.String tplvlDeptNm) {
	this.tplvlDeptNm = tplvlDeptNm;
}

/**
 * @return the msfSysm0300List
 */
public List<SysIfSysm0300VO> getMsfSysm0300List() {
	return msfSysm0300List;
}

/**
 * @param msfSysm0300List the msfSysm0300List to set
 */
public void setMsfSysm0300List(List<SysIfSysm0300VO> msfSysm0300List) {
	this.msfSysm0300List = msfSysm0300List;
}

/**
 * @return the userInfo
 */
public LoginVO getUserInfo() {
	return userInfo;
}

/**
 * @param userInfo the userInfo to set
 */
public void setUserInfo(LoginVO userInfo) {
	this.userInfo = userInfo;
}

/**
 * @return the ssoxUser
 */
public MSFSsoxUserVO getSsoxUser() {
	return ssoxUser;
}

/**
 * @param ssoxUser the ssoxUser to set
 */
public void setSsoxUser(MSFSsoxUserVO ssoxUser) {
	this.ssoxUser = ssoxUser;
}

/**
 * @return the userAuth
 */
public MSFAuthCheckVO getUserAuth() {
	return userAuth;
}

/**
 * @param userAuth the userAuth to set
 */
public void setUserAuth(MSFAuthCheckVO userAuth) {
	this.userAuth = userAuth;
}

	/**
 * Comment : 
 * @fn java.lang.String getUsrAuthEepnYn()
 * @brief date:2017 2017. 1. 23. user:atres-pc
 * @return the usrAuthEepnYn get
 */
public java.lang.String getUsrAuthEepnYn() {
	return usrAuthEepnYn;
}

/**
 * Comment : 
 *@fn void setUsrAuthEepnYn(java.lang.String usrAuthEepnYn)
 *@brief date:2017 2017. 1. 23. user:atres-pc
 *@param usrAuthEepnYn the usrAuthEepnYn to set
 */
public void setUsrAuthEepnYn(java.lang.String usrAuthEepnYn) {
	this.usrAuthEepnYn = usrAuthEepnYn;
}

/**
 * Comment : 
 * @fn java.lang.String getPyspInsnYn()
 * @brief date:2017 2017. 1. 23. user:atres-pc
 * @return the pyspInsnYn get
 */
public java.lang.String getPyspInsnYn() {
	return pyspInsnYn;
}

/**
 * Comment : 
 *@fn void setPyspInsnYn(java.lang.String pyspInsnYn)
 *@brief date:2017 2017. 1. 23. user:atres-pc
 *@param pyspInsnYn the pyspInsnYn to set
 */
public void setPyspInsnYn(java.lang.String pyspInsnYn) {
	this.pyspInsnYn = pyspInsnYn;
}

/**
 * Comment : 
 * @fn java.lang.String getNotPyspInsnYn()
 * @brief date:2017 2017. 1. 23. user:atres-pc
 * @return the notPyspInsnYn get
 */
public java.lang.String getNotPyspInsnYn() {
	return notPyspInsnYn;
}

/**
 * Comment : 
 *@fn void setNotPyspInsnYn(java.lang.String notPyspInsnYn)
 *@brief date:2017 2017. 1. 23. user:atres-pc
 *@param notPyspInsnYn the notPyspInsnYn to set
 */
public void setNotPyspInsnYn(java.lang.String notPyspInsnYn) {
	this.notPyspInsnYn = notPyspInsnYn;
}

/**
 * Comment : 
 * @fn java.lang.String getServcInptPrcsYn()
 * @brief date:2017 2017. 1. 23. user:atres-pc
 * @return the servcInptPrcsYn get
 */
public java.lang.String getServcInptPrcsYn() {
	return servcInptPrcsYn;
}

/**
 * Comment : 
 *@fn void setServcInptPrcsYn(java.lang.String servcInptPrcsYn)
 *@brief date:2017 2017. 1. 23. user:atres-pc
 *@param servcInptPrcsYn the servcInptPrcsYn to set
 */
public void setServcInptPrcsYn(java.lang.String servcInptPrcsYn) {
	this.servcInptPrcsYn = servcInptPrcsYn;
}

/**
 * Comment : 
 * @fn java.lang.String getYrtxInptPrcsYn()
 * @brief date:2017 2017. 1. 23. user:atres-pc
 * @return the yrtxInptPrcsYn get
 */
public java.lang.String getYrtxInptPrcsYn() {
	return yrtxInptPrcsYn;
}

/**
 * Comment : 
 *@fn void setYrtxInptPrcsYn(java.lang.String yrtxInptPrcsYn)
 *@brief date:2017 2017. 1. 23. user:atres-pc
 *@param yrtxInptPrcsYn the yrtxInptPrcsYn to set
 */
public void setYrtxInptPrcsYn(java.lang.String yrtxInptPrcsYn) {
	this.yrtxInptPrcsYn = yrtxInptPrcsYn;
}

/**
 * Comment : 
 * @fn java.lang.String getShttmInsnYn()
 * @brief date:2017 2017. 1. 23. user:atres-pc
 * @return the shttmInsnYn get
 */
public java.lang.String getShttmInsnYn() {
	return shttmInsnYn;
}

/**
 * Comment : 
 *@fn void setShttmInsnYn(java.lang.String shttmInsnYn)
 *@brief date:2017 2017. 1. 23. user:atres-pc
 *@param shttmInsnYn the shttmInsnYn to set
 */
public void setShttmInsnYn(java.lang.String shttmInsnYn) {
	this.shttmInsnYn = shttmInsnYn;
}

/**
 * Comment : 
 * @fn java.lang.String getUsrAuthDivCd()
 * @brief date:2017 2017. 1. 23. user:atres-pc
 * @return the usrAuthDivCd get
 */
public java.lang.String getUsrAuthDivCd() {
	return usrAuthDivCd;
}

/**
 * Comment : 
 *@fn void setUsrAuthDivCd(java.lang.String usrAuthDivCd)
 *@brief date:2017 2017. 1. 23. user:atres-pc
 *@param usrAuthDivCd the usrAuthDivCd to set
 */
public void setUsrAuthDivCd(java.lang.String usrAuthDivCd) {
	this.usrAuthDivCd = usrAuthDivCd;
}

	public java.lang.String getSysDivNm() {
    return sysDivNm;
}

public void setSysDivNm(java.lang.String sysDivNm) {
    this.sysDivNm = sysDivNm;
}

public java.lang.String getBusinDivNm() {
    return businDivNm;
}

public void setBusinDivNm(java.lang.String businDivNm) {
    this.businDivNm = businDivNm;
}

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

	/**
	 * @return the appWebConn
	 */
	public java.lang.String getAppWebConn() {
		return appWebConn;
	}

	/**
	 * @param appWebConn the appWebConn to set
	 */
	public void setAppWebConn(java.lang.String appWebConn) {
		this.appWebConn = appWebConn;
	}

	/**
	 * Comment : 고용구분코드
	 * @fn java.lang.String getEmymtDivCd()
	 * @brief date:2017 2017. 10. 16. user:atres
	 * @return the emymtDivCd get
	 */
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	/**
	 * Comment : 고용구분코드
	 *@fn void setEmymtDivCd(java.lang.String emymtDivCd)
	 *@brief date:2017 2017. 10. 16. user:atres
	 *@param emymtDivCd the emymtDivCd to set
	 */
	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	/**
	 * Comment : 고용구분명
	 * @fn java.lang.String getEmymtDivNm()
	 * @brief date:2017 2017. 10. 16. user:atres
	 * @return the emymtDivNm get
	 */
	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}

	/**
	 * Comment : 고용구분명
	 *@fn void setEmymtDivNm(java.lang.String emymtDivNm)
	 *@brief date:2017 2017. 10. 16. user:atres
	 *@param emymtDivNm the emymtDivNm to set
	 */
	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

 
    
    
}
