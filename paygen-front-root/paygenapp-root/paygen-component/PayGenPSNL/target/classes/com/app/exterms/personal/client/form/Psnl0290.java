package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0126BM;
import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.client.form.defs.Psnl0126Def;
import com.app.exterms.personal.client.service.Psnl0100Service;
import com.app.exterms.personal.client.service.Psnl0100ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0290Service;
import com.app.exterms.personal.client.service.Psnl0290ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.lookup.LookupSysComYear;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ===================================================================  
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * ===================================================================  
 **/
public class Psnl0290 extends MSFPanel {

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 시작} 
	 * #######################################################	 
	 */

	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------

	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnlRight0290Bar;	
	private Button btnPsnl0290Create;				//휴가일수생성
	private Button btnPsnl0290Init;					//초기화 버튼
	private Button btnPsnl0290New;					//신규 버튼
	private Button btnPsnl0290Save;					//저장 버튼
	private Button btnPsnl0290Del;					//삭제 버튼
	private Button btnPsnl0290Sreach;				//조회 버튼
	private Button btnPsnl0290Excel;				//엑셀 버튼
	private Button btnPsnl0290Print;				//인쇄 버튼
	private ButtonBar topPsnlLeft0290Bar;	
	private Button btnPsnl0290ContactToSeol;		//세올연계휴가정보가져오기 버튼
	// -------------- 상단 버튼 종료 --------------

	// -------------- 검색조건 폼 시작 --------------
	private ComboBox<BaseModel> srhYear;					//년도
	private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드  	
	private ComboBox<BaseModel> srhBusinCd; 				//사업
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			//단위기관
	private TextField<String> srhHanNm;         			//성명
	private TextField<String> srhResnRegnNum;   			//주민번호 
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

//	private TextField<String> srhMangeDeptCd; 				//관리부서 수정
//private TextField<String> srhMangeDeptNm; 				//관리부서 수정 
	private HiddenField<String> systemkey;   				//시스템키
	private MSFMultiComboBox<ModelData> srhDeptCd ; 		//부서 
	private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	   
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종  
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;	//직종세
	private CheckBox srhHodyFixYn;							//확정여부

	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;

	private boolean mutilCombo = false;
	// -------------- 검색조건 폼 종료 --------------

	// -------------- 휴가일수 생성 폼 시작 --------------
	private DateField creWorkDayS;      						//근태기간 시작일
	private DateField creWorkDayE;      						//근태기간 종료일
	private ComboBox<BaseModel> creEmymtDivCd;					//고용구분
	private ComboBox<BaseModel> creRepbtyBusinDivCd; 			//호봉제구분코드  
	private ComboBox<BaseModel> creBusinCd;						//사업
	//    private ComboBox<BaseModel> crePayCd;						//급여구분
	private ComboBox<BaseModel> crePayrMangDeptCd;				//단위기관
	private ComboBox<BaseModel> creYear;        				//작업년도
	private MSFMultiComboBox<ModelData> creDeptCd ;    			//부서 
	private ComboBox<BaseModel> creDeptGpCd; 					//부서직종그룹코드	
	private MSFMultiComboBox<ModelData> creTypOccuCd;			//직종  
	private MSFMultiComboBox<ModelData> creDtilOccuInttnCd;		//직종세   
	private CheckBox creHodyFixYn;								//확정여부
	private List<ModelData> mDtalistcrDeptCd;			
	private List<ModelData> mDtalistcrTypOccuCd;
	private List<ModelData> mDtalistcrDtilOccuInttnCd;
	private FileUploadField psnl0290flUp; 									//파일업로드처리 부분  
	private Boolean picBoolFile;
	

	private Boolean emptyCheck = false ;

	
	

	private boolean mutilcrCombo = false;
	// -------------- 휴가일수 생성 폼 종료 --------------

	// -------------- 휴가 마감 관리 시작--------------
	private DateField hodyFixDt;    			//마감일자 
	private ToolBar underFinishToolBar;	//마감 toorbar	
	private ButtonBar underFinishBtnBar;	//마감 buttobar
	private Button btnFinish;					//마감
	private Button btnCancel;					//마감풀기
	// -------------- 휴가 마감 관리 종료--------------



	//직종 콤보
	//    private LookupSysComBass0320 lkTypOccuCd = new LookupSysComBass0320();  
	//    private MSFGridPanel typOccuCdGridPanel;

	//년도 콤보 
	private LookupSysComYear lkPayYr = new LookupSysComYear();  

	// -------------- store 선언 시작 ---------------
	private ListStore<BaseModel> lsPayrMangDeptCd   	= new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>();	//사업	
	private ListStore<BaseModel> lsDeptCd 		    	= new ListStore<BaseModel>();	//부서콤보
	private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드  	
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();	//직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsPayCd 				= new ListStore<BaseModel>(); 	//급여구분
	private ListStore<BaseModel> lsPayYrStore 			= new ListStore<BaseModel>();  	//년도 
	private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>();	//고용구분 
	private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	
	private HashMap<String, String> param = new HashMap<String, String>();
	// --------------------------------------------------------------------------------------
	private ListStore<BaseModel> lscrPayYr				= new ListStore<BaseModel>();	//년도 
	private ListStore<BaseModel> lscrPayMonth			= new ListStore<BaseModel>();  	//급여월   
	private ListStore<BaseModel> lscrEmymtDivCd 		= new ListStore<BaseModel>();	//고용구분 
	private ListStore<BaseModel> lscreRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lscrDeptCd  			= new ListStore<BaseModel>();	//부서콤보
	private ListStore<BaseModel> lscrBusinCd  			= new ListStore<BaseModel>();	//사업콤보   
	private ListStore<BaseModel> lscrPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel> lscreDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드  
	private ListStore<BaseModel> lscrTypOccuCd 			= new ListStore<BaseModel>();	//직종 
	private ListStore<BaseModel> lscrDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lscrPayCd 				= new ListStore<BaseModel>(); 	//급여구분
	// -------------- store 선언 종료  ---------------

	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto;	//공통코드
	private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
	private PrgmComBass0150DTO sysComBass0150Dto; 	//단위기관 
	private SysCoCalendarDTO  msfCoCalendarDto;  
	private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	// -------------- DTO 선언 종료 --------------

	// -------------- grid 선언 시작  ---------------
	private Psnl0126Def psnl0126Def  = new Psnl0126Def("PSNL0290");   //그리드 테이블 컬럼 define  
	private MSFGridPanel psnl0126GridPanel;
	// -------------- grid 선언 종료  ---------------

	private BaseModel record;
	private Iterator<Record> records;
	private ActionDatabase actionDatabase;

	private List<BaseModel> baseRecords;

	//    private List<Record>  newLsRec;
	List<Psnl0126DTO> listPsnl0126dto = new ArrayList<Psnl0126DTO>();  


	// -------------- 코드 호출 시작 --------------
	//	private SysComBass0300ServiceAsync sysComBass0300Service = SysComBass0300Service.Util.getInstance();	//공통코드 
	//	private SysComBass0400ServiceAsync sysComBass0400Service = SysComBass0400Service.Util.getInstance();	//부서코드 
	// -------------- 코드 호출 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private Psnl0100ServiceAsync psnl0100Service = Psnl0100Service.Util.getInstance();
	private Psnl0290ServiceAsync psnl0290Service = Psnl0290Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------



	//	private RpcProxy<BaseListLoadResult<Psnl0290DTO>> psnl0290Proxy = new RpcProxy<BaseListLoadResult<Psnl0290DTO>>() {
	//		@Override
	//		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0290DTO>> callback) {
	//			
	//			Psnl0290DTO dto = new Psnl0290DTO();
	//			
	//			dto.setHodyApptnYr(PersonalUtil.getSelectedComboValue(srhYear,"commCd"));
	//			dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
	//			dto.setEmymtDivCd(PersonalUtil.getSelectedComboValue(srhEmymtDivCd,"commCd"));
	//			dto.setDeptCd(MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
	//			dto.setBusinCd(PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));
	//			dto.setHanNm(srhHanNm.getValue());
	//			dto.setResnRegnNum(srhResnRegnNum.getValue());
	//			
	//			try{
	//				psnl0126Service.selectPsnl0290((BaseListLoadConfig) loadConfig,	dto, callback);
	//			}catch(Exception e){
	//				e.printStackTrace();
	//			}
	//		}
	//	};
	//	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0290Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0290Proxy);
	//	private ListStore<Psnl0290DTO> psnl0290Store = new ListStore<Psnl0290DTO>(psnl0290Loader);




	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################	 
	 */

	private VerticalPanel vp;
	private FormPanel plFrmPsnl0290;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

	//	private GridCellRenderer<Stock> gridNumber;
	//	private GridCellRenderer<Stock> change;


	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

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
	private void checkPsnl0290Auth( String authAction, ListStore<BaseModel> bm) {   
		//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		// Boolean bool = gwtExtAuth.checkExtAuth(authAction, bm );
		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			if (!maskTracker) { unmask(); }  
			authExecEnabled() ;

		}
	}
	private void authExecEnabled() { 
		//------------------
		//----------------------------------------------------
		Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd
				, crePayrMangDeptCd, creEmymtDivCd, creDeptCd, creTypOccuCd, creDtilOccuInttnCd, creBusinCd};

		gwtAuthorization.formAuthFieldConfig(fldArrField);
		gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 

		srhYear.setValue(lsPayYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 
		creYear.setValue(lscrPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
		if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year"))) {
			setInitDate();
		}  
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		 **++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		//String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
		//gwtAuthorization.formAuthPopConfig(plFrmPsnl0290, "","searchEmymtDivCd",strArrDeptCd,"searchTypOccuCd","searchBusinCd");
		//gwtAuthorization.formAuthPopConfig(plFrmPsnl0290, "","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
		//gwtAuthorization.formAuthConfig(plFrmPsnl0290, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
		//gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
		// GWTAuthorization.formAuthConfig(plFrmPsnl0250, "","searchEmymtDivCd","searchDeptCd","searchTypOccuCd","searchYearBusinCd");
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
		 **++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//srhDeptCd.fireEvent(Events.Add);
		srhDeptCd.getListView().fireEvent(Events.CheckChanged);

		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
           ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		//gwtAuthorization.formAuthConfig(plFrmPsnl0290, "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creDtilOccuInttnCd","creBusinCd");

		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
           ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		creDeptCd.getListView().fireEvent(Events.CheckChanged); 

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

		HashMap<String, Boolean> authMapDef = new HashMap<String,Boolean>(); 

		authMapDef.put("srhYear",Boolean.FALSE);
		authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
		authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
		authMapDef.put("srhDeptCd",Boolean.FALSE); 
		//  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  

		authMapDef.put("creYear",Boolean.FALSE);  
		authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
		authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
		authMapDef.put("creDeptCd",Boolean.FALSE); 
		// authMapDef.put("creTypOccuCd",Boolean.FALSE);


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
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 시작
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */  

	//버튼에 따른 Action
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			psnl0290FormSave();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			psnl0290FormSave();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			MessageBox.confirm("경고", "해당 데이터를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						psnl0290FormSave();
					}
				}
			});
			break;
		}
	}

	//마감여부에 따른 Action
	private void doFinish(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			finishPsnl0290();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			finishPsnl0290();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			finishPsnl0290();
			break;
		}
	}

	private void finishPsnl0290() { 

		if (MSFSharedUtils.paramNotNull(records)) {
			MessageBox.confirm("마감", "선택하신 테이타를 마감(마감풀기)하시겠습니까?</br> 이미 확정된 데이터에 대해서는 다시 확정하지 않습니다.",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//  if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

						List<Psnl0126DTO> listPsnl0126dto = new ArrayList<Psnl0126DTO>();  

						if (MSFSharedUtils.paramNull(GWTUtils.getStringFromDate(hodyFixDt.getValue(),"yyyyMMdd"))) {
							MessageBox.alert( "일자오류 ", "마감일자를 입력해 주십시요.", null);
							return ;
						} 
						while (records.hasNext()) {

							Record record = (Record) records.next(); 
							BaseModel bmMapModel = (BaseModel)record.getModel();

							Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  

							psnl0126Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** 사업장코드 : dpobCd */
							psnl0126Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey"))); 		/** SYSTEMKEY : systemkey */
							psnl0126Dto.setHodyApptnYr(MSFSharedUtils.allowNulls(bmMapModel.get("hodyApptnYr")));		/** 휴가적용년도 HODY_APPTN_YR */
							//	                          psnl0126Dto.setLvsgCoptnCstApptnYn((Boolean)bmMapModel.get("pymtDducItemDelYn"));			/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
							//	                          psnl0126Dto.setHodyNumDysSysCalc((Long)bmMapModel.get("hodyNumDysSysCalc"));				/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
							//	                          psnl0126Dto.setHodyApptnNumDys((Double)bmMapModel.get("hodyApptnNumDys"));				/** 휴가적용일수 HODY_APPTN_NUM_DYS */
							//	                          psnl0126Dto.setHodyUseNumDys((Double)bmMapModel.get("hodyUseNumDys"));					/** 휴가사용일수 HODY_USE_NUM_DYS */

							//------------------------ 휴가 잔여 일수 = 휴가적용일수(hodyApptnNumDys) - 휴가사용일수(hodyUseNumDys) ------------------------
							//	                          Double doubleHodyApptnNumDys = (Double)bmMapModel.get("hodyApptnNumDys") - (Double)bmMapModel.get("hodyUseNumDys");
							//	                          Double doubleHodyUseNumDys = (double) Integer.parseInt((MSFSharedUtils.allowNulls(bmMapModel.get("hodyUseNumDys"))));
							//	                          Double doubleHodyRstNumDys = doubleHodyApptnNumDys -doubleHodyUseNumDys;
							//-----------------------------------------------------------------------------------------------------------------

							//	                          psnl0126Dto.setHodyRstNumDys((Double)bmMapModel.get("hodyApptnNumDys") - (Double)bmMapModel.get("hodyUseNumDys"));/** 휴가잔여일수 HODY_RST_NUM_DYS */
							//	                          psnl0126Dto.setHodyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyBgnnDt"),"yyyyMMdd")); 			/** 휴가시작일자 HODY_BGNN_DT */
							//	                          psnl0126Dto.setHodyEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyEndDt"),"yyyyMMdd"));				/** 휴가종료일자 HODY_END_DT */
							//	                          psnl0126Dto.setHodyRstNumDys((Double)bmMapModel.get("hodyApptnNumDys"));											/** 휴가잔여일수 HODY_RST_NUM_DYS */
							//	                          psnl0126Dto.setHodyNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("hodyNoteCtnt"))); 							/** 휴가비고내용 HODY_NOTE_CTNT */
							psnl0126Dto.setHodyFixYn((Boolean)bmMapModel.get("hodyFixYn")); 													/** 휴가확정여부 HODY_FIX_YN */ 
							psnl0126Dto.setHodyFixDt(GWTUtils.getStringFromDate(hodyFixDt.getValue(),"yyyyMMdd") ); 							/** 휴가마감일자 HODY_FIX_DT */ 

							listPsnl0126dto.add(psnl0126Dto);

						}  


						psnl0290Service.finishOnPsnl0126(listPsnl0126dto, actionDatabase, new AsyncCallback<Long>(){
							public void onFailure(Throwable caught) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
										MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0410DetailFormSave() : " + caught), null);
							}
							public void onSuccess(Long result) { 

								if (result == 0) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
											( actionDatabase.equals(ActionDatabase.DELETE) ? "마감풀기" : "마감") + "(처리)가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
								} else {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
											( actionDatabase.equals(ActionDatabase.DELETE) ? "마감풀기" : "마감") + "(처리)가 완료되었습니다.", null);

									if (actionDatabase.equals(ActionDatabase.INSERT)) {
										reload();
									}
									psnl0126GridPanel.reload();
									actionDatabase = ActionDatabase.UPDATE;
								} 
							} 

						}); 
					}
				}
			}); 


		} else {
			MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
			return;
		}
	}

	private void psnl0290FormSave() {

		psnl0290Service.activityOnPsnl0126(listPsnl0126dto, actionDatabase, new AsyncCallback<Long>(){
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPsnl0126(" + actionDatabase.name() + ") : " + caught), null);
			}
			public void onSuccess(Long result) { 
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);

					reload();
					actionDatabase = ActionDatabase.UPDATE;						
				} 
			} 

		}); 

	}   
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 종료
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */        


	public ContentPanel getViewPanel() {
		if (panel == null) {

			//콤보 권한초기화
			initLoad();

			//	detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0290Form();	// 화면 기본정보를 설정
			createSearchForm();		// 검색필드 적용
			createSubForm();
			//			createXlsForm();		// 휴가일수 생성 적용
			createListGrdForm();	// 휴가정보 그리드				
			//createStandardForm(); 	// 기본정보필드

			add(vp);
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "750px");

			this.actionDatabase = ActionDatabase.UPDATE;


			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.add(vp);
		}
		return panel;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Psnl0290() {

		//		final NumberFormat currency = NumberFormat.getCurrencyFormat();
		//		final NumberFormat number = NumberFormat.getFormat("0.00");
		//		final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);
		//
		//		change = new GridCellRenderer<Stock>() {
		//			public String render(Stock model, String property,
		//					ColumnData config, int rowIndex, int colIndex,
		//					ListStore<Stock> store, Grid<Stock> grid) {
		//				double val = (Double) model.get(property);
		//				String style = val < 0 ? "red" : "green";
		//				return "<span style='color:" + style + "'>"+ number.format(val) + "</span>";
		//			}
		//		};
		//
		//		gridNumber = new GridCellRenderer<Stock>() {
		//			public String render(Stock model, String property,
		//					ColumnData config, int rowIndex, int colIndex,
		//					ListStore<Stock> store, Grid<Stock> grid) {
		//				return numberRenderer.render(null, property, model.get(property));
		//			}
		//		};
		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Psnl0290(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0290Form() {

		plFrmPsnl0290 = new FormPanel();
		plFrmPsnl0290.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 휴가일수산정"));
		plFrmPsnl0290.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0290.setBodyStyleName("pad-text");
		plFrmPsnl0290.setFrame(true);
		plFrmPsnl0290.setPadding(2);

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   

		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//로그 뷰화면 호출 메서드 
				funcLogMessage("휴가일수산정","PSNL0290");
			}
		});
		plFrmPsnl0290.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0290.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		// ------------------ 멀티콤보박스 닫기 ------------------  
		plFrmPsnl0290.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible()) {
						//부서
						srhDeptCd.showClose(ce);
						mutilCombo = false;
					} else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
						//직종
						srhTypOccuCd.showClose(ce);
						mutilCombo = false;
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
			} 
		}); 
		// ------------------ 멀티콤보박스 닫기 ------------------  



		LayoutContainer btnLayoutContainer = new LayoutContainer(new ColumnLayout());


		LayoutContainer btnLayoutLeftContainer = new LayoutContainer();

		topPsnlLeft0290Bar = new ButtonBar();
		topPsnlLeft0290Bar.setAlignment(HorizontalAlignment.LEFT);

		btnPsnl0290ContactToSeol = new Button("휴가연계세올정보가져오기");
		btnPsnl0290ContactToSeol.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				MessageBox.alert("알림", "준비중입니다.", null);

			}
		});
		topPsnlLeft0290Bar.add(btnPsnl0290ContactToSeol);

		btnLayoutLeftContainer.add(topPsnlLeft0290Bar);


		LayoutContainer btnLayoutRightContainer = new LayoutContainer();

		topPsnlRight0290Bar = new ButtonBar();
		topPsnlRight0290Bar.setAlignment(HorizontalAlignment.RIGHT);
		btnPsnl0290Create= new Button("휴가일수생성");
		topPsnlRight0290Bar.add(btnPsnl0290Create);
		btnPsnl0290Create.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				PsnlP029001 psnlP029001Form = new PsnlP029001(ActionDatabase.READ, getThis());   

				MSFFormWindows msFwPsnlP029001 = new MSFFormWindows("휴가일수생성", psnlP029001Form, "닫기", "800px", "600px", true);
				msFwPsnlP029001.show();
				psnlP029001Form.setMSFFormWindows(msFwPsnlP029001);           	
			}
		});

		btnPsnl0290Init = new Button("초기화");
		btnPsnl0290Init.setIcon(MSFMainApp.ICONS.new16());
		topPsnlRight0290Bar.add(btnPsnl0290Init);
		btnPsnl0290Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {


				srhHanNm.setValue("");
				srhResnRegnNum.setValue("");
				systemkey.setValue("");
				srhHodyFixYn.setValue(false);

				creHodyFixYn.setValue(false);
				psnl0290flUp.reset();

				//그리드 초기화
				psnl0126GridPanel.getMsfGrid().clearData();

			}
		});



		btnPsnl0290New = new Button("신규");
		btnPsnl0290New.setIcon(MSFMainApp.ICONS.new16());
		topPsnlRight0290Bar.add(btnPsnl0290New);
		btnPsnl0290New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//신규 버튼 클릭시 처리     
				psnl0126GridPanel.getMsfGrid().clearData();
				actionDatabase = ActionDatabase.INSERT; 
				fnPopupPsnl0126(); 
				//actionDatabase = actionDatabase.INSERT;
			}


		});


		btnPsnl0290Save = new Button("저장");
		btnPsnl0290Save.setIcon(MSFMainApp.ICONS.save16());
		topPsnlRight0290Bar.add(btnPsnl0290Save);
		btnPsnl0290Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				if(ActionDatabase.UPDATE.equals(actionDatabase)) {

					boolean dataChk = true;

					setListRecord(psnl0126GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());

					if (MSFSharedUtils.paramNotNull(records)) { 

						listPsnl0126dto = new ArrayList<Psnl0126DTO>();  

						while (records.hasNext()) {

							Record record = (Record) records.next(); 
							BaseModel bmMapModel = (BaseModel)record.getModel();

							Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  

							psnl0126Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** 사업장코드 : dpobCd */
							psnl0126Dto.setResnRegnNum(MSFSharedUtils.allowNulls((bmMapModel.get("resnRegnNum"))));	/** 주민등록번호 : resnRegnNum */
							psnl0126Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** SYSTEMKEY : systemkey */

							//                            Window.alert("시스템 키 : " + psnl0126Dto.getSystemkey());

							psnl0126Dto.setHodyApptnYr(MSFSharedUtils.allowNulls(bmMapModel.get("hodyApptnYr")));	/** 휴가적용년도 HODY_APPTN_YR */
							psnl0126Dto.setLvsgCoptnCstApptnYn((Boolean)bmMapModel.get("lvsgCoptnCstApptnYn"));		/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */

							Calendar  intiCal =  Calendar.getInstance(); 
							if((Boolean)bmMapModel.get("lvsgCoptnCstApptnYn")) {
								psnl0126Dto.setLvsgCoptnCstApptnDt(GWTUtils.getStringFromDate(intiCal.getTime(),"yyyyMMdd")); /** 연가보상비적용일자 LVSG_COPTN_CST_APPTN_DT */
							}else {
								psnl0126Dto.setLvsgCoptnCstApptnDt("");
							}

							psnl0126Dto.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(bmMapModel.get("hodyNumDysSysCalc"), "0"));			/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
							psnl0126Dto.setHodyApptnNumDys((Double)bmMapModel.get("hodyApptnNumDys"));				/** 휴가적용일수 HODY_APPTN_NUM_DYS */
							psnl0126Dto.setSpclHodyNumDys((Double)bmMapModel.get("spclHodyNumDys"));    			/** 특별휴가일수 : spclHodyNumDys */
							psnl0126Dto.setHodyUseNumDys((Double)bmMapModel.get("hodyUseNumDys"));					/** 휴가사용일수 HODY_USE_NUM_DYS */
							psnl0126Dto.setSpclHodyUseDys((Double)bmMapModel.get("spclHodyUseDys"));    			/** 특별휴가사용일수 SPCL_HODY_USE_DYS */

							//------------------------ 휴가 잔여 일수 = 휴가적용일수(hodyApptnNumDys) - 휴가사용일수(hodyUseNumDys) ------------------------
							//                            Double doubleHodyApptnNumDys = (Double)bmMapModel.get("hodyApptnNumDys") - (Double)bmMapModel.get("hodyUseNumDys");
							//                            Double doubleHodyUseNumDys = (double) Integer.parseInt((MSFSharedUtils.allowNulls(bmMapModel.get("hodyUseNumDys"))));
							//                            Double doubleHodyRstNumDys = doubleHodyApptnNumDys -doubleHodyUseNumDys;
							//-----------------------------------------------------------------------------------------------------------------

							psnl0126Dto.setHodyRstNumDys((Double)bmMapModel.get("hodyRstNumDys"));												/** 휴가잔여일수 HODY_RST_NUM_DYS */
							psnl0126Dto.setHodyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyBgnnDt"),"yyyyMMdd")); 				/** 휴가시작일자 HODY_BGNN_DT */
							psnl0126Dto.setHodyEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyEndDt"),"yyyyMMdd"));					/** 휴가종료일자 HODY_END_DT */
							//                            psnl0126Dto.setHodyRstNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("hodyApptnNumDys")));				/** 휴가잔여일수 HODY_RST_NUM_DYS */
							psnl0126Dto.setHodyNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("hodyNoteCtnt"))); 							/** 휴가비고내용 HODY_NOTE_CTNT */
							psnl0126Dto.setHodyFixYn((Boolean)bmMapModel.get("hodyFixYn")); 													/** 휴가확정여부 HODY_FIX_YN */ 
							psnl0126Dto.setHodyFixDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyFixDt"),"yyyyMMdd")); 				/** 휴가마감일자 HODY_FIX_DT */


							// 데이터 체크
							if(psnl0126Dto.getHodyApptnNumDys().toString().length() > 4 ) {
								dataChk = false;
								MessageBox.alert("오류", "휴가일수의 데이터가 이상합니다.(소숫점포함 최대4글자)", null);
								return;
							}else if(psnl0126Dto.getHodyApptnNumDys().toString().length() > 4 ) {
								dataChk = false;
								MessageBox.alert("오류", "사용일수의 데이터가 이상합니다.(소숫점포함 최대4글자)", null);
								return;
							}else if(psnl0126Dto.getHodyUseNumDys().toString().length() > 4 ) {

								dataChk = false;
								MessageBox.alert("오류", "특별휴가일수의 데이터가 이상합니다.(소숫점포함 최대4글자)", null);
								return;
							}


							listPsnl0126dto.add(psnl0126Dto);
						}  

						if (listPsnl0126dto.size() <= 0) {
							MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
							return;
						}else {

							if(dataChk) {
								psnl0290FormSave();
							}else {

								MessageBox.alert("오류", "입력된 일수를 확인해주세요.", null);
								return;

							}

						}

					} else {
						MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}

				}else {

					//                	Iterator<BaseModel> itBm  = psnl0126GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
					//                    
					//                	List<Record>  lsRec  = new ArrayList<Record>();
					//                	
					//                	if (lsRec.size() <= 0) {
					//        				MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "저장할 데이터를 선택해 주세요.", null);
					//        				return;
					//        			}else {
					//        				
					//        				while(itBm.hasNext()) {
					//                    		Record rec  = new Record(itBm.next()); 
					//                    		lsRec.add(rec);
					//                    	} 
					//                    	setListRecord(lsRec.iterator()); 
					//                     
					//                    	actionDatabase = ActionDatabase.INSERT;
					//                    	doAction(actionDatabase);

					//        			}

				}
			}
		});

		btnPsnl0290Del = new Button("삭제");
		btnPsnl0290Del.setIcon(MSFMainApp.ICONS.delete16());
		topPsnlRight0290Bar.add(btnPsnl0290Del);
		btnPsnl0290Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Iterator<BaseModel> itBm  = psnl0126GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				List<Record>  lsRec  = new ArrayList<Record>();

				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
				setListRecord(lsRec.iterator()); 

				actionDatabase = ActionDatabase.DELETE;
				//                doAction(actionDatabase);

				boolean dataChk = true;

				if (MSFSharedUtils.paramNotNull(records)) { 

					listPsnl0126dto = new ArrayList<Psnl0126DTO>();  

					while (records.hasNext()) {

						Record record = (Record) records.next(); 
						BaseModel bmMapModel = (BaseModel)record.getModel();

						Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  

						psnl0126Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** 사업장코드 : dpobCd */
						psnl0126Dto.setResnRegnNum(MSFSharedUtils.allowNulls((bmMapModel.get("resnRegnNum"))));	/** 주민등록번호 : resnRegnNum */
						psnl0126Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** SYSTEMKEY : systemkey */

						psnl0126Dto.setHodyApptnYr(MSFSharedUtils.allowNulls(bmMapModel.get("hodyApptnYr")));	/** 휴가적용년도 HODY_APPTN_YR */
						psnl0126Dto.setLvsgCoptnCstApptnYn((Boolean)bmMapModel.get("lvsgCoptnCstApptnYn"));		/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
						psnl0126Dto.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(bmMapModel.get("hodyNumDysSysCalc"), "0"));			/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
						psnl0126Dto.setHodyApptnNumDys((Double)bmMapModel.get("hodyApptnNumDys"));				/** 휴가적용일수 HODY_APPTN_NUM_DYS */
						psnl0126Dto.setSpclHodyNumDys((Double)bmMapModel.get("spclHodyNumDys"));    			/** 특별휴가일수 : spclHodyNumDys */
						psnl0126Dto.setHodyUseNumDys((Double)bmMapModel.get("hodyUseNumDys"));					/** 휴가사용일수 HODY_USE_NUM_DYS */
						psnl0126Dto.setSpclHodyUseDys((Double)bmMapModel.get("spclHodyUseDys"));    			/** 특별휴가사용일수 SPCL_HODY_USE_DYS */
						//                        psnl0126Dto.setHodyRstNumDys((Double)bmMapModel.get("hodyApptnNumDys") - (Double)bmMapModel.get("hodyUseNumDys"));	/** 휴가잔여일수 HODY_RST_NUM_DYS */
						psnl0126Dto.setHodyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyBgnnDt"),"yyyyMMdd")); 				/** 휴가시작일자 HODY_BGNN_DT */
						psnl0126Dto.setHodyEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyEndDt"),"yyyyMMdd"));					/** 휴가종료일자 HODY_END_DT */
						psnl0126Dto.setHodyRstNumDys((Double)bmMapModel.get("hodyRstNumDys"));												/** 휴가잔여일수 HODY_RST_NUM_DYS */
						psnl0126Dto.setHodyNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("hodyNoteCtnt"))); 							/** 휴가비고내용 HODY_NOTE_CTNT */
						psnl0126Dto.setHodyFixYn((Boolean)bmMapModel.get("hodyFixYn")); 													/** 휴가확정여부 HODY_FIX_YN */ 
						psnl0126Dto.setHodyFixDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("hodyFixDt"),"yyyyMMdd")); 				/** 휴가마감일자 HODY_FIX_DT */ 

						if((Boolean)bmMapModel.get("hodyFixYn")) {
							dataChk = false;
						}



						listPsnl0126dto.add(psnl0126Dto);


					}  

					if (listPsnl0126dto.size() <= 0) {
						MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
					else if(!dataChk){
						MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "마감처리 된 데이터는 삭제할 수 없습니다.", null);
						return;
					}
					else {
						psnl0290FormSave();
					}

				} else {
					MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
			}
		});

		btnPsnl0290Sreach = new Button("조회");
		btnPsnl0290Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0290Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				actionDatabase = ActionDatabase.UPDATE;
				reload();
			}
		});
		topPsnlRight0290Bar.add(btnPsnl0290Sreach);

		btnPsnl0290Excel = new Button("엑셀");
		btnPsnl0290Excel.setIcon(MSFMainApp.ICONS.excel16());
		topPsnlRight0290Bar.add(btnPsnl0290Excel);
		btnPsnl0290Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//엑셀저장  
				excelFileExport();
			}
		});

		btnLayoutRightContainer.add(topPsnlRight0290Bar);

		btnLayoutContainer.add(btnLayoutLeftContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		btnLayoutContainer.add(btnLayoutRightContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		//		plFrmPsnl0290.add(topPsnlRight0290Bar);
		plFrmPsnl0290.add(btnLayoutContainer);


		// 파일업로드 처리
		plFrmPsnl0290.setAction("myurl");
		plFrmPsnl0290.setEncoding(Encoding.MULTIPART);
		plFrmPsnl0290.setMethod(Method.POST);

		vp.add(plFrmPsnl0290);
		//엣지변환
		//plFrmPsnl0290.setSize("990px", "680px");
		plFrmPsnl0290.setSize("990px", "730px");
	}

	//검색조건 시작
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
		sysComBass0300Dto.setRpsttvCd("B015");	//급여구분 
		lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		sysComBass0300Dto.setRpsttvCd("A002");	//고용구분
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		 //-------------------관리부서 추가  
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		
		
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);	//부서

		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
				srhDeptCd.getStore().add(mDtalistDeptCd);

				lscrDeptCd.add(lsDeptCd.getModels()); 
				mDtalistcrDeptCd = PersonalUtil.getDeptCdModelData(lscrDeptCd) ; 
				creDeptCd.getInitStore().add(mDtalistcrDeptCd);
			}
		});  

		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------


		//--------------------년도 불러 오는 함수 ------------------------------------------------
		lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);	
		//--------------------년도 불러 오는 함수 ------------------------------------------------ 


		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		// lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  

		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 직종 콤보박스 처리  시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
		 */

		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  

				mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

				lscrTypOccuCd.add(lsTypOccuCd.getModels());
				mDtalistcrTypOccuCd = PersonalUtil.getTypOccuCdModelData(lscrTypOccuCd) ;  
				creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);


			}
		});  

		//--------검색조건, 휴가일수 중복 store---------
		lscrPayrMangDeptCd = lsPayrMangDeptCd; 
		lscrPayCd = lsPayCd; 
		lscrEmymtDivCd = lsEmymtDivCd;
		lscreRepbtyBusinDivCd = lsRepbtyBusinDivCd;
		lscreDeptGpCd = lsDeptGpCd;
		//--------검색조건, 휴가일수 중복 store---------

		//        typOccuCdGrid.add(typOccuCdGridPanel); 
		//        plFrmPsnl0290.add(typOccuCdGrid); 

		systemkey = new HiddenField<String>(); 

		plFrmPsnl0290.setLayout(new FlowLayout());


		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/


		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());


		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);

		srhYear = new ComboBox<BaseModel>();
		srhYear.setName("srhYear");
		srhYear.setForceSelection(true);
		srhYear.setMinChars(1);
		srhYear.setDisplayField("yearDisp");
		srhYear.setValueField("year");
		srhYear.setTriggerAction(TriggerAction.ALL);
		srhYear.setSelectOnFocus(true); 
		srhYear.setReadOnly(false);
		srhYear.setEnabled(true); 
		srhYear.setStore(lsPayYrStore);
		srhYear.setFieldLabel("년도"); 
		srhYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {    
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 

					checkPsnl0290Auth("srhYear", lsPayYrStore); 
				}
			}
		});
		srhYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmPayYr =  se.getSelectedItem(); 
				if (bmPayYr != null) {
					if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
						if (srhDeptCd.getListView().getChecked().size() > 0) {  
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYear, "year"));
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
			} 
		}); 



		lcSchCol01.add(srhYear, new FormData("100%"));
		//        lcSchCol01_1.add(lcSchCol01_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));


		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

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
					checkPsnl0290Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
				}

			}
		});    
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리
				sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));  
				// sysComBass0400Dto.setDeptDspyYn("Y");
			 
				//--------------------부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
				//--------------------부서 불러 오는 함수 ------------------------------------------------

				lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
						srhDeptCd.getInitStore().add(mDtalistDeptCd);
					}
				});   
			} 
		});
		lcSchCol02.add(srhPayrMangDeptCd, new FormData("100%"));
		lcSchCol02.setBorders(false);


		LayoutContainer lcSchCol03 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcSchCol03_1 = new LayoutContainer();

		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03_1.setLayout(frmlytSch);

		srhEmymtDivCd = new ComboBox<BaseModel>();
		srhEmymtDivCd.setFieldLabel("고용구분");
		srhEmymtDivCd.setForceSelection(true);
		srhEmymtDivCd.setMinChars(1);
		srhEmymtDivCd.setDisplayField("commCdNm");
		srhEmymtDivCd.setValueField("commCd");
		srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		srhEmymtDivCd.setEmptyText("--고용구분선택--");
		srhEmymtDivCd.setSelectOnFocus(true);
		srhEmymtDivCd.setStore(lsEmymtDivCd);
		srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) { 
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPsnl0290Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
		lcSchCol03_1.add(srhEmymtDivCd, new FormData("100%"));
		lcSchCol03.add(lcSchCol03_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		LayoutContainer lcSchCol03_2 = new LayoutContainer();
		//  lcSchCol.add(layoutContainer_101);
		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol03_2.setLayout(frmlytSch);

		srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
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

		lcSchCol03_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
		lcSchCol03_2.setBorders(false);
		lcSchCol03.add(lcSchCol03_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));






		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());


	    LayoutContainer lcSch2 = new LayoutContainer();
			lcSch2.setLayout(new ColumnLayout());
			
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
	  	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
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
		      	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
		      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
		      	    			} 
		      	    			
		      	    		}); 
		      	    		emptyCheck = false;
	                	}
	                 }  
	            } 
	        });   
	       
	        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));


		

		LayoutContainer layoutContainer_14 = new LayoutContainer();

		FormLayout frmlytSch01_2 = new FormLayout();
		frmlytSch01_2.setLabelWidth(60);
		frmlytSch01_2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch01_2);

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

				// srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		       			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPsnl0290Auth("srhDeptCd", lsDeptCd); 
				}
			}
		});    

		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {  
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYear,"year"));    

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
				} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

					//2015.11.30 권한 직종가져오기  추가 
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));

					String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					sysComBass0320Dto.setDeptCd(strDeptCd);

					lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
					lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
							mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
							srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
						}
					});  
				} else {
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));

					String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					sysComBass0320Dto.setDeptCd(strDeptCd);

					lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
					lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
							mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
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
		layoutContainer_14.add(srhDeptCd, new FormData("100%"));
		layoutContainer_14.setBorders(false);



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
		//        frmlytSch.setLabelWidth(30); 
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
		//        srhTypOccuCd.setFieldLabel("직종");
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



		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_15 = new LayoutContainer();
		layoutContainer_15.setBorders(false);

		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSch);

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

		layoutContainer_15.add(srhBusinCd, new FormData("100%"));



		LayoutContainer lcSchCol04_1 = new LayoutContainer();
		lcSchCol04_1.setLayout(new ColumnLayout());


		LayoutContainer lcSchCol02_Nm = new LayoutContainer();
		lcSchCol02_Nm.setLayout(new ColumnLayout());

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol02_Nm.setLayout(frmlytSch);

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

		//        srhHanNm.addKeyListener(new KeyListener() {
		//            public void componentKeyUp(ComponentEvent event) {
		////                super.componentKeyUp(event);
		//                srhHanNm.validate();
		//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
		//                	systemkey.setValue("");
		//                    srhResnRegnNum.setValue(""); 
		//                    fnPopupPsnl0100();
		//                }
		//            }
		//        });
		//        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
		//            @Override
		//            public void handleEvent(BaseEvent be) {  
		//                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
		//                	systemkey.setValue("");
		//                    srhResnRegnNum.setValue("");
		//                }
		//             
		//            } 
		//        }); 
		lcSchCol02_Nm.add(srhHanNm, new FormData("100%"));

		lcSchCol04_1.add(lcSchCol02_Nm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));


		LayoutContainer lcSchCol02_btnHanNm = new LayoutContainer();

		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol02_btnHanNm.setLayout(frmlytSch);

		Button btnHanNm = new Button("검색");
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				systemkey.setValue("");
				srhResnRegnNum.setValue("");  
				fnPopupPsnl0100() ;
			}
		});
		lcSchCol02_btnHanNm.add(btnHanNm, new FormData("100%"));
		lcSchCol04_1.add(lcSchCol02_btnHanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		LayoutContainer lcSchCol02_Jumin = new LayoutContainer();

		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol02_Jumin.setLayout(frmlytSch);

		srhResnRegnNum = new TextField<String>();
		new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");  
		srhResnRegnNum.setName("srhResnRegnNum");
		srhResnRegnNum.setHideLabel(true);
		srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
			@Override
			public void handleEvent(BaseEvent be) {  
				if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
					systemkey.setValue("");
					srhHanNm.setValue("");
				}
			} 
		});
		lcSchCol02_Jumin.add(srhResnRegnNum, new FormData("100%"));
		lcSchCol04_1.add(lcSchCol02_Jumin, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
		lcSchCol02_Jumin.setBorders(false); 


		LayoutContainer layoutContainer_16 = new LayoutContainer();

		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_16.setLayout(frmlytSch);

		srhHodyFixYn = new CheckBox();
		srhHodyFixYn.setName("srhHodyFixYn");
		srhHodyFixYn.setBoxLabel("미확정");
		srhHodyFixYn.setLabelSeparator("확정여부 : ");
		srhHodyFixYn.setHideLabel(false);
		layoutContainer_16.add(srhHodyFixYn, new FormData("100%"));




		//        lcSchCol.add(lcSchCol01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 	
		//        lcSchCol.add(lcSchCol02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		//        lcSchCol.add(lcSchCol03,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));		
		//        lcSchCol.add(lcSchCol04,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	

		lcSchCol.add(lcSchCol01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));					// 년도 	
		lcSchCol.add(lcSchCol02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));					// 단위기관
		lcSchCol.add(lcSchCol03,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));					// 고용구분

		layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); // 부서
		layoutContainer_13.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));// 부서
		layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		 // 직종

		lcSchCol3.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 사업
		lcSchCol3.add(lcSchCol04_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));				// 성명
		lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 확정여부

		fieldSet.add(lcSchCol, new FormData("100%"));
		fieldSet.add(layoutContainer_13, new FormData("100%"));
		fieldSet.add(lcSchCol3, new FormData("100%"));

		plFrmPsnl0290.add(fieldSet);
	}
	/**
	 * Excel 
	 */
	private void createSubForm() {
		
		msfCoCalendarDto = new SysCoCalendarDTO();

		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		

		FieldSet fldstNewFieldset = new FieldSet();	
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");

		LayoutContainer btnLayoutContainer = new LayoutContainer(new ColumnLayout());

		LayoutContainer LayoutContainer1 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lc2_1_1 = new LayoutContainer();
		FormLayout fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(60);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1_1.setLayout(fl2_1);

		creYear = new ComboBox<BaseModel>();
		creYear.setName("creYear");
		creYear.setFieldLabel("년도");
		creYear.setForceSelection(true);
		creYear.setMinChars(1);
		creYear.setDisplayField("yearDisp");
		creYear.setValueField("year");
		creYear.setTriggerAction(TriggerAction.ALL);
		creYear.setEmptyText("--년도--");
		creYear.setSelectOnFocus(true);
		creYear.setStore(lscrPayYr); 
		lc2_1_1.add(creYear, new FormData("100%"));

		LayoutContainer lc2_1_2 = new LayoutContainer();
		fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(40);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1_2.setLayout(fl2_1);

		creWorkDayS = new DateField();
		creWorkDayS.setName("creWorkDayS");
		new DateFieldMask(creWorkDayS, "9999.99.99"); 
		creWorkDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		creWorkDayS.setFieldLabel("기간");       
		lc2_1_2.add(creWorkDayS, new FormData("100%"));

		LayoutContainer lc2_1_3 = new LayoutContainer();
		fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(7);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1_3.setLayout(fl2_1);

		creWorkDayE = new DateField();
		creWorkDayE.setName("creWorkDayE");
		new DateFieldMask(creWorkDayE, "9999.99.99"); 
		creWorkDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		creWorkDayE.setLabelSeparator("~");
		creWorkDayE.setReadOnly(true);
		creWorkDayE.setEnabled(true);
		lc2_1_3.add(creWorkDayE, new FormData("100%"));

		LayoutContainer1.add(lc2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		LayoutContainer1.add(lc2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		LayoutContainer1.add(lc2_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		LayoutContainer LayoutContainer2 = new LayoutContainer();

		ButtonBar topPsnl0290Bar = new ButtonBar();
		topPsnl0290Bar.setAlignment(HorizontalAlignment.RIGHT);

		Button btnPsnl0290Excel= new Button("엑셀일괄업로드");
		topPsnl0290Bar.add(btnPsnl0290Excel);
		btnPsnl0290Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				PsnlP029002 psnlP029002Form = new PsnlP029002(ActionDatabase.READ, getThis());   

				MSFFormWindows msFwPsnlP029002 = new MSFFormWindows("엑셀일괄업로드", psnlP029002Form, "닫기", "800px", "600px", true);
				msFwPsnlP029002.show();
				psnlP029002Form.setMSFFormWindows(msFwPsnlP029002);   
			}
		});
		LayoutContainer2.add(topPsnl0290Bar);

		btnLayoutContainer.add(LayoutContainer1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		btnLayoutContainer.add(LayoutContainer2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fldstNewFieldset.add(btnLayoutContainer);

		plFrmPsnl0290.add(fldstNewFieldset);

	} 

	private void  displayDtilOccuInttnCd() {

		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));

			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect, "deptCd"); 
			sysComBass0350Dto.setDeptCd(strDeptCd);

			List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
			String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 

			//               sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 

			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
				lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
				//            	   srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
				lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistDtilOccuInttnCd = PersonalUtil.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
						srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);

						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;

							//            				   if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
								//            					   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
							//            						   ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
							//            						   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
							//            							   mdSelect = tpMdSelect;
							//            						   } 
							//            					   }  	 

							srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
							//            			   }  
						} 
					}
				});     
			} 
		} else {
		} 
	}
	//휴가일수 - 생성
	/*private void createXlsForm() {

		msfCoCalendarDto = new SysCoCalendarDTO();

		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 


		FieldSet fldstNewFieldset = new FieldSet(); 
		fldstNewFieldset.setHeadingHtml("휴가일수-생성");



		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());


		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);

		creYear = new ComboBox<BaseModel>();
		creYear.setName("creYear");
		creYear.setFieldLabel("년도");
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
					*//**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*//* 
					checkPsnl0290Auth("creYear", lscrPayYr); 
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
		creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmMonth =  se.getSelectedItem(); 
				if (bmMonth != null) { 
					if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(creYear,"year")) ) {
						//년도에 따라 기간 변화
						setInitDate();
					}
				}       
			} 
		});  
		lcSchCol01.add(creYear, new FormData("100%"));


		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		*//** column 단위기관 : payrMangDeptCd *//*
		crePayrMangDeptCd = new ComboBox<BaseModel>();
		crePayrMangDeptCd.setName("crePayrMangDeptCd"); 
		crePayrMangDeptCd.setForceSelection(true);
		crePayrMangDeptCd.setMinChars(1);
		crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
		crePayrMangDeptCd.setValueField("payrMangDeptCd");
		crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		crePayrMangDeptCd.setEmptyText("--단위기관선택--");
		crePayrMangDeptCd.setSelectOnFocus(true); 
		crePayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		crePayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
		crePayrMangDeptCd.setStore(lscrPayrMangDeptCd);  
		crePayrMangDeptCd.setFieldLabel("단위기관"); 
		lscrPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					*//**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*//* 
					checkPsnl0290Auth("crePayrMangDeptCd", lscrPayrMangDeptCd); 
				}
			}
		});    
		crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));

				//--------------------부서 불러 오는 함수 ------------------------------------------------
				lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
				//--------------------부서 불러 오는 함수 ------------------------------------------------

				lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistcrDeptCd = PersonalUtil.getDeptCdModelData(lscrDeptCd) ; 
						creDeptCd.getInitStore().add(mDtalistcrDeptCd);
					}
				});   
			} 
		});
		lcSchCol02.add(crePayrMangDeptCd, new FormData("100%")); 




		LayoutContainer lcSchCol03 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcSchCol03_1 = new LayoutContainer();

		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03_1.setLayout(frmlytSch);

		creEmymtDivCd = new ComboBox<BaseModel>();
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
		creEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		creEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmPayCd =  se.getSelectedItem(); 
				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					creDeptCd.getListView().fireEvent(Events.CheckChanged); 
					creBusinCd.setEnabled(true);
					creTypOccuCd.reset();
					creTypOccuCd.setEnabled(false);
					creDtilOccuInttnCd.reset();
					creDtilOccuInttnCd.setEnabled(false);
				} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {

					creBusinCd.reset();
					creBusinCd.setEnabled(false);  
					//20151130 추가 수정
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

		lscrEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					*//**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			    	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*//*
					checkPsnl0290Auth("creEmymtDivCd", lscrEmymtDivCd); 
				}
			}
		});
		lcSchCol03_1.add(creEmymtDivCd, new FormData("100%"));
		lcSchCol03.add(lcSchCol03_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));


		LayoutContainer lcSchCol03_2 = new LayoutContainer();
		//  lcSchCol.add(layoutContainer_101);
		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol03_2.setLayout(frmlytSch);

		creRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		creRepbtyBusinDivCd.setName("creRepbtyBusinDivCd");
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
		lcSchCol03_2.add(creRepbtyBusinDivCd, new FormData("100%"));
		lcSchCol03_2.setBorders(false);
		lcSchCol03.add(lcSchCol03_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));



		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_14 = new LayoutContainer();

		FormLayout frmlytSch01_2 = new FormLayout();
		frmlytSch01_2.setLabelWidth(60);
		frmlytSch01_2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch01_2);


		creDeptCd = new MSFMultiComboBox<ModelData>();
		creDeptCd.setName("creDeptCd");
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		creDeptCd.getStore().add(mDtalistcrDeptCd);
		creDeptCd.setWidth(100);
		creDeptCd.setFieldLabel("부서");
		creDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		creDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					*//**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*//* 
					checkPsnl0290Auth("creDeptCd", lscrDeptCd); 
				}
			}
		});    

		creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
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
							//   creBusinCd.setValue(lscrBusinCd.getAt(0));  
						}
					});    


				} else  if ((creDeptCd.getListView().getChecked().size() >  0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

					//2015.11.30 권한 직종가져오기  추가 
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
					String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					sysComBass0320Dto.setDeptCd(strDeptCd);
					lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
					lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  

							mDtalistcrTypOccuCd = PersonalUtil.getTypOccuCdModelData(lscrTypOccuCd) ;  
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
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				} 
			} 
		});                       

		layoutContainer_14.add(creDeptCd, new FormData("100%"));



		//직종 직종세처리 
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_211 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_211.setLayout(frmlytSch); 

		creDeptGpCd  =  new ComboBox<BaseModel>(); 
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
		//       	frmlytSch.setLabelWidth(0); 
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_21.setLayout(frmlytSch);

		creTypOccuCd = new MSFMultiComboBox<ModelData>();
		creTypOccuCd.setName("creTypOccuCd"); 
		creTypOccuCd.setEmptyText("--직종선택--"); 
		creTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
		creTypOccuCd.setWidth(100);
		creTypOccuCd.setHideLabel(true);
		//     	creTypOccuCd.setLabelSeparator("");
		//      	creTypOccuCd.setFieldLabel("직종");
		creTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		creTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		creTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  

				EventType type = be.getType();
				if (type == Store.Add) { 
					//2015.11.30 추가 
					if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
						if (!gwtExtAuth.getEnableTypOccuCd()) {
							ModelData  mdSelect  = creTypOccuCd.getStore().getAt(0) ; 
							// if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
							//   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
							//      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
							//   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
							//         mdSelect = tpMdSelect;
							//  } 
							//  }  

							creTypOccuCd.getListView().setChecked(mdSelect, true); 
							creTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
							// }  

						}  
					}
					*//**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			     		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*//* 
					//checkPsnl0290Auth("creTypOccuCd", lscrTypOccuCd); 
				}
			}
		});     

		creTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 

				//2015.11.30 추가 
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
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});

		//2015.11.30 추가 
		creTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
			@Override
			public void handleEvent(BaseEvent ce) {   

				displayCreDtilOccuInttnCd();  
			} 
		});    

		layoutContainer_21.add(creTypOccuCd, new FormData("100%")); 

		LayoutContainer lcSchRight = new LayoutContainer();
		frmlytSch = new FormLayout();  
		//       	frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		frmlytSch.setDefaultWidth(0);
		lcSchRight.setLayout(frmlytSch);

		*//** column 직종세코드 : dtilOccuInttnCd *//*  
		creDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		creDtilOccuInttnCd.setName("creDtilOccuInttnCd"); 
		creDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
		creDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
		creDtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
		creDtilOccuInttnCd.setWidth(100);
		creDtilOccuInttnCd.setHideLabel(true);
		creDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		creDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {    
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else {

				}  
			} 
		});

		lcSchRight.add(creDtilOccuInttnCd, new FormData("100%")); 


		lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));


		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());


		LayoutContainer layoutContainer_15 = new LayoutContainer();
		layoutContainer_15.setBorders(false);

		frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSch);


		creBusinCd = new ComboBox<BaseModel>();
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
		creBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		creBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		creBusinCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmPayCd =  se.getSelectedItem(); 
				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					srhBusinCd.setValue(lsBusinCd.findModel("businCd",bmPayCd.get("businCd")) );
				}  
			} 
		});

		layoutContainer_15.add(creBusinCd, new FormData("100%")); 



		LayoutContainer lc41 = new LayoutContainer();
		FormLayout fl4 = new FormLayout();
		fl4.setLabelWidth(60);
		fl4.setLabelAlign(LabelAlign.RIGHT);
		lc41.setLayout(fl4);

		LayoutContainer lc2_1 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lc2_1_1 = new LayoutContainer();
		FormLayout fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(60);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1_1.setLayout(fl2_1);

		creWorkDayS = new DateField();
		creWorkDayS.setName("creWorkDayS");
		new DateFieldMask(creWorkDayS, "9999.99.99"); 
		creWorkDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		creWorkDayS.setFieldLabel("기간");

		lc2_1_1.add(creWorkDayS, new FormData("100%"));

		LayoutContainer lc2_1_2 = new LayoutContainer();
		FormLayout fl2_2 = new FormLayout();
		fl2_2.setLabelWidth(7);
		fl2_2.setLabelAlign(LabelAlign.RIGHT);
		lc2_1_2.setLayout(fl2_2);

		creWorkDayE = new DateField();
		creWorkDayE.setName("creWorkDayE");
		new DateFieldMask(creWorkDayE, "9999.99.99"); 
		creWorkDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		creWorkDayE.setLabelSeparator("~");
		creWorkDayE.setReadOnly(true);
		creWorkDayE.setEnabled(true);
		lc2_1_2.add(creWorkDayE, new FormData("100%"));

		lc2_1.add(lc2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		lc2_1.add(lc2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		lc41.add(lc2_1, new FormData("100%"));

		LayoutContainer layoutContainer_16 = new LayoutContainer();

		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_16.setLayout(frmlytSch);

		creHodyFixYn = new CheckBox();
		creHodyFixYn.setName("creHodyFixYn");
		creHodyFixYn.setBoxLabel("미확정");
		creHodyFixYn.setLabelSeparator("확정여부 : ");
		creHodyFixYn.setHideLabel(false);
		layoutContainer_16.add(creHodyFixYn, new FormData("100%"));




		// 3
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout()); 

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2.setLayout(frmlytSch);

		psnl0290flUp = new FileUploadField();
		psnl0290flUp.setName("psnl0290flUp");
		psnl0290flUp.setValidator(new Validator() {  
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

		layoutContainer_2.add(psnl0290flUp, new FormData("100%"));
		psnl0290flUp.setFieldLabel("휴가일수");

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

		Button btnDlgn0250Save = new Button("일수업로드");
		layoutContainer_4.add(btnDlgn0250Save, new FormData("100%"));
		btnDlgn0250Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsImportData(); 
			}
		});
		layoutContainer_1.add(layoutContainer_4, new FormData("100%"));
		layoutContainer_4.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_1.add(layoutContainer_3, new FormData("100%"));
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");

		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);

		Button btnPsnl0290down = new Button("양식다운로드");
		btnPsnl0290down.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportData();
			}
		}); 

		layoutContainer_3.add(btnPsnl0290down, new FormData("100%"));
		layoutContainer_3.setBorders(false);


		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_1.add(layoutContainer_5, new FormData("100%"));
		layoutContainer_5.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_5.setLayout(frmlytSch);

		Button btnPsnl0290Create = new Button("휴가일수산정");
		btnPsnl0290Create.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				createPsnl0126ToPsnl0290Data();
			}
		}); 

		layoutContainer_5.add(btnPsnl0290Create, new FormData("100%"));
		layoutContainer_5.setBorders(false);



		lcSchCol.add(lcSchCol01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));					// 년도 	
		lcSchCol.add(lcSchCol02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));					// 단위기관
		lcSchCol.add(lcSchCol03,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));					// 고용구분

		layoutContainer_13.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));// 부서
		layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));		// 직종

		lcSchCol3.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 사업
		lcSchCol3.add(lc41,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));						// 기간
		lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 확정여부



		fldstNewFieldset.add(lcSchCol, new FormData("100%")); 
		fldstNewFieldset.add(layoutContainer_13, new FormData("100%")); 
		fldstNewFieldset.add(lcSchCol3, new FormData("100%")); 
		fldstNewFieldset.add(layoutContainer_1, new FormData("100%"));


		plFrmPsnl0290.add(fldstNewFieldset);

	}*/

	private void  displayCreDtilOccuInttnCd() {

		if ((creTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

			//직종변경에 따른 직종세 값 가져오기

			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));

			List<ModelData> mdDeptCdSelect =  creDeptCd.getListView().getChecked();  
			String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
			sysComBass0350Dto.setDeptCd(strDeptCd);

			List<ModelData> mdListSelect =  creTypOccuCd.getListView().getChecked();
			String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
			//  sysComBass0350Dto.setPyspGrdeCd(PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 

			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {

				lscrDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
				//  creDtilOccuInttnCd.setStore(lscrDtilOccuInttnCd); 

				lscrDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistcrDtilOccuInttnCd = PersonalUtil.getDtilOccuInttnCdModelData(lscrDtilOccuInttnCd) ; 
						creDtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);

						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = creDtilOccuInttnCd.getStore().getAt(0) ;

							// if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
								//   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
							//      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
							//   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
							//         mdSelect = tpMdSelect;
							//  } 
							//  }  

							creDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							creDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
							// }  
						} 
					}
				});     

			} 

		} else {

		}   
	}

	/**	   
	private void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FormLayout());

		FieldSet fldstNewFieldset_2 = new FieldSet();
		//fldstNewFieldset_2.setSize(572, 500);
		fldstNewFieldset_2.setSize("965px", "520px");
		fldstNewFieldset_2.setHeadingHtml("근무실적");
		fldstNewFieldset_2.setCollapsible(false);
		layoutContainer.add(fldstNewFieldset_2, new FormData("0"));
		//fieldSet.setSize("965px", "470px");

		fldstNewFieldset_2.add(occupationalRBottom(), new FormData("100%"));

		plFrmPsnl0290.add(layoutContainer);
		layoutContainer.setBorders(false);
	}
	 */


	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	} 

	/*//엑셀 양식 저장
	private void xlsExportData() {

		HashMap<String, String> param = new HashMap<String, String>(); 

		param.put("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(creYear,"year"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));
		param.put("deptCd", PersonalUtil.getStrValToBMMultiCombo(lsDeptCd, creDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		param.put("typOccuCd", PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd, creTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("dtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lscrDtilOccuInttnCd, creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"));
		param.put("hodyFixYn", MSFSharedUtils.allowNulls(creHodyFixYn.getValue()?"Y":"N"));

		if("".equals(srhYear)){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			} else { 
				psnl0126GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPsnl0290Export.do","extgwtFrame" ,param);   
			}
		}else{ 
			psnl0126GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPsnl0290Export.do","extgwtFrame" ,param);  
		}
	}	*/

	//엑셀 저장
	private void excelFileExport() {

		HashMap<String, String> param = new HashMap<String, String>(); 

		param.put("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(srhYear,"year"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		param.put("deptCd", PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		param.put("typOccuCd", PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("dtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
		param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 



		if("".equals(srhYear)){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			} else { 
				psnl0126GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFilePsnl0290Export.do","extgwtFrame" ,param);   
			}
		}else{ 
			psnl0126GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFilePsnl0290Export.do","extgwtFrame" ,param);  
		}
	}	

	//날짜계산
	private void setInitDate() {

		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;

		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.set (Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear, "year")), monthS -1, 1);
		creWorkDayS.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH);  

		Calendar  intieCal =   Calendar.getInstance();
		intieCal.set (Integer.parseInt(MSFSharedUtils.getSelectedComboValue(creYear,"year")), monthE - 1, maxDays );
		creWorkDayE.setValue(intieCal.getTime());

	}



	//private LayoutContainer occupationalRBottom()
	//휴가상세정보 그리드
	private void createListGrdForm() {

		FieldSet fieldSetGrd = new FieldSet();  
		fieldSetGrd.setHeadingHtml("휴가정보");

		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout(); 
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setLayout(frmlytStd);  

		ContentPanel cpGrid = new ContentPanel();   
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());      
		cpGrid.setSize(950, 450);  //450

		MSFCustomForm msfCustomForm = new MSFCustomForm(psnl0126Def, 0, 0, false, false, false);
		msfCustomForm.setHeaderVisible(false);
		psnl0126GridPanel = new MSFGridPanel(psnl0126Def, false, false, false, false, false);
		psnl0126GridPanel.setHeaderVisible(false);  
		psnl0126GridPanel.setBodyBorder(true);
		psnl0126GridPanel.setBorders(true);
		//Set the CustomForm to be used by the GridPanel
		psnl0126GridPanel.setMSFFormPanel(msfCustomForm);

		final Grid psnl0126Grid = psnl0126GridPanel.getMsfGrid().getGrid();
		psnl0126Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (psnl0126GridPanel.getCurrentlySelectedItem() != null) {      

					psnl0126GridPanel.getMSFFormPanel().bind(psnl0126GridPanel.getCurrentlySelectedItem());

					setRecord(psnl0126GridPanel.getCurrentlySelectedItem());
					if(actionDatabase == ActionDatabase.INSERT) {
						actionDatabase = ActionDatabase.INSERT;
					}else {
						actionDatabase = ActionDatabase.UPDATE;
					}


				} 
			}
		}); 

		GWTUtils.findColumnConfig(psnl0126GridPanel, Psnl0126BM.ATTR_HODYAPPTNNUMDYS).setStyle("background-color:#F5F6CE;");
		GWTUtils.findColumnConfig(psnl0126GridPanel, Psnl0126BM.ATTR_SPCLHODYNUMDYS).setStyle("background-color:#F5F6CE;");
		GWTUtils.findColumnConfig(psnl0126GridPanel, Psnl0126BM.ATTR_HODYUSENUMDYS).setStyle("background-color:#F5F6CE;");
		GWTUtils.findColumnConfig(psnl0126GridPanel, Psnl0126BM.ATTR_SPCLHODYUSEDYS).setStyle("background-color:#F5F6CE;");

		//2줄파싱 
		psnl0126GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 7, new HeaderGroupConfig("휴가일수", 1, 3));
		psnl0126GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 10, new HeaderGroupConfig("사용", 1, 2));


		cpGrid.add(psnl0126GridPanel); 

		//마감
		underFinishToolBar = new ToolBar();
		underFinishToolBar.getAriaSupport().setLabel("확정일자");

		underFinishToolBar.add(new LabelToolItem("확정일자: "));


		hodyFixDt = new DateField();
		hodyFixDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
		hodyFixDt.setName("itemApptnBgnnDt"); 
		//	    hodyFixDt.setFieldLabel("시작일자");
		hodyFixDt.setWidth("100px");
		hodyFixDt.setValue(new Date());

		underFinishToolBar.add(hodyFixDt);
		underFinishToolBar.setAlignment(HorizontalAlignment.RIGHT); 

		underFinishBtnBar = new ButtonBar();     
		underFinishBtnBar.setAlignment(HorizontalAlignment.RIGHT); 


		btnFinish = new Button("확정마감");
		underFinishBtnBar.add(btnFinish);
		btnFinish.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Iterator<BaseModel> itBm  = psnl0126GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

				List<Record>  lsRec  = new ArrayList<Record>();

				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
				setListRecord(lsRec.iterator()); 

				actionDatabase = ActionDatabase.INSERT;
				doFinish(actionDatabase);
			}
		});

		btnCancel = new Button("마감해제");
		underFinishBtnBar.add(btnCancel);
		btnCancel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Iterator<BaseModel> itBm  = psnl0126GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

				List<Record>  lsRec  = new ArrayList<Record>();

				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
				setListRecord(lsRec.iterator());  

				actionDatabase = ActionDatabase.DELETE;
				doFinish(actionDatabase);
			}
		});



		underFinishToolBar.add(underFinishBtnBar);  
		cpGrid.setBottomComponent(underFinishToolBar);


		lcStdGrid.add(cpGrid);   
		fieldSetGrd.add(lcStdGrid);   

		plFrmPsnl0290.add(fieldSetGrd, new FormData("100%"));

	}


	public void setRecord(BaseModel record) {
		this.record = record;
	}


	public void reload() {
		// TODO Auto-generated method stub
		if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
				return;
			} 
		} 

		IColumnFilter filters = null;
		psnl0126GridPanel.getTableDef().setTableColumnFilters(filters);

		psnl0126GridPanel.getTableDef().addColumnFilter("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(srhYear, "year"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0126GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0126GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		psnl0126GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
		//20180305추가 
		psnl0126GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0126GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strTypOccuCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		psnl0126GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 

		//	String strPyspGrdeCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
		//	psnl0126GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  

		String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		psnl0126GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 

		psnl0126GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0126GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0126GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		psnl0126GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
		psnl0126GridPanel.getTableDef().addColumnFilter("hodyFixYn", MSFSharedUtils.allowNulls(srhHodyFixYn.getValue()?"Y":"N"), SimpleColumnFilter.OPERATOR_EQUALS);  

		psnl0126GridPanel.reload();
	}


	//일수업로드
	private void xlsImportData() { 
		MessageBox.confirm("일수 생성", "휴가일수를 생성하시겠습니까?<br>(등록되어있는 일수가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					HashMap<String, String> param = new HashMap<String, String>();

					// only accept certain files 
					String year = PersonalUtil.getSelectedComboValue(creYear,"year");
					String name = MSFSharedUtils.allowNulls(srhHanNm.getValue());    
					String hodyBgnnDt = PersonalUtil.getConvertDateToString(creWorkDayS, "yyyyMMdd");
					String hodyEndDt = PersonalUtil.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
					String emymtDivCd = PersonalUtil.getSelectedComboValue(creEmymtDivCd,"commCd");
					String deptCd = PersonalUtil.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					String typOccuCd = PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
					// String pyspGrdeCd = PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
					String dtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
					String businCd = PersonalUtil.getSelectedComboValue(creBusinCd, "businCd"); 
					String payrMangDeptCd = PersonalUtil.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"); 
					String systemKey = MSFSharedUtils.allowNulls(systemkey.getValue()); 

					if("".equals(year)){
						MessageBox.info("", "작업년도는 필수 입니다.", null);
					}else if("".equals(hodyBgnnDt) || "".equals(hodyEndDt)){
						MessageBox.info("", "근태기간은 필수 입니다.", null);
					} else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
						if("".equals(businCd)){
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
						} else {
							//get the filename to be uploaded
							String filename = MSFSharedUtils.allowNulls(psnl0290flUp.getValue());
							if (filename.length() == 0) {
								Window.alert("선택된 파일이 없습니다.");
							} else {
								//submit the form
								plFrmPsnl0290.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 

								//파일업로드 처리
								plFrmPsnl0290.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadPsnl0290Import.do");
								plFrmPsnl0290.setEncoding(Encoding.MULTIPART);
								plFrmPsnl0290.setMethod(Method.POST);   
								plFrmPsnl0290.submit();  
								plFrmPsnl0290.onFrameLoad();  
								picBoolFile = true;
							}               
							// reset and unmask the form 
							// after file upload 
							plFrmPsnl0290.addListener(Events.Submit, new Listener<FormEvent>() {
								public void handleEvent(FormEvent evt) {   
									if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {

										//업로드가  성공했으면 인서트 모듈을 태운다. 
										plFrmPsnl0290.unmask();  
										//	                                   	MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
										picBoolFile = false;
										evt.setResultHtml("");
									} else {
										if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {

											//업로드가  성공했으면 인서트 모듈을 태운다.
											MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
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
						String filename = MSFSharedUtils.allowNulls(psnl0290flUp.getValue());
						if (filename.length() == 0) {
							Window.alert("선택된 파일이 없습니다.");
						} else {
							//submit the form
							plFrmPsnl0290.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
							//파일업로드 처리

							plFrmPsnl0290.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadPsnl0290Import.do");
							plFrmPsnl0290.setEncoding(Encoding.MULTIPART);
							plFrmPsnl0290.setMethod(Method.POST);   
							plFrmPsnl0290.submit();  
							plFrmPsnl0290.onFrameLoad();  
							picBoolFile = true;
						}               

						// reset and unmask the form 
						// after file upload 
						plFrmPsnl0290.addListener(Events.Submit, new Listener<FormEvent>() {
							public void handleEvent(FormEvent evt) {   
								if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
									//업로드가  성공했으면 인서트 모듈을 태운다. 
									plFrmPsnl0290.unmask();  
									//	                             	MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
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
				}  
			}
		}); 
	}

	/**
	 * 휴가일수산정
	 */
	private void createPsnl0126ToPsnl0290Data() {

		MessageBox.confirm("휴가 일수 산정", "휴가일수를 산정 하시겠습니까?</br> 미확정 데이터만 산정합니다.(퇴직자제외)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//  if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					String year = PersonalUtil.getSelectedComboValue(creYear,"year");
					String name = MSFSharedUtils.allowNulls(srhHanNm.getValue());    
					String hodyBgnnDt = PersonalUtil.getConvertDateToString(creWorkDayS, "yyyyMMdd");
					String hodyEndDt = PersonalUtil.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
					String emymtDivCd = PersonalUtil.getSelectedComboValue(creEmymtDivCd,"commCd");
					String deptCd = PersonalUtil.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					String typOccuCd = PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
					// String pyspGrdeCd = PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
					String dtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
					String businCd = PersonalUtil.getSelectedComboValue(creBusinCd, "businCd"); 
					String payrMangDeptCd = PersonalUtil.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"); 
					String systemKey = MSFSharedUtils.allowNulls(systemkey.getValue());

					if("".equals(year)){
						MessageBox.info("", "년도는 필수 입니다.", null);
					}else if("".equals(hodyBgnnDt) || "".equals(hodyEndDt)){
						MessageBox.info("", "기간은 필수 입니다.", null);
					}else if(GregorianCalendar.compareDate(creWorkDayS.getValue(), creWorkDayE.getValue()) < 0){
						MessageBox.info("", "기간 설정이 이상합니다. 확인하십시요.", null);  
					} else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {    
						if("".equals(businCd)){
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
						} else {
							final Tracker tracker = new Tracker();
							tracker.setStatus(false);

							//휴가일수생성
							//Progress bar for upload
							final MessageBox box = MessageBox.wait("휴가일수산정", "휴가일수산정 중 입니다...", "휴가일수 산정 중...");
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

							HashMap<String, String> param = new HashMap<String, String>(); 

							param.put("hanNm", name);
							param.put("hodyApptnYr", year);
							param.put("hodyBgnnDt", hodyBgnnDt);
							param.put("hodyEndDt", hodyEndDt);
							param.put("emymtDivCd", emymtDivCd);

							param.put("deptCd", deptCd);
							param.put("typOccuCd", typOccuCd); 
							//    param.put("pyspGrdeCd", pyspGrdeCd); 
							param.put("dtilOccuInttnCd", dtilOccuInttnCd); 

							param.put("businCd", businCd);

							param.put("payrMangDeptCd", payrMangDeptCd);
							param.put("systemKey", systemKey);
							param.put("hodyFixYn", MSFSharedUtils.allowNulls(creHodyFixYn.getValue()?"Y":"N"));

							actionDatabase = ActionDatabase.UPDATE;

							psnl0290Service.createPsnl0126HolidayCount(param, actionDatabase, new AsyncCallback<Long>(){
								public void onFailure(Throwable caught) {
									tracker.setStatus(true);
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
											MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createPsnl0126HolidayCount(" + actionDatabase.name() + ") : " + caught), null);
								}
								public void onSuccess(Long result) { 
									tracker.setStatus(true);
									if (result == 0) {
										MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
												"휴가일수산정 된 데이터가 없습니다. 데이타를 확인하십시요.", null);
									} else {
										MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
												"휴가일수산정이 완료되었습니다.", null);
										reload();
										actionDatabase = ActionDatabase.UPDATE;
									} 
								} 

							}); 
						}

					}else{ 


						final Tracker tracker = new Tracker();
						tracker.setStatus(false);


						//휴가일수생성
						//Progress bar for upload
						final MessageBox box = MessageBox.wait("휴가일수산정", "휴가일수산정 중 입니다...", "휴가일수  생성 중...");
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


						HashMap<String, String> param = new HashMap<String, String>(); 
						param.put("hanNm", name);
						param.put("hodyApptnYr", year);
						param.put("hodyBgnnDt", hodyBgnnDt);
						param.put("hodyEndDt", hodyEndDt);
						param.put("emymtDivCd", emymtDivCd);

						param.put("deptCd", deptCd);
						param.put("typOccuCd", typOccuCd); 
						//   param.put("pyspGrdeCd", pyspGrdeCd); 
						param.put("dtilOccuInttnCd", dtilOccuInttnCd); 

						param.put("businCd", businCd);
						param.put("systemKey", systemKey); 

						param.put("payrMangDeptCd", payrMangDeptCd);

						param.put("hodyFixYn", MSFSharedUtils.allowNulls(creHodyFixYn.getValue()?"Y":"N"));


						actionDatabase = ActionDatabase.INSERT;

						psnl0290Service.createPsnl0126HolidayCount(param, actionDatabase, new AsyncCallback<Long>(){
							public void onFailure(Throwable caught) {
								tracker.setStatus(true);
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
										MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createPsnl0126HolidayCount(" + actionDatabase.name() + ") : " + caught), null);
							}
							public void onSuccess(Long result) { 
								tracker.setStatus(true);
								if (result == 0) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
											"휴가일수산정 된 데이터가 없습니다. 데이타를 확인하십시요.", null);
								} else {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
											"휴가일수산정이 완료되었습니다.", null);
									reload();
									actionDatabase = ActionDatabase.UPDATE;
								} 
							} 
						}); 
					}
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


	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	//성명
	private void fnPopupPsnl0100()  {
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 

		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) { 

					systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   	//시스템키
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));			//성명
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));//주민번호 
				}  
			}
		});
	}


	//신규 생성
	private   void fnPopupPsnl0126() {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.

		String yearVal = PersonalUtil.getSelectedComboValue(creYear,"year");

		if("".equals(yearVal) || MSFSharedUtils.paramNull(yearVal)){

			MessageBox.info("", "휴가일수 생성부 에서 년도는 선택해주세요. (필수)", null);
			return;

		}else {

			MSFFormPanel popCom0126 = PrgmComPopupUtils.lovPopUpPrgmComPsnl0126Form(yearVal);  // 인사 휴가

			final FormBinding popBindingCom0126 = popCom0126.getFormBinding();

			popBindingCom0126.addListener(Events.Change, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					List<BaseModel> mapModels = (List<BaseModel>)be.getSource();

					//		                List<BaseModel> mapDataModels = null ;
					if (mapModels != null) { 

						//		                	setListRecord(mapModels);
						BaseModel bmData = psnl0126GridPanel.getTableDef().getDefaultValues(); 
						psnl0126GridPanel.setSize(945, 445);

						int i = 0;


						Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();

						listPsnl0126dto = new ArrayList<Psnl0126DTO>();  

						while (iterRecords.hasNext()) {

							BaseModel bmMapModel = (BaseModel) iterRecords.next(); 

							bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());													/** 사업장코드 : dpobCd */  
							bmData.set("systemkey",MSFSharedUtils.allowNulls(bmMapModel.get("systemkey"))); 								/** SYSTEMKEY : systemkey */ 

							bmData.set("currAffnDeptNm",MSFSharedUtils.allowNulls(bmMapModel.get("currAffnDeptNm")));						/** column 부서 : deptNm */ 
							bmData.set("hanNm",MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));  										/** column 한글성명 : hanNm */ 
							bmData.set("resnRegnNum",MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));  							/** column 주민등록번호 : resnRegnNum */ 

							bmData.set("emymtDivCd",MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd"))); 								/** column 고용구분코드 : emymtDivCd */   
							bmData.set("typOccuCd",MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))); 								/** column 직종코드 : typOccuCd */ 
							//   bmData.set("pyspGrdeCd",MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));				/** column 호봉등급코드 : pyspGrdeCd */ 
							bmData.set("dtilOccuInttnCd",MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))); 					/** column 직종세구분코드 : dtilOccuInttnCd */  
							bmData.set("businCd",MSFSharedUtils.allowNulls(bmMapModel.get("businCd"))); 									/** column 사업코드 : businCd */ 
							bmData.set("logSvcYrNumCd",MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));  						/** set 근속년수코드 : logSvcYrNumCd */

							bmData.set("logSvcYrNumNm",MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumNm")));  						/** column 근속년수 : logSvcYrNumNm */  
							bmData.set("emymtDivNm",MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivNm")));  								/** column 고용구분코드 : emymtDivNm */  
							bmData.set("typOccuNm",MSFSharedUtils.allowNulls(bmMapModel.get("typOccuNm")));  								/** column 직종코드 : typOccuNm*/ 
							//    bmData.set("pyspGrdeNm",MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeNm"))); 				/** column 호봉등급코드 : pyspGrdeNm */ 
							bmData.set("dtilOccuClsDivNm",MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivNm")));  					/** column 직종세구분코드 : dtilOccuClsDivNm */  
							bmData.set("businNm",MSFSharedUtils.allowNulls(bmMapModel.get("businNm"))); 									/** column 사업코드 : businNm */ 

							bmData.set("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(creYear, "year")); 							/** 휴가적용년도 HODY_APPTN_YR */	
							bmData.set("lvsgCoptnCstApptnYn",false);																	/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
							bmData.set("hodyNumDysSysCalc", 0L);																		/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
							bmData.set("hodyApptnNumDys", 0.0);																			/** 휴가적용일수 HODY_APPTN_NUM_DYS */
							bmData.set("hodyUseNumDys", 0.0);																			/** 휴가사용일수 HODY_USE_NUM_DYS */
							bmData.set("spclHodyNumDys", 0.0);																			/** set 특별휴가일수 : spclHodyNumDys */
							bmData.set("hodyBgnnDt", creWorkDayS.getValue());															/** 휴가시작일자 HODY_BGNN_DT */
							bmData.set("hodyEndDt", creWorkDayE.getValue());															/** 휴가종료일자 HODY_END_DT */
							bmData.set("hodyRstNumDys", 0.0);																			/** 휴가잔여일수 HODY_RST_NUM_DYS */
							bmData.set("hodyNoteCtnt", ""); 																			/** 휴가비고내용 HODY_NOTE_CTNT */
							bmData.set("hodyFixYn", false);
							bmData.set("hodyFixDt", GWTUtils.getDateFromString("", "yyyyMMdd"));										/** 휴가확정날짜 HODY_FIX_DT */

							// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
							// 데이터 추가를 위해 dto에 담아준 후 서비스 호출
							// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
							Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  
							psnl0126Dto.setDpobCd(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));				/** 사업장코드 : dpobCd */
							psnl0126Dto.setResnRegnNum(MSFSharedUtils.allowNulls((bmData.get("resnRegnNum"))));	/** 주민등록번호 : resnRegnNum */
							psnl0126Dto.setSystemkey(MSFSharedUtils.allowNulls(bmData.get("systemkey")));    	/** SYSTEMKEY : systemkey */

							//		                        Window.alert("시스템 키 : " + psnl0126Dto.getSystemkey());
							psnl0126Dto.setHodyApptnYr(MSFSharedUtils.allowNulls(bmData.get("hodyApptnYr")));	/** 휴가적용년도 HODY_APPTN_YR */
							psnl0126Dto.setLvsgCoptnCstApptnYn((Boolean)bmData.get("lvsgCoptnCstApptnYn"));		/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
							psnl0126Dto.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(bmData.get("hodyNumDysSysCalc"), "0"));			/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
							psnl0126Dto.setHodyApptnNumDys((Double)bmData.get("hodyApptnNumDys"));				/** 휴가적용일수 HODY_APPTN_NUM_DYS */
							psnl0126Dto.setSpclHodyNumDys((Double)bmData.get("spclHodyNumDys"));    			/** 특별휴가일수 : spclHodyNumDys */
							psnl0126Dto.setHodyUseNumDys((Double)bmData.get("hodyUseNumDys"));					/** 휴가사용일수 HODY_USE_NUM_DYS */

							psnl0126Dto.setHodyRstNumDys((Double)bmData.get("hodyRstNumDys"));					/** 휴가잔여일수 HODY_RST_NUM_DYS */
							psnl0126Dto.setHodyBgnnDt(GWTUtils.getStringFromDate((Date)bmData.get("hodyBgnnDt"),"yyyyMMdd")); 				/** 휴가시작일자 HODY_BGNN_DT */
							psnl0126Dto.setHodyEndDt(GWTUtils.getStringFromDate((Date)bmData.get("hodyEndDt"),"yyyyMMdd"));					/** 휴가종료일자 HODY_END_DT */
							//		                        psnl0126Dto.setHodyRstNumDys(MSFSharedUtils.allowNulls(bmMapModel.get("hodyApptnNumDys")));				/** 휴가잔여일수 HODY_RST_NUM_DYS */
							psnl0126Dto.setHodyNoteCtnt(MSFSharedUtils.allowNulls(bmData.get("hodyNoteCtnt"))); 							/** 휴가비고내용 HODY_NOTE_CTNT */
							psnl0126Dto.setHodyFixYn((Boolean)bmMapModel.get("hodyFixYn")); /** 휴가확정여부 HODY_FIX_YN */ 
							psnl0126Dto.setHodyFixDt(GWTUtils.getStringFromDate((Date)bmData.get("hodyFixDt"),"yyyyMMdd")); 				/** 휴가마감일자 HODY_FIX_DT */ 
							listPsnl0126dto.add(psnl0126Dto);
							// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
							// 데이터 추가를 위해 dto에 담아준 후 서비스 호출
							// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

							//		                        // 대상자 신규/기존 구분
							//		                        if(bmMapModel.get("hodyApptnYr") == null) {
							//		                        	bmData.set("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(srhYear, "year")); 							/** 휴가적용년도 HODY_APPTN_YR */	
							//		                            bmData.set("pymtDducItemDelYn",false);																		/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
							//		                            bmData.set("hodyNumDysSysCalc", 0L);																		/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
							//		                            bmData.set("hodyApptnNumDys", 0.0);																			/** 휴가적용일수 HODY_APPTN_NUM_DYS */
							//		                            bmData.set("hodyUseNumDys", 0.0);																			/** 휴가사용일수 HODY_USE_NUM_DYS */
							//		                            bmData.set("spclHodyNumDys", 0.0);																			/** set 특별휴가일수 : spclHodyNumDys */
							//		                            bmData.set("hodyBgnnDt", creWorkDayS.getValue());															/** 휴가시작일자 HODY_BGNN_DT */
							//		                            bmData.set("hodyEndDt", creWorkDayE.getValue());															/** 휴가종료일자 HODY_END_DT */
							//		                            bmData.set("hodyRstNumDys", 0.0);																			/** 휴가잔여일수 HODY_RST_NUM_DYS */
							//		                            bmData.set("hodyNoteCtnt", ""); 																			/** 휴가비고내용 HODY_NOTE_CTNT */
							//		                            bmData.set("hodyFixYn", false);
							//		                            bmData.set("hodyFixDt", GWTUtils.getDateFromString("", "yyyyMMdd"));										/** 휴가확정날짜 HODY_FIX_DT */
							//		                            
							//		                            
							//		                            
							//		                            
							//		                            
							//		                        }else {
							//		                        	bmData.set("hodyApptnYr", MSFSharedUtils.allowNulls(bmMapModel.get("hodyApptnYr"))); 						/** 휴가적용년도 HODY_APPTN_YR */	
							//		                            bmData.set("pymtDducItemDelYn", MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducItemDelYn")));			/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
							//		                            bmData.set("hodyNumDysSysCalc", MSFSharedUtils.allowNulls((Double)bmMapModel.get("hodyNumDysSysCalc")));	/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
							//		                            bmData.set("hodyApptnNumDys", MSFSharedUtils.allowNulls((Long)bmMapModel.get("hodyApptnNumDys")));			/** 휴가적용일수 HODY_APPTN_NUM_DYS */
							//		                            bmData.set("hodyUseNumDys", MSFSharedUtils.allowNulls((Long)bmMapModel.get("hodyUseNumDys")));				/** 휴가사용일수 HODY_USE_NUM_DYS */
							//		                            bmData.set("spclHodyNumDys", 0.0);																			/** set 특별휴가일수 : spclHodyNumDys */
							//		                            bmData.set("hodyBgnnDt",MSFSharedUtils.allowNulls((Date)bmMapModel.get("hodyBgnnDt")));						/** 휴가시작일자 HODY_BGNN_DT */
							//		                            bmData.set("hodyEndDt", MSFSharedUtils.allowNulls((Date)bmMapModel.get("hodyEndDt")));						/** 휴가종료일자 HODY_END_DT */
							//		                            bmData.set("hodyRstNumDys", MSFSharedUtils.allowNulls((Long)bmMapModel.get("hodyRstNumDys")));				/** 휴가잔여일수 HODY_RST_NUM_DYS */
							//		                            bmData.set("hodyNoteCtnt", MSFSharedUtils.allowNulls(bmMapModel.get("hodyNoteCtnt"))); 						/** 휴가비고내용 HODY_NOTE_CTNT */
							//		                            bmData.set("hodyFixYn", MSFSharedUtils.allowNulls(bmMapModel.get("hodyFixYn")));
							//		                            bmData.set("hodyFixDt",MSFSharedUtils.allowNulls((Date)bmMapModel.get("hodyFixDt")));
							//		                        }
							psnl0126GridPanel.getMsfGrid().getGrid().stopEditing();      
							psnl0126GridPanel.getMsfGrid().getGrid().getStore().insert(bmData, i); 
							psnl0126GridPanel.getMsfGrid().getGrid().startEditing(psnl0126GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 1);
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getView().setShowDirtyCells(true);
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getView().refresh(true);
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getStore().getRecord(psnl0126GridPanel.getMsfGrid().getGrid().getStore().getAt(i)).setDirty(true);
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getStore().update(psnl0126GridPanel.getMsfGrid().getGrid().getStore().getAt(i));
							//		                        Window.alert("" + psnl0126GridPanel.getMsfGrid().getGrid().getStore().getAt(i).get("systemkey"));

							//		                        psnl0126GridPanel.getGrid().saveState();
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getStore().getRecord(psnl0126GridPanel.getMsfGrid().getGrid().getStore().getAt(i)).isModified("systemkey");
							//		                        psnl0126GridPanel.getMsfGrid().getGrid().getStore().getRecord(psnl0126GridPanel.getMsfGrid().getGrid().getStore().getAt(i)).isModified("resnRegnNum");
							psnl0126GridPanel.getMsfGrid().getGrid().getStore().getRecord(psnl0126GridPanel.getMsfGrid().getGrid().getStore().getAt(i)).setDirty(true);

							psnl0126GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
							//		                        psnl0126GridPanel.getGrid().getStore().g
							//		                        BaseModel bm = psnl0126GridPanel.getMsfGrid().getStore().getAt(i);
							//		                        newLsRec.add(psnl0126GridPanel.getMsfGrid().getStore().getRecord(bm));

							//		                        Window.alert("" + newLsRec.get(i).get("systemkey"));

							i = i + 1;


						} 

						// 신규 데이터 바로 insert 처리
						psnl0290FormSave();


					}  
				}
			});
			actionDatabase = ActionDatabase.INSERT;

		}



	}

	//	public void setListRecord(List<BaseModel> records) {
	//		this.baseRecords = records;
	//	}

	public Iterator<Record>  getListRecord() {
		return this.records;
	}

	private Psnl0290 getThis() {
		return this;
	}
	/**	
    //부서 
	private void fnPopupCommP140(String deptCd) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
		MSFFormPanel popCom0140 = SysComPopupUtils.lovPopUpMsfCom0140Form(deptCd);  //부서
		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();

		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("mangeDeptCd"))) { 
					srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
					srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
					srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
					srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
					srhDeptCd.fireEvent(Events.Add);
				}  
			}
		});

	 */
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/ 

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
