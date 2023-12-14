package com.app.exterms.yearendtax.client.form.defs.yeta2022;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.PdfN101yBM;
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
public class PdfN101yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfN101yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA7200_PDF_N101Y_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfN101yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfN101yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfN101yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfN101yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("소득공제자료적용여부", PdfN101yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfN101yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfN101yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 장기집합투자_계좌번호 : secuNo */
        listColumnDefs.add(new ColumnDef("장기집합투자_계좌번호", PdfN101yBM.ATTR_SECUNO, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfN101yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("장기집합투자_주민등록번호", PdfN101yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_성명 : name */
        listColumnDefs.add(new ColumnDef("장기집합투자_성명", PdfN101yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfN101yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_사업자등록번호 : busnid */
        listColumnDefs.add(new ColumnDef("장기집합투자_사업자등록번호", PdfN101yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_취급기관명 : tradeNm */
        listColumnDefs.add(new ColumnDef("장기집합투자_취급기관명", PdfN101yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_펀드명 : fundNm */
        listColumnDefs.add(new ColumnDef("장기집합투자_펀드명", PdfN101yBM.ATTR_FUNDNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_가입일자 : regDt */
        listColumnDefs.add(new ColumnDef("장기집합투자_가입일자", PdfN101yBM.ATTR_REGDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_금융회사등코드 : comCd */
        listColumnDefs.add(new ColumnDef("장기집합투자_금융회사등코드", PdfN101yBM.ATTR_COMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_연간합계액 : longAssSum */
        listColumnDefs.add(new ColumnDef("장기집합투자_연간합계액", PdfN101yBM.ATTR_LONGASSSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 장기집합투자_소득공제대상금액 : ddctBsAssAmt */
        listColumnDefs.add(new ColumnDef("장기집합투자_소득공제대상금액", PdfN101yBM.ATTR_DDCTBSASSAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfN101yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfN101yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfN101yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfN101yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfN101yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfN101yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
 
 
