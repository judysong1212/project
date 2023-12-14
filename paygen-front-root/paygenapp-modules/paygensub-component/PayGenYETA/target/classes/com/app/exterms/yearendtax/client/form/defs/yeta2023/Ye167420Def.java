package com.app.exterms.yearendtax.client.form.defs.yeta2023;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.Ye167420BM;
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
public class Ye167420Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167420Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167420BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167420BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167420BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167420BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금일련번호 : cnbtSeilNum */
        listColumnDefs.add(new ColumnDef("기부금일련번호", Ye167420BM.ATTR_CNBTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부유형 : conbCd */
        listColumnDefs.add(new ColumnDef("기부유형", Ye167420BM.ATTR_CONBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부코드 : conbNm */
        listColumnDefs.add(new ColumnDef("기부코드", Ye167420BM.ATTR_CONBNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자료구분코드 : yrsMateClCd */
        listColumnDefs.add(new ColumnDef("기부자료구분코드", Ye167420BM.ATTR_YRSMATECLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부내용 : dntcntn */
        listColumnDefs.add(new ColumnDef("기부내용", Ye167420BM.ATTR_DNTCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부처_상호명 : coplNm */
        listColumnDefs.add(new ColumnDef("기부처_상호명", Ye167420BM.ATTR_COPLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부처_사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("기부처_사업자등록번호", Ye167420BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자관계코드 : cnbtRltClCd */
        listColumnDefs.add(new ColumnDef("기부자관계코드", Ye167420BM.ATTR_CNBTRLTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자성명 : cnbtFnm */
        listColumnDefs.add(new ColumnDef("기부자성명", Ye167420BM.ATTR_CNBTFNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자_주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("기부자_주민등록번호", Ye167420BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부명세건수 : dntScnt */
        listColumnDefs.add(new ColumnDef("기부명세건수", Ye167420BM.ATTR_DNTSCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부명세합계금액 : useSumAmt */
        listColumnDefs.add(new ColumnDef("기부명세합계금액", Ye167420BM.ATTR_USESUMAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상기부금액 : ddcTrgtConbAmt */
        listColumnDefs.add(new ColumnDef("공제대상기부금액", Ye167420BM.ATTR_DDCTRGTCONBAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부장려금신청금 : conbSumAmt */
        listColumnDefs.add(new ColumnDef("기부장려금신청금", Ye167420BM.ATTR_CONBSUMAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167420BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167420BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167420BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167420BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167420BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167420BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> cnbtSeilNum;   /** column 기부금일련번호 : cnbtSeilNum */
//
//        private TextField<String> conbCd;   /** column 기부유형 : conbCd */
//
//        private TextField<String> conbNm;   /** column 기부코드 : conbNm */
//
//        private TextField<String> yrsMateClCd;   /** column 기부자료구분코드 : yrsMateClCd */
//
//        private TextField<String> dntcntn;   /** column 기부내용 : dntcntn */
//
//        private TextField<String> coplNm;   /** column 기부처_상호명 : coplNm */
//
//        private TextField<String> bsnoEncCntn;   /** column 기부처_사업자등록번호 : bsnoEncCntn */
//
//        private TextField<String> cnbtRltClCd;   /** column 기부자관계코드 : cnbtRltClCd */
//
//        private TextField<String> cnbtFnm;   /** column 기부자성명 : cnbtFnm */
//
//        private TextField<String> resnoEncCntn;   /** column 기부자_주민등록번호 : resnoEncCntn */
//
//        private TextField<String> dntScnt;   /** column 기부명세건수 : dntScnt */
//
//        private TextField<String> useSumAmt;   /** column 기부명세합계금액 : useSumAmt */
//
//        private TextField<String> ddcTrgtConbAmt;   /** column 공제대상기부금액 : ddcTrgtConbAmt */
//
//        private TextField<String> conbSumAmt;   /** column 기부장려금신청금 : conbSumAmt */
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
 
 