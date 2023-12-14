package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

public class SysIfBass0400Def extends TableDef implements MSFPkgDaoConstants {
    private int row = 0;
    
    private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;
    
    public SysIfBass0400Def(){
    	
    	  setTitle("");
          //setDaoClass(CLASS_SysIfBass0400_LIST); 
          //setCustomListMethod(CLASS_SysIfBass0400_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", SysIfBass0400BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서명_한글 : deptNmHan */
        listColumnDefs.add(new ColumnDef("부서명_한글", SysIfBass0400BM.ATTR_DEPTNMHAN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서명_단축 : deptNmRtchnt */
        listColumnDefs.add(new ColumnDef("부서명_단축", SysIfBass0400BM.ATTR_DEPTNMRTCHNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서명_영문 : deptNmEng */
        listColumnDefs.add(new ColumnDef("부서명_영문", SysIfBass0400BM.ATTR_DEPTNMENG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최상위부서코드 : tplvlDeptCd */
        listColumnDefs.add(new ColumnDef("최상위부서코드", SysIfBass0400BM.ATTR_TPLVLDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위부서코드 : hhrkDeptCd */
        listColumnDefs.add(new ColumnDef("상위부서코드", SysIfBass0400BM.ATTR_HHRKDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("null", SysIfBass0400BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서사용여부 : deptUseYn */
        listColumnDefs.add(new ColumnDef("부서사용여부", SysIfBass0400BM.ATTR_DEPTUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", SysIfBass0400BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", SysIfBass0400BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", SysIfBass0400BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", SysIfBass0400BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서비고내용 : deptNoteCtnt */
        listColumnDefs.add(new ColumnDef("부서비고내용", SysIfBass0400BM.ATTR_DEPTNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서출력여부 : deptDspyYn */
        listColumnDefs.add(new ColumnDef("부서출력여부", SysIfBass0400BM.ATTR_DEPTDSPYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관리부서코드 : mangeDeptCd */
        listColumnDefs.add(new ColumnDef("관리부서코드", SysIfBass0400BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", SysIfBass0400BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", SysIfBass0400BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", SysIfBass0400BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", SysIfBass0400BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", SysIfBass0400BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정자주소", SysIfBass0400BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서순서 : deptRank */
        listColumnDefs.add(new ColumnDef("부서순서", SysIfBass0400BM.ATTR_DEPTRANK, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> deptNmHan;   /** column 부서명_한글 : deptNmHan */
//
//        private TextField<String> deptNmRtchnt;   /** column 부서명_단축 : deptNmRtchnt */
//
//        private TextField<String> deptNmEng;   /** column 부서명_영문 : deptNmEng */
//
//        private TextField<String> tplvlDeptCd;   /** column 최상위부서코드 : tplvlDeptCd */
//
//        private TextField<String> hhrkDeptCd;   /** column 상위부서코드 : hhrkDeptCd */
//
//        private TextField<String> payrMangDeptCd;   /** column null : payrMangDeptCd */
//
//        private TextField<String> deptUseYn;   /** column 부서사용여부 : deptUseYn */
//
//        private TextField<String> natPennSym;   /** column 국민연금기호 : natPennSym */
//
//        private TextField<String> hlthInsrSym;   /** column 건강보험기호 : hlthInsrSym */
//
//        private TextField<String> umytInsrSym;   /** column 고용보험기호 : umytInsrSym */
//
//        private TextField<String> idtlAccdtInsurSym;   /** column 산재보험기호 : idtlAccdtInsurSym */
//
//        private TextField<String> deptNoteCtnt;   /** column 부서비고내용 : deptNoteCtnt */
//
//        private TextField<String> deptDspyYn;   /** column 부서출력여부 : deptDspyYn */
//
//        private TextField<String> mangeDeptCd;   /** column 관리부서코드 : mangeDeptCd */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정자주소 : revnAddr */
//
//        private TextField<String> deptRank;   /** column 부서순서 : deptRank */
//       
        return listColumnDefs;
    }
}
