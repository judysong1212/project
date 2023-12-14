package com.app.exterms.yearendtax.client.form.defs.yeta2023;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.Ye167230BM;
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

public class Ye167230Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167230Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167230BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye167230BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167230BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167230BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대주주민등록번호 : txprDscmNoEncCntn */
        listColumnDefs.add(new ColumnDef("대주주민등록번호", Ye167230BM.ATTR_TXPRDSCMNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차계약시작일자 : ctrTermStrDt */
        listColumnDefs.add(new ColumnDef("금전소비대차계약시작일자", Ye167230BM.ATTR_CTRTERMSTRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대주성명 : lsorFnm */
        listColumnDefs.add(new ColumnDef("대주성명", Ye167230BM.ATTR_LSORFNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차계약종료일자 : ctrTermEndDt */
        listColumnDefs.add(new ColumnDef("금전소비대차계약종료일자", Ye167230BM.ATTR_CTRTERMENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 차입금이자율 : lnpbIntrt */
        listColumnDefs.add(new ColumnDef("차입금이자율", Ye167230BM.ATTR_LNPBINTRT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 원리금상환액계 : amt */
        listColumnDefs.add(new ColumnDef("원리금상환액계", Ye167230BM.ATTR_AMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 원리금상환액원금 : pnamt */
        listColumnDefs.add(new ColumnDef("원리금상환액원금", Ye167230BM.ATTR_PNAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 원리금상환액이자 : intrAmt */
        listColumnDefs.add(new ColumnDef("원리금상환액이자", Ye167230BM.ATTR_INTRAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차공제금액 : ddcAmt */
        listColumnDefs.add(new ColumnDef("금전소비대차공제금액", Ye167230BM.ATTR_DDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167230BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167230BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167230BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167230BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167230BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167230BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> txprDscmNoEncCntn;   /** column 대주주민등록번호 : txprDscmNoEncCntn */
//
//        private TextField<String> ctrTermStrDt;   /** column 금전소비대차계약시작일자 : ctrTermStrDt */
//
//        private TextField<String> lsorFnm;   /** column 대주성명 : lsorFnm */
//
//        private TextField<String> ctrTermEndDt;   /** column 금전소비대차계약종료일자 : ctrTermEndDt */
//
//        private TextField<String> lnpbIntrt;   /** column 차입금이자율 : lnpbIntrt */
//
//        private TextField<String> amt;   /** column 원리금상환액계 : amt */
//
//        private TextField<String> pnamt;   /** column 원리금상환액원금 : pnamt */
//
//        private TextField<String> intrAmt;   /** column 원리금상환액이자 : intrAmt */
//
//        private TextField<String> ddcAmt;   /** column 금전소비대차공제금액 : ddcAmt */
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
  