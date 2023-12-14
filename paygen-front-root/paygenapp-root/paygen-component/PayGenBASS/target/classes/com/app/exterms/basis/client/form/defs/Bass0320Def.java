/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0320BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0320Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Bass0320Def(){
    	
    	  setTitle("");
          setDaoClass(""); 
          setCustomListMethod(CLASS_BASS0320_LIST);
          
    	  setColumnsDefinition(getAllColumnsList()); 
    	  setAutoFillGrid(true);
          setShowFilterToolbar(false);  
          
    }
       
    private List<ColumnDef> getAllColumnsList(){  
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0320BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Bass0320BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직종명 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종명", Bass0320BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직종사용여부 : typOccuUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", Bass0320BM.ATTR_TYPOCCUUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{

        	}
        });
        /** column 직종내용 : typOccuCtnt */
        listColumnDefs.add(new ColumnDef("직종내용", Bass0320BM.ATTR_TYPOCCUCTNT, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 개편전직종코드 : chngTypOccuCd */
        listColumnDefs.add(new ColumnDef("개편전직종코드", Bass0320BM.ATTR_CHNGTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정렬순서 : typOccuOrd */
        listColumnDefs.add(new ColumnDef("정렬순서", Bass0320BM.ATTR_TYPOCCUORD, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 직종직군구분코드 : typOccuJbfmlDivCd */
        listColumnDefs.add(new ColumnDef("직종직군구분코드", Bass0320BM.ATTR_TYPOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("등급코드", Bass0320BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });        
        /** column 직종시작일자 : typOccuStdt */
        listColumnDefs.add(new ColumnDef("직종시작일자", Bass0320BM.ATTR_TYPOCCUSTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직종종료일자 : typOccuEddt */
        listColumnDefs.add(new ColumnDef("직종종료일자", Bass0320BM.ATTR_TYPOCCUEDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });

//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Bass0320BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Bass0320BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Bass0320BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Bass0320BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Bass0320BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Bass0320BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> typOccuNm;   /** column 직종명 : typOccuNm */
//
//        private TextField<String> typOccuUseYn;   /** column 직종사용여부 : typOccuUseYn */
//
//        private TextField<String> typOccuCtnt;   /** column 직종내용 : typOccuCtnt */
//
//        private TextField<String> typOccuOrd;   /** column 정렬순서 : typOccuOrd */
//
//        private TextField<String> typOccuJbfmlDivCd;   /** column 직종직군구분코드 : typOccuJbfmlDivCd */
//
//        private TextField<String> pyspGrdeCd;   /** column null : pyspGrdeCd */
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
