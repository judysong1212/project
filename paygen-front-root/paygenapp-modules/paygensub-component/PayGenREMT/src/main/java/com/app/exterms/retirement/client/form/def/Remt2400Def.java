/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.Remt2400BM;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Remt2400Def  extends TableDef implements RemtDaoConstants {

    private int row = 0;
    private RemtConstants RemtLabel = RemtConstants.INSTANCE;

    public Remt2400Def(){
        setTitle("");
        setDaoClass(CLASS_REMT3520_DATA_LIST);
        setCustomListMethod(CLASS_REMT3520_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Remt2400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산귀속년월 : calcSevePayPsnBlggYr */
        listColumnDefs.add(new ColumnDef("퇴직정산귀속년월", Remt2400BM.ATTR_CALCSEVEPAYPSNBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt2400BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Remt2400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Remt2400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Remt2400BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Remt2400BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득자임원여부 : aimenrEcteYn */
        listColumnDefs.add(new ColumnDef("소득자임원여부", Remt2400BM.ATTR_AIMENRECTEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인구분코드 : frgnrDivCd */
        listColumnDefs.add(new ColumnDef("외국인구분코드", Remt2400BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주구분여부 : ridnSeptYn */
        listColumnDefs.add(new ColumnDef("거주구분여부", Remt2400BM.ATTR_RIDNSEPTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지국코드 : ridnCd */
        listColumnDefs.add(new ColumnDef("거주지국코드", Remt2400BM.ATTR_RIDNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지국명 : ridnNm */
        listColumnDefs.add(new ColumnDef("거주지국명", Remt2400BM.ATTR_RIDNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도시작일자 : blggYrBgnnDt */
        listColumnDefs.add(new ColumnDef("귀속년도시작일자", Remt2400BM.ATTR_BLGGYRBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도종료일자 : blggYrEndDt */
        listColumnDefs.add(new ColumnDef("귀속년도종료일자", Remt2400BM.ATTR_BLGGYRENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직사유코드 : retryReasCd */
        listColumnDefs.add(new ColumnDef("퇴직사유코드", Remt2400BM.ATTR_RETRYREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Remt2400BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무처명 : paeWorkNm */
        listColumnDefs.add(new ColumnDef("근무처명", Remt2400BM.ATTR_PAEWORKNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직급여액 : retryPayQnty */
        listColumnDefs.add(new ColumnDef("퇴직급여액", Remt2400BM.ATTR_RETRYPAYQNTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
        listColumnDefs.add(new ColumnDef("비과세퇴직급여액", Remt2400BM.ATTR_FREEDTYRETRYPAYQNTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 과세대상퇴직급여액 : txtnTgtRetryPayQnty */
        listColumnDefs.add(new ColumnDef("과세대상퇴직급여액", Remt2400BM.ATTR_TXTNTGTRETRYPAYQNTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입사일자 : icncDt */
        listColumnDefs.add(new ColumnDef("입사일자", Remt2400BM.ATTR_ICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기산일자 : rkfcdDt */
        listColumnDefs.add(new ColumnDef("기산일자", Remt2400BM.ATTR_RKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴사일자 : rsgtnDt */
        listColumnDefs.add(new ColumnDef("퇴사일자", Remt2400BM.ATTR_RSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급일자 : pymtDt */
        listColumnDefs.add(new ColumnDef("지급일자", Remt2400BM.ATTR_PYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수 : logSvcMnthIcm */
        listColumnDefs.add(new ColumnDef("근속월수", Remt2400BM.ATTR_LOGSVCMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 제외월수 : eepnMnthIcm */
        listColumnDefs.add(new ColumnDef("제외월수", Remt2400BM.ATTR_EEPNMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 가산월수 : addMnthIcm */
        listColumnDefs.add(new ColumnDef("가산월수", Remt2400BM.ATTR_ADDMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 중복월수 : dupMnthIcm */
        listColumnDefs.add(new ColumnDef("중복월수", Remt2400BM.ATTR_DUPMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속연수 : logSvcYrNum */
        listColumnDefs.add(new ColumnDef("근속연수", Remt2400BM.ATTR_LOGSVCYRNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_입사일자", Remt2400BM.ATTR_LOGPPNL12BEFICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_기산일자", Remt2400BM.ATTR_LOGPPNL12BEFRKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_퇴사일자", Remt2400BM.ATTR_LOGPPNL12BEFRSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_지급일자", Remt2400BM.ATTR_LOGPPNL12BEFPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_근속월수", Remt2400BM.ATTR_LOGPPNL12BEFLOGMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_제외월수", Remt2400BM.ATTR_LOGPPNL12BEFEEPNMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_가산월수", Remt2400BM.ATTR_LOGPPNL12BEFADDMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_중복월수", Remt2400BM.ATTR_LOGPPNL12BEFDUPMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
        listColumnDefs.add(new ColumnDef("근속안분_2012전_근속년수", Remt2400BM.ATTR_LOGPPNL12BEFLOGYRNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_입사일자", Remt2400BM.ATTR_LOGPPNL13AFRICNCDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_기산일자", Remt2400BM.ATTR_LOGPPNL13AFRRKFCDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_퇴사일자", Remt2400BM.ATTR_LOGPPNL13AFRRSGTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_지급일자", Remt2400BM.ATTR_LOGPPNL13AFRPYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_근속월수", Remt2400BM.ATTR_LOGPPNL13AFRLOGMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_제외월수", Remt2400BM.ATTR_LOGPPNL13AFREEPNMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_가산월수", Remt2400BM.ATTR_LOGPPNL13AFRADDMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_중복월수", Remt2400BM.ATTR_LOGPPNL13AFRDUPMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
        listColumnDefs.add(new ColumnDef("근속안분_2013후_근속연수", Remt2400BM.ATTR_LOGPPNL13AFRLOGSVC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직소득_지급금액 : retryIncmPymtSum */
        listColumnDefs.add(new ColumnDef("퇴직소득_지급금액", Remt2400BM.ATTR_RETRYINCMPYMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직소득정률공제금액 : retryIncmFxrtDducSum */
        listColumnDefs.add(new ColumnDef("퇴직소득정률공제금액", Remt2400BM.ATTR_RETRYINCMFXRTDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수공제금액 : logYrDducSum */
        listColumnDefs.add(new ColumnDef("근속년수공제금액", Remt2400BM.ATTR_LOGYRDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
        listColumnDefs.add(new ColumnDef("퇴직소득과세표준_정산금액", Remt2400BM.ATTR_RETRYTXTNSTDCLUTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
        listColumnDefs.add(new ColumnDef("세액_2012전_과세표준안분금액", Remt2400BM.ATTR_TAT12BEFTXTNSTDPPNLSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
        listColumnDefs.add(new ColumnDef("세액_2012전_연평균과세표준금액", Remt2400BM.ATTR_TAT12BEFYRAVGTXSTDSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
        listColumnDefs.add(new ColumnDef("세액_2012전_환산과세표준금액", Remt2400BM.ATTR_TAT12BEFCVSNTXTNSTDSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
        listColumnDefs.add(new ColumnDef("세액_2012전_환산산출세액금액", Remt2400BM.ATTR_TAT12BEFCVSNCALCAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
        listColumnDefs.add(new ColumnDef("세액_2012전_연평균산출세액", Remt2400BM.ATTR_TAT12BEFYRAVGCALCAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_2012전_산출세액", Remt2400BM.ATTR_TAT12BEFCALCTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_2012전_기납부세액", Remt2400BM.ATTR_TAT12BEFALPAYTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_2012전_신고대상세액", Remt2400BM.ATTR_TAT12BEFREGTGTTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
        listColumnDefs.add(new ColumnDef("세액_2013후_과세표준안분금액", Remt2400BM.ATTR_TAT13AFRTXSTDPPNLSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
        listColumnDefs.add(new ColumnDef("세액_2013후_연평균과세표준금액", Remt2400BM.ATTR_TAT13AFRYRAVGSTDSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
        listColumnDefs.add(new ColumnDef("세액_2013후_환산과세표준금액", Remt2400BM.ATTR_TAT13AFRCVSNTXTNSTDSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_2013후_환산산출세액", Remt2400BM.ATTR_TAT13AFRCVSNCALCTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
        listColumnDefs.add(new ColumnDef("세액_2013후_연평균산출세액", Remt2400BM.ATTR_TAT13AFRYRAVGCALCAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_2013후_기납부세액", Remt2400BM.ATTR_TAT13AFRALPAYTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
        listColumnDefs.add(new ColumnDef("세액_2013후_신고대상세액", Remt2400BM.ATTR_TAT13AFRREGRSTTGTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
        listColumnDefs.add(new ColumnDef("세액_합계_과세표준안분금액", Remt2400BM.ATTR_TATAGGRTXTNSTDPPNLSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
        listColumnDefs.add(new ColumnDef("세액_합계_연평균과세표준금액", Remt2400BM.ATTR_TATAGGRYRAVGTXTNSTDSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
        listColumnDefs.add(new ColumnDef("세액_합계_환산과세표준금액", Remt2400BM.ATTR_TATAGGRCVSNTXTNSTDSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_합계_환산산출세액", Remt2400BM.ATTR_TATAGGRCVSNCALCTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_합계_연평균산출세액", Remt2400BM.ATTR_TATAGGRYRAVGCALCTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_합계_산출세액", Remt2400BM.ATTR_TATAGGRCALCTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_합계_기납부세액", Remt2400BM.ATTR_TATAGGRALPAYTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
        listColumnDefs.add(new ColumnDef("세액_합계_신고대상세액", Remt2400BM.ATTR_TATAGGRREGRSTTGTTXAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
        listColumnDefs.add(new ColumnDef("납부신고대상_소득세액", Remt2400BM.ATTR_PYMTREGTGTINCMTXQNTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
        listColumnDefs.add(new ColumnDef("납부신고대상_지방소득세액", Remt2400BM.ATTR_PYMTREGTGTRGONINCMQNTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
        listColumnDefs.add(new ColumnDef("납부신고대상_농어촌특별세액", Remt2400BM.ATTR_PYMTREGTGTFARVILSPCLQNTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
        listColumnDefs.add(new ColumnDef("납부신고대상_합계금액", Remt2400BM.ATTR_PYMTREGRSTTGTAGGRSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Remt2400BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Remt2400BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Remt2400BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Remt2400BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Remt2400BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Remt2400BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> calcSevePayPsnBlggYr;   /** column 퇴직정산귀속년월 : calcSevePayPsnBlggYr */
//
//        private TextField<String> calcSevePayPsnDivCd;   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> hanNm;   /** column 한글성명 : hanNm */
//
//        private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//
//        private TextField<String> aimenrEcteYn;   /** column 소득자임원여부 : aimenrEcteYn */
//
//        private TextField<String> frgnrDivCd;   /** column 외국인구분코드 : frgnrDivCd */
//
//        private TextField<String> ridnSeptYn;   /** column 거주구분여부 : ridnSeptYn */
//
//        private TextField<String> ridnCd;   /** column 거주지국코드 : ridnCd */
//
//        private TextField<String> ridnNm;   /** column 거주지국명 : ridnNm */
//
//        private TextField<String> blggYrBgnnDt;   /** column 귀속년도시작일자 : blggYrBgnnDt */
//
//        private TextField<String> blggYrEndDt;   /** column 귀속년도종료일자 : blggYrEndDt */
//
//        private TextField<String> retryReasCd;   /** column 퇴직사유코드 : retryReasCd */
//
//        private TextField<String> busoprRgstnNum;   /** column 사업자등록번호 : busoprRgstnNum */
//
//        private TextField<String> paeWorkNm;   /** column 근무처명 : paeWorkNm */
//
//        private TextField<String> retryPayQnty;   /** column 퇴직급여액 : retryPayQnty */
//
//        private TextField<String> freeDtyRetryPayQnty;   /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
//
//        private TextField<String> txtnTgtRetryPayQnty;   /** column 과세대상퇴직급여액 : txtnTgtRetryPayQnty */
//
//        private TextField<String> icncDt;   /** column 입사일자 : icncDt */
//
//        private TextField<String> rkfcdDt;   /** column 기산일자 : rkfcdDt */
//
//        private TextField<String> rsgtnDt;   /** column 퇴사일자 : rsgtnDt */
//
//        private TextField<String> pymtDt;   /** column 지급일자 : pymtDt */
//
//        private TextField<String> logSvcMnthIcm;   /** column 근속월수 : logSvcMnthIcm */
//
//        private TextField<String> eepnMnthIcm;   /** column 제외월수 : eepnMnthIcm */
//
//        private TextField<String> addMnthIcm;   /** column 가산월수 : addMnthIcm */
//
//        private TextField<String> dupMnthIcm;   /** column 중복월수 : dupMnthIcm */
//
//        private TextField<String> logSvcYrNum;   /** column 근속연수 : logSvcYrNum */
//
//        private TextField<String> logPpnl12befIcncDt;   /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
//
//        private TextField<String> logPpnl12befRkfcdDt;   /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
//
//        private TextField<String> logPpnl12befRsgtnDt;   /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
//
//        private TextField<String> logPpnl12befPymtDt;   /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
//
//        private TextField<String> logPpnl12befLogMnthIcm;   /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
//
//        private TextField<String> logPpnl12befEepnMnthIcm;   /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
//
//        private TextField<String> logPpnl12befAddMnthIcm;   /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
//
//        private TextField<String> logPpnl12befDupMnthIcm;   /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
//
//        private TextField<String> logPpnl12befLogYrNum;   /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
//
//        private TextField<String> logPpnl13afrIcncDt;   /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
//
//        private TextField<String> logPpnl13afrRkfcdDt;   /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
//
//        private TextField<String> logPpnl13afrRsgtnDt;   /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
//
//        private TextField<String> logPpnl13afrPymtDt;   /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
//
//        private TextField<String> logPpnl13afrLogMnthIcm;   /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
//
//        private TextField<String> logPpnl13afrEepnMnthIcm;   /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
//
//        private TextField<String> logPpnl13afrAddMnthIcm;   /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
//
//        private TextField<String> logPpnl13afrDupMnthIcm;   /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
//
//        private TextField<String> logPpnl13afrLogSvc;   /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
//
//        private TextField<String> retryIncmPymtSum;   /** column 퇴직소득_지급금액 : retryIncmPymtSum */
//
//        private TextField<String> retryIncmFxrtDducSum;   /** column 퇴직소득정률공제금액 : retryIncmFxrtDducSum */
//
//        private TextField<String> logYrDducSum;   /** column 근속년수공제금액 : logYrDducSum */
//
//        private TextField<String> retryTxtnStdClutSum;   /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
//
//        private TextField<String> tat12befTxtnStdPpnlSum;   /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
//
//        private TextField<String> tat12befYravgTxstdSum;   /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
//
//        private TextField<String> tat12befCvsnTxtnStdSum;   /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
//
//        private TextField<String> tat12befCvsnCalcAmnt;   /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
//
//        private TextField<String> tat12befYrAvgCalcAmnt;   /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
//
//        private TextField<String> tat12befCalcTxAmnt;   /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
//
//        private TextField<String> tat12befAlpayTxAmnt;   /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
//
//        private TextField<String> tat12befRegTgtTxAmnt;   /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
//
//        private TextField<String> tat13afrTxstdPpnlSum;   /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
//
//        private TextField<String> tat13afrYrAvgStdSum;   /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
//
//        private TextField<String> tat13afrCvsnTxtnStdSum;   /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
//
//        private TextField<String> tat13afrCvsnCalcTxAmnt;   /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
//
//        private TextField<String> tat13afrYrAvgCalcAmnt;   /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
//
//        private TextField<String> tat13afrAlpayTxAmnt;   /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
//
//        private TextField<String> tat13afrRegrstTgtSum;   /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
//
//        private TextField<String> tatAggrTxtnStdPpnlSum;   /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
//
//        private TextField<String> tatAggrYrAvgTxtnStdSum;   /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
//
//        private TextField<String> tatAggrCvsnTxtnStdSum;   /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
//
//        private TextField<String> tatAggrCvsnCalcTxAmnt;   /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
//
//        private TextField<String> tatAggrYrAvgCalcTxAmnt;   /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
//
//        private TextField<String> tatAggrCalcTxAmnt;   /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
//
//        private TextField<String> tatAggrAlpayTxAmnt;   /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
//
//        private TextField<String> tatAggrRegrstTgtTxAmnt;   /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
//
//        private TextField<String> pymtRegTgtIncmTxQnty;   /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
//
//        private TextField<String> pymtRegTgtRgonIncmQnty;   /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
//
//        private TextField<String> pymtRegTgtFarvilSpclQnty;   /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
//
//        private TextField<String> pymtRegrstTgtAggrSum;   /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */

        
        setColumnsDefinition(listColumnDefs);
    }
}
