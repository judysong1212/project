package com.app.exterms.yearendtax.client.dto.yeta2018;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author Kim ji eun
 * @since 2016.12.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class YetaT13003BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 연말정산귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 월세일련번호 : mnthRntQntySeilNum */
    public static final String ATTR_MNTHRNTQNTYSEILNUM = "mnthRntQntySeilNum";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";
    
    /** set 번호 : rNum */
    public static final String ATTR_RNUM = "rNum";
    
    /** set 항목명 : Item01 */
    public static final String ATTR_ITEM01 = "Item01";
    
    /** set 국세청자료 : Item02 */
    public static final String ATTR_ITEM02 = "Item02";
    
    /** set 그밖의자료 : Item03 */
    public static final String ATTR_ITEM03 = "Item03";

    /** set 월세_임대인성명 : mnthRnttyLehdrNm */
    public static final String ATTR_MNTHRNTTYLEHDRNM = "mnthRnttyLehdrNm";

    /** set 월세_주민번호 : mnthRnttyBurRgsum */
    public static final String ATTR_MNTHRNTTYBURRGSUM = "mnthRnttyBurRgsum";

    /** set 월세_주택유형코드 : mnthRnttyHusFrmCd */
    public static final String ATTR_MNTHRNTTYHUSFRMCD = "mnthRnttyHusFrmCd";
    
    /** set 월세_주택유형코드명 : mnthRnttyHusFrmNm */
    public static final String ATTR_MNTHRNTTYHUSFRMNM = "mnthRnttyHusFrmNm";

    /** set 월세주택계약면적 : mnthRnttyHusCnttArea */
    public static final String ATTR_MNTHRNTTYHUSCNTTAREA = "mnthRnttyHusCnttArea";

    /** set 월세_계약서상주소 : mnthRnttyRntlAddr */
    public static final String ATTR_MNTHRNTTYRNTLADDR = "mnthRnttyRntlAddr";

    /** set 월세_임대차계약시작일자 : mnthRnttyRntlBgnnDt */
    public static final String ATTR_MNTHRNTTYRNTLBGNNDT = "mnthRnttyRntlBgnnDt";

    /** set 월세_임대차계약종료일자 : mnthRnttyRntlEndDt */
    public static final String ATTR_MNTHRNTTYRNTLENDDT = "mnthRnttyRntlEndDt";

    /** set 월세_연간월세금액 : mnthRnttyYrlyMnthSum */
    public static final String ATTR_MNTHRNTTYYRLYMNTHSUM = "mnthRnttyYrlyMnthSum";

    /** set 월세_월세세액공제금액 : mnthRnttyTxDducSum */
    public static final String ATTR_MNTHRNTTYTXDDUCSUM = "mnthRnttyTxDducSum";

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
    
    /** set 전자파일이관여부 : ectnFlTrnrCtlYn */
    public static final String ATTR_ECTNFLTRNRCTLYN = "ectnFlTrnrCtlYn";

    /** 생성자 */
     public YetaT13003BM() { super(); } 

    /** 일괄등록 처리   */
     public YetaT13003BM(
    		 String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, BigDecimal  mnthRntQntySeilNum 
    		, String  dpobCd 
    		, String  systemkey
    		, String  rNum
    		, String  item01
    		, String  item02
    		, String  item03
    		, String  mnthRnttyLehdrNm 
    		, String  mnthRnttyBurRgsum 
    		, String  mnthRnttyHusFrmCd
    		, String  mnthRnttyHusFrmNm
    		, String  mnthRnttyHusCnttArea 
    		, String  mnthRnttyRntlAddr 
    		, String  mnthRnttyRntlBgnnDt 
    		, String  mnthRnttyRntlEndDt 
    		, BigDecimal  mnthRnttyYrlyMnthSum 
    		, BigDecimal  mnthRnttyTxDducSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr
    		, String  ectnFlTrnrCtlYn) { 
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_MNTHRNTQNTYSEILNUM,mnthRntQntySeilNum);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_RNUM,rNum);
     	values.put(ATTR_ITEM01,item01);
     	values.put(ATTR_ITEM02,item02);
     	values.put(ATTR_ITEM03,item03);
     	values.put(ATTR_MNTHRNTTYLEHDRNM,mnthRnttyLehdrNm);
     	values.put(ATTR_MNTHRNTTYBURRGSUM,mnthRnttyBurRgsum);
     	values.put(ATTR_MNTHRNTTYHUSFRMCD,mnthRnttyHusFrmCd);
     	values.put(ATTR_MNTHRNTTYHUSFRMNM,mnthRnttyHusFrmNm);
     	values.put(ATTR_MNTHRNTTYHUSCNTTAREA,mnthRnttyHusCnttArea);
     	values.put(ATTR_MNTHRNTTYRNTLADDR,mnthRnttyRntlAddr);
     	values.put(ATTR_MNTHRNTTYRNTLBGNNDT,mnthRnttyRntlBgnnDt);
     	values.put(ATTR_MNTHRNTTYRNTLENDDT,mnthRnttyRntlEndDt);
     	values.put(ATTR_MNTHRNTTYYRLYMNTHSUM,mnthRnttyYrlyMnthSum);
     	values.put(ATTR_MNTHRNTTYTXDDUCSUM,mnthRnttyTxDducSum);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_ECTNFLTRNRCTLYN,ectnFlTrnrCtlYn);} 

    /** set 연말정산귀속년도 : yrtxBlggYr */
    public void setEdacRvyy(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 연말정산귀속년도 : yrtxBlggYr */
    public String  getEdacRvyy() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 정산구분코드 : clutSeptCd */
    public void setSettGbcd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 정산구분코드 : clutSeptCd */
    public String  getSettGbcd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 월세일련번호 : mnthRntQntySeilNum */
    public void setMnrnSqno(BigDecimal  mnthRntQntySeilNum) { set( ATTR_MNTHRNTQNTYSEILNUM ,mnthRntQntySeilNum);}
    /** get 월세일련번호 : mnthRntQntySeilNum */
    public BigDecimal  getMnrnSqno() { return (BigDecimal )get( ATTR_MNTHRNTQNTYSEILNUM );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    
    /** set 번호 : rNum */
    public void setRNum(String  rNum) { set( ATTR_RNUM ,rNum);}
    /** get 번호 : rNum */
    public String  getRNum() { return (String )get( ATTR_RNUM );}
    
    /** set 항목명 : item01 */
    public void setItem01(String  item01) { set( ATTR_ITEM01 ,item01);}
    /** get 항목명 : item01 */
    public String  getItem01() { return (String )get( ATTR_ITEM01 );}
    
    /** set 국세청자료 : item02 */
    public void setItem02(String  item02) { set( ATTR_ITEM02 ,item02);}
    /** get 국세청자료 : item02 */
    public String  getItem02() { return (String )get( ATTR_ITEM02 );}
    
    /** set 그밖의자료 : item03 */
    public void setItem03(String  item03) { set( ATTR_ITEM03 ,item03);}
    /** get 그밖의자료 : item03 */
    public String  getItem03() { return (String )get( ATTR_ITEM03 );}
    
    /** set 월세_임대인성명 : mnthRnttyLehdrNm */
    public void setMnrnName(String  mnthRnttyLehdrNm) { set( ATTR_MNTHRNTTYLEHDRNM ,mnthRnttyLehdrNm);}
    /** get 월세_임대인성명 : mnthRnttyLehdrNm */
    public String  getMnrnName() { return (String )get( ATTR_MNTHRNTTYLEHDRNM );}

    /** set 월세_주민번호 : mnthRnttyBurRgsum */
    public void setMnrnRsno(String  mnthRnttyBurRgsum) { set( ATTR_MNTHRNTTYBURRGSUM ,mnthRnttyBurRgsum);}
    /** get 월세_주민번호 : mnthRnttyBurRgsum */
    public String  getMnrnRsno() { return (String )get( ATTR_MNTHRNTTYBURRGSUM );}

    /** set 월세_주택유형코드 : mnthRnttyHusFrmCd */
    public void setMnrnTyhu(String  mnthRnttyHusFrmCd) { set( ATTR_MNTHRNTTYHUSFRMCD ,mnthRnttyHusFrmCd);}
    /** get 월세_주택유형코드 : mnthRnttyHusFrmCd */
    public String  getMnrnTyhu() { return (String )get( ATTR_MNTHRNTTYHUSFRMCD );}
    
    /** set 월세_주택유형코드명 : mnthRnttyHusFrmNm */
    public void setMnrnTyhuNm(String  mnthRnttyHusFrmNm) { set( ATTR_MNTHRNTTYHUSFRMNM ,mnthRnttyHusFrmNm);}
    /** get 월세_주택유형코드명 : mnthRnttyHusFrmNm */
    public String  getMnrnTyhuNm() { return (String )get( ATTR_MNTHRNTTYHUSFRMNM );}

    /** set 월세주택계약면적 : mnthRnttyHusCnttArea */
    public void setMnrnArea(String  mnthRnttyHusCnttArea) { set( ATTR_MNTHRNTTYHUSCNTTAREA ,mnthRnttyHusCnttArea);}
    /** get 월세주택계약면적 : mnthRnttyHusCnttArea */
    public String  getMnrnArea() { return (String )get( ATTR_MNTHRNTTYHUSCNTTAREA );}

    /** set 월세_계약서상주소 : mnthRnttyRntlAddr */
    public void setMnrnAddr(String  mnthRnttyRntlAddr) { set( ATTR_MNTHRNTTYRNTLADDR ,mnthRnttyRntlAddr);}
    /** get 월세_계약서상주소 : mnthRnttyRntlAddr */
    public String  getMnrnAddr() { return (String )get( ATTR_MNTHRNTTYRNTLADDR );}

    /** set 월세_임대차계약시작일자 : mnthRnttyRntlBgnnDt */
    public void setMnrnStdt(String  mnthRnttyRntlBgnnDt) { set( ATTR_MNTHRNTTYRNTLBGNNDT ,mnthRnttyRntlBgnnDt);}
    /** get 월세_임대차계약시작일자 : mnthRnttyRntlBgnnDt */
    public String  getMnrnStdt() { return (String )get( ATTR_MNTHRNTTYRNTLBGNNDT );}

    /** set 월세_임대차계약종료일자 : mnthRnttyRntlEndDt */
    public void setMnrnEddt(String  mnthRnttyRntlEndDt) { set( ATTR_MNTHRNTTYRNTLENDDT ,mnthRnttyRntlEndDt);}
    /** get 월세_임대차계약종료일자 : mnthRnttyRntlEndDt */
    public String  getMnrnEddt() { return (String )get( ATTR_MNTHRNTTYRNTLENDDT );}

    /** set 월세_연간월세금액 : mnthRnttyYrlyMnthSum */
    public void setMnrnAmnt(BigDecimal  mnthRnttyYrlyMnthSum) { set( ATTR_MNTHRNTTYYRLYMNTHSUM ,mnthRnttyYrlyMnthSum);}
    /** get 월세_연간월세금액 : mnthRnttyYrlyMnthSum */
    public BigDecimal  getMnrnAmnt() { return (BigDecimal )get( ATTR_MNTHRNTTYYRLYMNTHSUM );}

    /** set 월세_월세세액공제금액 : mnthRnttyTxDducSum */
    public void setMnrnDuam(BigDecimal  mnthRnttyTxDducSum) { set( ATTR_MNTHRNTTYTXDDUCSUM ,mnthRnttyTxDducSum);}
    /** get 월세_월세세액공제금액 : mnthRnttyTxDducSum */
    public BigDecimal  getMnrnDuam() { return (BigDecimal )get( ATTR_MNTHRNTTYTXDDUCSUM );}

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
    
    /** set 전자파일이관여부 : ectnFlTrnrCtlYn */
    public void setEctnFlTrnrCtlYn(String  ectnFlTrnrCtlYn) { set( ATTR_ECTNFLTRNRCTLYN ,ectnFlTrnrCtlYn);}
    /** get 전자파일이관여부 : ectnFlTrnrCtlYn */
    public String  getEctnFlTrnrCtlYn() { return (String )get( ATTR_ECTNFLTRNRCTLYN );}


}
