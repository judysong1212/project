package com.app.exterms.yearendtax.client.form.yeta2015;

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
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta3900Def;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
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
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
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


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow {
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Yeta0900   extends MSFPanel {

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    
    private VerticalPanel vp;
    private FormPanel plFrmYeta0900; 
    private String txtForm = "";
    private XTemplate detailTp;
    private FileUploadField yeta0900flUp;   //파일업로드처리 부분
    private Boolean picBoolFile;
    private Yeta3900Def yeta0900def = new Yeta3900Def("Yeta0900");
    private MSFGridPanel yeta0900Gridpanel;
    
	private GridCellRenderer<Stock> gridNumber;
	private GridCellRenderer<Stock> change;    
    
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
	
     /**
      * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      * 검색변수 선언 
      * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      **/
		// -------------- 검색조건 생성 시작 --------------
	    private ComboBox<BaseModel> srhPayYr;							// 지급년
	    private ComboBox<BaseModel> srhPayMonth;						// 지급월
    	private ComboBox<BaseModel> srhCalcSevePayPsnDivCd;     	// 정산구분
    	private ComboBox<BaseModel> srhPayrMangDeptCd; 				// 단위기관
    	private TextField<String> srhHanNm;        							// 성명
    	private TextField<String> srhResnRegnNum;   						// 주민번호 
    	private ComboBox<BaseModel> srhEmymtDivCd; 					// 고용구분
    	private MSFMultiComboBox<ModelData> srhDeptCd; 				// 부서
    	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 	// 직종세
		private ComboBox<BaseModel> srhBusinCd; 						// 사업
		private HiddenField<String> srhSystemkey;   						//시스템키  	      
		// -------------- 검색조건 생성 종료 --------------
		
		private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
		private List<ModelData> mDtalistHdofcCodtnCd;
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;
	
		private boolean mutilCombo = false;	
	
		private HiddenField<String> systemkey;	/** column SYSTEMKEY : systemkey */
		private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
		private HiddenField<String> clutYrMnth;	/** column 정산년월 : clutYrMnth */
		private HiddenField<String> pyspGrdeCd;	/** column 호봉등급코드 : pyspGrdeCd */
		
		private BaseModel ppRecord; // 팝업에 넘길 레코드 값
		
		
		//-------------- 상단버튼 시작 -----------------------

		//-------------- 상단버튼 시작 -----------------------
		
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
    	      
      // -------------- stroe [검색부]선언 시작 --------------
	  private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  				// 지급년 
	  private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  				// 지급월 
      private ListStore<BaseModel> lsCrCalcSevePayPsnDivCd = new ListStore<BaseModel>();// 정산구분
      private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>(); 		// 단위기관
      private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>(); 			// 고용구분
      private ListStore<BaseModel> lsDeptCd = new ListStore<BaseModel>(); 				// 부서콤보
      private ListStore<BaseModel> lsBusinCd = new ListStore<BaseModel>(); 				// 사업콤보
      private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>(); 			// 직종
      private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>(); 		// 직종세
      private ListStore<BaseModel> lsCalcSevePayPsnDivCd = new ListStore<BaseModel>(); 	// 정산구분
      private ListStore<BaseModel> lsPymtDducDivCd = new ListStore<BaseModel>(); 		// 지급공제구분코드
      // -------------- stroe [검색부]선언 종료 --------------     
      
      
      // -------------- DTO 선언 시작 --------------  
	  private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
	  private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
	  private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	  private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	  private SysCoCalendarDTO msfCoCalendarDto;  
	  private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	  private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	  // -------------- DTO 선언 종료 --------------
	    
	  private BaseModel record;
	  private  Iterator<Record> records;
	  /**
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	   **/
	   
	  	/**
	 	 * 권한설정 처리 체크 AuthAction
	 	 */
	  	private void checkYeta0900Auth( String authAction, ListStore<BaseModel>bm) {
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
			 
			 srhPayYr.setValue(lsPayYrStore.findModel("year","2015"));
          srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(2));
			 
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  * 권한설정을 위한 콤보처리를 위한 메서드 종료
			  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
			 
			 }
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) { 
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
		     
		
//			authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
			authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
			authMapDef.put("srhDeptCd",Boolean.FALSE); 
		    authMapDef.put("srhTypOccuCd",Boolean.FALSE);
		    
		    gwtExtAuth.setCheckMapDef(authMapDef);
	 		
	 		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//	 			 권한 검색조건처리를 위해 추가된 부분
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
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/
	  
	public ContentPanel getViewPanel(){
		if(panel == null){
			
			//콤보 권한초기화
	  		initLoad();
	  		
	  		detailTp = XTemplate.create(getDetailTemplate());
	  		vp = new VerticalPanel();
	  		vp.setSpacing(10);
	  		createYeta0900Form();  //화면 기본정보를 설정
	  		createSearchForm(); 
	  		createMsfGridForm();  //그리드설정
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
		public Yeta0900() {
			setSize("1600px", "700px");  
		} 

		public Yeta0900(String txtForm) {
		      this.txtForm = txtForm;
		}
	  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/		  
		private void createYeta0900Form() {
			
			plFrmYeta0900 = new FormPanel(); 
			plFrmYeta0900.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산급여파일업로드"));
			plFrmYeta0900.setIcon(MSFMainApp.ICONS.text());
			plFrmYeta0900.setPadding(2);
			plFrmYeta0900.setFrame(true); 
			
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage("연말정산급여파일업로드","YETA0900");
					}
				});
			plFrmYeta0900.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmYeta0900.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/
		     
			/** 상단 버튼 ButtonBar**/
			ButtonBar buttonBar = new ButtonBar();    
			buttonBar.setAlignment(HorizontalAlignment.RIGHT);
			    
			Button btnYeta0900Reset = new Button("초기화");  
			btnYeta0900Reset.setIcon(MSFMainApp.ICONS.new16());
			buttonBar.add(btnYeta0900Reset);
			    
			Button btnYeta0900New = new Button("신 규");  
			btnYeta0900New.setIcon(MSFMainApp.ICONS.new16());
			buttonBar.add(btnYeta0900New); 
		    
//			topBtn = new Button("수 정");  
//			topBtn.setIcon(MSFMainApp.ICONS.edit());
//			buttonBar.add(topBtn);
		      
			Button btnYeta0900Delete = new Button("삭 제");  
			btnYeta0900Delete.setIcon(MSFMainApp.ICONS.delete16());
			buttonBar.add(btnYeta0900Delete);
		      
			Button btnYeta0100Save = new Button("저 장");  
			btnYeta0100Save.setIcon(MSFMainApp.ICONS.save16());
			buttonBar.add(btnYeta0100Save);
		      
			Button btnYeta0900Search = new Button("조 회");  
			btnYeta0900Search.setIcon(MSFMainApp.ICONS.search());
			buttonBar.add(btnYeta0900Search);
		      
			Button btnYeta0900Print = new Button("인 쇄");  
			btnYeta0900Print.setIcon(MSFMainApp.ICONS.print16());
			buttonBar.add(btnYeta0900Print);		     
			plFrmYeta0900.add(buttonBar);
		      
			//파일업로드 처리
			plFrmYeta0900.setAction("myurl");
			plFrmYeta0900.setEncoding(Encoding.MULTIPART);
			plFrmYeta0900.setMethod(Method.POST);		         
			vp.add(plFrmYeta0900);		      
			plFrmYeta0900.setSize("990px", "680px");	      
			plFrmYeta0900.setLayout(new FlowLayout());
		}
    private void createSearchForm() {   		
			
			dpobCd = new HiddenField<String>();            //사업장코드 
	        systemkey = new HiddenField<String>();         //시스템키 
	        pyspGrdeCd =  new HiddenField<String>();
	        clutYrMnth =   new HiddenField<String>();
			
			sysComBass0150Dto = new PrgmComBass0150DTO();
		    sysComBass0300Dto = new PrgmComBass0300DTO();
		    sysComBass0400Dto = new PrgmComBass0400DTO();
		    sysComBass0500Dto = new PrgmComBass0500DTO();
		    msfCoCalendarDto = new SysCoCalendarDTO();
		    sysComBass0350Dto = new PrgmComBass0350DTO();
		    sysComBass0320Dto = new PrgmComBass0320DTO();
			
		    
		  //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		    lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);		// 단위기관_검색조건
		    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		     
		    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//		    sysComBass0300Dto.setRpsttvCd("B027");
//		    lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);// 정산구분
		     
		    sysComBass0300Dto.setRpsttvCd("A002");
		    lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);			// 고용구분_검색조건
		    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		     
		     //--------------------지급년월 불러 오는 함수 ------------------------------------------------
		    lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		    lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		     //--------------------지급년월 불러 오는 함수 ------------------------------------------------
	     
		     
		     sysComBass0400Dto.setDeptDspyYn("Y");
		     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		     
		     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		     
		     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		    	 public void handleEvent(StoreEvent<BaseModel> be) {  
		    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd); 
		    		 srhDeptCd.getInitStore().add(mDtalistDeptCd);
		    	 }
		     });
		     
		     
		     sysComBass0400Dto.setDeptDspyYn("Y");
		     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());		     
		     
		     /**
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		      * 직종 콤보박스 처리  시작
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
		      */
		     
//		     ContentPanel typOccuCdGrid = new ContentPanel();  
//		     typOccuCdGrid.setVisible(false);
//		                
//		        //직종 콤보처리 
//		        typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		        typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		        	public void handleEvent(ComponentEvent be) {  
//		        		typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		        			public void handleEvent(StoreEvent<BaseModel> be) {  
//		        				lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
//		        				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//		        				srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//		        				lscrTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//		        				mDtalistcrTypOccuCd = YetaUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//		        				creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
//		    			   		}  
//		        		});  
//		        	}  
//		        });  
//			typOccuCdGrid.add(typOccuCdGridPanel); 
//		  	plFrmYeta0100.add(typOccuCdGrid);

		      lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		             
	                 mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                  
	               }
	           }); 		 
			   
		  	srhSystemkey = new HiddenField<String>(); 
		  	plFrmYeta0900.setLayout(new FlowLayout());
		    
		     
		      
		      
			  FieldSet fieldSet = new FieldSet();  
			  fieldSet.setHeadingHtml("검색조건");
		        /****************************************************************
				 * 검색조건 배경 변경 스타일시트 추가 시작
				 ****************************************************************/
				fieldSet.addStyleName("x-fieldset-serarch-back-color");
				/****************************************************************
				 * 검색조건 배경 변경 스타일시트 추가 끝
				 ****************************************************************/
			  fieldSet.setHeight("80px");   			  

			  // 컬럼 총 열에 대한 컨테이너
			  LayoutContainer lcSchCol1 = new LayoutContainer();
			  lcSchCol1.setLayout(new ColumnLayout());
			  fieldSet.add(lcSchCol1, new FormData("100%"));		  
			  
			  // 부속 열 컨테이너 묶음			  
			  LayoutContainer layoutContainer1_1 = new LayoutContainer();
			  layoutContainer1_1.setLayout(new ColumnLayout());
		
			  
			  /** column 지급년 : srhPayYr */
			  LayoutContainer layoutContainer1 = new LayoutContainer();
			  FormLayout frmlytSch = new FormLayout();  
			  frmlytSch.setLabelWidth(70); 
			  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			  layoutContainer1.setLayout(frmlytSch);				  
			  
			  srhPayYr = new ComboBox<BaseModel>();
			  srhPayYr.setName("srhPayYr");
			  srhPayYr.setForceSelection(true);
			  srhPayYr.setMinChars(1);
			  srhPayYr.setDisplayField("yearDisp");
			  srhPayYr.setValueField("year");
			  srhPayYr.setTriggerAction(TriggerAction.ALL);
			  srhPayYr.setSelectOnFocus(true); 
			  srhPayYr.setReadOnly(false);
			  srhPayYr.setEnabled(true); 
			  srhPayYr.setStore(lsPayYrStore);
			  srhPayYr.setFieldLabel("지급년월"); 
			  srhPayYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {

					}
				});
			  srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
					public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
						// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
						BaseModel bmClutYr = se.getSelectedItem();
						if (bmClutYr != null) {
							if ((srhDeptCd.getListView().getChecked().size() == 1)
											&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

									if (srhDeptCd.getListView().getChecked().size() > 0) {
											sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr, "year"));
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
//														 searchBusinCd.setValue(lsBusinCd.getAt(0));
													}
												});

							} else {
										// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
										// return;
							}
						}
					}
				});		    
			    layoutContainer1.add(srhPayYr, new FormData("100%"));
			    layoutContainer1_1.add(layoutContainer1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			    layoutContainer1.setBorders(false);
			    
			    
			    /** column 지급월 : Mnth */ 
			    LayoutContainer layoutContainer2 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(0); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer2.setLayout(frmlytSch);			    
			    
			    srhPayMonth = new ComboBox<BaseModel>();
			    srhPayMonth.setName("srhPayMonth");
			    srhPayMonth.setForceSelection(true);
			    srhPayMonth.setMinChars(1);
			    srhPayMonth.setDisplayField("monthDisp");
			    srhPayMonth.setValueField("month");
			    srhPayMonth.setTriggerAction(TriggerAction.ALL);
			    srhPayMonth.setSelectOnFocus(true);   
			    srhPayMonth.setStore(lsPayMonth); 
			    srhPayMonth.setHideLabel(true);	
			    srhPayMonth.getStore().addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
					}
				});
		    
			    layoutContainer2.add(srhPayMonth, new FormData("100%"));	
			    layoutContainer1_1.add(layoutContainer2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			    layoutContainer2.setBorders(false);			    
			    
	    
			    
			    /** column 정산구분 : CalcSevePayPsnDivCd */ 
			    LayoutContainer layoutContainer3 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
			    layoutContainer3.setLayout(frmlytSch);
			    
			    srhCalcSevePayPsnDivCd =  new ComboBox<BaseModel>(); 
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
			    srhCalcSevePayPsnDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			        public void handleEvent(StoreEvent<BaseModel> be) {  
			        	
			        }
			    });  			    
			    layoutContainer3.add(srhCalcSevePayPsnDivCd, new FormData("100%"));
			    layoutContainer3.setBorders(false);		    
			    
			    
			    
			    
			    /** column 단위기관 : PayrMangDeptCd */ 
			    LayoutContainer layoutContainer4 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
			    layoutContainer4.setLayout(frmlytSch);			    

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
				                 srhDeptCd.getStore().add(mDtalistDeptCd);
			               }
			            });  
			        } 
			    });
			    layoutContainer4.add(srhPayrMangDeptCd, new FormData("100%"));
			    layoutContainer4.setBorders(false);
			    
			    
			    
			    
			    // 부속 열 컨테이너 묶음
			    LayoutContainer layoutContainer1_2 = new LayoutContainer();
			    layoutContainer1_2.setLayout(new ColumnLayout());
			    
			    
			    /** column 성명 : HanNm */
			    LayoutContainer layoutContainer5 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer5.setLayout(frmlytSch);
			    
			    srhHanNm = new TextField<String>();
			    srhHanNm.setName("srhHanNm");
			    srhHanNm.setFieldLabel("성명");
			    layoutContainer5.add(srhHanNm, new FormData("100%"));
 
			    srhHanNm.addKeyListener(new KeyListener() {
			    	 @Override
			        public void componentKeyDown(ComponentEvent event) {
			          
			            srhHanNm.validate();
			            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
			            	srhSystemkey.setValue("");
			                srhResnRegnNum.setValue("");
			            }
			            if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
			            	srhSystemkey.setValue("");
			                srhResnRegnNum.setValue(""); 
			                fnPopupPsnl0100();
			            }
			            super.componentKeyDown(event);
			        }
			     });
//			    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			        @Override
//			        public void handleEvent(BaseEvent be) {  
//			            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//			            	srhSystemkey.setValue("");
//			                srhResnRegnNum.setValue("");
//			            }
//			         
//			        } 
//			   }); 
			    layoutContainer1_2.add(layoutContainer5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
			    layoutContainer5.setBorders(false);
			    
			    Button btnHanNm = new Button("검색");
			    layoutContainer1_2.add(btnHanNm);
			    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			        public void handleEvent(ButtonEvent e) {
			        	srhSystemkey.setValue("");
			            srhResnRegnNum.setValue("");
			            fnPopupPsnl0100();			              
			        }
			    });
			    
			    /** column 주민등록번호 : resnRegnNum */
			    LayoutContainer layoutContainer6 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(0); 
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
			    layoutContainer1_2.add(layoutContainer6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
			    layoutContainer6.setBorders(false); 
			    layoutContainer1_2.setBorders(false);
			    
			    
			    
			    /** column 고용구분 : EmymtDivCd */
			    LayoutContainer layoutContainer7 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer7.setLayout(frmlytSch);
			    
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
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				    		   checkYeta0900Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
			                  
			                   sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
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
			           srhBusinCd.setEnabled(true);
			           srhTypOccuCd.reset();
			           srhTypOccuCd.setEnabled(false);
			           srhDtilOccuInttnCd.reset();
			           srhDtilOccuInttnCd.setEnabled(false);
			        } else {
			            srhBusinCd.reset();
			            srhBusinCd.setEnabled(false);  
			            
			            if (gwtAuthorization.getCheckOccuDisabled()) {
			                srhTypOccuCd.setEnabled(true);
			                srhDtilOccuInttnCd.setEnabled(true); 
			            } else {
			                srhTypOccuCd.setEnabled(false);
			                srhDtilOccuInttnCd.setEnabled(false);
			            }
			        }
			        }
			    });
			    layoutContainer7.add(srhEmymtDivCd, new FormData("100%"));
			    layoutContainer7.setBorders(false); 
			    
			    
			    
			    LayoutContainer layoutContainer8 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
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
			    srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			        public void handleEvent(StoreEvent<ModelData> be) {  
			        	  EventType type = be.getType();
				    	   if (type == Store.Add) { 
			           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				    		   checkYeta0900Auth("srhDeptCd", lsDeptCd); 
			           	 }
			         
			        }
			    });    

			    srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			       @Override
			      public void handleEvent(ComponentEvent ce) { 
			               
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
			         
			    layoutContainer8.add(srhDeptCd, new FormData("100%"));
			    layoutContainer8.setBorders(false);
			    
			    
			    
			    
			    
			 // 부속 열 컨테이너 묶음			  
				LayoutContainer layoutContainer1_3 = new LayoutContainer();
				layoutContainer1_3.setLayout(new ColumnLayout());	
				
				
			    /** column 직종 : srhTypOccuCd */
			    LayoutContainer lcTypOccuCd = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    lcTypOccuCd.setLayout(frmlytSch);   	    
  
			    srhTypOccuCd = new MSFMultiComboBox<ModelData>();
			    srhTypOccuCd.setName("srhTypOccuCd"); 
			    srhTypOccuCd.setEmptyText("--직종선택--"); 
			    srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
			    srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
			    srhTypOccuCd.setWidth(100);
			    srhTypOccuCd.setFieldLabel("직종");
			    srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
			    srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
			    srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			        public void handleEvent(StoreEvent<ModelData> be) {  
			        	  EventType type = be.getType();
				    	   if (type == Store.Add) { 
			           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				    		   checkYeta0900Auth("srhTypOccuCd", lsTypOccuCd); 
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
			                       // sysComBass0350Dto.setPyspGrdeCd(YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
			                        
			                        if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
			                            
			                            lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
			                          //  srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
			                            
			                            lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
			                                public void handleEvent(StoreEvent<BaseModel> be) {  
			                                    mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuClsDivCdModelData(lsDtilOccuInttnCd) ; 
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
			    
			    layoutContainer1_3.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
			    layoutContainer1_3.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 
			    layoutContainer1_3.setBorders(false);
			    
			    
			    
			    
			    /** column 사업 : BusinCd */
			    LayoutContainer layoutContainer9 = new LayoutContainer();
				frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
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
			    
			    plFrmYeta0900.add(fieldSet);
			    
			    
			    
			    
			    
			    // 연말정산대상자-생성			    
			    FieldSet fieldSet_2 = new FieldSet();  
			    fieldSet_2.setHeadingHtml("연말정산자료 업로드");
			    fieldSet_2.setHeight("50px");
			    fieldSet_2.setCollapsible(false);
			    
			    // 컬럼 총 열에 대한 컨테이너
				LayoutContainer lcSchCol2 = new LayoutContainer();
				lcSchCol2.setLayout(new ColumnLayout());
				fieldSet_2.add(lcSchCol2, new FormData("100%"));	
				
		    	LayoutContainer layoutContainer_1 = new LayoutContainer();
		    	layoutContainer_1.setLayout(new HBoxLayout()); 
		           
		     	LayoutContainer layoutContainer_2 = new LayoutContainer();
		       	layoutContainer_2.setStyleAttribute("paddingRight", "10px");
		      	frmlytSch = new FormLayout();  
		      	frmlytSch.setLabelWidth(60); 
		     	frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		      	layoutContainer_2.setLayout(frmlytSch);
		           
		      	yeta0900flUp = new FileUploadField();
		      	yeta0900flUp.setName("yeta0900flUp");
		      	yeta0900flUp.setValidator(new Validator() {  
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
		           
		       	layoutContainer_2.add(yeta0900flUp, new FormData("100%"));
		       	yeta0900flUp.setFieldLabel("휴가일수");
		            
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
		           
		       	Button btnDlgn0250Save = new Button("급여 업로드");
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

		        fieldSet_2.add(layoutContainer_1, new FormData("100%"));
				 
	  
			    plFrmYeta0900.add(fieldSet_2);	

			    lcSchCol1.add(layoutContainer1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));   	// 정산년,월
			    lcSchCol1.add(layoutContainer3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 정산구분
			    lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 단위기관
			    lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 성명, 주민등록번호
			    lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 고용구분
			    lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 		// 부서
			    lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 	// 직종
			    lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 사업
			    

			    
		  }	  
			  
	
		   
		 /**
		 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 폼 생성시 기본 처리 함수 선언부 종료
		 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
		 **/

		/**
		 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 검색 함수 선언부 시작
		 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
		 **/ 
		
		
		private void createMsfGridForm() {
		    //연말정산정보 테이블
			
			FieldSet fieldSetGrd = new FieldSet();  
		    fieldSetGrd.setHeadingHtml("연말정산정보");
			
		    yeta0900Gridpanel = new MSFGridPanel(yeta0900def, false, false, false, false);
		    yeta0900Gridpanel.setSize(960, 450);
		    yeta0900Gridpanel.setHeaderVisible(false); 
		    yeta0900Gridpanel.setBorders(true);
			
			fieldSetGrd.add(yeta0900Gridpanel);
			plFrmYeta0900.add(fieldSetGrd);
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
						systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); 		// 시스템키
						srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));			// 성명
						srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));// 주민번호
					}
				}
			});
		}
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 종료
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/	
		
		// 급여 업로드
		private void xlsImportData() { 
			MessageBox.confirm("급여 업로드", "급여를 생성하시겠습니까?",new Listener<MessageBoxEvent>(){
		      	@Override
		    	public void handleEvent(MessageBoxEvent be) {
		      		//if("Yes".equals(be.getButtonClicked().getText())){
		      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		              		//get the filename to be uploaded
		              		String filename = MSFSharedUtils.allowNulls(yeta0900flUp.getValue());
		              		if (filename.length() == 0) {
		              			Window.alert("선택된 파일이 없습니다.");
		                	} else {
		                		//submit the form
		                		plFrmYeta0900.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
		                		//파일업로드 처리		                		
		                		plFrmYeta0900.setAction(GWT.getHostPageBaseURL() + "/imp/XlsReadYeta0900Import.do");
		                		plFrmYeta0900.setEncoding(Encoding.MULTIPART);
		                		plFrmYeta0900.setMethod(Method.POST);   
		                		plFrmYeta0900.submit();  
		                		plFrmYeta0900.onFrameLoad();  
		                    	picBoolFile = true;
		                	}    
		              		plFrmYeta0900.addListener(Events.Submit, new Listener<FormEvent>() {
		                		public void handleEvent(FormEvent evt) {   
		                			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
		                				//업로드가  성공했으면 인서트 모듈을 태운다. 
		                				plFrmYeta0900.unmask();  
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
		                     	}
		                  	});
		             	}
		           	}  
			});
		}		
		
		//엑셀 양식 저장(다운로드)
		private void xlsExportData() {			                    
			HashMap<String, String> param = new HashMap<String, String>(); 			
			
			yeta0900Gridpanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta0900Export.do","extgwtFrame" ,param);  

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