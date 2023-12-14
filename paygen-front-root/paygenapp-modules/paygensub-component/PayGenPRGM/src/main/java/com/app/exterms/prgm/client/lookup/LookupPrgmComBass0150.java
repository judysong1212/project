/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupPrgmComBass0150  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComBass0150(){
        setTitle("");
        setDaoClass("");
        setCustomListMethod(PRGMCOM_METHOD_LOOK_BASS0150_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
       
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//    
//        	}
//        });
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", PrgmComBass0150BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
    
        	}
        });
        /** column 단위기관명 : payMangeDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관", PrgmComBass0150BM.ATTR_PAYMANGEDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
    
        	}
        });
          
        
        setColumnsDefinition(listColumnDefs);
    }
     
}
