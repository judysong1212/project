package com.app.exterms.yearendtax.client.form.yeta2016;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3000DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3150DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3220BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3220DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta2000Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta3000Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta3150Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta3220Def;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1300Service;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1300ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaComboUtils;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Yeta1300 extends MSFPanel {

	private VerticalPanel vp;
	private FormPanel plFrmYeta1300;
	private String txtForm = "";
	private XTemplate detailTp;
	public FormBinding formBinding;

	private GridCellRenderer<Stock> gridNumber;
	private GridCellRenderer<Stock> change;
	
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  // 초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
	
	// -------------- 탭 시작 --------------
	private TabPanel tabsYeta1300 = new TabPanel();		// 전체
	private TabPanel tabsItemYeta05 = new TabPanel();	// 특별소득공제 하위
	private TabPanel tabsItemYeta08 = new TabPanel();	// 세액감면및세액공제1 하위
	// -------------- 탭 종료 --------------

	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topYeta1300Bar;
	private Button btnYeta1300Reset; 	// 초기화
	private Button btnYeta1300New; 		// 신규
	private Button btnYeta1300Save; 	// 저장
	private Button btnYeta1300Del; 		// 삭제
	private Button btnYeta1300Sreach; 	// 조회
	private Button btnYeta1300Print; 	// 인쇄
	
	private RadioGroup printType;		// 대상자 선택
	// -------------- 상단 버튼 종료 --------------

	// -------------- 중간 버튼 시작 --------------
	private Button btnYeta1300_01;			// 의료비지급명세서
	private Button btnYeta1300_02; 			// 기부금명세서
	private Button btnYeta1300_03; 			// 재계산대상자
	private Button btnYeta1300_04; 			// 삭제
	private Button btnYeta1300_05; 			// 세액계산
	private Button btnYeta1300_06; 			// 세액재계산
	private Button btnYeta1300_07; 			// 원천징수인쇄
	private ComboBox<BaseModel> issueMethod;// 발행방법
	private CheckBoxGroup juminCk;			// 주민번호 보이기 여부
	// -------------- 중간 버튼 종료 --------------

	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private Ye16Ta1005DTO ye16Ta1005Dto;
	
	private Ye16Ta2000DTO yeta2000Dto;
	private Ye16Ta3000DTO yeta13000Dto;
	private Ye16Ta2000BM yeta2000Bm;
	// -------------- DTO 선언 종료 --------------
	
	// -------------- grid 선언 시작  ---------------
//	private Yeta1300Def yeta1300Def_01  = new Yeta1300Def("YETA03001");	//대상자 정보 그리드 테이블 컬럼 define  
//	private Yeta1300Def yeta1300Def_02  = new Yeta1300Def("YETA03002");	//세액계산 정보 그리드 테이블 컬럼 define 
//	private Yeta1300Def yeta1300Def_03  = new Yeta1300Def("YETA03003");	//인적공제 정보 그리드 테이블 컬럼 define
//	private Yeta1300Def yeta1300Def_04  = new Yeta1300Def("YETA03004"); //소득공제명세 그리드 테이블 컬럼 define(합계) 
//	private Yeta1300Def yeta1300Def_04_01  = new Yeta1300Def("YETA03004_01"); //소득공제명세 그리드 테이블 컬럼 define(국세청자료) 
//	private Yeta1300Def yeta1300Def_04_02  = new Yeta1300Def("YETA03004_02"); //소득공제명세 그리드 테이블 컬럼 define(기타자료)
//	private Yeta1300Def yeta1300Def_05  = new Yeta1300Def("YETA03005");	//가족교육비 그리드 테이블 컬럼 define 
	
	private Ye16Ta2000Def Ye16Ta2000Def_01 		= new Ye16Ta2000Def("YETA1300"); 	//대상자 정보 그리드 테이블 컬럼 define
//	private Ye16Ta2000Def Ye16Ta2000Def_02  	= new Ye16Ta2000Def("YETA200001"); 		//대상자 정보 그리드 새로고침을 위한 define
	private Ye16Ta3000Def yeta13000Def_01  		= new Ye16Ta3000Def("YETA300001");	//세액계산 정보 그리드 테이블 컬럼 define 
	
	private Ye16Ta3220Def Yeta3220Def_01  		= new Ye16Ta3220Def("YETA322001");	//인적공제 정보 그리드 테이블 컬럼 define
	private Ye16Ta3220Def Yeta3220Def_02_SUM  	= new Ye16Ta3220Def("YETA322002"); 	//소득공제명세 그리드 테이블 컬럼 define(합계) 
	private Ye16Ta3220Def Yeta3220Def_02_01  	= new Ye16Ta3220Def("YETA322003"); 	//소득공제명세 그리드 테이블 컬럼 define(국세청자료)  
	private Ye16Ta3220Def Yeta3220Def_02_02  	= new Ye16Ta3220Def("YETA322004"); 	//소득공제명세 그리드 테이블 컬럼 define(기타자료)
	private Ye16Ta3150Def Yeta3150Def_01  		= new Ye16Ta3150Def("YETA315001");	//가족교육비 그리드 테이블 컬럼 define 
	
	
	private MSFGridPanel yeta1300GridPanel;
	private MSFGridPanel yeta1300ToYe16Ta2000GridPanel;	//대상자정보 GridPanel
//	private MSFGridPanel yeta1300ToYe16Ta2000GridPanel2;	//대상자정보 GridPanel
	private MSFGridPanel yeta1300ToYeta3220GridPanel1;	//인적공제 GridPanel
	private MSFGridPanel yeta1300ToYeta3220GridPanel2;	//소득공제 - 국세청 GridPanel
	private MSFGridPanel yeta1300ToYeta3220GridPanel3;	//소득공제 - 기타자료 GridPanel
	private MSFGridPanel yeta1300ToYeta3220GridPanel4;	//소득공제 - 합계 GridPanel
	private MSFGridPanel yeta1300ToYeta3150GridPanel;	//가족교육비 GridPanel
	// -------------- grid 선언 종료  ---------------
	
	//직종콤보
//	private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	private MSFGridPanel typOccuCdGridPanel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 검색 조건 시작 --------------
	private ComboBox<BaseModel> srhEdacRvyy;				//정산년
	private ComboBox<BaseModel> srhSettGbcd; 				//정산구분 
	private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드 
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			//단위기관
	private MSFMultiComboBox<ModelData> srhDeptCd; 			//부서
	private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	     
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
	private ComboBox<BaseModel> srhBusinCd; 				//사업
	private TextField<String> srhHanNm; 					//성명
	private TextField<String> srhResnRegnNum; 				//주민번호
	private HiddenField<String> srhSystemkey; 				//시스템키
	
	private ComboBox<BaseModel> srhYetaDpcd; 				// 원천신고부서
	private ComboBox<BaseModel> srhBusoprRgstnum; 			// 사업자등록번호

	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;

	private boolean mutilCombo = false;
	
	
	private HiddenField<String> edacRvyy;	/** column 연말정산귀속년도 : edacRvyy */
	private HiddenField<String> settGbcd;	/** column 정산구분코드 : settGbcd */
	private HiddenField<String> systemkey;  /**  column SYSTEMKEY : systemkey */
	private HiddenField<String>	 dpobCd;	/**  column 사업장코드 : dpobCd */
	private HiddenField<String>	 hanNm;		/**  column 사업장코드 : dpobCd */
	private HiddenField<String>	 deptNm;	/**  column 사업장코드 : dpobCd */
    private HiddenField<Long> edacSeilNum;	/** set 연말정산마감일련번호 : edacSeilNum */
//    private HiddenField<String> clutYrMnth;   	/** column 정산년월 : clutYrMnth */
//    private HiddenField<String> pyspGrdeCd;   	/** column 호봉등급코드 : pyspGrdeCd */
	// -------------- 검색 조건 종료 --------------
	
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 상태처리 전역변수
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
    private ActionDatabase actionDatabase;   
    

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */    
    
    // -------------- 기본 사항 시작 --------------
    
    //-- 기본사항  
    private RadioGroup gnanSgtf;			//세대주여부
    
    private HiddenField<String> natnGbcd;	//국적코드
    private TextField<String> natnName;		//국적명
    private TextField<String> natnItem; 	//국적코드 두자리
    
    private MSFDateField reymStdt;			//근무 시작 일자
    private MSFDateField reymEddt;			//근무 종료 일자
    
    private MSFDateField rutrStdt;			//감면 시작 일자 
    private MSFDateField rutrEddt;			//감면 종료 일자
    
    private RadioGroup resdFlag;			//거주구분여부
    
    private HiddenField<String> redtGbcd;	//거주지국코드
    private TextField<String> redtName;		//거주지국명
    private TextField<String> redtItem; 	//거주지국 두자리
    	
    private MSFNumberField dcsnTots;		  	//종근무지_급여총액
    private MSFNumberField currTots;			//주근무지_급여총액
    private MSFNumberField totlSala;			//총급여_현_전
    	
    private MSFNumberField wkerDdct;			//근로소득공제
    private MSFNumberField wkerAmnt;			//근로소득금액
    private MSFNumberField taxdWken;			//세액공제_근로소득세액공제
    	
    private MSFNumberField  stndIncm; //과세표준  
    private MSFNumberField  prddTaxn; //산출세액 
    private MSFNumberField dcsnItax;			//결정세액_소득세
    private MSFNumberField dcsnBtax;			//결정세액_주민세_지방소득세
    	
    private MSFNumberField alryPinx;		//기납부세액_소득세
    private MSFNumberField alryPhbx;		//기납부세액_주민세_지방소득세
    // -------------- 기본 사항 종료 --------------
    
    
    
    // -------------- 인적 공제 시작 --------------
    private RadioGroup humnCgue;		//인적공제항목변동여부
    Radio humnCgue0;
    Radio humnCgue1;
    private MSFNumberField addrMrct;		//추가공제_다자녀인원수
    private MSFNumberField addrMccr;		//세액공제_자녀세액공제금액
//    private HiddenField<String> beforeJumin;	//수정전 주민등록번호
    
//    private List<Ye16Ta3220DTO> beforeJumin = new ArrayList<Ye16Ta3220DTO>();  
    // -------------- 인적 공제 종료 --------------
    
    
    // -------------- 연금보험료 공제 시작 --------------
    //--국민보험료
    private MSFNumberField bnatPsnf;		//종근무지_국민연금보험료
    private MSFNumberField jnatPsnf;	//주근무지_국민연금보험료
    private MSFNumberField bnatDdct;		//종근무지_국민연금보험료공제
    private MSFNumberField jnatDdct;		//주근무지_국민연금보험료공제

    //--국민연금보험료외의 연금보험료
    private MSFNumberField bpssPulc;		//종근무지_국민연금외공무원연금
    private MSFNumberField jpssPulc;	//주근무지_국민연금외공무원연금
   
    private MSFNumberField bpssSold;		//종근무지_국민연금외군인연금
    private MSFNumberField jpssSold;	//주근무지_국민연금외군인연금
    
    private MSFNumberField bpssTech;		//종근무지_국인연금외교직원연금
    private MSFNumberField jpssTech;	//주근무지_국인연금외교직원연금
    
    private MSFNumberField bpssFect;		//종근무지_국민연금외별정우체국
    private MSFNumberField jpssFect;	//주근무지_국민연금외별정우체국

    private MSFNumberField bpssHpul;		//종근무지_국민연금외공무원연금공제
    private MSFNumberField jpssHpul;		//주근무지_공무원연금보험료공제

    private MSFNumberField bpssHsol;		//종근무지_국민연금외군인연금공제
    private MSFNumberField jpssHsol;		//주근무지_국민연금외군인연금공제

    private MSFNumberField bpssHtec;		//종근무지_국민연금외교직원연금공제
    private MSFNumberField jpssHtec;		//주근무지_국민연금외교직원연금공제

    private MSFNumberField bpssDdct;		//종근무지_별정우체국연금보험료공제
    private MSFNumberField jpssDdct;		//주근무지_별정우체국연금보험료공제
    
    private MSFNumberField rrptAmnt;		//연금보험료계
    private MSFNumberField rrptYnam;		//연금보험료공제계
    // -------------- 연금보험료 공제 종료 --------------
    
    
    
    // -------------- 특별 소득 공제 시작 --------------
    // -- 보험료
    private MSFNumberField spciBhlh;		//특별공제_종건강보험료
    private MSFNumberField spciHhlh;		//특별공제_주건강보험료
    private MSFNumberField spciBhth;		//특별공제_종건강보험료 공제액
    private MSFNumberField spciJhth;		//특별공제_주건강보험료 공제액
    	
    private MSFNumberField spciBepf;		//특별공제_종고용보험료
    private MSFNumberField spciJepf;		//특별공제_주고용보험료

    private MSFNumberField spciBepf01;		//특별공제_종고용보험료 공제액
    private MSFNumberField spciJepf01;		//특별공제_주고용보험료 공제액
    	
    private MSFNumberField spciIuam;		//특별공제_보험료계
    private MSFNumberField spciHrto;		//특별공제_보험료계

    // -- 주택자금
    private MSFNumberField spciRefn;		//특별공제_차입금원리금상환액_대출기관
    private MSFNumberField spciResf;		//특별공제_차입금원리금상환액_거주자
    	
    private MSFNumberField spciRefn01;		//특별공제_차입금원리금상환액_대출기관 공제액
    private MSFNumberField spciResf01;		//특별공제_차입금원리금상환액_거주자 공제액
    	
    private MSFNumberField spciHtam;	//특별공제_주택자금_월세금액
    private MSFNumberField spciRtam;		//특별공제_주택자금월세공제액
    
    private MSFNumberField spchRe06;	//특별공제_11장기주택저당차입금15
    private MSFNumberField spchRe10;	//특별공제_11장기주택저당차입금29
    private MSFNumberField spchRe20;	//특별공제_11장기주택저당차입금30
    
    private MSFNumberField spchRefx;	//특별공제_12장기주택저당차입금_고정
    private MSFNumberField spchReec;	//특별공제_12장기주택저당차입금_기타
    	
    private MSFNumberField spchRefx01;		//특별공제_12장기주택저당차입금_고정  공제액
    private MSFNumberField spchReec01;		//특별공제_12장기주택저당차입금_기타  공제액

    private MSFNumberField spchRe15;		//특별공제_11장기주택저당차입금15 공제액
    private MSFNumberField spchRe29;		//특별공제_11장기주택저당차입금29 공제액
    private MSFNumberField spchRe30;		//특별공제_11장기주택저당차입금30 공제액
    	
    private MSFNumberField spch15fx;	//특별공제_15장기주택저당_15고정AND비거치상환
    private MSFNumberField spch15fb;	//특별공제_15장기주택저당_15고정OR비거치상환
    private MSFNumberField spch15ec;	//특별공제_15장기주택저당_15기타대출
    private MSFNumberField spch10fb;		//특별공제_15장기주택저당_10고정OR비거치상환
    	
    private MSFNumberField spci15fx;		//특별공제_15장기주택저당_15고정AND비거치상환 공제액
    private MSFNumberField spci15fb;		//특별공제_15장기주택저당_15고정OR비거치상환 공제액
    private MSFNumberField spci15ec;		//특별공제_15장기주택저당_15기타대출 공제액
    private MSFNumberField spci10fb;		//특별공제_15장기주택저당_10고정OR비거치상환 공제액
    	
    private MSFNumberField spchReto;		//특별공제_주택자금공제액계
    // -------------- 특별 소득 공제 종료 --------------
    
    // -------------- 그밖의 소득 공제1 시작 --------------
    private MSFNumberField prvm20be;	//개인연금저축불입액_2000년이전
    private MSFNumberField etcpPsnv;		//개인연금저축불입액_2000년이전
    
    private MSFNumberField etchPrep;	//기타공제_소기업공제불입금액
    private MSFNumberField etchPrep01;		//기타공제_소기업공제불입금 공제액
    	
    private MSFNumberField etcsComp;	//기타공제_주택마련저축_청약저축
    private MSFNumberField etwkHsbm;	//기타공제_주택마련저축_주택청약종합저축
    private MSFNumberField etwkHsvm;	//기타공제_주택마련저축_근로자주택마련저축
    private MSFNumberField etwkHbdm;	//기타공제_주택마련저축소득금액
    	
    private MSFNumberField etcsComp01;		//기타공제_주택마련저축_청약저축 공제액
    private MSFNumberField etwkSbam;		//기타공제_주택마련저축_주택청약종합저축 공제액
    private MSFNumberField etwkSvam;		//기타공제_주택마련저축_근로자주택마련저축 공제액
    private MSFNumberField etwkBdam;		//기타공제_주택마련저축소득공제계
    	

    private MSFNumberField etgdH14f;	//기타공제_투자조합출자금액_2014년도
    private MSFNumberField etclH15f;	//기타공제_투자조합출자금액_2015년이후
    private MSFNumberField etgdHdam;		//기타공제투자조합출자금액계
    	

    private MSFNumberField etgdD14f;		//기타공제_투자조합출자소득공제_2014년
    private MSFNumberField etgdD15f;		//기타공제_투자조합출자소득공제_2015년이후
    private MSFNumberField etgdDdam;		//기타공제_투자조합출자공제액계
    	
    private MSFNumberField etctCard;		//기타공제_신용카드등사용금액
    private MSFNumberField etchBcbs;		//기타공제_직불카드등사용금액
    private MSFNumberField etchUeam;		//기타공제_현금영수증사용금액
    private MSFNumberField etchMgvd;		//기타공제_전통시장사용분
    private MSFNumberField etchBced;		//기타공제_지로납부_대중교통금액
    private MSFNumberField etchBcue;		//기타공제_신용카드등사용금액계
    private MSFNumberField etccCard;		//기타공제_신용카드등사용공제계
    

    private MSFNumberField cardEt14;	//기타공제_본인신용카드등사용액_2014
    private MSFNumberField cardEt15;	//기타공제_본인신용카등사용액_2015
    
 
    private MSFNumberField etadD14l;	//기타공제_본인추가공제율사용액_2014하
    

    // -------------- 그밖의 소득 공제1 종료 --------------
    
    // -------------- 그밖의 소득 공제2 시작 --------------
    private MSFNumberField etckUnon;	//기타공제_우리사주출연금액
    private MSFNumberField etckUncb;	//기타공제_우리사주조합기부금2014이전
    private MSFNumberField etepHsam;	//기타공제_고용유지중소기업근로자임금삭감액
    private MSFNumberField etgdCtra;	//기타공제_목돈안드는전세이자상환금액
    private MSFNumberField etepSest;	//기타공제_장기집합투자증권저축금액
    

    private MSFNumberField etckUnon01;		//기타공제_우리사주출연금공제 공제액
    private MSFNumberField etckUncr;		//기타공제_우리사주조합기부금공제2014이전 공제액
    private MSFNumberField etepMsam;		//기타공제_고용유지중소기업근로자임금삭감공제액
    private MSFNumberField etgdHtra;		//기타공제_목돈안드는전세이자상환소득공제액
    private MSFNumberField etepSecr;		//기타공제_장기집합투자증권저축공제액
    // -------------- 그밖의 소득 공제2 종료 --------------
    
    
    // -------------- 세액감면및세액공제1 시작 --------------
    //--연금계좌및보험료
    private MSFNumberField jrtrCict;	//주근무지_퇴직연금과학기술인공제
    private MSFNumberField jrtrCtar;//주근무지_퇴직연금과학기술인공제대상금액
    private MSFNumberField jrtrHict;	//주근무지_퇴직연금과학기술인공제액
    	
    private MSFNumberField jrtrPsct;	//주근무지_퇴직연금근로자퇴직급여보장법
    private MSFNumberField jrtrPtar;//주근무지_퇴직연금근로자퇴직급여보장대상금액
    private MSFNumberField jrtrPsrn;	//주근무지_퇴직연금근로자퇴직급여보장법공제액
    	
    private MSFNumberField jrtrAnsv;	//주근무지_연금계좌_연금저축
    private MSFNumberField jrtrAtar;//주근무지_연금계좌저축공제대상금액
    private MSFNumberField jrtrHnsv;	//주근무지_퇴직연금연금계좌저축공제
    	
    private MSFNumberField jrtrAtom;	//연금계좌계
    private MSFNumberField jrtrTotr;	//연금계좌공제대상금액
    private MSFNumberField jrtrHnto;	//연금계좌세액공제계
    	
    private MSFNumberField spciGurt;//특별공제_일반보장성보험료
    private MSFNumberField spciRttg;	//특별공제_일반보장성보험료 공제대상금액
    private MSFNumberField spciGurt01;	//특별공제_일반보장성보험료 공제액
    
    
    private MSFNumberField spciHdrc;//특별공제_장애인전용보험료
    private MSFNumberField spciHdtg;	//특별공제_장애인보장성대상금액
    private MSFNumberField spciHdrc01; //특별공제_장애인보장성대상금액 공제액
    	
    private MSFNumberField spciRtto;	//특별공제_보장성보험료계
    private MSFNumberField spciDetg;	//특별공제_보장성보험료대상금액
    private MSFNumberField spciRtde;	//특별공제_보장성보혐료세액공제금액

    //--의료비
    private MSFNumberField spciSelf;	//특별공제_의료비_본인
    private MSFNumberField spciSftg;	//본인의료비공제대상금액
    private MSFNumberField spciSelf01;	//본인 의료비 세액공제
    	
    private MSFNumberField spciAe65;	//특별공제_의료비_경로65세이상
   	private MSFNumberField spci65tg;	//65세이상자의료비공제대상금액
    private MSFNumberField spciHe65;	//특별공제_의료비_경로65세이상
    	
    private MSFNumberField spciDbps;	//특별공제_의료비_장애인
    private MSFNumberField spciPstg;	//장애인의료비공제대상금액
    private MSFNumberField spciHbps;	//특별공제_의료비_장애인 공제액
    
    private MSFNumberField spciEtcg;	//그밖의의료비공제대상금액
    private MSFNumberField spciDetc;	//특별공제_의료비_기타공제대상자
    private MSFNumberField spciDetc01;	//특별공제_의료비_기타공제대상자 공제액
    	
    private MSFNumberField spciEtam;	//특별공제_의료비계
    private MSFNumberField spciDtar;	//특별공제_의료비세액공제대상금액
    private MSFNumberField spciTxcr;	//특별공제_의료비세액공제액
     

    //--교육비
    private MSFNumberField spedSelf;//특별공제_교육비_본인
    private MSFNumberField spedSftr;	//소득자본인교육비대상금액
    private MSFNumberField spedSelf01;	//특별공제_교육비_본인 공제액
    	
    private MSFNumberField spedEdsu;	//특별공제_교육비_취학전아동수
    private MSFNumberField spedEdam;	//특별공제_교육비_취학전아동
    private MSFNumberField spedGrde;	//특별공제_교육비_취학전아동 공제액
    	
    private MSFNumberField spedGdsu;	//특별공제_교육비_초중고자녀수
    private MSFNumberField spedGdam;	//특별공제_교육비_초중고
    private MSFNumberField spedGdto;	//특별공제_교육비_초중고 공제액
    	
    private MSFNumberField spedCvsu;	//특별공제_교육비_대학생수
    private MSFNumberField spedCvam;	//특별공제_교육비_대학교
    private MSFNumberField spedCldv;	//특별공제_교육비_대학교
    	
    private MSFNumberField spciSctr;	//특별공제_장애인수
    private MSFNumberField spciScam;	//특별공제_장애인특수교육비
    private MSFNumberField spciSpec;	//특별공제_장애인특수교육비
    	
    private MSFNumberField siedToam;	//특별공제_교육비계
    private MSFNumberField spedEtar;	//특별공제_교육비공제대상금액
    private MSFNumberField spedTxcr;	//특별공제_교육비세액공제금액
    
     
    //--   기부금 재조정  ....
    private MSFNumberField taxdPltc;	//세액공제_기부정치자금금액 10만원이하 
    private MSFNumberField taxd10tg;	//특별공제_기부정치자금_10이하대상금액
    private MSFNumberField taxdPltc01;	//세액공제_기부정치자금 공제세액  
    
   private MSFNumberField spciPltc;	//특별공제_기부금_정치	
   private MSFNumberField spciPltg;	//특별공제_기부금_정치10초과대상금액	
   private MSFNumberField spciPltc01;	//특별공제_기부금_정치 공제세액
    
   private MSFNumberField spciFbam;	//특별공제_기부금_법정	
   private MSFNumberField spciFbtg;	//특별공제_기부금_법정 대상금액	
   private MSFNumberField spciFbam01;	//특별공제_기부금_법정 공제세액
   
   private MSFNumberField spciExam;	//특별공제_기부금_특례_공익법인신탁제외	
   private MSFNumberField spciExtg;	//특례기부금_공익법인제외대상금액	
   private MSFNumberField spciExam01;	//특별공제_기부금_특례_공익법인신탁제외	공제새액
   

   private MSFNumberField spciHfam;	//특별공제_기부금_우리사주조합2015이후	
   private MSFNumberField spciHftg;	//우리사주종합기부대상금액	
   private MSFNumberField spciRfam;	//특별공제_기부금_우리사주조합2015이후
    
   private MSFNumberField spciNamt;	//특별공제_기부금_종교단체외	
   private MSFNumberField spciNatg;	//종교단체외지정대상금액	
   private MSFNumberField spciNamt01;	//특별공제_기부금_종교단체외	   
    
   private MSFNumberField spciYamt;	//특별공제_기부금_종교단체	
   private MSFNumberField spciYatg;	//종교단체지정대상금액	
   private MSFNumberField spciYamt01;	//특별공제_기부금_종교단체	
   		 

   private MSFNumberField spciDgam;	//기부금합계금액	
   private MSFNumberField spciDgtg;	//기부금 공제대상계	 
   private MSFNumberField spciDgcr;	//기부금 세액공제계	
 
   
   private MSFNumberField spciObam;	//이월법정기부금액
   private MSFNumberField spciOyam;	//이월종교단체기부금
   private MSFNumberField spciOnam;	//이월종교단체외기부금
   

   
   private MSFNumberField spciObam01;	//이월법정기부금액_공제액
   private MSFNumberField spciOyam01;	//이월종교단체기부금_공제액
   private MSFNumberField spciOnam01;	//이월종교단체외기부금_공제액

   private MSFNumberField spciSsum;	//기부금(이월분)	
   // -------------- 세액감면및세액공제1 종료 --------------
   
    // -------------- 세액감면및세액공제2 시작 --------------
    private CheckBoxGroup taxdIncd;		//세액공제_외국인_입국목적코드
    private CheckBox taxdIncd1;
    private CheckBox taxdIncd2;
    private CheckBox taxdIncd3;
    private CheckBox taxdIncd4;
    private MSFDateField taxdWkdt;		//세액공제_외국인_근로제공일자
    private MSFDateField tamaEddt;		//세액공제_외국인_감면기간만료일자
    private MSFDateField tamaIndt;		//세액공제_외국인_감면신청접수일자
    private MSFDateField tamaOudt;		//세액공제_외국인_감면신청제출일자
    private MSFDateField txlgFrrd;		//세액공제_외국인해저광물개발감면확인일자
    private MSFDateField txlgFrid;		//세액공제_외국인해저광물개발감면신청일자
    private MSFDateField txlgWkid;		//세액공제_근로소득조세조약상면제접수일자
    private MSFDateField txlgTxtd;		//세액공제_근로소득조세조약상면제제출일자
    	
    private MSFDateField txlgBscd;		//세액공제_중소기업청년감면취업일자
    private MSFDateField txlgBcde;		//세액공제_중소기업청년감면종료일자
    	
    private MSFNumberField txlgItct;	//세액감면_소득세법감면세액
    private MSFNumberField taxdIcax;	//세액감면_소득세법
    	
    private MSFNumberField txlgBsta;	//세액감면_취업청년감면대상총급여액
    private MSFNumberField txlgWkta;		//세액감면_취업청년감면근로자총급여액
    	
    private MSFNumberField txlgClta;		//세액감면_계산감면세액금액
    private MSFNumberField taxdTsum;		//세액감면_감면세액계
    	
    private MSFNumberField txlgFrta;	//세액감면_외국인기술자감면세액
    private MSFNumberField taxdRedu;		//세액공제_외국인감면세액
    	
    private MSFNumberField txlgTxty;	//세액감면_조세조약감면세액
    private MSFNumberField txlgHxtt;		//세액감면_조세조약
    	
    private MSFNumberField txlgInam;	//세액공제_외국납부_국외원천소득금액
    private MSFNumberField txlgDlam;	//세액공제_외국납부_외화납세액
    private MSFNumberField txlgWnam;	//세액공제_외국납부_원화납세액
    private MSFTextField txlgOtcy;		//세액공제_외국납부_납세국명
    private MSFDateField txlgOtdt;		//세액공제_외국납부_납부일자
    private MSFDateField txlgApdt;		//세액공제_외국납부_신청서제출일자
    private MSFTextField txlgOuwk;		//세액공제_외국납부_국외근무처명
    private MSFTextField txapWkdy;		//세액공제_외국납부_직책
    private MSFDateField txapStdt;		//세액공제_외국납부_근무시작일자
    private MSFDateField txapEddt;		//세액공제_외국납부_근무종료일자
    
    private MSFNumberField taxdUnin;	//세액공제_납세조합공제
    private MSFNumberField taxdUnin01;		//세액공제_납세조합공제
    	
    private MSFNumberField taxdLoaa;	//세액공제_주택차입금이자상황금액
    private MSFNumberField taxdLoan;		//세액공제_주택차입금
    
    // -------------- 세액감면및세액공제2 종료 --------------
    
    private    boolean statCheck = false ;
    
    // -------------- 추가제출서류 시작 --------------
    private RadioGroup frnrSgyn;	//1.외국인근로자 단말세율적용신청서 제출여부
    private RadioGroup addcNtyn;	//2.연금, 저축 등 소득공제 명세서 제출 여부
    private RadioGroup spciReyn;	//3.월세액.비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부
    
    private RadioGroup addcMdyn;	//의료비지급 명세서
    private RadioGroup addcCtyn;	//기부금 명세서
    private RadioGroup addcPfyn;	//소득공제 증빙서류
    private RadioGroup incoOufg;	//소득공제신고서제출여부
    private MSFDateField incoOudt;	//소득공제신고서제출여부_제출일자
    // -------------- 추가제출서류 종료 --------------
    
    
    
  //-------------------2016년 귀속 추가 부분 ---------------------------------------------------  

    private CheckBox yrenSgyn;   /** column 연말정산분할납부신청여부 : yrenSgyn */

    private ComboBox<BaseModel>  addIncmTxApptnRtoCd;   /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */

    private  CheckBox  frnrRnyn;   /** column 외국인법인소속파견근로자여부 : frnrRnyn */

    private MSFNumberField etgdH14b;   /** column 기타공제_투자조합출자금액_14_벤처 : etgdH14b */

    private MSFNumberField etclH15b;   /** column 기타공제_투자조합출자금액_15_벤처 : etclH15b */

    private MSFNumberField etclH16f;   /** column 기타공제_투자조합출자금액_16_조합 : etclH16f */

    private MSFNumberField etclH16b;   /** column 기타공제_투자조합출자금액_16_벤처 : etclH16b */

    private MSFNumberField etadD16l;   /** column 기타공제_본인추가공제율사용액_2016상 : etadD16l */

    private ComboBox<BaseModel> yetaDpcd;   /** column 원천징수의무부서코드 : yetaDpcd */
    
   // private TextField<String> tempPrddTaxn;   /** column null : tempPrddTaxn */

    private MSFNumberField etgdD14b;   /** column 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */

    private MSFNumberField etgdD15b;   /** column 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */

    private MSFNumberField etgdD16f;   /** column 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */

    private MSFNumberField etgdD16b;   /** column 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
    
 //삭제 필드 
    

//  private MSFNumberField etgdH09f;	//기타공제_투자조합출자금액_2012
//  private MSFNumberField etgdH13f;	//기타공제_투자조합출자금액_2013년도
    //  private NumberField etgd09af;		//기타공제_투자조합출자소득공제_2012년도
    //   private NumberField etgdH13h;		//기타공제_투자조합출자소득공제_2013년도
    //  private MSFNumberField cardEt13;	//기타공제_본인신용카드등사용액_2013
    // private MSFNumberField etadDd13;	//기타공제_본인추가공재율사용액_2013
//    private MSFNumberField etadD15h;	//기타공제_본인추가공제율사용액2015상반기
 //   private MSFNumberField etadD15l;	//기타공제_본인추가공제율사용액2015하반기
    
    //  private MSFTextField etclEttl;		//기타공제_기타제목
    // private MSFNumberField etclEtam;	//기타공제_기타금액
    // private NumberField etcdTsum;		//기타공제_공제계
    
    //-------------------2016년 귀속 추가 부분 ---------------------------------------------------  

    private BaseModel ppRecord; //팝업에 넘길 레코드 값 
	private BaseModel record;
	private Iterator<Record> records;
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Rpc Service 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	// -------------- stroe 선언 시작 --------------
	private ListStore<BaseModel> lsClutYrStore 			= new ListStore<BaseModel>(); 	//년도
	private ListStore<BaseModel> lsClutMnth 			= new ListStore<BaseModel>(); 	//급여월
	private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>(); 	//고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd 				= new ListStore<BaseModel>(); 	//부서콤보
	private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>(); 	//사업콤보
	private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>(); 	//단위기관
	private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드 
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>(); 	//직종
	private ListStore<BaseModel> lsSettGbcd 			= new ListStore<BaseModel>();	//정산구분
	private ListStore<BaseModel> lsPymtDducDivCd 		= new ListStore<BaseModel>(); 	//지급공제구분코드
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>(); 	//직종세
//	private ListStore<BaseModel> lsCrClutYrStore = new ListStore<BaseModel>(); 			//년도
//	private ListStore<BaseModel> lsCrClutMnth = new ListStore<BaseModel>(); 			//급여월
	
	private ListStore<BaseModel> lsAddIncmTxApptnRtoCd 	= new ListStore<BaseModel>(); 	//추가소득세적용비율코드
	
	private ListStore<BaseModel> lsYetaDpcd  			= new ListStore<BaseModel>();	// 원천징수부서코드  
	private ListStore<BaseModel> lsBusoprRgstnum  		= new ListStore<BaseModel>();	// 사업자등록번호  

	// -------------- stroe 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 --------------
	private Yeta1300ServiceAsync yeta1300Service = Yeta1300Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------

	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// detailTp = XTemplate.create(getDetailTemplate());
	//
	// vp = new VerticalPanel();
	// vp.setSpacing(10);
	// createPsnl0100Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createLeftRForm();
	//
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	 private void checkYeta1300Auth( String authAction, ListStore<BaseModel>bm) {
		 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
	
			 if (!maskTracker) { unmask(); } 
			   authExecEnabled() ;
			 
		 }
	 }

	 private void authExecEnabled() { 
	   //------------------
		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * 권한설정을 위한 콤보처리를 위한 메서드 시작
			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
			 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		 //----------------------------------------------------
		 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
		 gwtAuthorization.formAuthFieldConfig(fldArrField);
		  
		 srhEdacRvyy.setValue(lsClutYrStore.findModel("year","2016"));
		 srhSettGbcd.setValue(lsSettGbcd.getAt(0)); 
	 	 addIncmTxApptnRtoCd.setValue(lsAddIncmTxApptnRtoCd.getAt(1));
			
		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
		 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	 }
	 
	 
	   final Timer tmMask = new Timer()
	     {
	           public void run()
	           {
	              // if (maskTracker)
	              // { 
	        	   if (lsEmymtDivCd.getCount() > 0 ) {
	        		   
		           	    cancel();
		               	unmask(); 
		               	authExecEnabled() ;
		                maskTracker  = true;
		        	
		        	   } else {
		        		   tmMask.scheduleRepeating(2000);
		        	   }
	              // }
	           }
	     }; 
	     
	 private void initLoad() {
	
		 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		 gwtAuthorization = GWTAuthorization.getInstance();
		 gwtExtAuth = GWTExtAuth.getInstance();
		
		
		 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
			 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
			 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
			 authMapDef.put("srhDeptCd",Boolean.FALSE);
			 // authMapDef.put("srhTypOccuCd",Boolean.FALSE);
		
		 gwtExtAuth.setCheckMapDef(authMapDef);
		
		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			 //권한 검색조건처리를 위해 추가된 부분
			 mask("[화면로딩] 초기화 진행 중!");
		 }	
		 tmMask.scheduleRepeating(5000);
	 }
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 :연말 정산 대상자 세액 계산  
	  * 2. 처리내용 : 선택된 연말정산 대상자의 세액계산  
	  * </pre>
	  * @Method Name : fnYeta1300Payr06430CalcTax
	  * @date : Jan 26, 2016
	  * @author : leeheuisung
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	Jan 26, 2016		leeheuisung				최초 작성 
	  *	-----------------------------------------------------------------------
	  *
	  */
	 private void fnYeta1300Payr06430CalcTax() { 

   	  MessageBox.confirm("세액계산", "선택된 연말정산계산  대상자에 대해서 세액계산을 합니다. <br> 세액재계산을 하시겠습니까?",new Listener<MessageBoxEvent>(){
   	      @Override
   	       public void handleEvent(MessageBoxEvent be) {
   	          // if("Yes".equals(be.getButtonClicked().getText())){
   	    	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
   	       
   	        	 	     Iterator<BaseModel> itBm  = yeta1300ToYe16Ta2000GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				          
				          List<Record>  lsRec  = new ArrayList<Record>();
				          
				          while(itBm.hasNext()) {
				
				              Record rec  = new Record(itBm.next()); 
				              lsRec.add(rec);
				              
				          } 
				           setListRecord(lsRec.iterator()); 
           	
	  
//          	        	String pymtYrMnth =  MSFSharedUtils.getSelectedComboValue(clutYr,"year") + MSFSharedUtils.getSelectedComboValue(clutMnth,"month");
//          	        	if (MSFSharedUtils.paramNull(pymtYrMnth)) {
//          	        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//          		                        "대상자를 선택하시려면 정산년월을 선택하셔야 합니다.", null);
//          	        		return;
//          	        	}
//              	     	if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"))) {
//              	     	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//        	                            "대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
//          	        		return;
//          	        	}
              	     	
              	     	
				           if (MSFSharedUtils.paramNotNull(records)) {    
				        	   
				        	   final Tracker tracker = new Tracker();
		    					tracker.setStatus(false);
		    					
			                	  List<Ye16Ta2000DTO> listYe16Ta2000Dto = new ArrayList<Ye16Ta2000DTO>();  
		       	               
		       	               while (records.hasNext()) {
		       	             
		       	                  Record record = (Record) records.next(); 
		       	                  BaseModel bmMapModel = (BaseModel)record.getModel();
		       	                     
		       	                  Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO();    

									yeta2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
									yeta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
									yeta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
									yeta2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
									yeta2000Dto.setEdacSeilNum((Long)bmMapModel.get("edacSeilNum"));    /** column 연말정산마감일련번호 : edacSeilNum */
									yeta2000Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
									yeta2000Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
									yeta2000Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    /** column 한글성명 : hanNm */
									yeta2000Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
									yeta2000Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
									yeta2000Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
									yeta2000Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
									yeta2000Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
									yeta2000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
									yeta2000Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    /** column 직책코드 : odtyCd */
									yeta2000Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    /** column 호봉코드 : pyspCd */
									yeta2000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
									yeta2000Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
									yeta2000Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
									yeta2000Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
									yeta2000Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
									yeta2000Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
									yeta2000Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
									yeta2000Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    /** column 퇴직일자 : retryDt */
									yeta2000Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));    /** column 연말정산적용년월 : yrtxApptnYrMnth */
									yeta2000Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));    /** column 연말정산처리일자 : yrtxPrcsDt */
//									yeta2000Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
									yeta2000Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    /** column 연말정산처리여부 : yrtxPrcsYn */
									yeta2000Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    /** column 분할납부구분코드 : divdPymtDivCd */
									yeta2000Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    /** column 분할납부횟수 : divdPymt */ 
		 
		       	                  
		       	                 listYe16Ta2000Dto.add(yeta2000Dto);
		       	                 
		       	               }    
			                       
              	    	    
	               	      if (listYe16Ta2000Dto.size() <= 0) {
	  	  	                    
	  	  	                    MessageBox.alert("세액계산", "세액계산 할 데이타가 존재하지 않습니다.", null);
	  	  	                    return;
	  	  	                }
	                      final MessageBox box = MessageBox.wait("연말정산 세액계산", "세액계산 처리 중 입니다...", "세액결과 생성 중...");
			              final Timer t = new Timer()
			              {
			                  public void run()
			                  {
			                      if (tracker.getStatus())
			                      {
			                          cancel();
			                          box.close();
			                      }
			                  }
			              };
			              t.scheduleRepeating(500);
	               	             
   	           	 		yeta1300Service.fnYeta1300Payr06430CalcTax(listYe16Ta2000Dto,  
   	           	                new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
   	           	        public void onFailure(Throwable caught) {
   	           	         tracker.setStatus(true);
   	           	          List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                             ShowMessageBM smBm = new ShowMessageBM();
                     	      smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
                     	      smBm.setMenu("Yeta");
                     	      smBm.setPhase("[세액계산]세액계산에러");
                     	      smBm.setMessage(caught.getLocalizedMessage());
                     	      smBm.setContent(caught.getMessage());
                     	      bmResult.add(smBm);  
                     	      PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
                     	   
                             ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
   		    			    
 		    		          MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
 		    		          msFwMessage.show();
 		    		          showMessageForm.setMSFFormWindows(msFwMessage);
 		    		       
//   	           	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//   	           	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertRemt0100(insert) : " + caught), null);
  	           	           }
   	           	        public void onSuccess(PagingLoadResult<ShowMessageBM> result) {  
   	           	        tracker.setStatus(true);
   	           	        if (MSFSharedUtils.paramNotNull(result)) {
   	           	           ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                        	   BaseModel tmRec = new BaseModel();
    		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
    		    		       msFwMessage.show();
    		    		       showMessageForm.setMSFFormWindows(msFwMessage);
   	           	        }
                           //계산 결과에 따른 조회 호출 
   	                  	  //reload() ;
   	           	          reFresh();
   	           	        } 
   	           	        }); 	  
              	    	   
 	  	              
 	  	          } else {
 	  	              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
 	  	              return;
 	  	          }
   	           }  
   	      }
   	      
   	  }); 
             
	 }
	 
	 
	 private void fnYeta1300Payr06430AllCalcTax() { 

	   	  MessageBox.confirm("전체세액계산", "선택된 연말정산계산  대상자에 대해서 전체세액계산을 합니다. <br> 세액재계산을 하시겠습니까?",new Listener<MessageBoxEvent>(){
	   	      @Override
	   	       public void handleEvent(MessageBoxEvent be) {
	   	        //   if("Yes".equals(be.getButtonClicked().getText())){
	   	    	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	   	       
	   	        	 	    
		  
	          	        	String pymtYr  =  MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year") ;
	          	        	if (MSFSharedUtils.paramNull(pymtYr)) {
	          	        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	          		                        "대상자를 선택하시려면 정산년을 선택하셔야 합니다.", null);
	          	        		return;
	          	        	}
	              	     	if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"))) {
	              	     	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	        	                            "대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
	          	        		return;
	          	        	}
	              	     	
	              	     	
					          
			        	       final Tracker tracker = new Tracker();
	    					   tracker.setStatus(false);
	    				 
	       	                    Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO();    

								yeta2000Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());    /** column 사업장코드 : dpobCd */
								yeta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year")));    /** column 연말정산귀속년도 : edacRvyy */
								yeta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")));    /** column 정산구분코드 : settGbcd */
								  
	              	    	    
		               	   
		                      final MessageBox box = MessageBox.wait("전체세액계산", "세액계산 처리 중 입니다...", "세액결과 생성 중...");
				              final Timer t = new Timer()
				              {
				                  public void run()
				                  {
				                      if (tracker.getStatus())
				                      {
				                          cancel();
				                          box.close();
				                      }
				                  }
				              };
				              t.scheduleRepeating(500);
		               	             
	   	           	 		yeta1300Service.fnYeta1300Payr06430AllCalcTax(yeta2000Dto,  
	   	           	                new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
	   	           	        public void onFailure(Throwable caught) {
	   	           	         tracker.setStatus(true);
	   	           	          List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	                             ShowMessageBM smBm = new ShowMessageBM();
	                     	      smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
	                     	      smBm.setMenu("Yeta");
	                     	      smBm.setPhase("[세액계산]전체세액계산에러");
	                     	      smBm.setMessage(caught.getLocalizedMessage());
	                     	      smBm.setContent(caught.getMessage());
	                     	      bmResult.add(smBm);  
	                     	      PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
	                     	   
	                             ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
	   		    			    
	 		    		          MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
	 		    		          msFwMessage.show();
	 		    		          showMessageForm.setMSFFormWindows(msFwMessage);
	 		    		       
//	   	           	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	   	           	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertRemt0100(insert) : " + caught), null);
	  	           	           }
	   	           	        public void onSuccess(PagingLoadResult<ShowMessageBM> result) {  
	   	           	        tracker.setStatus(true);
	   	           	        if (MSFSharedUtils.paramNotNull(result)) {
	   	           	           ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
	                        	   BaseModel tmRec = new BaseModel();
	    		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	    		    		       msFwMessage.show();
	    		    		       showMessageForm.setMSFFormWindows(msFwMessage);
	   	           	        }
	                           //계산 결과에 따른 조회 호출 
	   	                  	  //reload() ;
	   	           	         // yeta1300ToYe16Ta2000GridPanel.getMsfGrid().getGrid() 
	   	           	          reFresh();
	   	           	        } 
	   	           	        }); 	  
	   	           }
	   	      }
	   	      
	   	  }); 
	             
		 }
		  
	 

class Tracker 
{
    public boolean status = false;
    public boolean getStatus(){return status;}
    public void setStatus(boolean stat){status = stat;}
}   
		 
	  public void setListRecord(Iterator<Record> records) {
		    this.records = records;
		 }
	  
   public Iterator<Record>  getListRecord() {
        return this.records;
     }
	 /**
	  * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	  * 인쇄 처리를 위해 추가된 부분 시작
	  * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  */
	 	/**
	 	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 	 * 	print Service 선언부 시작
	 	 *  rex 추가로 리포트 타입변경
	     *  fileName : 출력파일명 
	     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
	     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	     **/
		private void Yeta1300Print(String fileName, String repType) {
			if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
				RdaPrint(fileName);
			} else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
				RexPrint(fileName);
			} else {
				Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
			}
		}	
		
		//rda
		private void RdaPrint(String fileName) {
				
			// 출력물 디렉토리 패스경로 
			String strDirPath = "YETA";
				
			// mrd 출력물
			String rdaFileName = fileName+".mrd";
						
			// 보낼 파라미터
				
			//검색조건
			String serarchParam = "";
			
			//권한 설정으로 인해 추가된 부분 
	        String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd") ;
	        String deptCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
	        String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
				
			
	        serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";  //$1 사업장코드
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year") + "]";		//$2 년도
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")+ "]";		//$3 정산구분
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+ "]";//$4 단위기관
			serarchParam += "[" + MSFSharedUtils.allowNulls(srhHanNm.getValue()) + "]";					//$5 성명
			serarchParam += "[" + MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()) + "]";			//$6 주민등록번호
			serarchParam += "[" + MSFSharedUtils.allowNulls(srhSystemkey.getValue()) + "]";				//$7 시스템키
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") + "]";	//$8 고용구분
//			serarchParam += "[" + YetaUtils.getPrintStrToMultiData(lsDeptCd, MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd") +"]";		//$8 부서
     		//20151212-추가 시작 
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "[]"; ////$9 부서
            } else {
            	serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsDeptCd, MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd") +"]";	//$9 부서
            }  
		    //20151212-추가 끝		
			
			
			
			
			serarchParam += "[" + YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";	//$10 직종
			serarchParam += "[" + YetaUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$11 직종세
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd") + "]";		//$12 사업
//			serarchParam += "[" + MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";				//$12 시스템키 
			
			
			
			String checkedSystemKeys = "";
			
			List<BaseModel> list = yeta1300ToYe16Ta2000GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
				}
	            
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			//$13 시스템키 
			serarchParam += "["+checkedSystemKeys+"]";
			
	      		
			//20151212-변경추가 시작 
		    serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";		//$14 유우져 아이디 넘김 
			serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$15 단위기관 여부
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += "["+deptCdAuth+"]"; 			//$16 부서 
			serarchParam += "["+dtilOccuInttnCdAuth+"]";	//$17 직종세 
			//20151212-추가 끝 
			
			//원친징수일 경우 발행방법 파라미터 추가
			if("YETAT0302".equals(fileName)) {
				serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(issueMethod,"commCd") + "]";	//$18 발행방법	
				serarchParam += "[" + YetaUtils.getCheckedCheckBoxValue(juminCk)+ "]";	//$19 주민번호 보이기 여부
				
				//도장 출력을 위해 추가 2014-11-06
		      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
		      	if(MSFSharedUtils.paramNull(myImgUrl)) {
		      			// myImgUrl = "http://105.19.10.32:8080";
		              	//경로오류 출력 
		      	}
		      	serarchParam += "[" + myImgUrl+ "]";	//$20 이미지 경로
			 }
			
			
			serarchParam = "/rp " + serarchParam;
				
				
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rdaPrint(strDirPath, rdaFileName, serarchParam);
		}
		
		//rex 
		private void RexPrint(String fileName) {
			
			// 출력물 디렉토리 패스경로 
			String strDirPath = "YETA";
			
			// reb 출력물
			String rexFileName = fileName+".crf";
			
			// 보낼 파라미터  
			
	        // 검색조건
	     	String serarchParam = "";
	     	
	    	//권한 설정으로 인해 추가된 부분 
	        String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd") ;
	        String deptCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
	        String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
	       
	        
	        serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";  		//$1 사업장코드
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year") + "⊥";				//$2 년도
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")+ "⊥";				//$3 정산구분
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+ "⊥";	//$4 단위기관
			serarchParam += "" + MSFSharedUtils.allowNulls(srhHanNm.getValue()) + "⊥";							//$5 성명
			serarchParam += "" + MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()) + "⊥";					//$6 주민등록번호
			serarchParam += "" + MSFSharedUtils.allowNulls(srhSystemkey.getValue()) + "⊥";						//$7 시스템키
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd") + "⊥";			//$8 고용구분
//			serarchParam += "" + YetaUtils.getPrintStrToMultiData(lsDeptCd, MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd") +"⊥";		
     		//20151212-추가 시작 
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "⊥"; ////$9 부서
            } else {
            	serarchParam += ""+ YetaUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; //$9 부서
            }  
		    //20151212-추가 끝		
			
			serarchParam += "" + YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";	//$10 직종
			serarchParam += "" + YetaUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"⊥";  //$11 직종세
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd") + "⊥";		//$12 사업
			
			
			String checkedSystemKeys = "";
			
			List<BaseModel> list = yeta1300ToYe16Ta2000GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
				}
	            
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			//$13 시스템키 
			serarchParam += ""+checkedSystemKeys+"⊥";
			
	      		
			//20151212-변경추가 시작 
		    serarchParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";			//$14 유우져 아이디 넘김 
			serarchParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥";	//$15 단위기관 여부
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += ""+deptCdAuth+"⊥"; 			//$16 부서 
			serarchParam += ""+dtilOccuInttnCdAuth+"⊥";	//$17 직종세 
			//20151212-추가 끝 
			
			
			//원친징수일 경우 발행방법 파라미터 추가
			if("YETAT1302".equals(fileName)) {
				serarchParam += "" + MSFSharedUtils.getSelectedComboValue(issueMethod,"commCd") + "⊥";	//$18 발행방법	
				serarchParam += "" + YetaUtils.getCheckedCheckBoxValue(juminCk)+ "⊥";	//$19 주민번호 보이기 여부	
				
				//도장 출력을 위해 추가 2014-11-06
		      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
		      	if(MSFSharedUtils.paramNull(myImgUrl)) {
		      			// myImgUrl = "http://105.19.10.32:8080";
		              	//경로오류 출력 
		      	}
		      	serarchParam += "" + myImgUrl+ "⊥";	//$20 이미지 경로
			}
			
							
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, serarchParam);
		}
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 인쇄 처리를 위해 추가된 부분 종료
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */	 

	public ContentPanel getViewPanel() {
		if (panel == null) {
			
			
			//콤보 권한초기화
			initLoad(); 

			detailTp = XTemplate.create(getDetailTemplate());

			vp = new VerticalPanel();
			vp.setSpacing(10);

			createYeta1300Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createContentForm(); 	// 내용 필드
//			vp.setSize("1010px", "750px");
			vp.setSize("1010px", "720px");

			// 폼데이터를 바인딩
			// formBinding = new FormBinding(this.plFrmYeta1300, true);

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.setScrollMode(Scroll.AUTO);
			panel.add(vp);
		}

		return panel;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Yeta1300() {
	 
		setSize("1010px", "700px");
//		setSize("1010px", "750px");
	}

	public Yeta1300(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createContentForm() {

		LayoutContainer conLayoutContainer = new LayoutContainer();
		conLayoutContainer.setBorders(false);

		LayoutContainer btnLayoutContainer = new LayoutContainer();
		btnLayoutContainer.setBorders(false);
		btnLayoutContainer.setLayout(new ColumnLayout());
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		LayoutContainer btnLayoutContainer_0 = new LayoutContainer();
		btnLayoutContainer_0.setBorders(false);

		Button btnNewButton_22 = new Button("신용카드명세서");
		btnNewButton_22.setIcon(MSFMainApp.ICONS.print16());
		btnNewButton_22.addListener(Events.Select,  new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				Yeta1300Print("YETAT1303", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
			
		});
		btnBar.add(btnNewButton_22);
		

		LayoutContainer btnLayoutContainer_01 = new LayoutContainer();
		btnLayoutContainer_01.setBorders(false);

		Button btnNewButton_2 = new Button("의료비명세서");
		btnNewButton_2.setIcon(MSFMainApp.ICONS.print16());
		btnNewButton_2.addListener(Events.Select,  new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				Yeta1300Print("YETAT1300", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
			
		});
		btnBar.add(btnNewButton_2);

		LayoutContainer btnLayoutContainer_02 = new LayoutContainer();
		btnLayoutContainer_02.setBorders(false);

		Button btnNewButton_3 = new Button("기부금명세서");
		btnNewButton_3.setIcon(MSFMainApp.ICONS.print16());
		btnNewButton_3.addListener(Events.Select,  new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				Yeta1300Print("YETAT1301", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
			
		});
		btnBar.add(btnNewButton_3);

//		LayoutContainer btnLayoutContainer_03 = new LayoutContainer();
//		btnLayoutContainer_03.setBorders(false);
//
//		Button btnNewButton_4 = new Button("재계산대상자");
//		btnLayoutContainer_03.add(btnNewButton_4);
//		btnBar.add(btnNewButton_4);

		LayoutContainer btnLayoutContainer_04 = new LayoutContainer();
		btnLayoutContainer_04.setBorders(false);

		Button btnYeta1300_05 = new Button("세액계산");
		btnYeta1300_05.setIcon(MSFMainApp.ICONS.save16());
		btnBar.add(btnYeta1300_05);
		btnYeta1300_05.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    		 
    	        fnYeta1300Payr06430CalcTax();
    		}
    	});
		if ("yongbc".equals(MSFMainApp.get().getUser().getUsrId()) || "admin".equals(MSFMainApp.get().getUser().getUsrId())) {	
			LayoutContainer btnLayoutContainer_05 = new LayoutContainer();
			btnLayoutContainer_05.setBorders(false);
	
			Button btnNewButton_6 = new Button("세액전체계산");
			btnLayoutContainer_05.add(btnNewButton_6);
			btnBar.add(btnNewButton_6);
			btnNewButton_6.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) { 
	    	        fnYeta1300Payr06430AllCalcTax();
	    		}
	    	});
		}
			
		LayoutContainer btnLayoutContainer_06 = new LayoutContainer();
		btnLayoutContainer_06.setBorders(false);

		FormLayout frmlytSch8 = new FormLayout();
		frmlytSch8.setLabelWidth(60);
		frmlytSch8.setLabelAlign(LabelAlign.RIGHT);

		btnLayoutContainer_06.setLayout(frmlytSch8);

		issueMethod = new ComboBox<BaseModel>();
		issueMethod.setFieldLabel("발행방법");
		issueMethod.setDisplayField("commNm");
		issueMethod.setValueField("commCd");
		issueMethod.setTriggerAction(TriggerAction.ALL);
		issueMethod.setSelectOnFocus(true);
		issueMethod.setMinChars(1);
		btnLayoutContainer_06.add(issueMethod, new FormData("90%"));
		
		ListStore<BaseModel> lsIssueMethod = new ListStore<BaseModel>();
		
		BaseModel issueMethodBaseModel = new BaseModel();
		issueMethodBaseModel.set("commCd", "Y11");
		issueMethodBaseModel.set("commNm", "1. 소득자보관용");
		lsIssueMethod.add(issueMethodBaseModel);
		
		issueMethodBaseModel = new BaseModel();
		issueMethodBaseModel.set("commCd", "Y12");
		issueMethodBaseModel.set("commNm", "2. 발행자보관용");
		lsIssueMethod.add(issueMethodBaseModel);
		
		issueMethodBaseModel = new BaseModel();
		issueMethodBaseModel.set("commCd", "Y13");
		issueMethodBaseModel.set("commNm", "3. 발행자보고용");
		lsIssueMethod.add(issueMethodBaseModel);
		
		issueMethod.setStore(lsIssueMethod);
		issueMethod.setValue(lsIssueMethod.getAt(0));
		
		
		LayoutContainer btnLayoutContainer_07 = new LayoutContainer();
		btnLayoutContainer_07.setBorders(false);
		
		ButtonBar btnBar2 = new ButtonBar();
		btnBar2.setAlignment(HorizontalAlignment.RIGHT);

		Button btnNewButton_7 = new Button("영수증/명세");
		btnNewButton_7.setIcon(MSFMainApp.ICONS.print16());
		btnNewButton_7.setIconAlign(IconAlign.RIGHT);
		btnNewButton_7.addListener(Events.Select,  new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				Yeta1300Print("YETAT1302", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
		});
//		btnLayoutContainer_07.add(btnNewButton_7);
		btnBar2.add(btnNewButton_7);
		
		
		LayoutContainer btnLayoutContainer_08 = new LayoutContainer();
		btnLayoutContainer_08.setBorders(false);
		
		
		juminCk = new CheckBoxGroup();
		juminCk.setName("juminCk");
		juminCk.setHideLabel(true);
		CheckBox juminY  = new CheckBox();
		juminY.setBoxLabel("주민번호 표시");
		juminY.setHideLabel(true);
		juminY.setValueAttribute("Y");
		juminCk.add(juminY);
		
		btnLayoutContainer_08.add(juminCk);
		

		
		btnLayoutContainer.add(btnBar, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		btnLayoutContainer.add(btnLayoutContainer_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));
//		btnLayoutContainer.add(btnLayoutContainer_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
////		btnLayoutContainer.add(btnLayoutContainer_03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
//		btnLayoutContainer.add(btnLayoutContainer_04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
////		btnLayoutContainer.add(btnLayoutContainer_05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		btnLayoutContainer.add(btnLayoutContainer_06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		btnLayoutContainer.add(btnLayoutContainer_07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		btnLayoutContainer.add(btnBar2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		btnLayoutContainer.add(btnLayoutContainer_08, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());
		layoutContainer_5.add(createListGrid(), new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_5.add(createTabForm(), new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_5.setBorders(false);

		conLayoutContainer.add(btnLayoutContainer);
		conLayoutContainer.add(layoutContainer_5);

		plFrmYeta1300.add(conLayoutContainer);

	}

	private void createYeta1300Form() {
		
		plFrmYeta1300 = new FormPanel();
		plFrmYeta1300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 소득공제신고자료관리"));
		plFrmYeta1300.setIcon(MSFMainApp.ICONS.text());
		plFrmYeta1300.setBodyStyleName("pad-text");
		plFrmYeta1300.setFrame(true);
		plFrmYeta1300.setPadding(2);
		
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("소득공제신고자료관리","YETA1300");
				}
			});
		plFrmYeta1300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta1300.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		   //멀티콤보박스 닫기 
		plFrmYeta1300.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
				            @Override
				            public void handleEvent(ComponentEvent ce) { 
				            
				             //   for (Field<?>  f : ((FormPanel) plFrmRemt0100).getFields()) {
			                        
				            //        if (f instanceof MSFMultiComboBox<?>) {
				                        
//				                        if ("srhDeptCd".equals(f.getName())) {
//				                            
//				                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//				                            
//				                        }
			                            
			                  //      } else {
				                   if (mutilCombo) {
			                            if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
			                                srhDeptCd.showClose(ce);
			                                mutilCombo = false;
			                         //   } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
			                         //       srhHdofcCodtnCd.showClose(ce);
			                          //      mutilCombo = false;
			                            } else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
			                                //직종
			                                srhTypOccuCd.showClose(ce);
			                                mutilCombo = false;
			                              //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
			                            } else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
			                                //직종세
			                                srhDtilOccuInttnCd.showClose(ce);
			                                mutilCombo = false;
			                            } 
				                   }
			                    //    }
				            //    } 
				            } 
				        });
		topYeta1300Bar = new ButtonBar();
		topYeta1300Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnYeta1300Reset = new Button("초기화");
		btnYeta1300Reset.setIcon(MSFMainApp.ICONS.new16());
		btnYeta1300Reset.addListener(Events.Select, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				
				resetSearchForm();				//검색조건 초기화
				resetYeta300ToYe16Ta2000Grid();	//대상자정보 grid 초기화
				resetItemYeta01();				//기본사항 초기화

				tabsYeta1300.setSelection(tabsYeta1300.getItem(0));//탭부분 초기화
			}
		});
		topYeta1300Bar.add(btnYeta1300Reset);

		btnYeta1300Save = new Button("저장");
		btnYeta1300Save.setIcon(MSFMainApp.ICONS.save16());
		topYeta1300Bar.add(btnYeta1300Save);
		btnYeta1300Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				
				    if (edacRvyy.getValue().compareTo("2016") != 0) {
				    	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
 	                            "2016년연말정산 이전자료는 조회만 가능합니다.", null); 
				        return;
				    
				    }
				    
				     if (settGbcd.getValue().compareTo("Y0020010") != 0 ) { 
				    	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	 	                            "2016년 귀속분 연말정산만 가능합니다.", null); 
				        //  showMessage('2015년 연말정산은 마감되었습니다. 수정은 재정산만 가능합니다.');
				         return;
				     }
				
//				     actionDatabase = ActionDatabase.UPDATE;
				     
				//  {-- 기본사항 --}
				if("itemYeta01".equals(tabsYeta1300.getSelectedItem().getId())) {
					
//					MessageBox.info("", "기본사항 탭은 수정할 수 없습니다.", null);
					itemYeta01Save();	//기본사항 탭
					
				//  {-- 인적공제 --}	
				}else if("itemYeta02".equals(tabsYeta1300.getSelectedItem().getId())) {
					
//					MessageBox.info("", "인적공제 탭은 수정할 수 없습니다.", null);
					itemYeta02Save();	//인적공제 저장
				//	{-- 소득공제 --}	
				}else if("itemYeta03".equals(tabsYeta1300.getSelectedItem().getId())) {
					
					itemYeta03Save();	//소득공제
					//MessageBox.info("", "소득공제 탭은 수정할 수 없습니다.", null);
					
				}else if("itemYeta04".equals(tabsYeta1300.getSelectedItem().getId())) {
				//	  {-- 연금보험료공제--}
					itemYeta04Save();//국민연금보험료외의 연금보험료 저장
					
				}else if("itemYeta05".equals(tabsYeta1300.getSelectedItem().getId())) {
					if("itemYeta05_1".equals(tabsItemYeta05.getSelectedItem().getId())) {
						// {-- 특별공제 --}
						itemYeta05_1Save();//특별소득공제 - 보험료 탭 저장
							
					}else if("itemYeta05_2".equals(tabsItemYeta05.getSelectedItem().getId())) {
						
						itemYeta05_2Save();//특별소득공제 - 주택자금 탭 저장
							
					}
				}
//				else if("itemYeta05_1".equals(tabsItemYeta05.getSelectedItem().getId())) {
//					// {-- 특별공제 --}
//					//MessageBox.info("", "특별공제 탭의 보험료 내용은 수정할 수 없습니다.", null);
//						
//				}else if("itemYeta05_2".equals(tabsItemYeta05.getSelectedItem().getId())) {
//					
//					itemYeta05_2Save();//특별소득공제 - 주택자금 탭 저장
//						
//				}
				else if("itemYeta06".equals(tabsYeta1300.getSelectedItem().getId())) {
					// {-- 그밖의 소득공제--}
					itemYeta06Save();//그밖의소득공제1 저장
					
				}else if("itemYeta07".equals(tabsYeta1300.getSelectedItem().getId())) {
					
					itemYeta07Save();//그밖의소득공제2 저장
					
				}else if("itemYeta08".equals(tabsYeta1300.getSelectedItem().getId())) {
					//{-- 세액감면및세액공제--}
					if("itemYeta08_1".equals(tabsItemYeta08.getSelectedItem().getId())) {
						 
						itemYeta08_1Save();//세액감면및세액공제1 - 연금계좌및보험료 저장
							
					}else if("itemYeta08_2".equals(tabsItemYeta08.getSelectedItem().getId())) {
						
						//MessageBox.info("", "세액감면 및 세액공제1 탭의 의료비 내용은 수정할 수 없습니다.", null);
							
					}else if("itemYeta08_3".equals(tabsItemYeta08.getSelectedItem().getId())) {
						
						itemYeta08_3Save();//세액감면및세액공제1 - 교육비 저장
							
					}else if("itemYeta08_4".equals(tabsItemYeta08.getSelectedItem().getId())) {
						
						//MessageBox.info("", "세액감면 및 세액공제1 탭의 기부금 내용은 수정할 수 없습니다.", null);
						
					}
				}else if("itemYeta09".equals(tabsYeta1300.getSelectedItem().getId())) {
					
					//세액감면및세액공제2 저장
					itemYeta09Save();
					
				}else if("itemYeta10".equals(tabsYeta1300.getSelectedItem().getId())) {
					//{-- 추가제출서류 --}
					//추가제출서류 저장
					itemYeta10Save();
//					MessageBox.info("", "추가서류제출 탭은 수정할 수 없습니다.", null);
				}
			}
		});

//		btnYeta1300Del = new Button("삭제");
//		btnYeta1300Del.setIcon(MSFMainApp.ICONS.delete16());
//		topYeta1300Bar.add(btnYeta1300Del);
		
		LabelField radioLabel = new LabelField("대상");
		radioLabel.setWidth(30);
		radioLabel.setStyleAttribute("fontSize", "13px");
		radioLabel.setStyleAttribute("font-weight", "bold");
		topYeta1300Bar.add(radioLabel);
		
		printType = new RadioGroup();
		
		Radio radio1 = new Radio();
		radio1.setBoxLabel("원천징수");
		radio1.setHideLabel(true);
		printType.add(radio1);
		
		Radio radio2 = new Radio();
		radio2.setBoxLabel("의료비");
		radio2.setHideLabel(true);
		radio2.setValueAttribute("YETA3140");
		printType.add(radio2);
		
		Radio radio3 = new Radio();
		radio3.setBoxLabel("기부금");
		radio3.setHideLabel(true);
		radio2.setValueAttribute("YETA3170");
		printType.add(radio3);
		
		topYeta1300Bar.add(printType);

		btnYeta1300Sreach = new Button("조회");
		btnYeta1300Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnYeta1300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				//탭 선택 없애기
				tabsYeta1300.setSelection(tabsYeta1300.getItem(0));
	        	   
				//대상자 정보 조회
				reload();
			}
		});
		topYeta1300Bar.add(btnYeta1300Sreach);

//		btnYeta1300Print = new Button("인쇄");
//		btnYeta1300Print.setIcon(MSFMainApp.ICONS.print16());
//		topYeta1300Bar.add(btnYeta1300Print);

		plFrmYeta1300.add(topYeta1300Bar);

		// 파일업로드 처리
		plFrmYeta1300.setAction("myurl");
		plFrmYeta1300.setEncoding(Encoding.MULTIPART);
		plFrmYeta1300.setMethod(Method.POST);

		vp.add(plFrmYeta1300);
		plFrmYeta1300.setSize("990px", "680px");
//		plFrmYeta1300.setSize("990px", "730px");

	}

	// 정산대상자 그리드 리스트
	private LayoutContainer createListGrid() {
		
		FieldSet fieldSetGrd = new FieldSet();  
	    fieldSetGrd.setHeadingHtml("대상자정보");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    FormLayout frmlytStd = new FormLayout();  
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(275, 480);  
	    
	    yeta1300ToYe16Ta2000GridPanel = new MSFGridPanel(Ye16Ta2000Def_01, false, false, false, false, false);
	    yeta1300ToYe16Ta2000GridPanel.setHeaderVisible(false);  
	    yeta1300ToYe16Ta2000GridPanel.setBodyBorder(true);
	    yeta1300ToYe16Ta2000GridPanel.setBorders(true);
	    final Grid yeta1300ToYe16Ta2000Grid = yeta1300ToYe16Ta2000GridPanel.getMsfGrid().getGrid();
        yeta1300ToYe16Ta2000Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {

           public void handleEvent(BaseEvent be) {   
	        	   
        	   //탭 선택 없애기
        	   tabsYeta1300.setSelection(tabsYeta1300.getItem(0));
        	   
//        	   BaseModel bmData = yeta1300ToYe16Ta2000GridPanel.getMsfGrid().getStore().getModels().get(0);  
        	   BaseModel bmData = yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem();  
        	   
//        	   funcSetPopUpRecord();
        	  
        	   dpobCd.setValue((String) bmData.get("dpobCd"));		/**  column 사업장코드 : dpobCd */
        	   edacRvyy.setValue((String) bmData.get("edacRvyy"));	/** column 연말정산귀속년도 : edacRvyy */
        	   settGbcd.setValue((String) bmData.get("settGbcd"));	/** column 정산구분코드 : settGbcd */
        	   systemkey.setValue((String) bmData.get("systemkey"));/**  column SYSTEMKEY : systemkey */
        	   hanNm.setValue((String) bmData.get("hanNm"));		/** column 성명 : hanNm */
        	   deptNm.setValue((String) bmData.get("deptNm"));		/**  column 부서명 : deptNm */
        	   
        	   setPPRecord(bmData); //팝업에 넘길값 

//        	   yeta1300ToYe16Ta2000Detail();
        	   reFresh();
        	   //reFresh("itemYeta01");
           }
       }); 
	    
	    cpGrid.add(yeta1300ToYe16Ta2000GridPanel); 
	    
	    fieldSetGrd.add(cpGrid);
	    lcStdGrid.add(fieldSetGrd);
	    
	    return lcStdGrid;
		
	}

	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {
		
		dpobCd = new HiddenField<String>();            //사업장코드 
        systemkey = new HiddenField<String>();         //시스템키 
        edacRvyy  = new HiddenField<String>();	/** set 연말정산귀속년도 : edacRvyy */
		settGbcd = new HiddenField<String>();	/** set 정산구분코드 : settGbcd */
		edacSeilNum = new HiddenField<Long>();	/** set 연말정산마감일련번호 : edacSeilNum */
		hanNm = new HiddenField<String>();		/** set 성명 : hanNm */
		deptNm = new HiddenField<String>();		/** set 부서 : deptNm */
		
//        pyspGrdeCd =  new HiddenField<String>();
//        clutYrMnth =   new HiddenField<String>();
		
		sysComBass0150Dto = new PrgmComBass0150DTO();
	    sysComBass0300Dto = new PrgmComBass0300DTO();
	    sysComBass0320Dto = new PrgmComBass0320DTO();
	    sysComBass0400Dto = new PrgmComBass0400DTO();
	    sysComBass0500Dto = new PrgmComBass0500DTO();
	    msfCoCalendarDto = new SysCoCalendarDTO();
	    sysComBass0350Dto = new PrgmComBass0350DTO();
	     
	    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	    lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);//단위기관
	    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	     
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	    sysComBass0300Dto.setRpsttvCd("Y002");
	    lsSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
	     
	    sysComBass0300Dto.setRpsttvCd("A002");
	    lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//고용구분
	    
		
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);//호봉
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	     
		sysComBass0300Dto.setRpsttvCd("B029");
		lsAddIncmTxApptnRtoCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);//추가소득세적용비율코드 
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	     
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	    lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
	    lsClutMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);			//월
	    //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
	    
		// --------------------연말정산 불러 오는 함수------------------------------------------------	
//	    ye16Ta1005Dto = new Ye16Ta1005DTO();
//		ye16Ta1005Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());	/** column 사업장코드 : dpobCd */
//		ye16Ta1005Dto.setDeptCd(MSFMainApp.get().getUser().getDeptCd());    /** column 부서코드 : deptCd */
//		ye16Ta1005Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//	    lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdList(ye16Ta1005Dto);
	    lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdListNoAuth();
	    // --------------------연말정산 불러 오는 함수------------------------------------------------		
	     
	     sysComBass0400Dto.setDeptDspyYn("Y");
	     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	     
	     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	     
	     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	    	 public void handleEvent(StoreEvent<BaseModel> be) {  
	    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
	    		 srhDeptCd.getInitStore().add(mDtalistDeptCd);
	    	 }
	     });     
	        
	     /**
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	      * 직종 콤보박스 처리  시작
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
	      */
	     
//	     ContentPanel typOccuCdGrid = new ContentPanel();  
//	     typOccuCdGrid.setVisible(false);
//	                
//	     //직종 콤보처리 
//	     typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//	     typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	    	 public void handleEvent(ComponentEvent be) {  
//	    		 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	    			 public void handleEvent(StoreEvent<BaseModel> be) {  
//	    				 lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//	    				 mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	    				 srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//	    			 }  
//	    		 });  
//	    	 }  
//	     });  
//	          
//		typOccuCdGrid.add(typOccuCdGridPanel); 
//	  	plFrmYeta1300.add(typOccuCdGrid);
	     
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd);
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

			}
		});
		   
	  	
	  	srhSystemkey = new HiddenField<String>(); 
	  	edacRvyy= new HiddenField<String>();	/** column 연말정산귀속년도 : edacRvyy */
		settGbcd = new HiddenField<String>();	/** column 정산구분코드 : settGbcd */
		systemkey = new HiddenField<String>();  /**  column SYSTEMKEY : systemkey */
		dpobCd 	= new HiddenField<String>();	/**  column 사업장코드 : dpobCd */
		edacSeilNum = new HiddenField<Long>();	/** set 연말정산마감일련번호 : edacSeilNum */
	  	
	  	
	  	
		plFrmYeta1300.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/

		LayoutContainer lcSchLeft = new LayoutContainer();

		fieldSet.add(lcSchCol, new FormData("100%"));
		lcSchLeft.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);

		
		srhEdacRvyy = new ComboBox<BaseModel>();
		srhEdacRvyy.setName("srhEdacRvyy");
		srhEdacRvyy.setForceSelection(true);
		srhEdacRvyy.setMinChars(1);
		srhEdacRvyy.setDisplayField("yearDisp");
		srhEdacRvyy.setValueField("year");
		srhEdacRvyy.setTriggerAction(TriggerAction.ALL);
		// srhEdacRvyy.setEmptyText("--년도선택--");
		srhEdacRvyy.setSelectOnFocus(true);
		srhEdacRvyy.setReadOnly(true);
		srhEdacRvyy.setEnabled(true);
		srhEdacRvyy.setStore(lsClutYrStore);
		srhEdacRvyy.setFieldLabel("년도");
		srhEdacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		srhEdacRvyy.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmClutYr = se.getSelectedItem();
				if (bmClutYr != null) {
					if ((srhDeptCd.getListView().getChecked().size() == 1)
									&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

							if (srhDeptCd.getListView().getChecked().size() > 0) {
									sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));
									List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
									sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
							}

								// --------------------사업 불러 오는 함수-------------------------------------------------
								lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
								// --------------------사업 불러 오는 함수-------------------------------------------------
								srhBusinCd.setStore(lsBusinCd);
								srhBusinCd.getStore().addStoreListener(
										new StoreListener<BaseModel>() {
											public void handleEvent(StoreEvent<BaseModel> be) {
												// searchBusinCd.setValue(lsBusinCd.getAt(0));
											}
										});

					} else {
								// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
								// return;
					}
				}
			}
		});
		layoutContainer_8.add(srhEdacRvyy, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_8.setBorders(false);

		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		layoutContainer_14.setBorders(false);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch);

		/** column 단위기관 : payrMangDeptCd */
		srhPayrMangDeptCd = new ComboBox<BaseModel>();
		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		srhPayrMangDeptCd.setForceSelection(true);
		srhPayrMangDeptCd.setMinChars(1);
		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
		srhPayrMangDeptCd.setSelectOnFocus(true);
		srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
	    srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
		srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);
		srhPayrMangDeptCd.setFieldLabel("단위기관");
		lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
	        	  
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		             * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		             * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						checkYeta1300Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
				}
			}
		});
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	            sysComBass0400Dto.setDeptDspyYn("Y");
	            sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	            //--------------------부서 불러 오는 함수 ------------------------------------------------
	            lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	            //--------------------부서 불러 오는 함수 ------------------------------------------------
	            lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	               public void handleEvent(StoreEvent<BaseModel> be) {  
	                 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
	                 srhDeptCd.getInitStore().add(mDtalistDeptCd);
	                   
	               }
	            });  
	        } 
	    });		
	    layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
	    
	    
		LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
		layoutContainer.setBorders(false);
		
		
		LayoutContainer layoutContainer_155 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_155.setLayout(frmlytSch);

		srhEmymtDivCd = new ComboBox<BaseModel>();
		srhEmymtDivCd.setName("srhEmymtDivCd");
		srhEmymtDivCd.setForceSelection(true);
		srhEmymtDivCd.setMinChars(1);
		srhEmymtDivCd.setDisplayField("commCdNm");
		srhEmymtDivCd.setValueField("commCd");
		srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		srhEmymtDivCd.setEmptyText("--고용구분선택--");
		srhEmymtDivCd.setSelectOnFocus(true);
		srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		srhEmymtDivCd.setStore(lsEmymtDivCd);
		srhEmymtDivCd.setFieldLabel("고용구분");
	    lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	        public void handleEvent(StoreEvent<BaseModel> be) {  
	        	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	           		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	           		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	           		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		         		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkYeta1300Auth("srhEmymtDivCd", lsEmymtDivCd); 
		    	   }
	        }
	    });    
	    srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	            //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	    		BaseModel bmPayCd =  se.getSelectedItem(); 
	    		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	    			if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	    				if (srhDeptCd.getListView().getChecked().size() > 0) {  
	    					sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));    
	    					List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
	    					sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
	    				}      
	            
	    				//--------------------사업 불러 오는 함수 -------------------------------------------------
	    				lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
		                //--------------------사업 불러 오는 함수 -------------------------------------------------
	    				srhBusinCd.setStore(lsBusinCd); 
	    				srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	    					public void handleEvent(StoreEvent<BaseModel> be) {  
	                      //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
	    					}
	    				});    
	    			} else {
		              // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
		              // return;
	    			}  
		           srhBusinCd.setEnabled(true);
		           srhTypOccuCd.reset();
		           srhTypOccuCd.setEnabled(false);
		           srhDtilOccuInttnCd.reset();
		           srhDtilOccuInttnCd.setEnabled(false);
	    		} else {
		            srhBusinCd.reset();
		            srhBusinCd.setEnabled(false);  
		            
		            //if (gwtAuthorization.getCheckOccuDisabled()) {
		                srhTypOccuCd.setEnabled(true);
		                srhDtilOccuInttnCd.setEnabled(true); 
		           // } else {
		           //     srhTypOccuCd.setEnabled(false);
		            //    srhDtilOccuInttnCd.setEnabled(false);
	                
	                //TODO 확인 
//	              ModelData  mdSelect = null; 
//	              List<ModelData> lsMdSelect = (List<ModelData>) srhTypOccuCd.getStore().findModels("typOccuCd",MSFMainApp.get().getUser().getTypOccuCd());
//	              
//	              if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//	                  for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//	                      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//	                      if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//	                          mdSelect = tpMdSelect;
//	                      } 
//	                  }  
//	              
//	                  srhTypOccuCd.getListView().setChecked(mdSelect, true); 
//	                  srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
//	              } 
	                
		           // } 
	    		}  
	    	} 
	    });		
		
	    layoutContainer_155.add(srhEmymtDivCd, new FormData("100%"));
	    layoutContainer.add(layoutContainer_155, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    
	    
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

	    frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0);
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setHideLabel(true);
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(false);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	    srhRepbtyBusinDivCd.setValueField("commCd");
	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	    srhRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    
		

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");
		srhHanNm.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				super.componentKeyUp(event);
				srhHanNm.validate();
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
			}
		});
		
		
		
		srhHanNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {
				
				srhHanNm.validate();
				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		});
//		srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//					srhSystemkey.setValue("");
//					srhResnRegnNum.setValue("");
//				}
//
//			}
//		});
		layoutContainer_6.add(srhHanNm, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		layoutContainer_6.setBorders(false);
		
        LayoutContainer layoutContainer_btn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        layoutContainer_btn.setLayout(frmlytSch);

		Button btnHanNm = new Button("검색");
		layoutContainer_5.add(btnHanNm);
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				srhResnRegnNum.setValue("");
				fnPopupPsnl0100();
			}
		});
		
        layoutContainer_btn.add(btnHanNm);
        layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSch);

		/** column 주민등록번호 : resnRegnNum */
		srhResnRegnNum = new TextField<String>();
		srhResnRegnNum.setName("srhResnRegnNum");
		new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
		srhResnRegnNum.setHideLabel(true);
		srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
					srhSystemkey.setValue("");
					srhHanNm.setValue("");
				}

			}
		});
		layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		layoutContainer_7.setBorders(false);
		layoutContainer_5.setBorders(false);

//		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));				// 년도
//		lcSchCol.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 정산구분
//		lcSchCol.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));		// 단위기관
//		lcSchCol.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));		// 성명, 주민등록번호
		
		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));				// 년도
		lcSchCol.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
		lcSchCol.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 고용구분
		

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());
		
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setBorders(false);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);

		srhSettGbcd = new ComboBox<BaseModel>();
		srhSettGbcd.setName("srhSettGbcd");
		srhSettGbcd.setForceSelection(true);
		srhSettGbcd.setMinChars(1);
		srhSettGbcd.setDisplayField("commCdNm");
		srhSettGbcd.setValueField("commCd");
		srhSettGbcd.setTriggerAction(TriggerAction.ALL);
		srhSettGbcd.setEmptyText("--정산구분선택--");
		srhSettGbcd.setSelectOnFocus(true);
		srhSettGbcd.setReadOnly(false);
		srhSettGbcd.setEnabled(true);
		srhSettGbcd.setStore(lsSettGbcd);
		srhSettGbcd.setFieldLabel("정산구분");
//		srhSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//			
//			}
//		});

		layoutContainer_1.add(srhSettGbcd, new FormData("100%"));

		

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.getStore().add(mDtalistDeptCd);
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
	    srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	    srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	        public void handleEvent(StoreEvent<ModelData> be) {  
	        	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	           		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	           		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	           		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		        		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkYeta1300Auth("srhDeptCd", lsDeptCd); 
	           	 	}
	        	}
	    	});    
	    srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	    	@Override
	    	public void handleEvent(ComponentEvent ce) { 
	    		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	    			if (srhDeptCd.getListView().getChecked().size() > 0) {  
	    				
	    				sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year"));    
	    				List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
	    				sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
	    			}      
	                   
	    			//--------------------사업 불러 오는 함수 -------------------------------------------------
	    			lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	             	//--------------------사업 불러 오는 함수 -------------------------------------------------
	            	srhBusinCd.setStore(lsBusinCd); 
	            	srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            		public void handleEvent(StoreEvent<BaseModel> be) {  
	                             //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
	                	}
	            	}); 
	    		} else {
	                     // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
	                     // return;
	    		} 
	    	}  
	    });  
	     
	    srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	        @Override
	        public void handleEvent(ComponentEvent ce) {   
	            if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
	               // GWT.log(" a" + ce.getEvent().getType());
	                mutilCombo = true;
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                mutilCombo = true;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                mutilCombo = false;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } 
	        } 
	    });	    

		layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);
		
		

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);
		
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(80); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_211.setLayout(frmlytSch); 
       
        srhDeptGpCd  =  new ComboBox<BaseModel>(); 
        srhDeptGpCd.setName("srhDeptGpCd");
        srhDeptGpCd.setForceSelection(true);
        srhDeptGpCd.setAllowBlank(false);
        srhDeptGpCd.setMinChars(1);
        srhDeptGpCd.setDisplayField("commCdNm");
        srhDeptGpCd.setValueField("commCd");
        srhDeptGpCd.setTriggerAction(TriggerAction.ALL);
        srhDeptGpCd.setEmptyText("--그룹--");
        srhDeptGpCd.setSelectOnFocus(true); 
        srhDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        srhDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        srhDeptGpCd.setStore(lsDeptGpCd);
        srhDeptGpCd.setFieldLabel("직종"); 
        
        layoutContainer_211.add(srhDeptGpCd, new FormData("100%")); 
        

		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);

		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.setHideLabel(true);
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
//		srhTypOccuCd.setFieldLabel("직종");
		//srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		//srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			    		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						//checkYeta1300Auth("srhTypOccuCd", lsTypOccuCd); 
				}
			}
		});     
		    
		srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
		               
				if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
		                        
					//직종변경에 따른 직종세 값 가져오기
					List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked();  
		                        
					String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
					sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
		                        
		        	if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
		                            
		        		lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
		        		//  srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
			        	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
			        		public void handleEvent(StoreEvent<BaseModel> be) {  
			        			mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
			        			srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
			        		}
			        	});     
		         	} 
				} else {
		                   
				} 
		                  
			}  
		});  
		     
		srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
		               // GWT.log(" a" + ce.getEvent().getType());
		                mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
		                mutilCombo = true;
		              //  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
		                mutilCombo = false;
		              //  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});		
		layoutContainer_21.add(srhTypOccuCd, new FormData("100%"));

		LayoutContainer lcSchRight = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		// fieldSet.setLayout(layout);
		lcSchRight.setLayout(frmlytSch);

		/** column 직종세코드 : dtilOccuInttnCd */
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
		srhDtilOccuInttnCd.setWidth(100);
		srhDtilOccuInttnCd.setHideLabel(true);
	    //srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	    //srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
	    srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	        @Override
	        public void handleEvent(ComponentEvent ce) {    
	            if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
	                mutilCombo = true;
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                mutilCombo = true;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                mutilCombo = false;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else {
	               
	            }  
	        
	        } 
	    });		

		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));
		
		
		lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		lcTypOccuCd.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_21.setBorders(false);

		layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
		layoutContainer_10.setBorders(false);
		
		

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSch);

		srhBusinCd = new ComboBox<BaseModel>();
		srhBusinCd.setName("srhBusinCd");
		srhBusinCd.setForceSelection(true);
		srhBusinCd.setMinChars(1);
		srhBusinCd.setDisplayField("businNm");
		srhBusinCd.setValueField("businCd");
		srhBusinCd.setTriggerAction(TriggerAction.ALL);
		srhBusinCd.setEmptyText("--사업선택--");
		srhBusinCd.setSelectOnFocus(true);
		srhBusinCd.getListView().setWidth("200px");
		srhBusinCd.setStore(lsBusinCd);
		srhBusinCd.setFieldLabel("사업");
		srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		layoutContainer_4.setBorders(false);
		
		
//		layoutContainer_13.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));	// 정산구분
//		layoutContainer_13.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 부서
//		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 직종
//		layoutContainer_13.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 사업
		
		layoutContainer_13.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 정산구분
		layoutContainer_13.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
		
		
		fieldSet.add(layoutContainer_13);
		
        
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());
        
        LayoutContainer layoutContainer_16_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_1.setLayout(frmlytSch);
			    
		srhYetaDpcd = new ComboBox<BaseModel>();
		srhYetaDpcd.setName("srhYetaDpcd");
		srhYetaDpcd.setForceSelection(true);
		srhYetaDpcd.setMinChars(1);
		srhYetaDpcd.setDisplayField("yetaDpnm");
		srhYetaDpcd.setValueField("yetaDpcd");
		srhYetaDpcd.setTriggerAction(TriggerAction.ALL);
		srhYetaDpcd.setEmptyText("--원천신고부서--");
		srhYetaDpcd.setSelectOnFocus(true);
		srhYetaDpcd.setReadOnly(false);
		srhYetaDpcd.setEnabled(true);
		srhYetaDpcd.setStore(lsYetaDpcd);
		srhYetaDpcd.setFieldLabel("원천신고부서");
		layoutContainer_16_1.add(srhYetaDpcd, new FormData("100%"));
		layoutContainer_16_1.setBorders(false);
		srhYetaDpcd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 원천신고부서가 변경될 경우 해당하는 사업자등록번호를 가져옴
				BaseModel bmClutYr = se.getSelectedItem();
				
				if (bmClutYr != null) {
					
					
					// TODO 콤보 선택시 사업자번호 스토어 
					lsBusoprRgstnum.removeAll();
					srhBusoprRgstnum.setStore(new ListStore<BaseModel>());
					srhBusoprRgstnum.removeAllListeners();
					srhBusoprRgstnum.setValue(new BaseModel());
					
					
					Ye16Ta1005DTO yeta161005Dto = new Ye16Ta1005DTO();
					yeta161005Dto.setDpobCd(dpobCd.getValue());
					yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
					
					lsBusoprRgstnum = YetaComboUtils.getYeta2000busoprRgstnumList(yeta161005Dto);
					srhBusoprRgstnum.setStore(lsBusoprRgstnum);
					
				}
			}
		}); 
		layoutContainer_16_1.add(srhYetaDpcd, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_16_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_16_2 = new LayoutContainer();
		layoutContainer_16_2.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_2.setLayout(frmlytSch);

		srhBusoprRgstnum = new ComboBox<BaseModel>();
		srhBusoprRgstnum.setName("srhBusoprRgstnum");
		srhBusoprRgstnum.setHideLabel(true);
		srhBusoprRgstnum.setForceSelection(true);
		srhBusoprRgstnum.setMinChars(1);
		srhBusoprRgstnum.setDisplayField("busoprRgstnum");
		srhBusoprRgstnum.setValueField("busoprRgstnum");
		srhBusoprRgstnum.setTriggerAction(TriggerAction.ALL);
		srhBusoprRgstnum.setEmptyText("--원천신고부서--");
		srhBusoprRgstnum.setSelectOnFocus(false);
		srhBusoprRgstnum.setReadOnly(false);
		srhBusoprRgstnum.setEnabled(true);
		srhBusoprRgstnum.setStore(lsBusoprRgstnum);
		srhBusoprRgstnum.setLabelSeparator("");
//		srhBusoprRgstnum.setFieldLabel("사업자등록번호");
		lsRepbtyBusinDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});
		layoutContainer_16_2.add(srhBusoprRgstnum, new FormData("100%"));
		layoutContainer_16.add(layoutContainer_16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));		
		
        
        lcSchCol3.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
        lcSchCol3.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 성명, 주민등록번호
        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
        
		fieldSet.add(lcSchCol3);
		

		plFrmYeta1300.add(fieldSet);
		// vp.add(panel);
	}

	/**
	 * 기본사항
	 */
	private LayoutContainer createTabForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FormLayout());
		layoutContainer.setBorders(false);

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");

		fieldSet.setSize(670, 510);
//		fieldSet.setSize(670, 550);


		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeaderVisible(false);
		cntntpnlNewContentpanel.setCollapsible(false);
		cntntpnlNewContentpanel.setFrame(true);
		cntntpnlNewContentpanel.setLayout(new FlowLayout());

//		final TabPanel tabsYeta1300 = new TabPanel();
		tabsYeta1300 = new TabPanel();
		
		
		//하위탭을 선택하였을 경우 관련된 정보를 가져온다.
		tabsYeta1300.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				
				//탭선택
//				yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), tabsYeta1300.getSelectedItem().getId()); 
				//reFresh(tabsYeta1300.getSelectedItem().getId());
					
			}
		});

		// tabsPsnl.setMinTabWidth(80);
		tabsYeta1300.setAutoWidth(false);
		// tabsPsnl.setResizeTabs(true);
		tabsYeta1300.setAnimScroll(false);
		tabsYeta1300.setTabScroll(true);
		tabsYeta1300.setPlain(true);
		tabsYeta1300.setSize(660, 520);
//		tabsYeta1300.setSize(660, 540);

		
		/** 우측 탭 시작 **/
		// 기본사항
		TabItem itemYeta01 = new TabItem();
		itemYeta01.setId("itemYeta01");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta01.setText("기본사항");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta01.setLayout(new FormLayout());
		itemYeta01.add(YetaData01(), new FormData("100%"));
		tabsYeta1300.add(itemYeta01);
		
		// 인적공제
		TabItem itemYeta02 = new TabItem();
		itemYeta02.setId("itemYeta02");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta02.setText("인적공제");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta02.setLayout(new FormLayout());
		itemYeta02.add(yetaData02(), new FormData("100%"));
		tabsYeta1300.add(itemYeta02);
		
		// 소득공제
		TabItem itemYeta03 = new TabItem();
		itemYeta03.setId("itemYeta03");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta03.setText("소득공제");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta03.setLayout(new FormLayout());
		itemYeta03.add(yetaData03(), new FormData("100%"));
		tabsYeta1300.add(itemYeta03);
		
		// 연금보험료공제
		TabItem itemYeta04 = new TabItem();
		itemYeta04.setId("itemYeta04");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta04.setText("연금보험료공제");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta04.setLayout(new FormLayout());
		itemYeta04.add(yetaData04(), new FormData("100%"));
		tabsYeta1300.add(itemYeta04);		
		
		
		// 특별소득공제
		TabItem itemYeta05 = new TabItem();
		itemYeta05.setId("itemYeta05");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta05.setText("특별소득공제");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta05.setLayout(new FormLayout());
		itemYeta05.add(yetaData05(), new FormData("100%"));
		tabsYeta1300.add(itemYeta05);		

		
		// 그밖의소득공제1
		TabItem itemYeta06 = new TabItem();
		itemYeta06.setId("itemYeta06");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta06.setText("그밖의소득공제1");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta06.setLayout(new FormLayout());
		itemYeta06.add(yetaData06(), new FormData("100%"));
		tabsYeta1300.add(itemYeta06);

		
		// 그밖의소득공제2
		TabItem itemYeta07 = new TabItem();
		itemYeta07.setId("itemYeta07");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta07.setText("그밖의소득공제2");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta07.setLayout(new FormLayout());
		itemYeta07.add(yetaData07(), new FormData("100%"));
		tabsYeta1300.add(itemYeta07);

		// 세액감면및세액공제1
		TabItem itemYeta08 = new TabItem();
		itemYeta08.setId("itemYeta08");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta08.setText("세액감면및세액공제1");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta08.setLayout(new FormLayout());
		itemYeta08.add(yetaData08(), new FormData("100%"));
		tabsYeta1300.add(itemYeta08);		
		

		// 세액감면및세액공제2
		TabItem itemYeta09 = new TabItem();
		itemYeta09.setId("itemYeta09");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta09.setText("세액감면및세액공제2");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta09.setLayout(new FormLayout());
		itemYeta09.add(yetaData09(), new FormData("100%"));
		tabsYeta1300.add(itemYeta09);			

		// 추가제출서류
		TabItem itemYeta10 = new TabItem();
		itemYeta10.setId("itemYeta10");
		//itemPsnl0111.setStyleAttribute("padding", "10px");
		itemYeta10.setText("추가제출서류");
		//itemPsnl0111.addStyleName("pad-text");
		itemYeta10.setLayout(new FormLayout());
		itemYeta10.add(yetaData10(), new FormData("100%"));
		tabsYeta1300.add(itemYeta10);	
		

		fieldSet.add(tabsYeta1300);

		layoutContainer.add(fieldSet);
		return layoutContainer;
	}


	
	 //인적공제명세 grid
	 private LayoutContainer occupationalRBottom2() {

		 FieldSet fieldSetGrd = new FieldSet();  
		 fieldSetGrd.setHeadingHtml("인적공제명세");
		    
		 LayoutContainer lcStdGrid = new LayoutContainer();
		 FormLayout frmlytStd = new FormLayout();  
		 lcStdGrid.setLayout(frmlytStd);  
		    
		 ContentPanel cpGrid = new ContentPanel();   
		 cpGrid.setBodyBorder(false); 
		 cpGrid.setHeaderVisible(false);   
		 cpGrid.setLayout(new FitLayout());      
		 cpGrid.setSize(650, 320);  
		    
		 yeta1300ToYeta3220GridPanel1 = new MSFGridPanel(Yeta3220Def_01, false, false, false, false, false);
		 yeta1300ToYeta3220GridPanel1.setHeaderVisible(false);  
		 yeta1300ToYeta3220GridPanel1.setBodyBorder(true);
		 yeta1300ToYeta3220GridPanel1.setBorders(true);
		 
		 
		 /** --- grid 체크 컬럼 --- **/
//		 // 기본
//		 final Grid<BaseModel> grid5 = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid();
//         final ColumnModel columnModel1 =  grid5.getColumnModel();
//         final List<ColumnConfig> columnConfigs1 = columnModel1.getColumns();
//         final CheckColumnConfig check1 = new CheckColumnConfig("select", "기본", 55); 
//         check1.setAlignment(Style.HorizontalAlignment.CENTER);		            
//         check1.setEditor(columnConfigs1.get(5).getEditor());
//         columnConfigs1.set(5, check1);
//
//         check1.setRenderer(columnConfigs1.get(5).getRenderer());  
//         grid5.addPlugin(check1);
//         grid5.getView().setForceFit(true);
//         
//         
//         // 부녀자
//		 final Grid<BaseModel> grid6 = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid();
//         final ColumnModel columnModel2 =  grid6.getColumnModel();
//         final List<ColumnConfig> columnConfigs2 = columnModel2.getColumns();
//         final CheckColumnConfig check2 = new CheckColumnConfig("select", "부녀자", 55); 
//         check2.setAlignment(Style.HorizontalAlignment.CENTER);		            
//         check2.setEditor(columnConfigs2.get(6).getEditor());
//         columnConfigs2.set(6, check2);
//
//         check2.setRenderer(columnConfigs2.get(6).getRenderer());  
//         grid6.addPlugin(check2);
//         grid6.getView().setForceFit(true);
//         
//         
//         // 경로
//         final Grid<BaseModel> grid7 = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid();
//         final ColumnModel columnModel3 = grid6.getColumnModel();
//         final List<ColumnConfig> columnConfigs3 = columnModel3.getColumns();
//         final CheckColumnConfig check3 = new CheckColumnConfig("select", "경로",55);
//         check3.setAlignment(Style.HorizontalAlignment.CENTER);
//         check3.setEditor(columnConfigs3.get(7).getEditor());
//         columnConfigs3.set(7, check3);
//
//         check3.setRenderer(columnConfigs3.get(7).getRenderer());
//         grid7.addPlugin(check3);
//         grid7.getView().setForceFit(true);
//		 
//		 
//         // 출산
//         final Grid<BaseModel> grid8 = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid();
//         final ColumnModel columnModel4 = grid8.getColumnModel();
//         final List<ColumnConfig> columnConfigs4 = columnModel4.getColumns();
//         final CheckColumnConfig check4 = new CheckColumnConfig("select", "출산",55);
//         check4.setAlignment(Style.HorizontalAlignment.CENTER);
//         check4.setEditor(columnConfigs4.get(8).getEditor());
//         columnConfigs4.set(8, check4);
//
//         check4.setRenderer(columnConfigs4.get(8).getRenderer());
//         grid8.addPlugin(check4);
//         grid8.getView().setForceFit(true);
//         
//         
//         // 6세
//         final Grid<BaseModel> grid10 = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid();
//         final ColumnModel columnModel5 = grid10.getColumnModel();
//         final List<ColumnConfig> columnConfigs5 = columnModel5.getColumns();
//         final CheckColumnConfig check5 = new CheckColumnConfig("select", "6세",55);
//         check5.setAlignment(Style.HorizontalAlignment.CENTER);
//         check5.setEditor(columnConfigs4.get(10).getEditor());
//         columnConfigs5.set(10, check5);
//
//         check5.setRenderer(columnConfigs5.get(10).getRenderer());
//         grid10.addPlugin(check5);
//         grid10.getView().setForceFit(true);
//         
//         
//         // 한부모
//         final Grid<BaseModel> grid11 = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid();
//         final ColumnModel columnModel6 = grid11.getColumnModel();
//         final List<ColumnConfig> columnConfigs6 = columnModel6.getColumns();
//         final CheckColumnConfig check6 = new CheckColumnConfig("select", "한부모", 55);
//         check6.setAlignment(Style.HorizontalAlignment.CENTER);
//         check6.setEditor(columnConfigs6.get(11).getEditor());
//         columnConfigs6.set(11, check6);
//
//         check6.setRenderer(columnConfigs6.get(11).getRenderer());
//         grid11.addPlugin(check6);
//         grid11.getView().setForceFit(true);
         /** --- grid 체크 컬럼 --- **/
         
         
		    
		 cpGrid.add(yeta1300ToYeta3220GridPanel1); 
		    
		 lcStdGrid.add(cpGrid);
		    
		 return lcStdGrid;		 

	 }
	 
	 //소득공제명세 grid(합계)
	 private LayoutContainer occupationalRBottom3() {
		 
		 FieldSet fieldSetGrd = new FieldSet();  
		 fieldSetGrd.setHeadingHtml("합계");
		 fieldSetGrd.setBorders(false);
		 
		 LayoutContainer lcStdGrid = new LayoutContainer();
		 FormLayout frmlytStd = new FormLayout();  
		 lcStdGrid.setLayout(frmlytStd);  
		    
		 ContentPanel cpGrid = new ContentPanel();  
		 cpGrid.setBodyBorder(false); 
		 cpGrid.setHeaderVisible(false);   
		 cpGrid.setLayout(new FitLayout());      
		 cpGrid.setSize(610, 80);  
		    
		 yeta1300ToYeta3220GridPanel4 = new MSFGridPanel(Yeta3220Def_02_SUM, false, false, false, false, false);
		 yeta1300ToYeta3220GridPanel4.setHeaderVisible(false);  
		 yeta1300ToYeta3220GridPanel4.setBodyBorder(true);
		 yeta1300ToYeta3220GridPanel4.setBorders(true);
		 yeta1300ToYeta3220GridPanel4.getBottomComponent().setVisible(false);
		 
		 yeta1300ToYeta3220GridPanel4.getGrid().getColumnModel().addHeaderGroup(0, 3, new HeaderGroupConfig("보험료", 1, 3));
		 yeta1300ToYeta3220GridPanel4.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("신용카드 등 사용액", 1, 5)); 
		    
		 cpGrid.add(yeta1300ToYeta3220GridPanel4); 
		    
		 lcStdGrid.add(cpGrid);
		 fieldSetGrd.add(lcStdGrid);
		 return fieldSetGrd;		 		 
	
	 }
	 
	 //소득공제명세 grid(국세청자료)
	 private LayoutContainer occupationalRBottom3_01() {
		 
		 FieldSet fieldSetGrd = new FieldSet();  
		 fieldSetGrd.setHeadingHtml("국세청자료");
		 fieldSetGrd.setBorders(false);
		 
		 LayoutContainer lcStdGrid = new LayoutContainer();
		 FormLayout frmlytStd = new FormLayout();  
		 lcStdGrid.setLayout(frmlytStd);  
		    
		 ContentPanel cpGrid = new ContentPanel();   
		 cpGrid.setBodyBorder(false); 
		 cpGrid.setHeaderVisible(false);   
		 cpGrid.setLayout(new FitLayout());      
		 cpGrid.setSize(620, 200);  
		    
		 yeta1300ToYeta3220GridPanel2 = new MSFGridPanel(Yeta3220Def_02_01, false, false, false, false, false);
		 yeta1300ToYeta3220GridPanel2.setHeaderVisible(false);  
		 yeta1300ToYeta3220GridPanel2.setBodyBorder(true);
		 yeta1300ToYeta3220GridPanel2.setBorders(true);
		 yeta1300ToYeta3220GridPanel2.getBottomComponent().setVisible(false);
		 yeta1300ToYeta3220GridPanel2.getGrid().getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("보험료", 1, 4));
		 yeta1300ToYeta3220GridPanel2.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("신용카드 등 사용액", 1, 5));
		 
		 
		 AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//			GWTUtils.findColumnConfig(yetaP03001GridPanel, Yeta3170BM.ATTR_CTRBAMNT).setStyle("Height:20px;");
			
		 payrSummaryRow.setHtml(Ye16Ta3220BM.ATTR_KORNNAME, "합 계");  
		 payrSummaryRow.setCellStyle(Ye16Ta3220BM.ATTR_KORNNAME,"summary_color");	/** column 성명 : kornName */
		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_INSUPAYR, SummaryType.SUM);  
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_INSUGOPY, SummaryType.SUM);  
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_INSUPAYR, SummaryType.SUM);  
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_INSURTYR, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_PSCLIURR, SummaryType.SUM); 
		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_MEDICOST, SummaryType.SUM); 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_EDUCCOST, SummaryType.SUM);  
		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_CDTECARD, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_JIBLCARD, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_CASHRECE, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_MGNTSTVD, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_GRPYAMNT, SummaryType.SUM); 
		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_CTRBAMNT, SummaryType.SUM);   
		 

		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_INSUPAYR, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료_건강고용등국세청 : insuPayr */
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_INSUGOPY, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료_건강고용등국세청 : insuPayr */
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_INSURTYR, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료보장성_국세청 : insuRtyr */
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_PSCLIURR, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료장애인보장성_국세청 : psclIurr */    
		 
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_MEDICOST, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 의료비_국세청 : mediCost */  
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_EDUCCOST, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 교육비_국세청 : educCost */   
		 
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_CDTECARD, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 신용카드등_국세청 : cdteCard */   
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_JIBLCARD, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 직불카드등_국세청 : jiblCard */    
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_CASHRECE, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 현금영수증_국세청 : cashRece */     
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_MGNTSTVD, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 전통시장사용분_국세청 : mgntStvd */   
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_GRPYAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 지로납부액_대중교통_국세청 : grpyAmnt */   
		 
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_CTRBAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 기부금액_국세청 : ctrbAmnt */   
		 
		 
		 yeta1300ToYeta3220GridPanel2.getGrid().getColumnModel().addAggregationRow(payrSummaryRow); 
		    
		 
		 cpGrid.add(yeta1300ToYeta3220GridPanel2); 
		    
		 lcStdGrid.add(cpGrid);
		 fieldSetGrd.add(lcStdGrid);
		 
		 
		 return fieldSetGrd;		 		 
	 }
	 
	 //소득공제명세 grid(기타자료)
	 private LayoutContainer occupationalRBottom3_02() {
		 
		 FieldSet fieldSetGrd = new FieldSet();  
		 fieldSetGrd.setHeadingHtml("기타자료");
		 fieldSetGrd.setBorders(false);
		 
		 LayoutContainer lcStdGrid = new LayoutContainer();
		 FormLayout frmlytStd = new FormLayout();  
		 lcStdGrid.setLayout(frmlytStd);  
		    
		 ContentPanel cpGrid = new ContentPanel();  
		 cpGrid.setBodyBorder(false); 
		 cpGrid.setHeaderVisible(false);   
		 cpGrid.setLayout(new FitLayout());      
		 cpGrid.setSize(620, 200);  
		    
		 yeta1300ToYeta3220GridPanel3 = new MSFGridPanel(Yeta3220Def_02_02, false, false, false, false, false);
		 yeta1300ToYeta3220GridPanel3.setHeaderVisible(false);  
		 yeta1300ToYeta3220GridPanel3.setBodyBorder(true);
		 yeta1300ToYeta3220GridPanel3.setBorders(true);
		 yeta1300ToYeta3220GridPanel3.getBottomComponent().setVisible(false);
		 
		 yeta1300ToYeta3220GridPanel3.getGrid().getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("보험료", 1, 4));
		 yeta1300ToYeta3220GridPanel3.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("신용카드 등 사용액", 1, 5)); 
		 
		 
		 AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
//			GWTUtils.findColumnConfig(yetaP03001GridPanel, Yeta3170BM.ATTR_CTRBAMNT).setStyle("Height:20px;");
			
		 payrSummaryRow.setHtml(Ye16Ta3220BM.ATTR_KORNNAME, "합 계");  
		 payrSummaryRow.setCellStyle(Ye16Ta3220BM.ATTR_KORNNAME,"summary_color");	/** column 성명 : kornName */

		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_INSUFETC, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_INSUGOEC, SummaryType.SUM);  
		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_INSURTET, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_PSCLIURT, SummaryType.SUM); 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_MEDIEXPS, SummaryType.SUM); 
		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_EDUCOTEC, SummaryType.SUM);  
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_CDTECDEC, SummaryType.SUM);  
		 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_JIBLCDEC, SummaryType.SUM);   
//		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_TEMP, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_MGNTSDEC, SummaryType.SUM);   
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_GRPYATEC, SummaryType.SUM); 
		 payrSummaryRow.setSummaryType(Ye16Ta3220BM.ATTR_CTRBAMEC, SummaryType.SUM);  
		 
		 
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_INSUFETC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료_건강고용등외 : insuFetc */
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_INSUGOEC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료_건강고용등외 : insuFetc */
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_INSURTET, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료보장성외 : insuRtet */
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_PSCLIURT, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 보험료장애인보장성외 : psclIurt */   
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_MEDIEXPS, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 의료비외 : mediExps */ 
		 
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_EDUCOTEC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 교육비외 : educOtec */  
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_CDTECDEC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 신용카드외 : cdteCdec */ 
		 
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_JIBLCDEC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 직불카드외 : jiblCdec */   
//		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_TEMP, NumberFormat.getFormat("#,##0;(#,##0)"));	/** column 현금영수증   */  
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_MGNTSDEC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 전통시장사용분외 : mgntSdec */  
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_GRPYATEC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 지로납부액_대중교통외 : grpyAtec */   
		 payrSummaryRow.setSummaryFormat(Ye16Ta3220BM.ATTR_CTRBAMEC, NumberFormat.getFormat("#,##0;(#,##0)"));/** column 기부금액외 : ctrbAmec */  
		 
		 yeta1300ToYeta3220GridPanel3.getGrid().getColumnModel().addAggregationRow(payrSummaryRow); 
		    
		 cpGrid.add(yeta1300ToYeta3220GridPanel3); 
		    
		 lcStdGrid.add(cpGrid);
		 fieldSetGrd.add(lcStdGrid);
		 
		 
		 return fieldSetGrd;		 		 
	
	 }
	
	 //가족교육비 grid
	 private LayoutContainer occupationalRBottom4() {
		 
		 LayoutContainer lcStdGrid = new LayoutContainer();
		 FormLayout frmlytStd = new FormLayout();  
		 lcStdGrid.setLayout(frmlytStd);  
		    
		 ContentPanel cpGrid = new ContentPanel();   
		 cpGrid.setBodyBorder(false); 
		 cpGrid.setHeaderVisible(false);   
		 cpGrid.setLayout(new FitLayout());      
		 cpGrid.setSize(320, 130);  
		    
		 
		 yeta1300ToYeta3150GridPanel = new MSFGridPanel(Yeta3150Def_01, false, false, false, false, false);
		 yeta1300ToYeta3150GridPanel.setHeaderVisible(false);  
		 yeta1300ToYeta3150GridPanel.setBodyBorder(true);
		 yeta1300ToYeta3150GridPanel.setBorders(true);
		 yeta1300ToYeta3150GridPanel.getBottomComponent().setVisible(false);
		    
		 cpGrid.add(yeta1300ToYeta3150GridPanel); 
		    
		 lcStdGrid.add(cpGrid);
		    
		 return lcStdGrid;		 		 

	 }
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 상세정보 tab 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
		// 기본사항
		private LayoutContainer YetaData01() {
			
			LayoutContainer lcTabFormLayer = new LayoutContainer();
			
			ContentPanel cp01 = new ContentPanel();
			cp01.setHeaderVisible(false);
			cp01.setHeadingText("");
			cp01.setSize("660", "450");

			LayoutContainer layoutContainer_8 = new LayoutContainer();
			FormLayout frmlytSch2_1 = new FormLayout();
			frmlytSch2_1.setLabelWidth(90);
			frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_8.setLayout(frmlytSch2_1);
			
			LayoutContainer layoutContainer_18 = new LayoutContainer();
			frmlytSch2_1 = new FormLayout();
			frmlytSch2_1.setLabelWidth(90);
			frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_18.setLayout(frmlytSch2_1);
			
			FieldSet fldstNewFieldset = new FieldSet();

			LayoutContainer layoutContainer_21 = new LayoutContainer();
			layoutContainer_21.setLayout(new ColumnLayout());

			LayoutContainer layoutContainer_23 = new LayoutContainer();
			frmlytSch2_1 = new FormLayout();
			frmlytSch2_1.setLabelWidth(90);
			frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_23.setLayout(frmlytSch2_1);
			layoutContainer_23.setBorders(false);

			LayoutContainer layoutContainer_26 = new LayoutContainer(); 
		 
			layoutContainer_26.setLayout(new ColumnLayout());

			LayoutContainer layoutContainer_470 = new LayoutContainer();
			 
			
			LabelField lblfldNewLabelfield = new LabelField("세대주:");
			lblfldNewLabelfield.setStyleAttribute("textAlign", "RIGHT");
			layoutContainer_470.add(lblfldNewLabelfield);
			layoutContainer_26.add(layoutContainer_470, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			layoutContainer_470.setBorders(false);
			
			
			gnanSgtf= new RadioGroup();
			gnanSgtf.setFieldLabel("세대주구분");
		  //  gnanSgtf.setHeight("세대주구분");
			
			Radio gnanSgtf1 = new Radio();
//			layoutContainer_26.add(rdNewRadio);
			gnanSgtf.add(gnanSgtf1);
			gnanSgtf1.setBoxLabel("세대주");
			gnanSgtf1.setHideLabel(true);
			gnanSgtf1.setValueAttribute("1");

			Radio gnanSgtf0 = new Radio();
			gnanSgtf.add(gnanSgtf0);
//			layoutContainer_26.add(rdNewRadio_1);
			gnanSgtf0.setBoxLabel("세대원");
			gnanSgtf0.setHideLabel(true);
			gnanSgtf0.setValueAttribute("0");
			
			layoutContainer_26.add(gnanSgtf, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

			layoutContainer_23.add(layoutContainer_26, new FormData("100%"));
			layoutContainer_21.add(layoutContainer_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

			
			
			LayoutContainer layoutContainer_25 = new LayoutContainer();
			layoutContainer_25.setLayout(new ColumnLayout());

			//
			LayoutContainer layoutContainer_32 = new LayoutContainer();
			frmlytSch2_1 = new FormLayout();
			frmlytSch2_1.setLabelWidth(90);
			frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_32.setLayout(frmlytSch2_1);
			
			reymStdt = new MSFDateField();
//			emymtBgnnDt.setWidth(100);
			reymStdt.setFieldLabel("근무기간");
			reymStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			layoutContainer_32.add(reymStdt, new FormData("100%"));
//			reymStdt.setHeight("");

			layoutContainer_32.setBorders(false);


			//
			LayoutContainer layoutContainer_34 = new LayoutContainer();
//			layoutContainer_34.setWidth(100);
			FormLayout frmlytSch2_11 = new FormLayout();
			frmlytSch2_11.setLabelWidth(10);
//			frmlytSch2_1.setLabelWidth(100);
//			frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_34.setLayout(frmlytSch2_11);

			reymEddt = new MSFDateField();
//			emymtEndDt.setWidth(100);
			reymEddt.setLabelSeparator("~");
			reymEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			layoutContainer_34.add(reymEddt, new FormData("100%"));

			layoutContainer_34.setBorders(false);
			layoutContainer_23.add(layoutContainer_25, new FormData("100%"));


			// 근무기간 add
			layoutContainer_25.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
			layoutContainer_25.add(layoutContainer_34, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

			LayoutContainer layoutContainer_27 = new LayoutContainer();
			layoutContainer_27.setLayout(new ColumnLayout());

			LayoutContainer layoutContainer_457 = new LayoutContainer();
			layoutContainer_457.setBorders(false);

			LabelField lblfldNewLabelfield_1 = new LabelField("거주지구분: ");
			lblfldNewLabelfield_1.setStyleAttribute("textAlign", "RIGHT");
			layoutContainer_457.setStyleAttribute("verticalAlign","bottom");
			layoutContainer_457.add(lblfldNewLabelfield_1);
			layoutContainer_27.add(layoutContainer_457, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

			resdFlag = new RadioGroup();
			
			Radio resdFlag1 = new Radio();
			resdFlag.add(resdFlag1);
			resdFlag1.setBoxLabel("거주자");
			resdFlag1.setHideLabel(true);
			resdFlag1.setValueAttribute("1");

			Radio resdFlag0 = new Radio();
			resdFlag.add(resdFlag0);
			resdFlag0.setBoxLabel("비거주자");
			resdFlag0.setHideLabel(true);
			resdFlag0.setValueAttribute("0");
			
			layoutContainer_27.add(resdFlag, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			
			layoutContainer_23.add(layoutContainer_27, new FormData("100%"));

			LayoutContainer layoutContainer_24 = new LayoutContainer();
			layoutContainer_24.setBorders(false);

			LayoutContainer lucnNatn = new LayoutContainer(new ColumnLayout());
			LayoutContainer lucnNatn1_1 = new LayoutContainer();
			
			Button btnNatnCd = new Button();
			btnNatnCd.setIcon(MSFMainApp.ICONS.search());
			btnNatnCd.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	            	if (MSFSharedUtils.allowNulls(natnName.getValue()).trim().equals("")) {
	            		natnGbcd.setValue("");
	                }
	            	fnPopupBass0300("A001", "natn");
	            }
	        });
				
			
			natnName = new TextFieldWithButton<String>(btnNatnCd);
			FormLayout frmlytSch2 = new FormLayout();
			frmlytSch2.setLabelWidth(100);
			frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
			lucnNatn1_1.setLayout(frmlytSch2);
			natnName.setFieldLabel("국 적");
			
			natnGbcd = new HiddenField<String>();
			natnGbcd.setName("natnGbcd");
			natnGbcd.setFieldLabel("natnGbcd");
			natnName.addKeyListener(new KeyListener() {
				@Override
	            public void componentKeyDown(ComponentEvent event) {
	              
	                natnGbcd.validate();
	                if (MSFSharedUtils.allowNulls(natnName.getValue()).trim().equals("")) {
	                	natnGbcd.setValue("");
	                }if (MSFSharedUtils.paramNull(natnName.getValue())) {
	                	natnGbcd.setValue("");
	                }   
	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                	//if (MSFSharedUtils.allowNulls(natnName.getValue()).trim().equals("")) {
	                		natnName.setValue("");
	                		natnItem.setValue("");
	                    //	}
	                	   fnPopupBass0300("A001", "natn");
	                	}
	            	}
	           
	         	});
//			natnName.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(natnName.getValue()).trim().equals("")) {
//	                	natnGbcd.setValue("");
//	                }if (MSFSharedUtils.paramNull(natnName.getValue())) {
//	                	natnGbcd.setValue("");
//	                }   
//	            } 
//	        }); 
			lucnNatn1_1.add(natnName, new FormData("100%"));
			
			
			LayoutContainer lucnNatn1_2 = new LayoutContainer();
			FormLayout frmlytSch3 = new FormLayout();
			frmlytSch3.setLabelWidth(0);
			lucnNatn1_2.setLayout(frmlytSch3);
			natnItem = new TextField<String>();
			natnItem.setReadOnly(true);
			natnItem.setLabelSeparator("");
			natnItem.setEnabled(false);
			
			lucnNatn1_2.add(natnItem, new FormData("100%"));
			
			lucnNatn.add(lucnNatn1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			lucnNatn.add(lucnNatn1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			
			layoutContainer_24.add(lucnNatn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			LayoutContainer lcTabLeft = new LayoutContainer(new ColumnLayout());
			
			LayoutContainer lcTabLeft1_1 = new LayoutContainer();
			rutrStdt = new MSFDateField();
			new DateFieldMask(rutrStdt, "9999.99.99");
			rutrStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			FormLayout frmlytStd1_1 = new FormLayout();
			frmlytStd1_1.setLabelWidth(100);
			frmlytStd1_1.setLabelAlign(LabelAlign.RIGHT);
			lcTabLeft1_1.setLayout(frmlytStd1_1);
			rutrStdt.setFieldLabel("감면기간");
			lcTabLeft1_1.add(rutrStdt, new FormData("100%"));
			lcTabLeft.add(lcTabLeft1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
			
			LayoutContainer lcTabLeft1_2 = new LayoutContainer();
			rutrEddt = new MSFDateField();
			new DateFieldMask(rutrEddt, "9999.99.99");
			rutrEddt.setLabelSeparator("");
			rutrEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			FormLayout frmlytStd1_2 = new FormLayout();
			frmlytStd1_2.setLabelWidth(10);
			frmlytStd1_2.setLabelAlign(LabelAlign.RIGHT);
			lcTabLeft1_2.setLayout(frmlytStd1_2);
			rutrEddt.setFieldLabel("~");
			lcTabLeft1_2.add(rutrEddt, new FormData("100%"));
			lcTabLeft.add(lcTabLeft1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
			layoutContainer_24.add(lcTabLeft);

			LayoutContainer lucnRedt = new LayoutContainer(new ColumnLayout());
			LayoutContainer lucnRedt1_1 = new LayoutContainer();
			
			Button btnRedtCd = new Button();
			btnRedtCd.setIcon(MSFMainApp.ICONS.search());
			btnRedtCd.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	            	if (MSFSharedUtils.allowNulls(redtName.getValue()).trim().equals("")) {
	            		redtGbcd.setValue("");
	                }
	            	fnPopupBass0300("A001", "redt");
	            }
	        });
			
			redtName = new TextFieldWithButton<String>(btnRedtCd);
			frmlytSch2_1 = new FormLayout();
			frmlytSch2_1.setLabelWidth(100);
			frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
			lucnRedt1_1.setLayout(frmlytSch2_1);
			redtName.setFieldLabel("거주지국");
			
			redtGbcd = new HiddenField<String>();
			redtGbcd.setName("redtGbcd");
			redtGbcd.setFieldLabel("redtGbcd");
			redtName.addKeyListener(new KeyListener() {
				 @Override
	            public void componentKeyDown(ComponentEvent event) {
	              
	                redtGbcd.validate();
	                if (MSFSharedUtils.allowNulls(redtName.getValue()).trim().equals("")) {
	                	redtGbcd.setValue("");
	                }if (MSFSharedUtils.paramNull(redtName.getValue())) {
	                	redtGbcd.setValue("");
	                }   
	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                	if (MSFSharedUtils.allowNulls(redtName.getValue()).trim().equals("")) {
	                		redtName.setValue("");
	                		redtItem.setValue("");
	                    	}
	                	fnPopupBass0300("A001", "redt");
	                	}
	                super.componentKeyDown(event);
	            	}
				 
	         	});
//			redtName.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(redtName.getValue()).trim().equals("")) {
//	                	redtGbcd.setValue("");
//	                }if (MSFSharedUtils.paramNull(redtName.getValue())) {
//	                	redtGbcd.setValue("");
//	                }   
//	            } 
//	        }); 
			lucnRedt1_1.add(redtName, new FormData("100%"));
			
			
			LayoutContainer lucnRedt1_2 = new LayoutContainer();
			FormLayout frmlytSch3_1 = new FormLayout();
			frmlytSch3_1.setLabelWidth(0);
			lucnRedt1_2.setLayout(frmlytSch3_1);
			redtItem = new TextField<String>();
			redtItem.setReadOnly(true);
			redtItem.setLabelSeparator("");
			redtItem.setEnabled(false);
			
			lucnRedt1_2.add(redtItem, new FormData("100%"));
			
			lucnRedt.add(lucnRedt1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			lucnRedt.add(lucnRedt1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			
			layoutContainer_24.add(lucnRedt, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
			layoutContainer_21.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
			
			//-----------------------2016년 추가 필드   ------------------------------------------------------------------
			LayoutContainer layoutContainer_241 = new LayoutContainer(new ColumnLayout());
			LayoutContainer sub01 = new LayoutContainer(new ColumnLayout());
	
			LayoutContainer sub01_1 = new LayoutContainer();
			FormLayout sub11_1 = new FormLayout();
			sub11_1.setLabelWidth(70); 
			sub01_1.setLayout(sub11_1);
			yrenSgyn = new CheckBox(); 
			yrenSgyn.setName("yrenSgyn");
			yrenSgyn.setBoxLabel("정산분할납부");
			yrenSgyn.setHideLabel(true);
			yrenSgyn.setValueAttribute("Y");
			
			sub01_1.add(yrenSgyn, new FormData("100%"));
				
				
			LayoutContainer sub01_2 = new LayoutContainer(new ColumnLayout());
			FormLayout sub11_2 = new FormLayout();
			sub11_2.setLabelWidth(70);
			sub01_2.setLayout(sub11_2);
			frnrRnyn = new CheckBox(); 
			frnrRnyn.setName("frnrRnyn");
			frnrRnyn.setBoxLabel("외국법인파견");
			frnrRnyn.setHideLabel(true);
			frnrRnyn.setValueAttribute("Y"); 
				
			 sub01_2.add(frnrRnyn , new FormData("100%"));
			 
			 LayoutContainer sub01_t = new LayoutContainer();
			 sub01.add(sub01_t, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		 	 sub01.add(sub01_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			 sub01.add(sub01_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			
			LayoutContainer sub02 = new LayoutContainer();
			FormLayout sub02_1 = new FormLayout();
			sub02_1.setLabelWidth(70);
			sub02.setLayout(sub02_1);
			addIncmTxApptnRtoCd = new ComboBox<BaseModel>();
			addIncmTxApptnRtoCd.setName("addIncmTxApptnRtoCd"); 
			addIncmTxApptnRtoCd.setFieldLabel("소득세비율"); 
			addIncmTxApptnRtoCd.setDisplayField("commCdNm");
			addIncmTxApptnRtoCd.setValueField("commCd");
			addIncmTxApptnRtoCd.setTriggerAction(TriggerAction.ALL);
			addIncmTxApptnRtoCd.setSelectOnFocus(true);
			addIncmTxApptnRtoCd.setMinChars(1); 
			addIncmTxApptnRtoCd.setStore(lsAddIncmTxApptnRtoCd); 
			sub02.add(addIncmTxApptnRtoCd, new FormData("100%"));
			lsAddIncmTxApptnRtoCd.addStoreListener(new StoreListener<BaseModel>() {
				public void handleEvent(StoreEvent<BaseModel> be) {
					
					
				}
			});
			
			layoutContainer_241.add(sub01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			layoutContainer_241.add(sub02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			 
			layoutContainer_21.add(layoutContainer_241, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1)); 
			
			//-----------------------2016년 추가 필드   ------------------------------------------------------------------
			 

			fldstNewFieldset.add(layoutContainer_21, new FormData("100%"));
			layoutContainer_21.setBorders(false);
			layoutContainer_18.add(fldstNewFieldset, new FormData("100%"));
			fldstNewFieldset.setHeadingHtml("기본사항");
			layoutContainer_8.add(layoutContainer_18, new FormData("100%"));
//			layoutContainer_18.setHeight("100");

			// 소득기본사항
			LayoutContainer layoutContainer_19 = new LayoutContainer();
			layoutContainer_19.setHeight("");
			FieldSet fldstNewFieldset_1 = new FieldSet();
			fldstNewFieldset_1.setHeadingHtml("소득기본사항");

			LayoutContainer layoutContainer_38 = new LayoutContainer();
			layoutContainer_38.setBorders(false);
			layoutContainer_38.setLayout(new ColumnLayout());

			LayoutContainer layoutContainer_39 = new LayoutContainer();
			layoutContainer_39.setBorders(false);

			LayoutContainer layoutContainer_41 = new LayoutContainer();
			// layoutContainer_41.setLayout(new ColumnLayout());
			FormLayout frmlytSch101 = new FormLayout();
			frmlytSch101.setLabelWidth(170);
			frmlytSch101.setLabelAlign(LabelAlign.RIGHT); 
			layoutContainer_41.setLayout(frmlytSch101);
			// 종전근무지급여액
			LayoutContainer layoutContainer_42 = new LayoutContainer(); 
			FormLayout frmlytSch10 = new FormLayout();
			frmlytSch10.setLabelWidth(170);
			frmlytSch10.setLabelAlign(LabelAlign.RIGHT); 
			layoutContainer_42.setLayout(frmlytSch10);

			dcsnTots = new MSFNumberField();
			dcsnTots.setReadOnly(true);
			layoutContainer_42.add(dcsnTots, new FormData("100%"));
			dcsnTots.setFieldLabel("  종전근무지급여액");
			dcsnTots.setAllowDecimals(true); 
			dcsnTots.setPropertyEditorType(Long.class); 
			dcsnTots.setFormat(NumberFormat.getDecimalFormat());
			layoutContainer_41.add(layoutContainer_42, new FormData("100%"));

			// 주현근무지급여액
			LayoutContainer layoutContainer_43 = new LayoutContainer();
			layoutContainer_43.setBorders(false);

			FormLayout frmlytSch11 = new FormLayout();
			frmlytSch11.setLabelWidth(170);
			frmlytSch11.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_43.setLayout(frmlytSch11);

			currTots = new MSFNumberField();
			layoutContainer_43.add(currTots, new FormData("100%"));
			currTots.setFieldLabel("주현근무지급여액");
			currTots.setAllowDecimals(true); 
			currTots.setPropertyEditorType(Long.class); 
			currTots.setFormat(NumberFormat.getDecimalFormat());
			layoutContainer_41.add(layoutContainer_43, new FormData("100%"));

			// 총급여액
			LayoutContainer layoutContainer_44 = new LayoutContainer();
			layoutContainer_44.setBorders(false);

			FormLayout frmlytSch12 = new FormLayout();
			frmlytSch12.setLabelWidth(170);
			frmlytSch12.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_44.setLayout(frmlytSch12);

			totlSala = new MSFNumberField();
			totlSala.setReadOnly(true);
			layoutContainer_44.add(totlSala, new FormData("100%"));
			totlSala.setFieldLabel("총 급 여 액");
			totlSala.setAllowDecimals(true); 
			totlSala.setPropertyEditorType(Long.class); 
			totlSala.setFormat(NumberFormat.getDecimalFormat());
			layoutContainer_41.add(layoutContainer_44, new FormData("100%"));

			// 근로소득공제
			LayoutContainer layoutContainer_45 = new LayoutContainer();
			
			layoutContainer_45.setBorders(false);

			FormLayout frmlytSch13 = new FormLayout();
			frmlytSch13.setLabelWidth(170);
			frmlytSch13.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_45.setLayout(frmlytSch13);

			wkerDdct = new MSFNumberField();
			wkerDdct.setReadOnly(true);
			layoutContainer_45.add(wkerDdct, new FormData("100%"));
			wkerDdct.setFieldLabel("근로소득공제");
			wkerDdct.setAllowDecimals(true); 
			wkerDdct.setPropertyEditorType(Long.class); 
			wkerDdct.setFormat(NumberFormat.getDecimalFormat());
			layoutContainer_41.add(layoutContainer_45, new FormData("100%"));

			// 근로소득금액
			LayoutContainer layoutContainer_46 = new LayoutContainer();
			layoutContainer_46.setBorders(false);

			FormLayout frmlytSch14 = new FormLayout();
			frmlytSch14.setLabelWidth(170);
			frmlytSch14.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_46.setLayout(frmlytSch14);

			wkerAmnt = new MSFNumberField();
			wkerAmnt.setReadOnly(true);
			layoutContainer_46.add(wkerAmnt, new FormData("100%"));
			wkerAmnt.setFieldLabel("근로소득금액");
			wkerAmnt.setAllowDecimals(true); 
			wkerAmnt.setPropertyEditorType(Long.class); 
			wkerAmnt.setFormat(NumberFormat.getDecimalFormat());
			layoutContainer_41.add(layoutContainer_46, new FormData("100%"));

			// 종전근무지결정세액 소득세
			LayoutContainer layoutContainer_47 = new LayoutContainer();

			FormLayout frmlytSch15 = new FormLayout();
			frmlytSch15.setLabelWidth(170);
			frmlytSch15.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_47.setLayout(frmlytSch15);

			dcsnItax = new MSFNumberField();
			dcsnItax.setReadOnly(true);
			layoutContainer_47.add(dcsnItax, new FormData("100%"));
			dcsnItax.setFieldLabel("종전근무지결정세액  소득세");
			dcsnItax.setAllowDecimals(true); 
			dcsnItax.setPropertyEditorType(Long.class); 
			dcsnItax.setFormat(NumberFormat.getDecimalFormat());
			layoutContainer_41.add(layoutContainer_47, new FormData("100%"));

			// 주현근무지기납부세액
			LayoutContainer layoutContainer_48 = new LayoutContainer();

			FormLayout frmlytSch16 = new FormLayout();
			frmlytSch16.setLabelWidth(170);
			frmlytSch16.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_48.setLayout(frmlytSch16);

			alryPinx = new MSFNumberField();
			layoutContainer_48.add(alryPinx, new FormData("100%"));
			alryPinx.setFieldLabel("주현근무지기납부세액 소득세");
			alryPinx.setAllowDecimals(true); 
			alryPinx.setPropertyEditorType(Long.class); 
			alryPinx.setFormat(NumberFormat.getDecimalFormat());
			
			layoutContainer_41.add(layoutContainer_48, new FormData("100%"));

			layoutContainer_39.add(layoutContainer_41, new FormData("100%"));

			LayoutContainer layoutContainer_40 = new LayoutContainer();
			layoutContainer_40.setBorders(false);
			FormLayout frmlytSch131 = new FormLayout();
			frmlytSch131.setLabelWidth(170);
			frmlytSch131.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_40.setLayout(frmlytSch131);
			
			// 종전근무지등록
			LayoutContainer layoutContainer_49 = new LayoutContainer();
			layoutContainer_40.add(layoutContainer_49, new FormData("100%"));
			layoutContainer_49.setBorders(false);

			Button btnNewButton = new Button("종전근무지등록");
			btnNewButton.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			            return;
			        }
					
					//전체내역  
					YetaP13006 yetaP03006Form = new YetaP13006(ActionDatabase.READ, getThis());   
							    
					MSFFormWindows msFwYeta13006 = new MSFFormWindows("종전근무지등록", yetaP03006Form, "닫기", "820px", "710px", true);
					msFwYeta13006.show();
					yetaP03006Form.setMSFFormWindows(msFwYeta13006);
					
					funcSetPopUpRecord();
					//TODO 추후 주석해제 
					yetaP03006Form.bind(ppRecord); 
				}
			});			
			layoutContainer_49.add(btnNewButton);

			
			
				
			// 주현근무지등록
//			LayoutContainer layoutContainer_49_2 = new LayoutContainer();
//			layoutContainer_40.add(layoutContainer_49_2);
//			layoutContainer_49_2.setBorders(false);

//			Button btnNewButton1 = new Button("주현근무지등록");
//			btnNewButton1.addListener(Events.Select, new Listener<ButtonEvent>() {
//				public void handleEvent(ButtonEvent e) {
//					//전체내역  
//					YetaP13009 yetaP03009Form = new YetaP13009(ActionDatabase.READ, getThis());   
//										    
//					MSFFormWindows msFwYeta13009 = new MSFFormWindows("주현근무지등록", yetaP03009Form, "닫기", "820px", "710px", true);
//					msFwYeta13009.show();
//					yetaP03009Form.setMSFFormWindows(msFwYeta13009);
//					//TODO 추후 주석해제 
////										yetaP3001Form.bind(ppRecord); 
//					}
//				});			
//			layoutContainer_49_2.add(btnNewButton1);
			
			
			
			// 주현근무지등록
			LayoutContainer layoutContainer_50 = new LayoutContainer();
			
			Button btnNewButton1 = new Button("현비과세및감면소득");
			btnNewButton1.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					//전체내역  
					YetaP13008 yetaP03008Form = new YetaP13008(ActionDatabase.READ, getThis());   
										    
					MSFFormWindows msFwYeta13008 = new MSFFormWindows("현비과세및감면", yetaP03008Form, "닫기", "820px", "710px", true);
					msFwYeta13008.show();
					yetaP03008Form.setMSFFormWindows(msFwYeta13008);
					
					funcSetPopUpRecord();
				 
					yetaP03008Form.bind(ppRecord); 
					}
				});			
			layoutContainer_50.add(btnNewButton1);
			
//			layoutContainer_50.setHeight(28);
			layoutContainer_40.add(layoutContainer_50, new FormData("100%"));
//			layoutContainer_50.setHeight("26");
//
//			LayoutContainer layoutContainer_51 = new LayoutContainer();
//			layoutContainer_51.setHeight(28);
//			layoutContainer_40.add(layoutContainer_51, new FormData("100%"));
////			layoutContainer_51.setHeight("26");
//
//			LayoutContainer layoutContainer_52 = new LayoutContainer();
//			layoutContainer_52.setHeight(28);
//			layoutContainer_40.add(layoutContainer_52, new FormData("100%"));
////			layoutContainer_52.setHeight("26");

			//종합소득과세표준 
			LayoutContainer layoutContainer_a53 = new LayoutContainer();
			layoutContainer_a53.setBorders(false);

			FormLayout frmlytSch17 = new FormLayout();
			frmlytSch17.setLabelWidth(170);
			frmlytSch17.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_a53.setLayout(frmlytSch17);

			stndIncm = new  MSFNumberField();
			stndIncm.setReadOnly(true);
			layoutContainer_a53.add(stndIncm, new FormData("100%"));
			stndIncm.setFieldLabel("종합소득과세표준");
			stndIncm.setAllowDecimals(true); 
			stndIncm.setPropertyEditorType(Long.class); 
			stndIncm.setFormat(NumberFormat.getDecimalFormat());
			
			layoutContainer_40.add(layoutContainer_a53, new FormData("100%"));
			//산출세액 
			LayoutContainer layoutContainer_b53 = new LayoutContainer();
			layoutContainer_b53.setBorders(false);

			  frmlytSch17 = new FormLayout();
			frmlytSch17.setLabelWidth(170);
			frmlytSch17.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_b53.setLayout(frmlytSch17);

			prddTaxn = new MSFNumberField();
			prddTaxn.setReadOnly(true);
			layoutContainer_b53.add(prddTaxn, new FormData("100%"));
			prddTaxn.setFieldLabel("산출세액");
			prddTaxn.setAllowDecimals(true); 
			prddTaxn.setPropertyEditorType(Long.class); 
			prddTaxn.setFormat(NumberFormat.getDecimalFormat());
			
			layoutContainer_40.add(layoutContainer_b53, new FormData("100%"));
			
			// 근로소득세액공제
			LayoutContainer layoutContainer_53 = new LayoutContainer();
			layoutContainer_53.setBorders(false);

			  frmlytSch17 = new FormLayout();
			frmlytSch17.setLabelWidth(170);
			frmlytSch17.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_53.setLayout(frmlytSch17);

			taxdWken = new   MSFNumberField();
			taxdWken.setReadOnly(true);
			layoutContainer_53.add(taxdWken, new FormData("100%"));
			taxdWken.setFieldLabel("근로소득세액공제");
			taxdWken.setAllowDecimals(true); 
			taxdWken.setPropertyEditorType(Long.class); 
			taxdWken.setFormat(NumberFormat.getDecimalFormat());
			
			layoutContainer_40.add(layoutContainer_53, new FormData("100%"));

			// 지방소득세
			LayoutContainer layoutContainer_54 = new LayoutContainer();

			FormLayout frmlytSch18 = new FormLayout();
			frmlytSch18.setLabelWidth(170);
			frmlytSch18.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_54.setLayout(frmlytSch18);

			//결정세액_주민세_지방소득세 
			dcsnBtax = new  MSFNumberField();
			dcsnBtax.setReadOnly(true);
			layoutContainer_54.add(dcsnBtax, new FormData("100%"));
			dcsnBtax.setFieldLabel("지방소득세");
			dcsnBtax.setAllowDecimals(true); 
			dcsnBtax.setPropertyEditorType(Long.class); 
			dcsnBtax.setFormat(NumberFormat.getDecimalFormat());
			
			layoutContainer_40.add(layoutContainer_54, new FormData("100%"));

			//기납부세액_주민세_지방세
			LayoutContainer layoutContainer_55 = new LayoutContainer();

			FormLayout frmlytSch19 = new FormLayout();
			frmlytSch19.setLabelWidth(170);
			frmlytSch19.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_55.setLayout(frmlytSch19);

			alryPhbx = new MSFNumberField();
			layoutContainer_55.add(alryPhbx, new FormData("100%"));
			alryPhbx.setFieldLabel("지방소득세");
			alryPhbx.setAllowDecimals(true); 
			alryPhbx.setPropertyEditorType(Long.class); 
			alryPhbx.setFormat(NumberFormat.getDecimalFormat());
			layoutContainer_40.add(layoutContainer_55, new FormData("100%"));

			// layoutContainer_38 add
			layoutContainer_38.add(layoutContainer_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			layoutContainer_38.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

			fldstNewFieldset_1.add(layoutContainer_38, new FormData("100%"));
			layoutContainer_19.add(fldstNewFieldset_1, new FormData("100%"));
			layoutContainer_8.add(layoutContainer_19, new FormData("100%"));

			LayoutContainer layoutContainer_20 = new LayoutContainer();

			FieldSet fldstNewFieldset_2 = new FieldSet();
			fldstNewFieldset_2.setHeadingHtml("세액계산");
			
		    LayoutContainer lcStdGrid = new LayoutContainer();
		    FormLayout frmlytStd = new FormLayout();  
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(640, 100);  
		    
		    yeta1300GridPanel = new MSFGridPanel(yeta13000Def_01, false, false, false, false, false);
		    yeta1300GridPanel.setHeaderVisible(false);  
		    yeta1300GridPanel.setBodyBorder(true);
		    yeta1300GridPanel.setBorders(true);
		    yeta1300GridPanel.getBottomComponent().setVisible(false);
		    //
		    cpGrid.add(yeta1300GridPanel); 
		    
		    lcStdGrid.add(cpGrid);
		    fldstNewFieldset_2.add(cpGrid);
		    
//			fldstNewFieldset_2.add(layoutContainer_57);
			layoutContainer_20.add(fldstNewFieldset_2, new FormData("100%"));
			fldstNewFieldset_2.setCollapsible(false);
			layoutContainer_8.add(layoutContainer_20, new FormData("100%"));
			layoutContainer_20.setHeight("100");

			cp01.add(layoutContainer_8, new FormData("100%"));
			lcTabFormLayer.add(cp01);
			
			return lcTabFormLayer;
		}
		
		
		//인적공제
		private LayoutContainer yetaData02() {
			
			LayoutContainer lcTabFormLayer = new LayoutContainer();
			
			ContentPanel cp01 = new ContentPanel();
			cp01.setHeaderVisible(false);
			cp01.setHeadingText("");
			cp01.setSize("660", "450");
			
			LayoutContainer layoutContainer_9 = new LayoutContainer();

			LayoutContainer layoutContainer_78 = new LayoutContainer();

			// 인적공제명세
			FieldSet fldstNewFieldset_3 = new FieldSet();

			LayoutContainer layoutContainer_80 = new LayoutContainer();

			ButtonBar btnYeta3220Bar = new ButtonBar();
			btnYeta3220Bar.setAlignment(HorizontalAlignment.RIGHT);

			Button btnYeta3220New = new Button("추가");
			btnYeta3220New.addListener(Events.Select, new Listener<ButtonEvent>() {
				@Override
				public void handleEvent(ButtonEvent be) {
					// TODO Auto-generated method stub
					//TODO 가족사항을 가지고 오는 팝업을 호출한다.
					//선택한 내용을 저장 후리스트에 보여준다.
		  	    	//저장은 업데이트로 처리한다. 
		  	        fnPopupCommP160("Yeta3220");  
				}
			});
			btnYeta3220Bar.add(btnYeta3220New);

			Button btnYeta3220Del = new Button("삭제");
			btnYeta3220Del.addListener(Events.Select, new Listener<ButtonEvent>() {
				@Override
				public void handleEvent(ButtonEvent be) {
					// TODO Auto-generated method stub
					
				      boolean selfCheck = false ;
					Iterator<BaseModel> itBm  = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		              
					List<Record>  lsRec  = new ArrayList<Record>();
		              
					while(itBm.hasNext()) {
						Record rec  = new Record(itBm.next()); 
						lsRec.add(rec);
					} 
		                
		            Iterator<Record> iterRecords = lsRec.iterator() ;  
		            List<Ye16Ta3220DTO> listYeta3220dto = new ArrayList<Ye16Ta3220DTO>(); 
					
//					if((ActionDatabase.INSERT).equals(actionDatabase)) {
//						yeta1300ToYeta3220GridPanel1.getMsfGrid().clearData();
//
//						actionDatabase = ActionDatabase.DELETE;
//					}else {
						while (iterRecords.hasNext()) {
					 	       
							Record recData = (Record) iterRecords.next(); 
							BaseModel bmMapModel = (BaseModel)recData.getModel();
			 	               
							Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
			                    
			 	            yeta3220Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
			 	            yeta3220Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
			 	            yeta3220Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
			 	            yeta3220Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
			 	            
			 	            
			 	            yeta3220Dto.setBeforeJumin(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb2")));    	/** column 주민등록번호 : rsnoNumb */
			 	            
			 	            yeta3220Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 주민등록번호 : rsnoNumb */
			 	            
			 	            yeta3220Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("relhCode")));    	/** column 관계 : relhCode */
			 	            yeta3220Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("kornName")));    	/** column 성명 : kornName */
			 	            yeta3220Dto.setFrnrCode(MSFSharedUtils.allowNulls(bmMapModel.get("frnrCode")));    	/** column 내외국인구분코드 : frnrCode */
			 	            
			 	            yeta3220Dto.setBaseDdyn((Boolean) bmMapModel.get("baseDdyn"));    /** column 기본공제여부 : baseDdyn */
			 	            yeta3220Dto.setPsclDdyn(MSFSharedUtils.allowNulls(bmMapModel.get("psclDdyn")));		/** column 장애인공제여부 : psclDdyn */
			 	            yeta3220Dto.setBrddCtyn((Boolean) bmMapModel.get("brddCtyn"));    /** column 자녀양육비공제여부 : brddCtyn */
			 	            yeta3220Dto.setFaddCtyn((Boolean) bmMapModel.get("faddCtyn"));    /** column 부녀자공제여부 : faddCtyn */
			 	            yeta3220Dto.setRpctDdyn((Boolean) bmMapModel.get("rpctDdyn"));    /** column 경로우대공제여부 : rpctDdyn */
			 	            yeta3220Dto.setBithDdyn((Boolean) bmMapModel.get("bithDdyn"));    /** column 출산입양자공제여부 : bithDdyn */
			 	            yeta3220Dto.setPantOnyn((Boolean) bmMapModel.get("pantOnyn"));    /** column 한부모공제여부 : pantOnyn */
			                    
			 	            if (yeta3220Dto.getRelhCode().equals("A0190001")) {
			 	            	selfCheck = true; 
			 	            }
			 	           listYeta3220dto.add(yeta3220Dto);
			 	           
						}   
						
						actionDatabase = ActionDatabase.DELETE;
//					}
					
					//본인여부 확인 삭제 못하도록 추가 
						if (selfCheck) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "인적공제 본인은 삭제가 불가합니다.", null);
							return;
						}
		 	          
					yeta1300Service.activityOnYeta1300ToYeta3220(listYeta3220dto, actionDatabase, new AsyncCallback<Long>() {
		 	    			 
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
											MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta1300ToYeta3220(" + actionDatabase.name() + ") : " + caught), null);
						}
						public void onSuccess(Long result) {  
							reloadYeta3220_item02Grid();
						}	
					});
				}   
			});
			btnYeta3220Bar.add(btnYeta3220Del);
			layoutContainer_80.add(btnYeta3220Bar);

			fldstNewFieldset_3.add(layoutContainer_80, new FormData("100%"));
			layoutContainer_80.setBorders(false);

			LayoutContainer layoutContainer_79 = new LayoutContainer();
			fldstNewFieldset_3.add(layoutContainer_79, new FormData("100%"));
			layoutContainer_79.add(occupationalRBottom2(), new com.extjs.gxt.ui.client.widget.layout.RowData());
			layoutContainer_79.setBorders(false);

			LayoutContainer layoutContainer_81 = new LayoutContainer();

			LabelField lblfldNewLabelfield_16 = new LabelField(
					"* 장애인표기 - 1 : 장애인복지법  2 : 국가유공자등 예우 및 지원관련법률  3 : 중증환자");
			layoutContainer_81.add(lblfldNewLabelfield_16);

			LabelField lblfldNewLabelfield_17 = new LabelField("* 내국인 : 1 , 외국인 : 9 로 표기");
			layoutContainer_81.add(lblfldNewLabelfield_17);

			fldstNewFieldset_3.add(layoutContainer_81, new FormData("100%"));
			layoutContainer_81.setBorders(false);

			layoutContainer_78.add(fldstNewFieldset_3);
			fldstNewFieldset_3.setHeadingHtml("인적공제명세");
			layoutContainer_9.add(layoutContainer_78, new FormData("100%"));
			layoutContainer_78.setBorders(false);

			LayoutContainer layoutContainer_77 = new LayoutContainer();
			layoutContainer_77.setLayout(new ColumnLayout());

			LayoutContainer layoutContainer_82 = new LayoutContainer();
			layoutContainer_82.setLayout(new ColumnLayout());

			// 자녀수
			LayoutContainer layoutContainer_83 = new LayoutContainer();

			FormLayout frmlytSch20 = new FormLayout();
			frmlytSch20.setLabelWidth(45);
			frmlytSch20.setLabelAlign(LabelAlign.LEFT);

			layoutContainer_83.setLayout(frmlytSch20);

			addrMrct = new  MSFNumberField();
			addrMrct.setReadOnly(true);
			layoutContainer_83.add(addrMrct, new FormData("100%"));
			addrMrct.setFieldLabel("자녀수");
			layoutContainer_82.add(layoutContainer_83, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

			// 세액공제
			LayoutContainer layoutContainer_87 = new LayoutContainer();

			FormLayout frmlytSch21 = new FormLayout();
			frmlytSch21.setLabelWidth(65);
			frmlytSch21.setLabelAlign(LabelAlign.LEFT);

			layoutContainer_87.setLayout(frmlytSch21);

			addrMccr = new   MSFNumberField();
			addrMccr.setReadOnly(true);
			layoutContainer_87.add(addrMccr, new FormData("100%"));
			addrMccr.setFieldLabel("세액공제");
			addrMccr.setAllowDecimals(true); 
			addrMccr.setPropertyEditorType(Long.class); 
			addrMccr.setFormat(NumberFormat.getDecimalFormat());
			
			layoutContainer_82.add(layoutContainer_87, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));

			layoutContainer_77.add(layoutContainer_82, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
			layoutContainer_82.setBorders(false);

			LayoutContainer layoutContainer_84 = new LayoutContainer();
			layoutContainer_84.setBorders(false);
			layoutContainer_77.add(layoutContainer_84, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
			layoutContainer_84.setLayout(new ColumnLayout());

			LayoutContainer layoutContainer_85 = new LayoutContainer();

			LabelField lblfldNewLabelfield_18 = new LabelField("인적공제항목변동여부  :");
			lblfldNewLabelfield_18.setStyleAttribute("textAlign", "RIGHT");
			layoutContainer_85.add(lblfldNewLabelfield_18);
			layoutContainer_84.add(layoutContainer_85, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

			LayoutContainer layoutContainer_86 = new LayoutContainer();
			layoutContainer_84.add(layoutContainer_86, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
			layoutContainer_86.setLayout(new ColumnLayout());
			
			humnCgue = new RadioGroup();

			  humnCgue0 = new Radio();
			humnCgue.add(humnCgue0);
			humnCgue0.setBoxLabel("전년과동일");
			humnCgue0.setHideLabel(true);
			humnCgue0.setValueAttribute("0");

			  humnCgue1 = new Radio();
			humnCgue.add(humnCgue1);
			humnCgue1.setBoxLabel("변동");
			humnCgue1.setHideLabel(true);
			humnCgue1.setValueAttribute("1");
			
			layoutContainer_86.add(humnCgue);
			
			layoutContainer_84.add(layoutContainer_86, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

			layoutContainer_9.add(layoutContainer_77, new FormData("100%"));
			
			cp01.add(layoutContainer_9);
			
			lcTabFormLayer.add(cp01);
			
			return lcTabFormLayer;
		}
		
		private LayoutContainer yetaData03() {
			
			LayoutContainer lcTabFormLayer = new LayoutContainer();
			
			ContentPanel cp01 = new ContentPanel();
			cp01.setScrollMode(Scroll.AUTOY);
			cp01.setHeaderVisible(false);
			cp01.setHeadingText("");
			cp01.setSize("660", "450");

			LayoutContainer layoutContainer_10 = new LayoutContainer();

			LayoutContainer layoutContainer_89 = new LayoutContainer();
			FormLayout frmlytSch21 = new FormLayout();
			frmlytSch21.setLabelWidth(65);
			frmlytSch21.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_89.setLayout(frmlytSch21);
			// 소득공제명세
			FieldSet fldstNewFieldset_4 = new FieldSet();

			LayoutContainer layoutContainer_90 = new LayoutContainer();
//			layoutContainer_90.add(occupationalRBottom3());
			layoutContainer_90.add(occupationalRBottom3_01(), new FormData("100%"));
			layoutContainer_90.add(occupationalRBottom3_02(), new FormData("100%"));
			
			fldstNewFieldset_4.add(layoutContainer_90, new FormData("100%"));
			layoutContainer_90.setBorders(false);
			layoutContainer_89.add(fldstNewFieldset_4);
			fldstNewFieldset_4.setHeadingHtml("소득공제명세");
			layoutContainer_10.add(layoutContainer_89, new FormData("100%"));
			layoutContainer_89.setBorders(false);

			LayoutContainer layoutContainer_88 = new LayoutContainer();
			LabelField lblfldNewLabelfield_19 = new LabelField(
					"* 신용카드, 직불카드, 현금영수증은 전통시장/대중교통비를 제외한 금액을 적습니다.");
			layoutContainer_88.add(lblfldNewLabelfield_19);
			layoutContainer_10.add(layoutContainer_88, new FormData("100%"));
			layoutContainer_88.setBorders(false);

			cp01.add(layoutContainer_10);
			lcTabFormLayer.add(cp01);

			return lcTabFormLayer;
		}
		
		
	private LayoutContainer yetaData04() {
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "450");

		LayoutContainer layoutContainer_11 = new LayoutContainer();

		FieldSet fldstNewFieldset_5 = new FieldSet();

		LayoutContainer layoutContainer_91 = new LayoutContainer();

		FieldSet fldstNewFieldset_6 = new FieldSet();
		fldstNewFieldset_6.setHeadingHtml("국민연금보험료");
		fldstNewFieldset_6.setLayout(new ColumnLayout());
		  
		  
		LayoutContainer layoutContainer_94 = new LayoutContainer();
		layoutContainer_94.setBorders(false);

		// 종전근무지금액
		LayoutContainer layoutContainer_96 = new LayoutContainer();

		FormLayout frmlytSch22 = new FormLayout();
		frmlytSch22.setLabelWidth(100);
		frmlytSch22.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_96.setLayout(frmlytSch22);

		bnatPsnf = new   MSFNumberField();
		bnatPsnf.setReadOnly(true);
		layoutContainer_96.add(bnatPsnf, new FormData("95%"));
		bnatPsnf.setFieldLabel("종전근무지금액");
		bnatPsnf.setReadOnly(true);
		bnatPsnf.setAllowDecimals(true); 
		bnatPsnf.setPropertyEditorType(Long.class); 
		bnatPsnf.setFormat(NumberFormat.getDecimalFormat());
		
		
		layoutContainer_94.add(layoutContainer_96);
		  
		// 주현근무지금액
		LayoutContainer layoutContainer_97 = new LayoutContainer();

		FormLayout frmlytSch23 = new FormLayout();
		frmlytSch23.setLabelWidth(100);
		frmlytSch23.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_97.setLayout(frmlytSch23);

		jnatPsnf = new MSFNumberField();
		layoutContainer_97.add(jnatPsnf, new FormData("95%"));
		jnatPsnf.setFieldLabel("주현근무지금액");
		jnatPsnf.setReadOnly(false);
		jnatPsnf.setAllowDecimals(true); 
		jnatPsnf.setPropertyEditorType(Long.class); 
		jnatPsnf.setFormat(NumberFormat.getDecimalFormat());
		
		
		layoutContainer_94.add(layoutContainer_97);
		  
		fldstNewFieldset_6.add(layoutContainer_94, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_95 = new LayoutContainer();

		// 종전근무지공제액
		LayoutContainer layoutContainer_98 = new LayoutContainer();

		FormLayout frmlytSch24 = new FormLayout();
		frmlytSch24.setLabelWidth(100);
		frmlytSch24.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_98.setLayout(frmlytSch24);

		bnatDdct = new   MSFNumberField();
		bnatDdct.setReadOnly(true);
		layoutContainer_98.add(bnatDdct, new FormData("95%"));
		bnatDdct.setFieldLabel("종전근무지공제액");
		bnatDdct.setReadOnly(true);
		bnatDdct.setAllowDecimals(true); 
		bnatDdct.setPropertyEditorType(Long.class); 
		bnatDdct.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_95.add(layoutContainer_98);

		// 주현근무지공제액
		LayoutContainer layoutContainer_99 = new LayoutContainer();

		FormLayout frmlytSch25 = new FormLayout();
		frmlytSch25.setLabelWidth(100);
		frmlytSch25.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_99.setLayout(frmlytSch25);

		jnatDdct = new  MSFNumberField();
		jnatDdct.setReadOnly(true);
		layoutContainer_99.add(jnatDdct, new FormData("95%"));
		jnatDdct.setFieldLabel("주현근무지공제액");
		jnatDdct.setReadOnly(true);
		jnatDdct.setAllowDecimals(true); 
		jnatDdct.setPropertyEditorType(Long.class); 
		jnatDdct.setFormat(NumberFormat.getDecimalFormat());
		
		
		
		layoutContainer_95.add(layoutContainer_99);
		  
		fldstNewFieldset_6.add(layoutContainer_95, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_95.setBorders(false);

		layoutContainer_91.add(fldstNewFieldset_6);
		fldstNewFieldset_5.add(layoutContainer_91);

		// 국민연금보험료외의 연금보험료
		LayoutContainer layoutContainer_92 = new LayoutContainer();

		FieldSet fldstNewFieldset_7 = new FieldSet();
		fldstNewFieldset_7.setHeadingHtml("국민연금보험료외의 연금보험료");
		fldstNewFieldset_7.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_100 = new LayoutContainer();

		LayoutContainer layoutContainer_102 = new LayoutContainer();
		layoutContainer_102.setLayout(new ColumnLayout());

		// 공무원연금
		LayoutContainer layoutContainer_110 = new LayoutContainer();

		FormLayout frmlytSch26 = new FormLayout();
		frmlytSch26.setLabelWidth(70);
		frmlytSch26.setLabelAlign(LabelAlign.RIGHT);
		  
		layoutContainer_110.setLayout(frmlytSch26);

		bpssPulc = new MSFNumberField();
		bpssPulc.setReadOnly(true);
		bpssPulc.setFieldLabel("공무원연금");
		bpssPulc.setReadOnly(true);
		bpssPulc.setAllowDecimals(true); 
		bpssPulc.setPropertyEditorType(Long.class); 
		bpssPulc.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_110.add(bpssPulc, new FormData("100%"));
		
		
		
		layoutContainer_102.add(layoutContainer_110, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_110.setBorders(false);
		  
		LayoutContainer layoutContainer_111 = new LayoutContainer();

		FormLayout frmlytSch111 = new FormLayout();
		frmlytSch111.setLabelWidth(0);
		layoutContainer_111.setLayout(frmlytSch111);

		jpssPulc = new MSFNumberField();
		jpssPulc.setLabelSeparator("");
		jpssPulc.setAllowDecimals(true); 
		jpssPulc.setPropertyEditorType(Long.class); 
		jpssPulc.setFormat(NumberFormat.getDecimalFormat());
		
		
		layoutContainer_111.add(jpssPulc, new FormData("100%"));
		layoutContainer_102.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_111.setBorders(false);
		layoutContainer_100.add(layoutContainer_102);
		layoutContainer_102.setBorders(false);
		  
		LayoutContainer layoutContainer_103 = new LayoutContainer();
		layoutContainer_103.setLayout(new ColumnLayout());

		// 군인연금
		LayoutContainer layoutContainer_114 = new LayoutContainer();

		FormLayout frmlytSch27 = new FormLayout();
		frmlytSch27.setLabelWidth(70);
		frmlytSch27.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_114.setLayout(frmlytSch27);

		bpssSold = new  MSFNumberField();
		bpssSold.setReadOnly(true);
		bpssSold.setAllowDecimals(true); 
		bpssSold.setPropertyEditorType(Long.class); 
		bpssSold.setFormat(NumberFormat.getDecimalFormat());
		bpssSold.setFieldLabel("군인연금");
		bpssSold.setReadOnly(true);
		
		layoutContainer_114.add(bpssSold, new FormData("100%"));
		
		layoutContainer_103.add(layoutContainer_114, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_114.setBorders(false);

		LayoutContainer layoutContainer_115 = new LayoutContainer();

		FormLayout frmlytSch115 = new FormLayout();
		frmlytSch115.setLabelWidth(0);
		layoutContainer_115.setLayout(frmlytSch115);

		jpssSold = new MSFNumberField();
		jpssSold.setAllowDecimals(true); 
		jpssSold.setPropertyEditorType(Long.class); 
		jpssSold.setFormat(NumberFormat.getDecimalFormat());
		jpssSold.setLabelSeparator("");
		
		layoutContainer_115.add(jpssSold, new FormData("100%"));
		layoutContainer_103.add(layoutContainer_115, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_115.setBorders(false);
		layoutContainer_100.add(layoutContainer_103);
		layoutContainer_103.setBorders(false);

		LayoutContainer layoutContainer_104 = new LayoutContainer();
		layoutContainer_104.setLayout(new ColumnLayout());

		// 교직원연금
		LayoutContainer layoutContainer_118 = new LayoutContainer();

		FormLayout frmlytSch28 = new FormLayout();
		frmlytSch28.setLabelWidth(70);
		frmlytSch28.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_118.setLayout(frmlytSch28);

		//근무지_국민연금외교직원연금
		bpssTech = new   MSFNumberField();
		bpssTech.setReadOnly(true);
		bpssTech.setAllowDecimals(true); 
		bpssTech.setPropertyEditorType(Long.class); 
		bpssTech.setFormat(NumberFormat.getDecimalFormat());
		bpssTech.setFieldLabel("교직원연금");
		bpssTech.setReadOnly(true);
		
		layoutContainer_118.add(bpssTech, new FormData("100%"));
		
		layoutContainer_104.add(layoutContainer_118, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_118.setBorders(false);

		LayoutContainer layoutContainer_119 = new LayoutContainer();

		FormLayout frmlytSch119 = new FormLayout();
		frmlytSch119.setLabelWidth(0);
		layoutContainer_119.setLayout(frmlytSch119);

		jpssTech = new MSFNumberField();
		jpssTech.setLabelSeparator("");
		jpssTech.setAllowDecimals(true); 
		jpssTech.setPropertyEditorType(Long.class); 
		jpssTech.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_119.add(jpssTech, new FormData("100%"));
		
		layoutContainer_104.add(layoutContainer_119, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_119.setBorders(false);
		layoutContainer_100.add(layoutContainer_104);
		layoutContainer_104.setBorders(false);

		LayoutContainer layoutContainer_105 = new LayoutContainer();
		layoutContainer_105.setLayout(new ColumnLayout());

		// 별정우체국
		LayoutContainer layoutContainer_122 = new LayoutContainer();

		FormLayout frmlytSch29 = new FormLayout();
		frmlytSch29.setLabelWidth(70);
		frmlytSch29.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_122.setLayout(frmlytSch29);

		bpssFect = new   MSFNumberField();
		bpssFect.setReadOnly(true);
		bpssFect.setAllowDecimals(true); 
		bpssFect.setPropertyEditorType(Long.class); 
		bpssFect.setFormat(NumberFormat.getDecimalFormat());
		bpssFect.setFieldLabel("별정우체국");
		bpssFect.setReadOnly(true);
		
		layoutContainer_122.add(bpssFect, new FormData("100%"));
		
		layoutContainer_105.add(layoutContainer_122, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_122.setBorders(false);

		LayoutContainer layoutContainer_123 = new LayoutContainer();

		FormLayout frmlytSch123 = new FormLayout();
		frmlytSch123.setLabelWidth(0);
		layoutContainer_123.setLayout(frmlytSch123);

		jpssFect = new MSFNumberField();
		jpssFect.setLabelSeparator("");
		jpssFect.setAllowDecimals(true); 
		jpssFect.setPropertyEditorType(Long.class); 
		jpssFect.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_123.add(jpssFect, new FormData("100%"));
		
		layoutContainer_105.add(layoutContainer_123, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_123.setBorders(false);

		layoutContainer_100.add(layoutContainer_105);
		layoutContainer_105.setBorders(false);

		fldstNewFieldset_7.add(layoutContainer_100, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_100.setBorders(false);

		LayoutContainer layoutContainer_101 = new LayoutContainer();

		LayoutContainer layoutContainer_106 = new LayoutContainer();
		layoutContainer_106.setLayout(new ColumnLayout());

		// 종근무지_국민연금외공무원연금공제
		LayoutContainer layoutContainer_112 = new LayoutContainer();

		FormLayout frmlytSch30 = new FormLayout();
		frmlytSch30.setLabelWidth(70);
		frmlytSch30.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_112.setLayout(frmlytSch30);

		bpssHpul = new   MSFNumberField();
		bpssHpul.setReadOnly(true);
		bpssHpul.setAllowDecimals(true); 
		bpssHpul.setPropertyEditorType(Long.class); 
		bpssHpul.setFormat(NumberFormat.getDecimalFormat());
		bpssHpul.setFieldLabel("공제액");
		layoutContainer_112.add(bpssHpul, new FormData("100%"));
		
		layoutContainer_106.add(layoutContainer_112, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_112.setBorders(false);

		// 주근무지_공무원연금보험료공제
		LayoutContainer layoutContainer_113 = new LayoutContainer();

		FormLayout frmlytSch113 = new FormLayout();
		frmlytSch113.setLabelWidth(0);
		layoutContainer_113.setLayout(frmlytSch113);

		jpssHpul = new   MSFNumberField();
		jpssHpul.setReadOnly(true);
		jpssHpul.setLabelSeparator("");
		jpssHpul.setAllowDecimals(true); 
		jpssHpul.setPropertyEditorType(Long.class); 
		jpssHpul.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_113.add(jpssHpul, new FormData("100%"));
		
		layoutContainer_106.add(layoutContainer_113, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_113.setBorders(false);
		layoutContainer_101.add(layoutContainer_106);
		layoutContainer_106.setBorders(false);

		LayoutContainer layoutContainer_107 = new LayoutContainer();
		layoutContainer_107.setLayout(new ColumnLayout());

		// 종근무지_국민연금외군인연금공제
		LayoutContainer layoutContainer_116 = new LayoutContainer();

		FormLayout frmlytSch31 = new FormLayout();
		frmlytSch31.setLabelWidth(70);
		frmlytSch31.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_116.setLayout(frmlytSch31);

		bpssHsol = new   MSFNumberField();
		bpssHsol.setReadOnly(true);
		bpssHsol.setAllowDecimals(true); 
		bpssHsol.setPropertyEditorType(Long.class); 
		bpssHsol.setFormat(NumberFormat.getDecimalFormat());
		bpssHsol.setFieldLabel("공제액");
		layoutContainer_116.add(bpssHsol, new FormData("100%"));
		
		layoutContainer_107.add(layoutContainer_116, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_116.setBorders(false);
		  
		// 주근무지_국민연금외군인연금공제
		LayoutContainer layoutContainer_117 = new LayoutContainer();

		FormLayout frmlytSch117 = new FormLayout();
		frmlytSch117.setLabelWidth(0);
		layoutContainer_117.setLayout(frmlytSch117);

		jpssHsol = new   MSFNumberField();
		jpssHsol.setReadOnly(true);
		jpssHsol.setAllowDecimals(true); 
		jpssHsol.setPropertyEditorType(Long.class); 
		jpssHsol.setFormat(NumberFormat.getDecimalFormat());
		jpssHsol.setLabelSeparator("");
		layoutContainer_117.add(jpssHsol, new FormData("100%"));
		layoutContainer_107.add(layoutContainer_117, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_117.setBorders(false);
		layoutContainer_101.add(layoutContainer_107);
		layoutContainer_107.setBorders(false);

		LayoutContainer layoutContainer_108 = new LayoutContainer();
		layoutContainer_108.setLayout(new ColumnLayout());

		// 종근무지_국민연금외교직원연금공제
		LayoutContainer layoutContainer_120 = new LayoutContainer();

		FormLayout frmlytSch32 = new FormLayout();
		frmlytSch32.setLabelWidth(70);
		frmlytSch32.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_120.setLayout(frmlytSch32);

		bpssHtec = new   MSFNumberField();
		bpssHtec.setReadOnly(true);
		bpssHtec.setAllowDecimals(true); 
		bpssHtec.setPropertyEditorType(Long.class); 
		bpssHtec.setFormat(NumberFormat.getDecimalFormat());
		bpssHtec.setFieldLabel("공제액");
		
		layoutContainer_120.add(bpssHtec, new FormData("100%"));
		
		layoutContainer_108.add(layoutContainer_120, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_120.setBorders(false);
		  
		// 주근무지_국민연금외교직원연금공제
		LayoutContainer layoutContainer_121 = new LayoutContainer();

		FormLayout frmlytSch121 = new FormLayout();
		frmlytSch121.setLabelWidth(0);
		layoutContainer_121.setLayout(frmlytSch121);

		jpssHtec = new   MSFNumberField();
		jpssHtec.setReadOnly(true);
		jpssHtec.setLabelSeparator("");
		jpssHtec.setAllowDecimals(true); 
		jpssHtec.setPropertyEditorType(Long.class); 
		jpssHtec.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_121.add(jpssHtec, new FormData("100%"));
		
		layoutContainer_108.add(layoutContainer_121, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_121.setBorders(false);
		layoutContainer_101.add(layoutContainer_108);
		layoutContainer_108.setBorders(false);
		  
		LayoutContainer layoutContainer_109 = new LayoutContainer();
		layoutContainer_109.setLayout(new ColumnLayout());

		// 종근무지_별정우체국연금보험료공제
		LayoutContainer layoutContainer_124 = new LayoutContainer();

		FormLayout frmlytSch33 = new FormLayout();
		frmlytSch33.setLabelWidth(70);
		frmlytSch33.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_124.setLayout(frmlytSch33);

		bpssDdct = new   MSFNumberField();
		bpssDdct.setReadOnly(true);
		
		bpssDdct.setAllowDecimals(true); 
		bpssDdct.setPropertyEditorType(Long.class); 
		bpssDdct.setFormat(NumberFormat.getDecimalFormat());
		bpssDdct.setFieldLabel("공제액");
		
		layoutContainer_124.add(bpssDdct, new FormData("100%"));
		
		layoutContainer_109.add(layoutContainer_124, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_124.setBorders(false);
		  
		  
		// 주근무지_별정우체국연금보험료공제
		LayoutContainer layoutContainer_125 = new LayoutContainer();

		FormLayout frmlytSch125 = new FormLayout();
		frmlytSch125.setLabelWidth(0);
		layoutContainer_125.setLayout(frmlytSch125);

		jpssDdct = new   MSFNumberField();
		jpssDdct.setReadOnly(true);
		
		jpssDdct.setAllowDecimals(true); 
		jpssDdct.setPropertyEditorType(Long.class); 
		jpssDdct.setFormat(NumberFormat.getDecimalFormat());
		jpssDdct.setLabelSeparator("");
		
		layoutContainer_125.add(jpssDdct, new FormData("100%"));
		layoutContainer_109.add(layoutContainer_125, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_125.setBorders(false);
		layoutContainer_101.add(layoutContainer_109);
		layoutContainer_109.setBorders(false);
		  
		fldstNewFieldset_7.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_101.setBorders(false);

		layoutContainer_92.add(fldstNewFieldset_7);
		fldstNewFieldset_7.setHeadingHtml("국민연금보험료외의 연금보험료");
		fldstNewFieldset_7.setCollapsible(false);
		fldstNewFieldset_5.add(layoutContainer_92);

		LayoutContainer layoutContainer_93 = new LayoutContainer();

		LayoutContainer layoutContainer_126 = new LayoutContainer();
		  
		LabelField lblfldNewLabelfield_20 = new LabelField("국민연금보험료외 연금보험료는 종근무지/주근무지 순으로 나타냄");
		layoutContainer_126.add(lblfldNewLabelfield_20);
		layoutContainer_93.add(layoutContainer_126);
		layoutContainer_126.setBorders(false);
		  
		LayoutContainer layoutContainer_127 = new LayoutContainer();
		layoutContainer_127.setLayout(new ColumnLayout());

		// 연금보험료금액계
		LayoutContainer layoutContainer_129 = new LayoutContainer();

		FormLayout frmlytSch34 = new FormLayout();
		frmlytSch34.setLabelWidth(110);
		frmlytSch34.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_129.setLayout(frmlytSch34);

		rrptAmnt = new   MSFNumberField();
		rrptAmnt.setReadOnly(true);
		
		
		rrptAmnt.setAllowDecimals(true); 
		rrptAmnt.setPropertyEditorType(Long.class); 
		rrptAmnt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_129.add(rrptAmnt, new FormData("100%"));
		rrptAmnt.setFieldLabel("연금보험료금액계");
		layoutContainer_127.add(layoutContainer_129, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_129.setBorders(false);
		  
		//연금보험료공제계
		LayoutContainer layoutContainer_130 = new LayoutContainer();
		  
		FormLayout frmlytSch35 = new FormLayout();
		frmlytSch35.setLabelWidth(110);
		frmlytSch35.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_130.setLayout(frmlytSch35);

		rrptYnam = new    MSFNumberField();
		rrptYnam.setReadOnly(true);
		
		rrptYnam.setAllowDecimals(true); 
		rrptYnam.setPropertyEditorType(Long.class); 
		rrptYnam.setFormat(NumberFormat.getDecimalFormat());
		rrptYnam.setFieldLabel("연금보험료공제계");
		
		layoutContainer_130.add(rrptYnam, new FormData("100%"));
		
		layoutContainer_127.add(layoutContainer_130, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_130.setBorders(false);
		layoutContainer_93.add(layoutContainer_127);
		layoutContainer_127.setBorders(false);

		LayoutContainer layoutContainer_128 = new LayoutContainer();

		ButtonBar buttonBar_2 = new ButtonBar();
		buttonBar_2.setAlignment(HorizontalAlignment.RIGHT);
		  
		Button btnNewButton_9 = new Button("연금/저축등소득공제");
		btnNewButton_9.setIconAlign(IconAlign.RIGHT);
		btnNewButton_9.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 전체내역
				YetaP13007 yetaP03007Form = new YetaP13007(ActionDatabase.READ, getThis());

				MSFFormWindows msFwYeta13007 = new MSFFormWindows("연금저축소득공제",yetaP03007Form, "닫기", "820px", "710px", true);
				msFwYeta13007.show();
				yetaP03007Form.setMSFFormWindows(msFwYeta13007);
				
				// TODO 추후 주석해제
				yetaP03007Form.bind(ppRecord);
			}
		});
		  
		buttonBar_2.add(btnNewButton_9);
		layoutContainer_128.add(buttonBar_2);
		layoutContainer_93.add(layoutContainer_128);
		layoutContainer_128.setBorders(false);

		fldstNewFieldset_5.add(layoutContainer_93);
		layoutContainer_93.setBorders(false);
		layoutContainer_11.add(fldstNewFieldset_5);
		fldstNewFieldset_5.setHeadingHtml("연금보험료공제");
		cp01.add(layoutContainer_11);
		layoutContainer_11.setBorders(false);

		cp01.add(layoutContainer_11);
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}
	
	
	private LayoutContainer yetaData05() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		
		ContentPanel cp01 = new ContentPanel();
//		cp01.setScrollMode(Scroll.AUTOY);
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "5000");
		
		  
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		  
		tabsItemYeta05 = new TabPanel();
	
		tabsItemYeta05.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				
				//탭선택
//				yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), tabsItemYeta05.getSelectedItem().getId());
					
				//reFresh(tabsItemYeta05.getSelectedItem().getId());
				
			}
		});
		  
		//보험료tab
		TabItem itemYeta05_1 = new TabItem("보험료");
		itemYeta05_1.setId("itemYeta05_1");
		itemYeta05_1.setBorders(true);
		  
		ContentPanel cp02 = new ContentPanel();
		cp02.setHeaderVisible(false);
		cp02.setHeadingText("");
		  
		LayoutContainer layoutContainer_281 = new LayoutContainer();
		  
		LayoutContainer layoutContainer_282 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_18 = new FieldSet();
		fldstNewFieldset_18.setHeadingHtml("보험료공제");
		  
		LayoutContainer layoutContainer_284 = new LayoutContainer();
		layoutContainer_284.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_285 = new LayoutContainer();
		layoutContainer_285.setBorders(false);
		  
		
		FieldSet fldstNewFieldset_188 = new FieldSet();
		fldstNewFieldset_188.setHeadingHtml("건강보험");
		
		//특별공제_종건강보험료
		LayoutContainer layoutContainer_287 = new LayoutContainer();
		  
		FormLayout frmlytSch130 = new FormLayout();  
		frmlytSch130.setLabelWidth(110); 
		frmlytSch130.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_287.setLayout(frmlytSch130);
		  
		spciBhlh = new   MSFNumberField();
		spciBhlh.setReadOnly(true);
		
		spciBhlh.setAllowDecimals(true); 
		spciBhlh.setPropertyEditorType(Long.class); 
		spciBhlh.setFormat(NumberFormat.getDecimalFormat());
		spciBhlh.setFieldLabel("종전근무지금액");
		
		layoutContainer_287.add(spciBhlh, new FormData("100%"));
		
		layoutContainer_285.add(layoutContainer_287);
		layoutContainer_287.setBorders(false);
		  
		//특별공제_주건강보험료
		LayoutContainer layoutContainer_288 = new LayoutContainer();
		  
		FormLayout frmlytSch131 = new FormLayout();  
		frmlytSch131.setLabelWidth(110); 
		frmlytSch131.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_288.setLayout(frmlytSch131);
		  
		spciHhlh = new MSFNumberField();
		
		spciHhlh.setAllowDecimals(true); 
		spciHhlh.setPropertyEditorType(Long.class); 
		spciHhlh.setFormat(NumberFormat.getDecimalFormat());
		spciHhlh.setFieldLabel("주현근무지금액");
		
		layoutContainer_288.add(spciHhlh, new FormData("100%"));
		
		layoutContainer_285.add(layoutContainer_288);
		layoutContainer_288.setBorders(false);
		  
		  
		layoutContainer_284.add(layoutContainer_285, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_286 = new LayoutContainer();
		  
		//특별공제_종건강보험료
		LayoutContainer layoutContainer_289 = new LayoutContainer();
		  
		FormLayout frmlytSch132 = new FormLayout();  
		frmlytSch132.setLabelWidth(110); 
		frmlytSch132.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_289.setLayout(frmlytSch132);
		  
		spciBhth = new   MSFNumberField();
		spciBhth.setReadOnly(true);
		
		spciBhth.setAllowDecimals(true); 
		spciBhth.setPropertyEditorType(Long.class); 
		spciBhth.setFormat(NumberFormat.getDecimalFormat());
		spciBhth.setFieldLabel("종전근무지공제액");
		
		layoutContainer_289.add(spciBhth, new FormData("100%"));
		
		layoutContainer_286.add(layoutContainer_289);
		layoutContainer_289.setBorders(false);
		  
		//특별공제_주건강보험료
		LayoutContainer layoutContainer_290 = new LayoutContainer();
		  
		FormLayout frmlytSch133 = new FormLayout();  
		frmlytSch133.setLabelWidth(110); 
		frmlytSch133.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_290.setLayout(frmlytSch133);
	 
		spciJhth = new   MSFNumberField();
		spciJhth.setReadOnly(true);
		
		spciJhth.setAllowDecimals(true); 
		spciJhth.setPropertyEditorType(Long.class); 
		spciJhth.setFormat(NumberFormat.getDecimalFormat());
		spciJhth.setFieldLabel("주현근무지공제액");
		
		layoutContainer_290.add(spciJhth, new FormData("100%"));
		
		layoutContainer_286.add(layoutContainer_290);
		layoutContainer_290.setBorders(false);
		  
		  
		layoutContainer_284.add(layoutContainer_286, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_286.setBorders(false);
		  
		  
		  
//		fldstNewFieldset_18.add(layoutContainer_284);
		fldstNewFieldset_188.add(layoutContainer_284);
		fldstNewFieldset_18.add(fldstNewFieldset_188);
		
		layoutContainer_282.add(fldstNewFieldset_18);
		layoutContainer_281.add(layoutContainer_282);
		layoutContainer_282.setBorders(false);
		  
		LayoutContainer layoutContainer_283 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_19 = new FieldSet();
		fldstNewFieldset_19.setHeadingHtml("고용보험");
		 
		LayoutContainer layoutContainer_291 = new LayoutContainer();
		layoutContainer_291.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_292 = new LayoutContainer();
		  
		//특별공제_종고용보험료
		LayoutContainer layoutContainer_294 = new LayoutContainer();
		  
		FormLayout frmlytSch134 = new FormLayout();  
		frmlytSch134.setLabelWidth(110); 
		frmlytSch134.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_294.setLayout(frmlytSch134);
		  
		spciBepf = new   MSFNumberField();
		spciBepf.setReadOnly(true);
		
		
		spciBepf.setAllowDecimals(true); 
		spciBepf.setPropertyEditorType(Long.class); 
		spciBepf.setFormat(NumberFormat.getDecimalFormat());
		spciBepf.setFieldLabel("종전근무지금액");
		
		layoutContainer_294.add(spciBepf, new FormData("100%"));
		
		layoutContainer_292.add(layoutContainer_294);
		layoutContainer_294.setBorders(false);
		  
		//특별공제_주고용보험료
		LayoutContainer layoutContainer_295 = new LayoutContainer();
		  
		FormLayout frmlytSch135 = new FormLayout();  
		frmlytSch135.setLabelWidth(110); 
		frmlytSch135.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_295.setLayout(frmlytSch135);
		  
		spciJepf = new MSFNumberField();
		
		spciJepf.setAllowDecimals(true); 
		spciJepf.setPropertyEditorType(Long.class); 
		spciJepf.setFormat(NumberFormat.getDecimalFormat());
		spciJepf.setFieldLabel("주현근무지금액");
		
		layoutContainer_295.add(spciJepf, new FormData("100%"));
		
		layoutContainer_292.add(layoutContainer_295);
		layoutContainer_295.setBorders(false);
		    
		  
		layoutContainer_291.add(layoutContainer_292, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_292.setBorders(false);
		  
		LayoutContainer layoutContainer_293 = new LayoutContainer();
		 
		//특별공제_종고용보험료공제액
		LayoutContainer layoutContainer_297 = new LayoutContainer();
		  
		FormLayout frmlytSch137 = new FormLayout();  
		frmlytSch137.setLabelWidth(110); 
		frmlytSch137.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_297.setLayout(frmlytSch137);
		  
		spciBepf01 = new   MSFNumberField();
		spciBepf01.setReadOnly(true);
		
		spciBepf01.setAllowDecimals(true); 
		spciBepf01.setPropertyEditorType(Long.class); 
		spciBepf01.setFormat(NumberFormat.getDecimalFormat());
		spciBepf01.setFieldLabel("종전근무지공제액");
		
		layoutContainer_297.add(spciBepf01, new FormData("100%"));
		
		layoutContainer_293.add(layoutContainer_297);
		layoutContainer_297.setBorders(false);
		  
		
		//특별공제_주고용보험료공제액
		LayoutContainer layoutContainer_298 = new LayoutContainer();
		  
		FormLayout frmlytSch138 = new FormLayout();  
		frmlytSch138.setLabelWidth(110); 
		frmlytSch138.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_298.setLayout(frmlytSch138);
		  
		spciJepf01 = new  MSFNumberField();
		spciJepf01.setReadOnly(true);
		
		spciJepf01.setAllowDecimals(true); 
		spciJepf01.setPropertyEditorType(Long.class); 
		spciJepf01.setFormat(NumberFormat.getDecimalFormat());
		spciJepf01.setFieldLabel("주현근무지공제액");
		
		layoutContainer_298.add(spciJepf01, new FormData("100%"));
		
		layoutContainer_293.add(layoutContainer_298);
		layoutContainer_298.setBorders(false);
		  
		  
		layoutContainer_291.add(layoutContainer_293, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_293.setBorders(false);
		  
		
		fldstNewFieldset_19.add(layoutContainer_291);
		fldstNewFieldset_18.add(fldstNewFieldset_19);
		
		
		layoutContainer_283.add(fldstNewFieldset_19);
		layoutContainer_281.add(layoutContainer_283);
		
		LayoutContainer lcNum = new LayoutContainer(new ColumnLayout());
		
		//보혐료금액계
		LayoutContainer layoutContainer_296 = new LayoutContainer();
		  
		FormLayout frmlytSch136 = new FormLayout();  
		frmlytSch136.setLabelWidth(110); 
		frmlytSch136.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_296.setLayout(frmlytSch136);
		
		spciIuam = new   MSFNumberField();
		spciIuam.setReadOnly(true);
		
		spciIuam.setAllowDecimals(true); 
		spciIuam.setPropertyEditorType(Long.class); 
		spciIuam.setFormat(NumberFormat.getDecimalFormat());
		spciIuam.setFieldLabel("보혐료금액계");
		
		layoutContainer_296.add(spciIuam, new FormData("100%"));
		
		lcNum.add(layoutContainer_296, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_296.setBorders(false);
		
		//보혐료공제액
		LayoutContainer layoutContainer_299 = new LayoutContainer();
		  
		FormLayout frmlytSch139 = new FormLayout();  
		frmlytSch139.setLabelWidth(110); 
		frmlytSch139.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_299.setLayout(frmlytSch139);
		
		spciHrto = new  MSFNumberField();
		spciHrto.setReadOnly(true);
		
		spciHrto.setAllowDecimals(true); 
		spciHrto.setPropertyEditorType(Long.class); 
		spciHrto.setFormat(NumberFormat.getDecimalFormat());
		spciHrto.setFieldLabel("보혐료공제액");
		
		layoutContainer_299.add(spciHrto, new FormData("100%"));
		
		lcNum.add(layoutContainer_299, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_299.setBorders(false);
		layoutContainer_283.add(lcNum);
		
		fldstNewFieldset_18.add(layoutContainer_283);
		
		layoutContainer_283.setBorders(false);
		  
		  
		cp02.add(layoutContainer_281);
		itemYeta05_1.add(cp02);
//		cp02.setSize(650, 440);
		cp02.setSize(650, 520);
		tabsItemYeta05.add(itemYeta05_1);
		  
		//주택자금tab
		TabItem itemYeta05_2 = new TabItem("주택자금");
		itemYeta05_2.setId("itemYeta05_2");
		itemYeta05_2.setBorders(true);
		  
		ContentPanel cntntpnlNewContentpanel_2 = new ContentPanel();
		cntntpnlNewContentpanel_2.setScrollMode(Scroll.AUTOY);
		cntntpnlNewContentpanel_2.setHeaderVisible(false);
		cntntpnlNewContentpanel_2.setHeadingHtml("");
		  
		LayoutContainer layoutContainer_300 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_20 = new FieldSet();
		  
//		LayoutContainer layoutContainer_301 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_21 = new FieldSet();
		fldstNewFieldset_21.setHeadingHtml("주택자금공제");
		  
		LayoutContainer layoutContainer_448 = new LayoutContainer();
		layoutContainer_448.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_449 = new LayoutContainer();
		
		FormLayout frmlytSch449 = new FormLayout();  
		frmlytSch449.setLabelWidth(0); 
		  
		layoutContainer_449.setLayout(frmlytSch449);
		  
		Button btnNewButton_15 = new Button("임차등록");
		btnNewButton_15.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP13004 yetaP03004Form = new YetaP13004(ActionDatabase.READ, getThis());   
					    
				MSFFormWindows msFwYeta13004 = new MSFFormWindows("거주자간 주택임차차입금 원리금 상환액", yetaP03004Form, "닫기", "820px", "710px", true);
				msFwYeta13004.show();
				yetaP03004Form.setMSFFormWindows(msFwYeta13004);
				
				funcSetPopUpRecord();
				//TODO 추후 주석해제 
				yetaP03004Form.bind(ppRecord); 
				}
		});	
		layoutContainer_449.add(btnNewButton_15, new FormData("100%"));
		
		
		layoutContainer_448.add(layoutContainer_449, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//		layoutContainer_448.add(layoutContainer_449, new com.extjs.gxt.ui.client.widget.layout.ColumnData(63.0));
		  
		LayoutContainer layoutContainer_450 = new LayoutContainer();
		  
		//대출기관차입
		LayoutContainer layoutContainer_452 = new LayoutContainer();
		  
		FormLayout frmlytSch300 = new FormLayout();  
		frmlytSch300.setLabelWidth(100); 
		frmlytSch300.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_452.setLayout(frmlytSch300);
		  
		spciRefn = new MSFNumberField();
		
		spciRefn.setAllowDecimals(true); 
		spciRefn.setPropertyEditorType(Long.class); 
		spciRefn.setFormat(NumberFormat.getDecimalFormat());
		spciRefn.setFieldLabel("대출기관차입");
		
		layoutContainer_452.add(spciRefn, new FormData("100%"));
	
		layoutContainer_450.add(layoutContainer_452, new FormData("100%"));
		layoutContainer_452.setBorders(false);
		  
		//거주자차입
		LayoutContainer layoutContainer_453 = new LayoutContainer();
		  
		FormLayout frmlytSch301 = new FormLayout();  
		frmlytSch301.setLabelWidth(100); 
		frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_453.setLayout(frmlytSch301);
		  
		spciResf = new MSFNumberField();
		
		spciResf.setAllowDecimals(true); 
		spciResf.setReadOnly(true);
		spciResf.setPropertyEditorType(Long.class); 
		spciResf.setFormat(NumberFormat.getDecimalFormat());
		spciResf.setFieldLabel("거주자차입");
		
		layoutContainer_453.add(spciResf, new FormData("100%"));
		
		layoutContainer_450.add(layoutContainer_453, new FormData("100%"));
		layoutContainer_453.setBorders(false);
		  
//		layoutContainer_448.add(layoutContainer_450, new com.extjs.gxt.ui.client.widget.layout.ColumnData(270.0));
		layoutContainer_448.add(layoutContainer_450, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_450.setBorders(false);
		  
		LayoutContainer layoutContainer_451 = new LayoutContainer();
		 frmlytSch301 = new FormLayout();  
		frmlytSch301.setLabelWidth(100); 
		frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_451.setLayout(frmlytSch301);
		//특별공제_차입금원리금상환액_대출기관 공제액
		LayoutContainer layoutContainer_454 = new LayoutContainer();
		  
		FormLayout frmlytSch302 = new FormLayout();  
		frmlytSch302.setLabelWidth(50); 
		frmlytSch302.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_454.setLayout(frmlytSch302);
		  
		spciRefn01 = new   MSFNumberField();
		spciRefn01.setReadOnly(true);
		
		
		spciRefn01.setAllowDecimals(true); 
		spciRefn01.setPropertyEditorType(Long.class); 
		spciRefn01.setFormat(NumberFormat.getDecimalFormat());
		spciRefn01.setFieldLabel("공제액");
		
		layoutContainer_454.add(spciRefn01, new FormData("100%"));
	
		layoutContainer_451.add(layoutContainer_454, new FormData("100%"));
		layoutContainer_454.setBorders(false);
		  
		//특별공제_차입금원리금상환액_거주자 공제액
		LayoutContainer layoutContainer_455 = new LayoutContainer();
		  
		FormLayout frmlytSch303 = new FormLayout();  
		frmlytSch303.setLabelWidth(50); 
		frmlytSch303.setLabelAlign(LabelAlign.RIGHT); 
		  
		layoutContainer_455.setLayout(frmlytSch303);
		  
		spciResf01 = new   MSFNumberField();
		spciResf01.setReadOnly(true);
		
		spciResf01.setAllowDecimals(true); 
		spciResf01.setPropertyEditorType(Long.class); 
		spciResf01.setFormat(NumberFormat.getDecimalFormat());
		spciResf01.setFieldLabel("공제액");
		
		layoutContainer_455.add(spciResf01, new FormData("100%"));
		
		layoutContainer_451.add(layoutContainer_455, new FormData("100%"));
		layoutContainer_455.setBorders(false);
		  
		layoutContainer_448.add(layoutContainer_451, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer_451.setBorders(false);
		  
		  
		fldstNewFieldset_21.add(layoutContainer_448, new FormData("100%"));
//		layoutContainer_301.add(fldstNewFieldset_21);
		fldstNewFieldset_20.add(fldstNewFieldset_21, new FormData("100%"));
		
//		fldstNewFieldset_20.add(layoutContainer_301);
//		layoutContainer_301.setBorders(false);
		  
//		LayoutContainer layoutContainer_302 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_22 = new FieldSet();
		fldstNewFieldset_22.setHeadingHtml("월세액_세액공제");
		  
		LayoutContainer layoutContainer_315 = new LayoutContainer();
		layoutContainer_315.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_314 = new LayoutContainer();
		  
		FormLayout frmlytSch3142 = new FormLayout();  
		frmlytSch3142.setLabelWidth(0); 
		layoutContainer_314.setLayout(frmlytSch3142);
		  
		  Button btnNewButton_16 = new Button("월세액등록");
		  btnNewButton_16.addListener(Events.Select, new Listener<ButtonEvent>() {
			  public void handleEvent(ButtonEvent e) {
				  //전체내역  
				  YetaP13005 yetaP03005Form = new YetaP13005(ActionDatabase.READ, getThis());   
						    
//				  MSFFormWindows msFwYeta13005 = new MSFFormWindows("월세액소득공제명세", yetaP03005Form, "닫기", "820px", "710px", true);
				  MSFFormWindows msFwYeta13005 = new MSFFormWindows("월세액소득공제명세", yetaP03005Form, "닫기", "820px", "580px", true);
				  msFwYeta13005.show();
				  yetaP03005Form.setMSFFormWindows(msFwYeta13005);
				  
				  funcSetPopUpRecord();
				  //TODO 추후 주석해제 
				  yetaP03005Form.bind(ppRecord); 
			  }
		  });		  
		  layoutContainer_314.add(btnNewButton_16, new FormData("100%"));
		  layoutContainer_315.add(layoutContainer_314, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		  layoutContainer_314.setBorders(false);
		  
		  
		  LayoutContainer layoutContainer_316 = new LayoutContainer();
		  
		  //지출금액
		  LayoutContainer layoutContainer_456 = new LayoutContainer();
		  
		  FormLayout frmlytSch304 = new FormLayout();  
		  frmlytSch304.setLabelWidth(100); 
		  frmlytSch304.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_456.setLayout(frmlytSch304);
		  
		  spciHtam = new MSFNumberField();
		  
		  spciHtam.setAllowDecimals(true); 
		  spciHtam.setReadOnly(true);
		  spciHtam.setPropertyEditorType(Long.class); 
		  spciHtam.setFormat(NumberFormat.getDecimalFormat());
		  spciHtam.setFieldLabel("지출금액");
		  
		  layoutContainer_456.add(spciHtam, new FormData("100%"));
		 
		  layoutContainer_316.add(layoutContainer_456, new FormData("100%"));
		  layoutContainer_456.setBorders(false);
		  
//		  layoutContainer_315.add(layoutContainer_316, new com.extjs.gxt.ui.client.widget.layout.ColumnData(270.0));
		  layoutContainer_315.add(layoutContainer_316, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		  layoutContainer_316.setBorders(false);
		  
		  LayoutContainer layoutContainer_317 = new LayoutContainer();
		  frmlytSch301 = new FormLayout();  
			frmlytSch301.setLabelWidth(100); 
			frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
			  
			layoutContainer_317.setLayout(frmlytSch301);
		  //특별공제_주택자금월세공제액
		  LayoutContainer layoutContainer_458 = new LayoutContainer();
		  
		  FormLayout frmlytSch305 = new FormLayout();  
		  frmlytSch305.setLabelWidth(50); 
		  frmlytSch305.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_458.setLayout(frmlytSch305);
		  
		  spciRtam = new   MSFNumberField();
		  spciRtam.setReadOnly(true);
		  
		  spciRtam.setAllowDecimals(true); 
		  spciRtam.setPropertyEditorType(Long.class); 
		  spciRtam.setFormat(NumberFormat.getDecimalFormat());
		  spciRtam.setFieldLabel("공제액");
		  
		  layoutContainer_458.add(spciRtam, new FormData("100%"));
		  
		  layoutContainer_317.add(layoutContainer_458, new FormData("100%"));
		  layoutContainer_458.setBorders(false);
		  
//		  layoutContainer_315.add(layoutContainer_317, new com.extjs.gxt.ui.client.widget.layout.ColumnData(230.0));
		  layoutContainer_315.add(layoutContainer_317, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		  layoutContainer_317.setBorders(false);
		  
		  fldstNewFieldset_22.add(layoutContainer_315, new FormData("100%"));
		  fldstNewFieldset_20.add(fldstNewFieldset_22, new FormData("100%"));
//		  layoutContainer_302.add(fldstNewFieldset_22);
		  fldstNewFieldset_22.setCollapsible(false);
//		  fldstNewFieldset_20.add(layoutContainer_302);
//		  layoutContainer_302.setBorders(false);
		  
//		  LayoutContainer layoutContainer_303 = new LayoutContainer();
		  
		  FieldSet fldstNewFieldset_23 = new FieldSet();
//		  layoutContainer_303.add(fldstNewFieldset_23);
		  fldstNewFieldset_23.setHeadingHtml("장기주택저당차입금");
		  fldstNewFieldset_23.setCollapsible(false);
		  
		  LayoutContainer layoutContainer_305 = new LayoutContainer();
		  frmlytSch301 = new FormLayout();  
			frmlytSch301.setLabelWidth(100); 
			frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
			  
			layoutContainer_305.setLayout(frmlytSch301);
		  LayoutContainer layoutContainer_306 = new LayoutContainer();
		  
		  FieldSet fldstNewFieldset_24 = new FieldSet();
		  
		  LayoutContainer layoutContainer_311 = new LayoutContainer();
		  layoutContainer_311.setLayout(new ColumnLayout());
		  
		  LayoutContainer layoutContainer_312 = new LayoutContainer();
		  FormLayout frmlytSch3061 = new FormLayout();  
		  frmlytSch3061.setLabelWidth(240); 
		  frmlytSch3061.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_312.setLayout(frmlytSch3061);
		  
		  //이자상환액(15년 미만)
		  LayoutContainer layoutContainer_460= new LayoutContainer();
		  
		  FormLayout frmlytSch306 = new FormLayout();  
		  frmlytSch306.setLabelWidth(240); 
		  frmlytSch306.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_460.setLayout(frmlytSch306);
		  
		  spchRe06 = new MSFNumberField();
		  
		  spchRe06.setAllowDecimals(true); 
		  spchRe06.setPropertyEditorType(Long.class); 
		  spchRe06.setFormat(NumberFormat.getDecimalFormat());
		  spchRe06.setFieldLabel("이자상환액(15년 미만)");
			
		  layoutContainer_460.add(spchRe06, new FormData("100%"));
		  
		  layoutContainer_312.add(layoutContainer_460, new FormData("100%"));
		  layoutContainer_460.setBorders(false);
		  
		  //이자상환액(15년 ~ 29년)
		  LayoutContainer layoutContainer_461= new LayoutContainer();
		  
		  FormLayout frmlytSch307 = new FormLayout();  
		  frmlytSch307.setLabelWidth(240); 
		  frmlytSch307.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_461.setLayout(frmlytSch307);
		  
		  spchRe10 = new MSFNumberField();
		  
		  spchRe10.setAllowDecimals(true); 
		  spchRe10.setPropertyEditorType(Long.class); 
		  spchRe10.setFormat(NumberFormat.getDecimalFormat());
		  spchRe10.setFieldLabel("이자상환액(15년 ~ 29년)");
			
		  layoutContainer_461.add(spchRe10, new FormData("100%"));
		 
		  layoutContainer_312.add(layoutContainer_461, new FormData("100%"));
		  layoutContainer_461.setBorders(false);
		  
		  //이자상환액(30년 이상)
		  LayoutContainer layoutContainer_468= new LayoutContainer();
		  
		  FormLayout frmlytSch308 = new FormLayout();  
		  frmlytSch308.setLabelWidth(240); 
		  frmlytSch308.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_468.setLayout(frmlytSch308);
		  
		  spchRe20 = new MSFNumberField();
		  
		  spchRe20.setAllowDecimals(true); 
		  spchRe20.setPropertyEditorType(Long.class); 
		  spchRe20.setFormat(NumberFormat.getDecimalFormat());
		  spchRe20.setFieldLabel("이자상환액(30년 이상)");
			
		  layoutContainer_468.add(spchRe20, new FormData("100%"));
		  
		  layoutContainer_312.add(layoutContainer_468, new FormData("100%"));
		  layoutContainer_468.setBorders(false);
		  
		  layoutContainer_312.setBorders(false);
//		  layoutContainer_311.add(layoutContainer_312, new com.extjs.gxt.ui.client.widget.layout.ColumnData(321.0));
		  layoutContainer_311.add(layoutContainer_312, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		 
		  LayoutContainer layoutContainer_313 = new LayoutContainer();
		  frmlytSch301 = new FormLayout();  
			frmlytSch301.setLabelWidth(100); 
			frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
			  
			layoutContainer_313.setLayout(frmlytSch301);
		  //특별공제_11장기주택저당차입금15 공제액
		  LayoutContainer layoutContainer_462= new LayoutContainer();
		  
		  FormLayout frmlytSch309 = new FormLayout();  
		  frmlytSch309.setLabelWidth(50); 
		  frmlytSch309.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_462.setLayout(frmlytSch309);
		  
		  spchRe15 = new   MSFNumberField();
		  spchRe15.setReadOnly(true);
		  
		  spchRe15.setAllowDecimals(true); 
		  spchRe15.setPropertyEditorType(Long.class); 
		  spchRe15.setFormat(NumberFormat.getDecimalFormat());
		  spchRe15.setFieldLabel("공제액");
			
		  layoutContainer_462.add(spchRe15, new FormData("100%"));
		 
		  layoutContainer_313.add(layoutContainer_462, new FormData("100%"));
		  layoutContainer_462.setBorders(false);
		  
		  //특별공제_11장기주택저당차입금29 공제액
		  LayoutContainer layoutContainer_463= new LayoutContainer();
		  
		  FormLayout frmlytSch310 = new FormLayout();  
		  frmlytSch310.setLabelWidth(50); 
		  frmlytSch310.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_463.setLayout(frmlytSch310);
		  
		  spchRe29 = new   MSFNumberField();
		  spchRe29.setReadOnly(true);
		  
		  
		  spchRe29.setAllowDecimals(true); 
		  spchRe29.setPropertyEditorType(Long.class); 
		  spchRe29.setFormat(NumberFormat.getDecimalFormat());
		  spchRe29.setFieldLabel("공제액");
			
		  layoutContainer_463.add(spchRe29, new FormData("100%"));
		 
		  layoutContainer_313.add(layoutContainer_463, new FormData("100%"));
		  layoutContainer_463.setBorders(false);
		  
		  //특별공제_11장기주택저당차입금30 공제액
		  LayoutContainer layoutContainer_469 = new LayoutContainer();
		  
		  FormLayout frmlytSch311 = new FormLayout();  
		  frmlytSch311.setLabelWidth(50); 
		  frmlytSch311.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_469.setLayout(frmlytSch311);
		  
		  spchRe30 = new   MSFNumberField();
		  spchRe30.setReadOnly(true);
		  
		  spchRe30.setAllowDecimals(true); 
		  spchRe30.setPropertyEditorType(Long.class); 
		  spchRe30.setFormat(NumberFormat.getDecimalFormat());
		  spchRe30.setFieldLabel("공제액");
		  
		  layoutContainer_469.add(spchRe30, new FormData("100%"));
		 
		  layoutContainer_313.add(layoutContainer_469, new FormData("100%"));
		  layoutContainer_469.setBorders(false);
		  
//		  layoutContainer_311.add(layoutContainer_313, new com.extjs.gxt.ui.client.widget.layout.ColumnData(210.0));
		  layoutContainer_311.add(layoutContainer_313, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		  
		  layoutContainer_313.setBorders(false);
		  
		  
		  fldstNewFieldset_24.add(layoutContainer_311, new FormData("100%"));
		  layoutContainer_306.add(fldstNewFieldset_24, new FormData("100%"));
		  fldstNewFieldset_24.setHeadingHtml("2011년 이전 차입분");
		  layoutContainer_305.add(layoutContainer_306, new FormData("100%"));
		  layoutContainer_306.setBorders(false);
		  
		 
		  layoutContainer_469.setLayout(frmlytSch311);
		  
		  LayoutContainer layoutContainer_307 = new LayoutContainer();
		  frmlytSch301 = new FormLayout();  
			frmlytSch301.setLabelWidth(100); 
			frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
			  
			layoutContainer_307.setLayout(frmlytSch301);
		  FieldSet fldstNewFieldset_25 = new FieldSet();
		  fldstNewFieldset_25.setHeadingHtml("2012년 이후 차입분(15년이상)");
		  
		  LayoutContainer layoutContainer_308 = new LayoutContainer();
		  layoutContainer_308.setLayout(new ColumnLayout());
		  
		  LayoutContainer layoutContainer_309 = new LayoutContainer();
		  frmlytSch301 = new FormLayout();  
			frmlytSch301.setLabelWidth(100); 
			frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
			  
			layoutContainer_309.setLayout(frmlytSch301);
		  
		  //고정금리.비거치상환
		  LayoutContainer layoutContainer_464= new LayoutContainer();
		  layoutContainer_464.setBorders(false);
		  
		  FormLayout frmlytSch312 = new FormLayout();  
		  frmlytSch312.setLabelWidth(240); 
		  frmlytSch312.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_464.setLayout(frmlytSch312);
		  
		  spchRefx = new MSFNumberField();
		  
		  spchRefx.setAllowDecimals(true); 
		  spchRefx.setPropertyEditorType(Long.class); 
		  spchRefx.setFormat(NumberFormat.getDecimalFormat());
		  spchRefx.setFieldLabel("고정금리.비거치상환");
			
		  layoutContainer_464.add(spchRefx, new FormData("100%"));
		 
		  layoutContainer_309.add(layoutContainer_464, new FormData("100%"));
		  layoutContainer_464.setBorders(false);
		  
		  //기타대출
		  LayoutContainer layoutContainer_465= new LayoutContainer();
		  
		  FormLayout frmlytSch313 = new FormLayout();  
		  frmlytSch313.setLabelWidth(240); 
		  frmlytSch313.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_465.setLayout(frmlytSch313);
		  
		  spchReec = new MSFNumberField();
		  
		  spchReec.setAllowDecimals(true); 
		  spchReec.setPropertyEditorType(Long.class); 
		  spchReec.setFormat(NumberFormat.getDecimalFormat());
		  spchReec.setFieldLabel("기타대출");
			
		  layoutContainer_465.add(spchReec, new FormData("100%"));
		  
		  layoutContainer_309.add(layoutContainer_465, new FormData("100%"));
		  layoutContainer_465.setBorders(false);
		  
//		  layoutContainer_308.add(layoutContainer_309, new com.extjs.gxt.ui.client.widget.layout.ColumnData(321.0));
		  layoutContainer_308.add(layoutContainer_309, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  
		  layoutContainer_309.setBorders(false);
		  
		  LayoutContainer layoutContainer_310 = new LayoutContainer();
		  frmlytSch312 = new FormLayout();  
		  frmlytSch312.setLabelWidth(240); 
		  frmlytSch312.setLabelAlign(LabelAlign.RIGHT); 
		  layoutContainer_310.setLayout(frmlytSch312);
		  //특별공제_12장기주택저당차입금_고정 공제액
		  LayoutContainer layoutContainer_466= new LayoutContainer();
		  
		  FormLayout frmlytSch314 = new FormLayout();  
		  frmlytSch314.setLabelWidth(50); 
		  frmlytSch314.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_466.setLayout(frmlytSch314);
		  
		  spchRefx01 = new  MSFNumberField();
		  spchRefx01.setReadOnly(true);
		  spchRefx01.setAllowDecimals(true); 
		  spchRefx01.setPropertyEditorType(Long.class); 
		  spchRefx01.setFormat(NumberFormat.getDecimalFormat());
		  spchRefx01.setFieldLabel("공제액");
			
		  layoutContainer_466.add(spchRefx01, new FormData("100%"));
		 
		  layoutContainer_310.add(layoutContainer_466, new FormData("100%"));
		  layoutContainer_466.setBorders(false);
		  
		  //특별공제_12장기주택저당차입금_기타 공제액
		  LayoutContainer layoutContainer_467= new LayoutContainer();
		  
		  FormLayout frmlytSch315 = new FormLayout();  
		  frmlytSch315.setLabelWidth(50); 
		  frmlytSch315.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_467.setLayout(frmlytSch315);
		  
		  spchReec01 = new   MSFNumberField();
		  spchReec01.setReadOnly(true);
		  
		  spchReec01.setAllowDecimals(true); 
		  spchReec01.setPropertyEditorType(Long.class); 
		  spchReec01.setFormat(NumberFormat.getDecimalFormat());
		  spchReec01.setFieldLabel("공제액");
		  
		  layoutContainer_467.add(spchReec01, new FormData("100%"));
		 
		  layoutContainer_310.add(layoutContainer_467, new FormData("100%"));
		  layoutContainer_467.setBorders(false);
		  
		  layoutContainer_308.add(layoutContainer_310, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		  
		  layoutContainer_310.setBorders(false);
		  
		  
		  fldstNewFieldset_25.add(layoutContainer_308, new FormData("100%"));
		  
		  layoutContainer_307.add(fldstNewFieldset_25, new FormData("100%"));
		  fldstNewFieldset_25.setCollapsible(false);
		  
		  
		  FieldSet fldstNewFieldset_28 = new FieldSet();
		  fldstNewFieldset_28.setHeadingHtml("2015년 이후 차입분");
		  
		  LayoutContainer layoutContainer_348 = new LayoutContainer();
		  layoutContainer_348.setLayout(new ColumnLayout());
		  
		  
		  LayoutContainer layoutContainer_349 = new LayoutContainer();
		  
		  frmlytSch312 = new FormLayout();  
		  frmlytSch312.setLabelWidth(240); 
		  frmlytSch312.setLabelAlign(LabelAlign.RIGHT); 
		  layoutContainer_349.setLayout(frmlytSch312);
		  
		  //특별공제_15장기주택저당_15고정AND비거치상환
		  LayoutContainer layoutContainer_350 = new LayoutContainer();
		  
		  frmlytSch312 = new FormLayout();  
		  frmlytSch312.setLabelWidth(240); 
		  frmlytSch312.setLabelAlign(LabelAlign.RIGHT); 
		  layoutContainer_350.setLayout(frmlytSch312);
		  
		  spch15fx = new MSFNumberField();
		  
		  spch15fx.setAllowDecimals(true); 
		  spch15fx.setPropertyEditorType(Long.class); 
		  spch15fx.setFormat(NumberFormat.getDecimalFormat());
		  spch15fx.setFieldLabel("고정금리.비거치상환 대출(15년이상)");
			
		  layoutContainer_350.add(spch15fx, new FormData("100%"));
		 
		  layoutContainer_349.add(layoutContainer_350, new FormData("100%"));
		  
		  
		  //특별공제_15장기주택저당_15고정OR비거치상환
		  LayoutContainer layoutContainer_351 = new LayoutContainer();
		  
		  frmlytSch312 = new FormLayout();  
		  frmlytSch312.setLabelWidth(240); 
		  frmlytSch312.setLabelAlign(LabelAlign.RIGHT); 
		  layoutContainer_351.setLayout(frmlytSch312);
		  
		  spch15fb = new MSFNumberField();
		  
		  spch15fb.setAllowDecimals(true); 
		  spch15fb.setPropertyEditorType(Long.class); 
		  spch15fb.setFormat(NumberFormat.getDecimalFormat());
			
		  spch15fb.setFieldLabel("고정금리/비거치상환 대출(15년이상)");
		  layoutContainer_351.add(spch15fb, new FormData("100%"));
		  layoutContainer_349.add(layoutContainer_351, new FormData("100%"));
		  
		  
		  
		  //특별공제_15장기주택저당_15기타대출
		  LayoutContainer layoutContainer_352 = new LayoutContainer();
		  
		  frmlytSch312 = new FormLayout();  
		  frmlytSch312.setLabelWidth(240); 
		  frmlytSch312.setLabelAlign(LabelAlign.RIGHT); 
		  layoutContainer_352.setLayout(frmlytSch312);
		  
		  spch15ec = new MSFNumberField();
		  
		  spch15ec.setAllowDecimals(true); 
		  spch15ec.setPropertyEditorType(Long.class); 
		  spch15ec.setFormat(NumberFormat.getDecimalFormat());
			
		  spch15ec.setFieldLabel("기타대출(15년이상)");
		  layoutContainer_352.add(spch15ec, new FormData("100%"));
		  layoutContainer_349.add(layoutContainer_352, new FormData("100%"));
		  
		  
		  
		  //특별공제_15장기주택저당_10고정OR비거치상환
		  LayoutContainer layoutContainer_353 = new LayoutContainer();
		  
		  frmlytSch312 = new FormLayout();  
		  frmlytSch312.setLabelWidth(240); 
		  frmlytSch312.setLabelAlign(LabelAlign.RIGHT); 
		  layoutContainer_353.setLayout(frmlytSch312);
		  
		  spch10fb = new  MSFNumberField();
		  spch10fb.setReadOnly(true);
		  
		  spch10fb.setAllowDecimals(true); 
		  spch10fb.setPropertyEditorType(Long.class); 
		  spch10fb.setFormat(NumberFormat.getDecimalFormat());
			 
		  spch10fb.setFieldLabel("고정금리/비거치상환 대출(10년 ~ 15년)");
		  layoutContainer_353.add(spch10fb, new FormData("100%"));
		  layoutContainer_349.add(layoutContainer_353, new FormData("100%"));
		  
		  
		  
		  layoutContainer_348.add(layoutContainer_349, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		  
		  LayoutContainer layoutContainer_354 = new LayoutContainer();
		  frmlytSch301 = new FormLayout();  
			frmlytSch301.setLabelWidth(100); 
			frmlytSch301.setLabelAlign(LabelAlign.RIGHT); 
			  
			layoutContainer_354.setLayout(frmlytSch301);
		  //특별공제_15장기주택저당_15고정AND비거치상환 공제액
		  LayoutContainer layoutContainer_355= new LayoutContainer();
		  
		  FormLayout frmlytSch3148 = new FormLayout();  
		  frmlytSch3148.setLabelWidth(50); 
		  frmlytSch3148.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_355.setLayout(frmlytSch3148);
		  
		  spci15fx = new   MSFNumberField();
		  spci15fx.setReadOnly(true);
		  
		  spci15fx.setAllowDecimals(true); 
		  spci15fx.setPropertyEditorType(Long.class); 
		  spci15fx.setFormat(NumberFormat.getDecimalFormat());
			
		  layoutContainer_355.add(spci15fx, new FormData("100%"));
		  spci15fx.setFieldLabel("공제액");
		  layoutContainer_354.add(layoutContainer_355, new FormData("100%"));
		  layoutContainer_355.setBorders(false);
		  
		  //특별공제_15장기주택저당_15고정OR비거치상환 공제액
		  LayoutContainer layoutContainer_356= new LayoutContainer();
		  
		  frmlytSch315 = new FormLayout();  
		  frmlytSch315.setLabelWidth(50); 
		  frmlytSch315.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_356.setLayout(frmlytSch315);
		  
		  spci15fb = new   MSFNumberField();
		  spci15fb.setReadOnly(true);
		  
		  spci15fb.setAllowDecimals(true); 
		  spci15fb.setPropertyEditorType(Long.class); 
		  spci15fb.setFormat(NumberFormat.getDecimalFormat());
			
		  layoutContainer_356.add(spci15fb, new FormData("100%"));
		  spci15fb.setFieldLabel("공제액");
		  layoutContainer_354.add(layoutContainer_356, new FormData("100%"));
		  layoutContainer_356.setBorders(false);
		  
		  
		  
		  //특별공제_15장기주택저당_15기타대출 공제액
		  LayoutContainer layoutContainer_357= new LayoutContainer();
		  
		  frmlytSch315 = new FormLayout();  
		  frmlytSch315.setLabelWidth(50); 
		  frmlytSch315.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_357.setLayout(frmlytSch315);
		  
		  spci15ec = new   MSFNumberField();
		  spci15ec.setReadOnly(true);
		  
		  spci15ec.setAllowDecimals(true); 
		  spci15ec.setPropertyEditorType(Long.class); 
		  spci15ec.setFormat(NumberFormat.getDecimalFormat());
			
		  layoutContainer_357.add(spci15ec, new FormData("100%"));
		  spci15ec.setFieldLabel("공제액");
		  layoutContainer_354.add(layoutContainer_357, new FormData("100%"));
		  layoutContainer_357.setBorders(false);
		  
		  //특별공제_15장기주택저당_10고정OR비거치상환 공제액
		  LayoutContainer layoutContainer_358= new LayoutContainer();
		  
		  frmlytSch315 = new FormLayout();  
		  frmlytSch315.setLabelWidth(50); 
		  frmlytSch315.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_358.setLayout(frmlytSch315);
		  
		  spci10fb = new  MSFNumberField();
		  spci10fb.setReadOnly(true);
		  
		  spci10fb.setAllowDecimals(true); 
		  spci10fb.setPropertyEditorType(Long.class); 
		  spci10fb.setFormat(NumberFormat.getDecimalFormat());
			
		  layoutContainer_358.add(spci10fb, new FormData("100%"));
		  spci10fb.setFieldLabel("공제액");
		  layoutContainer_354.add(layoutContainer_358, new FormData("100%"));
		  layoutContainer_358.setBorders(false);
		  
		  layoutContainer_348.add(layoutContainer_354, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		  
		  fldstNewFieldset_28.add(layoutContainer_348, new FormData("100%"));
		  layoutContainer_307.add(fldstNewFieldset_28, new FormData("100%"));
		  
		  layoutContainer_305.add(layoutContainer_307, new FormData("100%"));
		  layoutContainer_307.setBorders(false);
		  
		  
		  fldstNewFieldset_23.add(layoutContainer_305, new FormData("100%"));
		  fldstNewFieldset_20.add(fldstNewFieldset_23, new FormData("100%"));
//		  fldstNewFieldset_20.add(layoutContainer_303);
//		  layoutContainer_303.setBorders(false);
		  
		  //주택자금공제계
		  LayoutContainer layoutContainer_304 = new LayoutContainer();
		  
		  FormLayout frmlytSch140 = new FormLayout();  
		  frmlytSch140.setLabelWidth(430); 
		  frmlytSch140.setLabelAlign(LabelAlign.RIGHT); 
		  
		  layoutContainer_304.setLayout(frmlytSch140);
		  
		  spchReto = new   MSFNumberField();
		  spchReto.setReadOnly(true);
		  
		  spchReto.setAllowDecimals(true); 
		  spchReto.setPropertyEditorType(Long.class); 
		  spchReto.setFormat(NumberFormat.getDecimalFormat());
			
		  layoutContainer_304.add(spchReto, new FormData("100%"));
		  spchReto.setFieldLabel("주택자금공제계");
		  fldstNewFieldset_20.add(layoutContainer_304, new FormData("100%"));
		  layoutContainer_304.setBorders(false);
		  
		  
		  
		  layoutContainer_300.add(fldstNewFieldset_20);
		  fldstNewFieldset_20.setHeadingHtml("주택자금공제");
		  cntntpnlNewContentpanel_2.add(layoutContainer_300);
		  layoutContainer_300.setBorders(true);
		  itemYeta05_2.add(cntntpnlNewContentpanel_2);
//		  cntntpnlNewContentpanel_2.setSize(650, 440);
		  cntntpnlNewContentpanel_2.setSize(650, 420);
		  tabsItemYeta05.add(itemYeta05_2);
		  
		  
//		  itemYeta05_1.setWidth("");
		  layoutContainer_12.add(tabsItemYeta05);
		  tabsItemYeta05.setHeight("480");
		  cp01.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		  layoutContainer_12.setHeight("480");
		  layoutContainer_12.setBorders(false);
	
		  cp01.add(layoutContainer_12);
		  lcTabFormLayer.add(cp01);
		
		  return lcTabFormLayer;
	}	

	private LayoutContainer yetaData06() {
		
		
		ContentPanel cp01 = new ContentPanel();
		
		cp01.setScrollMode(Scroll.AUTOY);//스크롤
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
//		cp01.setSize("660", "450");
		  
		LayoutContainer layoutContainer_13 = new LayoutContainer();

		// 연금저축공제
		LayoutContainer layoutContainer_199 = new LayoutContainer();

		FieldSet fldstNewFieldset_14 = new FieldSet();

		LayoutContainer layoutContainer_202 = new LayoutContainer();
		layoutContainer_202.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_203 = new LayoutContainer();
		layoutContainer_203.setBorders(false);
		layoutContainer_203.setLayout(new ColumnLayout());

		// 개인납입금액
		LayoutContainer layoutContainer_205 = new LayoutContainer();

		FormLayout frmlytSch36 = new FormLayout();
		frmlytSch36.setLabelWidth(80);
		frmlytSch36.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_205.setLayout(frmlytSch36);

		prvm20be = new MSFNumberField();
		
		prvm20be.setAllowDecimals(true); 
		prvm20be.setPropertyEditorType(Long.class); 
		prvm20be.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_205.add(prvm20be, new FormData("100%"));
		prvm20be.setFieldLabel("개인납입금액");
		layoutContainer_203.add(layoutContainer_205, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		  
		LayoutContainer layoutContainer_206 = new LayoutContainer();

		LabelField lblfldNewLabelfield_33 = new LabelField("(2000년이전가입)");
		layoutContainer_206.add(lblfldNewLabelfield_33);
		layoutContainer_203.add(layoutContainer_206, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		  
		  
		layoutContainer_202.add(layoutContainer_203, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  
		// 개인연금저축불입액_2000년이전 공제액
		LayoutContainer layoutContainer_204 = new LayoutContainer();

		FormLayout frmlytSch37 = new FormLayout();
		frmlytSch37.setLabelWidth(60);
		frmlytSch37.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_204.setLayout(frmlytSch37);

		etcpPsnv = new    MSFNumberField();
		etcpPsnv.setReadOnly(true);
		
		etcpPsnv.setAllowDecimals(true); 
		etcpPsnv.setPropertyEditorType(Long.class); 
		etcpPsnv.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_204.add(etcpPsnv, new FormData("100%"));
		etcpPsnv.setFieldLabel("공제액");
		layoutContainer_202.add(layoutContainer_204, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_204.setBorders(false);
		  
		fldstNewFieldset_14.add(layoutContainer_202, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_199.add(fldstNewFieldset_14);
		fldstNewFieldset_14.setHeadingHtml("연금저축공제");
		layoutContainer_13.add(layoutContainer_199);
		layoutContainer_199.setBorders(false);
		  
		  
		LayoutContainer layoutContainer_207 = new LayoutContainer();
		layoutContainer_207.setLayout(new ColumnLayout());
		  
		  
		// 소기업.소상공인공제부금 불입금
		LayoutContainer layoutContainer_208 = new LayoutContainer();
		layoutContainer_208.setBorders(false);

		FormLayout frmlytSch38 = new FormLayout();
		frmlytSch38.setLabelWidth(200);
		frmlytSch38.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_208.setLayout(frmlytSch38);

		etchPrep = new MSFNumberField();
		
		etchPrep.setAllowDecimals(true); 
		etchPrep.setPropertyEditorType(Long.class); 
		etchPrep.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_208.add(etchPrep, new FormData("100%"));
		etchPrep.setFieldLabel("소기업.소상공인공제부금 불입금");
		layoutContainer_207.add(layoutContainer_208, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  
		// 기타공제_소기업공제불입금액 공제액
		LayoutContainer layoutContainer_209 = new LayoutContainer();

		FormLayout frmlytSch39 = new FormLayout();
		frmlytSch39.setLabelWidth(60);
		frmlytSch39.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_209.setLayout(frmlytSch39);

		etchPrep01 = new    MSFNumberField();
		etchPrep01.setReadOnly(true);
		
		etchPrep01.setAllowDecimals(true); 
		etchPrep01.setPropertyEditorType(Long.class); 
		etchPrep01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_209.add(etchPrep01, new FormData("95%"));
		etchPrep01.setFieldLabel("공제액");
		layoutContainer_207.add(layoutContainer_209, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_209.setBorders(false);

		layoutContainer_13.add(layoutContainer_207);
		layoutContainer_207.setBorders(false);
		  
		  
		// 주택마련저축소득공제
		LayoutContainer layoutContainer_200 = new LayoutContainer();

		FieldSet fldstNewFieldset_15 = new FieldSet();
		fldstNewFieldset_15.setHeadingHtml("주택마련저축소득공제");

		LayoutContainer layoutContainer_210 = new LayoutContainer();
		layoutContainer_210.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_211 = new LayoutContainer();
		layoutContainer_211.setBorders(false);

		// 청약저축
		LayoutContainer layoutContainer_213 = new LayoutContainer();

		FormLayout frmlytSch40 = new FormLayout();
		frmlytSch40.setLabelWidth(140);
		frmlytSch40.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_213.setLayout(frmlytSch40);

		etcsComp = new MSFNumberField();
		
		etcsComp.setAllowDecimals(true); 
		etcsComp.setPropertyEditorType(Long.class); 
		etcsComp.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_213.add(etcsComp, new FormData("100%"));
		etcsComp.setFieldLabel("청약저축");
		layoutContainer_211.add(layoutContainer_213);
		layoutContainer_213.setBorders(false);

		// 주택청약종합저축
		LayoutContainer layoutContainer_214 = new LayoutContainer();

		FormLayout frmlytSch41 = new FormLayout();
		frmlytSch41.setLabelWidth(140);
		frmlytSch41.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_214.setLayout(frmlytSch41);

		etwkHsbm = new MSFNumberField();
		
		etwkHsbm.setAllowDecimals(true); 
		etwkHsbm.setPropertyEditorType(Long.class); 
		etwkHsbm.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_214.add(etwkHsbm, new FormData("100%"));
		etwkHsbm.setFieldLabel("주택청약종합저축");
		layoutContainer_211.add(layoutContainer_214);
		layoutContainer_214.setBorders(false);

		// 근로자주택마련저축
		LayoutContainer layoutContainer_215 = new LayoutContainer();

		FormLayout frmlytSch42 = new FormLayout();
		frmlytSch42.setLabelWidth(140);
		frmlytSch42.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_215.setLayout(frmlytSch42);

		etwkHsvm = new MSFNumberField();
		
		etwkHsvm.setAllowDecimals(true); 
		etwkHsvm.setPropertyEditorType(Long.class); 
		etwkHsvm.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_215.add(etwkHsvm, new FormData("100%"));
		etwkHsvm.setFieldLabel("근로자주택마련저축");
		layoutContainer_211.add(layoutContainer_215);
		layoutContainer_215.setBorders(false);

		// 주택마련저축소득공제계
		LayoutContainer layoutContainer_216 = new LayoutContainer();

		FormLayout frmlytSch43 = new FormLayout();
		frmlytSch43.setLabelWidth(140);
		frmlytSch43.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_216.setLayout(frmlytSch43);

		etwkHbdm = new MSFNumberField();
		
		etwkHbdm.setAllowDecimals(true); 
		etwkHbdm.setPropertyEditorType(Long.class); 
		etwkHbdm.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_216.add(etwkHbdm, new FormData("100%"));
		etwkHbdm.setFieldLabel("주택마련저축소득공제계");
		layoutContainer_211.add(layoutContainer_216);
		layoutContainer_216.setBorders(false);
		  
		layoutContainer_210.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_212 = new LayoutContainer();
		layoutContainer_212.setBorders(false);

		// 기타공제_주택마련저축_청약저축 공제액
		LayoutContainer layoutContainer_217 = new LayoutContainer();

		FormLayout frmlytSch44 = new FormLayout();
		frmlytSch44.setLabelWidth(60);
		frmlytSch44.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_217.setLayout(frmlytSch44);

		etcsComp01 = new   MSFNumberField();
		etcsComp01.setReadOnly(true);
		
		
		etcsComp01.setAllowDecimals(true); 
		etcsComp01.setPropertyEditorType(Long.class); 
		etcsComp01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_217.add(etcsComp01, new FormData("100%"));
		etcsComp01.setFieldLabel("공제액");
		layoutContainer_212.add(layoutContainer_217);
		layoutContainer_217.setBorders(false);

		// 기타공제_주택마련저축_주택청약종합저축 공제액
		LayoutContainer layoutContainer_218 = new LayoutContainer();

		FormLayout frmlytSch45 = new FormLayout();
		frmlytSch45.setLabelWidth(60);
		frmlytSch45.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_218.setLayout(frmlytSch45);

		etwkSbam = new   MSFNumberField();
		etwkSbam.setReadOnly(true);
		
		etwkSbam.setAllowDecimals(true); 
		etwkSbam.setPropertyEditorType(Long.class); 
		etwkSbam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_218.add(etwkSbam, new FormData("100%"));
		etwkSbam.setFieldLabel("공제액");
		layoutContainer_212.add(layoutContainer_218);
		layoutContainer_218.setBorders(false);

		// 기타공제_주택마련저축_근로자주택마련저축 공제액
		LayoutContainer layoutContainer_219 = new LayoutContainer();

		FormLayout frmlytSch46 = new FormLayout();
		frmlytSch46.setLabelWidth(60);
		frmlytSch46.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_219.setLayout(frmlytSch46);

		etwkSvam = new    MSFNumberField();
		etwkSvam.setReadOnly(true);
		etwkSvam.setAllowDecimals(true); 
		etwkSvam.setPropertyEditorType(Long.class); 
		etwkSvam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_219.add(etwkSvam, new FormData("100%"));
		etwkSvam.setFieldLabel("공제액");
		layoutContainer_212.add(layoutContainer_219);
		layoutContainer_219.setBorders(false);

		// 기타공제_주택마련저축소득공제계
		LayoutContainer layoutContainer_220 = new LayoutContainer();

		FormLayout frmlytSch47 = new FormLayout();
		frmlytSch47.setLabelWidth(60);
		frmlytSch47.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_220.setLayout(frmlytSch47);

		etwkBdam = new    MSFNumberField();
		etwkBdam.setReadOnly(true);
		
		etwkBdam.setAllowDecimals(true); 
		etwkBdam.setPropertyEditorType(Long.class); 
		etwkBdam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_220.add(etwkBdam, new FormData("100%"));
		etwkBdam.setFieldLabel("공제액계");
		layoutContainer_212.add(layoutContainer_220);
		layoutContainer_220.setBorders(false);
		  
		layoutContainer_210.add(layoutContainer_212, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		fldstNewFieldset_15.add(layoutContainer_210);
		layoutContainer_200.add(fldstNewFieldset_15);
		layoutContainer_13.add(layoutContainer_200);
		layoutContainer_200.setBorders(false);

		LayoutContainer layoutContainer_222 = new LayoutContainer();

		FieldSet fldstNewFieldset_17 = new FieldSet();

		LayoutContainer layoutContainer_223 = new LayoutContainer();
		layoutContainer_223.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_224 = new LayoutContainer();

		LayoutContainer layoutContainer_242 = new LayoutContainer();
		layoutContainer_242.setLayout(new ColumnLayout());

		// 출자.투자금액
		LayoutContainer layoutContainer_250 = new LayoutContainer();
		layoutContainer_250.setBorders(false);

		FormLayout frmlytSch80 = new FormLayout();
		frmlytSch80.setLabelWidth(100);
		frmlytSch80.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_250.setLayout(frmlytSch80);

		etgdH14f = new MSFNumberField();
		
		etgdH14f.setAllowDecimals(true); 
		etgdH14f.setPropertyEditorType(Long.class); 
		etgdH14f.setFormat(NumberFormat.getDecimalFormat());
//		etgdH14f.setEmptyText("10%(20%) 공제율 적용금액");	
		
		layoutContainer_250.add(etgdH14f, new FormData("100%"));
		etgdH14f.setFieldLabel("출자∙투자금액");
		layoutContainer_242.add(layoutContainer_250, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		  
		// (2012년도)
		LayoutContainer layoutContainer_251 = new LayoutContainer();
		layoutContainer_251.setBorders(false);

		LabelField lblfldNewLabelfield_34 = new LabelField("(2014년조합)");
		layoutContainer_251.add(lblfldNewLabelfield_34);
		layoutContainer_242.add(layoutContainer_251, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_242);
		layoutContainer_242.setBorders(false);

		LayoutContainer layoutContainer_243 = new LayoutContainer();
		layoutContainer_243.setLayout(new ColumnLayout());

		// 출자.투자금액
		LayoutContainer layoutContainer_252 = new LayoutContainer();

		FormLayout frmlytSch81 = new FormLayout();
		frmlytSch81.setLabelWidth(100);
		frmlytSch81.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_252.setLayout(frmlytSch81);

		etgdH14b = new MSFNumberField();
		
		etgdH14b.setAllowDecimals(true); 
		etgdH14b.setPropertyEditorType(Long.class); 
		etgdH14b.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_252.add(etgdH14b, new FormData("100%"));
		etgdH14b.setFieldLabel("출자∙투자금액");
		layoutContainer_243.add(layoutContainer_252, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_252.setBorders(false);

		// (2013년도)
		LayoutContainer layoutContainer_253 = new LayoutContainer();

		LabelField lblfldNewLabelfield_35 = new LabelField("(2014년벤처)");
		layoutContainer_253.add(lblfldNewLabelfield_35);
		layoutContainer_243.add(layoutContainer_253, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_253.setBorders(false);

		layoutContainer_224.add(layoutContainer_243);
		layoutContainer_243.setBorders(false);

	 	LayoutContainer layoutContainer_244 = new LayoutContainer();
		layoutContainer_244.setLayout(new ColumnLayout());

		// 출자.투자금액
    LayoutContainer layoutContainer_254 = new LayoutContainer();

		FormLayout frmlytSch82 = new FormLayout();
		frmlytSch82.setLabelWidth(100);
		frmlytSch82.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_254.setLayout(frmlytSch82);

		etclH15f = new MSFNumberField();
		
		etclH15f.setAllowDecimals(true); 
		etclH15f.setPropertyEditorType(Long.class); 
		etclH15f.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_254.add(etclH15f, new FormData("100%"));
		etclH15f.setFieldLabel("출자∙투자금액");
		layoutContainer_244.add(layoutContainer_254, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_254.setBorders(false);
		  
		// (2014년도)
	 	LayoutContainer layoutContainer_255 = new LayoutContainer();

		LabelField lblfldNewLabelfield_36 = new LabelField("(2015년조합)");
		layoutContainer_255.add(lblfldNewLabelfield_36);
		layoutContainer_244.add(layoutContainer_255, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_255.setBorders(false);

		layoutContainer_224.add(layoutContainer_244);
		layoutContainer_244.setBorders(false);

		// --
		// (2015년 이후 출자∙투자분)
		 LayoutContainer layoutContainer_2545 = new LayoutContainer();

		frmlytSch82 = new FormLayout();
		frmlytSch82.setLabelWidth(100);
		frmlytSch82.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_2545.setLayout(frmlytSch82);

		etclH15b = new MSFNumberField();
		
		etclH15b.setAllowDecimals(true); 
		etclH15b.setPropertyEditorType(Long.class); 
		etclH15b.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2545.add(etclH15b, new FormData("100%"));
		etclH15b.setFieldLabel("출자∙투자금액");
		layoutContainer_244.add(layoutContainer_2545, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_2545.setBorders(false);
		  
		// (2015년도)
		LayoutContainer layoutContainer_2555 = new LayoutContainer();

		LabelField lblfldNewLabelfield_366 = new LabelField("(2015년벤처)");
		layoutContainer_2555.add(lblfldNewLabelfield_366);
		layoutContainer_244.add(layoutContainer_2555, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_2555.setBorders(false);

		layoutContainer_224.add(layoutContainer_244);
		layoutContainer_244.setBorders(false);
		
		
		//------------------2016년도   -----------------------------------------------------------
		
		LayoutContainer layoutContainer_244a = new LayoutContainer();
		layoutContainer_244a.setLayout(new ColumnLayout());

		// 출자.투자금액
		LayoutContainer layoutContainer_254a = new LayoutContainer();

		FormLayout frmlytSch82a = new FormLayout();
		frmlytSch82a.setLabelWidth(100);
		frmlytSch82a.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_254a.setLayout(frmlytSch82a);

		etclH16f = new MSFNumberField();
		
		etclH16f.setAllowDecimals(true); 
		etclH16f.setPropertyEditorType(Long.class); 
		etclH16f.setFormat(NumberFormat.getDecimalFormat());
		
		etclH16f.setFieldLabel("출자∙투자금액");
		layoutContainer_254a.add(etclH16f, new FormData("100%"));
		layoutContainer_244a.add(layoutContainer_254a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_254a.setBorders(false);
		  
		// (2016년도)
		LayoutContainer layoutContainer_255a = new LayoutContainer();

		LabelField lblfldNewLabelfield_36a = new LabelField("(2016년조합)");
		layoutContainer_255a.add(lblfldNewLabelfield_36a);
		layoutContainer_244a.add(layoutContainer_255a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_255a.setBorders(false);

		layoutContainer_224.add(layoutContainer_244a);
		layoutContainer_244a.setBorders(false);

		// --
		// (2016년 이후 출자∙투자분)
		LayoutContainer layoutContainer_2545a = new LayoutContainer();

		frmlytSch82a = new FormLayout();
		frmlytSch82a.setLabelWidth(100);
		frmlytSch82a.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_2545a.setLayout(frmlytSch82a);

		etclH16b = new MSFNumberField();
		
		etclH16b.setAllowDecimals(true); 
		etclH16b.setPropertyEditorType(Long.class); 
		etclH16b.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2545a.add(etclH16b, new FormData("100%"));
		etclH16b.setFieldLabel("출자∙투자금액");
		layoutContainer_244a.add(layoutContainer_2545a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_2545a.setBorders(false);
		  
		// (2015년도)
		LayoutContainer layoutContainer_2555a = new LayoutContainer();

		LabelField lblfldNewLabelfield_366a = new LabelField("(2016년벤처)");
		layoutContainer_2555a.add(lblfldNewLabelfield_366a);
		layoutContainer_244a.add(layoutContainer_2555a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_2555a.setBorders(false);

		layoutContainer_224.add(layoutContainer_244a);
		layoutContainer_244a.setBorders(false);

	//------------------------2016년도 --------------------------------------------------------------------------------------------	
		

		LayoutContainer layoutContainer_245 = new LayoutContainer();
		layoutContainer_245.setLayout(new ColumnLayout());

		// 출자.투자금액계
		LayoutContainer layoutContainer_256 = new LayoutContainer();
		layoutContainer_256.setBorders(false);

		FormLayout frmlytSch83 = new FormLayout();
		frmlytSch83.setLabelWidth(100);
		frmlytSch83.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_256.setLayout(frmlytSch83);

		etgdHdam = new   MSFNumberField();
		etgdHdam.setReadOnly(true);
		
		etgdHdam.setAllowDecimals(true); 
		etgdHdam.setPropertyEditorType(Long.class); 
		etgdHdam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_256.add(etgdHdam, new FormData("100%"));
		etgdHdam.setFieldLabel("출자∙투자금액계");
		  
		layoutContainer_245.add(layoutContainer_256, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		LayoutContainer layoutContainer_257 = new LayoutContainer();
		layoutContainer_257.setBorders(false);
		layoutContainer_245.add(layoutContainer_257, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_245);
		layoutContainer_245.setBorders(false);
		  
		layoutContainer_223.add(layoutContainer_224, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_224.setBorders(false);

		LayoutContainer layoutContainer_225 = new LayoutContainer();

		// 기타공제_투자조합출자소득공제_2012년도 공제액
		LayoutContainer layoutContainer_246 = new LayoutContainer();

		FormLayout frmlytSch84 = new FormLayout();
		frmlytSch84.setLabelWidth(60);
		frmlytSch84.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_246.setLayout(frmlytSch84);

		etgdD14f = new  MSFNumberField();
		etgdD14f.setReadOnly(true);
		
		etgdD14f.setAllowDecimals(true); 
		etgdD14f.setPropertyEditorType(Long.class); 
		etgdD14f.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_246.add(etgdD14f, new FormData("100%"));
		etgdD14f.setFieldLabel("공제액");
		layoutContainer_225.add(layoutContainer_246);
		layoutContainer_246.setBorders(false);

		// 기타공제_투자조합출자소득공제_2013년도 공제액
		LayoutContainer layoutContainer_247 = new LayoutContainer();

		FormLayout frmlytSch85 = new FormLayout();
		frmlytSch85.setLabelWidth(60);
		frmlytSch85.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_247.setLayout(frmlytSch85);

		etgdD14b = new   MSFNumberField();
		etgdD14b.setReadOnly(true);
		
		etgdD14b.setAllowDecimals(true); 
		etgdD14b.setPropertyEditorType(Long.class); 
		etgdD14b.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_247.add(etgdD14b, new FormData("100%"));
		etgdD14b.setFieldLabel("공제액");
		layoutContainer_225.add(layoutContainer_247);
		layoutContainer_247.setBorders(false);

		// 기타공제_투자조합출자소득공제_2014년 공제액
		LayoutContainer layoutContainer_248 = new LayoutContainer();

		FormLayout frmlytSch86 = new FormLayout();
		frmlytSch86.setLabelWidth(60);
		frmlytSch86.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_248.setLayout(frmlytSch86);

		etgdD15f = new   MSFNumberField();
		etgdD15f.setReadOnly(true);
		
		etgdD15f.setAllowDecimals(true); 
		etgdD15f.setPropertyEditorType(Long.class); 
		etgdD15f.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_248.add(etgdD15f, new FormData("100%"));
		etgdD15f.setFieldLabel("공제액");
		layoutContainer_225.add(layoutContainer_248);
		layoutContainer_248.setBorders(false);

		// 기타공제_투자조합출자소득공제_2015년이후 공제액
		LayoutContainer layoutContainer_2522 = new LayoutContainer();

		frmlytSch86 = new FormLayout();
		frmlytSch86.setLabelWidth(60);
		frmlytSch86.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_2522.setLayout(frmlytSch86);

		etgdD15b = new   MSFNumberField();
		etgdD15b.setReadOnly(true);
		
		etgdD15b.setAllowDecimals(true); 
		etgdD15b.setPropertyEditorType(Long.class); 
		etgdD15b.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2522.add(etgdD15b, new FormData("100%"));
		etgdD15b.setFieldLabel("공제액");
		layoutContainer_225.add(layoutContainer_2522);
		layoutContainer_2522.setBorders(false);
		
		//----------------------- 2016 공제액  -------------------------------------------------
		
		
		// 기타공제_투자조합출자소득공제_2014년 공제액
		LayoutContainer layoutContainer_248a = new LayoutContainer();

		FormLayout frmlytSch86a = new FormLayout();
		frmlytSch86a.setLabelWidth(60);
		frmlytSch86a.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_248a.setLayout(frmlytSch86a);

		etgdD16f = new   MSFNumberField();
		etgdD16f.setReadOnly(true);
		etgdD16f.setAllowDecimals(true); 
		etgdD16f.setPropertyEditorType(Long.class); 
		etgdD16f.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_248a.add(etgdD16f, new FormData("100%"));
		etgdD16f.setFieldLabel("공제액");
		layoutContainer_225.add(layoutContainer_248a);
		layoutContainer_248a.setBorders(false);

		// 기타공제_투자조합출자소득공제_2015년이후 공제액
		LayoutContainer layoutContainer_2522a = new LayoutContainer();

		frmlytSch86a = new FormLayout();
		frmlytSch86a.setLabelWidth(60);
		frmlytSch86a.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_2522a.setLayout(frmlytSch86a);

		etgdD16b = new    MSFNumberField();
		etgdD16b.setReadOnly(true);
		
		etgdD16b.setAllowDecimals(true); 
		etgdD16b.setPropertyEditorType(Long.class); 
		etgdD16b.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2522a.add(etgdD16b, new FormData("100%"));
		etgdD16b.setFieldLabel("공제액");
		layoutContainer_225.add(layoutContainer_2522a);
		layoutContainer_2522a.setBorders(false);

		
	//-----------------------2016 공제액 ------------------------------------------------------	

		// 공제액계
		LayoutContainer layoutContainer_249 = new LayoutContainer();

		FormLayout frmlytSch87 = new FormLayout();
		frmlytSch87.setLabelWidth(60);
		frmlytSch87.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_249.setLayout(frmlytSch87);

		etgdDdam = new    MSFNumberField();
		etgdDdam.setReadOnly(true);
		
		etgdDdam.setAllowDecimals(true); 
		etgdDdam.setPropertyEditorType(Long.class); 
		etgdDdam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_249.add(etgdDdam, new FormData("100%"));
		etgdDdam.setFieldLabel("공제액계");
		layoutContainer_225.add(layoutContainer_249);
		layoutContainer_249.setBorders(false);
		  
		  
		layoutContainer_223.add(layoutContainer_225, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_225.setBorders(false);

		fldstNewFieldset_17.add(layoutContainer_223);
		layoutContainer_222.add(fldstNewFieldset_17);
		fldstNewFieldset_17.setHeadingHtml("투자조합출자공제(공제율적용금액기입)");
		layoutContainer_13.add(layoutContainer_222);

		// 신용카드등사용액소득공제
		LayoutContainer layoutContainer_201 = new LayoutContainer();

		FieldSet fldstNewFieldset_16 = new FieldSet();

		LayoutContainer layoutContainer_221 = new LayoutContainer();

		LayoutContainer layoutContainer_226 = new LayoutContainer();
		layoutContainer_226.setLayout(new ColumnLayout());
		layoutContainer_226.setBorders(false);

		// 신용카드
		LayoutContainer layoutContainer_229 = new LayoutContainer();

		FormLayout frmlytSch48 = new FormLayout();
		frmlytSch48.setLabelWidth(70);
		frmlytSch48.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_229.setLayout(frmlytSch48);

		etctCard = new   MSFNumberField();
		etctCard.setReadOnly(true);
		
		etctCard.setAllowDecimals(true); 
		etctCard.setPropertyEditorType(Long.class); 
		etctCard.setFormat(NumberFormat.getDecimalFormat());
		
		etctCard.setReadOnly(true);
		layoutContainer_229.add(etctCard, new FormData("100%"));
		etctCard.setFieldLabel("신용카드");
		layoutContainer_226.add(layoutContainer_229, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_229.setBorders(false);

		// 직불카드등
		LayoutContainer layoutContainer_230 = new LayoutContainer();

		FormLayout frmlytSch49 = new FormLayout();
		frmlytSch49.setLabelWidth(70);
		frmlytSch49.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_230.setLayout(frmlytSch49);

		etchBcbs = new  MSFNumberField();
		etchBcbs.setReadOnly(true);
		
		etchBcbs.setAllowDecimals(true); 
		etchBcbs.setPropertyEditorType(Long.class); 
		etchBcbs.setFormat(NumberFormat.getDecimalFormat());
		
		etchBcbs.setReadOnly(true);
		layoutContainer_230.add(etchBcbs, new FormData("100%"));
		etchBcbs.setFieldLabel("직불카드등");
		layoutContainer_226.add(layoutContainer_230, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_230.setBorders(false);
		layoutContainer_221.add(layoutContainer_226);

		LayoutContainer layoutContainer_227 = new LayoutContainer();
		layoutContainer_227.setLayout(new ColumnLayout());

		// 현금영수증
		LayoutContainer layoutContainer_231 = new LayoutContainer();

		FormLayout frmlytSch90 = new FormLayout();
		frmlytSch90.setLabelWidth(70);
		frmlytSch90.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_231.setLayout(frmlytSch90);

		etchUeam = new  MSFNumberField();
		etchUeam.setReadOnly(true);
		
		etchUeam.setAllowDecimals(true); 
		etchUeam.setPropertyEditorType(Long.class); 
		etchUeam.setFormat(NumberFormat.getDecimalFormat());
		
		etchUeam.setReadOnly(true);
		layoutContainer_231.add(etchUeam, new FormData("90%"));
		etchUeam.setFieldLabel("현금영수증");
		layoutContainer_227.add(layoutContainer_231, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_231.setBorders(false);

		// 전통시장
		LayoutContainer layoutContainer_232 = new LayoutContainer();

		FormLayout frmlytSch91 = new FormLayout();
		frmlytSch91.setLabelWidth(70);
		frmlytSch91.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_232.setLayout(frmlytSch91);

		etchMgvd = new   MSFNumberField();
		etchMgvd.setReadOnly(true);
		
		etchMgvd.setAllowDecimals(true); 
		etchMgvd.setPropertyEditorType(Long.class); 
		etchMgvd.setFormat(NumberFormat.getDecimalFormat());
		
		etchMgvd.setReadOnly(true);
		layoutContainer_232.add(etchMgvd, new FormData("100%"));
		etchMgvd.setFieldLabel("전통시장");
		layoutContainer_227.add(layoutContainer_232, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_232.setBorders(false);

		// 대중교통
		LayoutContainer layoutContainer_233 = new LayoutContainer();

		FormLayout frmlytSch92 = new FormLayout();
		frmlytSch92.setLabelWidth(70);
		frmlytSch92.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_233.setLayout(frmlytSch92);

		etchBced = new    MSFNumberField();
		etchBced.setReadOnly(true);
		
		etchBced.setAllowDecimals(true); 
		etchBced.setPropertyEditorType(Long.class); 
		etchBced.setFormat(NumberFormat.getDecimalFormat());
		
		etchBced.setReadOnly(true);
		layoutContainer_233.add(etchBced, new FormData("100%"));
		etchBced.setFieldLabel("대중교통");
		layoutContainer_227.add(layoutContainer_233, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_233.setBorders(false);

		layoutContainer_221.add(layoutContainer_227);
		layoutContainer_227.setBorders(false);

		LayoutContainer layoutContainer_228 = new LayoutContainer();
		layoutContainer_228.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_234 = new LayoutContainer();

		// 신용카드등사용금액계
		LayoutContainer layoutContainer_236 = new LayoutContainer();

		FormLayout frmlytSch93 = new FormLayout();
		frmlytSch93.setLabelWidth(150);
		frmlytSch93.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_236.setLayout(frmlytSch93);

		etchBcue = new    MSFNumberField();
		etchBcue.setReadOnly(true);
		etchBcue.setAllowDecimals(true); 
		etchBcue.setPropertyEditorType(Long.class); 
		etchBcue.setFormat(NumberFormat.getDecimalFormat());
		
		etchBcue.setReadOnly(true);
		layoutContainer_236.add(etchBcue, new FormData("100%"));
		etchBcue.setFieldLabel("신용카드등사용금액계");
		layoutContainer_234.add(layoutContainer_236);
		layoutContainer_236.setBorders(false);

		// 신용카드등(본인2013년)
//		LayoutContainer layoutContainer_237 = new LayoutContainer();
//
//		FormLayout frmlytSch94 = new FormLayout();
//		frmlytSch94.setLabelWidth(150);
//		frmlytSch94.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_237.setLayout(frmlytSch94);
//
//		cardEt13 = new MSFNumberField();
//		
//		cardEt13.setAllowDecimals(true); 
//		cardEt13.setPropertyEditorType(Long.class); 
//		cardEt13.setFormat(NumberFormat.getDecimalFormat());
//		
//		cardEt13.setReadOnly(false);
//		layoutContainer_237.add(cardEt13, new FormData("100%"));
//		cardEt13.setFieldLabel("신용카드등(본인2013년)");
//		layoutContainer_234.add(layoutContainer_237);
//		layoutContainer_237.setBorders(false);

		// 신용카드등(본인2014년)
		LayoutContainer layoutContainer_238 = new LayoutContainer();

		FormLayout frmlytSch95 = new FormLayout();
		frmlytSch95.setLabelWidth(150);
		frmlytSch95.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_238.setLayout(frmlytSch95);

		cardEt14 = new MSFNumberField();
		
		cardEt14.setAllowDecimals(true); 
		cardEt14.setPropertyEditorType(Long.class); 
		cardEt14.setFormat(NumberFormat.getDecimalFormat());
		
		cardEt14.setReadOnly(false);
		layoutContainer_238.add(cardEt14, new FormData("100%"));
		cardEt14.setFieldLabel("신용카드등(본인2014년)");
		layoutContainer_234.add(layoutContainer_238);
		layoutContainer_238.setBorders(false);
		
		
		// 신용카드등(본인2015년)
		LayoutContainer layoutContainer_2015 = new LayoutContainer();

		frmlytSch95 = new FormLayout();
		frmlytSch95.setLabelWidth(150);
		frmlytSch95.setLabelAlign(LabelAlign.RIGHT);

		
		layoutContainer_2015.setLayout(frmlytSch95);

		cardEt15 = new MSFNumberField();
		
		cardEt15.setAllowDecimals(true); 
		cardEt15.setPropertyEditorType(Long.class); 
		cardEt15.setFormat(NumberFormat.getDecimalFormat());
		
		cardEt15.setReadOnly(false);
		layoutContainer_238.add(cardEt15, new FormData("100%"));
		cardEt15.setFieldLabel("신용카드등(본인2015년)");
		layoutContainer_234.add(layoutContainer_2015);
		layoutContainer_2015.setBorders(false);
		  
		layoutContainer_228.add(layoutContainer_234, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_234.setBorders(false);
		
		

		LayoutContainer layoutContainer_235 = new LayoutContainer();

		// 신용카드등사용공제액계
		LayoutContainer layoutContainer_239 = new LayoutContainer();

		FormLayout frmlytSch96 = new FormLayout();
		frmlytSch96.setLabelWidth(150);
		frmlytSch96.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_239.setLayout(frmlytSch96);

		etccCard = new   MSFNumberField();
		etccCard.setReadOnly(true);
		
		etccCard.setAllowDecimals(true); 
		etccCard.setPropertyEditorType(Long.class); 
		etccCard.setFormat(NumberFormat.getDecimalFormat());
		
		etccCard.setReadOnly(true);
		layoutContainer_239.add(etccCard, new FormData("100%"));
		etccCard.setFieldLabel("신용카드등사용공제액계");
		layoutContainer_235.add(layoutContainer_239);
		layoutContainer_239.setBorders(false);

		// 추가공제율(본인2013년)
//		LayoutContainer layoutContainer_240 = new LayoutContainer();
//
//		FormLayout frmlytSch97 = new FormLayout();
//		frmlytSch97.setLabelWidth(150);
//		frmlytSch97.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_240.setLayout(frmlytSch97);
//
//		etadDd13 = new MSFNumberField();
//		
//		etadDd13.setAllowDecimals(true); 
//		etadDd13.setPropertyEditorType(Long.class); 
//		etadDd13.setFormat(NumberFormat.getDecimalFormat());
//		
//		etadDd13.setReadOnly(false);
//		layoutContainer_240.add(etadDd13, new FormData("100%"));
//		etadDd13.setFieldLabel("추가공제율(본인2013년)");
//		layoutContainer_235.add(layoutContainer_240);
//		layoutContainer_240.setBorders(false);

		// 추가공제율(본인2014년하)
		LayoutContainer layoutContainer_241 = new LayoutContainer();

		FormLayout frmlytSch98 = new FormLayout();
		frmlytSch98.setLabelWidth(150);
		frmlytSch98.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_241.setLayout(frmlytSch98);

		etadD14l = new MSFNumberField();
		
		etadD14l.setAllowDecimals(true); 
		etadD14l.setPropertyEditorType(Long.class); 
		etadD14l.setFormat(NumberFormat.getDecimalFormat());
		
		etadD14l.setReadOnly(false);
		layoutContainer_241.add(etadD14l, new FormData("100%"));
		etadD14l.setFieldLabel("추가공제율(본인2014년)");
		layoutContainer_235.add(layoutContainer_241);
		layoutContainer_241.setBorders(false);
		
		
		// 추가공제율(본인2016년상)
		LayoutContainer layoutContainer_578 = new LayoutContainer();

		frmlytSch98 = new FormLayout();
		frmlytSch98.setLabelWidth(150);
		frmlytSch98.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_578.setLayout(frmlytSch98);

		etadD16l = new MSFNumberField();
		
		etadD16l.setAllowDecimals(true); 
		etadD16l.setPropertyEditorType(Long.class); 
		etadD16l.setFormat(NumberFormat.getDecimalFormat());
		
		etadD16l.setReadOnly(false);
		layoutContainer_241.add(etadD16l, new FormData("100%"));
		etadD16l.setFieldLabel("추가공제율(본인2016년상)");
		layoutContainer_235.add(layoutContainer_578);
		layoutContainer_578.setBorders(false);		
		
		
		// 추가공제율(본인2015년하)
//		LayoutContainer layoutContainer_579 = new LayoutContainer();
//
//		frmlytSch98 = new FormLayout();
//		frmlytSch98.setLabelWidth(150);
//		frmlytSch98.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_579.setLayout(frmlytSch98);
//
//		etadD15l = new MSFNumberField();
//		
//		etadD15l.setAllowDecimals(true); 
//		etadD15l.setPropertyEditorType(Long.class); 
//		etadD15l.setFormat(NumberFormat.getDecimalFormat());
//		
//		etadD15l.setReadOnly(false);
//		layoutContainer_579.add(etadD15l, new FormData("100%"));
//		etadD15l.setFieldLabel("추가공제율(본인2015년하)");
//		layoutContainer_235.add(layoutContainer_579);
//		layoutContainer_579.setBorders(false);	

		
		layoutContainer_228.add(layoutContainer_235, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_235.setBorders(false);

		layoutContainer_221.add(layoutContainer_228);
		layoutContainer_228.setBorders(false);

		fldstNewFieldset_16.add(layoutContainer_221);

		layoutContainer_201.add(fldstNewFieldset_16);
		fldstNewFieldset_16.setHeadingHtml("신용카드등사용액소득공제");
		layoutContainer_13.add(layoutContainer_201);
		layoutContainer_201.setBorders(false);

		cp01.add(layoutContainer_13);
		layoutContainer_13.setHeight("450");
		layoutContainer_13.setBorders(false);
		cp01.setHeight("445");
//		cp01.setSize("660", "520");

		return cp01;
	}	
	
	private LayoutContainer yetaData07() {
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "450");
		
		ContentPanel cntntpnlNewContentpane7 = new ContentPanel();
		cntntpnlNewContentpane7.setHeaderVisible(false);
		cntntpnlNewContentpane7.setHeadingText("");

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		layoutContainer_14.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_131 = new LayoutContainer();
		layoutContainer_131.setBorders(false);

		// 우리사주조합연출연금액
		LayoutContainer layoutContainer_133 = new LayoutContainer();

		FormLayout frmlytSch50 = new FormLayout();
		frmlytSch50.setLabelWidth(200);
		frmlytSch50.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_133.setLayout(frmlytSch50);

		etckUnon = new MSFNumberField();
		
		etckUnon.setAllowDecimals(true); 
		etckUnon.setPropertyEditorType(Long.class); 
		etckUnon.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_133.add(etckUnon, new FormData("100%"));
		etckUnon.setFieldLabel("우리사주조합연출연금액");
		layoutContainer_131.add(layoutContainer_133);
		layoutContainer_133.setBorders(false);

		// 우리사주조합기부금
		LayoutContainer layoutContainer_135 = new LayoutContainer();

		FormLayout frmlytSch51 = new FormLayout();
		frmlytSch51.setLabelWidth(200);
		frmlytSch51.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_135.setLayout(frmlytSch51);

		etckUncb = new MSFNumberField();
		etckUncb.setReadOnly(true);
		etckUncb.setAllowDecimals(true); 
		etckUncb.setPropertyEditorType(Long.class); 
		etckUncb.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_135.add(etckUncb, new FormData("100%"));
		etckUncb.setFieldLabel("우리사주조합기부금");
		layoutContainer_131.add(layoutContainer_135);
		layoutContainer_135.setBorders(false);

		// 고용유지중소기업근로자 임금삭감액
		LayoutContainer layoutContainer_136 = new LayoutContainer();

		FormLayout frmlytSch52 = new FormLayout();
		frmlytSch52.setLabelWidth(200);
		frmlytSch52.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_136.setLayout(frmlytSch52);

		etepHsam = new MSFNumberField();
		
		etepHsam.setAllowDecimals(true); 
		etepHsam.setPropertyEditorType(Long.class); 
		etepHsam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_136.add(etepHsam, new FormData("100%"));
		etepHsam.setFieldLabel("고용유지중소기업근로자 임금삭감액");
		layoutContainer_131.add(layoutContainer_136);
		layoutContainer_136.setBorders(false);

		// 목돈안드는전세이자상환액
		LayoutContainer layoutContainer_137 = new LayoutContainer();

		FormLayout frmlytSch53 = new FormLayout();
		frmlytSch53.setLabelWidth(200);
		frmlytSch53.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_137.setLayout(frmlytSch53);

		etgdCtra = new MSFNumberField();
		etgdCtra.setReadOnly(true);
		etgdCtra.setAllowDecimals(true); 
		etgdCtra.setPropertyEditorType(Long.class); 
		etgdCtra.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_137.add(etgdCtra, new FormData("100%"));
		etgdCtra.setFieldLabel("목돈안드는전세이자상환액");
		layoutContainer_131.add(layoutContainer_137);
		layoutContainer_137.setBorders(false);

		// 장기집합투자증권저축 납입금액
		LayoutContainer layoutContainer_138 = new LayoutContainer();

		FormLayout frmlytSch54 = new FormLayout();
		frmlytSch54.setLabelWidth(200);
		frmlytSch54.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_138.setLayout(frmlytSch54);

		etepSest = new MSFNumberField();
		etepSest.setReadOnly(true);
		etepSest.setAllowDecimals(true); 
		etepSest.setPropertyEditorType(Long.class); 
		etepSest.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_138.add(etepSest, new FormData("100%"));
		etepSest.setFieldLabel("장기집합투자증권저축 납입금액");
		layoutContainer_131.add(layoutContainer_138);
		layoutContainer_138.setBorders(false);

		// 기타
//		LayoutContainer layoutContainer_139 = new LayoutContainer();
//		layoutContainer_139.setLayout(new ColumnLayout());
//
//		LayoutContainer layoutContainer_142 = new LayoutContainer();
//
//		FormLayout frmlytSch55 = new FormLayout();
//		frmlytSch55.setLabelWidth(50);
//		frmlytSch55.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_142.setLayout(frmlytSch55);
//
//		etclEttl = new MSFTextField();
//		
//		layoutContainer_142.add(etclEttl, new FormData("100%"));
//		etclEttl.setFieldLabel("기타 (");
//		layoutContainer_139.add(layoutContainer_142, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
//		layoutContainer_142.setBorders(false);
//
//		LayoutContainer layoutContainer_146 = new LayoutContainer();
//
//		FormLayout frmlytSch56 = new FormLayout();
//		frmlytSch56.setLabelWidth(10);
//		frmlytSch56.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_146.setLayout(frmlytSch56);
//
//		etclEtam = new MSFNumberField();
//		
//		etclEtam.setAllowDecimals(true); 
//		etclEtam.setPropertyEditorType(Long.class); 
//		etclEtam.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_146.add(etclEtam, new FormData("100%"));
//		etclEtam.setFieldLabel(" )");
//		layoutContainer_139.add(layoutContainer_146, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		layoutContainer_146.setBorders(false);
//
//		layoutContainer_131.add(layoutContainer_139);
 
 	layoutContainer_14.add(layoutContainer_131, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));

		LayoutContainer layoutContainer_132 = new LayoutContainer();

		// 기타공제_우리사주출연금공제 공제액
		LayoutContainer layoutContainer_134 = new LayoutContainer();

		FormLayout frmlytSch57 = new FormLayout();
		frmlytSch57.setLabelWidth(70);
		frmlytSch57.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_134.setLayout(frmlytSch57);

		etckUnon01 = new   MSFNumberField();
		etckUnon01.setReadOnly(true);
		etckUnon01.setAllowDecimals(true); 
		etckUnon01.setPropertyEditorType(Long.class); 
		etckUnon01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_134.add(etckUnon01);
		etckUnon01.setFieldLabel("공제액");
		layoutContainer_132.add(layoutContainer_134);
		layoutContainer_134.setBorders(false);

		// 기타공제_우리사주조합기부금공제2014이전 공제액
		LayoutContainer layoutContainer_140 = new LayoutContainer();

		FormLayout frmlytSch58 = new FormLayout();
		frmlytSch58.setLabelWidth(70);
		frmlytSch58.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_140.setLayout(frmlytSch58);

		etckUncr = new MSFNumberField();
		etckUncr.setReadOnly(true);
		etckUncr.setAllowDecimals(true); 
		etckUncr.setPropertyEditorType(Long.class); 
		etckUncr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_140.add(etckUncr);
		etckUncr.setFieldLabel("공제액");
		layoutContainer_132.add(layoutContainer_140);
		layoutContainer_140.setBorders(false);

		//기타공제_고용유지중소기업근로자임금삭감 공제액
		LayoutContainer layoutContainer_141 = new LayoutContainer();

		FormLayout frmlytSch59 = new FormLayout();
		frmlytSch59.setLabelWidth(70);
		frmlytSch59.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_141.setLayout(frmlytSch59);

		etepMsam = new  MSFNumberField();
		etepMsam.setReadOnly(true);
		
		etepMsam.setAllowDecimals(true); 
		etepMsam.setPropertyEditorType(Long.class); 
		etepMsam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_141.add(etepMsam);
		etepMsam.setFieldLabel("공제액");
		layoutContainer_132.add(layoutContainer_141);
		layoutContainer_141.setBorders(false);

		// 공제액
		LayoutContainer layoutContainer_143 = new LayoutContainer();

		FormLayout frmlytSch60 = new FormLayout();
		frmlytSch60.setLabelWidth(70);
		frmlytSch60.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_143.setLayout(frmlytSch60);

		etgdHtra = new  MSFNumberField();
		etgdHtra.setReadOnly(true);
		
		etgdHtra.setAllowDecimals(true); 
		etgdHtra.setPropertyEditorType(Long.class); 
		etgdHtra.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_143.add(etgdHtra);
		etgdHtra.setFieldLabel("공제액");
		layoutContainer_132.add(layoutContainer_143);
		layoutContainer_143.setBorders(false);

		// 기타공제_장기집합투자증권저축 공제액
		LayoutContainer layoutContainer_144 = new LayoutContainer();

		FormLayout frmlytSch61 = new FormLayout();
		frmlytSch61.setLabelWidth(70);
		frmlytSch61.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_144.setLayout(frmlytSch61);

		etepSecr = new  MSFNumberField();
		etepSecr.setReadOnly(true);
		
		etepSecr.setAllowDecimals(true); 
		etepSecr.setPropertyEditorType(Long.class); 
		etepSecr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_144.add(etepSecr);
		etepSecr.setFieldLabel("공제액");
		layoutContainer_132.add(layoutContainer_144);
		layoutContainer_144.setBorders(false);

//		// 기타 공제액
//		LayoutContainer layoutContainer_145 = new LayoutContainer();
//
//		FormLayout frmlytSch62 = new FormLayout();
//		frmlytSch62.setLabelWidth(70);
//		frmlytSch62.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_145.setLayout(frmlytSch62);
//
//		etcdTsum = new NumberField();
//		
//		etcdTsum.setAllowDecimals(true); 
//		etcdTsum.setPropertyEditorType(Long.class); 
//		etcdTsum.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_145.add(etcdTsum);
//		etcdTsum.setFieldLabel("공제액");
//		layoutContainer_132.add(layoutContainer_145);
//		layoutContainer_145.setBorders(false);
//
		layoutContainer_14.add(layoutContainer_132, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
//		layoutContainer_132.setBorders(false);
 
		cp01.add(layoutContainer_14);
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}	
	
	private LayoutContainer yetaData08() {
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "450");
		

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		layoutContainer_15.setBorders(false);

		tabsItemYeta08 = new TabPanel();
		
		tabsItemYeta08.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				
				//탭선택
//				yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), tabsItemYeta08.getSelectedItem().getId());
				//reFresh(tabsItemYeta08.getSelectedItem().getId());
			}
		});

		// 연금계좌및보험료 tab
		TabItem itemYeta08_1 = new TabItem("연금계좌및보험료");
		itemYeta08_1.setId("itemYeta08_1");
		itemYeta08_1.setBorders(false);
		tabsItemYeta08.add(itemYeta08_1);
		itemYeta08_1.setHeight("370px");
//		itemYeta08_1.setHeight("400px");

		ContentPanel cntntpnlNewContentpanel_3 = new ContentPanel();
		cntntpnlNewContentpanel_3.setHeaderVisible(false);
		cntntpnlNewContentpanel_3.setHeadingText("");

		LayoutContainer layoutContainer_318 = new LayoutContainer();
		FormLayout frmlytSch159 = new FormLayout();
			frmlytSch159.setLabelWidth(110);
			frmlytSch159.setLabelAlign(LabelAlign.RIGHT);

			layoutContainer_318.setLayout(frmlytSch159);
		LayoutContainer layoutContainer_319 = new LayoutContainer();
		  frmlytSch159 = new FormLayout();
			frmlytSch159.setLabelWidth(110);
			frmlytSch159.setLabelAlign(LabelAlign.RIGHT);

		 layoutContainer_319.setLayout(frmlytSch159);
		 FieldSet fldstNewFieldset_26 = new FieldSet();

		LayoutContainer layoutContainer_334 = new LayoutContainer();
		layoutContainer_334.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_335 = new LayoutContainer();
		 frmlytSch159 = new FormLayout();
		frmlytSch159.setLabelWidth(110);
		frmlytSch159.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_335.setLayout(frmlytSch159);
		// 과학기술인공제
		LayoutContainer layoutContainer_338 = new LayoutContainer();

		  frmlytSch159 = new FormLayout();
		frmlytSch159.setLabelWidth(110);
		frmlytSch159.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_338.setLayout(frmlytSch159);

		jrtrCict = new  MSFNumberField();
		jrtrCict.setReadOnly(true);
		
		jrtrCict.setAllowDecimals(true); 
		jrtrCict.setPropertyEditorType(Long.class); 
		jrtrCict.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_338.add(jrtrCict, new FormData("100%"));
		jrtrCict.setFieldLabel("과학기술인공제");
		layoutContainer_335.add(layoutContainer_338, new FormData("100%"));
		layoutContainer_338.setBorders(false);

		// 근로자퇴직보장법
		LayoutContainer layoutContainer_339 = new LayoutContainer();

		FormLayout frmlytSch160 = new FormLayout();
		frmlytSch160.setLabelWidth(110);
		frmlytSch160.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_339.setLayout(frmlytSch160);

		jrtrPsct = new  MSFNumberField();
		jrtrPsct.setReadOnly(true);
		
		jrtrPsct.setAllowDecimals(true); 
		jrtrPsct.setPropertyEditorType(Long.class); 
		jrtrPsct.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_339.add(jrtrPsct, new FormData("100%"));
		jrtrPsct.setFieldLabel("근로자퇴직보장법");
		layoutContainer_335.add(layoutContainer_339, new FormData("100%"));
		layoutContainer_339.setBorders(false);

		// 연금저축계좌
		LayoutContainer layoutContainer_340 = new LayoutContainer();

		FormLayout frmlytSch161 = new FormLayout();
		frmlytSch161.setLabelWidth(110);
		frmlytSch161.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_340.setLayout(frmlytSch161);

		jrtrAnsv = new   MSFNumberField();
		jrtrAnsv.setReadOnly(true);
		
		jrtrAnsv.setAllowDecimals(true); 
		jrtrAnsv.setPropertyEditorType(Long.class); 
		jrtrAnsv.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_340.add(jrtrAnsv, new FormData("100%"));
		jrtrAnsv.setFieldLabel("연금저축계좌");
		layoutContainer_335.add(layoutContainer_340, new FormData("100%"));
		layoutContainer_340.setBorders(false);

		// 연금계좌제
		LayoutContainer layoutContainer_341 = new LayoutContainer();

		FormLayout frmlytSch162 = new FormLayout();
		frmlytSch162.setLabelWidth(110);
		frmlytSch162.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_341.setLayout(frmlytSch162);

		jrtrAtom = new   MSFNumberField();
		jrtrAtom.setReadOnly(true);
		
		jrtrAtom.setAllowDecimals(true); 
		jrtrAtom.setPropertyEditorType(Long.class); 
		jrtrAtom.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_341.add(jrtrAtom, new FormData("100%"));
		jrtrAtom.setFieldLabel("연금계좌계");
		layoutContainer_335.add(layoutContainer_341, new FormData("100%"));
		layoutContainer_341.setBorders(false);

		layoutContainer_334.add(layoutContainer_335, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_335.setBorders(false);

		LayoutContainer layoutContainer_336 = new LayoutContainer();
		FormLayout frmlytSch163 = new FormLayout();
		frmlytSch163.setLabelWidth(70);
		frmlytSch163.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_336.setLayout(frmlytSch163);
		// 주근무지_퇴직연금과학기술인공제대상금액 공제대상
		LayoutContainer layoutContainer_342 = new LayoutContainer();

		  frmlytSch163 = new FormLayout();
		frmlytSch163.setLabelWidth(70);
		frmlytSch163.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_342.setLayout(frmlytSch163);

		jrtrCtar = new MSFNumberField();
		jrtrCtar.setReadOnly(true);
		jrtrCtar.setAllowDecimals(true); 
		jrtrCtar.setPropertyEditorType(Long.class); 
		jrtrCtar.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_342.add(jrtrCtar, new FormData("100%"));
		jrtrCtar.setFieldLabel("공제대상");
		layoutContainer_336.add(layoutContainer_342, new FormData("100%"));
		layoutContainer_342.setBorders(false);

		// 주근무지_퇴직연금근로자퇴직급여보장대상금액 공제대상
		LayoutContainer layoutContainer_343 = new LayoutContainer();

		FormLayout frmlytSch164 = new FormLayout();
		frmlytSch164.setLabelWidth(70);
		frmlytSch164.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_343.setLayout(frmlytSch164);

		jrtrPtar = new MSFNumberField();
		jrtrPtar.setReadOnly(true);
		jrtrPtar.setAllowDecimals(true); 
		jrtrPtar.setPropertyEditorType(Long.class); 
		jrtrPtar.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_343.add(jrtrPtar, new FormData("100%"));
		jrtrPtar.setFieldLabel("공제대상");
		layoutContainer_336.add(layoutContainer_343, new FormData("100%"));
		layoutContainer_343.setBorders(false);

		// 주근무지_연금계좌저축공제대상금액 공제대상
		LayoutContainer layoutContainer_344 = new LayoutContainer();

		FormLayout frmlytSch165 = new FormLayout();
		frmlytSch165.setLabelWidth(70);
		frmlytSch165.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_344.setLayout(frmlytSch165);

		jrtrAtar = new MSFNumberField();
		jrtrAtar.setReadOnly(true);
		jrtrAtar.setAllowDecimals(true); 
		jrtrAtar.setPropertyEditorType(Long.class); 
		jrtrAtar.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_344.add(jrtrAtar, new FormData("100%"));
		jrtrAtar.setFieldLabel("공제대상");
		layoutContainer_336.add(layoutContainer_344, new FormData("100%"));
		layoutContainer_344.setBorders(false);

		//연금계좌공제대상금액 공제대상
		LayoutContainer layoutContainer_345 = new LayoutContainer();

		FormLayout frmlytSch166 = new FormLayout();
		frmlytSch166.setLabelWidth(70);
		frmlytSch166.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_345.setLayout(frmlytSch166);

		jrtrTotr = new MSFNumberField();
		jrtrTotr.setReadOnly(true);
		jrtrTotr.setAllowDecimals(true); 
		jrtrTotr.setPropertyEditorType(Long.class); 
		jrtrTotr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_345.add(jrtrTotr, new FormData("100%"));
		jrtrTotr.setFieldLabel("공제대상");
		layoutContainer_336.add(layoutContainer_345, new FormData("100%"));
		layoutContainer_345.setBorders(false);

		layoutContainer_334.add(layoutContainer_336,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_336.setBorders(false);

		LayoutContainer layoutContainer_337 = new LayoutContainer();
		FormLayout  frmlytSch167 = new FormLayout();
		frmlytSch167.setLabelWidth(70);
		frmlytSch167.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_337.setLayout(frmlytSch167);
		//주근무지_퇴직연금과학기술인공제액 공제세액
		LayoutContainer layoutContainer_346 = new LayoutContainer();
		   frmlytSch167 = new FormLayout();
		frmlytSch167.setLabelWidth(70);
		frmlytSch167.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_346.setLayout(frmlytSch167);

		jrtrHict = new MSFNumberField();
		jrtrHict.setReadOnly(true);
		jrtrHict.setAllowDecimals(true); 
		jrtrHict.setPropertyEditorType(Long.class); 
		jrtrHict.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_346.add(jrtrHict, new FormData("100%"));
		jrtrHict.setFieldLabel("공제세액");
		layoutContainer_337.add(layoutContainer_346, new FormData("100%"));
		layoutContainer_346.setBorders(false);

		// 주근무지_퇴직연금근로자퇴직급여보장법공제액 공제세액
		LayoutContainer layoutContainer_347 = new LayoutContainer();

		FormLayout frmlytSch168 = new FormLayout();
		frmlytSch168.setLabelWidth(70);
		frmlytSch168.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_347.setLayout(frmlytSch168);

		jrtrPsrn = new MSFNumberField(); 
		jrtrPsrn.setReadOnly(true);
		jrtrPsrn.setAllowDecimals(true); 
		jrtrPsrn.setPropertyEditorType(Long.class); 
		jrtrPsrn.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_347.add(jrtrPsrn, new FormData("100%"));
		jrtrPsrn.setFieldLabel("공제세액");
		layoutContainer_337.add(layoutContainer_347, new FormData("100%"));
		layoutContainer_347.setBorders(false);

		// 주근무지_퇴직연금연금계좌저축공제 공제세액
		LayoutContainer layoutContainer_348 = new LayoutContainer();

		FormLayout frmlytSch169 = new FormLayout();
		frmlytSch169.setLabelWidth(70);
		frmlytSch169.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_348.setLayout(frmlytSch169);

		jrtrHnsv = new MSFNumberField();
		jrtrHnsv.setReadOnly(true);
		jrtrHnsv.setAllowDecimals(true); 
		jrtrHnsv.setPropertyEditorType(Long.class); 
		jrtrHnsv.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_348.add(jrtrHnsv, new FormData("100%"));
		jrtrHnsv.setFieldLabel("공제세액");
		layoutContainer_337.add(layoutContainer_348, new FormData("100%"));
		layoutContainer_348.setBorders(false);

		//연금계좌세액공제계 공제세액
		LayoutContainer layoutContainer_349 = new LayoutContainer();

		FormLayout frmlytSch170 = new FormLayout();
		frmlytSch170.setLabelWidth(70);
		frmlytSch170.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_349.setLayout(frmlytSch170);

		jrtrHnto = new MSFNumberField();
		jrtrHnto.setReadOnly(true);
		jrtrHnto.setAllowDecimals(true); 
		jrtrHnto.setPropertyEditorType(Long.class); 
		jrtrHnto.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_349.add(jrtrHnto, new FormData("100%"));
		jrtrHnto.setFieldLabel("공제세액");
		layoutContainer_337.add(layoutContainer_349, new FormData("100%"));
		layoutContainer_349.setBorders(false);

		layoutContainer_334.add(layoutContainer_337, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_337.setBorders(false);

		fldstNewFieldset_26.add(layoutContainer_334, new FormData("100%"));
		layoutContainer_319.add(fldstNewFieldset_26, new FormData("100%"));
		fldstNewFieldset_26.setHeadingHtml("연금계좌");
		layoutContainer_318.add(layoutContainer_319, new FormData("100%"));

		LayoutContainer layoutContainer_320 = new LayoutContainer();
		FormLayout frmlytSch156 = new FormLayout();
		frmlytSch156.setLabelWidth(110);
		frmlytSch156.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_320.setLayout(frmlytSch156);
		FieldSet fldstNewFieldset_27 = new FieldSet();

		LayoutContainer layoutContainer_330 = new LayoutContainer();
		layoutContainer_330.setLayout(new ColumnLayout());

		// 보험료금액
		LayoutContainer layoutContainer_331 = new LayoutContainer();

		  frmlytSch156 = new FormLayout();
		frmlytSch156.setLabelWidth(110);
		frmlytSch156.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_331.setLayout(frmlytSch156);

		spciGurt = new MSFNumberField();
		
		spciGurt.setAllowDecimals(true); 
		spciGurt.setPropertyEditorType(Long.class); 
		spciGurt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_331.add(spciGurt, new FormData("100%"));
		spciGurt.setFieldLabel("보험료금액");
		layoutContainer_330.add(layoutContainer_331, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_331.setBorders(false);

		// 특별공제_일반보장성보험료 공제대상금액 공제대상
		LayoutContainer layoutContainer_332 = new LayoutContainer();

		FormLayout frmlytSch157 = new FormLayout();
		frmlytSch157.setLabelWidth(70);
		frmlytSch157.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_332.setLayout(frmlytSch157);

		spciRttg = new   MSFNumberField();
		spciRttg.setReadOnly(true);
		
		spciRttg.setAllowDecimals(true); 
		spciRttg.setPropertyEditorType(Long.class); 
		spciRttg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_332.add(spciRttg, new FormData("100%"));
		spciRttg.setFieldLabel("공제대상");
		layoutContainer_330.add(layoutContainer_332, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_332.setBorders(false);

		// 특별공제_일반보장성보험료 공제액 세액공제
		LayoutContainer layoutContainer_333 = new LayoutContainer();

		FormLayout frmlytSch158 = new FormLayout();
		frmlytSch158.setLabelWidth(70);
		frmlytSch158.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_333.setLayout(frmlytSch158);

		spciGurt01 = new   MSFNumberField();
		spciGurt01.setReadOnly(true);
		
		spciGurt01.setAllowDecimals(true); 
		spciGurt01.setPropertyEditorType(Long.class); 
		spciGurt01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_333.add(spciGurt01, new FormData("100%"));
		spciGurt01.setFieldLabel("세액공제");
		layoutContainer_330.add(layoutContainer_333, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_333.setBorders(false);

		fldstNewFieldset_27.add(layoutContainer_330);
		layoutContainer_320.add(fldstNewFieldset_27);
		fldstNewFieldset_27.setHeadingHtml("일반보장성보험");
		fldstNewFieldset_27.setCollapsible(false);
		layoutContainer_318.add(layoutContainer_320);

		LayoutContainer layoutContainer_321 = new LayoutContainer();
		FormLayout frmlytSch153 = new FormLayout();
		frmlytSch153.setLabelWidth(110);
		frmlytSch153.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_321.setLayout(frmlytSch153);
		FieldSet fldstNewFieldset_28 = new FieldSet();

		LayoutContainer layoutContainer_326 = new LayoutContainer();
		layoutContainer_326.setLayout(new ColumnLayout());

		//특별공제_장애인전용보험료
		LayoutContainer layoutContainer_327 = new LayoutContainer();

		  frmlytSch153 = new FormLayout();
		frmlytSch153.setLabelWidth(110);
		frmlytSch153.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_327.setLayout(frmlytSch153);

		spciHdrc = new MSFNumberField();
		
		spciHdrc.setAllowDecimals(true); 
		spciHdrc.setPropertyEditorType(Long.class); 
		spciHdrc.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_327.add(spciHdrc, new FormData("100%"));
		spciHdrc.setFieldLabel("보험료금액");
		layoutContainer_326.add(layoutContainer_327, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_327.setBorders(false);

		//특별공제_장애인보장성대상금액 공제대상
		LayoutContainer layoutContainer_328 = new LayoutContainer();

		FormLayout frmlytSch154 = new FormLayout();
		frmlytSch154.setLabelWidth(70);
		frmlytSch154.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_328.setLayout(frmlytSch154);

		spciHdtg = new   MSFNumberField();
		spciHdtg.setReadOnly(true);
		
		spciHdtg.setAllowDecimals(true); 
		spciHdtg.setPropertyEditorType(Long.class); 
		spciHdtg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_328.add(spciHdtg, new FormData("100%"));
		spciHdtg.setFieldLabel("공제대상");
		layoutContainer_326.add(layoutContainer_328, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_328.setBorders(false);

		// 특별공제_장애인보장성대상금액 공제액 세액공제
		LayoutContainer layoutContainer_329 = new LayoutContainer();

		FormLayout frmlytSch155 = new FormLayout();
		frmlytSch155.setLabelWidth(70);
		frmlytSch155.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_329.setLayout(frmlytSch155);

		spciHdrc01 = new   MSFNumberField();
		spciHdrc01.setReadOnly(true);
		
		spciHdrc01.setAllowDecimals(true); 
		spciHdrc01.setPropertyEditorType(Long.class); 
		spciHdrc01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_329.add(spciHdrc01, new FormData("100%"));
		spciHdrc01.setFieldLabel("세액공제");
		layoutContainer_326.add(layoutContainer_329, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_329.setBorders(false);

		fldstNewFieldset_28.add(layoutContainer_326, new FormData("100%"));
		layoutContainer_321.add(fldstNewFieldset_28, new FormData("100%"));
		fldstNewFieldset_28.setHeadingHtml("장애인전용보장성보험");
		fldstNewFieldset_28.setCollapsible(false);
		layoutContainer_318.add(layoutContainer_321, new FormData("100%"));

		LayoutContainer layoutContainer_322 = new LayoutContainer();
		layoutContainer_322.setLayout(new ColumnLayout());

		// 특별공제_보장성보험료계
		LayoutContainer layoutContainer_323 = new LayoutContainer();

		FormLayout frmlytSch150 = new FormLayout();
		frmlytSch150.setLabelWidth(120);
		frmlytSch150.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_323.setLayout(frmlytSch150);

		spciRtto = new   MSFNumberField();
		spciRtto.setReadOnly(true);
		
		spciRtto.setAllowDecimals(true); 
		spciRtto.setPropertyEditorType(Long.class); 
		spciRtto.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_323.add(spciRtto, new FormData("100%"));
		spciRtto.setFieldLabel("보험료계");
		layoutContainer_322.add(layoutContainer_323, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_323.setBorders(false);

		// 특별공제_보장성보험료대상금액
		LayoutContainer layoutContainer_324 = new LayoutContainer();

		FormLayout frmlytSch151 = new FormLayout();
		frmlytSch151.setLabelWidth(70);
		frmlytSch151.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_324.setLayout(frmlytSch151);

		spciDetg = new   MSFNumberField();
		spciDetg.setReadOnly(true);
		
		spciDetg.setAllowDecimals(true); 
		spciDetg.setPropertyEditorType(Long.class); 
		spciDetg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_324.add(spciDetg, new FormData("100%"));
		spciDetg.setFieldLabel("공제대상");
		layoutContainer_322.add(layoutContainer_324, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_324.setBorders(false);
		
		//특별공제_보장성보혐료세액공제금액
		LayoutContainer layoutContainer_325 = new LayoutContainer();

		FormLayout frmlytSch152 = new FormLayout();
		frmlytSch152.setLabelWidth(70);
		frmlytSch152.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_325.setLayout(frmlytSch152);

		spciRtde = new  MSFNumberField();
		spciRtde.setReadOnly(true);
		
		
		spciRtde.setAllowDecimals(true); 
		spciRtde.setPropertyEditorType(Long.class); 
		spciRtde.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_325.add(spciRtde, new FormData("100%"));
		spciRtde.setFieldLabel("공제세액");
		layoutContainer_322.add(layoutContainer_325, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_325.setBorders(false);

		layoutContainer_318.add(layoutContainer_322, new FormData("100%"));

		cntntpnlNewContentpanel_3.add(layoutContainer_318);
		itemYeta08_1.add(cntntpnlNewContentpanel_3);
		cntntpnlNewContentpanel_3.setHeight("355px");

		// 의료비tab
		TabItem itemYeta08_2 = new TabItem("의료비");
		itemYeta08_2.setId("itemYeta08_2");
		itemYeta08_2.setBorders(true);
		tabsItemYeta08.add(itemYeta08_2);
		itemYeta08_2.setHeight("370px");

		ContentPanel cntntpnlNewContentpanel_4 = new ContentPanel();
		cntntpnlNewContentpanel_4.setScrollMode(Scroll.AUTOY);
		cntntpnlNewContentpanel_4.setHeaderVisible(false);
		cntntpnlNewContentpanel_4.setHeadingText("");

		LayoutContainer layoutContainer_350 = new LayoutContainer();

		FieldSet fldstNewFieldset_29 = new FieldSet();
		layoutContainer_350.add(fldstNewFieldset_29);
		fldstNewFieldset_29.setHeadingHtml("의료비공제");

		LayoutContainer layoutContainer_351 = new LayoutContainer();

		ButtonBar buttonBar_3 = new ButtonBar();
		buttonBar_3.setAlignment(HorizontalAlignment.RIGHT);

		Button btnNewButton_10 = new Button("의료비내역등록");
		buttonBar_3.add(btnNewButton_10);
		btnNewButton_10.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP13002 yetaP03002Form = new YetaP13002(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwYeta13002 = new MSFFormWindows("의료비내역등록", yetaP03002Form, "닫기", "820px", "710px", true);
				msFwYeta13002.show();
				yetaP03002Form.setMSFFormWindows(msFwYeta13002);
				
				funcSetPopUpRecord();
				//TODO 추후 주석해제 
				yetaP03002Form.bind(ppRecord); 
			}
		});		
		
		layoutContainer_351.add(buttonBar_3);
		fldstNewFieldset_29.add(layoutContainer_351);
		layoutContainer_351.setBorders(false);

		FieldSet fldstNewFieldset_30 = new FieldSet();
		fldstNewFieldset_30.setHeadingHtml("본인 의료비");

		LayoutContainer layoutContainer_377 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_377.setLayout(new ColumnLayout());

		// 지출금액
		LayoutContainer layoutContainer_378 = new LayoutContainer();

		FormLayout frmlytSch200 = new FormLayout();
		frmlytSch200.setLabelWidth(70);
		frmlytSch200.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_378.setLayout(frmlytSch200);

		spciSelf = new   MSFNumberField();
		spciSelf.setReadOnly(true);
		
		spciSelf.setAllowDecimals(true); 
		spciSelf.setPropertyEditorType(Long.class); 
		spciSelf.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_378.add(spciSelf, new FormData("100%"));
		spciSelf.setFieldLabel("지출금액");
		layoutContainer_377.add(layoutContainer_378, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_378.setBorders(false);

		// 본인의료비공제대상금액
		LayoutContainer layoutContainer_379 = new LayoutContainer();

		FormLayout frmlytSch201 = new FormLayout();
		frmlytSch201.setLabelWidth(70);
		frmlytSch201.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_379.setLayout(frmlytSch201);

		spciSftg = new   MSFNumberField();
		spciSftg.setReadOnly(true);
		
		spciSftg.setAllowDecimals(true); 
		spciSftg.setPropertyEditorType(Long.class); 
		spciSftg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_379.add(spciSftg, new FormData("100%"));
		spciSftg.setFieldLabel("공제대상");
		layoutContainer_377.add(layoutContainer_379, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_379.setBorders(false);

		//특별공제_의료비_본인 세액공제
		LayoutContainer layoutContainer_380 = new LayoutContainer();

		FormLayout frmlytSch202 = new FormLayout();
		frmlytSch202.setLabelWidth(70);
		frmlytSch202.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_380.setLayout(frmlytSch202);

		spciSelf01 = new   MSFNumberField();
		spciSelf01.setReadOnly(true);
		
		spciSelf01.setAllowDecimals(true); 
		spciSelf01.setPropertyEditorType(Long.class); 
		spciSelf01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_380.add(spciSelf01, new FormData("100%"));
		spciSelf01.setFieldLabel("세액공제");
		layoutContainer_377.add(layoutContainer_380, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_380.setBorders(false);

		fldstNewFieldset_30.add(layoutContainer_377);
		
		fldstNewFieldset_29.add(fldstNewFieldset_30);


		FieldSet fldstNewFieldset_31 = new FieldSet();
		fldstNewFieldset_31.setHeadingHtml("65세이상자 의료비");

		LayoutContainer layoutContainer_381 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_381.setLayout(new ColumnLayout());

		// 지출금액
		LayoutContainer layoutContainer_382 = new LayoutContainer();

		FormLayout frmlytSch203 = new FormLayout();
		frmlytSch203.setLabelWidth(70);
		frmlytSch203.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_382.setLayout(frmlytSch203);

		spciAe65 = new  MSFNumberField();
		spciAe65.setReadOnly(true);
		
		spciAe65.setAllowDecimals(true); 
		spciAe65.setPropertyEditorType(Long.class); 
		spciAe65.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_382.add(spciAe65, new FormData("100%"));
		spciAe65.setFieldLabel("지출금액");
		layoutContainer_381.add(layoutContainer_382, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_382.setBorders(false);

		// 65세이상자의료비공제대상금액 
		LayoutContainer layoutContainer_383 = new LayoutContainer();

		FormLayout frmlytSch204 = new FormLayout();
		frmlytSch204.setLabelWidth(70);
		frmlytSch204.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_383.setLayout(frmlytSch204);

		spci65tg = new  MSFNumberField();
		spci65tg.setReadOnly(true);
		
		
		spci65tg.setAllowDecimals(true); 
		spci65tg.setPropertyEditorType(Long.class); 
		spci65tg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_383.add(spci65tg, new FormData("100%"));
		spci65tg.setFieldLabel("공제대상");
		layoutContainer_381.add(layoutContainer_383, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_383.setBorders(false);

		// 특별공제_의료비_경로65세이상 세액공제
		LayoutContainer layoutContainer_384 = new LayoutContainer();

		FormLayout frmlytSch205 = new FormLayout();
		frmlytSch205.setLabelWidth(70);
		frmlytSch205.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_384.setLayout(frmlytSch205);

		spciHe65 = new  MSFNumberField();
		spciHe65.setReadOnly(true);
		
		spciHe65.setAllowDecimals(true); 
		spciHe65.setPropertyEditorType(Long.class); 
		spciHe65.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_384.add(spciHe65, new FormData("100%"));
		spciHe65.setFieldLabel("세액공제");
		layoutContainer_381.add(layoutContainer_384, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_384.setBorders(false);

		fldstNewFieldset_31.add(layoutContainer_381);
		
		fldstNewFieldset_29.add(fldstNewFieldset_31);


		FieldSet fldstNewFieldset_32 = new FieldSet();
		fldstNewFieldset_32.setHeadingHtml("장애인 의료비");

		LayoutContainer layoutContainer_385 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_385.setLayout(new ColumnLayout());

		// 특별공제_의료비_장애인 지출금액
		LayoutContainer layoutContainer_386 = new LayoutContainer();

		FormLayout frmlytSch206 = new FormLayout();
		frmlytSch206.setLabelWidth(70);
		frmlytSch206.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_386.setLayout(frmlytSch206);

		spciDbps = new  MSFNumberField();
		spciDbps.setReadOnly(true);
		spciDbps.setAllowDecimals(true); 
		spciDbps.setPropertyEditorType(Long.class); 
		spciDbps.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_386.add(spciDbps, new FormData("100%"));
		spciDbps.setFieldLabel("지출금액");
		layoutContainer_385.add(layoutContainer_386, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_386.setBorders(false);

		// 장애인의료비공제대상금액 공제대상
		LayoutContainer layoutContainer_387 = new LayoutContainer();

		FormLayout frmlytSch207 = new FormLayout();
		frmlytSch207.setLabelWidth(70);
		frmlytSch207.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_387.setLayout(frmlytSch207);

		spciPstg = new   MSFNumberField();
		spciPstg.setReadOnly(true);
		
		spciPstg.setAllowDecimals(true); 
		spciPstg.setPropertyEditorType(Long.class); 
		spciPstg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_387.add(spciPstg, new FormData("100%"));
		spciPstg.setFieldLabel("공제대상");
		layoutContainer_385.add(layoutContainer_387, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_387.setBorders(false);

		// 특별공제_의료비_장애인 공제액 세액공제
		LayoutContainer layoutContainer_388 = new LayoutContainer();

		FormLayout frmlytSch208 = new FormLayout();
		frmlytSch208.setLabelWidth(70);
		frmlytSch208.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_388.setLayout(frmlytSch208);

		spciHbps = new   MSFNumberField();
		spciHbps.setReadOnly(true);
		
		spciHbps.setAllowDecimals(true); 
		spciHbps.setPropertyEditorType(Long.class); 
		spciHbps.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_388.add(spciHbps, new FormData("100%"));
		spciHbps.setFieldLabel("세액공제");
		layoutContainer_385.add(layoutContainer_388, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_388.setBorders(false);

		fldstNewFieldset_32.add(layoutContainer_385);
		fldstNewFieldset_29.add(fldstNewFieldset_32);


		FieldSet fldstNewFieldset_33 = new FieldSet();
		fldstNewFieldset_33.setHeadingHtml("그밖의 공제대상자 의료비");

		LayoutContainer layoutContainer_389 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_389.setLayout(new ColumnLayout());

		//특별공제_의료비_기타공제대상자 지출금액
		LayoutContainer layoutContainer_390 = new LayoutContainer();

		FormLayout frmlytSch209 = new FormLayout();
		frmlytSch209.setLabelWidth(70);
		frmlytSch209.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_390.setLayout(frmlytSch209);

		spciDetc = new   MSFNumberField();
		spciDetc.setReadOnly(true);
		
		spciDetc.setAllowDecimals(true); 
		spciDetc.setPropertyEditorType(Long.class); 
		spciDetc.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_390.add(spciDetc, new FormData("100%"));
		spciDetc.setFieldLabel("지출금액");
		layoutContainer_389.add(layoutContainer_390, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_390.setBorders(false);

		// 그밖의의료비공제대상금액 공제대상
		LayoutContainer layoutContainer_391 = new LayoutContainer();

		FormLayout frmlytSch210 = new FormLayout();
		frmlytSch210.setLabelWidth(70);
		frmlytSch210.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_391.setLayout(frmlytSch210);

		spciEtcg = new    MSFNumberField();
		spciEtcg.setReadOnly(true);
		
		spciEtcg.setAllowDecimals(true); 
		spciEtcg.setPropertyEditorType(Long.class); 
		spciEtcg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_391.add(spciEtcg, new FormData("100%"));
		spciEtcg.setFieldLabel("공제대상");
		layoutContainer_389.add(layoutContainer_391, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_391.setBorders(false);

		//특별공제_의료비_기타공제대상자 세액공제
		LayoutContainer layoutContainer_392 = new LayoutContainer();

		FormLayout frmlytSch211 = new FormLayout();
		frmlytSch211.setLabelWidth(70);
		frmlytSch211.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_392.setLayout(frmlytSch211);

		spciDetc01 = new    MSFNumberField();
		spciDetc01.setReadOnly(true);
		
		spciDetc01.setAllowDecimals(true); 
		spciDetc01.setPropertyEditorType(Long.class); 
		spciDetc01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_392.add(spciDetc01, new FormData("100%"));
		spciDetc01.setFieldLabel("세액공제");
		layoutContainer_389.add(layoutContainer_392, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_392.setBorders(false);

		fldstNewFieldset_33.add(layoutContainer_389);
		fldstNewFieldset_29.add(fldstNewFieldset_33);

		// 의료비금액계
		LayoutContainer layoutContainer_356 = new LayoutContainer();

		FormLayout frmlytSch212 = new FormLayout();
		frmlytSch212.setLabelWidth(370);
		frmlytSch212.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_356.setLayout(frmlytSch212);

		spciEtam = new    MSFNumberField();
		spciDetc01.setReadOnly(true);
		
		spciEtam.setAllowDecimals(true); 
		spciEtam.setPropertyEditorType(Long.class); 
		spciEtam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_356.add(spciEtam, new FormData("100%"));
		spciEtam.setFieldLabel("의료비금액계");
		spciEtam.setReadOnly(true);
		fldstNewFieldset_29.add(layoutContainer_356);
		layoutContainer_356.setBorders(false);

		// 특별공제_의료비세액공제대상금액
		LayoutContainer layoutContainer_357 = new LayoutContainer();

		FormLayout frmlytSch213 = new FormLayout();
		frmlytSch213.setLabelWidth(370);
		frmlytSch213.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_357.setLayout(frmlytSch213);

		spciDtar = new   MSFNumberField();
		spciDtar.setReadOnly(true);
		
		spciDtar.setAllowDecimals(true); 
		spciDtar.setPropertyEditorType(Long.class); 
		spciDtar.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_357.add(spciDtar, new FormData("100%"));
		spciDtar.setFieldLabel("공제대상계");
		fldstNewFieldset_29.add(layoutContainer_357);
		layoutContainer_357.setBorders(false);

		//특별공제_의료비세액공제액
		LayoutContainer layoutContainer_360_1 = new LayoutContainer();

		FormLayout frmlytSch214 = new FormLayout();
		frmlytSch214.setLabelWidth(370);
		frmlytSch214.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_360_1.setLayout(frmlytSch214);

		spciTxcr = new   MSFNumberField();
		spciTxcr.setReadOnly(true);
		
		spciTxcr.setAllowDecimals(true); 
		spciTxcr.setPropertyEditorType(Long.class); 
		spciTxcr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_360_1.add(spciTxcr, new FormData("100%"));
		spciTxcr.setFieldLabel("세액공제계");
		fldstNewFieldset_29.add(layoutContainer_360_1);
		layoutContainer_360_1.setBorders(false);

		cntntpnlNewContentpanel_4.add(layoutContainer_350);
		itemYeta08_2.add(cntntpnlNewContentpanel_4);
		cntntpnlNewContentpanel_4.setHeight("355px");

		// 교육비tab
		TabItem itemYeta08_3 = new TabItem("교육비");
		itemYeta08_3.setId("itemYeta08_3");
		itemYeta08_3.setBorders(true);
		tabsItemYeta08.add(itemYeta08_3);
		itemYeta08_3.setHeight("370px");

		ContentPanel cntntpnlNewContentpanel_5 = new ContentPanel();
		cntntpnlNewContentpanel_5.setHeaderVisible(false);
		cntntpnlNewContentpanel_5.setHeadingText("");

		LayoutContainer layoutContainer_370 = new LayoutContainer();

		FieldSet fldstNewFieldset_35 = new FieldSet();

		LayoutContainer layoutContainer_371 = new LayoutContainer();

		// 소득자본인
		FieldSet fldstNewFieldset_36 = new FieldSet();
		fldstNewFieldset_36.setHeadingHtml("소득자본인");

		LayoutContainer layoutContainer_396 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_396.setLayout(new ColumnLayout());

		// 공납금(대학원포함)
		LayoutContainer layoutContainer_397 = new LayoutContainer();

		FormLayout frmlytSch215 = new FormLayout();
		frmlytSch215.setLabelWidth(120);
		frmlytSch215.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_397.setLayout(frmlytSch215);

		spedSelf = new MSFNumberField();
		
		spedSelf.setAllowDecimals(true); 
		spedSelf.setPropertyEditorType(Long.class); 
		spedSelf.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_397.add(spedSelf, new FormData("100%"));
		spedSelf.setFieldLabel("공납금(대학원포함)");
		layoutContainer_396.add(layoutContainer_397, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_397.setBorders(false);

		// 소득자본인교육비대상금액공제대상
		LayoutContainer layoutContainer_398 = new LayoutContainer();

		FormLayout frmlytSch216 = new FormLayout();
		frmlytSch216.setLabelWidth(70);
		frmlytSch216.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_398.setLayout(frmlytSch216);

		spedSftr = new   MSFNumberField();
		spedSftr.setReadOnly(true);
		
		spedSftr.setAllowDecimals(true); 
		spedSftr.setPropertyEditorType(Long.class); 
		spedSftr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_398.add(spedSftr, new FormData("100%"));
		spedSftr.setFieldLabel("공제대상");
		layoutContainer_396.add(layoutContainer_398, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_398.setBorders(false);

		//특별공제_교육비_본인 공제액 세액공제
		LayoutContainer layoutContainer_399 = new LayoutContainer();

		FormLayout frmlytSch217 = new FormLayout();
		frmlytSch217.setLabelWidth(70);
		frmlytSch217.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_399.setLayout(frmlytSch217);

		spedSelf01 = new  MSFNumberField();
		spedSelf01.setReadOnly(true);

		
		spedSelf01.setAllowDecimals(true); 
		spedSelf01.setPropertyEditorType(Long.class); 
		spedSelf01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_399.add(spedSelf01, new FormData("100%"));
		spedSelf01.setFieldLabel("세액공제");
		layoutContainer_396.add(layoutContainer_399, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_399.setBorders(false);

		fldstNewFieldset_36.add(layoutContainer_396);
		layoutContainer_396.setBorders(false);
		layoutContainer_371.add(fldstNewFieldset_36);

		//
		LayoutContainer layoutContainer_373 = new LayoutContainer();

		LabelField lblfldNewLabelfield_39 = new LabelField(
				"교육비는 지출액 -> 대상금액 -> 세액공제로 표시 됩니다.");
		layoutContainer_373.add(lblfldNewLabelfield_39);
		layoutContainer_371.add(layoutContainer_373);
		layoutContainer_373.setBorders(false);

		// 가족교육비등록
		LayoutContainer layoutContainer_374 = new LayoutContainer();

		FieldSet fldstNewFieldset_37 = new FieldSet();

		LayoutContainer layoutContainer_400 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_400.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_401 = new LayoutContainer();

		LayoutContainer layoutContainer_407 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_407.setLayout(new ColumnLayout());
		
		FieldSet fldstNewFieldset_39 = new FieldSet();
		fldstNewFieldset_39.setHeadingHtml("가족교육비");
		fldstNewFieldset_39.setBorders(false);
		layoutContainer_407.add(fldstNewFieldset_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//
//		LabelField lblfldNewLabelfield_40 = new LabelField("가족교육비");
//		layoutContainer_407.add(lblfldNewLabelfield_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(125.0));

		ButtonBar barYeta3150 = new ButtonBar();
		barYeta3150.setAlignment(HorizontalAlignment.RIGHT);

		Button btnYeta3150New = new Button("추가");
		btnYeta3150New.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
//				
	 

				fnPopupCommP160("Yeta3150");
				
// 
//				 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//	 	    		 return;
//	      	     }
//				 
//				 yeta1300ToYeta3150GridPanel.getMsfGrid().clearData();
//				 
//				 BaseModel bmData = yeta1300ToYeta3150GridPanel.getTableDef().getDefaultValues();  
//		              
//		         bmData.set("dpobCd", dpobCd.getValue()); 			/** column 사업장코드 : dpobCd */
//		         bmData.set("systemkey", systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
//		         bmData.set("edacRvyy", srhEdacRvyy.getValue());	/** column 연말정산귀속년도 : edacRvyy */
//		         bmData.set("settGbcd", srhSettGbcd.getValue());   	/** column 정산구분코드 : settGbcd */
//		         bmData.set("rsnoNumb", "");   	/** column 주민등록번호 : rsnoNumb */
//		         
//		         
//		         bmData.set("edacDtnu",0L);		/** column 교육비가족상세일련번호 : edacDtnu */
//		         bmData.set("fmacGbcd", new BaseModel());    		/** column 가족학력구분코드 : fmacGbcd */
//		         bmData.set("edacOtam", 0L);	/** column 교육비지급금액 : edacOtam */
//		              
//		         yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().stopEditing();      
//		         yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		         yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().startEditing(yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
// 
			
			}
		});
		barYeta3150.add(btnYeta3150New);

		
		Button btnYeta3150Del = new Button("삭제");
		btnYeta3150Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				
//				Iterator<Record> iterRecords = yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
				Iterator<BaseModel> itBm  = yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				
				List<Record>  lsRec  = new ArrayList<Record>();
	              
				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
	                
	            Iterator<Record> iterRecords = lsRec.iterator() ;  
				
				List<Ye16Ta3150DTO> listYeta3150dto = new ArrayList<Ye16Ta3150DTO>();  
			       
				while (iterRecords.hasNext()) {
			       
					Record recData = (Record) iterRecords.next(); 
					BaseModel bmMapModel = (BaseModel)recData.getModel();
			               
					Ye16Ta3150DTO yeta3150Dto = new Ye16Ta3150DTO();  
					
					yeta3150Dto.setEdacDtnu((Long) bmMapModel.get("edacDtnu"));    	/** column 교육비가족상세일련번호 : edacDtnu */
					yeta3150Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));		/** column 연말정산귀속년도 : edacRvyy */
					yeta3150Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
					yeta3150Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    		/** column 사업장코드 : dpobCd */
					yeta3150Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** column SYSTEMKEY : systemkey */
					yeta3150Dto.setFmacGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("fmacGbcd")));    	/** column 가족학력구분코드 : fmacGbcd */
					yeta3150Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 가족학력구분코드 : rsnoNumb */
					
					yeta3150Dto.setEdacOtam((Long) bmMapModel.get("edacOtam"));		/** column 교육비지급금액 : edacOtam */
					yeta3150Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb"))); 	/** column 가족주민등록번호 : rsnoNumb */   
					listYeta3150dto.add(yeta3150Dto);
					
				}   
				actionDatabase = ActionDatabase.DELETE;  
				
				yeta1300Service.saveYeta1300To2000tabItem08_3(listYeta3150dto, actionDatabase, new AsyncCallback<Long>() {
			    			 
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
										MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta1300ToYeta3220(" + actionDatabase.name() + ") : " + caught), null);
					}
					public void onSuccess(Long result) {  
						reloadYeta3150Grid();
						
						actionDatabase = null;  
					}	
				});
			}
		});
		barYeta3150.add(btnYeta3150Del);

		layoutContainer_407.add(barYeta3150, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_401.add(layoutContainer_407);
		layoutContainer_407.setBorders(false);

		LayoutContainer layoutContainer_408 = new LayoutContainer();
		layoutContainer_408.add(occupationalRBottom4());
		layoutContainer_401.add(layoutContainer_408);
		layoutContainer_408.setBorders(false);

		layoutContainer_400.add(layoutContainer_401, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_401.setBorders(false);

		LayoutContainer layoutContainer_402 = new LayoutContainer();
		// 취학전 아동
		LayoutContainer layoutContainer_409 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_409.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_415 = new LayoutContainer();

		FormLayout frmlytSch230 = new FormLayout();
		frmlytSch230.setLabelWidth(150);
		frmlytSch230.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_415.setLayout(frmlytSch230);

		//특별공제_교육비_취학전아동수
		spedEdsu= new  MSFNumberField();
		spedEdsu.setReadOnly(true);
		
		spedEdsu.setAllowDecimals(true); 
		spedEdsu.setPropertyEditorType(Long.class); 
		spedEdsu.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_415.add(spedEdsu, new FormData("100%"));
		spedEdsu.setFieldLabel("취학전아동");
		layoutContainer_409.add(layoutContainer_415, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_415.setBorders(false);

		LayoutContainer layoutContainer_416 = new LayoutContainer();
		
		FormLayout frmlytSch416 = new FormLayout();
		frmlytSch416.setLabelWidth(0);

		layoutContainer_416.setLayout(frmlytSch416);

		//특별공제_교육비_취학전아동
		spedEdam = new MSFNumberField();
		spedEdam.setReadOnly(true);
		
		spedEdam.setAllowDecimals(true); 
		spedEdam.setPropertyEditorType(Long.class); 
		spedEdam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_416.add(spedEdam, new FormData("100%"));
		spedEdam.setLabelSeparator("");
		layoutContainer_409.add(layoutContainer_416, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_402.add(layoutContainer_409);
		layoutContainer_409.setBorders(false);

		// 취학전아동(공제)
		LayoutContainer layoutContainer_410 = new LayoutContainer();

		FormLayout frmlytSch231 = new FormLayout();
		frmlytSch231.setLabelWidth(150);
		frmlytSch231.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_410.setLayout(frmlytSch231);

		spedGrde = new  MSFNumberField();
		spedEdam.setReadOnly(true);
		
		spedGrde.setAllowDecimals(true); 
		spedGrde.setPropertyEditorType(Long.class); 
		spedGrde.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_410.add(spedGrde, new FormData("100%"));
		spedGrde.setLabelSeparator("");
		spedGrde.setFieldLabel("취학전아동(공제)");
		spedGrde.setReadOnly(true);
		
		layoutContainer_402.add(layoutContainer_410, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_410.setBorders(false);

		// 초.중.고등학교
		LayoutContainer layoutContainer_411 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_411.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_417 = new LayoutContainer();

		FormLayout frmlytSch232 = new FormLayout();
		frmlytSch232.setLabelWidth(150);
		frmlytSch232.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_417.setLayout(frmlytSch232);

		//특별공제_교육비_초중고자녀수
		spedGdsu = new  MSFNumberField();
		spedGdsu.setReadOnly(true);
		
		spedGdsu.setAllowDecimals(true); 
		spedGdsu.setPropertyEditorType(Long.class); 
		spedGdsu.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_417.add(spedGdsu, new FormData("100%"));
		spedGdsu.setFieldLabel("초.중.고등학교");

		layoutContainer_411.add(layoutContainer_417, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_417.setBorders(false);

		LayoutContainer layoutContainer_418 = new LayoutContainer();
		
		FormLayout frmlytSch418 = new FormLayout();
		frmlytSch418.setLabelWidth(0);

		layoutContainer_418.setLayout(frmlytSch418);

		//특별공제_교육비_초중고
		spedGdam = new MSFNumberField();
		spedGdam.setReadOnly(true);
		
		spedGdam.setAllowDecimals(true); 
		spedGdam.setPropertyEditorType(Long.class); 
		spedGdam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_418.add(spedGdam, new FormData("100%"));
		spedGdam.setLabelSeparator("");

		layoutContainer_411.add(layoutContainer_418, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_418.setBorders(false);

		layoutContainer_402.add(layoutContainer_411);
		layoutContainer_411.setBorders(false);

		// 초.중.고등학교(공제)
		LayoutContainer layoutContainer_412 = new LayoutContainer();

		FormLayout frmlytSch233 = new FormLayout();
		frmlytSch233.setLabelWidth(150);
		frmlytSch233.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_412.setLayout(frmlytSch233);

		spedGdto = new MSFNumberField();
		spedGdto.setReadOnly(true);
		
		spedGdto.setAllowDecimals(true); 
		spedGdto.setPropertyEditorType(Long.class); 
		spedGdto.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_412.add(spedGdto, new FormData("100%"));
		spedGdto.setFieldLabel("초.중.고등학교(공제)");

		layoutContainer_402.add(layoutContainer_412, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_412.setBorders(false);

		// 대학원(대학원불포함)
		LayoutContainer layoutContainer_413 = new LayoutContainer();
		layoutContainer_413.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_419 = new LayoutContainer();

		FormLayout frmlytSch234 = new FormLayout();
		frmlytSch234.setLabelWidth(150);
		frmlytSch234.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_419.setLayout(frmlytSch234);

		//특별공제_교육비_대학생수
		spedCvsu = new MSFNumberField();
		spedCvsu.setReadOnly(true);
		
		layoutContainer_419.add(spedCvsu, new FormData("100%"));
		spedCvsu.setFieldLabel("대학원(대학원불포함)");

		layoutContainer_413.add(layoutContainer_419, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_419.setBorders(false);

		LayoutContainer layoutContainer_420 = new LayoutContainer();
		
		FormLayout frmlytSch420 = new FormLayout();
		frmlytSch420.setLabelWidth(0);

		layoutContainer_420.setLayout(frmlytSch420);

		//특별공제_교육비_대학교
		spedCvam = new MSFNumberField();
		spedCvam.setReadOnly(true);
		
		spedCvam.setAllowDecimals(true); 
		spedCvam.setPropertyEditorType(Long.class); 
		spedCvam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_420.add(spedCvam, new FormData("100%"));
		spedCvam.setLabelSeparator("");

		layoutContainer_413.add(layoutContainer_420, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_420.setBorders(false);

		layoutContainer_402.add(layoutContainer_413);
		layoutContainer_413.setBorders(false);

		// 대학원생(공제)
		LayoutContainer layoutContainer_414 = new LayoutContainer();

		FormLayout frmlytSch235 = new FormLayout();
		frmlytSch235.setLabelWidth(150);
		frmlytSch235.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_414.setLayout(frmlytSch235);

		spedCldv = new MSFNumberField();
		spedCldv.setReadOnly(true);
		
		spedCldv.setAllowDecimals(true); 
		spedCldv.setPropertyEditorType(Long.class); 
		spedCldv.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_414.add(spedCldv, new FormData("100%"));
//		nmbrfldNewNumberfield_169.setWidth("175");
		spedCldv.setFieldLabel("대학원생(공제)");

		layoutContainer_402.add(layoutContainer_414, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_414.setBorders(false);

		layoutContainer_400.add(layoutContainer_402, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_402.setBorders(false);

		fldstNewFieldset_37.add(layoutContainer_400);
		layoutContainer_374.add(fldstNewFieldset_37);
		fldstNewFieldset_37.setHeadingHtml("가족교육비등록");
		layoutContainer_371.add(layoutContainer_374);
		layoutContainer_374.setBorders(false);

		// 장애인
		FieldSet fldstNewFieldset_38 = new FieldSet();
		fldstNewFieldset_38.setHeadingHtml("장애인");

		LayoutContainer layoutContainer_403 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_403.setLayout(new ColumnLayout());

		// 특수교육비
		LayoutContainer layoutContainer_404 = new LayoutContainer();

		FormLayout frmlytSch218 = new FormLayout();
		frmlytSch218.setLabelWidth(80);
		frmlytSch218.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_404.setLayout(frmlytSch218);

		//특별공제_장애인수
		spciScam = new MSFNumberField();
		
		spciScam.setAllowDecimals(true); 
		spciScam.setPropertyEditorType(Long.class); 
		spciScam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_404.add(spciScam, new FormData("100%"));
		spciScam.setFieldLabel("특수교육비");
		layoutContainer_403.add(layoutContainer_404, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_404.setBorders(false);

		// 특별공제_장애인특수교육비 공제대상계
		LayoutContainer layoutContainer_405 = new LayoutContainer();

		FormLayout frmlytSch219 = new FormLayout();
		frmlytSch219.setLabelWidth(80);
		frmlytSch219.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_405.setLayout(frmlytSch219);

		spciSctr = new MSFNumberField();
		spciSctr.setReadOnly(true);
		
		spciSctr.setAllowDecimals(true); 
		spciSctr.setPropertyEditorType(Long.class); 
		spciSctr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_405.add(spciSctr, new FormData("100%"));
		spciSctr.setFieldLabel("공제대상");
		layoutContainer_403.add(layoutContainer_405, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_405.setBorders(false);

		// 특별공제_장애인특수교육비 세액공제
		LayoutContainer layoutContainer_406 = new LayoutContainer();

		FormLayout frmlytSch220 = new FormLayout();
		frmlytSch220.setLabelWidth(80);
		frmlytSch220.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_406.setLayout(frmlytSch220);

		spciSpec = new MSFNumberField();
		spciSpec.setReadOnly(true);
		
		spciSpec.setAllowDecimals(true); 
		spciSpec.setPropertyEditorType(Long.class); 
		spciSpec.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_406.add(spciSpec, new FormData("100%"));
		spciSpec.setFieldLabel("세액공제");
		layoutContainer_403.add(layoutContainer_406, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_406.setBorders(false);

		fldstNewFieldset_38.add(layoutContainer_403);
		
		layoutContainer_371.add(fldstNewFieldset_38);

		LayoutContainer layoutContainer_376 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_376.setLayout(new ColumnLayout());

		// 교육비금액계
		LayoutContainer layoutContainer_393 = new LayoutContainer();

		FormLayout frmlytSch221 = new FormLayout();
		frmlytSch221.setLabelWidth(80);
		frmlytSch221.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_393.setLayout(frmlytSch221);

		siedToam = new MSFNumberField();
		siedToam.setReadOnly(true);
		
		siedToam.setAllowDecimals(true); 
		siedToam.setPropertyEditorType(Long.class); 
		siedToam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_393.add(siedToam, new FormData("100%"));
		siedToam.setFieldLabel("교육비금액계");
		layoutContainer_376.add(layoutContainer_393, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_393.setBorders(false);

		// 특별공제_교육비공제대상금액 공제대상계
		LayoutContainer layoutContainer_394 = new LayoutContainer();

		FormLayout frmlytSch222 = new FormLayout();
		frmlytSch222.setLabelWidth(80);
		frmlytSch222.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_394.setLayout(frmlytSch222);

		spedEtar = new MSFNumberField();
		spedEtar.setReadOnly(true);
		
		spedEtar.setAllowDecimals(true); 
		spedEtar.setPropertyEditorType(Long.class); 
		spedEtar.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_394.add(spedEtar, new FormData("100%"));
		spedEtar.setFieldLabel("공제대상계");
		layoutContainer_376.add(layoutContainer_394, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_394.setBorders(false);

		// 특별공제_교육비세액공제금액 세액공제계
		LayoutContainer layoutContainer_395 = new LayoutContainer();

		FormLayout frmlytSch223 = new FormLayout();
		frmlytSch223.setLabelWidth(80);
		frmlytSch223.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_395.setLayout(frmlytSch223);

		spedTxcr = new MSFNumberField();
		spedTxcr.setReadOnly(true);
		
		spedTxcr.setAllowDecimals(true); 
		spedTxcr.setPropertyEditorType(Long.class); 
		spedTxcr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_395.add(spedTxcr, new FormData("100%"));
		spedTxcr.setFieldLabel("세액공제계");
		layoutContainer_376.add(layoutContainer_395, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_395.setBorders(false);

		layoutContainer_371.add(layoutContainer_376);
		layoutContainer_376.setBorders(false);

		fldstNewFieldset_35.add(layoutContainer_371);
		layoutContainer_370.add(fldstNewFieldset_35);
		fldstNewFieldset_35.setHeadingHtml("교육비공제");
		cntntpnlNewContentpanel_5.add(layoutContainer_370);
		itemYeta08_3.add(cntntpnlNewContentpanel_5);
		cntntpnlNewContentpanel_5.setHeight("415px");  //355

		// 기부금tab
		TabItem itemYeta08_4 = new TabItem("기부금");
		itemYeta08_4.setId("itemYeta08_4");
		itemYeta08_4.setBorders(true);
		tabsItemYeta08.add(itemYeta08_4);
		itemYeta08_4.setHeight("370px");

		ContentPanel cntntpnlNewContentpanel_6 = new ContentPanel();
		cntntpnlNewContentpanel_6.setScrollMode(Scroll.AUTOY);
		cntntpnlNewContentpanel_6.setHeaderVisible(false);
		cntntpnlNewContentpanel_6.setHeadingText("");


		// 기부금
		FieldSet fieldSet_2 = new FieldSet();
		fieldSet_2.setHeadingHtml("기부금");
		
		// 버튼
		LayoutContainer layoutContainer_360 = new LayoutContainer();

		ButtonBar buttonBar_5 = new ButtonBar();
		buttonBar_5.setAlignment(HorizontalAlignment.RIGHT);

		Button btnNewButton_13 = new Button("이월기부금등록");
		buttonBar_5.add(btnNewButton_13);
		btnNewButton_13.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP13001 yetaP03001Form = new YetaP13001(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwYeta13001 = new MSFFormWindows("이월기부금등록", yetaP03001Form, "닫기", "820px", "710px", true);
				msFwYeta13001.show();
				yetaP03001Form.setMSFFormWindows(msFwYeta13001);
				
				funcSetPopUpRecord();
				
				//TODO 추후 주석해제 
				yetaP03001Form.bind(ppRecord); 
			}
		});

		Button btnNewButton_14 = new Button("기부금내역등록");
		buttonBar_5.add(btnNewButton_14);
		btnNewButton_14.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP13003 yetaP03003Form = new YetaP13003(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwYeta13003 = new MSFFormWindows("기부금내역등록", yetaP03003Form, "닫기", "820px", "710px", true);
				msFwYeta13003.show();
				yetaP03003Form.setMSFFormWindows(msFwYeta13003);
				
				funcSetPopUpRecord();
				//TODO 추후 주석해제 
				yetaP03003Form.bind(ppRecord); 
			}
		});	

		layoutContainer_360.add(buttonBar_5);
		fieldSet_2.add(layoutContainer_360);
		layoutContainer_360.setBorders(false);
		
		LayoutContainer layoutContainer_gibu = new LayoutContainer();
//		layoutContainer_gibu.setLayout(new ColumnLayout());
		layoutContainer_gibu.setBorders(false);
		
		
		LayoutContainer layoutContainer_gibu01 = new LayoutContainer(new ColumnLayout());
		
		// 정치자금(10만원이하)
		LayoutContainer layoutContainer_giLeftbu01 = new LayoutContainer();
		
		FormLayout frmlytSchLeft01 = new FormLayout();
		frmlytSchLeft01.setLabelWidth(170);
		frmlytSchLeft01.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu01.setLayout(frmlytSchLeft01);
		layoutContainer_giLeftbu01.setBorders(false);

		//세액공제_기부정치자금금액
		taxdPltc = new MSFNumberField();
		taxdPltc.setReadOnly(true);
		
		taxdPltc.setAllowDecimals(true); 
		taxdPltc.setPropertyEditorType(Long.class); 
		taxdPltc.setFormat(NumberFormat.getDecimalFormat());
		
		taxdPltc.setFieldLabel("정치자금(10만원이하)");
		layoutContainer_giLeftbu01.add(taxdPltc, new FormData("100%"));
		layoutContainer_gibu01.add(layoutContainer_giLeftbu01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter01 = new LayoutContainer();
		layoutContainer_gibuCenter01.setBorders(false);
		
		FormLayout frmlytSchCenter01 = new FormLayout();
		frmlytSchCenter01.setLabelWidth(0);
		
		layoutContainer_gibuCenter01.setLayout(frmlytSchCenter01);

		//특별공제_기부정치자금_10이하대상금액
		taxd10tg = new MSFNumberField();
		taxd10tg.setReadOnly(true);
		
		taxd10tg.setAllowDecimals(true); 
		taxd10tg.setPropertyEditorType(Long.class); 
		taxd10tg.setFormat(NumberFormat.getDecimalFormat());
		
		taxd10tg.setLabelSeparator("");
		layoutContainer_gibuCenter01.add(taxd10tg, new FormData("100%"));
		layoutContainer_gibu01.add(layoutContainer_gibuCenter01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer_gibuRight01 = new LayoutContainer();
		layoutContainer_gibuRight01.setBorders(false);
		
		FormLayout frmlytSchRight01 = new FormLayout();
		frmlytSchRight01.setLabelWidth(0);
		
		
		layoutContainer_gibuRight01.setLayout(frmlytSchRight01);

		// 세액공제_기부정치자금 공제액
		taxdPltc01 = new MSFNumberField();
		taxdPltc01.setReadOnly(true);
		
		taxdPltc01.setAllowDecimals(true); 
		taxdPltc01.setPropertyEditorType(Long.class); 
		taxdPltc01.setFormat(NumberFormat.getDecimalFormat());
		
		taxdPltc01.setLabelSeparator("");
		layoutContainer_gibuRight01.add(taxdPltc01, new FormData("100%"));
		layoutContainer_gibu01.add(layoutContainer_gibuRight01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer_gibu02 = new LayoutContainer(new ColumnLayout());
		// 정치자금(10만원초과)
		LayoutContainer layoutContainer_gibuLeft02 = new LayoutContainer();
				
		FormLayout frmlytSchLeft02 = new FormLayout();
		frmlytSchLeft02.setLabelWidth(170);
		frmlytSchLeft02.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft02.setLayout(frmlytSchLeft02);
		layoutContainer_gibuLeft02.setBorders(false);

		//특별공제_기부금_정치
		spciPltc = new MSFNumberField();
		spciPltc.setReadOnly(true);
		
		spciPltc.setAllowDecimals(true); 
		spciPltc.setPropertyEditorType(Long.class); 
		spciPltc.setFormat(NumberFormat.getDecimalFormat());
		
		spciPltc.setFieldLabel("정치자금(10만원초과)");
		layoutContainer_gibuLeft02.add(spciPltc, new FormData("100%"));
		layoutContainer_gibu02.add(layoutContainer_gibuLeft02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter02 = new LayoutContainer();
		layoutContainer_gibuCenter02.setBorders(false);
		
		FormLayout frmlytSchCenter02 = new FormLayout();
		frmlytSchCenter02.setLabelWidth(0);
		
		layoutContainer_gibuCenter02.setLayout(frmlytSchCenter02);

		//특별공제_기부금_정치10초과대상금액
		spciPltg = new MSFNumberField();
		spciPltg.setReadOnly(true);
		
		spciPltg.setAllowDecimals(true); 
		spciPltg.setPropertyEditorType(Long.class); 
		spciPltg.setFormat(NumberFormat.getDecimalFormat());
		
		spciPltg.setLabelSeparator("");
		layoutContainer_gibuCenter02.add(spciPltg, new FormData("100%"));
		layoutContainer_gibu02.add(layoutContainer_gibuCenter02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer layoutContainer_gibuRight02 = new LayoutContainer();
		layoutContainer_gibuRight02.setBorders(false);
		
		FormLayout frmlytSchRight02 = new FormLayout();
		frmlytSchRight02.setLabelWidth(0);
		
		layoutContainer_gibuRight02.setLayout(frmlytSchRight02);

		//특별공제_기부금_정치 공제액
		spciPltc01 = new MSFNumberField();
		spciPltc01.setReadOnly(true);
		
		spciPltc01.setAllowDecimals(true); 
		spciPltc01.setPropertyEditorType(Long.class); 
		spciPltc01.setFormat(NumberFormat.getDecimalFormat());
		
		spciPltc01.setLabelSeparator("");
		layoutContainer_gibuRight02.add(spciPltc01, new FormData("100%"));
		layoutContainer_gibu02.add(layoutContainer_gibuRight02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer_gibu03 = new LayoutContainer(new ColumnLayout());
		// 전액공제기부금액(법정)
		LayoutContainer layoutContainer_gibuLeft03 = new LayoutContainer();
				
		FormLayout frmlytSchLeft03 = new FormLayout();
		frmlytSchLeft03.setLabelWidth(170);
		frmlytSchLeft03.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft03.setLayout(frmlytSchLeft03);
		layoutContainer_gibuLeft03.setBorders(false);

		spciFbam = new  MSFNumberField();
		spciFbam.setReadOnly(true);
		
		spciFbam.setAllowDecimals(true); 
		spciFbam.setPropertyEditorType(Long.class); 
		spciFbam.setFormat(NumberFormat.getDecimalFormat());
		
		spciFbam.setFieldLabel("전액공제기부금액(법정)");
		layoutContainer_gibuLeft03.add(spciFbam, new FormData("100%"));
		layoutContainer_gibu03.add(layoutContainer_gibuLeft03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer_gibuCenter03 = new LayoutContainer();
		layoutContainer_gibuCenter03.setBorders(false);
		
		FormLayout frmlytSchCenter03 = new FormLayout();
		frmlytSchCenter03.setLabelWidth(0);
		
		layoutContainer_gibuCenter03.setLayout(frmlytSchCenter03);

		//특별공제_기부금_법정대상금액
		spciFbtg = new  MSFNumberField();
		spciFbtg.setReadOnly(true);
		
		spciFbtg.setAllowDecimals(true); 
		spciFbtg.setPropertyEditorType(Long.class); 
		spciFbtg.setFormat(NumberFormat.getDecimalFormat());
		
		spciFbtg.setLabelSeparator("");
		layoutContainer_gibuCenter03.add(spciFbtg, new FormData("100%"));
		layoutContainer_gibu03.add(layoutContainer_gibuCenter03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight03 = new LayoutContainer();
		layoutContainer_gibuRight03.setBorders(false);
		
		FormLayout frmlytSchRight03 = new FormLayout();
		frmlytSchRight03.setLabelWidth(0);
		
		layoutContainer_gibuRight03.setLayout(frmlytSchRight03);

		//특별공제_기부금_법정 공제액
		spciFbam01 = new   MSFNumberField();
		spciFbam01.setReadOnly(true);
		
		spciFbam01.setAllowDecimals(true); 
		spciFbam01.setPropertyEditorType(Long.class); 
		spciFbam01.setFormat(NumberFormat.getDecimalFormat());
		
		spciFbam01.setLabelSeparator("");
		layoutContainer_gibuRight03.add(spciFbam01, new FormData("100%"));
		layoutContainer_gibu03.add(layoutContainer_gibuRight03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer layoutContainer_gibu04 = new LayoutContainer(new ColumnLayout());
		// 특례기부금(공익법인신탁제외)
		LayoutContainer layoutContainer_gibuLeft04 = new LayoutContainer();
				
		FormLayout frmlytSchLeft04 = new FormLayout();
		frmlytSchLeft04.setLabelWidth(170);
		frmlytSchLeft04.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft04.setLayout(frmlytSchLeft04);

		spciExam = new MSFNumberField();
		spciExam.setReadOnly(true);
		
		spciExam.setAllowDecimals(true); 
		spciExam.setPropertyEditorType(Long.class); 
		spciExam.setFormat(NumberFormat.getDecimalFormat());
		
		spciExam.setFieldLabel("특례기부금(공익법인신탁제외)");
		layoutContainer_gibuLeft04.add(spciExam, new FormData("100%"));
		layoutContainer_gibu04.add(layoutContainer_gibuLeft04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter04 = new LayoutContainer();
		layoutContainer_gibuCenter04.setBorders(false);
		
		FormLayout frmlytSchCenter04 = new FormLayout();
		frmlytSchCenter04.setLabelWidth(0);
		
		layoutContainer_gibuCenter04.setLayout(frmlytSchCenter04);

		//특례기부금_공익법인제외대상금액
		spciExtg = new MSFNumberField();
		spciExtg.setReadOnly(true);
		
		spciExtg.setAllowDecimals(true); 
		spciExtg.setPropertyEditorType(Long.class); 
		spciExtg.setFormat(NumberFormat.getDecimalFormat());
		
		spciExtg.setLabelSeparator("");
		layoutContainer_gibuCenter04.add(spciExtg, new FormData("100%"));
		layoutContainer_gibu04.add(layoutContainer_gibuCenter04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight04 = new LayoutContainer();
		layoutContainer_gibuRight04.setBorders(false);
		
		FormLayout frmlytSchRight04 = new FormLayout();
		frmlytSchRight04.setLabelWidth(0);
		
		layoutContainer_gibuRight04.setLayout(frmlytSchRight04);

		//특별공제_기부금_특례_공익법인신탁제외 공제세액
		spciExam01 = new MSFNumberField();
		spciExam01.setReadOnly(true);
		
		spciExam01.setAllowDecimals(true); 
		spciExam01.setPropertyEditorType(Long.class); 
		spciExam01.setFormat(NumberFormat.getDecimalFormat());
		
		spciExam01.setLabelSeparator("");
		layoutContainer_gibuRight04.add(spciExam01, new FormData("100%"));
		layoutContainer_gibu04.add(layoutContainer_gibuRight04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer_gibu05 = new LayoutContainer(new ColumnLayout());
		// 우리사주조합 기부금
		LayoutContainer layoutContainer_gibuLeft05 = new LayoutContainer();
		
		FormLayout frmlytSchLeft05 = new FormLayout();
		frmlytSchLeft05.setLabelWidth(170);
		frmlytSchLeft05.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_gibuLeft05.setLayout(frmlytSchLeft05);

		spciHfam = new  MSFNumberField();
		spciHfam.setReadOnly(true);
		
		spciHfam.setAllowDecimals(true); 
		spciHfam.setPropertyEditorType(Long.class); 
		spciHfam.setFormat(NumberFormat.getDecimalFormat());
		
		spciHfam.setFieldLabel("우리사주조합 기부금");
		layoutContainer_gibuLeft05.add(spciHfam, new FormData("100%"));
		layoutContainer_gibu05.add(layoutContainer_gibuLeft05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer_gibuCenter05 = new LayoutContainer();
		layoutContainer_gibuCenter05.setBorders(false);
		
		FormLayout frmlytSchCenter05 = new FormLayout();
		frmlytSchCenter05.setLabelWidth(0);
		
		layoutContainer_gibuCenter05.setLayout(frmlytSchCenter05);

		
		//우리사주종합기부대상금액
		spciHftg = new MSFNumberField();
		spciHftg.setReadOnly(true);
		
		spciHftg.setAllowDecimals(true); 
		spciHftg.setPropertyEditorType(Long.class); 
		spciHftg.setFormat(NumberFormat.getDecimalFormat());
		
		spciHftg.setLabelSeparator("");
		layoutContainer_gibuCenter05.add(spciHftg, new FormData("100%"));
		layoutContainer_gibu05.add(layoutContainer_gibuCenter05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight05 = new LayoutContainer();
		layoutContainer_gibuRight05.setBorders(false);
		
		FormLayout frmlytSchRight05 = new FormLayout();
		frmlytSchRight05.setLabelWidth(0);
		
		layoutContainer_gibuRight05.setLayout(frmlytSchRight05);

		//특별공제_기부금_우리사주조합2015이후
		spciRfam = new  MSFNumberField();
		spciRfam.setReadOnly(true);
		
		spciRfam.setAllowDecimals(true); 
		spciRfam.setPropertyEditorType(Long.class); 
		spciRfam.setFormat(NumberFormat.getDecimalFormat());
		
		spciRfam.setLabelSeparator("");
		layoutContainer_gibuRight05.add(spciRfam, new FormData("100%"));
		layoutContainer_gibu05.add(layoutContainer_gibuRight05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer layoutContainer_gibu06 = new LayoutContainer(new ColumnLayout());
		// 종교단체외지정기부금
		LayoutContainer layoutContainer_gibuLeft06 = new LayoutContainer();
		layoutContainer_gibuLeft06.setBorders(false);
				
		FormLayout frmlytSchLeft06 = new FormLayout();
		frmlytSchLeft06.setLabelWidth(170);
		frmlytSchLeft06.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft06.setLayout(frmlytSchLeft06);
				

		spciNamt = new MSFNumberField();
		spciNamt.setReadOnly(true);
		
		spciNamt.setAllowDecimals(true); 
		spciNamt.setPropertyEditorType(Long.class); 
		spciNamt.setFormat(NumberFormat.getDecimalFormat());
		
		spciNamt.setFieldLabel("종교단체외지정기부금");
		layoutContainer_gibuLeft06.add(spciNamt, new FormData("100%"));
		layoutContainer_gibu06.add(layoutContainer_gibuLeft06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter06 = new LayoutContainer();
		layoutContainer_gibuCenter06.setBorders(false);
		
		FormLayout frmlytSchCenter06= new FormLayout();
		frmlytSchCenter06.setLabelWidth(0);
		
		layoutContainer_gibuCenter06.setLayout(frmlytSchCenter06);

		
		//종교단체외지정대상금액
		spciNatg = new MSFNumberField();
		spciNatg.setReadOnly(true);
		
		spciNatg.setAllowDecimals(true); 
		spciNatg.setPropertyEditorType(Long.class); 
		spciNatg.setFormat(NumberFormat.getDecimalFormat());
		
		spciNatg.setLabelSeparator("");
		layoutContainer_gibuCenter06.add(spciNatg, new FormData("100%"));
		layoutContainer_gibu06.add(layoutContainer_gibuCenter06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight06 = new LayoutContainer();
		layoutContainer_gibuRight06.setBorders(false);
		
		FormLayout frmlytSchRight06 = new FormLayout();
		frmlytSchRight06.setLabelWidth(0);
		
		layoutContainer_gibuRight06.setLayout(frmlytSchRight06);

		//특별공제_기부금_종교단체외 공제액
		spciNamt01 = new MSFNumberField();
		spciNamt01.setReadOnly(true);
		
		
		spciNamt01.setAllowDecimals(true); 
		spciNamt01.setPropertyEditorType(Long.class); 
		spciNamt01.setFormat(NumberFormat.getDecimalFormat());
		
		spciNamt01.setLabelSeparator("");
		layoutContainer_gibuRight06.add(spciNamt01, new FormData("100%"));
		layoutContainer_gibu06.add(layoutContainer_gibuRight06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer_gibu07 = new LayoutContainer(new ColumnLayout());
		// 종교단체지정기부금
		LayoutContainer layoutContainer_gibuLeft07 = new LayoutContainer();
		layoutContainer_gibuLeft07.setBorders(false);
				
		FormLayout frmlytSchLeft07 = new FormLayout();
		frmlytSchLeft07.setLabelWidth(170);
		frmlytSchLeft07.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft07.setLayout(frmlytSchLeft07);

		spciYamt = new MSFNumberField();
		spciYamt.setReadOnly(true);
		
		spciYamt.setAllowDecimals(true); 
		spciYamt.setPropertyEditorType(Long.class); 
		spciYamt.setFormat(NumberFormat.getDecimalFormat());
		
		spciYamt.setFieldLabel("종교단체지정기부금");
		layoutContainer_gibuLeft07.add(spciYamt, new FormData("100%"));
		layoutContainer_gibu07.add(layoutContainer_gibuLeft07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer_gibuCenter07 = new LayoutContainer();
		layoutContainer_gibuCenter07.setBorders(false);
		
		FormLayout frmlytSchCenter07= new FormLayout();
		frmlytSchCenter07.setLabelWidth(0);
		
		layoutContainer_gibuCenter07.setLayout(frmlytSchCenter07);

		//종교단체지정대상금액
		spciYatg = new MSFNumberField();
		spciYatg.setReadOnly(true);
		
		spciYatg.setAllowDecimals(true); 
		spciYatg.setPropertyEditorType(Long.class); 
		spciYatg.setFormat(NumberFormat.getDecimalFormat());
		
		spciYatg.setLabelSeparator("");
		layoutContainer_gibuCenter07.add(spciYatg, new FormData("100%"));
		layoutContainer_gibu07.add(layoutContainer_gibuCenter07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight07 = new LayoutContainer();
		layoutContainer_gibuRight07.setBorders(false);
		
		FormLayout frmlytSchRight07 = new FormLayout();
		frmlytSchRight07.setLabelWidth(0);
		
		layoutContainer_gibuRight07.setLayout(frmlytSchRight07);

		//특별공제_기부금_종교단체 공제액
		spciYamt01= new MSFNumberField();
		spciYamt01.setReadOnly(true);
		
		spciYamt01.setAllowDecimals(true); 
		spciYamt01.setPropertyEditorType(Long.class); 
		spciYamt01.setFormat(NumberFormat.getDecimalFormat());
		
		spciYamt01.setLabelSeparator("");
		layoutContainer_gibuRight07.add(spciYamt01, new FormData("100%"));
		layoutContainer_gibu07.add(layoutContainer_gibuRight07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		//----------------------------------------------------
		
		layoutContainer_gibu.add(layoutContainer_gibu01);
		layoutContainer_gibu.add(layoutContainer_gibu02);
		layoutContainer_gibu.add(layoutContainer_gibu03);
		layoutContainer_gibu.add(layoutContainer_gibu04);
		layoutContainer_gibu.add(layoutContainer_gibu05);
		layoutContainer_gibu.add(layoutContainer_gibu06);
		layoutContainer_gibu.add(layoutContainer_gibu07);
		
		fieldSet_2.add(layoutContainer_gibu);
		cntntpnlNewContentpanel_6.add(fieldSet_2);
		
//		LayoutContainer layoutContainer_358 = new LayoutContainer();
		
		FieldSet fldstNewFieldset_34 = new FieldSet();
		fldstNewFieldset_34.setHeadingHtml("기부금공제");
		LayoutContainer layoutContainer_359 = new LayoutContainer();

		//
		LayoutContainer layoutContainer_362 = new LayoutContainer();
		layoutContainer_362.setLayout(new ColumnLayout());

		// 기부금액계
		LayoutContainer layoutContainer_421 = new LayoutContainer();

		FormLayout frmlytSch242 = new FormLayout();
		frmlytSch242.setLabelWidth(100);
		frmlytSch242.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_421.setLayout(frmlytSch242);

		spciDgam = new  MSFNumberField();
		spciDgam.setReadOnly(true);
		spciDgam.setFieldLabel("기부금액계");
		
		spciDgam.setAllowDecimals(true); 
		spciDgam.setPropertyEditorType(Long.class); 
		spciDgam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_421.add(spciDgam, new FormData("100%"));
		
		
		layoutContainer_362.add(layoutContainer_421, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_421.setBorders(false);
		

		// 공제대상계
		LayoutContainer layoutContainer_422 = new LayoutContainer();

		FormLayout frmlytSch243 = new FormLayout();
		frmlytSch243.setLabelWidth(100);
		frmlytSch243.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_422.setLayout(frmlytSch243);

		spciDgtg = new  MSFNumberField();
		spciDgtg.setReadOnly(true);
		
		spciDgtg.setAllowDecimals(true); 
		spciDgtg.setPropertyEditorType(Long.class); 
		spciDgtg.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_422.add(spciDgtg, new FormData("100%"));
		spciDgtg.setFieldLabel("공제대상계");
		layoutContainer_362.add(layoutContainer_422, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_422.setBorders(false);

		//기부금 세액공제계
		LayoutContainer layoutContainer_423 = new LayoutContainer();

		FormLayout frmlytSch244 = new FormLayout();
		frmlytSch244.setLabelWidth(100);
		frmlytSch244.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_423.setLayout(frmlytSch244);

		spciDgcr = new MSFNumberField();
		spciDgcr.setReadOnly(true);
		
		spciDgcr.setAllowDecimals(true); 
		spciDgcr.setPropertyEditorType(Long.class); 
		spciDgcr.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_423.add(spciDgcr, new FormData("100%"));
		spciDgcr.setFieldLabel("세액공제계");
		layoutContainer_362.add(layoutContainer_423, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_423.setBorders(false);

		layoutContainer_359.add(layoutContainer_362);
		layoutContainer_362.setBorders(false);
		
		
		
		LayoutContainer layoutContainer_428 = new LayoutContainer(new ColumnLayout());
		layoutContainer_428.setBorders(false);
		
		
		LayoutContainer layoutContainer_428_left = new LayoutContainer();
		layoutContainer_428_left.setBorders(false);
		
		
		LayoutContainer layoutContainer_428_left01 = new LayoutContainer();
		
		FormLayout frmlytSch428 = new FormLayout();
		frmlytSch428.setLabelWidth(170);
		frmlytSch428.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_left01.setLayout(frmlytSch428);

		spciObam = new MSFNumberField();
		spciObam.setReadOnly(true);
		spciObam.setFieldLabel("이월법정기부금액");
		
		spciObam.setAllowDecimals(true); 
		spciObam.setPropertyEditorType(Long.class); 
		spciObam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_left01.add(spciObam, new FormData("100%"));
		layoutContainer_428_left.add(layoutContainer_428_left01);
		
		LayoutContainer layoutContainer_428_left02 = new LayoutContainer();
		
		frmlytSch428 = new FormLayout();
		frmlytSch428.setLabelWidth(170);
		frmlytSch428.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_left02.setLayout(frmlytSch428);

		spciOyam = new  MSFNumberField();
		spciOyam.setReadOnly(true);
		spciOyam.setFieldLabel("이월지정기부금(종교단체 외)");
		
		spciOyam.setAllowDecimals(true); 
		spciOyam.setPropertyEditorType(Long.class); 
		spciOyam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_left02.add(spciOyam, new FormData("100%"));
		layoutContainer_428_left.add(layoutContainer_428_left02);
		
		LayoutContainer layoutContainer_428_left03 = new LayoutContainer();
		
		frmlytSch428 = new FormLayout();
		frmlytSch428.setLabelWidth(170);
		frmlytSch428.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_left03.setLayout(frmlytSch428);

		spciOnam = new  MSFNumberField();
		spciOnam.setReadOnly(true);
		spciOnam.setFieldLabel("이월지정기부금(종교단체)");
		
		spciOnam.setAllowDecimals(true); 
		spciOnam.setPropertyEditorType(Long.class); 
		spciOnam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_left03.add(spciOnam, new FormData("100%"));
		layoutContainer_428_left.add(layoutContainer_428_left03);
		
		
		layoutContainer_428.add(layoutContainer_428_left, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		
		LayoutContainer layoutContainer_428_right = new LayoutContainer();
		layoutContainer_428_right.setBorders(false);
		
		
		//이월법정기부금액_공제액
		LayoutContainer layoutContainer_428_right01 = new LayoutContainer();
		
		FormLayout frmlytSch429 = new FormLayout();
		frmlytSch429.setLabelWidth(100);
		frmlytSch429.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_right01.setLayout(frmlytSch429);

		spciObam01 = new MSFNumberField();
		spciObam01.setReadOnly(true);
		spciObam01.setFieldLabel("공제세액");
		
		spciObam01.setAllowDecimals(true); 
		spciObam01.setPropertyEditorType(Long.class); 
		spciObam01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_right01.add(spciObam01, new FormData("100%"));
		layoutContainer_428_right.add(layoutContainer_428_right01);
		
		
		
		//이월종교단체기부금_공제액
		LayoutContainer layoutContainer_428_right02 = new LayoutContainer();
		
		frmlytSch429 = new FormLayout();
		frmlytSch429.setLabelWidth(100);
		frmlytSch429.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_right02.setLayout(frmlytSch429);

		spciOyam01 = new MSFNumberField();
		spciOyam01.setReadOnly(true);
		spciOyam01.setFieldLabel("공제세액");
		
		spciOyam01.setAllowDecimals(true); 
		spciOyam01.setPropertyEditorType(Long.class); 
		spciOyam01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_right02.add(spciOyam01, new FormData("100%"));
		layoutContainer_428_right.add(layoutContainer_428_right02);
		
		
		
		//지정기부금(종교단체)_공제액
		LayoutContainer layoutContainer_428_right03 = new LayoutContainer();
		
		frmlytSch429 = new FormLayout();
		frmlytSch429.setLabelWidth(100);
		frmlytSch429.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_right03.setLayout(frmlytSch429);

		spciOnam01 = new MSFNumberField();
		spciOnam01.setReadOnly(true);
		spciOnam01.setFieldLabel("공제세액");
		
		spciOnam01.setAllowDecimals(true); 
		spciOnam01.setPropertyEditorType(Long.class); 
		spciOnam01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_right03.add(spciOnam01, new FormData("100%"));
		
		layoutContainer_428_right.add(layoutContainer_428_right03);
		
		
		layoutContainer_428.add(layoutContainer_428_right, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		
		layoutContainer_359.add(layoutContainer_428);
		
		
		

//		// 기부금(이월분)
//		LayoutContainer layoutContainer_363 = new LayoutContainer();
//
//		FormLayout frmlytSch174 = new FormLayout();
//		frmlytSch174.setLabelWidth(100);
//		frmlytSch174.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_363.setLayout(frmlytSch174);
//
//		spciSsum = new NumberField();
//		
//		spciSsum.setAllowDecimals(true); 
//		spciSsum.setPropertyEditorType(Long.class); 
//		spciSsum.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_363.add(spciSsum, new FormData("35%"));
//		spciSsum.setFieldLabel("기부금(이월분)");
//		layoutContainer_359.add(layoutContainer_363);
//		layoutContainer_363.setBorders(false);

		// 기부금적용순서
		LayoutContainer layoutContainer_364 = new LayoutContainer();

		LabelField lblfldNewLabelfield_37 = new LabelField(
				"* 기부금적용순서 : 이월기부금등록 -> 기부금내역등록 순으로");
		layoutContainer_364.add(lblfldNewLabelfield_37);
		layoutContainer_359.add(layoutContainer_364);
		layoutContainer_364.setBorders(false);

		// 기부금은
		LayoutContainer layoutContainer_365 = new LayoutContainer();

		LabelField lblfldNewLabelfield_38 = new LabelField("* 기부금은 기부금액 -> 공제대상금액 -> 공제세액순으로 표시됩니다.");
		layoutContainer_365.add(lblfldNewLabelfield_38);
		layoutContainer_359.add(layoutContainer_365);
		layoutContainer_365.setBorders(false);


		fldstNewFieldset_34.add(layoutContainer_359);
		
		cntntpnlNewContentpanel_6.add(fldstNewFieldset_34);
		
		
		// 기부금(이월분)
		LayoutContainer layoutContainer_363 = new LayoutContainer();

		FormLayout frmlytSch174 = new FormLayout();
		frmlytSch174.setLabelWidth(400);
		frmlytSch174.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_363.setLayout(frmlytSch174);

		spciSsum = new  MSFNumberField();
		spciSsum.setReadOnly(true);
		spciSsum.setFieldLabel("기부금(이월분)");
				
		spciSsum.setAllowDecimals(true); 
		spciSsum.setPropertyEditorType(Long.class); 
		spciSsum.setFormat(NumberFormat.getDecimalFormat());
				
		layoutContainer_363.add(spciSsum, new FormData("35%"));
		
		cntntpnlNewContentpanel_6.add(layoutContainer_363);
		layoutContainer_363.setBorders(false);
				
				
		itemYeta08_4.add(cntntpnlNewContentpanel_6);
		cntntpnlNewContentpanel_6.setHeight("450");

		layoutContainer_15.add(tabsItemYeta08);
		tabsItemYeta08.setHeight("450");

	
		cp01.add(layoutContainer_15);
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}	
	
	private LayoutContainer yetaData09() {
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setHeadingText("");
//		cp01.setSize("660", "450");
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setScrollMode(Scroll.AUTOY);
//		cp01.setSize("660", "450");
		
		
		LayoutContainer layoutContainer_16 = new LayoutContainer();
		  
		LayoutContainer layoutContainer_147 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_8 = new FieldSet();
		fldstNewFieldset_8.setHeadingHtml("외국인근로자");
		  
		LayoutContainer layoutContainer_151 = new LayoutContainer();
		layoutContainer_151.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_152 = new LayoutContainer();
		layoutContainer_152.setBorders(false);
		layoutContainer_152.setLayout(new ColumnLayout());
		  
		LabelField lblfldNewLabelfield_21 = new LabelField("입국목적");
		layoutContainer_152.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_152.add(lblfldNewLabelfield_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		  
		taxdIncd = new CheckBoxGroup();
		taxdIncd.setName("taxdIncd");
		
		  taxdIncd1 = new CheckBox();
//		layoutContainer_152.add(chckbxNewCheckbox1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		taxdIncd.add(taxdIncd1);
		taxdIncd1.setBoxLabel("정부간협약");
		taxdIncd1.setHideLabel(true);
		taxdIncd1.setValueAttribute("Y");
		  
		  taxdIncd2 = new CheckBox();
//		layoutContainer_152.add(chckbxNewCheckbox2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		taxdIncd.add(taxdIncd2);
		taxdIncd2.setBoxLabel("기술도입계약");
		taxdIncd2.setHideLabel(true);
		taxdIncd2.setValueAttribute("Y");
		  
		  taxdIncd3 = new CheckBox();
//		layoutContainer_152.add(chckbxNewCheckbox3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		taxdIncd.add(taxdIncd3);
		taxdIncd3.setBoxLabel("조세특례제한법 상 감면");
		taxdIncd3.setHideLabel(true);
		taxdIncd3.setValueAttribute("Y");
		  
		  taxdIncd4 = new CheckBox();
//		layoutContainer_152.add(chckbxNewCheckbox4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		taxdIncd.add(taxdIncd4);
		taxdIncd4.setBoxLabel("조세조약상 감면");
		taxdIncd4.setHideLabel(true);
		taxdIncd4.setValueAttribute("Y");
		  
		layoutContainer_152.add(taxdIncd);

		  
		layoutContainer_151.add(layoutContainer_152, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		  
		LayoutContainer layoutContainer_153 = new LayoutContainer();
		  
		  
		 //기술도입계약 또는 근로제공일
		LayoutContainer layoutContainer_155 = new LayoutContainer();
		  
		FormLayout frmlytSch49_1 = new FormLayout();
		frmlytSch49_1.setLabelWidth(250);
		frmlytSch49_1.setLabelAlign(LabelAlign.RIGHT);
		  
		layoutContainer_155.setLayout(frmlytSch49_1);

		taxdWkdt = new MSFDateField();
		taxdWkdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		taxdWkdt.setName("taxdWkdt");
	    new DateFieldMask(taxdWkdt, "9999.99.99");
		layoutContainer_155.add(taxdWkdt, new FormData("100%"));
		taxdWkdt.setFieldLabel("기술도입계약 또는 근로제공일");
		layoutContainer_153.add(layoutContainer_155);
		layoutContainer_155.setBorders(false);
		  
		// 외국인근로소득에 대한 감면 신청서 접수일자
		LayoutContainer layoutContainer_156 = new LayoutContainer();

		FormLayout frmlytSch63 = new FormLayout();
		frmlytSch63.setLabelWidth(250);
		frmlytSch63.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_156.setLayout(frmlytSch63);

		tamaIndt = new MSFDateField();
		tamaIndt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tamaIndt.setName("tamaIndt");
	    new DateFieldMask(tamaIndt, "9999.99.99");
		layoutContainer_156.add(tamaIndt, new FormData("100%"));
		tamaIndt.setFieldLabel("외국인근로소득에 대한 감면 신청서 접수일자");
		layoutContainer_153.add(layoutContainer_156);
		layoutContainer_156.setBorders(false);
		  
		// 해저광물자원개발에 대한 감면확인일자
		LayoutContainer layoutContainer_157 = new LayoutContainer();

		FormLayout frmlytSch64 = new FormLayout();
		frmlytSch64.setLabelWidth(250);
		frmlytSch64.setLabelAlign(LabelAlign.RIGHT);

		// 해저광물자원개발에 대한 감면확인일자
		layoutContainer_157.setLayout(frmlytSch64);

		txlgFrrd = new MSFDateField();
		txlgFrrd.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txlgFrrd.setName("txlgFrrd");
	    new DateFieldMask(txlgFrrd, "9999.99.99");
		layoutContainer_157.add(txlgFrrd, new FormData("100%"));
		txlgFrrd.setFieldLabel("해저광물자원개발에 대한 감면확인일자");
		layoutContainer_153.add(layoutContainer_157);
		layoutContainer_157.setBorders(false);

		
		LayoutContainer layoutContainer_161 = new LayoutContainer();

		FormLayout frmlytSch65 = new FormLayout();
		frmlytSch65.setLabelWidth(250);
		frmlytSch65.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_161.setLayout(frmlytSch65);

		txlgWkid = new MSFDateField();
		txlgWkid.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txlgWkid.setName("txlgWkid");
	    new DateFieldMask(txlgWkid, "9999.99.99");
		layoutContainer_161.add(txlgWkid, new FormData("100%"));
		txlgWkid.setFieldLabel("근로소득에 대한 조세조약상 면제 접수일자");
		layoutContainer_153.add(layoutContainer_161);
		layoutContainer_161.setBorders(false);
		  
		  
		layoutContainer_151.add(layoutContainer_153, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_153.setBorders(false);
		  
		LayoutContainer layoutContainer_154 = new LayoutContainer();
		  
		// 감면기간 만료일
		LayoutContainer layoutContainer_158 = new LayoutContainer();

		FormLayout frmlytSch66 = new FormLayout();
		frmlytSch66.setLabelWidth(100);
		frmlytSch66.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_158.setLayout(frmlytSch66);

		tamaEddt = new MSFDateField();
		tamaEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tamaEddt.setName("tamaEddt");
	    new DateFieldMask(tamaEddt, "9999.99.99");
		layoutContainer_158.add(tamaEddt, new FormData("100%"));
		tamaEddt.setFieldLabel("감면기간 만료일");
		layoutContainer_154.add(layoutContainer_158);
		layoutContainer_158.setBorders(false);

		//세액공제_외국인_감면신청 제출일자
		LayoutContainer layoutContainer_159 = new LayoutContainer();

		FormLayout frmlytSch67 = new FormLayout();
		frmlytSch67.setLabelWidth(100);
		frmlytSch67.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_159.setLayout(frmlytSch67);

		tamaOudt = new MSFDateField();
		tamaOudt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		tamaOudt.setName("tamaOudt");
	    new DateFieldMask(tamaOudt, "9999.99.99");
		layoutContainer_159.add(tamaOudt, new FormData("100%"));
		tamaOudt.setFieldLabel("제출일자");
		layoutContainer_154.add(layoutContainer_159);
		layoutContainer_159.setBorders(false);
		  
		//세액공제_외국인해저광물개발감면 신청일자
		LayoutContainer layoutContainer_160 = new LayoutContainer();

		FormLayout frmlytSch68 = new FormLayout();
		frmlytSch68.setLabelWidth(100);
		frmlytSch68.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_160.setLayout(frmlytSch68);

		txlgFrid = new MSFDateField();
		txlgFrid.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txlgFrid.setName("txlgFrid");
	    new DateFieldMask(txlgFrid, "9999.99.99");
		layoutContainer_160.add(txlgFrid, new FormData("100%"));
		txlgFrid.setFieldLabel("신청일자");
		layoutContainer_154.add(layoutContainer_160);
		layoutContainer_160.setBorders(false);
		  
		//세액공제_근로소득조세조약상면제 제출일자
		LayoutContainer layoutContainer_162 = new LayoutContainer();

		FormLayout frmlytSch69 = new FormLayout();
		frmlytSch69.setLabelWidth(100);
		frmlytSch69.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_162.setLayout(frmlytSch69);

		txlgTxtd = new MSFDateField();
		txlgTxtd.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txlgTxtd.setName("txlgTxtd");
	    new DateFieldMask(txlgTxtd, "9999.99.99");
		layoutContainer_162.add(txlgTxtd, new FormData("100%"));
		txlgTxtd.setFieldLabel("제출일자");
		layoutContainer_154.add(layoutContainer_162);
		layoutContainer_162.setBorders(false);
		  
		// 세액감면
		layoutContainer_151.add(layoutContainer_154, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_154.setBorders(false);

		fldstNewFieldset_8.add(layoutContainer_151);
		layoutContainer_151.setBorders(false);
		layoutContainer_147.add(fldstNewFieldset_8);

		layoutContainer_16.add(layoutContainer_147);
		layoutContainer_147.setBorders(false);

		//
		LayoutContainer layoutContainer_148 = new LayoutContainer();
		layoutContainer_148.setLayout(new ColumnLayout());
		  
		  
		// 중소기업 취업 청년가면 취업일자
		LayoutContainer layoutContainer_163 = new LayoutContainer();

		FormLayout frmlytSch70 = new FormLayout();
		frmlytSch70.setLabelWidth(230);
		frmlytSch70.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_163.setLayout(frmlytSch70);

		txlgBscd = new MSFDateField();
		txlgBscd.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txlgBscd.setName("txlgBscd");
	    new DateFieldMask(txlgBscd, "9999.99.99");
		layoutContainer_163.add(txlgBscd, new FormData("100%"));
		txlgBscd.setFieldLabel("중소기업 취업 청년감면 취업일자 ");
		layoutContainer_148.add(layoutContainer_163, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_163.setBorders(false);

		//세액공제_중소기업청년감면 감면기간 종료일
		LayoutContainer layoutContainer_164 = new LayoutContainer();

		FormLayout frmlytSch71 = new FormLayout();
		frmlytSch71.setLabelWidth(100);
		frmlytSch71.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_164.setLayout(frmlytSch71);

		txlgBcde = new MSFDateField();
		txlgBcde.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txlgBcde.setName("txlgBcde");
	    new DateFieldMask(txlgBcde, "9999.99.99");
		layoutContainer_164.add(txlgBcde, new FormData("100%"));
		txlgBcde.setFieldLabel("감면기간 종료일");
		layoutContainer_148.add(layoutContainer_164, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_164.setBorders(false);
		  
		  
		layoutContainer_16.add(layoutContainer_148, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		  
		// 세액감면
		LayoutContainer layoutContainer_149 = new LayoutContainer();

		FieldSet fldstNewFieldset_9 = new FieldSet();

		LayoutContainer layoutContainer_166 = new LayoutContainer();
		layoutContainer_166.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_165 = new LayoutContainer();
		layoutContainer_165.setBorders(false);
		  
		// 소득세법 감면세액
		LayoutContainer layoutContainer_168 = new LayoutContainer();

		FormLayout frmlytSch100 = new FormLayout();
		frmlytSch100.setLabelWidth(150);
		frmlytSch100.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_168.setLayout(frmlytSch100);

		txlgItct = new MSFNumberField();
		
		txlgItct.setAllowDecimals(true); 
		txlgItct.setPropertyEditorType(Long.class); 
		txlgItct.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_168.add(txlgItct, new FormData("100%"));
		txlgItct.setFieldLabel("소득세법 감면세액");
		layoutContainer_165.add(layoutContainer_168);
		layoutContainer_168.setBorders(false);

		// 취업청년감면대상총급여
		LayoutContainer layoutContainer_169 = new LayoutContainer();

		FormLayout frmlytSch101 = new FormLayout();
		frmlytSch101.setLabelWidth(150);
		frmlytSch101.setLabelAlign(LabelAlign.RIGHT);
		  
		layoutContainer_169.setLayout(frmlytSch101);

		txlgBsta = new MSFNumberField();
		
		txlgBsta.setAllowDecimals(true); 
		txlgBsta.setPropertyEditorType(Long.class); 
		txlgBsta.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_169.add(txlgBsta, new FormData("100%"));
		txlgBsta.setFieldLabel("취업청년감면대상총급여");
		layoutContainer_165.add(layoutContainer_169);
		layoutContainer_169.setBorders(false);

		// 계산 감면세액
		LayoutContainer layoutContainer_170 = new LayoutContainer();

		FormLayout frmlytSch102 = new FormLayout();
		frmlytSch102.setLabelWidth(150);
		frmlytSch102.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_170.setLayout(frmlytSch102);

		txlgClta = new MSFNumberField();
		txlgClta.setReadOnly(true);
		
		txlgClta.setAllowDecimals(true); 
		txlgClta.setPropertyEditorType(Long.class); 
		txlgClta.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_170.add(txlgClta, new FormData("100%"));
		txlgClta.setFieldLabel("계산 감면세액");
		layoutContainer_165.add(layoutContainer_170);
		layoutContainer_170.setBorders(false);

		// 외국인기술자 감면세액
		LayoutContainer layoutContainer_171 = new LayoutContainer();

		FormLayout frmlytSch103 = new FormLayout();
		frmlytSch103.setLabelWidth(150);
		frmlytSch103.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_171.setLayout(frmlytSch103);

		txlgFrta = new MSFNumberField();
		
		txlgFrta.setAllowDecimals(true); 
		txlgFrta.setPropertyEditorType(Long.class); 
		txlgFrta.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_171.add(txlgFrta, new FormData("100%"));
		txlgFrta.setFieldLabel("외국인기술자 감면세액");
		layoutContainer_165.add(layoutContainer_171);
		layoutContainer_171.setBorders(false);

		// 조세조약 감면세액
		LayoutContainer layoutContainer_172 = new LayoutContainer();

		FormLayout frmlytSch104 = new FormLayout();
		frmlytSch104.setLabelWidth(150);
		frmlytSch104.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_172.setLayout(frmlytSch104);

		txlgTxty = new MSFNumberField();
		
		txlgTxty.setAllowDecimals(true); 
		txlgTxty.setPropertyEditorType(Long.class); 
		txlgTxty.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_172.add(txlgTxty, new FormData("100%"));
		txlgTxty.setFieldLabel("조세조약 감면세액");
		layoutContainer_165.add(layoutContainer_172);
		layoutContainer_172.setBorders(false);
		  
		  
		layoutContainer_166.add(layoutContainer_165, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		  
		  
		LayoutContainer layoutContainer_167 = new LayoutContainer();

		// 감면세액 세액감면_소득세법
		LayoutContainer layoutContainer_173 = new LayoutContainer();
		  
		FormLayout frmlytSch105 = new FormLayout();
		frmlytSch105.setLabelWidth(80);
		frmlytSch105.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_173.setLayout(frmlytSch105);

		taxdIcax = new MSFNumberField();
		
		taxdIcax.setAllowDecimals(true); 
		taxdIcax.setPropertyEditorType(Long.class); 
		taxdIcax.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_173.add(taxdIcax, new FormData("100%"));
		taxdIcax.setFieldLabel("감면세액");
		layoutContainer_167.add(layoutContainer_173);
		layoutContainer_173.setBorders(false);

		// 근로자총급여 세액공제_근로소득세액공제
		LayoutContainer layoutContainer_174 = new LayoutContainer();

		FormLayout frmlytSch106 = new FormLayout();
		frmlytSch106.setLabelWidth(80);
		frmlytSch106.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_174.setLayout(frmlytSch106);

		txlgWkta = new  MSFNumberField();
		txlgWkta.setReadOnly(true);
		
		txlgWkta.setAllowDecimals(true); 
		txlgWkta.setPropertyEditorType(Long.class); 
		txlgWkta.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_174.add(txlgWkta, new FormData("100%"));
		txlgWkta.setFieldLabel("근로자총급여");
		layoutContainer_167.add(layoutContainer_174);
		layoutContainer_174.setBorders(false);

		// 감면세액 세액감면_감면세액계
		LayoutContainer layoutContainer_175 = new LayoutContainer();

		FormLayout frmlytSch107 = new FormLayout();
		frmlytSch107.setLabelWidth(80);
		frmlytSch107.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_175.setLayout(frmlytSch107);

		taxdTsum = new MSFNumberField();
		taxdTsum.setReadOnly(true);
		
		taxdTsum.setAllowDecimals(true); 
		taxdTsum.setPropertyEditorType(Long.class); 
		taxdTsum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_175.add(taxdTsum, new FormData("100%"));
		taxdTsum.setFieldLabel("감면세액");
		layoutContainer_167.add(layoutContainer_175);
		layoutContainer_175.setBorders(false);

		// 감면세액 세액공제_외국인감면세액
		LayoutContainer layoutContainer_176 = new LayoutContainer();

		FormLayout frmlytSch108 = new FormLayout();
		frmlytSch108.setLabelWidth(80);
		frmlytSch108.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_176.setLayout(frmlytSch108);

		taxdRedu = new MSFNumberField();
		taxdRedu.setReadOnly(true);
		
		taxdRedu.setAllowDecimals(true); 
		taxdRedu.setPropertyEditorType(Long.class); 
		taxdRedu.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_176.add(taxdRedu, new FormData("100%"));
		taxdRedu.setFieldLabel("감면세액");
		layoutContainer_167.add(layoutContainer_176);
		layoutContainer_176.setBorders(false);

		// 감면세액 세액감면_조세조약
		LayoutContainer layoutContainer_177 = new LayoutContainer();

		FormLayout frmlytSch109 = new FormLayout();
		frmlytSch109.setLabelWidth(80);
		frmlytSch109.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_177.setLayout(frmlytSch109);

		txlgHxtt = new MSFNumberField();
		txlgHxtt.setReadOnly(true);
		
		txlgHxtt.setAllowDecimals(true); 
		txlgHxtt.setPropertyEditorType(Long.class); 
		txlgHxtt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_177.add(txlgHxtt, new FormData("100%"));
		txlgHxtt.setFieldLabel("감면세액");
		layoutContainer_167.add(layoutContainer_177);
		layoutContainer_177.setBorders(false);
		  
		layoutContainer_167.setBorders(false);
		layoutContainer_166.add(layoutContainer_167, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		  
		  
		fldstNewFieldset_9.add(layoutContainer_166);

		layoutContainer_149.add(fldstNewFieldset_9);
		fldstNewFieldset_9.setHeadingHtml("세액감면");
		layoutContainer_16.add(layoutContainer_149);
		layoutContainer_149.setBorders(false);

		// 외국납부세액공제
		LayoutContainer layoutContainer_150 = new LayoutContainer();

		FieldSet fldstNewFieldset_10 = new FieldSet();

		LayoutContainer layoutContainer_268 = new LayoutContainer();

		LayoutContainer layoutContainer_272 = new LayoutContainer();
		layoutContainer_272.setLayout(new ColumnLayout());
		layoutContainer_272.setBorders(false);

		// 국외원천소득
		LayoutContainer layoutContainer_276 = new LayoutContainer();
		layoutContainer_276.setBorders(false);

		FormLayout frmlytSch120 = new FormLayout();
		frmlytSch120.setLabelWidth(80);
		frmlytSch120.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_276.setLayout(frmlytSch120);

		txlgInam= new MSFNumberField();
		
		txlgInam.setAllowDecimals(true); 
		txlgInam.setPropertyEditorType(Long.class); 
		txlgInam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_276.add(txlgInam, new FormData("90%"));
		txlgInam.setFieldLabel("국외원천소득");
		layoutContainer_272.add(layoutContainer_276, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  
		  
		//납세액(외화)
		LayoutContainer layoutContainer_280 = new LayoutContainer();

		FormLayout frmlytSch121 = new FormLayout();
		frmlytSch121.setLabelWidth(80);
		frmlytSch121.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_280.setLayout(frmlytSch121);

		txlgDlam = new MSFNumberField();
		
		txlgDlam.setAllowDecimals(true); 
		txlgDlam.setPropertyEditorType(Long.class); 
		txlgDlam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_280.add(txlgDlam, new FormData("90%"));
		txlgDlam.setFieldLabel("납세액(외화)");
		layoutContainer_272.add(layoutContainer_280,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_280.setBorders(false);

		layoutContainer_268.add(layoutContainer_272);
		fldstNewFieldset_10.add(layoutContainer_268);
		layoutContainer_268.setBorders(false);

		LayoutContainer layoutContainer_264 = new LayoutContainer();
		layoutContainer_264.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_265 = new LayoutContainer();

		// 납세액(원화)
		LayoutContainer layoutContainer_269 = new LayoutContainer();

		FormLayout frmlytSch122 = new FormLayout();
		frmlytSch122.setLabelWidth(80);
		frmlytSch122.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_269.setLayout(frmlytSch122);

		txlgWnam = new MSFNumberField();
		
		txlgWnam.setAllowDecimals(true); 
		txlgWnam.setPropertyEditorType(Long.class); 
		txlgWnam.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_269.add(txlgWnam, new FormData("100%"));
		txlgWnam.setFieldLabel("납세액(원화)");
		layoutContainer_265.add(layoutContainer_269);
		layoutContainer_269.setBorders(false);
		  
		// 신청서제출일
		LayoutContainer layoutContainer_270 = new LayoutContainer();

		FormLayout frmlytSch123 = new FormLayout();
		frmlytSch123.setLabelWidth(80);
		frmlytSch123.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_270.setLayout(frmlytSch123);

		txlgApdt = new MSFDateField();
		txlgApdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txlgApdt.setName("txlgApdt");
	    new DateFieldMask(txlgApdt, "9999.99.99");
		layoutContainer_270.add(txlgApdt, new FormData("100%"));
		txlgApdt.setFieldLabel("신청서제출일");
		layoutContainer_265.add(layoutContainer_270);
		layoutContainer_270.setBorders(false);
		  
		//세액공제_외국납부_근무시작일자
		LayoutContainer layoutContainer_271 = new LayoutContainer();

		FormLayout frmlytSch124 = new FormLayout();
		frmlytSch124.setLabelWidth(80);
		frmlytSch124.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_271.setLayout(frmlytSch124);

		txapStdt = new MSFDateField();
		txapStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txapStdt.setName("txapStdt");
	    new DateFieldMask(txapStdt, "9999.99.99");
		layoutContainer_271.add(txapStdt, new FormData("100%"));
		txapStdt.setFieldLabel("근무기간");
		layoutContainer_265.add(layoutContainer_271);
		layoutContainer_271.setBorders(false);
		  
		layoutContainer_264.add(layoutContainer_265, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_265.setBorders(false);
		  
		LayoutContainer layoutContainer_266 = new LayoutContainer();

		// 납세국명
		LayoutContainer layoutContainer_273 = new LayoutContainer();

		FormLayout frmlytSch125 = new FormLayout();
		frmlytSch125.setLabelWidth(80);
		frmlytSch125.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_273.setLayout(frmlytSch125);

		txlgOtcy = new MSFTextField();
		layoutContainer_273.add(txlgOtcy, new FormData("100%"));
		txlgOtcy.setFieldLabel("납세국명");
		layoutContainer_266.add(layoutContainer_273);
		layoutContainer_273.setBorders(false);

		// 국외근무처
		LayoutContainer layoutContainer_274 = new LayoutContainer();

		FormLayout frmlytSch126 = new FormLayout();
		frmlytSch126.setLabelWidth(80);
		frmlytSch126.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_274.setLayout(frmlytSch126);
		  
		txlgOuwk = new MSFTextField();
		layoutContainer_274.add(txlgOuwk, new FormData("100%"));
		txlgOuwk.setFieldLabel("국외근무처");
		layoutContainer_266.add(layoutContainer_274);
		layoutContainer_274.setBorders(false);

		LayoutContainer layoutContainer_275 = new LayoutContainer();

		FormLayout frmlytSch127 = new FormLayout();
		frmlytSch127.setLabelWidth(10);
		frmlytSch127.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_275.setLayout(frmlytSch127);

		//세액공제_외국납부_근무종료일자
		txapEddt = new MSFDateField();
		txapEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		txapEddt.setName("txapEddt");
	    new DateFieldMask(txapEddt, "9999.99.99");
		txapEddt.setLabelSeparator("~");
		layoutContainer_275.add(txapEddt, new FormData("80%"));
		layoutContainer_266.add(layoutContainer_275);
		layoutContainer_275.setBorders(false);
		  
		  
		layoutContainer_264.add(layoutContainer_266, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_266.setBorders(false);
		  
		LayoutContainer layoutContainer_267 = new LayoutContainer();
		  
		  
		// 납부일
		LayoutContainer layoutContainer_277 = new LayoutContainer();

		FormLayout frmlytSch128 = new FormLayout();
		frmlytSch128.setLabelWidth(80);
		frmlytSch128.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_277.setLayout(frmlytSch128);

		txlgOtdt = new MSFDateField();
		layoutContainer_277.add(txlgOtdt, new FormData("100%"));
		txlgOtdt.setFieldLabel("납부일");
		layoutContainer_267.add(layoutContainer_277);
		layoutContainer_277.setBorders(false);

		// 직책
		LayoutContainer layoutContainer_278 = new LayoutContainer();

		FormLayout frmlytSch129 = new FormLayout();
		frmlytSch129.setLabelWidth(80);
		frmlytSch129.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_278.setLayout(frmlytSch129);

		txapWkdy = new MSFTextField();
		layoutContainer_278.add(txapWkdy, new FormData("100%"));
		txapWkdy.setFieldLabel("직책");
		layoutContainer_267.add(layoutContainer_278);
		layoutContainer_278.setBorders(false);

		LayoutContainer layoutContainer_279 = new LayoutContainer();
		layoutContainer_267.add(layoutContainer_279);
		layoutContainer_279.setBorders(false);
		  
		  
		layoutContainer_264.add(layoutContainer_267, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_267.setBorders(false);
		  
		  
		layoutContainer_268.add(layoutContainer_264);
		layoutContainer_150.add(fldstNewFieldset_10);
		fldstNewFieldset_10.setHeadingHtml("외국납부세액공제");
		layoutContainer_16.add(layoutContainer_150);
		layoutContainer_150.setBorders(false);

		//
		LayoutContainer layoutContainer_17 = new LayoutContainer();
		layoutContainer_17.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_258 = new LayoutContainer();

		// 납세조합원청징수세액(10%)
		LayoutContainer layoutContainer_260 = new LayoutContainer();

		FormLayout frmlytSch110 = new FormLayout();
		frmlytSch110.setLabelWidth(270);
		frmlytSch110.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_260.setLayout(frmlytSch110);

		taxdUnin = new MSFNumberField();
		
		taxdUnin.setAllowDecimals(true); 
		taxdUnin.setPropertyEditorType(Long.class); 
		taxdUnin.setFormat(NumberFormat.getDecimalFormat());
		
		
		layoutContainer_260.add(taxdUnin, new FormData("100%"));
		taxdUnin.setFieldLabel("납세조합원청징수세액(10%)");
		layoutContainer_258.add(layoutContainer_260);
		layoutContainer_260.setBorders(false);

		// 주택자금차입금이자세액공제 이자상환/공제액
		LayoutContainer layoutContainer_261 = new LayoutContainer();

		FormLayout frmlytSch111 = new FormLayout();
		frmlytSch111.setLabelWidth(270);
		frmlytSch111.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_261.setLayout(frmlytSch111);

		taxdLoaa = new MSFNumberField();
		
		taxdLoaa.setAllowDecimals(true); 
		taxdLoaa.setPropertyEditorType(Long.class); 
		taxdLoaa.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_261.add(taxdLoaa, new FormData("100%"));
		taxdLoaa.setFieldLabel("주택자금차입금이자세액공제 이자상환/공제액");
		layoutContainer_258.add(layoutContainer_261);
		layoutContainer_261.setBorders(false);
		  
		  
		layoutContainer_17.add(layoutContainer_258, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_258.setBorders(false);
		  
		LayoutContainer layoutContainer_259 = new LayoutContainer();

		// 납세조합공제액
		LayoutContainer layoutContainer_262 = new LayoutContainer();

		FormLayout frmlytSch112 = new FormLayout();
		frmlytSch112.setLabelWidth(100);
		frmlytSch112.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_262.setLayout(frmlytSch112);

		taxdUnin01 = new  MSFNumberField();
		taxdUnin01.setReadOnly(true);

		
		taxdUnin01.setAllowDecimals(true); 
		taxdUnin01.setPropertyEditorType(Long.class); 
		taxdUnin01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_262.add(taxdUnin01, new FormData("100%"));
		taxdUnin01.setFieldLabel("납세조합공제액");
		layoutContainer_259.add(layoutContainer_262);
		layoutContainer_262.setBorders(false);

		LayoutContainer layoutContainer_263 = new LayoutContainer();

		//세액공제_주택차입금 공제액
		taxdLoan = new  MSFNumberField();
		taxdLoan.setReadOnly(true);
		
		taxdLoan.setAllowDecimals(true); 
		taxdLoan.setPropertyEditorType(Long.class); 
		taxdLoan.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_263.add(taxdLoan);
		layoutContainer_259.add(layoutContainer_263);
		layoutContainer_263.setBorders(false);
		  
		layoutContainer_17.add(layoutContainer_259, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_259.setBorders(false); 
		  
		  //layoutContainer_17.add(fldstNewFieldset_12);
		// fldstNewFieldset_12.setHeadingHtml("");
		layoutContainer_16.add(layoutContainer_17);

		cp01.add(layoutContainer_16);
		layoutContainer_16.setHeight("450");
//		layoutContainer_16.setHeight("515");
		cp01.add(cp01);
		cp01.setHeight("445");
//		cp01.setSize("660", "520");
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}	
	
	private LayoutContainer yetaData10() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "450");

		LayoutContainer layoutContainer_178 = new LayoutContainer();

		LayoutContainer layoutContainer_179 = new LayoutContainer();

		FieldSet fldstNewFieldset_13 = new FieldSet();

		LayoutContainer layoutContainer_182 = new LayoutContainer();

		// 1. 외국인근로자..
		LayoutContainer layoutContainer_193 = new LayoutContainer();
		layoutContainer_193.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_26 = new LabelField("1.외국인근로자 단일세율적용신청서 제출여부");
		layoutContainer_193.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_193.add(lblfldNewLabelfield_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		frnrSgyn = new RadioGroup();
		frnrSgyn.setFieldLabel("1.외국인근로자 단일세율적용신청서 제출여부");
		frnrSgyn.setHideLabel(false);
		
		Radio fornrSgyn0 = new Radio();
//		layoutContainer_193.add(rdNewRadio_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		frnrSgyn.add(fornrSgyn0);
		fornrSgyn0.setBoxLabel("미제출");
		fornrSgyn0.setHideLabel(true);
		fornrSgyn0.setValueAttribute("0");


		Radio fornrSgyn1 = new Radio();
		frnrSgyn.add(fornrSgyn1);
//		layoutContainer_193.add(rdNewRadio_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		fornrSgyn1.setBoxLabel("제출");
		fornrSgyn1.setHideLabel(true);
		fornrSgyn1.setValueAttribute("1");
		
		layoutContainer_193.add(frnrSgyn);
		layoutContainer_182.add(layoutContainer_193);
		layoutContainer_193.setBorders(false);

		// 2.연금,저축 등 소득공제 명세서 제출여부
		LayoutContainer layoutContainer_194 = new LayoutContainer();
		layoutContainer_194.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_27 = new LabelField("2.연금,저축 등 소득공제 명세서 제출여부");
		layoutContainer_194.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_194.add(lblfldNewLabelfield_27, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		addcNtyn = new RadioGroup();
		
		Radio addcNtyn0 = new Radio();
//		layoutContainer_194.add(rdNewRadio_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		addcNtyn.add(addcNtyn0);
		addcNtyn0.setBoxLabel("미제출");
		addcNtyn0.setHideLabel(true);
		addcNtyn0.setValueAttribute("0");


		Radio addcNtyn1 = new Radio();
//		layoutContainer_194.add(rdNewRadio_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		addcNtyn.add(addcNtyn1);
		addcNtyn1.setBoxLabel("제출");
		addcNtyn1.setHideLabel(true);
		addcNtyn1.setValueAttribute("1");

		
//		layoutContainer_194.add(addcNtyn);

		layoutContainer_182.add(layoutContainer_194);
		layoutContainer_194.add(addcNtyn);
		layoutContainer_194.setBorders(false);

		// * 퇴직연금..
		LayoutContainer layoutContainer_195 = new LayoutContainer();

		LabelField lblfldNewLabelfield_28 = new LabelField("* 퇴직연금, 연금저축, 주택마련저축, 장기주식형저축 등 소득공제를 신청하는 경우");
		layoutContainer_195.add(lblfldNewLabelfield_28);
		layoutContainer_182.add(layoutContainer_195);
		layoutContainer_195.setBorders(false);

		LayoutContainer layoutContainer_196 = new LayoutContainer();
		layoutContainer_196.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_32 = new LabelField("");
		layoutContainer_196.add(lblfldNewLabelfield_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.02));

		LabelField lblfldNewLabelfield_29 = new LabelField("해당 명세서를 제출하여야 합니다.");
		layoutContainer_196.add(lblfldNewLabelfield_29, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.98));
		layoutContainer_182.add(layoutContainer_196);
		layoutContainer_196.setBorders(false);

		// 3. 월세액/비거주자간..
		LayoutContainer layoutContainer_197 = new LayoutContainer();
		layoutContainer_197.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_30 = new LabelField("3.월세액/비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부");
		layoutContainer_197.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_197.add(lblfldNewLabelfield_30);

		//
		LayoutContainer layoutContainer_198 = new LayoutContainer();
		layoutContainer_198.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_31 = new LabelField("");
		layoutContainer_198.add(lblfldNewLabelfield_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		spciReyn = new RadioGroup();
		
		Radio spciReyn0 = new Radio();
//		layoutContainer_198.add(rdNewRadio_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		spciReyn.add(spciReyn0);
		spciReyn0.setBoxLabel("미제출");
		spciReyn0.setHideLabel(true);
		spciReyn0.setValueAttribute("0");


		Radio spciReyn1 = new Radio();
//		layoutContainer_198.add(rdNewRadio_19, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		spciReyn.add(spciReyn1);
		spciReyn1.setBoxLabel("제출");
		spciReyn1.setHideLabel(true);
		spciReyn1.setValueAttribute("1");
		
		layoutContainer_198.add(spciReyn);

		layoutContainer_182.add(layoutContainer_197);
		layoutContainer_197.setBorders(false);
		layoutContainer_182.add(layoutContainer_198);
		
		layoutContainer_197.setBorders(false);

		fldstNewFieldset_13.add(layoutContainer_182);
		layoutContainer_182.setBorders(false);
		layoutContainer_179.add(fldstNewFieldset_13);
		fldstNewFieldset_13.setHeadingHtml("");
		layoutContainer_178.add(layoutContainer_179);
		layoutContainer_179.setBorders(false);

//		LayoutContainer layoutContainer_180 = new LayoutContainer();

		FieldSet fldstNewFieldset_11 = new FieldSet();
		fldstNewFieldset_11.setHeadingHtml("그 밖의 추가 제출서류");

		LayoutContainer layoutContainer_188 = new LayoutContainer();
		layoutContainer_188.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_189 = new LayoutContainer();

		// ① 의료비지급명세서
		LayoutContainer layoutContainer_191 = new LayoutContainer();
		layoutContainer_191.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_23 = new LabelField("① 의료비지급명세서     : ");
		layoutContainer_191.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_191.add(lblfldNewLabelfield_23);
		
		addcMdyn = new RadioGroup();

		Radio addcMnN = new Radio();
//		layoutContainer_191.add(rdNewRadio_8);
		addcMdyn.add(addcMnN);
		addcMnN.setBoxLabel("미제출");
		addcMnN.setHideLabel(true);
		addcMnN.setValueAttribute("0");

		Radio addcMnY = new Radio();
		addcMdyn.add(addcMnY);
//		layoutContainer_191.add(rdNewRadio_9);
		addcMnY.setBoxLabel("제출");
		addcMnY.setHideLabel(true);
		addcMnY.setValueAttribute("1");
		
		layoutContainer_191.add(addcMdyn);

//		layoutContainer_189.add(addcMdyn);
		layoutContainer_189.add(layoutContainer_191);
		layoutContainer_191.setBorders(false);

		// ③ 소득공제 증빙서류
		LayoutContainer layoutContainer_192 = new LayoutContainer();
		layoutContainer_192.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_24 = new LabelField("③ 소득공제 증빙서류     : ");
		layoutContainer_192.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_192.add(lblfldNewLabelfield_24);
		
		addcPfyn = new RadioGroup();

		Radio addcPfyn0 = new Radio();
		addcPfyn.add(addcPfyn0);
		addcPfyn0.setBoxLabel("미제출");
		addcPfyn0.setHideLabel(true);
		addcPfyn0.setValueAttribute("0");

		Radio addcPfyn1 = new Radio();
		addcPfyn.add(addcPfyn1);
		addcPfyn1.setBoxLabel("제출");
		addcPfyn1.setHideLabel(true);
		addcPfyn1.setValueAttribute("1");
		
		layoutContainer_192.setBorders(false);
		layoutContainer_192.add(addcPfyn);
		

		layoutContainer_189.add(layoutContainer_192);
		layoutContainer_189.setBorders(false);
		
		layoutContainer_188.add(layoutContainer_189, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		
		// ② 기부금명세서
		LayoutContainer layoutContainer_190 = new LayoutContainer();
		layoutContainer_190.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_25 = new LabelField("② 기부금명세서     : ");
		layoutContainer_190.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_190.add(lblfldNewLabelfield_25);
		
		addcCtyn = new RadioGroup();

		Radio addcCtN = new Radio();
		addcCtyn.add(addcCtN);
		addcCtN.setBoxLabel("미제출");
		addcCtN.setHideLabel(true);
		addcCtN.setValueAttribute("0");

		Radio addcCtY = new Radio();
		addcCtyn.add(addcCtY);
		addcCtY.setBoxLabel("제출");
		addcCtY.setHideLabel(true);
		addcCtY.setValueAttribute("1");
		layoutContainer_190.add(addcCtyn);
		
		layoutContainer_188.add(layoutContainer_190, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer_190.setBorders(false);

		fldstNewFieldset_11.add(layoutContainer_188);
		layoutContainer_188.setBorders(false);
		
		
		
//		layoutContainer_180.add(fldstNewFieldset_11);
//		layoutContainer_178.add(layoutContainer_180);
		
		layoutContainer_178.add(fldstNewFieldset_11);

		LayoutContainer layoutContainer_181 = new LayoutContainer();

		// 소득공제신고서
		FieldSet fldstNewFieldset_12 = new FieldSet();
		layoutContainer_181.add(fldstNewFieldset_12);
		fldstNewFieldset_12.setHeadingHtml("소득공제신고서");
		fldstNewFieldset_12.setCollapsible(false);

		LayoutContainer layoutContainer_183 = new LayoutContainer();
		layoutContainer_183.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_184 = new LayoutContainer();

		// 소득공제신고서제출여부
		LayoutContainer layoutContainer_186 = new LayoutContainer();
		layoutContainer_186.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_22 = new LabelField("소득공제신고서제출여부     : ");
		layoutContainer_186.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_186.add(lblfldNewLabelfield_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		incoOufg = new RadioGroup();
		
		Radio incoOufgN = new Radio();
//		layoutContainer_186.add(rdNewRadio_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		incoOufg.add(incoOufgN);
		incoOufgN.setBoxLabel("미제출");
		incoOufgN.setHideLabel(true);
		incoOufgN.setValueAttribute("0");
		
		Radio incoOufgY = new Radio();
		incoOufg.add(incoOufgY); 
		incoOufgY.setBoxLabel("제출");
		incoOufgY.setHideLabel(true);
		incoOufgY.setValueAttribute("1");
		
		layoutContainer_186.add(incoOufg, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		layoutContainer_184.add(layoutContainer_186, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//		layoutContainer_184.add(incoOufg);

		// 제출일자
		LayoutContainer layoutContainer_187 = new LayoutContainer();

		FormLayout frmlytSch72 = new FormLayout();
		frmlytSch72.setLabelWidth(130);
		frmlytSch72.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_187.setLayout(frmlytSch72);

		incoOudt = new MSFDateField();
		new DateFieldMask(incoOudt, "9999.99.99");
		incoOudt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		incoOudt.setFieldLabel("제출일자");
		layoutContainer_187.add(incoOudt, new FormData("100%"));
		
		layoutContainer_184.add(layoutContainer_187);
		layoutContainer_183.add(layoutContainer_184, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_185 = new LayoutContainer();
		layoutContainer_183.add(layoutContainer_185, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fldstNewFieldset_12.add(layoutContainer_183);
		layoutContainer_178.add(layoutContainer_181);
		layoutContainer_178.setBorders(false);
	
		cp01.add(layoutContainer_178);
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}
	
	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}
	
	private Yeta1300 getThis(){
	       return this;
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	//성명
	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사

		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) {
					srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); // 시스템키
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum"))); // 주민번호
				}
			}
		});
	}
	
	//국적
	private void fnPopupBass0300(final String itemValue, final String fnFalg) {
		MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통  
	       
		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
	      
		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("commCd"))) { 
					if ("A001".equals(itemValue)) {
						
						if("natn".equals(fnFalg)) {
							//국적
							natnGbcd.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCd")));		//국가코드(Hidden)
							natnName.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));		//국가명
		                	natnItem.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeItem12")));	//국가코드Item
						}else if("redt".equals(fnFalg)) {
							//거주지국
						    redtGbcd.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCd")));		//거주지국코드
						    redtName.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));		//거주지국명
						    redtItem.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeItem12")));	//거주지국 두자리
						}
					}   
				}
			}
		});
	}
	
	//가족사항
	private void fnPopupCommP160(String yetaFlag) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
//		
		
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		
		if("Yeta3220".equals(yetaFlag)) {
			PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
			sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
			sysComPsnl0115Dto.setSystemkey(systemkey.getValue());//systemKey 넘김.
		      
			MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto);  //인사  
		      
			final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
		      
			popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
		               
					if (mapModels != null) { 
						actionDatabase = ActionDatabase.INSERT;
						
						Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
						List<Ye16Ta3220DTO> listYeta3220dto = new ArrayList<Ye16Ta3220DTO>();  
						
						while (iterRecords.hasNext()) {
							BaseModel bmMapModel = (BaseModel) iterRecords.next();
							//건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
							Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
	                        
	                        
	                        yeta3220Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    		/** column 사업장코드 : dpobCd */
	                        yeta3220Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** column SYSTEMKEY : systemkey */
	                        
//	                        yeta3220Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
//	                        yeta3220Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
	                       
	                        yeta3220Dto.setEdacRvyy(edacRvyy.getValue());    /** column 연말정산귀속년도 : edacRvyy */
	                        yeta3220Dto.setSettGbcd(settGbcd.getValue());    /** column 정산구분코드 : settGbcd */
	                        
	                        yeta3220Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum"))); 	/** column 주민등록번호 : rsnoNumb */
	                        yeta3220Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));	/** column 관계 : famyRelaDivCd */
	                        yeta3220Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("famyNm")));    		/** column 성명 : famyNm */
	                        
	                        
	                        
	                        /** column 내외국인구분코드 : frnrCode */
	                        if(Boolean.TRUE.equals(bmMapModel.get("frgnrYn"))) {
	                        	yeta3220Dto.setFrnrCode("1");
	                        }else {
	                        	yeta3220Dto.setFrnrCode("0");
	                        }
	                        
	                        
	                        yeta3220Dto.setBaseDdyn(true);	/** column 기본공제여부 : baseDdyn */
	                        yeta3220Dto.setPsclDdyn(MSFSharedUtils.allowNulls(bmMapModel.get("psclDdyn")));	/** column 장애인공제여부 : psclDdyn */
	                        yeta3220Dto.setBrddCtyn(false); /** column 자녀양육비공제여부 : brddCtyn */
	                        yeta3220Dto.setFaddCtyn(false); /** column 부녀자공제여부 : faddCtyn */
	                        yeta3220Dto.setRpctDdyn(false); /** column 경로우대공제여부 : rpctDdyn */
	                        yeta3220Dto.setBithDdyn(false); /** column 출산입양자공제여부 : bithDdyn */
	                        yeta3220Dto.setPantOnyn(false); /** column 한부모공제여부 : pantOnyn */
	                        
	                        listYeta3220dto.add(yeta3220Dto);
						}    
		                 
						yeta1300Service.activityOnYeta1300ToYeta3220(listYeta3220dto, actionDatabase, new AsyncCallback<Long>() {
		                         
							public void onFailure(Throwable caught) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
									MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta1300ToYeta3220(" + actionDatabase.name() + ") : " + caught), null);
							}
							public void onSuccess(Long result) {  
								reloadYeta3220_item02Grid();
							}   
						});
					}  
				}
			});
		}else if("Yeta3150".equals(yetaFlag)) {
			PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
			sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
			sysComPsnl0115Dto.setSystemkey(systemkey.getValue());//systemKey 넘김.
		    
			MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto);  //인사  
		      
			final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
		      
			popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
					statCheck = false ; 
					if (mapModels != null) { 
						actionDatabase = ActionDatabase.INSERT;
						
						Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
						List<Ye16Ta3150DTO> listYeta3150dto = new ArrayList<Ye16Ta3150DTO>();  
						
						while (iterRecords.hasNext()) {
							BaseModel bmMapModel = (BaseModel) iterRecords.next();
							//건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
							Ye16Ta3150DTO yeta3150Dto = new Ye16Ta3150DTO();  
	                        
	                        
							yeta3150Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    		/** column 사업장코드 : dpobCd */
							yeta3150Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** column SYSTEMKEY : systemkey */
	                        
							yeta3150Dto.setEdacRvyy(edacRvyy.getValue());    /** column 연말정산귀속년도 : edacRvyy */
							yeta3150Dto.setSettGbcd(settGbcd.getValue());    /** column 정산구분코드 : settGbcd */
	                        
							if (MSFSharedUtils.paramNull(bmMapModel.get("famyResnRegnNum"))) {
								
								MessageBox.alert("", "선택하신 교육비 대상자의 주민번호가 존재하지 않습니다.", null);
								statCheck = true ;
								break; 
							}
							yeta3150Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum"))); 	/** column 주민등록번호 : rsnoNumb */
							
							
							yeta3150Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));	/** column 관계 : famyRelaDivCd */
							yeta3150Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("famyNm")));    		/** column 성명 : famyNm */
	                        
							
							yeta3150Dto.setFmacGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("fmacGbcd")));    		/** column 가족학력구분코드 : fmacGbcd */
							yeta3150Dto.setEdacOtam(bmMapModel.set("edacOtam", 0L)) ;	/** column 교육비지급금액 : edacOtam */
							
							
							
							listYeta3150dto.add(yeta3150Dto);
							
							
						}    
		                
						if (!statCheck) {
							yeta1300Service.saveYeta1300To2000tabItem08_3(listYeta3150dto, actionDatabase, new AsyncCallback<Long>() {
				    			 
								public void onFailure(Throwable caught) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
													MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta1300ToYeta3150(" + actionDatabase.name() + ") : " + caught), null);
								}
								public void onSuccess(Long result) {  
									reloadYeta3150Grid();
								
									actionDatabase = ActionDatabase.UPDATE;;  
								}	
							});
							
							statCheck = false ;
						}		
					}  
				}
			});
		}
		
		
		
		
		
		
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 저장 메소드 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	
	/** 기본사항 **/
	public void itemYeta01Save() {
		// TODO Auto-generated method stub
		yeta2000Dto = new  Ye16Ta2000DTO();
	 
		yeta2000Dto.setDpobCd(dpobCd.getValue());		/** column 사업장코드 : dpobCd */
		yeta2000Dto.setSystemkey(systemkey.getValue());	/** column SYSTEMKEY : systemkey */
		yeta2000Dto.setEdacRvyy(edacRvyy.getValue());/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Dto.setSettGbcd(settGbcd.getValue());/** column 정산구분코드 : settGbcd */ 
		//yeta2000Dto.setEdacRvyy(YetaUtils.getSelectedComboValue(srhEdacRvyy));/** column 연말정산귀속년도 : edacRvyy */
		//yeta2000Dto.setSettGbcd(YetaUtils.getSelectedComboValue(srhSettGbcd));/** column 정산구분코드 : settGbcd */
		
		
		yeta2000Dto.setGnanSgtf(YetaUtils.getCheckedRadioValue(gnanSgtf));	//세대주
		yeta2000Dto.setResdFlag(YetaUtils.getCheckedRadioValue(resdFlag));	//거주지구분
		yeta2000Dto.setNatnGbcd(natnGbcd.getValue());//국적코드
		yeta2000Dto.setNatnName(natnName.getValue());//국적명
		
		
		yeta2000Dto.setReymStdt(GWTUtils.getStringFromDate(reymStdt.getValue(), "yyyyMMdd"));//귀속년월시작일자
		yeta2000Dto.setReymEddt(GWTUtils.getStringFromDate(reymEddt.getValue(), "yyyyMMdd"));//귀속년월종료일자
		
		yeta2000Dto.setRutrStdt(GWTUtils.getStringFromDate(rutrStdt.getValue(), "yyyyMMdd"));//감면 시작 일자 
		yeta2000Dto.setRutrEddt(GWTUtils.getStringFromDate(rutrEddt.getValue(), "yyyyMMdd"));//감면 종료 일자
		
		yeta2000Dto.setRedtGbcd(redtGbcd.getValue());//거주지국코드
		yeta2000Dto.setRedtName(redtName.getValue());//거주지국명 
		
		 
		
		yeta2000Dto.setAlryPinx((Long) alryPinx.getValue());//기납부세액_소득세
		yeta2000Dto.setAlryPhbx((Long) alryPhbx.getValue());//기납부세액_주민세_지방소득세
		

		yeta2000Dto.setCurrTots((Long) currTots.getValue());//주현근무지 급여액 
		
		
		/*****************2016귀속추가 ***************************/
		yeta2000Dto.setYrenSgyn(yrenSgyn.getValue());      															/** column 연말정산분할납부신청여부 : yrenSgyn */
		yeta2000Dto.setAddIncmTxApptnRtoCd(MSFSharedUtils.getSelectedComboValue(addIncmTxApptnRtoCd, "commCd"));	/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
		yeta2000Dto.setFrnrRnyn(frnrRnyn.getValue());    															/** column 외국인법인소속파견근로자여부 : frnrRnyn */
		/*****************2016귀속추가 ***************************/	
		
		
		yeta1300Service.saveYeta1300To2000tabItem01(yeta2000Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta01Save(저장) : " + caught), null);
			}
			
			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//					yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					
					//reFresh("itemYeta01");
					reFresh();
					
				} 
			}
		});
	}
	
	/**인적공제 grid 저장 **/
	public void itemYeta02Save() {
		
		actionDatabase = ActionDatabase.UPDATE;
        // ---------- 소득공제 부분 추가 해야 함....부분.............부분.
		Iterator<Record> iterRecords = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
	           
		List<Ye16Ta3220DTO> listYeta3220dto = new ArrayList<Ye16Ta3220DTO>();  
		
		
//		int i = 0;  
//		int cnt = 0;
		
		while (iterRecords.hasNext()) {
			
//			i = cnt + 0;
			
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
	               
			Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
               
			yeta3220Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** column 사업장코드 : dpobCd */
	        yeta3220Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));		/** column SYSTEMKEY : systemkey */
	        yeta3220Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    		/** column 연말정산귀속년도 : edacRvyy */
	        yeta3220Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    		/** column 정산구분코드 : settGbcd */
	            
	        yeta3220Dto.setBeforeJumin(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb2")));
	            
	        yeta3220Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    		/** column 주민등록번호 : rsnoNumb */
	        yeta3220Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("relhCode")));    		/** column 관계 : relhCode */
	        yeta3220Dto.setFamySupptRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famySupptRelaDivCd$commCd")) );/** column 연말정산부양관계코드 : famySupptRelaDivCd */
	        yeta3220Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("kornName")));    		/** column 성명 : kornName */
	        yeta3220Dto.setFrnrCode(MSFSharedUtils.allowNulls(bmMapModel.get("frnrCode")));    		/** column 내외국인구분코드 : frnrCode */
	            
	        yeta3220Dto.setBaseDdyn((Boolean) bmMapModel.get("baseDdyn"));    						/** column 기본공제여부 : baseDdyn */
	        yeta3220Dto.setPsclDdyn(MSFSharedUtils.allowNulls(bmMapModel.get("psclDdyn$commCd")));	/** column 장애인공제여부 : psclDdyn */
	        yeta3220Dto.setBrddCtyn((Boolean) bmMapModel.get("brddCtyn"));    						/** column 자녀양육비공제여부 : brddCtyn */
	        yeta3220Dto.setFaddCtyn((Boolean) bmMapModel.get("faddCtyn"));    						/** column 부녀자공제여부 : faddCtyn */
	        yeta3220Dto.setRpctDdyn((Boolean) bmMapModel.get("rpctDdyn"));    						/** column 경로우대공제여부 : rpctDdyn */
	        yeta3220Dto.setBithDdyn((Boolean) bmMapModel.get("bithDdyn"));    						/** column 출산입양자공제여부 : bithDdyn */
	        yeta3220Dto.setPantOnyn((Boolean) bmMapModel.get("pantOnyn"));    						/** column 한부모공제여부 : pantOnyn */
                
	            
//	        i = cnt + 1;
	        listYeta3220dto.add(yeta3220Dto);
		}   
	       
		yeta1300Service.activityOnYeta1300ToYeta3220(listYeta3220dto, actionDatabase, new AsyncCallback<Long>() {
	    			 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta1300ToYeta3220(" + actionDatabase.name() + ") : " + caught), null);
			}
			public void onSuccess(Long result) {  
				reloadYeta3220_item02Grid();
				
				//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//				yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
				//reFresh("itemYeta02");
				reFresh();
			}	
		});
	}
	
	
	
	
	/**소득공제 grid 저장 **/
	public void itemYeta03Save() {
		
		actionDatabase = ActionDatabase.UPDATE;  
		
		//국세청자료 grid
		Iterator<Record> iterRecords = yeta1300ToYeta3220GridPanel2.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		
		List<Ye16Ta3220DTO> listYeta3220_1dto = new ArrayList<Ye16Ta3220DTO>();  
		
		while (iterRecords.hasNext()) {
			
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
	               
			Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
               
		     	yeta3220Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
	            yeta3220Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
	            yeta3220Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
	            yeta3220Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
	            
	            yeta3220Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 주민등록번호 : rsnoNumb */
	            yeta3220Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("relhCode")));    	/** column 관계 : relhCode */
	            yeta3220Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("kornName")));    	/** column 성명 : kornName */
	            
	            yeta3220Dto.setInsuPayr(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("insuPayr"), "0")));    /** column 보험료_건강고용등국세청 : insuPayr */
	            yeta3220Dto.setInsuGopy(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("insuGopy"), "0")));    /** column 보험료_건강고용등국세청 : insuPayr */
	            yeta3220Dto.setInsuRtyr(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("insuRtyr"), "0")));    /** column 보험료보장성_국세청 : insuRtyr */
	            yeta3220Dto.setPsclIurr(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("psclIurr"), "0")));    /** column 보험료장애인보장성_국세청 : psclIurr */
	            yeta3220Dto.setMediCost(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mediCost"), "0")));   /** column 의료비_국세청 : mediCost */
	            yeta3220Dto.setEducCost(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("educCost"), "0")));    /** column 교육비_국세청 : educCost */
	            yeta3220Dto.setCdteCard(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("cdteCard"), "0")));    /** column 신용카드등_국세청 : cdteCard */
	            yeta3220Dto.setCashRece(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("cashRece"), "0")));    /** column 현금영수증_국세청 : cashRece */
	            yeta3220Dto.setJiblCard(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("jiblCard"), "0")));    /** column 직불카드등_국세청 : jiblCard */
	            yeta3220Dto.setGrpyAmnt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("grpyAmnt"), "0")));    /** column 지로납부액_대중교통_국세청 : grpyAmnt */
	            yeta3220Dto.setMgntStvd(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mgntStvd"), "0")));    /** column 전통시장사용분_국세청 : mgntStvd */
	            yeta3220Dto.setCtrbAmnt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("ctrbAmnt"), "0")));    /** column 기부금액_국세청 : ctrbAmnt */
	            
	            listYeta3220_1dto.add(yeta3220Dto);
		}   
		
		//기타자료 grid
		iterRecords = yeta1300ToYeta3220GridPanel3.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		
		List<Ye16Ta3220DTO> listYeta3220_2dto = new ArrayList<Ye16Ta3220DTO>();  
		
		while (iterRecords.hasNext()) {
			
			
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
	               
			Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
               
			yeta3220Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
	        yeta3220Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
	        yeta3220Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
	        yeta3220Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
	            
	        yeta3220Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 주민등록번호 : rsnoNumb */
	        yeta3220Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("relhCode")));    	/** column 관계 : relhCode */
	        yeta3220Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("kornName")));    	/** column 성명 : kornName */
	            
	        yeta3220Dto.setInsuFetc(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("insuFetc"), "0")));    /** column 보험료_건강고용등외 : insuFetc */
	        yeta3220Dto.setInsuGoec(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("insuGoec"), "0")));    /** column 보험료_건강고용등외 : insuFetc */
	        yeta3220Dto.setInsuRtet(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("insuRtet"), "0")));    /** column 보험료보장성외 : insuRtet */
	        yeta3220Dto.setPsclIurt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("psclIurt"), "0")));    /** column 보험료장애인보장성외 : psclIurt */
	        yeta3220Dto.setMediExps(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mediExps"), "0")));    /** column 의료비외 : mediExps */
	        yeta3220Dto.setEducOtec(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("educOtec"), "0")));    /** column 교육비외 : educOtec */
	        yeta3220Dto.setCdteCdec(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("cdteCdec"), "0")));    /** column 신용카드외 : cdteCdec */
	        yeta3220Dto.setJiblCdec(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("jiblCdec"), "0")));    /** column 직불카드외 : jiblCdec */
	        yeta3220Dto.setGrpyAtec(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("grpyAtec"), "0")));    /** column 지로납부액_대중교통외 : grpyAtec */
	        yeta3220Dto.setMgntSdec(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mgntSdec"), "0")));    /** column 전통시장사용분외 : mgntSdec */
	        yeta3220Dto.setCtrbAmec(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("ctrbAmec"), "0")));    /** column 기부금액외 : ctrbAmec */
	            
	        listYeta3220_2dto.add(yeta3220Dto);
		}   
	       
		yeta1300Service.saveYeta1300To2000tabItem03(listYeta3220_1dto, listYeta3220_2dto, new AsyncCallback<Integer>() {
	    			 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta03Save(" + actionDatabase.name() + ") : " + caught), null);
			}
			public void onSuccess(Integer result) {  
//				reloadYeta3220_item02Grid();
//				reload();
				//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//				yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta03");
				//reFresh("itemYeta03");
				reFresh();
			}	
		});
	}
	
	
	
	/**연금보험료공제tab 국민연금외의 연금보험료 주근무지 수정 **/
	public void itemYeta04Save() {
			// TODO Auto-generated method stub
			yeta2000Dto = new Ye16Ta2000DTO();
			
			yeta2000Dto.setDpobCd(dpobCd.getValue());								/** column 사업장코드 : dpobCd */
			yeta2000Dto.setEdacRvyy(edacRvyy.getValue());							/** column 연말정산귀속년도 : edacRvyy */
			yeta2000Dto.setSettGbcd(settGbcd.getValue()); 							/** column 정산구분코드 : settGbcd */ 
			yeta2000Dto.setSystemkey(systemkey.getValue());							/** column SYSTEMKEY : systemkey */
			
//			yeta2000Dto.setBnatPsnf((Long) bnatPsnf.getValue());//종근무지_국민연금보험료
			yeta2000Dto.setJnatPsnf((Long) jnatPsnf.getValue());//주근무지_국민연금보험료
		
			yeta2000Dto.setJpssPulc((Long) jpssPulc.getValue());//주근무지_국민연금외공무원연금
			yeta2000Dto.setJpssSold((Long) jpssSold.getValue());//주근무지_국민연금외군인연금
			yeta2000Dto.setJpssTech((Long) jpssTech.getValue());//주근무지_국인연금외교직원연금
			yeta2000Dto.setJpssFect((Long) jpssFect.getValue());//주근무지_국민연금외별정우체국
			
			yeta1300Service.saveYeta1300To2000tabItem04(yeta2000Dto, new AsyncCallback<Integer>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta04Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						// reload();
						 
						//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//						yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
						//reFresh("itemYeta04");
						 reFresh();
					 } 
				}
			});
		}
	
	/**특별소득공제tab 보험료 tab 저장 **/
	public void itemYeta05_1Save() {
			// TODO Auto-generated method stub
			yeta2000Dto = new  Ye16Ta2000DTO();
			
			yeta2000Dto.setDpobCd(dpobCd.getValue());				/** column 사업장코드 : dpobCd */
			yeta2000Dto.setEdacRvyy(edacRvyy.getValue());			/** column 연말정산귀속년도 : edacRvyy */
			yeta2000Dto.setSettGbcd(settGbcd.getValue()); 			/** column 정산구분코드 : settGbcd */ 
			yeta2000Dto.setSystemkey(systemkey.getValue());			/** column SYSTEMKEY : systemkey */
		
			yeta2000Dto.setSpciHhlh((Long) spciHhlh.getValue());	//특별공제_주건강보험료
			yeta2000Dto.setSpciJepf((Long) spciJepf.getValue());	//특별공제_주고용보험료
			
			yeta1300Service.saveYeta1300To2000tabItem05_1(yeta2000Dto, new AsyncCallback<Integer>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta05_1Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
				           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
				          // reload();
				           
				        //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//						yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
						//reFresh("itemYeta05_2");
				           reFresh();
					 } 
				}
			});
		}
	
	
	/**특별소득공제tab 주택자금 tab 저장 **/
	public void itemYeta05_2Save() {
			// TODO Auto-generated method stub
			yeta2000Dto = new Ye16Ta2000DTO();
			
			yeta2000Dto.setDpobCd(dpobCd.getValue());/** column 사업장코드 : dpobCd */
			yeta2000Dto.setEdacRvyy(edacRvyy.getValue());		/** column 연말정산귀속년도 : edacRvyy */
			yeta2000Dto.setSettGbcd(settGbcd.getValue()); 	/** column 정산구분코드 : settGbcd */ 
			//yeta2000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));		/** column 연말정산귀속년도 : edacRvyy */
			//yeta2000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd")); 	/** column 정산구분코드 : settGbcd */
			yeta2000Dto.setSystemkey(systemkey.getValue());/** column SYSTEMKEY : systemkey */
		
			yeta2000Dto.setSpciRefn((Long) spciRefn.getValue());	//특별공제_차입금원리금상환액_대출기관 
			yeta2000Dto.setSpciResf((Long) spciResf.getValue());	//특별공제_차입금원리금상환액_거주자
			yeta2000Dto.setSpciHtam((Long) spciHtam.getValue());	//특별공제_주택자금_월세금액
			
			
			yeta2000Dto.setSpchRe06((Long) spchRe06.getValue());	//특별공제_11장기주택저당차입금15
			yeta2000Dto.setSpchRe10((Long) spchRe10.getValue());	//특별공제_11장기주택저당차입금29
			yeta2000Dto.setSpchRe20((Long) spchRe20.getValue());	//특별공제_11장기주택저당차입금30
			
			
			yeta2000Dto.setSpchRefx((Long) spchRefx.getValue());	//특별공제_12장기주택저당차입금_고정
			yeta2000Dto.setSpchReec((Long) spchReec.getValue());	//특별공제_12장기주택저당차입금_기타
			
			
			yeta2000Dto.setSpch15fx((Long) spch15fx.getValue()); 	//특별공제_15장기주택저당_15고정AND비거치상환
			yeta2000Dto.setSpch15fb((Long) spch15fb.getValue()); 	//특별공제_15장기주택저당_15고정OR비거치상환
			yeta2000Dto.setSpch15ec((Long) spch15ec.getValue()); 	//특별공제_15장기주택저당_15기타대출
			yeta2000Dto.setSpch10fb((Long) spch10fb.getValue()); 	//특별공제_15장기주택저당_10고정OR비거치상환

			
			
			yeta1300Service.saveYeta1300To2000tabItem05_2(yeta2000Dto, new AsyncCallback<Integer>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta05_2Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
				           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
				          // reload();
				           
				        //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//						yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
						//reFresh("itemYeta05_2");
				           reFresh();
					 } 
				}
			});
		}
	
	
	/**그밖의소득공제1 수정 **/
	public void itemYeta06Save() {
		// TODO Auto-generated method stub
		yeta2000Dto = new Ye16Ta2000DTO();
			
		yeta2000Dto.setDpobCd(dpobCd.getValue());/** column 사업장코드 : dpobCd */
		yeta2000Dto.setEdacRvyy(edacRvyy.getValue());		/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Dto.setSettGbcd(settGbcd.getValue()); 	/** column 정산구분코드 : settGbcd */ 
		
	//	yeta2000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));		/** column 연말정산귀속년도 : edacRvyy */
	//	yeta2000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd")); 	/** column 정산구분코드 : settGbcd */
		yeta2000Dto.setSystemkey(systemkey.getValue());/** column SYSTEMKEY : systemkey */

		//yeta2000Dto.setPrvm20be((Long) prvm20be.getValue()); 	// 개인연금저축불입액_2000년이전
		yeta2000Dto.setEtchPrep((Long) etchPrep.getValue()); 	    // 기타공제_소기업공제불입금액
		yeta2000Dto.setEtcsComp((Long) etcsComp.getValue()); 	// 기타공제_주택마련저축_청약저축
		yeta2000Dto.setEtwkHsbm((Long) etwkHsbm.getValue()); 	// 기타공제_주택마련저축_주택청약종합저축
		yeta2000Dto.setEtwkHsvm((Long) etwkHsvm.getValue()); 	// 기타공제_주택마련저축_근로자주택마련저축
		yeta2000Dto.setEtwkHbdm((Long) etwkHbdm.getValue()); 	// 기타공제_주택마련저축소득금액
		
		   //----------2016년도 추가 ----------------------------------------------------------------------------
		yeta2000Dto.setEtgdH14f((Long) etgdH14f.getValue()); 	// 기타공제_투자조합출자금액_2014년_조합
		yeta2000Dto.setEtgdH14b((Long) etgdH14b.getValue()); 	// 기타공제_투자조합출자금액_2014년_벤처
		yeta2000Dto.setEtclH15f((Long) etclH15f.getValue()); 	// 기타공제_투자조합출자금액_2015년_조합
		yeta2000Dto.setEtclH15b((Long) etclH15b.getValue()); 	// 기타공제_투자조합출자금액_2015년_벤처  
	
		/*****************2016귀속추가 ***************************/
		yeta2000Dto.setEtclH16f((Long) etclH16f.getValue()); 	// 기타공제_투자조합출자금액_2016년_조합
		yeta2000Dto.setEtclH16b((Long) etclH16b.getValue());	// 기타공제_투자조합출자금액_2016년_벤처 
		/*****************2016귀속추가 ***************************/	
		
	//	yeta2000Dto.setCardEt13((Long) cardEt13.getValue());	//기타공제_본인신용카드등사용액_2013
		yeta2000Dto.setCardEt14((Long) cardEt14.getValue());	//기타공제_본인신용카드등사용액_2014
		yeta2000Dto.setCardEt15((Long) cardEt15.getValue());	//기타공제_본인신용카등사용액_2015
	    
//		yeta2000Dto.setEtadDd13((Long) etadDd13.getValue());	//기타공제_본인추가공재율사용액_2013
		yeta2000Dto.setEtadD14l((Long) etadD14l.getValue());	//기타공제_본인추가공제율사용액_2014년도 
	//	yeta2000Dto.setEtadD15h((Long) etadD15h.getValue());	//기타공제_본인추가공제율사용액2015상반기
	//	yeta2000Dto.setEtadD15l((Long) etadD15l.getValue());	//기타공제_본인추가공제율사용액2015하반기
		
		/*****************2016귀속추가 ***************************/	
		yeta2000Dto.setEtadD16l((Long) etadD16l.getValue());	/** column 기타공제_본인추가공제율사용액_2016상 : etadD16l */
		/*****************2016귀속추가 ***************************/	
		   //----------2016년도 추가 ----------------------------------------------------------------------------
		
		
		yeta1300Service.saveYeta1300To2000tabItem06(yeta2000Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta06Save(저장) : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
					//reload();
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//					yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					//reFresh("itemYeta06");
					reFresh();
				} 
			}
		});
	}
	
	
	/**그밖의소득공제2 수정 **/
	public void itemYeta07Save() {
		// TODO Auto-generated method stub
		yeta2000Dto = new Ye16Ta2000DTO();
			
		yeta2000Dto.setDpobCd(dpobCd.getValue());			/** column 사업장코드 : dpobCd */
		yeta2000Dto.setEdacRvyy(edacRvyy.getValue());		/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Dto.setSettGbcd(settGbcd.getValue()); 		/** column 정산구분코드 : settGbcd */ 
		//yeta2000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));		/** column 연말정산귀속년도 : edacRvyy */
		//yeta2000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd")); 	/** column 정산구분코드 : settGbcd */
		yeta2000Dto.setSystemkey(systemkey.getValue());		/** column SYSTEMKEY : systemkey */

		yeta2000Dto.setEtckUnon((Long) etckUnon.getValue()); 	// 기타공제_우리사주출연금액
		//yeta2000Dto.setEtckUncb((Long) etckUncb.getValue()); 	// 기타공제_우리사주조합기부금2014이전
		yeta2000Dto.setEtepHsam((Long) etepHsam.getValue()); 	// 기타공제_고용유지중소기업근로자임금삭감액
		//yeta2000Dto.setEtgdCtra((Long) etgdCtra.getValue()); 	// 기타공제_목돈안드는전세이자상환금액
		//yeta2000Dto.setEtepSest((Long) etepSest.getValue()); 	// 기타공제_장기집합투자증권저축금액
	//	yeta2000Dto.setEtclEttl(etclEttl.getValue());			// 기타공제_기타제목
//		yeta2000Dto.setEtclEtam((Long) etclEtam.getValue()); 	// 기타공제_기타금액
		
		
		yeta1300Service.saveYeta1300To2000tabItem07(yeta2000Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta07Save(저장) : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
				//	reload();
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//					yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					//reFresh("itemYeta07");
					reFresh();
				} 
			}
		});
	}
	
	
	/**세액감면및세액공제1 - 연금계좌및보험료 수정 **/
	public void itemYeta08_1Save() {
		// TODO Auto-generated method stub
		yeta2000Dto = new Ye16Ta2000DTO();
			
		yeta2000Dto.setDpobCd(dpobCd.getValue());/** column 사업장코드 : dpobCd */
		yeta2000Dto.setEdacRvyy(edacRvyy.getValue());		/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Dto.setSettGbcd(settGbcd.getValue()); 	/** column 정산구분코드 : settGbcd */ 
	 
	//	yeta2000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));		/** column 연말정산귀속년도 : edacRvyy */
	//	yeta2000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd")); 	/** column 정산구분코드 : settGbcd */
		yeta2000Dto.setSystemkey(systemkey.getValue());/** column SYSTEMKEY : systemkey */
		
		//yeta2000Dto.setJrtrCtar((Long) jrtrCtar.getValue());	//주근무지_퇴직연금과학기술인공제대상금액
		//yeta2000Dto.setJrtrPtar((Long) jrtrPtar.getValue());	//주근무지_퇴직연금근로자퇴직급여보장대상금액
		//yeta2000Dto.setJrtrAtar((Long) jrtrAtar.getValue());	//주근무지_연금계좌저축공제대상금액
		yeta2000Dto.setSpciGurt((Long) spciGurt.getValue());	//특별공제_일반보장성보험료
		yeta2000Dto.setSpciHdrc((Long) spciHdrc.getValue());	//특별공제_장애인전용보험료
		

		yeta1300Service.saveYeta1300To2000tabItem08_1(yeta2000Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta08_1Save(저장) : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
					//reload();
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//					yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					//reFresh("itemYeta08_1");
					reFresh();
				} 
			}
		});
	}
	
	
	/**세액감면및세액공제1 - 교육비 수정 **/
	public void itemYeta08_3Save() {
		// TODO Auto-generated method stub
		yeta2000Dto = new  Ye16Ta2000DTO();
			
		yeta2000Dto.setDpobCd(dpobCd.getValue());/** column 사업장코드 : dpobCd */
		yeta2000Dto.setEdacRvyy(edacRvyy.getValue());		/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Dto.setSettGbcd(settGbcd.getValue()); 	/** column 정산구분코드 : settGbcd */ 
		//yeta2000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));		/** column 연말정산귀속년도 : edacRvyy */
		//yeta2000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd")); 	/** column 정산구분코드 : settGbcd */
		yeta2000Dto.setSystemkey(systemkey.getValue());/** column SYSTEMKEY : systemkey */

		yeta2000Dto.setSpedSelf((Long) spedSelf.getValue());	//특별공제_교육비_본인
		yeta2000Dto.setSpciScam((Long) spciScam.getValue());	//특별공제_장애인수

		 
		
		yeta1300Service.saveYeta1300To2000tabItem08_3(yeta2000Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta08_3Save(저장) : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
					
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					
					//Iterator<Record> iterRecords = yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
//			           
//					 Iterator<BaseModel> itBm  = yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();   
//			          
//			          List<Record>  lsRec  = new ArrayList<Record>();
//			          
//			          while(itBm.hasNext()) {
//			
//			              Record rec  = new Record(itBm.next()); 
//			              lsRec.add(rec);
//			              
//			          } 
//			          setListRecord(lsRec.iterator()); 
//			          Iterator<Record> iterRecords = getListRecord();
//			          
//					
//					List<Ye16Ta3150DTO> listYeta3150dto = new ArrayList<Ye16Ta3150DTO>();  
//				         
//					while (iterRecords.hasNext()) {
//				       
//						Record recData = (Record) iterRecords.next(); 
//						BaseModel bmMapModel = (BaseModel)recData.getModel();
//				               
//						Ye16Ta3150DTO yeta3150Dto = new Ye16Ta3150DTO();   
//						
//						yeta3150Dto.setEdacDtnu((Long) bmMapModel.get("edacDtnu"));    	/** column 교육비가족상세일련번호 : edacDtnu */
//						yeta3150Dto.setDpobCd(dpobCd.getValue());/** column 사업장코드 : dpobCd */
//						yeta3150Dto.setEdacRvyy(edacRvyy.getValue());		/** column 연말정산귀속년도 : edacRvyy */
//						yeta3150Dto.setSettGbcd(settGbcd.getValue()); 	/** column 정산구분코드 : settGbcd */ 
// 						yeta3150Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** column SYSTEMKEY : systemkey */
// 						yeta3150Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 가족학력구분코드 : rsnoNumb */
//						yeta3150Dto.setFmacGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("fmacGbcd$commCd")));    	/** column 가족학력구분코드 : fmacGbcd */
//						yeta3150Dto.setEdacOtam((Long) bmMapModel.get("edacOtam"));		/** column 교육비지급금액 : edacOtam */
//			                
//						listYeta3150dto.add(yeta3150Dto);
//						
//					}   

					
				} else {
//					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
//					reload();
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//					yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					
				} 
			}
		}); 

		
		Iterator<Record> iterRecords = yeta1300ToYeta3150GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
        
		List<Ye16Ta3150DTO> listYeta3150dto = new ArrayList<Ye16Ta3150DTO>(); 
		
		
		//if(listYeta3150dto.size() > 0) {
			
			
			while (iterRecords.hasNext()) {
			       
				Record recData = (Record) iterRecords.next(); 
				BaseModel bmMapModel = (BaseModel)recData.getModel();
		               
				Ye16Ta3150DTO yeta3150Dto = new Ye16Ta3150DTO();  
				
				
				yeta3150Dto.setEdacDtnu((Long) bmMapModel.get("edacDtnu"));								/** column 교육비가족상세일련번호 : edacDtnu */
				yeta3150Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));			/** column 정산구분코드 : settGbcd */
				yeta3150Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));			/** column 정산구분코드 : settGbcd */
				yeta3150Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
				yeta3150Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));		/** column SYSTEMKEY : systemkey */
				
				
				yeta3150Dto.setFmacGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("fmacGbcd$commCd")));	/** column 가족학력구분코드 : fmacGbcd */
				yeta3150Dto.setEdacOtam((Long) bmMapModel.get("edacOtam"));								/** column 교육비지급금액 : edacOtam */
				yeta3150Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));			/** column 가족주민등록번호 : rsnoNumb */
				yeta3150Dto.setGuksYeno((Boolean) bmMapModel.get("guksYeno"));
				listYeta3150dto.add(yeta3150Dto);
				
			}   
			
			actionDatabase = ActionDatabase.UPDATE;  
			
			yeta1300Service.saveYeta1300To2000tabItem08_3(listYeta3150dto, actionDatabase, new AsyncCallback<Long>() {
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
					                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta08_3Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Long result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					} else {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						
					} 
				}
			});
			
	//	}else {
	//		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
	//	}
	}
	
	
	/**세액감면및세액공제2  수정 **/
	public void itemYeta09Save() {
		// TODO Auto-generated method stub
		yeta2000Dto = new  Ye16Ta2000DTO();
			
		yeta2000Dto.setDpobCd(dpobCd.getValue());											/** column 사업장코드 : dpobCd */
		yeta2000Dto.setEdacRvyy(edacRvyy.getValue());										/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Dto.setSettGbcd(settGbcd.getValue()); 										/** column 정산구분코드 : settGbcd */ 
		yeta2000Dto.setSystemkey(systemkey.getValue());										/** column SYSTEMKEY : systemkey */

		//TODO DB에 TYPE이 NUBBER 확인필요
 		yeta2000Dto.setTaxdIncd1(taxdIncd1.getValue());										//세액공제_외국인_입국목적코드
 		yeta2000Dto.setTaxdIncd2(taxdIncd2.getValue());										//세액공제_외국인_입국목적코드
 		yeta2000Dto.setTaxdIncd3(taxdIncd3.getValue());										//세액공제_외국인_입국목적코드
 		yeta2000Dto.setTaxdIncd4(taxdIncd4.getValue());										//세액공제_외국인_입국목적코드 
		yeta2000Dto.setTaxdWkdt(YetaUtils.getConvertDateToString(taxdWkdt, "yyyyMMdd"));	//세액공제_외국인_근로제공일자
		yeta2000Dto.setTamaEddt(YetaUtils.getConvertDateToString(tamaEddt, "yyyyMMdd"));	//세액공제_외국인_감면기간만료일자
		yeta2000Dto.setTamaIndt(YetaUtils.getConvertDateToString(tamaIndt, "yyyyMMdd"));	//세액공제_외국인_감면신청접수일자
		yeta2000Dto.setTamaOudt(YetaUtils.getConvertDateToString(tamaOudt, "yyyyMMdd"));	//세액공제_외국인_감면신청제출일자
		yeta2000Dto.setTxlgFrrd(YetaUtils.getConvertDateToString(txlgFrrd, "yyyyMMdd"));	//세액공제_외국인해저광물개발감면확인일자
		yeta2000Dto.setTxlgFrid(YetaUtils.getConvertDateToString(txlgFrid, "yyyyMMdd"));	//세액공제_외국인해저광물개발감면신청일자
		yeta2000Dto.setTxlgWkid(YetaUtils.getConvertDateToString(txlgWkid, "yyyyMMdd"));	//세액공제_근로소득조세조약상면제접수일자
		yeta2000Dto.setTxlgTxtd(YetaUtils.getConvertDateToString(txlgTxtd, "yyyyMMdd"));	//세액공제_근로소득조세조약상면제제출일자
		yeta2000Dto.setTxlgBscd(YetaUtils.getConvertDateToString(txlgBscd, "yyyyMMdd"));	//세액공제_중소기업청년감면취업일자
		yeta2000Dto.setTxlgBcde(YetaUtils.getConvertDateToString(txlgBcde, "yyyyMMdd"));	//세액공제_중소기업청년감면종료일자
		yeta2000Dto.setTxlgItct((Long) txlgItct.getValue());								//세액감면_소득세법감면세액
		yeta2000Dto.setTxlgBsta((Long) txlgBsta.getValue());								//세액감면_취업청년감면대상총급여액
		yeta2000Dto.setTxlgWkta((Long) txlgWkta.getValue());								//세액감면_취업청년감면근로자총급여액
		yeta2000Dto.setTxlgFrta((Long) txlgFrta.getValue());								//세액감면_외국인기술자감면세액
		yeta2000Dto.setTxlgTxty((Long) txlgTxty.getValue());								//세액감면_조세조약감면세액
		
		yeta2000Dto.setTxlgInam((Long)txlgInam.getValue());   								//세액공제_외국납부_국외원천소득금액';
		yeta2000Dto.setTxlgDlam((Long)txlgDlam.getValue());   								//세액공제_외국납부_외화납세액';
		yeta2000Dto.setTxlgWnam((Long)txlgWnam.getValue());   								//세액공제_외국납부_원화납세액';
		yeta2000Dto.setTxlgOtcy(txlgOtcy.getValue());         								//세액공제_외국납부_납세국명';
		yeta2000Dto.setTxlgOtdt(YetaUtils.getConvertDateToString(txlgOtdt, "yyyyMMdd"));	//세액공제_외국납부_납부일자';
		yeta2000Dto.setTxlgApdt(YetaUtils.getConvertDateToString(incoOudt, "yyyyMMdd")); 	//세액공제_외국납부_신청서제출일자';
		yeta2000Dto.setTxlgOuwk(txlgOuwk.getValue());                                    	//세액공제_외국납부_국외근무처명';
		yeta2000Dto.setTxapStdt(YetaUtils.getConvertDateToString(txapStdt, "yyyyMMdd"));	//세액공제_외국납부_근무시작일자';
		yeta2000Dto.setTxapEddt(YetaUtils.getConvertDateToString(txapEddt, "yyyyMMdd")); 	//세액공제_외국납부_근무종료일자';
		yeta2000Dto.setTxapWkdy(txapWkdy.getValue());                                    	//세액공제_외국납부_직책';
		yeta2000Dto.setTaxdUnin((Long)taxdUnin.getValue());								 	//세액공제_납세조합세액공제';
		yeta2000Dto.setTaxdLoaa((Long)taxdLoaa.getValue());  							 	//세액공제_주택차입금이자상황금액';
		  
         
		yeta1300Service.saveYeta1300To2000tabItem09(yeta2000Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta09Save(저장) : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
					//reload();
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//					yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					//reFresh("itemYeta09");
					reFresh();
				} 
			}
		});
	}
	
	
	/**추가제출서류  수정 **/
	public void itemYeta10Save() {
		// TODO Auto-generated method stub
		yeta2000Dto = new  Ye16Ta2000DTO();
		
		yeta2000Dto.setDpobCd(dpobCd.getValue());/** column 사업장코드 : dpobCd */
		yeta2000Dto.setEdacRvyy(edacRvyy.getValue());		/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Dto.setSettGbcd(settGbcd.getValue()); 	/** column 정산구분코드 : settGbcd */ 
		
		//yeta2000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));		/** column 연말정산귀속년도 : edacRvyy */
		//yeta2000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd")); 	/** column 정산구분코드 : settGbcd */
		yeta2000Dto.setSystemkey(systemkey.getValue());/** column SYSTEMKEY : systemkey */
		
		yeta2000Dto.setFrnrSgyn(YetaUtils.getCheckedRadioValue(frnrSgyn));//1.외국인근로자 단말세율적용신청서 제출여부
		yeta2000Dto.setAddcNtyn(YetaUtils.getCheckedRadioValue(addcNtyn)) ;	//2.연금, 저축 등 소득공제 명세서 제출 여부
		yeta2000Dto.setSpciReyn(YetaUtils.getCheckedRadioValue(spciReyn)) ;	//3.월세액.비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부
	    
		yeta2000Dto.setAddcMdyn(YetaUtils.getCheckedRadioValue(addcMdyn)) ;	//의료비지급 명세서
		yeta2000Dto.setAddcCtyn(YetaUtils.getCheckedRadioValue(addcCtyn)) ;	//기부금 명세서
		yeta2000Dto.setAddcPfyn(YetaUtils.getCheckedRadioValue(addcPfyn)) ;	//소득공제 증빙서류
		yeta2000Dto.setIncoOufg(YetaUtils.getCheckedRadioValue(incoOufg)) ;	//소득공제신고서제출여부
		
		yeta2000Dto.setIncoOudt(YetaUtils.getConvertDateToString(incoOudt, "yyyyMMdd"));//소득공제신고서제출여부_제출일자
		
		yeta1300Service.saveYeta1300To2000tabItem10(yeta2000Dto, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta10Save(저장) : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
//					reload();
					
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
//					yeta1300ToYe16Ta2000Detail(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem(), "itemYeta01");
					//reFresh("itemYeta10");
					reFresh();
				} 
			}
		});
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 저장 메소드 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	 
	//대상자정보 grid 조회
	public void reload() {
		// TODO Auto-generated method stub
		
		String pymtYr  =  MSFSharedUtils.getSelectedComboValue(srhEdacRvyy,"year") ;
      	if (MSFSharedUtils.paramNull(pymtYr)) {
      		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                        "조회하시려면  정산년을 선택하셔야 합니다.", null);
      		return;
      	}
	     	if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd"))) {
	     	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                        "조회하시려면 정산구분을 선택하셔야 합니다.", null);
      		return;
      	}
	     	
	     	
		if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
				//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
				//return;
			} 
		} 
		resetItemYeta01();	    
		IColumnFilter filters = null;
		
		yeta1300ToYe16Ta2000GridPanel.getTableDef().setTableColumnFilters(filters);
		
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"), SimpleColumnFilter.OPERATOR_EQUALS);
		
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strDeptCd =YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
		           
		String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		       
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
		
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("printType", YetaUtils.getCheckedRadioValue(printType), SimpleColumnFilter.OPERATOR_EQUALS);  
		
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("yetaDpcd", MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYe16Ta2000GridPanel.getTableDef().addColumnFilter("busoprRgstnum", MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"), SimpleColumnFilter.OPERATOR_EQUALS);

		
		
		
		yeta1300ToYe16Ta2000GridPanel.reload(); 
      
	}
	
	
	/** 대상자에 따른 정보 가져옴 **/
	private void yeta1300ToYe16Ta2000Detail2(Ye16Ta2000BM result) {
	//	private void yeta1300ToYe16Ta2000Detail2(Ye16Ta2000BM result, String tabId) {
		//if("itemYeta01".equals(tabId)){//기본사항탭을 선택하였을 경우
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				dpobCd.setValue(result.getDpobCd());		/**  column 사업장코드 : dpobCd */
				edacRvyy.setValue(result.getEdacRvyy());	/** column 연말정산귀속년도 : edacRvyy */
				settGbcd.setValue(result.getSettGbcd());	/** column 정산구분코드 : settGbcd */
				systemkey.setValue(result.getSystemkey());	/**  column SYSTEMKEY : systemkey */
				
				
				YetaUtils.setCheckedRadioValue(gnanSgtf, result.getGnanSgtf());//세대주
				YetaUtils.setCheckedRadioValue(resdFlag, result.getResdFlag());//거주지구분
				
				natnName.setValue(MSFSharedUtils.allowNulls(result.getNatnName()));//국적 명
				natnGbcd.setValue(MSFSharedUtils.allowNulls(result.getNatnGbcd()));//국적 코드
				natnItem.setValue(MSFSharedUtils.allowNulls(result.getNatnItem()));//국적 코드 두자리
				
				reymStdt.setValue(GWTUtils.getDateFromString(result.getReymStdt(), "yyyyMMdd"));//근무 시작 기간
				reymEddt.setValue(GWTUtils.getDateFromString(result.getReymEddt(), "yyyyMMdd"));//근무 종료 기간
				rutrStdt.setValue(GWTUtils.getDateFromString(result.getRutrStdt(), "yyyyMMdd"));//감면 시작 기간
				rutrEddt.setValue(GWTUtils.getDateFromString(result.getRutrEddt(), "yyyyMMdd"));//감면 종료 기간
				
				redtName.setValue(MSFSharedUtils.allowNulls(result.getRedtName()));	//거구지국 두자리
				redtGbcd.setValue(MSFSharedUtils.allowNulls(result.getRedtGbcd()));	//거주지 코드
				redtItem.setValue(MSFSharedUtils.allowNulls(result.getRedtItem()));	//거주지국 명
				
				/*****************2016귀속추가 ***************************/
				
				YetaUtils.setCheckedCheckBoxValue(yrenSgyn, result.getYrenSgyn());
//				yrenSgyn.setValue(result.getYrenSgyn());   																							/** column 연말정산분할납부신청여부 : yrenSgyn */
				addIncmTxApptnRtoCd.setValue(lsAddIncmTxApptnRtoCd.findModel("commCd",MSFSharedUtils.allowNulls(result.getAddIncmTxApptnRtoCd())));	/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
				YetaUtils.setCheckedCheckBoxValue(frnrRnyn, result.getFrnrRnyn());
				
				
				//				frnrRnyn.setValue(result.getFrnrRnyn());   																							/** column 외국인법인소속파견근로자여부 : frnrRnyn */
				/*****************2016귀속추가 ***************************/
				
				dcsnTots.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getDcsnTots(), "0")));//종전근무지급여액
				currTots.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getCurrTots(), "0")));//주현근무지급여액
				totlSala.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTotlSala(), "0")));//총급여액
				wkerDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getWkerDdct(), "0")));//근로소득공제
				wkerAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getWkerAmnt(), "0")));//근로소득금액
				dcsnItax.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getDcsnItax(), "0")));//종전근무지결정세액 소득세
				dcsnBtax.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getDcsnBtax(), "0")));//종전근무지기납부세액 지방소득세
				taxdWken.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdWken(), "0")));//근로소득세액공제
				
				stndIncm.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getStndIncm(), "0")));//과세표준 
				prddTaxn.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPrddTaxn(), "0")));//산출세액 
				
				alryPinx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getAlryPinx(), "0")));//소득세_근무지결정세액 
				alryPhbx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getAlryPhbx(), "0")));//지방소득세_주현근무지기납부세액 
				
				 IColumnFilter filters = null;
		       		
	        	   yeta1300GridPanel.getTableDef().setTableColumnFilters(filters); 
	       	   	   yeta1300GridPanel.getTableDef().addColumnFilter("edacRvyy", edacRvyy.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
	       		   yeta1300GridPanel.getTableDef().addColumnFilter("settGbcd", settGbcd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
	       		   yeta1300GridPanel.getTableDef().addColumnFilter("systemkey", systemkey.getValue(), SimpleColumnFilter.OPERATOR_EQUALS); 
	       		   yeta1300GridPanel.reload();
			}
		//}else if("itemYeta02".equals(tabId)){//인적공제
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){
				
				reloadYeta3220_item02Grid();
				
				addrMrct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getAddrMrct(),"0")));//자녀수_인적공제
				addrMccr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getAddrMccr(),"0")));//세액공제_자녀수
			
				YetaUtils.setCheckedRadioValue(humnCgue, (String) result.get("humnCgue"));	//인적공제항목변동여부
			}
			
		//}else if("itemYeta03".equals(tabId)){//소득공제
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){

				reloadYeta3220_item03Grid();
				
				//addrMrct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((String) result.get("addrMrct"),"0")));//자녀수_인적공제
				//addrMccr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((String) result.get("addrMccr"),"0")));//세액공제_자녀수
			}
			
		//}else if("itemYeta04".equals(tabId)){ //연금보험료공제
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
			
				bnatPsnf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBnatPsnf(),"0")));//종전근무지금액_국민연금
				bnatDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBnatDdct(),"0")));//종전근무지공제액_국민연금
				jnatPsnf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJnatPsnf(),"0")));//주현근근무지금액_국민연금
				jnatDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJnatDdct(),"0")));//주현근무지공제액_국민연금
				
				bpssPulc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssPulc(),"0")));//공무원연금_종근무지
				bpssHpul.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssHpul(),"0")));//공무원연금_주근무지
				jpssPulc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssPulc(),"0")));//공제액_공무원연금_종근무지
				jpssHpul.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssHpul(),"0")));//공제액_공무원연금_주근무지
				
				bpssSold.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssSold(),"0")));//군인연금_종근무지
				bpssHsol.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssHsol(),"0")));//군인연금_주근무지
				jpssSold.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssSold(),"0")));//공제액_군인연금_종근무지
				jpssHsol.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssHsol(),"0")));//공제액_군인연금_주근무지
				
				bpssTech.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssTech(),"0")));//교직원연금_종근무지
				bpssHtec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssHtec(),"0")));//교직원연금_주근무지
				jpssTech.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssTech(),"0")));//공제액_교직원연금_종근무지
				jpssHtec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssHtec(),"0")));//공제액_교직원연금_주근무지
				
				bpssFect.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssFect(),"0")));//별정우체국_종근무지
				bpssDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getBpssDdct(),"0")));//별정우체국_주근무지
				jpssFect.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssFect(),"0")));//공제액_별정우체국_종근무지
				jpssDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJpssDdct(),"0")));//공제액_별정우체국_주근무지
				
				rrptAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getRrptAmnt(),"0")));//연금보험료금액계
				rrptYnam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getRrptYnam(),"0")));//연금보험료공제계
			}
			
		//}else if("itemYeta05_1".equals(tabId)) {//특별소득공제 - 보험료
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				spciBhlh.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciBhlh(),"0")));		//종전근무지금액_건강보험
				spciBhth.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciBhth(),"0")));		//종전근무지공제액_건강보험
				spciHhlh.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHhlh(),"0")));		//주현근무지금액_건강보험
				spciJhth.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciJhth(),"0")));		//주현근무지공제액_건강보험
				
				spciBepf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciBepf(),"0")));		//종전근무지금액_고용보험
				spciBepf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciBepf01(),"0")));	//종전근무지공제액_고용보험
				spciJepf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciJepf(),"0")));		//주현근무지금액_고용보험
				spciJepf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciJepf01(),"0")));	//주현근무지공제액_고용보험
				
				spciIuam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciIuam(),"0")));		//보험료금액계
				spciHrto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHrto(),"0")));		//보험료공제액
			}
			
		//}else if("itemYeta05_2".equals(tabId)) {//특별소득공제 - 주택자금
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				spciRefn.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciRefn(),"0")));		//대출기관차입
				spciResf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciResf(),"0")));		//공제액_대출기관차입
				spciRefn01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciRefn01(),"0")));	//거주자차입
				spciResf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciResf01(),"0")));	//공제액_거주자차입
				
				spciHtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHtam(),"0")));	//특별공제_차입금원리금상환액_거주자
				spciRtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciRtam(),"0")));	//특별공제_주택자금_월세금액
				
				spchRe06.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRe06(),"0")));	//이자상환액(15년 미만)
				spchRe10.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRe10(),"0")));	//공제액_이자상환액(15년 미만)
				spchRe20.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRe20(),"0")));	//이자상환액(15~29년)
				spchRe15.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRe15(),"0")));	//공제액_이자상환액(15~29년)
				spchRe29.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRe29(),"0")));	//이자상환액(30년 이상)
				spchRe30.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRe30(),"0")));	//공제액_이자상환액(30년 이상)
				
				spchRefx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRefx(),"0")));		//고정금리.비거치상환
				spchRefx01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchRefx01(),"0")));	//공제액_고정금리 비거치상환
				spchReec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchReec(),"0")));		//기타대출
				spchReec01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchReec01(),"0")));	//공제액_기타대출
				
				spch15fx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpch15fx(),"0")));//고정금리.비거치상환 대출(15년이상)
				spch15fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpch15fb(),"0")));//고정금리/비거치상환 대출(15년이상)
				spch15ec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpch15ec(),"0")));//기타대출(15년이상)
				spch10fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpch10fb(),"0")));//고정금리/비거치상환 대출(10년~15년)
				
				
				spci15fx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpci15fx(),"0")));//공제액_고정금리.비거치상환 대출(15년이상)
				spci15fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpci15fb(),"0")));//공제액_고정금리/비거치상환 대출(15년이상)
				spci15ec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpci15ec(),"0")));//공제액_기타대출(15년이상)
				spci10fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpci10fb(),"0")));//공제액_고정금리/비거치상환 대출(10년~15년)
				
				
				spchReto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpchReto(),"0")));//주택자금공제계
			}
		
		//}else if("itemYeta06".equals(tabId)){ //그밖의소득공제1
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				prvm20be.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getPrvm20be(),"0")));	//개인납입금액
				etcpPsnv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtcpPsnv(),"0")));	//공제액_개인납입금액
				etchPrep.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtchPrep(),"0")));	//소기업.소상공인공제부금 불입금
				etchPrep01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtchPrep01(),"0")));	//공제액_소기업.소상공인공제부금 불입금
				
				etcsComp.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtcsComp(),"0")));		//청약저축
				etwkHsbm.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtwkHsbm(),"0")));		//주택청약종합저축
				etwkHsvm.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtwkHsvm(),"0")));		//근로자주택마련저축
				etwkHbdm.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtwkHbdm(),"0")));		//주택마련저축소득공제계
				
				etcsComp01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtcsComp01(),"0")));	//공제액_청약저축
				etwkSbam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtwkSbam(),"0")));		//공제액_주택청약종합저축
				etwkSvam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtwkSvam(),"0")));		//공제액_근로자주택마련저축
				etwkBdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtwkBdam(),"0")));		//공제액계_주택마련저축소득공제계
				
				
				//---------------------------2016  변경 -------------------------------------------------------------------------------
				etgdH14f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdH14f(),"0")));	//출자.투자금액_2014년도조합
				etgdH14b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdH14b(),"0")));	//출자.투자금액_2014년도벤처
				etclH15f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtclH15f(),"0")));	//출자.투자금액_2015년도조합
				
				etclH15b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtclH15f(),"0")));	//출자.투자금액_2015년도 벤처 
				etclH16f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtclH16f(),"0")));	//출자.투자금액_2016년도조합
				etclH16b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtclH16b(),"0")));	//출자.투자금액_2016년도 벤처 
				etgdHdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdHdam(),"0")));	//출자.투자금액계
				
				
				etgdD14f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdD14f(),"0")));	//공제액_출자.투자금액_2014년도조합
				etgdD14b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdD14b(),"0")));	//공제액_출자.투자금액_2014년도벤처
				etgdD15f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdD15f(),"0")));	//공제액_출자.투자금액_2015년도조합
				etgdD15b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdD15b(),"0")));	//공제액_출자.투자금액_2015년도 벤처

				etgdD16f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdD16f(),"0")));	//공제액_출자.투자금액_2016년도조합
				etgdD16b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdD16b(),"0")));	//공제액_출자.투자금액_2016년도 벤처
				
				etgdDdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdDdam(),"0")));	//공제액계_출자.투자금액계
				
				etctCard.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtctCard(),"0")));	//신용카드
				etchBcbs.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtchBcbs(),"0")));	//직불카드등
				etchUeam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtchUeam(),"0")));	//현금영수증
				etchMgvd.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtchMgvd(),"0")));	//전통시장
				etchBced.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtchBced(),"0")));	//대중교통
				etchBcue.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtchBcue(),"0")));	//신용카드등사용금액계
				etccCard.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtccCard(),"0")));	//신용카드등사용공제액계
			//	cardEt13.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getCardEt13(),"0")));	//신용카드등(본인2013년)
				cardEt14.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getCardEt14(),"0")));	//신용카드등(본인2014년)
			//	etadDd13.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtadDd13(),"0")));	//추가공제율(본인2013년)
				etadD14l.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtadD14l(),"0")));	//추가공제율(본인2014년)
				
				
				cardEt15.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getCardEt15(),"0")));	//신용카드등(본인2015년)
			//	etadD15h.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtadD15h(),"0")));	//추가공제율(본인2015년)
			//	etadD15l.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtadD15l(),"0")));	//추가공제율(본인2015년하)
				etadD16l.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtadD16l(),"0")));	/** column 기타공제_본인추가공제율사용액_2016상 : etadD16l */
		
				//---------------------------2016  변경 -------------------------------------------------------------------------------
				
			}
		//}else if("itemYeta07".equals(tabId)){//그밖의소득공제2
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){
				
				etckUnon.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtckUnon(),"0")));	//우리사주조합연출금액
				etckUncb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtckUncb(),"0")));	//우리사주조합기부금
				etepHsam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtepHsam(),"0")));	//고용유지중소기업근로자 임금삭감액
				etgdCtra.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdCtra(),"0")));	//목돈안드는전세이자상환액
				etepSest.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtepSest(),"0")));	//장기집합투자증권저축 납입금액
			//	etclEtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtclEtam(),"0")));	//기타_금액
				
		//		etclEttl.setValue(MSFSharedUtils.allowNulls((String) result.get("etclEttl")));//기타_필드명
				
				etckUnon01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtckUnon01(),"0")));	//공제액_우리사주조합연출금액
				etckUncr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtckUncr(),"0")));		//공제액_우리사주조합기부금
				etepMsam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtepMsam(),"0")));		//공제액_고용유지중소기업근로자 임금삭감액
				etgdHtra.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtgdHtra(),"0")));//공제액_목돈안드는전세이자상환액
				etepSecr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtepSecr(),"0")));		//공제액_장기집합투자증권저축 납입금액
			//	etcdTsum.setValue(0L);		//공제액_기타MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getEtcdTsum(),"0"))
			}
			
		//}else if("itemYeta08_1".equals(tabId)) {//세액감면및세액공제1 - 연금계좌및보험료
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				jrtrCict.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrCict(),"0")));	//과학기술인공제
				jrtrCtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrCtar(),"0")));	//공제대상_과학기술인공제
				jrtrHict.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrHict(),"0")));	//공제액_과학기술인공제
				
				jrtrPsct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrPsct(),"0")));	//근로자퇴직보장법
				jrtrPtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrPtar(),"0")));	//공제대상_근로자퇴직보장법
				jrtrPsrn.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrPsrn(),"0")));	//공제액_근로자퇴직보장법
				
				jrtrAnsv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrAnsv(),"0")));	//연금저축계좌
				jrtrAtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrAtar(),"0")));	//공제대상_연금저축계좌
				jrtrHnsv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrHnsv(),"0")));	//공제액_연금저축계좌
				
				jrtrAtom.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrAtom(),"0")));	//연금계좌제
				jrtrTotr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrTotr(),"0")));	//공제대상_연금계좌제
				jrtrHnto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getJrtrHnto(),"0")));	//공제액_연금계좌제
				
				spciGurt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciGurt(),"0")));	//일반보장성보험_보험료금액
				spciRttg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciRttg(),"0")));	//공제대상_일반보장성보험_보험료금액
				spciGurt01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciGurt01(),"0")));//공제액_일반보장성보험_보험료금액
				
				spciHdrc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHdrc(),"0")));	//장애인전용보장성보험_보험료금액
				spciHdtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHdtg(),"0")));	//공제대상_장애인전용보장성보험_보험료금액
				spciHdrc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHdrc01(),"0")));//공제액_장애인전용보장성보험_보험료금액
				
				spciRtto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciRtto(),"0")));	//연금계좌및보험료_보험료계
				spciDetg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDetg(),"0")));	//공제대상_연금계좌및보험료_보험료금액
				spciRtde.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciRtde(),"0")));	//공제액_연금계좌및보험료_보험료금액
			}
		//}else if("itemYeta08_2".equals(tabId)) {//세액감면및세액공제1 - 의료비
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){
				
				spciSelf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciSelf(),"0")));//지출금액_본인의료비
				spciSftg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciSftg(),"0")));//공제대상_본인의료비
				spciSelf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciSelf01(),"0")));//세액공제_본인의료비
	
				spciAe65.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciAe65(),"0")));//지출금액_65세이상자 의료비
				spci65tg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpci65tg(),"0")));//공제대상_65세이상자 의료비
				spciHe65.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHe65(),"0")));//세액공제_65세이상자 의료비
				
				spciDbps.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDbps(),"0")));//지출금액_장애인 의료비
				spciPstg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciPstg(),"0")));//공제대상_장애인 의료비
				spciHbps.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHbps(),"0")));//세액공제_장애인 의료비
				
				spciEtcg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciEtcg(),"0")));//지출금액_그밖의 공제대상자 의료비
				spciDetc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDetc(),"0")));//공제대상_그밖의 공제대상자 의료비
				spciDetc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDetc01(),"0")));//세액공제_그밖의 공제대상자 의료비
				
				spciEtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciEtam(),"0")));//의료비금액계
				spciDtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDtar(),"0")));//공제대상계_의료비금액계
				spciTxcr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciTxcr(),"0")));//세액공제계_의료비금액계
			}
			
		//}else if("itemYeta08_3".equals(tabId)) {//세액감면및세액공제1 - 교육비
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				spedSelf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedSelf(),"0")));//공납금(대학원포함)
				spedSftr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedSftr(),"0")));//공제대상_공납금(대학원포함)
				spedSelf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedSelf01(),"0")));//세액공제_공납금(대학원포함)
				
				spedEdsu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedEdsu(),"0")));//취학전아동_수
				spedEdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedEdam(),"0")));//취학전아동_금액
				spedGrde.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedGrde(),"0")));//취학전아동(공제)
				
				spedGdsu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedGdsu(),"0")));//초.중.고등학교_수
				spedGdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedGdam(),"0")));//초.중.고등학교_금액
				spedGdto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedGdto(),"0")));//초.중.고등학교(공제)
				
				spedCvsu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedCvsu(),"0")));//대학원(대학원불포함)_수
				spedCvam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedCvam(),"0")));//대학원(대학원불포함)_금액
				spedCldv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedCldv(),"0")));//대학원(대학원불포함)(공제)
				
				spciSctr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciSctr(),"0")));//특수교육비_장애인
				spciScam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciScam(),"0")));//공제대상계_장애인
				spciSpec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciSpec(),"0")));//세액공제_장애인
				
				siedToam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSiedToam(),"0")));//교육비금액계
				spedEtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedEtar(),"0")));//공제대상계_교육비금액계
				spedTxcr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpedTxcr(),"0")));//세액공제계_교육비금액계
				
				reloadYeta3150Grid();
				
			}
			
		//}else if("itemYeta08_4".equals(tabId)) {//세액감면및세액공제1 - 기부금
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				taxdPltc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdPltc(),"0")));//정지차금(10만원이하)_기부금액
				taxd10tg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxd10tg(),"0")));//정지차금(10만원이하)_공제대상금액
				taxdPltc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdPltc01(),"0")));//정지차금(10만원이하)_공제세액
				
				spciPltc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciPltc(),"0")));//정지차금(10만원초과)_기부금액
				spciPltg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciPltg(),"0")));//정지차금(10만원초과)_공제대상금액
				spciPltc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciPltc01(),"0")));//정지차금(10만원초과)_공제세액
				
				spciFbam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciFbam(),"0")));//전액공제기부금액(법정)_기부금액
				spciFbtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciFbtg(),"0")));//전액공제기부금액(법정)_공제대상금액
				spciFbam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciFbam01(),"0")));//전액공제기부금액(법정)_공제세액
				
				spciExam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciExam(),"0")));//특례기부금(공익법인신탁제외)_기부금액
				spciExtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciExtg(),"0")));//특례기부금(공익법인신탁제외)_공제대상금액
				spciExam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciExam01(),"0")));//특례기부금(공익법인신탁제외)_공제세액
				
				spciHfam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHfam(),"0")));//우리사주조합기부금_기부금액
				spciHftg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciHftg(),"0")));//우리사주조합기부금_공제대상금액
				spciRfam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciRfam(),"0")));//우리사주조합기부금_공제세액
				
				spciNamt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciNamt(),"0")));//종교단체외지정기부금_기부금액
				spciNatg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciNatg(),"0")));//종교단체외지정기부금_공제대상금액
				spciNamt01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciNamt01(),"0")));//종교단체외지정기부금_공제세액
				
				spciYamt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciYamt(),"0")));//종교단체지정기부금_기부금액
				spciYatg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciYatg(),"0")));//종교단체지정기부금_기부금액_공제대상금액
				spciYamt01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciYamt01(),"0")));//종교단체지정기부금_기부금액_공제세액
				
				spciDgam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDgam(),"0")));//기부금액계
				spciDgtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDgtg(),"0")));//공제대상계_기부금액계
				spciDgcr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciDgcr(),"0")));//세액공제계_기부금액계
				
				spciObam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciObam(),"0")));//이월법정기부금액
				spciOyam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciOyam(),"0")));//이월지정기부금(종교 외)
				spciOnam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciOnam(),"0")));//이월지정기부금(종교)
				spciObam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciObam01(),"0")));//이월법정기부금액_공제세액
				spciOyam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciOyam01(),"0")));//이월지정기부금(종교 외)_공제세액
				spciOnam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciOnam01(),"0")));//이월지정기부금(종교외)_공제세액
				
				spciSsum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getSpciSsum(),"0")));//기부금(이월분)
			
			}
		//}else if("itemYeta09".equals(tabId)){//세액감면및세액공제2
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				//YetaUtils.setCheckedCheckBoxValue(taxdIncd, MSFSharedUtils.allowNulls((String) result.get("taxdIncd")));//입국목적
				
				
				YetaUtils.setCheckedCheckBoxValue(taxdIncd1, result.getTaxdIncd1());
				YetaUtils.setCheckedCheckBoxValue(taxdIncd2, result.getTaxdIncd2());
				YetaUtils.setCheckedCheckBoxValue(taxdIncd3, result.getTaxdIncd3());
				YetaUtils.setCheckedCheckBoxValue(taxdIncd4, result.getTaxdIncd4());
				
				taxdWkdt.setValue(GWTUtils.getDateFromString(result.getTaxdWkdt(), "yyyyMMdd"));//기술도입계약 또는 근로제공일
				tamaEddt.setValue(GWTUtils.getDateFromString(result.getTamaEddt(), "yyyyMMdd"));//감면기간 만료일
				tamaIndt.setValue(GWTUtils.getDateFromString(result.getTamaIndt(), "yyyyMMdd"));//외국인근로소득에 대한 감면 신청서 접수일자
				tamaOudt.setValue(GWTUtils.getDateFromString(result.getTamaOudt(), "yyyyMMdd"));//제출일자_외국인근로소득에 대한 감면 신청서 접수일자
				txlgFrrd.setValue(GWTUtils.getDateFromString(result.getTxlgFrrd(), "yyyyMMdd"));//해저광물자원개발에 대한 감면 확인일자
				txlgFrid.setValue(GWTUtils.getDateFromString(result.getTxlgFrid(), "yyyyMMdd"));//신청일자_해저광물자원개발에 대한 감면 확인일자
				txlgWkid.setValue(GWTUtils.getDateFromString(result.getTxlgWkid(), "yyyyMMdd"));//근로소득에 대한 조세조약상 면제 접수일자
				txlgTxtd.setValue(GWTUtils.getDateFromString(result.getTxlgTxtd(), "yyyyMMdd"));//제출일자_근로소득에 대한 조세조약상 면제 접수일자
				
				txlgBscd.setValue(GWTUtils.getDateFromString(result.getTxlgBscd(), "yyyyMMdd"));//중소기업 취업 청년감면 취업일자
				txlgBcde.setValue(GWTUtils.getDateFromString(result.getTxlgBcde(), "yyyyMMdd"));//감면기간 종료일_중소기업 취업 청년감면 취업일자
				
				txlgItct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgItct(),"0")));//소득세법 감면세액
				taxdIcax.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdIcax(),"0")));//감면세액_소득세법 감면세액
				
				txlgBsta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgBsta(),"0")));//취업청년감면대상총급여
				txlgWkta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgWkta(),"0")));//근로자총급여_취업청년감면대상총급여
				
				txlgClta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgClta(),"0")));//계산 감면세액
				taxdTsum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdTsum(),"0")));//감면세액_계산 감면세액
				
				txlgFrta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgFrta(),"0")));//외국인기술자 감면세액
				taxdRedu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdRedu(),"0")));//감면세액_외국인기술자 감면세액
				
				txlgTxty.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgTxty(),"0")));//조세조약 감면세액
				txlgHxtt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgHxtt(),"0")));//감면세액_조세조약 감면세액
			
				txlgInam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgInam(),"0")));//국외원천소득
				txlgDlam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgDlam(),"0")));//납세액(외화)
				txlgWnam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTxlgWnam(),"0")));//납세액(원화)
				txlgOtcy.setValue(MSFSharedUtils.allowNulls(result.getTxlgOtcy()));//납세국명
				txlgOtdt.setValue(GWTUtils.getDateFromString(result.getTxlgOtdt(), "yyyyMMdd"));//납부일
				txlgApdt.setValue(GWTUtils.getDateFromString(result.getTxlgApdt(), "yyyyMMdd"));//신청서제출일
				txlgOtcy.setValue(MSFSharedUtils.allowNulls(result.getTxlgOtcy()));//국외근무처
				txapWkdy.setValue(MSFSharedUtils.allowNulls(result.getTxapWkdy()));//직책
				txapStdt.setValue(GWTUtils.getDateFromString(result.getTxapStdt(), "yyyyMMdd"));//근무기간_시작_외국납부세액공제
				txapEddt.setValue(GWTUtils.getDateFromString(result.getTxapEddt(), "yyyyMMdd"));//근무기간_종료_외국납부세액공제
				
				taxdUnin.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdUnin(),"0")));//납세조합원천징수세액(10%)
				taxdUnin01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdUnin01(),"0")));//납세조합공제액
				taxdLoaa.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdLoaa(),"0")));//주택자금차입금이자세액공제 이자상환
				taxdLoan.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(result.getTaxdLoan(),"0")));//주택자금차입금이자세액공제 공제액
				
			}
			
		//}else if("itemYeta10".equals(tabId)){//추가제출서류
			
			if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
				
				YetaUtils.setCheckedRadioValue(frnrSgyn, MSFSharedUtils.allowNulls(result.getFrnrSgyn()));		//1.외국인근로자 단일세율적용신청서 제출여부
				YetaUtils.setCheckedRadioValue(addcNtyn, MSFSharedUtils.allowNulls(result.getAddcNtyn()));		//2.연금, 저축 등 소득공제 명세서 제출여부
				YetaUtils.setCheckedRadioValue(spciReyn, MSFSharedUtils.allowNulls(result.getSpciReyn()));		//3.월세액.비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부
				
				YetaUtils.setCheckedRadioValue(addcMdyn, MSFSharedUtils.allowNulls(result.getAddcMdyn()));		//의료비지급명세서
				YetaUtils.setCheckedRadioValue(addcCtyn, MSFSharedUtils.allowNulls(result.getAddcCtyn()));		//기부금명세서
				YetaUtils.setCheckedRadioValue(addcPfyn, MSFSharedUtils.allowNulls(result.getAddcPfyn()));		//소득공제 증빙서류
				
				YetaUtils.setCheckedRadioValue(incoOufg, MSFSharedUtils.allowNulls(result.getIncoOufg()));		//소득공제신고서제출여부
				incoOudt.setValue(GWTUtils.getDateFromString(result.getIncoOudt(), "yyyyMMdd"));	//제출일자_소득공제신고서제출여부
			}
		//}
	}
	
	
	/** 대상자에 따른 정보 가져옴 **/
//	private void yeta1300ToYe16Ta2000Detail(BaseModel selRecord, String tabId) {
//		if("itemYeta01".equals(tabId)){//기본사항탭을 선택하였을 경우
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				 
//				dpobCd.setValue((String) selRecord.get("dpobCd"));		/**  column 사업장코드 : dpobCd */
//				edacRvyy.setValue((String) selRecord.get("edacRvyy"));	/** column 연말정산귀속년도 : edacRvyy */
//				settGbcd.setValue((String) selRecord.get("settGbcd"));	/** column 정산구분코드 : settGbcd */
//				systemkey.setValue((String) selRecord.get("systemkey"));/**  column SYSTEMKEY : systemkey */
//				
//				
//				dpobCd.setValue((String) selRecord.get("dpobCd"));		/**  column 사업장코드 : dpobCd */
//				edacRvyy.setValue((String) selRecord.get("edacRvyy"));	/** column 연말정산귀속년도 : edacRvyy */
//				settGbcd.setValue((String) selRecord.get("settGbcd"));	/** column 정산구분코드 : settGbcd */
//				systemkey.setValue((String) selRecord.get("systemkey"));/**  column SYSTEMKEY : systemkey */
//				
//				YetaUtils.setCheckedRadioValue(gnanSgtf, (String) selRecord.get("gnanSgtf"));	//세대주
//				YetaUtils.setCheckedRadioValue(resdFlag, (String) selRecord.get("resdFlag"));	//거주지구분
//				
//				natnName.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("natnName")));//국적 명
//				natnGbcd.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("natnGbcd")));//국적 코드
//				natnItem.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("natnItem")));//국적 코드 두자리
//				
//				reymStdt.setValue((Date) selRecord.get("reymStdt"));//근무 시작 기간
//				reymEddt.setValue((Date) selRecord.get("reymEddt"));//근무 종료 기간
//				rutrStdt.setValue((Date) selRecord.get("rutrStdt"));//감면 시작 기간
//				rutrEddt.setValue((Date) selRecord.get("rutrEddt"));//감면 종료 기간
//				redtGbcd.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("redtGbcd")));//거주지 코드
//				redtName.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("redtName")));//거구지국 두자리
//				redtItem.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("redtItem")));//거주지국 명
//				
//				dcsnTots.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("dcsnTots"), "0")));//종전근무지급여액
//				currTots.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("currTots"), "0")));//주현근무지급여액
//				totlSala.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("totlSala"), "0")));//총급여액
//				wkerDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("wkerDdct"), "0")));//근로소득공제
//				wkerAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("wkerAmnt"), "0")));//근로소득금액
//				dcsnItax.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("dcsnItax"), "0")));//종전근무지결정세액 소득세
//				dcsnBtax.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("dcsnBtax"), "0")));//종전근무지기납부세액 지방소득세
//				taxdWken.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("taxdWken"), "0")));//근로소득세액공제
//      	
//				alryPinx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("alryPinx"), "0")));//소득세_현근무지결정세액 
//				alryPhbx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("alryPhbx"), "0")));//지방소득세_주현근무지기납부세액 
//			}
//		}else if("itemYeta02".equals(tabId)){//인적공제
//			if (MSFSharedUtils.paramNotNull(selRecord)){
//				
//				reloadYeta3220_item02Grid();
//				
////				Iterator<Record> iterRecords = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
////		        
////				beforeJumin = new ArrayList<Ye16Ta3220DTO>();  
////				
////				while (iterRecords.hasNext()) {
////				       
////					Record recData = (Record) iterRecords.next(); 
////					BaseModel bmMapModel = (BaseModel)recData.getModel();
////			               
////					Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
////		                
////			        yeta3220Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
////			        yeta3220Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
////			        yeta3220Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
////			        yeta3220Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
////			            
////			        yeta3220Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 주민등록번호 : rsnoNumb */
////			        yeta3220Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("relhCode")));    	/** column 관계 : relhCode */
////			        yeta3220Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("kornName")));    	/** column 성명 : kornName */
//////			            yeta3220Dto.setFrnrCode(MSFSharedUtils.allowNulls(bmMapModel.get("frnrCode")));    	/** column 내외국인구분코드 : frnrCode */
//////			            
//////			            yeta3220Dto.setBaseDdyn((Boolean) bmMapModel.get("baseDdyn"));    /** column 기본공제여부 : baseDdyn */
//////			            yeta3220Dto.setPsclDdyn(MSFSharedUtils.allowNulls(bmMapModel.get("psclDdyn$commCd")));    	/** column 장애인공제여부 : psclDdyn */
//////			            yeta3220Dto.setBrddCtyn((Boolean) bmMapModel.get("brddCtyn"));    /** column 자녀양육비공제여부 : brddCtyn */
//////			            yeta3220Dto.setFaddCtyn((Boolean) bmMapModel.get("faddCtyn"));    /** column 부녀자공제여부 : faddCtyn */
//////			            yeta3220Dto.setRpctDdyn((Boolean) bmMapModel.get("rpctDdyn"));    /** column 경로우대공제여부 : rpctDdyn */
//////			            yeta3220Dto.setBithDdyn((Boolean) bmMapModel.get("bithDdyn"));    /** column 출산입양자공제여부 : bithDdyn */
//////			            yeta3220Dto.setPantOnyn((Boolean) bmMapModel.get("pantOnyn"));    /** column 한부모공제여부 : pantOnyn */
////		                
////			            beforeJumin.add(yeta3220Dto);
////				}  
//				addrMrct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("addrMrct"),"0")));//자녀수_인적공제
//				addrMccr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((Long) selRecord.get("addrMccr"),"0")));//세액공제_자녀수
//			
//				
//				YetaUtils.setCheckedRadioValue(humnCgue, (String) selRecord.get("humnCgue"));	//인적공제항목변동여부
//			}
//			
//		}else if("itemYeta03".equals(tabId)){//소득공제
//			if (MSFSharedUtils.paramNotNull(selRecord)){
//
//				reloadYeta3220_item03Grid();
//				
//				//addrMrct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((String) selRecord.get("addrMrct"),"0")));//자녀수_인적공제
//				//addrMccr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls((String) selRecord.get("addrMccr"),"0")));//세액공제_자녀수
//			}
//			
//		}else if("itemYeta04".equals(tabId)){ //연금보험료공제
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//			
//				bnatPsnf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bnatPsnf"),"0")));//종전근무지금액_국민연금
//				bnatDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bnatDdct"),"0")));//종전근무지공제액_국민연금
//				jnatPsnf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jnatPsnf"),"0")));//주현근근무지금액_국민연금
//				jnatDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jnatDdct"),"0")));//주현근무지공제액_국민연금
//				
//				bpssPulc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssPulc"),"0")));//공무원연금_종근무지
//				bpssHpul.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssHpul"),"0")));//공무원연금_주근무지
//				jpssPulc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssPulc"),"0")));//공제액_공무원연금_종근무지
//				jpssHpul.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssHpul"),"0")));//공제액_공무원연금_주근무지
//				
//				bpssSold.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssSold"),"0")));//군인연금_종근무지
//				bpssHsol.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssHsol"),"0")));//군인연금_주근무지
//				jpssSold.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssSold"),"0")));//공제액_군인연금_종근무지
//				jpssHsol.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssHsol"),"0")));//공제액_군인연금_주근무지
//				
//				bpssTech.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssTech"),"0")));//교직원연금_종근무지
//				bpssHtec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssHtec"),"0")));//교직원연금_주근무지
//				jpssTech.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssTech"),"0")));//공제액_교직원연금_종근무지
//				jpssHtec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssHtec"),"0")));//공제액_교직원연금_주근무지
//				
//				bpssFect.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssFect"),"0")));//별정우체국_종근무지
//				bpssDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("bpssDdct"),"0")));//별정우체국_주근무지
//				jpssFect.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssFect"),"0")));//공제액_별정우체국_종근무지
//				jpssDdct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jpssDdct"),"0")));//공제액_별정우체국_주근무지
//				
//				rrptAmnt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("rrptAmnt"),"0")));//연금보험료금액계
//				rrptYnam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("rrptYnam"),"0")));//연금보험료공제계
//			}
//			
//		}else if("itemYeta05_1".equals(tabId)) {//특별소득공제 - 보험료
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				spciBhlh.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciBhlh"),"0")));//종전근무지금액_건강보험
//				spciBhth.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciBhth"),"0")));//종전근무지공제액_건강보험
//				spciHhlh.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHhlh"),"0")));//주현근무지금액_건강보험
//				spciJhth.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciJhth"),"0")));//주현근무지공제액_건강보험
//				
//				spciBepf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciBepf"),"0")));		//종전근무지금액_고용보험
//				spciBepf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciBepf01"),"0")));	//종전근무지공제액_고용보험
//				spciJepf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciJepf"),"0")));		//주현근무지금액_고용보험
//				spciJepf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciJepf01"),"0")));	//주현근무지공제액_고용보험
//				
//				spciIuam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciIuam"),"0")));//보험료금액계
//				spciHrto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHrto"),"0")));//보험료공제액
//			}
//			
//		}else if("itemYeta05_2".equals(tabId)) {//특별소득공제 - 주택자금
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				spciRefn.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciRefn"),"0")));		//대출기관차입
//				spciResf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciResf"),"0")));		//공제액_대출기관차입
//				spciRefn01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciRefn01"),"0")));	//거주자차입
//				spciResf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciResf01"),"0")));	//공제액_거주자차입
//				
//				spciHtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHtam"),"0")));	//특별공제_차입금원리금상환액_거주자
//				spciRtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciRtam"),"0")));	//특별공제_주택자금_월세금액
//				
//				spchRe06.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRe06"),"0")));	//이자상환액(15년 미만)
//				spchRe10.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRe10"),"0")));	//공제액_이자상환액(15년 미만)
//				spchRe20.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRe20"),"0")));	//이자상환액(15~29년)
//				spchRe15.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRe15"),"0")));	//공제액_이자상환액(15~29년)
//				spchRe29.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRe29"),"0")));	//이자상환액(30년 이상)
//				spchRe30.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRe30"),"0")));	//공제액_이자상환액(30년 이상)
//				
//				spchRefx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRefx"),"0")));		//고정금리.비거치상환
//				spchRefx01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchRefx01"),"0")));	//공제액_고정금리 비거치상환
//				spchReec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchReec"),"0")));		//기타대출
//				spchReec01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchReec01"),"0")));	//공제액_기타대출
//				
//				spch15fx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spch15fx"),"0")));//고정금리.비거치상환 대출(15년이상)
//				spch15fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spch15fb"),"0")));//고정금리/비거치상환 대출(15년이상)
//				spch15ec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spch15ec"),"0")));//기타대출(15년이상)
//				spch10fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spch10fb"),"0")));//고정금리/비거치상환 대출(10년~15년)
//				
//				
//				spci15fx.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spci15fx"),"0")));//공제액_고정금리.비거치상환 대출(15년이상)
//				spci15fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spci15fb"),"0")));//공제액_고정금리/비거치상환 대출(15년이상)
//				spci15ec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spci15ec"),"0")));//공제액_기타대출(15년이상)
//				spci10fb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spci10fb"),"0")));//공제액_고정금리/비거치상환 대출(10년~15년)
//				
//				
//				spchReto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spchReto"),"0")));//주택자금공제계
//			}
//		
//		}else if("itemYeta06".equals(tabId)){ //그밖의소득공제1
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				prvm20be.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("prvm20be"),"0")));	//개인납입금액
//				etcpPsnv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etcpPsnv"),"0")));	//공제액_개인납입금액
//				etchPrep.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etchPrep"),"0")));	//소기업.소상공인공제부금 불입금
//				etchPrep01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etchPrep01"),"0")));	//공제액_소기업.소상공인공제부금 불입금
//				
//				etcsComp.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etcsComp"),"0")));		//청약저축
//				etwkHsbm.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etwkHsbm"),"0")));		//주택청약종합저축
//				etwkHsvm.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etwkHsvm"),"0")));		//근로자주택마련저축
//				etwkHbdm.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etwkHbdm"),"0")));		//주택마련저축소득공제계
//				
//				etcsComp01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etcsComp01"),"0")));	//공제액_청약저축
//				etwkSbam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etwkSbam"),"0")));		//공제액_주택청약종합저축
//				etwkSvam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etwkSvam"),"0")));		//공제액_근로자주택마련저축
//				etwkBdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etwkBdam"),"0")));		//공제액계_주택마련저축소득공제계
//				
//				etgdH14f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdH14f"),"0")));	//출자.투자금액_2012년도
//				etgdH14b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdH14b"),"0")));	//출자.투자금액_2013년도
//				etclH15f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etclH15f"),"0")));	//출자.투자금액_2014년도
//				etclH15b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etclH15b"),"0")));	//출자.투자금액_2015년도 이후
//				etgdHdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdHdam"),"0")));	//출자.투자금액계
//				
//				etgdD14f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdD14f"),"0")));	//공제액_출자.투자금액_2012년도
//				etgdD14b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdD14b"),"0")));	//공제액_출자.투자금액_2013년도
//				etgdD15f.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdD15f"),"0")));	//공제액_출자.투자금액_2014년도
//				etgdD15b.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdD15b"),"0")));	//공제액_출자.투자금액_2015년도 이후
//				etgdDdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdDdam"),"0")));	//공제액계_출자.투자금액계
//				
//				etctCard.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etctCard"),"0")));	//신용카드
//				etchBcbs.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etchBcbs"),"0")));	//직불카드등
//				etchUeam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etchUeam"),"0")));	//현금영수증
//				etchMgvd.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etchMgvd"),"0")));	//전통시장
//				etchBced.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etchBced"),"0")));	//대중교통
//				etchBcue.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etchBcue"),"0")));	//신용카드등사용금액계
//				etccCard.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etccCard"),"0")));	//신용카드등사용공제액계
//				cardEt13.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("cardEt13"),"0")));	//신용카드등(본인2013년)
//				cardEt14.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("cardEt14"),"0")));	//신용카드등(본인2014년)
//				etadDd13.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etadDd13"),"0")));	//추가공제율(본인2013년)
//				etadD14l.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etadD14l"),"0")));	//추가공제율(본인20134년하)
//				
//				
//				cardEt15.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("cardEt15"),"0")));	//신용카드등(본인2015년)
//				etadD15h.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etadD15h"),"0")));	//추가공제율(본인2015년)
//				etadD15l.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etadD15l"),"0")));	//추가공제율(본인2015년하)
//				
//			}
//		}else if("itemYeta07".equals(tabId)){//그밖의소득공제2
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){
//				
//				etckUnon.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etckUnon"),"0")));	//우리사주조합연출금액
//				etckUncb.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etckUncb"),"0")));	//우리사주조합기부금
//				etepHsam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etepHsam"),"0")));	//고용유지중소기업근로자 임금삭감액
//				etgdCtra.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdCtra"),"0")));	//목돈안드는전세이자상환액
//				etepSest.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etepSest"),"0")));	//장기집합투자증권저축 납입금액
//				etclEtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etclEtam"),"0")));	//기타_금액
//				
//				etclEttl.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("etclEttl")));//기타_필드명
//				
//				etckUnon01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etckUnon01"),"0")));	//공제액_우리사주조합연출금액
//				etckUncr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etckUncr"),"0")));		//공제액_우리사주조합기부금
//				etepMsam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etepMsam"),"0")));		//공제액_고용유지중소기업근로자 임금삭감액
//				etgdHtra.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etgdHtra"),"0")));//공제액_목돈안드는전세이자상환액
//				etepSecr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etepSecr"),"0")));		//공제액_장기집합투자증권저축 납입금액
//				etcdTsum.setValue(0);		//공제액_기타MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("etcdTsum"),"0"))
//			}
//			
//		}else if("itemYeta08_1".equals(tabId)) {//세액감면및세액공제1 - 연금계좌및보험료
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				jrtrCict.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrCict"),"0")));	//과학기술인공제
//				jrtrCtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrCtar"),"0")));	//공제대상_과학기술인공제
//				jrtrHict.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrHict"),"0")));	//공제액_과학기술인공제
//				
//				jrtrPsct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrPsct"),"0")));	//근로자퇴직보장법
//				jrtrPtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrPtar"),"0")));	//공제대상_근로자퇴직보장법
//				jrtrPsrn.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrPsrn"),"0")));	//공제액_근로자퇴직보장법
//				
//				jrtrAnsv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrAnsv"),"0")));	//연금저축계좌
//				jrtrAtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrAtar"),"0")));	//공제대상_연금저축계좌
//				jrtrHnsv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrHnsv"),"0")));	//공제액_연금저축계좌
//				
//				jrtrAtom.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrAtom"),"0")));	//연금계좌제
//				jrtrTotr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrTotr"),"0")));	//공제대상_연금계좌제
//				jrtrHnto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("jrtrHnto"),"0")));	//공제액_연금계좌제
//				
//				spciGurt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciGurt"),"0")));	//일반보장성보험_보험료금액
//				spciRttg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciRttg"),"0")));	//공제대상_일반보장성보험_보험료금액
//				spciGurt01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciGurt01"),"0")));//공제액_일반보장성보험_보험료금액
//				
//				spciHdrc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHdrc"),"0")));	//장애인전용보장성보험_보험료금액
//				spciHdtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHdtg"),"0")));	//공제대상_장애인전용보장성보험_보험료금액
//				spciHdrc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHdrc01"),"0")));//공제액_장애인전용보장성보험_보험료금액
//				
//				spciRtto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciRtto"),"0")));	//연금계좌및보험료_보험료계
//				spciDetg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDetg"),"0")));	//공제대상_연금계좌및보험료_보험료금액
//				spciRtde.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciRtde"),"0")));	//공제액_연금계좌및보험료_보험료금액
//			}
//		}else if("itemYeta08_2".equals(tabId)) {//세액감면및세액공제1 - 의료비
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){
//				
//				spciSelf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciSelf"),"0")));//지출금액_본인의료비
//				spciSftg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciSftg"),"0")));//공제대상_본인의료비
//				spciSelf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciSelf01"),"0")));//세액공제_본인의료비
//	
//				spciAe65.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciAe65"),"0")));//지출금액_65세이상자 의료비
//				spci65tg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spci65tg"),"0")));//공제대상_65세이상자 의료비
//				spciHe65.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHe65"),"0")));//세액공제_65세이상자 의료비
//				
//				spciDbps.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDbps"),"0")));//지출금액_장애인 의료비
//				spciPstg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciPstg"),"0")));//공제대상_장애인 의료비
//				spciHbps.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHbps"),"0")));//세액공제_장애인 의료비
//				
//				spciEtcg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciEtcg"),"0")));//지출금액_그밖의 공제대상자 의료비
//				spciDetc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDetc"),"0")));//공제대상_그밖의 공제대상자 의료비
//				spciDetc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDetc01"),"0")));//세액공제_그밖의 공제대상자 의료비
//				
//				spciEtam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciEtam"),"0")));//의료비금액계
//				spciDtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDtar"),"0")));//공제대상계_의료비금액계
//				spciTxcr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciTxcr"),"0")));//세액공제계_의료비금액계
//			}
//			
//		}else if("itemYeta08_3".equals(tabId)) {//세액감면및세액공제1 - 교육비
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				spedSelf.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedSelf"),"0")));//공납금(대학원포함)
//				spedSftr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedSftr"),"0")));//공제대상_공납금(대학원포함)
//				spedSelf01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedSelf01"),"0")));//세액공제_공납금(대학원포함)
//				
//				spedEdsu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedEdsu"),"0")));//취학전아동_수
//				spedEdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedEdam"),"0")));//취학전아동_금액
//				spedGrde.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedGrde"),"0")));//취학전아동(공제)
//				
//				spedGdsu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedGdsu"),"0")));//초.중.고등학교_수
//				spedGdam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedGdam"),"0")));//초.중.고등학교_금액
//				spedGdto.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedGdto"),"0")));//초.중.고등학교(공제)
//				
//				spedCvsu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedCvsu"),"0")));//대학원(대학원불포함)_수
//				spedCvam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedCvam"),"0")));//대학원(대학원불포함)_금액
//				spedCldv.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedCldv"),"0")));//대학원(대학원불포함)(공제)
//				
//				spciSctr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciSctr"),"0")));//특수교육비_장애인
//				spciScam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciScam"),"0")));//공제대상계_장애인
//				spciSpec.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciSpec"),"0")));//세액공제_장애인
//				
//				
//				
//				siedToam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("siedToam"),"0")));//교육비금액계
//				spedEtar.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedEtar"),"0")));//공제대상계_교육비금액계
//				spedTxcr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spedTxcr"),"0")));//세액공제계_교육비금액계
//			}
//			
//		}else if("itemYeta08_4".equals(tabId)) {//세액감면및세액공제1 - 기부금
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				taxdPltc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdPltc"),"0")));//정지차금(10만원이하)_기부금액
//				taxd10tg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxd10tg"),"0")));//정지차금(10만원이하)_공제대상금액
//				taxdPltc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdPltc01"),"0")));//정지차금(10만원이하)_공제세액
//				
//				spciPltc.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciPltc"),"0")));//정지차금(10만원초과)_기부금액
//				spciPltg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciPltg"),"0")));//정지차금(10만원초과)_공제대상금액
//				spciPltc01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciPltc01"),"0")));//정지차금(10만원초과)_공제세액
//				
//				spciFbam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciFbam"),"0")));//전액공제기부금액(법정)_기부금액
//				spciFbtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciFbtg"),"0")));//전액공제기부금액(법정)_공제대상금액
//				spciFbam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciFbam01"),"0")));//전액공제기부금액(법정)_공제세액
//				
//				spciExam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciExam"),"0")));//특례기부금(공익법인신탁제외)_기부금액
//				spciExtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciExtg"),"0")));//특례기부금(공익법인신탁제외)_공제대상금액
//				spciExam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciExam01"),"0")));//특례기부금(공익법인신탁제외)_공제세액
//				
//				spciHfam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHfam"),"0")));//우리사주조합기부금_기부금액
//				spciHftg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciHftg"),"0")));//우리사주조합기부금_공제대상금액
//				spciRfam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciRfam"),"0")));//우리사주조합기부금_공제세액
//				
//				spciNamt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciNamt"),"0")));//종교단체외지정기부금_기부금액
//				spciNatg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciNatg"),"0")));//종교단체외지정기부금_공제대상금액
//				spciNamt01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciNamt01"),"0")));//종교단체외지정기부금_공제세액
//				
//				spciYamt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciYamt"),"0")));//종교단체지정기부금_기부금액
//				spciYatg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciYatg"),"0")));//종교단체지정기부금_기부금액_공제대상금액
//				spciYamt01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciYamt01"),"0")));//종교단체지정기부금_기부금액_공제세액
//				
//				spciDgam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDgam"),"0")));//기부금액계
//				spciDgtg.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDgtg"),"0")));//공제대상계_기부금액계
//				spciDgcr.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciDgcr"),"0")));//세액공제계_기부금액계
//				
//				spciObam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciObam"),"0")));//이월법정기부금액
//				spciOyam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciOyam"),"0")));//이월지정기부금(종교 외)
//				spciOnam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciOnam"),"0")));//이월지정기부금(종교)
//				spciObam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciObam01"),"0")));//이월법정기부금액_공제세액
//				spciOyam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciOyam01"),"0")));//이월지정기부금(종교 외)_공제세액
//				spciOnam01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciOnam01"),"0")));//이월지정기부금(종교외)_공제세액
//				
//				spciSsum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("spciSsum"),"0")));//기부금(이월분)
//			
//			}
//		}else if("itemYeta09".equals(tabId)){//세액감면및세액공제2
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				//YetaUtils.setCheckedCheckBoxValue(taxdIncd, MSFSharedUtils.allowNulls((String) selRecord.get("taxdIncd")));//입국목적
//				taxdIncd1.setValue((Boolean)selRecord.get("taxdIncd1"));
//				taxdIncd2.setValue((Boolean)selRecord.get("taxdIncd2"));
//				taxdIncd3.setValue((Boolean)selRecord.get("taxdIncd3"));
//				taxdIncd4.setValue((Boolean)selRecord.get("taxdIncd4"));
//				taxdWkdt.setValue(GWTUtils.getDateFromString((String) selRecord.get("taxdWkdt"), "yyyyMMdd"));//기술도입계약 또는 근로제공일
//				tamaEddt.setValue(GWTUtils.getDateFromString((String) selRecord.get("tamaEddt"), "yyyyMMdd"));//감면기간 만료일
//				tamaIndt.setValue(GWTUtils.getDateFromString((String) selRecord.get("tamaIndt"), "yyyyMMdd"));//외국인근로소득에 대한 감면 신청서 접수일자
//				tamaOudt.setValue(GWTUtils.getDateFromString((String) selRecord.get("tamaOudt"), "yyyyMMdd"));//제출일자_외국인근로소득에 대한 감면 신청서 접수일자
//				txlgFrrd.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgFrrd"), "yyyyMMdd"));//해저광물자원개발에 대한 감면 확인일자
//				txlgFrid.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgFrid"), "yyyyMMdd"));//신청일자_해저광물자원개발에 대한 감면 확인일자
//				txlgWkid.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgWkid"), "yyyyMMdd"));//근로소득에 대한 조세조약상 면제 접수일자
//				txlgTxtd.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgTxtd"), "yyyyMMdd"));//제출일자_근로소득에 대한 조세조약상 면제 접수일자
//				
//				txlgBscd.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgBscd"), "yyyyMMdd"));//중소기업 취업 청년감면 취업일자
//				txlgBcde.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgBcde"), "yyyyMMdd"));//감면기간 종료일_중소기업 취업 청년감면 취업일자
//				
//				txlgItct.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgItct"),"0")));//소득세법 감면세액
//				taxdIcax.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdIcax"),"0")));//감면세액_소득세법 감면세액
//				
//				txlgBsta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgBsta"),"0")));//취업청년감면대상총급여
//				txlgWkta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgWkta"),"0")));//근로자총급여_취업청년감면대상총급여
//				
//				txlgClta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgClta"),"0")));//계산 감면세액
//				taxdTsum.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdTsum"),"0")));//감면세액_계산 감면세액
//				
//				txlgFrta.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgFrta"),"0")));//외국인기술자 감면세액
//				taxdRedu.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdRedu"),"0")));//감면세액_외국인기술자 감면세액
//				
//				txlgTxty.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgTxty"),"0")));//조세조약 감면세액
//				txlgHxtt.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgHxtt"),"0")));//감면세액_조세조약 감면세액
//			
//				txlgInam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgInam"),"0")));//국외원천소득
//				txlgDlam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgDlam"),"0")));//납세액(외화)
//				txlgWnam.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("txlgWnam"),"0")));//납세액(원화)
//				txlgOtcy.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("txlgOtcy")));//납세국명
//				txlgOtdt.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgOtdt"), "yyyyMMdd"));//납부일
//				txlgApdt.setValue(GWTUtils.getDateFromString((String) selRecord.get("txlgApdt"), "yyyyMMdd"));//신청서제출일
//				txlgOtcy.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("txlgOtcy")));//국외근무처
//				txapWkdy.setValue(MSFSharedUtils.allowNulls((String) selRecord.get("txapWkdy")));//직책
//				txapStdt.setValue(GWTUtils.getDateFromString((String) selRecord.get("txapStdt"), "yyyyMMdd"));//근무기간_시작_외국납부세액공제
//				txapEddt.setValue(GWTUtils.getDateFromString((String) selRecord.get("txapEddt"), "yyyyMMdd"));//근무기간_종료_외국납부세액공제
//				
//				taxdUnin.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdUnin"),"0")));//납세조합원천징수세액(10%)
//				taxdUnin01.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdUnin01"),"0")));//납세조합공제액
//				taxdLoaa.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdLoaa"),"0")));//주택자금차입금이자세액공제 이자상환
//				taxdLoan.setValue(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(selRecord.get("taxdLoan"),"0")));//주택자금차입금이자세액공제 공제액
//				
//			}
//			
//		}else if("itemYeta10".equals(tabId)){//추가제출서류
//			
//			if (MSFSharedUtils.paramNotNull(selRecord)){	
//				
//				YetaUtils.setCheckedRadioValue(frnrSgyn, (String) selRecord.get("frnrSgyn"));		//1.외국인근로자 단일세율적용신청서 제출여부
//				YetaUtils.setCheckedRadioValue(addcNtyn, (String) selRecord.get("addcNtyn"));		//2.연금, 저축 등 소득공제 명세서 제출여부
//				YetaUtils.setCheckedRadioValue(spciReyn, (String) selRecord.get("spciReyn"));		//3.월세액.비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부
//				
//				YetaUtils.setCheckedRadioValue(addcMdyn, (String) selRecord.get("addcMdyn"));		//의료비지급명세서
//				YetaUtils.setCheckedRadioValue(addcCtyn, (String) selRecord.get("addcCtyn"));		//기부금명세서
//				YetaUtils.setCheckedRadioValue(addcPfyn, (String) selRecord.get("addcPfyn"));		//소득공제 증빙서류
//				
//				YetaUtils.setCheckedRadioValue(incoOufg, (String) selRecord.get("incoOufg"));		//소득공제신고서제출여부
//				incoOudt.setValue(GWTUtils.getDateFromString((String) selRecord.get("incoOudt"), "yyyyMMdd"));	//제출일자_소득공제신고서제출여부
//			}
//		}
//		
//	}
	
			
	//인적공제명세 grid 조회
	private void reloadYeta3220_item02Grid(){
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		IColumnFilter filters = null;
		
		yeta1300ToYeta3220GridPanel1.getTableDef().setTableColumnFilters(filters);
		
		yeta1300ToYeta3220GridPanel1.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYeta3220GridPanel1.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYeta3220GridPanel1.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.allowNulls(settGbcd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta1300ToYeta3220GridPanel1.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(edacRvyy.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		yeta1300ToYeta3220GridPanel1.reload();
		
//		Iterator<Record> iterRecords = yeta1300ToYeta3220GridPanel1.getMsfGrid().getGrid().getStore().getRecord(model); 
//        
//		beforeJumin = new ArrayList<Ye16Ta3220DTO>();  
//		
//		while (iterRecords.hasNext()) {
//		       
//			Record recData = (Record) iterRecords.next(); 
//			BaseModel bmMapModel = (BaseModel)recData.getModel();
//	               
//			Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
//                
//	        yeta3220Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
//	        yeta3220Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
//	        yeta3220Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
//	        yeta3220Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
//	            
//	        yeta3220Dto.setRsnoNumb(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb")));    	/** column 주민등록번호 : rsnoNumb */
//	        yeta3220Dto.setRelhCode(MSFSharedUtils.allowNulls(bmMapModel.get("relhCode")));    	/** column 관계 : relhCode */
//	        yeta3220Dto.setKornName(MSFSharedUtils.allowNulls(bmMapModel.get("kornName")));    	/** column 성명 : kornName */
////	            yeta3220Dto.setFrnrCode(MSFSharedUtils.allowNulls(bmMapModel.get("frnrCode")));    	/** column 내외국인구분코드 : frnrCode */
////	            
////	            yeta3220Dto.setBaseDdyn((Boolean) bmMapModel.get("baseDdyn"));    /** column 기본공제여부 : baseDdyn */
////	            yeta3220Dto.setPsclDdyn(MSFSharedUtils.allowNulls(bmMapModel.get("psclDdyn$commCd")));    	/** column 장애인공제여부 : psclDdyn */
////	            yeta3220Dto.setBrddCtyn((Boolean) bmMapModel.get("brddCtyn"));    /** column 자녀양육비공제여부 : brddCtyn */
////	            yeta3220Dto.setFaddCtyn((Boolean) bmMapModel.get("faddCtyn"));    /** column 부녀자공제여부 : faddCtyn */
////	            yeta3220Dto.setRpctDdyn((Boolean) bmMapModel.get("rpctDdyn"));    /** column 경로우대공제여부 : rpctDdyn */
////	            yeta3220Dto.setBithDdyn((Boolean) bmMapModel.get("bithDdyn"));    /** column 출산입양자공제여부 : bithDdyn */
////	            yeta3220Dto.setPantOnyn((Boolean) bmMapModel.get("pantOnyn"));    /** column 한부모공제여부 : pantOnyn */
//                
//	            beforeJumin.add(yeta3220Dto);
//		}  
	}
	
	
	
	
	//소득공제 grid 조회
	private void reloadYeta3220_item03Grid(){
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		IColumnFilter filters = null;
		
		yeta1300ToYeta3220GridPanel2.getTableDef().setTableColumnFilters(filters);
		
		yeta1300ToYeta3220GridPanel2.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYeta3220GridPanel2.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYeta3220GridPanel2.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.allowNulls(settGbcd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta1300ToYeta3220GridPanel2.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(edacRvyy.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		yeta1300ToYeta3220GridPanel2.reload();
		
		yeta1300ToYeta3220GridPanel3.getTableDef().setTableColumnFilters(filters);
		
		yeta1300ToYeta3220GridPanel3.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYeta3220GridPanel3.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYeta3220GridPanel3.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.allowNulls(settGbcd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta1300ToYeta3220GridPanel3.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(edacRvyy.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		yeta1300ToYeta3220GridPanel3.reload();
		
//		yeta1300ToYeta3220GridPanel4.getTableDef().setTableColumnFilters(filters);
//		
//		yeta1300ToYeta3220GridPanel4.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
//		yeta1300ToYeta3220GridPanel4.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
//		yeta1300ToYeta3220GridPanel4.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.allowNulls(settGbcd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//		yeta1300ToYeta3220GridPanel4.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(edacRvyy.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			
//		yeta1300ToYeta3220GridPanel4.reload();
	}
	
	
	
	//가족교육비 grid 조회
	private void reloadYeta3150Grid(){
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		IColumnFilter filters = null;
		
		yeta1300ToYeta3150GridPanel.getTableDef().setTableColumnFilters(filters);
			
		yeta1300ToYeta3150GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		yeta1300ToYeta3150GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta1300ToYeta3150GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.allowNulls(settGbcd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		yeta1300ToYeta3150GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(edacRvyy.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		yeta1300ToYeta3150GridPanel.reload();
	}
	
	
	//검색조건 초기화
	public void resetSearchForm() { 

		 srhEdacRvyy.setValue(lsClutYrStore.findModel("year",String.valueOf(Integer.parseInt(DateTimeFormat.getFormat("yyyy").format(new Date())) - 1)));
		 srhSettGbcd.setValue(lsSettGbcd.getAt(0));
		 
	}
	
	//대상자정보 grid 초기화
	public void resetYeta300ToYe16Ta2000Grid() {
		yeta1300ToYe16Ta2000GridPanel.getMsfGrid().clearData();
	}
	
	//기본사항 초기화
	public void resetItemYeta01() {  
		 
		//hiddin 초기화 
		edacRvyy.setValue("");		/** column 연말정산귀속년도 : edacRvyy */
		settGbcd.setValue("");		/** column 정산구분코드 : settGbcd */
		systemkey.setValue("");	  	/**  column SYSTEMKEY : systemkey */
		dpobCd.setValue("");		/**  column 사업장코드 : dpobCd */
		hanNm.setValue("");			/**  column 성명 : dpobCd */
		deptNm.setValue("");		/**  column 부서명 : dpobCd */
	    edacSeilNum.setValue(0L);	/** set 연말정산마감일련번호 : edacSeilNum */
	    
	    
	    
	    ((Radio)gnanSgtf.get(0)).setValue(true); 		//세대주여부
		natnGbcd.setValue("");		//국적코드
		natnName.setValue("");		//국적명
		natnItem.setValue("");		//국적코드 두자리
		    
		reymStdt.clear();	//귀속년월 시작일자
		reymEddt.clear();	//귀속년월 종료일자 
		    
		rutrStdt.clear();	//감면 시작 일자 
		rutrEddt.clear();	//감면 종료 일자
		
		((Radio)resdFlag.get(0)).setValue(true); //거주구분여부
		    
		redtGbcd.setValue("");		//거주지국코드
		redtName.setValue("");		//거주지국명
		redtItem.setValue(""); 		//거주지국 두자리
		
		//-------- 2016년 추가 ---------------------------
		yrenSgyn.setValue(false); 	                /** column 연말정산분할납부신청여부 : yrenSgyn */
		addIncmTxApptnRtoCd.reset();    	/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
		frnrRnyn.setValue(false); 		                    /** column 외국인법인소속파견근로자여부 : frnrRnyn */
		//-------- 2016년 추가 ---------------------------
		
		dcsnTots.clear(); 	//종근무지_급여총액
		currTots.clear();	//주근무지_급여총액
		totlSala.clear();	//총급여_현_전
		    	
		wkerDdct.clear();	//근로소득공제
		wkerAmnt.clear(); //근로소득금액
		taxdWken.clear();	//세액공제_근로소득세액공제
		
		stndIncm.clear();	//세액공제_근로소득세액공제
		prddTaxn.clear();	//세액공제_근로소득세액공제
		    	
		dcsnItax.clear();	//결정세액_소득세
		dcsnBtax.clear();	//결정세액_주민세_지방소득세
		    	
		alryPinx.clear();	//기납부세액_소득세
		alryPhbx.clear();	//기납부세액_주민세_지방소득세
		
		yeta1300GridPanel.getMsfGrid().clearData();
		
		
		// { 인적공제}

		    yeta1300ToYeta3220GridPanel1.getMsfGrid().clearData(); 
		    
		    addrMrct.clear(); 
		    addrMccr.clear(); 
		    
		    humnCgue0.setValue(true);
		    humnCgue1.setValue(false);
		    
		//   {소득공제}
		   
//		   yeta1300ToYeta3220GridPanel4.getMsfGrid().clearData(); 
		   yeta1300ToYeta3220GridPanel2.getMsfGrid().clearData(); 
		   yeta1300ToYeta3220GridPanel3.getMsfGrid().clearData(); 

		   //{연금보험료}
		   
		    bnatPsnf.clear();	
		    bnatDdct.clear();	
		    jnatPsnf.clear();	
		    jnatDdct.clear();	


		  bpssPulc.clear();	  //공무원연금
		  bpssSold.clear();	  //군인연금
		  bpssTech.clear();	  //교직원연금
		  bpssFect.clear();	   //별정우체국

		  jpssFect.clear();	
		  jpssPulc.clear();	
		  jpssSold.clear();	
		  jpssTech.clear();	

		  bpssHpul.clear();	
		  bpssHsol.clear();	
		  bpssHtec.clear();	
		  bpssDdct.clear();	

		  jpssHpul.clear();	
		  jpssHsol.clear();	
		  jpssHtec.clear();	
		  jpssDdct.clear();	


		 // BRTR_CICT.Text := '';  //과학기술인공제
		 // BrtrPsct.Text := '';   //근로자퇴직보장법
		 // BRTR_ANSV.Text := '';  //연금저축계좌
		 // BRTR_HICT.Text := '';
		 // BrtrPsrn.Text := '';
		 // BRTR_HNSV.Text := '';

		  jrtrAnsv.clear();	
		  jrtrHnsv.clear();	



		  jrtrPsct.clear();	
		  jrtrCict.clear();	
		  jrtrHict.clear();	
		  jrtrPsrn.clear();	

		  rrptAmnt.clear();	
		  rrptYnam.clear();	
		
		  
//		  //{특별공제 보험료}
//
//		 edSpciBhlh.Text := '';
//		 edSpciBhth.Text := '';
//		 edSpciHhlh.Text := '';
//		 edSpciJhth.Text := '';
//
//
//		 edSpciBepf.Text := '';
//		 edSpciHepf.Text := '';
//		 edSpciJepf.Text := '';
//		 edSpciJepf01.Text := '';
//
//		 edSpciGurt.Text := '';
//		 edSpciGurt01.Text := '';
//
//		 edSpciHdrc.Text := '';
//		 edSpciHdrc01.Text := '';
//
//		 edSpciIuam.Text := '';
//		 edSpciHrto.Text := '';
//
//		 {특별공제 의료비}
//		  edSpciSelf.Text := '';
//		  edSpciSelf01.Text := '';
//
//		  edSPCI_AE65.Text := '';
//		  edSPCI_HE65.Text := '';
//
//		  edSPCI_DBPS.Text := '';
//		  edSPCI_HBPS.Text := '';
//
//		  edSpciDetc.Text := '';
//		  edSpciDetc01.Text := '';
//
//		  edSpciEtam.Text := '';
//		 // edSpciMeto01.Text := '';
//		  {특별공제 교육비}
//
//		   edSpedSelf.Text := '';
//		   edSpedSelf01.Text := '';
//
//		   advclmngrdPayr0653003.ClearNormalRows(1,1);
//
//		   edSpedEdam.Text := '';
//		   edSpedGrde.Text := '';
//		   edSpedGdam.Text := '';
//		   edSpedGdto.Text := '';
//		   edSpedCvam.Text := '';
//		   edSpedCldv.Text := '';
//
//		   edSpciScam.Text := '';
//		   edSpciSpec.Text := '';
//
//		   edSiedToam.Text := '';
//		  // edSpedToam.Text := '';
//
//		  {특별공제 주택자금 }
//		  edSpciRefn.Text := '';
//		  edSpciRefn01.Text := '';
//		  edSPCI_HTAM.Text := '';
//		  edSPCI_RTAM.Text := '';
//
//		  edSpchRe06.Text := '';
//		  edSpchRe10.Text := '';
//		  edSpchRe15.Text := '';
//		  edSPCH_REFX.Text := '';
//		  edSPCH_REEC.Text := '';
//		  edSpchRefn.Text := '';
//		  edSpchReto.Text := '';
//
//		  edSpciReSf.Text  := '';
//		  edSpciReSf01.Text  := '';
//		  edSpchRe29.Text   := '';
//		  edSpchRe30.Text   := '';
//		  edSPCI_REFX.Text := '';
//		  edSPCI_REEC.Text := '';
//
//		  {특별공제 기부금 }
//		  edSpciPltc.Text := '';
//		  edSpciPltc01.Text := '';
//		  edSpciFbam.Text := '';
//		  edSpciFbam01.Text := '';
//		  edSpciExam.Text := '';
//		  edSpciExam01.Text := '';
//		  edSpciUnon.Text := '';
//		  edSpciUnon01.Text := '';
//		  edSPCI_HFAM.Text := '';
//		  edSPCI_RFAM.Text := '';
//		  edSpciNamt.Text := '';
//		  edSpciNamt01.Text := '';
//		  edSpciYamt.Text := '';
//		  edSpciYamt01.Text := '';
//		 // edSpciSsum.Text := '';
//		  {그밖의 소득 공제 }
//
//		  edPrvm20be.Text := '';
//		  edEtcpPsnv.Text := '';
//		  //edPrvm21af.Text := '';
//		  //edEtcpNsav.Text := '';
//		  //edPrcmToam.Text := '';
//
//		  edEtchPrep.Text := '';
//		  edEtchPrep01.Text := '';
//
//		  edETCS_COMP.Text := '';
//		  edETCS_COMP01.Text := '';
//		  edETWK_HSVM.Text := '';
//		  edETWK_SVAM.Text := '';
//		  edETWK_HSBM.Text := '';
//		  edETWK_SBAM.Text := '';
//		 // edETWK_HLGM.Text := '';
//		 // edETWK_LGAM.Text := '';
//		  edETWK_HBDM.Text := '';
//		  edETWK_BDAM.Text := '';
//
//		  //투자조합출자공제
//		  //edETCT_CONC.Text := '';
//		  //edETCT_CONC01.Text := '';
//		  edETGD_H09F.Text := '';
//		  edETGD_09AF.Text := '';
//
//		  edETGD_H13F.Text := '';
//		  edETGD_H13H.Text := '';
//
//		  edETGD_HDAM.Text := '';
//		  edETGD_DDAM.Text := '';
//
//		  edETCT_CARD.Text := '';
//		  edETCH_BCBS.Text := '';
//		  edETCH_UEAM.Text := '';
//		  edETCH_BCED.Text := '';
//		  edETCH_BCUE.Text := '';
//		  edETCC_CARD.Text := '';
//		  edETCH_MGVD.Text := '';
//
//		  //목돈안드는 전세이자 상환액
//		  edETGD_CTRA.Text := '';
//		  edETGD_HTRA.Text := '';
//
//		  {세액감면 및 세액공제 }
//
//		  edETCK_UNON.Text := '';
//		  edETCK_UNON01.Text := '';
//		  //edEtclHm01.Text := '';
//		  //edEtclHm02.Text := '';
//		  //edEtclHm03.Text := '';
//		  //edEtclHmta.Text := '';
//		  //edEtclHmto.Text := '';
//
//		  edETEP_HSAM.Text := '';
//		  edETEP_MSAM.Text := '';
//		  edETCL_ETTL.Text := '';
//
//		  edETCL_ETAM.Text := '';
//		  edETCD_TSUM.Text := '';
//
//		  edTxlgInam.Text := '';
//		  edTxlgDlam.Text := '';
//		  edTxlgWnam.Text := '';
//		  edTxlgOtcy.Text := '';
//		  edTxlgOtdt.Text := '';
//		  edTxlgOtdt01.Date :=  Date;
//		  edIncoOudt.Text := '';
//		  edIncoOudt01.Date :=  Date;
//		  edTxlgOuwk.Text := '';
//		  edTxapWkdy.Text := '';
//
//		  edTxapStdt.Text := '';
//		  edTxapStdt01.Date :=  Date;
//		  edTxapEddt.Text := '';
//		  edTxapEddt01.Date :=  Date;
//
//
//		  edTaxdLoaa.Text := '';
//		  edTaxdLoan.Text := '';
//		  edTaxdPltc.Text := '';
//		  edTaxdPltc01.Text := '';
//		  //외국인 근로자
//		  chkTaxdInc01.Checked := False;
//		  chkTaxdInc02.Checked := False;
//		  chkTaxdInc03.Checked := False;
//		  chkTaxdInc04.Checked := False;
//
//		  edTaxdWkdt.Text := '';
//		  edTaxdWkdt01.Date :=  Date;
//		  edTamaEddt.Text := '';
//		  edTamaEddt01.Date :=  Date;
//
//		  edTXLG_FRRD.Text := '';
//		  edTXLG_FRRD01.Date :=  Date;
//
//		  edTXLG_FRID.Text := '';
//		  edTXLG_FRID01.Date :=  Date;
//
//		  edTXLG_WKID.Text := '';
//		  edTXLG_WKID01.Date :=  Date;
//
//		  edTXLG_TXTD.Text := '';
//		  edTXLG_TXTD01.Date :=  Date;
//
//		  //중소기업청년
//		  edTXLG_BSCD.Text := '';
//		  edTXLG_BSCD01.Date :=  Date;
//
//		  edTXLG_BCDE.Text := '';
//		  edTXLG_BCDE01.Date :=  Date;
//
//		  edTamaIndt.Text := '';
//		  edTamaIndt01.Date :=  Date;
//		  edTamaOudt.Text := '';
//		  edTamaOudt01.Date :=  Date;
//		  edtTAXD_UNIN.Text := '';
//		  edtTAXD_UNIN01.Text := '';
//
//		  //세액감면
//		  edTXLG_ITCT.Text := '';
//		  edTAXD_ICAX.Text := '';
//		  edTXLG_BSTA.Text := '';
//		  edTXLG_WKTA.Text := '';
//		  edTXLG_CLTA.Text := '';
//		  edTXLG_CL30.Text := '';
//		  edTXLG_FRTA.Text := '';
//		  edTAXD_SPCT.Text := '';
//		  edTXLG_TXTT.Text := '';
//		  edTXLG_HXTT.Text := '';
//
//		    edSPCI_RTDE.Text := '';
//		    edSPCI_TXCR.Text := '';
//		    edSPED_TXCR.Text := '';
//
//		    edSPCI_DGCR.Text := '';
//		    edETGD_D14F.Text := '';
//		    edETCK_UNCR.Text := '';
//		    edETEP_SECR.Text := '';
//		    edADDR_MCCR.Text := '';
//		   // edSPCI_DCTO.Text := '';
//		    edJRTR_HNTO.Text := '';
//
//
//		    edJRTR_CTAR.Text := '';
//		    edJRTR_PTAR.Text := '';
//		    edJRTR_ATAR.Text := '';
//		    edJRTR_ATOM.Text := '';
//		                    
//		    edJRTR_TOTR.Text := '';
//
//		    edSPCI_RTTG.Text := '';
//		    edSPCI_HDTG.Text := '';
//		    edSPCI_DETG.Text := '';
//		    edSPCI_RTTO.Text := '';
//
//		    edSPCI_DTAR.Text := '';
//
//
//		    edSPED_ETAR.Text :=  '';
//		    edTAXD_10TG.Text := '';
//		    edSPCI_PLTG.Text := '';
//		    edSPCI_FBTG.Text := '';
//		    edSPCI_DGTG.Text := '';
//		    edETGD_H14F.Text := '';
//		    edCARD_ET13.Text := '';
//		    edCARD_ET14.Text := '';
//		    edETAD_DD13.Text := '';
//		    edETAD_D14L.Text := '';
//		    edETCK_UNCB.Text := '';
//		 //   edTXLG_TXTY.Text := '';
//		    edETEP_SEST.Text := '';
//		    edSPCI_DGAM.Text := '';
//		                    
//		    edSPCI_SFTG.Text := '';
//		    edSPCI_65TG.Text := '';
//		    edSPCI_PSTG.Text := '';
//		    edSPCI_ETCG.Text := '';
//
//		    edSPCI_EXTG.Text :=  '';
//		    edSPCI_UNTG.Text :=  '';
//		    edSPCI_HFTG.Text :=  '';
//		    edSPCI_NATG.Text :=  '';
//		    edSPCI_YATG.Text :=  '';
//
//
//		    edSPED_SFTR.Text := '';
//		    edSPED_EDTR.Text :=  '';
//		    edSPED_GDTR.Text :=  '';
//		    edSPED_CVTR.Text :=  '';
//		    edSPCI_SCTR.Text := '';
//		    edSpciSsum.Text := '';
 
//
//		  {추가서류제출여부}
//		  chkFRNR_SGYN01.Checked := True;
//		  chkFRNR_SGYN02.Checked := False;
//
//		  chkADDC_NTYN01.Checked := True;
//		  chkADDC_NTYN02.Checked := False;
//
//		  chkTXLG_MXTM01.Checked := True;
//		  chkTXLG_MXTM02.Checked := False;
//
//		  chkADDC_MDYN01.Checked := True;
//		  chkADDC_MDYN02.Checked := False;
//
//		  chkADDC_CTYN01.Checked := True;
//		  chkADDC_CTYN02.Checked := False;
//
//		  chkADDC_PFYN01.Checked := True;
//		  chkADDC_PFYN02.Checked := False;

		
		
		
	}
	
	
	
	private void funcSetPopUpRecord() {
		   
		BaseModel ppRecord = new BaseModel();

		ppRecord.set("dpobCd", dpobCd.getValue());
		ppRecord.set("settGbcd", settGbcd.getValue());
		ppRecord.set("systemkey", systemkey.getValue());
		ppRecord.set("edacRvyy", edacRvyy.getValue());
		ppRecord.set("deptNm", deptNm.getValue());
		ppRecord.set("hanNm", hanNm.getValue());

		setPPRecord(ppRecord);
   }
	
	
	private void reFresh() {
	//	private void reFresh(final String tabId) {
		
		Ye16Ta2000BM yeta2000Bm = new Ye16Ta2000BM();
   	   
		yeta2000Bm.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year"));
		yeta2000Bm.setSettGbcd(MSFSharedUtils.getSelectedComboValue(srhSettGbcd, "commCd"));
    		
		yeta2000Bm.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		yeta2000Bm.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		
		
    	String strDeptCd =YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
    	yeta2000Bm.setDeptCd(strDeptCd);
    	
    	String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
    	yeta2000Bm.setTypOccuCd(strTypOccuCd);
    	
    	String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
    	yeta2000Bm.setDtilOccuInttnCd(strDtilOccuInttnCd); 
    	
    	
    	yeta2000Bm.setBusinCd(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
    	yeta2000Bm.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));
    	yeta2000Bm.setHanNm(MSFSharedUtils.allowNulls(srhHanNm.getValue()));
    	yeta2000Bm.setResnRegnNum(MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
    	
    	if (MSFSharedUtils.paramNotNull(yeta1300ToYe16Ta2000GridPanel.getCurrentlySelectedItem())){	
    		
    		   yeta1300Service.resultListYeta2000(yeta2000Bm, new AsyncCallback<Ye16Ta2000BM>() {

    			@Override
    			public void onFailure(Throwable caught) {
    				// TODO Auto-generated method stub
    				MessageBox.alert("정보 가져오기", "정보가져오기 실패", null);
    			}
    			

    			@Override
    			public void onSuccess(Ye16Ta2000BM result) {
    			// TODO Auto-generated method stub
    				
    				//선택된 탭에 따라 대상자 정보 출력
    			//	yeta1300ToYe16Ta2000Detail2(result, tabId);
    				yeta1300ToYe16Ta2000Detail2(result);
    				
    				  
    			} 
    		});
    	}
    	
		
		
		
	}

	public native String getDetailTemplate() /*-{
												return ['<div class="details">',
												'<tpl for=".">',
												'<img src="{modPath}"><div class="details-info">',
												'<b>Image Name:</b>',
												'<span>{name}</span>',
												'<b>Size:</b>',
												'<span>{sizeString}</span>',
												'<b>Last Modified:</b>',
												'<span>{dateString}</span></div>',
												'</tpl>',
												'</div>'].join("");
												}-*/;
	


	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 화면별 에러로그 확인 처리 를위해 추가 된 부분....
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : funcLogMessage
	 * @date : 2016. 9. 2.
	 * @author : Administrator
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 9. 2.		Administrator				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param wndName
	 * @param wndId
	 */
	public void funcLogMessage(String wndName, String wndId){
	
		 ShowMessageBM smForm = new ShowMessageBM();
		 smForm.setWindowId(wndId);
		 smForm.setWindowNm(wndName);
		//개별 화면 에러메시지 검색 팝업  
		GWTUtils.funcLogMessage(smForm);
	}  
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
 
}