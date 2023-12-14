package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class Insr3200ExcelVO extends AbstractVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<Insr3200ExcelVO> insr3200List = new ArrayList<Insr3200ExcelVO>();
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DPOB_CD 사업장코드*/
    private java.lang.String dpobCd;
    
    /** NOFCT_YR_MNTH 고지년월*/
    private java.lang.String nofctYrMnth;

    /**  emymtSeilNum  고용일련번호 */
  	private java.lang.String  emymtSeilNum;
  	
    /** DPOB_MANGE_NUM 사업장 관리번호 */
    private java.lang.String dpobMangeNum;
    
    /** UNT_ISTUT_CD 단위기관코드 */
    private java.lang.String untIstutCd;
 
    /** NOFCT_DSPTY 고지차수 */
    private java.lang.String nofctDspty;
    
    /** ACC_SGN 회계부호*/
    private java.lang.String accSgn;
    
    /** HLTH_INSR_CERT_NUM 건강보험증번호*/
    private java.lang.String hlthInsrCertNum;
    
    /** HAN_NM 한글성명*/
    private java.lang.String hanNm;
    
    /** RESN_REGN_NUM 주민등록번호*/
    private java.lang.String resnRegnNum;
    
    /** REDU_REAS_CD 감면사유코드*/
    private java.lang.String reduReasCd;
    
    /** REDU_REAS_NM 감면사유코드명*/
    private java.lang.String reduReasNm;
    
    /** HLTH_INSR_TYP_OCCU_CD 건강보험직종코드*/
    private java.lang.String hlthInsrTypOccuCd;
    
    /** PAY_MNTH_AMNT_GRDE 보수월액등급*/
    private java.lang.String payMnthAmntGrde;
    
    /** PAY_MNTH_AMNT 보수월액*/
    private java.lang.String payMnthAmnt;
    
    /** CALC_PRMM 산출보험료*/
    private java.lang.String calcPrmm;
    
    /** CLUT_REAS_CD 정산사유코드 */
    private java.lang.String clutReasCd;
    
    /** CLUT_APPTN_TERMS 정산적용기간*/
    private java.lang.String clutApptnTerms;
    
    /** CLUT_APPTN_BGNN_YR_MNTH 정산적용시작년월*/
    private java.lang.String clutApptnBgnnYrMnth;
    
    /** CLUT_APPTN_END_YR_MNTH 정산적용종료년월*/
    private java.lang.String clutApptnEndYrMnth;
    
    /** CLUT_PRMM 정산보험료*/
    private java.lang.String clutPrmm;
    
    /** NOFCT_PRMM 고지보험료*/
    private java.lang.String nofctPrmm;
    
    /** YRTX_PRMM 연말정산보험료*/
    private java.lang.String yrtxPrmm;
    
    /** AQTN_DT 취득일자*/
    private java.lang.String aqtnDt;
    
    /** LSS_DT 상실일자*/
    private java.lang.String lssDt;
    
    /** LGTM_RCPTN_CALC_PRMM 요양산출보험료*/
    private java.lang.String lgtmRcptnCalcPrmm;

    /** LGTM_RCPTN_CLUT_REAS_CD 요양정산사유코드*/
    private java.lang.String lgtmRcptnClutReasCd;
 
    /** LGTM_RCPTN_APPTN_TERMS 요양정산적용기간*/
    private java.lang.String lgtmRcptnApptnTerms;
    
    /** LGTM_RCPTN_APPTN_BGNN_YR_MNTH 요양정산적용시작년월*/
    private java.lang.String lgtmRcptnApptnBgnnYrMnth;
    
    /** LGTM_RCPTN_APPTN_END_YR_MNTH 요양정산적용종료년월*/
    private java.lang.String lgtmRcptnApptnEndYrMnth;
    
    /** LGTM_RCPTN_CLUT_PRMM 요양정산보험료*/
    private java.lang.String lgtmRcptnClutPrmm;
    
    /** LGTM_RCPTN_NOFCT_PRMM 요양고지보험료*/
    private java.lang.String lgtmRcptnNofctPrmm;
    
    /** LGTM_RCPTN_YRTX_PRMM 요양연말정산보험료*/
    private java.lang.String lgtmRcptnYrtxPrmm;
    
    /** HLTH_RCPTN_CALC_PRMM 건강_요양산출보험료계*/
    private java.lang.String hlthRcptnCalcPrmm;
    
    /** HLTH_RCPTN_CLUT_PRMM 건강_요양정산보험료계*/
    private java.lang.String hlthRcptnClutPrmm;
    
    /** HLTH_RCPTN_NOFCT_PRMM 건강_요양고지보험료계*/
    private java.lang.String hlthRcptnNofctPrmm;
    
    /** HLTH_RCPTN_YRTX_PRMM 건강_요양연말정산보험료계*/
    private java.lang.String hlthRcptnYrtxPrmm;
    
    /** HLTH_INSR_REFD_ITRT 건강환급금이자*/
    private java.lang.String hlthInsrRefdItrt;
    
    /** LGTM_RCPTN_REFD_ITRT 요양환급금이자*/
    private java.lang.String lgtmRcptnRefdItrt;
    
    /** TOT_PYMT_PRMM 총납부보험료*/
    private java.lang.String totPymtPrmm;
    
    /** DDUC_YR_MNTH 공제년월*/
    private java.lang.String dducYrMnth;
    
    /** KYBDR 입력자*/
    private java.lang.String kybdr;
    
    /** INPT_DT 입력일자*/
    private java.lang.String inptDt;
    
    /** INPT_ADDR 입력주소 */
    private java.lang.String inptAddr;
    
    /** ISMT 수정자*/
    private java.lang.String ismt;
    
    /** REVN_DT 수정일자*/
    private java.lang.String revnDt;
    
    /** REVN_ADDR 수정주소*/
    private java.lang.String revnAddr;
    
  
    
    /** HLTH_INSR_PRCS_YN 건강보험처리여부 */
    private java.lang.String hlthInsrPrcsYn;
    
    /** HLTH_INSR_PRMM_SRD 건강보험보험료차액*/
    private java.lang.String hlthInsrPrmmSrd;

    /** LGTM_RCPTN_INSUR_SRD 장기요양보험차액*/
    private java.lang.String lgtmRcptnInsurSrd;
 
    /** SRD_AGGR_SUM 차액합계*/
    private java.lang.String srdAggrSum;
    
    /** SAN_CALC_PRMM  */
    private java.lang.String sanCalcPrmm;
 
    /** SAN_LGTM_RCPTN_CALC_PRMM */
    private java.lang.String sanLgtmRcptnCalcPrmm;
    
    /** set 급여산출건강보험금액 : payCalcHlthInsrSum */
    private java.lang.String payCalcHlthInsrSum;
    
	/** set 급여산출요양보험금액 : payCalcRcptnInsurSum */
    private java.lang.String payCalcRcptnInsurSum;


    public java.lang.String getPayCalcHlthInsrSum() {
		return payCalcHlthInsrSum;
	}

	public void setPayCalcHlthInsrSum(java.lang.String payCalcHlthInsrSum) {
		this.payCalcHlthInsrSum = payCalcHlthInsrSum;
	}

	public java.lang.String getPayCalcRcptnInsurSum() {
		return payCalcRcptnInsurSum;
	}

	public void setPayCalcRcptnInsurSum(java.lang.String payCalcRcptnInsurSum) {
		this.payCalcRcptnInsurSum = payCalcRcptnInsurSum;
	}

    public java.lang.String getClutApptnTerms() {
		return clutApptnTerms;
	}

	public void setClutApptnTerms(java.lang.String clutApptnTerms) {
		this.clutApptnTerms = clutApptnTerms;
	}

	public java.lang.String getLgtmRcptnApptnTerms() {
		return lgtmRcptnApptnTerms;
	}

	public void setLgtmRcptnApptnTerms(java.lang.String lgtmRcptnApptnTerms) {
		this.lgtmRcptnApptnTerms = lgtmRcptnApptnTerms;
	}

	public List<Insr3200ExcelVO> getInsr3200List() {
		return insr3200List;
	}

	public void setInsr3200List(List<Insr3200ExcelVO> insr3200List) {
		this.insr3200List = insr3200List;
	}
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getNofctYrMnth() {
        return this.nofctYrMnth;
    }
    
    public void setNofctYrMnth(java.lang.String nofctYrMnth) {
        this.nofctYrMnth = nofctYrMnth;
    }
    
    public java.lang.String getNofctDspty() {
        return this.nofctDspty;
    }
    
    public void setNofctDspty(java.lang.String nofctDspty) {
        this.nofctDspty = nofctDspty;
    }
    
//    public java.lang.String getHlthInsrSeilNum() {
//        return this.hlthInsrSeilNum;
//    }
//    
//    public void setHlthInsrSeilNum(java.lang.String hlthInsrSeilNum) {
//        this.hlthInsrSeilNum = hlthInsrSeilNum;
//    }
    
    
    public java.lang.String getDpobMangeNum() {
        return this.dpobMangeNum;
    }
    
    /**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public java.lang.String getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(java.lang.String emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public void setDpobMangeNum(java.lang.String dpobMangeNum) {
        this.dpobMangeNum = dpobMangeNum;
    }
    
    public java.lang.String getUntIstutCd() {
        return this.untIstutCd;
    }
    
    public void setUntIstutCd(java.lang.String untIstutCd) {
        this.untIstutCd = untIstutCd;
    }
    
    public java.lang.String getAccSgn() {
        return this.accSgn;
    }
    
    public void setAccSgn(java.lang.String accSgn) {
        this.accSgn = accSgn;
    }
    
    public java.lang.String getHlthInsrCertNum() {
        return this.hlthInsrCertNum;
    }
    
    public void setHlthInsrCertNum(java.lang.String hlthInsrCertNum) {
        this.hlthInsrCertNum = hlthInsrCertNum;
    }
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.lang.String getReduReasCd() {
        return this.reduReasCd;
    }
    
    public void setReduReasCd(java.lang.String reduReasCd) {
        this.reduReasCd = reduReasCd;
    }
    
    public java.lang.String getReduReasNm() {
        return this.reduReasNm;
    }
    
    public void setReduReasNm(java.lang.String reduReasNm) {
        this.reduReasNm = reduReasNm;
    }
    
    public java.lang.String getHlthInsrTypOccuCd() {
        return this.hlthInsrTypOccuCd;
    }
    
    public void setHlthInsrTypOccuCd(java.lang.String hlthInsrTypOccuCd) {
        this.hlthInsrTypOccuCd = hlthInsrTypOccuCd;
    }
    
    public java.lang.String getPayMnthAmntGrde() {
        return this.payMnthAmntGrde;
    }
    
    public void setPayMnthAmntGrde(java.lang.String payMnthAmntGrde) {
        this.payMnthAmntGrde = payMnthAmntGrde;
    }
    
    public java.lang.String getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(java.lang.String payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public java.lang.String getHlthInsrPrcsYn() {
        return this.hlthInsrPrcsYn;
    }
    
    public void setHlthInsrPrcsYn(java.lang.String hlthInsrPrcsYn) {
        this.hlthInsrPrcsYn = hlthInsrPrcsYn;
    }
    
    public java.lang.String getCalcPrmm() {
        return this.calcPrmm;
    }
    
    public void setCalcPrmm(java.lang.String calcPrmm) {
        this.calcPrmm = calcPrmm;
    }
    
    public java.lang.String getSanCalcPrmm() {
        return this.sanCalcPrmm;
    }
    
    public void setSanCalcPrmm(java.lang.String sanCalcPrmm) {
        this.sanCalcPrmm = sanCalcPrmm;
    }
    
    public java.lang.String getHlthInsrPrmmSrd() {
        return this.hlthInsrPrmmSrd;
    }
    
    public void setHlthInsrPrmmSrd(java.lang.String hlthInsrPrmmSrd) {
        this.hlthInsrPrmmSrd = hlthInsrPrmmSrd;
    }
    
    public java.lang.String getClutReasCd() {
        return this.clutReasCd;
    }
    
    public void setClutReasCd(java.lang.String clutReasCd) {
        this.clutReasCd = clutReasCd;
    }
    
    public java.lang.String getClutApptnBgnnYrMnth() {
        return this.clutApptnBgnnYrMnth;
    }
    
    public void setClutApptnBgnnYrMnth(java.lang.String clutApptnBgnnYrMnth) {
        this.clutApptnBgnnYrMnth = clutApptnBgnnYrMnth;
    }
    
    public java.lang.String getClutApptnEndYrMnth() {
        return this.clutApptnEndYrMnth;
    }
    
    public void setClutApptnEndYrMnth(java.lang.String clutApptnEndYrMnth) {
        this.clutApptnEndYrMnth = clutApptnEndYrMnth;
    }
    
    public java.lang.String getClutPrmm() {
        return this.clutPrmm;
    }
    
    public void setClutPrmm(java.lang.String clutPrmm) {
        this.clutPrmm = clutPrmm;
    }
    
    public java.lang.String getNofctPrmm() {
        return this.nofctPrmm;
    }
    
    public void setNofctPrmm(java.lang.String nofctPrmm) {
        this.nofctPrmm = nofctPrmm;
    }
    
    public java.lang.String getYrtxPrmm() {
        return this.yrtxPrmm;
    }
    
    public void setYrtxPrmm(java.lang.String yrtxPrmm) {
        this.yrtxPrmm = yrtxPrmm;
    }
    
    public java.lang.String getAqtnDt() {
        return this.aqtnDt;
    }
    
    public void setAqtnDt(java.lang.String aqtnDt) {
        this.aqtnDt = aqtnDt;
    }
    
    public java.lang.String getLssDt() {
        return this.lssDt;
    }
    
    public void setLssDt(java.lang.String lssDt) {
        this.lssDt = lssDt;
    }
    
    public java.lang.String getLgtmRcptnCalcPrmm() {
        return this.lgtmRcptnCalcPrmm;
    }
    
    public void setLgtmRcptnCalcPrmm(java.lang.String lgtmRcptnCalcPrmm) {
        this.lgtmRcptnCalcPrmm = lgtmRcptnCalcPrmm;
    }
    
    public java.lang.String getSanLgtmRcptnCalcPrmm() {
        return this.sanLgtmRcptnCalcPrmm;
    }
    
    public void setSanLgtmRcptnCalcPrmm(java.lang.String sanLgtmRcptnCalcPrmm) {
        this.sanLgtmRcptnCalcPrmm = sanLgtmRcptnCalcPrmm;
    }
    
    public java.lang.String getLgtmRcptnInsurSrd() {
        return this.lgtmRcptnInsurSrd;
    }
    
    public void setLgtmRcptnInsurSrd(java.lang.String lgtmRcptnInsurSrd) {
        this.lgtmRcptnInsurSrd = lgtmRcptnInsurSrd;
    }
    
    public java.lang.String getLgtmRcptnClutReasCd() {
        return this.lgtmRcptnClutReasCd;
    }
    
    public void setLgtmRcptnClutReasCd(java.lang.String lgtmRcptnClutReasCd) {
        this.lgtmRcptnClutReasCd = lgtmRcptnClutReasCd;
    }
    
    public java.lang.String getLgtmRcptnApptnBgnnYrMnth() {
        return this.lgtmRcptnApptnBgnnYrMnth;
    }
    
    public void setLgtmRcptnApptnBgnnYrMnth(java.lang.String lgtmRcptnApptnBgnnYrMnth) {
        this.lgtmRcptnApptnBgnnYrMnth = lgtmRcptnApptnBgnnYrMnth;
    }
    
    public java.lang.String getLgtmRcptnApptnEndYrMnth() {
        return this.lgtmRcptnApptnEndYrMnth;
    }
    
    public void setLgtmRcptnApptnEndYrMnth(java.lang.String lgtmRcptnApptnEndYrMnth) {
        this.lgtmRcptnApptnEndYrMnth = lgtmRcptnApptnEndYrMnth;
    }
    
    public java.lang.String getLgtmRcptnClutPrmm() {
        return this.lgtmRcptnClutPrmm;
    }
    
    public void setLgtmRcptnClutPrmm(java.lang.String lgtmRcptnClutPrmm) {
        this.lgtmRcptnClutPrmm = lgtmRcptnClutPrmm;
    }
    
    public java.lang.String getLgtmRcptnNofctPrmm() {
        return this.lgtmRcptnNofctPrmm;
    }
    
    public void setLgtmRcptnNofctPrmm(java.lang.String lgtmRcptnNofctPrmm) {
        this.lgtmRcptnNofctPrmm = lgtmRcptnNofctPrmm;
    }
    
    public java.lang.String getLgtmRcptnYrtxPrmm() {
        return this.lgtmRcptnYrtxPrmm;
    }
    
    public void setLgtmRcptnYrtxPrmm(java.lang.String lgtmRcptnYrtxPrmm) {
        this.lgtmRcptnYrtxPrmm = lgtmRcptnYrtxPrmm;
    }
    
    public java.lang.String getHlthRcptnCalcPrmm() {
        return this.hlthRcptnCalcPrmm;
    }
    
    public void setHlthRcptnCalcPrmm(java.lang.String hlthRcptnCalcPrmm) {
        this.hlthRcptnCalcPrmm = hlthRcptnCalcPrmm;
    }
    
    public java.lang.String getHlthRcptnClutPrmm() {
        return this.hlthRcptnClutPrmm;
    }
    
    public void setHlthRcptnClutPrmm(java.lang.String hlthRcptnClutPrmm) {
        this.hlthRcptnClutPrmm = hlthRcptnClutPrmm;
    }
    
    public java.lang.String getHlthRcptnNofctPrmm() {
        return this.hlthRcptnNofctPrmm;
    }
    
    public void setHlthRcptnNofctPrmm(java.lang.String hlthRcptnNofctPrmm) {
        this.hlthRcptnNofctPrmm = hlthRcptnNofctPrmm;
    }
    
    public java.lang.String getHlthRcptnYrtxPrmm() {
        return this.hlthRcptnYrtxPrmm;
    }
    
    public void setHlthRcptnYrtxPrmm(java.lang.String hlthRcptnYrtxPrmm) {
        this.hlthRcptnYrtxPrmm = hlthRcptnYrtxPrmm;
    }
    
    public java.lang.String getHlthInsrRefdItrt() {
        return this.hlthInsrRefdItrt;
    }
    
    public void setHlthInsrRefdItrt(java.lang.String hlthInsrRefdItrt) {
        this.hlthInsrRefdItrt = hlthInsrRefdItrt;
    }
    
    public java.lang.String getLgtmRcptnRefdItrt() {
        return this.lgtmRcptnRefdItrt;
    }
    
    public void setLgtmRcptnRefdItrt(java.lang.String lgtmRcptnRefdItrt) {
        this.lgtmRcptnRefdItrt = lgtmRcptnRefdItrt;
    }
    
    public java.lang.String getTotPymtPrmm() {
        return this.totPymtPrmm;
    }
    
    public void setTotPymtPrmm(java.lang.String totPymtPrmm) {
        this.totPymtPrmm = totPymtPrmm;
    }
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
    }
    
    public java.lang.String getSrdAggrSum() {
        return this.srdAggrSum;
    }
    
    public void setSrdAggrSum(java.lang.String srdAggrSum) {
        this.srdAggrSum = srdAggrSum;
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
    
}