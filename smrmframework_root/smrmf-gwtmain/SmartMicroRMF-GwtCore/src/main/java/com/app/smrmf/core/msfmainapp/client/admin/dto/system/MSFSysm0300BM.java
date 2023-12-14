/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto.system;

 

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;
 

public class MSFSysm0300BM extends MSFSimpleBaseModel implements IsSerializable{

    private static final long serialVersionUID = 1L;

     
    public static final String ATTR_SYSDIVCD 		= "sysDivCd";
    public static final String ATTR_AUTHGRPSEILNUM  = "authGrpSeilNum";
    public static final String ATTR_BUSINDIVCD 		= "businDivCd";
    public static final String ATTR_AUTHGRPNM 		= "authGrpNm";
    public static final String ATTR_GRDE 			= "grde";
    public static final String ATTR_AUTHGRPUSEYN 	= "authGrpUseYn";
    public static final String ATTR_GRPEPLN 		= "grpEpln";
    
    
    public MSFSysm0300BM() {
        super();
    }

    public MSFSysm0300BM( 
              String sysDivCd
            , Long authGrpSeilNum
  		    , String businDivCd
            , String authGrpNm
            , String grde
            , String authGrpUseYn
            , String grpEpln) {
      	values.put(ATTR_SYSDIVCD,sysDivCd);
      	values.put(ATTR_AUTHGRPSEILNUM,authGrpSeilNum);
      	values.put(ATTR_BUSINDIVCD,businDivCd);
      	values.put(ATTR_AUTHGRPNM,authGrpNm);
      	values.put(ATTR_GRDE,grde);
      	values.put(ATTR_AUTHGRPUSEYN,authGrpUseYn);
      	values.put(ATTR_GRPEPLN,grpEpln); 
    }

    public String getSysDivCd() {
        Object value = values.get(ATTR_SYSDIVCD);
        return (String)value;
    }

    public void setSysDivCd(String sysDivCd) {
        values.put(ATTR_SYSDIVCD, sysDivCd);
    }
    
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
    
    public String getAuthGrpUseYn() {
        Object value = values.get(ATTR_AUTHGRPUSEYN);
        return (String)value;
    }
    
    public String getGrpEpln() {
        Object value = values.get(ATTR_GRPEPLN);
        return (String)value;
    }
 
    
    public MSFSysm0300BM clone(){
        return new MSFSysm0300BM(
                this.getSysDivCd(), 
                this.getAuthGrpSeilNum(),
                this.getBusinDivCd(),
                this.getAuthGrpNm(),
                this.getGrde(),
                this.getAuthGrpUseYn(),
                this.getGrpEpln());
    }

}
