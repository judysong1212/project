package com.app.exterms.yearendtax.client.dto.yeta2015;



import java.math.BigDecimal;

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
public class Yeta3140BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 의료비지급일련번호 : mediSeqn */
    public static final String ATTR_MEDISEQN = "mediSeqn";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";
    
    /** set 정산구분 : settGbnm */
    public static final String ATTR_SETTGBNM = "settGbnm";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 주민등록번호 : rsnoNumb */
    public static final String ATTR_RSNONUMB = "rsnoNumb";

    /** set 본인등해당여부 : psclHpyn */
    public static final String ATTR_PSCLHPYN = "psclHpyn";

    /** set 거래처번호 : vendNumb */
    public static final String ATTR_VENDNUMB = "vendNumb";

    /** set 거래처명 : vendName */
    public static final String ATTR_VENDNAME = "vendName";

    /** set 의료증빙코드 : mediCfcd */
    public static final String ATTR_MEDICFCD = "mediCfcd";
    
    /** set 의료증빙코드명 : mediCfnm */
    public static final String ATTR_MEDICFNM = "mediCfnm";

    /** set 지급건수 : cashUect */
    public static final String ATTR_CASHUECT = "cashUect";

    /** set 지급금액 : cashUeam */
    public static final String ATTR_CASHUEAM = "cashUeam";

    /** set 난임시술비해당여부 : ctifTrea */
    public static final String ATTR_CTIFTREA = "ctifTrea";

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
     public Yeta3140BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3140BM(
    		 BigDecimal  mediSeqn 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  dpobCd 
    		, String  systemkey 
    		, String  rsnoNumb 
    		, String  psclHpyn 
    		, String  vendNumb 
    		, String  vendName 
    		, String  mediCfcd 
    		, BigDecimal  cashUect 
    		, BigDecimal  cashUeam 
    		, String  ctifTrea 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_MEDISEQN,mediSeqn);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_RSNONUMB,rsnoNumb);
     	values.put(ATTR_PSCLHPYN,psclHpyn);
     	values.put(ATTR_VENDNUMB,vendNumb);
     	values.put(ATTR_VENDNAME,vendName);
     	values.put(ATTR_MEDICFCD,mediCfcd);
     	values.put(ATTR_CASHUECT,cashUect);
     	values.put(ATTR_CASHUEAM,cashUeam);
     	values.put(ATTR_CTIFTREA,ctifTrea);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 의료비지급일련번호 : mediSeqn */
    public void setMediSeqn(BigDecimal  mediSeqn) { set( ATTR_MEDISEQN ,mediSeqn);}
    /** get 의료비지급일련번호 : mediSeqn */
    public BigDecimal  getMediSeqn() { return (BigDecimal )get( ATTR_MEDISEQN );}

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 주민등록번호 : rsnoNumb */
    public void setRsnoNumb(String  rsnoNumb) { set( ATTR_RSNONUMB ,rsnoNumb);}
    /** get 주민등록번호 : rsnoNumb */
    public String  getRsnoNumb() { return (String )get( ATTR_RSNONUMB );}

    /** set 본인등해당여부 : psclHpyn */
    public void setPsclHpyn(String  psclHpyn) { set( ATTR_PSCLHPYN ,psclHpyn);}
    /** get 본인등해당여부 : psclHpyn */
    public String  getPsclHpyn() { return (String )get( ATTR_PSCLHPYN );}

    /** set 거래처번호 : vendNumb */
    public void setVendNumb(String  vendNumb) { set( ATTR_VENDNUMB ,vendNumb);}
    /** get 거래처번호 : vendNumb */
    public String  getVendNumb() { return (String )get( ATTR_VENDNUMB );}

    /** set 거래처명 : vendName */
    public void setVendName(String  vendName) { set( ATTR_VENDNAME ,vendName);}
    /** get 거래처명 : vendName */
    public String  getVendName() { return (String )get( ATTR_VENDNAME );}

    /** set 의료증빙코드 : mediCfcd */
    public void setMediCfcd(String  mediCfcd) { set( ATTR_MEDICFCD ,mediCfcd);}
    /** get 의료증빙코드 : mediCfcd */
    public String  getMediCfcd() { return (String )get( ATTR_MEDICFCD );}
    
    /** set 의료증빙코드명 : mediCfnm */
    public void setMediCfnm(String  mediCfnm) { set( ATTR_MEDICFNM ,mediCfnm);}
    /** get 의료증빙코드명 : mediCfnm */
    public String  getMediCfnm() { return (String )get( ATTR_MEDICFNM );}

    /** set 지급건수 : cashUect */
    public void setCashUect(BigDecimal  cashUect) { set( ATTR_CASHUECT ,cashUect);}
    /** get 지급건수 : cashUect */
    public BigDecimal  getCashUect() { return (BigDecimal )get( ATTR_CASHUECT );}

    /** set 지급금액 : cashUeam */
    public void setCashUeam(BigDecimal  cashUeam) { set( ATTR_CASHUEAM ,cashUeam);}
    /** get 지급금액 : cashUeam */
    public BigDecimal  getCashUeam() { return (BigDecimal )get( ATTR_CASHUEAM );}

    /** set 난임시술비해당여부 : ctifTrea */
    public void setCtifTrea(String  ctifTrea) { set( ATTR_CTIFTREA ,ctifTrea);}
    /** get 난임시술비해당여부 : ctifTrea */
    public String  getCtifTrea() { return (String )get( ATTR_CTIFTREA );}

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
    
    /** set 정산구분 : settGbnm */
    public void setSettGbnm(String  settGbnm) { set( ATTR_SETTGBNM ,settGbnm);}
    /** get 정산구분 : settGbnm */
    public String  getSettGbnm() { return (String )get( ATTR_SETTGBNM );}


}
