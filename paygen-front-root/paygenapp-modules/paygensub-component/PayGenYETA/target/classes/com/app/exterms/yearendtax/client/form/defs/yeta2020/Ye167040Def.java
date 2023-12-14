package com.app.exterms.yearendtax.client.form.defs.yeta2020;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye167040BM;
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

public class Ye167040Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167040Def(String chkPayrDef){
 
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


        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167040BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167040BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167040BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167040BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료_종근무지보험료금액", Ye167040BM.ATTR_NPHTHRWAINFEEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료_종근무지보험료공제액", Ye167040BM.ATTR_NPHTHRWAINFEEDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료_주근무지보험료금액", Ye167040BM.ATTR_NPHTHRMCURWKARINFEEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료_주근무지보험료공제액", Ye167040BM.ATTR_NPHTHRMCURWKARDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료외_공적연금종근무지보험료금액", Ye167040BM.ATTR_HTHRPBLCPNSNINFEEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료외_공적연금종근무지보험료공제액", Ye167040BM.ATTR_HTHRPBLCPNSNINFEEDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료외_공적연금주근무지보험료금액", Ye167040BM.ATTR_MCURPBLCPNSNINFEEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
        listColumnDefs.add(new ColumnDef("국민연금보험료외_공적연금주근무지보험료공제액", Ye167040BM.ATTR_MCURPBLCPNSNINFEEDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
        listColumnDefs.add(new ColumnDef("연금보험료보험료합계", Ye167040BM.ATTR_PNSNINFEEUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
        listColumnDefs.add(new ColumnDef("연금보험료공제액합계", Ye167040BM.ATTR_PNSNINFEEDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167040BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167040BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167040BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167040BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167040BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167040BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> npHthrWaInfeeAmt;   /** column 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
//
//        private TextField<String> npHthrWaInfeeDdcAmt;   /** column 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
//
//        private TextField<String> npHthrMcurWkarInfeeAmt;   /** column 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
//
//        private TextField<String> npHthrMcurWkarDdcAmt;   /** column 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
//
//        private TextField<String> hthrPblcPnsnInfeeAmt;   /** column 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
//
//        private TextField<String> hthrPblcPnsnInfeeDdcAmt;   /** column 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
//
//        private TextField<String> mcurPblcPnsnInfeeAmt;   /** column 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
//
//        private TextField<String> mcurPblcPnsnInfeeDdcAmt;   /** column 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
//
//        private TextField<String> pnsnInfeeUseAmtSum;   /** column 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
//
//        private TextField<String> pnsnInfeeDdcAmtSum;   /** column 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
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
 
 
