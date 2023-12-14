package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161055BM;
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

public class Ye161055Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye161055Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye161055BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye161055BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161055BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161055BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주종근무지구분코드 : piclEmplDivCd */
        listColumnDefs.add(new ColumnDef("주종근무지구분코드", Ye161055BM.ATTR_PICLEMPLDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료금액 : natPennPrmmSum */
        listColumnDefs.add(new ColumnDef("국민연금보험료금액", Ye161055BM.ATTR_NATPENNPRMMSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금지역보험료금액 : natPennAraPrmmSum */
        listColumnDefs.add(new ColumnDef("국민연금지역보험료금액", Ye161055BM.ATTR_NATPENNARAPRMMSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료공제금액 : natPennDducSum */
        listColumnDefs.add(new ColumnDef("국민연금보험료공제금액", Ye161055BM.ATTR_NATPENNDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_공무원연금금액 : puoferAnty */
        listColumnDefs.add(new ColumnDef("공적연금_공무원연금금액", Ye161055BM.ATTR_PUOFERANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
        listColumnDefs.add(new ColumnDef("공적연금_공무원연금공제금액", Ye161055BM.ATTR_PUOFERANTYDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_군인연금금액 : mltymAnty */
        listColumnDefs.add(new ColumnDef("공적연금_군인연금금액", Ye161055BM.ATTR_MLTYMANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
        listColumnDefs.add(new ColumnDef("공적연금_군인연금공제금액", Ye161055BM.ATTR_MLTYMANTYDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
        listColumnDefs.add(new ColumnDef("공적연금_사립학교교직원연금금액", Ye161055BM.ATTR_PRTAFIRSCHLFALYMMANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
        listColumnDefs.add(new ColumnDef("공적연금_사립학교직원연금공제금액", Ye161055BM.ATTR_PRTAFIRSCHLDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
        listColumnDefs.add(new ColumnDef("공적연금_별정우체국연금금액", Ye161055BM.ATTR_SPILDTNPSTOFICANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
        listColumnDefs.add(new ColumnDef("공적연금_별정우체국연금공제금액", Ye161055BM.ATTR_SPILDTNPSTOFICDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161055BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161055BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161055BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161055BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161055BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161055BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> piclEmplDivCd;   /** column 주종근무지구분코드 : piclEmplDivCd */
//
//        private TextField<String> natPennPrmmSum;   /** column 국민연금보험료금액 : natPennPrmmSum */
//
//        private TextField<String> natPennAraPrmmSum;   /** column 국민연금지역보험료금액 : natPennAraPrmmSum */
//
//        private TextField<String> natPennDducSum;   /** column 국민연금보험료공제금액 : natPennDducSum */
//
//        private TextField<String> puoferAnty;   /** column 공적연금_공무원연금금액 : puoferAnty */
//
//        private TextField<String> puoferAntyDducSum;   /** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
//
//        private TextField<String> mltymAnty;   /** column 공적연금_군인연금금액 : mltymAnty */
//
//        private TextField<String> mltymAntyDducSum;   /** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
//
//        private TextField<String> prtafirSchlFalymmAnty;   /** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
//
//        private TextField<String> prtafirSchlDducSum;   /** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
//
//        private TextField<String> spildtnPstoficAnty;   /** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
//
//        private TextField<String> spildtnPstoficDducSum;   /** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
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
 

 
