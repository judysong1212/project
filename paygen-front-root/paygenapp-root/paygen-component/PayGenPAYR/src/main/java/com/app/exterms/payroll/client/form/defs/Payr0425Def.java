/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0425BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0425Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0425Def(){
        setTitle("");
        setDaoClass(CLASS_PAYR5100_PAYR0425_DATA_LIST);
        setCustomListMethod(CLASS_PAYR5100_PAYR0425_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setEditFieldGrid(true);
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0425BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, false){
            {

            }
        });
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0425BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, false){
            {

            }
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0425BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, false){
            {

            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0425BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, false){
            {

            }
        });
        /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Payr0425BM.ATTR_PYSPLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, false){
            {

            }
        });
        
        /** column 호봉근속년수 : pyspLogSvcYrNumNm */
        listColumnDefs.add(new ColumnDef("근속년수", Payr0425BM.ATTR_PYSPLOGSVCYRNUMNM, ColumnDef.TYPE_STRING , 70, true, true, false){
            {

            }
        });
        
        /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
        listColumnDefs.add(new ColumnDef("직종별급여산정기준일자", Payr0425BM.ATTR_OCCUCLSSPAYCMPTTNSTD, ColumnDef.TYPE_DATE , 90, true, false, false){
            {

            }
        });
        /** column 이전근속년수단가금액 : befSvcYrUcstSum */
        listColumnDefs.add(new ColumnDef("이전단가금액", Payr0425BM.ATTR_BEFSVCYRUCSTSUM, ColumnDef.TYPE_LONG , 100, true, true, false){
            {

            }
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0425BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0425BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0425BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0425BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0425BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0425BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });

   
        
        setColumnsDefinition(listColumnDefs);
    }
}
