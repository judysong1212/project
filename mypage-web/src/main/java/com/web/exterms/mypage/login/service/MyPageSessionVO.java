package com.web.exterms.mypage.login.service;

import java.io.Serializable;

/**
 * 세션 VO 클래스
 * @author kyumin.jang
 * @since 2017.07.03
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      		수정자          	수정내용
 *  -------   	 --------    	---------------------------
 *  2017.07.03  kyumin.jang      최초 생성 
 *  
 *  </pre>
 */
public class MyPageSessionVO implements Serializable {
	
	private static final long serialVersionUID = -1535780465453029845L;
		
	/** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** USR_NM */
    private java.lang.String usrNm;
    
    /** USR_DIV_CD */
    private java.lang.String usrDivCd;
    
    /** USR_TEL */
    private java.lang.String usrTel;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** CURR_AFFN_DEPT_CD */
    private java.lang.String currAffnDeptCd;
    
    /** EMAIL */
    private java.lang.String email;
    
    /** PWD */
    private java.lang.String pwd;
    
    /** PWD */
    private java.lang.String newPwd;
    
    /** USE_YN */
    private java.lang.String useYn;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.sql.Date revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    /** SAVE_ID */
    private java.lang.String saveId;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNumSch;
    
    /** HUS_PHN_NUM */
    private java.lang.String husPhnNum;    
	
    /** CURR_AFFN_DEPT_NM */
    private java.lang.String currAffnDeptNm;
    
    /** EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** EMYMT_DIV_NM */
    private java.lang.String emymtDivNm;    
    
    /** HAN_NM */
    private java.lang.String hanNm;    
    
    /** EMAIL_ADDR */    
    private java.lang.String emailAddr;
    
    /** CHK_USER_ID */    
    private java.lang.String chkUserId;
    
    /** CURR_DEPT_NM */  
    private java.lang.String currDeptNm;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** USR_BF_PWD */
    private java.lang.String usrBfPwd;
    
    /** USR_CHG_PWD */
    private java.lang.String usrChgPwd;
    
	/** USR_PWD_CHG_DTTM */
    private java.lang.String usrPwdChgDttm;
    
    /** USR_ERR_LGN_CNT */
    private java.math.BigDecimal usrErrLgnCnt;
    
    /** USR_ERR_LGN_DTTM */
    private java.lang.String usrErrLgnDttm;
    
    /** USR_LGN_SESN */
    private java.lang.String usrLgnSesn;
    
    /** USR_LGN_CHK_DTTM */
    private java.lang.String usrLgnChkDttm;   
    
    /** USR_LGN_ACC_LCK_YN */
    private java.lang.String usrLgnAccLckYn;
    
    /** USR_LGN_ACC_LCK_YN */
    private java.lang.String chkNum;
	
	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}
	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}
	public java.lang.String getUsrId() {
		return usrId;
	}
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}
	public java.lang.String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(java.lang.String usrNm) {
		this.usrNm = usrNm;
	}
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}
	public java.lang.String getSystemkey() {
		return systemkey;
	}
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}
	public java.lang.String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getPwd() {
		return pwd;
	}
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}
	public java.lang.String getUseYn() {
		return useYn;
	}
	public void setUseYn(java.lang.String useYn) {
		this.useYn = useYn;
	}
	public java.lang.String getKybdr() {
		return kybdr;
	}
	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}
	public java.sql.Date getInptDt() {
		return inptDt;
	}
	public void setInptDt(java.sql.Date inptDt) {
		this.inptDt = inptDt;
	}
	public java.lang.String getInptAddr() {
		return inptAddr;
	}
	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}
	public java.lang.String getIsmt() {
		return ismt;
	}
	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}
	public java.sql.Date getRevnDt() {
		return revnDt;
	}
	public void setRevnDt(java.sql.Date revnDt) {
		this.revnDt = revnDt;
	}
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}
	public java.lang.String getSaveId() {
		return saveId;
	}
	public void setSaveId(java.lang.String saveId) {
		this.saveId = saveId;
	}
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}
	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}
	public java.lang.String getResnRegnNumSch() {
		return resnRegnNumSch;
	}
	public void setResnRegnNumSch(java.lang.String resnRegnNumSch) {
		this.resnRegnNumSch = resnRegnNumSch;
	}
	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}
	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}
	public java.lang.String getHusPhnNum() {
		return husPhnNum;
	}
	public void setHusPhnNum(java.lang.String husPhnNum) {
		this.husPhnNum = husPhnNum;
	}
	public java.lang.String getCurrAffnDeptNm() {
		return currAffnDeptNm;
	}
	public void setCurrAffnDeptNm(java.lang.String currAffnDeptNm) {
		this.currAffnDeptNm = currAffnDeptNm;
	}
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}
	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}
	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}
	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}
	public java.lang.String getHanNm() {
		return hanNm;
	}
	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}
	public java.lang.String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(java.lang.String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public java.lang.String getChkUserId() {
		return chkUserId;
	}
	public void setChkUserId(java.lang.String chkUserId) {
		this.chkUserId = chkUserId;
	}
	public java.lang.String getCurrDeptNm() {
		return currDeptNm;
	}
	public void setCurrDeptNm(java.lang.String currDeptNm) {
		this.currDeptNm = currDeptNm;
	}
	public java.lang.String getDpobCd() {
		return dpobCd;
	}
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}
	public java.lang.String getUsrTel() {
		return usrTel;
	}
	public void setUsrTel(java.lang.String usrTel) {
		this.usrTel = usrTel;
	}
	public java.lang.String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(java.lang.String newPwd) {
		this.newPwd = newPwd;
	}
	public java.lang.String getUsrBfPwd() {
		return usrBfPwd;
	}
	public void setUsrBfPwd(java.lang.String usrBfPwd) {
		this.usrBfPwd = usrBfPwd;
	}
	public java.lang.String getUsrChgPwd() {
		return usrChgPwd;
	}
	public void setUsrChgPwd(java.lang.String usrChgPwd) {
		this.usrChgPwd = usrChgPwd;
	}
	public java.lang.String getUsrPwdChgDttm() {
		return usrPwdChgDttm;
	}
	public void setUsrPwdChgDttm(java.lang.String usrPwdChgDttm) {
		this.usrPwdChgDttm = usrPwdChgDttm;
	}
	public java.math.BigDecimal getUsrErrLgnCnt() {
		return usrErrLgnCnt;
	}
	public void setUsrErrLgnCnt(java.math.BigDecimal usrErrLgnCnt) {
		this.usrErrLgnCnt = usrErrLgnCnt;
	}
	public java.lang.String getUsrErrLgnDttm() {
		return usrErrLgnDttm;
	}
	public void setUsrErrLgnDttm(java.lang.String usrErrLgnDttm) {
		this.usrErrLgnDttm = usrErrLgnDttm;
	}
	public java.lang.String getUsrLgnSesn() {
		return usrLgnSesn;
	}
	public void setUsrLgnSesn(java.lang.String usrLgnSesn) {
		this.usrLgnSesn = usrLgnSesn;
	}
	public java.lang.String getUsrLgnChkDttm() {
		return usrLgnChkDttm;
	}
	public void setUsrLgnChkDttm(java.lang.String usrLgnChkDttm) {
		this.usrLgnChkDttm = usrLgnChkDttm;
	}
	public java.lang.String getUsrLgnAccLckYn() {
		return usrLgnAccLckYn;
	}
	public void setUsrLgnAccLckYn(java.lang.String usrLgnAccLckYn) {
		this.usrLgnAccLckYn = usrLgnAccLckYn;
	}
	public java.lang.String getChkNum() {
		return chkNum;
	}
	public void setChkNum(java.lang.String chkNum) {
		this.chkNum = chkNum;
	}
}
