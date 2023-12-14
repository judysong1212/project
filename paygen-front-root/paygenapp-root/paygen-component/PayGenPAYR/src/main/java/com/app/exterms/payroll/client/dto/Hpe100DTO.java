package com.app.exterms.payroll.client.dto;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Hpe100DTO implements IsSerializable {
	private static final long serialVersionUID = 1L;

	private String DPOB_CD; //사업장코드
	private String YEAR_YYYY; //정산년도
	private String HALF_YEAR; //근무시기
	private String DEPT_CD; //부서코드
	private String PERSON_NUMB; 
	private String RESN_REGN_NUM; //주민번호
	private String HAN_NM;
	private String CELL_PHNE_NUM;
	private String FRGNR_DIV_CD;
	private String RESIDENT_CD;
	private String NATN_CD;
	private String EMYMT_BGNN_DT;
	private String EMYMT_END_DT;
	private String TXTN_TOT_AMNT;
	private String FREE_DTY_TOT_AMT;
	
	//--2021년 하반기 간이세액명세서 양식변경 수정작업 (PDS-2022.01.11) START--//  
	private String TXTN_TOT_AMNT_A;
	private String FREE_DTY_TOT_AMT_A;
	private String TXTN_TOT_AMNT_B;
	private String FREE_DTY_TOT_AMT_B;
	private String TXTN_TOT_AMNT_C;
	private String FREE_DTY_TOT_AMT_C;
	private String TXTN_TOT_AMNT_D;
	private String FREE_DTY_TOT_AMT_D;
	private String TXTN_TOT_AMNT_E;
	private String FREE_DTY_TOT_AMT_E;
	private String TXTN_TOT_AMNT_F;
	private String FREE_DTY_TOT_AMT_F;
	//--2021년 하반기 간이세액명세서 양식변경 수정작업 (PDS-202
	
	private String KYBDR; //입력자
	private String INPT_DT; //입력일자
	private String INPT_ADDR; //입력주소
	private String ISMT; //수정자
	private String REVN_DT; //수정일자
	private String REVN_ADDR; //수정주소
	private String TEMPC_01;
	private String TEMPC_02;
	private String TEMPC_03;
	private String TEMPN_01;
	private String TEMPN_02;
	private String TEMPN_03;

	private String DPOB_NM; //법인명
	private String TX_OFFC_CD; //관할세무서
	private String BUSOPR_RGSTN_NUM; //사업자등록번호
	private String DPOB_ZPCD; //우편번호
	private String DPOB_FNDTN_ADDR; //사업장주소
	private String DPOB_DTL_PATR_ADDR; //사업장상세주소
	private String DEGTR_NM; //대표이사명
	private String CORP_RGSTN_NUM; //법인번호
	private String DEPT_NM; //담당부서명
	private String USR_NM; //담당자명
	private String USR_TEL; //담당자전화번호
	private String SUBMIT_DATE; 
	private String HOMETAX_ID; //홈텍스아이디
	private String SUBMITTER; //제출자구분
	private String TAX_AGENT_NO; //세무대리인번호
	private String TAX_PGM_CODE; //세무프로그램코드
         
	private String SrhYrtxBlggYr; //정산년도
	private String SrhClutSeptCd;
	private String SrhPayrMangDeptCd;
	private String SrhEmymtDivCd;
	private String SrhDeptCd; //부서
	private String SrhTypOccuCd;
	private String SrhDtilOccuInttnCd;
	private String SrhBusinCd;
	private String SrhUtDpobCd;
	
	private String PayrMangDeptYn;
	private String DeptCdAuth;
	private String DtilOccuInttnCdAuth;
	private String UsrId; //담당자아이디
	
	
	
	private List<String> DeptCdArr;
	private List<String> TypOccuCdArr;
	private List<String> DtilOccuInttnCdArr;
	private List<String> BusinCdArr;

	private int pageSize;
	private int firstIndex;
	private int lastIndex;
	
	public String getDPOB_CD() {
		return DPOB_CD;
	}
	public String getYEAR_YYYY() {
		return YEAR_YYYY;
	}
	public String getHALF_YEAR() {
		return HALF_YEAR;
	}
	public String getDEPT_CD() {
		return DEPT_CD;
	}
	public String getPERSON_NUMB() {
		return PERSON_NUMB;
	}
	public String getRESN_REGN_NUM() {
		return RESN_REGN_NUM;
	}
	public String getHAN_NM() {
		return HAN_NM;
	}
	public String getCELL_PHNE_NUM() {
		return CELL_PHNE_NUM;
	}
	public String getFRGNR_DIV_CD() {
		return FRGNR_DIV_CD;
	}
	public String getRESIDENT_CD() {
		return RESIDENT_CD;
	}
	public String getNATN_CD() {
		return NATN_CD;
	}
	public String getEMYMT_BGNN_DT() {
		return EMYMT_BGNN_DT;
	}
	public String getEMYMT_END_DT() {
		return EMYMT_END_DT;
	}
	public String getTXTN_TOT_AMNT() {
		return TXTN_TOT_AMNT;
	}
	public String getFREE_DTY_TOT_AMT() {
		return FREE_DTY_TOT_AMT;
	}
	public String getKYBDR() {
		return KYBDR;
	}
	public String getINPT_DT() {
		return INPT_DT;
	}
	public String getINPT_ADDR() {
		return INPT_ADDR;
	}
	public String getISMT() {
		return ISMT;
	}
	public String getREVN_DT() {
		return REVN_DT;
	}
	public String getREVN_ADDR() {
		return REVN_ADDR;
	}
	public String getTEMPC_01() {
		return TEMPC_01;
	}
	public String getTEMPC_02() {
		return TEMPC_02;
	}
	public String getTEMPC_03() {
		return TEMPC_03;
	}
	public String getTEMPN_01() {
		return TEMPN_01;
	}
	public String getTEMPN_02() {
		return TEMPN_02;
	}
	public String getTEMPN_03() {
		return TEMPN_03;
	}
	public String getSrhYrtxBlggYr() {
		return SrhYrtxBlggYr;
	}
	public String getSrhClutSeptCd() {
		return SrhClutSeptCd;
	}
	public String getSrhPayrMangDeptCd() {
		return SrhPayrMangDeptCd;
	}
	public String getSrhEmymtDivCd() {
		return SrhEmymtDivCd;
	}
	public String getSrhDeptCd() {
		return SrhDeptCd;
	}
	public String getSrhTypOccuCd() {
		return SrhTypOccuCd;
	}
	public String getSrhDtilOccuInttnCd() {
		return SrhDtilOccuInttnCd;
	}
	public String getSrhBusinCd() {
		return SrhBusinCd;
	}
	public String getSrhUtDpobCd() {
		return SrhUtDpobCd;
	}
	public String getPayrMangDeptYn() {
		return PayrMangDeptYn;
	}
	public String getDeptCdAuth() {
		return DeptCdAuth;
	}
	public String getDtilOccuInttnCdAuth() {
		return DtilOccuInttnCdAuth;
	}
	public String getUsrId() {
		return UsrId;
	}
	public List<String> getDeptCdArr() {
		return DeptCdArr;
	}
	public List<String> getTypOccuCdArr() {
		return TypOccuCdArr;
	}
	public List<String> getDtilOccuInttnCdArr() {
		return DtilOccuInttnCdArr;
	}
	public List<String> getBusinCdArr() {
		return BusinCdArr;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public String getDPOB_NM() {
		return DPOB_NM;
	}
	public String getTX_OFFC_CD() {
		return TX_OFFC_CD;
	}
	public String getBUSOPR_RGSTN_NUM() {
		return BUSOPR_RGSTN_NUM;
	}
	public String getDPOB_ZPCD() {
		return DPOB_ZPCD;
	}
	public String getDPOB_FNDTN_ADDR() {
		return DPOB_FNDTN_ADDR;
	}
	public String getDPOB_DTL_PATR_ADDR() {
		return DPOB_DTL_PATR_ADDR;
	}
	public String getDEGTR_NM() {
		return DEGTR_NM;
	}
	public String getCORP_RGSTN_NUM() {
		return CORP_RGSTN_NUM;
	}
	public String getDEPT_NM() {
		return DEPT_NM;
	}
	public String getUSR_NM() {
		return USR_NM;
	}
	public String getUSR_TEL() {
		return USR_TEL;
	}
	public String getSUBMIT_DATE() {
		return SUBMIT_DATE;
	}
	public String getHOMETAX_ID() {
		return HOMETAX_ID;
	}
	public String getSUBMITTER() {
		return SUBMITTER;
	}
	public String getTAX_AGENT_NO() {
		return TAX_AGENT_NO;
	}
	public String getTAX_PGM_CODE() {
		return TAX_PGM_CODE;
	}
	
	
	
	
	
	public void setDPOB_CD(String dPOB_CD) {
		DPOB_CD = dPOB_CD;
	}
	public void setYEAR_YYYY(String yEAR_YYYY) {
		YEAR_YYYY = yEAR_YYYY;
	}
	public void setHALF_YEAR(String hALF_YEAR) {
		HALF_YEAR = hALF_YEAR;
	}
	public void setDEPT_CD(String dEPT_CD) {
		DEPT_CD = dEPT_CD;
	}
	public void setPERSON_NUMB(String pERSON_NUMB) {
		PERSON_NUMB = pERSON_NUMB;
	}
	public void setRESN_REGN_NUM(String rESN_REGN_NUM) {
		RESN_REGN_NUM = rESN_REGN_NUM;
	}
	public void setHAN_NM(String hAN_NM) {
		HAN_NM = hAN_NM;
	}
	public void setCELL_PHNE_NUM(String cELL_PHNE_NUM) {
		CELL_PHNE_NUM = cELL_PHNE_NUM;
	}
	public void setFRGNR_DIV_CD(String fRGNR_DIV_CD) {
		FRGNR_DIV_CD = fRGNR_DIV_CD;
	}
	public void setRESIDENT_CD(String rESIDENT_CD) {
		RESIDENT_CD = rESIDENT_CD;
	}
	public void setNATN_CD(String nATN_CD) {
		NATN_CD = nATN_CD;
	}
	public void setEMYMT_BGNN_DT(String eMYMT_BGNN_DT) {
		EMYMT_BGNN_DT = eMYMT_BGNN_DT;
	}
	public void setEMYMT_END_DT(String eMYMT_END_DT) {
		EMYMT_END_DT = eMYMT_END_DT;
	}
	public void setTXTN_TOT_AMNT(String tXTN_TOT_AMNT) {
		TXTN_TOT_AMNT = tXTN_TOT_AMNT;
	}
	public void setFREE_DTY_TOT_AMT(String fREE_DTY_TOT_AMT) {
		FREE_DTY_TOT_AMT = fREE_DTY_TOT_AMT;
	}
	

	//**--------2021년 하반기 간이세액명세서 양식변경 수정작업 (PDS-2022.01.11) START -----**//
	public void setTXTN_TOT_AMNT_A(String tXTN_TOT_AMNT_A) {
		TXTN_TOT_AMNT_A = tXTN_TOT_AMNT_A;
	}
	public void setFREE_DTY_TOT_AMT_A(String fREE_DTY_TOT_AMT_A) {
		FREE_DTY_TOT_AMT_A = fREE_DTY_TOT_AMT_A;
	}
	
	public void setTXTN_TOT_AMNT_B(String tXTN_TOT_AMNT_B) {
		TXTN_TOT_AMNT_B = tXTN_TOT_AMNT_B;
	}
	public void setFREE_DTY_TOT_AMT_B(String fREE_DTY_TOT_AMT_B) {
		FREE_DTY_TOT_AMT_B = fREE_DTY_TOT_AMT_B;
	}

	public void setTXTN_TOT_AMNT_C(String tXTN_TOT_AMNT_C) {
		TXTN_TOT_AMNT_C = tXTN_TOT_AMNT_C;
	}
	public void setFREE_DTY_TOT_AMT_C(String fREE_DTY_TOT_AMT_C) {
		FREE_DTY_TOT_AMT_C = fREE_DTY_TOT_AMT_C;
	}

	public void setTXTN_TOT_AMNT_D(String tXTN_TOT_AMNT_D) {
		TXTN_TOT_AMNT_D = tXTN_TOT_AMNT_D;
	}
	public void setFREE_DTY_TOT_AMT_D(String fREE_DTY_TOT_AMT_D) {
		FREE_DTY_TOT_AMT_D = fREE_DTY_TOT_AMT_D;
	}
	
	public void setTXTN_TOT_AMNT_E(String tXTN_TOT_AMNT_E) {
		TXTN_TOT_AMNT_E = tXTN_TOT_AMNT_E;
	}
	public void setFREE_DTY_TOT_AMT_E(String fREE_DTY_TOT_AMT_E) {
		FREE_DTY_TOT_AMT_E = fREE_DTY_TOT_AMT_E;
	}

	public void setTXTN_TOT_AMNT_F(String tXTN_TOT_AMNT_F) {
		TXTN_TOT_AMNT_F = tXTN_TOT_AMNT_F;
	}
	public void setFREE_DTY_TOT_AMT_F(String fREE_DTY_TOT_AMT_F) {
		FREE_DTY_TOT_AMT_F = fREE_DTY_TOT_AMT_F;
	}

//**---------------------2021년 하반기 간이세액명세서 양식변경 수정작업 (PDS-2022.01.11) END--**//	
	
	public void setKYBDR(String kYBDR) {
		KYBDR = kYBDR;
	}
	public void setINPT_DT(String iNPT_DT) {
		INPT_DT = iNPT_DT;
	}
	public void setINPT_ADDR(String iNPT_ADDR) {
		INPT_ADDR = iNPT_ADDR;
	}
	public void setISMT(String iSMT) {
		ISMT = iSMT;
	}
	public void setREVN_DT(String rEVN_DT) {
		REVN_DT = rEVN_DT;
	}
	public void setREVN_ADDR(String rEVN_ADDR) {
		REVN_ADDR = rEVN_ADDR;
	}
	public void setTEMPC_01(String tEMPC_01) {
		TEMPC_01 = tEMPC_01;
	}
	public void setTEMPC_02(String tEMPC_02) {
		TEMPC_02 = tEMPC_02;
	}
	public void setTEMPC_03(String tEMPC_03) {
		TEMPC_03 = tEMPC_03;
	}
	public void setTEMPN_01(String tEMPN_01) {
		TEMPN_01 = tEMPN_01;
	}
	public void setTEMPN_02(String tEMPN_02) {
		TEMPN_02 = tEMPN_02;
	}
	public void setTEMPN_03(String tEMPN_03) {
		TEMPN_03 = tEMPN_03;
	}
	public void setSrhYrtxBlggYr(String srhYrtxBlggYr) {
		SrhYrtxBlggYr = srhYrtxBlggYr;
	}
	public void setSrhClutSeptCd(String srhClutSeptCd) {
		SrhClutSeptCd = srhClutSeptCd;
	}
	public void setSrhPayrMangDeptCd(String srhPayrMangDeptCd) {
		SrhPayrMangDeptCd = srhPayrMangDeptCd;
	}
	public void setSrhEmymtDivCd(String srhEmymtDivCd) {
		SrhEmymtDivCd = srhEmymtDivCd;
	}
	public void setSrhDeptCd(String srhDeptCd) {
		SrhDeptCd = srhDeptCd;
	}
	public void setSrhTypOccuCd(String srhTypOccuCd) {
		SrhTypOccuCd = srhTypOccuCd;
	}
	public void setSrhDtilOccuInttnCd(String srhDtilOccuInttnCd) {
		SrhDtilOccuInttnCd = srhDtilOccuInttnCd;
	}
	public void setSrhBusinCd(String srhBusinCd) {
		SrhBusinCd = srhBusinCd;
	}
	public void setSrhUtDpobCd(String srhUtDpobCd) {
		SrhUtDpobCd = srhUtDpobCd;
	}
	public void setPayrMangDeptYn(String payrMangDeptYn) {
		PayrMangDeptYn = payrMangDeptYn;
	}
	public void setDeptCdAuth(String deptCdAuth) {
		DeptCdAuth = deptCdAuth;
	}
	public void setDtilOccuInttnCdAuth(String dtilOccuInttnCdAuth) {
		DtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}
	public void setUsrId(String usrId) {
		UsrId = usrId;
	}
	public void setDeptCdArr(List<String> deptCdArr) {
		DeptCdArr = deptCdArr;
	}
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		TypOccuCdArr = typOccuCdArr;
	}
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		DtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}
	public void setBusinCdArr(List<String> businCdArr) {
		BusinCdArr = businCdArr;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public void setDPOB_NM(String dPOB_NM) {
		DPOB_NM = dPOB_NM;
	}
	public void setTX_OFFC_CD(String tX_OFFC_CD) {
		TX_OFFC_CD = tX_OFFC_CD;
	}
	public void setBUSOPR_RGSTN_NUM(String bUSOPR_RGSTN_NUM) {
		BUSOPR_RGSTN_NUM = bUSOPR_RGSTN_NUM;
	}
	public void setDPOB_ZPCD(String dPOB_ZPCD) {
		DPOB_ZPCD = dPOB_ZPCD;
	}
	public void setDPOB_FNDTN_ADDR(String dPOB_FNDTN_ADDR) {
		DPOB_FNDTN_ADDR = dPOB_FNDTN_ADDR;
	}
	public void setDPOB_DTL_PATR_ADDR(String dPOB_DTL_PATR_ADDR) {
		DPOB_DTL_PATR_ADDR = dPOB_DTL_PATR_ADDR;
	}
	public void setDEGTR_NM(String dEGTR_NM) {
		DEGTR_NM = dEGTR_NM;
	}
	
	public void setCORP_RGSTN_NUM(String cORP_RGSTN_NUM) {
		CORP_RGSTN_NUM = cORP_RGSTN_NUM;
	}
	public void setDEPT_NM(String dEPT_NM) {
		DEPT_NM = dEPT_NM;
	}
	public void setUSR_NM(String uSR_NM) {
		USR_NM = uSR_NM;
	}
	public void setUSR_TEL(String uSR_TEL) {
		USR_TEL = uSR_TEL;
	}
	public void setSUBMIT_DATE(String sUBMIT_DATE) {
		SUBMIT_DATE = sUBMIT_DATE;
	}
	public void setHOMETAX_ID(String hOMETAX_ID) {
		HOMETAX_ID = hOMETAX_ID;
	}
	public void setSUBMITTER(String sUBMITTER) {
		SUBMITTER = sUBMITTER;
	}
	public void setTAX_AGENT_NO(String tAX_AGENT_NO) {
		TAX_AGENT_NO = tAX_AGENT_NO;
	}
	public void setTAX_PGM_CODE(String tAX_PGM_CODE) {
		TAX_PGM_CODE = tAX_PGM_CODE;
	}
	
	
}