package com.app.smrmf.infc.sysauth.system.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Remt9000VO.java
 * @Description : Remt9000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgSysm0500VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;

    /** set 권한그룹일련번호 : authGrpSeilNum */
    private java.math.BigDecimal authGrpSeilNum;

    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;

    /** set 사용자권한사용여부 : usrAuthUseYn */
    private java.lang.String usrAuthUseYn;

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

	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}

	public java.math.BigDecimal getAuthGrpSeilNum() {
		return authGrpSeilNum;
	}

	public void setAuthGrpSeilNum(java.math.BigDecimal authGrpSeilNum) {
		this.authGrpSeilNum = authGrpSeilNum;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getUsrAuthUseYn() {
		return usrAuthUseYn;
	}

	public void setUsrAuthUseYn(java.lang.String usrAuthUseYn) {
		this.usrAuthUseYn = usrAuthUseYn;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

    
    
}
