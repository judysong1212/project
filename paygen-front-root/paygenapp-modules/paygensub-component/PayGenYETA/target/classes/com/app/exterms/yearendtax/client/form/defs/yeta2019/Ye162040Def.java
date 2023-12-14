package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162040BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye162040Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162040Def  extends TableDef implements YetaDaoConstants {

	private int row = 0;

	// private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye162040Def(String chkPayrDef) {

		if ("".equals(chkPayrDef)) {

			setDaoClass("");
			// setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe162040ColumnsList());

		}
	}
     
    private List<ColumnDef> getYe162040ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162040BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye162040BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye162040BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 계좌번호_증권번호 : ltrmCniSsAccno */
        listColumnDefs.add(new ColumnDef("계좌번호_증권번호", Ye162040BM.ATTR_LTRMCNISSACCNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162040BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 장기집합투자증권저축소득공제구분코드 : ltrmCniSsfnnCl */
        listColumnDefs.add(new ColumnDef("장기집합투자증권저축소득공제구분코드", Ye162040BM.ATTR_LTRMCNISSFNNCL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 장기집합투자증권저축금융기관코드 : ltrmCniSsfnnOrgnCd */
        listColumnDefs.add(new ColumnDef("장기집합투자증권저축금융기관코드", Ye162040BM.ATTR_LTRMCNISSFNNORGNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 장기집합투자증권저축회사명 : ltrmCniSsFnnCmp */
        listColumnDefs.add(new ColumnDef("장기집합투자증권저축회사명", Ye162040BM.ATTR_LTRMCNISSFNNCMP, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 장기집합투자증권저축납입금액 : ltrmCniSsPymAmt */
        listColumnDefs.add(new ColumnDef("장기집합투자증권저축납입금액", Ye162040BM.ATTR_LTRMCNISSPYMAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기집합투자증권저축세액공제금액 : ltrmCniSsIncDdcAmt */
        listColumnDefs.add(new ColumnDef("장기집합투자증권저축세액공제금액", Ye162040BM.ATTR_LTRMCNISSINCDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162040BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162040BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162040BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162040BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162040BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162040BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
		});

		return listColumnDefs;
	}

}

 