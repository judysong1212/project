/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0300BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0300Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0300Def(){
        setTitle(PayrLabel.titlePayr0300());
        setDaoClass(CLASS_PAYR0300_DATA_LIST);
      //  setCustomListMethod(CLASS_BASS0100_LIST);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0300BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0300BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0300BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0300BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급일자 : payPymtDt */
        listColumnDefs.add(new ColumnDef("급여지급일자", Payr0300BM.ATTR_PAYPYMTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Payr0300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Payr0300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Payr0300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Payr0300BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Payr0300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Payr0300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여마스터비고내용 : payMstrNoteCtnt */
        listColumnDefs.add(new ColumnDef("급여마스터비고내용", Payr0300BM.ATTR_PAYMSTRNOTECTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> payrMangDeptCd   /** column 단위기관코드 : payrMangDeptCd */
//
//        private TextField<String> pymtYrMnth   /** column 지급년월 : pymtYrMnth */
//
//        private TextField<String> payCd   /** column 급여구분코드 : payCd */
//
//        private TextField<String> payrSeilNum   /** column 급여일련번호 : payrSeilNum */
//
//        private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> payPymtDt   /** column 급여지급일자 : payPymtDt */
//
//        private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
//
//        private TextField<String> payMstrNoteCtnt   /** column 급여마스터비고내용 : payMstrNoteCtnt */

        
        setColumnsDefinition(listColumnDefs);
    }
}
