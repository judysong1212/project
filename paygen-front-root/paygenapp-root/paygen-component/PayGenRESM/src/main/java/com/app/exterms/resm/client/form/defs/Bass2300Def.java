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
import com.app.exterms.resm.client.dto.Bass2300BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2300Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2300Def(){
    	  
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
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업_세부직종코드 : busnDtlTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업_세부직종코드", Bass2300BM.ATTR_BUSNDTLTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종명 : busnDtlTypOccuNm */
        listColumnDefs.add(new ColumnDef("사업세부직종명", Bass2300BM.ATTR_BUSNDTLTYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종일근무시간 : busnDtlTypOccuDayDys */
        listColumnDefs.add(new ColumnDef("사업세부직종일근무시간", Bass2300BM.ATTR_BUSNDTLTYPOCCUDAYDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종주근무시간 : busnDtlTypOccuMnDys */
        listColumnDefs.add(new ColumnDef("사업세부직종주근무시간", Bass2300BM.ATTR_BUSNDTLTYPOCCUMNDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
        listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", Bass2300BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종단가금액 : busnDtlTypOccuUcstSum */
        listColumnDefs.add(new ColumnDef("사업세부직종단가금액", Bass2300BM.ATTR_BUSNDTLTYPOCCUUCSTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종시작일자 : busnDtlTypOccuBgnnDt */
        listColumnDefs.add(new ColumnDef("사업세부직종시작일자", Bass2300BM.ATTR_BUSNDTLTYPOCCUBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종종료일자 : busnDtlTypOccuEndDt */
        listColumnDefs.add(new ColumnDef("사업세부직종종료일자", Bass2300BM.ATTR_BUSNDTLTYPOCCUENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Bass2300BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Bass2300BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종직군구분코드 : busnDtlTypOccuJbfmlCd */
        listColumnDefs.add(new ColumnDef("사업세부직종직군구분코드", Bass2300BM.ATTR_BUSNDTLTYPOCCUJBFMLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업세부직종구분비고내용 : busnDtlTypOccuSeptCtnt */
        listColumnDefs.add(new ColumnDef("사업세부직종구분비고내용", Bass2300BM.ATTR_BUSNDTLTYPOCCUSEPTCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류코드 : busnTypOccuCifiCd */
        listColumnDefs.add(new ColumnDef("사업직종분류코드", Bass2300BM.ATTR_BUSNTYPOCCUCIFICD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
        listColumnDefs.add(new ColumnDef("사업직종분류유사코드", Bass2300BM.ATTR_BUSNTYPOCCUCIFISMLRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> busnDtlTypOccuCd;   /** column 사업_세부직종코드 : busnDtlTypOccuCd */
//
//        private TextField<String> busnDtlTypOccuNm;   /** column 사업세부직종명 : busnDtlTypOccuNm */
//
//        private TextField<String> busnDtlTypOccuDayDys;   /** column 사업세부직종일근무시간 : busnDtlTypOccuDayDys */
//
//        private TextField<String> busnDtlTypOccuMnDys;   /** column 사업세부직종주근무시간 : busnDtlTypOccuMnDys */
//
//        private TextField<String> dtilOcclsApptnUcstCd;   /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
//
//        private TextField<String> busnDtlTypOccuUcstSum;   /** column 사업세부직종단가금액 : busnDtlTypOccuUcstSum */
//
//        private TextField<String> busnDtlTypOccuBgnnDt;   /** column 사업세부직종시작일자 : busnDtlTypOccuBgnnDt */
//
//        private TextField<String> busnDtlTypOccuEndDt;   /** column 사업세부직종종료일자 : busnDtlTypOccuEndDt */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> busnDtlTypOccuJbfmlCd;   /** column 사업세부직종직군구분코드 : busnDtlTypOccuJbfmlCd */
//
//        private TextField<String> busnDtlTypOccuSeptCtnt;   /** column 사업세부직종구분비고내용 : busnDtlTypOccuSeptCtnt */
//
//        private TextField<String> busnTypOccuCifiCd;   /** column 사업직종분류코드 : busnTypOccuCifiCd */
//
//        private TextField<String> busnTypOccuCifiSmlrCd;   /** column 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
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
