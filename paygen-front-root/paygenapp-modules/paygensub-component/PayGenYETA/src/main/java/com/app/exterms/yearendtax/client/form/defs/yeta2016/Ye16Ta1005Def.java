package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta1005Def extends TableDef implements YetaDaoConstants{
	
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	private int row = 0;
	
	public Ye16Ta1005Def(String chkDef) {
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		
		if("".equals(chkDef)) {
//		setTitle("연금저축소득공제");
			setTitle("");
	        setDaoClass("");
//	        setCustomListMethod(CLASS_YETAP13007TOYETA3100_DATA_LIST);
	  	  	setAutoFillGrid(true);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsList()); 
		}else {
			
//			setTitle("연말정산대상자 및 내역");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
//	        setCustomListMethod(CLASS_YETA0100_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(false);
		    setColumnsDefinition(getColumnsList()); 	
	    }
	}

	private List<ColumnDef> getColumnsList() {
	 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta1005BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
        listColumnDefs.add(new ColumnDef("원천세신고부서코드", Ye16Ta1005BM.ATTR_WHDGTXREGRSTDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
        listColumnDefs.add(new ColumnDef("상위원천세신고부서코드", Ye16Ta1005BM.ATTR_HHRKWHDGREGRSTDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A3_세무서코드 : txOffcCd */
        listColumnDefs.add(new ColumnDef("A3_세무서코드", Ye16Ta1005BM.ATTR_TXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A5_제출자구분 : pentrSeptCd */
        listColumnDefs.add(new ColumnDef("A5_제출자구분", Ye16Ta1005BM.ATTR_PENTRSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A6_세무대리인관리번호 : txDeptyMangeNum */
        listColumnDefs.add(new ColumnDef("A6_세무대리인관리번호", Ye16Ta1005BM.ATTR_TXDEPTYMANGENUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A7_홈텍스ID : hmtxId */
        listColumnDefs.add(new ColumnDef("A7_홈텍스ID", Ye16Ta1005BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A8_세무프로그램코드 : txPgmCd */
        listColumnDefs.add(new ColumnDef("A8_세무프로그램코드", Ye16Ta1005BM.ATTR_TXPGMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A9_사업자등록번호 : busoprRgstnum */
        listColumnDefs.add(new ColumnDef("A9_사업자등록번호", Ye16Ta1005BM.ATTR_BUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A10_법인_상호명 : corpFmnmNm */
        listColumnDefs.add(new ColumnDef("A10_법인_상호명", Ye16Ta1005BM.ATTR_CORPFMNMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A11_담당자부서 : pernChrgDeptNm */
        listColumnDefs.add(new ColumnDef("A11_담당자부서", Ye16Ta1005BM.ATTR_PERNCHRGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A12_담당자성명 : pernChrgNm */
        listColumnDefs.add(new ColumnDef("A12_담당자성명", Ye16Ta1005BM.ATTR_PERNCHRGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A13_담당자전화번호 : pernChrgPhnNum */
        listColumnDefs.add(new ColumnDef("A13_담당자전화번호", Ye16Ta1005BM.ATTR_PERNCHRGPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column A15_사용한글코드 : useHanCd */
        listColumnDefs.add(new ColumnDef("A15_사용한글코드", Ye16Ta1005BM.ATTR_USEHANCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column B16_제출대상기간코드 : sumtTgtPridCd */
        listColumnDefs.add(new ColumnDef("B16_제출대상기간코드", Ye16Ta1005BM.ATTR_SUMTTGTPRIDCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인번호 : corpNum */
        listColumnDefs.add(new ColumnDef("법인번호", Ye16Ta1005BM.ATTR_CORPNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자우편번호 : incmPost */
        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Ye16Ta1005BM.ATTR_INCMPOST, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자기본주소 : incmAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Ye16Ta1005BM.ATTR_INCMADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자상세주소 : incmAdtl */
        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Ye16Ta1005BM.ATTR_INCMADTL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta1005BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta1005BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta1005BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta1005BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta1005BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta1005BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자성명 : reprName */
        listColumnDefs.add(new ColumnDef("대표자성명", Ye16Ta1005BM.ATTR_REPRNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resuNumb */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta1005BM.ATTR_RESUNUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
          
          return listColumnDefs;
	}
	
	
	

}
