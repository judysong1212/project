/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350BM;
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
public class LookupPrgmComBass0320  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComBass0320(){
        setTitle(SysComLabel.titleSysComComboBass0320());
        setDaoClass("");     
        setCustomListMethod(PRGMCOM_METHOD_COMBO_BASS0320_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Bass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, true, true){
//        	{
//
//        	}
//        });
       
        /** column 직종 : typOccuCd  */
        listColumnDefs.add(new ColumnDef("직종코드", PrgmComBass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", PrgmComBass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupPrgmComBass0320(PrgmComBass0320DTO sysComBass0320Dto) {
        this();
        addColumnFilter("typOccuCd"   , sysComBass0320Dto.getTypOccuCd() , SimpleColumnFilter.OPERATOR_EQUALS); 
        addColumnFilter("deptCd"   , sysComBass0320Dto.getDeptCd() , SimpleColumnFilter.OPERATOR_EQUALS);        
        addColumnFilter("payrMangDeptCd"   , sysComBass0320Dto.getPayrMangDeptCd(), SimpleColumnFilter.OPERATOR_EQUALS); 
        //사용여부에 A 인경우 [N] [Y] 구분자로 표시하는 방법으로 구현 
        addColumnFilter("typOccuUseYn"   , sysComBass0320Dto.getTypOccuUseYn(), SimpleColumnFilter.OPERATOR_EQUALS); 
    
    }
}
