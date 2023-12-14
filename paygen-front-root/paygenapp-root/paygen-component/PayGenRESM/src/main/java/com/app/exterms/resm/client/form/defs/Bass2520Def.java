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
import com.app.exterms.resm.client.dto.Bass2520BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2520Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2520Def(){
    	  
    	  sysComBass0300Dto = new PrgmComBass0300DTO();
    	 
    	  setTitle("");
          setDaoClass(CLASS_BASS0200_LIST); 
          setCustomListMethod(CLASS_BASS0200_LIST);
          setAutoFillGrid(true);
          setShowFilterToolbar(false);
         // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true);
           
      //    addColumnFilter("pubcHodyCtnt", "", SimpleColumnFilter.OPERATOR_LIKE); 
		    
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
       
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 설정통합구분값 : stpInttnSeptVal */
        listColumnDefs.add(new ColumnDef("설정통합구분값", Bass2520BM.ATTR_STPINTTNSEPTVAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무구분코드 : dutyDivCd */
        listColumnDefs.add(new ColumnDef("근무구분코드", Bass2520BM.ATTR_DUTYDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월요일근무여부 : monDutyYn */
        listColumnDefs.add(new ColumnDef("월요일근무여부", Bass2520BM.ATTR_MONDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 화요일근무여부 : tueDutyYn */
        listColumnDefs.add(new ColumnDef("화요일근무여부", Bass2520BM.ATTR_TUEDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수요일근무여부 : wedDutyYn */
        listColumnDefs.add(new ColumnDef("수요일근무여부", Bass2520BM.ATTR_WEDDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 목요일근무여부 : thurDutyYn */
        listColumnDefs.add(new ColumnDef("목요일근무여부", Bass2520BM.ATTR_THURDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금요일근무여부 : friDutyYn */
        listColumnDefs.add(new ColumnDef("금요일근무여부", Bass2520BM.ATTR_FRIDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 토요일근무여부 : satDutyYn */
        listColumnDefs.add(new ColumnDef("토요일근무여부", Bass2520BM.ATTR_SATDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 일요일근무여부 : sunDutyYn */
        listColumnDefs.add(new ColumnDef("일요일근무여부", Bass2520BM.ATTR_SUNDUTYYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상근무휴일계산여부 : norPubcHodyCalcYn */
        listColumnDefs.add(new ColumnDef("정상근무휴일계산여부", Bass2520BM.ATTR_NORPUBCHODYCALCYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 복무근무요일일련번호 : servcDutyDotwSeilNum */
        listColumnDefs.add(new ColumnDef("복무근무요일일련번호", Bass2520BM.ATTR_SERVCDUTYDOTWSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2520BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> stpInttnSeptVal;   /** column 설정통합구분값 : stpInttnSeptVal */
//
//        private TextField<String> dutyDivCd;   /** column 근무구분코드 : dutyDivCd */
//
//        private TextField<String> monDutyYn;   /** column 월요일근무여부 : monDutyYn */
//
//        private TextField<String> tueDutyYn;   /** column 화요일근무여부 : tueDutyYn */
//
//        private TextField<String> wedDutyYn;   /** column 수요일근무여부 : wedDutyYn */
//
//        private TextField<String> thurDutyYn;   /** column 목요일근무여부 : thurDutyYn */
//
//        private TextField<String> friDutyYn;   /** column 금요일근무여부 : friDutyYn */
//
//        private TextField<String> satDutyYn;   /** column 토요일근무여부 : satDutyYn */
//
//        private TextField<String> sunDutyYn;   /** column 일요일근무여부 : sunDutyYn */
//
//        private TextField<String> norPubcHodyCalcYn;   /** column 정상근무휴일계산여부 : norPubcHodyCalcYn */
//
//        private TextField<String> servcDutyDotwSeilNum;   /** column 복무근무요일일련번호 : servcDutyDotwSeilNum */
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
