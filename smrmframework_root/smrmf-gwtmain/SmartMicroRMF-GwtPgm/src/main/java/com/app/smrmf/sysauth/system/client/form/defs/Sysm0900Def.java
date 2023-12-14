package com.app.smrmf.sysauth.system.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfPsnl0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfPsnl0115BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;

public class Sysm0900Def extends TableDef implements SysmDaoConstants {
    private int row = 0;
    
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;
      
//    private SysIfBass0300DTO sysIfBass0300Dto ;
//    private SysIfBass0400DTO sysIfBass0400Dto;
    
    public Sysm0900Def(String chkMenu){
    	 
    	if ("Psnl0100".equals(chkMenu)) {
	            
//			setTitle(lblSysmConst.title_Sysm0100());
			setDaoClass("");
			setCustomListMethod(CLASS_SYSM0900_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setColumnsDefinition(getPsnl0100DefList());
        	
        	  
    	} else if("Psnl0115".equals(chkMenu)) {
    		
//			setTitle(lblSysmConst.title_Sysm0100());
			setDaoClass("");
			setCustomListMethod(CLASS_SYSM0900_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setColumnsDefinition(getPsnl0115DefList());
    		
    	}else {

//			setTitle(lblSysmConst.title_Sysm0100());
			setDaoClass(CLASS_SYSM0100_CUD);
			setCustomListMethod(CLASS_SYSM0100_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);

			setColumnsDefinition(getPsnl0115DefList());
    	 
		}
	}
    
    private List<ColumnDef> getPsnl0100DefList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 130, true, false, true){
    		{

    		}
    	}); 
    	
    	/** column 부서코드 : deptNm */
    	listColumnDefs.add(new ColumnDef("부서", SysIfSysm0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 130, true, true, true ){
    		{

    		}
    	}); 
     
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", SysIfPsnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호(복호화)", SysIfPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnSecNum */
        listColumnDefs.add(new ColumnDef("주민번호(암호화)", SysIfPsnl0100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 120, false, true, false){
        	{

        	}
        });
        
        /** column  */
        listColumnDefs.add(new ColumnDef("조회구분", SysIfPsnl0115BM.ATTR_DATATYPE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
 
        
        return listColumnDefs;
      
    }
    
    
    private List<ColumnDef> getPsnl0115DefList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 130, true, false, true){
    		{

    		}
    	}); 
    	
    	/** column 부서코드 : deptNm */
    	listColumnDefs.add(new ColumnDef("부서", SysIfSysm0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 130, true, true, true ){
    		{

    		}
    	}); 
     
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", SysIfPsnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호(복호화)", SysIfPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnSecNum */
        listColumnDefs.add(new ColumnDef("주민번호(암호화)", SysIfPsnl0100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 100, false, false, false){
        	{

        	}
        });
        
        /** column 가족관계구분코드 : famyRelaDivCd */
        listColumnDefs.add(new ColumnDef("가족관계구분코드", SysIfPsnl0115BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 가족관계구분코드 : famyRelaDivCd */
        listColumnDefs.add(new ColumnDef("가족관계", SysIfPsnl0115BM.ATTR_FAMYRELADIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 가족성명 : famyNm */
        listColumnDefs.add(new ColumnDef("가족성명", SysIfPsnl0115BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 가족주민등록번호 : famyResnRegnNum */
        listColumnDefs.add(new ColumnDef("가족주민번호(복호화)", SysIfPsnl0115BM.ATTR_FAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 가족주민등록번호 : famyResnRegnNum */
        listColumnDefs.add(new ColumnDef("가족주민번호(암호화)", SysIfPsnl0115BM.ATTR_SECFAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column  */
        listColumnDefs.add(new ColumnDef("조회구분", SysIfPsnl0115BM.ATTR_DATATYPE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
 
        return listColumnDefs;
      
    }
    
    
    
    
}
