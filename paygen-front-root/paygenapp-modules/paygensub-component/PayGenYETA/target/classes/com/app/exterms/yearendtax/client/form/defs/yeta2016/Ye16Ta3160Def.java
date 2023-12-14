package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3160BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Ye16Ta3160Def extends TableDef implements YetaDaoConstants{
	
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Ye16Ta3160Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETAP03004".equals(chkDef)) {
//		setTitle("임대차계약");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAP03004TOYETA3160_DATA_LIST);
	  	  	setAutoFillGrid(true);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaP03005ToYe16Ta3160()); 
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
	
	
	
	private List<ColumnDef> getColumnsListYetaP03005ToYe16Ta3160() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 임대차_임대인성명 : leasName */
        listColumnDefs.add(new ColumnDef("임대인성명", Ye16Ta3160BM.ATTR_LEASNAME, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 임대차_주민번호 : leasRsno */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta3160BM.ATTR_LEASRSNO, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y007");
        /** column 월세_주택유형코드 : mnrnTyhu */
        listColumnDefs.add(new ColumnListDef("주택유형",   Ye16Ta3160BM.ATTR_LEASTYHU,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        /** column 임대차_주택유형코드 : leasTyhu */
        listColumnDefs.add(new ColumnDef("주택유형코드", Ye16Ta3160BM.ATTR_LEASTYHU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_주책계약면적 : leasArea */
        listColumnDefs.add(new ColumnDef("계약면적", Ye16Ta3160BM.ATTR_LEASAREA, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 임대차_계약서상주소 : leasAddr */
        listColumnDefs.add(new ColumnDef("임대차계약서상주소", Ye16Ta3160BM.ATTR_LEASADDR, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 임대차_계약시작일자 : leasStdt */
        listColumnDefs.add(new ColumnDef("계약시작일자", Ye16Ta3160BM.ATTR_LEASSTDT, ColumnDef.TYPE_DATE , 90, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 임대차_계약종료일자 : leasEddt */
        listColumnDefs.add(new ColumnDef("계약종료일자", Ye16Ta3160BM.ATTR_LEASEDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 임대차_전세보증금액 : leasDpst */
        listColumnDefs.add(new ColumnDef("전세보증금(원)", Ye16Ta3160BM.ATTR_LEASDPST, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3160BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3160BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차일련번호 : leasSqno */
        listColumnDefs.add(new ColumnDef("임대차일련번호", Ye16Ta3160BM.ATTR_LEASSQNO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3160BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3160BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
          
          return listColumnDefs;
	}

	private List<ColumnDef> getColumnsList() {
	 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3160BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3160BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차일련번호 : leasSqno */
        listColumnDefs.add(new ColumnDef("임대차일련번호", Ye16Ta3160BM.ATTR_LEASSQNO, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3160BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3160BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_임대인성명 : leasName */
        listColumnDefs.add(new ColumnDef("임대차_임대인성명", Ye16Ta3160BM.ATTR_LEASNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_주민번호 : leasRsno */
        listColumnDefs.add(new ColumnDef("임대차_주민번호", Ye16Ta3160BM.ATTR_LEASRSNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_주택유형코드 : leasTyhu */
        listColumnDefs.add(new ColumnDef("임대차_주택유형코드", Ye16Ta3160BM.ATTR_LEASTYHU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_주책계약면적 : leasArea */
        listColumnDefs.add(new ColumnDef("임대차_주책계약면적", Ye16Ta3160BM.ATTR_LEASAREA, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_계약서상주소 : leasAddr */
        listColumnDefs.add(new ColumnDef("임대차_계약서상주소", Ye16Ta3160BM.ATTR_LEASADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_계약시작일자 : leasStdt */
        listColumnDefs.add(new ColumnDef("임대차_계약시작일자", Ye16Ta3160BM.ATTR_LEASSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_계약종료일자 : leasEddt */
        listColumnDefs.add(new ColumnDef("임대차_계약종료일자", Ye16Ta3160BM.ATTR_LEASEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차_전세보증금액 : leasDpst */
        listColumnDefs.add(new ColumnDef("임대차_전세보증금액", Ye16Ta3160BM.ATTR_LEASDPST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> leasSqno;   /** column 임대차일련번호 : leasSqno */
//
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> leasName;   /** column 임대차_임대인성명 : leasName */
//
//        private TextField<String> leasRsno;   /** column 임대차_주민번호 : leasRsno */
//
//        private TextField<String> leasTyhu;   /** column 임대차_주택유형코드 : leasTyhu */
//
//        private TextField<String> leasArea;   /** column 임대차_주책계약면적 : leasArea */
//
//        private TextField<String> leasAddr;   /** column 임대차_계약서상주소 : leasAddr */
//
//        private TextField<String> leasStdt;   /** column 임대차_계약시작일자 : leasStdt */
//
//        private TextField<String> leasEddt;   /** column 임대차_계약종료일자 : leasEddt */
//
//        private TextField<String> leasDpst;   /** column 임대차_전세보증금액 : leasDpst */
          
          return listColumnDefs;
	}

}
