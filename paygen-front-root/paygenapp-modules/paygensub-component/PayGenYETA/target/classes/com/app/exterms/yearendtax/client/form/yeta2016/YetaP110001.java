/**
 * 연말정산대상자검색
 */
package com.app.exterms.yearendtax.client.form.yeta2016;
  

import java.util.ArrayList;
import java.util.Calendar;
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
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.InfcPsnl0100Def;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110001Service;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110001ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP110001   extends MSFFormPanel {  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    

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
 
	private  ContentPanel cpYeta1100; 
	
	private InfcPsnl0100Def yetaP110001def = new InfcPsnl0100Def("YETAP110001");
	private MSFGridPanel yetaP110001GridPanel;
	
	private Button btnAllUsed;
	private Button btnUnUsed;
	private Button btnSelected;
	private MSFFormPanel popCom0100 = null ;
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  // 초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
    
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
 		private ActionDatabase actionDatabase;
 	
 	/**
 	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 	 * 화면 렌더링 변수 선언 
 	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 	 */
 		private MSFPanel caller;
 		private Boolean reading = false;
 		public FormBinding formBinding;
// 		public FormBinding formBinding2;
  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		private ButtonBar topPayr4200Bar;
		private Button btnPayr4200Sreach;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
      
		private HiddenField<String> systemkey;
		private HiddenField<String> clutYr; 					// 정산년		
		private HiddenField<String> clutSeptCd; 				// 정산구분	
		
		
		private HiddenField<String> dpobCd;  					// 사업장코드
		private HiddenField<String> srhSystemkey; 				// 시스템키
		
		private TextField<String> srhHanNm; 					// 성명
		private TextField<String> srhResnRegnNum; 				// 주민번호
		
		private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
		private HiddenField<String> payrMangDeptCd; 			// 단위기관	
		
		private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
		private HiddenField<String> emymtDivCd; 				// 고용구분	
		private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드
		private MSFMultiComboBox<ModelData> srhHdofcCodtnCd;	// 재직 
		private HiddenField<String> hdofcCodtnCd; 				// 재직	
		
		private DateField srhEmymtBgnnDt;		  				// 재직 시작일 
		private DateField srhEmymtEndDt;		  				// 재직 종료일
	
		private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
		private HiddenField<String> deptCd; 					// 부서	
		private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드
		private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
		private HiddenField<String> typOccuCd; 					// 직종	
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
		private HiddenField<String> dtilOccuInttnCd; 			// 직종세	
		private ComboBox<BaseModel> srhBusinCd; 				// 사업
		private HiddenField<String> businCd; 					// 사업	
		
		private List<ModelData> mDtalistHdofcCodtnCd;
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;
		
		private boolean mutilCombo = false;

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */


      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr410001FormBinding() {
	 	 
	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	   
	    }        
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/ 
 
	private YetaP110001ServiceAsync yetaP110001Service = YetaP110001Service.Util.getInstance();

	private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	// 호봉제구분코드 
	private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>();	// 고용구분 
	private ListStore<BaseModel> lsHdofcCodtnCd 		= new ListStore<BaseModel>(); 	//재직상태 
	
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  				= new ListStore<BaseModel>();	// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------

	private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>();	// 단위기관 
	private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	// 부서직종그룹코드  	
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();	// 직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();	// 직종세
	
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  			= new ListStore<BaseModel>();	// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------

	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO  msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종
  		
	    
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
	 * 	print Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	print Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/ 
 
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
	public YetaP110001(final ActionDatabase actionDatabase, final MSFPanel caller) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;
		
		
		
		// 콤보 권한초기화
		initLoad();

		cpYeta1100 = new ContentPanel();

		createSearchForm(); 	// 검색필드를 적용
		createStandardForm(); 	// 기본정보필드

		cpYeta1100.setBodyBorder(false);
		cpYeta1100.setBorders(false);
		cpYeta1100.setHeaderVisible(false);
		cpYeta1100.setSize("890px", "640px");

		this.add(cpYeta1100);
		formBinding = new FormBinding(this, true);

		this.setSize("910px", "710px");
	}
	    
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	/**
	 * 권한설정 처리 체크 AuthAction
	 */
	 private void checkYetaP110001Auth( String authAction, ListStore<BaseModel>bm) {
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
		 
		 
         if (MSFSharedUtils.paramNotNull(clutYr.getValue())) {
             setInitDate();
         }  
		  
//		 srhEdacRvyy.setValue(lsClutYrStore.findModel("year","2015"));
//		 srhSettGbcd.setValue(lsSettGbcd.getAt(0));
			
		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
		 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	 }
	 
	 
	   final Timer tmMask = new Timer()
	     {
	           public void run()
	           {
	        	   if (lsEmymtDivCd.getCount() > 0 ) {
	        		   
		           	    cancel();
		               	unmask(); 
		               	authExecEnabled() ;
		                maskTracker  = true;
		        	
		        	   } else {
		        		   tmMask.scheduleRepeating(2000);
		        	   }
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
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createPayrP410001Form() {

	}
	   
	  
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {

	     sysComBass0150Dto = new PrgmComBass0150DTO();
		 sysComBass0300Dto = new PrgmComBass0300DTO();
		 sysComBass0400Dto = new PrgmComBass0400DTO();
		 sysComBass0500Dto = new PrgmComBass0500DTO();
		 sysComBass0350Dto = new PrgmComBass0350DTO();
		 msfCoCalendarDto = new SysCoCalendarDTO();
		 sysComBass0320Dto = new PrgmComBass0320DTO();
		 
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		 //재직상태  
		 sysComBass0300Dto.setRpsttvCd("A003");
		 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
             public void handleEvent(StoreEvent<BaseModel> be) {  
                 mDtalistHdofcCodtnCd = YetaUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
                 srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
             }
		 });   
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //호봉
		 sysComBass0300Dto.setRpsttvCd("A048");
		 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	     	    
		 lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		 lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			 public void handleEvent(StoreEvent<BaseModel> be) {  
	           
				 mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
				 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                 
			 }
		 });  
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
		 //--------------------급여부서 불러 오는 함수 ------------------------------------------------ 
		 
		 
		 //---------------------멀티콤보박스 닫기 -------------------------------------------------
		 cpYeta1100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			 @Override
			 public void handleEvent(ComponentEvent ce) { 
				 if (mutilCombo) {
					 if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						  srhDeptCd.showClose(ce);
						  mutilCombo = false;
					 } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
						  srhHdofcCodtnCd.showClose(ce);
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
		 //---------------------멀티콤보박스 닫기 -------------------------------------------------		 
		 
		 
		 
		
	    systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta1100.add(systemkey);
		
		dpobCd = new HiddenField<String>();
		dpobCd.setName("dpobCd");
		cpYeta1100.add(dpobCd);

		srhSystemkey = new HiddenField<String>();
		srhSystemkey.setName("srhSystemkey");
		cpYeta1100.add(srhSystemkey);
		
		clutYr = new HiddenField<String>();
		clutYr.setName("clutYr");
		cpYeta1100.add(clutYr);
		
		clutSeptCd = new HiddenField<String>();
		clutSeptCd.setName("clutSeptCd");
		cpYeta1100.add(clutSeptCd);		
		
		payrMangDeptCd = new HiddenField<String>();
		payrMangDeptCd.setName("payrMangDeptCd");
		cpYeta1100.add(payrMangDeptCd);
		
		emymtDivCd = new HiddenField<String>();
		emymtDivCd.setName("emymtDivCd");
		cpYeta1100.add(emymtDivCd);
		
		hdofcCodtnCd = new HiddenField<String>();
		hdofcCodtnCd.setName("hdofcCodtnCd");
		cpYeta1100.add(hdofcCodtnCd);
		
		deptCd = new HiddenField<String>();
		deptCd.setName("deptCd");
		cpYeta1100.add(deptCd);
		
		typOccuCd = new HiddenField<String>();
		typOccuCd.setName("typOccuCd");
		cpYeta1100.add(typOccuCd);
		
		dtilOccuInttnCd = new HiddenField<String>();
		dtilOccuInttnCd.setName("dtilOccuInttnCd");
		cpYeta1100.add(dtilOccuInttnCd);

		businCd = new HiddenField<String>();
		businCd.setName("businCd");
		cpYeta1100.add(businCd);

		cpYeta1100.setLayout(new FlowLayout());

//		topPayr4200Bar = new ButtonBar();
//		topPayr4200Bar.setAlignment(HorizontalAlignment.RIGHT);
//
//
//		cpYeta1100.add(topPayr4200Bar);

		LayoutContainer lcSchCol = new LayoutContainer();
		// lcSchCol.setStyleAttribute("background-color","red");
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		fieldSet.setStyleAttribute("marginTop", "10px");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		
		
		LayoutContainer lcRow01 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcCol0101 = new LayoutContainer(new ColumnLayout());		
		
		LayoutContainer lcHanNm = new LayoutContainer();	
		
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lcHanNm.setLayout(frmlytSch);
	    
	    
        srhHanNm = new TextField<String>();
        srhHanNm.setName("srhHanNm");
        srhHanNm.setFieldLabel("성명");
        lcHanNm.add(srhHanNm, new FormData("100%"));
		lcCol0101.add(lcHanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		
		LayoutContainer lcResn = new LayoutContainer();	
		
        frmlytSch = new FormLayout();
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        lcResn.setLayout(frmlytSch);
        
        /** column 주민등록번호 : resnRegnNum */
        srhResnRegnNum = new TextField<String>();
        srhResnRegnNum.setName("srhResnRegnNum");
        srhResnRegnNum.setHideLabel(true);
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
        srhResnRegnNum.setLabelSeparator("");
        //srhResnRegnNum.setFieldLabel("주민번호");
        lcResn.add(srhResnRegnNum, new FormData("100%"));		
		lcCol0101.add(lcResn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcCol0102 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lcCol0102.setLayout(frmlytSch);
	    
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
            			checkYetaP110001Auth("PayrMangDeptCd", lsPayrMangDeptCd );   
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
	    lcCol0102.add(srhPayrMangDeptCd, new FormData("100%"));
	    
	    
	    
	    
		LayoutContainer lcCol0103 = new LayoutContainer(new ColumnLayout());	
		
	    LayoutContainer layoutContainer_1_1 = new LayoutContainer();
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_1_1.setLayout(frmlytSch);
	    
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
		    		   	checkYetaP110001Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	    layoutContainer_1_1.add(srhEmymtDivCd, new FormData("100%"));
	    lcCol0103.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    frmlytSch.setLabelWidth(0);
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(true);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setHideLabel(true);
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
	    layoutContainer_101.setBorders(false);
	    lcCol0103.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		
		
		
		LayoutContainer lcCol0104 = new LayoutContainer();	
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lcCol0104.setLayout(frmlytSch);
		
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
//                srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//                srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
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
        lcCol0104.add(srhHdofcCodtnCd, new FormData("100%"));		
		
		
		lcRow01.add(lcCol0101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));	// 성명, 주민등록번호
		lcRow01.add(lcCol0102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	// 단위기관
		lcRow01.add(lcCol0103, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));	// 고용구분
		lcRow01.add(lcCol0104, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));	// 재직상태
		
		lcSchCol.add(lcRow01);
		
		
		
		
		LayoutContainer lcRow02 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcCol0201 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytSch);

		srhEmymtBgnnDt = new DateField();
		new DateFieldMask(srhEmymtBgnnDt, "9999.99.99");
		srhEmymtBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		layoutContainer_9.add(srhEmymtBgnnDt, new FormData("100%"));
		srhEmymtBgnnDt.setFieldLabel("재직기간");
		lcCol0201.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(10);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);

		srhEmymtEndDt = new DateField();
		new DateFieldMask(srhEmymtEndDt, "9999.99.99");
		srhEmymtEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		srhEmymtEndDt.setLabelSeparator("~");
		layoutContainer_10.add(srhEmymtEndDt, new FormData("100%"));
		lcCol0201.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);
		
		
		
		
		LayoutContainer lcCol0202 = new LayoutContainer(new ColumnLayout());
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcCol0202.setLayout(frmlytSch);
		
	    
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
        				checkYetaP110001Auth("srhDeptCd", lsDeptCd); 
        		}
            }
        });    
 
        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
           @Override
           public void handleEvent(ComponentEvent ce) { 
                   
        	   if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                         
        		   if (srhDeptCd.getListView().getChecked().size() > 0) {  
                             
        			   sysComBass0500Dto.setBusinApptnYr(clutYr.getValue());   
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
        		   String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	           		sysComBass0320Dto.setDeptCd(strDeptCd);
	           		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	           		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           			public void handleEvent(StoreEvent<BaseModel> be) {  
	           				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	           				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                              
	           			}
	           		});  
        	   } else {
        		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
        		   String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
        		   sysComBass0320Dto.setDeptCd(strDeptCd);
        		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
        		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
        			   public void handleEvent(StoreEvent<BaseModel> be) {  
        				   mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
        lcCol0202.add(srhDeptCd, new FormData("100%"));		
		
		
		LayoutContainer lcCol0203 = new LayoutContainer();
		
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
        srhDeptGpCd.setAllowBlank(true);
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
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_21.setLayout(frmlytSch); 
        
        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
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
		    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
		    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
	         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
		                      //         mdSelect = tpMdSelect;
		                         //  } 
		                     //  }  
		                   
		                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
		                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
		                   // }  
		                    
	                }  
	            // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkPayr4250Auth("srhTypOccuCd", lsTypOccuCd); 
		    		   }
               	 }
                
            }
        });     
        
        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
        	@Override
        	public void handleEvent(ComponentEvent ce) { 

        		// 2015.11.30 추가
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
      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
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
        
        lcCol0203.add(lcTypOccuCd, new FormData("100%"));
		
		
		lcRow02.add(lcCol0201, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));	// 재직기간
		lcRow02.add(lcCol0202, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	// 부서
		lcRow02.add(lcCol0203, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.48));	// 직종
		
		lcSchCol.add(lcRow02);
		
		
		
		
		LayoutContainer lcRow03 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcCol0301 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lcCol0301.setLayout(frmlytSch);
	    
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
	    lcCol0301.add(srhBusinCd, new FormData("100%"));
		

		
		LayoutContainer lcCol0302 = new LayoutContainer();
		
		btnPayr4200Sreach = new Button("검색");
		btnPayr4200Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPayr4200Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				String strEmymtBgnnDt = MSFSharedUtils.getConvertDateToString(srhEmymtBgnnDt, "yyyyMMdd").replace(".", "");
				String strEmymtEndDt = MSFSharedUtils.getConvertDateToString(srhEmymtEndDt, "yyyyMMdd").replace(".", "");
				
				if(MSFSharedUtils.paramNull(strEmymtBgnnDt)) {
					Window.alert("재직기간 시작일자를 입력해주세요.");
					return;
				}else if(MSFSharedUtils.paramNull(strEmymtEndDt)) {
					Window.alert("재직기간 종료일자를 입력해주세요.");
					return;
				}
				
				// 조회버튼 클릭시 처리
				reload();
			}
		});
		lcCol0302.add(btnPayr4200Sreach);
		
		lcRow03.add(lcCol0301, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));	// 사업
		lcRow03.add(lcCol0302, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	// 사업
		lcSchCol.add(lcRow03);
		
		
		fieldSet.add(lcSchCol);
		cpYeta1100.add(fieldSet);

	}
	  
	 
	private void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_1 = new FieldSet();
		// fldstNewFieldset_1.setSize(628, 320);

		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("대상자내역");
		fldstNewFieldset_1.setCollapsible(false);

		fldstNewFieldset_1.add(payrModiListInfo(), new FormData("100%"));

		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);

		cpYeta1100.add(layoutContainer);
		layoutContainer.setBorders(false);

	}
	  
	private LayoutContainer payrModiListInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 500);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		yetaP110001GridPanel = new MSFGridPanel(yetaP110001def, false, false, false, false,false);
		yetaP110001GridPanel.setHeaderVisible(false);
		yetaP110001GridPanel.setBodyBorder(false);
		yetaP110001GridPanel.setBorders(true);
		yetaP110001GridPanel.getBottomComponent().setVisible(false);
		// payr0307GridPanel.setSize(600, 145);
		
        final Grid<BaseModel> grid = yetaP110001GridPanel.getMsfGrid().getGrid();
        final ColumnModel columnModel =  grid.getColumnModel();
        final List<ColumnConfig> columnConfigs = columnModel.getColumns();
        final CheckColumnConfig check = new CheckColumnConfig("select", "대상자선택", 45); 
        check.setAlignment(Style.HorizontalAlignment.CENTER);		            
        check.setEditor(columnConfigs.get(0).getEditor());
        columnConfigs.set(0, check);

        check.setRenderer(columnConfigs.get(0).getRenderer());  
        grid.addPlugin(check);
        grid.getView().setForceFit(true);	
        
        
        
        //툴바메뉴
        ToolBar bottomToolbar = new ToolBar();  
        bottomToolbar.add(new FillToolItem());
        
        // 첫번째 사용직종정보 툴바
        // ================전체선택버튼=========================
        btnAllUsed = new Button("전체선택");
        btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
            public void componentSelected(ButtonEvent ce) { 
            	
            	  int  lsCnt = yetaP110001GridPanel.getMsfGrid().getGrid().getStore().getCount();
            	  
            	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
            		  
            		  yetaP110001GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
            		  yetaP110001GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
            		   
            	  } 
            	  yetaP110001GridPanel.getMsfGrid().getGrid().getView().refresh(true);
		    }
        });
        
        
        bottomToolbar.add(btnAllUsed);
        bottomToolbar.add(new SeparatorMenuItem());
        //====================================================
        
       // ================전체해제버튼=========================
        btnUnUsed = new Button("전체해제");
        btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {  
            	
            	  int  lsCnt = yetaP110001GridPanel.getMsfGrid().getGrid().getStore().getCount();
            	  
            	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
            		  
            		  yetaP110001GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
            		  yetaP110001GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
            		   
            	  } 
            	  yetaP110001GridPanel.getMsfGrid().getGrid().getView().refresh(true);
            }  
        });

        bottomToolbar.add(btnUnUsed);
        bottomToolbar.add(new SeparatorMenuItem());
        //====================================================
        
        btnSelected = new Button("선택");
        btnSelected.addSelectionListener(new SelectionListener<ButtonEvent>() {   
        	
        	public void componentSelected(ButtonEvent ce) {  
        		
        		final Tracker tracker = new Tracker();
				tracker.setStatus(false);
            	
//				Ye161020DTO ye161020Dto = new Ye161020DTO();
//				List<Ye161020DTO> listYe161020Dto = new ArrayList<Ye161020DTO>();
            	
        		
        		Ye16Ta1000DTO yeta1000Dto = new Ye16Ta1000DTO(); 
        		List<Ye16Ta1000DTO> listYeta1000Dto = new ArrayList<Ye16Ta1000DTO>();
        		
				Iterator<BaseModel> itBm = yetaP110001GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); // .getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				} 
				
				Iterator<Record> iterRecords = lsRec.iterator();
				while (iterRecords.hasNext()) {
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {
						
    	 				yeta1000Dto = new Ye16Ta1000DTO();  
    	 				
    	 				
    					yeta1000Dto.setSrhPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));		/** column 급여관리부서코드 : payrMangDeptCd */

						String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
						String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
						String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  

						yeta1000Dto.setSrhDeptCd(strDeptCd);    																		/** column 부서코드 : deptCd */
						yeta1000Dto.setSrhTypOccuCd(strTypOccuCd);    																	/** column 직종코드 : typOccuCd */
						//yeta1000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(dtilOccuClsDivCd.getValue()));    /** column 직종세구분코드 : dtilOccuClsDivCd */
						//yeta1000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(pyspGrdeCd.getValue()));    /** column 호봉등급코드 : pyspGrdeCd */
						yeta1000Dto.setSrhDtilOccuInttnCd(strDtilOccuInttnCd);    														/** column 직종세통합코드 : dtilOccuInttnCd */
						yeta1000Dto.setSrhBusinCd( MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));    						/** column 사업코드 : businCd */
						yeta1000Dto.setSrhEmymtDivCd(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));    					/** column 고용구분코드 : emymtDivCd */
    	 				
    	 				
    	 				
    	 				
    	 				
    	 				yeta1000Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
						yeta1000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(clutYr.getValue()));    						/** column 연말정산귀속년도 : edacRvyy */
						yeta1000Dto.setSettGbcd(MSFSharedUtils.allowNulls(clutSeptCd.getValue()));    					/** column 정산구분코드 : settGbcd */
						yeta1000Dto.setEdacSeilNum(0L);    																/** column 연말정산마감일련번호 : edacSeilNum */
						yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));		/** column 급여관리부서코드 : payrMangDeptCd */
						yeta1000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    			/** column SYSTEMKEY : systemkey */

						strDeptCd = MSFSharedUtils.allowNulls(bmMapModel.get("deptCd"));  
						strTypOccuCd = MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")); 
						strDtilOccuInttnCd = MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"));  

						yeta1000Dto.setDeptCd(strDeptCd);    															/** column 부서코드 : deptCd */
						yeta1000Dto.setTypOccuCd(strTypOccuCd);    														/** column 직종코드 : typOccuCd */
						//yeta1000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(dtilOccuClsDivCd.getValue()));    /** column 직종세구분코드 : dtilOccuClsDivCd */
						//yeta1000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(pyspGrdeCd.getValue()));    /** column 호봉등급코드 : pyspGrdeCd */
						yeta1000Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);    											/** column 직종세통합코드 : dtilOccuInttnCd */
						yeta1000Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")) );    				/** column 사업코드 : businCd */
						yeta1000Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    			/** column 고용구분코드 : emymtDivCd */
					//	yeta1000Dto.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(pernChrgEmpIdenNum.getValue()));    /** column 생성직원번호 : pernChrgEmpIdenNum */
						
//						iCnt = iCnt + 1;
						
//						ye161020Dto = new Ye161020DTO();
//						
//						ye161020Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")) );
//						ye161020Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd"))  );
//						ye161020Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")) );
//						ye161020Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")) );
//						ye161020Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));
//						ye161020Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")) );
//
//						ye161020Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
//						ye161020Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(clutYr.getValue()));    							/** column 귀속연도 : yrtxBlggYr */
//						ye161020Dto.setClutSeptCd(MSFSharedUtils.allowNulls(clutSeptCd.getValue()));    						/** column 연말정산구분코드 : clutSeptCd */
//						ye161020Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
//						ye161020Dto.setFnm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    								/** column 소득자성명 : fnm */
//						ye161020Dto.setResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    				/** column 주민등록번호 : resnoEncCntn */
//						ye161020Dto.setTnm("");    																				/** column 근무처명 : tnm */
//						ye161020Dto.setBsnoEncCntn("");    																		/** column 사업자등록번호 : bsnoEncCntn */
//						ye161020Dto.setHshrClCd(MSFSharedUtils.allowNulls(bmMapModel.get("hfmlyRelaCd")));    					/** column 세대주여부 : hshrClCd */
//						ye161020Dto.setRsplNtnInfrNm(MSFSharedUtils.allowNulls(bmMapModel.get("natnNm")));						/** column 국적 : rsplNtnInfrNm */
//						ye161020Dto.setRsplNtnInfrCd(MSFSharedUtils.allowNulls(bmMapModel.get("natnCd")));						/** column 국적코드 : rsplNtnInfrCd */
//						ye161020Dto.setDtyStrtDt(MSFSharedUtils.allowNulls( bmMapModel.get("emymtBgnnDt")));    				/** column 근무기간시작일자 : dtyStrtDt */
//						ye161020Dto.setDtyEndDt(MSFSharedUtils.allowNulls( bmMapModel.get("emymtEndDt")));    					/** column 근무기간종료일자 : dtyEndDt */
//						ye161020Dto.setReStrtDt("");    																		/** column 감면기간시작일자 : reStrtDt */
//						ye161020Dto.setReEndDt("");    																			/** column 감면기간종료일자 : reEndDt */
//						ye161020Dto.setRsdtClCd("N");   	 																	/** column 거주구분 : rsdtClCd */
//						ye161020Dto.setRsplNtnNm(MSFSharedUtils.allowNulls(bmMapModel.get("natnNm")));    						/** column 거주지국명 : rsplNtnNm */
//						ye161020Dto.setRsplNtnCd(MSFSharedUtils.allowNulls(bmMapModel.get("natnCd")));    						/** column 거주지코드 : rsplNtnCd */
//						ye161020Dto.setInctxWhtxTxamtMetnCd("");																/** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
//						ye161020Dto.setInpmYn("N");    																			/** column 분납신청여부 : inpmYn */
//						ye161020Dto.setPrifChngYn("N");    																		/** column 인적공제항목변동여부 : prifChngYn */
//						ye161020Dto.setBscDdcnFpCnt(0L);    																	/** column 기본공제인원수 : bscDdcnFpCnt */
//						ye161020Dto.setSccNfpCnt(0L);    																		/** column 경로우대인원수 : sccNfpCnt */
//						ye161020Dto.setChbtAdopNfpCnt(0L);    																	/** column 출산입양인원수 : chbtAdopNfpCnt */
//						ye161020Dto.setWmnNfpCnt(0L);    																		/** column 부녀자인원수 : wmnNfpCnt */
//						ye161020Dto.setSnprntNfpCnt(0L);    																	/** column 한부모인원수 : snprntNfpCnt */
//						ye161020Dto.setDsbrNfpCnt(0L);    																		/** column 자애인인원수 : dsbrNfpCnt */
//						ye161020Dto.setAge6ltNfpCnt(0L);    																	/** column 6세이하인원수 : age6ltNfpCnt */
//						ye161020Dto.setFileSbtYn("N");    																		/** column 소득공제신고전자파일제출여부 : fileSbtYn */
//						ye161020Dto.setFileAppYn("N");    																		/** column 소득공제신고전자파일적용여부 : fileAppYn */
//						ye161020Dto.setFormCd(MSFSharedUtils.allowNulls(bmMapModel.get("formCd")));    							/** column 서식코드 : formCd */
//						ye161020Dto.setIssDtSeilNum(0L);    																	/** column 발급일자일련번호 : issDtSeilNum */
////						ye161020Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    							/** column 입력자 : kybdr */
////						ye161020Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    							/** column 입력일자 : inptDt */
////						ye161020Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    						/** column 입력주소 : inptAddr */
////						ye161020Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    								/** column 수정자 : ismt */
////						ye161020Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));   			 				/** column 수정일자 : revnDt */
////						ye161020Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    						/** column 수정주소 : revnAddr */
						
						listYeta1000Dto.add(yeta1000Dto);

					}
				}
				
				
				if(listYeta1000Dto.size() <= 0 ) {
					MessageBox.info("경고", "생성할 대상자를 선택해 주세요.", null);
					return;
				}
				
				
				final MessageBox box = MessageBox.wait("연말정산 대상자생성", "연말정산 반영처리 중 입니다...", "대상자 생성 중...");
				final Timer t = new Timer(){
					public void run() {
						if (tracker.getStatus()) {
							cancel();
							box.close();
						}
					}
				};
				t.scheduleRepeating(500);
				
				yetaP110001Service.saveYetaP110001ToYeta1000(listYeta1000Dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
					public void onFailure(Throwable caught) {
						tracker.setStatus(true);
						List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
						ShowMessageBM smBm = new ShowMessageBM();
						smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
						smBm.setMenu("Yeta");
						smBm.setPhase("[연말정산생성]연말정산대상자에러");
						smBm.setMessage(caught.getLocalizedMessage());
						smBm.setContent(caught.getMessage());
						bmResult.add(smBm);  
						PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
              	   
						ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
         			    
						MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
						msFwMessage.show();
						showMessageForm.setMSFFormWindows(msFwMessage);
         		          
//                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100Save(저장(수정)) : " + caught), null);
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
						reload();
					} 
				});
			}
		});
        bottomToolbar.add(btnSelected);
        bottomToolbar.add(new SeparatorMenuItem());

        Button refresh = new Button();
        refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
        refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {  
            	yetaP110001GridPanel.reload();	                	
            }  
        });		            
        bottomToolbar.add(refresh);
        
        //툴바 넣어주는것
        yetaP110001GridPanel.setBottomComponent(bottomToolbar);
        
		

		cp01.add(yetaP110001GridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	
	
	  
	  
		   
	public void reload() {
		// TODO Auto-generated method stub
		formInit();
		
		IColumnFilter filters = null;
		yetaP110001GridPanel.getTableDef().setTableColumnFilters(filters);
		
		yetaP110001GridPanel.getTableDef().addColumnFilter("clutYr", clutYr.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
		yetaP110001GridPanel.getTableDef().addColumnFilter("clutSeptCd", clutSeptCd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);	
				 
		yetaP110001GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaP110001GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 		
		
		
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
  	  		String chkkey = "";
  	           
  	  		for (int i=0; i<ray.length; i++){ 
  	  			BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
  	  			chkkey += bmData.get("commCd")+","; 
  	  		}
  	  		strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		}
		yetaP110001GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
		String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		yetaP110001GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
		           
		String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		yetaP110001GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		yetaP110001GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		yetaP110001GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);	
		yetaP110001GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls( srhHanNm.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);	
		yetaP110001GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		yetaP110001GridPanel.getTableDef().addColumnFilter("emymtBgnnDt", MSFSharedUtils.getConvertDateToString(srhEmymtBgnnDt, "yyyyMMdd")  , SimpleColumnFilter.OPERATOR_EQUALS); 
		yetaP110001GridPanel.getTableDef().addColumnFilter("emymtEndDt", MSFSharedUtils.getConvertDateToString(srhEmymtEndDt, "yyyyMMdd") , SimpleColumnFilter.OPERATOR_EQUALS); 
		
		yetaP110001GridPanel.reload();

	}
			
			
	// 폼초기화 검색조건포함
	private void formInit() {

		yetaP110001GridPanel.getMsfGrid().clearData();
		actionDatabase = ActionDatabase.READ;

	}
	
			    
   	
	@Override
	public void bind(final ModelData model) {
		
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {

				Timer timer = new Timer() {
					@Override
					public void run() {
						
						
//						Window.alert("단위기관?? "  + payrMangDeptCd.getValue());
							
						// 단위기관
						YetaUtils.setSelectedComboValue(srhPayrMangDeptCd,payrMangDeptCd.getValue(), "payrMangDeptCd");
						
//						Window.alert("부서는?? "  + deptCd.getValue());

						// 부서
						String deptCdStr = deptCd.getValue();
						String deptNmStr = "";
						if (MSFSharedUtils.paramNotNull(deptCd.getValue())) {
							String[] ray = deptCdStr.substring(0,deptCdStr.length()).split(",");
							for (int i = 0; i < ray.length; i++) {
								for (int j = 0; j < srhDeptCd.getStore().getCount(); j++) {
									if (ray[i].equals(srhDeptCd.getStore().getAt(j).get("deptCd"))) {
										srhDeptCd.getListView().setChecked(mDtalistDeptCd.get(j), true);
										if (i == 0) {
											deptNmStr += mDtalistDeptCd.get(j).get("deptNmRtchnt").toString();
										} else {
											deptNmStr += ","+ mDtalistDeptCd.get(j).get("deptNmRtchnt").toString();
										}
									}
								}
							}

							if (!"".equals(deptNmStr) && deptNmStr.length() > 0) {
								srhDeptCd.setValue(deptNmStr);
							}
						}
						
						
//						Window.alert("직종은?? "  + typOccuCd.getValue());
//
//						// 직종
//						String typOccuCdStr = typOccuCd.getValue();
//						String typOccuNmStr = "";
//						if (MSFSharedUtils.paramNotNull(typOccuCd.getValue())) {
//							String[] ray = typOccuCdStr.substring(0,typOccuCdStr.length()).split(",");
//							for (int i = 0; i < ray.length; i++) {
//								for (int j = 0; j < srhTypOccuCd.getStore().getCount(); j++) {
//									if (ray[i].equals(srhTypOccuCd.getStore().getAt(j).get("typOccuCd"))) {
//										srhTypOccuCd.getListView().setChecked(mDtalistTypOccuCd.get(j), true);
//										if (i == 0) {
//											typOccuNmStr += mDtalistTypOccuCd.get(j).get("typOccuNm").toString();
//										} else {
//											typOccuNmStr += "," + mDtalistTypOccuCd.get(j).get("typOccuNm").toString();		    		 		        
//										}
//									}
//								}
//							}
//
//							if (!"".equals(typOccuNmStr)&& typOccuNmStr.length() > 0) {
//								srhTypOccuCd.setValue(typOccuNmStr);
//							}
//						}
//						
//						
//						Window.alert("직종세는?? "  + dtilOccuInttnCd.getValue());
//
//						// 직종세
//						String dtilOccuInttnCdStr = dtilOccuInttnCd.getValue();
//						String dtilOccuInttnNmStr = "";
//						if (MSFSharedUtils.paramNotNull(dtilOccuInttnCd.getValue())) {
//							String[] ray = dtilOccuInttnCdStr.substring(0,dtilOccuInttnCdStr.length()).split(",");
//							for (int i = 0; i < ray.length; i++) {
//								for (int j = 0; j < srhDtilOccuInttnCd.getStore().getCount(); j++) {
//									if (ray[i].equals(srhDtilOccuInttnCd.getStore().getAt(j).get("dtilOccuInttnCd"))) {
//										srhDtilOccuInttnCd.getListView().setChecked(mDtalistDtilOccuInttnCd.get(j), true);
//										if (i == 0) {
//											dtilOccuInttnNmStr += mDtalistDtilOccuInttnCd.get(j).get("dtilOccuClsNm").toString();
//										} else {
//											dtilOccuInttnNmStr += ","+ mDtalistDtilOccuInttnCd.get(j).get("dtilOccuClsNm").toString();
//										}
//									}
//								}
//							}
//
//
//							if (!"".equals(dtilOccuInttnNmStr)&& dtilOccuInttnNmStr.length() > 0) {
//								srhDtilOccuInttnCd.setValue(dtilOccuInttnNmStr);
//							}
//						}
							
						
						
//						Window.alert("고용구분은?? "  + srhEmymtDivCd.getValue());

						// 고용구분
						YetaUtils.setSelectedComboValue(srhEmymtDivCd, emymtDivCd.getValue(), "commCd");
						
						
						// 사업
						YetaUtils.setSelectedComboValue(srhBusinCd, businCd.getValue(), "businCd");
					}
				};
				
				timer.schedule(3000);
			}
		});
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSuccessSave() {
		// TODO Auto-generated method stub

	}
	
	
	
	//날짜계산
	private void setInitDate() {
		   
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		   
		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.set (Integer.parseInt(clutYr.getValue()), monthS -1, 1);
		srhEmymtBgnnDt.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH);  
	      
		Calendar  intieCal =   Calendar.getInstance();
	    intieCal.set (Integer.parseInt(clutYr.getValue()), monthE - 1, maxDays );
	    srhEmymtEndDt.setValue(intieCal.getTime());
	    
	}
	
	
	
	private void  displayDtilOccuInttnCd() {
		  
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	         
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
			sysComBass0350Dto.setDeptCd(strDeptCd);
			List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
	     	String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
	    	sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
	             
	    	// sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	             
	    	if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
	                 
	    		lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	               //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
	                 
	    		lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	    				mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
	
	private YetaP110001 getThis(){
	       return this;
	   }
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	}   
			  	

}
