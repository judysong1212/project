package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfPsnl0115BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set 사업장코드 : dataType */
    public static final String ATTR_DATATYPE = "dataType";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 가족일련번호 : famySeilNum */
    public static final String ATTR_FAMYSEILNUM = "famySeilNum";

    /** set 가족관계구분코드 : famyRelaDivCd */
    public static final String ATTR_FAMYRELADIVCD = "famyRelaDivCd";
    
    /** set 가족관계구분코드 : famyRelaDivNm */
    public static final String ATTR_FAMYRELADIVNM = "famyRelaDivNm";

    /** set 가족성명 : famyNm */
    public static final String ATTR_FAMYNM = "famyNm";

    /** set 가족주민등록번호 : famyResnRegnNum */
    public static final String ATTR_FAMYRESNREGNNUM = "famyResnRegnNum";
    
    /** set 가족주민등록번호 : secFamyResnRegnNum */
    public static final String ATTR_SECFAMYRESNREGNNUM = "secFamyResnRegnNum";

    /** set 생년월일 : yoobhMnthDay */
    public static final String ATTR_YOOBHMNTHDAY = "yoobhMnthDay";

    /** set 음양구분코드 : sclcDivCd */
    public static final String ATTR_SCLCDIVCD = "sclcDivCd";

    /** set 학력구분코드 : acadAbtyDivCd */
    public static final String ATTR_ACADABTYDIVCD = "acadAbtyDivCd";

    /** set 학교명 : schlNm */
    public static final String ATTR_SCHLNM = "schlNm";

    /** set 직업명 : crrCd */
    public static final String ATTR_CRRCD = "crrCd";

    /** set 직장명 : wkOfcNm */
    public static final String ATTR_WKOFCNM = "wkOfcNm";

    /** set 직위명 : inbyNm */
    public static final String ATTR_INBYNM = "inbyNm";

    /** set 외국인여부 : frgnrYn */
    public static final String ATTR_FRGNRYN = "frgnrYn";

    /** set 장애구분코드 : dabtyDivCd */
    public static final String ATTR_DABTYDIVCD = "dabtyDivCd";

    /** set 장애등급코드 : dabtyGrdeCd */
    public static final String ATTR_DABTYGRDECD = "dabtyGrdeCd";

    /** set 가족사항비고내용 : famyPartNoteCtnt */
    public static final String ATTR_FAMYPARTNOTECTNT = "famyPartNoteCtnt";

    /** set 국가코드 : natnCd */
    public static final String ATTR_NATNCD = "natnCd";

    /** set 가족동거여부 : famyChbttYn */
    public static final String ATTR_FAMYCHBTTYN = "famyChbttYn";

    /** set 가족수당여부 : famyAllwYn */
    public static final String ATTR_FAMYALLWYN = "famyAllwYn";

    /** set 학비보조여부 : schlExpnAdmclYn */
    public static final String ATTR_SCHLEXPNADMCLYN = "schlExpnAdmclYn";

    /** set 연말정산여부 : yrtxYn */
    public static final String ATTR_YRTXYN = "yrtxYn";

    /** set 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** set 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** set 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** set 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** set 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** set 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** set null : famySecRegnNum */
    public static final String ATTR_FAMYSECREGNNUM = "famySecRegnNum";

    /** set null : famyOrgRegnNum */
    public static final String ATTR_FAMYORGREGNNUM = "famyOrgRegnNum";

    /** 생성자 */
     public SysIfPsnl0115BM() { super(); } 

    /** 일괄등록 처리   */
     public SysIfPsnl0115BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  famySeilNum 
    		, String  famyRelaDivCd 
    		, String  famyNm 
    		, String  famyResnRegnNum 
    		, String  yoobhMnthDay 
    		, String  sclcDivCd 
    		, String  acadAbtyDivCd 
    		, String  schlNm 
    		, String  crrCd 
    		, String  wkOfcNm 
    		, String  inbyNm 
    		, String  frgnrYn 
    		, String  dabtyDivCd 
    		, String  dabtyGrdeCd 
    		, String  famyPartNoteCtnt 
    		, String  natnCd 
    		, String  famyChbttYn 
    		, String  famyAllwYn 
    		, String  schlExpnAdmclYn 
    		, String  yrtxYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  famySecRegnNum 
    		, String  famyOrgRegnNum ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_FAMYSEILNUM,famySeilNum);
     	values.put(ATTR_FAMYRELADIVCD,famyRelaDivCd);
     	values.put(ATTR_FAMYNM,famyNm);
     	values.put(ATTR_FAMYRESNREGNNUM,famyResnRegnNum);
     	values.put(ATTR_YOOBHMNTHDAY,yoobhMnthDay);
     	values.put(ATTR_SCLCDIVCD,sclcDivCd);
     	values.put(ATTR_ACADABTYDIVCD,acadAbtyDivCd);
     	values.put(ATTR_SCHLNM,schlNm);
     	values.put(ATTR_CRRCD,crrCd);
     	values.put(ATTR_WKOFCNM,wkOfcNm);
     	values.put(ATTR_INBYNM,inbyNm);
     	values.put(ATTR_FRGNRYN,frgnrYn);
     	values.put(ATTR_DABTYDIVCD,dabtyDivCd);
     	values.put(ATTR_DABTYGRDECD,dabtyGrdeCd);
     	values.put(ATTR_FAMYPARTNOTECTNT,famyPartNoteCtnt);
     	values.put(ATTR_NATNCD,natnCd);
     	values.put(ATTR_FAMYCHBTTYN,famyChbttYn);
     	values.put(ATTR_FAMYALLWYN,famyAllwYn);
     	values.put(ATTR_SCHLEXPNADMCLYN,schlExpnAdmclYn);
     	values.put(ATTR_YRTXYN,yrtxYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_FAMYSECREGNNUM,famySecRegnNum);
     	values.put(ATTR_FAMYORGREGNNUM,famyOrgRegnNum); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set 사업장코드 : dataType */
    public void setDataType(String  dataType) { set( ATTR_DATATYPE ,dataType);}
    /** get 사업장코드 : dataType */
    public String  getDataType() { return (String )get( ATTR_DATATYPE );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 가족일련번호 : famySeilNum */
    public void setFamySeilNum(BigDecimal  famySeilNum) { set( ATTR_FAMYSEILNUM ,famySeilNum);}
    /** get 가족일련번호 : famySeilNum */
    public BigDecimal  getFamySeilNum() { return (BigDecimal )get( ATTR_FAMYSEILNUM );}
    /** set 가족관계구분코드 : famyRelaDivCd */
    public void setFamyRelaDivCd(String  famyRelaDivCd) { set( ATTR_FAMYRELADIVCD ,famyRelaDivCd);}
    /** get 가족관계구분코드 : famyRelaDivCd */
    public String  getFamyRelaDivCd() { return (String )get( ATTR_FAMYRELADIVCD );}
    
    /** set 가족관계구분코드 : famyRelaDivNm */
    public void setFamyRelaDivNm(String  famyRelaDivNm) { set( ATTR_FAMYRELADIVNM ,famyRelaDivNm);}
    /** get 가족관계구분코드 : famyRelaDivNm */
    public String  getFamyRelaDivNm() { return (String )get( ATTR_FAMYRELADIVNM );} 
    
    /** set 가족성명 : famyNm */
    public void setFamyNm(String  famyNm) { set( ATTR_FAMYNM ,famyNm);}
    /** get 가족성명 : famyNm */
    public String  getFamyNm() { return (String )get( ATTR_FAMYNM );}
    /** set 가족주민등록번호 : famyResnRegnNum */
    public void setFamyResnRegnNum(String  famyResnRegnNum) { set( ATTR_FAMYRESNREGNNUM ,famyResnRegnNum);}
    /** get 가족주민등록번호 : famyResnRegnNum */
    public String  getFamyResnRegnNum() { return (String )get( ATTR_FAMYRESNREGNNUM );}
    
    
    /** set 가족주민등록번호 : secFamyResnRegnNum */
    public void setSecFamyResnRegnNumm(String  secFamyResnRegnNum) { set( ATTR_SECFAMYRESNREGNNUM ,secFamyResnRegnNum);}
    /** get 가족주민등록번호 : secFamyResnRegnNum */
    public String  getSecFamyResnRegnNum() { return (String )get( ATTR_SECFAMYRESNREGNNUM );}   
    
    
    /** set 생년월일 : yoobhMnthDay */
    public void setYoobhMnthDay(String  yoobhMnthDay) { set( ATTR_YOOBHMNTHDAY ,yoobhMnthDay);}
    /** get 생년월일 : yoobhMnthDay */
    public String  getYoobhMnthDay() { return (String )get( ATTR_YOOBHMNTHDAY );}
    /** set 음양구분코드 : sclcDivCd */
    public void setSclcDivCd(String  sclcDivCd) { set( ATTR_SCLCDIVCD ,sclcDivCd);}
    /** get 음양구분코드 : sclcDivCd */
    public String  getSclcDivCd() { return (String )get( ATTR_SCLCDIVCD );}
    /** set 학력구분코드 : acadAbtyDivCd */
    public void setAcadAbtyDivCd(String  acadAbtyDivCd) { set( ATTR_ACADABTYDIVCD ,acadAbtyDivCd);}
    /** get 학력구분코드 : acadAbtyDivCd */
    public String  getAcadAbtyDivCd() { return (String )get( ATTR_ACADABTYDIVCD );}
    /** set 학교명 : schlNm */
    public void setSchlNm(String  schlNm) { set( ATTR_SCHLNM ,schlNm);}
    /** get 학교명 : schlNm */
    public String  getSchlNm() { return (String )get( ATTR_SCHLNM );}
    /** set 직업명 : crrCd */
    public void setCrrCd(String  crrCd) { set( ATTR_CRRCD ,crrCd);}
    /** get 직업명 : crrCd */
    public String  getCrrCd() { return (String )get( ATTR_CRRCD );}
    /** set 직장명 : wkOfcNm */
    public void setWkOfcNm(String  wkOfcNm) { set( ATTR_WKOFCNM ,wkOfcNm);}
    /** get 직장명 : wkOfcNm */
    public String  getWkOfcNm() { return (String )get( ATTR_WKOFCNM );}
    /** set 직위명 : inbyNm */
    public void setInbyNm(String  inbyNm) { set( ATTR_INBYNM ,inbyNm);}
    /** get 직위명 : inbyNm */
    public String  getInbyNm() { return (String )get( ATTR_INBYNM );}
    /** set 외국인여부 : frgnrYn */
    public void setFrgnrYn(String  frgnrYn) { set( ATTR_FRGNRYN ,frgnrYn);}
    /** get 외국인여부 : frgnrYn */
    public String  getFrgnrYn() { return (String )get( ATTR_FRGNRYN );}
    /** set 장애구분코드 : dabtyDivCd */
    public void setDabtyDivCd(String  dabtyDivCd) { set( ATTR_DABTYDIVCD ,dabtyDivCd);}
    /** get 장애구분코드 : dabtyDivCd */
    public String  getDabtyDivCd() { return (String )get( ATTR_DABTYDIVCD );}
    /** set 장애등급코드 : dabtyGrdeCd */
    public void setDabtyGrdeCd(String  dabtyGrdeCd) { set( ATTR_DABTYGRDECD ,dabtyGrdeCd);}
    /** get 장애등급코드 : dabtyGrdeCd */
    public String  getDabtyGrdeCd() { return (String )get( ATTR_DABTYGRDECD );}
    /** set 가족사항비고내용 : famyPartNoteCtnt */
    public void setFamyPartNoteCtnt(String  famyPartNoteCtnt) { set( ATTR_FAMYPARTNOTECTNT ,famyPartNoteCtnt);}
    /** get 가족사항비고내용 : famyPartNoteCtnt */
    public String  getFamyPartNoteCtnt() { return (String )get( ATTR_FAMYPARTNOTECTNT );}
    /** set 국가코드 : natnCd */
    public void setNatnCd(String  natnCd) { set( ATTR_NATNCD ,natnCd);}
    /** get 국가코드 : natnCd */
    public String  getNatnCd() { return (String )get( ATTR_NATNCD );}
    /** set 가족동거여부 : famyChbttYn */
    public void setFamyChbttYn(String  famyChbttYn) { set( ATTR_FAMYCHBTTYN ,famyChbttYn);}
    /** get 가족동거여부 : famyChbttYn */
    public String  getFamyChbttYn() { return (String )get( ATTR_FAMYCHBTTYN );}
    /** set 가족수당여부 : famyAllwYn */
    public void setFamyAllwYn(String  famyAllwYn) { set( ATTR_FAMYALLWYN ,famyAllwYn);}
    /** get 가족수당여부 : famyAllwYn */
    public String  getFamyAllwYn() { return (String )get( ATTR_FAMYALLWYN );}
    /** set 학비보조여부 : schlExpnAdmclYn */
    public void setSchlExpnAdmclYn(String  schlExpnAdmclYn) { set( ATTR_SCHLEXPNADMCLYN ,schlExpnAdmclYn);}
    /** get 학비보조여부 : schlExpnAdmclYn */
    public String  getSchlExpnAdmclYn() { return (String )get( ATTR_SCHLEXPNADMCLYN );}
    /** set 연말정산여부 : yrtxYn */
    public void setYrtxYn(String  yrtxYn) { set( ATTR_YRTXYN ,yrtxYn);}
    /** get 연말정산여부 : yrtxYn */
    public String  getYrtxYn() { return (String )get( ATTR_YRTXYN );}
    /** set 입력자 : kybdr */
    public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String  getKybdr() { return (String )get( ATTR_KYBDR );}
    /** set 입력일자 : inptDt */
    public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String  getInptDt() { return (String )get( ATTR_INPTDT );}
    /** set 입력주소 : inptAddr */
    public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}
    /** set 수정자 : ismt */
    public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String  getIsmt() { return (String )get( ATTR_ISMT );}
    /** set 수정일자 : revnDt */
    public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String  getRevnDt() { return (String )get( ATTR_REVNDT );}
    /** set 수정주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정주소 : revnAddr */
    public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}
    /** set null : famySecRegnNum */
    public void setFamySecRegnNum(String  famySecRegnNum) { set( ATTR_FAMYSECREGNNUM ,famySecRegnNum);}
    /** get null : famySecRegnNum */
    public String  getFamySecRegnNum() { return (String )get( ATTR_FAMYSECREGNNUM );}
    /** set null : famyOrgRegnNum */
    public void setFamyOrgRegnNum(String  famyOrgRegnNum) { set( ATTR_FAMYORGREGNNUM ,famyOrgRegnNum);}
    /** get null : famyOrgRegnNum */
    public String  getFamyOrgRegnNum() { return (String )get( ATTR_FAMYORGREGNNUM );}
     
}
