/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2018;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye160401BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye160401Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Ye160401Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("Ye161020Def".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe161020ColumnsList());

		}else if ("Yeta2300Def".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160401ColumnsList());

		}else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe161020ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYe161020ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye160401BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속연도", Ye160401BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye160401BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye160401BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 지급년월 : elctYymm */
		listColumnDefs.add(new ColumnDef("지급년월", Ye160401BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 급여지급일자 : elctDate */
		listColumnDefs.add(new ColumnDef("급여지급일자", Ye160401BM.ATTR_ELCTDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 급여지급금액_과세 : suprTxam */
		listColumnDefs.add(new ColumnDef("급여지급금액_과세", Ye160401BM.ATTR_SUPRTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지상여금_과세 : buamTxam */
		listColumnDefs.add(new ColumnDef("현근무지상여금_과세", Ye160401BM.ATTR_BUAMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지인정상여금액 : inbsAmnt */
		listColumnDefs.add(new ColumnDef("현근무지인정상여금액", Ye160401BM.ATTR_INBSAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지주식매수선택권행사이익금액 : stckInam */
		listColumnDefs.add(new ColumnDef("현근무지주식매수선택권행사이익금액", Ye160401BM.ATTR_STCKINAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지과세합계금액 : spbmTxam */
		listColumnDefs.add(new ColumnDef("현근무지과세합계금액", Ye160401BM.ATTR_SPBMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 외국인소득금액_과세 : ecinTxam */
		listColumnDefs.add(new ColumnDef("외국인소득금액_과세", Ye160401BM.ATTR_ECINTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 외국인소득금액_비과세 : taxmEcin */
		listColumnDefs.add(new ColumnDef("외국인소득금액_비과세", Ye160401BM.ATTR_TAXMECIN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지건강보험료금액 : spciHlth */
		listColumnDefs.add(new ColumnDef("현근무지건강보험료금액", Ye160401BM.ATTR_SPCIHLTH, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지고용보험료금액 : spciEmpf */
		listColumnDefs.add(new ColumnDef("현근무지고용보험료금액", Ye160401BM.ATTR_SPCIEMPF, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지국민연금금액 : natnPsnf */
		listColumnDefs.add(new ColumnDef("현근무지국민연금금액", Ye160401BM.ATTR_NATNPSNF, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지소득세 : earnTaxn */
		listColumnDefs.add(new ColumnDef("현근무지소득세", Ye160401BM.ATTR_EARNTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지지방소득세 : ihtxTaxn */
		listColumnDefs.add(new ColumnDef("현근무지지방소득세", Ye160401BM.ATTR_IHTXTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지기타금액_과세 : etccTxam */
		listColumnDefs.add(new ColumnDef("현근무지기타금액_과세", Ye160401BM.ATTR_ETCCTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지기타금액_비과세 : etccEtam */
		listColumnDefs.add(new ColumnDef("현근무지기타금액_비과세", Ye160401BM.ATTR_ETCCETAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 급여지급금액총액 : payPymtSumTotAmnt */
		listColumnDefs.add(new ColumnDef("급여지급금액총액", Ye160401BM.ATTR_PAYPYMTSUMTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 급여지급금액_비과세 : payPymtFreeDtySum */
		listColumnDefs.add(new ColumnDef("급여지급금액_비과세", Ye160401BM.ATTR_PAYPYMTFREEDTYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
		listColumnDefs.add(new ColumnDef("현근무지상여금_비과세", Ye160401BM.ATTR_CURRWORKFREEDTUSAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
		listColumnDefs.add(new ColumnDef("현근무지우리사주조합인출금액", Ye160401BM.ATTR_CURRWORKEMPTKWDRWSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
		listColumnDefs.add(new ColumnDef("현근무지임원퇴직소득금액한도초과금액", Ye160401BM.ATTR_CURRWORKECTERETCESUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지요양보험료금액 : currWorkRcpInsurSum */
		listColumnDefs.add(new ColumnDef("현근무지요양보험료금액", Ye160401BM.ATTR_CURRWORKRCPINSURSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
		listColumnDefs.add(new ColumnDef("현근무지건강요양보험료합계금액", Ye160401BM.ATTR_CURRWORKRCPAGGRSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye160401BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye160401BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye160401BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye160401BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye160401BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye160401BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
//
//		private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//		private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//		private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//		private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//		private TextField<String> elctYymm;   /** column 지급년월 : elctYymm */
//
//		private TextField<String> elctDate;   /** column 급여지급일자 : elctDate */
//
//		private TextField<String> suprTxam;   /** column 급여지급금액_과세 : suprTxam */
//
//		private TextField<String> buamTxam;   /** column 현근무지상여금_과세 : buamTxam */
//
//		private TextField<String> inbsAmnt;   /** column 현근무지인정상여금액 : inbsAmnt */
//
//		private TextField<String> stckInam;   /** column 현근무지주식매수선택권행사이익금액 : stckInam */
//
//		private TextField<String> spbmTxam;   /** column 현근무지과세합계금액 : spbmTxam */
//
//		private TextField<String> ecinTxam;   /** column 외국인소득금액_과세 : ecinTxam */
//
//		private TextField<String> taxmEcin;   /** column 외국인소득금액_비과세 : taxmEcin */
//
//		private TextField<String> spciHlth;   /** column 현근무지건강보험료금액 : spciHlth */
//
//		private TextField<String> spciEmpf;   /** column 현근무지고용보험료금액 : spciEmpf */
//
//		private TextField<String> natnPsnf;   /** column 현근무지국민연금금액 : natnPsnf */
//
//		private TextField<String> earnTaxn;   /** column 현근무지소득세 : earnTaxn */
//
//		private TextField<String> ihtxTaxn;   /** column 현근무지지방소득세 : ihtxTaxn */
//
//		private TextField<String> etccTxam;   /** column 현근무지기타금액_과세 : etccTxam */
//
//		private TextField<String> etccEtam;   /** column 현근무지기타금액_비과세 : etccEtam */
//
//		private TextField<String> payPymtSumTotAmnt;   /** column 급여지급금액총액 : payPymtSumTotAmnt */
//
//		private TextField<String> payPymtFreeDtySum;   /** column 급여지급금액_비과세 : payPymtFreeDtySum */
//
//		private TextField<String> currWorkFreeDtusAmnt;   /** column 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
//
//		private TextField<String> currWorkEmptkWdrwSum;   /** column 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
//
//		private TextField<String> currWorkEcteRetceSum;   /** column 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
//
//		private TextField<String> currWorkRcpInsurSum;   /** column 현근무지요양보험료금액 : currWorkRcpInsurSum */
//
//		private TextField<String> currWorkRcpAggrSum;   /** column 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
//
//		private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//		private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//		private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//		private TextField<String> ismt;   /** column 수정자 : ismt */
//
//		private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//		private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */

		return listColumnDefs;
	}
    

	private List<ColumnDef> getYe160401ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
		/** column 지급년월 : elctYymm */
		listColumnDefs.add(new ColumnDef("지급년월", Ye160401BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye160401BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye160401BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속연도", Ye160401BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye160401BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 급여지급일자 : elctDate */
		listColumnDefs.add(new ColumnDef("급여지급일자", Ye160401BM.ATTR_ELCTDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 급여지급금액총액 : payPymtSumTotAmnt */
		listColumnDefs.add(new ColumnDef("급여지급금액총액", Ye160401BM.ATTR_PAYPYMTSUMTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 급여지급금액_비과세 : payPymtFreeDtySum */
		listColumnDefs.add(new ColumnDef("급여지급금액_비과세", Ye160401BM.ATTR_PAYPYMTFREEDTYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 급여지급금액_과세 : suprTxam */
		listColumnDefs.add(new ColumnDef("급여지급금액_과세", Ye160401BM.ATTR_SUPRTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
		listColumnDefs.add(new ColumnDef("현근무지상여금_비과세", Ye160401BM.ATTR_CURRWORKFREEDTUSAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지상여금_과세 : buamTxam */
		listColumnDefs.add(new ColumnDef("현근무지상여금_과세", Ye160401BM.ATTR_BUAMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지인정상여금액 : inbsAmnt */
		listColumnDefs.add(new ColumnDef("현근무지인정상여금액", Ye160401BM.ATTR_INBSAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지주식매수선택권행사이익금액 : stckInam */
		listColumnDefs.add(new ColumnDef("현근무지주식매수선택권행사이익금액", Ye160401BM.ATTR_STCKINAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
		listColumnDefs.add(new ColumnDef("현근무지우리사주조합인출금액", Ye160401BM.ATTR_CURRWORKEMPTKWDRWSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
		listColumnDefs.add(new ColumnDef("현근무지임원퇴직소득금액한도초과금액", Ye160401BM.ATTR_CURRWORKECTERETCESUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 외국인소득금액_과세 : ecinTxam */
		listColumnDefs.add(new ColumnDef("외국인소득금액_과세", Ye160401BM.ATTR_ECINTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 외국인소득금액_비과세 : taxmEcin */
		listColumnDefs.add(new ColumnDef("외국인소득금액_비과세", Ye160401BM.ATTR_TAXMECIN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지건강보험료금액 : spciHlth */
		listColumnDefs.add(new ColumnDef("현근무지건강보험료금액", Ye160401BM.ATTR_SPCIHLTH, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지요양보험료금액 : currWorkRcpInsurSum */
		listColumnDefs.add(new ColumnDef("현근무지요양보험료금액", Ye160401BM.ATTR_CURRWORKRCPINSURSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
		listColumnDefs.add(new ColumnDef("현근무지건강요양보험료합계금액", Ye160401BM.ATTR_CURRWORKRCPAGGRSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지고용보험료금액 : spciEmpf */
		listColumnDefs.add(new ColumnDef("현근무지고용보험료금액", Ye160401BM.ATTR_SPCIEMPF, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지국민연금금액 : natnPsnf */
		listColumnDefs.add(new ColumnDef("현근무지국민연금금액", Ye160401BM.ATTR_NATNPSNF, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지소득세 : earnTaxn */
		listColumnDefs.add(new ColumnDef("현근무지소득세", Ye160401BM.ATTR_EARNTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지지방소득세 : ihtxTaxn */
		listColumnDefs.add(new ColumnDef("현근무지지방소득세", Ye160401BM.ATTR_IHTXTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지농특세금액 : nnksSsum */
		listColumnDefs.add(new ColumnDef("현근무지농특세금액", Ye160401BM.ATTR_NNKSSSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지기타금액_과세 : etccTxam */
		listColumnDefs.add(new ColumnDef("현근무지기타금액_과세", Ye160401BM.ATTR_ETCCTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지기타금액_비과세 : etccEtam */
		listColumnDefs.add(new ColumnDef("현근무지기타금액_비과세", Ye160401BM.ATTR_ETCCETAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 현근무지과세합계금액 : spbmTxam */
		listColumnDefs.add(new ColumnDef("현근무지과세합계금액", Ye160401BM.ATTR_SPBMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye160401BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye160401BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye160401BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye160401BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye160401BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye160401BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
    

}
