package com.app.exterms.yearendtax.client.dto.yeta2021;

import java.io.Serializable;


/**
 * @Class Name : Ye161080DTO.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161080DTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
    private java.lang.String frgrLbrrEntcPupCd;
    private Boolean frgrLbrrEntcPupCd1;
    private Boolean frgrLbrrEntcPupCd2;
    private Boolean frgrLbrrEntcPupCd3;
    private Boolean frgrLbrrEntcPupCd4;
    
    
    /** set C114_세액감면_소득세법감면금액 : yetaC114 */
    private Long yetaC114;

    /** set C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
    private Long yetaC115;

    /** set C116_세액감면_조특범20조_감면금액 : yetaC116 */
    private Long yetaC116;

    /** set C117_세액감면_조세조약감면금액 : yetaC117 */
    private Long yetaC117;

    /** set C119_세액감면합계금액 : yetaC119 */
    private Long yetaC119;
    
    

    
    public Long getYetaC114() {
		return yetaC114;
	}

	public void setYetaC114(Long yetaC114) {
		this.yetaC114 = yetaC114;
	}

	public Long getYetaC115() {
		return yetaC115;
	}

	public void setYetaC115(Long yetaC115) {
		this.yetaC115 = yetaC115;
	}

	public Long getYetaC116() {
		return yetaC116;
	}

	public void setYetaC116(Long yetaC116) {
		this.yetaC116 = yetaC116;
	}

	public Long getYetaC117() {
		return yetaC117;
	}

	public void setYetaC117(Long yetaC117) {
		this.yetaC117 = yetaC117;
	}

	public Long getYetaC119() {
		return yetaC119;
	}

	public void setYetaC119(Long yetaC119) {
		this.yetaC119 = yetaC119;
	}

	public Boolean getFrgrLbrrEntcPupCd1() {
		return frgrLbrrEntcPupCd1;
	}

	public void setFrgrLbrrEntcPupCd1(Boolean frgrLbrrEntcPupCd1) {
		this.frgrLbrrEntcPupCd1 = frgrLbrrEntcPupCd1;
	}

	public Boolean getFrgrLbrrEntcPupCd2() {
		return frgrLbrrEntcPupCd2;
	}

	public void setFrgrLbrrEntcPupCd2(Boolean frgrLbrrEntcPupCd2) {
		this.frgrLbrrEntcPupCd2 = frgrLbrrEntcPupCd2;
	}

	public Boolean getFrgrLbrrEntcPupCd3() {
		return frgrLbrrEntcPupCd3;
	}

	public void setFrgrLbrrEntcPupCd3(Boolean frgrLbrrEntcPupCd3) {
		this.frgrLbrrEntcPupCd3 = frgrLbrrEntcPupCd3;
	}

	public Boolean getFrgrLbrrEntcPupCd4() {
		return frgrLbrrEntcPupCd4;
	}

	public void setFrgrLbrrEntcPupCd4(Boolean frgrLbrrEntcPupCd4) {
		this.frgrLbrrEntcPupCd4 = frgrLbrrEntcPupCd4;
	}


	/** set 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
    private java.lang.String frgrLbrrLbrOfrDt;

    /** set 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
    private java.lang.String frgrLbrrReExryDt;

    /** set 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
    private java.lang.String frgrLbrrReRcpnDt;

    /** set 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
    private java.lang.String frgrLbrrReAlfaSbmsDt;

    /** set 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
    private java.lang.String frgrLbrrErinImnRcpnDt;

    /** set 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
    private java.lang.String frgrLbrrErinImnSbmsDt;

    /** set 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
    private java.lang.String yupSnmcReStrtDt;

    /** set 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
    private java.lang.String yupSnmcReEndDt;

    /** set 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
    private Long sctcHpUseAmt;

    /** set 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
    private Long sctcHpDdcTrgtAmt;

    /** set 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
    private Long sctcHpDdcAmt;

    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
    private Long rtpnUseAmt;

    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
    private Long rtpnDdcTrgtAmt;

    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
    private Long rtpnDdcAmt;

    /** set 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
    private Long pnsnSvngUseAmt;

    /** set 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
    private Long pnsnSvngDdcTrgtAmt;

    /** set 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
    private Long pnsnSvngDdcAmt;

    /** set 연금계좌납입금액합계 : pnsnAccUseAmtSum */
    private Long pnsnAccUseAmtSum;

    /** set 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
    private Long pnsnAccDdcTrgtAmtSum;

    /** set 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
    private Long pnsnAccDdcAmtSum;

    /** set 보장성보험납입금액 : cvrgInscUseAmt */
    private Long cvrgInscUseAmt;

    /** set 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
    private Long cvrgInscDdcTrgtAmt2;

    /** set 보장성보험공제세액 : cvrgInscDdcAmt */
    private Long cvrgInscDdcAmt;

    /** set 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
    private Long dsbrEuCvrgUseAmt;

    /** set 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
    private Long dsbrEuCvrgDdcTrgtAmt;

    /** set 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
    private Long dsbrEuCvrgDdcAmt;

    /** set 보험료납입금액합계 : infeePymUseAmtSum */
    private Long infeePymUseAmtSum;

    /** set 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
    private Long infeePymDdcTrgtAmtSum;

    /** set 보험료공제세액합계 : infeePymDdcAmtSum */
    private Long infeePymDdcAmtSum;
    
    
    /** set 의료비_실손보험금보전액 : mdxpsLsInsrTrAmt */
    private Long mdxpsLsInsrTrAmt;
    
    private Long medxpsUseAmtSum;
    
    /** set 의료비_난임시술비납입금액 : mdxpsSftSprcdUseAmt */
    private Long mdxpsSftSprcdUseAmt;

    /** set 의료비_난임시술비공제대상금액 : mdxpsSftSprcdDdcTrgtAmt */
    private Long mdxpsSftSprcdDdcTrgtAmt;

    /** set 의료비_난임시술비공제세액 : mdxpsSftSprcdDdcAmt */
    private Long mdxpsSftSprcdDdcAmt;

    /** set 의료비_본인65세이상장애인난임시술비납입금액 : mdxpsPrsUseAmt */
    private Long mdxpsPrsUseAmt;

    /** set 의료비_본인65세이상장애인난임시술비공제대상금액 : mdxpsPrsDdcTrgtAmt */
    private Long mdxpsPrsDdcTrgtAmt;

    /** set 의료비_본인65세이상장애인난임시술비공제세액 : mdxpsPrsDdcAmt */
    private Long mdxpsPrsDdcAmt;

    /** set 의료비_그밖의공제대상자납입금액 : mdxpsOthUseAmt */
    private Long mdxpsOthUseAmt;

    /** set 의료비_그밖의공제대상자공제대상금액 : mdxpsOthDdcTrgtAmt */
    private Long mdxpsOthDdcTrgtAmt;

    /** set 의료비_그밖의공제대상자공제새액 : mdxpsOthDdcAmt */
    private Long mdxpsOthDdcAmt;

    /** set 의료비납입금액합계 : mdxpsUseAmtSum */
    private Long mdxpsUseAmtSum;

    /** set 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
    private Long mdxpsDdcTrgtAmtSum;

    /** set 의료비공제세액합계 : mdxpsDdcAmtSum */
    private Long mdxpsDdcAmtSum;

    /** set 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
    private Long scxpsPrsUseAmt;

    /** set 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
    private Long scxpsPrsDdcTrgtAmt;

    /** set 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
    private Long scxpsPrsDdcAmt;

    /** set 교육비_취학전아동납입금액 : scxpsKidUseAmt */
    private Long scxpsKidUseAmt;

    /** set 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
    private Long scxpsKidDdcTrgtAmt;

    /** set 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
    private Long scxpsKidDdcAmt;

    /** set 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
    private Long scxpsStdUseAmt;

    /** set 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
    private Long scxpsStdDdcTrgtAmt;

    /** set 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
    private Long scxpsStdDdcAmt;

    /** set 교육비_대학생납입금액 : scxpsUndUseAmt */
    private Long scxpsUndUseAmt;

    /** set 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
    private Long scxpsUndDdcTrgtAmt;

    /** set 교육비_대상생공제세액 : scxpsUndDdcAmt */
    private Long scxpsUndDdcAmt;

    /** set 교육비_장애인납입금액 : scxpsDsbrUseAmt */
    private Long scxpsDsbrUseAmt;

    /** set 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
    private Long scxpsDsbrDdcTrgtAmt;

    /** set 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
    private Long scxpsDsbrDdcAmt;

    /** set 교육비_취학전아동인원수 : scxpsKidCount */
    private Long scxpsKidCount;

    /** set 교육비_초중고등학교인원수 : scxpsStdCount */
    private Long scxpsStdCount;

    /** set 교육비_대학생인원수 : scxpsUndCount */
    private Long scxpsUndCount;

    /** set 교육비_장애인인원수 : scxpsDsbrCount */
    private Long scxpsDsbrCount;

    /** set 교육비납입금액합계 : scxpsUseAmtSum */
    private Long scxpsUseAmtSum;

    /** set 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
    private Long scxpsDdcTrgtAmtSum;

    /** set 교육비공제세액금액합계 : scxpsDdcAmtSum */
    private Long scxpsDdcAmtSum;

    /** set 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
    private Long conb10ttswLtUseAmt;

    /** set 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
    private Long conb10ttswLtDdcTrgtAmt;

    /** set 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
    private Long conb10ttswLtDdcAmt;

    /** set 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
    private Long conb10excsLtUseAmt;

    /** set 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
    private Long conb10excsLtDdcTrgtAmt;

    /** set 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
    private Long conb10excsLtDdcAmt;

    /** set 기부금_법정기부금납입금액 : conbLglUseAmt */
    private Long conbLglUseAmt;

    /** set 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
    private Long conbLglDdcTrgtAmt;

    /** set 기부금_법정기부금공제세액 : conbLglDdcAmt */
    private Long conbLglDdcAmt;

    /** set 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
    private Long conbEmstAsctUseAmt;

    /** set 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
    private Long conbEmstAsctDdcTrgtAmt;

    /** set 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
    private Long conbEmstAsctDdcAmt;

    /** set 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
    private Long conbReliOrgOthUseAmt;

    /** set 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
    private Long conbReliOrgOthDdcTrgtAmt;

    /** set 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
    private Long conbReliOrgOthDdcAmt;

    /** set 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
    private Long conbReliOrgUseAmt;

    /** set 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
    private Long conbReliOrgDdcTrgtAmt;

    /** set 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
    private Long conbReliOrgDdcAmt;

    /** set 기부금납입금액합계 : conbUseAmtSum */
    private Long conbUseAmtSum;

    /** set 기부금공제대상금액합계 : conbDdcTrgtAmtSum */
    private Long conbDdcTrgtAmtSum;

    /** set 기부금공제세액합계 : conbDdcAmtSum */
    private Long conbDdcAmtSum;

    /** set 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
    private Long ovrsSurcIncFmt;

    /** set 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
    private Long frgnPmtFcTxamt;

    /** set 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
    private Long frgnPmtWcTxamt;

    /** set 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
    private java.lang.String frgnPmtTxamtTxpNtnNm;

    /** set 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
    private java.lang.String frgnPmtTxamtPmtDt;

    /** set 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
    private java.lang.String frgnPmtTxamtAlfaSbmsDt;

    /** set 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
    private java.lang.String frgnPmtTxamtAbrdWkarNm;

    /** set 외국납부세액_근무기간시작일자 : frgnDtyTermStdt */
    private java.lang.String frgnDtyTermStdt;
    
    /** set 외국납부세액_근무기간종료일자 : frgnDtyTermEddt */
    private java.lang.String frgnDtyTermEddt;
    
    /** set 외국납부세액직책 : frgnPmtTxamtRfoNm */
    private java.lang.String frgnPmtTxamtRfoNm;

    /** set 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
    private Long hsngTennLnpbUseAmt;

    /** set 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
    private Long hsngTennLnpbDdcAmt;

    /** set 월세액세액공제지출금액 : mmrUseAmt */
    private Long mmrUseAmt;

    /** set 월세액세액공제공제세액 : mmrDdcAmt */
    private Long mmrDdcAmt;

    /** set 신고인성명 : cd218 */
    private java.lang.String cd218;

    /** set 외국인근로자단일세율적용신청서제출여부 : d219 */
    private java.lang.String d219;

    /** set 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
    private java.lang.String prcspWorkIncmSumtYn;

    /** set 연금저축등소득세액공제명세서제출여부 : cd225 */
    private java.lang.String cd225;

    /** set 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
    private java.lang.String cd226;

    /** set 의료비지급명세서제출여부 : cd227 */
    private java.lang.String cd227;

    /** set 기부금명세서제출여부 : cd228 */
    private java.lang.String cd228;

    /** set 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
    private java.lang.String incmDducWtnnteSumtDt;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;
    
    /** set 소득공제신고파일제출여부 : fileAppPaprSbtYn */
    private java.lang.String fileAppPaprSbtYn;
    
    /** set 세액감면_소득세법감면세액 : txlgItctAmnt */
    private Long txlgItctAmnt;

    /** set 세액감면_취업청년감면대상총급여액 : txlgBstaAmnt */
    private Long txlgBstaAmnt;

    /** set 세액감면_취업청년감면근로자총급여액 : txlgWktaAmnt */
    private Long txlgWktaAmnt;

    /** set 세액감면_계산감면세액금액 : txlgCltaAmnt */
    private Long txlgCltaAmnt;

    /** set 세액감면_외국인기술자감면세액 : txlgFrtaAmnt */
    private Long txlgFrtaAmnt;

    /** set 세액감면_조세조약감면세액 : txlgTxtyAmnt */
    private Long txlgTxtyAmnt;
    
    
    
    
    /** set 연금계좌_ISA_퇴직연금납입금액 : rtpnIsaUseAmt */
    private Long rtpnIsaUseAmt;

    /** set 연금계좌_ISA_퇴직연금공제대상금액 : rtpnDdcIsaTrgtAmt */
    private Long rtpnDdcIsaTrgtAmt;

    /** set 연금계좌_ISA_퇴직연금공제세액 : rtpnDdcIsaAmt */
    private Long rtpnDdcIsaAmt;
    
    /** set 연금계좌_ISA_연금저축납입금액 : pnsnSvngIsaUseAmt */
    private Long pnsnSvngIsaUseAmt;

    /** set 연금계좌_ISA_연금저축공제대상금액 : pnsnSvngDdcIsaTrgtAmt */
    private Long pnsnSvngDdcIsaTrgtAmt;

    /** set 연금계좌_ISA_연금저축공제세액 : pnsnSvngDdcIsaAmt */
    private Long pnsnSvngDdcIsaAmt;
    
    
    
    
    
    

	public Long getRtpnIsaUseAmt() {
		return rtpnIsaUseAmt;
	}

	public void setRtpnIsaUseAmt(Long rtpnIsaUseAmt) {
		this.rtpnIsaUseAmt = rtpnIsaUseAmt;
	}

	public Long getRtpnDdcIsaTrgtAmt() {
		return rtpnDdcIsaTrgtAmt;
	}

	public void setRtpnDdcIsaTrgtAmt(Long rtpnDdcIsaTrgtAmt) {
		this.rtpnDdcIsaTrgtAmt = rtpnDdcIsaTrgtAmt;
	}

	public Long getRtpnDdcIsaAmt() {
		return rtpnDdcIsaAmt;
	}

	public void setRtpnDdcIsaAmt(Long rtpnDdcIsaAmt) {
		this.rtpnDdcIsaAmt = rtpnDdcIsaAmt;
	}

	public Long getPnsnSvngIsaUseAmt() {
		return pnsnSvngIsaUseAmt;
	}

	public void setPnsnSvngIsaUseAmt(Long pnsnSvngIsaUseAmt) {
		this.pnsnSvngIsaUseAmt = pnsnSvngIsaUseAmt;
	}

	public Long getPnsnSvngDdcIsaTrgtAmt() {
		return pnsnSvngDdcIsaTrgtAmt;
	}

	public void setPnsnSvngDdcIsaTrgtAmt(Long pnsnSvngDdcIsaTrgtAmt) {
		this.pnsnSvngDdcIsaTrgtAmt = pnsnSvngDdcIsaTrgtAmt;
	}

	public Long getPnsnSvngDdcIsaAmt() {
		return pnsnSvngDdcIsaAmt;
	}

	public void setPnsnSvngDdcIsaAmt(Long pnsnSvngDdcIsaAmt) {
		this.pnsnSvngDdcIsaAmt = pnsnSvngDdcIsaAmt;
	}

	public Long getMedxpsUseAmtSum() {
		return medxpsUseAmtSum;
	}

	public void setMedxpsUseAmtSum(Long medxpsUseAmtSum) {
		this.medxpsUseAmtSum = medxpsUseAmtSum;
	}

	public Long getTxlgItctAmnt() {
		return txlgItctAmnt;
	}

	public void setTxlgItctAmnt(Long txlgItctAmnt) {
		this.txlgItctAmnt = txlgItctAmnt;
	}

	public Long getTxlgBstaAmnt() {
		return txlgBstaAmnt;
	}

	public void setTxlgBstaAmnt(Long txlgBstaAmnt) {
		this.txlgBstaAmnt = txlgBstaAmnt;
	}

	public Long getTxlgWktaAmnt() {
		return txlgWktaAmnt;
	}

	public void setTxlgWktaAmnt(Long txlgWktaAmnt) {
		this.txlgWktaAmnt = txlgWktaAmnt;
	}

	public Long getTxlgCltaAmnt() {
		return txlgCltaAmnt;
	}

	public void setTxlgCltaAmnt(Long txlgCltaAmnt) {
		this.txlgCltaAmnt = txlgCltaAmnt;
	}

	public Long getTxlgFrtaAmnt() {
		return txlgFrtaAmnt;
	}

	public void setTxlgFrtaAmnt(Long txlgFrtaAmnt) {
		this.txlgFrtaAmnt = txlgFrtaAmnt;
	}

	public Long getTxlgTxtyAmnt() {
		return txlgTxtyAmnt;
	}

	public void setTxlgTxtyAmnt(Long txlgTxtyAmnt) {
		this.txlgTxtyAmnt = txlgTxtyAmnt;
	}

	public java.lang.String getFrgnDtyTermStdt() {
		return frgnDtyTermStdt;
	}

	public void setFrgnDtyTermStdt(java.lang.String frgnDtyTermStdt) {
		this.frgnDtyTermStdt = frgnDtyTermStdt;
	}

	public java.lang.String getFrgnDtyTermEddt() {
		return frgnDtyTermEddt;
	}

	public void setFrgnDtyTermEddt(java.lang.String frgnDtyTermEddt) {
		this.frgnDtyTermEddt = frgnDtyTermEddt;
	}

	public java.lang.String getFileAppPaprSbtYn() {
		return fileAppPaprSbtYn;
	}

	public void setFileAppPaprSbtYn(java.lang.String fileAppPaprSbtYn) {
		this.fileAppPaprSbtYn = fileAppPaprSbtYn;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getFrgrLbrrEntcPupCd() {
		return frgrLbrrEntcPupCd;
	}

	public void setFrgrLbrrEntcPupCd(java.lang.String frgrLbrrEntcPupCd) {
		this.frgrLbrrEntcPupCd = frgrLbrrEntcPupCd;
	}

	public java.lang.String getFrgrLbrrLbrOfrDt() {
		return frgrLbrrLbrOfrDt;
	}

	public void setFrgrLbrrLbrOfrDt(java.lang.String frgrLbrrLbrOfrDt) {
		this.frgrLbrrLbrOfrDt = frgrLbrrLbrOfrDt;
	}

	public java.lang.String getFrgrLbrrReExryDt() {
		return frgrLbrrReExryDt;
	}

	public void setFrgrLbrrReExryDt(java.lang.String frgrLbrrReExryDt) {
		this.frgrLbrrReExryDt = frgrLbrrReExryDt;
	}

	public java.lang.String getFrgrLbrrReRcpnDt() {
		return frgrLbrrReRcpnDt;
	}

	public void setFrgrLbrrReRcpnDt(java.lang.String frgrLbrrReRcpnDt) {
		this.frgrLbrrReRcpnDt = frgrLbrrReRcpnDt;
	}

	public java.lang.String getFrgrLbrrReAlfaSbmsDt() {
		return frgrLbrrReAlfaSbmsDt;
	}

	public void setFrgrLbrrReAlfaSbmsDt(java.lang.String frgrLbrrReAlfaSbmsDt) {
		this.frgrLbrrReAlfaSbmsDt = frgrLbrrReAlfaSbmsDt;
	}

	public java.lang.String getFrgrLbrrErinImnRcpnDt() {
		return frgrLbrrErinImnRcpnDt;
	}

	public void setFrgrLbrrErinImnRcpnDt(java.lang.String frgrLbrrErinImnRcpnDt) {
		this.frgrLbrrErinImnRcpnDt = frgrLbrrErinImnRcpnDt;
	}

	public java.lang.String getFrgrLbrrErinImnSbmsDt() {
		return frgrLbrrErinImnSbmsDt;
	}

	public void setFrgrLbrrErinImnSbmsDt(java.lang.String frgrLbrrErinImnSbmsDt) {
		this.frgrLbrrErinImnSbmsDt = frgrLbrrErinImnSbmsDt;
	}

	public java.lang.String getYupSnmcReStrtDt() {
		return yupSnmcReStrtDt;
	}

	public void setYupSnmcReStrtDt(java.lang.String yupSnmcReStrtDt) {
		this.yupSnmcReStrtDt = yupSnmcReStrtDt;
	}

	public java.lang.String getYupSnmcReEndDt() {
		return yupSnmcReEndDt;
	}

	public void setYupSnmcReEndDt(java.lang.String yupSnmcReEndDt) {
		this.yupSnmcReEndDt = yupSnmcReEndDt;
	}

	public Long getSctcHpUseAmt() {
		return sctcHpUseAmt;
	}

	public void setSctcHpUseAmt(Long sctcHpUseAmt) {
		this.sctcHpUseAmt = sctcHpUseAmt;
	}

	public Long getSctcHpDdcTrgtAmt() {
		return sctcHpDdcTrgtAmt;
	}

	public void setSctcHpDdcTrgtAmt(Long sctcHpDdcTrgtAmt) {
		this.sctcHpDdcTrgtAmt = sctcHpDdcTrgtAmt;
	}

	public Long getSctcHpDdcAmt() {
		return sctcHpDdcAmt;
	}

	public void setSctcHpDdcAmt(Long sctcHpDdcAmt) {
		this.sctcHpDdcAmt = sctcHpDdcAmt;
	}

	public Long getRtpnUseAmt() {
		return rtpnUseAmt;
	}

	public void setRtpnUseAmt(Long rtpnUseAmt) {
		this.rtpnUseAmt = rtpnUseAmt;
	}

	public Long getRtpnDdcTrgtAmt() {
		return rtpnDdcTrgtAmt;
	}

	public void setRtpnDdcTrgtAmt(Long rtpnDdcTrgtAmt) {
		this.rtpnDdcTrgtAmt = rtpnDdcTrgtAmt;
	}

	public Long getRtpnDdcAmt() {
		return rtpnDdcAmt;
	}

	public void setRtpnDdcAmt(Long rtpnDdcAmt) {
		this.rtpnDdcAmt = rtpnDdcAmt;
	}

	public Long getPnsnSvngUseAmt() {
		return pnsnSvngUseAmt;
	}

	public void setPnsnSvngUseAmt(Long pnsnSvngUseAmt) {
		this.pnsnSvngUseAmt = pnsnSvngUseAmt;
	}

	public Long getPnsnSvngDdcTrgtAmt() {
		return pnsnSvngDdcTrgtAmt;
	}

	public void setPnsnSvngDdcTrgtAmt(Long pnsnSvngDdcTrgtAmt) {
		this.pnsnSvngDdcTrgtAmt = pnsnSvngDdcTrgtAmt;
	}

	public Long getPnsnSvngDdcAmt() {
		return pnsnSvngDdcAmt;
	}

	public void setPnsnSvngDdcAmt(Long pnsnSvngDdcAmt) {
		this.pnsnSvngDdcAmt = pnsnSvngDdcAmt;
	}

	public Long getPnsnAccUseAmtSum() {
		return pnsnAccUseAmtSum;
	}

	public void setPnsnAccUseAmtSum(Long pnsnAccUseAmtSum) {
		this.pnsnAccUseAmtSum = pnsnAccUseAmtSum;
	}

	public Long getPnsnAccDdcTrgtAmtSum() {
		return pnsnAccDdcTrgtAmtSum;
	}

	public void setPnsnAccDdcTrgtAmtSum(Long pnsnAccDdcTrgtAmtSum) {
		this.pnsnAccDdcTrgtAmtSum = pnsnAccDdcTrgtAmtSum;
	}

	public Long getPnsnAccDdcAmtSum() {
		return pnsnAccDdcAmtSum;
	}

	public void setPnsnAccDdcAmtSum(Long pnsnAccDdcAmtSum) {
		this.pnsnAccDdcAmtSum = pnsnAccDdcAmtSum;
	}

	public Long getCvrgInscUseAmt() {
		return cvrgInscUseAmt;
	}

	public void setCvrgInscUseAmt(Long cvrgInscUseAmt) {
		this.cvrgInscUseAmt = cvrgInscUseAmt;
	}

	public Long getCvrgInscDdcTrgtAmt2() {
		return cvrgInscDdcTrgtAmt2;
	}

	public void setCvrgInscDdcTrgtAmt2(Long cvrgInscDdcTrgtAmt2) {
		this.cvrgInscDdcTrgtAmt2 = cvrgInscDdcTrgtAmt2;
	}

	public Long getCvrgInscDdcAmt() {
		return cvrgInscDdcAmt;
	}

	public void setCvrgInscDdcAmt(Long cvrgInscDdcAmt) {
		this.cvrgInscDdcAmt = cvrgInscDdcAmt;
	}

	public Long getDsbrEuCvrgUseAmt() {
		return dsbrEuCvrgUseAmt;
	}

	public void setDsbrEuCvrgUseAmt(Long dsbrEuCvrgUseAmt) {
		this.dsbrEuCvrgUseAmt = dsbrEuCvrgUseAmt;
	}

	public Long getDsbrEuCvrgDdcTrgtAmt() {
		return dsbrEuCvrgDdcTrgtAmt;
	}

	public void setDsbrEuCvrgDdcTrgtAmt(Long dsbrEuCvrgDdcTrgtAmt) {
		this.dsbrEuCvrgDdcTrgtAmt = dsbrEuCvrgDdcTrgtAmt;
	}

	public Long getDsbrEuCvrgDdcAmt() {
		return dsbrEuCvrgDdcAmt;
	}

	public void setDsbrEuCvrgDdcAmt(Long dsbrEuCvrgDdcAmt) {
		this.dsbrEuCvrgDdcAmt = dsbrEuCvrgDdcAmt;
	}

	public Long getInfeePymUseAmtSum() {
		return infeePymUseAmtSum;
	}

	public void setInfeePymUseAmtSum(Long infeePymUseAmtSum) {
		this.infeePymUseAmtSum = infeePymUseAmtSum;
	}

	public Long getInfeePymDdcTrgtAmtSum() {
		return infeePymDdcTrgtAmtSum;
	}

	public void setInfeePymDdcTrgtAmtSum(Long infeePymDdcTrgtAmtSum) {
		this.infeePymDdcTrgtAmtSum = infeePymDdcTrgtAmtSum;
	}

	public Long getInfeePymDdcAmtSum() {
		return infeePymDdcAmtSum;
	}

	public void setInfeePymDdcAmtSum(Long infeePymDdcAmtSum) {
		this.infeePymDdcAmtSum = infeePymDdcAmtSum;
	}

	public Long getMdxpsPrsUseAmt() {
		return mdxpsPrsUseAmt;
	}

	public void setMdxpsPrsUseAmt(Long mdxpsPrsUseAmt) {
		this.mdxpsPrsUseAmt = mdxpsPrsUseAmt;
	}

	public Long getMdxpsPrsDdcTrgtAmt() {
		return mdxpsPrsDdcTrgtAmt;
	}

	public void setMdxpsPrsDdcTrgtAmt(Long mdxpsPrsDdcTrgtAmt) {
		this.mdxpsPrsDdcTrgtAmt = mdxpsPrsDdcTrgtAmt;
	}

	public Long getMdxpsPrsDdcAmt() {
		return mdxpsPrsDdcAmt;
	}

	public void setMdxpsPrsDdcAmt(Long mdxpsPrsDdcAmt) {
		this.mdxpsPrsDdcAmt = mdxpsPrsDdcAmt;
	}

	public Long getMdxpsOthUseAmt() {
		return mdxpsOthUseAmt;
	}

	public void setMdxpsOthUseAmt(Long mdxpsOthUseAmt) {
		this.mdxpsOthUseAmt = mdxpsOthUseAmt;
	}

	public Long getMdxpsOthDdcTrgtAmt() {
		return mdxpsOthDdcTrgtAmt;
	}

	public void setMdxpsOthDdcTrgtAmt(Long mdxpsOthDdcTrgtAmt) {
		this.mdxpsOthDdcTrgtAmt = mdxpsOthDdcTrgtAmt;
	}

	public Long getMdxpsOthDdcAmt() {
		return mdxpsOthDdcAmt;
	}

	public void setMdxpsOthDdcAmt(Long mdxpsOthDdcAmt) {
		this.mdxpsOthDdcAmt = mdxpsOthDdcAmt;
	}

	public Long getMdxpsUseAmtSum() {
		return mdxpsUseAmtSum;
	}

	public void setMdxpsUseAmtSum(Long mdxpsUseAmtSum) {
		this.mdxpsUseAmtSum = mdxpsUseAmtSum;
	}

	public Long getMdxpsDdcTrgtAmtSum() {
		return mdxpsDdcTrgtAmtSum;
	}

	public void setMdxpsDdcTrgtAmtSum(Long mdxpsDdcTrgtAmtSum) {
		this.mdxpsDdcTrgtAmtSum = mdxpsDdcTrgtAmtSum;
	}

	public Long getMdxpsDdcAmtSum() {
		return mdxpsDdcAmtSum;
	}

	public void setMdxpsDdcAmtSum(Long mdxpsDdcAmtSum) {
		this.mdxpsDdcAmtSum = mdxpsDdcAmtSum;
	}

	public Long getScxpsPrsUseAmt() {
		return scxpsPrsUseAmt;
	}

	public void setScxpsPrsUseAmt(Long scxpsPrsUseAmt) {
		this.scxpsPrsUseAmt = scxpsPrsUseAmt;
	}

	public Long getScxpsPrsDdcTrgtAmt() {
		return scxpsPrsDdcTrgtAmt;
	}

	public void setScxpsPrsDdcTrgtAmt(Long scxpsPrsDdcTrgtAmt) {
		this.scxpsPrsDdcTrgtAmt = scxpsPrsDdcTrgtAmt;
	}

	public Long getScxpsPrsDdcAmt() {
		return scxpsPrsDdcAmt;
	}

	public void setScxpsPrsDdcAmt(Long scxpsPrsDdcAmt) {
		this.scxpsPrsDdcAmt = scxpsPrsDdcAmt;
	}

	public Long getScxpsKidUseAmt() {
		return scxpsKidUseAmt;
	}

	public void setScxpsKidUseAmt(Long scxpsKidUseAmt) {
		this.scxpsKidUseAmt = scxpsKidUseAmt;
	}

	public Long getScxpsKidDdcTrgtAmt() {
		return scxpsKidDdcTrgtAmt;
	}

	public void setScxpsKidDdcTrgtAmt(Long scxpsKidDdcTrgtAmt) {
		this.scxpsKidDdcTrgtAmt = scxpsKidDdcTrgtAmt;
	}

	public Long getScxpsKidDdcAmt() {
		return scxpsKidDdcAmt;
	}

	public void setScxpsKidDdcAmt(Long scxpsKidDdcAmt) {
		this.scxpsKidDdcAmt = scxpsKidDdcAmt;
	}

	public Long getScxpsStdUseAmt() {
		return scxpsStdUseAmt;
	}

	public void setScxpsStdUseAmt(Long scxpsStdUseAmt) {
		this.scxpsStdUseAmt = scxpsStdUseAmt;
	}

	public Long getScxpsStdDdcTrgtAmt() {
		return scxpsStdDdcTrgtAmt;
	}

	public void setScxpsStdDdcTrgtAmt(Long scxpsStdDdcTrgtAmt) {
		this.scxpsStdDdcTrgtAmt = scxpsStdDdcTrgtAmt;
	}

	public Long getScxpsStdDdcAmt() {
		return scxpsStdDdcAmt;
	}

	public void setScxpsStdDdcAmt(Long scxpsStdDdcAmt) {
		this.scxpsStdDdcAmt = scxpsStdDdcAmt;
	}

	public Long getScxpsUndUseAmt() {
		return scxpsUndUseAmt;
	}

	public void setScxpsUndUseAmt(Long scxpsUndUseAmt) {
		this.scxpsUndUseAmt = scxpsUndUseAmt;
	}

	public Long getScxpsUndDdcTrgtAmt() {
		return scxpsUndDdcTrgtAmt;
	}

	public void setScxpsUndDdcTrgtAmt(Long scxpsUndDdcTrgtAmt) {
		this.scxpsUndDdcTrgtAmt = scxpsUndDdcTrgtAmt;
	}

	public Long getScxpsUndDdcAmt() {
		return scxpsUndDdcAmt;
	}

	public void setScxpsUndDdcAmt(Long scxpsUndDdcAmt) {
		this.scxpsUndDdcAmt = scxpsUndDdcAmt;
	}

	public Long getScxpsDsbrUseAmt() {
		return scxpsDsbrUseAmt;
	}

	public void setScxpsDsbrUseAmt(Long scxpsDsbrUseAmt) {
		this.scxpsDsbrUseAmt = scxpsDsbrUseAmt;
	}

	public Long getScxpsDsbrDdcTrgtAmt() {
		return scxpsDsbrDdcTrgtAmt;
	}

	public void setScxpsDsbrDdcTrgtAmt(Long scxpsDsbrDdcTrgtAmt) {
		this.scxpsDsbrDdcTrgtAmt = scxpsDsbrDdcTrgtAmt;
	}

	public Long getScxpsDsbrDdcAmt() {
		return scxpsDsbrDdcAmt;
	}

	public void setScxpsDsbrDdcAmt(Long scxpsDsbrDdcAmt) {
		this.scxpsDsbrDdcAmt = scxpsDsbrDdcAmt;
	}

	public Long getScxpsKidCount() {
		return scxpsKidCount;
	}

	public void setScxpsKidCount(Long scxpsKidCount) {
		this.scxpsKidCount = scxpsKidCount;
	}

	public Long getScxpsStdCount() {
		return scxpsStdCount;
	}

	public void setScxpsStdCount(Long scxpsStdCount) {
		this.scxpsStdCount = scxpsStdCount;
	}

	public Long getScxpsUndCount() {
		return scxpsUndCount;
	}

	public void setScxpsUndCount(Long scxpsUndCount) {
		this.scxpsUndCount = scxpsUndCount;
	}

	public Long getScxpsDsbrCount() {
		return scxpsDsbrCount;
	}

	public void setScxpsDsbrCount(Long scxpsDsbrCount) {
		this.scxpsDsbrCount = scxpsDsbrCount;
	}

	public Long getScxpsUseAmtSum() {
		return scxpsUseAmtSum;
	}

	public void setScxpsUseAmtSum(Long scxpsUseAmtSum) {
		this.scxpsUseAmtSum = scxpsUseAmtSum;
	}

	public Long getScxpsDdcTrgtAmtSum() {
		return scxpsDdcTrgtAmtSum;
	}

	public void setScxpsDdcTrgtAmtSum(Long scxpsDdcTrgtAmtSum) {
		this.scxpsDdcTrgtAmtSum = scxpsDdcTrgtAmtSum;
	}

	public Long getScxpsDdcAmtSum() {
		return scxpsDdcAmtSum;
	}

	public void setScxpsDdcAmtSum(Long scxpsDdcAmtSum) {
		this.scxpsDdcAmtSum = scxpsDdcAmtSum;
	}

	public Long getConb10ttswLtUseAmt() {
		return conb10ttswLtUseAmt;
	}

	public void setConb10ttswLtUseAmt(Long conb10ttswLtUseAmt) {
		this.conb10ttswLtUseAmt = conb10ttswLtUseAmt;
	}

	public Long getConb10ttswLtDdcTrgtAmt() {
		return conb10ttswLtDdcTrgtAmt;
	}

	public void setConb10ttswLtDdcTrgtAmt(Long conb10ttswLtDdcTrgtAmt) {
		this.conb10ttswLtDdcTrgtAmt = conb10ttswLtDdcTrgtAmt;
	}

	public Long getConb10ttswLtDdcAmt() {
		return conb10ttswLtDdcAmt;
	}

	public void setConb10ttswLtDdcAmt(Long conb10ttswLtDdcAmt) {
		this.conb10ttswLtDdcAmt = conb10ttswLtDdcAmt;
	}

	public Long getConb10excsLtUseAmt() {
		return conb10excsLtUseAmt;
	}

	public void setConb10excsLtUseAmt(Long conb10excsLtUseAmt) {
		this.conb10excsLtUseAmt = conb10excsLtUseAmt;
	}

	public Long getConb10excsLtDdcTrgtAmt() {
		return conb10excsLtDdcTrgtAmt;
	}

	public void setConb10excsLtDdcTrgtAmt(Long conb10excsLtDdcTrgtAmt) {
		this.conb10excsLtDdcTrgtAmt = conb10excsLtDdcTrgtAmt;
	}

	public Long getConb10excsLtDdcAmt() {
		return conb10excsLtDdcAmt;
	}

	public void setConb10excsLtDdcAmt(Long conb10excsLtDdcAmt) {
		this.conb10excsLtDdcAmt = conb10excsLtDdcAmt;
	}

	public Long getConbLglUseAmt() {
		return conbLglUseAmt;
	}

	public void setConbLglUseAmt(Long conbLglUseAmt) {
		this.conbLglUseAmt = conbLglUseAmt;
	}

	public Long getConbLglDdcTrgtAmt() {
		return conbLglDdcTrgtAmt;
	}

	public void setConbLglDdcTrgtAmt(Long conbLglDdcTrgtAmt) {
		this.conbLglDdcTrgtAmt = conbLglDdcTrgtAmt;
	}

	public Long getConbLglDdcAmt() {
		return conbLglDdcAmt;
	}

	public void setConbLglDdcAmt(Long conbLglDdcAmt) {
		this.conbLglDdcAmt = conbLglDdcAmt;
	}

	public Long getConbEmstAsctUseAmt() {
		return conbEmstAsctUseAmt;
	}

	public void setConbEmstAsctUseAmt(Long conbEmstAsctUseAmt) {
		this.conbEmstAsctUseAmt = conbEmstAsctUseAmt;
	}

	public Long getConbEmstAsctDdcTrgtAmt() {
		return conbEmstAsctDdcTrgtAmt;
	}

	public void setConbEmstAsctDdcTrgtAmt(Long conbEmstAsctDdcTrgtAmt) {
		this.conbEmstAsctDdcTrgtAmt = conbEmstAsctDdcTrgtAmt;
	}

	public Long getConbEmstAsctDdcAmt() {
		return conbEmstAsctDdcAmt;
	}

	public void setConbEmstAsctDdcAmt(Long conbEmstAsctDdcAmt) {
		this.conbEmstAsctDdcAmt = conbEmstAsctDdcAmt;
	}

	public Long getConbReliOrgOthUseAmt() {
		return conbReliOrgOthUseAmt;
	}

	public void setConbReliOrgOthUseAmt(Long conbReliOrgOthUseAmt) {
		this.conbReliOrgOthUseAmt = conbReliOrgOthUseAmt;
	}

	public Long getConbReliOrgOthDdcTrgtAmt() {
		return conbReliOrgOthDdcTrgtAmt;
	}

	public void setConbReliOrgOthDdcTrgtAmt(Long conbReliOrgOthDdcTrgtAmt) {
		this.conbReliOrgOthDdcTrgtAmt = conbReliOrgOthDdcTrgtAmt;
	}

	public Long getConbReliOrgOthDdcAmt() {
		return conbReliOrgOthDdcAmt;
	}

	public void setConbReliOrgOthDdcAmt(Long conbReliOrgOthDdcAmt) {
		this.conbReliOrgOthDdcAmt = conbReliOrgOthDdcAmt;
	}

	public Long getConbReliOrgUseAmt() {
		return conbReliOrgUseAmt;
	}

	public void setConbReliOrgUseAmt(Long conbReliOrgUseAmt) {
		this.conbReliOrgUseAmt = conbReliOrgUseAmt;
	}

	public Long getConbReliOrgDdcTrgtAmt() {
		return conbReliOrgDdcTrgtAmt;
	}

	public void setConbReliOrgDdcTrgtAmt(Long conbReliOrgDdcTrgtAmt) {
		this.conbReliOrgDdcTrgtAmt = conbReliOrgDdcTrgtAmt;
	}

	public Long getConbReliOrgDdcAmt() {
		return conbReliOrgDdcAmt;
	}

	public void setConbReliOrgDdcAmt(Long conbReliOrgDdcAmt) {
		this.conbReliOrgDdcAmt = conbReliOrgDdcAmt;
	}

	public Long getConbUseAmtSum() {
		return conbUseAmtSum;
	}

	public void setConbUseAmtSum(Long conbUseAmtSum) {
		this.conbUseAmtSum = conbUseAmtSum;
	}

	public Long getConbDdcTrgtAmtSum() {
		return conbDdcTrgtAmtSum;
	}

	public void setConbDdcTrgtAmtSum(Long conbDdcTrgtAmtSum) {
		this.conbDdcTrgtAmtSum = conbDdcTrgtAmtSum;
	}

	public Long getConbDdcAmtSum() {
		return conbDdcAmtSum;
	}

	public void setConbDdcAmtSum(Long conbDdcAmtSum) {
		this.conbDdcAmtSum = conbDdcAmtSum;
	}

	public Long getOvrsSurcIncFmt() {
		return ovrsSurcIncFmt;
	}

	public void setOvrsSurcIncFmt(Long ovrsSurcIncFmt) {
		this.ovrsSurcIncFmt = ovrsSurcIncFmt;
	}

	public Long getFrgnPmtFcTxamt() {
		return frgnPmtFcTxamt;
	}

	public void setFrgnPmtFcTxamt(Long frgnPmtFcTxamt) {
		this.frgnPmtFcTxamt = frgnPmtFcTxamt;
	}

	public Long getFrgnPmtWcTxamt() {
		return frgnPmtWcTxamt;
	}

	public void setFrgnPmtWcTxamt(Long frgnPmtWcTxamt) {
		this.frgnPmtWcTxamt = frgnPmtWcTxamt;
	}

	public java.lang.String getFrgnPmtTxamtTxpNtnNm() {
		return frgnPmtTxamtTxpNtnNm;
	}

	public void setFrgnPmtTxamtTxpNtnNm(java.lang.String frgnPmtTxamtTxpNtnNm) {
		this.frgnPmtTxamtTxpNtnNm = frgnPmtTxamtTxpNtnNm;
	}

	public java.lang.String getFrgnPmtTxamtPmtDt() {
		return frgnPmtTxamtPmtDt;
	}

	public void setFrgnPmtTxamtPmtDt(java.lang.String frgnPmtTxamtPmtDt) {
		this.frgnPmtTxamtPmtDt = frgnPmtTxamtPmtDt;
	}

	public java.lang.String getFrgnPmtTxamtAlfaSbmsDt() {
		return frgnPmtTxamtAlfaSbmsDt;
	}

	public void setFrgnPmtTxamtAlfaSbmsDt(java.lang.String frgnPmtTxamtAlfaSbmsDt) {
		this.frgnPmtTxamtAlfaSbmsDt = frgnPmtTxamtAlfaSbmsDt;
	}

	public java.lang.String getFrgnPmtTxamtAbrdWkarNm() {
		return frgnPmtTxamtAbrdWkarNm;
	}

	public void setFrgnPmtTxamtAbrdWkarNm(java.lang.String frgnPmtTxamtAbrdWkarNm) {
		this.frgnPmtTxamtAbrdWkarNm = frgnPmtTxamtAbrdWkarNm;
	}

	public java.lang.String getFrgnPmtTxamtRfoNm() {
		return frgnPmtTxamtRfoNm;
	}

	public void setFrgnPmtTxamtRfoNm(java.lang.String frgnPmtTxamtRfoNm) {
		this.frgnPmtTxamtRfoNm = frgnPmtTxamtRfoNm;
	}

	public Long getHsngTennLnpbUseAmt() {
		return hsngTennLnpbUseAmt;
	}

	public void setHsngTennLnpbUseAmt(Long hsngTennLnpbUseAmt) {
		this.hsngTennLnpbUseAmt = hsngTennLnpbUseAmt;
	}

	public Long getHsngTennLnpbDdcAmt() {
		return hsngTennLnpbDdcAmt;
	}

	public void setHsngTennLnpbDdcAmt(Long hsngTennLnpbDdcAmt) {
		this.hsngTennLnpbDdcAmt = hsngTennLnpbDdcAmt;
	}

	public Long getMmrUseAmt() {
		return mmrUseAmt;
	}

	public void setMmrUseAmt(Long mmrUseAmt) {
		this.mmrUseAmt = mmrUseAmt;
	}

	public Long getMmrDdcAmt() {
		return mmrDdcAmt;
	}

	public void setMmrDdcAmt(Long mmrDdcAmt) {
		this.mmrDdcAmt = mmrDdcAmt;
	}

	public java.lang.String getCd218() {
		return cd218;
	}

	public void setCd218(java.lang.String cd218) {
		this.cd218 = cd218;
	}

	public java.lang.String getD219() {
		return d219;
	}

	public void setD219(java.lang.String d219) {
		this.d219 = d219;
	}

	public java.lang.String getPrcspWorkIncmSumtYn() {
		return prcspWorkIncmSumtYn;
	}

	public void setPrcspWorkIncmSumtYn(java.lang.String prcspWorkIncmSumtYn) {
		this.prcspWorkIncmSumtYn = prcspWorkIncmSumtYn;
	}

	public java.lang.String getCd225() {
		return cd225;
	}

	public void setCd225(java.lang.String cd225) {
		this.cd225 = cd225;
	}

	public java.lang.String getCd226() {
		return cd226;
	}

	public void setCd226(java.lang.String cd226) {
		this.cd226 = cd226;
	}

	public java.lang.String getCd227() {
		return cd227;
	}

	public void setCd227(java.lang.String cd227) {
		this.cd227 = cd227;
	}

	public java.lang.String getCd228() {
		return cd228;
	}

	public void setCd228(java.lang.String cd228) {
		this.cd228 = cd228;
	}

	public java.lang.String getIncmDducWtnnteSumtDt() {
		return incmDducWtnnteSumtDt;
	}

	public void setIncmDducWtnnteSumtDt(java.lang.String incmDducWtnnteSumtDt) {
		this.incmDducWtnnteSumtDt = incmDducWtnnteSumtDt;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

	public Long getMdxpsSftSprcdUseAmt() {
		return mdxpsSftSprcdUseAmt;
	}

	public void setMdxpsSftSprcdUseAmt(Long mdxpsSftSprcdUseAmt) {
		this.mdxpsSftSprcdUseAmt = mdxpsSftSprcdUseAmt;
	}

	public Long getMdxpsSftSprcdDdcTrgtAmt() {
		return mdxpsSftSprcdDdcTrgtAmt;
	}

	public void setMdxpsSftSprcdDdcTrgtAmt(Long mdxpsSftSprcdDdcTrgtAmt) {
		this.mdxpsSftSprcdDdcTrgtAmt = mdxpsSftSprcdDdcTrgtAmt;
	}

	public Long getMdxpsSftSprcdDdcAmt() {
		return mdxpsSftSprcdDdcAmt;
	}

	public void setMdxpsSftSprcdDdcAmt(Long mdxpsSftSprcdDdcAmt) {
		this.mdxpsSftSprcdDdcAmt = mdxpsSftSprcdDdcAmt;
	}

	public Long getMdxpsLsInsrTrAmt() {
		return mdxpsLsInsrTrAmt;
	}

	public void setMdxpsLsInsrTrAmt(Long mdxpsLsInsrTrAmt) {
		this.mdxpsLsInsrTrAmt = mdxpsLsInsrTrAmt;
	}

	
}
