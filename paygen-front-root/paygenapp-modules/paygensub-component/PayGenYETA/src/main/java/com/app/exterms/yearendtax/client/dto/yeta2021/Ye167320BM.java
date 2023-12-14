package com.app.exterms.yearendtax.client.dto.yeta2021;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye167320BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 의료비지급일련번호 : mdxpsSeilNum */
    public static final String ATTR_MDXPSSEILNUM = "mdxpsSeilNum";

    /** set 의료비공제대상자주민등록번호 : resnoEncCntn */
    public static final String ATTR_RESNOENCCNTN = "resnoEncCntn";

    /** set 본인등해당여부 : yn */
    public static final String ATTR_YN = "yn";

    /** set 지급처사업자등록번호 : bsnoEncCntn */
    public static final String ATTR_BSNOENCCNTN = "bsnoEncCntn";

    /** set 의료비_상호명 : plymNm */
    public static final String ATTR_PLYMNM = "plymNm";

    /** set 의료비_의료증빙코드 : mdxpsPrfClCd */
    public static final String ATTR_MDXPSPRFCLCD = "mdxpsPrfClCd";

    /** set 의료비_건수 : scnt */
    public static final String ATTR_SCNT = "scnt";

    /** set 의료비_금액 : useAmt */
    public static final String ATTR_USEAMT = "useAmt";

    /** set 의료비_난임시술비해당여부 : yn2 */
    public static final String ATTR_YN2 = "yn2";
    
    /** set 의료비_산후조리비용여부 : yn3 */
    public static final String ATTR_YN3 = "yn3";

    /** set 의료비_실손보험금보전금액여부 : yn4 */
    public static final String ATTR_YN4 = "yn4";

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

    /** 생성자 */
     public Ye167320BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167320BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, Long  mdxpsSeilNum 
    		, String  resnoEncCntn 
    		, String  yn 
    		, String  bsnoEncCntn 
    		, String  plymNm 
    		, String  mdxpsPrfClCd 
    		, String  scnt 
    		, String  useAmt 
    		, String  yn2 
    		, String  yn3
    		, String  yn4
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_MDXPSSEILNUM,mdxpsSeilNum);
     	values.put(ATTR_RESNOENCCNTN,resnoEncCntn);
     	values.put(ATTR_YN,yn);
     	values.put(ATTR_BSNOENCCNTN,bsnoEncCntn);
     	values.put(ATTR_PLYMNM,plymNm);
     	values.put(ATTR_MDXPSPRFCLCD,mdxpsPrfClCd);
     	values.put(ATTR_SCNT,scnt);
     	values.put(ATTR_USEAMT,useAmt);
     	values.put(ATTR_YN2,yn2);
     	values.put(ATTR_YN3,yn3);
     	values.put(ATTR_YN4,yn4);
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

    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 의료비지급일련번호 : mdxpsSeilNum */
    public void setMdxpsSeilNum(Long  mdxpsSeilNum) { set( ATTR_MDXPSSEILNUM ,mdxpsSeilNum);}
    /** get 의료비지급일련번호 : mdxpsSeilNum */
    public Long  getMdxpsSeilNum() { return (Long )get( ATTR_MDXPSSEILNUM );}

    /** set 의료비공제대상자주민등록번호 : resnoEncCntn */
    public void setResnoEncCntn(String  resnoEncCntn) { set( ATTR_RESNOENCCNTN ,resnoEncCntn);}
    /** get 의료비공제대상자주민등록번호 : resnoEncCntn */
    public String  getResnoEncCntn() { return (String )get( ATTR_RESNOENCCNTN );}

    /** set 본인등해당여부 : yn */
    public void setYn(String  yn) { set( ATTR_YN ,yn);}
    /** get 본인등해당여부 : yn */
    public String  getYn() { return (String )get( ATTR_YN );}

    /** set 지급처사업자등록번호 : bsnoEncCntn */
    public void setBsnoEncCntn(String  bsnoEncCntn) { set( ATTR_BSNOENCCNTN ,bsnoEncCntn);}
    /** get 지급처사업자등록번호 : bsnoEncCntn */
    public String  getBsnoEncCntn() { return (String )get( ATTR_BSNOENCCNTN );}

    /** set 의료비_상호명 : plymNm */
    public void setPlymNm(String  plymNm) { set( ATTR_PLYMNM ,plymNm);}
    /** get 의료비_상호명 : plymNm */
    public String  getPlymNm() { return (String )get( ATTR_PLYMNM );}

    /** set 의료비_의료증빙코드 : mdxpsPrfClCd */
    public void setMdxpsPrfClCd(String  mdxpsPrfClCd) { set( ATTR_MDXPSPRFCLCD ,mdxpsPrfClCd);}
    /** get 의료비_의료증빙코드 : mdxpsPrfClCd */
    public String  getMdxpsPrfClCd() { return (String )get( ATTR_MDXPSPRFCLCD );}

    /** set 의료비_건수 : scnt */
    public void setScnt(String  scnt) { set( ATTR_SCNT ,scnt);}
    /** get 의료비_건수 : scnt */
    public String  getScnt() { return (String )get( ATTR_SCNT );}

    /** set 의료비_금액 : useAmt */
    public void setUseAmt(String  useAmt) { set( ATTR_USEAMT ,useAmt);}
    /** get 의료비_금액 : useAmt */
    public String  getUseAmt() { return (String )get( ATTR_USEAMT );}

    /** set 의료비_난임시술비해당여부 : yn2 */
    public void setYn2(String  yn2) { set( ATTR_YN2 ,yn2);}
    /** get 의료비_난임시술비해당여부 : yn2 */
    public String  getYn2() { return (String )get( ATTR_YN2 );}
    
    /** set 의료비_산후조리여부 : yn3 */
    public void setYn3(String  yn3) { set( ATTR_YN3 ,yn3);}
    /** get 의료비_산후조리여부 : yn3 */
    public String  getYn3() { return (String )get( ATTR_YN3 );}
    /** set 의료비_실손보험보전금액여부 : yn4 */
    public void setYn4(String  yn4) { set( ATTR_YN4 ,yn4);}
    /** get 의료비_실손보험보전금액여부 : yn4 */
    public String  getYn4() { return (String )get( ATTR_YN4 );}

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

}
