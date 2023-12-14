/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0445BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0445Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0445Def(){
        setTitle("");
        setDaoClass(CLASS_PAYR5200_PAYR0445_DATA_LIST);
        setCustomListMethod(CLASS_PAYR5200_PAYR0445_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setEditFieldGrid(true);
         
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0445BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0445BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 60, false, true, true){
            {

            }
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0445BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("호봉근속년수코드", Payr0445BM.ATTR_PYSPLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0445BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 직종세별급여생성일자 : occuClssPayCmpttnStd */
        listColumnDefs.add(new ColumnDef("생성일자", Payr0445BM.ATTR_OCCUCLSSPAYCMPTTNSTD, ColumnDef.TYPE_DATE , 90, false, false, true){
            {
                setFormatDate(MSFMainApp.MSFCONSTANTS.DateFormat());
            }
        });
        /** column 월통상임금액 : mnthUsalyAmntWag */
        listColumnDefs.add(new ColumnDef("월통상임금액", Payr0445BM.ATTR_MNTHUSALYAMNTWAG, ColumnDef.TYPE_LONG , 120, false, true, true){
            {

            }
        });
        /** column 월통상임금상여금액 : mnthUsalyAmntAllwBnusSum */
        listColumnDefs.add(new ColumnDef("월통상임금상여(포함)", Payr0445BM.ATTR_MNTHUSALYAMNTALLWBNUSSUM, ColumnDef.TYPE_LONG , 150, false, true, true){
            {

            }
        });
        /** column 통상임금일급액 : usalyAmntPdyQnty */
        listColumnDefs.add(new ColumnDef("통상임금일급액", Payr0445BM.ATTR_USALYAMNTPDYQNTY, ColumnDef.TYPE_LONG , 120, false, true, true){
            {

            }
        });
        /** column 통상임금시급액 : usalyAmntHrwgQnty */
        listColumnDefs.add(new ColumnDef("통상임금시급액", Payr0445BM.ATTR_USALYAMNTHRWGQNTY, ColumnDef.TYPE_LONG , 120, false, true, true){
            {

            }
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0445BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0445BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0445BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0445BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0445BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0445BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> payYr;   /** column 급여년도 : payYr */
//
//        private TextField<String> typOccuGrdeMppgSeilNum;   /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
//
//        private TextField<String> pyspLogSvcYrNumCd;   /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
//
//        private TextField<String> payrItemSeilNum;   /** column 급여항목일련번호 : payrItemSeilNum */
//
//        private TextField<String> occuClssPayCmpttnStd;   /** column 직종세별급여생성일자 : occuClssPayCmpttnStd */
//
//        private TextField<String> mnthUsalyAmntWag;   /** column 월통상임금액 : mnthUsalyAmntWag */
//
//        private TextField<String> mnthUsalyAmntAllwBnusSum;   /** column 월통상임금상여금액 : mnthUsalyAmntAllwBnusSum */
//
//        private TextField<String> usalyAmntPdyQnty;   /** column 통상임금일급액 : usalyAmntPdyQnty */
//
//        private TextField<String> usalyAmntHrwgQnty;   /** column 통상임금시급액 : usalyAmntHrwgQnty */
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
