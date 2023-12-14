package com.app.exterms.yearendtax.client.form.defs.yeta2021;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye165030TempBM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye165030TempDef.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye165030TempDef  extends TableDef implements YetaDaoConstants {

	private int row = 0;

	// private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye165030TempDef(String chkPayrDef) {

		if ("".equals(chkPayrDef)) {

			setDaoClass("");
			// setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye165030TempBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye165030TempBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye165030TempBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye165030TempBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금조정일련번호 : conbSeilNum */
        listColumnDefs.add(new ColumnDef("기부금조정일련번호", Ye165030TempBM.ATTR_CONBSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금유형구분코드 : conbCddl */
        listColumnDefs.add(new ColumnDef("기부금유형구분코드", Ye165030TempBM.ATTR_CONBCDDL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부년도 : attrYr */
        listColumnDefs.add(new ColumnDef("기부년도", Ye165030TempBM.ATTR_ATTRYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액 : useAmt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye165030TempBM.ATTR_USEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전년도공제된금액 : pyrDdcAmt */
        listColumnDefs.add(new ColumnDef("전년도공제된금액", Ye165030TempBM.ATTR_PYRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금공제대상금액 : ddcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금공제대상금액", Ye165030TempBM.ATTR_DDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
        listColumnDefs.add(new ColumnDef("해당연도공제금액필요경비", Ye165030TempBM.ATTR_THCYRDDCAMTNDXPS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
        listColumnDefs.add(new ColumnDef("해당연도공제금액세액공제금액", Ye165030TempBM.ATTR_THCYRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
        listColumnDefs.add(new ColumnDef("해당연도미공제금액_소멸금액", Ye165030TempBM.ATTR_THCYRNDUCEXTNAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
        listColumnDefs.add(new ColumnDef("해당연도미공제금액_이월금액", Ye165030TempBM.ATTR_THCYRNDUCCRFWAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye165030TempBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye165030TempBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye165030TempBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye165030TempBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye165030TempBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye165030TempBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
 
 