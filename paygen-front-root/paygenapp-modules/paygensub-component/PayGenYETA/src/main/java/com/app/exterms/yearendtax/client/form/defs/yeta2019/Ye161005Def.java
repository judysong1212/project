package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161005BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye161005Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye161005Def(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
//          setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0304ToPayr4420ColumnsList());
          
      }
 
        
    }
     
    private List<ColumnDef> getPayr0304ToPayr4420ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye161005BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
        listColumnDefs.add(new ColumnDef("원천세신고부서코드", Ye161005BM.ATTR_WHDGTXREGRSTDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
        listColumnDefs.add(new ColumnDef("상위원천세신고부서코드", Ye161005BM.ATTR_HHRKWHDGREGRSTDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A3_세무서코드 : txOffcCd */
        listColumnDefs.add(new ColumnDef("A3_세무서코드", Ye161005BM.ATTR_TXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A5_제출자구분 : pentrSeptCd */
        listColumnDefs.add(new ColumnDef("A5_제출자구분", Ye161005BM.ATTR_PENTRSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A6_세무대리인관리번호 : txDeptyMangeNum */
        listColumnDefs.add(new ColumnDef("A6_세무대리인관리번호", Ye161005BM.ATTR_TXDEPTYMANGENUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A7_홈텍스ID : hmtxId */
        listColumnDefs.add(new ColumnDef("A7_홈텍스ID", Ye161005BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A8_세무프로그램코드 : txPgmCd */
        listColumnDefs.add(new ColumnDef("A8_세무프로그램코드", Ye161005BM.ATTR_TXPGMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A9_사업자등록번호 : busoprRgstnum */
        listColumnDefs.add(new ColumnDef("A9_사업자등록번호", Ye161005BM.ATTR_BUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A10_법인_상호명 : corpFmnmNm */
        listColumnDefs.add(new ColumnDef("A10_법인_상호명", Ye161005BM.ATTR_CORPFMNMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A11_담당자부서 : pernChrgDeptNm */
        listColumnDefs.add(new ColumnDef("A11_담당자부서", Ye161005BM.ATTR_PERNCHRGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A12_담당자성명 : pernChrgNm */
        listColumnDefs.add(new ColumnDef("A12_담당자성명", Ye161005BM.ATTR_PERNCHRGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A13_담당자전화번호 : pernChrgPhnNum */
        listColumnDefs.add(new ColumnDef("A13_담당자전화번호", Ye161005BM.ATTR_PERNCHRGPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A15_사용한글코드 : useHanCd */
        listColumnDefs.add(new ColumnDef("A15_사용한글코드", Ye161005BM.ATTR_USEHANCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column B16_제출대상기간코드 : sumtTgtPridCd */
        listColumnDefs.add(new ColumnDef("B16_제출대상기간코드", Ye161005BM.ATTR_SUMTTGTPRIDCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인번호 : corpNum */
        listColumnDefs.add(new ColumnDef("법인번호", Ye161005BM.ATTR_CORPNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자우편번호 : incmPost */
        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Ye161005BM.ATTR_INCMPOST, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자기본주소 : incmAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Ye161005BM.ATTR_INCMADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자상세주소 : incmAdtl */
        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Ye161005BM.ATTR_INCMADTL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161005BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161005BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161005BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161005BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161005BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161005BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> whdgTxRegrstDeptCd;   /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
//
//        private TextField<String> hhrkWhdgRegrstDeptCd;   /** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
//
//        private TextField<String> txOffcCd;   /** column A3_세무서코드 : txOffcCd */
//
//        private TextField<String> pentrSeptCd;   /** column A5_제출자구분 : pentrSeptCd */
//
//        private TextField<String> txDeptyMangeNum;   /** column A6_세무대리인관리번호 : txDeptyMangeNum */
//
//        private TextField<String> hmtxId;   /** column A7_홈텍스ID : hmtxId */
//
//        private TextField<String> txPgmCd;   /** column A8_세무프로그램코드 : txPgmCd */
//
//        private TextField<String> busoprRgstnum;   /** column A9_사업자등록번호 : busoprRgstnum */
//
//        private TextField<String> corpFmnmNm;   /** column A10_법인_상호명 : corpFmnmNm */
//
//        private TextField<String> pernChrgDeptNm;   /** column A11_담당자부서 : pernChrgDeptNm */
//
//        private TextField<String> pernChrgNm;   /** column A12_담당자성명 : pernChrgNm */
//
//        private TextField<String> pernChrgPhnNum;   /** column A13_담당자전화번호 : pernChrgPhnNum */
//
//        private TextField<String> useHanCd;   /** column A15_사용한글코드 : useHanCd */
//
//        private TextField<String> sumtTgtPridCd;   /** column B16_제출대상기간코드 : sumtTgtPridCd */
//
//        private TextField<String> corpNum;   /** column 법인번호 : corpNum */
//
//        private TextField<String> incmPost;   /** column 소득신고의무자우편번호 : incmPost */
//
//        private TextField<String> incmAddr;   /** column 소득신고의무자기본주소 : incmAddr */
//
//        private TextField<String> incmAdtl;   /** column 소득신고의무자상세주소 : incmAdtl */
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
  
