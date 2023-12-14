package com.app.exterms.payroll.client.dto;
 
import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0130VO.java
 * @Description : Psnl0130 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014/07/31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0127BM   extends MSFSimpleBaseModel implements IsSerializable  {
	
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 사회보험년도 : soctyInsurYr */
    public static final String ATTR_SOCTYINSURYR = "soctyInsurYr";

    /** set 건강보험변동일자 : hlthInsurFlucDt */
    public static final String ATTR_HLTHINSURFLUCDT = "hlthInsurFlucDt";

    /** set 건강보험보수총액 : hlthInsrPayTotAmnt */
    public static final String ATTR_HLTHINSRPAYTOTAMNT = "hlthInsrPayTotAmnt";

    /** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
    public static final String ATTR_HLTHINSRMNTHRUNTNAMNT = "hlthInsrMnthRuntnAmnt";

    /** set 건강보험등급 : hlthInsrGrde */
    public static final String ATTR_HLTHINSRGRDE = "hlthInsrGrde";

    /** set 건강보험증번호 : hlthInsrCertNum */
    public static final String ATTR_HLTHINSRCERTNUM = "hlthInsrCertNum";

    /** set 국민연금변동일자 : natPennInsurFlucDt */
    public static final String ATTR_NATPENNINSURFLUCDT = "natPennInsurFlucDt";

    /** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
    public static final String ATTR_NATPENNSTDINCMMNTHAMNT = "natPennStdIncmMnthAmnt";

    /** set 국민연금등급 : natPennGrde */
    public static final String ATTR_NATPENNGRDE = "natPennGrde";

    /** set 건강보험적용여부 : hlthInsrApptnYn */
    public static final String ATTR_HLTHINSRAPPTNYN = "hlthInsrApptnYn";

    /** set 국민연금적용여부 : natPennApptnYn */
    public static final String ATTR_NATPENNAPPTNYN = "natPennApptnYn";

    /** set 고용보험적용여부 : umytInsrApptnYn */
    public static final String ATTR_UMYTINSRAPPTNYN = "umytInsrApptnYn";

    /** set 산재보험적용여부 : idtlAccdtInsurApptnYn */
    public static final String ATTR_IDTLACCDTINSURAPPTNYN = "idtlAccdtInsurApptnYn";

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

    /** set 고용보험변동일자 : umytInsrFlucDt */
    public static final String ATTR_UMYTINSRFLUCDT = "umytInsrFlucDt";

    /** set 고용보험보수총액 : umytInsrPayTotAmnt */
    public static final String ATTR_UMYTINSRPAYTOTAMNT = "umytInsrPayTotAmnt";

    /** set 고용보험보수월액 : umytInsrPayMnthAmnt */
    public static final String ATTR_UMYTINSRPAYMNTHAMNT = "umytInsrPayMnthAmnt";

    /** set 산재보험변동일자 : idtlAccdtFlucDt */
    public static final String ATTR_IDTLACCDTFLUCDT = "idtlAccdtFlucDt";

    /** set 산재보험보수총액 : idtlAccdtPayTotAmnt */
    public static final String ATTR_IDTLACCDTPAYTOTAMNT = "idtlAccdtPayTotAmnt";

    /** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
    public static final String ATTR_IDTLACCDTPAYMNTHAMNT = "idtlAccdtPayMnthAmnt";

    /** 생성자 */
     public Psnl0127BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0127BM(
             String  dpobCd 
            , String  systemkey 
            , String  soctyInsurYr 
            , String  hlthInsurFlucDt 
            , Long  hlthInsrPayTotAmnt 
            , Long  hlthInsrMnthRuntnAmnt 
            , String  hlthInsrGrde 
            , String  hlthInsrCertNum 
            , String  natPennInsurFlucDt 
            , Long  natPennStdIncmMnthAmnt 
            , String  natPennGrde 
            , String  hlthInsrApptnYn 
            , String  natPennApptnYn 
            , String  umytInsrApptnYn 
            , String  idtlAccdtInsurApptnYn 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr 
            , String  umytInsrFlucDt 
            , Long  umytInsrPayTotAmnt 
            , Long  umytInsrPayMnthAmnt 
            , String  idtlAccdtFlucDt 
            , Long  idtlAccdtPayTotAmnt 
            , Long  idtlAccdtPayMnthAmnt ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_SYSTEMKEY,systemkey);
        values.put(ATTR_SOCTYINSURYR,soctyInsurYr);
        values.put(ATTR_HLTHINSURFLUCDT,hlthInsurFlucDt);
        values.put(ATTR_HLTHINSRPAYTOTAMNT,hlthInsrPayTotAmnt);
        values.put(ATTR_HLTHINSRMNTHRUNTNAMNT,hlthInsrMnthRuntnAmnt);
        values.put(ATTR_HLTHINSRGRDE,hlthInsrGrde);
        values.put(ATTR_HLTHINSRCERTNUM,hlthInsrCertNum);
        values.put(ATTR_NATPENNINSURFLUCDT,natPennInsurFlucDt);
        values.put(ATTR_NATPENNSTDINCMMNTHAMNT,natPennStdIncmMnthAmnt);
        values.put(ATTR_NATPENNGRDE,natPennGrde);
        values.put(ATTR_HLTHINSRAPPTNYN,hlthInsrApptnYn);
        values.put(ATTR_NATPENNAPPTNYN,natPennApptnYn);
        values.put(ATTR_UMYTINSRAPPTNYN,umytInsrApptnYn);
        values.put(ATTR_IDTLACCDTINSURAPPTNYN,idtlAccdtInsurApptnYn);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr);
        values.put(ATTR_UMYTINSRFLUCDT,umytInsrFlucDt);
        values.put(ATTR_UMYTINSRPAYTOTAMNT,umytInsrPayTotAmnt);
        values.put(ATTR_UMYTINSRPAYMNTHAMNT,umytInsrPayMnthAmnt);
        values.put(ATTR_IDTLACCDTFLUCDT,idtlAccdtFlucDt);
        values.put(ATTR_IDTLACCDTPAYTOTAMNT,idtlAccdtPayTotAmnt);
        values.put(ATTR_IDTLACCDTPAYMNTHAMNT,idtlAccdtPayMnthAmnt); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 사회보험년도 : soctyInsurYr */
    public void setSoctyInsurYr(String  soctyInsurYr) { set( ATTR_SOCTYINSURYR ,soctyInsurYr);}
    /** get 사회보험년도 : soctyInsurYr */
    public String  getSoctyInsurYr() { return (String )get( ATTR_SOCTYINSURYR );}

    /** set 건강보험변동일자 : hlthInsurFlucDt */
    public void setHlthInsurFlucDt(String  hlthInsurFlucDt) { set( ATTR_HLTHINSURFLUCDT ,hlthInsurFlucDt);}
    /** get 건강보험변동일자 : hlthInsurFlucDt */
    public String  getHlthInsurFlucDt() { return (String )get( ATTR_HLTHINSURFLUCDT );}

    /** set 건강보험보수총액 : hlthInsrPayTotAmnt */
    public void setHlthInsrPayTotAmnt(Long  hlthInsrPayTotAmnt) { set( ATTR_HLTHINSRPAYTOTAMNT ,hlthInsrPayTotAmnt);}
    /** get 건강보험보수총액 : hlthInsrPayTotAmnt */
    public Long  getHlthInsrPayTotAmnt() { return (Long )get( ATTR_HLTHINSRPAYTOTAMNT );}

    /** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
    public void setHlthInsrMnthRuntnAmnt(Long  hlthInsrMnthRuntnAmnt) { set( ATTR_HLTHINSRMNTHRUNTNAMNT ,hlthInsrMnthRuntnAmnt);}
    /** get 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
    public Long  getHlthInsrMnthRuntnAmnt() { return (Long )get( ATTR_HLTHINSRMNTHRUNTNAMNT );}

    /** set 건강보험등급 : hlthInsrGrde */
    public void setHlthInsrGrde(String  hlthInsrGrde) { set( ATTR_HLTHINSRGRDE ,hlthInsrGrde);}
    /** get 건강보험등급 : hlthInsrGrde */
    public String  getHlthInsrGrde() { return (String )get( ATTR_HLTHINSRGRDE );}

    /** set 건강보험증번호 : hlthInsrCertNum */
    public void setHlthInsrCertNum(String  hlthInsrCertNum) { set( ATTR_HLTHINSRCERTNUM ,hlthInsrCertNum);}
    /** get 건강보험증번호 : hlthInsrCertNum */
    public String  getHlthInsrCertNum() { return (String )get( ATTR_HLTHINSRCERTNUM );}

    /** set 국민연금변동일자 : natPennInsurFlucDt */
    public void setNatPennInsurFlucDt(String  natPennInsurFlucDt) { set( ATTR_NATPENNINSURFLUCDT ,natPennInsurFlucDt);}
    /** get 국민연금변동일자 : natPennInsurFlucDt */
    public String  getNatPennInsurFlucDt() { return (String )get( ATTR_NATPENNINSURFLUCDT );}

    /** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
    public void setNatPennStdIncmMnthAmnt(Long  natPennStdIncmMnthAmnt) { set( ATTR_NATPENNSTDINCMMNTHAMNT ,natPennStdIncmMnthAmnt);}
    /** get 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
    public Long  getNatPennStdIncmMnthAmnt() { return (Long )get( ATTR_NATPENNSTDINCMMNTHAMNT );}

    /** set 국민연금등급 : natPennGrde */
    public void setNatPennGrde(String  natPennGrde) { set( ATTR_NATPENNGRDE ,natPennGrde);}
    /** get 국민연금등급 : natPennGrde */
    public String  getNatPennGrde() { return (String )get( ATTR_NATPENNGRDE );}

    /** set 건강보험적용여부 : hlthInsrApptnYn */
    public void setHlthInsrApptnYn(String  hlthInsrApptnYn) { set( ATTR_HLTHINSRAPPTNYN ,hlthInsrApptnYn);}
    /** get 건강보험적용여부 : hlthInsrApptnYn */
    public String  getHlthInsrApptnYn() { return (String )get( ATTR_HLTHINSRAPPTNYN );}

    /** set 국민연금적용여부 : natPennApptnYn */
    public void setNatPennApptnYn(String  natPennApptnYn) { set( ATTR_NATPENNAPPTNYN ,natPennApptnYn);}
    /** get 국민연금적용여부 : natPennApptnYn */
    public String  getNatPennApptnYn() { return (String )get( ATTR_NATPENNAPPTNYN );}

    /** set 고용보험적용여부 : umytInsrApptnYn */
    public void setUmytInsrApptnYn(String  umytInsrApptnYn) { set( ATTR_UMYTINSRAPPTNYN ,umytInsrApptnYn);}
    /** get 고용보험적용여부 : umytInsrApptnYn */
    public String  getUmytInsrApptnYn() { return (String )get( ATTR_UMYTINSRAPPTNYN );}

    /** set 산재보험적용여부 : idtlAccdtInsurApptnYn */
    public void setIdtlAccdtInsurApptnYn(String  idtlAccdtInsurApptnYn) { set( ATTR_IDTLACCDTINSURAPPTNYN ,idtlAccdtInsurApptnYn);}
    /** get 산재보험적용여부 : idtlAccdtInsurApptnYn */
    public String  getIdtlAccdtInsurApptnYn() { return (String )get( ATTR_IDTLACCDTINSURAPPTNYN );}

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

    /** set 고용보험변동일자 : umytInsrFlucDt */
    public void setUmytInsrFlucDt(String  umytInsrFlucDt) { set( ATTR_UMYTINSRFLUCDT ,umytInsrFlucDt);}
    /** get 고용보험변동일자 : umytInsrFlucDt */
    public String  getUmytInsrFlucDt() { return (String )get( ATTR_UMYTINSRFLUCDT );}

    /** set 고용보험보수총액 : umytInsrPayTotAmnt */
    public void setUmytInsrPayTotAmnt(Long  umytInsrPayTotAmnt) { set( ATTR_UMYTINSRPAYTOTAMNT ,umytInsrPayTotAmnt);}
    /** get 고용보험보수총액 : umytInsrPayTotAmnt */
    public Long  getUmytInsrPayTotAmnt() { return (Long )get( ATTR_UMYTINSRPAYTOTAMNT );}

    /** set 고용보험보수월액 : umytInsrPayMnthAmnt */
    public void setUmytInsrPayMnthAmnt(Long  umytInsrPayMnthAmnt) { set( ATTR_UMYTINSRPAYMNTHAMNT ,umytInsrPayMnthAmnt);}
    /** get 고용보험보수월액 : umytInsrPayMnthAmnt */
    public Long  getUmytInsrPayMnthAmnt() { return (Long )get( ATTR_UMYTINSRPAYMNTHAMNT );}

    /** set 산재보험변동일자 : idtlAccdtFlucDt */
    public void setIdtlAccdtFlucDt(String  idtlAccdtFlucDt) { set( ATTR_IDTLACCDTFLUCDT ,idtlAccdtFlucDt);}
    /** get 산재보험변동일자 : idtlAccdtFlucDt */
    public String  getIdtlAccdtFlucDt() { return (String )get( ATTR_IDTLACCDTFLUCDT );}

    /** set 산재보험보수총액 : idtlAccdtPayTotAmnt */
    public void setIdtlAccdtPayTotAmnt(Long  idtlAccdtPayTotAmnt) { set( ATTR_IDTLACCDTPAYTOTAMNT ,idtlAccdtPayTotAmnt);}
    /** get 산재보험보수총액 : idtlAccdtPayTotAmnt */
    public Long  getIdtlAccdtPayTotAmnt() { return (Long )get( ATTR_IDTLACCDTPAYTOTAMNT );}

    /** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
    public void setIdtlAccdtPayMnthAmnt(Long  idtlAccdtPayMnthAmnt) { set( ATTR_IDTLACCDTPAYMNTHAMNT ,idtlAccdtPayMnthAmnt);}
    /** get 산재보험보수월액 : idtlAccdtPayMnthAmnt */
    public Long  getIdtlAccdtPayMnthAmnt() { return (Long )get( ATTR_IDTLACCDTPAYMNTHAMNT );}

    
 
}
