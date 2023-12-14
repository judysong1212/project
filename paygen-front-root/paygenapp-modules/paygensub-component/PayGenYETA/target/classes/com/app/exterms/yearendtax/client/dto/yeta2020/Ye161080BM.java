package com.app.exterms.yearendtax.client.dto.yeta2020;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye161080BM.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161080BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
    public static final String ATTR_FRGRLBRRENTCPUPCD = "frgrLbrrEntcPupCd";

    /** set 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
    public static final String ATTR_FRGRLBRRLBROFRDT = "frgrLbrrLbrOfrDt";

    /** set 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
    public static final String ATTR_FRGRLBRRREEXRYDT = "frgrLbrrReExryDt";

    /** set 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
    public static final String ATTR_FRGRLBRRRERCPNDT = "frgrLbrrReRcpnDt";

    /** set 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
    public static final String ATTR_FRGRLBRRREALFASBMSDT = "frgrLbrrReAlfaSbmsDt";

    /** set 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
    public static final String ATTR_FRGRLBRRERINIMNRCPNDT = "frgrLbrrErinImnRcpnDt";

    /** set 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
    public static final String ATTR_FRGRLBRRERINIMNSBMSDT = "frgrLbrrErinImnSbmsDt";

    /** set 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
    public static final String ATTR_YUPSNMCRESTRTDT = "yupSnmcReStrtDt";

    /** set 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
    public static final String ATTR_YUPSNMCREENDDT = "yupSnmcReEndDt";

    /** set 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
    public static final String ATTR_SCTCHPUSEAMT = "sctcHpUseAmt";

    /** set 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
    public static final String ATTR_SCTCHPDDCTRGTAMT = "sctcHpDdcTrgtAmt";

    /** set 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
    public static final String ATTR_SCTCHPDDCAMT = "sctcHpDdcAmt";

    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
    public static final String ATTR_RTPNUSEAMT = "rtpnUseAmt";

    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
    public static final String ATTR_RTPNDDCTRGTAMT = "rtpnDdcTrgtAmt";

    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
    public static final String ATTR_RTPNDDCAMT = "rtpnDdcAmt";

    /** set 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
    public static final String ATTR_PNSNSVNGUSEAMT = "pnsnSvngUseAmt";

    /** set 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
    public static final String ATTR_PNSNSVNGDDCTRGTAMT = "pnsnSvngDdcTrgtAmt";

    /** set 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
    public static final String ATTR_PNSNSVNGDDCAMT = "pnsnSvngDdcAmt";

    /** set 연금계좌납입금액합계 : pnsnAccUseAmtSum */
    public static final String ATTR_PNSNACCUSEAMTSUM = "pnsnAccUseAmtSum";

    /** set 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
    public static final String ATTR_PNSNACCDDCTRGTAMTSUM = "pnsnAccDdcTrgtAmtSum";

    /** set 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
    public static final String ATTR_PNSNACCDDCAMTSUM = "pnsnAccDdcAmtSum";

    /** set 보장성보험납입금액 : cvrgInscUseAmt */
    public static final String ATTR_CVRGINSCUSEAMT = "cvrgInscUseAmt";

    /** set 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
    public static final String ATTR_CVRGINSCDDCTRGTAMT2 = "cvrgInscDdcTrgtAmt2";

    /** set 보장성보험공제세액 : cvrgInscDdcAmt */
    public static final String ATTR_CVRGINSCDDCAMT = "cvrgInscDdcAmt";

    /** set 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
    public static final String ATTR_DSBREUCVRGUSEAMT = "dsbrEuCvrgUseAmt";

    /** set 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
    public static final String ATTR_DSBREUCVRGDDCTRGTAMT = "dsbrEuCvrgDdcTrgtAmt";

    /** set 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
    public static final String ATTR_DSBREUCVRGDDCAMT = "dsbrEuCvrgDdcAmt";

    /** set 보험료납입금액합계 : infeePymUseAmtSum */
    public static final String ATTR_INFEEPYMUSEAMTSUM = "infeePymUseAmtSum";

    /** set 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
    public static final String ATTR_INFEEPYMDDCTRGTAMTSUM = "infeePymDdcTrgtAmtSum";

    /** set 보험료공제세액합계 : infeePymDdcAmtSum */
    public static final String ATTR_INFEEPYMDDCAMTSUM = "infeePymDdcAmtSum";
    
    /** set 의료비_실손보험금보전액 : mdxpsLsInsrTrAmt */
    public static final String ATTR_MDXPSLSINSRTRAMT = "mdxpsLsInsrTrAmt";
    
    /** set 의료비_난임시술비납입금액 : mdxpsSftSprcdUseAmt */
    public static final String ATTR_MDXPSSFTSPRCDUSEAMT = "mdxpsSftSprcdUseAmt";

    /** set 의료비_난임시술비공제대상금액 : mdxpsSftSprcdDdcTrgtAmt */
    public static final String ATTR_MDXPSSFTSPRCDDDCTRGTAMT = "mdxpsSftSprcdDdcTrgtAmt";

    /** set 의료비_난임시술비공제세액 : mdxpsSftSprcdDdcAmt */
    public static final String ATTR_MDXPSSFTSPRCDDDCAMT = "mdxpsSftSprcdDdcAmt";

    /** set 의료비_본인65세이상장애인난임시술비납입금액 : mdxpsPrsUseAmt */
    public static final String ATTR_MDXPSPRSUSEAMT = "mdxpsPrsUseAmt";

    /** set 의료비_본인65세이상장애인난임시술비공제대상금액 : mdxpsPrsDdcTrgtAmt */
    public static final String ATTR_MDXPSPRSDDCTRGTAMT = "mdxpsPrsDdcTrgtAmt";

    /** set 의료비_본인65세이상장애인난임시술비공제세액 : mdxpsPrsDdcAmt */
    public static final String ATTR_MDXPSPRSDDCAMT = "mdxpsPrsDdcAmt";

    /** set 의료비_그밖의공제대상자납입금액 : mdxpsOthUseAmt */
    public static final String ATTR_MDXPSOTHUSEAMT = "mdxpsOthUseAmt";

    /** set 의료비_그밖의공제대상자공제대상금액 : mdxpsOthDdcTrgtAmt */
    public static final String ATTR_MDXPSOTHDDCTRGTAMT = "mdxpsOthDdcTrgtAmt";

    /** set 의료비_그밖의공제대상자공제새액 : mdxpsOthDdcAmt */
    public static final String ATTR_MDXPSOTHDDCAMT = "mdxpsOthDdcAmt";

    /** set 의료비납입금액합계 : mdxpsUseAmtSum */
    public static final String ATTR_MDXPSUSEAMTSUM = "mdxpsUseAmtSum";

    /** set 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
    public static final String ATTR_MDXPSDDCTRGTAMTSUM = "mdxpsDdcTrgtAmtSum";

    /** set 의료비공제세액합계 : mdxpsDdcAmtSum */
    public static final String ATTR_MDXPSDDCAMTSUM = "mdxpsDdcAmtSum";

    /** set 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
    public static final String ATTR_SCXPSPRSUSEAMT = "scxpsPrsUseAmt";

    /** set 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
    public static final String ATTR_SCXPSPRSDDCTRGTAMT = "scxpsPrsDdcTrgtAmt";

    /** set 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
    public static final String ATTR_SCXPSPRSDDCAMT = "scxpsPrsDdcAmt";

    /** set 교육비_취학전아동납입금액 : scxpsKidUseAmt */
    public static final String ATTR_SCXPSKIDUSEAMT = "scxpsKidUseAmt";

    /** set 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
    public static final String ATTR_SCXPSKIDDDCTRGTAMT = "scxpsKidDdcTrgtAmt";

    /** set 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
    public static final String ATTR_SCXPSKIDDDCAMT = "scxpsKidDdcAmt";

    /** set 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
    public static final String ATTR_SCXPSSTDUSEAMT = "scxpsStdUseAmt";

    /** set 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
    public static final String ATTR_SCXPSSTDDDCTRGTAMT = "scxpsStdDdcTrgtAmt";

    /** set 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
    public static final String ATTR_SCXPSSTDDDCAMT = "scxpsStdDdcAmt";

    /** set 교육비_대학생납입금액 : scxpsUndUseAmt */
    public static final String ATTR_SCXPSUNDUSEAMT = "scxpsUndUseAmt";

    /** set 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
    public static final String ATTR_SCXPSUNDDDCTRGTAMT = "scxpsUndDdcTrgtAmt";

    /** set 교육비_대상생공제세액 : scxpsUndDdcAmt */
    public static final String ATTR_SCXPSUNDDDCAMT = "scxpsUndDdcAmt";

    /** set 교육비_장애인납입금액 : scxpsDsbrUseAmt */
    public static final String ATTR_SCXPSDSBRUSEAMT = "scxpsDsbrUseAmt";

    /** set 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
    public static final String ATTR_SCXPSDSBRDDCTRGTAMT = "scxpsDsbrDdcTrgtAmt";

    /** set 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
    public static final String ATTR_SCXPSDSBRDDCAMT = "scxpsDsbrDdcAmt";

    /** set 교육비_취학전아동인원수 : scxpsKidCount */
    public static final String ATTR_SCXPSKIDCOUNT = "scxpsKidCount";

    /** set 교육비_초중고등학교인원수 : scxpsStdCount */
    public static final String ATTR_SCXPSSTDCOUNT = "scxpsStdCount";

    /** set 교육비_대학생인원수 : scxpsUndCount */
    public static final String ATTR_SCXPSUNDCOUNT = "scxpsUndCount";

    /** set 교육비_장애인인원수 : scxpsDsbrCount */
    public static final String ATTR_SCXPSDSBRCOUNT = "scxpsDsbrCount";

    /** set 교육비납입금액합계 : scxpsUseAmtSum */
    public static final String ATTR_SCXPSUSEAMTSUM = "scxpsUseAmtSum";

    /** set 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
    public static final String ATTR_SCXPSDDCTRGTAMTSUM = "scxpsDdcTrgtAmtSum";

    /** set 교육비공제세액금액합계 : scxpsDdcAmtSum */
    public static final String ATTR_SCXPSDDCAMTSUM = "scxpsDdcAmtSum";

    /** set 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
    public static final String ATTR_CONB10TTSWLTUSEAMT = "conb10ttswLtUseAmt";

    /** set 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
    public static final String ATTR_CONB10TTSWLTDDCTRGTAMT = "conb10ttswLtDdcTrgtAmt";

    /** set 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
    public static final String ATTR_CONB10TTSWLTDDCAMT = "conb10ttswLtDdcAmt";

    /** set 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
    public static final String ATTR_CONB10EXCSLTUSEAMT = "conb10excsLtUseAmt";

    /** set 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
    public static final String ATTR_CONB10EXCSLTDDCTRGTAMT = "conb10excsLtDdcTrgtAmt";

    /** set 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
    public static final String ATTR_CONB10EXCSLTDDCAMT = "conb10excsLtDdcAmt";

    /** set 기부금_법정기부금납입금액 : conbLglUseAmt */
    public static final String ATTR_CONBLGLUSEAMT = "conbLglUseAmt";

    /** set 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
    public static final String ATTR_CONBLGLDDCTRGTAMT = "conbLglDdcTrgtAmt";

    /** set 기부금_법정기부금공제세액 : conbLglDdcAmt */
    public static final String ATTR_CONBLGLDDCAMT = "conbLglDdcAmt";

    /** set 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
    public static final String ATTR_CONBEMSTASCTUSEAMT = "conbEmstAsctUseAmt";

    /** set 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
    public static final String ATTR_CONBEMSTASCTDDCTRGTAMT = "conbEmstAsctDdcTrgtAmt";

    /** set 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
    public static final String ATTR_CONBEMSTASCTDDCAMT = "conbEmstAsctDdcAmt";

    /** set 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
    public static final String ATTR_CONBRELIORGOTHUSEAMT = "conbReliOrgOthUseAmt";

    /** set 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
    public static final String ATTR_CONBRELIORGOTHDDCTRGTAMT = "conbReliOrgOthDdcTrgtAmt";

    /** set 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
    public static final String ATTR_CONBRELIORGOTHDDCAMT = "conbReliOrgOthDdcAmt";

    /** set 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
    public static final String ATTR_CONBRELIORGUSEAMT = "conbReliOrgUseAmt";

    /** set 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
    public static final String ATTR_CONBRELIORGDDCTRGTAMT = "conbReliOrgDdcTrgtAmt";

    /** set 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
    public static final String ATTR_CONBRELIORGDDCAMT = "conbReliOrgDdcAmt";

    /** set 기부금납입금액합계 : conbUseAmtSum */
    public static final String ATTR_CONBUSEAMTSUM = "conbUseAmtSum";

    /** set 기부금공제대상금액합계 : conbDdcTrgtAmtSum */
    public static final String ATTR_CONBDDCTRGTAMTSUM = "conbDdcTrgtAmtSum";

    /** set 기부금공제세액합계 : conbDdcAmtSum */
    public static final String ATTR_CONBDDCAMTSUM = "conbDdcAmtSum";

    /** set 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
    public static final String ATTR_OVRSSURCINCFMT = "ovrsSurcIncFmt";

    /** set 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
    public static final String ATTR_FRGNPMTFCTXAMT = "frgnPmtFcTxamt";

    /** set 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
    public static final String ATTR_FRGNPMTWCTXAMT = "frgnPmtWcTxamt";

    /** set 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
    public static final String ATTR_FRGNPMTTXAMTTXPNTNNM = "frgnPmtTxamtTxpNtnNm";

    /** set 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
    public static final String ATTR_FRGNPMTTXAMTPMTDT = "frgnPmtTxamtPmtDt";

    /** set 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
    public static final String ATTR_FRGNPMTTXAMTALFASBMSDT = "frgnPmtTxamtAlfaSbmsDt";

    /** set 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
    public static final String ATTR_FRGNPMTTXAMTABRDWKARNM = "frgnPmtTxamtAbrdWkarNm";

    /** set 외국납부세액_근무기간일자 : frgnDtyTerm */
    public static final String ATTR_FRGNDTYTERM = "frgnDtyTerm";

    /** set 외국납부세액직책 : frgnPmtTxamtRfoNm */
    public static final String ATTR_FRGNPMTTXAMTRFONM = "frgnPmtTxamtRfoNm";

    /** set 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
    public static final String ATTR_HSNGTENNLNPBUSEAMT = "hsngTennLnpbUseAmt";

    /** set 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
    public static final String ATTR_HSNGTENNLNPBDDCAMT = "hsngTennLnpbDdcAmt";

    /** set 월세액세액공제지출금액 : mmrUseAmt */
    public static final String ATTR_MMRUSEAMT = "mmrUseAmt";

    /** set 월세액세액공제공제세액 : mmrDdcAmt */
    public static final String ATTR_MMRDDCAMT = "mmrDdcAmt";

    /** set 신고인성명 : cd218 */
    public static final String ATTR_CD218 = "cd218";

    /** set 외국인근로자단일세율적용신청서제출여부 : d219 */
    public static final String ATTR_D219 = "d219";

    /** set 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
    public static final String ATTR_PRCSPWORKINCMSUMTYN = "prcspWorkIncmSumtYn";

    /** set 연금저축등소득세액공제명세서제출여부 : cd225 */
    public static final String ATTR_CD225 = "cd225";

    /** set 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
    public static final String ATTR_CD226 = "cd226";

    /** set 의료비지급명세서제출여부 : cd227 */
    public static final String ATTR_CD227 = "cd227";

    /** set 기부금명세서제출여부 : cd228 */
    public static final String ATTR_CD228 = "cd228";

    /** set 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
    public static final String ATTR_INCMDDUCWTNNTESUMTDT = "incmDducWtnnteSumtDt";

    /** set 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** set 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** set 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** set 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** set 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** set 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** 생성자 */
     public Ye161080BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye161080BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  frgrLbrrEntcPupCd 
    		, String  frgrLbrrLbrOfrDt 
    		, String  frgrLbrrReExryDt 
    		, String  frgrLbrrReRcpnDt 
    		, String  frgrLbrrReAlfaSbmsDt 
    		, String  frgrLbrrErinImnRcpnDt 
    		, String  frgrLbrrErinImnSbmsDt 
    		, String  yupSnmcReStrtDt 
    		, String  yupSnmcReEndDt 
    		, Long  sctcHpUseAmt 
    		, Long  sctcHpDdcTrgtAmt 
    		, Long  sctcHpDdcAmt 
    		, Long  rtpnUseAmt 
    		, Long  rtpnDdcTrgtAmt 
    		, Long  rtpnDdcAmt 
    		, Long  pnsnSvngUseAmt 
    		, Long  pnsnSvngDdcTrgtAmt 
    		, Long  pnsnSvngDdcAmt 
    		, Long  pnsnAccUseAmtSum 
    		, Long  pnsnAccDdcTrgtAmtSum 
    		, Long  pnsnAccDdcAmtSum 
    		, Long  cvrgInscUseAmt 
    		, Long  cvrgInscDdcTrgtAmt2 
    		, Long  cvrgInscDdcAmt 
    		, Long  dsbrEuCvrgUseAmt 
    		, Long  dsbrEuCvrgDdcTrgtAmt 
    		, Long  dsbrEuCvrgDdcAmt 
    		, Long  infeePymUseAmtSum 
    		, Long  infeePymDdcTrgtAmtSum 
    		, Long  infeePymDdcAmtSum
    		, Long 	mdxpsLsInsrTrAmt
    		, Long  mdxpsPrsUseAmt 
    		, Long  mdxpsPrsDdcTrgtAmt 
    		, Long  mdxpsPrsDdcAmt 
    		, Long  mdxpsOthUseAmt 
    		, Long  mdxpsOthDdcTrgtAmt 
    		, Long  mdxpsOthDdcAmt 
    		, Long  mdxpsUseAmtSum 
    		, Long  mdxpsDdcTrgtAmtSum 
    		, Long  mdxpsDdcAmtSum 
    		, Long  scxpsPrsUseAmt 
    		, Long  scxpsPrsDdcTrgtAmt 
    		, Long  scxpsPrsDdcAmt 
    		, Long  scxpsKidUseAmt 
    		, Long  scxpsKidDdcTrgtAmt 
    		, Long  scxpsKidDdcAmt 
    		, Long  scxpsStdUseAmt 
    		, Long  scxpsStdDdcTrgtAmt 
    		, Long  scxpsStdDdcAmt 
    		, Long  scxpsUndUseAmt 
    		, Long  scxpsUndDdcTrgtAmt 
    		, Long  scxpsUndDdcAmt 
    		, Long  scxpsDsbrUseAmt 
    		, Long  scxpsDsbrDdcTrgtAmt 
    		, Long  scxpsDsbrDdcAmt 
    		, Long  scxpsKidCount 
    		, Long  scxpsStdCount 
    		, Long  scxpsUndCount 
    		, Long  scxpsDsbrCount 
    		, Long  scxpsUseAmtSum 
    		, Long  scxpsDdcTrgtAmtSum 
    		, Long  scxpsDdcAmtSum 
    		, Long  conb10ttswLtUseAmt 
    		, Long  conb10ttswLtDdcTrgtAmt 
    		, Long  conb10ttswLtDdcAmt 
    		, Long  conb10excsLtUseAmt 
    		, Long  conb10excsLtDdcTrgtAmt 
    		, Long  conb10excsLtDdcAmt 
    		, Long  conbLglUseAmt 
    		, Long  conbLglDdcTrgtAmt 
    		, Long  conbLglDdcAmt 
    		, Long  conbEmstAsctUseAmt 
    		, Long  conbEmstAsctDdcTrgtAmt 
    		, Long  conbEmstAsctDdcAmt 
    		, Long  conbReliOrgOthUseAmt 
    		, Long  conbReliOrgOthDdcTrgtAmt 
    		, Long  conbReliOrgOthDdcAmt 
    		, Long  conbReliOrgUseAmt 
    		, Long  conbReliOrgDdcTrgtAmt 
    		, Long  conbReliOrgDdcAmt 
    		, Long  conbUseAmtSum 
    		, Long  conbDdcTrgtAmtSum 
    		, Long  conbDdcAmtSum 
    		, Long  ovrsSurcIncFmt 
    		, Long  frgnPmtFcTxamt 
    		, Long  frgnPmtWcTxamt 
    		, String  frgnPmtTxamtTxpNtnNm 
    		, String  frgnPmtTxamtPmtDt 
    		, String  frgnPmtTxamtAlfaSbmsDt 
    		, String  frgnPmtTxamtAbrdWkarNm 
    		, String  frgnDtyTerm 
    		, String  frgnPmtTxamtRfoNm 
    		, Long  hsngTennLnpbUseAmt 
    		, Long  hsngTennLnpbDdcAmt 
    		, Long  mmrUseAmt 
    		, Long  mmrDdcAmt 
    		, String  cd218 
    		, String  d219 
    		, String  prcspWorkIncmSumtYn 
    		, String  cd225 
    		, String  cd226 
    		, String  cd227 
    		, String  cd228 
    		, String  incmDducWtnnteSumtDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr
    		) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_FRGRLBRRENTCPUPCD,frgrLbrrEntcPupCd);
     	values.put(ATTR_FRGRLBRRLBROFRDT,frgrLbrrLbrOfrDt);
     	values.put(ATTR_FRGRLBRRREEXRYDT,frgrLbrrReExryDt);
     	values.put(ATTR_FRGRLBRRRERCPNDT,frgrLbrrReRcpnDt);
     	values.put(ATTR_FRGRLBRRREALFASBMSDT,frgrLbrrReAlfaSbmsDt);
     	values.put(ATTR_FRGRLBRRERINIMNRCPNDT,frgrLbrrErinImnRcpnDt);
     	values.put(ATTR_FRGRLBRRERINIMNSBMSDT,frgrLbrrErinImnSbmsDt);
     	values.put(ATTR_YUPSNMCRESTRTDT,yupSnmcReStrtDt);
     	values.put(ATTR_YUPSNMCREENDDT,yupSnmcReEndDt);
     	values.put(ATTR_SCTCHPUSEAMT,sctcHpUseAmt);
     	values.put(ATTR_SCTCHPDDCTRGTAMT,sctcHpDdcTrgtAmt);
     	values.put(ATTR_SCTCHPDDCAMT,sctcHpDdcAmt);
     	values.put(ATTR_RTPNUSEAMT,rtpnUseAmt);
     	values.put(ATTR_RTPNDDCTRGTAMT,rtpnDdcTrgtAmt);
     	values.put(ATTR_RTPNDDCAMT,rtpnDdcAmt);
     	values.put(ATTR_PNSNSVNGUSEAMT,pnsnSvngUseAmt);
     	values.put(ATTR_PNSNSVNGDDCTRGTAMT,pnsnSvngDdcTrgtAmt);
     	values.put(ATTR_PNSNSVNGDDCAMT,pnsnSvngDdcAmt);
     	values.put(ATTR_PNSNACCUSEAMTSUM,pnsnAccUseAmtSum);
     	values.put(ATTR_PNSNACCDDCTRGTAMTSUM,pnsnAccDdcTrgtAmtSum);
     	values.put(ATTR_PNSNACCDDCAMTSUM,pnsnAccDdcAmtSum);
     	values.put(ATTR_CVRGINSCUSEAMT,cvrgInscUseAmt);
     	values.put(ATTR_CVRGINSCDDCTRGTAMT2,cvrgInscDdcTrgtAmt2);
     	values.put(ATTR_CVRGINSCDDCAMT,cvrgInscDdcAmt);
     	values.put(ATTR_DSBREUCVRGUSEAMT,dsbrEuCvrgUseAmt);
     	values.put(ATTR_DSBREUCVRGDDCTRGTAMT,dsbrEuCvrgDdcTrgtAmt);
     	values.put(ATTR_DSBREUCVRGDDCAMT,dsbrEuCvrgDdcAmt);
     	values.put(ATTR_INFEEPYMUSEAMTSUM,infeePymUseAmtSum);
     	values.put(ATTR_INFEEPYMDDCTRGTAMTSUM,infeePymDdcTrgtAmtSum);
     	values.put(ATTR_INFEEPYMDDCAMTSUM,infeePymDdcAmtSum);
     	values.put(ATTR_MDXPSLSINSRTRAMT,mdxpsLsInsrTrAmt);
     	values.put(ATTR_MDXPSPRSUSEAMT,mdxpsPrsUseAmt);
     	values.put(ATTR_MDXPSPRSDDCTRGTAMT,mdxpsPrsDdcTrgtAmt);
     	values.put(ATTR_MDXPSPRSDDCAMT,mdxpsPrsDdcAmt);
     	values.put(ATTR_MDXPSOTHUSEAMT,mdxpsOthUseAmt);
     	values.put(ATTR_MDXPSOTHDDCTRGTAMT,mdxpsOthDdcTrgtAmt);
     	values.put(ATTR_MDXPSOTHDDCAMT,mdxpsOthDdcAmt);
     	values.put(ATTR_MDXPSUSEAMTSUM,mdxpsUseAmtSum);
     	values.put(ATTR_MDXPSDDCTRGTAMTSUM,mdxpsDdcTrgtAmtSum);
     	values.put(ATTR_MDXPSDDCAMTSUM,mdxpsDdcAmtSum);
     	values.put(ATTR_SCXPSPRSUSEAMT,scxpsPrsUseAmt);
     	values.put(ATTR_SCXPSPRSDDCTRGTAMT,scxpsPrsDdcTrgtAmt);
     	values.put(ATTR_SCXPSPRSDDCAMT,scxpsPrsDdcAmt);
     	values.put(ATTR_SCXPSKIDUSEAMT,scxpsKidUseAmt);
     	values.put(ATTR_SCXPSKIDDDCTRGTAMT,scxpsKidDdcTrgtAmt);
     	values.put(ATTR_SCXPSKIDDDCAMT,scxpsKidDdcAmt);
     	values.put(ATTR_SCXPSSTDUSEAMT,scxpsStdUseAmt);
     	values.put(ATTR_SCXPSSTDDDCTRGTAMT,scxpsStdDdcTrgtAmt);
     	values.put(ATTR_SCXPSSTDDDCAMT,scxpsStdDdcAmt);
     	values.put(ATTR_SCXPSUNDUSEAMT,scxpsUndUseAmt);
     	values.put(ATTR_SCXPSUNDDDCTRGTAMT,scxpsUndDdcTrgtAmt);
     	values.put(ATTR_SCXPSUNDDDCAMT,scxpsUndDdcAmt);
     	values.put(ATTR_SCXPSDSBRUSEAMT,scxpsDsbrUseAmt);
     	values.put(ATTR_SCXPSDSBRDDCTRGTAMT,scxpsDsbrDdcTrgtAmt);
     	values.put(ATTR_SCXPSDSBRDDCAMT,scxpsDsbrDdcAmt);
     	values.put(ATTR_SCXPSKIDCOUNT,scxpsKidCount);
     	values.put(ATTR_SCXPSSTDCOUNT,scxpsStdCount);
     	values.put(ATTR_SCXPSUNDCOUNT,scxpsUndCount);
     	values.put(ATTR_SCXPSDSBRCOUNT,scxpsDsbrCount);
     	values.put(ATTR_SCXPSUSEAMTSUM,scxpsUseAmtSum);
     	values.put(ATTR_SCXPSDDCTRGTAMTSUM,scxpsDdcTrgtAmtSum);
     	values.put(ATTR_SCXPSDDCAMTSUM,scxpsDdcAmtSum);
     	values.put(ATTR_CONB10TTSWLTUSEAMT,conb10ttswLtUseAmt);
     	values.put(ATTR_CONB10TTSWLTDDCTRGTAMT,conb10ttswLtDdcTrgtAmt);
     	values.put(ATTR_CONB10TTSWLTDDCAMT,conb10ttswLtDdcAmt);
     	values.put(ATTR_CONB10EXCSLTUSEAMT,conb10excsLtUseAmt);
     	values.put(ATTR_CONB10EXCSLTDDCTRGTAMT,conb10excsLtDdcTrgtAmt);
     	values.put(ATTR_CONB10EXCSLTDDCAMT,conb10excsLtDdcAmt);
     	values.put(ATTR_CONBLGLUSEAMT,conbLglUseAmt);
     	values.put(ATTR_CONBLGLDDCTRGTAMT,conbLglDdcTrgtAmt);
     	values.put(ATTR_CONBLGLDDCAMT,conbLglDdcAmt);
     	values.put(ATTR_CONBEMSTASCTUSEAMT,conbEmstAsctUseAmt);
     	values.put(ATTR_CONBEMSTASCTDDCTRGTAMT,conbEmstAsctDdcTrgtAmt);
     	values.put(ATTR_CONBEMSTASCTDDCAMT,conbEmstAsctDdcAmt);
     	values.put(ATTR_CONBRELIORGOTHUSEAMT,conbReliOrgOthUseAmt);
     	values.put(ATTR_CONBRELIORGOTHDDCTRGTAMT,conbReliOrgOthDdcTrgtAmt);
     	values.put(ATTR_CONBRELIORGOTHDDCAMT,conbReliOrgOthDdcAmt);
     	values.put(ATTR_CONBRELIORGUSEAMT,conbReliOrgUseAmt);
     	values.put(ATTR_CONBRELIORGDDCTRGTAMT,conbReliOrgDdcTrgtAmt);
     	values.put(ATTR_CONBRELIORGDDCAMT,conbReliOrgDdcAmt);
     	values.put(ATTR_CONBUSEAMTSUM,conbUseAmtSum);
     	values.put(ATTR_CONBDDCTRGTAMTSUM,conbDdcTrgtAmtSum);
     	values.put(ATTR_CONBDDCAMTSUM,conbDdcAmtSum);
     	values.put(ATTR_OVRSSURCINCFMT,ovrsSurcIncFmt);
     	values.put(ATTR_FRGNPMTFCTXAMT,frgnPmtFcTxamt);
     	values.put(ATTR_FRGNPMTWCTXAMT,frgnPmtWcTxamt);
     	values.put(ATTR_FRGNPMTTXAMTTXPNTNNM,frgnPmtTxamtTxpNtnNm);
     	values.put(ATTR_FRGNPMTTXAMTPMTDT,frgnPmtTxamtPmtDt);
     	values.put(ATTR_FRGNPMTTXAMTALFASBMSDT,frgnPmtTxamtAlfaSbmsDt);
     	values.put(ATTR_FRGNPMTTXAMTABRDWKARNM,frgnPmtTxamtAbrdWkarNm);
     	values.put(ATTR_FRGNDTYTERM,frgnDtyTerm);
     	values.put(ATTR_FRGNPMTTXAMTRFONM,frgnPmtTxamtRfoNm);
     	values.put(ATTR_HSNGTENNLNPBUSEAMT,hsngTennLnpbUseAmt);
     	values.put(ATTR_HSNGTENNLNPBDDCAMT,hsngTennLnpbDdcAmt);
     	values.put(ATTR_MMRUSEAMT,mmrUseAmt);
     	values.put(ATTR_MMRDDCAMT,mmrDdcAmt);
     	values.put(ATTR_CD218,cd218);
     	values.put(ATTR_D219,d219);
     	values.put(ATTR_PRCSPWORKINCMSUMTYN,prcspWorkIncmSumtYn);
     	values.put(ATTR_CD225,cd225);
     	values.put(ATTR_CD226,cd226);
     	values.put(ATTR_CD227,cd227);
     	values.put(ATTR_CD228,cd228);
     	values.put(ATTR_INCMDDUCWTNNTESUMTDT,incmDducWtnnteSumtDt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}
    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
    public void setFrgrLbrrEntcPupCd(String  frgrLbrrEntcPupCd) { set( ATTR_FRGRLBRRENTCPUPCD ,frgrLbrrEntcPupCd);}
    /** get 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
    public String  getFrgrLbrrEntcPupCd() { return (String )get( ATTR_FRGRLBRRENTCPUPCD );}
    /** set 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
    public void setFrgrLbrrLbrOfrDt(String  frgrLbrrLbrOfrDt) { set( ATTR_FRGRLBRRLBROFRDT ,frgrLbrrLbrOfrDt);}
    /** get 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
    public String  getFrgrLbrrLbrOfrDt() { return (String )get( ATTR_FRGRLBRRLBROFRDT );}
    /** set 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
    public void setFrgrLbrrReExryDt(String  frgrLbrrReExryDt) { set( ATTR_FRGRLBRRREEXRYDT ,frgrLbrrReExryDt);}
    /** get 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
    public String  getFrgrLbrrReExryDt() { return (String )get( ATTR_FRGRLBRRREEXRYDT );}
    /** set 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
    public void setFrgrLbrrReRcpnDt(String  frgrLbrrReRcpnDt) { set( ATTR_FRGRLBRRRERCPNDT ,frgrLbrrReRcpnDt);}
    /** get 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
    public String  getFrgrLbrrReRcpnDt() { return (String )get( ATTR_FRGRLBRRRERCPNDT );}
    /** set 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
    public void setFrgrLbrrReAlfaSbmsDt(String  frgrLbrrReAlfaSbmsDt) { set( ATTR_FRGRLBRRREALFASBMSDT ,frgrLbrrReAlfaSbmsDt);}
    /** get 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
    public String  getFrgrLbrrReAlfaSbmsDt() { return (String )get( ATTR_FRGRLBRRREALFASBMSDT );}
    /** set 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
    public void setFrgrLbrrErinImnRcpnDt(String  frgrLbrrErinImnRcpnDt) { set( ATTR_FRGRLBRRERINIMNRCPNDT ,frgrLbrrErinImnRcpnDt);}
    /** get 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
    public String  getFrgrLbrrErinImnRcpnDt() { return (String )get( ATTR_FRGRLBRRERINIMNRCPNDT );}
    /** set 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
    public void setFrgrLbrrErinImnSbmsDt(String  frgrLbrrErinImnSbmsDt) { set( ATTR_FRGRLBRRERINIMNSBMSDT ,frgrLbrrErinImnSbmsDt);}
    /** get 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
    public String  getFrgrLbrrErinImnSbmsDt() { return (String )get( ATTR_FRGRLBRRERINIMNSBMSDT );}
    /** set 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
    public void setYupSnmcReStrtDt(String  yupSnmcReStrtDt) { set( ATTR_YUPSNMCRESTRTDT ,yupSnmcReStrtDt);}
    /** get 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
    public String  getYupSnmcReStrtDt() { return (String )get( ATTR_YUPSNMCRESTRTDT );}
    /** set 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
    public void setYupSnmcReEndDt(String  yupSnmcReEndDt) { set( ATTR_YUPSNMCREENDDT ,yupSnmcReEndDt);}
    /** get 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
    public String  getYupSnmcReEndDt() { return (String )get( ATTR_YUPSNMCREENDDT );}
    /** set 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
    public void setSctcHpUseAmt(Long  sctcHpUseAmt) { set( ATTR_SCTCHPUSEAMT ,sctcHpUseAmt);}
    /** get 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
    public Long  getSctcHpUseAmt() { return (Long )get( ATTR_SCTCHPUSEAMT );}
    /** set 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
    public void setSctcHpDdcTrgtAmt(Long  sctcHpDdcTrgtAmt) { set( ATTR_SCTCHPDDCTRGTAMT ,sctcHpDdcTrgtAmt);}
    /** get 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
    public Long  getSctcHpDdcTrgtAmt() { return (Long )get( ATTR_SCTCHPDDCTRGTAMT );}
    /** set 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
    public void setSctcHpDdcAmt(Long  sctcHpDdcAmt) { set( ATTR_SCTCHPDDCAMT ,sctcHpDdcAmt);}
    /** get 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
    public Long  getSctcHpDdcAmt() { return (Long )get( ATTR_SCTCHPDDCAMT );}
    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
    public void setRtpnUseAmt(Long  rtpnUseAmt) { set( ATTR_RTPNUSEAMT ,rtpnUseAmt);}
    /** get 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
    public Long  getRtpnUseAmt() { return (Long )get( ATTR_RTPNUSEAMT );}
    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
    public void setRtpnDdcTrgtAmt(Long  rtpnDdcTrgtAmt) { set( ATTR_RTPNDDCTRGTAMT ,rtpnDdcTrgtAmt);}
    /** get 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
    public Long  getRtpnDdcTrgtAmt() { return (Long )get( ATTR_RTPNDDCTRGTAMT );}
    /** set 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
    public void setRtpnDdcAmt(Long  rtpnDdcAmt) { set( ATTR_RTPNDDCAMT ,rtpnDdcAmt);}
    /** get 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
    public Long  getRtpnDdcAmt() { return (Long )get( ATTR_RTPNDDCAMT );}
    /** set 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
    public void setPnsnSvngUseAmt(Long  pnsnSvngUseAmt) { set( ATTR_PNSNSVNGUSEAMT ,pnsnSvngUseAmt);}
    /** get 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
    public Long  getPnsnSvngUseAmt() { return (Long )get( ATTR_PNSNSVNGUSEAMT );}
    /** set 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
    public void setPnsnSvngDdcTrgtAmt(Long  pnsnSvngDdcTrgtAmt) { set( ATTR_PNSNSVNGDDCTRGTAMT ,pnsnSvngDdcTrgtAmt);}
    /** get 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
    public Long  getPnsnSvngDdcTrgtAmt() { return (Long )get( ATTR_PNSNSVNGDDCTRGTAMT );}
    /** set 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
    public void setPnsnSvngDdcAmt(Long  pnsnSvngDdcAmt) { set( ATTR_PNSNSVNGDDCAMT ,pnsnSvngDdcAmt);}
    /** get 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
    public Long  getPnsnSvngDdcAmt() { return (Long )get( ATTR_PNSNSVNGDDCAMT );}
    /** set 연금계좌납입금액합계 : pnsnAccUseAmtSum */
    public void setPnsnAccUseAmtSum(Long  pnsnAccUseAmtSum) { set( ATTR_PNSNACCUSEAMTSUM ,pnsnAccUseAmtSum);}
    /** get 연금계좌납입금액합계 : pnsnAccUseAmtSum */
    public Long  getPnsnAccUseAmtSum() { return (Long )get( ATTR_PNSNACCUSEAMTSUM );}
    /** set 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
    public void setPnsnAccDdcTrgtAmtSum(Long  pnsnAccDdcTrgtAmtSum) { set( ATTR_PNSNACCDDCTRGTAMTSUM ,pnsnAccDdcTrgtAmtSum);}
    /** get 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
    public Long  getPnsnAccDdcTrgtAmtSum() { return (Long )get( ATTR_PNSNACCDDCTRGTAMTSUM );}
    /** set 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
    public void setPnsnAccDdcAmtSum(Long  pnsnAccDdcAmtSum) { set( ATTR_PNSNACCDDCAMTSUM ,pnsnAccDdcAmtSum);}
    /** get 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
    public Long  getPnsnAccDdcAmtSum() { return (Long )get( ATTR_PNSNACCDDCAMTSUM );}
    /** set 보장성보험납입금액 : cvrgInscUseAmt */
    public void setCvrgInscUseAmt(Long  cvrgInscUseAmt) { set( ATTR_CVRGINSCUSEAMT ,cvrgInscUseAmt);}
    /** get 보장성보험납입금액 : cvrgInscUseAmt */
    public Long  getCvrgInscUseAmt() { return (Long )get( ATTR_CVRGINSCUSEAMT );}
    /** set 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
    public void setCvrgInscDdcTrgtAmt2(Long  cvrgInscDdcTrgtAmt2) { set( ATTR_CVRGINSCDDCTRGTAMT2 ,cvrgInscDdcTrgtAmt2);}
    /** get 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
    public Long  getCvrgInscDdcTrgtAmt2() { return (Long )get( ATTR_CVRGINSCDDCTRGTAMT2 );}
    /** set 보장성보험공제세액 : cvrgInscDdcAmt */
    public void setCvrgInscDdcAmt(Long  cvrgInscDdcAmt) { set( ATTR_CVRGINSCDDCAMT ,cvrgInscDdcAmt);}
    /** get 보장성보험공제세액 : cvrgInscDdcAmt */
    public Long  getCvrgInscDdcAmt() { return (Long )get( ATTR_CVRGINSCDDCAMT );}
    /** set 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
    public void setDsbrEuCvrgUseAmt(Long  dsbrEuCvrgUseAmt) { set( ATTR_DSBREUCVRGUSEAMT ,dsbrEuCvrgUseAmt);}
    /** get 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
    public Long  getDsbrEuCvrgUseAmt() { return (Long )get( ATTR_DSBREUCVRGUSEAMT );}
    /** set 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
    public void setDsbrEuCvrgDdcTrgtAmt(Long  dsbrEuCvrgDdcTrgtAmt) { set( ATTR_DSBREUCVRGDDCTRGTAMT ,dsbrEuCvrgDdcTrgtAmt);}
    /** get 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
    public Long  getDsbrEuCvrgDdcTrgtAmt() { return (Long )get( ATTR_DSBREUCVRGDDCTRGTAMT );}
    /** set 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
    public void setDsbrEuCvrgDdcAmt(Long  dsbrEuCvrgDdcAmt) { set( ATTR_DSBREUCVRGDDCAMT ,dsbrEuCvrgDdcAmt);}
    /** get 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
    public Long  getDsbrEuCvrgDdcAmt() { return (Long )get( ATTR_DSBREUCVRGDDCAMT );}
    /** set 보험료납입금액합계 : infeePymUseAmtSum */
    public void setInfeePymUseAmtSum(Long  infeePymUseAmtSum) { set( ATTR_INFEEPYMUSEAMTSUM ,infeePymUseAmtSum);}
    /** get 보험료납입금액합계 : infeePymUseAmtSum */
    public Long  getInfeePymUseAmtSum() { return (Long )get( ATTR_INFEEPYMUSEAMTSUM );}
    /** set 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
    public void setInfeePymDdcTrgtAmtSum(Long  infeePymDdcTrgtAmtSum) { set( ATTR_INFEEPYMDDCTRGTAMTSUM ,infeePymDdcTrgtAmtSum);}
    /** get 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
    public Long  getInfeePymDdcTrgtAmtSum() { return (Long )get( ATTR_INFEEPYMDDCTRGTAMTSUM );}
    /** set 보험료공제세액합계 : infeePymDdcAmtSum */
    public void setInfeePymDdcAmtSum(Long  infeePymDdcAmtSum) { set( ATTR_INFEEPYMDDCAMTSUM ,infeePymDdcAmtSum);}
    /** get 보험료공제세액합계 : infeePymDdcAmtSum */
    public Long  getInfeePymDdcAmtSum() { return (Long )get( ATTR_INFEEPYMDDCAMTSUM );}
    /** set 의료비_실손보험금보전액  : mdxpsLsInsrTrAmt  */
    public void setMdxpsLsInsrTrAmt (Long  mdxpsLsInsrTrAmt) { set( ATTR_MDXPSLSINSRTRAMT ,mdxpsLsInsrTrAmt);}
    /** get 의료비_실손보험금보전액  : mdxpsLsInsrTrAmt  */
    public Long  getMdxpsLsInsrTrAmt () { return (Long )get( ATTR_MDXPSLSINSRTRAMT );}
    /** set 의료비_난임시술비납입금액 : mdxpsSftSprcdUseAmt */
    public void setMdxpsSftSprcdUseAmt(Long  mdxpsSftSprcdUseAmt) { set( ATTR_MDXPSSFTSPRCDUSEAMT ,mdxpsSftSprcdUseAmt);}
    /** get 의료비_난임시술비납입금액 : mdxpsSftSprcdUseAmt */
    public Long  getMdxpsSftSprcdUseAmt() { return (Long )get( ATTR_MDXPSSFTSPRCDUSEAMT );}
    /** set 의료비_난임시술비공제대상금액 : mdxpsSftSprcdDdcTrgtAmt */
    public void setMdxpsSftSprcdDdcTrgtAmt(Long  mdxpsSftSprcdDdcTrgtAmt) { set( ATTR_MDXPSSFTSPRCDDDCTRGTAMT ,mdxpsSftSprcdDdcTrgtAmt);}
    /** get 의료비_난임시술비공제대상금액 : mdxpsSftSprcdDdcTrgtAmt */
    public Long  getMdxpsSftSprcdDdcTrgtAmt() { return (Long )get( ATTR_MDXPSSFTSPRCDDDCTRGTAMT );}
    /** set 의료비_난임시술비공제세액 : mdxpsSftSprcdDdcAmt */
    public void setMdxpsSftSprcdDdcAmt(Long  mdxpsSftSprcdDdcAmt) { set( ATTR_MDXPSSFTSPRCDDDCAMT ,mdxpsSftSprcdDdcAmt);}
    /** get 의료비_난임시술비공제세액 : mdxpsSftSprcdDdcAmt */
    public Long  getMdxpsSftSprcdDdcAmt() { return (Long )get( ATTR_MDXPSSFTSPRCDDDCAMT );}
    /** set 의료비_본인65세이상장애인난임시술비납입금액 : mdxpsPrsUseAmt */
    public void setMdxpsPrsUseAmt(Long  mdxpsPrsUseAmt) { set( ATTR_MDXPSPRSUSEAMT ,mdxpsPrsUseAmt);}
    /** get 의료비_본인65세이상장애인난임시술비납입금액 : mdxpsPrsUseAmt */
    public Long  getMdxpsPrsUseAmt() { return (Long )get( ATTR_MDXPSPRSUSEAMT );}
    /** set 의료비_본인65세이상장애인난임시술비공제대상금액 : mdxpsPrsDdcTrgtAmt */
    public void setMdxpsPrsDdcTrgtAmt(Long  mdxpsPrsDdcTrgtAmt) { set( ATTR_MDXPSPRSDDCTRGTAMT ,mdxpsPrsDdcTrgtAmt);}
    /** get 의료비_본인65세이상장애인난임시술비공제대상금액 : mdxpsPrsDdcTrgtAmt */
    public Long  getMdxpsPrsDdcTrgtAmt() { return (Long )get( ATTR_MDXPSPRSDDCTRGTAMT );}
    /** set 의료비_본인65세이상장애인난임시술비공제세액 : mdxpsPrsDdcAmt */
    public void setMdxpsPrsDdcAmt(Long  mdxpsPrsDdcAmt) { set( ATTR_MDXPSPRSDDCAMT ,mdxpsPrsDdcAmt);}
    /** get 의료비_본인65세이상장애인난임시술비공제세액 : mdxpsPrsDdcAmt */
    public Long  getMdxpsPrsDdcAmt() { return (Long )get( ATTR_MDXPSPRSDDCAMT );}
    /** set 의료비_그밖의공제대상자납입금액 : mdxpsOthUseAmt */
    public void setMdxpsOthUseAmt(Long  mdxpsOthUseAmt) { set( ATTR_MDXPSOTHUSEAMT ,mdxpsOthUseAmt);}
    /** get 의료비_그밖의공제대상자납입금액 : mdxpsOthUseAmt */
    public Long  getMdxpsOthUseAmt() { return (Long )get( ATTR_MDXPSOTHUSEAMT );}
    /** set 의료비_그밖의공제대상자공제대상금액 : mdxpsOthDdcTrgtAmt */
    public void setMdxpsOthDdcTrgtAmt(Long  mdxpsOthDdcTrgtAmt) { set( ATTR_MDXPSOTHDDCTRGTAMT ,mdxpsOthDdcTrgtAmt);}
    /** get 의료비_그밖의공제대상자공제대상금액 : mdxpsOthDdcTrgtAmt */
    public Long  getMdxpsOthDdcTrgtAmt() { return (Long )get( ATTR_MDXPSOTHDDCTRGTAMT );}
    /** set 의료비_그밖의공제대상자공제새액 : mdxpsOthDdcAmt */
    public void setMdxpsOthDdcAmt(Long  mdxpsOthDdcAmt) { set( ATTR_MDXPSOTHDDCAMT ,mdxpsOthDdcAmt);}
    /** get 의료비_그밖의공제대상자공제새액 : mdxpsOthDdcAmt */
    public Long  getMdxpsOthDdcAmt() { return (Long )get( ATTR_MDXPSOTHDDCAMT );}
    /** set 의료비납입금액합계 : mdxpsUseAmtSum */
    public void setMdxpsUseAmtSum(Long  mdxpsUseAmtSum) { set( ATTR_MDXPSUSEAMTSUM ,mdxpsUseAmtSum);}
    /** get 의료비납입금액합계 : mdxpsUseAmtSum */
    public Long  getMdxpsUseAmtSum() { return (Long )get( ATTR_MDXPSUSEAMTSUM );}
    /** set 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
    public void setMdxpsDdcTrgtAmtSum(Long  mdxpsDdcTrgtAmtSum) { set( ATTR_MDXPSDDCTRGTAMTSUM ,mdxpsDdcTrgtAmtSum);}
    /** get 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
    public Long  getMdxpsDdcTrgtAmtSum() { return (Long )get( ATTR_MDXPSDDCTRGTAMTSUM );}
    /** set 의료비공제세액합계 : mdxpsDdcAmtSum */
    public void setMdxpsDdcAmtSum(Long  mdxpsDdcAmtSum) { set( ATTR_MDXPSDDCAMTSUM ,mdxpsDdcAmtSum);}
    /** get 의료비공제세액합계 : mdxpsDdcAmtSum */
    public Long  getMdxpsDdcAmtSum() { return (Long )get( ATTR_MDXPSDDCAMTSUM );}
    /** set 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
    public void setScxpsPrsUseAmt(Long  scxpsPrsUseAmt) { set( ATTR_SCXPSPRSUSEAMT ,scxpsPrsUseAmt);}
    /** get 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
    public Long  getScxpsPrsUseAmt() { return (Long )get( ATTR_SCXPSPRSUSEAMT );}
    /** set 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
    public void setScxpsPrsDdcTrgtAmt(Long  scxpsPrsDdcTrgtAmt) { set( ATTR_SCXPSPRSDDCTRGTAMT ,scxpsPrsDdcTrgtAmt);}
    /** get 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
    public Long  getScxpsPrsDdcTrgtAmt() { return (Long )get( ATTR_SCXPSPRSDDCTRGTAMT );}
    /** set 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
    public void setScxpsPrsDdcAmt(Long  scxpsPrsDdcAmt) { set( ATTR_SCXPSPRSDDCAMT ,scxpsPrsDdcAmt);}
    /** get 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
    public Long  getScxpsPrsDdcAmt() { return (Long )get( ATTR_SCXPSPRSDDCAMT );}
    /** set 교육비_취학전아동납입금액 : scxpsKidUseAmt */
    public void setScxpsKidUseAmt(Long  scxpsKidUseAmt) { set( ATTR_SCXPSKIDUSEAMT ,scxpsKidUseAmt);}
    /** get 교육비_취학전아동납입금액 : scxpsKidUseAmt */
    public Long  getScxpsKidUseAmt() { return (Long )get( ATTR_SCXPSKIDUSEAMT );}
    /** set 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
    public void setScxpsKidDdcTrgtAmt(Long  scxpsKidDdcTrgtAmt) { set( ATTR_SCXPSKIDDDCTRGTAMT ,scxpsKidDdcTrgtAmt);}
    /** get 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
    public Long  getScxpsKidDdcTrgtAmt() { return (Long )get( ATTR_SCXPSKIDDDCTRGTAMT );}
    /** set 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
    public void setScxpsKidDdcAmt(Long  scxpsKidDdcAmt) { set( ATTR_SCXPSKIDDDCAMT ,scxpsKidDdcAmt);}
    /** get 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
    public Long  getScxpsKidDdcAmt() { return (Long )get( ATTR_SCXPSKIDDDCAMT );}
    /** set 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
    public void setScxpsStdUseAmt(Long  scxpsStdUseAmt) { set( ATTR_SCXPSSTDUSEAMT ,scxpsStdUseAmt);}
    /** get 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
    public Long  getScxpsStdUseAmt() { return (Long )get( ATTR_SCXPSSTDUSEAMT );}
    /** set 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
    public void setScxpsStdDdcTrgtAmt(Long  scxpsStdDdcTrgtAmt) { set( ATTR_SCXPSSTDDDCTRGTAMT ,scxpsStdDdcTrgtAmt);}
    /** get 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
    public Long  getScxpsStdDdcTrgtAmt() { return (Long )get( ATTR_SCXPSSTDDDCTRGTAMT );}
    /** set 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
    public void setScxpsStdDdcAmt(Long  scxpsStdDdcAmt) { set( ATTR_SCXPSSTDDDCAMT ,scxpsStdDdcAmt);}
    /** get 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
    public Long  getScxpsStdDdcAmt() { return (Long )get( ATTR_SCXPSSTDDDCAMT );}
    /** set 교육비_대학생납입금액 : scxpsUndUseAmt */
    public void setScxpsUndUseAmt(Long  scxpsUndUseAmt) { set( ATTR_SCXPSUNDUSEAMT ,scxpsUndUseAmt);}
    /** get 교육비_대학생납입금액 : scxpsUndUseAmt */
    public Long  getScxpsUndUseAmt() { return (Long )get( ATTR_SCXPSUNDUSEAMT );}
    /** set 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
    public void setScxpsUndDdcTrgtAmt(Long  scxpsUndDdcTrgtAmt) { set( ATTR_SCXPSUNDDDCTRGTAMT ,scxpsUndDdcTrgtAmt);}
    /** get 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
    public Long  getScxpsUndDdcTrgtAmt() { return (Long )get( ATTR_SCXPSUNDDDCTRGTAMT );}
    /** set 교육비_대상생공제세액 : scxpsUndDdcAmt */
    public void setScxpsUndDdcAmt(Long  scxpsUndDdcAmt) { set( ATTR_SCXPSUNDDDCAMT ,scxpsUndDdcAmt);}
    /** get 교육비_대상생공제세액 : scxpsUndDdcAmt */
    public Long  getScxpsUndDdcAmt() { return (Long )get( ATTR_SCXPSUNDDDCAMT );}
    /** set 교육비_장애인납입금액 : scxpsDsbrUseAmt */
    public void setScxpsDsbrUseAmt(Long  scxpsDsbrUseAmt) { set( ATTR_SCXPSDSBRUSEAMT ,scxpsDsbrUseAmt);}
    /** get 교육비_장애인납입금액 : scxpsDsbrUseAmt */
    public Long  getScxpsDsbrUseAmt() { return (Long )get( ATTR_SCXPSDSBRUSEAMT );}
    /** set 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
    public void setScxpsDsbrDdcTrgtAmt(Long  scxpsDsbrDdcTrgtAmt) { set( ATTR_SCXPSDSBRDDCTRGTAMT ,scxpsDsbrDdcTrgtAmt);}
    /** get 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
    public Long  getScxpsDsbrDdcTrgtAmt() { return (Long )get( ATTR_SCXPSDSBRDDCTRGTAMT );}
    /** set 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
    public void setScxpsDsbrDdcAmt(Long  scxpsDsbrDdcAmt) { set( ATTR_SCXPSDSBRDDCAMT ,scxpsDsbrDdcAmt);}
    /** get 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
    public Long  getScxpsDsbrDdcAmt() { return (Long )get( ATTR_SCXPSDSBRDDCAMT );}
    /** set 교육비_취학전아동인원수 : scxpsKidCount */
    public void setScxpsKidCount(Long  scxpsKidCount) { set( ATTR_SCXPSKIDCOUNT ,scxpsKidCount);}
    /** get 교육비_취학전아동인원수 : scxpsKidCount */
    public Long  getScxpsKidCount() { return (Long )get( ATTR_SCXPSKIDCOUNT );}
    /** set 교육비_초중고등학교인원수 : scxpsStdCount */
    public void setScxpsStdCount(Long  scxpsStdCount) { set( ATTR_SCXPSSTDCOUNT ,scxpsStdCount);}
    /** get 교육비_초중고등학교인원수 : scxpsStdCount */
    public Long  getScxpsStdCount() { return (Long )get( ATTR_SCXPSSTDCOUNT );}
    /** set 교육비_대학생인원수 : scxpsUndCount */
    public void setScxpsUndCount(Long  scxpsUndCount) { set( ATTR_SCXPSUNDCOUNT ,scxpsUndCount);}
    /** get 교육비_대학생인원수 : scxpsUndCount */
    public Long  getScxpsUndCount() { return (Long )get( ATTR_SCXPSUNDCOUNT );}
    /** set 교육비_장애인인원수 : scxpsDsbrCount */
    public void setScxpsDsbrCount(Long  scxpsDsbrCount) { set( ATTR_SCXPSDSBRCOUNT ,scxpsDsbrCount);}
    /** get 교육비_장애인인원수 : scxpsDsbrCount */
    public Long  getScxpsDsbrCount() { return (Long )get( ATTR_SCXPSDSBRCOUNT );}
    /** set 교육비납입금액합계 : scxpsUseAmtSum */
    public void setScxpsUseAmtSum(Long  scxpsUseAmtSum) { set( ATTR_SCXPSUSEAMTSUM ,scxpsUseAmtSum);}
    /** get 교육비납입금액합계 : scxpsUseAmtSum */
    public Long  getScxpsUseAmtSum() { return (Long )get( ATTR_SCXPSUSEAMTSUM );}
    /** set 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
    public void setScxpsDdcTrgtAmtSum(Long  scxpsDdcTrgtAmtSum) { set( ATTR_SCXPSDDCTRGTAMTSUM ,scxpsDdcTrgtAmtSum);}
    /** get 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
    public Long  getScxpsDdcTrgtAmtSum() { return (Long )get( ATTR_SCXPSDDCTRGTAMTSUM );}
    /** set 교육비공제세액금액합계 : scxpsDdcAmtSum */
    public void setScxpsDdcAmtSum(Long  scxpsDdcAmtSum) { set( ATTR_SCXPSDDCAMTSUM ,scxpsDdcAmtSum);}
    /** get 교육비공제세액금액합계 : scxpsDdcAmtSum */
    public Long  getScxpsDdcAmtSum() { return (Long )get( ATTR_SCXPSDDCAMTSUM );}
    /** set 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
    public void setConb10ttswLtUseAmt(Long  conb10ttswLtUseAmt) { set( ATTR_CONB10TTSWLTUSEAMT ,conb10ttswLtUseAmt);}
    /** get 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
    public Long  getConb10ttswLtUseAmt() { return (Long )get( ATTR_CONB10TTSWLTUSEAMT );}
    /** set 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
    public void setConb10ttswLtDdcTrgtAmt(Long  conb10ttswLtDdcTrgtAmt) { set( ATTR_CONB10TTSWLTDDCTRGTAMT ,conb10ttswLtDdcTrgtAmt);}
    /** get 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
    public Long  getConb10ttswLtDdcTrgtAmt() { return (Long )get( ATTR_CONB10TTSWLTDDCTRGTAMT );}
    /** set 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
    public void setConb10ttswLtDdcAmt(Long  conb10ttswLtDdcAmt) { set( ATTR_CONB10TTSWLTDDCAMT ,conb10ttswLtDdcAmt);}
    /** get 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
    public Long  getConb10ttswLtDdcAmt() { return (Long )get( ATTR_CONB10TTSWLTDDCAMT );}
    /** set 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
    public void setConb10excsLtUseAmt(Long  conb10excsLtUseAmt) { set( ATTR_CONB10EXCSLTUSEAMT ,conb10excsLtUseAmt);}
    /** get 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
    public Long  getConb10excsLtUseAmt() { return (Long )get( ATTR_CONB10EXCSLTUSEAMT );}
    /** set 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
    public void setConb10excsLtDdcTrgtAmt(Long  conb10excsLtDdcTrgtAmt) { set( ATTR_CONB10EXCSLTDDCTRGTAMT ,conb10excsLtDdcTrgtAmt);}
    /** get 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
    public Long  getConb10excsLtDdcTrgtAmt() { return (Long )get( ATTR_CONB10EXCSLTDDCTRGTAMT );}
    /** set 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
    public void setConb10excsLtDdcAmt(Long  conb10excsLtDdcAmt) { set( ATTR_CONB10EXCSLTDDCAMT ,conb10excsLtDdcAmt);}
    /** get 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
    public Long  getConb10excsLtDdcAmt() { return (Long )get( ATTR_CONB10EXCSLTDDCAMT );}
    /** set 기부금_법정기부금납입금액 : conbLglUseAmt */
    public void setConbLglUseAmt(Long  conbLglUseAmt) { set( ATTR_CONBLGLUSEAMT ,conbLglUseAmt);}
    /** get 기부금_법정기부금납입금액 : conbLglUseAmt */
    public Long  getConbLglUseAmt() { return (Long )get( ATTR_CONBLGLUSEAMT );}
    /** set 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
    public void setConbLglDdcTrgtAmt(Long  conbLglDdcTrgtAmt) { set( ATTR_CONBLGLDDCTRGTAMT ,conbLglDdcTrgtAmt);}
    /** get 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
    public Long  getConbLglDdcTrgtAmt() { return (Long )get( ATTR_CONBLGLDDCTRGTAMT );}
    /** set 기부금_법정기부금공제세액 : conbLglDdcAmt */
    public void setConbLglDdcAmt(Long  conbLglDdcAmt) { set( ATTR_CONBLGLDDCAMT ,conbLglDdcAmt);}
    /** get 기부금_법정기부금공제세액 : conbLglDdcAmt */
    public Long  getConbLglDdcAmt() { return (Long )get( ATTR_CONBLGLDDCAMT );}
    /** set 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
    public void setConbEmstAsctUseAmt(Long  conbEmstAsctUseAmt) { set( ATTR_CONBEMSTASCTUSEAMT ,conbEmstAsctUseAmt);}
    /** get 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
    public Long  getConbEmstAsctUseAmt() { return (Long )get( ATTR_CONBEMSTASCTUSEAMT );}
    /** set 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
    public void setConbEmstAsctDdcTrgtAmt(Long  conbEmstAsctDdcTrgtAmt) { set( ATTR_CONBEMSTASCTDDCTRGTAMT ,conbEmstAsctDdcTrgtAmt);}
    /** get 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
    public Long  getConbEmstAsctDdcTrgtAmt() { return (Long )get( ATTR_CONBEMSTASCTDDCTRGTAMT );}
    /** set 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
    public void setConbEmstAsctDdcAmt(Long  conbEmstAsctDdcAmt) { set( ATTR_CONBEMSTASCTDDCAMT ,conbEmstAsctDdcAmt);}
    /** get 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
    public Long  getConbEmstAsctDdcAmt() { return (Long )get( ATTR_CONBEMSTASCTDDCAMT );}
    /** set 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
    public void setConbReliOrgOthUseAmt(Long  conbReliOrgOthUseAmt) { set( ATTR_CONBRELIORGOTHUSEAMT ,conbReliOrgOthUseAmt);}
    /** get 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
    public Long  getConbReliOrgOthUseAmt() { return (Long )get( ATTR_CONBRELIORGOTHUSEAMT );}
    /** set 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
    public void setConbReliOrgOthDdcTrgtAmt(Long  conbReliOrgOthDdcTrgtAmt) { set( ATTR_CONBRELIORGOTHDDCTRGTAMT ,conbReliOrgOthDdcTrgtAmt);}
    /** get 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
    public Long  getConbReliOrgOthDdcTrgtAmt() { return (Long )get( ATTR_CONBRELIORGOTHDDCTRGTAMT );}
    /** set 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
    public void setConbReliOrgOthDdcAmt(Long  conbReliOrgOthDdcAmt) { set( ATTR_CONBRELIORGOTHDDCAMT ,conbReliOrgOthDdcAmt);}
    /** get 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
    public Long  getConbReliOrgOthDdcAmt() { return (Long )get( ATTR_CONBRELIORGOTHDDCAMT );}
    /** set 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
    public void setConbReliOrgUseAmt(Long  conbReliOrgUseAmt) { set( ATTR_CONBRELIORGUSEAMT ,conbReliOrgUseAmt);}
    /** get 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
    public Long  getConbReliOrgUseAmt() { return (Long )get( ATTR_CONBRELIORGUSEAMT );}
    /** set 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
    public void setConbReliOrgDdcTrgtAmt(Long  conbReliOrgDdcTrgtAmt) { set( ATTR_CONBRELIORGDDCTRGTAMT ,conbReliOrgDdcTrgtAmt);}
    /** get 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
    public Long  getConbReliOrgDdcTrgtAmt() { return (Long )get( ATTR_CONBRELIORGDDCTRGTAMT );}
    /** set 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
    public void setConbReliOrgDdcAmt(Long  conbReliOrgDdcAmt) { set( ATTR_CONBRELIORGDDCAMT ,conbReliOrgDdcAmt);}
    /** get 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
    public Long  getConbReliOrgDdcAmt() { return (Long )get( ATTR_CONBRELIORGDDCAMT );}
    /** set 기부금납입금액합계 : conbUseAmtSum */
    public void setConbUseAmtSum(Long  conbUseAmtSum) { set( ATTR_CONBUSEAMTSUM ,conbUseAmtSum);}
    /** get 기부금납입금액합계 : conbUseAmtSum */
    public Long  getConbUseAmtSum() { return (Long )get( ATTR_CONBUSEAMTSUM );}
    /** set 기부금공제대상금액합계 : conbDdcTrgtAmtSum */
    public void setConbDdcTrgtAmtSum(Long  conbDdcTrgtAmtSum) { set( ATTR_CONBDDCTRGTAMTSUM ,conbDdcTrgtAmtSum);}
    /** get 기부금공제대상금액합계 : conbDdcTrgtAmtSum */
    public Long  getConbDdcTrgtAmtSum() { return (Long )get( ATTR_CONBDDCTRGTAMTSUM );}
    /** set 기부금공제세액합계 : conbDdcAmtSum */
    public void setConbDdcAmtSum(Long  conbDdcAmtSum) { set( ATTR_CONBDDCAMTSUM ,conbDdcAmtSum);}
    /** get 기부금공제세액합계 : conbDdcAmtSum */
    public Long  getConbDdcAmtSum() { return (Long )get( ATTR_CONBDDCAMTSUM );}
    /** set 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
    public void setOvrsSurcIncFmt(Long  ovrsSurcIncFmt) { set( ATTR_OVRSSURCINCFMT ,ovrsSurcIncFmt);}
    /** get 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
    public Long  getOvrsSurcIncFmt() { return (Long )get( ATTR_OVRSSURCINCFMT );}
    /** set 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
    public void setFrgnPmtFcTxamt(Long  frgnPmtFcTxamt) { set( ATTR_FRGNPMTFCTXAMT ,frgnPmtFcTxamt);}
    /** get 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
    public Long  getFrgnPmtFcTxamt() { return (Long )get( ATTR_FRGNPMTFCTXAMT );}
    /** set 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
    public void setFrgnPmtWcTxamt(Long  frgnPmtWcTxamt) { set( ATTR_FRGNPMTWCTXAMT ,frgnPmtWcTxamt);}
    /** get 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
    public Long  getFrgnPmtWcTxamt() { return (Long )get( ATTR_FRGNPMTWCTXAMT );}
    /** set 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
    public void setFrgnPmtTxamtTxpNtnNm(String  frgnPmtTxamtTxpNtnNm) { set( ATTR_FRGNPMTTXAMTTXPNTNNM ,frgnPmtTxamtTxpNtnNm);}
    /** get 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
    public String  getFrgnPmtTxamtTxpNtnNm() { return (String )get( ATTR_FRGNPMTTXAMTTXPNTNNM );}
    /** set 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
    public void setFrgnPmtTxamtPmtDt(String  frgnPmtTxamtPmtDt) { set( ATTR_FRGNPMTTXAMTPMTDT ,frgnPmtTxamtPmtDt);}
    /** get 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
    public String  getFrgnPmtTxamtPmtDt() { return (String )get( ATTR_FRGNPMTTXAMTPMTDT );}
    /** set 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
    public void setFrgnPmtTxamtAlfaSbmsDt(String  frgnPmtTxamtAlfaSbmsDt) { set( ATTR_FRGNPMTTXAMTALFASBMSDT ,frgnPmtTxamtAlfaSbmsDt);}
    /** get 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
    public String  getFrgnPmtTxamtAlfaSbmsDt() { return (String )get( ATTR_FRGNPMTTXAMTALFASBMSDT );}
    /** set 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
    public void setFrgnPmtTxamtAbrdWkarNm(String  frgnPmtTxamtAbrdWkarNm) { set( ATTR_FRGNPMTTXAMTABRDWKARNM ,frgnPmtTxamtAbrdWkarNm);}
    /** get 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
    public String  getFrgnPmtTxamtAbrdWkarNm() { return (String )get( ATTR_FRGNPMTTXAMTABRDWKARNM );}
    /** set 외국납부세액_근무기간일자 : frgnDtyTerm */
    public void setFrgnDtyTerm(String  frgnDtyTerm) { set( ATTR_FRGNDTYTERM ,frgnDtyTerm);}
    /** get 외국납부세액_근무기간일자 : frgnDtyTerm */
    public String  getFrgnDtyTerm() { return (String )get( ATTR_FRGNDTYTERM );}
    /** set 외국납부세액직책 : frgnPmtTxamtRfoNm */
    public void setFrgnPmtTxamtRfoNm(String  frgnPmtTxamtRfoNm) { set( ATTR_FRGNPMTTXAMTRFONM ,frgnPmtTxamtRfoNm);}
    /** get 외국납부세액직책 : frgnPmtTxamtRfoNm */
    public String  getFrgnPmtTxamtRfoNm() { return (String )get( ATTR_FRGNPMTTXAMTRFONM );}
    /** set 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
    public void setHsngTennLnpbUseAmt(Long  hsngTennLnpbUseAmt) { set( ATTR_HSNGTENNLNPBUSEAMT ,hsngTennLnpbUseAmt);}
    /** get 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
    public Long  getHsngTennLnpbUseAmt() { return (Long )get( ATTR_HSNGTENNLNPBUSEAMT );}
    /** set 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
    public void setHsngTennLnpbDdcAmt(Long  hsngTennLnpbDdcAmt) { set( ATTR_HSNGTENNLNPBDDCAMT ,hsngTennLnpbDdcAmt);}
    /** get 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
    public Long  getHsngTennLnpbDdcAmt() { return (Long )get( ATTR_HSNGTENNLNPBDDCAMT );}
    /** set 월세액세액공제지출금액 : mmrUseAmt */
    public void setMmrUseAmt(Long  mmrUseAmt) { set( ATTR_MMRUSEAMT ,mmrUseAmt);}
    /** get 월세액세액공제지출금액 : mmrUseAmt */
    public Long  getMmrUseAmt() { return (Long )get( ATTR_MMRUSEAMT );}
    /** set 월세액세액공제공제세액 : mmrDdcAmt */
    public void setMmrDdcAmt(Long  mmrDdcAmt) { set( ATTR_MMRDDCAMT ,mmrDdcAmt);}
    /** get 월세액세액공제공제세액 : mmrDdcAmt */
    public Long  getMmrDdcAmt() { return (Long )get( ATTR_MMRDDCAMT );}
    /** set 신고인성명 : cd218 */
    public void setCd218(String  cd218) { set( ATTR_CD218 ,cd218);}
    /** get 신고인성명 : cd218 */
    public String  getCd218() { return (String )get( ATTR_CD218 );}
    /** set 외국인근로자단일세율적용신청서제출여부 : d219 */
    public void setD219(String  d219) { set( ATTR_D219 ,d219);}
    /** get 외국인근로자단일세율적용신청서제출여부 : d219 */
    public String  getD219() { return (String )get( ATTR_D219 );}
    /** set 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
    public void setPrcspWorkIncmSumtYn(String  prcspWorkIncmSumtYn) { set( ATTR_PRCSPWORKINCMSUMTYN ,prcspWorkIncmSumtYn);}
    /** get 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
    public String  getPrcspWorkIncmSumtYn() { return (String )get( ATTR_PRCSPWORKINCMSUMTYN );}
    /** set 연금저축등소득세액공제명세서제출여부 : cd225 */
    public void setCd225(String  cd225) { set( ATTR_CD225 ,cd225);}
    /** get 연금저축등소득세액공제명세서제출여부 : cd225 */
    public String  getCd225() { return (String )get( ATTR_CD225 );}
    /** set 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
    public void setCd226(String  cd226) { set( ATTR_CD226 ,cd226);}
    /** get 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
    public String  getCd226() { return (String )get( ATTR_CD226 );}
    /** set 의료비지급명세서제출여부 : cd227 */
    public void setCd227(String  cd227) { set( ATTR_CD227 ,cd227);}
    /** get 의료비지급명세서제출여부 : cd227 */
    public String  getCd227() { return (String )get( ATTR_CD227 );}
    /** set 기부금명세서제출여부 : cd228 */
    public void setCd228(String  cd228) { set( ATTR_CD228 ,cd228);}
    /** get 기부금명세서제출여부 : cd228 */
    public String  getCd228() { return (String )get( ATTR_CD228 );}
    /** set 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
    public void setIncmDducWtnnteSumtDt(String  incmDducWtnnteSumtDt) { set( ATTR_INCMDDUCWTNNTESUMTDT ,incmDducWtnnteSumtDt);}
    /** get 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
    public String  getIncmDducWtnnteSumtDt() { return (String )get( ATTR_INCMDDUCWTNNTESUMTDT );}
    /** set 입력자 : kybdr */
    public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String  getKybdr() { return (String )get( ATTR_KYBDR );}
    /** set 입력일자 : inptDt */
    public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String  getInptDt() { return (String )get( ATTR_INPTDT );}
    /** set 입력주소 : inptAddr */
    public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}
    /** set 수정자 : ismt */
    public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String  getIsmt() { return (String )get( ATTR_ISMT );}
    /** set 수정일자 : revnDt */
    public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String  getRevnDt() { return (String )get( ATTR_REVNDT );}
    /** set 수정주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정주소 : revnAddr */
    public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}

}
