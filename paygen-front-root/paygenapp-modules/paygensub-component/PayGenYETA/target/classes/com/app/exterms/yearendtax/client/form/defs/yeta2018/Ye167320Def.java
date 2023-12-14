package com.app.exterms.yearendtax.client.form.defs.yeta2018;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye167320BM;
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

public class Ye167320Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167320Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167320BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167320BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167320BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167320BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비지급일련번호 : mdxpsSeilNum */
        listColumnDefs.add(new ColumnDef("의료비지급일련번호", Ye167320BM.ATTR_MDXPSSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("의료비공제대상자주민등록번호", Ye167320BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 본인등해당여부 : yn */
        listColumnDefs.add(new ColumnDef("본인등해당여부", Ye167320BM.ATTR_YN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급처사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("지급처사업자등록번호", Ye167320BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_상호명 : plymNm */
        listColumnDefs.add(new ColumnDef("의료비_상호명", Ye167320BM.ATTR_PLYMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_의료증빙코드 : mdxpsPrfClCd */
        listColumnDefs.add(new ColumnDef("의료비_의료증빙코드", Ye167320BM.ATTR_MDXPSPRFCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_건수 : scnt */
        listColumnDefs.add(new ColumnDef("의료비_건수", Ye167320BM.ATTR_SCNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_금액 : useAmt */
        listColumnDefs.add(new ColumnDef("의료비_금액", Ye167320BM.ATTR_USEAMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_난임시술비해당여부 : yn2 */
        listColumnDefs.add(new ColumnDef("의료비_난임시술비해당여부", Ye167320BM.ATTR_YN2, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167320BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167320BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167320BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167320BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167320BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167320BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> mdxpsSeilNum;   /** column 의료비지급일련번호 : mdxpsSeilNum */
//
//        private TextField<String> resnoEncCntn;   /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
//
//        private TextField<String> yn;   /** column 본인등해당여부 : yn */
//
//        private TextField<String> bsnoEncCntn;   /** column 지급처사업자등록번호 : bsnoEncCntn */
//
//        private TextField<String> plymNm;   /** column 의료비_상호명 : plymNm */
//
//        private TextField<String> mdxpsPrfClCd;   /** column 의료비_의료증빙코드 : mdxpsPrfClCd */
//
//        private TextField<String> scnt;   /** column 의료비_건수 : scnt */
//
//        private TextField<String> useAmt;   /** column 의료비_금액 : useAmt */
//
//        private TextField<String> yn2;   /** column 의료비_난임시술비해당여부 : yn2 */
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
 
 