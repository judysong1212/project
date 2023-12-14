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
public class Psnl0320BMRight2    extends MSFSimpleBaseModel implements IsSerializable   {

	private static final long serialVersionUID = 1L;


	public static final String	ATTR_DPOB_CD	=	"dpobCd";/* set 사업장코드 : dpobCd */
	/* set SYSTEMKEY : systemkey */
	public static final String	ATTR_SYSTEMKEY	=	"systemkey";
	/* set 경력사항일련번호 : carrRsptSeilNum */
	public static final String	ATTR_CARR_RSPT_SEIL_NUM	=	"carrRsptSeilNum";
	/* set 경력시작일자 : carrBgnnDt */
	public static final String	ATTR_CARR_BGNN_DT	=	"carrBgnnDt";
	/* set 경력종료일자 : carrEndDt */
	public static final String	ATTR_CARR_END_DT	=	"carrEndDt";
	/* set 근무처명 : paeWorkNm */
	public static final String	ATTR_PAE_WORK_NM	=	"paeWorkNm";
	/* set 경력구분코드 : carrDivCd */
	public static final String	ATTR_CARR_DIV_CD	=	"carrDivCd";
	public static final String	ATTR_CARR_DIV_NM	=	"carrDivNm";
	/* set 근무부서명 : dutyDeptNm */
	public static final String	ATTR_DUTY_DEPT_NM	=	"dutyDeptNm";
	/* set 담당업무명 : repbtyBusinNm */
	public static final String	ATTR_REPBTY_BUSIN_NM	=	"repbtyBusinNm";
	/* set 직책명 : odtyNm */
	public static final String	ATTR_ODTY_NM	=	"odtyNm";
	/* set 임금일당금액 : amntDlywagSum */
	public static final String	ATTR_AMNT_DLYWAG_SUM	=	"amntDlywagSum";
	/* set 경력비고내용 : carrNoteCtnt */
	public static final String	ATTR_CARR_NOTE_CTNT	=	"carrNoteCtnt";
	/* set 근무년수 : dutyYrNum */
	public static final String	ATTR_DUTY_YR_NUM	=	"dutyYrNum";
	/* set 근무월수 : dutyMnthIcm */
	public static final String	ATTR_DUTY_MNTH_ICM	=	"dutyMnthIcm";
	/* set 환산비율 : cvsnRtoDivCd */
	public static final String	ATTR_CVSN_RTO_DIV_CD	=	"cvsnRtoDivCd";
	/* set 가감월수 : ajmtMnthNum */
	public static final String	ATTR_AJMT_MNTH_NUM	=	"ajmtMnthNum";
	/* set 인정월수 : rcgtnMnthNum */
	public static final String	ATTR_RCGTN_MNTH_NUM	=	"rcgtnMnthNum";
	/* set 입력자 : kybdr */
	public static final String	ATTR_KYBDR	=	"kybdr";
	/* set 입력일자 : inptDt */
	public static final String	ATTR_INPT_DT	=	"inptDt";
	/* set 입력주소 : inptAddr */
	public static final String	ATTR_INPT_ADDR	=	"inptAddr";
	/* set 수정자 : ismt */
	public static final String	ATTR_ISMT	=	"ismt";
	/* set 수정일자 : revnDt */
	public static final String	ATTR_REVN_DT	=	"revnDt";
	/* set 수정주소 : revnAddr */
	public static final String	ATTR_REVN_ADDR	=	"revnAddr";
	/* set 근속일수 : dutyDayNum */
	public static final String	ATTR_DUTY_DAY_NUM	=	"dutyDayNum";
	/* set 근속전체일수 : dutyTotDayNum */
	public static final String	ATTR_DUTY_TOT_DAY_NUM	=	"dutyTotDayNum";


	/** 생성자 */
	public Psnl0320BMRight2() { super(); }


	/** 일괄등록 처리   */
	public Psnl0320BMRight2(
		String dpobCd		
		,String systemkey		
		,String carrRsptSeilNum		
		,String carrBgnnDt		
		,String carrEndDt		
		,String paeWorkNm		
		,String carrDivCd	
		,String carrDivNm
		,String dutyDeptNm		
		,String repbtyBusinNm		
		,String odtyNm		
		,String amntDlywagSum		
		,String carrNoteCtnt		
		,String dutyYrNum		
		,String dutyMnthIcm		
		,String cvsnRtoDivCd		
		,String ajmtMnthNum		
		,String rcgtnMnthNum		
		,String kybdr		
		,String inptDt		
		,String inptAddr		
		,String ismt		
		,String revnDt		
		,String revnAddr		
		,String dutyDayNum		
		,String dutyTotDayNum		
	){
		 values.put(ATTR_DPOB_CD	,	dpobCd);
		 values.put(ATTR_SYSTEMKEY	,	systemkey);
		 values.put(ATTR_CARR_RSPT_SEIL_NUM	,	carrRsptSeilNum);
		 values.put(ATTR_CARR_BGNN_DT	,	carrBgnnDt);
		 values.put(ATTR_CARR_END_DT	,	carrEndDt);
		 values.put(ATTR_PAE_WORK_NM	,	paeWorkNm);
		 values.put(ATTR_CARR_DIV_CD	,	carrDivCd);
		 values.put(ATTR_CARR_DIV_NM	,	carrDivNm);
		 values.put(ATTR_DUTY_DEPT_NM	,	dutyDeptNm);
		 values.put(ATTR_REPBTY_BUSIN_NM	,	repbtyBusinNm);
		 values.put(ATTR_ODTY_NM	,	odtyNm);
		 values.put(ATTR_AMNT_DLYWAG_SUM	,	amntDlywagSum);
		 values.put(ATTR_CARR_NOTE_CTNT	,	carrNoteCtnt);
		 values.put(ATTR_DUTY_YR_NUM	,	dutyYrNum);
		 values.put(ATTR_DUTY_MNTH_ICM	,	dutyMnthIcm);
		 values.put(ATTR_CVSN_RTO_DIV_CD	,	cvsnRtoDivCd);
		 values.put(ATTR_AJMT_MNTH_NUM	,	ajmtMnthNum);
		 values.put(ATTR_RCGTN_MNTH_NUM	,	rcgtnMnthNum);
		 values.put(ATTR_KYBDR	,	kybdr);
		 values.put(ATTR_INPT_DT	,	inptDt);
		 values.put(ATTR_INPT_ADDR	,	inptAddr);
		 values.put(ATTR_ISMT	,	ismt);
		 values.put(ATTR_REVN_DT	,	revnDt);
		 values.put(ATTR_REVN_ADDR	,	revnAddr);
		 values.put(ATTR_DUTY_DAY_NUM	,	dutyDayNum);
		 values.put(ATTR_DUTY_TOT_DAY_NUM	,	dutyTotDayNum);
	}


	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOB_CD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String getDpobCd() { return (String )get( ATTR_DPOB_CD );}


	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_DPOB_CD ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String getSystemkey() { return (String )get( ATTR_DPOB_CD );}


	/** set 경력사항일련번호 : carrRsptSeilNum */
	public void setCarrRsptSeilNum(String  carrRsptSeilNum) { set( ATTR_CARR_RSPT_SEIL_NUM ,carrRsptSeilNum);}
	/** get 경력사항일련번호 : carrRsptSeilNum */
	public String getCarrRsptSeilNum() { return (String )get( ATTR_CARR_RSPT_SEIL_NUM );}


	/** set 경력시작일자 : carrBgnnDt */
	public void setCarrBgnnDt(String  carrBgnnDt) { set( ATTR_CARR_BGNN_DT ,carrBgnnDt);}
	/** get 경력시작일자 : carrBgnnDt */
	public String getCarrBgnnDt() { return (String )get( ATTR_CARR_BGNN_DT );}


	/** set 경력종료일자 : carrEndDt */
	public void setCarrEndDt(String  carrEndDt) { set( ATTR_CARR_END_DT ,carrEndDt);}
	/** get 경력종료일자 : carrEndDt */
	public String getCarrEndDt() { return (String )get( ATTR_CARR_END_DT );}


	/** set 근무처명 : paeWorkNm */
	public void setPaeWorkNm(String  paeWorkNm) { set( ATTR_PAE_WORK_NM ,paeWorkNm);}
	/** get 근무처명 : paeWorkNm */
	public String getPaeWorkNm() { return (String )get( ATTR_PAE_WORK_NM );}


	/** set 경력구분코드 : carrDivCd */
	public void setCarrDivCd(String  carrDivCd) { set( ATTR_CARR_DIV_CD ,carrDivCd);}
	/** get 경력구분코드 : carrDivCd */
	public String getCarrDivCd() { return (String )get( ATTR_CARR_DIV_CD );}
	
	public void setCarrDivNm(String  carrDivNm) { set( ATTR_CARR_DIV_NM ,carrDivNm);}
	/** get 경력구분코드 : carrDivCd */
	public String getCarrDivNm() { return (String )get( ATTR_CARR_DIV_NM );}


	/** set 근무부서명 : dutyDeptNm */
	public void setDutyDeptNm(String  dutyDeptNm) { set( ATTR_DUTY_DEPT_NM ,dutyDeptNm);}
	/** get 근무부서명 : dutyDeptNm */
	public String getDutyDeptNm() { return (String )get( ATTR_DUTY_DEPT_NM );}


	/** set 담당업무명 : repbtyBusinNm */
	public void setRepbtyBusinNm(String  repbtyBusinNm) { set( ATTR_REPBTY_BUSIN_NM ,repbtyBusinNm);}
	/** get 담당업무명 : repbtyBusinNm */
	public String getRepbtyBusinNm() { return (String )get( ATTR_REPBTY_BUSIN_NM );}


	/** set 직책명 : odtyNm */
	public void setOdtyNm(String  odtyNm) { set( ATTR_ODTY_NM ,odtyNm);}
	/** get 직책명 : repbtyBusinNm */
	public String getOdtyNm() { return (String )get( ATTR_ODTY_NM );}


	/** set 임금일당금액 : amntDlywagSum */
	public void setAmntDlywagSum(String  amntDlywagSum) { set( ATTR_AMNT_DLYWAG_SUM ,amntDlywagSum);}
	/** get 임금일당금액 : amntDlywagSum */
	public String getAmntDlywagSum() { return (String )get( ATTR_AMNT_DLYWAG_SUM );}


	/** set 경력비고내용 : carrNoteCtnt */
	public void setCarrNoteCtnt(String  carrNoteCtnt) { set( ATTR_CARR_NOTE_CTNT ,carrNoteCtnt);}
	/** get 경력비고내용 : carrNoteCtnt */
	public String getCarrNoteCtnt() { return (String )get( ATTR_CARR_NOTE_CTNT );}


	/** set 근무년수 : dutyYrNum */
	public void setDutyYrNum(String  dutyYrNum) { set( ATTR_DUTY_YR_NUM ,dutyYrNum);}
	/** get 근무년수 : carrNoteCtnt */
	public String getDutyYrNum() { return (String )get( ATTR_DUTY_YR_NUM );}


	/** set 근무월수 : dutyMnthIcm */
	public void setDutyMnthIcm(String  dutyMnthIcm) { set( ATTR_DUTY_MNTH_ICM ,dutyMnthIcm);}
	/** get 근무월수 : carrNoteCtnt */
	public String getDutyMnthIcm() { return (String )get( ATTR_DUTY_MNTH_ICM );}


	/** set 환산비율 : cvsnRtoDivCd */
	public void setCvsnRtoDivCd(String  cvsnRtoDivCd) { set( ATTR_CVSN_RTO_DIV_CD ,cvsnRtoDivCd);}
	/** get 환산비율 : cvsnRtoDivCd */
	public String getCvsnRtoDivCd() { return (String )get( ATTR_CVSN_RTO_DIV_CD );}


	/** set 가감월수 : ajmtMnthNum */
	public void setAjmtMnthNum(String  ajmtMnthNum) { set( ATTR_AJMT_MNTH_NUM ,ajmtMnthNum);}
	/** get 가감월수 : cvsnRtoDivCd */
	public String getAjmtMnthNum() { return (String )get( ATTR_AJMT_MNTH_NUM );}


	/** set 인정월수 : rcgtnMnthNum */
	public void setRcgtnMnthNum(String  rcgtnMnthNum) { set( ATTR_RCGTN_MNTH_NUM ,rcgtnMnthNum);}
	/** get 인정월수 : rcgtnMnthNum */
	public String getRcgtnMnthNum() { return (String )get( ATTR_RCGTN_MNTH_NUM );}


	/** set 입력자 : kybdr */
	public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
	/** get 입력자 : kybdr */
	public String getKybdr() { return (String )get( ATTR_KYBDR );}


	/** set 입력일자 : inptDt */
	public void setInptDt(String  inptDt) { set( ATTR_INPT_DT ,inptDt);}
	/** get 입력일자 : kybdr */
	public String getInptDt() { return (String )get( ATTR_INPT_DT );}


	/** set 입력주소 : inptAddr */
	public void setInptAddr(String  inptAddr) { set( ATTR_INPT_ADDR ,inptAddr);}
	/** get 입력주소 : inptAddr */
	public String getInptAddr() { return (String )get( ATTR_INPT_ADDR );}


	/** set 수정자 : ismt */
	public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
	/** get 수정자 : ismt */
	public String getIsmt() { return (String )get( ATTR_ISMT );}


	/** set 수정일자 : revnDt */
	public void setRevnDt(String  revnDt) { set( ATTR_REVN_DT ,revnDt);}
	/** get 수정일자 : revnDt */
	public String getRevnDt() { return (String )get( ATTR_REVN_DT );}


	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String  revnAddr) { set( ATTR_REVN_ADDR ,revnAddr);}
	/** get 수정주소 : revnDt */
	public String getRevnAddr() { return (String )get( ATTR_REVN_ADDR );}


	/** set 근속일수 : dutyDayNum */
	public void setDutyDayNum(String  dutyDayNum) { set( ATTR_DUTY_DAY_NUM ,dutyDayNum);}
	/** get 근속일수 : dutyDayNum */
	public String getDutyDayNum() { return (String )get( ATTR_DUTY_DAY_NUM );}


	/** set 근속전체일수 : dutyTotDayNum */
	public void setDutyTotDayNum(String  dutyTotDayNum) { set( ATTR_DUTY_TOT_DAY_NUM ,dutyTotDayNum);}
	/** get 근속전체일수 : dutyTotDayNum */
	public String getDutyTotDayNum() { return (String )get( ATTR_DUTY_TOT_DAY_NUM );}
}
