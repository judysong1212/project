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
import com.app.exterms.resm.client.dto.Bass2640BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2640Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2640Def(){
    	  
    	  sysComBass0300Dto = new PrgmComBass0300DTO();
    	 
    	  setTitle("");
          setDaoClass(CLASS_BASS0200_LIST); 
          setCustomListMethod(CLASS_BASS0200_LIST);
          setAutoFillGrid(true);
          setShowFilterToolbar(false);
         // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true);
           
         // addColumnFilter("pubcHodyCtnt", "", SimpleColumnFilter.OPERATOR_LIKE); 
		    
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2640BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 설정통합구분값 : stpInttnSeptVal */
        listColumnDefs.add(new ColumnDef("설정통합구분값", Bass2640BM.ATTR_STPINTTNSEPTVAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일조기출근수당배율 : wkdyEryGtwkExtpyMgftn */
        listColumnDefs.add(new ColumnDef("평일조기출근수당배율", Bass2640BM.ATTR_WKDYERYGTWKEXTPYMGFTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일조기출근수당금액 : wkdyEryGtwkExtpySum */
        listColumnDefs.add(new ColumnDef("평일조기출근수당금액", Bass2640BM.ATTR_WKDYERYGTWKEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일정상근무수당배율 : wkdyNorDutyExtpyMgftn */
        listColumnDefs.add(new ColumnDef("평일정상근무수당배율", Bass2640BM.ATTR_WKDYNORDUTYEXTPYMGFTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일정상근무수당금액 : wkdyNorDutyExtpySum */
        listColumnDefs.add(new ColumnDef("평일정상근무수당금액", Bass2640BM.ATTR_WKDYNORDUTYEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일연장근무수당배율 : wkdyExtnnExtpyMgftn */
        listColumnDefs.add(new ColumnDef("평일연장근무수당배율", Bass2640BM.ATTR_WKDYEXTNNEXTPYMGFTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일연장근무수당금액 : wkdyExtnnExtpySum */
        listColumnDefs.add(new ColumnDef("평일연장근무수당금액", Bass2640BM.ATTR_WKDYEXTNNEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일야간근무수당배율 : wkdyNgtExtpyMgftn */
        listColumnDefs.add(new ColumnDef("평일야간근무수당배율", Bass2640BM.ATTR_WKDYNGTEXTPYMGFTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일야간근무수당금액 : wkdyNgtExtpySum */
        listColumnDefs.add(new ColumnDef("평일야간근무수당금액", Bass2640BM.ATTR_WKDYNGTEXTPYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일정상근무배율 : pubcHodyNorDutyMgftn */
        listColumnDefs.add(new ColumnDef("휴일정상근무배율", Bass2640BM.ATTR_PUBCHODYNORDUTYMGFTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일정상근무금액 : pubcHodyNorDutySum */
        listColumnDefs.add(new ColumnDef("휴일정상근무금액", Bass2640BM.ATTR_PUBCHODYNORDUTYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일연장근무배율 : pubcHodyExtnnMgftn */
        listColumnDefs.add(new ColumnDef("휴일연장근무배율", Bass2640BM.ATTR_PUBCHODYEXTNNMGFTN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일연장근무금액 : pubcHodyExtnnSum */
        listColumnDefs.add(new ColumnDef("휴일연장근무금액", Bass2640BM.ATTR_PUBCHODYEXTNNSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 급여근무시간계산일련번호 : payDutyTmCalcSeilNum */
        listColumnDefs.add(new ColumnDef("급여근무시간계산일련번호", Bass2640BM.ATTR_PAYDUTYTMCALCSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업번호 : workBusinNum */
        listColumnDefs.add(new ColumnDef("근로사업번호", Bass2640BM.ATTR_WORKBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업_단위사업번호 : workUntBusinNum */
        listColumnDefs.add(new ColumnDef("근로사업_단위사업번호", Bass2640BM.ATTR_WORKUNTBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관리부서_단위사업번호 : mangeUntBusinNum */
        listColumnDefs.add(new ColumnDef("관리부서_단위사업번호", Bass2640BM.ATTR_MANGEUNTBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2640BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2640BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2640BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2640BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2640BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2640BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> stpInttnSeptVal;   /** column 설정통합구분값 : stpInttnSeptVal */
//
//        private TextField<String> wkdyEryGtwkExtpyMgftn;   /** column 평일조기출근수당배율 : wkdyEryGtwkExtpyMgftn */
//
//        private TextField<String> wkdyEryGtwkExtpySum;   /** column 평일조기출근수당금액 : wkdyEryGtwkExtpySum */
//
//        private TextField<String> wkdyNorDutyExtpyMgftn;   /** column 평일정상근무수당배율 : wkdyNorDutyExtpyMgftn */
//
//        private TextField<String> wkdyNorDutyExtpySum;   /** column 평일정상근무수당금액 : wkdyNorDutyExtpySum */
//
//        private TextField<String> wkdyExtnnExtpyMgftn;   /** column 평일연장근무수당배율 : wkdyExtnnExtpyMgftn */
//
//        private TextField<String> wkdyExtnnExtpySum;   /** column 평일연장근무수당금액 : wkdyExtnnExtpySum */
//
//        private TextField<String> wkdyNgtExtpyMgftn;   /** column 평일야간근무수당배율 : wkdyNgtExtpyMgftn */
//
//        private TextField<String> wkdyNgtExtpySum;   /** column 평일야간근무수당금액 : wkdyNgtExtpySum */
//
//        private TextField<String> pubcHodyNorDutyMgftn;   /** column 휴일정상근무배율 : pubcHodyNorDutyMgftn */
//
//        private TextField<String> pubcHodyNorDutySum;   /** column 휴일정상근무금액 : pubcHodyNorDutySum */
//
//        private TextField<String> pubcHodyExtnnMgftn;   /** column 휴일연장근무배율 : pubcHodyExtnnMgftn */
//
//        private TextField<String> pubcHodyExtnnSum;   /** column 휴일연장근무금액 : pubcHodyExtnnSum */
//
//        private TextField<String> payDutyTmCalcSeilNum;   /** column 급여근무시간계산일련번호 : payDutyTmCalcSeilNum */
//
//        private TextField<String> workBusinNum;   /** column 근로사업번호 : workBusinNum */
//
//        private TextField<String> workUntBusinNum;   /** column 근로사업_단위사업번호 : workUntBusinNum */
//
//        private TextField<String> mangeUntBusinNum;   /** column 관리부서_단위사업번호 : mangeUntBusinNum */
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