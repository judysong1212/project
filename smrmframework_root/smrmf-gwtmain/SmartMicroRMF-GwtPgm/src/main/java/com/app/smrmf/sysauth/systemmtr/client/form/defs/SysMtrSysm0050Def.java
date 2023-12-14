package com.app.smrmf.sysauth.systemmtr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0050BM;
import com.app.smrmf.sysauth.systemmtr.client.languages.SysmMtrConstants;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.google.gwt.i18n.client.DateTimeFormat;

public class SysMtrSysm0050Def extends TableDef implements SysmMtrDaoConstants {
    private int row = 0;
    
    private SysmMtrConstants lblSysmConst = SysmMtrConstants.INSTANCE;
    
    public SysMtrSysm0050Def(){
    	
    	  setTitle("");
          setDaoClass(""); 
          setCustomListMethod(CLASS_SYSMMTR0100TOSYSM0050_LIST);
          
    	  
//          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          setEditableGrid(false);
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
  
	 
		/** column 시스템사업장코드 : sysDpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", SysMtrSysm0050BM.ATTR_SYSDPOBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 시스템사업장명 : sysDpobNm */
		listColumnDefs.add(new ColumnDef("사업장명", SysMtrSysm0050BM.ATTR_SYSDPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 시스템사업장KEY : sysDpobKey */
		listColumnDefs.add(new ColumnDef("사업장KEY", SysMtrSysm0050BM.ATTR_SYSDPOBKEY, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		/** column 사용시스템구분코드 : useSysDivCd */
		listColumnDefs.add(new ColumnDef("시스템구분", SysMtrSysm0050BM.ATTR_USESYSDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});
		
		/** column 시스템사업장개시일자 : sysDpobBgnDt */
		listColumnDefs.add(new ColumnDef("개시일자", SysMtrSysm0050BM.ATTR_SYSDPOBBGNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
				setMaxLength(10);
				setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
				setDtFieldMask("9999.99.99");
		
			}
		});
		/** column 시스템사업장종료일자 : sysDpobEdDt */
		listColumnDefs.add(new ColumnDef("종료일자", SysMtrSysm0050BM.ATTR_SYSDPOBEDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
				setMaxLength(10);
				setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
				setDtFieldMask("9999.99.99");
		
			}
		});
		
		/** column 시스템사업장사용여부 : sysDpobUseYn */
		listColumnDefs.add(new ColumnDef("사용여부", SysMtrSysm0050BM.ATTR_SYSDPOBUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{
		
			}
		});
		
		/** column 시스템사업장내용 : sysDpobCtnt */
		listColumnDefs.add(new ColumnDef("내 용", SysMtrSysm0050BM.ATTR_SYSDPOBCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
		
			}
		});

///** column 입력자 : kybdr */
//listColumnDefs.add(new ColumnDef("입력자", SysMtrSysm0050BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 입력일자 : inptDt */
//listColumnDefs.add(new ColumnDef("입력일자", SysMtrSysm0050BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 입력주소 : inptAddr */
//listColumnDefs.add(new ColumnDef("입력주소", SysMtrSysm0050BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정자 : ismt */
//listColumnDefs.add(new ColumnDef("수정자", SysMtrSysm0050BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정일자 : revnDt */
//listColumnDefs.add(new ColumnDef("수정일자", SysMtrSysm0050BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정주소 : revnAddr */
//listColumnDefs.add(new ColumnDef("수정주소", SysMtrSysm0050BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});

//private TextField<String> sysDpobCd;   /** column 시스템사업장코드 : sysDpobCd */
//
//private TextField<String> sysDpobNm;   /** column 시스템사업장명 : sysDpobNm */
//
//private TextField<String> sysDpobKey;   /** column 시스템사업장KEY : sysDpobKey */
//
//private TextField<String> useSysDivCd;   /** column 사용시스템구분코드 : useSysDivCd */
//
//private TextField<String> sysDpobUseYn;   /** column 시스템사업장사용여부 : sysDpobUseYn */
//
//private TextField<String> sysDpobBgnDt;   /** column 시스템사업장개시일자 : sysDpobBgnDt */
//
//private TextField<String> sysDpobEdDt;   /** column 시스템사업장종료일자 : sysDpobEdDt */
//
//private TextField<String> sysDpobCtnt;   /** column 시스템사업장내용 : sysDpobCtnt */
//
//private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//private TextField<String> ismt;   /** column 수정자 : ismt */
//
//private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */

        return listColumnDefs;
    }
}
