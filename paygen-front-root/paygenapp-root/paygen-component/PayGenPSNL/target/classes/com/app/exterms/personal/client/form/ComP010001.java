/**
 * 신규고용일괄등록
 */
package com.app.exterms.personal.client.form;
  

import java.util.HashMap;

import com.app.exterms.basis.client.dto.InfcPkgBass0360DTO;
import com.app.exterms.personal.client.service.ComP010001Service;
import com.app.exterms.personal.client.service.ComP010001ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
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
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class ComP010001   extends MSFFormPanel {  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  private boolean boolKeyCode = true;   //중복팝업에 의해 변경 
	  
	  private boolean typFlag = true;
	  private boolean dtilFlag = true;
	    

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
 
	private  ContentPanel cpComPsnl0100; 
	    
    
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
  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
//		private ButtonBar topPayr4200Bar;
//		// private Button btnPayr4200Init;
//		// private Button btnPayr4200Save;
//		// private Button btnPayr4200Del;
//		private Button btnPayr4200Sreach;
//		// private Button btnPayr4200Print;
//		private Button btnPayr4200Excel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	* 검색변수 선언 
	* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	*/
 		
 		private HiddenField<String> dpobCd;  //사업장코드
		private HiddenField<String> systemkey;
		
		
	    private HiddenField<String> payrMangDeptCd; 	/** column 단위기관코드 : payrMangDeptCd */	      
	    private HiddenField<String> emymtDivCd;   		/** column 고용구분코드 : emymtDivCd */
//		private HiddenField<String> repbtyBusinDivCd; 	// 호봉제구분코드
	    private HiddenField<String> deptCd;  			/** column 부서코드 : deptCd */
	    private HiddenField<String> businCd;   			/** column 사업코드 : businCd */
//		private HiddenField<String> deptGpCd; 			// 부서직종그룹코드
	    private HiddenField<String> typOccuCd;   		/** column 직종코드 : typOccuCd */
	    private HiddenField<String> dtilOccuInttnCd;	/**  column 직종세구분코드 : dtilOccuInttnCd */

		private ComboBox<BaseModel> srhPayrMangDeptCd; 	// 단위기관
//		private TextField<String> srhEmymtDivCd; 		// 고용구분
//		private TextField<String> srhRepbtyBusinDivCd; 	// 호봉제구분코드
		private ComboBox<BaseModel> srhDeptCd; 			// 부서
//		private TextField<String> srhDeptGpCd; 			// 부서직종그룹코드
		private ComboBox<BaseModel> srhTypOccuCd; 		// 직종
		private ComboBox<BaseModel> srhDtilOccuInttnCd; 	// 직종세
//		private TextField<String> srhBusinCd; 			// 사업

      
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
 
		private ComP010001ServiceAsync comPsnlP010001Service = ComP010001Service.Util.getInstance();
	    
	    
	    private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관 
		private ListStore<BaseModel> lsDeptCd  			= new ListStore<BaseModel>();	//부서콤보
//		private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	//고용구분 
		private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	//직종 
		private ListStore<BaseModel> lsDtilOccuInttnCd  = new ListStore<BaseModel>();	//직종세
	    
  		
		// -------------- DTO 선언 시작 --------------
		private PrgmComBass0150DTO sysComBass0150Dto;	//단위기관
		private PrgmComBass0300DTO sysComBass0300Dto; 	//공통코드 
		private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
		private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
		private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
		private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	    private InfcPkgBass0360DTO infcBass0360Dto;;
		// -------------- DTO 선언 끝 ---------------

		/**
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 **/
	      /**
	       * 권한설정 처리 체크 
	       * AuthAction 
	       */
	      private void checkComPsnl0100Auth( String authAction, ListStore<BaseModel> bm) {   
	    	  //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
				 
	    	  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
	    	  if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
	    		  //----------------------------------------------------
	    		  if (!maskTracker) { unmask(); }  
			           
	    		  Field<?>[] fldArrField = {srhPayrMangDeptCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd};
	                    
	    		  gwtAuthorization.formAuthFieldConfig(fldArrField);      			   
	    		  gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
	     			  
	          
	              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                // String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
			                // GWTAuthorization.formAuthPopConfig(plFrmDlgn0250, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
			                // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
					    //  gwtAuthorization.formAuthConfig(plFrmDlgn0250, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
	              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	               * 권한설정을 위한 콤보처리를 위한 메서드 종료
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			             //    srhDeptCd.fireEvent(Events.Add);
//	              	srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
			                
	              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                     // String[] strArrDeptCd = { "creCurrDeptCd","creCurrDeptNm"};
			                     // GWTAuthorization.formAuthPopConfig(plFrmDlgn0250, "crePayrMangDeptCd","creEmymtDivCd",strArrDeptCd,"creTypOccuCd","creBusinCd");
			                     // GWTAuthorization.formAuthBtnConfig(btnCreCurrDeptCd); 
			             //  gwtAuthorization.formAuthConfig(plFrmDlgn0250,  "crePayrMangDeptCd","creEmymtDivCd","creDeptCd","creTypOccuCd","creDtilOccuInttnCd","creBusinCd" );
			                    
	              	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	              	 * 권한설정을 위한 콤보처리를 위한 메서드 종료
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//	              	srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
		                //MSFMainApp.unmaskMainPage();
	    	  }
	      }
			  
	      final Timer tmMask = new Timer(){
	    	  public void run() {
	    		  // if (maskTracker) { 
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
	    	  
	    	  authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
	    	  authMapDef.put("srhDeptCd",Boolean.FALSE); 
	    	  //  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
				      
	    	  //  authMapDef.put("creTypOccuCd",Boolean.FALSE);  
					 
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
	public ComP010001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
		// 콤보 권한초기화
		initLoad();
					
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

		cpComPsnl0100 = new ContentPanel();

		createSearchForm(); 	// 검색필드를 적용
//		createInfoForm(); 		// 파일 업로드부 적용
		// createPayrP410001Form(); //화면 기본정보를 설정

		cpComPsnl0100.setBodyBorder(false);
		cpComPsnl0100.setBorders(false);
		cpComPsnl0100.setHeaderVisible(false);
		cpComPsnl0100.setSize("680px", "100px");

		this.add(cpComPsnl0100);
		formBinding = new FormBinding(this, true);

		this.setSize("700px", "120px");
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
	private void createPayrP410001Form() {

	}
	  
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {

		sysComBass0300Dto = new PrgmComBass0300DTO();

		sysComBass0150Dto = new PrgmComBass0150DTO(); // 단위기관
		sysComBass0300Dto = new PrgmComBass0300DTO(); // 공통코드
		sysComBass0350Dto = new PrgmComBass0350DTO(); // 직종세
		sysComBass0400Dto = new PrgmComBass0400DTO(); // 부서코드
		sysComBass0500Dto = new PrgmComBass0500DTO(); // 사업코드
		sysComBass0320Dto = new PrgmComBass0320DTO(); // 직종

		systemkey = new HiddenField<String>();		/** column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpComPsnl0100.add(systemkey);

		dpobCd = new HiddenField<String>();
		dpobCd.setName("dpobCd");
		cpComPsnl0100.add(dpobCd);
		
		
//		payYr = new HiddenField<String>();	
//		payYr.setName("payYr");
//		cpComPsnl0100.add(payYr);
//		
//		payMonth = new HiddenField<String>();	
//		payMonth.setName("payMonth");
//		cpComPsnl0100.add(payMonth);
//		
//		payCd = new HiddenField<String>();	
//		payCd.setName("payCd");
//		cpComPsnl0100.add(payCd);
//		
		payrMangDeptCd = new HiddenField<String>();
		payrMangDeptCd.setName("payrMangDeptCd");
		cpComPsnl0100.add(payrMangDeptCd);
//		
//		emymtDivCd = new HiddenField<String>();	
//		emymtDivCd.setName("emymtDivCd");
//		cpComPsnl0100.add(emymtDivCd);
//		
		deptCd = new HiddenField<String>();	
		deptCd.setName("deptCd");
		cpComPsnl0100.add(deptCd);
		
		typOccuCd = new HiddenField<String>();	
		typOccuCd.setName("typOccuCd");
		cpComPsnl0100.add(typOccuCd);
		
		dtilOccuInttnCd = new HiddenField<String>();	
		dtilOccuInttnCd.setName("dtilOccuInttnCd");
		cpComPsnl0100.add(dtilOccuInttnCd);
//		
//		businCd = new HiddenField<String>();	
//		businCd.setName("businCd");
//		cpComPsnl0100.add(businCd);
		
		
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		
		
		//--------------------부서 불러 오는 함수 ------------------------------------------------  
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		
		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		
		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
//                mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//                srhDeptCd.getInitStore().add(mDtalistDeptCd);
            }
		});     
		//--------------------부서 불러 오는 함수 ------------------------------------------------
		 
		//---------------------직종 콤보 처리----------------------------------------------------
		// 권한 없이 직종 가져옴
		lsTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto); 
		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
//				  mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
//				  srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		});  
		//---------------------직종 콤보 처리----------------------------------------------------
		  

		cpComPsnl0100.setLayout(new FlowLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");
		
		
		LayoutContainer lc = new LayoutContainer();
		
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcCol1_1 = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcCol1_1.setLayout(frmlytSch);
		
		srhDeptCd = new ComboBox<BaseModel>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setForceSelection(true);
		srhDeptCd.setMinChars(1);
		srhDeptCd.setDisplayField("deptNmRtchnt");
		srhDeptCd.setValueField("deptCd");
		srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.setSelectOnFocus(true);
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.setStore(lsDeptCd);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
             
            	sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
         		   
            	String strDeptCd = MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd");  
            	sysComBass0320Dto.setDeptCd(strDeptCd);
         		   
            	lsTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto); 
            	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
            		public void handleEvent(StoreEvent<BaseModel> be) {  
//         		   			mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
//         		   			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
            		}
            	});  
			} 
		});		
		
		srhDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서
					 * : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkComPsnl0100Auth("srhDeptCd", lsDeptCd);
					
					srhDeptCd.setValue(lsDeptCd.findModel("deptCd",deptCd.getValue()));
				}
			}
		});  
        lcCol1_1.add(srhDeptCd, new FormData("100%"));
		
		
		lc1.add(lcCol1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcCol1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcCol1_2.setLayout(frmlytSch);
		
		srhTypOccuCd = new ComboBox<BaseModel>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setForceSelection(true);
		srhTypOccuCd.setMinChars(1);
		srhTypOccuCd.setDisplayField("typOccuNm");
		srhTypOccuCd.setValueField("typOccuCd");
		srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
		srhTypOccuCd.setEmptyText("--부서선택--");
		srhTypOccuCd.setSelectOnFocus(true);
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhTypOccuCd.setStore(lsTypOccuCd);
		srhTypOccuCd.setFieldLabel("직종");
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				displayDtilOccuInttnCd();
			} 
		});	        
        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent ce) {
            	displayDtilOccuInttnCd();
            } 
        });   
        lcCol1_2.add(srhTypOccuCd, new FormData("100%"));
		lc1.add(lcCol1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer lc2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcCol2_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcCol2_1.setLayout(frmlytSch);
		
		srhDtilOccuInttnCd = new ComboBox<BaseModel>();
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
        srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
        srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
        srhDtilOccuInttnCd.setFieldLabel("직종세");
        srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
        srhDtilOccuInttnCd.addListener(Events.Add,new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent ce) { 
            	displayDtilOccuInttnCd();
            } 
        });
        
        lcCol2_1.add(srhDtilOccuInttnCd, new FormData("100%"));
		
		lc2.add(lcCol2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcCol2_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcCol2_2.setLayout(frmlytSch);
		
		srhPayrMangDeptCd = new ComboBox<BaseModel>();
		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		srhPayrMangDeptCd.setForceSelection(true);
		srhPayrMangDeptCd.setMinChars(1);
		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
		srhPayrMangDeptCd.setSelectOnFocus(true); 
//		srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//		srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
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
					checkComPsnl0100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
					
					srhPayrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd", payrMangDeptCd.getValue()));
				}
	    	}
	    });    
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
  	          	
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		
  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//  	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
  	    			}
  	    		});       
	    	} 
	    });
	    lcCol2_2.add(srhPayrMangDeptCd, new FormData("100%"));
		
		lc2.add(lcCol2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer lc3 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcCol3_1 = new LayoutContainer();
//		lc3.add(lcCol3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcCol3_2 = new LayoutContainer();
		
		ButtonBar barBtn = new ButtonBar();
		barBtn.setAlignment(HorizontalAlignment.RIGHT);
		
        Button btnBass0360Insert = new Button("저 장");
        btnBass0360Insert.setWidth("80");
        btnBass0360Insert.addListener(Events.Select, new Listener<ButtonEvent>() {
        	public void handleEvent(ButtonEvent e) {
                // 저장
        	    infcBass0360Dto = new InfcPkgBass0360DTO();
        	    
				infcBass0360Dto.setDeptCd(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhDeptCd, "deptCd")));
				infcBass0360Dto.setTypOccuCd(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhTypOccuCd, "typOccuCd")));
				infcBass0360Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhDtilOccuInttnCd, "dtilOccuInttnCd")));
				infcBass0360Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd")));
            
				if(infcBass0360Dto.getDeptCd() == null || infcBass0360Dto.getDeptCd() == ""){
					MessageBox.info("", "부서는 필수입니다.", null);
					return;
					
				}else if(infcBass0360Dto.getTypOccuCd() == null || infcBass0360Dto.getTypOccuCd() == ""){
					MessageBox.info("", "직종은 필수입니다.", null);
					return;
				}else if(infcBass0360Dto.getPayrMangDeptCd() == null || infcBass0360Dto.getPayrMangDeptCd() == ""){
					MessageBox.info("", "직종세 필수입니다.", null);
					return;
				}
				
				
				comPsnlP010001Service.insertBass0360List(infcBass0360Dto, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if("Y".equals(result) || "Y" == result) {
							MessageBox.alert("저장", "저장이 성공하였습니다.", null);
						}else if("N".equals(result) || "N" == result) {
							MessageBox.alert("저장", "이미 등록되어 있는 단위기관입니다.", null);
						}else if("X".equals(result) || "X" == result) {
							MessageBox.alert("실패", "저장에 실패하였습니다.", null);
						}
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
						MessageBox.alert("실패", "저장에 실패하였습니다. " + caught, null);
						
					}
				});
        	}
        });
        barBtn.add(btnBass0360Insert);
        lcCol3_2.add(barBtn);
		
		lc3.add(lcCol3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		lc.add(lc1);
		lc.add(lc2);
		lc.add(lc3);
		
		
		fieldSet.add(lc);
		
		cpComPsnl0100.add(fieldSet);
		
	}
	  
			
			
	// 폼초기화 검색조건포함
	private void formInit() {


	}
	
	
			    
   	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
//				Window.alert("단위기관 -> " + payrMangDeptCd.getValue());
//				Window.alert("부서 -> " + deptCd.getValue());
//				Window.alert("직종 -> " + typOccuCd.getValue());
//				Window.alert("직종세 -> " + dtilOccuInttnCd.getValue());
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
	
	
	private void  displayDtilOccuInttnCd() {
		
		
//		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
            
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
			
//			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            
//            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
            	
            	//직종세 초기화
            	srhDtilOccuInttnCd.setValue(new BaseModel());
            	lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto); 
            	
            } 
            
            srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);


//		} else {
//           
//		} 
	}
	
	 

}
