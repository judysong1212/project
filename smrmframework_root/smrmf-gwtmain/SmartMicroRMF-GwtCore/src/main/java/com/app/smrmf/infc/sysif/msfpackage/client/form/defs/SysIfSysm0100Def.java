package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

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
import com.app.smrmf.infc.sysif.msfpackage.client.languages.SysIfConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0400;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

public class SysIfSysm0100Def extends TableDef implements MSFPkgDaoConstants {
    private int row = 0;
    
    private SysIfConstants lblSysmConst = SysIfConstants.INSTANCE;
      
    private SysIfBass0300DTO sysIfBass0300Dto ;
    private SysIfBass0400DTO sysIfBass0400Dto;
    
    public SysIfSysm0100Def(String chkMenu){
    	 
       if ("SYSM0100".equals(chkMenu)) {	// 사용자검색
    		  
    	    sysIfBass0300Dto = new SysIfBass0300DTO();
            sysIfBass0400Dto = new SysIfBass0400DTO();
        	
            setTitle("사용자정보");
            setAutoFillGrid(false);
//            setDaoClass("");
//            setCustomListMethod(CLASS_SYSM0700TOSYSM0100_LIST);  
            setShowFilterToolbar(false);
          	setColumnsDefinition(getSysm0100DefList()); 
          	 
      
    	}  
	}
    
    private List<ColumnDef> getSysm0100DefList() {
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, true, false,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	});
    	
    	sysIfBass0300Dto.setRpsttvCd("D001");
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", SysIfSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
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
        
    	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
    	listColumnDefs.add(new ColumnDef("연말정산", SysIfSysm0100BM.ATTR_YRTXINPTPRCSYN, ColumnDef.TYPE_BOOLEAN , 70, true, true, true){
    		{

    		}
    	});
    	
    	return listColumnDefs;
        
    	
    }
    
 
}
