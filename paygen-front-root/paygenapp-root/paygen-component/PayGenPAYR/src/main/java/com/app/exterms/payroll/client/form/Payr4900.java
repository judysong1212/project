package com.app.exterms.payroll.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.service.Payr4150Service;
import com.app.exterms.payroll.client.service.Payr4150ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

public class Payr4900 extends MSFPanel {

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmPayr4900;
	//private FormData formData; 
	private String txtForm = "";
	private XTemplate detailTp; 

	//지급년도 
	private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
	private MSFGridPanel payYrGridPanel;

/**
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 상태처리 전역변수
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 **/
	private ActionDatabase actionDatabase;
/**
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 화면 렌더링 변수 선언 
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 **/

/**
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * Button 변수 선언
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 **/
//	private ButtonBar topPayr4150Bar;
//	private Button btnPayr4150Init;
//	//private Button btnPayr4150Save;
//	//private Button btnPayr4150Del;
//	private Button btnPayr4150Sreach;

/**
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 검색변수 선언 
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 **/

	/** column  년도 : payYr */
	private MSFComboBox<BaseModel> srhPayYr;				//	지급년도
	private MSFComboBox<BaseModel> srhPayMonth;				//	지급월
    private MSFComboBox<BaseModel> srhPayCd;				//	급여구분
    private MSFDateField srhPayDt;							//	지급일자
    private MSFMultiComboBox<ModelData> srhDeptCd;			//	부서
    private MSFMultiComboBox<ModelData> srhTypOccuCd;		//	직종
    private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;	//	직종세
    private MSFDateField srhDutyDtFr;						//	근태일자
    private MSFDateField srhDutyDtTo;						//  근태일자

    private List<ModelData> mDtalistDeptCd;
    private List<ModelData> mDtalistTypOccuCd;
    private List<ModelData> mDtalistDtilOccuInttnCd;
    private List<ModelData> mDtalistHdofcCodtnCd;
    
    private Boolean emptyCheck = false;
    private boolean mutilCombo = false;

/**
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 입력 변수 선언 
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 **/
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    //입력수정삭제처리 rpc 처리부     
	private Payr4150ServiceAsync payr4150Service = Payr4150Service.Util.getInstance();	    
	
	private ListStore<BaseModel> lsPayYrStore 		= new ListStore<BaseModel>();  	// 년도 
	private ListStore<BaseModel> lsPayMonth 		= new ListStore<BaseModel>();  	// 급여월   
	
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분 
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	// 호봉제구분코드 
	
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  			= new ListStore<BaseModel>();	// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  		= new ListStore<BaseModel>();	// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	// 단위기관 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	// 부서직종그룹코드  	
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	// 직종 
	private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>(); 	// 급여구분
	
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	// 직종세
	
	private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
	private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	
	private SysCoCalendarDTO  msfCoCalendarDto;  
	
	private BaseModel record; 
	
	private Iterator<Record>  records;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 조회처리부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	 /**
	  * 권한설정 처리 체크 
	  * AuthAction 
	  */
    private void checkPayr4900Auth( String authAction, ListStore<BaseModel> bm) {
    	//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 

    	//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
    	if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
    		if (!maskTracker) { 
    			unmask();
    			authExecEnabled() ;
    		}  
    		//MSFMainApp.unmaskMainPage(); 

    		gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화
    	}
    }

    private void authExecEnabled() {
    	Field<?>[] fldArrField = {srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd};
    	
    	gwtAuthorization.formAuthFieldConfig(fldArrField); 
    	
    	srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
    	srhPayCd.setValue(lsPayCd.getAt(0));
    	
    	//srhDeptCd.fireEvent(Events.Add); 
    	srhDeptCd.getListView().fireEvent(Events.CheckChanged);
    }

    final Timer tmMask = new Timer()
    {
    	public void run()
    	{
    		//if (maskTracker)
    		//{ 
    		if (lsEmymtDivCd.getCount() > 0 ) {
    			cancel();
    			unmask(); 
    			authExecEnabled() ;
    			maskTracker  = true;
    		} else {
    			tmMask.scheduleRepeating(2000);
    		}
    		//}
    	}
    };

    private void initLoad() { 
    	//권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
    	gwtAuthorization = GWTAuthorization.getInstance();
    	gwtExtAuth = GWTExtAuth.getInstance();

    	HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
    	
    	authMapDef.put("srhPayYr",Boolean.FALSE);
    	authMapDef.put("srhPayMonth",Boolean.FALSE);
    	authMapDef.put("srhPayCd",Boolean.FALSE);
    	//authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
    	authMapDef.put("srhDeptCd",Boolean.FALSE);
    	authMapDef.put("srhTypOccuCd",Boolean.FALSE);

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
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    //화면 폼 바인딩 처리 
    private void setPayr4900FormBinding() {

    }
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	print Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/


/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/
    public ContentPanel getViewPanel(){
    	if(panel == null){
    		//콤보 권한초기화
    		initLoad(); 

    		detailTp = XTemplate.create(getDetailTemplate());

    		//formData = new FormData("-650");
    		vp = new VerticalPanel();
    		vp.setSpacing(10);
    		createPayr4900Form();  //화면 기본정보를 설정
    		//createSearchForm();    //검색필드를 적용
    		createStandardForm();    //기본정보필드  
    		vp.setSize("1010px", "700px");

    		/**
			 * Create the relations 
			 */
//    		final RelationDef relPayr0250 = new RelationDef(payr0250Def);
//    		relPayr0250.addJoinDef("dpobCd", "dpobCd");
//    		relPayr0250.addJoinDef("payCd", "payCd");
//    		relPayr0250.addJoinDef("jobYrMnth", "pymtYrMnth");
//    		relPayr0250.addJoinDef("payScduSeilNum", "payrSeilNum");
//    		relPayr0250.addJoinDef("emymtDivCd", "emymtDivCd");
//    		relPayr0250.addJoinDef("deptCd", "deptCd");
//    		relPayr0250.addJoinDef("businCd", "businCd");
//    		relPayr0250.addJoinDef("typOccuCd", "typOccuCd");
//    		//relPayr0250.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
//    		relPayr0250.addJoinDef("payrMangDeptCd", "payrMangDeptCd");
//    		relPayr0250.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
//    		relPayr0250.setLinkedObject(payr0250GridPanel);
//    		payr0301Def.addRelation(relPayr0250);


//    		//DETAILS 
//    		final Grid payr0250Grid = payr0250GridPanel.getMsfGrid().getGrid();
//    		payr0250Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//    			public void handleEvent(BaseEvent be) {  
//    				if (payr0250GridPanel.getCurrentlySelectedItem() != null) {
//    					payr0301Def.synchronizeGridDetail(
//    							payr0250GridPanel.getCurrentlySelectedItem(),
//    							payr0301GridPanel ); 
//    					//payr0301GridPanel.reload(); 
//    				}
//    			}
//    		}); 

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
*############################################################################# 
* 프로그램 종료  	  
*############################################################################# 
**/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 생성자 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 	
	/**
	 * @wbp.parser.constructor
	 */
    public Payr4900() { 
    	setSize("1010px", "700px");
    }

    public Payr4900(String txtForm) {
    	this.txtForm = txtForm;
    }
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 생성자 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 폼 생성시 기본 처리 함수 선언부 시작
 * 1. 폼 생성 선언
 * 2. 공통 버튼 처리 선언
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/
    private void createPayr4900Form() {

    	plFrmPayr4900 = new FormPanel();
    	plFrmPayr4900.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr4900());
    	//plFrmPayr4900.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여계산관리");
    	plFrmPayr4900.setIcon(MSFMainApp.ICONS.text());
    	plFrmPayr4900.setBodyStyleName("pad-text");
    	plFrmPayr4900.setPadding(2);
    	plFrmPayr4900.setFrame(true);
    	
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
    	final Button btnlogView = new Button("로그");   
		
    	btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
    	btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//로그 뷰화면 호출 메서드 
    			funcLogMessage(lblPayrConst.title_Payr4900(),"PAYR4900");
    		}
    	});
    	plFrmPayr4900.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
    	plFrmPayr4900.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

    	//멀티콤보박스 닫기 
    	plFrmPayr4900.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
    		@Override
    		public void handleEvent(ComponentEvent ce) {
    			if (mutilCombo) {
    				if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
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
    		}
    	});

//    	LayoutContainer layoutContainer = new LayoutContainer();
//    	layoutContainer.setLayout(new ColumnLayout());
//
//    	LayoutContainer layoutContainer_1 = new LayoutContainer(); 
//    	layoutContainer_1.setLayout(new FlowLayout());
//
//    	ButtonBar buttonBar_1 = new ButtonBar();
//
//    	Button btnNewButton_2 = new Button("");
//    	//btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
//    	buttonBar_1.add(btnNewButton_2);
//    	layoutContainer_1.add(buttonBar_1);
//    	layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//    	layoutContainer_1.setBorders(false);
//
//    	LayoutContainer layoutContainer_2 = new LayoutContainer();
//    	layoutContainer_2.setLayout(new FlowLayout());

//    	topPayr4150Bar = new ButtonBar();    
//    	layoutContainer_2.add(topPayr4150Bar);
//    	topPayr4150Bar.setAlignment(HorizontalAlignment.RIGHT);
//    	
//    	btnPayr4150Init = new Button("초기화");  
//    	btnPayr4150Init.setIcon(MSFMainApp.ICONS.new16());
//    	topPayr4150Bar.add(btnPayr4150Init);
//    	btnPayr4150Init.addListener(Events.Select, new Listener<ButtonEvent>() {
//    		public void handleEvent(ButtonEvent e) {
//    			//초기화 
//    			formInit();
//    		}
//    	});
    	
//    	btnPayr4150Sreach = new Button("조회"); 
//    	btnPayr4150Sreach.setIcon(MSFMainApp.ICONS.search16());
//    	topPayr4150Bar.add(btnPayr4150Sreach);
//    	btnPayr4150Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
//    		public void handleEvent(ButtonEvent e) {
//    			//조회버튼 클릭시 처리 
//    			reloadPayr4200();  
//    		}
//    	});
    	
//    	layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//    	layoutContainer_2.setBorders(false); 
//    	layoutContainer.setBorders(false);
//    	
//    	plFrmPayr4900.add(layoutContainer);
	  	
//    	//파일업로드 처리
//    	plFrmPayr4150.setAction("bizform");
//    	plFrmPayr4150.setEncoding(Encoding.MULTIPART);
//    	plFrmPayr4150.setMethod(Method.POST);

    	vp.add(plFrmPayr4900);
    	plFrmPayr4900.setSize("990px", "680px");
    }

 /**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 폼 생성시 기본 처리 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 기본화면 입력 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 

	/**
	 * 프리폼 설정
	 */
	private void createStandardForm() {
		//srhSystemkey = new HiddenField<String>();  //시스템키 
		//dpobCd = new HiddenField<String>();  //사업장코드 
	
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
	
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//월 
		lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 직종 콤보박스 처리  시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		 */	     	    
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});		   
		
		//-------------------관리부서 추가  
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
	
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		
		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		
		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd);
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------
	
		plFrmPayr4900.setLayout(new FlowLayout());
	
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout()); 
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("생성조건");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		//fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		
		fieldSet.setStyleAttribute("marginTop", "10px");
		
		LayoutContainer lcSchLeft = new LayoutContainer();
		
		fieldSet.add(lcSchCol, new FormData("100%"));
		lcSchLeft.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_8.setLayout(frmlytSch);
	
		/** column 지급년월 : payYr */
		srhPayYr = new MSFComboBox<BaseModel>();
		srhPayYr.setName("srhPayYr");
		srhPayYr.setForceSelection(true);
		srhPayYr.setMinChars(1);
		srhPayYr.setDisplayField("yearDisp");
		srhPayYr.setValueField("year");
		srhPayYr.setTriggerAction(TriggerAction.ALL);
		//srhPayYr.setEmptyText("--년도선택--");
		srhPayYr.setSelectOnFocus(true); 
		srhPayYr.setReadOnly(false);
		srhPayYr.setEnabled(true); 
		srhPayYr.setStore(lsPayYrStore);
		srhPayYr.setFieldLabel("지급년월"); 
		lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 **++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPayr4900Auth("srhPayYr", lsPayYrStore); 
				}
			}
		});    
	//	srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	//		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	//			//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	//			BaseModel bmPayYr =  se.getSelectedItem(); 
	//			if (bmPayYr != null) {
	//				if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	//					if (srhDeptCd.getListView().getChecked().size() > 0) {
	//						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")); 
	//						List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
	//						sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
	//					}
	//					
	//					//--------------------사업 불러 오는 함수 -------------------------------------------------
	//					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	//					//--------------------사업 불러 오는 함수 -------------------------------------------------
	//					srhBusinCd.setStore(lsBusinCd); 
	//					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	//						public void handleEvent(StoreEvent<BaseModel> be) {  
	//							//searchBusinCd.setValue(lsBusinCd.getAt(0));  
	//						}
	//					});
	//				}
	//			}
	//		} 
	//	});
		
		layoutContainer_8.add(srhPayYr, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_8.setBorders(false);
	
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_9.setLayout(frmlytSch);
		    
		/** column 지급년월 : Mnth */ 
		srhPayMonth = new MSFComboBox<BaseModel>();
		srhPayMonth.setName("srhPayMonth");
		srhPayMonth.setForceSelection(true);
		srhPayMonth.setMinChars(1);
		srhPayMonth.setDisplayField("monthDisp");
		srhPayMonth.setValueField("month");
		srhPayMonth.setTriggerAction(TriggerAction.ALL);
		//srhPayMonth.setEmptyText("--월선택--");
		srhPayMonth.setSelectOnFocus(true); 
		srhPayMonth.setReadOnly(false);
		srhPayMonth.setEnabled(true);
		srhPayMonth.setStore(lsPayMonth);
		srhPayMonth.setHideLabel(true);
		srhPayMonth.select(0);
		srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {   
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 **++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					Date today = new Date();
					DateTimeFormat fmt = DateTimeFormat.getFormat("MM");
	
					srhPayMonth.setValue(lsPayMonth.findModel("month", fmt.format(today) ));
	
					checkPayr4900Auth("srhPayMonth", lsPayMonth); 
				}
			}  
		});  
		layoutContainer_9.add(srhPayMonth, new FormData("100%"));
		lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_9.setBorders(false);
		
	//	LayoutContainer layoutContainer = new LayoutContainer();
	//	frmlytSch = new FormLayout();  
	//	frmlytSch.setLabelWidth(60); 
	//	frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	//	layoutContainer.setLayout(frmlytSch);
	
	//        /** column 단위기관 : payrMangDeptCd */
	//        srhPayrMangDeptCd = new ComboBox<BaseModel>();
	//        srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
	//        srhPayrMangDeptCd.setForceSelection(true);
	//        srhPayrMangDeptCd.setMinChars(1);
	//        srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
	//        srhPayrMangDeptCd.setValueField("payrMangDeptCd");
	//        srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
	//        srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
	//        srhPayrMangDeptCd.setSelectOnFocus(true); 
	//        srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
	//        srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
	//        srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
	//        srhPayrMangDeptCd.setFieldLabel("단위기관"); 
	//        lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	//            public void handleEvent(StoreEvent<BaseModel> be) {  
	//            	 EventType type = be.getType();
	//		    	   if (type == Store.Add) { 
	//              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	//		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	//		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	//		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	//		                	checkPayr4150Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	//              	 }
	//              
	//            }
	//        });    
	//        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	//            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	//
	//            	sysComBass0400Dto = new PrgmComBass0400DTO();  
	//                sysComBass0400Dto.setDeptDspyYn("Y");
	//                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	//                sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
	//                //--------------------부서 불러 오는 함수 ------------------------------------------------
	//                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	//                //--------------------부서 불러 오는 함수 ------------------------------------------------
	//                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	//                   public void handleEvent(StoreEvent<BaseModel> be) {  
	//                     mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
	//                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
	//                       
	//                   }
	//                });   
	//            } 
	//        });
	//        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
	//        layoutContainer.setBorders(false);
		
	//	LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
	//	LayoutContainer layoutContainer_1_1 = new LayoutContainer();
	//
	//	frmlytSch = new FormLayout();  
	//	frmlytSch.setLabelWidth(60); 
	//	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	//	layoutContainer_1_1.setLayout(frmlytSch);
		    
	//	    srhEmymtDivCd =  new ComboBox<BaseModel>(); 
	//	    srhEmymtDivCd.setName("srhEmymtDivCd");
	//	    srhEmymtDivCd.setForceSelection(true);
	//	    srhEmymtDivCd.setMinChars(1);
	//	    srhEmymtDivCd.setDisplayField("commCdNm");
	//	    srhEmymtDivCd.setValueField("commCd");
	//	    srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
	//	    srhEmymtDivCd.setEmptyText("--고용구분선택--");
	//	    srhEmymtDivCd.setSelectOnFocus(true); 
	//	    srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	//	    srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	//	    srhEmymtDivCd.setStore(lsEmymtDivCd);
	//	    srhEmymtDivCd.setFieldLabel("고용구분"); 
	//	    lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	//            public void handleEvent(StoreEvent<BaseModel> be) {  
	//            	 EventType type = be.getType();
	//		    	   if (type == Store.Add) { 
	//              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	//		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	//		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	//		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	//		                	checkPayr4150Auth("srhEmymtDivCd", lsEmymtDivCd); 
	//              	 }
	//                            
	//            }
	//        });    
	//	    srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	//  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	//  	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	//  	    	 BaseModel bmPayCd =  se.getSelectedItem(); 
	//  	    	 if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	//  	    		   srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
	//                   srhBusinCd.setEnabled(true);
	//                   srhTypOccuCd.reset();
	//                   srhTypOccuCd.setEnabled(false);
	//                   srhDtilOccuInttnCd.reset();
	//                   srhDtilOccuInttnCd.setEnabled(false);
	//  	    	 } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
	//            	 //20151130 추가 수정 
	//        	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	//            	 srhBusinCd.reset();
	//                 srhBusinCd.setEnabled(false);   
	//                 if (gwtExtAuth.getEnableTypOccuCd()) {
	//                	 srhTypOccuCd.setEnabled(true);
	//                     srhDtilOccuInttnCd.setEnabled(true); 
	//                 } else {
	//                	 srhTypOccuCd.setEnabled(false);
	//                     srhDtilOccuInttnCd.setEnabled(false);
	//                     
	//                 }
	//        	     
	//  	    	  }  
	//  	    	} 
	//  	    });
	//	    layoutContainer_1_1.add(srhEmymtDivCd, new FormData("100%"));
	//	    layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		    
	//	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	//	    frmlytSch = new FormLayout();  
	//	    frmlytSch.setDefaultWidth(0);
	//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	//	    layoutContainer_101.setLayout(frmlytSch);
	//	    
	//	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	//	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	//	    srhRepbtyBusinDivCd.setHideLabel(true);
	//	    srhRepbtyBusinDivCd.setForceSelection(true);
	//	    srhRepbtyBusinDivCd.setAllowBlank(true);
	//	    srhRepbtyBusinDivCd.setMinChars(1);
	//	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	//	    srhRepbtyBusinDivCd.setValueField("commCd");
	//	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	//	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	//	    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	//	    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	//	    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	//	    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	//	    srhRepbtyBusinDivCd.setLabelSeparator("");
	//       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	//	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	//            public void handleEvent(StoreEvent<BaseModel> be) {  
	//
	//              
	//            }
	//        });  
	//	    
	//	    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
	//	    layoutContainer_101.setBorders(false);
	//	    layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	        
	        
	//	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 			// 지급년월
	//	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));	// 급여구분
	//	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 단위기관
	//	    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명
	        
		lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 지급년월
	//	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
	//	    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
		    
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());
		
		//관리부서 
	//	  		LayoutContainer lcSch2_1 = new LayoutContainer();
	//	  		FormLayout frmlytSch2_1 = new FormLayout();
	//	  		frmlytSch2_1.setLabelWidth(60);
	//	  		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
	//	  		lcSch2_1.setLayout(frmlytSch2_1);
	//	  		
	//	  		srhMangeDeptCd = new ComboBox<BaseModel>();
	//	  		srhMangeDeptCd.setName("srhMangeDeptCd"); 
	//	  		srhMangeDeptCd.setEmptyText("--관리부서선택--");
	//	  		srhMangeDeptCd.setDisplayField("deptNmRtchnt");
	//	  		srhMangeDeptCd.setStore(lsMangeDeptCd); 
	//	  		srhMangeDeptCd.setWidth(100);
	//	  		srhMangeDeptCd.setFieldLabel("관리부서");
	//	  		srhMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
	//	          srhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	//	          srhMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	//	              public void handleEvent(StoreEvent<BaseModel> be) {  
	//	              	EventType type = be.getType();
	//	              	if (type == Store.Add) { 
	//	              		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//	              		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	//	              		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	//	              		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	//	  		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	//	              		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
	//	              	}
	//	              }
	//	          });  
	//	          srhMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	//	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	//	  	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	//	  	    		sysComBass0400Dto = new PrgmComBass0400DTO();
	//	    	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
	//	    	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
	//	    	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	//	    	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	//	    	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	//	    	    		
	//	    	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	//	    	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	//	    	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
	//	    	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	//	    	    			}
	//	    	    		});  
	//	    	    		emptyCheck = true;
	//	  	    	} 
	//	  	    });
	//	          srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	//	              @Override
	//	              public void handleEvent(ComponentEvent ce) {    
	//	              	
	//	                  if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
	//	                  	
	//	                  	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
	//	  	                	sysComBass0400Dto = new PrgmComBass0400DTO();
	//	  	      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
	//	  	      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
	//	  	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	//	  	      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	//	  	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	//	  	      	    		
	//	  	      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	//	  	      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	//	  	      	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
	//	  	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	//	  	      	    			} 
	//	  	      	    			
	//	  	      	    		}); 
	//	  	      	    		emptyCheck = false;
	//	                  	}
	//	                   }  
	//	              } 
	//	          });   
	//	         
	//	          lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
	
		LayoutContainer layoutContainer_2 = new LayoutContainer();
	
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_2.setLayout(frmlytSch);
	
		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		//srhDeptCd.setForceSelection(true);
		//srhDeptCd.setMinChars(1);
		//srhDeptCd.setDisplayField("deptNmRtchnt");
		//srhDeptCd.setValueField("deptCd");
		//srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		//srhDeptCd.setSelectOnFocus(true); 
		//srhDeptCd.setReadOnly(false);
		//srhDeptCd.setEnabled(true); 
		//srhDeptCd.setStore(lsDeptCd );
		//srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
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
					if (!gwtExtAuth.getEnableDeptCd()) {
						ModelData mdSelect = (ModelData) srhDeptCd.getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
						if (MSFSharedUtils.paramNotNull(mdSelect)) {
							srhDeptCd.getListView().setChecked(mdSelect, true); 
							srhDeptCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("deptNmRtchnt"))); 
						}
					}
					
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 **++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPayr4900Auth("srhDeptCd", lsDeptCd); 
				}
			}
		});
		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
//				if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//					if (srhDeptCd.getListView().getChecked().size() > 0) {
//						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));    
//						List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//						sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//					}
//	
//					//--------------------사업 불러 오는 함수 -------------------------------------------------
//					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//					//--------------------사업 불러 오는 함수 -------------------------------------------------
//					srhBusinCd.setStore(lsBusinCd); 
//					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//						public void handleEvent(StoreEvent<BaseModel> be) {  
//							//searchBusinCd.setValue(lsBusinCd.getAt(0));  
//						}
//					});
//				} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					//2015.11.30 권한 직종가져오기  추가 
					//sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
					String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					sysComBass0320Dto.setDeptCd(strDeptCd);
					lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
					lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {
							mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
							srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
						}
					});
//				} else {
//					//sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//					String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//					sysComBass0320Dto.setDeptCd(strDeptCd);
//					lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
//					lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//						public void handleEvent(StoreEvent<BaseModel> be) {
//							mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
//							srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
//						}
//					});   
//				}
			}
		});
		srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
		
		layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_10 = new LayoutContainer();
	
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_10.setLayout(frmlytSch);
	
		//직종 직종세처리  
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());
	
		LayoutContainer layoutContainer_211 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.LEFT); 
		layoutContainer_211.setLayout(frmlytSch); 
	
	//	srhDeptGpCd  =  new ComboBox<BaseModel>(); 
	//	srhDeptGpCd.setName("srhDeptGpCd");
	//	srhDeptGpCd.setForceSelection(true);
	//	srhDeptGpCd.setAllowBlank(false);
	//	srhDeptGpCd.setMinChars(1);
	//	srhDeptGpCd.setDisplayField("commCdNm");
	//	srhDeptGpCd.setValueField("commCd");
	//	srhDeptGpCd.setTriggerAction(TriggerAction.ALL);
	//	srhDeptGpCd.setEmptyText("--그룹--");
	//	srhDeptGpCd.setSelectOnFocus(true); 
	//	srhDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	//	srhDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	//	srhDeptGpCd.setStore(lsDeptGpCd);
	//	srhDeptGpCd.setFieldLabel("직종");
	
	//	layoutContainer_211.add(srhDeptGpCd, new FormData("100%"));
	
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);
	
		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd"); 
		srhTypOccuCd.setEmptyText("--직종선택--"); 
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
		srhTypOccuCd.setHideLabel(true);
		srhTypOccuCd.setFieldLabel("직종");
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					//if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
						if (!gwtExtAuth.getEnableTypOccuCd()) {
							ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ;
							srhTypOccuCd.getListView().setChecked(mdSelect, true); 
							srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
						}
					//} 
				}
			}
		});
		srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				displayDtilOccuInttnCd();
			}
		});
		srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
		srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
			@Override
			public void handleEvent(BaseEvent ce) {
				displayDtilOccuInttnCd();
			} 
		}); 
		layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
	
		LayoutContainer lcSchRight = new LayoutContainer();
		//lcSchRight.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(1); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		frmlytSch.setDefaultWidth(0);
		//fieldSet.setLayout(layout);  
		lcSchRight.setLayout(frmlytSch);
		
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
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
				}
			} 
		});
		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%")); 
		
		lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
		layoutContainer_21.setBorders(false);
		layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
		layoutContainer_10.setBorders(false);
		
	//	layoutContainer_13.add(lcSch2_1 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 관리부서 
		layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
		layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
		
		fieldSet.add(layoutContainer_13);
		layoutContainer_13.setBorders(false);
		
		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		layoutContainer_14.setLayout(frmlytSch);
	        
		srhPayCd =  new MSFComboBox<BaseModel>(); 
		srhPayCd.setName("srhPayCd");
		srhPayCd.setForceSelection(true);
		srhPayCd.setMinChars(1);
		srhPayCd.setDisplayField("commCdNm");
		srhPayCd.setValueField("commCd");
		srhPayCd.setTriggerAction(TriggerAction.ALL);
		//srhPayCd.setEmptyText("--급여구분선택--");
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
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 **++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkPayr4900Auth("srhPayCd", lsPayCd); 
				}
			}
		});
		layoutContainer_14.add(srhPayCd, new FormData("100%"));
		layoutContainer_14.setBorders(false);
		
		LayoutContainer layoutContainer_btn = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		layoutContainer_btn.setLayout(frmlytSch);
		
		Button btnHanNm = new Button("검색");
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//fnPopupPsnl0100();
		    }
		});
	
		layoutContainer_btn.add(btnHanNm);
		
	//	    LayoutContainer layoutContainer_4 = new LayoutContainer();
	//	    
	//	    frmlytSch = new FormLayout();  
	//	    frmlytSch.setLabelWidth(60); 
	//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	//	    layoutContainer_4.setLayout(frmlytSch);
	//	    
	//	    srhBusinCd = new ComboBox<BaseModel>();
	//	    srhBusinCd.setName("srhBusinCd");
	//	    srhBusinCd.setForceSelection(true);
	//	    srhBusinCd.setMinChars(1);
	//	    srhBusinCd.setDisplayField("businNm");
	//	    srhBusinCd.setValueField("businCd");
	//	    srhBusinCd.setTriggerAction(TriggerAction.ALL);
	//	    srhBusinCd.setEmptyText("--사업선택--");
	//	    srhBusinCd.setSelectOnFocus(true); 
	//	    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	//	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
	//	    srhBusinCd.setStore(lsBusinCd);
	//	    srhBusinCd.setFieldLabel("사업");
	//	    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
	//	    layoutContainer_4.setBorders(false);
	//	    
	//	    
	//	    
		lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 
	//        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));		// 성명
	//        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 사업
	
		fieldSet.add(lcSchCol3);
	
		plFrmPayr4900.add(fieldSet);   
	}

	private void  displayDtilOccuInttnCd() {
		//if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
			//sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
			sysComBass0350Dto.setDeptCd(strDeptCd);
			List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
			String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
	             
			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
				lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
				lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
						srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
	                         
						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0);
							srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
						}
					}
				});
			}
		//}
	}

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/   
	 

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
	public void funcLogMessage(String wndName, String wndId) {
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
