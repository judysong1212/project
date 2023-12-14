package com.app.exterms.yearendtax.client.dto.yeta2023;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : PdfJ501yBM.java
 * @Description : PdfJ501yBM class
 * @Modification Information
 *
 * @author atres
 * @since 2020.12.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfJ501yBM extends MSFSimpleBaseModel implements IsSerializable {

	private static final long serialVersionUID = 1L;

	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 귀속년도 : yrtxBlggYr */
	public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

	/** set 연말정산구분코드 : clutSeptCd */
	public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";
	
	
	public static final String ATTR_MANSEILNUM = "manSeilNum";

	/** set 서식코드 : formCd */
	public static final String ATTR_FORMCD = "formCd";

	/** set 월세액 주민등록번호 : resid */
	public static final String ATTR_RESID = "resid";

	/** set 월세액 성명 : name */
	public static final String ATTR_NAME = "name";

	/** set 자료코드 : datCd */
	public static final String ATTR_DATCD = "datCd";

	/** set 임대인번호 : lsorNo */
	public static final String ATTR_LSORNO = "lsorNo";

	/** set 임대인 명: lsorNm */
	public static final String ATTR_LSORNM= "lsorNm";

	/** set 임대차 시작일 : rentalSt */
	public static final String ATTR_RENTALST= "rentalSt";

	/** set 임대차 종료일 : rentalDt */
	public static final String ATTR_RENTALDT = "rentalDt";
	
	/** set 계약서 주소 : rentalAdr */
	public static final String ATTR_RENTALADR = "rentalAdr";

	/** set 계약면적 : rentalArea */
	public static final String ATTR_RENTALAREA = "rentalArea";
	
	public static final String ATTR_RENTALCD = "rentalCd";

	/** set 지급액 : rentalAmtSum */
	public static final String ATTR_RENTALAMTSUM = "rentalAmtSum";
	
	/** set pdf 소득공제자료적용여부 : pdfDatAppYn */
	public static final String ATTR_PDFDATAPPYN = "pdfDatAppYn";

	/** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
	public static final String ATTR_PDFDATAPPCMPLDT = "pdfDatAppCmplDt";

	/** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
	public static final String ATTR_PDFDATAPPEXCCTNT = "pdfDatAppExcCtnt";

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
	
	/** 생성자*/
	public PdfJ501yBM() {
		super();
	}
	
	 public PdfJ501yBM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey
    		, String  manSeilNum
    		, String  formCd 
    		, String  resid 
    		, String  name 
    		, String  datCd 
    		, String  lsorNo 
    		, String  lsorNm
    		, String  rentalSt 
    		, String rentalDt 
    		, String rentalAdr
    		, String rentalArea 
    		, String rentalCd
    		, Long 	rentalAmtSum
    		, String  pdfDatAppYn 
    		, String  pdfDatAppCmplDt
    		, String  pdfDatAppExcCtnt
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_SYSTEMKEY,manSeilNum);
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_RESID,resid);
     	values.put(ATTR_NAME,name);
     	values.put(ATTR_DATCD,datCd);
     	values.put(ATTR_LSORNO,lsorNo);
     	values.put(ATTR_LSORNM,lsorNm);
     	values.put(ATTR_RENTALST,rentalSt);
     	values.put(ATTR_RENTALDT,rentalDt);
     	values.put(ATTR_RENTALADR,rentalAdr);
     	values.put(ATTR_RENTALAREA,rentalArea);
     	values.put(ATTR_RENTALCD, rentalCd);
     	values.put(ATTR_RENTALAMTSUM ,rentalAmtSum);
     	values.put(ATTR_PDFDATAPPYN,pdfDatAppYn);
     	values.put(ATTR_PDFDATAPPCMPLDT,pdfDatAppCmplDt);
     	values.put(ATTR_PDFDATAPPEXCCTNT,pdfDatAppExcCtnt);
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

	    /** set 귀속년도 : yrtxBlggYr */
	    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
	    /** get 귀속년도 : yrtxBlggYr */
	    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

	    /** set 연말정산구분코드 : clutSeptCd */
	    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
	    /** get 연말정산구분코드 : clutSeptCd */
	    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

	    /** set SYSTEMKEY : systemkey */
	    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	    /** get SYSTEMKEY : systemkey */
	    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
	    
	    public void setManSeilNum(String  manSeilNum) { set( ATTR_SYSTEMKEY ,manSeilNum);}
	    public String  getManSeilNum() { return (String )get( ATTR_SYSTEMKEY );}

	    /** set 서식코드 : formCd */
	    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
	    /** get 서식코드 : formCd */
	    public String  getFormCd() { return (String )get( ATTR_FORMCD );}
	    
	    /** set 월세액 주민등록번호 : resid */
	    public void setResid(String  resid) { set( ATTR_RESID ,resid);}
	    /** get 월세액 주민등록번호 : resid */
	    public String  getResid() { return (String )get( ATTR_RESID );}

	    /** set 월세액 성명 : name */
	    public void setName(String  name) { set( ATTR_NAME ,name);}
	    /** get 월세액 성명 : name */
	    public String  getName() { return (String )get( ATTR_NAME );}

	    /** set 자료코드 : datCd */
	    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
	    /** get 자료코드 : datCd */
	    public String  getDatCd() { return (String )get( ATTR_DATCD );}
	    
	    /** set 임대인번호 : lsorNo */
	    public void setLsorNo(String  lsorNo) { set( ATTR_LSORNO ,lsorNo);}
	    /** get 임대인번호 : lsorNo */
	    public Long  getLsorNo() { return (Long )get( ATTR_LSORNO );}

	    /** set 임대인 명: lsorNm */
	    public void setLsorNm(String lsorNm) { set( ATTR_LSORNM ,lsorNm);}
	    /** set 임대인 명: lsorNm */
	    public Long getLsorNm() { return (Long )get( ATTR_LSORNM);}

	    /** set 임대차 시작일 : rentalSt */
	    public void setRentalSt(String  rentalSt) { set( ATTR_RENTALST  ,rentalSt);}
	    /** set 임대차 시작일 : rentalSt */
	    public Long  getRentalSt() { return (Long )get( ATTR_RENTALST );}

	    /** set 임대차 종료일 : rentalDt */	   
	    public void setRentalDt(String  rentalDt) { set( ATTR_RENTALDT ,rentalDt);}
	    /** set 임대차 종료일 : rentalDt */	
	    public String  getRentalDt() { return (String )get( ATTR_RENTALDT );}
	    
	    /** set 계약서 주소 : rentalAdr */
	    public void setRentalAdr(String  rentalAdr) { set( ATTR_RENTALADR ,rentalAdr);}
	    /** set 계약서 주소 : rentalAdr */
	    public String  getRentalAdr() { return (String )get( ATTR_RENTALADR );}
	    
	    /** set 계약면적 : rentalArea */
	    public void setrentalArea(String  rentalArea) { set( ATTR_RENTALAREA ,rentalArea);}
	    /** set 계약면적 : rentalArea */
	    public String  getrentalArea() { return (String )get( ATTR_RENTALAREA);}
	    
	    /** set 계약코드 : rentalCd */
	    public void setrentalCd(String  rentalCd) { set( ATTR_RENTALCD ,rentalCd);}
	    /** set 계약코드 : rentalCd */
	    public String  getrentalCd() { return (String )get( ATTR_RENTALCD);}

	    /** set 지급액 : rentalAmtSum */
	    public void setRentalAmtSum(Long  rentalAmtSum) { set( ATTR_RENTALAMTSUM,rentalAmtSum);}
	    /** set 지급액 : rentalAmtSum */
	    public Long  getRentalAmtSum() { return (Long)get( ATTR_RENTALAMTSUM);}
	    
	    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
	    public void setPdfDatAppYn(String  pdfDatAppYn) { set( ATTR_PDFDATAPPYN ,pdfDatAppYn);}
	    /** get pdf 소득공제자료적용여부 : pdfDatAppYn */
	    public String  getPdfDatAppYn() { return (String )get( ATTR_PDFDATAPPYN );}
	    
	    /** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
	    public void setPdfDatAppCmplDt(String  pdfDatAppCmplDt) { set( ATTR_PDFDATAPPCMPLDT ,pdfDatAppCmplDt);}
	    /** get pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
	    public String  getPdfDatAppCmplDt() { return (String )get( ATTR_PDFDATAPPCMPLDT );}
	    
	    /** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
	    public void setPdfDatAppExcCtnt(String  pdfDatAppExcCtnt) { set( ATTR_PDFDATAPPEXCCTNT ,pdfDatAppExcCtnt);}
	    /** get pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
	    public String  getPdfDatAppExcCtnt() { return (String )get( ATTR_PDFDATAPPEXCCTNT );}

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
