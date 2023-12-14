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
import com.app.exterms.resm.client.dto.Bass2000BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2000Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2000Def(){
    	  
    	  sysComBass0300Dto = new PrgmComBass0300DTO();
    	 
    	  setTitle("");
          setDaoClass(CLASS_BASS0200_LIST); 
          setCustomListMethod(CLASS_BASS0200_LIST);
          setAutoFillGrid(true);
          setShowFilterToolbar(false);
         // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true);
           
     //     addColumnFilter("pubcHodyCtnt", "", SimpleColumnFilter.OPERATOR_LIKE); 
		    
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         


/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Bass2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업번호 : workBusinNum */
listColumnDefs.add(new ColumnDef("근로사업번호", Bass2000BM.ATTR_WORKBUSINNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업생성년도 : workBusinCretnYr */
listColumnDefs.add(new ColumnDef("근로사업생성년도", Bass2000BM.ATTR_WORKBUSINCRETNYR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업구분코드 : workBusinDivCd */
listColumnDefs.add(new ColumnDef("근로사업구분코드", Bass2000BM.ATTR_WORKBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업단계구분코드 : workBusinStgeDivCd */
listColumnDefs.add(new ColumnDef("근로사업단계구분코드", Bass2000BM.ATTR_WORKBUSINSTGEDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업시작일자 : workBusinBgnnDt */
listColumnDefs.add(new ColumnDef("근로사업시작일자", Bass2000BM.ATTR_WORKBUSINBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업종료일자 : workBusinEndDt */
listColumnDefs.add(new ColumnDef("근로사업종료일자", Bass2000BM.ATTR_WORKBUSINENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업사용여부 : workBusinUseYn */
listColumnDefs.add(new ColumnDef("근로사업사용여부", Bass2000BM.ATTR_WORKBUSINUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 근로사업비고내용 : workBusinCtnt */
listColumnDefs.add(new ColumnDef("근로사업비고내용", Bass2000BM.ATTR_WORKBUSINCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력자 : kybdr */
listColumnDefs.add(new ColumnDef("입력자", Bass2000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력일자 : inptDt */
listColumnDefs.add(new ColumnDef("입력일자", Bass2000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력주소 : inptAddr */
listColumnDefs.add(new ColumnDef("입력주소", Bass2000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정자 : ismt */
listColumnDefs.add(new ColumnDef("수정자", Bass2000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정일자 : revnDt */
listColumnDefs.add(new ColumnDef("수정일자", Bass2000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정주소 : revnAddr */
listColumnDefs.add(new ColumnDef("수정주소", Bass2000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});

//private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//private TextField<String> workBusinNum;   /** column 근로사업번호 : workBusinNum */
//
//private TextField<String> workBusinCretnYr;   /** column 근로사업생성년도 : workBusinCretnYr */
//
//private TextField<String> workBusinDivCd;   /** column 근로사업구분코드 : workBusinDivCd */
//
//private TextField<String> workBusinStgeDivCd;   /** column 근로사업단계구분코드 : workBusinStgeDivCd */
//
//private TextField<String> workBusinBgnnDt;   /** column 근로사업시작일자 : workBusinBgnnDt */
//
//private TextField<String> workBusinEndDt;   /** column 근로사업종료일자 : workBusinEndDt */
//
//private TextField<String> workBusinUseYn;   /** column 근로사업사용여부 : workBusinUseYn */
//
//private TextField<String> workBusinCtnt;   /** column 근로사업비고내용 : workBusinCtnt */
//
//private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//private TextField<String> ismt;   /** column 수정자 : ismt */
//
//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
        return listColumnDefs;
    }
}
