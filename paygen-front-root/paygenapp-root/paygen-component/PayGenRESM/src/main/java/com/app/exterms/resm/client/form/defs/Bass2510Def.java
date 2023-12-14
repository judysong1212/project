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
import com.app.exterms.resm.client.dto.Bass2510BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2510Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2510Def(){
    	  
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
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2510BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무구분코드 : dutyDivCd */
        listColumnDefs.add(new ColumnDef("근무구분코드", Bass2510BM.ATTR_DUTYDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 설정통합구분값 : stpInttnSeptVal */
        listColumnDefs.add(new ColumnDef("설정통합구분값", Bass2510BM.ATTR_STPINTTNSEPTVAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대근무구분코드 : rotaDutyDivCd */
        listColumnDefs.add(new ColumnDef("교대근무구분코드", Bass2510BM.ATTR_ROTADUTYDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대근무시작시간 : rotaDutyBgnnTm */
        listColumnDefs.add(new ColumnDef("교대근무시작시간", Bass2510BM.ATTR_ROTADUTYBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대근무종료시간 : rotaDutyEndTm */
        listColumnDefs.add(new ColumnDef("교대근무종료시간", Bass2510BM.ATTR_ROTADUTYENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대근무시간수 : rotaDutyTmNum */
        listColumnDefs.add(new ColumnDef("교대근무시간수", Bass2510BM.ATTR_ROTADUTYTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교대근무제외시간수 : rotaDutyEepnTmNum */
        listColumnDefs.add(new ColumnDef("교대근무제외시간수", Bass2510BM.ATTR_ROTADUTYEEPNTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교대연장근무시작시간 : extnnDutyBgnnTm */
        listColumnDefs.add(new ColumnDef("교대연장근무시작시간", Bass2510BM.ATTR_EXTNNDUTYBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대연장근무종료시간 : extnnDutyEndTm */
        listColumnDefs.add(new ColumnDef("교대연장근무종료시간", Bass2510BM.ATTR_EXTNNDUTYENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대연장제외시간수 : rotaExtnnEepnTmNum */
        listColumnDefs.add(new ColumnDef("교대연장제외시간수", Bass2510BM.ATTR_ROTAEXTNNEEPNTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교대야간근무시작시간 : ngtDutyBgnnTm */
        listColumnDefs.add(new ColumnDef("교대야간근무시작시간", Bass2510BM.ATTR_NGTDUTYBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대야간근무종료시간 : ngtDutyEndTm */
        listColumnDefs.add(new ColumnDef("교대야간근무종료시간", Bass2510BM.ATTR_NGTDUTYENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교대야간근무제외시간수 : rotaNgtEepnTmNum */
        listColumnDefs.add(new ColumnDef("교대야간근무제외시간수", Bass2510BM.ATTR_ROTANGTEEPNTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2510BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2510BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2510BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2510BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2510BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2510BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> dutyDivCd;   /** column 근무구분코드 : dutyDivCd */
//
//        private TextField<String> stpInttnSeptVal;   /** column 설정통합구분값 : stpInttnSeptVal */
//
//        private TextField<String> rotaDutyDivCd;   /** column 교대근무구분코드 : rotaDutyDivCd */
//
//        private TextField<String> rotaDutyBgnnTm;   /** column 교대근무시작시간 : rotaDutyBgnnTm */
//
//        private TextField<String> rotaDutyEndTm;   /** column 교대근무종료시간 : rotaDutyEndTm */
//
//        private TextField<String> rotaDutyTmNum;   /** column 교대근무시간수 : rotaDutyTmNum */
//
//        private TextField<String> rotaDutyEepnTmNum;   /** column 교대근무제외시간수 : rotaDutyEepnTmNum */
//
//        private TextField<String> extnnDutyBgnnTm;   /** column 교대연장근무시작시간 : extnnDutyBgnnTm */
//
//        private TextField<String> extnnDutyEndTm;   /** column 교대연장근무종료시간 : extnnDutyEndTm */
//
//        private TextField<String> rotaExtnnEepnTmNum;   /** column 교대연장제외시간수 : rotaExtnnEepnTmNum */
//
//        private TextField<String> ngtDutyBgnnTm;   /** column 교대야간근무시작시간 : ngtDutyBgnnTm */
//
//        private TextField<String> ngtDutyEndTm;   /** column 교대야간근무종료시간 : ngtDutyEndTm */
//
//        private TextField<String> rotaNgtEepnTmNum;   /** column 교대야간근무제외시간수 : rotaNgtEepnTmNum */
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
