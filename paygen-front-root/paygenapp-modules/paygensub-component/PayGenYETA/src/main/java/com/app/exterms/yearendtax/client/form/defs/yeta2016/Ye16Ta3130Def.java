package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3130BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Ye16Ta3130Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Ye16Ta3130Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
//		if("YETAP03004".equals(chkDef)) {
////		setTitle("임대차계약");
//		setTitle("");
//        setDaoClass("");
//        setCustomListMethod(CLASS_YETAP03004TOYETA3130_DATA_LIST);
//  	  	setAutoFillGrid(false);
//        setShowFilterToolbar(false);   
//        setCheckBoxOnGridRows(true); 
//	    setEditFieldGrid(true);
//	    setColumnsDefinition(getColumnsListYetaP03004ToYeta03130()); 
//		}else 
		if("YETAP13005".equals(chkDef)) {
//			setTitle("월세액소득공제명세");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAP03005TOYETA3130_DATA_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaP03005ToYe16Ta3130()); 
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

        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3130BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3130BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세일련번호 : mnrnSqno */
        listColumnDefs.add(new ColumnDef("월세일련번호", Ye16Ta3130BM.ATTR_MNRNSQNO, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3130BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3130BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_임대인성명 : mnrnName */
        listColumnDefs.add(new ColumnDef("월세_임대인성명", Ye16Ta3130BM.ATTR_MNRNNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_주민번호 : mnrnRsno */
        listColumnDefs.add(new ColumnDef("월세_주민번호", Ye16Ta3130BM.ATTR_MNRNRSNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_주택유형코드 : mnrnTyhu */
        listColumnDefs.add(new ColumnDef("월세_주택유형코드", Ye16Ta3130BM.ATTR_MNRNTYHU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세주택계약면적 : mnrnArea */
        listColumnDefs.add(new ColumnDef("월세주택계약면적", Ye16Ta3130BM.ATTR_MNRNAREA, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_계약서상주소 : mnrnAddr */
        listColumnDefs.add(new ColumnDef("월세_계약서상주소", Ye16Ta3130BM.ATTR_MNRNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_임대차계약시작일자 : mnrnStdt */
        listColumnDefs.add(new ColumnDef("월세_임대차계약시작일자", Ye16Ta3130BM.ATTR_MNRNSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_임대차계약종료일자 : mnrnEddt */
        listColumnDefs.add(new ColumnDef("월세_임대차계약종료일자", Ye16Ta3130BM.ATTR_MNRNEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_연간월세금액 : mnrnAmnt */
        listColumnDefs.add(new ColumnDef("월세_연간월세금액", Ye16Ta3130BM.ATTR_MNRNAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_월세세액공제금액 : mnrnDuam */
        listColumnDefs.add(new ColumnDef("월세_월세세액공제금액", Ye16Ta3130BM.ATTR_MNRNDUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3130BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3130BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3130BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3130BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3130BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3130BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> mnrnSqno;   /** column 월세일련번호 : mnrnSqno */
//
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> mnrnName;   /** column 월세_임대인성명 : mnrnName */
//
//        private TextField<String> mnrnRsno;   /** column 월세_주민번호 : mnrnRsno */
//
//        private TextField<String> mnrnTyhu;   /** column 월세_주택유형코드 : mnrnTyhu */
//
//        private TextField<String> mnrnArea;   /** column 월세주택계약면적 : mnrnArea */
//
//        private TextField<String> mnrnAddr;   /** column 월세_계약서상주소 : mnrnAddr */
//
//        private TextField<String> mnrnStdt;   /** column 월세_임대차계약시작일자 : mnrnStdt */
//
//        private TextField<String> mnrnEddt;   /** column 월세_임대차계약종료일자 : mnrnEddt */
//
//        private TextField<String> mnrnAmnt;   /** column 월세_연간월세금액 : mnrnAmnt */
//
//        private TextField<String> mnrnDuam;   /** column 월세_월세세액공제금액 : mnrnDuam */
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
       

          
          return listColumnDefs;
	}
	
	
	
	private List<ColumnDef> getColumnsListYetaP03004ToYeta03130() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3130BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3130BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 월세_임대인성명 : mnrnName */
        listColumnDefs.add(new ColumnDef("임대인성명", Ye16Ta3130BM.ATTR_MNRNNAME, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        /** column 월세_주민번호 : mnrnRsno */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta3130BM.ATTR_MNRNRSNO, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y007");
        /** column 월세_주택유형코드 : mnrnTyhu */
        listColumnDefs.add(new ColumnListDef("주택유형",   Ye16Ta3130BM.ATTR_MNRNTYHU,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        listColumnDefs.add(new ColumnDef("주택유형", Ye16Ta3130BM.ATTR_MNRNTYHUNM, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        /** column 월세주택계약면적 : mnrnArea */
        listColumnDefs.add(new ColumnDef("주택계약면적(㎡)", Ye16Ta3130BM.ATTR_MNRNAREA, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 월세_계약서상주소 : mnrnAddr */
        listColumnDefs.add(new ColumnDef("임대차계약서상주소지", Ye16Ta3130BM.ATTR_MNRNADDR, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        /** column 월세_임대차계약시작일자 : mnrnStdt */
        listColumnDefs.add(new ColumnDef("개시일", Ye16Ta3130BM.ATTR_MNRNSTDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 월세_임대차계약종료일자 : mnrnEddt */
        listColumnDefs.add(new ColumnDef("종료일", Ye16Ta3130BM.ATTR_MNRNEDDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 월세_연간월세금액 : mnrnAmnt */
        listColumnDefs.add(new ColumnDef("월세금액", Ye16Ta3130BM.ATTR_MNRNAMNT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        
        
        

        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3130BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3130BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세일련번호 : mnrnSqno */
        listColumnDefs.add(new ColumnDef("월세일련번호", Ye16Ta3130BM.ATTR_MNRNSQNO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });


        /** column 월세_월세세액공제금액 : mnrnDuam */
        listColumnDefs.add(new ColumnDef("월세_월세세액공제금액", Ye16Ta3130BM.ATTR_MNRNDUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3130BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3130BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3130BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3130BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3130BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3130BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

          
        return listColumnDefs;
	}
	
	
	private List<ColumnDef> getColumnsListYetaP03005ToYe16Ta3130() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3130BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3130BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 월세_임대인성명 : mnrnName */
        listColumnDefs.add(new ColumnDef("임대인성명", Ye16Ta3130BM.ATTR_MNRNNAME, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        /** column 월세_주민번호 : mnrnRsno */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta3130BM.ATTR_MNRNRSNO, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 월세_주택유형코드 : mnrnTyhu */
        sysComBass0300Dto.setRpsttvCd("Y007");
        listColumnDefs.add(new ColumnListDef("주택유형",   Ye16Ta3130BM.ATTR_MNRNTYHU,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        listColumnDefs.add(new ColumnDef("주택유형", Ye16Ta3130BM.ATTR_MNRNTYHU, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        /** column 월세주택계약면적 : mnrnArea */
        listColumnDefs.add(new ColumnDef("주택계약면적(㎡)", Ye16Ta3130BM.ATTR_MNRNAREA, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 월세_계약서상주소 : mnrnAddr */
        listColumnDefs.add(new ColumnDef("임대차계약서상주소지", Ye16Ta3130BM.ATTR_MNRNADDR, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        /** column 월세_임대차계약시작일자 : mnrnStdt */
        listColumnDefs.add(new ColumnDef("개시일", Ye16Ta3130BM.ATTR_MNRNSTDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 월세_임대차계약종료일자 : mnrnEddt */
        listColumnDefs.add(new ColumnDef("종료일", Ye16Ta3130BM.ATTR_MNRNEDDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 월세_연간월세금액 : mnrnAmnt */
        listColumnDefs.add(new ColumnDef("연간월세액(원)", Ye16Ta3130BM.ATTR_MNRNAMNT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 월세_월세세액공제금액 : mnrnDuam */
        listColumnDefs.add(new ColumnDef("공제금액(원)", Ye16Ta3130BM.ATTR_MNRNDUAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
//        		setReadOnly(true);
        	}
        });
        
        //---------

        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3130BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3130BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세일련번호 : mnrnSqno */
        listColumnDefs.add(new ColumnDef("월세일련번호", Ye16Ta3130BM.ATTR_MNRNSQNO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });


        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3130BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3130BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3130BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3130BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3130BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3130BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

          
        return listColumnDefs;
	}

}
