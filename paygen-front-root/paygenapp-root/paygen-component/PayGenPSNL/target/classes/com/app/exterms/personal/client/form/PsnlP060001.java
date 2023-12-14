/**
 * 신규고용일괄등록
 */
package com.app.exterms.personal.client.form;
  

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.form.PrgmComP0130;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0300Def;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
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
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PsnlP060001   extends MSFFormPanel {  

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
 
	private  FormPanel cpPsnl0600; 

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

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
      
      
      
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
 		
 	private Button btnPsnl0600Excel;	//엑셀 버튼
 		
 	// --  출력 선택
 	private CheckBoxGroup psnl0600Yn;							//
 	
 	private CheckBox checkBox1;
 	private CheckBox checkBox2;
 	private CheckBox checkBox3;
 	private CheckBox checkBox4;
 	private CheckBox checkBox5;
 	private CheckBox checkBox6;
 	private CheckBox checkBox7;
 	private CheckBox checkBox8;
 	private CheckBox checkBox9;
 	private CheckBox checkBox10;
 	
 	// -------------- 상위 검색조건 시작 -------------- 
	private HiddenField<String> payrMangDeptCd;					//단위기관 코드
	private TextField<String> srhDeptCd;						//부서코드
    private TextField<String> srhDeptNm; 						//부서명  
    private Button btnSrhDeptCd;
    private TextField<String> srhMangeDeptCd; 					//관리부서 수정
    private TextField<String> srhMangeDeptNm; 					//관리부서 수정 
    private ComboBox<BaseModel> srhPayrMangDeptCd; 				//단위기관
	private ComboBox<BaseModel> searchEmymtDivCd; 				//고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 			//호봉제구분코드  
	private HiddenField<String> searchPyspGrdeCd;
	private String typComboOccuCd  = new String(); 
	private ComboBox<BaseModel> srhTypOccuCd;  					//직종
	private ComboBox<BaseModel> srhDeptGpCd;		 			//부서직종그룹코드	    
	private MSFMultiComboBox<ModelData>  srhDtilOccuInttnCd;	//직종세 구분
	private DateField searchNowDeptDateS;		  				//현부서 시작일
	private DateField searchNowDeptDateE;		  				//현부서 종료일
	private DateField searchFrstWorkDateS;		  				//최초 고용 시작일
	private DateField searchFrstWorkDateE;		  				//최초 고용 종료일
	private DateField searchBirthDateS;			  				//생일 시작일
	private DateField searchBirthDateE;			  				//생일 종료일
	private ComboBox<BaseModel> searchWorkYearS;  				//근속년수 시작일
	private ComboBox<BaseModel> searchWorkYearE;  				//근속년수 시작일
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 		//재직구분
	private ComboBox<BaseModel> searchSexType;					//성별
	private ComboBox<BaseModel> srhBusinCd; 					//사업명 
	
	
	private LayoutContainer lcSch1_2_1 = new LayoutContainer(new ColumnLayout());	// 기간별
	private LayoutContainer lcSch1_2_2 = new LayoutContainer(new ColumnLayout());	// 분기별
	private LayoutContainer lcSch1_2_3 = new LayoutContainer(new ColumnLayout());	// 월별
	
	private ComboBox<BaseModel> srhDateType;						// 기간구분(기간별, 분기별, 월별)
	private ComboBox<BaseModel> srhYr01;							// 월별 년
	private ComboBox<BaseModel> srhMnth;							// 월별 월
    private DateField srhDayS;      								// 기간별 시작일
    private DateField srhDayE;      								// 기간별 종료일
    private ComboBox<BaseModel> srhYr02;							// 분기별 년
    private ComboBox<BaseModel> srhMnthS;							// 분기별 시작월
    private ComboBox<BaseModel> srhMnthE;							// 분기별 종료월
	private HiddenField<String> month;
	// -------------- 상위 검색조건 종료 -------------- 
	
	private ListStore<BaseModel> listStoreA002 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA041 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA007 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA003 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA004 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA025 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA023 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA024 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA045 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA026 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA028 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA011 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA046 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreB014 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsHdofcCodtnCd 	= new ListStore<BaseModel>();	//재직상태 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  	
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDateType 		= new ListStore<BaseModel>();  	// 기간 구분
	private ListStore<BaseModel> lsYrStore 			= new ListStore<BaseModel>();  	// 년도 
	private ListStore<BaseModel> lsMonthStore 		= new ListStore<BaseModel>();  	// 월 
	
	
    private List<ModelData> mDtalistDtilOccuInttnCd;			//직종세 멀티 
    private List<ModelData> mDtalistHdofcCodtnCd;				//재직 멀티
    private boolean mutilCombo = false;
    
    
	private TabPanel tabsPsnl; //하위 탭  
	
	
	// -------------- 병역 검색조건 시작 -------------- 
	private ComboBox<BaseModel> searchDsageDivCd;				//제대구분
	private DateField searchDsageDtS;		      				//제대 시작일
	private DateField searchDsageDtE;		      				//제대 종료일
	private ComboBox<BaseModel> searchBaggrpCd;   				//군별
	private ComboBox<BaseModel> searchAbotsCd;    				//병과
	private ComboBox<BaseModel> searchClsCd;      				//계급
	// -------------- 병역 검색조건 종료 -------------- 
	
	
	// -------------- 단체 검색조건 시작 --------------
	private TextField<String> searchJnOpztnNm;					//단체명
	private DateField searchJnDtS;			  					//가입기간 시작일
	private DateField searchJnDtE;			  					//가입기간 종료일
	// -------------- 단체 검색조건 종료 --------------
	
	
	// -------------- 학력 검색조건 시작 --------------
	private ComboBox<BaseModel> searchAcadAbtyDivCd;			//학력구분
	private ComboBox<BaseModel> searchDegrDivCd;				//학위
	private TextField<String> searchDeprMajrCd;	 				//학과
	private TextField<String> searchSchlCd;		 				//학교명
	private TextField<String> searchDeprMajrCdNm;				//학과
	private TextField<String> searchSchlCdNm;					//학교명
	// -------------- 학력 검색조건 종료 --------------
	
	
	// -------------- 경력 검색조건 시작 --------------
	private TextField<String> searchPaeWorkNm;					//근무처명
	private DateField searchCarrBgnnDtS;						//근무시작일 시작
	private DateField searchCarrBgnnDtE;						//근무시작일 종료
	// -------------- 경력 검색조건 종료 --------------
	
	// -------------- 자격 검색조건 시작 --------------
	private TextField<String> searchQftntLicnsPovncCtnt;		//자격면허
	private DateField searchAqtnDtS;							//취득일자 시작
	private DateField searchAqtnDtE;							//취득일자 종료
	// -------------- 자격 검색조건 종료 --------------
	
	// -------------- 교육 검색조건 시작 --------------
	private TextField<String> searchEduKndNm;					//교육종류
	private DateField searchEduBgnnDtS;							//교육기간 시작
	private DateField searchEduBgnnDtE;							//교육기간 종료
	// -------------- 교육 검색조건 종료 --------------
	
	// -------------- 징계 검색조건 시작 --------------
	private ComboBox<BaseModel> searchDsnyActDivCd;				//징계구분
	private DateField searchDsnyActDsplDtS;						//징계처분일 시작
	private DateField searchDsnyActDsplDtE;		    			//징계처분일 종료
	// -------------- 징계 검색조건 종료 --------------
	
	// -------------- 휴직 검색조건 시작 --------------
	private ComboBox<BaseModel> searchLevfAbncDivCd;			//휴직구분
	private DateField searchLevfAbncBgnnDtS;					//휴직일 시작
	private DateField searchLevfAbncBgnnDtE;					//휴직일 종료
	// -------------- 휴직 검색조건 종료 --------------

	
    
    
	
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/
	  /**
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	  private void checkPsnl0600Auth( String authAction, ListStore<BaseModel> bm) {   
  	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			   if (!maskTracker) { unmask(); }  
             //MSFMainApp.unmaskMainPage();
			   authExecEnabled() ;
				
               
		   }
	  }
	  
	  private void authExecEnabled() { 
		  Field<?>[] fldArrField = {searchEmymtDivCd,srhMangeDeptCd,srhDeptNm,srhDeptCd,srhDeptNm,srhTypOccuCd, srhBusinCd};
	       	 
		  gwtAuthorization.formAuthFieldConfig(fldArrField);
		  gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
		  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  		  	* 권한설정을 위한 콤보처리를 위한 메서드 시작 
  		  	* 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		  
		  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  		  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
     		 srhDeptCd.fireEvent(Events.Add);
     		 
     		 
  		 // ------------- 월별 날짜 셋팅 
  		 srhYr01.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
  		 srhMnth.setValue(lsMonthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
  		 // ------------- 월별 날짜 셋팅 
  		 
  		 
  		 // ------------- 분기별 날짜 셋팅 
  		 srhYr02.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//분기별 년도
  		 srhMnthS.setValue(lsMonthStore.findModel("month", DateTimeFormat.getFormat("MM").format(new Date()))); 
  		 // ------------- 분기별 날짜 셋팅 
     	
	  }

	final Timer tmMask = new Timer() {
		public void run() {
			if (listStoreA002.getCount() > 0) {

				cancel();
				unmask();
				authExecEnabled();
				maskTracker = true;

			} else {
				tmMask.scheduleRepeating(2000);
			}
		}
	};
	     
	private void initLoad() {
		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();

		authMapDef.put("searchEmymtDivCd", Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			// 권한 검색조건처리를 위해 추가된 부분
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
 
//	    private PsnlP010002ServiceAsync psnlP010002Service = PsnlP010002Service.Util.getInstance();
		
	    
  		private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드  
  		private PrgmComBass0320DTO sysComBass0320Dto; // 직종코드  
  		private PrgmComBass0350DTO sysComBass0350Dto; // 직종세코드  
  		private PrgmComBass0500DTO sysComBass0500Dto; // 부서코드
  		
  		private SysCoCalendarDTO msfCoCalendarDto;   
  		
	    
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
  		
  		
	private void doAction(ActionDatabase actionDatabase) {

		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			break;
//		case DELETE:
//			this.actionDatabase = ActionDatabase.DELETE;
//			savePsnl0100();
//			break;
		}

	}
 
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
  		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
  		 * 	file upload  선언부 시작
  		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
  		 **/
  	 
//  	  FlowPanel panelImages = new FlowPanel();
//  	  OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
//  	    public void onLoad(PreloadedImage img) {
//  	      img.setWidth("75px");
//  	      panelImages.add(img);
//  	    }
//  	  };
//
//  	  protected UploaderConstants i18nStrs;;
//
//  	  private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
//  	    public void onFinish(IUploader uploader) {
//  	      if (uploader.getStatus() == Status.SUCCESS) {
//  	        for (String url : uploader.getServerMessage().getUploadedFileUrls()) {
//  	          new PreloadedImage(url, showImage);
//  	        }
//  	      }
//  	    }
//  	  };
		/**
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 	file upload  선언부 닫기
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 **/  
	
	
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/ 		    
	public PsnlP060001(final ActionDatabase ad, final MSFPanel caller) {
		
		
		// 권한 검색조건처리를 위해 추가된 부분 
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
		this.actionDatabase = ad;
		this.caller = caller;

		cpPsnl0600 = new FormPanel();
		cpPsnl0600.setBodyBorder(false);
		cpPsnl0600.setBorders(false);
		cpPsnl0600.setHeaderVisible(false);
		cpPsnl0600.setSize("950px", "300px");
		// cpPsnl0600.add(single1);
		this.add(cpPsnl0600);
		
		createStandardForm(); 	
		
		 //---------------------멀티콤보박스 닫기 -------------------------------------------------
		cpPsnl0600.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			  @Override
			  public void handleEvent(ComponentEvent ce) { 
				  if (mutilCombo) {
					  if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
						  srhHdofcCodtnCd.showClose(ce);
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
		
		formBinding = new FormBinding(this, true);

		this.setSize("970px", "310px");
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
	 
	private void createStandardForm() {
		
		payrMangDeptCd = new HiddenField<String>();
		month = new HiddenField<String>();
		
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
  		sysComBass0320Dto = new PrgmComBass0320DTO();  
  		sysComBass0350Dto = new PrgmComBass0350DTO(); 
  		sysComBass0500Dto = new PrgmComBass0500DTO();
  		
  		
  		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A002");
		 listStoreA002 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A041");
		 listStoreA041 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A007");
		 listStoreA007 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------년도 불러 오는 함수 ------------------------------------------------
		 lsYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);	
		 //--------------------년도 불러 오는 함수 ------------------------------------------------ 
	        
		 //--------------------월 불러 오는 함수 ------------------------------------------------ 
		 lsMonthStore = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------월 불러 오는 함수 ------------------------------------------------ 
		 
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("S001");	// 기간구분
		 lsDateType = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		 lsDateType.addStoreListener( new StoreListener<BaseModel>() {   
				public void handleEvent(StoreEvent<BaseModel> be) {  
					srhDateType.setValue(lsDateType.getAt(0));
		         }
			});  
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		    
		 //sysComBass0300Dto.setRpsttvCd("A003");
		// listStoreA003 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		//재직상태  
		sysComBass0300Dto.setRpsttvCd("A003");
		lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(lsHdofcCodtnCd) ; 
	            srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
	         }
		});   
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A004");
		 listStoreA004 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A025");
		 listStoreA025 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A023");
		 listStoreA023 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A024");
		 listStoreA024 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A045");
		 listStoreA045 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A026");
		 listStoreA026 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A028");
		 listStoreA028 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A011");
		 listStoreA011 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A048");
		 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A046");
		 listStoreA046 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("B014");
		 listStoreB014 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		sysComBass0320Dto = new PrgmComBass0320DTO();
		listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
  		
//		 cpPsnl0600.setLayout(new FlowLayout());
        
		LayoutContainer layoutContainer111 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		
		btnPsnl0600Excel = new Button("엑셀");
		btnPsnl0600Excel.setIcon(MSFMainApp.ICONS.excel16());
		btnPsnl0600Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// TODO Auto-generated method stub
				
				HashMap<String, String> param = new HashMap<String, String>(); 
//				DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
				
				
				param.put("psnl0100Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox1) );
				param.put("psnl0112Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox2) );
				param.put("psnl0114Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox3) );
				param.put("psnl0116Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox4) );
				param.put("psnl0119Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox5) );
				param.put("psnl0118Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox6) );
				param.put("psnl0120Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox7) );
				param.put("psnl0121Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox8) );
				param.put("psnl0122Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox9) );
				param.put("psnl0123Chk", PersonalUtil.getCheckedCheckBoxYnValue(checkBox10) );

			 	/******************* 기본 검색조건 시작 *******************/       
            	param.put("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));	
            	
    	        param.put("srhDeptCd", MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
    	        param.put("srhCurrDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
    	        param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(searchEmymtDivCd,"commCd"));
    	        param.put("srhTypOccuCd", PersonalUtil.getSelectedComboValue(srhTypOccuCd,"typOccuCd"));
    	        
    	        String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
    	        param.put("srhDtilOccuInttnCd", strDtilOccuInttnCd);  
    	        
    	        
    	        param.put("srhNowDeptDateS", PersonalUtil.getConvertDateToString(searchNowDeptDateS, "yyyyMMdd"));
    	        param.put("srhNowDeptDateE", PersonalUtil.getConvertDateToString(searchNowDeptDateE, "yyyyMMdd"));
    	        param.put("srhFrstWorkDateS", PersonalUtil.getConvertDateToString(searchFrstWorkDateS, "yyyyMMdd"));
    	        param.put("srhFrstWorkDateE", PersonalUtil.getConvertDateToString(searchFrstWorkDateE, "yyyyMMdd"));
    	        param.put("srhWorkYearS", PersonalUtil.getSelectedComboValue(searchWorkYearS,"mangeItem01"));
    	        param.put("srhWorkYearE", PersonalUtil.getSelectedComboValue(searchWorkYearE,"mangeItem01"));
    	                    
//    	        String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
//    	    	if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
//    	    		String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
//    	    	    String chkkey = "";
//    	    	    for (int i=0; i<ray.length; i++){ 
//    	    	    	BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
//    	    	    	chkkey += bmData.get("commCd")+","; 
//    	    		}
//    	    	    strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
//    	    	} 
    	        String strHdofcCodtnCd =  PersonalUtil.getStrValToBMMultiCombo(lsHdofcCodtnCd, srhHdofcCodtnCd.getValue(),"commCdNm","commCd"); 
    	    	param.put("srhHdofcCodtnCd", strHdofcCodtnCd);	
    	    	param.put("srhSexType", PersonalUtil.getSelectedComboValue(searchSexType,"commCd"));
    	    	
    	    	
    			// 기간구분별 파라미터 설정
    			String strDateType = PersonalUtil.getSelectedComboValue(srhDateType, "commCd");									// 기간 구분
    			
    			String strDayS = PersonalUtil.getConvertDateToString(srhDayS, "yyyyMMdd");										// 기간별_시작일
    			String strDayE = PersonalUtil.getConvertDateToString(srhDayE, "yyyyMMdd");										// 기간별_종료일
    			
    			String strYr02 = PersonalUtil.getSelectedComboValue(srhYr02, "yearDisp");										// 분기별_년
    			String strMnthS = PersonalUtil.getSelectedComboValue(srhMnthS, "monthDisp");									// 분기별_시작월
    			String strMnthE = PersonalUtil.getSelectedComboValue(srhMnthE, "monthDisp");									// 분기별_종료월
    			
    			String strYr01 = PersonalUtil.getSelectedComboValue(srhYr01, "yearDisp");										// 월별_년			
    			String strMnth = PersonalUtil.getSelectedComboValue(srhMnth, "monthDisp");										// 월별_월
    			
    			param.put("dateType", strDateType); 																			// 고용기간구분
    			// 기간별
    			if("S0010010".equals(strDateType) || strDateType == "S0010010") {
    				
    				param.put("emymtBgnnDt" , strDayS ); 				
    				param.put("emymtEndDt"  , strDayE ); 
    			
    			// 분기별
    			}else if("S0010020".equals(strDateType) || strDateType == "S0010020") {
    				
    				param.put("emymtBgnnDt" , strYr02 +  strMnthS ); 				
    				param.put("emymtEndDt"  , strYr02 +  strMnthE ); 
    			
    			// 월별
    			}else if("S0010030".equals(strDateType) || strDateType == "S0010030") {
    				
    				param.put("emymtBgnnDt" , strYr01 +  strMnth ); 				
    				param.put("emymtEndDt"  , strYr01 +  strMnth );
    				
    			}
    	    	/******************* 기본 검색조건 종료 *******************/
    			
    			
    			/******************* 병역 검색조건 시작 *******************/
    	    	param.put("srhDsageDivCd", PersonalUtil.getSelectedComboValue(searchDsageDivCd,"commCd"));				// 제대구분
    	    	param.put("srhDsageDtS", PersonalUtil.getConvertDateToString(searchDsageDtS, "yyyyMMdd"));				// 제대 시작 일자  
    	    	param.put("srhDsageDtE", PersonalUtil.getConvertDateToString(searchDsageDtE, "yyyyMMdd"));				// 제대 종료 일자 
    	    	param.put("srhBaggrpCd", PersonalUtil.getSelectedComboValue(searchBaggrpCd,"commCd"));					// 군별
    	    	param.put("srhAbotsCd", PersonalUtil.getSelectedComboValue(searchAbotsCd,"commCd"));					// 병과
    	    	param.put("srhClsCd", PersonalUtil.getSelectedComboValue(searchClsCd,"commCd"));						// 계급
    	    	/******************* 병역 검색조건 종료 *******************/

    	    	
    			/******************* 단체 검색조건 시작 *******************/
    	    	param.put("srhJnOpztnNm", searchJnOpztnNm.getValue());													// 단체명
    	    	param.put("srhJnDtS", PersonalUtil.getConvertDateToString(searchJnDtS, "yyyyMMdd"));					// 가입 시작 일자  
    	    	param.put("srhJnDtE", PersonalUtil.getConvertDateToString(searchJnDtE, "yyyyMMdd"));					// 가입 종료 일자
    	    	/******************* 단체 검색조건 종료 *******************/

    	    	
    	    	/******************* 학력 검색조건 시작 *******************/
    	       	param.put("srhAcadAbtyDivCd", PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd"));		// 학력구분
    	    	param.put("srhSchlCd", searchSchlCd.getValue());														// 학교
    	    	param.put("srhDeprMajrCd", searchDeprMajrCd.getValue());												// 학과
    	    	param.put("srhDegrDivCd", PersonalUtil.getSelectedComboValue(searchDegrDivCd,"commCd"));				// 학위
    	       	/******************* 학력 검색조건 종료 *******************/

    	    	
    	    	/******************* 경력 검색조건 시작 *******************/
       	    	param.put("srhPaeWorkNm", searchPaeWorkNm.getValue());													// 근무처명
    	    	param.put("srhCarrBgnnDtS", PersonalUtil.getConvertDateToString(searchCarrBgnnDtS, "yyyyMMdd"));		// 근무시작일(시작)
    	    	param.put("srhCarrBgnnDtE", PersonalUtil.getConvertDateToString(searchCarrBgnnDtE, "yyyyMMdd"));		// 근무시작일(종료)
    	      	/******************* 경력 검색조건 종료 *******************/

    	    	
    	    	/******************* 자격 검색조건 시작 *******************/
    	    	param.put("srhQftntLicnsPovncCtnt", searchQftntLicnsPovncCtnt.getValue());								// 자격면허
    	    	param.put("srhAqtnDtS", PersonalUtil.getConvertDateToString(searchAqtnDtS, "yyyyMMdd"));				// 취득일자(시작)
    	    	param.put("srhAqtnDtE", PersonalUtil.getConvertDateToString(searchAqtnDtE, "yyyyMMdd"));				// 취득일자(종료)
    	    	/******************* 자격 검색조건 종료 *******************/

    	    	
    	     	/******************* 교육 검색조건 시작 *******************/
    	    	param.put("srhEduKndNm", searchEduKndNm.getValue());													// 교육종류
    	    	param.put("srhEduBgnnDtS", PersonalUtil.getConvertDateToString(searchEduBgnnDtS, "yyyyMMdd"));			// 교육기간(시작)
    	    	param.put("srhEduBgnnDtE", PersonalUtil.getConvertDateToString(searchEduBgnnDtE, "yyyyMMdd"));			// 교육기간(종료)
    	    	/******************* 교육 검색조건 종료 *******************/

    	    	
    	     	/******************* 징계 검색조건 시작 *******************/
    	    	param.put("srhDsnyActDivCd", PersonalUtil.getSelectedComboValue(searchDsnyActDivCd,"commCd"));			// 징계구분
    	    	param.put("srhDsnyActDsplDtS", PersonalUtil.getConvertDateToString(searchDsnyActDsplDtS, "yyyyMMdd"));	// 징계처분일(시작)
    	    	param.put("srhDsnyActDsplDtE", PersonalUtil.getConvertDateToString(searchDsnyActDsplDtE, "yyyyMMdd"));	// 징계처분일(종료)
    	    	/******************* 징계 검색조건 종료 *******************/
    	    	
    	    	
    	    	/******************* 휴직 검색조건 시작 *******************/
    	    	param.put("srhLevfAbncDivCd", PersonalUtil.getSelectedComboValue(searchLevfAbncDivCd,"commCd"));		 // 휴직구분
    	    	param.put("srhLevfAbncBgnnDtS", PersonalUtil.getConvertDateToString(searchLevfAbncBgnnDtS, "yyyyMMdd")); // 휴직기간(시작)
    	    	param.put("srhLevfAbncBgnnDtE", PersonalUtil.getConvertDateToString(searchLevfAbncBgnnDtE, "yyyyMMdd")); // 휴직기간(종료)
    	     	/******************* 휴직 검색조건 종료 *******************/
    	    	
    	    	
    	    	GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0600SelExport.do","extgwtFrame", JsUtil.toJavaScriptObject(param));	                	
				
			}
		});
		btnBar.add(btnPsnl0600Excel);
		
		
		layoutContainer111.add(btnBar);

		FieldSet fieldSet1 = new FieldSet();
		fieldSet1.setHeadingHtml("출력선택");
		fieldSet1.setStyleAttribute("paddingLeft"	, "5px");
		fieldSet1.setStyleAttribute("paddingRight"	, "5px");
		
		
		psnl0600Yn = new CheckBoxGroup();
		psnl0600Yn.setHideLabel(true);
		
		checkBox1 = new CheckBox();
		checkBox1.setBoxLabel("기본");
		checkBox1.setHideLabel(false);
		checkBox1.setReadOnly(true);
		checkBox1.setValueAttribute("Y");
		checkBox1.setValue(true);
		psnl0600Yn.add(checkBox1);
		
		checkBox2 = new CheckBox();
		checkBox2.setBoxLabel("병역");
		checkBox2.setHideLabel(false);
		checkBox2.setValueAttribute("Y");
		checkBox2.setValue(false);
		psnl0600Yn.add(checkBox2);
		
		
		checkBox3 = new CheckBox();
		checkBox3.setBoxLabel("단체");
		checkBox3.setHideLabel(false);
		checkBox3.setValueAttribute("Y");
		checkBox3.setValue(false);
		psnl0600Yn.add(checkBox3);
		
		checkBox4 = new CheckBox();
		checkBox4.setBoxLabel("학력");
		checkBox4.setHideLabel(false);
		checkBox4.setValueAttribute("Y");
		checkBox4.setValue(false);
		psnl0600Yn.add(checkBox4);
		
		checkBox5 = new CheckBox();
		checkBox5.setBoxLabel("경력");
		checkBox5.setHideLabel(false);
		checkBox5.setValueAttribute("Y");
		checkBox5.setValue(false);
		psnl0600Yn.add(checkBox5);
		
		checkBox6 = new CheckBox();
		checkBox6.setBoxLabel("자격");
		checkBox6.setHideLabel(false);
		checkBox6.setValueAttribute("Y");
		checkBox6.setValue(false);
		psnl0600Yn.add(checkBox6);
		
		checkBox7 = new CheckBox();
		checkBox7.setBoxLabel("교육");
		checkBox7.setHideLabel(false);
		checkBox7.setValueAttribute("Y");
		checkBox7.setValue(false);
		psnl0600Yn.add(checkBox7);
		
		checkBox8 = new CheckBox();
		checkBox8.setBoxLabel("포상");
		checkBox8.setHideLabel(false);
		checkBox8.setValueAttribute("Y");
		checkBox8.setValue(false);
		psnl0600Yn.add(checkBox8);
		
		checkBox9 = new CheckBox();
		checkBox9.setBoxLabel("징계");
		checkBox9.setHideLabel(false);
		checkBox9.setValueAttribute("Y");
		checkBox9.setValue(false);
		psnl0600Yn.add(checkBox9);
		
		checkBox10 = new CheckBox();
		checkBox10.setBoxLabel("휴직");
		checkBox10.setHideLabel(false);
		checkBox10.setValueAttribute("Y");
		checkBox10.setValue(false);
		psnl0600Yn.add(checkBox10);
		
		
		fieldSet1.add(psnl0600Yn, new FormData("100%"));
		
		
		layoutContainer111.add(fieldSet1);
		
		
		FieldSet fieldSet2 = new FieldSet();
		fieldSet2.setHeadingHtml("검색조건");
		fieldSet2.setStyleAttribute("paddingLeft"	, "5px");
		fieldSet2.setStyleAttribute("paddingRight"	, "5px");
		
		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytSch);

		
		 //검색 부서 코드 처리  
		LayoutContainer lccmlcDeptNm = new LayoutContainer();
        lccmlcDeptNm.setLayout(new ColumnLayout());
        //부서 
        srhDeptCd = new TextField<String>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setVisible(false);
//        srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());//TODO 확인 
//        srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd()); 
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
		        				//searchYearBusinCd.setValue(lsBusinCd.getAt(0));  
        						}
        					});    
        				} else  if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
   	            		     					
        					//2015.11.30 권한 직종가져오기  추가 
   	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
   	            		   sysComBass0320Dto.setDeptCd(srhDeptCd.getValue());
   	            	       listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   	            	       srhTypOccuCd.setStore(listStoreA041);
   	            	   } else {
   	            		     
   	            	   } 
        		} 
        	}
        });
        
        
        cpPsnl0600.add(srhDeptCd);
        
        srhMangeDeptCd = new TextField<String>();
        srhMangeDeptCd.setName("srhMangeDeptCd");
        srhMangeDeptCd.setVisible(false);
        cpPsnl0600.add(srhMangeDeptCd);
        srhMangeDeptNm = new TextField<String>();
        srhMangeDeptNm.setName("srhMangeDeptNm");
        srhMangeDeptNm.setVisible(false);
        cpPsnl0600.add(srhMangeDeptNm);
  
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcDeptNm.setLayout(frmlytSch);
      
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
        			//if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
        				srhDeptCd.setValue("");
        				srhMangeDeptCd.setValue("");
        			//}
        			fnPopupCommP140(srhDeptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
         
         
       
         
         lcDeptNm.add(srhDeptNm, new FormData("100%"));  
          
         btnSrhDeptCd = new Button();
         btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
         btnSrhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
         btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
        	 public void handleEvent(ButtonEvent e) { 
        		 //if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
        			 srhDeptCd.setValue("");
        			 srhMangeDeptCd.setValue("");
        		 //}
        		 fnPopupCommP140(srhDeptNm.getValue()); 
        	 }
         });
            
         lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
         lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
           
         layoutContainer.add(lccmlcDeptNm, new FormData("100%"));
         lcSchCol.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
         layoutContainer.setBorders(false);

         LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
         
         
         LayoutContainer layoutContainer_1_1 = new LayoutContainer();
         
         frmlytSch = new FormLayout();
         frmlytSch.setLabelWidth(70);
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
         layoutContainer_1_1.setLayout(frmlytSch);
		 
		
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
         searchEmymtDivCd.setStore(listStoreA002);
         searchEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
         searchEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
         listStoreA002.addStoreListener( new StoreListener<BaseModel>() {   
        	 public void handleEvent(StoreEvent<BaseModel> be) {  
        		 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              		  	* 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
              		  	* 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              		  	* "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			 			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkPsnl0600Auth("searchEmymtDivCd", listStoreA002); 
              	 }
        	 }
         });
        
         searchEmymtDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
        	 @Override
        	 public void handleEvent(BaseEvent be) {
        		 String emymt = searchEmymtDivCd.getValue() == null ? "" : String.valueOf(searchEmymtDivCd.getValue().get("commCd")) ;
 				
        		 if(MSFConfiguration.EMYMT_DIVCD01.equals(emymt)){ //공무직일 경우
        			//20151130 추가 수정 
        			 srhDeptCd.fireEvent(Events.Add); 
        			 srhBusinCd.reset();
                     srhBusinCd.setEnabled(false);   
                     if (gwtExtAuth.getEnableTypOccuCd()) {
                    	 srhTypOccuCd.setEnabled(true);
                      	 srhDtilOccuInttnCd.setEnabled(true); 
                     } else {
                    	 srhTypOccuCd.setEnabled(false);
                     	 srhDtilOccuInttnCd.setEnabled(false);
                     }
        			 
   					
   				}else if(MSFConfiguration.EMYMT_DIVCD02.equals(emymt)){ //기간제 계약직일 경우
   					srhDeptCd.fireEvent(Events.Add); 
   					srhBusinCd.setEnabled(true);
   					srhTypOccuCd.reset();
        			srhTypOccuCd.setEnabled(false);
        			srhDtilOccuInttnCd.reset();
        			srhDtilOccuInttnCd.setEnabled(false);
   					
   				} 
        	 }
         });

         layoutContainer_1_1.add(searchEmymtDivCd, new FormData("100%"));
         layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
         
         
         LayoutContainer layoutContainer_1_2 = new LayoutContainer();
		// lcSchCol.add(layoutContainer_101);
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1_2.setLayout(frmlytSch);

		srhRepbtyBusinDivCd = new ComboBox<BaseModel>();
		srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
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
		lsRepbtyBusinDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});
		    
		layoutContainer_1_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
		layoutContainer_1_2.setBorders(false);
		layoutContainer_1.add(layoutContainer_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
         
         
         lcSchCol.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
         layoutContainer_1.setBorders(false);

         LayoutContainer layoutContainer_2 = new LayoutContainer();
         frmlytSch = new FormLayout();
         frmlytSch.setLabelWidth(70);
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
         layoutContainer_2.setLayout(frmlytSch);
		

         srhBusinCd = new ComboBox<BaseModel>();
         srhBusinCd.setFieldLabel("사업명");
         srhBusinCd.setForceSelection(true);
       	 srhBusinCd.setMinChars(1);
       	 srhBusinCd.setDisplayField("businNm");
         srhBusinCd.setValueField("businCd");
         srhBusinCd.setTriggerAction(TriggerAction.ALL);
         srhBusinCd.setEmptyText("--사업선택--");
         srhBusinCd.setSelectOnFocus(true);
         srhBusinCd.setName("srhBusinCd");
         srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
         srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
         srhBusinCd.setStore(new ListStore<BaseModel>());
         
         layoutContainer_2.add(srhBusinCd, new FormData("100%"));
         
         lcSchCol.add(layoutContainer_2,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
         layoutContainer_2.setBorders(false);

         LayoutContainer layoutContainer_3 = new LayoutContainer();
         frmlytSch = new FormLayout();
         frmlytSch.setLabelWidth(70);
         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
         layoutContainer_3.setLayout(frmlytSch);

		 
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
//                 srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//                 srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
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
         layoutContainer_3.add(srhHdofcCodtnCd, new FormData("100%"));
		 
		 
		 
		 lcSchCol.add(layoutContainer_3,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		 layoutContainer_3.setBorders(false);

		 /****************************************************************
		  * 검색조건 배경 변경 스타일시트 추가 시작
		  ****************************************************************/
//		 	fieldSet.addStyleName("x-fieldset-serarch-back-color");
		 /****************************************************************
		  * 검색조건 배경 변경 스타일시트 추가 끝
		  ****************************************************************/		 

		 	fieldSet2.add(lcSchCol, new FormData("100%"));

		 LayoutContainer layoutContainer_4 = new LayoutContainer();
		 layoutContainer_4.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_5 = new LayoutContainer();
		 layoutContainer_5.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_9 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_9.setLayout(frmlytSch);

		 searchNowDeptDateS = new DateField();
		 new DateFieldMask(searchNowDeptDateS, "9999.99.99");
		 searchNowDeptDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 layoutContainer_9.add(searchNowDeptDateS, new FormData("100%"));
		 searchNowDeptDateS.setFieldLabel("현부서일");
		 layoutContainer_5.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		 layoutContainer_9.setBorders(false);

		 LayoutContainer layoutContainer_10 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(10);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_10.setLayout(frmlytSch);

		 searchNowDeptDateE = new DateField();
		 new DateFieldMask(searchNowDeptDateE, "9999.99.99");
		 searchNowDeptDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchNowDeptDateE.setLabelSeparator("~");
		 layoutContainer_10.add(searchNowDeptDateE, new FormData("100%"));
		 layoutContainer_5.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		 layoutContainer_10.setBorders(false);
		 layoutContainer_4.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		 layoutContainer_5.setBorders(false);

		 LayoutContainer layoutContainer_6 = new LayoutContainer();
		 layoutContainer_6.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_8 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_8.setLayout(frmlytSch);
 
		 searchFrstWorkDateS = new DateField();
		 new DateFieldMask(searchFrstWorkDateS, "9999.99.99");
		 searchFrstWorkDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchFrstWorkDateS.setFieldLabel("최초고용일");
		 layoutContainer_8.add(searchFrstWorkDateS, new FormData("100%"));
		 layoutContainer_6.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		 layoutContainer_8.setBorders(false);

		 LayoutContainer layoutContainer_11 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(10);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_11.setLayout(frmlytSch);

		 searchFrstWorkDateE = new DateField();
		 new DateFieldMask(searchFrstWorkDateE, "9999.99.99");
		 searchFrstWorkDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchFrstWorkDateE.setLabelSeparator("~");
		 layoutContainer_11.add(searchFrstWorkDateE, new FormData("100%"));
		 layoutContainer_11.setBorders(false);
		 layoutContainer_6.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		 layoutContainer_6.setBorders(false);
		 layoutContainer_4.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));

		 LayoutContainer layoutContainer_7 = new LayoutContainer();
		 layoutContainer_7.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_12 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_12.setLayout(frmlytSch);

//		searchBirthDateS = new DateField();
//		searchBirthDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		searchBirthDateS.setFieldLabel("생년월일");
//		layoutContainer_12.add(searchBirthDateS, new FormData("100%"));
		
		 searchWorkYearS = new ComboBox<BaseModel>();
		 searchWorkYearS.setFieldLabel("근속년수");
		 searchWorkYearS.setForceSelection(true);
		 searchWorkYearS.setMinChars(1);
		 searchWorkYearS.setDisplayField("commCdNm");
		 searchWorkYearS.setValueField("commCd");
		 searchWorkYearS.setTriggerAction(TriggerAction.ALL);
		 searchWorkYearS.setEmptyText("--근속년수--");
		 searchWorkYearS.setSelectOnFocus(true);
		 searchWorkYearS.setStore(listStoreA007);
		
		 layoutContainer_12.add(searchWorkYearS, new FormData("100%"));
		
		 layoutContainer_7.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		 layoutContainer_12.setBorders(false);

		 LayoutContainer layoutContainer_13 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(10);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_13.setLayout(frmlytSch);

//		searchBirthDateE = new DateField();
//		searchBirthDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		searchBirthDateE.setLabelSeparator("~");
//		layoutContainer_13.add(searchBirthDateE, new FormData("100%"));
		
		 searchWorkYearE = new ComboBox<BaseModel>();
		 searchWorkYearE.setLabelSeparator("~");
		 searchWorkYearE.setForceSelection(true);
		 searchWorkYearE.setMinChars(1);
		 searchWorkYearE.setDisplayField("commCdNm");
		 searchWorkYearE.setValueField("commCd");
		 searchWorkYearE.setTriggerAction(TriggerAction.ALL);
		 searchWorkYearE.setEmptyText("--근속년수--");
		 searchWorkYearE.setSelectOnFocus(true);
		 searchWorkYearE.setStore(listStoreA007);
		
		 layoutContainer_13.add(searchWorkYearE, new FormData("100%"));
		
		 layoutContainer_7.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		 layoutContainer_13.setBorders(false);
		 layoutContainer_4.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		 layoutContainer_7.setBorders(false);

		 LayoutContainer layoutContainer_14 = new LayoutContainer();
		 layoutContainer_14.setLayout(new ColumnLayout());

		 LayoutContainer layoutContainer_17 = new LayoutContainer();
		 frmlytSch = new FormLayout();
		 frmlytSch.setLabelWidth(70);
		 frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		 layoutContainer_17.setLayout(frmlytSch);
  
//		searchWorkYearS = new ComboBox<BaseModel>();
//		searchWorkYearS.setFieldLabel("근속년수");
//		searchWorkYearS.setForceSelection(true);
//		searchWorkYearS.setMinChars(1);
//		searchWorkYearS.setDisplayField("commCdNm");
//		searchWorkYearS.setValueField("commCd");
//		searchWorkYearS.setTriggerAction(TriggerAction.ALL);
//		searchWorkYearS.setEmptyText("--근속년수--");
//		searchWorkYearS.setSelectOnFocus(true);
//		searchWorkYearS.setStore(listStoreA007);
//		
//		layoutContainer_17.add(searchWorkYearS, new FormData("100%"));
		
		 searchBirthDateS = new DateField();
		 new DateFieldMask(searchBirthDateS, "9999.99.99");
		 searchBirthDateS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchBirthDateS.setFieldLabel("생년월일");
		 layoutContainer_17.add(searchBirthDateS, new FormData("100%"));
		
	     layoutContainer_14.add(layoutContainer_17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	    
	     LayoutContainer layoutContainer_18 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(10); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	     layoutContainer_18.setLayout(frmlytSch);
	     layoutContainer_18.setBorders(false);
	     
//	    searchWorkYearE = new ComboBox<BaseModel>();
//		searchWorkYearE.setLabelSeparator("~");
//		searchWorkYearE.setForceSelection(true);
//		searchWorkYearE.setMinChars(1);
//		searchWorkYearE.setDisplayField("commCdNm");
//		searchWorkYearE.setValueField("commCd");
//		searchWorkYearE.setTriggerAction(TriggerAction.ALL);
//		searchWorkYearE.setEmptyText("--근속년수--");
//		searchWorkYearE.setSelectOnFocus(true);
//		searchWorkYearE.setStore(listStoreA007);
//		
//	    layoutContainer_18.add(searchWorkYearE, new FormData("100%"));
	    
	     searchBirthDateE = new DateField();
	     new DateFieldMask(searchBirthDateE, "9999.99.99");
		 searchBirthDateE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		 searchBirthDateE.setLabelSeparator("~");
		 layoutContainer_18.add(searchBirthDateE, new FormData("100%"));
	    
	     layoutContainer_14.add(layoutContainer_18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	    
	     layoutContainer_4.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
	    
	     LayoutContainer layoutContainer_15 = new LayoutContainer();
	     frmlytSch = new FormLayout();  
	     frmlytSch.setLabelWidth(70); 
	     frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	     layoutContainer_15.setLayout(frmlytSch);
	    
	     searchSexType = new ComboBox<BaseModel>();
         searchSexType.setFieldLabel("성 별");
         searchSexType.setForceSelection(true);
         searchSexType.setMinChars(1);
         searchSexType.setDisplayField("commCdNm");
         searchSexType.setValueField("commCd");
         searchSexType.setTriggerAction(TriggerAction.ALL);
         searchSexType.setEmptyText("--성별 선택--");
         searchSexType.setSelectOnFocus(true);
         searchSexType.setStore(listStoreA004);   
	  
	     layoutContainer_15.add(searchSexType, new FormData("100%"));
	     layoutContainer_4.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	     layoutContainer_15.setBorders(false);
	    
	     LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());
	     
	     
	     LayoutContainer layoutContainer_16_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_1.setLayout(frmlytSch);

		srhDeptGpCd = new ComboBox<BaseModel>();
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
	     
		layoutContainer_16_1.add(srhDeptGpCd, new FormData("100%"));	     
		layoutContainer_16.add(layoutContainer_16_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    
		
		
	     LayoutContainer layoutContainer_16_2 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16_2.setLayout(frmlytSch);
	    
	     srhTypOccuCd = new ComboBox<BaseModel>();
//	     srhTypOccuCd.setFieldLabel("직 종");
//	     srhTypOccuCd.setLabelSeparator("");
	     srhTypOccuCd.setHideLabel(true);
	     srhTypOccuCd.setForceSelection(true);
	     srhTypOccuCd.setMinChars(1);
	     srhTypOccuCd.setDisplayField("typOccuNm");
	     srhTypOccuCd.setValueField("typOccuCd");
	     srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
	     srhTypOccuCd.setEmptyText("--직종선택--");
	     srhTypOccuCd.setSelectOnFocus(true);
	     srhTypOccuCd.setStore(listStoreA041);
	     srhTypOccuCd.setName("srhTypOccuCd");
	     srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	     srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	     srhTypOccuCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	    	 public void handleEvent(StoreEvent<BaseModel> be) { 
	    		 //2015.11.30 추가 
	    		  if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(searchEmymtDivCd,"commCd"))) {
	    		 if (!gwtExtAuth.getEnableTypOccuCd()) {
	    			 BaseModel  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
//		            	if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//		            		for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//		            			ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//		            			if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//		            				mdSelect = tpMdSelect;
//		            			} 
//		                	}  
		                   
		    			   srhTypOccuCd.setValue(mdSelect);
		                   // }  
	    		 }  
	    		 }
             }
         }); 
	     srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	 public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	             
	            	//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
	    		    sysComBass0350Dto = new PrgmComBass0350DTO();
	    		    
//	            	sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
	            	sysComBass0350Dto.setDeptCd(srhDeptCd.getValue()); 
	                sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")); 
	                
//	    			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	    			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
//	    			
//	    			String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
//	                sysComBass0350Dto.setDeptCd(strDeptCd);
//	                
//	                List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
//	                String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
//	                sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
	                    
	                // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	                    
	                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
	                	
	                	//직종세 초기화
	                	srhDtilOccuInttnCd.getInitStore(); 
	                	srhDtilOccuInttnCd.setValue("");
	                	
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
	            } 
	        });	     
//		layoutContainer_16.add(srhTypOccuCd, new FormData("100%"));
	     layoutContainer_16_2.add(srhTypOccuCd, new FormData("100%"));	     
	     layoutContainer_16.add(layoutContainer_16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		
		layoutContainer_4.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer_16.setBorders(false);

		
		
		LayoutContainer layoutContainer_20 = new LayoutContainer();
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(0);
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_20.setLayout(frmlytSch);
	    
	     
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.setHideLabel(true);
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
//		srhDtilOccuInttnCd.setLabelSeparator("");
		srhDtilOccuInttnCd.setWidth(100);
		// srhDtilOccuInttnCd.setHideLabel(true);
//		srhDtilOccuInttnCd.setFieldLabel("직종세");
		srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,
				new Listener<ComponentEvent>() {
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
	  
	     layoutContainer_20.add(srhDtilOccuInttnCd, new FormData("100%"));
	    
	     layoutContainer_4.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	    
	     fieldSet2.add(layoutContainer_4);
	     
	     
	     
		LayoutContainer layoutContainer_77 = new LayoutContainer(new ColumnLayout());
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(70);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSch1_2.setLayout(frmlytSch);
	     
		LayoutContainer lcSch1_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_1.setLayout(frmlytSch);
		
		
		srhDateType = new ComboBox<BaseModel>();
		srhDateType.setName("srhDateType");
		srhDateType.setForceSelection(true);
		srhDateType.setMinChars(1);
		srhDateType.setDisplayField("commCdNm");
		srhDateType.setAllowBlank(false);
		srhDateType.setValueField("commCd");
		srhDateType.setTriggerAction(TriggerAction.ALL);
		srhDateType.setEmptyText("-- 기간 선택 --");
		srhDateType.setSelectOnFocus(true); 
		srhDateType.setFieldLabel("기간구분"); 
		srhDateType.setStore(lsDateType);
		srhDateType.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// TODO Auto-generated method stub
				// 기간 선택에 따라 날짜를 보여준다.
				
				if("S0010010".equals(MSFSharedUtils.getSelectedComboValue(srhDateType, "commCd"))) {		// 기간별
					
					lcSch1_2_3.hide();
					lcSch1_2_2.hide();
					lcSch1_2_1.show();
					
					setInitDate();	// 기간 셋팅
					
					
				}else if("S0010020".equals(MSFSharedUtils.getSelectedComboValue(srhDateType, "commCd"))) {	// 분기별
					
					lcSch1_2_3.hide();
					lcSch1_2_2.show();
					lcSch1_2_1.hide();
					
				}else if("S0010030".equals(MSFSharedUtils.getSelectedComboValue(srhDateType, "commCd"))) {	// 월별
					
					lcSch1_2_1.hide();
					lcSch1_2_3.show();
					lcSch1_2_2.hide();
					
					
				}else {
					
					lcSch1_2_3.hide();
					lcSch1_2_2.hide();
					lcSch1_2_1.show();
					
				}
			}
	    });
		srhDateType.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
//				SttsUtils.setSelectedComboValue(srhDateType, "S0010010", "commCd");
//				srhDateType.setValue(lsDateType.getAt(0));
			}
		});
		lcSch1_1.add(srhDateType, new FormData("100%"));
		
//		private LayoutContainer lcSch1_2_1 = new LayoutContainer(new ColumnLayout());	// 기간별
		layoutContainer_77.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		
		
		
		
		/****** 기간 *******/	    
		LayoutContainer lcSch1_2 = new LayoutContainer();
		FormLayout frmlytSch1_2 = new FormLayout();
//		frmlytSch1_2.setLabelWidth(60);
//		frmlytSch1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_2.setLayout(frmlytSch1_2);
		
		// 기간별
		lcSch1_2_1 = new LayoutContainer(new ColumnLayout());
//		FormLayout fl1_2_1  = new FormLayout();
//		lcSch1_2_1.setLayout(fl1_2_1);
		
		LayoutContainer lcSch1_2_1_S = new LayoutContainer();
    	FormLayout fl2_1 = new FormLayout();
      	fl2_1.setLabelWidth(40);
      	fl2_1.setLabelAlign(LabelAlign.RIGHT);
      	lcSch1_2_1_S.setLayout(fl2_1);
             
     	srhDayS = new DateField();
     	srhDayS.setName("srhDayS");
        new DateFieldMask(srhDayS, "9999.99.99"); 
        srhDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        srhDayS.setFieldLabel("기간");
        lcSch1_2_1_S.add(srhDayS, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_1_E = new LayoutContainer();
        FormLayout fl2_2 = new FormLayout();
        fl2_2.setLabelWidth(5);
        fl2_2.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_1_E.setLayout(fl2_2);
        
            
        srhDayE = new DateField();
        srhDayE.setName("srhDayE");
        new DateFieldMask(srhDayE, "9999.99.99"); 
        srhDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        srhDayE.setLabelSeparator("~");
//        srhDayE.setReadOnly(true);
//        srhDayE.setEnabled(true);
        lcSch1_2_1_E.add(srhDayE, new FormData("100%"));
            
        lcSch1_2_1.add(lcSch1_2_1_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
        lcSch1_2_1.add(lcSch1_2_1_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
        
//        lcSch1_2_1.show();
        lcSch1_2.add(lcSch1_2_1);
        
        
        
		// 분기별
        lcSch1_2_2 = new LayoutContainer(new ColumnLayout());
//        FormLayout fl1_2_2  = new FormLayout();
//        lcSch1_2_2.setLayout(fl1_2_2);
		
		LayoutContainer lcSch1_2_2_Y = new LayoutContainer();
    	FormLayout fl1_2_2_Y  = new FormLayout();
    	fl1_2_2_Y.setLabelWidth(40);
    	fl1_2_2_Y.setLabelAlign(LabelAlign.RIGHT);
    	lcSch1_2_2_Y.setLayout(fl1_2_2_Y);
             
    	srhYr02 = new ComboBox<BaseModel>();
    	srhYr02.setName("srhYr02");
    	srhYr02.setForceSelection(true);
    	srhYr02.setMinChars(1);
    	srhYr02.setDisplayField("yearDisp");
    	srhYr02.setValueField("year");
    	srhYr02.setTriggerAction(TriggerAction.ALL);
    	srhYr02.setEmptyText("-- 년도선택 --");
    	srhYr02.setSelectOnFocus(true); 
    	srhYr02.setStore(lsYrStore);  
    	srhYr02.setFieldLabel("년도");
    	srhYr02.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {    
				EventType type = be.getType();
				if (type == Store.Add) { 
//					srhYr02.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
				}
			}
    	});
		lcSch1_2_2_Y.add(srhYr02, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_2_M_S = new LayoutContainer();
        FormLayout fl1_2_2_M_S = new FormLayout();
        fl1_2_2_M_S.setLabelWidth(30);
        fl1_2_2_M_S.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_2_M_S.setLayout(fl1_2_2_M_S);
        
        srhMnthS = new ComboBox<BaseModel>();
        srhMnthS.setName("srhMnthS");
        srhMnthS.setForceSelection(true);
        srhMnthS.setMinChars(1);
        srhMnthS.setDisplayField("monthDisp");
        srhMnthS.setValueField("month");
        srhMnthS.setTriggerAction(TriggerAction.ALL);
        srhMnthS.setEmptyText("-- 년도선택 --");
        srhMnthS.setSelectOnFocus(true); 
        srhMnthS.setStore(lsMonthStore);  
        srhMnthS.setFieldLabel("월");
        srhMnthS.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {    
				EventType type = be.getType();
				if (type == Store.Add) { 
//					srhMnthS.setValue(lsMonthStore.findModel("month", DateTimeFormat.getFormat("MM").format(new Date()))); 	
				}
			}
    	});
        srhMnthS.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		// 시작월에 따라 마감월 변경
        		String strMon_S = MSFSharedUtils.getSelectedComboValue(srhMnthS, "month");
        		
        		// 1분기 시작월, 마감월 고정
        		if ("01".equals(strMon_S) || "02".equals(strMon_S) || "03".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "01"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "03"));
        			
        			month.setValue("02");
        			
        		// 2분기 시작월, 마감월 고정	
        		} else  if ("04".equals(strMon_S) || "05".equals(strMon_S) || "06".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "04"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "06"));
        			
        			month.setValue("05");
        			
        		// 3분기 시작월, 마감월 고정		
        		}  else  if ("07".equals(strMon_S) || "08".equals(strMon_S) || "09".equals(strMon_S)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "07"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "09"));
        			
        			month.setValue("08");
        			
        		// 4분기 시작월, 마감월 고정			
        		} else  if ("10".equals(strMon_S) || "11".equals(strMon_S) || "12".equals(strMon_S)) {
         			
         			srhMnthS.setValue(lsMonthStore.findModel("month", "10"));
         			srhMnthE.setValue(lsMonthStore.findModel("month", "12"));
         			
         			month.setValue("11");
         			
         		} 
        		
        	} 
        });
    	lcSch1_2_2_M_S.add(srhMnthS, new FormData("100%"));
    	
    	
      	LayoutContainer lcSch1_2_2_M_E = new LayoutContainer();
        FormLayout fl1_2_2_M_E = new FormLayout();
        fl1_2_2_M_E.setLabelWidth(5);
        fl1_2_2_M_E.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_2_M_E.setLayout(fl1_2_2_M_E);
        
        srhMnthE = new ComboBox<BaseModel>();
        srhMnthE.setName("srhMnthE");
        srhMnthE.setForceSelection(true);
        srhMnthE.setMinChars(1);
        srhMnthE.setDisplayField("monthDisp");
        srhMnthE.setValueField("month");
    	srhMnthE.setTriggerAction(TriggerAction.ALL);
//    	srhMnthE.setEmptyText("-- 년도선택 --");
    	srhMnthE.setSelectOnFocus(true); 
    	srhMnthE.setStore(lsMonthStore);  
    	srhMnthE.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		// 시작월에 따라 마감월 변경
        		String strMon_E = MSFSharedUtils.getSelectedComboValue(srhMnthE, "month");
        		
        		// 1분기 시작월, 마감월 고정
        		if ("01".equals(strMon_E) || "02".equals(strMon_E) || "03".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "01"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "03"));
        			
        		// 2분기 시작월, 마감월 고정	
        		} else  if ("04".equals(strMon_E) || "05".equals(strMon_E) || "06".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "04"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "06"));
        			
        		// 3분기 시작월, 마감월 고정		
        		}  else  if ("07".equals(strMon_E) || "08".equals(strMon_E) || "09".equals(strMon_E)) {
        			
        			srhMnthS.setValue(lsMonthStore.findModel("month", "07"));
        			srhMnthE.setValue(lsMonthStore.findModel("month", "09"));
        			
        		// 4분기 시작월, 마감월 고정			
        		} else  if ("10".equals(strMon_E) || "11".equals(strMon_E) || "12".equals(strMon_E)) {
         			
         			srhMnthS.setValue(lsMonthStore.findModel("month", "10"));
         			srhMnthE.setValue(lsMonthStore.findModel("month", "12"));
         			
         		} 
        		
        	} 
        });
    	srhMnthE.setLabelSeparator("~");
    	lcSch1_2_2_M_E.add(srhMnthE, new FormData("100%"));
            
        lcSch1_2_2.add(lcSch1_2_2_Y, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.44));
        lcSch1_2_2.add(lcSch1_2_2_M_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
        lcSch1_2_2.add(lcSch1_2_2_M_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
        
        lcSch1_2.add(lcSch1_2_2);
        
        
    	// 월별
        lcSch1_2_3 = new LayoutContainer(new ColumnLayout());
//        FormLayout fl1_2_3  = new FormLayout();
//        lcSch1_2_3.setLayout(fl1_2_3);
		
		LayoutContainer lcSch1_2_3_S = new LayoutContainer();
    	FormLayout fl1_2_3_S  = new FormLayout();
    	fl1_2_3_S.setLabelWidth(40);
    	fl1_2_3_S.setLabelAlign(LabelAlign.RIGHT);
      	lcSch1_2_3_S.setLayout(fl1_2_3_S);
             
    	srhYr01 = new ComboBox<BaseModel>();
    	srhYr01.setName("srhYr");
    	srhYr01.setForceSelection(true);
    	srhYr01.setMinChars(1);
    	srhYr01.setDisplayField("yearDisp");
    	srhYr01.setValueField("year");
    	srhYr01.setTriggerAction(TriggerAction.ALL);
    	srhYr01.setEmptyText("-- 년도선택 --");
    	srhYr01.setSelectOnFocus(true); 
    	srhYr01.setStore(lsYrStore);  
    	srhYr01.setFieldLabel("년도");
    	srhYr01.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {    
        		EventType type = be.getType();
        		if (type == Store.Add) { 
//        			 srhYr01.setValue(lsYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date()))); 	//월별 년도
        		}
        	}
        });
        lcSch1_2_3_S.add(srhYr01, new FormData("100%"));
            
      	LayoutContainer lcSch1_2_3_E = new LayoutContainer();
        FormLayout fl1_2_3_E = new FormLayout();
        fl1_2_3_E.setLabelWidth(30);
        fl1_2_3_E.setLabelAlign(LabelAlign.RIGHT);
        lcSch1_2_3_E.setLayout(fl1_2_3_E);
        
    	srhMnth = new ComboBox<BaseModel>();
    	srhMnth.setName("srhMnth");
    	srhMnth.setForceSelection(true);
    	srhMnth.setMinChars(1);
    	srhMnth.setDisplayField("monthDisp");
    	srhMnth.setValueField("month");
    	srhMnth.setTriggerAction(TriggerAction.ALL);
    	srhMnth.setEmptyText("-- 년도선택 --");
    	srhMnth.setSelectOnFocus(true); 
    	srhMnth.setStore(lsMonthStore);  
    	srhMnth.setFieldLabel("월");
    	srhMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        	public void handleEvent(StoreEvent<BaseModel> be) {    
        		EventType type = be.getType();
        		if (type == Store.Add) { 
//        			 srhMnth.setValue(lsMonthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
        		}
        	}
        });
        lcSch1_2_3_E.add(srhMnth, new FormData("100%"));
            
        lcSch1_2_3.add(lcSch1_2_3_S, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
        lcSch1_2_3.add(lcSch1_2_3_E, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        
        lcSch1_2.add(lcSch1_2_3);
        layoutContainer_77.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
        fieldSet2.add(layoutContainer_77);
//		layoutContainer111.add(fieldSet2);
//		cpPsnl0600.add(layoutContainer111);
		
		LayoutContainer layoutContainer112 = new LayoutContainer();
		
		tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab
		/*
		tabsPsnl.addListener(Events.Select, new Listener<TabPanelEvent>() {
			@Override
			public void handleEvent(TabPanelEvent be) {
				if("itemPsnl0600".equals(tabsPsnl.getSelectedItem().getId())){
					loaderPsnl0600.load();
				}else if("itemPsnl0112".equals(tabsPsnl.getSelectedItem().getId())){
					loaderPsnl0112.load();
				}else if("itemPsnl0114".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0116".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0119".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0118".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0120".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0121".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0122".equals(tabsPsnl.getSelectedItem().getId())){
					
				}else if("itemPsnl0123".equals(tabsPsnl.getSelectedItem().getId())){
					
				}
			}
			
		});
		*/
		
		// tabsPsnl.setMinTabWidth(80);
		tabsPsnl.setAutoWidth(false);
		// tabsPsnl.setResizeTabs(true);
		tabsPsnl.setAnimScroll(true);
		tabsPsnl.setTabScroll(true);
		tabsPsnl.setPlain(true);
		tabsPsnl.setSize(920, 280);

//		TabItem itemPsnl0600 = new TabItem();
////		itemPsnl0600.setStyleAttribute("padding", "10px");
//		itemPsnl0600.setText(" 기 본 ");
//		itemPsnl0600.addStyleName("pad-text");
//		itemPsnl0600.setLayout(new FormLayout());
//		itemPsnl0600.setId("itemPsnl0600");
//		itemPsnl0600.add(StdData01(), new FormData("100%"));
//		tabsPsnl.add(itemPsnl0600);


		TabItem itemPsnl0112 = new TabItem();
//		itemPsnl0112.setStyleAttribute("padding", "10px");
		itemPsnl0112.setText(" 병 역 ");
		itemPsnl0112.setLayout(new FormLayout());
		itemPsnl0112.setId("itemPsnl0112");
		itemPsnl0112.add(PersonalMilitary01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0112);


		TabItem itemPsnl0114 = new TabItem();
//		itemPsnl0114.setStyleAttribute("padding", "10px");
		itemPsnl0114.setText(" 단 체 ");
		itemPsnl0114.setId("itemPsnl0114");
		itemPsnl0114.setLayout(new FormLayout());
		itemPsnl0114.add(PersonalGroup01(), new FormData("100%"));

		tabsPsnl.add(itemPsnl0114);


		TabItem itemPsnl0116 = new TabItem();
//		itemPsnl0116.setStyleAttribute("padding", "10px");
		itemPsnl0116.setText(" 학 력 ");
		itemPsnl0116.setId("itemPsnl0116");
		itemPsnl0116.setLayout(new FormLayout());
		itemPsnl0116.add(PersonalAcademicAbility01(), new FormData("100%"));

		tabsPsnl.add(itemPsnl0116);

		TabItem itemPsnl0119 = new TabItem();
//		itemPsnl0119.setStyleAttribute("padding", "10px");
		itemPsnl0119.setText(" 경 력 ");
		itemPsnl0119.setId("itemPsnl0119");
		itemPsnl0119.setLayout(new FormLayout());
		itemPsnl0119.add(PersonalTemp01(), new FormData("100%"));

		tabsPsnl.add(itemPsnl0119);

		TabItem itemPsnl0118 = new TabItem();
//		itemPsnl0118.setStyleAttribute("padding", "10px");
		itemPsnl0118.setText(" 자 격 ");
		itemPsnl0118.setId("itemPsnl0118");
		itemPsnl0118.setLayout(new FormLayout());
		itemPsnl0118.add(PersonalTemp02(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0118);


		TabItem itemPsnl0120 = new TabItem();
//		itemPsnl0120.setStyleAttribute("padding", "10px");
		itemPsnl0120.setText(" 교 육 ");
		itemPsnl0120.setId("itemPsnl0120");
		itemPsnl0120.setLayout(new FormLayout());
		itemPsnl0120.add(PersonalTemp04(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0120);

//		TabItem itemPsnl0121 = new TabItem();
////		itemPsnl0121.setStyleAttribute("padding", "10px");
//		itemPsnl0121.setText(" 포 상 ");
//		itemPsnl0121.setId("itemPsnl0121");
//		itemPsnl0121.setLayout(new FormLayout());
//		itemPsnl0121.add(PersonalTemp05(), new FormData("100%"));
//		tabsPsnl.add(itemPsnl0121);

		TabItem itemPsnl0122 = new TabItem();
//		itemPsnl0122.setStyleAttribute("padding", "10px");
		itemPsnl0122.setText(" 징 계 ");
		itemPsnl0122.setId("itemPsnl0122");
		itemPsnl0122.setLayout(new FormLayout());
		itemPsnl0122.add(PersonalTemp06(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0122);

		TabItem itemPsnl0123 = new TabItem();
//		itemPsnl0123.setStyleAttribute("padding", "10px");
		itemPsnl0123.setText(" 휴 직 ");
		itemPsnl0123.setId("itemPsnl0123");
		itemPsnl0123.setLayout(new FormLayout());
		itemPsnl0123.add(PersonalTemp07(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0123);

		layoutContainer112.add(tabsPsnl, new FormData("100%"));
		
		fieldSet2.add(layoutContainer112);
		layoutContainer111.add(fieldSet2);
		
		cpPsnl0600.add(layoutContainer111);
//		cpPsnl0600.add(layoutContainer112);
		
		
		
//		ContentPanel panel = new ContentPanel();
//		panel.setStyleAttribute("paddingLeft"	, "10px");
//		panel.setStyleAttribute("paddingRight"	, "10px");
//		panel.setBodyBorder(false);
//		panel.setBorders(false);
//		panel.setHeaderVisible(false);
//		panel.setScrollMode(Scroll.AUTO);
//		panel.add(layoutContainer111);
//		
//		cpPsnl0600.add(panel);
		
	}
	  
			
	// 폼초기화 검색조건포함
	private void formInit() {

		actionDatabase = ActionDatabase.READ;

	}
	
	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
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
                	srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                	srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                    srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                    srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                    payrMangDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("payrMangDeptCd"))); 
                    srhDeptCd.fireEvent(Events.Add);
                }  
            }
        });
    }
	
	// 학교
	private void fnPopupBass0300(final String itemValue) {
		MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통  
	       
		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
	      
		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("commCd"))) { 
//					if ("A001".equals(itemValue)) {
//						//국적
//						//코드값 및 버튼 텍스트 변경.
//            			searchSchlCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
//            			searchSchlCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
//					} else 
					if("A027".equals(itemValue) ) {
						//코드값 및 버튼 텍스트 변경.
	            		searchDeprMajrCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
	            		searchDeprMajrCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
					}else if("A032".equals(itemValue) || "A033".equals(itemValue) 
								|| "A034".equals(itemValue) || "A035".equals(itemValue)){
						//코드값 및 버튼 텍스트 변경.
            			searchSchlCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCd")));
            			searchSchlCdNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
					}
				}   
			}
		});
	}
	

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	private void psnl0600Init() {
		
	}
	
	
	// 기간 셋팅
	private void setInitDate() {
		   
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		
		String strYr = DateTimeFormat.getFormat("yyyy").format(new Date());
		
		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.set (Integer.parseInt(strYr), monthS -1, 1);
		srhDayS.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH);  
	       
	      
		Calendar  intieCal =   Calendar.getInstance();
	    intieCal.set (Integer.parseInt(strYr), monthE - 1, maxDays );
	    srhDayE.setValue(intieCal.getTime());
	    
	}
	
	
    private PsnlP060001 getThis() {
		return this;
	}
	
	
    
    /** 하위 탭 조건 시작 **/
	// 병역
	private LayoutContainer PersonalMilitary01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(920, 100);
		cp01.setLayout(new FitLayout());


		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);

		// TODO 병역 검색시작
		searchDsageDivCd = new ComboBox<BaseModel>();
		searchDsageDivCd.setFieldLabel("제대구분");
		searchDsageDivCd.setForceSelection(true);
		searchDsageDivCd.setMinChars(1);
		searchDsageDivCd.setDisplayField("commCdNm");
		searchDsageDivCd.setValueField("commCd");
		searchDsageDivCd.setTriggerAction(TriggerAction.ALL);
		searchDsageDivCd.setEmptyText("--제대구분선택--");
		searchDsageDivCd.setSelectOnFocus(true);
		searchDsageDivCd.setStore(listStoreA025);
		
		layoutContainer_7.add(searchDsageDivCd, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		layoutContainer_6.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);

		
		searchDsageDtS = new DateField();
		new DateFieldMask(searchDsageDtS, "9999.99.99");
		searchDsageDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsageDtS.setFieldLabel("제대일자");
		layoutContainer_9.add(searchDsageDtS, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchDsageDtE = new DateField();
		new DateFieldMask(searchDsageDtE, "9999.99.99");
		searchDsageDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsageDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchDsageDtE, new FormData("100%"));
		layoutContainer_6.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);

		searchBaggrpCd = new ComboBox<BaseModel>();
		searchBaggrpCd.setFieldLabel(" 군별");
		searchBaggrpCd.setForceSelection(true);
		searchBaggrpCd.setMinChars(1);
		searchBaggrpCd.setDisplayField("commCdNm");
		searchBaggrpCd.setValueField("commCd");
		searchBaggrpCd.setTriggerAction(TriggerAction.ALL);
		searchBaggrpCd.setEmptyText("--군별선택--");
		searchBaggrpCd.setSelectOnFocus(true);
		searchBaggrpCd.setStore(listStoreA023);
		
		layoutContainer_8.add(searchBaggrpCd, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		layoutContainer_8.setBorders(false);
		fieldSet.add(layoutContainer_5, new FormData("100%"));
		layoutContainer_5.setBorders(false);

		searchAbotsCd = new ComboBox<BaseModel>();
		searchAbotsCd.setFieldLabel("병과");
		searchAbotsCd.setForceSelection(true);
		searchAbotsCd.setMinChars(1);
		searchAbotsCd.setDisplayField("commCdNm");
		searchAbotsCd.setValueField("commCd");
		searchAbotsCd.setTriggerAction(TriggerAction.ALL);
		searchAbotsCd.setEmptyText("--병과선택--");
		searchAbotsCd.setSelectOnFocus(true);
		searchAbotsCd.setStore(listStoreA024);
		layoutContainer_3.add(searchAbotsCd, new FormData("100%"));

		searchClsCd = new ComboBox<BaseModel>();
		searchClsCd.setFieldLabel("계급");
		searchClsCd.setForceSelection(true);
		searchClsCd.setMinChars(1);
		searchClsCd.setDisplayField("commCdNm");
		searchClsCd.setValueField("commCd");
		searchClsCd.setTriggerAction(TriggerAction.ALL);
		searchClsCd.setEmptyText("--계급선택--");
		searchClsCd.setSelectOnFocus(true);
		searchClsCd.setStore(listStoreA045);
		
		layoutContainer_4.add(searchClsCd, new FormData("100%"));
		
		
		fieldSet.add(layoutContainer_2);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);
//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		
		lcTabFormLayer.add(lcTabCol02);
		
		return lcTabFormLayer;
	}
	
	
	

	
	// TODO 단체 시작
	private LayoutContainer PersonalGroup01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
//		cp01.setSize(968, 500);
//		cp01.setLayout(new FitLayout());

		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		searchJnOpztnNm = new TextField<String>();
		searchJnOpztnNm.setFieldLabel("단체명");
		layoutContainer_3.add(searchJnOpztnNm, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchJnDtS = new DateField();
		new DateFieldMask(searchJnDtS, "9999.99.99");
		searchJnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchJnDtS.setFieldLabel("가입기간");
		layoutContainer_9.add(searchJnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchJnDtE = new DateField();
		new DateFieldMask(searchJnDtE, "9999.99.99");
		searchJnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchJnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchJnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		
		lcTabFormLayer.add(lcTabCol02);
		
		return lcTabFormLayer;

	}

	

	// TODO 학력 시작
	private LayoutContainer PersonalAcademicAbility01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		LayoutContainer lcTabCol02 = new LayoutContainer();

//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
////		cp01.setSize(968, 463);
//		cp01.setSize(968, 500);
//		cp01.setLayout(new FlowLayout());

		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);
		
		
		searchAcadAbtyDivCd = new ComboBox<BaseModel>();
		searchAcadAbtyDivCd.setFieldLabel("학력구분");
		searchAcadAbtyDivCd.setForceSelection(true);
		searchAcadAbtyDivCd.setMinChars(1);
		searchAcadAbtyDivCd.setDisplayField("commCdNm");
		searchAcadAbtyDivCd.setValueField("commCd");
		searchAcadAbtyDivCd.setTriggerAction(TriggerAction.ALL);
		searchAcadAbtyDivCd.setEmptyText("--학력구분선택--");  
		searchAcadAbtyDivCd.setSelectOnFocus(true);
		searchAcadAbtyDivCd.setStore(listStoreA026);
		searchAcadAbtyDivCd.addListener(Events.Valid, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				searchSchlCd.setValue("");
				searchDeprMajrCd.setValue("");
				if(searchAcadAbtyDivCd.getValue() == null){
					searchSchlCdNm.setEmptyText("--학력선택--");
					searchDeprMajrCdNm.setEmptyText("--학력선택--");
				}else{
					searchSchlCdNm.setEmptyText("--학교선택--");
					searchDeprMajrCdNm.setEmptyText("--학과선택--");
				}
			}
		});
		searchAcadAbtyDivCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
       	 	public void handleEvent(BaseEvent be) {
				
				// 학력구분을 해당없음으로 선택하였을 경우 조건에 있는 학교, 학과, 학위를 초기화 해줌.
				if("A0260000".equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd")))) {
					
					searchDeprMajrCd.setValue("");
            		searchDeprMajrCdNm.setValue("");
        			searchSchlCd.setValue("");
        			searchSchlCdNm.setValue("");
        			searchDegrDivCd.setValue(new BaseModel());
        			
				}
       	 	}
		});
		
		
		
		layoutContainer_7.add(searchAcadAbtyDivCd, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		layoutContainer_5.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		layoutContainer_3.setBorders(false);
		
		
		
		searchSchlCd = new TextField<String>();
		searchDeprMajrCd = new TextField<String>();
		
		searchSchlCdNm = new TextField<String>();
		searchSchlCdNm.setFieldLabel("학교");
		searchSchlCdNm.setEmptyText("--학력선택--");
		searchSchlCdNm.setReadOnly(true);
		searchSchlCdNm.addListener(Events.OnFocus, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {
				Lov lov;     
				LovLiveGeneric lovWindow; 
				MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 900, 50);
				MSFCustomForm sysCom0130Form = customForm.getCustomForm();    
				MSFFormPanel comform = (MSFFormPanel)sysCom0130Form;
				final FormBinding popBindingInner = comform.getFormBinding();
				
				customForm.setLov(new PrgmComP0130());
				lov = customForm.getLov();   
				
				//학교구분의 선택에 따라..
//				String schType= searchAcadAbtyDivCd.getValue() == null ? "" : String.valueOf(searchAcadAbtyDivCd.getValue().get("commCd"));
				String schType = MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd"));
				
				if(schType != null && !"".equals(schType)) {
					
					String sch = schType.substring(schType.length()-2,schType.length()-1);
					if("2".equals(sch)){
						sch = "A031";
					}else if("3".equals(sch)){
						sch = "A032";
					}else if("4".equals(sch)){
						sch = "A033";
					}else if("5".equals(sch)){
						sch = "A034";
					}else if("6".equals(sch)){
						sch = "A035";
					}else{
						sch = "";
					}
					
					fnPopupBass0300(sch);
					
				}else{
					MessageBox.alert("", "학력구분을 선택하여주세요.", null);
				}
			}
		
		});
		
		layoutContainer_3.add(searchSchlCdNm, new FormData("100%"));

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
		
		
		searchDeprMajrCdNm = new TextField<String>();
		searchDeprMajrCdNm.setFieldLabel("학과");
		searchDeprMajrCdNm.setEmptyText("--학력선택--");  
		searchDeprMajrCdNm.setReadOnly(true);
		searchDeprMajrCdNm.addListener(Events.OnFocus, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				// 학교구분의 선택에 따라..
				String schType = MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchAcadAbtyDivCd,"commCd"));
				
				if(schType != null && !"".equals(schType)) {
					
					String sch = schType.substring(schType.length()-2,schType.length()-1);
					
					if("4".equals(sch) || "5".equals(sch) || "6".equals(sch) ){
						sch = "A027";
					}else{
						sch = "";
					}
					
					fnPopupBass0300(sch);
					
				}else{
					MessageBox.alert("", "학력구분을 선택하여주세요.", null);
				}			
				
			}
		});
		
		layoutContainer_8.add(searchDeprMajrCdNm, new FormData("100%"));
		
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setBorders(false);
		layoutContainer_5.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
		layoutContainer_4.setStyleAttribute("paddingRight", "10px");
		
		
		searchDegrDivCd = new ComboBox<BaseModel>();
		searchDegrDivCd.setFieldLabel("학위");
		searchDegrDivCd.setForceSelection(true);
		searchDegrDivCd.setMinChars(1);
		searchDegrDivCd.setDisplayField("commCdNm");
		searchDegrDivCd.setValueField("commCd");
		searchDegrDivCd.setTriggerAction(TriggerAction.ALL);
		searchDegrDivCd.setEmptyText("--학위선택--");  
		searchDegrDivCd.setSelectOnFocus(true);
		searchDegrDivCd.setStore(listStoreA028);
		
		layoutContainer_4.add(searchDegrDivCd, new FormData("100%"));
		
		fieldSet.add(layoutContainer_5, new FormData("100%"));
		layoutContainer.add(fieldSet);
		lcTabCol02.add(layoutContainer);

//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(lcTabCol02);
		
		return lcTabFormLayer;

	}

	// TODO 경력시작
	private LayoutContainer PersonalTemp01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
////		cp01.setSize(968, 463);
//		cp01.setSize(968, 500);
//		cp01.setLayout(new FitLayout());

		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		searchPaeWorkNm = new TextField<String>();
		searchPaeWorkNm.setFieldLabel("근무처명");
		layoutContainer_3.add(searchPaeWorkNm, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchCarrBgnnDtS = new DateField();
		new DateFieldMask(searchCarrBgnnDtS, "9999.99.99");
		searchCarrBgnnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchCarrBgnnDtS.setFieldLabel("근무시작일");
		layoutContainer_9.add(searchCarrBgnnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchCarrBgnnDtE = new DateField();
		new DateFieldMask(searchCarrBgnnDtE, "9999.99.99");
		searchCarrBgnnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchCarrBgnnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchCarrBgnnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(lcTabCol02);
		
		return lcTabFormLayer;

	}

	// TODO 자격시작
	private LayoutContainer PersonalTemp02() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
//		cp01.setSize(968, 500);
////		cp01.setSize(968, 463);
//		cp01.setLayout(new FitLayout());


		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		searchQftntLicnsPovncCtnt = new TextField<String>();
		searchQftntLicnsPovncCtnt.setFieldLabel("자격면허");
		layoutContainer_3.add(searchQftntLicnsPovncCtnt, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchAqtnDtS = new DateField();
		new DateFieldMask(searchAqtnDtS, "9999.99.99");
		searchAqtnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchAqtnDtS.setFieldLabel("취득일자");
		layoutContainer_9.add(searchAqtnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchAqtnDtE = new DateField();
		new DateFieldMask(searchAqtnDtE, "9999.99.99");
		searchAqtnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchAqtnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchAqtnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);

//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(lcTabCol02);
		return lcTabFormLayer;

	}

	

	// TODO 교육 시작
	private LayoutContainer PersonalTemp04() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
////		cp01.setSize(968, 463);
//		cp01.setSize(968, 500);
//		cp01.setLayout(new FitLayout());

		

		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
		
		
		
		
		searchEduKndNm = new TextField<String>();
		searchEduKndNm.setFieldLabel("교육종류");
		layoutContainer_3.add(searchEduKndNm, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		
		searchEduBgnnDtS = new DateField();
		new DateFieldMask(searchEduBgnnDtS, "9999.99.99");
		searchEduBgnnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchEduBgnnDtS.setFieldLabel("교육시작기간");
		layoutContainer_9.add(searchEduBgnnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchEduBgnnDtE = new DateField();
		new DateFieldMask(searchEduBgnnDtE, "9999.99.99");
		searchEduBgnnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchEduBgnnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchEduBgnnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);


//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(lcTabCol02);
		
		return lcTabFormLayer;

	}


	// TODO 징계시작
	private LayoutContainer PersonalTemp06() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
////		cp01.setSize(968, 463);
//		cp01.setSize(968, 500);
//		cp01.setLayout(new FitLayout());


		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		
		searchDsnyActDivCd = new ComboBox<BaseModel>();
		searchDsnyActDivCd.setFieldLabel("징계구분");
		searchDsnyActDivCd.setForceSelection(true);
		searchDsnyActDivCd.setMinChars(1);
		searchDsnyActDivCd.setDisplayField("commCdNm");
		searchDsnyActDivCd.setValueField("commCd");
		searchDsnyActDivCd.setTriggerAction(TriggerAction.ALL);
		searchDsnyActDivCd.setEmptyText("--징계구분선택--");
		searchDsnyActDivCd.setSelectOnFocus(true);
		searchDsnyActDivCd.setStore(listStoreA011);
		
		layoutContainer_3.add(searchDsnyActDivCd, new FormData("100%"));

		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		searchDsnyActDsplDtS = new DateField();
		new DateFieldMask(searchDsnyActDsplDtS, "9999.99.99");
		searchDsnyActDsplDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsnyActDsplDtS.setFieldLabel("징계처분일");
		layoutContainer_9.add(searchDsnyActDsplDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchDsnyActDsplDtE = new DateField();
		new DateFieldMask(searchDsnyActDsplDtE, "9999.99.99");
		searchDsnyActDsplDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchDsnyActDsplDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchDsnyActDsplDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);


//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(lcTabCol02);
		
		return lcTabFormLayer;

	}

	// TODO 휴직관리 시작
	private LayoutContainer PersonalTemp07() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		
		LayoutContainer lcTabCol02 = new LayoutContainer(new FormLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
////		cp01.setSize(968, 463);
//		cp01.setSize(968, 500);
//		cp01.setLayout(new FitLayout());

		
		LayoutContainer layoutContainer = new LayoutContainer();
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);

		
		searchLevfAbncDivCd = new ComboBox<BaseModel>();
		searchLevfAbncDivCd.setFieldLabel("휴직구분");
		searchLevfAbncDivCd.setForceSelection(true);
		searchLevfAbncDivCd.setMinChars(1);
		searchLevfAbncDivCd.setDisplayField("commCdNm");
		searchLevfAbncDivCd.setValueField("commCd");
		searchLevfAbncDivCd.setTriggerAction(TriggerAction.ALL);
		searchLevfAbncDivCd.setEmptyText("--휴직구분선택--");
		searchLevfAbncDivCd.setSelectOnFocus(true);
		searchLevfAbncDivCd.setStore(listStoreB014);
		
		layoutContainer_3.add(searchLevfAbncDivCd, new FormData("100%"));

		layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);
		searchLevfAbncBgnnDtS = new DateField();
		new DateFieldMask(searchLevfAbncBgnnDtS, "9999.99.99");
		searchLevfAbncBgnnDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchLevfAbncBgnnDtS.setFieldLabel("휴직기간");
		layoutContainer_9.add(searchLevfAbncBgnnDtS, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_4.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		searchLevfAbncBgnnDtE = new DateField();
		new DateFieldMask(searchLevfAbncBgnnDtE, "9999.99.99");
		searchLevfAbncBgnnDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchLevfAbncBgnnDtE.setLabelSeparator("~");
		layoutContainer_10.add(searchLevfAbncBgnnDtE, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_10.setBorders(false);

		layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_4.setBorders(false);

		fieldSet.add(layoutContainer_2);
		layoutContainer.add(fieldSet, new FormData("100%"));
		lcTabCol02.add(layoutContainer);


//		cp01.add(lcTabCol02);
//		lcTabFormLayer.add(cp01);
		
		lcTabFormLayer.add(lcTabCol02);
		
		return lcTabFormLayer;

	}

	
	
}
