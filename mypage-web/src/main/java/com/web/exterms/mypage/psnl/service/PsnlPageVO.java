package com.web.exterms.mypage.psnl.service;

/**
 * @Class Name : PsnlPageVO.java
 * @Description : PsnlPage VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.06
 * @version 1.0
 * @see
 * PSNL0100 
 *  Copyright (C)  All right reserved.
 */
public class PsnlPageVO extends PsnlPageDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD : 사업장코드*/
    private java.lang.String dpobCd;
    
    /** SYSTEMKEY : SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** HAN_NM : 한글성명 */
    private java.lang.String hanNm;
    
    /** ENG_NM : 영문성명 */
    private java.lang.String engNm;
    
    /** CHIN_CHAR_NM : 한문성명 */
    private java.lang.String chinCharNm;
    
    /** RESN_REGN_NUM : 주민등록번호 */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** KEY : 성별구분코드 */
    private java.lang.String key;
    
    /** GET_SUB_DATA_TYPE*/
    private java.lang.String getSubDataType;
    
    /** FAMY_RESN_REGN_NUM : 가족주민번호 */
    private java.lang.String famyResnRegnNum;
    
    /** SX_DIV_CD : 성별구분코드 */
    private java.lang.String sxDivCd;
    
    /** YOOBH_MNTH_DAY : 생년월일 */
    private java.lang.String yoobhMnthDay;
    
    /** SCLC_DIV_CD : 음양구분코드 */
    private java.lang.String sclcDivCd;
    
    /** NATN_CD : 국가코드 */
    private java.lang.String natnCd;
    
    /** DEPT_CD : 부서코드 */
    private java.lang.String deptCd;
    
    /** BUSIN_CD : 사업코드 */
    private java.lang.String businCd;
    
    /** CURR_AFFN_DEPT_CD : 현소속부서코드 */
    private java.lang.String currAffnDeptCd;
    
    /** REPBTY_BUSIN_DIV_CD : 담당업무구분코드 */
    private java.lang.String repbtyBusinDivCd;
    
    /** TYP_OCCU_CD : 직종코드 */
    private java.lang.String typOccuCd;
    
    /** ODTY_CD : 직책코드 */
    private java.lang.String odtyCd;
    
    /** FRST_EMYMT_DT : 최초고용일자 */
    private java.lang.String frstEmymtDt;
    
    /** EMYMT_DIV_CD : 고용구분코드 */
    private java.lang.String emymtDivCd;
    
    /** EMYMT_BGNN_DT : 고용시작일자 */
    private java.lang.String emymtBgnnDt;
    
    /** EMYMT_END_DT : 고용종료일자 */
    private java.lang.String emymtEndDt;
    
    /** PYSP_CD : 호봉코드 */
    private java.lang.String pyspCd;
    
    /** HDOFC_CODTN_CD : 재직상태코드 */
    private java.lang.String hdofcCodtnCd;
    
    /** RETRY_DT : 퇴직일자 */
    private java.lang.String retryDt;
    
    /** RETRY_REAS_CTNT : 퇴직사유내용 */
    private java.lang.String retryReasCtnt;
    
    /** FRGNR_DIV_CD : 외국인구분코드 */
    private java.lang.String frgnrDivCd;
    
    /** PSPT_NUM : 여권번호 */
    private java.lang.String psptNum;
    
    /** STY_BGNN_DT : 체류시작일자 */
    private java.lang.String styBgnnDt;
    
    /** STY_END_DT : 체류종료일자 */
    private java.lang.String styEndDt;
    
    /** END_SCHL : 최종학교 */
    private java.lang.String endSchl;
    
    /** END_DEGR_DIV_CD : 최종학위구분코드 */
    private java.lang.String endDegrDivCd;
    
    /** PMTN_SCDU_DT : 승진예정일자 */
    private java.lang.String pmtnScduDt;
    
    /** PYSP_PRMTN_SCDU_DT : 호봉승급예정일자 */
    private java.lang.String pyspPrmtnScduDt;
    
    /** HUS_ROAD_NM_FNDTN_NM_ADDR :  */
    private java.lang.String husRoadNmFndtnNmAddr;
    
    /** HUS_ROAD_NM_ZPCD :  */
    private java.lang.String husRoadNmZpcd;
    
    /** REYMN_SCDU_DT : 재고용예정일자 */
    private java.lang.String reymnScduDt;
    
    /** LOG_SVC_YR_NUM_CD : 근속년수코드 */
    private java.lang.String logSvcYrNumCd;
    
    /** LOG_SVC_MNTH_ICM_CD : 근속월수코드 */
    private java.lang.String logSvcMnthIcmCd;
    
    /** CURR_PYSP_APPMT_DT : 현_호봉발령일자 */
    private java.lang.String currPyspAppmtDt;
    
    /** CURR_DEPT_APPMT_DT : 현_부서발령일자 */
    private java.lang.String currDeptAppmtDt;
    
    /** PERN_NOTE_CTNT : 인사비고내용 */
    private java.lang.String pernNoteCtnt;
    
    /** KYBDR : 입력자 */
    private java.lang.String kybdr;
    
    /** INPT_DT : 입력일자  */
    private java.lang.String inptDt;
    
    /** INPT_ADDR : 입력주소 */
    private java.lang.String inptAddr;
    
    /** ISMT : 수정자 */
    private java.lang.String ismt;
    
    /** REVN_DT : 수정일자 */
    private java.lang.String revnDt;
    
    /** REVN_ADDR : 수정주소 */
    private java.lang.String revnAddr;
    
    /** PYSP_GRDE_CD : 호봉등급코드 */
    private java.lang.String pyspGrdeCd;
    
    /** DTIL_OCCU_CLS_DIV_CD : 직종세구분코드 */
    private java.lang.String dtilOccuClsDivCd;
    
    /** PIC_FLNM */
    private java.lang.String picFlnm;
    
    /** DPOB_NM :  */
    private java.lang.String dpobNm;
    
    /** CURR_AFFN_DEPT_NM :  */
    private java.lang.String currAffnDeptNm;
    
    /** CURR_PAE_WORK_NM :  */
    private java.lang.String currPaeWorkNm;
    
    /** BUSIN_NM :  */
    private java.lang.String businNm;
    
    /** TYP_OCCU_NM :  */
    private java.lang.String typOccuNm;
    
    /** DTIL_OCCU_CLS_DIV_NM :  */
    private java.lang.String dtilOccuClsDivNm;
    
    /** EMYMT_DIV_NM :  */
    private java.lang.String emymtDivNm;
    
    /** HDOFC_CODTN_NM :  */
    private java.lang.String hdofcCodtnNm;
    
    /** LOG_SVC_YR_NUM_NM :  */
    private java.lang.String logSvcYrNumNm;
    
    /** BASE_AR_NUM :  */
    private java.lang.String baseArNum;

	/** HUS_ROAD_NM_FNDTN_ADDR :  */
    private java.lang.String husRoadNmFndtnAddr;
    
    /** HUS_ROAD_NM_DTL_PATR_ADDR :  */
    private java.lang.String husRoadNmDtlPatrAddr;
    
    /** HUS_ZPCD :  */
    private java.lang.String husZpcd;
    
    /** HUS_FNDTN_ADDR :  */
    private java.lang.String husFndtnAddr;
    
    /** HUS_DTL_PATR_ADDR :  */
    private java.lang.String husDtlPatrAddr;
    
    /** HFMLY_NM :  */
    private java.lang.String hfmlyNm;
    
    /** HFMLY_RELA_NM :  */
    private java.lang.String hfmlyRelaNm;
    
    /** HUS_PHN_NUM :  */
    private java.lang.String husPhnNum;
    
    /** CELL_PHNE_NUM :  */
    private java.lang.String cellPhneNum;
    
    /** EMAIL_ADDR :  */
    private java.lang.String emailAddr;
    
    /** FAMY_RELA_DIV_NM :  */
    private java.lang.String famyRelaDivNm;
    
    /** FAMY_NM :  */
    private java.lang.String famyNm;
    
    /** ACAD_ABTY_DIV_NM :  */
    private java.lang.String acadAbtyDivNm;
    
    /** CRR_NM :  */
    private java.lang.String crrNm;
    
    /** WK_OFC_NM :  */
    private java.lang.String wkOfcNm;
    
    /** INBY_NM :  */
    private java.lang.String inbyNm;
        
    /** FRGNR_YN :  */
    private java.lang.String frgnrYn;
    
    /** DABTY_DIV_NM :  */
    private java.lang.String dabtyDivNm;
    
    /** DABTY_GRDE_NM :  */
    private java.lang.String dabtyGrdeNm;
    
	/** FAMY_ALLW_PYMT_YN :  */
    private java.lang.String famyAllwPymtYn;   
    
    /** ACCLD_PRTT_DT_YEAR :  */
    private java.lang.String accldPrttDtYear;  
    
    /** ACCLD_PRTT_DT_MONTH :  */    
    private java.lang.String accldPrttDtMonth;  
    
    /** ACCLD_PRTT_DT_DAY :  */    
    private java.lang.String accldPrttDtDay;  
    
    /** ACCLD_KND_CD :  */
    private java.lang.String accldKndCd;  
    
    /** ACCLD_DIV_CD :  */
    private java.lang.String accldDivCd;  
    
    /** ACCLD_NM :  */
    private java.lang.String accldNm;  
    
    /** ACCLD_CFMNT_NUM :  */
    private java.lang.String accldCfmntNum;  
    
    /** EFMN_ISTUT_NM :  */
    private java.lang.String efmnIstutNm;  
    
    /** ACCLD_MNANT_CTNT :  */
    private java.lang.String accldMnantCtnt;  
    
    /** ACCLD_NOTE_CTNT :  */
    private java.lang.String accldNoteCtnt;  
    
    /** DEPT_NM_ENG :  */
    private java.lang.String deptNmEng;  
    
    /** EMYMT_TYP_NM :  */
    private java.lang.String emymtTypNm;  
    
    /** DEPT_NM_RTCHNT :  */
    private java.lang.String deptNmRtchnt;  
    
    
    
    
    public java.lang.String getDeptNmEng() {
		return deptNmEng;
	}

	public void setDeptNmEng(java.lang.String deptNmEng) {
		this.deptNmEng = deptNmEng;
	}

	public java.lang.String getEmymtTypNm() {
		return emymtTypNm;
	}

	public void setEmymtTypNm(java.lang.String emymtTypNm) {
		this.emymtTypNm = emymtTypNm;
	}

	public java.lang.String getDeptNmRtchnt() {
		return deptNmRtchnt;
	}

	public void setDeptNmRtchnt(java.lang.String deptNmRtchnt) {
		this.deptNmRtchnt = deptNmRtchnt;
	}

	public java.lang.String getAccldPrttDtYear() {
		return accldPrttDtYear;
	}

	public void setAccldPrttDtYear(java.lang.String accldPrttDtYear) {
		this.accldPrttDtYear = accldPrttDtYear;
	}

	public java.lang.String getAccldPrttDtMonth() {
		return accldPrttDtMonth;
	}

	public void setAccldPrttDtMonth(java.lang.String accldPrttDtMonth) {
		this.accldPrttDtMonth = accldPrttDtMonth;
	}

	public java.lang.String getAccldPrttDtDay() {
		return accldPrttDtDay;
	}

	public void setAccldPrttDtDay(java.lang.String accldPrttDtDay) {
		this.accldPrttDtDay = accldPrttDtDay;
	}

	public java.lang.String getAccldKndCd() {
		return accldKndCd;
	}

	public void setAccldKndCd(java.lang.String accldKndCd) {
		this.accldKndCd = accldKndCd;
	}

	public java.lang.String getAccldDivCd() {
		return accldDivCd;
	}

	public void setAccldDivCd(java.lang.String accldDivCd) {
		this.accldDivCd = accldDivCd;
	}

	public java.lang.String getAccldNm() {
		return accldNm;
	}

	public void setAccldNm(java.lang.String accldNm) {
		this.accldNm = accldNm;
	}

	public java.lang.String getAccldCfmntNum() {
		return accldCfmntNum;
	}

	public void setAccldCfmntNum(java.lang.String accldCfmntNum) {
		this.accldCfmntNum = accldCfmntNum;
	}

	public java.lang.String getEfmnIstutNm() {
		return efmnIstutNm;
	}

	public void setEfmnIstutNm(java.lang.String efmnIstutNm) {
		this.efmnIstutNm = efmnIstutNm;
	}

	public java.lang.String getAccldMnantCtnt() {
		return accldMnantCtnt;
	}

	public void setAccldMnantCtnt(java.lang.String accldMnantCtnt) {
		this.accldMnantCtnt = accldMnantCtnt;
	}

	public java.lang.String getAccldNoteCtnt() {
		return accldNoteCtnt;
	}

	public void setAccldNoteCtnt(java.lang.String accldNoteCtnt) {
		this.accldNoteCtnt = accldNoteCtnt;
	}

	public java.lang.String getFamyRelaDivNm() {
		return famyRelaDivNm;
	}

	public void setFamyRelaDivNm(java.lang.String famyRelaDivNm) {
		this.famyRelaDivNm = famyRelaDivNm;
	}

	public java.lang.String getFamyNm() {
		return famyNm;
	}

	public void setFamyNm(java.lang.String famyNm) {
		this.famyNm = famyNm;
	}

	public java.lang.String getAcadAbtyDivNm() {
		return acadAbtyDivNm;
	}

	public void setAcadAbtyDivNm(java.lang.String acadAbtyDivNm) {
		this.acadAbtyDivNm = acadAbtyDivNm;
	}

	public java.lang.String getCrrNm() {
		return crrNm;
	}

	public void setCrrNm(java.lang.String crrNm) {
		this.crrNm = crrNm;
	}

	public java.lang.String getWkOfcNm() {
		return wkOfcNm;
	}

	public void setWkOfcNm(java.lang.String wkOfcNm) {
		this.wkOfcNm = wkOfcNm;
	}

	public java.lang.String getInbyNm() {
		return inbyNm;
	}

	public void setInbyNm(java.lang.String inbyNm) {
		this.inbyNm = inbyNm;
	}

	public java.lang.String getFrgnrYn() {
		return frgnrYn;
	}

	public void setFrgnrYn(java.lang.String frgnrYn) {
		this.frgnrYn = frgnrYn;
	}

	public java.lang.String getDabtyDivNm() {
		return dabtyDivNm;
	}

	public void setDabtyDivNm(java.lang.String dabtyDivNm) {
		this.dabtyDivNm = dabtyDivNm;
	}

	public java.lang.String getDabtyGrdeNm() {
		return dabtyGrdeNm;
	}

	public void setDabtyGrdeNm(java.lang.String dabtyGrdeNm) {
		this.dabtyGrdeNm = dabtyGrdeNm;
	}

	public java.lang.String getFamyAllwPymtYn() {
		return famyAllwPymtYn;
	}

	public void setFamyAllwPymtYn(java.lang.String famyAllwPymtYn) {
		this.famyAllwPymtYn = famyAllwPymtYn;
	}
    
    public java.lang.String getHusRoadNmFndtnAddr() {
		return husRoadNmFndtnAddr;
	}

	public void setHusRoadNmFndtnAddr(java.lang.String husRoadNmFndtnAddr) {
		this.husRoadNmFndtnAddr = husRoadNmFndtnAddr;
	}

	public java.lang.String getHusRoadNmDtlPatrAddr() {
		return husRoadNmDtlPatrAddr;
	}

	public void setHusRoadNmDtlPatrAddr(java.lang.String husRoadNmDtlPatrAddr) {
		this.husRoadNmDtlPatrAddr = husRoadNmDtlPatrAddr;
	}

	public java.lang.String getHusZpcd() {
		return husZpcd;
	}

	public void setHusZpcd(java.lang.String husZpcd) {
		this.husZpcd = husZpcd;
	}

	public java.lang.String getHusFndtnAddr() {
		return husFndtnAddr;
	}

	public void setHusFndtnAddr(java.lang.String husFndtnAddr) {
		this.husFndtnAddr = husFndtnAddr;
	}

	public java.lang.String getHusDtlPatrAddr() {
		return husDtlPatrAddr;
	}

	public void setHusDtlPatrAddr(java.lang.String husDtlPatrAddr) {
		this.husDtlPatrAddr = husDtlPatrAddr;
	}

	public java.lang.String getHfmlyNm() {
		return hfmlyNm;
	}

	public void setHfmlyNm(java.lang.String hfmlyNm) {
		this.hfmlyNm = hfmlyNm;
	}

	public java.lang.String getHfmlyRelaNm() {
		return hfmlyRelaNm;
	}

	public void setHfmlyRelaNm(java.lang.String hfmlyRelaNm) {
		this.hfmlyRelaNm = hfmlyRelaNm;
	}

	public java.lang.String getHusPhnNum() {
		return husPhnNum;
	}

	public void setHusPhnNum(java.lang.String husPhnNum) {
		this.husPhnNum = husPhnNum;
	}

	public java.lang.String getCellPhneNum() {
		return cellPhneNum;
	}

	public void setCellPhneNum(java.lang.String cellPhneNum) {
		this.cellPhneNum = cellPhneNum;
	}

	public java.lang.String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(java.lang.String emailAddr) {
		this.emailAddr = emailAddr;
	}
	
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }
    
    public java.lang.String getEngNm() {
        return this.engNm;
    }
    
    public void setEngNm(java.lang.String engNm) {
        this.engNm = engNm;
    }
    
    public java.lang.String getChinCharNm() {
        return this.chinCharNm;
    }
    
    public void setChinCharNm(java.lang.String chinCharNm) {
        this.chinCharNm = chinCharNm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.lang.String getSxDivCd() {
        return this.sxDivCd;
    }
    
    public void setSxDivCd(java.lang.String sxDivCd) {
        this.sxDivCd = sxDivCd;
    }
    
    public java.lang.String getYoobhMnthDay() {
        return this.yoobhMnthDay;
    }
    
    public void setYoobhMnthDay(java.lang.String yoobhMnthDay) {
        this.yoobhMnthDay = yoobhMnthDay;
    }
    
    public java.lang.String getSclcDivCd() {
        return this.sclcDivCd;
    }
    
    public void setSclcDivCd(java.lang.String sclcDivCd) {
        this.sclcDivCd = sclcDivCd;
    }
    
    public java.lang.String getNatnCd() {
        return this.natnCd;
    }
    
    public void setNatnCd(java.lang.String natnCd) {
        this.natnCd = natnCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getCurrAffnDeptCd() {
        return this.currAffnDeptCd;
    }
    
    public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
        this.currAffnDeptCd = currAffnDeptCd;
    }
    
    public java.lang.String getRepbtyBusinDivCd() {
        return this.repbtyBusinDivCd;
    }
    
    public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
        this.repbtyBusinDivCd = repbtyBusinDivCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getOdtyCd() {
        return this.odtyCd;
    }
    
    public void setOdtyCd(java.lang.String odtyCd) {
        this.odtyCd = odtyCd;
    }
    
    public java.lang.String getFrstEmymtDt() {
        return this.frstEmymtDt;
    }
    
    public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
        this.frstEmymtDt = frstEmymtDt;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getEmymtBgnnDt() {
        return this.emymtBgnnDt;
    }
    
    public void setEmymtBgnnDt(java.lang.String emymtBgnnDt) {
        this.emymtBgnnDt = emymtBgnnDt;
    }
    
    public java.lang.String getEmymtEndDt() {
        return this.emymtEndDt;
    }
    
    public void setEmymtEndDt(java.lang.String emymtEndDt) {
        this.emymtEndDt = emymtEndDt;
    }
    
    public java.lang.String getPyspCd() {
        return this.pyspCd;
    }
    
    public void setPyspCd(java.lang.String pyspCd) {
        this.pyspCd = pyspCd;
    }
    
    public java.lang.String getHdofcCodtnCd() {
        return this.hdofcCodtnCd;
    }
    
    public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
        this.hdofcCodtnCd = hdofcCodtnCd;
    }
    
    public java.lang.String getRetryDt() {
        return this.retryDt;
    }
    
    public void setRetryDt(java.lang.String retryDt) {
        this.retryDt = retryDt;
    }
    
    public java.lang.String getRetryReasCtnt() {
        return this.retryReasCtnt;
    }
    
    public void setRetryReasCtnt(java.lang.String retryReasCtnt) {
        this.retryReasCtnt = retryReasCtnt;
    }
    
    public java.lang.String getFrgnrDivCd() {
        return this.frgnrDivCd;
    }
    
    public void setFrgnrDivCd(java.lang.String frgnrDivCd) {
        this.frgnrDivCd = frgnrDivCd;
    }
    
    public java.lang.String getPsptNum() {
        return this.psptNum;
    }
    
    public void setPsptNum(java.lang.String psptNum) {
        this.psptNum = psptNum;
    }
    
    public java.lang.String getStyBgnnDt() {
        return this.styBgnnDt;
    }
    
    public void setStyBgnnDt(java.lang.String styBgnnDt) {
        this.styBgnnDt = styBgnnDt;
    }
    
    public java.lang.String getStyEndDt() {
        return this.styEndDt;
    }
    
    public void setStyEndDt(java.lang.String styEndDt) {
        this.styEndDt = styEndDt;
    }
    
    public java.lang.String getEndSchl() {
        return this.endSchl;
    }
    
    public void setEndSchl(java.lang.String endSchl) {
        this.endSchl = endSchl;
    }
    
    public java.lang.String getEndDegrDivCd() {
        return this.endDegrDivCd;
    }
    
    public void setEndDegrDivCd(java.lang.String endDegrDivCd) {
        this.endDegrDivCd = endDegrDivCd;
    }
    
    public java.lang.String getPmtnScduDt() {
        return this.pmtnScduDt;
    }
    
    public void setPmtnScduDt(java.lang.String pmtnScduDt) {
        this.pmtnScduDt = pmtnScduDt;
    }
    
    public java.lang.String getPyspPrmtnScduDt() {
        return this.pyspPrmtnScduDt;
    }
    
    public void setPyspPrmtnScduDt(java.lang.String pyspPrmtnScduDt) {
        this.pyspPrmtnScduDt = pyspPrmtnScduDt;
    }
    
    public java.lang.String getReymnScduDt() {
        return this.reymnScduDt;
    }
    
    public void setReymnScduDt(java.lang.String reymnScduDt) {
        this.reymnScduDt = reymnScduDt;
    }
    
    public java.lang.String getLogSvcYrNumCd() {
        return this.logSvcYrNumCd;
    }
    
    public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
        this.logSvcYrNumCd = logSvcYrNumCd;
    }
    
    public java.lang.String getLogSvcMnthIcmCd() {
        return this.logSvcMnthIcmCd;
    }
    
    public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
        this.logSvcMnthIcmCd = logSvcMnthIcmCd;
    }
    
    public java.lang.String getCurrPyspAppmtDt() {
        return this.currPyspAppmtDt;
    }
    
    public void setCurrPyspAppmtDt(java.lang.String currPyspAppmtDt) {
        this.currPyspAppmtDt = currPyspAppmtDt;
    }
    
    public java.lang.String getCurrDeptAppmtDt() {
        return this.currDeptAppmtDt;
    }
    
    public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
        this.currDeptAppmtDt = currDeptAppmtDt;
    }
    
    public java.lang.String getPernNoteCtnt() {
        return this.pernNoteCtnt;
    }
    
    public void setPernNoteCtnt(java.lang.String pernNoteCtnt) {
        this.pernNoteCtnt = pernNoteCtnt;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
    public java.lang.String getPyspGrdeCd() {
        return this.pyspGrdeCd;
    }
    
    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }

	/**
	 * Comment : 주민번호 오리지날
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 주민번호 오리지날
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getKey() {
		return key;
	}

	public void setKey(java.lang.String key) {
		this.key = key;
	}

	public java.lang.String getFamyResnRegnNum() {
		return famyResnRegnNum;
	}

	public void setFamyResnRegnNum(java.lang.String famyResnRegnNum) {
		this.famyResnRegnNum = famyResnRegnNum;
	}

	public java.lang.String getGetSubDataType() {
		return getSubDataType;
	}

	public void setGetSubDataType(java.lang.String getSubDataType) {
		this.getSubDataType = getSubDataType;
	}

	public java.lang.String getPicFlnm() {
		return picFlnm;
	}

	public void setPicFlnm(java.lang.String picFlnm) {
		this.picFlnm = picFlnm;
	}

	public java.lang.String getDpobNm() {
		return dpobNm;
	}

	public void setDpobNm(java.lang.String dpobNm) {
		this.dpobNm = dpobNm;
	}

	public java.lang.String getCurrAffnDeptNm() {
		return currAffnDeptNm;
	}

	public void setCurrAffnDeptNm(java.lang.String currAffnDeptNm) {
		this.currAffnDeptNm = currAffnDeptNm;
	}

	public java.lang.String getCurrPaeWorkNm() {
		return currPaeWorkNm;
	}

	public void setCurrPaeWorkNm(java.lang.String currPaeWorkNm) {
		this.currPaeWorkNm = currPaeWorkNm;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public java.lang.String getDtilOccuClsDivNm() {
		return dtilOccuClsDivNm;
	}

	public void setDtilOccuClsDivNm(java.lang.String dtilOccuClsDivNm) {
		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
	}

	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}

	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

	public java.lang.String getHdofcCodtnNm() {
		return hdofcCodtnNm;
	}

	public void setHdofcCodtnNm(java.lang.String hdofcCodtnNm) {
		this.hdofcCodtnNm = hdofcCodtnNm;
	}

	public java.lang.String getLogSvcYrNumNm() {
		return logSvcYrNumNm;
	}

	public void setLogSvcYrNumNm(java.lang.String logSvcYrNumNm) {
		this.logSvcYrNumNm = logSvcYrNumNm;
	}

	public java.lang.String getBaseArNum() {
		return baseArNum;
	}

	public void setBaseArNum(java.lang.String baseArNum) {
		this.baseArNum = baseArNum;
	}

	public java.lang.String getHusRoadNmZpcd() {
		return husRoadNmZpcd;
	}

	public void setHusRoadNmZpcd(java.lang.String husRoadNmZpcd) {
		this.husRoadNmZpcd = husRoadNmZpcd;
	}

	public java.lang.String getHusRoadNmFndtnNmAddr() {
		return husRoadNmFndtnNmAddr;
	}

	public void setHusRoadNmFndtnNmAddr(java.lang.String husRoadNmFndtnNmAddr) {
		this.husRoadNmFndtnNmAddr = husRoadNmFndtnNmAddr;
	}
    
}
