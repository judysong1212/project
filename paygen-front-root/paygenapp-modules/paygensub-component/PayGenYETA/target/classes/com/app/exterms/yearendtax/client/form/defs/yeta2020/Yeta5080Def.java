/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2020;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.yearendtax.client.dto.InfcPkgSysm0100BM;
import com.app.exterms.yearendtax.client.dto.yeta2020.Yeta5080BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0400;

public class Yeta5080Def extends TableDef implements YetaDaoConstants {
    private int row = 0;
    
    private PrgmComBass0300DTO sysComBass0300Dto;
    
    private SysIfBass0300DTO sysIfBass0300Dto ;
    private SysIfBass0400DTO sysIfBass0400Dto;

    public Yeta5080Def(String chkDef){
    	
    	sysIfBass0300Dto = new SysIfBass0300DTO();
    	sysIfBass0400Dto = new SysIfBass0400DTO();
    	 
    	if("yeta5080ToBass0400".equals(chkDef)){
    		setTitle("부서");
            setDaoClass(""); 
	        setCustomListMethod(CLASS_YETA5080_TO_BASS0400_LIST);
      	  	setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta5080ToBass0400ColumnsList());
   	      	
    	}else if("yeta5080ToSysm0100On".equals(chkDef)){
    		setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA5080_TO_SYSM0100_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta5080ToSys0100ColumnsList()); 
   	      	
    	}
//    	else if("yeta2080ToSysm0100Off".equals(chkDef)){
//    		setTitle("미선택된 사용자");
//            setDaoClass(""); 
//            setCustomListMethod("");
//      	  	setAutoFillGrid(true);
//            setShowFilterToolbar(false);   
//   	      	setEditFieldGrid(false);
//   	      	setColumnsDefinition(getYeta2080ToBass0400ColumnsList()); 
//   	      	
//    	}
    	else if("yeta5080ToSysm0100Off".equals(chkDef)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA5080_TO_SYSM0100_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta5080ToSys0100ColumnsList()); 
    	 
		}   
//    	  
    }
   
    private List<ColumnDef> getYeta5080ToBass0400ColumnsList(){
    	
    	row = 0;
    	List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    	
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서코드", Yeta5080BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 70, false, true, false){
    		{

    		}
    	});
    	
    	
    	
    	/** column 부서명_단축 : deptNmRtchnt */
    	listColumnDefs.add(new ColumnDef("부서명", Yeta5080BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING , 150, false, true, false){
    		{

    		}
    	});
    	
    	
    	
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Yeta5080BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});

    	/** column 부서명_한글 : deptNmHan */
    	listColumnDefs.add(new ColumnDef("부서명_한글", Yeta5080BM.ATTR_DEPTNMHAN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});

    	/** column 부서명_영문 : deptNmEng */
    	listColumnDefs.add(new ColumnDef("부서명_영문", Yeta5080BM.ATTR_DEPTNMENG, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 최상위부서코드 : tplvlDeptCd */
    	listColumnDefs.add(new ColumnDef("최상위부서코드", Yeta5080BM.ATTR_TPLVLDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 상위부서코드 : hhrkDeptCd */
    	listColumnDefs.add(new ColumnDef("상위부서코드", Yeta5080BM.ATTR_HHRKDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column null : payrMangDeptCd */
    	listColumnDefs.add(new ColumnDef("null", Yeta5080BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서사용여부 : deptUseYn */
    	listColumnDefs.add(new ColumnDef("부서사용여부", Yeta5080BM.ATTR_DEPTUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 국민연금기호 : natPennSym */
    	listColumnDefs.add(new ColumnDef("국민연금기호", Yeta5080BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 건강보험기호 : hlthInsrSym */
    	listColumnDefs.add(new ColumnDef("건강보험기호", Yeta5080BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 고용보험기호 : umytInsrSym */
    	listColumnDefs.add(new ColumnDef("고용보험기호", Yeta5080BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 산재보험기호 : idtlAccdtInsurSym */
    	listColumnDefs.add(new ColumnDef("산재보험기호", Yeta5080BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서비고내용 : deptNoteCtnt */
    	listColumnDefs.add(new ColumnDef("부서비고내용", Yeta5080BM.ATTR_DEPTNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서출력여부 : deptDspyYn */
    	listColumnDefs.add(new ColumnDef("부서출력여부", Yeta5080BM.ATTR_DEPTDSPYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 관리부서코드 : mangeDeptCd */
    	listColumnDefs.add(new ColumnDef("관리부서코드", Yeta5080BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", Yeta5080BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", Yeta5080BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	return listColumnDefs;
    }
    
    
    /** 연말정산등록담당자관리 **/
    private List<ColumnDef> getYeta5080ToSys0100ColumnsList() {
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        /** column 선택 : select */
         listColumnDefs.add(new ColumnDef("선택", InfcPkgSysm0100BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
      	  {      	
      		 
      	  }        	  
         });  
        
        /** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 120, false, true, false,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	});
    	
    	sysIfBass0300Dto.setRpsttvCd("D001");
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", InfcPkgSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
    		{

    		}
    	}); 
    	
    	
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", InfcPkgSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 70, false, true, false){
    		{
    			 
    		}
    	});
    	
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", InfcPkgSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 70, false, true, false){
    		{
    			 
    		}
    	});
    	

    	/** column 내선번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("연말정산", InfcPkgSysm0100BM.ATTR_YRTXINPTPRCSYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
    		{

    		}
    	});
    	
        /** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{

    		}
    	});
        
    	return listColumnDefs;
        
    	
    }

}