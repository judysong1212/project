package com.app.smrmf.core.msfmainapp.client.admin.dto.system;

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
	
	/** set 패스워드 : tmpPwd */
	private java.lang.String tmpPwd;

	// 비밀번호 변경날짜, 로그인 횟수, 계정잠김여부 추가_hieju/05.25
	
	/** set 비밀번호 변경 날짜 : Pwddate */
	private java.lang.String Pwddate;
	
	/** set 로그인 횟수 : Logincnt */
	private java.lang.String Logincnt;
	
	/** set 계정잠김여부 : Lockat */
	private java.lang.String lockat;


	/** set 사용자사용여부 : useYn */
	private java.lang.String useYn;

	/** set 입력자 : kybdr */
	private java.lang.String kybdr;

	/** set 입력일자 : inptDt */
	private java.lang.String  inptDt;

	/** set 입력주소 : inptAddr */
	private java.lang.String inptAddr;

	/** set 수정자 : ismt */
	private java.lang.String ismt;

	/** set 수정일자 : revnDt */
	private java.lang.String  revnDt;

	/** set 수정주소 : revnAddr */
	private java.lang.String revnAddr;
	
    
	/** TYP_OCCU_CD */
    private java.lang.String typOccuCd; 
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
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

	public java.lang.String getPwddate() {
		return Pwddate;
	}

	public void setPwddate(java.lang.String pwddate) {
		Pwddate = pwddate;
	}

	public java.lang.String getLogincnt() {
		return Logincnt;
	}

	public void setLogincnt(java.lang.String logincnt) {
		Logincnt = logincnt;
	}

	public java.lang.String getLockat() {
		return this.lockat;
	}

	public void setLockat(java.lang.String lockat) {
		this.lockat = lockat;
		
	}
    
}
