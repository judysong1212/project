package com.app.exterms.yearendtax.client.form.defs.yeta2017;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG104yBM;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG104yBM;
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
public class PdfG104yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfG104yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA2200_PDF_G104Y_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          setEditFieldGrid(true);
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0304ToPayr4420ColumnsList());
          
      }
 
        
    }
     
    private List<ColumnDef> getPayr0304ToPayr4420ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", PdfG104yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfG104yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfG104yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfG104yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("소득공제자료적용여부", PdfG104yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfG104yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfG104yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 신용카드일련번호 : cardSeilNum */
        listColumnDefs.add(new ColumnDef("신용카드일련번호", PdfG104yBM.ATTR_CARDSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfG104yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("신용카드주민등록번호", PdfG104yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfG104yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드사업자등록번호 : busnid */
        listColumnDefs.add(new ColumnDef("신용카드사업자등록번호", PdfG104yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드성명 : name */
        listColumnDefs.add(new ColumnDef("신용카드성명", PdfG104yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드상호명 : tradeNm */
        listColumnDefs.add(new ColumnDef("신용카드상호명", PdfG104yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드종류코드 : usePlaceCd */
        listColumnDefs.add(new ColumnDef("신용카드종류코드", PdfG104yBM.ATTR_USEPLACECD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드전전년도일반공제대상금액합계 : ftyrTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드전전년도일반공제대상금액합계", PdfG104yBM.ATTR_FTYRTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드전전년도전통시장공제대상금액합계 : ftyrMarketTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드전전년도전통시장공제대상금액합계", PdfG104yBM.ATTR_FTYRMARKETTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드전전년도대중교통공제대상금액합셰 : ftyrTmoneyTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드전전년도대중교통공제대상금액합셰", PdfG104yBM.ATTR_FTYRTMONEYTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드직전년도일반공제대상금액합계 : preTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드직전년도일반공제대상금액합계", PdfG104yBM.ATTR_PRETOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드직전년도전통시장공제대상금액합계 : preMarketTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드직전년도전통시장공제대상금액합계", PdfG104yBM.ATTR_PREMARKETTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드직전년도대중교통공제대상금액합계 : preTmoneyTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드직전년도대중교통공제대상금액합계", PdfG104yBM.ATTR_PRETMONEYTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드귀속년도_상_대상금액합계_미 : firstTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드귀속년도_상_대상금액합계_미", PdfG104yBM.ATTR_FIRSTTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드귀속년도_하_대상금액합계_미 : secondTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드귀속년도_하_대상금액합계_미", PdfG104yBM.ATTR_SECONDTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드귀속년도상반기대상금액합계 : firstYearTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드귀속년도상반기대상금액합계", PdfG104yBM.ATTR_FIRSTYEARTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드귀속년도하반기대상금액합계 : secondYearTotAmt */
        listColumnDefs.add(new ColumnDef("신용카드귀속년도하반기대상금액합계", PdfG104yBM.ATTR_SECONDYEARTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드조회기간시작월 : inqrStrtMm */
        listColumnDefs.add(new ColumnDef("신용카드조회기간시작월", PdfG104yBM.ATTR_INQRSTRTMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드조회기간종료월 : inqrEndMm */
        listColumnDefs.add(new ColumnDef("신용카드조회기간종료월", PdfG104yBM.ATTR_INQRENDMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드공제대상금액합계 : cardAmtSum */
        listColumnDefs.add(new ColumnDef("신용카드공제대상금액합계", PdfG104yBM.ATTR_CARDAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfG104yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfG104yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfG104yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfG104yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfG104yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfG104yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
 
 