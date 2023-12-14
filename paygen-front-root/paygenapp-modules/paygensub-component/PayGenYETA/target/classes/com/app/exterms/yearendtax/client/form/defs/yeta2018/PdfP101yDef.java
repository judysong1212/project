package com.app.exterms.yearendtax.client.form.defs.yeta2018;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2018.PdfP101yBM;
import com.app.exterms.yearendtax.client.dto.yeta2018.PdfP101yBM;
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
public class PdfP101yDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public PdfP101yDef(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_YETA3200_PDF_P101Y_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfP101yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfP101yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfP101yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfP101yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
        listColumnDefs.add(new ColumnDef("pdf 소득공제자료적용여부", PdfP101yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
        listColumnDefs.add(new ColumnDef("PDF_소득공제적용일자", PdfP101yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
        listColumnDefs.add(new ColumnDef("PDF_소득공제제외사유내용", PdfP101yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 자료코드 : datCd */
        listColumnDefs.add(new ColumnDef("자료코드", PdfP101yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", PdfP101yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금_주민등록번호 : resid */
        listColumnDefs.add(new ColumnDef("국민연금_주민등록번호", PdfP101yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금_성명 : name */
        listColumnDefs.add(new ColumnDef("국민연금_성명", PdfP101yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금_총합계금액 : natAmtSum */
        listColumnDefs.add(new ColumnDef("국민연금_총합계금액", PdfP101yBM.ATTR_NATAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금_추납보험료납부금액 : spym */
        listColumnDefs.add(new ColumnDef("국민연금_추납보험료납부금액", PdfP101yBM.ATTR_SPYM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금_실업크레딧납부금액 : jlc */
        listColumnDefs.add(new ColumnDef("국민연금_실업크레딧납부금액", PdfP101yBM.ATTR_JLC, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금_직장가입자고지금액합계 : ntf */
        listColumnDefs.add(new ColumnDef("국민연금_직장가입자고지금액합계", PdfP101yBM.ATTR_NTF, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금_지역가입자등_납입금액합계 : pmt */
        listColumnDefs.add(new ColumnDef("국민연금_지역가입자등_납입금액합계", PdfP101yBM.ATTR_PMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfP101yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfP101yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfP101yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfP101yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfP101yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfP101yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
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
//        private TextField<String> datCd;   /** column 자료코드 : datCd */
//
//        private TextField<String> formCd;   /** column 서식코드 : formCd */
//
//        private TextField<String> resid;   /** column 국민연금_주민등록번호 : resid */
//
//        private TextField<String> name;   /** column 국민연금_성명 : name */
//
//        private TextField<String> natAmtSum;   /** column 국민연금_총합계금액 : natAmtSum */
//
//        private TextField<String> spym;   /** column 국민연금_추납보험료납부금액 : spym */
//
//        private TextField<String> jlc;   /** column 국민연금_실업크레딧납부금액 : jlc */
//
//        private TextField<String> ntf;   /** column 국민연금_직장가입자고지금액합계 : ntf */
//
//        private TextField<String> pmt;   /** column 국민연금_지역가입자등_납입금액합계 : pmt */
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
  
