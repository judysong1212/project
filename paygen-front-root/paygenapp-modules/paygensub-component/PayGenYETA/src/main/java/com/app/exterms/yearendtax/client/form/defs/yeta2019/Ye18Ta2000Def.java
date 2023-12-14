package com.app.exterms.yearendtax.client.form.defs.yeta2019;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0400BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0400;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3000BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Ye18Ta2000Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	
	private PrgmComBass0400DTO sysComBass0400Dto;
	// 권한 설정 객체
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	
	
    protected ColumnListDef deptCdColumnDef;
	
	public Ye18Ta2000Def(String chkDef) {
		
		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		sysComBass0400Dto = new PrgmComBass0400DTO();
       	  
		if("YETAP410002".equals(chkDef)){
			
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAP110002ToYE16TA2000_LIST);
	  	  	setAutoFillGrid(true);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getYetaP110002ToYeta2000ColumnsList()); 	
			 	    
		} 
		

	}

	private List<ColumnDef> getColumnsList() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye16Ta2000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산마감일련번호 : edacSeilNum */
        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta2000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta2000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Ye16Ta2000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta2000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Ye16Ta2000BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉코드 : pyspCd */
        listColumnDefs.add(new ColumnDef("호봉코드", Ye16Ta2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Ye16Ta2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수코드 : logSvcMnthIcmCd */
        listColumnDefs.add(new ColumnDef("근속월수코드", Ye16Ta2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Ye16Ta2000BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자", Ye16Ta2000BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("고용종료일자", Ye16Ta2000BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 재직구분코드 : hdofcDivCd */
        listColumnDefs.add(new ColumnDef("재직구분코드", Ye16Ta2000BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직일자 : retryDt */
        listColumnDefs.add(new ColumnDef("퇴직일자", Ye16Ta2000BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산적용년월 : yrtxApptnYrMnth */
        listColumnDefs.add(new ColumnDef("연말정산적용년월", Ye16Ta2000BM.ATTR_YRTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산처리일자 : yrtxPrcsDt */
        listColumnDefs.add(new ColumnDef("연말정산처리일자", Ye16Ta2000BM.ATTR_YRTXPRCSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산처리여부 : yrtxPrcsYn */
        listColumnDefs.add(new ColumnDef("연말정산처리여부", Ye16Ta2000BM.ATTR_YRTXPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 분할납부구분코드 : divdPymtDivCd */
        listColumnDefs.add(new ColumnDef("분할납부구분코드", Ye16Ta2000BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 분할납부횟수 : divdPymt */
        listColumnDefs.add(new ColumnDef("분할납부횟수", Ye16Ta2000BM.ATTR_DIVDPYMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세대주여부 : gnanSgtf */
        listColumnDefs.add(new ColumnDef("세대주여부", Ye16Ta2000BM.ATTR_GNANSGTF, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인구분코드 : frnrYeno */
        listColumnDefs.add(new ColumnDef("외국인구분코드", Ye16Ta2000BM.ATTR_FRNRYENO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_FROM : reymStdt */
        listColumnDefs.add(new ColumnDef("귀속년월_FROM", Ye16Ta2000BM.ATTR_REYMSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_TO : reymEddt */
        listColumnDefs.add(new ColumnDef("귀속년월_TO", Ye16Ta2000BM.ATTR_REYMEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_TO : rutrEddt */
        listColumnDefs.add(new ColumnDef("감면기간_TO", Ye16Ta2000BM.ATTR_RUTREDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_FROM : rutrStdt */
        listColumnDefs.add(new ColumnDef("감면기간_FROM", Ye16Ta2000BM.ATTR_RUTRSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주구분여부 : resdFlag */
        listColumnDefs.add(new ColumnDef("거주구분여부", Ye16Ta2000BM.ATTR_RESDFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국적코드 : natnGbcd */
        listColumnDefs.add(new ColumnDef("국적코드", Ye16Ta2000BM.ATTR_NATNGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국적명 : natnName */
        listColumnDefs.add(new ColumnDef("국적명", Ye16Ta2000BM.ATTR_NATNNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지국코드 : redtGbcd */
        listColumnDefs.add(new ColumnDef("거주지국코드", Ye16Ta2000BM.ATTR_REDTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지국명 : redtName */
        listColumnDefs.add(new ColumnDef("거주지국명", Ye16Ta2000BM.ATTR_REDTNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 인적공제항목변동여부 : humnCgue */
        listColumnDefs.add(new ColumnDef("인적공제항목변동여부", Ye16Ta2000BM.ATTR_HUMNCGUE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인단일세율적용여부 : frnrSgyn */
        listColumnDefs.add(new ColumnDef("외국인단일세율적용여부", Ye16Ta2000BM.ATTR_FRNRSGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제_배우자유무 : baseWiyn */
        listColumnDefs.add(new ColumnDef("기본공제_배우자유무", Ye16Ta2000BM.ATTR_BASEWIYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제_부양가족수 : baseFmly */
        listColumnDefs.add(new ColumnDef("기본공제_부양가족수", Ye16Ta2000BM.ATTR_BASEFMLY, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_경로우대_70세이상수 : addrCt70 */
        listColumnDefs.add(new ColumnDef("추가공제_경로우대_70세이상수", Ye16Ta2000BM.ATTR_ADDRCT70, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_장애인수 : addrHdrc */
        listColumnDefs.add(new ColumnDef("추가공제_장애인수", Ye16Ta2000BM.ATTR_ADDRHDRC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_부녀자수 : addrFdsu */
        listColumnDefs.add(new ColumnDef("추가공제_부녀자수", Ye16Ta2000BM.ATTR_ADDRFDSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_자녀양육비양육수 : addrClct */
        listColumnDefs.add(new ColumnDef("추가공제_자녀양육비양육수", Ye16Ta2000BM.ATTR_ADDRCLCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_출산자녀양육수 : addrBhct */
        listColumnDefs.add(new ColumnDef("추가공제_출산자녀양육수", Ye16Ta2000BM.ATTR_ADDRBHCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_한부모수 : pantOnsu */
        listColumnDefs.add(new ColumnDef("추가공제_한부모수", Ye16Ta2000BM.ATTR_PANTONSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_다자녀인원수 : addrMrct */
        listColumnDefs.add(new ColumnDef("추가공제_다자녀인원수", Ye16Ta2000BM.ATTR_ADDRMRCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금보험료 : bnatPsnf */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금보험료", Ye16Ta2000BM.ATTR_BNATPSNF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금보험료 : jnatPsnf */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금보험료", Ye16Ta2000BM.ATTR_JNATPSNF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외교직원연금 : bpssTech */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외교직원연금", Ye16Ta2000BM.ATTR_BPSSTECH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외공무원연금 : bpssPulc */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외공무원연금", Ye16Ta2000BM.ATTR_BPSSPULC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외별정우체국 : bpssFect */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외별정우체국", Ye16Ta2000BM.ATTR_BPSSFECT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외군인연금 : bpssSold */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외군인연금", Ye16Ta2000BM.ATTR_BPSSSOLD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외공무원연금 : jpssPulc */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외공무원연금", Ye16Ta2000BM.ATTR_JPSSPULC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외군인연금 : jpssSold */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외군인연금", Ye16Ta2000BM.ATTR_JPSSSOLD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국인연금외교직원연금 : jpssTech */
        listColumnDefs.add(new ColumnDef("주근무지_국인연금외교직원연금", Ye16Ta2000BM.ATTR_JPSSTECH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외별정우체국 : jpssFect */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외별정우체국", Ye16Ta2000BM.ATTR_JPSSFECT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_종_근로자퇴직보장법 : brtrPsct */
        listColumnDefs.add(new ColumnDef("종근무지_종_근로자퇴직보장법", Ye16Ta2000BM.ATTR_BRTRPSCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_종_과학기술인공제 : brtrCict */
        listColumnDefs.add(new ColumnDef("종근무지_종_과학기술인공제", Ye16Ta2000BM.ATTR_BRTRCICT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_연금계좌_연금저축 : brtrAnsv */
        listColumnDefs.add(new ColumnDef("종근무지_연금계좌_연금저축", Ye16Ta2000BM.ATTR_BRTRANSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금과학기술인공제 : jrtrCict */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금과학기술인공제", Ye16Ta2000BM.ATTR_JRTRCICT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금과학기술인공제대상금액", Ye16Ta2000BM.ATTR_JRTRCTAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금근로자퇴직급여보장법", Ye16Ta2000BM.ATTR_JRTRPSCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금근로자퇴직급여보장대상금액", Ye16Ta2000BM.ATTR_JRTRPTAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_연금계좌_연금저축 : jrtrAnsv */
        listColumnDefs.add(new ColumnDef("주근무지_연금계좌_연금저축", Ye16Ta2000BM.ATTR_JRTRANSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
        listColumnDefs.add(new ColumnDef("주근무지_연금계좌저축공제대상금액", Ye16Ta2000BM.ATTR_JRTRATAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금보험료계 : rrptAmnt */
        listColumnDefs.add(new ColumnDef("연금보험료계", Ye16Ta2000BM.ATTR_RRPTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_종건강보험료 : spciBhlh */
        listColumnDefs.add(new ColumnDef("특별공제_종건강보험료", Ye16Ta2000BM.ATTR_SPCIBHLH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주건강보험료 : spciHhlh */
        listColumnDefs.add(new ColumnDef("특별공제_주건강보험료", Ye16Ta2000BM.ATTR_SPCIHHLH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_종고용보험료 : spciBepf */
        listColumnDefs.add(new ColumnDef("특별공제_종고용보험료", Ye16Ta2000BM.ATTR_SPCIBEPF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주고용보험료 : spciJepf */
        listColumnDefs.add(new ColumnDef("특별공제_주고용보험료", Ye16Ta2000BM.ATTR_SPCIJEPF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_일반보장성보험료 : spciGurt */
        listColumnDefs.add(new ColumnDef("특별공제_일반보장성보험료", Ye16Ta2000BM.ATTR_SPCIGURT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인전용보험료 : spciHdrc */
        listColumnDefs.add(new ColumnDef("특별공제_장애인전용보험료", Ye16Ta2000BM.ATTR_SPCIHDRC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
        listColumnDefs.add(new ColumnDef("특별공제_보장성보험료공제대상금액", Ye16Ta2000BM.ATTR_SPCIRTTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보험료계 : spciIuam */
        listColumnDefs.add(new ColumnDef("특별공제_보험료계", Ye16Ta2000BM.ATTR_SPCIIUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_본인 : spciSelf */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_본인", Ye16Ta2000BM.ATTR_SPCISELF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_경로65세이상 : spciAe65 */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_경로65세이상", Ye16Ta2000BM.ATTR_SPCIAE65, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_장애인 : spciDbps */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_장애인", Ye16Ta2000BM.ATTR_SPCIDBPS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_기타공제대상자 : spciDetc */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_기타공제대상자", Ye16Ta2000BM.ATTR_SPCIDETC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비세액공제대상금액 : spciDtar */
        listColumnDefs.add(new ColumnDef("특별공제_의료비세액공제대상금액", Ye16Ta2000BM.ATTR_SPCIDTAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비계 : spciEtam */
        listColumnDefs.add(new ColumnDef("특별공제_의료비계", Ye16Ta2000BM.ATTR_SPCIETAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_본인 : spedSelf */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_본인", Ye16Ta2000BM.ATTR_SPEDSELF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_취학전아동수 : spedEdsu */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_취학전아동수", Ye16Ta2000BM.ATTR_SPEDEDSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_취학전아동 : spedEdam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_취학전아동", Ye16Ta2000BM.ATTR_SPEDEDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_초중고자녀수 : spedGdsu */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_초중고자녀수", Ye16Ta2000BM.ATTR_SPEDGDSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_초중고 : spedGdam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_초중고", Ye16Ta2000BM.ATTR_SPEDGDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_대학생수 : spedCvsu */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_대학생수", Ye16Ta2000BM.ATTR_SPEDCVSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_대학교 : spedCvam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_대학교", Ye16Ta2000BM.ATTR_SPEDCVAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인수 : spciScsu */
        listColumnDefs.add(new ColumnDef("특별공제_장애인수", Ye16Ta2000BM.ATTR_SPCISCSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인특수교육비 : spciScam */
        listColumnDefs.add(new ColumnDef("특별공제_장애인특수교육비", Ye16Ta2000BM.ATTR_SPCISCAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비공제대상금액 : spedEtar */
        listColumnDefs.add(new ColumnDef("특별공제_교육비공제대상금액", Ye16Ta2000BM.ATTR_SPEDETAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비계 : siedToam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비계", Ye16Ta2000BM.ATTR_SIEDTOAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
        listColumnDefs.add(new ColumnDef("특별공제_차입금원리금상환액_대출기관", Ye16Ta2000BM.ATTR_SPCIREFN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
        listColumnDefs.add(new ColumnDef("특별공제_차입금원리금상환액_거주자", Ye16Ta2000BM.ATTR_SPCIRESF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주택자금_월세금액 : spciHtam */
        listColumnDefs.add(new ColumnDef("특별공제_주택자금_월세금액", Ye16Ta2000BM.ATTR_SPCIHTAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장기주택이자상환액 : spchRefn */
        listColumnDefs.add(new ColumnDef("특별공제_장기주택이자상환액", Ye16Ta2000BM.ATTR_SPCHREFN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금15 : spchRe06 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금15", Ye16Ta2000BM.ATTR_SPCHRE06, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금29 : spchRe10 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금29", Ye16Ta2000BM.ATTR_SPCHRE10, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금30 : spchRe20 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금30", Ye16Ta2000BM.ATTR_SPCHRE20, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_12장기주택저당차입금_고정 : spchRefx */
        listColumnDefs.add(new ColumnDef("특별공제_12장기주택저당차입금_고정", Ye16Ta2000BM.ATTR_SPCHREFX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_12장기주택저당차입금_기타 : spchReec */
        listColumnDefs.add(new ColumnDef("특별공제_12장기주택저당차입금_기타", Ye16Ta2000BM.ATTR_SPCHREEC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15고정AND비거치상환", Ye16Ta2000BM.ATTR_SPCH15FX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15고정OR비거치상환", Ye16Ta2000BM.ATTR_SPCH15FB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15기타대출 : spch15ec */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15기타대출", Ye16Ta2000BM.ATTR_SPCH15EC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_10고정OR비거치상환", Ye16Ta2000BM.ATTR_SPCH10FB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_10기타대출 : spch10ec */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_10기타대출", Ye16Ta2000BM.ATTR_SPCH10EC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_기부정치자금금액 : taxdPltc */
        listColumnDefs.add(new ColumnDef("세액공제_기부정치자금금액", Ye16Ta2000BM.ATTR_TAXDPLTC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
        listColumnDefs.add(new ColumnDef("특별공제_기부정치자금_10이하대상금액", Ye16Ta2000BM.ATTR_TAXD10TG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_정치 : spciPltc */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_정치", Ye16Ta2000BM.ATTR_SPCIPLTC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_정치10초과대상금액 : spciPltg */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_정치10초과대상금액", Ye16Ta2000BM.ATTR_SPCIPLTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_법정 : spciFbam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_법정", Ye16Ta2000BM.ATTR_SPCIFBAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_법정대상금액 : spciFbtg */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_법정대상금액", Ye16Ta2000BM.ATTR_SPCIFBTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_특례_공익법인신탁제외", Ye16Ta2000BM.ATTR_SPCIEXAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_공익법인신탁특례", Ye16Ta2000BM.ATTR_SPCIUNON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_우리사주조합2015이후 : spciHfam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_우리사주조합2015이후", Ye16Ta2000BM.ATTR_SPCIHFAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_종교단체 : spciYamt */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_종교단체", Ye16Ta2000BM.ATTR_SPCIYAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_종교단체외 : spciNamt */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_종교단체외", Ye16Ta2000BM.ATTR_SPCINAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_지정기부금대상금액 : spciDgtg */
        listColumnDefs.add(new ColumnDef("특별공제_지정기부금대상금액", Ye16Ta2000BM.ATTR_SPCIDGTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
        listColumnDefs.add(new ColumnDef("특별공제_혼인_이사_장례비_삭제", Ye16Ta2000BM.ATTR_SPCIFNRL, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축불입액_2000년이전 : prvm20be */
        listColumnDefs.add(new ColumnDef("개인연금저축불입액_2000년이전", Ye16Ta2000BM.ATTR_PRVM20BE, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축불입액_2001년이후_삭제 : prvm21af */
        listColumnDefs.add(new ColumnDef("개인연금저축불입액_2001년이후_삭제", Ye16Ta2000BM.ATTR_PRVM21AF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_소기업공제불입금액 : etchPrep */
        listColumnDefs.add(new ColumnDef("기타공제_소기업공제불입금액", Ye16Ta2000BM.ATTR_ETCHPREP, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_청약저축 : etcsComp */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_청약저축", Ye16Ta2000BM.ATTR_ETCSCOMP, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_근로자주택마련저축", Ye16Ta2000BM.ATTR_ETWKHSVM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_주택청약종합저축", Ye16Ta2000BM.ATTR_ETWKHSBM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_장기주택마련저축_del", Ye16Ta2000BM.ATTR_ETWKHLGM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축소득금액 : etwkHbdm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축소득금액", Ye16Ta2000BM.ATTR_ETWKHBDM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2011이전 : etctConc */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2011이전", Ye16Ta2000BM.ATTR_ETCTCONC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2012년도 : etgdH09f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2012년도", Ye16Ta2000BM.ATTR_ETGDH09F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2013년도 : etgdH13f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2013년도", Ye16Ta2000BM.ATTR_ETGDH13F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2014년도 : etgdH14f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2014년도", Ye16Ta2000BM.ATTR_ETGDH14F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2015년이후 : etclH15f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2015년이후", Ye16Ta2000BM.ATTR_ETCLH15F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제투자조합출자금액계 : etgdHdam */
        listColumnDefs.add(new ColumnDef("기타공제투자조합출자금액계", Ye16Ta2000BM.ATTR_ETGDHDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_신용카드등사용금액 : etctCard */
        listColumnDefs.add(new ColumnDef("기타공제_신용카드등사용금액", Ye16Ta2000BM.ATTR_ETCTCARD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_직불카드등사용금액 : etchBcbs */
        listColumnDefs.add(new ColumnDef("기타공제_직불카드등사용금액", Ye16Ta2000BM.ATTR_ETCHBCBS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_현금영수증사용금액 : etchUeam */
        listColumnDefs.add(new ColumnDef("기타공제_현금영수증사용금액", Ye16Ta2000BM.ATTR_ETCHUEAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_전통시장사용분 : etchMgvd */
        listColumnDefs.add(new ColumnDef("기타공제_전통시장사용분", Ye16Ta2000BM.ATTR_ETCHMGVD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_지로납부_대중교통금액 : etchBced */
        listColumnDefs.add(new ColumnDef("기타공제_지로납부_대중교통금액", Ye16Ta2000BM.ATTR_ETCHBCED, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인신용카드등사용액_2013 : cardEt13 */
        listColumnDefs.add(new ColumnDef("기타공제_본인신용카드등사용액_2013", Ye16Ta2000BM.ATTR_CARDET13, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인신용카드등사용액_2014 : cardEt14 */
        listColumnDefs.add(new ColumnDef("기타공제_본인신용카드등사용액_2014", Ye16Ta2000BM.ATTR_CARDET14, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공재율사용액_2013 : etadDd13 */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공재율사용액_2013", Ye16Ta2000BM.ATTR_ETADDD13, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공제율사용액_2014하 : etadD14l */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공제율사용액_2014하", Ye16Ta2000BM.ATTR_ETADD14L, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_신용카드등사용공제계 : etchBcue */
        listColumnDefs.add(new ColumnDef("기타공제_신용카드등사용공제계", Ye16Ta2000BM.ATTR_ETCHBCUE, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_우리사주출연금액 : etckUnon */
        listColumnDefs.add(new ColumnDef("기타공제_우리사주출연금액", Ye16Ta2000BM.ATTR_ETCKUNON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_우리사주조합기부금2014이전 : etckUncb */
        listColumnDefs.add(new ColumnDef("기타공제_우리사주조합기부금2014이전", Ye16Ta2000BM.ATTR_ETCKUNCB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
        listColumnDefs.add(new ColumnDef("기타공제_고용유지중소기업근로자임금삭감액", Ye16Ta2000BM.ATTR_ETEPHSAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
        listColumnDefs.add(new ColumnDef("기타공제_목돈안드는전세이자상환금액", Ye16Ta2000BM.ATTR_ETGDCTRA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기집합투자증권저축금액 : etepSest */
        listColumnDefs.add(new ColumnDef("기타공제_장기집합투자증권저축금액", Ye16Ta2000BM.ATTR_ETEPSEST, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_1년차_삭제", Ye16Ta2000BM.ATTR_ETCLHM01, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_2년차_삭제", Ye16Ta2000BM.ATTR_ETCLHM02, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_3년차_삭제", Ye16Ta2000BM.ATTR_ETCLHM03, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_납입합계금액_삭제", Ye16Ta2000BM.ATTR_ETCLHMTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_기타제목 : etclEttl */
        listColumnDefs.add(new ColumnDef("기타공제_기타제목", Ye16Ta2000BM.ATTR_ETCLETTL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_기타금액 : etclEtam */
        listColumnDefs.add(new ColumnDef("기타공제_기타금액", Ye16Ta2000BM.ATTR_ETCLETAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_입국목적코드 : taxdIncd */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_입국목적코드", Ye16Ta2000BM.ATTR_TAXDINCD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_근로제공일자 : taxdWkdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_근로제공일자", Ye16Ta2000BM.ATTR_TAXDWKDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_감면기간만료일자 : tamaEddt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_감면기간만료일자", Ye16Ta2000BM.ATTR_TAMAEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_감면신청접수일자 : tamaIndt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_감면신청접수일자", Ye16Ta2000BM.ATTR_TAMAINDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_감면신청제출일자 : tamaOudt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_감면신청제출일자", Ye16Ta2000BM.ATTR_TAMAOUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
        listColumnDefs.add(new ColumnDef("세액공제_외국인해저광물개발감면확인일자", Ye16Ta2000BM.ATTR_TXLGFRRD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
        listColumnDefs.add(new ColumnDef("세액공제_외국인해저광물개발감면신청일자", Ye16Ta2000BM.ATTR_TXLGFRID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
        listColumnDefs.add(new ColumnDef("세액공제_근로소득조세조약상면제접수일자", Ye16Ta2000BM.ATTR_TXLGWKID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
        listColumnDefs.add(new ColumnDef("세액공제_근로소득조세조약상면제제출일자", Ye16Ta2000BM.ATTR_TXLGTXTD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_중소기업청년감면취업일자 : txlgBscd */
        listColumnDefs.add(new ColumnDef("세액공제_중소기업청년감면취업일자", Ye16Ta2000BM.ATTR_TXLGBSCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_중소기업청년감면종료일자 : txlgBcde */
        listColumnDefs.add(new ColumnDef("세액공제_중소기업청년감면종료일자", Ye16Ta2000BM.ATTR_TXLGBCDE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_소득세법감면세액 : txlgItct */
        listColumnDefs.add(new ColumnDef("세액감면_소득세법감면세액", Ye16Ta2000BM.ATTR_TXLGITCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_취업청년감면대상총급여액 : txlgBsta */
        listColumnDefs.add(new ColumnDef("세액감면_취업청년감면대상총급여액", Ye16Ta2000BM.ATTR_TXLGBSTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_취업청년감면근로자총급여액 : txlgWkta */
        listColumnDefs.add(new ColumnDef("세액감면_취업청년감면근로자총급여액", Ye16Ta2000BM.ATTR_TXLGWKTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_계산감면세액금액 : txlgClta */
        listColumnDefs.add(new ColumnDef("세액감면_계산감면세액금액", Ye16Ta2000BM.ATTR_TXLGCLTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_외국인기술자감면세액 : txlgFrta */
        listColumnDefs.add(new ColumnDef("세액감면_외국인기술자감면세액", Ye16Ta2000BM.ATTR_TXLGFRTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_조세조약감면세액 : txlgTxty */
        listColumnDefs.add(new ColumnDef("세액감면_조세조약감면세액", Ye16Ta2000BM.ATTR_TXLGTXTY, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_국외원천소득금액 : txlgInam */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_국외원천소득금액", Ye16Ta2000BM.ATTR_TXLGINAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_외화납세액 : txlgDlam */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_외화납세액", Ye16Ta2000BM.ATTR_TXLGDLAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_원화납세액 : txlgWnam */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_원화납세액", Ye16Ta2000BM.ATTR_TXLGWNAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_납세국명 : txlgOtcy */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_납세국명", Ye16Ta2000BM.ATTR_TXLGOTCY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_납부일자 : txlgOtdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_납부일자", Ye16Ta2000BM.ATTR_TXLGOTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_신청서제출일자 : txlgApdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_신청서제출일자", Ye16Ta2000BM.ATTR_TXLGAPDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_국외근무처명 : txlgOuwk */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_국외근무처명", Ye16Ta2000BM.ATTR_TXLGOUWK, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_근무시작일자 : txapStdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_근무시작일자", Ye16Ta2000BM.ATTR_TXAPSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_근무종료일자 : txapEddt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_근무종료일자", Ye16Ta2000BM.ATTR_TXAPEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_직책 : txapWkdy */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_직책", Ye16Ta2000BM.ATTR_TXAPWKDY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_납세조합공제 : taxdUnin */
        listColumnDefs.add(new ColumnDef("세액공제_납세조합공제", Ye16Ta2000BM.ATTR_TAXDUNIN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_주택차입금이자상황금액 : taxdLoaa */
        listColumnDefs.add(new ColumnDef("세액공제_주택차입금이자상황금액", Ye16Ta2000BM.ATTR_TAXDLOAA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_연금저축등소득공제제출여부 : addcNtyn */
        listColumnDefs.add(new ColumnDef("추가서류_연금저축등소득공제제출여부", Ye16Ta2000BM.ATTR_ADDCNTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_의료비지급명세서제출여부 : addcMdyn */
        listColumnDefs.add(new ColumnDef("추가서류_의료비지급명세서제출여부", Ye16Ta2000BM.ATTR_ADDCMDYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_기부금명세서제출여부 : addcCtyn */
        listColumnDefs.add(new ColumnDef("추가서류_기부금명세서제출여부", Ye16Ta2000BM.ATTR_ADDCCTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_소득공제증빙서류제출여부 : addcPfyn */
        listColumnDefs.add(new ColumnDef("추가서류_소득공제증빙서류제출여부", Ye16Ta2000BM.ATTR_ADDCPFYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
        listColumnDefs.add(new ColumnDef("추가서류_종전근무지근로소득원천징수제출여부", Ye16Ta2000BM.ATTR_ADDFPVYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
        listColumnDefs.add(new ColumnDef("추가서류_월세액_거주자_주택차입금세액공제제출여부", Ye16Ta2000BM.ATTR_SPCIREYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
        listColumnDefs.add(new ColumnDef("추가서류_월세_비거주간상환액제출여부", Ye16Ta2000BM.ATTR_TXLGMXTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고제출일자 : incoOudt */
        listColumnDefs.add(new ColumnDef("소득신고제출일자", Ye16Ta2000BM.ATTR_INCOOUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득신고제출여부 : incoOufg */
        listColumnDefs.add(new ColumnDef("소득신고제출여부", Ye16Ta2000BM.ATTR_INCOOUFG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 파일생성여부 : jdocFile */
        listColumnDefs.add(new ColumnDef("제출구분", Ye16Ta2000BM.ATTR_JDOCFILE, ColumnDef.TYPE_STRING , 90, true,true, true){
        	{

        	}
        });
        /** column 연금계좌계 : jrtrAtom */
        listColumnDefs.add(new ColumnDef("연금계좌계", Ye16Ta2000BM.ATTR_JRTRATOM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌공제대상금액 : jrtrTotr */
        listColumnDefs.add(new ColumnDef("연금계좌공제대상금액", Ye16Ta2000BM.ATTR_JRTRTOTR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인보장성대상금액 : spciHdtg */
        listColumnDefs.add(new ColumnDef("특별공제_장애인보장성대상금액", Ye16Ta2000BM.ATTR_SPCIHDTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보장성보험료대상금액 : spciDetg */
        listColumnDefs.add(new ColumnDef("특별공제_보장성보험료대상금액", Ye16Ta2000BM.ATTR_SPCIDETG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보장성보험료계 : spciRtto */
        listColumnDefs.add(new ColumnDef("특별공제_보장성보험료계", Ye16Ta2000BM.ATTR_SPCIRTTO, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 본인의료비공제대상금액 : spciSftg */
        listColumnDefs.add(new ColumnDef("본인의료비공제대상금액", Ye16Ta2000BM.ATTR_SPCISFTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 65세이상자의료비공제대상금액 : spci65tg */
        listColumnDefs.add(new ColumnDef("65세이상자의료비공제대상금액", Ye16Ta2000BM.ATTR_SPCI65TG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인의료비공제대상금액 : spciPstg */
        listColumnDefs.add(new ColumnDef("장애인의료비공제대상금액", Ye16Ta2000BM.ATTR_SPCIPSTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 그밖의의료비공제대상금액 : spciEtcg */
        listColumnDefs.add(new ColumnDef("그밖의의료비공제대상금액", Ye16Ta2000BM.ATTR_SPCIETCG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 소득자본인교육비대상금액 : spedSftr */
        listColumnDefs.add(new ColumnDef("소득자본인교육비대상금액", Ye16Ta2000BM.ATTR_SPEDSFTR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 취학전아동교육비대상금액 : spedEdtr */
        listColumnDefs.add(new ColumnDef("취학전아동교육비대상금액", Ye16Ta2000BM.ATTR_SPEDEDTR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 초중고교육비대상금액 : spedGdtr */
        listColumnDefs.add(new ColumnDef("초중고교육비대상금액", Ye16Ta2000BM.ATTR_SPEDGDTR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 대학생교육비대상금액 : spedCvtr */
        listColumnDefs.add(new ColumnDef("대학생교육비대상금액", Ye16Ta2000BM.ATTR_SPEDCVTR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특수교육비공제대상금액 : spciSctr */
        listColumnDefs.add(new ColumnDef("특수교육비공제대상금액", Ye16Ta2000BM.ATTR_SPCISCTR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특례기부금_공익법인제외대상금액 : spciExtg */
        listColumnDefs.add(new ColumnDef("특례기부금_공익법인제외대상금액", Ye16Ta2000BM.ATTR_SPCIEXTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 공익법인신탁대상금액 : spciUntg */
        listColumnDefs.add(new ColumnDef("공익법인신탁대상금액", Ye16Ta2000BM.ATTR_SPCIUNTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 우리사주종합기부대상금액 : spciHftg */
        listColumnDefs.add(new ColumnDef("우리사주종합기부대상금액", Ye16Ta2000BM.ATTR_SPCIHFTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종교단체외지정대상금액 : spciNatg */
        listColumnDefs.add(new ColumnDef("종교단체외지정대상금액", Ye16Ta2000BM.ATTR_SPCINATG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종교단체지정대상금액 : spciYatg */
        listColumnDefs.add(new ColumnDef("종교단체지정대상금액", Ye16Ta2000BM.ATTR_SPCIYATG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금합계금액 : spciDgam */
        listColumnDefs.add(new ColumnDef("기부금합계금액", Ye16Ta2000BM.ATTR_SPCIDGAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월특례기부금_공익신탁금액 : spciOnon */
        listColumnDefs.add(new ColumnDef("이월특례기부금_공익신탁금액", Ye16Ta2000BM.ATTR_SPCIONON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월법정기부금액 : spciObam */
        listColumnDefs.add(new ColumnDef("이월법정기부금액", Ye16Ta2000BM.ATTR_SPCIOBAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월종교단체기부금 : spciOyam */
        listColumnDefs.add(new ColumnDef("이월종교단체기부금", Ye16Ta2000BM.ATTR_SPCIOYAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 이월종교단체외기부금 : spciOnam */
        listColumnDefs.add(new ColumnDef("이월종교단체외기부금", Ye16Ta2000BM.ATTR_SPCIONAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta2000BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta2000BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta2000BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta2000BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta2000BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta2000BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 기타공제_본인신용카등사용액_2015 : cardEt15 */
        listColumnDefs.add(new ColumnDef("기타공제_본인신용카등사용액_2015", Ye16Ta2000BM.ATTR_CARDET15, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공제율사용액2015상반기", Ye16Ta2000BM.ATTR_ETADD15H, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공제율사용액2015하반기 : etadD15l */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공제율사용액2015하반기", Ye16Ta2000BM.ATTR_ETADD15L, ColumnDef.TYPE_LONG , 90, true, false, true){
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
//        private TextField<String> edacSeilNum;   /** column 연말정산마감일련번호 : edacSeilNum */
//
//        private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> hanNm;   /** column 한글성명 : hanNm */
//
//        private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//        private TextField<String> odtyCd;   /** column 직책코드 : odtyCd */
//
//        private TextField<String> pyspCd;   /** column 호봉코드 : pyspCd */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> logSvcYrNumCd;   /** column 근속년수코드 : logSvcYrNumCd */
//
//        private TextField<String> logSvcMnthIcmCd;   /** column 근속월수코드 : logSvcMnthIcmCd */
//
//        private TextField<String> frstEmymtDt;   /** column 최초고용일자 : frstEmymtDt */
//
//        private TextField<String> emymtBgnnDt;   /** column 고용시작일자 : emymtBgnnDt */
//
//        private TextField<String> emymtEndDt;   /** column 고용종료일자 : emymtEndDt */
//
//        private TextField<String> hdofcDivCd;   /** column 재직구분코드 : hdofcDivCd */
//
//        private TextField<String> retryDt;   /** column 퇴직일자 : retryDt */
//
//        private TextField<String> yrtxApptnYrMnth;   /** column 연말정산적용년월 : yrtxApptnYrMnth */
//
//        private TextField<String> yrtxPrcsDt;   /** column 연말정산처리일자 : yrtxPrcsDt */
//
//        private TextField<String> yrtxPrcsYn;   /** column 연말정산처리여부 : yrtxPrcsYn */
//
//        private TextField<String> divdPymtDivCd;   /** column 분할납부구분코드 : divdPymtDivCd */
//
//        private TextField<String> divdPymt;   /** column 분할납부횟수 : divdPymt */
//
//        private TextField<String> gnanSgtf;   /** column 세대주여부 : gnanSgtf */
//
//        private TextField<String> frnrYeno;   /** column 외국인구분코드 : frnrYeno */
//
//        private TextField<String> reymStdt;   /** column 귀속년월_FROM : reymStdt */
//
//        private TextField<String> reymEddt;   /** column 귀속년월_TO : reymEddt */
//
//        private TextField<String> rutrEddt;   /** column 감면기간_TO : rutrEddt */
//
//        private TextField<String> rutrStdt;   /** column 감면기간_FROM : rutrStdt */
//
//        private TextField<String> resdFlag;   /** column 거주구분여부 : resdFlag */
//
//        private TextField<String> natnGbcd;   /** column 국적코드 : natnGbcd */
//
//        private TextField<String> natnName;   /** column 국적명 : natnName */
//
//        private TextField<String> redtGbcd;   /** column 거주지국코드 : redtGbcd */
//
//        private TextField<String> redtName;   /** column 거주지국명 : redtName */
//
//        private TextField<String> humnCgue;   /** column 인적공제항목변동여부 : humnCgue */
//
//        private TextField<String> frnrSgyn;   /** column 외국인단일세율적용여부 : frnrSgyn */
//
//        private TextField<String> baseWiyn;   /** column 기본공제_배우자유무 : baseWiyn */
//
//        private TextField<String> baseFmly;   /** column 기본공제_부양가족수 : baseFmly */
//
//        private TextField<String> addrCt70;   /** column 추가공제_경로우대_70세이상수 : addrCt70 */
//
//        private TextField<String> addrHdrc;   /** column 추가공제_장애인수 : addrHdrc */
//
//        private TextField<String> addrFdsu;   /** column 추가공제_부녀자수 : addrFdsu */
//
//        private TextField<String> addrClct;   /** column 추가공제_자녀양육비양육수 : addrClct */
//
//        private TextField<String> addrBhct;   /** column 추가공제_출산자녀양육수 : addrBhct */
//
//        private TextField<String> pantOnsu;   /** column 추가공제_한부모수 : pantOnsu */
//
//        private TextField<String> addrMrct;   /** column 추가공제_다자녀인원수 : addrMrct */
//
//        private TextField<String> bnatPsnf;   /** column 종근무지_국민연금보험료 : bnatPsnf */
//
//        private TextField<String> jnatPsnf;   /** column 주근무지_국민연금보험료 : jnatPsnf */
//
//        private TextField<String> bpssTech;   /** column 종근무지_국민연금외교직원연금 : bpssTech */
//
//        private TextField<String> bpssPulc;   /** column 종근무지_국민연금외공무원연금 : bpssPulc */
//
//        private TextField<String> bpssFect;   /** column 종근무지_국민연금외별정우체국 : bpssFect */
//
//        private TextField<String> bpssSold;   /** column 종근무지_국민연금외군인연금 : bpssSold */
//
//        private TextField<String> jpssPulc;   /** column 주근무지_국민연금외공무원연금 : jpssPulc */
//
//        private TextField<String> jpssSold;   /** column 주근무지_국민연금외군인연금 : jpssSold */
//
//        private TextField<String> jpssTech;   /** column 주근무지_국인연금외교직원연금 : jpssTech */
//
//        private TextField<String> jpssFect;   /** column 주근무지_국민연금외별정우체국 : jpssFect */
//
//        private TextField<String> brtrPsct;   /** column 종근무지_종_근로자퇴직보장법 : brtrPsct */
//
//        private TextField<String> brtrCict;   /** column 종근무지_종_과학기술인공제 : brtrCict */
//
//        private TextField<String> brtrAnsv;   /** column 종근무지_연금계좌_연금저축 : brtrAnsv */
//
//        private TextField<String> jrtrCict;   /** column 주근무지_퇴직연금과학기술인공제 : jrtrCict */
//
//        private TextField<String> jrtrCtar;   /** column 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
//
//        private TextField<String> jrtrPsct;   /** column 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
//
//        private TextField<String> jrtrPtar;   /** column 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
//
//        private TextField<String> jrtrAnsv;   /** column 주근무지_연금계좌_연금저축 : jrtrAnsv */
//
//        private TextField<String> jrtrAtar;   /** column 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
//
//        private TextField<String> rrptAmnt;   /** column 연금보험료계 : rrptAmnt */
//
//        private TextField<String> spciBhlh;   /** column 특별공제_종건강보험료 : spciBhlh */
//
//        private TextField<String> spciHhlh;   /** column 특별공제_주건강보험료 : spciHhlh */
//
//        private TextField<String> spciBepf;   /** column 특별공제_종고용보험료 : spciBepf */
//
//        private TextField<String> spciJepf;   /** column 특별공제_주고용보험료 : spciJepf */
//
//        private TextField<String> spciGurt;   /** column 특별공제_일반보장성보험료 : spciGurt */
//
//        private TextField<String> spciHdrc;   /** column 특별공제_장애인전용보험료 : spciHdrc */
//
//        private TextField<String> spciRttg;   /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
//
//        private TextField<String> spciIuam;   /** column 특별공제_보험료계 : spciIuam */
//
//        private TextField<String> spciSelf;   /** column 특별공제_의료비_본인 : spciSelf */
//
//        private TextField<String> spciAe65;   /** column 특별공제_의료비_경로65세이상 : spciAe65 */
//
//        private TextField<String> spciDbps;   /** column 특별공제_의료비_장애인 : spciDbps */
//
//        private TextField<String> spciDetc;   /** column 특별공제_의료비_기타공제대상자 : spciDetc */
//
//        private TextField<String> spciDtar;   /** column 특별공제_의료비세액공제대상금액 : spciDtar */
//
//        private TextField<String> spciEtam;   /** column 특별공제_의료비계 : spciEtam */
//
//        private TextField<String> spedSelf;   /** column 특별공제_교육비_본인 : spedSelf */
//
//        private TextField<String> spedEdsu;   /** column 특별공제_교육비_취학전아동수 : spedEdsu */
//
//        private TextField<String> spedEdam;   /** column 특별공제_교육비_취학전아동 : spedEdam */
//
//        private TextField<String> spedGdsu;   /** column 특별공제_교육비_초중고자녀수 : spedGdsu */
//
//        private TextField<String> spedGdam;   /** column 특별공제_교육비_초중고 : spedGdam */
//
//        private TextField<String> spedCvsu;   /** column 특별공제_교육비_대학생수 : spedCvsu */
//
//        private TextField<String> spedCvam;   /** column 특별공제_교육비_대학교 : spedCvam */
//
//        private TextField<String> spciScsu;   /** column 특별공제_장애인수 : spciScsu */
//
//        private TextField<String> spciScam;   /** column 특별공제_장애인특수교육비 : spciScam */
//
//        private TextField<String> spedEtar;   /** column 특별공제_교육비공제대상금액 : spedEtar */
//
//        private TextField<String> siedToam;   /** column 특별공제_교육비계 : siedToam */
//
//        private TextField<String> spciRefn;   /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
//
//        private TextField<String> spciResf;   /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
//
//        private TextField<String> spciHtam;   /** column 특별공제_주택자금_월세금액 : spciHtam */
//
//        private TextField<String> spchRefn;   /** column 특별공제_장기주택이자상환액 : spchRefn */
//
//        private TextField<String> spchRe06;   /** column 특별공제_11장기주택저당차입금15 : spchRe06 */
//
//        private TextField<String> spchRe10;   /** column 특별공제_11장기주택저당차입금29 : spchRe10 */
//
//        private TextField<String> spchRe20;   /** column 특별공제_11장기주택저당차입금30 : spchRe20 */
//
//        private TextField<String> spchRefx;   /** column 특별공제_12장기주택저당차입금_고정 : spchRefx */
//
//        private TextField<String> spchReec;   /** column 특별공제_12장기주택저당차입금_기타 : spchReec */
//
//        private TextField<String> spch15fx;   /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
//
//        private TextField<String> spch15fb;   /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
//
//        private TextField<String> spch15ec;   /** column 특별공제_15장기주택저당_15기타대출 : spch15ec */
//
//        private TextField<String> spch10fb;   /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
//
//        private TextField<String> spch10ec;   /** column 특별공제_15장기주택저당_10기타대출 : spch10ec */
//
//        private TextField<String> taxdPltc;   /** column 세액공제_기부정치자금금액 : taxdPltc */
//
//        private TextField<String> taxd10tg;   /** column 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
//
//        private TextField<String> spciPltc;   /** column 특별공제_기부금_정치 : spciPltc */
//
//        private TextField<String> spciPltg;   /** column 특별공제_기부금_정치10초과대상금액 : spciPltg */
//
//        private TextField<String> spciFbam;   /** column 특별공제_기부금_법정 : spciFbam */
//
//        private TextField<String> spciFbtg;   /** column 특별공제_기부금_법정대상금액 : spciFbtg */
//
//        private TextField<String> spciExam;   /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
//
//        private TextField<String> spciUnon;   /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
//
//        private TextField<String> spciHfam;   /** column 특별공제_기부금_우리사주조합2015이후 : spciHfam */
//
//        private TextField<String> spciYamt;   /** column 특별공제_기부금_종교단체 : spciYamt */
//
//        private TextField<String> spciNamt;   /** column 특별공제_기부금_종교단체외 : spciNamt */
//
//        private TextField<String> spciDgtg;   /** column 특별공제_지정기부금대상금액 : spciDgtg */
//
//        private TextField<String> spciFnrl;   /** column 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
//
//        private TextField<String> prvm20be;   /** column 개인연금저축불입액_2000년이전 : prvm20be */
//
//        private TextField<String> prvm21af;   /** column 개인연금저축불입액_2001년이후_삭제 : prvm21af */
//
//        private TextField<String> etchPrep;   /** column 기타공제_소기업공제불입금액 : etchPrep */
//
//        private TextField<String> etcsComp;   /** column 기타공제_주택마련저축_청약저축 : etcsComp */
//
//        private TextField<String> etwkHsvm;   /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
//
//        private TextField<String> etwkHsbm;   /** column 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
//
//        private TextField<String> etwkHlgm;   /** column 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
//
//        private TextField<String> etwkHbdm;   /** column 기타공제_주택마련저축소득금액 : etwkHbdm */
//
//        private TextField<String> etctConc;   /** column 기타공제_투자조합출자금액_2011이전 : etctConc */
//
//        private TextField<String> etgdH09f;   /** column 기타공제_투자조합출자금액_2012년도 : etgdH09f */
//
//        private TextField<String> etgdH13f;   /** column 기타공제_투자조합출자금액_2013년도 : etgdH13f */
//
//        private TextField<String> etgdH14f;   /** column 기타공제_투자조합출자금액_2014년도 : etgdH14f */
//
//        private TextField<String> etclH15f;   /** column 기타공제_투자조합출자금액_2015년이후 : etclH15f */
//
//        private TextField<String> etgdHdam;   /** column 기타공제투자조합출자금액계 : etgdHdam */
//
//        private TextField<String> etctCard;   /** column 기타공제_신용카드등사용금액 : etctCard */
//
//        private TextField<String> etchBcbs;   /** column 기타공제_직불카드등사용금액 : etchBcbs */
//
//        private TextField<String> etchUeam;   /** column 기타공제_현금영수증사용금액 : etchUeam */
//
//        private TextField<String> etchMgvd;   /** column 기타공제_전통시장사용분 : etchMgvd */
//
//        private TextField<String> etchBced;   /** column 기타공제_지로납부_대중교통금액 : etchBced */
//
//        private TextField<String> cardEt13;   /** column 기타공제_본인신용카드등사용액_2013 : cardEt13 */
//
//        private TextField<String> cardEt14;   /** column 기타공제_본인신용카드등사용액_2014 : cardEt14 */
//
//        private TextField<String> etadDd13;   /** column 기타공제_본인추가공재율사용액_2013 : etadDd13 */
//
//        private TextField<String> etadD14l;   /** column 기타공제_본인추가공제율사용액_2014하 : etadD14l */
//
//        private TextField<String> etchBcue;   /** column 기타공제_신용카드등사용공제계 : etchBcue */
//
//        private TextField<String> etckUnon;   /** column 기타공제_우리사주출연금액 : etckUnon */
//
//        private TextField<String> etckUncb;   /** column 기타공제_우리사주조합기부금2014이전 : etckUncb */
//
//        private TextField<String> etepHsam;   /** column 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
//
//        private TextField<String> etgdCtra;   /** column 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
//
//        private TextField<String> etepSest;   /** column 기타공제_장기집합투자증권저축금액 : etepSest */
//
//        private TextField<String> etclHm01;   /** column 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
//
//        private TextField<String> etclHm02;   /** column 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
//
//        private TextField<String> etclHm03;   /** column 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
//
//        private TextField<String> etclHmta;   /** column 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
//
//        private TextField<String> etclEttl;   /** column 기타공제_기타제목 : etclEttl */
//
//        private TextField<String> etclEtam;   /** column 기타공제_기타금액 : etclEtam */
//
//        private TextField<String> taxdIncd;   /** column 세액공제_외국인_입국목적코드 : taxdIncd */
//
//        private TextField<String> taxdWkdt;   /** column 세액공제_외국인_근로제공일자 : taxdWkdt */
//
//        private TextField<String> tamaEddt;   /** column 세액공제_외국인_감면기간만료일자 : tamaEddt */
//
//        private TextField<String> tamaIndt;   /** column 세액공제_외국인_감면신청접수일자 : tamaIndt */
//
//        private TextField<String> tamaOudt;   /** column 세액공제_외국인_감면신청제출일자 : tamaOudt */
//
//        private TextField<String> txlgFrrd;   /** column 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
//
//        private TextField<String> txlgFrid;   /** column 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
//
//        private TextField<String> txlgWkid;   /** column 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
//
//        private TextField<String> txlgTxtd;   /** column 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
//
//        private TextField<String> txlgBscd;   /** column 세액공제_중소기업청년감면취업일자 : txlgBscd */
//
//        private TextField<String> txlgBcde;   /** column 세액공제_중소기업청년감면종료일자 : txlgBcde */
//
//        private TextField<String> txlgItct;   /** column 세액감면_소득세법감면세액 : txlgItct */
//
//        private TextField<String> txlgBsta;   /** column 세액감면_취업청년감면대상총급여액 : txlgBsta */
//
//        private TextField<String> txlgWkta;   /** column 세액감면_취업청년감면근로자총급여액 : txlgWkta */
//
//        private TextField<String> txlgClta;   /** column 세액감면_계산감면세액금액 : txlgClta */
//
//        private TextField<String> txlgFrta;   /** column 세액감면_외국인기술자감면세액 : txlgFrta */
//
//        private TextField<String> txlgTxty;   /** column 세액감면_조세조약감면세액 : txlgTxty */
//
//        private TextField<String> txlgInam;   /** column 세액공제_외국납부_국외원천소득금액 : txlgInam */
//
//        private TextField<String> txlgDlam;   /** column 세액공제_외국납부_외화납세액 : txlgDlam */
//
//        private TextField<String> txlgWnam;   /** column 세액공제_외국납부_원화납세액 : txlgWnam */
//
//        private TextField<String> txlgOtcy;   /** column 세액공제_외국납부_납세국명 : txlgOtcy */
//
//        private TextField<String> txlgOtdt;   /** column 세액공제_외국납부_납부일자 : txlgOtdt */
//
//        private TextField<String> txlgApdt;   /** column 세액공제_외국납부_신청서제출일자 : txlgApdt */
//
//        private TextField<String> txlgOuwk;   /** column 세액공제_외국납부_국외근무처명 : txlgOuwk */
//
//        private TextField<String> txapStdt;   /** column 세액공제_외국납부_근무시작일자 : txapStdt */
//
//        private TextField<String> txapEddt;   /** column 세액공제_외국납부_근무종료일자 : txapEddt */
//
//        private TextField<String> txapWkdy;   /** column 세액공제_외국납부_직책 : txapWkdy */
//
//        private TextField<String> taxdUnin;   /** column 세액공제_납세조합공제 : taxdUnin */
//
//        private TextField<String> taxdLoaa;   /** column 세액공제_주택차입금이자상황금액 : taxdLoaa */
//
//        private TextField<String> addcNtyn;   /** column 추가서류_연금저축등소득공제제출여부 : addcNtyn */
//
//        private TextField<String> addcMdyn;   /** column 추가서류_의료비지급명세서제출여부 : addcMdyn */
//
//        private TextField<String> addcCtyn;   /** column 추가서류_기부금명세서제출여부 : addcCtyn */
//
//        private TextField<String> addcPfyn;   /** column 추가서류_소득공제증빙서류제출여부 : addcPfyn */
//
//        private TextField<String> addfPvyn;   /** column 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
//
//        private TextField<String> spciReyn;   /** column 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
//
//        private TextField<String> txlgMxtm;   /** column 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
//
//        private TextField<String> incoOudt;   /** column 소득신고제출일자 : incoOudt */
//
//        private TextField<String> incoOufg;   /** column 소득신고제출여부 : incoOufg */
//
//        private TextField<String> jdocFile;   /** column 파일생성여부 : jdocFile */
//
//        private TextField<String> jrtrAtom;   /** column 연금계좌계 : jrtrAtom */
//
//        private TextField<String> jrtrTotr;   /** column 연금계좌공제대상금액 : jrtrTotr */
//
//        private TextField<String> spciHdtg;   /** column 특별공제_장애인보장성대상금액 : spciHdtg */
//
//        private TextField<String> spciDetg;   /** column 특별공제_보장성보험료대상금액 : spciDetg */
//
//        private TextField<String> spciRtto;   /** column 특별공제_보장성보험료계 : spciRtto */
//
//        private TextField<String> spciSftg;   /** column 본인의료비공제대상금액 : spciSftg */
//
//        private TextField<String> spci65tg;   /** column 65세이상자의료비공제대상금액 : spci65tg */
//
//        private TextField<String> spciPstg;   /** column 장애인의료비공제대상금액 : spciPstg */
//
//        private TextField<String> spciEtcg;   /** column 그밖의의료비공제대상금액 : spciEtcg */
//
//        private TextField<String> spedSftr;   /** column 소득자본인교육비대상금액 : spedSftr */
//
//        private TextField<String> spedEdtr;   /** column 취학전아동교육비대상금액 : spedEdtr */
//
//        private TextField<String> spedGdtr;   /** column 초중고교육비대상금액 : spedGdtr */
//
//        private TextField<String> spedCvtr;   /** column 대학생교육비대상금액 : spedCvtr */
//
//        private TextField<String> spciSctr;   /** column 특수교육비공제대상금액 : spciSctr */
//
//        private TextField<String> spciExtg;   /** column 특례기부금_공익법인제외대상금액 : spciExtg */
//
//        private TextField<String> spciUntg;   /** column 공익법인신탁대상금액 : spciUntg */
//
//        private TextField<String> spciHftg;   /** column 우리사주종합기부대상금액 : spciHftg */
//
//        private TextField<String> spciNatg;   /** column 종교단체외지정대상금액 : spciNatg */
//
//        private TextField<String> spciYatg;   /** column 종교단체지정대상금액 : spciYatg */
//
//        private TextField<String> spciDgam;   /** column 기부금합계금액 : spciDgam */
//
//        private TextField<String> spciOnon;   /** column 이월특례기부금_공익신탁금액 : spciOnon */
//
//        private TextField<String> spciObam;   /** column 이월법정기부금액 : spciObam */
//
//        private TextField<String> spciOyam;   /** column 이월종교단체기부금 : spciOyam */
//
//        private TextField<String> spciOnam;   /** column 이월종교단체외기부금 : spciOnam */
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
	
	
	
	
	private List<ColumnDef> getColumnsListYeta0300ToYeta2000() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 부서명 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Ye16Ta2000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Ye16Ta2000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta2000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 직종명 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Ye16Ta2000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 직종세명 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세", Ye16Ta2000BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 사업명 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Ye16Ta2000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta2000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 연말정산마감일련번호 : edacSeilNum */
        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta2000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta2000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
    
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Ye16Ta2000BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉코드 : pyspCd */
        listColumnDefs.add(new ColumnDef("호봉코드", Ye16Ta2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Ye16Ta2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수코드 : logSvcMnthIcmCd */
        listColumnDefs.add(new ColumnDef("근속월수코드", Ye16Ta2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Ye16Ta2000BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자", Ye16Ta2000BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("고용종료일자", Ye16Ta2000BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 재직구분코드 : hdofcDivCd */
        listColumnDefs.add(new ColumnDef("재직구분코드", Ye16Ta2000BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직일자 : retryDt */
        listColumnDefs.add(new ColumnDef("퇴직일자", Ye16Ta2000BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세대주여부 : gnanSgtf */
        listColumnDefs.add(new ColumnDef("세대주여부", Ye16Ta2000BM.ATTR_GNANSGTF, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인구분코드 : frnrYeno */
        listColumnDefs.add(new ColumnDef("외국인구분코드", Ye16Ta2000BM.ATTR_FRNRYENO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_FROM : reymStdt */
        listColumnDefs.add(new ColumnDef("귀속년월_FROM", Ye16Ta2000BM.ATTR_REYMSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년월_TO : reymEddt */
        listColumnDefs.add(new ColumnDef("귀속년월_TO", Ye16Ta2000BM.ATTR_REYMEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_TO : rutrEddt */
        listColumnDefs.add(new ColumnDef("감면기간_TO", Ye16Ta2000BM.ATTR_RUTREDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간_FROM : rutrStdt */
        listColumnDefs.add(new ColumnDef("감면기간_FROM", Ye16Ta2000BM.ATTR_RUTRSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주구분여부 : resdFlag */
        listColumnDefs.add(new ColumnDef("거주구분여부", Ye16Ta2000BM.ATTR_RESDFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국적코드 : natnGbcd */
        listColumnDefs.add(new ColumnDef("국적코드", Ye16Ta2000BM.ATTR_NATNGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국적명 : natnName */
        listColumnDefs.add(new ColumnDef("국적명", Ye16Ta2000BM.ATTR_NATNNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지국코드 : redtGbcd */
        listColumnDefs.add(new ColumnDef("거주지국코드", Ye16Ta2000BM.ATTR_REDTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지국명 : redtName */
        listColumnDefs.add(new ColumnDef("거주지국명", Ye16Ta2000BM.ATTR_REDTNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 인적공제항목변동여부 : humnCgue */
        listColumnDefs.add(new ColumnDef("인적공제항목변동여부", Ye16Ta2000BM.ATTR_HUMNCGUE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인단일세율적용여부 : frnrSgyn */
        listColumnDefs.add(new ColumnDef("외국인단일세율적용여부", Ye16Ta2000BM.ATTR_FRNRSGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제_배우자유무 : baseWiyn */
        listColumnDefs.add(new ColumnDef("기본공제_배우자유무", Ye16Ta2000BM.ATTR_BASEWIYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제_부양가족수 : baseFmly */
        listColumnDefs.add(new ColumnDef("기본공제_부양가족수", Ye16Ta2000BM.ATTR_BASEFMLY, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_경로우대_70세이상수 : addrCt70 */
        listColumnDefs.add(new ColumnDef("추가공제_경로우대_70세이상수", Ye16Ta2000BM.ATTR_ADDRCT70, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_장애인수 : addrHdrc */
        listColumnDefs.add(new ColumnDef("추가공제_장애인수", Ye16Ta2000BM.ATTR_ADDRHDRC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_부녀자수 : addrFdsu */
        listColumnDefs.add(new ColumnDef("추가공제_부녀자수", Ye16Ta2000BM.ATTR_ADDRFDSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_자녀양육비양육수 : addrClct */
        listColumnDefs.add(new ColumnDef("추가공제_자녀양육비양육수", Ye16Ta2000BM.ATTR_ADDRCLCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_출산자녀양육수 : addrBhct */
        listColumnDefs.add(new ColumnDef("추가공제_출산자녀양육수", Ye16Ta2000BM.ATTR_ADDRBHCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_한부모수 : pantOnsu */
        listColumnDefs.add(new ColumnDef("추가공제_한부모수", Ye16Ta2000BM.ATTR_PANTONSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제_다자녀인원수 : addrMrct */
        listColumnDefs.add(new ColumnDef("추가공제_다자녀인원수", Ye16Ta2000BM.ATTR_ADDRMRCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금보험료 : bnatPsnf */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금보험료", Ye16Ta2000BM.ATTR_BNATPSNF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금보험료 : jnatPsnf */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금보험료", Ye16Ta2000BM.ATTR_JNATPSNF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외별정우체국 : bpssFect */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외별정우체국", Ye16Ta2000BM.ATTR_BPSSFECT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_국민연금외군인연금 : bpssPulc */
        listColumnDefs.add(new ColumnDef("종근무지_국민연금외군인연금", Ye16Ta2000BM.ATTR_BPSSPULC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외공무원연금 : jpssPulc */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외공무원연금", Ye16Ta2000BM.ATTR_JPSSPULC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외군인연금 : jpssSold */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외군인연금", Ye16Ta2000BM.ATTR_JPSSSOLD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국인연금외교직원연금 : jpssTech */
        listColumnDefs.add(new ColumnDef("주근무지_국인연금외교직원연금", Ye16Ta2000BM.ATTR_JPSSTECH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_국민연금외별정우체국 : jpssFect */
        listColumnDefs.add(new ColumnDef("주근무지_국민연금외별정우체국", Ye16Ta2000BM.ATTR_JPSSFECT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_종_근로자퇴직보장법 : brtrPsct */
        listColumnDefs.add(new ColumnDef("종근무지_종_근로자퇴직보장법", Ye16Ta2000BM.ATTR_BRTRPSCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_종_과학기술인공제 : brtrCict */
        listColumnDefs.add(new ColumnDef("종근무지_종_과학기술인공제", Ye16Ta2000BM.ATTR_BRTRCICT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지_연금계좌_연금저축 : brtrAnsv */
        listColumnDefs.add(new ColumnDef("종근무지_연금계좌_연금저축", Ye16Ta2000BM.ATTR_BRTRANSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금과학기술인공제 : jrtrCict */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금과학기술인공제", Ye16Ta2000BM.ATTR_JRTRCICT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금과학기술인공제대상금액", Ye16Ta2000BM.ATTR_JRTRCTAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금근로자퇴직급여보장법", Ye16Ta2000BM.ATTR_JRTRPSCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
        listColumnDefs.add(new ColumnDef("주근무지_퇴직연금근로자퇴직급여보장대상금액", Ye16Ta2000BM.ATTR_JRTRPTAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_연금계좌_연금저축 : jrtrAnsv */
        listColumnDefs.add(new ColumnDef("주근무지_연금계좌_연금저축", Ye16Ta2000BM.ATTR_JRTRANSV, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
        listColumnDefs.add(new ColumnDef("주근무지_연금계좌저축공제대상금액", Ye16Ta2000BM.ATTR_JRTRATAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연금보험료계 : rrptAmnt */
        listColumnDefs.add(new ColumnDef("연금보험료계", Ye16Ta2000BM.ATTR_RRPTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_종건강보험료 : spciBhlh */
        listColumnDefs.add(new ColumnDef("특별공제_종건강보험료", Ye16Ta2000BM.ATTR_SPCIBHLH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주건강보험료 : spciHhlh */
        listColumnDefs.add(new ColumnDef("특별공제_주건강보험료", Ye16Ta2000BM.ATTR_SPCIHHLH, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_종고용보험료 : spciBepf */
        listColumnDefs.add(new ColumnDef("특별공제_종고용보험료", Ye16Ta2000BM.ATTR_SPCIBEPF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주고용보험료 : spciJepf */
        listColumnDefs.add(new ColumnDef("특별공제_주고용보험료", Ye16Ta2000BM.ATTR_SPCIJEPF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_일반보장성보험료 : spciGurt */
        listColumnDefs.add(new ColumnDef("특별공제_일반보장성보험료", Ye16Ta2000BM.ATTR_SPCIGURT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인전용보험료 : spciHdrc */
        listColumnDefs.add(new ColumnDef("특별공제_장애인전용보험료", Ye16Ta2000BM.ATTR_SPCIHDRC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
        listColumnDefs.add(new ColumnDef("특별공제_보장성보험료공제대상금액", Ye16Ta2000BM.ATTR_SPCIRTTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_보험료계 : spciIuam */
        listColumnDefs.add(new ColumnDef("특별공제_보험료계", Ye16Ta2000BM.ATTR_SPCIIUAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_본인 : spciSelf */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_본인", Ye16Ta2000BM.ATTR_SPCISELF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_경로65세이상 : spciAe65 */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_경로65세이상", Ye16Ta2000BM.ATTR_SPCIAE65, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_장애인 : spciDbps */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_장애인", Ye16Ta2000BM.ATTR_SPCIDBPS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비_기타공제대상자 : spciDetc */
        listColumnDefs.add(new ColumnDef("특별공제_의료비_기타공제대상자", Ye16Ta2000BM.ATTR_SPCIDETC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비세액공제대상금액 : spciDtar */
        listColumnDefs.add(new ColumnDef("특별공제_의료비세액공제대상금액", Ye16Ta2000BM.ATTR_SPCIDTAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_의료비계 : spciEtam */
        listColumnDefs.add(new ColumnDef("특별공제_의료비계", Ye16Ta2000BM.ATTR_SPCIETAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_본인 : spedSelf */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_본인", Ye16Ta2000BM.ATTR_SPEDSELF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_취학전아동수 : spedEdsu */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_취학전아동수", Ye16Ta2000BM.ATTR_SPEDEDSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_취학전아동 : spedEdam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_취학전아동", Ye16Ta2000BM.ATTR_SPEDEDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_초중고자녀수 : spedGdsu */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_초중고자녀수", Ye16Ta2000BM.ATTR_SPEDGDSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_초중고 : spedGdam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_초중고", Ye16Ta2000BM.ATTR_SPEDGDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_대학생수 : spedCvsu */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_대학생수", Ye16Ta2000BM.ATTR_SPEDCVSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비_대학교 : spedCvam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비_대학교", Ye16Ta2000BM.ATTR_SPEDCVAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인수 : spciScsu */
        listColumnDefs.add(new ColumnDef("특별공제_장애인수", Ye16Ta2000BM.ATTR_SPCISCSU, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장애인특수교육비 : spciScam */
        listColumnDefs.add(new ColumnDef("특별공제_장애인특수교육비", Ye16Ta2000BM.ATTR_SPCISCAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비공제대상금액 : spedEtar */
        listColumnDefs.add(new ColumnDef("특별공제_교육비공제대상금액", Ye16Ta2000BM.ATTR_SPEDETAR, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_교육비계 : siedToam */
        listColumnDefs.add(new ColumnDef("특별공제_교육비계", Ye16Ta2000BM.ATTR_SIEDTOAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
        listColumnDefs.add(new ColumnDef("특별공제_차입금원리금상환액_대출기관", Ye16Ta2000BM.ATTR_SPCIREFN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
        listColumnDefs.add(new ColumnDef("특별공제_차입금원리금상환액_거주자", Ye16Ta2000BM.ATTR_SPCIRESF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_주택자금_월세금액 : spciHtam */
        listColumnDefs.add(new ColumnDef("특별공제_주택자금_월세금액", Ye16Ta2000BM.ATTR_SPCIHTAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_장기주택이자상환액 : spchRefn */
        listColumnDefs.add(new ColumnDef("특별공제_장기주택이자상환액", Ye16Ta2000BM.ATTR_SPCHREFN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금15 : spchRe06 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금15", Ye16Ta2000BM.ATTR_SPCHRE06, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금29 : spchRe10 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금29", Ye16Ta2000BM.ATTR_SPCHRE10, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_11장기주택저당차입금30 : spchRe20 */
        listColumnDefs.add(new ColumnDef("특별공제_11장기주택저당차입금30", Ye16Ta2000BM.ATTR_SPCHRE20, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_12장기주택저당차입금_고정 : spchRefx */
        listColumnDefs.add(new ColumnDef("특별공제_12장기주택저당차입금_고정", Ye16Ta2000BM.ATTR_SPCHREFX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_12장기주택저당차입금_기타 : spchReec */
        listColumnDefs.add(new ColumnDef("특별공제_12장기주택저당차입금_기타", Ye16Ta2000BM.ATTR_SPCHREEC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15고정AND비거치상환", Ye16Ta2000BM.ATTR_SPCH15FX, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15고정OR비거치상환", Ye16Ta2000BM.ATTR_SPCH15FB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_15기타대출 : spch15ec */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_15기타대출", Ye16Ta2000BM.ATTR_SPCH15EC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_10고정OR비거치상환", Ye16Ta2000BM.ATTR_SPCH10FB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_15장기주택저당_10기타대출 : spch10ec */
        listColumnDefs.add(new ColumnDef("특별공제_15장기주택저당_10기타대출", Ye16Ta2000BM.ATTR_SPCH10EC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_기부정치자금금액 : taxdPltc */
        listColumnDefs.add(new ColumnDef("세액공제_기부정치자금금액", Ye16Ta2000BM.ATTR_TAXDPLTC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
        listColumnDefs.add(new ColumnDef("특별공제_기부정치자금_10이하대상금액", Ye16Ta2000BM.ATTR_TAXD10TG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_정치 : spciPltc */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_정치", Ye16Ta2000BM.ATTR_SPCIPLTC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_정치10초과대상금액 : spciPltg */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_정치10초과대상금액", Ye16Ta2000BM.ATTR_SPCIPLTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_법정 : spciFbam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_법정", Ye16Ta2000BM.ATTR_SPCIFBAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_법정대상금액 : spciFbtg */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_법정대상금액", Ye16Ta2000BM.ATTR_SPCIFBTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_특례_공익법인신탁제외", Ye16Ta2000BM.ATTR_SPCIEXAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_공익법인신탁특례", Ye16Ta2000BM.ATTR_SPCIUNON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_우리사주조합2015이후 : spciHfam */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_우리사주조합2015이후", Ye16Ta2000BM.ATTR_SPCIHFAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_종교단체 : spciYamt */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_종교단체", Ye16Ta2000BM.ATTR_SPCIYAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_기부금_종교단체외 : spciNamt */
        listColumnDefs.add(new ColumnDef("특별공제_기부금_종교단체외", Ye16Ta2000BM.ATTR_SPCINAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_지정기부금대상금액 : spciDgtg */
        listColumnDefs.add(new ColumnDef("특별공제_지정기부금대상금액", Ye16Ta2000BM.ATTR_SPCIDGTG, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
        listColumnDefs.add(new ColumnDef("특별공제_혼인_이사_장례비_삭제", Ye16Ta2000BM.ATTR_SPCIFNRL, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축불입액_2000년이전 : prvm20be */
        listColumnDefs.add(new ColumnDef("개인연금저축불입액_2000년이전", Ye16Ta2000BM.ATTR_PRVM20BE, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축불입액_2001년이후_삭제 : prvm21af */
        listColumnDefs.add(new ColumnDef("개인연금저축불입액_2001년이후_삭제", Ye16Ta2000BM.ATTR_PRVM21AF, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_소기업공제불입금액 : etchPrep */
        listColumnDefs.add(new ColumnDef("기타공제_소기업공제불입금액", Ye16Ta2000BM.ATTR_ETCHPREP, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_청약저축 : etcsComp */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_청약저축", Ye16Ta2000BM.ATTR_ETCSCOMP, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_근로자주택마련저축", Ye16Ta2000BM.ATTR_ETWKHSVM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_주택청약종합저축", Ye16Ta2000BM.ATTR_ETWKHSBM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축_장기주택마련저축_del", Ye16Ta2000BM.ATTR_ETWKHLGM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_주택마련저축소득금액 : etwkHbdm */
        listColumnDefs.add(new ColumnDef("기타공제_주택마련저축소득금액", Ye16Ta2000BM.ATTR_ETWKHBDM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2011이전 : etctConc */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2011이전", Ye16Ta2000BM.ATTR_ETCTCONC, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2012년도 : etgdH09f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2012년도", Ye16Ta2000BM.ATTR_ETGDH09F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2013년도 : etgdH13f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2013년도", Ye16Ta2000BM.ATTR_ETGDH13F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2014년도 : etgdH14f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2014년도", Ye16Ta2000BM.ATTR_ETGDH14F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제투자조합출자금액계 : etgdHdam */
        listColumnDefs.add(new ColumnDef("기타공제투자조합출자금액계", Ye16Ta2000BM.ATTR_ETGDHDAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_신용카드등사용금액 : etctCard */
        listColumnDefs.add(new ColumnDef("기타공제_신용카드등사용금액", Ye16Ta2000BM.ATTR_ETCTCARD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_직불카드등사용금액 : etchBcbs */
        listColumnDefs.add(new ColumnDef("기타공제_직불카드등사용금액", Ye16Ta2000BM.ATTR_ETCHBCBS, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_현금영수증사용금액 : etchUeam */
        listColumnDefs.add(new ColumnDef("기타공제_현금영수증사용금액", Ye16Ta2000BM.ATTR_ETCHUEAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_전통시장사용분 : etchMgvd */
        listColumnDefs.add(new ColumnDef("기타공제_전통시장사용분", Ye16Ta2000BM.ATTR_ETCHMGVD, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_지로납부_대중교통금액 : etchBced */
        listColumnDefs.add(new ColumnDef("기타공제_지로납부_대중교통금액", Ye16Ta2000BM.ATTR_ETCHBCED, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인신용카드등사용액_2013 : cardEt13 */
        listColumnDefs.add(new ColumnDef("기타공제_본인신용카드등사용액_2013", Ye16Ta2000BM.ATTR_CARDET13, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인신용카드등사용액_2014 : cardEt14 */
        listColumnDefs.add(new ColumnDef("기타공제_본인신용카드등사용액_2014", Ye16Ta2000BM.ATTR_CARDET14, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공재율사용액_2013 : etadDd13 */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공재율사용액_2013", Ye16Ta2000BM.ATTR_ETADDD13, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공제율사용액_2014하 : etadD14l */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공제율사용액_2014하", Ye16Ta2000BM.ATTR_ETADD14L, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_신용카드등사용공제계 : etchBcue */
        listColumnDefs.add(new ColumnDef("기타공제_신용카드등사용공제계", Ye16Ta2000BM.ATTR_ETCHBCUE, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_우리사주출연금액 : etckUnon */
        listColumnDefs.add(new ColumnDef("기타공제_우리사주출연금액", Ye16Ta2000BM.ATTR_ETCKUNON, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_우리사주조합기부금2014이전 : etckUncb */
        listColumnDefs.add(new ColumnDef("기타공제_우리사주조합기부금2014이전", Ye16Ta2000BM.ATTR_ETCKUNCB, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
        listColumnDefs.add(new ColumnDef("기타공제_고용유지중소기업근로자임금삭감액", Ye16Ta2000BM.ATTR_ETEPHSAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
        listColumnDefs.add(new ColumnDef("기타공제_목돈안드는전세이자상환금액", Ye16Ta2000BM.ATTR_ETGDCTRA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기집합투자증권저축금액 : etepSest */
        listColumnDefs.add(new ColumnDef("기타공제_장기집합투자증권저축금액", Ye16Ta2000BM.ATTR_ETEPSEST, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_1년차_삭제", Ye16Ta2000BM.ATTR_ETCLHM01, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_2년차_삭제", Ye16Ta2000BM.ATTR_ETCLHM02, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_3년차_삭제", Ye16Ta2000BM.ATTR_ETCLHM03, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_2015년이후 : etclH15f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_2015년이후", Ye16Ta2000BM.ATTR_ETCLH15F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
        listColumnDefs.add(new ColumnDef("기타공제_장기주식형저축_납입합계금액_삭제", Ye16Ta2000BM.ATTR_ETCLHMTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_기타제목 : etclEttl */
        listColumnDefs.add(new ColumnDef("기타공제_기타제목", Ye16Ta2000BM.ATTR_ETCLETTL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_기타금액 : etclEtam */
        listColumnDefs.add(new ColumnDef("기타공제_기타금액", Ye16Ta2000BM.ATTR_ETCLETAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_입국목적코드 : taxdIncd */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_입국목적코드", Ye16Ta2000BM.ATTR_TAXDINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 세액공제_외국인_입국목적코드 : taxdIncd1 */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_입국목적코드", Ye16Ta2000BM.ATTR_TAXDINCD1, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_입국목적코드 : taxdIncd2 */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_입국목적코드", Ye16Ta2000BM.ATTR_TAXDINCD2, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_입국목적코드 : taxdIncd3 */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_입국목적코드", Ye16Ta2000BM.ATTR_TAXDINCD3, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_입국목적코드 : taxdIncd4 */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_입국목적코드", Ye16Ta2000BM.ATTR_TAXDINCD4, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        
        /** column 세액공제_외국인_근로제공일자 : taxdWkdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_근로제공일자", Ye16Ta2000BM.ATTR_TAXDWKDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_감면기간만료일자 : tamaEddt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_감면기간만료일자", Ye16Ta2000BM.ATTR_TAMAEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_감면신청접수일자 : tamaIndt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_감면신청접수일자", Ye16Ta2000BM.ATTR_TAMAINDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인_감면신청제출일자 : tamaOudt */
        listColumnDefs.add(new ColumnDef("세액공제_외국인_감면신청제출일자", Ye16Ta2000BM.ATTR_TAMAOUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
        listColumnDefs.add(new ColumnDef("세액공제_외국인해저광물개발감면확인일자", Ye16Ta2000BM.ATTR_TXLGFRRD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
        listColumnDefs.add(new ColumnDef("세액공제_외국인해저광물개발감면신청일자", Ye16Ta2000BM.ATTR_TXLGFRID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
        listColumnDefs.add(new ColumnDef("세액공제_근로소득조세조약상면제접수일자", Ye16Ta2000BM.ATTR_TXLGWKID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
        listColumnDefs.add(new ColumnDef("세액공제_근로소득조세조약상면제제출일자", Ye16Ta2000BM.ATTR_TXLGTXTD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_중소기업청년감면취업일자 : txlgBscd */
        listColumnDefs.add(new ColumnDef("세액공제_중소기업청년감면취업일자", Ye16Ta2000BM.ATTR_TXLGBSCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_중소기업청년감면종료일자 : txlgBcde */
        listColumnDefs.add(new ColumnDef("세액공제_중소기업청년감면종료일자", Ye16Ta2000BM.ATTR_TXLGBCDE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_소득세법감면세액 : txlgItct */
        listColumnDefs.add(new ColumnDef("세액감면_소득세법감면세액", Ye16Ta2000BM.ATTR_TXLGITCT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_취업청년감면대상총급여액 : txlgBsta */
        listColumnDefs.add(new ColumnDef("세액감면_취업청년감면대상총급여액", Ye16Ta2000BM.ATTR_TXLGBSTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_취업청년감면근로자총급여액 : txlgWkta */
        listColumnDefs.add(new ColumnDef("세액감면_취업청년감면근로자총급여액", Ye16Ta2000BM.ATTR_TXLGWKTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_계산감면세액금액 : txlgClta */
        listColumnDefs.add(new ColumnDef("세액감면_계산감면세액금액", Ye16Ta2000BM.ATTR_TXLGCLTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_외국인기술자감면세액 : txlgFrta */
        listColumnDefs.add(new ColumnDef("세액감면_외국인기술자감면세액", Ye16Ta2000BM.ATTR_TXLGFRTA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액감면_조세조약감면세액 : txlgTxty */
        listColumnDefs.add(new ColumnDef("세액감면_조세조약감면세액", Ye16Ta2000BM.ATTR_TXLGTXTY, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_국외원천소득금액 : txlgInam */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_국외원천소득금액", Ye16Ta2000BM.ATTR_TXLGINAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_외화납세액 : txlgDlam */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_외화납세액", Ye16Ta2000BM.ATTR_TXLGDLAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_원화납세액 : txlgWnam */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_원화납세액", Ye16Ta2000BM.ATTR_TXLGWNAM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_납세국명 : txlgOtcy */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_납세국명", Ye16Ta2000BM.ATTR_TXLGOTCY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_납부일자 : txlgOtdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_납부일자", Ye16Ta2000BM.ATTR_TXLGOTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_신청서제출일자 : txlgApdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_신청서제출일자", Ye16Ta2000BM.ATTR_TXLGAPDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_국외근무처명 : txlgOuwk */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_국외근무처명", Ye16Ta2000BM.ATTR_TXLGOUWK, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_근무시작일자 : txapStdt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_근무시작일자", Ye16Ta2000BM.ATTR_TXAPSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_근무종료일자 : txapEddt */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_근무종료일자", Ye16Ta2000BM.ATTR_TXAPEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_외국납부_직책 : txapWkdy */
        listColumnDefs.add(new ColumnDef("세액공제_외국납부_직책", Ye16Ta2000BM.ATTR_TXAPWKDY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_납세조합공제 : taxdUnin */
        listColumnDefs.add(new ColumnDef("세액공제_납세조합공제", Ye16Ta2000BM.ATTR_TAXDUNIN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 세액공제_주택차입금이자상황금액 : taxdLoaa */
        listColumnDefs.add(new ColumnDef("세액공제_주택차입금이자상황금액", Ye16Ta2000BM.ATTR_TAXDLOAA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 추가서류_연금저축등소득공제제출여부 : addcNtyn */
        listColumnDefs.add(new ColumnDef("추가서류_연금저축등소득공제제출여부", Ye16Ta2000BM.ATTR_ADDCNTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
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
        
        /** column 기타공제_본인신용카등사용액_2015 : cardEt15 */
        listColumnDefs.add(new ColumnDef("기타공제_본인신용카등사용액_2015", Ye16Ta2000BM.ATTR_CARDET15, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공제율사용액2015상반기", Ye16Ta2000BM.ATTR_ETADD15H, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공제율사용액2015하반기 : etadD15l */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공제율사용액2015하반기", Ye16Ta2000BM.ATTR_ETADD15L, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
       
        /** column 난임수술비용 : ctifTram */
        listColumnDefs.add(new ColumnDef("난임수술비용", Ye16Ta2000BM.ATTR_CTIFTRAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 법정기부금2014금액 : spciOb14 */
        listColumnDefs.add(new ColumnDef("법정기부금2014금액", Ye16Ta2000BM.ATTR_SPCIOB14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 종교단체2014금액 : spciOy14 */
        listColumnDefs.add(new ColumnDef("종교단체2014금액", Ye16Ta2000BM.ATTR_SPCIOY14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 종교단체외2014금액 : spciOn14 */
        listColumnDefs.add(new ColumnDef("종교단체외2014금액", Ye16Ta2000BM.ATTR_SPCION14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 법정기부금2014대상금액 : spciFb14 */
        listColumnDefs.add(new ColumnDef("법정기부금2014대상금액", Ye16Ta2000BM.ATTR_SPCIFB14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 종교단체2014대상금액 : spciYa14 */
        listColumnDefs.add(new ColumnDef("종교단체2014대상금액", Ye16Ta2000BM.ATTR_SPCIYA14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 총교단체외2014대상금액 : spciNa14 */
        listColumnDefs.add(new ColumnDef("총교단체외2014대상금액", Ye16Ta2000BM.ATTR_SPCINA14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 분납납부금액 : divdPymtAmnt */
        listColumnDefs.add(new ColumnDef("분납납부금액", Ye16Ta2000BM.ATTR_DIVDPYMTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산분할납부신청여부 : yrenSgyn */
        listColumnDefs.add(new ColumnDef("연말정산분할납부신청여부", Ye16Ta2000BM.ATTR_YRENSGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
        listColumnDefs.add(new ColumnDef("추가소득세적용비율코드", Ye16Ta2000BM.ATTR_ADDINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인법인소속파견근로자여부 : frnrRnyn */
        listColumnDefs.add(new ColumnDef("외국인법인소속파견근로자여부", Ye16Ta2000BM.ATTR_FRNRRNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_14_벤처 : etgdH14b */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_14_벤처", Ye16Ta2000BM.ATTR_ETGDH14B, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_15_벤처 : etclH15b */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_15_벤처", Ye16Ta2000BM.ATTR_ETCLH15B, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_16_조합 : etclH16f */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_16_조합", Ye16Ta2000BM.ATTR_ETCLH16F, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_투자조합출자금액_16_벤처 : etclH16b */
        listColumnDefs.add(new ColumnDef("기타공제_투자조합출자금액_16_벤처", Ye16Ta2000BM.ATTR_ETCLH16B, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기타공제_본인추가공제율사용액_2016상 : etadD16l */
        listColumnDefs.add(new ColumnDef("기타공제_본인추가공제율사용액_2016상", Ye16Ta2000BM.ATTR_ETADD16L, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        
        /** column 원천징수의무부서코드 : yetaDpcd */
        listColumnDefs.add(new ColumnDef("원천징수의무부서코드", Ye16Ta2000BM.ATTR_YETADPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 마감여부 : closFlag */
        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta2000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : closDate */
        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta2000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        return listColumnDefs;
	}
 
   /**
    * 
    * <pre>
    * 1. 개요 :   yeta0100 화면 대상자 선정결과 리스트
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : getYeta0100ToYeta2000List
    * @date : Jan 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @return
    */

	
	private List<ColumnDef> getYeta0100ToYeta2000List() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye16Ta2000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbnm */
        listColumnDefs.add(new ColumnDef("정산구분", Ye16Ta2000BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 부서명 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Ye16Ta2000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Ye16Ta2000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta2000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
  
       
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 연말정산마감일련번호 : edacSeilNum */
        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta2000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta2000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
    
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Ye16Ta2000BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉코드 : pyspCd */
        listColumnDefs.add(new ColumnDef("호봉코드", Ye16Ta2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Ye16Ta2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수코드 : logSvcMnthIcmCd */
        listColumnDefs.add(new ColumnDef("근속월수코드", Ye16Ta2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Ye16Ta2000BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자", Ye16Ta2000BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("고용종료일자", Ye16Ta2000BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 시작일자 : reymStdt */
        listColumnDefs.add(new ColumnDef("시작일자", Ye16Ta2000BM.ATTR_REYMSTDT, ColumnDef.TYPE_DATE , 70, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column 귀속년월_TO : reymEddt */
        listColumnDefs.add(new ColumnDef("종료일자", Ye16Ta2000BM.ATTR_REYMEDDT, ColumnDef.TYPE_DATE , 70, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        
        /** column 주근무지_급여총액 : payrTamt */
        listColumnDefs.add(new ColumnDef("급여총액", Ye16Ta3000BM.ATTR_PAYRTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 주근무지_상여총액 : bonsToam */
        listColumnDefs.add(new ColumnDef("상여총액", Ye16Ta3000BM.ATTR_BONSTOAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 주근무지_국민연금보험료 : jnatPsnf */
        listColumnDefs.add(new ColumnDef("국민연금", Ye16Ta2000BM.ATTR_JNATPSNF, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 특별공제_주건강보험료 : spciHhlh */
        listColumnDefs.add(new ColumnDef("건강보험", Ye16Ta2000BM.ATTR_SPCIHHLH, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 특별공제_주고용보험료 : spciJepf */
        listColumnDefs.add(new ColumnDef("고용보험", Ye16Ta2000BM.ATTR_SPCIJEPF, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 기납부세액_소득세 : alryPinx */
        listColumnDefs.add(new ColumnDef("소득세", Ye16Ta3000BM.ATTR_ALRYPINX, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 기납부세액_주민세_지방소득세 : alryPhbx */
        listColumnDefs.add(new ColumnDef("지방소득세", Ye16Ta3000BM.ATTR_ALRYPHBX, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column 기납부세액_농특세 : alryYvtx */
        listColumnDefs.add(new ColumnDef("농특세", Ye16Ta3000BM.ATTR_ALRYYVTX, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 재직구분코드 : hdofcDivCd */
        listColumnDefs.add(new ColumnDef("재직구분코드", Ye16Ta2000BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 재직 : hdofcDivNm */
        listColumnDefs.add(new ColumnDef("재직", Ye16Ta2000BM.ATTR_HDOFCDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직종명 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Ye16Ta2000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 직종세명 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세", Ye16Ta2000BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });

        
        /** column 사업명 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Ye16Ta2000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column 마감여부 : closFlag */
        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta2000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : closDate */
        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta2000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
          return listColumnDefs;
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getYeta1200ToYeta2000List
	 * @date : Jan 26, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 26, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @return
	 */
	private List<ColumnDef> getYeta1200ToYeta2000List() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye16Ta2000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbnm */
        listColumnDefs.add(new ColumnDef("정산구분", Ye16Ta2000BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 부서명 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Ye16Ta2000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Ye16Ta2000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta2000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });
        
         
        /** column 파일생성여부 : jdocFile */
        listColumnDefs.add(new ColumnDef("제출구분", Ye16Ta2000BM.ATTR_JDOCFNNM, ColumnDef.TYPE_STRING , 70, true,true, true){
        	{

        	}
        });
       
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 연말정산마감일련번호 : edacSeilNum */
        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta2000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta2000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
    
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Ye16Ta2000BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉코드 : pyspCd */
        listColumnDefs.add(new ColumnDef("호봉코드", Ye16Ta2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Ye16Ta2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수코드 : logSvcMnthIcmCd */
        listColumnDefs.add(new ColumnDef("근속월수코드", Ye16Ta2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Ye16Ta2000BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자", Ye16Ta2000BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("고용종료일자", Ye16Ta2000BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column 재직구분코드 : hdofcDivCd */
        listColumnDefs.add(new ColumnDef("재직구분코드", Ye16Ta2000BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 재직 : hdofcDivNm */
        listColumnDefs.add(new ColumnDef("재직", Ye16Ta2000BM.ATTR_HDOFCDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 직종명 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Ye16Ta2000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 직종세명 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세", Ye16Ta2000BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });

        
        /** column 사업명 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Ye16Ta2000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column 마감여부 : closFlag */
        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta2000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : closDate */
        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta2000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
          return listColumnDefs;
	}
	

	private List<ColumnDef> getYeta0300ToYeta2000List() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye16Ta2000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 60, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 70, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbnm */
        listColumnDefs.add(new ColumnDef("정산구분", Ye16Ta2000BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서명 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", Ye16Ta2000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Ye16Ta2000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta2000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
  
       
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 연말정산마감일련번호 : edacSeilNum */
        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta2000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta2000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
    
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Ye16Ta2000BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉코드 : pyspCd */
        listColumnDefs.add(new ColumnDef("호봉코드", Ye16Ta2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Ye16Ta2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수코드 : logSvcMnthIcmCd */
        listColumnDefs.add(new ColumnDef("근속월수코드", Ye16Ta2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Ye16Ta2000BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자", Ye16Ta2000BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("고용종료일자", Ye16Ta2000BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
      
        
        /** column 재직구분코드 : hdofcDivCd */
        listColumnDefs.add(new ColumnDef("재직구분코드", Ye16Ta2000BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        /** column 재직 : hdofcDivNm */
        listColumnDefs.add(new ColumnDef("재직", Ye16Ta2000BM.ATTR_HDOFCDIVNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종명 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Ye16Ta2000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 직종세명 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세", Ye16Ta2000BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });

        
        /** column 사업명 : businCd */
        listColumnDefs.add(new ColumnDef("사업", Ye16Ta2000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column 마감여부 : closFlag */
        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta2000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 마감일자 : closDate */
        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta2000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
          return listColumnDefs;
	}
	
	   /**
	    * 
	    * <pre>
	    * 1. 개요 :   yeta0100 화면 대상자 선정결과 리스트
	    * 2. 처리내용 : 
	    * </pre>
	    * @Method Name : getYeta1100ToYe16Ta2000List
	    * @date : Jan 25, 2016
	    * @author : leeheuisung
	    * @history : 
	    *	-----------------------------------------------------------------------
	    *	변경일				작성자						변경내용  
	    *	----------- ------------------- ---------------------------------------
	    *	Jan 25, 2016		leeheuisung				최초 작성 
	    *	-----------------------------------------------------------------------
	    * 
	    * @return
	    */
		private List<ColumnDef> getYeta1100ToYe16Ta2000List() {
			 
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	        
	        
	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 연말정산귀속년도 : edacRvyy */
	        listColumnDefs.add(new ColumnDef("귀속년도", Ye16Ta2000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 60, true, true, true){
	        	{

	        	}
	        });
	        /** column 정산구분코드 : settGbcd */
	        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 70, true, false, true){
	        	{

	        	}
	        });
	        /** column 정산구분코드 : settGbnm */
	        listColumnDefs.add(new ColumnDef("정산구분", Ye16Ta2000BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 원천징수의무부서코드 : yetaDpcd */
	        listColumnDefs.add(new ColumnDef("원천징수의무부서", Ye16Ta2000BM.ATTR_YETADPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        
	        
//	        sysComBass0400Dto.setDeptDspyYn("Y");
//	        sysComBass0400Dto.setDeptCd("");
////	        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
//	        /** column 원천징수의무부서코드 : yetaDpcd */
//	        deptCdColumnDef = new ColumnListDef("원천징수의무부서", Ye16Ta2000BM.ATTR_YETADPCD, ColumnDef.TYPE_STRING, 140, true, true, true,new LookupPrgmComBass0400(sysComBass0400Dto),PrgmComBass0400BM.ATTR_DEPTCD,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT){
//	        	{ 
//	        		
//	        	}
//	        };
	                            
//	       listColumnDefs.add(deptCdColumnDef);
//	       sysComBass0400Dto.setDeptDspyYn("");
	        /** column 부서 : deptNm */
	        listColumnDefs.add(new ColumnDef("원천징수", Ye16Ta2000BM.ATTR_YETADPNM, ColumnDef.TYPE_STRING, 140, false, true, true){
	        	{

	        	}
	        }); 	        
	        
	        
	        /** column 부서명 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Ye16Ta2000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Ye16Ta2000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 60, true, true, true){
	        	{

	        	}
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta2000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 70, true, true, true){
	        	{

	        	}
	        });
	  
	       
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        
	        /** column 연말정산마감일련번호 : edacSeilNum */
	        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta2000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, false){
	        	{

	        	}
	        });
	        /** column 급여관리부서코드 : payrMangDeptCd */
	        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta2000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	    
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 직종코드 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column null : dtilOccuInttnCd */
	        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 직책코드 : odtyCd */
	        listColumnDefs.add(new ColumnDef("직책코드", Ye16Ta2000BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 호봉코드 : pyspCd */
	        listColumnDefs.add(new ColumnDef("호봉코드", Ye16Ta2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 근속년수코드 : logSvcYrNumCd */
	        listColumnDefs.add(new ColumnDef("근속년수코드", Ye16Ta2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 근속월수코드 : logSvcMnthIcmCd */
	        listColumnDefs.add(new ColumnDef("근속월수코드", Ye16Ta2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 최초고용일자 : frstEmymtDt */
	        listColumnDefs.add(new ColumnDef("최초고용일자", Ye16Ta2000BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 고용시작일자 : emymtBgnnDt */
	        listColumnDefs.add(new ColumnDef("고용시작일자", Ye16Ta2000BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 고용종료일자 : emymtEndDt */
	        listColumnDefs.add(new ColumnDef("고용종료일자", Ye16Ta2000BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        
	        /** column 시작일자 : reymStdt */
	        listColumnDefs.add(new ColumnDef("시작일자", Ye16Ta2000BM.ATTR_REYMSTDT, ColumnDef.TYPE_DATE , 70, true, true, true){
	        	{
	        		setMaxLength(10);
	        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
	        		setDtFieldMask("9999.99.99");
	        	}
	        });
	        /** column 귀속년월_TO : reymEddt */
	        listColumnDefs.add(new ColumnDef("종료일자", Ye16Ta2000BM.ATTR_REYMEDDT, ColumnDef.TYPE_DATE , 70, true, true, true){
	        	{
	        		setMaxLength(10);
	        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
	        		setDtFieldMask("9999.99.99");
	        	}
	        });
	        
	        /** column 주근무지_급여총액 : payrTamt */
	        listColumnDefs.add(new ColumnDef("급여총액", Ye16Ta3000BM.ATTR_PAYRTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 주근무지_상여총액 : bonsToam */
	        listColumnDefs.add(new ColumnDef("상여총액", Ye16Ta3000BM.ATTR_BONSTOAM, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 주근무지_국민연금보험료 : jnatPsnf */
	        listColumnDefs.add(new ColumnDef("국민연금", Ye16Ta2000BM.ATTR_JNATPSNF, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 특별공제_주건강보험료 : spciHhlh */
	        listColumnDefs.add(new ColumnDef("건강보험", Ye16Ta2000BM.ATTR_SPCIHHLH, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 특별공제_주고용보험료 : spciJepf */
	        listColumnDefs.add(new ColumnDef("고용보험", Ye16Ta2000BM.ATTR_SPCIJEPF, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        
	        /** column 기납부세액_소득세 : alryPinx */
	        listColumnDefs.add(new ColumnDef("소득세", Ye16Ta3000BM.ATTR_ALRYPINX, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 기납부세액_주민세_지방소득세 : alryPhbx */
	        listColumnDefs.add(new ColumnDef("지방소득세", Ye16Ta3000BM.ATTR_ALRYPHBX, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 기납부세액_농특세 : alryYvtx */
	        listColumnDefs.add(new ColumnDef("농특세", Ye16Ta3000BM.ATTR_ALRYYVTX, ColumnDef.TYPE_LONG , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 재직구분코드 : hdofcDivCd */
	        listColumnDefs.add(new ColumnDef("재직구분코드", Ye16Ta2000BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 재직 : hdofcDivNm */
	        listColumnDefs.add(new ColumnDef("재직", Ye16Ta2000BM.ATTR_HDOFCDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 직종명 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Ye16Ta2000BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 70, true, true, true){
	        	{

	        	}
	        });
	        /** column 직종세명 : dtilOccuInttnCd */
	        listColumnDefs.add(new ColumnDef("직종세", Ye16Ta2000BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 70, true, true, true){
	        	{

	        	}
	        });

	        
	        /** column 사업명 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Ye16Ta2000BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 70, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 마감여부 : closFlag */
	        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta2000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 마감일자 : closDate */
	        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta2000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        
	          return listColumnDefs;
		}
 

		
	 private List<ColumnDef> getYetaP110002ToYeta2000ColumnsList() {
			 
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	        

	        /** column 연말정산귀속년도 : edacRvyy */
	        listColumnDefs.add(new ColumnDef("귀속년도", Ye16Ta2000BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 70, true, true, true){
	        	{
	        		setReadOnly(true);
	        	}
	        });
	        
	        /** column 정산구분코드 : settGbcd */
	        listColumnDefs.add(new ColumnDef("정산구분", Ye16Ta2000BM.ATTR_SETTGBNM, ColumnDef.TYPE_STRING , 70, true, true, true){
	        	{
	        		setReadOnly(true);
	        	}
	        });
	        
	        
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Ye16Ta2000BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, true, true, true){
	        	{
	        		setReadOnly(true);
	        	}
	        });
	        
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Ye16Ta2000BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{
	        		setReadOnly(true);
	        	}
	        });
	         
	        
	        sysComBass0400Dto.setDeptDspyYn("Y");
	        sysComBass0400Dto.setDeptCd("");
//	        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
	        /** column 원천징수의무부서코드 : yetaDpcd */
	        deptCdColumnDef = new ColumnListDef("원천징수의무부서", Ye16Ta2000BM.ATTR_YETADPCD, ColumnDef.TYPE_STRING, 140, true, true, true,new LookupPrgmComBass0400(sysComBass0400Dto),PrgmComBass0400BM.ATTR_DEPTCD,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT){
	        	{ 
	        		
	        	}
	        };
	                            
	       listColumnDefs.add(deptCdColumnDef);
	       sysComBass0400Dto.setDeptDspyYn("");
	        /** column 부서 : deptNm */
	        listColumnDefs.add(new ColumnDef("원천징수의무부서", Ye16Ta2000BM.ATTR_YETADPNM, ColumnDef.TYPE_STRING, 140, false, false, true){
	        	{

	        	}
	        }); 	        
	        
	        
	        
	        
	        
	        /** column 고용시작일자 : emymtBgnnDt */
	        listColumnDefs.add(new ColumnDef("시작일자", Ye16Ta2000BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{
	        		setReadOnly(true);
	        	}
	        });
	        /** column 고용종료일자 : emymtEndDt */
	        listColumnDefs.add(new ColumnDef("종료일자", Ye16Ta2000BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{
	        		setReadOnly(true);
	        	}
	        });
	        
	         

	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta2000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });

	        
	        /** column 정산구분코드 : settGbcd */
	        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        

	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta2000BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 연말정산마감일련번호 : edacSeilNum */
	        listColumnDefs.add(new ColumnDef("연말정산마감일련번호", Ye16Ta2000BM.ATTR_EDACSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 급여관리부서코드 : payrMangDeptCd */
	        listColumnDefs.add(new ColumnDef("급여관리부서코드", Ye16Ta2000BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분코드", Ye16Ta2000BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });

	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta2000BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서코드", Ye16Ta2000BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업코드", Ye16Ta2000BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 직종코드 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종코드", Ye16Ta2000BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 직종세통합코드 : dtilOccuInttnCd */
	        listColumnDefs.add(new ColumnDef("직종세통합코드", Ye16Ta2000BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세구분코드", Ye16Ta2000BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 직책코드 : odtyCd */
	        listColumnDefs.add(new ColumnDef("직책코드", Ye16Ta2000BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 호봉코드 : pyspCd */
	        listColumnDefs.add(new ColumnDef("호봉코드", Ye16Ta2000BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급코드", Ye16Ta2000BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 근속년수코드 : logSvcYrNumCd */
	        listColumnDefs.add(new ColumnDef("근속년수코드", Ye16Ta2000BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 근속월수코드 : logSvcMnthIcmCd */
	        listColumnDefs.add(new ColumnDef("근속월수코드", Ye16Ta2000BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 최초고용일자 : frstEmymtDt */
	        listColumnDefs.add(new ColumnDef("최초고용일자", Ye16Ta2000BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        
	        /** column 정산구분코드 : settGbcd */
	        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta2000BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 70, true, false, true){
	        	{

	        	}
	        });
	        
	        /** column 마감여부 : closFlag */
	        listColumnDefs.add(new ColumnDef("마감여부", Ye16Ta2000BM.ATTR_CLOSFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 마감일자 : closDate */
	        listColumnDefs.add(new ColumnDef("마감일자", Ye16Ta2000BM.ATTR_CLOSDATE, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });

	     
	          
	          return listColumnDefs;
		}
		
		
		
		
		
}
