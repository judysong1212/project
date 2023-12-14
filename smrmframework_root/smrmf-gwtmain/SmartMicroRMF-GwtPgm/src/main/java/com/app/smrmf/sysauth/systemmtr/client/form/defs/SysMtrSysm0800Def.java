package com.app.smrmf.sysauth.systemmtr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0800BM;
import com.app.smrmf.sysauth.systemmtr.client.languages.SysmMtrConstants;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;

public class SysMtrSysm0800Def extends TableDef implements SysmMtrDaoConstants {
    private int row = 0;
    
    private SysmMtrConstants lblSysmConst = SysmMtrConstants.INSTANCE;
    
    public SysMtrSysm0800Def(String chkDef){
    	  
        	 
             if("SYSMMTR0500".equals(chkDef)){
           	  
           	     setTitle("");
                 setDaoClass(CLASS_SYSMMTR0500TOSYSM0800_LIST); 
                 setCustomListMethod(CLASS_SYSMMTR0500TOSYSM0800_LIST);
                 
           	  setColumnsDefinition(getAllColumnsList());
           	  setShowFilterToolbar(false);   
           	  setAutoFillGrid(true);
                 
        	      	setColumnsDefinition(getSysm0800ColumnsList()); 
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
       

       private List<ColumnDef> getSysm0800ColumnsList(){
           row = 0;
           List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
            
           /** column 선택 : select */
           listColumnDefs.add(new ColumnDef("선택", SysIfSysm0800BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
        	  {      	
        		 
        	  }        	  
           });   
          
           /** column 시스템구분코드 : sysDivCd */
           listColumnDefs.add(new ColumnDef("시스템구분코드", SysIfSysm0800BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
           	{
           		setTypeTextField(ColumnDef.TEXTFIELD);
           	}
           });      

		/** column 사용자권한구분코드 : usrDivCd */
		listColumnDefs.add(new ColumnDef("권한구분코드", SysIfSysm0800BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setTypeTextField(ColumnDef.TEXTFIELD);
			}
		});
		

		/** column 사용자권한구분코드 : usrDivCd */
		listColumnDefs.add(new ColumnDef("권한구분", SysIfSysm0800BM.ATTR_USRDIVNM, ColumnDef.TYPE_STRING , 120, true, true, true){
			{
				setTypeTextField(ColumnDef.TEXTFIELD);
			}
		});
		
		/** column 권한그룹일련번호 : authGrpSeilNum */
		listColumnDefs.add(new ColumnDef("그룹번호", SysIfSysm0800BM.ATTR_AUTHGRPSEILNUM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{
		
			}
		});
		
		/** column 권한그룹명 : authGrpNm */
    	listColumnDefs.add(new ColumnDef("권한그룹명", SysIfSysm0300BM.ATTR_AUTHGRPNM, ColumnDef.TYPE_STRING, 120, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
		/** column 사용자권한그룹사용여부 : usrAuthGrpUseYn */
		listColumnDefs.add(new ColumnDef("사용", SysIfSysm0800BM.ATTR_USRAUTHGRPUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
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
