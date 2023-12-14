package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0900VO.java
 * @Description : Payr0900 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0300BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
   
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 공통코드 : commCd */
    public static final String ATTR_COMMCD = "commCd";

    /** set 대표코드 : rpsttvCd */
    public static final String ATTR_RPSTTVCD = "rpsttvCd";

    /** set 세부코드 : dtlCd */
    public static final String ATTR_DTLCD = "dtlCd";

    /** set 공통코드명 : commCdNm */
    public static final String ATTR_COMMCDNM = "commCdNm";

    /** set 약어명 : abbrNm */
    public static final String ATTR_ABBRNM = "abbrNm";

    /** set 영문명 : engNm */
    public static final String ATTR_ENGNM = "engNm";

    /** set 관리항목01 : mangeItem01 */
    public static final String ATTR_MANGEITEM01 = "mangeItem01";

    /** set 관리항목02 : mangeItem02 */
    public static final String ATTR_MANGEITEM02 = "mangeItem02";

    /** set 관리항목03 : mangeItem03 */
    public static final String ATTR_MANGEITEM03 = "mangeItem03";

    /** set 관리항목04 : mangeItem04 */
    public static final String ATTR_MANGEITEM04 = "mangeItem04";

    /** set 관리항목05 : mangeItem05 */
    public static final String ATTR_MANGEITEM05 = "mangeItem05";

    /** set 관리항목06 : mangeItem06 */
    public static final String ATTR_MANGEITEM06 = "mangeItem06";

    /** set 관리항목07 : mangeItem07 */
    public static final String ATTR_MANGEITEM07 = "mangeItem07";

    /** set 관리항목08 : mangeItem08 */
    public static final String ATTR_MANGEITEM08 = "mangeItem08";

    /** set 관리항목09 : mangeItem09 */
    public static final String ATTR_MANGEITEM09 = "mangeItem09";

    /** set 관리항목10 : mangeItem10 */
    public static final String ATTR_MANGEITEM10 = "mangeItem10";

    /** set 관리항목11 : mangeItem11 */
    public static final String ATTR_MANGEITEM11 = "mangeItem11";

    /** set 관리항목12 : mangeItem12 */
    public static final String ATTR_MANGEITEM12 = "mangeItem12";

    /** set 관리항목13 : mangeItem13 */
    public static final String ATTR_MANGEITEM13 = "mangeItem13";

    /** set 관리항목14 : mangeItem14 */
    public static final String ATTR_MANGEITEM14 = "mangeItem14";

    /** set 관리항목15 : mangeItem15 */
    public static final String ATTR_MANGEITEM15 = "mangeItem15";

    /** set 관리항목16 : mangeItem16 */
    public static final String ATTR_MANGEITEM16 = "mangeItem16";

    /** set 관리항목17 : mangeItem17 */
    public static final String ATTR_MANGEITEM17 = "mangeItem17";

    /** set 관리항목18 : mangeItem18 */
    public static final String ATTR_MANGEITEM18 = "mangeItem18";

    /** set 관리항목19 : mangeItem19 */
    public static final String ATTR_MANGEITEM19 = "mangeItem19";

    /** set 관리항목20 : mangeItem20 */
    public static final String ATTR_MANGEITEM20 = "mangeItem20";

    /** set 코드TREE레벨 : cdTreeLvl */
    public static final String ATTR_CDTREELVL = "cdTreeLvl";

    /** set 순서 : ord */
    public static final String ATTR_ORD = "ord";

    /** set 오픈여부 : opnYn */
    public static final String ATTR_OPNYN = "opnYn";

    /** set 사용여부 : useYn */
    public static final String ATTR_USEYN = "useYn";

    /** set 비고 : note */
    public static final String ATTR_NOTE = "note";

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

    /** 생성자 */
     public Bass0300BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass0300BM(
    		 String  dpobCd 
    		, String  commCd 
    		, String  rpsttvCd 
    		, String  dtlCd 
    		, String  commCdNm 
    		, String  abbrNm 
    		, String  engNm 
    		, String  mangeItem01 
    		, String  mangeItem02 
    		, String  mangeItem03 
    		, String  mangeItem04 
    		, String  mangeItem05 
    		, String  mangeItem06 
    		, String  mangeItem07 
    		, String  mangeItem08 
    		, String  mangeItem09 
    		, String  mangeItem10 
    		, String  mangeItem11 
    		, String  mangeItem12 
    		, String  mangeItem13 
    		, String  mangeItem14 
    		, String  mangeItem15 
    		, String  mangeItem16 
    		, String  mangeItem17 
    		, String  mangeItem18 
    		, String  mangeItem19 
    		, String  mangeItem20 
    		, String  cdTreeLvl 
    		, BigDecimal  ord 
    		, String  opnYn 
    		, String  useYn 
    		, String  note 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_COMMCD,commCd);
     	values.put(ATTR_RPSTTVCD,rpsttvCd);
     	values.put(ATTR_DTLCD,dtlCd);
     	values.put(ATTR_COMMCDNM,commCdNm);
     	values.put(ATTR_ABBRNM,abbrNm);
     	values.put(ATTR_ENGNM,engNm);
     	values.put(ATTR_MANGEITEM01,mangeItem01);
     	values.put(ATTR_MANGEITEM02,mangeItem02);
     	values.put(ATTR_MANGEITEM03,mangeItem03);
     	values.put(ATTR_MANGEITEM04,mangeItem04);
     	values.put(ATTR_MANGEITEM05,mangeItem05);
     	values.put(ATTR_MANGEITEM06,mangeItem06);
     	values.put(ATTR_MANGEITEM07,mangeItem07);
     	values.put(ATTR_MANGEITEM08,mangeItem08);
     	values.put(ATTR_MANGEITEM09,mangeItem09);
     	values.put(ATTR_MANGEITEM10,mangeItem10);
     	values.put(ATTR_MANGEITEM11,mangeItem11);
     	values.put(ATTR_MANGEITEM12,mangeItem12);
     	values.put(ATTR_MANGEITEM13,mangeItem13);
     	values.put(ATTR_MANGEITEM14,mangeItem14);
     	values.put(ATTR_MANGEITEM15,mangeItem15);
     	values.put(ATTR_MANGEITEM16,mangeItem16);
     	values.put(ATTR_MANGEITEM17,mangeItem17);
     	values.put(ATTR_MANGEITEM18,mangeItem18);
     	values.put(ATTR_MANGEITEM19,mangeItem19);
     	values.put(ATTR_MANGEITEM20,mangeItem20);
     	values.put(ATTR_CDTREELVL,cdTreeLvl);
     	values.put(ATTR_ORD,ord);
     	values.put(ATTR_OPNYN,opnYn);
     	values.put(ATTR_USEYN,useYn);
     	values.put(ATTR_NOTE,note);
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
    /** set 공통코드 : commCd */
    public void setCommCd(String  commCd) { set( ATTR_COMMCD ,commCd);}
    /** get 공통코드 : commCd */
    public String  getCommCd() { return (String )get( ATTR_COMMCD );}
    /** set 대표코드 : rpsttvCd */
    public void setRpsttvCd(String  rpsttvCd) { set( ATTR_RPSTTVCD ,rpsttvCd);}
    /** get 대표코드 : rpsttvCd */
    public String  getRpsttvCd() { return (String )get( ATTR_RPSTTVCD );}
    /** set 세부코드 : dtlCd */
    public void setDtlCd(String  dtlCd) { set( ATTR_DTLCD ,dtlCd);}
    /** get 세부코드 : dtlCd */
    public String  getDtlCd() { return (String )get( ATTR_DTLCD );}
    /** set 공통코드명 : commCdNm */
    public void setCommCdNm(String  commCdNm) { set( ATTR_COMMCDNM ,commCdNm);}
    /** get 공통코드명 : commCdNm */
    public String  getCommCdNm() { return (String )get( ATTR_COMMCDNM );}
    /** set 약어명 : abbrNm */
    public void setAbbrNm(String  abbrNm) { set( ATTR_ABBRNM ,abbrNm);}
    /** get 약어명 : abbrNm */
    public String  getAbbrNm() { return (String )get( ATTR_ABBRNM );}
    /** set 영문명 : engNm */
    public void setEngNm(String  engNm) { set( ATTR_ENGNM ,engNm);}
    /** get 영문명 : engNm */
    public String  getEngNm() { return (String )get( ATTR_ENGNM );}
    /** set 관리항목01 : mangeItem01 */
    public void setMangeItem01(String  mangeItem01) { set( ATTR_MANGEITEM01 ,mangeItem01);}
    /** get 관리항목01 : mangeItem01 */
    public String  getMangeItem01() { return (String )get( ATTR_MANGEITEM01 );}
    /** set 관리항목02 : mangeItem02 */
    public void setMangeItem02(String  mangeItem02) { set( ATTR_MANGEITEM02 ,mangeItem02);}
    /** get 관리항목02 : mangeItem02 */
    public String  getMangeItem02() { return (String )get( ATTR_MANGEITEM02 );}
    /** set 관리항목03 : mangeItem03 */
    public void setMangeItem03(String  mangeItem03) { set( ATTR_MANGEITEM03 ,mangeItem03);}
    /** get 관리항목03 : mangeItem03 */
    public String  getMangeItem03() { return (String )get( ATTR_MANGEITEM03 );}
    /** set 관리항목04 : mangeItem04 */
    public void setMangeItem04(String  mangeItem04) { set( ATTR_MANGEITEM04 ,mangeItem04);}
    /** get 관리항목04 : mangeItem04 */
    public String  getMangeItem04() { return (String )get( ATTR_MANGEITEM04 );}
    /** set 관리항목05 : mangeItem05 */
    public void setMangeItem05(String  mangeItem05) { set( ATTR_MANGEITEM05 ,mangeItem05);}
    /** get 관리항목05 : mangeItem05 */
    public String  getMangeItem05() { return (String )get( ATTR_MANGEITEM05 );}
    /** set 관리항목06 : mangeItem06 */
    public void setMangeItem06(String  mangeItem06) { set( ATTR_MANGEITEM06 ,mangeItem06);}
    /** get 관리항목06 : mangeItem06 */
    public String  getMangeItem06() { return (String )get( ATTR_MANGEITEM06 );}
    /** set 관리항목07 : mangeItem07 */
    public void setMangeItem07(String  mangeItem07) { set( ATTR_MANGEITEM07 ,mangeItem07);}
    /** get 관리항목07 : mangeItem07 */
    public String  getMangeItem07() { return (String )get( ATTR_MANGEITEM07 );}
    /** set 관리항목08 : mangeItem08 */
    public void setMangeItem08(String  mangeItem08) { set( ATTR_MANGEITEM08 ,mangeItem08);}
    /** get 관리항목08 : mangeItem08 */
    public String  getMangeItem08() { return (String )get( ATTR_MANGEITEM08 );}
    /** set 관리항목09 : mangeItem09 */
    public void setMangeItem09(String  mangeItem09) { set( ATTR_MANGEITEM09 ,mangeItem09);}
    /** get 관리항목09 : mangeItem09 */
    public String  getMangeItem09() { return (String )get( ATTR_MANGEITEM09 );}
    /** set 관리항목10 : mangeItem10 */
    public void setMangeItem10(String  mangeItem10) { set( ATTR_MANGEITEM10 ,mangeItem10);}
    /** get 관리항목10 : mangeItem10 */
    public String  getMangeItem10() { return (String )get( ATTR_MANGEITEM10 );}
    /** set 관리항목11 : mangeItem11 */
    public void setMangeItem11(String  mangeItem11) { set( ATTR_MANGEITEM11 ,mangeItem11);}
    /** get 관리항목11 : mangeItem11 */
    public String  getMangeItem11() { return (String )get( ATTR_MANGEITEM11 );}
    /** set 관리항목12 : mangeItem12 */
    public void setMangeItem12(String  mangeItem12) { set( ATTR_MANGEITEM12 ,mangeItem12);}
    /** get 관리항목12 : mangeItem12 */
    public String  getMangeItem12() { return (String )get( ATTR_MANGEITEM12 );}
    /** set 관리항목13 : mangeItem13 */
    public void setMangeItem13(String  mangeItem13) { set( ATTR_MANGEITEM13 ,mangeItem13);}
    /** get 관리항목13 : mangeItem13 */
    public String  getMangeItem13() { return (String )get( ATTR_MANGEITEM13 );}
    /** set 관리항목14 : mangeItem14 */
    public void setMangeItem14(String  mangeItem14) { set( ATTR_MANGEITEM14 ,mangeItem14);}
    /** get 관리항목14 : mangeItem14 */
    public String  getMangeItem14() { return (String )get( ATTR_MANGEITEM14 );}
    /** set 관리항목15 : mangeItem15 */
    public void setMangeItem15(String  mangeItem15) { set( ATTR_MANGEITEM15 ,mangeItem15);}
    /** get 관리항목15 : mangeItem15 */
    public String  getMangeItem15() { return (String )get( ATTR_MANGEITEM15 );}
    /** set 관리항목16 : mangeItem16 */
    public void setMangeItem16(String  mangeItem16) { set( ATTR_MANGEITEM16 ,mangeItem16);}
    /** get 관리항목16 : mangeItem16 */
    public String  getMangeItem16() { return (String )get( ATTR_MANGEITEM16 );}
    /** set 관리항목17 : mangeItem17 */
    public void setMangeItem17(String  mangeItem17) { set( ATTR_MANGEITEM17 ,mangeItem17);}
    /** get 관리항목17 : mangeItem17 */
    public String  getMangeItem17() { return (String )get( ATTR_MANGEITEM17 );}
    /** set 관리항목18 : mangeItem18 */
    public void setMangeItem18(String  mangeItem18) { set( ATTR_MANGEITEM18 ,mangeItem18);}
    /** get 관리항목18 : mangeItem18 */
    public String  getMangeItem18() { return (String )get( ATTR_MANGEITEM18 );}
    /** set 관리항목19 : mangeItem19 */
    public void setMangeItem19(String  mangeItem19) { set( ATTR_MANGEITEM19 ,mangeItem19);}
    /** get 관리항목19 : mangeItem19 */
    public String  getMangeItem19() { return (String )get( ATTR_MANGEITEM19 );}
    /** set 관리항목20 : mangeItem20 */
    public void setMangeItem20(String  mangeItem20) { set( ATTR_MANGEITEM20 ,mangeItem20);}
    /** get 관리항목20 : mangeItem20 */
    public String  getMangeItem20() { return (String )get( ATTR_MANGEITEM20 );}
    /** set 코드TREE레벨 : cdTreeLvl */
    public void setCdTreeLvl(String  cdTreeLvl) { set( ATTR_CDTREELVL ,cdTreeLvl);}
    /** get 코드TREE레벨 : cdTreeLvl */
    public String  getCdTreeLvl() { return (String )get( ATTR_CDTREELVL );}
    /** set 순서 : ord */
    public void setOrd(BigDecimal  ord) { set( ATTR_ORD ,ord);}
    /** get 순서 : ord */
    public BigDecimal  getOrd() { return (BigDecimal )get( ATTR_ORD );}
    /** set 오픈여부 : opnYn */
    public void setOpnYn(String  opnYn) { set( ATTR_OPNYN ,opnYn);}
    /** get 오픈여부 : opnYn */
    public String  getOpnYn() { return (String )get( ATTR_OPNYN );}
    /** set 사용여부 : useYn */
    public void setUseYn(String  useYn) { set( ATTR_USEYN ,useYn);}
    /** get 사용여부 : useYn */
    public String  getUseYn() { return (String )get( ATTR_USEYN );}
    /** set 비고 : note */
    public void setNote(String  note) { set( ATTR_NOTE ,note);}
    /** get 비고 : note */
    public String  getNote() { return (String )get( ATTR_NOTE );}
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
    
    
}
