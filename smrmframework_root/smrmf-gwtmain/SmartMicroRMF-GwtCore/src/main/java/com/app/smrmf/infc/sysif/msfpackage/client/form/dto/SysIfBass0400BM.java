package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0400VO.java
 * @Description : Bass0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfBass0400BM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    
    /** MANGE_DEPT_NM 관리부서명 */
    public static final String ATTR_MANGEDEPTNM  	 = "mangeDeptNm";
    
    /** MANGE_DEPT_NM 관리부서약어명 */
    public static final String ATTR_MANGEDEPTNMRTCHNT  	 = "mangeDeptNmRtchnt"; 
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 부서명_한글 : deptNmHan */
    public static final String ATTR_DEPTNMHAN = "deptNmHan";

    /** set 부서명_단축 : deptNmRtchnt */
    public static final String ATTR_DEPTNMRTCHNT = "deptNmRtchnt";

    /** set 부서명_영문 : deptNmEng */
    public static final String ATTR_DEPTNMENG = "deptNmEng";

    /** set 최상위부서코드 : tplvlDeptCd */
    public static final String ATTR_TPLVLDEPTCD = "tplvlDeptCd";

    /** set 상위부서코드 : hhrkDeptCd */
    public static final String ATTR_HHRKDEPTCD = "hhrkDeptCd";

    /** set null : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 부서사용여부 : deptUseYn */
    public static final String ATTR_DEPTUSEYN = "deptUseYn";

    /** set 국민연금기호 : natPennSym */
    public static final String ATTR_NATPENNSYM = "natPennSym";

    /** set 건강보험기호 : hlthInsrSym */
    public static final String ATTR_HLTHINSRSYM = "hlthInsrSym";

    /** set 고용보험기호 : umytInsrSym */
    public static final String ATTR_UMYTINSRSYM = "umytInsrSym";

    /** set 산재보험기호 : idtlAccdtInsurSym */
    public static final String ATTR_IDTLACCDTINSURSYM = "idtlAccdtInsurSym";

    /** set 부서비고내용 : deptNoteCtnt */
    public static final String ATTR_DEPTNOTECTNT = "deptNoteCtnt";

    /** set 부서출력여부 : deptDspyYn */
    public static final String ATTR_DEPTDSPYYN = "deptDspyYn";

    /** set 관리부서코드 : mangeDeptCd */
    public static final String ATTR_MANGEDEPTCD = "mangeDeptCd";

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

    /** set 수정자주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** set 부서순서 : deptRank */
    public static final String ATTR_DEPTRANK = "deptRank";

    public static final String ATTR_PAYR_MANG_DEPT_CD = "payrMangDeptCd";

    /** 생성자 */
     public SysIfBass0400BM() { super(); } 

    /** 일괄등록 처리   */
     public SysIfBass0400BM(
    		 String  dpobCd 
    		, String  deptCd 
    		, String  deptNmHan 
    		, String  deptNmRtchnt 
    		, String  deptNmEng 
    		, String  tplvlDeptCd 
    		, String  hhrkDeptCd 
    		, String  payrMangDeptCd 
    		, String  deptUseYn 
    		, String  natPennSym 
    		, String  hlthInsrSym 
    		, String  umytInsrSym 
    		, String  idtlAccdtInsurSym 
    		, String  deptNoteCtnt 
    		, String  deptDspyYn 
    		, String  mangeDeptCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  deptRank ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_DEPTNMHAN,deptNmHan);
     	values.put(ATTR_DEPTNMRTCHNT,deptNmRtchnt);
     	values.put(ATTR_DEPTNMENG,deptNmEng);
     	values.put(ATTR_TPLVLDEPTCD,tplvlDeptCd);
     	values.put(ATTR_HHRKDEPTCD,hhrkDeptCd);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_DEPTUSEYN,deptUseYn);
     	values.put(ATTR_NATPENNSYM,natPennSym);
     	values.put(ATTR_HLTHINSRSYM,hlthInsrSym);
     	values.put(ATTR_UMYTINSRSYM,umytInsrSym);
     	values.put(ATTR_IDTLACCDTINSURSYM,idtlAccdtInsurSym);
     	values.put(ATTR_DEPTNOTECTNT,deptNoteCtnt);
     	values.put(ATTR_DEPTDSPYYN,deptDspyYn);
     	values.put(ATTR_MANGEDEPTCD,mangeDeptCd);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_DEPTRANK,deptRank); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 부서명_한글 : deptNmHan */
    public void setDeptNmHan(String  deptNmHan) { set( ATTR_DEPTNMHAN ,deptNmHan);}
    /** get 부서명_한글 : deptNmHan */
    public String  getDeptNmHan() { return (String )get( ATTR_DEPTNMHAN );}

    /** set 부서명_단축 : deptNmRtchnt */
    public void setDeptNmRtchnt(String  deptNmRtchnt) { set( ATTR_DEPTNMRTCHNT ,deptNmRtchnt);}
    /** get 부서명_단축 : deptNmRtchnt */
    public String  getDeptNmRtchnt() { return (String )get( ATTR_DEPTNMRTCHNT );}

    /** set 부서명_영문 : deptNmEng */
    public void setDeptNmEng(String  deptNmEng) { set( ATTR_DEPTNMENG ,deptNmEng);}
    /** get 부서명_영문 : deptNmEng */
    public String  getDeptNmEng() { return (String )get( ATTR_DEPTNMENG );}

    /** set 최상위부서코드 : tplvlDeptCd */
    public void setTplvlDeptCd(String  tplvlDeptCd) { set( ATTR_TPLVLDEPTCD ,tplvlDeptCd);}
    /** get 최상위부서코드 : tplvlDeptCd */
    public String  getTplvlDeptCd() { return (String )get( ATTR_TPLVLDEPTCD );}

    /** set 상위부서코드 : hhrkDeptCd */
    public void setHhrkDeptCd(String  hhrkDeptCd) { set( ATTR_HHRKDEPTCD ,hhrkDeptCd);}
    /** get 상위부서코드 : hhrkDeptCd */
    public String  getHhrkDeptCd() { return (String )get( ATTR_HHRKDEPTCD );}

    /** set null : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get null : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 부서사용여부 : deptUseYn */
    public void setDeptUseYn(String  deptUseYn) { set( ATTR_DEPTUSEYN ,deptUseYn);}
    /** get 부서사용여부 : deptUseYn */
    public String  getDeptUseYn() { return (String )get( ATTR_DEPTUSEYN );}

    /** set 국민연금기호 : natPennSym */
    public void setNatPennSym(String  natPennSym) { set( ATTR_NATPENNSYM ,natPennSym);}
    /** get 국민연금기호 : natPennSym */
    public String  getNatPennSym() { return (String )get( ATTR_NATPENNSYM );}

    /** set 건강보험기호 : hlthInsrSym */
    public void setHlthInsrSym(String  hlthInsrSym) { set( ATTR_HLTHINSRSYM ,hlthInsrSym);}
    /** get 건강보험기호 : hlthInsrSym */
    public String  getHlthInsrSym() { return (String )get( ATTR_HLTHINSRSYM );}

    /** set 고용보험기호 : umytInsrSym */
    public void setUmytInsrSym(String  umytInsrSym) { set( ATTR_UMYTINSRSYM ,umytInsrSym);}
    /** get 고용보험기호 : umytInsrSym */
    public String  getUmytInsrSym() { return (String )get( ATTR_UMYTINSRSYM );}

    /** set 산재보험기호 : idtlAccdtInsurSym */
    public void setIdtlAccdtInsurSym(String  idtlAccdtInsurSym) { set( ATTR_IDTLACCDTINSURSYM ,idtlAccdtInsurSym);}
    /** get 산재보험기호 : idtlAccdtInsurSym */
    public String  getIdtlAccdtInsurSym() { return (String )get( ATTR_IDTLACCDTINSURSYM );}

    /** set 부서비고내용 : deptNoteCtnt */
    public void setDeptNoteCtnt(String  deptNoteCtnt) { set( ATTR_DEPTNOTECTNT ,deptNoteCtnt);}
    /** get 부서비고내용 : deptNoteCtnt */
    public String  getDeptNoteCtnt() { return (String )get( ATTR_DEPTNOTECTNT );}

    /** set 부서출력여부 : deptDspyYn */
    public void setDeptDspyYn(String  deptDspyYn) { set( ATTR_DEPTDSPYYN ,deptDspyYn);}
    /** get 부서출력여부 : deptDspyYn */
    public String  getDeptDspyYn() { return (String )get( ATTR_DEPTDSPYYN );}

    /** set 관리부서코드 : mangeDeptCd */
    public void setMangeDeptCd(String  mangeDeptCd) { set( ATTR_MANGEDEPTCD ,mangeDeptCd);}
    /** get 관리부서코드 : mangeDeptCd */
    public String  getMangeDeptCd() { return (String )get( ATTR_MANGEDEPTCD );}

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

    /** set 수정자주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정자주소 : revnAddr */
    public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}

    /** set 부서순서 : deptRank */
    public void setDeptRank(String  deptRank) { set( ATTR_DEPTRANK ,deptRank);}
    /** get 부서순서 : deptRank */
    public String  getDeptRank() { return (String )get( ATTR_DEPTRANK );}
 
}
