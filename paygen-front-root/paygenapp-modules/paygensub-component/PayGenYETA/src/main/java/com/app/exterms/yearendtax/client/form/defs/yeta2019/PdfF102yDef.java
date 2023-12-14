package com.app.exterms.yearendtax.client.form.defs.yeta2019;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.PdfF102yBM;
import com.app.exterms.yearendtax.client.dto.yeta2019.PdfF102yBM;
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

public class PdfF102yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfF102yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA4200_PDF_F102Y_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfF102yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfF102yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfF102yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfF102yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("소득공제자료적용여부", PdfF102yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfF102yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfF102yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직연금계좌번호 : accNo */
        listColumnDefs.add(new ColumnDef("퇴직연금계좌번호", PdfF102yBM.ATTR_ACCNO, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfF102yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("퇴직연금주민등록번호", PdfF102yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금성명 : name */
        listColumnDefs.add(new ColumnDef("퇴직연금성명", PdfF102yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfF102yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금사업자등록번호 : busnid */
        listColumnDefs.add(new ColumnDef("퇴직연금사업자등록번호", PdfF102yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금상호명 : tradeNm */
        listColumnDefs.add(new ColumnDef("퇴직연금상호명", PdfF102yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금금융회사등코드 : comCd */
        listColumnDefs.add(new ColumnDef("퇴직연금금융회사등코드", PdfF102yBM.ATTR_COMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금계좌유형코드 : pensionCd */
        listColumnDefs.add(new ColumnDef("퇴직연금계좌유형코드", PdfF102yBM.ATTR_PENSIONCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금당해연도납입금액 : annTotAmt */
        listColumnDefs.add(new ColumnDef("퇴직연금당해연도납입금액", PdfF102yBM.ATTR_ANNTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금당해연도인출금액 : taxYearAmt */
        listColumnDefs.add(new ColumnDef("퇴직연금당해연도인출금액", PdfF102yBM.ATTR_TAXYEARAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금순납입금액 : ddctBsAssAmt */
        listColumnDefs.add(new ColumnDef("퇴직연금순납입금액", PdfF102yBM.ATTR_DDCTBSASSAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 퇴직연금납입금액합계 : retirPnsnAmtSum */
        listColumnDefs.add(new ColumnDef("퇴직연금납입금액합계", PdfF102yBM.ATTR_RETIRPNSNAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfF102yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfF102yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfF102yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfF102yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfF102yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfF102yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
 
 
