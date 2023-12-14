/**
 * 공통화면 팝업 
 */
package com.app.exterms.diligence.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0100BM;
import com.app.exterms.diligence.client.dto.Dlgn0110BM;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Dlgn0110Def  extends TableDef implements DiligenceDaoConstants {

    private int row = 0;
    private DiligenceConstants dlgnLabel = DiligenceConstants.INSTANCE;

    public Dlgn0110Def(){
        setTitle("");
        setDaoClass("");
        setCustomListMethod("");
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setCheckBoxOnGridRows(true);
        setEditFieldGrid(true);
        setCellModel(true);
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column SYSTEMKEY : systemkey */

/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0110BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column SYSTEMKEY : systemkey */
listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0110BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태년월 : dilnlazYrMnth */
listColumnDefs.add(new ColumnDef("근태년월", Dlgn0110BM.ATTR_DILNLAZYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 급여구분코드 : payCd */
listColumnDefs.add(new ColumnDef("급여구분코드", Dlgn0110BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_적용일자 : dilnlazApptnDt */
listColumnDefs.add(new ColumnDef("근태_적용일자", Dlgn0110BM.ATTR_DILNLAZAPPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_근무시간 : dilnlazDutyTm */
listColumnDefs.add(new ColumnDef("근태_근무시간", Dlgn0110BM.ATTR_DILNLAZDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_근무여부 : dilnlazDutyYn */
listColumnDefs.add(new ColumnDef("근태_근무여부", Dlgn0110BM.ATTR_DILNLAZDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_결근여부 : dilnlazAbnceYn */
listColumnDefs.add(new ColumnDef("근태_결근여부", Dlgn0110BM.ATTR_DILNLAZABNCEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_연가여부 : dilnlazLvsgYn */
listColumnDefs.add(new ColumnDef("근태_연가여부", Dlgn0110BM.ATTR_DILNLAZLVSGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_병가여부 : dilnlazSckleaYn */
listColumnDefs.add(new ColumnDef("근태_병가여부", Dlgn0110BM.ATTR_DILNLAZSCKLEAYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_공가여부 : dilnlazOffvaYn */
listColumnDefs.add(new ColumnDef("근태_공가여부", Dlgn0110BM.ATTR_DILNLAZOFFVAYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_경조사여부 : dilnlazFmlyEvntYn */
listColumnDefs.add(new ColumnDef("근태_경조사여부", Dlgn0110BM.ATTR_DILNLAZFMLYEVNTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_보건여부 : dilnlazHlthCreYn */
listColumnDefs.add(new ColumnDef("근태_보건여부", Dlgn0110BM.ATTR_DILNLAZHLTHCREYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_결근근무인정여부 : dilnlazAbnceDutyRcgtnYn */
listColumnDefs.add(new ColumnDef("근태_결근근무인정여부", Dlgn0110BM.ATTR_DILNLAZABNCEDUTYRCGTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력자 : kybdr */
listColumnDefs.add(new ColumnDef("입력자", Dlgn0110BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력일자 : inptDt */
listColumnDefs.add(new ColumnDef("입력일자", Dlgn0110BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력주소 : inptAddr */
listColumnDefs.add(new ColumnDef("입력주소", Dlgn0110BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정자 : ismt */
listColumnDefs.add(new ColumnDef("수정자", Dlgn0110BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정일자 : revnDt */
listColumnDefs.add(new ColumnDef("수정일자", Dlgn0110BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정주소 : revnAddr */
listColumnDefs.add(new ColumnDef("수정주소", Dlgn0110BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_특별휴가여부 : dilnlazSpclHodyYn */
listColumnDefs.add(new ColumnDef("근태_특별휴가여부", Dlgn0110BM.ATTR_DILNLAZSPCLHODYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_교통보조비여부 : dilnlazTfcAssCstYn */
listColumnDefs.add(new ColumnDef("근태_교통보조비여부", Dlgn0110BM.ATTR_DILNLAZTFCASSCSTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_급식비여부 : dilnlazLnchYn */
listColumnDefs.add(new ColumnDef("근태_급식비여부", Dlgn0110BM.ATTR_DILNLAZLNCHYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근태_휴일근무여부 : dilnlazHodyYn */
listColumnDefs.add(new ColumnDef("근태_휴일근무여부", Dlgn0110BM.ATTR_DILNLAZHODYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 복무기타구분코드 : dilnlazEtcDivCd */
listColumnDefs.add(new ColumnDef("복무기타구분코드", Dlgn0110BM.ATTR_DILNLAZETCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});

//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//private TextField<String> dilnlazYrMnth;   /** column 근태년월 : dilnlazYrMnth */
//
//private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//private TextField<String> dilnlazApptnDt;   /** column 근태_적용일자 : dilnlazApptnDt */
//
//private TextField<String> dilnlazDutyTm;   /** column 근태_근무시간 : dilnlazDutyTm */
//
//private TextField<String> dilnlazDutyYn;   /** column 근태_근무여부 : dilnlazDutyYn */
//
//private TextField<String> dilnlazAbnceYn;   /** column 근태_결근여부 : dilnlazAbnceYn */
//
//private TextField<String> dilnlazLvsgYn;   /** column 근태_연가여부 : dilnlazLvsgYn */
//
//private TextField<String> dilnlazSckleaYn;   /** column 근태_병가여부 : dilnlazSckleaYn */
//
//private TextField<String> dilnlazOffvaYn;   /** column 근태_공가여부 : dilnlazOffvaYn */
//
//private TextField<String> dilnlazFmlyEvntYn;   /** column 근태_경조사여부 : dilnlazFmlyEvntYn */
//
//private TextField<String> dilnlazHlthCreYn;   /** column 근태_보건여부 : dilnlazHlthCreYn */
//
//private TextField<String> dilnlazAbnceDutyRcgtnYn;   /** column 근태_결근근무인정여부 : dilnlazAbnceDutyRcgtnYn */
//
//private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//private TextField<String> ismt;   /** column 수정자 : ismt */
//
//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//
//private TextField<String> dilnlazSpclHodyYn;   /** column 근태_특별휴가여부 : dilnlazSpclHodyYn */
//
//private TextField<String> dilnlazTfcAssCstYn;   /** column 근태_교통보조비여부 : dilnlazTfcAssCstYn */
//
//private TextField<String> dilnlazLnchYn;   /** column 근태_급식비여부 : dilnlazLnchYn */
//
//private TextField<String> dilnlazHodyYn;   /** column 근태_휴일근무여부 : dilnlazHodyYn */
//
//private TextField<String> dilnlazEtcDivCd;   /** column 복무기타구분코드 : dilnlazEtcDivCd */

        
        setColumnsDefinition(listColumnDefs);
    }
}
