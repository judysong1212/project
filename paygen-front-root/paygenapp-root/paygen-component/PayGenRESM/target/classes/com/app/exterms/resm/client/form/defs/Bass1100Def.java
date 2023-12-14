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
import com.app.exterms.resm.client.dto.Bass1100BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass1100Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass1100Def(){
    	  
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
        listColumnDefs.add(new ColumnDef("사업장코드", Bass1100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 설정통합구분값 : stpInttnSeptVal */
        listColumnDefs.add(new ColumnDef("설정통합구분값", Bass1100BM.ATTR_STPINTTNSEPTVAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Bass1100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일정상근무시간수 : wkdyNorDutyTmNum */
        listColumnDefs.add(new ColumnDef("평일정상근무시간수", Bass1100BM.ATTR_WKDYNORDUTYTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일근무주근무시간수 : wkdyMnDutyTmNum */
        listColumnDefs.add(new ColumnDef("평일근무주근무시간수", Bass1100BM.ATTR_WKDYMNDUTYTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일근무월통상기준시간수 : wkdyMnthStdTmNum */
        listColumnDefs.add(new ColumnDef("평일근무월통상기준시간수", Bass1100BM.ATTR_WKDYMNTHSTDTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 평일연장근무한도시간수 : wkdyExtnnBudTmNum */
        listColumnDefs.add(new ColumnDef("평일연장근무한도시간수", Bass1100BM.ATTR_WKDYEXTNNBUDTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일정상근무시간수 : pubcHodyNorDutyTmNum */
        listColumnDefs.add(new ColumnDef("휴일정상근무시간수", Bass1100BM.ATTR_PUBCHODYNORDUTYTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일근무일기준시간수 : pubcHodyDayStdTmNum */
        listColumnDefs.add(new ColumnDef("휴일근무일기준시간수", Bass1100BM.ATTR_PUBCHODYDAYSTDTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일근무월한도일수 : pubcHodyMnthBudNumDys */
        listColumnDefs.add(new ColumnDef("휴일근무월한도일수", Bass1100BM.ATTR_PUBCHODYMNTHBUDNUMDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일근무월한도시간수 : pubcHodyMnthBudTmNum */
        listColumnDefs.add(new ColumnDef("휴일근무월한도시간수", Bass1100BM.ATTR_PUBCHODYMNTHBUDTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Bass1100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : deptCd */
        listColumnDefs.add(new ColumnDef("null", Bass1100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Bass1100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Bass1100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 복무근무시간설정일련번호 : servcDutyTmStpSeilNum */
        listColumnDefs.add(new ColumnDef("복무근무시간설정일련번호", Bass1100BM.ATTR_SERVCDUTYTMSTPSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass1100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass1100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass1100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass1100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass1100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass1100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> stpInttnSeptVal;   /** column 설정통합구분값 : stpInttnSeptVal */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> wkdyNorDutyTmNum;   /** column 평일정상근무시간수 : wkdyNorDutyTmNum */
//
//        private TextField<String> wkdyMnDutyTmNum;   /** column 평일근무주근무시간수 : wkdyMnDutyTmNum */
//
//        private TextField<String> wkdyMnthStdTmNum;   /** column 평일근무월통상기준시간수 : wkdyMnthStdTmNum */
//
//        private TextField<String> wkdyExtnnBudTmNum;   /** column 평일연장근무한도시간수 : wkdyExtnnBudTmNum */
//
//        private TextField<String> pubcHodyNorDutyTmNum;   /** column 휴일정상근무시간수 : pubcHodyNorDutyTmNum */
//
//        private TextField<String> pubcHodyDayStdTmNum;   /** column 휴일근무일기준시간수 : pubcHodyDayStdTmNum */
//
//        private TextField<String> pubcHodyMnthBudNumDys;   /** column 휴일근무월한도일수 : pubcHodyMnthBudNumDys */
//
//        private TextField<String> pubcHodyMnthBudTmNum;   /** column 휴일근무월한도시간수 : pubcHodyMnthBudTmNum */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> deptCd;   /** column null : deptCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> servcDutyTmStpSeilNum;   /** column 복무근무시간설정일련번호 : servcDutyTmStpSeilNum */
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
