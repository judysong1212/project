/**
 * 이전사업이관
 */
package com.app.exterms.resm.client.form;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.resm.client.dto.Bass0500DTO;
import com.app.exterms.resm.client.form.defs.Bass0500Def;
import com.app.exterms.resm.client.service.Resm3200Service;
import com.app.exterms.resm.client.service.Resm3200ServiceAsync;
import com.app.exterms.resm.client.service.ResmP320001Service;
import com.app.exterms.resm.client.service.ResmP320001ServiceAsync;
import com.app.exterms.resm.client.utils.ResmUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
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
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
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
public  class ResmP320001   extends MSFFormPanel {  

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
 
	private  ContentPanel cpBass05001; 
	  
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

		  
	// -------------- grid 선언 시작  ---------------	  
	private MSFGridPanel bassP05001_01GridPanel;
	private MSFGridPanel bassP05001_02GridPanel;
	
	
//	private Bass0500Def bass0500Def  = new Bass0500Def();
	private Bass0500Def bass050001Def  = new Bass0500Def("BASS0500_BEF");	
	private Bass0500Def bass050002Def  = new Bass0500Def("BASS0500_CRE");
	// -------------- grid 선언 종료  ---------------	


		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
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
       
  	private  ButtonBar topBassBtnBar = new ButtonBar();
	private  Button btnBassInit = new Button();	// 초기화
	private  Button btnBassSave = new Button();	// 저장
	private  Button btnBassSrh = new Button();	// 조회

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
	private ComboBox<BaseModel> brfDeptCd; 	// 직전부서
 	private ComboBox<BaseModel> bfrYr; 		// 직전년도
 	
	private ComboBox<BaseModel> creDeptCd; 	// 생성부서
 	private ComboBox<BaseModel> cretnYr; 	// 생성년도
 	
	private DateField businStDt; 			// 사업 시작일자
	private DateField businEdDt; 			// 사업 종료일자
 		
	private HiddenField<String>	dpobCd;		/**  column 사업장코드 : dpobCd */
 	// -------------- 검색 조건 종료 --------------
    
    
	// -------------- 서비스 호출 시작 --------------
	private Resm3200ServiceAsync bass0500Service = Resm3200Service.Util.getInstance();
	private ResmP320001ServiceAsync bassP05001Service = ResmP320001Service.Util.getInstance();
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
	 	private ListStore<BaseModel> listStoreSrhYr    = new ListStore<BaseModel>();		// 년도
	 	private ListStore<BaseModel> listStoredeptCd = new ListStore<BaseModel>();		// 부서
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
		 private void checkResmP320001Auth( String authAction, ListStore<BaseModel>bm) {
			 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
				   
				  if (!maskTracker) { unmask(); }  
				  authExecEnabled();
					
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//					 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 //----------------------------------------------------
//				 Field<?>[] fldArrField = {deptCd};
//				 gwtAuthorization.formAuthFieldConfig(fldArrField);
//				 
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
//				 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				  brfDeptCd.getListView().fireEvent(Events.CheckChanged);
			 }
		 }
		 
		 private void authExecEnabled() { 
			 
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작
				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
				 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 //----------------------------------------------------
			 Field<?>[] fldArrField = {brfDeptCd};
			 gwtAuthorization.formAuthFieldConfig(fldArrField);
			 
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
			 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 
             String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());	
             int yyyy = Integer.parseInt(fmt.toString()) - 1;                    
             bfrYr.setValue(businYrStore.findModel("businApptnYr", String.valueOf(yyyy)));

             cretnYr.setValue(listStoreSrhYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
		 }

		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker)
				// {
				cancel();
				unmask();
				maskTracker = true;
				// }
			}
		};
		     
		private void initLoad() {
		
			 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
			 gwtAuthorization = GWTAuthorization.getInstance();
			 gwtExtAuth = GWTExtAuth.getInstance();
			
			
			 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
//				 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
//				 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
			 authMapDef.put("deptCd",Boolean.FALSE);
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
	  
	public ResmP320001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
		// 콤보 권한초기화
		initLoad();
		
		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		this.setAutoHeight(true);
		
//		this.caller = caller;

		cpBass05001 = new ContentPanel();

		createSearchForm(); // 기본정보 필드를 적용
//		createMsfGridForm(); // 그리드필드
		   
	           
		cpBass05001.setBodyBorder(false);
		cpBass05001.setBorders(false);
		cpBass05001.setHeaderVisible(false);
		cpBass05001.setSize("790px", "640px");

		this.add(cpBass05001);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "730px");
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
		cpBass05001.add(dpobCd);

		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//		sysComBass0300Dto.setRpsttvCd("Y002");
//		lsSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
//		     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		//--------------------년도 불러 오는 함수 ------------------------------------------------
		listStoreSrhYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		// 년도
		//--------------------부서 불러 오는 함수 ------------------------------------------------  
		
		
		bass0500Service.getBass0400List(new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				listStoredeptCd.add(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "부서코드 에러!", null);
			}
		});
		
		/**  생성된 부서의 년도를 가져 온다. **/
		bass0500Service.getBass0500BusinYrList(new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				businYrStore.add(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "사업 년도 에러!", null);
			}
		});
		
		     
		     // sysComBass0400Dto.setDeptDspyYn("Y");
//		     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
//		     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		     
//		     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//		     
//		     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//		    	 public void handleEvent(StoreEvent<BaseModel> be) {  
//		    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
//		    		 deptCd.getStore().add(mDtalistDeptCd);
//		    	 }
//		     });     
		       

		cpBass05001.setLayout(new FlowLayout());

		topBassBtnBar = new ButtonBar();
		topBassBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnBassInit = new Button("초기화");
		btnBassInit.setIcon(MSFMainApp.ICONS.new16());
		btnBassInit.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				
				brfDeptCd.setValue(new BaseModel());
				creDeptCd.setValue(new BaseModel());
				
				String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());	
				int yyyy = Integer.parseInt(fmt.toString()) - 1;    
				
				
            	bfrYr.setValue(businYrStore.findModel("businApptnYr", String.valueOf(yyyy)));
            	cretnYr.setValue(listStoreSrhYr.findModel("year", String.valueOf(yyyy)));
				
				
				businStDt.reset(); 			
				businEdDt.reset(); 		
				
				bassP05001_01GridPanel.getMsfGrid().clearData();
				bassP05001_02GridPanel.getMsfGrid().clearData();
				
				actionDatabase = ActionDatabase.INSERT;
			}
		});
		topBassBtnBar.add(btnBassInit);

		
		btnBassSrh = new Button("조회");
		btnBassSrh.setIcon(MSFMainApp.ICONS.save16());
		btnBassSrh.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"))) {
					MessageBox.alert( "경고",  "직전년도를 선택해 주세요.", null);
					return;					
				}
				reload01();
				reload02();
			}
		});

		topBassBtnBar.add(btnBassSrh);
		cpBass05001.add(topBassBtnBar);
		
		
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
		
		brfDeptCd = new ComboBox<BaseModel>();
		brfDeptCd.setName("brfDeptCd");
		brfDeptCd.setFieldLabel("직전부서");
		brfDeptCd.setForceSelection(true);
		brfDeptCd.setMinChars(1);
		brfDeptCd.setDisplayField("commCdNm");
		brfDeptCd.setValueField("commCd");
		brfDeptCd.setTriggerAction(TriggerAction.ALL);
		brfDeptCd.setEmptyText("--부서선택--");
		brfDeptCd.setSelectOnFocus(true);
//		deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		brfDeptCd.setStore(listStoredeptCd);
		brfDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		brfDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		       public void handleEvent(StoreEvent<BaseModel> be) {  
	    		  EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    		    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   		checkResmP320001Auth("deptCd", listStoredeptCd); 
		    	   }   
		    	   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
		         
		       }
		   });   
		lcSchCol1_1.add(brfDeptCd, new FormData("100%"));
		
		
		
		LayoutContainer lcSchCol1_2 = new LayoutContainer();
		
		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(80);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_2.setLayout(fl1_2);
		
		bfrYr = new ComboBox<BaseModel>();
		bfrYr.setFieldLabel("직전년도");
		bfrYr.setName("bfrYr");
		bfrYr.setForceSelection(true);
		bfrYr.setMinChars(1);
		bfrYr.setDisplayField("businApptnYr");
		bfrYr.setValueField("businApptnYr");
		bfrYr.setTriggerAction(TriggerAction.ALL);
		bfrYr.setEmptyText("--년도선택--");
		bfrYr.setSelectOnFocus(true);
		bfrYr.setStore(businYrStore);
//		bfrYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
////				YetaUtils.setSelectedComboValue(srhSettGbcd, settGbcd.getValue(), "commCd");
//				bfrYr.setValue(businYrStore.getAt(0));
//			}
//		});
//		bfrYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//			public void handleEvent(StoreEvent<BaseModel> be) {
//
//				EventType type = be.getType();
//				if (type == Store.Add) { 
//                    String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());	
//                    int yyyy = Integer.parseInt(fmt.toString()) - 1;                    
//                    bfrYr.setValue(listStoreSrhYr.findModel("year", String.valueOf(yyyy)));
//				} 
//			}
//		});    
		
		lcSchCol1_2.add(bfrYr, new FormData("100%"));
		
		
		
		lcSchCol1.add(lcSchCol1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.4));	// 부서
		lcSchCol1.add(lcSchCol1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));	// 이전년도
		
		
		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());
		
		
		LayoutContainer lcSchCol2_1 = new LayoutContainer();
		
		FormLayout fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(80);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol2_1.setLayout(fl2_1);
		
		creDeptCd = new ComboBox<BaseModel>();
		creDeptCd.setName("creDeptCd");
		creDeptCd.setFieldLabel("생성부서");
		creDeptCd.setForceSelection(true);
		creDeptCd.setMinChars(1);
		creDeptCd.setDisplayField("commCdNm");
		creDeptCd.setValueField("commCd");
		creDeptCd.setTriggerAction(TriggerAction.ALL);
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.setSelectOnFocus(true);
//		deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		creDeptCd.setStore(listStoredeptCd);
		creDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		creDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		       public void handleEvent(StoreEvent<BaseModel> be) {  
	    		  EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    		    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   		checkResmP320001Auth("deptCd", listStoredeptCd); 
		    	   }   
		    	   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
		         
		       }
		   });   
		lcSchCol2_1.add(creDeptCd, new FormData("100%"));
		
		
		
		LayoutContainer lcSchCol2_2 = new LayoutContainer();
		
		FormLayout fl2_2 = new FormLayout();
		fl2_2.setLabelWidth(80);
		fl2_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol2_2.setLayout(fl2_2);
		
		cretnYr = new ComboBox<BaseModel>();
		cretnYr.setFieldLabel("생성년도");
		cretnYr.setName("cretnYr");
		cretnYr.setForceSelection(true);
		cretnYr.setMinChars(1);
		cretnYr.setDisplayField("yearDisp");
		cretnYr.setValueField("year");
		cretnYr.setTriggerAction(TriggerAction.ALL);
		cretnYr.setEmptyText("--년도선택--");
		cretnYr.setSelectOnFocus(true);
		cretnYr.setStore(listStoreSrhYr);
//		bfrYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
////				YetaUtils.setSelectedComboValue(srhSettGbcd, settGbcd.getValue(), "commCd");
//				bfrYr.setValue(businYrStore.getAt(0));
//			}
//		});
//		bfrYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//			public void handleEvent(StoreEvent<BaseModel> be) {
//
//				EventType type = be.getType();
//				if (type == Store.Add) { 
//                    String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());	
//                    int yyyy = Integer.parseInt(fmt.toString()) - 1;                    
//                    bfrYr.setValue(listStoreSrhYr.findModel("year", String.valueOf(yyyy)));
//				} 
//			}
//		});    
		
		lcSchCol2_2.add(cretnYr, new FormData("100%"));
		
		
		lcSchCol2.add(lcSchCol2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.4));	// 부서
		lcSchCol2.add(lcSchCol2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));	// 이전년도
		
		
		
		
		LayoutContainer lcSchCol3 = new LayoutContainer();
		lcSchCol3.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchCol3_1 = new LayoutContainer();
		lcSchCol3_1.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchCol3_1_1 = new LayoutContainer();
		FormLayout fl3_1_1 = new FormLayout();
		fl3_1_1.setLabelWidth(80);
		fl3_1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol3_1_1.setLayout(fl3_1_1);
		
		businStDt = new DateField();
		new DateFieldMask(businStDt, "9999.99.99"); 
		businStDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		businStDt.setFieldLabel("사업기간");
		lcSchCol3_1_1.add(businStDt, new FormData("100%"));
		
		lcSchCol3_1.add(lcSchCol3_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.6));
		
		LayoutContainer lcSchCol3_1_2 = new LayoutContainer();
		FormLayout fl3_1_2 = new FormLayout();
		fl3_1_2.setLabelWidth(10);
		fl3_1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol3_1_2.setLayout(fl3_1_2);
		
		businEdDt = new DateField();
		new DateFieldMask(businEdDt, "9999.99.99"); 
		businEdDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		businEdDt.setLabelSeparator("~");
		lcSchCol3_1_2.add(businEdDt, new FormData("100%"));
		
		lcSchCol3_1.add(lcSchCol3_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.4));
		
		
		LayoutContainer lcSchCol3_2 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnBassSave = new Button("사업이관");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
//				if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(deptCd,"commCd"))) {
//					MessageBox.info("", "부서를 선택해 주세요", null);
//					return;
//				}else 
			    if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"))){
					MessageBox.info("", "이전년도를 선택해 주세요.", null);
					return;
				}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(cretnYr,"year"))){
					MessageBox.info("", "생성년도를 선택해 주세요.", null);
					return;
				}else if(
//						GregorianCalendar.compareDate(businStDt.getValue(), businStDt.getValue()) < 0 || 
						ResmUtils.getConvertDateToString(businStDt, "yyyyMMdd").replace(".", "")==null ||
						"".equals(ResmUtils.getConvertDateToString(businEdDt, "yyyyMMdd").replace(".", ""))) {
				
					MessageBox.alert("경고", "사업 시작 기간이 이상합니다. 확인하십시요.", null);  
					return;
				} else if(
//						GregorianCalendar.compareDate(businEdDt.getValue(), businEdDt.getValue()) < 0 || 
						ResmUtils.getConvertDateToString(businEdDt, "yyyyMMdd").replace(".", "") == null ||
						"".equals(ResmUtils.getConvertDateToString(businEdDt, "yyyyMMdd").replace(".", ""))){
					MessageBox.alert("경고", "사업 종료 기간이 이상합니다. 확인하십시요.", null);  
					return;
				}else if (bassP05001_01GridPanel.getGrid().getSelectionModel().getSelectedItems().size() <= 0) {
		            MessageBox.alert("경고", "이전할 데이터를 선택해 주세요.", null);
		            return;
		        }else if(MSFSharedUtils.getSelectedComboValue(bfrYr, "businApptnYr") == MSFSharedUtils.getSelectedComboValue(cretnYr, "year")
		        			|| MSFSharedUtils.getSelectedComboValue(bfrYr, "businApptnYr").equals(MSFSharedUtils.getSelectedComboValue(cretnYr, "year")) ){
		        	
		        	if(MSFSharedUtils.getSelectedComboValue(brfDeptCd, "commCd") ==  MSFSharedUtils.getSelectedComboValue(creDeptCd, "commCd") ||
		        			MSFSharedUtils.getSelectedComboValue(brfDeptCd, "commCd").equals(MSFSharedUtils.getSelectedComboValue(creDeptCd, "commCd"))	) {
		        		
		        		MessageBox.alert( "경고",  "동일 년도 이관은 다른 부서만 가능합니다.", null);
		        		return;		
		        		
		        	}
		        }
				trnrBass0500();
			}
		});

		btnBar.add(btnBassSave);
		lcSchCol3_2.add(btnBar);
		
		lcSchCol3.add(lcSchCol3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));	// 기간
		lcSchCol3.add(lcSchCol3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));	// 버튼


		
		lcSchCol.add(lcSchCol1, new FormData("100%"));
		lcSchCol.add(lcSchCol2, new FormData("100%"));
		lcSchCol.add(lcSchCol3, new FormData("100%"));
		
		fieldSet.add(lcSchCol, new FormData("100%"));
		
		cpBass05001.add(fieldSet);
		cpBass05001.add(createMsfGridForm(), new FormData("100%"));
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
		layoutContainer2_1.add(bassLeft01(), new FormData("100%"));
		fldstNewFieldset2.add(layoutContainer2_1, new FormData("100%"));
		layoutContainer2_1.setBorders(false);
			
		layoutContainer2.add(fldstNewFieldset2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset2.setHeadingHtml("이전년도");
			
		FieldSet fldstNewFieldset3 = new FieldSet();

		LayoutContainer layoutContainer2_2 = new LayoutContainer();
		layoutContainer2_2.setStyleAttribute("paddingLeft", "10px");

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_2.setLayout(frmlytStd);
		layoutContainer2_2.add(bassRight01(), new FormData("100%"));
		fldstNewFieldset3.add(layoutContainer2_2, new FormData("100%"));
		layoutContainer2_2.setBorders(false);

		layoutContainer2.add(fldstNewFieldset3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset3.setHeadingHtml("생성년도");
		
		lcTabFormLayer.add(layoutContainer2);
		
		LabelField lblfldNewLabelfield = new LabelField(" ※ 이관 후 담당직원 및 사업기간을 수정 해주세요.");
		lcTabFormLayer.add(lblfldNewLabelfield, new FormData("100%"));
		
		lblfldNewLabelfield = new LabelField(" ※  직제개편 시 직전부서(직제개편 전 부서) -> 생성부서(직제개편 후 부서) 선택 후 사업이관");
		lcTabFormLayer.add(lblfldNewLabelfield, new FormData("100%"));
		
		return lcTabFormLayer;
	}	
	
	
	
	private LayoutContainer bassLeft01() {
			  
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		lcStdGrid.setLayout(frmlytStd);  
		    
		ContentPanel cpGridBassP0500 = new ContentPanel();
		cpGridBassP0500.setBodyBorder(false); 
		cpGridBassP0500.setHeaderVisible(false);   
		cpGridBassP0500.setLayout(new FitLayout());      
//	    cpGridBassP0500.setSize(430, 480);   
	     
		     
	    bassP05001_01GridPanel = new MSFGridPanel(bass050001Def, false, false, false, false);
	    bassP05001_01GridPanel.setSize(420, 450);   
//	bassP05001GridPanel.setHeight(400);
	    bassP05001_01GridPanel.setBorders(false);
	    bassP05001_01GridPanel.setBodyBorder(true);
	    bassP05001_01GridPanel.setHeaderVisible(false); 
	    bassP05001_01GridPanel.getBottomComponent().setVisible(false);
	    
	    cpGridBassP0500.add(bassP05001_01GridPanel);

		lcStdGrid.add(cpGridBassP0500);

		return lcStdGrid;
		
	}
	
	
	
	private LayoutContainer bassRight01() {
		  
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		lcStdGrid.setLayout(frmlytStd);  
		    
		ContentPanel cpGridBassP0500 = new ContentPanel();
		cpGridBassP0500.setBodyBorder(false); 
		cpGridBassP0500.setHeaderVisible(false);   
		cpGridBassP0500.setLayout(new FitLayout());      
//	    cpGridBassP0500.setSize(350, 480);   
	     
		     
	    bassP05001_02GridPanel = new MSFGridPanel(bass050002Def, false, false, false, false);
	    bassP05001_02GridPanel.setSize(420, 450); 
//	bassP05001GridPanel.setSize(790, 440);
//	bassP05001GridPanel.setHeight(400);
	    bassP05001_02GridPanel.setBorders(false);
	    bassP05001_02GridPanel.setBodyBorder(true);
	    bassP05001_02GridPanel.setHeaderVisible(false); 
	    bassP05001_02GridPanel.getBottomComponent().setVisible(false);
			   
	    cpGridBassP0500.add(bassP05001_02GridPanel);

		lcStdGrid.add(cpGridBassP0500);

		return lcStdGrid;
		
	}
	
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
	
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
				yetaP03001FormSave();
				break;
			case UPDATE:
				this.actionDatabase = ActionDatabase.UPDATE;
				yetaP03001FormSave();
				break;
			case DELETE:
				this.actionDatabase = ActionDatabase.DELETE;
				yetaP03001FormSave();
				break;
		}
	}
	
	
	private void yetaP03001FormSave() {  
//		if (MSFSharedUtils.paramNotNull(records)) { 
//              
//			List<Yeta3170DTO> listYeta3170dto = new ArrayList<Yeta3170DTO>();  
//                
//			while (records.hasNext()) {
//              
//				Record record = (Record) records.next(); 
//                BaseModel bmMapModel = (BaseModel)record.getModel();
//                      
//                Yeta3170DTO yeta3170Dto= new Yeta3170DTO();  
//
//                yeta3170Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
//                yeta3170Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));  	/** SYSTEMKEY : systemkey */
//                yeta3170Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
//                yeta3170Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    	/** column 정산구분코드 : settGbcd */
//                
//                yeta3170Dto.setCtrbSeqn((Long) bmMapModel.get("ctrbSeqn"));		/** column 기부조정명세일련번호 : ctrbSeqn */
//                yeta3170Dto.setCtrbYrmn(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbYrmn")));		/** column 기부조정명세기부연도 : ctrbYrmn */
//                yeta3170Dto.setCtrbDdcd(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbDdcd$commCd")));    	/** column 기부조정명세유형구분코드 : ctrbDdcd */
//                yeta3170Dto.setCtrbTycd(MSFSharedUtils.allowNulls(bmMapModel.get("ctrbTycd")));    	/** column 기부조정명세유형코드 : ctrbTycd */
//                yeta3170Dto.setCtrbAmnt((Long) bmMapModel.get("ctrbAmnt"));    	/** column 기부조정명세기부금액 : ctrbAmnt */
//                yeta3170Dto.setBfyrDeam((Long) bmMapModel.get("bfyrDeam"));    	/** column 전년도_공제금액 : bfyrDeam */
//                yeta3170Dto.setDetrAmnt((Long) bmMapModel.get("detrAmnt"));    	/** column 공제대상금액 : detrAmnt */
//                yeta3170Dto.setDyyrDeam((Long) bmMapModel.get("dyyrDeam"));    	/** column 해당연도공제금액 : dyyrDeam */
//                yeta3170Dto.setDyyrOtam((Long) bmMapModel.get("dyyrOtam"));    	/** column 해당년도_미공제소멸금액 : dyyrOtam */
//                yeta3170Dto.setAyyrNtam((Long) bmMapModel.get("ayyrNtam"));    	/** column 해당년도_미공제이월금액 : ayyrNtam */
//                
//                
//                listYeta3170dto.add(yeta3170Dto);
//			}  
//                
//			if (listYeta3170dto.size() <= 0) {
//				MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//				return;
//			}
//                
//			yetaP03001Service.activityOnYetaP03001ToYeta3170(listYeta3170dto, actionDatabase, new AsyncCallback<Long>(){
//				public void onFailure(Throwable caught) {
//					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP03001ToYeta3170(" + actionDatabase.name() + ") : " + caught), null);
//				}
//				public void onSuccess(Long result) { 
//					if (result == 0) {
//						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//					} else {
//						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
//						
//						reload();
//						
//						actionDatabase = ActionDatabase.UPDATE;
//					} 
//				} 
//                   
//			}); 
//              
//		} else {
//			MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//			return;
//		}
	} 
	
	public void reload01() {
		
		IColumnFilter filters = null;
		
		bassP05001_01GridPanel.getMsfGrid().clearData();	
		bassP05001_01GridPanel.getTableDef().setTableColumnFilters(filters);
		bassP05001_01GridPanel.getTableDef().addColumnFilter("srhBusinApptnYr", MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(bfrYr,"businApptnYr"))
				, SimpleColumnFilter.OPERATOR_EQUALS);	// 이전년도 
		bassP05001_01GridPanel.getTableDef().addColumnFilter("srhDeptCd", MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(brfDeptCd,"commCd")) 
				, SimpleColumnFilter.OPERATOR_EQUALS);	// 부서
		
		bassP05001_01GridPanel.reload();
			
		// TODO Auto-generated method stub
//		actionDatabase = ActionDatabase.READ;
	}
	
	public void trnrBass0500() {
		
		
		Iterator<BaseModel> itBm = bassP05001_01GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		
		List<Record>  lsRec  = new ArrayList<Record>();
        
		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next()); 
			lsRec.add(rec);
		} 
            
        Iterator<Record> iterRecords = lsRec.iterator() ;  
        List<Bass0500DTO> listBass0500Dto = new ArrayList<Bass0500DTO>(); 
		
        final int cnt = bassP05001_01GridPanel.getGrid().getSelectionModel().getSelectedItems().size();
        
        while (iterRecords.hasNext()) {
		 	       
        	Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
 	               
			Bass0500DTO bass0500Dto = new Bass0500DTO();  
                    
			bass0500Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    										/** column 사업장코드 : dpobCd */
			bass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    										/** column 직전 부서코드 : deptCd */
			bass0500Dto.setCreDeptCd(MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(creDeptCd,"commCd")));		/** column 생성 부서코드 : deptCd */
			
			bass0500Dto.setBusinBfrApptnYr(MSFSharedUtils.allowNulls(bmMapModel.get("businApptnYr"))); 							/** column 사업적용년도 : businApptnYr */ //이전
			bass0500Dto.setBusinCreApptnYr(MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(cretnYr,"year"))); 	/** column 사업적용년도 : businApptnYr */ //생성
			bass0500Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));   		 							/** column 사업코드 : businCd */
			bass0500Dto.setBusinNm(MSFSharedUtils.allowNulls(bmMapModel.get("businNm")));   									/** column 사업명 : businNm */
			
			bass0500Dto.setBusinStdt(MSFSharedUtils.allowNulls(ResmUtils.getConvertDateToString(businStDt, "yyyyMMdd")));    	/** column 사업시작기간 : businStdt */
			bass0500Dto.setBusinEddt(MSFSharedUtils.allowNulls(ResmUtils.getConvertDateToString(businEdDt, "yyyyMMdd")));    	/** column 사업종료기간 : businEddt */
                    
			listBass0500Dto.add(bass0500Dto);
		}  
        bassP05001Service.trnrBusinBass0500(listBass0500Dto ,new AsyncCallback<Integer>()  {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("trnrBusinBass0500(" + "사업이관이 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + cnt + "건중  " + " " + result + " " + "건이 완료되었습니다. 데이터를 확인해 주세요.", null);
				
				reload01();
				reload02();
				
			}
        });
	}
	
	
	public void reload02() {
		
		IColumnFilter filters = null;
		
		
		bassP05001_01GridPanel.getMsfGrid().clearData();	
		bassP05001_02GridPanel.getTableDef().setTableColumnFilters(filters);
		bassP05001_02GridPanel.getTableDef().addColumnFilter("srhBusinApptnYr", MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(cretnYr,"year"))
				, SimpleColumnFilter.OPERATOR_EQUALS);	// 생성년도 
		bassP05001_02GridPanel.getTableDef().addColumnFilter("srhDeptCd", MSFSharedUtils.allowNulls( MSFSharedUtils.getSelectedComboValue(creDeptCd,"commCd")) 
				, SimpleColumnFilter.OPERATOR_EQUALS);	// 부서
		
		bassP05001_02GridPanel.reload();
		
		// TODO Auto-generated method stub
//		actionDatabase = ActionDatabase.READ;
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
