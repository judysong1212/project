package com.app.exterms.yearendtax.client.form.defs.yeta2015;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3220BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Yeta3220Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Yeta3220Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETA322001".equals(chkDef)) {
			
//			setTitle("인적공제명세");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
	        setCustomListMethod(CLASS_YETA0300To3220_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getYeta3220ToYeta0300ColumnsList01());  
		}else if("YETA322002".equals(chkDef)) {
			
//			setTitle("합계");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA0300To3220_SUM_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getYeta3220ToYeta0300ColumnsList02());  
		}else if("YETA322003".equals(chkDef)) {
			
//			setTitle("국세청자료");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA0300To3220_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getYeta3220ToYeta0300ColumnsList03());  
		}else if("YETA322004".equals(chkDef)) {
			
//			setTitle("기타자료");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA0300To3220_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getYeta3220ToYeta0300ColumnsList04());  
		}

	}

	private List<ColumnDef> getYeta3220ToYeta0300ColumnsList01() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 관계 : relhCode */
        sysComBass0300Dto.setRpsttvCd("A019");
        listColumnDefs.add(new ColumnListDef("관계",   Yeta3220BM.ATTR_RELHCODE,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		setReadOnly(true);
            }
        });
        listColumnDefs.add(new ColumnDef("관계", Yeta3220BM.ATTR_RELHCODE, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{
        		
        	}
        });
        
        
        /** column 성명 : kornName */
        listColumnDefs.add(new ColumnDef("성명", Yeta3220BM.ATTR_KORNNAME, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 내외국인구분코드 : frnrCode */
        listColumnDefs.add(new ColumnDef("내국인", Yeta3220BM.ATTR_FRNRCODE, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("주민번호", Yeta3220BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("수정전주민", Yeta3220BM.ATTR_RSNONUMB2, ColumnDef.TYPE_STRING , 120, true, false, true){
        	{

        	}
        });
        
        /** column 기본공제여부 : baseDdyn */
        listColumnDefs.add(new ColumnDef("기본", Yeta3220BM.ATTR_BASEDDYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{
            	setSelectOnFocus(true);
        	}
        });
        /** column 부녀자공제여부 : faddCtyn */
        listColumnDefs.add(new ColumnDef("부녀자", Yeta3220BM.ATTR_FADDCTYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 경로우대공제여부 : rpctDdyn */
        listColumnDefs.add(new ColumnDef("경로", Yeta3220BM.ATTR_RPCTDDYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 출산입양자공제여부 : bithDdyn */
        listColumnDefs.add(new ColumnDef("출산", Yeta3220BM.ATTR_BITHDDYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 장애인공제여부 : psclDdyn */
        sysComBass0300Dto.setRpsttvCd("Y008");
        listColumnDefs.add(new ColumnListDef("장애인",   Yeta3220BM.ATTR_PSCLDDYN,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
//        listColumnDefs.add(new ColumnDef("장애인", Yeta3220BM.ATTR_PSCLDDYN, ColumnDef.TYPE_STRING, 60, true, true, true){
//        	{
//
//        	}
//        });
        
        /** column 자녀양육비공제여부 : brddCtyn */
        listColumnDefs.add(new ColumnDef("6세", Yeta3220BM.ATTR_BRDDCTYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 한부모공제여부 : pantOnyn */
        listColumnDefs.add(new ColumnDef("한부모", Yeta3220BM.ATTR_PANTONYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        
        
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3220BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3220BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3220BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3220BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 보험료_건강고용등국세청 : insuPayr */
        listColumnDefs.add(new ColumnDef("보험료_건강고용등국세청", Yeta3220BM.ATTR_INSUPAYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료보장성_국세청 : insuRtyr */
        listColumnDefs.add(new ColumnDef("보험료보장성_국세청", Yeta3220BM.ATTR_INSURTYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료장애인보장성_국세청 : psclIurr */
        listColumnDefs.add(new ColumnDef("보험료장애인보장성_국세청", Yeta3220BM.ATTR_PSCLIURR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_국세청 : mediCost */
        listColumnDefs.add(new ColumnDef("의료비_국세청", Yeta3220BM.ATTR_MEDICOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_국세청 : educCost */
        listColumnDefs.add(new ColumnDef("교육비_국세청", Yeta3220BM.ATTR_EDUCCOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등_국세청 : cdteCard */
        listColumnDefs.add(new ColumnDef("신용카드등_국세청", Yeta3220BM.ATTR_CDTECARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 현금영수증_국세청 : cashRece */
        listColumnDefs.add(new ColumnDef("현금영수증_국세청", Yeta3220BM.ATTR_CASHRECE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드등_국세청 : jiblCard */
        listColumnDefs.add(new ColumnDef("직불카드등_국세청", Yeta3220BM.ATTR_JIBLCARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 지로납부액_대중교통_국세청 : grpyAmnt */
        listColumnDefs.add(new ColumnDef("지로납부액_대중교통_국세청", Yeta3220BM.ATTR_GRPYAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장사용분_국세청 : mgntStvd */
        listColumnDefs.add(new ColumnDef("전통시장사용분_국세청", Yeta3220BM.ATTR_MGNTSTVD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액_국세청 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부금액_국세청", Yeta3220BM.ATTR_CTRBAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료_건강고용등외 : insuFetc */
        listColumnDefs.add(new ColumnDef("보험료_건강고용등외", Yeta3220BM.ATTR_INSUFETC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료보장성외 : insuRtet */
        listColumnDefs.add(new ColumnDef("보험료보장성외", Yeta3220BM.ATTR_INSURTET, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료장애인보장성외 : psclIurt */
        listColumnDefs.add(new ColumnDef("보험료장애인보장성외", Yeta3220BM.ATTR_PSCLIURT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비외 : mediExps */
        listColumnDefs.add(new ColumnDef("의료비외", Yeta3220BM.ATTR_MEDIEXPS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비외 : educOtec */
        listColumnDefs.add(new ColumnDef("교육비외", Yeta3220BM.ATTR_EDUCOTEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드외 : cdteCdec */
        listColumnDefs.add(new ColumnDef("신용카드외", Yeta3220BM.ATTR_CDTECDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드외 : jiblCdec */
        listColumnDefs.add(new ColumnDef("직불카드외", Yeta3220BM.ATTR_JIBLCDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 지로납부액_대중교통외 : grpyAtec */
        listColumnDefs.add(new ColumnDef("지로납부액_대중교통외", Yeta3220BM.ATTR_GRPYATEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장사용분외 : mgntSdec */
        listColumnDefs.add(new ColumnDef("전통시장사용분외", Yeta3220BM.ATTR_MGNTSDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액외 : ctrbAmec */
        listColumnDefs.add(new ColumnDef("기부금액외", Yeta3220BM.ATTR_CTRBAMEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3220BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3220BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3220BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3220BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3220BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3220BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> rsnoNumb;   /** column 주민등록번호 : rsnoNumb */
//
//        private TextField<String> relhCode;   /** column 관계 : relhCode */
//
//        private TextField<String> kornName;   /** column 성명 : kornName */
//
//        private TextField<String> frnrCode;   /** column 내외국인구분코드 : frnrCode */
//
//        private TextField<String> baseDdyn;   /** column 기본공제여부 : baseDdyn */
//
//        private TextField<String> psclDdyn;   /** column 장애인공제여부 : psclDdyn */
//
//        private TextField<String> brddCtyn;   /** column 자녀양육비공제여부 : brddCtyn */
//
//        private TextField<String> faddCtyn;   /** column 부녀자공제여부 : faddCtyn */
//
//        private TextField<String> rpctDdyn;   /** column 경로우대공제여부 : rpctDdyn */
//
//        private TextField<String> bithDdyn;   /** column 출산입양자공제여부 : bithDdyn */
//
//        private TextField<String> pantOnyn;   /** column 한부모공제여부 : pantOnyn */
//
//        private TextField<String> insuPayr;   /** column 보험료_건강고용등국세청 : insuPayr */
//
//        private TextField<String> insuRtyr;   /** column 보험료보장성_국세청 : insuRtyr */
//
//        private TextField<String> psclIurr;   /** column 보험료장애인보장성_국세청 : psclIurr */
//
//        private TextField<String> mediCost;   /** column 의료비_국세청 : mediCost */
//
//        private TextField<String> educCost;   /** column 교육비_국세청 : educCost */
//
//        private TextField<String> cdteCard;   /** column 신용카드등_국세청 : cdteCard */
//
//        private TextField<String> cashRece;   /** column 현금영수증_국세청 : cashRece */
//
//        private TextField<String> jiblCard;   /** column 직불카드등_국세청 : jiblCard */
//
//        private TextField<String> grpyAmnt;   /** column 지로납부액_대중교통_국세청 : grpyAmnt */
//
//        private TextField<String> mgntStvd;   /** column 전통시장사용분_국세청 : mgntStvd */
//
//        private TextField<String> ctrbAmnt;   /** column 기부금액_국세청 : ctrbAmnt */
//
//        private TextField<String> insuFetc;   /** column 보험료_건강고용등외 : insuFetc */
//
//        private TextField<String> insuRtet;   /** column 보험료보장성외 : insuRtet */
//
//        private TextField<String> psclIurt;   /** column 보험료장애인보장성외 : psclIurt */
//
//        private TextField<String> mediExps;   /** column 의료비외 : mediExps */
//
//        private TextField<String> educOtec;   /** column 교육비외 : educOtec */
//
//        private TextField<String> cdteCdec;   /** column 신용카드외 : cdteCdec */
//
//        private TextField<String> jiblCdec;   /** column 직불카드외 : jiblCdec */
//
//        private TextField<String> grpyAtec;   /** column 지로납부액_대중교통외 : grpyAtec */
//
//        private TextField<String> mgntSdec;   /** column 전통시장사용분외 : mgntSdec */
//
//        private TextField<String> ctrbAmec;   /** column 기부금액외 : ctrbAmec */
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
	
	
	
	private List<ColumnDef> getYeta3220ToYeta0300ColumnsList02() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 합계 :  */ 
        listColumnDefs.add(new ColumnDef("", Yeta3220BM.ATTR_SUMNAME, ColumnDef.TYPE_STRING, 70, true, true, true));
          
        /** column 구분 :  */
        listColumnDefs.add(new ColumnDef("구분", Yeta3220BM.ATTR_HEADER, ColumnDef.TYPE_STRING, 30, true, true, true));
        
        /** column 보험료_건강고용등국세청 : insuPayr */
        listColumnDefs.add(new ColumnDef("건강∙고용등", Yeta3220BM.ATTR_INSUPAYR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });   

        /** column 보험료보장성_국세청 : insuRtyr */
        listColumnDefs.add(new ColumnDef("보장성", Yeta3220BM.ATTR_INSURTYR, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });
        /** column 보험료장애인보장성_국세청 : psclIurr */
        listColumnDefs.add(new ColumnDef("장애인전용", Yeta3220BM.ATTR_PSCLIURR, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        }); 
        
        /** column 의료비_국세청 : mediCost */
        listColumnDefs.add(new ColumnDef("의료비", Yeta3220BM.ATTR_MEDICOST, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });
        
        /** column 교육비_국세청 : educCost */
        listColumnDefs.add(new ColumnDef("교육비", Yeta3220BM.ATTR_EDUCCOST, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });

        /** column 신용카드등_국세청 : cdteCard */
        listColumnDefs.add(new ColumnDef("신용카드등", Yeta3220BM.ATTR_CDTECARD, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });
        
        /** column 직불카드등_국세청 : jiblCard */
        listColumnDefs.add(new ColumnDef("직불카드등", Yeta3220BM.ATTR_JIBLCARD, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });
        
        /** column 현금영수증_국세청 : cashRece */
        listColumnDefs.add(new ColumnDef("현금영수증", Yeta3220BM.ATTR_CASHRECE, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });
        /** column 전통시장사용분_국세청 : mgntStvd */
        listColumnDefs.add(new ColumnDef("전통시장사용액", Yeta3220BM.ATTR_MGNTSTVD, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        }); 
        /** column 지로납부액_대중교통_국세청 : grpyAmnt */
        listColumnDefs.add(new ColumnDef("대중교통이용액", Yeta3220BM.ATTR_GRPYAMNT, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });
        
        /** column 기부금액_국세청 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부금", Yeta3220BM.ATTR_CTRBAMNT, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{

        	}
        });
        
        
        
        
        
        
//        
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3220BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 연말정산귀속년도 : edacRvyy */
//        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3220BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 정산구분코드 : settGbcd */
//        listColumnDefs.add(new ColumnDef("구분", Yeta3220BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 50, true, true, true){
//        	{
//
//        	}
//        });
//        /** column SYSTEMKEY : systemkey */
//        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3220BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//
//        /** column 보험료_건강고용등국세청 : insuPayr */
//        listColumnDefs.add(new ColumnDef("보험료_건강고용등국세청", Yeta3220BM.ATTR_INSUPAYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료보장성_국세청 : insuRtyr */
//        listColumnDefs.add(new ColumnDef("보험료보장성_국세청", Yeta3220BM.ATTR_INSURTYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료장애인보장성_국세청 : psclIurr */
//        listColumnDefs.add(new ColumnDef("보험료장애인보장성_국세청", Yeta3220BM.ATTR_PSCLIURR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 의료비_국세청 : mediCost */
//        listColumnDefs.add(new ColumnDef("의료비_국세청", Yeta3220BM.ATTR_MEDICOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 교육비_국세청 : educCost */
//        listColumnDefs.add(new ColumnDef("교육비_국세청", Yeta3220BM.ATTR_EDUCCOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 신용카드등_국세청 : cdteCard */
//        listColumnDefs.add(new ColumnDef("신용카드등_국세청", Yeta3220BM.ATTR_CDTECARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현금영수증_국세청 : cashRece */
//        listColumnDefs.add(new ColumnDef("현금영수증_국세청", Yeta3220BM.ATTR_CASHRECE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직불카드등_국세청 : jiblCard */
//        listColumnDefs.add(new ColumnDef("직불카드등_국세청", Yeta3220BM.ATTR_JIBLCARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 지로납부액_대중교통_국세청 : grpyAmnt */
//        listColumnDefs.add(new ColumnDef("지로납부액_대중교통_국세청", Yeta3220BM.ATTR_GRPYAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 전통시장사용분_국세청 : mgntStvd */
//        listColumnDefs.add(new ColumnDef("전통시장사용분_국세청", Yeta3220BM.ATTR_MGNTSTVD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 기부금액_국세청 : ctrbAmnt */
//        listColumnDefs.add(new ColumnDef("기부금액_국세청", Yeta3220BM.ATTR_CTRBAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료_건강고용등외 : insuFetc */
//        listColumnDefs.add(new ColumnDef("보험료_건강고용등외", Yeta3220BM.ATTR_INSUFETC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료보장성외 : insuRtet */
//        listColumnDefs.add(new ColumnDef("보험료보장성외", Yeta3220BM.ATTR_INSURTET, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료장애인보장성외 : psclIurt */
//        listColumnDefs.add(new ColumnDef("보험료장애인보장성외", Yeta3220BM.ATTR_PSCLIURT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 의료비외 : mediExps */
//        listColumnDefs.add(new ColumnDef("의료비외", Yeta3220BM.ATTR_MEDIEXPS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 교육비외 : educOtec */
//        listColumnDefs.add(new ColumnDef("교육비외", Yeta3220BM.ATTR_EDUCOTEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 신용카드외 : cdteCdec */
//        listColumnDefs.add(new ColumnDef("신용카드외", Yeta3220BM.ATTR_CDTECDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직불카드외 : jiblCdec */
//        listColumnDefs.add(new ColumnDef("직불카드외", Yeta3220BM.ATTR_JIBLCDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 지로납부액_대중교통외 : grpyAtec */
//        listColumnDefs.add(new ColumnDef("지로납부액_대중교통외", Yeta3220BM.ATTR_GRPYATEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 전통시장사용분외 : mgntSdec */
//        listColumnDefs.add(new ColumnDef("전통시장사용분외", Yeta3220BM.ATTR_MGNTSDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 기부금액외 : ctrbAmec */
//        listColumnDefs.add(new ColumnDef("기부금액외", Yeta3220BM.ATTR_CTRBAMEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Yeta3220BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Yeta3220BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Yeta3220BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Yeta3220BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Yeta3220BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Yeta3220BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
       
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getYeta3220ToYeta0300ColumnsList03() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 성명 : kornName */
        listColumnDefs.add(new ColumnDef("성명", Yeta3220BM.ATTR_KORNNAME, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
          
        /** column 구분 :  */
        listColumnDefs.add(new ColumnDef("구분", Yeta3220BM.ATTR_KUNM, ColumnDef.TYPE_STRING, 30, true, false, true));
        
        /** column 보험료_건강고용등국세청 : insuPayr */
        listColumnDefs.add(new ColumnDef("건강∙고용등", Yeta3220BM.ATTR_INSUPAYR, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });   

        /** column 보험료보장성_국세청 : insuRtyr */
        listColumnDefs.add(new ColumnDef("보장성", Yeta3220BM.ATTR_INSURTYR, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 보험료장애인보장성_국세청 : psclIurr */
        listColumnDefs.add(new ColumnDef("장애인전용", Yeta3220BM.ATTR_PSCLIURR, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        }); 
        
        /** column 의료비_국세청 : mediCost */
        listColumnDefs.add(new ColumnDef("의료비", Yeta3220BM.ATTR_MEDICOST, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 교육비_국세청 : educCost */
        listColumnDefs.add(new ColumnDef("교육비", Yeta3220BM.ATTR_EDUCCOST, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });

        /** column 신용카드등_국세청 : cdteCard */
        listColumnDefs.add(new ColumnDef("신용카드등", Yeta3220BM.ATTR_CDTECARD, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 직불카드등_국세청 : jiblCard */
        listColumnDefs.add(new ColumnDef("직불카드등", Yeta3220BM.ATTR_JIBLCARD, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 현금영수증_국세청 : cashRece */
        listColumnDefs.add(new ColumnDef("현금영수증", Yeta3220BM.ATTR_CASHRECE, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 전통시장사용분_국세청 : mgntStvd */
        listColumnDefs.add(new ColumnDef("전통시장사용액", Yeta3220BM.ATTR_MGNTSTVD, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        }); 
        /** column 지로납부액_대중교통_국세청 : grpyAmnt */
        listColumnDefs.add(new ColumnDef("대중교통이용액", Yeta3220BM.ATTR_GRPYAMNT, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 기부금액_국세청 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부금", Yeta3220BM.ATTR_CTRBAMNT, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        
        
    	/** column 관계 : relhCode */
        listColumnDefs.add(new ColumnDef("관계", Yeta3220BM.ATTR_RELHCODE, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });

        /** column 내외국인구분코드 : frnrCode */
        listColumnDefs.add(new ColumnDef("내국인", Yeta3220BM.ATTR_FRNRCODE, ColumnDef.TYPE_STRING, 100, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("주민번호", Yeta3220BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 120, true, false, true){
        	{

        	}
        });
        /** column 기본공제여부 : baseDdyn */
        listColumnDefs.add(new ColumnDef("기본", Yeta3220BM.ATTR_BASEDDYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        /** column 부녀자공제여부 : faddCtyn */
        listColumnDefs.add(new ColumnDef("부녀자", Yeta3220BM.ATTR_FADDCTYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        /** column 경로우대공제여부 : rpctDdyn */
        listColumnDefs.add(new ColumnDef("경로", Yeta3220BM.ATTR_RPCTDDYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        
        /** column 출산입양자공제여부 : bithDdyn */
        listColumnDefs.add(new ColumnDef("출산", Yeta3220BM.ATTR_BITHDDYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        
        /** column 장애인공제여부 : psclDdyn */
        listColumnDefs.add(new ColumnDef("장애인", Yeta3220BM.ATTR_PSCLDDYN, ColumnDef.TYPE_STRING, 60, true, false, true){
        	{

        	}
        });
        
        /** column 자녀양육비공제여부 : brddCtyn */
        listColumnDefs.add(new ColumnDef("6세", Yeta3220BM.ATTR_BRDDCTYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        /** column 한부모공제여부 : pantOnyn */
        listColumnDefs.add(new ColumnDef("한부모", Yeta3220BM.ATTR_PANTONYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3220BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3220BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3220BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3220BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        /** column 보험료_건강고용등국세청 : insuPayr */
//        listColumnDefs.add(new ColumnDef("보험료_건강고용등국세청", Yeta3220BM.ATTR_INSUPAYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료보장성_국세청 : insuRtyr */
//        listColumnDefs.add(new ColumnDef("보험료보장성_국세청", Yeta3220BM.ATTR_INSURTYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료장애인보장성_국세청 : psclIurr */
//        listColumnDefs.add(new ColumnDef("보험료장애인보장성_국세청", Yeta3220BM.ATTR_PSCLIURR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 의료비_국세청 : mediCost */
//        listColumnDefs.add(new ColumnDef("의료비_국세청", Yeta3220BM.ATTR_MEDICOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 교육비_국세청 : educCost */
//        listColumnDefs.add(new ColumnDef("교육비_국세청", Yeta3220BM.ATTR_EDUCCOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 신용카드등_국세청 : cdteCard */
//        listColumnDefs.add(new ColumnDef("신용카드등_국세청", Yeta3220BM.ATTR_CDTECARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현금영수증_국세청 : cashRece */
//        listColumnDefs.add(new ColumnDef("현금영수증_국세청", Yeta3220BM.ATTR_CASHRECE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직불카드등_국세청 : jiblCard */
//        listColumnDefs.add(new ColumnDef("직불카드등_국세청", Yeta3220BM.ATTR_JIBLCARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 지로납부액_대중교통_국세청 : grpyAmnt */
//        listColumnDefs.add(new ColumnDef("지로납부액_대중교통_국세청", Yeta3220BM.ATTR_GRPYAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 전통시장사용분_국세청 : mgntStvd */
//        listColumnDefs.add(new ColumnDef("전통시장사용분_국세청", Yeta3220BM.ATTR_MGNTSTVD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 기부금액_국세청 : ctrbAmnt */
//        listColumnDefs.add(new ColumnDef("기부금액_국세청", Yeta3220BM.ATTR_CTRBAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 보험료_건강고용등외 : insuFetc */
        listColumnDefs.add(new ColumnDef("보험료_건강고용등외", Yeta3220BM.ATTR_INSUFETC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료보장성외 : insuRtet */
        listColumnDefs.add(new ColumnDef("보험료보장성외", Yeta3220BM.ATTR_INSURTET, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료장애인보장성외 : psclIurt */
        listColumnDefs.add(new ColumnDef("보험료장애인보장성외", Yeta3220BM.ATTR_PSCLIURT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비외 : mediExps */
        listColumnDefs.add(new ColumnDef("의료비외", Yeta3220BM.ATTR_MEDIEXPS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비외 : educOtec */
        listColumnDefs.add(new ColumnDef("교육비외", Yeta3220BM.ATTR_EDUCOTEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드외 : cdteCdec */
        listColumnDefs.add(new ColumnDef("신용카드외", Yeta3220BM.ATTR_CDTECDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드외 : jiblCdec */
        listColumnDefs.add(new ColumnDef("직불카드외", Yeta3220BM.ATTR_JIBLCDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 지로납부액_대중교통외 : grpyAtec */
        listColumnDefs.add(new ColumnDef("지로납부액_대중교통외", Yeta3220BM.ATTR_GRPYATEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장사용분외 : mgntSdec */
        listColumnDefs.add(new ColumnDef("전통시장사용분외", Yeta3220BM.ATTR_MGNTSDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액외 : ctrbAmec */
        listColumnDefs.add(new ColumnDef("기부금액외", Yeta3220BM.ATTR_CTRBAMEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3220BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3220BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3220BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3220BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3220BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3220BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
//        
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3220BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 연말정산귀속년도 : edacRvyy */
//        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3220BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 정산구분코드 : settGbcd */
//        listColumnDefs.add(new ColumnDef("구분", Yeta3220BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 50, true, true, true){
//        	{
//
//        	}
//        });
//        /** column SYSTEMKEY : systemkey */
//        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3220BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//
//        /** column 보험료_건강고용등국세청 : insuPayr */
//        listColumnDefs.add(new ColumnDef("보험료_건강고용등국세청", Yeta3220BM.ATTR_INSUPAYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료보장성_국세청 : insuRtyr */
//        listColumnDefs.add(new ColumnDef("보험료보장성_국세청", Yeta3220BM.ATTR_INSURTYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료장애인보장성_국세청 : psclIurr */
//        listColumnDefs.add(new ColumnDef("보험료장애인보장성_국세청", Yeta3220BM.ATTR_PSCLIURR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 의료비_국세청 : mediCost */
//        listColumnDefs.add(new ColumnDef("의료비_국세청", Yeta3220BM.ATTR_MEDICOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 교육비_국세청 : educCost */
//        listColumnDefs.add(new ColumnDef("교육비_국세청", Yeta3220BM.ATTR_EDUCCOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 신용카드등_국세청 : cdteCard */
//        listColumnDefs.add(new ColumnDef("신용카드등_국세청", Yeta3220BM.ATTR_CDTECARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현금영수증_국세청 : cashRece */
//        listColumnDefs.add(new ColumnDef("현금영수증_국세청", Yeta3220BM.ATTR_CASHRECE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직불카드등_국세청 : jiblCard */
//        listColumnDefs.add(new ColumnDef("직불카드등_국세청", Yeta3220BM.ATTR_JIBLCARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 지로납부액_대중교통_국세청 : grpyAmnt */
//        listColumnDefs.add(new ColumnDef("지로납부액_대중교통_국세청", Yeta3220BM.ATTR_GRPYAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 전통시장사용분_국세청 : mgntStvd */
//        listColumnDefs.add(new ColumnDef("전통시장사용분_국세청", Yeta3220BM.ATTR_MGNTSTVD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 기부금액_국세청 : ctrbAmnt */
//        listColumnDefs.add(new ColumnDef("기부금액_국세청", Yeta3220BM.ATTR_CTRBAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료_건강고용등외 : insuFetc */
//        listColumnDefs.add(new ColumnDef("보험료_건강고용등외", Yeta3220BM.ATTR_INSUFETC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료보장성외 : insuRtet */
//        listColumnDefs.add(new ColumnDef("보험료보장성외", Yeta3220BM.ATTR_INSURTET, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 보험료장애인보장성외 : psclIurt */
//        listColumnDefs.add(new ColumnDef("보험료장애인보장성외", Yeta3220BM.ATTR_PSCLIURT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 의료비외 : mediExps */
//        listColumnDefs.add(new ColumnDef("의료비외", Yeta3220BM.ATTR_MEDIEXPS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 교육비외 : educOtec */
//        listColumnDefs.add(new ColumnDef("교육비외", Yeta3220BM.ATTR_EDUCOTEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 신용카드외 : cdteCdec */
//        listColumnDefs.add(new ColumnDef("신용카드외", Yeta3220BM.ATTR_CDTECDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직불카드외 : jiblCdec */
//        listColumnDefs.add(new ColumnDef("직불카드외", Yeta3220BM.ATTR_JIBLCDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 지로납부액_대중교통외 : grpyAtec */
//        listColumnDefs.add(new ColumnDef("지로납부액_대중교통외", Yeta3220BM.ATTR_GRPYATEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 전통시장사용분외 : mgntSdec */
//        listColumnDefs.add(new ColumnDef("전통시장사용분외", Yeta3220BM.ATTR_MGNTSDEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 기부금액외 : ctrbAmec */
//        listColumnDefs.add(new ColumnDef("기부금액외", Yeta3220BM.ATTR_CTRBAMEC, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Yeta3220BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Yeta3220BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Yeta3220BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Yeta3220BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Yeta3220BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Yeta3220BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
       
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getYeta3220ToYeta0300ColumnsList04() {
		
		
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        /** column 성명 : kornName */
        listColumnDefs.add(new ColumnDef("성명", Yeta3220BM.ATTR_KORNNAME, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
          
        /** column 구분 :  */
        listColumnDefs.add(new ColumnDef("구분", Yeta3220BM.ATTR_KINM, ColumnDef.TYPE_STRING, 30, true, false, true));
          
        
        /** column 보험료_건강고용등외 : insuFetc */
        listColumnDefs.add(new ColumnDef("건강∙고용등", Yeta3220BM.ATTR_INSUFETC, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
          

        /** column 보험료보장성외 : insuRtet */
        listColumnDefs.add(new ColumnDef("보장성", Yeta3220BM.ATTR_INSURTET, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        

        /** column 보험료장애인보장성외 : psclIurt */
        listColumnDefs.add(new ColumnDef("장애인전용", Yeta3220BM.ATTR_PSCLIURT, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });

        /** column 의료비외 : mediExps */
        listColumnDefs.add(new ColumnDef("의료비", Yeta3220BM.ATTR_MEDIEXPS, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        
        /** column 교육비외 : educOtec */
        listColumnDefs.add(new ColumnDef("교육비", Yeta3220BM.ATTR_EDUCOTEC, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 신용카드외 : cdteCdec */
        listColumnDefs.add(new ColumnDef("신용카드", Yeta3220BM.ATTR_CDTECDEC, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 직불카드외 : jiblCdec */
        listColumnDefs.add(new ColumnDef("직불카드등", Yeta3220BM.ATTR_JIBLCDEC, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        
        /** column 현금영수증   */
        listColumnDefs.add(new ColumnDef("현금영수증", Yeta3220BM.ATTR_TEMP, ColumnDef.TYPE_STRING, 70, true, true, true){
        	{
        		setReadOnly(true);
        	}
        }); 
        
        /** column 전통시장사용분외 : mgntSdec */
        listColumnDefs.add(new ColumnDef("전통시장사용액", Yeta3220BM.ATTR_MGNTSDEC, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 지로납부액_대중교통외 : grpyAtec */
        listColumnDefs.add(new ColumnDef("대중교통이용액", Yeta3220BM.ATTR_GRPYATEC, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 기부금액외 : ctrbAmec */
        listColumnDefs.add(new ColumnDef("기부금", Yeta3220BM.ATTR_CTRBAMEC, ColumnDef.TYPE_LONG , 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3220BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3220BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("구분", Yeta3220BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 50, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3220BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 보험료_건강고용등국세청 : insuPayr */
        listColumnDefs.add(new ColumnDef("보험료_건강고용등국세청", Yeta3220BM.ATTR_INSUPAYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료보장성_국세청 : insuRtyr */
        listColumnDefs.add(new ColumnDef("보험료보장성_국세청", Yeta3220BM.ATTR_INSURTYR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료장애인보장성_국세청 : psclIurr */
        listColumnDefs.add(new ColumnDef("보험료장애인보장성_국세청", Yeta3220BM.ATTR_PSCLIURR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_국세청 : mediCost */
        listColumnDefs.add(new ColumnDef("의료비_국세청", Yeta3220BM.ATTR_MEDICOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_국세청 : educCost */
        listColumnDefs.add(new ColumnDef("교육비_국세청", Yeta3220BM.ATTR_EDUCCOST, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등_국세청 : cdteCard */
        listColumnDefs.add(new ColumnDef("신용카드등_국세청", Yeta3220BM.ATTR_CDTECARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 현금영수증_국세청 : cashRece */
        listColumnDefs.add(new ColumnDef("현금영수증_국세청", Yeta3220BM.ATTR_CASHRECE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드등_국세청 : jiblCard */
        listColumnDefs.add(new ColumnDef("직불카드등_국세청", Yeta3220BM.ATTR_JIBLCARD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 지로납부액_대중교통_국세청 : grpyAmnt */
        listColumnDefs.add(new ColumnDef("지로납부액_대중교통_국세청", Yeta3220BM.ATTR_GRPYAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 전통시장사용분_국세청 : mgntStvd */
        listColumnDefs.add(new ColumnDef("전통시장사용분_국세청", Yeta3220BM.ATTR_MGNTSTVD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액_국세청 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부금액_국세청", Yeta3220BM.ATTR_CTRBAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 관계 : relhCode */
        listColumnDefs.add(new ColumnDef("관계", Yeta3220BM.ATTR_RELHCODE, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });

        /** column 내외국인구분코드 : frnrCode */
        listColumnDefs.add(new ColumnDef("내국인", Yeta3220BM.ATTR_FRNRCODE, ColumnDef.TYPE_STRING, 100, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("주민번호", Yeta3220BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 120, true, false, true){
        	{

        	}
        });
        /** column 기본공제여부 : baseDdyn */
        listColumnDefs.add(new ColumnDef("기본", Yeta3220BM.ATTR_BASEDDYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        /** column 부녀자공제여부 : faddCtyn */
        listColumnDefs.add(new ColumnDef("부녀자", Yeta3220BM.ATTR_FADDCTYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        /** column 경로우대공제여부 : rpctDdyn */
        listColumnDefs.add(new ColumnDef("경로", Yeta3220BM.ATTR_RPCTDDYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        
        /** column 출산입양자공제여부 : bithDdyn */
        listColumnDefs.add(new ColumnDef("출산", Yeta3220BM.ATTR_BITHDDYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        
        /** column 장애인공제여부 : psclDdyn */
        listColumnDefs.add(new ColumnDef("장애인", Yeta3220BM.ATTR_PSCLDDYN, ColumnDef.TYPE_STRING, 60, true, false, true){
        	{

        	}
        });
        
        /** column 자녀양육비공제여부 : brddCtyn */
        listColumnDefs.add(new ColumnDef("6세", Yeta3220BM.ATTR_BRDDCTYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        /** column 한부모공제여부 : pantOnyn */
        listColumnDefs.add(new ColumnDef("한부모", Yeta3220BM.ATTR_PANTONYN, ColumnDef.TYPE_BOOLEAN, 60, true, false, true){
        	{

        	}
        });
        

        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3220BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3220BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3220BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3220BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3220BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3220BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
          return listColumnDefs;
	}


}
