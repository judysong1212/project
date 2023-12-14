/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0304BM;
import com.app.exterms.payroll.client.dto.Payr0400BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0400Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public Payr0400Def(){
        setTitle(PayrLabel.titlePayr0400());
        setDaoClass(CLASS_PAYR0400_DATA_LIST);
        setCustomListMethod(CLASS_PAYR0400_DATA_LIST);
        setAutoFillGrid(true);
        setShowFilterToolbar(false);
       // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
        setCheckBoxOnGridRows(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0400BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0400BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0400BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0400BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        }); 
        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0400BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        }); 
         
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0400BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0400BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});  
        
		/** column 최대근속년수코드 : bggLogSvcYrNumCd */
		listColumnDefs.add(new ColumnDef("최대근속년수코드", Payr0400BM.ATTR_BGGLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
       
        /** column 직종_등급맵핑내용 : typOccuGrdeMppgCtnt */
        listColumnDefs.add(new ColumnDef("직종_등급맵핑내용", Payr0400BM.ATTR_TYPOCCUGRDEMPPGCTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 직종_등급맵핑삭제여부 : typOccuGrdeMppgDelYn */
        listColumnDefs.add(new ColumnDef("직종_등급맵핑삭제여부", Payr0400BM.ATTR_TYPOCCUGRDEMPPGDELYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0400BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0400BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0400BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0400BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0400BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0400BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });



        setColumnsDefinition(listColumnDefs);
    }
}
