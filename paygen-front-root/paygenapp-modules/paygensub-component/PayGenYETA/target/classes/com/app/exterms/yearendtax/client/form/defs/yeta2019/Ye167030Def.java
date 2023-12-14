package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye167030BM;
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

public class Ye167030Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167030Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167030BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167030BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167030BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167030BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제명세자료구분 : cdVvalKrnNm */
        listColumnDefs.add(new ColumnDef("소득공제명세자료구분", Ye167030BM.ATTR_CDVVALKRNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강고용등보험료 : hifeDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("건강고용등보험료", Ye167030BM.ATTR_HIFEDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보장성보험료 : cvrgInscDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("보장성보험료", Ye167030BM.ATTR_CVRGINSCDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인전용보장성 : dsbrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("장애인전용보장성", Ye167030BM.ATTR_DSBRDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비 : mdxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("의료비", Ye167030BM.ATTR_MDXPSDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비 : scxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비", Ye167030BM.ATTR_SCXPSDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드_전통대중제외 : crdcDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("신용카드_전통대중제외", Ye167030BM.ATTR_CRDCDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드등_전통대중제외 : drtpCardDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("직불카드등_전통대중제외", Ye167030BM.ATTR_DRTPCARDDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 현금영수증_전통대중제외 : cshptDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("현금영수증_전통대중제외", Ye167030BM.ATTR_CSHPTDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시작사용액 : tdmrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("전통시작사용액", Ye167030BM.ATTR_TDMRDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통이용액 : pbtDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용액", Ye167030BM.ATTR_PBTDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금 : conbDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금", Ye167030BM.ATTR_CONBDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167030BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167030BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167030BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167030BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167030BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167030BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> cdVvalKrnNm;   /** column 소득공제명세자료구분 : cdVvalKrnNm */
//
//        private TextField<String> hifeDdcTrgtAmt;   /** column 건강고용등보험료 : hifeDdcTrgtAmt */
//
//        private TextField<String> cvrgInscDdcTrgtAmt;   /** column 보장성보험료 : cvrgInscDdcTrgtAmt */
//
//        private TextField<String> dsbrDdcTrgtAmt;   /** column 장애인전용보장성 : dsbrDdcTrgtAmt */
//
//        private TextField<String> mdxpsDdcTrgtAmt;   /** column 의료비 : mdxpsDdcTrgtAmt */
//
//        private TextField<String> scxpsDdcTrgtAmt;   /** column 교육비 : scxpsDdcTrgtAmt */
//
//        private TextField<String> crdcDdcTrgtAmt;   /** column 신용카드_전통대중제외 : crdcDdcTrgtAmt */
//
//        private TextField<String> drtpCardDdcTrgtAmt;   /** column 직불카드등_전통대중제외 : drtpCardDdcTrgtAmt */
//
//        private TextField<String> cshptDdcTrgtAmt;   /** column 현금영수증_전통대중제외 : cshptDdcTrgtAmt */
//
//        private TextField<String> tdmrDdcTrgtAmt;   /** column 전통시작사용액 : tdmrDdcTrgtAmt */
//
//        private TextField<String> pbtDdcTrgtAmt;   /** column 대중교통이용액 : pbtDdcTrgtAmt */
//
//        private TextField<String> conbDdcTrgtAmt;   /** column 기부금 : conbDdcTrgtAmt */
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
  
