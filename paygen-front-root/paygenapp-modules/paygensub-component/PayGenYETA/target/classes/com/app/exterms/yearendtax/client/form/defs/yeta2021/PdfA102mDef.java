package com.app.exterms.yearendtax.client.form.defs.yeta2021;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.PdfA102mBM;
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
public class PdfA102mDef  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    public PdfA102mDef(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", PdfA102mBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", PdfA102mBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfA102mBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfA102mBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료납입월 : insuMm */
        listColumnDefs.add(new ColumnDef("보험료납입월", PdfA102mBM.ATTR_INSUMM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 증권번호 : accNo */
        listColumnDefs.add(new ColumnDef("증권번호", PdfA102mBM.ATTR_ACCNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료월별납입금액 : insuMmAmt */
        listColumnDefs.add(new ColumnDef("보험료월별납입금액", PdfA102mBM.ATTR_INSUMMAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료월별확정구분코드 : insuFixCd */
        listColumnDefs.add(new ColumnDef("보험료월별확정구분코드", PdfA102mBM.ATTR_INSUFIXCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PdfA102mBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PdfA102mBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PdfA102mBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PdfA102mBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PdfA102mBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PdfA102mBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> insuMm;   /** column 보험료납입월 : insuMm */
    //
//        private TextField<String> accNo;   /** column 증권번호 : accNo */
    //
//        private TextField<String> insuMmAmt;   /** column 보험료월별납입금액 : insuMmAmt */
    //
//        private TextField<String> insuFixCd;   /** column 보험료월별확정구분코드 : insuFixCd */
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

            
            return listColumnDefs;
        }
    
    
}
