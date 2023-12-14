/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0400BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
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
public class LookupPrgmComBass40001  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComBass40001(){
        setTitle(SysComLabel.titleSysComPopUpBass0500());
        setDaoClass("");
        setCustomListMethod(PRGMCOM_METHOD_LOOKUP_BASS040001_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
       
        /** column 사업장코드 : dpobCd */
     //   listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100, false, true, true)); 
        /** column 부서코드 : mangeDeptCd */
        listColumnDefs.add(new ColumnDef("부서코드", PrgmComBass0400BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        
//        listColumnDefs.add(new ColumnDef("부서코드", PrgmComBass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 부서명_한글 : deptNmHan */
       // listColumnDefs.add(new ColumnDef("부서명_한글", PrgmComBass0400BM.ATTR_DEPTNMHAN, ColumnDef.TYPE_STRING, 150, true, true, true));

        /** column 부서명_단축 : deptNmRtchnt */
        listColumnDefs.add(new ColumnDef("부서명_단축", PrgmComBass0400BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 150, true, true, true));
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupPrgmComBass40001(PrgmComBass0400DTO sysComBass0400Dto) {
        this();
        addColumnFilter("chkCombo"   		, "combo" 								, SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("deptCd"   			, sysComBass0400Dto.getDeptCd()			, SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("payrMangDeptCd"   	, sysComBass0400Dto.getPayrMangDeptCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeDeptCd"   	, sysComBass0400Dto.getMangeDeptCd() 	, SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeDeptNm"   	, sysComBass0400Dto.getMangeDeptNm() 	, SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("deptDspyYn"   		, sysComBass0400Dto.getDeptDspyYn() 	, SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("emymtDivCd"   		, "" 									, SimpleColumnFilter.OPERATOR_EQUALS);
        //사용여부에 A 인경우 [N] [Y] 구분자로 표시하는 방법으로 구현 
        addColumnFilter("deptUseYn"   		, sysComBass0400Dto.getDeptUseYn() 		, SimpleColumnFilter.OPERATOR_EQUALS);
          
    }
}
