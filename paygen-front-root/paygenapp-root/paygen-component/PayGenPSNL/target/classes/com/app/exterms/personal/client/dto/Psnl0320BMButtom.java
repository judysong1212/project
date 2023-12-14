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
public class Psnl0320BMButtom    extends MSFSimpleBaseModel implements IsSerializable   {

	private static final long serialVersionUID = 1L;


	public static final String ATTR_DPOB_CD = "dpobCd"; /*사업장코드*/
	public static final String ATTR_SYSTEMKEY = "systemkey"; /*시스템키*/
	public static final String ATTR_PYSP_RE_MRK_SEIL_NUM = "pyspReMrkSeilNum"; /*호봉재획정일련번호*/
	public static final String ATTR_LOG_STD_BGN_DT = "logStdBgnDt"; /*근속기준시작일자*/
	public static final String ATTR_PYSP_RE_MRK_CALC_DT = "pyspReMrkCalcDt"; /*호봉재획정계산일자*/
	public static final String ATTR_PYSP_CD = "pyspCd"; /*호봉코드*/
	
	public static final String ATTR_PYSP_NM = "pyspNm"; /*호봉코드*/
	public static final String ATTR_M_PYSP_NM = "mPyspNm"; /*호봉코드*/
	
	public static final String ATTR_LOG_SVC_YR_NUM_CD = "logSvcYrNumCd"; /*근속년수코드*/
	public static final String ATTR_LOG_SVC_YR_NUM_NM = "logSvcYrNumNm"; /*근속년수코드*/
	
	
	public static final String ATTR_LOG_SVC_MNTH_ICM_CD = "logSvcMnthIcmCd"; /*근속월수코드*/
	public static final String ATTR_LOG_SVC_MNTH_ICM_NM = "logSvcMnthIcmNm"; /*근속월수코드*/
	
	
	
	public static final String ATTR_LOG_SVC_DYS = "logSvcDys"; /*근속일수*/
	public static final String ATTR_TOT_LOG_SVC_DYS = "totLogSvcDys"; /*총근속일수*/
	public static final String ATTR_ORG_LOG_SVC_YR_CD = "orgLogSvcYrCd"; /*원근속년수코드*/
	public static final String ATTR_ORG_LOG_SVC_YR_NM = "orgLogSvcYrNm"; /*원근속년수코드*/
	
	
	public static final String ATTR_ORG_LOG_SVC_MNTH_CD = "orgLogSvcMnthCd"; /*원근속월수코드*/
	public static final String ATTR_ORG_LOG_SVC_MNTH_NM = "orgLogSvcMnthNm"; /*원근속월수코드*/
	
	
	public static final String ATTR_ORG_LOG_SVC_DYS = "orgLogSvcDys"; /*원근속일수*/
	public static final String ATTR_ORG_TOT_LOG_SVC_DYS = "orgTotLogSvcDys"; /*원총근속일수*/
	public static final String ATTR_RE_MRK_DT = "reMrkDt"; /*재획정일자*/
	public static final String ATTR_PMTN_SCDU_DT = "pmtnScduDt"; /*승진예정일자*/
	public static final String ATTR_REYMN_SCDU_DT = "reymnScduDt"; /*재고용예정일자*/
	public static final String ATTR_PYSP_PRMTN_SCDU_DT = "pyspPrmtnScduDt"; /*호봉승급예정일자*/
	public static final String ATTR_EMYMT_RCGTN_LOG_SVC_YR_NUM = "emymtRcgtnLogSvcYrNum"; /*고용인정근속년수*/
	public static final String ATTR_EMYMT_RCGTN_LOG_SVC_MNTH_NUM = "emymtRcgtnLogSvcMnthNum"; /*고용인정근속월수*/
	public static final String ATTR_EMYMT_RCGTN_LOG_SVC_DYS = "emymtRcgtnLogSvcDys"; /*고용인정근속일수*/
	public static final String ATTR_MITY_CARR_RCGTN_LOG_SVC_YR_NUM = "mityCarrRcgtnLogSvcYrNum"; /*군경력인정근속년수*/
	public static final String ATTR_MITY_CARR_RCGTN_LOG_SVC_MNTH = "mityCarrRcgtnLogSvcMnth"; /*군경력인정근속월수*/
	public static final String ATTR_MITY_CARR_RCGTN_LOG_SVC_DYS = "mityCarrRcgtnLogSvcDys"; /*군경력인정근속일수*/
	public static final String ATTR_CARR_RCGTN_LOG_SVC_YR_NUM = "carrRcgtnLogSvcYrNum"; /*경력인정근속년수*/
	public static final String ATTR_CARR_RCGTN_LOG_SVC_MNTH_NUM = "carrRcgtnLogSvcMnthNum"; /*경력인정근속월수*/
	public static final String ATTR_CARR_RCGTN_LOG_SVC_DYS = "carrRcgtnLogSvcDys"; /*경력인정근속일수*/
	public static final String ATTR_DSNY_ACT_CTWP_MNTH_ICM = "dsnyActCtwpMnthIcm"; /*징계감봉월수*/
	public static final String ATTR_KYBDR = "kybdr"; /*입력자*/
	public static final String ATTR_INPT_DT = "inptDt"; /*입력일자*/
	public static final String ATTR_INPT_ADDR = "inptAddr"; /*입력주소*/
	public static final String ATTR_ISMT = "ismt"; /*수정자*/
	public static final String ATTR_REVN_DT = "revnDt"; /*수정일자*/
	public static final String ATTR_REVN_ADDR = "revnAddr"; /*수정주소*/

	/** 생성자 */
	 public Psnl0320BMButtom() { super(); } 

		/** 일괄등록 처리   */
	 public Psnl0320BMButtom(			
			  String dpobCd 	
			, String systemkey	
			, String pyspReMrkSeilNum	
			, String logStdBgnDt	
			, String pyspReMrkCalcDt	
			, String pyspCd	
			, String logSvcYrNumCd	
			, String logSvcMnthIcmCd	
			, String logSvcDys	
			, String totLogSvcDys	
			, String orgLogSvcYrCd	
			, String orgLogSvcMnthCd	
			, String orgLogSvcDys	
			, String orgTotLogSvcDys	
			, String reMrkDt	
			, String pmtnScduDt	
			, String reymnScduDt	
			, String pyspPrmtnScduDt	
			, String emymtRcgtnLogSvcYrNum	
			, String emymtRcgtnLogSvcMnthNum	
			, String emymtRcgtnLogSvcDys	
			, String mityCarrRcgtnLogSvcYrNum	
			, String mityCarrRcgtnLogSvcMnth	
			, String mityCarrRcgtnLogSvcDys	
			, String carrRcgtnLogSvcYrNum	
			, String carrRcgtnLogSvcMnthNum	
			, String carrRcgtnLogSvcDys	
			, String dsnyActCtwpMnthIcm	
			, String pyspNm
			, String mPyspNm
			, String logSvcYrNumNm
			, String logSvcMnthIcmNm
			, String orgLogSvcYrNm
			, String orgLogSvcMnthNm
			, String kybdr	
			, String inptDt	
			, String inptAddr	
			, String ismt	
			, String revnDt	
			, String revnAddr	
			) { 
		 values.put(ATTR_DPOB_CD,dpobCd);
		 values.put(ATTR_SYSTEMKEY,systemkey);
		 values.put(ATTR_PYSP_RE_MRK_SEIL_NUM,pyspReMrkSeilNum);
		 values.put(ATTR_LOG_STD_BGN_DT,logStdBgnDt);
		 values.put(ATTR_PYSP_RE_MRK_CALC_DT,pyspReMrkCalcDt);
		 values.put(ATTR_PYSP_CD,pyspCd);
		 values.put(ATTR_LOG_SVC_YR_NUM_CD,logSvcYrNumCd);
		 values.put(ATTR_LOG_SVC_MNTH_ICM_CD,logSvcMnthIcmCd);
		 values.put(ATTR_LOG_SVC_DYS,logSvcDys);
		 values.put(ATTR_TOT_LOG_SVC_DYS,totLogSvcDys);
		 values.put(ATTR_ORG_LOG_SVC_YR_CD,orgLogSvcYrCd);
		 values.put(ATTR_ORG_LOG_SVC_MNTH_CD,orgLogSvcMnthCd);
		 values.put(ATTR_ORG_LOG_SVC_DYS,orgLogSvcDys);
		 values.put(ATTR_ORG_TOT_LOG_SVC_DYS,orgTotLogSvcDys);
		 values.put(ATTR_RE_MRK_DT,reMrkDt);
		 values.put(ATTR_PMTN_SCDU_DT,pmtnScduDt);
		 values.put(ATTR_REYMN_SCDU_DT,reymnScduDt);
		 values.put(ATTR_PYSP_PRMTN_SCDU_DT,pyspPrmtnScduDt);
		 values.put(ATTR_EMYMT_RCGTN_LOG_SVC_YR_NUM,emymtRcgtnLogSvcYrNum);
		 values.put(ATTR_EMYMT_RCGTN_LOG_SVC_MNTH_NUM,emymtRcgtnLogSvcMnthNum);
		 values.put(ATTR_EMYMT_RCGTN_LOG_SVC_DYS,emymtRcgtnLogSvcDys);
		 values.put(ATTR_MITY_CARR_RCGTN_LOG_SVC_YR_NUM,mityCarrRcgtnLogSvcYrNum);
		 values.put(ATTR_MITY_CARR_RCGTN_LOG_SVC_MNTH,mityCarrRcgtnLogSvcMnth);
		 values.put(ATTR_MITY_CARR_RCGTN_LOG_SVC_DYS,mityCarrRcgtnLogSvcDys);
		 values.put(ATTR_CARR_RCGTN_LOG_SVC_YR_NUM,carrRcgtnLogSvcYrNum);
		 values.put(ATTR_CARR_RCGTN_LOG_SVC_MNTH_NUM,carrRcgtnLogSvcMnthNum);
		 values.put(ATTR_CARR_RCGTN_LOG_SVC_DYS,carrRcgtnLogSvcDys);
		 values.put(ATTR_DSNY_ACT_CTWP_MNTH_ICM,dsnyActCtwpMnthIcm);
		 
		 values.put(ATTR_PYSP_NM,pyspNm);
		 values.put(ATTR_M_PYSP_NM,mPyspNm);
		 values.put(ATTR_LOG_SVC_YR_NUM_NM,logSvcYrNumNm);
		 values.put(ATTR_LOG_SVC_MNTH_ICM_NM,logSvcMnthIcmNm);
		 values.put(ATTR_ORG_LOG_SVC_YR_NM,orgLogSvcYrNm);
		 values.put(ATTR_ORG_LOG_SVC_MNTH_NM,orgLogSvcMnthNm);
		 
		 values.put(ATTR_KYBDR,kybdr);
		 values.put(ATTR_INPT_DT,inptDt);
		 values.put(ATTR_INPT_ADDR,inptAddr);
		 values.put(ATTR_ISMT,ismt);
		 values.put(ATTR_REVN_DT,revnDt);
		 values.put(ATTR_REVN_ADDR,revnAddr);
	 	}

	public void setDpobCd(String  dpobCd) { set( ATTR_DPOB_CD ,dpobCd);}
	public String getDpobCd() { return (String )get( ATTR_DPOB_CD );}

	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	public String getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	public void setPyspReMrkSeilNum(String  pyspReMrkSeilNum) { set( ATTR_PYSP_RE_MRK_SEIL_NUM ,pyspReMrkSeilNum);}
	public String getPyspReMrkSeilNum() { return (String )get( ATTR_PYSP_RE_MRK_SEIL_NUM );}

	public void setLogStdBgnDt(String  logStdBgnDt) { set( ATTR_LOG_STD_BGN_DT ,logStdBgnDt);}
	public String getLogStdBgnDt() { return (String )get( ATTR_LOG_STD_BGN_DT );}

	public void setPyspReMrkCalcDt(String  pyspReMrkCalcDt) { set( ATTR_PYSP_RE_MRK_CALC_DT ,pyspReMrkCalcDt);}
	public String getPyspReMrkCalcDt() { return (String )get( ATTR_PYSP_RE_MRK_CALC_DT );}

	public void setPyspCd(String  pyspCd) { set( ATTR_PYSP_CD ,pyspCd);}
	public String getPyspCd() { return (String )get( ATTR_PYSP_CD );}

	public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( ATTR_LOG_SVC_YR_NUM_CD ,logSvcYrNumCd);}
	public String getLogSvcYrNumCd() { return (String )get( ATTR_LOG_SVC_YR_NUM_CD );}

	public void setLogSvcMnthIcmCd(String  logSvcMnthIcmCd) { set( ATTR_LOG_SVC_MNTH_ICM_CD ,logSvcMnthIcmCd);}
	public String getLogSvcMnthIcmCd() { return (String )get( ATTR_LOG_SVC_MNTH_ICM_CD );}

	public void setLogSvcDys(String  logSvcDys) { set( ATTR_LOG_SVC_DYS ,logSvcDys);}
	public String getLogSvcDys() { return (String )get( ATTR_LOG_SVC_DYS );}

	public void setTotLogSvcDys(String  totLogSvcDys) { set( ATTR_TOT_LOG_SVC_DYS ,totLogSvcDys);}
	public String getTotLogSvcDys() { return (String )get( ATTR_TOT_LOG_SVC_DYS );}

	public void setOrgLogSvcYrCd(String  orgLogSvcYrCd) { set( ATTR_ORG_LOG_SVC_YR_CD ,orgLogSvcYrCd);}
	public String getOrgLogSvcYrCd() { return (String )get( ATTR_ORG_LOG_SVC_YR_CD );}

	public void setOrgLogSvcMnthCd(String  orgLogSvcMnthCd) { set( ATTR_ORG_LOG_SVC_MNTH_CD ,orgLogSvcMnthCd);}
	public String getOrgLogSvcMnthCd() { return (String )get( ATTR_ORG_LOG_SVC_MNTH_CD );}

	public void setOrgLogSvcDys(String  orgLogSvcDys) { set( ATTR_ORG_LOG_SVC_DYS ,orgLogSvcDys);}
	public String getOrgLogSvcDys() { return (String )get( ATTR_ORG_LOG_SVC_DYS );}

	public void setOrgTotLogSvcDys(String  orgTotLogSvcDys) { set( ATTR_ORG_TOT_LOG_SVC_DYS ,orgTotLogSvcDys);}
	public String getOrgTotLogSvcDys() { return (String )get( ATTR_ORG_TOT_LOG_SVC_DYS );}

	public void setReMrkDt(String  reMrkDt) { set( ATTR_RE_MRK_DT ,reMrkDt);}
	public String getReMrkDt() { return (String )get( ATTR_RE_MRK_DT );}

	public void setPmtnScduDt(String  pmtnScduDt) { set( ATTR_PMTN_SCDU_DT ,pmtnScduDt);}
	public String getPmtnScduDt() { return (String )get( ATTR_PMTN_SCDU_DT );}

	public void setReymnScduDt(String  reymnScduDt) { set( ATTR_REYMN_SCDU_DT ,reymnScduDt);}
	public String getReymnScduDt() { return (String )get( ATTR_REYMN_SCDU_DT );}

	public void setPyspPrmtnScduDt(String  pyspPrmtnScduDt) { set( ATTR_PYSP_PRMTN_SCDU_DT ,pyspPrmtnScduDt);}
	public String getPyspPrmtnScduDt() { return (String )get( ATTR_PYSP_PRMTN_SCDU_DT );}

	public void setEmymtRcgtnLogSvcYrNum(String  emymtRcgtnLogSvcYrNum) { set( ATTR_EMYMT_RCGTN_LOG_SVC_YR_NUM ,emymtRcgtnLogSvcYrNum);}
	public String getEmymtRcgtnLogSvcYrNum() { return (String )get( ATTR_EMYMT_RCGTN_LOG_SVC_YR_NUM );}

	public void setEmymtRcgtnLogSvcMnthNum(String  emymtRcgtnLogSvcMnthNum) { set( ATTR_EMYMT_RCGTN_LOG_SVC_MNTH_NUM ,emymtRcgtnLogSvcMnthNum);}
	public String getEmymtRcgtnLogSvcMnthNum() { return (String )get( ATTR_EMYMT_RCGTN_LOG_SVC_MNTH_NUM );}

	public void setEmymtRcgtnLogSvcDys(String  emymtRcgtnLogSvcDys) { set( ATTR_EMYMT_RCGTN_LOG_SVC_DYS ,emymtRcgtnLogSvcDys);}
	public String getEmymtRcgtnLogSvcDys() { return (String )get( ATTR_EMYMT_RCGTN_LOG_SVC_DYS );}

	public void setMityCarrRcgtnLogSvcYrNum(String  mityCarrRcgtnLogSvcYrNum) { set( ATTR_MITY_CARR_RCGTN_LOG_SVC_YR_NUM ,mityCarrRcgtnLogSvcYrNum);}
	public String getMityCarrRcgtnLogSvcYrNum() { return (String )get( ATTR_MITY_CARR_RCGTN_LOG_SVC_YR_NUM );}

	public void setMityCarrRcgtnLogSvcMnth(String  mityCarrRcgtnLogSvcMnth) { set( ATTR_MITY_CARR_RCGTN_LOG_SVC_MNTH ,mityCarrRcgtnLogSvcMnth);}
	public String setMityCarrRcgtnLogSvcMnth() { return (String )get( ATTR_MITY_CARR_RCGTN_LOG_SVC_MNTH );}

	public void setMityCarrRcgtnLogSvcDys(String  mityCarrRcgtnLogSvcDys) { set( ATTR_MITY_CARR_RCGTN_LOG_SVC_DYS ,mityCarrRcgtnLogSvcDys);}
	public String getMityCarrRcgtnLogSvcDys() { return (String )get( ATTR_MITY_CARR_RCGTN_LOG_SVC_DYS );}

	public void setCarrRcgtnLogSvcYrNum(String  carrRcgtnLogSvcYrNum) { set( ATTR_CARR_RCGTN_LOG_SVC_YR_NUM ,carrRcgtnLogSvcYrNum);}
	public String getCarrRcgtnLogSvcYrNum() { return (String )get( ATTR_CARR_RCGTN_LOG_SVC_YR_NUM );}

	public void setCarrRcgtnLogSvcMnthNum(String  carrRcgtnLogSvcMnthNum) { set( ATTR_CARR_RCGTN_LOG_SVC_MNTH_NUM ,carrRcgtnLogSvcMnthNum);}
	public String getCarrRcgtnLogSvcMnthNum() { return (String )get( ATTR_CARR_RCGTN_LOG_SVC_MNTH_NUM );}

	public void setCarrRcgtnLogSvcDys(String  carrRcgtnLogSvcDys) { set( ATTR_CARR_RCGTN_LOG_SVC_DYS ,carrRcgtnLogSvcDys);}
	public String getCarrRcgtnLogSvcDys() { return (String )get( ATTR_CARR_RCGTN_LOG_SVC_DYS );}

	public void setDsnyActCtwpMnthIcm(String  dsnyActCtwpMnthIcm) { set( ATTR_DSNY_ACT_CTWP_MNTH_ICM ,dsnyActCtwpMnthIcm);}
	public String getDsnyActCtwpMnthIcm() { return (String )get( ATTR_DSNY_ACT_CTWP_MNTH_ICM );}
	
	
	
	public void setPyspNm(String  pyspNm) { set( ATTR_PYSP_NM ,pyspNm);}
	public String getPyspNm() { return (String )get( ATTR_PYSP_NM );}
	
	public void setMPyspNm(String  mPyspNm) { set( ATTR_M_PYSP_NM ,mPyspNm);}
	public String getMPyspNm() { return (String )get( ATTR_M_PYSP_NM );}
	
	public void setLogSvcYrNumNm(String  logSvcYrNumNm) { set( ATTR_LOG_SVC_YR_NUM_NM ,logSvcYrNumNm);}
	public String getLogSvcYrNumNm() { return (String )get( ATTR_LOG_SVC_YR_NUM_NM );}
	
	public void setLogSvcMnthIcmNm(String  logSvcMnthIcmNm) { set( ATTR_LOG_SVC_MNTH_ICM_NM ,logSvcMnthIcmNm);}
	public String getLogSvcMnthIcmNm() { return (String )get( ATTR_LOG_SVC_MNTH_ICM_NM );}
	
	public void setOrgLogSvcYrNm(String  orgLogSvcYrNm) { set( ATTR_ORG_LOG_SVC_YR_NM ,orgLogSvcYrNm);}
	public String getOrgLogSvcYrNm() { return (String )get( ATTR_ORG_LOG_SVC_YR_NM );}
	
	public void setOrgLogSvcMnthNm(String  orgLogSvcMnthNm) { set( ATTR_ORG_LOG_SVC_MNTH_NM ,orgLogSvcMnthNm);}
	public String getOrgLogSvcMnthNm() { return (String )get( ATTR_ORG_LOG_SVC_MNTH_NM );}

	
	
	public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
	public String getKybdr() { return (String )get( ATTR_KYBDR );}

	public void setInptDt(String  inptDt) { set( ATTR_INPT_DT ,inptDt);}
	public String getInptDt() { return (String )get( ATTR_INPT_DT );}

	public void setInptAddr(String  inptAddr) { set( ATTR_INPT_ADDR ,inptAddr);}
	public String getInptAddr() { return (String )get( ATTR_INPT_ADDR );}

	public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
	public String getIsmt() { return (String )get( ATTR_ISMT );}

	public void setRevnDt(String  revnDt) { set( ATTR_REVN_DT ,revnDt);}
	public String getRevnDt() { return (String )get( ATTR_REVN_DT );}

	public void setRevnAddr(String  revnAddr) { set( ATTR_REVN_ADDR ,revnAddr);}
	public String getRevnAddr() { return (String )get( ATTR_REVN_ADDR );}
}