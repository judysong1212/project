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
import com.app.exterms.resm.client.dto.Bass2400BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2400Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2400Def(){
    	  
    	  sysComBass0300Dto = new PrgmComBass0300DTO();
    	 
    	  setTitle("");
          setDaoClass(CLASS_BASS0200_LIST); 
          setCustomListMethod(CLASS_BASS0200_LIST);
          setAutoFillGrid(true);
          setShowFilterToolbar(false);
         // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true);
           
  //        addColumnFilter("pubcHodyCtnt", "", SimpleColumnFilter.OPERATOR_LIKE); 
		    
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업_세부직종코드 : busnDtlTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업_세부직종코드", Bass2400BM.ATTR_BUSNDTLTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종세단가적용년도 : busnDtilOccuClsUcstYr */
        listColumnDefs.add(new ColumnDef("사업직종세단가적용년도", Bass2400BM.ATTR_BUSNDTILOCCUCLSUCSTYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Bass2400BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Bass2400BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Bass2400BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 항목명 : itemNm */
        listColumnDefs.add(new ColumnDef("항목명", Bass2400BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Bass2400BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급공제유형코드 : pymtDducFrmCd */
        listColumnDefs.add(new ColumnDef("지급공제유형코드", Bass2400BM.ATTR_PYMTDDUCFRMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급공제율 : pymtDducRate */
        listColumnDefs.add(new ColumnDef("지급공제율", Bass2400BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 지급공제액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("지급공제액", Bass2400BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 과세구분코드 : txtnDivCd */
        listColumnDefs.add(new ColumnDef("과세구분코드", Bass2400BM.ATTR_TXTNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세율 : freeDtyRate */
        listColumnDefs.add(new ColumnDef("비과세율", Bass2400BM.ATTR_FREEDTYRATE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세금액 : freeDtySum */
        listColumnDefs.add(new ColumnDef("비과세금액", Bass2400BM.ATTR_FREEDTYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 1월 : jan */
        listColumnDefs.add(new ColumnDef("1월", Bass2400BM.ATTR_JAN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 2월 : feb */
        listColumnDefs.add(new ColumnDef("2월", Bass2400BM.ATTR_FEB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 3월 : mar */
        listColumnDefs.add(new ColumnDef("3월", Bass2400BM.ATTR_MAR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 4월 : apr */
        listColumnDefs.add(new ColumnDef("4월", Bass2400BM.ATTR_APR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 5월 : may */
        listColumnDefs.add(new ColumnDef("5월", Bass2400BM.ATTR_MAY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 6월 : jun */
        listColumnDefs.add(new ColumnDef("6월", Bass2400BM.ATTR_JUN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 7월 : jul */
        listColumnDefs.add(new ColumnDef("7월", Bass2400BM.ATTR_JUL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 8월 : aug */
        listColumnDefs.add(new ColumnDef("8월", Bass2400BM.ATTR_AUG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 9월 : sep */
        listColumnDefs.add(new ColumnDef("9월", Bass2400BM.ATTR_SEP, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 10월 : oct */
        listColumnDefs.add(new ColumnDef("10월", Bass2400BM.ATTR_OCT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 11월 : nov */
        listColumnDefs.add(new ColumnDef("11월", Bass2400BM.ATTR_NOV, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 12월 : dec */
        listColumnDefs.add(new ColumnDef("12월", Bass2400BM.ATTR_DEC, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정렬순서 : rngeOrd */
        listColumnDefs.add(new ColumnDef("정렬순서", Bass2400BM.ATTR_RNGEORD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목사용여부 : payItemUseYn */
        listColumnDefs.add(new ColumnDef("급여항목사용여부", Bass2400BM.ATTR_PAYITEMUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 항목적용시작일자 : itemApptnBgnnDt */
        listColumnDefs.add(new ColumnDef("항목적용시작일자", Bass2400BM.ATTR_ITEMAPPTNBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 항목적용종료일자 : itemApptnEndDt */
        listColumnDefs.add(new ColumnDef("항목적용종료일자", Bass2400BM.ATTR_ITEMAPPTNENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 일월액구분코드 : dayMnthAmntDivCd */
        listColumnDefs.add(new ColumnDef("일월액구분코드", Bass2400BM.ATTR_DAYMNTHAMNTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 계산기준구분코드 : calcStdDivCd */
        listColumnDefs.add(new ColumnDef("계산기준구분코드", Bass2400BM.ATTR_CALCSTDDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Bass2400BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 통상임금여부 : usalyAmntYn */
        listColumnDefs.add(new ColumnDef("통상임금여부", Bass2400BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상여금여부 : allwBnusAmntYn */
        listColumnDefs.add(new ColumnDef("상여금여부", Bass2400BM.ATTR_ALLWBNUSAMNTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목비고내용 : payItemNoteCtnt */
        listColumnDefs.add(new ColumnDef("급여항목비고내용", Bass2400BM.ATTR_PAYITEMNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 회계처리구분코드 : accPrcsDivCd */
        listColumnDefs.add(new ColumnDef("회계처리구분코드", Bass2400BM.ATTR_ACCPRCSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2400BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2400BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2400BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2400BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2400BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2400BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> busnDtlTypOccuCd;   /** column 사업_세부직종코드 : busnDtlTypOccuCd */
//
//        private TextField<String> busnDtilOccuClsUcstYr;   /** column 사업직종세단가적용년도 : busnDtilOccuClsUcstYr */
//
//        private TextField<String> payItemCd;   /** column 급여항목코드 : payItemCd */
//
//        private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
//
//        private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//        private TextField<String> itemNm;   /** column 항목명 : itemNm */
//
//        private TextField<String> pymtDducDivCd;   /** column 지급공제구분코드 : pymtDducDivCd */
//
//        private TextField<String> pymtDducFrmCd;   /** column 지급공제유형코드 : pymtDducFrmCd */
//
//        private TextField<String> pymtDducRate;   /** column 지급공제율 : pymtDducRate */
//
//        private TextField<String> pymtDducSum;   /** column 지급공제액 : pymtDducSum */
//
//        private TextField<String> txtnDivCd;   /** column 과세구분코드 : txtnDivCd */
//
//        private TextField<String> freeDtyRate;   /** column 비과세율 : freeDtyRate */
//
//        private TextField<String> freeDtySum;   /** column 비과세금액 : freeDtySum */
//
//        private TextField<String> jan;   /** column 1월 : jan */
//
//        private TextField<String> feb;   /** column 2월 : feb */
//
//        private TextField<String> mar;   /** column 3월 : mar */
//
//        private TextField<String> apr;   /** column 4월 : apr */
//
//        private TextField<String> may;   /** column 5월 : may */
//
//        private TextField<String> jun;   /** column 6월 : jun */
//
//        private TextField<String> jul;   /** column 7월 : jul */
//
//        private TextField<String> aug;   /** column 8월 : aug */
//
//        private TextField<String> sep;   /** column 9월 : sep */
//
//        private TextField<String> oct;   /** column 10월 : oct */
//
//        private TextField<String> nov;   /** column 11월 : nov */
//
//        private TextField<String> dec;   /** column 12월 : dec */
//
//        private TextField<String> rngeOrd;   /** column 정렬순서 : rngeOrd */
//
//        private TextField<String> payItemUseYn;   /** column 급여항목사용여부 : payItemUseYn */
//
//        private TextField<String> itemApptnBgnnDt;   /** column 항목적용시작일자 : itemApptnBgnnDt */
//
//        private TextField<String> itemApptnEndDt;   /** column 항목적용종료일자 : itemApptnEndDt */
//
//        private TextField<String> dayMnthAmntDivCd;   /** column 일월액구분코드 : dayMnthAmntDivCd */
//
//        private TextField<String> calcStdDivCd;   /** column 계산기준구분코드 : calcStdDivCd */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> usalyAmntYn;   /** column 통상임금여부 : usalyAmntYn */
//
//        private TextField<String> allwBnusAmntYn;   /** column 상여금여부 : allwBnusAmntYn */
//
//        private TextField<String> payItemNoteCtnt;   /** column 급여항목비고내용 : payItemNoteCtnt */
//
//        private TextField<String> accPrcsDivCd;   /** column 회계처리구분코드 : accPrcsDivCd */
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
