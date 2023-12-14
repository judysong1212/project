/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0303BM;
import com.app.exterms.payroll.client.dto.Payr0440BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0303Def  extends TableDef implements PayrDaoConstants {

    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0303Def(){
        setTitle(PayrLabel.titlePayr0303());
        setDaoClass("");
        setCustomListMethod(CLASS_PAYR0303_DATA_LIST);
        setAutoFillGrid(false);
	    setShowFilterToolbar(false);
	    // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
	   //  setCheckBoxOnGridRows(true); 
        

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
      

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0303BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급년도 : reattyYr */
        listColumnDefs.add(new ColumnDef("소급년도", Payr0303BM.ATTR_REATTYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0303BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소급설정회차번호 : reattyStpDsptyNum */
        listColumnDefs.add(new ColumnDef("소급설정회차번호", Payr0303BM.ATTR_REATTYSTPDSPTYNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0303BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0303BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0303BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("급여항목", Payr0303BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
     
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0303BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING ,80, true, false, true){
        	{

        	}
        });
        
        /** column 근태일_시간수 : dilnlazDutyTmDys */
        listColumnDefs.add(new ColumnDef("근태", Payr0303BM.ATTR_DILNLAZDUTYTMDYS, ColumnDef.TYPE_STRING , 40, true, true, true){
        	{

        	}
        });
        
        /** column 이전지급공제금액 : bfrPymtDducSum */
        listColumnDefs.add(new ColumnDef("기지급액", Payr0303BM.ATTR_BFRPYMTDDUCSUM, ColumnDef.TYPE_LONG , 80, true, true, true){
        	{

        	}
        });
        
        /** column 단가금액 : ucstSum */
        listColumnDefs.add(new ColumnDef("단가금액", Payr0440BM.ATTR_UCSTSUM, ColumnDef.TYPE_LONG, 80, true, true, true){
        	{

        	}
        });
        
        /** column 지급공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("금액(인상분)", Payr0303BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG , 80, true, true, true){
        	{

        	}
        });
        /** column 소급지급공제차액 : reattyPymtDducSrd */
        listColumnDefs.add(new ColumnDef("정산차액", Payr0303BM.ATTR_REATTYPYMTDDUCSRD, ColumnDef.TYPE_LONG , 80, true, true, true){
        	{

        	}
        });
        /** column 지급공제과세금액 : pymtDducTxtnAmnt */
        listColumnDefs.add(new ColumnDef("과세금액", Payr0303BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 80, true, true, true){
        	{

        	}
        });
        /** column 지급공제비과세금액 : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("비과세금액", Payr0303BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG , 80, true, true, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0303BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0303BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0303BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0303BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0303BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0303BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> reattyYr;   /** column 소급년도 : reattyYr */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> reattyStpDsptyNum;   /** column 소급설정회차번호 : reattyStpDsptyNum */
//
//        private TextField<String> payItemCd;   /** column 급여항목코드 : payItemCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> pymtDducDivCd;   /** column 지급공제구분코드 : pymtDducDivCd */
//
//        private TextField<String> bfrPymtDducSum;   /** column 이전지급공제금액 : bfrPymtDducSum */
//
//        private TextField<String> pymtDducSum;   /** column 지급공제금액 : pymtDducSum */
//
//        private TextField<String> reattyPymtDducSrd;   /** column 소급지급공제차액 : reattyPymtDducSrd */
//
//        private TextField<String> pymtDducTxtnAmnt;   /** column 지급공제과세금액 : pymtDducTxtnAmnt */
//
//        private TextField<String> pymtDducFreeDtySum;   /** column 지급공제비과세금액 : pymtDducFreeDtySum */
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
