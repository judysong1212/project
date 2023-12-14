package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.service.Psnl0100Service;
import com.app.exterms.personal.client.service.Psnl0100ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0350Service;
import com.app.exterms.prgm.client.service.PrgmComBass0350ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
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
public class Psnl0650 extends MSFPanel {

/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 시작} 
 * #######################################################
 */
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	 
/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 종료} 
 * #######################################################
 */

	private XTemplate detailTp;
	private VerticalPanel vp;
	private FormPanel plFrmPsnl0650; // formpanel
	private String txtForm = "";

	final TabPanel tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab
	
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	
	public FormBinding formBinding; // 폼바인딩변수

	// -------------- 검색조건 시작 -------------- 
	private HashMap<String, String> param = new HashMap<String, String>();
	
	private FieldSet fieldSet; 								//검색조건
	
	private DateField searchEmymtBgnnDtS;					//고용시작일 시작
	private DateField searchEmymtBgnnDtE; 					//고용시작일 종료
	
	private TextField<String> srhDeptCd; 					//부서코드
    private TextField<String> srhDeptNm; 					//부서명  
    
    private Button btnSrhDeptCd;							//부서 검색 버튼
    		
    private TextField<String> srhMangeDeptCd; 				//관리부서 수정
    private TextField<String> srhMangeDeptNm; 				//관리부서 수정 
    
    private String typComboOccuCd  = new String(); 
    
    private HiddenField<String> searchPyspGrdeCd;
    
    private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	
	private ComboBox<BaseModel> srhTypOccuCd; 				//직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;	//직종세 
//	private ComboBox<BaseModel> searchHdofcCodtnCd; 		//재직구분
	private MSFMultiComboBox<ModelData> searchHdofcCodtnCd; 		//재직구분
	private ComboBox<BaseModel> searchEmymtDivCd; 			//고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드 
	
	private ComboBox<BaseModel> srhBusinCd;	//사업명 코드
	//private TextField<String> searchName; // 검색조건 이름
	//private TextField<String> searchResnRegnNum; // 검색조건 주민번호
	//private ComboBox<BaseModel> searchManageDeptCd; // 관리부서
	//private ComboBox<BaseModel> searchDeptCd; // 관리부서	
	 private List<ModelData> mDtalistDtilOccuInttnCd ;
	 private List<ModelData> mDtalistHdofcCodtnCd;
     
     private boolean mutilCombo = false;
	
	//직종콤보
//    private LookupPrgmComBass0320 comTypOccuCd = new LookupPrgmComBass0320();  
//    private MSFGridPanel comTypOccuCdGridPanel;
	// -------------- 검색조건 종료 -------------- 
	
	// -------------- 서비스 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();//공통코드 호출
	//private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();//부서코드 호출
	private Psnl0100ServiceAsync psnl0100Service = Psnl0100Service.Util.getInstance();
	private PrgmComBass0350ServiceAsync sysComBass0350Service = PrgmComBass0350Service.Util.getInstance();	//직종
	private PrgmComBass0350DTO sysComBass0350Dto; 
	 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	// -------------- 서비스 호출 종료 --------------
	
	private RadioGroup outputTypeRadiogroup;
	
	private Grid<Psnl0100DTO> psnl0100Grid;
	private CheckBoxSelectionModel<Psnl0100DTO> sm;
	
	// -------------- store 선언 시작 --------------
	//private ListStore<BaseModel> listStoreBass0400 = new ListStore<BaseModel>();
	//private ListStore<BaseModel> listStoreBass0400All = new ListStore<BaseModel>(); // 소속부서 전체 데이타
	private ListStore<BaseModel> listStoreA002 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA003 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA041 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();			 
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  	
	// -------------- store 선언 종료 --------------
	
//	private RpcProxy<BaseListLoadResult<Psnl0100DTO>> psnl0100Proxy = new RpcProxy<BaseListLoadResult<Psnl0100DTO>>() {
//		@Override
//		protected void load(Object loadConfig,
//				AsyncCallback<BaseListLoadResult<Psnl0100DTO>> callback) {
//			// TODO Auto-generated method stub
//			param.put("type", "search");
//			param.put("searchEmymtBgnnDtS", PersonalUtil.getConvertDateToString(searchEmymtBgnnDtS, "yyyyMMdd"));	//고용시작일 
//			param.put("searchEmymtBgnnDtE", PersonalUtil.getConvertDateToString(searchEmymtBgnnDtE, "yyyyMMdd")); 	//고용종료일
////			param.put("searchHdofcCodtnCd",PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd) );	//재직구분
//			param.put("searchHdofcCodtnCd", PersonalUtil.getStrValToBMMultiCombo(listStoreA003,searchHdofcCodtnCd.getValue(),"commCdNm","commCd"));	//재직구분
//			//param.put("searchMangeDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()) ); 	//관리부서
//			param.put("searchDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue())); 				//관리부서
//			param.put("srhTypOccuCd",PersonalUtil.getSelectedComboValue(srhTypOccuCd)); 			//직종
//			param.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
//			//param.put("srhDtilOccuInttnCd",PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd)); 	//직종세
//			param.put("searchEmymtDivCd",PersonalUtil.getSelectedComboValue(searchEmymtDivCd));			//고용구분
//			param.put("searchBusinCd",PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));	//부서
//			
//			try{
//				psnl0100Service.selectPsnl0100((BaseListLoadConfig) loadConfig,	param, callback);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//			param = new HashMap<String, String>();
//		}
//	};
//	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0110Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0100Proxy);
//	private ListStore<Psnl0100DTO> psnl0100Store = new ListStore<Psnl0100DTO>(psnl0110Loader);
	

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
	  private void checkPsnl0650Auth( String authAction, ListStore<BaseModel> bm) {   
    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
		    
			   if (!maskTracker) { unmask(); }  
	              //MSFMainApp.unmaskMainPage();
			   //----------------------------------------------------
			   authExecEnabled() ;
              
                 
		   }
	  }

		 private void authExecEnabled() { 
		   //------------------
			 Field<?>[] fldArrField = {searchEmymtDivCd, srhMangeDeptCd, srhMangeDeptNm, srhDeptCd, srhDeptNm, srhTypOccuCd, srhBusinCd};
             
             gwtAuthorization.formAuthFieldConfig(fldArrField);
             gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
             
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              * 권한설정을 위한 콤보처리를 위한 메서드 시작 
              * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
              // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
              // gwtAuthorization.formAuthPopConfig(plFrmPsnl0650, "","searchEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
               //gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
               // GWTAuthorization.formAuthConfig(plFrmPsnl0250, "","searchEmymtDivCd","searchDeptCd","srhTypOccuCd","srhBusinCd");
             /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              * 권한설정을 위한 콤보처리를 위한 메서드 종료
              ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
               srhDeptCd.fireEvent(Events.Add);
               
               searchEmymtBgnnDtS.setValue(new Date());
               
               searchEmymtBgnnDtS.setValue(new Date());
//               searchHdofcCodtnCd.setValue(listStoreA003.getAt(0)); 
		 }
//		  private AuthAction authAction;
//		  private int checkCntDef = 4;   //체크 값 갯수 
//		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//		  /**
//		   * 권한설정 처리 체크 
//		   * AuthAction 
//		   */
//		  private void checkPsnl0650Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//			 
//			   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//			   
//				   
//	                //----------------------------------------------------
//	                unmask(); 
//	                //MSFMainApp.unmaskMainPage();
//	                 
//			   }
//		  }

	   final Timer tmMask = new Timer()
	     {
	           public void run()
	           {
	              // if (maskTracker)
	              // { 
	        	   if (listStoreA002.getCount() > 0 ) {
	        		   
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
			     
			     authMapDef.put("searchEmymtDivCd",Boolean.FALSE); 
				 
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
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// // formData = new FormData("-650");
	// vp = new VerticalPanel();
	// vp.setSpacing(10);
	// createPsnl0600Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createCheckBoxGrid(); //기본정보필드
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }

	public ContentPanel getViewPanel() {
		if (panel == null) {
			 //권한 검색조건처리를 위해 추가된 부분 
			initLoad();
//			listStoreBass0400 = PrgmComComboUtils.getMangDeptBass0400ComboData(new PrgmComBass0400DTO());
//			sysComBass0400Service.getPrgmComDeptBass0400List(new PrgmComBass0400DTO(),new AsyncCallback<List<BaseModel>>() {
//				@Override
//				public void onSuccess(List<BaseModel> result) {
//					listStoreBass0400All.add(result);
//				}
//				@Override
//				public void onFailure(Throwable caught) {
//					caught.printStackTrace();
//				}
//			});
			// 공통 코드 가져오기
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add("A002"); //고용구분
			arrRpsttvCd.add("A003"); //재직구분
			arrRpsttvCd.add("A048"); //호봉
			//arrRpsttvCd.add("A041"); //직종
			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String, List<BaseModel>>>() {
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					// TODO Auto-generated method stub
					if (result != null && result.size() > 0) {
						//listStoreA041.add(result.get("A041"));	//직종
						listStoreA003.add(result.get("A003"));
						listStoreA002.add(result.get("A002"));
						lsRepbtyBusinDivCd.add(result.get("A048"));
//						ssearchHdofcCodtnCd.setValue(listStoreA003.getAt(0));
					}
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					MessageBox.alert("", "공통코드 에러! 재 로그인", null);
				}
			});
			
			
			listStoreA003.addStoreListener( new StoreListener<BaseModel>() {   
				public void handleEvent(StoreEvent<BaseModel> be) {  
					mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(listStoreA003) ; 
					searchHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
		         }
			});  

			detailTp = XTemplate.create(getDetailTemplate());
			vp = new VerticalPanel();
			// vp.setSpacing(10);

			createPsnl0650Form();	//화면 기본정보를 설정
			createSearchForm(); 	//검색필드를 적용
			createCheckBoxGrid(); 	//기본정보필드

			vp.setSize("1010px", "700px");

			// 폼데이터를 바인딩
			formBinding = new FormBinding(this.plFrmPsnl0650, true);

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
	public Psnl0650() {
		setSize("1010px", "700px");
	}

	public Psnl0650(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0650Form() {
		
		plFrmPsnl0650 = new FormPanel();
		plFrmPsnl0650.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 인사통계현황"));
		plFrmPsnl0650.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0650.setBodyStyleName("pad-text");
		plFrmPsnl0650.setFrame(true);
		plFrmPsnl0650.setPadding(2);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("인사통계현황","PSNL0650");
				}
			});
		plFrmPsnl0650.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0650.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		//멀티콤보박스 닫기 
		plFrmPsnl0650.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				            
				if (mutilCombo) {
					if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
						//직종세
						srhDtilOccuInttnCd.showClose(ce);
						mutilCombo = false;
					}  else if ( searchHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
						// 재직
						searchHdofcCodtnCd.showClose(ce);
						mutilCombo = false;
				                  
					} 
				}
			}
		}); 

		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT); 

		Button topBtn = new Button("인쇄", psnl0650ButtonListener);
		topBtn.setIcon(MSFMainApp.ICONS.print16());
		buttonBar.add(topBtn);

		plFrmPsnl0650.add(buttonBar);

		vp.add(plFrmPsnl0650);
		plFrmPsnl0650.setSize("990px", "690px"); //690 - > 290 으로 변경
		
	}

	private SelectionListener<ButtonEvent> psnl0650ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			if(MSFSharedUtils.paramNull(searchEmymtBgnnDtS.getValue()) || GregorianCalendar.compareDate(searchEmymtBgnnDtS.getValue(), searchEmymtBgnnDtS.getValue()) < 0){
				searchEmymtBgnnDtS.setValue(new Date());
//				MessageBox.info("", message+"근태기간 설정이 이상합니다. 확인하십시요.", null);  
			} 
			
			String printType = PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup);
			
			// 직종별통계현황은 무기계약근로자만 
			if(printType == "PSNLT0652" || "PSNLT0652".equals(printType)){
				if(!MSFConfiguration.EMYMT_DIVCD01.equals(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"))) {
					MessageBox.info("경고", "직종별통계현황은 공무직만 가능<BR>고용구분을 확인해주세요. ", null);
					return;
				}
			}
			Psn0650Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"));
		}
	};

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
	
	private void Psn0650Print(String fileName, String repType) {
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

		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PSNL";
		
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터 
		
		//검색조건
		String serarchParam = "";
		
		String searchEmymtBgnnDtS = this.searchEmymtBgnnDtS.getValue() == null ? "" : PersonalUtil.getConvertDateToString(this.searchEmymtBgnnDtS, "yyyyMMdd"); 
		String searchEmymtBgnnDtE = this.searchEmymtBgnnDtE.getValue() == null ? "" : PersonalUtil.getConvertDateToString(this.searchEmymtBgnnDtE, "yyyyMMdd"); 
//		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
		String hdofcCodtnCd = PersonalUtil.getStrValToBMMultiCombo(listStoreA003,searchHdofcCodtnCd.getValue(),"commCdNm","commCd");  
		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
		String deptCd = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); //소속부서
		String businCd = PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd") == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"); 
		String typOccuCd = PersonalUtil.getSelectedComboValue(srhTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(srhTypOccuCd, "commCd"); //직종
		String dtilOccuInttnCd = PersonalUtil.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd");  //직종세	
		//직종별통계현황은 공무직만...
		if("PSNLT0652".equals(fileName)){
			emymtDivCd = "A0020010";
		}
		
		serarchParam += "["+searchEmymtBgnnDtS+"]";
		serarchParam += "["+searchEmymtBgnnDtE+"]";
		serarchParam += "["+hdofcCodtnCd+"]";
		serarchParam += "["+emymtDivCd+"]";
		serarchParam += "["+deptCd+"]";
		serarchParam += "["+businCd+"]";
		serarchParam += "["+typOccuCd+"]";
		serarchParam += "["+dtilOccuInttnCd+"]";
		
		String strParam = "/rp " + serarchParam;
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	}
	
	//rex 
	private void RexPrint(String fileName) {

		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PSNL";
		
		// mrd 출력물
		String rexFileName = fileName+".crf";
		// 보낼 파라미터 
			
		//검색조건
		String serarchParam = "";
		
		String eymtBgnnDtS = PersonalUtil.getConvertDateToString(searchEmymtBgnnDtS, "yyyyMMdd");	//고용시작일	
//		String searchEmymtBgnnDtS = this.searchEmymtBgnnDtS.getValue() == null ? "" : PersonalUtil.getConvertDateToString(this.searchEmymtBgnnDtS, "yyyyMMdd");	//고용시작일
		String emymtBgnnDtE = this.searchEmymtBgnnDtE.getValue() == null ? "" : PersonalUtil.getConvertDateToString(this.searchEmymtBgnnDtE, "yyyyMMdd"); //고용종료일
//		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
		String hdofcCodtnCd = PersonalUtil.getPrintStrToMultiData(listStoreA003,searchHdofcCodtnCd.getValue(),"commCdNm","commCd");  
		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
		
		String deptCd = "";
//		Window.alert(srhDeptNm.getValue());
		if("".equals(srhDeptNm.getValue()) || srhDeptNm.getValue() == null) {
			deptCd = "";
		}else {
			deptCd = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); //소속부서
		}
//		String deptCd = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); //소속부서
		String businCd = PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd") == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"); //사업
		String typOccuCd = PersonalUtil.getSelectedComboValue(srhTypOccuCd, "typOccuCd") == null ? "" : PersonalUtil.getSelectedComboValue(srhTypOccuCd, "typOccuCd"); //직종
		String dtilOccuInttnCd = PersonalUtil.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd");  //직종세	
		//직종별통계현황은 공무직만...
		if("PSNLT0652".equals(fileName)){
			emymtDivCd = MSFConfiguration.EMYMT_DIVCD01;
		}
			
		serarchParam += ""+eymtBgnnDtS+"⊥";			//$1 고용시작일
		serarchParam += ""+emymtBgnnDtE+"⊥";		//$2 고용시작일
		serarchParam += ""+hdofcCodtnCd+"⊥";		//$3 재직구분
		serarchParam += ""+emymtDivCd+"⊥";			//$4 고용구분
		serarchParam += ""+deptCd+"⊥";				//$5 부서
		serarchParam += ""+businCd+"⊥";				//$6 사업
		serarchParam += ""+typOccuCd+"⊥";			//$7 직종
		serarchParam += ""+dtilOccuInttnCd+"⊥";		//$8 직종세
		
		String strParam = ""  + serarchParam;
		//GWT 타입으로 팝업 호출시  postCall true 설정
		
		PrintUtils.setPostCall(true);
		PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
		}
/**
	private void Psn0600Print(String fileName) {

		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PSNL";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터 
		
		//검색조건
		String serarchParam = "";
		
		String searchEmymtBgnnDtS = this.searchEmymtBgnnDtS.getValue() == null ? "" : PersonalUtil.getConvertDateToString(this.searchEmymtBgnnDtS, "yyyyMMdd"); 
		String searchEmymtBgnnDtE = this.searchEmymtBgnnDtE.getValue() == null ? "" : PersonalUtil.getConvertDateToString(this.searchEmymtBgnnDtE, "yyyyMMdd"); 
		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
		String deptCd = MSFSharedUtils.allowNulls(srhDeptCd.getValue()); //소속부서
		String businCd = PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd") == null ? "" : PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"); 
		String typOccuCd = PersonalUtil.getSelectedComboValue(srhTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(srhTypOccuCd, "commCd"); //직종
		
		//직종별통계현황은 공무직만...
		if("PSNLT0652".equals(fileName)){
			emymtDivCd = "A0020010";
		}
		
		serarchParam += "["+searchEmymtBgnnDtS+"]";
		serarchParam += "["+searchEmymtBgnnDtE+"]";
		serarchParam += "["+hdofcCodtnCd+"]";
		serarchParam += "["+emymtDivCd+"]";
		serarchParam += "["+deptCd+"]";
		serarchParam += "["+businCd+"]";
		serarchParam += "["+typOccuCd+"]";
	
		String strParam = "/rp " + serarchParam;
		
		//System.out.println(strParam);
		
		//String strParam = "/rp " + "[" + "20080311" + "]";
		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
		
		System.out.println(strParam);
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);

	}
	*/
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {
		
		sysComBass0320Dto = new PrgmComBass0320DTO();
		
		// FormPanel panel = new FormPanel();
		// panel.setFrame(true);
		// panel.setHeaderVisible(false);
		// panel.setIcon(MSFMainApp.ICONS.form());
		// panel.setHeadingText("FormPanel");
		// panel.setSize(600, -1);
		// panel.setLabelAlign(LabelAlign.TOP);
		// panel.setButtonAlign(HorizontalAlignment.CENTER);

		// FormPanel form2 = new FormPanel();
		// form2.setFrame(true);
		// form2.setHeadingHtml("Simple Form with FieldSets");
		// form2.setWidth(350);
		plFrmPsnl0650.setLayout(new FlowLayout());
		
		searchPyspGrdeCd = new  HiddenField<String>();
		
		 /**
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * 직종 콤보박스 처리  시작
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
         */
//		ContentPanel typOccuCdGrid = new ContentPanel();  
//		typOccuCdGrid.setVisible(false);
//                   
//		//직종 콤보처리 
//		comTypOccuCdGridPanel = new MSFGridPanel(comTypOccuCd, false, false, false, true); 
//		comTypOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//			public void handleEvent(ComponentEvent be) {  
//				comTypOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//					public void handleEvent(StoreEvent<BaseModel> be) {  
//						listStoreA041.add(comTypOccuCdGridPanel.getMsfGrid().getStore().getModels());  
//					}  
//				});  
//			}  
//		});  
//		
//		typOccuCdGrid.add(comTypOccuCdGridPanel); 
//		plFrmPsnl0650.add(typOccuCdGrid);
		listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		 /**
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * 직종 콤보박스 처리 종료
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
         */
             
		
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
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchLeft = new LayoutContainer();
		
		LayoutContainer lcSchLeft_1 = new LayoutContainer();
		lcSchLeft_1.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchLeft_DtS = new LayoutContainer();
		FormLayout frmlytSchLeftDate_1 = new FormLayout();
		frmlytSchLeftDate_1.setLabelWidth(80);
		frmlytSchLeftDate_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft_DtS.setLayout(frmlytSchLeftDate_1);
		lcSchLeft_DtS.setBorders(false);
		
		searchEmymtBgnnDtS = new DateField();
		new DateFieldMask(searchEmymtBgnnDtS, "9999.99.99");
		searchEmymtBgnnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchEmymtBgnnDtS.setFieldLabel("고용시작일");
//		searchEmymtBgnnDtS.setLabelStyle("text-align:center;");
		lcSchLeft_DtS.add(searchEmymtBgnnDtS, new FormData("100%"));
		lcSchLeft_1.add(lcSchLeft_DtS, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));	//고용시작일
		
		
		LayoutContainer lcSchLeft_DtE = new LayoutContainer();
		FormLayout frmlytSchLeftDate_2 = new FormLayout();
		frmlytSchLeftDate_2.setLabelWidth(10);
		frmlytSchLeftDate_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft_DtE.setLayout(frmlytSchLeftDate_2);
		lcSchLeft_DtE.setBorders(false);
		
		searchEmymtBgnnDtE = new DateField();
		searchEmymtBgnnDtE.setLabelSeparator("~");
		new DateFieldMask(searchEmymtBgnnDtE, "9999.99.99");
		searchEmymtBgnnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		searchEmymtBgnnDtE.setLabelStyle("text-align:center;");
		searchEmymtBgnnDtE.setLabelSeparator("~");
		lcSchLeft_DtE.add(searchEmymtBgnnDtE, new FormData("100%"));
		lcSchLeft_1.add(lcSchLeft_DtE, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));	//고용종료일	
		
		lcSchLeft.add(lcSchLeft_1, new FormData("100%"));	
		
		
		LayoutContainer lcSchLeftTypOccuCd= new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcSchLeftTypOccuCd_1= new LayoutContainer();
		
		
		FormLayout frmlytLeftTypOccuCd = new FormLayout();
		frmlytLeftTypOccuCd.setLabelAlign(LabelAlign.RIGHT);
		frmlytLeftTypOccuCd.setLabelWidth(80);
		lcSchLeftTypOccuCd_1.setLayout(frmlytLeftTypOccuCd);
		
	       
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
        
        
        lcSchLeftTypOccuCd_1.add(srhDeptGpCd, new FormData("100%"));
        lcSchLeftTypOccuCd.add(lcSchLeftTypOccuCd_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
        
        
        
        
		LayoutContainer lcSchLeftTypOccuCd_2= new LayoutContainer();
		
		frmlytLeftTypOccuCd = new FormLayout();
		frmlytLeftTypOccuCd.setLabelAlign(LabelAlign.RIGHT);
//		frmlytLeftTypOccuCd.setLabelWidth(0);
		frmlytLeftTypOccuCd.setDefaultWidth(0);
		lcSchLeftTypOccuCd_2.setLayout(frmlytLeftTypOccuCd);
		
		
		srhTypOccuCd = new ComboBox<BaseModel>();
		srhTypOccuCd.setLabelSeparator("");
//		srhTypOccuCd.setFieldLabel("직 종");
        srhTypOccuCd.setForceSelection(true);
        srhTypOccuCd.setMinChars(1);
        srhTypOccuCd.setHideLabel(true);
        srhTypOccuCd.setDisplayField("typOccuNm");
        srhTypOccuCd.setValueField("typOccuCd");
        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
        srhTypOccuCd.setEmptyText("--직종선택--");
        srhTypOccuCd.setSelectOnFocus(true);
        srhTypOccuCd.setStore(listStoreA041);
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) { 
            	 //2015.11.30 추가 
            	 if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
	    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
	    			   BaseModel  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
	                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
	                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
	                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
	                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
	                      //         mdSelect = tpMdSelect;
	                         //  } 
	                     //  }  
	                   
	                      
	    			   srhTypOccuCd.setValue(mdSelect);
	                   // }  
	                    
                }  } 
             
         }
     }); 
        srhTypOccuCd.addListener(Events.Change, new Listener<BaseEvent>() {
        	@Override
       	 	public void handleEvent(final BaseEvent be) { 
        		if (MSFSharedUtils.paramNotNull(srhTypOccuCd.getValue())) {	
        			 if(srhTypOccuCd.getValue() != null){
	    				 PrgmComBass0350DTO sysComBass0350Dto = new PrgmComBass0350DTO();
	    				// sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
	    				 sysComBass0350Dto.setDeptCd(srhDeptCd.getValue());
	    				 sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd, "typOccuCd"));
        				
	    				  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
	                          
	                          lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	                        //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
	                          
	                          lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
	                              public void handleEvent(StoreEvent<BaseModel> be) {  
	                                  mDtalistDtilOccuInttnCd = PersonalUtil.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
	    			 }else{
	    				 srhDtilOccuInttnCd.setStore(new ListStore<ModelData>());
	    				 srhDtilOccuInttnCd.setEmptyText("--직종선택--");
	    				// srhDtilOccuInttnCd.setValue(new ModelData());
					}
				}
			}
		});
        
        
        lcSchLeftTypOccuCd_2.add(srhTypOccuCd, new FormData("100%"));
        lcSchLeftTypOccuCd.add(lcSchLeftTypOccuCd_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
        
        
        lcSchLeft.add(lcSchLeftTypOccuCd, new FormData("100%"));

        
		LayoutContainer lcSchCenter = new LayoutContainer();
		//검색 소속부서 코드 처리  
		LayoutContainer lcSchCenterDept = new LayoutContainer();
		lcSchCenterDept.setLayout(new ColumnLayout());
//		LayoutContainer lccmlcDeptNm = new LayoutContainer();
//		lccmlcDeptNm.setLayout(new ColumnLayout());
		//부서 
		srhDeptCd = new TextField<String>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setVisible(false);
		srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
			
			@Override
        	public void handleEvent(BaseEvent be) { 
        		if(srhDeptCd.getValue() != null){
        			
        				if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") ))) {
        					
        					PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
        					dto.setBusinApptnYr("");  
        					dto.setDeptCd(srhDeptCd.getValue()); 
        					//--------------------사업 불러 오는 함수 -------------------------------------------------
        					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
        					//--------------------사업 불러 오는 함수 -------------------------------------------------
        					srhBusinCd.setStore(lsBusinCd); 
        					
        					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        						public void handleEvent(StoreEvent<BaseModel> be) {  
		        				//srhBusinCd.setValue(lsBusinCd.getAt(0));  
        						}
        					});    
        				} else  if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
   	            		     					
        					//2015.11.30 권한 직종가져오기  추가 
//   	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
        					sysComBass0320Dto.setDeptCd(srhDeptCd.getValue());
   	            	       listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   	            	       srhTypOccuCd.setStore(listStoreA041);
   	            	   } else {
   	            		     
   	            	   } 
        		} 
			}
//			@Override
//			public void handleEvent(BaseEvent be) { 
//				if(srhDeptCd.getValue() != null){
//					
//					if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") ))) {
//    					PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//    					dto.setBusinApptnYr("");  
//    					dto.setDeptCd(srhDeptCd.getValue()); 
//    					//--------------------사업 불러 오는 함수 -------------------------------------------------
//    					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//    					//--------------------사업 불러 오는 함수 -------------------------------------------------
//    					srhBusinCd.setStore(lsBusinCd); 
//    					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//    						public void handleEvent(StoreEvent<BaseModel> be) {  
//	        				//srhBusinCd.setValue(lsBusinCd.getAt(0));  
//    						}
//    					});    
//    				} else  if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
//	            		   //2015.11.30 권한 직종가져오기  추가 
//	            		 // sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	            		   sysComBass0320Dto.setDeptCd(srhDeptCd.getValue());
//	            	       listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
//	            	      
//	            	   } else {
//	            		     
//	            	   } 
//					
//					
////					if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") ))) {
////						PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
////			        	dto.setBusinApptnYr("");  
////			        	dto.setDeptCd(srhDeptCd.getValue()); 
////			        	//--------------------사업 불러 오는 함수 -------------------------------------------------
////			        	lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
////			        	//--------------------사업 불러 오는 함수 -------------------------------------------------
////			        	srhBusinCd.setStore(lsBusinCd); 
////			        	srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
////			        		public void handleEvent(StoreEvent<BaseModel> be) {  
////			        				//srhBusinCd.setValue(lsBusinCd.getAt(0));  
////			        		}
////			        	});    
////					}
//				} 
//			}
		});
		plFrmPsnl0650.add(srhDeptCd);
		srhMangeDeptCd = new TextField<String>();
		srhMangeDeptCd.setName("srhMangeDeptCd");
		srhMangeDeptCd.setVisible(false);
		plFrmPsnl0650.add(srhMangeDeptCd);
		srhMangeDeptNm = new TextField<String>();
		srhMangeDeptNm.setName("srhMangeDeptNm");
		srhMangeDeptNm.setVisible(false);
		plFrmPsnl0650.add(srhMangeDeptNm);
			 
		LayoutContainer lcDeptNm = new LayoutContainer(); 
//		lcDeptNm.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytlcDeptNm = new FormLayout();
		frmlytlcDeptNm.setLabelWidth(60);
		frmlytlcDeptNm.setLabelAlign(LabelAlign.RIGHT);
		lcDeptNm.setLayout(frmlytlcDeptNm);
			     
		srhDeptNm = new TextField<String>();
		srhDeptNm.setName("srhDeptNm");
		srhDeptNm.setFieldLabel("부서");  
		srhDeptNm.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptNm.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {
				
				if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
					srhDeptCd.setValue("");
					srhMangeDeptCd.setValue("");
					
				}
				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
					//if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
						srhDeptCd.setValue("");
						srhMangeDeptCd.setValue("");
					//}
					fnPopupCommP140(srhDeptNm.getValue());
				}
				super.componentKeyDown(event); 
			}
		});
			        
//		srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent be) { 
//				//if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//					srhDeptCd.setValue("");
//					srhMangeDeptCd.setValue("");
//				//}
//			} 
//		});        
		lcDeptNm.add(srhDeptNm, new FormData("100%"));  
			         
		btnSrhDeptCd = new Button();
		btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
	    btnSrhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				//if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
					srhDeptCd.setValue("");
			    	srhMangeDeptCd.setValue("");
				//}
				fnPopupCommP140(srhDeptNm.getValue()); 
			}
		});
			           
		lcSchCenterDept.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
		lcSchCenterDept.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));		
		lcSchCenter.add(lcSchCenterDept, new FormData("100%"));
		
		LayoutContainer lcSchCenterDtilOccuInttnCd= new LayoutContainer();
		FormLayout frmlytlcDtilOccuInttnCd = new FormLayout();
		frmlytlcDtilOccuInttnCd.setLabelWidth(0);
		frmlytlcDtilOccuInttnCd.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenterDtilOccuInttnCd.setLayout(frmlytlcDtilOccuInttnCd);
		
		
	    srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
        srhDtilOccuInttnCd.setHideLabel(true);
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
//        srhDtilOccuInttnCd.setLabelSeparator("");
        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
        srhDtilOccuInttnCd.setWidth(100);
       // srhDtilOccuInttnCd.setHideLabel(true);
//        srhDtilOccuInttnCd.setFieldLabel("직종세");
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
		  
		lcSchCenterDtilOccuInttnCd.add(srhDtilOccuInttnCd, new FormData("100%"));
		lcSchCenter.add(lcSchCenterDtilOccuInttnCd, new FormData("100%"));
		
		
		LayoutContainer lcSchRight = new LayoutContainer();
		
		LayoutContainer lcSchRight_1 = new LayoutContainer();
		lcSchRight_1.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchRight_1_1 = new LayoutContainer();
		FormLayout frmlytSchRight_1_1 = new FormLayout();
		frmlytSchRight_1_1.setLabelWidth(60);
		frmlytSchRight_1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight_1_1.setLayout(frmlytSchRight_1_1);
		
		searchHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
        searchHdofcCodtnCd.setName("searchHdofcCodtnCd");
        searchHdofcCodtnCd.setEmptyText("--재직선택--");
        searchHdofcCodtnCd.setReadOnly(true);
        searchHdofcCodtnCd.setEnabled(true); 
        searchHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
        searchHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
        searchHdofcCodtnCd.setFieldLabel("재직");
        searchHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
//                srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//                srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
            }
        }); 
        searchHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {   
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                }  
            } 
        });
		lcSchRight_1_1.add(searchHdofcCodtnCd, new FormData("100%"));		

//		searchHdofcCodtnCd = new ComboBox<BaseModel>();
//		searchHdofcCodtnCd.setFieldLabel("재직구분");
//		searchHdofcCodtnCd.setForceSelection(true);
//		searchHdofcCodtnCd.setMinChars(1);
//		searchHdofcCodtnCd.setDisplayField("commCdNm");
//		searchHdofcCodtnCd.setValueField("commCd");
//		searchHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
//		//searchHdofcCodtnCd.setEmptyText("--재직구분선택--");
//		searchHdofcCodtnCd.setSelectOnFocus(true);
//		searchHdofcCodtnCd.setStore(listStoreA003);
//		lcSchRight_1_1.add(searchHdofcCodtnCd, new FormData("100%"));
		
		
		LayoutContainer lcSchRight_1_2 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcSchRight_1_2_1 = new LayoutContainer();
		
		
		FormLayout frmlytSchRight_1_2 = new FormLayout();
		frmlytSchRight_1_2.setLabelWidth(60);
		frmlytSchRight_1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight_1_2_1.setLayout(frmlytSchRight_1_2);
		
		searchEmymtDivCd = new ComboBox<BaseModel>();
		searchEmymtDivCd.setFieldLabel("고용구분");
		searchEmymtDivCd.setForceSelection(true);
		searchEmymtDivCd.setMinChars(1);
		searchEmymtDivCd.setDisplayField("commCdNm");
		searchEmymtDivCd.setValueField("commCd");
		searchEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		searchEmymtDivCd.setEmptyText("--고용구분선택--");
		searchEmymtDivCd.setSelectOnFocus(true);
		searchEmymtDivCd.setName("searchEmymtDivCd");
		searchEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		searchEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		searchEmymtDivCd.setStore(listStoreA002);
		listStoreA002.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) { 
            	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPsnl0650Auth("searchEmymtDivCd", listStoreA002); 
               	 }
            }
		});
		
		searchEmymtDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				String emymt = searchEmymtDivCd.getValue() == null ? "" : String.valueOf(searchEmymtDivCd.getValue().get("commCd")) ;
				
				if(MSFConfiguration.EMYMT_DIVCD01.equals(emymt)){ //공무직일 경우
					
					srhDeptCd.fireEvent(Events.Add); 
					
   					srhTypOccuCd.setValue(new BaseModel());
   					
   					srhDtilOccuInttnCd.reset();
   					srhDtilOccuInttnCd.setEnabled(false);
   					
   					srhBusinCd.setEnabled(false); 
   					srhBusinCd.setValue(new BaseModel());
   					 
   	                 if (gwtExtAuth.getEnableTypOccuCd()) { 
   	                	 srhTypOccuCd.setEnabled(true);
   	                	 srhDtilOccuInttnCd.setEnabled(true); 
   	                    // srhDtilOccuInttnCd.setEnabled(true); 
   	                 } else { 
   	                	 srhTypOccuCd.setEnabled(false);
   	                	 srhDtilOccuInttnCd.setEnabled(false);   
   	                    // srhDtilOccuInttnCd.setEnabled(false);
   	                     
   	                 }
   					
   				}else if(MSFConfiguration.EMYMT_DIVCD02.equals(emymt)){ //기간제 계약직일 경우
   					srhDeptCd.fireEvent(Events.Add); 
   				
   					srhTypOccuCd.setValue(new BaseModel());
   					srhTypOccuCd.setEnabled(false);
   					
   					srhDtilOccuInttnCd.reset();
   	               	srhDtilOccuInttnCd.setEnabled(false);
   	               
   	               	srhBusinCd.setValue(new BaseModel());
					srhBusinCd.setEnabled(true);
   				} 
			}
		});
		lcSchRight_1_2_1.add(searchEmymtDivCd, new FormData("100%"));
		lcSchRight_1_2.add(lcSchRight_1_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
		
		LayoutContainer lcSchRight_1_2_2 = new LayoutContainer();
		
	  //  lcSchCol.add(layoutContainer_101);
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0);
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lcSchRight_1_2_2.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(false);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	    srhRepbtyBusinDivCd.setValueField("commCd");
	    srhRepbtyBusinDivCd.setHideLabel(true);
	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
//	    srhRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    lcSchRight_1_2_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    lcSchRight_1_2_2.setBorders(false);
	    lcSchRight_1_2.add(lcSchRight_1_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		lcSchRight_1.add(lcSchRight_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchRight_1.add(lcSchRight_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		lcSchRight.add(lcSchRight_1, new FormData("100%"));
		
		LayoutContainer lcSchRight_2 = new LayoutContainer();
		FormLayout frmlytSchRight_2 = new FormLayout();
		frmlytSchRight_2.setLabelWidth(60);
		frmlytSchRight_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight_2.setLayout(frmlytSchRight_2);
		
		srhBusinCd = new ComboBox<BaseModel>();
        srhBusinCd.setFieldLabel("사업명");
        srhBusinCd.setForceSelection(true);
        srhBusinCd.setMinChars(1);
        srhBusinCd.setDisplayField("businNm");
        srhBusinCd.setValueField("businCd");
        srhBusinCd.setTriggerAction(TriggerAction.ALL);
        srhBusinCd.setEmptyText("--사업선택--");
        srhBusinCd.setSelectOnFocus(true);
        srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
        srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        srhBusinCd.setStore(new ListStore<BaseModel>());
        srhBusinCd.setName("srhBusinCd");
		
        lcSchRight_2.add(srhBusinCd, new FormData("100%"));
        lcSchRight.add(lcSchRight_2, new FormData("100%"));
		
		
		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));	
		lcSchCol.add(lcSchCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));	
		

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmPsnl0650.add(fieldSet);
		// vp.add(panel);
	}

	private void createCheckBoxGrid() {
//
//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		sm = new CheckBoxSelectionModel<Psnl0100DTO>();
//		sm.setSelectionMode(SelectionMode.MULTI);
//		
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("hanNm");
//			}
//		});
//		configs.add(column);
//		
//
//		column = new ColumnConfig();
//		column.setId("resnRegnNum");
//		column.setHeaderText("주민번호");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("resnRegnNum");
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivCdNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("emymtDivCdNm");
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("currAffnDeptCdNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(250);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("currAffnDeptCdNm");
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig("typOccuCdNm", "직종", 250);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("typOccuCdNm");
//			}
//		});
//		configs.add(column);
//
//
//		ColumnModel cm = new ColumnModel(configs);
//
//		ContentPanel cp = new ContentPanel();
//		cp.setHeaderVisible(false);
//		cp.setFrame(true);
//		cp.setIcon(MSFMainApp.ICONS.table());
//		cp.setLayout(new FitLayout());
//		cp.setSize(600, 300);
//
//		psnl0100Grid = new Grid<Psnl0100DTO>(psnl0100Store, cm);
//		psnl0100Grid.setStateId("psnl0100GridId");
//		psnl0100Grid.setStateful(true);
//		psnl0100Grid.setLoadMask(true);
//		psnl0100Grid.setAutoExpandColumn("typOccuCdNm");;
//		psnl0100Grid.setBorders(true);
//		psnl0100Grid.setSelectionModel(sm);
////		psnl0100Grid.setColumnReordering(true);
//		//psnl0100Grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
//		psnl0100Grid.addPlugin(sm);
//
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("출력대상자정보");

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");

		FieldSet fieldSet_1 = new FieldSet();

		LayoutContainer layoutContainer = new LayoutContainer();

		outputTypeRadiogroup = new RadioGroup();
		outputTypeRadiogroup.setBorders(false);
		outputTypeRadiogroup.setFieldLabel("출력조건");

		Radio radio = new Radio();
		radio.setBoxLabel("부서별통계현황");
		radio.setHideLabel(true);
		radio.setValue(true);
		radio.setValueAttribute("PSNLT0650");
		outputTypeRadiogroup.add(radio);

		radio = new Radio();
		radio.setBoxLabel("고용구분별통계현황");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0651"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("직종별통계현황(공무직)");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0652"); 
		outputTypeRadiogroup.add(radio);
		
		layoutContainer.add(outputTypeRadiogroup);
		
		
		fieldSet_1.add(layoutContainer);

		layoutContainer.setLayout(new FlowLayout(5));
		layoutContainer.setBorders(true);
		plFrmPsnl0650.add(fieldSet_1);
		fieldSet_1.setHeadingHtml("출력조건");
		fieldSet_1.setCollapsible(false);
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdGrid.setLayout(frmlytStd);

//		ContentPanel cpGrid = new ContentPanel();
//		cpGrid.setBodyBorder(false);
//		cpGrid.setHeaderVisible(false);
//		cpGrid.setLayout(new FitLayout());
//		cpGrid.setSize(935, 350);
//
//		cpGrid.add(psnl0100Grid);
//		psnl0100Grid.setHeight("345px");
//		lcStdGrid.add(cpGrid);
//		fieldSet.add(lcStdGrid);

//		plFrmPsnl0650.add(fieldSet_1);

	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	 //부서 
    private void fnPopupCommP140(String deptCd) {
        //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨.
        
        MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
        
        final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
       
        popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource();
                if (!"".equals(mapModel.get("deptCd"))) { 
                   // srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
                   // srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
                    srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                    srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));  
                }  
            }
        });
	}
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
