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
import com.app.exterms.resm.client.dto.Bass2600BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2600Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2600Def(){
    	  
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
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2600BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 설정통합구분값 : stpInttnSeptVal */
        listColumnDefs.add(new ColumnDef("설정통합구분값", Bass2600BM.ATTR_STPINTTNSEPTVAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 조기출근집계여부 : eryGtwkTotYn */
        listColumnDefs.add(new ColumnDef("조기출근집계여부", Bass2600BM.ATTR_ERYGTWKTOTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근태공제급여차감여부 : dilnlazDducPaySubtnYn */
        listColumnDefs.add(new ColumnDef("근태공제급여차감여부", Bass2600BM.ATTR_DILNLAZDDUCPAYSUBTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주휴수당처리여부 : wklyHldyExtpyPrcsYn */
        listColumnDefs.add(new ColumnDef("주휴수당처리여부", Bass2600BM.ATTR_WKLYHLDYEXTPYPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일정상근무시간절삭구분코드 : wkdyNorTmCttgDivCd */
        listColumnDefs.add(new ColumnDef("평일정상근무시간절삭구분코드", Bass2600BM.ATTR_WKDYNORTMCTTGDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일연장근무절삭구분코드 : wkdyExtnnCttgDivCd */
        listColumnDefs.add(new ColumnDef("평일연장근무절삭구분코드", Bass2600BM.ATTR_WKDYEXTNNCTTGDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일야간근무절삭구분코드 : wkdyNgtCttgDivCd */
        listColumnDefs.add(new ColumnDef("평일야간근무절삭구분코드", Bass2600BM.ATTR_WKDYNGTCTTGDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일정상근무시간절삭구분코드 : pubcHodyNorTmCttgCd */
        listColumnDefs.add(new ColumnDef("휴일정상근무시간절삭구분코드", Bass2600BM.ATTR_PUBCHODYNORTMCTTGCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일연장근무시간절삭구분코드 : pubcHodyExtnnTmCttgCd */
        listColumnDefs.add(new ColumnDef("휴일연장근무시간절삭구분코드", Bass2600BM.ATTR_PUBCHODYEXTNNTMCTTGCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일정상근무표시구분코드 : wkdyNorDutyMrkDivCd */
        listColumnDefs.add(new ColumnDef("평일정상근무표시구분코드", Bass2600BM.ATTR_WKDYNORDUTYMRKDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일연장근무표시구분코드 : wkdyExtnnMrkDivCd */
        listColumnDefs.add(new ColumnDef("평일연장근무표시구분코드", Bass2600BM.ATTR_WKDYEXTNNMRKDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 평일야간근무표시구분코드 : wkdyNgtMrkDivCd */
        listColumnDefs.add(new ColumnDef("평일야간근무표시구분코드", Bass2600BM.ATTR_WKDYNGTMRKDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일정상근무표시구분코드 : pubcHodyNorMrkDivCd */
        listColumnDefs.add(new ColumnDef("휴일정상근무표시구분코드", Bass2600BM.ATTR_PUBCHODYNORMRKDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일연장근무표시구분코드 : pubcHodyExtnnMrkCd */
        listColumnDefs.add(new ColumnDef("휴일연장근무표시구분코드", Bass2600BM.ATTR_PUBCHODYEXTNNMRKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 휴일야간근무표시구분코드 : pubcHodyNgtMrkDivCd */
        listColumnDefs.add(new ColumnDef("휴일야간근무표시구분코드", Bass2600BM.ATTR_PUBCHODYNGTMRKDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 복무공통설정일련번호 : servcCommSeilNum */
        listColumnDefs.add(new ColumnDef("복무공통설정일련번호", Bass2600BM.ATTR_SERVCCOMMSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업번호 : workBusinNum */
        listColumnDefs.add(new ColumnDef("근로사업번호", Bass2600BM.ATTR_WORKBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근로사업_단위사업번호 : workUntBusinNum */
        listColumnDefs.add(new ColumnDef("근로사업_단위사업번호", Bass2600BM.ATTR_WORKUNTBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관리부서_단위사업번호 : mangeUntBusinNum */
        listColumnDefs.add(new ColumnDef("관리부서_단위사업번호", Bass2600BM.ATTR_MANGEUNTBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2600BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2600BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2600BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2600BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2600BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2600BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> stpInttnSeptVal;   /** column 설정통합구분값 : stpInttnSeptVal */
//
//        private TextField<String> eryGtwkTotYn;   /** column 조기출근집계여부 : eryGtwkTotYn */
//
//        private TextField<String> dilnlazDducPaySubtnYn;   /** column 근태공제급여차감여부 : dilnlazDducPaySubtnYn */
//
//        private TextField<String> wklyHldyExtpyPrcsYn;   /** column 주휴수당처리여부 : wklyHldyExtpyPrcsYn */
//
//        private TextField<String> wkdyNorTmCttgDivCd;   /** column 평일정상근무시간절삭구분코드 : wkdyNorTmCttgDivCd */
//
//        private TextField<String> wkdyExtnnCttgDivCd;   /** column 평일연장근무절삭구분코드 : wkdyExtnnCttgDivCd */
//
//        private TextField<String> wkdyNgtCttgDivCd;   /** column 평일야간근무절삭구분코드 : wkdyNgtCttgDivCd */
//
//        private TextField<String> pubcHodyNorTmCttgCd;   /** column 휴일정상근무시간절삭구분코드 : pubcHodyNorTmCttgCd */
//
//        private TextField<String> pubcHodyExtnnTmCttgCd;   /** column 휴일연장근무시간절삭구분코드 : pubcHodyExtnnTmCttgCd */
//
//        private TextField<String> wkdyNorDutyMrkDivCd;   /** column 평일정상근무표시구분코드 : wkdyNorDutyMrkDivCd */
//
//        private TextField<String> wkdyExtnnMrkDivCd;   /** column 평일연장근무표시구분코드 : wkdyExtnnMrkDivCd */
//
//        private TextField<String> wkdyNgtMrkDivCd;   /** column 평일야간근무표시구분코드 : wkdyNgtMrkDivCd */
//
//        private TextField<String> pubcHodyNorMrkDivCd;   /** column 휴일정상근무표시구분코드 : pubcHodyNorMrkDivCd */
//
//        private TextField<String> pubcHodyExtnnMrkCd;   /** column 휴일연장근무표시구분코드 : pubcHodyExtnnMrkCd */
//
//        private TextField<String> pubcHodyNgtMrkDivCd;   /** column 휴일야간근무표시구분코드 : pubcHodyNgtMrkDivCd */
//
//        private TextField<String> servcCommSeilNum;   /** column 복무공통설정일련번호 : servcCommSeilNum */
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
