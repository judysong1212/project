/**
 * 공통화면 팝업 
 */
package com.app.smrmf.syscom.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0400;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.shared.SysComDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysComSysm0100Def  extends TableDef implements SysComDaoConstants {

    private int row = 0;
    private SysComConstants sysComLabel = SysComConstants.INSTANCE;

    private SysIfBass0400DTO sysComBass0400Dto;
    private SysIfBass0300DTO sysComBass0300Dto;
    
    public SysComSysm0100Def(){
    	
    	sysComBass0400Dto = new SysIfBass0400DTO(); 
    	sysComBass0300Dto = new SysIfBass0300DTO();
    	
        setTitle("사용자정보");
        setDaoClass("");
        setAutoFillGrid(false);

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
            
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, true, false,new LookupSysIfBass0400(sysComBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	});
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", SysIfSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
    		{

    		}
    	}); 
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, false, true, false){
    		{
    			 
    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, false, true, false){
    		{
    			 
    		}
    	});
    	
    	/** column 내선번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("내선번호", SysIfSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
        
        setColumnsDefinition(listColumnDefs);
    }
}
