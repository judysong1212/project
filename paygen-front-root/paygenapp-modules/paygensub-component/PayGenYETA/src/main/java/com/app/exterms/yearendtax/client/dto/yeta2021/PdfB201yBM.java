package com.app.exterms.yearendtax.client.dto.yeta2021;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2020.12.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfB201yBM extends MSFSimpleBaseModel implements IsSerializable {
	private static final long serialVersionUID = 1L;

	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 귀속년도 : yrtxBlggYr */
	public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

	/** set 연말정산구분코드 : clutSeptCd */
	public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

	/** set SYSTEMKEY : 사원번호 */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 실손의료보험금내역일련번호 : manSeilNum */
	public static final String ATTR_MANSEILNUM = "manSeilNum";

	/** set 서식코드 : formCd */
	public static final String ATTR_FORMCD = "formCd";

	/** set 자료코드 : datCd */
	public static final String ATTR_DATCD = "datCd";

	/** set 수익자 주민등록번호 : resid */
	public static final String ATTR_RESID = "resid";

	/** set 수익자 성명 : name */
	public static final String ATTR_NAME = "name";

	/** set 실손의료보험금 사업자번호 : busnid */
	public static final String ATTR_BUSNID = "busnid";

	/** set 실손의료보험금 상호 : tradeNm */
	public static final String ATTR_TRADENM = "tradeNm";

	/** set 실손의료보험금 증권번호 : accNo */
	public static final String ATTR_ACCNO = "accNo";

	/** set 실손의료보험금 보험종류: goodsNm */
	public static final String ATTR_GOODSNM = "goodsNm";

	/** set 피보험자주민등록번호: insuResid */
	public static final String ATTR_INSURESID = "insuResid";

	/** set 피보험자 성명: insuNm */
	public static final String ATTR_INSUNM = "insuNm";

	/** set 실손의료보험금 납입금액 : manSum */
	public static final String ATTR_MANSUM = "manSum";

	/** set pdf 파일제출여부 : pdfDatAppYn */
	public static final String ATTR_PDFDATAPPYN = "pdfDatAppYn";

	/** set pdf 파일제출일자 : pdfDatAppCmplDt */
	public static final String ATTR_PDFDATAPPCMPLDT = "pdfDatAppCmplDt";

	/** set pdf 파일건수 : pdfDatAppExcCtnt */
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
	
	/** 생성자 */
    public PdfB201yBM() { super(); } 
    
    /** 일괄등록 처리   */
    public PdfB201yBM(
   		 String  dpobCd 
   		, String  yrtxBlggYr 
   		, String  clutSeptCd 
   		, String  systemkey 
   		, Long manSeilNum 
   		, String  formCd
   		, String  datCd
   		, String  resid 
   		, String  name  
   		, String  busnid 
   		, String  tradeNm 
   		, String  accNo
   		, String  goodsNm
   		, String  insuResid
   		, String  insuNm
   		, Long  manSum 
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
    	values.put(ATTR_MANSEILNUM,manSeilNum);
    	values.put(ATTR_FORMCD,formCd);
      	values.put(ATTR_DATCD,datCd);
    	values.put(ATTR_RESID,resid);
    	values.put(ATTR_NAME,name);
    	values.put(ATTR_BUSNID,busnid);
    	values.put(ATTR_TRADENM,tradeNm);
    	values.put(ATTR_ACCNO,accNo);
    	values.put(ATTR_GOODSNM,goodsNm);
    	values.put(ATTR_INSURESID,insuResid);
    	values.put(ATTR_INSUNM,insuNm);
    	values.put(ATTR_MANSUM,manSum);
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

    /** set SYSTEMKEY : 사원번호 */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : 사원번호 */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 실손의료보험금내역일련번호 : manSeilNum */
    public void setManSeilNum(Long  manSeilNum) { set( ATTR_MANSEILNUM ,manSeilNum);}
    /** get 실손의료보험금내역일련번호 : manSeilNum */
    public Long  getManSeilNum() { return (Long )get( ATTR_MANSEILNUM );}

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 자료코드 : datCd */
    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
    /** get 자료코드 : datCd */
    public String  getDatCd() { return (String )get( ATTR_DATCD );}
    
    /** set 수익자 주민등록번호 : resid */
    public void setResid(String  resid) { set( ATTR_RESID ,resid);}
    /** get 수익자 주민등록번호 : resid */
    public String  getResid() { return (String )get( ATTR_RESID );}

    /** set 수익자 성명 : name */
    public void setName(String  name) { set( ATTR_NAME ,name);}
    /** get 수익자 성명 : name */
    public String  getName() { return (String )get( ATTR_NAME );}

    /** set 실손의료보험금 사업자번호 : busnid */
    public void setBusnid(String  busnid) { set( ATTR_BUSNID ,busnid);}
    /** get 실손의료보험금 사업자번호 : busnid */
    public String  getBusnid() { return (String )get( ATTR_BUSNID );}

    /** set 실손의료보험금 상호 : tradeNm */
    public void setTradeNm(String tradeNm) { set( ATTR_TRADENM ,tradeNm);}
    /** get 실손의료보험금 상호 : tradeNm */
    public String  getTradeNm() { return (String )get( ATTR_TRADENM );}
    
    /** set 실손의료보험금 증권번호 : accNo */
    public void setAccNo(String  accNo) { set( ATTR_TRADENM ,accNo);}
    /** get 실손의료보험금 증권번호 : accNo */
    public String  getAccNo() { return (String )get( ATTR_TRADENM );}
    
    /** set 실손의료보험금 보험종류: goodsNm */
    public void setGoodsNm(String  goodsNm) { set( ATTR_TRADENM ,goodsNm);}
    /** get 실손의료보험금 보험종류: goodsNm */
    public String  getGoodsNm() { return (String )get( ATTR_TRADENM );}
    
    /** set 피보험자주민등록번호: insuResid */
    public void setInsuResid(String  insuResid) { set( ATTR_TRADENM ,insuResid);}
    /** get 피보험자주민등록번호: insuResid */
    public String  getInsuResid() { return (String )get( ATTR_TRADENM );}
    
    /** set 피보험자 성명: insuNm */
    public void setInsuNm(String  insuNm) { set( ATTR_TRADENM ,insuNm);}
    /** get 피보험자 성명: insuNm */
    public String  getInsuNm() { return (String )get( ATTR_TRADENM );}

    /** set 실손의료보험금 납입금액 : manSum */
    public void setManSum(Long  manSum) { set( ATTR_MANSUM ,manSum);}
    /** get 실손의료보험금 납입금액 : manSum */
    public Long  getManSum() { return (Long )get( ATTR_MANSUM );}

    /** set pdf 파일제출여부 : pdfDatAppYn */
    public void setPdfDatAppYn(String  pdfDatAppYn) { set( ATTR_PDFDATAPPYN ,pdfDatAppYn);}
    /** get pdf 파일제출여부 : pdfDatAppYn */
    public String  getPdfDatAppYn() { return (String )get( ATTR_PDFDATAPPYN );}
    
    /** set pdf 파일제출일자 : pdfDatAppCmplDt */
    public void setPdfDatAppCmplDt(String  pdfDatAppCmplDt) { set( ATTR_PDFDATAPPCMPLDT ,pdfDatAppCmplDt);}
    /** get pdf 파일제출일자 : pdfDatAppCmplDt */
    public String  getPdfDatAppCmplDt() { return (String )get( ATTR_PDFDATAPPCMPLDT );}
    
    /** set pdf 파일건수 : pdfDatAppExcCtnt */
    public void setPdfDatAppExcCtnt(String  pdfDatAppExcCtnt) { set( ATTR_PDFDATAPPEXCCTNT ,pdfDatAppExcCtnt);}
    /** get pdf 파일건수 : pdfDatAppExcCtnt */
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
