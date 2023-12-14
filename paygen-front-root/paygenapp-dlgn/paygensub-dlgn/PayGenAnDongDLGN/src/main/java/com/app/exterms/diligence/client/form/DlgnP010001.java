/**
 * 월별급여내역
 */
package com.app.exterms.diligence.client.form;
  

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.service.DlgnP010001Service;
import com.app.exterms.diligence.client.service.DlgnP010001ServiceAsync;
import com.app.exterms.dlgn.client.utils.DlgnUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
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
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class DlgnP010001   extends MSFFormPanel {  

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
 
	  private  ContentPanel cpDlgnP010001; 
	  
    
   /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 상태처리 전역변수
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	
  private ActionDatabase actionDatabase;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 화면 렌더링 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
  private MSFPanel caller;
  private Boolean  reading = false;
  public  FormBinding formBinding;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
    //  private  ButtonBar topPayr4200Bar;
     // private  Button btnPayr4200Init;
     // private Button btnPayr4200Save;
     // private  Button btnPayr4200Del;
     // private  Button btnPayr4200Sreach;
    //  private  Button btnPayr4200Print;
     // private  Button btnPayr4200Excel;

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
      
      
  	// ---------- 검색조건 시작 	----------
      private ComboBox<BaseModel> crePayYr;						// 지급년도
      private ComboBox<BaseModel> crePayMonth;					// 지급년월
      private ComboBox<BaseModel> crePayrMangDeptCd;			// 단위기관
      private ComboBox<BaseModel> crePayCd;     				// 급여구분
      private DateField creWorkDayS01;      					// 기본 근태기간 시작일
      private DateField creWorkDayE01;      					// 기본 근태기간 종료일
      private DateField creWorkDayS02;      					// 시간외 근태기간 시작일
      private DateField creWorkDayE02;      					// 시간외 근태기간 종료일
      private ComboBox<BaseModel> creEmymtDivCd; 				// 고용구분 
      private ComboBox<BaseModel> creRepbtyBusinDivCd;	 		// 호봉제구분코드  

      private MSFMultiComboBox<ModelData> creDeptCd ;  			// 부서 
      private ComboBox<BaseModel> creDeptGpCd; 					// 부서직종그룹코드	  
      private MSFMultiComboBox<ModelData> creTypOccuCd;			// 직종  
      private MSFMultiComboBox<ModelData> creDtilOccuInttnCd; 	// 직종세
      private ComboBox<BaseModel> creBusinCd;    				// 사업

     // private Boolean picBoolFile;
       
  	// ---------- 검색조건 종료 	----------
  	
  	
  	// ------  멀티콤보 선언 시작 ------
    //	private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
     // private List<ModelData> mDtalistDtilOccuInttnCd ;
      
    //  private boolean mutilCombo = false;
      
      private List<ModelData> mDtalistcrDeptCd ;
      private List<ModelData> mDtalistcrTypOccuCd ;
      private List<ModelData> mDtalistcrDtilOccuInttnCd ;
      
      private boolean mutilcrCombo = false;
   	// ------  멀티콤보 선언 종료 ------
      
      // ------  DTO 선언 시작 ------
      private PrgmComBass0300DTO sysComBass0300Dto;	//공통코드 dto
      private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
      private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
      private PrgmComBass0150DTO sysComBass0150Dto; 	//단위기관 
      private SysCoCalendarDTO  msfCoCalendarDto;  
      private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
      private PrgmComBass0320DTO sysComBass0320Dto;	//직종
      // ------  DTO 선언 종료 ------

      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

      private HiddenField<String> dpobCd;  //사업장코드
      
      
      
      
      
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

		// formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt,
		// "srhPubcHodyCtnt"));
		// formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum,
		// "degtrResnRegnNum"));

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
	    
	private DlgnP010001ServiceAsync dlgnP010001Service =DlgnP010001Service.Util.getInstance();	
	
	// ------ stroe 선언 시작 ------
	private ListStore<BaseModel> lsPayYrStore 			= new ListStore<BaseModel>(); 	// 년도
	private ListStore<BaseModel> lsPayMonth 			= new ListStore<BaseModel>(); 	// 급여월
	private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>(); 	// 고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	// 호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd 				= new ListStore<BaseModel>(); 	// 부서콤보
	private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>();	// 사업콤보
	private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>(); 	// 단위기관
	private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	// 부서직종그룹코드
	private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>(); 	// 직종
	private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>(); 	// 직종세
	private ListStore<BaseModel> lsPayCd 				= new ListStore<BaseModel>(); 	// 급여구분
	 // ----------------------------------------------------------------------------------
  		
	    
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
	       *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	       * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	       *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	       **/
	       // 검색 폼 바인딩 처리 함수 
	      // private AuthAction authAction;  
	  		//  private Boolean boolChkAuth;  
	  		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	  	/**
	  	 * 권한설정 처리 체크 AuthAction
	  	 */
	  	private void checkDlgnP010001Auth(String authAction, ListStore<BaseModel> bm) {
	  		// MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중");
	  		// 2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
	  		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())&& gwtExtAuth.checkExtAuth(authAction, bm)) {
	  			
	  			 if (!maskTracker) { unmask(); }  
				       		
//	  			 authExecEnabled();
	  			 gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화

	  		}
	  	}

	  	 private void authExecEnabled() { 
	  	  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	        * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
	        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
             Field<?>[] fldArrField = {crePayrMangDeptCd,creEmymtDivCd,creDeptCd,creTypOccuCd,creDtilOccuInttnCd,creBusinCd};
	  	     gwtAuthorization.formAuthFieldConfig(fldArrField);
	  	     
  	 	     crePayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
  	 	   	 crePayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
  	 	   	 
  	 	   	 crePayCd.setValue(lsPayCd.getAt(0));
  	 	   	 
  	 	   	 if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(crePayYr,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(crePayMonth,"month"))) {
  	 	   		 setInitDate();
  	 	   	 }
	  	     
//	  	     
//	  	     srhPayYr_E.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
//	  	     srhPayMonth_E.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
//	  	     
//	  	     srhPayCd.setValue(lsPayCd.getAt(0));
	  	  //   gwtAuthorization.formAuthFieldConfig(srhPayrMangDeptCd,srhEmymtDivCd,strArrDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd);
//	              gwtAuthorization.formAuthPopConfig(plFrmPayr4050, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
//	             gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
	         //GWTAuthorization.formAuthConfig(plFrmPayr4050, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
	       /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        * 권한설정을 위한 콤보처리를 위한 메서드 종료
	        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	         creDeptCd.getListView().fireEvent(Events.CheckChanged); 
	  	 }
	  	 
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker)
				// {
				if (lsEmymtDivCd.getCount() > 0) {
	
					cancel();
					unmask();
					authExecEnabled();
					maskTracker = true;
	
				} else {
					tmMask.scheduleRepeating(2000);
				}
				// }
			}
		};
	  	 
//	  	final Timer tmMask = new Timer() {
//	  		public void run() {
//	  			if (lsEmymtDivCd.getCount() > 0 && lsPayYrStore.getCount() > 0) {
//
//	  				cancel();
//	  				unmask();
//	  				authExecEnabled();
//	  				maskTracker = true;
//
//	  			} else {
//	  				authExecEnabled();
//	  				tmMask.scheduleRepeating(2000);
//	  			}
//	  		}
//	  	};
	  	     
	  	private void initLoad() { 

	  		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
	  		gwtAuthorization = GWTAuthorization.getInstance();
	  		gwtExtAuth = GWTExtAuth.getInstance();
	  		    
	  		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();
	  		
	  		authMapDef.put("crePayYr", Boolean.FALSE);
	  		authMapDef.put("crePayMonth", Boolean.FALSE);
	  		authMapDef.put("crePayCd", Boolean.FALSE);
	  		authMapDef.put("crePayrMangDeptCd", Boolean.FALSE);
	  		authMapDef.put("creEmymtDivCd", Boolean.FALSE);
	  		authMapDef.put("creDeptCd",Boolean.FALSE); 
	  		// authMapDef.put("TypOccuCd",Boolean.FALSE);

	  		gwtExtAuth.setCheckMapDef(authMapDef);

	  		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
	  			// 권한 검색조건처리를 위해 추가된 부분
	  			this.mask("[화면로딩] 초기화 진행 중!");
	  		}
	  		
	  		tmMask.scheduleRepeating(5000);
	  	}
	  	 
	         
	      /**
	       *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	       * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	       *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	       **/		      
 
	  
	public DlgnP010001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
	        //FormLayout layout = new FormLayout();
	        //layout.setDefaultWidth(600);
	       // layout.setLabelWidth(0);  
	       // this.setLayout(layout);   
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;
		
		//콤보 권한초기화
		initLoad(); 
		
		cpDlgnP010001 = new ContentPanel();

		createInfoForm(); // 기본사항을 보여줌

		cpDlgnP010001.setBodyBorder(false);
		cpDlgnP010001.setBorders(false);
		cpDlgnP010001.setHeaderVisible(false);
		cpDlgnP010001.setSize("490px", "250px");

		this.add(cpDlgnP010001);
		formBinding = new FormBinding(this, true);

		this.setSize("520px", "320px");
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
	private void createInfoForm() {
		
		// ------------------ 멀티콤보박스 닫기 ------------------  
		cpDlgnP010001.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) { 
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
		 //급여구분 
		 sysComBass0300Dto.setRpsttvCd("B015");
		 lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 lsPayCd.addStoreListener( new StoreListener<BaseModel>() {   
 	            public void handleEvent(StoreEvent<BaseModel> be) {  
 	            	 EventType type = be.getType();
			    	   if (type == Store.Add) { 
                     
			    	   }
                 }
             });  
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------	
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		 //--------------------급여년도 불러 오는 함수 --------------------------------------------------
		 //월 
		 lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //월 
		 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //-------------------- 직종 코드 불러 오는 함수 --------------------------------------------------
		 lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		     lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                mDtalistTypOccuCd =  DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                creTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                 
			}
		});  
		//-------------------- 직종 코드 불러 오는 함수 --------------------------------------------------
		
		LayoutContainer lc = new LayoutContainer();
		
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_Y = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(70); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc1_Y.setLayout(frmlytSch);
	    
	    crePayYr = new ComboBox<BaseModel>();
	    crePayYr.setName("crePayYr");
	    crePayYr.setForceSelection(true);
	    crePayYr.setMinChars(1);
	    crePayYr.setDisplayField("yearDisp");
	    crePayYr.setValueField("year");
	    crePayYr.setTriggerAction(TriggerAction.ALL);
	   // srhPayYr.setEmptyText("--년도선택--");
	    crePayYr.setSelectOnFocus(true); 
	    crePayYr.setReadOnly(false);
	    crePayYr.setEnabled(true); 
	    crePayYr.setStore(lsPayYrStore);
	    crePayYr.setFieldLabel("작업년월"); 
	    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		      			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkDlgnP010001Auth("crePayYr", lsPayYrStore); 
				}
			}
		});
	    crePayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	        	  BaseModel bmPayYr =  se.getSelectedItem(); 
		           if (bmPayYr != null) {
		        	   if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"))) {
	     					if (creDeptCd.getListView().getChecked().size() > 0) {  
	     						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(crePayYr,"year"));
	     						List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
	     						sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
	     					}       
	                    
	     					//--------------------사업 불러 오는 함수 -------------------------------------------------
	     					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
	     					//--------------------사업 불러 오는 함수 -------------------------------------------------
	     					creBusinCd.setStore(lsBusinCd); 
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
	    lc1_Y.add(crePayYr, new FormData("100%"));
		
		
	    lc1_1.add(lc1_Y, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
		
		LayoutContainer lc1_M = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc1_M.setLayout(frmlytSch);
	    
	    /** column 지급년월 : Mnth */ 
	    crePayMonth = new ComboBox<BaseModel>();
	    crePayMonth.setName("crePayMonth");
	    crePayMonth.setForceSelection(true);
	    crePayMonth.setMinChars(1);
	    crePayMonth.setDisplayField("monthDisp");
	    crePayMonth.setValueField("month");
	    crePayMonth.setTriggerAction(TriggerAction.ALL);
	   // srhPayMonth.setEmptyText("--월선택--");
	    crePayMonth.setSelectOnFocus(true); 
	    crePayMonth.setReadOnly(false);
	    crePayMonth.setEnabled(true); 
	    crePayMonth.setStore(lsPayMonth);
	    crePayMonth.setHideLabel(true);  
	    lsPayMonth.addStoreListener( new StoreListener<BaseModel>() {   
	    	public void handleEvent(StoreEvent<BaseModel> be) {  
	    		EventType type = be.getType();
	    		if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkDlgnP010001Auth("crePayMonth", lsPayMonth); 
	    		}
            }
        });    
	    crePayMonth.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
     		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
     			//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
     			BaseModel bmMonth =  se.getSelectedItem(); 
     			if (bmMonth != null) { 
     				if (MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(crePayYr,"year")) && MSFSharedUtils.paramNotNull(MSFSharedUtils.getSelectedComboValue(crePayMonth,"month"))) {
     					setInitDate();
     				}
     			}       
     		} 
     	});   
	    lc1_M.add(crePayMonth, new FormData("100%"));
	    lc1_1.add(lc1_M, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    lc1.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		
		LayoutContainer lc2 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lc2_1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc2_1_1 = new LayoutContainer();
     	FormLayout fl2_1 = new FormLayout();
     	fl2_1.setLabelWidth(70);
     	fl2_1.setLabelAlign(LabelAlign.RIGHT);
     	lc2_1_1.setLayout(fl2_1);
         
     	creWorkDayS01 = new DateField();
     	creWorkDayS01.setName("creWorkDayS01");
     	new DateFieldMask(creWorkDayS01, "9999.99.99"); 
     	creWorkDayS01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
     	creWorkDayS01.setFieldLabel("복무기간");
         
     	lc2_1_1.add(creWorkDayS01, new FormData("100%"));
              
     	LayoutContainer lc2_1_2 = new LayoutContainer();
     	FormLayout fl2_2 = new FormLayout();
    	fl2_2.setLabelWidth(7);
      	fl2_2.setLabelAlign(LabelAlign.RIGHT);
      	lc2_1_2.setLayout(fl2_2);
              
      	creWorkDayE01 = new DateField();
      	creWorkDayE01.setName("creWorkDayE01");
     	new DateFieldMask(creWorkDayE01, "9999.99.99"); 
     	creWorkDayE01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
    	creWorkDayE01.setLabelSeparator("~");
     	lc2_1_2.add(creWorkDayE01, new FormData("100%"));
              
      	lc2_1.add(lc2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.61));
      	lc2_1.add(lc2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
		
		lc2.add(lc2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		
		LayoutContainer lc2_2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc2_2_1 = new LayoutContainer();
        fl2_1 = new FormLayout();
     	fl2_1.setLabelWidth(70);
     	fl2_1.setLabelAlign(LabelAlign.RIGHT);
     	lc2_2_1.setLayout(fl2_1);
         
     	creWorkDayS02 = new DateField();
     	creWorkDayS02.setName("creWorkDayS02");
     	new DateFieldMask(creWorkDayS02, "9999.99.99"); 
     	creWorkDayS02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
     	creWorkDayS02.setFieldLabel("시간외기간");
         
     	lc2_2_1.add(creWorkDayS02, new FormData("100%"));
              
     	LayoutContainer lc2_2_2 = new LayoutContainer();
     	fl2_2 = new FormLayout();
    	fl2_2.setLabelWidth(7);
      	fl2_2.setLabelAlign(LabelAlign.RIGHT);
      	lc2_2_2.setLayout(fl2_2);
              
      	creWorkDayE02 = new DateField();
      	creWorkDayE02.setName("creWorkDayE02");
     	new DateFieldMask(creWorkDayE02, "9999.99.99"); 
     	creWorkDayE02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
     	creWorkDayE02.setLabelSeparator("~");
    	lc2_2_2.add(creWorkDayE02, new FormData("100%"));
              
      	lc2_1.add(lc2_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.61));
      	lc2_1.add(lc2_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
		
		
		lc2.add(lc2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		
		LayoutContainer lc3 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(70); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc3.setLayout(frmlytSch);
	    
		crePayrMangDeptCd = new ComboBox<BaseModel>();
		crePayrMangDeptCd.setName("crePayrMangDeptCd");
		crePayrMangDeptCd.setForceSelection(true);
		crePayrMangDeptCd.setMinChars(1);
		crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
		crePayrMangDeptCd.setValueField("payrMangDeptCd");
		crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		crePayrMangDeptCd.setEmptyText("--단위기관선택--");
		crePayrMangDeptCd.setSelectOnFocus(true);
		crePayrMangDeptCd.setReadOnly(false);
		crePayrMangDeptCd.setEnabled(true);
		crePayrMangDeptCd.setStore(lsPayrMangDeptCd);
		crePayrMangDeptCd.setFieldLabel("단위기관");
		lsPayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgnP010001Auth("crePayrMangDeptCd", lsPayrMangDeptCd);
				}
			}
		});
		crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
				creDeptCd.reset();
				sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
				// --------------------부서 불러 오는 함수------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
				// --------------------부서 불러 오는 함수------------------------------------------------
							
				lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistcrDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd);
						creDeptCd.getInitStore().add(mDtalistcrDeptCd);
					}
				});
			}
		});
		lc3.add(crePayrMangDeptCd, new FormData("60%"));
		
		LayoutContainer lc4 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(70); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc4.setLayout(frmlytSch);
	    
		crePayCd = new ComboBox<BaseModel>();
		crePayCd.setName("crePayCd");
		crePayCd.setFieldLabel("급여구분");
		crePayCd.setForceSelection(true);
		crePayCd.setMinChars(1);
		crePayCd.setDisplayField("commCdNm");
		crePayCd.setValueField("commCd");
		crePayCd.setTriggerAction(TriggerAction.ALL);
		crePayCd.setEmptyText("--급여구분선택--");
		crePayCd.setSelectOnFocus(true);
		crePayCd.setStore(lsPayCd);
		// crePayCd.setReadOnly(true);
		crePayCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관, 고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgnP010001Auth("crePayCd", lsPayCd);
				}
			}
		});

		lc4.add(crePayCd, new FormData("60%"));
		
		
		LayoutContainer lc5 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc5_1 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(70); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc5_1.setLayout(frmlytSch);
	    
		creEmymtDivCd = new ComboBox<BaseModel>();
		creEmymtDivCd.setFieldLabel("고용구분");
		creEmymtDivCd.setForceSelection(true);
		creEmymtDivCd.setMinChars(1);
		creEmymtDivCd.setDisplayField("commCdNm");
		creEmymtDivCd.setValueField("commCd");
		creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		creEmymtDivCd.setEmptyText("--고용구분선택--");
		creEmymtDivCd.setSelectOnFocus(true);
		creEmymtDivCd.setStore(lsEmymtDivCd);
		creEmymtDivCd.setName("creEmymtDivCd");
		creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					creDeptCd.getListView().fireEvent(Events.CheckChanged);
					creBusinCd.setEnabled(true);
					creTypOccuCd.reset();
					creTypOccuCd.setEnabled(false);
					creDtilOccuInttnCd.reset();
					creDtilOccuInttnCd.setEnabled(false);
				} else if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
					creBusinCd.reset();
					creBusinCd.setEnabled(false);
					// 20151130 추가 수정
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
		lsEmymtDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관, 고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgnP010001Auth("creEmymtDivCd", lsEmymtDivCd);
				}
			}
		});
		lc5_1.add(creEmymtDivCd, new FormData("100%"));
		lc5.add(lc5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
	    LayoutContainer lc5_2 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lc5_2.setLayout(frmlytSch);
	    
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
	    creRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	    creRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    lc5_2.add(creRepbtyBusinDivCd, new FormData("100%"));
	    lc5_2.setBorders(false);
		lc5.add(lc5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		LayoutContainer lc6 = new LayoutContainer();
		
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(70); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    lc6.setLayout(frmlytSch);
		
		creDeptCd = new MSFMultiComboBox<ModelData>();
		creDeptCd.setName("creDeptCd");
		creDeptCd.setEmptyText("--부서선택--");
		creDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		creDeptCd.getStore().add(mDtalistcrDeptCd);
		creDeptCd.setWidth(100);
		creDeptCd.setFieldLabel("부서");
		creDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				// srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
				EventType type = be.getType();
				if (type == Store.Add) {
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관,  고용구분, 부서, 직종, 사업 순으로 없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					checkDlgnP010001Auth("creDeptCd", lsDeptCd);
				}
			}
		});

		creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if ((creDeptCd.getListView().getChecked().size() == 1)
						&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

					if (creDeptCd.getListView().getChecked().size() > 0) {

						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(crePayYr,"year"));
						List<ModelData> mdListSelect = creDeptCd.getListView().getChecked();
						sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
					}

					// --------------------사업 불러 오는 함수-------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수-------------------------------------------------
					creBusinCd.setStore(lsBusinCd);
					creBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
								// creBusinCd.setValue(lscrBusinCd.getAt(0));
						}
					});

				} else if ((creDeptCd.getListView().getChecked().size() > 0)
								&& (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

					// 2015.11.30 권한 직종가져오기 추가
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
					String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,creDeptCd.getValue(),"deptNmRtchnt", "deptCd");
					sysComBass0320Dto.setDeptCd(strDeptCd);
					lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
					lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
							mDtalistcrTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd);
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
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		lc6.add(creDeptCd, new FormData("60%"));
		
		LayoutContainer lc7 = new LayoutContainer(new ColumnLayout());
		
		
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(70); 
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
        creDeptGpCd.setStore(lsDeptGpCd);
        creDeptGpCd.setFieldLabel("직종"); 
        
        layoutContainer_211.add(creDeptGpCd, new FormData("100%")); 
		
		
		
		
		
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(70);
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcTypOccuCd.setLayout(frmlytSch);

		creTypOccuCd = new MSFMultiComboBox<ModelData>();
		creTypOccuCd.setName("creTypOccuCd");
		creTypOccuCd.setEmptyText("--직종선택--");
		creTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
		creTypOccuCd.setHideLabel(true);
		creTypOccuCd.setWidth(100);
//		creTypOccuCd.setFieldLabel("직종");
		creTypOccuCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				// 2015.11.30 추가
				if (!gwtExtAuth.getEnableTypOccuCd()) {
					ModelData mdSelect = creTypOccuCd.getStore().getAt(0);
					creTypOccuCd.getListView().setChecked(mdSelect,true);
					creTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
				}
				EventType type = be.getType();
				if (type == Store.Add) {
				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
				 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
					// checkDlgn0100Auth("creTypOccuCd", lscrTypOccuCd);
				}
			}
		});

		creTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				// 2015.11.30 추가
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
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});

		// 2015.11.30 추가
		creTypOccuCd.addListener(Events.Add, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent ce) {
				displayCreDtilOccuInttnCd();
			}
		});
		lcTypOccuCd.add(creTypOccuCd, new FormData("100%"));

		LayoutContainer lcDtilOccuInttnCd = new LayoutContainer();
		// lcSchRight.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		// fieldSet.setLayout(layout);
		lcDtilOccuInttnCd.setLayout(frmlytSch);

		/** column 직종세코드 : dtilOccuInttnCd */
		creDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		creDtilOccuInttnCd.setName("creDtilOccuInttnCd");
		creDtilOccuInttnCd.setEmptyText("--직종세선택--");
		creDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		creDtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
		creDtilOccuInttnCd.setWidth(100);
		creDtilOccuInttnCd.setHideLabel(true);
		creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					mutilcrCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilcrCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilcrCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				} else {
					
				}
			}
		});

		lcDtilOccuInttnCd.add(creDtilOccuInttnCd, new FormData("100%"));
		
		
		lc7.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lc7.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lc7.add(lcDtilOccuInttnCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		
		
		LayoutContainer lc8 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lc8.setLayout(frmlytSch);
		
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
		creBusinCd.setStore(lsBusinCd);
		creBusinCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					creBusinCd.setValue(lsBusinCd.findModel("businCd",bmPayCd.get("businCd")));
				}
			}
		});
		lc8.add(creBusinCd, new FormData("60%"));
		
		LayoutContainer lc9 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button btnCreDlgn0100Data = new Button("생성");
		btnCreDlgn0100Data.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				createDlgn0100Data();
			}
		});
		btnBar.add(btnCreDlgn0100Data);
		lc9.add(btnBar);
		
		lc.add(lc1, new FormData("100%"));
		lc.add(lc2, new FormData("100%"));
		lc.add(lc3, new FormData("50%"));
		lc.add(lc4, new FormData("50%"));
		lc.add(lc5, new FormData("50%"));
		lc.add(lc6, new FormData("50%"));
		lc.add(lc7, new FormData("100%"));
		lc.add(lc8, new FormData("50%"));
		lc.add(lc9, new FormData("100%"));
		

		cpDlgnP010001.add(lc);
	}
	 
		   
		   
	public void reload() {
		// TODO Auto-generated method stub
		formInit(); 
		IColumnFilter filters = null;
//		payr0304GridPanel.getTableDef().setTableColumnFilters(filters);
//		 
//		payr0304GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
//		payr0304GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//		payr0304GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			 
//		payr0304GridPanel.reload();
				
		actionDatabase = ActionDatabase.READ;
	}
			
			
	// 폼초기화 검색조건포함
	private void formInit() {

		subformInit();
		actionDatabase = ActionDatabase.READ;

	}
	
	private void  displayCreDtilOccuInttnCd() {
		if ((creTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
			//직종변경에 따른 직종세 값 가져오기
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		           
			List<ModelData> mdDeptCdSelect =  creDeptCd.getListView().getChecked();  
			String strDeptCd = DlgnUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
	    	sysComBass0350Dto.setDeptCd(strDeptCd);
	                  
	    	List<ModelData> mdListSelect =  creTypOccuCd.getListView().getChecked();
		 	String strTypOccuCd = DlgnUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
		            
			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
				lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
		              //  creDtilOccuInttnCd.setStore(lscrDtilOccuInttnCd); 
				lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistcrDtilOccuInttnCd = DlgnUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
						creDtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);
						
						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = creDtilOccuInttnCd.getStore().getAt(0) ;
							creDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							creDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
						} 
					}
				});     
			} 
		} else {
		}   
	}
			   
	private void subformInit() {

	}
   	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {

			}
		});
	}
	
	
	/** 근무실적생성  */
	private void createDlgn0100Data() {
		
		
		final Tracker tracker = new Tracker();
	    	  tracker.setStatus(false);
         
		
		MessageBox.confirm("근태 생성", "복무, 시간외 근무 기간을 동일하게 생성합니다.<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					

					String year = DlgnUtils.getSelectedComboValue(crePayYr,"year");
					String month = DlgnUtils.getSelectedComboValue(crePayMonth,"month");
					String payCd = DlgnUtils.getSelectedComboValue(crePayCd,"commCd");
					String workDayS01 = DlgnUtils.getConvertDateToString(creWorkDayS01, "yyyyMMdd");
					String workDayE01 = DlgnUtils.getConvertDateToString(creWorkDayE01, "yyyyMMdd"); 
					String workDayS02 = DlgnUtils.getConvertDateToString(creWorkDayS02, "yyyyMMdd");
					String workDayE02 = DlgnUtils.getConvertDateToString(creWorkDayE02, "yyyyMMdd"); 
					String emymtDivCd = DlgnUtils.getSelectedComboValue(creEmymtDivCd,"commCd");

					//주휴일수 계산
					Calendar  startCal =   Calendar.getInstance();
					startCal.set ( Integer.parseInt(workDayS01.substring(0,4)), Integer.parseInt(workDayS01.substring(4,6)), Integer.parseInt(workDayS01.substring(6,8)) );
					int startWeek = startCal.get(Calendar.WEEK_OF_YEAR);
					
					Calendar  endCal =   Calendar.getInstance();
					endCal.set ( Integer.parseInt(workDayE01.substring(0,4)), Integer.parseInt(workDayE01.substring(4,6)), Integer.parseInt(workDayE01.substring(6,8)) );
					int endWeek = endCal.get(Calendar.WEEK_OF_YEAR);
						
					int weekDifference = endWeek - startWeek;
					//주휴일수 계산 끝
					
					String deptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					String payrMangDeptCd = DlgnUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd");
					
					String typOccuCd = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
					String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
					String businCd = DlgnUtils.getSelectedComboValue(creBusinCd, "businCd"); 
					
					
					if("".equals(year) || "".equals(month)){
						MessageBox.info("", "작업년월은 필수 입니다.", null);
						return;
					}else if("".equals(workDayS01) || "".equals(workDayS01)){
						MessageBox.info("", "복무기간은 필수 입니다.", null);
						return;
					}else if("".equals(workDayS02) || "".equals(workDayS02)){
						MessageBox.info("", "시간외기간은 필수 입니다.", null);
						return;
					}else if("".equals(payrMangDeptCd) || "".equals(payrMangDeptCd)){
						MessageBox.info("", "단위기관은 필수 입니다.", null);
						return;
					}else if("".equals(payCd)){
						MessageBox.info("", "급여구분은 필수 입니다.", null);
						return;
					}else if("".equals(emymtDivCd) || "".equals(emymtDivCd)){
						MessageBox.info("", "고용구분은 필수 입니다.", null);
						return;
					}else if("".equals(emymtDivCd) || "".equals(deptCd)){
						MessageBox.info("", "부서는 필수 입니다.", null);
						return;
					}else if(GregorianCalendar.compareDate(creWorkDayS01.getValue(), creWorkDayE01.getValue()) < 0){
						MessageBox.info("", "복무기간 설정이 이상합니다. 확인하십시요.", null);  
					} else if(GregorianCalendar.compareDate(creWorkDayS02.getValue(), creWorkDayE02.getValue()) < 0){
						MessageBox.info("", "시간외기간 설정이 이상합니다. 확인하십시요.", null);  
					}else if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {    
						if("".equals(businCd)){
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
	         		     } else {
	         		    	 
	         		    	
	                         Dlgn0100DTO dlgn0100Dto = new Dlgn0100DTO();
	                         
	                         String months = month;
							 
	                         if(month.length() == 1)  {
	                        	 months = "0"+month;
	                         }
	                         
//	                         dto.setSystemkey(srhSystemkey.getValue());			
//	                         dlgn0100Dto.setSystemkey(creSystemkey.getValue());			//시스템키
	                         dlgn0100Dto.setDilnlazYrMnth(year+months);					//지급년월 //jobYrMnth
	                         dlgn0100Dto.setDilnlazDutyBgnnDt(workDayS01);				// 근태기간(시작) //rflctnBgnnDt, workDayS
	                         dlgn0100Dto.setDilnlazDutyEndDt(workDayE01);				// 근태기간(종료) //rflctnEndDt, workDayE
	                         dlgn0100Dto.setPayrMangDeptCd(payrMangDeptCd);				// 단위기관
	                         dlgn0100Dto.setPayCd(payCd);								// 급여구분
	                         dlgn0100Dto.setSystemkey("");								// 시스템키
	                         
	                         dlgn0100Dto.setEmymtDivCd(emymtDivCd);						// 고용구분
	                         dlgn0100Dto.setCurrAffnDeptCd(deptCd);						// 부서
	                         dlgn0100Dto.setTypOccuCd(typOccuCd);						// 직종
	                         dlgn0100Dto.setDtilOccuInttnCd(dtilOccuInttnCd);			// 직종세
	                         dlgn0100Dto.setBusinCd(businCd);							// 사업
	                         dlgn0100Dto.setDeptCd(deptCd);								// 부서
	                         dlgn0100Dto.setDilnlazWklyHldyNumDys(weekDifference+""); 	// 주휴일수
	                         
							 // 무기계약직(A0020010)일 경우 직종세 통합코드, 기간제(A0020020)일 경우 부서 + 사업코드로 넣어줌.
							 if(MSFConfiguration.EMYMT_DIVCD01.equals(dlgn0100Dto.getEmymtDivCd())) {
								 dlgn0100Dto.setTypOccuBusinVal(dlgn0100Dto.getDtilOccuInttnCd());
							 }else if(MSFConfiguration.EMYMT_DIVCD02.equals(dlgn0100Dto.getEmymtDivCd())) {
								 dlgn0100Dto.setTypOccuBusinVal( dlgn0100Dto.getDeptCd() + dlgn0100Dto.getBusinCd());
							 }
	                         
	                         
							 
	                         Dlgn0200DTO dlgn0200Dto = new Dlgn0200DTO();
								
	                         dlgn0200Dto.setDilnlazExceDutyYrMnth(year+months);		// 지급년월 jobYrMnth 
	                         dlgn0200Dto.setDilnlazExceDutyBgnnDt(workDayS02);		// 근태기간(시작) 
	                         dlgn0200Dto.setDilnlazExceDutyEndDt(workDayE02);		// 근태기간(종료)
	                         dlgn0200Dto.setPayCd(payCd);							// 급여구분
	                         dlgn0200Dto.setPayrMangDeptCd(payrMangDeptCd);			// 단위기관
	                         dlgn0200Dto.setEmymtDivCd(emymtDivCd);					// 고용구분
	                         dlgn0200Dto.setDeptCd(deptCd);							// 부서
							 dlgn0200Dto.setTypOccuCd(typOccuCd);					// 직종
							 dlgn0200Dto.setDtilOccuInttnCd(dtilOccuInttnCd);		// 직종세
							 dlgn0200Dto.setBusinCd(businCd);						// 사업
							 dlgn0200Dto.setSystemkey("");							// 시스템키
							 
							 dlgn0200Dto.setTypOccuBusinVal(dlgn0100Dto.getTypOccuBusinVal());
							 
							 
							  final MessageBox box = MessageBox.wait("근무실적", "근무실적 데이타 처리 중 입니다...", "근무실적 생성(삭제) 중...");
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
				                
				                
				                dlgnP010001Service.generateAllWorkTime(dlgn0100Dto, dlgn0200Dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
									@Override
									public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
										
										tracker.setStatus(true);
										  
										ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
		    		    			    
										MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
										msFwMessage.show();
										showMessageForm.setMSFFormWindows(msFwMessage);
									}
									
									@Override
									public void onFailure(Throwable caught) {
										
										tracker.setStatus(true);
										
										ShowMessageBM smForm = new ShowMessageBM();
										smForm.setWindowId("DlgnP010001");
										smForm.setWindowNm("기본근무초과근무생성");
							            GWTUtils.messageExcepDlgEx(caught,smForm);
							            
										//MessageBox.info("", "근태 생성 실패", null);
									}
							});		 				                
				                
							 
//							 dlgnP010001Service.generateAllWorkTime(dlgn0100Dto, dlgn0200Dto, new AsyncCallback<Integer>() {
//									@Override
//									public void onSuccess(Integer result) {
//										
//										tracker.setStatus(true);
//										  
//										MessageBox.info("", "근태가 생성 되었습니다.", null);
//									}
//									
//									@Override
//									public void onFailure(Throwable caught) {
//										
//										tracker.setStatus(true);
//										
//										ShowMessageBM smForm = new ShowMessageBM();
//										smForm.setWindowId("DlgnP010001");
//										smForm.setWindowNm("기본근무초과근무생성");
//							            GWTUtils.messageExcepDlgEx(caught,smForm);
//							            
//										//MessageBox.info("", "근태 생성 실패", null);
//									}
//								});
	         		     }
	               }else{
	            	   
	            	 
                       Dlgn0100DTO dlgn0100Dto = new Dlgn0100DTO();
                       
                       String months = month;
						 
                       if(month.length() == 1)  {
                      	 months = "0"+month;
                       }
                       
//                       dto.setSystemkey(srhSystemkey.getValue());			
//                       dlgn0100Dto.setSystemkey(creSystemkey.getValue());			//시스템키
                       dlgn0100Dto.setDilnlazYrMnth(year+months);						//지급년월 //jobYrMnth
                       dlgn0100Dto.setDilnlazDutyBgnnDt(workDayS01);					// 근태기간(시작) //rflctnBgnnDt, workDayS
                       dlgn0100Dto.setDilnlazDutyEndDt(workDayE01);						// 근태기간(종료) //rflctnEndDt, workDayE
                       dlgn0100Dto.setPayrMangDeptCd(payrMangDeptCd);				// 단위기관
                       dlgn0100Dto.setPayCd(payCd);											// 급여구분
                       
                       dlgn0100Dto.setEmymtDivCd(emymtDivCd);							// 고용구분
                       dlgn0100Dto.setCurrAffnDeptCd(deptCd);								// 부서
                       dlgn0100Dto.setTypOccuCd(typOccuCd);								// 직종
                       dlgn0100Dto.setDtilOccuInttnCd(dtilOccuInttnCd);					// 직종세
                       dlgn0100Dto.setBusinCd(businCd);										// 사업
                       dlgn0100Dto.setDeptCd(deptCd);										// 부서
                       dlgn0100Dto.setDilnlazWklyHldyNumDys(weekDifference+""); 		// 주휴일수
                       dlgn0100Dto.setSystemkey("");											// 시스템키
						 
                       Dlgn0200DTO dlgn0200Dto = new Dlgn0200DTO();
							
                       dlgn0200Dto.setDilnlazExceDutyYrMnth(year+months);				// 지급년월 jobYrMnth 
                       dlgn0200Dto.setDilnlazExceDutyBgnnDt(workDayS02);				// 근태기간(시작) 
                       dlgn0200Dto.setDilnlazExceDutyEndDt(workDayE02);					// 근태기간(종료)
                       dlgn0200Dto.setPayCd(payCd);											// 급여구분
                       dlgn0200Dto.setPayrMangDeptCd(payrMangDeptCd);				// 단위기관
                       dlgn0200Dto.setEmymtDivCd(emymtDivCd);							// 고용구분
                       dlgn0200Dto.setCurrAffnDeptCd(deptCd);								// 부서
                       dlgn0200Dto.setDeptCd(deptCd);										// 부서
                       dlgn0200Dto.setTypOccuCd(typOccuCd);								// 직종
                       dlgn0200Dto.setDtilOccuInttnCd(dtilOccuInttnCd);					// 직종세
					   dlgn0200Dto.setBusinCd(businCd);										// 사업
					   dlgn0200Dto.setSystemkey("");											// 시스템키
						 
					   final MessageBox box = MessageBox.wait("근무실적", "근무실적 데이타 처리 중 입니다...", "근무실적 생성(삭제) 중...");
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
		                
		                dlgnP010001Service.generateAllWorkTime(dlgn0100Dto, dlgn0200Dto, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
							@Override
							public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
								
								tracker.setStatus(true);
								  
								ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
    		    			    
								MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
								msFwMessage.show();
								showMessageForm.setMSFFormWindows(msFwMessage);
							}
							
							@Override
							public void onFailure(Throwable caught) {
								
								tracker.setStatus(true);
								
								ShowMessageBM smForm = new ShowMessageBM();
								smForm.setWindowId("DlgnP010001");
								smForm.setWindowNm("기본근무초과근무생성");
					            GWTUtils.messageExcepDlgEx(caught,smForm);
					            
								//MessageBox.info("", "근태 생성 실패", null);
							}
						});		 		                
		                
		                
//					   dlgnP010001Service.generateAllWorkTime(dlgn0100Dto, dlgn0200Dto, new AsyncCallback<Integer>() {
//						   @Override
//						   public void onSuccess(Integer result) {
//							   
//							   tracker.setStatus(true);
//							   
//							   MessageBox.info("",	"근태가 생성 되었습니다.", null);
//						   }
//								
//						   @Override
//						   public void onFailure(Throwable caught) {
//							   
//							   tracker.setStatus(true);
//							   
//							    ShowMessageBM smForm = new ShowMessageBM();
//								smForm.setWindowId("DlgnP010001");
//								smForm.setWindowNm("기본근무초과근무생성");
//					            GWTUtils.messageExcepDlgEx(caught,smForm);
//					            
//							  // MessageBox.info("", "근태 생성 실패", null);
//						   }
//					   });
	               }
	           }  
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
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	} 
	
	
	private void setInitDate() {
		   
		int maxDays = 0;
		   
			Calendar  intiCal =  Calendar.getInstance(); 
			intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayYr,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayMonth,"month")) - 1, 1 );
			creWorkDayS01.setValue(intiCal.getTime());
			creWorkDayS02.setValue(intiCal.getTime());
			maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);  
	        
			Calendar  intieCal =   Calendar.getInstance();
			intieCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayYr,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(crePayMonth,"month")) - 1, maxDays );
	      // intiCal.add(Calendar.DATE, maxDays - 1);
	      // GWT.log("일수" + DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
			creWorkDayE01.setValue(intieCal.getTime());
			creWorkDayE02.setValue(intieCal.getTime());
			
	}
	  
	private DlgnP010001 getThis() {
		return this;
	}
}
