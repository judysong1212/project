package com.app.exterms.yearendtax.client.form.defs.yeta2018;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2018.PdfG307yBM;
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
public class PdfG307yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfG307yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA3200_PDF_G307Y_DATA_LIST);
          setAutoFillGrid(true);
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfG307yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfG307yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfG307yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfG307yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("소득공제자료적용여부", PdfG307yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfG307yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfG307yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        /** column 직불카드공제대상금액합계 : dirCardAmtSum */
        listColumnDefs.add(new ColumnDef("직불카드공제대상금액합계", PdfG307yBM.ATTR_DIRCARDAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 직불카드일련번호 : dirCardSeilNum */
        listColumnDefs.add(new ColumnDef("직불카드일련번호", PdfG307yBM.ATTR_DIRCARDSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfG307yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 직불카드주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("직불카드주민등록번호", PdfG307yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 직불카드성명 : name */
        listColumnDefs.add(new ColumnDef("직불카드성명", PdfG307yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfG307yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 직불카드사업자등록번호 : busnid */
        listColumnDefs.add(new ColumnDef("직불카드사업자등록번호", PdfG307yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 직불카드상호명 : tradeNm */
        listColumnDefs.add(new ColumnDef("직불카드상호명", PdfG307yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 직불카드종류코드 : usePlaceCd */
        listColumnDefs.add(new ColumnDef("직불카드종류코드", PdfG307yBM.ATTR_USEPLACECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfG307yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfG307yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfG307yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfG307yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfG307yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfG307yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
  