package com.app.exterms.personal.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0320BMRight2.java
 * @Description : Psnl0320BMRight2 class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0320BMRight3    extends MSFSimpleBaseModel implements IsSerializable   {

	private static final long serialVersionUID = 1L;

	public static final String	ATTR_DPOB_CD = "dpobCd"; /*사업장코드*/
	public static final String	ATTR_SYSTEMKEY = "systemkey"; /*SYSTEMKEY*/
	public static final String	ATTR_DSNY_ACT_SEIL_NUM = "dsnyActSeilNum"; /*징계일련번호*/
	public static final String	ATTR_DSNY_ACT_DSPL_DT = "dsnyActDsplDt"; /*징계처분일자*/
	public static final String	ATTR_DSNY_ACT_DIV_CD = "dsnyActDivCd"; /*징계구분코드*/
	
	public static final String	ATTR_DSNY_ACT_DIV_NM = "dsnyActDivNm"; /*징계구분코드*/
	
	public static final String	ATTR_DSNY_ACT_NM = "dsnyActNm"; /*징계명*/
	public static final String	ATTR_DSNY_ACT_REAS_CTNT = "dsnyActReasCtnt"; /*징계사유내용*/
	public static final String	ATTR_DSNY_ACT_ECTG_ORGN = "dsnyActEctgOrgn"; /*징계수행기관*/
	public static final String	ATTR_DSNY_ACT_NOTE_CTNT = "dsnyActNoteCtnt"; /*징계비고내용*/
	public static final String	ATTR_DSNY_ACT_BGNN_DT = "dsnyActBgnnDt"; /*징계시작일자*/
	public static final String	ATTR_DSNY_ACT_END_DT = "dsnyActEndDt"; /*징계종료일자*/
	public static final String	ATTR_DSNY_ACT_CTWP_RATE = "dsnyActCtwpRate"; /*징계감봉율*/
	public static final String	ATTR_DSNY_ACT_CTWP_MNTH_ICM = "dsnyActCtwpMnthIcm"; /*징계감봉월수*/
	public static final String	ATTR_DSNY_ACT_ANSTY_DT = "dsnyActAnstyDt"; /*징계사면일자*/
	public static final String	ATTR_DSNY_ACT_ANSTY_DIV_CD = "dsnyActAnstyDivCd"; /*징계사면구분코드*/
	public static final String	ATTR_KYBDR = "kybdr"; /*입력자*/
	public static final String	ATTR_INPT_DT = "inptDt"; /*입력일자*/
	public static final String	ATTR_INPT_ADDR = "inptAddr"; /*입력주소*/
	public static final String	ATTR_ISMT = "ismt"; /*수정자*/
	public static final String	ATTR_REVN_DT = "revnDt"; /*수정일자*/
	public static final String	ATTR_REVN_ADDR = "revnAddr"; /*수정주소*/



	/** 생성자 */
	 public Psnl0320BMRight3() { super(); }


		/** 일괄등록 처리   */
		public Psnl0320BMRight3(
			String dpobCd
			,String systemkey
			,String dsnyActSeilNum
			,String dsnyActDsplDt
			,String dsnyActDivCd
			,String dsnyActDivNm
			,String dsnyActNm
			,String dsnyActReasCtnt
			,String dsnyActEctgOrgn
			,String dsnyActNoteCtnt
			,String dsnyActBgnnDt
			,String dsnyActEndDt
			,String dsnyActCtwpRate
			,String dsnyActCtwpMnthIcm
			,String dsnyActAnstyDt
			,String dsnyActAnstyDivCd
			,String kybdr
			,String inptDt
			,String inptAddr
			,String ismt
			,String revnDt
			,String revnAddr
		){
			 values.put(ATTR_DPOB_CD	,	dpobCd);
			 values.put(ATTR_SYSTEMKEY	,	systemkey);
			 values.put(ATTR_DSNY_ACT_SEIL_NUM	,	dsnyActSeilNum);
			 values.put(ATTR_DSNY_ACT_DSPL_DT	,	dsnyActDsplDt);
			 values.put(ATTR_DSNY_ACT_DIV_CD	,	dsnyActDivCd);
			 values.put(ATTR_DSNY_ACT_DIV_NM	,	dsnyActDivNm);
			 values.put(ATTR_DSNY_ACT_NM	,	dsnyActNm);
			 values.put(ATTR_DSNY_ACT_REAS_CTNT	,	dsnyActReasCtnt);
			 values.put(ATTR_DSNY_ACT_ECTG_ORGN	,	dsnyActEctgOrgn);
			 values.put(ATTR_DSNY_ACT_NOTE_CTNT	,	dsnyActNoteCtnt);
			 values.put(ATTR_DSNY_ACT_BGNN_DT	,	dsnyActBgnnDt);
			 values.put(ATTR_DSNY_ACT_END_DT	,	dsnyActEndDt);
			 values.put(ATTR_DSNY_ACT_CTWP_RATE	,	dsnyActCtwpRate);
			 values.put(ATTR_DSNY_ACT_CTWP_MNTH_ICM	,	dsnyActCtwpMnthIcm);
			 values.put(ATTR_DSNY_ACT_ANSTY_DT	,	dsnyActAnstyDt);
			 values.put(ATTR_DSNY_ACT_ANSTY_DIV_CD	,	dsnyActAnstyDivCd);
			 values.put(ATTR_KYBDR	,	kybdr);
			 values.put(ATTR_INPT_DT	,	inptDt);
			 values.put(ATTR_INPT_ADDR	,	inptAddr);
			 values.put(ATTR_ISMT	,	ismt);
			 values.put(ATTR_REVN_DT	,	revnDt);
			 values.put(ATTR_REVN_ADDR	,	revnAddr);
		}


	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOB_CD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String getDpobCd() { return (String )get( ATTR_DPOB_CD );}


	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	
	/** set 징계일련번호 : dsnyActSeilNum */
	public void setDsnyActSeilNum(String  dsnyActSeilNum) { set( ATTR_DSNY_ACT_SEIL_NUM ,dsnyActSeilNum);}
	/** get 징계일련번호 : dsnyActSeilNum */
	public String getDsnyActSeilNum() { return (String )get( ATTR_DSNY_ACT_SEIL_NUM );}


	/** set 징계처분일자 : dsnyActDsplDt */
	public void setDsnyActDsplDt(String  dsnyActDsplDt) { set( ATTR_DSNY_ACT_SEIL_NUM ,dsnyActDsplDt);}
	/** get 징계처분일자 : dsnyActDsplDt */
	public String getDsnyActDsplDt() { return (String )get( ATTR_DSNY_ACT_SEIL_NUM );}


	/** set 징계구분코드 : dsnyActDivCd */
	public void setDsnyActDivCd(String  dsnyActDivCd) { set( ATTR_DSNY_ACT_DIV_CD ,dsnyActDivCd);}
	/** get 징계구분코드 : dsnyActDivCd */
	public String getDsnyActDivCd() { return (String )get( ATTR_DSNY_ACT_DIV_CD );}

	/** set 징계구분코드 : dsnyActDivCd */
	public void setDsnyActDivNm(String  dsnyActDivNm) { set( ATTR_DSNY_ACT_DIV_NM ,dsnyActDivNm);}
	/** get 징계구분코드 : dsnyActDivCd */
	public String getDsnyActDivNm() { return (String )get( ATTR_DSNY_ACT_DIV_NM );}
	
	
	/** set 징계명 : dsnyActNm */
	public void setDsnyActNm(String  dsnyActNm) { set( ATTR_DSNY_ACT_NM ,dsnyActNm);}
	/** get 징계명 : dsnyActDivCd */
	public String getDsnyActNm() { return (String )get( ATTR_DSNY_ACT_NM );}


	/** set 징계사유내용 : dsnyActReasCtnt */
	public void setDsnyActReasCtnt(String  dsnyActReasCtnt) { set( ATTR_DSNY_ACT_REAS_CTNT ,dsnyActReasCtnt);}
	/** get 징계사유내용 : dsnyActReasCtnt */
	public String getDsnyActReasCtnt() { return (String )get( ATTR_DSNY_ACT_REAS_CTNT );}


	/** set 징계수행기관 : dsnyActEctgOrgn */
	public void setDsnyActEctgOrgn(String  dsnyActEctgOrgn) { set( ATTR_DSNY_ACT_ECTG_ORGN ,dsnyActEctgOrgn);}
	/** get 징계수행기관 : dsnyActEctgOrgn */
	public String getDsnyActEctgOrgn() { return (String )get( ATTR_DSNY_ACT_ECTG_ORGN );}


	/** set 징계비고내용 : dsnyActNoteCtnt */
	public void setDsnyActNoteCtnt(String  dsnyActNoteCtnt) { set( ATTR_DSNY_ACT_NOTE_CTNT ,dsnyActNoteCtnt);}
	/** get 징계비고내용 : dsnyActNoteCtnt */
	public String getDsnyActNoteCtnt() { return (String )get( ATTR_DSNY_ACT_NOTE_CTNT );}


	/** set 징계시작일자 : dsnyActBgnnDt */
	public void setDsnyActBgnnDt(String  dsnyActBgnnDt) { set( ATTR_DSNY_ACT_BGNN_DT ,dsnyActBgnnDt);}
	/** get 징계시작일자 : dsnyActBgnnDt */
	public String getDsnyActBgnnDt() { return (String )get( ATTR_DSNY_ACT_BGNN_DT );}


	/** set 징계종료일자 : dsnyActEndDt */
	public void setDsnyActEndDt(String  dsnyActEndDt) { set( ATTR_DSNY_ACT_END_DT ,dsnyActEndDt);}
	/** get 징계종료일자 : dsnyActEndDt */
	public String setDsnyActEndDt() { return (String )get( ATTR_DSNY_ACT_END_DT );}


	/** set 징계감봉율 : dsnyActCtwpRate */
	public void setDsnyActCtwpRate(String  dsnyActCtwpRate) { set( ATTR_DSNY_ACT_CTWP_RATE ,dsnyActCtwpRate);}
	/** get 징계감봉율 : dsnyActCtwpRate */
	public String getDsnyActCtwpRate() { return (String )get( ATTR_DSNY_ACT_CTWP_RATE );}


	/** set 징계감봉월수 : dsnyActCtwpMnthIcm */
	public void setDsnyActCtwpMnthIcm(String  dsnyActCtwpMnthIcm) { set( ATTR_DSNY_ACT_CTWP_MNTH_ICM ,dsnyActCtwpMnthIcm);}
	/** get 징계감봉월수 : dsnyActCtwpMnthIcm */
	public String getDsnyActCtwpMnthIcm() { return (String )get( ATTR_DSNY_ACT_CTWP_MNTH_ICM );}


	/** set 징계사면일자 : dsnyActAnstyDt */
	public void setDsnyActAnstyDt(String  dsnyActAnstyDt) { set( ATTR_DSNY_ACT_ANSTY_DT ,dsnyActAnstyDt);}
	/** get 징계사면일자 : dsnyActAnstyDt */
	public String getDsnyActAnstyDt() { return (String )get( ATTR_DSNY_ACT_ANSTY_DT );}


	/** set 징계사면구분코드 : dsnyActAnstyDivCd */
	public void setDsnyActAnstyDivCd(String  dsnyActAnstyDivCd) { set( ATTR_DSNY_ACT_ANSTY_DIV_CD ,dsnyActAnstyDivCd);}
	/** get 징계사면구분코드 : dsnyActAnstyDt */
	public String getDsnyActAnstyDivCd() { return (String )get( ATTR_DSNY_ACT_ANSTY_DIV_CD );}


	/** set 입력자 : kybdr */
	public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
	/** get 입력자 : kybdr */
	public String getKybdr() { return (String )get( ATTR_KYBDR );}


	/** set 입력일자 : inptDt */
	public void setInptDt(String  inptDt) { set( ATTR_INPT_DT ,inptDt);}
	/** get 입력일자 : inptDt */
	public String getInptDt() { return (String )get( ATTR_INPT_DT );}


	/** set 입력주소 : inptAddr */
	public void setInptAddr(String  inptAddr) { set( ATTR_INPT_ADDR ,inptAddr);}
	/** get 입력주소 : inptDt */
	public String getInptAddr() { return (String )get( ATTR_INPT_ADDR );}


	/** set 수정자 : ismt */
	public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
	/** get 수정자 : inptDt */
	public String getIsmt() { return (String )get( ATTR_ISMT );}


	/** set 수정일자 : revnDt */
	public void setRevnDt(String  revnDt) { set( ATTR_ISMT ,revnDt);}
	/** get 수정일자 : revnDt */
	public String getRevnDt() { return (String )get( ATTR_ISMT );}


	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String  revnAddr) { set( ATTR_REVN_ADDR ,revnAddr);}
	/** get 수정주소 : revnAddr */
	public String getRevnAddr() { return (String )get( ATTR_REVN_ADDR );}
}
