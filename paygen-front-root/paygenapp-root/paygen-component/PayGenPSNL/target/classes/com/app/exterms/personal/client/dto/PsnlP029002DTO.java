package com.app.exterms.personal.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Psnl0126VO.java
 * @Description : Psnl0126 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PsnlP029002DTO extends BaseModel {
    private static final long serialVersionUID = 1L;
    
    /** 사업장 코드 DPOB_CD */
    public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
    
    /** 시스템키 SYSTEMKEY */
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
    
    /** 휴가적용년도 HODY_APPTN_YR */
    public void setHodyApptnYr(String hodyApptnYr) { set("hodyApptnYr",hodyApptnYr);}
	public String getHodyApptnYr() { return (String)get("hodyApptnYr");}
    
    /** 휴가적용일수 HODY_APPTN_NUM_DYS */
	public void setHodyApptnNumDys(Double hodyApptnNumDys) { set("hodyApptnNumDys",hodyApptnNumDys);}
	public Double getHodyApptnNumDys() { return (Double)get("hodyApptnNumDys");}
    
    /** set 한글성명 : hanNm */
	public void setHanNm(String hanNm) { set("hanNm",hanNm);}
	public String getHanNm() { return (String)get("hanNm");}
	
	public void setHodyNumDysSysCalc(Double hodyNumDysSysCalc) { set("hodyNumDysSysCalc",hodyNumDysSysCalc);}
	public Double getHodyNumDysSysCalc() { return (Double)get("hodyNumDysSysCalc");}	
    
    /** 휴가사용일수 HODY_USE_NUM_DYS */
	public void setHodyUseNumDys(Double hodyUseNumDys) { set("hodyUseNumDys",hodyUseNumDys);}
	public Double getHodyUseNumDys() { return (Double)get("hodyUseNumDys");}
    
    /** 휴가잔여일수 HODY_RST_NUM_DYS */
	public void setHodyRstNumDys(Double hodyRstNumDys) { set("hodyRstNumDys",hodyRstNumDys);}
	public Double getHodyRstNumDys() { return (Double)get("hodyRstNumDys");}
    
    /** 휴가비고내용 HODY_NOTE_CTNT */
    public void setHodyNoteCtnt(String hodyNoteCtnt) { set("hodyNoteCtnt",hodyNoteCtnt);}
	public String getHodyNoteCtnt() { return (String)get("hodyNoteCtnt");}
    
    /** 휴가확정여부 HODY_FIX_YN */
    public void setResnRegnGbn(String resnRegnGbn) { set("resnRegnGbn",resnRegnGbn);}
	public String getResnRegnGbn() { return (String)get("resnRegnGbn");}
    
    /** set 특별휴가일수 : spclHodyNumDys */
    public void setSpclHodyNumDys(Double spclHodyNumDys) { set("spclHodyNumDys",spclHodyNumDys);}
	public Double getSpclHodyNumDys() { return (Double)get("spclHodyNumDys");}
    
    /** set 특별휴가사용일수 : spclHodyUseDys */
    public void setSpclHodyUseDys(Double spclHodyUseDys) { set("spclHodyUseDys",spclHodyUseDys);}
	public Double getSpclHodyUseDys() { return (Double)get("spclHodyUseDys");}
    
    /** 부서이름 - DEPT_NM */
    public void setDeptNm(String deptNm) { set("deptNm",deptNm);}
	public String getDeptNm() { return (String)get("deptNm");}
    
    /** 존재여부 - HODY_NUM_DYS_USE_YN */
    public void setHodyNumDysUseYn(String hodyNumDysUseYn) { set("hodyNumDysUseYn",hodyNumDysUseYn);}
	public String getHodyNumDysUseYn() { return (String)get("hodyNumDysUseYn");}
       
    /** set 주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String resnRegnNum) { set("resnRegnNum",resnRegnNum);}
	public String getResnRegnNum() { return (String)get("resnRegnNum");}
	
	public void setDateChk(Boolean dateChk) { set("dateChk",dateChk);}
	public Boolean getDateChk() { return (Boolean)get("dateChk");}
	
	public void setLvsgCoptnCstApptnYn(String lvsgCoptnCstApptnYn) { set("lvsgCoptnCstApptnYn",lvsgCoptnCstApptnYn);}
	public String getLvsgCoptnCstApptnYn() { return (String)get("lvsgCoptnCstApptnYn");}
	
	public void setYoobhMnthDay(String yoobhMnthDay) { set("yoobhMnthDay",yoobhMnthDay);}
	public String getYoobhMnthDay() { return (String)get("yoobhMnthDay");}
	
		
	
}
