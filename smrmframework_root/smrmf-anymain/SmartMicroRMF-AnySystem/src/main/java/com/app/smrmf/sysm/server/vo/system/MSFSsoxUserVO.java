package com.app.smrmf.sysm.server.vo.system;

import java.io.Serializable;

/**
 * @Class Name : SsoxUserVO.java
 * @Description : SsoxUser VO class
 * @Modification Information
 *
 * @author s
 * @since ss
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MSFSsoxUserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
   
    
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** SSO_USR_ID */
    private java.lang.String ssoUsrId; 
    
	  /** sso 사용유무 타입 */
    private java.lang.String ssoUseType;
    
    /** sso연동설정  */
    private java.lang.String ssoLinkType;
    
    /** PWD */
    private java.lang.String pwd;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** USER_ID */
    private java.lang.String userId;
    
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
    
    /***************************************************************
     *  올레정보를 위해 추가됨 
     ***************************************************************/  
    
    /** NID */
    private java.lang.String nid;
    
    /** CN */
    private java.lang.String cn;
    
    /** OU */
    private java.lang.String ou;
    
    /** OUCODE */
    private java.lang.String oucode;
    
    /** PARENTOUCODE */
    private java.lang.String parentoucode;
    
    /** TOPOUCODE */
    private java.lang.String topoucode;
    
    /** UID_M */
    private java.lang.String uidM;
    
    /** DISPLAYNAME */
    private java.lang.String displayname;
    
    /** DESCRIPTION */
    private java.lang.String description;
    
    /** USERFULLNAME */
    private java.lang.String userfullname;
    
    /** GIVENNAME */
    private java.lang.String givenname;
    
    /** POSITIONCODE */
    private java.lang.String positioncode;
    
    /** POSITION */
    private java.lang.String position;
    
    /** TITLECODE */
    private java.lang.String titlecode;
    
    /** TITLE */
    private java.lang.String title;
    
    /** TITLEORPOSITION */
    private java.lang.String titleorposition;
    
    /** MAIL */
    private java.lang.String mail;
    
    /** OTHERMAIL */
    private java.lang.String othermail;
    
    /** TELEPHONENUMBER */
    private java.lang.String telephonenumber;
    
    /** FAX */
    private java.lang.String fax;
    
    /** ORGFULLNAME */
    private java.lang.String orgfullname;
    
    /** ORDERRANK */
    private java.math.BigDecimal orderrank;
    
    /** HOMEPOSTALADDRESS1 */
    private java.lang.String homepostaladdress1;
    
    /** HOMEPOSTALADDRESS2 */
    private java.lang.String homepostaladdress2;
    
    /** HOMEFAXPHONENUMBER */
    private java.lang.String homefaxphonenumber;
    
    /** HOMEPHONE */
    private java.lang.String homephone;
    
    
    /** PAGER */
    private java.lang.String pager;
    
    /** JOBTITLE */
    private java.lang.String jobtitle;
    
    /** NICKNAME */
    private java.lang.String nickname;
    
    /** EMPNUMBER */
    private java.lang.String empnumber;
    
    /** HOMEPAGEURL */
    private java.lang.String homepageurl;
    
    /** PHOTOPATH */
    private java.lang.String photopath;
    
    /** GENDER */
    private java.lang.String gender;
    
    /** WEDDINGDATE */
    private java.lang.String weddingdate;
    
    /** BIRTHDAY */
    private java.lang.String birthday;
    
    /** CARNUMBER */
    private java.lang.String carnumber;
    
    /** STATUS */
    private java.lang.String status;
    
    /** ISOTHER */
    private java.lang.String isother;
    
    /** OTHERPERIOD */
    private java.lang.String otherperiod;
    
    /** OTHEROUCODE */
    private java.lang.String otheroucode;
    
    /** OTHEROU */
    private java.lang.String otherou;
    
    /** SID_M */
    private java.lang.String sidM;
    
    public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

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

	public java.lang.String getSsoUsrId() {
		return ssoUsrId;
	}

	public void setSsoUsrId(java.lang.String ssoUsrId) {
		this.ssoUsrId = ssoUsrId;
	}

	public java.lang.String getSsoUseType() {
		return ssoUseType;
	}

	public void setSsoUseType(java.lang.String ssoUseType) {
		this.ssoUseType = ssoUseType;
	}

	public java.lang.String getSsoLinkType() {
		return ssoLinkType;
	}

	public void setSsoLinkType(java.lang.String ssoLinkType) {
		this.ssoLinkType = ssoLinkType;
	}

	public java.lang.String getPwd() {
		return pwd;
	}

	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNid()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the nid get
	 */
	public java.lang.String getNid() {
		return nid;
	}

	/**
	 * Comment : 
	 *@fn void setNid(java.lang.String nid)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param nid the nid to set
	 */
	public void setNid(java.lang.String nid) {
		this.nid = nid;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCn()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the cn get
	 */
	public java.lang.String getCn() {
		return cn;
	}

	/**
	 * Comment : 
	 *@fn void setCn(java.lang.String cn)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param cn the cn to set
	 */
	public void setCn(java.lang.String cn) {
		this.cn = cn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOu()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the ou get
	 */
	public java.lang.String getOu() {
		return ou;
	}

	/**
	 * Comment : 
	 *@fn void setOu(java.lang.String ou)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param ou the ou to set
	 */
	public void setOu(java.lang.String ou) {
		this.ou = ou;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOucode()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the oucode get
	 */
	public java.lang.String getOucode() {
		return oucode;
	}

	/**
	 * Comment : 
	 *@fn void setOucode(java.lang.String oucode)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param oucode the oucode to set
	 */
	public void setOucode(java.lang.String oucode) {
		this.oucode = oucode;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getParentoucode()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the parentoucode get
	 */
	public java.lang.String getParentoucode() {
		return parentoucode;
	}

	/**
	 * Comment : 
	 *@fn void setParentoucode(java.lang.String parentoucode)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param parentoucode the parentoucode to set
	 */
	public void setParentoucode(java.lang.String parentoucode) {
		this.parentoucode = parentoucode;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTopoucode()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the topoucode get
	 */
	public java.lang.String getTopoucode() {
		return topoucode;
	}

	/**
	 * Comment : 
	 *@fn void setTopoucode(java.lang.String topoucode)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param topoucode the topoucode to set
	 */
	public void setTopoucode(java.lang.String topoucode) {
		this.topoucode = topoucode;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUidM()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the uidM get
	 */
	public java.lang.String getUidM() {
		return uidM;
	}

	/**
	 * Comment : 
	 *@fn void setUidM(java.lang.String uidM)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param uidM the uidM to set
	 */
	public void setUidM(java.lang.String uidM) {
		this.uidM = uidM;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDisplayname()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the displayname get
	 */
	public java.lang.String getDisplayname() {
		return displayname;
	}

	/**
	 * Comment : 
	 *@fn void setDisplayname(java.lang.String displayname)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param displayname the displayname to set
	 */
	public void setDisplayname(java.lang.String displayname) {
		this.displayname = displayname;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDescription()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the description get
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * Comment : 
	 *@fn void setDescription(java.lang.String description)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param description the description to set
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUserfullname()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the userfullname get
	 */
	public java.lang.String getUserfullname() {
		return userfullname;
	}

	/**
	 * Comment : 
	 *@fn void setUserfullname(java.lang.String userfullname)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param userfullname the userfullname to set
	 */
	public void setUserfullname(java.lang.String userfullname) {
		this.userfullname = userfullname;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getGivenname()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the givenname get
	 */
	public java.lang.String getGivenname() {
		return givenname;
	}

	/**
	 * Comment : 
	 *@fn void setGivenname(java.lang.String givenname)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param givenname the givenname to set
	 */
	public void setGivenname(java.lang.String givenname) {
		this.givenname = givenname;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPositioncode()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the positioncode get
	 */
	public java.lang.String getPositioncode() {
		return positioncode;
	}

	/**
	 * Comment : 
	 *@fn void setPositioncode(java.lang.String positioncode)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param positioncode the positioncode to set
	 */
	public void setPositioncode(java.lang.String positioncode) {
		this.positioncode = positioncode;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPosition()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the position get
	 */
	public java.lang.String getPosition() {
		return position;
	}

	/**
	 * Comment : 
	 *@fn void setPosition(java.lang.String position)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param position the position to set
	 */
	public void setPosition(java.lang.String position) {
		this.position = position;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTitlecode()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the titlecode get
	 */
	public java.lang.String getTitlecode() {
		return titlecode;
	}

	/**
	 * Comment : 
	 *@fn void setTitlecode(java.lang.String titlecode)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param titlecode the titlecode to set
	 */
	public void setTitlecode(java.lang.String titlecode) {
		this.titlecode = titlecode;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTitle()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the title get
	 */
	public java.lang.String getTitle() {
		return title;
	}

	/**
	 * Comment : 
	 *@fn void setTitle(java.lang.String title)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param title the title to set
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTitleorposition()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the titleorposition get
	 */
	public java.lang.String getTitleorposition() {
		return titleorposition;
	}

	/**
	 * Comment : 
	 *@fn void setTitleorposition(java.lang.String titleorposition)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param titleorposition the titleorposition to set
	 */
	public void setTitleorposition(java.lang.String titleorposition) {
		this.titleorposition = titleorposition;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getMail()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the mail get
	 */
	public java.lang.String getMail() {
		return mail;
	}

	/**
	 * Comment : 
	 *@fn void setMail(java.lang.String mail)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param mail the mail to set
	 */
	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOthermail()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the othermail get
	 */
	public java.lang.String getOthermail() {
		return othermail;
	}

	/**
	 * Comment : 
	 *@fn void setOthermail(java.lang.String othermail)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param othermail the othermail to set
	 */
	public void setOthermail(java.lang.String othermail) {
		this.othermail = othermail;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTelephonenumber()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the telephonenumber get
	 */
	public java.lang.String getTelephonenumber() {
		return telephonenumber;
	}

	/**
	 * Comment : 
	 *@fn void setTelephonenumber(java.lang.String telephonenumber)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param telephonenumber the telephonenumber to set
	 */
	public void setTelephonenumber(java.lang.String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getFax()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the fax get
	 */
	public java.lang.String getFax() {
		return fax;
	}

	/**
	 * Comment : 
	 *@fn void setFax(java.lang.String fax)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param fax the fax to set
	 */
	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOrgfullname()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the orgfullname get
	 */
	public java.lang.String getOrgfullname() {
		return orgfullname;
	}

	/**
	 * Comment : 
	 *@fn void setOrgfullname(java.lang.String orgfullname)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param orgfullname the orgfullname to set
	 */
	public void setOrgfullname(java.lang.String orgfullname) {
		this.orgfullname = orgfullname;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getOrderrank()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the orderrank get
	 */
	public java.math.BigDecimal getOrderrank() {
		return orderrank;
	}

	/**
	 * Comment : 
	 *@fn void setOrderrank(java.math.BigDecimal orderrank)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param orderrank the orderrank to set
	 */
	public void setOrderrank(java.math.BigDecimal orderrank) {
		this.orderrank = orderrank;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHomepostaladdress1()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the homepostaladdress1 get
	 */
	public java.lang.String getHomepostaladdress1() {
		return homepostaladdress1;
	}

	/**
	 * Comment : 
	 *@fn void setHomepostaladdress1(java.lang.String homepostaladdress1)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param homepostaladdress1 the homepostaladdress1 to set
	 */
	public void setHomepostaladdress1(java.lang.String homepostaladdress1) {
		this.homepostaladdress1 = homepostaladdress1;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHomepostaladdress2()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the homepostaladdress2 get
	 */
	public java.lang.String getHomepostaladdress2() {
		return homepostaladdress2;
	}

	/**
	 * Comment : 
	 *@fn void setHomepostaladdress2(java.lang.String homepostaladdress2)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param homepostaladdress2 the homepostaladdress2 to set
	 */
	public void setHomepostaladdress2(java.lang.String homepostaladdress2) {
		this.homepostaladdress2 = homepostaladdress2;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHomefaxphonenumber()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the homefaxphonenumber get
	 */
	public java.lang.String getHomefaxphonenumber() {
		return homefaxphonenumber;
	}

	/**
	 * Comment : 
	 *@fn void setHomefaxphonenumber(java.lang.String homefaxphonenumber)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param homefaxphonenumber the homefaxphonenumber to set
	 */
	public void setHomefaxphonenumber(java.lang.String homefaxphonenumber) {
		this.homefaxphonenumber = homefaxphonenumber;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHomephone()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the homephone get
	 */
	public java.lang.String getHomephone() {
		return homephone;
	}

	/**
	 * Comment : 
	 *@fn void setHomephone(java.lang.String homephone)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param homephone the homephone to set
	 */
	public void setHomephone(java.lang.String homephone) {
		this.homephone = homephone;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPager()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the pager get
	 */
	public java.lang.String getPager() {
		return pager;
	}

	/**
	 * Comment : 
	 *@fn void setPager(java.lang.String pager)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param pager the pager to set
	 */
	public void setPager(java.lang.String pager) {
		this.pager = pager;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getJobtitle()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the jobtitle get
	 */
	public java.lang.String getJobtitle() {
		return jobtitle;
	}

	/**
	 * Comment : 
	 *@fn void setJobtitle(java.lang.String jobtitle)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param jobtitle the jobtitle to set
	 */
	public void setJobtitle(java.lang.String jobtitle) {
		this.jobtitle = jobtitle;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNickname()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the nickname get
	 */
	public java.lang.String getNickname() {
		return nickname;
	}

	/**
	 * Comment : 
	 *@fn void setNickname(java.lang.String nickname)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param nickname the nickname to set
	 */
	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmpnumber()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the empnumber get
	 */
	public java.lang.String getEmpnumber() {
		return empnumber;
	}

	/**
	 * Comment : 
	 *@fn void setEmpnumber(java.lang.String empnumber)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param empnumber the empnumber to set
	 */
	public void setEmpnumber(java.lang.String empnumber) {
		this.empnumber = empnumber;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHomepageurl()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the homepageurl get
	 */
	public java.lang.String getHomepageurl() {
		return homepageurl;
	}

	/**
	 * Comment : 
	 *@fn void setHomepageurl(java.lang.String homepageurl)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param homepageurl the homepageurl to set
	 */
	public void setHomepageurl(java.lang.String homepageurl) {
		this.homepageurl = homepageurl;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPhotopath()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the photopath get
	 */
	public java.lang.String getPhotopath() {
		return photopath;
	}

	/**
	 * Comment : 
	 *@fn void setPhotopath(java.lang.String photopath)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param photopath the photopath to set
	 */
	public void setPhotopath(java.lang.String photopath) {
		this.photopath = photopath;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getGender()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the gender get
	 */
	public java.lang.String getGender() {
		return gender;
	}

	/**
	 * Comment : 
	 *@fn void setGender(java.lang.String gender)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param gender the gender to set
	 */
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWeddingdate()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the weddingdate get
	 */
	public java.lang.String getWeddingdate() {
		return weddingdate;
	}

	/**
	 * Comment : 
	 *@fn void setWeddingdate(java.lang.String weddingdate)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param weddingdate the weddingdate to set
	 */
	public void setWeddingdate(java.lang.String weddingdate) {
		this.weddingdate = weddingdate;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBirthday()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the birthday get
	 */
	public java.lang.String getBirthday() {
		return birthday;
	}

	/**
	 * Comment : 
	 *@fn void setBirthday(java.lang.String birthday)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param birthday the birthday to set
	 */
	public void setBirthday(java.lang.String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCarnumber()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the carnumber get
	 */
	public java.lang.String getCarnumber() {
		return carnumber;
	}

	/**
	 * Comment : 
	 *@fn void setCarnumber(java.lang.String carnumber)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param carnumber the carnumber to set
	 */
	public void setCarnumber(java.lang.String carnumber) {
		this.carnumber = carnumber;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getStatus()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the status get
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Comment : 
	 *@fn void setStatus(java.lang.String status)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param status the status to set
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getIsother()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the isother get
	 */
	public java.lang.String getIsother() {
		return isother;
	}

	/**
	 * Comment : 
	 *@fn void setIsother(java.lang.String isother)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param isother the isother to set
	 */
	public void setIsother(java.lang.String isother) {
		this.isother = isother;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOtherperiod()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the otherperiod get
	 */
	public java.lang.String getOtherperiod() {
		return otherperiod;
	}

	/**
	 * Comment : 
	 *@fn void setOtherperiod(java.lang.String otherperiod)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param otherperiod the otherperiod to set
	 */
	public void setOtherperiod(java.lang.String otherperiod) {
		this.otherperiod = otherperiod;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOtheroucode()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the otheroucode get
	 */
	public java.lang.String getOtheroucode() {
		return otheroucode;
	}

	/**
	 * Comment : 
	 *@fn void setOtheroucode(java.lang.String otheroucode)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param otheroucode the otheroucode to set
	 */
	public void setOtheroucode(java.lang.String otheroucode) {
		this.otheroucode = otheroucode;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOtherou()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the otherou get
	 */
	public java.lang.String getOtherou() {
		return otherou;
	}

	/**
	 * Comment : 
	 *@fn void setOtherou(java.lang.String otherou)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param otherou the otherou to set
	 */
	public void setOtherou(java.lang.String otherou) {
		this.otherou = otherou;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSidM()
	 * @brief date:2018 2018. 1. 24. user:atres
	 * @return the sidM get
	 */
	public java.lang.String getSidM() {
		return sidM;
	}

	/**
	 * Comment : 
	 *@fn void setSidM(java.lang.String sidM)
	 *@brief date:2018 2018. 1. 24. user:atres
	 *@param sidM the sidM to set
	 */
	public void setSidM(java.lang.String sidM) {
		this.sidM = sidM;
	}
	
	  
    /***************************************************************
     *  올레정보를 위해 추가됨 
     ***************************************************************/ 
	
	
    
}
