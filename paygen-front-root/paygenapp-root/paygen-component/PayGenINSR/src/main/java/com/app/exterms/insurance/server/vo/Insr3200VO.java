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
public class Insr3200VO extends AbstractVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<Insr3200VO> insr3200List = new ArrayList<Insr3200VO>();
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DPOB_CD 사업장코드*/
    private java.lang.String dpobCd;
    
    /** NOFCT_YR_MNTH 고지년월*/
    private java.lang.String nofctYrMnth;

    /**  emymtSeilNum  고용일련번호 */
  	private Long  emymtSeilNum;
  	
    /** DPOB_MANGE_NUM 사업장 관리번호 */
    private java.lang.String dpobMangeNum;
    
    /** UNT_ISTUT_CD 단위기관코드 */
    private java.lang.String untIstutCd;
 
    /** NOFCT_DSPTY 고지차수 */
    private Long nofctDspty;
    
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
    private Long payMnthAmnt;
    
    /** CALC_PRMM 산출보험료*/
    private Long calcPrmm;
    
    /** CLUT_REAS_CD 정산사유코드 */
    private java.lang.String clutReasCd;
    
    /** CLUT_APPTN_TERMS 정산적용기간*/
    private java.lang.String clutApptnTerms;
    
    /** CLUT_APPTN_BGNN_YR_MNTH 정산적용시작년월*/
    private java.lang.String clutApptnBgnnYrMnth;
    
    /** CLUT_APPTN_END_YR_MNTH 정산적용종료년월*/
    private java.lang.String clutApptnEndYrMnth;
    
    /** CLUT_PRMM 정산보험료*/
    private Long clutPrmm;
    
    /** NOFCT_PRMM 고지보험료*/
    private Long nofctPrmm;
    
    /** YRTX_PRMM 연말정산보험료*/
    private Long yrtxPrmm;
    
    /** AQTN_DT 취득일자*/
    private java.lang.String aqtnDt;
    
    /** LSS_DT 상실일자*/
    private java.lang.String lssDt;
    
    /** LGTM_RCPTN_CALC_PRMM 요양산출보험료*/
    private Long lgtmRcptnCalcPrmm;

    /** LGTM_RCPTN_CLUT_REAS_CD 요양정산사유코드*/
    private java.lang.String lgtmRcptnClutReasCd;
 
    /** LGTM_RCPTN_APPTN_TERMS 요양정산적용기간*/
    private java.lang.String lgtmRcptnApptnTerms;
    
    /** LGTM_RCPTN_APPTN_BGNN_YR_MNTH 요양정산적용시작년월*/
    private java.lang.String lgtmRcptnApptnBgnnYrMnth;
    
    /** LGTM_RCPTN_APPTN_END_YR_MNTH 요양정산적용종료년월*/
    private java.lang.String lgtmRcptnApptnEndYrMnth;
    
    /** LGTM_RCPTN_CLUT_PRMM 요양정산보험료*/
    private Long lgtmRcptnClutPrmm;
    
    /** LGTM_RCPTN_NOFCT_PRMM 요양고지보험료*/
    private Long lgtmRcptnNofctPrmm;
    
    /** LGTM_RCPTN_YRTX_PRMM 요양연말정산보험료*/
    private Long lgtmRcptnYrtxPrmm;
    
    /** HLTH_RCPTN_CALC_PRMM 건강_요양산출보험료계*/
    private Long hlthRcptnCalcPrmm;
    
    /** HLTH_RCPTN_CLUT_PRMM 건강_요양정산보험료계*/
    private Long hlthRcptnClutPrmm;
    
    /** HLTH_RCPTN_NOFCT_PRMM 건강_요양고지보험료계*/
    private Long hlthRcptnNofctPrmm;
    
    /** HLTH_RCPTN_YRTX_PRMM 건강_요양연말정산보험료계*/
    private Long hlthRcptnYrtxPrmm;
    
    /** HLTH_INSR_REFD_ITRT 건강환급금이자*/
    private Long hlthInsrRefdItrt;
    
    /** LGTM_RCPTN_REFD_ITRT 요양환급금이자*/
    private Long lgtmRcptnRefdItrt;
    
    /** TOT_PYMT_PRMM 총납부보험료*/
    private Long totPymtPrmm;
    
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
    private Long hlthInsrPrmmSrd;

    /** LGTM_RCPTN_INSUR_SRD 장기요양보험차액*/
    private Long lgtmRcptnInsurSrd;
 
    /** SRD_AGGR_SUM 차액합계*/
    private Long srdAggrSum;
    
    /** SAN_CALC_PRMM  */
    private Long sanCalcPrmm;
 
    /** SAN_LGTM_RCPTN_CALC_PRMM */
    private Long sanLgtmRcptnCalcPrmm;
    
    /** set 급여산출건강보험금액 : payCalcHlthInsrSum */
    private Long payCalcHlthInsrSum;
    
	/** set 급여산출요양보험금액 : payCalcRcptnInsurSum */
    private Long payCalcRcptnInsurSum;


    public Long getPayCalcHlthInsrSum() {
		return payCalcHlthInsrSum;
	}

	public void setPayCalcHlthInsrSum(Long payCalcHlthInsrSum) {
		this.payCalcHlthInsrSum = payCalcHlthInsrSum;
	}

	public Long getPayCalcRcptnInsurSum() {
		return payCalcRcptnInsurSum;
	}

	public void setPayCalcRcptnInsurSum(Long payCalcRcptnInsurSum) {
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

	public List<Insr3200VO> getInsr3200List() {
		return insr3200List;
	}

	public void setInsr3200List(List<Insr3200VO> insr3200List) {
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
    
    public Long getNofctDspty() {
        return this.nofctDspty;
    }
    
    public void setNofctDspty(Long nofctDspty) {
        this.nofctDspty = nofctDspty;
    }
    
//    public Long getHlthInsrSeilNum() {
//        return this.hlthInsrSeilNum;
//    }
//    
//    public void setHlthInsrSeilNum(Long hlthInsrSeilNum) {
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
	public Long getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(Long emymtSeilNum) {
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
    
    public Long getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(Long payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public java.lang.String getHlthInsrPrcsYn() {
        return this.hlthInsrPrcsYn;
    }
    
    public void setHlthInsrPrcsYn(java.lang.String hlthInsrPrcsYn) {
        this.hlthInsrPrcsYn = hlthInsrPrcsYn;
    }
    
    public Long getCalcPrmm() {
        return this.calcPrmm;
    }
    
    public void setCalcPrmm(Long calcPrmm) {
        this.calcPrmm = calcPrmm;
    }
    
    public Long getSanCalcPrmm() {
        return this.sanCalcPrmm;
    }
    
    public void setSanCalcPrmm(Long sanCalcPrmm) {
        this.sanCalcPrmm = sanCalcPrmm;
    }
    
    public Long getHlthInsrPrmmSrd() {
        return this.hlthInsrPrmmSrd;
    }
    
    public void setHlthInsrPrmmSrd(Long hlthInsrPrmmSrd) {
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
    
    public Long getClutPrmm() {
        return this.clutPrmm;
    }
    
    public void setClutPrmm(Long clutPrmm) {
        this.clutPrmm = clutPrmm;
    }
    
    public Long getNofctPrmm() {
        return this.nofctPrmm;
    }
    
    public void setNofctPrmm(Long nofctPrmm) {
        this.nofctPrmm = nofctPrmm;
    }
    
    public Long getYrtxPrmm() {
        return this.yrtxPrmm;
    }
    
    public void setYrtxPrmm(Long yrtxPrmm) {
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
    
    public Long getLgtmRcptnCalcPrmm() {
        return this.lgtmRcptnCalcPrmm;
    }
    
    public void setLgtmRcptnCalcPrmm(Long lgtmRcptnCalcPrmm) {
        this.lgtmRcptnCalcPrmm = lgtmRcptnCalcPrmm;
    }
    
    public Long getSanLgtmRcptnCalcPrmm() {
        return this.sanLgtmRcptnCalcPrmm;
    }
    
    public void setSanLgtmRcptnCalcPrmm(Long sanLgtmRcptnCalcPrmm) {
        this.sanLgtmRcptnCalcPrmm = sanLgtmRcptnCalcPrmm;
    }
    
    public Long getLgtmRcptnInsurSrd() {
        return this.lgtmRcptnInsurSrd;
    }
    
    public void setLgtmRcptnInsurSrd(Long lgtmRcptnInsurSrd) {
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
    
    public Long getLgtmRcptnClutPrmm() {
        return this.lgtmRcptnClutPrmm;
    }
    
    public void setLgtmRcptnClutPrmm(Long lgtmRcptnClutPrmm) {
        this.lgtmRcptnClutPrmm = lgtmRcptnClutPrmm;
    }
    
    public Long getLgtmRcptnNofctPrmm() {
        return this.lgtmRcptnNofctPrmm;
    }
    
    public void setLgtmRcptnNofctPrmm(Long lgtmRcptnNofctPrmm) {
        this.lgtmRcptnNofctPrmm = lgtmRcptnNofctPrmm;
    }
    
    public Long getLgtmRcptnYrtxPrmm() {
        return this.lgtmRcptnYrtxPrmm;
    }
    
    public void setLgtmRcptnYrtxPrmm(Long lgtmRcptnYrtxPrmm) {
        this.lgtmRcptnYrtxPrmm = lgtmRcptnYrtxPrmm;
    }
    
    public Long getHlthRcptnCalcPrmm() {
        return this.hlthRcptnCalcPrmm;
    }
    
    public void setHlthRcptnCalcPrmm(Long hlthRcptnCalcPrmm) {
        this.hlthRcptnCalcPrmm = hlthRcptnCalcPrmm;
    }
    
    public Long getHlthRcptnClutPrmm() {
        return this.hlthRcptnClutPrmm;
    }
    
    public void setHlthRcptnClutPrmm(Long hlthRcptnClutPrmm) {
        this.hlthRcptnClutPrmm = hlthRcptnClutPrmm;
    }
    
    public Long getHlthRcptnNofctPrmm() {
        return this.hlthRcptnNofctPrmm;
    }
    
    public void setHlthRcptnNofctPrmm(Long hlthRcptnNofctPrmm) {
        this.hlthRcptnNofctPrmm = hlthRcptnNofctPrmm;
    }
    
    public Long getHlthRcptnYrtxPrmm() {
        return this.hlthRcptnYrtxPrmm;
    }
    
    public void setHlthRcptnYrtxPrmm(Long hlthRcptnYrtxPrmm) {
        this.hlthRcptnYrtxPrmm = hlthRcptnYrtxPrmm;
    }
    
    public Long getHlthInsrRefdItrt() {
        return this.hlthInsrRefdItrt;
    }
    
    public void setHlthInsrRefdItrt(Long hlthInsrRefdItrt) {
        this.hlthInsrRefdItrt = hlthInsrRefdItrt;
    }
    
    public Long getLgtmRcptnRefdItrt() {
        return this.lgtmRcptnRefdItrt;
    }
    
    public void setLgtmRcptnRefdItrt(Long lgtmRcptnRefdItrt) {
        this.lgtmRcptnRefdItrt = lgtmRcptnRefdItrt;
    }
    
    public Long getTotPymtPrmm() {
        return this.totPymtPrmm;
    }
    
    public void setTotPymtPrmm(Long totPymtPrmm) {
        this.totPymtPrmm = totPymtPrmm;
    }
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
    }
    
    public Long getSrdAggrSum() {
        return this.srdAggrSum;
    }
    
    public void setSrdAggrSum(Long srdAggrSum) {
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