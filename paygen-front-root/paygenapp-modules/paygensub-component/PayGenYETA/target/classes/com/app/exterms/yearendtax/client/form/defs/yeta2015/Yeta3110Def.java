package com.app.exterms.yearendtax.client.form.defs.yeta2015;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3110BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Yeta3110Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Yeta3110Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETAP03006".equals(chkDef)) {
			setTitle("");
//			setTitle("종전근무지등록");
	        setDaoClass("");
//	        setCustomListMethod("");
	        setCustomListMethod(CLASS_YETAP03006TOYETA3110_DATA_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaP03006ToYeta3110()); 		
		}else {
//			setTitle("연말정산대상자 및 내역");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAP03006TOYETA3110_DATA_LIST);
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
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3110BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3110BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("Y002");
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnListDef("정산구분",   Yeta3110BM.ATTR_SETTGBCD,   ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
//        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3110BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
//        	{
//
//        	}
//        });
        /** column 사업자등록번호 : siteNumb */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Yeta3110BM.ATTR_SITENUMB, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3110BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_FROM : jeymStdt */
        listColumnDefs.add(new ColumnDef("귀속년월_FROM", Yeta3110BM.ATTR_JEYMSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_TO : jeymEddt */
        listColumnDefs.add(new ColumnDef("귀속년월_TO", Yeta3110BM.ATTR_JEYMEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_TO : jutrEddt */
        listColumnDefs.add(new ColumnDef("감면기간_TO", Yeta3110BM.ATTR_JUTREDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_FROM : jutrStdt */
        listColumnDefs.add(new ColumnDef("감면기간_FROM", Yeta3110BM.ATTR_JUTRSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무지명 : siteCtnt */
        listColumnDefs.add(new ColumnDef("근무지명", Yeta3110BM.ATTR_SITECTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 급여합계금액 : payrTotl */
        listColumnDefs.add(new ColumnDef("급여합계금액", Yeta3110BM.ATTR_PAYRTOTL, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 상여합계금액 : bonsAmnt */
        listColumnDefs.add(new ColumnDef("상여합계금액", Yeta3110BM.ATTR_BONSAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 인정상여합계금액 : dtmnBtam */
        listColumnDefs.add(new ColumnDef("인정상여합계금액", Yeta3110BM.ATTR_DTMNBTAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 주식행사이익 : stckPrft */
        listColumnDefs.add(new ColumnDef("주식행사이익", Yeta3110BM.ATTR_STCKPRFT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 우리사주조합인출금액 : unonAmnt */
        listColumnDefs.add(new ColumnDef("우리사주조합인출금액", Yeta3110BM.ATTR_UNONAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 임원퇴직소득금액한도초과액 : ofrrExli */
        listColumnDefs.add(new ColumnDef("임원퇴직소득금액한도초과액", Yeta3110BM.ATTR_OFRREXLI, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 비과세합계금액 : taxeTotl */
        listColumnDefs.add(new ColumnDef("비과세합계금액", Yeta3110BM.ATTR_TAXETOTL, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 연구보조비합계금액 : reseSmam */
        listColumnDefs.add(new ColumnDef("연구보조비합계금액", Yeta3110BM.ATTR_RESESMAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 소득세 : earnTaxn */
        listColumnDefs.add(new ColumnDef("소득세", Yeta3110BM.ATTR_EARNTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 지방소득세 : ihtxTaxn */
        listColumnDefs.add(new ColumnDef("지방소득세", Yeta3110BM.ATTR_IHTXTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 농특세 : farmTaxn */
        listColumnDefs.add(new ColumnDef("농특세", Yeta3110BM.ATTR_FARMTAXN, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금보험료금액 : annuMuam */
        listColumnDefs.add(new ColumnDef("국민연금보험료금액", Yeta3110BM.ATTR_ANNUMUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금보험료공제액 : annuDdam */
        listColumnDefs.add(new ColumnDef("국민연금보험료공제액", Yeta3110BM.ATTR_ANNUDDAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외공무원연금 : auetMuam */
        listColumnDefs.add(new ColumnDef("국민연금외공무원연금", Yeta3110BM.ATTR_AUETMUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외군인연금 : auetSold */
        listColumnDefs.add(new ColumnDef("국민연금외군인연금", Yeta3110BM.ATTR_AUETSOLD, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외교직원연금 : auetTech */
        listColumnDefs.add(new ColumnDef("국민연금외교직원연금", Yeta3110BM.ATTR_AUETTECH, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외별정우체국 : auetFect */
        listColumnDefs.add(new ColumnDef("국민연금외별정우체국", Yeta3110BM.ATTR_AUETFECT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외공무원연금공제액 : auetDdam */
        listColumnDefs.add(new ColumnDef("국민연금외공무원연금공제액", Yeta3110BM.ATTR_AUETDDAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외군인연금공제액 : auetDold */
        listColumnDefs.add(new ColumnDef("국민연금외군인연금공제액", Yeta3110BM.ATTR_AUETDOLD, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외교직원연금공제액 : auetDech */
        listColumnDefs.add(new ColumnDef("국민연금외교직원연금공제액", Yeta3110BM.ATTR_AUETDECH, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민연금외별정우체국공제액 : auetDect */
        listColumnDefs.add(new ColumnDef("국민연금외별정우체국공제액", Yeta3110BM.ATTR_AUETDECT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직연금과학기술인금액 : rtreMuam */
        listColumnDefs.add(new ColumnDef("퇴직연금과학기술인금액", Yeta3110BM.ATTR_RTREMUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직연금근로자퇴직급여보장법 : rtrePsct */
        listColumnDefs.add(new ColumnDef("퇴직연금근로자퇴직급여보장법", Yeta3110BM.ATTR_RTREPSCT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
        listColumnDefs.add(new ColumnDef("퇴직연금연금계좌_연금저축금액", Yeta3110BM.ATTR_RTREANSV, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직연금과학기술인공제액 : rtreDdam */
        listColumnDefs.add(new ColumnDef("퇴직연금과학기술인공제액", Yeta3110BM.ATTR_RTREDDAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
        listColumnDefs.add(new ColumnDef("퇴직연금근로자퇴직급여보장법공제액", Yeta3110BM.ATTR_RTREDSCT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
        listColumnDefs.add(new ColumnDef("퇴직연금연금계좌_연금저축공제액", Yeta3110BM.ATTR_RTREDNSV, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민건강보험료금액 : hlthDbam */
        listColumnDefs.add(new ColumnDef("국민건강보험료금액", Yeta3110BM.ATTR_HLTHDBAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 국민건강보험료공제액 : hlthMuam */
        listColumnDefs.add(new ColumnDef("국민건강보험료공제액", Yeta3110BM.ATTR_HLTHMUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 고용보험금액 : upisJuam */
        listColumnDefs.add(new ColumnDef("고용보험금액", Yeta3110BM.ATTR_UPISJUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 고용보험공제액 : upisMuam */
        listColumnDefs.add(new ColumnDef("고용보험공제액", Yeta3110BM.ATTR_UPISMUAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        /** column 처리구분여부 : mangGbyn */
        listColumnDefs.add(new ColumnDef("처리구분여부", Yeta3110BM.ATTR_MANGGBYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 원천징수영수증제출여부 : wthdSbyn */
        listColumnDefs.add(new ColumnDef("원천징수영수증제출여부", Yeta3110BM.ATTR_WTHDSBYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3110BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3110BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3110BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3110BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3110BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3110BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> siteNumb;   /** column 사업자등록번호 : siteNumb */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> jeymStdt;   /** column 귀속년월_FROM : jeymStdt */
//
//        private TextField<String> jeymEddt;   /** column 귀속년월_TO : jeymEddt */
//
//        private TextField<String> jutrEddt;   /** column 감면기간_TO : jutrEddt */
//
//        private TextField<String> jutrStdt;   /** column 감면기간_FROM : jutrStdt */
//
//        private TextField<String> siteCtnt;   /** column 근무지명 : siteCtnt */
//
//        private TextField<String> payrTotl;   /** column 급여합계금액 : payrTotl */
//
//        private TextField<String> bonsAmnt;   /** column 상여합계금액 : bonsAmnt */
//
//        private TextField<String> dtmnBtam;   /** column 인정상여합계금액 : dtmnBtam */
//
//        private TextField<String> stckPrft;   /** column 주식행사이익 : stckPrft */
//
//        private TextField<String> unonAmnt;   /** column 우리사주조합인출금액 : unonAmnt */
//
//        private TextField<String> ofrrExli;   /** column 임원퇴직소득금액한도초과액 : ofrrExli */
//
//        private TextField<String> taxeTotl;   /** column 비과세합계금액 : taxeTotl */
//
//        private TextField<String> reseSmam;   /** column 연구보조비합계금액 : reseSmam */
//
//        private TextField<String> earnTaxn;   /** column 소득세 : earnTaxn */
//
//        private TextField<String> ihtxTaxn;   /** column 지방소득세 : ihtxTaxn */
//
//        private TextField<String> farmTaxn;   /** column 농특세 : farmTaxn */
//
//        private TextField<String> annuMuam;   /** column 국민연금보험료금액 : annuMuam */
//
//        private TextField<String> annuDdam;   /** column 국민연금보험료공제액 : annuDdam */
//
//        private TextField<String> auetMuam;   /** column 국민연금외공무원연금 : auetMuam */
//
//        private TextField<String> auetSold;   /** column 국민연금외군인연금 : auetSold */
//
//        private TextField<String> auetTech;   /** column 국민연금외교직원연금 : auetTech */
//
//        private TextField<String> auetFect;   /** column 국민연금외별정우체국 : auetFect */
//
//        private TextField<String> auetDdam;   /** column 국민연금외공무원연금공제액 : auetDdam */
//
//        private TextField<String> auetDold;   /** column 국민연금외군인연금공제액 : auetDold */
//
//        private TextField<String> auetDech;   /** column 국민연금외교직원연금공제액 : auetDech */
//
//        private TextField<String> auetDect;   /** column 국민연금외별정우체국공제액 : auetDect */
//
//        private TextField<String> rtreMuam;   /** column 퇴직연금과학기술인금액 : rtreMuam */
//
//        private TextField<String> rtrePsct;   /** column 퇴직연금근로자퇴직급여보장법 : rtrePsct */
//
//        private TextField<String> rtreAnsv;   /** column 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
//
//        private TextField<String> rtreDdam;   /** column 퇴직연금과학기술인공제액 : rtreDdam */
//
//        private TextField<String> rtreDsct;   /** column 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
//
//        private TextField<String> rtreDnsv;   /** column 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
//
//        private TextField<String> hlthDbam;   /** column 국민건강보험료금액 : hlthDbam */
//
//        private TextField<String> hlthMuam;   /** column 국민건강보험료공제액 : hlthMuam */
//
//        private TextField<String> upisJuam;   /** column 고용보험금액 : upisJuam */
//
//        private TextField<String> upisMuam;   /** column 고용보험공제액 : upisMuam */
//
//        private TextField<String> mangGbyn;   /** column 처리구분여부 : mangGbyn */
//
//        private TextField<String> wthdSbyn;   /** column 원천징수영수증제출여부 : wthdSbyn */
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
	
	
	
	private List<ColumnDef> getColumnsListYetaP03006ToYeta3110() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3110BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("정산년도", Yeta3110BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("Y002");
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnListDef("정산구분",   Yeta3110BM.ATTR_SETTGBCD,   ColumnDef.TYPE_STRING, 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        listColumnDefs.add(new ColumnDef("정산구분", Yeta3110BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Yeta3110BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 사업자등록번호 : siteNumb */
        listColumnDefs.add(new ColumnDef("사업자번호", Yeta3110BM.ATTR_SITENUMB, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 근무지명 : siteCtnt */
        listColumnDefs.add(new ColumnDef("근무지명", Yeta3110BM.ATTR_SITECTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 급여합계금액 : payrTotl */
        listColumnDefs.add(new ColumnDef("급여합계", Yeta3110BM.ATTR_PAYRTOTL, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 상여합계금액 : bonsAmnt */
        listColumnDefs.add(new ColumnDef("상여합계", Yeta3110BM.ATTR_BONSAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 소득세 : earnTaxn */
        listColumnDefs.add(new ColumnDef("소득세", Yeta3110BM.ATTR_EARNTAXN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 지방소득세 : ihtxTaxn */
        listColumnDefs.add(new ColumnDef("지방소득세", Yeta3110BM.ATTR_IHTXTAXN, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 처리구분여부 : mangGbyn */
        listColumnDefs.add(new ColumnDef("처리구분", Yeta3110BM.ATTR_MANGGBYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{

        	}
        });
        
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3110BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_FROM : jeymStdt */
        listColumnDefs.add(new ColumnDef("귀속년월_FROM", Yeta3110BM.ATTR_JEYMSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_TO : jeymEddt */
        listColumnDefs.add(new ColumnDef("귀속년월_TO", Yeta3110BM.ATTR_JEYMEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_TO : jutrEddt */
        listColumnDefs.add(new ColumnDef("감면기간_TO", Yeta3110BM.ATTR_JUTREDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_FROM : jutrStdt */
        listColumnDefs.add(new ColumnDef("감면기간_FROM", Yeta3110BM.ATTR_JUTRSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column 인정상여합계금액 : dtmnBtam */
        listColumnDefs.add(new ColumnDef("인정상여합계금액", Yeta3110BM.ATTR_DTMNBTAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주식행사이익 : stckPrft */
        listColumnDefs.add(new ColumnDef("주식행사이익", Yeta3110BM.ATTR_STCKPRFT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 우리사주조합인출금액 : unonAmnt */
        listColumnDefs.add(new ColumnDef("우리사주조합인출금액", Yeta3110BM.ATTR_UNONAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 임원퇴직소득금액한도초과액 : ofrrExli */
        listColumnDefs.add(new ColumnDef("임원퇴직소득금액한도초과액", Yeta3110BM.ATTR_OFRREXLI, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세합계금액 : taxeTotl */
        listColumnDefs.add(new ColumnDef("비과세합계금액", Yeta3110BM.ATTR_TAXETOTL, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연구보조비합계금액 : reseSmam */
        listColumnDefs.add(new ColumnDef("연구보조비합계금액", Yeta3110BM.ATTR_RESESMAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
       
        /** column 농특세 : farmTaxn */
        listColumnDefs.add(new ColumnDef("농특세", Yeta3110BM.ATTR_FARMTAXN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료금액 : annuMuam */
        listColumnDefs.add(new ColumnDef("국민연금보험료금액", Yeta3110BM.ATTR_ANNUMUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금보험료공제액 : annuDdam */
        listColumnDefs.add(new ColumnDef("국민연금보험료공제액", Yeta3110BM.ATTR_ANNUDDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외공무원연금 : auetMuam */
        listColumnDefs.add(new ColumnDef("국민연금외공무원연금", Yeta3110BM.ATTR_AUETMUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외군인연금 : auetSold */
        listColumnDefs.add(new ColumnDef("국민연금외군인연금", Yeta3110BM.ATTR_AUETSOLD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외교직원연금 : auetTech */
        listColumnDefs.add(new ColumnDef("국민연금외교직원연금", Yeta3110BM.ATTR_AUETTECH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외별정우체국 : auetFect */
        listColumnDefs.add(new ColumnDef("국민연금외별정우체국", Yeta3110BM.ATTR_AUETFECT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외공무원연금공제액 : auetDdam */
        listColumnDefs.add(new ColumnDef("국민연금외공무원연금공제액", Yeta3110BM.ATTR_AUETDDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외군인연금공제액 : auetDold */
        listColumnDefs.add(new ColumnDef("국민연금외군인연금공제액", Yeta3110BM.ATTR_AUETDOLD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외교직원연금공제액 : auetDech */
        listColumnDefs.add(new ColumnDef("국민연금외교직원연금공제액", Yeta3110BM.ATTR_AUETDECH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금외별정우체국공제액 : auetDect */
        listColumnDefs.add(new ColumnDef("국민연금외별정우체국공제액", Yeta3110BM.ATTR_AUETDECT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직연금과학기술인금액 : rtreMuam */
        listColumnDefs.add(new ColumnDef("퇴직연금과학기술인금액", Yeta3110BM.ATTR_RTREMUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직연금근로자퇴직급여보장법 : rtrePsct */
        listColumnDefs.add(new ColumnDef("퇴직연금근로자퇴직급여보장법", Yeta3110BM.ATTR_RTREPSCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
        listColumnDefs.add(new ColumnDef("퇴직연금연금계좌_연금저축금액", Yeta3110BM.ATTR_RTREANSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직연금과학기술인공제액 : rtreDdam */
        listColumnDefs.add(new ColumnDef("퇴직연금과학기술인공제액", Yeta3110BM.ATTR_RTREDDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
        listColumnDefs.add(new ColumnDef("퇴직연금근로자퇴직급여보장법공제액", Yeta3110BM.ATTR_RTREDSCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
        listColumnDefs.add(new ColumnDef("퇴직연금연금계좌_연금저축공제액", Yeta3110BM.ATTR_RTREDNSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민건강보험료금액 : hlthDbam */
        listColumnDefs.add(new ColumnDef("국민건강보험료금액", Yeta3110BM.ATTR_HLTHDBAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 국민건강보험료공제액 : hlthMuam */
        listColumnDefs.add(new ColumnDef("국민건강보험료공제액", Yeta3110BM.ATTR_HLTHMUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험금액 : upisJuam */
        listColumnDefs.add(new ColumnDef("고용보험금액", Yeta3110BM.ATTR_UPISJUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험공제액 : upisMuam */
        listColumnDefs.add(new ColumnDef("고용보험공제액", Yeta3110BM.ATTR_UPISMUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
      
        /** column 원천징수영수증제출여부 : wthdSbyn */
        listColumnDefs.add(new ColumnDef("원천징수영수증제출여부", Yeta3110BM.ATTR_WTHDSBYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3110BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3110BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3110BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3110BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3110BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3110BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

      
        return listColumnDefs;
	}

}
