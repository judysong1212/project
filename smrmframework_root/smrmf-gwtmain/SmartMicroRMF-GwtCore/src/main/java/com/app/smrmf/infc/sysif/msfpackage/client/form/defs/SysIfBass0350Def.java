package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0350BM;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

public class SysIfBass0350Def extends TableDef implements MSFPkgDaoConstants {
    private int row = 0;
    
    private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;
    
    public SysIfBass0350Def(){
    	
    	  setTitle("");
       //   setDaoClass(CLASS_SysIfBass0350_LIST); 
        //  setCustomListMethod(CLASS_SysIfBass0350_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", SysIfBass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", SysIfBass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", SysIfBass0350BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", SysIfBass0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세명 : dtilOccuClsNm */
        listColumnDefs.add(new ColumnDef("직종세명", SysIfBass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세직군구분코드 : dtilOccuJbfmlDivCd */
        listColumnDefs.add(new ColumnDef("직종세직군구분코드", SysIfBass0350BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세사용여부 : dtilOccuClsUseYn */
        listColumnDefs.add(new ColumnDef("직종세사용여부", SysIfBass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전환대상여부 : chngTgtYn */
        listColumnDefs.add(new ColumnDef("전환대상여부", SysIfBass0350BM.ATTR_CHNGTGTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세내용 : dtilOccuClsCtnt */
        listColumnDefs.add(new ColumnDef("직종세내용", SysIfBass0350BM.ATTR_DTILOCCUCLSCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정렬순서 : dtilOccuClsOrd */
        listColumnDefs.add(new ColumnDef("정렬순서", SysIfBass0350BM.ATTR_DTILOCCUCLSORD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 최대근속년수코드 : bggLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("최대근속년수코드", SysIfBass0350BM.ATTR_BGGLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
    	/** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
		listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", SysIfBass0350BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 직종세적용단가금액 : dtilOcclsApptnUcstSum */
		listColumnDefs.add(new ColumnDef("직종세적용단가금액", SysIfBass0350BM.ATTR_DTILOCCLSAPPTNUCSTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", SysIfBass0350BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", SysIfBass0350BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", SysIfBass0350BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", SysIfBass0350BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", SysIfBass0350BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", SysIfBass0350BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세코드 : dtilOccuClsDivCd */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> dtilOccuClsNm;   /** column 직종세명 : dtilOccuClsNm */
//
//        private TextField<String> dtilOccuJbfmlDivCd;   /** column 직종세직군구분코드 : dtilOccuJbfmlDivCd */
//
//        private TextField<String> dtilOccuClsUseYn;   /** column 직종세사용여부 : dtilOccuClsUseYn */
//
//        private TextField<String> chngTgtYn;   /** column 전환대상여부 : chngTgtYn */
//
//        private TextField<String> dtilOccuClsCtnt;   /** column 직종세내용 : dtilOccuClsCtnt */
//
//        private TextField<String> dtilOccuClsOrd;   /** column 정렬순서 : dtilOccuClsOrd */
//
//        private TextField<String> bggLogSvcYrNumCd;   /** column 최대근속년수코드 : bggLogSvcYrNumCd */
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
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
       
        return listColumnDefs;
    }
}
