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
public class SsoxUserBM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set null : userId */
    public static final String ATTR_USERID = "userId";

    /** set null : userName */
    public static final String ATTR_USERNAME = "userName";

    /** set null : userSn */
    public static final String ATTR_USERSN = "userSn";

    /** set null : userStat */
    public static final String ATTR_USERSTAT = "userStat";

    /** set null : userStatName */
    public static final String ATTR_USERSTATNAME = "userStatName";

    /** set null : regularity */
    public static final String ATTR_REGULARITY = "regularity";

    /** set null : orgId */
    public static final String ATTR_ORGID = "orgId";

    /** set null : orgName */
    public static final String ATTR_ORGNAME = "orgName";

    /** set null : deptId */
    public static final String ATTR_DEPTID = "deptId";

    /** set null : deptName */
    public static final String ATTR_DEPTNAME = "deptName";

    /** set null : deptFullname */
    public static final String ATTR_DEPTFULLNAME = "deptFullname";

    /** set null : classId */
    public static final String ATTR_CLASSID = "classId";

    /** set null : className */
    public static final String ATTR_CLASSNAME = "className";

    /** set null : positionId */
    public static final String ATTR_POSITIONID = "positionId";

    /** set null : positionName */
    public static final String ATTR_POSITIONNAME = "positionName";

    /** set null : gradeId */
    public static final String ATTR_GRADEID = "gradeId";

    /** set null : gradeName */
    public static final String ATTR_GRADENAME = "gradeName";

    /** set null : email */
    public static final String ATTR_EMAIL = "email";

    /** set null : tel */
    public static final String ATTR_TEL = "tel";

    /** set null : mobile */
    public static final String ATTR_MOBILE = "mobile";

    /** set null : joinDay */
    public static final String ATTR_JOINDAY = "joinDay";

    /** set null : retireDay */
    public static final String ATTR_RETIREDAY = "retireDay";

    /** set null : addInfo1 */
    public static final String ATTR_ADDINFO1 = "addInfo1";

    /** set null : addInfo2 */
    public static final String ATTR_ADDINFO2 = "addInfo2";

    /** set null : addInfo3 */
    public static final String ATTR_ADDINFO3 = "addInfo3";

    /** set null : addInfo4 */
    public static final String ATTR_ADDINFO4 = "addInfo4";

    /** set null : addInfo5 */
    public static final String ATTR_ADDINFO5 = "addInfo5";

    /** set null : addInfo6 */
    public static final String ATTR_ADDINFO6 = "addInfo6";

    /** set null : addInfo7 */
    public static final String ATTR_ADDINFO7 = "addInfo7";

    /** set null : baseSys */
    public static final String ATTR_BASESYS = "baseSys";

    /** set null : regDay */
    public static final String ATTR_REGDAY = "regDay";

    /** set null : updateDay */
    public static final String ATTR_UPDATEDAY = "updateDay";

    /** set null : useYn */
    public static final String ATTR_USEYN = "useYn";

    /** set null : rdutyName */
    public static final String ATTR_RDUTYNAME = "rdutyName";


    public static final String ATTR_SSOUSETYPE = "ssoUseType";
   
    
    /** 생성자 */
     public SsoxUserBM() { super(); } 

    /** 일괄등록 처리   */
     public SsoxUserBM(
    		 String  userId 
    		, String  userName 
    		, String  userSn 
    		, String  userStat 
    		, String  userStatName 
    		, String  regularity 
    		, String  orgId 
    		, String  orgName 
    		, String  deptId 
    		, String  deptName 
    		, String  deptFullname 
    		, String  classId 
    		, String  className 
    		, String  positionId 
    		, String  positionName 
    		, String  gradeId 
    		, String  gradeName 
    		, String  email 
    		, String  tel 
    		, String  mobile 
    		, String  joinDay 
    		, String  retireDay 
    		, String  addInfo1 
    		, String  addInfo2 
    		, String  addInfo3 
    		, String  addInfo4 
    		, String  addInfo5 
    		, String  addInfo6 
    		, String  addInfo7 
    		, String  baseSys 
    		, String  regDay 
    		, String  updateDay 
    		, String  useYn 
    		, String  rdutyName ) { 
     	values.put(ATTR_USERID,userId);
     	values.put(ATTR_USERNAME,userName);
     	values.put(ATTR_USERSN,userSn);
     	values.put(ATTR_USERSTAT,userStat);
     	values.put(ATTR_USERSTATNAME,userStatName);
     	values.put(ATTR_REGULARITY,regularity);
     	values.put(ATTR_ORGID,orgId);
     	values.put(ATTR_ORGNAME,orgName);
     	values.put(ATTR_DEPTID,deptId);
     	values.put(ATTR_DEPTNAME,deptName);
     	values.put(ATTR_DEPTFULLNAME,deptFullname);
     	values.put(ATTR_CLASSID,classId);
     	values.put(ATTR_CLASSNAME,className);
     	values.put(ATTR_POSITIONID,positionId);
     	values.put(ATTR_POSITIONNAME,positionName);
     	values.put(ATTR_GRADEID,gradeId);
     	values.put(ATTR_GRADENAME,gradeName);
     	values.put(ATTR_EMAIL,email);
     	values.put(ATTR_TEL,tel);
     	values.put(ATTR_MOBILE,mobile);
     	values.put(ATTR_JOINDAY,joinDay);
     	values.put(ATTR_RETIREDAY,retireDay);
     	values.put(ATTR_ADDINFO1,addInfo1);
     	values.put(ATTR_ADDINFO2,addInfo2);
     	values.put(ATTR_ADDINFO3,addInfo3);
     	values.put(ATTR_ADDINFO4,addInfo4);
     	values.put(ATTR_ADDINFO5,addInfo5);
     	values.put(ATTR_ADDINFO6,addInfo6);
     	values.put(ATTR_ADDINFO7,addInfo7);
     	values.put(ATTR_BASESYS,baseSys);
     	values.put(ATTR_REGDAY,regDay);
     	values.put(ATTR_UPDATEDAY,updateDay);
     	values.put(ATTR_USEYN,useYn);
     	values.put(ATTR_RDUTYNAME,rdutyName); } 

    /** set null : userId */
    public void setUserId(String  userId) { set( ATTR_USERID ,userId);}
    /** get null : userId */
    public String  getUserId() { return (String )get( ATTR_USERID );}

    /** set null : userName */
    public void setUserName(String  userName) { set( ATTR_USERNAME ,userName);}
    /** get null : userName */
    public String  getUserName() { return (String )get( ATTR_USERNAME );}

    /** set null : userSn */
    public void setUserSn(String  userSn) { set( ATTR_USERSN ,userSn);}
    /** get null : userSn */
    public String  getUserSn() { return (String )get( ATTR_USERSN );}

    /** set null : userStat */
    public void setUserStat(String  userStat) { set( ATTR_USERSTAT ,userStat);}
    /** get null : userStat */
    public String  getUserStat() { return (String )get( ATTR_USERSTAT );}

    /** set null : userStatName */
    public void setUserStatName(String  userStatName) { set( ATTR_USERSTATNAME ,userStatName);}
    /** get null : userStatName */
    public String  getUserStatName() { return (String )get( ATTR_USERSTATNAME );}

    /** set null : regularity */
    public void setRegularity(String  regularity) { set( ATTR_REGULARITY ,regularity);}
    /** get null : regularity */
    public String  getRegularity() { return (String )get( ATTR_REGULARITY );}

    /** set null : orgId */
    public void setOrgId(String  orgId) { set( ATTR_ORGID ,orgId);}
    /** get null : orgId */
    public String  getOrgId() { return (String )get( ATTR_ORGID );}

    /** set null : orgName */
    public void setOrgName(String  orgName) { set( ATTR_ORGNAME ,orgName);}
    /** get null : orgName */
    public String  getOrgName() { return (String )get( ATTR_ORGNAME );}

    /** set null : deptId */
    public void setDeptId(String  deptId) { set( ATTR_DEPTID ,deptId);}
    /** get null : deptId */
    public String  getDeptId() { return (String )get( ATTR_DEPTID );}

    /** set null : deptName */
    public void setDeptName(String  deptName) { set( ATTR_DEPTNAME ,deptName);}
    /** get null : deptName */
    public String  getDeptName() { return (String )get( ATTR_DEPTNAME );}

    /** set null : deptFullname */
    public void setDeptFullname(String  deptFullname) { set( ATTR_DEPTFULLNAME ,deptFullname);}
    /** get null : deptFullname */
    public String  getDeptFullname() { return (String )get( ATTR_DEPTFULLNAME );}

    /** set null : classId */
    public void setClassId(String  classId) { set( ATTR_CLASSID ,classId);}
    /** get null : classId */
    public String  getClassId() { return (String )get( ATTR_CLASSID );}

    /** set null : className */
    public void setClassName(String  className) { set( ATTR_CLASSNAME ,className);}
    /** get null : className */
    public String  getClassName() { return (String )get( ATTR_CLASSNAME );}

    /** set null : positionId */
    public void setPositionId(String  positionId) { set( ATTR_POSITIONID ,positionId);}
    /** get null : positionId */
    public String  getPositionId() { return (String )get( ATTR_POSITIONID );}

    /** set null : positionName */
    public void setPositionName(String  positionName) { set( ATTR_POSITIONNAME ,positionName);}
    /** get null : positionName */
    public String  getPositionName() { return (String )get( ATTR_POSITIONNAME );}

    /** set null : gradeId */
    public void setGradeId(String  gradeId) { set( ATTR_GRADEID ,gradeId);}
    /** get null : gradeId */
    public String  getGradeId() { return (String )get( ATTR_GRADEID );}

    /** set null : gradeName */
    public void setGradeName(String  gradeName) { set( ATTR_GRADENAME ,gradeName);}
    /** get null : gradeName */
    public String  getGradeName() { return (String )get( ATTR_GRADENAME );}

    /** set null : email */
    public void setEmail(String  email) { set( ATTR_EMAIL ,email);}
    /** get null : email */
    public String  getEmail() { return (String )get( ATTR_EMAIL );}

    /** set null : tel */
    public void setTel(String  tel) { set( ATTR_TEL ,tel);}
    /** get null : tel */
    public String  getTel() { return (String )get( ATTR_TEL );}

    /** set null : mobile */
    public void setMobile(String  mobile) { set( ATTR_MOBILE ,mobile);}
    /** get null : mobile */
    public String  getMobile() { return (String )get( ATTR_MOBILE );}

    /** set null : joinDay */
    public void setJoinDay(String  joinDay) { set( ATTR_JOINDAY ,joinDay);}
    /** get null : joinDay */
    public String  getJoinDay() { return (String )get( ATTR_JOINDAY );}

    /** set null : retireDay */
    public void setRetireDay(String  retireDay) { set( ATTR_RETIREDAY ,retireDay);}
    /** get null : retireDay */
    public String  getRetireDay() { return (String )get( ATTR_RETIREDAY );}

    /** set null : addInfo1 */
    public void setAddInfo1(String  addInfo1) { set( ATTR_ADDINFO1 ,addInfo1);}
    /** get null : addInfo1 */
    public String  getAddInfo1() { return (String )get( ATTR_ADDINFO1 );}

    /** set null : addInfo2 */
    public void setAddInfo2(String  addInfo2) { set( ATTR_ADDINFO2 ,addInfo2);}
    /** get null : addInfo2 */
    public String  getAddInfo2() { return (String )get( ATTR_ADDINFO2 );}

    /** set null : addInfo3 */
    public void setAddInfo3(String  addInfo3) { set( ATTR_ADDINFO3 ,addInfo3);}
    /** get null : addInfo3 */
    public String  getAddInfo3() { return (String )get( ATTR_ADDINFO3 );}

    /** set null : addInfo4 */
    public void setAddInfo4(String  addInfo4) { set( ATTR_ADDINFO4 ,addInfo4);}
    /** get null : addInfo4 */
    public String  getAddInfo4() { return (String )get( ATTR_ADDINFO4 );}

    /** set null : addInfo5 */
    public void setAddInfo5(String  addInfo5) { set( ATTR_ADDINFO5 ,addInfo5);}
    /** get null : addInfo5 */
    public String  getAddInfo5() { return (String )get( ATTR_ADDINFO5 );}

    /** set null : addInfo6 */
    public void setAddInfo6(String  addInfo6) { set( ATTR_ADDINFO6 ,addInfo6);}
    /** get null : addInfo6 */
    public String  getAddInfo6() { return (String )get( ATTR_ADDINFO6 );}

    /** set null : addInfo7 */
    public void setAddInfo7(String  addInfo7) { set( ATTR_ADDINFO7 ,addInfo7);}
    /** get null : addInfo7 */
    public String  getAddInfo7() { return (String )get( ATTR_ADDINFO7 );}

    /** set null : baseSys */
    public void setBaseSys(String  baseSys) { set( ATTR_BASESYS ,baseSys);}
    /** get null : baseSys */
    public String  getBaseSys() { return (String )get( ATTR_BASESYS );}

    /** set null : regDay */
    public void setRegDay(String  regDay) { set( ATTR_REGDAY ,regDay);}
    /** get null : regDay */
    public String  getRegDay() { return (String )get( ATTR_REGDAY );}

    /** set null : updateDay */
    public void setUpdateDay(String  updateDay) { set( ATTR_UPDATEDAY ,updateDay);}
    /** get null : updateDay */
    public String  getUpdateDay() { return (String )get( ATTR_UPDATEDAY );}

    /** set null : useYn */
    public void setUseYn(Boolean  useYn) { set( ATTR_USEYN ,useYn);}
    /** get null : useYn */
    public Boolean  getUseYn() { return (Boolean )get( ATTR_USEYN );}

    /** set null : rdutyName */
    public void setRdutyName(String  rdutyName) { set( ATTR_RDUTYNAME ,rdutyName);}
    /** get null : rdutyName */
    public String  getRdutyName() { return (String )get( ATTR_RDUTYNAME );}

    /** set null : ssoUseType */
    public void setSsoUseType(String  ssoUseType) { set( ATTR_SSOUSETYPE ,ssoUseType);}
    /** get null : ssoUseType */
    public String  getSsoUseType() { return (String )get( ATTR_SSOUSETYPE );}
 
}
