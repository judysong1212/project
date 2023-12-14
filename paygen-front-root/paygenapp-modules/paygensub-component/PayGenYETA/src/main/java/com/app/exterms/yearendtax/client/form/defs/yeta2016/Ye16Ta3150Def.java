package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3150BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta3150Def extends TableDef implements YetaDaoConstants{
	
	private int row = 0;
	
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Ye16Ta3150Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		
		if("YETA315001".equals(chkDef)) {
	//		setTitle("가족교육비");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setCustomListMethod(CLASS_YETA1300To3150_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYeta0300ToYeta03150());
	    
		}else {
			setTitle("연말정산대상자 및 내역");
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

        /** column 교육비가족상세일련번호 : edacDtnu */
        listColumnDefs.add(new ColumnDef("교육비가족상세일련번호", Ye16Ta3150BM.ATTR_EDACDTNU, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3150BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3150BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3150BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 가족학력구분코드 : fmacGbcd */
        listColumnDefs.add(new ColumnDef("가족학력구분코드", Ye16Ta3150BM.ATTR_FMACGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비지급금액 : edacOtam */
        listColumnDefs.add(new ColumnDef("교육비지급금액", Ye16Ta3150BM.ATTR_EDACOTAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });

        /** column 가족주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("가족주민등록번호", Ye16Ta3150BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 국세청자료여부 : guksYeno */
        listColumnDefs.add(new ColumnDef("국세청자료여부", Ye16Ta3150BM.ATTR_GUKSYENO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
//        private TextField<String> edacDtnu;   /** column 교육비가족상세일련번호 : edacDtnu */
//
//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> fmacGbcd;   /** column 가족학력구분코드 : fmacGbcd */
//
//        private TextField<String> edacOtam;   /** column 교육비지급금액 : edacOtam */
       

          
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getColumnsListYeta0300ToYeta03150() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 교육비가족상세일련번호 : edacDtnu */
        listColumnDefs.add(new ColumnDef("순번", Ye16Ta3150BM.ATTR_EDACDTNU, ColumnDef.TYPE_LONG , 40, true, false, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Ye16Ta3150BM.ATTR_KORNNAME, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y003");
        /** column 가족학력구분코드 : fmacGbcd */
        listColumnDefs.add(new ColumnListDef("교육구분",   Ye16Ta3150BM.ATTR_FMACGBCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
//        listColumnDefs.add(new ColumnDef("교육구분", Ye16Ta3150BM.ATTR_FMACGBCD, ColumnDef.TYPE_STRING , 100, true, true, true){
//        	{
//
//        	}
//        });
        /** column 교육비지급금액 : edacOtam */
        listColumnDefs.add(new ColumnDef("지출금액", Ye16Ta3150BM.ATTR_EDACOTAM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 국세청자료여부 : guksYeno */
        listColumnDefs.add(new ColumnDef("국세청", Ye16Ta3150BM.ATTR_GUKSYENO, ColumnDef.TYPE_BOOLEAN ,50, true, true, true){
        	{

        	}
        });
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3150BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3150BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3150BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 가족주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("가족주민등록번호", Ye16Ta3150BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
          
          return listColumnDefs;
	}


}
