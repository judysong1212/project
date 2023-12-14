package com.app.smrmf.sysauth.systemusr.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Sysm0100VO.java
 * @Description : Sysm0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysmUsr0100DTO  implements Serializable {
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
   	
    /** set 사용여부 : USE_YN */
   	private java.lang.String useYn;	
   	
   	/** set 계정잠김여부 : Lockat */ // 계정잠김여부 추가_hieju_06.15
	private java.lang.String lockat;
   	
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
  									
    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;   						
  		
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
    
	/** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
	/** set 생년월일 : yoobhMnthDay */
    private java.lang.String yoobhMnthDay;
    
 
    

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getYoobhMnthDay() {
		return yoobhMnthDay;
	}

	public void setYoobhMnthDay(java.lang.String yoobhMnthDay) {
		this.yoobhMnthDay = yoobhMnthDay;
	}

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

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
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

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getUsrAuthEepnYn() {
		return usrAuthEepnYn;
	}

	public void setUsrAuthEepnYn(java.lang.String usrAuthEepnYn) {
		this.usrAuthEepnYn = usrAuthEepnYn;
	}

	public java.lang.String getPyspInsnYn() {
		return pyspInsnYn;
	}

	public void setPyspInsnYn(java.lang.String pyspInsnYn) {
		this.pyspInsnYn = pyspInsnYn;
	}

	public java.lang.String getNotPyspInsnYn() {
		return notPyspInsnYn;
	}

	public void setNotPyspInsnYn(java.lang.String notPyspInsnYn) {
		this.notPyspInsnYn = notPyspInsnYn;
	}

	public java.lang.String getServcInptPrcsYn() {
		return servcInptPrcsYn;
	}

	public void setServcInptPrcsYn(java.lang.String servcInptPrcsYn) {
		this.servcInptPrcsYn = servcInptPrcsYn;
	}

	public java.lang.String getYrtxInptPrcsYn() {
		return yrtxInptPrcsYn;
	}

	public void setYrtxInptPrcsYn(java.lang.String yrtxInptPrcsYn) {
		this.yrtxInptPrcsYn = yrtxInptPrcsYn;
	}

	public java.lang.String getShttmInsnYn() {
		return shttmInsnYn;
	}

	public void setShttmInsnYn(java.lang.String shttmInsnYn) {
		this.shttmInsnYn = shttmInsnYn;
	}

	public java.lang.String getUsrAuthDivCd() {
		return usrAuthDivCd;
	}

	public void setUsrAuthDivCd(java.lang.String usrAuthDivCd) {
		this.usrAuthDivCd = usrAuthDivCd;
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

	public java.lang.String getUsrTel() {
		return usrTel;
	}

	public void setUsrTel(java.lang.String usrTel) {
		this.usrTel = usrTel;
	}

	public java.lang.String getLockat() {
		return lockat;
	}

	public void setLockat(java.lang.String lockat) {
		this.lockat = lockat;
	} 		
    
    
}
