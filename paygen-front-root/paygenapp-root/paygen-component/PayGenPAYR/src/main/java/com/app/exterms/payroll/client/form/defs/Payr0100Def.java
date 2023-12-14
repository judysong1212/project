/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0100BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0100Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0100Def(){
        setTitle(PayrLabel.titlePayr0100());
        setDaoClass(CLASS_PAYR0100_DATA_LIST);
        setCustomListMethod(CLASS_PAYR0100_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        setCheckBoxOnGridRows(true);
        setFilterFormType(FILTER_FORM_SINGLE);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, false){
        	{

        	}
        });
        
        /** column 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
        listColumnDefs.add(new ColumnDef("순번", Payr0100BM.ATTR_EANDINCMTXTBSIMFTXSNUM, ColumnDef.TYPE_LONG, 50, false, true, true){
        	{
               
        	}
        });
        
        /** column 적용년도 : apptnYr */
        listColumnDefs.add(new ColumnDef("적용년도", Payr0100BM.ATTR_APPTNYR, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{

        	}
        });
     
        /** column 이상 : ovr */
        listColumnDefs.add(new ColumnDef("금액이상", Payr0100BM.ATTR_OVR, ColumnDef.TYPE_LONG, 100, true, true, true){
        	{

        	}
        });
        /** column 미만 : udr */
        listColumnDefs.add(new ColumnDef("금액미만", Payr0100BM.ATTR_UDR, ColumnDef.TYPE_LONG, 100, true, true, true){
        	{

        	}
        });
        /** column 1인 : oneOfPepl */
        listColumnDefs.add(new ColumnDef("1인", Payr0100BM.ATTR_ONEOFPEPL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 2인 : twoOfPepl */
        listColumnDefs.add(new ColumnDef("2인", Payr0100BM.ATTR_TWOOFPEPL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 3인일반 : treOfGerl */
        listColumnDefs.add(new ColumnDef("3인일반", Payr0100BM.ATTR_TREOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 3인다자녀 : treOfMlchd */
        listColumnDefs.add(new ColumnDef("3인다자녀", Payr0100BM.ATTR_TREOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 4인일반 : furOfGerl */
        listColumnDefs.add(new ColumnDef("4인일반", Payr0100BM.ATTR_FUROFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 4인다자녀 : furOfMlchd */
        listColumnDefs.add(new ColumnDef("4인다자녀", Payr0100BM.ATTR_FUROFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 5인일반 : fveOfGerl */
        listColumnDefs.add(new ColumnDef("5인일반", Payr0100BM.ATTR_FVEOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 5인다자녀 : fveOfMlchd */
        listColumnDefs.add(new ColumnDef("5인다자녀", Payr0100BM.ATTR_FVEOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 6인일반 : sixOfGerl */
        listColumnDefs.add(new ColumnDef("6인일반", Payr0100BM.ATTR_SIXOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 6인다자녀 : sixOfMlchd */
        listColumnDefs.add(new ColumnDef("6인다자녀", Payr0100BM.ATTR_SIXOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 7인일반 : svnOfGerl */
        listColumnDefs.add(new ColumnDef("7인일반", Payr0100BM.ATTR_SVNOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 7인다자녀 : svnOfMlchd */
        listColumnDefs.add(new ColumnDef("7인다자녀", Payr0100BM.ATTR_SVNOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 8인일반 : egtOfGerl */
        listColumnDefs.add(new ColumnDef("8인일반", Payr0100BM.ATTR_EGTOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 8인다자녀 : egtOfMlchd */
        listColumnDefs.add(new ColumnDef("8인다자녀", Payr0100BM.ATTR_EGTOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 9인일반 : nineOfGerl */
        listColumnDefs.add(new ColumnDef("9인일반", Payr0100BM.ATTR_NINEOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 9인다자녀 : nineOfMlchd */
        listColumnDefs.add(new ColumnDef("9인다자녀", Payr0100BM.ATTR_NINEOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 10인일반 : tenOfGerl */
        listColumnDefs.add(new ColumnDef("10인일반", Payr0100BM.ATTR_TENOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 10인다자녀 : tenOfMlchd */
        listColumnDefs.add(new ColumnDef("10인다자녀", Payr0100BM.ATTR_TENOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 11인일반 : evthOfGerl */
        listColumnDefs.add(new ColumnDef("11인일반", Payr0100BM.ATTR_EVTHOFGERL, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 11인다자녀 : evthOfMlchd */
        listColumnDefs.add(new ColumnDef("11인다자녀", Payr0100BM.ATTR_EVTHOFMLCHD, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });

        /** column 적용기준시작일자 : apptnStdBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0100BM.ATTR_APPTNSTDBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{
        		//setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));
        	}
        });
        /** column 적용기준종료일자 : apptnStdEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0100BM.ATTR_APPTNSTDENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{
        		//setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));
        	}
        });
        
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });        
        setColumnsDefinition(listColumnDefs);
    }
}