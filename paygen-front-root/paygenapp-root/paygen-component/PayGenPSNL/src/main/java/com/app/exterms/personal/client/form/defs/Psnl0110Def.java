package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100BM;
import com.app.exterms.personal.client.dto.Psnl0110BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0500;
import com.app.exterms.prgm.client.lookup.LookupPrgmComNonBass0400;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0110Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;
    
    //권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
    private PrgmComBass0300DTO sysComBass0300Dto ;
    private PrgmComBass0320DTO sysComBass0320Dto ;
    private PrgmComBass0400DTO sysComBass0400Dto;
    private PrgmComBass0500DTO sysComBass0500Dto;
   // private boolean boolDeptCd = false ;
    
    public static final String COLUMN_DEF_DEPTCD = "deptCd"; 
    public static final String COLUMN_DEF_BUSINCD = "businCd"; 
    public static final String COLUMN_DEF_EMYMTBGNNDT = "emymtBgnnDt"; 

    public static final String FIELD_ID_DEPTCD = COLUMN_DEF_DEPTCD + "$deptCd"; 
    public static final String FIELD_ID_BUSINCD = COLUMN_DEF_DEPTCD + "$businCd"; 
    public static final String FIELD_ID_EMYMTBGNNDT = COLUMN_DEF_EMYMTBGNNDT; 
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter; 
    
    protected ColumnListDef deptCdColumnDef;
    protected ColumnListDef businCdColumnDef;

    public Psnl0110Def(){
    	
	        setTitle("");
	        setDaoClass("CLASS_PSNL0100_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0100_DATA_LIST);
	        setColumnsDefinition(getPsnl0100ToPsnl0250ColumnsList());
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
	        
    
    }
    
    public Psnl0110Def(String flag){
    	
    	
    	if("PSNL0100".equals(flag)) {
    		
    		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
    		gwtAuthorization = GWTAuthorization.getInstance();
    		gwtExtAuth = GWTExtAuth.getInstance();

    		sysComBass0300Dto = new PrgmComBass0300DTO();
    		sysComBass0320Dto = new PrgmComBass0320DTO();
    		sysComBass0400Dto = new PrgmComBass0400DTO();
    		sysComBass0500Dto = new PrgmComBass0500DTO();
    		
            setTitle("");
            setDaoClass("");
            setCustomListMethod(CLASS_PSNL0100_TO_0110_DATA_LIST);
            setColumnsDefinition(getPsnl0100To0110ColumnsList());
            setAutoFillGrid(false);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(false);
            setEditFieldGrid(true);
            
    		
    	}else if("PSNLP020001".equals(flag)) {
    		
            setTitle("");
            setDaoClass("CLASS_PSNL0100_DATA_LIST");
            setCustomListMethod(CLASS_PSNL0100_DATA_LIST);
            setColumnsDefinition(getPsnl0100ToPsnl0250ColumnsList());
            setAutoFillGrid(false);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(true);
            setEditFieldGrid(false);
            
    	}else if("PSNL0400".equals(flag)) {
    		
            setTitle("");
            setDaoClass("");
            setCustomListMethod(CLASS_PSNL0400_TO_PSNL0110_DATA_LIST);
            setColumnsDefinition(getPsnl0400ToPsnl0110ColumnsList());
            setAutoFillGrid(true);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(true);
            setEditFieldGrid(false);
            
		}

	}

    private List<ColumnDef> getPsnl0100ToPsnl0250ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 순번 : rnum */
        listColumnDefs.add(new ColumnDef("순번", Psnl0110BM.ATTR_RNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0110BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Psnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0110BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
//        
//        /** column 주민등록번호 : resnSecNum */
//        listColumnDefs.add(new ColumnDef("주민번호", Psnl0100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 100, false, false, false){
//        	{
//
//        	}
//        });
//        
//        /** column 고용구분코드 : emymtDivCd */
//        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 120, true, true, true){
//        	{
//
//        	}
//        });
//        
//        /** column 부서 : deptNm */
//        listColumnDefs.add(new ColumnDef("부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 250, true, true, true){
//        	{
//        		setReadOnly(true);
//        	}
//        });
//        
//        /** column 직종 : typOccuNm */
//        listColumnDefs.add(new ColumnDef("직종", Psnl0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 250, true, true, true){
//        	{
//        		setReadOnly(true);
//        	}
//        });
//        
//       
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column SYSTEMKEY : systemkey */
//        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        
//        /** column 영문성명 : engNm */
//        listColumnDefs.add(new ColumnDef("영문성명", Psnl0100BM.ATTR_ENGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 한문성명 : chinCharNm */
//        listColumnDefs.add(new ColumnDef("한문성명", Psnl0100BM.ATTR_CHINCHARNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        
//        /** column 성별구분코드 : sxDivCd */
//        listColumnDefs.add(new ColumnDef("성별구분코드", Psnl0100BM.ATTR_SXDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 생년월일 : yoobhMnthDay */
//        listColumnDefs.add(new ColumnDef("생년월일", Psnl0100BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 음양구분코드 : sclcDivCd */
//        listColumnDefs.add(new ColumnDef("음양구분코드", Psnl0100BM.ATTR_SCLCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 국가코드 : natnCd */
//        listColumnDefs.add(new ColumnDef("국가코드", Psnl0100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 부서코드 : deptCd */
//        listColumnDefs.add(new ColumnDef("부서코드", Psnl0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 사업코드 : businCd */
//        listColumnDefs.add(new ColumnDef("사업코드", Psnl0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현소속부서코드 : currAffnDeptCd */
//        listColumnDefs.add(new ColumnDef("현소속부서코드", Psnl0100BM.ATTR_CURRAFFNDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 담당업무구분코드 : repbtyBusinDivCd */
//        listColumnDefs.add(new ColumnDef("담당업무구분코드", Psnl0100BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직종코드 : typOccuCd */
//        listColumnDefs.add(new ColumnDef("직종코드", Psnl0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직책코드 : odtyCd */
//        listColumnDefs.add(new ColumnDef("직책코드", Psnl0100BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 최초고용일자 : frstEmymtDt */
//        listColumnDefs.add(new ColumnDef("최초고용일자", Psnl0100BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 고용구분코드 : emymtDivCd */
//        listColumnDefs.add(new ColumnDef("고용구분코드", Psnl0100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 고용시작일자 : emymtBgnnDt */
//        listColumnDefs.add(new ColumnDef("고용시작일자", Psnl0100BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 고용종료일자 : emymtEndDt */
//        listColumnDefs.add(new ColumnDef("고용종료일자", Psnl0100BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 호봉코드 : pyspCd */
//        listColumnDefs.add(new ColumnDef("호봉코드", Psnl0100BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 재직상태코드 : hdofcCodtnCd */
//        listColumnDefs.add(new ColumnDef("재직상태코드", Psnl0100BM.ATTR_HDOFCCODTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 퇴직일자 : retryDt */
//        listColumnDefs.add(new ColumnDef("퇴직일자", Psnl0100BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 퇴직사유내용 : retryReasCtnt */
//        listColumnDefs.add(new ColumnDef("퇴직사유내용", Psnl0100BM.ATTR_RETRYREASCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 외국인구분코드 : frgnrDivCd */
//        listColumnDefs.add(new ColumnDef("외국인구분코드", Psnl0100BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 여권번호 : psptNum */
//        listColumnDefs.add(new ColumnDef("여권번호", Psnl0100BM.ATTR_PSPTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 체류시작일자 : styBgnnDt */
//        listColumnDefs.add(new ColumnDef("체류시작일자", Psnl0100BM.ATTR_STYBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 체류종료일자 : styEndDt */
//        listColumnDefs.add(new ColumnDef("체류종료일자", Psnl0100BM.ATTR_STYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 최종학교 : endSchl */
//        listColumnDefs.add(new ColumnDef("최종학교", Psnl0100BM.ATTR_ENDSCHL, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 최종학위구분코드 : endDegrDivCd */
//        listColumnDefs.add(new ColumnDef("최종학위구분코드", Psnl0100BM.ATTR_ENDDEGRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 승진예정일자 : pmtnScduDt */
//        listColumnDefs.add(new ColumnDef("승진예정일자", Psnl0100BM.ATTR_PMTNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 호봉승급예정일자 : pyspPrmtnScduDt */
//        listColumnDefs.add(new ColumnDef("호봉승급예정일자", Psnl0100BM.ATTR_PYSPPRMTNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 재고용예정일자 : reymnScduDt */
//        listColumnDefs.add(new ColumnDef("재고용예정일자", Psnl0100BM.ATTR_REYMNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 근속년수코드 : logSvcYrNumCd */
//        listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0100BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 근속월수코드 : logSvcMnthIcmCd */
//        listColumnDefs.add(new ColumnDef("근속월수코드", Psnl0100BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현_호봉발령일자 : currPyspAppmtDt */
//        listColumnDefs.add(new ColumnDef("현_호봉발령일자", Psnl0100BM.ATTR_CURRPYSPAPPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현_부서발령일자 : currDeptAppmtDt */
//        listColumnDefs.add(new ColumnDef("현_부서발령일자", Psnl0100BM.ATTR_CURRDEPTAPPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 인사비고내용 : pernNoteCtnt */
//        listColumnDefs.add(new ColumnDef("인사비고내용", Psnl0100BM.ATTR_PERNNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Psnl0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Psnl0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Psnl0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Psnl0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Psnl0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Psnl0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 호봉등급코드 : pyspGrdeCd */
//        listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직종세구분코드 : dtilOccuClsDivCd */
//        listColumnDefs.add(new ColumnDef("직종세구분코드", Psnl0100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        

        
        return listColumnDefs;
    }
    
    
	private List<ColumnDef> getPsnl0400ToPsnl0110ColumnsList() {
		row = 0;

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
		
		
        /** column 고용유형코드 : emymtTypNm */
        listColumnDefs.add(new ColumnDef("고용유형", Psnl0110BM.ATTR_EMYMTTYPNM, ColumnDef.TYPE_STRING , 90, false, true, false){
        	{

        	}
        });
        
        
		/** column 고용시작일자 : emymtBgnnDt */
		listColumnDefs.add(new ColumnDef("근무시작일자", Psnl0110BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_DATE , 100, true, true, true){
			{
				setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
				setDtFieldMask("9999.99.99");
			}
		});
		/** column 고용종료일자 : emymtEndDt */
		listColumnDefs.add(new ColumnDef("근무종료일자", Psnl0110BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_DATE , 100, true, true, true){
			{
				setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
				setDtFieldMask("9999.99.99");
			}
		});
      
		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분", Psnl0110BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 120, true, true, true){
			{

			}
		});
		
        listColumnDefs.add(new ColumnDef("부서", Psnl0110BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 120, true, true, true){
        	{
        		
        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종명", Psnl0110BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 120, true, true, true){
        	{
        		
        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세명", Psnl0110BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업명", Psnl0100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{
	
	      	}
        });
        
        /** column 고용일련번호 : emymtSeilNum */
        listColumnDefs.add(new ColumnDef("고용일련번호", Psnl0110BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0110BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Psnl0110BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
      
        listColumnDefs.add(new ColumnDef("부서", Psnl0110BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 250, true, false, true){
        	{
        		
        	}
        });
        
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Psnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0110BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Psnl0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 250, true, false, true){
        	{
        		
        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세명", Psnl0110BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 120, true, false, true){
        	{

        	}
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Psnl0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
	
	      	}
        });
//        
//        /** column 주민등록번호 : resnSecNum */
//        listColumnDefs.add(new ColumnDef("주민번호", Psnl0100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 100, false, false, false){
//        	{
//
//        	}
//        });
//        
//        /** column 고용구분코드 : emymtDivCd */
//        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 120, true, true, true){
//        	{
//
//        	}
//        });
//        
//        /** column 부서 : deptNm */
//        listColumnDefs.add(new ColumnDef("부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 250, true, true, true){
//        	{
//        		setReadOnly(true);
//        	}
//        });
//        
//        /** column 직종 : typOccuNm */
//        listColumnDefs.add(new ColumnDef("직종", Psnl0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 250, true, true, true){
//        	{
//        		setReadOnly(true);
//        	}
//        });
//        
//       
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column SYSTEMKEY : systemkey */
//        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        
//        /** column 영문성명 : engNm */
//        listColumnDefs.add(new ColumnDef("영문성명", Psnl0100BM.ATTR_ENGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 한문성명 : chinCharNm */
//        listColumnDefs.add(new ColumnDef("한문성명", Psnl0100BM.ATTR_CHINCHARNM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        
//        /** column 성별구분코드 : sxDivCd */
//        listColumnDefs.add(new ColumnDef("성별구분코드", Psnl0100BM.ATTR_SXDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 생년월일 : yoobhMnthDay */
//        listColumnDefs.add(new ColumnDef("생년월일", Psnl0100BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 음양구분코드 : sclcDivCd */
//        listColumnDefs.add(new ColumnDef("음양구분코드", Psnl0100BM.ATTR_SCLCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 국가코드 : natnCd */
//        listColumnDefs.add(new ColumnDef("국가코드", Psnl0100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 부서코드 : deptCd */
//        listColumnDefs.add(new ColumnDef("부서코드", Psnl0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 사업코드 : businCd */
//        listColumnDefs.add(new ColumnDef("사업코드", Psnl0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현소속부서코드 : currAffnDeptCd */
//        listColumnDefs.add(new ColumnDef("현소속부서코드", Psnl0100BM.ATTR_CURRAFFNDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 담당업무구분코드 : repbtyBusinDivCd */
//        listColumnDefs.add(new ColumnDef("담당업무구분코드", Psnl0100BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직종코드 : typOccuCd */
//        listColumnDefs.add(new ColumnDef("직종코드", Psnl0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직책코드 : odtyCd */
//        listColumnDefs.add(new ColumnDef("직책코드", Psnl0100BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 최초고용일자 : frstEmymtDt */
//        listColumnDefs.add(new ColumnDef("최초고용일자", Psnl0100BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });


//        /** column 호봉코드 : pyspCd */
//        listColumnDefs.add(new ColumnDef("호봉코드", Psnl0100BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 재직상태코드 : hdofcCodtnCd */
//        listColumnDefs.add(new ColumnDef("재직상태코드", Psnl0100BM.ATTR_HDOFCCODTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 퇴직일자 : retryDt */
//        listColumnDefs.add(new ColumnDef("퇴직일자", Psnl0100BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 퇴직사유내용 : retryReasCtnt */
//        listColumnDefs.add(new ColumnDef("퇴직사유내용", Psnl0100BM.ATTR_RETRYREASCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 외국인구분코드 : frgnrDivCd */
//        listColumnDefs.add(new ColumnDef("외국인구분코드", Psnl0100BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 여권번호 : psptNum */
//        listColumnDefs.add(new ColumnDef("여권번호", Psnl0100BM.ATTR_PSPTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 체류시작일자 : styBgnnDt */
//        listColumnDefs.add(new ColumnDef("체류시작일자", Psnl0100BM.ATTR_STYBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 체류종료일자 : styEndDt */
//        listColumnDefs.add(new ColumnDef("체류종료일자", Psnl0100BM.ATTR_STYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 최종학교 : endSchl */
//        listColumnDefs.add(new ColumnDef("최종학교", Psnl0100BM.ATTR_ENDSCHL, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 최종학위구분코드 : endDegrDivCd */
//        listColumnDefs.add(new ColumnDef("최종학위구분코드", Psnl0100BM.ATTR_ENDDEGRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 승진예정일자 : pmtnScduDt */
//        listColumnDefs.add(new ColumnDef("승진예정일자", Psnl0100BM.ATTR_PMTNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 호봉승급예정일자 : pyspPrmtnScduDt */
//        listColumnDefs.add(new ColumnDef("호봉승급예정일자", Psnl0100BM.ATTR_PYSPPRMTNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 재고용예정일자 : reymnScduDt */
//        listColumnDefs.add(new ColumnDef("재고용예정일자", Psnl0100BM.ATTR_REYMNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 근속년수코드 : logSvcYrNumCd */
//        listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0100BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 근속월수코드 : logSvcMnthIcmCd */
//        listColumnDefs.add(new ColumnDef("근속월수코드", Psnl0100BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현_호봉발령일자 : currPyspAppmtDt */
//        listColumnDefs.add(new ColumnDef("현_호봉발령일자", Psnl0100BM.ATTR_CURRPYSPAPPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 현_부서발령일자 : currDeptAppmtDt */
//        listColumnDefs.add(new ColumnDef("현_부서발령일자", Psnl0100BM.ATTR_CURRDEPTAPPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 인사비고내용 : pernNoteCtnt */
//        listColumnDefs.add(new ColumnDef("인사비고내용", Psnl0100BM.ATTR_PERNNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Psnl0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Psnl0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Psnl0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Psnl0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Psnl0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Psnl0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 호봉등급코드 : pyspGrdeCd */
//        listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 직종세구분코드 : dtilOccuClsDivCd */
//        listColumnDefs.add(new ColumnDef("직종세구분코드", Psnl0100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        
        /** column 퇴직사유내용 : retryReasCtnt */
        listColumnDefs.add(new ColumnDef("퇴직사유내용", Psnl0110BM.ATTR_RETRYREASCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직이직사유구분코드 : retryDivCd */
        listColumnDefs.add(new ColumnDef("퇴직이직사유구분코드", Psnl0110BM.ATTR_RETRYDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        return listColumnDefs;
    }
    
    
    
    
    private List<ColumnDef> getPsnl0100To0110ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        changeValueListenerAdapter = new ColumnDefListenerAdapter() {
            @SuppressWarnings("rawtypes")
            public void run(Field field, Object valueField) {

            	MSFFormPanel formPanel = getMsfGridPanel().getMSFFormPanel();
   			 	final ModelData formModel = formPanel.getFormBinding().getModel();
   		  
                //To get by name the combo box fields
                Field businCdField = findFieldByAttributeName(FIELD_ID_BUSINCD); 
                
                
                if (FIELD_ID_DEPTCD.equals(field.getItemId()) ) {
                    //Clear countries and locations
                    GWTUtils.clearField(businCdField); 
                    //Reload Countries
                    BaseModel item = (BaseModel)valueField;
                    String deptCd = (String)item.get("deptCd");
                    String emymtBgnnDt =  GWTUtils.getStringFromDate((Date) formModel.get(Psnl0110BM.ATTR_EMYMTBGNNDT), "yyyyMMdd") ;   
                    
                    
                    
                    
                    Date today = new Date(); 
                    DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");  
                    
                    businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("deptCd", deptCd, SimpleColumnFilter.OPERATOR_EQUALS));
                    businCdColumnDef.getTableDef().addColumnFilter("chkCombo", "combo" , SimpleColumnFilter.OPERATOR_EQUALS); 
//                    businCdColumnDef.getTableDef().addColumnFilter("businApptnYr",fmt.format(today), SimpleColumnFilter.OPERATOR_EQUALS); 
                    businCdColumnDef.getTableDef().addColumnFilter("businApptnYr",emymtBgnnDt.substring(0, 4), SimpleColumnFilter.OPERATOR_EQUALS); 
                    
                    
                    //MSFSharedUtils.allowNulls(jobYrMnthField.getValue())
                    //businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("businApptnYr", MSFSharedUtils.allowNulls(jobYrMnthField.getValue()).substring(0,4), SimpleColumnFilter.OPERATOR_EQUALS));
                    //businCdColumnDef.getTableDef().setTableColumnFilters(new SimpleColumnFilter("deptCd", deptCd, SimpleColumnFilter.OPERATOR_EQUALS));
                    businCdColumnDef.readData();

                 } 
            }
        };
        
        
        listColumnDefs.add(new ColumnDef("삭제", Psnl0110BM.ATTR_DELCHK, ColumnDef.TYPE_BOOLEAN , 40, true, true, true){
        	{
        		
        	}
        });
        
        
        
        sysComBass0300Dto.setRpsttvCd("A002"); 
    	sysComBass0300Dto.setCommUseYn("A");  //조건을 넣으면 사용여부 구분처리를 한 후 보여줌 
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnListDef("고용구분", Psnl0110BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 100, true, true, true ,new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
//            	 if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//            	        setReadOnly(true);
//                  
//            	 } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//            	     setReadOnly(true);
//            	 }
//        		  setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        		
        	} 
        });
        sysComBass0300Dto.setCommUseYn("");  
        
        
        sysComBass0300Dto.setRpsttvCd("A042");
		sysComBass0300Dto.setMangeItem01("Y");
		/** column 고용유형코드 : emymtTypCd */
        listColumnDefs.add(new ColumnListDef("고용유형", Psnl0110BM.ATTR_EMYMTTYPCD, ColumnDef.TYPE_STRING, 80, true, true, true ,new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		
        	} 
        });
        sysComBass0300Dto.setMangeItem01("");
        
        
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Psnl0110BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_DATE , 80, true, true, true){
        	
        	{
        		
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
        		setDtFieldMask("9999.99.99");

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Psnl0110BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_DATE , 80, true, true, true){
        	{
        		
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
        		setDtFieldMask("9999.99.99");

        	}
        });
        sysComBass0400Dto.setDeptDspyYn("");
//        sysComBass0400Dto.setDeptCd("");
//        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
        /** column 부서코드 : deptCd */
//        listColumnDefs.add(new ColumnListDef("부서", Payr0250BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, true, true, true,new LookupInfcBass0400Def LookupPrgmComBass0400(sysComBass0400Dto),PrgmComBass0400BM.ATTR_DEPTCD,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT){
        deptCdColumnDef = new ColumnListDef("부서", Psnl0110BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 150, true, true, true,new LookupPrgmComNonBass0400(sysComBass0400Dto),PrgmComBass0400BM.ATTR_DEPTCD,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT){
                           { 
                        	    //TODO 차후 적용후 풆기 
                              // setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
                             //  if (!gwtExtAuth.getReadOnlyDeptCd()) { 
                                   addTrigger(Events.Select, changeValueListenerAdapter);  
                              // }    
                           }
                    };
                            
       listColumnDefs.add(deptCdColumnDef);
       sysComBass0400Dto.setDeptDspyYn("");
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Psnl0110BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 140, false, false, true){
        	{

        	}
        }); 
        
        
//        boolean chkbusinShow = true ;
//        if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
//            chkbusinShow = false;
//        } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//            chkbusinShow = true;
//        } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
//            chkbusinShow = true;
//        } else {
//            chkbusinShow = true;
//        }
        
        /** column 사업코드 : businCd */
        Date today = new Date(); 
        // A custom date format
        DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");  
        sysComBass0500Dto.setBusinApptnYr(fmt.format(today));
        sysComBass0500Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());  //gwtExtAuth.getReadOnlyBusinCd()
        businCdColumnDef = new ColumnListDef("사업", Psnl0110BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 130, false, true, true,new LookupPrgmComBass0500(sysComBass0500Dto),PrgmComBass0500BM.ATTR_BUSINCD,PrgmComBass0500BM.ATTR_BUSINNM, true)
        {{
           
        }};
        
        listColumnDefs.add(businCdColumnDef);
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Psnl0110BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
        /** column 현근무지명 : currPaeWorkNm */
        listColumnDefs.add(new ColumnDef("현근무지", Psnl0110BM.ATTR_CURRPAEWORKNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        
        sysComBass0300Dto.setRpsttvCd("A015"); 
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnListDef("직 책", Psnl0110BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING, 70, true, true, true ,new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		
        	} 
        });
        
        /** column 퇴직사유내용 : retryReasCtnt */
        listColumnDefs.add(new ColumnDef("퇴직사유내용", Psnl0110BM.ATTR_RETRYREASCTNT, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 퇴직이직사유구분코드 : retryDivCd */
        listColumnDefs.add(new ColumnDef("퇴직이직사유구분코드", Psnl0110BM.ATTR_RETRYDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 고용사유내용 : emymtReasCtnt */
        listColumnDefs.add(new ColumnDef("비고", Psnl0110BM.ATTR_EMYMTREASCTNT, ColumnDef.TYPE_STRING , 130, true, true, true){
        	{

        	}
        });
        
        
        
        //---
        
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0110BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0110BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용일련번호 : emymtSeilNum */
        listColumnDefs.add(new ColumnDef("고용일련번호", Psnl0110BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Psnl0110BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용유형코드 : emymtTypCd */
        listColumnDefs.add(new ColumnDef("고용유형코드", Psnl0110BM.ATTR_EMYMTTYPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
     
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Psnl0110BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Psnl0110BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Psnl0110BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Psnl0110BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Psnl0110BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여지급구분코드 : payPymtDivCd */
        listColumnDefs.add(new ColumnDef("급여지급구분코드", Psnl0110BM.ATTR_PAYPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용금액 : emymtSum */
        listColumnDefs.add(new ColumnDef("고용금액", Psnl0110BM.ATTR_EMYMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });

        /** column 증번호 : certNumHuhd */
        listColumnDefs.add(new ColumnDef("증번호", Psnl0110BM.ATTR_CERTNUMHUHD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 경감시작일자 : rducBgnnDt */
        listColumnDefs.add(new ColumnDef("경감시작일자", Psnl0110BM.ATTR_RDUCBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Psnl0110BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Psnl0110BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Psnl0110BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Psnl0110BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Psnl0110BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Psnl0110BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 경감종료일자 : rducEndDt */
        listColumnDefs.add(new ColumnDef("경감종료일자", Psnl0110BM.ATTR_RDUCENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl0110BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종통합코드", Psnl0110BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 환산비율구분코드 : cvsnRtoDivCd */
        listColumnDefs.add(new ColumnDef("환산비율구분코드", Psnl0110BM.ATTR_CVSNRTODIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수 : dutyYrNum */
        listColumnDefs.add(new ColumnDef("근속년수", Psnl0110BM.ATTR_DUTYYRNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수 : dutyMnthIcm */
        listColumnDefs.add(new ColumnDef("근속월수", Psnl0110BM.ATTR_DUTYMNTHICM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속일수 : dutyDayNum */
        listColumnDefs.add(new ColumnDef("근속일수", Psnl0110BM.ATTR_DUTYDAYNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 근속전체일수 : dutyTotDayNum */
        listColumnDefs.add(new ColumnDef("근속전체일수", Psnl0110BM.ATTR_DUTYTOTDAYNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        
        
        
        
        
        return listColumnDefs;
    }
}