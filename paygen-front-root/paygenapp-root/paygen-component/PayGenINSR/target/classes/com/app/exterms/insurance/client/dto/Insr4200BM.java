package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr4200VO.java
 * @Description : Insr4200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4200BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 공제년월 : dducYrMnth */
	public static final String ATTR_DDUCYRMNTH = "dducYrMnth";

//	/** set 국민연금일련번호 : natPennSeilNum */
//	public static final String ATTR_NATPENNSEILNUM = "natPennSeilNum";

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";
	
	/** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";


	/** set 신고소득총액 : regrstIncmTotAmnt */
	public static final String ATTR_REGRSTINCMTOTAMNT = "regrstIncmTotAmnt";

	/** set 결정기준소득월액 : deinStdIncmMnthAmnt */
	public static final String ATTR_DEINSTDINCMMNTHAMNT = "deinStdIncmMnthAmnt";

	/** set 결정월보험료 : deinMnthPrmm */
	public static final String ATTR_DEINMNTHPRMM = "deinMnthPrmm";

	/** set 본인부담액 : indvBrdnSum */
	public static final String ATTR_INDVBRDNSUM = "indvBrdnSum";

	/** set 본인소급보험료 : reattyQnty */
	public static final String ATTR_REATTYQNTY = "reattyQnty";

	/** set 본인정산보험료 : hmlfClutPrmm */
	public static final String ATTR_HMLFCLUTPRMM = "hmlfClutPrmm";

	/** set 본인보험료계 : hmlfPrmmAggr */
	public static final String ATTR_HMLFPRMMAGGR = "hmlfPrmmAggr";

	/** set 사업장부담액 : dpobBrdnSum */
	public static final String ATTR_DPOBBRDNSUM = "dpobBrdnSum";

	/** set 사업자정산보험료 : busoprClutPrmm */
	public static final String ATTR_BUSOPRCLUTPRMM = "busoprClutPrmm";

	/** set 사업자소급보험료 : busoprReattyPrmm */
	public static final String ATTR_BUSOPRREATTYPRMM = "busoprReattyPrmm";

	/** set 사업자보험료계 : busoprPrmmAggr */
	public static final String ATTR_BUSOPRPRMMAGGR = "busoprPrmmAggr";

	/** set 본인납부보험료계 : aggr */
	public static final String ATTR_AGGR = "aggr";

	/** set 변동구분 : fluc */
	public static final String ATTR_FLUC = "fluc";

	/** set 취득월납부여부 : aqtnMnthPymtYn */
	public static final String ATTR_AQTNMNTHPYMTYN = "aqtnMnthPymtYn";

	/** set 변동일자 : flucDt */
	public static final String ATTR_FLUCDT = "flucDt";

	/** set 변동사유내용 : flucReasCtnt */
	public static final String ATTR_FLUCREASCTNT = "flucReasCtnt";

	/** set 공단직권결정여부 : pbcorpOautyDeinYn */
	public static final String ATTR_PBCORPOAUTYDEINYN = "pbcorpOautyDeinYn";

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
	
	/** set 산출액 : calNatPrmm */
	public static final String CAL_NAT_PRMM  = "calNatPrmm";
	
	
	/** set 국민연금급여공제년월 : natPayrDducYrMnth */
	public static final String ATTR_NATPAYRDDUCYRMNTH = "natPayrDducYrMnth";
	
	/** set 국민연금처리일자 : natInsrPrcsDt */
	public static final String ATTR_NATINSRPRCSDT = "natInsrPrcsDt";
	
	/** set 국민연금처리여부 : natInsrPrcsYn */
	public static final String ATTR_NATINSRPRCSYN = "natInsrPrcsYn";
	
	/** set 국민연금차액 : natInsrPrmmSrd */
	public static final String ATTR_NATINSRPRMMSRD = "natInsrPrmmSrd";
	
	/** set 분할납부구분코드 : divdPymtDivCd */
	public static final String ATTR_DIVDPYMTDIVCD = "divdPymtDivCd";
	
	/** set 분할납부회수 : divdPymt */
	public static final String ATTR_DIVDPYMT = "divdPymt";
	
	/** set 국민연금기호번호 : natPennSymNum */
	public static final String ATTR_NATPENNSYMNUM = "natPennSymNum";

	/** set 연금급여산출보험금액 : natPennPayCalcSum */
	public static final String ATTR_NATPENNPAYCALCSUM = "natPennPayCalcSum";

	/** 생성자 */
	 public Insr4200BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr4200BM(
			 String  dpobCd 
			, String  systemkey 
			, String  dducYrMnth 
			, Long  emymtSeilNum 
			, String  hanNm 
			, String  resnRegnNum 
			, Long  regrstIncmTotAmnt 
			, Long  deinStdIncmMnthAmnt 
			, Long  deinMnthPrmm 
			, Long  indvBrdnSum 
			, Long  reattyQnty 
			, Long  hmlfClutPrmm 
			, Long  hmlfPrmmAggr 
			, Long  dpobBrdnSum 
			, Long  busoprClutPrmm 
			, Long  busoprReattyPrmm 
			, Long  busoprPrmmAggr 
			, Long  aggr 
			, String  fluc 
			, String  aqtnMnthPymtYn 
			, String  flucDt 
			, String  flucReasCtnt 
			, String  pbcorpOautyDeinYn 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr
			, Long  calNatPrmm 
			, String  natPennSymNum 
			, Long  natPennPayCalcSum 
			 ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_DDUCYRMNTH,dducYrMnth);
	 //	values.put(ATTR_NATPENNSEILNUM,natPennSeilNum);
	 	values.put(ATTR_HANNM,hanNm);
	 	values.put(ATTR_RESNREGNNUM,resnRegnNum);
	 	values.put(ATTR_REGRSTINCMTOTAMNT,regrstIncmTotAmnt);
	 	values.put(ATTR_DEINSTDINCMMNTHAMNT,deinStdIncmMnthAmnt);
	 	values.put(ATTR_DEINMNTHPRMM,deinMnthPrmm);
	 	values.put(ATTR_INDVBRDNSUM,indvBrdnSum);
	 	values.put(ATTR_REATTYQNTY,reattyQnty);
	 	values.put(ATTR_HMLFCLUTPRMM,hmlfClutPrmm);
	 	values.put(ATTR_HMLFPRMMAGGR,hmlfPrmmAggr);
	 	values.put(ATTR_DPOBBRDNSUM,dpobBrdnSum);
	 	values.put(ATTR_BUSOPRCLUTPRMM,busoprClutPrmm);
	 	values.put(ATTR_BUSOPRREATTYPRMM,busoprReattyPrmm);
	 	values.put(ATTR_BUSOPRPRMMAGGR,busoprPrmmAggr);
	 	values.put(ATTR_AGGR,aggr);
	 	values.put(ATTR_FLUC,fluc);
	 	values.put(ATTR_AQTNMNTHPYMTYN,aqtnMnthPymtYn);
	 	values.put(ATTR_FLUCDT,flucDt);
	 	values.put(ATTR_FLUCREASCTNT,flucReasCtnt);
	 	values.put(ATTR_PBCORPOAUTYDEINYN,pbcorpOautyDeinYn);
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr);
		values.put(CAL_NAT_PRMM,calNatPrmm);
	 	values.put(ATTR_NATPENNSYMNUM,natPennSymNum);
	 	values.put(ATTR_NATPENNPAYCALCSUM,natPennPayCalcSum);
	 } 

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 공제년월 : dducYrMnth */
	public void setDducYrMnth(String  dducYrMnth) { set( ATTR_DDUCYRMNTH ,dducYrMnth);}
	/** get 공제년월 : dducYrMnth */
	public String  getDducYrMnth() { return (String )get( ATTR_DDUCYRMNTH );}

//	/** set 국민연금일련번호 : natPennSeilNum */
//	public void setNatPennSeilNum(Long  natPennSeilNum) { set( ATTR_NATPENNSEILNUM ,natPennSeilNum);}
//	/** get 국민연금일련번호 : natPennSeilNum */
//	public Long  getNatPennSeilNum() { return (Long )get( ATTR_NATPENNSEILNUM );}


	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}
	
	/** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

	/** set 신고소득총액 : regrstIncmTotAmnt */
	public void setRegrstIncmTotAmnt(Long  regrstIncmTotAmnt) { set( ATTR_REGRSTINCMTOTAMNT ,regrstIncmTotAmnt);}
	/** get 신고소득총액 : regrstIncmTotAmnt */
	public Long  getRegrstIncmTotAmnt() { return (Long )get( ATTR_REGRSTINCMTOTAMNT );}

	/** set 결정기준소득월액 : deinStdIncmMnthAmnt */
	public void setDeinStdIncmMnthAmnt(Long  deinStdIncmMnthAmnt) { set( ATTR_DEINSTDINCMMNTHAMNT ,deinStdIncmMnthAmnt);}
	/** get 결정기준소득월액 : deinStdIncmMnthAmnt */
	public Long  getDeinStdIncmMnthAmnt() { return (Long )get( ATTR_DEINSTDINCMMNTHAMNT );}

	/** set 결정월보험료 : deinMnthPrmm */
	public void setDeinMnthPrmm(Long  deinMnthPrmm) { set( ATTR_DEINMNTHPRMM ,deinMnthPrmm);}
	/** get 결정월보험료 : deinMnthPrmm */
	public Long  getDeinMnthPrmm() { return (Long )get( ATTR_DEINMNTHPRMM );}

	/** set 본인부담액 : indvBrdnSum */
	public void setIndvBrdnSum(Long  indvBrdnSum) { set( ATTR_INDVBRDNSUM ,indvBrdnSum);}
	/** get 본인부담액 : indvBrdnSum */
	public Long  getIndvBrdnSum() { return (Long )get( ATTR_INDVBRDNSUM );}

	/** set 본인소급보험료 : reattyQnty */
	public void setReattyQnty(Long  reattyQnty) { set( ATTR_REATTYQNTY ,reattyQnty);}
	/** get 본인소급보험료 : reattyQnty */
	public Long  getReattyQnty() { return (Long )get( ATTR_REATTYQNTY );}

	/** set 본인정산보험료 : hmlfClutPrmm */
	public void setHmlfClutPrmm(Long  hmlfClutPrmm) { set( ATTR_HMLFCLUTPRMM ,hmlfClutPrmm);}
	/** get 본인정산보험료 : hmlfClutPrmm */
	public Long  getHmlfClutPrmm() { return (Long )get( ATTR_HMLFCLUTPRMM );}

	/** set 본인보험료계 : hmlfPrmmAggr */
	public void setHmlfPrmmAggr(Long  hmlfPrmmAggr) { set( ATTR_HMLFPRMMAGGR ,hmlfPrmmAggr);}
	/** get 본인보험료계 : hmlfPrmmAggr */
	public Long  getHmlfPrmmAggr() { return (Long )get( ATTR_HMLFPRMMAGGR );}

	/** set 사업장부담액 : dpobBrdnSum */
	public void setDpobBrdnSum(Long  dpobBrdnSum) { set( ATTR_DPOBBRDNSUM ,dpobBrdnSum);}
	/** get 사업장부담액 : dpobBrdnSum */
	public Long  getDpobBrdnSum() { return (Long )get( ATTR_DPOBBRDNSUM );}

	/** set 사업자정산보험료 : busoprClutPrmm */
	public void setBusoprClutPrmm(Long  busoprClutPrmm) { set( ATTR_BUSOPRCLUTPRMM ,busoprClutPrmm);}
	/** get 사업자정산보험료 : busoprClutPrmm */
	public Long  getBusoprClutPrmm() { return (Long )get( ATTR_BUSOPRCLUTPRMM );}

	/** set 사업자소급보험료 : busoprReattyPrmm */
	public void setBusoprReattyPrmm(Long  busoprReattyPrmm) { set( ATTR_BUSOPRREATTYPRMM ,busoprReattyPrmm);}
	/** get 사업자소급보험료 : busoprReattyPrmm */
	public Long  getBusoprReattyPrmm() { return (Long )get( ATTR_BUSOPRREATTYPRMM );}

	/** set 사업자보험료계 : busoprPrmmAggr */
	public void setBusoprPrmmAggr(Long  busoprPrmmAggr) { set( ATTR_BUSOPRPRMMAGGR ,busoprPrmmAggr);}
	/** get 사업자보험료계 : busoprPrmmAggr */
	public Long  getBusoprPrmmAggr() { return (Long )get( ATTR_BUSOPRPRMMAGGR );}

	/** set 본인납부보험료계 : aggr */
	public void setAggr(Long  aggr) { set( ATTR_AGGR ,aggr);}
	/** get 본인납부보험료계 : aggr */
	public Long  getAggr() { return (Long )get( ATTR_AGGR );}

	/** set 변동구분 : fluc */
	public void setFluc(String  fluc) { set( ATTR_FLUC ,fluc);}
	/** get 변동구분 : fluc */
	public String  getFluc() { return (String )get( ATTR_FLUC );}

	/** set 취득월납부여부 : aqtnMnthPymtYn */
	public void setAqtnMnthPymtYn(String  aqtnMnthPymtYn) { set( ATTR_AQTNMNTHPYMTYN ,aqtnMnthPymtYn);}
	/** get 취득월납부여부 : aqtnMnthPymtYn */
	public String  getAqtnMnthPymtYn() { return (String )get( ATTR_AQTNMNTHPYMTYN );}

	/** set 변동일자 : flucDt */
	public void setFlucDt(String  flucDt) { set( ATTR_FLUCDT ,flucDt);}
	/** get 변동일자 : flucDt */
	public String  getFlucDt() { return (String )get( ATTR_FLUCDT );}

	/** set 변동사유내용 : flucReasCtnt */
	public void setFlucReasCtnt(String  flucReasCtnt) { set( ATTR_FLUCREASCTNT ,flucReasCtnt);}
	/** get 변동사유내용 : flucReasCtnt */
	public String  getFlucReasCtnt() { return (String )get( ATTR_FLUCREASCTNT );}

	/** set 공단직권결정여부 : pbcorpOautyDeinYn */
	public void setPbcorpOautyDeinYn(String  pbcorpOautyDeinYn) { set( ATTR_PBCORPOAUTYDEINYN ,pbcorpOautyDeinYn);}
	/** get 공단직권결정여부 : pbcorpOautyDeinYn */
	public String  getPbcorpOautyDeinYn() { return (String )get( ATTR_PBCORPOAUTYDEINYN );}

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
	
	
	/** set 국민연금급여공제년월 : natPayrDducYrMnth */
	public void setNatPayrDducYrMnth(String  natPayrDducYrMnth) { set( ATTR_NATPAYRDDUCYRMNTH ,natPayrDducYrMnth);}
	/** get 국민연금급여공제년월 : natPayrDducYrMnth */
	public String  getNatPayrDducYrMnth() { return (String )get( ATTR_NATPAYRDDUCYRMNTH );}

	/** set 국민연금처리일자 : natInsrPrcsDt */
	public void setNatInsrPrcsDt(String  natInsrPrcsDt) { set( ATTR_NATINSRPRCSDT ,natInsrPrcsDt);}
	/** get 국민연금처리일자 : natInsrPrcsDt */
	public String  getNatInsrPrcsDt() { return (String )get( ATTR_NATINSRPRCSDT );}

	/** set 국민연금처리여부 : natInsrPrcsYn */
	public void setNatInsrPrcsYn(String  natInsrPrcsYn) { set( ATTR_NATINSRPRCSYN ,natInsrPrcsYn);}
	/** get 국민연금처리여부 : natInsrPrcsYn */
	public String  getNatInsrPrcsYn() { return (String )get( ATTR_NATINSRPRCSYN );}

	/** set 국민연금차액 : natInsrPrmmSrd */
	public void setNatInsrPrmmSrd(String  natInsrPrmmSrd) { set( ATTR_NATINSRPRMMSRD ,natInsrPrmmSrd);}
	/** get 국민연금차액 : natInsrPrmmSrd */
	public String  getNatInsrPrmmSrd() { return (String )get( ATTR_NATINSRPRMMSRD );}

	/** set 분할납부구분코드 : divdPymtDivCd */
	public void setDivdPymtDivCd(String  divdPymtDivCd) { set( ATTR_DIVDPYMTDIVCD ,divdPymtDivCd);}
	/** get 분할납부구분코드 : divdPymtDivCd */
	public String  getDivdPymtDivCd() { return (String )get( ATTR_DIVDPYMTDIVCD );}

	/** set 분할납부회수 : divdPymt */
	public void setDivdPymt(String  divdPymt) { set( ATTR_DIVDPYMT ,divdPymt);}
	/** get 분할납부회수 : divdPymt */
	public String  getDivdPymt() { return (String )get( ATTR_DIVDPYMT );}
    
	/** set 산출액 : dpobBrdnSum */
	public void setCalNatPrmm(Long  calNatPrmm) { set( CAL_NAT_PRMM ,calNatPrmm);}
	/** get 산출액 : dpobBrdnSum */
	public Long  getCalNatPrmm() { return (Long )get( CAL_NAT_PRMM );}


    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
    /** set 국민연금기호번호 : natPennSymNum */
    public void setNatPennSymNum(String  natPennSymNum) { set( ATTR_NATPENNSYMNUM ,natPennSymNum);}
    /** get 국민연금기호번호 : natPennSymNum */
    public String  getNatPennSymNum() { return (String )get( ATTR_NATPENNSYMNUM );}
  
    /** set 연금급여산출보험금액 : natPennPayCalcSum */
    public void setNatPennPayCalcSum(Long  natPennPayCalcSum) { set( ATTR_NATPENNPAYCALCSUM ,natPennPayCalcSum);}
    /** get 연금급여산출보험금액 : natPennPayCalcSum */
    public Long  getNatPennPayCalcSum() { return (Long )get( ATTR_NATPENNPAYCALCSUM );}
    /** column 사업장코드 : dpobCd */
    
    
}
