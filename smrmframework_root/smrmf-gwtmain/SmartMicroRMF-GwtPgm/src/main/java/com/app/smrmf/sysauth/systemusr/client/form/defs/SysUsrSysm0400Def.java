package com.app.smrmf.sysauth.systemusr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0350BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0360BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.sysauth.systemusr.client.languages.SysmUsrConstants;
import com.app.smrmf.sysauth.systemusr.shared.SysmUsrDaoConstants;

public class SysUsrSysm0400Def extends TableDef implements SysmUsrDaoConstants {
    private int row = 0;
    
    private SysmUsrConstants lblSysmConst = SysmUsrConstants.INSTANCE ;

    public SysUsrSysm0400Def(String chkDef){
    	
	if("BASS0400".equals(chkDef)){
		setTitle("부서정보");
        setDaoClass(""); 
        setCustomListMethod(CLASS_SYSMUSR0400TOBASS0400_LIST);
  	  	setAutoFillGrid(true);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(false); 
	      	setEditFieldGrid(false);
	      	setColumnsDefinition(getLeftColumnsList()); 
	}else if("BASS0360".equals(chkDef)){
		setTitle("사용 직종세정보");
        setDaoClass(""); 
        setCustomListMethod(CLASS_SYSMUSR0400TOBASS0360_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
	      	setEditFieldGrid(false);
	      	setColumnsDefinition(getRightUpColumnsList()); 
	}else if("BASS0350".equals(chkDef)){
		setTitle("미사용 직종세정보");
        setDaoClass(""); 
        setCustomListMethod(CLASS_SYSMUSR0400TOBASS0350_LIST);
  	  	setAutoFillGrid(true);
        setShowFilterToolbar(false);   
	      	setEditFieldGrid(false);
	      	setColumnsDefinition(getRightDownColumnsList()); 
	}
	  
}
   
private List<ColumnDef> getLeftColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    
    listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING,70,false,false,false){
    	{
    		setReadOnly(true);
    	}
    });
    
    /** column 부서코드 : deptCd */ 
    listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 70, true, true, true));
      
    /** column 부서명_단축 : deptNmRtchnt */
      listColumnDefs.add(new ColumnDef("부서명", SysIfBass0400BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 150, true, true, true));
      
    /** column 관리부서코드 : mangeDeptCd */
      listColumnDefs.add(new ColumnDef("관리부서코드", SysIfBass0400BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING, 80, false, false, false));
      
    /** column 단위기관 : payrMangDeptCd */
      listColumnDefs.add(new ColumnDef("단위기관코드", SysIfBass0400BM.ATTR_PAYR_MANG_DEPT_CD, ColumnDef.TYPE_STRING, 80, false, false, false));
      
    /** column 부서사용여부 : deptUseYn */
      listColumnDefs.add(new ColumnDef("사용", SysIfBass0400BM.ATTR_DEPTUSEYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true));
      
      return listColumnDefs;
}


private List<ColumnDef> getRightUpColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    
    /** column 선택 : select */
     listColumnDefs.add(new ColumnDef("선택", SysIfBass0360BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
  	  {      	
  		 
  	  }        	  
     });   
    
    listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING,70,false,false,false){
    	{
    		setReadOnly(true);
    	}
    });
    /** column 급여관리부서코드 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("급여관리부서코드", SysIfBass0350BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 급여관리부서명 : payMangeDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", SysIfBass0350BM.ATTR_PAYMANGEDEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });      
    /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 70, false, false, false){
    	  {
    		setReadOnly(true);        		
    	  }        	  
      });
      /** column 직종코드 : typOccuCd */
      listColumnDefs.add(new ColumnDef("직종코드", SysIfBass0360BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 70, false, false, false){
    	  {
    		setReadOnly(true);
    	  }        	  
      });
      
    /** column 부서명_단축 : deptNmRtchnt */
      listColumnDefs.add(new ColumnDef("부서명", SysIfBass0400BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 110, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
    /** column 직종명 : typOccuNm */
      listColumnDefs.add(new ColumnDef("직종명", SysIfBass0360BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 110, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
   /** column 직종세통합코드 : dtilOccuInttnCd */
      listColumnDefs.add(new ColumnDef("직종세통합코드", SysIfBass0360BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 80, false, false, false){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
    /** column 직종세명 : dtilOccuClsNm */
      listColumnDefs.add(new ColumnDef("직종세명", SysIfBass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
     
    /** column 직군세구분코드 : dtilOccuJbfmlDivCd */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0350BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING, 70, false, false, true){
    	   {
       		setReadOnly(true); 
       	  } 
       });   
       
       /** column 직군 : dtilOccuJbfmlDivNm */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0350BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
    	   {
       		setReadOnly(true); 
       	  } 
       }); 
      
    /** column 직종세사용여부 : dtilOccuClsUseYn */
      listColumnDefs.add(new ColumnDef("사용", SysIfBass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true, false){
    	  {
      		setReadOnly(false);
      	  } 
      }); 
      
    return listColumnDefs;
}

private List<ColumnDef> getRightDownColumnsList(){
	row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    
    
    /** column 선택 : select */
    listColumnDefs.add(new ColumnDef("선택", SysIfBass0360BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
  	  {
  		 
  	  }        	  
    });
    
    listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING,70,false,false,false){
    	{
    		setReadOnly(true);
    	}
    });
    
    /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 70, false, false, false){
    	  {
    		setReadOnly(true);
    	  }        	  
      });
      
      /** column 직종코드 : typOccuCd */
      listColumnDefs.add(new ColumnDef("직종코드", SysIfBass0360BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 70, false, false, false){
    	  {
    		setReadOnly(true);
    	  }        	  
      });
      
    /** column 부서명_단축 : deptNmRtchnt */
      listColumnDefs.add(new ColumnDef("부서명", SysIfBass0400BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 130, false, false, false){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
    /** column 직종명 : typOccuNm */
      listColumnDefs.add(new ColumnDef("직종명", SysIfBass0360BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 150, false, true, true){
    	  {
      		setReadOnly(true);  
      		
      	  } 
      });
      
   /** column 직종세통합코드 : dtilOccuInttnCd */
      listColumnDefs.add(new ColumnDef("직종세통합코드", SysIfBass0360BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 80, false, false, false){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
    /** column 직종세명 : dtilOccuClsNm */
      listColumnDefs.add(new ColumnDef("직종세명", SysIfBass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 120, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
     
    /** column 직군세구분코드 : dtilOccuJbfmlDivCd */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0350BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING, 80, false, false, false){
    	   {
       		setReadOnly(true); 
       	  } 
       }); 
       
       /** column 직군 : dtilOccuJbfmlDivNm */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0350BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
    	   {
       		setReadOnly(true); 
       	  } 
       }); 
      
    /** column 직종세사용여부 : dtilOccuClsUseYn */
      listColumnDefs.add(new ColumnDef("사용", SysIfBass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 70, true, true, true, false){
    	  {
      		setReadOnly(false);
      	  } 
      });
      
    return listColumnDefs;
}
}
