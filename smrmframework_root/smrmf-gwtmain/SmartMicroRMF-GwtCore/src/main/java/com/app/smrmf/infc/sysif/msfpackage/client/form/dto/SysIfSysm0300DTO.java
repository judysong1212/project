package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.io.Serializable;

/**
 * @Class Name : Sysm0300VO.java
 * @Description : Sysm0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0300DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;

    /** set 권한그룹일련번호 : authGrpSeilNum */
    private Long authGrpSeilNum;

    /** set 시스템업무구분코드 : businDivCd */
    private java.lang.String businDivCd;

    /** set 권한그룹명 : authGrpNm */
    private java.lang.String authGrpNm;

    /** set 등급 : grde */
    private java.lang.String grde;

    /** set 권한그룹사용여부 : authGrpUseYn */
    private Boolean authGrpUseYn;

    /** set 그룹설명 : grpEpln */
    private java.lang.String grpEpln;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
 public SysIfSysm0300DTO() {
    	
    }

    public SysIfSysm0300DTO(
                String sysDivCd
              , Long authGrpSeilNum
    		  , String businDivCd
	          , String authGrpNm
	          , String grde
	          , Boolean authGrpUseYn
	          , String grpEpln
	          , String usrId) {
        this.sysDivCd = sysDivCd;
    	this.authGrpSeilNum = authGrpSeilNum;
		this.businDivCd = businDivCd;
		this.authGrpNm = authGrpNm;
		this.grde = grde;
		this.authGrpUseYn = authGrpUseYn;
		this.grpEpln = grpEpln; 
		this.usrId = usrId;
    }

    
    /**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2015 Dec 16, 2015 user:leeheuisung
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2015 Dec 16, 2015 user:leeheuisung
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public Long getAuthGrpSeilNum() {
        return this.authGrpSeilNum;
    }
    
    public void setAuthGrpSeilNum(Long authGrpSeilNum) {
        this.authGrpSeilNum = authGrpSeilNum;
    }
    
    public java.lang.String getBusinDivCd() {
        return this.businDivCd;
    }
    
    public void setBusinDivCd(java.lang.String businDivCd) {
        this.businDivCd = businDivCd;
    }
    
    public java.lang.String getAuthGrpNm() {
        return this.authGrpNm;
    }
    
    public void setAuthGrpNm(java.lang.String authGrpNm) {
        this.authGrpNm = authGrpNm;
    }
    
    public java.lang.String getGrde() {
        return this.grde;
    }
    
    public void setGrde(java.lang.String grde) {
        this.grde = grde;
    }
    
    public Boolean getAuthGrpUseYn() {
        return this.authGrpUseYn;
    }
    
    public void setAuthGrpUseYn(Boolean authGrpUseYn) {
        this.authGrpUseYn = authGrpUseYn;
    }
    
    public java.lang.String getGrpEpln() {
        return this.grpEpln;
    }
    
    public void setGrpEpln(java.lang.String grpEpln) {
        this.grpEpln = grpEpln;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
   
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
   
    
    /**
	 * Comment : 
	 * @fn java.lang.String getInptDt()
	 * @brief date:2015 Dec 16, 2015 user:leeheuisung
	 * @return the inptDt get
	 */
	public java.lang.String getInptDt() {
		return inptDt;
	}

	/**
	 * Comment : 
	 *@fn void setInptDt(java.lang.String inptDt)
	 *@brief date:2015 Dec 16, 2015 user:leeheuisung
	 *@param inptDt the inptDt to set
	 */
	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2015 Dec 16, 2015 user:leeheuisung
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}

	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2015 Dec 16, 2015 user:leeheuisung
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
}
