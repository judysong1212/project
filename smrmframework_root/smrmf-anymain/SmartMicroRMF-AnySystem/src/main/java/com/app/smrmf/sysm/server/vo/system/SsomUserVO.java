package com.app.smrmf.sysm.server.vo.system;

import java.io.Serializable;

/**
 * @Class Name : SsomUserVO.java
 * @Description : SsomUser VO class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SsomUserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    //#sso 사용여부 확인을 위한 설정값  SSOX, NONE 설정  sso 사용유무 타입
    private java.lang.String  ssoUseType ;
    
    /** PWD */
    private java.lang.String pwd;  
    
    /** sso연동설정  */
    private java.lang.String ssoLinkType;
    

    /** ssoUsrId  */
    private java.lang.String ssoUsrId; 
    
    
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** USER_ID */
    private java.lang.String userId;
    
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
    
    /** MOBILE */
    private java.lang.String mobile;
    
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
    
    public java.lang.String getNid() {
        return this.nid;
    }
    
    public void setNid(java.lang.String nid) {
        this.nid = nid;
    }
    
    public java.lang.String getCn() {
        return this.cn;
    }
    
    public void setCn(java.lang.String cn) {
        this.cn = cn;
    }
    
    public java.lang.String getOu() {
        return this.ou;
    }
    
    public void setOu(java.lang.String ou) {
        this.ou = ou;
    }
    
    public java.lang.String getOucode() {
        return this.oucode;
    }
    
    public void setOucode(java.lang.String oucode) {
        this.oucode = oucode;
    }
    
    public java.lang.String getParentoucode() {
        return this.parentoucode;
    }
    
    public void setParentoucode(java.lang.String parentoucode) {
        this.parentoucode = parentoucode;
    }
    
    public java.lang.String getTopoucode() {
        return this.topoucode;
    }
    
    public void setTopoucode(java.lang.String topoucode) {
        this.topoucode = topoucode;
    }
    
    public java.lang.String getUidM() {
        return this.uidM;
    }
    
    public void setUidM(java.lang.String uidM) {
        this.uidM = uidM;
    }
    
    public java.lang.String getDisplayname() {
        return this.displayname;
    }
    
    public void setDisplayname(java.lang.String displayname) {
        this.displayname = displayname;
    }
    
    public java.lang.String getDescription() {
        return this.description;
    }
    
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    
    public java.lang.String getUserfullname() {
        return this.userfullname;
    }
    
    public void setUserfullname(java.lang.String userfullname) {
        this.userfullname = userfullname;
    }
    
    public java.lang.String getGivenname() {
        return this.givenname;
    }
    
    public void setGivenname(java.lang.String givenname) {
        this.givenname = givenname;
    }
    
    public java.lang.String getPositioncode() {
        return this.positioncode;
    }
    
    public void setPositioncode(java.lang.String positioncode) {
        this.positioncode = positioncode;
    }
    
    public java.lang.String getPosition() {
        return this.position;
    }
    
    public void setPosition(java.lang.String position) {
        this.position = position;
    }
    
    public java.lang.String getTitlecode() {
        return this.titlecode;
    }
    
    public void setTitlecode(java.lang.String titlecode) {
        this.titlecode = titlecode;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getTitleorposition() {
        return this.titleorposition;
    }
    
    public void setTitleorposition(java.lang.String titleorposition) {
        this.titleorposition = titleorposition;
    }
    
    public java.lang.String getMail() {
        return this.mail;
    }
    
    public void setMail(java.lang.String mail) {
        this.mail = mail;
    }
    
    public java.lang.String getOthermail() {
        return this.othermail;
    }
    
    public void setOthermail(java.lang.String othermail) {
        this.othermail = othermail;
    }
    
    public java.lang.String getTelephonenumber() {
        return this.telephonenumber;
    }
    
    public void setTelephonenumber(java.lang.String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }
    
    public java.lang.String getFax() {
        return this.fax;
    }
    
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }
    
    public java.lang.String getOrgfullname() {
        return this.orgfullname;
    }
    
    public void setOrgfullname(java.lang.String orgfullname) {
        this.orgfullname = orgfullname;
    }
    
    public java.math.BigDecimal getOrderrank() {
        return this.orderrank;
    }
    
    public void setOrderrank(java.math.BigDecimal orderrank) {
        this.orderrank = orderrank;
    }
    
    public java.lang.String getHomepostaladdress1() {
        return this.homepostaladdress1;
    }
    
    public void setHomepostaladdress1(java.lang.String homepostaladdress1) {
        this.homepostaladdress1 = homepostaladdress1;
    }
    
    public java.lang.String getHomepostaladdress2() {
        return this.homepostaladdress2;
    }
    
    public void setHomepostaladdress2(java.lang.String homepostaladdress2) {
        this.homepostaladdress2 = homepostaladdress2;
    }
    
    public java.lang.String getHomefaxphonenumber() {
        return this.homefaxphonenumber;
    }
    
    public void setHomefaxphonenumber(java.lang.String homefaxphonenumber) {
        this.homefaxphonenumber = homefaxphonenumber;
    }
    
    public java.lang.String getHomephone() {
        return this.homephone;
    }
    
    public void setHomephone(java.lang.String homephone) {
        this.homephone = homephone;
    }
    
    public java.lang.String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }
    
    public java.lang.String getPager() {
        return this.pager;
    }
    
    public void setPager(java.lang.String pager) {
        this.pager = pager;
    }
    
    public java.lang.String getJobtitle() {
        return this.jobtitle;
    }
    
    public void setJobtitle(java.lang.String jobtitle) {
        this.jobtitle = jobtitle;
    }
    
    public java.lang.String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(java.lang.String nickname) {
        this.nickname = nickname;
    }
    
    public java.lang.String getEmpnumber() {
        return this.empnumber;
    }
    
    public void setEmpnumber(java.lang.String empnumber) {
        this.empnumber = empnumber;
    }
    
    public java.lang.String getHomepageurl() {
        return this.homepageurl;
    }
    
    public void setHomepageurl(java.lang.String homepageurl) {
        this.homepageurl = homepageurl;
    }
    
    public java.lang.String getPhotopath() {
        return this.photopath;
    }
    
    public void setPhotopath(java.lang.String photopath) {
        this.photopath = photopath;
    }
    
    public java.lang.String getGender() {
        return this.gender;
    }
    
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }
    
    public java.lang.String getWeddingdate() {
        return this.weddingdate;
    }
    
    public void setWeddingdate(java.lang.String weddingdate) {
        this.weddingdate = weddingdate;
    }
    
    public java.lang.String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(java.lang.String birthday) {
        this.birthday = birthday;
    }
    
    public java.lang.String getCarnumber() {
        return this.carnumber;
    }
    
    public void setCarnumber(java.lang.String carnumber) {
        this.carnumber = carnumber;
    }
    
    public java.lang.String getStatus() {
        return this.status;
    }
    
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    
    public java.lang.String getIsother() {
        return this.isother;
    }
    
    public void setIsother(java.lang.String isother) {
        this.isother = isother;
    }
    
    public java.lang.String getOtherperiod() {
        return this.otherperiod;
    }
    
    public void setOtherperiod(java.lang.String otherperiod) {
        this.otherperiod = otherperiod;
    }
    
    public java.lang.String getOtheroucode() {
        return this.otheroucode;
    }
    
    public void setOtheroucode(java.lang.String otheroucode) {
        this.otheroucode = otheroucode;
    }
    
    public java.lang.String getOtherou() {
        return this.otherou;
    }
    
    public void setOtherou(java.lang.String otherou) {
        this.otherou = otherou;
    }
    
    public java.lang.String getSidM() {
        return this.sidM;
    }
    
    public void setSidM(java.lang.String sidM) {
        this.sidM = sidM;
    }

	/**
	 * Comment : 
	 * @fn java.lang.String getSysDivCd()
	 * @brief date:2018 2018. 1. 25. user:atres
	 * @return the sysDivCd get
	 */
	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSysDivCd(java.lang.String sysDivCd)
	 *@brief date:2018 2018. 1. 25. user:atres
	 *@param sysDivCd the sysDivCd to set
	 */
	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSsoUseType()
	 * @brief date:2018 2018. 1. 25. user:atres
	 * @return the ssoUseType get
	 */
	public java.lang.String getSsoUseType() {
		return ssoUseType;
	}

	/**
	 * Comment : 
	 *@fn void setSsoUseType(java.lang.String ssoUseType)
	 *@brief date:2018 2018. 1. 25. user:atres
	 *@param ssoUseType the ssoUseType to set
	 */
	public void setSsoUseType(java.lang.String ssoUseType) {
		this.ssoUseType = ssoUseType;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSsoLinkType()
	 * @brief date:2018 2018. 1. 25. user:atres
	 * @return the ssoLinkType get
	 */
	public java.lang.String getSsoLinkType() {
		return ssoLinkType;
	}

	/**
	 * Comment : 
	 *@fn void setSsoLinkType(java.lang.String ssoLinkType)
	 *@brief date:2018 2018. 1. 25. user:atres
	 *@param ssoLinkType the ssoLinkType to set
	 */
	public void setSsoLinkType(java.lang.String ssoLinkType) {
		this.ssoLinkType = ssoLinkType;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSsoUsrId()
	 * @brief date:2018 2018. 1. 25. user:atres
	 * @return the ssoUsrId get
	 */
	public java.lang.String getSsoUsrId() {
		return ssoUsrId;
	}

	/**
	 * Comment : 
	 *@fn void setSsoUsrId(java.lang.String ssoUsrId)
	 *@brief date:2018 2018. 1. 25. user:atres
	 *@param ssoUsrId the ssoUsrId to set
	 */
	public void setSsoUsrId(java.lang.String ssoUsrId) {
		this.ssoUsrId = ssoUsrId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2018 2018. 1. 25. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2018 2018. 1. 25. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPwd()
	 * @brief date:2018 2018. 1. 25. user:atres
	 * @return the pwd get
	 */
	public java.lang.String getPwd() {
		return pwd;
	}

	/**
	 * Comment : 
	 *@fn void setPwd(java.lang.String pwd)
	 *@brief date:2018 2018. 1. 25. user:atres
	 *@param pwd the pwd to set
	 */
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUserId()
	 * @brief date:2018 2018. 1. 25. user:atres
	 * @return the userId get
	 */
	public java.lang.String getUserId() {
		return userId;
	}

	/**
	 * Comment : 
	 *@fn void setUserId(java.lang.String userId)
	 *@brief date:2018 2018. 1. 25. user:atres
	 *@param userId the userId to set
	 */
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
    
	
}
