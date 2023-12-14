package com.app.smrmf.core.msfmainapp.client.admin.dto.system;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MSFUserInfoBM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set 사업장명 : dpobNm */
    public static final String ATTR_DPOBNM = "dpobNm"; 
    
    public static final String ATTR_SYSDIVCD 		= "sysDivCd";
    
    /** set 회계년도 : accYr */
    public static final String ATTR_ACCYR = "accYr";
     
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm"; 

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
 
    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 부서명 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    
  
    
    /** set 단위기관명 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
  
    public static final String ATTR_AUTHGRPSEILNUM  = "authGrpSeilNum";
    public static final String ATTR_BUSINDIVCD 		= "businDivCd";
    public static final String ATTR_AUTHGRPNM 		= "authGrpNm";
    public static final String ATTR_GRDE 			= "grde";
    
    /** 생성자 */
     public MSFUserInfoBM() { super(); } 

    /** 일괄등록 처리   */
     public MSFUserInfoBM(
    		  String  dpobCd 
    		, String dpobNm 
    		,  String sysDivCd
    		, String  accYr
    		, String  systemkey 
    		, String  hanNm  
    		, String  resnRegnNum  
    		, String  deptCd 
    		, String  deptNm 
    		, String  businCd  
    		, String  businNm  
    		, String  payrMangDeptCd  
    		, String  payrMangDeptNm  
    		  , Long authGrpSeilNum
    		    , String businDivCd
              , String authGrpNm
              , String grde
    		) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DPOBNM,dpobNm);
    	values.put(ATTR_SYSDIVCD,sysDivCd);
     	values.put(ATTR_ACCYR,accYr);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_HANNM,hanNm);
     	values.put(ATTR_RESNREGNNUM,resnRegnNum); 
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_DEPTNM,deptNm);
     	values.put(ATTR_BUSINCD,businCd); 
     	values.put(ATTR_BUSINNM,businNm); 
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);  
     	values.put(ATTR_PAYRMANGDEPTNM,payrMangDeptNm);
    	values.put(ATTR_AUTHGRPSEILNUM,authGrpSeilNum);
      	values.put(ATTR_BUSINDIVCD,businDivCd);
      	values.put(ATTR_AUTHGRPNM,authGrpNm);
      	values.put(ATTR_GRDE,grde);
     	 } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    
    /** set 사업장 : dpobNm */
    public void setDpobNm(String  dpobNm) { set( ATTR_DPOBNM ,dpobNm);}
    /** get 사업장 : dpobNm */
    public String  getDpobNm() { return (String )get( ATTR_DPOBNM );}
    
    public String getSysDivCd() {
        Object value = values.get(ATTR_SYSDIVCD);
        return (String)value;
    }

    public void setSysDivCd(String sysDivCd) {
        values.put(ATTR_SYSDIVCD, sysDivCd);
    }
    
    /** set 회계년도 : accYr */
    public void setAccYr(String  accYr) { set( ATTR_ACCYR ,accYr);}
    /** get 회계년도 : accYr */
    public String  getAccYr() { return (String )get( ATTR_ACCYR );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 한글성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 한글성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}


    /** set 주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
    /** get 주민등록번호 : resnRegnNum */
    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}


    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
    
    
    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
    
    
    /** set 부서 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 부서코드 : deptNm */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

    /** set 사업 : businNm */
    public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** get 사업 : businNm */
    public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
    
    
    /** set 단위기관 : payrMangDeptNm */
    public void setPayrMangDeptNm(String  payrMangDeptNm) { set( ATTR_PAYRMANGDEPTNM ,payrMangDeptNm);}
    /** get 단위기관 : payrMangDeptNm */
    public String  getPayrMangDeptNm() { return (String )get( ATTR_PAYRMANGDEPTNM );}

    public Long getAuthGrpSeilNum() {
        Object value = values.get(ATTR_AUTHGRPSEILNUM);
        return (Long)value;
    }

    public void setAuthGrpSeilNum(Long authGrpSeilNum) {
        values.put(ATTR_AUTHGRPSEILNUM, authGrpSeilNum);
    }

    public String getBusinDivCd() {
        Object value = values.get(ATTR_BUSINDIVCD);
        return (String)value;
    }

    public String getAuthGrpNm() {
        Object value = values.get(ATTR_AUTHGRPNM);
        return (String)value;
    }
    
    public String getGrde() {
        Object value = values.get(ATTR_GRDE);
        return (String)value;
    }
    
    public MSFUserInfoBM clone(){
        return new MSFUserInfoBM(  
        		      this.getDpobCd() 
       	    		,  this.getDpobNm() 
       	    		,  this.getSysDivCd()
       	    		,  this.getAccYr()
       	    		,  this.getSystemkey() 
       	    		,  this.getHanNm() 
       	    		,  this.getResnRegnNum()  
       	    		,  this.getDeptCd() 
       	    		,  this.getDeptNm() 
       	    		,  this.getBusinCd()  
       	    		,  this.getBusinNm()  
       	    		,  this.getPayrMangDeptCd()  
       	    		,  this.getPayrMangDeptNm() 
       	    		, this.getAuthGrpSeilNum()
       	    		, this.getBusinDivCd()
       	    		, this.getAuthGrpNm()
       	    		, this.getGrde()
      		 );
    }
}
