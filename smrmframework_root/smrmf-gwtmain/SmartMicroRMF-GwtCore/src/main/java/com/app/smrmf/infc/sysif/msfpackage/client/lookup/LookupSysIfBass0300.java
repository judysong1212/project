/**
 * 공통화면 팝업 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupSysIfBass0300  extends TableDef implements MSFPkgDaoConstants {

  
	 private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;

    public LookupSysIfBass0300(){
       // setTitle(lblSysmConst.titleSysComPopUpBass0300());
        setDaoClass("");
        setCustomListMethod(MSFPKG_METHOD_COMBO_BASS0300_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
       
        listColumnDefs.add(new ColumnDef("코드", SysIfBass0300BM.ATTR_COMMCD, ColumnDef.TYPE_STRING, 80, true, true, true){
            {
                
            }
        });
       
        listColumnDefs.add(new ColumnDef("코드명", SysIfBass0300BM.ATTR_COMMCDNM, ColumnDef.TYPE_STRING, 200, true, true, true){
            {
                 
            }
        });
          
        
        setColumnsDefinition(listColumnDefs);
    }
    
    public LookupSysIfBass0300(SysIfBass0300DTO sysIfBass0300Dto) {
        this();
        addColumnFilter("chkCombo"   , "combo" , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("rpsttvCd"   , sysIfBass0300Dto.getRpsttvCd() , SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem01", sysIfBass0300Dto.getMangeItem01(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem02", sysIfBass0300Dto.getMangeItem02(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem03", sysIfBass0300Dto.getMangeItem03(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem04", sysIfBass0300Dto.getMangeItem04(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem05", sysIfBass0300Dto.getMangeItem05(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem06", sysIfBass0300Dto.getMangeItem06(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem07", sysIfBass0300Dto.getMangeItem07(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem08", sysIfBass0300Dto.getMangeItem08(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem09", sysIfBass0300Dto.getMangeItem09(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem10", sysIfBass0300Dto.getMangeItem10(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem11", sysIfBass0300Dto.getMangeItem11(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem12", sysIfBass0300Dto.getMangeItem12(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem13", sysIfBass0300Dto.getMangeItem13(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem14", sysIfBass0300Dto.getMangeItem14(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem15", sysIfBass0300Dto.getMangeItem15(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem16", sysIfBass0300Dto.getMangeItem16(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem17", sysIfBass0300Dto.getMangeItem17(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem18", sysIfBass0300Dto.getMangeItem18(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem19", sysIfBass0300Dto.getMangeItem19(), SimpleColumnFilter.OPERATOR_EQUALS);
        addColumnFilter("mangeItem20", sysIfBass0300Dto.getMangeItem20(), SimpleColumnFilter.OPERATOR_LIKE);
      
    }
}
