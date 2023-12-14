package com.app.exterms.yearendtax.client.form.defs.yeta2017;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG304yBM;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG304yBM;
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
public class PdfG304yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfG304yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA2200_PDF_G304Y_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          setEditFieldGrid(false);
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0304ToPayr4420ColumnsList());
          
      }
 
        
    }
     
    private List<ColumnDef> getPayr0304ToPayr4420ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", PdfG304yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfG304yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfG304yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfG304yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("pdf 소득공제자료적용여부", PdfG304yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("PDF_소득공제적용일자", PdfG304yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("PDF_소득공제제외사유내용", PdfG304yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드일련번호 : dirCardSeilNum */
        listColumnDefs.add(new ColumnDef("직불카드일련번호", PdfG304yBM.ATTR_DIRCARDSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfG304yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("직불카드주민등록번호", PdfG304yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드성명 : name */
        listColumnDefs.add(new ColumnDef("직불카드성명", PdfG304yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드전전년도일반공제대상금액합계 : ftyrTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드전전년도일반공제대상금액합계", PdfG304yBM.ATTR_FTYRTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드전전년도전통시장공제대상금액합계 : ftyrMarketTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드전전년도전통시장공제대상금액합계", PdfG304yBM.ATTR_FTYRMARKETTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드전전년도대중교통공제대상금액합계 : ftyrTmoneyTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드전전년도대중교통공제대상금액합계", PdfG304yBM.ATTR_FTYRTMONEYTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드직전년도일반공제대상금액합계 : preTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드직전년도일반공제대상금액합계", PdfG304yBM.ATTR_PRETOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드직전년도전통시장공제대상금액합계 : preMarketTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드직전년도전통시장공제대상금액합계", PdfG304yBM.ATTR_PREMARKETTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드직전년도대중교통공제대상금액합계 : preTmoneyTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드직전년도대중교통공제대상금액합계", PdfG304yBM.ATTR_PRETMONEYTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfG304yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드사업자등록번호 : busnid */
        listColumnDefs.add(new ColumnDef("직불카드사업자등록번호", PdfG304yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드상호명 : tradeNm */
        listColumnDefs.add(new ColumnDef("직불카드상호명", PdfG304yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드종류코드 : usePlaceCd */
        listColumnDefs.add(new ColumnDef("직불카드종류코드", PdfG304yBM.ATTR_USEPLACECD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드귀속년도_상_대상금액합계 : firstTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드귀속년도_상_대상금액합계", PdfG304yBM.ATTR_FIRSTTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드귀속년도_하_대상금액합계 : secondTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드귀속년도_하_대상금액합계", PdfG304yBM.ATTR_SECONDTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드귀속년도상반기대상금액합계 : firstYearTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드귀속년도상반기대상금액합계", PdfG304yBM.ATTR_FIRSTYEARTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드귀속년도하반기대상금액합계 : secondYearTotAmt */
        listColumnDefs.add(new ColumnDef("직불카드귀속년도하반기대상금액합계", PdfG304yBM.ATTR_SECONDYEARTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드조회기간시작월 : inqrStrtMm */
        listColumnDefs.add(new ColumnDef("직불카드조회기간시작월", PdfG304yBM.ATTR_INQRSTRTMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드조회기간종료월 : inqrEndMm */
        listColumnDefs.add(new ColumnDef("직불카드조회기간종료월", PdfG304yBM.ATTR_INQRENDMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직불카드공제대상금액합계 : dirCardAmtSum */
        listColumnDefs.add(new ColumnDef("직불카드공제대상금액합계", PdfG304yBM.ATTR_DIRCARDAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfG304yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfG304yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfG304yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfG304yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfG304yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfG304yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
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
//        private TextField<String> dirCardSeilNum;   /** column 직불카드일련번호 : dirCardSeilNum */
//
//        private TextField<String> formCd;   /** column 서식코드 : formCd */
//
//        private TextField<String> resid;   /** column 직불카드주민등록번호 : resid */
//
//        private TextField<String> name;   /** column 직불카드성명 : name */
//
//        private TextField<String> ftyrTotAmt;   /** column 직불카드전전년도일반공제대상금액합계 : ftyrTotAmt */
//
//        private TextField<String> ftyrMarketTotAmt;   /** column 직불카드전전년도전통시장공제대상금액합계 : ftyrMarketTotAmt */
//
//        private TextField<String> ftyrTmoneyTotAmt;   /** column 직불카드전전년도대중교통공제대상금액합계 : ftyrTmoneyTotAmt */
//
//        private TextField<String> preTotAmt;   /** column 직불카드직전년도일반공제대상금액합계 : preTotAmt */
//
//        private TextField<String> preMarketTotAmt;   /** column 직불카드직전년도전통시장공제대상금액합계 : preMarketTotAmt */
//
//        private TextField<String> preTmoneyTotAmt;   /** column 직불카드직전년도대중교통공제대상금액합계 : preTmoneyTotAmt */
//
//        private TextField<String> datCd;   /** column 자료코드 : datCd */
//
//        private TextField<String> busnid;   /** column 직불카드사업자등록번호 : busnid */
//
//        private TextField<String> tradeNm;   /** column 직불카드상호명 : tradeNm */
//
//        private TextField<String> usePlaceCd;   /** column 직불카드종류코드 : usePlaceCd */
//
//        private TextField<String> firstTotAmt;   /** column 직불카드귀속년도_상_대상금액합계 : firstTotAmt */
//
//        private TextField<String> secondTotAmt;   /** column 직불카드귀속년도_하_대상금액합계 : secondTotAmt */
//
//        private TextField<String> firstYearTotAmt;   /** column 직불카드귀속년도상반기대상금액합계 : firstYearTotAmt */
//
//        private TextField<String> secondYearTotAmt;   /** column 직불카드귀속년도하반기대상금액합계 : secondYearTotAmt */
//
//        private TextField<String> inqrStrtMm;   /** column 직불카드조회기간시작월 : inqrStrtMm */
//
//        private TextField<String> inqrEndMm;   /** column 직불카드조회기간종료월 : inqrEndMm */
//
//        private TextField<String> dirCardAmtSum;   /** column 직불카드공제대상금액합계 : dirCardAmtSum */
//
//        private TextField<String> pdfDatAppYn;   /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
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
  