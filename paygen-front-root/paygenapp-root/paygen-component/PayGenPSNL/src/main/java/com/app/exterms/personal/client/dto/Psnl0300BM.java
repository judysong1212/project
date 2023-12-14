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
public class Psnl0300BM    extends MSFSimpleBaseModel implements IsSerializable   {
	
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";
    
    /** set 성 명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";
    
	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	
	/** set 상태 : appmtFixYnNm */
	public static final String ATTR_APPMTFIXYNNM = "appmtFixYnNm";
	
	/** set 상태 : appmtFixYn */
	public static final String ATTR_APPMTFIXYN = "appmtFixYn";
	
	/** set 전부서 : bfrDeptCd */
	public static final String ATTR_BFRDEPTCD = "bfrDeptCd";
	
	/** set 전부서 : bfrDeptNm */
	public static final String ATTR_BFRDEPTNM = "bfrDeptNm";
	
	/** set 전사업 : bfrBusinCd */
	public static final String ATTR_BFRBUSINCD = "bfrBusinCd";
	
	/** set 전사업 : bfrBusinNm" */
	public static final String ATTR_BFRBUSINNM = "bfrBusinNm";
	
	/** set 전직종 : bfrTypOccuDivCd */
	public static final String ATTR_BFRTYPOCCUDIVCD = "bfrTypOccuDivCd";
	
	/** set 전직종 : bfrTypOccuDivNm */
	public static final String ATTR_BFRTYPOCCUDIVNM = "bfrTypOccuDivNm";

	/** set 전직책 : bfrOdtyDivCd */
	public static final String ATTR_BFRODTYDIVCD = "bfrOdtyDivCd";
	
	/** set 전직책 : bfrOdtyDivNm */
	public static final String ATTR_BFRODTYDIVNM = "bfrOdtyDivNm";
	
	/** set 전호봉 : bfrPyspCd */
	public static final String ATTR_BFRPYSPCD = "bfrPyspCd";
	
	/** set 전호봉 : bfrPyspNm */
	public static final String ATTR_BFRPYSPNM = "bfrPyspNm";
	
	/** set 후부서 : aftDeptNm */
	public static final String ATTR_AFTDEPTCD = "aftDeptCd";
	
	/** set 후부서 : aftDeptNm */
	public static final String ATTR_AFTDEPTNM = "aftDeptNm";
	
	/** set 후사업 : aftBusinCd */
	public static final String ATTR_AFTBUSINCD = "aftBusinCd";
	
	/** set 후사업 : aftBusinNm */
	public static final String ATTR_AFTBUSINNM = "aftBusinNm";
	
	/** set 후직종 : aftTypOccuDivCd */
	public static final String ATTR_AFTTYPOCCUDIVCD = "aftTypOccuDivCd";
	
	/** set 후직종 : aftTypOccuDivNm */
	public static final String ATTR_AFTTYPOCCUDIVNM = "aftTypOccuDivNm";
	
	/** set 후직책 : aftOdtyDivCd */
	public static final String ATTR_AFTODTYDIVCD = "aftOdtyDivCd";
	
	/** set 후직책 : aftOdtyDivNm */
	public static final String ATTR_AFTODTYDIVNM = "aftOdtyDivNm";
	
	/** set 후호봉 : aftPyspCd */
	public static final String ATTR_AFTPYSPCD = "aftPyspCd";
	
	/** set 후호봉 : aftPyspNm */
	public static final String ATTR_AFTPYSPNM = "aftPyspNm";
	
    /** set 발령번호 : appmtNum */
    public static final String ATTR_APPMTNUM = "appmtNum";

    /** set 발령구분코드 : appmtDivCd */
    public static final String ATTR_APPMTDIVCD = "appmtDivCd";
    
    /** set 발령구분코드 : appmtDivCdNm */
    public static final String ATTR_APPMTDIVCDNM = "appmtDivCdNm";

    /** set 발령일자 : appmtDt */
    public static final String ATTR_APPMTDT = "appmtDt";

    /** set 발령근거내용 : appmtBssCtnt */
    public static final String ATTR_APPMTBSSCTNT = "appmtBssCtnt";

    /** set 발령기관 : appmtIstut */
    public static final String ATTR_APPMTISTUT = "appmtIstut";

    /** set 시작일자 : bgnnDt */
    public static final String ATTR_BGNNDT = "bgnnDt";

    /** set 종료일자 : endDt */
    public static final String ATTR_ENDDT = "endDt";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직책코드 : odtyCd */
    public static final String ATTR_ODTYCD = "odtyCd";

    /** set 호봉코드 : pyspCd */
    public static final String ATTR_PYSPCD = "pyspCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 근속년수코드 : logSvcYrNumCd */
    public static final String ATTR_LOGSVCYRNUMCD = "logSvcYrNumCd";

    /** set 징계구분코드 : dsnyActDivCd */
    public static final String ATTR_DSNYACTDIVCD = "dsnyActDivCd";

    /** set 감봉월수 : ctwpMnthNum */
    public static final String ATTR_CTWPMNTHNUM = "ctwpMnthNum";

    /** set 인사발령비고내용 : pernAppmtNoteCtnt */
    public static final String ATTR_PERNAPPMTNOTECTNT = "pernAppmtNoteCtnt";

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

    /** set 발령일련번호 : appmtSeilNum */
    public static final String ATTR_APPMTSEILNUM = "appmtSeilNum";

    /** 생성자 */
     public Psnl0300BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0300BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  appmtNum 
    		, String  appmtDivCd 
    		, String  appmtDt 
    		, String  appmtBssCtnt 
    		, String  appmtIstut 
    		, String  bgnnDt 
    		, String  endDt 
    		, String  deptCd 
    		, String  businCd 
    		, String  typOccuCd 
    		, String  odtyCd 
    		, String  pyspCd 
    		, String  pyspGrdeCd 
    		, String  logSvcYrNumCd 
    		, String  dsnyActDivCd 
    		, Long  ctwpMnthNum 
    		, String  pernAppmtNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, Long  appmtSeilNum ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_APPMTNUM,appmtNum);
     	values.put(ATTR_APPMTDIVCD,appmtDivCd);
     	values.put(ATTR_APPMTDT,appmtDt);
     	values.put(ATTR_APPMTBSSCTNT,appmtBssCtnt);
     	values.put(ATTR_APPMTISTUT,appmtIstut);
     	values.put(ATTR_BGNNDT,bgnnDt);
     	values.put(ATTR_ENDDT,endDt);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_ODTYCD,odtyCd);
     	values.put(ATTR_PYSPCD,pyspCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_LOGSVCYRNUMCD,logSvcYrNumCd);
     	values.put(ATTR_DSNYACTDIVCD,dsnyActDivCd);
     	values.put(ATTR_CTWPMNTHNUM,ctwpMnthNum);
     	values.put(ATTR_PERNAPPMTNOTECTNT,pernAppmtNoteCtnt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_APPMTSEILNUM,appmtSeilNum); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
	/** set 상태 : appmtFixYnNm */
	public void setAppmtFixYnNm(String  appmtFixYnNm) { set( ATTR_APPMTFIXYNNM ,appmtFixYnNm);}
	/** get 상태 : appmtFixYnNm */
	public String  getAppmtFixYnNm() { return (String )get( ATTR_APPMTFIXYNNM );}
	/** set 상태 : appmtFixYn */
	public void setAppmtFixYn(String  appmtFixYn) { set( ATTR_APPMTFIXYN ,appmtFixYn);}
	/** get 상태 : appmtFixYn */
	public String  getAppmtFixYn() { return (String )get( ATTR_APPMTFIXYN );}
    /** set 발령번호 : appmtNum */
    public void setAppmtNum(String  appmtNum) { set( ATTR_APPMTNUM ,appmtNum);}
    /** get 발령번호 : appmtNum */
    public String  getAppmtNum() { return (String )get( ATTR_APPMTNUM );}
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
    /** set 발령근거내용 : appmtBssCtnt */
    public void setAppmtBssCtnt(String  appmtBssCtnt) { set( ATTR_APPMTBSSCTNT ,appmtBssCtnt);}
    /** get 발령근거내용 : appmtBssCtnt */
    public String  getAppmtBssCtnt() { return (String )get( ATTR_APPMTBSSCTNT );}
    /** set 발령기관 : appmtIstut */
    public void setAppmtIstut(String  appmtIstut) { set( ATTR_APPMTISTUT ,appmtIstut);}
    /** get 발령기관 : appmtIstut */
    public String  getAppmtIstut() { return (String )get( ATTR_APPMTISTUT );}
    /** set 시작일자 : bgnnDt */
    public void setBgnnDt(String  bgnnDt) { set( ATTR_BGNNDT ,bgnnDt);}
    /** get 시작일자 : bgnnDt */
    public String  getBgnnDt() { return (String )get( ATTR_BGNNDT );}
    /** set 종료일자 : endDt */
    public void setEndDt(String  endDt) { set( ATTR_ENDDT ,endDt);}
    /** get 종료일자 : endDt */
    public String  getEndDt() { return (String )get( ATTR_ENDDT );}
    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    /** set 직책코드 : odtyCd */
    public void setOdtyCd(String  odtyCd) { set( ATTR_ODTYCD ,odtyCd);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyCd() { return (String )get( ATTR_ODTYCD );}
    /** set 호봉코드 : pyspCd */
    public void setPyspCd(String  pyspCd) { set( ATTR_PYSPCD ,pyspCd);}
    /** get 호봉코드 : pyspCd */
    public String  getPyspCd() { return (String )get( ATTR_PYSPCD );}
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
    /** set 근속년수코드 : logSvcYrNumCd */
    public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( ATTR_LOGSVCYRNUMCD ,logSvcYrNumCd);}
    /** get 근속년수코드 : logSvcYrNumCd */
    public String  getLogSvcYrNumCd() { return (String )get( ATTR_LOGSVCYRNUMCD );}
    /** set 징계구분코드 : dsnyActDivCd */
    public void setDsnyActDivCd(String  dsnyActDivCd) { set( ATTR_DSNYACTDIVCD ,dsnyActDivCd);}
    /** get 징계구분코드 : dsnyActDivCd */
    public String  getDsnyActDivCd() { return (String )get( ATTR_DSNYACTDIVCD );}
    /** set 감봉월수 : ctwpMnthNum */
    public void setCtwpMnthNum(Long  ctwpMnthNum) { set( ATTR_CTWPMNTHNUM ,ctwpMnthNum);}
    /** get 감봉월수 : ctwpMnthNum */
    public Long  getCtwpMnthNum() { return (Long )get( ATTR_CTWPMNTHNUM );}
    /** set 인사발령비고내용 : pernAppmtNoteCtnt */
    public void setPernAppmtNoteCtnt(String  pernAppmtNoteCtnt) { set( ATTR_PERNAPPMTNOTECTNT ,pernAppmtNoteCtnt);}
    /** get 인사발령비고내용 : pernAppmtNoteCtnt */
    public String  getPernAppmtNoteCtnt() { return (String )get( ATTR_PERNAPPMTNOTECTNT );}
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
    /** set 발령일련번호 : appmtSeilNum */
    public void setAppmtSeilNum(Long  appmtSeilNum) { set( ATTR_APPMTSEILNUM ,appmtSeilNum);}
    /** get 발령일련번호 : appmtSeilNum */
    public Long  getAppmtSeilNum() { return (Long )get( ATTR_APPMTSEILNUM );}
    
    /** set 전부서 : bfrDeptCd */
    public void setBfrDeptCd(String   bfrDeptCd) { set( ATTR_BFRDEPTCD ,bfrDeptCd);}
    /** get 전부서 : bfrDeptCd */
    public String  getBfrDeptCd() { return (String  )get( ATTR_BFRDEPTCD );}
    
    
    /** set 전부서 : bfrDeptNm */
    public void setBfrDeptNm(String   bfrDeptNm) { set( ATTR_BFRDEPTNM ,bfrDeptNm);}
    /** get 전부서 : bfrDeptNm */
    public String  getBfrDeptNm() { return (String  )get( ATTR_BFRDEPTNM );}
    
    /** set 전사업 : bfrBusinCd */
    public void setBfrBusinCd(String   bfrBusinCd) { set( ATTR_BFRBUSINCD ,bfrBusinCd);}
    /** get 전사업 : bfrBusinCd */
    public String  getBfrBusinCd() { return (String  )get( ATTR_BFRBUSINCD );}
    
    /** set 전사업 : bfrBusinNm */
    public void setBfrBusinNm(String   bfrBusinNm) { set( ATTR_BFRBUSINNM ,bfrBusinNm);}
    /** get 전사업 : bfrBusinNm */
    public String  getBfrBusinNm() { return (String  )get( ATTR_BFRBUSINNM );}
    
    /** set 전직종 : bfrTypOccuDivCd */
    public void setBfrTypOccuDivCd(String   bfrTypOccuDivCd) { set( ATTR_BFRTYPOCCUDIVCD ,bfrTypOccuDivCd);}
    /** get 전직종 : bfrTypOccuDivCd */
    public String  getBfrTypOccuDivCd() { return (String  )get( ATTR_BFRTYPOCCUDIVCD );}
    
    /** set 전직종 : bfrTypOccuDivNm */
    public void setBfrTypOccuDivNm(String   bfrTypOccuDivNm) { set( ATTR_BFRTYPOCCUDIVNM ,bfrTypOccuDivNm);}
    /** get 전직종 : bfrTypOccuDivNm */
    public String  getBfrTypOccuDivNm() { return (String  )get( ATTR_BFRTYPOCCUDIVNM );}
    
    
    /** set 전직책 : bfrOdtyDivCd */
    public void setBfrOdtyDivCd(String   bfrOdtyDivCd) { set( ATTR_BFRODTYDIVCD ,bfrOdtyDivCd);}
    /** get 전직책 : bfrOdtyDivCd */
    public String  getBfrOdtyDivCd() { return (String  )get( ATTR_BFRODTYDIVCD );}
    
    /** set 전직책 : bfrOdtyDivNm */
    public void setBfrOdtyDivNm(String   bfrOdtyDivNm) { set( ATTR_BFRODTYDIVNM ,bfrOdtyDivNm);}
    /** get 전직책 : bfrOdtyDivNm */
    public String  getBfrOdtyDivNm() { return (String  )get( ATTR_BFRODTYDIVNM );}
    
    /** set 전호봉 : bfrPyspCd */
    public void setBfrPyspCd(String   bfrPyspCd) { set( ATTR_BFRPYSPCD ,bfrPyspCd);}
    /** get 전호봉 : bfrPyspCd */
    public String  getBfrPyspCd() { return (String  )get( ATTR_BFRPYSPCD );}
    
    /** set 전호봉 : bfrPyspNm */
    public void setBfrPyspNm(String   bfrPyspNm) { set( ATTR_BFRPYSPNM ,bfrPyspNm);}
    /** get 전호봉 : bfrPyspNm */
    public String  getBfrPyspNm() { return (String  )get( ATTR_BFRPYSPNM );}
    
    
    /** set 후부서 : aftDeptCd */
    public void setAftDeptCd(String   aftDeptCd) { set( ATTR_AFTDEPTCD, aftDeptCd);}
    /** get 후부서 : aftDeptCd */
    public String  getAftDeptCd() { return (String  )get( ATTR_AFTDEPTCD );}
    
    /** set 후부서 : aftDeptNm */
    public void setAftDeptNm(String   aftDeptNm) { set( ATTR_AFTDEPTNM, aftDeptNm);}
    /** get 후부서 : aftDeptNm */
    public String  getAftDeptNm() { return (String  )get( ATTR_AFTDEPTNM );}
    
    
    
    /** set 후사업 : aftBusinCd */
    public void setAftBusinCd(String   aftBusinCd) { set( ATTR_AFTBUSINCD, aftBusinCd);}
    /** get 후사업 : aftBusinCd */
    public String  getAftBusinCd() { return (String  )get( ATTR_AFTBUSINCD );}
    
    /** set 후사업 : aftBusinNm */
    public void setAftBusinNm(String   aftBusinNm) { set( ATTR_AFTBUSINNM, aftBusinNm);}
    /** get 후사업 : aftBusinNm */
    public String  getAftBusinNm() { return (String  )get( ATTR_AFTBUSINNM );}
    
    /** set 후직종 : aftTypOccuDivCd */
    public void setAftTypOccuDivCd(String   aftTypOccuDivCd) { set( ATTR_AFTTYPOCCUDIVCD, aftTypOccuDivCd);}
    /** get 후직종 : aftTypOccuDivCd */
    public String  getAftTypOccuDivCd() { return (String  )get( ATTR_AFTTYPOCCUDIVCD );}
    
    /** set 후직종 : aftTypOccuDivNm */
    public void setAftTypOccuDivNm(String   aftTypOccuDivNm) { set( ATTR_AFTTYPOCCUDIVNM, aftTypOccuDivNm);}
    /** get 후직종 : aftTypOccuDivNm */
    public String  getAftTypOccuDivNm() { return (String  )get( ATTR_AFTTYPOCCUDIVNM );}
    
    /** set 후직책 : aftOdtyDivCd */
    public void setAftOdtyDivCd(String   aftOdtyDivCd) { set( ATTR_AFTODTYDIVCD, aftOdtyDivCd);}
    /** get 후직책 : aftOdtyDivCd */
    public String  getAftOdtyDivCd() { return (String  )get( ATTR_AFTODTYDIVCD );}
    
    /** set 후직책 : aftOdtyDivNm */
    public void setAftOdtyDivNm(String   aftOdtyDivNm) { set( ATTR_AFTODTYDIVNM, aftOdtyDivNm);}
    /** get 후직책 : aftOdtyDivNm */
    public String  getAftOdtyDivNm() { return (String  )get( ATTR_AFTODTYDIVNM );}
    
    /** set 후호봉 : aftPyspCd */
    public void setAftPyspCd(String   aftPyspCd) { set( ATTR_AFTPYSPCD, aftPyspCd);}
    /** get 후호봉 : aftPyspCd */
    public String  geTAftPyspCd() { return (String  )get( ATTR_AFTPYSPCD);}
    
    /** set 후호봉 : aftPyspNm */
    public void setAftPyspNm(String   aftPyspNm) { set( ATTR_AFTPYSPNM, aftPyspNm);}
    /** get 후호봉 : aftPyspNm */
    public String  geTAftPyspNm() { return (String  )get( ATTR_AFTPYSPNM);}
    
     
}
