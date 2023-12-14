package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.PdfJ203yBM;
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
public class PdfJ203yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfJ203yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA4200_PDF_J203Y_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfJ203yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfJ203yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfJ203yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfJ203yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("pdf 소득공제자료적용여부", PdfJ203yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("PDF_소득공제적용일자", PdfJ203yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("PDF_소득공제제외사유내용", PdfJ203yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 장기주택저당차입금일련번호 : loanSeilNum */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금일련번호", PdfJ203yBM.ATTR_LOANSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfJ203yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금주민등록번호", PdfJ203yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금성명 : name */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금성명", PdfJ203yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfJ203yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금사업자등록번호 : busnid */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금사업자등록번호", PdfJ203yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금취급기관명 : tradeNm */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금취급기관명", PdfJ203yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금계좌번호 : accNo */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금계좌번호", PdfJ203yBM.ATTR_ACCNO, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금대출종류 : lendKd */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금대출종류", PdfJ203yBM.ATTR_LENDKD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금주택취득일자 : houseTakeDt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금주택취득일자", PdfJ203yBM.ATTR_HOUSETAKEDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금저당권설정일자 : mortSetupDt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금저당권설정일자", PdfJ203yBM.ATTR_MORTSETUPDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금최초차입일자 : startDt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금최초차입일자", PdfJ203yBM.ATTR_STARTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금최종상환예정일자 : endDt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금최종상환예정일자", PdfJ203yBM.ATTR_ENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금상환기간연수 : repayYears */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금상환기간연수", PdfJ203yBM.ATTR_REPAYYEARS, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금상품명 : lendGoodsNm */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금상품명", PdfJ203yBM.ATTR_LENDGOODSNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금금액 : debt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금금액", PdfJ203yBM.ATTR_DEBT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금고정금리차입금 : fixedRateDebt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금고정금리차입금", PdfJ203yBM.ATTR_FIXEDRATEDEBT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금비거치식상환차입금액 : notDeferDebt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금비거치식상환차입금액", PdfJ203yBM.ATTR_NOTDEFERDEBT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금당해년원금상환액 : thisYearRedeAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금당해년원금상환액", PdfJ203yBM.ATTR_THISYEARREDEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금소득공제대상금액 : sumDdct */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금소득공제대상금액", PdfJ203yBM.ATTR_SUMDDCT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기주택저당차입금연간합계금액 : yearSumDdct */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금연간합계금액", PdfJ203yBM.ATTR_YEARSUMDDCT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfJ203yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfJ203yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfJ203yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfJ203yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfJ203yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfJ203yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
  