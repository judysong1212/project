package com.app.exterms.yearendtax.client.form.defs.yeta2017;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye17Ta1000Def extends TableDef implements YetaDaoConstants{
	
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Ye17Ta1000Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETA2400".equals(chkDef)) {
//		setTitle("연말정산대상자 및 내역");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA2400LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(false);
		    setColumnsDefinition(getColumnsList()); 
		}else if("YETA1500".equals(chkDef)) {
//			setTitle("연말정산대상자 및 내역");
				setTitle("");
		        setDaoClass("");
		        setCustomListMethod(CLASS_YETA1500LIST);
		  	  	setAutoFillGrid(false);
		        setShowFilterToolbar(false);   
		        setCheckBoxOnGridRows(true); 
			    setEditFieldGrid(true);
			    setColumnsDefinition(getYeta1000ToYeta0500ColumnsList()); 
		}
	}

	private List<ColumnDef> getColumnsList() {
	 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("정산년도", Ye16Ta1000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서명 : deptNm */
        listColumnDefs.add(new ColumnDef("부서", Ye16Ta1000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 고용구분코드 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Ye16Ta1000BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Ye16Ta1000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta1000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
       
        
        /** column 직종세명 : dtilOccuInttnNm */
        listColumnDefs.add(new ColumnDef("직종세", Ye16Ta1000BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업", Ye16Ta1000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        
        /** column 총급여 : ITEM01 */
        listColumnDefs.add(new ColumnDef("총급여", Ye16Ta1000BM.ATTR_ITEM01, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 비과세 : ITEM02 */
        listColumnDefs.add(new ColumnDef("비과세", Ye16Ta1000BM.ATTR_ITEM02, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 소득세 : ITEM03 */
        listColumnDefs.add(new ColumnDef("소득세", Ye16Ta1000BM.ATTR_ITEM03, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 주민세 : ITEM04 */
        listColumnDefs.add(new ColumnDef("주민세", Ye16Ta1000BM.ATTR_ITEM04, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 건강보험 : ITEM05 */
        listColumnDefs.add(new ColumnDef("건강보험", Ye16Ta1000BM.ATTR_ITEM05, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 국민연금 : ITEM06 */
        listColumnDefs.add(new ColumnDef("국민연금", Ye16Ta1000BM.ATTR_ITEM06, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 고용보험 : ITEM07 */
        listColumnDefs.add(new ColumnDef("고용보험", Ye16Ta1000BM.ATTR_ITEM07, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 결정세액(소득세)  : ITEM15 */
        listColumnDefs.add(new ColumnDef("결정세액(소득세)", Ye16Ta1000BM.ATTR_ITEM15, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 결정세액(주민세)  : ITEM16 */
        listColumnDefs.add(new ColumnDef("결정세액(주민세)", Ye16Ta1000BM.ATTR_ITEM16, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        
        
        /** column 환급소득세 : ITEM08 */
        listColumnDefs.add(new ColumnDef("환급소득세", Ye16Ta1000BM.ATTR_ITEM08, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 환급주민세 : ITEM09 */
        listColumnDefs.add(new ColumnDef("환급주민세", Ye16Ta1000BM.ATTR_ITEM09, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 환급계 : ITEM10 */
        listColumnDefs.add(new ColumnDef("환급계", Ye16Ta1000BM.ATTR_ITEM10, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 환급소득세(재) : ITEM11 */
        listColumnDefs.add(new ColumnDef("환급소득세(재) ", Ye16Ta1000BM.ATTR_ITEM11, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 환급주민세(재) : ITEM12 */
        listColumnDefs.add(new ColumnDef("환급주민세(재)", Ye16Ta1000BM.ATTR_ITEM12, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 재정산환급계 : ITEM13 */
        listColumnDefs.add(new ColumnDef("재정산환급계", Ye16Ta1000BM.ATTR_ITEM13, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 환급차액 : ITEM14 */
        listColumnDefs.add(new ColumnDef("환급차액", Ye16Ta1000BM.ATTR_ITEM14, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta1000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta1000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산마감일련번호 : edacSeilNum */
        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta1000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta1000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta1000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta1000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta1000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종명 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Ye16Ta1000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta1000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta1000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta1000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta1000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 생성직원번호 : pernChrgEmpIdenNum */
        listColumnDefs.add(new ColumnDef("생성직원번호", Ye16Ta1000BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감여부 : closFlag */
        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta1000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감건수 : closCont */
        listColumnDefs.add(new ColumnDef("마감건수", Ye16Ta1000BM.ATTR_CLOSCONT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : closDate */
        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta1000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산제출일자 : edacPrdt */
        listColumnDefs.add(new ColumnDef("연말정산제출일자", Ye16Ta1000BM.ATTR_EDACPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자성명 : reprName */
        listColumnDefs.add(new ColumnDef("대표자성명", Ye16Ta1000BM.ATTR_REPRNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인명_상호 : juriName */
        listColumnDefs.add(new ColumnDef("법인명_상호", Ye16Ta1000BM.ATTR_JURINAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busiNumb */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Ye16Ta1000BM.ATTR_BUSINUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resuNumb */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta1000BM.ATTR_RESUNUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인번호 : juriNumb */
        listColumnDefs.add(new ColumnDef("법인번호", Ye16Ta1000BM.ATTR_JURINUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자우편번호 : incmPost */
        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Ye16Ta1000BM.ATTR_INCMPOST, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자기본주소 : incmAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Ye16Ta1000BM.ATTR_INCMADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자상세주소 : incmAdtl */
        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Ye16Ta1000BM.ATTR_INCMADTL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관할세무서코드 : taxaCode */
        listColumnDefs.add(new ColumnDef("관할세무서코드", Ye16Ta1000BM.ATTR_TAXACODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 제출자구분코드 : incmGbcd */
        listColumnDefs.add(new ColumnDef("제출자구분코드", Ye16Ta1000BM.ATTR_INCMGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무대리인번호 : taxaDnum */
        listColumnDefs.add(new ColumnDef("세무대리인번호", Ye16Ta1000BM.ATTR_TAXADNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 홈텍스ID : homeTxid */
        listColumnDefs.add(new ColumnDef("홈텍스ID", Ye16Ta1000BM.ATTR_HOMETXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무프로그램코드 : taxaPrcd */
        listColumnDefs.add(new ColumnDef("세무프로그램코드", Ye16Ta1000BM.ATTR_TAXAPRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자부서명 : charDept */
        listColumnDefs.add(new ColumnDef("담당자부서명", Ye16Ta1000BM.ATTR_CHARDEPT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자성명 : charName */
        listColumnDefs.add(new ColumnDef("담당자성명", Ye16Ta1000BM.ATTR_CHARNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자전화번호 : charTele */
        listColumnDefs.add(new ColumnDef("담당자전화번호", Ye16Ta1000BM.ATTR_CHARTELE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column FILE_PASS : filePass */
        listColumnDefs.add(new ColumnDef("FILE_PASS", Ye16Ta1000BM.ATTR_FILEPASS, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta1000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta1000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta1000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta1000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta1000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta1000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> edacSeilNum;   /** column 연말정산마감일련번호 : edacSeilNum */
//
//        private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> pernChrgEmpIdenNum;   /** column 생성직원번호 : pernChrgEmpIdenNum */
//
//        private TextField<String> closFlag;   /** column 마감여부 : closFlag */
//
//        private TextField<String> closCont;   /** column 마감건수 : closCont */
//
//        private TextField<String> closDate;   /** column 마감일자 : closDate */
//
//        private TextField<String> edacPrdt;   /** column 연말정산제출일자 : edacPrdt */
//
//        private TextField<String> reprName;   /** column 대표자성명 : reprName */
//
//        private TextField<String> juriName;   /** column 법인명_상호 : juriName */
//
//        private TextField<String> busiNumb;   /** column 사업자등록번호 : busiNumb */
//
//        private TextField<String> resuNumb;   /** column 주민등록번호 : resuNumb */
//
//        private TextField<String> juriNumb;   /** column 법인번호 : juriNumb */
//
//        private TextField<String> incmPost;   /** column 소득신고의무자우편번호 : incmPost */
//
//        private TextField<String> incmAddr;   /** column 소득신고의무자기본주소 : incmAddr */
//
//        private TextField<String> incmAdtl;   /** column 소득신고의무자상세주소 : incmAdtl */
//
//        private TextField<String> taxaCode;   /** column 관할세무서코드 : taxaCode */
//
//        private TextField<String> incmGbcd;   /** column 제출자구분코드 : incmGbcd */
//
//        private TextField<String> taxaDnum;   /** column 세무대리인번호 : taxaDnum */
//
//        private TextField<String> homeTxid;   /** column 홈텍스ID : homeTxid */
//
//        private TextField<String> taxaPrcd;   /** column 세무프로그램코드 : taxaPrcd */
//
//        private TextField<String> charDept;   /** column 담당자부서명 : charDept */
//
//        private TextField<String> charName;   /** column 담당자성명 : charName */
//
//        private TextField<String> charTele;   /** column 담당자전화번호 : charTele */
//
//        private TextField<String> filePass;   /** column FILE_PASS : filePass */
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
	
	
	
	private List<ColumnDef> getYeta1000ToYeta0500ColumnsList() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("정산년도", Ye16Ta1000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서명 : deptNm */
        listColumnDefs.add(new ColumnDef("부서", Ye16Ta1000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 고용구분코드 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Ye16Ta1000BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Ye16Ta1000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta1000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 연말정산적용년월 : yrtxApptnYrMnth */
        listColumnDefs.add(new ColumnDef("급여년월", Ye16Ta2000BM.ATTR_YRTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 연말정산처리여부 : yrtxPrcsYn */
        listColumnDefs.add(new ColumnDef("처리", Ye16Ta2000BM.ATTR_YRTXPRCSYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 연말정산처리일자 : yrtxPrcsDt */
        listColumnDefs.add(new ColumnDef("연말정산처리일자", Ye16Ta2000BM.ATTR_YRTXPRCSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("B030");
        /** column 분할납부구분코드 : divdPymtDivCd */
        listColumnDefs.add(new ColumnListDef("분납구분", Ye16Ta2000BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90,  true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		
        	}
        });  
        listColumnDefs.add(new ColumnDef("분할납부구분코드", Ye16Ta2000BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 분할납부횟수 : divdPymt */
        listColumnDefs.add(new ColumnDef("분납횟수", Ye16Ta2000BM.ATTR_DIVDPYMT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 직종세명 : dtilOccuInttnNm */
        listColumnDefs.add(new ColumnDef("직종세", Ye16Ta1000BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업", Ye16Ta1000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        
        /** column 총급여 : ITEM01 */
        listColumnDefs.add(new ColumnDef("총급여", Ye16Ta1000BM.ATTR_ITEM01, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 비과세 : ITEM02 */
        listColumnDefs.add(new ColumnDef("비과세", Ye16Ta1000BM.ATTR_ITEM02, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 소득세 : ITEM03 */
        listColumnDefs.add(new ColumnDef("소득세", Ye16Ta1000BM.ATTR_ITEM03, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 주민세 : ITEM04 */
        listColumnDefs.add(new ColumnDef("주민세", Ye16Ta1000BM.ATTR_ITEM04, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 건강보험 : ITEM05 */
        listColumnDefs.add(new ColumnDef("건강보험", Ye16Ta1000BM.ATTR_ITEM05, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 국민연금 : ITEM06 */
        listColumnDefs.add(new ColumnDef("국민연금", Ye16Ta1000BM.ATTR_ITEM06, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 고용보험 : ITEM07 */
        listColumnDefs.add(new ColumnDef("고용보험", Ye16Ta1000BM.ATTR_ITEM07, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 환급소득세 : ITEM08 */
        listColumnDefs.add(new ColumnDef("환급소득세", Ye16Ta1000BM.ATTR_ITEM08, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 환급주민세 : ITEM09 */
        listColumnDefs.add(new ColumnDef("환급주민세", Ye16Ta1000BM.ATTR_ITEM09, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 환급계 : ITEM10 */
        listColumnDefs.add(new ColumnDef("환급계", Ye16Ta1000BM.ATTR_ITEM10, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 환급소득세(재) : ITEM11 */
        listColumnDefs.add(new ColumnDef("환급소득세(재) ", Ye16Ta1000BM.ATTR_ITEM11, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 환급주민세(재) : ITEM12 */
        listColumnDefs.add(new ColumnDef("환급주민세(재)", Ye16Ta1000BM.ATTR_ITEM12, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 재정산환급계 : ITEM13 */
        listColumnDefs.add(new ColumnDef("재정산환급계", Ye16Ta1000BM.ATTR_ITEM13, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        /** column 환급차액 : ITEM14 */
        listColumnDefs.add(new ColumnDef("환급차액", Ye16Ta1000BM.ATTR_ITEM14, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta1000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta1000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산마감일련번호 : edacSeilNum */
        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta1000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta1000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta1000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta1000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 직종명 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Ye16Ta1000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta1000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta1000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta1000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta1000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta1000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 생성직원번호 : pernChrgEmpIdenNum */
        listColumnDefs.add(new ColumnDef("생성직원번호", Ye16Ta1000BM.ATTR_PERNCHRGEMPIDENNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감여부 : closFlag */
        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta1000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감건수 : closCont */
        listColumnDefs.add(new ColumnDef("마감건수", Ye16Ta1000BM.ATTR_CLOSCONT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : closDate */
        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta1000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산제출일자 : edacPrdt */
        listColumnDefs.add(new ColumnDef("연말정산제출일자", Ye16Ta1000BM.ATTR_EDACPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자성명 : reprName */
        listColumnDefs.add(new ColumnDef("대표자성명", Ye16Ta1000BM.ATTR_REPRNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인명_상호 : juriName */
        listColumnDefs.add(new ColumnDef("법인명_상호", Ye16Ta1000BM.ATTR_JURINAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busiNumb */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Ye16Ta1000BM.ATTR_BUSINUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resuNumb */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta1000BM.ATTR_RESUNUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인번호 : juriNumb */
        listColumnDefs.add(new ColumnDef("법인번호", Ye16Ta1000BM.ATTR_JURINUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자우편번호 : incmPost */
        listColumnDefs.add(new ColumnDef("소득신고의무자우편번호", Ye16Ta1000BM.ATTR_INCMPOST, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자기본주소 : incmAddr */
        listColumnDefs.add(new ColumnDef("소득신고의무자기본주소", Ye16Ta1000BM.ATTR_INCMADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고의무자상세주소 : incmAdtl */
        listColumnDefs.add(new ColumnDef("소득신고의무자상세주소", Ye16Ta1000BM.ATTR_INCMADTL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관할세무서코드 : taxaCode */
        listColumnDefs.add(new ColumnDef("관할세무서코드", Ye16Ta1000BM.ATTR_TAXACODE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 제출자구분코드 : incmGbcd */
        listColumnDefs.add(new ColumnDef("제출자구분코드", Ye16Ta1000BM.ATTR_INCMGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무대리인번호 : taxaDnum */
        listColumnDefs.add(new ColumnDef("세무대리인번호", Ye16Ta1000BM.ATTR_TAXADNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 홈텍스ID : homeTxid */
        listColumnDefs.add(new ColumnDef("홈텍스ID", Ye16Ta1000BM.ATTR_HOMETXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무프로그램코드 : taxaPrcd */
        listColumnDefs.add(new ColumnDef("세무프로그램코드", Ye16Ta1000BM.ATTR_TAXAPRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자부서명 : charDept */
        listColumnDefs.add(new ColumnDef("담당자부서명", Ye16Ta1000BM.ATTR_CHARDEPT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자성명 : charName */
        listColumnDefs.add(new ColumnDef("담당자성명", Ye16Ta1000BM.ATTR_CHARNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당자전화번호 : charTele */
        listColumnDefs.add(new ColumnDef("담당자전화번호", Ye16Ta1000BM.ATTR_CHARTELE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column FILE_PASS : filePass */
        listColumnDefs.add(new ColumnDef("FILE_PASS", Ye16Ta1000BM.ATTR_FILEPASS, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        

        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta1000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta1000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta1000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta1000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta1000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta1000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
          
          return listColumnDefs;
	}

}
