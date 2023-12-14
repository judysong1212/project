package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.PdfO101yBM;
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
public class PdfO101yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfO101yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA4200_PDF_O101Y_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfO101yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfO101yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfO101yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfO101yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("소득공제자료적용여부", PdfO101yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfO101yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfO101yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfO101yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfO101yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 건강보험료_주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("건강보험료_주민등록번호", PdfO101yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 건강보험료_성명 : name */
        listColumnDefs.add(new ColumnDef("건강보험료_성명", PdfO101yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 건강보험료총합계금액 : hlthAmtSum */
        listColumnDefs.add(new ColumnDef("건강보험료총합계금액", PdfO101yBM.ATTR_HLTHAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 건강보험연말정산금액 : hiYrs */
        listColumnDefs.add(new ColumnDef("건강보험연말정산금액", PdfO101yBM.ATTR_HIYRS, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기요양연말정산금액 : ltrmYrs */
        listColumnDefs.add(new ColumnDef("장기요양연말정산금액", PdfO101yBM.ATTR_LTRMYRS, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 건강보험_보수월액_고지금액합계 : hiNtf */
        listColumnDefs.add(new ColumnDef("건강보험_보수월액_고지금액합계", PdfO101yBM.ATTR_HINTF, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기요양_보수월액_고지금액합계 : ltrmNtf */
        listColumnDefs.add(new ColumnDef("장기요양_보수월액_고지금액합계", PdfO101yBM.ATTR_LTRMNTF, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 건강보험_소득월액_납부금액합계 : hiPmt */
        listColumnDefs.add(new ColumnDef("건강보험_소득월액_납부금액합계", PdfO101yBM.ATTR_HIPMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기요양_소득월액_납부금액합계 : ltrmPmt */
        listColumnDefs.add(new ColumnDef("장기요양_소득월액_납부금액합계", PdfO101yBM.ATTR_LTRMPMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfO101yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfO101yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfO101yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfO101yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfO101yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfO101yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
 

 
