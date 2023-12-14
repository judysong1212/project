package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3120BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Ye16Ta3120Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	public Ye16Ta3120Def(String chkDef) {
		
		if("YETAP03004".equals(chkDef)) {
//		setTitle("금전소비대차계약");
		setTitle("");
        setDaoClass("");
        setCustomListMethod(CLASS_YETAP03004TOYETA3120_DATA_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(true); 
	    setEditFieldGrid(true);
	    setColumnsDefinition(getColumnsListYetaP03004ToYeta03120()); 
		}else {
			setTitle("연말정산대상자 및 내역");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
//	        setCustomListMethod(CLASS_YETA0100_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsList()); 
		}
	}

	private List<ColumnDef> getColumnsList() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3120BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3120BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차일련번호 : cnclSqno */
        listColumnDefs.add(new ColumnDef("금전소비대차일련번호", Ye16Ta3120BM.ATTR_CNCLSQNO, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3120BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3120BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_임대인성명 : cnclName */
        listColumnDefs.add(new ColumnDef("금전소비대차_임대인성명", Ye16Ta3120BM.ATTR_CNCLNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_주민번호 : cnclRsno */
        listColumnDefs.add(new ColumnDef("금전소비대차_주민번호", Ye16Ta3120BM.ATTR_CNCLRSNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_계약시작일자 : cnclStdt */
        listColumnDefs.add(new ColumnDef("금전소비대차_계약시작일자", Ye16Ta3120BM.ATTR_CNCLSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_계약종료일자 : cnclEddt */
        listColumnDefs.add(new ColumnDef("금전소비대차_계약종료일자", Ye16Ta3120BM.ATTR_CNCLEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_차입금이자율 : cnclItro */
        listColumnDefs.add(new ColumnDef("금전소비대차_차입금이자율", Ye16Ta3120BM.ATTR_CNCLITRO, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금상환액계 : cnclRdmt */
        listColumnDefs.add(new ColumnDef("금전소비대차_원리금상환액계", Ye16Ta3120BM.ATTR_CNCLRDMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금 : cnclPrpl */
        listColumnDefs.add(new ColumnDef("금전소비대차_원리금", Ye16Ta3120BM.ATTR_CNCLPRPL, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_이자 : cnclItrt */
        listColumnDefs.add(new ColumnDef("금전소비대차_이자", Ye16Ta3120BM.ATTR_CNCLITRT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차_공제금액 : cnclDuam */
        listColumnDefs.add(new ColumnDef("금전소비대차_공제금액", Ye16Ta3120BM.ATTR_CNCLDUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3120BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3120BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3120BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3120BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3120BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3120BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> cnclSqno;   /** column 금전소비대차일련번호 : cnclSqno */
//
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> cnclName;   /** column 금전소비대차_임대인성명 : cnclName */
//
//        private TextField<String> cnclRsno;   /** column 금전소비대차_주민번호 : cnclRsno */
//
//        private TextField<String> cnclStdt;   /** column 금전소비대차_계약시작일자 : cnclStdt */
//
//        private TextField<String> cnclEddt;   /** column 금전소비대차_계약종료일자 : cnclEddt */
//
//        private TextField<String> cnclItro;   /** column 금전소비대차_차입금이자율 : cnclItro */
//
//        private TextField<String> cnclRdmt;   /** column 금전소비대차_원리금상환액계 : cnclRdmt */
//
//        private TextField<String> cnclPrpl;   /** column 금전소비대차_원리금 : cnclPrpl */
//
//        private TextField<String> cnclItrt;   /** column 금전소비대차_이자 : cnclItrt */
//
//        private TextField<String> cnclDuam;   /** column 금전소비대차_공제금액 : cnclDuam */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//       
          
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getColumnsListYetaP03004ToYeta03120() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3120BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3120BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 금전소비대차_임대인성명 : cnclName */
        listColumnDefs.add(new ColumnDef("대주성명", Ye16Ta3120BM.ATTR_CNCLNAME, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 금전소비대차_주민번호 : cnclRsno */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta3120BM.ATTR_CNCLRSNO, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 금전소비대차_계약시작일자 : cnclStdt */
        listColumnDefs.add(new ColumnDef("계약시작일", Ye16Ta3120BM.ATTR_CNCLSTDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 금전소비대차_계약종료일자 : cnclEddt */
        listColumnDefs.add(new ColumnDef("계약종료일", Ye16Ta3120BM.ATTR_CNCLEDDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 금전소비대차_차입금이자율 : cnclItro */
        listColumnDefs.add(new ColumnDef("이자율", Ye16Ta3120BM.ATTR_CNCLITRO, ColumnDef.TYPE_DOUBLE , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금상환액계 : cnclRdmt */
        listColumnDefs.add(new ColumnDef("상환액계", Ye16Ta3120BM.ATTR_CNCLRDMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금 : cnclPrpl */
        listColumnDefs.add(new ColumnDef("원금", Ye16Ta3120BM.ATTR_CNCLPRPL, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_이자 : cnclItrt */
        listColumnDefs.add(new ColumnDef("이자", Ye16Ta3120BM.ATTR_CNCLITRT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_공제금액 : cnclDuam */
        listColumnDefs.add(new ColumnDef("공제금액", Ye16Ta3120BM.ATTR_CNCLDUAM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
//        		setReadOnly(true);
        	}
        });
        
        
        

        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3120BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3120BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차일련번호 : cnclSqno */
        listColumnDefs.add(new ColumnDef("금전소비대차일련번호", Ye16Ta3120BM.ATTR_CNCLSQNO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
     

      
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3120BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3120BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3120BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3120BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3120BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3120BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        return listColumnDefs;
	}

}
