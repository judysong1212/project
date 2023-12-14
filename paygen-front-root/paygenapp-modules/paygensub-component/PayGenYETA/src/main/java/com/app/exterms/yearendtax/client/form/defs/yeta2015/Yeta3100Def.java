package com.app.exterms.yearendtax.client.form.defs.yeta2015;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3100BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Yeta3100Def extends TableDef implements YetaDaoConstants{
	
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	private int row = 0;
	
	public Yeta3100Def(String chkDef) {
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		
		
		if("YETAP03007".equals(chkDef)) {
//		setTitle("연금저축소득공제");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAP03007TOYETA3100_DATA_LIST);
	  	  	setAutoFillGrid(true);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaP03007ToYeta03100()); 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3100BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3100BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금_저축일련번호 : finaSeqn */
        listColumnDefs.add(new ColumnDef("연금_저축일련번호", Yeta3100BM.ATTR_FINASEQN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제구분코드 : imdeGbcd */
        listColumnDefs.add(new ColumnDef("소득공제구분코드", Yeta3100BM.ATTR_IMDEGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금융기관코드 : finaCode */
        listColumnDefs.add(new ColumnDef("금융기관코드", Yeta3100BM.ATTR_FINACODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금융기관상호 : finaName */
        listColumnDefs.add(new ColumnDef("금융기관상호", Yeta3100BM.ATTR_FINANAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 계좌번호 : acntNumb */
        listColumnDefs.add(new ColumnDef("계좌번호", Yeta3100BM.ATTR_ACNTNUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 납입연차 : icnmYear */
        listColumnDefs.add(new ColumnDef("납입연차", Yeta3100BM.ATTR_ICNMYEAR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 불입금액 : paytAmnt */
        listColumnDefs.add(new ColumnDef("불입금액", Yeta3100BM.ATTR_PAYTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제금액 : deduAmnt */
        listColumnDefs.add(new ColumnDef("세액공제금액", Yeta3100BM.ATTR_DEDUAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제구분국세청코드 : imdeTxcd */
        listColumnDefs.add(new ColumnDef("소득공제구분국세청코드", Yeta3100BM.ATTR_IMDETXCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금융기관국세청코드 : finaTxcd */
        listColumnDefs.add(new ColumnDef("금융기관국세청코드", Yeta3100BM.ATTR_FINATXCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> finaSeqn;   /** column 연금_저축일련번호 : finaSeqn */
//
//        private TextField<String> imdeGbcd;   /** column 소득공제구분코드 : imdeGbcd */
//
//        private TextField<String> finaCode;   /** column 금융기관코드 : finaCode */
//
//        private TextField<String> finaName;   /** column 금융기관상호 : finaName */
//
//        private TextField<String> acntNumb;   /** column 계좌번호 : acntNumb */
//
//        private TextField<String> icnmYear;   /** column 납입연차 : icnmYear */
//
//        private TextField<String> paytAmnt;   /** column 불입금액 : paytAmnt */
//
//        private TextField<String> deduAmnt;   /** column 세액공제금액 : deduAmnt */
//
//        private TextField<String> imdeTxcd;   /** column 소득공제구분국세청코드 : imdeTxcd */
//
//        private TextField<String> finaTxcd;   /** column 금융기관국세청코드 : finaTxcd */
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
	
	
	
	private List<ColumnDef> getColumnsListYetaP03007ToYeta03100() {
		
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y004"); 
        listColumnDefs.add(new ColumnListDef("연금/저축명",   Yeta3100BM.ATTR_IMDEGBCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        /** column 소득공제구분코드 : imdeGbcd */
        listColumnDefs.add(new ColumnDef("소득공제구분코드", Yeta3100BM.ATTR_IMDEGBCD, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y005"); 
        /** column 금융기관코드 : finaCode */
        listColumnDefs.add(new ColumnListDef("금융회사등명", Yeta3100BM.ATTR_FINACODE, ColumnDef.TYPE_STRING , 100, true, true, true, new LookupPrgmComBass0300(sysComBass0300Dto), PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        														
//        listColumnDefs.add(new ColumnDef("금융회사등명", Yeta3100BM.ATTR_FINACODE, ColumnDef.TYPE_STRING , 100, true, true, true){
//        	{
//
//        	}
//        });
        
        /** column 계좌번호 : acntNumb */
        listColumnDefs.add(new ColumnDef("계좌번호", Yeta3100BM.ATTR_ACNTNUMB, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 납입연차 : icnmYear */
        listColumnDefs.add(new ColumnDef("납입연차", Yeta3100BM.ATTR_ICNMYEAR, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 불입금액 : paytAmnt */
        listColumnDefs.add(new ColumnDef("불입금액", Yeta3100BM.ATTR_PAYTAMNT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        
        //---
        
        /** column 연금_저축일련번호 : finaSeqn */
        listColumnDefs.add(new ColumnDef("연금_저축일련번호", Yeta3100BM.ATTR_FINASEQN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 금융기관상호 : finaName */
        listColumnDefs.add(new ColumnDef("금융기관상호", Yeta3100BM.ATTR_FINANAME, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3100BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3100BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        


        /** column 소득공제구분국세청코드 : imdeTxcd */
        listColumnDefs.add(new ColumnDef("소득공제구분국세청코드", Yeta3100BM.ATTR_IMDETXCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

  
        /** column 세액공제금액 : deduAmnt */
        listColumnDefs.add(new ColumnDef("세액공제금액", Yeta3100BM.ATTR_DEDUAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });

        /** column 금융기관국세청코드 : finaTxcd */
        listColumnDefs.add(new ColumnDef("금융기관국세청코드", Yeta3100BM.ATTR_FINATXCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        return listColumnDefs;
	}

}
