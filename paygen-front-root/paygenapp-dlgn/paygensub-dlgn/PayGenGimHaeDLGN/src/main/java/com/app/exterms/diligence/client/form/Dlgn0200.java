package com.app.exterms.diligence.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.service.InfcPkgBass0500Service;
import com.app.exterms.basis.client.service.InfcPkgBass0500ServiceAsync;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.dto.Dlgn0210DTO;
import com.app.exterms.diligence.client.form.defs.Dlgn0200Def;
import com.app.exterms.diligence.client.service.Dlgn0200Service;
import com.app.exterms.diligence.client.service.Dlgn0200ServiceAsync;
import com.app.exterms.dlgn.client.utils.DlgnUtils;
import com.app.exterms.dlgn.server.utils.DiligenceCommonConstants;
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
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
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
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Dlgn0200 extends MSFPanel {

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부시작} 
	 * #######################################################
	 */
	
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	private BaseModel record; 
	
//	//검색조건 시작
//	private ComboBox<BaseModel> searchYear; 		//작업년도
//	private ComboBox<BaseModel> searchMonth;		//작업월
//	private ComboBox<BaseModel> searchCurrDeptCd;	//소속
//	private ComboBox<BaseModel> searchDeptCd; 		//부서
//	private ComboBox<BaseModel> searchBusinCd; 		//사업명
//	private ComboBox<BaseModel> searchEmymtDivCd; 	//고용구분
//	private TextField<String> searchName;			//성명
//	private TextField<String> searchResnRegnNum;	//주민번호
//	//검색조건 끝
//	
//	//중간 근태생성 부분 시작
//	private ComboBox<BaseModel> midYear; 		//작업년도
//	private ComboBox<BaseModel> midMonth;		//작업월
//	private DateField midWorkDayS;		//근태기간 시작일
//	private DateField midWorkDayE;		//근태기간 종료일
//	
//	private ComboBox<BaseModel> midEmymtDivCd;
//	private ComboBox<BaseModel> midCurrDeptCd;
//	private ComboBox<BaseModel> midBusinCd;
//	private ComboBox<BaseModel> midTypOccuCd;
//	private ComboBox<BaseModel> midPayCd;
//	
//	//중간 근태생성 부분 끝
	
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
    
    private ActionDatabase actionDatabase;

    private Boolean picBoolFile;
    private Iterator<Record> records;
          
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
    private MSFMultiComboBox<ModelData> creDeptCd ;    		//부서 
    private MSFComboBox<BaseModel> creDeptGpCd; 				//부서직종그룹코드	
    private MSFMultiComboBox<ModelData> creTypOccuCd; 		//직종  
    private MSFMultiComboBox<ModelData> creDtilOccuInttnCd; //직종세
    
    
    private HiddenField<String> creHanNm;        	 		//성명
    private HiddenField<String> creResnRegnNum;   			//주민번호 
    private HiddenField<String> creSecRegnNum;   			//주민번호 
    private HiddenField<String> creSystemkey;   			//시스템키
    // -- 중간 근태생성 부분 종료
	// ---------- 검색조건 종료 	----------
    
    //파일업로드처리 부분  
    private FileUploadField dlgn0200flUp;
	
	//근태상세정보 시작
    private TextField<String> detailYm;				//작업년월
	private TextField<String> detailWorkDayS;		//근태 시작기간
	private TextField<String> detailWorkDayE;		//근태 종료기간
	private TextField<String> detailName;			//성명
	private TextField<String> detailSystemkey;		//시스템키
	private TextField<String> detailRegnNum;		//주민번호
	private TextField<String> detailDeptNm;			//부서명
	private TextField<String> detailBusinNm;		//사업명	
	private TextField<String> detailEmymtBgnnDt;	//계약일자
	private TextField<String> detailEmymtEndDt;		//종료일자
	private TextField<String> detailWeekHdayCnt;	//휴가
	private TextField<String> detailTypOccuNm;		//직종명
	private TextField<String> detailDtilOccuInttnNm;//직종세명
	private HiddenField<String> detailEmymtDivCd;	//고용구분
	//근태상세정보 끝
	
	// ------  멀티콤보 선언 시작 ------
	private List<ModelData> mDtalistDeptCd ;
    private List<ModelData> mDtalistTypOccuCd ;
    private List<ModelData> mDtalistDtilOccuInttnCd ;
    
    private boolean mutilCombo = false;
    
    private List<ModelData> mDtalistcrDeptCd ;
    private List<ModelData> mDtalistcrTypOccuCd ;
    private List<ModelData> mDtalistcrDtilOccuInttnCd ;
    
    private boolean mutilcrCombo = false;
 	// ------  멀티콤보 선언 종료 ------
	
    // ------------- 기준일 전역변수 선언 시작------------

	private String detailYmKubn = DiligenceCommonConstants.GIMHAE_DLGN_DT_BUNGI;
//  	private String detailYmKubn = "201703"; //복무관리 기준일 property에서 받을 부분.
  	// --------------기준일 전역변수 선언 종료-------------
  	
    // ------------- 상단버튼 전역변수 선언 시작------------
  	Button topBtnSave = new Button();
  	Button topBtnDel = new Button();
  	Button topBtnSch = new Button();
  	Button btnDlgn0200Upload = new Button();
  	Button btnDlgn0200DownLoad = new Button();
    // ------------- 상단버튼 전역변수 선언 종료------------
  	
  	LabelField lblfldNewLabelfield_16 = new LabelField();
  	LabelField lblfldNewLabelfield_17 = new LabelField();
  	LabelField lblfldNewLabelfield_18 = new LabelField();
  	LabelField lblfldNewLabelfield_19 = new LabelField();
  	
    // ------  DTO 선언 시작 ------
    private PrgmComBass0300DTO sysComBass0300Dto;	//공통코드 dto
    private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
    private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
    private PrgmComBass0150DTO sysComBass0150Dto; 	//단위기관 
    private SysCoCalendarDTO  msfCoCalendarDto;  
    private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
    private PrgmComBass0320DTO sysComBass0320Dto;	//직종
    // ------  DTO 선언 종료 ------
	
    // ------  service 호출 시작 ------
	private InfcPkgPsnl0100ServiceAsync psnl0100Service = InfcPkgPsnl0100Service.Util.getInstance();
	private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	private Dlgn0200ServiceAsync dlgn0210Service = Dlgn0200Service.Util.getInstance();
	// ------  service 호출 종료 ------
	
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
    
	private ListStore<BaseModel> listStoreB015 = new ListStore<BaseModel>(); 		//급여구분
	private ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>(); 		//직종
	private ListStore<BaseModel> listStoreA002 = new ListStore<BaseModel>(); 		//고용구분
	private ListStore<BaseModel> listStoreBass0400 = new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreBass0400All = new ListStore<BaseModel>(); // 소속부서 전체 데이타
	private ListStore<BaseModel> listStoreSrhYr = new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreYr = new ListStore<BaseModel>();
	 // ------  stroe 선언 종료 ------
	
	ContentPanel cpGrid = new ContentPanel(); 
	ContentPanel cpGrid_1 = new ContentPanel(); 	
	// --------- gird,Def 선언 시작 ----------
	private MSFGridPanel Dlgn0200Grid0210;	//근태관리대상자정보(기준일 후)
	private MSFGridPanel Dlgn0200Grid0210_1;	//근태관리대상자정보(기준일 후)
	private Dlgn0200Def Dlgn0200Def = new Dlgn0200Def("DLGN0200"); //시간외근무관리 근무내역등록 GRID (기준일 후)
	private Dlgn0200Def Dlgn0200Def_1 = new Dlgn0200Def("DLGN0200_1"); //시간외근무관리 근무내역등록 GRID (기준일 전)
	// --------- grid,Def 선언 종료 ----------
	
	
	private Dlgn0200ServiceAsync dlgn0200Service = Dlgn0200Service.Util.getInstance();
	private RpcProxy<BaseListLoadResult<Dlgn0200DTO>> dlgn0200Proxy = new RpcProxy<BaseListLoadResult<Dlgn0200DTO>>(){

		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Dlgn0200DTO>> callback) {
			Dlgn0200DTO dto = new Dlgn0200DTO();
//			
//			String searchYearS = searchYear.getValue() == null ? "" : DlgnUtils.getSelectedComboValue(searchYear);
//			String searchMonthS = searchMonth.getValue() == null ? "" : DlgnUtils.getSelectedComboValue(searchMonth);
//			if(searchMonthS.length() == 1) searchMonthS = "0"+searchMonthS;
			
			String searchYearS = srhPayYr.getValue() == null ? "" : DlgnUtils.getSelectedComboValue(srhPayYr,"year");
			String searchMonthS = srhPayMonth.getValue() == null ? "" : DlgnUtils.getSelectedComboValue(srhPayMonth,"month");
			if(searchMonthS.length() == 1) searchMonthS = "0"+searchMonthS;
			
			dto.setDilnlazExceDutyYrMnth(searchYearS+searchMonthS);
			dto.setPayCd(DlgnUtils.getSelectedComboValue(srhPayCd,"commCd"));
//			dto.setDeptCd(DlgnUtils.getSelectedComboValue(srhPayrMangDeptCd,"mangeDeptCd"));
			dto.setDeptCd(DlgnUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			dto.setHanNm(srhHanNm.getValue());
			dto.setResnRegnNum(srhResnRegnNum.getValue());
			dto.setEmymtDivCd(DlgnUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
			dto.setCurrAffnDeptCd(DlgnUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));	//부서
			dto.setTypOccuCd(DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd")); 
			dto.setDtilOccuInttnCd(DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			dto.setBusinCd(DlgnUtils.getSelectedComboValue(srhBusinCd, "businCd"));
			
//			dto.setDilnlazExceDutyYrMnth(searchYearS+searchMonthS);
//			dto.setCurrAffnDeptCd(DlgnUtils.getSelectedComboValue(searchCurrDeptCd,"deptCd"));
//			dto.setDeptCd(DlgnUtils.getSelectedComboValue(searchCurrDeptCd,"mangeDeptCd"));
//			dto.setBusinCd(DlgnUtils.getSelectedComboValue(searchBusinCd, "businCd"));
//			dto.setEmymtDivCd(DlgnUtils.getSelectedComboValue(searchEmymtDivCd, "commCd"));
//			dto.setHanNm(searchName.getValue());
//			dto.setResnRegnNum(searchResnRegnNum.getValue());
			
			dlgn0200Service.searchWorkDayMemberInfo((BaseListLoadConfig) loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderDlgn0200 = new BaseListLoader<BaseListLoadResult<ModelData>>(dlgn0200Proxy);
	private ListStore<Dlgn0200DTO> storeDlgn0200 = new ListStore<Dlgn0200DTO>(loaderDlgn0200);

	private Grid<Dlgn0200DTO> dlgn0200Grid; //근태관리대상자정보
	
	private RpcProxy<BaseListLoadResult<Dlgn0200DTO>> dlgn0210Proxy = new RpcProxy<BaseListLoadResult<Dlgn0200DTO>>(){

		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Dlgn0200DTO>> callback) {
			Dlgn0200DTO dto = new Dlgn0200DTO();
			dto.setDpobCd( ((BaseListLoadConfig) loadConfig).get("getDpobCd")+"");
			dto.setSystemkey(((BaseListLoadConfig) loadConfig).get("getSystemkey")+"");
			dto.setDilnlazExceDutyYrMnth(((BaseListLoadConfig) loadConfig).get("getDilnlazExceDutyYrMnth")+"");
			dto.setPayCd(((BaseListLoadConfig) loadConfig).get("getPayCd")+"");
			
			dlgn0200Service.getMemberWorkTimeInfo((BaseListLoadConfig) loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> loaderDlgn0210 = new BaseListLoader<BaseListLoadResult<ModelData>>(dlgn0210Proxy);
	private ListStore<Dlgn0200DTO> storeDlgn0210 = new ListStore<Dlgn0200DTO>(loaderDlgn0210);

	private EditorGrid<Dlgn0200DTO> dlgn0210Grid;  //근태상세정보
	
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
	
	  /**
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	  private void checkDlgn0200Auth(String authAction, ListStore<BaseModel> bm) {   
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
	                // GWTAuthorization.formAuthPopConfig(plFrmDlgn0200, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
	                // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			    //  gwtAuthorization.formAuthConfig(plFrmDlgn0200, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
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
	                     // GWTAuthorization.formAuthPopConfig(plFrmDlgn0200, "crePayrMangDeptCd","creEmymtDivCd",strArrDeptCd,"creTypOccuCd","creBusinCd");
	                     // GWTAuthorization.formAuthBtnConfig(btnCreCurrDeptCd); 
	             //  gwtAuthorization.formAuthConfig(plFrmDlgn0200,  "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creDtilOccuInttnCd","creBusinCd" );
	                    
	                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                 creDeptCd.getListView().fireEvent(Events.CheckChanged); 
	                    
	                   
            //MSFMainApp.unmaskMainPage();
             
		   }
	  }		
	
	
//	  private void checkDlgn0200Auth( String authAction, ListStore<BaseModel> bm) {   
//   	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//		 
//		  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
//		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//		   
//			   
//			      //----------------------------------------------------
//			   if (!maskTracker) { unmask(); }  
//                  //MSFMainApp.unmaskMainPage();  
//			      Field<?>[] fldArrField = {searchEmymtDivCd,searchCurrDeptCd,searchBusinCd,midEmymtDivCd,midCurrDeptCd,midTypOccuCd,midBusinCd};
//			    
//			      gwtAuthorization.formAuthFieldConfig(fldArrField);
//			         
//			      gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
//			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		         * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//		         * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			 //  gwtAuthorization.formAuthConfig(plFrmDlgn0200, "","searchEmymtDivCd","searchCurrDeptCd","","searchBusinCd");
//		        /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		         * 권한설정을 위한 콤보처리를 위한 메서드 종료
//		         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		         
//		          /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			 //  gwtAuthorization.formAuthConfig(plFrmDlgn0200, "","midEmymtDivCd","midCurrDeptCd","midTypOccuCd","midBusinCd");
//               /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                * 권한설정을 위한 콤보처리를 위한 메서드 종료
//                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//         
//                
//		   }
//	  }
	  
     final Timer tmMask = new Timer()
     {
           public void run()
           {
              // if (maskTracker)
              // { 
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

			 authMapDef.put("creYear",Boolean.FALSE);  
			 authMapDef.put("creMonth",Boolean.FALSE);  
			 authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
			 authMapDef.put("crePayCd",Boolean.FALSE);  
			 authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
			 authMapDef.put("creDeptCd",Boolean.FALSE); 		     
		     
		     
// 	         authMapDef.put("searchCurrDeptCd",Boolean.FALSE);
//					 authMapDef.put("searchEmymtDivCd",Boolean.FALSE);
//					 authMapDef.put("midEmymtDivCd",Boolean.FALSE);
//					 authMapDef.put("midCurrDeptCd",Boolean.FALSE); 
			    // authMapDef.put("midTypOccuCd",Boolean.FALSE);  
			 
			     gwtExtAuth.setCheckMapDef(authMapDef);
	        
	        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
	        	  //권한 검색조건처리를 위해 추가된 부분 
				 mask("[화면로딩] 초기화 진행 중!");
       	}
	        tmMask.scheduleRepeating(5000);
	  }
	   
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/	
	  
	
	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} #######################################################
	 */

	private VerticalPanel vp;
	private FormPanel plFrmDlgn0200;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// detailTp = XTemplate.create(getDetailTemplate());
	//
	// // formData = new FormData("-650");
	// vp = new VerticalPanel();
	// vp.setSpacing(10);
	// createDlgn0200Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createStandardForm(); //기본정보필드
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }

	public ContentPanel getViewPanel() {
		if (panel == null) {
			
			 //콤보 권한초기화
			   initLoad(); 
			
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add("A002");
			arrRpsttvCd.add("A041");
			arrRpsttvCd.add("B015");
			 sysComBass0300Dto = new PrgmComBass0300DTO();  
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
				
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					if(result != null && result.size() > 0){
						listStoreA002.add(result.get("A002"));
						listStoreA041.add(result.get("A041"));
						listStoreB015.add(result.get("B015"));
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
			
//			bass0500Service.getYearList(new AsyncCallback<List<BaseModel>>() {
//				@SuppressWarnings("deprecation")
//				@Override
//				public void onSuccess(List<BaseModel> result) {
//					listStoreSrhYr.add(result);
//					listStoreYr.add(result);
//					if(listStoreSrhYr.getCount() > 0){
//						DlgnUtils.setSelectedComboValue(srhPayYr, DateTimeFormat.getFormat("yyyy").format(new Date()));
//						DlgnUtils.setSelectedComboValue(srhPayMonth, DateTimeFormat.getFormat("MM").format(new Date()));
//					}
//					if(listStoreYr.getCount() > 0){
//						DlgnUtils.setSelectedComboValue(creYear, DateTimeFormat.getFormat("yyyy").format(new Date()));
//						DlgnUtils.setSelectedComboValue(creMonth, DateTimeFormat.getFormat("MM").format(new Date()));
//						
//						int year = new Date().getYear();
//						int month = new Date().getMonth();
//						
//						creWorkDayS.setValue(new Date(year,month,1) );
//						creWorkDayE.setValue(new Date(year,month+1,0) );
//						
//					}
//				}
//				
//				@Override
//				public void onFailure(Throwable caught) {
//					MessageBox.alert("", "년도코드 에러!", null);
//				}
//			});
			
			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createDlgn0200Form();	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createXlsForm();		// 근태생성부
			createStandardForm(); 	// 기본정보필드
			vp.setSize("1010px", "700px");

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
	public Dlgn0200() {

		setSize("1010px", "700px");
	}

	public Dlgn0200(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createDlgn0200Form() {

		plFrmDlgn0200 = new FormPanel();
		plFrmDlgn0200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 시간외근무관리"));
		plFrmDlgn0200.setPadding(2);
		plFrmDlgn0200.setIcon(Resources.APP_ICONS.text());
		plFrmDlgn0200.setBodyStyleName("pad-text");
		plFrmDlgn0200.setFrame(true);

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("시간외근무관리","DLGN0200");
				}
			});
		plFrmDlgn0200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmDlgn0200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		   //멀티콤보박스 닫기 
		plFrmDlgn0200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
				            @Override
				            public void handleEvent(ComponentEvent ce) { 
				            
				             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
				                    
				            //        if (f instanceof MSFMultiComboBox<?>) {
				                        
//				                      if ("srhDeptCd".equals(f.getName())) {
//				                          
//				                      } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//				                          
//				                      }
				                        
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
				
//				MessageBox.confirm("근무내역등록 저장", "근무내역정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
//					@Override
//					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
//						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							actionDatabase = ActionDatabase.UPDATE;
							doAction(actionDatabase);
							
//							ArrayList<Dlgn0200DTO> changeDataList = new ArrayList<Dlgn0200DTO>();
//							
//							for ( int i = 0; i < storeDlgn0210.getCount(); i++){
//								
//								if(dlgn0210Grid.getStore().getRecord(storeDlgn0210.getAt(i)).isDirty()){
//									changeDataList.add(storeDlgn0210.getAt(i));
//									changeDataList.get(changeDataList.size() - 1).setEmymtDivCd(detailEmymtDivCd.getValue());
//								}
//							}
//							
//							if(changeDataList.size() > 0){
//								
//								dlgn0200Service.saveWorkTime(changeDataList, new AsyncCallback<Integer>() {
//									@Override
//									public void onFailure(Throwable caught) {
//										//caught.printStackTrace();
//										//MessageBox.alert("", "근무내역저장 에러!", null);
//										ShowMessageBM smForm = new ShowMessageBM();
//										smForm.setWindowId("DLGN0200");
//										smForm.setWindowNm("시간외근무관리");
//										GWTUtils.messageExcepDlgEx(caught,smForm);
//									}
//
//									@Override
//									public void onSuccess(Integer result) {
//										MessageBox.info("저장완료", "수정한 근무내역("+result+")이 저장되었습니다.", null);
//										loaderDlgn0210.load();
//										
//										dlgn0210Grid.getStore().removeAll();
//										dlgn0210Grid.getStore().commitChanges();
//									}
//								});
//								
//							}else{
//								MessageBox.info("", "수정한 근무내역정보가 없습니다.", null);
//							}
							
//						}
//					}
//				});
				
			}
		});
		buttonBar.add(topBtnSave);

		topBtnDel = new Button("삭제");
		topBtnDel.setIcon(MSFMainApp.ICONS.delete16());
		topBtnDel.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				MessageBox.confirm("복무관리대상자 삭제", "선택하시 시간외근무관리 대상자를 삭제 하시겠습니까? [기본근무내역도 삭제됩니다.]",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
					//	if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							if(dlgn0200Grid.getSelectionModel().getSelectedItems().size() > 0){
								dlgn0200Service.deleteWorkTime(dlgn0200Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
									@Override
									public void onSuccess(Integer result) {
										MessageBox.info("", "삭제 되었습니다.", null);
										loaderDlgn0200.load();
										dlgn0210Grid.getStore().removeAll();
										dlgn0210Grid.getStore().commitChanges();
										
										detailYm.setValue("");				//작업년월
										detailWorkDayS.setValue("");		//근태시작일자
										detailWorkDayE.setValue("");		//근태종료일자
										detailName.setValue("");			//성명
										detailRegnNum.setValue("");			//주민번호
										detailDeptNm.setValue("");			//부서명
										detailTypOccuNm.setValue("");		//직종명
										detailDtilOccuInttnNm.setValue("");	//직종세명
										detailBusinNm.setValue("");			//사업명
										detailEmymtBgnnDt.setValue("");		//계약일자
										detailEmymtEndDt.setValue("");		//종료일자
										detailEmymtDivCd.setValue("");		//고용구분(hidden)
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

		topBtnSch = new Button("조회");
		topBtnSch.setIcon(MSFMainApp.ICONS.search16());
		topBtnSch.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				
				if(srhPayYr.getValue() != null && srhPayMonth.getValue() != null){
					
					detailClear();
					String year = DlgnUtils.getSelectedComboValue(srhPayYr,"year");
					String month = DlgnUtils.getSelectedComboValue(srhPayMonth,"month");
					String yearMonth = year + month;
					
					if((detailYmKubn.compareTo(yearMonth) >= 0 )){ //기준일 전
						dlgn0200flUp.hide();
//						topBtnSave.show();
						btnDlgn0200Upload.hide();
						btnDlgn0200DownLoad.hide();
						lblfldNewLabelfield_16.hide();
						lblfldNewLabelfield_17.hide();
						lblfldNewLabelfield_18.hide();
						lblfldNewLabelfield_19.hide();
					}else{ //기준일 후
						dlgn0200flUp.show();
//						topBtnSave.show();
						btnDlgn0200Upload.show();
						btnDlgn0200DownLoad.show();
						lblfldNewLabelfield_16.show();
						lblfldNewLabelfield_17.show();
						lblfldNewLabelfield_18.show();
						lblfldNewLabelfield_19.show();
					}
					loaderDlgn0200.load();
					
					dlgn0200Grid.getStore().removeAll();
					dlgn0200Grid.getStore().commitChanges();
					dlgn0210Grid.getStore().removeAll();
					dlgn0210Grid.getStore().commitChanges();
					
					detailYm.setValue("");				//작업년월
					detailWorkDayS.setValue("");		//근태시작일자
					detailWorkDayE.setValue("");		//근태종료일자
					detailName.setValue("");			//성명
					detailRegnNum.setValue("");			//주민번호
					detailDeptNm.setValue("");			//부서명
					detailTypOccuNm.setValue("");		//직종명
					detailDtilOccuInttnNm.setValue("");	//직종세명
					detailBusinNm.setValue("");			//사업명
					detailEmymtBgnnDt.setValue("");		//계약일자
					detailEmymtEndDt.setValue("");		//종료일자
					detailEmymtDivCd.setValue("");		//고용구분(hidden)
					
					// ---------------------------  생성부  ---------------------------
					creYear.setValue(srhPayYr.getValue());						//작업년 
			        creMonth.setValue(srhPayMonth.getValue());					//작업월
			        creEmymtDivCd.setValue(srhEmymtDivCd.getValue());			//고용구분
			        creBusinCd.setValue(srhPayCd.getValue());					//사업
			        crePayCd.setValue(srhPayCd.getValue());						//급여구분
			        crePayrMangDeptCd.setValue(srhPayrMangDeptCd.getValue());	//단위기관
			        creDeptCd.setValue(srhDeptCd.getValue());					//부서
			        creTypOccuCd.setValue(srhTypOccuCd.getValue());				//직종
			        creDtilOccuInttnCd.setValue(srhDtilOccuInttnCd.getValue());	//직종세
			        // ---------------------------  생성부  ---------------------------
					
				}else{
					MessageBox.info("", "작업년월은 필수 입니다.", null);
				}
			}
		});
		buttonBar.add(topBtnSch);

		//TODO 나중에 주석 풀고 사용
//		topBtn = new Button("인쇄");
//		topBtn.setIcon(Resources.APP_ICONS.text());
//		buttonBar.add(topBtn);

		plFrmDlgn0200.add(buttonBar);

		vp.add(plFrmDlgn0200);
		plFrmDlgn0200.setSize("990px", "750px"); 
	}

	
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
//			savePayr4200();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			saveDlgn0210();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
//			savePayr4200();
			break;
		}
	}
	     

	private void saveDlgn0210() { 
			
		  //기준일 후
		if (!(Dlgn0200Grid0210.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)){
		  if ((Dlgn0200Grid0210.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)
				  &&!(Dlgn0200Grid0210_1.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)){ 
	            
	            MessageBox.alert("근태정보", "저장할 근태정보가 존재하지 않습니다.", null);
	            return;
	      }else{
	    	  MessageBox.confirm("저장", "데이터를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
	    			 
	 			 @Override
	              public void handleEvent(MessageBoxEvent be) {
	                 // if("Yes".equals(be.getButtonClicked().getText())){
	              	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	 			Iterator<Record> iterRecords = Dlgn0200Grid0210.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
	 			List<Dlgn0210DTO> listDlgn0210_1dto = new ArrayList<Dlgn0210DTO>();
	 			Dlgn0210DTO dlgn0210dto = null;
	 			
	 			while (iterRecords.hasNext()) {
	 			dlgn0210dto = new Dlgn0210DTO();
	 			Record recData = (Record) iterRecords.next(); 
	 			BaseModel bmMapModel = (BaseModel)recData.getModel();
	 			
	 			dlgn0210dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
	 			dlgn0210dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
	 			dlgn0210dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));			/** column 급여구분 : payCd */
//	 			dlgn0210dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
	 			dlgn0210dto.setEmymtDivCd(detailEmymtDivCd.getValue());    /** column 고용구분코드 : emymtDivCd */
	 			dlgn0210dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
	 			dlgn0210dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
	 			dlgn0210dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
	 			dlgn0210dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세구분코드 : dtilOccuInttnCd */

                
	 			dlgn0210dto.setDilnlazExceDutyYrMnth(detailYm.getValue().replaceAll("\\.",""));		/** column 근무년월 : detailYm */
	 			dlgn0210dto.setDilnlazApptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazApptnDt")));		/** column 근태일자 : dilnlazApptnDt */
	 			dlgn0210dto.setDilnlazDutyStTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyStTm")));	/** column 시작시간 : dilnlazDutyStTm */
	 			dlgn0210dto.setDilnlazDutyEdTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyEdTm")));	/** column 종료시간 : dilnlazDutyEdTm */
	 			
	 			dlgn0210dto.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTmRstDutyTm")));		/** column 연장근무시간 : dilnlazTmRstDutyTm */
	 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
	 			if(dlgn0210dto.getDilnlazTmRstDutyTm().length() == 1) {
	 				dlgn0210dto.setDilnlazTmRstDutyTm("0" +  dlgn0210dto.getDilnlazTmRstDutyTm() + ":00");				/** column 연장근무시간 : dilnlazTmRstDutyTm */
	 			}else if(dlgn0210dto.getDilnlazTmRstDutyTm().length() == 2) {
	 				if("0".equals(dlgn0210dto.getDilnlazTmRstDutyTm().substring(0,1))) {
	 					dlgn0210dto.setDilnlazTmRstDutyTm(dlgn0210dto.getDilnlazTmRstDutyTm() + ":00");					/** column 연장근무시간 : dilnlazTmRstDutyTm */
	 				}
	 			}
	 			
	 			dlgn0210dto.setDilnlazNtotTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazNtotTm")));				/** column 야간근무시간 : dilnlazNtotTm */
	 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
	 			if(dlgn0210dto.getDilnlazNtotTm().length() == 1) {
	 				dlgn0210dto.setDilnlazNtotTm("0" +  dlgn0210dto.getDilnlazNtotTm() + ":00");						/** column 야간근무시간 : dilnlazNtotTm */
	 			}else if(dlgn0210dto.getDilnlazNtotTm().length() == 2) {
	 				if("0".equals(dlgn0210dto.getDilnlazNtotTm().substring(0,1))) {
	 					dlgn0210dto.setDilnlazNtotTm(dlgn0210dto.getDilnlazNtotTm() + ":00");							/** column 야간근무시간 : dilnlazNtotTm */
	 				}
	 			}
	 			
	 			
	 			
	 			dlgn0210dto.setDilnlazHodyDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHodyDutyTm")));		/** column 휴일근무시간 : dilnlazHodyDutyTm */
	 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
	 			if(dlgn0210dto.getDilnlazHodyDutyTm().length() == 1) {
	 				dlgn0210dto.setDilnlazHodyDutyTm("0" +  dlgn0210dto.getDilnlazHodyDutyTm() + ":00");				/** column 휴일근무시간 : dilnlazHodyDutyTm */
	 			}else if(dlgn0210dto.getDilnlazHodyDutyTm().length() == 2) {
	 				if("0".equals(dlgn0210dto.getDilnlazHodyDutyTm().substring(0,1))) {
	 					dlgn0210dto.setDilnlazHodyDutyTm(dlgn0210dto.getDilnlazHodyDutyTm() + ":00");					/** column 휴일근무시간 : dilnlazHodyDutyTm */
	 				}
	 			}
	 			
	 			
	 			
	 			dlgn0210dto.setDilnlazHodyNtotTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHodyNtotTm")));		/** column 휴일연장근무시간 : dilnlazHodyDutyRstTm */
	 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
	 			if(dlgn0210dto.getDilnlazHodyNtotTm().length() == 1) {
	 				dlgn0210dto.setDilnlazHodyNtotTm("0" +  dlgn0210dto.getDilnlazHodyNtotTm() + ":00");				/** column 휴일연장근무시간 : dilnlazHodyDutyRstTm */
	 			}else if(dlgn0210dto.getDilnlazHodyNtotTm().length() == 2) {
	 				if("0".equals(dlgn0210dto.getDilnlazHodyNtotTm().substring(0,1))) {
	 					dlgn0210dto.setDilnlazHodyNtotTm(dlgn0210dto.getDilnlazHodyNtotTm() + ":00");					/** column 휴일연장근무시간 : dilnlazHodyDutyRstTm */
	 				}
	 			}
	 			
	 			
	 			dlgn0210dto.setOffdayKubn(MSFSharedUtils.allowNulls(bmMapModel.get("offdayKubn")));						/** column 휴일 : dilnlazHodyDutyRstTm */
	 			
	 			listDlgn0210_1dto.add(dlgn0210dto);
	 			
	 		}
	 		//validation 구현
	 			
	 		// 휴일일경우 연장근무, 야근근무에 입력 못하게 처리.
//	 			if(!"".equals(dlgn0210dto.getDilnlazTmRstDutyTm())){
//	 				if("1".equals(dlgn0210dto.getOffdayKubn()) || "2".equals(dlgn0210dto.getOffdayKubn())){
//	 					MessageBox.info("", "휴일일경우 연장근무시간, 야근근무시간 입력 안됩니다.", null);
//		 				return;
//	 				}
//	 			}
//	 			if(!"".equals(dlgn0210dto.getDilnlazNtotTm())){
//	 				if("1".equals(dlgn0210dto.getOffdayKubn()) || "2".equals(dlgn0210dto.getOffdayKubn())){
//	 					MessageBox.info("", "휴일일경우 연장근무시간, 야근근무시간 입력 안됩니다.", null);
//		 				return;
//	 				}
//	 			}
//	 			if((!"".equals(dlgn0210dto.getDilnlazTmRstDutyTm()) && !"".equals(dlgn0210dto.getDilnlazNtotTm()))){
//	 				if("1".equals(dlgn0210dto.getOffdayKubn()) || "2".equals(dlgn0210dto.getOffdayKubn())){
//	 					MessageBox.info("", "휴일일경우 연장근무시간, 야근근무시간 입력 안됩니다.", null);
//		 				return;
//	 				}
//	 			}
//	 			// 평일일경우 휴일근무, 휴일연장에 입력 못하게 처리.
//	 			if(!"".equals(dlgn0210dto.getDilnlazHodyDutyTm())){
//	 				if("0".equals(dlgn0210dto.getOffdayKubn())){
//	 					MessageBox.info("", "평일일경우 휴일근무시간, 휴일연장근무시간 입력 안됩니다.", null);
//		 				return;
//	 				}
//	 			}
//	 			if(!"".equals(dlgn0210dto.getDilnlazHodyNtotTm())){
//	 				if("0".equals(dlgn0210dto.getOffdayKubn())){
//	 					MessageBox.info("", "평일일경우 휴일근무시간, 휴일연장근무시간 입력 안됩니다.", null);
//		 				return;
//	 				}
//	 			}
//	 			if((!"".equals(dlgn0210dto.getDilnlazHodyDutyTm()) && !"".equals(dlgn0210dto.getDilnlazHodyNtotTm()))){
//	 				if("0".equals(dlgn0210dto.getOffdayKubn())){
//	 					MessageBox.info("", "평일일경우 휴일근무시간, 휴일연장근무시간 입력 안됩니다.", null);
//		 				return;
//	 				}
//	 			}
	 			
	 			if(dlgn0210dto.getDilnlazDutyStTm().length() == 4 
	 					|| dlgn0210dto.getDilnlazDutyEdTm().length() == 4){
	 				MessageBox.info("", "시작,종료시간 입력형식은 hh:mm 입니다.", null);
	 				return;
	 			}
	 			if(!"".equals(dlgn0210dto.getDilnlazTmRstDutyTm())){
		 			if(dlgn0210dto.getDilnlazTmRstDutyTm().length() != 5 || !dlgn0210dto.getDilnlazTmRstDutyTm().contains(":")){
		 					MessageBox.info("", "근무시간 입력방식은 hh:mm 입니다.", null);
		 					return;
		 			}
	 			}
	 			if(!"".equals(dlgn0210dto.getDilnlazNtotTm())){
		 			if(dlgn0210dto.getDilnlazNtotTm().length() != 5 || !dlgn0210dto.getDilnlazNtotTm().contains(":")){
		 					MessageBox.info("", "근무시간 입력방식은 hh:mm 입니다.", null);
		 					return;
		 			}
	 			}
	 			if(!"".equals(dlgn0210dto.getDilnlazHodyDutyTm())){
		 			if(dlgn0210dto.getDilnlazHodyDutyTm().length() != 5 || !dlgn0210dto.getDilnlazHodyDutyTm().contains(":")){
		 					MessageBox.info("", "근무시간 입력방식은 hh:mm 입니다.", null);
		 					return;
		 			}
	 			}
	 			if(!"".equals(dlgn0210dto.getDilnlazHodyNtotTm())){
		 			if(dlgn0210dto.getDilnlazHodyNtotTm().length() != 5 || !dlgn0210dto.getDilnlazHodyNtotTm().contains(":")){
		 					MessageBox.info("", "근무시간 입력방식은 hh:mm 입니다.", null);
		 					return;
		 			}
	 			}
	 			
//	 			if(dlgn0210dto.getDilnlazTmRstDutyTm().length() == 5){
//	 				if(Integer.parseInt(dlgn0210dto.getDilnlazTmRstDutyTm().replace(":", "")) > 400){
//		 				MessageBox.info("", "연장근무시간 최대 입력시간은 04:00 입니다.", null);
//		 				return;
//	 				}
//	 			}
//	 			
//	 			if(dlgn0210dto.getDilnlazHodyDutyTm().length() == 5){
//	 				if(Integer.parseInt(dlgn0210dto.getDilnlazHodyDutyTm().replace(":", "")) > 800){
//		 				MessageBox.info("", "휴일근무시간 최대 입력시간은 08:00 입니다.", null);
//		 				return;
//	 				}
//	 			}
	 			
//	 			if(!"".equals(dlgn0210dto.getDilnlazNtotTm())){
//	 				if("".equals(dlgn0210dto.getDilnlazTmRstDutyTm())){
//	 					MessageBox.info("", "연장근무시간부터 입력해주세요.", null);
//	 					return;
//	 				}
//	 			}
	 			
	 		//service 구현
	 		dlgn0210Service.updateDlgn0210Grid(listDlgn0210_1dto, new AsyncCallback<Long>(){
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
	 					Dlgn0200Grid0210.reload();
	 				} else {
	 				}
	 			}    		
	 		
	 		});
	              	}
	 			 }
	 		 }); 
	      }
		} 
		//기준일 전
		if (!(Dlgn0200Grid0210_1.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)){
			if ((Dlgn0200Grid0210_1.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)
					  &&!(Dlgn0200Grid0210.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0)){ 
	            
	            MessageBox.alert("근태정보", "저장할 근태정보가 존재하지 않습니다.", null);
	            return;
	      }else{
	    	  MessageBox.confirm("저장", "데이터를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
	    			 
	 			 @Override
	              public void handleEvent(MessageBoxEvent be) {
	                 // if("Yes".equals(be.getButtonClicked().getText())){
	              	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	 			Iterator<Record> iterRecords = Dlgn0200Grid0210_1.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
	 			List<Dlgn0210DTO> listDlgn0210_1dto = new ArrayList<Dlgn0210DTO>();
	 			Dlgn0210DTO dlgn0210dto = null;
	 			
	 			while (iterRecords.hasNext()) {
	 			dlgn0210dto = new Dlgn0210DTO();
	 			Record recData = (Record) iterRecords.next(); 
	 			BaseModel bmMapModel = (BaseModel)recData.getModel();
	 			
	 			dlgn0210dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** column 사업장코드 : dpobCd */
	 			dlgn0210dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
	 			dlgn0210dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd")));			/** column 급여구분 : payCd */
//	 			dlgn0210dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
	 			dlgn0210dto.setEmymtDivCd(detailEmymtDivCd.getValue());    /** column 고용구분코드 : emymtDivCd */
	 			dlgn0210dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
	 			dlgn0210dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
	 			dlgn0210dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
	 			dlgn0210dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세구분코드 : dtilOccuInttnCd */

                
	 			dlgn0210dto.setDilnlazExceDutyYrMnth(detailYm.getValue().replaceAll("\\.",""));		/** column 근무년월 : detailYm */
	 			dlgn0210dto.setDilnlazApptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazApptnDt")));		/** column 근태일자 : dilnlazApptnDt */
	 			dlgn0210dto.setDilnlazDutyStTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyStTm")));	/** column 시작시간 : dilnlazDutyStTm */
	 			dlgn0210dto.setDilnlazDutyEdTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazDutyEdTm")));	/** column 종료시간 : dilnlazDutyEdTm */
	 			dlgn0210dto.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazTmRstDutyTm")));		/** column 연장근무시간 : dilnlazTmRstDutyTm */
	 			dlgn0210dto.setDilnlazNtotTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazNtotTm")));		/** column 야간근무시간 : dilnlazNtotTm */
	 			dlgn0210dto.setDilnlazHodyDutyTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHodyDutyTm")));		/** column 휴일근무시간 : dilnlazHodyDutyTm */
	 			dlgn0210dto.setDilnlazHodyNtotTm(MSFSharedUtils.allowNulls(bmMapModel.get("dilnlazHodyNtotTm")));		/** column 휴일연장근무시간 : dilnlazHodyDutyRstTm */
	 			
	 			listDlgn0210_1dto.add(dlgn0210dto);
	 			
	 		}
	 		//validation 구현
	 		//service 구현
	 		dlgn0210Service.updateDlgn0210GridPre(listDlgn0210_1dto, new AsyncCallback<Long>(){
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
	 					Dlgn0200Grid0210_1.reload();
	 				} else {
	 				}
	 			}    		
	 		
	 		});
	              	}
	 			 }
	 		 }); 
	      }
		
		}
	} 
	
	
	
	//TODO 검색필드 시작
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
		//호봉
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	       
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//월  
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	         
		lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
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
		lscrPayCd = lsPayCd; 
		lscrEmymtDivCd = lsEmymtDivCd;   
		lscreRepbtyBusinDivCd = lsRepbtyBusinDivCd;
	      
		plFrmDlgn0200.setLayout(new FlowLayout());
	        
	    srhSystemkey = new HiddenField<String>(); 
	    
	    creHanNm = new HiddenField<String>(); 
	    creSecRegnNum = new HiddenField<String>(); 
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
	    					checkDlgn0200Auth("srhPayYr", lsPayYrStore); 
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
	        		checkDlgn0200Auth("srhPayMonth", lsPayMonth); 
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
	        				checkDlgn0200Auth("srhEmymtDivCd", lsEmymtDivCd ); 
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
//	        				checkDlgn0200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
	        				checkDlgn0200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	        		}
	            }
	        });    
	        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	        		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리  
	        		srhDeptCd.reset();  //2015.12.07 추가 
	        		sysComBass0400Dto.setDeptDspyYn("Y");
	                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
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
	        
	        
//	        LayoutContainer layoutContainer_14 = new LayoutContainer(new ColumnLayout());
//	        layoutContainer_14.setBorders(false); 
//	        
//	        LayoutContainer layoutContainer_111 = new LayoutContainer();
//	      
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(60); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_111.setLayout(frmlytSch);
//	        
//	        srhEmymtDivCd =  new ComboBox<BaseModel>(); 
//	        srhEmymtDivCd.setName("srhEmymtDivCd");
//	        srhEmymtDivCd.setForceSelection(true);
//	        srhEmymtDivCd.setMinChars(1);
//	        srhEmymtDivCd.setDisplayField("commCdNm");
//	        srhEmymtDivCd.setValueField("commCd");
//	        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
//	        srhEmymtDivCd.setEmptyText("--고용구분선택--");
//	        srhEmymtDivCd.setSelectOnFocus(true); 
//	        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//	        srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());  
//	        srhEmymtDivCd.setStore(lsEmymtDivCd);
//	        srhEmymtDivCd.setFieldLabel("고용구분");
//	        lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//	        	public void handleEvent(StoreEvent<BaseModel> be) {  
//	        		EventType type = be.getType();
//	        		if (type == Store.Add) { 
//	        			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//	        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//	  						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	        				checkDlgn0200Auth("srhEmymtDivCd", lsEmymtDivCd ); 
//	        		} 
//	            }
//	        });    
//	        srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	        		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	        		BaseModel bmPayCd =  se.getSelectedItem(); 
//	        		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
//	        			srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
//	        			srhBusinCd.setEnabled(true);
//	        			srhTypOccuCd.reset();
//	        			srhTypOccuCd.setEnabled(false);
//	        			srhDtilOccuInttnCd.reset();
//	        			srhDtilOccuInttnCd.setEnabled(false);
//	        		} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
//	        			//20151130 추가 수정 
//	        			srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//		            	srhBusinCd.reset();
//	                    srhBusinCd.setEnabled(false);   
//	                    
//	                    if (gwtExtAuth.getEnableTypOccuCd()) {
//	                    	srhTypOccuCd.setEnabled(true);
//	                    	srhDtilOccuInttnCd.setEnabled(true); 
//	                    } else {
//	                    	srhTypOccuCd.setEnabled(false);
//	                    	srhDtilOccuInttnCd.setEnabled(false);
//	                    }
//	        		}  
//	            } 
//	        });
//	        layoutContainer_111.add(srhEmymtDivCd, new FormData("100%"));
//	        layoutContainer_14.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//	        
//	        
//		    
//		    LayoutContainer layoutContainer_101 = new LayoutContainer();
//			layoutContainer_101.setBorders(false);
//
//		    frmlytSch = new FormLayout();
//		    frmlytSch.setDefaultWidth(0);
////		    frmlytSch.setLabelWidth(0); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_101.setLayout(frmlytSch);
//		    
//		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
//		    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
//		    srhRepbtyBusinDivCd.setHideLabel(true);
//		    srhRepbtyBusinDivCd.setForceSelection(true);
//		    srhRepbtyBusinDivCd.setAllowBlank(false);
//		    srhRepbtyBusinDivCd.setMinChars(1);
//		    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
//		    srhRepbtyBusinDivCd.setValueField("commCd");
//		    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
//		    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
//		    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
//		    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//		    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
//		    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
//		    srhRepbtyBusinDivCd.setLabelSeparator("");
//	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
//		    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//	              
//	            }
//	        });  
//		    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
//		    layoutContainer_14.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	        
//	        LayoutContainer layoutContainer_14 = new LayoutContainer();
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(60); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//	        layoutContainer_14.setLayout(frmlytSch);
//	        
//	        srhPayCd =  new ComboBox<BaseModel>(); 
//	        srhPayCd.setName("srhPayCd");
//	        srhPayCd.setForceSelection(true);
//	        srhPayCd.setMinChars(1);
//	        srhPayCd.setDisplayField("commCdNm");
//	        srhPayCd.setValueField("commCd");
//	        srhPayCd.setTriggerAction(TriggerAction.ALL);
//	        srhPayCd.setEmptyText("--급여구분선택--");
//	        srhPayCd.setSelectOnFocus(true); 
//	        srhPayCd.setReadOnly(false);
//	        srhPayCd.setEnabled(true); 
//	        srhPayCd.setStore(lsPayCd);
//	        srhPayCd.setFieldLabel("급여구분");
//	        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//	           	   EventType type = be.getType();
//		    	   if (type == Store.Add) { 
//             		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//             		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//             		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//             		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//		    			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    		   checkDlgn0200Auth("srhPayCd", lsPayCd); 
//		    	   }
//	            }
//	        });    
//	        
//	        layoutContainer_14.add(srhPayCd, new FormData("100%"));
	       
	        layoutContainer_14.setBorders(false);
	        
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
	        
//	        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 
//	        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//	        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//	        lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        
	        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 작업년월
	        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
	        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
//	        lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        

	        
	        
	        
	        LayoutContainer layoutContainer_13 = new LayoutContainer();
	        layoutContainer_13.setLayout(new ColumnLayout());
	        
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
		    		   checkDlgn0200Auth("srhPayCd", lsPayCd); 
		    	   }
	            }
	        });    
	        
	        layoutContainer_1.add(srhPayCd, new FormData("100%"));
	        
	        
	        
	        
	        
	        
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
	        				checkDlgn0200Auth("srhDeptCd", lsDeptCd); 
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
		                	//checkDlgn0200Auth("srhTypOccuCd", lsTypOccuCd); 
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
	        
	        
//	        layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
//	        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//	        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//	        layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	        
	        layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 급여구분
	        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));// 부서
	        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 직종
	        
	        fieldSet.add(layoutContainer_13);
	        
	        
	        
	        LayoutContainer lcSchCol3 = new LayoutContainer();
	        lcSchCol3.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_16 = new LayoutContainer();
	        
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_16.setLayout(frmlytSch);
	        
	        
	        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 사업
	        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 출력조건
	        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 성명
	        
	        fieldSet.add(lcSchCol3, new FormData("100%"));
	        
	        
	        
	        
	        plFrmDlgn0200.add(fieldSet); 
	} 
	
	//근태생성부
	private void createXlsForm() {
		  
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
     						checkDlgn0200Auth("creYear", lscrPayYr); 
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
     				} else {
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
       			checkDlgn0200Auth("creMonth", lscrPayMonth); 
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
					checkDlgn0200Auth("crePayrMangDeptCd", lscrPayrMangDeptCd);
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
					checkDlgn0200Auth("creEmymtDivCd", lscrEmymtDivCd);
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
              
		
	    
	    
		LayoutContainer lc41 = new LayoutContainer(new ColumnLayout());
//		FormLayout fl2 = new FormLayout();
//		fl2.setLabelWidth(60);
//		fl2.setLabelAlign(LabelAlign.RIGHT);
//		lc41.setLayout(fl2);
		         
//		LayoutContainer lc2_1 = new LayoutContainer(new ColumnLayout());
              
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
              

//		layoutContainer21.add(lc11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
//		layoutContainer21.add(lc21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		layoutContainer21.add(lc31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		layoutContainer21.add(lc41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
      	
		layoutContainer21.add(lc11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer21.add(lc21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainer21.add(lc31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));

		
		
		LayoutContainer layoutContainer = new LayoutContainer(new ColumnLayout());
		layoutContainer.setBorders(false);
		
		
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
					checkDlgn0200Auth("crePayCd", lscrPayCd);
				}
			}
		});

		lc1.add(crePayCd, new FormData("100%"));

		
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
					checkDlgn0200Auth("creDeptCd", lscrDeptCd);
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
					// checkDlgn0200Auth("creTypOccuCd", lscrTypOccuCd);
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
		
		
		

//		layoutContainer.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
//		layoutContainer.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		layoutContainer.add(lc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		layoutContainer.add(lc4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		
		
		layoutContainer.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		layoutContainer.add(lc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		
		
		
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
		
		
        LayoutContainer layoutContainer_16 = new LayoutContainer();
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_16.setLayout(frmlytSch);
        
        
        lcSchCol3.add(lc4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));					// 사업
        lcSchCol3.add(lc41,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));					// 성명
        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
       
        
		
		
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

		/*
		Button btnDlgn0250down = new Button("양식다운로드");
		btnDlgn0250down.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//TODO 다시
				// xlsExportData();
			}
		});
		

		layoutContainer_3.add(btnDlgn0250down, new FormData("100%"));
		*/
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_1.add(layoutContainer_5, new FormData("100%"));
		layoutContainer_5.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmlytSch);
		
		
		
		//--
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
         
         dlgn0200flUp = new FileUploadField();
         dlgn0200flUp.setName("dlgn0200flUp");
         dlgn0200flUp.setValidator(new Validator() {  
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
         
         layoutContainer_22.add(dlgn0200flUp, new FormData("100%"));
         dlgn0200flUp.setFieldLabel("근무실적");
          
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
         
		btnDlgn0200Upload = new Button("실적업로드");
		btnDlgn0200Upload.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsImportData();
//				Dlgn0200Grid0210.reload(); //TODO 그리드 reload 위치 다시.
			}
		});
		  layoutContainer_44.add(btnDlgn0200Upload, new FormData("100%"));
	      layoutContainer_11.add(layoutContainer_44, new FormData("100%"));
          layoutContainer_44.setBorders(false);
          
          LayoutContainer layoutContainer_33 = new LayoutContainer();
          layoutContainer_11.add(layoutContainer_33, new FormData("100%"));
          layoutContainer_33.setStyleAttribute("paddingRight", "10px");
          frmlytSch = new FormLayout();  
          frmlytSch.setLabelWidth(100); 
          frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
          layoutContainer_33.setLayout(frmlytSch);
		
		btnDlgn0200DownLoad = new Button("양식다운로드");
		btnDlgn0200DownLoad.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportData();
			}
		});
		
		
		layoutContainer_33.add(btnDlgn0200DownLoad, new FormData("100%"));
		layoutContainer_33.setBorders(false);
		
		LayoutContainer layoutContainer_55 = new LayoutContainer();
        layoutContainer_11.add(layoutContainer_55, new FormData("100%"));
        layoutContainer_55.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(100); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
        layoutContainer_55.setLayout(frmlytSch);
		
		Button btnDlgn0200CreateSingle = new Button("근태 개별생성");
		btnDlgn0200CreateSingle.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// TODO 다시
				dlgn0200Grid.getStore().removeAll();
				String year = DlgnUtils.getSelectedComboValue(creYear,"year");
				String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
				String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
				String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
				String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
				String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
				String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd");
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
		
		layoutContainer_55.add(btnDlgn0200CreateSingle, new FormData("100%"));
		layoutContainer_55.setBorders(false);
		
		LayoutContainer layoutContainer_66 = new LayoutContainer();
        layoutContainer_11.add(layoutContainer_66, new FormData("100%"));
        layoutContainer_66.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(100); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
        layoutContainer_66.setLayout(frmlytSch);
        
		
		Button btnDlgn0200Create = new Button("근태 일괄생성");
		btnDlgn0200Create.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				creSystemkey.setValue("");	//근태 개별 생성 후 일괄 생성할 경우 systemkey 들어가면 안되기 때문에
				
				// TODO 다시
				createDlgn0200Data();
			}
		});
		
		layoutContainer_66.add(btnDlgn0200Create, new FormData("100%"));
		layoutContainer_66.setBorders(false);
//		
//		buttonBar.add(layoutContainer_11);
//		buttonBar.add(btnDlgn0100DownLoad);
//		buttonBar.add(btnDlgn0250CreateSingle);
//		buttonBar.add(btnDlgn0250Create);
////		layoutContainer_5.add(layoutContainer_11);
//		layoutContainer_5.add(buttonBar);
//		//--
		
		
		//--
//		ButtonBar dlgn0250BtnBar = new ButtonBar();
//		dlgn0250BtnBar.setAlignment(HorizontalAlignment.RIGHT);
//		
//		Button btnDlgn0250CreateSingle = new Button("근태 개별생성");
//		btnDlgn0250CreateSingle.addListener(Events.Select,new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				// TODO 다시
//				dlgn0210Grid.getStore().removeAll();
//				
//				String year = DlgnUtils.getSelectedComboValue(creYear,"year");
//				String month = DlgnUtils.getSelectedComboValue(creMonth,"month");
//				String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
//				String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");
//				String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
//				String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");
//				String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//				String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd");
//				String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd"); 
//					
//				boolean doAction = false;
//				String message = "근태생성 조건 : ";
//				
//				if("".equals(year) || "".equals(month)){
//					MessageBox.info("", message+"작업년월은 필수 입니다.", null);
//				}else if("".equals(workDayS) || "".equals(workDayE)){
//					MessageBox.info("", message+"근태기간은 필수 입니다.", null);
//				}else if("".equals(payrMangDeptCd) || "".equals(payrMangDeptCd)){
//					MessageBox.info("", message+"단위기관은 필수 입니다.", null);
//				}else if("".equals(payCd)){
//					MessageBox.info("", message+"급여구분은 필수 입니다.", null);
//				}else if("".equals(emymtDivCd) || "".equals(emymtDivCd)){
//					MessageBox.info("", message+"고용구분은 필수 입니다.", null);
//				}else if("".equals(emymtDivCd) || "".equals(deptCd)){
//					MessageBox.info("", message+"부서는 필수 입니다.", null);
//				}else if(GregorianCalendar.compareDate(creWorkDayS.getValue(), creWorkDayE.getValue()) < 0){
//					MessageBox.info("", message+"근태기간 설정이 이상합니다. 확인하십시요.", null);  
//				} else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {    
//					if("".equals(businCd)){
//						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), message+"사업명을 선택하십시요.", null);
//         		     } else {
//         		    	doAction = true;
//         		     }
//				} else {
//					doAction = true;
//				}
//						
//				if(doAction) {
//            	  fnPopupPsnl0100("DLGN");
//				}
//			}
//		});
//
////		layoutContainer_5.add(btnDlgn0250Create, new FormData("100%"));
//		dlgn0250BtnBar.add(btnDlgn0250CreateSingle);
//
//		Button btnDlgn0250Create = new Button("근태 일괄생성");
//		btnDlgn0250Create.addListener(Events.Select,new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				createDlgn0200Data();
//			}
//		});
//
////		layoutContainer_5.add(btnDlgn0250Create, new FormData("100%"));
//		dlgn0250BtnBar.add(btnDlgn0250Create);
//		
//		layoutContainer_5.add(dlgn0250BtnBar);
//		layoutContainer_5.setBorders(false);
		//--
		fldstNewFieldset.add(layoutContainer21, new FormData("100%"));
		fldstNewFieldset.add(layoutContainer, new FormData("100%"));
		fldstNewFieldset.add(lcSchCol3, new FormData("100%"));
		fldstNewFieldset.add(layoutContainer_1, new FormData("100%"));
		fldstNewFieldset.add(layoutContainer_11, new FormData("100%"));

		fldstNewFieldset.setHeadingHtml("초과근무생성");

		plFrmDlgn0200.add(fldstNewFieldset);
		  
	}	
	
	

	//TODO 중간 근태생성 필드 시작
	private void createStandardForm() {
		
		
		
		LayoutContainer lcButtom = new LayoutContainer(new ColumnLayout());
		
		
		
		LayoutContainer leftGrid = new LayoutContainer();
		FieldSet fieldGridLeft = new FieldSet();
		fieldGridLeft.setSize("330px", "402px");
		fieldGridLeft.setHeadingHtml("근로자정보");
		fieldGridLeft.setCollapsible(false);
		fieldGridLeft.setStyleAttribute("paddingLeft", "5px");
		fieldGridLeft.setStyleAttribute("paddingRight", "5px");
		fieldGridLeft.add(occupationalLeft(), new FormData("100%"));
		leftGrid.add(fieldGridLeft);
		
		
		LayoutContainer rightGrid = new LayoutContainer();
		
		FieldSet fieldRightForm = new FieldSet();
//		fieldRightForm.setSize("625px", "120px");
		fieldRightForm.setSize("635px", "70px");
		fieldRightForm.setHeadingHtml("근태상세정보");
		fieldRightForm.setCollapsible(false);
		fieldRightForm.add(occupationalRTop(), new FormData("100%"));
		rightGrid.add(fieldRightForm);

		FieldSet fieldRightGrid = new FieldSet();
//		fieldRightGrid.setSize("625px", "280px");
		fieldRightGrid.setSize("635px", "330px");
		fieldRightGrid.setHeadingHtml("근무내역등록");
		fieldRightGrid.setStyleAttribute("paddingLeft", "5px");
		fieldRightGrid.setStyleAttribute("paddingRight", "5px");
		fieldRightGrid.setCollapsible(false);
		fieldRightGrid.add(occupationalRBottom(), new FormData("100%"));
		rightGrid.add(fieldRightGrid);
		
		lcButtom.add(leftGrid);
		lcButtom.add(rightGrid);
		
		LayoutContainer layoutContainer_81 = new LayoutContainer();

		lblfldNewLabelfield_16 = new LabelField(
				"* 근무내역등록 수정 할 때 시간은 무조건 hh:mm 형식으로 입력하세요. 그 외 형식은 수정 안됩니다.");
		layoutContainer_81.add(lblfldNewLabelfield_16);
		lcButtom.add(layoutContainer_81, new FormData("100%"));
		
		LayoutContainer layoutContainer_82 = new LayoutContainer();
		
		lblfldNewLabelfield_17 = new LabelField(
				"* ex : 분만 입력시 00:03 , 수정가능항목 : (시작시간, 종료시간, 근무시간), 퇴근시간컬럼은 수정 안됩니다.");
		layoutContainer_82.add(lblfldNewLabelfield_17);
		lcButtom.add(layoutContainer_82, new FormData("100%"));
		
		LayoutContainer layoutContainer_83 = new LayoutContainer();
		
		lblfldNewLabelfield_18 = new LabelField(
				"* 연장, 야근, 휴일근무시간 데이터 있을 경우 종료시간 수정시 초기화 됩니다. ");
		layoutContainer_83.add(lblfldNewLabelfield_18);
		lcButtom.add(layoutContainer_83, new FormData("100%"));
		
		LayoutContainer layoutContainer_84 = new LayoutContainer();
		
		lblfldNewLabelfield_19 = new LabelField(
				"* 연장근무시간 최대입력시간 04:00, 휴일근무시간 최대입력시간 08:00 입니다.");
		layoutContainer_84.add(lblfldNewLabelfield_19);
		lcButtom.add(layoutContainer_84, new FormData("100%"));
		
		
		plFrmDlgn0200.add(lcButtom);
		
	}
	
	
	//TODO 근태상세정보 시작
	private LayoutContainer occupationalRTop() {
	    
	    detailEmymtDivCd = new HiddenField<String>();

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(630, 50);

		LayoutContainer lytCtr01 = new LayoutContainer();
		lytCtr01.setLayout(new FlowLayout());
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);
		detailName = new TextField<String>();
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

		detailRegnNum = new TextField<String>();
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
		
		detailDeptNm = new  TextField<String>();
		detailDeptNm.setFieldLabel("부서명");
		detailDeptNm.setReadOnly(true);
		lcDeptNm.add(detailDeptNm, new FormData("100%"));
		
		layoutContainer_5.add(lcDeptNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
			
			
		LayoutContainer layoutContainer_89 = new LayoutContainer();
			
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_89.setLayout(frmlytStd);
		
		detailTypOccuNm = new TextField<String>();
		detailTypOccuNm.setFieldLabel("직종(사업)");
		detailTypOccuNm.setReadOnly(true);
		
		layoutContainer_89.add(detailTypOccuNm, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_89, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
			
		lytCtr01.add(layoutContainer_5);
		
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);

		detailYm = new  TextField<String>();
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
		
		
		detailWorkDayS = new TextField<String>();
		detailWorkDayS.setFieldLabel("근태기간");
		detailWorkDayS.setReadOnly(true);
     	layoutContainer_3.add(detailWorkDayS, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
			

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		detailWorkDayE= new  TextField<String>();
		detailWorkDayE.setLabelSeparator("~");
		detailWorkDayE.setReadOnly(true);
		layoutContainer_4.add(detailWorkDayE, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		
		
		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(65);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
		LabelField labelField = new LabelField();
		labelField.setFieldLabel("휴가 : ");
		layoutContainer_8.add(labelField, new FormData("100%"));
		layoutContainer.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		
		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		
		detailDtilOccuInttnNm = new  TextField<String>();
		detailDtilOccuInttnNm.setLabelSeparator("");
		detailDtilOccuInttnNm.setWidth(0);
		detailDtilOccuInttnNm.setReadOnly(true);
		layoutContainer_14.add(detailDtilOccuInttnNm, new FormData("100%"));
		detailDtilOccuInttnNm.hide();

		detailBusinNm = new  TextField<String>();
		detailBusinNm.setFieldLabel("사업명");
		detailBusinNm.setReadOnly(true);
		layoutContainer_14.add(detailBusinNm, new FormData("100%"));
		detailBusinNm.hide();
		
		detailEmymtBgnnDt = new TextField<String>();
		detailEmymtBgnnDt.setFieldLabel("시작일자");
		detailEmymtBgnnDt.setReadOnly(true);
		layoutContainer_14.add(detailEmymtBgnnDt, new FormData("100%"));
		detailEmymtBgnnDt.hide();
		
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytStd);

		detailEmymtEndDt = new TextField<String>();
		detailEmymtEndDt.setFieldLabel("종료일자");
		detailEmymtEndDt.setReadOnly(true);
		detailEmymtEndDt.hide();
		layoutContainer_14.add(detailEmymtEndDt, new FormData("100%"));
		
		layoutContainer.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		
		lytCtr01.add(layoutContainer);
		cp01.add(lytCtr01);
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	
	/**
	private LayoutContainer occupationalRTop() {
	    
	    detailEmymtDivCd = new HiddenField<String>();

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
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

		detailYm = new TextField<String>();
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

		detailWorkDayS = new TextField<String>();
		detailWorkDayS.setFieldLabel("근태기간");
		detailWorkDayS.setReadOnly(true);
		layoutContainer_3.add(detailWorkDayS, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		detailWorkDayE= new TextField<String>();
		detailWorkDayE.setLabelSeparator("~");
		detailWorkDayE.setReadOnly(true);
		layoutContainer_4.add(detailWorkDayE, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_4.setBorders(false);
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);

		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		lytCtr01.add(layoutContainer);
		layoutContainer.setBorders(false);

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		detailName = new TextField<String>();
		detailName.setFieldLabel("성 명");
		detailName.setReadOnly(true);
		layoutContainer_6.add(detailName, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		detailRegnNum = new TextField<String>();
		detailRegnNum.setFieldLabel("주민번호");
		detailRegnNum.setReadOnly(true);
		layoutContainer_7.add(detailRegnNum, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
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
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
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

		detailDeptNm = new TextField<String>();
		detailDeptNm.setFieldLabel("부서명");
		detailDeptNm.setReadOnly(true);
		layoutContainer_10.add(detailDeptNm, new FormData("100%"));
		layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);
		
		LayoutContainer layoutContainer_24 = new LayoutContainer();
		layoutContainer_24.setLayout(new ColumnLayout());
		
		LayoutContainer lcTypOccuNm = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuNm.setLayout(frmlytStd);

		detailTypOccuNm = new TextField<String>();
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

		detailDtilOccuInttnNm = new TextField<String>();
		detailDtilOccuInttnNm.setLabelSeparator("");
		detailDtilOccuInttnNm.setWidth(0);
		detailDtilOccuInttnNm.setReadOnly(true);
		lcDtilOccuInttnNm.add(detailDtilOccuInttnNm, new FormData("100%"));
		layoutContainer_24.add(lcDtilOccuInttnNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcDtilOccuInttnNm.setBorders(false);
		
		layoutContainer_9.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);

		detailBusinNm = new TextField<String>();
		detailBusinNm.setFieldLabel("사업명");
		detailBusinNm.setReadOnly(true);
		layoutContainer_11.add(detailBusinNm, new FormData("100%"));
		layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
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

		detailEmymtBgnnDt = new TextField<String>();
		detailEmymtBgnnDt.setFieldLabel("시작일자");
		detailEmymtBgnnDt.setReadOnly(true);
		layoutContainer_13.add(detailEmymtBgnnDt, new FormData("100%"));
		layoutContainer_12.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_13.setBorders(false);

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytStd);

		detailEmymtEndDt = new TextField<String>();
		detailEmymtEndDt.setFieldLabel("종료일자");
		detailEmymtEndDt.setReadOnly(true);
		layoutContainer_14.add(detailEmymtEndDt, new FormData("100%"));
		layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lytCtr01.add(layoutContainer_12);
		layoutContainer_12.setBorders(false);
		cp01.add(lytCtr01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	**/ 
	
	
	
	
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
		
		cpGrid = new ContentPanel(); //기준일 후 grid
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());      
//		cpGrid.setSize(620, 260);
		cpGrid.setSize(620, 310);
		
		cpGrid_1 = new ContentPanel();
		cpGrid_1.setBodyBorder(false); 
		cpGrid_1.setHeaderVisible(false);   
		cpGrid_1.setLayout(new FitLayout());      
//		cpGrid_1.setSize(620, 260);
		cpGrid_1.setSize(620, 310);
		
		MSFCustomForm msfCustomForm = new MSFCustomForm(Dlgn0200Def, 0, 0, false, false, false);
	    msfCustomForm.setHeaderVisible(false);
		Dlgn0200Grid0210 = new MSFGridPanel(Dlgn0200Def, false, false, false, false, false);
		Dlgn0200Grid0210.setHeaderVisible(false);  
		Dlgn0200Grid0210.setBodyBorder(true);
		Dlgn0200Grid0210.setBorders(true);
		Dlgn0200Grid0210.getBottomComponent().setVisible(false);
		Dlgn0200Grid0210.setMSFFormPanel(msfCustomForm);
		Dlgn0200Grid0210.getGrid().getColumnModel().addHeaderGroup(0, 4, new HeaderGroupConfig("연장근무(시:분)", 1, 2));
		Dlgn0200Grid0210.getGrid().getColumnModel().addHeaderGroup(0, 6, new HeaderGroupConfig("야간근무(시:분)", 1, 2));
		Dlgn0200Grid0210.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("휴일근무(시:분)", 1, 2));
		Dlgn0200Grid0210.getGrid().getColumnModel().addHeaderGroup(0, 10, new HeaderGroupConfig("휴일연장근무(시:분)", 1, 2));
		GWTUtils.setGridCellRenderer(Dlgn0200Grid0210, "dilnlazApptnDt", cellRender); //content 는 컬럼명
		cpGrid.add(Dlgn0200Grid0210);
		
		final Grid dlgn0200Grid = Dlgn0200Grid0210.getMsfGrid().getGrid();
		dlgn0200Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {  
             if (Dlgn0200Grid0210.getCurrentlySelectedItem() != null) {      
            	 
            	 Dlgn0200Grid0210.getMSFFormPanel().bind(Dlgn0200Grid0210.getCurrentlySelectedItem());
            	 
            	 setRecord(Dlgn0200Grid0210.getCurrentlySelectedItem());
               
              } 
            }
        });
		
		MSFCustomForm msfCustomForm_1 = new MSFCustomForm(Dlgn0200Def_1, 0, 0, false, false, false);
		msfCustomForm_1.setHeaderVisible(false);
		Dlgn0200Grid0210_1 = new MSFGridPanel(Dlgn0200Def_1, false, false, false, false, false);
		Dlgn0200Grid0210_1.setHeaderVisible(false);  
		Dlgn0200Grid0210_1.setBodyBorder(true);
		Dlgn0200Grid0210_1.setBorders(true);
		Dlgn0200Grid0210_1.getBottomComponent().setVisible(false);
		Dlgn0200Grid0210_1.setMSFFormPanel(msfCustomForm_1);
		Dlgn0200Grid0210_1.getGrid().getColumnModel().addHeaderGroup(0, 4, new HeaderGroupConfig("연장근무(시:분)", 1, 2));
		Dlgn0200Grid0210_1.getGrid().getColumnModel().addHeaderGroup(0, 6, new HeaderGroupConfig("야근근무(시:분)", 1, 2));
		Dlgn0200Grid0210_1.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("휴일근무(시:분)", 1, 2));
		Dlgn0200Grid0210_1.getGrid().getColumnModel().addHeaderGroup(0, 10, new HeaderGroupConfig("휴일연장근무(시:분)", 1, 2));
		GWTUtils.setGridCellRenderer(Dlgn0200Grid0210_1, "dilnlazApptnDt", cellRender); //content 는 컬럼명
		cpGrid_1.add(Dlgn0200Grid0210_1);
		
		final Grid dlgn0200Grid1 = Dlgn0200Grid0210_1.getMsfGrid().getGrid();
		dlgn0200Grid1.addListener(Events.RowClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {  
             if (Dlgn0200Grid0210_1.getCurrentlySelectedItem() != null) {      
            	 
            	 Dlgn0200Grid0210_1.getMSFFormPanel().bind(Dlgn0200Grid0210_1.getCurrentlySelectedItem());
            	 
            	 setRecord(Dlgn0200Grid0210_1.getCurrentlySelectedItem());
               
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
	
	
	//TODO 근태관리대상자정보 그리드 시작
	private LayoutContainer occupationalLeft() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Dlgn0200DTO> sm = new CheckBoxSelectionModel<Dlgn0200DTO>();

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
		cp01.setSize(320, 380);

		dlgn0200Grid = new Grid<Dlgn0200DTO>(storeDlgn0200, cm);
		dlgn0200Grid.setStateful(true);
		dlgn0200Grid.setSelectionModel(sm);
		dlgn0200Grid.setBorders(true);
		dlgn0200Grid.setColumnReordering(true);
		dlgn0200Grid.setLoadMask(true);
		dlgn0200Grid.addPlugin(sm);
		dlgn0200Grid.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<Dlgn0200DTO>() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent<Dlgn0200DTO> se) {
				
				if(se.getSelection().size() > 0){
					
//					System.out.println("00001 "+ se.getSelectedItem().getDilnlazExceDutyYrMnth());
					
					detailYm.setValue(DateTimeFormat.getFormat("yyyy.MM").format(DateTimeFormat.getFormat("yyyyMM").parse(se.getSelectedItem().getDilnlazExceDutyYrMnth())));
					
					if("".equals(se.getSelectedItem().getDilnlazExceDutyBgnnDt()) || se.getSelectedItem().getDilnlazExceDutyBgnnDt() == null) {
						detailWorkDayS.setValue("");
					}else {
						detailWorkDayS.setValue(se.getSelectedItem().getDilnlazExceDutyBgnnDt().substring(0,4)+"."+se.getSelectedItem().getDilnlazExceDutyBgnnDt().substring(4,6)+"."+se.getSelectedItem().getDilnlazExceDutyBgnnDt().substring(6,8));
					}
					
					if("".equals(se.getSelectedItem().getDilnlazExceDutyEndDt()) || se.getSelectedItem().getDilnlazExceDutyEndDt() == null) {
						detailWorkDayE.setValue("");
					}else {
						detailWorkDayE.setValue(se.getSelectedItem().getDilnlazExceDutyEndDt().substring(0,4)+"."+se.getSelectedItem().getDilnlazExceDutyEndDt().substring(4,6)+"."+se.getSelectedItem().getDilnlazExceDutyEndDt().substring(6,8));
					}
					
//					detailWorkDayS.setValue(se.getSelectedItem().getDilnlazExceDutyBgnnDt().substring(0,4)+"."+se.getSelectedItem().getDilnlazExceDutyBgnnDt().substring(4,6)+"."+se.getSelectedItem().getDilnlazExceDutyBgnnDt().substring(6,8));
//					detailWorkDayE.setValue(se.getSelectedItem().getDilnlazExceDutyEndDt().substring(0,4)+"."+se.getSelectedItem().getDilnlazExceDutyEndDt().substring(4,6)+"."+se.getSelectedItem().getDilnlazExceDutyEndDt().substring(6,8));
					
					detailName.setValue(se.getSelectedItem().getHanNm());
					detailRegnNum.setValue(se.getSelectedItem().getResnRegnNum());
//					detailTypOccuNm.setValue(se.getSelectedItem().getTypOccuNm());
					detailEmymtDivCd.setValue(se.getSelectedItem().getEmymtDivCd());
					
					if(MSFConfiguration.EMYMT_DIVCD01.equals(detailEmymtDivCd.getValue())) {
						detailTypOccuNm.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getTypOccuNm()) + "(" + MSFSharedUtils.allowNulls(se.getSelectedItem().getDtilOccuInttnNm()) + ")");
					}else {
						detailTypOccuNm.setValue(MSFSharedUtils.allowNulls(se.getSelectedItem().getBusinCdNm()));
					}
					detailDtilOccuInttnNm.setValue(se.getSelectedItem().getDtilOccuInttnNm());
					detailDeptNm.setValue(se.getSelectedItem().getDeptCdNm());
					detailBusinNm.setValue(se.getSelectedItem().getBusinCdNm());
					detailEmymtBgnnDt.setValue(se.getSelectedItem().getEmymtBgnnDt());
					detailEmymtEndDt.setValue(se.getSelectedItem().getEmymtEndDt());
					
//					detailSystemkey.setValue(se.getSelectedItem().getSystemkey());
					BaseListLoadConfig bllc = new BaseListLoadConfig();
					bllc.set("getDpobCd", se.getSelectedItem().getDpobCd());
					bllc.set("getSystemkey", se.getSelectedItem().getSystemkey());
					bllc.set("getDilnlazExceDutyYrMnth", se.getSelectedItem().getDilnlazExceDutyYrMnth());
					bllc.set("getPayCd", se.getSelectedItem().getPayCd());

					loaderDlgn0210.load(bllc);
					IColumnFilter filters = null;
					
					Dlgn0200Grid0210.getTableDef().setTableColumnFilters(filters);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("detailYm", MSFSharedUtils.allowNulls(detailYm.getValue().replaceAll("\\.", "")), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("detailName", MSFSharedUtils.allowNulls(detailName.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("detailRegnNum", MSFSharedUtils.allowNulls(detailRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("detailBusinNm",MSFSharedUtils.getSelectedComboValue(srhBusinCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("detailEmymtBgnnDt", MSFSharedUtils.allowNulls(detailEmymtBgnnDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("detailEmymtEndDt", MSFSharedUtils.allowNulls(detailEmymtEndDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("detailEmymtDivCd",MSFSharedUtils.allowNulls(detailEmymtDivCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(bllc.get("getSystemkey")), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210.getTableDef().addColumnFilter("payCd", MSFSharedUtils.allowNulls(bllc.get("getPayCd")), SimpleColumnFilter.OPERATOR_EQUALS);
					
					Dlgn0200Grid0210_1.getTableDef().setTableColumnFilters(filters);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("detailYm", MSFSharedUtils.allowNulls(detailYm.getValue().replaceAll("\\.", "")), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("detailName", MSFSharedUtils.allowNulls(detailName.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("detailRegnNum", MSFSharedUtils.allowNulls(detailRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("detailBusinNm",MSFSharedUtils.getSelectedComboValue(srhBusinCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("detailEmymtBgnnDt", MSFSharedUtils.allowNulls(detailEmymtBgnnDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("detailEmymtEndDt", MSFSharedUtils.allowNulls(detailEmymtEndDt.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("detailEmymtDivCd",MSFSharedUtils.allowNulls(detailEmymtDivCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(bllc.get("getSystemkey")), SimpleColumnFilter.OPERATOR_EQUALS);
					Dlgn0200Grid0210_1.getTableDef().addColumnFilter("payCd", MSFSharedUtils.allowNulls(bllc.get("getPayCd")), SimpleColumnFilter.OPERATOR_EQUALS);
					
					
					
				}
				if((detailYmKubn.compareTo(detailYm.getValue().replaceAll("\\.", "")) >= 0 )){
					cpGrid_1.show();
					cpGrid.hide();
					Dlgn0200Grid0210_1.reload(); //기준일 전
				}else{
					cpGrid_1.hide();
					cpGrid.show();
					Dlgn0200Grid0210.reload(); //기준일 후
				}
			}
		});
		
		
		cp01.add(dlgn0200Grid);
		// grid.setWidth("480px");

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	 private void detailClear() {
		  	
		    Dlgn0200Grid0210_1.getMsfGrid().clearData();
		    Dlgn0200Grid0210.getMsfGrid().clearData();
		    detailYm.clear();				//작업년월
		    detailWorkDayS.clear();		//근태 시작기간
			detailWorkDayE.clear();		//근태 종료기간
			detailName.clear();			//성명
			detailRegnNum.clear();			//주민번호
			detailDeptNm.clear();			//부서명
			detailTypOccuNm.clear();		//직종명
			detailDtilOccuInttnNm.clear();	//직종세명
			detailBusinNm.clear();			//사업명
			detailEmymtBgnnDt.clear();		//계약일자
			detailEmymtEndDt.clear();		//종료일자
	  }
	 
	private void setInitDate() {
		   
		int maxDays = 0;
		   
			Calendar  intiCal =  Calendar.getInstance(); 
			intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creMonth,"month")) - 1, 1 );
			creWorkDayS.setValue(intiCal.getTime());
			maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);  
	       
//			if ("02".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 28) {
//				maxDays = 28;
//			} else if ("04".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	    maxDays = 30;
//	        } else if ("06".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	    maxDays = 30;
//	        } else if ("09".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	    maxDays = 30;
//	        } else if ("11".equals(DlgnUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//	    	    maxDays = 30; 
//	        }
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
	
	/** 근무실적생성  */
	private void createDlgn0200Data() {
				
		final String year = DlgnUtils.getSelectedComboValue(creYear,"year");		//년도
		final String month = DlgnUtils.getSelectedComboValue(creMonth,"month");		//월
		final String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS, "yyyyMMdd");	//근태시작기간
		final String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 	//근태종료기간
//		final String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd");	//단위기관 
		final String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");	//급여구분
		final String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");	//고용구분
		final String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd"); 		//부서
		final String typOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd");//직종 
		final String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");//직종세  
		final String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd"); 		//사업
		final String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"); //단위기관
       
		final Tracker tracker = new Tracker();
	   	tracker.setStatus(false);
	   	   
		MessageBox.confirm("근태 생성", "초과근무생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					
					
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
					}else{
						Dlgn0200DTO dto = new Dlgn0200DTO();
						
						String months = month;
						if(month.length() == 1) months = "0"+month;
						dto.setDilnlazExceDutyYrMnth(year+months);
						dto.setDilnlazExceDutyBgnnDt(workDayS);
						dto.setDilnlazExceDutyEndDt(workDayE);
						dto.setPayCd(payCd);
						dto.setEmymtDivCd(emymtDivCd);
						dto.setCurrAffnDeptCd(deptCd);
						dto.setTypOccuCd(typOccuCd);
						dto.setDtilOccuInttnCd(dtilOccuInttnCd);
						dto.setBusinCd(businCd);
						dto.setPayrMangDeptCd(payrMangDeptCd);		//단위기관
//						dto.setSystemkey(srhSystemkey.getValue());
						dto.setSystemkey(creSystemkey.getValue());
						
						  final MessageBox box = MessageBox.wait("초과근무실적", "초과근무실적 데이타 처리 중 입니다...", "초과근무실적 생성(삭제) 중...");
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
			                
						dlgn0200Service.generateWorkTime(dto,  new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
							
							@Override
							public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
								  tracker.setStatus(true);
									
								   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
	    		    			    
		   		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
		   		    		       msFwMessage.show();
		   		    		       showMessageForm.setMSFFormWindows(msFwMessage);
		                       
		                            
		     	                    reload();
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
				}
			}
		});
	} 
	
	private Dlgn0200 getThis() {
		return this;
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
                	  if("DLGN".equals(flag)) {
                		  
                		creSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   	//시스템키
  	                	creHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));			//성명
  	                	creResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));//주민번호
                		  
                    	createDlgn0200Data();  
                    	  
                      }else if("PSNL".equals(flag)) {
                    	  
                    	  srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   	//시스템키
                          srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));				//성명
                          srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));  //주민번호   
                          
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
	                    		String filename = MSFSharedUtils.allowNulls(dlgn0200flUp.getValue());
	                    		if (filename.length() == 0) {
	                    			Window.alert("선택된 파일이 없습니다.");
	                    		} else {
	                    			//submit the form
	                    			plFrmDlgn0200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                    			
	                    			//파일업로드 처리
	                    			plFrmDlgn0200.setAction(GWT.getHostPageBaseURL() + "imp/XlsDlgn0200Import.do");
	                    			plFrmDlgn0200.setEncoding(Encoding.MULTIPART);
	                    			plFrmDlgn0200.setMethod(Method.POST);   
//	                                     FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
//	                                     frmEl.setAcceptCharset("UTF-8"); 
	                    			plFrmDlgn0200.submit();  
	                    			plFrmDlgn0200.onFrameLoad();  
	                                picBoolFile = true;
	                    		}               
	                                  
	                    		// reset and unmask the form 
	                    		// after file upload 
	                    		plFrmDlgn0200.addListener(Events.Submit, new Listener<FormEvent>() {
	                    			public void handleEvent(FormEvent evt) {   
	                    				if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    					//업로드가  성공했으면 인서트 모듈을 태운다. 
	                    					plFrmDlgn0200.unmask();  
//	                    					MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
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
	                    	String filename = MSFSharedUtils.allowNulls(dlgn0200flUp.getValue());
	                    	
	                    	if (filename.length() == 0) {
	                              Window.alert("선택된 파일이 없습니다.");
	                    	} else {
	                    		//submit the form
	                    		plFrmDlgn0200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                    		
	                    		//파일업로드 처리
	                    		plFrmDlgn0200.setAction(GWT.getHostPageBaseURL() + "imp/XlsDlgn0200Import.do");
	                    		plFrmDlgn0200.setEncoding(Encoding.MULTIPART);
	                    		plFrmDlgn0200.setMethod(Method.POST);   
//	                               FormElement frmEl=FormElement.as(plFrmDlgn0250.getElement()); 
//	                               frmEl.setAcceptCharset("UTF-8"); 
	                    		plFrmDlgn0200.submit();  
	                    		plFrmDlgn0200.onFrameLoad();  
	                    		picBoolFile = true;
	                    	}               
	                            
	                    	// reset and unmask the form 
	                    	// after file upload 
	                    	plFrmDlgn0200.addListener(Events.Submit, new Listener<FormEvent>() {
	                    		public void handleEvent(FormEvent evt) {   
	                    			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    				//업로드가  성공했으면 인서트 모듈을 태운다. 
	                    				plFrmDlgn0200.unmask();  
//	                    				MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
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
	  
	  
private void xlsExportData() {
		  
		  String year = DlgnUtils.getSelectedComboValue(creYear, "year");
			String month = DlgnUtils.getSelectedComboValue(creMonth, "month");
			String payCd = DlgnUtils.getSelectedComboValue(crePayCd, "commCd");
			String workDayS = DlgnUtils.getConvertDateToString(creWorkDayS,"yyyyMMdd");
			String workDayE = DlgnUtils.getConvertDateToString(creWorkDayE,"yyyyMMdd");
			String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");

			// String deptCd = MSFSharedUtils.allowNulls(creCurrDeptCd.getValue());
			// String typOccuCd =
			// DlgnUtils.getSelectedComboValue(creTypOccuCd,"typOccuCd");

			String deptCd = DlgnUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(), "deptNmRtchnt", "deptCd");
			String typOccuCd = DlgnUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
			String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd, creDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");

			String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd");

			String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd, "payrMangDeptCd");

			HashMap<String, String> param = new HashMap<String, String>();

			param.put("jobYrMnth", year.concat(month));
			param.put("payCd", payCd);
			param.put("rflctnBgnnDt", workDayS);
			param.put("rflctnEndDt", workDayE);
			param.put("payrMangDeptCd", payrMangDeptCd);
			param.put("emymtDivCd", emymtDivCd);
			param.put("deptCd", deptCd);
			//param.put("typOccuCd", typOccuCd);
			// param.put("pyspGrdeCd", pyspGrdeCd);
			//param.put("dtilOccuInttnCd", dtilOccuInttnCd);
			//param.put("businCd", businCd);
			

			if ("".equals(year) || "".equals(month)) {
				MessageBox.info("", "작업년월은 필수 입니다.", null);
			} else if ("".equals(payCd)) {
				MessageBox.info("", "급여구분은 필수 입니다.", null);
			} else if ("".equals(workDayS) || "".equals(workDayE)) {
				MessageBox.info("", "근태기간은 필수 입니다.", null);

			} else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
				
				
				if ("".equals(businCd)) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
				} else {
				  GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsDlgn0200Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
//				  dlgn0100Grid.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsDlgn0100Export.do", "extgwtFrame", param);
				  
				}
			} else {
				
				 GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsDlgn0200Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
//				dlgn0100Grid.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsDlgn0100Export.do", "extgwtFrame", param);
			}
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
