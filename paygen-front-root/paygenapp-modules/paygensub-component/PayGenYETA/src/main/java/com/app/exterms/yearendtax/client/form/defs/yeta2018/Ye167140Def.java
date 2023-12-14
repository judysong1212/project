package com.app.exterms.yearendtax.client.form.defs.yeta2018;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye167140BM;
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

public class Ye167140Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167140Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167140BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye167140BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167140BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167140BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축구분 : hsngPrptSvngSvngCl */
        listColumnDefs.add(new ColumnDef("주택마련저축구분", Ye167140BM.ATTR_HSNGPRPTSVNGSVNGCL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축가입일자 : jnngDt */
        listColumnDefs.add(new ColumnDef("주택마련저축가입일자", Ye167140BM.ATTR_JNNGDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축금융기관코드 : hsngPrptSvngFnnOrgnCd */
        listColumnDefs.add(new ColumnDef("주택마련저축금융기관코드", Ye167140BM.ATTR_HSNGPRPTSVNGFNNORGNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금융회사등명 : hsngPrptSvngFnnCmp */
        listColumnDefs.add(new ColumnDef("금융회사등명", Ye167140BM.ATTR_HSNGPRPTSVNGFNNCMP, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 계좌번호_증권번호 : hsngPrptSvngAccNo */
        listColumnDefs.add(new ColumnDef("계좌번호_증권번호", Ye167140BM.ATTR_HSNGPRPTSVNGACCNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축납입금액 : hsngPrptSvngPymAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축납입금액", Ye167140BM.ATTR_HSNGPRPTSVNGPYMAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축세액공제금액 : hsngPrptSvngIncDdcAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축세액공제금액", Ye167140BM.ATTR_HSNGPRPTSVNGINCDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167140BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167140BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167140BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167140BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167140BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167140BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> hsngPrptSvngSvngCl;   /** column 주택마련저축구분 : hsngPrptSvngSvngCl */
//
//        private TextField<String> jnngDt;   /** column 주택마련저축가입일자 : jnngDt */
//
//        private TextField<String> hsngPrptSvngFnnOrgnCd;   /** column 주택마련저축금융기관코드 : hsngPrptSvngFnnOrgnCd */
//
//        private TextField<String> hsngPrptSvngFnnCmp;   /** column 금융회사등명 : hsngPrptSvngFnnCmp */
//
//        private TextField<String> hsngPrptSvngAccNo;   /** column 계좌번호_증권번호 : hsngPrptSvngAccNo */
//
//        private TextField<String> hsngPrptSvngPymAmt;   /** column 주택마련저축납입금액 : hsngPrptSvngPymAmt */
//
//        private TextField<String> hsngPrptSvngIncDdcAmt;   /** column 주택마련저축세액공제금액 : hsngPrptSvngIncDdcAmt */
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
 
 
