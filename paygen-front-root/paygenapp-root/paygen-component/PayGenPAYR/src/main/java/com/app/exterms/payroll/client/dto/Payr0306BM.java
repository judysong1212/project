package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0306VO.java
 * @Description : Payr0306 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0306BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set 지급년월 : pymtYrMnth */
    public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";


    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    
    /** set 급여구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";

    /** set 급여일련번호 : payrSeilNum */
    public static final String ATTR_PAYRSEILNUM = "payrSeilNum";


    
    /** set 급여가족사항일련번호 : payFamyRsptSeilNum */
    public static final String ATTR_PAYFAMYRSPTSEILNUM = "payFamyRsptSeilNum";

    /** set 급여가족주민번호 : payFamyResnRegnNum */
    public static final String ATTR_PAYFAMYRESNREGNNUM = "payFamyResnRegnNum";

	/** set 가족주민등록번호 : famySecRegnNum */
	public static final String ATTR_FAMYSECREGNNUM = "famySecRegnNum";



    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 가족관계구분코드 : famyRelaDivCd */
    public static final String ATTR_FAMYRELADIVCD = "famyRelaDivCd";

    /** set 가족수당지급여부 : famyAllwPymtYn */
    public static final String ATTR_FAMYALLWPYMTYN = "famyAllwPymtYn";

    /** set 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
    public static final String ATTR_CHDNCHDRRGEPNSPYMTYN = "chdnChdRrgEpnsPymtYn";

    /** set 기본공제여부 : fndtnDducYn */
    public static final String ATTR_FNDTNDDUCYN = "fndtnDducYn";

    /** set 배우자공제여부 : spueDducYn */
    public static final String ATTR_SPUEDDUCYN = "spueDducYn";

    /** set 부녀자공제여부 : wmnDducYn */
    public static final String ATTR_WMNDDUCYN = "wmnDducYn";

    /** set 경로우대공제여부 : rftaGvstDducYn */
    public static final String ATTR_RFTAGVSTDDUCYN = "rftaGvstDducYn";

    /** set 장애자공제여부 : dabpnDducYn */
    public static final String ATTR_DABPNDDUCYN = "dabpnDducYn";

    /** set 한가족공제여부 : sgpnFmlyDducYn */
    public static final String ATTR_SGPNFMLYDDUCYN = "sgpnFmlyDducYn";

    /** set 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
    public static final String ATTR_CHDNCHDRRGEPNSDDUCYN = "chdnChdRrgEpnsDducYn";

    /** set 가족수당구분코드 : famyExtpyDivCd */
    public static final String ATTR_FAMYEXTPYDIVCD = "famyExtpyDivCd";

    /** set 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
    public static final String ATTR_SCHLEXPNADMCLEXTPYDIVCD = "schlExpnAdmclExtpyDivCd";

    /** set 학비보조수당금액 : schlExpnAdmclExtpySum */
    public static final String ATTR_SCHLEXPNADMCLEXTPYSUM = "schlExpnAdmclExtpySum";

    /** set 가족수당금액 : famyExtpySum */
    public static final String ATTR_FAMYEXTPYSUM = "famyExtpySum";

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
     public Payr0306BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0306BM( String  dpobCd 
             ,  String  pymtYrMnth 
    		, String  systemkey 
    		, BigDecimal  payFamyRsptSeilNum 
    		, String  payFamyResnRegnNum 
    		, String  hanNm 
    		, String  famyRelaDivCd 
    		, String  famyAllwPymtYn 
    		, String  chdnChdRrgEpnsPymtYn 
    		, String  fndtnDducYn 
    		, String  spueDducYn 
    		, String  wmnDducYn 
    		, String  rftaGvstDducYn 
    		, String  dabpnDducYn 
    		, String  sgpnFmlyDducYn 
    		, String  chdnChdRrgEpnsDducYn 
    		, String  famyExtpyDivCd 
    		, String  schlExpnAdmclExtpyDivCd 
    		, BigDecimal  schlExpnAdmclExtpySum 
    		, BigDecimal  famyExtpySum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
         values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PAYFAMYRSPTSEILNUM,payFamyRsptSeilNum);
     	values.put(ATTR_PAYFAMYRESNREGNNUM,payFamyResnRegnNum);
     	values.put(ATTR_HANNM,hanNm);
     	values.put(ATTR_FAMYRELADIVCD,famyRelaDivCd);
     	values.put(ATTR_FAMYALLWPYMTYN,famyAllwPymtYn);
     	values.put(ATTR_CHDNCHDRRGEPNSPYMTYN,chdnChdRrgEpnsPymtYn);
     	values.put(ATTR_FNDTNDDUCYN,fndtnDducYn);
     	values.put(ATTR_SPUEDDUCYN,spueDducYn);
     	values.put(ATTR_WMNDDUCYN,wmnDducYn);
     	values.put(ATTR_RFTAGVSTDDUCYN,rftaGvstDducYn);
     	values.put(ATTR_DABPNDDUCYN,dabpnDducYn);
     	values.put(ATTR_SGPNFMLYDDUCYN,sgpnFmlyDducYn);
     	values.put(ATTR_CHDNCHDRRGEPNSDDUCYN,chdnChdRrgEpnsDducYn);
     	values.put(ATTR_FAMYEXTPYDIVCD,famyExtpyDivCd);
     	values.put(ATTR_SCHLEXPNADMCLEXTPYDIVCD,schlExpnAdmclExtpyDivCd);
     	values.put(ATTR_SCHLEXPNADMCLEXTPYSUM,schlExpnAdmclExtpySum);
     	values.put(ATTR_FAMYEXTPYSUM,famyExtpySum);
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

     
    /** set 지급년월 : pymtYrMnth */
    public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
    /** get 지급년월 : pymtYrMnth */
    public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    


    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}
    

    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}

    /** set 급여일련번호 : payrSeilNum */
    public void setPayrSeilNum(BigDecimal  payrSeilNum) { set( ATTR_PAYRSEILNUM ,payrSeilNum);}
    /** get 급여일련번호 : payrSeilNum */
    public BigDecimal  getPayrSeilNum() { return (BigDecimal )get( ATTR_PAYRSEILNUM );}
    
    /** set 급여가족사항일련번호 : payFamyRsptSeilNum */
    public void setPayFamyRsptSeilNum(BigDecimal  payFamyRsptSeilNum) { set( ATTR_PAYFAMYRSPTSEILNUM ,payFamyRsptSeilNum);}
    /** get 급여가족사항일련번호 : payFamyRsptSeilNum */
    public BigDecimal  getPayFamyRsptSeilNum() { return (BigDecimal )get( ATTR_PAYFAMYRSPTSEILNUM );}

    /** set 급여가족주민번호 : payFamyResnRegnNum */
    public void setPayFamyResnRegnNum(String  payFamyResnRegnNum) { set( ATTR_PAYFAMYRESNREGNNUM ,payFamyResnRegnNum);}
    /** get 급여가족주민번호 : payFamyResnRegnNum */
    public String  getPayFamyResnRegnNum() { return (String )get( ATTR_PAYFAMYRESNREGNNUM );}

    /** set 한글성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 한글성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}

    /** set 가족관계구분코드 : famyRelaDivCd */
    public void setFamyRelaDivCd(String  famyRelaDivCd) { set( ATTR_FAMYRELADIVCD ,famyRelaDivCd);}
    /** get 가족관계구분코드 : famyRelaDivCd */
    public String  getFamyRelaDivCd() { return (String )get( ATTR_FAMYRELADIVCD );}

    /** set 가족수당지급여부 : famyAllwPymtYn */
    public void setFamyAllwPymtYn(String  famyAllwPymtYn) { set( ATTR_FAMYALLWPYMTYN ,famyAllwPymtYn);}
    /** get 가족수당지급여부 : famyAllwPymtYn */
    public String  getFamyAllwPymtYn() { return (String )get( ATTR_FAMYALLWPYMTYN );}

    /** set 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
    public void setChdnChdRrgEpnsPymtYn(String  chdnChdRrgEpnsPymtYn) { set( ATTR_CHDNCHDRRGEPNSPYMTYN ,chdnChdRrgEpnsPymtYn);}
    /** get 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
    public String  getChdnChdRrgEpnsPymtYn() { return (String )get( ATTR_CHDNCHDRRGEPNSPYMTYN );}

    /** set 기본공제여부 : fndtnDducYn */
    public void setFndtnDducYn(String  fndtnDducYn) { set( ATTR_FNDTNDDUCYN ,fndtnDducYn);}
    /** get 기본공제여부 : fndtnDducYn */
    public String  getFndtnDducYn() { return (String )get( ATTR_FNDTNDDUCYN );}

    /** set 배우자공제여부 : spueDducYn */
    public void setSpueDducYn(String  spueDducYn) { set( ATTR_SPUEDDUCYN ,spueDducYn);}
    /** get 배우자공제여부 : spueDducYn */
    public String  getSpueDducYn() { return (String )get( ATTR_SPUEDDUCYN );}

    /** set 부녀자공제여부 : wmnDducYn */
    public void setWmnDducYn(String  wmnDducYn) { set( ATTR_WMNDDUCYN ,wmnDducYn);}
    /** get 부녀자공제여부 : wmnDducYn */
    public String  getWmnDducYn() { return (String )get( ATTR_WMNDDUCYN );}

    /** set 경로우대공제여부 : rftaGvstDducYn */
    public void setRftaGvstDducYn(String  rftaGvstDducYn) { set( ATTR_RFTAGVSTDDUCYN ,rftaGvstDducYn);}
    /** get 경로우대공제여부 : rftaGvstDducYn */
    public String  getRftaGvstDducYn() { return (String )get( ATTR_RFTAGVSTDDUCYN );}

    /** set 장애자공제여부 : dabpnDducYn */
    public void setDabpnDducYn(String  dabpnDducYn) { set( ATTR_DABPNDDUCYN ,dabpnDducYn);}
    /** get 장애자공제여부 : dabpnDducYn */
    public String  getDabpnDducYn() { return (String )get( ATTR_DABPNDDUCYN );}

    /** set 한가족공제여부 : sgpnFmlyDducYn */
    public void setSgpnFmlyDducYn(String  sgpnFmlyDducYn) { set( ATTR_SGPNFMLYDDUCYN ,sgpnFmlyDducYn);}
    /** get 한가족공제여부 : sgpnFmlyDducYn */
    public String  getSgpnFmlyDducYn() { return (String )get( ATTR_SGPNFMLYDDUCYN );}

    /** set 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
    public void setChdnChdRrgEpnsDducYn(String  chdnChdRrgEpnsDducYn) { set( ATTR_CHDNCHDRRGEPNSDDUCYN ,chdnChdRrgEpnsDducYn);}
    /** get 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
    public String  getChdnChdRrgEpnsDducYn() { return (String )get( ATTR_CHDNCHDRRGEPNSDDUCYN );}

    /** set 가족수당구분코드 : famyExtpyDivCd */
    public void setFamyExtpyDivCd(String  famyExtpyDivCd) { set( ATTR_FAMYEXTPYDIVCD ,famyExtpyDivCd);}
    /** get 가족수당구분코드 : famyExtpyDivCd */
    public String  getFamyExtpyDivCd() { return (String )get( ATTR_FAMYEXTPYDIVCD );}

    /** set 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
    public void setSchlExpnAdmclExtpyDivCd(String  schlExpnAdmclExtpyDivCd) { set( ATTR_SCHLEXPNADMCLEXTPYDIVCD ,schlExpnAdmclExtpyDivCd);}
    /** get 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
    public String  getSchlExpnAdmclExtpyDivCd() { return (String )get( ATTR_SCHLEXPNADMCLEXTPYDIVCD );}

    /** set 학비보조수당금액 : schlExpnAdmclExtpySum */
    public void setSchlExpnAdmclExtpySum(BigDecimal  schlExpnAdmclExtpySum) { set( ATTR_SCHLEXPNADMCLEXTPYSUM ,schlExpnAdmclExtpySum);}
    /** get 학비보조수당금액 : schlExpnAdmclExtpySum */
    public BigDecimal  getSchlExpnAdmclExtpySum() { return (BigDecimal )get( ATTR_SCHLEXPNADMCLEXTPYSUM );}

    /** set 가족수당금액 : famyExtpySum */
    public void setFamyExtpySum(BigDecimal  famyExtpySum) { set( ATTR_FAMYEXTPYSUM ,famyExtpySum);}
    /** get 가족수당금액 : famyExtpySum */
    public BigDecimal  getFamyExtpySum() { return (BigDecimal )get( ATTR_FAMYEXTPYSUM );}

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


	/** set 가족주민등록번호 : famySecRegnNum */
	public void setFamySecRegnNum(String  famySecRegnNum) { set( ATTR_FAMYSECREGNNUM ,famySecRegnNum);}
	/** get 가족주민등록번호 : famySecRegnNum */
	public String  getFamySecRegnNum() { return (String )get( ATTR_FAMYSECREGNNUM );}
 
    
}
