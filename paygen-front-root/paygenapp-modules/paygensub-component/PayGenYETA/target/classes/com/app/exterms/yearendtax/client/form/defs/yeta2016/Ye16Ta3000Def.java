package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3000BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta3000Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	
	public Ye16Ta3000Def(String chkDef) {
		
		if("YETA0300".equals(chkDef)) { 
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
//	        setCustomListMethod(CLASS_YETA0100_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(false);
		    setColumnsDefinition(getColumnsList()); 
		}else if("YETA300001".equals(chkDef)) {
			setTitle("");
	        setDaoClass(""); 
	        setCustomListMethod(CLASS_YETA1300TOSUBTAX_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	       // setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(false);
		    setColumnsDefinition(getYeta0300ToSubTax()); 	
		}  

	}
	private List<ColumnDef> getColumnsList() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 종전근무지수 : befoScnt */
        listColumnDefs.add(new ColumnDef("종전근무지수", Ye16Ta3000BM.ATTR_BEFOSCNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_급여총액 : payrTamt */
        listColumnDefs.add(new ColumnDef("주근무지_급여총액", Ye16Ta3000BM.ATTR_PAYRTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_상여총액 : bonsToam */
        listColumnDefs.add(new ColumnDef("주근무지_상여총액", Ye16Ta3000BM.ATTR_BONSTOAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_인정상여총액 : dtmnBsam */
        listColumnDefs.add(new ColumnDef("주근무지_인정상여총액", Ye16Ta3000BM.ATTR_DTMNBSAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_주식행사이익 : stckPrft */
        listColumnDefs.add(new ColumnDef("주근무지_주식행사이익", Ye16Ta3000BM.ATTR_STCKPRFT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지총급여액 : currTots */
        listColumnDefs.add(new ColumnDef("주근무지총급여액", Ye16Ta3000BM.ATTR_CURRTOTS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세_자가운전보조금액_del : taxmSfam */
        listColumnDefs.add(new ColumnDef("비과세_자가운전보조금액_del", Ye16Ta3000BM.ATTR_TAXMSFAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세_급양비금액_del : taxmEtam */
        listColumnDefs.add(new ColumnDef("비과세_급양비금액_del", Ye16Ta3000BM.ATTR_TAXMETAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세_보육수당_del : taxmBoin */
        listColumnDefs.add(new ColumnDef("비과세_보육수당_del", Ye16Ta3000BM.ATTR_TAXMBOIN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세_외국인소득금액_del : txecAmnt */
        listColumnDefs.add(new ColumnDef("비과세_외국인소득금액_del", Ye16Ta3000BM.ATTR_TXECAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 총급여_현_전 : totlSala */
        listColumnDefs.add(new ColumnDef("총급여_현_전", Ye16Ta3000BM.ATTR_TOTLSALA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 근로소득공제 : wkerDdct */
        listColumnDefs.add(new ColumnDef("근로소득공제", Ye16Ta3000BM.ATTR_WKERDDCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 근로소득금액 : wkerAmnt */
        listColumnDefs.add(new ColumnDef("근로소득금액", Ye16Ta3000BM.ATTR_WKERAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제_본인 : baseSelf */
        listColumnDefs.add(new ColumnDef("기본공제_본인", Ye16Ta3000BM.ATTR_BASESELF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제_배우자 : baseWife */
        listColumnDefs.add(new ColumnDef("기본공제_배우자", Ye16Ta3000BM.ATTR_BASEWIFE, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제_부양가족 : baseFyam */
        listColumnDefs.add(new ColumnDef("기본공제_부양가족", Ye16Ta3000BM.ATTR_BASEFYAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_장애인 : addrHdam */
        listColumnDefs.add(new ColumnDef("추가공제_장애인", Ye16Ta3000BM.ATTR_ADDRHDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_경로우대70 : addrRpt70 */
        listColumnDefs.add(new ColumnDef("추가공제_경로우대70", Ye16Ta3000BM.ATTR_ADDRRPT70, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_부녀자 : addrFame */
        listColumnDefs.add(new ColumnDef("추가공제_부녀자", Ye16Ta3000BM.ATTR_ADDRFAME, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_자녀양육비 : addrChld */
        listColumnDefs.add(new ColumnDef("추가공제_자녀양육비", Ye16Ta3000BM.ATTR_ADDRCHLD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_출산자녀양육비 : addrBrth */
        listColumnDefs.add(new ColumnDef("추가공제_출산자녀양육비", Ye16Ta3000BM.ATTR_ADDRBRTH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_한부모공제금액 : pantOnam */
        listColumnDefs.add(new ColumnDef("추가공제_한부모공제금액", Ye16Ta3000BM.ATTR_PANTONAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_다자녀 : addrMcam */
        listColumnDefs.add(new ColumnDef("추가공제_다자녀", Ye16Ta3000BM.ATTR_ADDRMCAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금보험료공제 : bnatDdct */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금보험료공제", Ye16Ta3000BM.ATTR_BNATDDCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금보험료공제 : jnatDdct */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금보험료공제", Ye16Ta3000BM.ATTR_JNATDDCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_별정우체국연금보험료공제 : bpssDdct */
        listColumnDefs.add(new ColumnDef("종근무지_별정우체국연금보험료공제", Ye16Ta3000BM.ATTR_BPSSDDCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외군인연금공제 : bpssHsol */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외군인연금공제", Ye16Ta3000BM.ATTR_BPSSHSOL, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외교직원연금공제 : bpssHtec */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외교직원연금공제", Ye16Ta3000BM.ATTR_BPSSHTEC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외공무원연금공제 : bpssHpul */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외공무원연금공제", Ye16Ta3000BM.ATTR_BPSSHPUL, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_별정우체국연금보험료공제 : jpssDdct */
        listColumnDefs.add(new ColumnDef("주근무지_별정우체국연금보험료공제", Ye16Ta3000BM.ATTR_JPSSDDCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외군인연금공제 : jpssHsol */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외군인연금공제", Ye16Ta3000BM.ATTR_JPSSHSOL, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외교직원연금공제 : jpssHtec */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외교직원연금공제", Ye16Ta3000BM.ATTR_JPSSHTEC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_공무원연금보험료공제 : jpssHpul */
        listColumnDefs.add(new ColumnDef("주근무지_공무원연금보험료공제", Ye16Ta3000BM.ATTR_JPSSHPUL, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_퇴직연금과학기술인공제 : brtrHict */
        listColumnDefs.add(new ColumnDef("종근무지_퇴직연금과학기술인공제", Ye16Ta3000BM.ATTR_BRTRHICT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
        listColumnDefs.add(new ColumnDef("종근무지_퇴직연금근로자퇴직급여보장법공제", Ye16Ta3000BM.ATTR_BRTRPSRN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
        listColumnDefs.add(new ColumnDef("종근무지_퇴직연금연금계좌저축공제", Ye16Ta3000BM.ATTR_BRTRHNSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금과학기술인공제 : jrtrHict */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금과학기술인공제", Ye16Ta3000BM.ATTR_JRTRHICT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금근로자퇴직급여보장법공제", Ye16Ta3000BM.ATTR_JRTRPSRN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금연금계좌저축공제", Ye16Ta3000BM.ATTR_JRTRHNSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금보험료공제계 : rrptYnam */
        listColumnDefs.add(new ColumnDef("연금보험료공제계", Ye16Ta3000BM.ATTR_RRPTYNAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_종건강보험료 : spciBhth */
        listColumnDefs.add(new ColumnDef("특별공제_종건강보험료", Ye16Ta3000BM.ATTR_SPCIBHTH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주건강보험료 : spciJhth */
        listColumnDefs.add(new ColumnDef("특별공제_주건강보험료", Ye16Ta3000BM.ATTR_SPCIJHTH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_종고용보험료 : spciBepf */
        listColumnDefs.add(new ColumnDef("특별공제_종고용보험료", Ye16Ta3000BM.ATTR_SPCIBEPF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주고용보험료 : spciJepf */
        listColumnDefs.add(new ColumnDef("특별공제_주고용보험료", Ye16Ta3000BM.ATTR_SPCIJEPF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_일반보장성보험료 : spciGurt */
        listColumnDefs.add(new ColumnDef("특별공제_일반보장성보험료", Ye16Ta3000BM.ATTR_SPCIGURT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인보장성보험료 : spciHdrc */
        listColumnDefs.add(new ColumnDef("특별공제_장애인보장성보험료", Ye16Ta3000BM.ATTR_SPCIHDRC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보장성보혐료세액공제금액 : spciRtde */
        listColumnDefs.add(new ColumnDef("특별공제_보장성보혐료세액공제금액", Ye16Ta3000BM.ATTR_SPCIRTDE, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보험료계 : spciHrto */
        listColumnDefs.add(new ColumnDef("특별공제_보험료계", Ye16Ta3000BM.ATTR_SPCIHRTO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_본인 : spciSelf */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_본인", Ye16Ta3000BM.ATTR_SPCISELF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_경로65세이상 : spciHe65 */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_경로65세이상", Ye16Ta3000BM.ATTR_SPCIHE65, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_장애인 : spciHbps */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_장애인", Ye16Ta3000BM.ATTR_SPCIHBPS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_기타공제대상자 : spciDetc */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_기타공제대상자", Ye16Ta3000BM.ATTR_SPCIDETC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비세액공제액 : spciTxcr */
        listColumnDefs.add(new ColumnDef("특별공제_의료비세액공제액", Ye16Ta3000BM.ATTR_SPCITXCR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비계 : spciMeto */
        listColumnDefs.add(new ColumnDef("특별공제_의료비계", Ye16Ta3000BM.ATTR_SPCIMETO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_본인 : spedSelf */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_본인", Ye16Ta3000BM.ATTR_SPEDSELF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_취학전아동 : spedGrde */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_취학전아동", Ye16Ta3000BM.ATTR_SPEDGRDE, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_초중고 : spedGdto */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_초중고", Ye16Ta3000BM.ATTR_SPEDGDTO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_대학교 : spedCldv */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_대학교", Ye16Ta3000BM.ATTR_SPEDCLDV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인특수교육비 : spciSpec */
        listColumnDefs.add(new ColumnDef("특별공제_장애인특수교육비", Ye16Ta3000BM.ATTR_SPCISPEC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비세액공제금액 : spedTxcr */
        listColumnDefs.add(new ColumnDef("특별공제_교육비세액공제금액", Ye16Ta3000BM.ATTR_SPEDTXCR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비계 : spedToam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비계", Ye16Ta3000BM.ATTR_SPEDTOAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
        listColumnDefs.add(new ColumnDef("특별공제_차입금원리금상환액_대출기관", Ye16Ta3000BM.ATTR_SPCIREFN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
        listColumnDefs.add(new ColumnDef("특별공제_차입금원리금상환액_거주자", Ye16Ta3000BM.ATTR_SPCIRESF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_월세세액공제대상금액 : spciTgrt */
        listColumnDefs.add(new ColumnDef("특별공제_월세세액공제대상금액", Ye16Ta3000BM.ATTR_SPCITGRT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주택자금월세공제액 : spciRtam */
        listColumnDefs.add(new ColumnDef("특별공제_주택자금월세공제액", Ye16Ta3000BM.ATTR_SPCIRTAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장기주택이자상환액 : spchRefn */
        listColumnDefs.add(new ColumnDef("특별공제_장기주택이자상환액", Ye16Ta3000BM.ATTR_SPCHREFN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금15 : spchRe15 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금15", Ye16Ta3000BM.ATTR_SPCHRE15, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금29 : spchRe29 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금29", Ye16Ta3000BM.ATTR_SPCHRE29, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금30 : spchRe30 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금30", Ye16Ta3000BM.ATTR_SPCHRE30, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_12장기주택저당차입금_고정 : spciRefx */
        listColumnDefs.add(new ColumnDef("특별공제_12장기주택저당차입금_고정", Ye16Ta3000BM.ATTR_SPCIREFX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_12장기주택저당차입금_기타 : spciReec */
        listColumnDefs.add(new ColumnDef("특별공제_12장기주택저당차입금_기타", Ye16Ta3000BM.ATTR_SPCIREEC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15고정AND비거치상환", Ye16Ta3000BM.ATTR_SPCI15FX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15고정OR비거치상환", Ye16Ta3000BM.ATTR_SPCI15FB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15기타대출 : spci15ec */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15기타대출", Ye16Ta3000BM.ATTR_SPCI15EC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_10고정OR비거치상환", Ye16Ta3000BM.ATTR_SPCI10FB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_10기타대출 : spci10ec */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_10기타대출", Ye16Ta3000BM.ATTR_SPCI10EC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주택자금공제액계 : spchReto */
        listColumnDefs.add(new ColumnDef("특별공제_주택자금공제액계", Ye16Ta3000BM.ATTR_SPCHRETO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_기부정치자금 : taxdPltc */
        listColumnDefs.add(new ColumnDef("세액공제_기부정치자금", Ye16Ta3000BM.ATTR_TAXDPLTC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_정치 : spciPltc */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_정치", Ye16Ta3000BM.ATTR_SPCIPLTC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_법정 : spciFbam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_법정", Ye16Ta3000BM.ATTR_SPCIFBAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_특례_공익법인신탁제외", Ye16Ta3000BM.ATTR_SPCIEXAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_공익법인신탁특례", Ye16Ta3000BM.ATTR_SPCIUNON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_우리사주조합2015이후 : spciRfam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_우리사주조합2015이후", Ye16Ta3000BM.ATTR_SPCIRFAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_종교단체 : spciYamt */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_종교단체", Ye16Ta3000BM.ATTR_SPCIYAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_종교단체외 : spciNamt */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_종교단체외", Ye16Ta3000BM.ATTR_SPCINAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_지정기부금세액공제금액 : spciDgcr */
        listColumnDefs.add(new ColumnDef("특별공제_지정기부금세액공제금액", Ye16Ta3000BM.ATTR_SPCIDGCR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금공제액계 : spciSsum */
        listColumnDefs.add(new ColumnDef("특별공제_기부금공제액계", Ye16Ta3000BM.ATTR_SPCISSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_표준공제 : spciDdct */
        listColumnDefs.add(new ColumnDef("특별공제_표준공제", Ye16Ta3000BM.ATTR_SPCIDDCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 차감소득금액 : subtEram */
        listColumnDefs.add(new ColumnDef("차감소득금액", Ye16Ta3000BM.ATTR_SUBTERAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축불입액_2000년이전 : etcpPsnv */
        listColumnDefs.add(new ColumnDef("개인연금저축불입액_2000년이전", Ye16Ta3000BM.ATTR_ETCPPSNV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축불입액_2001이후_삭제 : etcpNsav */
        listColumnDefs.add(new ColumnDef("개인연금저축불입액_2001이후_삭제", Ye16Ta3000BM.ATTR_ETCPNSAV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금저축공제액계 : prcmToam */
        listColumnDefs.add(new ColumnDef("연금저축공제액계", Ye16Ta3000BM.ATTR_PRCMTOAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_소기업공제불입금 : etchPrep */
        listColumnDefs.add(new ColumnDef("기타공제_소기업공제불입금", Ye16Ta3000BM.ATTR_ETCHPREP, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_청약저축 : etcsComp */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_청약저축", Ye16Ta3000BM.ATTR_ETCSCOMP, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_주택청약종합저축", Ye16Ta3000BM.ATTR_ETWKSBAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_근로자주택마련저축", Ye16Ta3000BM.ATTR_ETWKSVAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_장기주택마련저축 : etwkLgam */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_장기주택마련저축", Ye16Ta3000BM.ATTR_ETWKLGAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축소득공제계 : etwkBdam */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축소득공제계", Ye16Ta3000BM.ATTR_ETWKBDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2011이전 : etctConc */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2011이전", Ye16Ta3000BM.ATTR_ETCTCONC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2012년도", Ye16Ta3000BM.ATTR_ETGD09AF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2013년도", Ye16Ta3000BM.ATTR_ETGDH13H, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2014년이후", Ye16Ta3000BM.ATTR_ETGDD14F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자공제액계 : etgdDdam */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자공제액계", Ye16Ta3000BM.ATTR_ETGDDDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_신용카드등사용액소득공제 : etccCard */
        listColumnDefs.add(new ColumnDef("기타공제_신용카드등사용액소득공제", Ye16Ta3000BM.ATTR_ETCCCARD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_우리사주출연금공제 : etckUnon */
        listColumnDefs.add(new ColumnDef("기타공제_우리사주출연금공제", Ye16Ta3000BM.ATTR_ETCKUNON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
        listColumnDefs.add(new ColumnDef("기타공제_우리사주조합기부금공제2014이전", Ye16Ta3000BM.ATTR_ETCKUNCR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
        listColumnDefs.add(new ColumnDef("기타공제_고용유지중소기업근로자임금삭감공제액", Ye16Ta3000BM.ATTR_ETEPMSAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
        listColumnDefs.add(new ColumnDef("기타공제_목돈안드는전세이자상환소득공제액", Ye16Ta3000BM.ATTR_ETGDHTRA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기집합투자증권저축공제액 : etepSecr */
        listColumnDefs.add(new ColumnDef("기타공제_장기집합투자증권저축공제액", Ye16Ta3000BM.ATTR_ETEPSECR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_1년차공제_삭제 : etclTo01 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_1년차공제_삭제", Ye16Ta3000BM.ATTR_ETCLTO01, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_2년차공제_삭제 : etclTo02 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_2년차공제_삭제", Ye16Ta3000BM.ATTR_ETCLTO02, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_3년차공제_삭제 : etclTo03 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_3년차공제_삭제", Ye16Ta3000BM.ATTR_ETCLTO03, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축소득공제_삭제 : etclHmto */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축소득공제_삭제", Ye16Ta3000BM.ATTR_ETCLHMTO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_공제계 : etcdTsum */
        listColumnDefs.add(new ColumnDef("기타공제_공제계", Ye16Ta3000BM.ATTR_ETCDTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_종합한도초과금액 : spchExli */
        listColumnDefs.add(new ColumnDef("특별공제_종합한도초과금액", Ye16Ta3000BM.ATTR_SPCHEXLI, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종합소득과세표준 : stndIncm */
        listColumnDefs.add(new ColumnDef("종합소득과세표준", Ye16Ta3000BM.ATTR_STNDINCM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 산출세액 : prddTaxn */
        listColumnDefs.add(new ColumnDef("산출세액", Ye16Ta3000BM.ATTR_PRDDTAXN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_소득세법 : taxdIcax */
        listColumnDefs.add(new ColumnDef("세액감면_소득세법", Ye16Ta3000BM.ATTR_TAXDICAX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_조세특례법 : taxdSpct */
        listColumnDefs.add(new ColumnDef("세액감면_조세특례법", Ye16Ta3000BM.ATTR_TAXDSPCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_조세특례법제30조 : txlgCl30 */
        listColumnDefs.add(new ColumnDef("세액감면_조세특례법제30조", Ye16Ta3000BM.ATTR_TXLGCL30, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_조세조약 : txlgHxtt */
        listColumnDefs.add(new ColumnDef("세액감면_조세조약", Ye16Ta3000BM.ATTR_TXLGHXTT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_감면세액계 : taxdTsum */
        listColumnDefs.add(new ColumnDef("세액감면_감면세액계", Ye16Ta3000BM.ATTR_TAXDTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_근로소득세액공제 : taxdWken */
        listColumnDefs.add(new ColumnDef("세액공제_근로소득세액공제", Ye16Ta3000BM.ATTR_TAXDWKEN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_납세조합공제 : taxdUnin */
        listColumnDefs.add(new ColumnDef("세액공제_납세조합공제", Ye16Ta3000BM.ATTR_TAXDUNIN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_주택차입금 : taxdLoan */
        listColumnDefs.add(new ColumnDef("세액공제_주택차입금", Ye16Ta3000BM.ATTR_TAXDLOAN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부 : taxdPaid */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부", Ye16Ta3000BM.ATTR_TAXDPAID, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인감면세액 : taxdRedu */
        listColumnDefs.add(new ColumnDef("세액공제_외국인감면세액", Ye16Ta3000BM.ATTR_TAXDREDU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_자녀세액공제금액 : addrMccr */
        listColumnDefs.add(new ColumnDef("세액공제_자녀세액공제금액", Ye16Ta3000BM.ATTR_ADDRMCCR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별세액공제계 : spciDcto */
        listColumnDefs.add(new ColumnDef("특별세액공제계", Ye16Ta3000BM.ATTR_SPCIDCTO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_공제계 : taxdCsum */
        listColumnDefs.add(new ColumnDef("세액공제_공제계", Ye16Ta3000BM.ATTR_TAXDCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 결정세액_소득세 : dcsnIncm */
        listColumnDefs.add(new ColumnDef("결정세액_소득세", Ye16Ta3000BM.ATTR_DCSNINCM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 결정세액_주민세_지방소득세 : dcsnInhb */
        listColumnDefs.add(new ColumnDef("결정세액_주민세_지방소득세", Ye16Ta3000BM.ATTR_DCSNINHB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 결정세액_농특세 : dcsnFafv */
        listColumnDefs.add(new ColumnDef("결정세액_농특세", Ye16Ta3000BM.ATTR_DCSNFAFV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기납부세액_소득세 : alryPinx */
        listColumnDefs.add(new ColumnDef("기납부세액_소득세", Ye16Ta3000BM.ATTR_ALRYPINX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기납부세액_주민세_지방소득세 : alryPhbx */
        listColumnDefs.add(new ColumnDef("기납부세액_주민세_지방소득세", Ye16Ta3000BM.ATTR_ALRYPHBX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기납부세액_농특세 : alryYvtx */
        listColumnDefs.add(new ColumnDef("기납부세액_농특세", Ye16Ta3000BM.ATTR_ALRYYVTX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이전근무지_총급여 : dcsnTots */
        listColumnDefs.add(new ColumnDef("이전근무지_총급여", Ye16Ta3000BM.ATTR_DCSNTOTS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이전근무지_소득세 : dcsnItax */
        listColumnDefs.add(new ColumnDef("이전근무지_소득세", Ye16Ta3000BM.ATTR_DCSNITAX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이전근무지_주민세_지방소득세 : dcsnBtax */
        listColumnDefs.add(new ColumnDef("이전근무지_주민세_지방소득세", Ye16Ta3000BM.ATTR_DCSNBTAX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이전근무지_농특세 : fafvTaxi */
        listColumnDefs.add(new ColumnDef("이전근무지_농특세", Ye16Ta3000BM.ATTR_FAFVTAXI, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 차감징수_소득세 : subtEtax */
        listColumnDefs.add(new ColumnDef("차감징수_소득세", Ye16Ta3000BM.ATTR_SUBTETAX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 차감징수_주민세_지방소득세 : subtInhb */
        listColumnDefs.add(new ColumnDef("차감징수_주민세_지방소득세", Ye16Ta3000BM.ATTR_SUBTINHB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 차감징수_농특세 : subtFafv */
        listColumnDefs.add(new ColumnDef("차감징수_농특세", Ye16Ta3000BM.ATTR_SUBTFAFV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 차감징수_세액계 : subtAmsu */
        listColumnDefs.add(new ColumnDef("차감징수_세액계", Ye16Ta3000BM.ATTR_SUBTAMSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌세액공제계 : jrtrHnto */
        listColumnDefs.add(new ColumnDef("연금계좌세액공제계", Ye16Ta3000BM.ATTR_JRTRHNTO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월특례기부금_공익신탁금액 : spciOnon */
        listColumnDefs.add(new ColumnDef("이월특례기부금_공익신탁금액", Ye16Ta3000BM.ATTR_SPCIONON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월법정기부금액 : spciObam */
        listColumnDefs.add(new ColumnDef("이월법정기부금액", Ye16Ta3000BM.ATTR_SPCIOBAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월종교단체기부금 : spciOyam */
        listColumnDefs.add(new ColumnDef("이월종교단체기부금", Ye16Ta3000BM.ATTR_SPCIOYAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월종교단체외기부금 : spciOnam */
        listColumnDefs.add(new ColumnDef("이월종교단체외기부금", Ye16Ta3000BM.ATTR_SPCIONAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : tempPrddTaxn */
        listColumnDefs.add(new ColumnDef("null", Ye16Ta3000BM.ATTR_TEMPPRDDTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2014_벤처", Ye16Ta3000BM.ATTR_ETGDD14B, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2015_벤처", Ye16Ta3000BM.ATTR_ETGDD15B, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2016_조합", Ye16Ta3000BM.ATTR_ETGDD16F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자소득공제_2016_벤처", Ye16Ta3000BM.ATTR_ETGDD16B, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });

          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getYeta0300ToSubTax() {
		row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        
        /** column 구분 : settGbnm */
        listColumnDefs.add(new ColumnDef("구분", Ye16Ta3000BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
     
        /** column 차감징수_소득세 : subtEtax */
        listColumnDefs.add(new ColumnDef("소득세", Ye16Ta3000BM.ATTR_SUBTETAX, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        /** column 차감징수_주민세_지방소득세 : subtInhb */
        listColumnDefs.add(new ColumnDef("지방소득세", Ye16Ta3000BM.ATTR_SUBTINHB, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        /** column 차감징수_농특세 : subtFafv */
        listColumnDefs.add(new ColumnDef("농특세", Ye16Ta3000BM.ATTR_SUBTFAFV, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
       
         
        
        return listColumnDefs;
	}	
	
	
}
