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
import com.app.exterms.resm.client.dto.Bass0505BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0505Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass0505Def(){
    	  
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
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0505BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Bass0505BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : deptCd */
        listColumnDefs.add(new ColumnDef("null", Bass0505BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기간제회계구분코드 : fxtmAccDivCd */
        listColumnDefs.add(new ColumnDef("기간제회계구분코드", Bass0505BM.ATTR_FXTMACCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기간제적용단가일수 : fxtmApptnUcstNumDys */
        listColumnDefs.add(new ColumnDef("기간제적용단가일수", Bass0505BM.ATTR_FXTMAPPTNUCSTNUMDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기간제일급단가금액 : fxtmPdyUcstSum */
        listColumnDefs.add(new ColumnDef("기간제일급단가금액", Bass0505BM.ATTR_FXTMPDYUCSTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교대근무적용여부 : rotaDutyApptnYn */
        listColumnDefs.add(new ColumnDef("교대근무적용여부", Bass0505BM.ATTR_ROTADUTYAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass0505BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass0505BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass0505BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass0505BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass0505BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass0505BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> deptCd;   /** column null : deptCd */
//
//        private TextField<String> fxtmAccDivCd;   /** column 기간제회계구분코드 : fxtmAccDivCd */
//
//        private TextField<String> fxtmApptnUcstNumDys;   /** column 기간제적용단가일수 : fxtmApptnUcstNumDys */
//
//        private TextField<String> fxtmPdyUcstSum;   /** column 기간제일급단가금액 : fxtmPdyUcstSum */
//
//        private TextField<String> rotaDutyApptnYn;   /** column 교대근무적용여부 : rotaDutyApptnYn */
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
