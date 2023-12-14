package com.app.exterms.yearendtax.client.dto.yeta2019;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 *
 * @Class Name : Ye161010BM.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161010BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";
    
    /** set 연말정산구분코드 : clutSeptNm */
    public static final String ATTR_CLUTSEPTNM = "clutSeptNm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 당시_고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
    
    /** set 당시_고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 당시_부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";
    
    /** set 당시_부서코드 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 당시_직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    public static final String ATTR_TYPNM = "typNm";
    
    /** set 당시_직종코드 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 당시_직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
    
    /** set 당시_직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNM = "dtilOccuInttnNm";

    /** set 당시_사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 당시_사업코드 : businCd */
    public static final String ATTR_BUSINNM = "businNm";

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

    /** set 단위사업장코드 : utDpobCd */
    public static final String ATTR_UTDPOBCD = "utDpobCd";
    

    /** set 단위사업장코드 : utDpobCd */
    public static final String ATTR_UTDPOBNM = "utDpobNm";

    /** 생성자 */
     public Ye161010BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye161010BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  payrMangDeptCd 
    		, String  emymtDivCd 
    		, String  deptCd 
    		, String  typOccuCd 
    		, String  dtilOccuInttnCd 
    		, String  businCd 
    		, String  pernChrgEmpIdenNum 
    		, String  closFlag 
    		, Long  closCont 
    		, String  closDate 
    		, String  edacPrdt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  utDpobCd ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_PERNCHRGEMPIDENNUM,pernChrgEmpIdenNum);
     	values.put(ATTR_CLOSFLAG,closFlag);
     	values.put(ATTR_CLOSCONT,closCont);
     	values.put(ATTR_CLOSDATE,closDate);
     	values.put(ATTR_EDACPRDT,edacPrdt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_UTDPOBCD,utDpobCd); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}
    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}
    /** set 연말정산구분코드 : clutSeptNm */
    public void setClutSeptNm(String  clutSeptNm) { set( ATTR_CLUTSEPTNM ,clutSeptNm);}
    /** get 연말정산구분코드 : clutSeptNm */
    public String  getClutSeptNm() { return (String )get( ATTR_CLUTSEPTNM );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
    /** set 당시_고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 당시_고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
    
    /** set 당시_고용구분코드 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
    /** get 당시_고용구분코드 : emymtDivNm */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}
    
    /** set 당시_부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 당시_부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
    /** set 당시_부서코드 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 당시_부서코드 : deptNm */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
    /** set 당시_직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 당시_직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    
    /** set 당시_직종코드 : typNm */
    public void setTypNm(String  typNm) { set( ATTR_TYPNM ,typNm);}
    /** get 당시_직종코드 : typNm */
    public String  getTypNm() { return (String )get( ATTR_TYPNM );}
    
    /** set 당시_직종코드 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 당시_직종코드 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
    /** set 당시_직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 당시_직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    /** set 당시_사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 당시_사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
    /** set 당시_사업코드 : businNm */
    public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** get 당시_사업코드 : businNm */
    public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
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
    /** set 단위사업장코드 : utDpobCd */
    public void setUtDpobCd(String  utDpobCd) { set( ATTR_UTDPOBCD ,utDpobCd);}
    /** get 단위사업장코드 : utDpobCd */
    public String  getUtDpobCd() { return (String )get( ATTR_UTDPOBCD );}
    
    /** set 단위사업장코드 : utDpobNm */
    public void setUtDpobNm(String  utDpobNm) { set( ATTR_UTDPOBNM ,utDpobNm);}
    /** get 단위사업장코드 : utDpobNm */
    public String  getUtDpobNm() { return (String )get( ATTR_UTDPOBNM );}
    
    
}
