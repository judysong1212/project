package com.app.exterms.yearendtax.client.dto.yeta2019;



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
public class Ye167310BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 성명 : fnm */
    public static final String ATTR_FNM = "fnm";

    /** set 주민등록번호 : resno */
    public static final String ATTR_RESNO = "resno";

    /** set 상호명 : tnm */
    public static final String ATTR_TNM = "tnm";

    /** set 사업자등록번호 : bsnoEncCntn */
    public static final String ATTR_BSNOENCCNTN = "bsnoEncCntn";

    /** set 의료비_귀속연도 : attrYr */
    public static final String ATTR_ATTRYR = "attrYr";

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
     public Ye167310BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167310BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  formCd 
    		, String  fnm 
    		, String  resno 
    		, String  tnm 
    		, String  bsnoEncCntn 
    		, String  attrYr 
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
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_FNM,fnm);
     	values.put(ATTR_RESNO,resno);
     	values.put(ATTR_TNM,tnm);
     	values.put(ATTR_BSNOENCCNTN,bsnoEncCntn);
     	values.put(ATTR_ATTRYR,attrYr);
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

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 성명 : fnm */
    public void setFnm(String  fnm) { set( ATTR_FNM ,fnm);}
    /** get 성명 : fnm */
    public String  getFnm() { return (String )get( ATTR_FNM );}

    /** set 주민등록번호 : resno */
    public void setResno(String  resno) { set( ATTR_RESNO ,resno);}
    /** get 주민등록번호 : resno */
    public String  getResno() { return (String )get( ATTR_RESNO );}

    /** set 상호명 : tnm */
    public void setTnm(String  tnm) { set( ATTR_TNM ,tnm);}
    /** get 상호명 : tnm */
    public String  getTnm() { return (String )get( ATTR_TNM );}

    /** set 사업자등록번호 : bsnoEncCntn */
    public void setBsnoEncCntn(String  bsnoEncCntn) { set( ATTR_BSNOENCCNTN ,bsnoEncCntn);}
    /** get 사업자등록번호 : bsnoEncCntn */
    public String  getBsnoEncCntn() { return (String )get( ATTR_BSNOENCCNTN );}

    /** set 의료비_귀속연도 : attrYr */
    public void setAttrYr(String  attrYr) { set( ATTR_ATTRYR ,attrYr);}
    /** get 의료비_귀속연도 : attrYr */
    public String  getAttrYr() { return (String )get( ATTR_ATTRYR );}

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
