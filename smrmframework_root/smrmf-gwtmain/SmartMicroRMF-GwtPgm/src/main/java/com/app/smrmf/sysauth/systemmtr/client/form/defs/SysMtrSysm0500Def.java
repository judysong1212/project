package com.app.smrmf.sysauth.systemmtr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0500BM;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;

public class SysMtrSysm0500Def extends TableDef implements SysmDaoConstants {
    private int row = 0;
    
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;
    
    public SysMtrSysm0500Def(){
    	
    	  setTitle(lblSysmConst.title_Sysm0500());
          setDaoClass(CLASS_SYSM0500_LIST); 
          setCustomListMethod(CLASS_SYSM0500_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         

/** column 시스템구분코드 : sysDivCd */
listColumnDefs.add(new ColumnDef("시스템구분코드", SysIfSysm0500BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});

/** column 사용자권한구분코드 : usrDivCd */
listColumnDefs.add(new ColumnDef("사용자권한구분코드", SysIfSysm0500BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true){
	{

	}
});

/** column 사용자권한구분코드 : usrDivCd */
listColumnDefs.add(new ColumnDef("사용자권한구분", SysIfSysm0500BM.ATTR_USRDIVNM, ColumnDef.TYPE_STRING , 120, true, true, true){
	{

	}
});

/** column 사용자아이디 : usrId */
listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0500BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, true, true){
	{

	}
});

/** column 사용자아이디 : usrId */
listColumnDefs.add(new ColumnDef("성명", SysIfSysm0500BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 100, true, true, true){
	{

	}
});


/** column 사용자권한사용여부 : usrAuthUseYn */
listColumnDefs.add(new ColumnDef("사용여부", SysIfSysm0500BM.ATTR_USRAUTHUSEYN, ColumnDef.TYPE_STRING , 90, true, true, true){
	{

	}
});

///** column 입력자 : kybdr */
//listColumnDefs.add(new ColumnDef("입력자", SysIfSysm0500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 입력일자 : inptDt */
//listColumnDefs.add(new ColumnDef("입력일자", SysIfSysm0500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정자 : ismt */
//listColumnDefs.add(new ColumnDef("수정자", SysIfSysm0500BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정일자 : revnDt */
//listColumnDefs.add(new ColumnDef("수정일자", SysIfSysm0500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정주소 : revnAddr */
//listColumnDefs.add(new ColumnDef("수정주소", SysIfSysm0500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 입력주소 : inptAddr */
//listColumnDefs.add(new ColumnDef("입력주소", SysIfSysm0500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});

//private TextField<String> sysDivCd;   /** column 시스템구분코드 : sysDivCd */
//
//private TextField<String> usrId;   /** column 사용자아이디 : usrId */
//
//private TextField<String> usrDivCd;   /** column 사용자권한구분코드 : usrDivCd */
//
//private TextField<String> usrAuthUseYn;   /** column 사용자권한사용여부 : usrAuthUseYn */
//
//private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//private TextField<String> ismt;   /** column 수정자 : ismt */
//
//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//
//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */

   
        return listColumnDefs;
    }
}
