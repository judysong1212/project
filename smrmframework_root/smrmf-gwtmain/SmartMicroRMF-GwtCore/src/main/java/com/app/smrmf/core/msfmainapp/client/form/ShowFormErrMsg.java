/**
 * 사용자에러상세정보
 */
package com.app.smrmf.core.msfmainapp.client.form;
  

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.service.SysmP330002Service;
import com.app.smrmf.core.msfmainapp.client.service.SysmP330002ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysIfComPopupUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysIfComboUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;

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
import com.extjs.gxt.ui.client.js.JsUtil;
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
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
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
public  class ShowFormErrMsg   extends MSFFormPanel {  

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
 
	private  ContentPanel cpSysmP330002; 
	  
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

    
   /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 상태처리 전역변수
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	private ActionDatabase actionDatabase;
	 private ShowMessageBM showMessagePlrlt;
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
	
	private ButtonBar topSysmP330002Bar;
	private Button btnSysmP330002Srh;
	private Button btnSysmP330002Excel;
       

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

	private HiddenField<String> srhSystemkey;   		// 시스템키 
	
	private ComboBox<BaseModel> srhDataType;			// 조회구분
    private DateField srhDay;      						// 시작일
    
	private ComboBox<BaseModel> srhHourS;				// 시작시간
	private ComboBox<BaseModel> srhMinuteS;				// 시작분
	private ComboBox<BaseModel> srhHourE;				// 시작시간
	private ComboBox<BaseModel> srhMinuteE;				// 시작분
	
	private TextField<String> strWindowNm;				// 화면명
	private TextField<String> strWindowId;				// 화면아이디

	private MSFMultiComboBox<ModelData> srhDeptCd; 		// 부서
	
	private TextField<String> srhUsrNm;					// 성명
	private TextField<String> srhUsrId; 				// 아이디
	
	
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	

 	private TextArea strErrEthdNm;						// 에러 메소드명
 	private TextArea strErrNm;							// 에러명
 	private TextArea strErrCtnt;						// 에러내용
 	
 	private TextField<String> dataCnt;					// 데이터 건수
 	private TextField<String> nDataCnt;					// 데이터 건수
 	
 	private Button btnBefore;							// 이전 버튼
 	private Button btnNext;								// 다음 버튼	
	private List<ModelData> mDtalistDeptCd;				// 부서 멀티	
	
	private ArrayList<SysIfHist0300DTO> hist0300List = new ArrayList<SysIfHist0300DTO>();

	private boolean mutilCombo = false;
	
	private HiddenField<String> dpobCd;					// 사업장코드
	
	
 	private HiddenField<String> deptNm; 				// 부서
 	private HiddenField<String> windowNm;				// 화면명
 	private HiddenField<String> windowIn;				// 화면아이디
 	private HiddenField<String> usrNm;					// 성명
 	private HiddenField<String> usrId;					// 아이디
 	private HiddenField<String> errOccrrncDtntm;		// 에러발생일시
 	private HiddenField<String> errEthdNm;				// 에러 메소드명
 	private HiddenField<String> errNm;					// 에러명
 	private HiddenField<String> errCtnt;				// 에러내용
 	private HiddenField<String> systemkey;				// 시스템키
 	
 	private int iCnt = 0;
 	private int iData = 1;
 	

      
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
	    // -------------- store 선언 시작 ---------------
		private ListStore<BaseModel> lsDataType 	    = new ListStore<BaseModel>();		// 조회구분콤보
		private ListStore<BaseModel> lsHour 	    	= new ListStore<BaseModel>();		// 시
		private ListStore<BaseModel> lsMinute 	    	= new ListStore<BaseModel>();		// 분
		private ListStore<BaseModel> lsDeptCd 		    = new ListStore<BaseModel>();		// 부서콤보
		private ListStore<BaseModel> lsUsrCd 		    = new ListStore<BaseModel>();		// 사용자콤보
		// -------------- store 선언 종료 ---------------
	    
	    
		// -------------- DTO 선언 시작 --------------
		private SysIfBass0300DTO sysIfBass0300Dto; 		//공통코드 dto
		private SysIfBass0400DTO sysIfBass0400Dto; 		//부서코드
	    // -------------- DTO 선언 종료 --------------
	    
		// -------------- grid 선언 시작  ---------------
//	 	private SysmIfHist0300Def hist0300Def  = new SysmIfHist0300Def("");   //그리드 테이블 컬럼 define  
//	 	private MSFGridPanel hist0300GridPanel;
	 	// -------------- grid 선언 종료  ---------------
	    
		private SysmP330002ServiceAsync sysmP330002Service = SysmP330002Service.Util.getInstance();
	    
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
		  	private void checkHistP030002Auth( String authAction, ListStore<BaseModel>bm) {
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
				 Field<?>[] fldArrField = {srhDeptCd};
				 gwtAuthorization.formAuthFieldConfig(fldArrField);
				 
				 srhDataType.setValue(lsDataType.findModel("commCd", "APP")); 			// 구분 셋팅
				 
				 // 현재 날짜로 
				 Calendar intiCal =  Calendar.getInstance(); 
				 intiCal.setTime(new Date());
				 srhDay.setValue(intiCal.getTime());
				 
				 
				 
				 String hourS =  GWTUtils.getStringFromDate(intiCal.getTime(), "HH");
				 String minuteS = String.valueOf(intiCal.get(Calendar.MINUTE));
				 
				 
				 SysIfComboUtils.setSelectedComboValue(srhHourS, hourS,"commCd"); 		// 시간셋팅
				 SysIfComboUtils.setSelectedComboValue(srhMinuteS, minuteS,"commCd"); 	// 분셋팅
		    		
		    		
				 intiCal.setTime(new Date());
				 intiCal.add(Calendar.MINUTE, 10);
				 
				 
				 String hourE = GWTUtils.getStringFromDate(intiCal.getTime(), "HH");
				 String minuteE = String.valueOf(intiCal.get(Calendar.MINUTE));
				 
				 
				 SysIfComboUtils.setSelectedComboValue(srhHourE, hourE,"commCd"); 		// 시간셋팅
				 SysIfComboUtils.setSelectedComboValue(srhMinuteE, minuteE,"commCd"); 	// 분셋팅
				 
				 
				 
				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				  * 권한설정을 위한 콤보처리를 위한 메서드 종료
				  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
			
			 }
			final Timer tmMask = new Timer() {
				public void run() {
					// if (maskTracker) { 
					 if (lsUsrCd.getCount() > 0 ) {
		        		   
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
			     
			
//				authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
//				authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
				authMapDef.put("srhDeptCd",Boolean.FALSE); 
			   // authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
				

		 		 gwtExtAuth.setCheckMapDef(authMapDef);
		 		
		 		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//		 			 권한 검색조건처리를 위해 추가된 부분
		 			 mask("[화면로딩] 초기화 진행 중!");
		 		 }	
		 		 tmMask.scheduleRepeating(5000);
		 	 }
		 	/**
		 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 	 **/   
	  
	  public ShowFormErrMsg(final ShowMessageBM retval,final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
			//콤보 권한초기화
			initLoad(); 		
			
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

	        this.showMessagePlrlt = new ShowMessageBM();
	        
	        this.showMessagePlrlt = retval;
	        
	        this.caller = caller;
		   
	        cpSysmP330002 = new ContentPanel();  

	        createHistP030002Form();	// 기본정보
	        createSearchForm();			// 검색조건
	        createStandardForm();		// 상세정보
		   
	           
		   cpSysmP330002.setBodyBorder(false);
		   cpSysmP330002.setBorders(false);
		   cpSysmP330002.setHeaderVisible(false);
//		   cpSysmP330002.setSize("790px", "330px");
		   cpSysmP330002.setSize("800px", "520px");
		   
		   this.add(cpSysmP330002);
		   formBinding = new FormBinding(this, true);
		    
//		   this.setSize("820px", "450px");  
		   this.setSize("830px", "530px");
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
	private void createHistP030002Form() {
			
		/** 상단 버튼 ButtonBar**/
		topSysmP330002Bar = new ButtonBar();    
		topSysmP330002Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnSysmP330002Srh = new Button("조 회");  
		btnSysmP330002Srh.setIcon(MSFMainApp.ICONS.search16());
		topSysmP330002Bar.add(btnSysmP330002Srh); 
		btnSysmP330002Srh.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
    			
    			SysIfHist0300DTO sysmIfHist0300Dto = new SysIfHist0300DTO();
    			
    			sysmIfHist0300Dto.setUsrConnectDivCd(MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"));	// 구분
    			sysmIfHist0300Dto.setErrOccrrncDtntm(																//  에러발생일시
    					MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 		
    					+ MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") 
    					+ MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd"));
    			
    			
    			sysmIfHist0300Dto.setErrOccrrncDtntmS( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 
    													+ MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") 
    													+ MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd")); 		// 접속시작시간
    			
    			sysmIfHist0300Dto.setErrOccrrncDtntmE( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 
						+ MSFSharedUtils.getSelectedComboValue(srhHourE,"commCd") 
						+ MSFSharedUtils.getSelectedComboValue(srhMinuteE,"commCd")); 										// 접속종료시간
    			
    			
    			sysmIfHist0300Dto.setDeptCd(MSFSharedUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));	// 부서
    			sysmIfHist0300Dto.setUsrId(MSFSharedUtils.allowNulls(srhUsrId.getValue()));			// 아이디
    			sysmIfHist0300Dto.setWindowId(MSFSharedUtils.allowNulls(strWindowId.getValue()));	// 화면아이디		
    			sysmIfHist0300Dto.setWindowNm(MSFSharedUtils.allowNulls(strWindowNm.getValue()));	// 화면명
    			
    			
//    			System.out.println("11111111111111");
    			// 조회
    			sysmP330002Search(sysmIfHist0300Dto);
    		}
    	});
		
		
		btnSysmP330002Excel = new Button("엑 셀");  
		btnSysmP330002Excel.setIcon(MSFMainApp.ICONS.excel16());
		topSysmP330002Bar.add(btnSysmP330002Excel); 
		btnSysmP330002Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//엑셀저장  
    			excelFileExport();
    		}
    	});
 
		cpSysmP330002.add(topSysmP330002Bar);
	} 
	
	/** 검색조건 **/
    private void createSearchForm() { 
    	
		dpobCd = new HiddenField<String>();		
	    dpobCd.setName("dpobCd");
	    cpSysmP330002.add(dpobCd);
	    
		systemkey = new HiddenField<String>();	
		systemkey.setName("systemkey");
		cpSysmP330002.add(systemkey);
		
	    
		deptNm = new HiddenField<String>();	
		deptNm.setName("deptNm");
		cpSysmP330002.add(deptNm);
	    
	    usrNm = new HiddenField<String>();	
	    usrNm.setName("usrNm");
	    cpSysmP330002.add(usrNm);
	    
	    usrId = new HiddenField<String>();		
	    usrId.setName("usrId");
	    cpSysmP330002.add(usrId);
	    
    	
    	sysIfBass0300Dto = new SysIfBass0300DTO();
    	sysIfBass0400Dto = new SysIfBass0400DTO();
        
        //--------------------조회구분 코드 불러 오는 함수 --------------------------------------------------
        lsDataType = new ListStore<BaseModel>();
		BaseModel DataTypeBaseModel = new BaseModel();
		DataTypeBaseModel.set("commCd", "APP");
		DataTypeBaseModel.set("commCdNm", "업무시스템");
		
		lsDataType.add(DataTypeBaseModel);
		DataTypeBaseModel = new BaseModel();
		DataTypeBaseModel.set("commCd", "WEB");
		DataTypeBaseModel.set("commCdNm", "마이페이지");
		lsDataType.add(DataTypeBaseModel);
        //--------------------조회구분 불러 오는 함수 --------------------------------------------------
		
		
		
        //--------------------시간 구분 코드 불러 오는 함수 --------------------------------------------------
		//시간
		sysmP330002Service.getHourList(new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				lsHour.add(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "시간코드 에러!", null);
			}
		});
		
		//분
		sysmP330002Service.getMinuteList(new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				lsMinute.add(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "분 에러!", null);
			}
		});
        //--------------------시간 구분 불러 오는 함수 --------------------------------------------------
        
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysIfBass0300Dto.setRpsttvCd("D001");		// 사용자구분
        lsUsrCd = SysifComServiceUtils.getSingleBass0300ComboData(sysIfBass0300Dto);
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        
        
       
    	//--------------------부서 불러 오는 함수 ------------------------------------------------
        sysIfBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
        sysIfBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		 
        sysIfBass0400Dto.setDeptDspyYn("Y");
        lsDeptCd = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
             public void handleEvent(StoreEvent<BaseModel> be) {  
                 mDtalistDeptCd = SysIfComboUtils.getDeptCdModelData(lsDeptCd) ; 
                 srhDeptCd.getInitStore().add(mDtalistDeptCd);
             }
         }); 
        //--------------------부서 불러 오는 함수 ------------------------------------------------
		
		//---------------------멀티콤보박스 닫기 -------------------------------------------------
		cpSysmP330002.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						srhDeptCd.showClose(ce);
						mutilCombo = false;
					} 
				}
			} 
		});
        
        
		dpobCd = new HiddenField<String>(); 		// 사업장코드
		srhSystemkey = new HiddenField<String>(); 	// 시스템키
		
		cpSysmP330002.setLayout(new FlowLayout());


		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		// fieldSet.setCheckboxToggle(false);
		
		LayoutContainer lcSchRow = new LayoutContainer();
		
		LayoutContainer lcSchCol1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcSchCol1_1 = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_1.setLayout(frmlytSch);
		
		srhDataType = new ComboBox<BaseModel>();
		srhDataType.setName("srhDataType");
		srhDataType.setReadOnly(true);
		srhDataType.setForceSelection(true);
		srhDataType.setMinChars(1);
		srhDataType.setDisplayField("commCdNm");
		srhDataType.setValueField("commCd");
		srhDataType.setTriggerAction(TriggerAction.ALL);
    	srhDataType.setEmptyText("-- 구분선택 --");
    	srhDataType.setSelectOnFocus(true); 
    	srhDataType.setStore(lsDataType);  
    	srhDataType.setFieldLabel("구분");
    	
    	lcSchCol1_1.add(srhDataType, new FormData("100%"));
    	
		LayoutContainer lcSchCol1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_2.setLayout(frmlytSch);
		
     	srhDay = new DateField();
     	srhDay.setReadOnly(false);
     	srhDay.setName("srhDay");
     	srhDay.setLabelSeparator("기간");
        new DateFieldMask(srhDay, "9999.99.99"); 
        srhDay.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		lcSchCol1_2.add(srhDay, new FormData("100%"));
    	
    	
		LayoutContainer lcSchCol1_3 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcSchCol1_3_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_3_1.setLayout(frmlytSch);
		
		srhHourS = new ComboBox<BaseModel>();
		srhHourS.setName("srhHourS");
		srhHourS.setForceSelection(true);
		srhHourS.setMinChars(1);
		srhHourS.setDisplayField("commCd");
		srhHourS.setValueField("commCd");
		srhHourS.setTriggerAction(TriggerAction.ALL);
		srhHourS.setEmptyText("-- 시간선택 --");
		srhHourS.setSelectOnFocus(true); 
		srhHourS.setStore(lsHour);  
		srhHourS.setFieldLabel("시간");
		lcSchCol1_3_1.add(srhHourS, new FormData("100%"));
		
    	lcSchCol1_3.add(lcSchCol1_3_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		LayoutContainer lcSchCol1_3_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_3_2.setLayout(frmlytSch);
		
		srhMinuteS = new ComboBox<BaseModel>();
		srhMinuteS.setName("srhMinuteS");
		srhMinuteS.setForceSelection(true);
		srhMinuteS.setMinChars(1);
		srhMinuteS.setDisplayField("commCd");
		srhMinuteS.setValueField("commCd");
		srhMinuteS.setTriggerAction(TriggerAction.ALL);
		srhMinuteS.setEmptyText("-- 시간선택 --");
		srhMinuteS.setSelectOnFocus(true); 
		srhMinuteS.setLabelSeparator(":");
		srhMinuteS.setStore(lsMinute);  
		lcSchCol1_3_2.add(srhMinuteS, new FormData("100%"));
		
    	lcSchCol1_3.add(lcSchCol1_3_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		LayoutContainer lcSchCol1_3_3 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(10);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_3_3.setLayout(frmlytSch);
		
		srhHourE = new ComboBox<BaseModel>();
		srhHourE.setName("srhHourE");
		srhHourE.setForceSelection(true);
		srhHourE.setMinChars(1);
		srhHourE.setDisplayField("commCd");
		srhHourE.setValueField("commCd");
		srhHourE.setTriggerAction(TriggerAction.ALL);
		srhHourE.setEmptyText("-- 시간선택 --");
		srhHourE.setSelectOnFocus(true); 
		srhHourE.setLabelSeparator("~");
		srhHourE.setStore(lsHour);  
		lcSchCol1_3_3.add(srhHourE, new FormData("100%"));
		
		lcSchCol1_3.add(lcSchCol1_3_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		LayoutContainer lcSchCol1_3_4 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_3_4.setLayout(frmlytSch);
		
		srhMinuteE = new ComboBox<BaseModel>();
		srhMinuteE.setName("srhMinuteE");
		srhMinuteE.setForceSelection(true);
		srhMinuteE.setMinChars(1);
		srhMinuteE.setDisplayField("commCd");
		srhMinuteE.setValueField("commCd");
		srhMinuteE.setTriggerAction(TriggerAction.ALL);
		srhMinuteE.setEmptyText("-- 시간선택 --");
		srhMinuteE.setSelectOnFocus(true); 
		srhMinuteE.setLabelSeparator(":");
		srhMinuteE.setStore(lsMinute);  
		lcSchCol1_3_4.add(srhMinuteE, new FormData("100%"));
		
		lcSchCol1_3.add(lcSchCol1_3_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
        
        
		
		
		LayoutContainer lcSchCol1_4 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_4.setLayout(frmlytSch);
		
		
		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.getStore().add(mDtalistDeptCd);
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
	    srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	        public void handleEvent(StoreEvent<ModelData> be) {  
	        	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	           		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	           		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	           		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		        		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkHistP030002Auth("srhDeptCd", lsDeptCd); 
	           	 	}
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
	    lcSchCol1_4.add(srhDeptCd, new FormData("100%"));
		
		
		
        
        lcSchCol1.add(lcSchCol1_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));			// 조회 구분
        lcSchCol1.add(lcSchCol1_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));			// 기간
        lcSchCol1.add(lcSchCol1_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));			// 시간
        lcSchCol1.add(lcSchCol1_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));			// 부서
		
        
        LayoutContainer lcSchCol2 = new LayoutContainer(new ColumnLayout());
        
		LayoutContainer lcSchCol2_1 = new LayoutContainer(new ColumnLayout());
		
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcDeptNm.setLayout(frmlytSch);
      
		
		srhUsrNm = new TextField<String>(); 
		srhUsrNm.setFieldLabel("성명");
		srhUsrNm.setMaxLength(20);
		srhUsrNm.addKeyListener(new KeyListener() {
	            public void componentKeyUp(ComponentEvent event) {
//	                super.componentKeyUp(event);
	                srhUsrId.validate();
	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                	if (MSFSharedUtils.allowNulls(srhUsrNm.getValue()).trim().equals("")) {
	                		srhUsrId.setValue("");
	                    }
	                	fnPopupCommP980(srhUsrNm.getValue());
	                }
	            }
	         });
		srhUsrNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
	            @Override
	            public void handleEvent(BaseEvent be) {  
	                if (MSFSharedUtils.allowNulls(srhUsrNm.getValue()).trim().equals("")) {
	                	srhUsrId.setValue("");
	                }if (MSFSharedUtils.paramNull(srhUsrNm.getValue())) {
	                	srhUsrId.setValue("");
	                }   
	            } 
	      }); 
		
		Button btnSrhUsr = new Button("");
		btnSrhUsr.setIcon(MSFMainApp.ICONS.search());
		btnSrhUsr.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	            	if (MSFSharedUtils.allowNulls(srhUsrNm.getValue()).trim().equals("")) {
	            		srhUsrId.setValue("");
	                }
	            	fnPopupCommP980(srhUsrNm.getValue());
	            }
	        });
		
		lcDeptNm.add(srhUsrNm, new FormData("100%"));
		lcSchCol2_1.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
		lcSchCol2_1.add(btnSrhUsr, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
		
        
        
		LayoutContainer lcSchCol2_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setDefaultWidth(0);
		lcSchCol2_2.setLayout(frmlytSch);
		
		srhUsrId = new TextField<String>();
		srhUsrId.setName("srhUsrId");
		srhUsrId.setHideLabel(true);
		srhUsrId.setReadOnly(true);
		lcSchCol2_2.add(srhUsrId, new FormData("100%"));
		
		
		
		
		LayoutContainer  lcSchCol2_3 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol2_3.setLayout(frmlytSch);
		
		strWindowNm = new TextField<String>(); 
		strWindowNm.setName("strWindowNm");
		strWindowNm.setValue(showMessagePlrlt.getWindowNm());
		strWindowNm.setFieldLabel("화면명");
		strWindowNm.setReadOnly(true);
		lcSchCol2_3.add(strWindowNm, new FormData("100%"));
		
		
		
		LayoutContainer  lcSchCol2_4 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol2_4.setLayout(frmlytSch);
		
		strWindowId = new TextField<String>(); 
		strWindowId.setValue(showMessagePlrlt.getWindowId());
		strWindowId.setFieldLabel("화면ID");
		strWindowId.setReadOnly(true);
		lcSchCol2_4.add(strWindowId, new FormData("100%"));
		
		
		
		lcSchCol2.add(lcSchCol2_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	// 성명
        lcSchCol2.add(lcSchCol2_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));	// 아이디
        lcSchCol2.add(lcSchCol2_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));	// 화면명
        lcSchCol2.add(lcSchCol2_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	// 화면ID
        
        
        lcSchRow.add(lcSchCol1, new FormData("100%"));
        lcSchRow.add(lcSchCol2, new FormData("100%"));

        
		fieldSet.add(lcSchRow, new FormData("100%"));
		

		cpSysmP330002.add(fieldSet);		
		
		
//		hist0300GridPanel = new MSFGridPanel(hist0300Def, false, false, false, false);
//		hist0300GridPanel.setHeaderVisible(false);  
//		hist0300GridPanel.setBodyBorder(true);
//		hist0300GridPanel.setBorders(true);
		
	} 
    
	/** 상세정보 **/
    private void createStandardForm() { 
    	
		errOccrrncDtntm = new HiddenField<String>();
		errOccrrncDtntm.setName("errOccrrncDtntm");
		cpSysmP330002.add(errOccrrncDtntm);

		errEthdNm = new HiddenField<String>();
		errEthdNm.setName("errEthdNm");
		cpSysmP330002.add(errEthdNm);

		errNm = new HiddenField<String>();
		errNm.setName("errNm");
		cpSysmP330002.add(errNm);

		errCtnt = new HiddenField<String>();
		errCtnt.setName("errCtnt");
		cpSysmP330002.add(errCtnt);
		
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");
		
		
		LayoutContainer lcSchRow = new LayoutContainer();
		
		
//		LayoutContainer  lcSchCol1 = new LayoutContainer(new ColumnLayout());
//		
//		LayoutContainer  lcSchCol1_1 = new LayoutContainer();
//		
//		FormLayout frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(80); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol1.setLayout(frmlytSch);
//		
//		strWindowNm = new TextField<String>(); 
//		strWindowNm.setFieldLabel("화면명");
//		strWindowNm.setReadOnly(true);
//		lcSchCol1_1.add(strWindowNm, new FormData("100%"));
//		
//		lcSchCol1.add(lcSchCol1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		
//		
//		LayoutContainer  lcSchCol1_2 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(80); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol1.setLayout(frmlytSch);
//		
//		strWindowId = new TextField<String>(); 
//		strWindowId.setFieldLabel("화면ID");
//		strWindowId.setReadOnly(true);
//		lcSchCol1_1.add(strWindowId, new FormData("100%"));
//		
//		lcSchCol1.add(lcSchCol1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer  lcSchCol2 = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol2.setLayout(frmlytSch);
		
		strErrEthdNm = new TextArea();
		strErrEthdNm.setName("strErrEthdNm");
		strErrEthdNm.setReadOnly(true);
		strErrEthdNm.setFieldLabel("에러메소드명");
		lcSchCol2.add(strErrEthdNm, new FormData("100%"));
		
		
		LayoutContainer  lcSchCol3 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol3.setLayout(frmlytSch);
		
		strErrNm = new TextArea();
		strErrNm.setName("strErrNm");
		strErrNm.setFieldLabel("에러명");
		strErrNm.setReadOnly(true);
//		strErrEthdNm.setSize(940, 40);
		
		lcSchCol3.add(strErrNm, new FormData("100%"));
		
		
		
		LayoutContainer  lcSchCol4 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol4.setLayout(frmlytSch);
		
		strErrCtnt = new TextArea();
		strErrCtnt.setName("strErrCtnt");
		strErrCtnt.setFieldLabel("에러내용");
		strErrCtnt.setHeight(250);
		strErrCtnt.setReadOnly(true);
		

		lcSchCol4.add(strErrCtnt, new FormData("100%"));
		
		
		LayoutContainer  lcSchCol5 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer  lcSchCol5_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		lcSchCol5_1.setLayout(frmlytSch);
		
//		lcSchCol5.add(lcSchCol5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer  lcSchCol5_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(550); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol5_2.setLayout(frmlytSch);
		
		dataCnt = new TextField<String>(); 
		dataCnt.setFieldLabel("건수");
		dataCnt.setReadOnly(true);
		lcSchCol5_2.add(dataCnt, new FormData("100%"));
		
		
		lcSchCol5.add(lcSchCol5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		
		LayoutContainer  lcSchCol5_3 = new LayoutContainer();
		
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(10); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol5_3.setLayout(frmlytSch);
		
		nDataCnt = new TextField<String>(); 
		nDataCnt.setLabelSeparator("/");
		nDataCnt.setReadOnly(true);
		lcSchCol5_3.add(nDataCnt, new FormData("85%"));
		
		
		lcSchCol5.add(lcSchCol5_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		
		
		LayoutContainer  lcSchCol5_4 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnBefore = new Button("◀ ");
		btnBefore.setWidth(50);
		btnBefore.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	
            	if(hist0300List.size() <= 0){
					MessageBox.alert("알림", "조회할 데이터가 존재하지 않습니다.", null);
        			return;
				}
            	
            	// 이동하고자 하는 게시글의 번호가 0보다 작거나 같을 경우 제일 마지막의 글을 보여줌
            	if(iData <= 0){
            		
            		iData = iCnt+1;
            	}
            	
            	iData = iData- 1 ;
            	
            	showHist0300List(hist0300List, iData, iCnt);
            	
            }
        });
		btnBar.add(btnBefore);
		
		btnNext = new Button("▶ ");
		btnNext.setWidth(50);
		btnNext.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	
            	if(hist0300List.size() <= 0){
					MessageBox.alert("알림", "조회할 데이터가 존재하지 않습니다.", null);
        			return;
				}
            	
            	// 이동하고자 하는 게시글의 번호가 총 게시물의 갯수보다 많으면 첫번째 글을 보여줌
            	if(iData+1 > iCnt){
            		
            		iData = 0;
            	}
            	
            	iData = iData+ + 1;
            	
            	showHist0300List(hist0300List, iData, iCnt);
            }
        });
		btnBar.add(btnNext);
		
		lcSchCol5_4.add(btnBar);
		lcSchCol5.add(lcSchCol5_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		
		

		
		
		
//		lcSchRow.add(lcSchCol1, new FormData("100%"));	// 화면명, 화면ID
		lcSchRow.add(lcSchCol2, new FormData("100%"));	// 에러메소드명
		lcSchRow.add(lcSchCol3, new FormData("100%"));	// 에러명
		lcSchRow.add(lcSchCol4, new FormData("100%"));	// 에러내용
		lcSchRow.add(lcSchCol5, new FormData("100%"));	// 건수 및 버튼
        
        
    	fieldSet.add(lcSchRow, new FormData("100%"));
        
        cpSysmP330002.add(fieldSet);	
		
    }
    
			  

	class Tracker {
		public boolean status = false;

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean stat) {
			status = stat;
		}
	}
		   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	 
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			 @Override
			public void handleEvent(BaseEvent be) {
				 
//				 strDeptNm.setValue(deptNm.getValue()); 						// 부서
//				 strHanNm.setValue(usrNm.getValue());							// 성명
//				 strUsrId.setValue(usrId.getValue());							// 아이디
//				 strErrOccrrncDtntm.setValue(errOccrrncDtntm.getValue());		// 에러발생일시
//				 strErrEthdNm.setValue(errEthdNm.getValue());					// 에러 메소드명
//				 strErrNm.setValue(errNm.getValue());							// 에러명
//				 strErrCtnt.setValue(errCtnt.getValue());						// 에러내용
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
	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	} 
	
	
	
	// 항목 보기(리스트, 데이터 번호, 전체데이터갯수)
	private void showHist0300List(ArrayList<SysIfHist0300DTO> hist0300List, int i, int j) {
		
		i = i - 1;
		
//		System.out.println("333333333");
		
//		strWindowNm.setValue(hist0300List.get(i).getWindowNm());	// 화면명
//		System.out.println(hist0300List.get(i).getWindowNm());
//		
//		strWindowId.setValue(hist0300List.get(i).getWindowId());	// 화면아이디
//		System.out.println(hist0300List.get(i).getWindowId());
		
		strErrEthdNm.setValue(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrEthdNm()));	// 에러메소드명
//		System.out.println(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrEthdNm()));
		
		strErrNm.setValue(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrNm()));			// 에러명
//		System.out.println(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrNm()));
		
		strErrCtnt.setValue(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrCtnt()));		// 에러내용
//		System.out.println(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrCtnt()));
		
		nDataCnt.setValue(String.valueOf(iData));					// 현재 데이터 번호
//		System.out.println(String.valueOf(iData));
		dataCnt.setValue(String.valueOf(iCnt));						// 전체 데이터 건수
//		System.out.println(String.valueOf(iCnt));
		
	}
	
	
	
	// 조회
	private void sysmP330002Search(SysIfHist0300DTO sysmIfHist0300Dto) {
		
		// 데이터 초기화
		initHist0300Info();	
		
//		System.out.println("2222222222222");
		
		sysmP330002Service.resultListHist0300(sysmIfHist0300Dto, new AsyncCallback<List<SysIfHist0300DTO>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				caught.printStackTrace();
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
							, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("resultListHist0300(" + "조회" + ") : " + caught), null);
				
			}

			@Override
			public void onSuccess(List<SysIfHist0300DTO> result) {
				// TODO Auto-generated method stub
				
				iCnt = 0;
				iData = 0;
				
				if(result.size() <= 0){
					MessageBox.alert("알림", "데이터가 존재하지 않습니다.", null);
        			return;
				}
				
				hist0300List = new ArrayList<SysIfHist0300DTO>();
				
				for(int i = 0; i < result.size(); i++){
						
					SysIfHist0300DTO hist0300Dto = new SysIfHist0300DTO();
						
					hist0300Dto.setRnum(MSFSharedUtils.allowNulls(result.get(i).getRnum()));
					hist0300Dto.setDpobCd(MSFSharedUtils.allowNulls(result.get(i).getDpobCd()));    				/** column 사업장코드 : dpobCd */
					hist0300Dto.setUsrId(MSFSharedUtils.allowNulls(result.get(i).getUsrId()));    					/** column 사용자아이디 : usrId */
					hist0300Dto.setErrOccrrncDtntm(MSFSharedUtils.allowNulls(result.get(i).getErrOccrrncDtntm())); 	/** column 에러발생일시 : errOccrrncDtntm */
					hist0300Dto.setErrSeilNum(MSFSharedUtils.convertStringToLong(
									MSFSharedUtils.defaultNulls(result.get(i).getErrSeilNum(), "0")));    			/** column 에러일련번호 : errSeilNum */
					hist0300Dto.setErrOccrrncYr(MSFSharedUtils.allowNulls(result.get(i).getErrOccrrncYr()));    	/** column 에러발생년도 : errOccrrncYr */
					hist0300Dto.setUsrConnectDivCd(MSFSharedUtils.allowNulls(result.get(i).getUsrConnectDivCd()));	/** column 사용자접속구분코드 : usrConnectDivCd */
					hist0300Dto.setDeptCd(MSFSharedUtils.allowNulls(result.get(i).getDeptCd()));    				/** column 부서코드 : deptCd */
					hist0300Dto.setUsrDivCd(MSFSharedUtils.allowNulls(result.get(i).getUsrDivCd()));    			/** column 사용자구분코드 : usrDivCd */
					hist0300Dto.setUsrNm(MSFSharedUtils.allowNulls(result.get(i).getUsrNm()));    					/** column 사용자성명 : usrNm */
					hist0300Dto.setErrEthdNm(MSFSharedUtils.allowNulls(result.get(i).getErrEthdNm()));    			/** column 에러메소드명 : errEthdNm */
					hist0300Dto.setErrNm(MSFSharedUtils.allowNulls(result.get(i).getErrNm()));    					/** column 에러명 : errNm */
					hist0300Dto.setErrCtnt(MSFSharedUtils.allowNulls(result.get(i).getErrCtnt()));    				/** column 에러내용 : errCtnt */
					hist0300Dto.setWindowNm(MSFSharedUtils.allowNulls(result.get(i).getWindowNm()));    			/** column 화면명 : windowNm */
					hist0300Dto.setWindowId(MSFSharedUtils.allowNulls(result.get(i).getWindowId()));    			/** column 화면아이디 : windowId */
					hist0300Dto.setKybdr(result.get(i).getKybdr());    												/** column 입력자 : kybdr */
					hist0300Dto.setInptDt(result.get(i).getInptDt());    											/** column 입력일자 : inptDt */
					hist0300Dto.setInptAddr(result.get(i).getInptAddr());    										/** column 입력주소 : inptAddr */
					hist0300Dto.setIsmt(result.get(i).getIsmt());    												/** column 수정자 : ismt */
					hist0300Dto.setRevnDt(result.get(i).getRevnDt());    											/** column 수정일자 : revnDt */
					hist0300Dto.setRevnAddr(result.get(i).getRevnAddr());    										/** column 수정주소 : revnAddr */
					

					iCnt = iCnt + 1;
					
//					hist0300List.add(result.get(i));
					hist0300List.add(hist0300Dto);
				}
				
				iData = 1;
				showHist0300List(hist0300List, iData, iCnt);
				
			}
			
		});
		
	}
	
	
	//엑셀 저장
	private void excelFileExport() {
	                     
		HashMap<String, String> param = new HashMap<String, String>(); 
		
	   
		param.put("usrConnectDivCd", MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"));			// 화면구분	
		
		param.put("errOccrrncDtntmS", ( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 			// 에러발생시간
					+ MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") 
					+ MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd")));				
		
		param.put("errOccrrncDtntmE", ( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 			// 에러발생시간
					+ MSFSharedUtils.getSelectedComboValue(srhHourE,"commCd") 
				+ MSFSharedUtils.getSelectedComboValue(srhMinuteE,"commCd")));		
		
		param.put("deptCd", MSFSharedUtils.getStrValToBMMultiCombo(
					lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));								// 부서
	                     
		
		param.put("usrId", MSFSharedUtils.allowNulls(srhUsrId.getValue()));									// 아이디
		param.put("windowId", MSFSharedUtils.allowNulls(strWindowId.getValue()));							// 화면아이디
		param.put("windowNm", MSFSharedUtils.allowNulls(strWindowNm.getValue()));							// 화면명
		
	                     
//		hist0300GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileSysmP330002Export.do","extgwtFrame" ,param);
		GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsFileSysmP330002Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	
	}
	
	
	private void initHist0300Info() {
		
//		strWindowNm.setValue("");	// 화면명
//		strWindowId.setValue("");	// 화면아이디
		
		strErrEthdNm.setValue("");	// 에러메소드명
		strErrNm.setValue("");		// 에러명
		strErrCtnt.setValue("");	// 에러내용	
		
		dataCnt.setValue("");		// 데이터건수
		nDataCnt.setValue("");		// 현재데이터번호
		
	}
	
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 시작
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
	
		
	 
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
    //담당자, 분임지출관
    private void fnPopupCommP980(String usrNm) {
        MSFFormPanel popCom0980 = SysIfComPopupUtils.lovPopUpMsfSysComP0980Form(usrNm);  
        
        final FormBinding popBindingCom0980 = popCom0980.getFormBinding();
        popBindingCom0980.addListener(Events.Change, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
            BaseModel mapModel = (BaseModel)be.getSource();
            
            	if (!"".equals(mapModel.get("usrId"))) {
            	
            		srhUsrNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrNm")));
            		srhUsrId.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrId")));
            		
				}
			}
		});
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

    
//    /**
// *##########################################################################
// * { 시스템 기본설정파일 선언부  시작}
// *##########################################################################
// **/
//	    
//
///**
// *##########################################################################
// * { 시스템 기본설정파일 선언부  종료}
// *##########################################################################
// **/
//  
///**
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// * 	전역변수 선언부  시작
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// **/
// 
//	private  ContentPanel cpSysmP330002; 
//	  
//	/**######################################################
//	 * { 시스템 기본설정파일 선언부  시작}
//	 *#######################################################*/
//		 
//	//권한 설정 객체 
//	private static  GWTAuthorization gwtAuthorization;
//	private static  GWTExtAuth gwtExtAuth;
//	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
//		  
//	/**######################################################
//	 * { 시스템 기본설정파일 선언부  종료}
//	 *#######################################################*/
//
//    
//   /**
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   * 상태처리 전역변수
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   */
//	private ActionDatabase actionDatabase;
//	 private ShowMessageBM showMessagePlrlt;
//  /**
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   * 화면 렌더링 변수 선언 
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   */
//    
//	private MSFPanel caller;
//	private Boolean  reading = false;
//	public  FormBinding formBinding;
//  
//	private BaseModel record;
//	private Iterator<Record> records;
//  
//  /**
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   * Button 변수 선언
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   */
//	
//	private ButtonBar topSysmP330002Bar;
//	private Button btnSysmP330002Srh;
//	private Button btnSysmP330002Excel;
//       
//
//  /**
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   * 검색변수 선언 
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   */
//
//	private HiddenField<String> srhSystemkey;   		// 시스템키 
//	
//	private ComboBox<BaseModel> srhDataType;			// 조회구분
//    private DateField srhDay;      						// 시작일
//    
//	private ComboBox<BaseModel> srhHourS;				// 시작시간
//	private ComboBox<BaseModel> srhMinuteS;				// 시작분
//	private ComboBox<BaseModel> srhHourE;				// 시작시간
//	private ComboBox<BaseModel> srhMinuteE;				// 시작분
//	
//	private TextField<String> strWindowNm;				// 화면명
//	private TextField<String> strWindowId;				// 화면아이디
//
//	private MSFMultiComboBox<ModelData> srhDeptCd; 		// 부서
//	
//	private TextField<String> srhUsrNm;					// 성명
//	private TextField<String> srhUsrId; 				// 아이디
//	
//	
//      
//  /**
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   * 입력 변수 선언 
//   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//   */
//	
//
// 	private TextArea strErrEthdNm;						// 에러 메소드명
// 	private TextArea strErrNm;							// 에러명
// 	private TextArea strErrCtnt;						// 에러내용
// 	
// 	private TextField<String> dataCnt;					// 데이터 건수
// 	private TextField<String> nDataCnt;					// 데이터 건수
// 	
// 	private Button btnBefore;							// 이전 버튼
// 	private Button btnNext;								// 다음 버튼	
//	private List<ModelData> mDtalistDeptCd;				// 부서 멀티	
//	
//	private ArrayList<SysIfHist0300DTO> hist0300List = new ArrayList<SysIfHist0300DTO>();
//
//	private boolean mutilCombo = false;
//	
//	private HiddenField<String> dpobCd;					// 사업장코드
//	
//	
// 	private HiddenField<String> deptNm; 				// 부서
// 	private HiddenField<String> windowNm;				// 화면명
// 	private HiddenField<String> windowIn;				// 화면아이디
// 	private HiddenField<String> usrNm;					// 성명
// 	private HiddenField<String> usrId;					// 아이디
// 	private HiddenField<String> errOccrrncDtntm;		// 에러발생일시
// 	private HiddenField<String> errEthdNm;				// 에러 메소드명
// 	private HiddenField<String> errNm;					// 에러명
// 	private HiddenField<String> errCtnt;				// 에러내용
// 	private HiddenField<String> systemkey;				// 시스템키
// 	
// 	private int iCnt = 0;
// 	private int iData = 1;
// 	
//
//      
///**
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// * 	전역변수 선언부  종료
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// **/	  
//
//      
///**
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// * 	전역함수 선언부 시작
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// **/
//   // 검색 폼 바인딩 처리 함수 
//      
//	   //화면 폼 바인딩 처리 
//	    private void setPayr410001FormBinding() {
//	 	 
//	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
//	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
//	   
//	    }        
//   
///**
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// * 	전역함수 선언부 시작
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// **/	
//	  
///**
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// * 	Rpc Service 선언부 시작
// *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
// **/ 
//	    // -------------- store 선언 시작 ---------------
//		private ListStore<BaseModel> lsDataType 	    = new ListStore<BaseModel>();		// 조회구분콤보
//		private ListStore<BaseModel> lsHour 	    	= new ListStore<BaseModel>();		// 시
//		private ListStore<BaseModel> lsMinute 	    	= new ListStore<BaseModel>();		// 분
//		private ListStore<BaseModel> lsDeptCd 		    = new ListStore<BaseModel>();		// 부서콤보
//		private ListStore<BaseModel> lsUsrCd 		    = new ListStore<BaseModel>();		// 사용자콤보
//		// -------------- store 선언 종료 ---------------
//	    
//	    
//		// -------------- DTO 선언 시작 --------------
//		private SysIfBass0300DTO sysIfBass0300Dto; 		//공통코드 dto
//		private SysIfBass0400DTO sysIfBass0400Dto; 		//부서코드
//	    // -------------- DTO 선언 종료 --------------
//	    
//		// -------------- grid 선언 시작  ---------------
////	 	private SysmIfHist0300Def hist0300Def  = new SysmIfHist0300Def("");   //그리드 테이블 컬럼 define  
////	 	private MSFGridPanel hist0300GridPanel;
//	 	// -------------- grid 선언 종료  ---------------
//	    
//		private SysmP330002ServiceAsync sysmP330002Service = SysmP330002Service.Util.getInstance();
//	    
//	/**
//     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//     * 조회처리부
//     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//     */  
// 
//	     
//	    /**
//     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
//     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//     */  
// 
//	/**
//	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
//	 * 	Rpc Service 선언부 종료
//	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
//	 **/
//	/**
//
//	/**
//	 *############################################################################# 
//	 * 프로그램 시작  	  
//	 *############################################################################# 
//	 **/ 
// 
//	/**
//	 *############################################################################# 
//	 * 프로그램 종료  	  
//	 *############################################################################# 
//	 **/	  
//
//	/**
//	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//	 * 생성자 함수 선언부 시작
//	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
//	 **/ 		    
//		  /**
//		   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
//		   * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
//		   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		   **/
//		   
//		  	/**
//		 	 * 권한설정 처리 체크 AuthAction
//		 	 */
//		  	private void checkHistP030002Auth( String authAction, ListStore<BaseModel>bm) {
//			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//				 
//				   if (!maskTracker) { unmask(); } 
//				   authExecEnabled() ;
//			   }	
//		 	 }
//
//		  	 
//			 private void authExecEnabled() { 
//			   //------------------
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//					 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 //----------------------------------------------------
//				 Field<?>[] fldArrField = {srhDeptCd};
//				 gwtAuthorization.formAuthFieldConfig(fldArrField);
//				 
//				 srhDataType.setValue(lsDataType.findModel("commCd", "APP")); 			// 구분 셋팅
//				 
//				 // 현재 날짜로 
//				 Calendar intiCal =  Calendar.getInstance(); 
//				 intiCal.setTime(new Date());
//				 srhDay.setValue(intiCal.getTime());
//				 
//				 
//				 
//				 String hourS =  GWTUtils.getStringFromDate(intiCal.getTime(), "HH");
//				 String minuteS = String.valueOf(intiCal.get(Calendar.MINUTE));
//				 
//				 
//				 SysIfComboUtils.setSelectedComboValue(srhHourS, hourS,"commCd"); 		// 시간셋팅
//				 SysIfComboUtils.setSelectedComboValue(srhMinuteS, minuteS,"commCd"); 	// 분셋팅
//		    		
//		    		
//				 intiCal.setTime(new Date());
//				 intiCal.add(Calendar.MINUTE, 10);
//				 
//				 
//				 String hourE = GWTUtils.getStringFromDate(intiCal.getTime(), "HH");
//				 String minuteE = String.valueOf(intiCal.get(Calendar.MINUTE));
//				 
//				 
//				 SysIfComboUtils.setSelectedComboValue(srhHourE, hourE,"commCd"); 		// 시간셋팅
//				 SysIfComboUtils.setSelectedComboValue(srhMinuteE, minuteE,"commCd"); 	// 분셋팅
//				 
//				 
//				 
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				  * 권한설정을 위한 콤보처리를 위한 메서드 종료
//				  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//			
//			 }
//			final Timer tmMask = new Timer() {
//				public void run() {
//					// if (maskTracker) { 
//					 if (lsUsrCd.getCount() > 0 ) {
//		        		   
//			           	    cancel();
//			               	unmask(); 
//			               	authExecEnabled() ;
//			                maskTracker  = true;
//			        	
//			        	   } else {
//			        		   tmMask.scheduleRepeating(2000);
//			        	   }
//					// }
//				}
//			}; 
//			     
//			private void initLoad() {
//		 	
//				// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//				gwtAuthorization = GWTAuthorization.getInstance();
//				gwtExtAuth = GWTExtAuth.getInstance();
//
//		 		HashMap<String, Boolean> authMapDef = new HashMap<String,Boolean>(); 
//			     
//			
////				authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
////				authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
//				authMapDef.put("srhDeptCd",Boolean.FALSE); 
//			   // authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
//				
//
//		 		 gwtExtAuth.setCheckMapDef(authMapDef);
//		 		
//		 		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
////		 			 권한 검색조건처리를 위해 추가된 부분
//		 			 mask("[화면로딩] 초기화 진행 중!");
//		 		 }	
//		 		 tmMask.scheduleRepeating(5000);
//		 	 }
//		 	/**
//		 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
//		 	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
//		 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		 	 **/   
//	  
//	  public ShowFormErrMsg(final ShowMessageBM retval,final ActionDatabase actionDatabase, final MSFPanel caller) {
//		  
//			//콤보 권한초기화
//			initLoad(); 		
//			
//		    this.setFrame(false);
//	        this.setBodyBorder(false);
//	        this.setBorders(false);
//	        this.setHeaderVisible(false);
//	        //FormLayout layout = new FormLayout();
//	        //layout.setDefaultWidth(600);
//	       // layout.setLabelWidth(0);  
//	       // this.setLayout(layout);   
//	        this.setAutoHeight(true);
//	        this.actionDatabase = actionDatabase;
//
//	        this.showMessagePlrlt = new ShowMessageBM();
//	        
//	        this.showMessagePlrlt = retval;
//	        
//	        this.caller = caller;
//		   
//	        cpSysmP330002 = new ContentPanel();  
//
//	        createHistP030002Form();	// 기본정보
//	        createSearchForm();			// 검색조건
//	        createStandardForm();		// 상세정보
//		   
//	           
//		   cpSysmP330002.setBodyBorder(false);
//		   cpSysmP330002.setBorders(false);
//		   cpSysmP330002.setHeaderVisible(false);
////		   cpSysmP330002.setSize("790px", "330px");
//		   cpSysmP330002.setSize("800px", "520px");
//		   
//		   this.add(cpSysmP330002);
//		   formBinding = new FormBinding(this, true);
//		    
////		   this.setSize("820px", "450px");  
//		   this.setSize("830px", "530px");
//	  } 
//	    
//	  /**
//	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//	   * 생성자 함수 선언부 종료
//	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
//	   **/		 
//	    
//	  /**
//	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//	   * 폼 생성시 기본 처리 함수 선언부 시작
//	   * 1. 폼 생성 선언
//	   * 2. 공통 버튼 처리 선언
//	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
//	   **/	
//	  
//	  
//	   
//
//	/**
//	 * 기본정보 설정
//	 */
//	private void createHistP030002Form() {
//			
//		/** 상단 버튼 ButtonBar**/
//		topSysmP330002Bar = new ButtonBar();    
//		topSysmP330002Bar.setAlignment(HorizontalAlignment.RIGHT);
//		
//		btnSysmP330002Srh = new Button("조 회");  
//		btnSysmP330002Srh.setIcon(MSFMainApp.ICONS.search16());
//		topSysmP330002Bar.add(btnSysmP330002Srh); 
//		btnSysmP330002Srh.addListener(Events.Select, new Listener<ButtonEvent>() {
//    		public void handleEvent(ButtonEvent e) {
//    			
//    			
//    			SysIfHist0300DTO sysIfHist0300Dto = new SysIfHist0300DTO();
//    			
//    			sysIfHist0300Dto.setUsrConnectDivCd(MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"));	// 구분
//    			sysIfHist0300Dto.setErrOccrrncDtntm(																//  에러발생일시
//    					MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 		
//    					+ MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") 
//    					+ MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd"));
//    			
//    			
//    			sysIfHist0300Dto.setErrOccrrncDtntmS( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 
//    													+ MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") 
//    													+ MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd")); 		// 접속시작시간
//    			
//    			sysIfHist0300Dto.setErrOccrrncDtntmE( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 
//						+ MSFSharedUtils.getSelectedComboValue(srhHourE,"commCd") 
//						+ MSFSharedUtils.getSelectedComboValue(srhMinuteE,"commCd")); 										// 접속종료시간
//    			
//    			
//    			sysIfHist0300Dto.setDeptCd(MSFSharedUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));	// 부서
//    			sysIfHist0300Dto.setUsrId(MSFSharedUtils.allowNulls(srhUsrId.getValue()));			// 아이디
//    			sysIfHist0300Dto.setWindowId(MSFSharedUtils.allowNulls(strWindowId.getValue()));	// 화면아이디		
//    			sysIfHist0300Dto.setWindowNm(MSFSharedUtils.allowNulls(strWindowNm.getValue()));	// 화면명
//    			
//    			
////    			System.out.println("11111111111111");
//    			// 조회
//    			sysmP330002Search(sysIfHist0300Dto);
//    		}
//    	});
//		
//		
//		btnSysmP330002Excel = new Button("엑 셀");  
//		btnSysmP330002Excel.setIcon(MSFMainApp.ICONS.excel16());
//		topSysmP330002Bar.add(btnSysmP330002Excel); 
//		btnSysmP330002Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
//    		public void handleEvent(ButtonEvent e) {
//    			//엑셀저장  
//    			excelFileExport();
//    		}
//    	});
// 
//		cpSysmP330002.add(topSysmP330002Bar);
//	} 
//	
//	/** 검색조건 **/
//    private void createSearchForm() { 
//    	
//		dpobCd = new HiddenField<String>();		
//	    dpobCd.setName("dpobCd");
//	    cpSysmP330002.add(dpobCd);
//	    
//		systemkey = new HiddenField<String>();	
//		systemkey.setName("systemkey");
//		cpSysmP330002.add(systemkey);
//		
//	    
//		deptNm = new HiddenField<String>();	
//		deptNm.setName("deptNm");
//		cpSysmP330002.add(deptNm);
//	    
//	    usrNm = new HiddenField<String>();	
//	    usrNm.setName("usrNm");
//	    cpSysmP330002.add(usrNm);
//	    
//	    usrId = new HiddenField<String>();		
//	    usrId.setName("usrId");
//	    cpSysmP330002.add(usrId);
//	    
//    	
//    	sysIfBass0300Dto = new SysIfBass0300DTO();
//    	sysIfBass0400Dto = new SysIfBass0400DTO();
//        
//        //--------------------조회구분 코드 불러 오는 함수 --------------------------------------------------
//        lsDataType = new ListStore<BaseModel>();
//		BaseModel DataTypeBaseModel = new BaseModel();
//		DataTypeBaseModel.set("commCd", "APP");
//		DataTypeBaseModel.set("commCdNm", "업무시스템");
//		
//		lsDataType.add(DataTypeBaseModel);
//		DataTypeBaseModel = new BaseModel();
//		DataTypeBaseModel.set("commCd", "WEB");
//		DataTypeBaseModel.set("commCdNm", "마이페이지");
//		lsDataType.add(DataTypeBaseModel);
//        //--------------------조회구분 불러 오는 함수 --------------------------------------------------
//		
//		
//		
//        //--------------------시간 구분 코드 불러 오는 함수 --------------------------------------------------
//		//시간
//		sysmP330002Service.getHourList(new AsyncCallback<List<BaseModel>>() {
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				lsHour.add(result);
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				MessageBox.alert("", "시간코드 에러!", null);
//			}
//		});
//		
//		//분
//		sysmP330002Service.getMinuteList(new AsyncCallback<List<BaseModel>>() {
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				lsMinute.add(result);
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				MessageBox.alert("", "분 에러!", null);
//			}
//		});
//        //--------------------시간 구분 불러 오는 함수 --------------------------------------------------
//        
//        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//		sysIfBass0300Dto.setRpsttvCd("D001");		// 사용자구분
//        lsUsrCd = SysifComServiceUtils.getSingleBass0300ComboData(sysIfBass0300Dto);
//        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//        
//        
//       
//    	//--------------------부서 불러 오는 함수 ------------------------------------------------
//        sysIfBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
//        sysIfBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//		 
//        sysIfBass0400Dto.setDeptDspyYn("Y");
//        lsDeptCd = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
//		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//             public void handleEvent(StoreEvent<BaseModel> be) {  
//                 mDtalistDeptCd = SysIfComboUtils.getDeptCdModelData(lsDeptCd) ; 
//                 srhDeptCd.getInitStore().add(mDtalistDeptCd);
//             }
//         }); 
//        //--------------------부서 불러 오는 함수 ------------------------------------------------
//		
//		//---------------------멀티콤보박스 닫기 -------------------------------------------------
//		cpSysmP330002.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
//			@Override
//			public void handleEvent(ComponentEvent ce) { 
//				if (mutilCombo) {
//					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
//						srhDeptCd.showClose(ce);
//						mutilCombo = false;
//					} 
//				}
//			} 
//		});
//        
//        
//		dpobCd = new HiddenField<String>(); 		// 사업장코드
//		srhSystemkey = new HiddenField<String>(); 	// 시스템키
//		
//		cpSysmP330002.setLayout(new FlowLayout());
//
//
//		FieldSet fieldSet = new FieldSet();
//		fieldSet.setHeadingHtml("검색조건");//.setHeading("검색조건");
//		// fieldSet.setCheckboxToggle(false);
//		
//		LayoutContainer lcSchRow = new LayoutContainer();
//		
//		LayoutContainer lcSchCol1 = new LayoutContainer(new ColumnLayout());
//		
//		LayoutContainer lcSchCol1_1 = new LayoutContainer();
//		
//		FormLayout frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_1.setLayout(frmlytSch);
//		
//		srhDataType = new ComboBox<BaseModel>();
//		srhDataType.setName("srhDataType");
//		srhDataType.setReadOnly(true);
//		srhDataType.setForceSelection(true);
//		srhDataType.setMinChars(1);
//		srhDataType.setDisplayField("commCdNm");
//		srhDataType.setValueField("commCd");
//		srhDataType.setTriggerAction(TriggerAction.ALL);
//    	srhDataType.setEmptyText("-- 구분선택 --");
//    	srhDataType.setSelectOnFocus(true); 
//    	srhDataType.setStore(lsDataType);  
//    	srhDataType.setFieldLabel("구분");
//    	
//    	lcSchCol1_1.add(srhDataType, new FormData("100%"));
//    	
//		LayoutContainer lcSchCol1_2 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(40);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_2.setLayout(frmlytSch);
//		
//     	srhDay = new DateField();
//     	srhDay.setReadOnly(false);
//     	srhDay.setName("srhDay");
//     	srhDay.setLabelSeparator("기간");
//        new DateFieldMask(srhDay, "9999.99.99"); 
//        srhDay.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		lcSchCol1_2.add(srhDay, new FormData("100%"));
//    	
//    	
//		LayoutContainer lcSchCol1_3 = new LayoutContainer(new ColumnLayout());
//		
//		LayoutContainer lcSchCol1_3_1 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(40);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_3_1.setLayout(frmlytSch);
//		
//		srhHourS = new ComboBox<BaseModel>();
//		srhHourS.setName("srhHourS");
//		srhHourS.setForceSelection(true);
//		srhHourS.setMinChars(1);
//		srhHourS.setDisplayField("commCd");
//		srhHourS.setValueField("commCd");
//		srhHourS.setTriggerAction(TriggerAction.ALL);
//		srhHourS.setEmptyText("-- 시간선택 --");
//		srhHourS.setSelectOnFocus(true); 
//		srhHourS.setStore(lsHour);  
//		srhHourS.setFieldLabel("시간");
//		lcSchCol1_3_1.add(srhHourS, new FormData("100%"));
//		
//    	lcSchCol1_3.add(lcSchCol1_3_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
//		
//		LayoutContainer lcSchCol1_3_2 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(5);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_3_2.setLayout(frmlytSch);
//		
//		srhMinuteS = new ComboBox<BaseModel>();
//		srhMinuteS.setName("srhMinuteS");
//		srhMinuteS.setForceSelection(true);
//		srhMinuteS.setMinChars(1);
//		srhMinuteS.setDisplayField("commCd");
//		srhMinuteS.setValueField("commCd");
//		srhMinuteS.setTriggerAction(TriggerAction.ALL);
//		srhMinuteS.setEmptyText("-- 시간선택 --");
//		srhMinuteS.setSelectOnFocus(true); 
//		srhMinuteS.setLabelSeparator(":");
//		srhMinuteS.setStore(lsMinute);  
//		lcSchCol1_3_2.add(srhMinuteS, new FormData("100%"));
//		
//    	lcSchCol1_3.add(lcSchCol1_3_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		
//		LayoutContainer lcSchCol1_3_3 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(10);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_3_3.setLayout(frmlytSch);
//		
//		srhHourE = new ComboBox<BaseModel>();
//		srhHourE.setName("srhHourE");
//		srhHourE.setForceSelection(true);
//		srhHourE.setMinChars(1);
//		srhHourE.setDisplayField("commCd");
//		srhHourE.setValueField("commCd");
//		srhHourE.setTriggerAction(TriggerAction.ALL);
//		srhHourE.setEmptyText("-- 시간선택 --");
//		srhHourE.setSelectOnFocus(true); 
//		srhHourE.setLabelSeparator("~");
//		srhHourE.setStore(lsHour);  
//		lcSchCol1_3_3.add(srhHourE, new FormData("100%"));
//		
//		lcSchCol1_3.add(lcSchCol1_3_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		LayoutContainer lcSchCol1_3_4 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(5);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_3_4.setLayout(frmlytSch);
//		
//		srhMinuteE = new ComboBox<BaseModel>();
//		srhMinuteE.setName("srhMinuteE");
//		srhMinuteE.setForceSelection(true);
//		srhMinuteE.setMinChars(1);
//		srhMinuteE.setDisplayField("commCd");
//		srhMinuteE.setValueField("commCd");
//		srhMinuteE.setTriggerAction(TriggerAction.ALL);
//		srhMinuteE.setEmptyText("-- 시간선택 --");
//		srhMinuteE.setSelectOnFocus(true); 
//		srhMinuteE.setLabelSeparator(":");
//		srhMinuteE.setStore(lsMinute);  
//		lcSchCol1_3_4.add(srhMinuteE, new FormData("100%"));
//		
//		lcSchCol1_3.add(lcSchCol1_3_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//        
//        
//		
//		
//		LayoutContainer lcSchCol1_4 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_4.setLayout(frmlytSch);
//		
//		
//		srhDeptCd = new MSFMultiComboBox<ModelData>();
//		srhDeptCd.setName("srhDeptCd");
//		srhDeptCd.setEmptyText("--부서선택--");
//		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
//		srhDeptCd.getStore().add(mDtalistDeptCd);
//		srhDeptCd.setWidth(100);
//		srhDeptCd.setFieldLabel("부서");
//	    srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
//	        public void handleEvent(StoreEvent<ModelData> be) {  
//	        	  EventType type = be.getType();
//		    	   if (type == Store.Add) { 
//	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	           		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//	           		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	           		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//		        		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    		   	checkHistP030002Auth("srhDeptCd", lsDeptCd); 
//	           	 	}
//	        	}
//	    	});    
//	    srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	    @Override
//	    	public void handleEvent(ComponentEvent ce) {   
//	    		if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//                	mutilCombo = true;
//	    		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	    			mutilCombo = true;
//	    		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	    			mutilCombo = false;
//	    		}  
//          	} 
//	    }); 
//	    lcSchCol1_4.add(srhDeptCd, new FormData("100%"));
//		
//		
//		
//        
//        lcSchCol1.add(lcSchCol1_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));			// 조회 구분
//        lcSchCol1.add(lcSchCol1_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));			// 기간
//        lcSchCol1.add(lcSchCol1_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));			// 시간
//        lcSchCol1.add(lcSchCol1_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));			// 부서
//		
//        
//        LayoutContainer lcSchCol2 = new LayoutContainer(new ColumnLayout());
//        
//		LayoutContainer lcSchCol2_1 = new LayoutContainer(new ColumnLayout());
//		
//        LayoutContainer lcDeptNm = new LayoutContainer(); 
//        
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(80);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcDeptNm.setLayout(frmlytSch);
//      
//		
//		srhUsrNm = new TextField<String>(); 
//		srhUsrNm.setFieldLabel("성명");
//		srhUsrNm.setMaxLength(20);
//		srhUsrNm.addKeyListener(new KeyListener() {
//	            public void componentKeyUp(ComponentEvent event) {
////	                super.componentKeyUp(event);
//	                srhUsrId.validate();
//	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                	if (MSFSharedUtils.allowNulls(srhUsrNm.getValue()).trim().equals("")) {
//	                		srhUsrId.setValue("");
//	                    }
//	                	fnPopupCommP980(srhUsrNm.getValue());
//	                }
//	            }
//	         });
//		srhUsrNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhUsrNm.getValue()).trim().equals("")) {
//	                	srhUsrId.setValue("");
//	                }if (MSFSharedUtils.paramNull(srhUsrNm.getValue())) {
//	                	srhUsrId.setValue("");
//	                }   
//	            } 
//	      }); 
//		
//		Button btnSrhUsr = new Button("");
//		btnSrhUsr.setIcon(MSFMainApp.ICONS.search());
//		btnSrhUsr.addListener(Events.Select, new Listener<ButtonEvent>() {
//	            public void handleEvent(ButtonEvent e) {
//	            	if (MSFSharedUtils.allowNulls(srhUsrNm.getValue()).trim().equals("")) {
//	            		srhUsrId.setValue("");
//	                }
//	            	fnPopupCommP980(srhUsrNm.getValue());
//	            }
//	        });
//		
//		lcDeptNm.add(srhUsrNm, new FormData("100%"));
//		lcSchCol2_1.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//		lcSchCol2_1.add(btnSrhUsr, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
//		
//        
//        
//		LayoutContainer lcSchCol2_2 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setDefaultWidth(0);
//		lcSchCol2_2.setLayout(frmlytSch);
//		
//		srhUsrId = new TextField<String>();
//		srhUsrId.setName("srhUsrId");
//		srhUsrId.setHideLabel(true);
//		srhUsrId.setReadOnly(true);
//		lcSchCol2_2.add(srhUsrId, new FormData("100%"));
//		
//		
//		
//		
//		LayoutContainer  lcSchCol2_3 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(80); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol2_3.setLayout(frmlytSch);
//		
//		strWindowNm = new TextField<String>(); 
//		strWindowNm.setName("strWindowNm");
//		strWindowNm.setValue(showMessagePlrlt.getWindowNm());
//		strWindowNm.setFieldLabel("화면명");
//		strWindowNm.setReadOnly(true);
//		lcSchCol2_3.add(strWindowNm, new FormData("100%"));
//		
//		
//		
//		LayoutContainer  lcSchCol2_4 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(80); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol2_4.setLayout(frmlytSch);
//		
//		strWindowId = new TextField<String>(); 
//		strWindowId.setValue(showMessagePlrlt.getWindowId());
//		strWindowId.setFieldLabel("화면ID");
//		strWindowId.setReadOnly(true);
//		lcSchCol2_4.add(strWindowId, new FormData("100%"));
//		
//		
//		
//		lcSchCol2.add(lcSchCol2_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	// 성명
//        lcSchCol2.add(lcSchCol2_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));	// 아이디
//        lcSchCol2.add(lcSchCol2_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));	// 화면명
//        lcSchCol2.add(lcSchCol2_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	// 화면ID
//        
//        
//        lcSchRow.add(lcSchCol1, new FormData("100%"));
//        lcSchRow.add(lcSchCol2, new FormData("100%"));
//
//        
//		fieldSet.add(lcSchRow, new FormData("100%"));
//		
//
//		cpSysmP330002.add(fieldSet);		
//		
//		
////		hist0300GridPanel = new MSFGridPanel(hist0300Def, false, false, false, false);
////		hist0300GridPanel.setHeaderVisible(false);  
////		hist0300GridPanel.setBodyBorder(true);
////		hist0300GridPanel.setBorders(true);
//		
//	} 
//    
//	/** 상세정보 **/
//    private void createStandardForm() { 
//    	
//		errOccrrncDtntm = new HiddenField<String>();
//		errOccrrncDtntm.setName("errOccrrncDtntm");
//		cpSysmP330002.add(errOccrrncDtntm);
//
//		errEthdNm = new HiddenField<String>();
//		errEthdNm.setName("errEthdNm");
//		cpSysmP330002.add(errEthdNm);
//
//		errNm = new HiddenField<String>();
//		errNm.setName("errNm");
//		cpSysmP330002.add(errNm);
//
//		errCtnt = new HiddenField<String>();
//		errCtnt.setName("errCtnt");
//		cpSysmP330002.add(errCtnt);
//		
//		
//		FieldSet fieldSet = new FieldSet();
//		fieldSet.setHeadingHtml("상세정보");//.setHeading("상세정보");
//		
//		
//		LayoutContainer lcSchRow = new LayoutContainer();
//		
//		
////		LayoutContainer  lcSchCol1 = new LayoutContainer(new ColumnLayout());
////		
////		LayoutContainer  lcSchCol1_1 = new LayoutContainer();
////		
////		FormLayout frmlytSch = new FormLayout();  
////		frmlytSch.setLabelWidth(80); 
////		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
////		lcSchCol1.setLayout(frmlytSch);
////		
////		strWindowNm = new TextField<String>(); 
////		strWindowNm.setFieldLabel("화면명");
////		strWindowNm.setReadOnly(true);
////		lcSchCol1_1.add(strWindowNm, new FormData("100%"));
////		
////		lcSchCol1.add(lcSchCol1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
////		
////		
////		
////		LayoutContainer  lcSchCol1_2 = new LayoutContainer();
////		
////		frmlytSch = new FormLayout();  
////		frmlytSch.setLabelWidth(80); 
////		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
////		lcSchCol1.setLayout(frmlytSch);
////		
////		strWindowId = new TextField<String>(); 
////		strWindowId.setFieldLabel("화면ID");
////		strWindowId.setReadOnly(true);
////		lcSchCol1_1.add(strWindowId, new FormData("100%"));
////		
////		lcSchCol1.add(lcSchCol1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//		
//		
//		
//		LayoutContainer  lcSchCol2 = new LayoutContainer();
//		
//		FormLayout frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(80); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol2.setLayout(frmlytSch);
//		
//		strErrEthdNm = new TextArea();
//		strErrEthdNm.setName("strErrEthdNm");
//		strErrEthdNm.setReadOnly(true);
//		strErrEthdNm.setFieldLabel("에러메소드명");
//		lcSchCol2.add(strErrEthdNm, new FormData("100%"));
//		
//		
//		LayoutContainer  lcSchCol3 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(80); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol3.setLayout(frmlytSch);
//		
//		strErrNm = new TextArea();
//		strErrNm.setName("strErrNm");
//		strErrNm.setFieldLabel("에러명");
//		strErrNm.setReadOnly(true);
////		strErrEthdNm.setSize(940, 40);
//		
//		lcSchCol3.add(strErrNm, new FormData("100%"));
//		
//		
//		
//		LayoutContainer  lcSchCol4 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(80); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol4.setLayout(frmlytSch);
//		
//		strErrCtnt = new TextArea();
//		strErrCtnt.setName("strErrCtnt");
//		strErrCtnt.setFieldLabel("에러내용");
//		strErrCtnt.setHeight(250);
//		strErrCtnt.setReadOnly(true);
//		
//
//		lcSchCol4.add(strErrCtnt, new FormData("100%"));
//		
//		
//		LayoutContainer  lcSchCol5 = new LayoutContainer(new ColumnLayout());
//		
//		LayoutContainer  lcSchCol5_1 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		lcSchCol5_1.setLayout(frmlytSch);
//		
////		lcSchCol5.add(lcSchCol5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		
//		LayoutContainer  lcSchCol5_2 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(550); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol5_2.setLayout(frmlytSch);
//		
//		dataCnt = new TextField<String>(); 
//		dataCnt.setFieldLabel("건수");
//		dataCnt.setReadOnly(true);
//		lcSchCol5_2.add(dataCnt, new FormData("100%"));
//		
//		
//		lcSchCol5.add(lcSchCol5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
//		
//		LayoutContainer  lcSchCol5_3 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();  
//		frmlytSch.setLabelWidth(10); 
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		lcSchCol5_3.setLayout(frmlytSch);
//		
//		nDataCnt = new TextField<String>(); 
//		nDataCnt.setLabelSeparator("/");
//		nDataCnt.setReadOnly(true);
//		lcSchCol5_3.add(nDataCnt, new FormData("85%"));
//		
//		
//		lcSchCol5.add(lcSchCol5_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
//		
//		
//		
//		LayoutContainer  lcSchCol5_4 = new LayoutContainer();
//		
//		ButtonBar btnBar = new ButtonBar();
//		btnBar.setAlignment(HorizontalAlignment.RIGHT);
//		
//		btnBefore = new Button("◀ ");
//		btnBefore.setWidth(50);
//		btnBefore.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//            	
//            	if(hist0300List.size() <= 0){
//					MessageBox.alert("알림", "조회할 데이터가 존재하지 않습니다.", null);
//        			return;
//				}
//            	
//            	// 이동하고자 하는 게시글의 번호가 0보다 작거나 같을 경우 제일 마지막의 글을 보여줌
//            	if(iData <= 0){
//            		
//            		iData = iCnt+1;
//            	}
//            	
//            	iData = iData- 1 ;
//            	
//            	showHist0300List(hist0300List, iData, iCnt);
//            	
//            }
//        });
//		btnBar.add(btnBefore);
//		
//		btnNext = new Button("▶ ");
//		btnNext.setWidth(50);
//		btnNext.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//            	
//            	if(hist0300List.size() <= 0){
//					MessageBox.alert("알림", "조회할 데이터가 존재하지 않습니다.", null);
//        			return;
//				}
//            	
//            	// 이동하고자 하는 게시글의 번호가 총 게시물의 갯수보다 많으면 첫번째 글을 보여줌
//            	if(iData+1 > iCnt){
//            		
//            		iData = 0;
//            	}
//            	
//            	iData = iData+ + 1;
//            	
//            	showHist0300List(hist0300List, iData, iCnt);
//            }
//        });
//		btnBar.add(btnNext);
//		
//		lcSchCol5_4.add(btnBar);
//		lcSchCol5.add(lcSchCol5_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
//		
//		
//
//		
//		
//		
////		lcSchRow.add(lcSchCol1, new FormData("100%"));	// 화면명, 화면ID
//		lcSchRow.add(lcSchCol2, new FormData("100%"));	// 에러메소드명
//		lcSchRow.add(lcSchCol3, new FormData("100%"));	// 에러명
//		lcSchRow.add(lcSchCol4, new FormData("100%"));	// 에러내용
//		lcSchRow.add(lcSchCol5, new FormData("100%"));	// 건수 및 버튼
//        
//        
//    	fieldSet.add(lcSchRow, new FormData("100%"));
//        
//        cpSysmP330002.add(fieldSet);	
//		
//    }
//    
//			  
//
//	class Tracker {
//		public boolean status = false;
//
//		public boolean getStatus() {
//			return status;
//		}
//
//		public void setStatus(boolean stat) {
//			status = stat;
//		}
//	}
//		   
//	/**
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//	 * 폼 생성시 기본 처리 함수 선언부 종료
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	 **/
//
//	/**
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//	 * 검색 함수 선언부 시작
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	 **/
//	
//	
//	 
//	@Override
//	public void bind(final ModelData model) {
//		formBinding.bind(model);
//		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
//			 @Override
//			public void handleEvent(BaseEvent be) {
//				 
////				 strDeptNm.setValue(deptNm.getValue()); 						// 부서
////				 strHanNm.setValue(usrNm.getValue());							// 성명
////				 strUsrId.setValue(usrId.getValue());							// 아이디
////				 strErrOccrrncDtntm.setValue(errOccrrncDtntm.getValue());		// 에러발생일시
////				 strErrEthdNm.setValue(errEthdNm.getValue());					// 에러 메소드명
////				 strErrNm.setValue(errNm.getValue());							// 에러명
////				 strErrCtnt.setValue(errCtnt.getValue());						// 에러내용
//			}
//		});
//	}
//		       
//	@Override
//	public boolean isValid() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void onSuccessSave() {
//		// TODO Auto-generated method stub
//
//	}
//	
//	
//	public void setListRecord(Iterator<Record> records) {
//	    this.records = records;
//	} 
//	
//	
//	
//	// 항목 보기(리스트, 데이터 번호, 전체데이터갯수)
//	private void showHist0300List(ArrayList<SysIfHist0300DTO> hist0300List, int i, int j) {
//		
//		i = i - 1;
//		
////		System.out.println("333333333");
//		
////		strWindowNm.setValue(hist0300List.get(i).getWindowNm());	// 화면명
////		System.out.println(hist0300List.get(i).getWindowNm());
////		
////		strWindowId.setValue(hist0300List.get(i).getWindowId());	// 화면아이디
////		System.out.println(hist0300List.get(i).getWindowId());
//		
//		strErrEthdNm.setValue(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrEthdNm()));	// 에러메소드명
////		System.out.println(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrEthdNm()));
//		
//		strErrNm.setValue(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrNm()));			// 에러명
////		System.out.println(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrNm()));
//		
//		strErrCtnt.setValue(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrCtnt()));		// 에러내용
////		System.out.println(MSFSharedUtils.allowNulls(hist0300List.get(i).getErrCtnt()));
//		
//		nDataCnt.setValue(String.valueOf(iData));					// 현재 데이터 번호
////		System.out.println(String.valueOf(iData));
//		dataCnt.setValue(String.valueOf(iCnt));						// 전체 데이터 건수
////		System.out.println(String.valueOf(iCnt));
//		
//	}
//	
//	
//	
//	// 조회
//	private void sysmP330002Search(SysIfHist0300DTO sysIfHist0300Dto) {
//		
//		// 데이터 초기화
//		initHist0300Info();	
//		
// 
//		sysmP330002Service.resultListHist0300(sysIfHist0300Dto, new AsyncCallback<List<SysIfHist0300DTO>>(){
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//				caught.printStackTrace();
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
//							, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("resultListHist0300(" + "조회" + ") : " + caught), null);
//				
//			}
//
//			@Override
//			public void onSuccess(List<SysIfHist0300DTO> result) {
//				// TODO Auto-generated method stub
//				
//				iCnt = 0;
//				iData = 0;
//				
//				if(result.size() <= 0){
//					MessageBox.alert("알림", "데이터가 존재하지 않습니다.", null);
//        			return;
//				}
//				
//				hist0300List = new ArrayList<SysIfHist0300DTO>();
//				
//				for(int i = 0; i < result.size(); i++){
//						
//					SysIfHist0300DTO hist0300Dto = new SysIfHist0300DTO();
//						
//					hist0300Dto.setRnum(MSFSharedUtils.allowNulls(result.get(i).getRnum()));
//					hist0300Dto.setDpobCd(MSFSharedUtils.allowNulls(result.get(i).getDpobCd()));    				/** column 사업장코드 : dpobCd */
//					hist0300Dto.setUsrId(MSFSharedUtils.allowNulls(result.get(i).getUsrId()));    					/** column 사용자아이디 : usrId */
//					hist0300Dto.setErrOccrrncDtntm(MSFSharedUtils.allowNulls(result.get(i).getErrOccrrncDtntm())); 	/** column 에러발생일시 : errOccrrncDtntm */
//					hist0300Dto.setErrSeilNum(MSFSharedUtils.convertStringToLong(
//									MSFSharedUtils.defaultNulls(result.get(i).getErrSeilNum(), "0")));    			/** column 에러일련번호 : errSeilNum */
//					hist0300Dto.setErrOccrrncYr(MSFSharedUtils.allowNulls(result.get(i).getErrOccrrncYr()));    	/** column 에러발생년도 : errOccrrncYr */
//					hist0300Dto.setUsrConnectDivCd(MSFSharedUtils.allowNulls(result.get(i).getUsrConnectDivCd()));	/** column 사용자접속구분코드 : usrConnectDivCd */
//					hist0300Dto.setDeptCd(MSFSharedUtils.allowNulls(result.get(i).getDeptCd()));    				/** column 부서코드 : deptCd */
//					hist0300Dto.setUsrDivCd(MSFSharedUtils.allowNulls(result.get(i).getUsrDivCd()));    			/** column 사용자구분코드 : usrDivCd */
//					hist0300Dto.setUsrNm(MSFSharedUtils.allowNulls(result.get(i).getUsrNm()));    					/** column 사용자성명 : usrNm */
//					hist0300Dto.setErrEthdNm(MSFSharedUtils.allowNulls(result.get(i).getErrEthdNm()));    			/** column 에러메소드명 : errEthdNm */
//					hist0300Dto.setErrNm(MSFSharedUtils.allowNulls(result.get(i).getErrNm()));    					/** column 에러명 : errNm */
//					hist0300Dto.setErrCtnt(MSFSharedUtils.allowNulls(result.get(i).getErrCtnt()));    				/** column 에러내용 : errCtnt */
//					hist0300Dto.setWindowNm(MSFSharedUtils.allowNulls(result.get(i).getWindowNm()));    			/** column 화면명 : windowNm */
//					hist0300Dto.setWindowId(MSFSharedUtils.allowNulls(result.get(i).getWindowId()));    			/** column 화면아이디 : windowId */
//					hist0300Dto.setKybdr(result.get(i).getKybdr());    												/** column 입력자 : kybdr */
//					hist0300Dto.setInptDt(result.get(i).getInptDt());    											/** column 입력일자 : inptDt */
//					hist0300Dto.setInptAddr(result.get(i).getInptAddr());    										/** column 입력주소 : inptAddr */
//					hist0300Dto.setIsmt(result.get(i).getIsmt());    												/** column 수정자 : ismt */
//					hist0300Dto.setRevnDt(result.get(i).getRevnDt());    											/** column 수정일자 : revnDt */
//					hist0300Dto.setRevnAddr(result.get(i).getRevnAddr());    										/** column 수정주소 : revnAddr */
//					
//
//					iCnt = iCnt + 1;
//					
////					hist0300List.add(result.get(i));
//					hist0300List.add(hist0300Dto);
//				}
//				
//				iData = 1;
//				showHist0300List(hist0300List, iData, iCnt);
//				
//			}
//			
//		});
//		
//	}
//	
//	
//	//엑셀 저장
//	private void excelFileExport() {
//	                     
//		HashMap<String, String> param = new HashMap<String, String>(); 
//		
//	   
//		param.put("usrConnectDivCd", MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"));			// 화면구분	
//		
//		param.put("errOccrrncDtntmS", ( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 			// 에러발생시간
//					+ MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") 
//					+ MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd")));				
//		
//		param.put("errOccrrncDtntmE", ( MSFSharedUtils.getConvertDateToString(srhDay, "yyyyMMdd") 			// 에러발생시간
//					+ MSFSharedUtils.getSelectedComboValue(srhHourE,"commCd") 
//				+ MSFSharedUtils.getSelectedComboValue(srhMinuteE,"commCd")));		
//		
//		param.put("deptCd", MSFSharedUtils.getStrValToBMMultiCombo(
//					lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));								// 부서
//	                     
//		
//		param.put("usrId", MSFSharedUtils.allowNulls(srhUsrId.getValue()));									// 아이디
//		param.put("windowId", MSFSharedUtils.allowNulls(strWindowId.getValue()));							// 화면아이디
//		param.put("windowNm", MSFSharedUtils.allowNulls(strWindowNm.getValue()));							// 화면명
//		
//	                     
////		hist0300GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileSysmP330002Export.do","extgwtFrame" ,param);
//		GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsFileSysmP330002Export.do","extgwtFrame", JsUtil.toJavaScriptObject(param)); 
//	
//	}
//	
//	
//	private void initHist0300Info() {
//		
////		strWindowNm.setValue("");	// 화면명
////		strWindowId.setValue("");	// 화면아이디
//		
//		strErrEthdNm.setValue("");	// 에러메소드명
//		strErrNm.setValue("");		// 에러명
//		strErrCtnt.setValue("");	// 에러내용	
//		
//		dataCnt.setValue("");		// 데이터건수
//		nDataCnt.setValue("");		// 현재데이터번호
//		
//	}
//	
//	/**
//     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 시작
//     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//     */  
//	
//		
//	 
//	/**
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//	 * 팝업화면 시작
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	 **/
//    //담당자, 분임지출관
//    private void fnPopupCommP980(String usrNm) {
//        MSFFormPanel popCom0980 = SysIfComPopupUtils.lovPopUpMsfSysComP0980Form(usrNm);  
//        
//        final FormBinding popBindingCom0980 = popCom0980.getFormBinding();
//        popBindingCom0980.addListener(Events.Change, new Listener<BaseEvent>() {
//        public void handleEvent(BaseEvent be) {
//            BaseModel mapModel = (BaseModel)be.getSource();
//            
//            	if (!"".equals(mapModel.get("usrId"))) {
//            	
//            		srhUsrNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrNm")));
//            		srhUsrId.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrId")));
//            		
//				}
//			}
//		});
//	}
//	/**
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//	 * 팝업화면 종료
//	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	 **/	
}
