/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.resm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.resm.client.dto.Bass2050BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2050Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2050Def(){
    	  
    	  sysComBass0300Dto = new PrgmComBass0300DTO();
    	 
    	  setTitle("");
          setDaoClass(CLASS_BASS0200_LIST); 
          setCustomListMethod(CLASS_BASS0200_LIST);
          setAutoFillGrid(true);
          setShowFilterToolbar(false);
         // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true);
           
        //  addColumnFilter("pubcHodyCtnt", "", SimpleColumnFilter.OPERATOR_LIKE); 
		    
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2050BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업번호 : workBusinNum */
        listColumnDefs.add(new ColumnDef("근로사업번호", Bass2050BM.ATTR_WORKBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업_단위사업번호 : workUntBusinNum */
        listColumnDefs.add(new ColumnDef("근로사업_단위사업번호", Bass2050BM.ATTR_WORKUNTBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업_세부직종공통코드 : busnDtlTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업_세부직종공통코드", Bass2050BM.ATTR_BUSNDTLTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업_유사세부직종코드", Bass2050BM.ATTR_BUSNSMLRDTLTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업_단위사업담당부서코드 : workBusinRepbtyDeptCd */
        listColumnDefs.add(new ColumnDef("근로사업_단위사업담당부서코드", Bass2050BM.ATTR_WORKBUSINREPBTYDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업_단위사업담당자아이디 : workBusinPernChrgId */
        listColumnDefs.add(new ColumnDef("근로사업_단위사업담당자아이디", Bass2050BM.ATTR_WORKBUSINPERNCHRGID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
        listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", Bass2050BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 과세유형구분코드 : txtnFrmDivCd */
        listColumnDefs.add(new ColumnDef("과세유형구분코드", Bass2050BM.ATTR_TXTNFRMDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장코드 : untDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장코드", Bass2050BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사대보험사업장기호통합코드 : socInsrSymInttnCd */
        listColumnDefs.add(new ColumnDef("사대보험사업장기호통합코드", Bass2050BM.ATTR_SOCINSRSYMINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업회계코드 : untBusinAccCd */
        listColumnDefs.add(new ColumnDef("단위사업회계코드", Bass2050BM.ATTR_UNTBUSINACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업_단위사업비고내용 : workUntBusinCtnt */
        listColumnDefs.add(new ColumnDef("근로사업_단위사업비고내용", Bass2050BM.ATTR_WORKUNTBUSINCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2050BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2050BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2050BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2050BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2050BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2050BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> workBusinNum;   /** column 근로사업번호 : workBusinNum */
//
//        private TextField<String> workUntBusinNum;   /** column 근로사업_단위사업번호 : workUntBusinNum */
//
//        private TextField<String> busnDtlTypOccuCd;   /** column 사업_세부직종공통코드 : busnDtlTypOccuCd */
//
//        private TextField<String> busnSmlrDtlTypOccuCd;   /** column 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
//
//        private TextField<String> workBusinRepbtyDeptCd;   /** column 근로사업_단위사업담당부서코드 : workBusinRepbtyDeptCd */
//
//        private TextField<String> workBusinPernChrgId;   /** column 근로사업_단위사업담당자아이디 : workBusinPernChrgId */
//
//        private TextField<String> dtilOcclsApptnUcstCd;   /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
//
//        private TextField<String> txtnFrmDivCd;   /** column 과세유형구분코드 : txtnFrmDivCd */
//
//        private TextField<String> untDpobCd;   /** column 단위사업장코드 : untDpobCd */
//
//        private TextField<String> socInsrSymInttnCd;   /** column 사대보험사업장기호통합코드 : socInsrSymInttnCd */
//
//        private TextField<String> untBusinAccCd;   /** column 단위사업회계코드 : untBusinAccCd */
//
//        private TextField<String> workUntBusinCtnt;   /** column 근로사업_단위사업비고내용 : workUntBusinCtnt */
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
//      
        
        return listColumnDefs;
    }
}
