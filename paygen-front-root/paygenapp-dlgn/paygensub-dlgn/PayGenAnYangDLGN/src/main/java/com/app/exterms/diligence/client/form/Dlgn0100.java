package com.app.exterms.diligence.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.service.InfcPkgBass0500Service;
import com.app.exterms.basis.client.service.InfcPkgBass0500ServiceAsync;
import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.exterms.diligence.client.form.defs.Dlgn0100Def;
import com.app.exterms.diligence.client.languages.DiligenceConstants;
import com.app.exterms.diligence.client.service.Dlgn0100Service;
import com.app.exterms.diligence.client.service.Dlgn0100ServiceAsync;
import com.app.exterms.dlgn.client.utils.DlgnUtils;
import com.app.exterms.personal.client.service.InfcPkgPsnl0100Service;
import com.app.exterms.personal.client.service.InfcPkgPsnl0100ServiceAsync;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0400Service;
import com.app.exterms.prgm.client.service.PrgmComBass0400ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Dlgn0100 extends MSFPanel {

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 시작} 
	 * #######################################################
	 */
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리
	private BaseModel record;
	private boolean detailWeekHday = false;
	 
	
	// ---------- 검색조건 시작 	----------
	/** column  년도 : payYr */
    private ComboBox<BaseModel> srhPayYr;					//지급년도
    private ComboBox<BaseModel> srhPayMonth;				//지급년월
    private ComboBox<BaseModel> srhPayCd;     				//급여구분
    private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분 
    private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드  
    private ComboBox<BaseModel> srhPayrMangDeptCd;			//단위기관
    private MSFMultiComboBox<ModelData> srhDeptCd ;  		//부서 
    private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	 
    private MSFMultiComboBox<ModelData> srhTypOccuCd;		//직종  
    private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
    
    private ComboBox<BaseModel> srhBusinCd;    				//사업
    private TextField<String> srhHanNm;        	 			//성명
    private TextField<String> srhResnRegnNum;   			//주민번호 
    private HiddenField<String> srhSystemkey;   			//시스템키

    private Boolean picBoolFile;
    private ActionDatabase actionDatabase;
    
          
    // -- 중간 근태생성 부분 시작
    private MSFComboBox<BaseModel> creYear;        			//작업년도
    private MSFComboBox<BaseModel> creMonth;       			//작업월
    private MSFDateField creWorkDayS;      					//근태기간 시작일
    private MSFDateField creWorkDayE;      					//근태기간 종료일
    private MSFComboBox<BaseModel> creEmymtDivCd;				//고용구분
    private MSFComboBox<BaseModel> creRepbtyBusinDivCd; 		//호봉제구분코드  
    private MSFComboBox<BaseModel> creBusinCd;					//사업명
    private MSFComboBox<BaseModel> crePayCd;					//급여구분
    private MSFComboBox<BaseModel> crePayrMangDeptCd;			//단위기관
    private MSFComboBox<BaseModel>  creMangeDeptCd; 				//관리부서 수정
    private MSFMultiComboBox<ModelData> creDeptCd ;    		//부서 
    private ComboBox<BaseModel> creDeptGpCd; 				//부서직종그룹코드
    private MSFMultiComboBox<ModelData> creTypOccuCd; 		//직종  
    private MSFMultiComboBox<ModelData> creDtilOccuInttnCd; //직종세
    
    private HiddenField<String> creHanNm;        	 		//성명
    private HiddenField<String> creResnRegnNum;   			//주민번호 
    /** secResnNum : 주민등록번호 원본*/
    private HiddenField<String> creSecResnNum;
    private HiddenField<String> creSystemkey;   			//시스템키
    // -- 중간 근태생성 부분 종료
	// ---------- 검색조건 종료 	----------
	
    //파일업로드처리 부분  
    private FileUploadField dlgn0100flUp;
	
    FieldSet fieldRightForm = new FieldSet();
    FieldSet fieldRightGrid = new FieldSet();
	// ------  멀티콤보 선언 시작 ------
	private List<ModelData> mDtalistDeptCd ;
    private List<ModelData> mDtalistTypOccuCd ;
    private List<ModelData> mDtalistDtilOccuInttnCd ;
    
    private boolean mutilCombo = false;
    
    private List<ModelData> mDtalistcrDeptCd ;
    private List<ModelData> mDtalistcrTypOccuCd ;
    private List<ModelData> mDtalistcrDtilOccuInttnCd ;
    private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

	private Boolean emptyCheck = false ;
    private boolean mutilcrCombo = false;
 	// ------  멀티콤보 선언 종료 ------
    
    // ------  DTO 선언 시작 ------
    private PrgmComBass0300DTO sysComBass0300Dto;	//공통코드 dto
    private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
    private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
    private PrgmComBass0150DTO sysComBass0150Dto; 	//단위기관 
    private SysCoCalendarDTO  msfCoCalendarDto;  
    private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
    private PrgmComBass0320DTO sysComBass0320Dto;	//직종
    // ------  DTO 선언 종료 ------
    
    // ------  엑셀 grid 선언 시작 -----
    private MSFGridPanel dlgn0100GridPanel; 
    // ------  엑셀 grid 선언 종료 -----

    // --------- gird,Def 선언 시작 ----------
 	private MSFGridPanel Dlgn0100Grid0110;	//근태관리대상자정보(기준일 후)
 	private MSFGridPanel Dlgn0100Grid0110_1;	//근태관리대상자정보(기준일 전)
 	private Dlgn0100Def Dlgn0100Def = new Dlgn0100Def("DLGN0100"); // 근무내역등록 GRID(기준일 후)
 	private Dlgn0100Def Dlgn0100_1Def = new Dlgn0100Def("DLGN0100_1"); // 근무내역등록 GRID(기준일 전)
 	// --------- grid,Def 선언 종료 ----------
 	
 	Button btnDlgn0100Upload = new Button();
 	Button btnDlgn0100DownLoad = new Button();
 	Button topBtnSave = new Button(); //저장
 	Button topBtnDel = new Button(); //삭제
 	Button topBtnSrc = new Button(); //조회
	ContentPanel cpGrid = new ContentPanel();
	ContentPanel cpGrid_1 = new ContentPanel();
	LabelField lblfldNewLabelfield_16 = new LabelField();
	LabelField lblfldNewLabelfield_17 = new LabelField();
    
 	// ------------- 기준일 전역변수 선언 시작------------
	private DiligenceConstants lblDlgnConst = DiligenceConstants.INSTANCE;
	private String detailYmKubn = lblDlgnConst.dt_Bungi_Dlgn();
// 	private String detailYmKubn = "201703"; //복무관리 기준일 property에서 받을 부분.
 	// --------------기준일 전역변수 선언 종료-------------
 	
    // ------  stroe 선언 시작 ------
    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();			//년도 
    private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  			//급여월   
    private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>();			//고용구분 
    private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
    private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();			//부서콤보
    private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();			//사업콤보   
    private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>();		//단위기관 
    private ListStore<BaseModel> lsDeptGpCd = new ListStore<BaseModel>();			//부서직종그룹코드
    private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();			//직종 
    private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세
    private ListStore<BaseModel> lsPayCd = new ListStore<BaseModel>(); 				//급여구분
    private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
    
    // ----------------------------------------------------------------------------------
    private ListStore<BaseModel> lscrPayYr = new ListStore<BaseModel>(); 			//년도
    private ListStore<BaseModel> lscrPayMonth = new ListStore<BaseModel>();  		//급여월   
    private ListStore<BaseModel> lscrEmymtDivCd = new ListStore<BaseModel>();		//고용구분 
    private ListStore<BaseModel> lscreRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
    private ListStore<BaseModel> lscrDeptCd  = new ListStore<BaseModel>();			//부서콤보
    private ListStore<BaseModel> lscrBusinCd  = new ListStore<BaseModel>();			//사업콤보   
    private ListStore<BaseModel> lscrPayrMangDeptCd = new ListStore<BaseModel>();	//단위기관 
    private ListStore<BaseModel> lscreDeptGpCd = new ListStore<BaseModel>();		//부서직종그룹코드
    private ListStore<BaseModel> lscrTypOccuCd = new ListStore<BaseModel>();		//직종 
    private ListStore<BaseModel> lscrDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세
    private ListStore<BaseModel> lscrPayCd = new ListStore<BaseModel>(); 			//급여구분
    private ListStore<BaseModel> lscreMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
    
	private ListStore<BaseModel> listStoreB015 = new ListStore<BaseModel>(); 		//급여구분
	private ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>(); 		//직종
	private ListStore<BaseModel> listStoreA002 = new ListStore<BaseModel>(); 		//고용구분
	private ListStore<BaseModel> listStoreBass0400 = new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreBass0400All = new ListStore<BaseModel>(); // 소속부서 전체 데이타 
	private ListStore<BaseModel> listStoreSrhYr = new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreYr = new ListStore<BaseModel>();
	
	
	private ListStore<BaseModel> listStoreN001 = new ListStore<BaseModel>();		//복무기타구분코드 
	private ListStore<BaseModel> tempListStore = new ListStore<BaseModel>();		//복무기타구분코드 
    // ------  stroe 선언 종료 ------
	
	//중간 근태생성 부분 끝
	
	//근태상세정보 시작
	private MSFTextField detailYm;					//작업년월
	private MSFTextField detailWorkDayS;			//근태 시작기간
	private MSFTextField detailWorkDayE;			//근태 종료기간
	private MSFTextField detailName;				//성명
	private MSFTextField detailRegnNum;				//주민번호
	private MSFTextField detailDeptNm;				//부서명
	private MSFTextField detailBusinNm;				//사업명	
	private MSFTextField detailEmymtBgnnDt;			//계약일자
	private MSFTextField detailEmymtEndDt;			//종료일자
	private MSFTextField detailWeekHdayCnt;			//휴가
	private String detailWeekHdayCntStr;			//기존주휴휴가
	private MSFTextField detailTypOccuNm;			//직종명
	private MSFTextField detailDtilOccuInttnNm;		//직종세명
	private HiddenField<String> detailEmymtDivCd;	//고용구분
	
	
	private HiddenField<String> dpobCdStr;				//사업장코드
	private HiddenField<String> payCdStr;				//급여구분코드
	private HiddenField<String> systemkeyStr;			//시스템키	
	private HiddenField<String> deptCdStr;				//부서코드
	private HiddenField<String> businCdStr;				//사업명	
	private HiddenField<String> typOccudStr;			//직종명
	private HiddenField<String> dtilOccuInttnCdStr;		//직종세명
	private HiddenField<String> emymtDivCdStr;			//고용구분
	
	//근태상세정보 끝
	
	private CheckColumnConfig checkColumn ; 
	
	//그리드 관련
	private ComboBox<BaseModel> dilnlazEtcDivCdCombo = new ComboBox<BaseModel>();	//기타   
	private ColumnConfig dilnlazEtcDivCdColumn = new ColumnConfig();
	
	// ------  service 호출 시작 ------
	private InfcPkgPsnl0100ServiceAsync psnl0100Service = InfcPkgPsnl0100Service.Util.getInstance();
	private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	private Dlgn0100ServiceAsync dlgn0110Service = Dlgn0100Service.Util.getInstance();
	//private PrgmComBass0150ServiceAsync sysComBass0150Service = PrgmComBass0150Service.Util.getInstance();
	// ------  service 호출 종료 ------

	
	private Dlgn0100ServiceAsync dlgn0100Service = Dlgn0100Service.Util.getInstance();
	private RpcProxy<BaseListLoadResult<Dlgn0100DTO>> dlgn0100Proxy = new RpcProxy<BaseListLoadResult<Dlgn0100DTO>>(){
		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Dlgn0100DTO>> callback) {
			Dlgn0100DTO dto = new Dlgn0100DTO();
			
			String searchYearS = srhPayYr.getValue() == null ? "" : DlgnUtils.getSelectedComboValue(srhPayYr,"year");
			String searchMonthS = srhPayMonth.getValue() == null ? "" : DlgnUtils.getSelectedComboValue(srhPayMonth,"month");
			if(searchMonthS.length() == 1) searchMonthS = "0"+searchMonthS;
			
//				dto.setDilnlazYrMnth(searchYearS+searchMonthS);
//				dto.setCurrAffnDeptCd(DlgnUtils.getSelectedComboValue(searchCurrDeptCd,"deptCd"));
//				dto.setDeptCd(DlgnUtils.getSelectedComboValue(searchDeptCd,"mangeDeptCd"));
//				dto.setBusinCd(DlgnUtils.getSelectedComboValue(searchBusinCd, "businCd"));
//				dto.setEmymtDivCd(DlgnUtils.getSelectedComboValue(searchEmymtDivCd, "commCd"));
//				dto.setHanNm(searchName.getValue());
//				dto.setResnRegnNum(searchResnRegnNum.getValue());
				
				dto.setDilnlazYrMnth(searchYearS+searchMonthS);
				dto.setPayCd(DlgnUtils.getSelectedComboValue(srhPayCd,"commCd"));
 				dto.setMangeDeptCd(DlgnUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
				dto.setDeptCd(DlgnUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				dto.setHanNm(srhHanNm.getValue());
				dto.setResnRegnNum(srhResnRegnNum.getValue());
				dto.setEmymtDivCd(DlgnUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
				dto.setCurrAffnDeptCd(DlgnUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));	//부서
//				dto.setDeptCd(DlgnUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));	//부서
				dto.setTypOccuCd(DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
				dto.setDtilOccuInttnCd(DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
				dto.setBusinCd(DlgnUtils.getSelectedComboValue(srhBusinCd, "businCd"));
				
				dto.setPayrMangDeptCd(dto.getDeptCd());
				dlgn0100Service.searchWorkDayMemberInfo((BaseListLoadConfig) loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderDlgn0100 = new BaseListLoader<BaseListLoadResult<ModelData>>(dlgn0100Proxy);
	private ListStore<Dlgn0100DTO> storeDlgn0100 = new ListStore<Dlgn0100DTO>(loaderDlgn0100);

	private Grid<Dlgn0100DTO> dlgn0100Grid;		// 근태관리대상자정보
	
	private RpcProxy<BaseListLoadResult<Dlgn0100DTO>> dlgn0110Proxy = new RpcProxy<BaseListLoadResult<Dlgn0100DTO>>(){

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Dlgn0100DTO>> callback) {
			Dlgn0100DTO dto = new Dlgn0100DTO();
			dto.setDpobCd( ((BaseListLoadConfig) loadConfig).get("getDpobCd")+"");
			dto.setSystemkey(((BaseListLoadConfig) loadConfig).get("getSystemkey")+"");
			dto.setDilnlazYrMnth(((BaseListLoadConfig) loadConfig).get("getDilnlazYrMnth")+"");
			dto.setPayCd(((BaseListLoadConfig) loadConfig).get("getPayCd")+"");
			
			dto.setDilnlazWklyHldyNumDys(((BaseListLoadConfig) loadConfig).get("getDilnlazWklyHldyNumDys")+"");

			dlgn0100Service.getMemberWorkTimeInfo((BaseListLoadConfig) loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderDlgn0110 = new BaseListLoader<BaseListLoadResult<ModelData>>(dlgn0110Proxy);
	private ListStore<Dlgn0100DTO> storeDlgn0110 = new ListStore<Dlgn0100DTO>(loaderDlgn0110);

	private EditorGrid<Dlgn0100DTO> dlgn0110Grid;	// 근태상세정보
	
	private InfcPkgBass0500ServiceAsync bass0500Service = InfcPkgBass0500Service.Util.getInstance();
	
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	// 검색 폼 바인딩 처리 함수 
	// private AuthAction authAction;  
	//  private Boolean boolChkAuth;  
	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	
	  /**
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	  private void checkDlgn0100Auth(String authAction, ListStore<BaseModel> bm) {   
  	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
	           //----------------------------------------------------
			   if (!maskTracker) { unmask(); }  
	           
             Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd
              		                  ,crePayrMangDeptCd,creEmymtDivCd,creDeptCd,creTypOccuCd,creDtilOccuInttnCd,creBusinCd};
              
			   gwtAuthorization.formAuthFieldConfig(fldArrField);      			   
			   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
			  
			   srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()))); 
	           srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	           creYear.setValue(lscrPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()))); 
	           creMonth.setValue(lscrPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
           
            // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
            // creEmymtDivCd.setValue(lscrEmymtDivCd.getAt(0)); 
             
	           srhPayCd.setValue(lsPayCd.getAt(0));  
	           crePayCd.setValue(lscrPayCd.getAt(0));
             
             
              if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
                   setInitDate();
              }
    
	              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                // String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
	                // GWTAuthorization.formAuthPopConfig(plFrmDlgn0100, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
	                // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			    //  gwtAuthorization.formAuthConfig(plFrmDlgn0100, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
	               /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	             //    srhDeptCd.fireEvent(Events.Add);
	                srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
	                
	                  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                     // String[] strArrDeptCd = { "creCurrDeptCd","creCurrDeptNm"};
	                     // GWTAuthorization.formAuthPopConfig(plFrmDlgn0100, "crePayrMangDeptCd","creEmymtDivCd",strArrDeptCd,"creTypOccuCd","creBusinCd");
	                     // GWTAuthorization.formAuthBtnConfig(btnCreCurrDeptCd); 
	             //  gwtAuthorization.formAuthConfig(plFrmDlgn0100,  "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creDtilOccuInttnCd","creBusinCd" );
	                    
	                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 creDeptCd.getListView().fireEvent(Events.CheckChanged); 
	                    
	                   
              //MSFMainApp.unmaskMainPage();
               
		   }
	  }	
//		private void checkDlgn0100Auth( String authAction, ListStore<BaseModel> bm) {   
//			//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
//			if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//				//----------------------------------------------------
//				if (!maskTracker) { unmask(); }  
//					Field<?>[] fldArrField = {searchEmymtDivCd,searchCurrDeptCd,searchBusinCd,midEmymtDivCd,midCurrDeptCd,midTypOccuCd,midBusinCd};
//						    
//					gwtAuthorization.formAuthFieldConfig(fldArrField); 
//					gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
//						
//			           
//					//MSFMainApp.unmaskMainPage();
//					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//						 //  gwtAuthorization.formAuthConfig(plFrmDlgn0100, "","searchEmymtDivCd","searchCurrDeptCd","","searchBusinCd");						   
//					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//	 					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//					          
//					         
//					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//						//  gwtAuthorization.formAuthConfig(plFrmDlgn0100, "","midEmymtDivCd","midCurrDeptCd","midTypOccuCd","midBusinCd");
//					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//				}
//		}
				  
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) // { 
				cancel();
				unmask(); 
				maskTracker  = true;
				// }
			}
		}; 
		
		private void initLoad() { 
			// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
			gwtAuthorization = GWTAuthorization.getInstance();
		    gwtExtAuth = GWTExtAuth.getInstance();
		     
		    HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
		     
		    authMapDef.put("srhPayYr",Boolean.FALSE);  
		    authMapDef.put("srhPayMonth",Boolean.FALSE);  
		
		    authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
		    authMapDef.put("srhPayCd",Boolean.FALSE);  
		    authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
		    authMapDef.put("srhDeptCd",Boolean.FALSE); 
		   //  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
		      
		     
		    authMapDef.put("creYear",Boolean.FALSE);  
		    authMapDef.put("creMonth",Boolean.FALSE);  
		    authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
		    authMapDef.put("crePayCd",Boolean.FALSE);  
		    authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
		    authMapDef.put("creDeptCd",Boolean.FALSE); 
		   //  authMapDef.put("creTypOccuCd",Boolean.FALSE);  
		    
		    gwtExtAuth.setCheckMapDef(authMapDef);
	        
	        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
	        	  //권한 검색조건처리를 위해 추가된 부분 
				  mask("[화면로딩] 초기화 진행 중!");
	        }
	        tmMask.scheduleRepeating(5000);			
			
			
//			// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//			gwtAuthorization = GWTAuthorization.getInstance();
//			gwtExtAuth = GWTExtAuth.getInstance();
//					     
//			HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
//					     
//			authMapDef.put("searchCurrDeptCd",Boolean.FALSE);
//			authMapDef.put("searchEmymtDivCd",Boolean.FALSE);
//			authMapDef.put("midEmymtDivCd",Boolean.FALSE);
//			authMapDef.put("midCurrDeptCd",Boolean.FALSE); 
//			//  authMapDef.put("midTypOccuCd",Boolean.FALSE); 
//						 
//			gwtExtAuth.setCheckMapDef(authMapDef);
//				        
//			if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//				//권한 검색조건처리를 위해 추가된 부분 
//				mask("[화면로딩] 초기화 진행 중!");
//			}
//			tmMask.scheduleRepeating(5000);
		}
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/	
	  
	
	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################
	 */

	private VerticalPanel vp;
	private FormPanel plFrmDlgn0100;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	private LayoutContainer layoutContainer_14;

	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// detailTp = XTemplate.create(getDetailTemplate());
	//
	// // formData = new FormData("-650");
	// vp = new VerticalPanel();
	// vp.setSpacing(10);
	// createDlgn0100Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createStandardForm(); //기본정보필드
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }

	public ContentPanel getViewPanel() {
		if (panel == null) {
			
			 //콤보 권한초기화
			   initLoad(); 
			
			   sysComBass0300Dto = new PrgmComBass0300DTO();    
			   
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add("A002");
			arrRpsttvCd.add("A041");
			arrRpsttvCd.add("A048");
			arrRpsttvCd.add("B015");
			
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
				
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					if(result != null && result.size() > 0){
						listStoreA002.add(result.get("A002"));
						listStoreA041.add(result.get("A041"));
						listStoreB015.add(result.get("B015"));
						lsRepbtyBusinDivCd.add(result.get("A048"));
					}
				}
				
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "공통코드 에러!", null);
				}
			});
			
			sysComBass0400Dto = new PrgmComBass0400DTO();
			listStoreBass0400 = PrgmComComboUtils.getMangDeptBass0400ComboData(sysComBass0400Dto);
		
			sysComBass0400Dto = new PrgmComBass0400DTO();
			sysComBass0400Service.getPrgmComDeptBass0400List(sysComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					listStoreBass0400All.add(result);
				}
				@Override
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}
			});
			
			
			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "780px");
			createDlgn0100Form();	// 화면 기본정보를 설정
			createSearchForm();   	// 검색필드를 적용
			createDataForm();		// 근태 생성 부
			createStandardForm(); 	// 기본정보필드

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
	public Dlgn0100() {

		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "780px");
	}

	public Dlgn0100(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createDlgn0100Form() {
		
		dpobCdStr = new HiddenField<String>();				//사업장코드
		payCdStr = new HiddenField<String>();				//급여구분코드
		systemkeyStr = new HiddenField<String>();			//시스템키	
		deptCdStr = new HiddenField<String>();				//부서코드
		businCdStr = new HiddenField<String>();				//사업명	
		typOccudStr = new HiddenField<String>();			//직종명
		dtilOccuInttnCdStr = new HiddenField<String>();		//직종세명
		emymtDivCdStr = new HiddenField<String>();			//고용구분
		

		plFrmDlgn0100 = new FormPanel();
		plFrmDlgn0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 기본근무관리"));
		plFrmDlgn0100.setPadding(2);
		plFrmDlgn0100.setIcon(Resources.APP_ICONS.text());
		plFrmDlgn0100.setBodyStyleName("pad-text");
		plFrmDlgn0100.setFrame(true);
		
		//엣지변환
		//plFrmDlgn0100.setSize("990px", "725px");  
		plFrmDlgn0100.setSize("990px", "805px");
		
		
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("근태기본관리","DLGN0100");
				}
			});
		plFrmDlgn0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmDlgn0100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		
		lscreRepbtyBusinDivCd = lsRepbtyBusinDivCd;

		
		   //멀티콤보박스 닫기 
		plFrmDlgn0100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
		            @Override
		            public void handleEvent(ComponentEvent ce) { 
		            
		             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
		                    
		            //        if (f instanceof MSFMultiComboBox<?>) {
		                        
//		                      if ("srhDeptCd".equals(f.getName())) {
//		                          
//		                      } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//		                          
//		                      }
		                        
		              //      } else {
		                   if (mutilCombo) {
		                        if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
		                            //부서
		                            srhDeptCd.showClose(ce);
		                            mutilCombo = false;
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
		                   
		                   if (mutilcrCombo) {
		                       if ( creDeptCd.getCheckBoxListHolder().isVisible() ) {
		                           //부서
		                           creDeptCd.showClose(ce);
		                           mutilcrCombo = false;
		                       } else if (creTypOccuCd.getCheckBoxListHolder().isVisible() ) {
		                           //직종
		                           creTypOccuCd.showClose(ce);
		                           mutilcrCombo = false;
		                         //  creTypOccuCd.getListView().fireEvent(Events.CheckChanged);
		                       } else if ( creDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
		                           //직종세
		                           creDtilOccuInttnCd.showClose(ce);
		                           mutilcrCombo = false;
		                       }  
		                  }
		                //    }
		            //    } 
		            } 
		        }); 
				
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		// buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));
		// buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));
		/*
		Button topBtn = new Button("신규");
		topBtn.setIcon(MSFMainApp.ICONS.text());
		buttonBar.add(topBtn);
		*/
		
		/*
		 * ##########################################
		 * 저장시 통계 집계 함수 넣어야함.............###########
		 * ##########################################
		 */
		
		topBtnSave = new Button("저장");
		topBtnSave.setIcon(MSFMainApp.ICONS.save16());
		topBtnSave.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				actionDatabase = ActionDatabase.UPDATE;
				doAction(actionDatabase);
			}
		});
		buttonBar.add(topBtnSave);

		topBtnDel = new Button("삭제");
		topBtnDel.setIcon(MSFMainApp.ICONS.delete16());
		topBtnDel.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				MessageBox.confirm("복무관리대상자 삭제", "선택하신 복무관리 대상자를 삭제 하시겠습니까?[삭제시 시간외근무내역도 삭제됩니다.]",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							if(dlgn0100Grid.getSelectionModel().getSelectedItems().size() > 0){
								dlgn0100Service.deleteWorkTime(dlgn0100Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
									@Override
									public void onSuccess(Integer result) {
										
										MessageBox.info("", "삭제 되었습니다.", null);
										
										loaderDlgn0100.load();
										
										dlgn0110Grid.getStore().removeAll();
										dlgn0110Grid.getStore().commitChanges();
										
										detailYm.setValue("");				//작업년월
										detailWorkDayS.setValue("");		//근태 시작기간
										detailWorkDayE.setValue("");		//근태 종료기간
										detailName.setValue("");			//성명
										detailRegnNum.setValue("");			//주민번호
										detailDeptNm.setValue("");			//부서명
										detailTypOccuNm.setValue("");		//직종명
										detailDtilOccuInttnNm.setValue("");	//직종세명
										detailBusinNm.setValue("");			//사업명
										detailEmymtDivCd.setValue("");		//고용구분(hidden)
										detailEmymtBgnnDt.setValue("");		//계약일자
										detailEmymtEndDt.setValue("");		//종료일자
										detailWeekHdayCnt.setValue("");		//주휴일수
									}
									@Override
									public void onFailure(Throwable caught) {
										caught.printStackTrace();
										MessageBox.info("", "삭제 오류", null);
									}
								});
							}else{
								MessageBox.info("", "삭제하실 대상자를 선택하여주세요.", null);
							}
						}
					}
				});
			}
		});
		buttonBar.add(topBtnDel);

		topBtnSrc = new Button("조회");
		topBtnSrc.setIcon(MSFMainApp.ICONS.search16());
		topBtnSrc.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if(srhPayYr.getValue() != null && srhPayMonth.getValue() != null){
					
					detailClear();
					
					String year = DlgnUtils.getSelectedComboValue(srhPayYr,"year");
					String month = DlgnUtils.getSelectedComboValue(srhPayMonth,"month");
					String yearMonth = year + month;
		
					if((detailYmKubn.compareTo(yearMonth) >= 0 )){
						dlgn0100flUp.hide();
						btnDlgn0100Upload.hide();
						btnDlgn0100DownLoad.hide();
						lblfldNewLabelfield_16.hide();
						lblfldNewLabelfield_17.hide();
//						topBtnSave.show();
						
					}else{
						dlgn0100flUp.show();
						btnDlgn0100Upload.show();
						btnDlgn0100DownLoad.show();
						lblfldNewLabelfield_16.show();
						lblfldNewLabelfield_17.show();
//						topBtnSave.show();
						
					}
					
					loaderDlgn0100.load();
					
					dlgn0100Grid.getStore().removeAll();
					dlgn0100Grid.getStore().commitChanges();
					dlgn0110Grid.getStore().removeAll();
					dlgn0110Grid.getStore().commitChanges();
					
					detailYm.setValue("");				//작업년월
					detailWorkDayS.setValue("");		//근태 시작기간
					detailWorkDayE.setValue("");		//근태 종료기간
					detailName.setValue("");			//성명
					detailRegnNum.setValue("");			//주민번호
					detailDeptNm.setValue("");			//부서명
					detailTypOccuNm.setValue("");		//직종명
					detailDtilOccuInttnNm.setValue("");	//직종세명
					detailBusinNm.setValue("");			//사업명
					detailEmymtDivCd.setValue("");		//고용구분(hidden)
					detailEmymtBgnnDt.setValue("");		//계약일자
					detailEmymtEndDt.setValue("");		//종료일자
					detailWeekHdayCnt.setValue("");		//주휴일수
					
					// ---------------------------  생성부  ---------------------------
					creYear.setValue(srhPayYr.getValue());						//작업년 
			        creMonth.setValue(srhPayMonth.getValue());					//작업월
			        creEmymtDivCd.setValue(srhEmymtDivCd.getValue());			//고용구분
			        creBusinCd.setValue(srhPayCd.getValue());					//사업
			        crePayCd.setValue(srhPayCd.getValue());						//급여구분
			        crePayrMangDeptCd.setValue(srhPayrMangDeptCd.getValue());	//단위기관
			        creMangeDeptCd.setValue(srhMangeDeptCd.getValue());	//단위기관
			        creDeptCd.setValue(srhDeptCd.getValue());					//부서
			        creTypOccuCd.setValue(srhTypOccuCd.getValue());				//직종
			        creDtilOccuInttnCd.setValue(srhDtilOccuInttnCd.getValue());	//직종세
			        // ---------------------------  생성부  ---------------------------
			        
				}else{
					MessageBox.info("", "작업년월은 필수 입니다.", null);
				}
			}
		});
		buttonBar.add(topBtnSrc);

		//TODO 출근부 추가 후 사용
//		topBtn = new Button("인쇄");
//		topBtn.setIcon(Resources.APP_ICONS.text());
//		buttonBar.add(topBtn);

		plFrmDlgn0100.add(buttonBar);

		vp.add(plFrmDlgn0100);
	}
	
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
//			savePayr4200();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			saveDlgn0110();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
//			savePayr4200();
			break;
		}
	}
	
	
	private void saveDlgn0110() { 
		
		// ============== 기준일 전
		if((detailYmKubn.compareTo(detailYm.getValue().replaceAll("\\.", "")) >= 0 )){	
		
			//기준일 전
//			if (!(Dlgn0100Grid0110_1.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)){
			if ( (Dlgn0100Grid0110_1.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)
					&& (Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)
					&& MSFSharedUtils.allowNulls(detailWeekHdayCntStr).equals(MSFSharedUtils.allowNulls(detailWeekHdayCnt.getValue()))  ){ 
		            	MessageBox.alert("근태정보", "저장할 근태정보가 존재하지 않습니다.", null);
		            	return;
			}else{
				
				MessageBox.confirm("저장", "데이터를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							String year = DlgnUtils.getSelectedComboValue(creYear,"year");
							String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
							String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
							String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
							String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
							String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
							String yearMonth = year + month;
						
							//주휴일수 계산
							Calendar  startCal =   Calendar.getInstance();
							startCal.set ( Integer.parseInt(workDayS.substring(0,4)), Integer.parseInt(workDayS.substring(4,6)), Integer.parseInt(workDayS.substring(6,8)) );
							int startWeek = startCal.get(Calendar.WEEK_OF_YEAR);
						
							Calendar  endCal =   Calendar.getInstance();
							endCal.set ( Integer.parseInt(workDayE.substring(0,4)), Integer.parseInt(workDayE.substring(4,6)), Integer.parseInt(workDayE.substring(6,8)) );
							int endWeek = endCal.get(Calendar.WEEK_OF_YEAR);
							
							int weekDifference = endWeek - startWeek;
							//주휴일수 계산 끝
							
							Iterator<Record> iterRecords = Dlgn0100Grid0110_1.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
							List<Dlgn0110DTO> listDlgn0110_1dto = new ArrayList<Dlgn0110DTO>();
			 			
			 			
							Dlgn0110DTO dlgn0110dto = null;
							while (iterRecords.hasNext()) {
								dlgn0110dto = new Dlgn0110DTO();
								Record recData = (Record) iterRecords.next(); 
								BaseModel bmMapModel = (BaseModel)recData.getModel();
			 			
								dlgn0110dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
								dlgn0110dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
		//	 			dlgn0110dto.setPayCd(DlgnUtils.getSelectedComboValue(crePayCd,"commCd"));			/** column 급여구분 : payCd */
								dlgn0110dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));			/** column 급여구분 : payCd */
//			 			dlgn0110dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("detailEmymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
								dlgn0110dto.setEmymtDivCd(detailEmymtDivCd.getValue());    /** column 고용구분코드 : emymtDivCd */
								dlgn0110dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
								dlgn0110dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
								dlgn0110dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
			 					dlgn0110dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세구분코드 : dtilOccuInttnCd */
		
			 					dlgn0110dto.setDilnlazYrMnth(detailYm.getValue().replaceAll("\\.",""));									/** column 근무년월 : detailYm */
			 					dlgn0110dto.setDilnlazApptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazApptnDt")));				/** column 근태일자 : dilnlazApptnDt */
			 					dlgn0110dto.setDilnlazDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyTm")));				/** column 근무시간 : dilnlazDutyTm */
			 					dlgn0110dto.setDilnlazDutyYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyYn")));				/** column 근무여부 : dilnlazDutyYn */
			 					dlgn0110dto.setDilnlazAbnceYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazAbnceYn")));				/** column 결근여부 : dilnlazAbnceYn */
			 					dlgn0110dto.setDilnlazLvsgYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazLvsgYn")));				/** column 연차여부 : dilnlazLvsgYn */
			 					dlgn0110dto.setDilnlazSpclHodyYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSpclHodyYn")));		/** column 특(휴)여부 : dilnlazSpclHodyYn */
			 					dlgn0110dto.setDilnlazSckleaYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSckleaYn")));			/** column 병가여부 : dilnlazSckleaYn */
			 					dlgn0110dto.setDilnlazOffvaYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazOffvaYn")));				/** column 공가여부 : dilnlazOffvaYn */
			 					dlgn0110dto.setDilnlazFmlyEvntYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazFmlyEvntYn")));		/** column 경조사여부 : dilnlazFmlyEvntYn */
			 					dlgn0110dto.setDilnlazHlthCreYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHlthCreYn")));			/** column 보건여부 : dilnlazHlthCreYn */
			 					dlgn0110dto.setDilnlazEtcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazEtcDivCd$commCd")));	/** column 복무기본코드 : dilnlazEtcDivCd */
			 					dlgn0110dto.setDilnlazTfcAssCstYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTfcAssCstYn")));		/** column 교통비여부 : dilnlazTfcAssCstYn */
			 					dlgn0110dto.setDilnlazLnchYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazLnchYn")));				/** column 급식비여부 : dilnlazLnchYn */
			 					dlgn0110dto.setDilnlazButpYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazButpYn")));    			/** column 근태_출장여부 : dilnlazButpYn */
			 					dlgn0110dto.setDilnlazSppySnkfYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSppySnkfYn")));   	/** column 근태_간식비여부 : dilnlazSppySnkfYn */
			 					dlgn0110dto.setDilnlazNgtdyYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazNgtdyYn")));    			/** column 근태_숙직여부 : dilnlazNgtdyYn */
			 					
			 					
			 					
			 					dlgn0110dto.setDilnlazWklyHldyNumDys(weekDifference+""); 	//주휴일수
			 			
			 					listDlgn0110_1dto.add(dlgn0110dto);
		 			
							}
							//service 구현
							dlgn0110Service.updateDlgn0110GridPre(listDlgn0110_1dto, new AsyncCallback<Long>(){
								@Override 
								public void onFailure(Throwable caught) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                        	MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnDlgn0210(업데이트오류) : " + caught)
		                        	, null);
								}
								@Override
								public void onSuccess(Long result) {
									if (result > 0L) {
										MessageBox.info("저장완료", "수정한 근무내역이 저장되었습니다.", null);
										Dlgn0100Grid0110_1.reload();      	
									} else {
		 					
									}
		 				 
								}    		
							});
		              	}
		 			 }
		 		 }); 
		      }
//		   }
		
		// ==============  기준일 후
		}else{																		    

			  // 기준일 후
//			if (!(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)){
				
			if ( (Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)
					&& (Dlgn0100Grid0110_1.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)
					&& MSFSharedUtils.allowNulls(detailWeekHdayCntStr).equals(MSFSharedUtils.allowNulls(detailWeekHdayCnt.getValue()))){  //기준일 후
						MessageBox.alert("근태정보", "저장할 근태정보가 존재하지 않습니다.", null);
						return;
			}else{
			    	  
				MessageBox.confirm("저장", "데이터를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
		 				 
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		            	
							String year = DlgnUtils.getSelectedComboValue(creYear,"year");
							String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
							String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
							String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
							String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
							String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
							String yearMonth = year + month;
						
							//주휴일수 계산
							Calendar  startCal =   Calendar.getInstance();
							startCal.set ( Integer.parseInt(workDayS.substring(0,4)), Integer.parseInt(workDayS.substring(4,6)), Integer.parseInt(workDayS.substring(6,8)) );
							int startWeek = startCal.get(Calendar.WEEK_OF_YEAR);
						
							Calendar  endCal =   Calendar.getInstance();
							endCal.set ( Integer.parseInt(workDayE.substring(0,4)), Integer.parseInt(workDayE.substring(4,6)), Integer.parseInt(workDayE.substring(6,8)) );
							int endWeek = endCal.get(Calendar.WEEK_OF_YEAR);
							
							int weekDifference = endWeek - startWeek;
							//주휴일수 계산 끝

							
							Dlgn0110DTO dlgn0110dto = new Dlgn0110DTO();
							
							// 그리드 수정 없이 주휴수정만 수정할 경우 해당 서비스 태움.(주휴일수만 수정)
							if(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getModifiedRecords().size() < 1 ) {
								
								dlgn0110dto = new Dlgn0110DTO();
			 			
								dlgn0110dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCdStr.getValue()));						/** column 사업장코드 : dpobCd */
								dlgn0110dto.setSystemkey(MSFSharedUtils.allowNulls(systemkeyStr.getValue()));				/** column SYSTEMKEY : systemkey */
								dlgn0110dto.setPayCd(MSFSharedUtils.allowNulls(payCdStr.getValue()));						/** column 급여구분 : payCd */
								dlgn0110dto.setEmymtDivCd(detailEmymtDivCd.getValue());    									/** column 고용구분코드 : emymtDivCd */
								dlgn0110dto.setDeptCd(MSFSharedUtils.allowNulls(deptCdStr.getValue()));    					/** column 부서코드 : deptCd */
								dlgn0110dto.setBusinCd(MSFSharedUtils.allowNulls(businCdStr.getValue()));    				/** column 사업코드 : businCd */
								dlgn0110dto.setTypOccuCd(MSFSharedUtils.allowNulls(typOccudStr.getValue()));    			/** column 직종코드 : typOccuCd */
								dlgn0110dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dtilOccuInttnCdStr.getValue()));	/** column 직종세구분코드 : dtilOccuInttnCd */
		
								dlgn0110dto.setDilnlazYrMnth(detailYm.getValue().replaceAll("\\.",""));									/** column 근무년월 : detailYm */
								dlgn0110dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(detailWeekHdayCnt.getValue())); 			/** 주휴일수 */
								
								dlgn0110Service.updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(dlgn0110dto, new AsyncCallback<Long>(){
									@Override 
									public void onFailure(Throwable caught) {
										MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
												MSFMainApp.ADMINMESSAGES.ExceptionMessageService("updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(주휴일수수정) : " + caught)
												, null);
									}
									@Override
									public void onSuccess(Long result) {
			 				
										if (result > 0L) {
											MessageBox.info("저장완료", "수정한 근무내역이 저장되었습니다.", null);
											Dlgn0100Grid0110.reload();      	
										} else {
											
										}
									}    		
								});
							
							// 그리드 수정 시 해당 로직 태움.(그리드 + 주휴일수 수정 반영)
							} else {
								
								Iterator<Record> iterRecords = Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
								List<Dlgn0110DTO> listDlgn0110_1dto = new ArrayList<Dlgn0110DTO>();
				 			
				 			
//								Dlgn0110DTO dlgn0110dto = null;
								dlgn0110dto = new Dlgn0110DTO();
								while (iterRecords.hasNext()) {
									
									dlgn0110dto = new Dlgn0110DTO();
									Record recData = (Record) iterRecords.next(); 
									BaseModel bmMapModel = (BaseModel)recData.getModel();
				 			
									dlgn0110dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));						/** column 사업장코드 : dpobCd */
									dlgn0110dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));				/** column SYSTEMKEY : systemkey */
			//	 			dlgn0110dto.setPayCd(DlgnUtils.getSelectedComboValue(crePayCd,"commCd"));			/** column 급여구분 : payCd */
									dlgn0110dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));						/** column 급여구분 : payCd */
//				 			dlgn0110dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("detailEmymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
									dlgn0110dto.setEmymtDivCd(detailEmymtDivCd.getValue());    										/** column 고용구분코드 : emymtDivCd */
									dlgn0110dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    					/** column 부서코드 : deptCd */
									dlgn0110dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    				/** column 사업코드 : businCd */
									dlgn0110dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    			/** column 직종코드 : typOccuCd */
									dlgn0110dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));	/** column 직종세구분코드 : dtilOccuInttnCd */
			
									dlgn0110dto.setDilnlazYrMnth(detailYm.getValue().replaceAll("\\.",""));									/** column 근무년월 : detailYm */
									dlgn0110dto.setDilnlazApptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazApptnDt")));				/** column 근태일자 : dilnlazApptnDt */
				 			
				 			
									dlgn0110dto.setDilnlazDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyTm")));				/** column 근무시간 : dilnlazDutyTm */
									// 한자릿수 시간만 입력할 경우 저장 시 h:mm 형식으로 해줌.
									if(dlgn0110dto.getDilnlazDutyTm().length() == 1) {
										dlgn0110dto.setDilnlazDutyTm(dlgn0110dto.getDilnlazDutyTm() + ":00");								/** column 근무시간 : dilnlazDutyTm */
									}
				 			
									dlgn0110dto.setDilnlazDutyYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyYn")));				/** column 근무여부 : dilnlazDutyYn */
									dlgn0110dto.setDilnlazAbnceYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazAbnceYn")));				/** column 결근여부 : dilnlazAbnceYn */
									dlgn0110dto.setDilnlazLvsgYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazLvsgYn")));				/** column 연차여부 : dilnlazLvsgYn */
									dlgn0110dto.setDilnlazSpclHodyYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSpclHodyYn")));		/** column 특(휴)여부 : dilnlazSpclHodyYn */
				 					dlgn0110dto.setDilnlazSckleaYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSckleaYn")));			/** column 병가여부 : dilnlazSckleaYn */
				 					dlgn0110dto.setDilnlazOffvaYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazOffvaYn")));				/** column 공가여부 : dilnlazOffvaYn */
				 					dlgn0110dto.setDilnlazFmlyEvntYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazFmlyEvntYn")));		/** column 경조사여부 : dilnlazFmlyEvntYn */
				 					dlgn0110dto.setDilnlazHlthCreYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHlthCreYn")));			/** column 보건여부 : dilnlazHlthCreYn */
				 					dlgn0110dto.setDilnlazEtcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazEtcDivCd$commCd")));	/** column 복무기본코드 : dilnlazEtcDivCd */
				 					dlgn0110dto.setDilnlazTfcAssCstYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTfcAssCstYn")));		/** column 교통비여부 : dilnlazTfcAssCstYn */
				 					dlgn0110dto.setDilnlazLnchYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazLnchYn")));				/** column 급식비여부 : dilnlazLnchYn */
				 					dlgn0110dto.setDilnlazButpYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazButpYn")));    			/** column 근태_출장여부 : dilnlazButpYn */
				 					dlgn0110dto.setDilnlazSppySnkfYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazSppySnkfYn")));   	/** column 근태_간식비여부 : dilnlazSppySnkfYn */
				 					dlgn0110dto.setDilnlazNgtdyYn(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazNgtdyYn")));    			/** column 근태_숙직여부 : dilnlazNgtdyYn */
				 					
				 					dlgn0110dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(detailWeekHdayCnt.getValue())); 			/** 주휴일수 */
				 					
				 					listDlgn0110_1dto.add(dlgn0110dto);
			 			
								}
//				 			if(dlgn0110dto.getDilnlazDutyTm().length() == 4){
//				 				if(Integer.parseInt(dlgn0110dto.getDilnlazDutyTm().replace(":", "")) > 800){
//					 				MessageBox.info("", "근무시간 입력 최대시간은 8:00 입니다.", null);
//					 				return;
//				 				}
//				 			}
				 			
								if(dlgn0110dto.getDilnlazDutyTm().length() == 5){
									MessageBox.info("", "h:mm 형식 외에 입력 안됩니다.", null);
									return;
								}
				 			
								if(!dlgn0110dto.getDilnlazDutyTm().contains(":")){
									MessageBox.info("", "h:mm 형식 외에 입력 안됩니다.", null);
									return;
								}							
								
								
								
								
								
								//service 구현
								dlgn0110Service.updateDlgn0110Grid(listDlgn0110_1dto, new AsyncCallback<Long>(){
									@Override 
									public void onFailure(Throwable caught) {
										MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
												MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnDlgn0210(업데이트오류) : " + caught)
												, null);
									}
									@Override
									public void onSuccess(Long result) {
			 				
										if (result > 0L) {
											MessageBox.info("저장완료", "수정한 근무내역이 저장되었습니다.", null);
											Dlgn0100Grid0110.reload();      	
										} else { 
											
										}
									}    		
								});
							}
		              	}
		 			 }
				}); 
			}
//			}
		}
		

		  
		
//		detailWeekHday = false; 
	} 
//
//	//TODO 검색필드 시작
//	private void createSearchForm() {
//
//		plFrmDlgn0100.setLayout(new FlowLayout());
//
//		LayoutContainer lcSchCol = new LayoutContainer();
//		lcSchCol.setLayout(new ColumnLayout());
//
//		FieldSet fieldSet = new FieldSet();
//		fieldSet.setHeadingHtml("검색조건");
//		
//
//		LayoutContainer lcSchLeft = new LayoutContainer();
//		lcSchLeft.setStyleAttribute("paddingRight", "10px");
//
//		
//		LayoutContainer layoutContainer = new LayoutContainer();
//		FormLayout frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer.setLayout(frmlytSch);
//
//		searchCurrDeptCd = new ComboBox<BaseModel>();
//		searchCurrDeptCd.setFieldLabel("소 속");
//		searchCurrDeptCd.setForceSelection(true);
//		searchCurrDeptCd.setMinChars(1);
//		searchCurrDeptCd.setDisplayField("deptNmRtchnt");
//		searchCurrDeptCd.setValueField("deptCd");
//		searchCurrDeptCd.setTriggerAction(TriggerAction.ALL);
//		searchCurrDeptCd.setEmptyText("--소속선택--");
//		searchCurrDeptCd.setSelectOnFocus(true);
//		searchCurrDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		searchCurrDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
//		searchCurrDeptCd.setStore(listStoreBass0400All);
//		searchCurrDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				
//				if(searchCurrDeptCd.getValue() != null){
//					PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//					dto.setBusinApptnYr(DlgnUtils.getSelectedComboValue(searchYear)); //DateTimeFormat.getFormat("yyyy").format(new Date())
//					dto.setDeptCd(String.valueOf(searchCurrDeptCd.getValue().get("deptCd")));
//					
//					psnl0100Service.getBusinList(dto, new AsyncCallback<List<BaseModel>>() {
//						
//						@Override
//						public void onSuccess(List<BaseModel> result) {
//							ListStore<BaseModel> ls = new ListStore<BaseModel>();
//							ls.add(result);
//							searchBusinCd.setStore(ls);
//							searchBusinCd.setEmptyText("--사업명선택--");
//							searchBusinCd.setValue(new BaseModel());
//						}
//						
//						@Override
//						public void onFailure(Throwable caught) {
//							caught.printStackTrace();
//							MessageBox.alert("", "사업코드 에러!", null);
//						}
//					});
//					
//				}else{
//					searchBusinCd.setStore(new ListStore<BaseModel>());
//					searchBusinCd.setEmptyText("--소속선택--");
//					searchBusinCd.setValue(new BaseModel());
//				}
//			}
//		});
//		searchCurrDeptCd.setName("searchCurrDeptCd");
//		searchCurrDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//		    public void handleEvent(StoreEvent<BaseModel> be) {  
//		  	   EventType type = be.getType();
//	    	   if (type == Store.Add) { 
//              	  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//	                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//                   checkDlgn0100Auth("searchCurrDeptCd", listStoreBass0400All);  
//	    	   }   
//		    }
//		});
//		layoutContainer.add(searchCurrDeptCd, new FormData("100%"));
//		layoutContainer.setBorders(false);
//
//		LayoutContainer layoutContainer_1 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_1.setLayout(frmlytSch);
//
//		searchEmymtDivCd = new ComboBox<BaseModel>();
//		searchEmymtDivCd.setFieldLabel("고용구분");
//		searchEmymtDivCd.setForceSelection(true);
//		searchEmymtDivCd.setMinChars(1);
//		searchEmymtDivCd.setDisplayField("commCdNm");
//		searchEmymtDivCd.setValueField("commCd");
//		searchEmymtDivCd.setTriggerAction(TriggerAction.ALL);
//		searchEmymtDivCd.setEmptyText("--고용구분선택--");
//		searchEmymtDivCd.setSelectOnFocus(true);
//		searchEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//		searchEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
//		searchEmymtDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				
//				String emymt = searchEmymtDivCd.getValue() == null ? "" : String.valueOf(searchEmymtDivCd.getValue().get("commCd")) ;
//				
//				if("A0020010".equals(emymt)){ //공무직일 경우
//					
//					searchBusinCd.setValue(new BaseModel());
//					//searchTypOccuCd.setValue(new BaseModel());
//					searchBusinCd.setEnabled(false);
//					//searchTypOccuCd.setEnabled(true);
//					
//				}else if("A0020020".equals(emymt)){ //기간제 계약직일 경우
//					searchBusinCd.setValue(new BaseModel());
//					//searchTypOccuCd.setValue(new BaseModel());
//					searchBusinCd.setEnabled(true);
//					//searchTypOccuCd.setEnabled(false);
//				}else{
//					searchBusinCd.setValue(new BaseModel());
//					//searchTypOccuCd.setValue(new BaseModel());
//					searchBusinCd.setEnabled(true);
//					//searchTypOccuCd.setEnabled(true);
//					
//				}
//			}
//		});
//		searchEmymtDivCd.setStore(listStoreA002);
//		searchEmymtDivCd.setName("searchEmymtDivCd");
//		searchEmymtDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//		    public void handleEvent(StoreEvent<BaseModel> be) {   
//		    	  EventType type = be.getType();
//		    	   if (type == Store.Add) { 
//	              	  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//		                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	                   checkDlgn0100Auth("searchEmymtDivCd", listStoreA002);  
//		    	   }   
//		        
//		    }
//		});
//		layoutContainer_1.add(searchEmymtDivCd, new FormData("100%"));
//		layoutContainer_1.setBorders(false);
//		fieldSet.add(lcSchCol, new FormData("100%"));
//		lcSchLeft.setLayout(new ColumnLayout());
//
//		LayoutContainer layoutContainer_8 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_8.setLayout(frmlytSch);
//
//		searchYear = new ComboBox<BaseModel>();
//		searchYear.setFieldLabel("작업년월");
//		searchYear.setForceSelection(true);
//		searchYear.setMinChars(1);
//		searchYear.setDisplayField("commCdNm");
//		searchYear.setValueField("commCd");
//		searchYear.setTriggerAction(TriggerAction.ALL);
//		searchYear.setEmptyText("--년도--");
//		searchYear.setSelectOnFocus(true);
//		searchYear.setStore(listStoreSrhYr);
//		
//		layoutContainer_8.add(searchYear, new FormData("100%"));
//		layoutContainer_8.setBorders(false);
//		lcSchLeft.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//
//		LayoutContainer layoutContainer_9 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(0);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_9.setLayout(frmlytSch);
//
//		searchMonth = new ComboBox<BaseModel>();
//		searchMonth.setLabelSeparator("");
//		searchMonth.setForceSelection(true);
//		searchMonth.setMinChars(1);
//		searchMonth.setDisplayField("commCdNm");
//		searchMonth.setValueField("commCd");
//		searchMonth.setTriggerAction(TriggerAction.ALL);
//		searchMonth.setEmptyText("--월--");
//		searchMonth.setSelectOnFocus(true);
//		
//		
//		ListStore<BaseModel> tempStore = new ListStore<BaseModel>();
//		for(int i = 1; i < 13; i++){
//			BaseModel tempbm = new BaseModel();
//			String month = i+"";
//			if(i < 10) month = "0"+month;
//			tempbm.set("commCd", month);
//			tempbm.set("commCdNm", month);
//			tempStore.add(tempbm);
//		}
//		searchMonth.setStore(tempStore);
//		
//		layoutContainer_9.add(searchMonth, new FormData("100%"));
//		lcSchLeft.add(layoutContainer_9,
//				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		layoutContainer_9.setBorders(false);
//
//		lcSchCol.add(lcSchLeft,
//				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		lcSchCol.add(layoutContainer,
//				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
//		lcSchCol.add(layoutContainer_1,
//				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//
//		LayoutContainer layoutContainer_3 = new LayoutContainer();
//		layoutContainer_3.setLayout(new ColumnLayout());
//
//		LayoutContainer layoutContainer_2 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_2.setLayout(frmlytSch);
//
//		searchDeptCd = new ComboBox<BaseModel>();
//		searchDeptCd.setFieldLabel("부서명");
//		searchDeptCd.setForceSelection(true);
//		searchDeptCd.setMinChars(1);
//		searchDeptCd.setDisplayField("deptNmRtchnt");
//		searchDeptCd.setValueField("mangeDeptCd");
//		searchDeptCd.setTriggerAction(TriggerAction.ALL);
//		searchDeptCd.setEmptyText("--부서명선택--");
//		searchDeptCd.setSelectOnFocus(true);
//		searchDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		searchDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
//		searchDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
//
//			@Override
//			public void handleEvent(BaseEvent be) {
//				PrgmComBass0400DTO sysComBass0400Dto = new PrgmComBass0400DTO();
//				
//				if(searchDeptCd.getValue() != null){
//					sysComBass0400Dto.setMangeDeptCd(searchDeptCd.getValue().get("mangeDeptCd")+"");
//				}
//				
//				searchCurrDeptCd.getStore().removeAll();
//				
//				sysComBass0400Service.getPrgmComDeptBass0400List(sysComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
//					
//					@Override
//					public void onSuccess(List<BaseModel> result) {
//						ListStore<BaseModel> ls = new ListStore<BaseModel>();
//						ls.add(result);
//						searchCurrDeptCd.setStore(ls);
//						searchCurrDeptCd.setEmptyText("--소속선택--");
//						searchCurrDeptCd.setValue(new BaseModel());
//						
//						searchBusinCd.setStore(new ListStore<BaseModel>());
//						searchBusinCd.setEmptyText("--소속선택--");
//						searchBusinCd.setValue(new BaseModel());
//						
//					}
//					@Override
//					public void onFailure(Throwable caught) {
//						caught.printStackTrace();
//					}
//				});
//				/*Dlgn0100DTO dto = new Dlgn0100DTO();
//				
//				if(searchDeptCd.getValue() != null){
//					dto.setDeptCd(searchDeptCd.getValue().get("mangeDeptCd")+"");
//				}
//				
//				searchCurrDeptCd.getStore().removeAll();
//				
//				dlgn0100Service.getPayrMangDeptCd(dto, new AsyncCallback<List<BaseModel>>() {
//					
//					@Override
//					public void onSuccess(List<BaseModel> result) {
//						ListStore<BaseModel> ls = new ListStore<BaseModel>();
//						ls.add(result);
//						searchCurrDeptCd.setStore(ls);
//						searchCurrDeptCd.setEmptyText("--소속선택--");
//						searchCurrDeptCd.setValue(new BaseModel());
//						
//						searchBusinCd.setStore(new ListStore<BaseModel>());
//						searchBusinCd.setEmptyText("--소속선택--");
//						searchBusinCd.setValue(new BaseModel());
//						
//					}
//					@Override
//					public void onFailure(Throwable caught) {
//						caught.printStackTrace();
//					}
//				});*/
//				
//			}
//		
//		});
//		searchDeptCd.setStore(listStoreBass0400);
//		layoutContainer_2.add(searchDeptCd, new FormData("100%"));
//		layoutContainer_3.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		layoutContainer_2.setBorders(false);
//
//		LayoutContainer layoutContainer_4 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_4.setLayout(frmlytSch);
//
//		searchBusinCd = new ComboBox<BaseModel>();
//		searchBusinCd.setFieldLabel("사업명");
//		searchBusinCd.setForceSelection(true);
//		searchBusinCd.setMinChars(1);
//		searchBusinCd.setDisplayField("businYearNm");
//		searchBusinCd.setValueField("businCd");
//		searchBusinCd.setTriggerAction(TriggerAction.ALL);
//		searchBusinCd.setEmptyText("--소속선택--");
//		searchBusinCd.setSelectOnFocus(true);
//		searchBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		searchBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//		searchBusinCd.setStore(new ListStore<BaseModel>());
//		searchBusinCd.setName("searchBusinCd");
//		
//		
//		layoutContainer_4.add(searchBusinCd, new FormData("100%"));
//		layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
//		layoutContainer_4.setBorders(false);
//
//		LayoutContainer layoutContainer_5 = new LayoutContainer();
//		layoutContainer_5.setLayout(new ColumnLayout());
//
//		LayoutContainer layoutContainer_6 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_6.setLayout(frmlytSch);
//
//		searchName = new TextField<String>();
//		searchName.setFieldLabel("성명");
//		layoutContainer_6.add(searchName, new FormData("100%"));
//		layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer_6.setBorders(false);
//
//		/*Button button = new Button("검색");
//		layoutContainer_5.add(button);*/
//
//		LayoutContainer layoutContainer_7 = new LayoutContainer();
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_7.setLayout(frmlytSch);
//
//		searchResnRegnNum = new TextField<String>();
//		searchResnRegnNum.setFieldLabel("주민번호");
//		layoutContainer_7.add(searchResnRegnNum, new FormData("100%"));
//		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		layoutContainer_7.setBorders(false);
//		layoutContainer_3.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		layoutContainer_5.setBorders(false);
//		fieldSet.add(layoutContainer_3);
//		layoutContainer_3.setBorders(false);
//
//		plFrmDlgn0100.add(fieldSet);
//		// vp.add(panel);
//	}
//
	
	
	private void createDataForm() {
		  
		msfCoCalendarDto = new SysCoCalendarDTO();
		     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//년도
		lscrPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);	//월 
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	         
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistcrTypOccuCd = DlgnUtils.getTypOccuCdModelData(lscrTypOccuCd) ;  
				creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);
			}
		});  
		 
		FieldSet fldstNewFieldset = new FieldSet(); 
		 
		LayoutContainer layoutContainer21 = new LayoutContainer(new ColumnLayout());
		layoutContainer21.setBorders(false);
		          
		         
		LayoutContainer lc11 = new LayoutContainer();
		FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(60);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc11.setLayout(fl1);
		         
		         
		LayoutContainer lc1_1 = new LayoutContainer(new ColumnLayout());
              
		LayoutContainer lc1_1_1 = new LayoutContainer();
        FormLayout fl1_1 = new FormLayout();
        fl1_1.setLabelWidth(60);
        fl1_1.setLabelAlign(LabelAlign.RIGHT);
        lc1_1_1.setLayout(fl1_1);
              
        creYear = new MSFComboBox<BaseModel>();
        creYear.setName("creYear");
        creYear.setFieldLabel("작업년월");
     	creYear.setForceSelection(true);
       	creYear.setMinChars(1);
     	creYear.setDisplayField("yearDisp");
     	creYear.setValueField("year");
     	creYear.setTriggerAction(TriggerAction.ALL);
      	creYear.setEmptyText("--년도--");
    	creYear.setSelectOnFocus(true);
    	creYear.setStore(lscrPayYr);
     	creYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
     		public void handleEvent(StoreEvent<BaseModel> be) {  
     			EventType type = be.getType();
     			if (type == Store.Add) { 
     				/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
     				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
     				 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			  			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
     						checkDlgn0100Auth("creYear", lscrPayYr); 
     			}
     		}
     	});
     	
     	creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
     		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
     			//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
     			BaseModel bmPayYr =  se.getSelectedItem(); 
     			if (bmPayYr != null) {
     				if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
     					if (creDeptCd.getListView().getChecked().size() > 0) {  
     						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));
     						List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
     						sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
     					}      
     					//--------------------사업 불러 오는 함수 -------------------------------------------------
     					lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
     					//--------------------사업 불러 오는 함수 -------------------------------------------------
     					creBusinCd.setStore(lscrBusinCd); 
     					creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
     						public void handleEvent(StoreEvent<BaseModel> be) {  
                                  //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
     						}
     					});  
     					
     					//dlgn0110Grid.getColumnModel().getColumn(5).setHidden(false);  // setHideable(false);   // this ensures the the user cannot toggle hide/show on the column with the header menus
     				 
     				} else {
     					
     					//dlgn0110Grid.getColumnModel().getColumn(5).setHidden(true);  // setHideable(false);   // this ensures the the user cannot toggle hide/show on the column with the header menus
     					//그리드 랜더링 다시 하기 ......
                          // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                          //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
                          // return;
     				}  
     			}       
     		} 
     	});   
     	lc1_1_1.add(creYear, new FormData("100%"));
              
              
     	LayoutContainer lc1_1_2 = new LayoutContainer();
    	FormLayout fl1_2 = new FormLayout();
        fl1_2.setLabelWidth(0);
       	fl1_2.setLabelAlign(LabelAlign.RIGHT);
        lc1_1_2.setLayout(fl1_2);
             
        creMonth = new MSFComboBox<BaseModel>();
       	creMonth.setName("creMonth");
       	creMonth.setHideLabel(true);
       	creMonth.setForceSelection(true);
        creMonth.setMinChars(1);
        creMonth.setDisplayField("monthDisp");
     	creMonth.setValueField("month");
       	creMonth.setTriggerAction(TriggerAction.ALL);
     	creMonth.setEmptyText("--월--");
      	creMonth.setSelectOnFocus(true); 
       	creMonth.setStore(lscrPayMonth);
       	creMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
       		public void handleEvent(StoreEvent<BaseModel> be) {   
       			checkDlgn0100Auth("creMonth", lscrPayMonth); 
                    //  GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
       			}
       		});
     	creMonth.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
     		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
     			//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
     			BaseModel bmMonth =  se.getSelectedItem(); 
     			if (bmMonth != null) { 
     				if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creMonth,"month"))) {
     					setInitDate();
     				}
     			}       
     		} 
     	});   
     	lc1_1_2.add(creMonth, new FormData("100%"));
              
              
     	lc1_1.add(lc1_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.74));
     	lc1_1.add(lc1_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
              
     	lc11.add(lc1_1, new FormData("100%"));
     	
       	LayoutContainer lc21 = new LayoutContainer();
		FormLayout fl2 = new FormLayout();
		fl2.setLabelWidth(60);
		fl2.setLabelAlign(LabelAlign.RIGHT);
		lc21.setLayout(fl2);
		         
              
		/** column 단위기관 : payrMangDeptCd */
        crePayrMangDeptCd = new MSFComboBox<BaseModel>();
		crePayrMangDeptCd.setName("crePayrMangDeptCd");
		crePayrMangDeptCd.setForceSelection(true);
		crePayrMangDeptCd.setMinChars(1);
		crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
		crePayrMangDeptCd.setValueField("payrMangDeptCd");
		crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		crePayrMangDeptCd.setEmptyText("--단위기관선택--");
		crePayrMangDeptCd.setSelectOnFocus(true);
		crePayrMangDeptCd.setReadOnly(false);
		crePayrMangDeptCd.setEnabled(true);
		crePayrMangDeptCd.setStore(lscrPayrMangDeptCd);
		crePayrMangDeptCd.setFieldLabel("단위기관");
		lscrPayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgn0100Auth("crePayrMangDeptCd", lscrPayrMangDeptCd);
				}
			}
		});
		crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
				creDeptCd.reset();
				sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
				// --------------------부서 불러 오는 함수------------------------------------------------
				lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
				// --------------------부서 불러 오는 함수------------------------------------------------
						
				lscrDeptCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistcrDeptCd = DlgnUtils.getDeptCdModelData(lscrDeptCd);
						creDeptCd.getInitStore().add(mDtalistcrDeptCd);
					}
				});
			}
		});
		lc21.add(crePayrMangDeptCd, new FormData("100%"));
		          
		         
		LayoutContainer lc31 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1222 = new LayoutContainer();
		
		FormLayout fl11 = new FormLayout();
		fl11.setLabelWidth(60);
		fl11.setLabelAlign(LabelAlign.RIGHT);
		lc1222.setLayout(fl11);

		creEmymtDivCd = new MSFComboBox<BaseModel>();
		creEmymtDivCd.setFieldLabel("고용구분");
		creEmymtDivCd.setForceSelection(true);
		creEmymtDivCd.setMinChars(1);
		creEmymtDivCd.setDisplayField("commCdNm");
		creEmymtDivCd.setValueField("commCd");
		creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		creEmymtDivCd.setEmptyText("--고용구분선택--");
		creEmymtDivCd.setSelectOnFocus(true);
		creEmymtDivCd.setStore(lscrEmymtDivCd);
		creEmymtDivCd.setName("creEmymtDivCd");
		creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					creDeptCd.getListView().fireEvent(Events.CheckChanged);
					creBusinCd.setEnabled(true);
					creTypOccuCd.reset();
					creTypOccuCd.setEnabled(false);
					creDtilOccuInttnCd.reset();
					creDtilOccuInttnCd.setEnabled(false);
				} else if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
					creBusinCd.reset();
					creBusinCd.setEnabled(false);
					// 20151130 추가 수정
					creDeptCd.getListView().fireEvent(Events.CheckChanged);
					if (gwtExtAuth.getEnableTypOccuCd()) {
						creTypOccuCd.setEnabled(true);
						creDtilOccuInttnCd.setEnabled(true);
					} else {
						creTypOccuCd.setEnabled(false);
						creDtilOccuInttnCd.setEnabled(false);
					}
				} else {

				}

			}
		});
		lscrEmymtDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관, 고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgn0100Auth("creEmymtDivCd", lscrEmymtDivCd);
				}
			}
		});
		lc1222.add(creEmymtDivCd, new FormData("100%"));
		lc31.add(lc1222, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		

	    LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    creRepbtyBusinDivCd  =  new MSFComboBox<BaseModel>(); 
	    creRepbtyBusinDivCd.setName("creRepbtyBusinDivCd");
	    creRepbtyBusinDivCd.setHideLabel(true);
	    creRepbtyBusinDivCd.setForceSelection(true);
	    creRepbtyBusinDivCd.setAllowBlank(false);
	    creRepbtyBusinDivCd.setMinChars(1);
	    creRepbtyBusinDivCd.setDisplayField("commCdNm");
	    creRepbtyBusinDivCd.setValueField("commCd");
	    creRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    creRepbtyBusinDivCd.setEmptyText("--호봉제--");
	    creRepbtyBusinDivCd.setSelectOnFocus(true); 
	    creRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    creRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	    creRepbtyBusinDivCd.setStore(lscreRepbtyBusinDivCd);
	    creRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lscreRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    layoutContainer_101.add(creRepbtyBusinDivCd, new FormData("100%"));
	    lc31.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
              
		
	    
	

//		layoutContainer21.add(lc11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));	
//		layoutContainer21.add(lc21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		layoutContainer21.add(lc31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		layoutContainer21.add(lc41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));

      	
		layoutContainer21.add(lc11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 작업년월
		layoutContainer21.add(lc21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
		layoutContainer21.add(lc31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
		
		
		
		
		LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
		layoutContainer.setBorders(false);
		
		
		//관리부서 
		LayoutContainer lcSch2_1 = new LayoutContainer();
		FormLayout frmlytSch2_1 = new FormLayout();
		frmlytSch2_1.setLabelWidth(60);
		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_1.setLayout(frmlytSch2_1);
		
		creMangeDeptCd = new MSFComboBox<BaseModel>();
		creMangeDeptCd.setName("creMangeDeptCd"); 
		creMangeDeptCd.setEmptyText("--관리부서선택--");
		creMangeDeptCd.setDisplayField("deptNmRtchnt");
		creMangeDeptCd.setStore(lscreMangeDeptCd); 
		creMangeDeptCd.setWidth(100);
		creMangeDeptCd.setFieldLabel("관리부서");
		creMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		creMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	EventType type = be.getType();
            	if (type == Store.Add) { 
            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
            		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
            	}
            }
        });  
		creMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	    		sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd")); 
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd"))); 
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		
  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
  	    				mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lscrDeptCd) ; 
  	    				creDeptCd.getInitStore().add(mDtalistDeptCd);
  	    			}
  	    		});  
  	    		emptyCheck = true;
	    	} 
	    });
		creMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
            	
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
                	
                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
	                	sysComBass0400Dto = new PrgmComBass0400DTO();
	      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));  
	      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd")); 
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    		lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    		
	      	    		lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	      	    				mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lscrDeptCd) ; 
	      	    				creDeptCd.getInitStore().add(mDtalistDeptCd);
	      	    			} 
	      	    			
	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        lcSch2_1.add(creMangeDeptCd, new FormData("100%"));

		
		LayoutContainer lc2 = new LayoutContainer();
		FormLayout fl21 = new FormLayout();
		fl21.setLabelWidth(60);
		fl21.setLabelAlign(LabelAlign.RIGHT);
		lc2.setLayout(fl21);

		creDeptCd = new MSFMultiComboBox<ModelData>();
		creDeptCd.setName("creDeptCd");
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		creDeptCd.getStore().add(mDtalistcrDeptCd);
		creDeptCd.setWidth(100);
		creDeptCd.setFieldLabel("부서");
		creDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				// srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관,  고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgn0100Auth("creDeptCd", lscrDeptCd);
				}
			}
		});

		creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((creDeptCd.getListView().getChecked().size() == 1)
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

					if (creDeptCd.getListView().getChecked().size() > 0) {

						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));
						List<ModelData> mdListSelect = creDeptCd.getListView().getChecked();
						sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
					}

					// --------------------사업 불러 오는 함수-------------------------------------------------
					lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수-------------------------------------------------
					creBusinCd.setStore(lscrBusinCd);
					creBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
								// creBusinCd.setValue(lscrBusinCd.getAt(0));
						}
					});

				} else if ((creDeptCd.getListView().getChecked().size() > 0)
								&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

					// 2015.11.30 권한 직종가져오기 추가
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
					String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt", "deptCd");
					sysComBass0320Dto.setDeptCd(strDeptCd);
					lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
					lscrTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
							mDtalistcrTypOccuCd = DlgnUtils.getTypOccuCdModelData(lscrTypOccuCd);
							creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);
						}
					});
				}
			}
		});

		creDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		lc2.add(creDeptCd, new FormData("100%"));

		LayoutContainer lc3 = new LayoutContainer();
		FormLayout fl31 = new FormLayout();
		fl31.setLabelWidth(60);
		fl31.setLabelAlign(LabelAlign.RIGHT);
		lc3.setLayout(fl31);

		// 직종 직종세처리
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());
		
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_211.setLayout(frmlytSch); 
       
        creDeptGpCd  =  new MSFComboBox<BaseModel>(); 
        creDeptGpCd.setName("creDeptGpCd");
        creDeptGpCd.setForceSelection(true);
        creDeptGpCd.setAllowBlank(false);
        creDeptGpCd.setMinChars(1);
        creDeptGpCd.setDisplayField("commCdNm");
        creDeptGpCd.setValueField("commCd");
        creDeptGpCd.setTriggerAction(TriggerAction.ALL);
        creDeptGpCd.setEmptyText("--그룹--");
        creDeptGpCd.setSelectOnFocus(true); 
        creDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
        creDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        creDeptGpCd.setStore(lscreDeptGpCd);
        creDeptGpCd.setFieldLabel("직종"); 
        
        layoutContainer_211.add(creDeptGpCd, new FormData("100%")); 
		

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(30);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);

		creTypOccuCd = new MSFMultiComboBox<ModelData>();
		creTypOccuCd.setName("creTypOccuCd");
		creTypOccuCd.setHideLabel(true);
		creTypOccuCd.setEmptyText("--직종선택--");
		creTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
		creTypOccuCd.setWidth(100);
//		creTypOccuCd.setFieldLabel("직종");
		creTypOccuCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				// 2015.11.30 추가
				if (!gwtExtAuth.getEnableTypOccuCd()) {
					ModelData mdSelect = creTypOccuCd.getStore().getAt(0);
					creTypOccuCd.getListView().setChecked(mdSelect,true);
					creTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
				}
				EventType type = be.getType();
				if (type == Store.Add) {
				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
				 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
					// checkDlgn0100Auth("creTypOccuCd", lscrTypOccuCd);
				}
			}
		});

		creTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				// 2015.11.30 추가
				displayCreDtilOccuInttnCd();
			}
		});

		creTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		// 2015.11.30 추가
		creTypOccuCd.addListener(Events.Add, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent ce) {
				displayCreDtilOccuInttnCd();
			}
		});
		layoutContainer_21.add(creTypOccuCd, new FormData("100%"));

		LayoutContainer lcSchRight = new LayoutContainer();
		// lcSchRight.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		// fieldSet.setLayout(layout);
		lcSchRight.setLayout(frmlytSch);

		/** column 직종세코드 : dtilOccuInttnCd */
		creDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		creDtilOccuInttnCd.setName("creDtilOccuInttnCd");
		creDtilOccuInttnCd.setEmptyText("--직종세선택--");
		creDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		creDtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
		creDtilOccuInttnCd.setWidth(100);
		creDtilOccuInttnCd.setHideLabel(true);
		creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				} else {
					
				}
			}
		});

		lcSchRight.add(creDtilOccuInttnCd, new FormData("100%"));

		lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));

		layoutContainer_21.setBorders(false);
		lc3.add(lcTypOccuCd, new FormData("100%"));
 
		
		
//		layoutContainer.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
//		layoutContainer.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		layoutContainer.add(lc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		layoutContainer.add(lc4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		
		layoutContainer.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 급여구분
		layoutContainer.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
		layoutContainer.add(lc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종 

		
		
		
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
        
        
        
    		LayoutContainer lc41 = new LayoutContainer(new ColumnLayout());
//    		FormLayout fl2 = new FormLayout();
//    		fl2.setLabelWidth(60);
//    		fl2.setLabelAlign(LabelAlign.RIGHT);
//    		lc41.setLayout(fl2);
    		         
//    		LayoutContainer lc2_1 = new LayoutContainer(new ColumnLayout());
                  
    		LayoutContainer lc41_1 = new LayoutContainer();
         	FormLayout fl41_1 = new FormLayout();
         	fl41_1.setLabelWidth(60);
         	fl41_1.setLabelAlign(LabelAlign.RIGHT);
         	lc41_1.setLayout(fl41_1);
             
                   
         	creWorkDayS = new MSFDateField();
         	creWorkDayS.setName("creWorkDayS");
         	new DateFieldMask(creWorkDayS, "9999.99.99"); 
         	creWorkDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
         	creWorkDayS.setFieldLabel("근태기간");
             
         	lc41_1.add(creWorkDayS, new FormData("100%"));
                  
         	LayoutContainer lc41_2 = new LayoutContainer();
         	FormLayout fl41_2 = new FormLayout();
         	fl41_2.setLabelWidth(7);
         	fl41_2.setLabelAlign(LabelAlign.RIGHT);
          	lc41_2.setLayout(fl41_2);
                  
          	creWorkDayE = new MSFDateField();
          	creWorkDayE.setName("creWorkDayE");
         	new DateFieldMask(creWorkDayE, "9999.99.99"); 
        	creWorkDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
          	creWorkDayE.setLabelSeparator("~");
          	lc41_2.add(creWorkDayE, new FormData("100%"));
                  
          	lc41.add(lc41_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.61));
          	lc41.add(lc41_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
                  
//          	lc41.add(lc2_1, new FormData("100%"));
    		
        
//        LayoutContainer layoutContainer_16 = new LayoutContainer();
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(0); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16.setLayout(frmlytSch);
        
    	LayoutContainer lc1 = new LayoutContainer();
		FormLayout fl4 = new FormLayout();
		fl4.setLabelWidth(60);
		fl4.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl4);

		crePayCd = new MSFComboBox<BaseModel>();
		crePayCd.setName("crePayCd");
		crePayCd.setFieldLabel("급여구분");
		crePayCd.setForceSelection(true);
		crePayCd.setMinChars(1);
		crePayCd.setDisplayField("commCdNm");
		crePayCd.setValueField("commCd");
		crePayCd.setTriggerAction(TriggerAction.ALL);
		crePayCd.setEmptyText("--급여구분선택--");
		crePayCd.setSelectOnFocus(true);
		crePayCd.setStore(lscrPayCd);
		// crePayCd.setReadOnly(true);
		crePayCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관, 고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgn0100Auth("crePayCd", lscrPayCd);
				}
			}
		});

		lc1.add(crePayCd, new FormData("100%"));
        
		LayoutContainer lc4 = new LayoutContainer();
		FormLayout fl41 = new FormLayout();
		fl41.setLabelWidth(60);
		fl41.setLabelAlign(LabelAlign.RIGHT);
		lc4.setLayout(fl41);

		creBusinCd = new MSFComboBox<BaseModel>();
		creBusinCd.setName("creBusinCd");
		creBusinCd.setFieldLabel("사업");
		creBusinCd.setForceSelection(true);
		creBusinCd.setMinChars(1);
		creBusinCd.setDisplayField("businNm");
		creBusinCd.setValueField("businCd");
		creBusinCd.setTriggerAction(TriggerAction.ALL);
		creBusinCd.setEmptyText("--사업선택--");
		creBusinCd.setSelectOnFocus(true);
		creBusinCd.setStore(lscrBusinCd);
 
		creBusinCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					srhBusinCd.setValue(lsBusinCd.findModel("businCd",bmPayCd.get("businCd")));
				}
			}
		});
		lc4.add(creBusinCd, new FormData("100%"));
		
        
        lcSchCol3.add(lc41,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));				// 사업
        lcSchCol3.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));				// 출력조건
        lcSchCol3.add(lc4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 성명

		
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);

		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.0);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		layoutContainer_2.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSch);

		layoutContainer_1.add(layoutContainer_4, new FormData("100%"));
		layoutContainer_4.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_1.add(layoutContainer_3, new FormData("100%"));
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSch);

		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_1.add(layoutContainer_5, new FormData("100%"));
		layoutContainer_5.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmlytSch);
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		
        LayoutContainer layoutContainer_11 = new LayoutContainer();
        layoutContainer_11.setLayout(new HBoxLayout()); 
         
         LayoutContainer layoutContainer_22 = new LayoutContainer();
         layoutContainer_22.setStyleAttribute("paddingRight", "10px");
         frmlytSch = new FormLayout();  
         frmlytSch.setLabelWidth(60); 
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
         layoutContainer_22.setLayout(frmlytSch);
         
         dlgn0100flUp = new FileUploadField();
         dlgn0100flUp.setName("dlgn0100flUp");
         dlgn0100flUp.setValidator(new Validator() {  
         	@Override  
         	public String validate(Field<?> field, String value) { 
         		value = value.toLowerCase();        
         		String result = "xls 파일이 아닙니다., 다시선택하십시요."; 
         		
         		if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
         			result = null;        
         		}        
         		return result;  
         	} 
         });
         
         layoutContainer_22.add(dlgn0100flUp, new FormData("100%"));
         dlgn0100flUp.setFieldLabel("근무실적");
          
         HBoxLayoutData hbld_layoutContainer_22 = new HBoxLayoutData();
         hbld_layoutContainer_22.setFlex(1.0);
         layoutContainer_11.add(layoutContainer_22, hbld_layoutContainer_22);
         layoutContainer_22.setBorders(false);
         
         LayoutContainer layoutContainer_44 = new LayoutContainer();
         layoutContainer_44.setStyleAttribute("paddingRight", "10px");
         frmlytSch = new FormLayout();  
         frmlytSch.setLabelWidth(100); 
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
         layoutContainer_44.setLayout(frmlytSch);
         
         
         
		
		btnDlgn0100Upload = new Button("실적업로드");
		btnDlgn0100Upload.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsImportData();
			}
		});
		  layoutContainer_44.add(btnDlgn0100Upload, new FormData("100%"));
	      layoutContainer_11.add(layoutContainer_44, new FormData("100%"));
          layoutContainer_44.setBorders(false);
          
          LayoutContainer layoutContainer_33 = new LayoutContainer();
          layoutContainer_11.add(layoutContainer_33, new FormData("100%"));
          layoutContainer_33.setStyleAttribute("paddingRight", "10px");
          frmlytSch = new FormLayout();  
          frmlytSch.setLabelWidth(100); 
          frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
          layoutContainer_33.setLayout(frmlytSch);
		
		btnDlgn0100DownLoad = new Button("양식다운로드");
		btnDlgn0100DownLoad.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportData();
			}
		});
		
		layoutContainer_33.add(btnDlgn0100DownLoad, new FormData("100%"));
		layoutContainer_33.setBorders(false);
		
		LayoutContainer layoutContainer_55 = new LayoutContainer();
        layoutContainer_11.add(layoutContainer_55, new FormData("100%"));
        layoutContainer_55.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(100); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
        layoutContainer_55.setLayout(frmlytSch);
		
		Button btnDlgn0250AllCreate = new Button("기본및시간외 근무 일괄생성");
		btnDlgn0250AllCreate.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
//				creSystemkey.setValue("");	//근태 개별 생성 후 일괄 생성할 경우 systemkey 들어가면 안되기 때문에
				DlgnP010001 dlgnP010001Form = new DlgnP010001(ActionDatabase.READ, getThis());   
				   //엣지변환
				  //MSFFormWindows msFwDlgnP010001= new MSFFormWindows("복무관리 일괄생성 (기본근무, 시간외근무 생성)" ,dlgnP010001Form,"닫기","520px", "320px",true);
			       MSFFormWindows msFwDlgnP010001= new MSFFormWindows("복무관리 일괄생성 (기본근무, 시간외근무 생성)" ,dlgnP010001Form,"닫기","520px", "370px",true);
			       msFwDlgnP010001.show();
			       dlgnP010001Form.setMSFFormWindows(msFwDlgnP010001);
			       
//			      funcSetPopUpRecord();
//			      dlgnP010001Form.bind(ppRecord); 
			}
		});
		
		layoutContainer_55.add(btnDlgn0250AllCreate, new FormData("100%"));
		layoutContainer_55.setBorders(false);
		
		
		LayoutContainer layoutContainer_66 = new LayoutContainer();
        layoutContainer_11.add(layoutContainer_66, new FormData("100%"));
        layoutContainer_66.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(100); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
        layoutContainer_66.setLayout(frmlytSch);
        
        
		Button btnDlgn0250CreateSingle = new Button("근태 개별생성");
		btnDlgn0250CreateSingle.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// TODO 다시
				dlgn0100Grid.getStore().removeAll();
				
				String year = DlgnUtils.getSelectedComboValue(creYear,"year");
				String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
				String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
				String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
				String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
				String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
				String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd");
				String mangeDeptCd = DlgnUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd");
				String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd"); 
					
				boolean doAction = false;
				String message = "근태생성 조건 : ";
				
				if("".equals(year) || "".equals(month)){
					MessageBox.info("", message+"작업년월은 필수 입니다.", null);
				}else if("".equals(workDayS) || "".equals(workDayE)){
					MessageBox.info("", message+"근태기간은 필수 입니다.", null);
				}else if("".equals(payrMangDeptCd) || "".equals(payrMangDeptCd)){
					MessageBox.info("", message+"단위기관은 필수 입니다.", null);
				}else if("".equals(payCd)){
					MessageBox.info("", message+"급여구분은 필수 입니다.", null);
				}else if("".equals(emymtDivCd) || "".equals(emymtDivCd)){
					MessageBox.info("", message+"고용구분은 필수 입니다.", null);
				}else if("".equals(emymtDivCd) || "".equals(deptCd)){
					MessageBox.info("", message+"부서는 필수 입니다.", null);
				}else if(GregorianCalendar.compareDate(creWorkDayS.getValue(), creWorkDayE.getValue()) < 0){
					MessageBox.info("", message+"근태기간 설정이 이상합니다. 확인하십시요.", null);  
				} else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {    
					if("".equals(businCd)){
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), message+"사업명을 선택하십시요.", null);
         		     } else {
         		    	doAction = true;
         		     }
				} else {
					doAction = true;
				}
						
				if(doAction) {
            	  fnPopupPsnl0100("DLGN");
				}
			}
		});
		
		layoutContainer_66.add(btnDlgn0250CreateSingle, new FormData("100%"));
		layoutContainer_66.setBorders(false);
		
		LayoutContainer layoutContainer_77 = new LayoutContainer();
        layoutContainer_11.add(layoutContainer_77, new FormData("100%"));
        layoutContainer_77.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(100); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
        layoutContainer_77.setLayout(frmlytSch);

		Button btnDlgn0250Create = new Button("근태 일괄생성");
		btnDlgn0250Create.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				creSystemkey.setValue("");	//근태 개별 생성 후 일괄 생성할 경우 systemkey 들어가면 안되기 때문에
				
				// TODO 다시
				createDlgn0100Data();
			}
		});
		
		layoutContainer_77.add(btnDlgn0250Create, new FormData("100%"));
		layoutContainer_77.setBorders(false);
		
//		buttonBar.add(btnDlgn0100Upload);
//		buttonBar.add(btnDlgn0100DownLoad);
//		buttonBar.add(btnDlgn0250AllCreate);
//		buttonBar.add(btnDlgn0250CreateSingle);
//		buttonBar.add(btnDlgn0250Create);
////		layoutContainer_5.add(layoutContainer_11);
//		layoutContainer_5.add(buttonBar);
		
		fldstNewFieldset.add(layoutContainer21, new FormData("100%"));
		fldstNewFieldset.add(layoutContainer, new FormData("100%"));
		fldstNewFieldset.add(lcSchCol3, new FormData("100%"));
		fldstNewFieldset.add(layoutContainer_1, new FormData("100%"));
		fldstNewFieldset.add(layoutContainer_11, new FormData("100%"));

		fldstNewFieldset.setHeadingHtml("기본근무생성");

		plFrmDlgn0100.add(fldstNewFieldset);
		  
	}	
	
	
	
//	//TODO 중간 근태생성 필드 시작
	private void createStandardForm() {
		
		LayoutContainer lcButtom = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer leftGrid = new LayoutContainer();
		FieldSet fieldGridLeft = new FieldSet();
//		fieldGridLeft.setSize("330px", "440px");
		//엣지변환
		//fieldGridLeft.setSize("330px", "402px");
		fieldGridLeft.setSize("330px", "432px");
		fieldGridLeft.setHeadingHtml("근로자정보");
		fieldGridLeft.setStyleAttribute("paddingLeft", "5px");
		fieldGridLeft.setStyleAttribute("paddingRight", "5px");
		fieldGridLeft.setCollapsible(false);
		fieldGridLeft.add(occupationalLeft(), new FormData("100%"));
		leftGrid.add(fieldGridLeft);
		
		
		LayoutContainer rightGrid = new LayoutContainer();
		
//		FieldSet fieldRightForm = new FieldSet();
//		fieldRightForm.setSize("625px", "145px");
//		fieldRightForm.setSize("625px", "130px");
		//엣지변환
		//fieldRightForm.setSize("625px", "90px");
		fieldRightForm.setSize("625px", "120px");
//		fieldRightForm.setSize(622, 145);
		fieldRightForm.setHeadingHtml("근태상세정보");
		fieldRightForm.setCollapsible(false);
		fieldRightForm.add(occupationalRTop(), new FormData("100%"));
		rightGrid.add(fieldRightForm);

//		FieldSet fieldRightGrid = new FieldSet();
		//엣지변환
		//fieldRightGrid.setSize("625px", "310px");
		fieldRightGrid.setSize("625px", "310px");
//		fieldRightGrid.setSize(610, 270);
		fieldRightGrid.setHeadingHtml("근무내역등록");
		fieldRightGrid.setStyleAttribute("paddingLeft", "5px");
		fieldRightGrid.setStyleAttribute("paddingRight", "5px");
		fieldRightGrid.setCollapsible(false);
		fieldRightGrid.add(occupationalRBottom(), new FormData("100%"));
		rightGrid.add(fieldRightGrid);
		
		lcButtom.add(leftGrid,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcButtom.add(rightGrid,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		
		LayoutContainer layoutContainer_81 = new LayoutContainer();

		lblfldNewLabelfield_16 = new LabelField(
				"* 근무시간 입력방식( ex : 8시간일 경우 8:00 , 5시간 35분일 경우 5:35 )와 같이 입력해주세요. 근무시간 최대 입력시간은 8:00 입니다.");
		layoutContainer_81.add(lblfldNewLabelfield_16);
		lcButtom.add(layoutContainer_81, new FormData("100%"));
		
		LayoutContainer layoutContainer_82 = new LayoutContainer();

		lblfldNewLabelfield_17 = new LabelField(
				"* 결근, 연차, 특(휴), 병가, 공가, 경조사, 보건 체크시 근무시간 0:00로 근무여부 체크는 없어집니다.");
		layoutContainer_82.add(lblfldNewLabelfield_17);
		lcButtom.add(layoutContainer_82, new FormData("100%"));
		
		plFrmDlgn0100.add(lcButtom);
		
	}
	
	//검색조건 및 근태생성
	private void createSearchForm() {  
		  
		sysComBass0150Dto = new PrgmComBass0150DTO();
	    sysComBass0300Dto = new PrgmComBass0300DTO();
	    sysComBass0400Dto = new PrgmComBass0400DTO();
	    sysComBass0500Dto = new PrgmComBass0500DTO();
	    msfCoCalendarDto  = new SysCoCalendarDTO();
	    sysComBass0350Dto = new PrgmComBass0350DTO();
	    sysComBass0320Dto = new PrgmComBass0320DTO();
	         
	    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	    lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	       
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	    //급여구분 
	    sysComBass0300Dto.setRpsttvCd("B015");
	    lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	        
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	    //고용구분
		sysComBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	    //복무기타구분코드
		sysComBass0300Dto.setRpsttvCd("N001");
		listStoreN001 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
	       
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		//년
		lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//월  
		lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		
		 //-------------------관리부서 추가  
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
         
		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
         
		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
                srhDeptCd.getInitStore().add(mDtalistDeptCd);
                  
                lscrDeptCd.add(lsDeptCd.getModels()); 
                mDtalistcrDeptCd = DlgnUtils.getDeptCdModelData(lscrDeptCd) ; 
                creDeptCd.getInitStore().add(mDtalistcrDeptCd);
			}
		});  
          
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});  
	             
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	     * 년도 콤보박스 처리  시작
	     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
	     */


		lscrPayrMangDeptCd = lsPayrMangDeptCd; 
		lscreMangeDeptCd = lsMangeDeptCd; 
		lscrPayCd = lsPayCd; 
		lscrEmymtDivCd = lsEmymtDivCd;   
	      
		plFrmDlgn0100.setLayout(new FlowLayout());
	        
	    srhSystemkey = new HiddenField<String>(); 
	    
	    creHanNm = new HiddenField<String>(); 
	    creSecResnNum =  new HiddenField<String>();
	    creResnRegnNum = new HiddenField<String>(); 
	    creSystemkey = new HiddenField<String>(); 
	          
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
	    
	    // fieldSet.setCheckboxToggle(false); 
	        
	    LayoutContainer lcSchLeft = new LayoutContainer();
	    // lcSchLeft.setStyleAttribute("paddingRight", "10px"); 
	     
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	        
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_8.setLayout(frmlytSch);
	        
	    srhPayYr = new ComboBox<BaseModel>();
	    srhPayYr.setName("srhPayYr");
	    srhPayYr.setForceSelection(true);
	 	srhPayYr.setMinChars(1);
	    srhPayYr.setDisplayField("yearDisp");
	    srhPayYr.setValueField("year");
	    srhPayYr.setTriggerAction(TriggerAction.ALL);
	   // srhPayYr.setEmptyText("--년도선택--");
	    srhPayYr.setSelectOnFocus(true); 
	    srhPayYr.setReadOnly(false);
	    srhPayYr.setEnabled(true); 
	    srhPayYr.setStore(lsPayYrStore);
	    srhPayYr.setFieldLabel("작업년월"); 
	    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	    	public void handleEvent(StoreEvent<BaseModel> be) {   
	    		EventType type = be.getType();
	    			if (type == Store.Add) { 
	    				/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	    				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	    				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			             * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
							++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	    					checkDlgn0100Auth("srhPayYr", lsPayYrStore); 
	    			}
	    		}
	    	});
	    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	    		BaseModel bmPayYr =  se.getSelectedItem(); 
	    			if (bmPayYr != null) {
	                   if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));
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
	                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
	                      // return;
	                   } 
	    			}       
	    		} 
	    	});   
	    	layoutContainer_8.add(srhPayYr, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.74));
	        layoutContainer_8.setBorders(false);
	        
	        LayoutContainer layoutContainer_9 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_9.setLayout(frmlytSch);
	        
	        /** column 지급년월 : Mnth */ 
	        srhPayMonth = new ComboBox<BaseModel>();
	        srhPayMonth.setName("srhPayMonth");
	        srhPayMonth.setForceSelection(true);
	        srhPayMonth.setMinChars(1);
	        srhPayMonth.setDisplayField("monthDisp");
	        srhPayMonth.setValueField("month");
	        srhPayMonth.setTriggerAction(TriggerAction.ALL);
	       // srhPayMonth.setEmptyText("--월선택--");
	        srhPayMonth.setSelectOnFocus(true); 
	        srhPayMonth.setReadOnly(false);
	        srhPayMonth.setEnabled(true); 
	        srhPayMonth.setStore(lsPayMonth);
	        srhPayMonth.setHideLabel(true);
	        srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	        	public void handleEvent(StoreEvent<BaseModel> be) {  
	        		checkDlgn0100Auth("srhPayMonth", lsPayMonth); 
	        	}
	        });
	        layoutContainer_9.add(srhPayMonth, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
	        layoutContainer_9.setBorders(false);
	        
	        LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
	        layoutContainer.setBorders(false); 
	        
	        LayoutContainer layoutContainer_111 = new LayoutContainer();
	      
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_111.setLayout(frmlytSch);
	        
	        srhEmymtDivCd =  new ComboBox<BaseModel>(); 
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
	        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	  						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	        				checkDlgn0100Auth("srhEmymtDivCd", lsEmymtDivCd ); 
	        		} 
	            }
	        });    
	        srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	        		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        		BaseModel bmPayCd =  se.getSelectedItem(); 
	        		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	        			srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
	        			srhBusinCd.setEnabled(true);
	        			srhTypOccuCd.reset();
	        			srhTypOccuCd.setEnabled(false);
	        			srhDtilOccuInttnCd.reset();
	        			srhDtilOccuInttnCd.setEnabled(false);
	        		} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
	        			//20151130 추가 수정 
	        			srhDeptCd.getListView().fireEvent(Events.CheckChanged);
		            	srhBusinCd.reset();
	                    srhBusinCd.setEnabled(false);   
	                    
	                    if (gwtExtAuth.getEnableTypOccuCd()) {
	                    	srhTypOccuCd.setEnabled(true);
	                    	srhDtilOccuInttnCd.setEnabled(true); 
	                    } else {
	                    	srhTypOccuCd.setEnabled(false);
	                    	srhDtilOccuInttnCd.setEnabled(false);
	                    }
	        		}  
	            } 
	        });
	        layoutContainer_111.add(srhEmymtDivCd, new FormData("100%"));
	        layoutContainer.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));	
	        
	        
		    LayoutContainer layoutContainer_101 = new LayoutContainer();
			layoutContainer_101.setBorders(false);

		    frmlytSch = new FormLayout();
		    frmlytSch.setDefaultWidth(0);
//		    frmlytSch.setLabelWidth(0); 
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
	        
	        
	        
//	        LayoutContainer layoutContainer = new LayoutContainer();
//	        layoutContainer.setBorders(false);
//	        
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(55); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//	        layoutContainer.setLayout(frmlytSch);
//	        
//	        /** column 단위기관 : payrMangDeptCd */
//	        srhPayrMangDeptCd = new ComboBox<BaseModel>();
//	        srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
//	        srhPayrMangDeptCd.setForceSelection(true);
//	        srhPayrMangDeptCd.setMinChars(1);
//	        srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
//	        srhPayrMangDeptCd.setValueField("payrMangDeptCd");
//	        srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
//	        srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
//	        srhPayrMangDeptCd.setSelectOnFocus(true); 
//	        srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//	        srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());  
//	        srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
//	        srhPayrMangDeptCd.setFieldLabel("단위기관"); 
//	        lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	        	public void handleEvent(StoreEvent<BaseModel> be) {  
//	        		EventType type = be.getType();
//	        		if (type == Store.Add) { 
//	        			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//	        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			 				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	        				checkDlgn0100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
//	        		}
//	            }
//	        });    
//	        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	        		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리  
//	        		srhDeptCd.reset();  //2015.12.07 추가 
//	        		sysComBass0400Dto.setDeptDspyYn("Y");
//	                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	                	public void handleEvent(StoreEvent<BaseModel> be) {  
//	                		mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
//	                		srhDeptCd.getInitStore().add(mDtalistDeptCd);
//	                	}
//	                });   
//	            } 
//	        });
//	        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
	        
	        
	        
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
	        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			 				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	        				checkDlgn0100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	        		}
	            }
	        });    
	        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	        		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리  
	        		sysComBass0400Dto = new PrgmComBass0400DTO(); 
	        		srhDeptCd.reset();  //2015.12.07 추가 
	        		sysComBass0400Dto.setDeptDspyYn("Y");
	                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
	  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
	                //--------------------부서 불러 오는 함수 ------------------------------------------------
	                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	                //--------------------부서 불러 오는 함수 ------------------------------------------------
	                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	                	public void handleEvent(StoreEvent<BaseModel> be) {  
	                		mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
	                		srhDeptCd.getInitStore().add(mDtalistDeptCd);
	                	}
	                });   
	            } 
	        });
	        layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%")); 
	        
	        
//	        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));			// 작업년월		 
//	        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	// 단위기관
//	        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 고용구분
//	        lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        
	        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 작업년월		 
	        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
	        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
	        
	        
	        
	        
	        LayoutContainer layoutContainer_13 = new LayoutContainer();
	        layoutContainer_13.setBorders(false);
	        layoutContainer_13.setLayout(new ColumnLayout());
	        
	    	//관리부서 
			LayoutContainer lcSch2_1 = new LayoutContainer();
			FormLayout frmlytSch2_1 = new FormLayout();
			frmlytSch2_1.setLabelWidth(60);
			frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
			lcSch2_1.setLayout(frmlytSch2_1);
			
			srhMangeDeptCd = new ComboBox<BaseModel>();
			srhMangeDeptCd.setName("srhMangeDeptCd"); 
			srhMangeDeptCd.setEmptyText("--관리부서선택--");
			srhMangeDeptCd.setDisplayField("deptNmRtchnt");
			srhMangeDeptCd.setStore(lsMangeDeptCd); 
			srhMangeDeptCd.setWidth(100);
			srhMangeDeptCd.setFieldLabel("관리부서");
			srhMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
	        srhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	        srhMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	            	EventType type = be.getType();
	            	if (type == Store.Add) { 
	            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	            		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
	            	}
	            }
	        });  
	        srhMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
		    		sysComBass0400Dto = new PrgmComBass0400DTO();
	  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
	  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
	  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	  	    		
	  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	  	    				mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
	  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	  	    			}
	  	    		});  
	  	    		emptyCheck = true;
		    	} 
		    });
	        srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) {    
	            	
	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
	                	
	                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
		                	sysComBass0400Dto = new PrgmComBass0400DTO();
		      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
		      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
		      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
		      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
		      	    		
		      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
		      	    				mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
		      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
		      	    			} 
		      	    			
		      	    		}); 
		      	    		emptyCheck = false;
	                	}
	                 }  
	            } 
	        });   
	       
	        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
	        
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
	        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			         	 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	        				checkDlgn0100Auth("srhDeptCd", lsDeptCd); 
	        		}
	        	}
	        });    

	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	        	@Override
	        	public void handleEvent(ComponentEvent ce) { 
	        		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	        			PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
	        			sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")); 
	        			List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
	        			sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
  		                  
	        			//--------------------사업 불러 오는 함수 -------------------------------------------------
	        			lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	        			//--------------------사업 불러 오는 함수 -------------------------------------------------
  		           		srhBusinCd.setStore(lsBusinCd); 
  		           		srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
  		           			public void handleEvent(StoreEvent<BaseModel> be) {  
  		           				//   searchBusinCd.setValue(lsBusinCd.getAt(0));  
  		           			}
  		           		});    
	        		} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	        			//2015.11.30 권한 직종가져오기  추가 
	        			sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        			String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		       	 		sysComBass0320Dto.setDeptCd(strDeptCd);
		       	 		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		       	 		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		       	 			public void handleEvent(StoreEvent<BaseModel> be) {  
		       	 				mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		       	 				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		       	 			}
		       	 		});  
	        		} else {
	        			sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	        			String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	        			sysComBass0320Dto.setDeptCd(strDeptCd);
	        			lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	        			lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	        				public void handleEvent(StoreEvent<BaseModel> be) {  
	        					mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	        					srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	        				}
	        			});   
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
	        
	        
	        //직종 직종세처리 
	        LayoutContainer lcTypOccuCd = new LayoutContainer();
	        lcTypOccuCd.setLayout(new ColumnLayout());
	        
	        
	        LayoutContainer layoutContainer_211 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
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
	        
	           
	        
	        LayoutContainer layoutContainer_21 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setDefaultWidth(0);
//	        frmlytSch.setLabelWidth(30); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_21.setLayout(frmlytSch);
	       
	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	        srhTypOccuCd.setName("srhTypOccuCd"); 
	        srhTypOccuCd.setEmptyText("--직종선택--"); 
	        srhTypOccuCd.setHideLabel(true);
	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	        srhTypOccuCd.setWidth(100);
	        srhTypOccuCd.setHideLabel(true);
//	        srhTypOccuCd.setFieldLabel("직종");
	        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	            public void handleEvent(StoreEvent<ModelData> be) {  
	            	
		    		  EventType type = be.getType();
		    		  if (type == Store.Add) { 
		    			  //2015.11.30 추가 
			    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
			    			   ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
			    			   srhTypOccuCd.getListView().setChecked(mdSelect, true); 
			    			   srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
			                    
			    		   }  
			    		   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
		    			  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    			   * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		    			   * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		    			   * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		         			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkDlgn0100Auth("srhTypOccuCd", lsTypOccuCd); 
		    		  }
	            }
	        });     
	        
	        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	        	@Override
	        	public void handleEvent(ComponentEvent ce) { 
	        		//2015.11.30 추가 
	        		displayDtilOccuInttnCd(); 
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
	        
	      //2015.11.30 추가 
	        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
	            @Override
	            public void handleEvent(BaseEvent ce) {   
	            	displayDtilOccuInttnCd();
	            } 
	        }); 
	        layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
	        
	        LayoutContainer lcSchRight = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(1); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        frmlytSch.setDefaultWidth(0);
	        lcSchRight.setLayout(frmlytSch);
	        
	        /** column 직종세코드 : dtilOccuInttnCd */ 
	        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
	        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
	        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
	        srhDtilOccuInttnCd.setWidth(100);
	        srhDtilOccuInttnCd.setHideLabel(true);
	        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
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
	        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
	        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
	        
	        layoutContainer_21.setBorders(false);
	        
	       // layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
	       // layoutContainer_10.setBorders(false);
	        
	      
	        
//	        layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
//	        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//	        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//	        layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        
	        layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 급여구분
	        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
	        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));			// 직종
	        
	        fieldSet.add(layoutContainer_13);
	        
	        
	        LayoutContainer lcSchCol3 = new LayoutContainer();
	        lcSchCol3.setLayout(new ColumnLayout());
	        LayoutContainer layoutContainer_1 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        layoutContainer_1.setLayout(frmlytSch);
	        
	        srhPayCd =  new ComboBox<BaseModel>(); 
	        srhPayCd.setName("srhPayCd");
	        srhPayCd.setForceSelection(true);
	        srhPayCd.setMinChars(1);
	        srhPayCd.setDisplayField("commCdNm");
	        srhPayCd.setValueField("commCd");
	        srhPayCd.setTriggerAction(TriggerAction.ALL);
	        srhPayCd.setEmptyText("--급여구분선택--");
	        srhPayCd.setSelectOnFocus(true); 
	        srhPayCd.setReadOnly(false);
	        srhPayCd.setEnabled(true); 
	        srhPayCd.setStore(lsPayCd);
	        srhPayCd.setFieldLabel("급여구분");
	        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	   EventType type = be.getType();
		    	   if (type == Store.Add) { 
             		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 
             		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
             		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		    			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   checkDlgn0100Auth("srhPayCd", lsPayCd); 
		    	   }
	            }
	        });    
	        
	        layoutContainer_1.add(srhPayCd, new FormData("100%"));
	        
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
	        layoutContainer_6.add(srhHanNm, new FormData("100%"));
 	        
	        srhHanNm.addKeyListener(new KeyListener() {
	        	public void componentKeyDown(ComponentEvent event) { 
	                srhHanNm.validate();
	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
	        			srhSystemkey.setValue("");
	        			srhResnRegnNum.setValue("");
	        		}
	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                	srhSystemkey.setValue("");
	                	srhResnRegnNum.setValue("");
						fnPopupPsnl0100("PSNL");
	                }
	                
	                super.componentKeyDown(event);
	            }
	         });
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	        	@Override
//	        	public void handleEvent(BaseEvent be) {  
//	        		if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	        			srhSystemkey.setValue("");
//	        			srhResnRegnNum.setValue("");
//	        		}
//             	} 
//	        }); 
	        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
	        layoutContainer_6.setBorders(false);
	        
	        
	        Button btnHanNm = new Button("검색");
	        layoutContainer_5.add(btnHanNm);
	        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	                srhSystemkey.setValue("");
	                srhResnRegnNum.setValue("");  
	                fnPopupPsnl0100("PSNL") ;
	            }
	        });
	        
	        
	        LayoutContainer layoutContainer_7 = new LayoutContainer();
	        frmlytSch = new FormLayout(); 
	        frmlytSch.setDefaultWidth(0);
//	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_7.setLayout(frmlytSch);
	        
	        /** column 주민등록번호 : resnRegnNum */
	        srhResnRegnNum = new TextField<String>();
	        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");  
	        srhResnRegnNum.setName("srhResnRegnNum");
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
	        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
	        layoutContainer_7.setBorders(false); 
	        layoutContainer_5.setBorders(false);  
 
	        
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
	        srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	        srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
	        srhBusinCd.setStore(lsBusinCd);
	        srhBusinCd.setFieldLabel("사업");
	        layoutContainer_4.add(srhBusinCd, new FormData("100%"));
	        layoutContainer_4.setBorders(false);
	        
	        
//	        LayoutContainer layoutContainer_16 = new LayoutContainer();
//	        
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(0); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_16.setLayout(frmlytSch);
	        
	        lcSchCol3.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 사업
	        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));			// 성명
	        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 
	        
	        fieldSet.add(lcSchCol3);
	        
	        plFrmDlgn0100.add(fieldSet); 
	}  

	
	//TODO 근태상세정보 시작

	private LayoutContainer occupationalRTop() {
		
		detailEmymtDivCd = new HiddenField<String>();
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
//		cp01.setSize(600, 120);
		//엣지변환
		//cp01.setSize(600, 70);
		cp01.setSize(600, 100);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());
		
		
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);
		detailName = new MSFTextField();
		detailName.setFieldLabel("성 명");
		detailName.setReadOnly(true);
		layoutContainer_6.add(detailName, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		detailRegnNum = new MSFTextField();
		detailRegnNum.setLabelSeparator("");
//			detailRegnNum.setFieldLabel("주민번호");
		detailRegnNum.setReadOnly(true);
		layoutContainer_7.add(detailRegnNum, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16));
		
			
			
		LayoutContainer lcDeptNm = new LayoutContainer();
			
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcDeptNm.setLayout(frmlytStd);
		
		detailDeptNm = new MSFTextField();
		detailDeptNm.setFieldLabel("부서명");
		detailDeptNm.setReadOnly(true);
		lcDeptNm.add(detailDeptNm, new FormData("100%"));
		
		layoutContainer_5.add(lcDeptNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
			
			
		LayoutContainer layoutContainer_89 = new LayoutContainer();
			
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_89.setLayout(frmlytStd);
		
		detailTypOccuNm = new MSFTextField();
		detailTypOccuNm.setFieldLabel("직종(사업)");
		detailTypOccuNm.setReadOnly(true);
		
		layoutContainer_89.add(detailTypOccuNm, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_89, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
			

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
		LabelField labelField = new LabelField();
		labelField.setFieldLabel("휴가 : ");
//		layoutContainer_8.add(labelField, new FormData("100%"));
//		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		lytCtr01.add(layoutContainer_5);
		
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);

		detailYm = new MSFTextField();
		detailYm.setFieldLabel("작업년월");
		detailYm.setReadOnly(true);
		layoutContainer_1.add(detailYm, new FormData("100%"));
		layoutContainer.add(layoutContainer_1);
		
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

			
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		detailWorkDayS = new MSFTextField();
		detailWorkDayS.setFieldLabel("근태기간");
		detailWorkDayS.setReadOnly(true);
     	layoutContainer_3.add(detailWorkDayS, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
			

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		detailWorkDayE= new MSFTextField();
		detailWorkDayE.setLabelSeparator("~");
		detailWorkDayE.setReadOnly(true);
		layoutContainer_4.add(detailWorkDayE, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));

		
		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);
		
		
		detailWeekHdayCnt = new MSFTextField();
		detailWeekHdayCnt.setFieldLabel("주휴일수");
		detailWeekHdayCnt.setReadOnly(false);
		detailWeekHdayCnt.addListener(Events.Change, new Listener<BaseEvent>() { 
	       	@Override
	       	public void handleEvent(BaseEvent be) {  
	       		if (!MSFSharedUtils.allowNulls(detailWeekHdayCnt.getValue()).trim().equals("")) {
	       			
	       		}
	       	} 
	 	}); 
		layoutContainer_10.add(detailWeekHdayCnt, new FormData("100%"));
		layoutContainer.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lytCtr01.add(layoutContainer);
		
		LayoutContainer layoutContainer_11 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		
		LabelField txt = new LabelField("");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_12.add(txt, new FormData("100%"));
		layoutContainer_11.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.05));
		
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);
		
		CheckBoxGroup chk = new CheckBoxGroup();
		chk.setFieldLabel("");
		chk.setHideLabel(true);
		
		final CheckBox dilnlazTfcAssCstYn = new CheckBox();
		dilnlazTfcAssCstYn.setBoxLabel("교통비");
		dilnlazTfcAssCstYn.setHideLabel(false);
		dilnlazTfcAssCstYn.setValueAttribute("Y");
		chk.add(dilnlazTfcAssCstYn);
		
		final CheckBox dilnlazLnchYn = new CheckBox();
		dilnlazLnchYn.setBoxLabel("급식비");
		dilnlazLnchYn.setHideLabel(false);
		dilnlazLnchYn.setValueAttribute("Y");
		chk.add(dilnlazLnchYn);
		
		final CheckBox dilnlazButpYn = new CheckBox();
		dilnlazButpYn.setBoxLabel("출장비");
		dilnlazButpYn.setHideLabel(false);
		dilnlazButpYn.setValueAttribute("Y");
		chk.add(dilnlazButpYn);
		
		layoutContainer_13.add(chk, new FormData("100%"));
		layoutContainer_11.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		
//		frmlytStd = new FormLayout();
//		layoutContainer_14.setLayout(frmlytStd);
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);
		btnBar.setBorders(false);
		
		Button btnSelectDlgnGrid = new Button("전체선택");
		btnSelectDlgnGrid.setAutoWidth(true);
		btnSelectDlgnGrid.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
            public void componentSelected(ButtonEvent ce) { 
            	
            	  int  lsCnt = Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getCount();
            	  
            	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
            		  
            		  if("0".equals(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getAt(iCnt).get("offdayKubn"))) {
            			  
	            			  if(dilnlazTfcAssCstYn.getValue()) {
	                			  // 레코드에 값을 담아준다.
	                			  Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getRecord(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getAt(iCnt)).set("dilnlazTfcAssCstYn", Boolean.TRUE);	// 교통비
	                		  }
	                		  
	                		  if(dilnlazLnchYn.getValue()) {
	                			  // 레코드에 값을 담아준다.
	                			  Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getRecord(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getAt(iCnt)).set("dilnlazLnchYn", Boolean.TRUE);		// 급식비 
	                		  }
	                		  
	                		  if(dilnlazButpYn.getValue()) {
	//                			  Dlgn0100Grid0110.getMsfGrid().getGrid().startEditing(iCnt, 13);
	                			  // 레코드에 값을 담아준다.
	                			  Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getRecord(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getAt(iCnt)).set("dilnlazButpYn", Boolean.TRUE);		// 출장비
	//                			  Dlgn0100Grid0110.getMsfGrid().getGrid().stopEditing();    
	            	          }
            		  	}
            	  } 
            	  
            	  Dlgn0100Grid0110.getMsfGrid().getGrid().getView().refresh(true);
            	  
		    }
        });
		btnBar.add(btnSelectDlgnGrid);
		
		
		
		Button btnNoSelectDlgnGrid = new Button("전체해제");
		btnNoSelectDlgnGrid.setAutoWidth(true);
		btnNoSelectDlgnGrid.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {

				int lsCnt = Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getCount();

				for (int iCnt = 0; iCnt < lsCnt; iCnt++) {
            		  
	      			  if(dilnlazTfcAssCstYn.getValue()) {
	        			  // 레코드에 값을 담아준다.
	        			  Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getRecord(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getAt(iCnt)).set("dilnlazTfcAssCstYn", Boolean.FALSE);	// 교통비
	        		  }
	        		  
	        		  if(dilnlazLnchYn.getValue()) {
	        			  // 레코드에 값을 담아준다.
	        			  Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getRecord(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getAt(iCnt)).set("dilnlazLnchYn", Boolean.FALSE);			// 급식비 
	        		  }
	        		  
	        		  if(dilnlazButpYn.getValue()) {
//	        			  Dlgn0100Grid0110.getMsfGrid().getGrid().startEditing(iCnt, 13);
	        			  // 레코드에 값을 담아준다.
	        			  Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getRecord(Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().getAt(iCnt)).set("dilnlazButpYn", Boolean.FALSE);			// 출장비
//	        			  Dlgn0100Grid0110.getMsfGrid().getGrid().stopEditing();    
	    	          }
					
	        		  Dlgn0100Grid0110.getMsfGrid().getGrid().getStore().commitChanges();
	        		  Dlgn0100Grid0110.getMsfGrid().getGrid().getView().refresh(true);
					
				} 
		    }
        });
		btnBar.add(btnNoSelectDlgnGrid);
		
		layoutContainer_14.add(btnBar);
		
		detailDtilOccuInttnNm = new MSFTextField();
		detailDtilOccuInttnNm.setLabelSeparator("");
		detailDtilOccuInttnNm.setWidth(0);
		detailDtilOccuInttnNm.setReadOnly(true);
		layoutContainer_14.add(detailDtilOccuInttnNm, new FormData("100%"));
		detailDtilOccuInttnNm.hide();

		detailBusinNm = new MSFTextField();
		detailBusinNm.setFieldLabel("사업명");
		detailBusinNm.setReadOnly(true);
		layoutContainer_14.add(detailBusinNm, new FormData("100%"));
		detailBusinNm.hide();
		
		detailEmymtBgnnDt = new MSFTextField();
		detailEmymtBgnnDt.setFieldLabel("시작일자");
		detailEmymtBgnnDt.setReadOnly(true);
		layoutContainer_14.add(detailEmymtBgnnDt, new FormData("100%"));
		detailEmymtBgnnDt.hide();
		
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytStd);

		detailEmymtEndDt = new MSFTextField();
		detailEmymtEndDt.setFieldLabel("종료일자");
		detailEmymtEndDt.setReadOnly(true);
		detailEmymtEndDt.hide();
		layoutContainer_14.add(detailEmymtEndDt, new FormData("100%"));
		
		layoutContainer_11.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		lytCtr01.add(layoutContainer_11);
		
		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	
	/*
	private LayoutContainer occupationalRTop() {

	    detailEmymtDivCd = new HiddenField<String>();
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
//		cp01.setSize(600, 120);
		cp01.setSize(600, 95);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);

		detailYm = new MSFTextField();
		detailYm.setFieldLabel("작업년월");
		detailYm.setReadOnly(true);
		layoutContainer_1.add(detailYm, new FormData("100%"));
		layoutContainer.add(layoutContainer_1);
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		detailWorkDayS = new MSFTextField();
		detailWorkDayS.setFieldLabel("근태기간");
		detailWorkDayS.setReadOnly(true);
		layoutContainer_3.add(detailWorkDayS, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		detailWorkDayE= new MSFTextField();
		detailWorkDayE.setLabelSeparator("~");
		detailWorkDayE.setReadOnly(true);
		layoutContainer_4.add(detailWorkDayE, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_4.setBorders(false);
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);

		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));

		lytCtr01.add(layoutContainer);
		layoutContainer.setBorders(false);

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		detailName = new MSFTextField();
		detailName.setFieldLabel("성 명");
		detailName.setReadOnly(true);
		layoutContainer_6.add(detailName, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		detailRegnNum = new MSFTextField();
		detailRegnNum.setFieldLabel("주민번호");
		detailRegnNum.setReadOnly(true);
		layoutContainer_7.add(detailRegnNum, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.325));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);

		LabelField labelField = new LabelField();
		labelField.setLabelSeparator(":");
		labelField.setFieldLabel("휴가");
		layoutContainer_8.add(labelField, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.325));
		layoutContainer_8.setBorders(false);
		lytCtr01.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		detailDeptNm = new MSFTextField();
		detailDeptNm.setFieldLabel("부서명");
		detailDeptNm.setReadOnly(true);
		layoutContainer_10.add(detailDeptNm, new FormData("100%"));
		layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_10.setBorders(false);
		
		
		LayoutContainer layoutContainer_24 = new LayoutContainer();
		layoutContainer_24.setLayout(new ColumnLayout());
		
		LayoutContainer lcTypOccuNm = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuNm.setLayout(frmlytStd);

		detailTypOccuNm = new MSFTextField();
		detailTypOccuNm.setFieldLabel("직종");
		detailTypOccuNm.setReadOnly(true);
		lcTypOccuNm.add(detailTypOccuNm, new FormData("100%"));
		layoutContainer_24.add(lcTypOccuNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		lcTypOccuNm.setBorders(false);
		
		LayoutContainer lcDtilOccuInttnNm = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcDtilOccuInttnNm.setLayout(frmlytStd);

		detailDtilOccuInttnNm = new MSFTextField();
		detailDtilOccuInttnNm.setLabelSeparator("");
		detailDtilOccuInttnNm.setWidth(0);
		detailDtilOccuInttnNm.setReadOnly(true);
		lcDtilOccuInttnNm.add(detailDtilOccuInttnNm, new FormData("100%"));
		layoutContainer_24.add(lcDtilOccuInttnNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcDtilOccuInttnNm.setBorders(false);
		
		layoutContainer_9.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.325));
		
		

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);

		detailBusinNm = new MSFTextField();
		detailBusinNm.setFieldLabel("사업명");
		detailBusinNm.setReadOnly(true);
		layoutContainer_11.add(detailBusinNm, new FormData("100%"));
		layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.325));
		layoutContainer_11.setBorders(false);
		lytCtr01.add(layoutContainer_9);
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);

		detailEmymtBgnnDt = new MSFTextField();
		detailEmymtBgnnDt.setFieldLabel("시작일자");
		detailEmymtBgnnDt.setReadOnly(true);
		layoutContainer_13.add(detailEmymtBgnnDt, new FormData("100%"));
		layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_13.setBorders(false);

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytStd);

		detailEmymtEndDt = new MSFTextField();
		detailEmymtEndDt.setFieldLabel("종료일자");
		detailEmymtEndDt.setReadOnly(true);
		layoutContainer_14.add(detailEmymtEndDt, new FormData("100%"));
		layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.325));
		
		//추가 주휴일수
		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytStd);

		detailWeekHdayCnt = new MSFTextField();
		detailWeekHdayCnt.setFieldLabel("주휴일수");
		detailWeekHdayCnt.setReadOnly(false);
		detailWeekHdayCnt.addListener(Events.Change, new Listener<BaseEvent>() { 
			
        	@Override
        	public void handleEvent(BaseEvent be) {  
//        		detailWeekHday = true;
        		if (!MSFSharedUtils.allowNulls(detailWeekHdayCnt.getValue()).trim().equals("")) {
        			
        			if(storeDlgn0110.getCount() > 0) {
        				dlgn0110Grid.getStore().getRecord(storeDlgn0110.getAt(0)).setDirty(true);
        				storeDlgn0110.getAt(0).setInptDilnlazWklyHldyNumDys(detailWeekHdayCnt.getValue()); //입력받은 휴일수
        			}
        		}
         	} 
        }); 
		
		layoutContainer_15.add(detailWeekHdayCnt, new FormData("100%"));
		layoutContainer_12.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.325));
		
		
		lytCtr01.add(layoutContainer_12);
		layoutContainer_12.setBorders(false);
		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	*/   
	
	private GridCellRenderer<BaseModel> cellRender = new GridCellRenderer<BaseModel>() {   // 기존것 보고 안에 수정
	        public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,  
	                final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
	        	 
//	             String val = (String) model.get(property);
//	             return "<div style=\"overflow: visible; white-space:normal !important;\">"+ val +" </div>";
	        	if("1".equals(model.get("offdayKubn"))){
					return "<span style='color:red'>" + model.get("dilnlazApptnDt") + "</span>";   
				}else if("2".equals(model.get("offdayKubn"))){
					return "<span style='color:blue'>" + model.get("dilnlazApptnDt") + "</span>";   
				}else{
					return model.get("dilnlazApptnDt");
				}
	             
	        }  
	    };
	//TODO 근무내역등록 그리드 시작
	private LayoutContainer occupationalRBottom() {
		
		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		lcStdGrid.setLayout(frmlytStd); 
		
		cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());      
		cpGrid.setSize(620, 290);
		
		cpGrid_1 = new ContentPanel();
		cpGrid_1.setBodyBorder(false); 
		cpGrid_1.setHeaderVisible(false);   
		cpGrid_1.setLayout(new FitLayout());      
		cpGrid_1.setSize(620, 290);

		//근무내역등록 기준일 후
		MSFCustomForm msfCustomForm = new MSFCustomForm(Dlgn0100Def, 0, 0, false, false, false);
	    msfCustomForm.setHeaderVisible(false);
		Dlgn0100Grid0110 = new MSFGridPanel(Dlgn0100Def, false, false, false, false, false);
		Dlgn0100Grid0110.setHeaderVisible(false);  
		Dlgn0100Grid0110.setBodyBorder(true);
		Dlgn0100Grid0110.setBorders(true);
		Dlgn0100Grid0110.setMSFFormPanel(msfCustomForm);
		Dlgn0100Grid0110.getBottomComponent().setVisible(false);
		GWTUtils.setGridCellRenderer(Dlgn0100Grid0110, "dilnlazApptnDt", cellRender); //content 는 컬럼명
		cpGrid.add(Dlgn0100Grid0110);
		
		final Grid dlgn0100Grid = Dlgn0100Grid0110.getMsfGrid().getGrid();
		dlgn0100Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					 if (Dlgn0100Grid0110.getCurrentlySelectedItem() != null) {
						 Dlgn0100Grid0110.getMSFFormPanel().bind(Dlgn0100Grid0110.getCurrentlySelectedItem());
		            	 setRecord(Dlgn0100Grid0110.getCurrentlySelectedItem());
					 }
				}
				
			});

		//근무내역등록 기준일 전
		MSFCustomForm msfCustomForm_1 = new MSFCustomForm(Dlgn0100_1Def, 0, 0, false, false, false);
		msfCustomForm_1.setHeaderVisible(false);
		Dlgn0100Grid0110_1 = new MSFGridPanel(Dlgn0100_1Def, false, false, false, false, false);
		Dlgn0100Grid0110_1.setHeaderVisible(false);  
		Dlgn0100Grid0110_1.setBodyBorder(true);
		Dlgn0100Grid0110_1.setBorders(true);
		Dlgn0100Grid0110_1.setMSFFormPanel(msfCustomForm_1);
		Dlgn0100Grid0110_1.getBottomComponent().setVisible(false);
		GWTUtils.setGridCellRenderer(Dlgn0100Grid0110_1, "dilnlazApptnDt", cellRender); //content 는 컬럼명
		cpGrid_1.add(Dlgn0100Grid0110_1);
		
		final Grid dlgn0100Grid1 = Dlgn0100Grid0110_1.getMsfGrid().getGrid();
		dlgn0100Grid1.addListener(Events.RowClick, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					 if (Dlgn0100Grid0110_1.getCurrentlySelectedItem() != null) {
						 Dlgn0100Grid0110_1.getMSFFormPanel().bind(Dlgn0100Grid0110_1.getCurrentlySelectedItem());
		            	 setRecord(Dlgn0100Grid0110_1.getCurrentlySelectedItem());
					 }
				}
				
			});
		
		lcStdGrid.add(cpGrid);
		lcStdGrid.add(cpGrid_1);
		return lcStdGrid;
		
	}
	
	public void setRecord(BaseModel record) {
		this.record = record;
	}
//	private LayoutContainer occupationalRBottom() {
//
//		LayoutContainer lcTabFormLayer = new LayoutContainer();
//		RowNumberer r = new RowNumberer();
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		//final CheckBoxSelectionModel<Dlgn0100DTO> sm = new CheckBoxSelectionModel<Dlgn0100DTO>();
//		//configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("dilnlazApptnDt");
//		column.setHeaderText("근태일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(75);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		column.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
//
//			@Override
//			public Object render(Dlgn0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
//				if("1".equals(model.getOffdayKubn())){
//					return "<span style='color:red'>" + model.getDilnlazApptnDt() + "</span>";   
//				}else if("2".equals(model.getOffdayKubn())){
//					return "<span style='color:blue'>" + model.getDilnlazApptnDt() + "</span>";   
//				}else{
//					return model.getDilnlazApptnDt();
//				}
//				
//			}
//		});
//		configs.add(column);
//
//	    column = new ColumnConfig();
//		column.setId("dilnlazDutyTm");
//		column.setHeaderText("시간(분)");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(60);
//		column.setEditor(new CellEditor(new TextField<String>()));
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		/*column.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
//
//			@Override
//			public Object render(Dlgn0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
//				int val = 0;
//				try{
//					val = Integer.parseInt(String.valueOf(model.get(property))); 
//				}catch(Exception e){
//					val = 0;
//				}
//				return val;
//			}
//		});*/
//		configs.add(column);
//		  final CheckBox cb02 = new CheckBox();  
//		    CellEditor cb02Editor = new CellEditor(cb02){  
//		        @Override  
//		        public Object preProcessValue(Object value) {   
//		            return value;   
//		        }  	    
//		        @Override  
//		        public Object postProcessValue(Object value) {    
//		        	 if (value == null) { 
//		        		return value;  
//		        	 }  
//		        	 return value;  
//		        }  
//		    };
//		    
////		CheckColumnConfig checkColumn = new CheckColumnConfig("dilnlazHodyYnboolean", "휴일", 40);
//		checkColumn = new CheckColumnConfig("dilnlazDutyYnBoolean", "근무", 40); 
//		checkColumn.setAlignment(HorizontalAlignment.CENTER); 
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(cb02Editor);
//		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
//			@Override
//			public Object render(Dlgn0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
//					//checkBox값 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazHodyYnboolean"); 
// 					boolean checkBoxValue = (Boolean)model.get("dilnlazDutyYnBoolean"); 
//					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
//					
//					if("1".equals(model.getOffdayKubn())){
//						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
//						store.getRecord(store.getAt(rowIndex)).cancelEdit();
//					}else if("2".equals(model.getOffdayKubn())){
//						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
//						store.getRecord(store.getAt(rowIndex)).cancelEdit();
//					}else {
//						if(checkBoxValue){  
//							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
//						}  
//						store.getRecord(store.getAt(rowIndex));
//					} 
//				return rtnValue;
//			}
//		});
//		configs.add(checkColumn);
//
//
//		// 콤보로처리 결근/결근인정/무단결근
//	    final CheckBox cb01 = new CheckBox();  
//	    CellEditor cb01Editor = new CellEditor(cb01){  
//	        @Override  
//	        public Object preProcessValue(Object value) {   
//	            return value;   
//	        }  	    
//	        @Override  
//	        public Object postProcessValue(Object value) {    
//	        	 if (value == null) { 
//	        		return value;  
//	        	 }  
//	        	 return value;  
//	        }  
//	    };
//	    checkColumn = new CheckColumnConfig("dilnlazAbnceYnboolean", "결근", 40);
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false); 
//		checkColumn.setEditor(cb01Editor);   
////		checkColumn.setRenderer(new GridCellRenderer<BaseModelData>() {
////			//-------------------------
////						@Override
////						public Object render(final BaseModelData model, String property,
////								final ColumnData config, final int rowIndex, final int colIndex,
////								final ListStore<BaseModelData> store,  final Grid<BaseModelData> grid) { 
////							 
////							
////							//checkBox값 
////							boolean checkBoxValue = (Boolean)model.get("dilnlazAbnceYnboolean"); 
////
////							//반환값 
////						    String rtnValue = ""; 
//// 
////							//체크되지 않은 체크 박스를 표시 - checkBox 
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////		 			    
////							if(checkBoxValue){  
////								//체크 박스를 표시 - checkBox 
////								rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>"; 
////							} 
////							
////						    cb01.addListener(Events.Change, new Listener<FieldEvent>() {
////				                @Override
////				                public void handleEvent(FieldEvent be) {
////				                    //////////
////				                boolean checked = ((CheckBox) be.getSource()).getValue();
////							    if(checked) {
////							    	store.getRecord(store.getAt(rowIndex)).set("dilnlazDutyTm", "0");
////									 
////								} else {
////									store.getRecord(store.getAt(rowIndex)).set("dilnlazDutyTm", "8");
////									 
////								} 
////							  
////							    store.getRecord(store.getAt(rowIndex)).set("dilnlazAbnceYnboolean", checked);
////	                           // store.update(store.getAt(rowIndex));
////	                           // store.getRecord(store.getAt(rowIndex)).setDirty(true);  
////	                           // grid.getView().refresh(true);    
////							 
////	
////				                }
////				            });  
////							
////							return rtnValue; 
////	 	   
////						}
////						
////					}); 
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//결근여부 checkBox값 
////					boolean checkBoxValue = (Boolean)model.get("dilnlazAbnceYnboolean");	 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						
////					   rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////					   store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					   
////					}else if("2".equals(model.getOffdayKubn())){
////						
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";   
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
//		configs.add(checkColumn);
//
////		checkColumn = new CheckColumnConfig("dilnlazAbnceDutyRcgtnYnboolean", "인정(결)", 55);
////		checkColumn.setAlignment(HorizontalAlignment.CENTER);
////		checkColumn.setMenuDisabled(true);
////		checkColumn.setSortable(false);
////		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		configs.add(checkColumn);
//		
//		checkColumn = new CheckColumnConfig("dilnlazLvsgYnboolean", "연차", 40);
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazLvsgYnboolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
//		configs.add(checkColumn);
//		
//		checkColumn = new CheckColumnConfig("dilnlazSpclHodyYnboolean", "특(휴)", 40);
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazSpclHodyYnboolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
//		configs.add(checkColumn);
//		
//		checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dilnlazSckleaYnboolean");
//		checkColumn.setHeaderText("병가");
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setWidth(40);
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazSckleaYnboolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
//		configs.add(checkColumn);
//
//		checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dilnlazOffvaYnboolean");
//		checkColumn.setHeaderText("공가");
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setWidth(40);
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazOffvaYnboolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
//		configs.add(checkColumn);
//
//		checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dilnlazFmlyEvntYnboolean");
//		checkColumn.setHeaderText("경조사");
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setWidth(50);
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazFmlyEvntYnboolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
//		configs.add(checkColumn);
//
//		checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dilnlazHlthCreYnboolean");
//		checkColumn.setHeaderText("보건");
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setWidth(40);
//		checkColumn.setMenuDisabled(true);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazHlthCreYnboolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
//		configs.add(checkColumn);
//		 		
//		checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dilnlazTfcAssCstYnBoolean");
//		checkColumn.setHeaderText("교통비");
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setWidth(50);
//		checkColumn.setMenuDisabled(false);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazTfcAssCstYnBoolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		});
////		configs.add(checkColumn);
//					
//		checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dilnlazLnchYnBoolean");
//		checkColumn.setHeaderText("급식비");
//		checkColumn.setAlignment(HorizontalAlignment.CENTER);
//		checkColumn.setWidth(50);
//		checkColumn.setMenuDisabled(false);
//		checkColumn.setSortable(false);
//		checkColumn.setEditor(new CellEditor(new CheckBox()));
////		checkColumn.setRenderer(new GridCellRenderer<Dlgn0100DTO>() {
////			@Override
////			public Object render(Dlgn0100DTO model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<Dlgn0100DTO> store, Grid<Dlgn0100DTO> grid) {
////					//checkBox값 
//// 
//// 					boolean checkBoxValue = (Boolean)model.get("dilnlazLnchYnBoolean"); 
////					String rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox'>&#160;</div>"; 
////					
////					if("1".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						rtnValue = "<div class='x-grid3-check-col x-grid3-check-col x-grid3-cc-checkBox x-grid3-check-col-disabled'>&#160;</div>";  
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						if(checkBoxValue){  
////							rtnValue = "<div class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-checkBox'>&#160;</div>";
////						}  
////						store.getRecord(store.getAt(rowIndex));
////					} 
////				return rtnValue;
////			}
////		 });
////		configs.add(checkColumn);
//		 
//		
//		dilnlazEtcDivCdCombo = new ComboBox<BaseModel>();  
//		dilnlazEtcDivCdCombo.setForceSelection(true);
//		dilnlazEtcDivCdCombo.setMinChars(1);
//		dilnlazEtcDivCdCombo.setDisplayField("commCdNm");
//		dilnlazEtcDivCdCombo.setValueField("commCd");
//		dilnlazEtcDivCdCombo.setForceSelection(true);  
//		dilnlazEtcDivCdCombo.setTriggerAction(TriggerAction.ALL);
//		dilnlazEtcDivCdCombo.setStore(listStoreN001);
//	    final CellEditor dilnlazEtcDivCdEditor = new CellEditor(dilnlazEtcDivCdCombo){  
//	    	@Override  
//	        public Object preProcessValue(Object value) {  
//	        	
//	        	//보건 checkBox값 
//				boolean dilnlazHlthCreYnboolean = dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazHlthCreYnboolean() == false ? false : dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazHlthCreYnboolean();
//				
//				//결근여부 checkBox값 
//				boolean dilnlazAbnceYnboolean = dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazAbnceYnboolean() == false ? false : dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazAbnceYnboolean();
//	        	
//				//결근
//				if(dilnlazAbnceYnboolean && !dilnlazHlthCreYnboolean){
//					
//					// ------------  초기화  ------------  
//					dilnlazEtcDivCdCombo.setStore(new ListStore<BaseModel>());
//					dilnlazEtcDivCdCombo.setValue(new BaseModel());
//					tempListStore.removeAll();
//					listStoreN001.removeAll();
//					// ------------  초기화  ------------  
//							
//					//체크하면 결근과 관련된 내용만 넣기위한 템프 스토어리스트
//					tempListStore = new ListStore<BaseModel>();
//							
//					//--------------------복무 불러 오는 함수 -------------------------------------------------
//					sysComBass0300Dto = new PrgmComBass0300DTO();
//					sysComBass0300Dto.setRpsttvCd("N001");
//					sysComBass0300Dto.setMangeItem01("Y");
//					tempListStore = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); // 복무
//					sysComBass0300Dto.setMangeItem01("");
//					//--------------------복무 불러 오는 함수 -------------------------------------------------
//					dilnlazEtcDivCdCombo.setStore(tempListStore);
//					
//				//보건	
//				}else if(dilnlazHlthCreYnboolean && !dilnlazAbnceYnboolean) {
//					
//					// ------------  초기화  ------------  
//					dilnlazEtcDivCdCombo.setStore(new ListStore<BaseModel>());
//					dilnlazEtcDivCdCombo.setValue(new BaseModel());
//					tempListStore.removeAll();
//					listStoreN001.removeAll();
//					// ------------  초기화  ------------  
//					
//					
//					//체크하면 결근과 관련된 내용만 넣기위한 템프 스토어리스트
//					tempListStore = new ListStore<BaseModel>();
//					//--------------------복무 불러 오는 함수 -------------------------------------------------
//					sysComBass0300Dto = new PrgmComBass0300DTO();
//					sysComBass0300Dto.setRpsttvCd("N001");
//					sysComBass0300Dto.setMangeItem02("Y");
//					tempListStore = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); // 복무
//					sysComBass0300Dto.setMangeItem02("");
//					//--------------------복무 불러 오는 함수 -------------------------------------------------
//					dilnlazEtcDivCdCombo.setStore(tempListStore);
//					
//				}else if(!dilnlazHlthCreYnboolean && !dilnlazAbnceYnboolean){
//					
//					// ------------  초기화  ------------  
//					dilnlazEtcDivCdCombo.setStore(new ListStore<BaseModel>());
//					dilnlazEtcDivCdCombo.setValue(new BaseModel());
//					tempListStore.removeAll();
//					listStoreN001.removeAll();
//					// ------------  초기화  ------------  
//					
//					
//					listStoreN001 = new ListStore<BaseModel>();
//					//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//				    //복무기타구분코드
//					sysComBass0300Dto.setRpsttvCd("N001");
//					listStoreN001 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
//					//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//					dilnlazEtcDivCdCombo.setStore(listStoreN001);
//					
//				}
//				
//			if(dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazEtcDivCd() != null) {
//				value = dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazEtcDivCd();
//			}	
//	        	
//			if (value == null) {
//
//				return value;
//
//			}
//				return dilnlazEtcDivCdCombo.getStore().findModel(DlgnUtils.getBaseModelComboDataCd(dilnlazEtcDivCdCombo, String.valueOf(value)));   
//	        }  
//	    
//	    	
//	        @Override  
//	        public Object postProcessValue(Object value) { 
//	        	
//	        	if(dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazEtcDivCd() != null) {
//	        		value = dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazEtcDivCd();
//	        	}
//	        	
//	        	if (value == null) { 
//	        		
//	        	  return value; 
//	        	  
//	        	}
//	        	
////	        	return ((BaseModel) value).get("commCd");
//	        	return dlgn0110Grid.getSelectionModel().getSelectedItem().getDilnlazEtcDivCd();
//	        }  
//	    };
//	    
//	    dilnlazEtcDivCdColumn = new ColumnConfig();
//	    dilnlazEtcDivCdColumn.setId("dilnlazEtcDivCd");
//	    dilnlazEtcDivCdColumn.setHeaderText("기타");
//	    dilnlazEtcDivCdColumn.setAlignment(HorizontalAlignment.CENTER);
//	    dilnlazEtcDivCdColumn.setWidth(100);
//	    dilnlazEtcDivCdColumn.setEditor(dilnlazEtcDivCdEditor);
//	    dilnlazEtcDivCdColumn.setSortable(false);
//	    dilnlazEtcDivCdColumn.setMenuDisabled(true);
//	    dilnlazEtcDivCdColumn.setRenderer(new GridCellRenderer<BaseModelData>() {
//
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				 
//							 
//					 
//				if(dilnlazEtcDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dilnlazEtcDivCd"))!= null){
//					
////					if("1".equals(model.getOffdayKubn())){
////						 
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						 
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						 
////						store.getRecord(store.getAt(rowIndex));
////					}  
//					
//					return dilnlazEtcDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dilnlazEtcDivCd")).get("commCdNm");
//				
//				}else{
//					
////					if("1".equals(model.getOffdayKubn())){
////						 
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else if("2".equals(model.getOffdayKubn())){
////						 
////						store.getRecord(store.getAt(rowIndex)).cancelEdit();
////					}else {
////						 
////						store.getRecord(store.getAt(rowIndex));
////					} 
//					
//					return "";
//				
//				}
//			}
//		});
//		configs.add(dilnlazEtcDivCdColumn);
//		
//
//
//		/*column = new ColumnConfig();
//		column.setId("symbol");
//		column.setHeaderText("시간외");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(40);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("symbol");
//		column.setHeaderText("근무시간");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(50);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("symbol");
//		column.setHeaderText("교통");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(30);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("symbol");
//		column.setHeaderText("야근");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(30);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("symbol");
//		column.setHeaderText("야근시간");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(50);
//		configs.add(column);*/
//
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		ContentPanel cp01 = new ContentPanel();
//		cp01.setBodyBorder(false);
//		cp01.setHeaderVisible(false);
//		cp01.setLayout(new FitLayout());
//		cp01.setSize(610, 255);
//		
//		dlgn0110Grid = new EditorGrid<Dlgn0100DTO>(storeDlgn0110, cm);
//		dlgn0110Grid.setStateful(false);
//		//dlgn0110Grid.setSelectionModel(sm);
//		dlgn0110Grid.setBorders(true);
//		//dlgn0110Grid.setColumnReordering(true);
//		dlgn0110Grid.setLoadMask(true); 
//		dlgn0110Grid.addPlugin(checkColumn); 
//		dlgn0110Grid.setStripeRows(true);
//		//dlgn0110Grid.setAutoExpandColumn("dilnlazApptnDt");
//		 
//		
//		// 1 : 토요일, 일요일 2 : 휴일관리 휴일
//		dlgn0110Grid.addListener(Events.BeforeEdit, new Listener<GridEvent<Dlgn0100DTO>>() {
//			@Override
//			public void handleEvent(GridEvent<Dlgn0100DTO> be) {
//		
//				   if("1".equals(be.getModel().getOffdayKubn())){		
//					   be.getGrid().getColumnModel().getColumn(4).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(4).getEditor().disable(); 
//					   be.getGrid().getColumnModel().getColumn(5).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(5).getEditor().disable(); 
//					   be.getGrid().getColumnModel().getColumn(6).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(6).getEditor().disable(); 
//					   be.getGrid().getColumnModel().getColumn(7).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(7).getEditor().disable(); 
//					   be.getGrid().getColumnModel().getColumn(8).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(8).getEditor().disable(); 
//					   be.getGrid().getColumnModel().getColumn(9).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(9).getEditor().disable(); 
//					   be.getGrid().getColumnModel().getColumn(10).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(10).getEditor().disable(); 
//					 //  be.getGrid().getColumnModel().getColumn(11).getEditor().cancelEdit();
//					 //  be.getGrid().getColumnModel().getColumn(11).getEditor().disable(); 
//					   
//					   be.getGrid().getColumnModel().getColumn(3).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(3).getEditor().disable(); 
//					   
//					   
//					}else if("2".equals(be.getModel().getOffdayKubn())){
//						be.getGrid().getColumnModel().getColumn(4).getEditor().cancelEdit();
//					    be.getGrid().getColumnModel().getColumn(4).getEditor().disable(); 
//					    be.getGrid().getColumnModel().getColumn(5).getEditor().cancelEdit();
//						   be.getGrid().getColumnModel().getColumn(5).getEditor().disable(); 
//						   be.getGrid().getColumnModel().getColumn(6).getEditor().cancelEdit();
//						   be.getGrid().getColumnModel().getColumn(6).getEditor().disable(); 
//						   be.getGrid().getColumnModel().getColumn(7).getEditor().cancelEdit();
//						   be.getGrid().getColumnModel().getColumn(7).getEditor().disable(); 
//						   be.getGrid().getColumnModel().getColumn(8).getEditor().cancelEdit();
//						   be.getGrid().getColumnModel().getColumn(8).getEditor().disable(); 
//						   be.getGrid().getColumnModel().getColumn(9).getEditor().cancelEdit();
//						   be.getGrid().getColumnModel().getColumn(9).getEditor().disable(); 
//						   be.getGrid().getColumnModel().getColumn(10).getEditor().cancelEdit();
//						   be.getGrid().getColumnModel().getColumn(10).getEditor().disable(); 
//						 //  be.getGrid().getColumnModel().getColumn(11).getEditor().cancelEdit();
//						 //  be.getGrid().getColumnModel().getColumn(11).getEditor().disable();
//						   
//						   be.getGrid().getColumnModel().getColumn(3).getEditor().cancelEdit();
//						   be.getGrid().getColumnModel().getColumn(3).getEditor().disable(); 
//					} else {   
//					  
//						be.getGrid().getColumnModel().getColumn(3).getEditor().cancelEdit();
//					   be.getGrid().getColumnModel().getColumn(3).getEditor().disable(); 
//						   
//					   be.getGrid().getColumnModel().getColumn(4).getEditor().enable(); 
//					   be.getGrid().getColumnModel().getColumn(5).getEditor().enable(); 
//					   be.getGrid().getColumnModel().getColumn(6).getEditor().enable(); 
//					   be.getGrid().getColumnModel().getColumn(7).getEditor().enable(); 
//					   be.getGrid().getColumnModel().getColumn(8).getEditor().enable(); 
//					   be.getGrid().getColumnModel().getColumn(9).getEditor().enable(); 
//					   be.getGrid().getColumnModel().getColumn(10).getEditor().enable(); 
//					 //  be.getGrid().getColumnModel().getColumn(11).getEditor().enable();
//					   
//					   be.getGrid().getColumnModel().getColumn(3).getEditor().enable(); 
//					}  
//			}	 
//		});
//		//TODO 공무직 기간제 처리 분리해야함. 
//		dlgn0110Grid.addListener(Events.AfterEdit, new Listener<GridEvent<Dlgn0100DTO>>() {
//			@Override
//			public void handleEvent(GridEvent<Dlgn0100DTO> be) {
//		
//				if(be.getColIndex() == 2){ //근무시간 수정시
//					String val = be.getGrid().getStore().getAt(be.getRowIndex()).getDilnlazDutyTm();
//					double changVal = 0;
//					try{
//						
//						changVal = Double.parseDouble(val);  //val.setRegEx("^[+-]?\\d*(\\.?\\d*)$");
////						 if("1".equals(be.getModel().getOffdayKubn())){		
////							 changVal = 0;
////						 }else if("2".equals(be.getModel().getOffdayKubn())){
////							 changVal = 0;
////						 } 
//					}catch(Exception e){
//						changVal = 0;
//					}
//					  
//					be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm",changVal); 
//				} else if(be.getColIndex() == 3 ){
//					 //휴일근무 
//					//boolean checked = false;
//					//결근
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazAbnceYnboolean()) checked = true;
//					//인정(결)
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazAbnceDutyRcgtnYnboolean()) checked = true;
//					//휴가
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazLvsgYnboolean()) checked = true;
//					//특(휴)
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazSpclHodyYnboolean()) checked = true;
//					//병가
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazSckleaYnboolean()) checked = true;
//					
////					   if("1".equals(be.getModel().getOffdayKubn()) || "2".equals(be.getModel().getOffdayKubn())){		
////						   
//////							if(be.getModel().getDilnlazHodyYnboolean()){
////							if(be.getModel().getDilnlazDutyYnBoolean()){	
////								be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
////								
////							}else {
////								
////								be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
////								 
////							}
////						}else {  
////						
////						}  
//					
//					 
//				} else if(be.getColIndex() == 4 ){
//					 //결근
//					//boolean checked = false;
//					//결근
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazAbnceYnboolean()) checked = true;
//					//인정(결)
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazAbnceDutyRcgtnYnboolean()) checked = true;
//					//휴가
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazLvsgYnboolean()) checked = true;
//					//특(휴)
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazSpclHodyYnboolean()) checked = true;
//					//병가
//					//if(be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazSckleaYnboolean()) checked = true;
//					
//					//   if("1".equals(be.getModel().getOffdayKubn()) || "2".equals(be.getModel().getOffdayKubn())){		
//						   
//						  // be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//						   
//				//		}else {  
//							if(be.getModel().getDilnlazAbnceYnboolean()){ 
//								 
//								be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//								
//							}else {
//								
//								be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
//								 
//							}
//					//	}  
//					//
//					
//					 
//					/*
//					if(be.getColIndex() == 4 && be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazAbnceDutyRcgtnYnboolean()){
//						be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).setDilnlazDutyTm("0");
//					}
//					if(be.getColIndex() == 5 && be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazLvsgYnboolean()){
//						be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).setDilnlazDutyTm("0");
//					}					
//					if(be.getColIndex() == 6 && be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazSpclHodyYnboolean()){
//						be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).setDilnlazDutyTm("0");
//					}
//					if(be.getColIndex() == 7 && be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).getDilnlazSckleaYnboolean()){
//						be.getGrid().getStore().getAt(dlgn0110Grid.getStore().indexOf(dlgn0110Grid.getSelectionModel().getSelectedItem())).setDilnlazDutyTm("0");
//					}
//					*/
////				} else if( be.getColIndex() == 5){ 
////					 /*
////					  * 결근이 true 가 아닌경우 처리 안함. 체크하여도 미체크로 전환 함.
////					  */
////					//인정(결근) 
////					
////					if(be.getModel().getDilnlazAbnceYnboolean()) {
////						if(be.getModel().getDilnlazAbnceDutyRcgtnYnboolean()){ 
////							 
////							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
////							
////						}else {
////							
////							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
////							 
////						}
////					} else {
////						if(be.getModel().getDilnlazAbnceDutyRcgtnYnboolean()){ 
////					      MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
////	                               "결근이 아닌경우 체크 하실 수 없습니다.", null);
////					      be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazAbnceDutyRcgtnYnboolean",false);
////						} 
////					}
////						
//				} else if( be.getColIndex() == 5){
//					 //휴가
//					 /**
//					  * TODO 휴가 체크 되어 있으나 근무시간이 0보다 큰경우 수정하지 않음 
//					  */
//					if(be.getModel().getDilnlazLvsgYnboolean() && (Integer.parseInt(be.getModel().getDilnlazDutyTm()) < 8)){ 
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//					} else {
//						if(be.getModel().getDilnlazLvsgYnboolean()){ 
//							 
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//							
//						}else {
//							
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
//							 
//						}
//					}
//				} else if( be.getColIndex() == 6){
//				 
//					 //특(휴)
//					if(be.getModel().getDilnlazLvsgYnboolean() && (Integer.parseInt(be.getModel().getDilnlazDutyTm()) < 8)){ 
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//					} else { 
//					if(be.getModel().getDilnlazSpclHodyYnboolean()){ 
//						 
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//						
//					}else {
//						
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
//						 
//					}
//					}
//					
//				} else if( be.getColIndex() == 7){
//					boolean checked = false;
//					 //TODO  인사규정에 의한 적용처리 공무직 및 기간제 다름 병가 - 합계적용시 처리 하는 부분임. 
//					if(be.getModel().getDilnlazLvsgYnboolean() && (Integer.parseInt(be.getModel().getDilnlazDutyTm()) < 8)){ 
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//					} else {	 	
//						if(be.getModel().getDilnlazSckleaYnboolean()){ 
//							 
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//							
//						}else {
//							
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
//							 
//						}
//					}
//				} else if( be.getColIndex() == 8){
//					boolean checked = false;
//					 //공가 
//					if(be.getModel().getDilnlazLvsgYnboolean() && (Integer.parseInt(be.getModel().getDilnlazDutyTm()) < 8)){ 
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//					} else {	 	
//						if(be.getModel().getDilnlazOffvaYnboolean()){ 
//							 
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//							
//						}else {
//							
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
//							 
//						}
//					}
//				} else if( be.getColIndex() == 9){
//					boolean checked = false;
//					 // 경조사 
//					if(be.getModel().getDilnlazLvsgYnboolean() && (Integer.parseInt(be.getModel().getDilnlazDutyTm()) < 8)){ 
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//					} else { 	
//						if(be.getModel().getDilnlazFmlyEvntYnboolean()){ 
//							 
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//							
//						}else {
//							
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
//							 
//						}
//					}
//				} else if( be.getColIndex() == 10){
//					boolean checked = false;
//					 //보건  
//					if(be.getModel().getDilnlazLvsgYnboolean() && (Integer.parseInt(be.getModel().getDilnlazDutyTm()) < 8)){ 
//						be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//					} else { 	
//						if(be.getModel().getDilnlazHlthCreYnboolean()){ 
//							 
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","0");
//							
//						}else {
//							
//							be.getGrid().getStore().getRecord(be.getModel()).set("dilnlazDutyTm","8");
//							 
//						}
//					}
//				}
//			}
//		});
//		
//		cp01.add(dlgn0110Grid);
//
//		lcTabFormLayer.add(cp01);
//
//		return lcTabFormLayer;
//	}
	
	//TODO 근태관리대상자정보 그리드 시작
	private LayoutContainer occupationalLeft() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Dlgn0100DTO> sm = new CheckBoxSelectionModel<Dlgn0100DTO>();

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("hanNm");
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setMenuDisabled(true);
		column.setSortable(false);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("resnRegnNum");
		column.setHeaderText("주민번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(95);
		column.setMenuDisabled(true);
		column.setSortable(false);
		configs.add(column);

	 
		column = new ColumnConfig();
		column.setId("deptCdNm");
		column.setHeaderText("부서명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setMenuDisabled(true);
		column.setSortable(false);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("businCdNm");
		column.setHeaderText("사업명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setMenuDisabled(true);
		column.setSortable(false);
		configs.add(column);
		
		DateField emymtBgnnDtField = new DateField();
		 
		emymtBgnnDtField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		new DateFieldMask(emymtBgnnDtField, "9999.99.99"); 
		
		column = new ColumnConfig();
		column.setId("emymtBgnnDt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(emymtBgnnDtField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);
	    
	    
	    DateField emymtEndDtField = new DateField();
		 
	    emymtEndDtField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		new DateFieldMask(emymtEndDtField, "9999.99.99"); 

	    
	    new DateFieldMask(emymtEndDtField, "9999.99.99"); 
	    column = new ColumnConfig();
		column.setId("emymtEndDt");
		column.setHeaderText("종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(emymtEndDtField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);

		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
//		cp01.setSize(320, 410);
//		cp01.setSize(320, 380);
		//엣지변환
		//cp01.setSize(320, 380);
		cp01.setSize(320, 410);

		dlgn0100Grid = new Grid<Dlgn0100DTO>(storeDlgn0100, cm);
		dlgn0100Grid.setStateful(true);
		dlgn0100Grid.setSelectionModel(sm);
		dlgn0100Grid.setBorders(true);
		dlgn0100Grid.setColumnReordering(true);
		dlgn0100Grid.setLoadMask(true);
		dlgn0100Grid.addPlugin(sm);
		dlgn0100Grid.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<Dlgn0100DTO>() {
			
			@Override
			public void selectionChanged(final SelectionChangedEvent<Dlgn0100DTO> se) {
				if(se.getSelection().size() > 0){
					
					dpobCdStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getDpobCd()));					//사업장코드
					payCdStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getPayCd()));						//급여구분코드
					systemkeyStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getSystemkey()));				//시스템키	
					deptCdStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getDeptCd()));  					//부서코드
					businCdStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getBusinCd()));					//사업명	
					typOccudStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getTypOccuCd()));				//직종명
					dtilOccuInttnCdStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getDtilOccuInttnCd()));	//직종세명
					emymtDivCdStr.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getEmymtDivCd()));			//고용구분
					
					
					// ==========================================================
					// =============== DB에 입력된 정보 가져옴(주휴일수)
					// ==========================================================
					Dlgn0100DTO dlgn0100Dto = new Dlgn0100DTO();
					
					dlgn0100Dto.setDilnlazYrMnth(se.getSelectedItem().getDilnlazYrMnth());
					dlgn0100Dto.setPayCd(MSFSharedUtils.allowNulls(se.getSelectedItem().getPayCd()));
					dlgn0100Dto.setDeptCd(MSFSharedUtils.allowNulls(se.getSelectedItem().getPayrMangDeptCd()));
//					dlgn0100Dto.setHanNm(srhHanNm.getValue());
//					dlgn0100Dto.setResnRegnNum(detailRegnNum.getValue());
					dlgn0100Dto.setSystemkey(se.getSelectedItem().getSystemkey());
					dlgn0100Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(se.getSelectedItem().getEmymtDivCd()));
					dlgn0100Dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(se.getSelectedItem().getDeptCd()));	//부서
					dlgn0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(se.getSelectedItem().getTypOccuCd())); 
					dlgn0100Dto.setDtilOccuInttnCd( MSFSharedUtils.allowNulls(se.getSelectedItem().getDtilOccuInttnCd()));
					dlgn0100Dto.setBusinCd(MSFSharedUtils.allowNulls(se.getSelectedItem().getBusinCd()));
					
					
					//service 구현
					dlgn0110Service.getMemberInfo(dlgn0100Dto, new AsyncCallback<Dlgn0100DTO>(){
						@Override 
						public void onFailure(Throwable caught) {
						// 해당 서비스 오류날 경우 기존 값 넣어줌.	
							detailWeekHdayCnt.setValue(se.getSelectedItem().getDilnlazWklyHldyNumDys());
							detailWeekHdayCntStr = se.getSelectedItem().getDilnlazWklyHldyNumDys();
							
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        	MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getMemberInfo(대상자정보 조회 오류) : " + caught), null);
						}
						
						@Override
						public void onSuccess(Dlgn0100DTO result) {
							
							// 데이터 없을 경우 기존 값 넣어줌
							if(result.getDilnlazWklyHldyNumDys() == null || "".equals(result.getDilnlazWklyHldyNumDys())) {
								
								detailWeekHdayCnt.setValue(se.getSelectedItem().getDilnlazWklyHldyNumDys());
								detailWeekHdayCntStr = se.getSelectedItem().getDilnlazWklyHldyNumDys();
							
							// db값 넣어줌
							}else {
								
								detailWeekHdayCnt.setValue(result.getDilnlazWklyHldyNumDys());
								detailWeekHdayCntStr = result.getDilnlazWklyHldyNumDys();
							}
 				 
						}    		
					});	
					// ==========================================================
					// =============== DB에 입력된 정보 가져옴(주휴일수)
					// ==========================================================
					
					
					detailYm.setValue(DateTimeFormat.getFormat("yyyy.MM").format(DateTimeFormat.getFormat("yyyyMM").parse(se.getSelectedItem().getDilnlazYrMnth())));
					
					if("".equals(se.getSelectedItem().getDilnlazDutyBgnnDt()) || se.getSelectedItem().getDilnlazDutyBgnnDt() == null) {
						detailWorkDayS.setValue("");
					}else {
						detailWorkDayS.setValue(se.getSelectedItem().getDilnlazDutyBgnnDt().substring(0,4)+"."+se.getSelectedItem().getDilnlazDutyBgnnDt().substring(4,6)+"."+se.getSelectedItem().getDilnlazDutyBgnnDt().substring(6,8));
					}
					
					if("".equals(se.getSelectedItem().getDilnlazDutyEndDt()) || se.getSelectedItem().getDilnlazDutyEndDt() == null) {
						detailWorkDayE.setValue("");
					}else {
						 detailWorkDayE.setValue(se.getSelectedItem().getDilnlazDutyEndDt().substring(0,4)+"."+se.getSelectedItem().getDilnlazDutyEndDt().substring(4,6)+"."+se.getSelectedItem().getDilnlazDutyEndDt().substring(6,8));
					}
					
					detailName.setValue(se.getSelectedItem().getHanNm());
					detailRegnNum.setValue(se.getSelectedItem().getResnRegnNum());
					detailDeptNm.setValue(se.getSelectedItem().getDeptCdNm());
					detailEmymtDivCd.setValue(se.getSelectedItem().getEmymtDivCd());
					
					if(MSFConfiguration.EMYMT_DIVCD01.equals(detailEmymtDivCd.getValue())) {
						detailTypOccuNm.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getTypOccuNm()) + "(" + MSFSharedUtils.allowNulls(se.getSelectedItem().getDtilOccuInttnNm()) + ")");
					}else {
						detailTypOccuNm.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getBusinCdNm()));
					}
					detailDtilOccuInttnNm.setValue(se.getSelectedItem().getDtilOccuInttnNm());
					detailBusinNm.setValue(se.getSelectedItem().getBusinCdNm());
					detailEmymtBgnnDt.setValue(se.getSelectedItem().getEmymtBgnnDt());
					detailEmymtEndDt.setValue(se.getSelectedItem().getEmymtEndDt());
//					detailWeekHdayCnt.setValue(se.getSelectedItem().getDilnlazWklyHldyNumDys());
					
					BaseListLoadConfig bllc = new BaseListLoadConfig();
					bllc.set("getDpobCd", se.getSelectedItem().getDpobCd());
					bllc.set("getSystemkey", se.getSelectedItem().getSystemkey());
					bllc.set("getDilnlazYrMnth", se.getSelectedItem().getDilnlazYrMnth());
					bllc.set("getPayCd", se.getSelectedItem().getPayCd());
					bllc.set("getDilnlazWklyHldyNumDys", se.getSelectedItem().getDilnlazWklyHldyNumDys());
					
					
					loaderDlgn0110.load(bllc);
					
					IColumnFilter filters = null;
					
					Dlgn0100Grid0110.getTableDef().setTableColumnFilters(filters);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailYm", MSFSharedUtils.allowNulls(detailYm.getValue().replaceAll("\\.", "")), SimpleColumnFilter.OPERATOR_EQUALS);
//					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailYm", MSFSharedUtils.allowNulls(DateTimeFormat.getFormat("yyyyMM").parse(detailYm.getValue())), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailName", MSFSharedUtils.allowNulls(detailName.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailRegnNum", MSFSharedUtils.allowNulls(detailRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailBusinNm",MSFSharedUtils.getSelectedComboValue(srhBusinCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailEmymtBgnnDt", MSFSharedUtils.allowNulls(detailEmymtBgnnDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailEmymtEndDt", MSFSharedUtils.allowNulls(detailEmymtEndDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
//					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailEmymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("detailEmymtDivCd",MSFSharedUtils.allowNulls(detailEmymtDivCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(bllc.get("getSystemkey")), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
					
					//여기
					Dlgn0100Grid0110_1.getTableDef().setTableColumnFilters(filters);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailYm", MSFSharedUtils.allowNulls(detailYm.getValue().replaceAll("\\.", "")), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailName", MSFSharedUtils.allowNulls(detailName.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailRegnNum", MSFSharedUtils.allowNulls(detailRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailBusinNm",MSFSharedUtils.getSelectedComboValue(srhBusinCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailEmymtBgnnDt", MSFSharedUtils.allowNulls(detailEmymtBgnnDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailEmymtEndDt", MSFSharedUtils.allowNulls(detailEmymtEndDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
//					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailEmymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("detailEmymtDivCd",MSFSharedUtils.allowNulls(detailEmymtDivCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(bllc.get("getSystemkey")), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0100Grid0110_1.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
					
				  
				}
					if((detailYmKubn.compareTo(detailYm.getValue().replaceAll("\\.", "")) >= 0 )){
						cpGrid_1.show();
						cpGrid.hide();
						Dlgn0100Grid0110_1.reload(); //기준일 전
					}else{
						cpGrid_1.hide();
						cpGrid.show();
						Dlgn0100Grid0110.reload(); //기준일 후
					}
			}
		});
		
		
		cp01.add(dlgn0100Grid);
		// grid.setWidth("480px");

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	
	
	/** 근무실적생성  */
	private void createDlgn0100Data() {
		
	   final Tracker tracker = new Tracker();
   	   tracker.setStatus(false);
   	   
   	   
		MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					String year = DlgnUtils.getSelectedComboValue(creYear,"year");
					String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
					String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
					String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
					String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
					String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");

					//주휴일수 계산
					Calendar  startCal =   Calendar.getInstance();
					startCal.set ( Integer.parseInt(workDayS.substring(0,4)), Integer.parseInt(workDayS.substring(4,6)), Integer.parseInt(workDayS.substring(6,8)) );
					int startWeek = startCal.get(Calendar.WEEK_OF_YEAR);
					
					Calendar  endCal =   Calendar.getInstance();
					endCal.set ( Integer.parseInt(workDayE.substring(0,4)), Integer.parseInt(workDayE.substring(4,6)), Integer.parseInt(workDayE.substring(6,8)) );
					int endWeek = endCal.get(Calendar.WEEK_OF_YEAR);
						
					int weekDifference = endWeek - startWeek;
					//주휴일수 계산 끝
					
					String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd");
					String mangeDeptCd = DlgnUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd");
					String typOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
					String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
					String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd"); 
					
					
					if("".equals(year) || "".equals(month)){
						MessageBox.info("", "작업년월은 필수 입니다.", null);
					}else if("".equals(workDayS) || "".equals(workDayE)){
						MessageBox.info("", "근태기간은 필수 입니다.", null);
						
					}else if("".equals(payrMangDeptCd) || "".equals(payrMangDeptCd)){
						MessageBox.info("", "단위기관은 필수 입니다.", null);
					}else if("".equals(payCd)){
						MessageBox.info("", "급여구분은 필수 입니다.", null);
						
					}else if("".equals(emymtDivCd) || "".equals(emymtDivCd)){
						MessageBox.info("", "고용구분은 필수 입니다.", null);
					}else if("".equals(emymtDivCd) || "".equals(deptCd)){
						MessageBox.info("", "부서는 필수 입니다.", null);
						
					}else if(GregorianCalendar.compareDate(creWorkDayS.getValue(), creWorkDayE.getValue()) < 0){
						MessageBox.info("", "근태기간 설정이 이상합니다. 확인하십시요.", null);  
					} else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {    
						if("".equals(businCd)){
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
	         		     } else {
	         		     
	                         
	                         Dlgn0100DTO dto = new Dlgn0100DTO();
	                         
	                         String months = month;
							 
	                         if(month.length() == 1)  {
	                        	 months = "0"+month;
	                         }
	                         
//	                         dto.setSystemkey(srhSystemkey.getValue());			
	                         dto.setSystemkey(creSystemkey.getValue());			//시스템키
	                         dto.setDilnlazYrMnth(year+months);					//지급년월 //jobYrMnth
	                         dto.setDilnlazDutyBgnnDt(workDayS);				//근태기간(시작) //rflctnBgnnDt, workDayS
	                         dto.setDilnlazDutyEndDt(workDayE);					//근태기간(종료) //rflctnEndDt, workDayE
	                         dto.setPayrMangDeptCd(payrMangDeptCd);				//단위기관
	                         dto.setPayCd(payCd);								//급여구분
	                         
	                         dto.setEmymtDivCd(emymtDivCd);						//고용구분
							 dto.setCurrAffnDeptCd(deptCd);						//부서
							 dto.setTypOccuCd(typOccuCd);						//직종
							 dto.setDtilOccuInttnCd(dtilOccuInttnCd);			//직종세
							 dto.setBusinCd(businCd);							//사업
							 dto.setDeptCd(deptCd);								//부서
							 dto.setDilnlazWklyHldyNumDys(weekDifference+""); 	//주휴일수
							 
							  final MessageBox box = MessageBox.wait("근무실적", "근무실적 데이타 처리 중 입니다...", "근무실적 생성(삭제) 중...");
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
				                
	                         dlgn0100Service.generateWorkTime(dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
									
									@Override
									public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
										  tracker.setStatus(true);
										
										   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
			    		    			    
				   		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
				   		    		       msFwMessage.show();
				   		    		       showMessageForm.setMSFFormWindows(msFwMessage);
				                       
				                            
				     	                    reload();
				     	                  //  actionDatabase = ActionDatabase.UPDATE;
				     	                    
										//MessageBox.info("", "근태가 생성 되었습니다.", null);
								   
									}
									
									@Override
									public void onFailure(Throwable caught) {
										tracker.setStatus(true);
										ShowMessageBM smForm = new ShowMessageBM();
										smForm.setWindowId("DLGN0100");
										smForm.setWindowNm("기본근무관리");
							            GWTUtils.messageExcepDlgEx(caught,smForm);
										//MessageBox.info("", "근태 생성 실패", null);
									}
								});
	         		     }
	               
	               }else{
	            	 
	            	   Dlgn0100DTO dto = new Dlgn0100DTO();
	            	   
	            	   String months = month;
	            	   if(month.length() == 1) months = "0"+month;
	            	   
//	            	   dto.setSystemkey(srhSystemkey.getValue());
	            	   dto.setSystemkey(creSystemkey.getValue());		//시스템키
	            	   dto.setDilnlazYrMnth(year+months);				//작업년월 
	            	   dto.setDilnlazDutyBgnnDt(workDayS);				//근태기간(시작) //rflctnBgnnDt, workDayS
	            	   dto.setDilnlazDutyEndDt(workDayE);				//근태기간(종료) //rflctnEndDt, workDayE
	            	   dto.setPayrMangDeptCd(payrMangDeptCd);			//단위기관
	            	   dto.setPayCd(payCd);								//급여구분	            	   
	            	   dto.setEmymtDivCd(emymtDivCd);					//고용구분
	            	   dto.setCurrAffnDeptCd(deptCd);					//부서
	            	   dto.setTypOccuCd(typOccuCd);						//직종
	            	   dto.setDtilOccuInttnCd(dtilOccuInttnCd);			//직종세
	            	   dto.setBusinCd(businCd);							//사업
	            	   dto.setDeptCd(deptCd);							//부서
	            	   dto.setDilnlazWklyHldyNumDys(weekDifference+""); // 주휴일수
	            	   
	            	   final MessageBox box = MessageBox.wait("근무실적", "근무실적 데이타 처리 중 입니다...", "근무실적 생성(삭제) 중...");
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
		                
	            	   dlgn0100Service.generateWorkTime(dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
	            		   @Override
	            		   public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
	            			   
	            			   tracker.setStatus(true);
								
							   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
    		    			    
	   		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
	   		    		       msFwMessage.show();
	   		    		       showMessageForm.setMSFFormWindows(msFwMessage);
	                       
	                            
	     	                    reload();
	     	                  //  actionDatabase = ActionDatabase.UPDATE;
	     	                    
							//MessageBox.info("", "근태가 생성 되었습니다.", null);
	            			   //MessageBox.info("", "근태가 생성 되었습니다.", null);
            			   }
	            		   @Override
	            		   public void onFailure(Throwable caught) {
	            			   tracker.setStatus(true);
								ShowMessageBM smForm = new ShowMessageBM();
								smForm.setWindowId("DLGN0100");
								smForm.setWindowNm("기본근무관리");
					            GWTUtils.messageExcepDlgEx(caught,smForm);
								//MessageBox.info("", "근태 생성 실패", null);
	            			  // MessageBox.info("", "근태 생성 실패", null);
            			   }
            		   });
	               }
	           }  
	      }
	  }); 
	}  
	 
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	  private void fnPopupPsnl0100(final String flag)  {
          //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
          //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
          //검색.처리하면됨.
		  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
		  //  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();  //우편번호 
          
		  final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
          
          popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
              public void handleEvent(BaseEvent be) {
                  BaseModel mapModel = (BaseModel)be.getSource();
                  if (!"".equals(mapModel.get("systemkey"))) { 
	                  //개별근태 생성일 경우
	                  if("DLGN".equals(flag)) {
	                	  
	                	creSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   	//시스템키
	                	creHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));			//성명
	                	creResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));//주민번호 
	                	  
	                   	createDlgn0100Data();
	                  
	                  // 검색조건일 경우
	                  }else if("PSNL".equals(flag)){
	                	  
	                	srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   	//시스템키
	                	srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));			//성명
	                	srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));//주민번호
	                	
	                  }  
                  }
              }
          });
	  }
	  
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	  private void xlsExportData() {
		  
		    HashMap<String, String> param = new HashMap<String, String>(); 
		    
		    String year = DlgnUtils.getSelectedComboValue(creYear, "year");
			String month = DlgnUtils.getSelectedComboValue(creMonth, "month");
			
			String typOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
			String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd, creDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
			String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd");
			
			param.put("payrMangDeptCd", DlgnUtils.getSelectedComboValue(crePayrMangDeptCd, "payrMangDeptCd"));
			param.put("mangeDeptCd", DlgnUtils.getSelectedComboValue(creMangeDeptCd, "mangeDeptCd"));
			param.put("jobYrMnth", year.concat(month));
			param.put("payCd", DlgnUtils.getSelectedComboValue(crePayCd, "commCd"));
			param.put("rflctnBgnnDt", DlgnUtils.getConvertDateToString(creWorkDayS,"yyyyMMdd"));
			param.put("rflctnEndDt", DlgnUtils.getConvertDateToString(creWorkDayE,"yyyyMMdd"));
			 
			param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")); 								//고용구분
			param.put("deptCd", DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(), "deptNmRtchnt", "deptCd")); 	//부서
			param.put("typOccuCd", typOccuCd);
//			 param.put("pyspGrdeCd", pyspGrdeCd);
			param.put("dtilOccuInttnCd", dtilOccuInttnCd);
			param.put("businCd", businCd);
			

			if ("".equals(year) || "".equals(month)) {
				MessageBox.info("", "작업년월은 필수 입니다.", null);
			} else if ("".equals(DlgnUtils.getSelectedComboValue(srhPayCd, "commCd"))) {
				MessageBox.info("", "급여구분은 필수 입니다.", null);
			} else if ("".equals(DlgnUtils.getConvertDateToString(creWorkDayS,"yyyyMMdd")) || "".equals(DlgnUtils.getConvertDateToString(creWorkDayE,"yyyyMMdd"))) {
				MessageBox.info("", "근태기간은 필수 입니다.", null);
			} else if ("".equals(DlgnUtils.getSelectedComboValue(crePayrMangDeptCd, "payrMangDeptCd"))){
				MessageBox.info("", "단위기관은 필수 입니다.", null);
			} else if ("".equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))){
				MessageBox.info("", "고용구분은 필수 입니다.", null);
			} else if ("".equals(DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(), "deptNmRtchnt", "deptCd"))){
				MessageBox.info("", "부서선택은 필수 입니다.", null);
			} else if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
				
				if ("".equals(MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"))) {
					
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
				} else {
				  GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsDlgn0100Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
//				  dlgn0100Grid.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsDlgn0100Export.do", "extgwtFrame", param);
				  
				}
			} else {
				
				 GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsDlgn0100Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
//				dlgn0100Grid.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsDlgn0100Export.do", "extgwtFrame", param);
			}
			
    } 
	  
	  private void xlsImportData() { 
	         
			MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	              
						HashMap<String, String> param = new HashMap<String, String>();
						// only accept certain files 
			                       
						String year = DlgnUtils.getSelectedComboValue(creYear,"year");
	                    String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
	                    String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
	                    String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
	                    String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"); 
	                    String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
	                    String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
	                    String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	                    String strTypOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	                    String strDtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	                    String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd");  
	                       
	                      
	                       
	                       
	                    if("".equals(year) || "".equals(month)){
	                    	MessageBox.info("", "작업년월은 필수 입니다.", null);
	                    }else if("".equals(payCd)){
	                    	MessageBox.info("", "급여구분은 필수 입니다.", null);
	                    }else if("".equals(workDayS) || "".equals(workDayE)){
	                    	MessageBox.info("", "근태기간은 필수 입니다.", null);
	                    } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
	                    	if("".equals(businCd)){
	                    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
	                    	} else {
	                    		//get the filename to be uploaded
	                    		String filename = MSFSharedUtils.allowNulls(dlgn0100flUp.getValue());
	                    		if (filename.length() == 0) {
	                    			Window.alert("선택된 파일이 없습니다.");
	                    		} else {
	                    			//submit the form
	                    			plFrmDlgn0100.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                    			
	                    			//파일업로드 처리
	                    			plFrmDlgn0100.setAction(GWT.getHostPageBaseURL() + "imp/XlsDlgn0100Import.do");
	                    			plFrmDlgn0100.setEncoding(Encoding.MULTIPART);
	                    			plFrmDlgn0100.setMethod(Method.POST);   
//	                                     FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
//	                                     frmEl.setAcceptCharset("UTF-8"); 
	                    			plFrmDlgn0100.submit();  
	                                plFrmDlgn0100.onFrameLoad();  
	                                picBoolFile = true;
	                    		}               
	                                  
	                    		// reset and unmask the form 
	                    		// after file upload 
	                    		plFrmDlgn0100.addListener(Events.Submit, new Listener<FormEvent>() {
	                    			public void handleEvent(FormEvent evt) {   
	                    				if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    					//업로드가  성공했으면 인서트 모듈을 태운다. 
	                    					plFrmDlgn0100.unmask();  
	                    					MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
	                    					picBoolFile = false;
	                    					evt.setResultHtml("");
	                    				} else {
	                    					if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    						//업로드가  성공했으면 인서트 모듈을 태운다.
	                    						MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
	                    						picBoolFile = false;
	                    						evt.setResultHtml("");
	                    					} else {
	                    						//실패 메시지나 에러 메시지 처리 . 
	                    						evt.setResultHtml("");
	                    					} 
	                    				}
	                    			};
	                    		}); 
	                    	}
	                    }else{ 
	                    	
	                    	//get the filename to be uploaded
	                    	String filename = MSFSharedUtils.allowNulls(dlgn0100flUp.getValue());
	                    	
	                    	if (filename.length() == 0) {
	                              Window.alert("선택된 파일이 없습니다.");
	                    	} else {
	                    		//submit the form
	                    		plFrmDlgn0100.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                    		
	                    		//파일업로드 처리
	                    		plFrmDlgn0100.setAction(GWT.getHostPageBaseURL() + "imp/XlsDlgn0100Import.do");
	                    		plFrmDlgn0100.setEncoding(Encoding.MULTIPART);
	                    		plFrmDlgn0100.setMethod(Method.POST);   
//	                               FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
//	                               frmEl.setAcceptCharset("UTF-8"); 
	                    		plFrmDlgn0100.submit();  
	                    		plFrmDlgn0100.onFrameLoad();  
	                    		picBoolFile = true;
	                    	}               
	                            
	                    	// reset and unmask the form 
	                    	// after file upload 
	                    	plFrmDlgn0100.addListener(Events.Submit, new Listener<FormEvent>() {
	                    		public void handleEvent(FormEvent evt) {   
	                    			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    				//업로드가  성공했으면 인서트 모듈을 태운다. 
	                    				plFrmDlgn0100.unmask();  
	                    				MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
	                    				picBoolFile = false;
	                    				evt.setResultHtml("");
	                    			} else {
	                    				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    					//업로드가  성공했으면 인서트 모듈을 태운다.
	                    					MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
	                    					picBoolFile = false;
	                    					evt.setResultHtml("");
	                    				} else {
	                    					//실패 메시지나 에러 메시지 처리 . 
	                    				} 
	                    			}
	                    		};
	                    	});
	                    }
					}  
				}
			}); 
		} 
	
	  private void detailClear() {
		  	
		    Dlgn0100Grid0110_1.getMsfGrid().clearData();
		    Dlgn0100Grid0110.getMsfGrid().clearData();
		    
		    detailYm.clear();				//작업년월
			detailWorkDayS.clear();		//근태 시작기간
			detailWorkDayE.clear();		//근태 종료기간
			detailName.clear();			//성명
			detailRegnNum.clear();			//주민번호
			detailDeptNm.clear();			//부서명
			detailTypOccuNm.clear();		//직종명
			detailDtilOccuInttnNm.clear();	//직종세명
			detailBusinNm.clear();			//사업명
			detailEmymtDivCd.clear();		//고용구분(hidden)
			detailEmymtBgnnDt.clear();		//계약일자
			detailEmymtEndDt.clear();		//종료일자
			detailWeekHdayCnt.clear();		//주휴일수
	  }
	  
	private void setInitDate() {
		   
		int maxDays = 0;
		   
			Calendar  intiCal =  Calendar.getInstance(); 
			intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creMonth,"month")) - 1, 1 );
			creWorkDayS.setValue(intiCal.getTime());
			maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);  
	        
			Calendar  intieCal =   Calendar.getInstance();
			intieCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creMonth,"month")) - 1, maxDays );
	      // intiCal.add(Calendar.DATE, maxDays - 1);
	      // GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
			creWorkDayE.setValue(intieCal.getTime());
	}	  
	
	
	private void  displayDtilOccuInttnCd() {
		  
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
           
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
               
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
            List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
            String strDeptCd = DlgnUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = DlgnUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
               
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
               
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                   
            	lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
            	//  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                   
            	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
            		public void handleEvent(StoreEvent<BaseModel> be) {  
            			mDtalistDtilOccuInttnCd = DlgnUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
            			srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
                           
            			if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
            				ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
		  		                   
		  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
		  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
		  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
		  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
		  		                      //         mdSelect = tpMdSelect;
		  		                         //  } 
		  		                     //  }  	
		  		                   
                       	    srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
                       	    srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
		  		                   // }  
   	                 	} 
            		}
            	});     
            } 
            
         } else {
         } 
	}
	
	private void  displayCreDtilOccuInttnCd() {
		if ((creTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
			//직종변경에 따른 직종세 값 가져오기
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		           
			List<ModelData> mdDeptCdSelect =  creDeptCd.getListView().getChecked();  
			String strDeptCd = DlgnUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
	    	sysComBass0350Dto.setDeptCd(strDeptCd);
	                  
	    	List<ModelData> mdListSelect =  creTypOccuCd.getListView().getChecked();
		 	String strTypOccuCd = DlgnUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
		            
			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
				lscrDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
		              //  creDtilOccuInttnCd.setStore(lscrDtilOccuInttnCd); 
				lscrDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistcrDtilOccuInttnCd = DlgnUtils.getDtilOccuInttnCdModelData(lscrDtilOccuInttnCd) ; 
						creDtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);
						
						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = creDtilOccuInttnCd.getStore().getAt(0) ;
							creDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							creDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
						} 
					}
				});     
			} 
		} else {
		}   
	}
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	} 
	
	
	private Dlgn0100 getThis() {
		return this;
	}
	
 	

	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
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
