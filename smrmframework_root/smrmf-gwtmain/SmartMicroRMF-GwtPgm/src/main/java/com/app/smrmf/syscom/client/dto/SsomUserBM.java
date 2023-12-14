package com.app.smrmf.syscom.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

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
public class SsomUserBM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
   


    public static final String ATTR_SSOUSETYPE = "ssoUseType";
   
    /** set null : nid */
    public static final String ATTR_NID = "nid";

    /** set null : cn */
    public static final String ATTR_CN = "cn";

    /** set null : ou */
    public static final String ATTR_OU = "ou";

    /** set null : oucode */
    public static final String ATTR_OUCODE = "oucode";

    /** set null : parentoucode */
    public static final String ATTR_PARENTOUCODE = "parentoucode";

    /** set null : topoucode */
    public static final String ATTR_TOPOUCODE = "topoucode";

    /** set null : uidM */
    public static final String ATTR_UIDM = "uidM";

    /** set null : displayname */
    public static final String ATTR_DISPLAYNAME = "displayname";

    /** set null : description */
    public static final String ATTR_DESCRIPTION = "description";

    /** set null : userfullname */
    public static final String ATTR_USERFULLNAME = "userfullname";

    /** set null : givenname */
    public static final String ATTR_GIVENNAME = "givenname";

    /** set null : positioncode */
    public static final String ATTR_POSITIONCODE = "positioncode";

    /** set null : position */
    public static final String ATTR_POSITION = "position";

    /** set null : titlecode */
    public static final String ATTR_TITLECODE = "titlecode";

    /** set null : title */
    public static final String ATTR_TITLE = "title";

    /** set null : titleorposition */
    public static final String ATTR_TITLEORPOSITION = "titleorposition";

    /** set null : mail */
    public static final String ATTR_MAIL = "mail";

    /** set null : othermail */
    public static final String ATTR_OTHERMAIL = "othermail";

    /** set null : telephonenumber */
    public static final String ATTR_TELEPHONENUMBER = "telephonenumber";

    /** set null : fax */
    public static final String ATTR_FAX = "fax";

    /** set null : orgfullname */
    public static final String ATTR_ORGFULLNAME = "orgfullname";

    /** set null : orderrank */
    public static final String ATTR_ORDERRANK = "orderrank";

    /** set null : homepostaladdress1 */
    public static final String ATTR_HOMEPOSTALADDRESS1 = "homepostaladdress1";

    /** set null : homepostaladdress2 */
    public static final String ATTR_HOMEPOSTALADDRESS2 = "homepostaladdress2";

    /** set null : homefaxphonenumber */
    public static final String ATTR_HOMEFAXPHONENUMBER = "homefaxphonenumber";

    /** set null : homephone */
    public static final String ATTR_HOMEPHONE = "homephone";

    /** set null : mobile */
    public static final String ATTR_MOBILE = "mobile";

    /** set null : pager */
    public static final String ATTR_PAGER = "pager";

    /** set null : jobtitle */
    public static final String ATTR_JOBTITLE = "jobtitle";

    /** set null : nickname */
    public static final String ATTR_NICKNAME = "nickname";

    /** set null : empnumber */
    public static final String ATTR_EMPNUMBER = "empnumber";

    /** set null : homepageurl */
    public static final String ATTR_HOMEPAGEURL = "homepageurl";

    /** set null : photopath */
    public static final String ATTR_PHOTOPATH = "photopath";

    /** set null : gender */
    public static final String ATTR_GENDER = "gender";

    /** set null : weddingdate */
    public static final String ATTR_WEDDINGDATE = "weddingdate";

    /** set null : birthday */
    public static final String ATTR_BIRTHDAY = "birthday";

    /** set null : carnumber */
    public static final String ATTR_CARNUMBER = "carnumber";

    /** set null : status */
    public static final String ATTR_STATUS = "status";

    /** set null : isother */
    public static final String ATTR_ISOTHER = "isother";

    /** set null : otherperiod */
    public static final String ATTR_OTHERPERIOD = "otherperiod";

    /** set null : otheroucode */
    public static final String ATTR_OTHEROUCODE = "otheroucode";

    /** set null : otherou */
    public static final String ATTR_OTHEROU = "otherou";

    /** set null : sidM */
    public static final String ATTR_SIDM = "sidM";

    /** 생성자 */
     public SsomUserBM() { super(); } 

    /** 일괄등록 처리   */
     public SsomUserBM(
    		 String  nid 
    		, String  cn 
    		, String  ou 
    		, String  oucode 
    		, String  parentoucode 
    		, String  topoucode 
    		, String  uidM 
    		, String  displayname 
    		, String  description 
    		, String  userfullname 
    		, String  givenname 
    		, String  positioncode 
    		, String  position 
    		, String  titlecode 
    		, String  title 
    		, String  titleorposition 
    		, String  mail 
    		, String  othermail 
    		, String  telephonenumber 
    		, String  fax 
    		, String  orgfullname 
    		, Long  orderrank 
    		, String  homepostaladdress1 
    		, String  homepostaladdress2 
    		, String  homefaxphonenumber 
    		, String  homephone 
    		, String  mobile 
    		, String  pager 
    		, String  jobtitle 
    		, String  nickname 
    		, String  empnumber 
    		, String  homepageurl 
    		, String  photopath 
    		, String  gender 
    		, String  weddingdate 
    		, String  birthday 
    		, String  carnumber 
    		, String  status 
    		, String  isother 
    		, String  otherperiod 
    		, String  otheroucode 
    		, String  otherou 
    		, String  sidM ) { 
     	values.put(ATTR_NID,nid);
     	values.put(ATTR_CN,cn);
     	values.put(ATTR_OU,ou);
     	values.put(ATTR_OUCODE,oucode);
     	values.put(ATTR_PARENTOUCODE,parentoucode);
     	values.put(ATTR_TOPOUCODE,topoucode);
     	values.put(ATTR_UIDM,uidM);
     	values.put(ATTR_DISPLAYNAME,displayname);
     	values.put(ATTR_DESCRIPTION,description);
     	values.put(ATTR_USERFULLNAME,userfullname);
     	values.put(ATTR_GIVENNAME,givenname);
     	values.put(ATTR_POSITIONCODE,positioncode);
     	values.put(ATTR_POSITION,position);
     	values.put(ATTR_TITLECODE,titlecode);
     	values.put(ATTR_TITLE,title);
     	values.put(ATTR_TITLEORPOSITION,titleorposition);
     	values.put(ATTR_MAIL,mail);
     	values.put(ATTR_OTHERMAIL,othermail);
     	values.put(ATTR_TELEPHONENUMBER,telephonenumber);
     	values.put(ATTR_FAX,fax);
     	values.put(ATTR_ORGFULLNAME,orgfullname);
     	values.put(ATTR_ORDERRANK,orderrank);
     	values.put(ATTR_HOMEPOSTALADDRESS1,homepostaladdress1);
     	values.put(ATTR_HOMEPOSTALADDRESS2,homepostaladdress2);
     	values.put(ATTR_HOMEFAXPHONENUMBER,homefaxphonenumber);
     	values.put(ATTR_HOMEPHONE,homephone);
     	values.put(ATTR_MOBILE,mobile);
     	values.put(ATTR_PAGER,pager);
     	values.put(ATTR_JOBTITLE,jobtitle);
     	values.put(ATTR_NICKNAME,nickname);
     	values.put(ATTR_EMPNUMBER,empnumber);
     	values.put(ATTR_HOMEPAGEURL,homepageurl);
     	values.put(ATTR_PHOTOPATH,photopath);
     	values.put(ATTR_GENDER,gender);
     	values.put(ATTR_WEDDINGDATE,weddingdate);
     	values.put(ATTR_BIRTHDAY,birthday);
     	values.put(ATTR_CARNUMBER,carnumber);
     	values.put(ATTR_STATUS,status);
     	values.put(ATTR_ISOTHER,isother);
     	values.put(ATTR_OTHERPERIOD,otherperiod);
     	values.put(ATTR_OTHEROUCODE,otheroucode);
     	values.put(ATTR_OTHEROU,otherou);
     	values.put(ATTR_SIDM,sidM); } 

    /** set null : nid */
    public void setNid(String  nid) { set( ATTR_NID ,nid);}
    /** get null : nid */
    public String  getNid() { return (String )get( ATTR_NID );}

    /** set null : cn */
    public void setCn(String  cn) { set( ATTR_CN ,cn);}
    /** get null : cn */
    public String  getCn() { return (String )get( ATTR_CN );}

    /** set null : ou */
    public void setOu(String  ou) { set( ATTR_OU ,ou);}
    /** get null : ou */
    public String  getOu() { return (String )get( ATTR_OU );}

    /** set null : oucode */
    public void setOucode(String  oucode) { set( ATTR_OUCODE ,oucode);}
    /** get null : oucode */
    public String  getOucode() { return (String )get( ATTR_OUCODE );}

    /** set null : parentoucode */
    public void setParentoucode(String  parentoucode) { set( ATTR_PARENTOUCODE ,parentoucode);}
    /** get null : parentoucode */
    public String  getParentoucode() { return (String )get( ATTR_PARENTOUCODE );}

    /** set null : topoucode */
    public void setTopoucode(String  topoucode) { set( ATTR_TOPOUCODE ,topoucode);}
    /** get null : topoucode */
    public String  getTopoucode() { return (String )get( ATTR_TOPOUCODE );}

    /** set null : uidM */
    public void setUidM(String  uidM) { set( ATTR_UIDM ,uidM);}
    /** get null : uidM */
    public String  getUidM() { return (String )get( ATTR_UIDM );}

    /** set null : displayname */
    public void setDisplayname(String  displayname) { set( ATTR_DISPLAYNAME ,displayname);}
    /** get null : displayname */
    public String  getDisplayname() { return (String )get( ATTR_DISPLAYNAME );}

    /** set null : description */
    public void setDescription(String  description) { set( ATTR_DESCRIPTION ,description);}
    /** get null : description */
    public String  getDescription() { return (String )get( ATTR_DESCRIPTION );}

    /** set null : userfullname */
    public void setUserfullname(String  userfullname) { set( ATTR_USERFULLNAME ,userfullname);}
    /** get null : userfullname */
    public String  getUserfullname() { return (String )get( ATTR_USERFULLNAME );}

    /** set null : givenname */
    public void setGivenname(String  givenname) { set( ATTR_GIVENNAME ,givenname);}
    /** get null : givenname */
    public String  getGivenname() { return (String )get( ATTR_GIVENNAME );}

    /** set null : positioncode */
    public void setPositioncode(String  positioncode) { set( ATTR_POSITIONCODE ,positioncode);}
    /** get null : positioncode */
    public String  getPositioncode() { return (String )get( ATTR_POSITIONCODE );}

    /** set null : position */
    public void setPosition(String  position) { set( ATTR_POSITION ,position);}
    /** get null : position */
    public String  getPosition() { return (String )get( ATTR_POSITION );}

    /** set null : titlecode */
    public void setTitlecode(String  titlecode) { set( ATTR_TITLECODE ,titlecode);}
    /** get null : titlecode */
    public String  getTitlecode() { return (String )get( ATTR_TITLECODE );}

    /** set null : title */
    public void setTitle(String  title) { set( ATTR_TITLE ,title);}
    /** get null : title */
    public String  getTitle() { return (String )get( ATTR_TITLE );}

    /** set null : titleorposition */
    public void setTitleorposition(String  titleorposition) { set( ATTR_TITLEORPOSITION ,titleorposition);}
    /** get null : titleorposition */
    public String  getTitleorposition() { return (String )get( ATTR_TITLEORPOSITION );}

    /** set null : mail */
    public void setMail(String  mail) { set( ATTR_MAIL ,mail);}
    /** get null : mail */
    public String  getMail() { return (String )get( ATTR_MAIL );}

    /** set null : othermail */
    public void setOthermail(String  othermail) { set( ATTR_OTHERMAIL ,othermail);}
    /** get null : othermail */
    public String  getOthermail() { return (String )get( ATTR_OTHERMAIL );}

    /** set null : telephonenumber */
    public void setTelephonenumber(String  telephonenumber) { set( ATTR_TELEPHONENUMBER ,telephonenumber);}
    /** get null : telephonenumber */
    public String  getTelephonenumber() { return (String )get( ATTR_TELEPHONENUMBER );}

    /** set null : fax */
    public void setFax(String  fax) { set( ATTR_FAX ,fax);}
    /** get null : fax */
    public String  getFax() { return (String )get( ATTR_FAX );}

    /** set null : orgfullname */
    public void setOrgfullname(String  orgfullname) { set( ATTR_ORGFULLNAME ,orgfullname);}
    /** get null : orgfullname */
    public String  getOrgfullname() { return (String )get( ATTR_ORGFULLNAME );}

    /** set null : orderrank */
    public void setOrderrank(Long  orderrank) { set( ATTR_ORDERRANK ,orderrank);}
    /** get null : orderrank */
    public Long  getOrderrank() { return (Long )get( ATTR_ORDERRANK );}

    /** set null : homepostaladdress1 */
    public void setHomepostaladdress1(String  homepostaladdress1) { set( ATTR_HOMEPOSTALADDRESS1 ,homepostaladdress1);}
    /** get null : homepostaladdress1 */
    public String  getHomepostaladdress1() { return (String )get( ATTR_HOMEPOSTALADDRESS1 );}

    /** set null : homepostaladdress2 */
    public void setHomepostaladdress2(String  homepostaladdress2) { set( ATTR_HOMEPOSTALADDRESS2 ,homepostaladdress2);}
    /** get null : homepostaladdress2 */
    public String  getHomepostaladdress2() { return (String )get( ATTR_HOMEPOSTALADDRESS2 );}

    /** set null : homefaxphonenumber */
    public void setHomefaxphonenumber(String  homefaxphonenumber) { set( ATTR_HOMEFAXPHONENUMBER ,homefaxphonenumber);}
    /** get null : homefaxphonenumber */
    public String  getHomefaxphonenumber() { return (String )get( ATTR_HOMEFAXPHONENUMBER );}

    /** set null : homephone */
    public void setHomephone(String  homephone) { set( ATTR_HOMEPHONE ,homephone);}
    /** get null : homephone */
    public String  getHomephone() { return (String )get( ATTR_HOMEPHONE );}

    /** set null : mobile */
    public void setMobile(String  mobile) { set( ATTR_MOBILE ,mobile);}
    /** get null : mobile */
    public String  getMobile() { return (String )get( ATTR_MOBILE );}

    /** set null : pager */
    public void setPager(String  pager) { set( ATTR_PAGER ,pager);}
    /** get null : pager */
    public String  getPager() { return (String )get( ATTR_PAGER );}

    /** set null : jobtitle */
    public void setJobtitle(String  jobtitle) { set( ATTR_JOBTITLE ,jobtitle);}
    /** get null : jobtitle */
    public String  getJobtitle() { return (String )get( ATTR_JOBTITLE );}

    /** set null : nickname */
    public void setNickname(String  nickname) { set( ATTR_NICKNAME ,nickname);}
    /** get null : nickname */
    public String  getNickname() { return (String )get( ATTR_NICKNAME );}

    /** set null : empnumber */
    public void setEmpnumber(String  empnumber) { set( ATTR_EMPNUMBER ,empnumber);}
    /** get null : empnumber */
    public String  getEmpnumber() { return (String )get( ATTR_EMPNUMBER );}

    /** set null : homepageurl */
    public void setHomepageurl(String  homepageurl) { set( ATTR_HOMEPAGEURL ,homepageurl);}
    /** get null : homepageurl */
    public String  getHomepageurl() { return (String )get( ATTR_HOMEPAGEURL );}

    /** set null : photopath */
    public void setPhotopath(String  photopath) { set( ATTR_PHOTOPATH ,photopath);}
    /** get null : photopath */
    public String  getPhotopath() { return (String )get( ATTR_PHOTOPATH );}

    /** set null : gender */
    public void setGender(String  gender) { set( ATTR_GENDER ,gender);}
    /** get null : gender */
    public String  getGender() { return (String )get( ATTR_GENDER );}

    /** set null : weddingdate */
    public void setWeddingdate(String  weddingdate) { set( ATTR_WEDDINGDATE ,weddingdate);}
    /** get null : weddingdate */
    public String  getWeddingdate() { return (String )get( ATTR_WEDDINGDATE );}

    /** set null : birthday */
    public void setBirthday(String  birthday) { set( ATTR_BIRTHDAY ,birthday);}
    /** get null : birthday */
    public String  getBirthday() { return (String )get( ATTR_BIRTHDAY );}

    /** set null : carnumber */
    public void setCarnumber(String  carnumber) { set( ATTR_CARNUMBER ,carnumber);}
    /** get null : carnumber */
    public String  getCarnumber() { return (String )get( ATTR_CARNUMBER );}

    /** set null : status */
    public void setStatus(String  status) { set( ATTR_STATUS ,status);}
    /** get null : status */
    public String  getStatus() { return (String )get( ATTR_STATUS );}

    /** set null : isother */
    public void setIsother(String  isother) { set( ATTR_ISOTHER ,isother);}
    /** get null : isother */
    public String  getIsother() { return (String )get( ATTR_ISOTHER );}

    /** set null : otherperiod */
    public void setOtherperiod(String  otherperiod) { set( ATTR_OTHERPERIOD ,otherperiod);}
    /** get null : otherperiod */
    public String  getOtherperiod() { return (String )get( ATTR_OTHERPERIOD );}

    /** set null : otheroucode */
    public void setOtheroucode(String  otheroucode) { set( ATTR_OTHEROUCODE ,otheroucode);}
    /** get null : otheroucode */
    public String  getOtheroucode() { return (String )get( ATTR_OTHEROUCODE );}

    /** set null : otherou */
    public void setOtherou(String  otherou) { set( ATTR_OTHEROU ,otherou);}
    /** get null : otherou */
    public String  getOtherou() { return (String )get( ATTR_OTHEROU );}

    /** set null : sidM */
    public void setSidM(String  sidM) { set( ATTR_SIDM ,sidM);}
    /** get null : sidM */
    public String  getSidM() { return (String )get( ATTR_SIDM );}


    /** set null : ssoUseType */
    public void setSsoUseType(String  ssoUseType) { set( ATTR_SSOUSETYPE ,ssoUseType);}
    /** get null : ssoUseType */
    public String  getSsoUseType() { return (String )get( ATTR_SSOUSETYPE );}
 
}
