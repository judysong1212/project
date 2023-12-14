/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0500BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupPrgmComBass0500  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComBass0500(){
        setTitle(SysComLabel.titleSysComPopUpBass0500());
        setDaoClass("");
        setCustomListMethod(PRGMCOM_METHOD_POPUP_BASS0500_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100, false, true, true)); 
//        /** column 부서코드 : deptCd */
//        listColumnDefs.add(new ColumnDef("부서코드", PrgmComBass0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, true, true));
//        listColumnDefs.add(new ColumnDef("부서명", PrgmComBass0500BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 150, false, true, true));
//        /** column 사업적용년도 : businApptnYr */
//        listColumnDefs.add(new ColumnDef("사업적용년도", PrgmComBass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING, 90, false, true, true));

        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", PrgmComBass0500BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, true, true));

        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", PrgmComBass0500BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 250, false, true, true));
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupPrgmComBass0500(PrgmComBass0500DTO sysComBass0500Dto) {
        this();
        addColumnFilter("chkCombo"   , "combo" , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("deptCd"   , sysComBass0500Dto.getDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("businApptnYr"   , sysComBass0500Dto.getBusinApptnYr(), SimpleColumnFilter.OPERATOR_EQUALS); 
        
      
    }
}
