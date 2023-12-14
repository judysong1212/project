package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

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
public class SsomIfDeptBM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set null : oucode */
    public static final String ATTR_OUCODE = "oucode";

    /** set null : ou */
    public static final String ATTR_OU = "ou";

    /** set null : topoucode */
    public static final String ATTR_TOPOUCODE = "topoucode";

    /** set null : parentoucode */
    public static final String ATTR_PARENTOUCODE = "parentoucode";

    /** set null : cn */
    public static final String ATTR_CN = "cn";

    /** set null : oudivision */
    public static final String ATTR_OUDIVISION = "oudivision";

    /** set null : orgfullname */
    public static final String ATTR_ORGFULLNAME = "orgfullname";

    /** set null : oulevel */
    public static final String ATTR_OULEVEL = "oulevel";

    /** set null : ouorder */
    public static final String ATTR_OUORDER = "ouorder";

    /** set null : engou */
    public static final String ATTR_ENGOU = "engou";

    /** set null : telephonenumber */
    public static final String ATTR_TELEPHONENUMBER = "telephonenumber";

    /** set null : ouaddress1 */
    public static final String ATTR_OUADDRESS1 = "ouaddress1";

    /** set null : ouaddress2 */
    public static final String ATTR_OUADDRESS2 = "ouaddress2";

    /** set null : ouhomepage */
    public static final String ATTR_OUHOMEPAGE = "ouhomepage";

    /** set null : oufax */
    public static final String ATTR_OUFAX = "oufax";

    /** set null : oumail */
    public static final String ATTR_OUMAIL = "oumail";

    /** set null : issidoonly */
    public static final String ATTR_ISSIDOONLY = "issidoonly";

    /** set null : status */
    public static final String ATTR_STATUS = "status";

    /** set null : sidoadduserid */
    public static final String ATTR_SIDOADDUSERID = "sidoadduserid";

    /** set null : sidoadddate */
    public static final String ATTR_SIDOADDDATE = "sidoadddate";

    /** set null : sidoaddtime */
    public static final String ATTR_SIDOADDTIME = "sidoaddtime";

    /** set null : sidochangeuserid */
    public static final String ATTR_SIDOCHANGEUSERID = "sidochangeuserid";

    /** set null : sidochangedate */
    public static final String ATTR_SIDOCHANGEDATE = "sidochangedate";

    /** set null : sidochangetime */
    public static final String ATTR_SIDOCHANGETIME = "sidochangetime";

    /** set null : isvirtual */
    public static final String ATTR_ISVIRTUAL = "isvirtual";

    /** set null : virparentoucode */
    public static final String ATTR_VIRPARENTOUCODE = "virparentoucode";

    /** 생성자 */
     public SsomIfDeptBM() { super(); } 

    /** 일괄등록 처리   */
     public SsomIfDeptBM(
    		 String  oucode 
    		, String  ou 
    		, String  topoucode 
    		, String  parentoucode 
    		, String  cn 
    		, String  oudivision 
    		, String  orgfullname 
    		, String  oulevel 
    		, String  ouorder 
    		, String  engou 
    		, String  telephonenumber 
    		, String  ouaddress1 
    		, String  ouaddress2 
    		, String  ouhomepage 
    		, String  oufax 
    		, String  oumail 
    		, String  issidoonly 
    		, String  status 
    		, String  sidoadduserid 
    		, String  sidoadddate 
    		, String  sidoaddtime 
    		, String  sidochangeuserid 
    		, String  sidochangedate 
    		, String  sidochangetime 
    		, String  isvirtual 
    		, String  virparentoucode ) { 
     	values.put(ATTR_OUCODE,oucode);
     	values.put(ATTR_OU,ou);
     	values.put(ATTR_TOPOUCODE,topoucode);
     	values.put(ATTR_PARENTOUCODE,parentoucode);
     	values.put(ATTR_CN,cn);
     	values.put(ATTR_OUDIVISION,oudivision);
     	values.put(ATTR_ORGFULLNAME,orgfullname);
     	values.put(ATTR_OULEVEL,oulevel);
     	values.put(ATTR_OUORDER,ouorder);
     	values.put(ATTR_ENGOU,engou);
     	values.put(ATTR_TELEPHONENUMBER,telephonenumber);
     	values.put(ATTR_OUADDRESS1,ouaddress1);
     	values.put(ATTR_OUADDRESS2,ouaddress2);
     	values.put(ATTR_OUHOMEPAGE,ouhomepage);
     	values.put(ATTR_OUFAX,oufax);
     	values.put(ATTR_OUMAIL,oumail);
     	values.put(ATTR_ISSIDOONLY,issidoonly);
     	values.put(ATTR_STATUS,status);
     	values.put(ATTR_SIDOADDUSERID,sidoadduserid);
     	values.put(ATTR_SIDOADDDATE,sidoadddate);
     	values.put(ATTR_SIDOADDTIME,sidoaddtime);
     	values.put(ATTR_SIDOCHANGEUSERID,sidochangeuserid);
     	values.put(ATTR_SIDOCHANGEDATE,sidochangedate);
     	values.put(ATTR_SIDOCHANGETIME,sidochangetime);
     	values.put(ATTR_ISVIRTUAL,isvirtual);
     	values.put(ATTR_VIRPARENTOUCODE,virparentoucode); } 

    /** set null : oucode */
    public void setOucode(String  oucode) { set( ATTR_OUCODE ,oucode);}
    /** get null : oucode */
    public String  getOucode() { return (String )get( ATTR_OUCODE );}

    /** set null : ou */
    public void setOu(String  ou) { set( ATTR_OU ,ou);}
    /** get null : ou */
    public String  getOu() { return (String )get( ATTR_OU );}

    /** set null : topoucode */
    public void setTopoucode(String  topoucode) { set( ATTR_TOPOUCODE ,topoucode);}
    /** get null : topoucode */
    public String  getTopoucode() { return (String )get( ATTR_TOPOUCODE );}

    /** set null : parentoucode */
    public void setParentoucode(String  parentoucode) { set( ATTR_PARENTOUCODE ,parentoucode);}
    /** get null : parentoucode */
    public String  getParentoucode() { return (String )get( ATTR_PARENTOUCODE );}

    /** set null : cn */
    public void setCn(String  cn) { set( ATTR_CN ,cn);}
    /** get null : cn */
    public String  getCn() { return (String )get( ATTR_CN );}

    /** set null : oudivision */
    public void setOudivision(String  oudivision) { set( ATTR_OUDIVISION ,oudivision);}
    /** get null : oudivision */
    public String  getOudivision() { return (String )get( ATTR_OUDIVISION );}

    /** set null : orgfullname */
    public void setOrgfullname(String  orgfullname) { set( ATTR_ORGFULLNAME ,orgfullname);}
    /** get null : orgfullname */
    public String  getOrgfullname() { return (String )get( ATTR_ORGFULLNAME );}

    /** set null : oulevel */
    public void setOulevel(String  oulevel) { set( ATTR_OULEVEL ,oulevel);}
    /** get null : oulevel */
    public String  getOulevel() { return (String )get( ATTR_OULEVEL );}

    /** set null : ouorder */
    public void setOuorder(String  ouorder) { set( ATTR_OUORDER ,ouorder);}
    /** get null : ouorder */
    public String  getOuorder() { return (String )get( ATTR_OUORDER );}

    /** set null : engou */
    public void setEngou(String  engou) { set( ATTR_ENGOU ,engou);}
    /** get null : engou */
    public String  getEngou() { return (String )get( ATTR_ENGOU );}

    /** set null : telephonenumber */
    public void setTelephonenumber(String  telephonenumber) { set( ATTR_TELEPHONENUMBER ,telephonenumber);}
    /** get null : telephonenumber */
    public String  getTelephonenumber() { return (String )get( ATTR_TELEPHONENUMBER );}

    /** set null : ouaddress1 */
    public void setOuaddress1(String  ouaddress1) { set( ATTR_OUADDRESS1 ,ouaddress1);}
    /** get null : ouaddress1 */
    public String  getOuaddress1() { return (String )get( ATTR_OUADDRESS1 );}

    /** set null : ouaddress2 */
    public void setOuaddress2(String  ouaddress2) { set( ATTR_OUADDRESS2 ,ouaddress2);}
    /** get null : ouaddress2 */
    public String  getOuaddress2() { return (String )get( ATTR_OUADDRESS2 );}

    /** set null : ouhomepage */
    public void setOuhomepage(String  ouhomepage) { set( ATTR_OUHOMEPAGE ,ouhomepage);}
    /** get null : ouhomepage */
    public String  getOuhomepage() { return (String )get( ATTR_OUHOMEPAGE );}

    /** set null : oufax */
    public void setOufax(String  oufax) { set( ATTR_OUFAX ,oufax);}
    /** get null : oufax */
    public String  getOufax() { return (String )get( ATTR_OUFAX );}

    /** set null : oumail */
    public void setOumail(String  oumail) { set( ATTR_OUMAIL ,oumail);}
    /** get null : oumail */
    public String  getOumail() { return (String )get( ATTR_OUMAIL );}

    /** set null : issidoonly */
    public void setIssidoonly(String  issidoonly) { set( ATTR_ISSIDOONLY ,issidoonly);}
    /** get null : issidoonly */
    public String  getIssidoonly() { return (String )get( ATTR_ISSIDOONLY );}

    /** set null : status */
    public void setStatus(String  status) { set( ATTR_STATUS ,status);}
    /** get null : status */
    public String  getStatus() { return (String )get( ATTR_STATUS );}

    /** set null : sidoadduserid */
    public void setSidoadduserid(String  sidoadduserid) { set( ATTR_SIDOADDUSERID ,sidoadduserid);}
    /** get null : sidoadduserid */
    public String  getSidoadduserid() { return (String )get( ATTR_SIDOADDUSERID );}

    /** set null : sidoadddate */
    public void setSidoadddate(String  sidoadddate) { set( ATTR_SIDOADDDATE ,sidoadddate);}
    /** get null : sidoadddate */
    public String  getSidoadddate() { return (String )get( ATTR_SIDOADDDATE );}

    /** set null : sidoaddtime */
    public void setSidoaddtime(String  sidoaddtime) { set( ATTR_SIDOADDTIME ,sidoaddtime);}
    /** get null : sidoaddtime */
    public String  getSidoaddtime() { return (String )get( ATTR_SIDOADDTIME );}

    /** set null : sidochangeuserid */
    public void setSidochangeuserid(String  sidochangeuserid) { set( ATTR_SIDOCHANGEUSERID ,sidochangeuserid);}
    /** get null : sidochangeuserid */
    public String  getSidochangeuserid() { return (String )get( ATTR_SIDOCHANGEUSERID );}

    /** set null : sidochangedate */
    public void setSidochangedate(String  sidochangedate) { set( ATTR_SIDOCHANGEDATE ,sidochangedate);}
    /** get null : sidochangedate */
    public String  getSidochangedate() { return (String )get( ATTR_SIDOCHANGEDATE );}

    /** set null : sidochangetime */
    public void setSidochangetime(String  sidochangetime) { set( ATTR_SIDOCHANGETIME ,sidochangetime);}
    /** get null : sidochangetime */
    public String  getSidochangetime() { return (String )get( ATTR_SIDOCHANGETIME );}

    /** set null : isvirtual */
    public void setIsvirtual(String  isvirtual) { set( ATTR_ISVIRTUAL ,isvirtual);}
    /** get null : isvirtual */
    public String  getIsvirtual() { return (String )get( ATTR_ISVIRTUAL );}

    /** set null : virparentoucode */
    public void setVirparentoucode(String  virparentoucode) { set( ATTR_VIRPARENTOUCODE ,virparentoucode);}
    /** get null : virparentoucode */
    public String  getVirparentoucode() { return (String )get( ATTR_VIRPARENTOUCODE );}
 
}
