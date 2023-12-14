package com.app.exterms.yearendtax.client.form.yeta2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0120DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta2000BM;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161020DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161030BM;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161030DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161040BM;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161040DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161055DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161060DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161070DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161080DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta2000Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2022.Ye161010Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2022.Ye161030Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2022.Ye161040Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2022.Ye161090Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2022.Ye169010Def;
import com.app.exterms.yearendtax.client.service.yeta2022.Yeta7300Service;
import com.app.exterms.yearendtax.client.service.yeta2022.Yeta7300ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.login.ChangePwd;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
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


/**
 *
 * @Class Name : Yeta7300.java
 * @since : 2018. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Yeta7300 extends MSFPanel {

	private VerticalPanel vp;
	private FormPanel plFrmYeta7300;
	private String txtForm = "";
	private String txprDscmNoCntn = "";
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
	private TabPanel tabsYeta7300 = new TabPanel();		// 전체
	private TabPanel tabsItemYeta05 = new TabPanel();	// 특별소득공제 하위
	private TabPanel tabsItemYeta08 = new TabPanel();	// 세액감면및세액공제1 하위
	// -------------- 탭 종료 --------------

	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topYeta7300Bar;
	private Button btnYeta7300All; 	// 일괄자료정리
	private Button btnYeta7300Reset; 	// 초기화
	private Button btnYeta7300New; 		// 신규
	private Button btnYeta7300Save; 	// 저장
	private Button btnYeta7300Del; 		// 삭제
	private Button btnYeta7300Sreach; 	// 조회
	private Button btnYeta7300Print; 	// 인쇄
	
	private RadioGroup printType;		// 대상자 선택
	// -------------- 상단 버튼 종료 --------------

	// -------------- 중간 버튼 시작 --------------
	private Button btnYeta7300_01;			// 의료비지급명세서
	private Button btnYeta7300_02; 			// 기부금명세서
	private Button btnYeta7300_03; 			// 재계산대상자
	private Button btnYeta7300_04; 			// 삭제
	private Button btnYeta7300_05; 			// 세액계산
	private Button btnYeta7300_06; 			// 세액재계산
	private Button btnYeta7300_07; 			// 원천징수인쇄
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
	
//	private Yeta2000DTO yeta2000Dto;
//	private Yeta3000DTO yeta3000Dto;
//	private Yeta2000BM yeta2000Bm;
	// -------------- DTO 선언 종료 --------------
	
	
	// -------------- grid 선언 시작  ---------------
	private Ye161010Def ye161010Def  		= new Ye161010Def("Yeta7300"); 		// 대상자 정보 그리드 테이블 컬럼 define
	private Yeta2000Def Ye161010Def_02  	= new Yeta2000Def("YETA300001"); 	// 대상자 정보 그리드 새로고침을 위한 define
	private Ye169010Def ye169010Def  		= new Ye169010Def("Yeta7300");		// 세액계산 정보 그리드 테이블 컬럼 define 
	private Ye161030Def ye161030Def  		= new Ye161030Def("Yeta7300");		// 인적공제 정보 그리드 테이블 컬럼 define
	
	private Ye161040Def ye161040Def_01  	= new Ye161040Def("Yeta730001"); 	// 소득공제명세 그리드 테이블 컬럼 define(국세청자료)  
	private Ye161040Def ye161040Def_02  	= new Ye161040Def("Yeta730002"); 	// 소득공제명세 그리드 테이블 컬럼 define(기타자료)
	private Ye161090Def ye161090Def  		= new Ye161090Def("Yeta7300");
	
	
	private MSFGridPanel Yeta7300ToYe169010GridPanel;
	private MSFGridPanel Yeta7300ToYe161010GridPanel;		// 대상자정보 GridPanel
	private MSFGridPanel Yeta7300ToYe161030GridPanel;		// 인적공제 GridPanel
	private MSFGridPanel Yeta7300ToYe161040GridPanel_01;	// 소득공제 - 국세청 GridPanel
	private MSFGridPanel Yeta7300ToYe161040GridPanel_02;	// 소득공제 - 기타자료 GridPanel
//	private MSFGridPanel Yeta7300ToYe161090GridPanel;		// 가족교육비 GridPanel
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
	private MSFComboBox<BaseModel> srhYrtxBlggYr;			//정산년
	private ComboBox<BaseModel> srhClutSeptCd; 				//정산구분 
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
    private HiddenField<String> resnRegnNum;				// 주민등록번호    
    private TextField<String> txtResnRegnNum;				// 입력받는주민등록번호 
    
    private MSFTextField utDpobCd; // 부서명
	private MSFTextField utDpobNm; // 부서명
	private Button btnUtDpobCd;  
    
    
    private HiddenField<String> closFlag; 					//마감여부
    
    
	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;

	private boolean mutilCombo = false;
	
	private HiddenField<String>	 dpobCd;				/**  column 사업장코드 : dpobCd */
	private HiddenField<String> yrtxBlggYr;				/** column 연말정산귀속년도 : edacRvyy */
	private HiddenField<String> clutSeptCd;				/** column 정산구분코드 : settGbcd */
	private HiddenField<String> systemkey;  			/**  column SYSTEMKEY : systemkey */
//	private HiddenField<String>	 hanNm;					/**  column 성명 : hanNm */
//	private HiddenField<String>	 deptNm;				/**  column 부서명 : deptNm */
//    private HiddenField<Long> edacSeilNum;	/** set 연말정산마감일련번호 : edacSeilNum */
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
    private TextField<String> tnm;						// 근무처명
    private TextField<String> bsnoEncCntn;				// 사업자등록번호
    
    private TextField<String> hanNm;					// 성명
    private TextField<String> deptNm;					// 부서명   
    private TextField<String> typNm;					// 직종(사업명)
    
    private CheckBox fileSbtYn;							// 소득공제신고전자파일제출여부
    private ButtonBar fileSbtnBar;
    private Button fileSbtBtn;							// 소득공제신고서자료추출
    private Button fileSbtReBtn;							// 소득공제신고서자료추출
    private Button fileSbtBtn01;						// 개별간소화파일
    private Button fileSbtBtn02;						// 일괄간소화파일
    
    
    //-- 기본사항  
    private RadioGroup hshrClCd;						// 세대주여부
    
    private HiddenField<String> rsplNtnInfrCd;			// 국적코드
    private TextField<String> rsplNtnInfrNm;			// 국적명
    private TextField<String> rsplNtnInfrItem; 			// 국적코드 두자리
    
    private MSFDateField dtyStrtDt;						// 근무 시작 일자
    private MSFDateField dtyEndDt;						// 근무 종료 일자
    
    private MSFDateField reStrtDt;						// 감면 시작 일자 
    private MSFDateField reEndDt;						// 감면 종료 일자
    
    private RadioGroup rsdtClCd;						// 거주구분여부
    
    private HiddenField<String> rsplNtnCd;				// 거주지국코드
    private TextField<String> rsplNtnNm;				// 거주지국명
    private TextField<String> rsplNtnItem; 				// 거주지국 두자리
    
    private CheckBox inpmYn;							// 분납신청여부
    private CheckBox c152StdTxDdcYn;					// 표준세액공제적용여부
    private ComboBox<BaseModel> inctxWhtxTxamtMetnCd;	// 소득세원천징수세액조정구분코드   
    
    	
    private MSFNumberField prcspPaySum;		  			// 종근무지_급여총액 
//    private MSFNumberField yeta0c22;					// 주근무지_급여총액 
    private MSFNumberField yeta0c29;					// 주근무지_급여총액 
    private MSFNumberField yeta0c63;					// 총급여_현_전 
    	
    private MSFNumberField yeta0c64;					// 근로소득공제 
    private MSFNumberField yeta0c65;					// 근로소득금액 
    private MSFNumberField yetaC120;					// 세액공제_근로소득세액공제 
    	
    private MSFNumberField yetaC112; 					// 과세표준   
    private MSFNumberField yetaC113; 					// 산출세액  
    private MSFNumberField prcspIncmTxSum;				// 결정세액_소득세 
    private MSFNumberField prcspRgonIncmTxSum;			// 결정세액_주민세_지방소득세 
    	
    private MSFNumberField yetaC162;					// 기납부세액_소득세 
    private MSFNumberField yetaC163;					// 기납부세액_주민세_지방소득세 
    // -------------- 기본 사항 종료 --------------
    
    
    
    // -------------- 인적 공제 시작 --------------
    private RadioGroup prifChngYn;					// 인적공제항목변동여부
    private Radio prifChngYn0;
    private Radio prifChngYn1;
    private MSFNumberField addrMrct;					// 추가공제_다자녀인원수
    private MSFNumberField addrMccr;					// 세액공제_자녀세액공제금액
//    private HiddenField<String> beforeJumin;	//수정전 주민등록번호
    
//    private List<Yeta3220DTO> beforeJumin = new ArrayList<Yeta3220DTO>();  
    // -------------- 인적 공제 종료 --------------
    
    
    // -------------- 연금보험료 공제 시작 --------------
    //--국민보험료
    private MSFNumberField npHthrWaInfeeAmt;			// 종근무지_국민연금보험료
    private MSFNumberField npHthrWaInfeeDdcAmt;			// 종근무지_국민연금보험료공제
    
    private MSFNumberField npHthrMcurWkarInfeeAmt;		// 주근무지_국민연금보험료
    private MSFNumberField npHthrMcurWkarDdcAmt;		// 주근무지_국민연금보험료공제
    
    private MSFNumberField npHthrAreaInfeeAmt;			// 국민연금지역보험료
    private MSFNumberField npHthrAreaDdcAmt;			// 국민연금지역보험료공제
    
    

    //--국민연금보험료외의 연금보험료
    private MSFNumberField puoferAnty_02;				// 종근무지_국민연금외공무원연금
    private MSFNumberField puoferAnty_01;				// 주근무지_국민연금외공무원연금
   
    private MSFNumberField mltymAnty_02;				// 종근무지_국민연금외군인연금
    private MSFNumberField mltymAnty_01;				// 주근무지_국민연금외군인연금
    
    private MSFNumberField prtafirSchlFalymmAnty_02;	// 종근무지_국인연금외교직원연금
    private MSFNumberField prtafirSchlFalymmAnty_01;	// 주근무지_국인연금외교직원연금
    
    private MSFNumberField spildtnPstoficAnty_02;		// 종근무지_국민연금외별정우체국
    private MSFNumberField spildtnPstoficAnty_01;	 	// 주근무지_국민연금외별정우체국

    private MSFNumberField puoferAntyDducSum_02;		// 종근무지_국민연금외공무원연금공제
    private MSFNumberField puoferAntyDducSum_01;		// 주근무지_공무원연금보험료공제

    private MSFNumberField mltymAntyDducSum_02;			// 종근무지_국민연금외군인연금공제
    private MSFNumberField mltymAntyDducSum_01;			// 주근무지_국민연금외군인연금공제

    private MSFNumberField prtafirSchlDducSum_02;		// 종근무지_국민연금외교직원연금공제
    private MSFNumberField prtafirSchlDducSum_01;		// 주근무지_국민연금외교직원연금공제

    private MSFNumberField spildtnPstoficDducSum_02;	// 종근무지_별정우체국연금보험료공제
    private MSFNumberField spildtnPstoficDducSum_01;	// 주근무지_별정우체국연금보험료공제
    
    private MSFNumberField pnsnInfeeUseAmtSum;			// 연금보험료계
    private MSFNumberField pnsnInfeeDdcAmtSum;			// 연금보험료공제계
    // -------------- 연금보험료 공제 종료 --------------
    
    
    
    // -------------- 특별 소득 공제 시작 --------------
    // -- 보험료
    private MSFNumberField hthrHifeAmt;					// 특별공제_종건강보험료
    private MSFNumberField mcurHifeAmt;					// 특별공제_주건강보험료
    private MSFNumberField hthrHifeDdcAmt;				// 특별공제_종건강보험료 공제액
    private MSFNumberField mcurHifeDdcAmt;				// 특별공제_주건강보험료 공제액
    private MSFNumberField mcurHifeAreaAmt;				// 특별공제_건강지역보험료
    private MSFNumberField mcurHifeAreaDdcAmt;			// 특별공제_건강지역보험료 공제액
    	
    private MSFNumberField hthrUiAmt;					// 특별공제_종고용보험료
    private MSFNumberField mcurUiAmt;					// 특별공제_주고용보험료
    private MSFNumberField hthrUiDdcAmt;				// 특별공제_종고용보험료 공제액
    private MSFNumberField mcurUiDdcAmt;				// 특별공제_주고용보험료 공제액
    	
    private MSFNumberField infeeUseAmtSum;				// 특별공제_보험료계
    private MSFNumberField infeeDdcAmtSum;				// 특별공제_보험료계

    // -- 주택자금
    private MSFNumberField brwLnpbSrmAmt;				// 특별공제_차입금원리금상환액_대출기관
    private MSFNumberField brwLnpbSrmDdcAmt;			// 특별공제_차입금원리금상환액_거주자
    	
    private MSFNumberField rsdtLnpbSrmAmt;				// 특별공제_차입금원리금상환액_대출기관 공제액
    private MSFNumberField rsdtLnpbSrmDdcAmt;			// 특별공제_차입금원리금상환액_거주자 공제액
    
    private MSFNumberField lthYr15BlwItrAmt;			// 특별공제_11장기주택저당차입금15
    private MSFNumberField lthYr29ItrAmt;				// 특별공제_11장기주택저당차입금29
    private MSFNumberField lthY30OverItrAmt;			// 특별공제_11장기주택저당차입금30
    
    private MSFNumberField lthYr15BlwDdcAmt;			// 특별공제_11장기주택저당차입금15 공제액
    private MSFNumberField lthYr29DdcAmt;				// 특별공제_11장기주택저당차입금29 공제액
    private MSFNumberField lthY30OverDdcAmt;			// 특별공제_11장기주택저당차입금30 공제액
    
    
    private MSFNumberField lthYr2012AfthY15Amt;			// 특별공제_12장기주택저당차입금_고정
    private MSFNumberField lthYr2012EtcBrwItrAmt;		// 특별공제_12장기주택저당차입금_기타
    	
    private MSFNumberField lthYr2012AfthY15DdcAmt;		// 특별공제_12장기주택저당차입금_고정  공제액
    private MSFNumberField lthYr2012EtcBrwDdcAmt;		// 특별공제_12장기주택저당차입금_기타  공제액

    private MSFNumberField lthYr2015AfthFxnIrItrAmt;	// 특별공제_15장기주택저당_15고정AND비거치상환
    private MSFNumberField lthYr2015AfthY15Amt;			// 특별공제_15장기주택저당_15고정OR비거치상환
    private MSFNumberField lthYr2015AfthEtcAmt;			// 특별공제_15장기주택저당_15기타대출
    private MSFNumberField lthYr2015AfthYr15Amt;		// 특별공제_15장기주택저당_10고정OR비거치상환
    	
    private MSFNumberField lthYr2015AfthFxnIrDdcAmt;	// 특별공제_15장기주택저당_15고정AND비거치상환 공제액
    private MSFNumberField lthYr2015AfthY15DdcAmt;		// 특별공제_15장기주택저당_15고정OR비거치상환 공제액
    private MSFNumberField lthYr2015AfthEtcDdcAmt;		// 특별공제_15장기주택저당_15기타대출 공제액
    private MSFNumberField lthYr2015AfthYr15DdcAmt;		// 특별공제_15장기주택저당_10고정OR비거치상환 공제액
    private MSFNumberField hsngFndsDdcAmtSum;			// 특별공제_주택자금공제액계
    
    private MSFNumberField conbLglUseAmt01;				// 이월법정기부금액
    private MSFNumberField conbReliOrgOthUseAmt01;		// 이월종교단체외기부금
    private MSFNumberField conbReliOrgUseAmt01;			// 이월종교단체기부금
    private MSFNumberField conbLglDdcAmt01;				// 이월법정기부금액_공제액
    private MSFNumberField conbReliOrgOthDdcAmt01;		// 이월종교단체외기부금_공제액
    private MSFNumberField conbReliOrgDdcAmt01;			// 이월종교단체기부금_공제액
    private MSFNumberField conbUseAmtSum01;				// 기부금(이월분) 합계	
    private MSFNumberField conbDdcAmtSum01;				// 기부금(이월분)	 합계_공제
 
//    ye161060Vo.setConbLglUseAmt(MSFSharedUtils.allowNulls(egovMap.get("conbLglUseAmt")));    /** column 기부금이월분_법정기부금기부금납입액 : conbLglUseAmt */
//    ye161060Vo.setConbLglDdcAmt(MSFSharedUtils.allowNulls(egovMap.get("conbLglDdcAmt")));    /** column 기부금이월분_법정기부금기부금공제액 : conbLglDdcAmt */
//    ye161060Vo.setConbReliOrgOthUseAmt(MSFSharedUtils.allowNulls(egovMap.get("conbReliOrgOthUseAmt")));    /** column 기부금이월분_지정기부금_종교단체외납입액 : conbReliOrgOthUseAmt */
//    ye161060Vo.setConbReliOrgOthDdcAmt(MSFSharedUtils.allowNulls(egovMap.get("conbReliOrgOthDdcAmt")));    /** column 기부금이월분_지정기부금_종교단체외공제액 : conbReliOrgOthDdcAmt */
//    ye161060Vo.setConbReliOrgUseAmt(MSFSharedUtils.allowNulls(egovMap.get("conbReliOrgUseAmt")));    /** column 기부금이월분_지정기부금_종교단체납입액 : conbReliOrgUseAmt */
//    ye161060Vo.setConbReliOrgDdcAmt(MSFSharedUtils.allowNulls(egovMap.get("conbReliOrgDdcAmt")));    /** column 기부금이월분_지정기부금_종교단체공제액 : conbReliOrgDdcAmt */
//    ye161060Vo.setConbUseAmtSum(MSFSharedUtils.allowNulls(egovMap.get("conbUseAmtSum")));    /** column 기부금이월분_지정기부금납입분합계 : conbUseAmtSum */
//    ye161060Vo.setConbDdcAmtSum(MSFSharedUtils.allowNulls(egovMap.get("conbDdcAmtSum")));    /** column 기부금이월분_지정기부금공제합계 : conbDdcAmtSum */
    	

    // -------------- 특별 소득 공제 종료 --------------
    
    
    
    // -------------- 그밖의 소득 공제1 시작 --------------
    private MSFNumberField yr2000PnsnSvngUseAmt;		// 개인연금저축불입액_2000년이전
    private MSFNumberField yr2000PnsnSvngDdcAmt;		// 개인연금저축불입액_2000년이전
    
    private MSFNumberField sbcSvngUseAmt;				// 기타공제_주택마련저축_청약저축
    private MSFNumberField hsngSvngUseAmt;				// 기타공제_주택마련저축_주택청약종합저축
//    private MSFNumberField hsngSvngUseAmt2015;		// 기타공제_주택마련저축_주택청약종합저축 2015년 이후
    private MSFNumberField lbrrPrptSvngUseAmt;			// 기타공제_주택마련저축_근로자주택마련저축
    private MSFNumberField hsngIncUseAmtSum;			// 기타공제_주택마련저축소득금액
    	
    private MSFNumberField sbcSvngDdcAmt;				// 기타공제_주택마련저축_청약저축 공제액
    private MSFNumberField hsngSvngDdcAmt;				// 기타공제_주택마련저축_주택청약종합저축 공제액
//    private MSFNumberField hsngSvngDdcAmt2015;			// 기타공제_주택마련저축_주택청약종합저축 공제액2015년 이후
    private MSFNumberField lbrrPrptSvngDdcAmt;			// 기타공제_주택마련저축_근로자주택마련저축 공제액
    private MSFNumberField hsngIncDdcAmtSum;			// 기타공제_주택마련저축소득공제계
    
    private MSFNumberField smceSbizUseAmt;				// 기타공제_소기업공제불입금액
    private MSFNumberField smceSbizDdcAmt;				// 기타공제_소기업공제불입금 공제액

    private MSFNumberField cpiv17AsctUseAmt;   			// 출자투자금액_조합등_2017납입금
    private MSFNumberField cpiv17AsctDdcAmt;   			// 출자투자금액 조합등_2017공제액
    
    private MSFNumberField cpiv17VntUseAmt;   			// 출자투자금액벤처등_2017납입금액
    private MSFNumberField cpiv17VntDdcAmt;   			// 출자투자금액벤처등_2017공제액 
    
    private MSFNumberField cpiv18AsctUseAmt;   			// 출자투자금액_조합등_2018납입금
    private MSFNumberField cpiv18AsctDdcAmt;   			// 출자투자금액 조합등_2018공제액
    
    private MSFNumberField cpiv18VntUseAmt;   			// 출자투자금액벤처등_2018납입금액
    private MSFNumberField cpiv18VntDdcAmt;   			// 출자투자금액벤처등_2018공제액
    // --- 2019
    private MSFNumberField cpiv19AsctUseAmt;   			// 출자투자금액_조합등_2019납입금
    private MSFNumberField cpiv19AsctDdcAmt;   			// 출자투자금액 조합등_2019공제액
    
    private MSFNumberField cpiv19VntUseAmt;   			// 출자투자금액벤처등_2019납입금액
    private MSFNumberField cpiv19VntDdcAmt;   			// 출자투자금액벤처등_2019공제액
    
    private MSFNumberField cpiv19AsctTwoUseAmt;
    private MSFNumberField cpiv19AsctTwoDdcAmt;
    // --- 2019
    
 // --- 2020
    private MSFNumberField cpiv20AsctUseAmt;   			// 출자투자금액_조합등_2020납입금
    private MSFNumberField cpiv20AsctDdcAmt;   			// 출자투자금액 조합등_2020공제액
    
    private MSFNumberField cpiv20VntUseAmt;   			// 출자투자금액벤처등_2020납입금액
    private MSFNumberField cpiv20VntDdcAmt;   			// 출자투자금액벤처등_2020공제액
    
    private MSFNumberField cpiv20AsctTwoUseAmt;
    private MSFNumberField cpiv20AsctTwoDdcAmt;
    // --- 2020
    
    
 // --- 2021
    private MSFNumberField cpiv21AsctUseAmt;   			// 출자투자금액_조합등_2021납입금
    private MSFNumberField cpiv21AsctDdcAmt;   			// 출자투자금액 조합등_2021공제액
    
    private MSFNumberField cpiv21VntUseAmt;   			// 출자투자금액벤처등_2021납입금액
    private MSFNumberField cpiv21VntDdcAmt;   			// 출자투자금액벤처등_2021공제액
    
    private MSFNumberField cpiv21AsctTwoUseAmt;
    private MSFNumberField cpiv21AsctTwoDdcAmt;
    // --- 2021
    
    //2022연말정산_추가
    // --- 2022
    private MSFNumberField cpiv22AsctUseAmt;   			// 출자투자금액_조합등_2022납입금
    private MSFNumberField cpiv22AsctDdcAmt;   			// 출자투자금액 조합등_2022공제액
    
    private MSFNumberField cpiv22VntUseAmt;   			// 출자투자금액벤처등_2022납입금액
    private MSFNumberField cpiv22VntDdcAmt;   			// 출자투자금액벤처등_2022공제액
    
    private MSFNumberField cpiv22AsctTwoUseAmt;
    private MSFNumberField cpiv22AsctTwoDdcAmt;
    // --- 2022
    
    private MSFNumberField ivcpInvmUseAmtSum;			// 투자조합출자등소득공제납입금액계
    private MSFNumberField ivcpInvmDdcAmtSum;			// 투자조합출자등소득공제공제액계
    	
    private MSFNumberField crdcUseAmt;					// 기타공제_신용카드등사용금액
    private MSFNumberField drtpCardUseAmt;				// 기타공제_직불카드등사용금액
    private MSFNumberField cshptUseAmt;					// 기타공제_현금영수증사용금액
    private MSFNumberField bookShowAmt;					// 도서구입
    private MSFNumberField tdmrUseAmt;					// 기타공제_전통시장사용분
    private MSFNumberField pbtUseAmt;					// 기타공제_지로납부_대중교통금액
    private MSFNumberField crdcSumUseAmt;				// 기타공제_신용카드등사용금액계
    private MSFNumberField rdcSumDdcAmt;				// 기타공제_신용카드등사용공제계
    
    
//    private MSFNumberField prsCrdcUseAmt1;				// 본인신용카드등사용액_2014
//    private MSFNumberField tyYrPrsCrdcUseAmt;			// 본인신용등사용액_2015
//    private MSFNumberField pyrPrsAddDdcrtUseAmt;		// 본인추가공제율사용분_2014  
//    private MSFNumberField tyShfyPrsAddDdcrtUseAmt;  	// 본인추가공제율사용분_2016_상반기 
    

  
    // -------------- 그밖의 소득 공제2 시작 --------------
    private MSFNumberField emstAsctCntrUseAmt;			// 기타공제_우리사주출연금액
    private MSFNumberField empMntnSnmcUseAmt;			// 기타공제_고용유지중소기업근로자임금삭감액
    private MSFNumberField ltrmCniSsUseAmt;				// 기타공제_장기집합투자증권저축금액
    
    private MSFNumberField emstAsctCntrDdcAmt;			// 기타공제_우리사주출연금공제 공제액
    private MSFNumberField empMntnSnmcDdcAmt;			// 기타공제_고용유지중소기업근로자임금삭감공제액
    private MSFNumberField ltrmCniSsDdcAmt;				// 기타공제_장기집합투자증권저축공제액 
    
//    private MSFNumberField etckUncb;//기타공제_우리사주조합기부금2014이전
//    private MSFNumberField etgdCtra;	//기타공제_목돈안드는전세이자상환금액
    
//    private MSFTextField etclEttl;		//기타공제_기타제목
//    private MSFNumberField etclEtam;	//기타공제_기타금액
//    private MSFNumberField etcdTsum;		//기타공제_공제계
    
//    private MSFNumberField etckUncr;		//기타공제_우리사주조합기부금공제2014이전 공제액
//    private MSFNumberField etgdHtra;		//기타공제_목돈안드는전세이자상환소득공제액
    // -------------- 그밖의 소득 공제2 종료 --------------
    
    
    // -------------- 세액감면및세액공제1 시작 --------------
    //--연금계좌및보험료
    private MSFNumberField sctcHpUseAmt;				// 과학기술인공제
    private MSFNumberField sctcHpDdcTrgtAmt;			// 과학기술인공제대상금액
    private MSFNumberField sctcHpDdcAmt;				// 과학기술인공제액
    	
    private MSFNumberField rtpnUseAmt;					// 근로자퇴직급여보장법
    private MSFNumberField rtpnDdcTrgtAmt;				// 근로자퇴직급여보장대상금액
    private MSFNumberField rtpnDdcAmt;					// 근로자퇴직급여보장법공제액
    
    private MSFNumberField rtpnIsaUseAmt;					// 근로자퇴직급여보장법_ISA
    private MSFNumberField rtpnDdcIsaTrgtAmt;				// 근로자퇴직급여보장대상금액_ISA
    private MSFNumberField rtpnDdcIsaAmt;					// 근로자퇴직급여보장법공제액_ISA
    	
    private MSFNumberField pnsnSvngUseAmt;				// 연금저축
    private MSFNumberField pnsnSvngDdcTrgtAmt;			// 연금계축공제대상금액
    private MSFNumberField pnsnSvngDdcAmt;				// 연금계좌저축공제
    
    private MSFNumberField pnsnSvngIsaUseAmt;				// 연금저축_ISA
    private MSFNumberField pnsnSvngDdcIsaTrgtAmt;			// 연금계축공제대상금액_ISA
    private MSFNumberField pnsnSvngDdcIsaAmt;				// 연금계좌저축공제_ISA
    	
    private MSFNumberField pnsnAccUseAmtSum;			// 연금계좌계
    private MSFNumberField pnsnAccDdcTrgtAmtSum;		// 연금계좌공제대상금액
    private MSFNumberField pnsnAccDdcAmtSum;			// 연금계좌세액공제계
    	
    private MSFNumberField cvrgInscUseAmt;				// 일반보장성보험료
    private MSFNumberField cvrgInscDdcTrgtAmt2;			// 일반보장성보험료 공제대상금액
    private MSFNumberField cvrgInscDdcAmt;				// 일반보장성보험료 공제액
    
    
    private MSFNumberField dsbrEuCvrgUseAmt;			// 장애인전용보험료
    private MSFNumberField dsbrEuCvrgDdcTrgtAmt;		// 장애인보장성대상금액
    private MSFNumberField dsbrEuCvrgDdcAmt; 			// 장애인보장성대상금액 공제액
    	
    private MSFNumberField infeePymUseAmtSum;			// 보장성보험료계
    private MSFNumberField infeePymDdcTrgtAmtSum;		// 보장성보험료대상금액
    private MSFNumberField infeePymDdcAmtSum;			// 보장성보혐료세액공제금액

    //--의료비
    private MSFNumberField mdxpsSftSprcdUseAmt;			// 난임시술비
    private MSFNumberField mdxpsSftSprcdDdcTrgtAmt;		// 난임시술비 공제대상금액
    private MSFNumberField mdxpsSftSprcdDdcAmt;			// 난임시술비  세액공제
    	
    private MSFNumberField mdxpsPrsUseAmt;				// 본인.65세이상자.장애인
   	private MSFNumberField mdxpsPrsDdcTrgtAmt;			// 본인.65세이상자.장애인 공제대상금액
    private MSFNumberField mdxpsPrsDdcAmt;				// 본인.65세이상자.장애인 세액공제 
    private MSFNumberField mdxpsPrsLsInsrTrAmt;			// 본인.65세이상자.장애인 실손보험금 
    
    private MSFNumberField mdxpsOthUseAmt;				// 그 밖의 공제대상자
    private MSFNumberField mdxpsOthDdcTrgtAmt;			// 그 밖의 공제대상자공제대상금액
    private MSFNumberField mdxpsOthDdcAmt;				// 그 밖의 공제대상자  세액공제
    private MSFNumberField mdxpsOthLsInsrTrAmt;			// 그 밖의 공제대상자 실손보험금
    
    private MSFNumberField mdxpsUseAmtSum;				// 의료비계
    private MSFNumberField mdxpsLsInsrTrAmt;			// 실손보험금보전금액
    private MSFNumberField mdxpsDdcTrgtAmtSum;			// 의료비 대상금액계
    private MSFNumberField mdxpsDdcAmtSum;				// 의료비 세액공제액계
    
    private MSFNumberField medxpsUseAmtSum;				// 실손보험금보전금액계
    	

    //--교육비
    private MSFNumberField scxpsPrsUseAmt;				// 본인
    private MSFNumberField scxpsPrsDdcTrgtAmt;			// 본인교육비 대상금액
    private MSFNumberField scxpsPrsDdcAmt;				// 본인 공제액
    	
    private MSFNumberField scxpsKidCount;				// 취학전아동수
    private MSFNumberField scxpsKidUseAmt;			// 취학전아동 대상금액
    private MSFNumberField scxpsKidDdcAmt;				// 취학전아동 공제액
    	
    private MSFNumberField scxpsStdCount;				// 초중고자녀수
    private MSFNumberField scxpsStdUseAmt;			// 초중고 대상금액
    private MSFNumberField scxpsStdDdcAmt;				// 초중고 공제액
    	
    private MSFNumberField scxpsUndCount;				// 대학생수
    private MSFNumberField scxpsUndUseAmt;			// 대학교 대상금액
    private MSFNumberField scxpsUndDdcAmt;				// 대학교 공제액
    	
    private MSFNumberField scxpsDsbrUseAmt;				// 장애인 
    private MSFNumberField scxpsDsbrDdcTrgtAmt;			// 장애인특수교육비 대상금액
    private MSFNumberField scxpsDsbrDdcAmt;				// 장애인특수교육비 공제액
    	
    private MSFNumberField scxpsUseAmtSum;				// 교육비계
    private MSFNumberField scxpsDdcTrgtAmtSum;			// 교육비공제 대상금액 
    private MSFNumberField scxpsDdcAmtSum;				// 교육비세액 공제금액
    
    //--기부금
    private MSFNumberField conb10ttswLtUseAmt;			// 기부정치자금_10이하 금액  	
    private MSFNumberField conb10ttswLtDdcTrgtAmt;		// 기부정치자금_10이하 대상금액	
    private MSFNumberField conb10ttswLtDdcAmt;			// 기부정치자금_10이하  공제세액	
    		
    private MSFNumberField conb10excsLtUseAmt;			// 기부정치자금_10초과	 금액
    private MSFNumberField conb10excsLtDdcTrgtAmt;		// 기부정치자금_10초과	 대상금액	
    private MSFNumberField conb10excsLtDdcAmt;			// 기부정치자금_10초과	  공제세액
    		
    private MSFNumberField conbLglUseAmt02;				// 법정 금액	 
    private MSFNumberField conbLglDdcTrgtAmt02;			// 법정 대상금액	
    private MSFNumberField conbLglDdcAmt02;				// 법정 공제세액
    
//    private MSFNumberField spciExam;	//특별공제_기부금_특례_공익법인신탁제외	
//    private MSFNumberField spciExtg;	//특례기부금_공익법인제외대상금액	
//    private MSFNumberField spciExam01;	//특별공제_기부금_특례_공익법인신탁제외	공제새액
    		
    private MSFNumberField conbEmstAsctUseAmt;			// 우리사주조합 	
    private MSFNumberField conbEmstAsctDdcTrgtAmt;		// 우리사주종합 대상금액	
    private MSFNumberField conbEmstAsctDdcAmt;			// 우리사주조합 공제세액	
    
    		
    private MSFNumberField conbReliOrgOthUseAmt02;		// 지정기부금종교단체외기부금액	
    private MSFNumberField conbReliOrgOthDdcTrgtAmt02;	// 지정기부금종교단체외공제대상금액	
    private MSFNumberField conbReliOrgOthDdcAmt02;		// 지정기부금종교단체외공제세액	
    		
    private MSFNumberField conbReliOrgUseAmt02;			// 지정기부금종교단체기부금액
    private MSFNumberField conbReliOrgDdcTrgtAmt02;		// 지정기부금종교단체공제대상금액	
    private MSFNumberField conbReliOrgDdcAmt02;			// 지정기부금종교단체공제세액
    		
    private MSFNumberField conbUseAmtSum02;				// 기부금납입금액합계	
    private MSFNumberField conbDdcTrgtAmtSum02;			// 기부금공제대상금액합계	
    private MSFNumberField conbDdcAmtSum02;				// 기부금공제세액합계
    
    // -------------- 세액감면및세액공제1 종료 --------------
    
    
    // -------------- 세액감면및세액공제2 시작 --------------
    private CheckBoxGroup frgrLbrrEntcPupCd;		// 세액공제_외국인_입국목적코드
    private CheckBox frgrLbrrEntcPupCd1;
    private CheckBox frgrLbrrEntcPupCd2;
    private CheckBox frgrLbrrEntcPupCd3;
    private CheckBox frgrLbrrEntcPupCd4;
    
    private MSFDateField frgrLbrrLbrOfrDt;			// 세액공제_외국인_근로제공일자
    private MSFDateField frgrLbrrReExryDt;			// 세액공제_외국인_감면기간만료일자
    private MSFDateField frgrLbrrReRcpnDt;			// 세액공제_외국인_감면신청접수일자
    private MSFDateField frgrLbrrReAlfaSbmsDt;		// 세액공제_외국인_감면신청제출일자
    
//    private MSFDateField txlgFrrd;		//세액공제_외국인해저광물개발감면확인일자
//    private MSFDateField txlgFrid;		//세액공제_외국인해저광물개발감면신청일자
    private MSFDateField frgrLbrrErinImnRcpnDt;		// 세액공제_근로소득조세조약상면제접수일자
    private MSFDateField frgrLbrrErinImnSbmsDt;		// 세액공제_근로소득조세조약상면제제출일자
    	
    private MSFDateField yupSnmcReStrtDt;			// 세액공제_중소기업청년감면취업일자
    private MSFDateField yupSnmcReEndDt;			// 세액공제_중소기업청년감면종료일자
    	
    private MSFNumberField txlgItctAmnt;			// 세액감면_소득세법감면세액 		
    private MSFNumberField yetaC114;				// 세액감면_소득세법			
    private MSFNumberField txlgFrtaAmnt;			// 세액감면_외국인기술자감면세액	 
    private MSFNumberField yetaC115;				// 세액공제_외국인감면세액		
    private MSFNumberField txlgBstaAmnt;			// 세액감면_취업청년감면대상총급여액		
    private MSFNumberField txlgWktaAmnt;			// 세액감면_취업청년감면근로자총급여액
    private MSFNumberField txlgTxtyAmnt;			// 세액감면_조세조약감면세액		
    private MSFNumberField yetaC117;				// 세액감면_조세조약		
    private MSFNumberField txlgCltaAmnt;			// 세액감면_계산감면세액금액
    private MSFNumberField yetaC116;				// 세액감면_감면세액
    
    	
    private MSFNumberField ovrsSurcIncFmt;			// 세액공제_외국납부_국외원천소득금액
    private MSFNumberField frgnPmtFcTxamt;			// 세액공제_외국납부_외화납세액
    private MSFNumberField frgnPmtWcTxamt;			// 세액공제_외국납부_원화납세액
    private MSFTextField frgnPmtTxamtTxpNtnNm;		// 세액공제_외국납부_납세국명
    private MSFDateField frgnPmtTxamtPmtDt;			// 세액공제_외국납부_납부일자
    private MSFDateField frgnPmtTxamtAlfaSbmsDt;	// 세액공제_외국납부_신청서제출일자
    private MSFTextField frgnPmtTxamtAbrdWkarNm;	// 세액공제_외국납부_국외근무처명
    private MSFTextField frgnPmtTxamtRfoNm;			// 세액공제_외국납부_직책
    
    /** set 외국납부세액_근무기간일자 : frgnDtyTerm */
    private MSFDateField frgnDtyTermStdt;			// 세액공제_외국납부_근무시작일자
    private MSFDateField frgnDtyTermEddt;			// 세액공제_외국납부_근무종료일자
    
//    private MSFNumberField taxdUnin;	//세액공제_납세조합공제
//    private MSFNumberField taxdUnin01;		//세액공제_납세조합공제
    	
    private MSFNumberField hsngTennLnpbUseAmt;			// 세액공제_주택차입금이자상황금액
    private MSFNumberField hsngTennLnpbDdcAmt;			// 세액공제_주택차입금
    
	
	private MSFNumberField mmrUseAmt;					// 월세금액
	private MSFNumberField mmrDdcAmt;					// 월세공제액
    // -------------- 세액감면및세액공제2 종료 --------------
    
    
    
    // -------------- 추가제출서류 시작 --------------
    private RadioGroup d219;						// 1.외국인근로자 단말세율적용신청서 제출여부
    private RadioGroup cd225;						// 2.연금, 저축 등 소득공제 명세서 제출 여부
    private RadioGroup cd226;						// 3.월세액.비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부
    
    private RadioGroup cd227;						// 의료비지급 명세서
    private RadioGroup cd228;						// 기부금 명세서
    private RadioGroup prcspWorkIncmSumtYn;			//소득공제 증빙서류
    private RadioGroup fileAppPaprSbtYn;	//소득공제신고서제출여부
    private MSFDateField incmDducWtnnteSumtDt;		// 소득공제신고서제출여부_제출일자
    // -------------- 추가제출서류 종료 --------------
    
    private BaseModel ppRecord; //팝업에 넘길 레코드 값 
	private BaseModel record;
	private Iterator<Record> records;
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Rpc Service 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	// -------------- stroe 선언 시작 --------------
	private ListStore<BaseModel> lsClutYrStore 			= new ListStore<BaseModel>(); 	// 년도
	private ListStore<BaseModel> lsClutMnth 			= new ListStore<BaseModel>(); 	// 급여월
	private ListStore<BaseModel> lsEmymtDivCd	 		= new ListStore<BaseModel>(); 	// 고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	// 호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd				= new ListStore<BaseModel>(); 	// 부서콤보
	private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>(); 	// 사업콤보
	private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>(); 	// 단위기관
	private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	// 부서직종그룹코드 
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>(); 	// 직종
	private ListStore<BaseModel> lsClutSeptCd 			= new ListStore<BaseModel>();	// 정산구분
	private ListStore<BaseModel> lsPymtDducDivCd		= new ListStore<BaseModel>(); 	// 지급공제구분코드
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>(); 	// 직종세
//	private ListStore<BaseModel> lsCrClutYrStore = new ListStore<BaseModel>(); 			//년도
//	private ListStore<BaseModel> lsCrClutMnth = new ListStore<BaseModel>(); 			//급여월
	
	private ListStore<BaseModel> lsInctxWhtxTxamtMetnCd = new ListStore<BaseModel>(); 	// 소득세원천징수세액조정구분코드
	// -------------- stroe 선언 종료 --------------
	
	
	// -------------- 서비스 호출 시작 -------------- 
	private Yeta7300ServiceAsync yeta7300Service = Yeta7300Service.Util.getInstance();
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
	 private void checkYeta7300Auth( String authAction, ListStore<BaseModel>bm) {
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
		  
		 srhYrtxBlggYr.setValue(lsClutYrStore.findModel("year","2022"));
		 srhClutSeptCd.setValue(lsClutSeptCd.getAt(0));
			
		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
		 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	}
	 
	 
	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			if (lsEmymtDivCd.getCount() > 0) {

				cancel();
				unmask();
				authExecEnabled();
				maskTracker = true;

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

		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();
		authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
		authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
		authMapDef.put("srhDeptCd", Boolean.FALSE);
		// authMapDef.put("srhTypOccuCd",Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			// 권한 검색조건처리를 위해 추가된 부분
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
	  * @Method Name : fnYeta7300Payr06530CalcTax
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
	private void fnYeta7300Payr06530CalcTax() {

		MessageBox.confirm("세액계산", "선택된 연말정산계산  대상자에 대해서 세액계산을 합니다. <br> 세액재계산을 하시겠습니까?",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {

					Iterator<BaseModel> itBm = Yeta7300ToYe161010GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

					List<Record> lsRec = new ArrayList<Record>();

					while (itBm.hasNext()) {
						Record rec = new Record(itBm.next());
						lsRec.add(rec);
					}
					setListRecord(lsRec.iterator());
           	  	     	
					if (MSFSharedUtils.paramNotNull(records)) {

						final Tracker tracker = new Tracker();
						tracker.setStatus(false);

						List<Ye161010DTO> listYe161010Dto = new ArrayList<Ye161010DTO>();

						while (records.hasNext()) {

							Record record = (Record) records.next();
							BaseModel bmMapModel = (BaseModel) record.getModel();

							Ye161010DTO ye161010Dto = new Ye161010DTO();   

							ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
							ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    			/** column 연말정산귀속년도 : yrtxBlggYr */
							ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    			/** column 정산구분코드 : clutSeptCd */
							ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    			/** column SYSTEMKEY : systemkey */ 
							ye161010Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    	/** column 급여관리부서코드 : payrMangDeptCd */
							ye161010Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    			/** column 고용구분코드 : emymtDivCd */
							ye161010Dto.setUtDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));    				/** column 단위사업장 : utDpobCd */
						 	ye161010Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    					/** column 부서코드 : deptCd */
							ye161010Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    				/** column 사업코드 : businCd */
							ye161010Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    			/** column 직종코드 : typOccuCd */
							ye161010Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));	/** column 직종세통합코드 : dtilOccuInttnCd */
						 	ye161010Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    					/** column 직책코드 : odtyCd */
							ye161010Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    					/** column 호봉코드 : pyspCd */
						 	ye161010Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    	/** column 근속년수코드 : logSvcYrNumCd */
							ye161010Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));   /** column 근속월수코드 : logSvcMnthIcmCd */
							ye161010Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    		/** column 최초고용일자 : frstEmymtDt */
							ye161010Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    		/** column 고용시작일자 : emymtBgnnDt */
							ye161010Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    			/** column 고용종료일자 : emymtEndDt */
							ye161010Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    			/** column 재직구분코드 : hdofcDivCd */
							ye161010Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    				/** column 퇴직일자 : retryDt */
							ye161010Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));	/** column 연말정산적용년월 : yrtxApptnYrMnth */
							ye161010Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));    			/** column 연말정산처리일자 : yrtxPrcsDt */
							ye161010Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    							/** column 연말정산처리여부 : yrtxPrcsYn */
							ye161010Dto.setClosFlag((Boolean) bmMapModel.get("closFlag") ? "Y" : "N" );   					/** set 마감여부 : closFlag */
							
							
							if("Y".equals(ye161010Dto.getClosFlag())) {
								MessageBox.alert("경고","이미 마감처리 된 대상자는 세액계산 불가 </br>마감처리 된 대상자 확인 요망", null);
								return;
							}
							
							listYe161010Dto.add(ye161010Dto);
		       	                 
						}    
			                       
              	    	    
						if (listYe161010Dto.size() <= 0) {
	  	  	                    
							MessageBox.alert("세액계산","세액계산 할 데이타가 존재하지 않습니다.", null);
							return;
						}
						
	                    final MessageBox box = MessageBox.wait("연말정산 세액계산", "세액계산 처리 중 입니다...", "세액결과 생성 중...");
			            final Timer t = new Timer() {
			            	public void run() {
			            		if (tracker.getStatus()) {
			                          cancel();
			                          box.close();
			                      }
			                  }
			              };
			              t.scheduleRepeating(500);
	               	             
   	           	 		yeta7300Service.fnYeta7300_Ye161010_2022_CalcTax(listYe161010Dto,   new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
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
   	           	 				BaseModel bmData = Yeta7300ToYe161010GridPanel.getCurrentlySelectedItem();  
   	                  	   
   	           	 				dpobCd.setValue((String) bmData.get("dpobCd"));				/**  column 사업장코드 : dpobCd */
   	           	 				yrtxBlggYr.setValue((String) bmData.get("yrtxBlggYr"));		/** column 연말정산귀속년도 : yrtxBlggYr */
   	           	 				clutSeptCd.setValue((String) bmData.get("clutSeptCd"));		/** column 정산구분코드 : clutSeptCd */
   	           	 				systemkey.setValue((String) bmData.get("systemkey"));		/**  column SYSTEMKEY : systemkey */
   	           	 				hanNm.setValue((String) bmData.get("hanNm"));				/** column 성명 : hanNm */
   	           	 				deptNm.setValue((String) bmData.get("deptNm"));				/**  column 부서명 : deptNm */
   	           	 				typNm.setValue((String) bmData.get("typNm"));
   	           	 				resnRegnNum.setValue((String) bmData.get("resnRegnNum"));
   	           	 				setPPRecord(bmData); 

   	           	 				Yeta7300ToYe161010Detail(bmData, "itemYeta01");
   	           	 				
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
	 
	private void fnYeta7300Payr06530AllCalcTax() {

		MessageBox.confirm("전체세액계산","선택된 연말정산계산  대상자에 대해서 전체세액계산을 합니다. <br> 세액재계산을 하시겠습니까?", new Listener<MessageBoxEvent>() {
			@Override
			public void handleEvent(MessageBoxEvent be) {
				if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {

					String pymtYr = MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year");
					if (MSFSharedUtils.paramNull(pymtYr)) {MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산년을 선택하셔야 합니다.", null);
						return;
					}
					if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"))) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
						return;
					}
	
					final Tracker tracker = new Tracker();
					tracker.setStatus(false);
	
					Ye161010DTO ye161010Dto = new Ye161010DTO();   
					
					ye161010Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */
					ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")));/** column 연말정산귀속년도 : edacRvyy */
					ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd")));/** column 정산구분코드 : settGbcd */
	
					final MessageBox box = MessageBox.wait("전체세액계산","세액계산 처리 중 입니다...", "세액결과 생성 중...");
					final Timer t = new Timer() {
						public void run() {
							if (tracker.getStatus()) {
								cancel();
								box.close();
							}
						}
					};
					t.scheduleRepeating(500);
	
					yeta7300Service.fnYeta7300Ye161010_2022_AllCalcTax(ye161010Dto ,new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
						public void onFailure(Throwable caught) {
							
							tracker.setStatus(true);
							List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
							ShowMessageBM smBm = new ShowMessageBM();
							smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
							smBm.setMenu("Yeta");
							smBm.setPhase("[세액계산]전체세액계산에러");
							smBm.setMessage(caught.getLocalizedMessage());
							smBm.setContent(caught.getMessage());
							bmResult.add(smBm);
							PagingLoadResult<ShowMessageBM> retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0,bmResult.size());
								
							ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ,getThis());
							MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기", "620px","510px", true);
							msFwMessage.show();
							showMessageForm.setMSFFormWindows(msFwMessage);
									
						}
	
						public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
							tracker.setStatus(true);
							if (MSFSharedUtils.paramNotNull(result)) {
								ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ,getThis());
								BaseModel tmRec = new BaseModel();
								MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",	showMessageForm,"닫기", "620px","510px", true);
								msFwMessage.show();
								showMessageForm.setMSFFormWindows(msFwMessage);
							}
							
//							reFresh();
						}
					});
				}
			}
		});
	}

	class Tracker {
		public boolean status = false;

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean stat) {
			status = stat;
		}
	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	public Iterator<Record> getListRecord() {
		return this.records;
	}

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * print Service 선언부 시작 
	 * rex 추가로 리포트 타입변경 
	 * fileName : 출력파일명 
	 * repType : 출력물
	 * 타입 RDA -M2SOFT , REX - CLIPSOFT
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
		private void Yeta7300Print(String fileName, String repType) {
			if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
				RdaPrint(fileName);
			} else if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
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
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year") + "]";		//$2 년도
			serarchParam += "[" + MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")+ "]";		//$3 정산구분
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
			
			List<BaseModel> list = Yeta7300ToYe161010GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year") + "⊥";				//$2 년도
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")+ "⊥";				//$3 정산구분
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
			
			List<BaseModel> list = Yeta7300ToYe161010GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
			if("YETAT0302".equals(fileName)) {
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
		private void RexPrintYeta2405(String resn_Regn_Num) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "출력물 진입"+resn_Regn_Num, null);
			// 출력물 디렉토리 패스경로 
			String strDirPath = "YETA/2022";
			
			// reb 출력물
			String rexFileName = "YETAT2402.crf";
			
			// 보낼 파라미터  
			
			// 검색조건
			String serarchParam = "";
			
			serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";  		//$1 사업장코드
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year") + "⊥";				//$2 년도
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")+ "⊥";				//$3 정산구분
			
			String checkedSystemKeys = "";
			
			List<BaseModel> list = Yeta7300ToYe161010GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
				}
	            
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
			serarchParam += ""+checkedSystemKeys+"⊥";															//$4 시스템키 
			
			//serarchParam += ""+MSFSharedUtils.allowNulls(YetaUtils.getCheckedCheckBoxValue(juminCk))+"⊥"; 		//$5 주민번호 표시
	
			serarchParam += ""+txtResnRegnNum+"⊥";	//$5 주민번호 
			
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(issueMethod,"commCd") + "⊥";	 			//$6 출력구분
	
			//도장 출력을 위해 추가 2014-11-06
	      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
//	      	if(MSFSharedUtils.paramNull(myImgUrl)) {
	      			// myImgUrl = "http://105.19.10.32:8080";
	              	//경로오류 출력 
//	      	}
	      	serarchParam += "" + myImgUrl+ "⊥";																	//$7 이미지 경로
	      	serarchParam += "" + resn_Regn_Num + "⊥";	 					//$8주민등록번호
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, serarchParam);
		}
		private void RexPrintYeta2404(String fileName) {
			
			// 출력물 디렉토리 패스경로 
			String strDirPath = "YETA/2022";
			
			// reb 출력물
			String rexFileName = fileName+".crf";
			
			// 보낼 파라미터  
			
			// 검색조건
			String serarchParam = "";
			
			serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";  		//$1 사업장코드
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year") + "⊥";				//$2 년도
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")+ "⊥";				//$3 정산구분
			
			String checkedSystemKeys = "";
			
			List<BaseModel> list = Yeta7300ToYe161010GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
				for(BaseModel bm : list){
					chkkey += "'"+bm.get("systemkey")+"',";
				}
	            
				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
			}
			
			serarchParam += ""+checkedSystemKeys+"⊥";															//$4 시스템키 
			
			//serarchParam += ""+MSFSharedUtils.allowNulls(YetaUtils.getCheckedCheckBoxValue(juminCk))+"⊥"; 		//$5 주민번호 표시
			serarchParam += ""+MSFSharedUtils.allowNulls( txtResnRegnNum.getValue()) +"⊥";	//$5 주민번호 
			
			serarchParam += "" + MSFSharedUtils.getSelectedComboValue(issueMethod,"commCd") + "⊥";	 			//$6 출력구분
	
			//도장 출력을 위해 추가 2014-11-06
	      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
//	      	if(MSFSharedUtils.paramNull(myImgUrl)) {
	      			// myImgUrl = "http://105.19.10.32:8080";
	              	//경로오류 출력 
//	      	}
	      	serarchParam += "" + myImgUrl+ "⊥";																	//$7 이미지 경로
	      	serarchParam += "" + MSFSharedUtils.allowNulls( resnRegnNum.getValue()) + "⊥";	 					//$8주민등록번호
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

			// 콤보 권한초기화
			initLoad();

			detailTp = XTemplate.create(getDetailTemplate());

			vp = new VerticalPanel();
			vp.setSpacing(10);

			createYeta7300Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createContentForm(); 	// 내용 필드
			//엣지변환
			//vp.setSize("1010px", "1600px");
			vp.setSize("1010px", "1850px");

			// 폼데이터를 바인딩
			// formBinding = new FormBinding(this.plFrmYeta7300, true);

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
	public Yeta7300() {

		//엣지변환
		//setSize("1010px", "1600px");
		setSize("1010px", "1850px");
		// setSize("1010px", "750px");
	}

	public Yeta7300(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createContentForm() {

		LayoutContainer conLayoutContainer = new LayoutContainer();

		LayoutContainer btnLayoutContainer = new LayoutContainer();
		btnLayoutContainer.setLayout(new ColumnLayout());

		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);

		LayoutContainer btnLayoutContainer_01 = new LayoutContainer();
		btnLayoutContainer_01.setBorders(false);
		
//		
		Button btnNewButton_5 = new Button("소득공제신고서");
		btnNewButton_5.setIcon(MSFMainApp.ICONS.print16());
		btnNewButton_5.addListener(Events.Select,  new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				RexPrintYeta2404("YETAT2404");
			}
		});
		btnBar.add(btnNewButton_5);		
		

		Button btnNewButton_2 = new Button("의료비명세서");
		btnNewButton_2.setIcon(MSFMainApp.ICONS.print16());
		btnNewButton_2.addListener(Events.Select,  new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				RexPrintYeta2404("YETAT2400");
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
				RexPrintYeta2404("YETAT2401");
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

		Button btnYeta7300_05 = new Button("세액계산");
		btnYeta7300_05.setIcon(MSFMainApp.ICONS.save16());
		btnBar.add(btnYeta7300_05);
		btnYeta7300_05.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    		 
    	        fnYeta7300Payr06530CalcTax();
    		}
    	});
		if ("D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {	
			LayoutContainer btnLayoutContainer_05 = new LayoutContainer();
			btnLayoutContainer_05.setBorders(false);
	
			Button btnNewButton_6 = new Button("세액전체계산");
			btnLayoutContainer_05.add(btnNewButton_6);
			btnBar.add(btnNewButton_6);
			btnNewButton_6.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) { 
	    	        fnYeta7300Payr06530AllCalcTax();
	    		}
	    	});
		}
			
		LayoutContainer btnLayoutContainer_06 = new LayoutContainer();
		btnLayoutContainer_06.setBorders(false);

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		btnLayoutContainer_06.setLayout(frmlytSch);

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
			//윤선
			public void handleEvent(ButtonEvent be) {
				RexPrintYeta2404("YETAT2402");
			/*	
				if(YetaUtils.getCheckedCheckBoxValue(juminCk) =="Y"){
		
					/*
					YetaP73010 yetaP73010Form = new YetaP73010(ActionDatabase.READ, getThis());   
								    
					MSFFormWindows msFwYeta73010 = new MSFFormWindows("주민등록번호등록", yetaP73010Form, "확인", "500px", "150px", true);
					
					msFwYeta73010.show();
					yetaP73010Form.setMSFFormWindows(msFwYeta73010);
						// 팝업이 닫히면 탭을 다시 조회한다.
					msFwYeta73010.addListener(Events.Hide, new Listener<BaseEvent>() { 
			    		@Override
			    		public void handleEvent(BaseEvent be) { 
			    			// TODO Auto-generated method stub
			    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "주민등록번호11", null);
			    			BaseModel mapModel = (BaseModel)be.getSource();
			    			  if (!"".equals(mapModel.get("txprDscmNoCntn"))) {  
			    				  txprDscmNoCntn = mapModel.get("txprDscmNoCntn");
			     				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "주민등록번호"+txprDscmNoCntn, null);
			    				  RexPrintYeta2405(txprDscmNoCntn);
			                   } 
							
			    		}
					});
					//yetaP73010Form.bind(ppRecord); 
					 * 
					 * 
						*/
					//funcSetPopUpRecord();
					//yetaP73010Form.bind(ppRecord); 
				/*	YetaP73010 yetaP73010Form = new YetaP73010();
				
					yetaP73010Form.show();
					yetaP73010Form.addListener(Events.Hide, new Listener<BaseEvent>() { 
			    		@Override
			    		public void handleEvent(BaseEvent be) { 
			    			// TODO Auto-generated method stub
			    			 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "Hide", null);
			    			BaseModel mapModel = (BaseModel)be.getSource();
			    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "주민등록번호1:"+mapModel.get("txprDscmNoCntn"), null);
			    			  if (!"".equals(mapModel.get("txprDscmNoCntn"))) {  
			    				  txprDscmNoCntn = mapModel.get("txprDscmNoCntn");
			     				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "주민등록번호"+txprDscmNoCntn, null);
			    				  RexPrintYeta2405(txprDscmNoCntn);
			                   } 
							
			    		}
					});
			
				
			}else{
				txprDscmNoCntn = "";
				RexPrintYeta2405(txprDscmNoCntn);
			}*/
		}
		});
		btnBar2.add(btnNewButton_7);
		
		
		LayoutContainer btnLayoutContainer_08 = new LayoutContainer();
		btnLayoutContainer_08.setWidth(100);
		btnLayoutContainer_08.setBorders(false);
		
		//juminCk = new CheckBoxGroup();
		//juminCk.setName("juminCk");
		//juminCk.setHideLabel(true);

		
		txtResnRegnNum = new TextField<String>();
		txtResnRegnNum.setName("srhHanNm");
		//txtResnRegnNum.setFieldLabel("성명");
		new TextFieldMask<String>(txtResnRegnNum, "999999-9999999");
		btnLayoutContainer_08.add(txtResnRegnNum);
		
		
	/*	
		CheckBox juminY  = new CheckBox();
		juminY.setBoxLabel("주민번호 표시");
		juminY.setHideLabel(true);
		juminY.setValueAttribute("Y");
		juminCk.add(juminY);
		btnLayoutContainer_08.add(juminCk);
		*/
		
		btnLayoutContainer.add(btnBar, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		btnLayoutContainer.add(btnLayoutContainer_06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		btnLayoutContainer.add(btnBar2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		btnLayoutContainer.add(btnLayoutContainer_08, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());
		layoutContainer_5.add(createListGrid()	, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_5.add(createTabForm()	, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		conLayoutContainer.add(btnLayoutContainer);
		conLayoutContainer.add(layoutContainer_5);

		plFrmYeta7300.add(conLayoutContainer);

	}

	private void createYeta7300Form() {

		plFrmYeta7300 = new FormPanel();
		plFrmYeta7300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 소득공제신고자료관리"));
		plFrmYeta7300.setIcon(MSFMainApp.ICONS.text());
		plFrmYeta7300.setBodyStyleName("pad-text");
		plFrmYeta7300.setFrame(true);
		plFrmYeta7300.setPadding(2);
//		plFrmYeta7300.setSize("990px", "780px");
		//엣지변환
		//plFrmYeta7300.setSize("990px", "830px");
		plFrmYeta7300.setSize("990px", "1080px");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("소득공제신고자료관리","Yeta7300");
				}
			});
		plFrmYeta7300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta7300.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmYeta7300.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						// 부서
						srhDeptCd.showClose(ce);
						mutilCombo = false;
					} else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
			        	// 직종
						srhTypOccuCd.showClose(ce);
						mutilCombo = false;
					} else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
						// 직종세
						srhDtilOccuInttnCd.showClose(ce);
						mutilCombo = false;
					} 
				}
			} 
		});
		topYeta7300Bar = new ButtonBar();
		topYeta7300Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		if ("admin".equals(MSFMainApp.get().getUser().getUsrId()) || "D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {	
			btnYeta7300All = new Button("일괄자료정리");
			btnYeta7300All.setIcon(MSFMainApp.ICONS.new16());
			topYeta7300Bar.add(btnYeta7300All);
			btnYeta7300All.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					Iterator<BaseModel> itBm = Yeta7300ToYe161010GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

					List<Record> lsRec = new ArrayList<Record>();

					while (itBm.hasNext()) {
						Record rec = new Record(itBm.next());
						lsRec.add(rec);
					}

					Iterator<Record> iterRecords = lsRec.iterator();
					final List<Ye161040DTO> listYe161040Dto = new ArrayList<Ye161040DTO>();
					
					Ye161040DTO ye161040DTO = new Ye161040DTO();
						
					while (iterRecords.hasNext()) {

						Record recData = (Record) iterRecords.next();
						BaseModel bmMapModel = (BaseModel) recData.getModel();

						ye161040DTO = new Ye161040DTO();
	                    
						ye161040DTO.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
						ye161040DTO.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   			/** column SYSTEMKEY : systemkey */
						ye161040DTO.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    			/** column 귀속연도 : yrtxBlggYr */
						ye161040DTO.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    			/** column 연말정산구분코드 : clutSeptCd */
//	                    ye161030Dto.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(bmMapModel.get("txprDscmNoCntn")));    	/** column 주민등록번호 : txprDscmNoCntn */
//	                    ye161030Dto.setSuptFmlyRltClCd(MSFSharedUtils.allowNulls(bmMapModel.get("suptFmlyRltClCd")));	/** column 부양관계코드 : suptFmlyRltClCd */
//	                    ye161030Dto.setNnfClCd(MSFSharedUtils.allowNulls(bmMapModel.get("nnfClCd")));   				/** column 내외국인구분 : nnfClCd */
//	                    ye161030Dto.setChild((Long) bmMapModel.get("child") );    										/** column 자녀인원수 : child */
//	                    ye161030Dto.setTxprNm(MSFSharedUtils.allowNulls( bmMapModel.get("txprNm")));    				/** column 성명 : txprNm */
//	                    ye161030Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));    	/** column 인사가족관계코드 : famyRelaDivCd */
						
	                    listYe161040Dto.add(ye161040DTO);
					}	
					
					yeta7300Service.updateYeta7300All(listYe161040Dto, new AsyncCallback<Integer>() {

						public void onFailure(Throwable caught) {
							MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
												, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta7300ToYe161030("+ actionDatabase.name()+ ") : " + caught)
												, null);
							}

							@Override
							public void onSuccess(Integer result) {
								// TODO Auto-generated method stub
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "처리 완료", null);
							}
					});	
					  
				}
			}); 
		
		}	

		btnYeta7300Reset = new Button("초기화");
		btnYeta7300Reset.setIcon(MSFMainApp.ICONS.new16());
		btnYeta7300Reset.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				
				resetSearchForm();				// 검색조건 초기화
				resetYeta300ToYeta2000Grid();	// 대상자정보 초기화
				detailInfoInit();				// 상세정보 초기화

				tabsYeta7300.setSelection(tabsYeta7300.getItem(0));//탭부분 초기화
			}
		});
		topYeta7300Bar.add(btnYeta7300Reset);

		btnYeta7300Save = new Button("저장");
		btnYeta7300Save.setIcon(MSFMainApp.ICONS.save16());
		topYeta7300Bar.add(btnYeta7300Save);
		btnYeta7300Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub  
				//  {-- 기본사항 --}
				if("itemYeta01".equals(tabsYeta7300.getSelectedItem().getId())) {
					
					itemYeta01Save();	// 기본사항 저장
					
				//  {-- 인적공제 --}	
				}else if("itemYeta02".equals(tabsYeta7300.getSelectedItem().getId())) {
					
					itemYeta02Save();	// 인적공제 저장
					
				//	{-- 소득공제 --}	
				}else if("itemYeta03".equals(tabsYeta7300.getSelectedItem().getId())) {
					
					itemYeta03Save();	// 소득공제 저장
					
				// {-- 연금보험료공제--}	
				} else if ("itemYeta04".equals(tabsYeta7300.getSelectedItem().getId())) {
				
					itemYeta04Save();	// 국민연금보험료외의 연금보험료 저장
					
				// {-- 특별소득공제 --}
				} else if ("itemYeta05".equals(tabsYeta7300.getSelectedItem().getId())) {
					if ("itemYeta05_1".equals(tabsItemYeta05.getSelectedItem().getId())) {
						
						itemYeta05_1Save();	// 특별소득공제 - 보험료 탭 저장

					} else if ("itemYeta05_2".equals(tabsItemYeta05.getSelectedItem().getId())) {

						itemYeta05_2Save();	// 특별소득공제 - 주택자금 탭 저장

					}
					
				// {-- 그밖의 소득공제--}	
				}else if("itemYeta06".equals(tabsYeta7300.getSelectedItem().getId())) {
					
					itemYeta06Save();	// 그밖의소득공제1 저장
					
				}else if("itemYeta07".equals(tabsYeta7300.getSelectedItem().getId())) {
					
					itemYeta07Save();	// 그밖의소득공제2 저장
					
				//{-- 세액감면및세액공제--}	
				}else if("itemYeta08".equals(tabsYeta7300.getSelectedItem().getId())) {
					
					if("itemYeta08_1".equals(tabsItemYeta08.getSelectedItem().getId())) {
						 
						itemYeta08_1Save();	// 세액감면및세액공제1 - 연금계좌및보험료 저장
							
					}else if("itemYeta08_2".equals(tabsItemYeta08.getSelectedItem().getId())) {
						
							
					}else if("itemYeta08_3".equals(tabsItemYeta08.getSelectedItem().getId())) {
						
						itemYeta08_3Save();//세액감면및세액공제1 - 교육비 저장
							
					}else if("itemYeta08_4".equals(tabsItemYeta08.getSelectedItem().getId())) {
						
						
					}
					
				} else if ("itemYeta09".equals(tabsYeta7300.getSelectedItem().getId())) {

					// 세액감면및세액공제2 저장
					itemYeta09Save();
					
				// {-- 추가제출서류 --}
				} else if ("itemYeta10".equals(tabsYeta7300.getSelectedItem().getId())) {
					
					// 추가제출서류 저장
					itemYeta10Save();
				}
			}
		});

//		btnYeta7300Del = new Button("삭제");
//		btnYeta7300Del.setIcon(MSFMainApp.ICONS.delete16());
//		topYeta7300Bar.add(btnYeta7300Del);
		
		LabelField radioLabel = new LabelField("대상");
		radioLabel.setWidth(30);
		radioLabel.setStyleAttribute("fontSize", "13px");
		radioLabel.setStyleAttribute("font-weight", "bold");
		topYeta7300Bar.add(radioLabel);
		
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
//		printType.add(radio3);
		
		topYeta7300Bar.add(printType);

		btnYeta7300Sreach = new Button("조회");
		btnYeta7300Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnYeta7300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//탭 선택 없애기
				tabsYeta7300.setSelection(tabsYeta7300.getItem(0));
				//대상자 정보 조회
				reload();
			}
		});
		topYeta7300Bar.add(btnYeta7300Sreach);

//		btnYeta7300Print = new Button("인쇄");
//		btnYeta7300Print.setIcon(MSFMainApp.ICONS.print16());
//		topYeta7300Bar.add(btnYeta7300Print);

		plFrmYeta7300.add(topYeta7300Bar);

		// 파일업로드 처리
		plFrmYeta7300.setAction("myurl");
		plFrmYeta7300.setEncoding(Encoding.MULTIPART);
		plFrmYeta7300.setMethod(Method.POST);

		vp.add(plFrmYeta7300);
		
		// plFrmYeta7300.setSize("990px", "730px");

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
		//엣지변환
		//cpGrid.setSize(280, 620);
		cpGrid.setSize(280, 820);
	    
	    Yeta7300ToYe161010GridPanel = new MSFGridPanel(ye161010Def, false, false, false, false, false);
	    Yeta7300ToYe161010GridPanel.setHeaderVisible(false);  
	    Yeta7300ToYe161010GridPanel.setBodyBorder(true);
	    Yeta7300ToYe161010GridPanel.setBorders(true);
	    final Grid yeta300ToYeta2000Grid = Yeta7300ToYe161010GridPanel.getMsfGrid().getGrid();
        yeta300ToYeta2000Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {

           public void handleEvent(BaseEvent be) {   
	        	   
        	   //탭 선택 없애기
        	   tabsYeta7300.setSelection(tabsYeta7300.getItem(0));
        	   
        	   BaseModel bmData = Yeta7300ToYe161010GridPanel.getCurrentlySelectedItem();  
        	   
//        	   funcSetPopUpRecord();
        	  
        	   dpobCd.setValue((String) bmData.get("dpobCd"));				/**  column 사업장코드 : dpobCd */
        	   yrtxBlggYr.setValue((String) bmData.get("yrtxBlggYr"));		/** column 연말정산귀속년도 : yrtxBlggYr */
        	   clutSeptCd.setValue((String) bmData.get("clutSeptCd"));		/** column 정산구분코드 : clutSeptCd */
        	   systemkey.setValue((String) bmData.get("systemkey"));		/**  column SYSTEMKEY : systemkey */
        	   hanNm.setValue((String) bmData.get("hanNm"));				/** column 성명 : hanNm */
        	   deptNm.setValue((String) bmData.get("deptNm"));				/**  column 부서명 : deptNm */
        	   typNm.setValue((String) bmData.get("typNm"));
        	   resnRegnNum.setValue((String) bmData.get("resnRegnNum"));
        	   closFlag.setValue((Boolean) bmData.get("closFlag")? "Y" : "N");
        	   
        	   setPPRecord(bmData); 

        	   Yeta7300ToYe161010Detail(bmData, "itemYeta01");
           }
       }); 
	    
	    cpGrid.add(Yeta7300ToYe161010GridPanel); 
	    
	    fieldSetGrd.add(cpGrid);
	    lcStdGrid.add(fieldSetGrd);
	    
	    return lcStdGrid;
		
	}

	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {

		dpobCd 		= new HiddenField<String>();	/**  column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		plFrmYeta7300.add(dpobCd);
		
		systemkey 	= new HiddenField<String>();  	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("dpobCd");
		plFrmYeta7300.add(dpobCd);
		
		
        yrtxBlggYr  = new HiddenField<String>();	/** set 연말정산귀속년도 : yrtxBlggYr */
        yrtxBlggYr.setName("yrtxBlggYr");
		plFrmYeta7300.add(yrtxBlggYr);
		
		
        clutSeptCd 	= new HiddenField<String>();	/** set 정산구분코드 : clutSeptCd */
        clutSeptCd.setName("clutSeptCd");
		plFrmYeta7300.add(clutSeptCd);
		
		resnRegnNum = new HiddenField<String>();	/** set 주민등록번호 : resnoEncCntn */
		resnRegnNum.setName("resnRegnNum");
		plFrmYeta7300.add(resnRegnNum);		
		
		closFlag = new HiddenField<String>();	
		closFlag.setName("closFlag");
		plFrmYeta7300.add(closFlag);	
		
		
		
//		hanNm 		= new HiddenField<String>();	/** set 성명 : hanNm */
//		hanNm.setName("hanNm");
//		plFrmYeta7300.add(hanNm);
		
//		deptNm 		= new HiddenField<String>();	/** set 부서 : deptNm */
//		deptNm.setName("deptNm");
//		plFrmYeta7300.add(deptNm);
		
		
	  	srhSystemkey= new HiddenField<String>(); 
		
		
		sysComBass0150Dto = new PrgmComBass0150DTO();
	    sysComBass0300Dto = new PrgmComBass0300DTO();
	    sysComBass0320Dto = new PrgmComBass0320DTO();
	    sysComBass0400Dto = new PrgmComBass0400DTO();
	    sysComBass0500Dto = new PrgmComBass0500DTO();
	    msfCoCalendarDto = new SysCoCalendarDTO();
	    sysComBass0350Dto = new PrgmComBass0350DTO();
	     
	    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	    lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);		// 단위기관
	    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	     
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	    sysComBass0300Dto.setRpsttvCd("Y002");
	    lsClutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);			// 정산구분
	     
	    sysComBass0300Dto.setRpsttvCd("A002");
	    lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);			//고용구분
		
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	// 호봉
		
		sysComBass0300Dto.setRpsttvCd("B029");
		lsInctxWhtxTxamtMetnCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);// 소득세원천징수세액조정구분코드 
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	     
	     
	    //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	    lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);				// 급여년도
	    lsClutMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);				// 월
	    //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
	     
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
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd);
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

			}
		});
		   
	  	
	  	
		plFrmYeta7300.setLayout(new FlowLayout());

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
		
		srhYrtxBlggYr = new MSFComboBox<BaseModel>();
		srhYrtxBlggYr.setName("srhYrtxBlggYr");
		srhYrtxBlggYr.setForceSelection(true);
		srhYrtxBlggYr.setMinChars(1);
		srhYrtxBlggYr.setDisplayField("yearDisp");
		srhYrtxBlggYr.setValueField("year");
		srhYrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		// srhYrtxBlggYr.setEmptyText("--년도선택--");
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
		srhYrtxBlggYr.setStore(lsClutYrStore);
		srhYrtxBlggYr.setFieldLabel("년도");
		srhYrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		srhYrtxBlggYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmClutYr = se.getSelectedItem();
				if (bmClutYr != null) {
					if ((srhDeptCd.getListView().getChecked().size() == 1)
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
							sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수-------------------------------------------------
						srhBusinCd.setStore(lsBusinCd);
						srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {
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
		layoutContainer_8.add(srhYrtxBlggYr, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));

		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		
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
						checkYeta7300Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
		                	checkYeta7300Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	    					sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));    
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

					srhTypOccuCd.setEnabled(true);
					srhDtilOccuInttnCd.setEnabled(true);
					
	    		}  
	    	} 
	    });		
		
	    layoutContainer_155.add(srhEmymtDivCd, new FormData("100%"));
	    layoutContainer.add(layoutContainer_155, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    
	    
	    LayoutContainer layoutContainer_101 = new LayoutContainer();

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
			@Override
			public void componentKeyDown(ComponentEvent event) {

				srhHanNm.validate();
				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
					systemkey.setValue("");
					srhResnRegnNum.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					systemkey.setValue("");
					srhResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		});   		
		
		
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

		srhClutSeptCd = new ComboBox<BaseModel>();
		srhClutSeptCd.setName("srhClutSeptCd");
		srhClutSeptCd.setForceSelection(true);
		srhClutSeptCd.setMinChars(1);
		srhClutSeptCd.setDisplayField("commCdNm");
		srhClutSeptCd.setValueField("commCd");
		srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
		srhClutSeptCd.setEmptyText("--정산구분선택--");
		srhClutSeptCd.setSelectOnFocus(true);
		srhClutSeptCd.setReadOnly(false);
		srhClutSeptCd.setEnabled(true);
		srhClutSeptCd.setStore(lsClutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
//		srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//			
//			}
//		});
		layoutContainer_1.add(srhClutSeptCd, new FormData("100%"));

		

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
	    			checkYeta7300Auth("srhDeptCd", lsDeptCd); 
	    		}
	    	}
	    });    
	    srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	    	@Override
	    	public void handleEvent(ComponentEvent ce) { 
	    		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	    			if (srhDeptCd.getListView().getChecked().size() > 0) {  
	    				
	    				sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));    
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
						//checkYeta7300Auth("srhTypOccuCd", lsTypOccuCd); 
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
		
		
		lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcTypOccuCd.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		layoutContainer_21.setBorders(false);

		layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));

		
		LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());

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
		srhBusinCd.setReadOnly(true);
		srhBusinCd.setSelectOnFocus(true);
		srhBusinCd.getListView().setWidth("200px");
		srhBusinCd.setStore(lsBusinCd);
		srhBusinCd.setFieldLabel("사업");
		srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		layoutContainer_4.setBorders(false);
		
		
		layoutContainer_13.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 정산구분
		layoutContainer_13.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
		
		
		fieldSet.add(layoutContainer_13);
		
        
        LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());
        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(0); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16.setLayout(frmlytSch);

        LayoutContainer layoutContainer_16_1 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_1.setLayout(frmlytSch);

		utDpobNm = new MSFTextField(); 
		utDpobNm.setName("utDpobNm");
		utDpobNm.setFieldLabel("원천징수부서"); 
		//currAffnDeptNm.setLabelSeparator("");
		utDpobNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {

				if (MSFSharedUtils.allowNulls(utDpobNm.getValue()).trim().equals("")) {
					utDpobNm.setValue("");
				}
				if (MSFSharedUtils.paramNull(utDpobNm.getValue())) {
					utDpobNm.setValue("");
				}  
				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
					//if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
					utDpobNm.setValue("");
					//}
					fnPopupPrgmComPBass120001(utDpobNm.getValue());
				 
				}
				
				if (event.getKeyCode() == KeyCodes.KEY_BACKSPACE) {
					utDpobCd.setValue("");
				}
				
				super.componentKeyDown(event); 
			}
		});
		layoutContainer_16_1.add(utDpobNm, new FormData("100%"));  
		
		
		LayoutContainer layoutContainer_16_2 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		layoutContainer_16_2.setLayout(frmlytSch);

		btnUtDpobCd = new Button();
		btnUtDpobCd.setIcon(MSFMainApp.ICONS.search()); 
		btnUtDpobCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				if (MSFSharedUtils.allowNulls(utDpobNm.getValue()).trim().equals("")) {
					utDpobNm.setValue("");
				}
				fnPopupPrgmComPBass120001(utDpobNm.getValue());
			}
		});
		layoutContainer_16_2.add(btnUtDpobCd, new FormData("100%"));
		
		
		
		LayoutContainer layoutContainer_16_3 = new LayoutContainer(); 
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_16_3.setLayout(frmlytSch);

		utDpobCd = new MSFTextField(); 
		utDpobCd.setLabelSeparator("");
		utDpobCd.setName("utDpobCd");
		utDpobCd.setReadOnly(true);
		layoutContainer_16_3.add(utDpobCd, new FormData("100%"));
		
        
        
		layoutContainer_16.add(layoutContainer_16_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_16.add(layoutContainer_16_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.05));
		layoutContainer_16.add(layoutContainer_16_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
        
        lcSchCol3.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
        lcSchCol3.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 성명, 주민등록번호
        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
        
		fieldSet.add(lcSchCol3);

		plFrmYeta7300.add(fieldSet);
		// vp.add(panel);
	}

	/**
	 * 기본사항
	 */
	private LayoutContainer createTabForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FormLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");
		//엣지변환
		//fieldSet.setSize(670, 720);
		fieldSet.setSize(670, 920);
		
		// 기본정보
		FieldSet infoFldSet = new FieldSet();
				
		LayoutContainer lcFldSet = new LayoutContainer();
				
		LayoutContainer lcFldSet1 = new LayoutContainer();
		lcFldSet1.setLayout(new ColumnLayout());
				
		LayoutContainer lcFldSet1_1 = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet1_1.setLayout(frmlytSch);
				
		tnm = new TextField<String>();
		tnm.setFieldLabel("근무처명");
		lcFldSet1_1.add(tnm, new FormData("100%"));
				
		lcFldSet1.add(lcFldSet1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
		LayoutContainer lcFldSet1_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet1_2.setLayout(frmlytSch);
				
		bsnoEncCntn = new TextField<String>();
		bsnoEncCntn.setFieldLabel("사업자등록번호");
		new TextFieldMask<String>(bsnoEncCntn, "999-99-99999");
		lcFldSet1_2.add(bsnoEncCntn, new FormData("100%"));
		lcFldSet1.add(lcFldSet1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
				
		LayoutContainer lcFldSet1_3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet1_3.setLayout(frmlytSch);
				
		lcFldSet1.add(lcFldSet1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		
		lcFldSet.add(lcFldSet1);
		
				
		LayoutContainer lcFldSet2 = new LayoutContainer();
		lcFldSet2.setLayout(new ColumnLayout());
				
		LayoutContainer lcFldSet2_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet2_1.setLayout(frmlytSch);
			
		deptNm = new TextField<String>();
		deptNm.setFieldLabel("부서명");
		deptNm.setReadOnly(true);
		lcFldSet2_1.add(deptNm, new FormData("100%"));
				
		lcFldSet2.add(lcFldSet2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			
		LayoutContainer lcFldSet2_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet2_2.setLayout(frmlytSch);
				
		hanNm = new TextField<String>();
		hanNm.setFieldLabel("성 명");
		hanNm.setReadOnly(true);
		lcFldSet2_2.add(hanNm, new FormData("80%"));
		lcFldSet2.add(lcFldSet2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
				
				
		LayoutContainer lcFldSet2_3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet2_3.setLayout(frmlytSch);
				
		typNm = new TextField<String>();
		typNm.setFieldLabel("직종(사업)명");
		typNm.setReadOnly(true);
		lcFldSet2_3.add(typNm, new FormData("100%"));
				
		lcFldSet2.add(lcFldSet2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		lcFldSet.add(lcFldSet2);
				
		LayoutContainer lcFldSet3 = new LayoutContainer();
		lcFldSet3.setLayout(new ColumnLayout());
				
		LayoutContainer lcFldSet3_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(30);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet3_1.setLayout(frmlytSch);
				
		fileSbtYn = new CheckBox();
		fileSbtYn.setName("fileSbtYn");
		fileSbtYn.setBoxLabel("전자파일 이용제출");
		fileSbtYn.setHideLabel(true);
		fileSbtYn.setValueAttribute("Y");
		fileSbtYn.setReadOnly(true);

		lcFldSet3_1.add(fileSbtYn, new FormData("100%"));
		lcFldSet3.add(lcFldSet3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			
		LayoutContainer lcFldSet3_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(30);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet3_2.setLayout(frmlytSch);
				
		fileSbtBtn = new Button("소득공제자료추출");
		fileSbtBtn.setIcon(MSFMainApp.ICONS.pdf16());
		fileSbtBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
			
				if (systemkey.getValue() == null) {
						
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"좌측 근로자급여정보에서 대상자를 선택해주세요.", null);
					
				}else {
					
					YetaP720003 yetaP720003Form = new YetaP720003(ActionDatabase.READ, getThis());
					final MSFFormWindows msFwYeta720003 = new MSFFormWindows("자료추출상세내역",yetaP720003Form, "닫기", "690px", "250px", false);
					msFwYeta720003.show();
					yetaP720003Form.setMSFFormWindows(msFwYeta720003);
					// 팝업이 닫히면 탭을 다시 조회한다.
					msFwYeta720003.addListener(Events.Hide,new Listener<BaseEvent>() { 
			    		@Override
			    		public void handleEvent(BaseEvent be) { 
			    			getItemYeta01();
			    		}
					});
	
					BaseModel bmRecord = new BaseModel();
								
					bmRecord.set("dpobCd"		, dpobCd.getValue());
					bmRecord.set("clutSeptCd"	, clutSeptCd.getValue());
					bmRecord.set("systemkey"	, systemkey.getValue());
					bmRecord.set("yrtxBlggYr"	, yrtxBlggYr.getValue());
					bmRecord.set("deptNm"		, deptNm.getValue());
					bmRecord.set("srhHanNm"		, hanNm.getValue());
					bmRecord.set("typOccuNm"	, typNm.getValue()); 
					bmRecord.set("resnRegnNum"	, resnRegnNum.getValue()); 
	
					yetaP720003Form.bind(bmRecord);
					
					
				}	
			}
		});
		lcFldSet3_2.add(fileSbtBtn);
		lcFldSet3.add(lcFldSet3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		LayoutContainer lcFldSet3_4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(30);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet3_4.setLayout(frmlytSch);
				
		fileSbtReBtn = new Button("소득공제재적용");
		fileSbtReBtn.setIcon(MSFMainApp.ICONS.pdf16());
		fileSbtReBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
			
				if (systemkey.getValue() == null) {
						
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"좌측 근로자급여정보에서 대상자를 선택해주세요.", null);
					
				}else {
					MessageBox.confirm("소득공제신고서 재적용", "선택된 대상자의 기존 정보를 삭제 후 재적용합니다.<br> 진행 하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {

								String pymtYr = MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year");
								if (MSFSharedUtils.paramNull(pymtYr)) {MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산년을 선택하셔야 합니다.", null);
									return;
								}
								if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"))) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"대상자를 선택하시려면 정산구분을 선택하셔야 합니다.", null);
									return;
								}
				
								final Tracker tracker = new Tracker();
								tracker.setStatus(false);
				
								Ye161010DTO ye161010Dto = new Ye161010DTO();   
								
								ye161010Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */
								ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")));/** column 연말정산귀속년도 : edacRvyy */
								ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd")));/** column 정산구분코드 : settGbcd */
								ye161010Dto.setSystemkey(systemkey.getValue());
								final MessageBox box = MessageBox.wait("소득공제신고서재적용","소득공제신고서 재 적용 처리 중 입니다...", "소득공제 재 적용 결과 생성 중...");
								final Timer t = new Timer() {
									public void run() {
										if (tracker.getStatus()) {
											cancel();
											box.close();
										}
									}
								};
								t.scheduleRepeating(500);
				
								yeta7300Service.fnYeta7300Ye161010_2022_SbtVolUse(ye161010Dto ,new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
									public void onFailure(Throwable caught) {
										
										tracker.setStatus(true);
										List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
										ShowMessageBM smBm = new ShowMessageBM();
										smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
										smBm.setMenu("Yeta");
										smBm.setPhase("소득공제 재적용 에러");
										smBm.setMessage(caught.getLocalizedMessage());
										smBm.setContent(caught.getMessage());
										bmResult.add(smBm);
										PagingLoadResult<ShowMessageBM> retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0,bmResult.size());
											
										ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ,getThis());
										MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기", "620px","510px", true);
										msFwMessage.show();
										showMessageForm.setMSFFormWindows(msFwMessage);
												
									}
				
									public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
										tracker.setStatus(true);
										if (MSFSharedUtils.paramNotNull(result)) {
											ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ,getThis());
											BaseModel tmRec = new BaseModel();
											MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",	showMessageForm,"닫기", "620px","510px", true);
											msFwMessage.show();
											showMessageForm.setMSFFormWindows(msFwMessage);
										}
										
//										reFresh();
									}
								});
							}
						}
					});
					
				}	
			}
		});
		lcFldSet3_4.add(fileSbtReBtn);
		lcFldSet3.add(lcFldSet3_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));		
		
		LayoutContainer lcFldSet3_3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(30);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet3_3.setLayout(frmlytSch);
				
		fileSbtBtn01 = new Button("개별간소화파일");
		fileSbtBtn01.setIcon(MSFMainApp.ICONS.pdf16());
		fileSbtBtn01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if (systemkey.getValue() == null) {
					
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"좌측 근로자급여정보에서 대상자를 선택해주세요.", null);
					
				}else {
					YetaP720001 yetaP720001Form = new YetaP720001(ActionDatabase.READ, getThis());
					MSFFormWindows msFwYeta720001 = new MSFFormWindows("자료추출상세내역",yetaP720001Form, "닫기", "920px", "710px", false);
					msFwYeta720001.show();
					yetaP720001Form.setMSFFormWindows(msFwYeta720001);

					BaseModel bmRecord = new BaseModel();
							
					bmRecord.set("dpobCd"		, dpobCd.getValue());
					bmRecord.set("clutSeptCd"	, clutSeptCd.getValue());
					bmRecord.set("systemkey"	, systemkey.getValue());
					bmRecord.set("yrtxBlggYr"	, yrtxBlggYr.getValue());
					bmRecord.set("deptNm"		, deptNm.getValue());
					bmRecord.set("fnm"			, hanNm.getValue());
					bmRecord.set("typOccuNm"	, typNm.getValue()); 

					yetaP720001Form.bind(bmRecord);
				}
			}
		});
		lcFldSet3_3.add(fileSbtBtn01);
		lcFldSet3.add(lcFldSet3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
				
		LayoutContainer lcFldSet3_5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(30);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcFldSet3_5.setLayout(frmlytSch);
		
		//연말정산2022_일괄간소화 주석처리후 버튼도 없앰
		/*fileSbtBtn02 = new Button("일괄간소화파일");
		fileSbtBtn02.setIcon(MSFMainApp.ICONS.pdf16());
		fileSbtBtn02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if (systemkey.getValue() == null) {
					
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"좌측 근로자급여정보에서 대상자를 선택해주세요.", null);
					
				}else {
			
					YetaP720002 yetaP720002Form = new YetaP720002(ActionDatabase.READ, getThis());
					final MSFFormWindows msFwYeta720002 = new MSFFormWindows("자료추출상세내역",yetaP720002Form, "닫기", "945px", "710px", false);
					msFwYeta720002.show();
					yetaP720002Form.setMSFFormWindows(msFwYeta720002);

					BaseModel bmRecord = new BaseModel();
						
					bmRecord.set("dpobCd"		, dpobCd.getValue());
					bmRecord.set("clutSeptCd"	, clutSeptCd.getValue());
					bmRecord.set("systemkey"	, systemkey.getValue());
					bmRecord.set("yrtxBlggYr"	, yrtxBlggYr.getValue());
					bmRecord.set("deptNm"		, deptNm.getValue());
					bmRecord.set("fnm"			, hanNm.getValue());
					bmRecord.set("typOccuNm"	, typNm.getValue()); 

					yetaP720002Form.bind(bmRecord);
				}
			}
		});
		lcFldSet3_5.add(fileSbtBtn02);*/
		
		lcFldSet3.add(lcFldSet3_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lcFldSet.add(lcFldSet3);
		
				
		infoFldSet.add(lcFldSet);

		fieldSet.add(infoFldSet);		

		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeaderVisible(false);
		cntntpnlNewContentpanel.setCollapsible(false);
		cntntpnlNewContentpanel.setFrame(true);
		cntntpnlNewContentpanel.setLayout(new FlowLayout());

		tabsYeta7300 = new TabPanel();
		tabsYeta7300.setAutoWidth(false);
		tabsYeta7300.setAnimScroll(false);
		tabsYeta7300.setTabScroll(true);
		tabsYeta7300.setPlain(true);
		//엣지변환
		//tabsYeta7300.setSize(660, 720);
		tabsYeta7300.setSize(660, 920);
		tabsYeta7300.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				// 탭선택
				Yeta7300ToYe161010Detail( Yeta7300ToYe161010GridPanel.getCurrentlySelectedItem(), tabsYeta7300.getSelectedItem().getId()); 
					
			}
		});

		
		/** 우측 탭 시작 **/
		// 기본사항
		TabItem itemYeta01 = new TabItem();
		itemYeta01.setId("itemYeta01");
		itemYeta01.setText("기본사항");
		itemYeta01.setLayout(new FormLayout());
		itemYeta01.add(YetaData01(), new FormData("100%"));
		tabsYeta7300.add(itemYeta01);
		
		// 인적공제
		TabItem itemYeta02 = new TabItem();
		itemYeta02.setId("itemYeta02");
		itemYeta02.setText("인적공제");
		itemYeta02.setLayout(new FormLayout());
		itemYeta02.add(yetaData02(), new FormData("100%"));
		tabsYeta7300.add(itemYeta02);
		
		// 소득공제
		TabItem itemYeta03 = new TabItem();
		itemYeta03.setId("itemYeta03");
		itemYeta03.setText("소득공제");
		itemYeta03.setLayout(new FormLayout());
		itemYeta03.add(yetaData03(), new FormData("100%"));
		tabsYeta7300.add(itemYeta03);
		
		// 연금보험료공제
		TabItem itemYeta04 = new TabItem();
		itemYeta04.setId("itemYeta04");
		itemYeta04.setText("연금보험료공제");
		itemYeta04.setLayout(new FormLayout());
		itemYeta04.add(yetaData04(), new FormData("100%"));
		tabsYeta7300.add(itemYeta04);		
		
		
		// 특별소득공제
		TabItem itemYeta05 = new TabItem();
		itemYeta05.setId("itemYeta05");
		itemYeta05.setText("특별소득공제");
		itemYeta05.setLayout(new FormLayout());
		itemYeta05.add(yetaData05(), new FormData("100%"));
		tabsYeta7300.add(itemYeta05);		

		
		// 그밖의소득공제1
		TabItem itemYeta06 = new TabItem();
		itemYeta06.setId("itemYeta06");
		itemYeta06.setText("그밖의소득공제1");
		itemYeta06.setLayout(new FormLayout());
		itemYeta06.add(yetaData06(), new FormData("100%"));
		tabsYeta7300.add(itemYeta06);

		
		// 그밖의소득공제2
		TabItem itemYeta07 = new TabItem();
		itemYeta07.setId("itemYeta07");
		itemYeta07.setText("그밖의소득공제2");
		itemYeta07.setLayout(new FormLayout());
		itemYeta07.add(yetaData07(), new FormData("100%"));
		tabsYeta7300.add(itemYeta07);

		// 세액감면및세액공제1
		TabItem itemYeta08 = new TabItem();
		itemYeta08.setId("itemYeta08");
		itemYeta08.setText("세액감면및세액공제1");
		itemYeta08.setLayout(new FormLayout());
		itemYeta08.add(yetaData08(), new FormData("100%"));
		itemYeta08.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				
				//탭선택
				Yeta7300ToYe161010Detail(Yeta7300ToYe161010GridPanel.getCurrentlySelectedItem(), tabsItemYeta08.getSelectedItem().getId());

			}
		});
		
		
		tabsYeta7300.add(itemYeta08);		
		

		// 세액감면및세액공제2
		TabItem itemYeta09 = new TabItem();
		itemYeta09.setId("itemYeta09");
		itemYeta09.setText("세액감면및세액공제2");
		itemYeta09.setLayout(new FormLayout());
		itemYeta09.add(yetaData09(), new FormData("100%"));
		tabsYeta7300.add(itemYeta09);			

		// 추가제출서류
		TabItem itemYeta10 = new TabItem();
		itemYeta10.setId("itemYeta10");
		itemYeta10.setText("추가제출서류");
		itemYeta10.setLayout(new FormLayout());
		itemYeta10.add(yetaData10(), new FormData("100%"));
		tabsYeta7300.add(itemYeta10);	
		

		fieldSet.add(tabsYeta7300);

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
		    
		 Yeta7300ToYe161030GridPanel = new MSFGridPanel(ye161030Def, false, false, false, false, false);
		 Yeta7300ToYe161030GridPanel.setHeaderVisible(false);  
		 Yeta7300ToYe161030GridPanel.setBodyBorder(true);
		 Yeta7300ToYe161030GridPanel.setBorders(true);
		    
		 cpGrid.add(Yeta7300ToYe161030GridPanel); 
		    
		 lcStdGrid.add(cpGrid);
		    
		 return lcStdGrid;		 

	 }
	 
//	 //소득공제명세 grid(합계)
//	 private LayoutContainer occupationalRBottom3() {
//		 
//		 FieldSet fieldSetGrd = new FieldSet();  
//		 fieldSetGrd.setHeadingHtml("합계");
//		 fieldSetGrd.setBorders(false);
//		 
//		 LayoutContainer lcStdGrid = new LayoutContainer();
//		 FormLayout frmlytStd = new FormLayout();  
//		 lcStdGrid.setLayout(frmlytStd);  
//		    
//		 ContentPanel cpGrid = new ContentPanel();  
//		 cpGrid.setBodyBorder(false); 
//		 cpGrid.setHeaderVisible(false);   
//		 cpGrid.setLayout(new FitLayout());      
//		 cpGrid.setSize(610, 80);  
//		    
//		 yeta300ToYeta3220GridPanel4 = new MSFGridPanel(Yeta3220Def_02_SUM, false, false, false, false, false);
//		 yeta300ToYeta3220GridPanel4.setHeaderVisible(false);  
//		 yeta300ToYeta3220GridPanel4.setBodyBorder(true);
//		 yeta300ToYeta3220GridPanel4.setBorders(true);
//		 yeta300ToYeta3220GridPanel4.getBottomComponent().setVisible(false);
//		 
//		 yeta300ToYeta3220GridPanel4.getGrid().getColumnModel().addHeaderGroup(0, 3, new HeaderGroupConfig("보험료", 1, 3));
//		 yeta300ToYeta3220GridPanel4.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("신용카드 등 사용액", 1, 5)); 
//		    
//		 cpGrid.add(yeta300ToYeta3220GridPanel4); 
//		    
//		 lcStdGrid.add(cpGrid);
//		 fieldSetGrd.add(lcStdGrid);
//		 return fieldSetGrd;		 		 
//	
//	 }
	 
	 //소득공제명세 grid(국세청자료)
	 private LayoutContainer occupationalRBottom3_01() {
		 
		 FieldSet fieldSetGrd = new FieldSet();  
		 fieldSetGrd.setHeadingHtml("국세청자료");
		 fieldSetGrd.setBorders(false);
		 
		 LayoutContainer lcStdGrid = new LayoutContainer();
		 FormLayout frmlytStd = new FormLayout();  
		 lcStdGrid.setLayout(frmlytStd);  
		    
		 ContentPanel cpGrid = new ContentPanel(); 
		 cpGrid.setStyleAttribute("paddingLeft"	, "5px");
		 cpGrid.setStyleAttribute("paddingRight", "5px");
		 cpGrid.setBodyBorder(false); 
		 cpGrid.setHeaderVisible(false);   
		 cpGrid.setLayout(new FitLayout());      
		 cpGrid.setSize(640, 200);  
		    
		 Yeta7300ToYe161040GridPanel_01 = new MSFGridPanel(ye161040Def_01, false, false, false, false, false);
		 Yeta7300ToYe161040GridPanel_01.setHeaderVisible(false);  
		 Yeta7300ToYe161040GridPanel_01.setBodyBorder(true);
		 Yeta7300ToYe161040GridPanel_01.setBorders(true);
		 Yeta7300ToYe161040GridPanel_01.getBottomComponent().setVisible(false);
		 Yeta7300ToYe161040GridPanel_01.getGrid().getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("보험료", 1, 4));
		 Yeta7300ToYe161040GridPanel_01.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("신용카드 등 사용액", 1, 13)); 
		 
		 
		 AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
		 payrSummaryRow.setHtml(Ye161030BM.ATTR_TXPRNM, "합 계");  
		 payrSummaryRow.setCellStyle(Ye161030BM.ATTR_TXPRNM,"summary_color");						/** column 성명 : txprNm */
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_HIFEDDCTRGTAMT		, SummaryType.SUM);		/** column 건강등보험료 : hifeDdcTrgtAmt */   
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_MCURUITRGTAMT		, SummaryType.SUM);		/** column 고용보험료 : hifeDdcTrgtAmt */     
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT	, SummaryType.SUM);		/** column 보장성보험료 : cvrgInscDdcTrgtAmt */   
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_DSBRDDCTRGTAMT		, SummaryType.SUM); 	/** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_MDXPSDDCTRGTAMT		, SummaryType.SUM); 	/** column 의료비금액 : mdxpsDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_SCXPSDDCTRGTAMT		, SummaryType.SUM);  	/** column 교육비금액 : scxpsDdcTrgtAmt */
		 
		 //2022연말정산_추가
		 //2021신용카드등사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTCRDCPRESUM		, SummaryType.SUM); 	/** column 전년도 신용카드등사용액: totCrdcPreSum */
		 //2022신용카드등사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTCRDCCURRSUM		, SummaryType.SUM); 	/** column 당해년도 신용카드등사용액 : totCrdcCurrSum */
		 //2021전통시장사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTTDMRPRESUM		, SummaryType.SUM); 	/** column 전년도 전통시장사용액 : totTdmrPreSum */
		 //2022전통시장사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTTDMRCURRSUM		, SummaryType.SUM); 	/** column 당해년도 전통시장사용액 : totTdmrCurrSum */
		 //상반기대중교통사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TFHYPBTAMT		, SummaryType.SUM); 	/** column 상반기 대중교통사용액 : tfhyPbtAmt */
		 //하반기대중교통사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_SHFYPBTAMT		, SummaryType.SUM); 	/** column 하반기 대중교통사용액 : shfyPbtAmt */
		 
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CRDCDDCTRGTAMT		, SummaryType.SUM); 	/** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT	, SummaryType.SUM); 	/** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
		 
		 //2022연말정산_추가
		 //제로페이
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_ZRTDDDCTRGTAMT	, SummaryType.SUM); 	
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CSHPTDDCTRGTAMT		, SummaryType.SUM); 	/** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_BOOKSHOWAMT		, SummaryType.SUM); 	/** column 도서구입비 : bookShowAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TDMRDDCTRGTAMT		, SummaryType.SUM);  	/** column 전통시작사용금액 : tdmrDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_PBTDDCTRGTAMT		, SummaryType.SUM); 	/** column 대중교통이용금액 : pbtDdcTrgtAmt */
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CONBDDCTRGTAMT		, SummaryType.SUM); 	/** column 기부금액 : conbDdcTrgtAmt */
		 

		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_HIFEDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_MCURUITRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_DSBRDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_MDXPSDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_SCXPSDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)")); 
		 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CRDCDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)"));  
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CSHPTDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)")); 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_BOOKSHOWAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_TDMRDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_PBTDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)")); 
		 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CONBDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));  
		 
		 
		 Yeta7300ToYe161040GridPanel_01.getGrid().getColumnModel().addAggregationRow(payrSummaryRow); 
		    
		 
		 cpGrid.add(Yeta7300ToYe161040GridPanel_01); 
		    
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
		 cpGrid.setStyleAttribute("paddingLeft"	, "5px");
		 cpGrid.setStyleAttribute("paddingRight", "5px");
		 cpGrid.setBodyBorder(false); 
		 cpGrid.setHeaderVisible(false);   
		 cpGrid.setLayout(new FitLayout());      
		 cpGrid.setSize(640, 200);  
		    
		 Yeta7300ToYe161040GridPanel_02 = new MSFGridPanel(ye161040Def_02, false, false, false, false, false);
		 Yeta7300ToYe161040GridPanel_02.setHeaderVisible(false);  
		 Yeta7300ToYe161040GridPanel_02.setBodyBorder(true);
		 Yeta7300ToYe161040GridPanel_02.setBorders(true);
		 Yeta7300ToYe161040GridPanel_02.getBottomComponent().setVisible(false);
		 
		 Yeta7300ToYe161040GridPanel_02.getGrid().getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("보험료", 1, 4));
		 Yeta7300ToYe161040GridPanel_02.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("신용카드 등 사용액", 1, 13)); 
		 
		 
		 AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
		 payrSummaryRow.setHtml(Ye161030BM.ATTR_TXPRNM, "합 계");  
		 payrSummaryRow.setCellStyle(Ye161030BM.ATTR_TXPRNM,"summary_color");						/** column 성명 : txprNm */
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_HIFEDDCTRGTAMT		, SummaryType.SUM);		/** column 건강등보험료 : hifeDdcTrgtAmt */   
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_MCURUITRGTAMT		, SummaryType.SUM);		/** column 고용보험료 : hifeDdcTrgtAmt */     
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT	, SummaryType.SUM);		/** column 보장성보험료 : cvrgInscDdcTrgtAmt */   
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_DSBRDDCTRGTAMT		, SummaryType.SUM); 	/** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_MDXPSDDCTRGTAMT		, SummaryType.SUM); 	/** column 의료비금액 : mdxpsDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_SCXPSDDCTRGTAMT		, SummaryType.SUM);  	/** column 교육비금액 : scxpsDdcTrgtAmt */
		 
		//2022연말정산_추가
		 //2021신용카드등사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTCRDCPRESUM		, SummaryType.SUM); 	/** column 전년도 신용카드등사용액: totCrdcPreSum */
		 //2022신용카드등사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTCRDCCURRSUM		, SummaryType.SUM); 	/** column 당해년도 신용카드등사용액 : totCrdcCurrSum */
		 //2021전통시장사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTTDMRPRESUM		, SummaryType.SUM); 	/** column 전년도 전통시장사용액 : totTdmrPreSum */
		 //2022전통시장사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TOTTDMRCURRSUM		, SummaryType.SUM); 	/** column 당해년도 전통시장사용액 : totTdmrCurrSum */
		 //상반기대중교통사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TFHYPBTAMT		, SummaryType.SUM); 	/** column 상반기 대중교통사용액 : tfhyPbtAmt */
		 //하반기대중교통사용액
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_SHFYPBTAMT		, SummaryType.SUM); 	/** column 하반기 대중교통사용액 : shfyPbtAmt */
		 
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CRDCDDCTRGTAMT		, SummaryType.SUM); 	/** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT	, SummaryType.SUM); 	/** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
		 
		//2022연말정산_추가
		 //제로페이
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_ZRTDDDCTRGTAMT	, SummaryType.SUM);
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CSHPTDDCTRGTAMT		, SummaryType.SUM); 	/** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_BOOKSHOWAMT		, SummaryType.SUM); 	/** column 도서이용금액 : bookShowAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_TDMRDDCTRGTAMT		, SummaryType.SUM);  	/** column 전통시작사용금액 : tdmrDdcTrgtAmt */
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_PBTDDCTRGTAMT		, SummaryType.SUM); 	/** column 대중교통이용금액 : pbtDdcTrgtAmt */
		 
		 payrSummaryRow.setSummaryType(Ye161040BM.ATTR_CONBDDCTRGTAMT		, SummaryType.SUM); 	/** column 기부금액 : conbDdcTrgtAmt */
		 

		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_HIFEDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_MCURUITRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_DSBRDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_MDXPSDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_SCXPSDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)")); 
		 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CRDCDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)"));  
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CSHPTDDCTRGTAMT	, NumberFormat.getFormat("#,##0;(#,##0)")); 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_BOOKSHOWAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_TDMRDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_PBTDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)")); 
		 
		 payrSummaryRow.setSummaryFormat(Ye161040BM.ATTR_CONBDDCTRGTAMT		, NumberFormat.getFormat("#,##0;(#,##0)"));   
		 
		 Yeta7300ToYe161040GridPanel_02.getGrid().getColumnModel().addAggregationRow(payrSummaryRow); 
		    
		 cpGrid.add(Yeta7300ToYe161040GridPanel_02); 
		    
		 lcStdGrid.add(cpGrid);
		 fieldSetGrd.add(lcStdGrid);
		 
		 return fieldSetGrd;		 		 
	
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
		cp01.setSize("660", "720");

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);
		

		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytSch);
		
	

		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("기본사항");
		
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_23 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_23.setLayout(frmlytSch);
		layoutContainer_23.setBorders(false);

		LayoutContainer layoutContainer_26 = new LayoutContainer();

		layoutContainer_26.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_470 = new LayoutContainer();

		LabelField lblfldNewLabelfield = new LabelField("세대주:");
		lblfldNewLabelfield.setStyleAttribute("textAlign", "RIGHT");
		layoutContainer_470.add(lblfldNewLabelfield);
		layoutContainer_26.add(layoutContainer_470, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			
			
		hshrClCd = new RadioGroup();
		hshrClCd.setFieldLabel("세대주구분");
		// hshrClCd.setHeight("세대주구분");

		Radio hshrClCd1 = new Radio();
		// layoutContainer_26.add(rdNewRadio);
		hshrClCd.add(hshrClCd1);
		hshrClCd1.setBoxLabel("세대주");
		hshrClCd1.setHideLabel(true);
		hshrClCd1.setValueAttribute("1");

		Radio hshrClCd0 = new Radio();
		hshrClCd.add(hshrClCd0);
		// layoutContainer_26.add(rdNewRadio_1);
		hshrClCd0.setBoxLabel("세대원");
		hshrClCd0.setHideLabel(true);
		hshrClCd0.setValueAttribute("2");
			
		layoutContainer_26.add(hshrClCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		layoutContainer_23.add(layoutContainer_26, new FormData("100%"));
		layoutContainer_21.add(layoutContainer_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

			
		LayoutContainer layoutContainer_25 = new LayoutContainer();
		layoutContainer_25.setLayout(new ColumnLayout());

		//
		LayoutContainer layoutContainer_32 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(90);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytSch);

		dtyStrtDt = new MSFDateField();
		// emymtBgnnDt.setWidth(100);
		dtyStrtDt.setFieldLabel("근무기간");
		dtyStrtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer_32.add(dtyStrtDt, new FormData("100%"));
//			dtyStrtDt.setHeight("");

		layoutContainer_32.setBorders(false);

		//
		LayoutContainer layoutContainer_34 = new LayoutContainer();
		// layoutContainer_34.setWidth(100);
		FormLayout frmlytSch1 = new FormLayout();
		frmlytSch1.setLabelWidth(10);
		// frmlytSch.setLabelWidth(100);
		// frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_34.setLayout(frmlytSch1);

		dtyEndDt = new MSFDateField();
		// emymtEndDt.setWidth(100);
		dtyEndDt.setLabelSeparator("~");
		dtyEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer_34.add(dtyEndDt, new FormData("100%"));
		layoutContainer_23.add(layoutContainer_25, new FormData("100%"));


		// 근무기간 add
		layoutContainer_25.add(layoutContainer_32, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_25.add(layoutContainer_34, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		LayoutContainer layoutContainer_27 = new LayoutContainer();
		layoutContainer_27.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_457 = new LayoutContainer();

		
		LabelField lblfldNewLabelfield_1 = new LabelField("거주지구분: ");
		lblfldNewLabelfield_1.setStyleAttribute("textAlign", "RIGHT");
		layoutContainer_457.setStyleAttribute("verticalAlign", "bottom");
		layoutContainer_457.add(lblfldNewLabelfield_1);
		layoutContainer_27.add(layoutContainer_457, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		rsdtClCd = new RadioGroup();

		Radio rsdtClCd1 = new Radio();
		rsdtClCd.add(rsdtClCd1);
		rsdtClCd1.setBoxLabel("거주자");
		rsdtClCd1.setHideLabel(true);
		rsdtClCd1.setValueAttribute("1");

		Radio rsdtClCd0 = new Radio();
		rsdtClCd.add(rsdtClCd0);
		rsdtClCd0.setBoxLabel("비거주자");
		rsdtClCd0.setHideLabel(true);
		rsdtClCd0.setValueAttribute("0");
			
		layoutContainer_27.add(rsdtClCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			
		layoutContainer_23.add(layoutContainer_27, new FormData("100%"));

		LayoutContainer layoutContainer_24 = new LayoutContainer();
		layoutContainer_24.setBorders(false);

		LayoutContainer lucnNatn = new LayoutContainer(new ColumnLayout());
		LayoutContainer lucnNatn1_1 = new LayoutContainer();

		Button btnNatnCd = new Button();
		btnNatnCd.setIcon(MSFMainApp.ICONS.search());
		btnNatnCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (MSFSharedUtils.allowNulls(rsplNtnInfrNm.getValue()).trim().equals("")) {
					rsplNtnInfrCd.setValue("");
				}
				fnPopupBass0300("A001", "natn");
			}
		});
				
			
		rsplNtnInfrNm = new TextFieldWithButton<String>(btnNatnCd);
		rsplNtnInfrNm.setFieldLabel("국 적");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lucnNatn1_1.setLayout(frmlytSch);
		
	
		rsplNtnInfrCd = new HiddenField<String>();
		rsplNtnInfrCd.setName("rsplNtnInfrCd");
		rsplNtnInfrCd.setFieldLabel("rsplNtnInfrCd");
		rsplNtnInfrNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {

				rsplNtnInfrCd.validate();
				if (MSFSharedUtils.allowNulls(rsplNtnInfrNm.getValue()).trim().equals("")) {
					rsplNtnInfrCd.setValue("");
				}
				if (MSFSharedUtils.paramNull(rsplNtnInfrNm.getValue())) {
					rsplNtnInfrCd.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {

					rsplNtnInfrNm.setValue("");
					rsplNtnInfrItem.setValue("");
					fnPopupBass0300("A001", "natn");
					
				}
			}
		});
		lucnNatn1_1.add(rsplNtnInfrNm, new FormData("100%"));

		LayoutContainer lucnNatn1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		lucnNatn1_2.setLayout(frmlytSch);
		
		rsplNtnInfrItem = new TextField<String>();
		rsplNtnInfrItem.setReadOnly(true);
		rsplNtnInfrItem.setLabelSeparator("");
		rsplNtnInfrItem.setEnabled(false);
		lucnNatn1_2.add(rsplNtnInfrItem, new FormData("100%"));
			
		lucnNatn.add(lucnNatn1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		lucnNatn.add(lucnNatn1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			
		layoutContainer_24.add(lucnNatn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			
		LayoutContainer lcTabLeft = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcTabLeft1_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTabLeft1_1.setLayout(frmlytSch);
		
		reStrtDt = new MSFDateField();
		new DateFieldMask(reStrtDt, "9999.99.99");
		reStrtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
	
		reStrtDt.setFieldLabel("감면기간");
		lcTabLeft1_1.add(reStrtDt, new FormData("100%"));
		lcTabLeft.add(lcTabLeft1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
			
		
		LayoutContainer lcTabLeft1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(10);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTabLeft1_2.setLayout(frmlytSch);
		
		reEndDt = new MSFDateField();
		new DateFieldMask(reEndDt, "9999.99.99");
		reEndDt.setLabelSeparator("");
		reEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		reEndDt.setFieldLabel("~");
		lcTabLeft1_2.add(reEndDt, new FormData("100%"));
		lcTabLeft.add(lcTabLeft1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_24.add(lcTabLeft);

		LayoutContainer lucnRedt = new LayoutContainer(new ColumnLayout());
		LayoutContainer lucnRedt1_1 = new LayoutContainer();

		Button btnRedtCd = new Button();
		btnRedtCd.setIcon(MSFMainApp.ICONS.search());
		btnRedtCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (MSFSharedUtils.allowNulls(rsplNtnNm.getValue()).trim().equals("")) {
					rsplNtnCd.setValue("");
				}
				fnPopupBass0300("A001", "redt");
			}
		});
		
		rsplNtnNm = new TextFieldWithButton<String>(btnRedtCd);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lucnRedt1_1.setLayout(frmlytSch);
		
		rsplNtnNm.setFieldLabel("거주지국");
		rsplNtnCd = new HiddenField<String>();
		rsplNtnCd.setName("rsplNtnCd");
		rsplNtnCd.setFieldLabel("rsplNtnCd");
		rsplNtnNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {

				rsplNtnCd.validate();
				if (MSFSharedUtils.allowNulls(rsplNtnNm.getValue()).trim().equals("")) {
					rsplNtnCd.setValue("");
				}
				if (MSFSharedUtils.paramNull(rsplNtnNm.getValue())) {
					rsplNtnCd.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					if (MSFSharedUtils.allowNulls(rsplNtnNm.getValue()).trim().equals("")) {
						rsplNtnNm.setValue("");
						rsplNtnItem.setValue("");
					}
					fnPopupBass0300("A001", "redt");
				}
				super.componentKeyDown(event);
			}
		});
		lucnRedt1_1.add(rsplNtnNm, new FormData("100%"));
			
			
		LayoutContainer lucnRedt1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		lucnRedt1_2.setLayout(frmlytSch);
		
		rsplNtnItem = new TextField<String>();
		rsplNtnItem.setReadOnly(true);
		rsplNtnItem.setLabelSeparator("");
		rsplNtnItem.setEnabled(false);
		lucnRedt1_2.add(rsplNtnItem, new FormData("100%"));
			
		lucnRedt.add(lucnRedt1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		lucnRedt.add(lucnRedt1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_24.add(lucnRedt);

		layoutContainer_21.add(layoutContainer_24,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		
		//-----------------------2018년 추가 필드   ------------------------------------------------------------------
		LayoutContainer layoutContainer_241 = new LayoutContainer(new ColumnLayout());
		LayoutContainer sub01 = new LayoutContainer(new ColumnLayout());

		LayoutContainer sub01_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70); 
		sub01_1.setLayout(frmlytSch);
		
		inpmYn = new CheckBox(); 
		inpmYn.setName("inpmYn");
		inpmYn.setBoxLabel("정산분할납부");
		inpmYn.setHideLabel(true);
		inpmYn.setValueAttribute("Y");
		
		sub01_1.add(inpmYn, new FormData("100%"));
			
			
		LayoutContainer sub01_2 = new LayoutContainer(new ColumnLayout());
		FormLayout sub11_2 = new FormLayout();
		sub11_2.setLabelWidth(90);
		sub01_2.setLayout(sub11_2);

		c152StdTxDdcYn = new CheckBox();
		c152StdTxDdcYn.setName("c152StdTxDdcYn");
		c152StdTxDdcYn.setBoxLabel("표준세액공제적용여부");
		c152StdTxDdcYn.setReadOnly(true);
		c152StdTxDdcYn.setHideLabel(true);
		c152StdTxDdcYn.setValueAttribute("Y");

		sub01_2.add(c152StdTxDdcYn, new FormData("100%"));
			 
		sub01.add(sub01_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		sub01.add(sub01_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer sub02 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		sub02.setLayout(frmlytSch);
		
		inctxWhtxTxamtMetnCd = new ComboBox<BaseModel>();
		inctxWhtxTxamtMetnCd.setName("inctxWhtxTxamtMetnCd"); 
		inctxWhtxTxamtMetnCd.setFieldLabel("소득세비율"); 
		inctxWhtxTxamtMetnCd.setDisplayField("commCdNm");
		inctxWhtxTxamtMetnCd.setValueField("commCd");
		inctxWhtxTxamtMetnCd.setTriggerAction(TriggerAction.ALL);
		inctxWhtxTxamtMetnCd.setSelectOnFocus(true);
		inctxWhtxTxamtMetnCd.setMinChars(1); 
		inctxWhtxTxamtMetnCd.setStore(lsInctxWhtxTxamtMetnCd); 
		sub02.add(inctxWhtxTxamtMetnCd, new FormData("100%"));
		lsInctxWhtxTxamtMetnCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				inctxWhtxTxamtMetnCd.setValue(lsInctxWhtxTxamtMetnCd.getAt(1));  
			}
		});
		
		layoutContainer_241.add(sub01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_241.add(sub02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		 
		 
		fldstNewFieldset.add(layoutContainer_21, new FormData("100%"));
		fldstNewFieldset.add(layoutContainer_241, new FormData("100%"));
		//-----------------------2018년 추가 필드   ------------------------------------------------------------------
		
		layoutContainer_18.add(fldstNewFieldset, new FormData("100%"));
		layoutContainer_8.add(layoutContainer_18, new FormData("100%"));
		

		// 소득기본사항
		LayoutContainer layoutContainer_19 = new LayoutContainer();
		layoutContainer_19.setHeight("");
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("소득기본사항");

		LayoutContainer layoutContainer_38 = new LayoutContainer();
		layoutContainer_38.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_39 = new LayoutContainer();

		LayoutContainer layoutContainer_41 = new LayoutContainer();
		// layoutContainer_41.setLayout(new ColumnLayout());
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_41.setLayout(frmlytSch);
		
		
		// 종전근무지급여액
		LayoutContainer layoutContainer_42 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytSch);

		prcspPaySum = new MSFNumberField();
		prcspPaySum.setReadOnly(true);
		prcspPaySum.setFieldLabel("종전근무지급여액");
		prcspPaySum.setAllowDecimals(true);
		prcspPaySum.setPropertyEditorType(Long.class);
		prcspPaySum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_42.add(prcspPaySum, new FormData("100%"));
		
		layoutContainer_41.add(layoutContainer_42, new FormData("100%"));

		// 주현근무지급여액
		LayoutContainer layoutContainer_43 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_43.setLayout(frmlytSch);

		yeta0c29 = new MSFNumberField();
		yeta0c29.setFieldLabel("주현근무지급여액");
		yeta0c29.setAllowDecimals(true);
		yeta0c29.setPropertyEditorType(Long.class);
		yeta0c29.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_43.add(yeta0c29, new FormData("100%"));
		layoutContainer_41.add(layoutContainer_43, new FormData("100%"));

		// 총급여액
		LayoutContainer layoutContainer_44 = new LayoutContainer();
		layoutContainer_44.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_44.setLayout(frmlytSch);

		yeta0c63 = new MSFNumberField();
		yeta0c63.setFieldLabel("총 급 여 액");
		yeta0c63.setReadOnly(true);
		yeta0c63.setAllowDecimals(true);
		yeta0c63.setPropertyEditorType(Long.class);
		yeta0c63.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_44.add(yeta0c63, new FormData("100%"));
		
		layoutContainer_41.add(layoutContainer_44, new FormData("100%"));

		// 근로소득공제
		LayoutContainer layoutContainer_45 = new LayoutContainer();

		layoutContainer_45.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_45.setLayout(frmlytSch);

		yeta0c64 = new MSFNumberField();
		yeta0c64.setReadOnly(true);
		yeta0c64.setFieldLabel("근로소득공제");
		yeta0c64.setAllowDecimals(true);
		yeta0c64.setPropertyEditorType(Long.class);
		yeta0c64.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_45.add(yeta0c64, new FormData("100%"));
		
		layoutContainer_41.add(layoutContainer_45, new FormData("100%"));

		// 근로소득금액
		LayoutContainer layoutContainer_46 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_46.setLayout(frmlytSch);

		yeta0c65 = new MSFNumberField();
		yeta0c65.setReadOnly(true);
		yeta0c65.setFieldLabel("근로소득금액");
		yeta0c65.setAllowDecimals(true);
		yeta0c65.setPropertyEditorType(Long.class);
		yeta0c65.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_46.add(yeta0c65, new FormData("100%"));
		layoutContainer_41.add(layoutContainer_46, new FormData("100%"));

		// 종전근무지결정세액 소득세
		LayoutContainer layoutContainer_47 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_47.setLayout(frmlytSch);

		prcspIncmTxSum = new MSFNumberField();
		prcspIncmTxSum.setReadOnly(true);
		prcspIncmTxSum.setFieldLabel("종전근무지결정세액  소득세");
		prcspIncmTxSum.setAllowDecimals(true);
		prcspIncmTxSum.setPropertyEditorType(Long.class);
		prcspIncmTxSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_47.add(prcspIncmTxSum, new FormData("100%"));
		layoutContainer_41.add(layoutContainer_47, new FormData("100%"));

		// 주현근무지기납부세액
		LayoutContainer layoutContainer_48 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_48.setLayout(frmlytSch);

		yetaC162 = new MSFNumberField();
		yetaC162.setFieldLabel("주현근무지기납부세액 소득세");
		yetaC162.setAllowDecimals(true);
		yetaC162.setPropertyEditorType(Long.class);
		yetaC162.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_48.add(yetaC162, new FormData("100%"));
		layoutContainer_41.add(layoutContainer_48, new FormData("100%"));

		layoutContainer_39.add(layoutContainer_41, new FormData("100%"));

		LayoutContainer layoutContainer_40 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_40.setLayout(frmlytSch);

		// 종전근무지등록
		LayoutContainer layoutContainer_49 = new LayoutContainer();
		layoutContainer_40.add(layoutContainer_49, new FormData("100%"));

		Button btnNewButton = new Button("종전근무지등록");
		btnNewButton.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
					return;
				}
					
				//전체내역  
				YetaP73006 yetaP73006Form = new YetaP73006(ActionDatabase.READ, getThis());   
							    
				//2022연말정산_수정
				//MSFFormWindows msFwYeta73006 = new MSFFormWindows("종전근무지등록", yetaP73006Form, "닫기", "960px", "710px", true);
				MSFFormWindows msFwYeta73006 = new MSFFormWindows("종전근무지등록", yetaP73006Form, "닫기", "980px", "780px", true);
				msFwYeta73006.show();
				yetaP73006Form.setMSFFormWindows(msFwYeta73006);
					
				funcSetPopUpRecord();
				yetaP73006Form.bind(ppRecord); 
				
				// 팝업이 닫히면 탭을 다시 조회한다.
				msFwYeta73006.addListener(Events.Hide, new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			getItemYeta01();
		    		}
				});
				
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
//					YetaP03009 yetaP03009Form = new YetaP03009(ActionDatabase.READ, getThis());   
//										    
//					MSFFormWindows msFwYeta73009 = new MSFFormWindows("주현근무지등록", yetaP03009Form, "닫기", "820px", "710px", true);
//					msFwYeta73009.show();
//					yetaP03009Form.setMSFFormWindows(msFwYeta73009);
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
				// 전체내역
				YetaP73008 yetaP73008Form = new YetaP73008(ActionDatabase.READ, getThis());   
									    
				MSFFormWindows msFwYeta73008 = new MSFFormWindows("현비과세및감면", yetaP73008Form, "닫기", "820px", "710px", true);
				msFwYeta73008.show();
				yetaP73008Form.setMSFFormWindows(msFwYeta73008);
					
				funcSetPopUpRecord();
				 
				yetaP73008Form.bind(ppRecord); 
			}
		});			
		layoutContainer_50.add(btnNewButton1);
		
		layoutContainer_40.add(layoutContainer_50, new FormData("100%"));

		// 종합소득과세표준
		LayoutContainer layoutContainer_a53 = new LayoutContainer();
		layoutContainer_a53.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_a53.setLayout(frmlytSch);

		yetaC112 = new MSFNumberField();
		yetaC112.setReadOnly(true);
		yetaC112.setFieldLabel("종합소득과세표준");
		yetaC112.setAllowDecimals(true);
		yetaC112.setPropertyEditorType(Long.class);
		yetaC112.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_a53.add(yetaC112, new FormData("100%"));
		
		layoutContainer_40.add(layoutContainer_a53, new FormData("100%"));
		
		
		// 산출세액
		LayoutContainer layoutContainer_b53 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_b53.setLayout(frmlytSch);

		yetaC113 = new MSFNumberField();
		yetaC113.setReadOnly(true);
		yetaC113.setFieldLabel("산출세액");
		yetaC113.setAllowDecimals(true);
		yetaC113.setPropertyEditorType(Long.class);
		yetaC113.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_b53.add(yetaC113, new FormData("100%"));

		layoutContainer_40.add(layoutContainer_b53, new FormData("100%"));

		// 근로소득세액공제
		LayoutContainer layoutContainer_53 = new LayoutContainer();
		layoutContainer_53.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_53.setLayout(frmlytSch);

		yetaC120 = new MSFNumberField();
		yetaC120.setReadOnly(true);
		yetaC120.setFieldLabel("근로소득세액공제");
		yetaC120.setAllowDecimals(true);
		yetaC120.setPropertyEditorType(Long.class);
		yetaC120.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_53.add(yetaC120, new FormData("100%"));

		layoutContainer_40.add(layoutContainer_53, new FormData("100%"));

		// 지방소득세
		LayoutContainer layoutContainer_54 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_54.setLayout(frmlytSch);

		// 결정세액_주민세_지방소득세
		prcspRgonIncmTxSum = new MSFNumberField();
		prcspRgonIncmTxSum.setReadOnly(true);
		prcspRgonIncmTxSum.setFieldLabel("지방소득세");
		prcspRgonIncmTxSum.setAllowDecimals(true);
		prcspRgonIncmTxSum.setPropertyEditorType(Long.class);
		prcspRgonIncmTxSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_54.add(prcspRgonIncmTxSum, new FormData("100%"));

		layoutContainer_40.add(layoutContainer_54, new FormData("100%"));

		// 기납부세액_주민세_지방세
		LayoutContainer layoutContainer_55 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_55.setLayout(frmlytSch);

		yetaC163 = new MSFNumberField();
		yetaC163.setFieldLabel("지방소득세");
		yetaC163.setAllowDecimals(true);
		yetaC163.setPropertyEditorType(Long.class);
		yetaC163.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_55.add(yetaC163, new FormData("100%"));
		
		layoutContainer_40.add(layoutContainer_55, new FormData("100%"));

		// layoutContainer_38 add
		layoutContainer_38.add(layoutContainer_39, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_38.add(layoutContainer_40, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fldstNewFieldset_1.add(layoutContainer_38, new FormData("100%"));
		layoutContainer_19.add(fldstNewFieldset_1, new FormData("100%"));
		layoutContainer_8.add(layoutContainer_19, new FormData("100%"));

		LayoutContainer layoutContainer_20 = new LayoutContainer();
//		layoutContainer_20.setHeight("100");

		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setHeadingHtml("세액계산");

		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setStyleAttribute("paddingLeft", "5px");
		cpGrid.setStyleAttribute("paddingRight", "5px");
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(650, 100);
		    
		Yeta7300ToYe169010GridPanel = new MSFGridPanel(ye169010Def, false, false,false, false, false);
		Yeta7300ToYe169010GridPanel.setHeaderVisible(false);
		Yeta7300ToYe169010GridPanel.setBodyBorder(true);
		Yeta7300ToYe169010GridPanel.setBorders(true);
		Yeta7300ToYe169010GridPanel.getBottomComponent().setVisible(false);
		//
		cpGrid.add(Yeta7300ToYe169010GridPanel);
		    
		lcStdGrid.add(cpGrid);
		fldstNewFieldset_2.add(cpGrid);
		
		

		layoutContainer_20.add(fldstNewFieldset_2, new FormData("100%"));
		fldstNewFieldset_2.setCollapsible(false);
		layoutContainer_8.add(layoutContainer_20, new FormData("100%"));
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		
		Button button2 = new Button("기본세액공제");
		button2.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				Ye161020DTO ye161020Dto = new Ye161020DTO();
				ye161020Dto.setDpobCd(dpobCd.getValue());    																/** column 사업장코드 : dpobCd */
				ye161020Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    														/** column 귀속연도 : yrtxBlggYr */
				ye161020Dto.setClutSeptCd(clutSeptCd.getValue());    														/** column 연말정산구분코드 : clutSeptCd */
				ye161020Dto.setSystemkey(systemkey.getValue());    															/** column SYSTEMKEY : systemkey */
				
				
				yeta7300Service.getYeta7300TxDdcYnToYe161020Data(ye161020Dto, new AsyncCallback<Ye161020DTO>() {

					public void onFailure(Throwable caught) {
						MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
											, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta7300ToYe161030("+ actionDatabase.name()+ ") : " + caught)
											, null);
						}

						public void onSuccess(Ye161020DTO result) {
							
//							if (result.getC152StdTxDdcYn() == "Y" || "N".equals(result.getC152StdTxDdcYn())) {
								//전체내역  
								YetaT730171 yetaT730171Form = new YetaT730171(ActionDatabase.READ, getThis());   
										    
								MSFFormWindows msFwYetaT730171 = new MSFFormWindows("기본세액공제", yetaT730171Form, "닫기", "650px", "710px", true);
								msFwYetaT730171.show();
								yetaT730171Form.setMSFFormWindows(msFwYetaT730171);
								  
//								funcSetPopUpRecord();
								
								BaseModel bm = new BaseModel();
								
								bm.set("dpobCd"			, dpobCd.getValue());
								bm.set("clutSeptCd"		, clutSeptCd.getValue());
								bm.set("systemkey"		, systemkey.getValue());
								bm.set("yrtxBlggYr"		, yrtxBlggYr.getValue());
								bm.set("deptNm"			, deptNm.getValue());
								bm.set("hanNm"			, hanNm.getValue());
								bm.set("c152StdTxDdcYn"	, "N");
								
								setPPRecord(bm);
								
								yetaT730171Form.bind(ppRecord); 
//							}
//							else {
//								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"기본세액공제 적용자가 아닙니다.", null);
//							}
							
						}
				});	 
					
			}
		});
		btnBar.add(button2);
		layoutContainer_8.add(btnBar);
		

		Button button = new Button("표준세액공제");
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				
				Ye161020DTO ye161020Dto = new Ye161020DTO();
				
				ye161020Dto.setDpobCd(dpobCd.getValue());    																/** column 사업장코드 : dpobCd */
				ye161020Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    														/** column 귀속연도 : yrtxBlggYr */
				ye161020Dto.setClutSeptCd(clutSeptCd.getValue());    														/** column 연말정산구분코드 : clutSeptCd */
				ye161020Dto.setSystemkey(systemkey.getValue());    															/** column SYSTEMKEY : systemkey */
				
				yeta7300Service.getYeta7300TxDdcYnToYe161020Data(ye161020Dto, new AsyncCallback<Ye161020DTO>() {

					public void onFailure(Throwable caught) {
						MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
											, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta7300ToYe161030("+ actionDatabase.name()+ ") : " + caught)
											, null);
						}

						public void onSuccess(Ye161020DTO result) {
							
							if (result.getC152StdTxDdcYn() == "Y" || "Y".equals(result.getC152StdTxDdcYn())) {
								//전체내역  
								YetaT73017 yetaT73017Form = new YetaT73017(ActionDatabase.READ, getThis());   
										    
								MSFFormWindows msFwYetaT73017 = new MSFFormWindows("표준세액공제", yetaT73017Form, "닫기", "650px", "710px", true);
								msFwYetaT73017.show();
								yetaT73017Form.setMSFFormWindows(msFwYetaT73017);
								  
//								funcSetPopUpRecord();
								
								BaseModel bm = new BaseModel();
								
								bm.set("dpobCd"			, dpobCd.getValue());
								bm.set("clutSeptCd"		, clutSeptCd.getValue());
								bm.set("systemkey"		, systemkey.getValue());
								bm.set("yrtxBlggYr"		, yrtxBlggYr.getValue());
								bm.set("deptNm"			, deptNm.getValue());
								bm.set("hanNm"			, hanNm.getValue());
								bm.set("c152StdTxDdcYn"	, "Y");
								
								setPPRecord(bm);
								yetaT73017Form.bind(ppRecord); 	
								
							}else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"표준세액공제 적용자가 아닙니다.", null);
							}
							
						}
				});	
					
			}
		});
		btnBar.add(button);
		layoutContainer_8.add(btnBar);
		
		

		cp01.add(layoutContainer_8, new FormData("100%"));
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
		
		
	// 인적공제
	private LayoutContainer yetaData02() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "590");

		LayoutContainer layoutContainer_9 = new LayoutContainer();

		LayoutContainer layoutContainer_78 = new LayoutContainer();

		// 인적공제명세
		FieldSet fldstNewFieldset_3 = new FieldSet();

		LayoutContainer layoutContainer_80 = new LayoutContainer();

		ButtonBar btnYeta3220Bar = new ButtonBar();
		btnYeta3220Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		//2022연말정산_가족추가(신규)버튼 제외
		/*Button btnYeta3220New = new Button("가족추가(신규)");
		btnYeta3220New.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				
				// 가족사항을 등록하는 팝업을 호출한다.
				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
					return;
				}
		    		
	          	//가족사항등록 
				YetaP730012 payrP41003Form = new YetaP730012(ActionDatabase.INSERT, getThis());   
			    
				MSFFormWindows msFwPayr41003 = new MSFFormWindows("가족사항등록",payrP41003Form,"닫기","530px", "300px",true);
				msFwPayr41003.show();
				payrP41003Form.setMSFFormWindows(msFwPayr41003);
				payrP41003Form.bind(ppRecord);  				
				
			}
		});
		btnYeta3220Bar.add(btnYeta3220New);*/

		//2022연말정산_주석
		/*Button btnYeta3220Sel = new Button("가족선택(인사)");
		btnYeta3220Sel.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				// 가족사항을 가지고 오는 팝업을 호출한다.
				// 선택한 내용을 저장 후리스트에 보여준다.
				// 저장은 업데이트로 처리한다.
				fnPopupCommP160("Ye161030");
			}
		});
		btnYeta3220Bar.add(btnYeta3220Sel);*/

		Button btnYeta3220Del = new Button("삭제");
		btnYeta3220Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub

				boolean selfCheck = false;
				Iterator<BaseModel> itBm = Yeta7300ToYe161030GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

				List<Record> lsRec = new ArrayList<Record>();

				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				}

				Iterator<Record> iterRecords = lsRec.iterator();
				final List<Ye161030DTO> listYe161030Dto = new ArrayList<Ye161030DTO>();
					
				while (iterRecords.hasNext()) {

					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					Ye161030DTO ye161030Dto = new Ye161030DTO();
                    
					ye161030Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
					ye161030Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   			/** column SYSTEMKEY : systemkey */
                    ye161030Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
                    ye161030Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    											/** column 귀속연도 : yrtxBlggYr */
                    ye161030Dto.setClutSeptCd(clutSeptCd.getValue());    											/** column 연말정산구분코드 : clutSeptCd */
                    ye161030Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   	 		/** column SYSTEMKEY : systemkey */
                    ye161030Dto.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(bmMapModel.get("txprDscmNoCntn")));    	/** column 주민등록번호 : txprDscmNoCntn */
                    ye161030Dto.setSuptFmlyRltClCd(MSFSharedUtils.allowNulls(bmMapModel.get("suptFmlyRltClCd")));	/** column 부양관계코드 : suptFmlyRltClCd */
                    ye161030Dto.setNnfClCd(MSFSharedUtils.allowNulls(bmMapModel.get("nnfClCd")));   				/** column 내외국인구분 : nnfClCd */
                    ye161030Dto.setChild((Long) bmMapModel.get("child") );    										/** column 자녀인원수 : child */
                    ye161030Dto.setTxprNm(MSFSharedUtils.allowNulls( bmMapModel.get("txprNm")));    				/** column 성명 : txprNm */
                    ye161030Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));    	/** column 인사가족관계코드 : famyRelaDivCd */
                    
                    
					if (ye161030Dto.getFamyRelaDivCd().equals("A0190001")) {
						selfCheck = true;
					}
					
					listYe161030Dto.add(ye161030Dto);
				}

				actionDatabase = ActionDatabase.DELETE;
				// }

				// 본인여부 확인 삭제 못하도록 추가
				if (selfCheck) {MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"인적공제 본인은 삭제가 불가합니다.", null);
					return;
				}
				
				MessageBox.confirm("삭제", "선택하신 인적공제명세를 삭제하시겠습니까?</br> (삭제시 관련된  교육비, 의료비 등의 내역도 같이 삭제 처리 됩니다. )",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							yeta7300Service.activityOnYeta7300ToYe161030(listYe161030Dto ,actionDatabase, new AsyncCallback<Long>() {

								public void onFailure(Throwable caught) {
									MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
														, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta7300ToYe161030("+ actionDatabase.name()+ ") : " + caught)
														, null);
									}

									public void onSuccess(Long result) {
										MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "처리가 완료되었습니다.", null);
										reloadYe161030();
									}
							});							
							
						}
					}
				});
			}
		});
		btnYeta3220Bar.add(btnYeta3220Del);
		layoutContainer_80.add(btnYeta3220Bar);

		fldstNewFieldset_3.add(layoutContainer_80, new FormData("100%"));

		LayoutContainer layoutContainer_79 = new LayoutContainer();
		fldstNewFieldset_3.add(layoutContainer_79, new FormData("100%"));
		layoutContainer_79.add(occupationalRBottom2(),new com.extjs.gxt.ui.client.widget.layout.RowData());

		LayoutContainer layoutContainer_81 = new LayoutContainer();

		LabelField lblfldNewLabelfield_16 = new LabelField("* 장애인표기 - 1 : 장애인복지법  2 : 국가유공자등 예우 및 지원관련법률  3 : 중증환자");
		layoutContainer_81.add(lblfldNewLabelfield_16);

		LabelField lblfldNewLabelfield_17 = new LabelField("* 내국인 : 1 , 외국인 : 9 로 표기");
		layoutContainer_81.add(lblfldNewLabelfield_17);

		fldstNewFieldset_3.add(layoutContainer_81, new FormData("100%"));

		layoutContainer_78.add(fldstNewFieldset_3);
		fldstNewFieldset_3.setHeadingHtml("인적공제명세");
		layoutContainer_9.add(layoutContainer_78, new FormData("100%"));

		LayoutContainer layoutContainer_77 = new LayoutContainer();
		layoutContainer_77.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_82 = new LayoutContainer();
		layoutContainer_82.setLayout(new ColumnLayout());

		// 자녀수
		LayoutContainer layoutContainer_83 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(45);
		frmlytSch.setLabelAlign(LabelAlign.LEFT);
		layoutContainer_83.setLayout(frmlytSch);

		addrMrct = new MSFNumberField();
		addrMrct.setReadOnly(true);
		addrMrct.setFieldLabel("공제대상자녀수");
		addrMrct.setAllowDecimals(true);
		addrMrct.setPropertyEditorType(Long.class); 
		addrMrct.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_83.add(addrMrct, new FormData("100%"));
		layoutContainer_82.add(layoutContainer_83,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		// 세액공제
		LayoutContainer layoutContainer_87 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(65);
		frmlytSch.setLabelAlign(LabelAlign.LEFT);
		layoutContainer_87.setLayout(frmlytSch);

		addrMccr = new MSFNumberField();
		addrMccr.setReadOnly(true);
		addrMccr.setFieldLabel("세액공제");
		addrMccr.setAllowDecimals(true);
		addrMccr.setPropertyEditorType(Long.class);
		addrMccr.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_87.add(addrMccr, new FormData("100%"));

		layoutContainer_82.add(layoutContainer_87,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));

		layoutContainer_77.add(layoutContainer_82,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		LayoutContainer layoutContainer_84 = new LayoutContainer();
		layoutContainer_77.add(layoutContainer_84,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		layoutContainer_84.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_85 = new LayoutContainer();

		LabelField lblfldNewLabelfield_18 = new LabelField("인적공제항목변동여부  :");
		lblfldNewLabelfield_18.setStyleAttribute("textAlign", "RIGHT");
		layoutContainer_85.add(lblfldNewLabelfield_18);
		layoutContainer_84.add(layoutContainer_85,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		LayoutContainer layoutContainer_86 = new LayoutContainer();
		layoutContainer_84.add(layoutContainer_86, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_86.setLayout(new ColumnLayout());

		prifChngYn = new RadioGroup();

		prifChngYn0 = new Radio();
		prifChngYn.add(prifChngYn0);
		prifChngYn0.setBoxLabel("전년과동일");
		prifChngYn0.setHideLabel(true);
		prifChngYn0.setValueAttribute("0");

		prifChngYn1 = new Radio();
		prifChngYn.add(prifChngYn1);
		prifChngYn1.setBoxLabel("변동");
		prifChngYn1.setHideLabel(true);
		prifChngYn1.setValueAttribute("1");

		layoutContainer_86.add(prifChngYn);

		layoutContainer_84.add(layoutContainer_86,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

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
		cp01.setSize("660", "590");

		LayoutContainer layoutContainer_10 = new LayoutContainer();

		LayoutContainer layoutContainer_89 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(65);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_89.setLayout(frmlytSch);
		
		
		// 소득공제명세
		FieldSet fldstNewFieldset_4 = new FieldSet();
		fldstNewFieldset_4.setHeadingHtml("소득공제명세");

		LayoutContainer layoutContainer_90 = new LayoutContainer();
		layoutContainer_90.add(occupationalRBottom3_01(), new FormData("100%"));
		layoutContainer_90.add(occupationalRBottom3_02(), new FormData("100%"));

		fldstNewFieldset_4.add(layoutContainer_90, new FormData("100%"));
		layoutContainer_89.add(fldstNewFieldset_4);
		layoutContainer_10.add(layoutContainer_89, new FormData("100%"));

		LayoutContainer layoutContainer_88 = new LayoutContainer();
		LabelField lblfldNewLabelfield_19 = new LabelField("* 신용카드, 직불카드, 현금영수증은 도서공연/전통시장/대중교통비를 제외한 금액을 적습니다.");
		layoutContainer_88.add(lblfldNewLabelfield_19);
		layoutContainer_10.add(layoutContainer_88, new FormData("100%"));

		cp01.add(layoutContainer_10);
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
		
		
	private LayoutContainer yetaData04() {
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "590");

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

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_96.setLayout(frmlytSch);

		npHthrWaInfeeAmt = new MSFNumberField();
		npHthrWaInfeeAmt.setFieldLabel("종전근무지금액");
		npHthrWaInfeeAmt.setReadOnly(true);
		npHthrWaInfeeAmt.setAllowDecimals(true); 
		npHthrWaInfeeAmt.setPropertyEditorType(Long.class); 
		npHthrWaInfeeAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_96.add(npHthrWaInfeeAmt, new FormData("95%"));
		layoutContainer_94.add(layoutContainer_96);
		
		  
		// 주현근무지금액
		LayoutContainer layoutContainer_97 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_97.setLayout(frmlytSch);

		npHthrMcurWkarInfeeAmt = new MSFNumberField();
		npHthrMcurWkarInfeeAmt.setFieldLabel("주현근무지금액");
		npHthrMcurWkarInfeeAmt.setReadOnly(false);
		npHthrMcurWkarInfeeAmt.setAllowDecimals(true); 
		npHthrMcurWkarInfeeAmt.setPropertyEditorType(Long.class); 
		npHthrMcurWkarInfeeAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_97.add(npHthrMcurWkarInfeeAmt, new FormData("95%"));
		
		layoutContainer_94.add(layoutContainer_97);
		
		// 국민연금보험료_지역보험료금액
		LayoutContainer layoutContainer_979 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_979.setLayout(frmlytSch);

		npHthrAreaInfeeAmt = new MSFNumberField();
		npHthrAreaInfeeAmt.setFieldLabel("지역보험료금액");
		npHthrAreaInfeeAmt.setReadOnly(false);
		npHthrAreaInfeeAmt.setAllowDecimals(true); 
		npHthrAreaInfeeAmt.setPropertyEditorType(Long.class); 
		npHthrAreaInfeeAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_979.add(npHthrAreaInfeeAmt, new FormData("95%"));
		
		layoutContainer_94.add(layoutContainer_979);
		fldstNewFieldset_6.add(layoutContainer_94, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		
		LayoutContainer layoutContainer_95 = new LayoutContainer();

		// 종전근무지공제액
		LayoutContainer layoutContainer_98 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_98.setLayout(frmlytSch);

		npHthrWaInfeeDdcAmt = new MSFNumberField();
		npHthrWaInfeeDdcAmt.setFieldLabel("종전근무지공제액");
		npHthrWaInfeeDdcAmt.setReadOnly(true);
		npHthrWaInfeeDdcAmt.setAllowDecimals(true); 
		npHthrWaInfeeDdcAmt.setPropertyEditorType(Long.class); 
		npHthrWaInfeeDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_98.add(npHthrWaInfeeDdcAmt, new FormData("95%"));
		layoutContainer_95.add(layoutContainer_98);
		
		
		// 종전근무지공제액
		LayoutContainer layoutContainer_981 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_981.setLayout(frmlytSch);

		npHthrMcurWkarDdcAmt = new MSFNumberField();
		npHthrMcurWkarDdcAmt.setFieldLabel("주현근무지공제액");
		npHthrMcurWkarDdcAmt.setReadOnly(true);
		npHthrMcurWkarDdcAmt.setAllowDecimals(true); 
		npHthrMcurWkarDdcAmt.setPropertyEditorType(Long.class); 
		npHthrMcurWkarDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_981.add(npHthrMcurWkarDdcAmt, new FormData("95%"));
		layoutContainer_95.add(layoutContainer_981);		
		

		// 국민연금보험료-지역보험료공제액
		LayoutContainer layoutContainer_999 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_999.setLayout(frmlytSch);

		npHthrAreaDdcAmt = new MSFNumberField();
		npHthrAreaDdcAmt.setFieldLabel("지역보험료공제액");
		npHthrAreaDdcAmt.setReadOnly(true);
		npHthrAreaDdcAmt.setAllowDecimals(true); 
		npHthrAreaDdcAmt.setPropertyEditorType(Long.class); 
		npHthrAreaDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_999.add(npHthrAreaDdcAmt, new FormData("95%"));
		layoutContainer_95.add(layoutContainer_999);
		  
		fldstNewFieldset_6.add(layoutContainer_95, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
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

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_110.setLayout(frmlytSch);

		puoferAnty_02 = new MSFNumberField();
		puoferAnty_02.setFieldLabel("공무원연금");
		puoferAnty_02.setReadOnly(true);
		puoferAnty_02.setAllowDecimals(true); 
		puoferAnty_02.setPropertyEditorType(Long.class); 
		puoferAnty_02.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_110.add(puoferAnty_02, new FormData("100%"));
		
		layoutContainer_102.add(layoutContainer_110, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  

		LayoutContainer layoutContainer_111 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_111.setLayout(frmlytSch);

		puoferAnty_01 = new MSFNumberField();
		puoferAnty_01.setLabelSeparator("");
		puoferAnty_01.setAllowDecimals(true); 
		puoferAnty_01.setPropertyEditorType(Long.class); 
		puoferAnty_01.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_111.add(puoferAnty_01, new FormData("100%"));
		
		layoutContainer_102.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_100.add(layoutContainer_102);
		  
		LayoutContainer layoutContainer_103 = new LayoutContainer();
		layoutContainer_103.setLayout(new ColumnLayout());

		// 군인연금
		LayoutContainer layoutContainer_114 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_114.setLayout(frmlytSch);

		mltymAnty_02 = new MSFNumberField();
		mltymAnty_02.setAllowDecimals(true); 
		mltymAnty_02.setPropertyEditorType(Long.class); 
		mltymAnty_02.setFormat(NumberFormat.getDecimalFormat());
		mltymAnty_02.setFieldLabel("군인연금");
		mltymAnty_02.setReadOnly(true);
		
		layoutContainer_114.add(mltymAnty_02, new FormData("100%"));
		
		layoutContainer_103.add(layoutContainer_114, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		
		LayoutContainer layoutContainer_115 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_115.setLayout(frmlytSch);

		mltymAnty_01 = new MSFNumberField();
		mltymAnty_01.setAllowDecimals(true); 
		mltymAnty_01.setPropertyEditorType(Long.class); 
		mltymAnty_01.setFormat(NumberFormat.getDecimalFormat());
		mltymAnty_01.setLabelSeparator("");
		
		layoutContainer_115.add(mltymAnty_01, new FormData("100%"));
		layoutContainer_103.add(layoutContainer_115, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_100.add(layoutContainer_103);

		LayoutContainer layoutContainer_104 = new LayoutContainer();
		layoutContainer_104.setLayout(new ColumnLayout());

		// 교직원연금
		LayoutContainer layoutContainer_118 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_118.setLayout(frmlytSch);

		//근무지_국민연금외교직원연금
		prtafirSchlFalymmAnty_02 = new MSFNumberField();
		prtafirSchlFalymmAnty_02.setAllowDecimals(true); 
		prtafirSchlFalymmAnty_02.setPropertyEditorType(Long.class); 
		prtafirSchlFalymmAnty_02.setFormat(NumberFormat.getDecimalFormat());
		prtafirSchlFalymmAnty_02.setFieldLabel("교직원연금");
		prtafirSchlFalymmAnty_02.setReadOnly(true);
		layoutContainer_118.add(prtafirSchlFalymmAnty_02, new FormData("100%"));
		
		layoutContainer_104.add(layoutContainer_118, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_119 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_119.setLayout(frmlytSch);

		prtafirSchlFalymmAnty_01 = new MSFNumberField();
		prtafirSchlFalymmAnty_01.setLabelSeparator("");
		prtafirSchlFalymmAnty_01.setAllowDecimals(true); 
		prtafirSchlFalymmAnty_01.setPropertyEditorType(Long.class); 
		prtafirSchlFalymmAnty_01.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_119.add(prtafirSchlFalymmAnty_01, new FormData("100%"));
		
		layoutContainer_104.add(layoutContainer_119, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_100.add(layoutContainer_104);

		LayoutContainer layoutContainer_105 = new LayoutContainer();
		layoutContainer_105.setLayout(new ColumnLayout());

		
		
		// 별정우체국
		LayoutContainer layoutContainer_122 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_122.setLayout(frmlytSch);

		spildtnPstoficAnty_02 = new MSFNumberField();
		spildtnPstoficAnty_02.setAllowDecimals(true); 
		spildtnPstoficAnty_02.setPropertyEditorType(Long.class); 
		spildtnPstoficAnty_02.setFormat(NumberFormat.getDecimalFormat());
		spildtnPstoficAnty_02.setFieldLabel("별정우체국");
		spildtnPstoficAnty_02.setReadOnly(true);
		
		layoutContainer_122.add(spildtnPstoficAnty_02, new FormData("100%"));
		layoutContainer_105.add(layoutContainer_122, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		
		LayoutContainer layoutContainer_123 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_123.setLayout(frmlytSch);

		spildtnPstoficAnty_01 = new MSFNumberField();
		spildtnPstoficAnty_01.setLabelSeparator("");
		spildtnPstoficAnty_01.setAllowDecimals(true); 
		spildtnPstoficAnty_01.setPropertyEditorType(Long.class); 
		spildtnPstoficAnty_01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_123.add(spildtnPstoficAnty_01, new FormData("100%"));
		
		layoutContainer_105.add(layoutContainer_123, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		layoutContainer_100.add(layoutContainer_105);

		fldstNewFieldset_7.add(layoutContainer_100, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_101 = new LayoutContainer();

		LayoutContainer layoutContainer_106 = new LayoutContainer();
		layoutContainer_106.setLayout(new ColumnLayout());

		
		// 종근무지_국민연금외공무원연금공제
		LayoutContainer layoutContainer_112 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_112.setLayout(frmlytSch);

		puoferAntyDducSum_02 = new MSFNumberField();
		puoferAntyDducSum_02.setReadOnly(true);
		puoferAntyDducSum_02.setAllowDecimals(true); 
		puoferAntyDducSum_02.setPropertyEditorType(Long.class); 
		puoferAntyDducSum_02.setFormat(NumberFormat.getDecimalFormat());
		puoferAntyDducSum_02.setFieldLabel("공제액");
		layoutContainer_112.add(puoferAntyDducSum_02, new FormData("100%"));
		
		layoutContainer_106.add(layoutContainer_112, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		// 주근무지_공무원연금보험료공제
		LayoutContainer layoutContainer_113 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_113.setLayout(frmlytSch);

		puoferAntyDducSum_01 = new MSFNumberField();
		puoferAntyDducSum_01.setReadOnly(true);
		puoferAntyDducSum_01.setLabelSeparator("");
		puoferAntyDducSum_01.setAllowDecimals(true); 
		puoferAntyDducSum_01.setPropertyEditorType(Long.class); 
		puoferAntyDducSum_01.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_113.add(puoferAntyDducSum_01, new FormData("100%"));
		
		layoutContainer_106.add(layoutContainer_113, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_101.add(layoutContainer_106);

		LayoutContainer layoutContainer_107 = new LayoutContainer();
		layoutContainer_107.setLayout(new ColumnLayout());

		// 종근무지_국민연금외군인연금공제
		LayoutContainer layoutContainer_116 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_116.setLayout(frmlytSch);

		mltymAntyDducSum_02 = new MSFNumberField();
		mltymAntyDducSum_02.setReadOnly(true);
		mltymAntyDducSum_02.setAllowDecimals(true); 
		mltymAntyDducSum_02.setPropertyEditorType(Long.class); 
		mltymAntyDducSum_02.setFormat(NumberFormat.getDecimalFormat());
		mltymAntyDducSum_02.setFieldLabel("공제액");
		layoutContainer_116.add(mltymAntyDducSum_02, new FormData("100%"));
		layoutContainer_107.add(layoutContainer_116, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  
		// 주근무지_국민연금외군인연금공제
		LayoutContainer layoutContainer_117 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_117.setLayout(frmlytSch);

		mltymAntyDducSum_01 = new MSFNumberField();
		mltymAntyDducSum_01.setReadOnly(true);
		mltymAntyDducSum_01.setAllowDecimals(true); 
		mltymAntyDducSum_01.setPropertyEditorType(Long.class); 
		mltymAntyDducSum_01.setFormat(NumberFormat.getDecimalFormat());
		mltymAntyDducSum_01.setLabelSeparator("");
		layoutContainer_117.add(mltymAntyDducSum_01, new FormData("100%"));
		layoutContainer_107.add(layoutContainer_117, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_101.add(layoutContainer_107);

		LayoutContainer layoutContainer_108 = new LayoutContainer();
		layoutContainer_108.setLayout(new ColumnLayout());

		// 종근무지_국민연금외교직원연금공제
		LayoutContainer layoutContainer_120 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_120.setLayout(frmlytSch);

		prtafirSchlDducSum_02 = new MSFNumberField();
		prtafirSchlDducSum_02.setReadOnly(true);
		prtafirSchlDducSum_02.setAllowDecimals(true); 
		prtafirSchlDducSum_02.setPropertyEditorType(Long.class); 
		prtafirSchlDducSum_02.setFormat(NumberFormat.getDecimalFormat());
		prtafirSchlDducSum_02.setFieldLabel("공제액");
		
		layoutContainer_120.add(prtafirSchlDducSum_02, new FormData("100%"));
		layoutContainer_108.add(layoutContainer_120, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  
		// 주근무지_국민연금외교직원연금공제
		LayoutContainer layoutContainer_121 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_121.setLayout(frmlytSch);

		prtafirSchlDducSum_01 = new MSFNumberField();
		prtafirSchlDducSum_01.setReadOnly(true);
		prtafirSchlDducSum_01.setLabelSeparator("");
		prtafirSchlDducSum_01.setAllowDecimals(true); 
		prtafirSchlDducSum_01.setPropertyEditorType(Long.class); 
		prtafirSchlDducSum_01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_121.add(prtafirSchlDducSum_01, new FormData("100%"));
		
		layoutContainer_108.add(layoutContainer_121, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_101.add(layoutContainer_108);
		  
		LayoutContainer layoutContainer_109 = new LayoutContainer();
		layoutContainer_109.setLayout(new ColumnLayout());

		// 종근무지_별정우체국연금보험료공제
		LayoutContainer layoutContainer_124 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_124.setLayout(frmlytSch);

		spildtnPstoficDducSum_02 = new MSFNumberField();
		spildtnPstoficDducSum_02.setReadOnly(true);
		spildtnPstoficDducSum_02.setAllowDecimals(true); 
		spildtnPstoficDducSum_02.setPropertyEditorType(Long.class); 
		spildtnPstoficDducSum_02.setFormat(NumberFormat.getDecimalFormat());
		spildtnPstoficDducSum_02.setFieldLabel("공제액");
		layoutContainer_124.add(spildtnPstoficDducSum_02, new FormData("100%"));
		
		layoutContainer_109.add(layoutContainer_124, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  
		  
		// 주근무지_별정우체국연금보험료공제
		LayoutContainer layoutContainer_125 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_125.setLayout(frmlytSch);

		spildtnPstoficDducSum_01 = new MSFNumberField();
		spildtnPstoficDducSum_01.setReadOnly(true);
		spildtnPstoficDducSum_01.setAllowDecimals(true); 
		spildtnPstoficDducSum_01.setPropertyEditorType(Long.class); 
		spildtnPstoficDducSum_01.setFormat(NumberFormat.getDecimalFormat());
		spildtnPstoficDducSum_01.setLabelSeparator("");
		
		layoutContainer_125.add(spildtnPstoficDducSum_01, new FormData("100%"));
		layoutContainer_109.add(layoutContainer_125, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_101.add(layoutContainer_109);
		  
		fldstNewFieldset_7.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

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

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(110);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_129.setLayout(frmlytSch);

		pnsnInfeeUseAmtSum = new MSFNumberField();
		pnsnInfeeUseAmtSum.setReadOnly(true);
		pnsnInfeeUseAmtSum.setFieldLabel("연금보험료금액계");
		pnsnInfeeUseAmtSum.setAllowDecimals(true); 
		pnsnInfeeUseAmtSum.setPropertyEditorType(Long.class); 
		pnsnInfeeUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_129.add(pnsnInfeeUseAmtSum, new FormData("100%"));

		layoutContainer_127.add(layoutContainer_129, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  
		
		//연금보험료공제계
		LayoutContainer layoutContainer_130 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(110);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_130.setLayout(frmlytSch);

		pnsnInfeeDdcAmtSum = new MSFNumberField();
		pnsnInfeeDdcAmtSum.setReadOnly(true);
		pnsnInfeeDdcAmtSum.setFieldLabel("연금보험료공제계");
		pnsnInfeeDdcAmtSum.setAllowDecimals(true); 
		pnsnInfeeDdcAmtSum.setPropertyEditorType(Long.class); 
		pnsnInfeeDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_130.add(pnsnInfeeDdcAmtSum, new FormData("100%"));
		
		layoutContainer_127.add(layoutContainer_130, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_93.add(layoutContainer_127);

		LayoutContainer layoutContainer_128 = new LayoutContainer();

		ButtonBar buttonBar_2 = new ButtonBar();
		buttonBar_2.setAlignment(HorizontalAlignment.RIGHT);
		  
		Button btnNewButton_9 = new Button("연금/저축등소득공제");
		btnNewButton_9.setIconAlign(IconAlign.RIGHT);
		btnNewButton_9.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 전체내역
				YetaP73007 yetaP73007Form = new YetaP73007(ActionDatabase.READ, getThis());

				MSFFormWindows msFwYeta73007 = new MSFFormWindows("연금저축소득공제",yetaP73007Form, "닫기", "820px", "550px", true);
				msFwYeta73007.show();
				yetaP73007Form.setMSFFormWindows(msFwYeta73007);
				
				msFwYeta73007.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			getItemYeta04();
		    		}
				});
				
				// TODO 추후 주석해제
				yetaP73007Form.bind(ppRecord);
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
		// cp01.setScrollMode(Scroll.AUTOY);
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "590");
		  
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setHeight("570");
		
		tabsItemYeta05 = new TabPanel();
		tabsItemYeta05.setHeight("570");
		tabsItemYeta05.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				Yeta7300ToYe161010Detail(Yeta7300ToYe161010GridPanel.getCurrentlySelectedItem(), tabsItemYeta05.getSelectedItem().getId());
			}
		});
		  
		//보험료tab
		TabItem itemYeta05_1 = new TabItem("보험료");
		itemYeta05_1.setId("itemYeta05_1");
		itemYeta05_1.setBorders(false);
		  
		ContentPanel cp02 = new ContentPanel();
		cp02.setSize(650, 570);
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
		  
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_287.setLayout(frmlytSch);
		  
		hthrHifeAmt = new MSFNumberField();
		hthrHifeAmt.setReadOnly(true);
		hthrHifeAmt.setFieldLabel("종전근무지금액");
		hthrHifeAmt.setAllowDecimals(true); 
		hthrHifeAmt.setPropertyEditorType(Long.class); 
		hthrHifeAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_287.add(hthrHifeAmt, new FormData("100%"));
		layoutContainer_285.add(layoutContainer_287);
		  
		
		//특별공제_주건강보험료
		LayoutContainer layoutContainer_288 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_288.setLayout(frmlytSch);
		  
		mcurHifeAmt = new MSFNumberField();
		mcurHifeAmt.setFieldLabel("주현근무지금액");
		mcurHifeAmt.setAllowDecimals(true); 
		mcurHifeAmt.setPropertyEditorType(Long.class); 
		mcurHifeAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_288.add(mcurHifeAmt, new FormData("100%"));
		layoutContainer_285.add(layoutContainer_288);
		
		
		// 국민건강보험_지역보험료금액
		LayoutContainer layoutContainer_218 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_218.setLayout(frmlytSch);
		  
		mcurHifeAreaAmt = new MSFNumberField();
		mcurHifeAreaAmt.setFieldLabel("지역보험료금액");
		mcurHifeAreaAmt.setAllowDecimals(true); 
		mcurHifeAreaAmt.setPropertyEditorType(Long.class); 
		mcurHifeAreaAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_218.add(mcurHifeAreaAmt, new FormData("100%"));
		layoutContainer_285.add(layoutContainer_218);
		  
		  
		layoutContainer_284.add(layoutContainer_285, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_286 = new LayoutContainer();
		  
		
		//특별공제_종건강보험료
		LayoutContainer layoutContainer_289 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_289.setLayout(frmlytSch);
		  
		hthrHifeDdcAmt = new MSFNumberField();
		hthrHifeDdcAmt.setReadOnly(true);
		hthrHifeDdcAmt.setFieldLabel("종전근무지공제액");
		hthrHifeDdcAmt.setAllowDecimals(true); 
		hthrHifeDdcAmt.setPropertyEditorType(Long.class); 
		hthrHifeDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_289.add(hthrHifeDdcAmt, new FormData("100%"));
		
		layoutContainer_286.add(layoutContainer_289);

		
		//특별공제_주건강보험료
		LayoutContainer layoutContainer_290 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_290.setLayout(frmlytSch);
	 
		mcurHifeDdcAmt = new MSFNumberField();
		mcurHifeDdcAmt.setReadOnly(true);
		mcurHifeDdcAmt.setFieldLabel("주현근무지공제액");		
		mcurHifeDdcAmt.setAllowDecimals(true); 
		mcurHifeDdcAmt.setPropertyEditorType(Long.class); 
		mcurHifeDdcAmt.setFormat(NumberFormat.getDecimalFormat());

		
		layoutContainer_290.add(mcurHifeDdcAmt, new FormData("100%"));
		layoutContainer_286.add(layoutContainer_290);
		
		
		
		//국민건강보험_지역보험료공제금액
		LayoutContainer layoutContainer_190 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_190.setLayout(frmlytSch);
	 
		mcurHifeAreaDdcAmt = new MSFNumberField();
		mcurHifeAreaDdcAmt.setReadOnly(true);
		mcurHifeAreaDdcAmt.setFieldLabel("지역보험료공제액");		
		mcurHifeAreaDdcAmt.setAllowDecimals(true); 
		mcurHifeAreaDdcAmt.setPropertyEditorType(Long.class); 
		mcurHifeAreaDdcAmt.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_190.add(mcurHifeAreaDdcAmt, new FormData("100%"));
		layoutContainer_286.add(layoutContainer_190);		
		
		  
		layoutContainer_284.add(layoutContainer_286, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  
		  
//		fldstNewFieldset_18.add(layoutContainer_284);
		fldstNewFieldset_188.add(layoutContainer_284);
		fldstNewFieldset_18.add(fldstNewFieldset_188);
		
		layoutContainer_282.add(fldstNewFieldset_18);
		layoutContainer_281.add(layoutContainer_282);

		
		LayoutContainer layoutContainer_283 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_19 = new FieldSet();
		fldstNewFieldset_19.setHeadingHtml("고용보험");
		 
		LayoutContainer layoutContainer_291 = new LayoutContainer();
		layoutContainer_291.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_292 = new LayoutContainer();
		  
		//특별공제_종고용보험료
		LayoutContainer layoutContainer_294 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_294.setLayout(frmlytSch);
		  
		hthrUiAmt = new MSFNumberField();
		hthrUiAmt.setReadOnly(true);
		hthrUiAmt.setFieldLabel("종전근무지금액");
		hthrUiAmt.setAllowDecimals(true); 
		hthrUiAmt.setPropertyEditorType(Long.class); 
		hthrUiAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_294.add(hthrUiAmt, new FormData("100%"));
		
		layoutContainer_292.add(layoutContainer_294);

		
		//특별공제_주고용보험료
		LayoutContainer layoutContainer_295 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_295.setLayout(frmlytSch);
		  
		mcurUiAmt = new MSFNumberField();
		mcurUiAmt.setFieldLabel("주현근무지금액");
		mcurUiAmt.setAllowDecimals(true); 
		mcurUiAmt.setPropertyEditorType(Long.class); 
		mcurUiAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_295.add(mcurUiAmt, new FormData("100%"));
		layoutContainer_292.add(layoutContainer_295);
		  
		layoutContainer_291.add(layoutContainer_292, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  
		LayoutContainer layoutContainer_293 = new LayoutContainer();
		 
		
		//특별공제_종고용보험료공제액
		LayoutContainer layoutContainer_297 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_297.setLayout(frmlytSch);
		  
		hthrUiDdcAmt = new MSFNumberField();
		hthrUiDdcAmt.setReadOnly(true);
		hthrUiDdcAmt.setFieldLabel("종현근무지공제액");
		hthrUiDdcAmt.setAllowDecimals(true); 
		hthrUiDdcAmt.setPropertyEditorType(Long.class); 
		hthrUiDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_297.add(hthrUiDdcAmt, new FormData("100%"));
		
		layoutContainer_293.add(layoutContainer_297);
		  
		
		//특별공제_주고용보험료공제액
		LayoutContainer layoutContainer_298 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_298.setLayout(frmlytSch);
		  
		mcurUiDdcAmt = new MSFNumberField();
		mcurUiDdcAmt.setReadOnly(true);
		mcurUiDdcAmt.setFieldLabel("주현근무지공제액");
		mcurUiDdcAmt.setAllowDecimals(true); 
		mcurUiDdcAmt.setPropertyEditorType(Long.class); 
		mcurUiDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_298.add(mcurUiDdcAmt, new FormData("100%"));
		
		layoutContainer_293.add(layoutContainer_298);
		  
		layoutContainer_291.add(layoutContainer_293, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  
		
		fldstNewFieldset_19.add(layoutContainer_291);
		fldstNewFieldset_18.add(fldstNewFieldset_19);
		
		
		layoutContainer_283.add(fldstNewFieldset_19);
		layoutContainer_281.add(layoutContainer_283);
		
		LayoutContainer lcNum = new LayoutContainer(new ColumnLayout());
		
		//보혐료금액계
		LayoutContainer layoutContainer_296 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_296.setLayout(frmlytSch);
		
		infeeUseAmtSum = new MSFNumberField();
		infeeUseAmtSum.setReadOnly(true);
		infeeUseAmtSum.setFieldLabel("보혐료금액계");
		infeeUseAmtSum.setAllowDecimals(true); 
		infeeUseAmtSum.setPropertyEditorType(Long.class); 
		infeeUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_296.add(infeeUseAmtSum, new FormData("100%"));
		
		lcNum.add(layoutContainer_296, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		//보혐료공제액
		LayoutContainer layoutContainer_299 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(110); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_299.setLayout(frmlytSch);
		
		infeeDdcAmtSum = new MSFNumberField();
		infeeDdcAmtSum.setReadOnly(true);
		infeeDdcAmtSum.setFieldLabel("보혐료공제액");	
		infeeDdcAmtSum.setAllowDecimals(true); 
		infeeDdcAmtSum.setPropertyEditorType(Long.class); 
		infeeDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_299.add(infeeDdcAmtSum, new FormData("100%"));
		
		lcNum.add(layoutContainer_299, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_283.add(lcNum);
		
		fldstNewFieldset_18.add(layoutContainer_283);
		
		  
		cp02.add(layoutContainer_281);
		itemYeta05_1.add(cp02);
		
		tabsItemYeta05.add(itemYeta05_1);
		  
		
		//주택자금tab
		TabItem itemYeta05_2 = new TabItem("주택자금");
		itemYeta05_2.setId("itemYeta05_2");
		  
		ContentPanel cntntpnlNewContentpanel_2 = new ContentPanel();
		cntntpnlNewContentpanel_2.setSize(650, 570);
		cntntpnlNewContentpanel_2.setScrollMode(Scroll.AUTOY);
		cntntpnlNewContentpanel_2.setHeaderVisible(false);
		cntntpnlNewContentpanel_2.setHeadingHtml("");
		  
		LayoutContainer layoutContainer_300 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_20 = new FieldSet();
		fldstNewFieldset_20.setHeadingHtml("주택자금공제");
		  
//		LayoutContainer layoutContainer_301 = new LayoutContainer();
		  
		FieldSet fldstNewFieldset_21 = new FieldSet();
		fldstNewFieldset_21.setHeadingHtml("주택임차금");
		  
		LayoutContainer layoutContainer_448 = new LayoutContainer();
		layoutContainer_448.setLayout(new ColumnLayout());
		  
		
		LayoutContainer layoutContainer_449 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		layoutContainer_449.setLayout(frmlytSch);
		  
		Button btnNewButton_15 = new Button("임차등록");
		btnNewButton_15.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP73004 yetaP73004Form = new YetaP73004(ActionDatabase.READ, getThis());   
					    
				MSFFormWindows msFwYeta73004 = new MSFFormWindows("거주자간 주택임차차입금 원리금 상환액", yetaP73004Form, "닫기", "820px", "600px", true);
				msFwYeta73004.show();
				yetaP73004Form.setMSFFormWindows(msFwYeta73004);
				 
				funcSetPopUpRecord();
				//TODO 추후 주석해제 
				yetaP73004Form.bind(ppRecord); 
			}
		});	
		layoutContainer_449.add(btnNewButton_15, new FormData("100%"));
		layoutContainer_448.add(layoutContainer_449, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		  
		
		LayoutContainer layoutContainer_450 = new LayoutContainer();
		  
		//대출기관차입
		LayoutContainer layoutContainer_452 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_452.setLayout(frmlytSch);
		  
		brwLnpbSrmAmt = new MSFNumberField();
		brwLnpbSrmAmt.setFieldLabel("대출기관차입");	
		brwLnpbSrmAmt.setAllowDecimals(true); 
		brwLnpbSrmAmt.setPropertyEditorType(Long.class); 
		brwLnpbSrmAmt.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_452.add(brwLnpbSrmAmt, new FormData("100%"));
		layoutContainer_450.add(layoutContainer_452, new FormData("100%"));
		  
		
		//거주자차입
		LayoutContainer layoutContainer_453 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_453.setLayout(frmlytSch);
		  
		rsdtLnpbSrmAmt = new MSFNumberField();
		rsdtLnpbSrmAmt.setReadOnly(true);
		rsdtLnpbSrmAmt.setFieldLabel("거주자차입");	
		rsdtLnpbSrmAmt.setAllowDecimals(true); 
		rsdtLnpbSrmAmt.setPropertyEditorType(Long.class); 
		rsdtLnpbSrmAmt.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_453.add(rsdtLnpbSrmAmt, new FormData("100%"));
		
		layoutContainer_450.add(layoutContainer_453, new FormData("100%"));
		layoutContainer_448.add(layoutContainer_450, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		  
		LayoutContainer layoutContainer_451 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_451.setLayout(frmlytSch);
		
		
		//특별공제_차입금원리금상환액_대출기관 공제액
		LayoutContainer layoutContainer_454 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(50); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_454.setLayout(frmlytSch);
		  
		brwLnpbSrmDdcAmt = new MSFNumberField();
		brwLnpbSrmDdcAmt.setReadOnly(true);
		brwLnpbSrmDdcAmt.setAllowDecimals(true); 
		brwLnpbSrmDdcAmt.setPropertyEditorType(Long.class); 
		brwLnpbSrmDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		brwLnpbSrmDdcAmt.setFieldLabel("공제액");
		
		layoutContainer_454.add(brwLnpbSrmDdcAmt, new FormData("100%"));
		layoutContainer_451.add(layoutContainer_454, new FormData("100%"));

		
		//특별공제_차입금원리금상환액_거주자 공제액
		LayoutContainer layoutContainer_455 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(50); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_455.setLayout(frmlytSch);
		  
		rsdtLnpbSrmDdcAmt = new MSFNumberField();
		rsdtLnpbSrmDdcAmt.setReadOnly(true);
		rsdtLnpbSrmDdcAmt.setAllowDecimals(true); 
		rsdtLnpbSrmDdcAmt.setPropertyEditorType(Long.class); 
		rsdtLnpbSrmDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		rsdtLnpbSrmDdcAmt.setFieldLabel("공제액");
		
		layoutContainer_455.add(rsdtLnpbSrmDdcAmt, new FormData("100%"));
		layoutContainer_451.add(layoutContainer_455, new FormData("100%"));
		  
		layoutContainer_448.add(layoutContainer_451, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		  
		  
		fldstNewFieldset_21.add(layoutContainer_448, new FormData("100%"));
		fldstNewFieldset_20.add(fldstNewFieldset_21, new FormData("100%"));
		
//		FieldSet fldstNewFieldset_22 = new FieldSet();
//		fldstNewFieldset_22.setHeadingHtml("월세액_세액공제");
//		  
//		LayoutContainer layoutContainer_315 = new LayoutContainer();
//		layoutContainer_315.setLayout(new ColumnLayout());
//		  
//		LayoutContainer layoutContainer_314 = new LayoutContainer();
//		  
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(0); 
//		layoutContainer_314.setLayout(frmlytSch);
//		  
//		Button btnNewButton_16 = new Button("월세액등록");
//		btnNewButton_16.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				// 전체내역
//				YetaP23005 yetaP23005Form = new YetaP23005(ActionDatabase.READ,getThis());
//
//				MSFFormWindows msFwYeta73005 = new MSFFormWindows("월세액소득공제명세",yetaP23005Form, "닫기", "820px", "510px", true);
//				msFwYeta73005.show();
//				yetaP23005Form.setMSFFormWindows(msFwYeta73005);
//
//				funcSetPopUpRecord();
//				yetaP23005Form.bind(ppRecord);
//			}
//		});
//		layoutContainer_314.add(btnNewButton_16, new FormData("100%"));
//		layoutContainer_315.add(layoutContainer_314,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//
//		
//		LayoutContainer layoutContainer_316 = new LayoutContainer();
//
//		// 지출금액
//		LayoutContainer layoutContainer_456 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(100);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_456.setLayout(frmlytSch);
//
//		mmrUseAmt = new MSFNumberField();
//		mmrUseAmt.setReadOnly(true);
//		mmrUseAmt.setAllowDecimals(true);
//		mmrUseAmt.setPropertyEditorType(Long.class);
//		mmrUseAmt.setFormat(NumberFormat.getDecimalFormat());
//		mmrUseAmt.setFieldLabel("지출금액");
//
//		layoutContainer_456.add(mmrUseAmt, new FormData("100%"));
//
//		layoutContainer_316.add(layoutContainer_456, new FormData("100%"));
//		layoutContainer_315.add(layoutContainer_316,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
//
//		
//		LayoutContainer layoutContainer_317 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(100);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_317.setLayout(frmlytSch);
//		
//		
//		// 특별공제_주택자금월세공제액
//		LayoutContainer layoutContainer_458 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(50);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_458.setLayout(frmlytSch);
//
//		mmrDdcAmt = new MSFNumberField();
//		mmrDdcAmt.setReadOnly(true);
//		mmrDdcAmt.setAllowDecimals(true);
//		mmrDdcAmt.setPropertyEditorType(Long.class);
//		mmrDdcAmt.setFormat(NumberFormat.getDecimalFormat());
//		mmrDdcAmt.setFieldLabel("공제액");
//
//		layoutContainer_458.add(mmrDdcAmt, new FormData("100%"));
//
//		layoutContainer_317.add(layoutContainer_458, new FormData("100%"));
//		layoutContainer_315.add(layoutContainer_317,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
//
//		fldstNewFieldset_22.add(layoutContainer_315, new FormData("100%"));
//		fldstNewFieldset_20.add(fldstNewFieldset_22);
		
		
		
		FieldSet fldstNewFieldset_23 = new FieldSet();
		// layoutContainer_303.add(fldstNewFieldset_23);
		fldstNewFieldset_23.setHeadingHtml("장기주택저당차입금");
		fldstNewFieldset_23.setCollapsible(false);

		LayoutContainer layoutContainer_305 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_305.setLayout(frmlytSch);
		
		LayoutContainer layoutContainer_306 = new LayoutContainer();

		FieldSet fldstNewFieldset_24 = new FieldSet();
		fldstNewFieldset_24.setHeadingHtml("2011년 이전 차입분");
		
		LayoutContainer layoutContainer_311 = new LayoutContainer();
		layoutContainer_311.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_312 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_312.setLayout(frmlytSch);

		// 이자상환액(15년 미만)
		LayoutContainer layoutContainer_460 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_460.setLayout(frmlytSch);

		lthYr15BlwItrAmt = new MSFNumberField();
		lthYr15BlwItrAmt.setAllowDecimals(true);
		lthYr15BlwItrAmt.setPropertyEditorType(Long.class);
		lthYr15BlwItrAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr15BlwItrAmt.setFieldLabel("이자상환액(15년 미만)");

		layoutContainer_460.add(lthYr15BlwItrAmt, new FormData("100%"));
		layoutContainer_312.add(layoutContainer_460, new FormData("100%"));

		// 이자상환액(15년 ~ 29년)
		LayoutContainer layoutContainer_461 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_461.setLayout(frmlytSch);

		lthYr29ItrAmt = new MSFNumberField();
		lthYr29ItrAmt.setAllowDecimals(true);
		lthYr29ItrAmt.setPropertyEditorType(Long.class);
		lthYr29ItrAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr29ItrAmt.setFieldLabel("이자상환액(15년~29년)");
			
		layoutContainer_461.add(lthYr29ItrAmt, new FormData("100%"));
		layoutContainer_312.add(layoutContainer_461, new FormData("100%"));

		
		// 이자상환액(30년 이상)
		LayoutContainer layoutContainer_468 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_468.setLayout(frmlytSch);

		lthY30OverItrAmt = new MSFNumberField();
		lthY30OverItrAmt.setAllowDecimals(true);
		lthY30OverItrAmt.setPropertyEditorType(Long.class);
		lthY30OverItrAmt.setFormat(NumberFormat.getDecimalFormat());
		lthY30OverItrAmt.setFieldLabel("이자상환액(30년 이상)");

		layoutContainer_468.add(lthY30OverItrAmt, new FormData("100%"));

		layoutContainer_312.add(layoutContainer_468, new FormData("100%"));
		layoutContainer_311.add(layoutContainer_312, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_313 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_313.setLayout(frmlytSch);
		
		// 특별공제_11장기주택저당차입금15 공제액
		LayoutContainer layoutContainer_462 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_462.setLayout(frmlytSch);

		lthYr15BlwDdcAmt = new MSFNumberField();
		lthYr15BlwDdcAmt.setReadOnly(true);
		lthYr15BlwDdcAmt.setAllowDecimals(true);
		lthYr15BlwDdcAmt.setPropertyEditorType(Long.class);
		lthYr15BlwDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr15BlwDdcAmt.setFieldLabel("공제액");
			
		layoutContainer_462.add(lthYr15BlwDdcAmt, new FormData("100%"));
		layoutContainer_313.add(layoutContainer_462, new FormData("100%"));
		

		// 특별공제_11장기주택저당차입금29 공제액
		LayoutContainer layoutContainer_463 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_463.setLayout(frmlytSch);

		lthYr29DdcAmt = new MSFNumberField();
		lthYr29DdcAmt.setReadOnly(true);
		lthYr29DdcAmt.setAllowDecimals(true);
		lthYr29DdcAmt.setPropertyEditorType(Long.class);
		lthYr29DdcAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr29DdcAmt.setFieldLabel("공제액");

		layoutContainer_463.add(lthYr29DdcAmt, new FormData("100%"));
		layoutContainer_313.add(layoutContainer_463, new FormData("100%"));

		// 특별공제_11장기주택저당차입금30 공제액
		LayoutContainer layoutContainer_469 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_469.setLayout(frmlytSch);

		lthY30OverDdcAmt = new MSFNumberField();
		lthY30OverDdcAmt.setReadOnly(true);
		lthY30OverDdcAmt.setAllowDecimals(true);
		lthY30OverDdcAmt.setPropertyEditorType(Long.class);
		lthY30OverDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		lthY30OverDdcAmt.setFieldLabel("공제액");

		layoutContainer_469.add(lthY30OverDdcAmt, new FormData("100%"));
		layoutContainer_313.add(layoutContainer_469, new FormData("100%"));

		layoutContainer_311.add(layoutContainer_313,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		  
		  
		fldstNewFieldset_24.add(layoutContainer_311, new FormData("100%"));
		layoutContainer_306.add(fldstNewFieldset_24, new FormData("100%"));

		layoutContainer_305.add(layoutContainer_306, new FormData("100%"));


		LayoutContainer layoutContainer_307 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_307.setLayout(frmlytSch);
		
		FieldSet fldstNewFieldset_25 = new FieldSet();
		fldstNewFieldset_25.setHeadingHtml("2012년 이후 차입분(15년이상)");

		LayoutContainer layoutContainer_308 = new LayoutContainer();
		layoutContainer_308.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_309 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_309.setLayout(frmlytSch);

		// 고정금리.비거치상환
		LayoutContainer layoutContainer_464 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_464.setLayout(frmlytSch);

		lthYr2012AfthY15Amt = new MSFNumberField();
		lthYr2012AfthY15Amt.setAllowDecimals(true);
		lthYr2012AfthY15Amt.setPropertyEditorType(Long.class);
		lthYr2012AfthY15Amt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2012AfthY15Amt.setFieldLabel("고정금리이면서, 비거치상환대출");
		
		layoutContainer_464.add(lthYr2012AfthY15Amt, new FormData("100%"));
		layoutContainer_309.add(layoutContainer_464, new FormData("100%"));

		
		// 기타대출
		LayoutContainer layoutContainer_465 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_465.setLayout(frmlytSch);

		lthYr2012EtcBrwItrAmt = new MSFNumberField();
		lthYr2012EtcBrwItrAmt.setAllowDecimals(true);
		lthYr2012EtcBrwItrAmt.setPropertyEditorType(Long.class);
		lthYr2012EtcBrwItrAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2012EtcBrwItrAmt.setFieldLabel("기타대출");

		layoutContainer_465.add(lthYr2012EtcBrwItrAmt, new FormData("100%"));
		layoutContainer_309.add(layoutContainer_465, new FormData("100%"));
		layoutContainer_308.add(layoutContainer_309,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));


		LayoutContainer layoutContainer_310 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_310.setLayout(frmlytSch);
		
		// 특별공제_12장기주택저당차입금_고정 공제액
		LayoutContainer layoutContainer_466 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_466.setLayout(frmlytSch);

		lthYr2012AfthY15DdcAmt = new MSFNumberField();
		lthYr2012AfthY15DdcAmt.setReadOnly(true);
		lthYr2012AfthY15DdcAmt.setAllowDecimals(true);
		lthYr2012AfthY15DdcAmt.setPropertyEditorType(Long.class);
		lthYr2012AfthY15DdcAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2012AfthY15DdcAmt.setFieldLabel("공제액");

		layoutContainer_466.add(lthYr2012AfthY15DdcAmt, new FormData("100%"));
		layoutContainer_310.add(layoutContainer_466, new FormData("100%"));

		// 특별공제_12장기주택저당차입금_기타 공제액
		LayoutContainer layoutContainer_467 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_467.setLayout(frmlytSch);

		lthYr2012EtcBrwDdcAmt = new MSFNumberField();
		lthYr2012EtcBrwDdcAmt.setReadOnly(true);
		lthYr2012EtcBrwDdcAmt.setAllowDecimals(true);
		lthYr2012EtcBrwDdcAmt.setPropertyEditorType(Long.class);
		lthYr2012EtcBrwDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2012EtcBrwDdcAmt.setFieldLabel("공제액");
		  
		layoutContainer_467.add(lthYr2012EtcBrwDdcAmt, new FormData("100%"));
		layoutContainer_310.add(layoutContainer_467, new FormData("100%"));

		layoutContainer_308.add(layoutContainer_310,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));

		layoutContainer_310.setBorders(false);

		fldstNewFieldset_25.add(layoutContainer_308, new FormData("100%"));

		layoutContainer_307.add(fldstNewFieldset_25, new FormData("100%"));
		fldstNewFieldset_25.setCollapsible(false);

		FieldSet fldstNewFieldset_28 = new FieldSet();
		fldstNewFieldset_28.setHeadingHtml("2015년 이후 차입분");

		LayoutContainer layoutContainer_348 = new LayoutContainer();
		layoutContainer_348.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_349 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_349.setLayout(frmlytSch);
		

		// 특별공제_15장기주택저당_15고정AND비거치상환
		LayoutContainer layoutContainer_350 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_350.setLayout(frmlytSch);

		lthYr2015AfthFxnIrItrAmt = new MSFNumberField();
		lthYr2015AfthFxnIrItrAmt.setAllowDecimals(true);
		lthYr2015AfthFxnIrItrAmt.setPropertyEditorType(Long.class);
		lthYr2015AfthFxnIrItrAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2015AfthFxnIrItrAmt.setFieldLabel("고정금리이면서,비거치상환대출(15년이상)");

		layoutContainer_350.add(lthYr2015AfthFxnIrItrAmt, new FormData("100%"));
		layoutContainer_349.add(layoutContainer_350, new FormData("100%"));

		// 특별공제_15장기주택저당_15고정OR비거치상환
		LayoutContainer layoutContainer_351 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_351.setLayout(frmlytSch);

		lthYr2015AfthY15Amt = new MSFNumberField();
		lthYr2015AfthY15Amt.setAllowDecimals(true);
		lthYr2015AfthY15Amt.setPropertyEditorType(Long.class);
		lthYr2015AfthY15Amt.setFormat(NumberFormat.getDecimalFormat());

		lthYr2015AfthY15Amt.setFieldLabel("고정금리이거나,비거치상환대출(15년이상)");
		layoutContainer_351.add(lthYr2015AfthY15Amt, new FormData("100%"));
		layoutContainer_349.add(layoutContainer_351, new FormData("100%"));

		// 특별공제_15장기주택저당_15기타대출
		LayoutContainer layoutContainer_352 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_352.setLayout(frmlytSch);

		lthYr2015AfthEtcAmt = new MSFNumberField();
		lthYr2015AfthEtcAmt.setAllowDecimals(true);
		lthYr2015AfthEtcAmt.setPropertyEditorType(Long.class);
		lthYr2015AfthEtcAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2015AfthEtcAmt.setFieldLabel("그밖의 대출(15년이상)");
		
		layoutContainer_352.add(lthYr2015AfthEtcAmt, new FormData("100%"));
		layoutContainer_349.add(layoutContainer_352, new FormData("100%"));

		// 특별공제_15장기주택저당_10고정OR비거치상환
		LayoutContainer layoutContainer_353 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(240);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_353.setLayout(frmlytSch);

		lthYr2015AfthYr15Amt = new MSFNumberField();
		lthYr2015AfthYr15Amt.setAllowDecimals(true);
		lthYr2015AfthYr15Amt.setPropertyEditorType(Long.class);
		lthYr2015AfthYr15Amt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2015AfthYr15Amt.setFieldLabel("고정금리이거나,비거치상환대출(10~15년)");
		layoutContainer_353.add(lthYr2015AfthYr15Amt, new FormData("100%"));
		
		layoutContainer_349.add(layoutContainer_353, new FormData("100%"));
		layoutContainer_348.add(layoutContainer_349,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_354 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_354.setLayout(frmlytSch);
		
		// 특별공제_15장기주택저당_15고정AND비거치상환 공제액
		LayoutContainer layoutContainer_355 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_355.setLayout(frmlytSch);

		lthYr2015AfthFxnIrDdcAmt = new MSFNumberField();
		lthYr2015AfthFxnIrDdcAmt.setReadOnly(true);
		lthYr2015AfthFxnIrDdcAmt.setAllowDecimals(true);
		lthYr2015AfthFxnIrDdcAmt.setPropertyEditorType(Long.class);
		lthYr2015AfthFxnIrDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		lthYr2015AfthFxnIrDdcAmt.setFieldLabel("공제액");
		
		layoutContainer_355.add(lthYr2015AfthFxnIrDdcAmt, new FormData("100%"));
		layoutContainer_354.add(layoutContainer_355, new FormData("100%"));

		// 특별공제_15장기주택저당_15고정OR비거치상환 공제액
		LayoutContainer layoutContainer_356 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_356.setLayout(frmlytSch);

		lthYr2015AfthY15DdcAmt = new MSFNumberField();
		lthYr2015AfthY15DdcAmt.setReadOnly(true);
		lthYr2015AfthY15DdcAmt.setFieldLabel("공제액");
		lthYr2015AfthY15DdcAmt.setAllowDecimals(true);
		lthYr2015AfthY15DdcAmt.setPropertyEditorType(Long.class);
		lthYr2015AfthY15DdcAmt.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_356.add(lthYr2015AfthY15DdcAmt, new FormData("100%"));
		layoutContainer_354.add(layoutContainer_356, new FormData("100%"));

		
		// 특별공제_15장기주택저당_15기타대출 공제액
		LayoutContainer layoutContainer_357 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_357.setLayout(frmlytSch);

		lthYr2015AfthEtcDdcAmt = new MSFNumberField();
		lthYr2015AfthEtcDdcAmt.setReadOnly(true);
		lthYr2015AfthEtcDdcAmt.setFieldLabel("공제액");
		lthYr2015AfthEtcDdcAmt.setAllowDecimals(true);
		lthYr2015AfthEtcDdcAmt.setPropertyEditorType(Long.class);
		lthYr2015AfthEtcDdcAmt.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_357.add(lthYr2015AfthEtcDdcAmt, new FormData("100%"));
		layoutContainer_354.add(layoutContainer_357, new FormData("100%"));

		// 특별공제_15장기주택저당_10고정OR비거치상환 공제액
		LayoutContainer layoutContainer_358 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_358.setLayout(frmlytSch);

		lthYr2015AfthYr15DdcAmt = new MSFNumberField();
		lthYr2015AfthYr15DdcAmt.setReadOnly(true);
		lthYr2015AfthYr15DdcAmt.setFieldLabel("공제액");
		lthYr2015AfthYr15DdcAmt.setAllowDecimals(true);
		lthYr2015AfthYr15DdcAmt.setPropertyEditorType(Long.class);
		lthYr2015AfthYr15DdcAmt.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_358.add(lthYr2015AfthYr15DdcAmt, new FormData("100%"));

		layoutContainer_354.add(layoutContainer_358, new FormData("100%"));

		layoutContainer_348.add(layoutContainer_354,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));

		fldstNewFieldset_28.add(layoutContainer_348, new FormData("100%"));
		layoutContainer_307.add(fldstNewFieldset_28, new FormData("100%"));

		layoutContainer_305.add(layoutContainer_307, new FormData("100%"));

		fldstNewFieldset_23.add(layoutContainer_305, new FormData("100%"));
		fldstNewFieldset_20.add(fldstNewFieldset_23, new FormData("100%"));

		// 주택자금공제계
		LayoutContainer layoutContainer_304 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(430);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_304.setLayout(frmlytSch);

		hsngFndsDdcAmtSum = new MSFNumberField();
		hsngFndsDdcAmtSum.setReadOnly(true);
		hsngFndsDdcAmtSum.setFieldLabel("주택자금공제계");
		hsngFndsDdcAmtSum.setAllowDecimals(true);
		hsngFndsDdcAmtSum.setPropertyEditorType(Long.class);
		hsngFndsDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_304.add(hsngFndsDdcAmtSum, new FormData("100%"));
		fldstNewFieldset_20.add(layoutContainer_304, new FormData("100%"));

		layoutContainer_300.add(fldstNewFieldset_20);
	
		cntntpnlNewContentpanel_2.add(layoutContainer_300);
		itemYeta05_2.add(cntntpnlNewContentpanel_2);

		tabsItemYeta05.add(itemYeta05_2);
		
		//기부금(이월분)tab
		TabItem itemYeta05_3 = new TabItem("기부금(이월분)");
		itemYeta05_3.setId("itemYeta05_3");
		
		ContentPanel cntntpnlNewContentpanel_3 = new ContentPanel();
		cntntpnlNewContentpanel_3.setSize(650, 570);
		cntntpnlNewContentpanel_3.setScrollMode(Scroll.AUTOY);
		cntntpnlNewContentpanel_3.setHeaderVisible(false);
		cntntpnlNewContentpanel_3.setHeadingHtml("");
		  
		
		FieldSet fldstNewFieldset_34 = new FieldSet();
		fldstNewFieldset_34.setHeadingHtml("기부금공제");
				
		LayoutContainer layoutContainer_359 = new LayoutContainer();
				
		LayoutContainer layoutContainer_428 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer_428_left = new LayoutContainer();
		
		LayoutContainer layoutContainer_428_left01 = new LayoutContainer();
		
		FormLayout frmlytSch428 = new FormLayout();
		frmlytSch428.setLabelWidth(170);
		frmlytSch428.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_left01.setLayout(frmlytSch428);

		conbLglUseAmt01 = new MSFNumberField();
		conbLglUseAmt01.setReadOnly(true);
		conbLglUseAmt01.setFieldLabel("이월법정기부금액");
		conbLglUseAmt01.setAllowDecimals(true); 
		conbLglUseAmt01.setPropertyEditorType(Long.class); 
		conbLglUseAmt01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_left01.add(conbLglUseAmt01, new FormData("100%"));
		layoutContainer_428_left.add(layoutContainer_428_left01);
		
		LayoutContainer layoutContainer_428_left02 = new LayoutContainer();
		
		frmlytSch428 = new FormLayout();
		frmlytSch428.setLabelWidth(170);
		frmlytSch428.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_left02.setLayout(frmlytSch428);

		conbReliOrgOthUseAmt01 = new MSFNumberField();
		conbReliOrgOthUseAmt01.setReadOnly(true);
		conbReliOrgOthUseAmt01.setFieldLabel("이월지정기부금(종교단체 외)");
		conbReliOrgOthUseAmt01.setAllowDecimals(true); 
		conbReliOrgOthUseAmt01.setPropertyEditorType(Long.class); 
		conbReliOrgOthUseAmt01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_left02.add(conbReliOrgOthUseAmt01, new FormData("100%"));
		layoutContainer_428_left.add(layoutContainer_428_left02);
		
		LayoutContainer layoutContainer_428_left03 = new LayoutContainer();
		
		frmlytSch428 = new FormLayout();
		frmlytSch428.setLabelWidth(170);
		frmlytSch428.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_left03.setLayout(frmlytSch428);

		conbReliOrgUseAmt01 = new MSFNumberField();
		conbReliOrgUseAmt01.setFieldLabel("이월지정기부금(종교단체)");
		conbReliOrgUseAmt01.setReadOnly(true);
		conbReliOrgUseAmt01.setAllowDecimals(true); 
		conbReliOrgUseAmt01.setPropertyEditorType(Long.class); 
		conbReliOrgUseAmt01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_left03.add(conbReliOrgUseAmt01, new FormData("100%"));
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

		conbLglDdcAmt01 = new MSFNumberField();
		conbLglDdcAmt01.setFieldLabel("공제세액");
		conbLglDdcAmt01.setReadOnly(true);
		conbLglDdcAmt01.setAllowDecimals(true); 
		conbLglDdcAmt01.setPropertyEditorType(Long.class); 
		conbLglDdcAmt01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_right01.add(conbLglDdcAmt01, new FormData("100%"));
		layoutContainer_428_right.add(layoutContainer_428_right01);
		
		
		
		//이월종교단체기부금_공제액
		LayoutContainer layoutContainer_428_right02 = new LayoutContainer();
		
		frmlytSch429 = new FormLayout();
		frmlytSch429.setLabelWidth(100);
		frmlytSch429.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_right02.setLayout(frmlytSch429);

		conbReliOrgOthDdcAmt01 = new MSFNumberField();
		conbReliOrgOthDdcAmt01.setFieldLabel("공제세액");
		conbReliOrgOthDdcAmt01.setReadOnly(true);
		conbReliOrgOthDdcAmt01.setAllowDecimals(true); 
		conbReliOrgOthDdcAmt01.setPropertyEditorType(Long.class); 
		conbReliOrgOthDdcAmt01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_right02.add(conbReliOrgOthDdcAmt01, new FormData("100%"));
		layoutContainer_428_right.add(layoutContainer_428_right02);
		
		
		
		//지정기부금(종교단체)_공제액
		LayoutContainer layoutContainer_428_right03 = new LayoutContainer();
		
		frmlytSch429 = new FormLayout();
		frmlytSch429.setLabelWidth(100);
		frmlytSch429.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_428_right03.setLayout(frmlytSch429);

		conbReliOrgDdcAmt01 = new MSFNumberField();
		conbReliOrgDdcAmt01.setFieldLabel("공제세액");
		conbReliOrgDdcAmt01.setReadOnly(true);
		conbReliOrgDdcAmt01.setAllowDecimals(true); 
		conbReliOrgDdcAmt01.setPropertyEditorType(Long.class); 
		conbReliOrgDdcAmt01.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_428_right03.add(conbReliOrgDdcAmt01, new FormData("100%"));
		layoutContainer_428_right.add(layoutContainer_428_right03);
		
		
		layoutContainer_428.add(layoutContainer_428_right, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_359.add(layoutContainer_428);
		
		
		LayoutContainer layoutContainer_3633 = new LayoutContainer();
		layoutContainer_3633.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_363 = new LayoutContainer();

		FormLayout frmlytSch4 = new FormLayout();
		frmlytSch4.setLabelWidth(220);
		frmlytSch4.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_363.setLayout(frmlytSch4);

		conbUseAmtSum01 = new MSFNumberField();
		conbUseAmtSum01.setFieldLabel("지정기부금계(이월분)");
		conbUseAmtSum01.setReadOnly(true);	
		conbUseAmtSum01.setAllowDecimals(true); 
		conbUseAmtSum01.setPropertyEditorType(Long.class); 
		conbUseAmtSum01.setFormat(NumberFormat.getDecimalFormat());
				
		layoutContainer_363.add(conbUseAmtSum01, new FormData("100%"));
		layoutContainer_3633.add(layoutContainer_363, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		LayoutContainer layoutContainer_3634 = new LayoutContainer();

		frmlytSch4 = new FormLayout();
		frmlytSch4.setLabelWidth(160);
		frmlytSch4.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3634.setLayout(frmlytSch4);

		conbDdcAmtSum01 = new MSFNumberField();
		conbDdcAmtSum01.setFieldLabel("지정기부금공제계(이월분)");
		conbDdcAmtSum01.setReadOnly(true);	
		conbDdcAmtSum01.setAllowDecimals(true); 
		conbDdcAmtSum01.setPropertyEditorType(Long.class); 
		conbDdcAmtSum01.setFormat(NumberFormat.getDecimalFormat());
				
		layoutContainer_3634.add(conbDdcAmtSum01, new FormData("100%"));
		layoutContainer_3633.add(layoutContainer_3634, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		
		layoutContainer_359.add(layoutContainer_3633);
		
		fldstNewFieldset_34.add(layoutContainer_359);
		cntntpnlNewContentpanel_3.add(fldstNewFieldset_34);
		
		itemYeta05_3.add(cntntpnlNewContentpanel_3);
		tabsItemYeta05.add(itemYeta05_3);
		

		layoutContainer_12.add(tabsItemYeta05);
		cp01.add(layoutContainer_12);
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	private LayoutContainer yetaData06() {
		
		ContentPanel cp01 = new ContentPanel();

//		cp01.setScrollMode(Scroll.AUTOY);// 스크롤
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		//엣지변환
		//cp01.setSize("660", "590");
		cp01.setSize("660", "790");

		LayoutContainer layoutContainer_13 = new LayoutContainer();

		// 연금저축공제
		LayoutContainer layoutContainer_199 = new LayoutContainer();

		FieldSet fldstNewFieldset_14 = new FieldSet();
		fldstNewFieldset_14.setHeadingHtml("연금저축공제");
		
		LayoutContainer layoutContainer_202 = new LayoutContainer();
		layoutContainer_202.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_203 = new LayoutContainer();
		layoutContainer_203.setLayout(new ColumnLayout());

		// 개인납입금액
		LayoutContainer layoutContainer_205 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_205.setLayout(frmlytSch);

		yr2000PnsnSvngUseAmt = new MSFNumberField();
		yr2000PnsnSvngUseAmt.setFieldLabel("개인납입금액");
		yr2000PnsnSvngUseAmt.setAllowDecimals(true); 
		yr2000PnsnSvngUseAmt.setPropertyEditorType(Long.class); 
		yr2000PnsnSvngUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_205.add(yr2000PnsnSvngUseAmt, new FormData("100%"));
		layoutContainer_203.add(layoutContainer_205, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		  
		
		LayoutContainer layoutContainer_206 = new LayoutContainer();

		LabelField lblfldNewLabelfield_33 = new LabelField("(2000.12.31.이전가입)");
		layoutContainer_206.add(lblfldNewLabelfield_33);
		layoutContainer_203.add(layoutContainer_206, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		  
		layoutContainer_202.add(layoutContainer_203, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		  
		// 개인연금저축불입액_2000년이전 공제액
		LayoutContainer layoutContainer_204 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_204.setLayout(frmlytSch);

		yr2000PnsnSvngDdcAmt = new MSFNumberField();
		yr2000PnsnSvngDdcAmt.setReadOnly(true);
		yr2000PnsnSvngDdcAmt.setFieldLabel("공제액");
		yr2000PnsnSvngDdcAmt.setAllowDecimals(true); 
		yr2000PnsnSvngDdcAmt.setPropertyEditorType(Long.class); 
		yr2000PnsnSvngDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_204.add(yr2000PnsnSvngDdcAmt, new FormData("100%"));
		layoutContainer_202.add(layoutContainer_204, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		  
		fldstNewFieldset_14.add(layoutContainer_202, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_199.add(fldstNewFieldset_14);
		
		layoutContainer_13.add(layoutContainer_199);
		  
		  
		  
		// 주택마련저축소득공제
		LayoutContainer layoutContainer_200 = new LayoutContainer();

		FieldSet fldstNewFieldset_15 = new FieldSet();
		fldstNewFieldset_15.setHeadingHtml("주택마련저축소득공제");

		LayoutContainer layoutContainer_210 = new LayoutContainer();
		layoutContainer_210.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_211 = new LayoutContainer();

		
		// 청약저축
		LayoutContainer layoutContainer_213 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_213.setLayout(frmlytSch);

		sbcSvngUseAmt = new MSFNumberField();
		sbcSvngUseAmt.setFieldLabel("청약저축");
		sbcSvngUseAmt.setAllowDecimals(true); 
		sbcSvngUseAmt.setPropertyEditorType(Long.class); 
		sbcSvngUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_213.add(sbcSvngUseAmt, new FormData("100%"));
		layoutContainer_211.add(layoutContainer_213);

		// 주택청약종합저축
		LayoutContainer layoutContainer_214 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_214.setLayout(frmlytSch);

		hsngSvngUseAmt = new MSFNumberField();
		hsngSvngUseAmt.setFieldLabel("주택청약종합저축");
		hsngSvngUseAmt.setAllowDecimals(true); 
		hsngSvngUseAmt.setPropertyEditorType(Long.class); 
		hsngSvngUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_214.add(hsngSvngUseAmt, new FormData("100%"));
		layoutContainer_211.add(layoutContainer_214);
		
		
//		LayoutContainer layoutContainer_2141 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(170);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_2141.setLayout(frmlytSch);
//
//		hsngSvngUseAmt2015 = new MSFNumberField();
//		hsngSvngUseAmt2015.setFieldLabel("주택청약종합저축(2015년이후)");
//		hsngSvngUseAmt2015.setAllowDecimals(true); 
//		hsngSvngUseAmt2015.setPropertyEditorType(Long.class); 
//		hsngSvngUseAmt2015.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_2141.add(hsngSvngUseAmt2015, new FormData("100%"));
//		layoutContainer_211.add(layoutContainer_2141);
		

		// 근로자주택마련저축
		LayoutContainer layoutContainer_215 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_215.setLayout(frmlytSch);

		lbrrPrptSvngUseAmt = new MSFNumberField();
		lbrrPrptSvngUseAmt.setFieldLabel("근로자주택마련저축");
		lbrrPrptSvngUseAmt.setAllowDecimals(true); 
		lbrrPrptSvngUseAmt.setPropertyEditorType(Long.class); 
		lbrrPrptSvngUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_215.add(lbrrPrptSvngUseAmt, new FormData("100%"));
		layoutContainer_211.add(layoutContainer_215);

		
		// 주택마련저축소득공제계
		LayoutContainer layoutContainer_216 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(170);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_216.setLayout(frmlytSch);

		hsngIncUseAmtSum = new MSFNumberField();
		hsngIncUseAmtSum.setReadOnly(true);
		hsngIncUseAmtSum.setFieldLabel("주택마련저축소득공제계");
		hsngIncUseAmtSum.setAllowDecimals(true); 
		hsngIncUseAmtSum.setPropertyEditorType(Long.class); 
		hsngIncUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_216.add(hsngIncUseAmtSum, new FormData("100%"));
		layoutContainer_211.add(layoutContainer_216);

		layoutContainer_210.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		
		LayoutContainer layoutContainer_212 = new LayoutContainer();

		// 기타공제_주택마련저축_청약저축 공제액
		LayoutContainer layoutContainer_217 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_217.setLayout(frmlytSch);

		sbcSvngDdcAmt = new MSFNumberField();
		sbcSvngDdcAmt.setReadOnly(true);
		sbcSvngDdcAmt.setFieldLabel("공제액");
		sbcSvngDdcAmt.setAllowDecimals(true); 
		sbcSvngDdcAmt.setPropertyEditorType(Long.class); 
		sbcSvngDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_217.add(sbcSvngDdcAmt, new FormData("100%"));
		layoutContainer_212.add(layoutContainer_217);

		// 기타공제_주택마련저축_주택청약종합저축 공제액
		LayoutContainer layoutContainer_218 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_218.setLayout(frmlytSch);

		hsngSvngDdcAmt = new MSFNumberField();
		hsngSvngDdcAmt.setReadOnly(true);
		hsngSvngDdcAmt.setFieldLabel("공제액");
		hsngSvngDdcAmt.setAllowDecimals(true); 
		hsngSvngDdcAmt.setPropertyEditorType(Long.class); 
		hsngSvngDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_218.add(hsngSvngDdcAmt, new FormData("100%"));
		layoutContainer_212.add(layoutContainer_218);
		
		
		
		// 기타공제_주택마련저축_주택청약종합저축 공제액_2015
//		LayoutContainer layoutContainer_2182 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_2182.setLayout(frmlytSch);
//
//		hsngSvngDdcAmt2015 = new MSFNumberField();
//		hsngSvngDdcAmt2015.setReadOnly(true);
//		hsngSvngDdcAmt2015.setFieldLabel("공제액");
//		hsngSvngDdcAmt2015.setAllowDecimals(true); 
//		hsngSvngDdcAmt2015.setPropertyEditorType(Long.class); 
//		hsngSvngDdcAmt2015.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_2182.add(hsngSvngDdcAmt2015, new FormData("100%"));
//		layoutContainer_212.add(layoutContainer_2182);
		

		// 기타공제_주택마련저축_근로자주택마련저축 공제액
		LayoutContainer layoutContainer_219 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_219.setLayout(frmlytSch);

		lbrrPrptSvngDdcAmt = new MSFNumberField();
		lbrrPrptSvngDdcAmt.setReadOnly(true);
		lbrrPrptSvngDdcAmt.setFieldLabel("공제액");
		lbrrPrptSvngDdcAmt.setAllowDecimals(true); 
		lbrrPrptSvngDdcAmt.setPropertyEditorType(Long.class); 
		lbrrPrptSvngDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_219.add(lbrrPrptSvngDdcAmt, new FormData("100%"));
		layoutContainer_212.add(layoutContainer_219);

		// 기타공제_주택마련저축소득공제계
		LayoutContainer layoutContainer_220 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_220.setLayout(frmlytSch);

		hsngIncDdcAmtSum = new MSFNumberField();
		hsngIncDdcAmtSum.setReadOnly(true);
		hsngIncDdcAmtSum.setFieldLabel("공제액계");
		hsngIncDdcAmtSum.setAllowDecimals(true); 
		hsngIncDdcAmtSum.setPropertyEditorType(Long.class); 
		hsngIncDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_220.add(hsngIncDdcAmtSum, new FormData("100%"));
		layoutContainer_212.add(layoutContainer_220);
		  
		layoutContainer_210.add(layoutContainer_212, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		fldstNewFieldset_15.add(layoutContainer_210);
		layoutContainer_200.add(fldstNewFieldset_15);
		layoutContainer_13.add(layoutContainer_200);
		
		
		
		// 소기업.소상공인공제부금 불입금
		FieldSet fldstNewFieldset_208= new FieldSet();
		fldstNewFieldset_208.setHeadingHtml("소기업소상공인공제부금");
		
		LayoutContainer layoutContainer_207 = new LayoutContainer();
		layoutContainer_207.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_208 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(220);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_208.setLayout(frmlytSch);

		smceSbizUseAmt = new MSFNumberField();
		smceSbizUseAmt.setFieldLabel("소기업소상공인공제부금(노란우산공제)");
		smceSbizUseAmt.setAllowDecimals(true); 
		smceSbizUseAmt.setPropertyEditorType(Long.class); 
		smceSbizUseAmt.setFormat(NumberFormat.getDecimalFormat());
						
		layoutContainer_208.add(smceSbizUseAmt, new FormData("100%"));
		layoutContainer_207.add(layoutContainer_208, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));	
		
						  
		// 기타공제_소기업공제불입금액 공제액
		LayoutContainer layoutContainer_209 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_209.setLayout(frmlytSch);

		smceSbizDdcAmt = new MSFNumberField();
		smceSbizDdcAmt.setReadOnly(true);
		smceSbizDdcAmt.setFieldLabel("공제액");
		smceSbizDdcAmt.setAllowDecimals(true); 
		smceSbizDdcAmt.setPropertyEditorType(Long.class); 
		smceSbizDdcAmt.setFormat(NumberFormat.getDecimalFormat());
						
		layoutContainer_209.add(smceSbizDdcAmt, new FormData("100%"));
		layoutContainer_207.add(layoutContainer_209, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		fldstNewFieldset_208.add(layoutContainer_207);
		layoutContainer_13.add(fldstNewFieldset_208);
		
		
		
		
		

		LayoutContainer layoutContainer_222 = new LayoutContainer();
		
		FieldSet fldstNewFieldset_17 = new FieldSet();
		fldstNewFieldset_17.setHeadingHtml("투자조합출자공제(공제율적용금액기입)");
		
		LayoutContainer layoutContainer_223 = new LayoutContainer();
		layoutContainer_223.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_224 = new LayoutContainer();

//		LayoutContainer layoutContainer_242 = new LayoutContainer();
//		layoutContainer_242.setLayout(new ColumnLayout());
//
//		// 출자.투자금액
//		LayoutContainer layoutContainer_250 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(100);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_250.setLayout(frmlytSch);
//
//		cpiv14AsctUseAmt = new MSFNumberField();
//		cpiv14AsctUseAmt.setFieldLabel("출자∙투자금액");
//		cpiv14AsctUseAmt.setAllowDecimals(true); 
//		cpiv14AsctUseAmt.setPropertyEditorType(Long.class); 
//		cpiv14AsctUseAmt.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_250.add(cpiv14AsctUseAmt, new FormData("100%"));
//		layoutContainer_242.add(layoutContainer_250, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//		  
//		
//		LayoutContainer layoutContainer_251 = new LayoutContainer();
//
//		LabelField lblfldNewLabelfield_34 = new LabelField("(2014년조합)");
//		layoutContainer_251.add(lblfldNewLabelfield_34);
//		layoutContainer_242.add(layoutContainer_251, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//
//		layoutContainer_224.add(layoutContainer_242);

//		LayoutContainer layoutContainer_243 = new LayoutContainer();
//		layoutContainer_243.setLayout(new ColumnLayout());
//
//		// 출자.투자금액
//		LayoutContainer layoutContainer_252 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(100);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_252.setLayout(frmlytSch);
//
//		cpiv14VntUseAmt = new MSFNumberField();
//		cpiv14VntUseAmt.setFieldLabel("출자∙투자금액");
//		cpiv14VntUseAmt.setAllowDecimals(true); 
//		cpiv14VntUseAmt.setPropertyEditorType(Long.class); 
//		cpiv14VntUseAmt.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_252.add(cpiv14VntUseAmt, new FormData("100%"));
//		layoutContainer_243.add(layoutContainer_252, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//
//		
//		// (2013년도)
//		LayoutContainer layoutContainer_253 = new LayoutContainer();
//
//		LabelField lblfldNewLabelfield_35 = new LabelField("(2014년벤처)");
//		layoutContainer_253.add(lblfldNewLabelfield_35);
//		layoutContainer_243.add(layoutContainer_253, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//
//		layoutContainer_224.add(layoutContainer_243);

	 	LayoutContainer layoutContainer_244 = new LayoutContainer();
		layoutContainer_244.setLayout(new ColumnLayout());

		// 출자.투자금액
		LayoutContainer layoutContainer_254 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_254.setLayout(frmlytSch);

		//2022연말정산_수정 : 19 -> 20 --------------------------------------------
		cpiv20AsctUseAmt = new MSFNumberField();
		cpiv20AsctUseAmt.setFieldLabel("출자∙투자금액");
		cpiv20AsctUseAmt.setAllowDecimals(true); 
		cpiv20AsctUseAmt.setPropertyEditorType(Long.class); 
		cpiv20AsctUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_254.add(cpiv20AsctUseAmt, new FormData("100%"));
		layoutContainer_244.add(layoutContainer_254, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		//
	 	LayoutContainer layoutContainer_255 = new LayoutContainer();

		LabelField lblfldNewLabelfield_36 = new LabelField("(2020년조합)");
		layoutContainer_255.add(lblfldNewLabelfield_36);
		layoutContainer_244.add(layoutContainer_255, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244);

		// (2020년 이후 출자∙투자분)
		LayoutContainer layoutContainer_2545 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2545.setLayout(frmlytSch);

		cpiv20VntUseAmt = new MSFNumberField();
		cpiv20VntUseAmt.setFieldLabel("출자∙투자금액");
		cpiv20VntUseAmt.setAllowDecimals(true); 
		cpiv20VntUseAmt.setPropertyEditorType(Long.class); 
		cpiv20VntUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2545.add(cpiv20VntUseAmt, new FormData("100%"));
		layoutContainer_244.add(layoutContainer_2545, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		// (2020년도)
		LayoutContainer layoutContainer_2555 = new LayoutContainer();

		LabelField lblfldNewLabelfield_366 = new LabelField("(2020년벤처)");
		layoutContainer_2555.add(lblfldNewLabelfield_366);
		layoutContainer_244.add(layoutContainer_2555, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244);
		
		
		
		LayoutContainer layoutContainer_25421 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_25421.setLayout(frmlytSch);

		cpiv20AsctTwoUseAmt = new MSFNumberField();
		cpiv20AsctTwoUseAmt.setFieldLabel("출자∙투자금액");
		cpiv20AsctTwoUseAmt.setAllowDecimals(true); 
		cpiv20AsctTwoUseAmt.setPropertyEditorType(Long.class); 
		cpiv20AsctTwoUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_25421.add(cpiv20AsctTwoUseAmt, new FormData("100%"));
		layoutContainer_244.add(layoutContainer_25421, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		//
	 	LayoutContainer layoutContainer_25521 = new LayoutContainer();

		LabelField lblfldNewLabelfield_3621 = new LabelField("(2020년조합2)");
		layoutContainer_25521.add(lblfldNewLabelfield_3621);
		layoutContainer_244.add(layoutContainer_25521, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244);
		
		//2022연말정산_수정 : 19 -> 20 --------------------------------------------
		
		
		//------------------2021년도   -----------------------------------------------------------
		
		
		LayoutContainer layoutContainer_244a = new LayoutContainer();
		layoutContainer_244a.setLayout(new ColumnLayout());

		// 출자.투자금액
		LayoutContainer layoutContainer_254a = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_254a.setLayout(frmlytSch);

		//2022연말정산_수정 : 20 -> 21 ----------------------------------
		
		cpiv21AsctUseAmt = new MSFNumberField();
		cpiv21AsctUseAmt.setFieldLabel("출자∙투자금액");
		cpiv21AsctUseAmt.setAllowDecimals(true); 
		cpiv21AsctUseAmt.setPropertyEditorType(Long.class); 
		cpiv21AsctUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_254a.add(cpiv21AsctUseAmt, new FormData("100%"));
		layoutContainer_244a.add(layoutContainer_254a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		// (2021년도)
		LayoutContainer layoutContainer_255a = new LayoutContainer();

		LabelField lblfldNewLabelfield_36a = new LabelField("(2021년조합)");
		layoutContainer_255a.add(lblfldNewLabelfield_36a);
		layoutContainer_244a.add(layoutContainer_255a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244a);

		
		// (2021년 이후 출자∙투자분)
		LayoutContainer layoutContainer_2545a = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2545a.setLayout(frmlytSch);

		cpiv21VntUseAmt = new MSFNumberField();
		cpiv21VntUseAmt.setFieldLabel("출자∙투자금액");
		cpiv21VntUseAmt.setAllowDecimals(true); 
		cpiv21VntUseAmt.setPropertyEditorType(Long.class); 
		cpiv21VntUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2545a.add(cpiv21VntUseAmt, new FormData("100%"));
		layoutContainer_244a.add(layoutContainer_2545a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
	
		LayoutContainer layoutContainer_2555a = new LayoutContainer();

		LabelField lblfldNewLabelfield_366a = new LabelField("(2021년벤처)");
		layoutContainer_2555a.add(lblfldNewLabelfield_366a);
		layoutContainer_244a.add(layoutContainer_2555a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244a);
		
		
		
		
		LayoutContainer layoutContainer_25421a = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_25421a.setLayout(frmlytSch);

		cpiv21AsctTwoUseAmt = new MSFNumberField();
		cpiv21AsctTwoUseAmt.setFieldLabel("출자∙투자금액");
		cpiv21AsctTwoUseAmt.setAllowDecimals(true); 
		cpiv21AsctTwoUseAmt.setPropertyEditorType(Long.class); 
		cpiv21AsctTwoUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_25421a.add(cpiv21AsctTwoUseAmt, new FormData("100%"));
		layoutContainer_244a.add(layoutContainer_25421a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		// (2021년도)
		LayoutContainer layoutContainer_25521a = new LayoutContainer();

		LabelField lblfldNewLabelfield_3621a = new LabelField("(2021년조합2)");
		layoutContainer_25521a.add(lblfldNewLabelfield_3621a);
		layoutContainer_244a.add(layoutContainer_25521a, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244a);
		
		//2022연말정산_수정 : 20 -> 21 ----------------------------------

		//------------------------2021년도 --------------------------------------------------------------------------------------------	
		
		
		
		//------------------2022년도   -----------------------------------------------------------
		
		LayoutContainer layoutContainer_244b = new LayoutContainer();
		layoutContainer_244b.setLayout(new ColumnLayout());

		// 출자.투자금액
		LayoutContainer layoutContainer_254b = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_254b.setLayout(frmlytSch);

		//2022연말정산_수정 : 21 -> 22 -------------------------------------------
		
		cpiv22AsctUseAmt = new MSFNumberField();
		cpiv22AsctUseAmt.setFieldLabel("출자∙투자금액");
		cpiv22AsctUseAmt.setAllowDecimals(true); 
		cpiv22AsctUseAmt.setPropertyEditorType(Long.class); 
		cpiv22AsctUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_254b.add(cpiv22AsctUseAmt, new FormData("100%"));
		layoutContainer_244b.add(layoutContainer_254b, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		// (2022년도)
		LayoutContainer layoutContainer_255b = new LayoutContainer();

		LabelField lblfldNewLabelfield_36b = new LabelField("(2022년조합)");
		layoutContainer_255b.add(lblfldNewLabelfield_36b);
		layoutContainer_244b.add(layoutContainer_255b, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244b);

		
		// (2022년 이후 출자∙투자분)
		LayoutContainer layoutContainer_2545b = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2545b.setLayout(frmlytSch);

		cpiv22VntUseAmt = new MSFNumberField();
		cpiv22VntUseAmt.setFieldLabel("출자∙투자금액");
		cpiv22VntUseAmt.setAllowDecimals(true); 
		cpiv22VntUseAmt.setPropertyEditorType(Long.class); 
		cpiv22VntUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2545b.add(cpiv22VntUseAmt, new FormData("100%"));
		layoutContainer_244b.add(layoutContainer_2545b, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		LayoutContainer layoutContainer_2555b = new LayoutContainer();

		LabelField lblfldNewLabelfield_366b = new LabelField("(2022년벤처)");
		layoutContainer_2555b.add(lblfldNewLabelfield_366b);
		layoutContainer_244b.add(layoutContainer_2555b, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244b);
		
		
		
		LayoutContainer layoutContainer_25421b = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_25421b.setLayout(frmlytSch);

		cpiv22AsctTwoUseAmt = new MSFNumberField();
		cpiv22AsctTwoUseAmt.setFieldLabel("출자∙투자금액");
		cpiv22AsctTwoUseAmt.setAllowDecimals(true); 
		cpiv22AsctTwoUseAmt.setPropertyEditorType(Long.class); 
		cpiv22AsctTwoUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_25421b.add(cpiv22AsctTwoUseAmt, new FormData("100%"));
		layoutContainer_244b.add(layoutContainer_25421b, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		// (2022년도)
		LayoutContainer layoutContainer_25521b = new LayoutContainer();

		LabelField lblfldNewLabelfield_3621b = new LabelField("(2022년조합2)");
		layoutContainer_25521b.add(lblfldNewLabelfield_3621b);
		layoutContainer_244b.add(layoutContainer_25521b, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_244b);
		
		//2022연말정산_수정 : 21 -> 22 -------------------------------------------

		//------------------------2022년도 --------------------------------------------------------------------------------------------		
		

		LayoutContainer layoutContainer_245 = new LayoutContainer();
		layoutContainer_245.setLayout(new ColumnLayout());

		// 출자.투자금액계
		LayoutContainer layoutContainer_256 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_256.setLayout(frmlytSch);

		ivcpInvmUseAmtSum = new MSFNumberField();
		ivcpInvmUseAmtSum.setReadOnly(true);
		ivcpInvmUseAmtSum.setFieldLabel("출자∙투자금액계");
		ivcpInvmUseAmtSum.setAllowDecimals(true); 
		ivcpInvmUseAmtSum.setPropertyEditorType(Long.class); 
		ivcpInvmUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_256.add(ivcpInvmUseAmtSum, new FormData("100%"));
		layoutContainer_245.add(layoutContainer_256, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		  
		LayoutContainer layoutContainer_257 = new LayoutContainer();
		layoutContainer_245.add(layoutContainer_257, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_224.add(layoutContainer_245);
		  
		layoutContainer_223.add(layoutContainer_224, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_225 = new LayoutContainer();

//		// 기타공제_투자조합출자소득공제_2012년도 공제액
//		LayoutContainer layoutContainer_246 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_246.setLayout(frmlytSch);
//
//		cpiv14AsctDdcAmt = new MSFNumberField();
//		cpiv14AsctDdcAmt.setReadOnly(true);
//		cpiv14AsctDdcAmt.setFieldLabel("공제액");
//		cpiv14AsctDdcAmt.setAllowDecimals(true); 
//		cpiv14AsctDdcAmt.setPropertyEditorType(Long.class); 
//		cpiv14AsctDdcAmt.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_246.add(cpiv14AsctDdcAmt, new FormData("100%"));
//		layoutContainer_225.add(layoutContainer_246);
//
//		// 기타공제_투자조합출자소득공제_2013년도 공제액
//		LayoutContainer layoutContainer_247 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_247.setLayout(frmlytSch);
//
//		cpiv14VntDdcAmt = new   MSFNumberField();
//		cpiv14VntDdcAmt.setReadOnly(true);
//		cpiv14VntDdcAmt.setFieldLabel("공제액");
//		cpiv14VntDdcAmt.setAllowDecimals(true); 
//		cpiv14VntDdcAmt.setPropertyEditorType(Long.class); 
//		cpiv14VntDdcAmt.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_247.add(cpiv14VntDdcAmt, new FormData("100%"));
//		layoutContainer_225.add(layoutContainer_247);
//
		// 기타공제_투자조합출자소득공제_2020년 공제액
		LayoutContainer layoutContainer_248 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_248.setLayout(frmlytSch);

		//2022연말정산_수정 : 19 -> 20 -------------------------------------------
		
		cpiv20AsctDdcAmt = new MSFNumberField();
		cpiv20AsctDdcAmt.setReadOnly(true);
		cpiv20AsctDdcAmt.setFieldLabel("공제액");
		cpiv20AsctDdcAmt.setAllowDecimals(true); 
		cpiv20AsctDdcAmt.setPropertyEditorType(Long.class); 
		cpiv20AsctDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_248.add(cpiv20AsctDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_248);

		// 기타공제_투자조합출자소득공제_2020년이후 공제액
		LayoutContainer layoutContainer_2522 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2522.setLayout(frmlytSch);

		cpiv20VntDdcAmt = new MSFNumberField();
		cpiv20VntDdcAmt.setReadOnly(true);
		cpiv20VntDdcAmt.setFieldLabel("공제액");
		cpiv20VntDdcAmt.setAllowDecimals(true); 
		cpiv20VntDdcAmt.setPropertyEditorType(Long.class); 
		cpiv20VntDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2522.add(cpiv20VntDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_2522);
		
		
		
		LayoutContainer layoutContainer_24821 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_24821.setLayout(frmlytSch);

		cpiv20AsctTwoDdcAmt = new MSFNumberField();
		cpiv20AsctTwoDdcAmt.setReadOnly(true);
		cpiv20AsctTwoDdcAmt.setFieldLabel("공제액");
		cpiv20AsctTwoDdcAmt.setAllowDecimals(true); 
		cpiv20AsctTwoDdcAmt.setPropertyEditorType(Long.class); 
		cpiv20AsctTwoDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_24821.add(cpiv20AsctTwoDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_24821);
		
		//2022연말정산_수정 : 19 -> 20 -------------------------------------------
		
		
		//----------------------- 2021 공제액  -------------------------------------------------
		
		
		// 기타공제_투자조합출자소득공제_2020년 공제액
		LayoutContainer layoutContainer_248a = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_248a.setLayout(frmlytSch);

		//2022연말정산_수정 : 20 -> 21 -------------------------------------------
		
		cpiv21AsctDdcAmt = new   MSFNumberField();
		cpiv21AsctDdcAmt.setFieldLabel("공제액");
		cpiv21AsctDdcAmt.setReadOnly(true);
		cpiv21AsctDdcAmt.setAllowDecimals(true); 
		cpiv21AsctDdcAmt.setPropertyEditorType(Long.class); 
		cpiv21AsctDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_248a.add(cpiv21AsctDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_248a);

		// 기타공제_투자조합출자소득공제_2021년이후 공제액
		LayoutContainer layoutContainer_2522a = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2522a.setLayout(frmlytSch);

		cpiv21VntDdcAmt = new MSFNumberField();
		cpiv21VntDdcAmt.setReadOnly(true);
		cpiv21VntDdcAmt.setFieldLabel("공제액");
		cpiv21VntDdcAmt.setAllowDecimals(true); 
		cpiv21VntDdcAmt.setPropertyEditorType(Long.class); 
		cpiv21VntDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2522a.add(cpiv21VntDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_2522a);
		
		
		LayoutContainer layoutContainer_24821a = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_24821a.setLayout(frmlytSch);

		cpiv21AsctTwoDdcAmt = new   MSFNumberField();
		cpiv21AsctTwoDdcAmt.setFieldLabel("공제액");
		cpiv21AsctTwoDdcAmt.setReadOnly(true);
		cpiv21AsctTwoDdcAmt.setAllowDecimals(true); 
		cpiv21AsctTwoDdcAmt.setPropertyEditorType(Long.class); 
		cpiv21AsctTwoDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_24821a.add(cpiv21AsctTwoDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_24821a);
		
		//2022연말정산_수정 : 20 -> 21 -------------------------------------------

	//-----------------------2021 공제액 ------------------------------------------------------	
		
		
	//----------------------- 2022 공제액  -------------------------------------------------
		
		// 기타공제_투자조합출자소득공제_2022년 공제액
		LayoutContainer layoutContainer_248b = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_248b.setLayout(frmlytSch);
		
		//2022연말정산_수정 : 21 -> 22 -------------------------------------------

		cpiv22AsctDdcAmt = new   MSFNumberField();
		cpiv22AsctDdcAmt.setFieldLabel("공제액");
		cpiv22AsctDdcAmt.setReadOnly(true);
		cpiv22AsctDdcAmt.setAllowDecimals(true); 
		cpiv22AsctDdcAmt.setPropertyEditorType(Long.class); 
		cpiv22AsctDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_248b.add(cpiv22AsctDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_248b);

		// 기타공제_투자조합출자소득공제_2022년이후 공제액
		LayoutContainer layoutContainer_2522b = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2522b.setLayout(frmlytSch);

		cpiv22VntDdcAmt = new MSFNumberField();
		cpiv22VntDdcAmt.setReadOnly(true);
		cpiv22VntDdcAmt.setFieldLabel("공제액");
		cpiv22VntDdcAmt.setAllowDecimals(true); 
		cpiv22VntDdcAmt.setPropertyEditorType(Long.class); 
		cpiv22VntDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_2522b.add(cpiv22VntDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_2522b);
		
		
		
		LayoutContainer layoutContainer_24821b = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_24821b.setLayout(frmlytSch);

		cpiv22AsctTwoDdcAmt = new   MSFNumberField();
		cpiv22AsctTwoDdcAmt.setFieldLabel("공제액");
		cpiv22AsctTwoDdcAmt.setReadOnly(true);
		cpiv22AsctTwoDdcAmt.setAllowDecimals(true); 
		cpiv22AsctTwoDdcAmt.setPropertyEditorType(Long.class); 
		cpiv22AsctTwoDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_24821b.add(cpiv22AsctTwoDdcAmt, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_24821b);
		
		//2022연말정산_수정 : 21 -> 22 -------------------------------------------
		
	//-----------------------2022 공제액 ------------------------------------------------------		
		

		// 공제액계
		LayoutContainer layoutContainer_249 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_249.setLayout(frmlytSch);

		ivcpInvmDdcAmtSum = new    MSFNumberField();
		ivcpInvmDdcAmtSum.setReadOnly(true);
		ivcpInvmDdcAmtSum.setFieldLabel("공제액계");
		ivcpInvmDdcAmtSum.setAllowDecimals(true); 
		ivcpInvmDdcAmtSum.setPropertyEditorType(Long.class); 
		ivcpInvmDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_249.add(ivcpInvmDdcAmtSum, new FormData("100%"));
		layoutContainer_225.add(layoutContainer_249);
		  
		  
		layoutContainer_223.add(layoutContainer_225, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		fldstNewFieldset_17.add(layoutContainer_223);
		
		layoutContainer_222.add(fldstNewFieldset_17);
		layoutContainer_13.add(layoutContainer_222);
		
		// 신용카드등사용액소득공제
		LayoutContainer layoutContainer_201 = new LayoutContainer();

		FieldSet fldstNewFieldset_16 = new FieldSet();

		LayoutContainer layoutContainer_221 = new LayoutContainer();

		LayoutContainer layoutContainer_226 = new LayoutContainer();
		layoutContainer_226.setLayout(new ColumnLayout());

		// 신용카드
		LayoutContainer layoutContainer_229 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_229.setLayout(frmlytSch);

		crdcUseAmt = new MSFNumberField();
		crdcUseAmt.setFieldLabel("신용카드");
		crdcUseAmt.setAllowDecimals(true); 
		crdcUseAmt.setPropertyEditorType(Long.class); 
		crdcUseAmt.setFormat(NumberFormat.getDecimalFormat());
		crdcUseAmt.setReadOnly(true);
		
		layoutContainer_229.add(crdcUseAmt, new FormData("100%"));
		layoutContainer_226.add(layoutContainer_229, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		// 직불카드등
		LayoutContainer layoutContainer_230 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_230.setLayout(frmlytSch);

		drtpCardUseAmt = new MSFNumberField();
		drtpCardUseAmt.setFieldLabel("직불카드등");
		drtpCardUseAmt.setAllowDecimals(true); 
		drtpCardUseAmt.setPropertyEditorType(Long.class); 
		drtpCardUseAmt.setFormat(NumberFormat.getDecimalFormat());
		drtpCardUseAmt.setReadOnly(true);
		
		layoutContainer_230.add(drtpCardUseAmt, new FormData("100%"));
		layoutContainer_226.add(layoutContainer_230, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		// 현금영수증
		LayoutContainer layoutContainer_231 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_231.setLayout(frmlytSch);

		cshptUseAmt = new MSFNumberField();
		cshptUseAmt.setFieldLabel("현금영수증");
		cshptUseAmt.setAllowDecimals(true); 
		cshptUseAmt.setPropertyEditorType(Long.class); 
		cshptUseAmt.setFormat(NumberFormat.getDecimalFormat());
		cshptUseAmt.setReadOnly(true);
		
		layoutContainer_231.add(cshptUseAmt, new FormData("100%"));
		layoutContainer_226.add(layoutContainer_231, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		
		
		layoutContainer_221.add(layoutContainer_226);

		
	
		LayoutContainer layoutContainer_227 = new LayoutContainer();
		layoutContainer_227.setLayout(new ColumnLayout());

		// 도서구입
		LayoutContainer layoutContainer_2331 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2331.setLayout(frmlytSch);

		bookShowAmt = new MSFNumberField();
		bookShowAmt.setFieldLabel("도서공연");
		bookShowAmt.setAllowDecimals(true); 
		bookShowAmt.setPropertyEditorType(Long.class); 
		bookShowAmt.setFormat(NumberFormat.getDecimalFormat());
		bookShowAmt.setReadOnly(true);
		
		layoutContainer_2331.add(bookShowAmt, new FormData("100%"));
		layoutContainer_227.add(layoutContainer_2331, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		// 전통시장
		LayoutContainer layoutContainer_232 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_232.setLayout(frmlytSch);

		tdmrUseAmt = new MSFNumberField();
		tdmrUseAmt.setFieldLabel("전통시장");
		tdmrUseAmt.setAllowDecimals(true); 
		tdmrUseAmt.setPropertyEditorType(Long.class); 
		tdmrUseAmt.setFormat(NumberFormat.getDecimalFormat());
		tdmrUseAmt.setReadOnly(true);
		
		layoutContainer_232.add(tdmrUseAmt, new FormData("100%"));
		layoutContainer_227.add(layoutContainer_232, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		// 대중교통
		LayoutContainer layoutContainer_233 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_233.setLayout(frmlytSch);

		pbtUseAmt = new MSFNumberField();
		pbtUseAmt.setFieldLabel("대중교통");
		pbtUseAmt.setAllowDecimals(true); 
		pbtUseAmt.setPropertyEditorType(Long.class); 
		pbtUseAmt.setFormat(NumberFormat.getDecimalFormat());
		pbtUseAmt.setReadOnly(true);
		
		layoutContainer_233.add(pbtUseAmt, new FormData("100%"));
		layoutContainer_227.add(layoutContainer_233, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));


		layoutContainer_221.add(layoutContainer_227);

		LayoutContainer layoutContainer_228 = new LayoutContainer();
		layoutContainer_228.setLayout(new ColumnLayout());
		

		LayoutContainer layoutContainer_234 = new LayoutContainer();

		// 신용카드등사용금액계
		LayoutContainer layoutContainer_236 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(150);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_236.setLayout(frmlytSch);

		crdcSumUseAmt = new MSFNumberField();
		crdcSumUseAmt.setFieldLabel("신용카드등사용금액계");
		crdcSumUseAmt.setAllowDecimals(true); 
		crdcSumUseAmt.setPropertyEditorType(Long.class); 
		crdcSumUseAmt.setFormat(NumberFormat.getDecimalFormat());
		crdcSumUseAmt.setReadOnly(true);
		
		layoutContainer_236.add(crdcSumUseAmt, new FormData("100%"));
		layoutContainer_234.add(layoutContainer_236);

		// 신용카드등(본인2013년)
//		LayoutContainer layoutContainer_237 = new LayoutContainer();
//
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(150);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_237.setLayout(frmlytSch);
//
////		cardEt13 = new MSFNumberField();
////		cardEt13.setAllowDecimals(true); 
////		cardEt13.setPropertyEditorType(Long.class); 
////		cardEt13.setFormat(NumberFormat.getDecimalFormat());
////		cardEt13.setFieldLabel("신용카드등(본인2013년)");
////		cardEt13.setReadOnly(false);
////		layoutContainer_237.add(cardEt13, new FormData("100%"));
////		
////		layoutContainer_234.add(layoutContainer_237);
////
//		// 신용카드등(본인2014년)
//		LayoutContainer layoutContainer_238 = new LayoutContainer();
//
//		FormLayout frmlytSch95 = new FormLayout();
//		frmlytSch95.setLabelWidth(150);
//		frmlytSch95.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_238.setLayout(frmlytSch95);
//
//		prsCrdcUseAmt1 = new MSFNumberField();
//		prsCrdcUseAmt1.setFieldLabel("신용카드등(본인2014년)");
//		prsCrdcUseAmt1.setAllowDecimals(true); 
//		prsCrdcUseAmt1.setPropertyEditorType(Long.class); 
//		prsCrdcUseAmt1.setFormat(NumberFormat.getDecimalFormat());
//		prsCrdcUseAmt1.setReadOnly(false);
//		layoutContainer_238.add(prsCrdcUseAmt1, new FormData("100%"));
//
//		layoutContainer_234.add(layoutContainer_238);
//		
//		
//		// 신용카드등(본인2015년)
//		LayoutContainer layoutContainer_2015 = new LayoutContainer();
//
//		frmlytSch95 = new FormLayout();
//		frmlytSch95.setLabelWidth(150);
//		frmlytSch95.setLabelAlign(LabelAlign.RIGHT);
//
//		
//		layoutContainer_2015.setLayout(frmlytSch95);
//
//		tyYrPrsCrdcUseAmt = new MSFNumberField();
//		
//		tyYrPrsCrdcUseAmt.setAllowDecimals(true); 
//		tyYrPrsCrdcUseAmt.setPropertyEditorType(Long.class); 
//		tyYrPrsCrdcUseAmt.setFormat(NumberFormat.getDecimalFormat());
//		
//		tyYrPrsCrdcUseAmt.setReadOnly(false);
//		layoutContainer_238.add(tyYrPrsCrdcUseAmt, new FormData("100%"));
//		tyYrPrsCrdcUseAmt.setFieldLabel("신용카드등(본인2015년)");
//		layoutContainer_234.add(layoutContainer_2015);
		  
		layoutContainer_228.add(layoutContainer_234, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		

		LayoutContainer layoutContainer_235 = new LayoutContainer();

		// 신용카드등사용공제액계
		LayoutContainer layoutContainer_239 = new LayoutContainer();

		FormLayout frmlytSch96 = new FormLayout();
		frmlytSch96.setLabelWidth(150);
		frmlytSch96.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_239.setLayout(frmlytSch96);

		rdcSumDdcAmt = new MSFNumberField();
		rdcSumDdcAmt.setFieldLabel("신용카드등사용공제액계");
		rdcSumDdcAmt.setAllowDecimals(true); 
		rdcSumDdcAmt.setPropertyEditorType(Long.class); 
		rdcSumDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		rdcSumDdcAmt.setReadOnly(true);
		
		layoutContainer_239.add(rdcSumDdcAmt, new FormData("100%"));
		layoutContainer_235.add(layoutContainer_239);

//		 추가공제율(본인2013년)
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
//
//		// 추가공제율(본인2014년하)
//		LayoutContainer layoutContainer_241 = new LayoutContainer();
//
//		FormLayout frmlytSch98 = new FormLayout();
//		frmlytSch98.setLabelWidth(150);
//		frmlytSch98.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_241.setLayout(frmlytSch98);
//
//		pyrPrsAddDdcrtUseAmt = new MSFNumberField();
//		
//		pyrPrsAddDdcrtUseAmt.setAllowDecimals(true); 
//		pyrPrsAddDdcrtUseAmt.setPropertyEditorType(Long.class); 
//		pyrPrsAddDdcrtUseAmt.setFormat(NumberFormat.getDecimalFormat());
//		
//		pyrPrsAddDdcrtUseAmt.setReadOnly(false);
//		layoutContainer_241.add(pyrPrsAddDdcrtUseAmt, new FormData("100%"));
//		pyrPrsAddDdcrtUseAmt.setFieldLabel("추가공제율(본인2014년)");
//		layoutContainer_235.add(layoutContainer_241);
//		layoutContainer_241.setBorders(false);
//		
//		
//		// 추가공제율(본인2015년)
//		LayoutContainer layoutContainer_578 = new LayoutContainer();
//
//		frmlytSch98 = new FormLayout();
//		frmlytSch98.setLabelWidth(150);
//		frmlytSch98.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_578.setLayout(frmlytSch98);
//
//		etadD15h = new MSFNumberField();
//		
//		etadD15h.setAllowDecimals(true); 
//		etadD15h.setPropertyEditorType(Long.class); 
//		etadD15h.setFormat(NumberFormat.getDecimalFormat());
//		
//		etadD15h.setReadOnly(false);
//		layoutContainer_241.add(etadD15h, new FormData("100%"));
//		etadD15h.setFieldLabel("추가공제율(본인2015년)");
//		layoutContainer_235.add(layoutContainer_578);
//		layoutContainer_578.setBorders(false);		
//		
//		
//		// 추가공제율(본인2015년하)
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
		
		
		// 추가공제율(본인2014년하)
//		LayoutContainer layoutContainer_241 = new LayoutContainer();
//		FormLayout frmlytSch98 = new FormLayout();
//		frmlytSch98.setLabelWidth(150);
//		frmlytSch98.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_241.setLayout(frmlytSch98);
//
//		pyrPrsAddDdcrtUseAmt = new MSFNumberField();
//		pyrPrsAddDdcrtUseAmt.setFieldLabel("추가공제율(본인2014년)");
//		pyrPrsAddDdcrtUseAmt.setAllowDecimals(true); 
//		pyrPrsAddDdcrtUseAmt.setPropertyEditorType(Long.class); 
//		pyrPrsAddDdcrtUseAmt.setFormat(NumberFormat.getDecimalFormat());
//		
//		pyrPrsAddDdcrtUseAmt.setReadOnly(false);
//		layoutContainer_241.add(pyrPrsAddDdcrtUseAmt, new FormData("100%"));
//		
//		layoutContainer_235.add(layoutContainer_241);
//		
//		
//		// 추가공제율(본인2016년상)
//		LayoutContainer layoutContainer_578 = new LayoutContainer();
//		frmlytSch98 = new FormLayout();
//		frmlytSch98.setLabelWidth(150);
//		frmlytSch98.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_578.setLayout(frmlytSch98);
//
//		tyShfyPrsAddDdcrtUseAmt = new MSFNumberField();
//		tyShfyPrsAddDdcrtUseAmt.setFieldLabel("추가공제율(본인2016년상)");
//		tyShfyPrsAddDdcrtUseAmt.setAllowDecimals(true); 
//		tyShfyPrsAddDdcrtUseAmt.setPropertyEditorType(Long.class); 
//		tyShfyPrsAddDdcrtUseAmt.setFormat(NumberFormat.getDecimalFormat());
//		tyShfyPrsAddDdcrtUseAmt.setReadOnly(false);
//		layoutContainer_578.add(tyShfyPrsAddDdcrtUseAmt, new FormData("100%"));
//		layoutContainer_235.add(layoutContainer_578);
		
		
		layoutContainer_228.add(layoutContainer_235, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_221.add(layoutContainer_228);

		fldstNewFieldset_16.add(layoutContainer_221);

		layoutContainer_201.add(fldstNewFieldset_16);
		fldstNewFieldset_16.setHeadingHtml("신용카드등사용액소득공제");
		layoutContainer_13.add(layoutContainer_201);

		cp01.add(layoutContainer_13);
		//엣지변환
		//layoutContainer_13.setHeight("570");
		//cp01.setHeight("565");
		layoutContainer_13.setHeight("770");
		cp01.setHeight("765");

		return cp01;
	}	
	
	private LayoutContainer yetaData07() {
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "590");
		
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

		emstAsctCntrUseAmt = new MSFNumberField();
		emstAsctCntrUseAmt.setFieldLabel("우리사주조합연출연금액");
		emstAsctCntrUseAmt.setAllowDecimals(true); 
		emstAsctCntrUseAmt.setPropertyEditorType(Long.class); 
		emstAsctCntrUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_133.add(emstAsctCntrUseAmt, new FormData("100%"));
		layoutContainer_131.add(layoutContainer_133);

//		// 우리사주조합기부금
//		LayoutContainer layoutContainer_135 = new LayoutContainer();
//
//		FormLayout frmlytSch51 = new FormLayout();
//		frmlytSch51.setLabelWidth(200);
//		frmlytSch51.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_135.setLayout(frmlytSch51);
//
//		etckUncb = new MSFNumberField();
//		etckUncb.setFieldLabel("우리사주조합기부금");
//		etckUncb.setReadOnly(true);
//		etckUncb.setAllowDecimals(true); 
//		etckUncb.setPropertyEditorType(Long.class); 
//		etckUncb.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_135.add(etckUncb, new FormData("100%"));
//		layoutContainer_131.add(layoutContainer_135);

		// 고용유지중소기업근로자 임금삭감액
		LayoutContainer layoutContainer_136 = new LayoutContainer();

		FormLayout frmlytSch52 = new FormLayout();
		frmlytSch52.setLabelWidth(200);
		frmlytSch52.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_136.setLayout(frmlytSch52);

		empMntnSnmcUseAmt = new MSFNumberField();
		empMntnSnmcUseAmt.setFieldLabel("고용유지중소기업근로자 임금삭감액");
		empMntnSnmcUseAmt.setAllowDecimals(true); 
		empMntnSnmcUseAmt.setPropertyEditorType(Long.class); 
		empMntnSnmcUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_136.add(empMntnSnmcUseAmt, new FormData("100%"));
		layoutContainer_131.add(layoutContainer_136);

		// 목돈안드는전세이자상환액
//		LayoutContainer layoutContainer_137 = new LayoutContainer();
//
//		FormLayout frmlytSch53 = new FormLayout();
//		frmlytSch53.setLabelWidth(200);
//		frmlytSch53.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_137.setLayout(frmlytSch53);
//
//		etgdCtra = new MSFNumberField();
//		etgdCtra.setFieldLabel("목돈안드는전세이자상환액");
//		etgdCtra.setReadOnly(true);
//		etgdCtra.setAllowDecimals(true); 
//		etgdCtra.setPropertyEditorType(Long.class); 
//		etgdCtra.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_137.add(etgdCtra, new FormData("100%"));
//		layoutContainer_131.add(layoutContainer_137);

		// 장기집합투자증권저축 납입금액
		LayoutContainer layoutContainer_138 = new LayoutContainer();

		FormLayout frmlytSch54 = new FormLayout();
		frmlytSch54.setLabelWidth(200);
		frmlytSch54.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_138.setLayout(frmlytSch54);

		ltrmCniSsUseAmt = new MSFNumberField();
		ltrmCniSsUseAmt.setFieldLabel("장기집합투자증권저축 납입금액");
		ltrmCniSsUseAmt.setReadOnly(true);
		ltrmCniSsUseAmt.setAllowDecimals(true); 
		ltrmCniSsUseAmt.setPropertyEditorType(Long.class); 
		ltrmCniSsUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_138.add(ltrmCniSsUseAmt, new FormData("100%"));
		layoutContainer_131.add(layoutContainer_138);

//		// 기타
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
//		etclEttl.setFieldLabel("기타 (");
//		
//		layoutContainer_142.add(etclEttl, new FormData("100%"));
//		layoutContainer_139.add(layoutContainer_142, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
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
//		etclEtam.setFieldLabel(" )");
//		etclEtam.setAllowDecimals(true); 
//		etclEtam.setPropertyEditorType(Long.class); 
//		etclEtam.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_146.add(etclEtam, new FormData("100%"));
//		layoutContainer_139.add(layoutContainer_146, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//
//		layoutContainer_131.add(layoutContainer_139);
//
		layoutContainer_14.add(layoutContainer_131, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
//
		LayoutContainer layoutContainer_132 = new LayoutContainer();

		// 기타공제_우리사주출연금공제 공제액
		LayoutContainer layoutContainer_134 = new LayoutContainer();

		FormLayout frmlytSch57 = new FormLayout();
		frmlytSch57.setLabelWidth(70);
		frmlytSch57.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_134.setLayout(frmlytSch57);

		emstAsctCntrDdcAmt = new MSFNumberField();
		emstAsctCntrDdcAmt.setReadOnly(true);
		emstAsctCntrDdcAmt.setFieldLabel("공제액");
		emstAsctCntrDdcAmt.setAllowDecimals(true); 
		emstAsctCntrDdcAmt.setPropertyEditorType(Long.class); 
		emstAsctCntrDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_134.add(emstAsctCntrDdcAmt, new FormData("100%"));
		layoutContainer_132.add(layoutContainer_134);

		// 기타공제_우리사주조합기부금공제2014이전 공제액
//		LayoutContainer layoutContainer_140 = new LayoutContainer();
//
//		FormLayout frmlytSch58 = new FormLayout();
//		frmlytSch58.setLabelWidth(70);
//		frmlytSch58.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_140.setLayout(frmlytSch58);
//
//		etckUncr = new MSFNumberField();
//		etckUncr.setFieldLabel("공제액");
//		etckUncr.setReadOnly(true);
//		etckUncr.setAllowDecimals(true); 
//		etckUncr.setPropertyEditorType(Long.class); 
//		etckUncr.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_140.add(etckUncr, new FormData("100%"));
//		layoutContainer_132.add(layoutContainer_140);

		//기타공제_고용유지중소기업근로자임금삭감 공제액
		LayoutContainer layoutContainer_141 = new LayoutContainer();

		FormLayout frmlytSch59 = new FormLayout();
		frmlytSch59.setLabelWidth(70);
		frmlytSch59.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_141.setLayout(frmlytSch59);

		empMntnSnmcDdcAmt = new MSFNumberField();
		empMntnSnmcDdcAmt.setFieldLabel("공제액");
		empMntnSnmcDdcAmt.setReadOnly(true);
		empMntnSnmcDdcAmt.setAllowDecimals(true); 
		empMntnSnmcDdcAmt.setPropertyEditorType(Long.class); 
		empMntnSnmcDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_141.add(empMntnSnmcDdcAmt, new FormData("100%"));
		layoutContainer_132.add(layoutContainer_141);

		// 공제액
//		LayoutContainer layoutContainer_143 = new LayoutContainer();
//
//		FormLayout frmlytSch60 = new FormLayout();
//		frmlytSch60.setLabelWidth(70);
//		frmlytSch60.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_143.setLayout(frmlytSch60);
//
//		etgdHtra = new MSFNumberField();
//		etgdHtra.setFieldLabel("공제액");
//		etgdHtra.setReadOnly(true);
//		etgdHtra.setAllowDecimals(true); 
//		etgdHtra.setPropertyEditorType(Long.class); 
//		etgdHtra.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_143.add(etgdHtra, new FormData("100%"));
//		layoutContainer_132.add(layoutContainer_143);

		// 기타공제_장기집합투자증권저축 공제액
		LayoutContainer layoutContainer_144 = new LayoutContainer();

		FormLayout frmlytSch61 = new FormLayout();
		frmlytSch61.setLabelWidth(70);
		frmlytSch61.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_144.setLayout(frmlytSch61);

		ltrmCniSsDdcAmt = new MSFNumberField();
		ltrmCniSsDdcAmt.setFieldLabel("공제액");
		ltrmCniSsDdcAmt.setReadOnly(true);
		ltrmCniSsDdcAmt.setAllowDecimals(true); 
		ltrmCniSsDdcAmt.setPropertyEditorType(Long.class); 
		ltrmCniSsDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_144.add(ltrmCniSsDdcAmt, new FormData("100%"));
		layoutContainer_132.add(layoutContainer_144);

		// 기타 공제액
//		LayoutContainer layoutContainer_145 = new LayoutContainer();
//
//		FormLayout frmlytSch62 = new FormLayout();
//		frmlytSch62.setLabelWidth(70);
//		frmlytSch62.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_145.setLayout(frmlytSch62);
//
//		etcdTsum = new MSFNumberField();
//		etcdTsum.setFieldLabel("공제액");
//		etcdTsum.setReadOnly(true);
//		etcdTsum.setAllowDecimals(true); 
//		etcdTsum.setPropertyEditorType(Long.class); 
//		etcdTsum.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_145.add(etcdTsum, new FormData("100%"));
//		layoutContainer_132.add(layoutContainer_145);

		layoutContainer_14.add(layoutContainer_132, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	
		cp01.add(layoutContainer_14);
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}	
	
	private LayoutContainer yetaData08() {
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "590");
		

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		layoutContainer_15.setBorders(false);

		tabsItemYeta08 = new TabPanel();
		tabsItemYeta08.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				
				//탭선택
				Yeta7300ToYe161010Detail(Yeta7300ToYe161010GridPanel.getCurrentlySelectedItem(), tabsItemYeta08.getSelectedItem().getId());

			}
		});

		// 연금계좌및보험료 tab
		TabItem itemYeta08_1 = new TabItem("연금계좌및보험료");
		itemYeta08_1.setId("itemYeta08_1");
		itemYeta08_1.setBorders(false);
		itemYeta08_1.setHeight("570px");
		tabsItemYeta08.add(itemYeta08_1);
		
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

		sctcHpUseAmt = new MSFNumberField();
		sctcHpUseAmt.setReadOnly(true);
		sctcHpUseAmt.setFieldLabel("과학기술인공제");
		sctcHpUseAmt.setAllowDecimals(true);
		sctcHpUseAmt.setPropertyEditorType(Long.class);
		sctcHpUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_338.add(sctcHpUseAmt, new FormData("100%"));
		layoutContainer_335.add(layoutContainer_338, new FormData("100%"));

		// 근로자퇴직보장법
		LayoutContainer layoutContainer_339 = new LayoutContainer();

		FormLayout frmlytSch160 = new FormLayout();
		frmlytSch160.setLabelWidth(110);
		frmlytSch160.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_339.setLayout(frmlytSch160);

		rtpnUseAmt = new MSFNumberField();
		rtpnUseAmt.setReadOnly(true);
		rtpnUseAmt.setFieldLabel("근로자퇴직보장법");
		rtpnUseAmt.setAllowDecimals(true); 
		rtpnUseAmt.setPropertyEditorType(Long.class); 
		rtpnUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_339.add(rtpnUseAmt, new FormData("100%"));
		layoutContainer_335.add(layoutContainer_339, new FormData("100%"));
		
		
		//2021연말정산_추가
		LayoutContainer layoutContainer_3391 = new LayoutContainer();

		FormLayout frmlytSch1601 = new FormLayout();
		frmlytSch1601.setLabelWidth(110);
		frmlytSch1601.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_3391.setLayout(frmlytSch1601);

		rtpnIsaUseAmt = new MSFNumberField();
		rtpnIsaUseAmt.setReadOnly(true);
		rtpnIsaUseAmt.setFieldLabel("퇴직연금ISA");
		rtpnIsaUseAmt.setAllowDecimals(true); 
		rtpnIsaUseAmt.setPropertyEditorType(Long.class); 
		rtpnIsaUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_3391.add(rtpnIsaUseAmt, new FormData("100%"));
		layoutContainer_335.add(layoutContainer_3391, new FormData("100%"));
		
		

		// 연금저축계좌
		LayoutContainer layoutContainer_340 = new LayoutContainer();

		FormLayout frmlytSch161 = new FormLayout();
		frmlytSch161.setLabelWidth(110);
		frmlytSch161.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_340.setLayout(frmlytSch161);

		pnsnSvngUseAmt = new MSFNumberField();
		pnsnSvngUseAmt.setReadOnly(true);
		pnsnSvngUseAmt.setFieldLabel("연금저축계좌");
		pnsnSvngUseAmt.setAllowDecimals(true); 
		pnsnSvngUseAmt.setPropertyEditorType(Long.class); 
		pnsnSvngUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_340.add(pnsnSvngUseAmt, new FormData("100%"));
		layoutContainer_335.add(layoutContainer_340, new FormData("100%"));
		
		
		
		//2021연말정산_추가
		LayoutContainer layoutContainer_3401 = new LayoutContainer();

		FormLayout frmlytSch1611 = new FormLayout();
		frmlytSch1611.setLabelWidth(110);
		frmlytSch1611.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_3401.setLayout(frmlytSch1611);

		pnsnSvngIsaUseAmt = new MSFNumberField();
		pnsnSvngIsaUseAmt.setReadOnly(true);
		pnsnSvngIsaUseAmt.setFieldLabel("연금저축ISA");
		pnsnSvngIsaUseAmt.setAllowDecimals(true); 
		pnsnSvngIsaUseAmt.setPropertyEditorType(Long.class); 
		pnsnSvngIsaUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_3401.add(pnsnSvngIsaUseAmt, new FormData("100%"));
		layoutContainer_335.add(layoutContainer_3401, new FormData("100%"));
		
		
		

		// 연금계좌계
		LayoutContainer layoutContainer_341 = new LayoutContainer();

		FormLayout frmlytSch162 = new FormLayout();
		frmlytSch162.setLabelWidth(110);
		frmlytSch162.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_341.setLayout(frmlytSch162);

		pnsnAccUseAmtSum = new MSFNumberField();
		pnsnAccUseAmtSum.setReadOnly(true);
		pnsnAccUseAmtSum.setFieldLabel("연금계좌계");
		pnsnAccUseAmtSum.setAllowDecimals(true); 
		pnsnAccUseAmtSum.setPropertyEditorType(Long.class); 
		pnsnAccUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_341.add(pnsnAccUseAmtSum, new FormData("100%"));
		layoutContainer_335.add(layoutContainer_341, new FormData("100%"));

		layoutContainer_334.add(layoutContainer_335, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

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
		
		sctcHpDdcTrgtAmt = new MSFNumberField();
		sctcHpDdcTrgtAmt.setFieldLabel("공제대상");
		sctcHpDdcTrgtAmt.setReadOnly(true);
		sctcHpDdcTrgtAmt.setAllowDecimals(true); 
		sctcHpDdcTrgtAmt.setPropertyEditorType(Long.class); 
		sctcHpDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_342.add(sctcHpDdcTrgtAmt, new FormData("100%"));
		layoutContainer_336.add(layoutContainer_342, new FormData("100%"));

		// 주근무지_퇴직연금근로자퇴직급여보장대상금액 공제대상
		LayoutContainer layoutContainer_343 = new LayoutContainer();

		FormLayout frmlytSch164 = new FormLayout();
		frmlytSch164.setLabelWidth(70);
		frmlytSch164.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_343.setLayout(frmlytSch164);

		rtpnDdcTrgtAmt = new MSFNumberField();
		rtpnDdcTrgtAmt.setFieldLabel("공제대상");
		rtpnDdcTrgtAmt.setReadOnly(true);
		rtpnDdcTrgtAmt.setAllowDecimals(true); 
		rtpnDdcTrgtAmt.setPropertyEditorType(Long.class); 
		rtpnDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_343.add(rtpnDdcTrgtAmt, new FormData("100%"));
		layoutContainer_336.add(layoutContainer_343, new FormData("100%"));
		
		
		//2021연말정산_추가
				LayoutContainer layoutContainer_3431 = new LayoutContainer();

				FormLayout frmlytSch1641 = new FormLayout();
				frmlytSch1641.setLabelWidth(70);
				frmlytSch1641.setLabelAlign(LabelAlign.RIGHT);

				layoutContainer_3431.setLayout(frmlytSch1641);

				rtpnDdcIsaTrgtAmt = new MSFNumberField();
				rtpnDdcIsaTrgtAmt.setFieldLabel("공제대상");
				rtpnDdcIsaTrgtAmt.setReadOnly(true);
				rtpnDdcIsaTrgtAmt.setAllowDecimals(true); 
				rtpnDdcIsaTrgtAmt.setPropertyEditorType(Long.class); 
				rtpnDdcIsaTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
				
				layoutContainer_3431.add(rtpnDdcIsaTrgtAmt, new FormData("100%"));
				layoutContainer_336.add(layoutContainer_3431, new FormData("100%"));
		

		// 주근무지_연금계좌저축공제대상금액 공제대상
		LayoutContainer layoutContainer_344 = new LayoutContainer();

		FormLayout frmlytSch165 = new FormLayout();
		frmlytSch165.setLabelWidth(70);
		frmlytSch165.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_344.setLayout(frmlytSch165);

		pnsnSvngDdcTrgtAmt = new MSFNumberField();
		pnsnSvngDdcTrgtAmt.setFieldLabel("공제대상");
		pnsnSvngDdcTrgtAmt.setReadOnly(true);
		pnsnSvngDdcTrgtAmt.setAllowDecimals(true); 
		pnsnSvngDdcTrgtAmt.setPropertyEditorType(Long.class); 
		pnsnSvngDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_344.add(pnsnSvngDdcTrgtAmt, new FormData("100%"));
		layoutContainer_336.add(layoutContainer_344, new FormData("100%"));
		
		
		//2021연말정산_추가
		LayoutContainer layoutContainer_3441 = new LayoutContainer();

		FormLayout frmlytSch1651 = new FormLayout();
		frmlytSch1651.setLabelWidth(70);
		frmlytSch1651.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_3441.setLayout(frmlytSch1651);

		pnsnSvngDdcIsaTrgtAmt = new MSFNumberField();
		pnsnSvngDdcIsaTrgtAmt.setFieldLabel("공제대상");
		pnsnSvngDdcIsaTrgtAmt.setReadOnly(true);
		pnsnSvngDdcIsaTrgtAmt.setAllowDecimals(true); 
		pnsnSvngDdcIsaTrgtAmt.setPropertyEditorType(Long.class); 
		pnsnSvngDdcIsaTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_3441.add(pnsnSvngDdcIsaTrgtAmt, new FormData("100%"));
		layoutContainer_336.add(layoutContainer_3441, new FormData("100%"));
		
		
		

		//연금계좌공제대상금액 공제대상
		LayoutContainer layoutContainer_345 = new LayoutContainer();

		FormLayout frmlytSch166 = new FormLayout();
		frmlytSch166.setLabelWidth(70);
		frmlytSch166.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_345.setLayout(frmlytSch166);

		pnsnAccDdcTrgtAmtSum = new MSFNumberField();
		pnsnAccDdcTrgtAmtSum.setFieldLabel("공제대상");
		pnsnAccDdcTrgtAmtSum.setReadOnly(true);
		pnsnAccDdcTrgtAmtSum.setAllowDecimals(true); 
		pnsnAccDdcTrgtAmtSum.setPropertyEditorType(Long.class); 
		pnsnAccDdcTrgtAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_345.add(pnsnAccDdcTrgtAmtSum, new FormData("100%"));
		layoutContainer_336.add(layoutContainer_345, new FormData("100%"));

		layoutContainer_334.add(layoutContainer_336,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		LayoutContainer layoutContainer_337 = new LayoutContainer();
		FormLayout  frmlytSch167 = new FormLayout();
		frmlytSch167.setLabelWidth(70);
		frmlytSch167.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_337.setLayout(frmlytSch167);
		
		// 주근무지_퇴직연금과학기술인공제액 공제세액
		LayoutContainer layoutContainer_346 = new LayoutContainer();
		frmlytSch167 = new FormLayout();
		frmlytSch167.setLabelWidth(70);
		frmlytSch167.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_346.setLayout(frmlytSch167);

		sctcHpDdcAmt = new MSFNumberField();
		sctcHpDdcAmt.setFieldLabel("공제세액");
		sctcHpDdcAmt.setReadOnly(true);
		sctcHpDdcAmt.setAllowDecimals(true);
		sctcHpDdcAmt.setPropertyEditorType(Long.class);
		sctcHpDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_346.add(sctcHpDdcAmt, new FormData("100%"));
		layoutContainer_337.add(layoutContainer_346, new FormData("100%"));

		// 주근무지_퇴직연금근로자퇴직급여보장법공제액 공제세액
		LayoutContainer layoutContainer_347 = new LayoutContainer();

		FormLayout frmlytSch168 = new FormLayout();
		frmlytSch168.setLabelWidth(70);
		frmlytSch168.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_347.setLayout(frmlytSch168);

		rtpnDdcAmt = new MSFNumberField();
		rtpnDdcAmt.setFieldLabel("공제세액");
		rtpnDdcAmt.setReadOnly(true);
		rtpnDdcAmt.setAllowDecimals(true); 
		rtpnDdcAmt.setPropertyEditorType(Long.class); 
		rtpnDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_347.add(rtpnDdcAmt, new FormData("100%"));
		layoutContainer_337.add(layoutContainer_347, new FormData("100%"));
		
		//2021연말정산_추가
		LayoutContainer layoutContainer_3471 = new LayoutContainer();

		FormLayout frmlytSch1681 = new FormLayout();
		frmlytSch1681.setLabelWidth(70);
		frmlytSch1681.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_3471.setLayout(frmlytSch1681);

		rtpnDdcIsaAmt = new MSFNumberField();
		rtpnDdcIsaAmt.setFieldLabel("공제세액");
		rtpnDdcIsaAmt.setReadOnly(true);
		rtpnDdcIsaAmt.setAllowDecimals(true); 
		rtpnDdcIsaAmt.setPropertyEditorType(Long.class); 
		rtpnDdcIsaAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_3471.add(rtpnDdcIsaAmt, new FormData("100%"));
		layoutContainer_337.add(layoutContainer_3471, new FormData("100%"));
		
		

		// 주근무지_퇴직연금연금계좌저축공제 공제세액
		LayoutContainer layoutContainer_348 = new LayoutContainer();

		FormLayout frmlytSch169 = new FormLayout();
		frmlytSch169.setLabelWidth(70);
		frmlytSch169.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_348.setLayout(frmlytSch169);

		pnsnSvngDdcAmt = new MSFNumberField();
		pnsnSvngDdcAmt.setFieldLabel("공제세액");
		pnsnSvngDdcAmt.setReadOnly(true);
		pnsnSvngDdcAmt.setAllowDecimals(true); 
		pnsnSvngDdcAmt.setPropertyEditorType(Long.class); 
		pnsnSvngDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_348.add(pnsnSvngDdcAmt, new FormData("100%"));
		layoutContainer_337.add(layoutContainer_348, new FormData("100%"));
		
		
		//2021연말정산_추가
		LayoutContainer layoutContainer_3481 = new LayoutContainer();

		FormLayout frmlytSch1691 = new FormLayout();
		frmlytSch1691.setLabelWidth(70);
		frmlytSch1691.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_3481.setLayout(frmlytSch1691);

		pnsnSvngDdcIsaAmt = new MSFNumberField();
		pnsnSvngDdcIsaAmt.setFieldLabel("공제세액");
		pnsnSvngDdcIsaAmt.setReadOnly(true);
		pnsnSvngDdcIsaAmt.setAllowDecimals(true); 
		pnsnSvngDdcIsaAmt.setPropertyEditorType(Long.class); 
		pnsnSvngDdcIsaAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_3481.add(pnsnSvngDdcIsaAmt, new FormData("100%"));
		layoutContainer_337.add(layoutContainer_3481, new FormData("100%"));
		

		//연금계좌세액공제계 공제세액
		LayoutContainer layoutContainer_349 = new LayoutContainer();

		FormLayout frmlytSch0 = new FormLayout();
		frmlytSch0.setLabelWidth(70);
		frmlytSch0.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_349.setLayout(frmlytSch0);

		pnsnAccDdcAmtSum = new MSFNumberField();
		pnsnAccDdcAmtSum.setReadOnly(true);
		pnsnAccDdcAmtSum.setFieldLabel("공제세액");
		pnsnAccDdcAmtSum.setAllowDecimals(true); 
		pnsnAccDdcAmtSum.setPropertyEditorType(Long.class); 
		pnsnAccDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_349.add(pnsnAccDdcAmtSum, new FormData("100%"));
		layoutContainer_337.add(layoutContainer_349, new FormData("100%"));

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

		cvrgInscUseAmt = new MSFNumberField();
		cvrgInscUseAmt.setFieldLabel("보험료금액");
		cvrgInscUseAmt.setAllowDecimals(true);
		cvrgInscUseAmt.setPropertyEditorType(Long.class);
		cvrgInscUseAmt.setFormat(NumberFormat.getDecimalFormat());

		layoutContainer_331.add(cvrgInscUseAmt, new FormData("100%"));
		layoutContainer_330.add(layoutContainer_331, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		// 특별공제_일반보장성보험료 공제대상금액 공제대상
		LayoutContainer layoutContainer_332 = new LayoutContainer();

		FormLayout frmlytSch157 = new FormLayout();
		frmlytSch157.setLabelWidth(70);
		frmlytSch157.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_332.setLayout(frmlytSch157);

		cvrgInscDdcTrgtAmt2 = new MSFNumberField();
		cvrgInscDdcTrgtAmt2.setReadOnly(true);
		cvrgInscDdcTrgtAmt2.setFieldLabel("공제대상");
		cvrgInscDdcTrgtAmt2.setAllowDecimals(true); 
		cvrgInscDdcTrgtAmt2.setPropertyEditorType(Long.class); 
		cvrgInscDdcTrgtAmt2.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_332.add(cvrgInscDdcTrgtAmt2, new FormData("100%"));
		layoutContainer_330.add(layoutContainer_332, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		// 특별공제_일반보장성보험료 공제액 세액공제
		LayoutContainer layoutContainer_333 = new LayoutContainer();

		FormLayout frmlytSch158 = new FormLayout();
		frmlytSch158.setLabelWidth(70);
		frmlytSch158.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_333.setLayout(frmlytSch158);

		cvrgInscDdcAmt = new MSFNumberField();
		cvrgInscDdcAmt.setReadOnly(true);
		cvrgInscDdcAmt.setFieldLabel("세액공제");
		cvrgInscDdcAmt.setAllowDecimals(true); 
		cvrgInscDdcAmt.setPropertyEditorType(Long.class); 
		cvrgInscDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_333.add(cvrgInscDdcAmt, new FormData("100%"));
		layoutContainer_330.add(layoutContainer_333, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

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

		// 특별공제_장애인전용보험료
		LayoutContainer layoutContainer_327 = new LayoutContainer();

		frmlytSch153 = new FormLayout();
		frmlytSch153.setLabelWidth(110);
		frmlytSch153.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_327.setLayout(frmlytSch153);

		dsbrEuCvrgUseAmt = new MSFNumberField();
		dsbrEuCvrgUseAmt.setFieldLabel("보험료금액");
		dsbrEuCvrgUseAmt.setAllowDecimals(true); 
		dsbrEuCvrgUseAmt.setPropertyEditorType(Long.class); 
		dsbrEuCvrgUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_327.add(dsbrEuCvrgUseAmt, new FormData("100%"));
		layoutContainer_326.add(layoutContainer_327, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		//특별공제_장애인보장성대상금액 공제대상
		LayoutContainer layoutContainer_328 = new LayoutContainer();

		FormLayout frmlytSch154 = new FormLayout();
		frmlytSch154.setLabelWidth(70);
		frmlytSch154.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_328.setLayout(frmlytSch154);

		dsbrEuCvrgDdcTrgtAmt = new MSFNumberField();
		dsbrEuCvrgDdcTrgtAmt.setReadOnly(true);
		dsbrEuCvrgDdcTrgtAmt.setFieldLabel("공제대상");
		dsbrEuCvrgDdcTrgtAmt.setAllowDecimals(true); 
		dsbrEuCvrgDdcTrgtAmt.setPropertyEditorType(Long.class); 
		dsbrEuCvrgDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_328.add(dsbrEuCvrgDdcTrgtAmt, new FormData("100%"));
		layoutContainer_326.add(layoutContainer_328, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		// 특별공제_장애인보장성대상금액 공제액 세액공제
		LayoutContainer layoutContainer_329 = new LayoutContainer();

		FormLayout frmlytSch155 = new FormLayout();
		frmlytSch155.setLabelWidth(70);
		frmlytSch155.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_329.setLayout(frmlytSch155);

		dsbrEuCvrgDdcAmt = new MSFNumberField();
		dsbrEuCvrgDdcAmt.setReadOnly(true);
		dsbrEuCvrgDdcAmt.setFieldLabel("세액공제");
		dsbrEuCvrgDdcAmt.setAllowDecimals(true); 
		dsbrEuCvrgDdcAmt.setPropertyEditorType(Long.class); 
		dsbrEuCvrgDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_329.add(dsbrEuCvrgDdcAmt, new FormData("100%"));
		layoutContainer_326.add(layoutContainer_329, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

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

		infeePymUseAmtSum = new MSFNumberField();
		infeePymUseAmtSum.setReadOnly(true);
		infeePymUseAmtSum.setFieldLabel("보험료계");
		infeePymUseAmtSum.setAllowDecimals(true); 
		infeePymUseAmtSum.setPropertyEditorType(Long.class); 
		infeePymUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_323.add(infeePymUseAmtSum, new FormData("100%"));
		layoutContainer_322.add(layoutContainer_323, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		// 특별공제_보장성보험료대상금액
		LayoutContainer layoutContainer_324 = new LayoutContainer();

		FormLayout frmlytSch151 = new FormLayout();
		frmlytSch151.setLabelWidth(70);
		frmlytSch151.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_324.setLayout(frmlytSch151);

		infeePymDdcTrgtAmtSum = new MSFNumberField();
		infeePymDdcTrgtAmtSum.setReadOnly(true);
		infeePymDdcTrgtAmtSum.setFieldLabel("공제대상");
		infeePymDdcTrgtAmtSum.setAllowDecimals(true); 
		infeePymDdcTrgtAmtSum.setPropertyEditorType(Long.class); 
		infeePymDdcTrgtAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_324.add(infeePymDdcTrgtAmtSum, new FormData("100%"));
		layoutContainer_322.add(layoutContainer_324, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		//특별공제_보장성보혐료세액공제금액
		LayoutContainer layoutContainer_325 = new LayoutContainer();

		FormLayout frmlytSch152 = new FormLayout();
		frmlytSch152.setLabelWidth(70);
		frmlytSch152.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_325.setLayout(frmlytSch152);

		infeePymDdcAmtSum = new MSFNumberField();
		infeePymDdcAmtSum.setReadOnly(true);
		infeePymDdcAmtSum.setFieldLabel("공제세액");
		infeePymDdcAmtSum.setAllowDecimals(true); 
		infeePymDdcAmtSum.setPropertyEditorType(Long.class); 
		infeePymDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_325.add(infeePymDdcAmtSum, new FormData("100%"));
		layoutContainer_322.add(layoutContainer_325, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		layoutContainer_318.add(layoutContainer_322, new FormData("100%"));

		cntntpnlNewContentpanel_3.add(layoutContainer_318);
		itemYeta08_1.add(cntntpnlNewContentpanel_3);
		cntntpnlNewContentpanel_3.setHeight("355px");

		// 의료비tab
		TabItem itemYeta08_2 = new TabItem("의료비");
		itemYeta08_2.setId("itemYeta08_2");
		itemYeta08_2.setBorders(true);
		tabsItemYeta08.add(itemYeta08_2);
		itemYeta08_2.setHeight("570px");

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
				YetaP73002 yetaP23002Form = new YetaP73002(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwYeta73002 = new MSFFormWindows("의료비내역등록", yetaP23002Form, "닫기", "820px", "710px", true);
				msFwYeta73002.show();
				yetaP23002Form.setMSFFormWindows(msFwYeta73002);
				
				msFwYeta73002.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			getItemYeta08();
		    		}
				});

				funcSetPopUpRecord();
				yetaP23002Form.bind(ppRecord); 
			}
		});		
		
		layoutContainer_351.add(buttonBar_3);
		fldstNewFieldset_29.add(layoutContainer_351);
		layoutContainer_351.setBorders(false);

		FieldSet fldstNewFieldset_30 = new FieldSet();
		fldstNewFieldset_30.setHeadingHtml("난임시술비 의료비");

		LayoutContainer layoutContainer_377 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_377.setLayout(new ColumnLayout());

		// 지출금액
		LayoutContainer layoutContainer_378 = new LayoutContainer();

		FormLayout frmlytSch200 = new FormLayout();
		frmlytSch200.setLabelWidth(70);
		frmlytSch200.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_378.setLayout(frmlytSch200);

		mdxpsSftSprcdUseAmt = new MSFNumberField();
		mdxpsSftSprcdUseAmt.setReadOnly(true);
		mdxpsSftSprcdUseAmt.setFieldLabel("지출금액");
		mdxpsSftSprcdUseAmt.setAllowDecimals(true); 
		mdxpsSftSprcdUseAmt.setPropertyEditorType(Long.class); 
		mdxpsSftSprcdUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_378.add(mdxpsSftSprcdUseAmt, new FormData("100%"));
		layoutContainer_377.add(layoutContainer_378, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

		// 본인의료비공제대상금액
		LayoutContainer layoutContainer_379 = new LayoutContainer();

		FormLayout frmlytSch201 = new FormLayout();
		frmlytSch201.setLabelWidth(70);
		frmlytSch201.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_379.setLayout(frmlytSch201);

		mdxpsSftSprcdDdcTrgtAmt = new MSFNumberField();
		mdxpsSftSprcdDdcTrgtAmt.setReadOnly(true);
		mdxpsSftSprcdDdcTrgtAmt.setFieldLabel("공제대상");
		mdxpsSftSprcdDdcTrgtAmt.setAllowDecimals(true); 
		mdxpsSftSprcdDdcTrgtAmt.setPropertyEditorType(Long.class); 
		mdxpsSftSprcdDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_379.add(mdxpsSftSprcdDdcTrgtAmt, new FormData("100%"));
		layoutContainer_377.add(layoutContainer_379, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		//특별공제_의료비_본인 세액공제
		LayoutContainer layoutContainer_380 = new LayoutContainer();

		FormLayout frmlytSch202 = new FormLayout();
		frmlytSch202.setLabelWidth(70);
		frmlytSch202.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_380.setLayout(frmlytSch202);

		mdxpsSftSprcdDdcAmt = new MSFNumberField();
		mdxpsSftSprcdDdcAmt.setReadOnly(true);
		mdxpsSftSprcdDdcAmt.setFieldLabel("세액공제");
		mdxpsSftSprcdDdcAmt.setAllowDecimals(true); 
		mdxpsSftSprcdDdcAmt.setPropertyEditorType(Long.class); 
		mdxpsSftSprcdDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_380.add(mdxpsSftSprcdDdcAmt, new FormData("100%"));
		layoutContainer_377.add(layoutContainer_380, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		fldstNewFieldset_30.add(layoutContainer_377);
		fldstNewFieldset_29.add(fldstNewFieldset_30);


		FieldSet fldstNewFieldset_31 = new FieldSet();
		fldstNewFieldset_31.setHeadingHtml("본인.65세이상자.장애인 의료비");

		LayoutContainer layoutContainer_381 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_381.setLayout(new ColumnLayout());

		// 지출금액
		LayoutContainer layoutContainer_382 = new LayoutContainer();

		FormLayout frmlytSch203 = new FormLayout();
		frmlytSch203.setLabelWidth(70);
		frmlytSch203.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_382.setLayout(frmlytSch203);

		mdxpsPrsUseAmt = new MSFNumberField();
		mdxpsPrsUseAmt.setReadOnly(true);
		mdxpsPrsUseAmt.setFieldLabel("지출금액");
		mdxpsPrsUseAmt.setAllowDecimals(true); 
		mdxpsPrsUseAmt.setPropertyEditorType(Long.class); 
		mdxpsPrsUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_382.add(mdxpsPrsUseAmt, new FormData("100%"));
		layoutContainer_381.add(layoutContainer_382, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

		// 65세이상자의료비공제대상금액 
		LayoutContainer layoutContainer_383 = new LayoutContainer();

		FormLayout frmlytSch204 = new FormLayout();
		frmlytSch204.setLabelWidth(70);
		frmlytSch204.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_383.setLayout(frmlytSch204);

		mdxpsPrsDdcTrgtAmt = new MSFNumberField();
		mdxpsPrsDdcTrgtAmt.setReadOnly(true);
		mdxpsPrsDdcTrgtAmt.setFieldLabel("공제대상");
		mdxpsPrsDdcTrgtAmt.setAllowDecimals(true); 
		mdxpsPrsDdcTrgtAmt.setPropertyEditorType(Long.class); 
		mdxpsPrsDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_383.add(mdxpsPrsDdcTrgtAmt, new FormData("100%"));
		layoutContainer_381.add(layoutContainer_383, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		
		// 특별공제_의료비_경로65세이상 세액공제
		LayoutContainer layoutContainer_384 = new LayoutContainer();

		FormLayout frmlytSch205 = new FormLayout();
		frmlytSch205.setLabelWidth(70);
		frmlytSch205.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_384.setLayout(frmlytSch205);

		mdxpsPrsDdcAmt = new MSFNumberField();
		mdxpsPrsDdcAmt.setReadOnly(true);
		mdxpsPrsDdcAmt.setFieldLabel("세액공제");
		mdxpsPrsDdcAmt.setAllowDecimals(true); 
		mdxpsPrsDdcAmt.setPropertyEditorType(Long.class); 
		mdxpsPrsDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_384.add(mdxpsPrsDdcAmt, new FormData("100%"));
		layoutContainer_381.add(layoutContainer_384, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		fldstNewFieldset_31.add(layoutContainer_381);
		/*
		// 실손보험비
		LayoutContainer layoutContainer_mdxpsPrsLsInsrTr = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_mdxpsPrsLsInsrTrAmt = new LayoutContainer();
		
		FormLayout frmlytMdxpsPrsLsInsrTrAmt = new FormLayout();
		frmlytMdxpsPrsLsInsrTrAmt.setLabelWidth(70);
		frmlytMdxpsPrsLsInsrTrAmt.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_mdxpsPrsLsInsrTrAmt.setLayout(frmlytMdxpsPrsLsInsrTrAmt);

		mdxpsPrsLsInsrTrAmt = new MSFNumberField();
		mdxpsPrsLsInsrTrAmt.setReadOnly(true);
		mdxpsPrsLsInsrTrAmt.setFieldLabel("실손보험금액");
		mdxpsPrsLsInsrTrAmt.setAllowDecimals(true); 
		mdxpsPrsLsInsrTrAmt.setPropertyEditorType(Long.class); 
		mdxpsPrsLsInsrTrAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_mdxpsPrsLsInsrTrAmt.add(mdxpsPrsLsInsrTrAmt, new FormData("100%"));
		
		layoutContainer_mdxpsPrsLsInsrTr.add(layoutContainer_mdxpsPrsLsInsrTrAmt, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		fldstNewFieldset_31.add(layoutContainer_mdxpsPrsLsInsrTr);
		*/
		fldstNewFieldset_29.add(fldstNewFieldset_31);
		
		FieldSet fldstNewFieldset_32 = new FieldSet();
		fldstNewFieldset_32.setHeadingHtml("그 밖의 공제대상자");

		LayoutContainer layoutContainer_385 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_385.setLayout(new ColumnLayout());

		// 특별공제_의료비_장애인 지출금액
		LayoutContainer layoutContainer_386 = new LayoutContainer();

		FormLayout frmlytSch206 = new FormLayout();
		frmlytSch206.setLabelWidth(70);
		frmlytSch206.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_386.setLayout(frmlytSch206);

		mdxpsOthUseAmt = new MSFNumberField();
		mdxpsOthUseAmt.setReadOnly(true);
		mdxpsOthUseAmt.setFieldLabel("지출금액");
		mdxpsOthUseAmt.setAllowDecimals(true); 
		mdxpsOthUseAmt.setPropertyEditorType(Long.class); 
		mdxpsOthUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_386.add(mdxpsOthUseAmt, new FormData("100%"));
		layoutContainer_385.add(layoutContainer_386, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

		// 장애인의료비공제대상금액 공제대상
		LayoutContainer layoutContainer_387 = new LayoutContainer();

		FormLayout frmlytSch207 = new FormLayout();
		frmlytSch207.setLabelWidth(70);
		frmlytSch207.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_387.setLayout(frmlytSch207);

		mdxpsOthDdcTrgtAmt = new MSFNumberField();
		mdxpsOthDdcTrgtAmt.setReadOnly(true);
		mdxpsOthDdcTrgtAmt.setFieldLabel("공제대상");
		mdxpsOthDdcTrgtAmt.setAllowDecimals(true); 
		mdxpsOthDdcTrgtAmt.setPropertyEditorType(Long.class); 
		mdxpsOthDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_387.add(mdxpsOthDdcTrgtAmt, new FormData("100%"));
		layoutContainer_385.add(layoutContainer_387, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		// 특별공제_의료비_장애인 공제액 세액공제
		LayoutContainer layoutContainer_388 = new LayoutContainer();

		FormLayout frmlytSch208 = new FormLayout();
		frmlytSch208.setLabelWidth(70);
		frmlytSch208.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_388.setLayout(frmlytSch208);

		mdxpsOthDdcAmt = new MSFNumberField();
		mdxpsOthDdcAmt.setReadOnly(true);
		mdxpsOthDdcAmt.setFieldLabel("세액공제");
		mdxpsOthDdcAmt.setAllowDecimals(true); 
		mdxpsOthDdcAmt.setPropertyEditorType(Long.class); 
		mdxpsOthDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_388.add(mdxpsOthDdcAmt, new FormData("100%"));
		layoutContainer_385.add(layoutContainer_388, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		fldstNewFieldset_32.add(layoutContainer_385);
		/*
		// 실손보험비
		LayoutContainer layoutContainer_mdxpsOthLsInsrTr = new LayoutContainer(new ColumnLayout());
		LayoutContainer layoutContainer_mdxpsOthLsInsrTrAmt = new LayoutContainer();
		
		FormLayout frmlytMdxpsOthLsInsrTrAmt = new FormLayout();
		frmlytMdxpsOthLsInsrTrAmt.setLabelWidth(70);
		frmlytMdxpsOthLsInsrTrAmt.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_mdxpsOthLsInsrTrAmt.setLayout(frmlytMdxpsPrsLsInsrTrAmt);

		mdxpsOthLsInsrTrAmt = new MSFNumberField();
		mdxpsOthLsInsrTrAmt.setReadOnly(true);
		mdxpsOthLsInsrTrAmt.setFieldLabel("실손보험금액");
		mdxpsOthLsInsrTrAmt.setAllowDecimals(true); 
		mdxpsOthLsInsrTrAmt.setPropertyEditorType(Long.class); 
		mdxpsOthLsInsrTrAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_mdxpsPrsLsInsrTrAmt.add(mdxpsOthLsInsrTrAmt, new FormData("100%"));
		
		layoutContainer_mdxpsPrsLsInsrTr.add(layoutContainer_mdxpsOthLsInsrTrAmt, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		fldstNewFieldset_32.add(layoutContainer_mdxpsOthLsInsrTr);
		*/
		fldstNewFieldset_29.add(fldstNewFieldset_32);
	
		// 의료비금액계
		LayoutContainer layoutContainer_356 = new LayoutContainer();

		FormLayout frmlytSch212 = new FormLayout();
		frmlytSch212.setLabelWidth(370);
		frmlytSch212.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_356.setLayout(frmlytSch212);

		mdxpsUseAmtSum = new MSFNumberField();
		mdxpsUseAmtSum.setReadOnly(true);
		mdxpsUseAmtSum.setFieldLabel("의료비금액계");
		mdxpsUseAmtSum.setAllowDecimals(true); 
		mdxpsUseAmtSum.setPropertyEditorType(Long.class); 
		mdxpsUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_356.add(mdxpsUseAmtSum, new FormData("100%"));
		fldstNewFieldset_29.add(layoutContainer_356);
		
		// 의료비금액계
		LayoutContainer layoutContainer_medxpsUseAmtSum = new LayoutContainer();

		FormLayout frmlytSchLsInsrTrAmt = new FormLayout();
		frmlytSchLsInsrTrAmt.setLabelWidth(370);
		frmlytSchLsInsrTrAmt.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_medxpsUseAmtSum.setLayout(frmlytSchLsInsrTrAmt);

		medxpsUseAmtSum = new MSFNumberField();
		medxpsUseAmtSum.setReadOnly(true);
		medxpsUseAmtSum.setFieldLabel("실손보험금보전금액계");
		medxpsUseAmtSum.setAllowDecimals(true); 
		medxpsUseAmtSum.setPropertyEditorType(Long.class); 
		medxpsUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_medxpsUseAmtSum.add(medxpsUseAmtSum, new FormData("100%"));
		fldstNewFieldset_29.add(layoutContainer_medxpsUseAmtSum);

		// 특별공제_의료비세액공제대상금액
		LayoutContainer layoutContainer_357 = new LayoutContainer();

		FormLayout frmlytSch213 = new FormLayout();
		frmlytSch213.setLabelWidth(370);
		frmlytSch213.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_357.setLayout(frmlytSch213);

		mdxpsDdcTrgtAmtSum = new MSFNumberField();
		mdxpsDdcTrgtAmtSum.setReadOnly(true);
		mdxpsDdcTrgtAmtSum.setFieldLabel("공제대상계");
		mdxpsDdcTrgtAmtSum.setAllowDecimals(true); 
		mdxpsDdcTrgtAmtSum.setPropertyEditorType(Long.class); 
		mdxpsDdcTrgtAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_357.add(mdxpsDdcTrgtAmtSum, new FormData("100%"));
		fldstNewFieldset_29.add(layoutContainer_357);

		//특별공제_의료비세액공제액
		LayoutContainer layoutContainer_360_1 = new LayoutContainer();

		FormLayout frmlytSch214 = new FormLayout();
		frmlytSch214.setLabelWidth(370);
		frmlytSch214.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_360_1.setLayout(frmlytSch214);

		mdxpsDdcAmtSum = new MSFNumberField();
		mdxpsDdcAmtSum.setReadOnly(true);
		mdxpsDdcAmtSum.setFieldLabel("세액공제계");
		mdxpsDdcAmtSum.setAllowDecimals(true); 
		mdxpsDdcAmtSum.setPropertyEditorType(Long.class); 
		mdxpsDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_360_1.add(mdxpsDdcAmtSum, new FormData("100%"));
		fldstNewFieldset_29.add(layoutContainer_360_1);

		cntntpnlNewContentpanel_4.add(layoutContainer_350);
		itemYeta08_2.add(cntntpnlNewContentpanel_4);
		cntntpnlNewContentpanel_4.setHeight("355px");

		// 교육비tab
		TabItem itemYeta08_3 = new TabItem("교육비");
		itemYeta08_3.setId("itemYeta08_3");
		itemYeta08_3.setBorders(true);
		tabsItemYeta08.add(itemYeta08_3);
		itemYeta08_3.setHeight("570px");

		ContentPanel cntntpnlNewContentpanel_5 = new ContentPanel();
		cntntpnlNewContentpanel_5.setHeaderVisible(false);
		cntntpnlNewContentpanel_5.setHeadingText("");

		LayoutContainer layoutContainer_370 = new LayoutContainer();

		FieldSet fldstNewFieldset_35 = new FieldSet();
		fldstNewFieldset_35.setHeadingHtml("교육비공제");
		
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

		scxpsPrsUseAmt = new MSFNumberField();
		scxpsPrsUseAmt.setFieldLabel("공납금(대학원포함)");
		scxpsPrsUseAmt.setAllowDecimals(true); 
		scxpsPrsUseAmt.setPropertyEditorType(Long.class); 
		scxpsPrsUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_397.add(scxpsPrsUseAmt, new FormData("100%"));
		layoutContainer_396.add(layoutContainer_397, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

		// 소득자본인교육비대상금액공제대상
		LayoutContainer layoutContainer_398 = new LayoutContainer();

		FormLayout frmlytSch216 = new FormLayout();
		frmlytSch216.setLabelWidth(70);
		frmlytSch216.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_398.setLayout(frmlytSch216);

		scxpsPrsDdcTrgtAmt = new MSFNumberField();
		scxpsPrsDdcTrgtAmt.setReadOnly(true);
		scxpsPrsDdcTrgtAmt.setFieldLabel("공제대상");
		scxpsPrsDdcTrgtAmt.setAllowDecimals(true); 
		scxpsPrsDdcTrgtAmt.setPropertyEditorType(Long.class); 
		scxpsPrsDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_398.add(scxpsPrsDdcTrgtAmt, new FormData("100%"));
		layoutContainer_396.add(layoutContainer_398, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		//특별공제_교육비_본인 공제액 세액공제
		LayoutContainer layoutContainer_399 = new LayoutContainer();

		FormLayout frmlytSch217 = new FormLayout();
		frmlytSch217.setLabelWidth(70);
		frmlytSch217.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_399.setLayout(frmlytSch217);

		scxpsPrsDdcAmt = new MSFNumberField();
		scxpsPrsDdcAmt.setReadOnly(true);
		scxpsPrsDdcAmt.setFieldLabel("세액공제");
		scxpsPrsDdcAmt.setAllowDecimals(true); 
		scxpsPrsDdcAmt.setPropertyEditorType(Long.class); 
		scxpsPrsDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_399.add(scxpsPrsDdcAmt, new FormData("100%"));
		layoutContainer_396.add(layoutContainer_399, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		fldstNewFieldset_36.add(layoutContainer_396);
		layoutContainer_371.add(fldstNewFieldset_36);

		
//		LayoutContainer layoutContainer_373 = new LayoutContainer();
//		LabelField lblfldNewLabelfield_39 = new LabelField("교육비는 지출액 -> 대상금액 -> 세액공제로 표시 됩니다.");
//		layoutContainer_373.add(lblfldNewLabelfield_39);
//		layoutContainer_371.add(layoutContainer_373);

		// 가족교육비등록
		LayoutContainer layoutContainer_374 = new LayoutContainer();

		FieldSet fldstNewFieldset_37 = new FieldSet();
		fldstNewFieldset_37.setHeadingHtml("가족교육비");
		
		// 컬럼레
		LayoutContainer layoutContainer_400 = new LayoutContainer();
		
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
		scxpsKidCount= new MSFNumberField();
		scxpsKidCount.setReadOnly(true);
		scxpsKidCount.setFieldLabel("취학전아동");
		scxpsKidCount.setAllowDecimals(true); 
		scxpsKidCount.setPropertyEditorType(Long.class); 
		scxpsKidCount.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_415.add(scxpsKidCount, new FormData("100%"));
		layoutContainer_409.add(layoutContainer_415, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		LayoutContainer layoutContainer_416 = new LayoutContainer();
		frmlytSch230 = new FormLayout();
		frmlytSch230.setLabelWidth(0);
		frmlytSch230.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_416.setLayout(frmlytSch230);

		//특별공제_교육비_취학전아동
		scxpsKidUseAmt = new MSFNumberField();
		scxpsKidUseAmt.setReadOnly(true);
		scxpsKidUseAmt.setLabelSeparator("");
		scxpsKidUseAmt.setAllowDecimals(true); 
		scxpsKidUseAmt.setPropertyEditorType(Long.class); 
		scxpsKidUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_416.add(scxpsKidUseAmt, new FormData("100%"));
		layoutContainer_409.add(layoutContainer_416, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));


		// 취학전아동(공제)
		LayoutContainer layoutContainer_410 = new LayoutContainer();
		frmlytSch230 = new FormLayout();
		frmlytSch230.setLabelWidth(0);
		frmlytSch230.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_410.setLayout(frmlytSch230);

		scxpsKidDdcAmt = new MSFNumberField();
		scxpsKidDdcAmt.setReadOnly(true);
		scxpsKidDdcAmt.setLabelSeparator("");
		scxpsKidDdcAmt.setAllowDecimals(true); 
		scxpsKidDdcAmt.setPropertyEditorType(Long.class); 
		scxpsKidDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_410.add(scxpsKidDdcAmt, new FormData("100%"));
		layoutContainer_409.add(layoutContainer_410, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		layoutContainer_402.add(layoutContainer_409);
		
		
		// 초.중.고등학교
		LayoutContainer layoutContainer_411 = new LayoutContainer(new ColumnLayout());
//		layoutContainer_411.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_417 = new LayoutContainer();

		FormLayout frmlytSch232 = new FormLayout();
		frmlytSch232.setLabelWidth(150);
		frmlytSch232.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_417.setLayout(frmlytSch232);

		//특별공제_교육비_초중고자녀수
		scxpsStdCount = new MSFNumberField();
		scxpsStdCount.setReadOnly(true);
		scxpsStdCount.setFieldLabel("초.중.고등학교");
		scxpsStdCount.setAllowDecimals(true); 
		scxpsStdCount.setPropertyEditorType(Long.class); 
		scxpsStdCount.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_417.add(scxpsStdCount, new FormData("100%"));
		layoutContainer_411.add(layoutContainer_417, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_418 = new LayoutContainer();
		
		FormLayout frmlytSch418 = new FormLayout();
		frmlytSch418.setLabelWidth(0);

		layoutContainer_418.setLayout(frmlytSch418);

		//특별공제_교육비_초중고
		scxpsStdUseAmt = new MSFNumberField();
		scxpsStdUseAmt.setReadOnly(true);
		scxpsStdUseAmt.setLabelSeparator("");
		scxpsStdUseAmt.setAllowDecimals(true); 
		scxpsStdUseAmt.setPropertyEditorType(Long.class); 
		scxpsStdUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_418.add(scxpsStdUseAmt, new FormData("100%"));
		layoutContainer_411.add(layoutContainer_418, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));


		// 초.중.고등학교(공제)
		LayoutContainer layoutContainer_412 = new LayoutContainer();

		FormLayout frmlytSch233 = new FormLayout();
		frmlytSch233.setLabelWidth(0);
		frmlytSch233.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_412.setLayout(frmlytSch233);

		scxpsStdDdcAmt = new MSFNumberField();
		scxpsStdDdcAmt.setReadOnly(true);
		scxpsStdDdcAmt.setLabelSeparator("");
		scxpsStdDdcAmt.setAllowDecimals(true); 
		scxpsStdDdcAmt.setPropertyEditorType(Long.class); 
		scxpsStdDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_412.add(scxpsStdDdcAmt, new FormData("100%"));
		layoutContainer_411.add(layoutContainer_412, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		layoutContainer_402.add(layoutContainer_411);

		// 대학원(대학원불포함)
		LayoutContainer layoutContainer_413 = new LayoutContainer();
		layoutContainer_413.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_419 = new LayoutContainer();

		FormLayout frmlytSch234 = new FormLayout();
		frmlytSch234.setLabelWidth(150);
		frmlytSch234.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_419.setLayout(frmlytSch234);

		//특별공제_교육비_대학생수
		scxpsUndCount = new MSFNumberField();
		scxpsUndCount.setReadOnly(true);
		scxpsUndCount.setFieldLabel("대학교(대학원불포함)");
		scxpsUndCount.setAllowDecimals(true); 
		scxpsUndCount.setPropertyEditorType(Long.class); 
		scxpsUndCount.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_419.add(scxpsUndCount, new FormData("100%"));
		layoutContainer_413.add(layoutContainer_419, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_420 = new LayoutContainer();
		
		FormLayout frmlytSch420 = new FormLayout();
		frmlytSch420.setLabelWidth(0);

		layoutContainer_420.setLayout(frmlytSch420);

		//특별공제_교육비_대학교
		scxpsUndUseAmt = new MSFNumberField();
		scxpsUndUseAmt.setReadOnly(true);
		scxpsUndUseAmt.setLabelSeparator("");
		scxpsUndUseAmt.setAllowDecimals(true); 
		scxpsUndUseAmt.setPropertyEditorType(Long.class); 
		scxpsUndUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_420.add(scxpsUndUseAmt, new FormData("100%"));
		layoutContainer_413.add(layoutContainer_420, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));


		// 대학원생(공제)
		LayoutContainer layoutContainer_414 = new LayoutContainer();

		FormLayout frmlytSch235 = new FormLayout();
		frmlytSch235.setLabelWidth(0);
		frmlytSch235.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_414.setLayout(frmlytSch235);

		scxpsUndDdcAmt = new MSFNumberField();
		scxpsUndDdcAmt.setReadOnly(true);
		scxpsUndDdcAmt.setLabelSeparator("");
		scxpsUndDdcAmt.setAllowDecimals(true); 
		scxpsUndDdcAmt.setPropertyEditorType(Long.class); 
		scxpsUndDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_414.add(scxpsUndDdcAmt, new FormData("100%"));
		layoutContainer_413.add(layoutContainer_414, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		layoutContainer_402.add(layoutContainer_413);

//		layoutContainer_400.add(layoutContainer_402, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_400.add(layoutContainer_402);

		fldstNewFieldset_37.add(layoutContainer_400);
		layoutContainer_374.add(fldstNewFieldset_37);
		
		LayoutContainer layoutContainer_373 = new LayoutContainer();
		LabelField lblfldNewLabelfield_39 = new LabelField("가죡교육비는 인원수 -> 납입금액 -> 공제세액으로 표시 됩니다.");
		layoutContainer_373.add(lblfldNewLabelfield_39);
		fldstNewFieldset_37.add(layoutContainer_373);
		
		
		
		
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
		scxpsDsbrUseAmt  = new MSFNumberField();
		scxpsDsbrUseAmt.setFieldLabel("특수교육비");
		scxpsDsbrUseAmt.setAllowDecimals(true); 
		scxpsDsbrUseAmt.setPropertyEditorType(Long.class); 
		scxpsDsbrUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_404.add(scxpsDsbrUseAmt, new FormData("100%"));
		layoutContainer_403.add(layoutContainer_404, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

		// 특별공제_장애인특수교육비 공제대상계
		LayoutContainer layoutContainer_405 = new LayoutContainer();

		FormLayout frmlytSch219 = new FormLayout();
		frmlytSch219.setLabelWidth(80);
		frmlytSch219.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_405.setLayout(frmlytSch219);

		scxpsDsbrDdcTrgtAmt = new MSFNumberField();
		scxpsDsbrDdcTrgtAmt.setReadOnly(true);
		scxpsDsbrDdcTrgtAmt.setFieldLabel("공제대상");
		scxpsDsbrDdcTrgtAmt.setAllowDecimals(true); 
		scxpsDsbrDdcTrgtAmt.setPropertyEditorType(Long.class); 
		scxpsDsbrDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_405.add(scxpsDsbrDdcTrgtAmt, new FormData("100%"));
		layoutContainer_403.add(layoutContainer_405, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		// 특별공제_장애인특수교육비 세액공제
		LayoutContainer layoutContainer_406 = new LayoutContainer();

		FormLayout frmlytSch220 = new FormLayout();
		frmlytSch220.setLabelWidth(80);
		frmlytSch220.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_406.setLayout(frmlytSch220);

		scxpsDsbrDdcAmt = new MSFNumberField();
		scxpsDsbrDdcAmt.setReadOnly(true);
		scxpsDsbrDdcAmt.setFieldLabel("세액공제");
		scxpsDsbrDdcAmt.setAllowDecimals(true); 
		scxpsDsbrDdcAmt.setPropertyEditorType(Long.class); 
		scxpsDsbrDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_406.add(scxpsDsbrDdcAmt, new FormData("100%"));
		layoutContainer_403.add(layoutContainer_406, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

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

		scxpsUseAmtSum = new MSFNumberField();
		scxpsUseAmtSum.setReadOnly(true);
		scxpsUseAmtSum.setFieldLabel("교육비금액계");
		scxpsUseAmtSum.setAllowDecimals(true); 
		scxpsUseAmtSum.setPropertyEditorType(Long.class); 
		scxpsUseAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_393.add(scxpsUseAmtSum, new FormData("100%"));
		layoutContainer_376.add(layoutContainer_393, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

		// 특별공제_교육비공제대상금액 공제대상계
		LayoutContainer layoutContainer_394 = new LayoutContainer();

		FormLayout frmlytSch222 = new FormLayout();
		frmlytSch222.setLabelWidth(80);
		frmlytSch222.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_394.setLayout(frmlytSch222);

		scxpsDdcTrgtAmtSum = new MSFNumberField();
		scxpsDdcTrgtAmtSum.setReadOnly(true);
		scxpsDdcTrgtAmtSum.setFieldLabel("공제대상계");
		scxpsDdcTrgtAmtSum.setAllowDecimals(true); 
		scxpsDdcTrgtAmtSum.setPropertyEditorType(Long.class); 
		scxpsDdcTrgtAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_394.add(scxpsDdcTrgtAmtSum, new FormData("100%"));
		layoutContainer_376.add(layoutContainer_394, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		// 특별공제_교육비세액공제금액 세액공제계
		LayoutContainer layoutContainer_395 = new LayoutContainer();

		FormLayout frmlytSch223 = new FormLayout();
		frmlytSch223.setLabelWidth(80);
		frmlytSch223.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_395.setLayout(frmlytSch223);

		scxpsDdcAmtSum = new MSFNumberField();
		scxpsDdcAmtSum.setReadOnly(true);
		scxpsDdcAmtSum.setFieldLabel("세액공제계");
		scxpsDdcAmtSum.setAllowDecimals(true); 
		scxpsDdcAmtSum.setPropertyEditorType(Long.class); 
		scxpsDdcAmtSum.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_395.add(scxpsDdcAmtSum, new FormData("100%"));
		layoutContainer_376.add(layoutContainer_395, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		layoutContainer_371.add(layoutContainer_376);
		
		fldstNewFieldset_35.add(layoutContainer_371);
		layoutContainer_370.add(fldstNewFieldset_35);
		
		ButtonBar buttonBar_4 = new ButtonBar();
		buttonBar_4.setAlignment(HorizontalAlignment.RIGHT);

		Button btnNewButton_11 = new Button("교육비내역등록");
		buttonBar_4.add(btnNewButton_11);
		btnNewButton_11.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP730011 yetaP230011Form = new YetaP730011(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwYeta730011 = new MSFFormWindows("교육비내역등록", yetaP230011Form, "닫기", "820px", "730px", true);
				msFwYeta730011.show();
				yetaP230011Form.setMSFFormWindows(msFwYeta730011);
				
				msFwYeta730011.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			getItemYeta08();
		    		}
				});
				
				
				
				funcSetPopUpRecord();
				yetaP230011Form.bind(ppRecord); 
			}
		});		

		layoutContainer_370.add(buttonBar_4);
		
		
		cntntpnlNewContentpanel_5.add(layoutContainer_370);
		itemYeta08_3.add(cntntpnlNewContentpanel_5);
		cntntpnlNewContentpanel_5.setHeight("415px");  //355

		
		
		// 기부금tab
		TabItem itemYeta08_4 = new TabItem("기부금");
		itemYeta08_4.setId("itemYeta08_4");
		itemYeta08_4.setBorders(true);
		tabsItemYeta08.add(itemYeta08_4);
		itemYeta08_4.setHeight("570px");

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

//		Button btnNewButton_13 = new Button("이월기부금등록");
//		buttonBar_5.add(btnNewButton_13);
//		btnNewButton_13.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				//전체내역  
//				YetaP23001 yetaP23001Form = new YetaP23001(ActionDatabase.READ, getThis());   
//				    
//				MSFFormWindows msFwYeta73001 = new MSFFormWindows("이월기부금등록", yetaP23001Form, "닫기", "820px", "710px", true);
//				msFwYeta73001.show();
//				yetaP23001Form.setMSFFormWindows(msFwYeta73001);
//				
//				funcSetPopUpRecord();
//				
//				//TODO 추후 주석해제 
//				yetaP23001Form.bind(ppRecord); 
//			}
//		});
		Button btnNewButton_14 = new Button("기부금내역등록");
		buttonBar_5.add(btnNewButton_14);
		btnNewButton_14.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP73003 yetaP23003Form = new YetaP73003(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwYeta73003 = new MSFFormWindows("기부금내역등록", yetaP23003Form, "닫기", "820px", "510px", true);
				msFwYeta73003.show();
				yetaP23003Form.setMSFFormWindows(msFwYeta73003);
				
				msFwYeta73003.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			getItemYeta08();
		    		}
				});
				
				
				funcSetPopUpRecord();
				//TODO 추후 주석해제 
				yetaP23003Form.bind(ppRecord); 
			}
		});	
		
		Button btnNewButton_13 = new Button("기부금조정명세");
		buttonBar_5.add(btnNewButton_13);
		btnNewButton_13.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//전체내역  
				YetaP73001 yetaP23001Form = new YetaP73001(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwYeta73001 = new MSFFormWindows("기부금조정명세", yetaP23001Form, "닫기", "820px", "710px", true);
				msFwYeta73001.show();
				yetaP23001Form.setMSFFormWindows(msFwYeta73001);
				
				msFwYeta73001.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			getItemYeta05();
		    		}
				});
				
						
				funcSetPopUpRecord();
				
				yetaP23001Form.bind(ppRecord); 
			}
		});

		layoutContainer_360.add(buttonBar_5);
		
		

		
		
		fieldSet_2.add(layoutContainer_360);
		
		LayoutContainer layoutContainer_gibu = new LayoutContainer();
//		layoutContainer_gibu.setLayout(new ColumnLayout());
		
		
		LayoutContainer layoutContainer_gibu01 = new LayoutContainer(new ColumnLayout());
		
		// 정치자금(10만원이하)
		LayoutContainer layoutContainer_giLeftbu01 = new LayoutContainer();
		
		FormLayout frmlytSchLeft01 = new FormLayout();
		frmlytSchLeft01.setLabelWidth(170);
		frmlytSchLeft01.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_giLeftbu01.setLayout(frmlytSchLeft01);
		layoutContainer_giLeftbu01.setBorders(false);

		//세액공제_기부정치자금금액
		conb10ttswLtUseAmt = new MSFNumberField();
		conb10ttswLtUseAmt.setReadOnly(true);
		conb10ttswLtUseAmt.setFieldLabel("정치자금(10만원이하)");
		conb10ttswLtUseAmt.setAllowDecimals(true); 
		conb10ttswLtUseAmt.setPropertyEditorType(Long.class); 
		conb10ttswLtUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		
		layoutContainer_giLeftbu01.add(conb10ttswLtUseAmt, new FormData("100%"));
		layoutContainer_gibu01.add(layoutContainer_giLeftbu01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter01 = new LayoutContainer();
		
		FormLayout frmlytSchCenter01 = new FormLayout();
		frmlytSchCenter01.setLabelWidth(0);
		
		layoutContainer_gibuCenter01.setLayout(frmlytSchCenter01);

		//특별공제_기부정치자금_10이하대상금액
		conb10ttswLtDdcTrgtAmt = new MSFNumberField();
		conb10ttswLtDdcTrgtAmt.setReadOnly(true);
		conb10ttswLtDdcTrgtAmt.setLabelSeparator("");
		conb10ttswLtDdcTrgtAmt.setAllowDecimals(true); 
		conb10ttswLtDdcTrgtAmt.setPropertyEditorType(Long.class); 
		conb10ttswLtDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		
		
		layoutContainer_gibuCenter01.add(conb10ttswLtDdcTrgtAmt, new FormData("100%"));
		layoutContainer_gibu01.add(layoutContainer_gibuCenter01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer_gibuRight01 = new LayoutContainer();
		
		FormLayout frmlytSchRight01 = new FormLayout();
		frmlytSchRight01.setLabelWidth(0);
		
		
		layoutContainer_gibuRight01.setLayout(frmlytSchRight01);

		// 세액공제_기부정치자금 공제액
		conb10ttswLtDdcAmt = new MSFNumberField();
		conb10ttswLtDdcAmt.setReadOnly(true);
		conb10ttswLtDdcAmt.setLabelSeparator("");
		conb10ttswLtDdcAmt.setAllowDecimals(true); 
		conb10ttswLtDdcAmt.setPropertyEditorType(Long.class); 
		conb10ttswLtDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_gibuRight01.add(conb10ttswLtDdcAmt, new FormData("100%"));
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
		conb10excsLtUseAmt = new MSFNumberField();
		conb10excsLtUseAmt.setReadOnly(true);
		conb10excsLtUseAmt.setAllowDecimals(true); 
		conb10excsLtUseAmt.setPropertyEditorType(Long.class); 
		conb10excsLtUseAmt.setFormat(NumberFormat.getDecimalFormat());
		conb10excsLtUseAmt.setFieldLabel("정치자금(10만원초과)");
		
		layoutContainer_gibuLeft02.add(conb10excsLtUseAmt, new FormData("100%"));
		layoutContainer_gibu02.add(layoutContainer_gibuLeft02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter02 = new LayoutContainer();
		layoutContainer_gibuCenter02.setBorders(false);
		
		FormLayout frmlytSchCenter02 = new FormLayout();
		frmlytSchCenter02.setLabelWidth(0);
		
		layoutContainer_gibuCenter02.setLayout(frmlytSchCenter02);

		//특별공제_기부금_정치10초과대상금액
		conb10excsLtDdcTrgtAmt = new MSFNumberField();
		conb10excsLtDdcTrgtAmt.setReadOnly(true);
		conb10excsLtDdcTrgtAmt.setAllowDecimals(true); 
		conb10excsLtDdcTrgtAmt.setPropertyEditorType(Long.class); 
		conb10excsLtDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		conb10excsLtDdcTrgtAmt.setLabelSeparator("");
		
		layoutContainer_gibuCenter02.add(conb10excsLtDdcTrgtAmt, new FormData("100%"));
		layoutContainer_gibu02.add(layoutContainer_gibuCenter02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer layoutContainer_gibuRight02 = new LayoutContainer();
		layoutContainer_gibuRight02.setBorders(false);
		
		FormLayout frmlytSchRight02 = new FormLayout();
		frmlytSchRight02.setLabelWidth(0);
		
		layoutContainer_gibuRight02.setLayout(frmlytSchRight02);

		//특별공제_기부금_정치 공제액
		conb10excsLtDdcAmt = new MSFNumberField();
		conb10excsLtDdcAmt.setReadOnly(true);
		conb10excsLtDdcAmt.setAllowDecimals(true); 
		conb10excsLtDdcAmt.setPropertyEditorType(Long.class); 
		conb10excsLtDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		conb10excsLtDdcAmt.setLabelSeparator("");
		
		layoutContainer_gibuRight02.add(conb10excsLtDdcAmt, new FormData("100%"));
		layoutContainer_gibu02.add(layoutContainer_gibuRight02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer_gibu03 = new LayoutContainer(new ColumnLayout());
		// 전액공제기부금액(법정)
		LayoutContainer layoutContainer_gibuLeft03 = new LayoutContainer();
				
		FormLayout frmlytSchLeft03 = new FormLayout();
		frmlytSchLeft03.setLabelWidth(170);
		frmlytSchLeft03.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft03.setLayout(frmlytSchLeft03);
		layoutContainer_gibuLeft03.setBorders(false);

		conbLglUseAmt02 = new MSFNumberField();
		conbLglUseAmt02.setReadOnly(true);
		conbLglUseAmt02.setAllowDecimals(true); 
		conbLglUseAmt02.setPropertyEditorType(Long.class); 
		conbLglUseAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbLglUseAmt02.setFieldLabel("전액공제기부금액(법정)");
		
		layoutContainer_gibuLeft03.add(conbLglUseAmt02, new FormData("100%"));
		layoutContainer_gibu03.add(layoutContainer_gibuLeft03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer_gibuCenter03 = new LayoutContainer();
		layoutContainer_gibuCenter03.setBorders(false);
		
		FormLayout frmlytSchCenter03 = new FormLayout();
		frmlytSchCenter03.setLabelWidth(0);
		
		layoutContainer_gibuCenter03.setLayout(frmlytSchCenter03);

		//특별공제_기부금_법정대상금액
		conbLglDdcTrgtAmt02 = new MSFNumberField();
		conbLglDdcTrgtAmt02.setReadOnly(true);
		conbLglDdcTrgtAmt02.setAllowDecimals(true); 
		conbLglDdcTrgtAmt02.setPropertyEditorType(Long.class); 
		conbLglDdcTrgtAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbLglDdcTrgtAmt02.setLabelSeparator("");
		
		layoutContainer_gibuCenter03.add(conbLglDdcTrgtAmt02, new FormData("100%"));
		layoutContainer_gibu03.add(layoutContainer_gibuCenter03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight03 = new LayoutContainer();
		layoutContainer_gibuRight03.setBorders(false);
		
		FormLayout frmlytSchRight03 = new FormLayout();
		frmlytSchRight03.setLabelWidth(0);
		
		layoutContainer_gibuRight03.setLayout(frmlytSchRight03);

		//특별공제_기부금_법정 공제액
		conbLglDdcAmt02 = new MSFNumberField();
		conbLglDdcAmt02.setReadOnly(true);
		conbLglDdcAmt02.setAllowDecimals(true); 
		conbLglDdcAmt02.setPropertyEditorType(Long.class); 
		conbLglDdcAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbLglDdcAmt02.setLabelSeparator("");
		
		layoutContainer_gibuRight03.add(conbLglDdcAmt02, new FormData("100%"));
		layoutContainer_gibu03.add(layoutContainer_gibuRight03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
				
		LayoutContainer layoutContainer_gibu05 = new LayoutContainer(new ColumnLayout());
		// 우리사주조합 기부금
		LayoutContainer layoutContainer_gibuLeft05 = new LayoutContainer();
		
		FormLayout frmlytSchLeft05 = new FormLayout();
		frmlytSchLeft05.setLabelWidth(170);
		frmlytSchLeft05.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_gibuLeft05.setLayout(frmlytSchLeft05);

		conbEmstAsctUseAmt = new MSFNumberField();
		conbEmstAsctUseAmt.setReadOnly(true);
		conbEmstAsctUseAmt.setAllowDecimals(true); 
		conbEmstAsctUseAmt.setPropertyEditorType(Long.class); 
		conbEmstAsctUseAmt.setFormat(NumberFormat.getDecimalFormat());
		conbEmstAsctUseAmt.setFieldLabel("우리사주조합 기부금");
		
		layoutContainer_gibuLeft05.add(conbEmstAsctUseAmt, new FormData("100%"));
		layoutContainer_gibu05.add(layoutContainer_gibuLeft05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer_gibuCenter05 = new LayoutContainer();
		
		FormLayout frmlytSchCenter05 = new FormLayout();
		frmlytSchCenter05.setLabelWidth(0);
		
		layoutContainer_gibuCenter05.setLayout(frmlytSchCenter05);

		
		//우리사주종합기부대상금액
		conbEmstAsctDdcTrgtAmt = new MSFNumberField();
		conbEmstAsctDdcTrgtAmt.setReadOnly(true);
		conbEmstAsctDdcTrgtAmt.setAllowDecimals(true); 
		conbEmstAsctDdcTrgtAmt.setPropertyEditorType(Long.class); 
		conbEmstAsctDdcTrgtAmt.setFormat(NumberFormat.getDecimalFormat());
		conbEmstAsctDdcTrgtAmt.setLabelSeparator("");
		
		layoutContainer_gibuCenter05.add(conbEmstAsctDdcTrgtAmt, new FormData("100%"));
		layoutContainer_gibu05.add(layoutContainer_gibuCenter05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight05 = new LayoutContainer();
		
		FormLayout frmlytSchRight05 = new FormLayout();
		frmlytSchRight05.setLabelWidth(0);
		
		layoutContainer_gibuRight05.setLayout(frmlytSchRight05);

		//특별공제_기부금_우리사주조합2015이후
		conbEmstAsctDdcAmt = new MSFNumberField();
		conbEmstAsctDdcAmt.setReadOnly(true);
		conbEmstAsctDdcAmt.setAllowDecimals(true); 
		conbEmstAsctDdcAmt.setPropertyEditorType(Long.class); 
		conbEmstAsctDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		conbEmstAsctDdcAmt.setLabelSeparator("");
		
		layoutContainer_gibuRight05.add(conbEmstAsctDdcAmt, new FormData("100%"));
		layoutContainer_gibu05.add(layoutContainer_gibuRight05, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer layoutContainer_gibu06 = new LayoutContainer(new ColumnLayout());
		// 종교단체외지정기부금
		LayoutContainer layoutContainer_gibuLeft06 = new LayoutContainer();
		layoutContainer_gibuLeft06.setBorders(false);
				
		FormLayout frmlytSchLeft06 = new FormLayout();
		frmlytSchLeft06.setLabelWidth(170);
		frmlytSchLeft06.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft06.setLayout(frmlytSchLeft06);
				

		conbReliOrgOthUseAmt02 = new MSFNumberField();
		conbReliOrgOthUseAmt02.setReadOnly(true);
		conbReliOrgOthUseAmt02.setAllowDecimals(true); 
		conbReliOrgOthUseAmt02.setPropertyEditorType(Long.class); 
		conbReliOrgOthUseAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbReliOrgOthUseAmt02.setFieldLabel("종교단체외지정기부금");
		
		layoutContainer_gibuLeft06.add(conbReliOrgOthUseAmt02, new FormData("100%"));
		layoutContainer_gibu06.add(layoutContainer_gibuLeft06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_gibuCenter06 = new LayoutContainer();
		
		FormLayout frmlytSchCenter06= new FormLayout();
		frmlytSchCenter06.setLabelWidth(0);
		
		layoutContainer_gibuCenter06.setLayout(frmlytSchCenter06);

		
		//종교단체외지정대상금액
		conbReliOrgOthDdcTrgtAmt02 = new MSFNumberField();
		conbReliOrgOthDdcTrgtAmt02.setReadOnly(true);
		conbReliOrgOthDdcTrgtAmt02.setAllowDecimals(true); 
		conbReliOrgOthDdcTrgtAmt02.setPropertyEditorType(Long.class); 
		conbReliOrgOthDdcTrgtAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbReliOrgOthDdcTrgtAmt02.setLabelSeparator("");
		
		layoutContainer_gibuCenter06.add(conbReliOrgOthDdcTrgtAmt02, new FormData("100%"));
		layoutContainer_gibu06.add(layoutContainer_gibuCenter06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight06 = new LayoutContainer();
		
		FormLayout frmlytSchRight06 = new FormLayout();
		frmlytSchRight06.setLabelWidth(0);
		
		layoutContainer_gibuRight06.setLayout(frmlytSchRight06);

		//특별공제_기부금_종교단체외 공제액
		conbReliOrgOthDdcAmt02 = new MSFNumberField();
		conbReliOrgOthDdcAmt02.setReadOnly(true);
		conbReliOrgOthDdcAmt02.setAllowDecimals(true); 
		conbReliOrgOthDdcAmt02.setPropertyEditorType(Long.class); 
		conbReliOrgOthDdcAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbReliOrgOthDdcAmt02.setLabelSeparator("");
		
		layoutContainer_gibuRight06.add(conbReliOrgOthDdcAmt02, new FormData("100%"));
		layoutContainer_gibu06.add(layoutContainer_gibuRight06, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer_gibu07 = new LayoutContainer(new ColumnLayout());
		// 종교단체지정기부금
		LayoutContainer layoutContainer_gibuLeft07 = new LayoutContainer();
		layoutContainer_gibuLeft07.setBorders(false);
				
		FormLayout frmlytSchLeft07 = new FormLayout();
		frmlytSchLeft07.setLabelWidth(170);
		frmlytSchLeft07.setLabelAlign(LabelAlign.RIGHT);
				
		layoutContainer_gibuLeft07.setLayout(frmlytSchLeft07);

		conbReliOrgUseAmt02 = new MSFNumberField();
		conbReliOrgUseAmt02.setReadOnly(true);
		conbReliOrgUseAmt02.setAllowDecimals(true); 
		conbReliOrgUseAmt02.setPropertyEditorType(Long.class); 
		conbReliOrgUseAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbReliOrgUseAmt02.setFieldLabel("종교단체지정기부금");
		
		layoutContainer_gibuLeft07.add(conbReliOrgUseAmt02, new FormData("100%"));
		layoutContainer_gibu07.add(layoutContainer_gibuLeft07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer_gibuCenter07 = new LayoutContainer();
		layoutContainer_gibuCenter07.setBorders(false);
		
		FormLayout frmlytSchCenter07= new FormLayout();
		frmlytSchCenter07.setLabelWidth(0);
		
		layoutContainer_gibuCenter07.setLayout(frmlytSchCenter07);

		//종교단체지정대상금액
		conbReliOrgDdcTrgtAmt02 = new MSFNumberField();
		conbReliOrgDdcTrgtAmt02.setReadOnly(true);
		conbReliOrgDdcTrgtAmt02.setAllowDecimals(true); 
		conbReliOrgDdcTrgtAmt02.setPropertyEditorType(Long.class); 
		conbReliOrgDdcTrgtAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbReliOrgDdcTrgtAmt02.setLabelSeparator("");
		
		layoutContainer_gibuCenter07.add(conbReliOrgDdcTrgtAmt02, new FormData("100%"));
		layoutContainer_gibu07.add(layoutContainer_gibuCenter07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer layoutContainer_gibuRight07 = new LayoutContainer();
		
		FormLayout frmlytSchRight07 = new FormLayout();
		frmlytSchRight07.setLabelWidth(0);
		
		layoutContainer_gibuRight07.setLayout(frmlytSchRight07);

		//특별공제_기부금_종교단체 공제액
		conbReliOrgDdcAmt02= new MSFNumberField();
		conbReliOrgDdcAmt02.setReadOnly(true);
		conbReliOrgDdcAmt02.setAllowDecimals(true); 
		conbReliOrgDdcAmt02.setPropertyEditorType(Long.class); 
		conbReliOrgDdcAmt02.setFormat(NumberFormat.getDecimalFormat());
		conbReliOrgDdcAmt02.setLabelSeparator("");
		
		layoutContainer_gibuRight07.add(conbReliOrgDdcAmt02, new FormData("100%"));
		layoutContainer_gibu07.add(layoutContainer_gibuRight07, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		//----------------------------------------------------
		
		layoutContainer_gibu.add(layoutContainer_gibu01);
		layoutContainer_gibu.add(layoutContainer_gibu02);
		layoutContainer_gibu.add(layoutContainer_gibu03);
//		layoutContainer_gibu.add(layoutContainer_gibu04);
		layoutContainer_gibu.add(layoutContainer_gibu05);
		layoutContainer_gibu.add(layoutContainer_gibu06);
		layoutContainer_gibu.add(layoutContainer_gibu07);
		
		LayoutContainer layoutContainer_362 = new LayoutContainer();
		layoutContainer_362.setLayout(new ColumnLayout());

		// 기부금액계
		LayoutContainer layoutContainer_421 = new LayoutContainer();

		FormLayout frmlytSch242 = new FormLayout();
		frmlytSch242.setLabelWidth(100);
		frmlytSch242.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_421.setLayout(frmlytSch242);

		conbUseAmtSum02 = new MSFNumberField();
		conbUseAmtSum02.setFieldLabel("기부금액계");
		conbUseAmtSum02.setReadOnly(true);
		conbUseAmtSum02.setAllowDecimals(true); 
		conbUseAmtSum02.setPropertyEditorType(Long.class); 
		conbUseAmtSum02.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_421.add(conbUseAmtSum02, new FormData("100%"));
		layoutContainer_362.add(layoutContainer_421, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		

		// 공제대상계
		LayoutContainer layoutContainer_422 = new LayoutContainer();

		FormLayout frmlytSch243 = new FormLayout();
		frmlytSch243.setLabelWidth(100);
		frmlytSch243.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_422.setLayout(frmlytSch243);

		conbDdcTrgtAmtSum02 = new MSFNumberField();
		conbDdcTrgtAmtSum02.setReadOnly(true);
		conbDdcTrgtAmtSum02.setFieldLabel("공제대상계");
		conbDdcTrgtAmtSum02.setAllowDecimals(true); 
		conbDdcTrgtAmtSum02.setPropertyEditorType(Long.class); 
		conbDdcTrgtAmtSum02.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_422.add(conbDdcTrgtAmtSum02, new FormData("100%"));
		layoutContainer_362.add(layoutContainer_422, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		//기부금 세액공제계
		LayoutContainer layoutContainer_423 = new LayoutContainer();

		FormLayout frmlytSch244 = new FormLayout();
		frmlytSch244.setLabelWidth(100);
		frmlytSch244.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_423.setLayout(frmlytSch244);

		conbDdcAmtSum02 = new MSFNumberField();
		conbDdcAmtSum02.setReadOnly(true);
		conbDdcAmtSum02.setFieldLabel("세액공제계");
		conbDdcAmtSum02.setAllowDecimals(true); 
		conbDdcAmtSum02.setPropertyEditorType(Long.class); 
		conbDdcAmtSum02.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_423.add(conbDdcAmtSum02, new FormData("100%"));
		layoutContainer_362.add(layoutContainer_423, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		layoutContainer_gibu.add(layoutContainer_362);
		
		
		fieldSet_2.add(layoutContainer_gibu);
		cntntpnlNewContentpanel_6.add(fieldSet_2);
		
		// 기부금적용순서
		LayoutContainer layoutContainer_364 = new LayoutContainer();

		LabelField lblfldNewLabelfield_37 = new LabelField("* 기부금은 기부금액 -> 공제대상금액 -> 공제세액순으로 표시됩니다.");
		layoutContainer_364.add(lblfldNewLabelfield_37);
				
		cntntpnlNewContentpanel_6.add(layoutContainer_364);
		
	
				
				
		itemYeta08_4.add(cntntpnlNewContentpanel_6);
		cntntpnlNewContentpanel_6.setHeight("550");

		layoutContainer_15.add(tabsItemYeta08);
		tabsItemYeta08.setHeight("550");

		cp01.add(layoutContainer_15);
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	private LayoutContainer yetaData09() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
//		cp01.setScrollMode(Scroll.AUTOY);
		cp01.setSize("660", "590");
		
		
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
		  
		frgrLbrrEntcPupCd = new CheckBoxGroup();
		frgrLbrrEntcPupCd.setName("frgrLbrrEntcPupCd");

		frgrLbrrEntcPupCd1 = new CheckBox();
		frgrLbrrEntcPupCd1.setBoxLabel("정부간협약");
		frgrLbrrEntcPupCd1.setHideLabel(true);
		frgrLbrrEntcPupCd1.setValueAttribute("Y");
		frgrLbrrEntcPupCd.add(frgrLbrrEntcPupCd1);
		
		
		frgrLbrrEntcPupCd2 = new CheckBox();
		frgrLbrrEntcPupCd2.setBoxLabel("기술도입계약");
		frgrLbrrEntcPupCd2.setHideLabel(true);
		frgrLbrrEntcPupCd2.setValueAttribute("Y");
		frgrLbrrEntcPupCd.add(frgrLbrrEntcPupCd2);
		  
		frgrLbrrEntcPupCd3 = new CheckBox();
		frgrLbrrEntcPupCd3.setBoxLabel("조세특례제한법 상 감면");
		frgrLbrrEntcPupCd3.setHideLabel(true);
		frgrLbrrEntcPupCd3.setValueAttribute("Y");
		frgrLbrrEntcPupCd.add(frgrLbrrEntcPupCd3);
		  
		frgrLbrrEntcPupCd4 = new CheckBox();
		frgrLbrrEntcPupCd4.setBoxLabel("조세조약상 감면");
		frgrLbrrEntcPupCd4.setHideLabel(true);
		frgrLbrrEntcPupCd4.setValueAttribute("Y");
		frgrLbrrEntcPupCd.add(frgrLbrrEntcPupCd4);
		  
		layoutContainer_152.add(frgrLbrrEntcPupCd);
		layoutContainer_151.add(layoutContainer_152, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		  
		
		LayoutContainer layoutContainer_153 = new LayoutContainer();
		  
		  
		 //기술도입계약 또는 근로제공일
		LayoutContainer layoutContainer_155 = new LayoutContainer();
		  
		FormLayout frmlytSch49_1 = new FormLayout();
		frmlytSch49_1.setLabelWidth(250);
		frmlytSch49_1.setLabelAlign(LabelAlign.RIGHT);
		  
		layoutContainer_155.setLayout(frmlytSch49_1);

		frgrLbrrLbrOfrDt = new MSFDateField();
		frgrLbrrLbrOfrDt.setFieldLabel("기술도입계약 또는 근로제공일");
		frgrLbrrLbrOfrDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgrLbrrLbrOfrDt.setName("frgrLbrrLbrOfrDt");
	    new DateFieldMask(frgrLbrrLbrOfrDt, "9999.99.99");
	    
		layoutContainer_155.add(frgrLbrrLbrOfrDt, new FormData("100%"));
		layoutContainer_153.add(layoutContainer_155);
		  
		// 외국인근로소득에 대한 감면 신청서 접수일자
		LayoutContainer layoutContainer_156 = new LayoutContainer();

		FormLayout frmlytSch63 = new FormLayout();
		frmlytSch63.setLabelWidth(250);
		frmlytSch63.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_156.setLayout(frmlytSch63);

		frgrLbrrReRcpnDt = new MSFDateField();
		frgrLbrrReRcpnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgrLbrrReRcpnDt.setName("frgrLbrrReRcpnDt");
	    new DateFieldMask(frgrLbrrReRcpnDt, "9999.99.99");
		frgrLbrrReRcpnDt.setFieldLabel("외국인근로소득에 대한 감면 신청서 접수일자");
		
		layoutContainer_156.add(frgrLbrrReRcpnDt, new FormData("100%"));
		layoutContainer_153.add(layoutContainer_156);
		  
//		// 해저광물자원개발에 대한 감면확인일자
//		LayoutContainer layoutContainer_157 = new LayoutContainer();
//
//		FormLayout frmlytSch64 = new FormLayout();
//		frmlytSch64.setLabelWidth(250);
//		frmlytSch64.setLabelAlign(LabelAlign.RIGHT);
//		// 해저광물자원개발에 대한 감면확인일자
//		layoutContainer_157.setLayout(frmlytSch64);
//
//		txlgFrrd = new MSFDateField();
//		txlgFrrd.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		txlgFrrd.setName("txlgFrrd");
//	    new DateFieldMask(txlgFrrd, "9999.99.99");
//		layoutContainer_157.add(txlgFrrd, new FormData("100%"));
//		txlgFrrd.setFieldLabel("해저광물자원개발에 대한 감면확인일자");
//		layoutContainer_153.add(layoutContainer_157);
		
		LayoutContainer layoutContainer_161 = new LayoutContainer();

		FormLayout frmlytSch65 = new FormLayout();
		frmlytSch65.setLabelWidth(250);
		frmlytSch65.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_161.setLayout(frmlytSch65);

		frgrLbrrErinImnRcpnDt = new MSFDateField();
		frgrLbrrErinImnRcpnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgrLbrrErinImnRcpnDt.setName("frgrLbrrErinImnRcpnDt");
	    new DateFieldMask(frgrLbrrErinImnRcpnDt, "9999.99.99");
		frgrLbrrErinImnRcpnDt.setFieldLabel("근로소득에 대한 조세조약상 면제 접수일자");
		
		layoutContainer_161.add(frgrLbrrErinImnRcpnDt, new FormData("100%"));
		layoutContainer_153.add(layoutContainer_161);
		  
		  
		layoutContainer_151.add(layoutContainer_153, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		  
		LayoutContainer layoutContainer_154 = new LayoutContainer();
		  
		// 감면기간 만료일
		LayoutContainer layoutContainer_158 = new LayoutContainer();

		FormLayout frmlytSch66 = new FormLayout();
		frmlytSch66.setLabelWidth(100);
		frmlytSch66.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_158.setLayout(frmlytSch66);

		frgrLbrrReExryDt = new MSFDateField();
		frgrLbrrReExryDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgrLbrrReExryDt.setName("frgrLbrrReExryDt");
	    new DateFieldMask(frgrLbrrReExryDt, "9999.99.99");
		frgrLbrrReExryDt.setFieldLabel("감면기간 만료일");
		
		layoutContainer_158.add(frgrLbrrReExryDt, new FormData("100%"));
		layoutContainer_154.add(layoutContainer_158);

		//세액공제_외국인_감면신청 제출일자
		LayoutContainer layoutContainer_159 = new LayoutContainer();

		FormLayout frmlytSch67 = new FormLayout();
		frmlytSch67.setLabelWidth(100);
		frmlytSch67.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_159.setLayout(frmlytSch67);

		frgrLbrrReAlfaSbmsDt = new MSFDateField();
		frgrLbrrReAlfaSbmsDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgrLbrrReAlfaSbmsDt.setName("frgrLbrrReAlfaSbmsDt");
	    new DateFieldMask(frgrLbrrReAlfaSbmsDt, "9999.99.99");
	    frgrLbrrReAlfaSbmsDt.setFieldLabel("제출일자");
	    
		layoutContainer_159.add(frgrLbrrReAlfaSbmsDt, new FormData("100%"));
		layoutContainer_154.add(layoutContainer_159);
		  
//		//세액공제_외국인해저광물개발감면 신청일자
//		LayoutContainer layoutContainer_160 = new LayoutContainer();
//
//		FormLayout frmlytSch68 = new FormLayout();
//		frmlytSch68.setLabelWidth(100);
//		frmlytSch68.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_160.setLayout(frmlytSch68);
//
//		txlgFrid = new MSFDateField();
//		txlgFrid.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		txlgFrid.setName("txlgFrid");
//	    new DateFieldMask(txlgFrid, "9999.99.99");
//		layoutContainer_160.add(txlgFrid, new FormData("100%"));
//		txlgFrid.setFieldLabel("신청일자");
//		layoutContainer_154.add(layoutContainer_160);
		  
		//세액공제_근로소득조세조약상면제 제출일자
		LayoutContainer layoutContainer_162 = new LayoutContainer();

		FormLayout frmlytSch69 = new FormLayout();
		frmlytSch69.setLabelWidth(100);
		frmlytSch69.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_162.setLayout(frmlytSch69);

		frgrLbrrErinImnSbmsDt = new MSFDateField();
		frgrLbrrErinImnSbmsDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgrLbrrErinImnSbmsDt.setName("frgrLbrrErinImnSbmsDt");
	    new DateFieldMask(frgrLbrrErinImnSbmsDt, "9999.99.99");
		frgrLbrrErinImnSbmsDt.setFieldLabel("제출일자");
		
		layoutContainer_162.add(frgrLbrrErinImnSbmsDt, new FormData("100%"));
		layoutContainer_154.add(layoutContainer_162);
		  
		// 세액감면
		layoutContainer_151.add(layoutContainer_154, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));

		fldstNewFieldset_8.add(layoutContainer_151);
		layoutContainer_147.add(fldstNewFieldset_8);

		layoutContainer_16.add(layoutContainer_147);

		//
		LayoutContainer layoutContainer_148 = new LayoutContainer();
		layoutContainer_148.setLayout(new ColumnLayout());
		  
		  
		// 중소기업 취업 청년가면 취업일자
		LayoutContainer layoutContainer_163 = new LayoutContainer();

		FormLayout frmlytSch70 = new FormLayout();
		frmlytSch70.setLabelWidth(230);
		frmlytSch70.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_163.setLayout(frmlytSch70);

		yupSnmcReStrtDt = new MSFDateField();
		yupSnmcReStrtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		yupSnmcReStrtDt.setName("yupSnmcReStrtDt");
	    new DateFieldMask(yupSnmcReStrtDt, "9999.99.99");
	    yupSnmcReStrtDt.setFieldLabel("중소기업 취업 청년감면 취업일자 ");
	    
		layoutContainer_163.add(yupSnmcReStrtDt, new FormData("100%"));
		layoutContainer_148.add(layoutContainer_163, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));

		//세액공제_중소기업청년감면 감면기간 종료일
		LayoutContainer layoutContainer_164 = new LayoutContainer();

		FormLayout frmlytSch71 = new FormLayout();
		frmlytSch71.setLabelWidth(100);
		frmlytSch71.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_164.setLayout(frmlytSch71);

		yupSnmcReEndDt = new MSFDateField();
		yupSnmcReEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		yupSnmcReEndDt.setName("yupSnmcReEndDt");
		yupSnmcReEndDt.setFieldLabel("감면기간 종료일");
	    new DateFieldMask(yupSnmcReEndDt, "9999.99.99");
	    
		layoutContainer_164.add(yupSnmcReEndDt, new FormData("100%"));
		layoutContainer_148.add(layoutContainer_164, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		  
		  
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

		txlgItctAmnt = new MSFNumberField();
		txlgItctAmnt.setFieldLabel("소득세법 감면세액");
		txlgItctAmnt.setAllowDecimals(true); 
		txlgItctAmnt.setPropertyEditorType(Long.class); 
		txlgItctAmnt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_168.add(txlgItctAmnt, new FormData("100%"));
		layoutContainer_165.add(layoutContainer_168);
		
		// 외국인기술자 감면세액
		LayoutContainer layoutContainer_171 = new LayoutContainer();

		FormLayout frmlytSch103 = new FormLayout();
		frmlytSch103.setLabelWidth(150);
		frmlytSch103.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_171.setLayout(frmlytSch103);

		txlgFrtaAmnt = new MSFNumberField();
		txlgFrtaAmnt = new MSFNumberField();
		txlgFrtaAmnt.setFieldLabel("외국인기술자 감면세액");
		txlgFrtaAmnt.setAllowDecimals(true); 
		txlgFrtaAmnt.setPropertyEditorType(Long.class); 
		txlgFrtaAmnt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_171.add(txlgFrtaAmnt, new FormData("100%"));
		layoutContainer_165.add(layoutContainer_171);

		// 취업청년감면대상총급여
		LayoutContainer layoutContainer_169 = new LayoutContainer();

		FormLayout frmlytSch101 = new FormLayout();
		frmlytSch101.setLabelWidth(150);
		frmlytSch101.setLabelAlign(LabelAlign.RIGHT);
		  
		layoutContainer_169.setLayout(frmlytSch101);

		txlgBstaAmnt = new MSFNumberField();
		txlgBstaAmnt.setFieldLabel("취업청년감면대상총급여");
		txlgBstaAmnt.setAllowDecimals(true); 
		txlgBstaAmnt.setPropertyEditorType(Long.class); 
		txlgBstaAmnt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_169.add(txlgBstaAmnt, new FormData("100%"));
		layoutContainer_165.add(layoutContainer_169);
		

		// 계산 감면세액
		LayoutContainer layoutContainer_170 = new LayoutContainer();

		FormLayout frmlytSch102 = new FormLayout();
		frmlytSch102.setLabelWidth(150);
		frmlytSch102.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_170.setLayout(frmlytSch102);

		txlgCltaAmnt = new MSFNumberField();
		txlgCltaAmnt.setReadOnly(false);
		txlgCltaAmnt.setFieldLabel("계산 감면세액");
		txlgCltaAmnt.setAllowDecimals(true); 
		txlgCltaAmnt.setPropertyEditorType(Long.class); 
		txlgCltaAmnt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_170.add(txlgCltaAmnt, new FormData("100%"));
		layoutContainer_165.add(layoutContainer_170);
		
		
		// 조세조약 감면세액
		LayoutContainer layoutContainer_172 = new LayoutContainer();

		FormLayout frmlytSch104 = new FormLayout();
		frmlytSch104.setLabelWidth(150);
		frmlytSch104.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_172.setLayout(frmlytSch104);
		
		txlgTxtyAmnt = new MSFNumberField();
		txlgTxtyAmnt.setFieldLabel("조세조약 감면세액");
		txlgTxtyAmnt.setAllowDecimals(true); 
		txlgTxtyAmnt.setPropertyEditorType(Long.class); 
		txlgTxtyAmnt.setFormat(NumberFormat.getDecimalFormat());
				
		layoutContainer_172.add(txlgTxtyAmnt, new FormData("100%"));
		layoutContainer_165.add(layoutContainer_172);
		
		
		  
		layoutContainer_166.add(layoutContainer_165, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		  
		  
		LayoutContainer layoutContainer_167 = new LayoutContainer();

		// 감면세액 세액감면_소득세법
		LayoutContainer layoutContainer_173 = new LayoutContainer();
		  
		FormLayout frmlytSch105 = new FormLayout();
		frmlytSch105.setLabelWidth(80);
		frmlytSch105.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_173.setLayout(frmlytSch105);

		yetaC114 = new MSFNumberField();
		yetaC114.setFieldLabel("감면세액");
		yetaC114.setAllowDecimals(true); 
		yetaC114.setPropertyEditorType(Long.class); 
		yetaC114.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_173.add(yetaC114, new FormData("100%"));
		layoutContainer_167.add(layoutContainer_173);
		
		// 감면세액 세액공제_외국인감면세액
		LayoutContainer layoutContainer_176 = new LayoutContainer();

		FormLayout frmlytSch108 = new FormLayout();
		frmlytSch108.setLabelWidth(80);
		frmlytSch108.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_176.setLayout(frmlytSch108);

		yetaC115 = new MSFNumberField();
		yetaC115.setReadOnly(true);
		yetaC115.setFieldLabel("감면세액");
		yetaC115.setAllowDecimals(true); 
		yetaC115.setPropertyEditorType(Long.class); 
		yetaC115.setFormat(NumberFormat.getDecimalFormat());
				
		layoutContainer_176.add(yetaC115, new FormData("100%"));
		layoutContainer_167.add(layoutContainer_176);

		// 근로자총급여 세액공제_근로소득세액공제
		LayoutContainer layoutContainer_174 = new LayoutContainer();

		FormLayout frmlytSch106 = new FormLayout();
		frmlytSch106.setLabelWidth(80);
		frmlytSch106.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_174.setLayout(frmlytSch106);

		txlgWktaAmnt = new MSFNumberField();
		txlgWktaAmnt.setReadOnly(true);
		txlgWktaAmnt.setFieldLabel("근로자총급여");
		txlgWktaAmnt.setAllowDecimals(true); 
		txlgWktaAmnt.setPropertyEditorType(Long.class); 
		txlgWktaAmnt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_174.add(txlgWktaAmnt, new FormData("100%"));
		layoutContainer_167.add(layoutContainer_174);
		
		
		// 감면세액 세액감면_감면세액계
		LayoutContainer layoutContainer_175 = new LayoutContainer();

		FormLayout frmlytSch107 = new FormLayout();
		frmlytSch107.setLabelWidth(80);
		frmlytSch107.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_175.setLayout(frmlytSch107);

		yetaC116 = new MSFNumberField();
		yetaC116.setReadOnly(true);
		yetaC116.setFieldLabel("감면세액");
		yetaC116.setAllowDecimals(true); 
		yetaC116.setPropertyEditorType(Long.class); 
		yetaC116.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_175.add(yetaC116, new FormData("100%"));
		layoutContainer_167.add(layoutContainer_175);
		
		
		// 감면세액 세액감면_조세조약
		LayoutContainer layoutContainer_177 = new LayoutContainer();

		FormLayout frmlytSch109 = new FormLayout();
		frmlytSch109.setLabelWidth(80);
		frmlytSch109.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_177.setLayout(frmlytSch109);

		yetaC117 = new MSFNumberField();
		yetaC117.setReadOnly(true);
		yetaC117.setFieldLabel("감면세액");
		yetaC117.setAllowDecimals(true); 
		yetaC117.setPropertyEditorType(Long.class); 
		yetaC117.setFormat(NumberFormat.getDecimalFormat());
				
		layoutContainer_177.add(yetaC117, new FormData("100%"));
		layoutContainer_167.add(layoutContainer_177);

		
		layoutContainer_166.add(layoutContainer_167, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		  
		  
		fldstNewFieldset_9.add(layoutContainer_166);

		layoutContainer_149.add(fldstNewFieldset_9);
		fldstNewFieldset_9.setHeadingHtml("세액감면");
		layoutContainer_16.add(layoutContainer_149);

		// 외국납부세액공제
		LayoutContainer layoutContainer_150 = new LayoutContainer();

		FieldSet fldstNewFieldset_10 = new FieldSet();
		fldstNewFieldset_10.setHeadingHtml("외국납부세액공제");
		
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

		ovrsSurcIncFmt= new MSFNumberField();
		ovrsSurcIncFmt.setFieldLabel("국외원천소득");
		ovrsSurcIncFmt.setAllowDecimals(true); 
		ovrsSurcIncFmt.setPropertyEditorType(Long.class); 
		ovrsSurcIncFmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_276.add(ovrsSurcIncFmt, new FormData("90%"));
		layoutContainer_272.add(layoutContainer_276, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  
		  
		//납세액(외화)
		LayoutContainer layoutContainer_280 = new LayoutContainer();

		FormLayout frmlytSch121 = new FormLayout();
		frmlytSch121.setLabelWidth(80);
		frmlytSch121.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_280.setLayout(frmlytSch121);

		frgnPmtFcTxamt = new MSFNumberField();
		frgnPmtFcTxamt.setFieldLabel("납세액(외화)");
		frgnPmtFcTxamt.setAllowDecimals(true); 
		frgnPmtFcTxamt.setPropertyEditorType(Long.class); 
		frgnPmtFcTxamt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_280.add(frgnPmtFcTxamt, new FormData("90%"));
		layoutContainer_272.add(layoutContainer_280,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		layoutContainer_268.add(layoutContainer_272);
		fldstNewFieldset_10.add(layoutContainer_268);

		LayoutContainer layoutContainer_264 = new LayoutContainer();
		layoutContainer_264.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_265 = new LayoutContainer();

		// 납세액(원화)
		LayoutContainer layoutContainer_269 = new LayoutContainer();

		FormLayout frmlytSch122 = new FormLayout();
		frmlytSch122.setLabelWidth(80);
		frmlytSch122.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_269.setLayout(frmlytSch122);

		frgnPmtWcTxamt = new MSFNumberField();
		frgnPmtWcTxamt.setFieldLabel("납세액(원화)");
		frgnPmtWcTxamt.setAllowDecimals(true); 
		frgnPmtWcTxamt.setPropertyEditorType(Long.class); 
		frgnPmtWcTxamt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_269.add(frgnPmtWcTxamt, new FormData("100%"));
		layoutContainer_265.add(layoutContainer_269);
		  
		// 신청서제출일
		LayoutContainer layoutContainer_270 = new LayoutContainer();

		FormLayout frmlytSch123 = new FormLayout();
		frmlytSch123.setLabelWidth(80);
		frmlytSch123.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_270.setLayout(frmlytSch123);

		frgnPmtTxamtAlfaSbmsDt = new MSFDateField();
		frgnPmtTxamtAlfaSbmsDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgnPmtTxamtAlfaSbmsDt.setName("frgnPmtTxamtAlfaSbmsDt");
	    new DateFieldMask(frgnPmtTxamtAlfaSbmsDt, "9999.99.99");
		frgnPmtTxamtAlfaSbmsDt.setFieldLabel("신청서제출일");
		
		layoutContainer_270.add(frgnPmtTxamtAlfaSbmsDt, new FormData("100%"));
		layoutContainer_265.add(layoutContainer_270);
		  
		//세액공제_외국납부_근무시작일자
		LayoutContainer layoutContainer_271 = new LayoutContainer();

		FormLayout frmlytSch124 = new FormLayout();
		frmlytSch124.setLabelWidth(80);
		frmlytSch124.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_271.setLayout(frmlytSch124);

		frgnDtyTermStdt = new MSFDateField();
		frgnDtyTermStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgnDtyTermStdt.setName("frgnDtyTermStdt");
	    new DateFieldMask(frgnDtyTermStdt, "9999.99.99");
	    frgnDtyTermStdt.setFieldLabel("근무기간");
	    
		layoutContainer_271.add(frgnDtyTermStdt, new FormData("100%"));
		layoutContainer_265.add(layoutContainer_271);
		  
		layoutContainer_264.add(layoutContainer_265, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		  
		LayoutContainer layoutContainer_266 = new LayoutContainer();

		// 납세국명
		LayoutContainer layoutContainer_273 = new LayoutContainer();

		FormLayout frmlytSch125 = new FormLayout();
		frmlytSch125.setLabelWidth(80);
		frmlytSch125.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_273.setLayout(frmlytSch125);

		frgnPmtTxamtTxpNtnNm = new MSFTextField();
		frgnPmtTxamtTxpNtnNm.setFieldLabel("납세국명");
		
		layoutContainer_273.add(frgnPmtTxamtTxpNtnNm, new FormData("100%"));
		layoutContainer_266.add(layoutContainer_273);

		// 국외근무처
		LayoutContainer layoutContainer_274 = new LayoutContainer();

		FormLayout frmlytSch126 = new FormLayout();
		frmlytSch126.setLabelWidth(80);
		frmlytSch126.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_274.setLayout(frmlytSch126);
		  
		frgnPmtTxamtAbrdWkarNm = new MSFTextField();
		frgnPmtTxamtAbrdWkarNm.setFieldLabel("국외근무처");
		
		layoutContainer_274.add(frgnPmtTxamtAbrdWkarNm, new FormData("100%"));
		layoutContainer_266.add(layoutContainer_274);

		LayoutContainer layoutContainer_275 = new LayoutContainer();

		FormLayout frmlytSch127 = new FormLayout();
		frmlytSch127.setLabelWidth(10);
		frmlytSch127.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_275.setLayout(frmlytSch127);

		//세액공제_외국납부_근무종료일자
		frgnDtyTermEddt = new MSFDateField();
		frgnDtyTermEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgnDtyTermEddt.setName("frgnDtyTermEddt");
	    new DateFieldMask(frgnDtyTermEddt, "9999.99.99");
		frgnDtyTermEddt.setLabelSeparator("~");
		
		layoutContainer_275.add(frgnDtyTermEddt, new FormData("80%"));
		layoutContainer_266.add(layoutContainer_275);
		  
		  
		layoutContainer_264.add(layoutContainer_266, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		  
		LayoutContainer layoutContainer_267 = new LayoutContainer();
		  
		  
		// 납부일
		LayoutContainer layoutContainer_277 = new LayoutContainer();

		FormLayout frmlytSch128 = new FormLayout();
		frmlytSch128.setLabelWidth(80);
		frmlytSch128.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_277.setLayout(frmlytSch128);

		frgnPmtTxamtPmtDt = new MSFDateField();
		frgnPmtTxamtPmtDt.setFieldLabel("납부일");
		frgnPmtTxamtPmtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		frgnPmtTxamtPmtDt.setName("frgnPmtTxamtPmtDt");
	    new DateFieldMask(frgnPmtTxamtPmtDt, "9999.99.99");
		
		layoutContainer_277.add(frgnPmtTxamtPmtDt, new FormData("100%"));
		layoutContainer_267.add(layoutContainer_277);

		// 직책
		LayoutContainer layoutContainer_278 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_278.setLayout(frmlytSch);

		frgnPmtTxamtRfoNm = new MSFTextField();
		frgnPmtTxamtRfoNm.setFieldLabel("직책");
		
		layoutContainer_278.add(frgnPmtTxamtRfoNm, new FormData("100%"));
		layoutContainer_267.add(layoutContainer_278);
		

		LayoutContainer layoutContainer_279 = new LayoutContainer();
		layoutContainer_267.add(layoutContainer_279);
		  
		  
		layoutContainer_264.add(layoutContainer_267, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		  
		  
		layoutContainer_268.add(layoutContainer_264);
		layoutContainer_150.add(fldstNewFieldset_10);
		layoutContainer_16.add(layoutContainer_150);
		
		
		FieldSet fldstNewFieldset_22 = new FieldSet();
		fldstNewFieldset_22.setHeadingHtml("월세액_세액공제");
		  
		LayoutContainer layoutContainer_315 = new LayoutContainer();
		layoutContainer_315.setLayout(new ColumnLayout());
		  
		LayoutContainer layoutContainer_314 = new LayoutContainer();
		  
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		layoutContainer_314.setLayout(frmlytSch);
		  
		Button btnNewButton_16 = new Button("월세액등록");
		btnNewButton_16.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 전체내역
				YetaP73005 yetaP23005Form = new YetaP73005(ActionDatabase.READ,getThis());

				MSFFormWindows msFwYeta73005 = new MSFFormWindows("월세액소득공제명세",yetaP23005Form, "닫기", "820px", "510px", true);
				msFwYeta73005.show();
				yetaP23005Form.setMSFFormWindows(msFwYeta73005);
				
				msFwYeta73005.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			getItemYeta09();
		    		}
				});

				funcSetPopUpRecord();
				yetaP23005Form.bind(ppRecord);
			}
		});
		layoutContainer_314.add(btnNewButton_16, new FormData("100%"));
		layoutContainer_315.add(layoutContainer_314,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		
		LayoutContainer layoutContainer_316 = new LayoutContainer();

		// 지출금액
		LayoutContainer layoutContainer_456 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_456.setLayout(frmlytSch);

		mmrUseAmt = new MSFNumberField();
		mmrUseAmt.setReadOnly(true);
		mmrUseAmt.setAllowDecimals(true);
		mmrUseAmt.setPropertyEditorType(Long.class);
		mmrUseAmt.setFormat(NumberFormat.getDecimalFormat());
		mmrUseAmt.setFieldLabel("지출금액");

		layoutContainer_456.add(mmrUseAmt, new FormData("100%"));

		layoutContainer_316.add(layoutContainer_456, new FormData("100%"));
		layoutContainer_315.add(layoutContainer_316,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		
		LayoutContainer layoutContainer_317 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_317.setLayout(frmlytSch);
		
		
		// 특별공제_주택자금월세공제액
		LayoutContainer layoutContainer_458 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_458.setLayout(frmlytSch);

		mmrDdcAmt = new MSFNumberField();
		mmrDdcAmt.setReadOnly(true);
		mmrDdcAmt.setAllowDecimals(true);
		mmrDdcAmt.setPropertyEditorType(Long.class);
		mmrDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		mmrDdcAmt.setFieldLabel("공제액");

		layoutContainer_458.add(mmrDdcAmt, new FormData("100%"));

		layoutContainer_317.add(layoutContainer_458, new FormData("100%"));
		layoutContainer_315.add(layoutContainer_317,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));

		fldstNewFieldset_22.add(layoutContainer_315, new FormData("100%"));
		layoutContainer_16.add(fldstNewFieldset_22);
		
		//
		LayoutContainer layoutContainer_17 = new LayoutContainer();
		layoutContainer_17.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_258 = new LayoutContainer();

		// 납세조합원청징수세액(10%)
//		LayoutContainer layoutContainer_260 = new LayoutContainer();
//
//		FormLayout frmlytSch110 = new FormLayout();
//		frmlytSch110.setLabelWidth(270);
//		frmlytSch110.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_260.setLayout(frmlytSch110);
//
//		taxdUnin = new MSFNumberField();
//		taxdUnin.setFieldLabel("납세조합원청징수세액(10%)");
//		taxdUnin.setAllowDecimals(true); 
//		taxdUnin.setPropertyEditorType(Long.class); 
//		taxdUnin.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_260.add(taxdUnin, new FormData("100%"));
//		layoutContainer_258.add(layoutContainer_260);

		// 주택자금차입금이자세액공제 이자상환/공제액
		LayoutContainer layoutContainer_261 = new LayoutContainer();

		FormLayout frmlytSch111 = new FormLayout();
		frmlytSch111.setLabelWidth(270);
		frmlytSch111.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_261.setLayout(frmlytSch111);

		hsngTennLnpbUseAmt = new MSFNumberField();
		hsngTennLnpbUseAmt.setFieldLabel("주택자금차입금이자세액공제 이자상환/공제액");
		hsngTennLnpbUseAmt.setAllowDecimals(true); 
		hsngTennLnpbUseAmt.setPropertyEditorType(Long.class); 
		hsngTennLnpbUseAmt.setFormat(NumberFormat.getDecimalFormat());
		
		layoutContainer_261.add(hsngTennLnpbUseAmt, new FormData("100%"));
		layoutContainer_258.add(layoutContainer_261);
		  
		  
		layoutContainer_17.add(layoutContainer_258, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		  
		LayoutContainer layoutContainer_259 = new LayoutContainer();

		// 납세조합공제액
//		LayoutContainer layoutContainer_262 = new LayoutContainer();
//
//		FormLayout frmlytSch112 = new FormLayout();
//		frmlytSch112.setLabelWidth(100);
//		frmlytSch112.setLabelAlign(LabelAlign.RIGHT);
//
//		layoutContainer_262.setLayout(frmlytSch112);
//
//		taxdUnin01 = new MSFNumberField();
//		taxdUnin01.setReadOnly(true);
//		taxdUnin01.setFieldLabel("납세조합공제액");
//		taxdUnin01.setAllowDecimals(true); 
//		taxdUnin01.setPropertyEditorType(Long.class); 
//		taxdUnin01.setFormat(NumberFormat.getDecimalFormat());
//		
//		layoutContainer_262.add(taxdUnin01, new FormData("100%"));
//		layoutContainer_259.add(layoutContainer_262);

		LayoutContainer layoutContainer_263 = new LayoutContainer();

		//세액공제_주택차입금 공제액
		hsngTennLnpbDdcAmt = new MSFNumberField();
		hsngTennLnpbDdcAmt.setReadOnly(true);
		layoutContainer_263.add(hsngTennLnpbDdcAmt);
		hsngTennLnpbDdcAmt.setAllowDecimals(true); 
		hsngTennLnpbDdcAmt.setPropertyEditorType(Long.class); 
		hsngTennLnpbDdcAmt.setFormat(NumberFormat.getDecimalFormat());
		
		
		layoutContainer_259.add(layoutContainer_263);
		layoutContainer_17.add(layoutContainer_259, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		  
		  
		  //layoutContainer_17.add(fldstNewFieldset_12);
		// fldstNewFieldset_12.setHeadingHtml("");
		layoutContainer_16.add(layoutContainer_17);

		cp01.add(layoutContainer_16);
		layoutContainer_16.setHeight("570");
		cp01.add(cp01);
		cp01.setHeight("565");
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
		
	}	
	
	private LayoutContainer yetaData10() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setHeadingText("");
		cp01.setSize("660", "590");

		LayoutContainer layoutContainer_178 = new LayoutContainer();

		LayoutContainer layoutContainer_179 = new LayoutContainer();

		FieldSet fldstNewFieldset_13 = new FieldSet();

		LayoutContainer layoutContainer_182 = new LayoutContainer();

		// 1. 외국인근로자..
		LayoutContainer layoutContainer_193 = new LayoutContainer();
		layoutContainer_193.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_26 = new LabelField("1.외국인근로자 단일세율적용신청서 제출여부");
		layoutContainer_193.setStyleAttribute("verticalAlign","middle");
		layoutContainer_193.add(lblfldNewLabelfield_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		d219 = new RadioGroup();
		d219.setFieldLabel("1.외국인근로자 단일세율적용신청서 제출여부");
		d219.setHideLabel(false);
		
		Radio fornrSgyn0 = new Radio();
//		layoutContainer_193.add(rdNewRadio_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		d219.add(fornrSgyn0);
		fornrSgyn0.setBoxLabel("미제출");
		fornrSgyn0.setHideLabel(true);
		fornrSgyn0.setValueAttribute("0");


		Radio fornrSgyn1 = new Radio();
		d219.add(fornrSgyn1);
//		layoutContainer_193.add(rdNewRadio_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		fornrSgyn1.setBoxLabel("제출");
		fornrSgyn1.setHideLabel(true);
		fornrSgyn1.setValueAttribute("1");
		
		layoutContainer_193.add(d219);
		layoutContainer_182.add(layoutContainer_193);
		layoutContainer_193.setBorders(false);

		// 2.연금,저축 등 소득공제 명세서 제출여부
		LayoutContainer layoutContainer_194 = new LayoutContainer();
		layoutContainer_194.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_27 = new LabelField("2.연금,저축 등 소득공제 명세서 제출여부");
		layoutContainer_194.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_194.add(lblfldNewLabelfield_27, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		cd225 = new RadioGroup();
		
		Radio cd2250 = new Radio();
//		layoutContainer_194.add(rdNewRadio_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		cd225.add(cd2250);
		cd2250.setBoxLabel("미제출");
		cd2250.setHideLabel(true);
		cd2250.setValueAttribute("0");


		Radio cd2251 = new Radio();
//		layoutContainer_194.add(rdNewRadio_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		cd225.add(cd2251);
		cd2251.setBoxLabel("제출");
		cd2251.setHideLabel(true);
		cd2251.setValueAttribute("1");

		
//		layoutContainer_194.add(cd225);

		layoutContainer_182.add(layoutContainer_194);
		layoutContainer_194.add(cd225);
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

		cd226 = new RadioGroup();
		
		Radio cd2260 = new Radio();
//		layoutContainer_198.add(rdNewRadio_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		cd226.add(cd2260);
		cd2260.setBoxLabel("미제출");
		cd2260.setHideLabel(true);
		cd2260.setValueAttribute("0");


		Radio cd2261 = new Radio();
//		layoutContainer_198.add(rdNewRadio_19, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		cd226.add(cd2261);
		cd2261.setBoxLabel("제출");
		cd2261.setHideLabel(true);
		cd2261.setValueAttribute("1");
		
		layoutContainer_198.add(cd226);

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
		
		cd227 = new RadioGroup();

		Radio addcMnN = new Radio();
//		layoutContainer_191.add(rdNewRadio_8);
		cd227.add(addcMnN);
		addcMnN.setBoxLabel("미제출");
		addcMnN.setHideLabel(true);
		addcMnN.setValueAttribute("0");

		Radio addcMnY = new Radio();
		cd227.add(addcMnY);
//		layoutContainer_191.add(rdNewRadio_9);
		addcMnY.setBoxLabel("제출");
		addcMnY.setHideLabel(true);
		addcMnY.setValueAttribute("1");
		
		layoutContainer_191.add(cd227);

//		layoutContainer_189.add(cd227);
		layoutContainer_189.add(layoutContainer_191);
		layoutContainer_191.setBorders(false);

		// ③ 소득공제 증빙서류
		LayoutContainer layoutContainer_192 = new LayoutContainer();
		layoutContainer_192.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_24 = new LabelField("③ 소득공제 증빙서류     : ");
		layoutContainer_192.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_192.add(lblfldNewLabelfield_24);
		
		prcspWorkIncmSumtYn = new RadioGroup();

		Radio prcspWorkIncmSumtYn0 = new Radio();
		prcspWorkIncmSumtYn.add(prcspWorkIncmSumtYn0);
		prcspWorkIncmSumtYn0.setBoxLabel("미제출");
		prcspWorkIncmSumtYn0.setHideLabel(true);
		prcspWorkIncmSumtYn0.setValueAttribute("0");

		Radio prcspWorkIncmSumtYn1 = new Radio();
		prcspWorkIncmSumtYn.add(prcspWorkIncmSumtYn1);
		prcspWorkIncmSumtYn1.setBoxLabel("제출");
		prcspWorkIncmSumtYn1.setHideLabel(true);
		prcspWorkIncmSumtYn1.setValueAttribute("1");
		
		layoutContainer_192.setBorders(false);
		layoutContainer_192.add(prcspWorkIncmSumtYn);
		

		layoutContainer_189.add(layoutContainer_192);
		layoutContainer_189.setBorders(false);
		
		layoutContainer_188.add(layoutContainer_189, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		
		
		// ② 기부금명세서
		LayoutContainer layoutContainer_190 = new LayoutContainer();
		layoutContainer_190.setLayout(new ColumnLayout());

		LabelField lblfldNewLabelfield_25 = new LabelField("② 기부금명세서     : ");
		layoutContainer_190.setStyleAttribute("verticalAlign","bottom");
		layoutContainer_190.add(lblfldNewLabelfield_25);
		
		cd228 = new RadioGroup();

		Radio addcCtN = new Radio();
		cd228.add(addcCtN);
		addcCtN.setBoxLabel("미제출");
		addcCtN.setHideLabel(true);
		addcCtN.setValueAttribute("0");

		Radio addcCtY = new Radio();
		cd228.add(addcCtY);
		addcCtY.setBoxLabel("제출");
		addcCtY.setHideLabel(true);
		addcCtY.setValueAttribute("1");
		layoutContainer_190.add(cd228);
		
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

		fileAppPaprSbtYn = new RadioGroup();
		
		Radio fileAppPaprSbtYnN = new Radio();
//		layoutContainer_186.add(rdNewRadio_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		fileAppPaprSbtYn.add(fileAppPaprSbtYnN);
		fileAppPaprSbtYnN.setBoxLabel("미제출");
		fileAppPaprSbtYnN.setHideLabel(true);
		fileAppPaprSbtYnN.setValueAttribute("0");
		
		Radio fileAppPaprSbtYnY = new Radio();
		fileAppPaprSbtYn.add(fileAppPaprSbtYnY); 
		fileAppPaprSbtYnY.setBoxLabel("제출");
		fileAppPaprSbtYnY.setHideLabel(true);
		fileAppPaprSbtYnY.setValueAttribute("1");
		
		layoutContainer_186.add(fileAppPaprSbtYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		layoutContainer_184.add(layoutContainer_186, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//		layoutContainer_184.add(fileAppPaprSbtYn);

		// 제출일자
		LayoutContainer layoutContainer_187 = new LayoutContainer();

		FormLayout frmlytSch72 = new FormLayout();
		frmlytSch72.setLabelWidth(130);
		frmlytSch72.setLabelAlign(LabelAlign.RIGHT);

		layoutContainer_187.setLayout(frmlytSch72);

		incmDducWtnnteSumtDt = new MSFDateField();
		new DateFieldMask(incmDducWtnnteSumtDt, "9999.99.99");
		incmDducWtnnteSumtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		incmDducWtnnteSumtDt.setFieldLabel("제출일자");
		
		layoutContainer_187.add(incmDducWtnnteSumtDt, new FormData("100%"));
		layoutContainer_184.add(layoutContainer_187);
		layoutContainer_183.add(layoutContainer_184, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer_185 = new LayoutContainer();
		layoutContainer_183.add(layoutContainer_185, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fldstNewFieldset_12.add(layoutContainer_183);
		layoutContainer_178.add(layoutContainer_181);
	
		cp01.add(layoutContainer_178);
		lcTabFormLayer.add(cp01);
		
		return lcTabFormLayer;
	}
	
	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}
	
	private Yeta7300 getThis(){
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
							rsplNtnInfrCd.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCd")));		//국가코드(Hidden)
							rsplNtnInfrNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));		//국가명
		                	rsplNtnInfrItem.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeItem12")));	//국가코드Item
						}else if("redt".equals(fnFalg)) {
							//거주지국
						    rsplNtnCd.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCd")));		//거주지국코드
						    rsplNtnNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));		//거주지국명
						    rsplNtnItem.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeItem12")));	//거주지국 두자리
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
		
		// 인적공제
		if("Ye161030".equals(yetaFlag)) {
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
						List<Ye161030DTO> listYe161030Dto = new ArrayList<Ye161030DTO>();  
						
						while (iterRecords.hasNext()) {
							BaseModel bmMapModel = (BaseModel) iterRecords.next();
							//건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
							Ye161030DTO ye161030Dto = new Ye161030DTO();  
	                        
							ye161030Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
							ye161030Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   					/** column SYSTEMKEY : systemkey */
	                        ye161030Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    													/** column 귀속연도 : yrtxBlggYr */
	                        ye161030Dto.setClutSeptCd(clutSeptCd.getValue());    													/** column 연말정산구분코드 : clutSeptCd */
	                        ye161030Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   	 				/** column SYSTEMKEY : systemkey */
	                        ye161030Dto.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum")));    		/** column 주민등록번호 : txprDscmNoCntn */
	                        ye161030Dto.setSuptFmlyRltClCd(MSFSharedUtils.allowNulls(bmMapModel.get("famySupptRelaDivCd")));		/** column 부양관계코드 : suptFmlyRltClCd */
	                        ye161030Dto.setNnfClCd(MSFSharedUtils.defaultNulls(bmMapModel.get("nnfClCd"), "1"));					/** column 내외국인구분 : nnfClCd */
	                        ye161030Dto.setTxprNm(MSFSharedUtils.allowNulls( bmMapModel.get("famyNm")));    						/** column 성명 : txprNm */
	                        ye161030Dto.setBscDdcClCd(false);    																	/** column 기본공제여부 : bscDdcClCd */
	                        ye161030Dto.setWmnDdcClCd(false);    																	/** column 부녀자여부 : wmnDdcClCd */
	                        ye161030Dto.setSnprntFmlyDdcClCd(false);    															/** column 한부모여부 : snprntFmlyDdcClCd */
	                        ye161030Dto.setSccDdcClCd(false);    																	/** column 경로우대여부 : sccDdcClCd */
	                        ye161030Dto.setDsbrDdcClCd(MSFSharedUtils.defaultNulls(bmMapModel.get("dsbrDdcClCd"), "Y0080004")); 	/** column 장애인여부 : dsbrDdcClCd */
	                        ye161030Dto.setChbtAtprDdcClCd("Y0210000");    																/** column 출산입양여부 : chbtAtprDdcClCd */
	                        ye161030Dto.setSchoolYn(false);
	                        ye161030Dto.setEduDdcDvcd(false);    																	/** column 교육비공제구분 : eduDdcDvcd */
	                        ye161030Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));    			/** column 인사가족관계코드 : famyRelaDivCd */
	                       
	                        listYe161030Dto.add(ye161030Dto);
	                        
						}    
		                 
						yeta7300Service.activityOnYeta7300ToYe161030(listYe161030Dto, actionDatabase, new AsyncCallback<Long>() {
		                         
							public void onFailure(Throwable caught) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
									MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta7300ToYe161030(" + actionDatabase.name() + ") : " + caught), null);
							}
							public void onSuccess(Long result) {  
								reloadYe161030();
							}   
						});
					}  
				}
			});
		
		// 가족교육비	
		}else if("Ye161090".equals(yetaFlag)) {
			
//			PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
//			sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
//			sysComPsnl0115Dto.setSystemkey(systemkey.getValue());//systemKey 넘김.
//		      
//			MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto);  //인사  
//		      
//			final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
//		      
//			popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
//				public void handleEvent(BaseEvent be) {
//					List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
//		               
//					if (mapModels != null) { 
//						actionDatabase = ActionDatabase.INSERT;
//						
//						Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
//						List<Ye161090DTO> listYe161090Dto = new ArrayList<Ye161090DTO>();  
//						Ye161090DTO ye161090Dto = new Ye161090DTO();  
//						while (iterRecords.hasNext()) {
//							BaseModel bmMapModel = (BaseModel) iterRecords.next();
//							//건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
//							ye161090Dto = new Ye161090DTO();  
//	                        
//							ye161090Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
//							ye161090Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   			/** column SYSTEMKEY : systemkey */
//							ye161090Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    											/** column 귀속연도 : yrtxBlggYr */
//							ye161090Dto.setClutSeptCd(clutSeptCd.getValue());    											/** column 연말정산구분코드 : clutSeptCd */
//							ye161090Dto.setFamResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum")));	/** column 가족주민등록번호 : famResnoEncCntn */
//							
//							ye161090Dto.setScxpsStd("Y0030020");    														/** column 교육비공제대상구분코드 : scxpsStd */
//							ye161090Dto.setCdVvalKrnCd("Y0140001");    														/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
//							ye161090Dto.setScxpsUseAmt(bmMapModel.set("scxpsUseAmt", 0L));    								/** column 교육비지출금액 : scxpsUseAmt */
//							ye161090Dto.setScxpsStdDdcTrgtIndvAmt(bmMapModel.set("scxpsStdDdcTrgtIndvAmt", 0L));    		/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
//							
//							listYe161090Dto.add(ye161090Dto);
//							
//						}    
//		                
//						yeta7300Service.saveYeta7300ToYe161090tabItem08_3(listYe161090Dto, actionDatabase, new AsyncCallback<Long>() {
//			    			 
//							public void onFailure(Throwable caught) {
//								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//												MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta7300ToYe161090tabItem08_3(" + actionDatabase.name() + ") : " + caught), null);
//							}
//							public void onSuccess(Long result) {  
//								reloadYe161090Grid();
//							
//								actionDatabase = ActionDatabase.UPDATE;
//							}	
//						});
//					}  
//				}
//			});
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
	
	/** 기본사항 저장**/
	public void itemYeta01Save() {
		// TODO Auto-generated method stub
		
		Ye161020DTO ye161020Dto = new Ye161020DTO();
		
		ye161020Dto.setDpobCd(dpobCd.getValue());    																/** column 사업장코드 : dpobCd */
		ye161020Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    														/** column 귀속연도 : yrtxBlggYr */
		ye161020Dto.setClutSeptCd(clutSeptCd.getValue());    														/** column 연말정산구분코드 : clutSeptCd */
		ye161020Dto.setSystemkey(systemkey.getValue());    															/** column SYSTEMKEY : systemkey */
		
		ye161020Dto.setTnm(tnm.getValue());    																		/** column 근무처명 : tnm */
		ye161020Dto.setBsnoEncCntn(MSFSharedUtils.allowNulls(bsnoEncCntn.getValue()).replaceAll("-", ""));    		/** column 사업자등록번호 : bsnoEncCntn */	
		
		ye161020Dto.setHshrClCd(YetaUtils.getCheckedRadioValue(hshrClCd));    										/** column 세대주여부 : hshrClCd */
		ye161020Dto.setRsplNtnInfrNm(rsplNtnInfrNm.getValue());    													/** column 국적 : rsplNtnInfrNm */
		ye161020Dto.setRsplNtnInfrCd(rsplNtnInfrCd.getValue());    													/** column 국적코드 : rsplNtnInfrCd */
		ye161020Dto.setDtyStrtDt(GWTUtils.getStringFromDate(dtyStrtDt.getValue(), "yyyyMMdd"));    					/** column 근무기간시작일자 : dtyStrtDt */
		ye161020Dto.setDtyEndDt(GWTUtils.getStringFromDate(dtyEndDt.getValue(), "yyyyMMdd"));    					/** column 근무기간종료일자 : dtyEndDt */
		ye161020Dto.setReStrtDt(GWTUtils.getStringFromDate(reStrtDt.getValue(), "yyyyMMdd"));    					/** column 감면기간시작일자 : reStrtDt */
		ye161020Dto.setReEndDt(GWTUtils.getStringFromDate(reEndDt.getValue(), "yyyyMMdd"));    						/** column 감면기간종료일자 : reEndDt */
		ye161020Dto.setRsdtClCd(YetaUtils.getCheckedRadioValue(rsdtClCd));    										/** column 거주구분 : rsdtClCd */
		ye161020Dto.setRsplNtnNm(rsplNtnNm.getValue());    															/** column 거주지국명 : rsplNtnNm */
		ye161020Dto.setRsplNtnCd(rsplNtnCd.getValue());    															/** column 거주지코드 : rsplNtnCd */
		ye161020Dto.setInctxWhtxTxamtMetnCd(MSFSharedUtils.getSelectedComboValue(inctxWhtxTxamtMetnCd, "commCd"));	/** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
		ye161020Dto.setInpmYn( ((Boolean) inpmYn.getValue() ? "Y" : "N" ));    										/** column 분납신청여부 : inpmYn */
		ye161020Dto.setC152StdTxDdcYn( ((Boolean) c152StdTxDdcYn.getValue() ? "Y" : "N" ));    						/** column 표준세액공제적용여부 : 표준세액공제적용여부 */		
		
//		ye161020Dto.setWhdgDebrBusoprRgstnum(whdgDebrBusoprRgstnum);
		ye161020Dto.setPrcspPaySum((Long) prcspPaySum.getValue());		  		// 종근무지_급여총액 
		ye161020Dto.setYeta0c29((Long) yeta0c29.getValue());					// 주근무지_급여총액 
		ye161020Dto.setYeta0c63((Long) yeta0c63.getValue());					// 총급여_현_전 
		ye161020Dto.setYeta0c64((Long) yeta0c64.getValue());					// 근로소득공제 
		ye161020Dto.setYeta0c65((Long) yeta0c65.getValue());					// 근로소득금액 
		ye161020Dto.setYetaC120((Long) yetaC120.getValue());					// 세액공제_근로소득세액공제 
		ye161020Dto.setYetaC112((Long) yetaC112.getValue()); 					// 과세표준   
		ye161020Dto.setYetaC113((Long) yetaC113.getValue()); 					// 산출세액  
		ye161020Dto.setPrcspIncmTxSum((Long) prcspIncmTxSum.getValue());		// 결정세액_소득세 
		ye161020Dto.setPrcspRgonIncmTxSum((Long) prcspRgonIncmTxSum.getValue());// 결정세액_주민세_지방소득세 
		ye161020Dto.setYetaC162((Long) yetaC162.getValue());					// 기납부세액_소득세 
		ye161020Dto.setYetaC163((Long) yetaC163.getValue());					// 기납부세액_주민세_지방소득세 			
		
		
//		ye161020Dto.setFnm(ye161020Dto.getFnm());    /** column 소득자성명 : fnm */
//		ye161020Dto.setResnoEncCntn(ye161020Dto.getResnoEncCntn());    /** column 주민등록번호 : resnoEncCntn */
//		ye161020Dto.setNnfClCd(ye161020Dto.getNnfClCd());    /** column 내외국인구분 : nnfClCd */
//		ye161020Dto.setPrifChngYn(ye161020Dto.getPrifChngYn());    /** column 인적공제항목변동여부 : prifChngYn */

		
		yeta7300Service.saveYeta7300ToYe161020tabItem01(ye161020Dto, new AsyncCallback<Integer>() {
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
					
					getItemYeta01();
					
				} 
			}
		});
	}
	
	
	/** 인적공제 저장 **/
	public void itemYeta02Save() {
		
		actionDatabase = ActionDatabase.UPDATE;
		
		Iterator<Record> iterRecords = Yeta7300ToYe161030GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
	           
		List<Ye161030DTO> listYe161030Dto = new ArrayList<Ye161030DTO>();  
		Ye161030DTO ye161030Dto = new Ye161030DTO(); 
		
		
		while (iterRecords.hasNext()) {
			
			Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
			
	               
			ye161030Dto = new Ye161030DTO();  
               
			ye161030Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    						/** column 사업장코드 : dpobCd */
			ye161030Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   				/** column SYSTEMKEY : systemkey */
            ye161030Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    												/** column 귀속연도 : yrtxBlggYr */
            ye161030Dto.setClutSeptCd(clutSeptCd.getValue());    												/** column 연말정산구분코드 : clutSeptCd */
            ye161030Dto.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(bmMapModel.get("txprDscmNoCntn")));    		/** column 주민등록번호 : txprDscmNoCntn */
            ye161030Dto.setSuptFmlyRltClCd(MSFSharedUtils.allowNulls(bmMapModel.get("suptFmlyRltClCd$commCd")));/** column 부양관계코드 : suptFmlyRltClCd */
            ye161030Dto.setNnfClCd(MSFSharedUtils.allowNulls(bmMapModel.get("nnfClCd")));   					/** column 내외국인구분 : nnfClCd */
            ye161030Dto.setTxprNm(MSFSharedUtils.allowNulls( bmMapModel.get("txprNm")));    					/** column 성명 : txprNm */
            ye161030Dto.setBscDdcClCd((Boolean) bmMapModel.get("bscDdcClCd"));    								/** column 기본공제여부 : bscDdcClCd */
            ye161030Dto.setWmnDdcClCd((Boolean) bmMapModel.get("wmnDdcClCd"));    								/** column 부녀자여부 : wmnDdcClCd */
            ye161030Dto.setSnprntFmlyDdcClCd((Boolean)bmMapModel.get("snprntFmlyDdcClCd"));    					/** column 한부모여부 : snprntFmlyDdcClCd */
            ye161030Dto.setSccDdcClCd((Boolean)bmMapModel.get("sccDdcClCd"));    								/** column 경로우대여부 : sccDdcClCd */
            ye161030Dto.setDsbrDdcClCd( MSFSharedUtils.allowNulls(bmMapModel.get("dsbrDdcClCd$commCd")));    	/** column 장애인여부 : dsbrDdcClCd */
            ye161030Dto.setChbtAtprDdcClCd(MSFSharedUtils.allowNulls(bmMapModel.get("chbtAtprDdcClCd$commCd")));/** column 출산입양여부 : chbtAtprDdcClCd */
            //ye161030Dto.setAge6Lt((Boolean) bmMapModel.get("age6Lt"));    										/** column 6세이하여부 : age6Lt */
            ye161030Dto.setSchoolYn((Boolean) bmMapModel.get("schoolYn"));    										/** column 자녀취학여부 : schoolYn */
            ye161030Dto.setEduDdcDvcd((Boolean) bmMapModel.get("eduDdcDvcd"));    								/** column 교육비공제구분 : eduDdcDvcd */
//	        yeta3220Dto.setBeforeJumin(MSFSharedUtils.allowNulls(bmMapModel.get("rsnoNumb2")));
            ye161030Dto.setPrifChngYn(YetaUtils.getCheckedRadioValue(prifChngYn)); 								/** column 인적공제항목변동여부 : prifChngYn */	
            
            listYe161030Dto.add(ye161030Dto);
		}  
		
		
		if(listYe161030Dto.size() < 1) {
			
			ye161030Dto = new Ye161030DTO();  
            
			ye161030Dto.setDpobCd(dpobCd.getValue());    														/** column 사업장코드 : dpobCd */
			ye161030Dto.setSystemkey(systemkey.getValue());   													/** column SYSTEMKEY : systemkey */
            ye161030Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    												/** column 귀속연도 : yrtxBlggYr */
            ye161030Dto.setClutSeptCd(clutSeptCd.getValue());    												/** column 연말정산구분코드 : clutSeptCd */

            ye161030Dto.setPrifChngYn(YetaUtils.getCheckedRadioValue(prifChngYn)); 								/** column 인적공제항목변동여부 : prifChngYn */	
            
            listYe161030Dto.add(ye161030Dto);
			
		}
		
		yeta7300Service.activityOnYeta7300ToYe161030(listYe161030Dto, actionDatabase, new AsyncCallback<Long>() {
	    			 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta7300ToYe161030(" + actionDatabase.name() + ") : " + caught), null);
			}
			public void onSuccess(Long result) {  
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
				
				getItemYeta02();
				
			}	
		});
	}
	
	
	/** 소득공제 저장 **/
	public void itemYeta03Save() {
		
		actionDatabase = ActionDatabase.UPDATE;  
		
		//국세청자료 grid
		Iterator<Record> iterRecords = Yeta7300ToYe161040GridPanel_01.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		
		List<Ye161040DTO> listYe161040Dto_01 = new ArrayList<Ye161040DTO>();  
		Ye161040DTO ye161040Dto = new Ye161040DTO();  
		
		
		while (iterRecords.hasNext()) {

			Record recData = (Record) iterRecords.next();
			BaseModel bmMapModel = (BaseModel) recData.getModel();
			
			ye161040Dto = new Ye161040DTO();  
			
			ye161040Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    																	/** column 사업장코드 : dpobCd */
			ye161040Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    															/** column 귀속연도 : yrtxBlggYr */
			ye161040Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    															/** column 연말정산구분코드 : clutSeptCd */
			ye161040Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    															/** column SYSTEMKEY : systemkey */
			ye161040Dto.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(bmMapModel.get("txprDscmNoCntn")).replaceAll("-", ""));    								/** column 주민등록번호 : txprDscmNoCntn */
			ye161040Dto.setCdVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("cdVvalKrnCd")));    														/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
			
			ye161040Dto.setHifeDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("hifeDdcTrgtAmt"), "0")));    		/** column 건강등보험료 : hifeDdcTrgtAmt */
			ye161040Dto.setMcurUiTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mcurUiTrgtAmt"), "0")));    		/** column 고용보험료 : mcurUiTrgtAmt */
			ye161040Dto.setCvrgInscDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("cvrgInscDdcTrgtAmt"), "0"))); 	/** column 보장성보험료 : cvrgInscDdcTrgtAmt */
			ye161040Dto.setDsbrDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("dsbrDdcTrgtAmt"), "0")));    		/** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
			ye161040Dto.setMdxpsDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mdxpsDdcTrgtAmt"), "0")));    	/** column 의료비금액 : mdxpsDdcTrgtAmt */
			ye161040Dto.setScxpsDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("scxpsDdcTrgtAmt"), "0")));    	/** column 교육비금액 : scxpsDdcTrgtAmt */
			
			//2022연말정산_추가
			ye161040Dto.setTotCrdcPreSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totCrdcPreSum"), "0")));    		
			ye161040Dto.setTotCrdcCurrSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totCrdcCurrSum"), "0")));    		
			ye161040Dto.setTotTdmrPreSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totTdmrPreSum"), "0")));    		
			ye161040Dto.setTotTdmrCurrSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totTdmrCurrSum"), "0")));    		
			ye161040Dto.setTfhyPbtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("tfhyPbtAmt"), "0")));    		
			ye161040Dto.setShfyPbtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("shfyPbtAmt"), "0")));  
			ye161040Dto.setZrtdDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("zrtdDdcTrgtAmt"), "0"))); 
			//2022연말정산_추가
			
			ye161040Dto.setCrdcDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("crdcDdcTrgtAmt"), "0")));    		/** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
			ye161040Dto.setDrtpCardDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("drtpCardDdcTrgtAmt"), "0")));	/** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
			ye161040Dto.setCshptDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("cshptDdcTrgtAmt"), "0")));   	 	/** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
			ye161040Dto.setBookShowAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("bookShowAmt"), "0")));    		/** column 도서구입이용금액 : bookShowAmt */
			ye161040Dto.setTdmrDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("tdmrDdcTrgtAmt"), "0")));    		/** column 전통시작사용금액 : tdmrDdcTrgtAmt */
			ye161040Dto.setPbtDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("pbtDdcTrgtAmt"), "0")));    		/** column 대중교통이용금액 : pbtDdcTrgtAmt */
			ye161040Dto.setConbDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("conbDdcTrgtAmt"), "0")));    		/** column 기부금액 : conbDdcTrgtAmt */
	            
			listYe161040Dto_01.add(ye161040Dto);
		}   
		
		//기타자료 grid
		iterRecords = Yeta7300ToYe161040GridPanel_02.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		
		List<Ye161040DTO> listYe161040Dto_02 = new ArrayList<Ye161040DTO>();  
		
		while (iterRecords.hasNext()) {
			
			
			Record recData = (Record) iterRecords.next();
			BaseModel bmMapModel = (BaseModel)recData.getModel();
	               
			ye161040Dto = new Ye161040DTO();  
               
			ye161040Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    																	/** column 사업장코드 : dpobCd */
			ye161040Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    															/** column 귀속연도 : yrtxBlggYr */
			ye161040Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    															/** column 연말정산구분코드 : clutSeptCd */
			ye161040Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    															/** column SYSTEMKEY : systemkey */
			ye161040Dto.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(bmMapModel.get("txprDscmNoCntn")).replaceAll("-", ""));    								/** column 주민등록번호 : txprDscmNoCntn */
			ye161040Dto.setCdVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("cdVvalKrnCd")));    														/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
			
			ye161040Dto.setHifeDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("hifeDdcTrgtAmt"), "0")));    		/** column 건강등보험료 : hifeDdcTrgtAmt */
			ye161040Dto.setMcurUiTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mcurUiTrgtAmt"), "0")));    		/** column 고용보험료 : mcurUiTrgtAmt */
			ye161040Dto.setCvrgInscDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("cvrgInscDdcTrgtAmt"), "0"))); 	/** column 보장성보험료 : cvrgInscDdcTrgtAmt */
			ye161040Dto.setDsbrDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("dsbrDdcTrgtAmt"), "0")));    		/** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
			ye161040Dto.setMdxpsDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("mdxpsDdcTrgtAmt"), "0")));    	/** column 의료비금액 : mdxpsDdcTrgtAmt */
			ye161040Dto.setScxpsDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("scxpsDdcTrgtAmt"), "0")));    	/** column 교육비금액 : scxpsDdcTrgtAmt */
			
			//2022연말정산_추가
			ye161040Dto.setTotCrdcPreSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totCrdcPreSum"), "0")));    		
			ye161040Dto.setTotCrdcCurrSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totCrdcCurrSum"), "0")));    		
			ye161040Dto.setTotTdmrPreSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totTdmrPreSum"), "0")));    		
			ye161040Dto.setTotTdmrCurrSum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("totTdmrCurrSum"), "0")));    		
			ye161040Dto.setTfhyPbtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("tfhyPbtAmt"), "0")));    		
			ye161040Dto.setShfyPbtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("shfyPbtAmt"), "0")));    		
			ye161040Dto.setZrtdDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("zrtdDdcTrgtAmt"), "0"))); 
			//2022연말정산_추가
			
			
			ye161040Dto.setCrdcDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("crdcDdcTrgtAmt"), "0")));    		/** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
			ye161040Dto.setDrtpCardDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("drtpCardDdcTrgtAmt"), "0")));	/** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
			ye161040Dto.setCshptDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("cshptDdcTrgtAmt"), "0")));   	 	/** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
			ye161040Dto.setBookShowAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("bookShowAmt"), "0")));    		/** column 도서구입이용금액 : bookShowAmt */
			ye161040Dto.setTdmrDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("tdmrDdcTrgtAmt"), "0")));    		/** column 전통시작사용금액 : tdmrDdcTrgtAmt */
			ye161040Dto.setPbtDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("pbtDdcTrgtAmt"), "0")));    		/** column 대중교통이용금액 : pbtDdcTrgtAmt */
			ye161040Dto.setConbDdcTrgtAmt(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("conbDdcTrgtAmt"), "0")));    		/** column 기부금액 : conbDdcTrgtAmt */
	            
			listYe161040Dto_02.add(ye161040Dto);
		}   
	       
		yeta7300Service.saveYeta7300ToYe1610400tabItem03(listYe161040Dto_01, listYe161040Dto_02, new AsyncCallback<Integer>() {
	    			 
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta03Save(" + actionDatabase.name() + ") : " + caught), null);
			}
			public void onSuccess(Integer result) { 
				
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
				
				getItemYeta03();
				
			}	
		});
	}
	
	
	/** 연금보험료공제 저장 **/
	public void itemYeta04Save() {
		// TODO Auto-generated method stub
		
		Ye161055DTO ye161055Dto = new Ye161055DTO();
			
		ye161055Dto.setDpobCd(dpobCd.getValue());    										/** column 사업장코드 : dpobCd */
		ye161055Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    								/** column 귀속연도 : yrtxBlggYr */
		ye161055Dto.setClutSeptCd(clutSeptCd.getValue());    								/** column 연말정산구분코드 : clutSeptCd */
		ye161055Dto.setSystemkey(systemkey.getValue());    									/** column SYSTEMKEY : systemkey */
		ye161055Dto.setPiclEmplDivCd("Y0130001");    										/** column 주종근무지구분코드 : piclEmplDivCd */
		
		
		ye161055Dto.setNpHthrWaInfeeAmt((Long) npHthrWaInfeeAmt.getValue());    			/** column 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
		ye161055Dto.setNpHthrWaInfeeDdcAmt((Long) npHthrWaInfeeDdcAmt.getValue());    		/** column 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
		ye161055Dto.setNpHthrMcurWkarInfeeAmt((Long) npHthrMcurWkarInfeeAmt.getValue());    /** column 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
		ye161055Dto.setNpHthrMcurWkarDdcAmt((Long) npHthrMcurWkarDdcAmt.getValue());    	/** column 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
		ye161055Dto.setNpHthrAreaInfeeAmt((Long) npHthrAreaInfeeAmt.getValue());    		/** column 국민연금보험료_지역보험료금액 : npHthrAreaInfeeAmt */
		ye161055Dto.setNpHthrAreaDdcAmt((Long) npHthrAreaDdcAmt.getValue());    			/** column 국민연금보험료-지역보험료공제액 : npHthrAreaDdcAmt */		
		
		
		ye161055Dto.setPuoferAnty_01((Long)puoferAnty_01.getValue());    					/** column 공적연금_공무원연금금액 : puoferAnty */
		ye161055Dto.setPuoferAntyDducSum_01((Long)puoferAntyDducSum_01.getValue());    		/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
		ye161055Dto.setMltymAnty_01((Long)mltymAnty_01.getValue());    						/** column 공적연금_군인연금금액 : mltymAnty */
		ye161055Dto.setMltymAntyDducSum_01((Long)mltymAntyDducSum_01.getValue());    		/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
		ye161055Dto.setPrtafirSchlFalymmAnty_01((Long)prtafirSchlFalymmAnty_01.getValue());	/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
		ye161055Dto.setPrtafirSchlDducSum_01((Long)prtafirSchlDducSum_01.getValue());    	/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
		ye161055Dto.setSpildtnPstoficAnty_01((Long)spildtnPstoficAnty_01.getValue()); 		/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
		ye161055Dto.setSpildtnPstoficDducSum_01((Long)spildtnPstoficDducSum_01.getValue());	/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
			
		yeta7300Service.saveYeta7300ToYe161055tabItem04(ye161055Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta04Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta04();
						 
					 } 
				}
		});
	}
	
	
	/** 특별소득공제tab 보험료 tab 저장 **/
	public void itemYeta05_1Save() {
		// TODO Auto-generated method stub
		
		Ye161060DTO ye161060Dto = new Ye161060DTO();
		
		ye161060Dto.setDpobCd(dpobCd.getValue());    							/** column 사업장코드 : dpobCd */
		ye161060Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    					/** column 귀속연도 : yrtxBlggYr */
		ye161060Dto.setClutSeptCd(clutSeptCd.getValue());    					/** column 연말정산구분코드 : clutSeptCd */
		ye161060Dto.setSystemkey(systemkey.getValue());    						/** column SYSTEMKEY : systemkey */
		
		ye161060Dto.setHthrHifeAmt			((Long) hthrHifeAmt.getValue());    	/** column 국민건강보험_종근무지보험료금액 : hthrHifeAmt */
		ye161060Dto.setHthrHifeDdcAmt		((Long) hthrHifeDdcAmt.getValue());    	/** column 국민건강보험_종근무지보험료공제액 : hthrHifeDdcAmt */
		ye161060Dto.setMcurHifeAmt			((Long) mcurHifeAmt.getValue());    	/** column 국민건강보험_주근무지보험료금액 : mcurHifeAmt */
		ye161060Dto.setMcurHifeDdcAmt		((Long) mcurHifeDdcAmt.getValue());    	/** column 국민건강보험_주근무지보험료공제액 : mcurHifeDdcAmt */
		ye161060Dto.setMcurHifeAreaAmt		((Long) mcurHifeAreaAmt.getValue());    /** column 국민건강보험_지역보험료금액 : mcurHifeAreaAmt */
		ye161060Dto.setMcurHifeAreaDdcAmt	((Long) mcurHifeAreaDdcAmt.getValue());	/** column 국민건강보험_지역보험료공제금액 : mcurHifeAreaDdcAmt */
		ye161060Dto.setHthrUiAmt			((Long) hthrUiAmt.getValue());    		/** column 고용보험_종근무지보험료금액 : hthrUiAmt */
		ye161060Dto.setHthrUiDdcAmt			((Long) hthrUiDdcAmt.getValue());    	/** column 고용보험_종근무지보험료공제액 : hthrUiDdcAmt */
		ye161060Dto.setMcurUiAmt			((Long) mcurUiAmt.getValue());    		/** column 고용보험_주근무지보험료금액 : mcurUiAmt */
		ye161060Dto.setMcurUiDdcAmt			((Long) mcurUiDdcAmt.getValue());    	/** column 고용보험_주근무지보험료공제액 : mcurUiDdcAmt */
		ye161060Dto.setInfeeUseAmtSum		((Long) infeeUseAmtSum.getValue());    	/** column 건강고용_보험료보험료합계 : infeeUseAmtSum */
		ye161060Dto.setInfeeDdcAmtSum		((Long) infeeDdcAmtSum.getValue());    	/** column 건강고용_보험료공제액합계 : infeeDdcAmtSum */
			
		yeta7300Service.saveYeta7300ToYe161060tabItem05_1(ye161060Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta05_1Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta05();
						 
					 } 
				}
		});
	}
	
	
	/** 특별소득공제tab 주택자금 tab 저장 **/
	public void itemYeta05_2Save() {
		// TODO Auto-generated method stub
		
		Ye161060DTO ye161060Dto = new Ye161060DTO();
		
		ye161060Dto.setDpobCd(dpobCd.getValue());    							/** column 사업장코드 : dpobCd */
		ye161060Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    					/** column 귀속연도 : yrtxBlggYr */
		ye161060Dto.setClutSeptCd(clutSeptCd.getValue());    					/** column 연말정산구분코드 : clutSeptCd */
		ye161060Dto.setSystemkey(systemkey.getValue());    						/** column SYSTEMKEY : systemkey */
		
		ye161060Dto.setBrwLnpbSrmAmt((Long) brwLnpbSrmAmt.getValue());    					/** column 주택임차차입금대출기관차입원리금상환액 : brwLnpbSrmAmt */
		ye161060Dto.setBrwLnpbSrmDdcAmt((Long) brwLnpbSrmDdcAmt.getValue());    			/** column 주택임차차입금대출기관차입공제액 : brwLnpbSrmDdcAmt */
		ye161060Dto.setRsdtLnpbSrmAmt((Long) rsdtLnpbSrmAmt.getValue());    				/** column 주택임차차입금거주자차입원리금상환액 : rsdtLnpbSrmAmt */
		ye161060Dto.setRsdtLnpbSrmDdcAmt((Long) rsdtLnpbSrmDdcAmt.getValue());    			/** column 주택임차차입금거주자차입공제액 : rsdtLnpbSrmDdcAmt */
		ye161060Dto.setLthYr15BlwItrAmt((Long) lthYr15BlwItrAmt.getValue());    			/** column 장기주택저장차입금2011년이전차입분중15년미만이자상환액 : lthYr15BlwItrAmt */
		ye161060Dto.setLthYr15BlwDdcAmt((Long) lthYr15BlwDdcAmt.getValue());    			/** column 장기주택저당차입금2011년이전차입분15년미만공제액 : lthYr15BlwDdcAmt */
		ye161060Dto.setLthYr29ItrAmt((Long) lthYr29ItrAmt.getValue());    					/** column 장기주택저당차입금2011년이전차입분중15_29년이자상환액 : lthYr29ItrAmt */
		ye161060Dto.setLthYr29DdcAmt((Long) lthYr29DdcAmt.getValue());    					/** column 장기주택저당차입금2011년이전차입분15_29년공제액 : lthYr29DdcAmt */
		ye161060Dto.setLthY30OverItrAmt((Long) lthY30OverItrAmt.getValue());    			/** column 장기주택저당차입금2011이전차입분중30년이상이자상환액 : lthY30OverItrAmt */
		ye161060Dto.setLthY30OverDdcAmt((Long) lthY30OverDdcAmt.getValue());   	 			/** column 장기주택저당차입금2011이전차입분20년이상공제액 : lthY30OverDdcAmt */
		ye161060Dto.setLthYr2012AfthY15Amt((Long) lthYr2012AfthY15Amt.getValue());   	 	/** column 장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액 : lthYr2012AfthY15Amt */
		ye161060Dto.setLthYr2012AfthY15DdcAmt((Long) lthYr2012AfthY15DdcAmt.getValue());    /** column 장기주택저당차입금2012이후고정금리이거나비거치산환대출공제액 : lthYr2012AfthY15DdcAmt */
		ye161060Dto.setLthYr2012EtcBrwItrAmt((Long) lthYr2012EtcBrwItrAmt.getValue());    	/** column 장기주택저당차입금2012이후기타대출이자상환액 : lthYr2012EtcBrwItrAmt */
		ye161060Dto.setLthYr2012EtcBrwDdcAmt((Long) lthYr2012EtcBrwDdcAmt.getValue());    	/** column 장기주택저당차입금2012이후기타대출공제액 : lthYr2012EtcBrwDdcAmt */
		ye161060Dto.setLthYr2015AfthFxnIrItrAmt((Long) lthYr2015AfthFxnIrItrAmt.getValue());/** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액 : lthYr2015AfthFxnIrItrAmt */
		ye161060Dto.setLthYr2015AfthFxnIrDdcAmt((Long) lthYr2015AfthFxnIrDdcAmt.getValue());/** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출공제액 : lthYr2015AfthFxnIrDdcAmt */
		ye161060Dto.setLthYr2015AfthY15Amt((Long) lthYr2015AfthY15Amt.getValue());    		/** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthY15Amt */
		ye161060Dto.setLthYr2015AfthY15DdcAmt((Long) lthYr2015AfthY15DdcAmt.getValue());    /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출공제액 : lthYr2015AfthY15DdcAmt */
		ye161060Dto.setLthYr2015AfthEtcAmt((Long) lthYr2015AfthEtcAmt.getValue());    		/** column 장기주택저당차입금2015이후_15이상_기타대출이자상환액 : lthYr2015AfthEtcAmt */
		ye161060Dto.setLthYr2015AfthEtcDdcAmt((Long) lthYr2015AfthEtcDdcAmt.getValue());    /** column 장기주택저당차입금2015이후_15이상_기타대출공제액 : lthYr2015AfthEtcDdcAmt */
		ye161060Dto.setLthYr2015AfthYr15Amt((Long) lthYr2015AfthYr15Amt.getValue());    	/** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthYr15Amt */
		ye161060Dto.setLthYr2015AfthYr15DdcAmt((Long) lthYr2015AfthYr15DdcAmt.getValue()); 	/** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출공제액 : lthYr2015AfthYr15DdcAmt */
			
		yeta7300Service.saveYeta7300ToYe161060tabItem05_2(ye161060Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta05_2Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta05();
						 
					 } 
				}
		});
	}
	
	
	/** 세액감면및세액공제1tab 연금계좌및보험료 tab 저장 **/	
	
	
	/**그밖의소득공제1 수정 **/
	public void itemYeta06Save() {
		// TODO Auto-generated method stub
		
		Ye161070DTO ye161070Dto = new Ye161070DTO();
		
		ye161070Dto.setDpobCd(dpobCd.getValue());    										/** column 사업장코드 : dpobCd */
		ye161070Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    								/** column 귀속연도 : yrtxBlggYr */
		ye161070Dto.setClutSeptCd(clutSeptCd.getValue());    								/** column 연말정산구분코드 : clutSeptCd */
		ye161070Dto.setSystemkey(systemkey.getValue());    									/** column SYSTEMKEY : systemkey */
		
		ye161070Dto.setYr2000PnsnSvngUseAmt		((Long) yr2000PnsnSvngUseAmt.getValue());	/** column 개인연금저축_2000이전_납입금액 : yr2000PnsnSvngUseAmt */
		ye161070Dto.setYr2000PnsnSvngDdcAmt		((Long) yr2000PnsnSvngDdcAmt.getValue());	/** column 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
		
		ye161070Dto.setSmceSbizUseAmt			((Long) smceSbizUseAmt.getValue());    		/** column 소기업소상인공제부금납입금액 : smceSbizUseAmt */	
		ye161070Dto.setSmceSbizDdcAmt			((Long) smceSbizDdcAmt.getValue());    		/** column 소기업소상인공제부금공제액 : smceSbizDdcAmt */
		
		ye161070Dto.setSbcSvngUseAmt			((Long) sbcSvngUseAmt.getValue());    		/** column 주택마련저축_청약저축납입금액 : sbcSvngUseAmt */
		ye161070Dto.setSbcSvngDdcAmt			((Long) sbcSvngDdcAmt.getValue());    		/** column 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */
		ye161070Dto.setLbrrPrptSvngUseAmt		((Long) lbrrPrptSvngUseAmt.getValue());    	/** column 주택마련저축_근로자주택마련저축납입금액 : lbrrPrptSvngUseAmt */
		ye161070Dto.setLbrrPrptSvngDdcAmt		((Long) lbrrPrptSvngDdcAmt.getValue());    	/** column 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
		ye161070Dto.setHsngSvngUseAmt			((Long) hsngSvngUseAmt.getValue());    		/** column 주택마련저축_주택청약종합저축납입금액 : hsngSvngUseAmt */
		ye161070Dto.setHsngSvngDdcAmt			((Long) hsngSvngDdcAmt.getValue());  		/** column 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
		ye161070Dto.setHsngIncUseAmtSum			((Long) hsngIncUseAmtSum.getValue());    	/** column 주택마련저축_소득공제합계 : hsngIncUseAmtSum */
		ye161070Dto.setHsngIncDdcAmtSum			((Long) hsngIncDdcAmtSum.getValue());    	/** column 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
		
		//2022연말정산_수정 : 19 -> 20, 20 -> 21, 21 -> 22
		ye161070Dto.setCpiv20AsctUseAmt			((Long) cpiv20AsctUseAmt.getValue());    	/** column 출자투자금액_조합등_2020납입금 : cpiv20AsctUseAmt */
		ye161070Dto.setCpiv20AsctDdcAmt			((Long) cpiv20AsctDdcAmt.getValue());    	/** column 출자투자금액 조합등_2020공제액 : cpiv20AsctDdcAmt */
		ye161070Dto.setCpiv20AsctTwoUseAmt			((Long) cpiv20AsctTwoUseAmt.getValue());    	/** column 출자투자금액_조합2등_2020납입금 : cpiv20AsctTwoUseAmt */
		ye161070Dto.setCpiv20AsctTwoDdcAmt			((Long) cpiv20AsctTwoDdcAmt.getValue());    	/** column 출자투자금액 조합2등_2020공제액 : cpiv20AsctTwoDdcAmt */
		ye161070Dto.setCpiv20VntUseAmt			((Long) cpiv20VntUseAmt.getValue());    	/** column 출자투자금액벤처등_2020납입금액 : cpiv20VntUseAmt */
		ye161070Dto.setCpiv20VntDdcAmt			((Long) cpiv20VntDdcAmt.getValue());    	/** column 출자투자금액벤처등_2020공제액 : cpiv20VntDdcAmt */
		
		ye161070Dto.setCpiv21AsctUseAmt			((Long) cpiv21AsctUseAmt.getValue());    	/** column 출자투자금액_조합등_2021납입금 : cpiv21AsctUseAmt */
		ye161070Dto.setCpiv21AsctDdcAmt			((Long) cpiv21AsctDdcAmt.getValue());    	/** column 출자투자금액 조합등_2021공제액 : cpiv21AsctDdcAmt */
		ye161070Dto.setCpiv21AsctTwoUseAmt			((Long) cpiv21AsctTwoUseAmt.getValue());    	/** column 출자투자금액_조합2등_2021납입금 : cpiv21AsctTwoUseAmt */
		ye161070Dto.setCpiv21AsctTwoDdcAmt			((Long) cpiv21AsctTwoDdcAmt.getValue());    	/** column 출자투자금액 조합2등_2021공제액 : cpiv21AsctTwoDdcAmt */
		ye161070Dto.setCpiv21VntUseAmt			((Long) cpiv21VntUseAmt.getValue());    	/** column 출자투자금액벤처등_2021납입금액 : cpiv21VntUseAmt */
		ye161070Dto.setCpiv21VntDdcAmt			((Long) cpiv21VntDdcAmt.getValue());    	/** column 출자투자금액벤처등_2021공제액 : cpiv21VntDdcAmt */
		
		ye161070Dto.setCpiv22AsctUseAmt			((Long) cpiv22AsctUseAmt.getValue());    	/** column 출자투자금액_조합등_2022납입금 : cpiv22AsctUseAmt */
		ye161070Dto.setCpiv22AsctDdcAmt			((Long) cpiv22AsctDdcAmt.getValue());    	/** column 출자투자금액 조합등_2022공제액 : cpiv22AsctDdcAmt */
		ye161070Dto.setCpiv22AsctTwoUseAmt			((Long) cpiv22AsctTwoUseAmt.getValue());    	/** column 출자투자금액_조합2등_2022납입금 : cpiv22AsctTwoUseAmt */
		ye161070Dto.setCpiv22AsctTwoDdcAmt			((Long) cpiv22AsctTwoDdcAmt.getValue());    	/** column 출자투자금액 조합2등_2022공제액 : cpiv22AsctTwoDdcAmt */
		ye161070Dto.setCpiv22VntUseAmt			((Long) cpiv22VntUseAmt.getValue());    	/** column 출자투자금액벤처등_2022납입금액 : cpiv22VntUseAmt */
		ye161070Dto.setCpiv22VntDdcAmt			((Long) cpiv22VntDdcAmt.getValue());    	/** column 출자투자금액벤처등_2022공제액 : cpiv22VntDdcAmt */
		//2022연말정산_수정 : 19 -> 20, 20 -> 21, 21 -> 22
		
		
		ye161070Dto.setIvcpInvmUseAmtSum		((Long) ivcpInvmUseAmtSum.getValue());    	/** column 투자조합출자등소득공제납입금액계 : ivcpInvmUseAmtSum */
		ye161070Dto.setIvcpInvmDdcAmtSum		((Long) ivcpInvmDdcAmtSum.getValue());    	/** column 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
			
		ye161070Dto.setCrdcUseAmt				((Long) crdcUseAmt.getValue());    			/** column 신용카드_전통대중제외사용금액 : crdcUseAmt */
		ye161070Dto.setDrtpCardUseAmt			((Long) drtpCardUseAmt.getValue());    		/** column 직불선불카드_전통대중제외사용금액 : drtpCardUseAmt */
		ye161070Dto.setCshptUseAmt				((Long) cshptUseAmt.getValue());    		/** column 현금영수증_전통대중제외사용금액 : cshptUseAmt */
		ye161070Dto.setBookShowAmt				((Long) bookShowAmt.getValue());    			/** column 도서구입 : bookShowAmt */
		ye161070Dto.setTdmrUseAmt				((Long) tdmrUseAmt.getValue());    			/** column 전통시장사용금액 : tdmrUseAmt */
		ye161070Dto.setPbtUseAmt				((Long) pbtUseAmt.getValue());    			/** column 대중교통이용금액 : pbtUseAmt */
		ye161070Dto.setCrdcSumUseAmt			((Long) crdcSumUseAmt.getValue());    		/** column 신용카드등사용액합계 : crdcSumUseAmt */
		ye161070Dto.setRdcSumDdcAmt				((Long) rdcSumDdcAmt.getValue());    		/** column 신용카드등사용공제액합계 : rdcSumDdcAmt */
//		ye161070Dto.setPrsCrdcUseAmt1			((Long) prsCrdcUseAmt1.getValue());    		/** column 본인신용카드등사용액_2014 : prsCrdcUseAmt1 */
//		ye161070Dto.setTyYrPrsCrdcUseAmt		((Long) tyYrPrsCrdcUseAmt.getValue());    	/** column 본인신용등사용액_2015 : tyYrPrsCrdcUseAmt */
//		ye161070Dto.setPyrPrsAddDdcrtUseAmt		((Long) pyrPrsAddDdcrtUseAmt.getValue());	/** column 본인추가공제율사용분_2014 : pyrPrsAddDdcrtUseAmt */
//		ye161070Dto.setTyShfyPrsAddDdcrtUseAmt	((Long) tyShfyPrsAddDdcrtUseAmt.getValue());/** column 본인추가공제율사용분_2016_상반기 : tyShfyPrsAddDdcrtUseAmt */
			
		yeta7300Service.saveYeta7300ToYe161070tabItem06(ye161070Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta06Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta06();
						 
					 } 
				}
		});
	}
	
	
	/**그밖의소득공제2 수정 **/
	public void itemYeta07Save() {
		// TODO Auto-generated method stub
		
		Ye161070DTO ye161070Dto = new Ye161070DTO();
		
		ye161070Dto.setDpobCd(dpobCd.getValue());    								/** column 사업장코드 : dpobCd */
		ye161070Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    						/** column 귀속연도 : yrtxBlggYr */
		ye161070Dto.setClutSeptCd(clutSeptCd.getValue());    						/** column 연말정산구분코드 : clutSeptCd */
		ye161070Dto.setSystemkey(systemkey.getValue());    							/** column SYSTEMKEY : systemkey */
		
		ye161070Dto.setEmstAsctCntrUseAmt((Long) emstAsctCntrUseAmt.getValue());    /** column 우리사주조합출연금액 : emstAsctCntrUseAmt */
		ye161070Dto.setEmstAsctCntrDdcAmt((Long) emstAsctCntrDdcAmt.getValue());    /** column 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */
		ye161070Dto.setEmpMntnSnmcUseAmt((Long) empMntnSnmcUseAmt.getValue());    	/** column 고용유지중소기업근로자임금삭감액 : empMntnSnmcUseAmt */
		ye161070Dto.setEmpMntnSnmcDdcAmt((Long) empMntnSnmcDdcAmt.getValue());    	/** column 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */
		ye161070Dto.setLtrmCniSsUseAmt((Long) ltrmCniSsUseAmt.getValue());   	 	/** column 장기집합투자증권저축납입금액 : ltrmCniSsUseAmt */
		ye161070Dto.setLtrmCniSsDdcAmt((Long) ltrmCniSsDdcAmt.getValue());    		/** column 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */
			
		yeta7300Service.saveYeta7300ToYe161070tabItem07(ye161070Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta07Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta06();
						 
					 } 
				}
		});
	}
	
	
	/**세액감면및세액공제1 - 연금계좌및보험료 수정 **/
	public void itemYeta08_1Save() {
		// TODO Auto-generated method stub
		
		Ye161080DTO ye161080Dto = new Ye161080DTO();
		
		ye161080Dto.setDpobCd(dpobCd.getValue());    							/** column 사업장코드 : dpobCd */
		ye161080Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    					/** column 귀속연도 : yrtxBlggYr */
		ye161080Dto.setClutSeptCd(clutSeptCd.getValue());    					/** column 연말정산구분코드 : clutSeptCd */
		ye161080Dto.setSystemkey(systemkey.getValue());    						/** column SYSTEMKEY : systemkey */
		
//		ye161080Vo.setFrgrLbrrEntcPupCd(ye161080Dto.getFrgrLbrrEntcPupCd());    /** column 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
//		ye161080Vo.setFrgrLbrrLbrOfrDt(ye161080Dto.getFrgrLbrrLbrOfrDt());    /** column 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
//		ye161080Vo.setFrgrLbrrReExryDt(ye161080Dto.getFrgrLbrrReExryDt());    /** column 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
//		ye161080Vo.setFrgrLbrrReRcpnDt(ye161080Dto.getFrgrLbrrReRcpnDt());    /** column 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
//		ye161080Vo.setFrgrLbrrReAlfaSbmsDt(ye161080Dto.getFrgrLbrrReAlfaSbmsDt());    /** column 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
//		ye161080Vo.setFrgrLbrrErinImnRcpnDt(ye161080Dto.getFrgrLbrrErinImnRcpnDt());    /** column 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
//		ye161080Vo.setFrgrLbrrErinImnSbmsDt(ye161080Dto.getFrgrLbrrErinImnSbmsDt());    /** column 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
//		ye161080Vo.setYupSnmcReStrtDt(ye161080Dto.getYupSnmcReStrtDt());    /** column 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
//		ye161080Vo.setYupSnmcReEndDt(ye161080Dto.getYupSnmcReEndDt());    /** column 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
		
		ye161080Dto.setSctcHpUseAmt			((Long) sctcHpUseAmt.getValue());    		/** column 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
		ye161080Dto.setSctcHpDdcTrgtAmt		((Long) sctcHpDdcTrgtAmt.getValue());   	/** column 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
		ye161080Dto.setSctcHpDdcAmt			((Long) sctcHpDdcAmt.getValue());    		/** column 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
		ye161080Dto.setRtpnUseAmt			((Long) rtpnUseAmt.getValue());    			/** column 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
		ye161080Dto.setRtpnDdcTrgtAmt		((Long) rtpnDdcTrgtAmt.getValue());    		/** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
		ye161080Dto.setRtpnDdcAmt			((Long) rtpnDdcAmt.getValue());    			/** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
		
		ye161080Dto.setRtpnIsaUseAmt			((Long) rtpnIsaUseAmt.getValue());    			/** column 연금계좌_근로자퇴직급여보장법_퇴직연금Isa납입금액 : rtpnIsaUseAmt */
		ye161080Dto.setRtpnDdcIsaTrgtAmt		((Long) rtpnDdcIsaTrgtAmt.getValue());    		/** column 연금계좌_근로자퇴직급여보장법_퇴직연금Isa공제대상금액 : rtpnDdcIsaTrgtAmt */
		ye161080Dto.setRtpnDdcIsaAmt			((Long) rtpnDdcIsaAmt.getValue());    			/** column 연금계좌_근로자퇴직급여보장법_퇴직연금Isa공제세액 : rtpnDdcIsaAmt */
		
		ye161080Dto.setPnsnSvngUseAmt		((Long) pnsnSvngUseAmt.getValue());    		/** column 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
		ye161080Dto.setPnsnSvngDdcTrgtAmt	((Long) pnsnSvngDdcTrgtAmt.getValue());    	/** column 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
		ye161080Dto.setPnsnSvngDdcAmt		((Long) pnsnSvngDdcAmt.getValue());    		/** column 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
		
		ye161080Dto.setPnsnSvngIsaUseAmt		((Long) pnsnSvngIsaUseAmt.getValue());    		/** column 연금계좌_연금저축Isa납입금액 : pnsnSvngIsaUseAmt */
		ye161080Dto.setPnsnSvngDdcIsaTrgtAmt	((Long) pnsnSvngDdcIsaTrgtAmt.getValue());    	/** column 연금계좌_연금저축Isa공제대상금액 : pnsnSvngDdcIsaTrgtAmt */
		ye161080Dto.setPnsnSvngDdcIsaAmt		((Long) pnsnSvngDdcIsaAmt.getValue());    		/** column 연금계좌_연금저축Isa공제세액 : pnsnSvngDdcIsaAmt */
		
		ye161080Dto.setPnsnAccUseAmtSum		((Long) pnsnAccUseAmtSum.getValue());    	/** column 연금계좌납입금액합계 : pnsnAccUseAmtSum */
		ye161080Dto.setPnsnAccDdcTrgtAmtSum	((Long) pnsnAccDdcTrgtAmtSum.getValue());	/** column 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
		ye161080Dto.setPnsnAccDdcAmtSum		((Long) pnsnAccDdcAmtSum.getValue());    	/** column 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
		ye161080Dto.setCvrgInscUseAmt		((Long) cvrgInscUseAmt.getValue());    		/** column 보장성보험납입금액 : cvrgInscUseAmt */
		ye161080Dto.setCvrgInscDdcTrgtAmt2	((Long) cvrgInscDdcTrgtAmt2.getValue());	/** column 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
		ye161080Dto.setCvrgInscDdcAmt		((Long) cvrgInscDdcAmt.getValue());    		/** column 보장성보험공제세액 : cvrgInscDdcAmt */
		ye161080Dto.setDsbrEuCvrgUseAmt		((Long) dsbrEuCvrgUseAmt.getValue());    	/** column 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
		ye161080Dto.setDsbrEuCvrgDdcTrgtAmt	((Long) dsbrEuCvrgDdcTrgtAmt.getValue());	/** column 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
		ye161080Dto.setDsbrEuCvrgDdcAmt		((Long) dsbrEuCvrgDdcAmt.getValue());    	/** column 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
		ye161080Dto.setInfeePymUseAmtSum	((Long) infeePymUseAmtSum.getValue());    	/** column 보험료납입금액합계 : infeePymUseAmtSum */
		ye161080Dto.setInfeePymDdcTrgtAmtSum((Long) infeePymDdcTrgtAmtSum.getValue()); 	/** column 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
		ye161080Dto.setInfeePymDdcAmtSum	((Long) infeePymDdcAmtSum.getValue());    	/** column 보험료공제세액합계 : infeePymDdcAmtSum */
			
		yeta7300Service.saveYeta7300ToYe161080tabItem08_1(ye161080Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta08_1Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta08();
						 
					 } 
				}
		});
	}
	
	
	/**세액감면및세액공제1 - 교육비 수정 **/
	public void itemYeta08_3Save() {
		// TODO Auto-generated method stub
		
		actionDatabase = ActionDatabase.UPDATE;  
		
		Ye161080DTO ye161080Dto = new Ye161080DTO();
		
		ye161080Dto.setDpobCd(dpobCd.getValue());    									/** column 사업장코드 : dpobCd */
		ye161080Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    							/** column 귀속연도 : yrtxBlggYr */
		ye161080Dto.setClutSeptCd(clutSeptCd.getValue());    							/** column 연말정산구분코드 : clutSeptCd */
		ye161080Dto.setSystemkey(systemkey.getValue());    								/** column SYSTEMKEY : systemkey */
		
		ye161080Dto.setScxpsPrsUseAmt		((Long) scxpsPrsUseAmt.getValue());    		/** column 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
		ye161080Dto.setScxpsPrsDdcTrgtAmt	((Long) scxpsPrsDdcTrgtAmt.getValue());    	/** column 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
		ye161080Dto.setScxpsPrsDdcAmt		((Long) scxpsPrsDdcAmt.getValue());    		/** column 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
		ye161080Dto.setScxpsKidUseAmt		((Long) scxpsKidUseAmt.getValue());    		/** column 교육비_취학전아동납입금액 : scxpsKidUseAmt */
//		ye161080Dto.setScxpsKidDdcTrgtAmt	((Long) scxpsKidDdcTrgtAmt.getValue());    	/** column 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
		ye161080Dto.setScxpsKidDdcAmt		((Long) scxpsKidDdcAmt.getValue());    		/** column 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
		ye161080Dto.setScxpsStdUseAmt		((Long) scxpsStdUseAmt.getValue());    		/** column 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
//		ye161080Dto.setScxpsStdDdcTrgtAmt	((Long) scxpsStdDdcTrgtAmt.getValue());    	/** column 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
		ye161080Dto.setScxpsStdDdcAmt		((Long) scxpsStdDdcAmt.getValue());    		/** column 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
		ye161080Dto.setScxpsUndUseAmt		((Long) scxpsUndUseAmt.getValue());    		/** column 교육비_대학생납입금액 : scxpsUndUseAmt */
//		ye161080Dto.setScxpsUndDdcTrgtAmt	((Long) scxpsUndDdcTrgtAmt.getValue());    	/** column 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
		ye161080Dto.setScxpsUndDdcAmt		((Long) scxpsUndDdcAmt.getValue());    		/** column 교육비_대상생공제세액 : scxpsUndDdcAmt */
		ye161080Dto.setScxpsDsbrUseAmt		((Long) scxpsDsbrUseAmt.getValue());    	/** column 교육비_장애인납입금액 : scxpsDsbrUseAmt */
		ye161080Dto.setScxpsDsbrDdcTrgtAmt	((Long) scxpsDsbrDdcTrgtAmt.getValue());    /** column 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
		ye161080Dto.setScxpsDsbrDdcAmt		((Long) scxpsDsbrDdcAmt.getValue());    	/** column 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
		ye161080Dto.setScxpsKidCount		((Long) scxpsKidCount.getValue());    		/** column 교육비_취학전아동인원수 : scxpsKidCount */
		ye161080Dto.setScxpsStdCount		((Long) scxpsStdCount.getValue());    		/** column 교육비_초중고등학교인원수 : scxpsStdCount */
		ye161080Dto.setScxpsUndCount		((Long) scxpsUndCount.getValue());    		/** column 교육비_대학생인원수 : scxpsUndCount */
//		ye161080Dto.setScxpsDsbrCount		((Long) scxpsDsbrCount.getValue());    	/** column 교육비_장애인인원수 : scxpsDsbrCount */
		ye161080Dto.setScxpsUseAmtSum		((Long) scxpsUseAmtSum.getValue());    		/** column 교육비납입금액합계 : scxpsUseAmtSum */
		ye161080Dto.setScxpsDdcTrgtAmtSum	((Long) scxpsDdcTrgtAmtSum.getValue());    	/** column 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
		ye161080Dto.setScxpsDdcAmtSum		((Long) scxpsDdcAmtSum.getValue());    		/** column 교육비공제세액금액합계 : scxpsDdcAmtSum */
			
		yeta7300Service.saveYeta7300ToYe161080tabItem08_3(ye161080Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta08_3Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 
					} else {
						getItemYeta08();
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
							
//						//-- 그리드 저장
//						
//						Iterator<Record> iterRecords = Yeta7300ToYe161090GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
//				        
//						List<Ye161090DTO> listYe161090Dto = new ArrayList<Ye161090DTO>();  
//						Ye161090DTO ye161090Dto = new Ye161090DTO(); 
//						
//						
//						while (iterRecords.hasNext()) {
//
//							Record recData = (Record) iterRecords.next();
//							BaseModel bmMapModel = (BaseModel) recData.getModel();
//
//							ye161090Dto = new Ye161090DTO();
//							
//							ye161090Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
//							ye161090Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   			/** column SYSTEMKEY : systemkey */
//							ye161090Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    			/** column 귀속연도 : yrtxBlggYr */
//							ye161090Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    			/** column 연말정산구분코드 : clutSeptCd */
//							
//							ye161090Dto.setScxpsStd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStd$commCd")));    		/** column 교육비공제대상구분코드 : scxpsStd */
//							ye161090Dto.setCdVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("cdVvalKrnCd$commCd")));    /** column 소득공제명세자료구분코드 : cdVvalKrnCd */
//							ye161090Dto.setFamResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famResnoEncCntn")));	/** column 가족주민등록번호 : famResnoEncCntn */
//							ye161090Dto.setScxpsStd(MSFSharedUtils.allowNulls(bmMapModel.get("scxpsStd$commCd")));    		/** column 교육비공제대상구분코드 : scxpsStd */
//							ye161090Dto.setScxpsUseAmt((Long) bmMapModel.get("scxpsUseAmt"));    							/** column 교육비지출금액 : scxpsUseAmt */
//							ye161090Dto.setScxpsStdDdcTrgtIndvAmt((Long) bmMapModel.get("scxpsStdDdcTrgtIndvAmt"));    		/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
//								
//							listYe161090Dto.add(ye161090Dto);
//							
//						} 
//						
//						if(listYe161090Dto.size() < 1) {
//							 getItemYeta08();
//							 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
//							
//							 
//						}else {
//							
//							yeta7300Service.saveYeta7300ToYe161090tabItem08_3(listYe161090Dto, actionDatabase, new AsyncCallback<Long>() {
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//										MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//									                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta08_3Save(저장) : " + caught), null);
//								}
//
//								@Override
//								public void onSuccess(Long result) {
//									// TODO Auto-generated method stub
//									if (result == 0) {
//										MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//									} else {
//										
//										getItemYeta08();
//										MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
//										
//									} 
//								}
//							});
//						}
					} 
				}
		});
	}
	
	
	/**세액감면및세액공제2  수정 **/
	public void itemYeta09Save() {
		// TODO Auto-generated method stub
		
		Ye161080DTO ye161080Dto = new Ye161080DTO();
		
		ye161080Dto.setDpobCd(dpobCd.getValue());    							/** column 사업장코드 : dpobCd */
		ye161080Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    					/** column 귀속연도 : yrtxBlggYr */
		ye161080Dto.setClutSeptCd(clutSeptCd.getValue());    					/** column 연말정산구분코드 : clutSeptCd */
		ye161080Dto.setSystemkey(systemkey.getValue());    						/** column SYSTEMKEY : systemkey */

		
		ye161080Dto.setFrgrLbrrEntcPupCd1(frgrLbrrEntcPupCd1.getValue());    
		ye161080Dto.setFrgrLbrrEntcPupCd2(frgrLbrrEntcPupCd2.getValue());  
		ye161080Dto.setFrgrLbrrEntcPupCd3(frgrLbrrEntcPupCd3.getValue());  
		ye161080Dto.setFrgrLbrrEntcPupCd4(frgrLbrrEntcPupCd4.getValue());  
		
		String frgrLbrrEntcPupCdStr =( ye161080Dto.getFrgrLbrrEntcPupCd1()? "Y" : "N" )
										+ ( ye161080Dto.getFrgrLbrrEntcPupCd2()? "Y" : "N" ) 
										+ ( ye161080Dto.getFrgrLbrrEntcPupCd3()? "Y" : "N" ) 
										+ ( ye161080Dto.getFrgrLbrrEntcPupCd4()? "Y" : "N" );
		ye161080Dto.setFrgrLbrrEntcPupCd( frgrLbrrEntcPupCdStr );    														/** column 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
		
		ye161080Dto.setFrgrLbrrLbrOfrDt(MSFSharedUtils.getConvertDateToString(frgrLbrrLbrOfrDt, "yyyyMMdd"));    			/** column 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
		ye161080Dto.setFrgrLbrrReExryDt(MSFSharedUtils.getConvertDateToString(frgrLbrrReExryDt, "yyyyMMdd"));  	  			/** column 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
		ye161080Dto.setFrgrLbrrReRcpnDt(MSFSharedUtils.getConvertDateToString(frgrLbrrReRcpnDt, "yyyyMMdd"));    			/** column 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
		ye161080Dto.setFrgrLbrrReAlfaSbmsDt(MSFSharedUtils.getConvertDateToString(frgrLbrrReAlfaSbmsDt, "yyyyMMdd"));    	/** column 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
		ye161080Dto.setFrgrLbrrErinImnRcpnDt(MSFSharedUtils.getConvertDateToString(frgrLbrrErinImnRcpnDt, "yyyyMMdd"));    	/** column 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
		ye161080Dto.setFrgrLbrrErinImnSbmsDt(MSFSharedUtils.getConvertDateToString(frgrLbrrErinImnSbmsDt, "yyyyMMdd"));    	/** column 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
		ye161080Dto.setYupSnmcReStrtDt(MSFSharedUtils.getConvertDateToString(yupSnmcReStrtDt, "yyyyMMdd"));    				/** column 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
		ye161080Dto.setYupSnmcReEndDt(MSFSharedUtils.getConvertDateToString(yupSnmcReEndDt, "yyyyMMdd"));    				/** column 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
		
		ye161080Dto.setOvrsSurcIncFmt((Long) ovrsSurcIncFmt.getValue());    												/** column 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
		ye161080Dto.setFrgnPmtFcTxamt((Long) frgnPmtFcTxamt.getValue());   													/** column 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
		ye161080Dto.setFrgnPmtWcTxamt((Long) frgnPmtWcTxamt.getValue());    												/** column 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
		ye161080Dto.setFrgnPmtTxamtTxpNtnNm(frgnPmtTxamtTxpNtnNm.getValue());    											/** column 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
		
		ye161080Dto.setFrgnPmtTxamtPmtDt(MSFSharedUtils.getConvertDateToString(frgnPmtTxamtPmtDt, "yyyyMMdd"));    			/** column 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
		ye161080Dto.setFrgnPmtTxamtAlfaSbmsDt(MSFSharedUtils.getConvertDateToString(frgnPmtTxamtAlfaSbmsDt, "yyyyMMdd"));	/** column 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
		ye161080Dto.setFrgnPmtTxamtAbrdWkarNm(frgnPmtTxamtAbrdWkarNm.getValue());    										/** column 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
		
		ye161080Dto.setFrgnDtyTermStdt(MSFSharedUtils.getConvertDateToString(frgnDtyTermStdt, "yyyyMMdd"));    				/** column 외국납부세액_근무기간일자 : frgnDtyTerm */
		ye161080Dto.setFrgnDtyTermEddt(MSFSharedUtils.getConvertDateToString(frgnDtyTermEddt, "yyyyMMdd"));    				/** column 외국납부세액_근무기간종료일자 : frgnDtyTermEddt */
		ye161080Dto.setFrgnPmtTxamtRfoNm(frgnPmtTxamtRfoNm.getValue());    													/** column 외국납부세액직책 : frgnPmtTxamtRfoNm */
		
		ye161080Dto.setHsngTennLnpbUseAmt((Long) hsngTennLnpbUseAmt.getValue());    										/** column 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
		ye161080Dto.setHsngTennLnpbDdcAmt((Long) hsngTennLnpbDdcAmt.getValue());    										/** column 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
		
		ye161080Dto.setMmrUseAmt((Long) mmrUseAmt.getValue());    															/** column 월세액세액공제지출금액 : mmrUseAmt */
		ye161080Dto.setMmrDdcAmt((Long) mmrDdcAmt.getValue());    															/** column 월세액세액공제공제세액 : mmrDdcAmt */
		
		ye161080Dto.setTxlgItctAmnt((Long) txlgItctAmnt.getValue());   	/** column 세액감면_소득세법감면세액 : txlgItctAmnt */
		ye161080Dto.setTxlgBstaAmnt((Long) txlgBstaAmnt.getValue());    /** column 세액감면_취업청년감면대상총급여액 : txlgBstaAmnt */
		ye161080Dto.setTxlgWktaAmnt((Long) txlgWktaAmnt.getValue());    /** column 세액감면_취업청년감면근로자총급여액 : txlgWktaAmnt */
		ye161080Dto.setTxlgCltaAmnt((Long) txlgCltaAmnt.getValue());    /** column 세액감면_계산감면세액금액 : txlgCltaAmnt */
		ye161080Dto.setTxlgFrtaAmnt((Long) txlgFrtaAmnt.getValue());    /** column 세액감면_외국인기술자감면세액 : txlgFrtaAmnt */
		ye161080Dto.setTxlgTxtyAmnt((Long) txlgTxtyAmnt.getValue());    /** column 세액감면_조세조약감면세액 : txlgTxtyAmnt */
		
		ye161080Dto.setYetaC114((Long) yetaC114.getValue());    		/** column C114_세액감면_소득세법감면금액 : yetaC114 */
		ye161080Dto.setYetaC115((Long) yetaC115.getValue());   	 		/** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
		ye161080Dto.setYetaC116((Long) yetaC116.getValue());    		/** column C116_세액감면_조특범30조_감면금액 : yetaC116 */
		ye161080Dto.setYetaC117((Long) yetaC117.getValue());    		/** column C117_세액감면_조세조약감면금액 : yetaC117 */
		
			
		yeta7300Service.saveYeta7300ToYe161080tabItem09(ye161080Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta09Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta09();
						 
					 } 
				}
		});
	}
	
	
	/** 추가제출서류  수정 **/
	public void itemYeta10Save() {
		// TODO Auto-generated method stub
		
		Ye161080DTO ye161080Dto = new Ye161080DTO();
		
		ye161080Dto.setDpobCd(dpobCd.getValue());    							/** column 사업장코드 : dpobCd */
		ye161080Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    					/** column 귀속연도 : yrtxBlggYr */
		ye161080Dto.setClutSeptCd(clutSeptCd.getValue());    					/** column 연말정산구분코드 : clutSeptCd */
		ye161080Dto.setSystemkey(systemkey.getValue());    						/** column SYSTEMKEY : systemkey */
		
		
		
		ye161080Dto.setD219(YetaUtils.getCheckedRadioValue(d219));   											 	/** column 외국인근로자단일세율적용신청서제출여부 : d219 */
		ye161080Dto.setCd225(YetaUtils.getCheckedRadioValue(cd225));    											/** column 연금저축등소득세액공제명세서제출여부 : cd225 */
		ye161080Dto.setCd226(YetaUtils.getCheckedRadioValue(cd226));    											/** column 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
		ye161080Dto.setPrcspWorkIncmSumtYn(YetaUtils.getCheckedRadioValue(prcspWorkIncmSumtYn));    				/** column 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */

		ye161080Dto.setCd227(YetaUtils.getCheckedRadioValue(cd227));    											/** column 의료비지급명세서제출여부 : cd227 */
		ye161080Dto.setCd228(YetaUtils.getCheckedRadioValue(cd228));    											/** column 기부금명세서제출여부 : cd228 */
		ye161080Dto.setFileAppPaprSbtYn(YetaUtils.getCheckedRadioValue(fileAppPaprSbtYn));    						/** column 소득공제신고파일제출여부 : fileAppPaprSbtYn */
		ye161080Dto.setIncmDducWtnnteSumtDt(MSFSharedUtils.getConvertDateToString(incmDducWtnnteSumtDt, "yyyyMMdd"));/** column 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
		
		yeta7300Service.saveYeta7300ToYe161080tabItem10(ye161080Dto, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("itemYeta10Save(저장) : " + caught), null);
				}

				@Override
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					if (result == 0) {
						
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "저장처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					 } else {
						 
						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장 처리가 완료되었습니다.", null);
						 getItemYeta10();
						 
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
		String pymtYr  =  MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year") ;
      	if (MSFSharedUtils.paramNull(pymtYr)) {
      		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                        "조회하시려면  정산년을 선택하셔야 합니다.", null);
      		return;
      	}
	     	if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"))) {
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
//		resetItemYeta01();	 
		
		IColumnFilter filters = null;
		
		Yeta7300ToYe161010GridPanel.getTableDef().setTableColumnFilters(filters);
		
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"), SimpleColumnFilter.OPERATOR_EQUALS);
		
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strDeptCd =YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
		           
		String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		       
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("utDpobCd", MSFSharedUtils.allowNulls(utDpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
		Yeta7300ToYe161010GridPanel.getTableDef().addColumnFilter("printType", YetaUtils.getCheckedRadioValue(printType), SimpleColumnFilter.OPERATOR_EQUALS);  

		Yeta7300ToYe161010GridPanel.reload(); 
      
	}
	
	
	/** 대상자에 따른 정보 가져옴 **/
	private void Yeta7300ToYeta2000Detail2(Yeta2000BM result) {
	
	}
	
	
	/** 대상자에 따른 정보 가져옴 **/
	private void Yeta7300ToYe161010Detail(BaseModel selRecord, String tabId) {
		if("itemYeta01".equals(tabId)){ 			// 기본사항
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta01();
			}
			
		}else if("itemYeta02".equals(tabId)){		// 인적공제
			
			if (MSFSharedUtils.paramNotNull(selRecord)) {
				getItemYeta02();
			}
			
		}else if("itemYeta03".equals(tabId)){		// 소득공제
			
			if (MSFSharedUtils.paramNotNull(selRecord)){
				getItemYeta03();
			}
			
		}else if("itemYeta04".equals(tabId)){ 		// 연금보험료공제
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta04();
			}
			
		}else if("itemYeta05_1".equals(tabId)) {	// 특별소득공제 - 보험료
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta05();
			}
			
		}else if("itemYeta05_2".equals(tabId)) {	// 특별소득공제 - 주택자금
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta05();
			}
		
		}else if("itemYeta06".equals(tabId)){ 		// 그밖의소득공제1
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta06();
			
			}
			
		}else if("itemYeta07".equals(tabId)){		// 그밖의소득공제2
			
			if (MSFSharedUtils.paramNotNull(selRecord)){
				getItemYeta06();
			}
			
		}else if("itemYeta08_1".equals(tabId)) {	// 세액감면및세액공제1 - 연금계좌및보험료
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta08();
			}
			
		}else if("itemYeta08_2".equals(tabId)) {	// 세액감면및세액공제1 - 의료비
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta08();
			}
			
		}else if("itemYeta08_3".equals(tabId)) {	// 세액감면및세액공제1 - 교육비
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta08();
			}
			
		}else if("itemYeta08_4".equals(tabId)) {	// 세액감면및세액공제1 - 기부금
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta08();
			}
			
		}else if("itemYeta09".equals(tabId)){		// 세액감면및세액공제2

			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta09();
			}
			
		}else if("itemYeta10".equals(tabId)){		// 추가제출서류
			
			if (MSFSharedUtils.paramNotNull(selRecord)){	
				getItemYeta10();
			}
			
		}
	}
	
	
	
	/** 기본사항 정보를 가져옴 **/
	private void getItemYeta01() {
		
		Ye161020DTO ye161020Dto = new Ye161020DTO();
		
		ye161020Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161020Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161020Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161020Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300ToYe161020Data(ye161020Dto, new AsyncCallback<Ye161020DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getYeta7300ToYe161020Data(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye161020DTO result) {
				// TODO Auto-generated method stub
				
				resetItemYeta01();
				
				YetaUtils.setCheckedCheckBoxValue(fileSbtYn, result.getFileSbtYn());				// 소득공제신고전자파일제출여부
				
				if(fileSbtYn.getValue()) {
					fileSbtYn.setReadOnly(true);
					fileSbtBtn.disable();		
					fileSbtReBtn.disable();
				}else {
					fileSbtYn.setReadOnly(false);
					fileSbtBtn.setEnabled(true);
					fileSbtReBtn.setEnabled(true);
				}
				
				tnm.setValue(result.getTnm());
				bsnoEncCntn.setValue(result.getBsnoEncCntn());	
				
				YetaUtils.setCheckedRadioValue(hshrClCd, result.getHshrClCd());						// 세대주여부
				rsplNtnInfrCd.setValue(result.getRsplNtnInfrCd());									// 국적코드
				rsplNtnInfrNm.setValue(result.getRsplNtnInfrNm());									// 국적명
				rsplNtnInfrItem.setValue(result.getRsplNtnInfrItem()); 								// 국적코드 두자리
				    	
				dtyStrtDt.setValue(GWTUtils.getDateFromString(result.getDtyStrtDt(), "yyyyMMdd"));	// 근무 시작 일자
				dtyEndDt.setValue(GWTUtils.getDateFromString(result.getDtyEndDt(), "yyyyMMdd"));	// 근무 종료 일자
				    
				reStrtDt.setValue(GWTUtils.getDateFromString(result.getReStrtDt(), "yyyyMMdd"));	// 감면 시작 일자 
				reEndDt.setValue(GWTUtils.getDateFromString(result.getReEndDt(), "yyyyMMdd"));		// 감면 종료 일자
				    
				YetaUtils.setCheckedRadioValue(rsdtClCd, result.getRsdtClCd());	;					// 거주구분여부
				    
				rsplNtnCd.setValue(result.getRsplNtnCd());											// 거주지국코드
				rsplNtnNm.setValue(result.getRsplNtnNm());											// 거주지국명
				rsplNtnItem.setValue(result.getRsplNtnItem()); 										// 거주지국 두자리
				    
				YetaUtils.setCheckedCheckBoxValue(inpmYn, result.getInpmYn());						// 분납신청여부
				YetaUtils.setCheckedCheckBoxValue(c152StdTxDdcYn, result.getC152StdTxDdcYn());		// 표준세액공제
				
				inctxWhtxTxamtMetnCd.setValue(lsInctxWhtxTxamtMetnCd.findModel("commCd"
								,MSFSharedUtils.allowNulls(result.getInctxWhtxTxamtMetnCd())));		// 소득세원천징수세액조정구분코드   
				
				
				prcspPaySum.setValue(result.getPrcspPaySum());		  								// 종근무지_급여총액 
				prcspIncmTxSum.setValue(result.getPrcspIncmTxSum());								// 결정세액_소득세 
				prcspRgonIncmTxSum.setValue(result.getPrcspRgonIncmTxSum());						// 결정세액_주민세_지방소득세 
				yeta0c29.setValue(result.getYeta0c29());											// 주근무지_급여총액 
				yeta0c63.setValue(result.getYeta0c63());											// 총급여_현_전 
				yeta0c64.setValue(result.getYeta0c64());											// 근로소득공제 
				yeta0c65.setValue(result.getYeta0c65());											// 근로소득금액 
				yetaC120.setValue(result.getYetaC120());											// 세액공제_근로소득세액공제 
				yetaC112.setValue(result.getYetaC112());											// 과세표준   
				yetaC113.setValue(result.getYetaC113());											// 산출세액  
				yetaC162.setValue(result.getYetaC162());											// 기납부세액_소득세 
				yetaC163.setValue(result.getYetaC163());											// 기납부세액_주민세_지방소득세 	

				
				reloadYe169010();
				
			}
		});
	}
	

	
	/** 인적공제 정보를 가져옴 **/
	private void getItemYeta02() {
		
		reloadYe161030();

		Ye161020DTO ye161020Dto = new Ye161020DTO();
		
		ye161020Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161020Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161020Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161020Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300TabItem02ToYe161020Data(ye161020Dto, new AsyncCallback<Ye161020DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta7300ToYe161020tabItem02(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye161020DTO result) {
				// TODO Auto-generated method stub
				resetItemYeta02();
				
				reloadYe161030();
				
				addrMrct.setValue(result.getAddrMrct());
				addrMccr.setValue(result.getAddrMccr());
				YetaUtils.setCheckedRadioValue(prifChngYn, result.getPrifChngYn());						// 인적공제항목변동여부
				
			}
		});
	}
	


	/** 소득공제 정보를 가져옴 **/	
	private void getItemYeta03() {
		resetItemYeta03();
		reloadYe161040_item03Grid();
		
	}
	
	

	
	/** 연금보험료공제 정보를 가져옴 **/
	private void getItemYeta04() {

		Ye161055DTO ye161055Dto = new Ye161055DTO();
		
		ye161055Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161055Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161055Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161055Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300TabItem04ToYe161055Data(ye161055Dto, new AsyncCallback<Ye161055DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getYeta7300TabItem04ToYe161055Data(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye161055DTO result) {
				// TODO Auto-generated method stub
				
				resetItemYeta04();

				npHthrWaInfeeAmt.setValue(result.getNpHthrWaInfeeAmt());				// 종근무지_국민연금보험료
			    npHthrWaInfeeDdcAmt.setValue(result.getNpHthrWaInfeeDdcAmt());			// 종근무지_국민연금보험료공제
			    npHthrMcurWkarInfeeAmt.setValue(result.getNpHthrMcurWkarInfeeAmt());	// 주근무지_국민연금보험료
			    npHthrMcurWkarDdcAmt.setValue(result.getNpHthrMcurWkarDdcAmt());		// 주근무지_국민연금보험료공제
			    npHthrAreaInfeeAmt.setValue(result.getNpHthrAreaInfeeAmt());			// 국민연금지역보험료
			    npHthrAreaDdcAmt.setValue(result.getNpHthrAreaDdcAmt());				// 국민연금지역보험료공제	
				
				puoferAnty_02.setValue(result.getPuoferAnty_02());						// 종근무지_국민연금외공무원연금
				puoferAnty_01.setValue(result.getPuoferAnty_01());						// 주근무지_국민연금외공무원연금

				mltymAnty_02.setValue(result.getMltymAnty_02());						// 종근무지_국민연금외군인연금
				mltymAnty_01.setValue(result.getMltymAnty_01());						// 주근무지_국민연금외군인연금

				prtafirSchlFalymmAnty_02.setValue(result.getPrtafirSchlFalymmAnty_02());// 종근무지_국인연금외교직원연금
				prtafirSchlFalymmAnty_01.setValue(result.getPrtafirSchlFalymmAnty_01());// 주근무지_국인연금외교직원연금

				spildtnPstoficAnty_02.setValue(result.getSpildtnPstoficAnty_02());		// 종근무지_국민연금외별정우체국
				spildtnPstoficAnty_01.setValue(result.getSpildtnPstoficAnty_01());	 	// 주근무지_국민연금외별정우체국

				puoferAntyDducSum_02.setValue(result.getPuoferAntyDducSum_02());		// 종근무지_국민연금외공무원연금공제
				puoferAntyDducSum_01.setValue(result.getPuoferAntyDducSum_01());		// 주근무지_공무원연금보험료공제

				mltymAntyDducSum_02.setValue(result.getMltymAntyDducSum_02());			// 종근무지_국민연금외군인연금공제
				mltymAntyDducSum_01.setValue(result.getMltymAntyDducSum_01());			// 주근무지_국민연금외군인연금공제

				prtafirSchlDducSum_02.setValue(result.getPrtafirSchlDducSum_02());		// 종근무지_국민연금외교직원연금공제
				prtafirSchlDducSum_01.setValue(result.getPrtafirSchlDducSum_01());		// 주근무지_국민연금외교직원연금공제

				spildtnPstoficDducSum_02.setValue(result.getSpildtnPstoficDducSum_02());// 종근무지_별정우체국연금보험료공제
				spildtnPstoficDducSum_01.setValue(result.getSpildtnPstoficDducSum_01());// 주근무지_별정우체국연금보험료공제

				pnsnInfeeUseAmtSum.setValue(result.getPnsnInfeeUseAmtSum());			// 연금보험료계
				pnsnInfeeDdcAmtSum.setValue(result.getPnsnInfeeDdcAmtSum());			// 연금보험료공제계
				
				    
			}
		});		
		
	}
	

	/** 특별소득공제 정보를 가져옴 **/	
	private void getItemYeta05() {

		Ye161060DTO ye161060Dto = new Ye161060DTO();
		
		ye161060Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161060Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161060Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161060Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300TabItem05ToYe161060Data(ye161060Dto, new AsyncCallback<Ye161060DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getItemYeta05(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye161060DTO result) {
				// TODO Auto-generated method stub
				
				resetItemYeta05();
				
				hthrHifeAmt.setValue(result.getHthrHifeAmt());								// 특별공제_종건강보험료
				mcurHifeAmt.setValue(result.getMcurHifeAmt());								// 특별공제_주건강보험료
				hthrHifeDdcAmt.setValue(result.getHthrHifeDdcAmt());						// 특별공제_종건강보험료 공제액
				mcurHifeDdcAmt.setValue(result.getMcurHifeDdcAmt());						// 특별공제_주건강보험료 공제액
				mcurHifeAreaAmt.setValue(result.getMcurHifeAreaAmt());						// 특별공제_건강지역보험료
				mcurHifeAreaDdcAmt.setValue(result.getMcurHifeAreaDdcAmt());				// 특별공제_건강지역보험료 공제액

				hthrUiAmt.setValue(result.getHthrUiAmt());									// 특별공제_종고용보험료
				mcurUiAmt.setValue(result.getMcurUiAmt());									// 특별공제_주고용보험료
				hthrUiDdcAmt.setValue(result.getHthrUiDdcAmt());							// 특별공제_종고용보험료 공제액
				mcurUiDdcAmt.setValue(result.getMcurUiDdcAmt());							// 특별공제_주고용보험료 공제액

				infeeUseAmtSum.setValue(result.getInfeeUseAmtSum());						// 특별공제_보험료계
				infeeDdcAmtSum.setValue(result.getInfeeDdcAmtSum());						// 특별공제_보험료계

				brwLnpbSrmAmt.setValue(result.getBrwLnpbSrmAmt());							// 특별공제_차입금원리금상환액_대출기관 상환액
				brwLnpbSrmDdcAmt.setValue(result.getBrwLnpbSrmDdcAmt());					// 특별공제_차입금원리금상환액_대출기관 공제액
				
				rsdtLnpbSrmAmt.setValue(result.getRsdtLnpbSrmAmt());						// 특별공제_차입금원리금상환액_거주자 상환액
				rsdtLnpbSrmDdcAmt.setValue(result.getRsdtLnpbSrmDdcAmt());					// 특별공제_차입금원리금상환액_거주자 공제액

				lthYr15BlwItrAmt.setValue(result.getLthYr15BlwItrAmt());					// 특별공제_11장기주택저당차입금15
				lthYr29ItrAmt.setValue(result.getLthYr29ItrAmt());							// 특별공제_11장기주택저당차입금29
				lthY30OverItrAmt.setValue(result.getLthY30OverItrAmt());					// 특별공제_11장기주택저당차입금30

				lthYr15BlwDdcAmt.setValue(result.getLthYr15BlwDdcAmt());					// 특별공제_11장기주택저당차입금15 공제액
				lthYr29DdcAmt.setValue(result.getLthYr29DdcAmt());							// 특별공제_11장기주택저당차입금29 공제액
				lthY30OverDdcAmt.setValue(result.getLthY30OverDdcAmt());					// 특별공제_11장기주택저당차입금30 공제액

				lthYr2012AfthY15Amt.setValue(result.getLthYr2012AfthY15Amt());				// 특별공제_12장기주택저당차입금_고정
				lthYr2012EtcBrwItrAmt.setValue(result.getLthYr2012EtcBrwItrAmt());			// 특별공제_12장기주택저당차입금_기타

				lthYr2012AfthY15DdcAmt.setValue(result.getLthYr2012AfthY15DdcAmt());		// 특별공제_12장기주택저당차입금_고정  공제액
				lthYr2012EtcBrwDdcAmt.setValue(result.getLthYr2012EtcBrwDdcAmt());			// 특별공제_12장기주택저당차입금_기타  공제액

				lthYr2015AfthFxnIrItrAmt.setValue(result.getLthYr2015AfthFxnIrItrAmt());	// 특별공제_15장기주택저당_15고정AND비거치상환
				lthYr2015AfthY15Amt.setValue(result.getLthYr2015AfthY15Amt());				// 특별공제_15장기주택저당_15고정OR비거치상환
				lthYr2015AfthEtcAmt.setValue(result.getLthYr2015AfthEtcAmt());				// 특별공제_15장기주택저당_15기타대출
				lthYr2015AfthYr15Amt.setValue(result.getLthYr2015AfthYr15Amt());			// 특별공제_15장기주택저당_10고정OR비거치상환

				lthYr2015AfthFxnIrDdcAmt.setValue(result.getLthYr2015AfthFxnIrDdcAmt());	// 특별공제_15장기주택저당_15고정AND비거치상환 공제액
				lthYr2015AfthY15DdcAmt.setValue(result.getLthYr2015AfthY15DdcAmt());		// 특별공제_15장기주택저당_15고정OR비거치상환 공제액
				lthYr2015AfthEtcDdcAmt.setValue(result.getLthYr2015AfthEtcDdcAmt());		// 특별공제_15장기주택저당_15기타대출 공제액
				lthYr2015AfthYr15DdcAmt.setValue(result.getLthYr2015AfthYr15DdcAmt());		// 특별공제_15장기주택저당_10고정OR비거치상환 공제액

				hsngFndsDdcAmtSum.setValue(result.getHsngFndsDdcAmtSum());					// 특별공제_주택자금공제액계
				
				conbLglUseAmt01.setValue(result.getConbLglUseAmt());						// 이월법정기부금액
				conbReliOrgOthUseAmt01.setValue(result.getConbReliOrgOthUseAmt());			// 이월종교단체외기부금
				conbReliOrgUseAmt01.setValue(result.getConbReliOrgUseAmt());				// 이월종교단체기부금
				conbLglDdcAmt01.setValue(result.getConbLglDdcAmt());						// 이월법정기부금액_공제액
				conbReliOrgOthDdcAmt01.setValue(result.getConbReliOrgOthDdcAmt());			// 이월종교단체외기부금_공제액
				conbReliOrgDdcAmt01.setValue(result.getConbReliOrgDdcAmt());				// 이월종교단체기부금_공제액
				conbUseAmtSum01.setValue(result.getConbUseAmtSum());						// 기부금(이월분) 합계	
				conbDdcAmtSum01.setValue(result.getConbDdcAmtSum());						// 기부금(이월분)	 합계_공제
				
			}
		});		
	}
	

	
	/** 그밖의소득공제1,2 정보를 가져옴 **/	
	private void getItemYeta06() {

		Ye161070DTO ye161070Dto = new Ye161070DTO();
		
		ye161070Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161070Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161070Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161070Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300TabItem06ToYe161070Data(ye161070Dto, new AsyncCallback<Ye161070DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getItemYeta06(" + actionDatabase.name() + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Ye161070DTO result) {
				// TODO Auto-generated method stub
				
				resetItemYeta06();
				resetItemYeta07();
				
				// -------------- 그밖의 소득 공제1 시작 --------------
				yr2000PnsnSvngUseAmt.setValue(result.getYr2000PnsnSvngUseAmt());		// 개인연금저축불입액_2000년이전
				yr2000PnsnSvngDdcAmt.setValue(result.getYr2000PnsnSvngDdcAmt());		// 개인연금저축불입액_2000년이전

				sbcSvngUseAmt.setValue(result.getSbcSvngUseAmt());						// 기타공제_주택마련저축_청약저축
				hsngSvngUseAmt.setValue(result.getHsngSvngUseAmt());					// 기타공제_주택마련저축_주택청약종합저축
				lbrrPrptSvngUseAmt.setValue(result.getLbrrPrptSvngUseAmt());			// 기타공제_주택마련저축_근로자주택마련저축
				hsngIncUseAmtSum.setValue(result.getHsngIncUseAmtSum());				// 기타공제_주택마련저축소득금액

				sbcSvngDdcAmt.setValue(result.getSbcSvngDdcAmt());						// 기타공제_주택마련저축_청약저축 공제액
				hsngSvngDdcAmt.setValue(result.getHsngSvngDdcAmt());					// 기타공제_주택마련저축_주택청약종합저축 공제액
				lbrrPrptSvngDdcAmt.setValue(result.getLbrrPrptSvngDdcAmt());			// 기타공제_주택마련저축_근로자주택마련저축 공제액
				hsngIncDdcAmtSum.setValue(result.getHsngIncDdcAmtSum());				// 기타공제_주택마련저축소득공제계

				smceSbizUseAmt.setValue(result.getSmceSbizUseAmt());					// 기타공제_소기업공제불입금액
				smceSbizDdcAmt.setValue(result.getSmceSbizDdcAmt());					// 기타공제_소기업공제불입금 공제액

				//2022연말정산_수정 : 19 -> 20, 20 -> 21, 21 -> 22
				
				cpiv20AsctUseAmt.setValue(result.getCpiv20AsctUseAmt());   				// 출자투자금액_조합등_2020납입금
				cpiv20AsctDdcAmt.setValue(result.getCpiv20AsctDdcAmt());   				// 출자투자금액 조합등_2020공제액

				cpiv20VntUseAmt.setValue(result.getCpiv20VntUseAmt());   				// 출자투자금액벤처등_2020납입금액
				cpiv20VntDdcAmt.setValue(result.getCpiv20VntDdcAmt());   				// 출자투자금액벤처등_2020공제액 
				
				cpiv20AsctTwoUseAmt.setValue(result.getCpiv20AsctTwoUseAmt());   				// 출자투자금액_조합2등_2020납입금
				cpiv20AsctTwoDdcAmt.setValue(result.getCpiv20AsctTwoDdcAmt());   				// 출자투자금액 조합2등_2020공제액

				cpiv21AsctUseAmt.setValue(result.getCpiv21AsctUseAmt());   				// 출자투자금액_조합등_2021납입금
				cpiv21AsctDdcAmt.setValue(result.getCpiv21AsctDdcAmt());   				// 출자투자금액 조합등_2021공제액

				cpiv21VntUseAmt.setValue(result.getCpiv21VntUseAmt());   				// 출자투자금액벤처등_2021납입금액
				cpiv21VntDdcAmt.setValue(result.getCpiv21VntDdcAmt());   				// 출자투자금액벤처등_2021공제액 
				
				cpiv21AsctTwoUseAmt.setValue(result.getCpiv21AsctTwoUseAmt());   				// 출자투자금액_조합2등_2021납입금
				cpiv21AsctTwoDdcAmt.setValue(result.getCpiv21AsctTwoDdcAmt());   				// 출자투자금액 조합2등_2021공제액
				
				cpiv22AsctUseAmt.setValue(result.getCpiv22AsctUseAmt());   				// 출자투자금액_조합등_2022납입금
				cpiv22AsctDdcAmt.setValue(result.getCpiv22AsctDdcAmt());   				// 출자투자금액 조합등_2022공제액

				cpiv22VntUseAmt.setValue(result.getCpiv22VntUseAmt());   				// 출자투자금액벤처등_2022납입금액
				cpiv22VntDdcAmt.setValue(result.getCpiv22VntDdcAmt());   				// 출자투자금액벤처등_2022공제액 
				
				cpiv22AsctTwoUseAmt.setValue(result.getCpiv22AsctTwoUseAmt());   				// 출자투자금액_조합2등_2022납입금
				cpiv22AsctTwoDdcAmt.setValue(result.getCpiv22AsctTwoDdcAmt());   				// 출자투자금액 조합2등_2022공제액

				ivcpInvmUseAmtSum.setValue(result.getIvcpInvmUseAmtSum());				// 투자조합출자등소득공제납입금액계
				ivcpInvmDdcAmtSum.setValue(result.getIvcpInvmDdcAmtSum());				// 투자조합출자등소득공제공제액계


				crdcUseAmt.setValue(result.getCrdcUseAmt());								// 기타공제_신용카드등사용금액
				drtpCardUseAmt.setValue(result.getDrtpCardUseAmt() + result.getZrtdUseAmt());						// 기타공제_직불카드등사용금액 + 직불카드_제로페이 사용금액
				cshptUseAmt.setValue(result.getCshptUseAmt());								// 기타공제_현금영수증사용금액
				bookShowAmt.setValue(result.getBookShowAmt());								// 기타공제_지로납부_도서구입
				tdmrUseAmt.setValue(result.getTdmrUseAmt());								// 기타공제_전통시장사용분
				pbtUseAmt.setValue(result.getPbtUseAmt());									// 기타공제_지로납부_대중교통금액
				crdcSumUseAmt.setValue(result.getCrdcSumUseAmt());							// 기타공제_신용카드등사용금액계
				rdcSumDdcAmt.setValue(result.getRdcSumDdcAmt());							// 기타공제_신용카드등사용공제계

//				prsCrdcUseAmt1.setValue(result.getPrsCrdcUseAmt1());					// 본인신용카드등사용액_2014
//				tyYrPrsCrdcUseAmt.setValue(result.getTyYrPrsCrdcUseAmt());				// 본인신용등사용액_2015
//				pyrPrsAddDdcrtUseAmt.setValue(result.getPyrPrsAddDdcrtUseAmt());		// 본인추가공제율사용분_2014  
//				tyShfyPrsAddDdcrtUseAmt.setValue(result.getTyShfyPrsAddDdcrtUseAmt());  // 본인추가공제율사용분_2016_상반기 
				  
				// -------------- 그밖의 소득 공제2 시작 --------------

				emstAsctCntrUseAmt.setValue(result.getEmstAsctCntrUseAmt());			// 기타공제_우리사주출연금액
				empMntnSnmcUseAmt.setValue(result.getEmpMntnSnmcUseAmt());				// 기타공제_고용유지중소기업근로자임금삭감액
				ltrmCniSsUseAmt.setValue(result.getLtrmCniSsUseAmt());					// 기타공제_장기집합투자증권저축금액

				emstAsctCntrDdcAmt.setValue(result.getEmstAsctCntrDdcAmt());			// 기타공제_우리사주출연금공제 공제액
				empMntnSnmcDdcAmt.setValue(result.getEmpMntnSnmcDdcAmt());				// 기타공제_고용유지중소기업근로자임금삭감공제액
				ltrmCniSsDdcAmt.setValue(result.getLtrmCniSsDdcAmt());					// 기타공제_장기집합투자증권저축공제액 
				// -------------- 그밖의 소득 공제2 종료 --------------
				
			}
		});
	}	
	
	
	
	/** 세액감면및세액공제1 정보를 가져옴 **/	
	private void getItemYeta08() {

		Ye161080DTO ye161080Dto = new Ye161080DTO();
		
		ye161080Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161080Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161080Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161080Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300TabItem08ToYe161080Data(ye161080Dto, new AsyncCallback<Ye161080DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getItemYeta08(" + actionDatabase.name() + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(Ye161080DTO result) {
				// TODO Auto-generated method stub
				
				resetItemYeta08();
				
//				reloadYe161090Grid();

				sctcHpUseAmt.setValue(result.getSctcHpUseAmt());						// 과학기술인공제
				sctcHpDdcTrgtAmt.setValue(result.getSctcHpDdcTrgtAmt());				// 과학기술인공제대상금액
				sctcHpDdcAmt.setValue(result.getSctcHpDdcAmt());						// 과학기술인공제액

				rtpnUseAmt.setValue(result.getRtpnUseAmt());							// 근로자퇴직급여보장법
				rtpnDdcTrgtAmt.setValue(result.getRtpnDdcTrgtAmt());					// 근로자퇴직급여보장대상금액
				rtpnDdcAmt.setValue(result.getRtpnDdcAmt());							// 근로자퇴직급여보장법공제액
				
				rtpnIsaUseAmt.setValue(result.getRtpnIsaUseAmt());							// 근로자퇴직급여보장법_ISA
				rtpnDdcIsaTrgtAmt.setValue(result.getRtpnDdcIsaTrgtAmt());					// 근로자퇴직급여보장대상금액_ISA
				rtpnDdcIsaAmt.setValue(result.getRtpnDdcIsaAmt());							// 근로자퇴직급여보장법공제액_ISA

				pnsnSvngUseAmt.setValue(result.getPnsnSvngUseAmt());					// 연금저축
				pnsnSvngDdcTrgtAmt.setValue(result.getPnsnSvngDdcTrgtAmt());			// 연금계축공제대상금액
				pnsnSvngDdcAmt.setValue(result.getPnsnSvngDdcAmt());					// 연금계좌저축공제
				
				pnsnSvngIsaUseAmt.setValue(result.getPnsnSvngIsaUseAmt());					// 연금저축_ISA
				pnsnSvngDdcIsaTrgtAmt.setValue(result.getPnsnSvngDdcIsaTrgtAmt());			// 연금계축공제대상금액_ISA
				pnsnSvngDdcIsaAmt.setValue(result.getPnsnSvngDdcIsaAmt());					// 연금계좌저축공제_ISA

				pnsnAccUseAmtSum.setValue(result.getPnsnAccUseAmtSum());				// 연금계좌계
				pnsnAccDdcTrgtAmtSum.setValue(result.getPnsnAccDdcTrgtAmtSum());		// 연금계좌공제대상금액
				pnsnAccDdcAmtSum.setValue(result.getPnsnAccDdcAmtSum());				// 연금계좌세액공제계

				cvrgInscUseAmt.setValue(result.getCvrgInscUseAmt());					// 일반보장성보험료
				cvrgInscDdcTrgtAmt2.setValue(result.getCvrgInscDdcTrgtAmt2());			// 일반보장성보험료 공제대상금액
				cvrgInscDdcAmt.setValue(result.getCvrgInscDdcAmt());					// 일반보장성보험료 공제액


				dsbrEuCvrgUseAmt.setValue(result.getDsbrEuCvrgUseAmt());				// 장애인전용보험료
				dsbrEuCvrgDdcTrgtAmt.setValue(result.getDsbrEuCvrgDdcTrgtAmt());		// 장애인보장성대상금액
				dsbrEuCvrgDdcAmt.setValue(result.getDsbrEuCvrgDdcAmt()); 				// 장애인보장성대상금액 공제액

				infeePymUseAmtSum.setValue(result.getInfeePymUseAmtSum());				// 보장성보험료계
				infeePymDdcTrgtAmtSum.setValue(result.getInfeePymDdcTrgtAmtSum());		// 보장성보험료대상금액
				infeePymDdcAmtSum.setValue(result.getInfeePymDdcAmtSum());				// 보장성보혐료세액공제금액


				mdxpsSftSprcdUseAmt.setValue(result.getMdxpsSftSprcdUseAmt());			// 난임시술비
				mdxpsSftSprcdDdcTrgtAmt.setValue(result.getMdxpsSftSprcdDdcTrgtAmt());	// 난임시술비 공제대상금액
				mdxpsSftSprcdDdcAmt.setValue(result.getMdxpsSftSprcdDdcAmt());			// 난임시술비  세액공제

				mdxpsPrsUseAmt.setValue(result.getMdxpsPrsUseAmt());					// 본인.65세이상자.장애인
				mdxpsPrsDdcTrgtAmt.setValue(result.getMdxpsPrsDdcTrgtAmt());			// 본인.65세이상자.장애인 공제대상금액
				mdxpsPrsDdcAmt.setValue(result.getMdxpsPrsDdcAmt());					// 본인.65세이상자.장애인 세액공제 

				mdxpsOthUseAmt.setValue(result.getMdxpsOthUseAmt());					// 그 밖의 공제대상자
				mdxpsOthDdcTrgtAmt.setValue(result.getMdxpsOthDdcTrgtAmt());			// 그 밖의 공제대상자공제대상금액
				mdxpsOthDdcAmt.setValue(result.getMdxpsOthDdcAmt());					// 그 밖의 공제대상자  세액공제


				mdxpsUseAmtSum.setValue(result.getMdxpsUseAmtSum());					// 의료비계
				medxpsUseAmtSum.setValue(result.getMedxpsUseAmtSum());					// 실손의료비보전금액
				mdxpsDdcTrgtAmtSum.setValue(result.getMdxpsDdcTrgtAmtSum());			// 의료비 대상금액계
				mdxpsDdcAmtSum.setValue(result.getMdxpsDdcAmtSum());					// 의료비 세액공제액계
				

				scxpsPrsUseAmt.setValue(result.getScxpsPrsUseAmt());					// 본인
				scxpsPrsDdcTrgtAmt.setValue(result.getScxpsPrsDdcTrgtAmt());			// 본인교육비 대상금액
				scxpsPrsDdcAmt.setValue(result.getScxpsPrsDdcAmt());					// 본인 공제액

				scxpsKidCount.setValue(result.getScxpsKidCount());						// 취학전아동수
				scxpsKidUseAmt.setValue(result.getScxpsKidUseAmt());			// 취학전아동 대상금액
				scxpsKidDdcAmt.setValue(result.getScxpsKidDdcAmt());					// 취학전아동 공제액

				scxpsStdCount.setValue(result.getScxpsStdCount());						// 초중고자녀수
				scxpsStdUseAmt.setValue(result.getScxpsStdUseAmt());			// 초중고 대상금액
				scxpsStdDdcAmt.setValue(result.getScxpsStdDdcAmt());					// 초중고 공제액

				scxpsUndCount.setValue(result.getScxpsUndCount());						// 대학생수
				scxpsUndUseAmt.setValue(result.getScxpsUndUseAmt());			// 대학교 대상금액
				scxpsUndDdcAmt.setValue(result.getScxpsUndDdcAmt());					// 대학교 공제액

				scxpsDsbrUseAmt.setValue(result.getScxpsDsbrUseAmt());					// 장애인수
				scxpsDsbrDdcTrgtAmt.setValue(result.getScxpsDsbrDdcTrgtAmt());			// 장애인특수교육비 대상금액
				scxpsDsbrDdcAmt.setValue(result.getScxpsDsbrDdcAmt());					// 장애인특수교육비 공제액

				scxpsUseAmtSum.setValue(result.getScxpsUseAmtSum());					// 교육비계
				scxpsDdcTrgtAmtSum.setValue(result.getScxpsDdcTrgtAmtSum());			// 교육비공제 대상금액 
				scxpsDdcAmtSum.setValue(result.getScxpsDdcAmtSum());					// 교육비세액 공제금액

				conb10ttswLtUseAmt.setValue(result.getConb10ttswLtUseAmt());			// 기부정치자금_10이하 금액  	
				conb10ttswLtDdcTrgtAmt.setValue(result.getConb10ttswLtDdcTrgtAmt());	// 기부정치자금_10이하 대상금액	
				conb10ttswLtDdcAmt.setValue(result.getConb10ttswLtDdcAmt());			// 기부정치자금_10이하  공제세액	

				conb10excsLtUseAmt.setValue(result.getConb10excsLtUseAmt());			// 기부정치자금_10초과	 금액
				conb10excsLtDdcTrgtAmt.setValue(result.getConb10excsLtDdcTrgtAmt());	// 기부정치자금_10초과	 대상금액	
				conb10excsLtDdcAmt.setValue(result.getConb10excsLtDdcAmt());			// 기부정치자금_10초과	  공제세액

				conbLglUseAmt02.setValue(result.getConbLglUseAmt());					// 법정 금액	 
				conbLglDdcTrgtAmt02.setValue(result.getConbLglDdcTrgtAmt());			// 법정 대상금액	
				conbLglDdcAmt02.setValue(result.getConbLglDdcAmt());					// 법정 공제세액


				conbEmstAsctUseAmt.setValue(result.getConbEmstAsctUseAmt());			// 우리사주조합 	
				conbEmstAsctDdcTrgtAmt.setValue(result.getConbEmstAsctDdcTrgtAmt());	// 우리사주종합 대상금액	
				conbEmstAsctDdcAmt.setValue(result.getConbEmstAsctDdcAmt());			// 우리사주조합 공제세액	


				conbReliOrgOthUseAmt02.setValue(result.getConbReliOrgOthUseAmt());			// 지정기부금종교단체외기부금액	
				conbReliOrgOthDdcTrgtAmt02.setValue(result.getConbReliOrgOthDdcTrgtAmt());	// 지정기부금종교단체외공제대상금액	
				conbReliOrgOthDdcAmt02.setValue(result.getConbReliOrgOthDdcAmt());			// 지정기부금종교단체외공제세액	

				conbReliOrgUseAmt02.setValue(result.getConbReliOrgUseAmt());			// 지정기부금종교단체기부금액
				conbReliOrgDdcTrgtAmt02.setValue(result.getConbReliOrgDdcTrgtAmt());	// 지정기부금종교단체공제대상금액	
				conbReliOrgDdcAmt02.setValue(result.getConbReliOrgDdcAmt());			// 지정기부금종교단체공제세액

				conbUseAmtSum02.setValue(result.getConbUseAmtSum());					// 기부금납입금액합계	
				conbDdcTrgtAmtSum02.setValue(result.getConbDdcTrgtAmtSum());			// 기부금공제대상금액합계	
				conbDdcAmtSum02.setValue(result.getConbDdcAmtSum());					// 기부금공제세액합계
				    
			}
		});		
		
	}
	
	
			
	/** 세액감면및세액공제2 정보를 가져옴 **/	
	private void getItemYeta09() {

		Ye161080DTO ye161080Dto = new Ye161080DTO();
		
		ye161080Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161080Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161080Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161080Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300TabItem09ToYe161080Data(ye161080Dto, new AsyncCallback<Ye161080DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getItemYeta08(" + actionDatabase.name() + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Ye161080DTO result) {
				// TODO Auto-generated method stub
				
				resetItemYeta09();
				
//				frgrLbrrEntcPupCd;		// 세액공제_외국인_입국목적코드
				frgrLbrrEntcPupCd1.setValue(result.getFrgrLbrrEntcPupCd1()); 
				frgrLbrrEntcPupCd2.setValue(result.getFrgrLbrrEntcPupCd2());
				frgrLbrrEntcPupCd3.setValue(result.getFrgrLbrrEntcPupCd3());
				frgrLbrrEntcPupCd4.setValue(result.getFrgrLbrrEntcPupCd4());
//
				frgrLbrrLbrOfrDt.setValue(GWTUtils.getDateFromString(result.getFrgrLbrrLbrOfrDt(), "yyyyMMdd"));			// 세액공제_외국인_근로제공일자
				frgrLbrrReExryDt.setValue(GWTUtils.getDateFromString(result.getFrgrLbrrReExryDt(), "yyyyMMdd"));			// 세액공제_외국인_감면기간만료일자
				frgrLbrrReRcpnDt.setValue(GWTUtils.getDateFromString(result.getFrgrLbrrReRcpnDt(), "yyyyMMdd"));			// 세액공제_외국인_감면신청접수일자
				frgrLbrrReAlfaSbmsDt.setValue(GWTUtils.getDateFromString(result.getFrgrLbrrReAlfaSbmsDt(), "yyyyMMdd"));	// 세액공제_외국인_감면신청제출일자
//				    
////				    private MSFDateField txlgFrrd;		//세액공제_외국인해저광물개발감면확인일자
////				    private MSFDateField txlgFrid;		//세액공제_외국인해저광물개발감면신청일자
				frgrLbrrErinImnRcpnDt.setValue(GWTUtils.getDateFromString(result.getFrgrLbrrErinImnRcpnDt(), "yyyyMMdd"));	// 세액공제_근로소득조세조약상면제접수일자
				frgrLbrrErinImnSbmsDt.setValue(GWTUtils.getDateFromString(result.getFrgrLbrrErinImnSbmsDt(), "yyyyMMdd"));	// 세액공제_근로소득조세조약상면제제출일자

				yupSnmcReStrtDt.setValue(GWTUtils.getDateFromString(result.getYupSnmcReStrtDt(), "yyyyMMdd"));				// 세액공제_중소기업청년감면취업일자
				yupSnmcReEndDt.setValue(GWTUtils.getDateFromString(result.getYupSnmcReEndDt(), "yyyyMMdd"));				// 세액공제_중소기업청년감면종료일자

				txlgItctAmnt.setValue(result.getTxlgItctAmnt());		// 세액감면_소득세법감면세액 		
				yetaC114.setValue(result.getYetaC114());				// 세액감면_소득세법			
				txlgFrtaAmnt.setValue(result.getTxlgFrtaAmnt());		// 세액감면_외국인기술자감면세액	 
				yetaC115.setValue(result.getYetaC115());				// 세액공제_외국인감면세액		
				txlgBstaAmnt.setValue(result.getTxlgBstaAmnt());		// 세액감면_취업청년감면대상총급여액		
				txlgWktaAmnt.setValue(result.getTxlgWktaAmnt());		// 세액감면_취업청년감면근로자총급여액
				txlgTxtyAmnt.setValue(result.getTxlgTxtyAmnt());		// 세액감면_조세조약감면세액		
				yetaC117.setValue(result.getYetaC117());				// 세액감면_조세조약		
				txlgCltaAmnt.setValue(result.getTxlgCltaAmnt());		// 세액감면_계산감면세액금액
				yetaC116.setValue(result.getYetaC116());				// 세액감면_감면세액

				ovrsSurcIncFmt.setValue(result.getOvrsSurcIncFmt());					// 세액공제_외국납부_국외원천소득금액
				frgnPmtFcTxamt.setValue(result.getFrgnPmtFcTxamt());					// 세액공제_외국납부_외화납세액
				frgnPmtWcTxamt.setValue(result.getFrgnPmtWcTxamt());					// 세액공제_외국납부_원화납세액
				frgnPmtTxamtTxpNtnNm.setValue(result.getFrgnPmtTxamtTxpNtnNm());		// 세액공제_외국납부_납세국명
				frgnPmtTxamtPmtDt.setValue(GWTUtils.getDateFromString(result.getFrgnPmtTxamtPmtDt(), "yyyyMMdd"));				// 세액공제_외국납부_납부일자
				frgnPmtTxamtAlfaSbmsDt.setValue(GWTUtils.getDateFromString(result.getFrgnPmtTxamtAlfaSbmsDt(), "yyyyMMdd"));	// 세액공제_외국납부_신청서제출일자
				frgnPmtTxamtAbrdWkarNm.setValue(result.getFrgnPmtTxamtAbrdWkarNm());	// 세액공제_외국납부_국외근무처명
				frgnPmtTxamtRfoNm.setValue(result.getFrgnPmtTxamtRfoNm());				// 세액공제_외국납부_직책

				frgnDtyTermStdt.setValue(GWTUtils.getDateFromString(result.getFrgnDtyTermStdt(), "yyyyMMdd"));			// 세액공제_외국납부_근무시작일자
				frgnDtyTermEddt.setValue(GWTUtils.getDateFromString(result.getFrgnDtyTermEddt(), "yyyyMMdd"));			// 세액공제_외국납부_근무종료일자
//				    
////				    private MSFNumberField taxdUnin;	//세액공제_납세조합공제
////				    private MSFNumberField taxdUnin01;		//세액공제_납세조합공제
//				    	
				hsngTennLnpbUseAmt.setValue(result.getHsngTennLnpbUseAmt());			// 세액공제_주택차입금이자상황금액
				hsngTennLnpbDdcAmt.setValue(result.getHsngTennLnpbDdcAmt());			// 세액공제_주택차입금
				    	
				mmrUseAmt.setValue(result.getMmrUseAmt());								// 월세금액
				mmrDdcAmt.setValue(result.getMmrDdcAmt());								// 월세공제액
						
			}
		});		
		
	}
	
	
			
	/** 추가제출서류 정보를 가져옴 **/	
	private void getItemYeta10() {

		Ye161080DTO ye161080Dto = new Ye161080DTO();
		
		ye161080Dto.setDpobCd(dpobCd.getValue());    		/** column 사업장코드 : dpobCd */
		ye161080Dto.setYrtxBlggYr(yrtxBlggYr.getValue());	/** column 귀속연도 : yrtxBlggYr */
		ye161080Dto.setClutSeptCd(clutSeptCd.getValue());	/** column 연말정산구분코드 : clutSeptCd */
		ye161080Dto.setSystemkey(systemkey.getValue());    	/** column SYSTEMKEY : systemkey */
		
		yeta7300Service.getYeta7300TabItem10ToYe161080Data(ye161080Dto, new AsyncCallback<Ye161080DTO>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getItemYeta10(" + actionDatabase.name() + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Ye161080DTO result) {
				// TODO Auto-generated method stub
				
				resetItemYeta10();
				
				YetaUtils.setCheckedRadioValue(d219, result.getD219());													// 1.외국인근로자 단말세율적용신청서 제출여부
				YetaUtils.setCheckedRadioValue(cd225, result.getCd225());												// 2.연금, 저축 등 소득공제 명세서 제출 여부
				YetaUtils.setCheckedRadioValue(cd226, result.getCd226());												// 3.월세액.비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부
				
				YetaUtils.setCheckedRadioValue(cd227, result.getCd227());												// 의료비지급 명세서
				YetaUtils.setCheckedRadioValue(cd228, result.getCd228());												// 기부금 명세서
				YetaUtils.setCheckedRadioValue(prcspWorkIncmSumtYn, result.getPrcspWorkIncmSumtYn());					//소득공제 증빙서류
				YetaUtils.setCheckedRadioValue(fileAppPaprSbtYn, result.getFileAppPaprSbtYn());							// 소득공제신고서제출여부
				incmDducWtnnteSumtDt.setValue(GWTUtils.getDateFromString(result.getIncmDducWtnnteSumtDt(), "yyyyMMdd"));// 소득공제신고서제출여부_제출일자
				
			}
		});		
	}
	
	
			

	
	
	/** 세액계산 grid 조회 **/
	private void reloadYe169010(){
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
		IColumnFilter filters = null;
		
		Yeta7300ToYe169010GridPanel.getTableDef().setTableColumnFilters(filters);
		
		Yeta7300ToYe169010GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe169010GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe169010GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta7300ToYe169010GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta7300ToYe169010GridPanel.getTableDef().addColumnFilter("c152StdTxDdcYn", c152StdTxDdcYn.getValue()?"Y" : "N", SimpleColumnFilter.OPERATOR_EQUALS); 
			
		Yeta7300ToYe169010GridPanel.reload();
		
	}	
	
	
	
	/** 인적공제 grid 조회 **/
	private void reloadYe161030(){
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		IColumnFilter filters = null;
		
		Yeta7300ToYe161030GridPanel.getTableDef().setTableColumnFilters(filters);
		
		Yeta7300ToYe161030GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161030GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161030GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta7300ToYe161030GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		Yeta7300ToYe161030GridPanel.reload();
		
	}
	
	
	/** 소득공제 grid 조회 **/
	private void reloadYe161040_item03Grid(){
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		IColumnFilter filters = null;
		
		Yeta7300ToYe161040GridPanel_01.getTableDef().setTableColumnFilters(filters);
		
		Yeta7300ToYe161040GridPanel_01.getTableDef().addColumnFilter("dpobCd"		, MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161040GridPanel_01.getTableDef().addColumnFilter("systemkey"	, MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161040GridPanel_01.getTableDef().addColumnFilter("clutSeptCd"	, MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta7300ToYe161040GridPanel_01.getTableDef().addColumnFilter("yrtxBlggYr"	, MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta7300ToYe161040GridPanel_01.getTableDef().addColumnFilter("cdVvalKrnCd"	, "Y0140000", SimpleColumnFilter.OPERATOR_EQUALS); 
			
		Yeta7300ToYe161040GridPanel_01.reload();
		
		Yeta7300ToYe161040GridPanel_02.getTableDef().setTableColumnFilters(filters);
		
		Yeta7300ToYe161040GridPanel_02.getTableDef().addColumnFilter("dpobCd"		, MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161040GridPanel_02.getTableDef().addColumnFilter("systemkey"	, MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		Yeta7300ToYe161040GridPanel_02.getTableDef().addColumnFilter("clutSeptCd"	, MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta7300ToYe161040GridPanel_02.getTableDef().addColumnFilter("yrtxBlggYr"	, MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		Yeta7300ToYe161040GridPanel_02.getTableDef().addColumnFilter("cdVvalKrnCd"	, "Y0140001", SimpleColumnFilter.OPERATOR_EQUALS); 
			
		Yeta7300ToYe161040GridPanel_02.reload();
		
	}
	
	
//	/** 가족교육비 grid 조회 **/
//	private void reloadYe161090Grid(){
//
//		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//			return;
//		}
//		
//		IColumnFilter filters = null;
//		
//		Yeta7300ToYe161090GridPanel.getTableDef().setTableColumnFilters(filters);
//			
//		Yeta7300ToYe161090GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
//		Yeta7300ToYe161090GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//		Yeta7300ToYe161090GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.allowNulls(clutSeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//		Yeta7300ToYe161090GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(yrtxBlggYr.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			
//		Yeta7300ToYe161090GridPanel.reload();
//		
//	}
	
	
	
	
	/** 검색조건 초기화 **/
	public void resetSearchForm() { 

		srhYrtxBlggYr.setValue( lsClutYrStore.findModel("year","2022"));
		srhClutSeptCd.setValue(lsClutSeptCd.getAt(0));
		
		srhHanNm.setValue("");
		srhResnRegnNum.setValue("");
		utDpobCd.setValue("");
		utDpobNm.setValue("");
		 
	}
	
	
	/** 대상자정보  초기화 **/
	public void resetYeta300ToYeta2000Grid() {
		Yeta7300ToYe161010GridPanel.getMsfGrid().clearData();
	}
	
	/** 기본사항 초기화 **/
	public void resetItemYeta01() {
		
		
		fileSbtYn.setValue(false);								// 소득공제신고전자파일제출여부
		fileSbtBtn.setEnabled(true);
		
		
		//		{기본사항}
		((Radio)hshrClCd.get(0)).setValue(false);				// 세대주여부
		    
		rsplNtnInfrCd.setValue("");								// 국적코드
		rsplNtnInfrNm.setValue("");								// 국적명
		rsplNtnInfrItem.setValue(""); 							// 국적코드 두자리
			    
		dtyStrtDt.reset();										// 근무 시작 일자
		dtyEndDt.reset();										// 근무 종료 일자
		reStrtDt.reset();										// 감면 시작 일자 
		reEndDt.reset();										// 감면 종료 일자
			 
		((Radio)rsdtClCd.get(0)).setValue(false);				// 거주구분여부
			    
		rsplNtnCd.setValue("");									// 거주지국코드
		rsplNtnNm.setValue("");									// 거주지국명
		rsplNtnItem.setValue(""); 								// 거주지국 두자리
		    
		inpmYn.setValue(false);									// 분납신청여부
		c152StdTxDdcYn.setValue(false);							// 표준세액공제적용여부
		inctxWhtxTxamtMetnCd.setValue(new BaseModel());			// 소득세원천징수세액조정구분코드   
			
		
		prcspPaySum.clear();		  							// 종근무지_급여총액
		yeta0c29.clear();										// 주근무지_급여총액
		yeta0c63.clear();										// 총급여_현_전

		yeta0c64.clear();										// 근로소득공제
		yeta0c65.clear();										// 근로소득금액
		yetaC120.clear();										// 세액공제_근로소득세액공제
		
	}
	
	/** 인적공제 초기화 **/
	public void resetItemYeta02() {
		
		//	{인적공제}

		Yeta7300ToYe161030GridPanel.getMsfGrid().clearData();
	    ((Radio)prifChngYn.get(0)).setValue(false);				// 인적공제항목변동여부
	    addrMrct.clear();										// 추가공제_다자녀인원수
	    addrMccr.clear();										// 세액공제_자녀세액공제금액
		
	}
	
	/** 소득공제 초기화 **/
	public void resetItemYeta03() {
		
		//	{소득공제}
		Yeta7300ToYe161040GridPanel_01.getMsfGrid().clearData();
		Yeta7300ToYe161040GridPanel_02.getMsfGrid().clearData();
		
	}
	
	
	/** 연금보험료공제 초기화 **/
	public void resetItemYeta04() {
		
		// 	{연금보험료}
	    //--국민보험료
		npHthrWaInfeeAmt.clear();								// 종근무지_국민연금보험료
		npHthrWaInfeeDdcAmt.clear();								// 종근무지_국민연금보험료공제

		npHthrMcurWkarInfeeAmt.clear();								// 주근무지_국민연금보험료
		npHthrMcurWkarDdcAmt.clear();								// 주근무지_국민연금보험료공제

		npHthrAreaInfeeAmt.clear();								// 국민연금지역보험료
		npHthrAreaDdcAmt.clear();								// 국민연금지역보험료공제
		    

		 //--국민연금보험료외의 연금보험료
		puoferAnty_02.clear();									// 종근무지_국민연금외공무원연금
		puoferAnty_01.clear();									// 주근무지_국민연금외공무원연금

		mltymAnty_02.clear();									// 종근무지_국민연금외군인연금
		mltymAnty_01.clear();									// 주근무지_국민연금외군인연금

		prtafirSchlFalymmAnty_02.clear();						// 종근무지_국인연금외교직원연금
		prtafirSchlFalymmAnty_01.clear();						// 주근무지_국인연금외교직원연금

		spildtnPstoficAnty_02.clear();							// 종근무지_국민연금외별정우체국
		spildtnPstoficAnty_01.clear();	 						// 주근무지_국민연금외별정우체국

		puoferAntyDducSum_02.clear();							// 종근무지_국민연금외공무원연금공제
		puoferAntyDducSum_01.clear();							// 주근무지_공무원연금보험료공제

		mltymAntyDducSum_02.clear();							// 종근무지_국민연금외군인연금공제
		mltymAntyDducSum_01.clear();							// 주근무지_국민연금외군인연금공제

		prtafirSchlDducSum_02.clear();							// 종근무지_국민연금외교직원연금공제
		prtafirSchlDducSum_01.clear();							// 주근무지_국민연금외교직원연금공제

		spildtnPstoficDducSum_02.clear();						// 종근무지_별정우체국연금보험료공제
		spildtnPstoficDducSum_01.clear();						// 주근무지_별정우체국연금보험료공제

		pnsnInfeeUseAmtSum.clear();								// 연금보험료계
		pnsnInfeeDdcAmtSum.clear();								// 연금보험료공제계
		
	}
	
	
	/** 특별소득공제 초기화 **/
	public void resetItemYeta05() {
		
		//	{특별공제 보험료}
	    // -- 보험료
		hthrHifeAmt.clear();									// 특별공제_종건강보험료
		mcurHifeAmt.clear();									// 특별공제_주건강보험료
		hthrHifeDdcAmt.clear();									// 특별공제_종건강보험료 공제액
		mcurHifeDdcAmt.clear();									// 특별공제_주건강보험료 공제액
		mcurHifeAreaAmt.clear();								// 특별공제_건강지역보험료
		mcurHifeAreaDdcAmt.clear();								// 특별공제_건강지역보험료 공제액

		hthrUiAmt.clear();										// 특별공제_종고용보험료
		mcurUiAmt.clear();										// 특별공제_주고용보험료
		hthrUiDdcAmt.clear();									// 특별공제_종고용보험료 공제액
		mcurUiDdcAmt.clear();									// 특별공제_주고용보험료 공제액

		infeeUseAmtSum.clear();									// 특별공제_보험료계
		infeeDdcAmtSum.clear();									// 특별공제_보험료계

		    // -- 주택자금
		brwLnpbSrmAmt.clear();									// 특별공제_차입금원리금상환액_대출기관
		brwLnpbSrmDdcAmt.clear();								// 특별공제_차입금원리금상환액_거주자

		rsdtLnpbSrmAmt.clear();									// 특별공제_차입금원리금상환액_대출기관 공제액
		rsdtLnpbSrmDdcAmt.clear();								// 특별공제_차입금원리금상환액_거주자 공제액

		lthYr15BlwItrAmt.clear();								// 특별공제_11장기주택저당차입금15
		lthYr29ItrAmt.clear();									// 특별공제_11장기주택저당차입금29
		lthY30OverItrAmt.clear();								// 특별공제_11장기주택저당차입금30

		lthYr15BlwDdcAmt.clear();								// 특별공제_11장기주택저당차입금15 공제액
		lthYr29DdcAmt.clear();									// 특별공제_11장기주택저당차입금29 공제액
		lthY30OverDdcAmt.clear();								// 특별공제_11장기주택저당차입금30 공제액

		lthYr2012AfthY15Amt.clear();							// 특별공제_12장기주택저당차입금_고정
		lthYr2012EtcBrwItrAmt.clear();							// 특별공제_12장기주택저당차입금_기타

		lthYr2012AfthY15DdcAmt.clear();							// 특별공제_12장기주택저당차입금_고정  공제액
		lthYr2012EtcBrwDdcAmt.clear();							// 특별공제_12장기주택저당차입금_기타  공제액

		lthYr2015AfthFxnIrItrAmt.clear();						// 특별공제_15장기주택저당_15고정AND비거치상환
		lthYr2015AfthY15Amt.clear();							// 특별공제_15장기주택저당_15고정OR비거치상환
		lthYr2015AfthEtcAmt.clear();							// 특별공제_15장기주택저당_15기타대출
		lthYr2015AfthYr15Amt.clear();							// 특별공제_15장기주택저당_10고정OR비거치상환

		lthYr2015AfthFxnIrDdcAmt.clear();						// 특별공제_15장기주택저당_15고정AND비거치상환 공제액
		lthYr2015AfthY15DdcAmt.clear();							// 특별공제_15장기주택저당_15고정OR비거치상환 공제액
		lthYr2015AfthEtcDdcAmt.clear();							// 특별공제_15장기주택저당_15기타대출 공제액
		lthYr2015AfthYr15DdcAmt.clear();						// 특별공제_15장기주택저당_10고정OR비거치상환 공제액

		hsngFndsDdcAmtSum.clear();								// 특별공제_주택자금공제액계
		
	}
	
	/** 그밖의소득공제1 초기화 **/
	public void resetItemYeta06() {
		
//		{그밖의 소득 공제 }
	    // -------------- 그밖의 소득 공제1 시작 --------------
		yr2000PnsnSvngUseAmt.clear();							// 개인연금저축불입액_2000년이전
		yr2000PnsnSvngDdcAmt.clear();							// 개인연금저축불입액_2000년이전

		sbcSvngUseAmt.clear();									// 기타공제_주택마련저축_청약저축
		hsngSvngUseAmt.clear();									// 기타공제_주택마련저축_주택청약종합저축

		lbrrPrptSvngUseAmt.clear();								// 기타공제_주택마련저축_근로자주택마련저축
		hsngIncUseAmtSum.clear();								// 기타공제_주택마련저축소득금액

		sbcSvngDdcAmt.clear();									// 기타공제_주택마련저축_청약저축 공제액
		hsngSvngDdcAmt.clear();									// 기타공제_주택마련저축_주택청약종합저축 공제액

		lbrrPrptSvngDdcAmt.clear();								// 기타공제_주택마련저축_근로자주택마련저축 공제액
		hsngIncDdcAmtSum.clear();								// 기타공제_주택마련저축소득공제계

		smceSbizUseAmt.clear();									// 기타공제_소기업공제불입금액
		smceSbizDdcAmt.clear();									// 기타공제_소기업공제불입금 공제액

//		cpiv14AsctUseAmt.clear();								// 출자투자금액_조합등_2014납입금액  
//		cpiv14AsctDdcAmt.clear();								// 출자투자금액_조합등_2014공제액 
//
//		cpiv14VntUseAmt.clear();   								// 출자투자금액_벤처등_2014납입금액 
//		cpiv14VntDdcAmt.clear();   								// 출자투자금액_벤처등_2014공제액

/*		cpiv15AsctUseAmt.clear();								// 출자투자금액_조합등_2015납입금액
		cpiv15AsctDdcAmt.clear();								// 출자투자금액_조합등_2015공제액

		cpiv15VntUseAmt.clear();   								// 출자투자금액_벤처등_2015납입금액
		cpiv15VntDdcAmt.clear();   								// 출자투자금액_벤처등_2015공제액
*/
		/*cpiv17AsctUseAmt.clear();   							// 출자투자금액_조합등_2017납입금
		cpiv17AsctDdcAmt.clear();   							// 출자투자금액 조합등_2017공제액

		cpiv17VntUseAmt.clear();   								// 출자투자금액벤처등_2017납입금액
		cpiv17VntDdcAmt.clear();   								// 출자투자금액벤처등_2017공제액
*/
		cpiv20AsctUseAmt.clear();   							// 출자투자금액_조합등_2020납입금
		cpiv20AsctDdcAmt.clear();   							// 출자투자금액 조합등_2020공제액

		cpiv20VntUseAmt.clear();   								// 출자투자금액벤처등_2020납입금액
		cpiv20VntDdcAmt.clear();   								// 출자투자금액벤처등_2020공제액 
		
		cpiv20AsctTwoUseAmt.clear();   							// 출자투자금액_조합2등_2020납입금
		cpiv20AsctTwoDdcAmt.clear();   							// 출자투자금액 조합2등_2020공제액

		cpiv21AsctUseAmt.clear();   							// 출자투자금액_조합등_2021납입금
		cpiv21AsctDdcAmt.clear();   							// 출자투자금액 조합등_2021공제액

		cpiv21VntUseAmt.clear();   								// 출자투자금액벤처등_2021납입금액
		cpiv21VntDdcAmt.clear();   								// 출자투자금액벤처등_2021공제액
		
		cpiv21AsctTwoUseAmt.clear();   							// 출자투자금액_조합2등_2021납입금
		cpiv21AsctTwoDdcAmt.clear();   							// 출자투자금액 조합2등_2021공제액
		
		cpiv22AsctUseAmt.clear();   							// 출자투자금액_조합등_2022납입금
		cpiv22AsctDdcAmt.clear();   							// 출자투자금액 조합등_2022공제액

		cpiv22VntUseAmt.clear();   								// 출자투자금액벤처등_2022납입금액
		cpiv22VntDdcAmt.clear();   								// 출자투자금액벤처등_2021공제액
		
		cpiv22AsctTwoUseAmt.clear();   							// 출자투자금액_조합2등_2022납입금
		cpiv22AsctTwoDdcAmt.clear();   							// 출자투자금액 조합2등_2022공제액
		
		ivcpInvmUseAmtSum.clear();								// 투자조합출자등소득공제납입금액계
		ivcpInvmDdcAmtSum.clear();								// 투자조합출자등소득공제공제액계

		drtpCardUseAmt.clear();									// 기타공제_직불카드등사용금액
		cshptUseAmt.clear();									// 기타공제_현금영수증사용금액
		bookShowAmt.clear();										// 기타공제_지로납부_도서구입
		tdmrUseAmt.clear();										// 기타공제_전통시장사용분
		pbtUseAmt.clear();										// 기타공제_지로납부_대중교통금액
		crdcSumUseAmt.clear();									// 기타공제_신용카드등사용금액계
		rdcSumDdcAmt.clear();									// 기타공제_신용카드등사용공제계

//		tyYrPrsCrdcUseAmt.clear();								// 본인신용등사용액_2015
//		pyrPrsAddDdcrtUseAmt.clear();							// 본인추가공제율사용분_2014  
//		tyShfyPrsAddDdcrtUseAmt.clear();  						// 본인추가공제율사용분_2016_상반기 
		  
		emstAsctCntrUseAmt.clear();								// 기타공제_우리사주출연금액
		empMntnSnmcUseAmt.clear();								// 기타공제_고용유지중소기업근로자임금삭감액
		ltrmCniSsUseAmt.clear();								// 기타공제_장기집합투자증권저축금액
		
	}
	
	
	/** 그밖의소득공제2 초기화 **/
	public void resetItemYeta07() {
		
		emstAsctCntrDdcAmt.clear();								// 기타공제_우리사주출연금공제 공제액
		empMntnSnmcDdcAmt.clear();								// 기타공제_고용유지중소기업근로자임금삭감공제액
		ltrmCniSsDdcAmt.clear();								// 기타공제_장기집합투자증권저축공제액 
		
	}
	
	/** 세액감면및세액공제1  초기화 **/
	public void resetItemYeta08() {
		
//		{세액감면 및 세액공제 }
	    //--연금계좌및보험료
		sctcHpUseAmt.clear();									// 과학기술인공제
		sctcHpDdcTrgtAmt.clear();								// 과학기술인공제대상금액
		sctcHpDdcAmt.clear();									// 과학기술인공제액

		rtpnUseAmt.clear();										// 근로자퇴직급여보장법
		rtpnDdcTrgtAmt.clear();									// 근로자퇴직급여보장대상금액
		rtpnDdcAmt.clear();										// 근로자퇴직급여보장법공제액
		
		rtpnIsaUseAmt.clear();										// 근로자퇴직급여보장법_ISA
		rtpnDdcIsaTrgtAmt.clear();									// 근로자퇴직급여보장대상금액_ISA
		rtpnDdcIsaAmt.clear();										// 근로자퇴직급여보장법공제액_ISA

		pnsnSvngUseAmt.clear();									// 연금저축
		pnsnSvngDdcTrgtAmt.clear();								// 연금계축공제대상금액
		pnsnSvngDdcAmt.clear();									// 연금계좌저축공제
		
		pnsnSvngIsaUseAmt.clear();									// 연금저축_ISA
		pnsnSvngDdcIsaTrgtAmt.clear();								// 연금계축공제대상금액_ISA
		pnsnSvngDdcIsaAmt.clear();									// 연금계좌저축공제_ISA
			
		pnsnAccUseAmtSum.clear();								// 연금계좌계
		pnsnAccDdcTrgtAmtSum.clear();							// 연금계좌공제대상금액
		pnsnAccDdcAmtSum.clear();								// 연금계좌세액공제계

		cvrgInscUseAmt.clear();									// 일반보장성보험료
		cvrgInscDdcTrgtAmt2.clear();							// 일반보장성보험료 공제대상금액
		cvrgInscDdcAmt.clear();									// 일반보장성보험료 공제액

		dsbrEuCvrgUseAmt.clear();								// 장애인전용보험료
		dsbrEuCvrgDdcTrgtAmt.clear();							// 장애인보장성대상금액
		dsbrEuCvrgDdcAmt.clear(); 								// 장애인보장성대상금액 공제액

		infeePymUseAmtSum.clear();								// 보장성보험료계
		infeePymDdcTrgtAmtSum.clear();							// 보장성보험료대상금액
		infeePymDdcAmtSum.clear();								// 보장성보혐료세액공제금액

		//--의료비
		mdxpsSftSprcdUseAmt.clear();							// 난임시술비
		mdxpsSftSprcdDdcTrgtAmt.clear();						// 난임시술비 공제대상금액
		mdxpsSftSprcdDdcAmt.clear();							// 난임시술비  세액공제

		mdxpsPrsUseAmt.clear();									// 본인.65세이상자.장애인
		mdxpsPrsDdcTrgtAmt.clear();								// 본인.65세이상자.장애인 공제대상금액
		mdxpsPrsDdcAmt.clear();									// 본인.65세이상자.장애인 세액공제 

		mdxpsOthUseAmt.clear();									// 그 밖의 공제대상자
		mdxpsOthDdcTrgtAmt.clear();								// 그 밖의 공제대상자공제대상금액
		mdxpsOthDdcAmt.clear();									// 그 밖의 공제대상자  세액공제

		mdxpsUseAmtSum.clear();									// 의료비계
		mdxpsDdcTrgtAmtSum.clear();								// 의료비 대상금액계
		mdxpsDdcAmtSum.clear();									// 의료비 세액공제액계
		
		medxpsUseAmtSum.clear();								//실손보험금보전금액계
		    	

		//--교육비
		scxpsPrsUseAmt.clear();									// 본인
		scxpsPrsDdcTrgtAmt.clear();								// 본인교육비 대상금액
		scxpsPrsDdcAmt.clear();									// 본인 공제액

		scxpsKidCount.clear();									// 취학전아동수
		scxpsKidUseAmt.clear();									// 취학전아동 대상금액
		scxpsKidDdcAmt.clear();									// 취학전아동 공제액

		scxpsStdCount.clear();									// 초중고자녀수
		scxpsStdUseAmt.clear();								// 초중고 대상금액
		scxpsStdDdcAmt.clear();									// 초중고 공제액

		scxpsUndCount.clear();									// 대학생수
		scxpsUndUseAmt.clear();								// 대학교 대상금액
		scxpsUndDdcAmt.clear();									// 대학교 공제액

		scxpsDsbrUseAmt.clear();								// 장애인 
		scxpsDsbrDdcTrgtAmt.clear();							// 장애인특수교육비 대상금액
		scxpsDsbrDdcAmt.clear();								// 장애인특수교육비 공제액

		scxpsUseAmtSum.clear();									// 교육비계
		scxpsDdcTrgtAmtSum.clear();								// 교육비공제 대상금액 
		scxpsDdcAmtSum.clear();									// 교육비세액 공제금액
		    
		    //--기부금
		conb10ttswLtUseAmt.clear();								// 기부정치자금_10이하 금액  	
		conb10ttswLtDdcTrgtAmt.clear();							// 기부정치자금_10이하 대상금액	
		conb10ttswLtDdcAmt.clear();								// 기부정치자금_10이하  공제세액	

		conb10excsLtUseAmt.clear();								// 기부정치자금_10초과	 금액
		conb10excsLtDdcTrgtAmt.clear();							// 기부정치자금_10초과	 대상금액	
		conb10excsLtDdcAmt.clear();								// 기부정치자금_10초과	  공제세액

		conbLglUseAmt02.clear();								// 법정 금액	 
		conbLglDdcTrgtAmt02.clear();							// 법정 대상금액	
		conbLglDdcAmt02.clear();								// 법정 공제세액

		conbEmstAsctUseAmt.clear();								// 우리사주조합 	
		conbEmstAsctDdcTrgtAmt.clear();							// 우리사주종합 대상금액	
		conbEmstAsctDdcAmt.clear();								// 우리사주조합 공제세액	

		conbReliOrgOthUseAmt02.clear();							// 지정기부금종교단체외기부금액	
		conbReliOrgOthDdcTrgtAmt02.clear();						// 지정기부금종교단체외공제대상금액	
		conbReliOrgOthDdcAmt02.clear();							// 지정기부금종교단체외공제세액	

		conbReliOrgUseAmt02.clear();							// 지정기부금종교단체기부금액
		conbReliOrgDdcTrgtAmt02.clear();						// 지정기부금종교단체공제대상금액	
		conbReliOrgDdcAmt02.clear();							// 지정기부금종교단체공제세액

		conbUseAmtSum02.clear();								// 기부금납입금액합계	
		conbDdcTrgtAmtSum02.clear();							// 기부금공제대상금액합계	
		conbDdcAmtSum02.clear();								// 기부금공제세액합계

		conbLglUseAmt01.clear();								// 이월법정기부금액
		conbReliOrgOthUseAmt01.clear();							// 이월종교단체외기부금
		conbReliOrgUseAmt01.clear();							// 이월종교단체기부금

		conbLglDdcAmt01.clear();								// 이월법정기부금액_공제액
		conbReliOrgOthDdcAmt01.clear();							// 이월종교단체외기부금_공제액
		conbReliOrgDdcAmt01.clear();							// 이월종교단체기부금_공제액

		conbUseAmtSum01.clear();								// 기부금(이월분)	
		conbDdcAmtSum01.clear();								// 지정기부금 공제합계
	}
	
	
	/** 세액감면및세액공제2 초기화 **/
	public void resetItemYeta09() {
		
		frgrLbrrEntcPupCd1.setValue(false);
		frgrLbrrEntcPupCd2.setValue(false);
		frgrLbrrEntcPupCd3.setValue(false);
		frgrLbrrEntcPupCd4.setValue(false);
		    
		frgrLbrrLbrOfrDt.reset();								// 세액공제_외국인_근로제공일자
		frgrLbrrReExryDt.reset();								// 세액공제_외국인_감면기간만료일자
		frgrLbrrReRcpnDt.reset();								// 세액공제_외국인_감면신청접수일자
		frgrLbrrReAlfaSbmsDt.reset();							// 세액공제_외국인_감면신청제출일자

		frgrLbrrErinImnRcpnDt.reset();							// 세액공제_근로소득조세조약상면제접수일자
		frgrLbrrErinImnSbmsDt.reset();							// 세액공제_근로소득조세조약상면제제출일자

		yupSnmcReStrtDt.reset();								// 세액공제_중소기업청년감면취업일자
		yupSnmcReEndDt.reset();									// 세액공제_중소기업청년감면종료일자
		    	
		txlgItctAmnt.clear();									// 세액감면_소득세법감면세액
		yetaC114.clear();										// 세액감면_소득세법

		txlgBstaAmnt.clear();									// 세액감면_취업청년감면대상총급여액
		txlgWktaAmnt.clear();									// 세액감면_취업청년감면근로자총급여액

		txlgCltaAmnt.clear();									// 세액감면_계산감면세액금액
		yetaC116.clear();										// 세액감면_감면세액계

		txlgFrtaAmnt.clear();									// 세액감면_외국인기술자감면세액
		yetaC115.clear();										// 세액공제_외국인감면세액

		txlgTxtyAmnt.clear();									// 세액감면_조세조약감면세액
		yetaC117.clear();										// 세액감면_조세조약
		    	
		ovrsSurcIncFmt.clear();									// 세액공제_외국납부_국외원천소득금액
		frgnPmtFcTxamt.clear();									// 세액공제_외국납부_외화납세액
		frgnPmtWcTxamt.clear();									// 세액공제_외국납부_원화납세액
		frgnPmtTxamtTxpNtnNm.setValue("");						// 세액공제_외국납부_납세국명
		frgnPmtTxamtPmtDt.reset();								// 세액공제_외국납부_납부일자
		frgnPmtTxamtAlfaSbmsDt.reset();							// 세액공제_외국납부_신청서제출일자
		frgnPmtTxamtAbrdWkarNm.setValue("");					// 세액공제_외국납부_국외근무처명
		frgnPmtTxamtRfoNm.setValue("");							// 세액공제_외국납부_직책
		    
		    /** set 외국납부세액_근무기간일자 : frgnDtyTerm */
		frgnDtyTermStdt.reset();								// 세액공제_외국납부_근무시작일자
		frgnDtyTermEddt.reset();								// 세액공제_외국납부_근무종료일자

		hsngTennLnpbUseAmt.clear();								// 세액공제_주택차입금이자상황금액
		hsngTennLnpbDdcAmt.clear();								// 세액공제_주택차입금

		mmrUseAmt.clear();										// 월세금액
		mmrDdcAmt.clear();										// 월세공제액
		
	}
	
	
	/** 추가제출서류 초기화 **/
	public void resetItemYeta10() {
		
		
		//	{추가서류제출여부}
		((Radio)d219.get(0)).setValue(false);					// 1.외국인근로자 단말세율적용신청서 제출여부
		((Radio)cd225.get(0)).setValue(false);					// 2.연금, 저축 등 소득공제 명세서 제출 여부
		((Radio)cd226.get(0)).setValue(false);					// 3.월세액.비거주자간 주택임차차입금 원리금 상환액 소득공제 증명서 제출여부

		((Radio)cd227.get(0)).setValue(false);					// 의료비지급 명세서
		((Radio)cd228.get(0)).setValue(false);					// 기부금 명세서
		((Radio)prcspWorkIncmSumtYn.get(0)).setValue(false);	//소득공제 증빙서류
		incmDducWtnnteSumtDt.reset();							// 소득공제신고서제출여부_제출일자		
		
	}
	
	/** 상세정보 초기화 **/
	public void detailInfoInit() { 
		
		dpobCd.setValue("");			/**  column 사업장코드 : dpobCd */ 
		yrtxBlggYr.setValue("");		/** column 연말정산귀속년도 : edacRvyy */
		clutSeptCd.setValue("");		/** column 정산구분코드 : settGbcd */
		systemkey.setValue("");	  		/**  column SYSTEMKEY : systemkey */
		hanNm.setValue("");				/**  column 성명 : dpobCd */
		deptNm.setValue("");			/**  column 부서명 : dpobCd */
	    
		 resetItemYeta01();
		 resetItemYeta02();
		 resetItemYeta03();
		 resetItemYeta04();
		 resetItemYeta05();
		 resetItemYeta06();
		 resetItemYeta07();
		 resetItemYeta08();
		 resetItemYeta09();
		 resetItemYeta10();
		
	}
	
	
	private void fnPopupPrgmComPBass120001(String deptNmStr) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨. 
		PrgmComBass0120DTO prgmComBass0120Dto = new PrgmComBass0120DTO();
		prgmComBass0120Dto.setUtDpobNm(deptNmStr);
		
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmComPBass120001Form(prgmComBass0120Dto) ;  //부서

		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();

		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();
	               
				if (mapModels != null) { 
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
					
					while (iterRecords.hasNext()) {
						
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						utDpobCd.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobCd")));
						utDpobNm.setValue(MSFSharedUtils.allowNulls(bmMapModel.get("utDpobNm"))); 
						
					}
				}
			}
		});
	}		
	
	
	private void funcSetPopUpRecord() {
		   
		BaseModel ppRecord = new BaseModel();
		
		ppRecord.set("dpobCd"		, dpobCd.getValue());
		ppRecord.set("clutSeptCd"	, clutSeptCd.getValue());
		ppRecord.set("systemkey"	, systemkey.getValue());
		ppRecord.set("yrtxBlggYr"	, yrtxBlggYr.getValue());
		ppRecord.set("deptNm"		, deptNm.getValue());
		ppRecord.set("hanNm"		, hanNm.getValue());
		
		setPPRecord(ppRecord);
		
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