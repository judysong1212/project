package com.app.smrmf.sysauth.systemmtr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0051BM;
import com.app.smrmf.sysauth.systemmtr.client.languages.SysmMtrConstants;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.google.gwt.i18n.client.DateTimeFormat;

public class SysMtrSysm0051Def extends TableDef implements SysmMtrDaoConstants {
    private int row = 0;
    
    private SysmMtrConstants lblSysmConst = SysmMtrConstants.INSTANCE;
    private SysIfBass0300DTO sysComBass0300Dto;
    
    public SysMtrSysm0051Def(){
    	
    	  setTitle("");
          setDaoClass(""); 
          setCustomListMethod(CLASS_SYSMMTR0100TOSYSM0051_LIST);
          
          setEditFieldGrid(true); 
          setEditableGrid(true);
          setCheckBoxOnGridRows(true);
    	 
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
    	
    	sysComBass0300Dto = new SysIfBass0300DTO();
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분코드", SysMtrSysm0051BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			{
		
			}
		});
        
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분", SysMtrSysm0051BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 90, true, true, false){
			{
				setReadOnly(true);
			}
		});     
		
		
//		/** column 과세유형구분코드 : txtnFrmDivCd */
//		listColumnDefs.add(new ColumnDef("과세유형구분코드", SysMtrSysm0051BM.ATTR_TXTNFRMDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
//			{
//		
//			}
//		});
		
        sysComBass0300Dto.setRpsttvCd("B031");
        listColumnDefs.add(new ColumnListDef("과세유형",   SysMtrSysm0051BM.ATTR_TXTNFRMDIVCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });	
		
		
		/** column 과세유형시작일자 : txtnFrmBgnnDt */
		listColumnDefs.add(new ColumnDef("시작일자", SysMtrSysm0051BM.ATTR_TXTNFRMBGNNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
				setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
			}
		});
		
		/** column 과세유형종료일자 : txtnFrmEndDt */
		listColumnDefs.add(new ColumnDef("종료일자", SysMtrSysm0051BM.ATTR_TXTNFRMENDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{
				setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
			}
		});
		
		/** column 과세유형내용 : txtnFrmCtnt */
		listColumnDefs.add(new ColumnDef("비 고", SysMtrSysm0051BM.ATTR_TXTNFRMCTNT, ColumnDef.TYPE_STRING , 90, false, true, true){
			{
		
			}
		});
		
		
//------------
		/** column 시스템사업장코드 : sysDpobCd */
		listColumnDefs.add(new ColumnDef("시스템사업장코드", SysMtrSysm0051BM.ATTR_SYSDPOBCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			{
		
			}
		});
		


///** column 입력자 : kybdr */
//listColumnDefs.add(new ColumnDef("입력자", SysMtrSysm0051BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 입력일자 : inptDt */
//listColumnDefs.add(new ColumnDef("입력일자", SysMtrSysm0051BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 입력주소 : inptAddr */
//listColumnDefs.add(new ColumnDef("입력주소", SysMtrSysm0051BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정자 : ismt */
//listColumnDefs.add(new ColumnDef("수정자", SysMtrSysm0051BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정일자 : revnDt */
//listColumnDefs.add(new ColumnDef("수정일자", SysMtrSysm0051BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
///** column 수정주소 : revnAddr */
//listColumnDefs.add(new ColumnDef("수정주소", SysMtrSysm0051BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	{
//
//	}
//});
//
//private TextField<String> sysDpobCd;   /** column 시스템사업장코드 : sysDpobCd */
//
//private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//private TextField<String> txtnFrmDivCd;   /** column 과세유형구분코드 : txtnFrmDivCd */
//
//private TextField<String> txtnFrmBgnnDt;   /** column 과세유형시작일자 : txtnFrmBgnnDt */
//
//private TextField<String> txtnFrmEndDt;   /** column 과세유형종료일자 : txtnFrmEndDt */
//
//private TextField<String> txtnFrmCtnt;   /** column 과세유형내용 : txtnFrmCtnt */
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
