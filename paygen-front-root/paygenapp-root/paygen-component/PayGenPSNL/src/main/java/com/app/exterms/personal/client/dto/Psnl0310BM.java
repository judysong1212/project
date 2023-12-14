package com.app.exterms.personal.client.dto;



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
public class Psnl0310BM    extends MSFSimpleBaseModel implements IsSerializable   {
	
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 발령일련번호 : appmtSeilNum */
    public static final String ATTR_APPMTSEILNUM = "appmtSeilNum";

    /** set 발령구분코드 : appmtDivCd */
    public static final String ATTR_APPMTDIVCD = "appmtDivCd";
    
    /** set 발령구분코드명 : appmtDivCdNm */
    public static final String ATTR_APPMTDIVCDNM = "appmtDivCdNm";

    /** set 발령일자 : appmtDt */
    public static final String ATTR_APPMTDT = "appmtDt";

    /** set 전_부서코드 : bfrDeptCd */
    public static final String ATTR_BFRDEPTCD = "bfrDeptCd";
    
    /** set 전_부서코드명 : bfrDeptNm */
    public static final String ATTR_BFRDEPTNM = "bfrDeptNm";

    /** set 전_사업코드 : bfrBusinCd */
    public static final String ATTR_BFRBUSINCD = "bfrBusinCd";
    
    /** set 전_사업코드명 : bfrBusinNm */
    public static final String ATTR_BFRBUSINM = "bfrBusinNm";
    
    /** set 전_직종구분코드 : bfrTypOccuDivCd */
    public static final String ATTR_BFRTYPOCCUDIVCD = "bfrTypOccuDivCd";
    
    /** set 전_직종구분코드명 : bfrTypOccuDivNm */
    public static final String ATTR_BFRTYPOCCUDIVNM = "bfrTypOccuDivNm";
    
    /** set 전_직책구분코드 : bfrOdtyDivCd */
    public static final String ATTR_BFRODTYDIVCD = "bfrOdtyDivCd";
    
    /** set 전_직책구분코드명 : bfrOdtyDivNm */
    public static final String ATTR_BFRODTYDIVNM = "bfrOdtyDivNm";

    /** set 전호봉코드 : bfrPyspCd */
    public static final String ATTR_BFRPYSPCD = "bfrPyspCd";
    
    /** set 전호봉코드명 : bfrPyspNm */
    public static final String ATTR_BFRPYSPNM = "bfrPyspNm";
    
    /** set 전호봉등급코드 : bfrPyspGrdeCd */
    public static final String ATTR_BFRPYSPGRDECD = "bfrPyspGrdeCd";

    /** set 전근속년수코드 : bfrLogSvcYrNumCd */
    public static final String ATTR_BFRLOGSVCYRNUMCD = "bfrLogSvcYrNumCd";

    /** set 후_부서코드 : aftDeptCd */
    public static final String ATTR_AFTDEPTCD = "aftDeptCd";
    
    /** set 후_부서코드명 : aftDeptNm */
    public static final String ATTR_AFTDEPTNM = "aftDeptNm";
    
    /** set 후_사업코드 : aftBusinCd */
    public static final String ATTR_AFTBUSINCD = "aftBusinCd";
    
    /** set 후_사업코드명 : aftBusinNm */
    public static final String ATTR_AFTBUSINNM = "aftBusinNm";

    /** set 후_직종구분코드 : aftTypOccuDivCd */
    public static final String ATTR_AFTTYPOCCUDIVCD = "aftTypOccuDivCd";
    
    /** set 후_직종구분코드명 : aftTypOccuDivNm */
    public static final String ATTR_AFTTYPOCCUDIVNM = "aftTypOccuDivNm";

    /** set 후_직책구분코드 : aftOdtyDivCd */
    public static final String ATTR_AFTODTYDIVCD = "aftOdtyDivCd";
    
    /** set 후_직책구분코드명 : aftOdtyDivNm */
    public static final String ATTR_AFTODTYDIVNM = "aftOdtyDivNm";
    

    /** set 후_호봉코드 : aftPyspCd */
    public static final String ATTR_AFTPYSPCD = "aftPyspCd";
    
    /** set 후_호봉코드명 : aftPyspNm */
    public static final String ATTR_AFTPYSPNM = "aftPyspNm";

    /** set 후_호봉등급코드 : aftPyspGrdeCd */
    public static final String ATTR_AFTPYSPGRDECD = "aftPyspGrdeCd";

    /** set 후_근속년수코드 : aftLogSvcYrNumCd */
    public static final String ATTR_AFTLOGSVCYRNUMCD = "aftLogSvcYrNumCd";

    /** set 발령확정여부 : appmtFixYn */
    public static final String ATTR_APPMTFIXYN = "appmtFixYn";
    
    /** set 발령확정여부명 : appmtFixYnNm */
    public static final String ATTR_APPMTFIXYNNM = "appmtFixYnNm";

    /** set 배치실행일자 : confrtnPrtcDt */
    public static final String ATTR_CONFRTNPRTCDT = "confrtnPrtcDt";

    /** set 배치처리여부 : confrtnPrcsYn */
    public static final String ATTR_CONFRTNPRCSYN = "confrtnPrcsYn";

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
    
    /** set 전_직종통합코드 : befTypOccuInttnCd */
    public static final String ATTR_BEFTYPOCCUINTTNCD = "befTypOccuInttnCd";

    /** set 후_직종통합코드 : aftTypOccuInttnCd */
    public static final String ATTR_AFTTYPOCCUINTTNCD = "aftTypOccuInttnCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 전직종세통합코드 : bfrDtilOccuInttnCd */
    public static final String ATTR_BFRDTILOCCUINTTNCD = "bfrDtilOccuInttnCd";
    
    /** set 전직종세통합코드 : bfrDtilOccuInttnCd */
    public static final String ATTR_BFRDTILOCCUINTTNNM = "bfrDtilOccuInttnNm";

    /** set 전근속월수코드 : bfrLogSvcMnthCd */
    public static final String ATTR_BFRLOGSVCMNTHCD = "bfrLogSvcMnthCd";

    /** set 후직종세통합코드 : aftDtilOccuInttnCd */
    public static final String ATTR_AFTDTILOCCUINTTNCD = "aftDtilOccuInttnCd";
    
    /** set 후직종세통합코드 : aftDtilOccuInttnCd */
    public static final String ATTR_AFTDTILOCCUINTTNNM = "aftDtilOccuInttnNm";

    /** set 후근속월수코드 : aftLogSvcMnthCd */
    public static final String ATTR_AFTLOGSVCMNTHCD = "aftLogSvcMnthCd";

    /** 생성자 */
     public Psnl0310BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0310BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, Long  appmtSeilNum 
    		, String  appmtDivCd 
    		, String  appmtDt 
    		, String  bfrDeptCd 
    		, String  bfrBusinCd 
    		, String  bfrTypOccuDivCd 
    		, String  bfrOdtyDivCd 
    		, String  bfrPyspCd 
    		, String  bfrPyspGrdeCd 
    		, String  bfrLogSvcYrNumCd 
    		, String  aftDeptCd 
    		, String  aftBusinCd 
    		, String  aftTypOccuDivCd 
    		, String  aftOdtyDivCd 
    		, String  aftPyspCd 
    		, String  aftPyspGrdeCd 
    		, String  aftLogSvcYrNumCd 
    		, String  appmtFixYn 
    		, String  confrtnPrtcDt 
    		, String  confrtnPrcsYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_APPMTSEILNUM,appmtSeilNum);
     	values.put(ATTR_APPMTDIVCD,appmtDivCd);
     	values.put(ATTR_APPMTDT,appmtDt);
     	values.put(ATTR_BFRDEPTCD,bfrDeptCd);
     	values.put(ATTR_BFRBUSINCD,bfrBusinCd);
     	values.put(ATTR_BFRTYPOCCUDIVCD,bfrTypOccuDivCd);
     	values.put(ATTR_BFRODTYDIVCD,bfrOdtyDivCd);
     	values.put(ATTR_BFRPYSPCD,bfrPyspCd);
     	values.put(ATTR_BFRPYSPGRDECD,bfrPyspGrdeCd);
     	values.put(ATTR_BFRLOGSVCYRNUMCD,bfrLogSvcYrNumCd);
     	values.put(ATTR_AFTDEPTCD,aftDeptCd);
     	values.put(ATTR_AFTBUSINCD,aftBusinCd);
     	values.put(ATTR_AFTTYPOCCUDIVCD,aftTypOccuDivCd);
     	values.put(ATTR_AFTODTYDIVCD,aftOdtyDivCd);
     	values.put(ATTR_AFTPYSPCD,aftPyspCd);
     	values.put(ATTR_AFTPYSPGRDECD,aftPyspGrdeCd);
     	values.put(ATTR_AFTLOGSVCYRNUMCD,aftLogSvcYrNumCd);
     	values.put(ATTR_APPMTFIXYN,appmtFixYn);
     	values.put(ATTR_CONFRTNPRTCDT,confrtnPrtcDt);
     	values.put(ATTR_CONFRTNPRCSYN,confrtnPrcsYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 발령일련번호 : appmtSeilNum */
    public void setAppmtSeilNum(Long  appmtSeilNum) { set( ATTR_APPMTSEILNUM ,appmtSeilNum);}
    /** get 발령일련번호 : appmtSeilNum */
    public Long  getAppmtSeilNum() { return (Long )get( ATTR_APPMTSEILNUM );}
    /** set 발령구분코드 : appmtDivCd */
    public void setAppmtDivCd(String  appmtDivCd) { set( ATTR_APPMTDIVCD ,appmtDivCd);}
    /** get 발령구분코드 : appmtDivCd */
    public String  getAppmtDivCd() { return (String )get( ATTR_APPMTDIVCD );}
    
    /** set 발령구분코드 : appmtDivCdNm */
    public void setAppmtDivCdNm(String  appmtDivCdNm) { set( ATTR_APPMTDIVCDNM ,appmtDivCdNm);}
    /** get 발령구분코드 : appmtDivCd */
    public String  getAppmtDivCdNm() { return (String )get( ATTR_APPMTDIVCDNM );}
    
    /** set 발령일자 : appmtDt */
    public void setAppmtDt(String  appmtDt) { set( ATTR_APPMTDT ,appmtDt);}
    /** get 발령일자 : appmtDt */
    public String  getAppmtDt() { return (String )get( ATTR_APPMTDT );}
    /** set 전_부서코드 : bfrDeptCd */
    public void setBfrDeptCd(String  bfrDeptCd) { set( ATTR_BFRDEPTCD ,bfrDeptCd);}
    /** get 전_부서코드 : bfrDeptCd */
    public String  getBfrDeptCd() { return (String )get( ATTR_BFRDEPTCD );}
    
    /** set 전_부서코드 : bfrDeptNm */
    public void setBfrDeptNm(String  bfrDeptNm) { set( ATTR_BFRDEPTNM ,bfrDeptNm);}
    /** get 전_부서코드 : bfrDeptCd */
    public String  getBfrDeptNm() { return (String )get( ATTR_BFRDEPTNM );}
    
    /** set 전_사업코드 : bfrBusinCd */
    public void setBfrBusinCd(String  bfrBusinCd) { set( ATTR_BFRBUSINCD ,bfrBusinCd);}
    /** get 전_사업코드 : bfrBusinCd */
    public String  getBfrBusinCd() { return (String )get( ATTR_BFRBUSINCD );}
    
    /** set 전_사업코드명 : bfrBusinNm */
    public void setBfrBusinNm(String  bfrBusinNm) { set( ATTR_BFRBUSINM ,bfrBusinNm);}
    /** get 전_사업코드 : bfrBusinCd */
    public String  getBfrBusinNm() { return (String )get( ATTR_BFRBUSINM );}
    
    /** set 전_직종구분코드 : bfrTypOccuDivCd */
    public void setBfrTypOccuDivCd(String  bfrTypOccuDivCd) { set( ATTR_BFRTYPOCCUDIVCD ,bfrTypOccuDivCd);}
    /** get 전_직종구분코드 : bfrTypOccuDivCd */
    public String  getBfrTypOccuDivCd() { return (String )get( ATTR_BFRTYPOCCUDIVCD );}
    
    
    /** set 전_직종구분코드명  : bfrTypOccuDivNm */
    public void setBfrTypOccuDivNm(String  bfrTypOccuDivNm) { set( ATTR_BFRTYPOCCUDIVNM ,bfrTypOccuDivNm);}
    /** get 전_직종구분코드명 : bfrTypOccuDivCd */
    public String  getBfrTypOccuDivNm() { return (String )get( ATTR_BFRTYPOCCUDIVNM );}
    
    
    /** set 전_직책구분코드 : bfrOdtyDivCd */
    public void setBfrOdtyDivCd(String  bfrOdtyDivCd) { set( ATTR_BFRODTYDIVCD ,bfrOdtyDivCd);}
    /** get 전_직책구분코드 : bfrOdtyDivCd */
    public String  getBfrOdtyDivCd() { return (String )get( ATTR_BFRODTYDIVCD );}
    
    /** set 전_직책구분코드명 : bfrOdtyDivNm */
    public void setBfrOdtyDivNm(String  bfrOdtyDivNm) { set( ATTR_BFRODTYDIVNM ,bfrOdtyDivNm);}
    /** get 전_직책구분코드명 : bfrOdtyDivNm */
    public String  getBfrOdtyDivNm() { return (String )get( ATTR_BFRODTYDIVNM );}
    
    /** set 전호봉코드 : bfrPyspCd */
    public void setBfrPyspCd(String  bfrPyspCd) { set( ATTR_BFRPYSPCD ,bfrPyspCd);}
    /** get 전호봉코드 : bfrPyspCd */
    public String  getBfrPyspCd() { return (String )get( ATTR_BFRPYSPCD );}
    
    /** set 전호봉코드명 : bfrPyspNm */
    public void setBfrPyspNm(String  bfrPyspNm) { set( ATTR_BFRPYSPNM ,bfrPyspNm);}
    /** get 전호봉코드명 : bfrPyspNm */
    public String  getBfrPyspNm() { return (String )get( ATTR_BFRPYSPNM );}
    
    /** set 전호봉등급코드 : bfrPyspGrdeCd */
    public void setBfrPyspGrdeCd(String  bfrPyspGrdeCd) { set( ATTR_BFRPYSPGRDECD ,bfrPyspGrdeCd);}
    /** get 전호봉등급코드 : bfrPyspGrdeCd */
    public String  getBfrPyspGrdeCd() { return (String )get( ATTR_BFRPYSPGRDECD );}
    /** set 전근속년수코드 : bfrLogSvcYrNumCd */
    public void setBfrLogSvcYrNumCd(String  bfrLogSvcYrNumCd) { set( ATTR_BFRLOGSVCYRNUMCD ,bfrLogSvcYrNumCd);}
    /** get 전근속년수코드 : bfrLogSvcYrNumCd */
    public String  getBfrLogSvcYrNumCd() { return (String )get( ATTR_BFRLOGSVCYRNUMCD );}
    /** set 후_부서코드 : aftDeptCd */
    public void setAftDeptCd(String  aftDeptCd) { set( ATTR_AFTDEPTCD ,aftDeptCd);}
    /** get 후_부서코드 : aftDeptCd */
    public String  getAftDeptCd() { return (String )get( ATTR_AFTDEPTCD );}
    
    /** set 후_부서코드 : aftDeptNm */
    public void setAftDeptNm(String  aftDeptNm) { set( ATTR_AFTDEPTNM ,aftDeptNm);}
    /** get 후_부서코드 : aftDeptNm */
    public String  getAftDeptNm() { return (String )get( ATTR_AFTDEPTNM );}
    
    /** set 후_사업코드 : aftBusinCd */
    public void setAftBusinCd(String  aftBusinCd) { set( ATTR_AFTBUSINCD ,aftBusinCd);}
    /** get 후_사업코드 : aftBusinCd */
    public String  getAftBusinCd() { return (String )get( ATTR_AFTBUSINCD );}
    
    /** set 후_사업코드 : aftBusinNm */
    public void setAftBusinNm(String  aftBusinNm) { set( ATTR_AFTBUSINNM ,aftBusinNm);}
    /** get 후_사업코드 : aftBusinNm */
    public String  getAftBusinNm() { return (String )get( ATTR_AFTBUSINNM );}
    
    /** set 후_직종구분코드 : aftTypOccuDivCd */
    public void setAftTypOccuDivCd(String  aftTypOccuDivCd) { set( ATTR_AFTTYPOCCUDIVCD ,aftTypOccuDivCd);}
    /** get 후_직종구분코드 : aftTypOccuDivCd */
    public String  getAftTypOccuDivCd() { return (String )get( ATTR_AFTTYPOCCUDIVCD );}
    
    /** set 후_직종구분코드 : aftTypOccuDivNm */
    public void setAftTypOccuDivNm(String  aftTypOccuDivNm) { set( ATTR_AFTTYPOCCUDIVNM ,aftTypOccuDivNm);}
    /** get 후_직종구분코드 : aftTypOccuDivNm */
    public String  getAftTypOccuDivNm() { return (String )get( ATTR_AFTTYPOCCUDIVNM );}
    
    
    /** set 후_직책구분코드 : aftOdtyDivCd */
    public void setAftOdtyDivCd(String  aftOdtyDivCd) { set( ATTR_AFTODTYDIVCD ,aftOdtyDivCd);}
    /** get 후_직책구분코드 : aftOdtyDivCd */
    public String  getAftOdtyDivCd() { return (String )get( ATTR_AFTODTYDIVCD );}
    
    
    /** set 후_직책구분코드 : aftOdtyDivNm */
    public void setAftOdtyDivNm(String  aftOdtyDivNm) { set( ATTR_AFTODTYDIVNM ,aftOdtyDivNm);}
    /** get 후_직책구분코드 : aftOdtyDivNm */
    public String  getAftOdtyDivNm() { return (String )get( ATTR_AFTODTYDIVNM );}
    
    /** set 후_호봉코드 : aftPyspCd */
    public void setAftPyspCd(String  aftPyspCd) { set( ATTR_AFTPYSPCD ,aftPyspCd);}
    /** get 후_호봉코드 : aftPyspCd */
    public String  getAftPyspCd() { return (String )get( ATTR_AFTPYSPCD );}
    
    /** set 후_호봉코드 : aftPyspNm */
    public void setAftPyspNm(String  aftPyspNm) { set( ATTR_AFTPYSPNM ,aftPyspNm);}
    /** get 후_호봉코드 : aftPyspCd */
    public String  getAftPyspNm() { return (String )get( ATTR_AFTPYSPNM );}
    
    /** set 후_호봉등급코드 : aftPyspGrdeCd */
    public void setAftPyspGrdeCd(String  aftPyspGrdeCd) { set( ATTR_AFTPYSPGRDECD ,aftPyspGrdeCd);}
    /** get 후_호봉등급코드 : aftPyspGrdeCd */
    public String  getAftPyspGrdeCd() { return (String )get( ATTR_AFTPYSPGRDECD );}
    /** set 후_근속년수코드 : aftLogSvcYrNumCd */
    public void setAftLogSvcYrNumCd(String  aftLogSvcYrNumCd) { set( ATTR_AFTLOGSVCYRNUMCD ,aftLogSvcYrNumCd);}
    /** get 후_근속년수코드 : aftLogSvcYrNumCd */
    public String  getAftLogSvcYrNumCd() { return (String )get( ATTR_AFTLOGSVCYRNUMCD );}
    /** set 발령확정여부 : appmtFixYn */
    public void setAppmtFixYn(String  appmtFixYn) { set( ATTR_APPMTFIXYN ,appmtFixYn);}
    /** get 발령확정여부 : appmtFixYn */
    public String  getAppmtFixYn() { return (String )get( ATTR_APPMTFIXYN );}
    
    /** set 발령확정여부 : appmtFixYnNm */
    public void setAppmtFixYnNm(String  appmtFixYnNm) { set( ATTR_APPMTFIXYNNM ,appmtFixYnNm);}
    /** get 발령확정여부 : appmtFixYnNm */
    public String  getAppmtFixYnNm() { return (String )get( ATTR_APPMTFIXYNNM );} 
    
    /** set 배치실행일자 : confrtnPrtcDt */
    public void setConfrtnPrtcDt(String  confrtnPrtcDt) { set( ATTR_CONFRTNPRTCDT ,confrtnPrtcDt);}
    /** get 배치실행일자 : confrtnPrtcDt */
    public String  getConfrtnPrtcDt() { return (String )get( ATTR_CONFRTNPRTCDT );}
    /** set 배치처리여부 : confrtnPrcsYn */
    public void setConfrtnPrcsYn(String  confrtnPrcsYn) { set( ATTR_CONFRTNPRCSYN ,confrtnPrcsYn);}
    /** get 배치처리여부 : confrtnPrcsYn */
    public String  getConfrtnPrcsYn() { return (String )get( ATTR_CONFRTNPRCSYN );}
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
    
    /** set 전_직종통합코드 : befTypOccuInttnCd */
    public void setBefTypOccuInttnCd(String  befTypOccuInttnCd) { set( ATTR_BEFTYPOCCUINTTNCD ,befTypOccuInttnCd);}
    /** get 전_직종통합코드 : befTypOccuInttnCd */
    public String  getBefTypOccuInttnCd() { return (String )get( ATTR_BEFTYPOCCUINTTNCD );}
    /** set 후_직종통합코드 : aftTypOccuInttnCd */
    public void setAftTypOccuInttnCd(String  aftTypOccuInttnCd) { set( ATTR_AFTTYPOCCUINTTNCD ,aftTypOccuInttnCd);}
    /** get 후_직종통합코드 : aftTypOccuInttnCd */
    public String  getAftTypOccuInttnCd() { return (String )get( ATTR_AFTTYPOCCUINTTNCD );}
    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
    /** set 전직종세통합코드 : bfrDtilOccuInttnCd */
    public void setBfrDtilOccuInttnCd(String  bfrDtilOccuInttnCd) { set( ATTR_BFRDTILOCCUINTTNCD ,bfrDtilOccuInttnCd);}
    /** get 전직종세통합코드 : bfrDtilOccuInttnCd */
    public String  getBfrDtilOccuInttnCd() { return (String )get( ATTR_BFRDTILOCCUINTTNCD );}
    /** set 전직종세통합코드 : bfrDtilOccuInttnCd */
    public void setBfrDtilOccuInttnNm(String  bfrDtilOccuInttnNm) { set( ATTR_BFRDTILOCCUINTTNNM ,bfrDtilOccuInttnNm);}
    /** get 전직종세통합코드 : bfrDtilOccuInttnCd */
    public String  getBfrDtilOccuInttnNm() { return (String )get( ATTR_BFRDTILOCCUINTTNNM );}
    /** set 전근속월수코드 : bfrLogSvcMnthCd */
    public void setBfrLogSvcMnthCd(String  bfrLogSvcMnthCd) { set( ATTR_BFRLOGSVCMNTHCD ,bfrLogSvcMnthCd);}
    /** get 전근속월수코드 : bfrLogSvcMnthCd */
    public String  getBfrLogSvcMnthCd() { return (String )get( ATTR_BFRLOGSVCMNTHCD );}
    /** set 후직종세통합코드 : aftDtilOccuInttnCd */
    public void setAftDtilOccuInttnCd(String  aftDtilOccuInttnCd) { set( ATTR_AFTDTILOCCUINTTNCD ,aftDtilOccuInttnCd);}
    /** get 후직종세통합코드 : aftDtilOccuInttnCd */
    public String  getAftDtilOccuInttnCd() { return (String )get( ATTR_AFTDTILOCCUINTTNCD );}
    /** set 후직종세통합코드 : aftDtilOccuInttnCd */
    public void setAftDtilOccuInttnNm(String  aftDtilOccuInttnNm) { set( ATTR_AFTDTILOCCUINTTNNM ,aftDtilOccuInttnNm);}
    /** get 후직종세통합코드 : aftDtilOccuInttnCd */
    public String  getAftDtilOccuInttnNm() { return (String )get( ATTR_AFTDTILOCCUINTTNNM );}
    /** set 후근속월수코드 : aftLogSvcMnthCd */
    public void setAftLogSvcMnthCd(String  aftLogSvcMnthCd) { set( ATTR_AFTLOGSVCMNTHCD ,aftLogSvcMnthCd);}
    /** get 후근속월수코드 : aftLogSvcMnthCd */
    public String  getAftLogSvcMnthCd() { return (String )get( ATTR_AFTLOGSVCMNTHCD );}

}
