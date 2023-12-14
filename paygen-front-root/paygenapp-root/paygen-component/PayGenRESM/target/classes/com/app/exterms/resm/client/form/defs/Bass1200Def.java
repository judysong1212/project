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
import com.app.exterms.resm.client.dto.Bass1200BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass1200Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass1200Def(){
    	  
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
        listColumnDefs.add(new ColumnDef("사업장코드", Bass1200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무구분코드 : dutyDivCd */
        listColumnDefs.add(new ColumnDef("근무구분코드", Bass1200BM.ATTR_DUTYDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 설정통합구분값 : stpInttnSeptVal */
        listColumnDefs.add(new ColumnDef("설정통합구분값", Bass1200BM.ATTR_STPINTTNSEPTVAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 출근기준시간 : gtwkStdTm */
        listColumnDefs.add(new ColumnDef("출근기준시간", Bass1200BM.ATTR_GTWKSTDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴근기준시간 : ofwkStdTm */
        listColumnDefs.add(new ColumnDef("퇴근기준시간", Bass1200BM.ATTR_OFWKSTDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 조기출근시작시간 : eryGtwkBgnnTm */
        listColumnDefs.add(new ColumnDef("조기출근시작시간", Bass1200BM.ATTR_ERYGTWKBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 조기출근종료시간 : eryGtwkEndTm */
        listColumnDefs.add(new ColumnDef("조기출근종료시간", Bass1200BM.ATTR_ERYGTWKENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상오전근무시작시간 : norMogDutyBgnnTm */
        listColumnDefs.add(new ColumnDef("정상오전근무시작시간", Bass1200BM.ATTR_NORMOGDUTYBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상오전근무종료시간 : norMogDutyEndTm */
        listColumnDefs.add(new ColumnDef("정상오전근무종료시간", Bass1200BM.ATTR_NORMOGDUTYENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상근무점심시작시간 : norDutyLuchBgnnTm */
        listColumnDefs.add(new ColumnDef("정상근무점심시작시간", Bass1200BM.ATTR_NORDUTYLUCHBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상근무점심종료시간 : norDutyLuchEndTm */
        listColumnDefs.add(new ColumnDef("정상근무점심종료시간", Bass1200BM.ATTR_NORDUTYLUCHENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상근무오후시작시간 : norDutyAftnBgnnTm */
        listColumnDefs.add(new ColumnDef("정상근무오후시작시간", Bass1200BM.ATTR_NORDUTYAFTNBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상근무오후종료시간 : norDutyAftnEndTm */
        listColumnDefs.add(new ColumnDef("정상근무오후종료시간", Bass1200BM.ATTR_NORDUTYAFTNENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정상근무시간수 : norDutyTmNum */
        listColumnDefs.add(new ColumnDef("정상근무시간수", Bass1200BM.ATTR_NORDUTYTMNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연장저녁시작시간 : extnnEvngBgnnTm */
        listColumnDefs.add(new ColumnDef("연장저녁시작시간", Bass1200BM.ATTR_EXTNNEVNGBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연장저녁종료시간 : extnnEvngEndTm */
        listColumnDefs.add(new ColumnDef("연장저녁종료시간", Bass1200BM.ATTR_EXTNNEVNGENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연장근무시작시간 : extnnDutyBgnnTm */
        listColumnDefs.add(new ColumnDef("연장근무시작시간", Bass1200BM.ATTR_EXTNNDUTYBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연장근무종료시간 : extnnDutyEndTm */
        listColumnDefs.add(new ColumnDef("연장근무종료시간", Bass1200BM.ATTR_EXTNNDUTYENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연장저녁식사포함여부 : extnnEvngMealInsnYn */
        listColumnDefs.add(new ColumnDef("연장저녁식사포함여부", Bass1200BM.ATTR_EXTNNEVNGMEALINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 야간근무시작시간 : ngtDutyBgnnTm */
        listColumnDefs.add(new ColumnDef("야간근무시작시간", Bass1200BM.ATTR_NGTDUTYBGNNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 야간근무종료시간 : ngtDutyEndTm */
        listColumnDefs.add(new ColumnDef("야간근무종료시간", Bass1200BM.ATTR_NGTDUTYENDTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass1200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass1200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass1200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass1200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass1200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass1200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> dutyDivCd;   /** column 근무구분코드 : dutyDivCd */
//
//        private TextField<String> stpInttnSeptVal;   /** column 설정통합구분값 : stpInttnSeptVal */
//
//        private TextField<String> gtwkStdTm;   /** column 출근기준시간 : gtwkStdTm */
//
//        private TextField<String> ofwkStdTm;   /** column 퇴근기준시간 : ofwkStdTm */
//
//        private TextField<String> eryGtwkBgnnTm;   /** column 조기출근시작시간 : eryGtwkBgnnTm */
//
//        private TextField<String> eryGtwkEndTm;   /** column 조기출근종료시간 : eryGtwkEndTm */
//
//        private TextField<String> norMogDutyBgnnTm;   /** column 정상오전근무시작시간 : norMogDutyBgnnTm */
//
//        private TextField<String> norMogDutyEndTm;   /** column 정상오전근무종료시간 : norMogDutyEndTm */
//
//        private TextField<String> norDutyLuchBgnnTm;   /** column 정상근무점심시작시간 : norDutyLuchBgnnTm */
//
//        private TextField<String> norDutyLuchEndTm;   /** column 정상근무점심종료시간 : norDutyLuchEndTm */
//
//        private TextField<String> norDutyAftnBgnnTm;   /** column 정상근무오후시작시간 : norDutyAftnBgnnTm */
//
//        private TextField<String> norDutyAftnEndTm;   /** column 정상근무오후종료시간 : norDutyAftnEndTm */
//
//        private TextField<String> norDutyTmNum;   /** column 정상근무시간수 : norDutyTmNum */
//
//        private TextField<String> extnnEvngBgnnTm;   /** column 연장저녁시작시간 : extnnEvngBgnnTm */
//
//        private TextField<String> extnnEvngEndTm;   /** column 연장저녁종료시간 : extnnEvngEndTm */
//
//        private TextField<String> extnnDutyBgnnTm;   /** column 연장근무시작시간 : extnnDutyBgnnTm */
//
//        private TextField<String> extnnDutyEndTm;   /** column 연장근무종료시간 : extnnDutyEndTm */
//
//        private TextField<String> extnnEvngMealInsnYn;   /** column 연장저녁식사포함여부 : extnnEvngMealInsnYn */
//
//        private TextField<String> ngtDutyBgnnTm;   /** column 야간근무시작시간 : ngtDutyBgnnTm */
//
//        private TextField<String> ngtDutyEndTm;   /** column 야간근무종료시간 : ngtDutyEndTm */
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
