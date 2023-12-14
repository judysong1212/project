package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0480VO.java
 * @Description : Payr0480 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0485BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set 고용구분코드 : commCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
    
    /** set 급여수당코드 : payExtpyCd */
    public static final String ATTR_PAYEXTPYCD = "payExtpyCd";
    
    /** set 급여공제코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";
    
    /** set 공통코드테스트 : sysComBass0300Dto */
    //public static final String ATTR_MSFCOMBASS0300DTO = "sysComBass0300Dto"; 

    /** set 급여수당그룹코드 : payExtpyGrpCd */
    public static final String ATTR_PAYEXTPYGRPCD = "payExtpyGrpCd";
    
    /** set 급여수당그룹 : payExtpyGrpNm */
    public static final String ATTR_PAYEXTPYGRPNM = "payExtpyGrpNm";
    
    /** set 급여공제그룹 : payDducGrpNm */
    public static final String ATTR_PAYDDUCGRPNM = "payDducGrpNm";

    /** set 급여항목코드명 : payExtpyNm */
    public static final String ATTR_PAYEXTPYNM = "payExtpyNm";

    /** set 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
    public static final String ATTR_PAYEXTPYPYMTPRDDIVCD = "payExtpyPymtPrdDivCd";
    
    /** set 급여수당지급시기구분 : payExtpyPymtPrdDivNm */
    public static final String ATTR_PAYEXTPYPYMTPRDDIVNM = "payExtpyPymtPrdDivNm";

    /** set 급여수당사용여부 : payExtpyUseYn */
    public static final String ATTR_PAYEXTPYUSEYN = "payExtpyUseYn";
    
    /** set 수당공제사용여부 : extptDducUseYn */
    public static final String ATTR_EXTPTDDUCUSEYN = "extptDducUseYn";
    
    /** set 화면출력여부 : extptDducDspyYn */
    public static final String ATTR_EXTPTDDUCDSPYYN = "extptDducDspyYn";
    
    /** set 통상임금여부 : usalyAmntYn */
    public static final String ATTR_USALYAMNTYN = "usalyAmntYn";

    /** set 급여수정가능여부 : payRevnPsbyYn */
    public static final String ATTR_PAYREVNPSBYYN = "payRevnPsbyYn";

    /** set 퇴직적용여부 : sevePayYn */
    public static final String ATTR_SEVEPAYYN = "sevePayYn";

    /** set 회계계정코드 : accAccCd */
    public static final String ATTR_ACCACCCD = "accAccCd";
    
    /** set 회계계정 : accAccNm */
    public static final String ATTR_ACCACCNM = "accAccNm";

    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public static final String ATTR_YRTXFREEDTYREDUCD = "yrtxFreeDtyReduCd";
    
    /** set 연말정산_비과세감면 : yrtxFreeDtyReduNm */
    public static final String ATTR_YRTXFREEDTYREDUNM = "yrtxFreeDtyReduNm";
    
    /** set 연말정산_기부금코드 : yrtxDotnCd */
    public static final String ATTR_YRTXDOTNCD = "yrtxDotnCd";
    
    /** set 연말정산_기부금명 : yrtxDotnNm */
    public static final String ATTR_YRTXDOTNNM = "yrtxDotnNm";

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
    
    /** set 기간제수당사용여부 : payrTermUseYn */
    public static final String ATTR_PAYRTERMUSEYN = "payrTermUseYn";

    /** set 지급공제구분코드  : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";
    

    /** set 지급공제구분  : pymtDducDivNm */
    public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";
    
    /** 생성자 */
     public Payr0485BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0485BM(
    		 String  dpobCd
    		, String  emymtDivCd
    		, String  payExtpyCd
    		, String  payItemCd
    		, String  payExtpyGrpCd 
    		, String  payExtpyGrpNm
    		, String  payDducGrpNm
    		, String  payExtpyNm 
    		, String  payExtpyPymtPrdDivCd 
    		, String  payExtpyPymtPrdDivNm
    		, String  payExtpyUseYn 
    		, String  extptDducUseYn
    		, String  extptDducDspyYn
    		, String  payRevnPsbyYn 
    		, String  sevePayYn 
    		, String  accAccCd 
    		, String  accAccNm
    		, String  yrtxFreeDtyReduCd 
    		, String  yrtxFreeDtyReduNm
    		, String  yrtxDotnCd
    		, String  yrtxDotnNm
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  pymtDducDivCd ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_PAYEXTPYCD,payExtpyCd);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_PAYEXTPYGRPCD,payExtpyGrpCd);
     	values.put(ATTR_PAYEXTPYGRPNM,payExtpyGrpNm);
     	values.put(ATTR_PAYDDUCGRPNM,payDducGrpNm);
     	values.put(ATTR_PAYEXTPYNM,payExtpyNm);
     	values.put(ATTR_PAYEXTPYPYMTPRDDIVCD,payExtpyPymtPrdDivCd);
     	values.put(ATTR_PAYEXTPYPYMTPRDDIVNM,payExtpyPymtPrdDivNm);
     	values.put(ATTR_PAYEXTPYUSEYN,payExtpyUseYn);
     	values.put(ATTR_PAYEXTPYUSEYN,payExtpyUseYn);
     	values.put(ATTR_EXTPTDDUCUSEYN,extptDducUseYn);
     	values.put(ATTR_EXTPTDDUCDSPYYN,extptDducDspyYn);
     	values.put(ATTR_SEVEPAYYN,sevePayYn);
     	values.put(ATTR_ACCACCCD,accAccCd);
     	values.put(ATTR_ACCACCNM,accAccNm);
     	values.put(ATTR_YRTXFREEDTYREDUCD,yrtxFreeDtyReduCd);
     	values.put(ATTR_YRTXFREEDTYREDUNM,yrtxFreeDtyReduNm);
     	values.put(ATTR_YRTXDOTNCD,yrtxDotnCd);
     	values.put(ATTR_YRTXDOTNNM,yrtxDotnNm);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); 
     	values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);} 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    
    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
    
 
    /** set 공통코드테스트 : sysComBass0300Dto */
  //  public void setMsfComBass0300Dto(PrgmComBass0300DTO  sysComBass0300Dto) { set( ATTR_MSFCOMBASS0300DTO ,sysComBass0300Dto);}
    /** get 공통코드테스트 : sysComBass0300Dto */
  //  public PrgmComBass0300DTO  getMsfComBass0300Dto() { return (PrgmComBass0300DTO)get( ATTR_MSFCOMBASS0300DTO );}
    
    /** set 급여수당코드 : payExtpyCd */
    public void setPayExtpyCd(String  payExtpyCd) { set( ATTR_PAYEXTPYCD ,payExtpyCd);}
    /** get 급여수당코드 : payExtpyCd */
    public String  getPayExtpyCd() { return (String )get( ATTR_PAYEXTPYCD );}
    
    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
    
    /** set 급여수당그룹코드 : payExtpyGrpCd */
    public void setPayExtpyGrpCd(String  payExtpyGrpCd) { set( ATTR_PAYEXTPYGRPCD ,payExtpyGrpCd);}
    /** get 급여수당그룹코드 : payExtpyGrpCd */
    public String  getPayExtpyGrpCd() { return (String )get( ATTR_PAYEXTPYGRPCD );}
    

    /** set 급여수당그룹 : payExtpyGrpNm */
    public void setPayExtpyGrpNm(String  payExtpyGrpNm) { set( ATTR_PAYEXTPYGRPNM ,payExtpyGrpNm);}
    /** get 급여수당그룹 : payExtpyGrpNm */
    public String  getPayExtpyGrpNm() { return (String )get( ATTR_PAYEXTPYGRPNM );}
    
    
    /** set 급여공제그룹 : payDducGrpNm */
    public void setPayDducGrpNm(String  payDducGrpNm) { set( ATTR_PAYDDUCGRPNM ,payDducGrpNm);}
    /** get 급여공제그룹 : payDducGrpNm */
    public String  getPayDducGrpNm() { return (String )get( ATTR_PAYDDUCGRPNM );}
    

	/** set 급여수당명 : payExtpyNm */
    public void setPayExtpyNm(String  payExtpyNm) { set( ATTR_PAYEXTPYNM ,payExtpyNm);}
    /** get 급여수당명 : payExtpyNm */
    public String  getPayExtpyNm() { return (String )get( ATTR_PAYEXTPYNM );}

    /** set 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
    public void setPayExtpyPymtPrdDivCd(String  payExtpyPymtPrdDivCd) { set( ATTR_PAYEXTPYPYMTPRDDIVCD ,payExtpyPymtPrdDivCd);}
    /** get 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
    public String  getPayExtpyPymtPrdDivCd() { return (String )get( ATTR_PAYEXTPYPYMTPRDDIVCD );}
    
    /** set 급여수당지급시기구분 : payExtpyPymtPrdDivNm */
    public void setPayExtpyPymtPrdDivNm(String  payExtpyPymtPrdDivNm) { set( ATTR_PAYEXTPYPYMTPRDDIVNM ,payExtpyPymtPrdDivNm);}
    /** get 급여수당지급시기구분 : payExtpyPymtPrdDivNm */
    public String  getPayExtpyPymtPrdDivNm() { return (String )get( ATTR_PAYEXTPYPYMTPRDDIVNM );}
    
    /** set 기간제수당사용여부 : payrTermUseYn */
    public void setPayrTermUseYn(String  payrTermUseYn) { set( ATTR_PAYRTERMUSEYN ,payrTermUseYn);}
    /** get 기간제수당사용여부 : payrTermUseYn */
    public String  getPayrTermUseYn() { return (String )get( ATTR_PAYRTERMUSEYN );}

    /** set 급여수당사용여부 : payExtpyUseYn */
    public void setPayExtpyUseYn(String  payExtpyUseYn) { set( ATTR_PAYEXTPYUSEYN ,payExtpyUseYn);}
    /** get 급여수당사용여부 : payExtpyUseYn */
    public String  getPayExtpyUseYn() { return (String )get( ATTR_PAYEXTPYUSEYN );}
    
    /** set 수당공제사용여부 : extpyDducUseYn */
    public void setExtpyDducUseYn(String  extptDducUseYn) { set( ATTR_EXTPTDDUCUSEYN ,extptDducUseYn);}
    /** get 수당공제사용여부 : extpyDducUseYn */
    public String  getExtpyDducUseYn() { return (String )get( ATTR_EXTPTDDUCUSEYN );}
    
    /** set 화면출력여부 : extpyDducDspyYn */
    public void setExtpyDducDspyYn(String  extptDducDspyYn) { set( ATTR_EXTPTDDUCDSPYYN ,extptDducDspyYn);}
    /** get 화면출력여부 : extpyDducDspyYn */
    public String  getExtpyDducDspyYn() { return (String )get( ATTR_EXTPTDDUCDSPYYN );}
    
    /** set 급여수정가능여부 : payRevnPsbyYn */
    public void setPayRevnPsbyYn(String  payRevnPsbyYn) { set( ATTR_PAYREVNPSBYYN ,payRevnPsbyYn);}
    /** get 급여수정가능여부 : payRevnPsbyYn */
    public String  getPayRevnPsbyYn() { return (String )get( ATTR_PAYREVNPSBYYN );}


    /** set 퇴직적용여부 : sevePayYn */
    public void setSevePayYn(String  sevePayYn) { set( ATTR_SEVEPAYYN ,sevePayYn);}
    /** get 퇴직적용여부 : sevePayYn */
    public String  getSevePayYn() { return (String )get( ATTR_SEVEPAYYN );}

    /** set 회계계정코드 : accAccCd */
    public void setAccAccCd(String  accAccCd) { set( ATTR_ACCACCCD ,accAccCd);}
    /** get 회계계정코드 : accAccCd */
    public String  getAccAccCd() { return (String )get( ATTR_ACCACCCD );}
    
    
    /** set 회계계정 : accAccNm */
    public void setAccAccNm(String  accAccNm) { set( ATTR_ACCACCNM ,accAccNm);}
    /** get 회계계정 : accAccNm */
    public String  getAccAccNm() { return (String )get( ATTR_ACCACCNM );}

    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public void setYrtxFreeDtyReduCd(String  yrtxFreeDtyReduCd) { set( ATTR_YRTXFREEDTYREDUCD ,yrtxFreeDtyReduCd);}
    /** get 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public String  getYrtxFreeDtyReduCd() { return (String )get( ATTR_YRTXFREEDTYREDUCD );}
    
    /** set 연말정산_비과세감면명 : yrtxFreeDtyReduNm */
    public void setYrtxFreeDtyReduNm(String  yrtxFreeDtyReduNm) { set( ATTR_YRTXFREEDTYREDUNM ,yrtxFreeDtyReduNm);}
    /** get 연말정산_비과세감면명 : yrtxFreeDtyReduNm */
    public String  getYrtxFreeDtyReduNm() { return (String )get( ATTR_YRTXFREEDTYREDUNM );}
    
    
    
    /** set 연말정산_기부금유형코드 : yrtxDotnCd */
    public void setYrtxDotnCd(String  yrtxDotnCd) { set( ATTR_YRTXDOTNCD ,yrtxDotnCd);}
    /** get 연말정산_기부금유형코드 : yrtxDotnCd */
    public String  getYrtxDotnCd() { return (String )get( ATTR_YRTXDOTNCD );}
    
    /** set 연말정산_기부금유형명 : yrtxDotnNm */
    public void setYrtxDotnNm(String  yrtxDotnNm) { set( ATTR_YRTXDOTNNM ,yrtxDotnNm);}
    /** get 연말정산_기부금유형명 : yrtxFreeDtyReduNm */
    public String  getYrtxDotnNm() { return (String )get( ATTR_YRTXDOTNNM );}
    

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

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}

    /** set 지급공제구분 : pymtDducDivNm */
    public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
    /** get 지급공제구분 : pymtDducDivNm */
    public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}
    
    /** set 통상임금여부 : usalyAmntYn */
    public void setUsalyAmntYn(String  usalyAmntYn) { set( ATTR_USALYAMNTYN ,usalyAmntYn);}
    /** get 통상임금여부 : usalyAmntYn */
    public String  getUsalyAmntYn() { return (String )get( ATTR_USALYAMNTYN );}

    
}
