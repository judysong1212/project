package com.app.exterms.yearendtax.client.form.defs.yeta2021;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye167440BM;
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
public class Ye167440Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167440Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167440BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167440BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167440BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167440BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금조정일련번호 : conbSeilNum */
        listColumnDefs.add(new ColumnDef("기부금조정일련번호", Ye167440BM.ATTR_CONBSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부년도 : attrYr */
        listColumnDefs.add(new ColumnDef("기부년도", Ye167440BM.ATTR_ATTRYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금코드 : conbCddl */
        listColumnDefs.add(new ColumnDef("기부금코드", Ye167440BM.ATTR_CONBCDDL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액 : useAmt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye167440BM.ATTR_USEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전년도공제된금액 : pyrDdcAmt */
        listColumnDefs.add(new ColumnDef("전년도공제된금액", Ye167440BM.ATTR_PYRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금공제대상금액 : ddcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금공제대상금액", Ye167440BM.ATTR_DDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
        listColumnDefs.add(new ColumnDef("해당연도공제금액필요경비", Ye167440BM.ATTR_THCYRDDCAMTNDXPS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
        listColumnDefs.add(new ColumnDef("해당연도공제금액세액공제금액", Ye167440BM.ATTR_THCYRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
        listColumnDefs.add(new ColumnDef("해당연도미공제금액_소멸금액", Ye167440BM.ATTR_THCYRNDUCEXTNAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
        listColumnDefs.add(new ColumnDef("해당연도미공제금액_이월금액", Ye167440BM.ATTR_THCYRNDUCCRFWAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167440BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167440BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167440BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167440BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167440BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167440BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> conbSeilNum;   /** column 기부금조정일련번호 : conbSeilNum */
//
//        private TextField<String> attrYr;   /** column 기부년도 : attrYr */
//
//        private TextField<String> conbCddl;   /** column 기부금코드 : conbCddl */
//
//        private TextField<String> useAmt;   /** column 기부금액 : useAmt */
//
//        private TextField<String> pyrDdcAmt;   /** column 전년도공제된금액 : pyrDdcAmt */
//
//        private TextField<String> ddcTrgtAmt;   /** column 기부금공제대상금액 : ddcTrgtAmt */
//
//        private TextField<String> thcYrDdcAmtNdXps;   /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
//
//        private TextField<String> thcYrDdcAmt;   /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
//
//        private TextField<String> thcYrNducExtnAmt;   /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
//
//        private TextField<String> thcYrNducCrfwAmt;   /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
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
 
 
