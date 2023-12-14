package com.app.exterms.personal.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
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
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

/**
 * ===================================================================  
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * ===================================================================  
 **/
public class Psnl0295 extends MSFPanel {

/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 시작} 
 * #######################################################	 
 */
	
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnl0295Bar;	
	private Button btnPsnl0295Init;					//초기화 버튼
	private Button btnPsnl0295Sreach;				//조회 버튼
	private Button btnPsnl0295Excel;				//엑셀 버튼
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색조건 폼 시작 --------------
	private ComboBox<BaseModel> srhYear;						//년도
	     
	private ComboBox<BaseModel> srhEmymtDivCd; 					//고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 			//호봉제구분코드  
	private ComboBox<BaseModel> srhBusinCd; 					//사업
	private ComboBox<BaseModel> srhPayrMangDeptCd; 				//단위기관
	private TextField<String> srhHanNm;         				//성명
	private TextField<String> srhResnRegnNum;   				//주민번호 
	//private TextField<String> srhMangeDeptCd; 					//관리부서 수정
	//private TextField<String> srhMangeDeptNm; 					//관리부서 수정
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

	private HiddenField<String> systemkey;   					//시스템키
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 		//재직 
	private MSFMultiComboBox<ModelData> srhDeptCd ; 			//부서 
	private ComboBox<BaseModel> srhDeptGpCd; 					//부서직종그룹코드	
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 			//직종  
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 	//직종세
    private CheckBox srhHodyFixYn;								//확정여부
	
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;
	    
	private boolean mutilCombo = false;
	 
	private Boolean emptyCheck = false ;

	// -------------- 검색조건 폼 종료 --------------
    
	//직종 콤보
//	private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	private MSFGridPanel typOccuCdGridPanel;

	//년도 콤보 
	private LookupSysComYear lkPayYr = new LookupSysComYear();  
	    
	// -------------- List<ModelData> 선언 시작 ---------------
	private ListStore<BaseModel> lsPayrMangDeptCd   	= new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>();	//사업	
	private ListStore<BaseModel> lsHdofcCodtnCd 		= new ListStore<BaseModel>(); 	//재직상태 
	private ListStore<BaseModel> lsDeptCd 		    	= new ListStore<BaseModel>();	//부서콤보
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();	//직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsPayCd 				= new ListStore<BaseModel>(); 	//급여구분
	private ListStore<BaseModel> lsPayYrStore 			= new ListStore<BaseModel>();  	//년도 
	private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>();	//고용구분 
	private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드  	
	private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 

	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서


	private HashMap<String, String> param = new HashMap<String, String>();
	// -------------- List<ModelData> 선언 종료  ---------------
		
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
	private Psnl0126Def psnl0126Def  = new Psnl0126Def("PSNL0295");   //그리드 테이블 컬럼 define  
	private MSFGridPanel psnl0126GridPanel;
	// -------------- grid 선언 종료  ---------------
		
	private BaseModel record;
	private Iterator<Record> records;
	private ActionDatabase actionDatabase;

		
	// -------------- 코드 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();	//공통코드 
	private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();	//부서코드 
	// -------------- 코드 호출 종료 --------------
		
	// -------------- 서비스 호출 시작 --------------
	private Psnl0100ServiceAsync psnl0100Service = Psnl0100Service.Util.getInstance();
	private Psnl0290ServiceAsync psnl0126Service = Psnl0290Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
//	private RpcProxy<BaseListLoadResult<Psnl0290DTO>> psnl0290Proxy = new RpcProxy<BaseListLoadResult<Psnl0290DTO>>() {
//		@Override
//		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0290DTO>> callback) {
//			
//			Psnl0290DTO dto = new Psnl0290DTO();
//			
//			dto.setHodyApptnYr(PersonalUtil.getSelectedComboValue(searchYear,"commCd"));
//			dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(srhDeptCd.getValue()) );
//			dto.setEmymtDivCd(PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
//			dto.setDeptCd(MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
//			dto.setBusinCd(PersonalUtil.getSelectedComboValue(searchBusinCd,"businCd"));
//			dto.setHanNm(searchName.getValue());
//			dto.setResnRegnNum(searchResnNum.getValue());
//			
//			try{
//				psnl0290Service.selectPsnl0290((BaseListLoadConfig) loadConfig,	dto, callback);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//	};
//	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0290Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0290Proxy);
//	private ListStore<Psnl0290DTO> psnl0290Store = new ListStore<Psnl0290DTO>(psnl0290Loader);
//	
	
/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 종료} 
 * #######################################################	 
 */

	private VerticalPanel vp;
	private FormPanel plFrmPsnl0295;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

//	private GridCellRenderer<Stock> gridNumber;
//	private GridCellRenderer<Stock> change;

	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

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
	  private void checkPsnl0295Auth( String authAction, ListStore<BaseModel> bm) {   
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

			   Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd };

				gwtAuthorization.formAuthFieldConfig(fldArrField);
				gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
				
				srhYear.setValue(lsPayYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
    		* 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
    		**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		   //String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
		  //gwtAuthorization.formAuthPopConfig(plFrmPsnl0290, "","searchEmymtDivCd",strArrDeptCd,"searchTypOccuCd","searchBusinCd");
		   //gwtAuthorization.formAuthPopConfig(plFrmPsnl0290, "","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
		   //gwtAuthorization.formAuthConfig(plFrmPsnl0295, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
		   //gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
		   // GWTAuthorization.formAuthConfig(plFrmPsnl0250, "","searchEmymtDivCd","searchDeptCd","searchTypOccuCd","searchYearBusinCd");
		   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    * 권한설정을 위한 콤보처리를 위한 메서드 종료
		    **++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		   //srhDeptCd.fireEvent(Events.Add);
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
			     
		HashMap<String, Boolean> authMapDef = new HashMap<String,Boolean>(); 
			     
		authMapDef.put("srhYear",Boolean.FALSE);
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
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/		
	  
	
	public ContentPanel getViewPanel() {
		if (panel == null) {
			
			 //콤보 권한초기화
			initLoad();
			
			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0295Form();	// 화면 기본정보를 설정
			createSearchForm();		// 검색필드를 적용
			createListGrdForm();	// 휴가정보 그리드	
			add(vp);
			vp.setSize("1010px", "700px");

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
	public Psnl0295() {
		setSize("1010px", "700px");
	}

	public Psnl0295(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0295Form() {

		plFrmPsnl0295 = new FormPanel();
		plFrmPsnl0295.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 휴가일수현황"));
		plFrmPsnl0295.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0295.setBodyStyleName("pad-text");
		plFrmPsnl0295.setFrame(true);
		plFrmPsnl0295.setPadding(2);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("휴가일수현황","PSNL0295");
				}
			});
		plFrmPsnl0295.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0295.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		//---------------------멀티콤보박스 닫기 -------------------------------------------------
		plFrmPsnl0295.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) { 
            	if (mutilCombo) {
            		if(srhDeptCd.getCheckBoxListHolder().isVisible()) {
            			//부서
            			srhDeptCd.showClose(ce);
                    	mutilCombo = false;
            		}else if ( srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
                      	//직종
            			srhTypOccuCd.showClose(ce);
                    	mutilCombo = false;
            		}else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                      	//직종세
            			srhDtilOccuInttnCd.showClose(ce);
                    	mutilCombo = false;
            		} else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
                      	//재직
            			srhHdofcCodtnCd.showClose(ce);
                    	mutilCombo = false;
            		}  
            	}
            } 
        });
        //---------------------멀티콤보박스 닫기 -------------------------------------------------	

		topPsnl0295Bar = new ButtonBar();
		topPsnl0295Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnPsnl0295Init = new Button("초기화");
		btnPsnl0295Init.setIcon(MSFMainApp.ICONS.new16());
		topPsnl0295Bar.add(btnPsnl0295Init);
		btnPsnl0295Init.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	
            	
            	srhHanNm.setValue("");
            	srhResnRegnNum.setValue("");
            	systemkey.setValue("");
            	srhHodyFixYn.setValue(false);
            	
                //그리드 초기화
            	psnl0126GridPanel.getMsfGrid().clearData();
            	
            }
        });

		
		btnPsnl0295Sreach = new Button("조회");
		topPsnl0295Bar.add(btnPsnl0295Sreach);
		btnPsnl0295Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0295Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//psnl0290Loader.load();
				if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
					if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
						return;
					} 
				}
				
				reload();
			}
		});
		
		
		btnPsnl0295Excel = new Button("엑셀");
		topPsnl0295Bar.add(btnPsnl0295Excel);
		btnPsnl0295Excel.setIcon(MSFMainApp.ICONS.excel16());
		btnPsnl0295Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//엑셀저장  
    			excelFileExport();
    		}
    	});


		plFrmPsnl0295.add(topPsnl0295Bar);

		// 파일업로드 처리
		plFrmPsnl0295.setAction("myurl");
		plFrmPsnl0295.setEncoding(Encoding.MULTIPART);
		plFrmPsnl0295.setMethod(Method.POST);

		vp.add(plFrmPsnl0295);
		plFrmPsnl0295.setSize("990px", "680px");
	}

	// 검색조건 시작
	private void createSearchForm() {

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
		
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	      
	        
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//급여구분 
		sysComBass0300Dto.setRpsttvCd("B015");	
		lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
	        
		//고용구분
		sysComBass0300Dto.setRpsttvCd("A002");	
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		//재직상태  
		sysComBass0300Dto.setRpsttvCd("A003");
		lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(lsHdofcCodtnCd) ; 
                srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
            }
		});   
		
		if(lsHdofcCodtnCd.getCount()>0){
//			cmbxSchHdofcCodtnCd.setValue(listStoreA003.getAt(0));
			srhHdofcCodtnCd.getStore().getAt(0) ; 
		}
		
		// 호봉
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	       
		//-------------------관리부서 추가  
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		
		//부서
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	 	sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	       
	  	lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);	
	        
		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
	            srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});  
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      

		//--------------------년도 불러 오는 함수 ------------------------------------------------
		lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);	
		//--------------------년도 불러 오는 함수 ------------------------------------------------ 
	        
	        
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		//lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
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
                 
              }
          });  
		   
			systemkey = new HiddenField<String>();

			plFrmPsnl0295.setLayout(new FlowLayout());

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
	        			
	        			checkPsnl0295Auth("srhYear", lsPayYrStore); 
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
//	        lcSchCol01_1.add(lcSchCol01_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
			
	        LayoutContainer layoutContainer_12 = new LayoutContainer();
	        
	     			FormLayout frmlytSch01_2 = new FormLayout();
	     			frmlytSch01_2.setLabelWidth(50);
	     			frmlytSch01_2.setLabelAlign(LabelAlign.RIGHT);
	     			layoutContainer_12.setLayout(frmlytSch01_2);
	     			
	     	         srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
	     	         srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
	     	         srhHdofcCodtnCd.setEmptyText("--재직선택--");
	     	         srhHdofcCodtnCd.setReadOnly(true);
	     	         srhHdofcCodtnCd.setEnabled(true); 
	     	         srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
	     	         srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
	     	         srhHdofcCodtnCd.setFieldLabel("재직");
	     	         srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	     	             public void handleEvent(StoreEvent<ModelData> be) {  
	     	                 srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
	     	                 srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
	     	             }
	     	         }); 
	     	         srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
	     	         layoutContainer_12.add(srhHdofcCodtnCd, new FormData("100%"));
	     	      
	     	         
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
			    		   		checkPsnl0295Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
		    			checkPsnl0295Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
//		    frmlytSch.setDefaultWidth(0);
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
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
	        FormLayout frmlytSch01_3 = new FormLayout();
	        frmlytSch01_3.setLabelWidth(60);
	        frmlytSch01_3.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_14.setLayout(frmlytSch01_3);
			
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
	            		 checkPsnl0295Auth("srhDeptCd", lsDeptCd); 
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
	       
//	        srhHanNm.addKeyListener(new KeyListener() {
//	            public void componentKeyUp(ComponentEvent event) {
////	                super.componentKeyUp(event);
//	                srhHanNm.validate();
//	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                	systemkey.setValue("");
//	                    srhResnRegnNum.setValue(""); 
//	                    fnPopupPsnl0100();
//	                }
//	            }
//	        });
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                	systemkey.setValue("");
//	                    srhResnRegnNum.setValue("");
//	                }
//	             
//	            } 
//	        }); 
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

	        
	        lcSchCol.add(lcSchCol01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));					// 년도 	
	        lcSchCol.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));					// 년도 	 
	        lcSchCol.add(lcSchCol02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));					// 단위기관
	        lcSchCol.add(lcSchCol03,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));					// 고용구분
	        
	        layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); // 재직
	        layoutContainer_13.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));// 부서
	        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		 // 직종
	        
	        lcSchCol3.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 사업
	        lcSchCol3.add(lcSchCol04_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));				// 성명
	        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));		// 
	       
	        fieldSet.add(lcSchCol, new FormData("100%"));
	        fieldSet.add(layoutContainer_13, new FormData("100%"));
	        fieldSet.add(lcSchCol3, new FormData("100%"));

			
//	        LayoutContainer lcSchCol01 = new LayoutContainer();
//			
//	        LayoutContainer lcSchCol01_1 = new LayoutContainer();
//	        lcSchCol01_1.setLayout(new ColumnLayout());
//	        
//	        
//	        LayoutContainer lcSchCol01_1_1 = new LayoutContainer();
//			
//	        lcSchCol01_1_1.setStyleAttribute("paddingLeft", "5px");
//	        FormLayout frmlytSch01_1_1 = new FormLayout();
//	        frmlytSch01_1_1.setLabelWidth(60);
//	        frmlytSch01_1_1.setLabelAlign(LabelAlign.RIGHT);
//	        lcSchCol01_1_1.setLayout(frmlytSch01_1_1);
//			
//	        srhYear = new ComboBox<BaseModel>();
//	        srhYear.setName("srhYear");
//	        srhYear.setForceSelection(true);
//	        srhYear.setMinChars(1);
//	        srhYear.setDisplayField("yearDisp");
//	        srhYear.setValueField("year");
//	        srhYear.setTriggerAction(TriggerAction.ALL);
//	        srhYear.setSelectOnFocus(true); 
//	        srhYear.setReadOnly(false);
//	        srhYear.setEnabled(true); 
//	        srhYear.setStore(lsPayYrStore);
//	        srhYear.setFieldLabel("년도"); 
//	        srhYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	        	public void handleEvent(StoreEvent<BaseModel> be) {   
//	        		
//	        		EventType type = be.getType();
//	        		if (type == Store.Add) { 
//	        			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//	        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//							++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	        			
//	        			checkPsnl0295Auth("srhYear", lsPayYrStore);  
//	        		}
//	        	}
//	        });
//	        srhYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	              public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                  //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	            	  BaseModel bmPayYr =  se.getSelectedItem(); 
//	            	  if (bmPayYr != null) {
//	            		  if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//	            			  if (srhDeptCd.getListView().getChecked().size() > 0) {  
//	            				  sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYear, "year"));
//	            				  List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//	            				  sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//	            			  }      
//	                    
//	            			  //--------------------사업 불러 오는 함수 -------------------------------------------------
//	            			  lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	            			  //--------------------사업 불러 오는 함수 -------------------------------------------------
//	            			  srhBusinCd.setStore(lsBusinCd); 
//	            			  srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	            				  public void handleEvent(StoreEvent<BaseModel> be) {  
//	                    		   //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	            				  }
//	            			  });    
//	            		  } else {
//	            			  // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
//	            			  // return;
//	            		  } 
//	            	  }       
//	              } 
//	        }); 
//	  
//			
//			
//	        lcSchCol01_1_1.add(srhYear, new FormData("100%"));
//	        lcSchCol01_1.add(lcSchCol01_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//			
//			
//			LayoutContainer lcSchCol01_1_2 = new LayoutContainer();
//			
//			lcSchCol01_1_2.setStyleAttribute("paddingLeft", "5px");
//			FormLayout frmlytSch01_1_2 = new FormLayout();
//			frmlytSch01_1_2.setLabelWidth(60);
//			frmlytSch01_1_2.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol01_1_2.setLayout(frmlytSch01_1_2);
//			
//			srhPayrMangDeptCd = new ComboBox<BaseModel>();
//	        srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
//	        srhPayrMangDeptCd.setForceSelection(true);
//	        srhPayrMangDeptCd.setMinChars(1);
//	        srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
//	        srhPayrMangDeptCd.setValueField("payrMangDeptCd");
//	        srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
//	        srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
//	        srhPayrMangDeptCd.setSelectOnFocus(true); 
//	        srhPayrMangDeptCd.setReadOnly(false);
//	        srhPayrMangDeptCd.setEnabled(true); 
//	        srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
//	        srhPayrMangDeptCd.setFieldLabel("단위기관"); 
//	        lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//	            	 EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			    		   		checkPsnl0295Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
//	                	 }
//	             
//	            }
//	        });    
//	        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                //단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
//	                // sysComBass0400Dto.setDeptDspyYn("Y");
//	                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	                   public void handleEvent(StoreEvent<BaseModel> be) {  
//	                     mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//	                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
//	                       
//	                   }
//	                });   
//	            } 
//	        });
//	        lcSchCol01_1_2.add(srhPayrMangDeptCd, new FormData("100%"));
//	        lcSchCol01_1_2.setBorders(false);
//	        lcSchCol01_1.add(lcSchCol01_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
//			
//	        
//	        LayoutContainer lcSchCol01_2 = new LayoutContainer();
//	        
//	        lcSchCol01_2.setStyleAttribute("paddingLeft", "5px");
//			FormLayout frmlytSch01_2 = new FormLayout();
//			frmlytSch01_2.setLabelWidth(60);
//			frmlytSch01_2.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol01_2.setLayout(frmlytSch01_2);
//			
//			srhDeptCd = new MSFMultiComboBox<ModelData>();
//	        srhDeptCd.setName("srhDeptCd");
//	        srhDeptCd.setEmptyText("--부서선택--");
//	        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
//	        srhDeptCd.getStore().add(mDtalistDeptCd);
//	        srhDeptCd.setWidth(100);
//	        srhDeptCd.setFieldLabel("부서");
//	        srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
//	             public void handleEvent(StoreEvent<ModelData> be) {  
//
//	                // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
//	            	  EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			                	checkPsnl0295Auth("srhDeptCd", lsDeptCd); 
//	               	 }
//	             }
//	         });    
//
//	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
//	        	@Override
//	        	public void handleEvent(ComponentEvent ce) { 
//	        		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//	        			if (srhDeptCd.getListView().getChecked().size() > 0) {  
//	        			    sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYear,"year"));   
//	        				List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//	        				sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//	        			}      
//	        			//--------------------사업 불러 오는 함수 -------------------------------------------------
//	        			lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	        			//--------------------사업 불러 오는 함수 -------------------------------------------------
//	        			srhBusinCd.setStore(lsBusinCd); 
//	        			srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	        				public void handleEvent(StoreEvent<BaseModel> be) {  
//	        					//   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	        				}
//	        			});    
//	                             
//	        		 } else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//  	            		 
//                   	  //2015.11.30 권한 직종가져오기  추가 
//	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	            		   String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
//	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
//	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
//	           	             
//	                             mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
//	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
//	                              
//	                           }
//	                       });  
//           	    
//               } else {
//           	  
//           	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//          		   String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//          		   sysComBass0320Dto.setDeptCd(strDeptCd);
//           	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
//        		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//       	            public void handleEvent(StoreEvent<BaseModel> be) {  
//       	             
//                         mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
//                         srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
//                          
//                       }
//                   });   
//             }
//	        	}  
//	        });  
//	          
//	        srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	        	@Override
//	        	public void handleEvent(ComponentEvent ce) {   
//	        		if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//	        			// GWT.log(" a" + ce.getEvent().getType());
//	        			mutilCombo = true;
//	        		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	        			mutilCombo = true;
//	        			//  GWT.log(" b" + ce.getEvent().getType());
//	        		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	        			mutilCombo = false;
//	        			//  GWT.log(" b" + ce.getEvent().getType());
//	        		}  
//	        	} 
//	        });	        
//	        lcSchCol01_2.add(srhDeptCd, new FormData("100%"));
//	        lcSchCol01_2.setBorders(false);
//	         
//	        lcSchCol01.add(lcSchCol01_1, new FormData("100%"));	//년도, 단위기관
//	    	lcSchCol01.add(lcSchCol01_2, new FormData("100%"));	//부서
//	         
//
//	    	LayoutContainer lcSchCol03 = new LayoutContainer();
//			
//			LayoutContainer lcSchCol03_1 = new LayoutContainer(new ColumnLayout());
//			
//			LayoutContainer lcSchCol03_1_1 = new LayoutContainer();
//			
//			
//			lcSchCol03_1.setStyleAttribute("paddingLeft", "5px");
//			FormLayout frmlytSch03_1 = new FormLayout();
//			frmlytSch03_1.setLabelWidth(60);
//			frmlytSch03_1.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol03_1_1.setLayout(frmlytSch03_1);
//			
//			srhEmymtDivCd = new ComboBox<BaseModel>();
//			srhEmymtDivCd.setFieldLabel("고용구분");
//			srhEmymtDivCd.setForceSelection(true);
//			srhEmymtDivCd.setMinChars(1);
//			srhEmymtDivCd.setDisplayField("commCdNm");
//			srhEmymtDivCd.setValueField("commCd");
//		    srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
//		    srhEmymtDivCd.setEmptyText("--고용구분선택--");
//		    srhEmymtDivCd.setSelectOnFocus(true);
//		    srhEmymtDivCd.setStore(lsEmymtDivCd);
//		    lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//		    	public void handleEvent(StoreEvent<BaseModel> be) { 
//		    		EventType type = be.getType();
//		    		if (type == Store.Add) { 
//		    			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		    			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//		    			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		    			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    			checkPsnl0295Auth("srhEmymtDivCd", lsEmymtDivCd); 
//		    		}
//		    	}
//		    });
//		    srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	            	BaseModel bmPayCd =  se.getSelectedItem(); 
//	            		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
//	            			srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
//	            			srhBusinCd.setEnabled(true);
//	            			srhTypOccuCd.reset();
//	            			srhTypOccuCd.setEnabled(false);
//	            			srhDtilOccuInttnCd.reset();
//	            			srhDtilOccuInttnCd.setEnabled(false);
//	            		 } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
//			            	 //20151130 추가 수정 
//		            	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//			            	 srhBusinCd.reset();
//		                     srhBusinCd.setEnabled(false);   
//			                 if (gwtExtAuth.getEnableTypOccuCd()) {
//			                	 srhTypOccuCd.setEnabled(true);
//			                     srhDtilOccuInttnCd.setEnabled(true); 
//			                 } else {
//			                	 srhTypOccuCd.setEnabled(false);
//			                     srhDtilOccuInttnCd.setEnabled(false);
//			                     
//			                 }
//		            	     
//		             }  
//	            	 
//	            } 
//		    });
//		    lcSchCol03_1_1.add(srhEmymtDivCd, new FormData("100%"));
//		    lcSchCol03_1_1.setBorders(false);
//		    lcSchCol03_1.add(lcSchCol03_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//		    
//		    
//		    
//		    
//			LayoutContainer lcSchCol03_1_2 = new LayoutContainer();
//			
//			lcSchCol03_1.setStyleAttribute("paddingLeft", "5px");
//			frmlytSch03_1 = new FormLayout();
//			frmlytSch03_1.setLabelWidth(0);
//			frmlytSch03_1.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol03_1_2.setLayout(frmlytSch03_1);
//			
//			
//		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
//		    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
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
//			
//			lcSchCol03_1_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
//			lcSchCol03_1_2.setBorders(false);
//			lcSchCol03_1.add(lcSchCol03_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//			
//			
//			
//			
//			LayoutContainer lcSchCol03_2 = new LayoutContainer();
//			lcSchCol03_2.setLayout(new ColumnLayout());
//			
//			LayoutContainer lcSchCol03_2_1 = new LayoutContainer();
//			
//			lcSchCol03_2_1.setStyleAttribute("paddingLeft", "5px");
//			FormLayout frmlytSch03_2_1 = new FormLayout();
//			frmlytSch03_2_1.setLabelWidth(60);
//			frmlytSch03_2_1.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol03_2_1.setLayout(frmlytSch03_2_1);
//			
//	        srhDeptGpCd  =  new ComboBox<BaseModel>(); 
//	        srhDeptGpCd.setName("srhDeptGpCd");
//	        srhDeptGpCd.setForceSelection(true);
//	        srhDeptGpCd.setAllowBlank(false);
//	        srhDeptGpCd.setMinChars(1);
//	        srhDeptGpCd.setDisplayField("commCdNm");
//	        srhDeptGpCd.setValueField("commCd");
//	        srhDeptGpCd.setTriggerAction(TriggerAction.ALL);
//	        srhDeptGpCd.setEmptyText("--그룹--");
//	        srhDeptGpCd.setSelectOnFocus(true); 
//	        srhDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//	        srhDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
//	        srhDeptGpCd.setStore(lsDeptGpCd);
//	        srhDeptGpCd.setFieldLabel("직종"); 
//	        
//	        lcSchCol03_2_1.add(srhDeptGpCd, new FormData("100%")); 
//			
//			
//	        
//	        LayoutContainer lcSchCol03_2_2 = new LayoutContainer();
//			
//			lcSchCol03_2_1.setStyleAttribute("paddingLeft", "5px");
//			FormLayout frmlytSch03_2_2 = new FormLayout();
//			frmlytSch03_2_2.setLabelWidth(0);
//			frmlytSch03_2_2.setDefaultWidth(0);
//			frmlytSch03_2_2.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol03_2_2.setLayout(frmlytSch03_2_2);
//			
//			srhTypOccuCd = new MSFMultiComboBox<ModelData>();
//	        srhTypOccuCd.setName("srhTypOccuCd"); 
//	        srhTypOccuCd.setEmptyText("--직종선택--"); 
//	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
//	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
////	        srhTypOccuCd.setLabelSeparator("");
//	        srhTypOccuCd.setHideLabel(true);
//	        srhTypOccuCd.setWidth(100);
////	        srhTypOccuCd.setFieldLabel("직종");
//	        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
//	            public void handleEvent(StoreEvent<ModelData> be) {  
//	            	
//	            	
//	    	       EventType type = be.getType();
//		    	   if (type == Store.Add) { 
//		    		 //2015.11.30 추가 
//		    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//		    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
//             	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
//		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//		                      //         mdSelect = tpMdSelect;
//		                         //  } 
//		                     //  }  
//		                   
//		                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
//		                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
//		                   // }  
//		                    
//                    }  
//		    		   }
//	            		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    		  // checkPsnl0295Auth("srhTypOccuCd", lsTypOccuCd); 
//	            	 }
//	            }
//	        });     
//	        
//	        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
//	        	@Override
//	        	public void handleEvent(ComponentEvent ce) {
//	        		
//	        		 //2015.11.30 추가 
//	            	 displayDtilOccuInttnCd();  
//	        	}  
//	        });  
//	         
//	        srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	            @Override
//	            public void handleEvent(ComponentEvent ce) {   
//	                
//	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//	                   // GWT.log(" a" + ce.getEvent().getType());
//	                    mutilCombo = true;
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	                    mutilCombo = true;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	                    mutilCombo = false;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                }  
//	            } 
//	        });
//	        //2015.11.30 추가 
//	        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent ce) {   
//	            	
//	            	displayDtilOccuInttnCd();
//	            } 
//	        }); 
//	        lcSchCol03_2_2.add(srhTypOccuCd, new FormData("100%")); 
//			
//			
//	        
//			LayoutContainer lcSchCol03_2_3 = new LayoutContainer();
//			
//			lcSchCol03_2_1.setStyleAttribute("paddingLeft", "5px");
//			frmlytSch03_2_1 = new FormLayout();
//			frmlytSch03_2_1.setLabelWidth(0);
//			frmlytSch03_2_1.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol03_2_3.setLayout(frmlytSch03_2_1);
//			
//			srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
//		    srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
//		    srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
//		    srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
//		    srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
//		    srhDtilOccuInttnCd.setWidth(100);
//		    srhDtilOccuInttnCd.setHideLabel(true);
//		    srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//		    	@Override
//		    	public void handleEvent(ComponentEvent ce) {    
//		    		if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
//		    			mutilCombo = true;
//		    		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//		    			mutilCombo = true;
//		    			//  GWT.log(" b" + ce.getEvent().getType());
//		    		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//		    			mutilCombo = false;
//		    			//  GWT.log(" b" + ce.getEvent().getType());
//		    		} else {
//		    		}  
//		    	} 
//		    });
//		    lcSchCol03_2_3.add(srhDtilOccuInttnCd, new FormData("100%"));
//			
//	        
//	        lcSchCol03_2.add(lcSchCol03_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
//	        lcSchCol03_2.add(lcSchCol03_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
//	        lcSchCol03_2.add(lcSchCol03_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
//	        
//	        lcSchCol03.add(lcSchCol03_1, new FormData("100%"));	//고용구분, 호봉
//			lcSchCol03.add(lcSchCol03_2, new FormData("100%"));	//직종, 직종세
//			
//			
//			LayoutContainer lcSchCol04 = new LayoutContainer();
//			
//			LayoutContainer lcSchCol04_1 = new LayoutContainer();
//			lcSchCol04_1.setLayout(new ColumnLayout());
//			
//			
//			LayoutContainer lcSchCol02_Nm = new LayoutContainer();
//			lcSchCol02_Nm.setLayout(new ColumnLayout());
//			
//			FormLayout frmlytSch02_Nm = new FormLayout();  
//			frmlytSch02_Nm.setLabelWidth(30); 
//			frmlytSch02_Nm.setLabelAlign(LabelAlign.RIGHT); 
//			lcSchCol02_Nm.setLayout(frmlytSch02_Nm);
//	        
//	        srhHanNm = new TextField<String>();
//	        srhHanNm.setName("srhHanNm");
//	        srhHanNm.setFieldLabel("성명");
//	        lcSchCol02_Nm.add(srhHanNm, new FormData("100%"));
//	        srhHanNm.addKeyListener(new KeyListener() {
//	            public void componentKeyUp(ComponentEvent event) {
//	                super.componentKeyUp(event);
//	                srhHanNm.validate();
//	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                	systemkey.setValue("");
//	                    srhResnRegnNum.setValue(""); 
//	                    fnPopupPsnl0100();
//	                }
//	            }
//	        });
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                	systemkey.setValue("");
//	                    srhResnRegnNum.setValue("");
//	                }
//	             
//	            } 
//	        }); 
//	        lcSchCol04_1.add(lcSchCol02_Nm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
//	        lcSchCol02_Nm.setBorders(false);
//	        
//	        LayoutContainer lcSchCol02_btnHanNm = new LayoutContainer();
//	        
//	        FormLayout frmlytSch02_btnHanNm = new FormLayout();  
//	        frmlytSch02_btnHanNm.setLabelWidth(0); 
//	        frmlytSch02_btnHanNm.setLabelAlign(LabelAlign.RIGHT); 
//	        lcSchCol02_btnHanNm.setLayout(frmlytSch02_btnHanNm);
//	        
//	        Button btnHanNm = new Button("검색");
//	        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
//	            public void handleEvent(ButtonEvent e) {
//	            	systemkey.setValue("");
//	                srhResnRegnNum.setValue("");  
//	                fnPopupPsnl0100() ;
//	            }
//	        });
//	        lcSchCol02_btnHanNm.add(btnHanNm, new FormData("100%"));
//	        lcSchCol04_1.add(lcSchCol02_btnHanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//	        
//	        LayoutContainer lcSchCol02_Jumin = new LayoutContainer();
//	        
//	        FormLayout frmlytSch02_Jumin = new FormLayout();  
//	        frmlytSch02_Jumin.setLabelWidth(0); 
//	        frmlytSch02_Jumin.setLabelAlign(LabelAlign.RIGHT); 
//	        lcSchCol02_Jumin.setLayout(frmlytSch02_Jumin);
//	        
//	        srhResnRegnNum = new TextField<String>();
//	        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");  
//	        srhResnRegnNum.setName("srhResnRegnNum");
//	        srhResnRegnNum.setHideLabel(true);
//	        srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
//	                	systemkey.setValue("");
//	                    srhHanNm.setValue("");
//	                }
//	            } 
//	        });
//	        lcSchCol02_Jumin.add(srhResnRegnNum, new FormData("100%"));
//	        lcSchCol04_1.add(lcSchCol02_Jumin, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
//	        lcSchCol02_Jumin.setBorders(false); 
//			
//	        lcSchCol04.add(lcSchCol04_1, new FormData("100%"));	//성명, 주민번호
//			
//	        lcSchCol04_1.setBorders(false);
//	        lcSchCol04.add(lcSchCol04_1, new FormData("100%"));	
//	        
//	        LayoutContainer lcSchCol04_2 = new LayoutContainer();
//			
//			lcSchCol04_1.setStyleAttribute("paddingLeft", "5px");
//			FormLayout frmlytSch04_2 = new FormLayout();
//			frmlytSch04_2.setLabelWidth(40);
//			frmlytSch04_2.setLabelAlign(LabelAlign.RIGHT);
//			lcSchCol04_2.setLayout(frmlytSch04_2);
//			
//			srhBusinCd = new ComboBox<BaseModel>();
//	        srhBusinCd.setName("srhBusinCd");
//	        srhBusinCd.setForceSelection(true);
//	        srhBusinCd.setMinChars(1);
//	        srhBusinCd.setDisplayField("businNm");
//	        srhBusinCd.setValueField("businCd");
//	        srhBusinCd.setTriggerAction(TriggerAction.ALL);
//	        srhBusinCd.setEmptyText("--사업선택--");
//	        srhBusinCd.setSelectOnFocus(true); 
//	        srhBusinCd.setReadOnly(false);
//	        srhBusinCd.setEnabled(true); 
//	        srhBusinCd.setStore(lsBusinCd);
//	        srhBusinCd.setFieldLabel("사업");
//				
//	        lcSchCol04_2.add(srhBusinCd, new FormData("100%"));
//	        lcSchCol04_2.setBorders(false);
//	        lcSchCol04.add(lcSchCol04_2, new FormData("100%"));	
//
//	       
//	        lcSchCol.add(lcSchCol01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
////	        lcSchCol.add(lcSchCol02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
//	        lcSchCol.add(lcSchCol03,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
//	        lcSchCol.add(lcSchCol04,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
//	       
//	        fieldSet.add(lcSchCol, new FormData("100%"));

	        plFrmPsnl0295.add(fieldSet);
		}

	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
            
            //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                
                sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                sysComBass0350Dto.setDeptCd(strDeptCd);
                List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                
               // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                
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
             
          } else {
           
          } 
        //직종변경에 따른 직종세 값 가져오기
//        String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//        if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//            sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//            sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//            }
//        }   
	  }
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
		cpGrid.setSize(950, 480);  
		    
		psnl0126GridPanel = new MSFGridPanel(psnl0126Def, false, false, false, false);
		psnl0126GridPanel.setHeaderVisible(false);  
		psnl0126GridPanel.setBodyBorder(true);
		psnl0126GridPanel.setBorders(true);
	    //2줄파싱 
	    psnl0126GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 9, new HeaderGroupConfig("사용", 1, 2));
		final Grid psnl0126Grid = psnl0126GridPanel.getMsfGrid().getGrid();
			psnl0126Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {  
					if (psnl0126GridPanel.getCurrentlySelectedItem() != null) {    
						setRecord(psnl0126GridPanel.getCurrentlySelectedItem());
						actionDatabase = ActionDatabase.UPDATE;
					} 
				}
			}); 
		    
		    cpGrid.add(psnl0126GridPanel); 
		          
			lcStdGrid.add(cpGrid);   
			fieldSetGrd.add(lcStdGrid);   
			      
			plFrmPsnl0295.add(fieldSetGrd, new FormData("100%"));
		    
	}
		
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	} 
		 
	public void setRecord(BaseModel record) {
		this.record = record;
	}
	public void reload() {
		// TODO Auto-generated method stub
		/*if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
				return;
			} 
		} */
				    
		IColumnFilter filters = null;
		psnl0126GridPanel.getTableDef().setTableColumnFilters(filters);
		
		psnl0126GridPanel.getTableDef().addColumnFilter("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(srhYear, "year"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0126GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0126GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		psnl0126GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
	
		//20180305추가 
	    psnl0126GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				
		String strHdofcCodtnCd = PersonalUtil.getStrValToBMMultiCombo(lsHdofcCodtnCd, srhHdofcCodtnCd.getValue(),"commCdNm","commCd");  
		psnl0126GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd , SimpleColumnFilter.OPERATOR_EQUALS);
		
		String strTypOccuCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		psnl0126GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strPyspGrdeCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
		psnl0126GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
		
		String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		psnl0126GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		       
		psnl0126GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0126GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0126GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		psnl0126GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
		psnl0126GridPanel.getTableDef().addColumnFilter("hodyFixYn", MSFSharedUtils.allowNulls(srhHodyFixYn.getValue()?"Y":"N"), SimpleColumnFilter.OPERATOR_EQUALS);  
		
		psnl0126GridPanel.reload();
		
	}
	
	//엑셀 저장
	private void excelFileExport() {
		                     
		HashMap<String, String> param = new HashMap<String, String>(); 
		   
			
		param.put("hodyApptnYr", MSFSharedUtils.getSelectedComboValue(srhYear,"year"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		param.put("hdofcCodtnCd", PersonalUtil.getStrValToBMMultiCombo(lsHdofcCodtnCd,srhHdofcCodtnCd.getValue(),"commCdNm","commCd"));
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("deptCd", PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		param.put("typOccuCd", PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("pyspGrdeCd", PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));
		param.put("dtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
		param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
		param.put("hodyFixYn", MSFSharedUtils.allowNulls(srhHodyFixYn.getValue()?"Y":"N")); 
		                     
					           
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
	
	
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/
	//성명
	private void fnPopupPsnl0100() {
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getRawValue());  //인사  
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	      
		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) { 
					systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));		//시스템키
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));			//이름
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));//주민번호 
				}  
			}
		});
	}
	
//    //부서 
//	private void fnPopupCommP140(String deptCd) {
//		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//		//검색.처리하면됨.
//		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//	      
//		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//			public void handleEvent(BaseEvent be) {
//				BaseModel mapModel = (BaseModel)be.getSource();
//				if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//					srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//					srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//					srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//					srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//					srhDeptCd.fireEvent(Events.Add);
//				}  
//			}
//		});
//	}
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
