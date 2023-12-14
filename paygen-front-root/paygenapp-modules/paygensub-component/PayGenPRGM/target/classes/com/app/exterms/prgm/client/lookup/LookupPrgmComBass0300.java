/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
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
public class LookupPrgmComBass0300  extends TableDef implements PrgmComDaoConstants {

  
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public LookupPrgmComBass0300(){
        setTitle(SysComLabel.titleSysComPopUpBass0300());
        setDaoClass("");
        setCustomListMethod(PRGMCOM_METHOD_COMBO_BASS0300_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
       
        listColumnDefs.add(new ColumnDef("코드", PrgmComBass0300BM.ATTR_COMMCD, ColumnDef.TYPE_STRING, 80, true, true, true){
            {
                
            }
        });
       
        listColumnDefs.add(new ColumnDef("코드명", PrgmComBass0300BM.ATTR_COMMCDNM, ColumnDef.TYPE_STRING, 200, true, true, true){
            {
                 
            }
        });
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupPrgmComBass0300(PrgmComBass0300DTO sysComBass0300Dto) {
        this();
        addColumnFilter("chkCombo"   , "combo" , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("rpsttvCd"   , sysComBass0300Dto.getRpsttvCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem01", sysComBass0300Dto.getMangeItem01(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem02", sysComBass0300Dto.getMangeItem02(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem03", sysComBass0300Dto.getMangeItem03(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem04", sysComBass0300Dto.getMangeItem04(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem05", sysComBass0300Dto.getMangeItem05(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem06", sysComBass0300Dto.getMangeItem06(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem07", sysComBass0300Dto.getMangeItem07(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem08", sysComBass0300Dto.getMangeItem08(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem09", sysComBass0300Dto.getMangeItem09(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem10", sysComBass0300Dto.getMangeItem10(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem11", sysComBass0300Dto.getMangeItem11(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem12", sysComBass0300Dto.getMangeItem12(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem13", sysComBass0300Dto.getMangeItem13(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem14", sysComBass0300Dto.getMangeItem14(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem15", sysComBass0300Dto.getMangeItem15(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem16", sysComBass0300Dto.getMangeItem16(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem17", sysComBass0300Dto.getMangeItem17(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem18", sysComBass0300Dto.getMangeItem18(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem19", sysComBass0300Dto.getMangeItem19(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem20", sysComBass0300Dto.getMangeItem20(), SimpleColumnFilter.OPERATOR_LIKE);
        //사용여부에 A 인경우 [N] [Y] 구분자로 표시하는 방법으로 구현 
        addColumnFilter("commUseYn", sysComBass0300Dto.getCommUseYn(), SimpleColumnFilter.OPERATOR_EQUALS);
      
    }
}
