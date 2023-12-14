package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr3200VO.java
 * @Description : Insr3200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5400BM  extends MSFSimpleBaseModel implements IsSerializable   {
	 
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 고용시작일(귀속년도) : hlthInsrYr -> srhHlthInsrYr */
	public static final String ATTR_SRH_HLTH_INSR_YR = "srhHlthInsrYr";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 부서 : deptNm */
	public static final String ATTR_DEPT_NM = "deptNm";

	/** set 성명 : hlthNm */
	//public static final String ATTR_HLTHNM = "hlthNm";//
	public static final String ATTR_ACNT_HODR_NM = "acntHodrNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESN_REGN_NUM = "resnRegnNum";

	/** set 보험료부과구분 : prmmIposDivCd */
	public static final String ATTR_PRMM_IPOS_DIV_CD = "prmmIposDivCd";

	/** set 고용보험사업장코드 : umytDpobCd */
	public static final String ATTR_UMYT_DPOB_CD = "umytDpobCd";	
	
	/** set 고용보험정산년도 : umytInsrClutYr */
	public static final String ATTR_UMYT_INSR_CLUT_YR = "umytInsrClutYr";
	
	/** set 고용보험시스템키 : umytSystemkey */
	public static final String ATTR_UMYT_SYSTEMKEY = "umytSystemkey";

	/** set 고용보험고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMT_SEIL_NUM2 = "emymtSeilNum2";

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public static final String ATTR_UMYT_INSR_AQTN_DT = "umytInsrAqtnDt";

	/** set 고용보험상실일자 : umytInsrLssDt */
	public static final String ATTR_UMYT_INSR_LSS_DT = "umytInsrLssDt";
	
	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	public static final String ATTR_UMYT_INSR_PAY_TOT_AMNT = "umytInsrPayTotAmnt";

	/** set 산재보험사업장코드 : idtlDpobCd */
	public static final String ATTR_IDTL_DPOB_CD = "idtlDpobCd";
	
	/** set 산재보험정산년도 : idtlAccdtInsurClutYr */
	public static final String ATTR_IDTL_ACCDT_INSUR_CLUT_YR = "idtlAccdtInsurClutYr";
	
	/** set 산재보험시스템키 : idtlSystemkey */
	public static final String ATTR_IDTL_SYSTEMKEY = "idtlSystemkey";

	/** set 산재보험고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMT_SEIL_NUM1 = "emymtSeilNum1";
	
	/** set 산재취득일자 : idtlAccdtInsurAqtnDt */
	public static final String ATTR_IDTL_ACCDT_INSUR_AQTN_DT = "idtlAccdtInsurAqtnDt";

	/** set 산재상실일자 : idtlAccdtInsurLssDt */
	public static final String ATTR_IDTL_ACCDT_INSUR_LSS_DT = "idtlAccdtInsurLssDt";
	
	/** set 산재보수총액 : idtlAccdtPayTotAmnt */
	public static final String ATTR_IDTL_ACCDT_PAY_TOT_AMNT = "idtlAccdtPayTotAmnt";

	/** set 직종코드 : typOccuCd */
	public static final String ATTR_TYP_OCCU_CD = "typOccuCd";

	/** set 직종명 : typOccuNm */
	public static final String ATTR_TYP_OCCU_NM = "typOccuNm";

	/** set 직종세 : dtilOccuClsDivCd */
	public static final String ATTR_DTIL_OCCU_CLS_DIV_CD = "dtilOccuClsDivCd";

	/** set 직종세 : dtilOccuClsDivCdNm */
	public static final String ATTR_DTIL_OCCU_CLS_DIV_CD_NM = "dtilOccuClsDivCdNm";
	











	/** 생성자 */
	 public Insr5400BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr5400BM(
			 String  dpobCd //사업장코드
			, String srhHlthInsrYr //고용시작일(귀속년도)
			, String systemkey  //SYSTEMKEY
			, String deptNm //부서
			, String acntHodrNm //성명
			, String resnRegnNum //주민등록번호
			, String prmmIposDivCd //보험료부과구분

			, String idtlDpobCd //산재보험사업장코드
			, String idtlAccdtInsurClutYr //산재보험정산년도
			, String idtlSystemkey //산재보험시스템키
			, String emymtSeilNum1 //산재보험고용일련번호
			, String idtlAccdtInsurAqtnDt //산재취득일자
			, String idtlAccdtInsurLssDt //산재상실일자
			, Long idtlAccdtPayTotAmnt //산재보수총액

			, String umytDpobCd //고용보험사업장코드
			, String umytInsrClutYr //고용보험정산년도
			, String umytSystemkey //고용보험시스템키
			, String emymtSeilNum2 //고용보험고용일련번호
			, String umytInsrAqtnDt //고용보험취득일자
			, String umytInsrLssDt //고용보험상실일자
			, Long  umytInsrPayTotAmnt //고용보험보수총액

			, String  typOccuCd
			, String typOccuNm
			, String  dtilOccuClsDivCd
			, String dtilOccuClsDivCdNm
			 ) {
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SRH_HLTH_INSR_YR,srhHlthInsrYr);
	 	values.put(ATTR_SYSTEMKEY,systemkey); 
	 	values.put(ATTR_DEPT_NM,deptNm);
	 	values.put(ATTR_ACNT_HODR_NM,acntHodrNm);
	 	values.put(ATTR_RESN_REGN_NUM,resnRegnNum);
	 	values.put(ATTR_PRMM_IPOS_DIV_CD,prmmIposDivCd);

	 	values.put(ATTR_IDTL_DPOB_CD,idtlDpobCd);
	 	values.put(ATTR_IDTL_ACCDT_INSUR_CLUT_YR,idtlAccdtInsurClutYr);
	 	values.put(ATTR_IDTL_SYSTEMKEY,idtlSystemkey);
	 	values.put(ATTR_EMYMT_SEIL_NUM1,emymtSeilNum1);	 	
	 	values.put(ATTR_IDTL_ACCDT_INSUR_AQTN_DT,idtlAccdtInsurAqtnDt);
	 	values.put(ATTR_IDTL_ACCDT_INSUR_LSS_DT,idtlAccdtInsurLssDt);
	 	values.put(ATTR_IDTL_ACCDT_PAY_TOT_AMNT,idtlAccdtPayTotAmnt);

	 	values.put(ATTR_UMYT_DPOB_CD,umytDpobCd);
	 	values.put(ATTR_UMYT_INSR_CLUT_YR,umytInsrClutYr);
	 	values.put(ATTR_UMYT_SYSTEMKEY,umytSystemkey);
	 	values.put(ATTR_EMYMT_SEIL_NUM2,emymtSeilNum2);
	 	values.put(ATTR_UMYT_INSR_AQTN_DT,umytInsrAqtnDt);
	 	values.put(ATTR_UMYT_INSR_LSS_DT,umytInsrLssDt);
	 	values.put(ATTR_UMYT_INSR_PAY_TOT_AMNT,umytInsrPayTotAmnt);

	 	values.put(ATTR_TYP_OCCU_CD,typOccuCd);
	 	values.put(ATTR_TYP_OCCU_NM,typOccuNm);
	 	values.put(ATTR_DTIL_OCCU_CLS_DIV_CD,dtilOccuClsDivCd);
	 	values.put(ATTR_DTIL_OCCU_CLS_DIV_CD_NM,dtilOccuClsDivCdNm);
	 }

	 
	 
	 
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}

	/** set 고용시작일(귀속년도) : hlthInsrYr -> srhHlthInsrYr */
	public void setHlthInsrYr(String  srhHlthInsrYr) { set( ATTR_SRH_HLTH_INSR_YR ,srhHlthInsrYr);}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}

	/** set 부서 : deptNm */
	public void setDeptNm(String  deptNm) { set( ATTR_DEPT_NM ,deptNm);}

	/** set 성명 : hlthNm */
	public void setHlthNm(String acntHodrNm) { set( ATTR_ACNT_HODR_NM ,acntHodrNm);}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String resnRegnNum) { set( ATTR_RESN_REGN_NUM ,resnRegnNum);}

	/** set 보험료부과구분 : prmmIposDivCd */
	public void setPrmmIposDivCd(String prmmIposDivCd) { set( ATTR_PRMM_IPOS_DIV_CD ,prmmIposDivCd);}

	/** set 산재보험사업장코드 : idtlDpobCd */
	public void setIdtlDpobCd(String idtlDpobCd) { set( ATTR_IDTL_DPOB_CD ,idtlDpobCd);}
	
	/** set 산재보험정산년도 : idtlAccdtInsurClutYr */
	public void setIdtlAccdtInsurClutYr(String idtlAccdtInsurClutYr) { set( ATTR_IDTL_ACCDT_INSUR_CLUT_YR ,idtlAccdtInsurClutYr);}

	/** set 산재보험시스템키 : idtlSystemkey */
	public void setIdtlSystemkey(String idtlSystemkey) { set( ATTR_IDTL_SYSTEMKEY ,idtlSystemkey);}

	/** set 산재보험고용일련번호 : emymtSeilNum1 */
	public void setEmymtSeilNum1(String emymtSeilNum1) { set( ATTR_EMYMT_SEIL_NUM1 ,emymtSeilNum1);}

	/** set 산재취득일자 : idtlAccdtInsurAqtnDt */
	public void setIdtlAccdtInsurAqtnDt(String idtlAccdtInsurAqtnDt) { set( ATTR_IDTL_ACCDT_INSUR_AQTN_DT ,idtlAccdtInsurAqtnDt);}

	/** set 산재상실일자 : idtlAccdtInsurLssDt */
	public void setIdtAccdtInsurLssDt(String idtlAccdtInsurLssDt) { set( ATTR_IDTL_ACCDT_INSUR_LSS_DT ,idtlAccdtInsurLssDt);}

	/** set 산재보수총액 : idtlAccdtPayTotAmnt */
	public void setIdtlAccdtPayTotAmnt(Long idtlAccdtPayTotAmnt) { set( ATTR_IDTL_ACCDT_PAY_TOT_AMNT ,idtlAccdtPayTotAmnt);}

	/** set 고용보험사업장코드 : umytDpobCd */
	public void setUmytDpobCd(String umytDpobCd) { set( ATTR_UMYT_DPOB_CD ,umytDpobCd);}

	/** set 고용보험정산년도 : umytInsrClutYr */
	public void setUmytInsrClutYr(String umytInsrClutYr) { set( ATTR_UMYT_INSR_CLUT_YR ,umytInsrClutYr);}

	/** set 고용보험시스템키 : umytSystemkey */
	public void setUmytSystemkey(String umytSystemkey) { set( ATTR_UMYT_SYSTEMKEY ,umytSystemkey);}

	/** set 고용보험고용일련번호 : emymtSeilNum2 */
	public void setEmymtSeilNum2(String emymtSeilNum2) { set( ATTR_EMYMT_SEIL_NUM2 ,emymtSeilNum2);}

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public void setUmytInsrAqtnDt(String umytInsrAqtnDt) { set( ATTR_UMYT_INSR_AQTN_DT ,umytInsrAqtnDt);}

	/** set 고용보험상실일자 : umytInsrLssDt */
	public void setUmytInsrLssDt(String umytInsrLssDt) { set( ATTR_UMYT_INSR_LSS_DT ,umytInsrLssDt);}
	
	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	public void setUmytInsrPayTotAmnt(Long umytInsrPayTotAmnt) { set( ATTR_UMYT_INSR_PAY_TOT_AMNT ,umytInsrPayTotAmnt);}


	/** set 직종 : typOccuCd */
	public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYP_OCCU_CD ,typOccuCd);}

	/** set 직종 : typOccuNm */
	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYP_OCCU_NM ,typOccuNm);}

	/** set 직종세 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTIL_OCCU_CLS_DIV_CD ,dtilOccuClsDivCd);}

	/** set 직종세 : dtilOccuClsDivCdNm */
	public void setDtilOccuClsDivCdNm(String  dtilOccuClsDivCdNm) { set( ATTR_DTIL_OCCU_CLS_DIV_CD_NM ,dtilOccuClsDivCdNm);}
}
