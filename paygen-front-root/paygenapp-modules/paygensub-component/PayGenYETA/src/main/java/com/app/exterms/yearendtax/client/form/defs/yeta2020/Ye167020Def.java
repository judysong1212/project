package com.app.exterms.yearendtax.client.form.defs.yeta2020;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye167020BM;
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

public class Ye167020Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167020Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167020BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167020BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167020BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167020BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관계코드 : suptFmlyRltClCd */
        listColumnDefs.add(new ColumnDef("관계코드", Ye167020BM.ATTR_SUPTFMLYRLTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 내외국인구분 : nnfClCd */
        listColumnDefs.add(new ColumnDef("내외국인구분", Ye167020BM.ATTR_NNFCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 자녀인원수 : child */
        listColumnDefs.add(new ColumnDef("자녀인원수", Ye167020BM.ATTR_CHILD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 성명 : txprNm */
        listColumnDefs.add(new ColumnDef("성명", Ye167020BM.ATTR_TXPRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : txprDscmNoCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye167020BM.ATTR_TXPRDSCMNOCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제여부 : bscDdcClCd */
        listColumnDefs.add(new ColumnDef("기본공제여부", Ye167020BM.ATTR_BSCDDCCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부녀자여부 : wmnDdcClCd */
        listColumnDefs.add(new ColumnDef("부녀자여부", Ye167020BM.ATTR_WMNDDCCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 한부모여부 : snprntFmlyDdcClCd */
        listColumnDefs.add(new ColumnDef("한부모여부", Ye167020BM.ATTR_SNPRNTFMLYDDCCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 경로우대여부 : sccDdcClCd */
        listColumnDefs.add(new ColumnDef("경로우대여부", Ye167020BM.ATTR_SCCDDCCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인여부 : dsbrDdcClCd */
        listColumnDefs.add(new ColumnDef("장애인여부", Ye167020BM.ATTR_DSBRDDCCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 출산입양여부 : chbtAtprDdcClCd */
        listColumnDefs.add(new ColumnDef("출산입양여부", Ye167020BM.ATTR_CHBTATPRDDCCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /**//** column 6세이하여부 : age6Lt *//*
        listColumnDefs.add(new ColumnDef("6세이하여부", Ye167020BM.ATTR_AGE6LT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        */
        /** column 취학여부 : schoolYN */
        listColumnDefs.add(new ColumnDef("7세미만취학", Ye167020BM.ATTR_SCHOOLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167020BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167020BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167020BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167020BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167020BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167020BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
  
