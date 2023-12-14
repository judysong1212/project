package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.io.Serializable;

/**
 * @Class Name : SsoxUserVO.java
 * @Description : SsoxUser VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.08.28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SsoxIfUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** USER_ID */
    private java.lang.String userId;

    //#sso 사용여부 확인을 위한 설정값  SSOX, NONE 설정 
    private java.lang.String  ssoUseType ;
    
    /** USER_NAME */
    private java.lang.String userName;
    
    /** USER_SN */
    private java.lang.String userSn;
    
    /** USER_STAT */
    private java.lang.String userStat;
    
    /** USER_STAT_NAME */
    private java.lang.String userStatName;
    
    /** REGULARITY */
    private java.lang.String regularity;
    
    /** ORG_ID */
    private java.lang.String orgId;
    
    /** ORG_NAME */
    private java.lang.String orgName;
    
    /** DEPT_ID */
    private java.lang.String deptId;
    
    /** DEPT_NAME */
    private java.lang.String deptName;
    
    /** DEPT_FULLNAME */
    private java.lang.String deptFullname;
    
    /** CLASS_ID */
    private java.lang.String classId;
    
    /** CLASS_NAME */
    private java.lang.String className;
    
    /** POSITION_ID */
    private java.lang.String positionId;
    
    /** POSITION_NAME */
    private java.lang.String positionName;
    
    /** GRADE_ID */
    private java.lang.String gradeId;
    
    /** GRADE_NAME */
    private java.lang.String gradeName;
    
    /** EMAIL */
    private java.lang.String email;
    
    /** TEL */
    private java.lang.String tel;
    
    /** MOBILE */
    private java.lang.String mobile;
    
    /** JOIN_DAY */
    private java.lang.String joinDay;
    
    /** RETIRE_DAY */
    private java.lang.String retireDay;
    
    /** ADD_INFO1 */
    private java.lang.String addInfo1;
    
    /** ADD_INFO2 */
    private java.lang.String addInfo2;
    
    /** ADD_INFO3 */
    private java.lang.String addInfo3;
    
    /** ADD_INFO4 */
    private java.lang.String addInfo4;
    
    /** ADD_INFO5 */
    private java.lang.String addInfo5;
    
    /** ADD_INFO6 */
    private java.lang.String addInfo6;
    
    /** ADD_INFO7 */
    private java.lang.String addInfo7;
    
    /** BASE_SYS */
    private java.lang.String baseSys;
    
    /** REG_DAY */
    private java.lang.String regDay;
    
    /** UPDATE_DAY */
    private java.lang.String updateDay;
    
    /** USE_YN */
    private java.lang.String useYn;
    
    /** RDUTY_NAME */
    private java.lang.String rdutyName;
    
    public java.lang.String getUserId() {
        return this.userId;
    }
    
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
    
    public java.lang.String getUserName() {
        return this.userName;
    }
    
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }
    
    public java.lang.String getUserSn() {
        return this.userSn;
    }
    
    public void setUserSn(java.lang.String userSn) {
        this.userSn = userSn;
    }
    
    public java.lang.String getUserStat() {
        return this.userStat;
    }
    
    public void setUserStat(java.lang.String userStat) {
        this.userStat = userStat;
    }
    
    public java.lang.String getUserStatName() {
        return this.userStatName;
    }
    
    public void setUserStatName(java.lang.String userStatName) {
        this.userStatName = userStatName;
    }
    
    public java.lang.String getRegularity() {
        return this.regularity;
    }
    
    public void setRegularity(java.lang.String regularity) {
        this.regularity = regularity;
    }
    
    public java.lang.String getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(java.lang.String orgId) {
        this.orgId = orgId;
    }
    
    public java.lang.String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }
    
    public java.lang.String getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(java.lang.String deptId) {
        this.deptId = deptId;
    }
    
    public java.lang.String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(java.lang.String deptName) {
        this.deptName = deptName;
    }
    
    public java.lang.String getDeptFullname() {
        return this.deptFullname;
    }
    
    public void setDeptFullname(java.lang.String deptFullname) {
        this.deptFullname = deptFullname;
    }
    
    public java.lang.String getClassId() {
        return this.classId;
    }
    
    public void setClassId(java.lang.String classId) {
        this.classId = classId;
    }
    
    public java.lang.String getClassName() {
        return this.className;
    }
    
    public void setClassName(java.lang.String className) {
        this.className = className;
    }
    
    public java.lang.String getPositionId() {
        return this.positionId;
    }
    
    public void setPositionId(java.lang.String positionId) {
        this.positionId = positionId;
    }
    
    public java.lang.String getPositionName() {
        return this.positionName;
    }
    
    public void setPositionName(java.lang.String positionName) {
        this.positionName = positionName;
    }
    
    public java.lang.String getGradeId() {
        return this.gradeId;
    }
    
    public void setGradeId(java.lang.String gradeId) {
        this.gradeId = gradeId;
    }
    
    public java.lang.String getGradeName() {
        return this.gradeName;
    }
    
    public void setGradeName(java.lang.String gradeName) {
        this.gradeName = gradeName;
    }
    
    public java.lang.String getEmail() {
        return this.email;
    }
    
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    public java.lang.String getTel() {
        return this.tel;
    }
    
    public void setTel(java.lang.String tel) {
        this.tel = tel;
    }
    
    public java.lang.String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }
    
    public java.lang.String getJoinDay() {
        return this.joinDay;
    }
    
    public void setJoinDay(java.lang.String joinDay) {
        this.joinDay = joinDay;
    }
    
    public java.lang.String getRetireDay() {
        return this.retireDay;
    }
    
    public void setRetireDay(java.lang.String retireDay) {
        this.retireDay = retireDay;
    }
    
    public java.lang.String getAddInfo1() {
        return this.addInfo1;
    }
    
    public void setAddInfo1(java.lang.String addInfo1) {
        this.addInfo1 = addInfo1;
    }
    
    public java.lang.String getAddInfo2() {
        return this.addInfo2;
    }
    
    public void setAddInfo2(java.lang.String addInfo2) {
        this.addInfo2 = addInfo2;
    }
    
    public java.lang.String getAddInfo3() {
        return this.addInfo3;
    }
    
    public void setAddInfo3(java.lang.String addInfo3) {
        this.addInfo3 = addInfo3;
    }
    
    public java.lang.String getAddInfo4() {
        return this.addInfo4;
    }
    
    public void setAddInfo4(java.lang.String addInfo4) {
        this.addInfo4 = addInfo4;
    }
    
    public java.lang.String getAddInfo5() {
        return this.addInfo5;
    }
    
    public void setAddInfo5(java.lang.String addInfo5) {
        this.addInfo5 = addInfo5;
    }
    
    public java.lang.String getAddInfo6() {
        return this.addInfo6;
    }
    
    public void setAddInfo6(java.lang.String addInfo6) {
        this.addInfo6 = addInfo6;
    }
    
    public java.lang.String getAddInfo7() {
        return this.addInfo7;
    }
    
    public void setAddInfo7(java.lang.String addInfo7) {
        this.addInfo7 = addInfo7;
    }
    
    public java.lang.String getBaseSys() {
        return this.baseSys;
    }
    
    public void setBaseSys(java.lang.String baseSys) {
        this.baseSys = baseSys;
    }
    
    public java.lang.String getRegDay() {
        return this.regDay;
    }
    
    public void setRegDay(java.lang.String regDay) {
        this.regDay = regDay;
    }
    
    public java.lang.String getUpdateDay() {
        return this.updateDay;
    }
    
    public void setUpdateDay(java.lang.String updateDay) {
        this.updateDay = updateDay;
    }
    
    public java.lang.String getUseYn() {
        return this.useYn;
    }
    
    public void setUseYn(java.lang.String useYn) {
        this.useYn = useYn;
    }
    
    public java.lang.String getRdutyName() {
        return this.rdutyName;
    }
    
    public void setRdutyName(java.lang.String rdutyName) {
        this.rdutyName = rdutyName;
    }

	/**
	 * Comment : 
	 * @fn java.lang.String getSsoUseType()
	 * @brief date:2017 2017. 6. 1. user:atres
	 * @return the ssoUseType get
	 */
	public java.lang.String getSsoUseType() {
		return ssoUseType;
	}

	/**
	 * Comment : 
	 *@fn void setSsoUseType(java.lang.String ssoUseType)
	 *@brief date:2017 2017. 6. 1. user:atres
	 *@param ssoUseType the ssoUseType to set
	 */
	public void setSsoUseType(java.lang.String ssoUseType) {
		this.ssoUseType = ssoUseType;
	}
    
}
