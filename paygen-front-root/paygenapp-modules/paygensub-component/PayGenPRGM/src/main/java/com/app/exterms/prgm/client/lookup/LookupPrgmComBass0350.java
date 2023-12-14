/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0350BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
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
public class LookupPrgmComBass0350  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComBass0350(){
        setTitle(SysComLabel.titleSysComComboBass0350());
        setDaoClass("");
        setCustomListMethod(PRGMCOM_METHOD_COMBO_BASS0350_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();  

        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, true, true){
//        	{
//
//        	}
//        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
//        /** column 직종코드 : typOccuCd */
//        listColumnDefs.add(new ColumnDef("직종코드", PrgmComBass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        
//        /** column 직종세구분코드 : dtilOccuClsDivCd */
//        listColumnDefs.add(new ColumnDef("직종세구분코드", PrgmComBass0350BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 100, false, true, true){
//        	{
//
//        	}
//        });
        /** column 직종세명 : dtilOccuClsNm */
        listColumnDefs.add(new ColumnDef("직종세명", PrgmComBass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 100, false, true, true){
        	{

        	}
        });
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupPrgmComBass0350(PrgmComBass0350DTO sysComBass0350Dto) {
        this();
        addColumnFilter("typOccuCd"   , sysComBass0350Dto.getTypOccuCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("dtilOccuInttnCd" , sysComBass0350Dto.getDtilOccuInttnCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("deptCd"   , sysComBass0350Dto.getDeptCd() , SimpleColumnFilter.OPERATOR_EQUALS);        
        addColumnFilter("payrMangDeptCd"   , sysComBass0350Dto.getPayrMangDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS); 
        //사용여부에 A 인경우 [N] [Y] 구분자로 표시하는 방법으로 구현 
        addColumnFilter("dtilOccuClsUseYn"   , sysComBass0350Dto.getDtilOccuClsUseYn(), SimpleColumnFilter.OPERATOR_EQUALS); 
         
    }
}
