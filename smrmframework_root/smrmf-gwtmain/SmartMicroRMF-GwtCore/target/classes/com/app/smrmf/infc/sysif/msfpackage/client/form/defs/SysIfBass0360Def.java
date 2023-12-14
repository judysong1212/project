package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0360BM;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

public class SysIfBass0360Def extends TableDef implements MSFPkgDaoConstants {
    private int row = 0;
    
    private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;
    
    public SysIfBass0360Def(String chkDef){
    	
     
      	if ("SYSM0600TOP".equals(chkDef)){
      		setTitle("사용 직종세정보");
              setDaoClass(""); 
              setCustomListMethod(PKG_SYSM0600TOPTOBASS0360_LIST);
        	  	setAutoFillGrid(false);
                setShowFilterToolbar(false);   
      	      	setEditFieldGrid(false);
      	      	setColumnsDefinition(getRightUpColumnsList()); 
      	}else if("SYSM0600BTM".equals(chkDef)){
      		setTitle("미사용 직종세정보");
              setDaoClass(""); 
              setCustomListMethod(PKG_SYSM0600BTMTOBASS0360_LIST);
        	  	setAutoFillGrid(false);
              setShowFilterToolbar(false);   
      	      	setEditFieldGrid(false);
      	      	setColumnsDefinition(getRightDownColumnsList()); 
       }else if("SYSM0700".equals(chkDef)){
      		setTitle("미사용 직종세정보");
            setDaoClass(""); 
            setCustomListMethod(PKG_SYSM0700TOBASS0360_LIST);
      	  	setAutoFillGrid(true);
            setShowFilterToolbar(false);   
    	      	setEditFieldGrid(false);
    	      	setColumnsDefinition(getSysm0700ColumnsList()); 
    	}
      	
      	
      	
      	
}
 

private List<ColumnDef> getRightUpColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    
    /** column 선택 : select */
     listColumnDefs.add(new ColumnDef("선택", SysIfBass0360BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
  	  {      	
  		 
  	  }        	  
     });   
    
    listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0360BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING,70,false,false,false){
    	{
    		setReadOnly(true);
    	}
    });
    /** column 급여관리부서코드 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("급여관리부서코드", SysIfBass0360BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 급여관리부서명 : payMangeDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", SysIfBass0360BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });   
    /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0360BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 70, false, false, false){
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
      listColumnDefs.add(new ColumnDef("부서", SysIfBass0360BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 110, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
    /** column 직종명 : typOccuNm */
      listColumnDefs.add(new ColumnDef("직종", SysIfBass0360BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 110, false, true, true){
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
      listColumnDefs.add(new ColumnDef("직종세", SysIfBass0360BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
     
    /** column 직군세구분코드 : dtilOccuJbfmlDivCd */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0360BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING, 70, false, false, true){
    	   {
       		setReadOnly(true); 
       	  } 
       });   
       
       /** column 직군 : dtilOccuJbfmlDivNm */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0360BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
    	   {
       		setReadOnly(true); 
       	  } 
       });   
      
    /** column 직종세사용여부 : dtilOccuClsUseYn */
      listColumnDefs.add(new ColumnDef("사용", SysIfBass0360BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true, false){
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
    
    listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0360BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING,70,false,false,false){
    	{
    		setReadOnly(true);
    	}
    });
    
    
    /** column 급여관리부서코드 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("급여관리부서코드", SysIfBass0360BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 급여관리부서명 : payMangeDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", SysIfBass0360BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0360BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 70, false, false, false){
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
      listColumnDefs.add(new ColumnDef("부서", SysIfBass0360BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 130, false, true, false){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
    /** column 직종명 : typOccuNm */
      listColumnDefs.add(new ColumnDef("직종", SysIfBass0360BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 150, false, true, true){
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
      listColumnDefs.add(new ColumnDef("직종세", SysIfBass0360BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 120, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
     
    /** column 직군세구분코드 : dtilOccuJbfmlDivCd */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0360BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING, 80, false, false, true){
    	   {
       		setReadOnly(true); 
       	  } 
       });   
       
       /** column 직군 : dtilOccuJbfmlDivNm */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0360BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
    	   {
       		setReadOnly(true); 
       	  } 
       }); 
      
    /** column 직종세사용여부 : dtilOccuClsUseYn */
      listColumnDefs.add(new ColumnDef("사용", SysIfBass0360BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 70, true, true, true, false){
    	  {
      		 
      	  } 
      });
       
      
    return listColumnDefs;
}    



private List<ColumnDef> getSysm0700ColumnsList(){
	row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    
    
    /** column 선택 : select */
    listColumnDefs.add(new ColumnDef("선택", SysIfBass0360BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
  	  {
  		 
  	  }        	  
    });
    
    listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0360BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING,70,false,false,false){
    	{
    		setReadOnly(true);
    	}
    });
    
    
    /** column 급여관리부서코드 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("급여관리부서코드", SysIfBass0360BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    	{

    	}
    });
    /** column 급여관리부서명 : payMangeDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", SysIfBass0360BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, false){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
      listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0360BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 70, false, false, false){
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
      listColumnDefs.add(new ColumnDef("부서", SysIfBass0360BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 130, false, true, false){
    	  {
      		setReadOnly(true);  
      	  } 
      });
      
    /** column 직종명 : typOccuNm */
      listColumnDefs.add(new ColumnDef("직종", SysIfBass0360BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 150, false, true, true){
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
      listColumnDefs.add(new ColumnDef("직종세", SysIfBass0360BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 120, false, true, true){
    	  {
      		setReadOnly(true);  
      	  } 
      });
     
    /** column 직군세구분코드 : dtilOccuJbfmlDivCd */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0360BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING, 80, false, false, true){
    	   {
       		setReadOnly(true); 
       	  } 
       });   
       
       /** column 직군 : dtilOccuJbfmlDivNm */
       listColumnDefs.add(new ColumnDef("직군", SysIfBass0360BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
    	   {
       		setReadOnly(true); 
       	  } 
       }); 
      
    /** column 직종세사용여부 : dtilOccuClsUseYn */
      listColumnDefs.add(new ColumnDef("사용", SysIfBass0360BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 70, true, true, true, false){
    	  {
      		 
      	  } 
      });
      
      
  	/** column 사용자아이디 : usrId */
  	listColumnDefs.add(new ColumnDef("사용자아이디", SysIfBass0360BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, false, false, false){
  		{

  		}
  	});
      
    return listColumnDefs;
}    
        
}
