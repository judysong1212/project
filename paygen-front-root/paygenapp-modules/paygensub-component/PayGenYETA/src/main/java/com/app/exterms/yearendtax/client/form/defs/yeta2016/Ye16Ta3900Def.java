package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3900BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta3900Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	
	public Ye16Ta3900Def(String string) {
//		setTitle("연말정산대상자 및 내역");
		setTitle("");
        setDaoClass("");
        setCustomListMethod("");
//        setCustomListMethod(CLASS_YETA0100_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(true); 
	    setEditFieldGrid(false);
	    setColumnsDefinition(getColumnsList()); 
	}

	private List<ColumnDef> getColumnsList() {
		row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3900BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Ye16Ta3900BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Ye16Ta3900BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta3900BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Ye16Ta3900BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 급여항목일련번호 : payItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Ye16Ta3900BM.ATTR_PAYITEMSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 70, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3900BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 지급공제구분코드 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Ye16Ta3900BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 지급공제금액 : pymtDducSum */
        listColumnDefs.add(new ColumnDef("지급공제금액", Ye16Ta3900BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 70, true, true, true){
        	{

        	}
        });
        /** column 지급공제과세금액 : pymtDducTxtnAmnt */
        listColumnDefs.add(new ColumnDef("지급공제과세금액", Ye16Ta3900BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_BIGDECIMAL , 70, true, true, true){
        	{

        	}
        });
        /** column 지급공제비과세금액 : pymtDducFreeDtySum */
        listColumnDefs.add(new ColumnDef("지급공제비과세금액", Ye16Ta3900BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_BIGDECIMAL , 70, true, true, true){
        	{

        	}
        });
        /** column 급여지급일자 : payPymtDt */
        listColumnDefs.add(new ColumnDef("급여지급일자", Ye16Ta3900BM.ATTR_PAYPYMTDT, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 급여항목명 : payItemNm */
        listColumnDefs.add(new ColumnDef("급여항목명", Ye16Ta3900BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });     
          
          return listColumnDefs;
	}

}
