package com.app.exterms.yearendtax.client.form.defs.yeta2023;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.PdfK101yBM;
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
public class PdfK101yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfK101yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA8200_PDF_K101Y_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfK101yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfK101yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfK101yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfK101yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("소득공제자료적용여부", PdfK101yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfK101yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfK101yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 소상공인공제부금계약_증서번호 : accNo */
        listColumnDefs.add(new ColumnDef("소상공인공제부금계약_증서번호", PdfK101yBM.ATTR_ACCNO, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfK101yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 소상공인공제부금주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("소상공인공제부금주민등록번호", PdfK101yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 소상공인공제부금성명 : name */
        listColumnDefs.add(new ColumnDef("소상공인공제부금성명", PdfK101yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfK101yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 소상공인공제부금대상가입일자 : startDt */
        listColumnDefs.add(new ColumnDef("소상공인공제부금대상가입일자", PdfK101yBM.ATTR_STARTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 소상공인공제부금대상종료일자 : endDt */
        listColumnDefs.add(new ColumnDef("소상공인공제부금대상종료일자", PdfK101yBM.ATTR_ENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 소상공인공제부금납입방법 : payMethod */
        listColumnDefs.add(new ColumnDef("소상공인공제부금납입방법", PdfK101yBM.ATTR_PAYMETHOD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 소상공인공제부금납입금액계 : busnAmtSum */
        listColumnDefs.add(new ColumnDef("소상공인공제부금납입금액계", PdfK101yBM.ATTR_BUSNAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 소상공인공제부금소득공제대상액 : busnSumDdct */
        listColumnDefs.add(new ColumnDef("소상공인공제부금소득공제대상액", PdfK101yBM.ATTR_BUSNSUMDDCT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfK101yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfK101yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfK101yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfK101yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfK101yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfK101yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
 
