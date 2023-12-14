package com.app.exterms.yearendtax.client.form.defs.yeta2017;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye166010BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye166010Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye166010Def  extends TableDef implements YetaDaoConstants {

	private int row = 0;

	// private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye166010Def(String chkPayrDef) {
		if ("".equals(chkPayrDef)) {
			setDaoClass("");
			// setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe166010ColumnsList());
		}
	}
     
    private List<ColumnDef> getYe166010ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye166010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye166010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye166010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye166010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장사용분공제금액 : tdmrDdcAmt */
        listColumnDefs.add(new ColumnDef("전통시장사용분공제금액", Ye166010BM.ATTR_TDMRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통이용분공제금액 : pbtDdcAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용분공제금액", Ye166010BM.ATTR_PBTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드등사용분공제금액 : drtpCardDdcAmt */
        listColumnDefs.add(new ColumnDef("직불카드등사용분공제금액", Ye166010BM.ATTR_DRTPCARDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드사용분 공제금액 : crdcDdcAmt */
        listColumnDefs.add(new ColumnDef("신용카드사용분 공제금액", Ye166010BM.ATTR_CRDCDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제제외금액계산총급여액 : totaSnwAmt */
        listColumnDefs.add(new ColumnDef("공제제외금액계산총급여액", Ye166010BM.ATTR_TOTASNWAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제제외금액계산최저사용금액 : minmUseAmt */
        listColumnDefs.add(new ColumnDef("공제제외금액계산최저사용금액", Ye166010BM.ATTR_MINMUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제제외금액계산공제제외금액 : ddcExclAmt */
        listColumnDefs.add(new ColumnDef("공제제외금액계산공제제외금액", Ye166010BM.ATTR_DDCEXCLAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제율사용분증가분공제금액 : addDdcrtDdcAmt */
        listColumnDefs.add(new ColumnDef("추가공제율사용분증가분공제금액", Ye166010BM.ATTR_ADDDDCRTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제가능금액 : ddcPsbAmt */
        listColumnDefs.add(new ColumnDef("공제가능금액", Ye166010BM.ATTR_DDCPSBAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제한도액 : ddcLmtAmt */
        listColumnDefs.add(new ColumnDef("공제한도액", Ye166010BM.ATTR_DDCLMTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 일반공제금액 : gnrlDdcAmt */
        listColumnDefs.add(new ColumnDef("일반공제금액", Ye166010BM.ATTR_GNRLDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장추가공제금액 : tdmrAddDdcAmt */
        listColumnDefs.add(new ColumnDef("전통시장추가공제금액", Ye166010BM.ATTR_TDMRADDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통추가공제금액 : pbtAddDdcAmt */
        listColumnDefs.add(new ColumnDef("대중교통추가공제금액", Ye166010BM.ATTR_PBTADDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 최종공제금액 : lstDdcAmt */
        listColumnDefs.add(new ColumnDef("최종공제금액", Ye166010BM.ATTR_LSTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전전년도본인신용카드사용액_2014 : ftyrPrsCrdcUseAmt */
        listColumnDefs.add(new ColumnDef("전전년도본인신용카드사용액_2014", Ye166010BM.ATTR_FTYRPRSCRDCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전년도본인신용카드사용액_2015 : pyrPrsCrdcUseAmt1 */
        listColumnDefs.add(new ColumnDef("전년도본인신용카드사용액_2015", Ye166010BM.ATTR_PYRPRSCRDCUSEAMT1, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전전년도_본인추가공제율사용분_2014 : ftyrPrsAddDdcrtAmt */
        listColumnDefs.add(new ColumnDef("전전년도_본인추가공제율사용분_2014", Ye166010BM.ATTR_FTYRPRSADDDDCRTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 당해년도상반기추가공제율사용분_2016상 : tyYrTfhyPrsAddDdcrtAmt */
        listColumnDefs.add(new ColumnDef("당해년도상반기추가공제율사용분_2016상", Ye166010BM.ATTR_TYYRTFHYPRSADDDDCRTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye166010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye166010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye166010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye166010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye166010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye166010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
		});

		return listColumnDefs;
	}

}
  