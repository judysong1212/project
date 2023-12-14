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
public class Yeta3100BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 연금_저축일련번호 : finaSeqn */
    public static final String ATTR_FINASEQN = "finaSeqn";

    /** set 소득공제구분코드 : imdeGbcd */
    public static final String ATTR_IMDEGBCD = "imdeGbcd";
    
    /** set 소득공제구분코드 : imdeGbcd */
    public static final String ATTR_IMDEGBNM = "imdeGbnm";

    /** set 금융기관코드 : finaCode */
    public static final String ATTR_FINACODE = "finaCode";
    
    /** set 금융기관코드 : finaCode */
    public static final String ATTR_FINACODENM = "finaCodeNm";

    /** set 금융기관상호 : finaName */
    public static final String ATTR_FINANAME = "finaName";

    /** set 계좌번호 : acntNumb */
    public static final String ATTR_ACNTNUMB = "acntNumb";

    /** set 납입연차 : icnmYear */
    public static final String ATTR_ICNMYEAR = "icnmYear";

    /** set 불입금액 : paytAmnt */
    public static final String ATTR_PAYTAMNT = "paytAmnt";

    /** set 세액공제금액 : deduAmnt */
    public static final String ATTR_DEDUAMNT = "deduAmnt";

    /** set 소득공제구분국세청코드 : imdeTxcd */
    public static final String ATTR_IMDETXCD = "imdeTxcd";

    /** set 금융기관국세청코드 : finaTxcd */
    public static final String ATTR_FINATXCD = "finaTxcd";

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
     public Yeta3100BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3100BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  systemkey 
    		, BigDecimal  finaSeqn 
    		, String  imdeGbcd 
    		, String  finaCode 
    		, String  finaName 
    		, String  acntNumb 
    		, String  icnmYear 
    		, BigDecimal  paytAmnt 
    		, BigDecimal  deduAmnt 
    		, String  imdeTxcd 
    		, String  finaTxcd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_FINASEQN,finaSeqn);
     	values.put(ATTR_IMDEGBCD,imdeGbcd);
     	values.put(ATTR_FINACODE,finaCode);
     	values.put(ATTR_FINANAME,finaName);
     	values.put(ATTR_ACNTNUMB,acntNumb);
     	values.put(ATTR_ICNMYEAR,icnmYear);
     	values.put(ATTR_PAYTAMNT,paytAmnt);
     	values.put(ATTR_DEDUAMNT,deduAmnt);
     	values.put(ATTR_IMDETXCD,imdeTxcd);
     	values.put(ATTR_FINATXCD,finaTxcd);
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

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 연금_저축일련번호 : finaSeqn */
    public void setFinaSeqn(BigDecimal  finaSeqn) { set( ATTR_FINASEQN ,finaSeqn);}
    /** get 연금_저축일련번호 : finaSeqn */
    public BigDecimal  getFinaSeqn() { return (BigDecimal )get( ATTR_FINASEQN );}

    /** set 소득공제구분코드 : imdeGbcd */
    public void setImdeGbcd(String  imdeGbcd) { set( ATTR_IMDEGBCD ,imdeGbcd);}
    /** get 소득공제구분코드 : imdeGbcd */
    public String  getImdeGbcd() { return (String )get( ATTR_IMDEGBCD );}
    
    /** set 소득공제구분코드명 : imdeGbcd */
    public void setImdeGbnm(String  imdeGbnm) { set( ATTR_IMDEGBNM ,imdeGbnm);}
    /** get 소득공제구분코드명 : imdeGbcd */
    public String  getImdeGbnm() { return (String )get( ATTR_IMDEGBNM );}

    /** set 금융기관코드 : finaCode */
    public void setFinaCode(String  finaCode) { set( ATTR_FINACODE ,finaCode);}
    /** get 금융기관코드 : finaCode */
    public String  getFinaCode() { return (String )get( ATTR_FINACODE );}

    /** set 금융기관상호 : finaName */
    public void setFinaName(String  finaName) { set( ATTR_FINANAME ,finaName);}
    /** get 금융기관상호 : finaName */
    public String  getFinaName() { return (String )get( ATTR_FINANAME );}

    /** set 계좌번호 : acntNumb */
    public void setAcntNumb(String  acntNumb) { set( ATTR_ACNTNUMB ,acntNumb);}
    /** get 계좌번호 : acntNumb */
    public String  getAcntNumb() { return (String )get( ATTR_ACNTNUMB );}

    /** set 납입연차 : icnmYear */
    public void setIcnmYear(String  icnmYear) { set( ATTR_ICNMYEAR ,icnmYear);}
    /** get 납입연차 : icnmYear */
    public String  getIcnmYear() { return (String )get( ATTR_ICNMYEAR );}

    /** set 불입금액 : paytAmnt */
    public void setPaytAmnt(BigDecimal  paytAmnt) { set( ATTR_PAYTAMNT ,paytAmnt);}
    /** get 불입금액 : paytAmnt */
    public BigDecimal  getPaytAmnt() { return (BigDecimal )get( ATTR_PAYTAMNT );}

    /** set 세액공제금액 : deduAmnt */
    public void setDeduAmnt(BigDecimal  deduAmnt) { set( ATTR_DEDUAMNT ,deduAmnt);}
    /** get 세액공제금액 : deduAmnt */
    public BigDecimal  getDeduAmnt() { return (BigDecimal )get( ATTR_DEDUAMNT );}

    /** set 소득공제구분국세청코드 : imdeTxcd */
    public void setImdeTxcd(String  imdeTxcd) { set( ATTR_IMDETXCD ,imdeTxcd);}
    /** get 소득공제구분국세청코드 : imdeTxcd */
    public String  getImdeTxcd() { return (String )get( ATTR_IMDETXCD );}

    /** set 금융기관국세청코드 : finaTxcd */
    public void setFinaTxcd(String  finaTxcd) { set( ATTR_FINATXCD ,finaTxcd);}
    /** get 금융기관국세청코드 : finaTxcd */
    public String  getFinaTxcd() { return (String )get( ATTR_FINATXCD );}

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
