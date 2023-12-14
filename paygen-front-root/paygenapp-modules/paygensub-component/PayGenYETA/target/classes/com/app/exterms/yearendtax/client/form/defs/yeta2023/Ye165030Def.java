package com.app.exterms.yearendtax.client.form.defs.yeta2023;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye165030BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye165030Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye165030Def  extends TableDef implements YetaDaoConstants {


	
	private int row = 0;
	private PrgmComBass0300DTO prgmComBass0300Dto;
	// private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	
	public Ye165030Def(String chkPayrDef) {
		
		prgmComBass0300Dto = new PrgmComBass0300DTO();
		
		
		if ("YetaP83001".equals(chkPayrDef)) {
			setDaoClass("");
			 setCustomListMethod(CLASS_YETAP83001_TO_YE165030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYetaP83001ToYe165030ColumnsList());

		}else {
			setDaoClass("");
			 setCustomListMethod(CLASS_YETAP83001_TO_YE165030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe165030ColumnsList());
		}
	}
     
    private List<ColumnDef> getYe165030ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye165030BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye165030BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye165030BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye165030BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금조정일련번호 : conbSeilNum */
        listColumnDefs.add(new ColumnDef("기부금조정일련번호", Ye165030BM.ATTR_CONBSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금유형구분코드 : conbCddl */
        listColumnDefs.add(new ColumnDef("기부금유형구분코드", Ye165030BM.ATTR_CONBCDDL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부년도 : attrYr */
        listColumnDefs.add(new ColumnDef("기부년도", Ye165030BM.ATTR_ATTRYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액 : useAmt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye165030BM.ATTR_USEAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 전년도공제된금액 : pyrDdcAmt */
        listColumnDefs.add(new ColumnDef("전년도공제된금액", Ye165030BM.ATTR_PYRDDCAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금공제대상금액 : ddcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금공제대상금액", Ye165030BM.ATTR_DDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
        listColumnDefs.add(new ColumnDef("해당연도공제금액필요경비", Ye165030BM.ATTR_THCYRDDCAMTNDXPS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
        listColumnDefs.add(new ColumnDef("해당연도공제금액세액공제금액", Ye165030BM.ATTR_THCYRDDCAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
        listColumnDefs.add(new ColumnDef("소멸금액", Ye165030BM.ATTR_THCYRNDUCEXTNAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
        listColumnDefs.add(new ColumnDef("이월금액", Ye165030BM.ATTR_THCYRNDUCCRFWAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye165030BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye165030BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye165030BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye165030BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye165030BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye165030BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
		});

		return listColumnDefs;
	}

    
    
    
    private List<ColumnDef> getYetaP83001ToYe165030ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 기부년도 : attrYr */
        listColumnDefs.add(new ColumnDef("기부년도", Ye165030BM.ATTR_ATTRYR, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        
        
        prgmComBass0300Dto.setRpsttvCd("B023");
        prgmComBass0300Dto.setMangeItem02("Y");
        /** column 기부금유형구분코드 : conbCddl */
        listColumnDefs.add(new ColumnListDef("유형", Ye165030BM.ATTR_CONBCDDL, ColumnDef.TYPE_STRING , 100,  true, true, true,  new LookupPrgmComBass0300(prgmComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });   
        prgmComBass0300Dto.setMangeItem02("");
        
        /** column 기부금유형신고코드 : ctrbTycd */
        listColumnDefs.add(new ColumnDef("유형코드", Ye165030BM.ATTR_CTRBTYCD, ColumnDef.TYPE_STRING , 60, false, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        
        /** column 기부금액 : useAmt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye165030BM.ATTR_USEAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 전년도공제된금액 : pyrDdcAmt */
        listColumnDefs.add(new ColumnDef("전년도공제금액", Ye165030BM.ATTR_PYRDDCAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 기부금공제대상금액 : ddcTrgtAmt */
        listColumnDefs.add(new ColumnDef("공제대상금액", Ye165030BM.ATTR_DDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
        listColumnDefs.add(new ColumnDef("필요경비", Ye165030BM.ATTR_THCYRDDCAMTNDXPS, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
        listColumnDefs.add(new ColumnDef("해당연도공제금액", Ye165030BM.ATTR_THCYRDDCAMT, ColumnDef.TYPE_LONG , 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
        listColumnDefs.add(new ColumnDef("소멸금액", Ye165030BM.ATTR_THCYRNDUCEXTNAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
        listColumnDefs.add(new ColumnDef("이월금액", Ye165030BM.ATTR_THCYRNDUCCRFWAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        //-- 
        
        /** column 기부금유형구분코드 : conbCddl */
        listColumnDefs.add(new ColumnDef("유형코드", Ye165030BM.ATTR_CONBCDDL, ColumnDef.TYPE_STRING , 80, false, false, false){
        	{
        		
        	}
        });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye165030BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye165030BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye165030BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye165030BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금조정일련번호 : conbSeilNum */
        listColumnDefs.add(new ColumnDef("기부금조정일련번호", Ye165030BM.ATTR_CONBSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
      

       
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye165030BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye165030BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye165030BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye165030BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye165030BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye165030BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
		});

		return listColumnDefs;
	}

    
    
    
    
    
    
}
 