package com.app.exterms.yearendtax.client.form.defs.yeta2022;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.Ye167240BM;
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
public class Ye167240Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167240Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167240BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye167240BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167240BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167240BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호_사업자번호 : xprDscmNoEncCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호_사업자번호", Ye167240BM.ATTR_XPRDSCMNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 계약서상임대차계약기간개시일자 : ctrTermStrtDt */
        listColumnDefs.add(new ColumnDef("계약서상임대차계약기간개시일자", Ye167240BM.ATTR_CTRTERMSTRTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대인성명_상호명 : lsorFnm */
        listColumnDefs.add(new ColumnDef("임대인성명_상호명", Ye167240BM.ATTR_LSORFNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주택유형 : hsngTypeClCd */
        listColumnDefs.add(new ColumnDef("주택유형", Ye167240BM.ATTR_HSNGTYPECLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주택계약면적 : hsngCtrSfl */
        listColumnDefs.add(new ColumnDef("주택계약면적", Ye167240BM.ATTR_HSNGCTRSFL, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차계약서상주소지 : lsrnCtrpAdr */
        listColumnDefs.add(new ColumnDef("임대차계약서상주소지", Ye167240BM.ATTR_LSRNCTRPADR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 계약서상임대차계약기간종료일자 : ctrrTermEndDt */
        listColumnDefs.add(new ColumnDef("계약서상임대차계약기간종료일자", Ye167240BM.ATTR_CTRRTERMENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차계약_전세보증금액 : lfhDpit */
        listColumnDefs.add(new ColumnDef("임대차계약_전세보증금액", Ye167240BM.ATTR_LFHDPIT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167240BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167240BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167240BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167240BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167240BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167240BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속년도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> xprDscmNoEncCntn;   /** column 주민등록번호_사업자번호 : xprDscmNoEncCntn */
//
//        private TextField<String> ctrTermStrtDt;   /** column 계약서상임대차계약기간개시일자 : ctrTermStrtDt */
//
//        private TextField<String> lsorFnm;   /** column 임대인성명_상호명 : lsorFnm */
//
//        private TextField<String> hsngTypeClCd;   /** column 주택유형 : hsngTypeClCd */
//
//        private TextField<String> hsngCtrSfl;   /** column 주택계약면적 : hsngCtrSfl */
//
//        private TextField<String> lsrnCtrpAdr;   /** column 임대차계약서상주소지 : lsrnCtrpAdr */
//
//        private TextField<String> ctrrTermEndDt;   /** column 계약서상임대차계약기간종료일자 : ctrrTermEndDt */
//
//        private TextField<String> lfhDpit;   /** column 임대차계약_전세보증금액 : lfhDpit */
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
 
 