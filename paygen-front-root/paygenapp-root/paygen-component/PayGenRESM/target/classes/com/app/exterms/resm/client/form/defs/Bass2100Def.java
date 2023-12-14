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
import com.app.exterms.resm.client.dto.Bass2100BM;
import com.app.exterms.resm.client.languages.ResmConstants;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass2100Def extends TableDef implements ResmDaoConstants {
    private int row = 0;
    
    private ResmConstants lblBasisConst = ResmConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass2100Def(){
    	  
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
        listColumnDefs.add(new ColumnDef("사업장코드", Bass2100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류코드 : busnTypOccuCifiCd */
        listColumnDefs.add(new ColumnDef("사업직종분류코드", Bass2100BM.ATTR_BUSNTYPOCCUCIFICD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업분류명 : busnCifiNm */
        listColumnDefs.add(new ColumnDef("사업분류명", Bass2100BM.ATTR_BUSNCIFINM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
        listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", Bass2100BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류단가금액 : busnTypOccuCifiUcstSum */
        listColumnDefs.add(new ColumnDef("사업직종분류단가금액", Bass2100BM.ATTR_BUSNTYPOCCUCIFIUCSTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류직군코드 : busnTypOccuCifiJbfmlCd */
        listColumnDefs.add(new ColumnDef("사업직종분류직군코드", Bass2100BM.ATTR_BUSNTYPOCCUCIFIJBFMLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류시작일자 : busnTypOccuCifiBgnnDt */
        listColumnDefs.add(new ColumnDef("사업직종분류시작일자", Bass2100BM.ATTR_BUSNTYPOCCUCIFIBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류종료일자 : busnTypOccuCifiEndDt */
        listColumnDefs.add(new ColumnDef("사업직종분류종료일자", Bass2100BM.ATTR_BUSNTYPOCCUCIFIENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업직종분류사용여부 : busnTypOccuCifiUseYn */
        listColumnDefs.add(new ColumnDef("사업직종분류사용여부", Bass2100BM.ATTR_BUSNTYPOCCUCIFIUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직종분류비고내용 : dpobTypOccuCifiCtnt */
        listColumnDefs.add(new ColumnDef("사업장직종분류비고내용", Bass2100BM.ATTR_DPOBTYPOCCUCIFICTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Bass2100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bass2100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bass2100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bass2100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bass2100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bass2100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Bass2100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> busnTypOccuCifiCd;   /** column 사업직종분류코드 : busnTypOccuCifiCd */
//
//        private TextField<String> busnCifiNm;   /** column 사업분류명 : busnCifiNm */
//
//        private TextField<String> dtilOcclsApptnUcstCd;   /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
//
//        private TextField<String> busnTypOccuCifiUcstSum;   /** column 사업직종분류단가금액 : busnTypOccuCifiUcstSum */
//
//        private TextField<String> busnTypOccuCifiJbfmlCd;   /** column 사업직종분류직군코드 : busnTypOccuCifiJbfmlCd */
//
//        private TextField<String> busnTypOccuCifiBgnnDt;   /** column 사업직종분류시작일자 : busnTypOccuCifiBgnnDt */
//
//        private TextField<String> busnTypOccuCifiEndDt;   /** column 사업직종분류종료일자 : busnTypOccuCifiEndDt */
//
//        private TextField<String> busnTypOccuCifiUseYn;   /** column 사업직종분류사용여부 : busnTypOccuCifiUseYn */
//
//        private TextField<String> dpobTypOccuCifiCtnt;   /** column 사업장직종분류비고내용 : dpobTypOccuCifiCtnt */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
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
