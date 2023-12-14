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
import com.app.exterms.resm.client.dto.Bass2350BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2350Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2350Def(){
    	  
    	  sysComBass0300Dto = new PrgmComBass0300DTO();
    	 
    	  setTitle("");
          setDaoClass(CLASS_BASS0200_LIST); 
          setCustomListMethod(CLASS_BASS0200_LIST);
          setAutoFillGrid(true);
          setShowFilterToolbar(false);
         // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true);
           
       //   addColumnFilter("pubcHodyCtnt", "", SimpleColumnFilter.OPERATOR_LIKE); 
		    
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
       

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업_세부직종코드 : busnDtlTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업_세부직종코드", Bass2350BM.ATTR_BUSNDTLTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업_유사세부직종코드", Bass2350BM.ATTR_BUSNSMLRDTLTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업유사세부직종명 : busnSmlrDtlTypOccuNm */
        listColumnDefs.add(new ColumnDef("사업유사세부직종명", Bass2350BM.ATTR_BUSNSMLRDTLTYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업유사세불직종시작일자 : busnSmlrTypOccuBgnnDt */
        listColumnDefs.add(new ColumnDef("사업유사세불직종시작일자", Bass2350BM.ATTR_BUSNSMLRTYPOCCUBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업유사세부직종종료일자 : busnSmlrTypOccuEndDt */
        listColumnDefs.add(new ColumnDef("사업유사세부직종종료일자", Bass2350BM.ATTR_BUSNSMLRTYPOCCUENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업유사세부직종사용여부 : busnSmlrTypOccuUseYn */
        listColumnDefs.add(new ColumnDef("사업유사세부직종사용여부", Bass2350BM.ATTR_BUSNSMLRTYPOCCUUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업유사세부직종내용 : busnSmlrDtlTypOccuCtnt */
        listColumnDefs.add(new ColumnDef("사업유사세부직종내용", Bass2350BM.ATTR_BUSNSMLRDTLTYPOCCUCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2350BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2350BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2350BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2350BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2350BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2350BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> busnDtlTypOccuCd;   /** column 사업_세부직종코드 : busnDtlTypOccuCd */
//
//        private TextField<String> busnSmlrDtlTypOccuCd;   /** column 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
//
//        private TextField<String> busnSmlrDtlTypOccuNm;   /** column 사업유사세부직종명 : busnSmlrDtlTypOccuNm */
//
//        private TextField<String> busnSmlrTypOccuBgnnDt;   /** column 사업유사세불직종시작일자 : busnSmlrTypOccuBgnnDt */
//
//        private TextField<String> busnSmlrTypOccuEndDt;   /** column 사업유사세부직종종료일자 : busnSmlrTypOccuEndDt */
//
//        private TextField<String> busnSmlrTypOccuUseYn;   /** column 사업유사세부직종사용여부 : busnSmlrTypOccuUseYn */
//
//        private TextField<String> busnSmlrDtlTypOccuCtnt;   /** column 사업유사세부직종내용 : busnSmlrDtlTypOccuCtnt */
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
