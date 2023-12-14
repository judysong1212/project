package com.app.exterms.basis.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0400VO.java
 * @Description : Bass0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0400BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    /** 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** 부서명_한글 : deptNmHan */
    public static final String ATTR_DEPTNMHAN = "deptNmHan";

    /** 부서명_단축 : deptNmRtchnt */
    public static final String ATTR_DEPTNMRTCHNT = "deptNmRtchnt";

    /** 부서명_영문 : deptNmEng */
    public static final String ATTR_DEPTNMENG = "deptNmEng";

    /** 최상위부서코드 : tplvlDeptCd */
    public static final String ATTR_TPLVLDEPTCD = "tplvlDeptCd";
    
    /** s최상위부서코드 명 : tplvlDeptCdNm */
    public static final String ATTR_TPLVLDEPTCDNM = "tplvlDeptCdNm";
    
    /** 상위부서코드 : hhrkDeptCd */
    public static final String ATTR_HHRKDEPTCD = "hhrkDeptCd";
    
    /** 상위부서코드명 : hhrkDeptCdNm */
    public static final String ATTR_HHRKDEPTCDNM = "hhrkDeptCdNm";

    /** 부서사용여부 : deptUseYn */
    public static final String ATTR_DEPTUSEYN = "deptUseYn";

    /** 국민연금기호 : natPennSym */
    public static final String ATTR_NATPENNSYM = "natPennSym";

    /** 건강보험기호 : hlthInsrSym */
    public static final String ATTR_HLTHINSRSYM = "hlthInsrSym";

    /** 고용보험기호 : umytInsrSym */
    public static final String ATTR_UMYTINSRSYM = "umytInsrSym";

    /** 산재보험기호 : idtlAccdtInsurSym */
    public static final String ATTR_IDTLACCDTINSURSYM = "idtlAccdtInsurSym";

    /** 부서비고내용 : deptNoteCtnt */
    public static final String ATTR_DEPTNOTECTNT = "deptNoteCtnt";

    /** 부서출력여부 : deptDspyYn */
    public static final String ATTR_DEPTDSPYYN = "deptDspyYn";

    /** 관리부서코드 : mangeDeptCd */
    public static final String ATTR_MANGEDEPTCD = "mangeDeptCd";
    
    /** 관리부서코드 : mangeDeptCdNm */
    public static final String ATTR_MANGEDEPTCDNM = "mangeDeptCdNm";
    
    /** 관리부서명_한글 : mangeDeptNmHan */
    public static final String ATTR_MANGEDEPTNMHAN = "mangeDeptNmHan"; 
    
    /** 관리부서명_단축 : mangeDeptNmRtchnt */
    public static final String ATTR_MANGEDEPTNMRTCHNT = "mangeDeptNmRtchnt";  

    /** 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** 수정자주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    public static final String ATTR_PAYR_MANG_DEPT_CD = "payrMangDeptCd";

/** set 부서생서일자 : deptCreDt */
public static final String ATTR_DEPTCREDT = "deptCreDt";

/** set 부서폐지일자 : deptEndDt */
public static final String ATTR_DEPTENDDT = "deptEndDt";

/** set 개편전부서코드 : befDeptCd */
public static final String ATTR_BEFDEPTCD = "befDeptCd";

/** set 개편전부서명 : befDeptNm */
public static final String ATTR_BEFDEPTNM = "befDeptNm";

/** set 개편전부서코드02 : befDeptCd02 */
public static final String ATTR_BEFDEPTCD02 = "befDeptCd02";

/** set 개편전부서명02 : befDeptNm02 */
public static final String ATTR_BEFDEPTNM02 = "befDeptNm02";

    /** 생성자 */
     public Bass0400BM() { super(); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get( ATTR_DPOBCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String getDeptCd() { return (String)get( ATTR_DEPTCD );}

    /** set 부서명_한글 : deptNmHan */
    public void setDeptNmHan(String deptNmHan) { set( ATTR_DEPTNMHAN ,deptNmHan);}
    /** get 부서명_한글 : deptNmHan */
    public String getDeptNmHan() { return (String)get( ATTR_DEPTNMHAN );}

    /** set 부서명_단축 : deptNmRtchnt */
    public void setDeptNmRtchnt(String deptNmRtchnt) { set( ATTR_DEPTNMRTCHNT ,deptNmRtchnt);}
    /** get 부서명_단축 : deptNmRtchnt */
    public String getDeptNmRtchnt() { return (String)get( ATTR_DEPTNMRTCHNT );}

    /** set 부서명_영문 : deptNmEng */
    public void setDeptNmEng(String deptNmEng) { set( ATTR_DEPTNMENG ,deptNmEng);}
    /** get 부서명_영문 : deptNmEng */
    public String getDeptNmEng() { return (String)get( ATTR_DEPTNMENG );}

    /** set 최상위부서코드 : tplvlDeptCd */
    public void setTplvlDeptCd(String tplvlDeptCd) { set( ATTR_TPLVLDEPTCD ,tplvlDeptCd);}
    /** get 최상위부서코드 : tplvlDeptCd */
    public String getTplvlDeptCd() { return (String)get( ATTR_TPLVLDEPTCD );}
    
    /** set 최상위부서코드명 : tplvlDeptCdNm */
    public void setTplvlDeptCdNm(String tplvlDeptCdNm) { set( ATTR_TPLVLDEPTCDNM ,tplvlDeptCdNm);}
    /** get 최상위부서코드명 : tplvlDeptCdNm */
    public String getTplvlDeptCdNm() { return (String)get( ATTR_TPLVLDEPTCDNM );}
    
    /** set 상위부서코드 : hhrkDeptCd */
    public void setHhrkDeptCd(String hhrkDeptCd) { set( ATTR_HHRKDEPTCD ,hhrkDeptCd);}
    /** get 상위부서코드 : hhrkDeptCd */
    public String getHhrkDeptCd() { return (String)get( ATTR_HHRKDEPTCD );}
    
    /** set 상위부서코드명 : hhrkDeptCdNm */
    public void setHhrkDeptCdNm(String hhrkDeptCdNm) { set( ATTR_HHRKDEPTCDNM ,hhrkDeptCdNm);}
    /** get 상위부서코드명 : hhrkDeptCdNm */
    public String getHhrkDeptCdNm() { return (String)get( ATTR_HHRKDEPTCDNM );}
    
    /** set 부서사용여부 : deptUseYn */
    public void setDeptUseYn(String deptUseYn) { set( ATTR_DEPTUSEYN ,deptUseYn);}
    /** get 부서사용여부 : deptUseYn */
    public String getDeptUseYn() { return (String)get( ATTR_DEPTUSEYN );}

    /** set 국민연금기호 : natPennSym */
    public void setNatPennSym(String natPennSym) { set( ATTR_NATPENNSYM ,natPennSym);}
    /** get 국민연금기호 : natPennSym */
    public String getNatPennSym() { return (String)get( ATTR_NATPENNSYM );}

    /** set 건강보험기호 : hlthInsrSym */
    public void setHlthInsrSym(String hlthInsrSym) { set( ATTR_HLTHINSRSYM ,hlthInsrSym);}
    /** get 건강보험기호 : hlthInsrSym */
    public String getHlthInsrSym() { return (String)get( ATTR_HLTHINSRSYM );}

    /** set 고용보험기호 : umytInsrSym */
    public void setUmytInsrSym(String umytInsrSym) { set( ATTR_UMYTINSRSYM ,umytInsrSym);}
    /** get 고용보험기호 : umytInsrSym */
    public String getUmytInsrSym() { return (String)get( ATTR_UMYTINSRSYM );}

    /** set 산재보험기호 : idtlAccdtInsurSym */
    public void setIdtlAccdtInsurSym(String idtlAccdtInsurSym) { set( ATTR_IDTLACCDTINSURSYM ,idtlAccdtInsurSym);}
    /** get 산재보험기호 : idtlAccdtInsurSym */
    public String getIdtlAccdtInsurSym() { return (String)get( ATTR_IDTLACCDTINSURSYM );}

    /** set 부서비고내용 : deptNoteCtnt */
    public void setDeptNoteCtnt(String deptNoteCtnt) { set( ATTR_DEPTNOTECTNT ,deptNoteCtnt);}
    /** get 부서비고내용 : deptNoteCtnt */
    public String getDeptNoteCtnt() { return (String)get( ATTR_DEPTNOTECTNT );}

    /** set 부서출력여부 : deptDspyYn */
    public void setDeptDspyYn(String deptDspyYn) { set( ATTR_DEPTDSPYYN ,deptDspyYn);}
    /** get 부서출력여부 : deptDspyYn */
    public String getDeptDspyYn() { return (String)get( ATTR_DEPTDSPYYN );}

    /** set 관리부서코드 : mangeDeptCd */
    public void setMangeDeptCd(String mangeDeptCd) { set( ATTR_MANGEDEPTCD ,mangeDeptCd);}
    /** get 관리부서코드 : mangeDeptCd */
    public String getMangeDeptCd() { return (String)get( ATTR_MANGEDEPTCD );}
    
    /** set 관리부서코드명 : mangeDeptCdNm */
    public void setMangeDeptCdNm(String mangeDeptCdNm) { set( ATTR_MANGEDEPTCDNM ,mangeDeptCdNm);}
    /** get 관리부서코드명 : mangeDeptCdNm */
    public String getMangeDeptCdNm() { return (String)get( ATTR_MANGEDEPTCDNM );}

    /** set 입력자 : kybdr */
    public void setKybdr(String kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String getKybdr() { return (String)get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String getInptDt() { return (String)get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String getInptAddr() { return (String)get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String getIsmt() { return (String)get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String getRevnDt() { return (String)get( ATTR_REVNDT );}

    /** set 수정자주소 : revnAddr */
    public void setRevnAddr(String revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정자주소 : revnAddr */
    public String getRevnAddr() { return (String)get( ATTR_REVNADDR );}
 
    /** set 관리부서명_한글 : mangeDeptNmHan */    
    public void setMangeDeptNmHan(String mangeDeptNmHan) { set( ATTR_MANGEDEPTNMHAN ,mangeDeptNmHan);}
    /** get 관리부서명_한글 : mangeDeptNmHan */
    public String getMangeDeptNmHan() { return (String)get( ATTR_MANGEDEPTNMHAN );}
    
    /** set 관리부서명_단축 : mangeDeptNmRtchnt */
    public void setMangeDeptNmRtchnt(String mangeDeptNmRtchnt) { set( ATTR_MANGEDEPTNMRTCHNT ,mangeDeptNmRtchnt);}
    /** get 관리부서명_단축 : mangeDeptNmRtchnt */
    public String getMangeDeptNmRtchnt() { return (String)get( ATTR_MANGEDEPTNMRTCHNT );}
    
    /** set 단위기관 : payrMangDeptCd */
    public void setPayrMangDeptCd(String payrMangDeptCd) { set( ATTR_PAYR_MANG_DEPT_CD ,payrMangDeptCd);}
    /** get 단위기관 : payrMangDeptCd */
    public String getPayrMangDeptCd() { return (String)get( ATTR_PAYR_MANG_DEPT_CD );}

/** set 부서생서일자 : deptCreDt */
public void setDeptCreDt(String  deptCreDt) { set( ATTR_DEPTCREDT ,deptCreDt);}
/** get 부서생서일자 : deptCreDt */
public String  getDeptCreDt() { return (String )get( ATTR_DEPTCREDT );}

/** set 부서폐지일자 : deptEndDt */
public void setDeptEndDt(String  deptEndDt) { set( ATTR_DEPTENDDT ,deptEndDt);}
/** get 부서폐지일자 : deptEndDt */
public String  getDeptEndDt() { return (String )get( ATTR_DEPTENDDT );}

/** set 개편전부서코드 : befDeptCd */
public void setBefDeptCd(String befDeptCd) { set( ATTR_BEFDEPTCD ,befDeptCd);}
/** get 개편전부서코드 : befDeptCd */
public String getBefDeptCd() { return (String)get( ATTR_BEFDEPTCD );}

/** set 개편전부서명 : befDeptNm */
public void setBefDeptNm(String befDeptNm) { set( ATTR_BEFDEPTNM ,befDeptNm);}
/** get 개편전부서명 : befDeptNm */
public String getBefDeptNm() { return (String)get( ATTR_BEFDEPTNM );}

/** set 개편전부서코드02 : befDeptCd02 */
public void setBefDeptCd02(String befDeptCd02) { set( ATTR_BEFDEPTCD02 ,befDeptCd02);}
/** get 개편전부서코드02 : befDeptCd02 */
public String getBefDeptCd02() { return (String)get( ATTR_BEFDEPTCD02 );}

/** set 개편전부서명02 : befDeptNm02 */
public void setBefDeptNm02(String befDeptNm02) { set( ATTR_BEFDEPTNM02 ,befDeptNm02);}
/** get 개편전부서명02 : befDeptNm02 */
public String getBefDeptNm02() { return (String)get( ATTR_BEFDEPTNM02 );}

}
