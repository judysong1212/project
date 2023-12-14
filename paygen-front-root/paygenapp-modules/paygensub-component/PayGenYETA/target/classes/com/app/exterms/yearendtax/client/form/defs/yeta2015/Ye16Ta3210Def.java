package com.app.exterms.yearendtax.client.form.defs.yeta2015;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2015.Ye16Ta3210BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta3210Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Ye16Ta3210Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETAP13009".equals(chkDef)) {
//	 		setTitle("현비과세및감면등록"); 
	        setDaoClass("");
//	        setCustomListMethod("");
//	        setCustomListMethod(CLASS_YETA0100TOYETA3210_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaP03009ToYe16Ta3210()); 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3210BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3210BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3210BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 지급년월 : elctYymm */
        listColumnDefs.add(new ColumnDef("지급년월", Ye16Ta3210BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3210BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급일자 : elctDate */
        listColumnDefs.add(new ColumnDef("급여지급일자", Ye16Ta3210BM.ATTR_ELCTDATE, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 급여지급금액_과세 : suprTxam */
        listColumnDefs.add(new ColumnDef("급여지급금액_과세", Ye16Ta3210BM.ATTR_SUPRTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 상여금_과세 : buamTxam */
        listColumnDefs.add(new ColumnDef("상여금_과세", Ye16Ta3210BM.ATTR_BUAMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 인정상여금액 : inbsAmnt */
        listColumnDefs.add(new ColumnDef("인정상여금액", Ye16Ta3210BM.ATTR_INBSAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 주식행사이익금액 : stckInam */
        listColumnDefs.add(new ColumnDef("주식행사이익금액", Ye16Ta3210BM.ATTR_STCKINAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 급여_상여합계금액 : spbmTxam */
        listColumnDefs.add(new ColumnDef("급여_상여합계금액", Ye16Ta3210BM.ATTR_SPBMTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 외국인소득금액_과세 : ecinTxam */
        listColumnDefs.add(new ColumnDef("외국인소득금액_과세", Ye16Ta3210BM.ATTR_ECINTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 외국인소득금액_비과세 : taxmEcin */
        listColumnDefs.add(new ColumnDef("외국인소득금액_비과세", Ye16Ta3210BM.ATTR_TAXMECIN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 자가운전보조금_비과세 : taxmEarn */
        listColumnDefs.add(new ColumnDef("자가운전보조금_비과세", Ye16Ta3210BM.ATTR_TAXMEARN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_비과세 : taxmEtam */
        listColumnDefs.add(new ColumnDef("정액급식비_비과세", Ye16Ta3210BM.ATTR_TAXMETAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_과세 : txetTxam */
        listColumnDefs.add(new ColumnDef("정액급식비_과세", Ye16Ta3210BM.ATTR_TXETTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 출산보육수당_비과세 : addrBhtx */
        listColumnDefs.add(new ColumnDef("출산보육수당_비과세", Ye16Ta3210BM.ATTR_ADDRBHTX, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 건강보험료금액 : spciHlth */
        listColumnDefs.add(new ColumnDef("건강보험료금액", Ye16Ta3210BM.ATTR_SPCIHLTH, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 고용보험료금액 : spciEmpf */
        listColumnDefs.add(new ColumnDef("고용보험료금액", Ye16Ta3210BM.ATTR_SPCIEMPF, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금금액 : natnPsnf */
        listColumnDefs.add(new ColumnDef("국민연금금액", Ye16Ta3210BM.ATTR_NATNPSNF, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 소득세 : earnTaxn */
        listColumnDefs.add(new ColumnDef("소득세", Ye16Ta3210BM.ATTR_EARNTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 지방소득세 : ihtxTaxn */
        listColumnDefs.add(new ColumnDef("지방소득세", Ye16Ta3210BM.ATTR_IHTXTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 기타금액_과세 : etccTxam */
        listColumnDefs.add(new ColumnDef("기타금액_과세", Ye16Ta3210BM.ATTR_ETCCTXAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 기타금액_비과세 : etccEtam */
        listColumnDefs.add(new ColumnDef("기타금액_비과세", Ye16Ta3210BM.ATTR_ETCCETAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3210BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3210BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3210BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3210BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3210BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3210BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
 
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getColumnsListYetaP03009ToYe16Ta3210() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3210BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("정산년도", Ye16Ta3210BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y002");
        /** column 정산구분코드 : settGbcd */
        
        listColumnDefs.add(new ColumnListDef("정산구분",   Ye16Ta3210BM.ATTR_SETTGBCD,   ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3210BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Ye16Ta3210BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 지급년월 : elctYymm */
        listColumnDefs.add(new ColumnDef("지급년월", Ye16Ta3210BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3210BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급일자 : elctDate */
        listColumnDefs.add(new ColumnDef("급여지급일자", Ye16Ta3210BM.ATTR_ELCTDATE, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여지급금액_과세 : suprTxam */
        listColumnDefs.add(new ColumnDef("급여지급금액_과세", Ye16Ta3210BM.ATTR_SUPRTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여_상여합계금액 : spbmTxam */
        listColumnDefs.add(new ColumnDef("상여합계", Ye16Ta3210BM.ATTR_SPBMTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 소득세 : earnTaxn */
        listColumnDefs.add(new ColumnDef("소득세", Ye16Ta3210BM.ATTR_EARNTAXN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 지방소득세 : ihtxTaxn */
        listColumnDefs.add(new ColumnDef("지방소득세", Ye16Ta3210BM.ATTR_IHTXTAXN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        

        /** column 상여금_과세 : buamTxam */
        listColumnDefs.add(new ColumnDef("상여금_과세", Ye16Ta3210BM.ATTR_BUAMTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 인정상여금액 : inbsAmnt */
        listColumnDefs.add(new ColumnDef("인정상여금액", Ye16Ta3210BM.ATTR_INBSAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 주식행사이익금액 : stckInam */
        listColumnDefs.add(new ColumnDef("주식행사이익금액", Ye16Ta3210BM.ATTR_STCKINAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });

        /** column 외국인소득금액_과세 : ecinTxam */
        listColumnDefs.add(new ColumnDef("외국인소득금액_과세", Ye16Ta3210BM.ATTR_ECINTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 외국인소득금액_비과세 : taxmEcin */
        listColumnDefs.add(new ColumnDef("외국인소득금액_비과세", Ye16Ta3210BM.ATTR_TAXMECIN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 자가운전보조금_비과세 : taxmEarn */
        listColumnDefs.add(new ColumnDef("자가운전보조금_비과세", Ye16Ta3210BM.ATTR_TAXMEARN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_비과세 : taxmEtam */
        listColumnDefs.add(new ColumnDef("정액급식비_비과세", Ye16Ta3210BM.ATTR_TAXMETAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 정액급식비_과세 : txetTxam */
        listColumnDefs.add(new ColumnDef("정액급식비_과세", Ye16Ta3210BM.ATTR_TXETTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 출산보육수당_비과세 : addrBhtx */
        listColumnDefs.add(new ColumnDef("출산보육수당_비과세", Ye16Ta3210BM.ATTR_ADDRBHTX, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 건강보험료금액 : spciHlth */
        listColumnDefs.add(new ColumnDef("건강보험료금액", Ye16Ta3210BM.ATTR_SPCIHLTH, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 고용보험료금액 : spciEmpf */
        listColumnDefs.add(new ColumnDef("고용보험료금액", Ye16Ta3210BM.ATTR_SPCIEMPF, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금금액 : natnPsnf */
        listColumnDefs.add(new ColumnDef("국민연금금액", Ye16Ta3210BM.ATTR_NATNPSNF, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });

        /** column 기타금액_과세 : etccTxam */
        listColumnDefs.add(new ColumnDef("기타금액_과세", Ye16Ta3210BM.ATTR_ETCCTXAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 기타금액_비과세 : etccEtam */
        listColumnDefs.add(new ColumnDef("기타금액_비과세", Ye16Ta3210BM.ATTR_ETCCETAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3210BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3210BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3210BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3210BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3210BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3210BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
	return listColumnDefs;
	}

}
