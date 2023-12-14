/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto.system; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.sql.NUMBER;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Sysm0100VO.java
 * @Description : Sysm0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MSFSysm0100BM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
     
    private static final String ATTR_DPOBCD          = "dpobCd";        //사업장코드
    private static final String ATTR_SYS_DIV_CD      = "sysDivCd";      //시스템코드
    private static final String ATTR_SYS_DIV_NM      = "sysDivNm";      //시스템
    private static final String ATTR_USR_ID     		= "usrId";
    private static final String ATTR_USR_NM          = "usrNm";
    private static final String ATTR_USR_DIV_CD      = "usrDivCd";
    private static final String ATTR_USR_DIV_NM     = "usrDivNm";
    private static final String ATTR_DEPT_CD      = "deptCd";
    private static final String ATTR_DEPT_NM      = "deptNm";
//    /** set 직종코드 : typOccuCd */
//    public static final String ATTR_TYPOCCUCD = "typOccuCd"; 
//    public static final String ATTR_TYPOCCUNM = "typOccuNm"; 
//    /** set 호봉등급코드 : pyspGrdeCd */
//   public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
//    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
 
    private static final String ATTR_USR_TEL          = "usrTel"; 
    private static final String ATTR_PAYRMANGDEPTCD   = "payrMangDeptCd";
    private static final String ATTR_PAYRMANGDEPTNM   = "payrMangDeptNm";
    private static final String ATTR_MANGEDEPTCD      = "mangeDeptCd";
    private static final String ATTR_MANGEDEPTNM      = "mangeDeptNm";
    private static final String ATTR_PAYRMANGDEPTYN   = "payrMangDeptYn";
    
    
 // lockat, pwddate, logincnt, inptDt 추가_hieju_05.26
    private static final String ATTR_LOCKAT = "lockat"; 
	private static final String ATTR_PWD_DATE = "pwddate"; 
    private static final String ATTR_LOGINCNT = "logincnt"; 
    private static final String ATTR_INPT_DT = "inptDt"; 
    
    
    
    
    

		/** set 사용자권한제외여부 : usrAuthEepnYn */
		public static final String ATTR_USRAUTHEEPNYN = "usrAuthEepnYn";
		
		/** set 호봉제포함여부 : pyspInsnYn */
		public static final String ATTR_PYSPINSNYN = "pyspInsnYn";
		
		/** set 비호봉제포함여부 : notPyspInsnYn */
		public static final String ATTR_NOTPYSPINSNYN = "notPyspInsnYn";
		
		/** set 복무입력처리여부 : servcInptPrcsYn */
		public static final String ATTR_SERVCINPTPRCSYN = "servcInptPrcsYn";
		
		/** set 연말정산입력처리여부 : yrtxInptPrcsYn */
		public static final String ATTR_YRTXINPTPRCSYN = "yrtxInptPrcsYn";
		
		/** set 기간제포함여부 : shttmInsnYn */
		public static final String ATTR_SHTTMINSNYN = "shttmInsnYn";
		
		/** set 사용자권한구분코드 : usrAuthDivCd */
		public static final String ATTR_USRAUTHDIVCD = "usrAuthDivCd";
		

    private static final String ATTR_EMAIL            = "email";
    private static final String ATTR_PWD              = "pwd";
    private static final String ATTR_USE_YN           = "useYn";

    
    private static final String ATTR_TPLVLDEPTCD      = "tplvlDeptCd";
    private static final String ATTR_TPLVLDEPTNM      = "tplvlDeptNm"; 
    
    
    private static final String ATTR_SYSM0300_LIST    = "msfSysm0300List";   //TODO 권한정보 처리 
    private static final String ATTR_USER_INFO        = "userInfo";       //TODO 로그인사용자 설정정보 
    private static final String ATTR_SSOXUSER         = "ssoxUser";        //TODO sso user info
    private static final String ATTR_USER_AUTH        = "userAuth";        //TODO sso user info
    

    public static final String ATTR_SSOUSETYPE = "ssoUseType";
   
    
    public MSFSysm0100BM() {
        super();
    }
    
    // lockat, pwddate, logincnt, inptDt 추가_hieju_06.09
    public MSFSysm0100BM(
    		String dpobCd,
            String sysDivCd,  
            String sysDivNm,  
            String usrId,
            String usrNm,
            String usrDivCd,
            String usrDivNm,
            String deptCd,
            String deptNm,
//            String  typOccuCd ,
//            String  typOccuNm ,
//            String  pyspGrdeCd ,
//            String  pyspGrdeNm ,
            String usrTel,
            String tplvlDeptCd,
            String tplvlDeptNm,
            String payrMangDeptCd,
            String payrMangDeptNm,
            String mangeDeptCd,
            String mangeDeptNm,
            String payrMangDeptYn, 
            String yrtxInptPrcsYn,
            String email, 
            String pwd, 
            String useYn,
            String lockat,
            String pwddate,
            String logincnt,
            String inptDt) {
        this(dpobCd,sysDivCd,sysDivNm, usrId, usrNm
                , usrDivCd,usrDivNm,deptCd,deptNm,
               // typOccuCd ,typOccuNm ,pyspGrdeCd 
               // ,pyspGrdeNm ,
                usrTel, tplvlDeptCd,tplvlDeptNm,payrMangDeptCd, payrMangDeptNm, mangeDeptCd,mangeDeptNm,payrMangDeptYn,yrtxInptPrcsYn,email, pwd, useYn, 
                null, null, null, null, lockat, pwddate, logincnt, inptDt);
    }
    
    // lockat, pwddate, logincnt, inptDt 추가_hieju_06.09
    public MSFSysm0100BM(
    		  String dpobCd,
    		  String sysDivCd, 
    		  String sysDivNm, 
              String usrId,
              String usrNm,
              String usrDivCd,
              String usrDivNm,
              String deptCd,
              String deptNm,
//              String  typOccuCd ,
//              String  typOccuNm ,
//              String  pyspGrdeCd ,
//              String  pyspGrdeNm ,
              String usrTel,
              String tplvlDeptCd,
              String tplvlDeptNm,
              String payrMangDeptCd,
              String payrMangDeptNm,
              String mangeDeptCd,
              String mangeDeptNm,
              String payrMangDeptYn,
              String yrtxInptPrcsYn,
              String email, 
              String pwd, 
              String useYn,
              List<MSFSysm0300BM> msfSysm0300List,
              MSFUserInfoBM userInfo,
              MSFSsoxUserBM ssoxUser,
              MSFAuthCheckBM userAuth, 
              String lockat,
              String logincnt,
              String pwddate,
              String inptDt) {
    	values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_SYS_DIV_CD,sysDivCd);
        values.put(ATTR_SYS_DIV_NM,sysDivNm);
        values.put(ATTR_USR_ID,usrId);
        values.put(ATTR_USR_NM, usrNm);
        values.put(ATTR_USR_DIV_CD,usrDivCd);
        values.put(ATTR_USR_DIV_NM,usrDivNm);
        values.put(ATTR_DEPT_CD,deptCd);
        values.put(ATTR_DEPT_NM,deptNm);
//        values.put(ATTR_TYPOCCUCD,typOccuCd);
//        values.put(ATTR_TYPOCCUNM,typOccuNm);
//        values.put(ATTR_PYSPGRDECD,pyspGrdeCd); 
//        values.put(ATTR_PYSPGRDENM,pyspGrdeNm); 
        values.put(ATTR_USR_TEL,usrTel);
        values.put(ATTR_TPLVLDEPTCD,tplvlDeptCd);
        values.put(ATTR_TPLVLDEPTNM,tplvlDeptNm); 
        values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
        values.put(ATTR_PAYRMANGDEPTNM,payrMangDeptNm);
        values.put(ATTR_MANGEDEPTCD,mangeDeptCd);
        values.put(ATTR_MANGEDEPTNM,mangeDeptNm);
        values.put(ATTR_PAYRMANGDEPTYN,payrMangDeptYn); 
        values.put(ATTR_YRTXINPTPRCSYN,yrtxInptPrcsYn);  
        values.put(ATTR_EMAIL, email);
        values.put(ATTR_PWD,pwd);
        values.put(ATTR_USE_YN, useYn);
        values.put(ATTR_SYSM0300_LIST, msfSysm0300List);
        values.put(ATTR_USER_INFO, userInfo);
        values.put(ATTR_SSOXUSER, ssoxUser);
        values.put(ATTR_USER_AUTH, userAuth);
        values.put(ATTR_LOCKAT , lockat);
        values.put(ATTR_PWD_DATE , logincnt);
        values.put(ATTR_LOGINCNT , pwddate);
        values.put(ATTR_INPT_DT , inptDt);
    } 
      
//    public String getCognomeNome() {
//        return MSFSharedUtils.allowNulls(values.get(ATTR_COGNOME)+" "+values.get(ATTR_NOME)).trim();
//    }
     
    public String getPayrMangDeptYn() {
        Object value = values.get(ATTR_PAYRMANGDEPTYN);
        return (String)value;
    }

    public void setPayrMangDeptYn(String payrMangDeptYn) {
        values.put(ATTR_PAYRMANGDEPTYN, payrMangDeptYn);
    }
 
    public String getDpobCd() {
    	 Object value = values.get(ATTR_DPOBCD);
         return (String)value;
	}

	public void setDpobCd(String dpobCd) {
		 values.put(ATTR_DPOBCD, dpobCd);
	}

	public String getSysDivCd() {
        Object value = values.get(ATTR_SYS_DIV_CD);
        return (String)value;
    }

    public void setSysDivCd(String sysDivCd) {
        values.put(ATTR_SYS_DIV_CD, sysDivCd);
    }
    
    public String getSysDivNm() {
        Object value = values.get(ATTR_SYS_DIV_NM);
        return (String)value;
    }

    public void setSysDivNm(String sysDivNm) {
        values.put(ATTR_SYS_DIV_NM, sysDivNm);
    }
    
    
    public void setUsrId(String usrId) {
        values.put(ATTR_USR_ID, usrId);
    }

    public String getUsrId() {
        Object value = values.get(ATTR_USR_ID);
        return (String)value;
    }
 
    
    public String getUsrNm() {
        Object value = values.get(ATTR_USR_NM);
        return (String)value;
    }

    public String getUsrDivCd() {
        Object value = values.get(ATTR_USR_DIV_CD);
        return (String)value;
    }
    
    public String getUsrDivNm() {
        Object value = values.get(ATTR_USR_DIV_NM);
        return (String)value;
    }

    public String getEmail() {
        Object value = values.get(ATTR_EMAIL);
        return (String)value;
    }

    public String getPwd() {
        Object value = values.get(ATTR_PWD);
        return (String)value;
    }
    
	public void setPwd(String password) {
		values.put(ATTR_PWD, password);
		
	}

    public String getUseYn() {
        Object value = values.get(ATTR_USE_YN);
        return (String)value;
    }
    
    public String getDeptCd() {
        Object value = values.get(ATTR_DEPT_CD);
        return (String)value;
    } 
    public String getDeptNm() {
        Object value = values.get(ATTR_DEPT_NM);
        return (String)value;
    }
    
    

///** set 직종코드 : typOccuCd */
//public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
///** get 직종코드 : typOccuCd */
//public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
//
//
///** set 직종코드 : typOccuNm */
//public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
///** get 직종코드 : typOccuNm */
//public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
//
//
///** set 호봉등급코드 : pyspGrdeCd */
//public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
///** get 호봉등급코드 : pyspGrdeCd */
//public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
//
//
///** set 호봉등급 : pyspGrdeNm */
//public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
///** get 호봉등급 : pyspGrdeNm */
//public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}


    public String getUsrTel() {
        Object value = values.get(ATTR_USR_TEL);
        return (String)value;
    }
    
    public String getTplvlDeptCd() {
        Object value = values.get(ATTR_TPLVLDEPTCD);
        return (String)value;
    }
    
    public String getTplvlDeptNm() {
        Object value = values.get(ATTR_TPLVLDEPTNM);
        return (String)value;
    }
    
    public String getPayrMangDeptCd() {
        Object value = values.get(ATTR_PAYRMANGDEPTCD);
        return (String)value;
    }
    
    public String getPayrMangDeptNm() {
        Object value = values.get(ATTR_PAYRMANGDEPTNM);
        return (String)value;
    }
    public String getMangeDeptCd() {
        Object value = values.get(ATTR_MANGEDEPTCD);
        return (String)value;
    }

    public String getMangeDeptNm() {
        Object value = values.get(ATTR_MANGEDEPTNM);
        return (String)value;
    }
    

/** set 사용자권한제외여부 : usrAuthEepnYn */
public void setUsrAuthEepnYn(String  usrAuthEepnYn) { set( ATTR_USRAUTHEEPNYN ,usrAuthEepnYn);}
/** get 사용자권한제외여부 : usrAuthEepnYn */
public String  getUsrAuthEepnYn() { return (String )get( ATTR_USRAUTHEEPNYN );}

/** set 호봉제포함여부 : pyspInsnYn */
public void setPyspInsnYn(String  pyspInsnYn) { set( ATTR_PYSPINSNYN ,pyspInsnYn);}
/** get 호봉제포함여부 : pyspInsnYn */
public String  getPyspInsnYn() { return (String )get( ATTR_PYSPINSNYN );}

/** set 비호봉제포함여부 : notPyspInsnYn */
public void setNotPyspInsnYn(String  notPyspInsnYn) { set( ATTR_NOTPYSPINSNYN ,notPyspInsnYn);}
/** get 비호봉제포함여부 : notPyspInsnYn */
public String  getNotPyspInsnYn() { return (String )get( ATTR_NOTPYSPINSNYN );}

/** set 복무입력처리여부 : servcInptPrcsYn */
public void setServcInptPrcsYn(String  servcInptPrcsYn) { set( ATTR_SERVCINPTPRCSYN ,servcInptPrcsYn);}
/** get 복무입력처리여부 : servcInptPrcsYn */
public String  getServcInptPrcsYn() { return (String )get( ATTR_SERVCINPTPRCSYN );}

/** set 연말정산입력처리여부 : yrtxInptPrcsYn */
public void setYrtxInptPrcsYn(String  yrtxInptPrcsYn) { set( ATTR_YRTXINPTPRCSYN ,yrtxInptPrcsYn);}
/** get 연말정산입력처리여부 : yrtxInptPrcsYn */
public String  getYrtxInptPrcsYn() { return (String )get( ATTR_YRTXINPTPRCSYN );}

// 계정잠금 추가_hieju_06.09

/** set 계정잠금 : lockat */
public void setLockat(String  lockat) { set( ATTR_LOCKAT ,lockat);}
/** get 계정잠금 : lockat */
public String  getLockat() { return (String )get( ATTR_LOCKAT );}

/** set 기간제포함여부 : shttmInsnYn */
public void setShttmInsnYn(String  shttmInsnYn) { set( ATTR_SHTTMINSNYN ,shttmInsnYn);}
/** get 기간제포함여부 : shttmInsnYn */
public String  getShttmInsnYn() { return (String )get( ATTR_SHTTMINSNYN );}

/** set 사용자권한구분코드 : usrAuthDivCd */
public void setUsrAuthDivCd(String  usrAuthDivCd) { set( ATTR_USRAUTHDIVCD ,usrAuthDivCd);}
/** get 사용자권한구분코드 : usrAuthDivCd */
public String  getUsrAuthDivCd() { return (String )get( ATTR_USRAUTHDIVCD );}
   

    @SuppressWarnings("unchecked")
    public List<MSFSysm0300BM> getMsfSysm0300List() {
        Object value = values.get(ATTR_SYSM0300_LIST);
        return (List<MSFSysm0300BM>)value;
    }

    public void addSysm0300(MSFSysm0300BM msfSysm0300) {
        List<MSFSysm0300BM> msfSysm0300List = getMsfSysm0300List();
        if ( msfSysm0300List==null ) {
        	msfSysm0300List = new ArrayList<MSFSysm0300BM>();
            values.put(ATTR_SYSM0300_LIST, msfSysm0300List);
        }
        msfSysm0300List.add(msfSysm0300);
    } 
   
   
    public MSFUserInfoBM getUserInfo() {
        Object value = values.get(ATTR_USER_INFO);
        return (MSFUserInfoBM)value;
    }

    public void setUserInfo(MSFUserInfoBM userInfo) {
        // MSFSysm0300BM  msfUserInfo = getUserInfo();
       // if ( msfUserInfo==null ) {
       // 	msfUserInfo = new MSFSysm0300BM();
            values.put(ATTR_USER_INFO, userInfo);
       // }
       // msfUserInfo.s.add(userInfo);
    }
     
    public MSFSsoxUserBM getSsoxUser() {
        Object value = values.get(ATTR_SSOXUSER);
        return (MSFSsoxUserBM)value;
    }

    public void setSsoxUser(MSFSsoxUserBM ssoxUser) {
       //  MSFSysm0300BM  msfSsoxUser = getSsoxUser();
       // if ( msfSsoxUser==null ) {
       // 	msfSsoxUser = new MSFSysm0300BM();
            values.put(ATTR_SSOXUSER, ssoxUser);
       //  }
       // msfSsoxUser.add(ssoxUser);
    }
    
    
   public MSFAuthCheckBM getAuthCheck() {
       Object value = values.get(ATTR_USER_AUTH);
       return (MSFAuthCheckBM)value;
   }

   public void setAuthCheck(MSFAuthCheckBM userAuth) {
//        MSFAuthCheckBM  msfAuthCheck = getAuthCheck();
//       if ( msfAuthCheck==null ) {
//    	   msfAuthCheck = new MSFAuthCheckBM();
//           values.put(ATTR_USER_AUTH, msfAuthCheck);
//        } else {
           values.put(ATTR_USER_AUTH, userAuth);
//        }  
   }
  
    
    public String getSysm0300AuthGrpNum() {
        List<MSFSysm0300BM> msfSysm0300s = getMsfSysm0300List();
        StringBuffer authGrpSeilNums = new StringBuffer(",");
        for ( int i=0 ; msfSysm0300s!=null && i<msfSysm0300s.size() ; i++ ) {
        	authGrpSeilNums.append(msfSysm0300s.get(i).getAuthGrpSeilNum()).append(",");
        }
        return authGrpSeilNums.toString();
    }
    

    /** set null : ssoUseType */
    public void setSsoUseType(String  ssoUseType) { set( ATTR_SSOUSETYPE ,ssoUseType);}
    /** get null : ssoUseType */
    public String  getSsoUseType() { return (String )get( ATTR_SSOUSETYPE );}
 

    // lockat, pwddate, logincnt, inptDt 추가_hieju_06.09
    
    public MSFSysm0100BM clone(){
        return new MSFSysm0100BM(
        		this.getDpobCd(),
                this.getSysDivCd(), 
                this.getSysDivNm(), 
                this.getUsrId(), 
                this.getUsrNm(), 
                this.getUsrDivCd(), 
                this.getUsrDivNm(), 
                this.getDeptCd(),
                this.getDeptNm(),
//                this.getTypOccuCd(),
//                this.getTypOccuNm(),
//                this.getPyspGrdeCd(),
//                this.getPyspGrdeNm(),
                this.getUsrTel(),
                this.getTplvlDeptCd() ,
                this.getTplvlDeptNm() ,
                this.getPayrMangDeptCd(),
                this.getPayrMangDeptNm(),
                this.getMangeDeptCd(),
                this.getMangeDeptNm(),
                this.getPayrMangDeptYn(),
                this.getYrtxInptPrcsYn(),
                this.getEmail(), 
                this.getPwd(), 
                this.getUseYn(),
                this.getMsfSysm0300List(),
                this.getUserInfo(),
                this.getSsoxUser(),
                this.getAuthCheck(), this.getLockat(), this.getPwddate(), this.getLogincnt(),this.getInptDt());
    }



    
    // lockat, pwddate, logincnt, inptDt 추가_hieju_06.09

	public String getPwddate() {
		Object value = values.get(ATTR_PWD_DATE);
		return (String)value; 
	}
	
	public void setPwddate(String pwddate) {
		 values.put(ATTR_PWD_DATE, pwddate);
	}

	public String getLogincnt() {
		Object value = values.get(ATTR_LOGINCNT);
		return (String)value; 
	}
	
	public void setLogincnt(String logincnt) {
		values.put(ATTR_LOGINCNT, logincnt);
		
	}

	public String getInptDt() {
		Object value = values.get(ATTR_INPT_DT);
		return (String)value; 
	}
	
	public void setInptDt(String inptDt) {
		values.put(ATTR_INPT_DT, inptDt);
	}



   
}
