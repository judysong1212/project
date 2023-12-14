package com.app.exterms.yearendtax.client.form.defs.yeta2015;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3190BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Yeta3190Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	
	public Yeta3190Def(String string) {
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
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3190BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3190BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3190BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3190BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부조정명세일련번호 : ctrbSeqn */
        listColumnDefs.add(new ColumnDef("기부조정명세일련번호", Yeta3190BM.ATTR_CTRBSEQN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부조정명세유형구분코드 : ctrbDdcd */
        listColumnDefs.add(new ColumnDef("기부조정명세유형구분코드", Yeta3190BM.ATTR_CTRBDDCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부조정명세유형코드 : ctrbTycd */
        listColumnDefs.add(new ColumnDef("기부조정명세유형코드", Yeta3190BM.ATTR_CTRBTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부조정명세기부연도 : ctrbYrmn */
        listColumnDefs.add(new ColumnDef("기부조정명세기부연도", Yeta3190BM.ATTR_CTRBYRMN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부조정명세기부금액 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부조정명세기부금액", Yeta3190BM.ATTR_CTRBAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전년도_공제금액 : bfyrDeam */
        listColumnDefs.add(new ColumnDef("전년도_공제금액", Yeta3190BM.ATTR_BFYRDEAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상금액 : detrAmnt */
        listColumnDefs.add(new ColumnDef("공제대상금액", Yeta3190BM.ATTR_DETRAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당연도공제금액 : dyyrDeam */
        listColumnDefs.add(new ColumnDef("해당연도공제금액", Yeta3190BM.ATTR_DYYRDEAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당년도_미공제소멸금액 : dyyrOtam */
        listColumnDefs.add(new ColumnDef("해당년도_미공제소멸금액", Yeta3190BM.ATTR_DYYROTAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 해당년도_미공제이월금액 : ayyrNtam */
        listColumnDefs.add(new ColumnDef("해당년도_미공제이월금액", Yeta3190BM.ATTR_AYYRNTAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3190BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3190BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3190BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3190BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3190BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3190BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> ctrbSeqn;   /** column 기부조정명세일련번호 : ctrbSeqn */
//
//        private TextField<String> ctrbDdcd;   /** column 기부조정명세유형구분코드 : ctrbDdcd */
//
//        private TextField<String> ctrbTycd;   /** column 기부조정명세유형코드 : ctrbTycd */
//
//        private TextField<String> ctrbYrmn;   /** column 기부조정명세기부연도 : ctrbYrmn */
//
//        private TextField<String> ctrbAmnt;   /** column 기부조정명세기부금액 : ctrbAmnt */
//
//        private TextField<String> bfyrDeam;   /** column 전년도_공제금액 : bfyrDeam */
//
//        private TextField<String> detrAmnt;   /** column 공제대상금액 : detrAmnt */
//
//        private TextField<String> dyyrDeam;   /** column 해당연도공제금액 : dyyrDeam */
//
//        private TextField<String> dyyrOtam;   /** column 해당년도_미공제소멸금액 : dyyrOtam */
//
//        private TextField<String> ayyrNtam;   /** column 해당년도_미공제이월금액 : ayyrNtam */
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

}
