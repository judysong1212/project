package com.app.exterms.yearendtax.client.dto.yeta2022;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye17Ta1000BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 시스템키 : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 연말정산마감일련번호 : edacSeilNum */
    public static final String ATTR_EDACSEILNUM = "edacSeilNum";

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
    /** set 원천징수의무부서코드 : yetaDpcd */
    public static final String ATTR_YETADPCD = "yetaDpcd";
    
    /** set A9_사업자등록번호 : busoprRgstnum */
    public static final String ATTR_BUSOPRRGSTNUM = "busoprRgstnum";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 생성직원번호 : pernChrgEmpIdenNum */
    public static final String ATTR_PERNCHRGEMPIDENNUM = "pernChrgEmpIdenNum";

    /** set 마감여부 : closFlag */
    public static final String ATTR_CLOSFLAG = "closFlag";

    /** set 마감건수 : closCont */
    public static final String ATTR_CLOSCONT = "closCont";

    /** set 마감일자 : closDate */
    public static final String ATTR_CLOSDATE = "closDate";

    /** set 연말정산제출일자 : edacPrdt */
    public static final String ATTR_EDACPRDT = "edacPrdt";

    /** set 대표자성명 : reprName */
    public static final String ATTR_REPRNAME = "reprName";

    /** set 법인명_상호 : juriName */
    public static final String ATTR_JURINAME = "juriName";

    /** set 사업자등록번호 : busiNumb */
    public static final String ATTR_BUSINUMB = "busiNumb";

    /** set 주민등록번호 : resuNumb */
    public static final String ATTR_RESUNUMB = "resuNumb";

    /** set 법인번호 : juriNumb */
    public static final String ATTR_JURINUMB = "juriNumb";

    /** set 소득신고의무자우편번호 : incmPost */
    public static final String ATTR_INCMPOST = "incmPost";

    /** set 소득신고의무자기본주소 : incmAddr */
    public static final String ATTR_INCMADDR = "incmAddr";

    /** set 소득신고의무자상세주소 : incmAdtl */
    public static final String ATTR_INCMADTL = "incmAdtl";

    /** set 관할세무서코드 : taxaCode */
    public static final String ATTR_TAXACODE = "taxaCode";

    /** set 제출자구분코드 : incmGbcd */
    public static final String ATTR_INCMGBCD = "incmGbcd";

    /** set 세무대리인번호 : taxaDnum */
    public static final String ATTR_TAXADNUM = "taxaDnum";

    /** set 홈텍스ID : homeTxid */
    public static final String ATTR_HOMETXID = "homeTxid";

    /** set 세무프로그램코드 : taxaPrcd */
    public static final String ATTR_TAXAPRCD = "taxaPrcd";

    /** set 담당자부서명 : charDept */
    public static final String ATTR_CHARDEPT = "charDept";

    /** set 담당자성명 : charName */
    public static final String ATTR_CHARNAME = "charName";

    /** set 담당자전화번호 : charTele */
    public static final String ATTR_CHARTELE = "charTele";

    /** set FILE_PASS : filePass */
    public static final String ATTR_FILEPASS = "filePass";

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
    
    
    /** set 부서명 : deptNm */
 	public static final String ATTR_DEPTNM = "deptNm";

	  
    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";

	/** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

	/** set 직종세통합코드명 : dtilOccuInttnNm */
    public static final String ATTR_DTILOCCUINTTNNM = "dtilOccuInttnNm";
    
    /** set 고용구분명 : emymtDivCd */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";
    
    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
    

	
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";


    /** set 총급여액 : item01 */
    public static final String ATTR_ITEM01 = "item01";
    
    /** set 비과세  : item02 */
    public static final String ATTR_ITEM02 = "item02";
    
    /** set 소득세  : item03 */
    public static final String ATTR_ITEM03 = "item03";
    
    /** set 주민세 : item04 */
    public static final String ATTR_ITEM04 = "item04";
    
    /** set 건강보험 : item05 */
    public static final String ATTR_ITEM05 = "item05";
    
    /** set 국민연금 : item06 */
    public static final String ATTR_ITEM06 = "item06";
    
    /** set 고용보험 : item07 */
    public static final String ATTR_ITEM07 = "item07";
    
    /** set 환급소득세 : item08 */
    public static final String ATTR_ITEM08 = "item08";
    
    /** set 환급주민세 : item09 */
    public static final String ATTR_ITEM09 = "item09";
    
    /** set 환급계 : item010 */
    public static final String ATTR_ITEM10 = "item10";
    
    /** set 환급소득세(재) : item11 */
    public static final String ATTR_ITEM11 = "item11";
    
    /** set 환급주민세(재) : item12 */
    public static final String ATTR_ITEM12 = "item12";
    
    /** set 재정산환급계 : item13 */
    public static final String ATTR_ITEM13 = "item13";
    
    /** set 환급차액 : item14 */
    public static final String ATTR_ITEM14 = "item14";
    
    
    /** set 결정세액(소득세)  : item15 */
    public static final String ATTR_ITEM15 = "item15";
    
    /** set 결정세액(주민세) : item16 */
    public static final String ATTR_ITEM16 = "item16";
    

    /** 생성자 */
     public Ye17Ta1000BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye17Ta1000BM(
    		 String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, Long  edacSeilNum 
    		, String  payrMangDeptCd 
    		, String  deptCd 
    		, String  typOccuCd 
    		, String  dtilOccuClsDivCd 
    		, String  pyspGrdeCd 
    		, String  dtilOccuInttnCd 
    		, String  businCd 
    		, String  emymtDivCd 
    		, String  pernChrgEmpIdenNum 
    		, String  closFlag 
    		, Long  closCont 
    		, String  closDate 
    		, String  edacPrdt 
    		, String  reprName 
    		, String  juriName 
    		, String  busiNumb 
    		, String  resuNumb 
    		, String  juriNumb 
    		, String  incmPost 
    		, String  incmAddr 
    		, String  incmAdtl 
    		, String  taxaCode 
    		, String  incmGbcd 
    		, String  taxaDnum 
    		, String  homeTxid 
    		, String  taxaPrcd 
    		, String  charDept 
    		, String  charName 
    		, String  charTele 
    		, String  filePass 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_EDACSEILNUM,edacSeilNum);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_PERNCHRGEMPIDENNUM,pernChrgEmpIdenNum);
     	values.put(ATTR_CLOSFLAG,closFlag);
     	values.put(ATTR_CLOSCONT,closCont);
     	values.put(ATTR_CLOSDATE,closDate);
     	values.put(ATTR_EDACPRDT,edacPrdt);
     	values.put(ATTR_REPRNAME,reprName);
     	values.put(ATTR_JURINAME,juriName);
     	values.put(ATTR_BUSINUMB,busiNumb);
     	values.put(ATTR_RESUNUMB,resuNumb);
     	values.put(ATTR_JURINUMB,juriNumb);
     	values.put(ATTR_INCMPOST,incmPost);
     	values.put(ATTR_INCMADDR,incmAddr);
     	values.put(ATTR_INCMADTL,incmAdtl);
     	values.put(ATTR_TAXACODE,taxaCode);
     	values.put(ATTR_INCMGBCD,incmGbcd);
     	values.put(ATTR_TAXADNUM,taxaDnum);
     	values.put(ATTR_HOMETXID,homeTxid);
     	values.put(ATTR_TAXAPRCD,taxaPrcd);
     	values.put(ATTR_CHARDEPT,charDept);
     	values.put(ATTR_CHARNAME,charName);
     	values.put(ATTR_CHARTELE,charTele);
     	values.put(ATTR_FILEPASS,filePass);
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
     
     /** set 시스템키 : systemkey */
     public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
     /** get 사업장코드 : systemkey */
     public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 연말정산귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 연말정산귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}  

    /** set 연말정산마감일련번호 : edacSeilNum */
    public void setEdacSeilNum(String  edacSeilNum) { set( ATTR_EDACSEILNUM ,edacSeilNum);}
    /** get 연말정산마감일련번호 : edacSeilNum */
    public String  getEdacSeilNum() { return (String )get( ATTR_EDACSEILNUM );}

    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    
    /** set 원천징수의무부서코드 : yetaDpcd */
    public void setYetaDpcd(String  yetaDpcd) { set( ATTR_YETADPCD ,yetaDpcd);}
    /** get 원천징수의무부서코드 : yetaDpcd */
    public String  getYetaDpcd() { return (String )get( ATTR_YETADPCD );}
    
    /** set A9_사업자등록번호 : busoprRgstnum */
    public void setBusoprRgstnum(String  busoprRgstnum) { set( ATTR_BUSOPRRGSTNUM ,busoprRgstnum);}
    /** get A9_사업자등록번호 : busoprRgstnum */
    public String  getBusoprRgstnum() { return (String )get( ATTR_BUSOPRRGSTNUM );}


    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 생성직원번호 : pernChrgEmpIdenNum */
    public void setPernChrgEmpIdenNum(String  pernChrgEmpIdenNum) { set( ATTR_PERNCHRGEMPIDENNUM ,pernChrgEmpIdenNum);}
    /** get 생성직원번호 : pernChrgEmpIdenNum */
    public String  getPernChrgEmpIdenNum() { return (String )get( ATTR_PERNCHRGEMPIDENNUM );}

    /** set 마감여부 : closFlag */
    public void setClosFlag(String  closFlag) { set( ATTR_CLOSFLAG ,closFlag);}
    /** get 마감여부 : closFlag */
    public String  getClosFlag() { return (String )get( ATTR_CLOSFLAG );}

    /** set 마감건수 : closCont */
    public void setClosCont(Long  closCont) { set( ATTR_CLOSCONT ,closCont);}
    /** get 마감건수 : closCont */
    public Long  getClosCont() { return (Long )get( ATTR_CLOSCONT );}

    /** set 마감일자 : closDate */
    public void setClosDate(String  closDate) { set( ATTR_CLOSDATE ,closDate);}
    /** get 마감일자 : closDate */
    public String  getClosDate() { return (String )get( ATTR_CLOSDATE );}

    /** set 연말정산제출일자 : edacPrdt */
    public void setEdacPrdt(String  edacPrdt) { set( ATTR_EDACPRDT ,edacPrdt);}
    /** get 연말정산제출일자 : edacPrdt */
    public String  getEdacPrdt() { return (String )get( ATTR_EDACPRDT );}

    /** set 대표자성명 : reprName */
    public void setReprName(String  reprName) { set( ATTR_REPRNAME ,reprName);}
    /** get 대표자성명 : reprName */
    public String  getReprName() { return (String )get( ATTR_REPRNAME );}

    /** set 법인명_상호 : juriName */
    public void setJuriName(String  juriName) { set( ATTR_JURINAME ,juriName);}
    /** get 법인명_상호 : juriName */
    public String  getJuriName() { return (String )get( ATTR_JURINAME );}

    /** set 사업자등록번호 : busiNumb */
    public void setBusiNumb(String  busiNumb) { set( ATTR_BUSINUMB ,busiNumb);}
    /** get 사업자등록번호 : busiNumb */
    public String  getBusiNumb() { return (String )get( ATTR_BUSINUMB );}

    /** set 주민등록번호 : resuNumb */
    public void setResuNumb(String  resuNumb) { set( ATTR_RESUNUMB ,resuNumb);}
    /** get 주민등록번호 : resuNumb */
    public String  getResuNumb() { return (String )get( ATTR_RESUNUMB );}

    /** set 법인번호 : juriNumb */
    public void setJuriNumb(String  juriNumb) { set( ATTR_JURINUMB ,juriNumb);}
    /** get 법인번호 : juriNumb */
    public String  getJuriNumb() { return (String )get( ATTR_JURINUMB );}

    /** set 소득신고의무자우편번호 : incmPost */
    public void setIncmPost(String  incmPost) { set( ATTR_INCMPOST ,incmPost);}
    /** get 소득신고의무자우편번호 : incmPost */
    public String  getIncmPost() { return (String )get( ATTR_INCMPOST );}

    /** set 소득신고의무자기본주소 : incmAddr */
    public void setIncmAddr(String  incmAddr) { set( ATTR_INCMADDR ,incmAddr);}
    /** get 소득신고의무자기본주소 : incmAddr */
    public String  getIncmAddr() { return (String )get( ATTR_INCMADDR );}

    /** set 소득신고의무자상세주소 : incmAdtl */
    public void setIncmAdtl(String  incmAdtl) { set( ATTR_INCMADTL ,incmAdtl);}
    /** get 소득신고의무자상세주소 : incmAdtl */
    public String  getIncmAdtl() { return (String )get( ATTR_INCMADTL );}

    /** set 관할세무서코드 : taxaCode */
    public void setTaxaCode(String  taxaCode) { set( ATTR_TAXACODE ,taxaCode);}
    /** get 관할세무서코드 : taxaCode */
    public String  getTaxaCode() { return (String )get( ATTR_TAXACODE );}

    /** set 제출자구분코드 : incmGbcd */
    public void setIncmGbcd(String  incmGbcd) { set( ATTR_INCMGBCD ,incmGbcd);}
    /** get 제출자구분코드 : incmGbcd */
    public String  getIncmGbcd() { return (String )get( ATTR_INCMGBCD );}

    /** set 세무대리인번호 : taxaDnum */
    public void setTaxaDnum(String  taxaDnum) { set( ATTR_TAXADNUM ,taxaDnum);}
    /** get 세무대리인번호 : taxaDnum */
    public String  getTaxaDnum() { return (String )get( ATTR_TAXADNUM );}

    /** set 홈텍스ID : homeTxid */
    public void setHomeTxid(String  homeTxid) { set( ATTR_HOMETXID ,homeTxid);}
    /** get 홈텍스ID : homeTxid */
    public String  getHomeTxid() { return (String )get( ATTR_HOMETXID );}

    /** set 세무프로그램코드 : taxaPrcd */
    public void setTaxaPrcd(String  taxaPrcd) { set( ATTR_TAXAPRCD ,taxaPrcd);}
    /** get 세무프로그램코드 : taxaPrcd */
    public String  getTaxaPrcd() { return (String )get( ATTR_TAXAPRCD );}

    /** set 담당자부서명 : charDept */
    public void setCharDept(String  charDept) { set( ATTR_CHARDEPT ,charDept);}
    /** get 담당자부서명 : charDept */
    public String  getCharDept() { return (String )get( ATTR_CHARDEPT );}

    /** set 담당자성명 : charName */
    public void setCharName(String  charName) { set( ATTR_CHARNAME ,charName);}
    /** get 담당자성명 : charName */
    public String  getCharName() { return (String )get( ATTR_CHARNAME );}

    /** set 담당자전화번호 : charTele */
    public void setCharTele(String  charTele) { set( ATTR_CHARTELE ,charTele);}
    /** get 담당자전화번호 : charTele */
    public String  getCharTele() { return (String )get( ATTR_CHARTELE );}

    /** set FILE_PASS : filePass */
    public void setFilePass(String  filePass) { set( ATTR_FILEPASS ,filePass);}
    /** get FILE_PASS : filePass */
    public String  getFilePass() { return (String )get( ATTR_FILEPASS );}

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
    
    
	/** set 부서명 : deptNm */
  	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
  	/** get 부서명 : deptNm */
  	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
    
    /** set 사업명 : businNm */
	public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** set 사업명 : businNm */
	public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
	
    /** set 직종명 : typOccuNm */
	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** set 직종명 : typOccuNm */
	public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
	
    /** set 직종세통합코드명 : dtilOccuInttnNm */
	public void setDtilOccuInttnNm(String  dtilOccuInttnNm) { set( ATTR_DTILOCCUINTTNNM ,dtilOccuInttnNm);}
	/** set 직종세통합코드명 : dtilOccuClsDivNm */
	public String  getDtilOccuInttnNm() { return (String )get( ATTR_DTILOCCUINTTNNM );}
	
    /** set 고용구분명 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
    /** get 고용구분명 : emymtDivNm */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}
    
    
    /** set 총급여액 : item01 */
    public void setItem01(Long  item01) { set( ATTR_ITEM01 ,item01);}
    /** get 총급여액 : item01 */
    public Long  getItem01() { return (Long )get( ATTR_ITEM01 );}
    
    /** set 비과세 : item02 */
    public void setItem02(Long  item02) { set( ATTR_ITEM02 ,item02);}
    /** get 비과세 : item02 */
    public Long  getItem02() { return (Long )get( ATTR_ITEM02 );}
    
    /** set 소득세 : item03 */
    public void setItem03(Long  item03) { set( ATTR_ITEM03 ,item03);}
    /** get 소득세 : item03 */
    public Long  getItem03() { return (Long )get( ATTR_ITEM03 );}
    
    /** set 주민세 : item04 */
    public void setItem04(Long  item04) { set( ATTR_ITEM04 ,item04);}
    /** get 주민세 : item04 */
    public Long  getItem04() { return (Long )get( ATTR_ITEM04 );}
    
    /** set 건강보험 : item05 */
    public void setItem05(Long  item05) { set( ATTR_ITEM05 ,item05);}
    /** get 건강보험 : item05 */
    public Long  getItem05() { return (Long )get( ATTR_ITEM05 );}
    
    /** set 국민연금 : item06 */
    public void setItem06(Long  item06) { set( ATTR_ITEM06 ,item06);}
    /** get 국민연금 : item06 */
    public Long  getItem06() { return (Long )get( ATTR_ITEM06 );}
    
    /** set 고용보험 : item07 */
    public void setItem07(Long  item07) { set( ATTR_ITEM07 ,item07);}
    /** get 고용보험 : item07 */
    public Long  getItem07() { return (Long )get( ATTR_ITEM07 );}
    
    /** set 환급소득세 : item08 */
    public void setItem08(Long  item08) { set( ATTR_ITEM08,item08);}
    /** get 환급소득세 : item08 */
    public Long  getItem08() { return (Long )get( ATTR_ITEM08 );}
    
    /** set 환급주민세 : item09 */
    public void setItem09(Long  item09) { set( ATTR_ITEM09 ,item09);}
    /** get 환급주민세 : item09 */
    public Long  getItem09() { return (Long )get( ATTR_ITEM09 );}
    
    /** set 환급계 : item10 */
    public void setItem10(Long  item10) { set( ATTR_ITEM10 ,item10);}
    /** get 환급계 : item10 */
    public Long  getItem10() { return (Long )get( ATTR_ITEM10 );}
    
    /** set 환급소득세(재) : item11 */
    public void setItem11(Long  item11) { set( ATTR_ITEM11 ,item11);}
    /** get 환급소득세(재) : item11 */
    public Long  getItem11() { return (Long )get( ATTR_ITEM11 );}
    
    /** set 환급주민세(재) : item12 */
    public void setItem12(Long  item12) { set( ATTR_ITEM12 ,item12);}
    /** get 환급주민세(재) : item12 */
    public Long  getitem12() { return (Long )get( ATTR_ITEM12 );}
    
    /** set 재정산환급계 : item13 */
    public void setItem13(Long  item13) { set( ATTR_ITEM13 ,item13);}
    /** get 재정산환급계 : item13 */
    public Long  GETITEM13() { return (Long )get( ATTR_ITEM13 );}
    
    /** set 환급차액 : item14 */
    public void setItem14(Long  item14) { set( ATTR_ITEM14 ,item14);}
    /** get 환급차액 : item14 */
    public Long  getItem14() { return (Long )get( ATTR_ITEM14 );}
    
    /** set 결정세액(소득세)  : item15 */
    public void setItem15(Long  item15) { set( ATTR_ITEM15 ,item15);}
    /** set 결정세액(소득세)  : item15 */
    public Long  getItem15() { return (Long )get( ATTR_ITEM15 );}
    
    /** set 결정세액(소득세)  : item16 */
    public void setItem16(Long  item16) { set( ATTR_ITEM16 ,item16);}
    /** set 결정세액(소득세)  : item16 */
    public Long  getItem16() { return (Long )get( ATTR_ITEM16 );}
    
    /** set 한글성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 한글성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}

    /** set 주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
    /** get 주민등록번호 : resnRegnNum */
    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
    

    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
    
    
 
    
}
