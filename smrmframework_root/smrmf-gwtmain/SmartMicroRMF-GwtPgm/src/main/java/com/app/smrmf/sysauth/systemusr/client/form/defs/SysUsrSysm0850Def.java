package com.app.smrmf.sysauth.systemusr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0360BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0850BM;
import com.app.smrmf.sysauth.systemmtr.client.languages.SysmMtrConstants;
import com.app.smrmf.sysauth.systemusr.shared.SysmUsrDaoConstants;

public class SysUsrSysm0850Def extends TableDef implements SysmUsrDaoConstants {
    private int row = 0;
    
    private SysmMtrConstants lblSysmConst = SysmMtrConstants.INSTANCE;
    
    public SysUsrSysm0850Def(String chkDef){
    	  
        	 
             if("SYSM0850".equals(chkDef)){
           	  
           	  setTitle("");
              setDaoClass(CLASS_SYSMUSR0300TOSYSM0850_LIST); 
              setCustomListMethod(CLASS_SYSMUSR0300TOSYSM0850_LIST);
                 
           	  setColumnsDefinition(getAllColumnsList());
           	  setShowFilterToolbar(false);   
           	  setAutoFillGrid(true);
                 
        	      	setColumnsDefinition(getSysm0850ColumnsList()); 
         	} 
             
//             else if("BASS0360".equals(chkDef)){
//         		setTitle("사용 직종세정보");
//                 setDaoClass(""); 
//                 setCustomListMethod(CLASS_BASS0450TOBASS0360_LIST);
//           	  	setAutoFillGrid(false);
//                 setShowFilterToolbar(false);   
//        	      	setEditFieldGrid(false);
//        	      	setColumnsDefinition(getRightUpColumnsList()); 
//         	}else if("BASS0350".equals(chkDef)){
//         		setTitle("미사용 직종세정보");
//                 setDaoClass(""); 
//                 setCustomListMethod(CLASS_BASS0450TOBASS0350_LIST);
//           	  	setAutoFillGrid(false);
//                 setShowFilterToolbar(false);   
//        	      	setEditFieldGrid(false);
//        	      	setColumnsDefinition(getRightDownColumnsList()); 
//         	} 
             
       }
       

       private List<ColumnDef> getSysm0850ColumnsList(){
           row = 0;
           List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
            
           /** column 선택 : select */
           listColumnDefs.add(new ColumnDef("선택", SysIfBass0360BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
        	  {      	
        		 
        	  }        	  
           });   
          
            /** column 시스템구분코드 : sysDivCd */
			listColumnDefs.add(new ColumnDef("시스템구분코드", SysIfSysm0850BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			/** column 사용자아이디 : usrId */
			listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0850BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			/** column 사용자아이디 : usrNm */
			listColumnDefs.add(new ColumnDef("성 명", SysIfSysm0850BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			/** column 사용자권한구분코드 : usrDivCd */
			listColumnDefs.add(new ColumnDef("사용자권한구분코드", SysIfSysm0850BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사용자권한구분코드 : usrDivNm */
			listColumnDefs.add(new ColumnDef("사용자권한구분", SysIfSysm0850BM.ATTR_USRDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			/** column 메뉴코드 : mnuCd */
			listColumnDefs.add(new ColumnDef("메뉴코드", SysIfSysm0850BM.ATTR_MNUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 메뉴 : mnuNm */
			listColumnDefs.add(new ColumnDef("메뉴명", SysIfSysm0850BM.ATTR_MNUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			/** column 메뉴권한그룹화면조회여부 : mnuAuthGrpScnInqyYn */
			listColumnDefs.add(new ColumnDef("조회", SysIfSysm0850BM.ATTR_MNUAUTHGRPSCNINQYYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
				{
			
				}
			});
			/** column 메뉴권한그룹화면입력여부 : mnuAuthGrpScnInptYn */
			listColumnDefs.add(new ColumnDef("입력", SysIfSysm0850BM.ATTR_MNUAUTHGRPSCNINPTYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
				{
			
				}
			});
			/** column 메뉴권한그룹화면수정여부 : mnuAuthGrpScnRevnYn */
			listColumnDefs.add(new ColumnDef("수정", SysIfSysm0850BM.ATTR_MNUAUTHGRPSCNREVNYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
				{
			
				}
			});
			/** column 메뉴권한그룹화면삭제여부 : mnuAuthGrpScnDelYn */
			listColumnDefs.add(new ColumnDef("삭제", SysIfSysm0850BM.ATTR_MNUAUTHGRPSCNDELYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
				{
			
				}
			});
			/** column 메뉴권한그룹화면인쇄여부 : mnuAuthGrpScnPrtYn */
			listColumnDefs.add(new ColumnDef("인쇄", SysIfSysm0850BM.ATTR_MNUAUTHGRPSCNPRTYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
				{
			
				}
			});
		 	 
           return listColumnDefs;
       }
       
          
       private List<ColumnDef> getAllColumnsList(){
           row = 0;
           List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
            
 
           return listColumnDefs;
       }
}
