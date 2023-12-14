package com.app.exterms.personal.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0320BMLeft.java
 * @Description : Psnl0320BMLeft class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0320BMRight1    extends MSFSimpleBaseModel implements IsSerializable   {

	private static final long serialVersionUID = 1L;



	public static final String ATTR_DPOB_CD = "dpobCd";/* set 사업장코드 : dpobCd */
	public static final String ATTR_SYSTEMKEY = "systemkey";/* set SYSTEMKEY : systemkey */
	public static final String ATTR_EMYMT_SEIL_NUM = "emymtSeilNum";/* set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMT_DIV_CD = "emymtDivCd";/* set 고용구분코드 : emymtDivCd */
	public static final String ATTR_EMYMT_DIV_NM = "emymtDivNm";/* set 고용구분명: emymtDivNm */
	public static final String ATTR_EMYMT_TYP_CD = "emymtTypCd";/* set 고용유형코드: emymtTypCd */
	public static final String ATTR_EMYMT_TYP_NM = "emymtTypNm";/* set 고용유형명: emymtTypNm */
	public static final String ATTR_EMYMT_BGNN_DT = "emymtBgnnDt";/* set 고용시작일자(입사일자) : emymtBgnnDt */
	public static final String ATTR_EMYMT_END_DT = "emymtEndDt";/* set 고용종료일자 : emymtEndDt */
	public static final String ATTR_DEPT_CD = "deptCd";/* set 부서코드 : deptCd */
	public static final String ATTR_DEPT_NM = "deptNm";/* set 부서명 : deptNm */
	public static final String ATTR_CURR_PAE_WORK_NM = "currPaeWorkNm";/* set 현근무지명 : currPaeWorkNm */
	public static final String ATTR_BUSIN_CD = "businCd";/* set 사업코드 : businCd */
	public static final String ATTR_TYP_OCCU_CD = "typOccuCd";/* set 직종코드 : typOccuCd */
	public static final String ATTR_TYP_OCCU_NM = "typOccuNm";/* set 직종명 : typOccuNm */
	public static final String ATTR_DTIL_OCCU_CLS_DIV_CD = "dtilOccuClsDivCd";/* set 직종세구분코드 : dtilOccuClsDivCd */
	public static final String ATTR_DTIL_OCCU_CLS_DIV_NM = "dtilOccuClsDivNm";/* set 직종세명 : dtilOccuClsDivNm */
	public static final String ATTR_ODTY_CD = "odtyCd";/* set 직책코드 : odtyCd */
	public static final String ATTR_PAY_PYMT_DIV_CD = "payPymtDivCd";/* set 급여지급구분코드 : payPymtDivCd */
	public static final String ATTR_EMYMT_SUM = "emymtSum";/* set 고용금액 : emymtSum */
	public static final String ATTR_EMYMT_REAS_CTNT ="emymtReasCtnt";/*고용사유내용*/
	public static final String ATTR_CERT_NUM_HUHD ="certNumHuhd";/*증번호*/
	public static final String ATTR_RDUC_BGNN_DT ="rducBgnnDt";/*경감시작일자*/
	public static final String ATTR_KYBDR = "kybdr"; /*입력자*/
	public static final String ATTR_INPT_DT = "inptDt"; /*입력일자*/
	public static final String ATTR_INPT_ADDR = "inptAddr"; /*입력주소*/
	public static final String ATTR_ISMT = "ismt"; /*수정자*/
	public static final String ATTR_REVN_DT = "revnDt"; /*수정일자*/
	public static final String ATTR_REVN_ADDR = "revnAddr"; /*수정주소*/
	public static final String ATTR_RDUC_END_DT = "rducEndDt"; /*경감종료일자*/
	public static final String ATTR_PYSP_GRDE_CD = "pyspGrdeCd"; /*호봉등급코드*/
	public static final String ATTR_DTIL_OCCU_INTTN_CD ="dtilOccuInttnCd"; /**/
	public static final String ATTR_CVSN_RTO_DIV_CD ="cvsnRtoDivCd"; /*환산비율구분코드*/
	public static final String ATTR_CVSN_RTO_DIV_CDCOMM_CD_NM = "cvsnRtoDivCdcommCdNm";
	public static final String ATTR_DUTY_YR_NUM = "dutyYrNum"; /*근무년수*/
	public static final String ATTR_DUTY_MNTH_ICM = "dutyMnthIcm"; /*근무월수*/
	public static final String ATTR_DUTY_DAY_NUM = "dutyDayNum"; /*근무일수*/
	public static final String ATTR_DUTY_TOT_DAY_NUM = "dutyTotDayNum"; /*근속전체일수*/






	/** 생성자 */
	 public Psnl0320BMRight1() { super(); } 

		/** 일괄등록 처리   */
	 public Psnl0320BMRight1(
			String dpobCd
			,String systemkey
			,String emymtSeilNum
			,String emymtDivCd
			,String emymtTypCd
			,String emymtBgnnDt
			,String emymtEndDt
			,String deptCd
			,String deptNm
			,String currPaeWorkNm
			,String businCd
			,String typOccuCd
			,String typOccuNm
			,String dtilOccuClsDivCd
			,String dtilOccuClsDivNm
			,String odtyCd
			,String payPymtDivCd
			,String emymtSum
			,String emymtReasCtnt
			,String certNumHuhd
			,String rducBgnnDt
			,String kybdr
			,String inptDt
			,String inptAddr
			,String ismt
			,String revnDt
			,String revnAddr
			,String rducEndDt
			,String pyspGrdeCd
			,String dtilOccuInttnCd
			,String cvsnRtoDivCd
			,String dutyYrNum
			,String dutyMnthIcm
			,String dutyDayNum
			,String dutyTotDayNum
		) {
		 	values.put(ATTR_DPOB_CD,dpobCd);
		 	values.put(ATTR_SYSTEMKEY,systemkey);
		 	values.put(ATTR_EMYMT_SEIL_NUM,emymtSeilNum);
		 	values.put(ATTR_EMYMT_DIV_CD,emymtDivCd);
		 	values.put(ATTR_EMYMT_TYP_CD,emymtTypCd);
		 	values.put(ATTR_EMYMT_BGNN_DT,emymtBgnnDt);
		 	values.put(ATTR_EMYMT_END_DT,emymtEndDt);
		 	values.put(ATTR_DEPT_CD,deptCd);
		 	values.put(ATTR_DEPT_NM,deptNm);
		 	values.put(ATTR_CURR_PAE_WORK_NM,currPaeWorkNm);
		 	values.put(ATTR_BUSIN_CD,businCd);
		 	values.put(ATTR_TYP_OCCU_CD,typOccuCd);
		 	values.put(ATTR_TYP_OCCU_NM,typOccuNm);
		 	values.put(ATTR_DTIL_OCCU_CLS_DIV_CD,dtilOccuClsDivCd);
		 	values.put(ATTR_DTIL_OCCU_CLS_DIV_NM,dtilOccuClsDivNm);
		 	values.put(ATTR_ODTY_CD,odtyCd);
		 	values.put(ATTR_PAY_PYMT_DIV_CD,payPymtDivCd);
		 	values.put(ATTR_EMYMT_SUM,emymtSum);
		 	values.put(ATTR_EMYMT_REAS_CTNT,emymtReasCtnt);
		 	values.put(ATTR_CERT_NUM_HUHD,certNumHuhd);
		 	values.put(ATTR_RDUC_BGNN_DT,rducBgnnDt);
		 	values.put(ATTR_KYBDR,kybdr);
		 	values.put(ATTR_INPT_DT,inptDt);
		 	values.put(ATTR_INPT_ADDR,inptAddr);
		 	values.put(ATTR_ISMT,ismt);
		 	values.put(ATTR_REVN_DT,revnDt);
		 	values.put(ATTR_REVN_ADDR,revnAddr);
		 	values.put(ATTR_RDUC_END_DT,rducEndDt);
		 	values.put(ATTR_PYSP_GRDE_CD,pyspGrdeCd);
		 	values.put(ATTR_DTIL_OCCU_INTTN_CD,dtilOccuInttnCd);
		 	values.put(ATTR_CVSN_RTO_DIV_CD,cvsnRtoDivCd);
		 	values.put(ATTR_DUTY_YR_NUM,dutyYrNum);
		 	values.put(ATTR_DUTY_MNTH_ICM,dutyMnthIcm);
		 	values.put(ATTR_DUTY_DAY_NUM,dutyDayNum);
		 	values.put(ATTR_DUTY_TOT_DAY_NUM,dutyTotDayNum);
	 	}


	public void setDpobCd(String dpobCd) { set( ATTR_DPOB_CD ,dpobCd);}
	public String getDpobCd() { return (String )get( ATTR_DPOB_CD );}

	public void setSystemkey(String systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	public String getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	public void setEmymtSeilNum(String emymtSeilNum) { set( ATTR_EMYMT_SEIL_NUM ,emymtSeilNum);}
	public String getEmymtSeilNum() { return (String )get( ATTR_EMYMT_SEIL_NUM );}

	public void setEmymtDivCd(String emymtDivCd) { set( ATTR_EMYMT_DIV_CD ,emymtDivCd);}
	public String getEmymtDivCd() { return (String )get( ATTR_EMYMT_DIV_CD );}
 
	public void setEmymtTypCd(String emymtTypCd) { set( ATTR_EMYMT_TYP_CD ,emymtTypCd);}
	public String getEmymtTypCd() { return (String )get( ATTR_EMYMT_TYP_CD );}

	public void setEmymtBgnnDt(String emymtBgnnDt) { set( ATTR_EMYMT_BGNN_DT ,emymtBgnnDt);}
	public String getEmymtBgnnDt() { return (String )get( ATTR_EMYMT_BGNN_DT );}

	public void setEmymtEndDt(String emymtEndDt) { set( ATTR_EMYMT_END_DT ,emymtEndDt);}
	public String getEmymtEndDt() { return (String )get( ATTR_EMYMT_END_DT );}

	public void setDeptCd(String deptCd) { set( ATTR_DEPT_CD ,deptCd);}
	public String getDeptCd() { return (String )get( ATTR_DEPT_CD );}

	public void setDeptNm(String deptNm) { set( ATTR_DEPT_NM ,deptNm);}
	public String getDeptNm() { return (String )get( ATTR_DEPT_NM );}

	public void setCurrPaeWorkNm(String currPaeWorkNm) { set( ATTR_CURR_PAE_WORK_NM ,currPaeWorkNm);}
	public String getCurrPaeWorkNm() { return (String )get( ATTR_CURR_PAE_WORK_NM );}

	public void setBusinCd(String businCd) { set( ATTR_BUSIN_CD ,businCd);}
	public String getBusinCd() { return (String )get( ATTR_BUSIN_CD );}

	public void setTypOccuCd(String typOccuCd) { set( ATTR_TYP_OCCU_CD ,typOccuCd);}
	public String getTypOccuCd() { return (String )get( ATTR_TYP_OCCU_CD );}

	public void setTypOccuNm(String typOccuNm) { set( ATTR_TYP_OCCU_NM ,typOccuNm);}
	public String getTypOccuNm() { return (String )get( ATTR_TYP_OCCU_NM );}

	public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) { set( ATTR_DTIL_OCCU_CLS_DIV_CD ,dtilOccuClsDivCd);}
	public String getDtilOccuClsDivCd() { return (String )get( ATTR_DTIL_OCCU_CLS_DIV_CD );}

	public void setDtilOccuClsDivNm(String dtilOccuClsDivNm) { set( ATTR_DTIL_OCCU_CLS_DIV_NM ,dtilOccuClsDivNm);}
	public String getDtilOccuClsDivNm() { return (String )get( ATTR_DTIL_OCCU_CLS_DIV_NM );}

	public void setOdtyCd(String odtyCd) { set( ATTR_ODTY_CD ,odtyCd);}
	public String getOdtyCd() { return (String )get( ATTR_ODTY_CD );}

	public void setPayPymtDivCd(String payPymtDivCd) { set( ATTR_PAY_PYMT_DIV_CD ,payPymtDivCd);}
	public String getPayPymtDivCd() { return (String )get( ATTR_PAY_PYMT_DIV_CD );}

	public void setEmymtSum(String emymtSum) { set( ATTR_EMYMT_SUM ,emymtSum);}
	public String getEmymtSum() { return (String )get( ATTR_EMYMT_SUM );}

	public void setEmymtReasCtnt(String emymtReasCtnt) { set( ATTR_EMYMT_REAS_CTNT ,emymtReasCtnt);}
	public String getEmymtReasCtnt() { return (String )get( ATTR_EMYMT_REAS_CTNT );}

	public void setCertNumHuhd(String certNumHuhd) { set( ATTR_CERT_NUM_HUHD ,certNumHuhd);}
	public String getCertNumHuhd() { return (String )get( ATTR_CERT_NUM_HUHD );}

	public void setRducBgnnDt(String rducBgnnDt) { set( ATTR_RDUC_BGNN_DT ,rducBgnnDt);}
	public String getRducBgnnDt() { return (String )get( ATTR_RDUC_BGNN_DT );}

	public void setKybdr(String kybdr) { set( ATTR_KYBDR ,kybdr);}
	public String getKybdr() { return (String )get( ATTR_KYBDR );}

	public void setInptDt(String inptDt) { set( ATTR_INPT_DT ,inptDt);}
	public String setInptDt() { return (String )get( ATTR_INPT_DT );}

	public void setInptAddr(String inptAddr) { set( ATTR_INPT_ADDR ,inptAddr);}
	public String getInptAddr() { return (String )get( ATTR_INPT_ADDR );}

	public void setIsmt(String ismt) { set( ATTR_ISMT ,ismt);}
	public String getIsmt() { return (String )get( ATTR_ISMT );}

	public void setRevnDt(String revnDt) { set( ATTR_REVN_DT ,revnDt);}
	public String getRevnDt() { return (String )get( ATTR_REVN_DT );}

	public void setRevnAddr(String revnAddr) { set( ATTR_REVN_ADDR ,revnAddr);}
	public String getRevnAddr() { return (String )get( ATTR_REVN_ADDR );}

	public void setRducEndDt(String rducEndDt) { set( ATTR_RDUC_END_DT ,rducEndDt);}
	public String getRducEndDt() { return (String )get( ATTR_RDUC_END_DT );}

	public void setPyspGrdeCd(String pyspGrdeCd) { set( ATTR_PYSP_GRDE_CD ,pyspGrdeCd);}
	public String getPyspGrdeCd() { return (String )get( ATTR_PYSP_GRDE_CD );}

	public void setDtilOccuInttnCd(String dtilOccuInttnCd) { set( ATTR_DTIL_OCCU_INTTN_CD ,dtilOccuInttnCd);}
	public String getDtilOccuInttnCd() { return (String )get( ATTR_DTIL_OCCU_INTTN_CD );}

	public void setCvsnRtoDivCd(String cvsnRtoDivCd) { set( ATTR_CVSN_RTO_DIV_CD ,cvsnRtoDivCd);}
	public String getCvsnRtoDivCd() { return (String )get( ATTR_CVSN_RTO_DIV_CD );}

	public void setDutyYrNum(String dutyYrNum) { set( ATTR_DUTY_YR_NUM ,dutyYrNum);}
	public String getDutyYrNum() { return (String )get( ATTR_DUTY_YR_NUM );}

	public void setDutyMnthIcm(String dutyMnthIcm) { set( ATTR_DUTY_MNTH_ICM ,dutyMnthIcm);}
	public String getDutyMnthIcm() { return (String )get( ATTR_DUTY_MNTH_ICM );}

	public void setDutyDayNum(String dutyDayNum) { set( ATTR_DUTY_DAY_NUM ,dutyDayNum);}
	public String getDutyDayNum() { return (String )get( ATTR_DUTY_DAY_NUM );}

	public void setDutyTotDayNum(String dutyTotDayNum) { set( ATTR_DUTY_TOT_DAY_NUM ,dutyTotDayNum);}
	public String getDutyTotDayNum() { return (String )get( ATTR_DUTY_TOT_DAY_NUM );}
}