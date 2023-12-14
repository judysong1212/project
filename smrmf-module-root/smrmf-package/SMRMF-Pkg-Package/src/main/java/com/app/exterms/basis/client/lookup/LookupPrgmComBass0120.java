/**
 * 공통화면 팝업 
 */
package com.app.exterms.basis.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.InfcPkgBass0150BM;
import com.app.exterms.basis.client.dto.InfcPkgBass0150DTO;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.PkgBasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupPrgmComBass0120  extends TableDef implements PkgBasisDaoConstants {

  
    private BasisConstants SysComLabel = BasisConstants.INSTANCE;

    public LookupPrgmComBass0120(){
        setTitle("");
        setDaoClass("");
        setCustomListMethod(METHOD_LOOK_BASS0120_LIST);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
       
        /** column 단위사업장코드 : utDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장코드", InfcPkgBass0150BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
    
        	}
        });
        /** column 단위사업장 : utDpobNm */
        listColumnDefs.add(new ColumnDef("단위사업장", InfcPkgBass0150BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
    
        	}
        });
          
        
        setColumnsDefinition(listColumnDefs);
    }
    public LookupPrgmComBass0120(InfcPkgBass0150DTO sysComBass0150Dto) {
        this();
        addColumnFilter("untDpobFndtnUseYn",sysComBass0150Dto.getUntDpobFndtnUseYn(), SimpleColumnFilter.OPERATOR_EQUALS);
    }
     
}
