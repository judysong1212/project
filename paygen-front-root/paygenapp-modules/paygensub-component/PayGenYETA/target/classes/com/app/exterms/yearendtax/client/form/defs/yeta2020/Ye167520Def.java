package com.app.exterms.yearendtax.client.form.defs.yeta2020;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye167520BM;
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

public class Ye167520Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167520Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye167520BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등소득공제상세일련번호 : crdcSeilNum */
        listColumnDefs.add(new ColumnDef("신용카드등소득공제상세일련번호", Ye167520BM.ATTR_CRDCSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167520BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자내외국인 : nnfCl */
        listColumnDefs.add(new ColumnDef("공제대상자내외국인", Ye167520BM.ATTR_NNFCL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자관계 : suptFmlyRltCl */
        listColumnDefs.add(new ColumnDef("공제대상자관계", Ye167520BM.ATTR_SUPTFMLYRLTCL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자성명 : suptFmlyFnm */
        listColumnDefs.add(new ColumnDef("공제대상자성명", Ye167520BM.ATTR_SUPTFMLYFNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자생년월일 : suptFmlyBhdt */
        listColumnDefs.add(new ColumnDef("공제대상자생년월일", Ye167520BM.ATTR_SUPTFMLYBHDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자가족주민등록번호 : famResnoEncCntn */
        listColumnDefs.add(new ColumnDef("공제대상자가족주민등록번호", Ye167520BM.ATTR_FAMRESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 자료구분 : dataCd */
        listColumnDefs.add(new ColumnDef("자료구분", Ye167520BM.ATTR_DATACD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액소계 : crdcUseAmtSum */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액소계", Ye167520BM.ATTR_CRDCUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_신용카드 : crdcUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_신용카드", Ye167520BM.ATTR_CRDCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_현금영수증 : cshptUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_현금영수증", Ye167520BM.ATTR_CSHPTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_직불선불카등등", Ye167520BM.ATTR_DRTPCARDUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_전통시장사용분", Ye167520BM.ATTR_TDMRUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_대중교통이용분 : etcUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_대중교통이용분", Ye167520BM.ATTR_ETCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167520BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속년도 : yrtxBlggYr */
//
//        private TextField<String> crdcSeilNum;   /** column 신용카드등소득공제상세일련번호 : crdcSeilNum */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> nnfCl;   /** column 공제대상자내외국인 : nnfCl */
//
//        private TextField<String> suptFmlyRltCl;   /** column 공제대상자관계 : suptFmlyRltCl */
//
//        private TextField<String> suptFmlyFnm;   /** column 공제대상자성명 : suptFmlyFnm */
//
//        private TextField<String> suptFmlyBhdt;   /** column 공제대상자생년월일 : suptFmlyBhdt */
//
//        private TextField<String> famResnoEncCntn;   /** column 공제대상자가족주민등록번호 : famResnoEncCntn */
//
//        private TextField<String> dataCd;   /** column 자료구분 : dataCd */
//
//        private TextField<String> crdcUseAmtSum;   /** column 신용카드등사용금액소계 : crdcUseAmtSum */
//
//        private TextField<String> crdcUseAmt;   /** column 신용카드등사용금액_신용카드 : crdcUseAmt */
//
//        private TextField<String> cshptUseAmt;   /** column 신용카드등사용금액_현금영수증 : cshptUseAmt */
//
//        private TextField<String> drtpCardUseAmt;   /** column 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
//
//        private TextField<String> tdmrUseAmt;   /** column 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
//
//        private TextField<String> etcUseAmt;   /** column 신용카드등사용금액_대중교통이용분 : etcUseAmt */
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
  