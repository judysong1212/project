package com.app.exterms.yearendtax.client.form.yeta2015;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta2000Def;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0200Service;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0200ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
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
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Yeta0200 extends MSFPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	// private RemtConstants lblRemtConst = RemtConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmYeta0200;
	private String txtForm = "";
 
	 
	private MSFGridPanel yeta2000GridPanel;
	private MSFGridPanel yeta2000XmlGridPanel;
	private Yeta2000Def yeta2000def = new Yeta2000Def("YETA0200");
	private Yeta2000Def yeta2000defXml = new Yeta2000Def("YETA0200_RESULT");

	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	// -------------- 권한 설정 객체 종료 --------------

	// 직종콤보
//	private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();
//	private MSFGridPanel typOccuCdGridPanel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 상태처리 전역 변수 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;

	
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topYeta0200Bar;
	private Button btnYeta0200Reset; 	// 초기화
	private Button btnYeta0200New; 		// 신규
	private Button btnYeta0200Save; 	// 저장
	private Button btnYeta0200Del; 		// 삭제
	private Button btnYeta0200Sreach; 	// 조회
	private Button btnYeta0200Print; 	// 인쇄
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/
	// -------------- 검색조건 생성 폼 시작 --------------
	private MSFComboBox<BaseModel> srhClutYr; 				// 정산년 
	private ComboBox<BaseModel> srhCalcSevePayPsnDivCd; 	// 정산구분
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
	private TextField<String> srhHanNm; 					// 성명
	private TextField<String> srhResnRegnNum; 				// 주민번호
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드  
	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
	private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드	 
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
	private ComboBox<BaseModel> srhBusinCd; 				// 사업
	private HiddenField<String> srhSystemkey; 				// 시스템키

	// -------------- 기본정보 폼 시작 --------------
	private MSFTextField typOccuNm; 			// 기본정보_직종
	private MSFTextField hanNm; 				// 기본정보_성명
	private MSFTextField deptNm; 				// 기본정보_부서
	private FileUploadField crefileUpload; 		// PDF파일자료_파일업로드
	private TextField<String> crePasswd; 		// PDF파일자료_패스워드
	private HiddenField<String> resnRegnNum; 	// PDF파일자료_패스워드 
	private CheckBox creOriginYn; 				// PDF파일자료_원본자동검증여부
 

	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;

	private boolean mutilCombo = false;

	private HiddenField<String> systemkey;
	/** column SYSTEMKEY : systemkey */
	private HiddenField<String> dpobCd;
	/** column 사업장코드 : dpobCd */
	 
    private HiddenField<String> edacRvyy;  /** set 연말정산귀속년도 : edacRvyy */
    private HiddenField<String> settGbcd;/** set 정산구분코드 : settGbcd */
    private HiddenField<Long> edacSeilNum;/** set 연말정산마감일련번호 : edacSeilNum */
 
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
	
	 private Boolean picBoolFile;

	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	 
	private BaseModel record;
	private Iterator<Record> records;

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ Rpc Service 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++++++++++
	 **/
	 private Yeta0200ServiceAsync yeta0200Service = Yeta0200Service.Util.getInstance(); 
	  
	private ListStore<BaseModel> lsClutYrStore = new ListStore<BaseModel>(); // 년도 
	private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>(); // 고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd = new ListStore<BaseModel>(); // 부서콤보
	private ListStore<BaseModel> lsBusinCd = new ListStore<BaseModel>(); // 사업콤보
	private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>(); // 단위기관
	private ListStore<BaseModel> lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  
	private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>(); // 직종
	private ListStore<BaseModel> lsCalcSevePayPsnDivCd = new ListStore<BaseModel>(); // 정산구분
	private ListStore<BaseModel> lsPymtDducDivCd = new ListStore<BaseModel>(); // 지급공제구분코드
	private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>(); // 직종세 

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++
	 * ++++++++++++++++++++++++++++++++++++++++
	 */
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	private void checkYeta0200Auth(String authAction, ListStore<BaseModel> bm) {
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())
				&& gwtExtAuth.checkExtAuth(authAction, bm)) {
			if (!maskTracker) {
				unmask();
			}
			
			 authExecEnabled() ;
			
		}
	}

	
	 private void authExecEnabled() { 
		   //------------------
		 /**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * ++++++++ 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세
			 * ,사업 순으로 없으면 ""
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * ++++++++++++++++++++++
			 */
			// ----------------------------------------------------
			Field<?>[] fldArrField = { srhPayrMangDeptCd, srhEmymtDivCd,
					srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd };
			gwtAuthorization.formAuthFieldConfig(fldArrField);

		    srhClutYr.setValue(lsClutYrStore.findModel("year","2015"));
			  
			srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
					
			/**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 * ++++++++ 권한설정을 위한 콤보처리를 위한 메서드 종료
			 * ++++++++++++++++++++++++++++++++
			 * ++++++++++++++++++++++++++++++++++++++++++
			 */
			srhDeptCd.getListView().fireEvent(Events.CheckChanged);
		 }
	final Timer tmMask = new Timer() {
		public void run() {
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

		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();

		 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
		authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
		authMapDef.put("srhDeptCd", Boolean.FALSE);
		//authMapDef.put("srhTypOccuCd", Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			// 권한 검색조건처리를 위해 추가된 부분
			mask("[화면로딩] 초기화 진행 중!");
		}
		tmMask.scheduleRepeating(5000);
	}

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++
	 * ++++++++++++++++++++++++++++++++++++++++
	 **/

	/**
	 * #########################################################################
	 * #### 프로그램 시작
	 * #############################################################
	 * ################
	 **/

	public ContentPanel getViewPanel() {
		if (panel == null) {

			initLoad(); 
			 
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createYeta0200Form(); // 화면 기본정보를 설정
			createMsfGridForm(); // 그리드설정
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
	 * #########################################################################
	 * #### 프로그램 종료
	 * #############################################################
	 * ################
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 생성자 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~~
	 **/
	/**
	 * @wbp.parser.constructor
	 */
	public Yeta0200() {
		setSize("1600px", "700px");
	}

	public Yeta0200(String txtForm) {
		this.txtForm = txtForm;
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createYeta0200Form() {

		plFrmYeta0200 = new FormPanel();
		plFrmYeta0200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산파일업로드"));
		plFrmYeta0200.setIcon(MSFMainApp.ICONS.text());
		plFrmYeta0200.setPadding(2);
		plFrmYeta0200.setFrame(true);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("연말정산파일업로드","YETA0200");
				}
			});
		plFrmYeta0200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta0200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		   //멀티콤보박스 닫기 
		plFrmYeta0200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			            @Override
			            public void handleEvent(ComponentEvent ce) { 
			            
			             //   for (Field<?>  f : ((FormPanel) plFrmRemt0100).getFields()) {
		                        
			            //        if (f instanceof MSFMultiComboBox<?>) {
			                        
//			                        if ("srhDeptCd".equals(f.getName())) {
//			                            
//			                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//			                            
//			                        }
		                            
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
		 
		/** 상단 버튼 ButtonBar **/
		topYeta0200Bar = new ButtonBar();
		topYeta0200Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnYeta0200Reset = new Button("초기화");
		btnYeta0200Reset.setIcon(MSFMainApp.ICONS.new16());
		topYeta0200Bar.add(btnYeta0200Reset);
		btnYeta0200Reset.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			 //초기화 
    			formInit();
    			 yeta2000GridPanel.getMsfGrid().clearData(); 
    		}
        });  

//		topBtn = new Button("신 규");
//		topBtn.setIcon(MSFMainApp.ICONS.new16());
//		buttonBar.add(topBtn);

//		topBtn = new Button("수 정");
//		topBtn.setIcon(MSFMainApp.ICONS.edit());
//		buttonBar.add(topBtn);
//
//		topBtn = new Button("삭 제");
//		topBtn.setIcon(MSFMainApp.ICONS.delete16());
//		buttonBar.add(topBtn);
//
//		topBtn = new Button("저 장");
//		topBtn.setIcon(MSFMainApp.ICONS.save16());
//		buttonBar.add(topBtn);

		btnYeta0200Sreach = new Button("조 회");
		btnYeta0200Sreach.setIcon(MSFMainApp.ICONS.search());
		topYeta0200Bar.add(btnYeta0200Sreach);
		btnYeta0200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//조회버튼 클릭시 처리 
    			reloadYeta0200();  
    		}
    	});
//		topBtn = new Button("인 쇄");
//		topBtn.setIcon(MSFMainApp.ICONS.print16());
//		buttonBar.add(topBtn);
		
		plFrmYeta0200.add(topYeta0200Bar);

		// 파일업로드 처리
		plFrmYeta0200.setAction("myurl");
		plFrmYeta0200.setEncoding(Encoding.MULTIPART);
		plFrmYeta0200.setMethod(Method.POST);
		
		vp.add(plFrmYeta0200);
		plFrmYeta0200.setSize("990px", "680px");
		plFrmYeta0200.setLayout(new FlowLayout());

	
		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();

		// --------------------단위기관 불러 오는 함수------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);	//단위기관
		// --------------------단위기관 불러 오는 함수------------------------------------------------

		// --------------------공통 코드 불러 오는 함수--------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); //정산구분

		sysComBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);		//고용구분
		
		//호봉
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// --------------------공통 코드 불러 오는 함수--------------------------------------------------

		// --------------------정산년도 불러 오는 함수------------------------------------------------
		lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		// --------------------정산년도 불러 오는 함수------------------------------------------------

		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);

		lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});

		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 직종 콤보박스 처리 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 */

//		ContentPanel typOccuCdGrid = new ContentPanel();
//		typOccuCdGrid.setVisible(false);
//
//		// 직종 콤보처리
//		typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false,true);
//		typOccuCdGridPanel.getGrid().addListener(Events.ViewReady,new Listener<ComponentEvent>() {
//			public void handleEvent(ComponentEvent be) {
//				typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {
//					public void handleEvent(StoreEvent<BaseModel> be) {
//						lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//						mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore());
//						srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
//					}
//				});
//			}
//		});
//		typOccuCdGrid.add(typOccuCdGridPanel);
//		plFrmYeta0200.add(typOccuCdGrid);
	    
		 lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
              mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
              srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
               
            }
        });  
		   
		srhSystemkey = new HiddenField<String>();
		plFrmYeta0200.setLayout(new FlowLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
//		fieldSet.setHeight("80px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());
		fieldSet.add(lcSchCol1, new FormData("100%"));

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_1 = new LayoutContainer();
		layoutContainer1_1.setLayout(new ColumnLayout());

		/** column 지급년 : ClutYr */
		LayoutContainer layoutContainer1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1.setLayout(frmlytSch);

		srhClutYr = new MSFComboBox<BaseModel>();
		srhClutYr.setName("srhClutYr");
		srhClutYr.setForceSelection(true);
		srhClutYr.setMinChars(1);
		srhClutYr.setDisplayField("yearDisp");
		srhClutYr.setValueField("year");
		srhClutYr.setTriggerAction(TriggerAction.ALL);
		srhClutYr.setSelectOnFocus(true);
		srhClutYr.setReadOnly(true);
		srhClutYr.setEnabled(true);
		srhClutYr.setStore(lsClutYrStore);
		srhClutYr.setFieldLabel("정산년도");
		srhClutYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});
		srhClutYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmClutYr = se.getSelectedItem();
				if (bmClutYr != null) {
					if ((srhDeptCd.getListView().getChecked().size() == 1)
									&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));
							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
							sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수-------------------------------------------------
						srhBusinCd.setStore(lsBusinCd);
						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
												// searchBusinCd.setValue(lsBusinCd.getAt(0));
							}
						});
					} else {
								// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
								// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
								// return;
							}
						}
					}
				});

		layoutContainer1.add(srhClutYr, new FormData("100%"));
		layoutContainer1_1.add(layoutContainer1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer1.setBorders(false);
		
		/** column 단위기관 : PayrMangDeptCd */
		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setBorders(false);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3.setLayout(frmlytSch);

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
		lsPayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
				checkYeta0200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd);
			}
		});
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// --------------------부서 불러 오는 함수------------------------------------------------
			    sysComBass0400Dto.setDeptDspyYn("Y"); 
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
				// --------------------부서 불러 오는 함수------------------------------------------------
				lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
						srhDeptCd.getInitStore().add(mDtalistDeptCd);
					}
				});
			}
		});
		layoutContainer3.add(srhPayrMangDeptCd, new FormData("100%"));
 

		/** column 고용구분 : EmymtDivCd */
		LayoutContainer layoutContainer4 = new LayoutContainer(new ColumnLayout());
		layoutContainer4.setBorders(false);
		
		LayoutContainer layoutContainer77 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer77.setLayout(frmlytSch);

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
		lsEmymtDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서: 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd", "srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta0200Auth("srhEmymtDivCd", lsEmymtDivCd);
				}
			}
		});
		srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null
								&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					if ((srhDeptCd.getListView().getChecked().size() == 1)
								&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

						if (srhDeptCd.getListView().getChecked().size() > 0) {
							sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));
							List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
							sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
						}

						// --------------------사업 불러 오는 함수-------------------------------------------------
						lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
						// --------------------사업 불러 오는 함수 -------------------------------------------------
						srhBusinCd.setStore(lsBusinCd);
						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
									// searchBusinCd.setValue(lsBusinCd.getAt(0));
							}
						});
					} else {
								// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
								// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
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
					//} else {
						//srhTypOccuCd.setEnabled(false);
						//srhDtilOccuInttnCd.setEnabled(false);
					//}
				}
			}
		});
		layoutContainer77.add(srhEmymtDivCd, new FormData("100%"));
		layoutContainer4.add(layoutContainer77, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
		
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
	    srhRepbtyBusinDivCd.setHideLabel(true);
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
	    layoutContainer4.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		

//		/** column 단위기관 : PayrMangDeptCd */
//		LayoutContainer layoutContainer4 = new LayoutContainer();
//		layoutContainer4.setBorders(false);
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer4.setLayout(frmlytSch);
//
//		srhPayrMangDeptCd = new ComboBox<BaseModel>();
//		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
//		srhPayrMangDeptCd.setForceSelection(true);
//		srhPayrMangDeptCd.setMinChars(1);
//		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
//		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
//		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
//		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
//		srhPayrMangDeptCd.setSelectOnFocus(true);
//		srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//		srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
//		srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);
//		srhPayrMangDeptCd.setFieldLabel("단위기관");
//		lsPayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				
//				checkYeta0200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd);
//			}
//		});
//		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				// --------------------부서 불러 오는 함수------------------------------------------------
//			    sysComBass0400Dto.setDeptDspyYn("Y"); 
//				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
//				// --------------------부서 불러 오는 함수------------------------------------------------
//				lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
//					public void handleEvent(StoreEvent<BaseModel> be) {
//						mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
//						srhDeptCd.getInitStore().add(mDtalistDeptCd);
//					}
//				});
//			}
//		});
//		layoutContainer4.add(srhPayrMangDeptCd, new FormData("100%"));
		

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		layoutContainer1_2.setLayout(new ColumnLayout());

		/** column 성명 : HanNm */
		LayoutContainer layoutContainer5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer5.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");
		layoutContainer5.add(srhHanNm, new FormData("100%"));
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
//			}
//		});
		layoutContainer1_2.add(layoutContainer5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		layoutContainer5.setBorders(false);
		
        LayoutContainer layoutContainer_btn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        layoutContainer_btn.setLayout(frmlytSch);

		Button btnHanNm = new Button("검색");
		layoutContainer1_2.add(btnHanNm);
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				srhResnRegnNum.setValue("");
				fnPopupPsnl0100();

			}
		});
		
        layoutContainer_btn.add(btnHanNm);
        layoutContainer1_2.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));

		/** column 주민등록번호 : resnRegnNum */
		LayoutContainer layoutContainer6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer6.setLayout(frmlytSch);
		
		
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
		layoutContainer6.add(srhResnRegnNum, new FormData("100%"));
		layoutContainer1_2.add(layoutContainer6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		layoutContainer6.setBorders(false);
		layoutContainer1_2.setBorders(false);
		
		/** column 정산구분 : CalcSevePayPsnDivCd */
		LayoutContainer layoutContainer7 = new LayoutContainer();
		layoutContainer7.setBorders(false);
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer7.setLayout(frmlytSch);

		srhCalcSevePayPsnDivCd = new ComboBox<BaseModel>();
		srhCalcSevePayPsnDivCd.setName("srhCalcSevePayPsnDivCd");
		srhCalcSevePayPsnDivCd.setForceSelection(true);
		srhCalcSevePayPsnDivCd.setMinChars(1);
		srhCalcSevePayPsnDivCd.setDisplayField("commCdNm");
		srhCalcSevePayPsnDivCd.setValueField("commCd");
		srhCalcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
		srhCalcSevePayPsnDivCd.setEmptyText("--정산구분선택--");
		srhCalcSevePayPsnDivCd.setSelectOnFocus(true);
		srhCalcSevePayPsnDivCd.setReadOnly(false);
		srhCalcSevePayPsnDivCd.setEnabled(true);
		srhCalcSevePayPsnDivCd.setStore(lsCalcSevePayPsnDivCd);
		srhCalcSevePayPsnDivCd.setFieldLabel("정산구분");
		srhCalcSevePayPsnDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				
			}
		});

		layoutContainer7.add(srhCalcSevePayPsnDivCd, new FormData("100%"));


		LayoutContainer layoutContainer8 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer8.setLayout(frmlytSch);

		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서: 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkYeta0200Auth("srhDeptCd", lsDeptCd);
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhDeptCd.getListView().getChecked().size() == 1)
								&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));
						List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
						sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
					}

					// --------------------사업 불러 오는 함수-------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수 -------------------------------------------------
					srhBusinCd.setStore(lsBusinCd);
					srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
								// searchBusinCd.setValue(lsBusinCd.getAt(0));
						}
					});
				} else {
						// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
						// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
						// return;
				}
			}
		});

		srhDeptCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		layoutContainer8.add(srhDeptCd, new FormData("100%"));
		layoutContainer8.setBorders(false);

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_3 = new LayoutContainer();
		layoutContainer1_3.setLayout(new ColumnLayout());
		
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

		/** column 직종 : srhTypOccuCd */
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuCd.setLayout(frmlytSch);

		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setHideLabel(true);
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
//		srhTypOccuCd.setFieldLabel("직종");
		//srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		//srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
					 * lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면
					 * ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd"
					 * ,"srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					//checkYeta0200Auth("srhTypOccuCd", lsTypOccuCd);
				}
			}
		});

		srhTypOccuCd.getListView().addListener(Events.CheckChanged, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((srhTypOccuCd.getListView().getChecked().size() > 0)
								&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					// 직종변경에 따른 직종세 값 가져오기
					List<ModelData> mdListSelect = srhTypOccuCd.getListView().getChecked();

					String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd");
					sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));

					if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {

						lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
						// srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd);

						lsDtilOccuInttnCd.addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
								mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuClsDivCdModelData(lsDtilOccuInttnCd);
								srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
							}
						});
					}
				} else {

				}
			}
		});

		srhTypOccuCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});
		lcTypOccuCd.add(srhTypOccuCd, new FormData("100%"));

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
	//	srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	//	srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				} else {

				}
			}
		});

		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));

		
		layoutContainer1_3.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		layoutContainer1_3.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer1_3.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		layoutContainer1_3.setBorders(false);

		/** column 사업 : BusinCd */
		LayoutContainer layoutContainer9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9.setLayout(frmlytSch);

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
		layoutContainer9.add(srhBusinCd, new FormData("100%"));
		layoutContainer9.setBorders(false);
		
        
        LayoutContainer layoutContainer_16 = new LayoutContainer();
        
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_16.setLayout(frmlytSch);

		plFrmYeta0200.add(fieldSet);

//		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 	// 정산년,월
//		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 	// 단위기관
//		lcSchCol1.add(layoutContainer4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38)); 	// 고용구분
//		lcSchCol1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 	// 성명, 주민등록번호
//		
//		lcSchCol1.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 	// 정산구분
//		lcSchCol1.add(layoutContainer8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	 	// 부서
//		lcSchCol1.add(layoutContainer1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38)); 	// 직종
//		lcSchCol1.add(layoutContainer9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));		// 사업
		
		lcSchCol1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 정산년,월
		lcSchCol1.add(layoutContainer3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 단위기관
		lcSchCol1.add(layoutContainer4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 고용구분
		
		
		lcSchCol1.add(layoutContainer7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 정산구분
		lcSchCol1.add(layoutContainer8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	 	// 부서
		lcSchCol1.add(layoutContainer1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
		
		
		lcSchCol1.add(layoutContainer9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
		lcSchCol1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 성명, 주민등록번호
		lcSchCol1.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
		
		
	}

	private void createMsfGridForm() {
		
		dpobCd = new HiddenField<String>();		// 사업장코드
		dpobCd.setName("dpobCd");
		dpobCd.setId("dpobCd");
		plFrmYeta0200.add(dpobCd);
		systemkey = new HiddenField<String>(); 	// 시스템키
		systemkey.setName("systemkey");
		systemkey.setId("systemkey");
		plFrmYeta0200.add(systemkey);
		edacRvyy  = new HiddenField<String>();	  /** set 연말정산귀속년도 : edacRvyy */
		edacRvyy.setName("edacRvyy");
		edacRvyy.setId("edacRvyy");
		plFrmYeta0200.add(edacRvyy);
		settGbcd = new HiddenField<String>();	/** set 정산구분코드 : settGbcd */
		settGbcd.setName("settGbcd");
		settGbcd.setId("settGbcd");
		plFrmYeta0200.add(settGbcd);
		edacSeilNum = new HiddenField<Long>();	/** set 연말정산마감일련번호 : edacSeilNum */
		edacSeilNum.setName("edacSeilNum");
		edacSeilNum.setId("edacSeilNum");
		plFrmYeta0200.add(edacSeilNum);
		resnRegnNum = new HiddenField<String>();	/** set 연말정산마감일련번호 : edacSeilNum */
		resnRegnNum.setName("resnRegnNum");
		resnRegnNum.setId("resnRegnNum");
		plFrmYeta0200.add(resnRegnNum);
		
		
		
		FieldSet fsGird = new FieldSet();
		fsGird.setHeadingHtml("정산대상자");
		fsGird.setStyleAttribute("paddingLeft", "5px");
		fsGird.setBorders(true);

		// 부속 열 컨테이너 묶음
		LayoutContainer layoutContainer1_4 = new LayoutContainer();
		layoutContainer1_4.setLayout(new ColumnLayout());

		yeta2000GridPanel = new MSFGridPanel(yeta2000def, false, false, false, false,false);
		yeta2000GridPanel.setHeaderVisible(false);
		yeta2000GridPanel.setSize(470, 505);
		yeta2000GridPanel.setBorders(true);
		  final Grid yeta2000DefGrid = yeta2000GridPanel.getMsfGrid().getGrid();
		  yeta2000DefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
	          public void handleEvent(BaseEvent be) {  
	        	  if (yeta2000GridPanel.getCurrentlySelectedItem() != null) { 
	        		  BaseModel bmData = new BaseModel();
	        		  formInit() ;
	        		  bmData = yeta2000GridPanel.getCurrentlySelectedItem();
	        		   
	        		  dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
	        		  systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
	        		  edacRvyy.setValue(MSFSharedUtils.allowNulls(bmData.get("edacRvyy")));  /** set 연말정산귀속년도 : edacRvyy */
	        		  settGbcd.setValue(MSFSharedUtils.allowNulls(bmData.get("settGbcd")));/** set 정산구분코드 : settGbcd */
	        		  edacSeilNum.setValue((Long)bmData.get("edacSeilNum"));/** set 연말정산마감일련번호 : edacSeilNum */  
	        		    
	        		  typOccuNm.setValue(MSFSharedUtils.allowNulls(bmData.get("typOccuNm"))); 
	        		  hanNm.setValue(MSFSharedUtils.allowNulls(bmData.get("hanNm")));
	        		  deptNm.setValue(MSFSharedUtils.allowNulls(bmData.get("deptNm")));
	        		  crePasswd.setValue(MSFSharedUtils.allowNulls(bmData.get("resnRegnNum")).substring(6,13)); 
	        		  resnRegnNum.setValue(MSFSharedUtils.allowNulls(bmData.get("resnRegnNum"))); 
	        		  creOriginYn.setValue(Boolean.FALSE);
	        	   } 
	        	   
	        	  
		       }
		  });  
		
		fsGird.add(yeta2000GridPanel);
		layoutContainer1_4.add(fsGird, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));
//		layoutContainer1_4.add(msfGridPanel, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		/** column text : 공백1 */
		LayoutContainer space1 = new LayoutContainer();
		space1.setHeight(500);
		space1.setWidth(10);
		space1.setId("space");
		space1.setBorders(false);
		layoutContainer1_4.add(space1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.01));

		FieldSet fieldSet3 = new FieldSet();
		fieldSet3.setHeadingHtml("기본정보");
		fieldSet3.setHeight("80px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());
		fieldSet3.add(lcSchCol2, new FormData("100%"));

		/** column text : 기본정보_직종 cretypOccuNm */
		LayoutContainer layoutContainer10 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer10.setLayout(frmlytSch);

		typOccuNm = new MSFTextField();
		typOccuNm.setName("typOccuNm");
		typOccuNm.setFieldLabel("직종");
		typOccuNm.setEmptyText("--직종--");
		typOccuNm.setReadOnly(true);
		layoutContainer10.add(typOccuNm, new FormData("100%"));
		layoutContainer10.setBorders(false);
		lcSchCol2.add(layoutContainer10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));

		/** column text : 기본정보_성명 cretypOccuNm */
		LayoutContainer layoutContainer11 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer11.setLayout(frmlytSch);

		hanNm = new MSFTextField();
		hanNm.setName("hanNm");
		hanNm.setFieldLabel("성명");
		hanNm.setEmptyText("--성명--");
		hanNm.setReadOnly(true);
		layoutContainer11.add(hanNm, new FormData("100%"));
		layoutContainer11.setBorders(false);
		lcSchCol2.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));

		/** column text : 기본정보_부서 creDeptCd */
		LayoutContainer layoutContainer12 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12.setLayout(frmlytSch);

		deptNm = new MSFTextField();
		deptNm.setName("deptNm");
		deptNm.setFieldLabel("부서");
		deptNm.setEmptyText("--부서--");
		deptNm.setReadOnly(true);
		layoutContainer12.add(deptNm, new FormData("100%"));
		layoutContainer12.setBorders(false);
		lcSchCol2.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.98));

		layoutContainer1_4.add(fieldSet3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		FieldSet fieldSet4 = new FieldSet();
		fieldSet4.setHeadingHtml("PDF파일자료");
		fieldSet4.setHeight("130px");
		fieldSet4.setStyleAttribute("marginTop", "10px");

		// 컬럼 총 열에 대한 컨테이너
		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());
		fieldSet4.add(lcSchCol3, new FormData("100%"));

		/** column text : PDF파일자료_파일업로드 crefileUpload */
		LayoutContainer layoutContainer13 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer13.setLayout(frmlytSch);

		crefileUpload = new FileUploadField();
		crefileUpload.setName("crefileUpload");
		crefileUpload.setFieldLabel("파일업로드");
		crefileUpload.setSelectOnFocus(true);
		layoutContainer13.add(crefileUpload, new FormData("100%"));
		layoutContainer13.setBorders(false);
		lcSchCol3.add(layoutContainer13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.98));

		/** column text : PDF파일자료_패스워드 crePasswd */
		LayoutContainer layoutContainer14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer14.setLayout(frmlytSch);

		crePasswd = new TextField<String>();
		crePasswd.setName("crePasswd");
		crePasswd.setId("crePasswd");
		crePasswd.setFieldLabel("패스워드");
		crePasswd.setSelectOnFocus(true);
		crePasswd.setPassword(true);
		layoutContainer14.add(crePasswd, new FormData("100%"));
		layoutContainer14.setBorders(false);
		lcSchCol3.add(layoutContainer14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.49));

		/** column text : PDF파일자료_원본자동검증여부 creOriginYn */
		LayoutContainer layoutContainer15 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer15.setLayout(frmlytSch);

		creOriginYn = new CheckBox();
		creOriginYn.setName("creOriginYn");
	    creOriginYn.setId("creOriginYn");
		creOriginYn.setBoxLabel("원본자동검증여부");
		creOriginYn.setLabelSeparator("");
		creOriginYn.setValue(false);
		layoutContainer15.add(creOriginYn, new FormData("100%"));
		layoutContainer15.setBorders(false);
		lcSchCol3.add(layoutContainer15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		/** column text : text */
		LayoutContainer layoutContainer16 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(35);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer16.setLayout(frmlytSch);

		Label txt1 = new Label();
		Label txt2 = new Label();
		txt1.setText("* PDF 비밀번호는 인사 정보를 이용해 자동비교 됩니다.");
		txt2.setText("* PDF 검증여부에 체크된 경우 원본검증은 자동처리 됩니다.");
		layoutContainer16.setStyleAttribute("paddingLeft", "10px");
		layoutContainer16.setStyleAttribute("marginTop", "5px");
		layoutContainer16.setStyleAttribute("marginBottom", "5px");
		layoutContainer16.add(txt1, new FormData("100%"));
		layoutContainer16.add(txt2, new FormData("100%"));
		
		
		
		layoutContainer16.setBorders(false);
		lcSchCol3.add(layoutContainer16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.95));
		
		Button topBtn = new Button("PDF 소득공제자료추출");
		topBtn.setIcon(MSFMainApp.ICONS.new16());
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			xmlImportData();
    		}
    	});
		
		Button topBtn01   = new Button("PDF 신용카드사용수정반영");
		topBtn01.setIcon(MSFMainApp.ICONS.new16());
		topBtn01.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			xmlImportUpData();
    		}
    	});
		lcSchCol3.add(topBtn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		lcSchCol3.add(topBtn01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		//fieldSet4.add(topBtn);

		layoutContainer1_4.add(fieldSet4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		yeta2000XmlGridPanel = new MSFGridPanel(yeta2000defXml, false, false,false, false);
		yeta2000XmlGridPanel.setSize(345, 310);
		yeta2000XmlGridPanel.setBorders(true);
		yeta2000XmlGridPanel.setStyleAttribute("marginTop", "5px");
		layoutContainer1_4.add(yeta2000XmlGridPanel, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));

		plFrmYeta0200.add(layoutContainer1_4);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
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
	
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 
	
	   public void setPPRecord(BaseModel ppRecord) {
	       this.ppRecord = ppRecord;
	   }
	   

		  public void setListRecord(Iterator<Record> records) {
			    this.records = records;
			 }
		  
	     public Iterator<Record>  getListRecord() {
	          return this.records;
	       }


	   private Yeta0200 getThis(){
	       return this;
	   }
	   
	   private void reloadYeta0200(){
			 
		   IColumnFilter filters = null;
		   yeta2000GridPanel.getTableDef().setTableColumnFilters(filters);
			 
			//정산년
		   yeta2000GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhClutYr,"year") , SimpleColumnFilter.OPERATOR_EQUALS); 
		        
			//정산구분
		   yeta2000GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		          
		   yeta2000GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		   yeta2000GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
		   String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		   yeta2000GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
         
          String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
          yeta2000GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
          
      //    String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
       //   remt2000DefGridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
          
        String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
        yeta2000GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	       
        yeta2000GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			   
          
        yeta2000GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
        yeta2000GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
        yeta2000GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			
        yeta2000GridPanel.reload();  
		   
	   }

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	   
        /**
         * 
         * <pre>
         * 1. 개요 : 전자파일 추출 컨데이너 호출  
         * 2. 처리내용 : 
         * </pre>
         * @Method Name : xmlImportData
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
		private void xmlImportData() { 
	         
			MessageBox.confirm("전자문서", "전자문서를 업로드 하시겠습니까?<br>(등록되어있는 전자문서가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
				//	if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	              
						//HashMap<String, String> param = new HashMap<String, String>();
						// only accept certain files  
						
//						dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
//		        		systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
//		        		edacRvyy.setValue(MSFSharedUtils.allowNulls(bmData.get("edacRvyy")));  /** set 연말정산귀속년도 : edacRvyy */
//		        		settGbcd.setValue(MSFSharedUtils.allowNulls(bmData.get("settGbcd")));/** set 정산구분코드 : settGbcd */
//		        		edacSeilNum.setValue((Long)bmData.get("edacSeilNum"));/** set 연말정산마감일련번호 : edacSeilNum */
						final Timer tmMask01 = new Timer() {
							public void run() {
								// if (maskTracker)
								// { 
					           	    cancel();
					           	    plFrmYeta0200.unmask();  
					               	reloadYeta0200();
								// }
							}
						};		        		  
	                       
	                    if("".equals(systemkey.getValue())){
	                    	MessageBox.alert("", "PDF 전자문서 업로드 대상자를 선택하십시요.", null);
	                    }else if("".equals(settGbcd.getValue())){
	                    	MessageBox.alert("", "정산구분은 필수 선택조건입니다.", null);
	                    } else { 
	                    	//get the filename to be uploaded
	                    	String filename = MSFSharedUtils.allowNulls(crefileUpload.getValue());
	                    	
	                    	if (filename.length() == 0) {
	                              Window.alert("선택된 파일이 없습니다.");
	                    	} else {
	                    		//submit the form
	                    		plFrmYeta0200.mask("PDF 전자문서 업데이트 중입니다. 업로드 중..."); 
	                    		
	                    		//파일업로드 처리
	                    		plFrmYeta0200.setAction(GWT.getHostPageBaseURL() + "/imp/XmlYeta0200Import.do");
	                    		plFrmYeta0200.setEncoding(Encoding.MULTIPART);
	                    		plFrmYeta0200.setMethod(Method.POST);   
//	                               FormElement frmEl=FormElement.as(plFrmYeta0200.getElement()); 
//	                               frmEl.setAcceptCharset("UTF-8"); 
	                    		plFrmYeta0200.submit();  
	                    		plFrmYeta0200.onFrameLoad();  
	                    		picBoolFile = true;
	                    		tmMask01.scheduleRepeating(5000);
	                    	}               
	                            
	                    	// reset and unmask the form 
	                    	// after file upload 
	                    	plFrmYeta0200.addListener(Events.Submit, new Listener<FormEvent>() {
	                    		public void handleEvent(FormEvent evt) {   
	                    			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    				//업로드가  성공했으면 인서트 모듈을 태운다. 
	                    				plFrmYeta0200.unmask();  
	                    				MessageBox.alert("", "PDF 전자문서 업로드가 정상적으로 완료되었습니다.", null); 
	                    				picBoolFile = false;
	                    				evt.setResultHtml("");
	                    			} else {
	                    				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    					//업로드가  성공했으면 인서트 모듈을 태운다.
	                    					plFrmYeta0200.unmask();  
	                    					MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
	                    					picBoolFile = false;
	                    					evt.setResultHtml("");
	                    				} else {
	                    					//실패 메시지나 에러 메시지 처리 . 
	                    					if (evt.getResultHtml().matches(".*error.*") && picBoolFile) {
		                    					//업로드가  성공했으면 인서트 모듈을 태운다.
		                    					plFrmYeta0200.unmask();  
		                    					MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
		                    					picBoolFile = false;
		                    					evt.setResultHtml("");
		                    				}
	                    				} 
	                    			}
	                    		};
	                    	});
	                    }
					}	
				}	
			}); 
		} 
		
		
		private void xmlImportUpData() { 
	         
			MessageBox.confirm("전자문서", "전자문서를 업로드 하시겠습니까?<br>(등록되어있는 전자문서가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
				//	if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	              
						//HashMap<String, String> param = new HashMap<String, String>();
						// only accept certain files  
						
//						dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd"))) ;         /**  column 사업장코드 : dpobCd */
//		        		systemkey.setValue(MSFSharedUtils.allowNulls(bmData.get("systemkey")));        /**  column SYSTEMKEY : systemkey */ 
//		        		edacRvyy.setValue(MSFSharedUtils.allowNulls(bmData.get("edacRvyy")));  /** set 연말정산귀속년도 : edacRvyy */
//		        		settGbcd.setValue(MSFSharedUtils.allowNulls(bmData.get("settGbcd")));/** set 정산구분코드 : settGbcd */
//		        		edacSeilNum.setValue((Long)bmData.get("edacSeilNum"));/** set 연말정산마감일련번호 : edacSeilNum */
						final Timer tmMask01 = new Timer() {
							public void run() {
								// if (maskTracker)
								// { 
					           	    cancel();
					           	    plFrmYeta0200.unmask();  
					               	reloadYeta0200();
								// }
							}
						};		        		  
	                       
	                    if("".equals(systemkey.getValue())){
	                    	MessageBox.alert("", "PDF 전자문서 업로드 대상자를 선택하십시요.", null);
	                    }else if("".equals(settGbcd.getValue())){
	                    	MessageBox.alert("", "정산구분은 필수 선택조건입니다.", null);
	                    } else { 
	                    	//get the filename to be uploaded
	                    	String filename = MSFSharedUtils.allowNulls(crefileUpload.getValue());
	                    	
	                    	if (filename.length() == 0) {
	                              Window.alert("선택된 파일이 없습니다.");
	                    	} else {
	                    		//submit the form
	                    		plFrmYeta0200.mask("PDF 전자문서 업데이트 중입니다. 업로드 중..."); 
	                    		
	                    		//파일업로드 처리
	                    		plFrmYeta0200.setAction(GWT.getHostPageBaseURL() + "/imp/XmlYeta0200UpImport.do");
	                    		plFrmYeta0200.setEncoding(Encoding.MULTIPART);
	                    		plFrmYeta0200.setMethod(Method.POST);   
//	                               FormElement frmEl=FormElement.as(plFrmYeta0200.getElement()); 
//	                               frmEl.setAcceptCharset("UTF-8"); 
	                    		plFrmYeta0200.submit();  
	                    		plFrmYeta0200.onFrameLoad();  
	                    		picBoolFile = true;
	                    		tmMask01.scheduleRepeating(5000);
	                    	}               
	                            
	                    	// reset and unmask the form 
	                    	// after file upload 
	                    	plFrmYeta0200.addListener(Events.Submit, new Listener<FormEvent>() {
	                    		public void handleEvent(FormEvent evt) {   
	                    			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    				//업로드가  성공했으면 인서트 모듈을 태운다. 
	                    				plFrmYeta0200.unmask();  
	                    				MessageBox.alert("", "PDF 전자문서 업로드가 정상적으로 완료되었습니다.", null); 
	                    				picBoolFile = false;
	                    				evt.setResultHtml("");
	                    			} else {
	                    				if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
	                    					//업로드가  성공했으면 인서트 모듈을 태운다.
	                    					plFrmYeta0200.unmask();  
	                    					MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
	                    					picBoolFile = false;
	                    					evt.setResultHtml("");
	                    				} else {
	                    					//실패 메시지나 에러 메시지 처리 . 
	                    					if (evt.getResultHtml().matches(".*error.*") && picBoolFile) {
		                    					//업로드가  성공했으면 인서트 모듈을 태운다.
		                    					plFrmYeta0200.unmask();  
		                    					MessageBox.alert("", "PDF 전자문서 업로드가 비정상적으로종료되었습니다.", null);
		                    					picBoolFile = false;
		                    					evt.setResultHtml("");
		                    				}
	                    				} 
	                    			}
	                    		};
	                    	});
	                    }
					}	
				}	
			}); 
		} 
		       
		 //폼초기화 검색조건포함 
		   private void formInit() {
		       
			  dpobCd.setValue("") ;         /**  column 사업장코드 : dpobCd */
     		  systemkey.setValue("");        /**  column SYSTEMKEY : systemkey */ 
     		  edacRvyy.setValue("");  /** set 연말정산귀속년도 : edacRvyy */
     		  settGbcd.setValue("");/** set 정산구분코드 : settGbcd */
     		  edacSeilNum.setValue(0L);/** set 연말정산마감일련번호 : edacSeilNum */ 
     		    
     		  typOccuNm.setValue(""); 
     		  hanNm.setValue("");
     		  deptNm.setValue("");
     		  crePasswd.setValue(""); 
     		  creOriginYn.setValue(false);
     		  crefileUpload.clear();
     		  picBoolFile = false;
     		   
		      
		   }


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