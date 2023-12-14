package com.app.exterms.yearendtax.client.form.defs.yeta2015;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3210BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Yeta3210Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Yeta3210Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETAP03009".equals(chkDef)) {
//	 		setTitle("현비과세및감면등록"); 
	        setDaoClass("");
//	        setCustomListMethod("");
//	        setCustomListMethod(CLASS_YETA0100TOYETA3210_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaP03009ToYeta3210()); 
		}else {
//			setTitle("현근무지급여지급명세"); 
	        setDaoClass("");
//	        setCustomListMethod("");
//	        setCustomListMethod(CLASS_YETA0100TOYETA3210_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsList()); 
		}
	}
	

	private List<ColumnDef> getColumnsList() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3210BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3210BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3210BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 지급년월 : elctYymm */
        listColumnDefs.add(new ColumnDef("지급년월", Yeta3210BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3210BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급일자 : elctDate */
        listColumnDefs.add(new ColumnDef("급여지급일자", Yeta3210BM.ATTR_ELCTDATE, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 급여지급금액_과세 : suprTxam */
        listColumnDefs.add(new ColumnDef("급여지급금액_과세", Yeta3210BM.ATTR_SUPRTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 상여금_과세 : buamTxam */
        listColumnDefs.add(new ColumnDef("상여금_과세", Yeta3210BM.ATTR_BUAMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 인정상여금액 : inbsAmnt */
        listColumnDefs.add(new ColumnDef("인정상여금액", Yeta3210BM.ATTR_INBSAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 주식행사이익금액 : stckInam */
        listColumnDefs.add(new ColumnDef("주식행사이익금액", Yeta3210BM.ATTR_STCKINAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 급여_상여합계금액 : spbmTxam */
        listColumnDefs.add(new ColumnDef("급여_상여합계금액", Yeta3210BM.ATTR_SPBMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 외국인소득금액_과세 : ecinTxam */
        listColumnDefs.add(new ColumnDef("외국인소득금액_과세", Yeta3210BM.ATTR_ECINTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 외국인소득금액_비과세 : taxmEcin */
        listColumnDefs.add(new ColumnDef("외국인소득금액_비과세", Yeta3210BM.ATTR_TAXMECIN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 자가운전보조금_비과세 : taxmEarn */
        listColumnDefs.add(new ColumnDef("자가운전보조금_비과세", Yeta3210BM.ATTR_TAXMEARN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_비과세 : taxmEtam */
        listColumnDefs.add(new ColumnDef("정액급식비_비과세", Yeta3210BM.ATTR_TAXMETAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_과세 : txetTxam */
        listColumnDefs.add(new ColumnDef("정액급식비_과세", Yeta3210BM.ATTR_TXETTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 출산보육수당_비과세 : addrBhtx */
        listColumnDefs.add(new ColumnDef("출산보육수당_비과세", Yeta3210BM.ATTR_ADDRBHTX, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 건강보험료금액 : spciHlth */
        listColumnDefs.add(new ColumnDef("건강보험료금액", Yeta3210BM.ATTR_SPCIHLTH, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 고용보험료금액 : spciEmpf */
        listColumnDefs.add(new ColumnDef("고용보험료금액", Yeta3210BM.ATTR_SPCIEMPF, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금금액 : natnPsnf */
        listColumnDefs.add(new ColumnDef("국민연금금액", Yeta3210BM.ATTR_NATNPSNF, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 소득세 : earnTaxn */
        listColumnDefs.add(new ColumnDef("소득세", Yeta3210BM.ATTR_EARNTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 지방소득세 : ihtxTaxn */
        listColumnDefs.add(new ColumnDef("지방소득세", Yeta3210BM.ATTR_IHTXTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 기타금액_과세 : etccTxam */
        listColumnDefs.add(new ColumnDef("기타금액_과세", Yeta3210BM.ATTR_ETCCTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 기타금액_비과세 : etccEtam */
        listColumnDefs.add(new ColumnDef("기타금액_비과세", Yeta3210BM.ATTR_ETCCETAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3210BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3210BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3210BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3210BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3210BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3210BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> elctYymm;   /** column 지급년월 : elctYymm */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> elctDate;   /** column 급여지급일자 : elctDate */
//
//        private TextField<String> suprTxam;   /** column 급여지급금액_과세 : suprTxam */
//
//        private TextField<String> buamTxam;   /** column 상여금_과세 : buamTxam */
//
//        private TextField<String> inbsAmnt;   /** column 인정상여금액 : inbsAmnt */
//
//        private TextField<String> stckInam;   /** column 주식행사이익금액 : stckInam */
//
//        private TextField<String> spbmTxam;   /** column 급여_상여합계금액 : spbmTxam */
//
//        private TextField<String> ecinTxam;   /** column 외국인소득금액_과세 : ecinTxam */
//
//        private TextField<String> taxmEcin;   /** column 외국인소득금액_비과세 : taxmEcin */
//
//        private TextField<String> taxmEarn;   /** column 자가운전보조금_비과세 : taxmEarn */
//
//        private TextField<String> taxmEtam;   /** column 정액급식비_비과세 : taxmEtam */
//
//        private TextField<String> txetTxam;   /** column 정액급식비_과세 : txetTxam */
//
//        private TextField<String> addrBhtx;   /** column 출산보육수당_비과세 : addrBhtx */
//
//        private TextField<String> spciHlth;   /** column 건강보험료금액 : spciHlth */
//
//        private TextField<String> spciEmpf;   /** column 고용보험료금액 : spciEmpf */
//
//        private TextField<String> natnPsnf;   /** column 국민연금금액 : natnPsnf */
//
//        private TextField<String> earnTaxn;   /** column 소득세 : earnTaxn */
//
//        private TextField<String> ihtxTaxn;   /** column 지방소득세 : ihtxTaxn */
//
//        private TextField<String> etccTxam;   /** column 기타금액_과세 : etccTxam */
//
//        private TextField<String> etccEtam;   /** column 기타금액_비과세 : etccEtam */
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
	
	
	private List<ColumnDef> getColumnsListYetaP03009ToYeta3210() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3210BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("정산년도", Yeta3210BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y002");
        /** column 정산구분코드 : settGbcd */
        
        listColumnDefs.add(new ColumnListDef("정산구분",   Yeta3210BM.ATTR_SETTGBCD,   ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3210BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Yeta3210BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 지급년월 : elctYymm */
        listColumnDefs.add(new ColumnDef("지급년월", Yeta3210BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3210BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급일자 : elctDate */
        listColumnDefs.add(new ColumnDef("급여지급일자", Yeta3210BM.ATTR_ELCTDATE, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여지급금액_과세 : suprTxam */
        listColumnDefs.add(new ColumnDef("급여지급금액_과세", Yeta3210BM.ATTR_SUPRTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여_상여합계금액 : spbmTxam */
        listColumnDefs.add(new ColumnDef("상여합계", Yeta3210BM.ATTR_SPBMTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 소득세 : earnTaxn */
        listColumnDefs.add(new ColumnDef("소득세", Yeta3210BM.ATTR_EARNTAXN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 지방소득세 : ihtxTaxn */
        listColumnDefs.add(new ColumnDef("지방소득세", Yeta3210BM.ATTR_IHTXTAXN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        

        /** column 상여금_과세 : buamTxam */
        listColumnDefs.add(new ColumnDef("상여금_과세", Yeta3210BM.ATTR_BUAMTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 인정상여금액 : inbsAmnt */
        listColumnDefs.add(new ColumnDef("인정상여금액", Yeta3210BM.ATTR_INBSAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 주식행사이익금액 : stckInam */
        listColumnDefs.add(new ColumnDef("주식행사이익금액", Yeta3210BM.ATTR_STCKINAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });

        /** column 외국인소득금액_과세 : ecinTxam */
        listColumnDefs.add(new ColumnDef("외국인소득금액_과세", Yeta3210BM.ATTR_ECINTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 외국인소득금액_비과세 : taxmEcin */
        listColumnDefs.add(new ColumnDef("외국인소득금액_비과세", Yeta3210BM.ATTR_TAXMECIN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 자가운전보조금_비과세 : taxmEarn */
        listColumnDefs.add(new ColumnDef("자가운전보조금_비과세", Yeta3210BM.ATTR_TAXMEARN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_비과세 : taxmEtam */
        listColumnDefs.add(new ColumnDef("정액급식비_비과세", Yeta3210BM.ATTR_TAXMETAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_과세 : txetTxam */
        listColumnDefs.add(new ColumnDef("정액급식비_과세", Yeta3210BM.ATTR_TXETTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 출산보육수당_비과세 : addrBhtx */
        listColumnDefs.add(new ColumnDef("출산보육수당_비과세", Yeta3210BM.ATTR_ADDRBHTX, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 건강보험료금액 : spciHlth */
        listColumnDefs.add(new ColumnDef("건강보험료금액", Yeta3210BM.ATTR_SPCIHLTH, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 고용보험료금액 : spciEmpf */
        listColumnDefs.add(new ColumnDef("고용보험료금액", Yeta3210BM.ATTR_SPCIEMPF, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금금액 : natnPsnf */
        listColumnDefs.add(new ColumnDef("국민연금금액", Yeta3210BM.ATTR_NATNPSNF, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });

        /** column 기타금액_과세 : etccTxam */
        listColumnDefs.add(new ColumnDef("기타금액_과세", Yeta3210BM.ATTR_ETCCTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 기타금액_비과세 : etccEtam */
        listColumnDefs.add(new ColumnDef("기타금액_비과세", Yeta3210BM.ATTR_ETCCETAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3210BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3210BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3210BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3210BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3210BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3210BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
	return listColumnDefs;
	}

}
