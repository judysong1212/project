package com.app.exterms.yearendtax.client.form.defs.yeta2021;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye166020BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye166020Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye166020Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    
	public Ye166020Def(String chkPayrDef) {

		if ("".equals(chkPayrDef)) {

			setDaoClass("");
			// setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe166020ColumnsList());

		}

	}
     
    private List<ColumnDef> getYe166020ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye166020BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye166020BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye166020BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye166020BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자가족주민등록번호 : famResnoEncCntn */
        listColumnDefs.add(new ColumnDef("공제대상자가족주민등록번호", Ye166020BM.ATTR_FAMRESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제자료명세구분코드 : dataCd */
        listColumnDefs.add(new ColumnDef("소득공제자료명세구분코드", Ye166020BM.ATTR_DATACD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자내외국인구분코드 : nnfCl */
        listColumnDefs.add(new ColumnDef("공제대상자내외국인구분코드", Ye166020BM.ATTR_NNFCL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자부양관계코드 : suptFmlyRltCl */
        listColumnDefs.add(new ColumnDef("공제대상자부양관계코드", Ye166020BM.ATTR_SUPTFMLYRLTCL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자성명 : suptFmlyFnm */
        listColumnDefs.add(new ColumnDef("공제대상자성명", Ye166020BM.ATTR_SUPTFMLYFNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상자생년월일 : suptFmlyBhdt */
        listColumnDefs.add(new ColumnDef("공제대상자생년월일", Ye166020BM.ATTR_SUPTFMLYBHDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액소계 : crdcUseAmtSum */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액소계", Ye166020BM.ATTR_CRDCUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_신용카드 : crdcUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_신용카드", Ye166020BM.ATTR_CRDCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_현금영수증 : cshptUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_현금영수증", Ye166020BM.ATTR_CSHPTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_직불선불카등등", Ye166020BM.ATTR_DRTPCARDUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_전통시장사용분", Ye166020BM.ATTR_TDMRUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용금액_대중교통이용분 : etcUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용금액_대중교통이용분", Ye166020BM.ATTR_ETCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye166020BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye166020BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye166020BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye166020BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye166020BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye166020BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

			}
		});

		return listColumnDefs;
	}

}

 
