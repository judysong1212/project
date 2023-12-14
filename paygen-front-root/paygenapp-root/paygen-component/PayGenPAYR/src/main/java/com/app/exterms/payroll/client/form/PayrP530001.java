/**
 * 이전사업이관
 */
package com.app.exterms.payroll.client.form;
  

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.service.InfcPkgBass0500Service;
import com.app.exterms.basis.client.service.InfcPkgBass0500ServiceAsync;
import com.app.exterms.payroll.client.dto.Payr0490DTO;
import com.app.exterms.payroll.client.service.PayrP530001Service;
import com.app.exterms.payroll.client.service.PayrP530001ServiceAsync;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
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
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PayrP530001   extends MSFFormPanel {  

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
 
	private  ContentPanel cpPayrP53001; 
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
		 
	//권한 설정 객체 
	private static  GWTAuthorization gwtAuthorization;
	private static  GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

		  
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 공통코드 dto
	private PrgmComBass0500DTO sysComBass0500Dto;
	private Payr0490DTO payr0490Dto;
	private SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	    
    
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
	private Boolean  reading = false;
	public  FormBinding formBinding;
  
	private BaseModel record;
	private Iterator<Record> records;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
//  	private  ButtonBar topBassBtnBar = new ButtonBar();
//	private  Button btnBassNew = new Button();	// 신규
	private  Button btnBassSave = new Button();	// 저장
//	private  Button btnBassSrh = new Button();	// 조회

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
	private ComboBox<BaseModel> bfrDeptCd; 	// 이전부서
 	private ComboBox<BaseModel> bfrYr; 		// 이전년도
 	
 	private ComboBox<BaseModel> creDeptCd; 	// 이관부서
 	private ComboBox<BaseModel> cretnYr; 	// 이관년도
 	
 		
	private HiddenField<String>	dpobCd;			/**  column 사업장코드 : dpobCd */
 	// -------------- 검색 조건 종료 --------------
	
	// -------------- 이관부 시작 ----------------
	private ComboBox<BaseModel> brfBusinCd01; 
	private ComboBox<BaseModel> brfBusinCd02; 
	private ComboBox<BaseModel> brfBusinCd03; 
	private ComboBox<BaseModel> brfBusinCd04; 
	private ComboBox<BaseModel> brfBusinCd05; 
	private ComboBox<BaseModel> brfBusinCd06; 
	private ComboBox<BaseModel> brfBusinCd07; 
	private ComboBox<BaseModel> brfBusinCd08; 

	private ComboBox<BaseModel> trnrBusinCd01; 
	private ComboBox<BaseModel> trnrBusinCd02; 
	private ComboBox<BaseModel> trnrBusinCd03; 
	private ComboBox<BaseModel> trnrBusinCd04; 
	private ComboBox<BaseModel> trnrBusinCd05; 
	private ComboBox<BaseModel> trnrBusinCd06; 
	private ComboBox<BaseModel> trnrBusinCd07; 
	private ComboBox<BaseModel> trnrBusinCd08; 
	// -------------- 이관부 종료 ----------------
	
    
    
	// -------------- 서비스 호출 시작 --------------
	private InfcPkgBass0500ServiceAsync infcBass0500Service = InfcPkgBass0500Service.Util.getInstance();
	private PayrP530001ServiceAsync payrP530001Service = PayrP530001Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
      
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
	    
//		bfrYr.setValue(listStoreSrhYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
//		cretnYr.setValue(listStoreSrhYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
   
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
	 // -------------- stroe 선언 시작 --------------
	    private ListStore<BaseModel> businYrStore     = new ListStore<BaseModel>();		// 년도
	 	private ListStore<BaseModel> lsBfrdeptCd	  = new ListStore<BaseModel>();		// 부서
//	 	private ListStore<BaseModel> listStoredeptCd = new ListStore<BaseModel>();		// 부서
	 	private ListStore<BaseModel> lsCredeptCd	  = new ListStore<BaseModel>();		// 부서	 	
	 	private ListStore<BaseModel> lsBfrBusinCd = new ListStore<BaseModel>();			// 이전 사업
	 	private ListStore<BaseModel> lsTrnrBusinCd = new ListStore<BaseModel>();		// 이관 사업
	 // -------------- stroe 선언 종료 --------------
	    
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
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/
		/**
		 * 권한설정 처리 체크 AuthAction
		 */
		 private void checkYetaP03001Auth( String authAction, ListStore<BaseModel>bm) {
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
					 
				   if (!maskTracker) { unmask(); } 
				   authExecEnabled();
			   }
		 }
	  	 
	private void authExecEnabled() { 
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작
				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
				 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 Field<?>[] fldArrField = {bfrDeptCd};
			 gwtAuthorization.formAuthFieldConfig(fldArrField);
			 
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  * 권한설정을 위한 콤보처리를 위한 메서드 종료
			  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 bfrDeptCd.getListView().fireEvent(Events.CheckChanged);
			 creDeptCd.getListView().fireEvent(Events.CheckChanged);
		 }
	
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker)
				// {
				cancel();
				unmask();
		      	authExecEnabled() ;
				maskTracker = true;
				// }
			}
		};
		     
		 private void initLoad() {
		
			 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
			 gwtAuthorization = GWTAuthorization.getInstance();
			 gwtExtAuth = GWTExtAuth.getInstance();
			
			
			 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
			 authMapDef.put("deptCd",Boolean.FALSE);
			
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
	  
	public PayrP530001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
		//콤보 권한초기화
		initLoad(); 		
		
		this.setBodyBorder(false);
		this.setHeaderVisible(false);

		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		
//		this.setBodyBorder(false);
//		this.setBorders(false);
//		this.setHeaderVisible(false);
	        //FormLayout layout = new FormLayout();
	        //layout.setDefaultWidth(600);
	       // layout.setLabelWidth(0);  
	       // this.setLayout(layout);   
		this.setAutoHeight(true);
//		this.caller = caller;

		cpPayrP53001 = new ContentPanel();

		createSearchForm(); // 기본정보 필드를 적용
//		createMsfGridForm(); // 그리드필드
		   
	           
		cpPayrP53001.setBodyBorder(false);
		cpPayrP53001.setBorders(false);
		cpPayrP53001.setHeaderVisible(false);
		cpPayrP53001.setSize("770px", "280px");

		this.add(cpPayrP53001);
		formBinding = new FormBinding(this, true);

		this.setSize("800px", "350px");
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
	  
	  
	   

	/**
	 * 기본정보 설정
	 */
	private void createSearchForm() {
		
			
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpPayrP53001.add(dpobCd);
		
		
		sysComBass0500Dto = new PrgmComBass0500DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		payr0490Dto 		  = new Payr0490DTO();
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//		sysComBass0300Dto.setRpsttvCd("Y002");
//		lsSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
//		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		//--------------------년도 불러 오는 함수 ------------------------------------------------
		/**  생성된 부서의 년도를 가져 온다. **/
		infcBass0500Service.getBass0500BusinYrList(new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				businYrStore.add(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "사업 년도 에러!", null);
			}
		});
		
		
		 //--------------------부서 불러 오는 함수 ------------------------------------------------  
		 sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		
		 lsBfrdeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		 
		 sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		
		 lsCredeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		       
		
		


		cpPayrP53001.setLayout(new FlowLayout());

//		topBassBtnBar = new ButtonBar();
//		topBassBtnBar.setAlignment(HorizontalAlignment.RIGHT);
//
//		btnBassNew = new Button("신규");
//		btnBassNew.setIcon(MSFMainApp.ICONS.new16());
//		btnBassNew.addListener(Events.Select, new Listener<ButtonEvent>() {
//			@Override
//			public void handleEvent(ButtonEvent be) {
//				
//				// TODO Auto-generated method stub
//				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//	 	    		 return;
//	      	     }
				 
//				 bassP05001GridPanel.getMsfGrid().clearData();
//				 
//				 BaseModel bmData = bassP05001GridPanel.getTableDef().getDefaultValues();  
//		              
////		         bmData.set("dpobCd",  MSFMainApp.get().getUser().getDpobCd()); /** column 사업장코드 : dpobCd */
//		         bmData.set("dpobCd",  dpobCd.getValue()); 		/** column 사업장코드 : dpobCd */
//		         bmData.set("systemkey", systemkey.getValue()); /** column SYSTEMKEY : systemkey */
//		         bmData.set("edacRvyy", edacRvyy.getValue());	/** column 연말정산귀속년도 : edacRvyy */
//		         bmData.set("settGbcd", settGbcd.getValue());	/** column 정산구분코드 : settGbcd */
//		         
//		         
//		         bmData.set("ctrbYrmn", "");    /** column 기부조정명세기부연도 : ctrbYrmn */
//		         bmData.set("ctrbDdcd", "");    /** column 기부조정명세유형구분코드 : ctrbDdcd */
//		         bmData.set("ctrbTycd", "");    /** column 기부조정명세유형코드 : ctrbTycd */
//		         bmData.set("ctrbAmnt", 0L);    /** column 기부조정명세기부금액 : ctrbAmnt */
//		         bmData.set("bfyrDeam", 0L);    /** column 전년도_공제금액 : bfyrDeam */
//		         bmData.set("detrAmnt", 0L);    /** column 공제대상금액 : detrAmnt */
//		         bmData.set("dyyrDeam", 0L);    /** column 해당연도공제금액 : dyyrDeam */
//		         bmData.set("dyyrOtam", 0L);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
//		         bmData.set("ayyrNtam", 0L);    /** column 해당년도_미공제이월금액 : ayyrNtam */
//		         
//		         bassP05001GridPanel.getMsfGrid().getGrid().stopEditing();      
//		         bassP05001GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
//		         bassP05001GridPanel.getMsfGrid().getGrid().startEditing(bassP05001GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
//				doAction(actionDatabase);
//		         
//		         actionDatabase = ActionDatabase.INSERT;
//			}
//		});
//		topBassBtnBar.add(btnBassNew);
//
//		
//		btnBassSrh = new Button("조회");
//		btnBassSrh.setIcon(MSFMainApp.ICONS.save16());
//		btnBassSrh.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"))) {
//					MessageBox.alert( "경고",  "이전년도를 선택해 주세요.", null);
//					return;					
//				}
//			}
//		});
//
//		topBassBtnBar.add(btnBassSrh);
//		cpPayrP53001.add(topBassBtnBar);
		
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("생성조건");
		  	
		  	
		LayoutContainer lcSchCol = new LayoutContainer();
		
		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());
		
		
		LayoutContainer lcSchCol1_1 = new LayoutContainer();
		
		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(80);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_1.setLayout(fl1_1);
		
		bfrDeptCd = new ComboBox<BaseModel>();
		bfrDeptCd.setName("bfrDeptCd");
		bfrDeptCd.setFieldLabel("부서명");
		bfrDeptCd.setForceSelection(true);
		bfrDeptCd.setMinChars(1);
		bfrDeptCd.setDisplayField("deptNmRtchnt");
		bfrDeptCd.setValueField("deptCd");
		bfrDeptCd.setTriggerAction(TriggerAction.ALL);
		bfrDeptCd.setEmptyText("--부서선택--");
		bfrDeptCd.setSelectOnFocus(true);
//		deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		bfrDeptCd.setStore(lsBfrdeptCd);
		bfrDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		bfrDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
             BaseModel bmPayYr =  se.getSelectedItem(); 
             if (bmPayYr != null ) {
            	 
            	 //--------------------이전년도 사업 불러 오는 함수 -------------------------------------------------
       	   	  	 sysComBass0500Dto = new PrgmComBass0500DTO();
                 sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr")); 
                 sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd")); 
                 
                 lsBfrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                 
                 brfBusinCd01.setStore(lsBfrBusinCd); 
                 brfBusinCd02.setStore(lsBfrBusinCd);
                 brfBusinCd03.setStore(lsBfrBusinCd);
                 brfBusinCd04.setStore(lsBfrBusinCd);
                 brfBusinCd05.setStore(lsBfrBusinCd);
                 brfBusinCd06.setStore(lsBfrBusinCd);
                 brfBusinCd07.setStore(lsBfrBusinCd);
                 brfBusinCd08.setStore(lsBfrBusinCd);
                //--------------------이전년도 사업 불러 오는 함수 -------------------------------------------------
				}
			}
		});
		bfrDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		             * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   checkYetaP03001Auth("deptCd", lsBfrdeptCd);  
		    	   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
				}
			}
		});
		lcSchCol1_1.add(bfrDeptCd, new FormData("100%"));
		
		
		
		LayoutContainer lcSchCol1_2 = new LayoutContainer();
		
		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(80);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_2.setLayout(fl1_2);
		
		bfrYr = new ComboBox<BaseModel>();
		bfrYr.setFieldLabel("이전사업년도");
		bfrYr.setName("bfrYr");
		bfrYr.setForceSelection(true);
		bfrYr.setMinChars(1);
		bfrYr.setDisplayField("businApptnYr");
		bfrYr.setValueField("businApptnYr");
		bfrYr.setTriggerAction(TriggerAction.ALL);
		bfrYr.setEmptyText("--년도선택--");
		bfrYr.setStore(businYrStore);
//		bfrYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//            	
//	             BaseModel bmBusinYr =  se.getSelectedItem(); 
//	             if (bmBusinYr != null) {
//	            	 
//						//--------------------이전년도 사업 불러 오는 함수 -------------------------------------------------
//		          	   	sysComBass0500Dto = new PrgmComBass0500DTO();
//		                sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr")); 
//		         	    sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "commCd")); 
//		            		      
//		        	    lsBfrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	
//						brfBusinCd01.setStore(lsBfrBusinCd);
//						brfBusinCd02.setStore(lsBfrBusinCd);
//						brfBusinCd03.setStore(lsBfrBusinCd);
//						brfBusinCd04.setStore(lsBfrBusinCd);
//						brfBusinCd05.setStore(lsBfrBusinCd);
//						brfBusinCd06.setStore(lsBfrBusinCd);
//						brfBusinCd07.setStore(lsBfrBusinCd);
//						brfBusinCd08.setStore(lsBfrBusinCd);
//		         		//--------------------이전년도 사업 불러 오는 함수 -------------------------------------------------
//	             }
//            }
//		});
		bfrYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) { 
//					cretnYr.setValue(businYrStore.getAt(0));
					 String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());	
			         int yyyy = Integer.parseInt(fmt.toString()) - 1; 
					 bfrYr.setValue(businYrStore.findModel("businApptnYr",String.valueOf(yyyy)));
					 bfrYr.setStore(businYrStore);	
				} 
			}
		});    
		bfrYr.setSelectOnFocus(true);
		
		lcSchCol1_2.add(bfrYr, new FormData("100%"));
		
		
		LayoutContainer lcSchCol1_5 = new LayoutContainer();
		
		fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(80);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_5.setLayout(fl1_1);
		
		creDeptCd = new ComboBox<BaseModel>();
		creDeptCd.setName("creDeptCd");
		creDeptCd.setFieldLabel("이관부서명");
		creDeptCd.setForceSelection(true);
		creDeptCd.setMinChars(1);
		creDeptCd.setDisplayField("deptNmRtchnt");
		creDeptCd.setValueField("deptCd");
		creDeptCd.setTriggerAction(TriggerAction.ALL);
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.setSelectOnFocus(true);
//		deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creDeptCd.setStore(lsCredeptCd);
		creDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		creDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
             BaseModel bmPayYr =  se.getSelectedItem(); 
             if (bmPayYr != null ) {
            	 
               //-------------------- 이관년도 사업 불러 오는 함수 -------------------------------------------------
                 sysComBass0500Dto = new PrgmComBass0500DTO();
                 sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(cretnYr,"businApptnYr")); 
                 sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(creDeptCd, "deptCd"));
                 
                 lsTrnrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                 
                 trnrBusinCd01.setStore(lsTrnrBusinCd); 
                 trnrBusinCd02.setStore(lsTrnrBusinCd);
                 trnrBusinCd03.setStore(lsTrnrBusinCd);
                 trnrBusinCd04.setStore(lsTrnrBusinCd);
                 trnrBusinCd05.setStore(lsTrnrBusinCd);
                 trnrBusinCd06.setStore(lsTrnrBusinCd);
                 trnrBusinCd07.setStore(lsTrnrBusinCd);
                 trnrBusinCd08.setStore(lsTrnrBusinCd);
                //-------------------- 이관년도 사업 불러 오는 함수 -------------------------------------------------          
				}
			}
		});
		
		creDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		             * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   checkYetaP03001Auth("deptCd", lsCredeptCd);  
		    	   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
				}
			}
		});
		lcSchCol1_5.add(creDeptCd, new FormData("100%"));		
		
		
		
		
		LayoutContainer lcSchCol1_3 = new LayoutContainer();
		
		FormLayout fl1_3 = new FormLayout();
		fl1_3.setLabelWidth(80);
		fl1_3.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_3.setLayout(fl1_3);
		
		cretnYr = new ComboBox<BaseModel>();
		cretnYr.setFieldLabel("이관년도");
		cretnYr.setName("cretnYr");
		cretnYr.setForceSelection(true);
		cretnYr.setMinChars(1);
		cretnYr.setDisplayField("businApptnYr");
		cretnYr.setValueField("businApptnYr");
		cretnYr.setTriggerAction(TriggerAction.ALL);
		cretnYr.setEmptyText("--년도선택--");
		cretnYr.setSelectOnFocus(true);
		cretnYr.setStore(businYrStore);
//		cretnYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//             BaseModel bmBusinYr =  se.getSelectedItem(); 
//             if (bmBusinYr != null) {
//            	 
//	           	    //-------------------- 이관년도 사업 불러 오는 함수 -------------------------------------------------
//					sysComBass0500Dto = new PrgmComBass0500DTO();
//					sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//					sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "commCd"));
//
//					lsTrnrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//
//					trnrBusinCd01.setStore(lsTrnrBusinCd);
//					trnrBusinCd02.setStore(lsTrnrBusinCd);
//					trnrBusinCd03.setStore(lsTrnrBusinCd);
//					trnrBusinCd04.setStore(lsTrnrBusinCd);
//					trnrBusinCd05.setStore(lsTrnrBusinCd);
//					trnrBusinCd06.setStore(lsTrnrBusinCd);
//					trnrBusinCd07.setStore(lsTrnrBusinCd);
//					trnrBusinCd08.setStore(lsTrnrBusinCd);
//	                 //-------------------- 이관년도 사업 불러 오는 함수 -------------------------------------------------
//
//				}
//			}
//		});
		cretnYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {

				EventType type = be.getType();
				if (type == Store.Add) { 
//					cretnYr.setValue(businYrStore.getAt(0));
					 bfrYr.setValue(businYrStore.findModel("businApptnYr",DateTimeFormat.getFormat("yyyy").format(new Date())));     
				} 
			}
		});    
		
		lcSchCol1_3.add(cretnYr, new FormData("100%"));
		
		
		LayoutContainer lcSchCol1_4 = new LayoutContainer();
		
		FormLayout fl1_4 = new FormLayout();
//		fl1_3.setLabelWidth(80);
//		fl1_3.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_4.setLayout(fl1_4);
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);
		
		Button btnSearch = new Button("조회");
		btnSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(bfrDeptCd,"deptCd"))) {
					MessageBox.alert( "경고",  "부서를 선택해 주세요.", null);
					return;	
				}else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"))) {
					MessageBox.alert( "경고",  "이전 사업 년도를 선택해 주세요.", null);
					return;					
				}else 	if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(cretnYr,"businApptnYr"))) {
					MessageBox.alert( "경고",  "이관 년도를 선택해 주세요.", null);
					return;					
				}else {
					
					//--------------------이전년도 사업 불러 오는 함수 -------------------------------------------------
	          	   	sysComBass0500Dto = new PrgmComBass0500DTO();
	                sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr")); 
	         	    sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd")); 
	            		      
	        	    lsBfrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	
					brfBusinCd01.setStore(lsBfrBusinCd);
					brfBusinCd02.setStore(lsBfrBusinCd);
					brfBusinCd03.setStore(lsBfrBusinCd);
					brfBusinCd04.setStore(lsBfrBusinCd);
					brfBusinCd05.setStore(lsBfrBusinCd);
					brfBusinCd06.setStore(lsBfrBusinCd);
					brfBusinCd07.setStore(lsBfrBusinCd);
					brfBusinCd08.setStore(lsBfrBusinCd);
	         		//--------------------이전년도 사업 불러 오는 함수 -------------------------------------------------
					
	           	    //-------------------- 이관년도 사업 불러 오는 함수 -------------------------------------------------
					sysComBass0500Dto = new PrgmComBass0500DTO();
					sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
					sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(creDeptCd, "deptCd"));
	
					lsTrnrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	
					trnrBusinCd01.setStore(lsTrnrBusinCd);
					trnrBusinCd02.setStore(lsTrnrBusinCd);
					trnrBusinCd03.setStore(lsTrnrBusinCd);
					trnrBusinCd04.setStore(lsTrnrBusinCd);
					trnrBusinCd05.setStore(lsTrnrBusinCd);
					trnrBusinCd06.setStore(lsTrnrBusinCd);
					trnrBusinCd07.setStore(lsTrnrBusinCd);
					trnrBusinCd08.setStore(lsTrnrBusinCd);
	                 //-------------------- 이관년도 사업 불러 오는 함수 -------------------------------------------------
					
				}
			}
		});
		btnBar.add(btnSearch);
		
		lcSchCol1_4.add(btnBar);
		
		

		lcSchCol1.add(lcSchCol1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));		// 이전년도
		lcSchCol1.add(lcSchCol1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.25));		// 부서
		lcSchCol1.add(lcSchCol1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));		// 생성년도
		lcSchCol1.add(lcSchCol1_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.25));		// 부서	
		lcSchCol1.add(lcSchCol1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.1));		// 버튼

		lcSchCol.add(lcSchCol1, new FormData("100%"));
		
		fieldSet.add(lcSchCol, new FormData("100%"));
		
		cpPayrP53001.add(fieldSet);
		cpPayrP53001.add(createMsfGridForm(), new FormData("100%"));
	}  
	 	 
	
	private LayoutContainer createMsfGridForm() {
//	private void createMsfGridForm() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		lcTabFormLayer.setLayout(frmlytStd);  
		
		
		LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setLayout(new ColumnLayout());
			
		FieldSet fldstNewFieldset2 = new FieldSet();
		fldstNewFieldset2.setCollapsible(false);
			
		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		layoutContainer2_1.setStyleAttribute("paddingLeft", "10px");
			 
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_1.setLayout(frmlytStd);
		layoutContainer2_1.add(payrLeft01(), new FormData("100%"));
		fldstNewFieldset2.add(layoutContainer2_1, new FormData("100%"));
		layoutContainer2_1.setBorders(false);
			
		layoutContainer2.add(fldstNewFieldset2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		fldstNewFieldset2.setHeadingHtml("");
			
		
		lcTabFormLayer.add(layoutContainer2);
		
		LabelField lblfldNewLabelfield = new LabelField(" * 이관 후 세부사항 : 금액, 시작일자, 종료일자, 지급월 등은 정비가 필요합니다. ");
		lcTabFormLayer.add(lblfldNewLabelfield, new FormData("100%"));
		
		return lcTabFormLayer;
	}	
	
	
	
	private LayoutContainer payrLeft01() {
			  
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		lcStdGrid.setLayout(frmlytStd);  
		    
//		ContentPanel cpGridBassP0500 = new ContentPanel();
//		cpGridBassP0500.setBodyBorder(false); 
//		cpGridBassP0500.setHeaderVisible(false);   
//		cpGridBassP0500.setLayout(new FitLayout());      
////	    cpGridBassP0500.setSize(430, 480);   
		
		
		LayoutContainer lc = new LayoutContainer();
		
		
		LayoutContainer lc_1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_1_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70); 
		lc_1_1.setLayout(frmlytStd);  

		brfBusinCd01 = new ComboBox<BaseModel>();
        brfBusinCd01.setName("brfBusinCd01");
        brfBusinCd01.setForceSelection(true);
        brfBusinCd01.setMinChars(1);
        brfBusinCd01.setDisplayField("businNm");
        brfBusinCd01.setValueField("businCd");
        brfBusinCd01.setTriggerAction(TriggerAction.ALL);
        brfBusinCd01.setEmptyText("--사업선택--");
        brfBusinCd01.setSelectOnFocus(true); 
//        brfBusinCd01.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//        brfBusinCd01.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        brfBusinCd01.setStore(lsBfrBusinCd);
        brfBusinCd01.setFieldLabel("사 업");
        lc_1_1.add(brfBusinCd01, new FormData("100%")); 
		
		lc_1.add(lc_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_1_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_1_2.setLayout(frmlytStd);  

		trnrBusinCd01 = new ComboBox<BaseModel>();
        trnrBusinCd01.setName("trnrBusinCd01");
        trnrBusinCd01.setForceSelection(true);
        trnrBusinCd01.setMinChars(1);
        trnrBusinCd01.setDisplayField("businNm");
        trnrBusinCd01.setValueField("businCd");
        trnrBusinCd01.setTriggerAction(TriggerAction.ALL);
        trnrBusinCd01.setEmptyText("--사업선택--");
        trnrBusinCd01.setSelectOnFocus(true); 
//        trnrBusinCd01.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//        trnrBusinCd01.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        trnrBusinCd01.setStore(lsTrnrBusinCd);
        trnrBusinCd01.setFieldLabel("-> 	사 업");
        lc_1_2.add(trnrBusinCd01, new FormData("100%")); 
        
		lc_1.add(lc_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_1_3 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);
		
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd01,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd01,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setBfrDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setCreDeptCd(MSFSharedUtils.getSelectedComboValue(creDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd01,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd01,"businCd"));
				
				trnrBass0500(payr0490Dto);
			}
		});
		btnBar.add(btnBassSave);
		lc_1_3.add(btnBar);
		
		lc_1.add(lc_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lc.add(lc_1);
		
		//
		LayoutContainer lc_2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_2_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_2_1.setLayout(frmlytStd);  

		brfBusinCd02 = new ComboBox<BaseModel>();
		brfBusinCd02.setName("brfBusinCd02");
		brfBusinCd02.setForceSelection(true);
		brfBusinCd02.setMinChars(1);
		brfBusinCd02.setDisplayField("businNm");
		brfBusinCd02.setValueField("businCd");
		brfBusinCd02.setTriggerAction(TriggerAction.ALL);
		brfBusinCd02.setEmptyText("--사업선택--");
		brfBusinCd02.setSelectOnFocus(true); 
//		brfBusinCd02.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		brfBusinCd02.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        brfBusinCd02.setStore(lsBfrBusinCd);
		brfBusinCd02.setFieldLabel("사 업");
		lc_2_1.add(brfBusinCd02, new FormData("100%")); 
		
		lc_1.add(lc_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_2_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_2_2.setLayout(frmlytStd);  

		trnrBusinCd02 = new ComboBox<BaseModel>();
		trnrBusinCd02.setName("trnrBusinCd02");
		trnrBusinCd02.setForceSelection(true);
		trnrBusinCd02.setMinChars(1);
		trnrBusinCd02.setDisplayField("businNm");
		trnrBusinCd02.setValueField("businCd");
		trnrBusinCd02.setTriggerAction(TriggerAction.ALL);
		trnrBusinCd02.setEmptyText("--사업선택--");
		trnrBusinCd02.setSelectOnFocus(true); 
//		trnrBusinCd02.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		trnrBusinCd02.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        trnrBusinCd02.setStore(lsTrnrBusinCd);
		trnrBusinCd02.setFieldLabel("-> 	사 업");
		lc_2_2.add(trnrBusinCd02, new FormData("100%")); 
		
		lc_1.add(lc_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_2_3 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);	
			
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd02,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd02,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd02,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd02,"businCd"));
				
				trnrBass0500(payr0490Dto);
				
			}
		});
		btnBar.add(btnBassSave);
		lc_2_3.add(btnBar);
		
		lc_1.add(lc_2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lc.add(lc_2);
		
		//
		LayoutContainer lc_3 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_3_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout(); 
		frmlytStd.setLabelWidth(70);
		lc_3_1.setLayout(frmlytStd);  

		brfBusinCd03 = new ComboBox<BaseModel>();
		brfBusinCd03.setName("brfBusinCd03");
		brfBusinCd03.setForceSelection(true);
		brfBusinCd03.setMinChars(1);
		brfBusinCd03.setDisplayField("businNm");
		brfBusinCd03.setValueField("businCd");
		brfBusinCd03.setTriggerAction(TriggerAction.ALL);
		brfBusinCd03.setEmptyText("--사업선택--");
		brfBusinCd03.setSelectOnFocus(true); 
//		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        brfBusinCd03.setStore(lsBfrBusinCd);
		brfBusinCd03.setFieldLabel("사 업");
		lc_3_1.add(brfBusinCd03, new FormData("100%")); 
		
		lc_1.add(lc_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_3_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_3_2.setLayout(frmlytStd);  

		trnrBusinCd03 = new ComboBox<BaseModel>();
		trnrBusinCd03.setName("trnrBusinCd03");
		trnrBusinCd03.setForceSelection(true);
		trnrBusinCd03.setMinChars(1);
		trnrBusinCd03.setDisplayField("businNm");
		trnrBusinCd03.setValueField("businCd");
		trnrBusinCd03.setTriggerAction(TriggerAction.ALL);
		trnrBusinCd03.setEmptyText("--사업선택--");
		trnrBusinCd03.setSelectOnFocus(true); 
//		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        trnrBusinCd03.setStore(lsTrnrBusinCd);
		trnrBusinCd03.setFieldLabel("-> 	사 업");
		lc_3_2.add(trnrBusinCd03, new FormData("100%")); 
		
		lc_1.add(lc_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_3_3 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);	
		
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd03,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd03,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd03,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd03,"businCd"));
				
				trnrBass0500(payr0490Dto);
			
			}
		});
		btnBar.add(btnBassSave);
		lc_3_3.add(btnBar);
		
		lc_1.add(lc_3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		
		lc.add(lc_3);
		
		//
		LayoutContainer lc_4 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_4_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_4_1.setLayout(frmlytStd);  

		brfBusinCd04 = new ComboBox<BaseModel>();
		brfBusinCd04.setName("brfBusinCd04");
		brfBusinCd04.setForceSelection(true);
		brfBusinCd04.setMinChars(1);
		brfBusinCd04.setDisplayField("businNm");
		brfBusinCd04.setValueField("businCd");
		brfBusinCd04.setTriggerAction(TriggerAction.ALL);
		brfBusinCd04.setEmptyText("--사업선택--");
		brfBusinCd04.setSelectOnFocus(true); 
//		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        brfBusinCd04.setStore(lsBfrBusinCd);
		brfBusinCd04.setFieldLabel("사 업");
		lc_4_1.add(brfBusinCd04, new FormData("100%")); 
		
		lc_1.add(lc_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_4_2 = new LayoutContainer();

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_4_2.setLayout(frmlytStd);  

		trnrBusinCd04 = new ComboBox<BaseModel>();
		trnrBusinCd04.setName("trnrBusinCd04");
		trnrBusinCd04.setForceSelection(true);
		trnrBusinCd04.setMinChars(1);
		trnrBusinCd04.setDisplayField("businNm");
		trnrBusinCd04.setValueField("businCd");
		trnrBusinCd04.setTriggerAction(TriggerAction.ALL);
		trnrBusinCd04.setEmptyText("--사업선택--");
		trnrBusinCd04.setSelectOnFocus(true); 
//		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        trnrBusinCd04.setStore(lsTrnrBusinCd);
		trnrBusinCd04.setFieldLabel("-> 				사 업");
		lc_4_2.add(trnrBusinCd04, new FormData("100%")); 
		
		lc_1.add(lc_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_4_3 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);	
		
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd04,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd04,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd04,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd04,"businCd"));
				
				trnrBass0500(payr0490Dto);
				
			}
		});
		btnBar.add(btnBassSave);
		lc_4_3.add(btnBar);
		
		lc_1.add(lc_4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lc.add(lc_4);
		
		//
		LayoutContainer lc_5 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_5_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout(); 
		frmlytStd.setLabelWidth(70);
		lc_5_1.setLayout(frmlytStd);  

		brfBusinCd05 = new ComboBox<BaseModel>();
		brfBusinCd05.setName("brfBusinCd05");
		brfBusinCd05.setForceSelection(true);
		brfBusinCd05.setMinChars(1);
		brfBusinCd05.setDisplayField("businNm");
		brfBusinCd05.setValueField("businCd");
		brfBusinCd05.setTriggerAction(TriggerAction.ALL);
		brfBusinCd05.setEmptyText("--사업선택--");
		brfBusinCd05.setSelectOnFocus(true); 
//		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        brfBusinCd05.setStore(lsBfrBusinCd);
		brfBusinCd05.setFieldLabel("사 업");
		lc_5_1.add(brfBusinCd05, new FormData("100%")); 
		
		lc_1.add(lc_5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_5_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_5_2.setLayout(frmlytStd);  

		trnrBusinCd05 = new ComboBox<BaseModel>();
		trnrBusinCd05.setName("trnrBusinCd05");
		trnrBusinCd05.setForceSelection(true);
		trnrBusinCd05.setMinChars(1);
		trnrBusinCd05.setDisplayField("businNm");
		trnrBusinCd05.setValueField("businCd");
		trnrBusinCd05.setTriggerAction(TriggerAction.ALL);
		trnrBusinCd05.setEmptyText("--사업선택--");
		trnrBusinCd05.setSelectOnFocus(true); 
//		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        trnrBusinCd05.setStore(lsTrnrBusinCd);
		trnrBusinCd05.setFieldLabel("-> 				사 업");
		lc_5_2.add(trnrBusinCd05, new FormData("100%"));
		
		lc_1.add(lc_5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_5_3 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);	
		
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd05,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd05,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd05,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd05,"businCd"));
				
				trnrBass0500(payr0490Dto);
				
			}
		});
		btnBar.add(btnBassSave);
		lc_5_3.add(btnBar);
		
		lc_1.add(lc_5_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		
		lc.add(lc_5);
		
		//
		LayoutContainer lc_6 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_6_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_6_1.setLayout(frmlytStd);  

		brfBusinCd06 = new ComboBox<BaseModel>();
		brfBusinCd06.setName("brfBusinCd06");
		brfBusinCd06.setForceSelection(true);
		brfBusinCd06.setMinChars(1);
		brfBusinCd06.setDisplayField("businNm");
		brfBusinCd06.setValueField("businCd");
		brfBusinCd06.setTriggerAction(TriggerAction.ALL);
		brfBusinCd06.setEmptyText("--사업선택--");
		brfBusinCd06.setSelectOnFocus(true); 
//		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        brfBusinCd06.setStore(lsBfrBusinCd);
		brfBusinCd06.setFieldLabel("사 업");
		lc_6_1.add(brfBusinCd06, new FormData("100%")); 
		lc_1.add(lc_6_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		
		LayoutContainer lc_6_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_6_2.setLayout(frmlytStd);  

		trnrBusinCd06 = new ComboBox<BaseModel>();
		trnrBusinCd06.setName("trnrBusinCd06");
		trnrBusinCd06.setForceSelection(true);
		trnrBusinCd06.setMinChars(1);
		trnrBusinCd06.setDisplayField("businNm");
		trnrBusinCd06.setValueField("businCd");
		trnrBusinCd06.setTriggerAction(TriggerAction.ALL);
		trnrBusinCd06.setEmptyText("--사업선택--");
		trnrBusinCd06.setSelectOnFocus(true); 
//		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        trnrBusinCd06.setStore(lsTrnrBusinCd);
		trnrBusinCd06.setFieldLabel("-> 				사 업");
		lc_6_2.add(trnrBusinCd06, new FormData("100%")); 
		lc_1.add(lc_6_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_6_3 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);	
		
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd06,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd06,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd06,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd06,"businCd"));
				
				trnrBass0500(payr0490Dto);
			}
		});
		btnBar.add(btnBassSave);
		lc_6_3.add(btnBar);
		
		lc_1.add(lc_6_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lc.add(lc_6);
		
		//
		LayoutContainer lc_7 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_7_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_7_1.setLayout(frmlytStd);  

		brfBusinCd07 = new ComboBox<BaseModel>();
		brfBusinCd07.setName("brfBusinCd07");
		brfBusinCd07.setForceSelection(true);
		brfBusinCd07.setMinChars(1);
		brfBusinCd07.setDisplayField("businNm");
		brfBusinCd07.setValueField("businCd");
		brfBusinCd07.setTriggerAction(TriggerAction.ALL);
		brfBusinCd07.setEmptyText("--사업선택--");
		brfBusinCd07.setSelectOnFocus(true); 
//		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        brfBusinCd07.setStore(lsBfrBusinCd);
		brfBusinCd07.setFieldLabel("사 업");
		lc_7_1.add(brfBusinCd07, new FormData("100%")); 
		
		lc_1.add(lc_7_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_7_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_7_2.setLayout(frmlytStd);  

		trnrBusinCd07 = new ComboBox<BaseModel>();
		trnrBusinCd07.setName("trnrBusinCd07");
		trnrBusinCd07.setForceSelection(true);
		trnrBusinCd07.setMinChars(1);
		trnrBusinCd07.setDisplayField("businNm");
		trnrBusinCd07.setValueField("businCd");
		trnrBusinCd07.setTriggerAction(TriggerAction.ALL);
		trnrBusinCd07.setEmptyText("--사업선택--");
		trnrBusinCd07.setSelectOnFocus(true); 
//		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
        trnrBusinCd07.setStore(lsTrnrBusinCd);
		trnrBusinCd07.setFieldLabel("-> 				사 업");
		lc_7_2.add(trnrBusinCd07, new FormData("100%")); 
		
		lc_1.add(lc_7_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_7_3 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);	
		
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd07,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd07,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd07,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd07,"businCd"));
				
				trnrBass0500(payr0490Dto);
				
			}
		});
		btnBar.add(btnBassSave);
		lc_7_3.add(btnBar);
		
		lc_1.add(lc_7_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		
		lc.add(lc_7);
		
		//
		LayoutContainer lc_8 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc_8_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_8_1.setLayout(frmlytStd);  

		brfBusinCd08 = new ComboBox<BaseModel>();
		brfBusinCd08.setName("brfBusinCd08");
		brfBusinCd08.setForceSelection(true);
		brfBusinCd08.setMinChars(1);
		brfBusinCd08.setDisplayField("businNm");
		brfBusinCd08.setValueField("businCd");
		brfBusinCd08.setTriggerAction(TriggerAction.ALL);
		brfBusinCd08.setEmptyText("--사업선택--");
		brfBusinCd08.setSelectOnFocus(true); 
//		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
		brfBusinCd08.setStore(lsBfrBusinCd);
		brfBusinCd08.setFieldLabel("사 업");
		lc_8_1.add(brfBusinCd08, new FormData("100%")); 
		lc_1.add(lc_8_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_8_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70);
		lc_8_2.setLayout(frmlytStd);  

		trnrBusinCd08 = new ComboBox<BaseModel>();
		trnrBusinCd08.setName("trnrBusinCd08");
		trnrBusinCd08.setForceSelection(true);
		trnrBusinCd08.setMinChars(1);
		trnrBusinCd08.setDisplayField("businNm");
		trnrBusinCd08.setValueField("businCd");
		trnrBusinCd08.setTriggerAction(TriggerAction.ALL);
		trnrBusinCd08.setEmptyText("--사업선택--");
		trnrBusinCd08.setSelectOnFocus(true); 
//		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
		trnrBusinCd08.setStore(lsTrnrBusinCd);
		trnrBusinCd08.setFieldLabel("-> 				사 업");
		lc_8_2.add(trnrBusinCd08, new FormData("100%")); 
		
		lc_1.add(lc_8_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		LayoutContainer lc_8_3 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.CENTER);	
		
		btnBassSave = new Button("생성");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd08,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd08,"businCd"));
				
				payr0490Dto = new Payr0490DTO();
				
				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(bfrDeptCd, "deptCd"));
				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd08,"businCd"));
				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd08,"businCd"));
				
				trnrBass0500(payr0490Dto);
				
			}
		});
		btnBar.add(btnBassSave);
		lc_8_3.add(btnBar);
		
		lc_1.add(lc_8_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		lc.add(lc_8);
		
		
		
		
//		LayoutContainer lc = new LayoutContainer(new ColumnLayout());
//		frmlytStd = new FormLayout();  
//		lc.setLayout(frmlytStd);  

		
//		LayoutContainer lcLeft= new LayoutContainer();
//		frmlytStd = new FormLayout();  
//		lcLeft.setLayout(frmlytStd);  
//		
//		LayoutContainer lcL1 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70); 
//		lcL1.setLayout(frmlytStd);  
//
//		brfBusinCd01 = new ComboBox<BaseModel>();
//        brfBusinCd01.setName("brfBusinCd01");
//        brfBusinCd01.setForceSelection(true);
//        brfBusinCd01.setMinChars(1);
//        brfBusinCd01.setDisplayField("businNm");
//        brfBusinCd01.setValueField("businCd");
//        brfBusinCd01.setTriggerAction(TriggerAction.ALL);
//        brfBusinCd01.setEmptyText("--사업선택--");
//        brfBusinCd01.setSelectOnFocus(true); 
////        brfBusinCd01.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////        brfBusinCd01.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        brfBusinCd01.setStore(lsBfrBusinCd);
//        brfBusinCd01.setFieldLabel("사 업");
//        lcL1.add(brfBusinCd01, new FormData("100%")); 
//	    
//	    lcLeft.add(lcL1);
//		
//		LayoutContainer lcL2= new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcL2.setLayout(frmlytStd);  
//
//		brfBusinCd02 = new ComboBox<BaseModel>();
//		brfBusinCd02.setName("brfBusinCd02");
//		brfBusinCd02.setForceSelection(true);
//		brfBusinCd02.setMinChars(1);
//		brfBusinCd02.setDisplayField("businNm");
//		brfBusinCd02.setValueField("businCd");
//		brfBusinCd02.setTriggerAction(TriggerAction.ALL);
//		brfBusinCd02.setEmptyText("--사업선택--");
//		brfBusinCd02.setSelectOnFocus(true); 
////		brfBusinCd02.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		brfBusinCd02.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        brfBusinCd02.setStore(lsBfrBusinCd);
//		brfBusinCd02.setFieldLabel("사 업");
//		lcL2.add(brfBusinCd02, new FormData("100%")); 
//		
//        lcLeft.add(lcL2);
//		
//		LayoutContainer lcL3 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout(); 
//		frmlytStd.setLabelWidth(70);
//		lcL3.setLayout(frmlytStd);  
//
//		brfBusinCd03 = new ComboBox<BaseModel>();
//		brfBusinCd03.setName("brfBusinCd03");
//		brfBusinCd03.setForceSelection(true);
//		brfBusinCd03.setMinChars(1);
//		brfBusinCd03.setDisplayField("businNm");
//		brfBusinCd03.setValueField("businCd");
//		brfBusinCd03.setTriggerAction(TriggerAction.ALL);
//		brfBusinCd03.setEmptyText("--사업선택--");
//		brfBusinCd03.setSelectOnFocus(true); 
////		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        brfBusinCd03.setStore(lsBfrBusinCd);
//		brfBusinCd03.setFieldLabel("사 업");
//		lcL3.add(brfBusinCd03, new FormData("100%")); 
//		
//		lcLeft.add(lcL3);
//		
//		LayoutContainer lcL4 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcL4.setLayout(frmlytStd);  
//
//		brfBusinCd04 = new ComboBox<BaseModel>();
//		brfBusinCd04.setName("brfBusinCd04");
//		brfBusinCd04.setForceSelection(true);
//		brfBusinCd04.setMinChars(1);
//		brfBusinCd04.setDisplayField("businNm");
//		brfBusinCd04.setValueField("businCd");
//		brfBusinCd04.setTriggerAction(TriggerAction.ALL);
//		brfBusinCd04.setEmptyText("--사업선택--");
//		brfBusinCd04.setSelectOnFocus(true); 
////		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        brfBusinCd04.setStore(lsBfrBusinCd);
//		brfBusinCd04.setFieldLabel("사 업");
//		lcL4.add(brfBusinCd04, new FormData("100%")); 
//		
//		lcLeft.add(lcL4);
//		
//		LayoutContainer lcL5 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout(); 
//		frmlytStd.setLabelWidth(70);
//		lcL5.setLayout(frmlytStd);  
//
//		brfBusinCd05 = new ComboBox<BaseModel>();
//		brfBusinCd05.setName("brfBusinCd05");
//		brfBusinCd05.setForceSelection(true);
//		brfBusinCd05.setMinChars(1);
//		brfBusinCd05.setDisplayField("businNm");
//		brfBusinCd05.setValueField("businCd");
//		brfBusinCd05.setTriggerAction(TriggerAction.ALL);
//		brfBusinCd05.setEmptyText("--사업선택--");
//		brfBusinCd05.setSelectOnFocus(true); 
////		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        brfBusinCd05.setStore(lsBfrBusinCd);
//		brfBusinCd05.setFieldLabel("사 업");
//		lcL5.add(brfBusinCd05, new FormData("100%")); 
//		
//		lcLeft.add(lcL5);
//		
//		LayoutContainer lcL6 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcL6.setLayout(frmlytStd);  
//
//		brfBusinCd06 = new ComboBox<BaseModel>();
//		brfBusinCd06.setName("brfBusinCd06");
//		brfBusinCd06.setForceSelection(true);
//		brfBusinCd06.setMinChars(1);
//		brfBusinCd06.setDisplayField("businNm");
//		brfBusinCd06.setValueField("businCd");
//		brfBusinCd06.setTriggerAction(TriggerAction.ALL);
//		brfBusinCd06.setEmptyText("--사업선택--");
//		brfBusinCd06.setSelectOnFocus(true); 
////		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        brfBusinCd06.setStore(lsBfrBusinCd);
//		brfBusinCd06.setFieldLabel("사 업");
//		lcL6.add(brfBusinCd06, new FormData("100%")); 
//		
//		lcLeft.add(lcL6);
//		
//		LayoutContainer lcL7 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcL7.setLayout(frmlytStd);  
//
//		brfBusinCd07 = new ComboBox<BaseModel>();
//		brfBusinCd07.setName("brfBusinCd07");
//		brfBusinCd07.setForceSelection(true);
//		brfBusinCd07.setMinChars(1);
//		brfBusinCd07.setDisplayField("businNm");
//		brfBusinCd07.setValueField("businCd");
//		brfBusinCd07.setTriggerAction(TriggerAction.ALL);
//		brfBusinCd07.setEmptyText("--사업선택--");
//		brfBusinCd07.setSelectOnFocus(true); 
////		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        brfBusinCd07.setStore(lsBfrBusinCd);
//		brfBusinCd07.setFieldLabel("사 업");
//		lcL7.add(brfBusinCd07, new FormData("100%")); 
//		
//		lcLeft.add(lcL7);
//		
//		LayoutContainer lcL8 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcL8.setLayout(frmlytStd);  
//
//		brfBusinCd08 = new ComboBox<BaseModel>();
//		brfBusinCd08.setName("brfBusinCd08");
//		brfBusinCd08.setForceSelection(true);
//		brfBusinCd08.setMinChars(1);
//		brfBusinCd08.setDisplayField("businNm");
//		brfBusinCd08.setValueField("businCd");
//		brfBusinCd08.setTriggerAction(TriggerAction.ALL);
//		brfBusinCd08.setEmptyText("--사업선택--");
//		brfBusinCd08.setSelectOnFocus(true); 
////		brfBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		brfBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//		brfBusinCd08.setStore(lsBfrBusinCd);
//		brfBusinCd08.setFieldLabel("사 업");
//		lcL8.add(brfBusinCd08, new FormData("100%")); 
//		
//		lcLeft.add(lcL8);
//		
//		
//		LayoutContainer lcRight= new LayoutContainer(new ColumnLayout());
////		frmlytStd = new FormLayout();  
////		lcRight.setLayout(frmlytStd);  
//		
//		LayoutContainer lcRight_1= new LayoutContainer();
//		frmlytStd = new FormLayout();  
//		lcRight_1.setLayout(frmlytStd);  
//
//		LayoutContainer lcR1 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR1.setLayout(frmlytStd);  
//
//		trnrBusinCd01 = new ComboBox<BaseModel>();
//        trnrBusinCd01.setName("trnrBusinCd01");
//        trnrBusinCd01.setForceSelection(true);
//        trnrBusinCd01.setMinChars(1);
//        trnrBusinCd01.setDisplayField("businNm");
//        trnrBusinCd01.setValueField("businCd");
//        trnrBusinCd01.setTriggerAction(TriggerAction.ALL);
//        trnrBusinCd01.setEmptyText("--사업선택--");
//        trnrBusinCd01.setSelectOnFocus(true); 
////        trnrBusinCd01.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////        trnrBusinCd01.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd01.setStore(lsTrnrBusinCd);
//        trnrBusinCd01.setFieldLabel("-> 				사 업");
//        lcR1.add(trnrBusinCd01, new FormData("100%")); 
//	    
//        lcRight_1.add(lcR1);
//		
//		LayoutContainer lcR2= new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR2.setLayout(frmlytStd);  
//
//		trnrBusinCd02 = new ComboBox<BaseModel>();
//		trnrBusinCd02.setName("trnrBusinCd02");
//		trnrBusinCd02.setForceSelection(true);
//		trnrBusinCd02.setMinChars(1);
//		trnrBusinCd02.setDisplayField("businNm");
//		trnrBusinCd02.setValueField("businCd");
//		trnrBusinCd02.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd02.setEmptyText("--사업선택--");
//		trnrBusinCd02.setSelectOnFocus(true); 
////		trnrBusinCd02.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd02.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd02.setStore(lsTrnrBusinCd);
//		trnrBusinCd02.setFieldLabel("-> 				사 업");
//		lcR2.add(trnrBusinCd02, new FormData("100%")); 
//		
//		lcRight_1.add(lcR2);
//		
//		LayoutContainer lcR3 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR3.setLayout(frmlytStd);  
//
//		trnrBusinCd03 = new ComboBox<BaseModel>();
//		trnrBusinCd03.setName("trnrBusinCd03");
//		trnrBusinCd03.setForceSelection(true);
//		trnrBusinCd03.setMinChars(1);
//		trnrBusinCd03.setDisplayField("businNm");
//		trnrBusinCd03.setValueField("businCd");
//		trnrBusinCd03.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd03.setEmptyText("--사업선택--");
//		trnrBusinCd03.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd03.setStore(lsTrnrBusinCd);
//		trnrBusinCd03.setFieldLabel("-> 				사 업");
//		lcR3.add(trnrBusinCd03, new FormData("100%")); 
//		
//		lcRight_1.add(lcR3);
//		
//		LayoutContainer lcR4 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR4.setLayout(frmlytStd);  
//
//		trnrBusinCd04 = new ComboBox<BaseModel>();
//		trnrBusinCd04.setName("trnrBusinCd04");
//		trnrBusinCd04.setForceSelection(true);
//		trnrBusinCd04.setMinChars(1);
//		trnrBusinCd04.setDisplayField("businNm");
//		trnrBusinCd04.setValueField("businCd");
//		trnrBusinCd04.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd04.setEmptyText("--사업선택--");
//		trnrBusinCd04.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd04.setStore(lsTrnrBusinCd);
//		trnrBusinCd04.setFieldLabel("-> 				사 업");
//		lcR4.add(trnrBusinCd04, new FormData("100%")); 
//		
//		lcRight_1.add(lcR4);
//		
//		LayoutContainer lcR5 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR5.setLayout(frmlytStd);  
//
//		trnrBusinCd05 = new ComboBox<BaseModel>();
//		trnrBusinCd05.setName("trnrBusinCd05");
//		trnrBusinCd05.setForceSelection(true);
//		trnrBusinCd05.setMinChars(1);
//		trnrBusinCd05.setDisplayField("businNm");
//		trnrBusinCd05.setValueField("businCd");
//		trnrBusinCd05.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd05.setEmptyText("--사업선택--");
//		trnrBusinCd05.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd05.setStore(lsTrnrBusinCd);
//		trnrBusinCd05.setFieldLabel("-> 				사 업");
//		lcR5.add(trnrBusinCd05, new FormData("100%")); 
//		
//		lcRight_1.add(lcR5);
//		
//		LayoutContainer lcR6 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR6.setLayout(frmlytStd);  
//
//		trnrBusinCd06 = new ComboBox<BaseModel>();
//		trnrBusinCd06.setName("trnrBusinCd06");
//		trnrBusinCd06.setForceSelection(true);
//		trnrBusinCd06.setMinChars(1);
//		trnrBusinCd06.setDisplayField("businNm");
//		trnrBusinCd06.setValueField("businCd");
//		trnrBusinCd06.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd06.setEmptyText("--사업선택--");
//		trnrBusinCd06.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd06.setStore(lsTrnrBusinCd);
//		trnrBusinCd06.setFieldLabel("-> 				사 업");
//		lcR6.add(trnrBusinCd06, new FormData("100%")); 
//		
//		lcRight_1.add(lcR6);
//		
//		LayoutContainer lcR7 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR7.setLayout(frmlytStd);  
//
//		trnrBusinCd07 = new ComboBox<BaseModel>();
//		trnrBusinCd07.setName("trnrBusinCd07");
//		trnrBusinCd07.setForceSelection(true);
//		trnrBusinCd07.setMinChars(1);
//		trnrBusinCd07.setDisplayField("businNm");
//		trnrBusinCd07.setValueField("businCd");
//		trnrBusinCd07.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd07.setEmptyText("--사업선택--");
//		trnrBusinCd07.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd07.setStore(lsTrnrBusinCd);
//		trnrBusinCd07.setFieldLabel("-> 				사 업");
//		lcR7.add(trnrBusinCd07, new FormData("100%")); 
//		
//		lcRight_1.add(lcR7);
//		
//		LayoutContainer lcR8 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lcR8.setLayout(frmlytStd);  
//
//		trnrBusinCd08 = new ComboBox<BaseModel>();
//		trnrBusinCd08.setName("trnrBusinCd08");
//		trnrBusinCd08.setForceSelection(true);
//		trnrBusinCd08.setMinChars(1);
//		trnrBusinCd08.setDisplayField("businNm");
//		trnrBusinCd08.setValueField("businCd");
//		trnrBusinCd08.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd08.setEmptyText("--사업선택--");
//		trnrBusinCd08.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//		trnrBusinCd08.setStore(lsTrnrBusinCd);
//		trnrBusinCd08.setFieldLabel("-> 				사 업");
//		lcR8.add(trnrBusinCd08, new FormData("100%")); 
//		
//		lcRight_1.add(lcR8);
//		
//		
//		LayoutContainer lcRight_2= new LayoutContainer();
//		frmlytStd = new FormLayout();  
//		lcRight_2.setLayout(frmlytStd);  
//
//		
//		LayoutContainer lcBtn1 = new LayoutContainer();
//		
//		ButtonBar btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);
//		
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd01,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd01,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd01,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd01,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn1.add(btnBar);
//        lcRight_2.add(lcBtn1);
//		
//        
//		LayoutContainer lcBtn2= new LayoutContainer();
//
//		btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);	
//			
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd02,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd02,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd02,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd02,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//				
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn2.add(btnBar);
//		lcRight_2.add(lcBtn2);
//		
//		LayoutContainer lcBtn3 = new LayoutContainer();
//		
//		btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);	
//		
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd03,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd03,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd03,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd03,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//			
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn3.add(btnBar);
//		lcRight_2.add(lcBtn3);
//		
//		LayoutContainer lcBtn4 = new LayoutContainer();
//		
//		btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);	
//		
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd04,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd04,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd04,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd04,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//				
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn4.add(btnBar);
//		lcRight_2.add(lcBtn4);
//		
//		
//		LayoutContainer lcBtn5 = new LayoutContainer();
//		
//		btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);	
//		
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd05,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd05,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd05,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd05,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//				
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn5.add(btnBar);
//		lcRight_2.add(lcBtn5);
//		
//		LayoutContainer lcBtn6 = new LayoutContainer();
//		
//		btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);	
//		
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd06,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd06,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd06,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd06,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn6.add(btnBar);
//		lcRight_2.add(lcBtn6);
//		
//		LayoutContainer lcBtn7 = new LayoutContainer();
//		
//		btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);	
//		
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd07,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd07,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd07,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd07,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//				
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn7.add(btnBar);
//		lcRight_2.add(lcBtn7);
//		
//		LayoutContainer lcBtn8 = new LayoutContainer();
//		
//		btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.CENTER);	
//		
//		btnBassSave = new Button("생성");
//		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				
//				checekValue(MSFSharedUtils.getSelectedComboValue(brfBusinCd08,"businCd"),  MSFSharedUtils.getSelectedComboValue(trnrBusinCd08,"businCd"));
//				
//				payr0490Dto = new Payr0490DTO();
//				
//				payr0490Dto.setPayBfrYr(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"));
//				payr0490Dto.setPayCreYr(MSFSharedUtils.getSelectedComboValue(cretnYr, "businApptnYr"));
//				payr0490Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd, "deptCd"));
//				payr0490Dto.setBfrBusinCd(MSFSharedUtils.getSelectedComboValue(brfBusinCd08,"businCd"));
//				payr0490Dto.setCreBusinCd(MSFSharedUtils.getSelectedComboValue(trnrBusinCd08,"businCd"));
//				
//				trnrBass0500(payr0490Dto);
//				
//			}
//		});
//		btnBar.add(btnBassSave);
//		lcBtn8.add(btnBar);
//		lcRight_2.add(lcBtn8);
//		
//		
//		lcRight.add(lcRight_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
//		lcRight.add(lcRight_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		
//		
//		lc.add(lcLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
//		lc.add(lcRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		
		lc.add(lc_1);
		lcStdGrid.add(lc);

		return lcStdGrid;
		
	}
	
	
	
//	private LayoutContainer payrRight01() {
//		  
//		LayoutContainer lcStdGrid = new LayoutContainer();
//		lcStdGrid.setStyleAttribute("paddingRight", "10px");
//		FormLayout frmlytStd = new FormLayout();  
//		  //  frmlytStd.setLabelWidth(85); 
//		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
//		lcStdGrid.setLayout(frmlytStd);  
//		    
////		ContentPanel cpGridBassP0500 = new ContentPanel();
////		cpGridBassP0500.setBodyBorder(false); 
////		cpGridBassP0500.setHeaderVisible(false);   
////		cpGridBassP0500.setLayout(new FitLayout());      
//////	    cpGridBassP0500.setSize(350, 480);   
//		
//		LayoutContainer lc = new LayoutContainer();
//		
//		LayoutContainer lc1 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc1.setLayout(frmlytStd);  
//
//		trnrBusinCd01 = new ComboBox<BaseModel>();
//        trnrBusinCd01.setName("trnrBusinCd01");
//        trnrBusinCd01.setForceSelection(true);
//        trnrBusinCd01.setMinChars(1);
//        trnrBusinCd01.setDisplayField("businNm");
//        trnrBusinCd01.setValueField("businCd");
//        trnrBusinCd01.setTriggerAction(TriggerAction.ALL);
//        trnrBusinCd01.setEmptyText("--사업선택--");
//        trnrBusinCd01.setSelectOnFocus(true); 
////        trnrBusinCd01.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////        trnrBusinCd01.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd01.setStore(lsTrnrBusinCd);
//        trnrBusinCd01.setFieldLabel("-> 				사 업");
//	    lc1.add(trnrBusinCd01, new FormData("100%")); 
//	    
//		lc.add(lc1);
//		
//		LayoutContainer lc2= new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc2.setLayout(frmlytStd);  
//
//		trnrBusinCd02 = new ComboBox<BaseModel>();
//		trnrBusinCd02.setName("trnrBusinCd02");
//		trnrBusinCd02.setForceSelection(true);
//		trnrBusinCd02.setMinChars(1);
//		trnrBusinCd02.setDisplayField("businNm");
//		trnrBusinCd02.setValueField("businCd");
//		trnrBusinCd02.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd02.setEmptyText("--사업선택--");
//		trnrBusinCd02.setSelectOnFocus(true); 
////		trnrBusinCd02.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd02.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd02.setStore(lsTrnrBusinCd);
//		trnrBusinCd02.setFieldLabel("-> 				사 업");
//        lc2.add(trnrBusinCd02, new FormData("100%")); 
//		
//		lc.add(lc2);
//		
//		LayoutContainer lc3 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc3.setLayout(frmlytStd);  
//
//		trnrBusinCd03 = new ComboBox<BaseModel>();
//		trnrBusinCd03.setName("trnrBusinCd03");
//		trnrBusinCd03.setForceSelection(true);
//		trnrBusinCd03.setMinChars(1);
//		trnrBusinCd03.setDisplayField("businNm");
//		trnrBusinCd03.setValueField("businCd");
//		trnrBusinCd03.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd03.setEmptyText("--사업선택--");
//		trnrBusinCd03.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd03.setStore(lsTrnrBusinCd);
//		trnrBusinCd03.setFieldLabel("-> 				사 업");
//		lc3.add(trnrBusinCd03, new FormData("100%")); 
//		
//		lc.add(lc3);
//		
//		LayoutContainer lc4 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc4.setLayout(frmlytStd);  
//
//		trnrBusinCd04 = new ComboBox<BaseModel>();
//		trnrBusinCd04.setName("trnrBusinCd04");
//		trnrBusinCd04.setForceSelection(true);
//		trnrBusinCd04.setMinChars(1);
//		trnrBusinCd04.setDisplayField("businNm");
//		trnrBusinCd04.setValueField("businCd");
//		trnrBusinCd04.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd04.setEmptyText("--사업선택--");
//		trnrBusinCd04.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd04.setStore(lsTrnrBusinCd);
//		trnrBusinCd04.setFieldLabel("-> 				사 업");
//		lc4.add(trnrBusinCd04, new FormData("100%")); 
//		
//		lc.add(lc4);
//		
//		LayoutContainer lc5 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc5.setLayout(frmlytStd);  
//
//		trnrBusinCd05 = new ComboBox<BaseModel>();
//		trnrBusinCd05.setName("trnrBusinCd05");
//		trnrBusinCd05.setForceSelection(true);
//		trnrBusinCd05.setMinChars(1);
//		trnrBusinCd05.setDisplayField("businNm");
//		trnrBusinCd05.setValueField("businCd");
//		trnrBusinCd05.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd05.setEmptyText("--사업선택--");
//		trnrBusinCd05.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd05.setStore(lsTrnrBusinCd);
//		trnrBusinCd05.setFieldLabel("-> 				사 업");
//		lc5.add(trnrBusinCd05, new FormData("100%")); 
//		
//		lc.add(lc5);
//		
//		LayoutContainer lc6 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc6.setLayout(frmlytStd);  
//
//		trnrBusinCd06 = new ComboBox<BaseModel>();
//		trnrBusinCd06.setName("trnrBusinCd06");
//		trnrBusinCd06.setForceSelection(true);
//		trnrBusinCd06.setMinChars(1);
//		trnrBusinCd06.setDisplayField("businNm");
//		trnrBusinCd06.setValueField("businCd");
//		trnrBusinCd06.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd06.setEmptyText("--사업선택--");
//		trnrBusinCd06.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd06.setStore(lsTrnrBusinCd);
//		trnrBusinCd06.setFieldLabel("-> 				사 업");
//		lc6.add(trnrBusinCd06, new FormData("100%")); 
//		
//		lc.add(lc6);
//		
//		LayoutContainer lc7 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc7.setLayout(frmlytStd);  
//
//		trnrBusinCd07 = new ComboBox<BaseModel>();
//		trnrBusinCd07.setName("trnrBusinCd07");
//		trnrBusinCd07.setForceSelection(true);
//		trnrBusinCd07.setMinChars(1);
//		trnrBusinCd07.setDisplayField("businNm");
//		trnrBusinCd07.setValueField("businCd");
//		trnrBusinCd07.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd07.setEmptyText("--사업선택--");
//		trnrBusinCd07.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//        trnrBusinCd07.setStore(lsTrnrBusinCd);
//		trnrBusinCd07.setFieldLabel("-> 				사 업");
//		lc7.add(trnrBusinCd07, new FormData("100%")); 
//		
//		lc.add(lc7);
//		
//		LayoutContainer lc8 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(70);
//		lc8.setLayout(frmlytStd);  
//
//		trnrBusinCd08 = new ComboBox<BaseModel>();
//		trnrBusinCd08.setName("trnrBusinCd08");
//		trnrBusinCd08.setForceSelection(true);
//		trnrBusinCd08.setMinChars(1);
//		trnrBusinCd08.setDisplayField("businNm");
//		trnrBusinCd08.setValueField("businCd");
//		trnrBusinCd08.setTriggerAction(TriggerAction.ALL);
//		trnrBusinCd08.setEmptyText("--사업선택--");
//		trnrBusinCd08.setSelectOnFocus(true); 
////		trnrBusinCd03.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
////		trnrBusinCd03.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//		trnrBusinCd08.setStore(lsTrnrBusinCd);
//		trnrBusinCd08.setFieldLabel("-> 				사 업");
//		lc8.add(trnrBusinCd08, new FormData("100%")); 
//		
//		lc.add(lc8);
//		
//		
//		lcStdGrid.add(lc);
//
////		lcStdGrid.add(cpGridBassP0500);
//
//		return lcStdGrid;
//		
//	}
	
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
	
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 시작
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
	
	
	public void checekValue(String val1, String val2) {
		
	    if(MSFSharedUtils.paramNull(val1)){
			MessageBox.info("", "이전 사업을 선택해 주세요.", null);
			return;
		}else if(MSFSharedUtils.paramNull(val2)){
			MessageBox.info("", "생성 사업을 선택해 주세요.", null);
			return;
		}	
	}

	public void trnrBass0500(final Payr0490DTO payr0490Dto) {
		
		
		
        MessageBox.confirm("이전데이터이관", "선택하신 사업에 대한 이전년도 지급항목 데이터를 해당 년도에 생성합니다. 이관하시겠습니까?<BR>(생셩년도에 기존 데이터가 있을 경우 삭제 후 재생성 합니다.)",new Listener<MessageBoxEvent>(){
            @Override
            public void handleEvent(MessageBoxEvent be) {
               // if("Yes".equals(be.getButtonClicked().getText())){
            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                	
            		payrP530001Service.trnrPayr0490(payr0490Dto ,new AsyncCallback<Integer>()  {

            			@Override
            			public void onFailure(Throwable caught) {
            				// TODO Auto-generated method stub
            				
            				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
            						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("trnrPayr0490(" + "지급항목 생성이 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
            			}

            			@Override
            			public void onSuccess(Integer result) {
            				
            				if(result == 1) {
            					// TODO Auto-generated method stub
                				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "지급항목 생성이 완료되었습니다. 상세정보에서 금액, 시작일자, 종료일자, 지급월을 수정해 주세요.", null);
            				}else {
            					// TODO Auto-generated method stub
                				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "생성이 실패되었습니다. 관리자에게 문의해 주세요.", null);
            				}
            			}
                    });
            		
                }else {
                	
                }
            }
        });

	}
	 
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSuccessSave() {
		// TODO Auto-generated method stub

	}
}
