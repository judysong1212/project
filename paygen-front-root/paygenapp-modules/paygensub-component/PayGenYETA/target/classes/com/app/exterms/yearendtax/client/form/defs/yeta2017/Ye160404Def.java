/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2017;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160404BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160406BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161020BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye160404Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

	public Ye160404Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("YETAP23006".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP23006_TO_YE160404_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(false);
			setEditFieldGrid(false);
			setColumnsDefinition(getYe160404ColumnsList());

		} else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP23006_TO_YE160404_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160404ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYe160404ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
		
		
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("정산년도", Ye160404BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, false, true, false){
			{

			}
		});
		
		
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("정산구분", Ye160404BM.ATTR_CLUTSEPTNM, ColumnDef.TYPE_STRING , 90, false, true, false){
			{

			}
		});
		
	    /** column 소득자성명 : fnm */
		listColumnDefs.add(new ColumnDef("성명", Ye161020BM.ATTR_FNM, ColumnDef.TYPE_STRING , 60, false, true, false){
			{

			}
		});
		
		/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
		listColumnDefs.add(new ColumnDef("사업자등록번호", Ye160404BM.ATTR_WHDGDEBRBUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 90, false, true, false){
			{

			}
		});
		
		/** column D9_종전근무처법인_상호명 : prcspFmnmNm */
		listColumnDefs.add(new ColumnDef("근무지명", Ye160404BM.ATTR_PRCSPFMNMNM, ColumnDef.TYPE_STRING , 90, false, true, false){
			{

			}
		});
		
		/** column D15_종전근무처급여금액 : prcspPaySum */
		listColumnDefs.add(new ColumnDef("급여금액", Ye160404BM.ATTR_PRCSPPAYSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
			{

			}
		});
		/** column D16_종전근무처상여금액 : prcspAllwBnusSum */
		listColumnDefs.add(new ColumnDef("상여금액", Ye160404BM.ATTR_PRCSPALLWBNUSSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
			{

			}
		});
		
		/** column D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
		listColumnDefs.add(new ColumnDef("소득세", Ye160404BM.ATTR_PRCSPINCMTXSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
			{

			}
		});
		
		/** column D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
		listColumnDefs.add(new ColumnDef("지방소득세금액", Ye160404BM.ATTR_PRCSPRGONINCMTXSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
			{

			}
		});
		
		/** column 종전근무지처리여부 : prcspPrcsYn */
		listColumnDefs.add(new ColumnDef("처리구분", Ye160404BM.ATTR_PRCSPPRCSYN, ColumnDef.TYPE_BOOLEAN, 90, false, true, false){
			{

			}
		});
		
		
		// --
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye160404BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye160404BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye160404BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		/** column D4_종전근무처일련번호 : prcspSeilNum */
		listColumnDefs.add(new ColumnDef("D4_종전근무처일련번호", Ye160404BM.ATTR_PRCSPSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column D7_소득자주민등록번호 : resnRegnNum */
		listColumnDefs.add(new ColumnDef("D7_소득자주민등록번호", Ye160404BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
		listColumnDefs.add(new ColumnDef("D8_종전근무처납세조합여부", Ye160404BM.ATTR_PRCSPTXPYRASOCYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		/** column D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
		listColumnDefs.add(new ColumnDef("D10_종전근무처사업자등록번호", Ye160404BM.ATTR_PRCSPBUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
		listColumnDefs.add(new ColumnDef("D11_종전근무처근무시간시작일자", Ye160404BM.ATTR_PRCSPDUTYBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
		listColumnDefs.add(new ColumnDef("D12_종전근무처근무시간종료일자", Ye160404BM.ATTR_PRCSPDUTYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
		listColumnDefs.add(new ColumnDef("D13_종전근무처감면기간시작일자", Ye160404BM.ATTR_PRCSPREDUBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column D14_종전근무처감면기간종료일자 : prcspReduEndDt */
		listColumnDefs.add(new ColumnDef("D14_종전근무처감면기간종료일자", Ye160404BM.ATTR_PRCSPREDUENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
	
		/** column D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
		listColumnDefs.add(new ColumnDef("D17_종전근무처인정상여금액", Ye160404BM.ATTR_PRCSPRCGTNBNUSSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
		listColumnDefs.add(new ColumnDef("D18_종전근무처주식매수선택권행사이익금액", Ye160404BM.ATTR_PRCSPSTCKEVNTPRFTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
		listColumnDefs.add(new ColumnDef("D19_종전근무처우리사주조합인출금액", Ye160404BM.ATTR_PRCSPEMPSTKSCWDRWSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
		listColumnDefs.add(new ColumnDef("D20_종전근무처임원퇴직소득한도초과금액", Ye160404BM.ATTR_PRCSPECTERSGTNEXCESUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column D22_종전근무처합계금액 : prcspAggrSum */
		listColumnDefs.add(new ColumnDef("D22_종전근무처합계금액", Ye160404BM.ATTR_PRCSPAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column D53_비과세합계금액 : freeDtyAggrSum */
		listColumnDefs.add(new ColumnDef("D53_비과세합계금액", Ye160404BM.ATTR_FREEDTYAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column D54_감면소득합계금액 : reduIncmAggrSum */
		listColumnDefs.add(new ColumnDef("D54_감면소득합계금액", Ye160404BM.ATTR_REDUINCMAGGRSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		
		/** column D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
		listColumnDefs.add(new ColumnDef("D58_종전근무지기납부세액_농특세금액", Ye160404BM.ATTR_PRCSPNNKSSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 종전근무지건강보험료금액 : prcspHlthPrmmSum */
		listColumnDefs.add(new ColumnDef("종전근무지건강보험료금액", Ye160404BM.ATTR_PRCSPHLTHPRMMSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
		listColumnDefs.add(new ColumnDef("종전근무지장기요양보험료금액", Ye160404BM.ATTR_PRCSPLGTMRCPTNSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
		listColumnDefs.add(new ColumnDef("종전근무지건강장기요양보험료합계금액", Ye160404BM.ATTR_PRCSPHLTHLGCPTNAGGR, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
		listColumnDefs.add(new ColumnDef("종전근무지건강보험료공제금액", Ye160404BM.ATTR_PRCSPHLTHPRMMDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
		listColumnDefs.add(new ColumnDef("종전근무지고용보험료금액", Ye160404BM.ATTR_PRCSPEMYMTPRMMSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
		listColumnDefs.add(new ColumnDef("종전근무지고용보험료공제금액", Ye160404BM.ATTR_PRCSPEMYTPRMMDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});

		/** column 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */
		listColumnDefs.add(new ColumnDef("종전근무지원천징수영수증제출여부", Ye160404BM.ATTR_PRCSPWHDGREIPSUMTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 국민연금보험료금액 : natPennPrmmSum */
		listColumnDefs.add(new ColumnDef("국민연금보험료금액", Ye160406BM.ATTR_NATPENNPRMMSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
		listColumnDefs.add(new ColumnDef("국민연금지역보험료금액", Ye160406BM.ATTR_NATPENNARAPRMMSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 국민연금공제금액 : natPennDducSum */
		listColumnDefs.add(new ColumnDef("국민연금공제금액", Ye160406BM.ATTR_NATPENNDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_공무원연금금액 : puoferAnty */
		listColumnDefs.add(new ColumnDef("공적연금_공무원연금금액", Ye160406BM.ATTR_PUOFERANTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_공무원연금공제금액", Ye160406BM.ATTR_PUOFERANTYDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_군인연금금액 : mltymAnty */
		listColumnDefs.add(new ColumnDef("공적연금_군인연금금액", Ye160406BM.ATTR_MLTYMANTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_군인연금공제금액", Ye160406BM.ATTR_MLTYMANTYDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
		listColumnDefs.add(new ColumnDef("공적연금_사립학교교직원연금금액", Ye160406BM.ATTR_PRTAFIRSCHLFALYMMANTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_사립학교직원연금공제금액", Ye160406BM.ATTR_PRTAFIRSCHLDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
		listColumnDefs.add(new ColumnDef("공적연금_별정우체국연금금액", Ye160406BM.ATTR_SPILDTNPSTOFICANTY, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_별정우체국연금공제금액", Ye160406BM.ATTR_SPILDTNPSTOFICDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		
		/** column C165_납부특례세액_소득세금액 : prcspYetaC165 */
		listColumnDefs.add(new ColumnDef("C165_납부특례세액_소득세금액", Ye160404BM.ATTR_PRCSPYETAC165, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
		listColumnDefs.add(new ColumnDef("C166_납부특례세액_지방소득세금액", Ye160404BM.ATTR_PRCSPYETAC166, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column C167_납부특례세액_농특세금액 : prcspYetaC167 */
		listColumnDefs.add(new ColumnDef("C167_납부특례세액_농특세금액", Ye160404BM.ATTR_PRCSPYETAC167, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		
		
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye160404BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye160404BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye160404BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye160404BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye160404BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye160404BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
    


}
