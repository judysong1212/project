package com.app.exterms.basis.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Bass0210BM extends MSFSimpleBaseModel implements IsSerializable {
	private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업장코드 : pubcHodyDt */
    public static final String ATTR_PUBCHODYDT = "pubcHodyDt";
    
//    /** set 년도 : year */
//    public static final String ATTR_YEAR = "year";
//
//    /** set 월 : mnth */
//    public static final String ATTR_MNTH = "mnth";
//
//    /** set 일 : day */
//    public static final String ATTR_DAY = "day";
    
    /** set 년월일 : yearMnthDay */
    public static final String ATTR_YEARMNTHDAY = "yearMnthDay";

    /** set 요일코드 : dotwCd */
    public static final String ATTR_DOTWCD = "dotwCd";
    
    /** set 요일 : dotwNm */
    public static final String ATTR_DOTWNM = "dotwNm"; 

    /** set 휴일내용 : pubcHodyCtnt */
    public static final String ATTR_PUBCHODYCTNT = "pubcHodyCtnt";

    /** set 휴일유무 : pubcHodyYn */
    public static final String ATTR_PUBCHODYYN = "pubcHodyYn";

    /** set 유급휴일여부 : paidPubcHodyYn */
    public static final String ATTR_PAIDPUBCHODYYN = "paidPubcHodyYn";

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
     public Bass0210BM() { super(); } 

     
     /** set 년월일 : yearMnthDay */
     public void setYearMnthDay(String yearMnthDay) { set( ATTR_YEARMNTHDAY ,yearMnthDay);}
     /** get 년월일 : yearMnthDay */
     public String getYearMnthDay() { return (String)get( ATTR_YEARMNTHDAY );}

     /** set 년월일 : pubcHodyDt */
     public void setPubcHodyDt(String pubcHodyDt) { set( ATTR_PUBCHODYDT ,pubcHodyDt);}
     /** get 년월일 : pubcHodyDt */
     public String getPubcHodyDt() { return (String)get( ATTR_PUBCHODYDT );}
    

	/** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get( ATTR_DPOBCD );}

//    /** set 년도 : year */
//    public void setYear(String year) { set( ATTR_YEAR ,year);}
//    /** get 년도 : year */
//    public String getYear() { return (String)get( ATTR_YEAR );}
//
//    /** set 월 : mnth */
//    public void setMnth(String mnth) { set( ATTR_MNTH ,mnth);}
//    /** get 월 : mnth */
//    public String getMnth() { return (String)get( ATTR_MNTH );}
//
//    /** set 일 : day */
//    public void setDay(String day) { set( ATTR_DAY ,day);}
//    /** get 일 : day */
//    public String getDay() { return (String)get( ATTR_DAY );}

    /** set 요일코드 : dotwCd */
    public void setDotwCd(String dotwCd) { set( ATTR_DOTWCD ,dotwCd);}
    /** get 요일코드 : dotwCd */
    public String getDotwCd() { return (String)get( ATTR_DOTWCD );}
    
     
    /** set 요일 : dotwNm */
    public void setDotwNm(String dotwNm) { set( ATTR_DOTWNM ,dotwNm);}
    /** get 요일 : dotwNm */
    public String getDotwNm() { return (String)get( ATTR_DOTWNM );} 

    /** set 휴일내용 : pubcHodyCtnt */
    public void setPubcHodyCtnt(String pubcHodyCtnt) { set( ATTR_PUBCHODYCTNT ,pubcHodyCtnt);}
    /** get 휴일내용 : pubcHodyCtnt */
    public String getPubcHodyCtnt() { return (String)get( ATTR_PUBCHODYCTNT );}

    /** set 휴일유무 : pubcHodyYn */
    public void setPubcHodyYn(String pubcHodyYn) { set( ATTR_PUBCHODYYN ,pubcHodyYn);}
    /** get 휴일유무 : pubcHodyYn */
    public String getPubcHodyYn() { return (String)get( ATTR_PUBCHODYYN );}

    /** set 유급휴일여부 : paidPubcHodyYn */
    public void setPaidPubcHodyYn(String paidPubcHodyYn) { set( ATTR_PAIDPUBCHODYYN ,paidPubcHodyYn);}
    /** get 유급휴일여부 : paidPubcHodyYn */
    public String getPaidPubcHodyYn() { return (String)get( ATTR_PAIDPUBCHODYYN );}

    /** set 입력자 : kybdr */
    public void setKybdr(String kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String getKybdr() { return (String)get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String getInptDt() { return (String)get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String getInptAddr() { return (String)get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String getIsmt() { return (String)get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String getRevnDt() { return (String)get( ATTR_REVNDT );}

    /** set 수정자주소 : revnAddr */
    public void setRevnAddr(String revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정자주소 : revnAddr */
    public String getRevnAddr() { return (String)get( ATTR_REVNADDR );}
}
