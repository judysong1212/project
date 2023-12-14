/**
 * 공통화면 팝업 
 */
package com.app.smrmf.syscom.client.lookup;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.syscom.client.dto.SysCoCalendarBM;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.shared.SysComDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class LookupSysComYear  extends TableDef implements SysComDaoConstants {

  
    private SysComConstants SysComLabel = SysComConstants.INSTANCE;

    public LookupSysComYear(){
        setTitle("");
        setDaoClass("");
        setCustomListMethod(MSFCOM_METHOD_COMBO_COCALE_YEAR_List);
        setAutoFillGrid(true);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column null : year */
        listColumnDefs.add(new ColumnDef("년도", SysCoCalendarBM.ATTR_YEAR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
    
        	}
        });
        
        /** column null : year */
        listColumnDefs.add(new ColumnDef("년도명", SysCoCalendarBM.ATTR_YEARDISP, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
    
        	}
        });
        
          
        
        setColumnsDefinition(listColumnDefs);
    }
     
}
