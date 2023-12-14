/**
 * 공통화면 팝업 
 */
package com.app.exterms.diligence.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0210BM;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Dlgn0210Def  extends TableDef implements DiligenceDaoConstants {

    private int row = 0;
    private DiligenceConstants dlgnLabel = DiligenceConstants.INSTANCE;

    public Dlgn0210Def(){
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
        listColumnDefs.add(new ColumnDef("사업장코드", Dlgn0210BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Dlgn0210BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
        listColumnDefs.add(new ColumnDef("근태초과근무년월", Dlgn0210BM.ATTR_DILNLAZEXCEDUTYYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Dlgn0210BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_적용일자 : dilnlazApptnDt */
        listColumnDefs.add(new ColumnDef("근태_적용일자", Dlgn0210BM.ATTR_DILNLAZAPPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_초과근무여부 : dilnlazDutyYn */
        listColumnDefs.add(new ColumnDef("근태_초과근무여부", Dlgn0210BM.ATTR_DILNLAZDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_초과근무시간 : dilnlazDutyTm */
        listColumnDefs.add(new ColumnDef("근태_초과근무시간", Dlgn0210BM.ATTR_DILNLAZDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_야근여부 : dilnlazNtotYn */
        listColumnDefs.add(new ColumnDef("근태_야근여부", Dlgn0210BM.ATTR_DILNLAZNTOTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_야근시간 : dilnlazNtotTm */
        listColumnDefs.add(new ColumnDef("근태_야근시간", Dlgn0210BM.ATTR_DILNLAZNTOTTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_시간외근무여부 : dilnlazTmRstDutyYn */
        listColumnDefs.add(new ColumnDef("근태_시간외근무여부", Dlgn0210BM.ATTR_DILNLAZTMRSTDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
        listColumnDefs.add(new ColumnDef("근태_시간외근무시간", Dlgn0210BM.ATTR_DILNLAZTMRSTDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Dlgn0210BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Dlgn0210BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Dlgn0210BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Dlgn0210BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Dlgn0210BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Dlgn0210BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_휴일근무여부 : dilnlazHodyDutyYn */
        listColumnDefs.add(new ColumnDef("근태_휴일근무여부", Dlgn0210BM.ATTR_DILNLAZHODYDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태_휴일근무시간 : dilnlazHodyDutyTm */
        listColumnDefs.add(new ColumnDef("근태_휴일근무시간", Dlgn0210BM.ATTR_DILNLAZHODYDUTYTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 복무통합구분값 : typOccuBusinVal */
    	listColumnDefs.add(new ColumnDef("복무통합구분값", Dlgn0210BM.ATTR_TYPOCCUBUSINVAL, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{

    		}
    	});

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> dilnlazExceDutyYrMnth;   /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> dilnlazApptnDt;   /** column 근태_적용일자 : dilnlazApptnDt */
//
//        private TextField<String> dilnlazDutyYn;   /** column 근태_초과근무여부 : dilnlazDutyYn */
//
//        private TextField<String> dilnlazDutyTm;   /** column 근태_초과근무시간 : dilnlazDutyTm */
//
//        private TextField<String> dilnlazNtotYn;   /** column 근태_야근여부 : dilnlazNtotYn */
//
//        private TextField<String> dilnlazNtotTm;   /** column 근태_야근시간 : dilnlazNtotTm */
//
//        private TextField<String> dilnlazTmRstDutyYn;   /** column 근태_시간외근무여부 : dilnlazTmRstDutyYn */
//
//        private TextField<String> dilnlazTmRstDutyTm;   /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
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
//
//        private TextField<String> dilnlazHodyDutyYn;   /** column 근태_휴일근무여부 : dilnlazHodyDutyYn */
//
//        private TextField<String> dilnlazHodyDutyTm;   /** column 근태_휴일근무시간 : dilnlazHodyDutyTm */

        
        setColumnsDefinition(listColumnDefs);
    }
}
