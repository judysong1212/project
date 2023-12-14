package com.app.smrmf.sysauth.system.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0360BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0700BM;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;

public class Sysm0700Def extends TableDef implements SysmDaoConstants {
    private int row = 0;
    
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;
    
    public Sysm0700Def(String chkDef){
    	 
          if("SYSM0700".equals(chkDef)){
        	  
        	  setTitle("개별 사용직종세정보");
              setDaoClass(CLASS_SYSM0700TOSYSM0700_LIST); 
              setCustomListMethod(CLASS_SYSM0700TOSYSM0700_LIST);
              
        	  setColumnsDefinition(getAllColumnsList());
        	  setShowFilterToolbar(false);   
        	  setAutoFillGrid(true);
              
     	      	setColumnsDefinition(getSysm0700ColumnsList()); 
      	} 
          
//          else if("BASS0360".equals(chkDef)){
//      		setTitle("사용 직종세정보");
//              setDaoClass(""); 
//              setCustomListMethod(CLASS_BASS0450TOBASS0360_LIST);
//        	  	setAutoFillGrid(false);
//              setShowFilterToolbar(false);   
//     	      	setEditFieldGrid(false);
//     	      	setColumnsDefinition(getRightUpColumnsList()); 
//      	}else if("BASS0350".equals(chkDef)){
//      		setTitle("미사용 직종세정보");
//              setDaoClass(""); 
//              setCustomListMethod(CLASS_BASS0450TOBASS0350_LIST);
//        	  	setAutoFillGrid(false);
//              setShowFilterToolbar(false);   
//     	      	setEditFieldGrid(false);
//     	      	setColumnsDefinition(getRightDownColumnsList()); 
//      	} 
          
    }
    

    private List<ColumnDef> getSysm0700ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 선택 : select */
        listColumnDefs.add(new ColumnDef("선택", SysIfBass0360BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
     	  {      	
     		 
     	  }        	  
        });   
       
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", SysIfSysm0700BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	  /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", SysIfSysm0700BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 70, false, false, false){
      	  {
      		 
      	  }        	  
        }); 
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", SysIfSysm0700BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 80, false, false, false){
      	  {
        		 
        	  } 
        });
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서코드", SysIfSysm0700BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	

        
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("사용자아이디", SysIfSysm0700BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	 
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfSysm0700BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 70, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	
    	
    	  /** column 부서명_단축 : deptNmRtchnt */
        listColumnDefs.add(new ColumnDef("부서명", SysIfSysm0700BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING, 110, false, true, true){
      	  {
        		setReadOnly(true);  
        	  } 
        });
        
      /** column 직종명 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종명", SysIfSysm0700BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 110, false, true, true){
      	  {
        		setReadOnly(true);  
        	  } 
        });
        
        
        /** column 직종세명 : dtilOccuClsNm */
          listColumnDefs.add(new ColumnDef("직종세명", SysIfSysm0700BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	  {
          		setReadOnly(true);  
          	  } 
          });
          
          /** column 직군세구분코드 : dtilOccuJbfmlDivCd */
          listColumnDefs.add(new ColumnDef("직군", SysIfSysm0700BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING, 70, false, false, true){
       	   {
          		setReadOnly(true); 
          	  } 
          });   
          
          /** column 직군 : dtilOccuJbfmlDivNm */
          listColumnDefs.add(new ColumnDef("직군", SysIfSysm0700BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
       	   {
          		setReadOnly(true); 
          	  } 
          });   
         
       /** column 직종세사용여부 : dtilOccuClsUseYn */
         listColumnDefs.add(new ColumnDef("사용", SysIfSysm0700BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true, false){
       	  {
         		setReadOnly(false);
         	  } 
         }); 
          
//    	/** column 입력자 : kybdr */
//    	listColumnDefs.add(new ColumnDef("입력자", SysIfSysm0700BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력일자 : inptDt */
//    	listColumnDefs.add(new ColumnDef("입력일자", SysIfSysm0700BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력주소 : inptAddr */
//    	listColumnDefs.add(new ColumnDef("입력주소", SysIfSysm0700BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정자 : ismt */
//    	listColumnDefs.add(new ColumnDef("수정자", SysIfSysm0700BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정일자 : revnDt */
//    	listColumnDefs.add(new ColumnDef("수정일자", SysIfSysm0700BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정주소 : revnAddr */
//    	listColumnDefs.add(new ColumnDef("수정주소", SysIfSysm0700BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});

//    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//    	private TextField<String> typOccuInttnCd;   /** column 직종통합코드 : typOccuInttnCd */
//
//    	private TextField<String> dtilOccuClsDivCd;   /** column 직종세코드 : dtilOccuClsDivCd */
//
//    	private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//    	private TextField<String> usrId;   /** column 사용자아이디 : usrId */
//
//    	private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//    	private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//    	private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//    	private TextField<String> ismt;   /** column 수정자 : ismt */
//
//    	private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//    	private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
    	
        return listColumnDefs;
    }
    
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         

    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", SysIfSysm0700BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	  /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", SysIfSysm0700BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 70, false, false, false){
      	  {
      		 
      	  }        	  
        }); 
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", SysIfSysm0700BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 80, false, false, false){
      	  {
        		 
        	  } 
        });
    	 
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서코드", SysIfSysm0700BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("사용자아이디", SysIfSysm0700BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
//    	/** column 입력자 : kybdr */
//    	listColumnDefs.add(new ColumnDef("입력자", SysIfSysm0700BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력일자 : inptDt */
//    	listColumnDefs.add(new ColumnDef("입력일자", SysIfSysm0700BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력주소 : inptAddr */
//    	listColumnDefs.add(new ColumnDef("입력주소", SysIfSysm0700BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정자 : ismt */
//    	listColumnDefs.add(new ColumnDef("수정자", SysIfSysm0700BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정일자 : revnDt */
//    	listColumnDefs.add(new ColumnDef("수정일자", SysIfSysm0700BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정주소 : revnAddr */
//    	listColumnDefs.add(new ColumnDef("수정주소", SysIfSysm0700BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});

//    	private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//    	private TextField<String> typOccuInttnCd;   /** column 직종통합코드 : typOccuInttnCd */
//
//    	private TextField<String> dtilOccuClsDivCd;   /** column 직종세코드 : dtilOccuClsDivCd */
//
//    	private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//    	private TextField<String> usrId;   /** column 사용자아이디 : usrId */
//
//    	private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//    	private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//    	private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//    	private TextField<String> ismt;   /** column 수정자 : ismt */
//
//    	private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//    	private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
    	
        return listColumnDefs;
    }
}
